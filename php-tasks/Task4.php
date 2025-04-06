<?php

namespace src;
use InvalidArgumentException;


class Task4
{
    function main($str)
    {
        try
        {
            if(!is_string($str))
            {
                throw new InvalidArgumentException('Task4 function only accepts strings. Input was: '.$str);
            }
            $res = "";
            $i = 0;
            while($i < strlen($str))
            {
                if($str[$i] !== " " && $str[$i] !== "-" && $str[$i] !== "_")
                {
                    if($str[$i - 1] === " " || $str[$i - 1] === "-" || $str[$i - 1] === "_" || $i === 0)
                    {
                        $res .= strtoupper($str[$i]);
                    }
                    else
                    {
                        $res .= $str[$i];
                    }
                }
                $i++;
            }
            return $res;
        }
        catch(InvalidArgumentException $e)
        {
            echo $e->getMessage();
        }
    }
}