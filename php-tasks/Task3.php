<?php

namespace src;

use InvalidArgumentException;


class Task3
{
    function main($num)
    {
        try
        {
            if(!is_int($num))
            {
                throw new InvalidArgumentException('Task3 function only accepts integers. Input was: '.$num);
            }
            $sum = 0;
            $number = $num;
            while($number > 0)
            {
                $sum += $number % 10;
                $number /= 10;
                if($sum !== $sum % 10 && $number <=0)
                {
                    $number = $sum;
                    $sum = 0;
                }
            }
            return $sum;
        }
        catch(InvalidArgumentException $e)
        {
            echo $e->getMessage();
        }
    }
}