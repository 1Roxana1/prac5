import kotlin.math.*

data class Point(val x: Double, val y: Double) {
    // Метод для вычисления расстояния до другой точки
    fun distanceTo(other: Point): Double {
        return sqrt((other.x - this.x).pow(2) + (other.y - this.y).pow(2))
    }

    // Статический метод для вычисления расстояния между двумя точками
    companion object {
        fun distance(point1: Point, point2: Point): Double {
            return point1.distanceTo(point2)
        }
    }
}
