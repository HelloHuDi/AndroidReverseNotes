package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class b {
    private static String TAG = "MicroMsg.ExptManager";
    private static b lOP;
    private f<Integer, a> lNH = new h(50);
    private String name = null;

    public static b brr() {
        AppMethodBeat.i(93274);
        if (lOP == null) {
            lOP = new b();
        }
        b bVar = lOP;
        AppMethodBeat.o(93274);
        return bVar;
    }

    protected b() {
        AppMethodBeat.i(93275);
        AppMethodBeat.o(93275);
    }

    private int Lb(String str) {
        AppMethodBeat.i(138273);
        as brs = brs();
        if (brs == null) {
            AppMethodBeat.o(138273);
            return -1;
        }
        int i = brs.getInt(str, -1);
        AppMethodBeat.o(138273);
        return i;
    }

    private a vc(int i) {
        AppMethodBeat.i(138274);
        if (i <= 0) {
            AppMethodBeat.o(138274);
            return null;
        }
        as brs = brs();
        if (brs == null) {
            AppMethodBeat.o(138274);
            return null;
        }
        String string = brs.getString(String.valueOf(i), "");
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(138274);
            return null;
        }
        a aVar = (a) this.lNH.get(Integer.valueOf(i));
        if (aVar != null) {
            if (bo.isEqual(string, aVar.field_exptContent)) {
                AppMethodBeat.o(138274);
                return aVar;
            }
            this.lNH.remove(Integer.valueOf(i));
        }
        aVar = new a();
        if (aVar.La(string)) {
            this.lNH.put(Integer.valueOf(i), aVar);
        } else {
            aVar = null;
        }
        AppMethodBeat.o(138274);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String b(String str, String str2, boolean z, boolean z2) {
        String str3;
        AppMethodBeat.i(93277);
        int Lb = Lb(str);
        if (Lb > 0) {
            a vc = vc(Lb);
            if (vc != null && vc.isReady()) {
                HashMap brq = vc.brq();
                if (!(brq == null || brq.isEmpty())) {
                    str3 = (String) brq.get(str);
                    if (z) {
                        a(vc, str, str3);
                    }
                    if (z2) {
                        ab.i(TAG, "%s get mulit expt result[%s] key[%s] def[%s]", aZm(), str3, str, str2);
                    }
                    AppMethodBeat.o(93277);
                    return str3;
                }
            }
        }
        str3 = str2;
        if (z2) {
        }
        AppMethodBeat.o(93277);
        return str3;
    }

    private static void a(a aVar, String str, String str2) {
        AppMethodBeat.i(138275);
        e.pXa.e(15452, Integer.valueOf(aVar.field_exptId), Integer.valueOf(aVar.field_groupId), Integer.valueOf(aVar.field_exptSeq), Long.valueOf(aVar.field_startTime), Long.valueOf(aVar.field_endTime), str, str2);
        AppMethodBeat.o(138275);
    }

    private String aZm() {
        AppMethodBeat.i(93278);
        String str = hashCode();
        AppMethodBeat.o(93278);
        return str;
    }

    public final as brs() {
        AppMethodBeat.i(93276);
        int i = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getInt("default_uin", 0);
        if (i == 0) {
            AppMethodBeat.o(93276);
            return null;
        }
        String str = i + "_WxExptmmkv";
        if (!bo.isEqual(this.name, str)) {
            ab.i(TAG, "%s get mmkv change uin old[%s] new[%s]", aZm(), this.name, str);
            this.name = str;
        }
        as amF = as.amF(this.name);
        AppMethodBeat.o(93276);
        return amF;
    }
}
