package com.tencent.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    private static j AIm = null;
    public static final String DEVICE = Build.DEVICE.toLowerCase();
    public static final String MANUFACTURER = Build.MANUFACTURER.toLowerCase();
    public static final String MODEL = Build.MODEL.toLowerCase();
    private boolean AIA = true;
    private boolean AIB = false;
    private boolean AIl = false;
    private boolean AIn = false;
    private boolean AIo = false;
    private boolean AIp = false;
    private int AIq = 0;
    private boolean AIr = false;
    private boolean AIs = false;
    private boolean AIt = false;
    private boolean AIu = false;
    public boolean AIv = false;
    private boolean AIw = false;
    private boolean AIx = false;
    private int AIy = 0;
    private boolean AIz = false;
    private String cws = null;

    static {
        AppMethodBeat.i(86624);
        AppMethodBeat.o(86624);
    }

    public static j dSM() {
        AppMethodBeat.i(86622);
        if (AIm == null) {
            AIm = new j();
        }
        j jVar = AIm;
        AppMethodBeat.o(86622);
        return jVar;
    }

    private j() {
        AppMethodBeat.i(86623);
        if (this.AIl) {
            i.j("PhoneProperty", "******MODEL*****" + Build.MODEL);
            i.j("PhoneProperty", "******BRAND*****" + Build.BRAND);
            i.j("PhoneProperty", "*******DEVICE****" + Build.DEVICE);
            i.j("PhoneProperty", "*****DISPLAY******" + Build.DISPLAY);
            i.j("PhoneProperty", "*****HARDWARE******" + Build.HARDWARE);
            i.j("PhoneProperty", "******MANUFACTURER*****" + Build.MANUFACTURER);
            i.j("PhoneProperty", "*****PRODUCT******" + Build.PRODUCT);
            i.j("PhoneProperty", "******TAGS*****" + Build.TAGS);
            i.j("PhoneProperty", "*****USER******" + Build.USER);
            i.j("PhoneProperty", "****TYPE*******" + Build.TYPE);
        }
        AppMethodBeat.o(86623);
    }
}
