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

public class ReturnSubArrayTest {
    ReturnArray returnArray;

    @BeforeEach
    public void init() {
        returnArray = new ReturnArray();
    }

    @CsvSource(value = {
            "'2,1,5,2,1,2,2', '2,2'",
            "'1,5,2,2,2', '5,2,2,2'",
            "'5,1,2,2', '2,2'",
            "'5,1,2,1,7', '7'",
            "'2,3,4,5,6,1', ''",
            "'1,1,1,1,1,1', ''",
    })
    @ParameterizedTest
    public void positiveTests(@ConvertWith(ListArrayConverter.class) List arr,
                     @ConvertWith(ListArrayConverter.class) List targetArr) {
        Assertions.assertIterableEquals(returnArray.returnSubArray(arr), targetArr);
    }

    @CsvSource(value = {
            "'2,3,4,5,6'",
            "'11,22'",
            "''"
    })
    @ParameterizedTest
    public void returnExeption(@ConvertWith(ListArrayConverter.class) List arr) {
        Assertions.assertThrowsExactly(RuntimeException.class, ()->
                returnArray.returnSubArray(arr));
    }
}
