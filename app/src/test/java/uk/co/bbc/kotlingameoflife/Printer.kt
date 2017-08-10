package uk.co.bbc.kotlingameoflife

import java.util.stream.Collectors

class Printer internal constructor(private val gridDimension: Int) {

    fun printGeneration(newGeneration: Set<Cell>) {
        printGeneration(newGeneration, 0, 0)
    }

    private fun printGeneration(liveCells: Set<Cell>, i: Int, j: Int) {

        val cells = liveCells.stream().filter { cell -> cell.x == i && cell.y == j }.collect(Collectors.toList<Any>())
        if (cells.isEmpty()) {
            print(".\t")
        } else {
            print("O\t")
        }

        if (j < gridDimension) {
            printGeneration(liveCells, i, j + 1)
        } else if (i < gridDimension) {
            print("\n\n")
            printGeneration(liveCells, i + 1, 0)
        } else {
            print("\n\n")
            print("\n\n")
        }
    }
}