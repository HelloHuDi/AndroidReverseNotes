package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p {
    public static int ouQ = 480;
    public static int ouR = 640;
    public int fXd;
    public int fps;
    public int lZe;
    public int lZf;
    public int ouS;
    public int ouT;
    public int ouU;
    public int ouV;
    public int ouW;
    public String ouX;
    public String ouY;
    public String ouZ;
    public String ova;
    public String ovb;
    public int ovc;
    public int ovd;
    public int rotate;

    public final String toString() {
        AppMethodBeat.i(76560);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fps=").append(this.fps).append(10);
        stringBuilder.append("width=").append(this.lZe).append(10);
        stringBuilder.append("height=").append(this.lZf).append(10);
        stringBuilder.append("bitrate=").append(this.ouS).append(10);
        stringBuilder.append("rotate=").append(this.rotate).append(10);
        stringBuilder.append("yuvWidth=").append(this.ouU).append(10);
        stringBuilder.append("yuvHeight=").append(this.ouT).append(10);
        stringBuilder.append("x264Speed=").append(this.ouV).append(10);
        stringBuilder.append("x264Quality=").append(this.ouW).append(10);
        stringBuilder.append("yuvFile=").append(this.ouX).append(10);
        stringBuilder.append("pcmFile=").append(this.ouY).append(10);
        stringBuilder.append("thuFile=").append(this.ouZ).append(10);
        stringBuilder.append("x264File=").append(this.ova).append(10);
        stringBuilder.append("mp4File=").append(this.ovb).append(10);
        stringBuilder.append("videoFrameCnt=").append(this.ovc).append(10);
        stringBuilder.append("videoLength=").append(this.fXd).append(10);
        stringBuilder.append("cameraCount=").append(this.ovd).append(10);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(76560);
        return stringBuilder2;
    }

    public static p bPJ() {
        AppMethodBeat.i(76561);
        p pVar = new p();
        pVar.fps = 30;
        pVar.rotate = 0;
        pVar.ouT = ouR;
        pVar.ouU = ouQ;
        pVar.lZf = ouR;
        pVar.lZe = ouQ;
        pVar.ouS = 327680;
        pVar.ouV = 4;
        pVar.ouW = 1;
        pVar.ouX = "/sdcard/2.yuv";
        pVar.ovb = "/sdcard/2.mp4";
        pVar.ouY = "/sdcard/2.pcm";
        pVar.ova = "/sdcard/2.x264";
        pVar.ovc = 0;
        pVar.fXd = 0;
        pVar.ovd = 0;
        AppMethodBeat.o(76561);
        return pVar;
    }
}
