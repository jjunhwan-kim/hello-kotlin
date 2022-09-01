package example.lec19

class Number(val number: Int) {
    fun getNumberOrNull(): Int? {
        return if (number <= 0) {
            null
        } else {
            number
        }
    }

    fun getNumberOrNull2(): Int? {
        /**
         * takeIf는 주어진 조건을 만족하면 그 값이 반환됨
         * 주어진 조건을 만족하지 않으면 null이 반환됨
         */
        return number.takeIf {
            number -> number > 0
        }
    }

    fun getNumberOrNull3(): Int? {
        return number.takeUnless { number -> number <= 0 }
    }
}