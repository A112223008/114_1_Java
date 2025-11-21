public class ShieldSwordsMan extends SwordsMan{
    private int defenseCapacity;

    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = defenseCapacity;
    }

    @Override
    public void attack(Role opponent) {
        // 使用 reducedDamage 變數，並確保不會變成負數（避免回血給對手）
        int reducedDamage = Math.max(0, this.getAttackPower() - 5);
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        // 顯示攻擊資訊（繁體中文）
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + "，造成 " +
                reducedDamage + " 點傷害。" + opponent);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence(){
        this.setHealth(this.getHealth() + this.defenseCapacity);
        System.out.println(this.getName() + " 使用防禦盾牌，恢復 " + defenseCapacity + " 點血量。" + this);
    }
}
