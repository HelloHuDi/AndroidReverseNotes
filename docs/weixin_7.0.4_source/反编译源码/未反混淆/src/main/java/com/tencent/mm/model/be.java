package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

public class be {
    private static be fmd;
    public b fmc;

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD;

        static {
            AppMethodBeat.o(16329);
        }
    }

    public interface b {
        void ZZ();
    }

    public static be ZV() {
        AppMethodBeat.i(16330);
        synchronized (be.class) {
            try {
                if (fmd == null) {
                    fmd = new be();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(16330);
            }
        }
        be beVar = fmd;
        return beVar;
    }

    private be() {
    }

    public static bd ZW() {
        AppMethodBeat.i(16332);
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null) {
            AppMethodBeat.o(16332);
            return null;
        }
        int i = lK.getInt("CurrentType", -1);
        int i2 = lK.getInt("CurrentShowType", -1);
        String string = lK.getString("CurrentData", "");
        if (i != -1) {
            switch (i) {
                case 1:
                    a ZY = ZY();
                    if (ZY == a.SUCC || ZY == a.SUCC_UNLOAD || g.aaK().aaI()) {
                        if (g.aaK().aaI()) {
                            ab.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                        } else {
                            ab.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                        }
                        AppMethodBeat.o(16332);
                        return null;
                    }
                case 2:
                    if (ZY() == a.SUCC || g.aaK().aaI()) {
                        if (g.aaK().aaI()) {
                            ab.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                        } else {
                            ab.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                        }
                        AppMethodBeat.o(16332);
                        return null;
                    }
                case 3:
                    ab.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                    AppMethodBeat.o(16332);
                    return null;
                case 11:
                    AppMethodBeat.o(16332);
                    return null;
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                case 57005:
                    AppMethodBeat.o(16332);
                    return null;
            }
            bd bdVar = new bd(i, i2, string);
            AppMethodBeat.o(16332);
            return bdVar;
        }
        AppMethodBeat.o(16332);
        return null;
    }

    public final void co(int i, int i2) {
        AppMethodBeat.i(16333);
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null) {
            AppMethodBeat.o(16333);
            return;
        }
        Editor edit = lK.edit();
        switch (i2) {
            case 1:
                edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                break;
            case 2:
                edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                List ov = ov("HistoryInfo");
                if (!ov.contains(Integer.valueOf(i))) {
                    ov.add(Integer.valueOf(i));
                }
                f("HistoryInfo", ov);
                break;
            case 3:
                if (i == 3) {
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                }
                break;
        }
        if (this.fmc != null) {
            this.fmc.ZZ();
        }
        AppMethodBeat.o(16333);
    }

    private static boolean ZX() {
        AppMethodBeat.i(16334);
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null || !lK.edit().clear().commit()) {
            AppMethodBeat.o(16334);
            return false;
        }
        AppMethodBeat.o(16334);
        return true;
    }

    private static boolean b(bd bdVar) {
        AppMethodBeat.i(16335);
        boolean contains = ov("HistoryInfo").contains(Integer.valueOf(bdVar.type));
        AppMethodBeat.o(16335);
        return contains;
    }

    private static boolean f(String str, List<Integer> list) {
        boolean z = false;
        AppMethodBeat.i(16336);
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null) {
            AppMethodBeat.o(16336);
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
                AppMethodBeat.o(16336);
                return z;
            }
        }
    }

    private static List<Integer> ov(String str) {
        AppMethodBeat.i(16337);
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null) {
            AppMethodBeat.o(16337);
            return null;
        }
        int i = lK.getInt(str + "ArraySize", 0);
        List<Integer> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(lK.getInt(str + i2, 0)));
        }
        AppMethodBeat.o(16337);
        return arrayList;
    }

    public static a ZY() {
        AppMethodBeat.i(16338);
        a aVar;
        try {
            aw.ZK();
            String str = (String) c.Ry().get(4097, (Object) "");
            aw.ZK();
            String str2 = (String) c.Ry().get(6, (Object) "");
            boolean Zc = r.Zc();
            ab.d("MicorMsg.MainFrameBannerStorage", "isUpload " + Zc + " stat " + r.YD());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                aVar = a.NO_INIT;
                AppMethodBeat.o(16338);
                return aVar;
            } else if (str != null && str2 == null) {
                aVar = a.SET_MOBILE;
                AppMethodBeat.o(16338);
                return aVar;
            } else if (Zc) {
                aVar = a.SUCC;
                AppMethodBeat.o(16338);
                return aVar;
            } else {
                aVar = a.SUCC_UNLOAD;
                AppMethodBeat.o(16338);
                return aVar;
            }
        } catch (Exception e) {
            aVar = a.NO_INIT;
            AppMethodBeat.o(16338);
            return aVar;
        }
    }

    public final boolean a(bd bdVar) {
        boolean z = true;
        AppMethodBeat.i(16331);
        if (bdVar.type == Downloads.MIN_WAIT_FOR_NETWORK) {
            ZX();
            if (this.fmc != null) {
                this.fmc.ZZ();
            }
            AppMethodBeat.o(16331);
            return true;
        } else if (bdVar.type == 57005) {
            AppMethodBeat.o(16331);
            return false;
        } else {
            aw.ZK();
            SharedPreferences lK = c.lK("banner");
            if (lK == null) {
                AppMethodBeat.o(16331);
                return false;
            }
            Editor edit = lK.edit();
            bd ZW = ZW();
            if (b(bdVar)) {
                z = false;
            }
            if (ZW != null && ZW.showType == 2) {
                List ov = ov("HistoryInfo");
                if (!ov.contains(Integer.valueOf(ZW.type))) {
                    ov.add(Integer.valueOf(ZW.type));
                }
                f("HistoryInfo", ov);
            }
            if (z) {
                edit.putInt("CurrentType", bdVar.type).putInt("CurrentShowType", bdVar.showType).putString("CurrentData", bdVar.data).commit();
            }
            if (this.fmc != null) {
                this.fmc.ZZ();
            }
            AppMethodBeat.o(16331);
            return z;
        }
    }
}
