import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    launch { doPing(5) }
    launch { doPong(5) }
}

suspend fun doPing(repeats: Int) {
    for (i in 0..repeats) {
        delay(2000L)
        println("Ping")
    }
}

suspend fun doPong(repeats: Int) {
    for (i in 0..repeats) {
        delay(2001L)
        println("Pong")
    }
}