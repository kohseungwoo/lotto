package com.core.call;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/** 
 * @Params size(int)
 * size에 따른 줄 + 고정자리 + n자리 출력
 */
public class PixRepository implements CallRepository{

    @Override
    public void findNumber(int size){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("원하는 임의의 숫자 개수를 입력하세요. : ");
        int in = sc.nextInt();

        System.out.println("임의의 숫자를 입력해주세요.");
        
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < in; i++) {
            int number;
            do {
                number = sc.nextInt();
                if(number > 45){
                    System.out.println("임의의 숫자는 45보다 작아야 합니다. 재 입력 바랍니다.");
                }
            } while (contains(lottoNumbers, number, true) || number > 45); // 중복된 번호 방지
            lottoNumbers[i] = number;
        }
        sc.close();

        for (int j = 0; j < size; j++) {
            lottoNumbers = generateLottoNumbers(lottoNumbers, in);
            Arrays.sort(lottoNumbers); // 번호를 정렬하여 출력
            
            System.out.println(Arrays.toString(lottoNumbers));
        }
    }

    private int[] generateLottoNumbers(int[] lottoNumbers, int in) {
        Random random = new Random();

        for (int i = in; i < 6; i++) {
            int randomNumber;
            do {
                // 1에서 45까지의 무작위 숫자 생성
                randomNumber = random.nextInt(45) + 1;
            } while (contains(lottoNumbers, randomNumber, false)); // 중복된 번호 방지

            lottoNumbers[i] = randomNumber;
        }

        return lottoNumbers;
    }

    private boolean contains(int[] arr, int number, boolean debug) {
        for (int n : arr) {
            if (n == number) {
                if(debug) System.out.println("중복 된 숫자를 입력할 수 없습니다. :" + number);
                return true;
            }
        }
        return false;
    }
}   
