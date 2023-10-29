package packages.configs.converters;

import org.aeonbits.owner.Converter;
import packages.enums.RunModeTye;

import java.lang.reflect.Method;

public class StringToRunModeTypeConverter implements Converter<RunModeTye> {
    @Override
    public RunModeTye convert(Method method,String runMode){return RunModeTye.valueOf(runMode.toUpperCase());}
}
