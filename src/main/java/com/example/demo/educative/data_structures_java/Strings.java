package com.example.demo.educative.data_structures_java;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Strings {


    public static void main(String[] args) {
        char[] arr = "Hello World!".toCharArray();
        System.out.println(Arrays.toString(arr));
        ReverseWords.reverseWords(arr);
        System.out.println(Arrays.toString(arr));
    }

    @UtilityClass
    class ReverseWords {
        void reverseWords(char[] sentence) {

            int len = sentence.length;
            reverse(sentence,0,len - 2);

            int start = 0;
            for (int end = 0; end < len; end++) {
                char cur = sentence[end];
                if (cur == ' ' ) {
                    reverse(sentence, start, end - 1);
                    start = end + 1;
                    end ++;
                }

                if (end == len - 1) {
                    reverse(sentence, start, end - 1);
                    break;
                }
            }

        }


        private void reverse(char[] word, int start, int end) {
            while (start < end) {
                char startCopy = word[start];
                word[start] = word[end];
                word[end] = startCopy;
                start++;
                end--;
            }

        }

    }


}
