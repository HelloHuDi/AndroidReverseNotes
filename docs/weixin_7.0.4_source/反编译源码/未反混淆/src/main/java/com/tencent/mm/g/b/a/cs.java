package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class cs extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    private String ddc;
    private String dhA;
    public c dhB;
    public b dhC;
    private String dhD;
    public d dhE;
    public e dhF;
    public a dhG;
    private String dhx;
    private long dhy = 0;
    private String dhz;

    public enum c {
        DEFAULT(0),
        YES(1),
        NO(2);
        
        final int value;

        static {
            AppMethodBeat.o(51104);
        }

        private c(int i) {
            this.value = i;
        }
    }

    public enum d {
        DEFAULT(0),
        DOING(1),
        DONE(2);
        
        final int value;

        static {
            AppMethodBeat.o(51107);
        }

        private d(int i) {
            this.value = i;
        }
    }

    public enum e {
        DEFAULT(0),
        NOTSUBSCRIBE(1),
        SUBSCRIBE(2);
        
        final int value;

        static {
            AppMethodBeat.o(51110);
        }

        private e(int i) {
            this.value = i;
        }
    }

    public enum b {
        SHAREAPPMSG(1),
        CLICKAPPMSG(2),
        CLICKSUBSCRIBETV(3),
        CLICKSTARTGAME(4);
        
        final int value;

        static {
            AppMethodBeat.o(51101);
        }

        private b(int i) {
            this.value = i;
        }
    }

    public enum a {
        undefined(0),
        normal(1000),
        plugin(1001),
        wxstore(1002),
        merchant(1003),
        wagame(1004),
        gift(1005);
        
        final int value;

        static {
            AppMethodBeat.o(51098);
        }

        private a(int i) {
            this.value = i;
        }

        public static a hp(int i) {
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

    public final cs hE(String str) {
        AppMethodBeat.i(51111);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(51111);
        return this;
    }

    public final cs hF(String str) {
        AppMethodBeat.i(51112);
        this.dhx = t("PageId", str, true);
        AppMethodBeat.o(51112);
        return this;
    }

    public final cs hG(String str) {
        AppMethodBeat.i(51114);
        this.dhz = t("ShareTicket", str, true);
        AppMethodBeat.o(51114);
        return this;
    }

    public final cs hH(String str) {
        AppMethodBeat.i(51115);
        this.dhA = t("ChattingId", str, true);
        AppMethodBeat.o(51115);
        return this;
    }

    public final cs hI(String str) {
        AppMethodBeat.i(51116);
        this.dhD = t("SceneNote", str, true);
        AppMethodBeat.o(51116);
        return this;
    }

    public final String Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.i(51117);
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
        VX(stringBuffer2);
        AppMethodBeat.o(51117);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(51118);
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
        AppMethodBeat.o(51118);
        return stringBuffer2;
    }

    public final cs Hk() {
        AppMethodBeat.i(51113);
        this.dhy = bo.anU();
        super.aj("ActionTimeStampMs", this.dhy);
        AppMethodBeat.o(51113);
        return this;
    }
}
