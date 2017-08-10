package uk.co.bbc.kotlingameoflife

import org.junit.Test
import java.util.function.Function
import java.util.stream.Collectors


/*
Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */

class GameOfLifeTests {
    private val DIMEN: Int = 10

    @Test
    fun main() {

        val printer = Printer(DIMEN)

        val generation0 = setOf(Cell(1, 2),
                Cell(1, 3),
                Cell(1, 4),
                Cell(2, 1),
                Cell(2, 2),
                Cell(2, 3))

        printer.printGeneration(generation0)

        generate(generation0, 1, printer)
    }


    private fun generate(generation: Set<Cell>, iteration: Int, printer: Printer) {

        if (iteration < 100) {

            val survivors = generation.filter { it.getNeighbours().filter { generation.contains(it) }.count() in 2..3 }

            val deadCells = generation.flatMap{ it.getNeighbours() }.filter { !generation.contains(it) }

            val newCells = deadCells.filter { it.getNeighbours().filter { generation.contains(it) }.count() == 3 }

            val nextGeneration = survivors.union(newCells)
            printer.printGeneration(nextGeneration)

            generate(nextGeneration, iteration + 1, printer)
        }
    }
}