package completeWithExplanation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.item.ItemProcessor;

public class DataItemProcessor implements ItemProcessor<DataPracticeVO, DataPracticeVO> {

	private static final Logger log = LoggerFactory.getLogger(DataItemProcessor.class);

	public JobExecution jobExecution;

	private DataPracticeVO resultVO;

	public DataPracticeVO process(DataPracticeVO dataPracticeVO) throws Exception {
		//取得檔案中的 檔案日期
		int fileDate = ToolMethods.getFileDate();
		int readFileDate;
		//防止空值
		if ("".equals(dataPracticeVO.getBuyDate().trim())) {
			readFileDate = 0;
		} else {
			readFileDate = Integer.valueOf(dataPracticeVO.getBuyDate().trim());
		}
		//比對日期 相同才繼續
		if (readFileDate == fileDate) {
			resultVO = transform(dataPracticeVO);
			return resultVO;
		} else {
			return null;
		}

	}

	//加工物件 
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
				cashNetReturn, cashReturnRate, profitPoint, lossPoint, vSw, invCode, failCnt, kind, riskAttrib,
				dataDate);

		return dataPracticeObj;

	}

}
