package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import static com.example.demo.ArraySolution.singleNumber;
import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
@SpringBootApplication
public class DemoApplication {


	private static final int[] input_singleNumber = {2, 1, 1, 2, 5};

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		out.println(singleNumber(input_singleNumber));
	}


	static class Printr {

		public static void print(int[] nums) {
			out.println(Arrays.stream(nums)
					.mapToObj(String::valueOf)
					.collect(joining(","))
			);
		}
	}


}
