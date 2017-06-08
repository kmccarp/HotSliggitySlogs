package com.hotsliggityslogs.enumerations;

public enum Heroes {
    ANUBARAK("Anub'arak", "Anubarak"),
    DVA("D.Va", "DVa"),
    ETC("E.T.C.", "ETC"),
    GULDAN("Gul'dan", "Guldan"),
    KAELTHAS("Kael'thas", "Kaelthas"),
    LILI("Li Li", "LiLi"),
    LTMORALES("Lt. Morales", "LtMorales"),
    LUCIO("Lúcio", "Lúcio"),
    SGTHAMMER("Sgt. Hammer", "SgtHammer"),
    THEBUTCHER("The Butcher", "TheButcher"),
    THELOSTVIKINGS("The Lost Vikings", "TheLostVikings"),
    ZULJIN("Zul'jin", "Zuljin");

    private String heroName;
    private String heroIconName;

    Heroes(String heroName, String heroIconName) {
        this.heroName = heroName;
        this.heroIconName = heroIconName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroIconName() {
        return heroIconName;
    }

    public void setHeroIconName(String heroIconName) {
        this.heroIconName = heroIconName;
    }

    public static String getIconByHeroName(String heroName) {
        for (Heroes hero : Heroes.values()) {
            if (heroName.equals(hero.getHeroName())) {
                return hero.getHeroIconName();
            }
        }
        return heroName;
    }
}
