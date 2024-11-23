import kotlin.math.abs
class Triangle(val a: Point, val b: Point, val c: Point) {
    fun contains(point: Point): Boolean {
        val area = area(a, b, c)
        val area1 = area(point, b, c)
        val area2 = area(a, point, c)
        val area3 = area(a, b, point)
        println("Задача 12")
        return abs(area - (area1 + area2 + area3)) < 1e-9
    }


    private fun area(p1: Point, p2: Point, p3: Point): Double {
        println("Задача 13")
        return 0.5 * abs(p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y))

    }
}