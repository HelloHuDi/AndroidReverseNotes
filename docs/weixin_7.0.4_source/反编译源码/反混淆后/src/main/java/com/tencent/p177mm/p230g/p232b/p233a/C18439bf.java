package com.tencent.p177mm.p230g.p232b.p233a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bf */
public final class C18439bf extends C46180a {
    public long cVR = 0;
    private String dbU = "";
    public long dbV = 0;
    private long dbW = 0;
    public long dbX = 0;
    private long dbY = 0;
    private String dbZ = "";
    public long dca = 0;
    private String dcb = "";

    public final int getId() {
        return 14404;
    }

    /* renamed from: fV */
    public final C18439bf mo33700fV(String str) {
        AppMethodBeat.m2504i(77609);
        this.dbU = mo74169t("BiilNo", str, true);
        AppMethodBeat.m2505o(77609);
        return this;
    }

    /* renamed from: fW */
    public final C18439bf mo33701fW(String str) {
        AppMethodBeat.m2504i(77610);
        this.dbZ = mo74169t(C8741b.CONTENT, str, true);
        AppMethodBeat.m2505o(77610);
        return this;
    }

    /* renamed from: fX */
    public final C18439bf mo33702fX(String str) {
        AppMethodBeat.m2504i(77611);
        this.dcb = mo74169t("packId", str, true);
        AppMethodBeat.m2505o(77611);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(77612);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.dbU);
        stringBuffer.append(str);
        stringBuffer.append(this.dbV);
        stringBuffer.append(str);
        stringBuffer.append(this.dbW);
        stringBuffer.append(str);
        stringBuffer.append(this.dbX);
        stringBuffer.append(str);
        stringBuffer.append(this.dbY);
        stringBuffer.append(str);
        stringBuffer.append(this.dbZ);
        stringBuffer.append(str);
        stringBuffer.append(this.dca);
        stringBuffer.append(str);
        stringBuffer.append(this.dcb);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(77612);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(77613);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("BiilNo:").append(this.dbU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("failReason:").append(this.dbV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("playerErrCode:").append(this.dbW);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("type:").append(this.dbX);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("retCode:").append(this.dbY);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("content:").append(this.dbZ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("amount:").append(this.dca);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("packId:").append(this.dcb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77613);
        return stringBuffer2;
    }
}
