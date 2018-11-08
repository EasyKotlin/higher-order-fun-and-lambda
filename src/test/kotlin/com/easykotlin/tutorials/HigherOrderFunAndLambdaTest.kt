package com.easykotlin.tutorials

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class HigherOrderFunAndLambdaTest {


    @Test
    fun testGetChar() {
        val higherOrderFunAndLambda = HigherOrderFunAndLambda()
        val chars = higherOrderFunAndLambda.getChar("唐诗三百首.txt")
        println(chars)
    }

    @Test
    fun testFnGetChar() {
        val higherOrderFunAndLambda = HigherOrderFunAndLambda()
        val chars = higherOrderFunAndLambda.fnGetChar("唐诗三百首.txt")
        //println(chars)
        val filterChars = higherOrderFunAndLambda.filterSpecialChars(chars, zhSeparators)
        println(filterChars)
    }

    @Test
    fun testGetAndFilterChar() {
        val higherOrderFunAndLambda = HigherOrderFunAndLambda()
        // this is a higher order function
        val filterChars = higherOrderFunAndLambda.getAndFilterChar(higherOrderFunAndLambda.fnGetChar, higherOrderFunAndLambda.filterSpecialChars, zhSeparators)
        val result = filterChars("唐诗三百首.txt")
        println(result.size)

        val set = result.toHashSet()
        println(set.size)
        // println(set)

        val map = mutableMapOf<Char, Int>()

        for (e in set) {
            for (x in result) {
                if (e == x) {
                    val v = map[e] ?: 0
                    map[e] = v + 1
                }
            }
        }
        println(map.map { it }.sortedByDescending { it.value })

    }

}