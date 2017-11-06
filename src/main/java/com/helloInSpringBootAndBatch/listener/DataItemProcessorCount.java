package com.helloInSpringBootAndBatch.listener;
//package com.helloInSpringBootAndBatch.config;
//
//import java.io.IOException;
//
//import org.springframework.batch.core.ExitStatus;
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.item.ItemProcessor;
//
//public class DataItemProcessorCount implements ItemProcessor<DataPracticeVO, DataPracticeVO> {
//
//	ToolMethods toolMethods = new ToolMethods();
//	
//	
//	public ExitStatus afterStep(StepExecution sStepExecution) throws IOException {
//	    if (sStepExecution.getReadCount() == toolMethods.getFileTotalRecord()) {
//	        return new ExitStatus("COMPLETED");
//	    }else {
//	    	return new ExitStatus("FAILED");
//	    }
//	}
//
//	@Override
//	public DataPracticeVO process(DataPracticeVO item) throws Exception {
//		// TODO Auto-generated method stub
//		return item;
//	}
//
//
//}
