package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.C44572a.C41118a;
import com.tencent.xweb.p1115c.C46831a.C16383a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.xwalk.a */
public final class C16408a {
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: di */
    public static synchronized C41118a m25219di(Object obj) {
        C41118a c41118a;
        Object obj2 = null;
        synchronized (C16408a.class) {
            AppMethodBeat.m2504i(85120);
            c41118a = new C41118a();
            if (obj == null || !(obj instanceof C16383a)) {
                AppMethodBeat.m2505o(85120);
            } else {
                String str;
                C16383a c16383a = (C16383a) obj;
                String str2 = c16383a.AOL;
                String str3 = c16383a.AOM;
                if (c16383a.AOL.equals("executeCommand")) {
                    String[] avb = C44572a.avb(c16383a.AOM);
                    if (avb == null || avb.length < 2) {
                        AppMethodBeat.m2505o(85120);
                    } else {
                        str2 = avb[0];
                        str = avb[1];
                    }
                } else {
                    str = str3;
                }
                switch (str2.hashCode()) {
                    case -844092179:
                        if (str2.equals("fix_dex")) {
                            int obj22 = 1;
                            break;
                        }
                    case 1108642905:
                        if (str2.equals("revertToVersion")) {
                            break;
                        }
                    default:
                        obj22 = -1;
                        break;
                }
                switch (obj22) {
                    case null:
                        c41118a.ALP = true;
                        try {
                            C46946n.m89796aE(XWalkEnvironment.getApplicationContext(), Integer.parseInt(str));
                            AppMethodBeat.m2505o(85120);
                            break;
                        } catch (Exception e) {
                            Log.m81046e("ConfigCmdProc", "parse revertapk cmdvalue to int failed , value is ".concat(String.valueOf(str)));
                            AppMethodBeat.m2505o(85120);
                            break;
                        }
                    case 1:
                        c41118a.ALP = true;
                        C46946n.dVL();
                        break;
                }
                AppMethodBeat.m2505o(85120);
            }
        }
        return c41118a;
    }
}
