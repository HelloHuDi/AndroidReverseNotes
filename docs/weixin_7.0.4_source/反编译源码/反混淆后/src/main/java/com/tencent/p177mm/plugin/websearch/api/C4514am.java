package com.tencent.p177mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.websearch.api.am */
public final class C4514am {
    private static C4514am uaT = new C4514am();
    public C4515a uaS = new C4515a();

    /* renamed from: com.tencent.mm.plugin.websearch.api.am$a */
    public static class C4515a {
        public String cIY;
        public int clear;
        public long fJB = System.currentTimeMillis();
        /* renamed from: id */
        public String f1288id;
        public long oak;
        public int tZU;
        public String text;
        public long timestamp;
        public int type;
        public int uaU;
        public int uaV;
        public int uaW;
        int uaX;

        public C4515a() {
            AppMethodBeat.m2504i(124206);
            AppMethodBeat.m2505o(124206);
        }

        public final boolean isValid() {
            AppMethodBeat.m2504i(124207);
            if (this.clear == 1) {
                AppMethodBeat.m2505o(124207);
                return false;
            } else if (this.uaV > C7243d.vxo) {
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", this.f1288id, Integer.valueOf(this.uaV), Integer.valueOf(C7243d.vxo));
                AppMethodBeat.m2505o(124207);
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
                    C4990ab.m7417i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", this.f1288id);
                    AppMethodBeat.m2505o(124207);
                    return false;
                }
                String str = "MicroMsg.WebSearch.WebSearchRedPointMgr";
                String str2 = this.uaU + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
                Object[] objArr = new Object[5];
                if (C46400aa.m87305HV(0) >= this.tZU) {
                    i2 = true;
                } else {
                    i2 = false;
                }
                objArr[0] = Boolean.valueOf(i2);
                objArr[1] = Integer.valueOf(this.tZU);
                objArr[2] = Integer.valueOf(C46400aa.m87305HV(0));
                objArr[3] = Long.valueOf(this.timestamp);
                objArr[4] = Long.valueOf(C4514am.cVu());
                C4990ab.m7417i(str, str2, objArr);
                if (C46400aa.m87305HV(0) < this.tZU || this.timestamp <= C4514am.cVu()) {
                    AppMethodBeat.m2505o(124207);
                    return false;
                }
                AppMethodBeat.m2505o(124207);
                return true;
            }
        }

        /* Access modifiers changed, original: final */
        public final String aDu() {
            AppMethodBeat.m2504i(124208);
            String str = this.f1288id + "&" + this.uaU + "&" + this.uaV + "&" + this.oak + "&" + this.tZU + "&" + this.type + "&" + this.text + "&" + this.cIY + "&" + this.timestamp + "&" + this.uaW + "&" + this.fJB + "&" + this.uaX;
            AppMethodBeat.m2505o(124208);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(124212);
        AppMethodBeat.m2505o(124212);
    }

    public static C4514am cVt() {
        return uaT;
    }

    private C4514am() {
        AppMethodBeat.m2504i(124209);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, (Object) "");
        C4515a c4515a = this.uaS;
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                c4515a.f1288id = C5046bo.m7584t(split[0], new Object[0]);
                c4515a.uaU = C5046bo.ank(split[1]);
                c4515a.uaV = C5046bo.ank(split[2]);
                c4515a.oak = C5046bo.anl(split[3]);
                c4515a.tZU = C5046bo.ank(split[4]);
                c4515a.type = C5046bo.ank(split[5]);
                c4515a.text = split[6];
                c4515a.cIY = split[7];
                c4515a.timestamp = C5046bo.anl(split[8]);
                c4515a.uaW = C5046bo.ank(split[9]);
                c4515a.fJB = C5046bo.anl(split[10]);
                c4515a.uaX = C5046bo.ank(split[11]);
            }
            AppMethodBeat.m2505o(124209);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(124209);
        }
    }

    public final void save() {
        AppMethodBeat.m2504i(124210);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FTS_DISCOVERY_RED_XML_STRING, this.uaS == null ? "" : this.uaS.aDu());
        AppMethodBeat.m2505o(124210);
    }

    public static long cVu() {
        AppMethodBeat.m2504i(124211);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SEARCH_REDDOT_LONG, null);
        if (obj == null) {
            AppMethodBeat.m2505o(124211);
            return 0;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.m2505o(124211);
        return longValue;
    }
}
