package io.jacobking.localticket.core.utility;

public class Startup {
    private Startup() {

    }

    public static void begin() {
       final boolean isFirstLaunch = Config.getInstance().isFirstLaunch();
       if (isFirstLaunch) {

       } else {
           System.out.println("NO");
       }
    }

}
