import kotlinx.coroutines.*

fun main(): Unit = runBlocking {

    val doPing = async { ping() }
    val doPong = async { pong() }


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

suspend fun ping(): String {
    delay(1000)
    return "Ping"
}

suspend fun pong(): String {
    delay(1000)
    return "Pong"
}