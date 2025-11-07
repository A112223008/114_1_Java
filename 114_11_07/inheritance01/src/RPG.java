public class RPG {
    public static void main(String[] args) {
        // 建立兩個劍士角色
        SwordsMan swordsMan_light = new SwordsMan("光明劍士", 100, 20);
        SwordsMan swordsMan_dark = new SwordsMan("黑暗劍士", 100, 25);

        // 建立一個魔法師角色
        Magician magician_light = new Magician("光明法師", 80, 15, 30);
        Magician magician_dark = new Magician("黑暗法師", 80, 20, 5);


        // 戰鬥模擬
        System.out.println("戰鬥開始！");
        swordsMan_light.attack(swordsMan_dark);
        magician_dark.attack(magician_light);
        magician_dark.heal(swordsMan_dark);
    }
}
