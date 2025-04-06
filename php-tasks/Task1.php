<?php

namespace src;

use InvalidArgumentException;

class Task1
{
    function main($inputNumber)
    {
        try
        {
            if(!is_int($inputNumber))
            {
                throw new InvalidArgumentException('Task1 function only accepts integers. Input was: '.$inputNumber);
            }
            return $inputNumber > 30 ? 'More than 30' : ($inputNumber > 20  ? 'More than 20' : ($inputNumber > 10 ? 'More than 10' : 'Equal or less than 10'));
        }
        catch(InvalidArgumentException $e)
        {
            echo $e->getMessage();
        }
    }
}