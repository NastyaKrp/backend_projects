<?php

namespace src;
use InvalidArgumentException;


class Task10
{
    function main($input)
    {
        try
        {
            if(!is_int($input))
            {
                throw new InvalidArgumentException('Task10 function only accepts integers. Input was: '.$input);
            }
            $res = [];
            $num = $input;
            $res[0] = $num;
            $k = 1;
            while($num !== 1)
            {
                if($num % 2 === 0)
                {
                    $num = $num / 2;
                    $res[$k] = $num;
                    $k++;
                }
                else
                {
                    $num = $num * 3 + 1;
                    $res[$k] = $num;
                    $k++;
                }
            }
            return $res;
        }
        catch(InvalidArgumentException $e)
        {
            echo $e->getMessage();
        }
    }
}