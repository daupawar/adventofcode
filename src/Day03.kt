fun main() {

    fun part1(input: List<String>): Int {
        val columns = input[0].indices
        val gammaRate = StringBuilder()
        val epsilonRate = StringBuilder()
        for (column in columns) {
            val (zeros, ones) = input.findMostFrequent(column)
            if (zeros > ones) {
                gammaRate.append("0")
                epsilonRate.append("1")
            } else {
                gammaRate.append("1")
                epsilonRate.append("0")
            }
        }

        val gamma = gammaRate.toString().toInt(2)
        val epsilon = epsilonRate.toString().toInt(2)

        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        fun rating(type: RatingType): String {
            val columns = input[0].indices
            var candidates = input
            for (column in columns) {
                val (zeroes, ones) = candidates.findMostFrequent(column)
                val mostCommon = if (zeroes > ones) '0' else '1'
                candidates = candidates.filter {
                    when (type) {
                        RatingType.OXYGEN -> it[column] == mostCommon
                        RatingType.CO2 -> it[column] != mostCommon
                    }
                }
                if (candidates.size == 1) break
            }
            return candidates.single()
        }
        return rating(RatingType.OXYGEN).toInt(2) * rating(RatingType.CO2).toInt(2)
    }


    val input = readInput("Day03_input")
    println(part1(input))
    println(part2(input))
}

fun List<String>.findMostFrequent(column: Int): BitCount {
    var zeros = 0
    var ones = 0
    for (line in this) {
        if (line[column] == '0') {
            zeros++
        } else {
            ones++
        }
    }
    return BitCount(zeros = zeros, ones = ones)
}


data class BitCount(val zeros: Int, val ones: Int)

private enum class RatingType {
    OXYGEN,
    CO2
}