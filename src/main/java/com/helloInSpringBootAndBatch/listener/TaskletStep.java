package com.helloInSpringBootAndBatch.listener;
//package com.helloInSpringBootAndBatch.config;
//
//import java.io.File;
//
//import org.springframework.batch.core.ExitStatus;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TaskletStep implements Tasklet{
//	private StepExecution stepExecution;
//	@Override
//	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//		
//		chunkContext.getStepContext().getStepExecution().setReadCount(DataItemProcessor.count);
//
////		chunkContext.getStepContext().getStepExecution().setRollbackCount(4);
//		
//		int total = chunkContext.getStepContext().getStepExecution().getReadCount();
//		
//		if(total != 4) {
//			contribution.setExitStatus(ExitStatus.COMPLETED);
//		}else {
//			contribution.setExitStatus(ExitStatus.STOPPED);
//		}
//		
//		
//		
//		int aaa = chunkContext.getStepContext().getStepExecution().getReadCount();
//		System.out.println("aaa :" +aaa);
//		
//		return RepeatStatus.FINISHED;
//		
//	}
//}
