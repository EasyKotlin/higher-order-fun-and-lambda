package com.easykotlin.tutorials

import java.io.File

class HigherOrderFunAndLambda {

    fun getChar(filePath: String): List<Char> {
        val result = mutableListOf<Char>()

        val lines = File(filePath).readLines()
        for (line in lines) {
            for (e in line) {
                result.add(e)
            }
        }
        return result
    }

    val fnGetChar: (String) -> List<Char> = { filePath ->
        val result = mutableListOf<Char>()

        val lines = File(filePath).readLines()
        for (line in lines) {
            for (e in line) {
                result.add(e)
            }
        }
        result
    }

    val filterSpecialChars: (List<Char>, Array<String>) -> (List<Char>) = { chars, zhSeparators ->
        val result = chars.filter {
            !zhSeparators.contains(it.toString())
        }
        result
    }


    fun getAndFilterChar(
            getChar: (String) -> List<Char>,
            filterSpecialChars: (List<Char>, Array<String>) -> List<Char>,
            zhSeparators: Array<String>
    ): (String) -> List<Char> {

        return { x -> filterSpecialChars(getChar(x), zhSeparators) }

    }


}

val zhSeparators = arrayOf("“", "”", "。", "！", "·", ".",
        "：", "；", "。", "？",
        "【", "】", "，", "《", "》", "（", "）",
        "、", "*", " ",
        "１", "２", "３", "４", "5", "6", "7", "8", "9", "0",
        "的"
)

