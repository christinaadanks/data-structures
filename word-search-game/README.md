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
![image](https://github.com/christinaadanks/data-structures/blob/main/word-search-game/boggle.png)

A string is said to be on the board if it can be constructed according to rules 1 through 4. A string is said to be a valid word if it is contained in the specified lexicon (rule 6). A scorable word is a valid word of at least the specified minimum length (rule 5) that is on the board.

HNTQ is on the board, but is not a valid word. PLACE, POPE, and PALE are valid words, but are not on the board. PEACE is a scorable word for any minimum length between 1 and 5. BOY is a valid word and it is on the board, but it would not be a scorable word if the specified minimum length is 4 or greater.

The score for a scorable word is calculated as follows: one point for the minimum number of characters, and one point for each character beyond the minimum number. Thus, each scorable word of length K > M is worth 1 + (K - M) points, where M is the specified minimum length. For example, the scorable words of length five or more on the board above would earn a score of 31. (22 words of length 5, 3 words of length 6, and 1 word of length 7 give 22 + 6 + 3 = 31 points.)
