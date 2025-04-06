<?php

namespace src;

use InvalidArgumentException;

class Task6
{
    function main($year, $lastYear, $month, $lastMonth, $day = 'Monday')
    {
        try
        {
            if(!is_int($year) || !is_int($lastYear) || !is_int($month) || !is_int($lastMonth) || !is_string($day))
            {
                throw new InvalidArgumentException('Task6 function only accepts integers.');
            }
            $k = 0;
            $d1 = "01" . "-" . ($month >= 10 ? "" : "0") . (string)$month . "-" . (string)$year;
            $d2 = "01" . "-" . ($lastMonth >= 10 ? "" : "0") . (string)$lastMonth . "-" . (string)$lastYear;
            $interval = date_interval_create_from_date_string('1 month');
            $date1 = date_create($d1);
            $date2 = date_create($d2);
            if($date1 > $date2)
            {
                $tmp = $date1;
                $date1 = $date2;
                $date2 = $tmp;
            }
            while($date1 <= $date2)
            {
                if($date1 -> format('l') === $day)
                {
                    $k++;
                }
                $date1->add($interval);
            }
            return $k;
        }
        catch(InvalidArgumentException $e)
        {
            echo $e->getMessage();
        }
    }
}