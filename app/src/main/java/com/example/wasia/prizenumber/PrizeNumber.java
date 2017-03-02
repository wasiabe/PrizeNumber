package com.example.wasia.prizenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wasia on 2017/2/27.
 */

public class PrizeNumber {
    public String number;
    public List<Integer> matchs = new ArrayList<Integer>();
    public List<Integer> prizes = new ArrayList<Integer>();

    public PrizeNumber(){}

    public PrizeNumber(String number, List<Integer> matchs, List<Integer> prizes){
        this.number = number;
        this.matchs = matchs;
        this.prizes = prizes;
    }
}
