# Word Chain Application

* The application is solving problem from http://codekata.com/kata/kata19-word-chains/ using 338k-words long english dictionary.

To get nice performance, the application is reading the dictionary, then separates it into smaller dictionaries containing only same-length words (e.g. words-len-3.txt contain only 3-letters long words etc).

When starting, app is reading all the smaller dictionaries and creates an internal graph structure, where each node contains word from the dictionary, and has words different by 1 letter as neighbours. Having that, the __Wave Propagation algorithm__ can be applied.

__The Wave Propagation__ algorithm is finding all neighbour nodes from the starting node. Then, for all neighbour nodes it finds next-step neighbours, and so on, until it finds the specified word. Then it reverts the path by doing the same mechanism starting from last word, but limiting possible nodes to only those mentioned in previous iterations.

The algorithm is complete and stable, meaning that it always finds the best possible solution, if exists.
__HOWEVER__ the implementation that I provided is simplified:
* It only loads the words from 2 to 5 letters long (it can be changed in AlgorithmService class)
* It stops after 100 iterations (when probably no solution was available), number of max iterations can be increased as well.

To run the application, simply run the WordChainApp class. Then, go to localhost:8080/{firstWord}/{secondWord} and receive the results.
