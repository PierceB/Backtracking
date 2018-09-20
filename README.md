# Backtracking #
AAA project for implementing the Backtracking algorithm for solving Sudoku.

Backtracking is nothing but the modified process of the brute force approach where the technique systematically searches for a solution to a problem among all available options. It does so by assuming that the solutions are represented by vectors (v<sub>i</sub>,...,v<sub>n</sub>) of values and by traversing through the domains of the vectors until the solution is found.


## Algorithm approach
- Backtracking systematically try and search possibilities to find the solution. Also it is an important process for solving constraint satisfication problem like crossword,Sudoku and many other puzzles. It can be more continent technique for parsing other combinatorial optimization problem.
- Basically the process is used when the problem has a number of options just one solution have to be selected. After having a new option set means recursion, the procedure is repeated over and over until final stage.


Algorithm Backtrack(v<sub>1</sub>,V<sub>i</sub>) 

if(V<sub>1</sub>,...,V<sub>i</sub>) is a Solution Then 

      Return (V<sub>1</sub>,...,V<sub>i</sub>) 
      
for each v DO 

  if (V<sub>1</sub>,...,V<sub>i</sub>) is acceptable vector THEN 
  
      sol = try(V<sub>1</sub>,...,V<sub>i</sub>,V) 
      
      if sol != () Then 
      
          Return sol 
          
      end 
      
  end 
  
end 

Return ()
