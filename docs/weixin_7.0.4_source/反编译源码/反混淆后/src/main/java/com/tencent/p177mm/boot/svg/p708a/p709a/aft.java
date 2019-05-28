package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aft */
public final class aft extends C5163c {
    private final int height = 160;
    private final int width = 160;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 160;
            case 1:
                return 160;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-1250068);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(79.01384f, 0.0f);
                l.lineTo(82.41509f, 0.0f);
                l.cubicTo(101.12201f, 0.5937107f, 119.53711f, 7.889308f, 133.41383f, 20.467924f);
                l.cubicTo(149.52452f, 34.767296f, 159.2956f, 55.79874f, 160.0f, 77.31321f);
                l.lineTo(160.0f, 82.485535f);
                l.cubicTo(159.38617f, 101.41383f, 151.89937f, 120.04025f, 139.039f, 133.9673f);
                l.cubicTo(124.890564f, 149.62515f, 104.3522f, 159.07422f, 83.290565f, 160.0f);
                l.lineTo(79.0239f, 160.0f);
                l.cubicTo(60.286793f, 159.8088f, 41.730816f, 152.78491f, 27.62264f, 140.4478f);
                l.cubicTo(10.898113f, 126.11824f, 0.7044025f, 104.64403f, 0.0f, 82.64654f);
                l.lineTo(0.0f, 77.58491f);
                l.cubicTo(0.6238994f, 55.74843f, 10.616352f, 34.415092f, 27.069183f, 20.03522f);
                l.cubicTo(41.237736f, 7.4163523f, 60.03522f, 0.20125785f, 79.01384f, 0.0f);
                l.lineTo(79.01384f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-3355444);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 41.0f, 0.0f, 1.0f, 44.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(8.019949f, 1.1661674f);
                l.cubicTo(28.676641f, 0.93631184f, 49.343307f, 0.95629925f, 70.0f, 1.1561736f);
                l.lineTo(70.0f, 6.8525925f);
                l.cubicTo(49.333332f, 7.052467f, 28.666666f, 7.0424733f, 8.0f, 6.8625865f);
                l.cubicTo(8.0f, 4.96378f, 8.0f, 3.0649736f, 8.019949f, 1.1661674f);
                l.lineTo(8.019949f, 1.1661674f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(5.850852f, 10.178336f);
                l.cubicTo(27.607054f, 9.930755f, 49.383244f, 9.950561f, 71.12945f, 10.178336f);
                l.cubicTo(72.83836f, 17.189867f, 74.42736f, 24.221203f, 76.156265f, 31.232735f);
                l.cubicTo(76.64595f, 33.668945f, 77.45544f, 36.233894f, 76.675934f, 38.709717f);
                l.cubicTo(75.586624f, 42.463066f, 71.249374f, 44.74082f, 67.481766f, 43.74059f);
                l.cubicTo(64.83344f, 43.29494f, 63.334393f, 40.87854f, 61.705425f, 39.026623f);
                l.cubicTo(59.616753f, 41.512352f, 57.09835f, 44.42392f, 53.44067f, 43.94856f);
                l.cubicTo(50.132767f, 43.94856f, 47.99412f, 41.29448f, 46.195263f, 38.917686f);
                l.cubicTo(44.346436f, 41.45293f, 41.937965f, 44.186237f, 38.450176f, 43.988174f);
                l.cubicTo(35.02235f, 44.146626f, 32.69383f, 41.45293f, 30.864986f, 38.977108f);
                l.cubicTo(28.976185f, 41.264767f, 26.857529f, 43.968365f, 23.55962f, 43.94856f);
                l.cubicTo(19.90194f, 44.414013f, 17.383537f, 41.512352f, 15.284868f, 39.036526f);
                l.cubicTo(13.785819f, 40.70028f, 12.506631f, 42.849293f, 10.228076f, 43.55243f);
                l.cubicTo(6.370522f, 44.94879f, 1.5235963f, 42.760166f, 0.3543379f, 38.798847f);
                l.cubicTo(-0.48512965f, 36.27351f, 0.36433157f, 33.639233f, 0.8740083f, 31.143604f);
                l.cubicTo(2.6029117f, 24.171686f, 4.1819105f, 17.170061f, 5.850852f, 10.178336f);
                l.lineTo(5.850852f, 10.178336f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(8.077558f, 48.74243f);
                l.cubicTo(10.055874f, 48.158264f, 12.044182f, 47.574097f, 14.022499f, 47.0f);
                l.cubicTo(14.082448f, 52.15679f, 13.9525585f, 57.30351f, 14.062465f, 62.4603f);
                l.cubicTo(16.550348f, 59.37831f, 18.798435f, 56.11503f, 21.276327f, 53.02297f);
                l.cubicTo(33.096268f, 52.932323f, 44.91621f, 52.912178f, 56.736153f, 53.033043f);
                l.cubicTo(59.204056f, 56.125103f, 61.45214f, 59.388382f, 63.940025f, 62.4603f);
                l.cubicTo(64.049934f, 57.31358f, 63.93003f, 52.15679f, 63.979992f, 47.0f);
                l.cubicTo(65.958305f, 47.574097f, 67.94662f, 48.158264f, 69.924934f, 48.74243f);
                l.cubicTo(69.99487f, 56.11503f, 70.07481f, 63.4977f, 69.86498f, 70.8703f);
                l.cubicTo(49.29249f, 71.03145f, 28.710001f, 71.06167f, 8.147498f, 70.85016f);
                l.cubicTo(7.9176936f, 63.48763f, 8.007617f, 56.11503f, 8.077558f, 48.74243f);
                l.lineTo(8.077558f, 48.74243f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
