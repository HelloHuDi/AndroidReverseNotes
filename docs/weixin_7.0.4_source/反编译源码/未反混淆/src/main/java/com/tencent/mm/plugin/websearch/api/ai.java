package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public final class ai {
    public static bdj uaA;

    public static bdj cVo() {
        AppMethodBeat.i(124174);
        if (uaA == null) {
            String cVl = cVl();
            uaA = new bdj();
            cVl = ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(cVl, "");
            if (!bo.isNullOrNil(cVl)) {
                try {
                    uaA.parseFrom(Base64.decode(cVl.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        if (b.sO((String) g.RP().Ry().get(274436, null))) {
            uaA.jBw.clear();
        }
        bdj bdj = uaA;
        AppMethodBeat.o(124174);
        return bdj;
    }

    public static String cVl() {
        AppMethodBeat.i(124175);
        String str = "key_pb_most_search_biz_list" + r.Yz();
        AppMethodBeat.o(124175);
        return str;
    }

    public static void adO(String str) {
        AppMethodBeat.i(124176);
        if (b.sO((String) g.RP().Ry().get(274436, null))) {
            AppMethodBeat.o(124176);
        } else if (t.mZ(str)) {
            bdi bdi;
            SharedPreferences sharedPreferences;
            if (uaA == null) {
                cVo();
            }
            long currentTimeMillis = System.currentTimeMillis();
            bdi bdi2 = null;
            int i = 0;
            while (i < uaA.jBw.size()) {
                bdi = (bdi) uaA.jBw.get(i);
                long j = (currentTimeMillis - bdi.wHn) / 86400000;
                bdi.wHm *= Math.pow(0.98d, (double) j);
                bdi.wHn = (j * 86400000) + bdi.wHn;
                ab.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", Double.valueOf(bdi.wHm), Long.valueOf(bdi.wHn), bdi.vHl);
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
                ab.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", str);
            } else {
                bdi2.wHm += 1.0d;
                ab.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", str, Double.valueOf(bdi2.wHm));
            }
            Collections.sort(uaA.jBw, new Comparator<bdi>() {
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
            });
            int size = uaA.jBw.size() - 1;
            while (true) {
                int i2 = size;
                if (i2 >= uaA.jBw.size() || uaA.jBw.size() <= 8) {
                    sharedPreferences = ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
                } else {
                    if (((bdi) uaA.jBw.get(i2)).wHm < 0.5d) {
                        uaA.jBw.remove(i2);
                    }
                    size = i2 + 1;
                }
            }
            sharedPreferences = ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(cVl(), Base64.encodeToString(uaA.toByteArray(), 0)).commit();
                ab.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", r2);
                AppMethodBeat.o(124176);
            } catch (IOException e) {
                AppMethodBeat.o(124176);
            }
        } else {
            AppMethodBeat.o(124176);
        }
    }
}
