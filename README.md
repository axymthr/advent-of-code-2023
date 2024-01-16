# advent-of-code-2023

Welcome to the Advent of Code[^aoc] Kotlin project created by [axymthr][github] using the [Advent of Code Kotlin Template][template] delivered by JetBrains.

In this repository, axymthr is about to provide solutions for the puzzles using [Kotlin][kotlin] language.
```
.
├── README.md               README file
├── build.gradle.kts        Gradle configuration created with Kotlin DSL
├── settings.gradle.kts     Gradle project settings
├── gradle*                 Gradle wrapper files
└── src
├── Day01.kt            An empty implementation for the first AoC day
├── Utils.kt            A set of utility methods shared across your days
│                       
│                       (create those files manually)
├── Day01.txt           An empty file for the Day 01 input data
└── Day01_test.txt      An optional Day 01 test input data used for checks
```
> [!NOTE]
>
> All task input files (`src/*.txt`) are excluded from the repository with `.gitignore` – we should not post them publicly, as [Eric Wastl requested for](https://twitter.com/ericwastl/status/1465805354214830081).

When the first puzzle appears, go to the `Day01.kt`, and for each `part1` and `part2` function, provide an algorithm implementation using the `input` data loaded from the `src/Day01.txt` file.
This input data is common for both parts, and you can find it at the bottom of each day on the [Advent of Code][aoc] page.

To read the input data, you can go with the `readInput(name: String)` utility method provided in the [`Utils.kt`][file:utils] file, like:

```kotlin
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    println(part1(input))
}
```

## Running

> [!IMPORTANT]
>
> Create relevant files Before running tasks or tests, like: `src/Day01.txt` or `src/Day01_test.txt`.

The [`Utils.kt`][file:utils] file also contains the `String.md5()` method for generating MD5 hash out of the given string and expects more helper functions for the sake of the [KISS principle][kiss].

Each puzzle describes some test conditions, a small portion of the information that helps check if the produced value for the given test input is valid.
To handle that case, you can put such an input into a separate file and perform a check against the output, like:

```kotlin
fun main() {
    // ...
    
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 13)
}
```

The current approach of providing both `part1` and `part2` solutions within the single `Day##.kt` file may sometimes bring a disadvantage due to the first solution calculation when we expect to work on the second part only.
With simple cases that don't consume too much of your time and resources that can be almost unnoticeable, but when the solution takes seconds, it is worth considering breaking the daily solution into two separated pieces, like `Day07_part1.kt` and `Day07_part2.kt`.

The final result of your algorithm will be printed on the screen so that you can pass it to the Advent of Code website.

To go with the next day, place the `Day02.txt` file into the `src` with relevant input data and create a `Day02.kt` file with a similar code scaffold:

```kotlin
fun main() {
    fun part1(input: List<String>): Int {
        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
```

If you're stuck with Kotlin-specific questions or anything related to this template, check out the following resources:

- [Kotlin docs][docs]
- [Kotlin Slack][slack]
- Template [issue tracker][issues]


[^aoc]:
    [Advent of Code][aoc] – An annual event of Christmas-oriented programming challenges started December 2015.
    Every year since then, beginning on the first day of December, a programming puzzle is published every day for twenty-five days.
    You can solve the puzzle and provide an answer using the language of your choice.

[aoc]: https://adventofcode.com
[docs]: https://kotlinlang.org/docs/home.html
[github]: https://github.com/axymthr
[issues]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template/issues
[kotlin]: https://kotlinlang.org
[slack]: https://surveys.jetbrains.com/s3/kotlin-slack-sign-up
[template]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template
