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

public final class awm extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(0.0f, 3.0f);
                l.cubicTo(0.0f, 1.3431456f, 1.3431456f, 0.0f, 3.0f, 0.0f);
                l.lineTo(55.5f, 0.0f);
                l.cubicTo(57.156853f, 0.0f, 58.5f, 1.3431456f, 58.5f, 3.0f);
                l.lineTo(58.5f, 55.5f);
                l.cubicTo(58.5f, 57.156853f, 57.156853f, 58.5f, 55.5f, 58.5f);
                l.lineTo(3.0f, 58.5f);
                l.cubicTo(1.3431456f, 58.5f, 0.0f, 57.156853f, 0.0f, 55.5f);
                l.lineTo(0.0f, 3.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                l = c.l(looper);
                l.moveTo(31.5f, 18.0f);
                l.lineTo(31.5f, 46.5f);
                l.cubicTo(31.5f, 47.328426f, 30.828426f, 48.0f, 30.0f, 48.0f);
                l.lineTo(27.0f, 48.0f);
                l.cubicTo(26.171574f, 48.0f, 25.5f, 47.328426f, 25.5f, 46.5f);
                l.lineTo(25.5f, 18.0f);
                l.lineTo(13.5f, 18.0f);
                l.cubicTo(12.671573f, 18.0f, 12.0f, 17.328426f, 12.0f, 16.5f);
                l.lineTo(12.0f, 13.5f);
                l.cubicTo(12.0f, 12.671573f, 12.671573f, 12.0f, 13.5f, 12.0f);
                l.lineTo(45.0f, 12.0f);
                l.cubicTo(45.828426f, 12.0f, 46.5f, 12.671573f, 46.5f, 13.5f);
                l.lineTo(46.5f, 16.5f);
                l.cubicTo(46.5f, 17.328426f, 45.828426f, 18.0f, 45.0f, 18.0f);
                l.lineTo(31.5f, 18.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
