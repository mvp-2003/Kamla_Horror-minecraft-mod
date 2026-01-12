package kamla.horror.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import kamla.horror.Kamla;

public class KamlaSounds {
    public static SoundEvent KAMLA_AMBIENT = registerSoundEvent("kamla_ambient");
    public static SoundEvent KAMLA_HURT = registerSoundEvent("kamla_hurt");
    public static SoundEvent KAMLA_DEATH = registerSoundEvent("kamla_death");
    public static SoundEvent KAMLA_STEP = registerSoundEvent("kamla_step");
    public static SoundEvent KAMLA_CHASE = registerSoundEvent("kamla_chase");
    public static SoundEvent KAMLA_ATTACK = registerSoundEvent("kamla_attack");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Kamla.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
    }
}
