package completeWithExplanation;

import java.io.Serializable;

//此例中的預設建構式必須設定 不然會出現 parse 類錯誤
public class DataPracticeVO implements Serializable {

	private String id;
	private String prodId;
	private String prodSeq;
	private String fundName;
	private String fundType;
	private String fundTypeName;
	private String curr;
	private String currName;
	private String buyDate;
	private String amt;
	private String unit;
	private String refNav;
	private String refNavDate;
	private String refRate;
	private String refAmt;
	private String refIncomeAmt;
	private String refIncomeRate;
	private String cashNetReturn;
	private String cashReturnRate;
	private String profitPoint;
	private String lossPoint;
	private String vSw;
	private String invCode;
	private String failCnt;
	private String kind;
	private String riskAttrib;
	private String dataDate;
//	private String creator;
//	private String create_time;
//	private String update_src;
//	private String update_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdSeq() {
		return prodSeq;
	}
	public void setProdSeq(String prodSeq) {
		this.prodSeq = prodSeq;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public String getFundTypeName() {
		return fundTypeName;
	}
	public void setFundTypeName(String fundTypeName) {
		this.fundTypeName = fundTypeName;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public String getCurrName() {
		return currName;
	}
	public void setCurrName(String currName) {
		this.currName = currName;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRefNav() {
		return refNav;
	}
	public void setRefNav(String refNav) {
		this.refNav = refNav;
	}
	public String getRefNavDate() {
		return refNavDate;
	}
	public void setRefNavDate(String refNavDate) {
		this.refNavDate = refNavDate;
	}
	public String getRefRate() {
		return refRate;
	}
	public void setRefRate(String refRate) {
		this.refRate = refRate;
	}
	public String getRefAmt() {
		return refAmt;
	}
	public void setRefAmt(String refAmt) {
		this.refAmt = refAmt;
	}
	public String getRefIncomeAmt() {
		return refIncomeAmt;
	}
	public void setRefIncomeAmt(String refIncomeAmt) {
		this.refIncomeAmt = refIncomeAmt;
	}
	public String getRefIncomeRate() {
		return refIncomeRate;
	}
	public void setRefIncomeRate(String refIncomeRate) {
		this.refIncomeRate = refIncomeRate;
	}
	public String getCashNetReturn() {
		return cashNetReturn;
	}
	public void setCashNetReturn(String cashNetReturn) {
		this.cashNetReturn = cashNetReturn;
	}
	public String getCashReturnRate() {
		return cashReturnRate;
	}
	public void setCashReturnRate(String cashReturnRate) {
		this.cashReturnRate = cashReturnRate;
	}
	public String getProfitPoint() {
		return profitPoint;
	}
	public void setProfitPoint(String profitPoint) {
		this.profitPoint = profitPoint;
	}
	public String getLossPoint() {
		return lossPoint;
	}
	public void setLossPoint(String lossPoint) {
		this.lossPoint = lossPoint;
	}
	public String getvSw() {
		return vSw;
	}
	public void setvSw(String vSw) {
		this.vSw = vSw;
	}
	public String getInvCode() {
		return invCode;
	}
	public void setInvCode(String invCode) {
		this.invCode = invCode;
	}
	public String getFailCnt() {
		return failCnt;
	}
	public void setFailCnt(String failCnt) {
		this.failCnt = failCnt;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getRiskAttrib() {
		return riskAttrib;
	}
	public void setRiskAttrib(String riskAttrib) {
		this.riskAttrib = riskAttrib;
	}
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
	public DataPracticeVO() {
		
	}
	public DataPracticeVO(String id, String prodId, String prodSeq, String fundName, String fundType,
			String fundTypeName, String curr, String currName, String buyDate, String amt, String unit, String refNav,
			String refNavDate, String refRate, String refAmt, String refIncomeAmt, String refIncomeRate,
			String cashNetReturn, String cashReturnRate, String profitPoint, String lossPoint, String vSw,
			String invCode, String failCnt, String kind, String riskAttrib, String dataDate) {
		super();
		this.id = id;
		this.prodId = prodId;
		this.prodSeq = prodSeq;
		this.fundName = fundName;
		this.fundType = fundType;
		this.fundTypeName = fundTypeName;
		this.curr = curr;
		this.currName = currName;
		this.buyDate = buyDate;
		this.amt = amt;
		this.unit = unit;
		this.refNav = refNav;
		this.refNavDate = refNavDate;
		this.refRate = refRate;
		this.refAmt = refAmt;
		this.refIncomeAmt = refIncomeAmt;
		this.refIncomeRate = refIncomeRate;
		this.cashNetReturn = cashNetReturn;
		this.cashReturnRate = cashReturnRate;
		this.profitPoint = profitPoint;
		this.lossPoint = lossPoint;
		this.vSw = vSw;
		this.invCode = invCode;
		this.failCnt = failCnt;
		this.kind = kind;
		this.riskAttrib = riskAttrib;
		this.dataDate = dataDate;
	}
	@Override
	public String toString() {
		return "DataPracticeVO [id=" + id + ", prodId=" + prodId + ", prodSeq=" + prodSeq + ", fundName=" + fundName
				+ ", fundType=" + fundType + ", fundTypeName=" + fundTypeName + ", curr=" + curr + ", currName="
				+ currName + ", buyDate=" + buyDate + ", amt=" + amt + ", unit=" + unit + ", refNav=" + refNav
				+ ", refNavDate=" + refNavDate + ", refRate=" + refRate + ", refAmt=" + refAmt + ", refIncomeAmt="
				+ refIncomeAmt + ", refIncomeRate=" + refIncomeRate + ", cashNetReturn=" + cashNetReturn
				+ ", cashReturnRate=" + cashReturnRate + ", profitPoint=" + profitPoint + ", lossPoint=" + lossPoint
				+ ", vSw=" + vSw + ", invCode=" + invCode + ", failCnt=" + failCnt + ", kind=" + kind + ", riskAttrib="
				+ riskAttrib + ", dataDate=" + dataDate + "]";
	}
	
	
	
	
	
	
	
	


}
