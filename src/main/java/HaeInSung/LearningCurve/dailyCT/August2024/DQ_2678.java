package HaeInSung.LearningCurve.dailyCT.August2024;

// link: https://leetcode.com/problems/number-of-senior-citizens/description/?envType=daily-question&envId=2024-08-01

/*
You are given a 0-indexed array of strings details. Each element of details provides information about a given passenger compressed into a string of length 15. The system is such that:

The first ten characters consist of the phone number of passengers.
The next character denotes the gender of the person.
The following two characters are used to indicate the age of the person.
The last two characters determine the seat allotted to that person.
Return the number of passengers who are strictly more than 60 years old.
* */

/*
* details란 애는 string들의 array긴 한데 괜히 꼬여있고 그런 거 없고 순수 직선?
* details의 각 요소는 승객들의 전화번호 10자리 묶음 + 성별표시 한글자 + 나이 두자리수 + 좌석번호
* 그래서 이 details에서 엄격하게 따졌을 때 60살 이상인 사람 수 구하라는 거
* */

/*
* ... age index 위치 고정되어 있으니까 정규식으로 그쪽 정보 딱 빼내서 구하거나
* 그냥 index substring 같은 걸로 구하면 끝 아닌감? (substring 범위가 첫 글자 이상, 두 번째 글자 미만이었나)
* */

import java.util.ArrayList;
import java.util.List;

public class DQ_2678 {

    public static int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] detail1 = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        String[] detail2 = {"1313579440F2036","2921522980M5644"};
        List<String[]> detailList = new ArrayList<>();
        detailList.add(detail1);
        detailList.add(detail2);

        for (String[] oneDetail : detailList) {
            System.out.println(countSeniors(oneDetail));
        }
    }
}
