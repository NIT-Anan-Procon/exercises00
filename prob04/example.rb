n = ARGV[0].to_i
n = n == 0 ? 10 : n
sum = (0..n).inject(:+)
(1..n).each{|i| sum -= STDIN.gets.to_i }
puts sum
