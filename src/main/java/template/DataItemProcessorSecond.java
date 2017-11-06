package template;
//package com.helloInSpringBootAndBatch.config;
//
//import java.util.List;
//
//import org.springframework.batch.item.ItemProcessor;
//
//public class DataItemProcessorSecond implements ItemProcessor<List<DataPracticeVO>, DataPracticeVO>{
//
//	@Override
//	public DataPracticeVO process(List<DataPracticeVO> item) throws Exception {
//
//		int fileTotalRecords = ToolMethods.getFileTotalRecord();
//		int fileDate = ToolMethods.getFileDate();
//		int readFileDate = 0;
//		for (DataPracticeVO dataPracticeVO2 : item) {
//			readFileDate = Integer.valueOf(dataPracticeVO2.getBuyDate().trim());
//			int readFileRecords = item.size();
//			
//			
////			if(fileTotalRecords == readFileRecords) {
//				if (readFileDate == fileDate) {
//					DataPracticeVO resultVO = transform(dataPracticeVO2);
//					return resultVO;
//				} else {
//					return null;
//				}
////			}else {
////				return null;
////			}
//			
//			
//			
//		}
//		return null;
//		
//	}
//
//	DataPracticeVO transform(DataPracticeVO dataPracticeVO) {
//
//		String id = dataPracticeVO.getId().trim();
//		String prodId = dataPracticeVO.getProdId().trim();
//		String prodSeq = dataPracticeVO.getProdSeq().trim();
//		String fundName = dataPracticeVO.getFundName().trim();
//		String fundType = dataPracticeVO.getFundType().trim();
//		String fundTypeName = dataPracticeVO.getFundTypeName().trim();
//		String curr = dataPracticeVO.getCurr().trim();
//		String currName = dataPracticeVO.getCurrName().trim();
//		String buyDate = dataPracticeVO.getBuyDate().trim();
//		String amt = dataPracticeVO.getAmt().trim();
//		String unit = dataPracticeVO.getUnit().trim();
//		String refNav = dataPracticeVO.getRefNav().trim();
//		String refNavDate = dataPracticeVO.getRefNavDate().trim();
//		String refRate = dataPracticeVO.getRefRate().trim();
//		String refAmt = dataPracticeVO.getRefAmt().trim();
//		String refIncomeAmt = dataPracticeVO.getRefIncomeAmt().trim();
//		String refIncomeRate = dataPracticeVO.getRefIncomeRate().trim();
//		String cashNetReturn = dataPracticeVO.getCashNetReturn().trim();
//		String cashReturnRate = dataPracticeVO.getCashReturnRate().trim();
//		String profitPoint = dataPracticeVO.getProfitPoint().trim();
//		String lossPoint = dataPracticeVO.getLossPoint().trim();
//		String vSw = dataPracticeVO.getvSw().trim();
//		String invCode = dataPracticeVO.getInvCode().trim();
//		String failCnt = dataPracticeVO.getFailCnt().trim();
//		String kind = dataPracticeVO.getKind().trim();
//		String riskAttrib = dataPracticeVO.getRiskAttrib().trim();
//
//		DataPracticeVO dataPracticeObj = new DataPracticeVO(id, prodId, prodSeq, fundName, fundType, fundTypeName, curr,
//				currName, buyDate, amt, unit, refNav, refNavDate, refRate, refAmt, refIncomeAmt, refIncomeRate,
//				cashNetReturn, cashReturnRate, profitPoint, lossPoint, vSw, invCode, failCnt, kind, riskAttrib);
//
//		return dataPracticeObj;
//
//	}
//
//	
//	
//}
