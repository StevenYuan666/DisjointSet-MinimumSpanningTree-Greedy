# Disjoint Set, Minimum Spanning Tree and Greedy Algorithm
## Disjoint Set
We want to implement a disjoint set data structure with union and find operations. 

In this question, we model a partition of n elements with distinct integers ranging from 0 to n − 1 (i.e. each element is represented by an integer in [0,··· ,n − 1], and each integer in [0,··· ,n − 1] represent one element). We choose to represent the disjoint sets with trees, and to implement the forest of trees with an array named par. More precisely, the value stored in par[i] is parent of the element i, and par[i]==i when i is the root of the tree and thus the representative of the disjoint set.

## Minimum Spanning Tree
We will implement the Kruskal algorithm to cal- culate the minimum spanning tree (MST) of an undirected weighted graph. 

## Greedy Algorithm
The input is a list of homeworks defined by two arrays: deadlines and weights (the rela- tive importance of the homework towards your final grade). These arrays have the same size and they contain integers between 1 and 100. The index of each entry in the arrays represents a single homework,for example, Homework 2 is defined as a homework with deadline deadlines[2] and weight weights[2]. Each homework takes exactly one hour to complete.
