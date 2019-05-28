package com.tencent.p177mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C1763c;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.scanner.a */
public final class C13119a {

    /* renamed from: com.tencent.mm.plugin.scanner.a$a */
    static class C13120a implements C45413i<Bundle, Bundle> {
        private C13120a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(79164);
            Bundle bundle = new Bundle();
            Set aIR = C13119a.aIR();
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
            AppMethodBeat.m2505o(79164);
            return bundle;
        }
    }

    static /* synthetic */ Set aIR() {
        AppMethodBeat.m2504i(79168);
        Set cgw = C13119a.cgw();
        AppMethodBeat.m2505o(79168);
        return cgw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (com.tencent.p177mm.ipcinvoker.C32710b.m53380PL().mo53222le("com.tencent.mm") == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ba */
    public static boolean m21150ba(int i, String str) {
        AppMethodBeat.m2504i(79165);
        if (i != 22) {
            AppMethodBeat.m2505o(79165);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79165);
            return false;
        } else {
            if (!C4996ah.bqo()) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                }
                HashSet hashSet = new HashSet();
                String[] split = C13119a.cgv().split("|");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!C5046bo.isNullOrNil(split[i2])) {
                        hashSet.add(split[i2]);
                    }
                }
                Object obj = hashSet;
                for (String startsWith : obj) {
                    if (str.startsWith(startsWith)) {
                        AppMethodBeat.m2505o(79165);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(79165);
                return false;
            }
            Set obj2 = C13119a.cgw();
            while (r2.hasNext()) {
            }
            AppMethodBeat.m2505o(79165);
            return false;
        }
    }

    /* renamed from: BQ */
    public static boolean m21148BQ(int i) {
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

    /* renamed from: BR */
    public static boolean m21149BR(int i) {
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
        AppMethodBeat.m2504i(79166);
        Bundle bundle = (Bundle) C9549f.m17010a("com.tencent.mm", null, C13120a.class);
        String str = "";
        if (bundle != null) {
            string = bundle.getString("wxCodePrefix", "");
        } else {
            string = str;
        }
        AppMethodBeat.m2505o(79166);
        return string;
    }

    private static Set<String> cgw() {
        AppMethodBeat.m2504i(79167);
        HashSet hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (C4996ah.bqo()) {
            String O;
            String str = "";
            C1763c Nv = ((C7234a) C1720g.m3528K(C7234a.class)).mo15609Nv();
            if (Nv != null) {
                O = Nv.mo5301O("ScanCode", "weAppCodePrefix");
            } else {
                O = str;
            }
            C4990ab.m7419v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", O);
            if (!C5046bo.isNullOrNil(O)) {
                String[] split = O.split("|");
                for (int i = 0; i < split.length; i++) {
                    if (!C5046bo.isNullOrNil(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(79167);
        return hashSet;
    }
}
