package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.tencent.xweb.a.a di(Object obj) {
        com.tencent.xweb.a.a aVar;
        Object obj2 = null;
        synchronized (a.class) {
            AppMethodBeat.i(85120);
            aVar = new com.tencent.xweb.a.a();
            if (obj == null || !(obj instanceof com.tencent.xweb.c.a.a)) {
                AppMethodBeat.o(85120);
            } else {
                String str;
                com.tencent.xweb.c.a.a aVar2 = (com.tencent.xweb.c.a.a) obj;
                String str2 = aVar2.AOL;
                String str3 = aVar2.AOM;
                if (aVar2.AOL.equals("executeCommand")) {
                    String[] avb = com.tencent.xweb.a.avb(aVar2.AOM);
                    if (avb == null || avb.length < 2) {
                        AppMethodBeat.o(85120);
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
                        aVar.ALP = true;
                        try {
                            n.aE(XWalkEnvironment.getApplicationContext(), Integer.parseInt(str));
                            AppMethodBeat.o(85120);
                            break;
                        } catch (Exception e) {
                            Log.e("ConfigCmdProc", "parse revertapk cmdvalue to int failed , value is ".concat(String.valueOf(str)));
                            AppMethodBeat.o(85120);
                            break;
                        }
                    case 1:
                        aVar.ALP = true;
                        n.dVL();
                        break;
                }
                AppMethodBeat.o(85120);
            }
        }
        return aVar;
    }
}
