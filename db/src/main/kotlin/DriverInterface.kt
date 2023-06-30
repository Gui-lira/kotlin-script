import java.sql.Connection
import java.sql.DriverManager

class DriverInterface {
    companion object {
        const val url = "jdbc:postgresql://localhost:5432/postgres"
        const val user = "postgres"
        const val password = "1234"
    }

    fun getConnection(): Connection? = DriverManager.getConnection(url, user, password)
}