# GA_Colville_Func
This program utilizes Genetic Algorithm concept to solve the Colville mathematical equation, 
the whole project is based on the idea from Lee Jacobson's simple Genetic Algorithm example, 
please kindly visit his site for more explanation on Genetic Algorithm, 
link:http://www.theprojectspot.com/tutorial-post/creating-a-genetic-algorithm-for-beginners/3

Hi, I am Yk, currently studying in Multimedia University, Malaysia for my Artificial Intelligence degree. 
I and my teammate, Wey Yeong build this Genetic Algorithm program for my assignment submission.

Feel free to utilize this code for both academic and commercial purpose if you find it useful.

Observation:

1. Population size increases, the better the result is (both the result and the number of generations it needs to compute the best fitness value).
2. The cycle of evolution that the population goes through increases, it often does not change the result much.
3. Tournament size increases, the lesser the number of generation it needs to get the end result (whether it is the best fitness value or the value that it sticks to) but it either get the best result extremely fast or get stuck in the not so good value forever,
ex:
Best Fitness Value = 0
It either gets this value within 10 generations or it gets stuck in the cycle saying 33.99 is the best fitness value.
4. Tournament size decreases, the larger the number of generations it needs to get its end result.
ex:
Best Fitness Value = 0
It might takes up to 90 generations to get this value 0. Even if it doesn't get 0, it will get value very close to 0, such as 1 and 4 unlike the previous setting.
