import kotlin.math.sqrt

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {

    require(naturalNumber > 0)

    return when ((1..sqrt(naturalNumber.toDouble()).toInt()).asSequence()
            .filter { naturalNumber % it == 0 }
            .map { setOf(it, naturalNumber / it) }.flatten()
            .minus(naturalNumber).sum()) {
        in 0 until naturalNumber -> Classification.DEFICIENT
        naturalNumber -> Classification.PERFECT
        else -> Classification.ABUNDANT
    }
}
