package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public boolean cwB = true;
    public String nJy = "";
    public int qPO = 0;
    public List<b> qPP = new ArrayList();
    public String qPm = "";
    public String qPn = "";

    static class a {
        public int actionType;
        public int index;
        public String jumpUrl;
        public String qPQ;
        public String qPR;
        public int qPS;

        a() {
        }
    }

    static class b {
        public List<a> hhZ = new ArrayList();
        public int qPT;
        public int showType;
        public String title;

        b() {
            AppMethodBeat.i(36801);
            AppMethodBeat.o(36801);
        }
    }

    public d() {
        AppMethodBeat.i(36802);
        AppMethodBeat.o(36802);
    }

    public final boolean h(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(36803);
        this.qPn = str;
        this.qPm = str2;
        if (map == null) {
            AppMethodBeat.o(36803);
            return false;
        }
        try {
            this.qPP.clear();
            this.nJy = bo.bc((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
            if (!this.nJy.equals("zh_cn")) {
                this.cwB = false;
            }
            int ank = bo.ank((String) map.get("tipcount"));
            int ank2 = bo.ank((String) map.get("expertype"));
            for (int i = 0; i < ank; i++) {
                b bVar = new b();
                bVar.title = bo.bc((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                bVar.qPT = bo.ank((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                bVar.showType = bo.ank((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                int ank3 = bo.ank((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                if (bVar.showType >= 6) {
                    this.cwB = false;
                }
                for (int i2 = 0; i2 < ank3; i2++) {
                    a aVar = new a();
                    aVar.index = bo.ank((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                    aVar.actionType = bo.ank((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                    aVar.qPQ = bo.bc((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                    aVar.jumpUrl = bo.bc((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                    aVar.qPR = bo.bc((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                    aVar.qPS = bo.ank((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                    if (aVar.actionType >= 9) {
                        this.cwB = false;
                    }
                    bVar.hhZ.add(aVar);
                }
                this.qPP.add(bVar);
            }
            ab.i("Micromsg.SnsABTestInfo", "expertType " + ank2 + " " + str);
        } catch (Exception e) {
            ab.printErrStackTrace("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
        }
        AppMethodBeat.o(36803);
        return false;
    }
}
