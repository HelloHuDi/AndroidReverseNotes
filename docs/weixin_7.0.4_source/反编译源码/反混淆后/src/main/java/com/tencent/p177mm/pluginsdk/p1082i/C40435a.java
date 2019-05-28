package com.tencent.p177mm.pluginsdk.p1082i;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
/* renamed from: com.tencent.mm.pluginsdk.i.a */
public final class C40435a {
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
        AppMethodBeat.m2504i(27460);
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
        AppMethodBeat.m2505o(27460);
        return stringBuilder2;
    }

    public static C40435a diE() {
        AppMethodBeat.m2504i(27461);
        C40435a c40435a = new C40435a();
        c40435a.fps = 30;
        c40435a.rotate = 0;
        c40435a.ouT = 640;
        c40435a.ouU = 480;
        c40435a.lZf = 640;
        c40435a.lZe = 480;
        c40435a.ouS = 1440000;
        c40435a.ouV = 1;
        c40435a.ouW = 4;
        c40435a.ouX = "/sdcard/1.yuv";
        c40435a.ovb = "/sdcard/1.mp4";
        c40435a.ouY = "/sdcard/1.pcm";
        c40435a.ova = "/sdcard/1.x264";
        c40435a.ovc = 0;
        c40435a.fXd = 0;
        c40435a.ovd = 0;
        AppMethodBeat.m2505o(27461);
        return c40435a;
    }

    public static C40435a diF() {
        AppMethodBeat.m2504i(27462);
        C40435a c40435a = new C40435a();
        c40435a.fps = 30;
        c40435a.rotate = 0;
        c40435a.ouT = ouR;
        c40435a.ouU = ouQ;
        c40435a.lZf = ouR;
        c40435a.lZe = ouQ;
        c40435a.ouS = 327680;
        c40435a.ouV = 4;
        c40435a.ouW = 1;
        c40435a.ouX = "/sdcard/2.yuv";
        c40435a.ovb = "/sdcard/2.mp4";
        c40435a.ouY = "/sdcard/2.pcm";
        c40435a.ova = "/sdcard/2.x264";
        c40435a.ovc = 0;
        c40435a.fXd = 0;
        c40435a.ovd = 0;
        AppMethodBeat.m2505o(27462);
        return c40435a;
    }
}
