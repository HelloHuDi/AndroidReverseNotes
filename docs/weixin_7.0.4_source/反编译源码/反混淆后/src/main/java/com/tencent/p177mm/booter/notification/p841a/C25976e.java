package com.tencent.p177mm.booter.notification.p841a;

import android.media.AudioManager;
import android.text.format.Time;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.booter.notification.a.e */
public final class C25976e {
    private static final Set<String> een;
    static final Time eep = new Time();
    public boolean eeo;

    static {
        AppMethodBeat.m2504i(16023);
        HashSet hashSet = new HashSet();
        een = hashSet;
        hashSet.add("readerapp");
        een.add("blogapp");
        een.add("newsapp");
        AppMethodBeat.m2505o(16023);
    }

    /* renamed from: jR */
    public static boolean m41433jR(String str) {
        AppMethodBeat.m2504i(16012);
        if (C4997aj.amC("keep_chatting_silent".concat(String.valueOf(str)))) {
            C4990ab.m7416i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            AppMethodBeat.m2505o(16012);
            return true;
        }
        C4990ab.m7416i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        AppMethodBeat.m2505o(16012);
        return false;
    }

    /* renamed from: a */
    public static boolean m41430a(boolean[] zArr, boolean z, boolean z2) {
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

    /* renamed from: a */
    public static boolean m41429a(boolean[] zArr, boolean z) {
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

    /* renamed from: jS */
    public static boolean m41434jS(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(16013);
        boolean contains = een.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        AppMethodBeat.m2505o(16013);
        return contains;
    }

    /* renamed from: IU */
    public static boolean m41423IU() {
        AppMethodBeat.m2504i(16014);
        eep.setToNow();
        int i = eep.hour;
        int i2 = eep.minute;
        C4996ah.getContext();
        if (C37885a.m63972bS(i, i2)) {
            AppMethodBeat.m2505o(16014);
            return false;
        }
        C4990ab.m7420w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        AppMethodBeat.m2505o(16014);
        return true;
    }

    /* renamed from: IV */
    public static boolean m41424IV() {
        AppMethodBeat.m2504i(16015);
        C4990ab.m7417i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", Boolean.valueOf(C37885a.m63954MG()));
        AppMethodBeat.m2505o(16015);
        return C37885a.m63954MG();
    }

    /* renamed from: it */
    public static boolean m41431it(int i) {
        boolean z;
        AppMethodBeat.m2504i(16016);
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(16016);
        return z;
    }

    /* renamed from: a */
    public static boolean m41428a(String str, C7620bi c7620bi) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(16017);
        if (!C18559f.m28909kI(str) || C18559f.m28900i(c7620bi)) {
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
        C4990ab.m7417i(str2, str3, objArr);
        AppMethodBeat.m2505o(16017);
        return z;
    }

    /* renamed from: IW */
    public static boolean m41425IW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(16018);
        try {
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 2;
            C4879a.xxA.mo10055m(c26250ui);
            z = c26250ui.cQy.cQz;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        C4990ab.m7411d(str, str2, objArr);
        AppMethodBeat.m2505o(16018);
        return z;
    }

    /* renamed from: l */
    public static boolean m41435l(int i, String str) {
        boolean Ns;
        AppMethodBeat.m2504i(16019);
        if (C18559f.m28902ja(i)) {
            if (C18559f.m28904kD(str)) {
                Ns = C18559f.m28886Ns();
            } else if (C18559f.m28905kE(str)) {
                Ns = C18559f.m28887Nt();
            }
            C4990ab.m7417i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(Ns));
            AppMethodBeat.m2505o(16019);
            return Ns;
        }
        Ns = true;
        C4990ab.m7417i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(Ns));
        AppMethodBeat.m2505o(16019);
        return Ns;
    }

    /* renamed from: IX */
    public static boolean m41426IX() {
        AppMethodBeat.m2504i(16020);
        boolean MI = C37885a.m63956MI();
        if (C25976e.m41427IY() == 0) {
            MI = false;
        }
        C4990ab.m7417i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", Boolean.valueOf(MI), Integer.valueOf(C25976e.m41427IY()));
        AppMethodBeat.m2505o(16020);
        return MI;
    }

    /* renamed from: IY */
    public static int m41427IY() {
        AppMethodBeat.m2504i(16021);
        int ringerMode = ((AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getRingerMode();
        AppMethodBeat.m2505o(16021);
        return ringerMode;
    }

    /* renamed from: iu */
    public static boolean m41432iu(int i) {
        boolean z;
        AppMethodBeat.m2504i(16022);
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(16022);
        return z;
    }
}
