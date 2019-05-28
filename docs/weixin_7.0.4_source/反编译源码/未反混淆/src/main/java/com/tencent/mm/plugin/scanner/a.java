package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a {

    static class a implements i<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(79164);
            Bundle bundle = new Bundle();
            Set aIR = a.aIR();
            StringBuilder stringBuilder = new StringBuilder();
            if (!(aIR == null || aIR.isEmpty())) {
                Iterator it = aIR.iterator();
                stringBuilder.append((String) it.next());
                while (it.hasNext()) {
                    stringBuilder.append("|");
                    stringBuilder.append((String) it.next());
                }
                bundle.putString("wxCodePrefix", stringBuilder.toString());
            }
            AppMethodBeat.o(79164);
            return bundle;
        }
    }

    static /* synthetic */ Set aIR() {
        AppMethodBeat.i(79168);
        Set cgw = cgw();
        AppMethodBeat.o(79168);
        return cgw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (com.tencent.mm.ipcinvoker.b.PL().le("com.tencent.mm") == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ba(int i, String str) {
        AppMethodBeat.i(79165);
        if (i != 22) {
            AppMethodBeat.o(79165);
            return false;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79165);
            return false;
        } else {
            if (!ah.bqo()) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                }
                HashSet hashSet = new HashSet();
                String[] split = cgv().split("|");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!bo.isNullOrNil(split[i2])) {
                        hashSet.add(split[i2]);
                    }
                }
                Object obj = hashSet;
                for (String startsWith : obj) {
                    if (str.startsWith(startsWith)) {
                        AppMethodBeat.o(79165);
                        return true;
                    }
                }
                AppMethodBeat.o(79165);
                return false;
            }
            Set obj2 = cgw();
            while (r2.hasNext()) {
            }
            AppMethodBeat.o(79165);
            return false;
        }
    }

    public static boolean BQ(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    public static boolean BR(int i) {
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    private static String cgv() {
        String string;
        AppMethodBeat.i(79166);
        Bundle bundle = (Bundle) f.a("com.tencent.mm", null, a.class);
        String str = "";
        if (bundle != null) {
            string = bundle.getString("wxCodePrefix", "");
        } else {
            string = str;
        }
        AppMethodBeat.o(79166);
        return string;
    }

    private static Set<String> cgw() {
        AppMethodBeat.i(79167);
        HashSet hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (ah.bqo()) {
            String O;
            String str = "";
            c Nv = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nv();
            if (Nv != null) {
                O = Nv.O("ScanCode", "weAppCodePrefix");
            } else {
                O = str;
            }
            ab.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", O);
            if (!bo.isNullOrNil(O)) {
                String[] split = O.split("|");
                for (int i = 0; i < split.length; i++) {
                    if (!bo.isNullOrNil(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        AppMethodBeat.o(79167);
        return hashSet;
    }
}
