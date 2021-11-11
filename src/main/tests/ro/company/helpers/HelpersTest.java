package ro.company.helpers;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import static  ro.company.helpers.Helpers.*;

class HelpersTest {
    @Test
    public void testLocalDateTimeSQL(){


        assertEquals("1991-10-10 10:10:10",  localDateSQLconvert(LocalDateTime.of(1991,10,10,10,10,10)));

    }

}