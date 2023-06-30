import java.sql.Connection
import java.sql.Timestamp

class Repository(private val connection: Connection? = DriverInterface().getConnection()) {
    companion object {
        const val TABLE_NAME = "statement"
    }

    fun save(statements: List<Statement>) {
//        println(buildQuery(statements.first()))
        val preparedStatements = prepareStatements(statements)
        preparedStatements.forEach { it?.execute() }
        connection?.close()
    }
    private fun prepareStatements(statements: List<Statement>) = statements.map {
        connection?.prepareStatement(buildQuery(it))
    }

    private fun buildQuery(statement: Statement) = """
        INSERT INTO $TABLE_NAME(id, amount, operation, billing_key, type, created_at, description, wallet_id)
            VALUES ('${statement.id}',
             '${statement.amount}',
             '${statement.operation}',
             '${statement.billingKey}',
             '${statement.type}',
             '${Timestamp.from(statement.createdAt)}',
             '${statement.description}',
             '${statement.walletId}')
    """.trimIndent()
}