package com.core.call;


import java.util.Arrays;
import java.util.Random;



/** 
 * @Params size(int)
 * size에 따른 줄 + 6자리 출력
 */
public class DefaultRepository implements CallRepository{

    @Override
    public void findNumber(int size){
        for (int i = 0; i < size; i++) {
            int[] lottoNumbers = generateLottoNumbers();
            Arrays.sort(lottoNumbers); // 번호를 정렬하여 출력
            
            System.out.println(Arrays.toString(lottoNumbers));
        }
    }

    private int[] generateLottoNumbers() {
        int[] lottoNumbers = new int[6];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int randomNumber;
            do {
                // 1에서 45까지의 무작위 숫자 생성
                randomNumber = random.nextInt(45) + 1;
            } while (contains(lottoNumbers, randomNumber)); // 중복된 번호 방지

            lottoNumbers[i] = randomNumber;
        }

        return lottoNumbers;
    }

    private boolean contains(int[] arr, int number) {
        for (int n : arr) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }
}   
