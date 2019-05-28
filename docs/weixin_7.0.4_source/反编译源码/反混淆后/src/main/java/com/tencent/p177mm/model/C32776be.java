package com.tencent.p177mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.model.be */
public class C32776be {
    private static C32776be fmd;
    public C32778b fmc;

    /* renamed from: com.tencent.mm.model.be$a */
    public enum C32777a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD;

        static {
            AppMethodBeat.m2505o(16329);
        }
    }

    /* renamed from: com.tencent.mm.model.be$b */
    public interface C32778b {
        /* renamed from: ZZ */
        void mo31111ZZ();
    }

    /* renamed from: ZV */
    public static C32776be m53537ZV() {
        AppMethodBeat.m2504i(16330);
        synchronized (C32776be.class) {
            try {
                if (fmd == null) {
                    fmd = new C32776be();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(16330);
            }
        }
        C32776be c32776be = fmd;
        return c32776be;
    }

    private C32776be() {
    }

    /* renamed from: ZW */
    public static C37903bd m53538ZW() {
        AppMethodBeat.m2504i(16332);
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null) {
            AppMethodBeat.m2505o(16332);
            return null;
        }
        int i = lK.getInt("CurrentType", -1);
        int i2 = lK.getInt("CurrentShowType", -1);
        String string = lK.getString("CurrentData", "");
        if (i != -1) {
            switch (i) {
                case 1:
                    C32777a ZY = C32776be.m53540ZY();
                    if (ZY == C32777a.SUCC || ZY == C32777a.SUCC_UNLOAD || C26407g.aaK().aaI()) {
                        if (C26407g.aaK().aaI()) {
                            C4990ab.m7416i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                        } else {
                            C4990ab.m7416i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                        }
                        AppMethodBeat.m2505o(16332);
                        return null;
                    }
                case 2:
                    if (C32776be.m53540ZY() == C32777a.SUCC || C26407g.aaK().aaI()) {
                        if (C26407g.aaK().aaI()) {
                            C4990ab.m7416i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                        } else {
                            C4990ab.m7416i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                        }
                        AppMethodBeat.m2505o(16332);
                        return null;
                    }
                case 3:
                    C4990ab.m7416i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                    AppMethodBeat.m2505o(16332);
                    return null;
                case 11:
                    AppMethodBeat.m2505o(16332);
                    return null;
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                case 57005:
                    AppMethodBeat.m2505o(16332);
                    return null;
            }
            C37903bd c37903bd = new C37903bd(i, i2, string);
            AppMethodBeat.m2505o(16332);
            return c37903bd;
        }
        AppMethodBeat.m2505o(16332);
        return null;
    }

    /* renamed from: co */
    public final void mo53322co(int i, int i2) {
        AppMethodBeat.m2504i(16333);
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null) {
            AppMethodBeat.m2505o(16333);
            return;
        }
        Editor edit = lK.edit();
        switch (i2) {
            case 1:
                edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                break;
            case 2:
                edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                List ov = C32776be.m53543ov("HistoryInfo");
                if (!ov.contains(Integer.valueOf(i))) {
                    ov.add(Integer.valueOf(i));
                }
                C32776be.m53542f("HistoryInfo", ov);
                break;
            case 3:
                if (i == 3) {
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                }
                break;
        }
        if (this.fmc != null) {
            this.fmc.mo31111ZZ();
        }
        AppMethodBeat.m2505o(16333);
    }

    /* renamed from: ZX */
    private static boolean m53539ZX() {
        AppMethodBeat.m2504i(16334);
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null || !lK.edit().clear().commit()) {
            AppMethodBeat.m2505o(16334);
            return false;
        }
        AppMethodBeat.m2505o(16334);
        return true;
    }

    /* renamed from: b */
    private static boolean m53541b(C37903bd c37903bd) {
        AppMethodBeat.m2504i(16335);
        boolean contains = C32776be.m53543ov("HistoryInfo").contains(Integer.valueOf(c37903bd.type));
        AppMethodBeat.m2505o(16335);
        return contains;
    }

    /* renamed from: f */
    private static boolean m53542f(String str, List<Integer> list) {
        boolean z = false;
        AppMethodBeat.m2504i(16336);
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null) {
            AppMethodBeat.m2505o(16336);
            return false;
        }
        Editor edit = lK.edit();
        edit.putInt(str + "ArraySize", list.size());
        while (true) {
            boolean z2 = z;
            if (z2 < list.size()) {
                edit.putInt(str + z2, ((Integer) list.get(z2)).intValue());
                z = z2 + 1;
            } else {
                z = edit.commit();
                AppMethodBeat.m2505o(16336);
                return z;
            }
        }
    }

    /* renamed from: ov */
    private static List<Integer> m53543ov(String str) {
        AppMethodBeat.m2504i(16337);
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null) {
            AppMethodBeat.m2505o(16337);
            return null;
        }
        int i = lK.getInt(str + "ArraySize", 0);
        List<Integer> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(lK.getInt(str + i2, 0)));
        }
        AppMethodBeat.m2505o(16337);
        return arrayList;
    }

    /* renamed from: ZY */
    public static C32777a m53540ZY() {
        AppMethodBeat.m2504i(16338);
        C32777a c32777a;
        try {
            C9638aw.m17190ZK();
            String str = (String) C18628c.m29072Ry().get(4097, (Object) "");
            C9638aw.m17190ZK();
            String str2 = (String) C18628c.m29072Ry().get(6, (Object) "");
            boolean Zc = C1853r.m3849Zc();
            C4990ab.m7410d("MicorMsg.MainFrameBannerStorage", "isUpload " + Zc + " stat " + C1853r.m3822YD());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                c32777a = C32777a.NO_INIT;
                AppMethodBeat.m2505o(16338);
                return c32777a;
            } else if (str != null && str2 == null) {
                c32777a = C32777a.SET_MOBILE;
                AppMethodBeat.m2505o(16338);
                return c32777a;
            } else if (Zc) {
                c32777a = C32777a.SUCC;
                AppMethodBeat.m2505o(16338);
                return c32777a;
            } else {
                c32777a = C32777a.SUCC_UNLOAD;
                AppMethodBeat.m2505o(16338);
                return c32777a;
            }
        } catch (Exception e) {
            c32777a = C32777a.NO_INIT;
            AppMethodBeat.m2505o(16338);
            return c32777a;
        }
    }

    /* renamed from: a */
    public final boolean mo53321a(C37903bd c37903bd) {
        boolean z = true;
        AppMethodBeat.m2504i(16331);
        if (c37903bd.type == Downloads.MIN_WAIT_FOR_NETWORK) {
            C32776be.m53539ZX();
            if (this.fmc != null) {
                this.fmc.mo31111ZZ();
            }
            AppMethodBeat.m2505o(16331);
            return true;
        } else if (c37903bd.type == 57005) {
            AppMethodBeat.m2505o(16331);
            return false;
        } else {
            C9638aw.m17190ZK();
            SharedPreferences lK = C18628c.m29106lK("banner");
            if (lK == null) {
                AppMethodBeat.m2505o(16331);
                return false;
            }
            Editor edit = lK.edit();
            C37903bd ZW = C32776be.m53538ZW();
            if (C32776be.m53541b(c37903bd)) {
                z = false;
            }
            if (ZW != null && ZW.showType == 2) {
                List ov = C32776be.m53543ov("HistoryInfo");
                if (!ov.contains(Integer.valueOf(ZW.type))) {
                    ov.add(Integer.valueOf(ZW.type));
                }
                C32776be.m53542f("HistoryInfo", ov);
            }
            if (z) {
                edit.putInt("CurrentType", c37903bd.type).putInt("CurrentShowType", c37903bd.showType).putString("CurrentData", c37903bd.data).commit();
            }
            if (this.fmc != null) {
                this.fmc.mo31111ZZ();
            }
            AppMethodBeat.m2505o(16331);
            return z;
        }
    }
}
