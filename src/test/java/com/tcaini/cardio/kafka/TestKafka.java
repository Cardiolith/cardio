package com.tcaini.cardio.kafka;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.google.common.collect.Lists;
import com.tcaini.cardio.CardioApplicationTests;
import com.tcaini.cardio.kafka.constants.KafkaConsts;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.*;
import java.util.stream.Stream;

@Slf4j
public class TestKafka extends CardioApplicationTests {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void sendMsg(){
        kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello kafka");
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr){
        List<List<Integer>> res=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            int currDiff=arr[i]-arr[i-1];
            if(currDiff<min){
                res.clear();
                res.add(Lists.newArrayList(arr[i], arr[i-1]));
                min=currDiff;
            }else if(currDiff==min){
                res.add(Lists.newArrayList(arr[i], arr[i-1]));
            }
        }
        return res;
    }

    public String complexNumberMultiply(String a, String b) {
        StringBuilder res=new StringBuilder();
        String[] splitA=a.split("\\+"), splitB=b.split("\\+");
        Integer A=Integer.parseInt(splitA[0]), B=Integer.parseInt(splitA[1].substring(0, splitA[1].length()-1)),
                C=Integer.parseInt(splitB[0]), D=Integer.parseInt(splitB[1].substring(0, splitB[1].length()-1));
        Integer r1=A*C-B*D, r2=A*D+B*C;
        res.append(r1+"+"+r2+"i");

        return res.toString();
    }

    public int maxValue(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=grid[i][j]+Math.max((i>0?dp[i-1][j]:0),(j>0?dp[i][j-1]:0));
            }
        }
        return dp[m-1][n-1];
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map=new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap=new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        heap.addAll(map.entrySet());
        StringBuilder sb=new StringBuilder();
        while (!heap.isEmpty()){
            Map.Entry<Character, Integer> entry=heap.poll();
            for(int i=0; i<entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
