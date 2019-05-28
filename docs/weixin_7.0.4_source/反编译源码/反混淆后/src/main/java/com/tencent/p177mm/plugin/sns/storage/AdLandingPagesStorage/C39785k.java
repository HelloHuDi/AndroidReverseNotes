package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k */
public final class C39785k {
    public String cFc;
    public int ecH;
    public long edh;
    public String extra = "";
    public String hxZ;
    public int lgf;
    public int mLz;
    public int meZ;
    public int mfa;
    public String qPj;
    public String qPm;
    public int qXp;
    public int reB;
    public int reC;
    public int reD;
    public int reE;
    public int reF;
    public int reG;
    public int reH;
    private String reI;
    public String reJ;
    public JSONArray reK = new JSONArray();

    public C39785k() {
        AppMethodBeat.m2504i(37782);
        AppMethodBeat.m2505o(37782);
    }

    public final String cqm() {
        String str;
        AppMethodBeat.m2504i(37783);
        this.reI = this.reK.toString();
        C4990ab.m7411d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", this.reI);
        if (!C5046bo.isNullOrNil(this.reI)) {
            try {
                this.reI = URLEncoder.encode(this.reI, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7412e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
        long j = 0;
        try {
            j = C29036i.m46094Xq(this.cFc);
        } catch (Exception e2) {
            C4990ab.m7413e("AdLandingPagesReportInfo", "", e2);
        }
        StringBuilder append = new StringBuilder().append(C29036i.m46117jV(j)).append(",").append(this.qPj).append(",").append(this.reB).append(",").append(this.ecH).append(",").append(this.lgf).append(",").append(this.reC).append(",").append(this.reD).append(",").append(this.reE).append(",").append(this.reF).append(",").append(this.reG).append(",").append(this.reH).append(",").append(this.mfa).append(",").append(this.meZ).append(",").append(this.mLz).append(",").append(this.reI).append(",").append(this.edh).append(",").append(this.reJ).append(",");
        if (this.qPm == null) {
            str = "";
        } else {
            str = this.qPm;
        }
        str = append.append(str).append(",").append(this.extra).append(",").append(this.qXp).append(",").append(this.hxZ).toString();
        AppMethodBeat.m2505o(37783);
        return str;
    }

    /* renamed from: dk */
    public final void mo62906dk(List<C13437h> list) {
        AppMethodBeat.m2504i(37784);
        for (C13437h c13437h : list) {
            if (!c13437h.cpv().qXb) {
                JSONObject jSONObject = new JSONObject();
                if (!c13437h.mo25547x(this.reK) && c13437h.mo15456al(jSONObject)) {
                    this.reK.put(jSONObject);
                }
            }
        }
        AppMethodBeat.m2505o(37784);
    }
}
