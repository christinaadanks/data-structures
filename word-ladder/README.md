# Word Ladder

### Problem Overview
The focus of the assignment is to implement a word connection game that has been played in one variation or another for almost 150 years. The object of the game is to transform a start word into an end word of the same length by a sequence of steps, each of which consists of a one-letter change to the current word that results in another legal word. Charles Lutwidge Dodsgon (Lewis Carroll) invented this game and called it “Doublets.” It’s now more commonly known as Word Ladders.

```
cat, can, con, cog, dog
cat, bat, eat, fat, gat, hat
clash, flash, flask, flack, flock, clock, crock, crook, croon, crown, clown
```
Each is a valid word ladder from the start word to the end word since the start and end words are the same length and each word in between is exactly one letter different from the previous word.

The game is usually played so that each player tries to find the shortest word ladder between two words. The shortest ladder would, of course, depend on the lexicon, or list of words, being used for the game. Using the SOWPODS word list (see below), word ladders with minimum length for the start-end pairs above would be:

```
cat, cot, dot, dog
cat, hat
clash, class, claws, clows, clown
```
