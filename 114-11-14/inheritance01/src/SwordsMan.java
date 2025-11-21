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

}
