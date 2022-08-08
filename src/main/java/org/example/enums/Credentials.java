package org.example.enums;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Credentials {HITESH(Arrays.asList("hitesh.prajapati@pmcretail.com","GatewayDev@2020"))
    ,MAULI(Arrays.asList("mauli.jadeja@pmcretail.com","GatewayDev@2020"));

    List<String> credList=new ArrayList<>();

    Credentials(List<String> list) {
       this.credList.addAll(list);
    }

    public List<String> getCredentials()
    {
        return credList;
    }
}

//class demo{
//
//    public static void main(String[] args)
//    {
//        List<String> l=new ArrayList<>();
//
//        System.out.println(Credentials.MAULI.getCredentials());
//        l.addAll(Credentials.MAULI.getCredentials());
//        System.out.println(l);
//
//    }
//}
