import com.harium.hci.espeak.Voice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VoiceTest {

    private Voice voice;

    @Before
    public void setUp() {
        voice = new Voice();
    }

    @Test
    public void testRanges() {
        Assert.assertTrue(voice.getAmplitude() > 0);
        Assert.assertTrue(voice.getAmplitude() < 200);
        Assert.assertTrue(voice.getPitch() > 0);
        Assert.assertTrue(voice.getPitch() < 99);
        Assert.assertTrue(voice.getSpeed() > 0);
        Assert.assertTrue(voice.getSpeed() < 200);
    }

}
