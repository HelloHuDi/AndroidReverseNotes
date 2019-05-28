package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.qr */
public final class C32391qr extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-352965);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                l.lineTo(120.0f, 108.0f);
                l.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                l.lineTo(12.0f, 120.0f);
                l.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(84.2129f, 73.166664f);
                l.lineTo(77.898056f, 73.166664f);
                l.lineTo(77.898056f, 76.333336f);
                l.lineTo(84.2129f, 76.333336f);
                l.lineTo(84.2129f, 82.666664f);
                l.lineTo(87.370316f, 82.666664f);
                l.lineTo(87.370316f, 76.333336f);
                l.lineTo(93.68516f, 76.333336f);
                l.lineTo(93.68516f, 73.166664f);
                l.lineTo(87.370316f, 73.166664f);
                l.lineTo(87.370316f, 66.833336f);
                l.lineTo(84.2129f, 66.833336f);
                l.lineTo(84.2129f, 73.166664f);
                l.close();
                l.moveTo(67.42371f, 70.079285f);
                l.cubicTo(67.04714f, 71.57356f, 66.847084f, 73.13834f, 66.847084f, 74.75f);
                l.cubicTo(66.847084f, 80.42489f, 69.32752f, 85.51856f, 73.26041f, 89.0f);
                l.lineTo(30.74431f, 89.0f);
                l.cubicTo(28.998022f, 89.0f, 27.783651f, 87.60048f, 28.032288f, 85.87163f);
                l.lineTo(28.33345f, 83.77754f);
                l.cubicTo(28.638906f, 81.65361f, 30.436558f, 79.121124f, 32.358017f, 78.116165f);
                l.lineTo(49.048275f, 69.38685f);
                l.cubicTo(51.59825f, 68.05316f, 52.127117f, 65.226555f, 50.227116f, 63.0707f);
                l.lineTo(48.833565f, 61.489502f);
                l.cubicTo(46.46028f, 58.796635f, 44.53635f, 53.717762f, 44.53635f, 50.146694f);
                l.lineTo(44.53635f, 44.955544f);
                l.cubicTo(44.53635f, 37.800396f, 50.373653f, 32.0f, 57.57787f, 32.0f);
                l.cubicTo(64.7805f, 32.0f, 70.61939f, 37.80192f, 70.61939f, 44.955544f);
                l.lineTo(70.61939f, 50.146694f);
                l.cubicTo(70.61939f, 53.71829f, 68.6945f, 58.798832f, 66.322174f, 61.491985f);
                l.lineTo(64.92863f, 63.073994f);
                l.cubicTo(63.029705f, 65.22971f, 63.56034f, 68.05949f, 66.10747f, 69.39114f);
                l.lineTo(67.42371f, 70.079285f);
                l.close();
                l.moveTo(71.58321f, 74.75129f);
                l.cubicTo(71.58321f, 66.88027f, 77.944855f, 60.5f, 85.79161f, 60.5f);
                l.cubicTo(93.63965f, 60.5f, 100.0f, 66.88027f, 100.0f, 74.75129f);
                l.cubicTo(100.0f, 82.621025f, 93.63965f, 89.0f, 85.79161f, 89.0f);
                l.cubicTo(78.66269f, 89.0f, 72.7596f, 83.734764f, 71.739204f, 76.86994f);
                l.cubicTo(71.63645f, 76.178696f, 71.58321f, 75.47123f, 71.58321f, 74.75129f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
