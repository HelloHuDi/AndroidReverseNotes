package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cx */
public final class C46885cx extends C46180a {
    public long cXP = 0;
    private String cXU = "";
    private String cYD = "";
    private String dbZ = "";
    private String din = "";
    private String diu = "";
    private String div = "";

    public final int getId() {
        return 16032;
    }

    /* renamed from: hR */
    public final C46885cx mo76078hR(String str) {
        AppMethodBeat.m2504i(91284);
        this.dbZ = mo74169t(C8741b.CONTENT, str, true);
        AppMethodBeat.m2505o(91284);
        return this;
    }

    /* renamed from: hS */
    public final C46885cx mo76079hS(String str) {
        AppMethodBeat.m2504i(91285);
        this.din = mo74169t("searchid", str, true);
        AppMethodBeat.m2505o(91285);
        return this;
    }

    /* renamed from: hT */
    public final C46885cx mo76080hT(String str) {
        AppMethodBeat.m2504i(91286);
        this.cXU = mo74169t("sessionid", str, true);
        AppMethodBeat.m2505o(91286);
        return this;
    }

    /* renamed from: hU */
    public final C46885cx mo76081hU(String str) {
        AppMethodBeat.m2504i(91287);
        this.cYD = mo74169t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.m2505o(91287);
        return this;
    }

    /* renamed from: hV */
    public final C46885cx mo76082hV(String str) {
        AppMethodBeat.m2504i(91288);
        this.diu = mo74169t("resulttype", str, true);
        AppMethodBeat.m2505o(91288);
        return this;
    }

    /* renamed from: hW */
    public final C46885cx mo76083hW(String str) {
        AppMethodBeat.m2504i(91289);
        this.div = mo74169t("resultsubtypelist", str, true);
        AppMethodBeat.m2505o(91289);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91290);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXP);
        stringBuffer.append(str);
        stringBuffer.append(this.dbZ);
        stringBuffer.append(str);
        stringBuffer.append(this.din);
        stringBuffer.append(str);
        stringBuffer.append(this.cXU);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.diu);
        stringBuffer.append(str);
        stringBuffer.append(this.div);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91290);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91291);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.cXP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("content:").append(this.dbZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("searchid:").append(this.din);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionid:").append(this.cXU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("resulttype:").append(this.diu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("resultsubtypelist:").append(this.div);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91291);
        return stringBuffer2;
    }
}
