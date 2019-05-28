package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public boolean cwB = true;
    public String nJy = "";
    public int qPO = 0;
    public List<a> qPP = new ArrayList();
    public String qPm = "";
    public String qPn = "";
    public String qQb = "";
    public int[] qQc;

    public h() {
        AppMethodBeat.i(36812);
        AppMethodBeat.o(36812);
    }

    public final boolean coC() {
        AppMethodBeat.i(36813);
        if (!this.cwB || this.qPP == null || this.qPP.size() <= 0) {
            AppMethodBeat.o(36813);
            return false;
        }
        AppMethodBeat.o(36813);
        return true;
    }

    public final boolean h(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(36814);
        this.qPn = str;
        this.qPm = str2;
        if (map == null) {
            AppMethodBeat.o(36814);
        } else {
            try {
                this.qPP.clear();
                this.nJy = bo.bc((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.qQb = bo.bc((String) map.get("first_step_order"), "");
                String[] split = this.qQb.split("\\|");
                this.qQc = new int[split.length];
                if (this.qQc.length == 0) {
                    this.cwB = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.qQc[i] = bo.ank(split[i]);
                    if (this.qQc[i] <= 0 || this.qQc[i] > 3) {
                        this.cwB = false;
                    }
                    i++;
                }
                int ank = bo.ank((String) map.get("wording_count"));
                int ank2 = bo.ank((String) map.get("expertype"));
                for (int i2 = 0; i2 < ank; i2++) {
                    a aVar = new a();
                    aVar.qOF = bo.ank((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    aVar.qOG = bo.bc((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.qOH = bo.bc((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.qOI = bo.bc((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.qOJ = bo.ank((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.qPP.add(aVar);
                }
                ab.i("MicroMsg.SnsAdAbTestInfo", "expertType " + ank2 + " " + str + " " + this.qQb);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
            AppMethodBeat.o(36814);
        }
        return false;
    }
}
