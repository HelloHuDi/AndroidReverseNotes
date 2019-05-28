package com.tencent.p177mm.plugin.sns.p516g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.g.h */
public final class C39736h {
    public boolean cwB = true;
    public String nJy = "";
    public int qPO = 0;
    public List<C21882a> qPP = new ArrayList();
    public String qPm = "";
    public String qPn = "";
    public String qQb = "";
    public int[] qQc;

    public C39736h() {
        AppMethodBeat.m2504i(36812);
        AppMethodBeat.m2505o(36812);
    }

    public final boolean coC() {
        AppMethodBeat.m2504i(36813);
        if (!this.cwB || this.qPP == null || this.qPP.size() <= 0) {
            AppMethodBeat.m2505o(36813);
            return false;
        }
        AppMethodBeat.m2505o(36813);
        return true;
    }

    /* renamed from: h */
    public final boolean mo62708h(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(36814);
        this.qPn = str;
        this.qPm = str2;
        if (map == null) {
            AppMethodBeat.m2505o(36814);
        } else {
            try {
                this.qPP.clear();
                this.nJy = C5046bo.m7532bc((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.qQb = C5046bo.m7532bc((String) map.get("first_step_order"), "");
                String[] split = this.qQb.split("\\|");
                this.qQc = new int[split.length];
                if (this.qQc.length == 0) {
                    this.cwB = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.qQc[i] = C5046bo.ank(split[i]);
                    if (this.qQc[i] <= 0 || this.qQc[i] > 3) {
                        this.cwB = false;
                    }
                    i++;
                }
                int ank = C5046bo.ank((String) map.get("wording_count"));
                int ank2 = C5046bo.ank((String) map.get("expertype"));
                for (int i2 = 0; i2 < ank; i2++) {
                    C21882a c21882a = new C21882a();
                    c21882a.qOF = C5046bo.ank((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    c21882a.qOG = C5046bo.m7532bc((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    c21882a.qOH = C5046bo.m7532bc((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    c21882a.qOI = C5046bo.m7532bc((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    c21882a.qOJ = C5046bo.ank((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.qPP.add(c21882a);
                }
                C4990ab.m7416i("MicroMsg.SnsAdAbTestInfo", "expertType " + ank2 + " " + str + " " + this.qQb);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
            AppMethodBeat.m2505o(36814);
        }
        return false;
    }
}
