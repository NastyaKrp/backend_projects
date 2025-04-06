package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;

class Big
{
    public
    BigDecimal x, eps;
    BigInteger k;

    Big(double X, int K)
    {
        x = BigDecimal.valueOf(X);
        k = BigInteger.valueOf(K);
        double temp = Math.pow(10.0, -K);
        eps = BigDecimal.valueOf(temp);
    }

    BigDecimal Big_sol() throws Exception {
        BigDecimal ex1 = new BigDecimal("1");
        BigDecimal ex2 = new BigDecimal("-1");
        if(x.compareTo(ex1) > 0 || x.compareTo(ex2) < 0) {
            throw new Exception("Error! Enter X from range [-1, 1]");
        }
        BigDecimal bsum = BigDecimal.valueOf(1);
        BigDecimal n = BigDecimal.valueOf(1);
        // double elem = 0.5 * x;
        BigDecimal elem = BigDecimal.valueOf(0.5);
        elem = elem.multiply(x);
        while(elem.abs().compareTo(eps) == 1)
        {
            bsum = bsum.add(elem);
            n = n.add(BigDecimal.valueOf(1));
            elem = elem.multiply(BigDecimal.valueOf(-1));
            elem = elem.multiply(x);

            //(2 * n - 3)
            BigDecimal l = BigDecimal.valueOf(2);
            l = l.multiply(n);
            l = l.add(BigDecimal.valueOf(-3));

            elem = elem.multiply(l);

            // /(2 * n)
            BigDecimal m = BigDecimal.valueOf(2);
            m = m.multiply(n);

            elem = elem.divide(m, k.intValue(), BigDecimal.ROUND_HALF_UP);
        }
        return bsum;
    }
}