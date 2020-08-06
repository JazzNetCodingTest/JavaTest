package com.jazz.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketValidatorTest {

    BracketValidator bracketValidator = new BracketValidator();

    @Test
    void testEmptyBracket() {
        assertTrue(bracketValidator.isValid(null));
    }

    @Test
    void testClosedBracketSeq() {
        assertTrue(bracketValidator.isValid("{[(())]()}"));
    }

    @Test
    void testClosedBracketSeqWithOtherCharacters() {
        assertTrue(bracketValidator.isValid("abcded{}[]()"));
    }

    @Test
    void testWithOtherCharacters() {
        assertTrue(bracketValidator.isValid("a little blue cat"));
    }

    @Test
    void testUnClosedBracketSeq() {
        assertFalse(bracketValidator.isValid("{[(()])()}"));
    }

    @Test
    void testUnClosedBracketSeqWithoutOpen() {
        assertFalse(bracketValidator.isValid("}}}}}}"));
    }

}