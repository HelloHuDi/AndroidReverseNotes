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

public final class axd extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(46.62213f, 76.7455f);
                l.cubicTo(46.62213f, 76.7455f, 27.0f, 57.136356f, 27.0f, 41.21418f);
                l.cubicTo(27.0f, 29.446882f, 36.40202f, 20.0f, 48.304348f, 20.0f);
                l.cubicTo(59.59798f, 20.0f, 69.0f, 29.446882f, 69.0f, 41.21418f);
                l.cubicTo(69.0f, 57.136356f, 49.37787f, 76.7455f, 49.37787f, 76.7455f);
                l.cubicTo(48.628487f, 77.53978f, 47.383106f, 77.54187f, 46.62213f, 76.7455f);
                l.close();
                l.moveTo(48.0f, 48.0905f);
                l.cubicTo(51.865993f, 48.0905f, 55.0f, 44.94636f, 55.0f, 41.067875f);
                l.cubicTo(55.0f, 37.189384f, 51.865993f, 34.04525f, 48.0f, 34.04525f);
                l.cubicTo(44.134007f, 34.04525f, 41.0f, 37.189384f, 41.0f, 41.067875f);
                l.cubicTo(41.0f, 44.94636f, 44.134007f, 48.0905f, 48.0f, 48.0905f);
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
