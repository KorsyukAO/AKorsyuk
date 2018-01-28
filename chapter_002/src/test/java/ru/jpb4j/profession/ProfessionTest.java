package ru.jpb4j.profession;

import org.junit.Test;
import ru.job4j.profession.Doctor;
import ru.job4j.profession.Teacher;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 28.01.2018
 *@version 0.1
 */
public class ProfessionTest {
    @Test
    public void whenDoctorHealTeacher(){
        Doctor doctor = new Doctor("Норик", 29, "23.03.1988 ", "Диплом врача");
        Teacher teacher = new Teacher("Болик", 28, "21.04.1989", "Диплом учителя");
        String result = doctor.diagnoseHeal(teacher);
        String expected = "Доктор Норик лечит Болика.";
        assertThat(result, is(expected));
    }
}
