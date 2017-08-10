package uk.co.bbc.kotlingameoflife

data class Cell(val x: Int, val y: Int) {

    fun getNeighbours() :Set<Cell> {
        return setOf(Cell(x - 1, y),
                Cell(x, y - 1),
                Cell(x + 1, y),
                Cell(x, y + 1),
                Cell(x - 1, y - 1),
                Cell(x + 1, y + 1),
                Cell(x - 1, y + 1),
                Cell(x + 1, y - 1))
    }
}