package completeWithExplanation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		FileReader fr = new FileReader("src/main/resource/IMS_W36001F_20171023.D");
		BufferedReader br = new BufferedReader(fr);
		int fileTotalRecords  = ToolMethods.getFileTotalRecord();
		int readFileRecords  = 0; 
		//繞迴圈 取得檔案中的筆數
		while (br.ready()) {
			String strTmp = br.readLine();
			readFileRecords++;
		}
		br.close();
		fr.close();
		System.out.println("readFileRecords : "+ readFileRecords);
		
		//筆數相同才繼續 設定 ExitStatus 告知 batch 如何動作
		if (fileTotalRecords == readFileRecords) {
			System.out.println(" ExitStatus.EXECUTING ");
			contribution.setExitStatus(ExitStatus.EXECUTING);
        }else {
        	System.out.println(" ExitStatus.FAILED  ");
        	contribution.setExitStatus(ExitStatus.FAILED);
        }
        
		return null;
		
	}

}
