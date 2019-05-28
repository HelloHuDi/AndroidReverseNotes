package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class bp extends com.tencent.mm.plugin.report.a {
    public long cVR = 0;
    private String cWo = "";
    private String ddc = "";
    public long ddd = 0;
    public a dde;
    public b ddf;
    public long ddg = 0;
    public long ddh = 0;
    public long ddi = 0;
    public long ddj = 0;
    public long ddk = 0;

    public enum a {
        release(1),
        debug(2),
        test(3);
        
        final int value;

        static {
            AppMethodBeat.o(128648);
        }

        private a(int i) {
            this.value = i;
        }

        public static a gP(int i) {
            switch (i) {
                case 1:
                    return release;
                case 2:
                    return debug;
                case 3:
                    return test;
                default:
                    return null;
            }
        }
    }

    public enum b {
        undefined(0),
        normal(1000),
        plugin(1001),
        wxstore(1002),
        merchant(1003),
        wagame(1004),
        gift(1005);
        
        final int value;

        static {
            AppMethodBeat.o(128651);
        }

        private b(int i) {
            this.value = i;
        }

        public static b gQ(int i) {
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
        return 16602;
    }

    public final bp gl(String str) {
        AppMethodBeat.i(128652);
        this.cWo = t("SessionId", str, true);
        AppMethodBeat.o(128652);
        return this;
    }

    public final bp gm(String str) {
        AppMethodBeat.i(128653);
        this.ddc = t("AppId", str, true);
        AppMethodBeat.o(128653);
        return this;
    }

    public final String Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.i(128654);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cWo);
        stringBuffer.append(str);
        stringBuffer.append(this.ddc);
        stringBuffer.append(str);
        stringBuffer.append(this.ddd);
        stringBuffer.append(str);
        if (this.dde != null) {
            i = this.dde.value;
        } else {
            i = -1;
        }
        stringBuffer.append(i);
        stringBuffer.append(str);
        if (this.ddf != null) {
            i2 = this.ddf.value;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.ddg);
        stringBuffer.append(str);
        stringBuffer.append(this.ddh);
        stringBuffer.append(str);
        stringBuffer.append(this.ddi);
        stringBuffer.append(str);
        stringBuffer.append(this.ddj);
        stringBuffer.append(str);
        stringBuffer.append(this.cVR);
        stringBuffer.append(str);
        stringBuffer.append(this.ddk);
        String stringBuffer2 = stringBuffer.toString();
        VX(stringBuffer2);
        AppMethodBeat.o(128654);
        return stringBuffer2;
    }

    public final String Fk() {
        AppMethodBeat.i(128655);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.cWo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppId:").append(this.ddc);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppVersion:").append(this.ddd);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppState:").append(this.dde);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("AppType:").append(this.ddf);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isPreload:").append(this.ddg);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreloadKey:").append(this.ddh);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("PreloadValue:").append(this.ddi);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("isDownloadCode:").append(this.ddj);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("Scene:").append(this.cVR);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("hasSplashScreen:").append(this.ddk);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(128655);
        return stringBuffer2;
    }
}
