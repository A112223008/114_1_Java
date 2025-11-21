public abstract class Role {

    private String name;

    private int health;

    private int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // 取得攻擊力（新增：攻擊力為 private，需要公開 getter 供子類別使用）
    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "角色名稱:" + name + "， 血量: " + health;
    }

    // 將抽象方法改為接受 Role，讓任意角色可以攻擊任意角色
    public abstract void attack(Role opponent);
}
