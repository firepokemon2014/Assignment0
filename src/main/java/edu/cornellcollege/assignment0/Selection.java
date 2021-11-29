/**
 * Anna Staib
 * November 18, 2021
 * CSC 144
 * Week 0 Assignment
 */
package edu.cornellcollege.assignment0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {

    public static List<Integer> makeList( int size, Random rng ) {
        List<Integer> result = new ArrayList<>();

        for( int i = 0; i < size; i++ ) {
            result.add( rng.nextInt( 100 ) );
        } // for

        return result;
    } // makeList( int, Random )

    
    public static int smallest( List<Integer> data ) {
        int small = data.get(0);
        
        for( int p = 1; p < data.size(); p++ ) {
            if( data.get(p) < small ) {
                small = data.get(p);
            } // if
        } // for
        
        return small;
    } // smallest( int )
    
    
    public static int posOfSmallest( List<Integer> data, int start ) {
        int bestGuessSoFar = start;

        for( int i = start + 1; i < data.size(); i++ ) {
            if( data.get(i) < data.get(bestGuessSoFar) ) {
                bestGuessSoFar = i;
            } // if
        } // for

        return bestGuessSoFar;
    } // posOfSmallest( List<Integer>, int )

    
    public static int posOfSpecSmallest( List<Integer> data, int spec) {
        int guess = spec;
        
        for( int g = spec + 1; g < data.size(); g++ ) {
            if( data.get(g) < data.get(guess) ) {
                guess = g;
            } // if
        } // for

        return guess;
    } // posOfSpecSmallest( List<Integer>, int)
    
    
    public static void exchange( List<Integer> data, int i, int j ) {
        int temp = data.get(i);
        data.set( i, data.get(j) );
        data.set( j, temp );
    } // exchange( List<Integer>, int, int )

    
    public static void selectionSort( List<Integer> data ) {

        for( int i = 0; i < data.size(); i++ ) {
            int j = posOfSmallest( data, i );
            exchange( data, i, j );
        } // for

    } // selectionSort( List<Integer> )

    
    public static void printList( List<Integer> data ) {
        for( int datum : data ) {
            System.out.println( datum );
        }  // for
    } // printList( List<Integer> )

    
    public static void main( String[] args ) {

        Random rng = new Random();
        List<Integer> samples = makeList( 16, rng );

        printList( samples );

        System.out.println();
        
        int small = smallest( samples );
        
        System.out.println( "smallest = " + small );
        
        System.out.println();

        int index = posOfSmallest( samples, 0 );

        System.out.println( "index = " + index );

        System.out.println();
        
        int specificPos = posOfSpecSmallest( samples, 7);
        
        System.out.println( "index of smallest after 7 places = " + specificPos );
        
        System.out.println();

        exchange( samples, 3, 4 );

        printList( samples );

        selectionSort( samples );

        System.out.println();

        printList( samples );
    } // main( String [] )

} // Selection