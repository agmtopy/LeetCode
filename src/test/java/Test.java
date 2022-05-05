import org.apache.shardingsphere.benchmark.db.shardingjdbc.ShardingConfigType;
import org.apache.shardingsphere.benchmark.db.shardingjdbc.ShardingJDBCDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println(111);
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.specification.version"));
        DataSource dataSource = ShardingJDBCDataSourceFactory.newInstance(ShardingConfigType.FULLROUTING_SHARDING_SHARDINGJDBC_CONFIG);
        System.out.println("dataSource:" + dataSource);
    }
}
