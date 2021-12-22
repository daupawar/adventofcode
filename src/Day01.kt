fun main() {

    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a, b) -> a < b }
    }

    fun part2(input: List<Int>): Int {
        val win3=input.windowed(3)//group every 3
        val win2=win3.windowed(2)// group every 2
        return win2.count { (a, b) -> a.sum() < b.sum() }
    }

//    fun part2(input: List<Int>): Int {
//        val win4 = input.windowed(4)//group every 3
//        return win4.count { it[0] < it[3] }
//    }

    val input = readInputAsInt("Day01")
//    var last = 0
//    var counter = 0
//
//    input.forEachIndexed { index, s ->
//        if (s > last && index != 0) {
//            counter++
//        }
//        last = s
//    }
//    println(counter)
    println(part1(input))
    println(part2(input))
}
