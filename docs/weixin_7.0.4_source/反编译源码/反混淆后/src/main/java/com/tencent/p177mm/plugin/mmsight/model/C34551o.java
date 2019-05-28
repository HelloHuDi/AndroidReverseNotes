package com.tencent.p177mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.model.C39388g.C39389b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.mmsight.model.o */
public final class C34551o {
    public int etz = 1;
    public int fay = -1;
    public VideoTransPara fcY;
    public int gLM = -1;
    public int ouK = -1;
    public boolean ouL = false;
    public boolean ouM = false;
    public boolean ouN = true;
    public boolean ouO = false;
    C39389b ouP;
    public boolean ouw = false;
    public int videoBitrate;

    /* renamed from: a */
    public static C34551o m56645a(int i, VideoTransPara videoTransPara) {
        C34551o d;
        AppMethodBeat.m2504i(76546);
        switch (i) {
            case 1:
                d = C34551o.m56646d(videoTransPara);
                break;
            case 2:
                d = C34551o.m56647e(videoTransPara);
                break;
            case 3:
                d = C34551o.m56648f(videoTransPara);
                break;
            case 4:
                d = C34551o.m56649g(videoTransPara);
                break;
            case 5:
                d = C34551o.m56650h(videoTransPara);
                break;
            case 6:
                d = C34551o.m56651i(videoTransPara);
                break;
            case 7:
                d = C34551o.m56652j(videoTransPara);
                break;
            case 8:
                d = C34551o.m56653k(videoTransPara);
                break;
            case 9:
                d = C34551o.m56654l(videoTransPara);
                break;
            case 10:
                d = C34551o.m56655m(videoTransPara);
                break;
            case 11:
                d = C34551o.m56656n(videoTransPara);
                break;
            case 12:
                d = C34551o.m56657o(videoTransPara);
                break;
            default:
                AppMethodBeat.m2505o(76546);
                return null;
        }
        if (d != null) {
            d.ouK = i;
        }
        AppMethodBeat.m2505o(76546);
        return d;
    }

    /* renamed from: d */
    private static C34551o m56646d(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76547);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig1");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = false;
        AppMethodBeat.m2505o(76547);
        return c34551o;
    }

    /* renamed from: e */
    private static C34551o m56647e(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76548);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig2");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = false;
        c34551o = c34551o.bPF().bPE();
        AppMethodBeat.m2505o(76548);
        return c34551o;
    }

    /* renamed from: f */
    private static C34551o m56648f(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76549);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig3");
        C34551o c34551o = new C34551o(1, videoTransPara);
        c34551o.ouM = false;
        AppMethodBeat.m2505o(76549);
        return c34551o;
    }

    /* renamed from: g */
    private static C34551o m56649g(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76550);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig4");
        C34551o c34551o = new C34551o(1, videoTransPara);
        c34551o.ouM = false;
        c34551o = c34551o.bPF().bPE();
        AppMethodBeat.m2505o(76550);
        return c34551o;
    }

    /* renamed from: h */
    private static C34551o m56650h(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76551);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig5");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = true;
        c34551o.ouL = false;
        c34551o = c34551o.bPE();
        AppMethodBeat.m2505o(76551);
        return c34551o;
    }

    /* renamed from: i */
    private static C34551o m56651i(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76552);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig6");
        C34551o c34551o = new C34551o(1, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPE();
        AppMethodBeat.m2505o(76552);
        return c34551o;
    }

    /* renamed from: j */
    private static C34551o m56652j(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76553);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig7");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPG();
        c34551o.ouL = false;
        AppMethodBeat.m2505o(76553);
        return c34551o;
    }

    /* renamed from: k */
    private static C34551o m56653k(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76554);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig8");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPG();
        c34551o.ouL = true;
        AppMethodBeat.m2505o(76554);
        return c34551o;
    }

    /* renamed from: l */
    private static C34551o m56654l(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76555);
        C34551o c34551o = new C34551o(1, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPG();
        c34551o.ouL = false;
        AppMethodBeat.m2505o(76555);
        return c34551o;
    }

    /* renamed from: m */
    private static C34551o m56655m(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76556);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        C34551o c34551o = new C34551o(1, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPG();
        c34551o.ouL = true;
        AppMethodBeat.m2505o(76556);
        return c34551o;
    }

    /* renamed from: n */
    private static C34551o m56656n(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76557);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPG();
        c34551o.ouL = false;
        c34551o = c34551o.bPF();
        AppMethodBeat.m2505o(76557);
        return c34551o;
    }

    /* renamed from: o */
    private static C34551o m56657o(VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76558);
        C4990ab.m7416i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        C34551o c34551o = new C34551o(2, videoTransPara);
        c34551o.ouM = true;
        c34551o = c34551o.bPH();
        c34551o.ouL = false;
        c34551o = c34551o.bPF();
        AppMethodBeat.m2505o(76558);
        return c34551o;
    }

    private C34551o(int i, VideoTransPara videoTransPara) {
        this.fcY = videoTransPara;
        this.etz = i;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.fay = videoTransPara.width;
    }

    public final C34551o bPE() {
        this.fay = 720;
        if (this.gLM > 0 && this.fay > this.gLM) {
            this.fay = this.gLM;
        }
        return this;
    }

    public final C34551o bPF() {
        this.videoBitrate = this.fcY.videoBitrate * 2;
        this.ouO = true;
        return this;
    }

    public final C34551o bPG() {
        this.fay = this.fcY.width * 2;
        if (this.gLM > 0 && this.fay > this.gLM) {
            this.fay = this.gLM;
        }
        return this;
    }

    private C34551o bPH() {
        this.fay = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        if (this.gLM > 0 && this.fay > this.gLM) {
            this.fay = this.gLM;
        }
        return this;
    }

    public final boolean bPI() {
        return this.fcY.width < this.fay;
    }

    public final String toString() {
        AppMethodBeat.m2504i(76559);
        String format = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.etz), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.ouw), Boolean.valueOf(this.ouL), Boolean.valueOf(this.ouM), Integer.valueOf(this.fay), this.fcY});
        AppMethodBeat.m2505o(76559);
        return format;
    }
}
