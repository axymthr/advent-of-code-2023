import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * https://blog.jetbrains.com/kotlin/2021/12/tips-and-tricks-for-solving-advent-of-code/
 *
 * Parses input lines.
 * Use the destructured function to assign the output to different variables right away
 * Library functions like substringBefore() and substringAfter() cover lots of cases and are often enough.
 * Use String.toInt() and Char.digitToInt() to convert the string content or characters into integers.
 */
fun parseInput(s: String) {
    val inputLineRegex = """(\d+),(\d+) -> (\d+),(\d+)""".toRegex()
    val (startX, startY, endX, endY) = inputLineRegex
        .matchEntire(s)
        ?.destructured
        ?: throw IllegalArgumentException("Incorrect input line $s")
}

/**
 * It’s often helpful to introduce domain types, even for smaller tasks like these puzzles.
 * data class Step(val direction: Direction, val units: Int)
 * fun String.toStep(): Step
 * fun String.toTicket(): Ticket
 * fun String.toSevenSegmentDigitList(): List<SevenSegmentDigit>
 * val steps = readInput(fileName).map(String::toStep)
 *
 * Enumerations instead of strings
 * enum class Direction { UP, DOWN, FORWARD }
 * data class Step(val direction: Direction, val units: Int)
 *
 * // "forward 8"
 * fun String.toStep() = Step(
 *    Direction.valueOf(substringBefore(" ").uppercase()),
 *    substringAfter(" ").toInt()
 * )
 *
 * for ((direction, units) in steps) {
 *    when (direction) {
 *        UP -> depth -= units
 *        DOWN -> depth += units
 *        FORWARD -> horizontalPosition += units
 *    }
 * }
 *
 * typealias Segment = Char
 * data class SevenSegmentDigit(val segments: Set<Segment>) {
 *    constructor(s: String): this(s.toSet())
 *    override fun toString() = segments.toList().sorted().joinToString("")
 * }
 *
 * Use buildList and buildMap functions to build data structures imperatively:
 * val monsters: List<Position> = buildList {
 *    for (y in 0..tile.size - Monster.height) {
 *        for (x in 0..tile.size - Monster.width) {
 *            if (monsterAt(tileRotation, x, y)) {
 *                add(Position(x, y))
 *            }
 *        }
 *    }
 * }
 *
 * val occurrences: Map<Int, List<Segment>> =
 *    segments.groupBy { countSegmentInAllDigits(it) }
 * // {8=[a, b], 9=[c], 7=[d, g], 4=[e], 6=[f]}
 *
 * listOf("abc", "c", "ad", "bc", "ab", "ca")
 *    .groupingBy(String::first)
 *    .eachCount() // {a=3, e=2, d=1}
 *
 * val rulesMap: Map<Int, Rule> = rules.associateBy { it.index }
 *
 * val initialState: Map<Int, Node> = numbers.associateWith { Node(it) }
 *
 * val bagRuleMap: Map<Bag, List<Content>> = bagRules.associate { it.bag to it.contentList }
 *
 * numbers.windowed(2).count { (first, second) -> first < second }
 * "abcde".windowed(2) // [ab, bc, cd, de]
 *
 * sumOf maxOf minOf
 *
 * fun RoundConfiguration.calculateScore(): Long {
 *    val winner = listOf(playerA, playerB).maxByOrNull { it.size }!!
 *    return winner
 *        .cards()
 *        .foldIndexed(0L) { index, acc, element ->
 *            acc + (winner.size - index) * element
 *        }
 * }
 *
 * private fun checkRow(row: List<Int>, visited: Set<Int>) =
 *    row.all { elem -> elem in visited }
 *        .also { result -> log("Checking row $row $visited: $result") }
 *
 * val differences = input
 *    .windowed(2)
 *    .also(::log)
 *    .map { (first, second) -> second - first }
 *    .also(::log)
 *    .sorted()
 * make a habit of using your own small log function instead. This way, you only need to change it in one place to stop
 * printing all of the intermediate values for your solution.
 *
 * Need a queue or a stack to implement an algorithm when solving the puzzle? Use ArrayDeque, a double-ended queue that
 * provides quick access to both ends.
 * fun dfs(board: Board, initial: Cell): Set<Cell> {
 *    val visited = mutableSetOf<Cell>()
 *    val queue = ArrayDeque<Cell>()
 *    queue += initial
 *    while (queue.isNotEmpty()) {
 *        val cell = queue.removeFirst()
 *        visited += cell
 *        queue += board.getUpperNeighbors(cell)
 *    }
 *    return visited
 * }
 *
 * Consider overloading get and set operators to simplify the code for working with your class.
 * dataclass Board(val content: List<List<Int>>) {
 *    operator fun get(cell: Cell) =
 *        content.getOrNull(cell.i)?.getOrNull(cell.j)
 * }
 * Instead of writing board.content[cell.i][cell.j] for all invocations, you write board[cell]
 * data class Line(val start: Point, val end: Point) {
 *    operator fun contains(point: Point): Boolean { … }
 * }
 * inputLines.count { line -> point in line }
 *
 *
 *
 */
