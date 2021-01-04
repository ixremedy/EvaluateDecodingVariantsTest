package com.forthreal.application.tests

import com.forthreal.application.classes.DecodingEvaluator
import org.junit.Test
import kotlin.test.assertEquals

class EvaluationTests
{
    @Test
    public fun test1()
    {
        assertEquals( 2, DecodingEvaluator.evaluateString( "11" ) )
    }

    @Test
    public fun test2()
    {
        assertEquals( 3, DecodingEvaluator.evaluateString( "111" ) )
    }

    @Test
    public fun test3()
    {
        assertEquals( 2, DecodingEvaluator.evaluateString( "13" ) )
    }

    @Test
    public fun test4()
    {
        assertEquals( 0, DecodingEvaluator.evaluateString( "01" ) )
    }
}