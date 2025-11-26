// java
public class ShieldSwordsMan extends SwordsMan {
    private int defenseCapacity;

    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = Math.max(0, defenseCapacity);
    }

    @Override
    public void attack(Role opponent) {
        int reducedDamage = Math.max(0, this.getAttackPower() - 5);
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + "，造成 " +
                reducedDamage + " 點傷害。" + opponent);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence() {
        this.setHealth(this.getHealth() + this.defenseCapacity);
        System.out.println(this.getName() + " 使用防禦盾牌，恢復 " + defenseCapacity + " 點血量。" + this);
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("┌──────────────────────────┐");
        System.out.println("│ " + this.getName() + " 的特殊技能 │");
        System.out.println("├──────────────────────────┤");
        System.out.println("│ 技能名稱：連續斬擊           │");
        System.out.println("│ 技能描述：快速揮劍三次       │");
        System.out.println("│ 技能效果：造成 150% 傷害     │");
        System.out.println("└──────────────────────────┘");
    }
}
