import kotlin.math.abs

fun main() {
    println("\nЗадача 1")
    val triangle = readTriangleCoords()

    val point = readPoint("Введите координаты точки (x y): ")

    if (triangle.contains(point)) {
        println("Точка находится внутри треугольника.")
    } else {
        println("Точка находится вне треугольника.")
    }

    println("\nЗадача 2")
    val firstPoint = readPoint("Введите координаты первой точки (x1 y1): ")
    val secondPoint = readPoint("Введите координаты второй точки (x2 y2): ")

    val dist=Point.distance(firstPoint, secondPoint)
    println("Расстояние между точками: $dist")

    println("\nЗадача 3")
    println("Введите количество точек (больше 2):")
    val n = readLine()?.toIntOrNull()
    if (n == null || n <= 2) {
        println("Ошибка: количество точек должно быть больше 2.")
        return
    }

    val points = mutableListOf<Point>()
    for (i in 1..n) {
        val point = readPoint("Введите координаты точки $i (x y):")
        points.add(point)
    }

    val (minDistance, maxDistance) = findMaxDistances(points)
    println("Максимальное расстояние между точками: $maxDistance")
    println("Максимальное расстояние между точками: $minDistance")
}

fun findMaxDistances(points: List<Point>): Pair<Double, Double> {
    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val distance = points[i].distanceTo(points[j])
            if (distance < minDistance) {
                minDistance = distance
            }
            if (distance > maxDistance) {
                maxDistance = distance
            }
        }
    }

    return Pair(minDistance, maxDistance)
}

fun readPoint(prompt: String): Point {
    while (true) {
        print(prompt)
        val input = readLine() ?: continue
        val coords = input.split(" ")
        if (coords.size == 2) {
            try {
                val x = coords[0].toDouble()
                val y = coords[1].toDouble()
                return Point(x, y)
            } catch (e: NumberFormatException) {
                println("Неверные данные попробуйте ещё")
            }
        } else {
            println("Неверные данные попробуйте ещё")
        }
    }
}

fun readTriangleCoords(): Triangle {
    while (true) {
        print("Введите координаты треугольника (x1 y1 x2 y2 x3 y3): ")
        val triangleCoords = readLine()!!.split(" ").map { it.toDoubleOrNull() }
        if (triangleCoords.size == 6 && triangleCoords.all { it != null }) {
            return Triangle(
                Point(triangleCoords[0]!!, triangleCoords[1]!!),
                Point(triangleCoords[2]!!, triangleCoords[3]!!),
                Point(triangleCoords[4]!!, triangleCoords[5]!!)
            )
        } else {
            println("Неверные данные попробуйте ещё")
        }
    }
}