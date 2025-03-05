package Pt2_day06;

public class Solution03 {
    public static void main(String[] args) {
        Morgan morgan = new Morgan();
        morgan.talkAboutLastSuperBall();
        morgan.talkAboutNetflixAnime();
        morgan.talkAboutThePreviousChampions();
    }
}

class Morgan implements KoreanBaseball, AmericanWestHipHop, SubCulture {
    @Override
    public void talkAboutLastSuperBall() {
        System.out.println("They not like us~ They not like us~ They not like us~");
    }

    @Override
    public void talkAboutThePreviousChampions() {
        System.out.println("와! 양현종! 와! 키아!");
    }

    @Override
    public void talkAboutNetflixAnime() {
        System.out.println("사카모토데이즈는 2기 확정인데 이제 2기 확정 나오고 좋아하는 밴드 애니메이션 팬들이 있다? (케이온 아님)");
    }
}

interface KoreanBaseball {
    void talkAboutThePreviousChampions();
}

interface AmericanWestHipHop {
    void talkAboutLastSuperBall();
}

interface SubCulture {
    void talkAboutNetflixAnime();
}