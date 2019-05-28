package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.cs */
public final class C26288cs extends C46180a {
    public long cVR = 0;
    private String ddc;
    private String dhA;
    public C18452c dhB;
    public C26289b dhC;
    private String dhD;
    public C18453d dhE;
    public C18454e dhF;
    public C26290a dhG;
    private String dhx;
    private long dhy = 0;
    private String dhz;

    /* renamed from: com.tencent.mm.g.b.a.cs$c */
    public enum C18452c {
        DEFAULT(0),
        YES(1),
        NO(2);
        
        final int value;

        static {
            AppMethodBeat.m2505o(51104);
        }

        private C18452c(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cs$d */
    public enum C18453d {
        DEFAULT(0),
        DOING(1),
        DONE(2);
        
        final int value;

        static {
            AppMethodBeat.m2505o(51107);
        }

        private C18453d(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cs$e */
    public enum C18454e {
        DEFAULT(0),
        NOTSUBSCRIBE(1),
        SUBSCRIBE(2);
        
        final int value;

        static {
            AppMethodBeat.m2505o(51110);
        }

        private C18454e(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cs$b */
    public enum C26289b {
        SHAREAPPMSG(1),
        CLICKAPPMSG(2),
        CLICKSUBSCRIBETV(3),
        CLICKSTARTGAME(4);
        
        final int value;

        static {
            AppMethodBeat.m2505o(51101);
        }

        private C26289b(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.g.b.a.cs$a */
    public enum C26290a {
        undefined(0),
        normal(1000),
        plugin(1001),
        wxstore(1002),
        merchant(1003),
        wagame(1004),
        gift(1005);
        
        final int value;

        static {
            AppMethodBeat.m2505o(51098);
        }

        private C26290a(int i) {
            this.value = i;
        }

        /* renamed from: hp */
        public static C26290a m41777hp(int i) {
            switch (i) {
                case 0:
                    return undefined;
                case 1000:
                    return normal;
                case 1001:
                    return plugin;
                case 1002:
                    return wxstore;
                case 1003:
                    return merchant;
                case 1004:
                    return wagame;
                case 1005:
                    return gift;
                default:
                    return null;
            }
        }
    }

    public final int getId() {
        return 16024;
    }

    /* renamed from: hE */
    public final C26288cs mo44049hE(String str) {
        AppMethodBeat.m2504i(51111);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(51111);
        return this;
    }

    /* renamed from: hF */
    public final C26288cs mo44050hF(String str) {
        AppMethodBeat.m2504i(51112);
        this.dhx = mo74169t("PageId", str, true);
        AppMethodBeat.m2505o(51112);
        return this;
    }

    /* renamed from: hG */
    public final C26288cs mo44051hG(String str) {
        AppMethodBeat.m2504i(51114);
        this.dhz = mo74169t("ShareTicket", str, true);
        AppMethodBeat.m2505o(51114);
        return this;
    }

    /* renamed from: hH */
    public final C26288cs mo44052hH(String str) {
        AppMethodBeat.m2504i(51115);
        this.dhA = mo74169t("ChattingId", str, true);
        AppMethodBeat.m2505o(51115);
        return this;
    }

    /* renamed from: hI */
    public final C26288cs mo44053hI(String str) {
        AppMethodBeat.m2504i(51116);
        this.dhD = mo74169t("SceneNote", str, true);
        AppMethodBeat.m2505o(51116);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(51117);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.dhx);
        stringBuffer.append(str);
        stringBuffer.append(this.dhy);
        stringBuffer.append(str);
        stringBuffer.append(this.dhz);
        stringBuffer.append(str);
        stringBuffer.append(this.dhA);
        stringBuffer.append(str);
        if (this.dhB != null) {
            i = this.dhB.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dhC != null) {
            i = this.dhC.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.dhD);
        stringBuffer.append(str);
        if (this.dhE != null) {
            i = this.dhE.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dhF != null) {
            i = this.dhF.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.dhG != null) {
            i2 = this.dhG.value;
        }
        stringBuffer.append(i2);
        String stringBuffer2 = stringBuffer.toString();
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(51117);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(51118);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PageId:").append(this.dhx);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ActionTimeStampMs:").append(this.dhy);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ShareTicket:").append(this.dhz);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ChattingId:").append(this.dhA);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("IsGroupChatting:").append(this.dhB);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EventId:").append(this.dhC);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SceneNote:").append(this.dhD);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("MsgState:").append(this.dhE);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("SubScribeState:").append(this.dhF);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.dhG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(51118);
        return stringBuffer2;
    }

    /* renamed from: Hk */
    public final C26288cs mo44048Hk() {
        AppMethodBeat.m2504i(51113);
        this.dhy = C5046bo.anU();
        super.mo74166aj("ActionTimeStampMs", this.dhy);
        AppMethodBeat.m2505o(51113);
        return this;
    }
}
