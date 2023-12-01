**This implementation is unfinished.**
# Old exam question 
Although Huffman’s encoding works great for binary systems, we can shorten the encodings even more by using ternary (0, 1, 2). With a 0 for the left child, a 1 for the middle child and a 2 for the right child, we could have the encoding “021” now for “left child, right child, middle child”.

In order to make sure our tree remains full however we can run into issues when we have an even number of characters. In such cases we might have a situation where the tree is a bit off balance. Fortunately there is a straightforward solution: if there are an even number of characters, just add a node with a non-used character (for example character code 0, in Java: (char) 0), and a frequency of 0. Now the number of characters is odd and all should be well!

# Not in the original exam question: 

As an additional question think about why this even/odd even matters for the number of characters. What goes wrong when we have an even number? Why? Help yourself by creating a small ternary tree for an input of a few characters.)

Provide an implementation for the decode method that given an encoded ternary string and the ternary tree, returns the original message.
Provide an implementation for the buildTree method that given 𝑛
characters with a frequency 𝑓
returns a ternary Huffman tree for the optimal prefix encoding.