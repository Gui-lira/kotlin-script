class Service {
    companion object {
        const val NUMBER_OF_INSERTS = 1000000
    }

    fun save() {
        val repository = Repository()
        repository.save(buildStatementList())
    }

    private fun buildStatementList() =
        generateSequence { buildStatement() }
            .take(NUMBER_OF_INSERTS)
            .toList()

    private fun buildStatement() = Statement(
        description = "mass insert",
        amount = 100
    )
}