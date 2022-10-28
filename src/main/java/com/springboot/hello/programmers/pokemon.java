package com.springboot.hello.programmers;

import java.util.HashSet;

public class pokemon {

        public int solution(int[] nums) {
            int answer = 0;
            int pickNum = nums.length / 2;

            HashSet<Integer> set = new HashSet<>();
            for(int n : nums) {
                set.add(n);
            }

            if(pickNum >= set.size()) answer = set.size();
            else answer = pickNum;

            return answer;
        }
    }

