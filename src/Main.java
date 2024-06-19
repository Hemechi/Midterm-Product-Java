import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/TestingDB";
        String username = "postgres";
        String password = "helen15121512";

        String sql = "SELECT * FROM Product";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double pricePerUnit = resultSet.getDouble("price_per_unit");
                boolean activeForSell = resultSet.getBoolean("active_for_sell");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price per Unit: " + pricePerUnit);
                System.out.println("Active for Sell: " + activeForSell);
                System.out.println("#".repeat(10));
                System.out.println();
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}