import systems.danger.DangerKotlin
import systems.danger.cmd.dangerjs.DangerJS

const val PROCESS_DANGER_KOTLIN = "danger-kotlin"
const val VERSION = "0.3.1"

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        when (val command = args.first()) {
            "ci", "local", "pr" -> {
                DangerJS.process(command ,PROCESS_DANGER_KOTLIN, args.drop(1))
            }
            "--version" -> println(VERSION)
            else -> return
        }
    } else {
        DangerKotlin.run()
    }
}