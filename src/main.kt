import kotlinx.coroutines.*

fun main(): Unit = runBlocking {

    val doPing = async { Ping() }
    val doPong = async { Pong() }


    launch {

        if (doPing.await() == "Ping") {
            println(doPing.await())
        }
        delay(1500L)
        if (doPong.await() == "Pong" && doPing.isCompleted) {
            println(doPong.await())
        }

    }
}

suspend fun Ping(): String {
    delay(1000)
    return "Ping"
}

suspend fun Pong(): String {
    delay(1000)
    return "Pong"
}