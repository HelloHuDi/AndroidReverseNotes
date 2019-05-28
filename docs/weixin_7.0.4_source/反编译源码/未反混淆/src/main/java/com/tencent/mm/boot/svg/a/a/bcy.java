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

public final class bcy extends c {
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
                k.setColor(-436207616);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 66.0f);
                l.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                l.close();
                l.moveTo(19.5f, 24.0f);
                l.lineTo(19.5f, 30.0f);
                l.lineTo(25.5f, 30.0f);
                l.lineTo(25.5f, 24.0f);
                l.lineTo(19.5f, 24.0f);
                l.close();
                l.moveTo(28.5f, 24.0f);
                l.lineTo(28.5f, 30.0f);
                l.lineTo(34.5f, 30.0f);
                l.lineTo(34.5f, 24.0f);
                l.lineTo(28.5f, 24.0f);
                l.close();
                l.moveTo(37.5f, 24.0f);
                l.lineTo(37.5f, 30.0f);
                l.lineTo(43.5f, 30.0f);
                l.lineTo(43.5f, 24.0f);
                l.lineTo(37.5f, 24.0f);
                l.close();
                l.moveTo(46.5f, 24.0f);
                l.lineTo(46.5f, 30.0f);
                l.lineTo(52.5f, 30.0f);
                l.lineTo(52.5f, 24.0f);
                l.lineTo(46.5f, 24.0f);
                l.close();
                l.moveTo(19.5f, 33.0f);
                l.lineTo(19.5f, 39.0f);
                l.lineTo(25.5f, 39.0f);
                l.lineTo(25.5f, 33.0f);
                l.lineTo(19.5f, 33.0f);
                l.close();
                l.moveTo(28.5f, 33.0f);
                l.lineTo(28.5f, 39.0f);
                l.lineTo(34.5f, 39.0f);
                l.lineTo(34.5f, 33.0f);
                l.lineTo(28.5f, 33.0f);
                l.close();
                l.moveTo(27.0f, 45.0f);
                l.lineTo(27.0f, 51.0f);
                l.lineTo(45.0f, 51.0f);
                l.lineTo(45.0f, 45.0f);
                l.lineTo(27.0f, 45.0f);
                l.close();
                l.moveTo(37.5f, 33.0f);
                l.lineTo(37.5f, 39.0f);
                l.lineTo(43.5f, 39.0f);
                l.lineTo(43.5f, 33.0f);
                l.lineTo(37.5f, 33.0f);
                l.close();
                l.moveTo(46.5f, 33.0f);
                l.lineTo(46.5f, 39.0f);
                l.lineTo(52.5f, 39.0f);
                l.lineTo(52.5f, 33.0f);
                l.lineTo(46.5f, 33.0f);
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
