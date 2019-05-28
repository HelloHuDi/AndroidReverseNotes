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

public final class ank extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                k = c.a(k, looper);
                k.setColor(-15028967);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(31.45011f, 60.4841f);
                l.lineTo(32.711105f, 58.771122f);
                l.lineTo(32.711105f, 58.771122f);
                l.cubicTo(33.36593f, 57.881584f, 34.61788f, 57.69131f, 35.50742f, 58.346134f);
                l.cubicTo(35.51739f, 58.353477f, 35.527294f, 58.36091f, 35.53713f, 58.36843f);
                l.lineTo(49.747337f, 69.241776f);
                l.lineTo(49.747337f, 69.241776f);
                l.cubicTo(50.4887f, 69.80905f, 51.523895f, 69.78802f, 52.241604f, 69.19109f);
                l.lineTo(89.730385f, 38.011433f);
                l.lineTo(89.730385f, 38.011433f);
                l.cubicTo(90.52095f, 37.35392f, 91.68126f, 37.403004f, 92.41347f, 38.124935f);
                l.lineTo(93.147606f, 38.848774f);
                l.lineTo(93.147606f, 38.848774f);
                l.cubicTo(93.93415f, 39.624283f, 93.9431f, 40.89058f, 93.16759f, 41.677128f);
                l.cubicTo(93.16016f, 41.684666f, 93.152664f, 41.692146f, 93.14511f, 41.699566f);
                l.lineTo(52.450825f, 81.68274f);
                l.lineTo(52.450825f, 81.68274f);
                l.cubicTo(51.66292f, 82.45688f, 50.39664f, 82.44572f, 49.62251f, 81.657814f);
                l.cubicTo(49.618988f, 81.65423f, 49.615482f, 81.650635f, 49.611988f, 81.647026f);
                l.lineTo(31.623617f, 63.060673f);
                l.lineTo(31.623617f, 63.060673f);
                l.cubicTo(30.944754f, 62.35924f, 30.871418f, 61.270214f, 31.45011f, 60.4841f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
