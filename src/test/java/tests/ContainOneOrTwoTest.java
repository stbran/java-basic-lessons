package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import ru.tamno.java.basic.lesson30.ReturnArray;

import java.util.ArrayList;
import java.util.List;

public class ContainOneOrTwoTest {

    ReturnArray returnArray;

    @BeforeEach
    public void init() {
        returnArray = new ReturnArray();
    }

    @CsvSource(value = {
            "'1,2,1,1'",
            "'2,2,2,1'",
            "'1,2'",
    })
    @ParameterizedTest
    public void positiveTests(@ConvertWith(ListArrayConverter.class) List arr) {
        Assertions.assertTrue(returnArray.isContainOneOrTwo(arr));
    }

    @CsvSource(value = {
            "'2,3,4,5,6,1'",
            "'1,1,1,1,1,1'",
            "'2,2,2,2'",
            "'0,0,0,0'",
            "'1'",
            "'2'",
            "'11,22'",
            "''",
    })
    @ParameterizedTest
    public void negativeTests(@ConvertWith(ListArrayConverter.class) List arr) {
        Assertions.assertFalse(returnArray.isContainOneOrTwo(arr));
    }
}
