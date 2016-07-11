package io.github.jwolff52.cyoa.api.entity.npc;

import io.github.jwolff52.cyoa.entity.npc.NPCType;

import java.util.ArrayList;

public abstract class AbstractNPC {
    protected String name;
    protected NPCType type;
    protected ArrayList<String> backStory;

    /**
     * <p>Must be true for main execution to proceed.</p>
     *
     * <p>Ensures addons call the Super Constructor while still leaving the getters and
     * setters available for use</p>
     */
    private boolean superCalled = false;

    public AbstractNPC(String name, NPCType type, ArrayList<String> backStory) {
        setName(name);
        setType(type);
        setBackStory(backStory);
        this.superCalled = true;
    }

    /**
     * <p>Ensures that <pre>name</pre> is not @null or an empty string (e.g. <pre>''</pre>) then
     * sets the value to AbstractNPC#name</p>
     * @param name
     */
    public final void setName(String name) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("\'name\' must not be null or an empty string (e.g. \'\')");
        }
        this.name = name;
    }

    /**
     * <p>Ensures that <pre>type</pre> is not @null then sets the value to AbstractNPC#type</p>
     * @param type
     */
    public final void setType(NPCType type) {
        if(type == null) {
            throw new IllegalArgumentException("\'type\' must not be null");
        }
        this.type = type;
    }

    /**
     * <p>Ensures that <pre>backstory</pre> is not @null or an empty List then sets the value
     * to AbstractNPC#backstory</p>
     * @param backStory
     */
    public final void setBackStory(ArrayList<String> backStory) {
        if(backStory == null || backStory.size() == 0) {
            throw new IllegalArgumentException("\'backstory\' must not be null or an empty List");
        }
        this.backStory = backStory;
    }

    /**
     *
     * @return an ArrayList of dropped Items
     */
    public abstract ArrayList<Object> onDeath();

    public abstract ArrayList<String> getBackStory();

    public abstract NPCType getType();

    public abstract String getName();

    public boolean isSuperCalled() {
        return superCalled;
    }
}
