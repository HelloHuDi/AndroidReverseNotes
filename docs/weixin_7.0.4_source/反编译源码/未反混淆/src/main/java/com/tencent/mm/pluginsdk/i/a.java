package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a {
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
        AppMethodBeat.i(27460);
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
        AppMethodBeat.o(27460);
        return stringBuilder2;
    }

    public static a diE() {
        AppMethodBeat.i(27461);
        a aVar = new a();
        aVar.fps = 30;
        aVar.rotate = 0;
        aVar.ouT = 640;
        aVar.ouU = 480;
        aVar.lZf = 640;
        aVar.lZe = 480;
        aVar.ouS = 1440000;
        aVar.ouV = 1;
        aVar.ouW = 4;
        aVar.ouX = "/sdcard/1.yuv";
        aVar.ovb = "/sdcard/1.mp4";
        aVar.ouY = "/sdcard/1.pcm";
        aVar.ova = "/sdcard/1.x264";
        aVar.ovc = 0;
        aVar.fXd = 0;
        aVar.ovd = 0;
        AppMethodBeat.o(27461);
        return aVar;
    }

    public static a diF() {
        AppMethodBeat.i(27462);
        a aVar = new a();
        aVar.fps = 30;
        aVar.rotate = 0;
        aVar.ouT = ouR;
        aVar.ouU = ouQ;
        aVar.lZf = ouR;
        aVar.lZe = ouQ;
        aVar.ouS = 327680;
        aVar.ouV = 4;
        aVar.ouW = 1;
        aVar.ouX = "/sdcard/2.yuv";
        aVar.ovb = "/sdcard/2.mp4";
        aVar.ouY = "/sdcard/2.pcm";
        aVar.ova = "/sdcard/2.x264";
        aVar.ovc = 0;
        aVar.fXd = 0;
        aVar.ovd = 0;
        AppMethodBeat.o(27462);
        return aVar;
    }
}
