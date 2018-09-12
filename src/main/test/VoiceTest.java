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
        Assert.assertTrue(voice.getGap() > -1);
        Assert.assertTrue(voice.getGap() < 10);
        Assert.assertTrue(voice.getVaiant().equals(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionAmplitudeLow()
    {
        voice.setAmplitude(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionAmplitudeHigh()
    {
        voice.setAmplitude(210);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionPitchLow()
    {
        voice.setPitch(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionPitchHigh()
    {
        voice.setPitch(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionSpeed()
    {
        voice.setSpeed(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionGap()
    {
        voice.setGap(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionVariantMaleLow()
    {
        voice.setVariant(true, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionVariantMaleHigh()
    {
        voice.setVariant(true, 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionVariantFemaleLow()
    {
        voice.setVariant(false, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionVariantFemaleHigh()
    {
        voice.setVariant(false, 8);
    }
}
