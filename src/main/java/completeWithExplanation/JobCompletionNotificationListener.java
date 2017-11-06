package completeWithExplanation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// job 做完後 再從 DB 中撈出資料 印出
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<DataPracticeVO> results = jdbcTemplate.query("SELECT * FROM MF_PROFIT_NOTIFY_DETAIL",
					new RowMapper<DataPracticeVO>() {
						public DataPracticeVO mapRow(ResultSet rs, int row) throws SQLException {
							//getString 數量必須與 POJO & 讀取資料相同
							return new DataPracticeVO(rs.getString(1), rs.getString(2), rs.getString(3),
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
									rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
									rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
									rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24),
									rs.getString(25), rs.getString(26), rs.getString(27));
							// rs.getString(28), rs.getDate(29), rs.getString(30), rs.getDate(31)
						}
					});

			for (DataPracticeVO data : results) {
				log.info("Found <" + data.toString() + "> in the database.");
			}

		}
	}

}
