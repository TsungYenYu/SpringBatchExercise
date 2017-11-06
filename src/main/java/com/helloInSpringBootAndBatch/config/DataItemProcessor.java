package com.helloInSpringBootAndBatch.config;

import java.io.BufferedReader;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class DataItemProcessor implements ItemProcessor<DataPracticeVO, DataPracticeVO> {

	private static final Logger log = LoggerFactory.getLogger(DataItemProcessor.class);
	
	public JobExecution jobExecution;

	DataPracticeVO resultVO ;
	
	public DataPracticeVO process(DataPracticeVO dataPracticeVO) throws Exception {
		int readFileRecord = DataItemReadListener.count;
		
		int fileTotalRecords = ToolMethods.getFileTotalRecord();
		int fileDate = ToolMethods.getFileDate();
		int readFileDate ;
		if("".equals(dataPracticeVO.getBuyDate().trim())) {
			readFileDate = 0;
		}else {
			readFileDate = Integer.valueOf(dataPracticeVO.getBuyDate().trim());
		}
		
//		DataPracticeVO resultVO ;
		
		if(readFileRecord ==  fileTotalRecords) {
			
			if (readFileDate == fileDate) {
				 resultVO = transform(dataPracticeVO);
				return resultVO;
			} else {
				return null;
			}
			
		}else {
			return null;
		}
		
		
		
		
//		FileReader frH = new FileReader("IMS_W36001F_20171023.H");
//		BufferedReader brH = new BufferedReader(frH);
//		String[] strH = brH.readLine().split("\\|");
//		int compareDateH = Integer.valueOf(strH[0].trim());// H 日期
//		int resultCount = Integer.valueOf(strH[4].trim());// H 筆數
//		int compareDateD = Integer.valueOf(dataPracticeVO.getBuyDate().trim());
//
//		if (compareDateD == compareDateH) {
//			DataPracticeVO resultVO = transform(dataPracticeVO);
//			return resultVO;
//		} else {
//			return null;
//		}

	}

	DataPracticeVO transform(DataPracticeVO dataPracticeVO) {

		String id = dataPracticeVO.getId().trim();
		String prodId = dataPracticeVO.getProdId().trim();
		String prodSeq = dataPracticeVO.getProdSeq().trim();
		String fundName = dataPracticeVO.getFundName().trim();
		String fundType = dataPracticeVO.getFundType().trim();
		String fundTypeName = dataPracticeVO.getFundTypeName().trim();
		String curr = dataPracticeVO.getCurr().trim();
		String currName = dataPracticeVO.getCurrName().trim();
		String buyDate = dataPracticeVO.getBuyDate().trim();
		String amt = dataPracticeVO.getAmt().trim();
		String unit = dataPracticeVO.getUnit().trim();
		String refNav = dataPracticeVO.getRefNav().trim();
		String refNavDate = dataPracticeVO.getRefNavDate().trim();
		String refRate = dataPracticeVO.getRefRate().trim();
		String refAmt = dataPracticeVO.getRefAmt().trim();
		String refIncomeAmt = dataPracticeVO.getRefIncomeAmt().trim();
		String refIncomeRate = dataPracticeVO.getRefIncomeRate().trim();
		String cashNetReturn = dataPracticeVO.getCashNetReturn().trim();
		String cashReturnRate = dataPracticeVO.getCashReturnRate().trim();
		String profitPoint = dataPracticeVO.getProfitPoint().trim();
		String lossPoint = dataPracticeVO.getLossPoint().trim();
		String vSw = dataPracticeVO.getvSw().trim();
		String invCode = dataPracticeVO.getInvCode().trim();
		String failCnt = dataPracticeVO.getFailCnt().trim();
		String kind = dataPracticeVO.getKind().trim();
		String riskAttrib = dataPracticeVO.getRiskAttrib().trim();
		String dataDate = "123";

		DataPracticeVO dataPracticeObj = new DataPracticeVO(id, prodId, prodSeq, fundName, fundType, fundTypeName, curr,
				currName, buyDate, amt, unit, refNav, refNavDate, refRate, refAmt, refIncomeAmt, refIncomeRate,
				cashNetReturn, cashReturnRate, profitPoint, lossPoint, vSw, invCode, failCnt, kind, riskAttrib,dataDate);

		return dataPracticeObj;

	}



}
