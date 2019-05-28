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

public final class gw extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(11.0f, 15.0f);
                l.lineTo(44.0f, 15.0f);
                l.lineTo(44.0f, 48.0f);
                l.lineTo(11.0f, 48.0f);
                l.lineTo(11.0f, 15.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-2012855);
                Path l2 = c.l(looper);
                l2.moveTo(30.0f, 28.37868f);
                l2.lineTo(20.454058f, 18.832739f);
                l2.lineTo(18.332739f, 20.954058f);
                l2.lineTo(27.87868f, 30.5f);
                l2.lineTo(18.332739f, 40.04594f);
                l2.lineTo(20.454058f, 42.167263f);
                l2.lineTo(30.0f, 32.62132f);
                l2.lineTo(39.54594f, 42.167263f);
                l2.lineTo(41.667263f, 40.04594f);
                l2.lineTo(32.12132f, 30.5f);
                l2.lineTo(41.667263f, 20.954058f);
                l2.lineTo(39.54594f, 18.832739f);
                l2.lineTo(30.0f, 28.37868f);
                l2.close();
                l2.moveTo(30.0f, 60.0f);
                l2.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                l2.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                l2.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                l2.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
