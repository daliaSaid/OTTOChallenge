Running the Solution:
---------------------
To run the executable jar file, use the following command:
java -jar ChallengeSolution.jar input.txt output.txt

Where input.txt and output.txt are the names of the input and output files respectively. The input file must be in the same folder as the jar file.

If you are manually viewing the output on a Windows machine, please use Wordpad or Notepad++, given Notepad's inability to handle line breaks. 
I have tested all the provided test cases and they yielded the correct results using my solution.

--------------------------------------------------------------------------------------------------------------------------------------------------------------

Assumptions Made:
-----------------

- I assumed that the restrictions on the input, like having more than 1000 waypoints per test case, were not "application breaking". I've come across a few waypoints in the same test case that had the same x and y coordinates. A warning is displayed to the user in these cases that the input does not comply with the restrictions, but the application runs normally.
- I used a Dynamic Programming approach to solve the problem. It is explained in the code. This speeds up the process, but requires more space to store the subproblem solutions. I assumed that this tradeoff was worth it, compared to a slow Brute Force approach, for example, that would take much more time, but requires less disk space.
- All access modifiers in my code were kept public, based on an assumption that no other applications/code has access to my work.
- I assumed that OTTO could skip multiple consecutive waypoints, if it results in reducing the time. This is implicit in the challenge description, though the example makes it seem as if only one waypoint can be skipped at a time.

--------------------------------------------------------------------------------------------------------------------------------------------------------------
