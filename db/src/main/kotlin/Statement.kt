import java.time.Instant
import java.util.*

data class Statement(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val amount: Long,
    val billingKey: String? = null,
    val type: String = "CREDIT",
    val operation: String = "CREDIT",
    val createdAt: Instant = Instant.now(),
    val relatedItemTransactionIds: List<UUID> = emptyList(),
    val walletId: UUID = UUID.randomUUID(),
    val transactionId: UUID = UUID.randomUUID()
)
