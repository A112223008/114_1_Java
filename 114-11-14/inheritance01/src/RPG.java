public class RPG {
    public static void main(String[] args) {
        // 建立兩個劍士角色
        SwordsMan swordsMan_light = new SwordsMan("光明劍士", 100, 20);
        SwordsMan swordsMan_dark = new SwordsMan("黑暗劍士", 100, 25);

        // 建立一個魔法師角色
        Magician magician_light = new Magician("光明法師", 80, 15, 30);
        Magician magician_dark = new Magician("黑暗法師", 80, 20, 5);

        ShieldSwordsMan shieldSwordsMan = new ShieldSwordsMan("持盾劍士", 120, 18, 8);

        Role[] gameRoles = {swordsMan_light, swordsMan_dark, magician_light, magician_dark, shieldSwordsMan};
        // 戰鬥模擬
        System.out.println("戰鬥開始！");
        for (Role currentRole : gameRoles) {
            if (!currentRole.isAlive()){
                continue;
            }
            if (currentRole instanceof SwordsMan) {
                Role target = gameRoles[(int) (Math.random() * gameRoles.length)];
                if (target instanceof ShieldSwordsMan)
                    ((ShieldSwordsMan) target).defence();
                currentRole.attack(target);
            } else if (currentRole instanceof Magician) {
                Magician magician = (Magician) currentRole;
                // 隨機決定是攻擊還是治療
                if (Math.random() < 0.5) {
                    Role target = gameRoles[(int) (Math.random() * gameRoles.length)];
                    if (target instanceof ShieldSwordsMan)
                        ((ShieldSwordsMan) target).defence();
                    currentRole.attack(target);
                } else {
                    magician.heal(gameRoles[(int) (Math.random() * gameRoles.length)]);
                }
            }
        }
    }
}


