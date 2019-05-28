package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class am {
    private static am uaT = new am();
    public a uaS = new a();

    public static class a {
        public String cIY;
        public int clear;
        public long fJB = System.currentTimeMillis();
        public String id;
        public long oak;
        public int tZU;
        public String text;
        public long timestamp;
        public int type;
        public int uaU;
        public int uaV;
        public int uaW;
        int uaX;

        public a() {
            AppMethodBeat.i(124206);
            AppMethodBeat.o(124206);
        }

        public final boolean isValid() {
            AppMethodBeat.i(124207);
            if (this.clear == 1) {
                AppMethodBeat.o(124207);
                return false;
            } else if (this.uaV > d.vxo) {
                ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", this.id, Integer.valueOf(this.uaV), Integer.valueOf(d.vxo));
                AppMethodBeat.o(124207);
                return false;
            } else {
                int i;
                boolean i2;
                if (System.currentTimeMillis() > this.fJB + (this.oak * 1000)) {
                    i2 = 1;
                } else {
                    i2 = false;
                }
                if (i2 != 0) {
                    ab.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", this.id);
                    AppMethodBeat.o(124207);
                    return false;
                }
                String str = "MicroMsg.WebSearch.WebSearchRedPointMgr";
                String str2 = this.uaU + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
                Object[] objArr = new Object[5];
                if (aa.HV(0) >= this.tZU) {
                    i2 = true;
                } else {
                    i2 = false;
                }
                objArr[0] = Boolean.valueOf(i2);
                objArr[1] = Integer.valueOf(this.tZU);
                objArr[2] = Integer.valueOf(aa.HV(0));
                objArr[3] = Long.valueOf(this.timestamp);
                objArr[4] = Long.valueOf(am.cVu());
                ab.i(str, str2, objArr);
                if (aa.HV(0) < this.tZU || this.timestamp <= am.cVu()) {
                    AppMethodBeat.o(124207);
                    return false;
                }
                AppMethodBeat.o(124207);
                return true;
            }
        }

        /* Access modifiers changed, original: final */
        public final String aDu() {
            AppMethodBeat.i(124208);
            String str = this.id + "&" + this.uaU + "&" + this.uaV + "&" + this.oak + "&" + this.tZU + "&" + this.type + "&" + this.text + "&" + this.cIY + "&" + this.timestamp + "&" + this.uaW + "&" + this.fJB + "&" + this.uaX;
            AppMethodBeat.o(124208);
            return str;
        }
    }

    static {
        AppMethodBeat.i(124212);
        AppMethodBeat.o(124212);
    }

    public static am cVt() {
        return uaT;
    }

    private am() {
        AppMethodBeat.i(124209);
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, (Object) "");
        a aVar = this.uaS;
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                aVar.id = bo.t(split[0], new Object[0]);
                aVar.uaU = bo.ank(split[1]);
                aVar.uaV = bo.ank(split[2]);
                aVar.oak = bo.anl(split[3]);
                aVar.tZU = bo.ank(split[4]);
                aVar.type = bo.ank(split[5]);
                aVar.text = split[6];
                aVar.cIY = split[7];
                aVar.timestamp = bo.anl(split[8]);
                aVar.uaW = bo.ank(split[9]);
                aVar.fJB = bo.anl(split[10]);
                aVar.uaX = bo.ank(split[11]);
            }
            AppMethodBeat.o(124209);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", e, "", new Object[0]);
            AppMethodBeat.o(124209);
        }
    }

    public final void save() {
        AppMethodBeat.i(124210);
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, this.uaS == null ? "" : this.uaS.aDu());
        AppMethodBeat.o(124210);
    }

    public static long cVu() {
        AppMethodBeat.i(124211);
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SEARCH_REDDOT_LONG, null);
        if (obj == null) {
            AppMethodBeat.o(124211);
            return 0;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(124211);
        return longValue;
    }
}
