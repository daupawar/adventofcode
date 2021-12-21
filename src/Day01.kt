fun main() {

    val input = readInput("Day01")
    var last = 0
    var counter = 0

    input.forEachIndexed { index, s ->
        if (s.toInt() > last && index != 0) {
            counter++
        }
        last = s.toInt()
    }
    println(counter)
}
