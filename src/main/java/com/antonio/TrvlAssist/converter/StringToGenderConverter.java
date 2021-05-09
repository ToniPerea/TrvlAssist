package  com.antonio.TrvlAssist.converter;

import org.springframework.core.convert.converter.Converter;

import static  com.antonio.TrvlAssist.model.User.*;

public class StringToGenderConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String value) {

        return Gender.valueOf(value.toUpperCase());
    }
}
