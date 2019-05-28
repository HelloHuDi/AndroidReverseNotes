package com.tencent.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.util.j */
public final class C16372j {
    private static C16372j AIm = null;
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
        AppMethodBeat.m2504i(86624);
        AppMethodBeat.m2505o(86624);
    }

    public static C16372j dSM() {
        AppMethodBeat.m2504i(86622);
        if (AIm == null) {
            AIm = new C16372j();
        }
        C16372j c16372j = AIm;
        AppMethodBeat.m2505o(86622);
        return c16372j;
    }

    private C16372j() {
        AppMethodBeat.m2504i(86623);
        if (this.AIl) {
            C16371i.m25185j("PhoneProperty", "******MODEL*****" + Build.MODEL);
            C16371i.m25185j("PhoneProperty", "******BRAND*****" + Build.BRAND);
            C16371i.m25185j("PhoneProperty", "*******DEVICE****" + Build.DEVICE);
            C16371i.m25185j("PhoneProperty", "*****DISPLAY******" + Build.DISPLAY);
            C16371i.m25185j("PhoneProperty", "*****HARDWARE******" + Build.HARDWARE);
            C16371i.m25185j("PhoneProperty", "******MANUFACTURER*****" + Build.MANUFACTURER);
            C16371i.m25185j("PhoneProperty", "*****PRODUCT******" + Build.PRODUCT);
            C16371i.m25185j("PhoneProperty", "******TAGS*****" + Build.TAGS);
            C16371i.m25185j("PhoneProperty", "*****USER******" + Build.USER);
            C16371i.m25185j("PhoneProperty", "****TYPE*******" + Build.TYPE);
        }
        AppMethodBeat.m2505o(86623);
    }
}
