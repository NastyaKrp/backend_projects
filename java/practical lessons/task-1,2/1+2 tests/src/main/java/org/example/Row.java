package org.example;

class Row
{

    public
    double x, eps;
    int k;

    Row(double X, int K)
    {
        x = X;
        k = K;
        eps = Math.pow(10, -k);
    }

    double sol() throws Exception {
        if(x > 1 || x < -1) {
            throw new Exception("Error! Enter X from range [-1, 1]");
        }
        double sum = 1.0;
        int n = 1;
        double elem = 0.5 * x;
        while(Math.abs(elem) > eps)
        {
            sum += elem;
            n++;
            elem = elem * (-1) * x * (2 * n - 3)/(2 * n);
        }
        return sum;
    }
}