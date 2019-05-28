package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cw */
public final class C37830cw extends C46180a {
    public long cXP = 0;
    private String cXU = "";
    private String cYD = "";
    private String din = "";
    public long dio = 0;
    private String dip = "";
    public long diq = 0;
    private String dis = "";
    public long dit = 0;

    public final int getId() {
        return 16033;
    }

    /* renamed from: hM */
    public final C37830cw mo60546hM(String str) {
        AppMethodBeat.m2504i(91277);
        this.din = mo74169t("searchid", str, true);
        AppMethodBeat.m2505o(91277);
        return this;
    }

    /* renamed from: hN */
    public final C37830cw mo60547hN(String str) {
        AppMethodBeat.m2504i(91278);
        this.dip = mo74169t("docid", str, true);
        AppMethodBeat.m2505o(91278);
        return this;
    }

    /* renamed from: hO */
    public final C37830cw mo60548hO(String str) {
        AppMethodBeat.m2504i(91279);
        this.dis = mo74169t("expand2", str, true);
        AppMethodBeat.m2505o(91279);
        return this;
    }

    /* renamed from: hP */
    public final C37830cw mo60549hP(String str) {
        AppMethodBeat.m2504i(91280);
        this.cYD = mo74169t(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.m2505o(91280);
        return this;
    }

    /* renamed from: hQ */
    public final C37830cw mo60550hQ(String str) {
        AppMethodBeat.m2504i(91281);
        this.cXU = mo74169t("sessionid", str, true);
        AppMethodBeat.m2505o(91281);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(91282);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cXP);
        stringBuffer.append(str);
        stringBuffer.append(this.din);
        stringBuffer.append(str);
        stringBuffer.append(this.dio);
        stringBuffer.append(str);
        stringBuffer.append(this.dip);
        stringBuffer.append(str);
        stringBuffer.append(this.diq);
        stringBuffer.append(str);
        stringBuffer.append(this.dis);
        stringBuffer.append(str);
        stringBuffer.append(this.cYD);
        stringBuffer.append(str);
        stringBuffer.append(this.cXU);
        stringBuffer.append(str);
        stringBuffer.append(this.dit);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(91282);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(91283);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.cXP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("searchid:").append(this.din);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("businesstype:").append(this.dio);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("docid:").append(this.dip);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("timestampInMs:").append(this.diq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("expand2:").append(this.dis);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("query:").append(this.cYD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("sessionid:").append(this.cXU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("resultsubtype:").append(this.dit);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(91283);
        return stringBuffer2;
    }
}
