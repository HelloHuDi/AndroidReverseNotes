package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.e */
public final class C42100e extends C46180a {
    private String cUM = "";
    public long cUN = 0;
    public long cUO = 0;
    public long cUP = 0;
    public boolean cUQ;
    public long cUR = 0;
    public long cUS = 0;
    public long cUT = 0;
    private long cUU = 0;
    private long cUV = 0;
    public C26292a cUW;

    /* renamed from: com.tencent.mm.g.b.a.e$a */
    public enum C26292a {
        ok(0),
        cancel(1),
        error(2);
        
        final int value;

        static {
            AppMethodBeat.m2505o(15825);
        }

        private C26292a(int i) {
            this.value = i;
        }
    }

    public final int getId() {
        return 15749;
    }

    /* renamed from: er */
    public final C42100e mo67665er(String str) {
        AppMethodBeat.m2504i(15826);
        this.cUM = mo74169t("ChatName", str, true);
        AppMethodBeat.m2505o(15826);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(15829);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cUM);
        stringBuffer.append(str);
        stringBuffer.append(this.cUN);
        stringBuffer.append(str);
        stringBuffer.append(this.cUO);
        stringBuffer.append(str);
        stringBuffer.append(this.cUP);
        stringBuffer.append(str);
        if (this.cUQ) {
            i = 1;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.cUR);
        stringBuffer.append(str);
        stringBuffer.append(this.cUS);
        stringBuffer.append(str);
        stringBuffer.append(this.cUT);
        stringBuffer.append(str);
        stringBuffer.append(this.cUU);
        stringBuffer.append(str);
        stringBuffer.append(this.cUV);
        stringBuffer.append(str);
        if (this.cUW != null) {
            i = this.cUW.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(15829);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(15830);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.cUM);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MemberCount:").append(this.cUN);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MsgSvrId:").append(this.cUO);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MsgCreateTime:").append(this.cUP);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsHdImgBool:").append(this.cUQ);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ImgSize:").append(this.cUR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ImgWidth:").append(this.cUS);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ImgHeight:").append(this.cUT);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("StartDownloadTimeStampMs:").append(this.cUU);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FinishDownloadTimeStampMs:").append(this.cUV);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("FinishCode:").append(this.cUW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(15830);
        return stringBuffer2;
    }

    /* renamed from: Fn */
    public final C42100e mo67663Fn() {
        AppMethodBeat.m2504i(15827);
        this.cUU = C5046bo.anU();
        super.mo74166aj("StartDownloadTimeStampMs", this.cUU);
        AppMethodBeat.m2505o(15827);
        return this;
    }

    /* renamed from: Fo */
    public final C42100e mo67664Fo() {
        AppMethodBeat.m2504i(15828);
        this.cUV = C5046bo.anU();
        super.mo74166aj("FinishDownloadTimeStampMs", this.cUV);
        AppMethodBeat.m2505o(15828);
        return this;
    }
}
