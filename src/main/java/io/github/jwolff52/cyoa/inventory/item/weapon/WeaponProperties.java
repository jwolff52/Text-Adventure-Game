package io.github.jwolff52.cyoa.inventory.item.weapon;

/**
 * Created by James on 4/7/2016.
 */
public class WeaponProperties {
    private int criticalChance;
    private int usableLevel;
    private int baseDamage;
    /**
     * [0] - Fire damage
     * [1] - Ice damage
     * [2] - Water damage
     */
    private int[] magicDamage;

    public WeaponProperties(int criticalChance, int usableLevel, int baseDamage, int[] magicDamage) {
        this.criticalChance = criticalChance;
        this.usableLevel = usableLevel;
        this.baseDamage = baseDamage;
        this.magicDamage = magicDamage;
    }

    public WeaponProperties(String info) {
        String[] infoAsArray = info.split("\\|");
        this.criticalChance = Integer.valueOf(infoAsArray[0]);
        this.usableLevel = Integer.valueOf(infoAsArray[1]);
        this.baseDamage = Integer.valueOf(infoAsArray[2]);
        this.magicDamage = new int[infoAsArray.length - 3];
        for(int i = 3; i < infoAsArray.length; i++) {
            this.magicDamage[i - 3] = Integer.valueOf(infoAsArray[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(criticalChance);
        sb.append("|");
        sb.append(usableLevel);
        sb.append("|");
        sb.append(baseDamage);
        for (int i : magicDamage) {
            sb.append("|");
            sb.append(i);

        }
        return sb.toString();
    }

    public int getUsableLevel() {
        return usableLevel;
    }

    public void setUsableLevel(int usableLevel) {
        this.usableLevel = usableLevel;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public int[] getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int[] magicDamage) {
        this.magicDamage = magicDamage;
    }
}
