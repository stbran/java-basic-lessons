package tests;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) {
        if (!source.toString().equals("")) {
            String[] str = ((String) source).split("\\s*,\\s*");
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                arr.add(Integer.parseInt(str[i]));
            }
            return arr;
        }
        return new ArrayList<>();
    }

}