package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.ce */
public final class C42095ce extends C46180a {
    private String ddc = "";
    public long ddd = 0;
    public long ddz = 0;
    private String dex = "";
    public C42094a dfv;
    private String dfw = "";
    public long dfx = 0;
    public long dfy = 0;

    /* renamed from: com.tencent.mm.g.b.a.ce$a */
    public enum C42094a {
        release(1),
        debug(2),
        demo(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128796);
        }

        private C42094a(int i) {
            this.value = i;
        }

        /* renamed from: he */
        public static C42094a m74190he(int i) {
            switch (i) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return demo;
                default:
                    return null;
            }
        }
    }

    public final int getId() {
        return 17120;
    }

    /* renamed from: gW */
    public final C42095ce mo67651gW(String str) {
        AppMethodBeat.m2504i(128797);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128797);
        return this;
    }

    /* renamed from: gX */
    public final C42095ce mo67652gX(String str) {
        AppMethodBeat.m2504i(128798);
        this.dfw = mo74169t("Provider", str, true);
        AppMethodBeat.m2505o(128798);
        return this;
    }

    /* renamed from: gY */
    public final C42095ce mo67653gY(String str) {
        AppMethodBeat.m2504i(128799);
        this.dex = mo74169t("networkTypeStr", str, true);
        AppMethodBeat.m2505o(128799);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        AppMethodBeat.m2504i(128800);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dfv != null) {
            i = this.dfv.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.ddz);
        stringBuffer.append(str);
        stringBuffer.append(this.dfw);
        stringBuffer.append(str);
        stringBuffer.append(this.dfx);
        stringBuffer.append(str);
        stringBuffer.append(this.dfy);
        stringBuffer.append(str);
        stringBuffer.append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128800);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128801);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dfv);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Provider:").append(this.dfw);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Version:").append(this.dfx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Stage:").append(this.dfy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("networkTypeStr:").append(this.dex);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128801);
        return stringBuffer2;
    }
}
