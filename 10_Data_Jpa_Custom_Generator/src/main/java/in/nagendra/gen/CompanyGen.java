package in.nagendra.gen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyGen implements IdentifierGenerator {

    @Autowired
    private DataSource dataSource; // DataSource provided by Spring Boot

    @Override
    public synchronized Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "COM";
        int nextVal = 0;

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {

            // Fetch the current value from the sequence
            ResultSet rs = stmt.executeQuery("SELECT next_val FROM company_seq FOR UPDATE");
            if (rs.next()) {
                nextVal = rs.getInt(1);
            }

            // Update the sequence to the next value
            stmt.executeUpdate("UPDATE company_seq SET next_val = next_val + 1");
        } catch (SQLException e) {
            throw new RuntimeException("Error generating custom ID", e);
        }

        // Return the generated ID with the prefix
        return prefix + nextVal;
    }
}
