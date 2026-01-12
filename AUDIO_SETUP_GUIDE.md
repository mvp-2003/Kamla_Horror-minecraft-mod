# Kamla Mod - Audio Setup Guide

## Current Status
Placeholder OGG sound files have been created in:
```
src/main/resources/assets/kamla/sounds/entity/kamla/
├── ambient.ogg
├── attack.ogg
├── chase.ogg
├── death.ogg
├── hurt.ogg
└── step.ogg
```

These placeholder files are minimal but valid OGG Vorbis files that will allow the mod to compile and run without audio errors.

## Adding Real Audio

### Required Tools
1. **FFmpeg** - For audio conversion and editing
   ```bash
   # Ubuntu/Debian
   sudo apt-get install ffmpeg

   # macOS
   brew install ffmpeg
   ```

2. **yt-dlp** - For downloading YouTube audio
   ```bash
   pip install yt-dlp
   ```

### Step 1: Download YouTube Audio

#### Chase Music (First 11 Seconds)
```bash
# Download from: https://www.youtube.com/watch?v=xdP0T42GUS8
yt-dlp -f bestaudio --extract-audio --audio-format mp3 \
  "https://www.youtube.com/watch?v=xdP0T42GUS8" \
  -o "chase_raw.mp3"
```

#### Ambient Horror Sound
```bash
# Download from: https://youtube.com/shorts/JLxPE7lu80E?si=9aRa_oXM7qvnet5A
yt-dlp -f bestaudio --extract-audio --audio-format mp3 \
  "https://youtube.com/shorts/JLxPE7lu80E?si=9aRa_oXM7qvnet5A" \
  -o "ambient_raw.mp3"
```

### Step 2: Convert and Edit Audio

#### Chase Music (Trim to 11 seconds)
```bash
ffmpeg -i chase_raw.mp3 -t 11 -q:a 5 -codec:a libvorbis chase.ogg
```

#### Ambient Sound (Full clip, high quality)
```bash
ffmpeg -i ambient_raw.mp3 -q:a 5 -codec:a libvorbis ambient.ogg
```

### Step 3: Create Additional Sound Effects

If you want to create or customize other sounds:

#### Attack Sound (Whoosh/Impact)
You can use existing Minecraft sounds or create new ones:
```bash
# Convert an existing sound file to OGG
ffmpeg -i attack_sound.wav -q:a 5 -codec:a libvorbis attack.ogg
```

#### Footstep Sound
```bash
ffmpeg -i footstep_sound.wav -q:a 5 -codec:a libvorbis step.ogg
```

#### Hurt/Scream Sound
```bash
ffmpeg -i hurt_sound.wav -q:a 5 -codec:a libvorbis hurt.ogg
```

#### Death Sound
```bash
ffmpeg -i death_sound.wav -q:a 5 -codec:a libvorbis death.ogg
```

### Step 4: Copy Files to Mod

Replace the placeholder files:
```bash
cp chase.ogg src/main/resources/assets/kamla/sounds/entity/kamla/
cp ambient.ogg src/main/resources/assets/kamla/sounds/entity/kamla/
cp hurt.ogg src/main/resources/assets/kamla/sounds/entity/kamla/
cp death.ogg src/main/resources/assets/kamla/sounds/entity/kamla/
cp step.ogg src/main/resources/assets/kamla/sounds/entity/kamla/
cp attack.ogg src/main/resources/assets/kamla/sounds/entity/kamla/
```

### Step 5: Rebuild the Mod

```bash
./gradlew clean build
```

The new mod JAR will be available at: `build/libs/kamla-1.0.0.jar`

## Audio Specifications

### File Format
- **Codec**: OGG Vorbis
- **Sample Rate**: 48 kHz or 44.1 kHz recommended
- **Quality**: -q:a 5 (FFmpeg quality parameter)
- **Mono or Stereo**: Either is acceptable

### Sound Characteristics

#### Chase Music
- **Duration**: 11 seconds
- **Usage**: Plays during pursuit when entity is chasing player
- **Volume Level**: Should be loud/prominent
- **Type**: High-energy, scary music

#### Ambient Sound
- **Duration**: Variable (loops)
- **Usage**: Ambient atmosphere when Kamla is nearby
- **Volume Level**: Quieter, background level
- **Type**: Unsettling presence sounds, whispers

#### Attack Sound
- **Duration**: 0.5-1.0 seconds
- **Usage**: Triggered when entity performs melee attack
- **Volume Level**: Medium-high impact
- **Type**: Whoosh, impact, or slashing sound

#### Hurt Sound
- **Duration**: 0.3-0.8 seconds
- **Usage**: Triggered when entity takes damage
- **Volume Level**: High (distressing)
- **Type**: Scream, shriek, or pain cry

#### Death Sound
- **Duration**: 1.0-2.0 seconds
- **Usage**: Triggered when entity dies
- **Volume Level**: Medium-high
- **Type**: Final cry, fade away effect

#### Footstep Sound
- **Duration**: 0.2-0.4 seconds
- **Usage**: Triggered while entity is walking/running
- **Volume Level**: Low-medium
- **Type**: Footstep, tapping, or dragging sound

## Testing Audio

After adding audio files:

1. **Rebuild the mod**:
   ```bash
   ./gradlew clean build
   ```

2. **Install in Minecraft**:
   ```bash
   cp build/libs/kamla-1.0.0.jar ~/.minecraft/mods/
   ```

3. **Test in-game**:
   - Launch Minecraft with the mod
   - Spawn a Kamla using `/summon kamla:kamla`
   - Verify sounds play:
     - Ambient sound when nearby
     - Footsteps while walking
     - Attack sound during combat
     - Hurt sound when taking damage
     - Death sound when killed
     - Chase music during pursuit (if implemented)

## Advanced Audio Editing

If you want to mix or modify audio further:

### Normalize Volume
```bash
ffmpeg -i input.mp3 -af "loudnorm=I=-23:TP=-1.5:LRA=11" -q:a 5 output.ogg
```

### Add Fade Effect
```bash
ffmpeg -i input.mp3 -af "afade=t=in:st=0:d=1,afade=t=out:st=9:d=2" -q:a 5 output.ogg
```

### Adjust Volume
```bash
# Increase volume by 3dB
ffmpeg -i input.mp3 -af "volume=1.4125" -q:a 5 output.ogg

# Decrease volume by 3dB
ffmpeg -i input.mp3 -af "volume=0.7079" -q:a 5 output.ogg
```

### Combine Multiple Clips
```bash
# Create a file list (concat.txt):
# file 'part1.mp3'
# file 'part2.mp3'

ffmpeg -f concat -safe 0 -i concat.txt -c copy output.ogg
```

## Troubleshooting

### Audio not playing in-game
- Verify OGG files are in correct directory: `src/main/resources/assets/kamla/sounds/entity/kamla/`
- Check file naming matches sounds.json exactly
- Ensure files are valid OGG format: `file *.ogg` should show OGG Vorbis Audio

### Audio distorted or cutting off
- Check volume levels (use loudnorm or volume filter)
- Verify file duration is appropriate for use case
- Ensure proper FFmpeg encoding parameters

### Build fails
- Clean build directory: `./gradlew clean`
- Verify all OGG files are valid audio files
- Check sounds.json for syntax errors

## Default Audio Behavior

With the placeholder files, the mod will:
- Compile successfully
- Run without audio errors
- Play silent "audio" when Kamla spawns/attacks
- Allow you to test all other functionality

Once real audio is added, players will experience the full horror atmosphere intended.
