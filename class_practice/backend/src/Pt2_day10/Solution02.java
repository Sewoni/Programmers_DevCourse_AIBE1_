package Pt2_day10;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Solution02 {
    public static void main(String[] args)
    {
        Logger logger = Logger.getLogger("Stream");
        // 배열이 아닌 자료구조의 경우 제너릭을 쓰기 때문에
        // Wrapper 클래스가 필요하다
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        logger.info(numbers.toString());
        logger.info(numbers.stream().map(x -> x * 2).toList().toString()); // .stream, .toList
    }
}