package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.af */
public final class C46877af extends C46180a {
    private String cWe = "";
    private String cYD = "";
    public long cYE = 0;
    private String cYF = "";
    private String cYG = "";

    public final int getId() {
        return 15960;
    }

    /* renamed from: ff */
    public final C46877af mo76048ff(String str) {
        AppMethodBeat.m2504i(91263);
        this.cYD = mo74169t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.m2505o(91263);
        return this;
    }

    /* renamed from: fg */
    public final C46877af mo76049fg(String str) {
        AppMethodBeat.m2504i(91264);
        this.cWe = mo74169t("sessionId", str, true);
        AppMethodBeat.m2505o(91264);
        return this;
    }

    /* renamed from: fh */
    public final C46877af mo76050fh(String str) {
        AppMethodBeat.m2504i(91265);
        this.cYF = mo74169t("appidBefore", str, true);
        AppMethodBeat.m2505o(91265);
        return this;
    }

    /* renamed from: fi */
    public final C46877af mo76051fi(String str) {
        AppMethodBeat.m2504i(91266);
        this.cYG = mo74169t("appidAfter", str, true);
        AppMethodBeat.m2505o(91266);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91267);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.cWe);
        stringBuffer.append(str);
        stringBuffer.append(this.cYE);
        stringBuffer.append(str);
        stringBuffer.append(this.cYF);
        stringBuffer.append(str);
        stringBuffer.append(this.cYG);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91267);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91268);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionId:").append(this.cWe);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isChange:").append(this.cYE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appidBefore:").append(this.cYF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("appidAfter:").append(this.cYG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91268);
        return stringBuffer2;
    }
}
