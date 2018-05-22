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
manVoice.amplitude = 100;
manVoice.pitch = 30;
manVoice.speed = 100;
manVoice.code = "m3";

Espeak man = new Espeak(manVoice, "en");
man.speak("Hello World!");
```