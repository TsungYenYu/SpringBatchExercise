package complete;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

public class DataItemWriteListener implements ItemWriteListener<DataPracticeVO>{

	private static final Logger log = LoggerFactory.getLogger(DataItemWriteListener.class);
	
	@Override
	public void beforeWrite(List<? extends DataPracticeVO> items) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterWrite(List<? extends DataPracticeVO> items) {
		log.info("*Insert "+ items.size() + " records after compare. ");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends DataPracticeVO> items) {
		// TODO Auto-generated method stub
	}

	


	
		
}
