fun main() {

    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontalPosition = 0
        val movements = input.map { it.split(' ') }
        for ((direction, valueString) in movements) {
            val value = valueString.toInt()
            when (direction) {
                "up" -> depth -= value
                "down" -> depth += value
                "forward" -> horizontalPosition += value
            }
        }
        return depth * horizontalPosition
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontalPosition = 0
        val movements = input.map { it.split(' ') }
        for ((direction, valueString) in movements) {
            val value = valueString.toInt()
            when (direction) {
                "up" -> aim -= value
                "down" -> aim += value
                "forward" -> {
                    horizontalPosition += value
                    depth += aim * value
                }
            }
        }
        return depth * horizontalPosition
    }


    val input = readInput("Day02_input")
    println(part1(input))
    println(part2(input))
}
