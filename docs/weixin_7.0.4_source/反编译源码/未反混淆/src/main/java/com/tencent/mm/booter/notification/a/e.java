package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.text.format.Time;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.m.a;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> een;
    static final Time eep = new Time();
    public boolean eeo;

    static {
        AppMethodBeat.i(16023);
        HashSet hashSet = new HashSet();
        een = hashSet;
        hashSet.add("readerapp");
        een.add("blogapp");
        een.add("newsapp");
        AppMethodBeat.o(16023);
    }

    public static boolean jR(String str) {
        AppMethodBeat.i(16012);
        if (aj.amC("keep_chatting_silent".concat(String.valueOf(str)))) {
            ab.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            AppMethodBeat.o(16012);
            return true;
        }
        ab.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        AppMethodBeat.o(16012);
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean jS(String str) {
        boolean z = true;
        AppMethodBeat.i(16013);
        boolean contains = een.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        AppMethodBeat.o(16013);
        return contains;
    }

    public static boolean IU() {
        AppMethodBeat.i(16014);
        eep.setToNow();
        int i = eep.hour;
        int i2 = eep.minute;
        ah.getContext();
        if (a.bS(i, i2)) {
            AppMethodBeat.o(16014);
            return false;
        }
        ab.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        AppMethodBeat.o(16014);
        return true;
    }

    public static boolean IV() {
        AppMethodBeat.i(16015);
        ab.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", Boolean.valueOf(a.MG()));
        AppMethodBeat.o(16015);
        return a.MG();
    }

    public static boolean it(int i) {
        boolean z;
        AppMethodBeat.i(16016);
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", Boolean.valueOf(z));
        AppMethodBeat.o(16016);
        return z;
    }

    public static boolean a(String str, bi biVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(16017);
        if (!f.kI(str) || f.i(biVar)) {
            z = false;
        } else {
            z = true;
        }
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Must Mute: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        ab.i(str2, str3, objArr);
        AppMethodBeat.o(16017);
        return z;
    }

    public static boolean IW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(16018);
        try {
            ui uiVar = new ui();
            uiVar.cQx.cAd = 2;
            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
            z = uiVar.cQy.cQz;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        ab.d(str, str2, objArr);
        AppMethodBeat.o(16018);
        return z;
    }

    public static boolean l(int i, String str) {
        boolean Ns;
        AppMethodBeat.i(16019);
        if (f.ja(i)) {
            if (f.kD(str)) {
                Ns = f.Ns();
            } else if (f.kE(str)) {
                Ns = f.Nt();
            }
            ab.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(Ns));
            AppMethodBeat.o(16019);
            return Ns;
        }
        Ns = true;
        ab.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(Ns));
        AppMethodBeat.o(16019);
        return Ns;
    }

    public static boolean IX() {
        AppMethodBeat.i(16020);
        boolean MI = a.MI();
        if (IY() == 0) {
            MI = false;
        }
        ab.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", Boolean.valueOf(MI), Integer.valueOf(IY()));
        AppMethodBeat.o(16020);
        return MI;
    }

    public static int IY() {
        AppMethodBeat.i(16021);
        int ringerMode = ((AudioManager) ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getRingerMode();
        AppMethodBeat.o(16021);
        return ringerMode;
    }

    public static boolean iu(int i) {
        boolean z;
        AppMethodBeat.i(16022);
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", Boolean.valueOf(z));
        AppMethodBeat.o(16022);
        return z;
    }
}
