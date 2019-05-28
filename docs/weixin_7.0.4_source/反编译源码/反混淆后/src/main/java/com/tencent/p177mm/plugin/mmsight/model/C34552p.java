package com.tencent.p177mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.mmsight.model.p */
public final class C34552p {
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
        AppMethodBeat.m2504i(76560);
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
        AppMethodBeat.m2505o(76560);
        return stringBuilder2;
    }

    public static C34552p bPJ() {
        AppMethodBeat.m2504i(76561);
        C34552p c34552p = new C34552p();
        c34552p.fps = 30;
        c34552p.rotate = 0;
        c34552p.ouT = ouR;
        c34552p.ouU = ouQ;
        c34552p.lZf = ouR;
        c34552p.lZe = ouQ;
        c34552p.ouS = 327680;
        c34552p.ouV = 4;
        c34552p.ouW = 1;
        c34552p.ouX = "/sdcard/2.yuv";
        c34552p.ovb = "/sdcard/2.mp4";
        c34552p.ouY = "/sdcard/2.pcm";
        c34552p.ova = "/sdcard/2.x264";
        c34552p.ovc = 0;
        c34552p.fXd = 0;
        c34552p.ovd = 0;
        AppMethodBeat.m2505o(76561);
        return c34552p;
    }
}
