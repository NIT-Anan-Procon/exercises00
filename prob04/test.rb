n = ARGV[0].to_i
n = n == 0 ? 10 : n
xs = (0..n).to_a.shuffle
STDERR.puts "answer: #{xs[0]}"
xs[1..n].each{|i| puts i }
