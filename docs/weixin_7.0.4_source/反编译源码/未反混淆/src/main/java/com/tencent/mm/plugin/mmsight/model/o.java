package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class o {
    public int etz = 1;
    public int fay = -1;
    public VideoTransPara fcY;
    public int gLM = -1;
    public int ouK = -1;
    public boolean ouL = false;
    public boolean ouM = false;
    public boolean ouN = true;
    public boolean ouO = false;
    b ouP;
    public boolean ouw = false;
    public int videoBitrate;

    public static o a(int i, VideoTransPara videoTransPara) {
        o d;
        AppMethodBeat.i(76546);
        switch (i) {
            case 1:
                d = d(videoTransPara);
                break;
            case 2:
                d = e(videoTransPara);
                break;
            case 3:
                d = f(videoTransPara);
                break;
            case 4:
                d = g(videoTransPara);
                break;
            case 5:
                d = h(videoTransPara);
                break;
            case 6:
                d = i(videoTransPara);
                break;
            case 7:
                d = j(videoTransPara);
                break;
            case 8:
                d = k(videoTransPara);
                break;
            case 9:
                d = l(videoTransPara);
                break;
            case 10:
                d = m(videoTransPara);
                break;
            case 11:
                d = n(videoTransPara);
                break;
            case 12:
                d = o(videoTransPara);
                break;
            default:
                AppMethodBeat.o(76546);
                return null;
        }
        if (d != null) {
            d.ouK = i;
        }
        AppMethodBeat.o(76546);
        return d;
    }

    private static o d(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76547);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = false;
        AppMethodBeat.o(76547);
        return oVar;
    }

    private static o e(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76548);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = false;
        oVar = oVar.bPF().bPE();
        AppMethodBeat.o(76548);
        return oVar;
    }

    private static o f(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76549);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
        o oVar = new o(1, videoTransPara);
        oVar.ouM = false;
        AppMethodBeat.o(76549);
        return oVar;
    }

    private static o g(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76550);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
        o oVar = new o(1, videoTransPara);
        oVar.ouM = false;
        oVar = oVar.bPF().bPE();
        AppMethodBeat.o(76550);
        return oVar;
    }

    private static o h(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76551);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = true;
        oVar.ouL = false;
        oVar = oVar.bPE();
        AppMethodBeat.o(76551);
        return oVar;
    }

    private static o i(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76552);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
        o oVar = new o(1, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPE();
        AppMethodBeat.o(76552);
        return oVar;
    }

    private static o j(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76553);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPG();
        oVar.ouL = false;
        AppMethodBeat.o(76553);
        return oVar;
    }

    private static o k(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76554);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPG();
        oVar.ouL = true;
        AppMethodBeat.o(76554);
        return oVar;
    }

    private static o l(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76555);
        o oVar = new o(1, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPG();
        oVar.ouL = false;
        AppMethodBeat.o(76555);
        return oVar;
    }

    private static o m(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76556);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        o oVar = new o(1, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPG();
        oVar.ouL = true;
        AppMethodBeat.o(76556);
        return oVar;
    }

    private static o n(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76557);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPG();
        oVar.ouL = false;
        oVar = oVar.bPF();
        AppMethodBeat.o(76557);
        return oVar;
    }

    private static o o(VideoTransPara videoTransPara) {
        AppMethodBeat.i(76558);
        ab.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        o oVar = new o(2, videoTransPara);
        oVar.ouM = true;
        oVar = oVar.bPH();
        oVar.ouL = false;
        oVar = oVar.bPF();
        AppMethodBeat.o(76558);
        return oVar;
    }

    private o(int i, VideoTransPara videoTransPara) {
        this.fcY = videoTransPara;
        this.etz = i;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.fay = videoTransPara.width;
    }

    public final o bPE() {
        this.fay = 720;
        if (this.gLM > 0 && this.fay > this.gLM) {
            this.fay = this.gLM;
        }
        return this;
    }

    public final o bPF() {
        this.videoBitrate = this.fcY.videoBitrate * 2;
        this.ouO = true;
        return this;
    }

    public final o bPG() {
        this.fay = this.fcY.width * 2;
        if (this.gLM > 0 && this.fay > this.gLM) {
            this.fay = this.gLM;
        }
        return this;
    }

    private o bPH() {
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
        AppMethodBeat.i(76559);
        String format = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.etz), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.ouw), Boolean.valueOf(this.ouL), Boolean.valueOf(this.ouM), Integer.valueOf(this.fay), this.fcY});
        AppMethodBeat.o(76559);
        return format;
    }
}
