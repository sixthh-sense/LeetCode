package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.*;

public class DQ_3016 {

    /* 8까진 1개 누르는 것 가능 8 주기로 필수로 눌러야 하는 값이 +1씩 증가
    word에 unique letter가 몇 개 있는지 알아냄
    많이 등장하는 unique letter 을 우선적으로 배치하고
    빈도순으로 key 뒤쪽에 위치하게끔 배치
    word는 1이상 10^5 이하니까 unique letter 가 8개 이하로 올 거라는 naive한 생각은 그만
    ... 근데 어차피 word consists of lowercase English letters하면 unique는 최대 26개 아닌가? 8*3 + 2네?
     */

    // 첫 시도
    public int minimumPushes_1(String word) {
        // 각 alphabet의 frequency 정보 저장하는 용도
        Map<String, Integer> infoMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String key = Character.toString(c);
            Integer value = (infoMap.get(key) == null) ? 0 : infoMap.get(key);
            infoMap.put(key, value + 1);
        }

        List<String> keys = new ArrayList<>(infoMap.keySet());

        // 정렬이 되지만 for문을 돌려야 정렬 판별이 되고 그냥 map 자체를 찍어버리면 티 안 남
        keys.sort((v1, v2) -> (infoMap.get(v2).compareTo(infoMap.get(v1))));

        int loop = 0;
        int result = 0;

        for (String key : keys) {
            int index = keys.indexOf(key);
            if (index % 8 == 0) {
                loop++;
            }
            result += loop * infoMap.get(key);
        }

        return result;
    }

    // 두 번째 시도(memory 측면에서 보다 효율적으로)
    public int minimumPushes_2(String word) {
        int result = 0;
        int[] alphabets = new int[26]; // a ~ z -> 26개

        // char에서 char을 뺐는데 int가 되는 이유는?
        /* char type은 문자 자체가 아니라 해당 문자의 유니코드 값, 즉 정수를 저장하기 때문
        * a는 유니코드 97에 해당, 뒤로 갈수록 숫자가 하나씩 커지는 형태고 */
        for (char c : word.toCharArray()) {
            //System.out.println("c: " + c + ", value: " + (c - 'a'));
            // 즉 c - 'a'는 c가 a일 땐 0 z일 때는 25가 나온다는 뜻 -> 이걸로 int[26]에 정보 저장
            alphabets[c - 'a']++;
        }

        // 오름차순
        Arrays.sort(alphabets);

        for (int i = 0; i < 26; i++) {
            // i가 아니다. 26 - i - 1이다. 뒤쪽에서부터 세야 한다.
            // 내림차순이었다면 alphabets[i]가 맞을 듯.
            result += alphabets[26 - i - 1] * ((i / 8) + 1);
        }

        // 내림차순 :: 내림차순은 primitive type이 안 벅혀서 우회로를 사용 -> 오름차순이 나은 듯

        /*
        Integer[] boxedArr = Arrays.stream(alphabets).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, Collections.reverseOrder());
        int[] descArr = Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < 26; i++) {
            result += descArr[i] * ((i / 8) + 1);
        }
        */


        return result;
    }
    public static void main(String[] args) {

        DQ_3016 daily = new DQ_3016();

        List<String> words = new ArrayList<>();
        words.add("abcde");
        words.add("xyzxyzxyzxyz");
        words.add("aabbccddeeffgghhiiiiii");

        for (String word : words) {
            // 얘는 HashMap을 만들어서 일일이 기록하는 방식
            //System.out.println(daily.minimumPushes_1(word));
            // 얘는 int[]를 만들어서 알파벳 문자별로 기록하는 방식
            System.out.println(daily.minimumPushes_2(word));
        }
    }
}
