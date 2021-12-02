package com.theundertaker11.magnetkeybind;

public class Reference {

    public static final String MODID = "bettermagnets";
    public static final String VERSION = "1.2";
    public static final String NAME = "Better Magnets";
    public static final String CLIENTPROXY = "com.theundertaker11.magnetkeybind.proxy.ClientProxy";
    public static final String SERVERPROXY = "com.theundertaker11.magnetkeybind.proxy.CommonProxy";

    /**NBTTag key used to tell if the magnet is on or not. */
    public static final String KEY = "active";
    /** String used to tell quickly if an item should be picked up */
    public static final String NO_PICKUP = "PreventRemoteMovement";

    public static final String BaublesModID = "baubles";


    private Reference() {
        throw new IllegalAccessError("Ref class");
    }
}
