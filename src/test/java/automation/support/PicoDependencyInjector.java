package automation.support;

import automation.ui.SharedDriver;
import cucumber.runtime.java.picocontainer.PicoFactory;

public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(SharedDriver.class);
    }
}
