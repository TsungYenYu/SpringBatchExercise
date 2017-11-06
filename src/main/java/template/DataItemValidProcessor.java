package template;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import complete.DataPracticeVO;
import complete.ToolMethods;

public class DataItemValidProcessor implements ItemProcessor<DataPracticeVO, DataPracticeVO> ,StepExecutionListener  {
	int fileTotalRecords ;
	int readFileRecords ;
	
	
	@Override
	public DataPracticeVO process(DataPracticeVO item) throws Exception {

		FileReader fr = new FileReader("IMS_W36001F_20171023.D");
		BufferedReader br = new BufferedReader(fr);
		fileTotalRecords = ToolMethods.getFileTotalRecord();
		readFileRecords = 0; 
		while (br.ready()) {
			String strTmp = br.readLine();
			readFileRecords++;
		}
		br.close();
		fr.close();
		System.out.println("readFileRecords : "+ readFileRecords);
		
		return null;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println(" afterStep works ");
		if (fileTotalRecords == readFileRecords) {
			System.out.println(" EXECUTING ");
			return ExitStatus.EXECUTING;
			
        }else {
        	System.out.println(" COMPLETED ");
            return ExitStatus.COMPLETED;
        }
		
	}

}
