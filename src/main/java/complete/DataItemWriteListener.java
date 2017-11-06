package complete;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

public class DataItemWriteListener implements ItemWriteListener<DataPracticeVO>{

	@Override
	public void beforeWrite(List<? extends DataPracticeVO> items) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterWrite(List<? extends DataPracticeVO> items) {
		System.out.println("Insert "+ items.size() + " records after compare. ");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends DataPracticeVO> items) {
		// TODO Auto-generated method stub
	}

	


	
		
}
