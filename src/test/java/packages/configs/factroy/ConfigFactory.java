package packages.configs.factroy;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {
    private ConfigFactory(){
    }

    public static Frameworkconfig getConfig(){return ConfigCache.getOrCreate(Frameworkconfig.class);
    }
}
