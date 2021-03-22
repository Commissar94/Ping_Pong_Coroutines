import kotlinx.coroutines.*

fun main(): Unit = runBlocking {

    val doPing = launch {doPing()}
    val doPong = launch {doPong()}
    delay(1000L)
    for (i in 1..10000) {
        if (doPing.isCompleted) {
            launch {doPong()}
        }
        delay(500L)
        if (doPong.isCompleted) {
            launch {doPing()}
        }
    }
}

suspend fun doPing() {
    println("Ping")
    delay(1000L)
}

suspend fun doPong() {
    println("Pong")
    delay(1000L)
}