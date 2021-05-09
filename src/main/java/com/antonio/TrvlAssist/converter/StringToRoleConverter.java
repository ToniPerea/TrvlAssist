package  com.antonio.TrvlAssist.converter;

import org.springframework.core.convert.converter.Converter;

import static  com.antonio.TrvlAssist.model.User.*;

public class StringToRoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String value) {

        return Role.valueOf("ROLE_" + value);
    }
}
