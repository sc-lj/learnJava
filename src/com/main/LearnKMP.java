package com.main;

public class LearnKMP {
    public static void main(String[] args){
        // 静态方法调用非静态方法
        LearnKMP learnkmp = new LearnKMP();
        System.out.println(learnkmp.kmp("afghansbdgd","grh"));
    }

    public int kmp(String s,String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNext(t_arr);
        int i=0,j=0;
        while(i<s_arr.length&&j<t_arr.length)
        {
            if(j==-1 || s_arr[i]==t_arr[j])
            {
                i++;
                j++;
            }
            else j=next[j];               //j回退。。。
        }
        if(j>=t_arr.length)
            return i-t_arr.length;         //匹配成功，返回子串的位置
        else
            return -1;                  //没找到
    }

    public int[] getNext(char[] t){
        int j=0,k=-1;
        int[] next = new int[t.length];
        next[0]=-1;
        next[1] = 0;
        while(j<t.length-1){
            if(k == -1 || t[j] == t[k])
            {
                j++;k++;
                if(t[j]==t[k])//当两个字符相同时，就跳过
                    next[j] = next[k];
                else
                    next[j] = k;
            }
            else k = next[k];
        }
        return next;
    }
}
