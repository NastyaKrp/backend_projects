<?php

namespace src;

use InvalidArgumentException;

class Task2
{
    function main($data)
    {
        try
        {
            if(!is_string($data))
            {
                throw new InvalidArgumentException('Task2 function only accepts strings. Input was: '.$data);
            }
            date_default_timezone_set('UTC');
            $curData = date("d-m-Y");
            $curYear = substr($curData, 6);
            $bdDate = substr($data, 0, 5) . "-" . $curYear;
            $date1 = strtotime($curData);
            $date2 = strtotime($bdDate);
            if($date2 < $date1)
            {
                $dateAt = strtotime('+1 YEAR', $date2);
                $bdDate = date('d-m-Y', $dateAt);
            }
            $date2 = strtotime($bdDate);
            $diff = abs($date1 - $date2)/60/60/24;
            return $diff;
        }
        catch(InvalidArgumentException $e)
        {
            echo $e->getMessage();
        }
    }
}