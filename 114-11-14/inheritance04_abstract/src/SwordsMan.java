public class SwordsMan extends Role{

    // 建構子 : 初始化角色的名稱、血量和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        // 顯示攻擊資訊（繁體中文）
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }


    @Override
    private void showSpecialSkill(){
        System.out.println("┌──────────────────────────┐");
        System.out.println("│ " + this.getName() + " 的特殊技能 │");
        System.out.println("├──────────────────────────┤");
        System.out.println("│ 技能名稱：連續斬擊           │");
        System.out.println("│ 技能描述：快速揮劍三次       │");
        System.out.println("│ 技能效果：造成 150% 傷害     │");
        System.out.println("└──────────────────────────┘");

    }
}
