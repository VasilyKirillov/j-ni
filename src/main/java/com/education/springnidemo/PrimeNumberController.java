package com.education.springnidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/prime")
public class PrimeNumberController {

    private final Random RANDOM = new Random();

    @GetMapping("/random/{upperbound}")
    public List<Long> getPrimeNumbers(@PathVariable int upperbound) {

        int to = 2 + RANDOM.nextInt(upperbound - 2);
        int from = 1 + RANDOM.nextInt(to -1);
        return primeSequence(from, to);
    }

    private boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }

    private List<Long> primeSequence(long min, long max) {
        return LongStream.range(min, max)
        .filter(this::isPrime)
        .boxed()
        .collect(Collectors.toList());
    }
}
