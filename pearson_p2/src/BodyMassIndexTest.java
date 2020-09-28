import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    public void testBodyMassIndex() {
        BodyMassIndex tester = new BodyMassIndex(69,188);

        assertEquals(tester.BMInumber, 27.8);
        assertEquals(tester.BMIcategory, "Overweight");
    }

    @Test
    public void testCalculateBMI() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        double result = tester.calculateBMI(69,188);
        assertEquals(27.8,result);
    }

    @Test
    public void testCalculateBMI2() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        double result = tester.calculateBMI(72,208);
        assertEquals(28.2,result);
    }

    @Test
    public void testBMIcategory1() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        String result = tester.BMIcategory(18.4);
        assertEquals("Underweight",result);
    }

    @Test
    public void testBMIcategory2() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        String result = tester.BMIcategory(18.5);
        assertEquals("Normal weight",result);
    }

    @Test
    public void testBMIcategory3() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        String result = tester.BMIcategory(25);
        assertEquals("Overweight",result);
    }

    @Test
    public void testBMIcategory4() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        String result = tester.BMIcategory(30);
        assertEquals("Obesity",result);
    }

    @Test
    public void testBMIcategory5() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        String result = tester.BMIcategory(22.3);
        assertEquals("Normal weight",result);
    }

    @Test
    public void testBMIcategory6() {
        BodyMassIndex tester = new BodyMassIndex(1,1);

        String result = tester.BMIcategory(28.1);
        assertEquals("Overweight",result);
    }

}