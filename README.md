# java-espeak
Simple [espeak](http://espeak.sourceforge.net) java wrapper, no JNI,
no native libraries, no headache.

You should install [espeak](http://espeak.sourceforge.net) to use this wrapper!

## Minimal Example
```
Espeak espeak = new Espeak();
espeak.speak("Hello World!");
```

## Example using voice
```
Voice manVoice = new Voice();
manVoice.setName("en-us");
manVoice.setAmplitude(100);
manVoice.setPitch(30);
manVoice.setSpeed(100);
manVoice.setVariant(true, 3);

Espeak man = new Espeak(manVoice);
man.speak("Hello World!");
```

## Example foreign voice
```
Voice chineseVoice = new Voice();
chineseVoice.setName("zh");
chineseVoice.setAmplitude(100);
chineseVoice.setPitch(30);
chineseVoice.setSpeed(100);
chineseVoice.setVariant("f2");

Espeak woman = new Espeak(chineseVoice);
woman.speak("Nǐ hǎo, shìjiè!");
```

## Maven
```
<dependency>
    <groupId>com.harium.hci</groupId>
    <artifactId>espeak</artifactId>
    <version>1.0.2</version>
</dependency>
```

## How it works
This library calls espeak via [Process](https://docs.oracle.com/javase/7/docs/api/java/lang/Process.html).
Everytime you call to Espeak.speak it creates a new thread to execute the process.

## Thanks to
- [MacFJA](https://github.com/MacFJA)