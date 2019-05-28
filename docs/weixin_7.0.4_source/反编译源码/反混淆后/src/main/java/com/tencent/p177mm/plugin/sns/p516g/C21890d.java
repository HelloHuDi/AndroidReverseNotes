package com.tencent.p177mm.plugin.sns.p516g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.g.d */
public final class C21890d {
    public boolean cwB = true;
    public String nJy = "";
    public int qPO = 0;
    public List<C21892b> qPP = new ArrayList();
    public String qPm = "";
    public String qPn = "";

    /* renamed from: com.tencent.mm.plugin.sns.g.d$a */
    static class C21891a {
        public int actionType;
        public int index;
        public String jumpUrl;
        public String qPQ;
        public String qPR;
        public int qPS;

        C21891a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.g.d$b */
    static class C21892b {
        public List<C21891a> hhZ = new ArrayList();
        public int qPT;
        public int showType;
        public String title;

        C21892b() {
            AppMethodBeat.m2504i(36801);
            AppMethodBeat.m2505o(36801);
        }
    }

    public C21890d() {
        AppMethodBeat.m2504i(36802);
        AppMethodBeat.m2505o(36802);
    }

    /* renamed from: h */
    public final boolean mo37376h(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(36803);
        this.qPn = str;
        this.qPm = str2;
        if (map == null) {
            AppMethodBeat.m2505o(36803);
            return false;
        }
        try {
            this.qPP.clear();
            this.nJy = C5046bo.m7532bc((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
            if (!this.nJy.equals("zh_cn")) {
                this.cwB = false;
            }
            int ank = C5046bo.ank((String) map.get("tipcount"));
            int ank2 = C5046bo.ank((String) map.get("expertype"));
            for (int i = 0; i < ank; i++) {
                C21892b c21892b = new C21892b();
                c21892b.title = C5046bo.m7532bc((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                c21892b.qPT = C5046bo.ank((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                c21892b.showType = C5046bo.ank((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                int ank3 = C5046bo.ank((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                if (c21892b.showType >= 6) {
                    this.cwB = false;
                }
                for (int i2 = 0; i2 < ank3; i2++) {
                    C21891a c21891a = new C21891a();
                    c21891a.index = C5046bo.ank((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                    c21891a.actionType = C5046bo.ank((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                    c21891a.qPQ = C5046bo.m7532bc((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                    c21891a.jumpUrl = C5046bo.m7532bc((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                    c21891a.qPR = C5046bo.m7532bc((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                    c21891a.qPS = C5046bo.ank((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                    if (c21891a.actionType >= 9) {
                        this.cwB = false;
                    }
                    c21892b.hhZ.add(c21891a);
                }
                this.qPP.add(c21892b);
            }
            C4990ab.m7416i("Micromsg.SnsABTestInfo", "expertType " + ank2 + " " + str);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
        }
        AppMethodBeat.m2505o(36803);
        return false;
    }
}
