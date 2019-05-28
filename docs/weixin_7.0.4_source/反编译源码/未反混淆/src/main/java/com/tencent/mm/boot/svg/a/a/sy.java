package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class sy extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-436207616);
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(30.0f, 60.0f);
                l.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                l.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                l.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                l.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                l.close();
                l.moveTo(30.0f, 56.4f);
                l.cubicTo(44.58032f, 56.4f, 56.4f, 44.58032f, 56.4f, 30.0f);
                l.cubicTo(56.4f, 15.4196825f, 44.58032f, 3.6f, 30.0f, 3.6f);
                l.cubicTo(15.4196825f, 3.6f, 3.6f, 15.4196825f, 3.6f, 30.0f);
                l.cubicTo(3.6f, 44.58032f, 15.4196825f, 56.4f, 30.0f, 56.4f);
                l.close();
                l.moveTo(12.0f, 31.5f);
                l.lineTo(48.0f, 31.5f);
                l.cubicTo(48.0f, 41.441124f, 39.941124f, 49.5f, 30.0f, 49.5f);
                l.cubicTo(20.058874f, 49.5f, 12.0f, 41.441124f, 12.0f, 31.5f);
                l.close();
                l.moveTo(30.0f, 45.9f);
                l.cubicTo(36.709824f, 45.9f, 42.347782f, 41.310818f, 43.94634f, 35.1f);
                l.lineTo(16.053663f, 35.1f);
                l.cubicTo(17.652218f, 41.310818f, 23.290178f, 45.9f, 30.0f, 45.9f);
                l.close();
                l.moveTo(19.5f, 25.5f);
                l.cubicTo(17.014719f, 25.5f, 15.0f, 23.485281f, 15.0f, 21.0f);
                l.cubicTo(15.0f, 18.514719f, 17.014719f, 16.5f, 19.5f, 16.5f);
                l.cubicTo(21.985281f, 16.5f, 24.0f, 18.514719f, 24.0f, 21.0f);
                l.cubicTo(24.0f, 23.485281f, 21.985281f, 25.5f, 19.5f, 25.5f);
                l.close();
                l.moveTo(40.5f, 25.5f);
                l.cubicTo(38.014717f, 25.5f, 36.0f, 23.485281f, 36.0f, 21.0f);
                l.cubicTo(36.0f, 18.514719f, 38.014717f, 16.5f, 40.5f, 16.5f);
                l.cubicTo(42.985283f, 16.5f, 45.0f, 18.514719f, 45.0f, 21.0f);
                l.cubicTo(45.0f, 23.485281f, 42.985283f, 25.5f, 40.5f, 25.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
