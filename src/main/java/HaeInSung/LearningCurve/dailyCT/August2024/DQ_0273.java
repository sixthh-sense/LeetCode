package HaeInSung.LearningCurve.dailyCT.August2024;

/* Convert a non-negative integer num to its English words representation. (띄어쓰기 있음, 첫 단어마다 대문자) */

/* 영문식으로 말하는 거니까 3자리수씩 끊어서 천 단위로 가는 건 알겠는데 Hard라는 이름값을 하는 건가 은근 어렵네
*  12,000 같은 경우 one two thousand가 아니라 twleve thousand -> 그렇다고 11,000 ~ 99,000를 커버하기 위해 eleven부터 ninety-nine까지 전부다 어디다 저장해놨다가 써야 하는 걸까?
*  정확히는 10,000 ten thousand 부터 불러야 하나
* one thousand ~ nine thousand도 있을 거고
* thousand -> million -> billion -> trillion...으로 가는 것도 잊으면 안 됨;;; wow
* num 범위는 0 이상 2의 31승 -1 이하라던데 trillion으로는 쨉도 안 되겠는데. 나 그 다음 단어 몰라요 아님 잊어버림...
* 일단 2의 31승 -1을 계산해보자... 2,147,483,647이 나오는데 java로도 계산하는 법 익혀놔야 하나? 일단 계산기로 했음
* -> trillion까지는 아니고 billion까지 가면 될 듯
*
*  */

public class DQ_0273 {

    // 숫자 -> 영문 정보 mapping
    // 0 ~ 9 -> Zero는 따로 말 안 해도 되나?
    private static final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    // 10 ~ 19
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // 20 ~ 90 (10단위) twenty-two 에서 twenty만 unique한 애
    // Fourty인 줄 알았는데 Forty였네 -> 이게 코딩 테스트인지 spelling test인지;;
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero"; // 유일하게 Zero란 단어가 쓰이는 순간
        }

        if (num < 10) { // 0인 건 앞에서 치웠고 1 ~ 9 상정 index 1 ~ 9까지니까 One은 index 1부터 시작해야 함
            return belowTen[num];
        }

        if (num < 20) { // 9 이하인 건 앞에서 치웠고 11 ~ 19 대상 -> 10을 빼면 인덱스 1부터 9까지
            return teens[num - 10];
        }

        if (num < 100) { // twenty, twenty one, twenty two... ninety nine :: 10으로 나눈 몫은 tens에서 나머지는 numberToWords 한번 더 돌리기
            return tens[num / 10] + (num % 10 != 0 ? " " + numberToWords(num % 10) : "");
        }

        if (num < 1000) { // 101 ~ 999 :: hundred 친화 spot
            return numberToWords(num / 100) + " Hundred" + (num % 100 != 0 ? " " + numberToWords(num % 100) : "");
        }

        if (num < 1000000) { // 1001 ~ 999999 :: below million, thousand 친화 spot
            return numberToWords(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + numberToWords(num % 1000) : "");
        }

        if (num < 1000000000) { // millions
            return numberToWords(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + numberToWords(num % 1000000): "");
        }
        // 2 billions... 가 끝지점이니 슬슬 마무리
        return numberToWords(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + numberToWords(num % 1000000000) : "");
    }

    public static void main(String[] args) {
        DQ_0273 dailyQ = new DQ_0273();
        //dailyQ.numberToWords();

        int[] testcases = new int[]{123, 12345, 1234567};

        for (int testcase : testcases) {
            System.out.println(dailyQ.numberToWords(testcase));
        }
    }
}
