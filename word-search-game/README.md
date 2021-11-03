# Word Search Game

### Problem Overview
In this assignment, you will implement a version of a word search game much like Boggle and other similar word games. The approach you take to finding words on the board will be a direct application of depth-first search with backtracking.

The version of the game that you will implement is played on a square board according to the following rules.

1. Each position on the board contains one or more uppercase letters.
2. Words are formed by joining the contents of adjacent positions on the board.
3. Positions may be joined horizontally, vertically, or diagonally, and the board does not wrap around.
4. No position on the board may be used more than once within any one word.
5. A specified minimum word length (number of letters) is required for all valid words.
6. A specified lexicon is used to define the set of all valid words.

Below, from left to right, is a sample 4x4 board with single letters in each position, a sequence of positions forming the word PEACE, and the list of all words with a minimum length of 5 found on the board using the words in the standard Unix /usr/share/dict/words file as the lexicon.
