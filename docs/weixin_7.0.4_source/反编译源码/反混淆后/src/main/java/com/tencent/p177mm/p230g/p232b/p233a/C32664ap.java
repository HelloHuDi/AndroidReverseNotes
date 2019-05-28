package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ap */
public final class C32664ap extends C46180a {
    private String cWo = "";
    private int cZA = 0;
    private int cZB = 0;
    private int cZC = 0;
    private String cZD = "";
    private int cZE = 0;
    private int cZF = 0;
    private String cZG = "";
    private long cZH = 0;
    private int cZz = 0;

    public final int getId() {
        return 16887;
    }

    /* renamed from: fw */
    public final C32664ap mo53177fw(String str) {
        AppMethodBeat.m2504i(108854);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(108854);
        return this;
    }

    /* renamed from: gJ */
    public final C32664ap mo53180gJ(int i) {
        this.cZz = i;
        return this;
    }

    /* renamed from: FB */
    public final int mo53173FB() {
        return this.cZz;
    }

    /* renamed from: gK */
    public final C32664ap mo53181gK(int i) {
        this.cZA = i;
        return this;
    }

    /* renamed from: gL */
    public final C32664ap mo53182gL(int i) {
        this.cZB = i;
        return this;
    }

    /* renamed from: gM */
    public final C32664ap mo53183gM(int i) {
        this.cZC = i;
        return this;
    }

    /* renamed from: FC */
    public final int mo53174FC() {
        return this.cZC;
    }

    /* renamed from: fx */
    public final C32664ap mo53178fx(String str) {
        AppMethodBeat.m2504i(108855);
        this.cZD = mo74169t("ExposeNewUinList", str, true);
        AppMethodBeat.m2505o(108855);
        return this;
    }

    /* renamed from: gN */
    public final C32664ap mo53184gN(int i) {
        this.cZE = i;
        return this;
    }

    /* renamed from: gO */
    public final C32664ap mo53185gO(int i) {
        this.cZF = i;
        return this;
    }

    /* renamed from: FD */
    public final int mo53175FD() {
        return this.cZF;
    }

    /* renamed from: fy */
    public final C32664ap mo53179fy(String str) {
        AppMethodBeat.m2504i(108856);
        this.cZG = mo74169t("ExposeBeforeUinList", str, true);
        AppMethodBeat.m2505o(108856);
        return this;
    }

    /* renamed from: bD */
    public final C32664ap mo53176bD(long j) {
        this.cZH = j;
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(108857);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.cZz);
        stringBuffer.append(str);
        stringBuffer.append(this.cZA);
        stringBuffer.append(str);
        stringBuffer.append(this.cZB);
        stringBuffer.append(str);
        stringBuffer.append(this.cZC);
        stringBuffer.append(str);
        stringBuffer.append(this.cZD);
        stringBuffer.append(str);
        stringBuffer.append(this.cZE);
        stringBuffer.append(str);
        stringBuffer.append(this.cZF);
        stringBuffer.append(str);
        stringBuffer.append(this.cZG);
        stringBuffer.append(str);
        stringBuffer.append(this.cZH);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(108857);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(108858);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeViewId:").append(this.cZz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeOrder:").append(this.cZA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewUinCount:").append(this.cZB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewFavorUinCount:").append(this.cZC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeNewUinList:").append(this.cZD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeBeforeUinCount:").append(this.cZE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeBeforeFavorUinCount:").append(this.cZF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ExposeBeforeUinList:").append(this.cZG);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("InteractiveUserCount:").append(this.cZH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108858);
        return stringBuffer2;
    }
}
