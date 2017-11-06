package complete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidTaskletStep implements Tasklet {
	
	private static final Logger log = LoggerFactory.getLogger(ValidTaskletStep.class);
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		FileReader fr = new FileReader("src/main/resource/IMS_W36001F_20171023.D");
		BufferedReader br = new BufferedReader(fr);
		int fileTotalRecords  = ToolMethods.getFileTotalRecord();
		int readFileRecords  = 0; 
		while (br.ready()) {
			String strTmp = br.readLine();
			readFileRecords++;
		}
		br.close();
		fr.close();
		log.info("*readFileRecords : "+ readFileRecords);
		
		if (fileTotalRecords == readFileRecords) {
			log.info("*ExitStatus.EXECUTING ");
			contribution.setExitStatus(ExitStatus.EXECUTING);
        }else {
        	log.info("*ExitStatus.FAILED ");
        	contribution.setExitStatus(ExitStatus.FAILED);
        }
        
		return null;
		
	}

}
