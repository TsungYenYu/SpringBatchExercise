package complete;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.AfterWrite;

public class DataItemWriteListener {

	private static final Logger log = LoggerFactory.getLogger(DataItemWriteListener.class);
	
	@AfterWrite
	public void afterWrite(List<? extends DataPracticeVO> items) {
		log.info("*Insert "+ items.size() + " records after compare. ");
	}
}
