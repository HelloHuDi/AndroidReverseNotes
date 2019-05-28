package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k {
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

    public k() {
        AppMethodBeat.i(37782);
        AppMethodBeat.o(37782);
    }

    public final String cqm() {
        String str;
        AppMethodBeat.i(37783);
        this.reI = this.reK.toString();
        ab.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", this.reI);
        if (!bo.isNullOrNil(this.reI)) {
            try {
                this.reI = URLEncoder.encode(this.reI, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
        long j = 0;
        try {
            j = i.Xq(this.cFc);
        } catch (Exception e2) {
            ab.e("AdLandingPagesReportInfo", "", e2);
        }
        StringBuilder append = new StringBuilder().append(i.jV(j)).append(",").append(this.qPj).append(",").append(this.reB).append(",").append(this.ecH).append(",").append(this.lgf).append(",").append(this.reC).append(",").append(this.reD).append(",").append(this.reE).append(",").append(this.reF).append(",").append(this.reG).append(",").append(this.reH).append(",").append(this.mfa).append(",").append(this.meZ).append(",").append(this.mLz).append(",").append(this.reI).append(",").append(this.edh).append(",").append(this.reJ).append(",");
        if (this.qPm == null) {
            str = "";
        } else {
            str = this.qPm;
        }
        str = append.append(str).append(",").append(this.extra).append(",").append(this.qXp).append(",").append(this.hxZ).toString();
        AppMethodBeat.o(37783);
        return str;
    }

    public final void dk(List<h> list) {
        AppMethodBeat.i(37784);
        for (h hVar : list) {
            if (!hVar.cpv().qXb) {
                JSONObject jSONObject = new JSONObject();
                if (!hVar.x(this.reK) && hVar.al(jSONObject)) {
                    this.reK.put(jSONObject);
                }
            }
        }
        AppMethodBeat.o(37784);
    }
}
