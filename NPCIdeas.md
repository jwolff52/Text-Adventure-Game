# Friendly NPCs

So I have laid out the different types of friendly NPCs in the `NPCType` Enum.

Each class will extend `NPC` and will go in the `io.github.jwolff52.cyoa.entity.npc` package.

Names will be Randomly generated and we will pick a random back story from a database.*

All friendly *adult* NPCs will be able to give you quests, but the reward for them will depend on the difficulty of the quest

The plan is to use Quest Templates and have them randomly generate certain parts, for example a quest template for a Shopkeeper might be:

`Hello %player%, I need you to find the delinquent who stole %item% from my shop. I believe they were wearing %torsoClothing% and %headWear%`

And the out put might be something like:

`Hello Dartanion, I need you to find the delinquent who stole a pot from mt shop. I believe they were wearing a black coat and a viking helmet.`

And then as the player searches the town (for example they enter the tavern) something along the lines of this comes up:

`You enter the tavern, there are only a few patrons, however they are all watching a gentleman in %description from quest% argue with the Tavern Keep.`

Then the player can choose how to handle the situation from there.

Basically where I am going with this is we need to have several methods in the NPC class that the others inherit and some, possibly, override, for example:
`onFirstMeeting`, `onAttack`, `onDeath`, etc.

# Monsters

So I haven't defined a `MonsterType` enum yet but the ones I had in mind were

- Goblin
- Orc
- Wolff
- Bear
- Dragon (This would be a boss, probably only a couple in the game)

You can just format it after the `NPCType` enum, most of it is a copy > paste job.

Again like NPCs each class will extend `Monster` which will have methods in it like:
`onDeath`, `onAttack`, etc.

# Inventories

All NPCs will have an inventory and if that inventory contains a weapon they will be able to use it in combat, excluding the wolf, the bear, and the dragon, and the goblin and orc only being able to use blades

When the NPC dies they will drop everything in their inventory and a random amount of gold (based on the monster's level, or the friendly NPC's job)

Some Monsters will be considered legendary and will have a higher chance to drop better items



* We are either going to have a local derby database or we will just continue with the text file method we are using right now. Something we will probably want to decide on sooner rather than later.