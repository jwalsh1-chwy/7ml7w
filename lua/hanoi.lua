function hanoi(n, A, B, C)
   if n == 1 then print(A .. ' ---> ' .. C) return end
   hanoi(n - 1, A, C, B)
   hanoi(1, A, B, C)
   hanoi(n - 1, B, A, C)
end

hanoi(3, 'A', 'B', 'C')
