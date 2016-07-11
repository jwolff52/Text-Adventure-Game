<<<<<<< HEAD:src/main/java/io/github/jwolff52/cyoa/entity/npc/monster/Monster.java
package io.github.jwolff52.cyoa.entity.npc.monster;

import io.github.jwolff52.cyoa.entity.npc.GenericNPC;

/**
 * Created by James on 4/7/2016.
 */
public abstract class Monster extends GenericNPC {
    private int level;

    public Monster(String name) {
        super(name);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
=======
package io.github.jwolff52.cyoa.entity.npc.enemy;

import io.github.jwolff52.cyoa.entity.npc.NPC;

/**
 * Created by James on 4/7/2016.
 */
public abstract class Enemy extends NPC {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
>>>>>>> bf7bdbb848c9f0dec3b058375a054bcfa80db36b:src/main/java/io/github/jwolff52/cyoa/entity/npc/enemy/Enemy.java
