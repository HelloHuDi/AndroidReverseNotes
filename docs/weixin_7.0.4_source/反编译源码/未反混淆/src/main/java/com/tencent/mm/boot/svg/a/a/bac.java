package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bac extends c {
    private final int height = 210;
    private final int width = 210;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-2471350);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(105.0f, 0.0f);
                l.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                l.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                l.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                l.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k2 = c.a(k, looper);
                k2.setColor(1275068416);
                canvas.save();
                a = c.a(k2, looper);
                l = c.l(looper);
                l.moveTo(105.0f, 0.0f);
                l.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                l.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                l.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                l.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(105.0f, 96.46164f);
                l.cubicTo(93.324905f, 96.46164f, 85.05575f, 99.22135f, 83.17065f, 101.40075f);
                l.cubicTo(81.28554f, 103.58014f, 79.694786f, 112.07398f, 77.24351f, 114.4038f);
                l.cubicTo(76.0654f, 115.52354f, 63.405796f, 117.93891f, 61.901104f, 118.25871f);
                l.cubicTo(60.39641f, 118.578514f, 58.85897f, 118.73449f, 58.145496f, 117.714584f);
                l.cubicTo(57.432022f, 116.69469f, 51.136547f, 103.91579f, 60.94151f, 96.85904f);
                l.cubicTo(70.746475f, 89.8023f, 91.694466f, 87.15565f, 105.0f, 87.0f);
                l.lineTo(105.0f, 96.46164f);
                l.close();
                l.moveTo(105.0f, 96.46164f);
                l.cubicTo(116.675095f, 96.46164f, 124.94425f, 99.22135f, 126.82935f, 101.40075f);
                l.cubicTo(128.71446f, 103.58014f, 130.30522f, 112.07398f, 132.7565f, 114.4038f);
                l.cubicTo(133.9346f, 115.52354f, 146.59421f, 117.93891f, 148.09889f, 118.25871f);
                l.cubicTo(149.60359f, 118.578514f, 151.14102f, 118.73449f, 151.8545f, 117.714584f);
                l.cubicTo(152.56798f, 116.69469f, 158.86345f, 103.91579f, 149.05849f, 96.85904f);
                l.cubicTo(139.25352f, 89.8023f, 118.305534f, 87.15565f, 105.0f, 87.0f);
                l.lineTo(105.0f, 96.46164f);
                l.close();
                canvas.saveLayerAlpha(null, 179, 4);
                Paint a2 = c.a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
