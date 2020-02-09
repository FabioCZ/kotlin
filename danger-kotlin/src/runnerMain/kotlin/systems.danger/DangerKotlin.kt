package systems.danger

import systems.danger.cmd.dangerfile.DangerFile

object DangerKotlin {
    private const val FILE_TMP_OUTPUT_JSON = "danger_out.json"

    fun run(vararg addToClasPath: String?) {
        val dangerDSLPath = readLine()

        dangerDSLPath?.removePrefix("danger://dsl/")?.stripEndLine()?.let {
            with(DangerFile) {
                execute(it, FILE_TMP_OUTPUT_JSON, *addToClasPath)
            }

            printResult()
        }
    }

    private fun printResult() {
        println("danger-results:/$FILE_TMP_OUTPUT_JSON")
    }

    private fun String.stripEndLine() = replace("\u007F", "")

}