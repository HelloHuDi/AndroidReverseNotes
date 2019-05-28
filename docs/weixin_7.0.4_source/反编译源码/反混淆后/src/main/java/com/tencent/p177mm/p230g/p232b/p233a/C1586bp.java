package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.bp */
public final class C1586bp extends C46180a {
    public long cVR = 0;
    private String cWo = "";
    private String ddc = "";
    public long ddd = 0;
    public C1587a dde;
    public C1588b ddf;
    public long ddg = 0;
    public long ddh = 0;
    public long ddi = 0;
    public long ddj = 0;
    public long ddk = 0;

    /* renamed from: com.tencent.mm.g.b.a.bp$a */
    public enum C1587a {
        release(1),
        debug(2),
        test(3);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128648);
        }

        private C1587a(int i) {
            this.value = i;
        }

        /* renamed from: gP */
        public static C1587a m3206gP(int i) {
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

    /* renamed from: com.tencent.mm.g.b.a.bp$b */
    public enum C1588b {
        undefined(0),
        normal(1000),
        plugin(1001),
        wxstore(1002),
        merchant(1003),
        wagame(1004),
        gift(1005);
        
        final int value;

        static {
            AppMethodBeat.m2505o(128651);
        }

        private C1588b(int i) {
            this.value = i;
        }

        /* renamed from: gQ */
        public static C1588b m3207gQ(int i) {
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

    /* renamed from: gl */
    public final C1586bp mo5015gl(String str) {
        AppMethodBeat.m2504i(128652);
        this.cWo = mo74169t("SessionId", str, true);
        AppMethodBeat.m2505o(128652);
        return this;
    }

    /* renamed from: gm */
    public final C1586bp mo5016gm(String str) {
        AppMethodBeat.m2504i(128653);
        this.ddc = mo74169t("AppId", str, true);
        AppMethodBeat.m2505o(128653);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        int i;
        int i2 = -1;
        AppMethodBeat.m2504i(128654);
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
        mo74164VX(stringBuffer2);
        AppMethodBeat.m2505o(128654);
        return stringBuffer2;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(128655);
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
        AppMethodBeat.m2505o(128655);
        return stringBuffer2;
    }
}
