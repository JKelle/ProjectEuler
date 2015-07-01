
import numpy


def f(n):
    """
    Generating function. Defined in the problem statement.

    Args:
        n: number

    Returns:
        number, f(n)
    """
    assert n <= 10
    return 1 - n + n**2 - n**3 + n**4 - n**5 + n**6 - n**7 + n**8 - n**9 + n**10


def polyFit(points):
    """
    Polynomial fit. Order is determined by number of points (order = number of
    points - 1). Is computed by solving a system of linear equations.

    Args:
        points: list of numbers (y values). Corresponding x values are assumed
            to be [1, 2, 3, ...]

    Returns:
        list of numbers, coefficients in order of descending polynomial degree
    """
    max_degree = len(points) - 1

    A = [[x**deg for deg in range(max_degree, -1, -1)] for x in range(1, max_degree + 2)]
    b = points

    # Ax = b
    return numpy.linalg.solve(A, b)


def polyEval(coefs, k):
    """
    Evaluate a polynomial expression.
    Ex. polyEval([2, 6, 3], 4) -> 2(4^2) + 6(4) + 3

    Args:
        coefs: list of numbers, coefficients in order of descending polynomial degree
        k: value at which to evaluate the polynomial function

    Returns:
        Single number
    """
    assert k == len(coefs) + 1

    value = 0
    degrees = range(len(coefs) - 1, -1, -1)
    for coef, deg in zip(coefs, degrees):
        value += coef*(k**deg)

    return value


def getFit(points, k):
    """
    compute the first incorrect term (FIT)

    Args:
        points: list of numbers (y values). Corresponding x values are assumed
            to be [1, 2, 3, ...]
        k: index of FIT (the k-th FIT)

    Returns:
        Single number, the k-th FIT
    """
    assert k <= len(points)
    coefs = polyFit(points[:k])
    return polyEval(coefs, k + 1)


def main():
    """
    Computes and prints the sum of all FITs for the generating function
    specified in the problem statement (projectEuler 101).
    """
    points = [f(n) for n in range(1, 11)]
    fits = [getFit(points, k) for k in range(1, 11)]
    print sum(fits)


if __name__ == '__main__':
    main()
