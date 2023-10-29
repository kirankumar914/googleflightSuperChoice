package packages.configs.factroy;

import org.aeonbits.owner.Config;
import packages.configs.converters.StringToBrowserTypeConverter;
import packages.configs.converters.StringToRunModeTypeConverter;
import packages.enums.BrowserType;
import packages.enums.RunModeTye;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath.config.properties"
})
public interface Frameworkconfig extends Config {

    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();
    @DefaultValue("local")
    @ConverterClass(StringToRunModeTypeConverter.class)
    RunModeTye runmode();
    String environment();
    @Key("${environment}.url")
    String applicationURL();
    @Key("${environment}.resgistrationPageURL")
    String resgistrationPageURL();

}
