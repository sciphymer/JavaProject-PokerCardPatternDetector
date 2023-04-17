# PokerCardPatternDetector

## Description

This is a Java Poker Cards project which consists of following 2 parts:

1. Update the skeleton of the Card and Deck class to pass all the test cases in CardTest.java and DeckTest.java.

2. Create a program from scratch that takes a hand of 5 poker cards (from the Card.class implemented in Part 1) and determine the highest
pattern of the hand (e.g. a Straight Flush should precede a Flush even though a hand may have both patterns).

The possible patterns include:
- Cheating — any duplicate card
- Royal Flush
- Straight Flush
- Quads
- Full House
- Flush
- Straight
- Three of a Kind
- Two pairs
- One Pair

The design pattern of **"Chain of Responsibility"** is chosen to tackle part 2 task, since it provides the flexibility to add the card pattern detectors one by one. 

Test cases are written for each card pattern detector to follow the Red-Green-Refactor Cycle of Test Driven Development(TDD) for:
1. Easier code verification and debugging
2. Code Refactoring without breaking the codes.
