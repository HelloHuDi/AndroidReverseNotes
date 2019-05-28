package com.tencent.p177mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.protocal.protobuf.bdi;
import com.tencent.p177mm.protocal.protobuf.bdj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.websearch.api.ai */
public final class C35573ai {
    public static bdj uaA;

    /* renamed from: com.tencent.mm.plugin.websearch.api.ai$1 */
    static class C355721 implements Comparator<bdi> {
        C355721() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            bdi bdi = (bdi) obj;
            bdi bdi2 = (bdi) obj2;
            if (bdi.wHm > bdi2.wHm) {
                return 1;
            }
            if (bdi.wHm < bdi2.wHm) {
                return -1;
            }
            return 0;
        }
    }

    public static bdj cVo() {
        AppMethodBeat.m2504i(124174);
        if (uaA == null) {
            String cVl = C35573ai.cVl();
            uaA = new bdj();
            cVl = C4996ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(cVl, "");
            if (!C5046bo.isNullOrNil(cVl)) {
                try {
                    uaA.parseFrom(Base64.decode(cVl.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            uaA.jBw.clear();
        }
        bdj bdj = uaA;
        AppMethodBeat.m2505o(124174);
        return bdj;
    }

    public static String cVl() {
        AppMethodBeat.m2504i(124175);
        String str = "key_pb_most_search_biz_list" + C1853r.m3846Yz();
        AppMethodBeat.m2505o(124175);
        return str;
    }

    public static void adO(String str) {
        AppMethodBeat.m2504i(124176);
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            AppMethodBeat.m2505o(124176);
        } else if (C1855t.m3913mZ(str)) {
            bdi bdi;
            SharedPreferences sharedPreferences;
            if (uaA == null) {
                C35573ai.cVo();
            }
            long currentTimeMillis = System.currentTimeMillis();
            bdi bdi2 = null;
            int i = 0;
            while (i < uaA.jBw.size()) {
                bdi = (bdi) uaA.jBw.get(i);
                long j = (currentTimeMillis - bdi.wHn) / 86400000;
                bdi.wHm *= Math.pow(0.98d, (double) j);
                bdi.wHn = (j * 86400000) + bdi.wHn;
                C4990ab.m7411d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", Double.valueOf(bdi.wHm), Long.valueOf(bdi.wHn), bdi.vHl);
                if (!bdi.vHl.equals(str)) {
                    bdi = bdi2;
                }
                i++;
                bdi2 = bdi;
            }
            if (bdi2 == null) {
                bdi = new bdi();
                bdi.wHm = 1.0d;
                bdi.wHn = currentTimeMillis;
                bdi.vHl = str;
                uaA.jBw.add(bdi);
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", str);
            } else {
                bdi2.wHm += 1.0d;
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", str, Double.valueOf(bdi2.wHm));
            }
            Collections.sort(uaA.jBw, new C355721());
            int size = uaA.jBw.size() - 1;
            while (true) {
                int i2 = size;
                if (i2 >= uaA.jBw.size() || uaA.jBw.size() <= 8) {
                    sharedPreferences = C4996ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
                } else {
                    if (((bdi) uaA.jBw.get(i2)).wHm < 0.5d) {
                        uaA.jBw.remove(i2);
                    }
                    size = i2 + 1;
                }
            }
            sharedPreferences = C4996ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(C35573ai.cVl(), Base64.encodeToString(uaA.toByteArray(), 0)).commit();
                C4990ab.m7417i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", r2);
                AppMethodBeat.m2505o(124176);
            } catch (IOException e) {
                AppMethodBeat.m2505o(124176);
            }
        } else {
            AppMethodBeat.m2505o(124176);
        }
    }
}
