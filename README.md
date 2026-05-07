# Fast-Exponentiation-Algorithms-Project
Design and Analysis of Algorithms final project comparing linear exponentiation and exponentiation by squaring.

# Fast Exponentiation Project

This project compares a baseline linear exponentiation algorithm with an improved exponentiation-by-squaring algorithm using theoretical analysis and experimental benchmarking.

The goal of the project is to demonstrate how the decrease-and-conquer technique can significantly improve the efficiency of computing \(a^n\) for large exponent values.

---

## Algorithms Included

### 1. Linear Exponentiation
Baseline algorithm that computes \(a^n\) using repeated multiplication.

- Time Complexity: Θ(n)
- Space Complexity: Θ(1)

### 2. Fast Exponentiation (Exponentiation by Squaring)
Improved algorithm using the decrease-and-conquer technique.

- Time Complexity: Θ(log n)
- Space Complexity: Θ(log n)

---

## Files

### `LinearExponentiation.java`
Implements the baseline linear exponentiation algorithm and multiplication counting.

### `FastExponentiation.java`
Implements exponentiation by squaring and multiplication counting for the improved algorithm.

### `Benchmark.java`
Runs benchmark experiments on multiple input sizes and outputs runtime and multiplication-count data.

### `Test.java`
Interactive demonstration program for comparing both algorithms on user-provided inputs.

---

## Compilation

Compile all Java source files:

```bash
javac *.java
```

---

## Running the Benchmark

Run the benchmark program:

```bash
java Benchmark
```

The benchmark tests multiple exponent sizes and reports:
- multiplication counts
- average runtime
- multiplication reduction factor

---

## Running the Interactive Demo

Run the interactive test program:

```bash
java Test
```

The program allows the user to:
- enter a base value
- enter an exponent
- compare both algorithms
- verify correctness
- view runtime and multiplication statistics

---

## Experimental Setup

The benchmark evaluates the algorithms using the following exponent sizes:

```text
8, 64, 256, 1024, 4096, 16384
```

Benchmark settings:
- 1000 trials per input size
- 200 warmup iterations
- Runtime measured using `System.nanoTime()`

---

## Notes and Assumptions

- The project assumes nonnegative exponents only.
- Very large exponent values may overflow Java `long`.
- Benchmarking focuses on algorithmic efficiency, multiplication counts, and runtime behavior rather than arbitrary-precision arithmetic.

---

## Project Topic

Topic 7 — Fast Exponentiation

---

## Authors

Mohsin Moosa
