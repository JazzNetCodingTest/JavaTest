package com.jazz.interview;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketValidatorTest {

    BracketValidator bracketValidator = new BracketValidator();

    @Test
    void testEmptyBracket(){
        assertTrue(bracketValidator.isValid(null));
    }

    @Test
    void testClosedBracketSeq(){
        assertTrue(bracketValidator.isValid("{[(())]()}"));
    }

    @Test
    void testClosedBracketSeqWithOtherCharacters(){
        assertTrue(bracketValidator.isValid("abcded{[((a))]()}"));
    }

    @Test
    void testUnClosedBracketSeq(){
        assertFalse(bracketValidator.isValid("{[(()])()}"));
    }

}