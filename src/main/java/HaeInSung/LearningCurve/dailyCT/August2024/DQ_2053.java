package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Kth Distinct String in an Array */

/* distinct String은 arr에 등장하는 unique한 String이란 뜻이고
*  arr에 문자열이 여러 개 나올 때 여기서 k번째로 distinct한 녀석을 구하기
* 없으면 빈 문자열 반환 */

/* 제한조건: 1 <= k <= arr.length <= 1000
*  1 <= arr[i].length <= 5
*  arr[i]는 영소문자로 구성되어 있음 */
public class DQ_2053 {

    public String kthDistinct(String[] arr, int k) {

        // arr 정보 담는 용도
        Map<String, Integer> infoMap = new HashMap<>();

        for (String string : arr) {
            int value = (infoMap.get(string) == null) ? 0 : infoMap.get(string);
            infoMap.put(string, value + 1);
        }

        for (String string : arr) {
            if (infoMap.containsKey(string) && infoMap.get(string) >= 2) {
                infoMap.remove(string);
            }
        }

        System.out.println("infoMap: " + infoMap);

        int cnt = 0; // str이 arr에서 몇 번째인지 인식용 변수
        for (String str : arr) {
            if (infoMap.containsKey(str)) {
                cnt++;
                if (k == cnt) {
                    cnt = 0; // 초기화
                    return str;
                }
            }
        }
        cnt = 0; // 초기화

        return "";
    }
    public static void main(String[] args) {
        DQ_2053 dq2053 = new DQ_2053();

        List<String[]> arrList = new ArrayList<>();
        arrList.add(new String[]{"d", "b", "c", "b", "c", "a"}); // 여기선 b와 c가 2개씩 나오니까 distinct하지 않음
        arrList.add(new String[]{"aaa", "aa", "a"});
        arrList.add(new String[]{"a", "b", "a"});
        arrList.add(new String[]{"c","exjk","nbmg","kgnas","s","oydx","ghpao","c","r","ohdm","fq","ashgg","mm","cc","mymy","w","t","neb","grjdb","cukk","ujyhn","dq","hhuo","qu","seslw","ybulz","iug","rs","kyfu","krz","nw","txnn","r","zpuao","sh","rfc","c","hgr","jfia","egm","gmuuv","gh","x","nfvgv","ibo","al","wn","o","dyu","zgkk","gdzrf","m","ui","xwsj","zeld","muowr","d","xgiu","yfu"});

        int[] k = new int[arrList.size()];
        k[0] = 2;
        k[1] = 1;
        k[2] = 3;
        k[3] = 19;

        for (String[] arr : arrList) {
            int index = arrList.indexOf(arr);
//            dq2053.kthDistinct(arr, k[index]);
            System.out.println(dq2053.kthDistinct(arr, k[index]));
        }
    }
}
