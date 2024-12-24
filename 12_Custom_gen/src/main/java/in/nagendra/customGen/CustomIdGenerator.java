package in.nagendra.customGen;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

    private static javax.sql.DataSource dataSource;

    public static void setDataSource(javax.sql.DataSource dataSource) {
        CustomIdGenerator.dataSource = dataSource;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "TCS";
        String suffix = "";

        try (Connection con = dataSource.getConnection();
             Statement stmt = con.createStatement()) {

            stmt.execute("CALL get_next_user_id(@next_value)");

            ResultSet rs = stmt.executeQuery("SELECT @next_value");
            if (rs.next()) {
                suffix = String.valueOf(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prefix + suffix;
    }
}
