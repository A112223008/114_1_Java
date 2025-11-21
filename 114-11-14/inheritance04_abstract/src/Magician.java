public class Magician extends Role {

    private int healPower;

    // 建構子 : 初始化角色的名稱、血量、攻擊力和治療力
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    // 取得角色治療力
    public int getHealPower() {
        return healPower;
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        // 顯示攻擊資訊（繁體中文）
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        // 顯示治療資訊（繁體中文）
        System.out.println(this.getName() + " 治療 " + ally.getName() + "恢復 " + this.healPower + " 點血量。");
    }

    @Override
    public  String toString() {
        return super.toString() + "， 治療力:"  + healPower;
    }
}
