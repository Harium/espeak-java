# java-espeak
Espeak java wrapper

You should install [espeak](http://espeak.sourceforge.net) to use this wrapper!

## Simple Example
```
Espeak espeak = new Espeak();
espeak.speak("Hello World!");
```

## Complete Example
```
Voice manVoice = new Voice();
manVoice.setName("english-us")
manVoice.setAmplitude(100);
manVoice.setPitch(30);
manVoice.setSpeed(100);
manVoice.setVariant(true, 3);

Espeak man = new Espeak(manVoice);
man.speak("Hello World!");
```

## Maven
```
<dependency>
    <groupId>com.harium.hci</groupId>
    <artifactId>espeak</artifactId>
    <version>1.0.1</version>
</dependency>
```