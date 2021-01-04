package com.forthreal.application.classes

import java.util.Arrays.copyOfRange
import javax.xml.ws.Holder

object DecodingEvaluator
{
    private val hCount  = Holder<Int>()

    private val letters =
        mapOf< String, Char >(
            Pair( "1", 'a'),
            Pair( "2", 'b'),
            Pair( "3", 'c'),
            Pair( "4", 'd'),
            Pair( "5", 'e'),
            Pair( "6", 'f'),
            Pair( "7", 'g'),
            Pair( "8", 'h'),
            Pair( "9", 'i'),
            Pair( "10", 'j'),
            Pair( "11", 'k'),
            Pair( "12", 'l'),
            Pair( "13", 'm'),
            Pair( "14", 'n'),
            Pair( "15", 'o'),
            Pair( "16", 'p'),
            Pair( "17", 'q'),
            Pair( "18", 'r'),
            Pair( "19", 's'),
            Pair( "20", 't'),
            Pair( "21", 'u'),
            Pair( "22", 'v'),
            Pair( "23", 'w'),
            Pair( "24", 'x'),
            Pair( "26", 'y'),
            Pair( "27", 'z')
        )

    public fun evaluateString(input: String) : Int
    {
        hCount.value = evaluateVariants( input )

        System.out.println("number of variants ${hCount.value}")

        return hCount.value
    }

    private fun evaluateVariants( input: String ) : Int
    {
        val hEvalCount = Holder<Int>()
        hEvalCount.value = 0

        letters
            .filter { input.length > 0 }
            .forEach {

                if( it.key.length <= input.length )
                {
                    if( input.substring( 0, it.key.length  ).equals( it.key ) == true )
                    {
                        hEvalCount.value++

                        val remaining = input.substring( it.key.length )

                        //System.out.println("found ${it.value} in ${input} added 1 ")

                        if( remaining.length > 0 )
                        {
                            //System.out.println("sending ${remaining}")

                            hEvalCount.value += evaluateVariants( remaining )
                        }

                    }
                }
            }

        return hEvalCount.value
    }
}