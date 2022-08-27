package example.lec11

/**
 * 직접 .kt 파일 최상단에 함수를 선언하여 유틸성 코드를 작성하는 것이 편함
 */
fun isDirectoryPath(path : String): Boolean {
    return path.endsWith("/")
}