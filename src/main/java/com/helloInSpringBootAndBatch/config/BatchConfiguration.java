package com.helloInSpringBootAndBatch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableBatchProcessing
@PropertySource(value = { "classpath:config.properties" })
public class BatchConfiguration {
	@Autowired
	private Environment environment;
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
    }
    
    @Bean
    public FlatFileItemReader<DataPracticeVO> reader() {
        FlatFileItemReader<DataPracticeVO> reader = new FlatFileItemReader<DataPracticeVO>();
        
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//        tokenizer.setNames(new String[] { "id", "prodId", "prodSeq", "fundName", "fundType", "fundTypeName", "curr", "currName", "buyDate", "amt", "unit", "refNav", "refNavDate", "refRate", "refAmt", "refIncomeAmt", "refIncomeRate", "cashNetReturn", "cashReturnRate", "profitPoint", "lossPoint", "vSw", "invCode", "failCnt", "kind", "riskAttrib" });
//        tokenizer.setDelimiter("|");
        
        reader.setResource(new ClassPathResource("IMS_W36001F_20171023.D"));
        
        
        reader.setLineMapper(new DefaultLineMapper<DataPracticeVO>() {{
            setLineTokenizer(
//            		tokenizer
            		new DelimitedLineTokenizer() {{
                setNames(new String[] { "id", "prodId", "prodSeq", "fundName", "fundType", "fundTypeName", "curr", "currName", "buyDate", "amt", "unit", "refNav", "refNavDate", "refRate", "refAmt", "refIncomeAmt", "refIncomeRate", "cashNetReturn", "cashReturnRate", "profitPoint", "lossPoint", "vSw", "invCode", "failCnt", "kind", "riskAttrib","dataDate" });
                setDelimiter("|");
            }}
            		);
            setFieldSetMapper(new BeanWrapperFieldSetMapper<DataPracticeVO>() {{
                setTargetType(DataPracticeVO.class);

            }});
        }});
        return reader;
    }
    
    @Bean
    public DataItemProcessor processor() {
        return new DataItemProcessor();
    }
    
    @Bean
    public DataItemReadListener processorListener() {
        return new DataItemReadListener();
    }
    @Bean
    public DataItemWriteListener processorListenerWrite() {
    	return new DataItemWriteListener();
    }
    
    
    @Bean
    public JdbcBatchItemWriter<DataPracticeVO> writer()  {
        JdbcBatchItemWriter<DataPracticeVO> writer = new JdbcBatchItemWriter<DataPracticeVO>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<DataPracticeVO>());
        writer.setSql("INSERT INTO MF_PROFIT_NOTIFY_DETAIL (id ,  prod_id ,  prod_seq ,  fund_name ,  fund_type ,  fund_type_name ,  curr ,  curr_name ,  buy_date ,  amt ,  unit ,  ref_nav ,  ref_nav_date ,  ref_rate ,  ref_amt ,  ref_income_amt ,  ref_income_rate ,  cash_net_return ,  cash_return_rate ,  profit_point ,  loss_point ,  v_sw ,  inv_code ,  fail_cnt ,  kind ,  risk_attrib ,data_date )"
        		+ " VALUES (:id, :prodId, :prodSeq, :fundName, :fundType, :fundTypeName,:curr, :currName, :buyDate, :amt, :unit, :refNav, :refNavDate, :refRate, :refAmt, :refIncomeAmt,:refIncomeRate, :cashNetReturn, :cashReturnRate, :profitPoint, :lossPoint, :vSw, :invCode, :failCnt,:kind, :riskAttrib ,:dataDate)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<DataPracticeVO, DataPracticeVO> chunk(22000)
                .reader(reader())
                .listener(processorListener())
                .processor(processor())
                .listener(processorListenerWrite())
                .writer(writer())
                .build();
    }
    


    // end::jobstep[]
}
