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

public final class qn extends c {
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
                a.setColor(-14187817);
                Path l = c.l(looper);
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
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a2 = c.a(a2, 1.0f, 0.0f, 7.5f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(2.1213202f, 33.62132f);
                l.cubicTo(0.94974744f, 32.44975f, 0.94974744f, 30.550253f, 2.1213202f, 29.37868f);
                l.lineTo(30.62132f, 0.87867963f);
                l.cubicTo(31.18393f, 0.31607053f, 31.946991f, 3.0425315E-14f, 32.74264f, 2.88658E-14f);
                l.lineTo(52.5f, -1.7763568E-15f);
                l.cubicTo(54.156853f, -2.0807161E-15f, 55.5f, 1.3431457f, 55.5f, 3.0f);
                l.lineTo(55.5f, 22.757359f);
                l.cubicTo(55.5f, 23.553009f, 55.18393f, 24.31607f, 54.62132f, 24.87868f);
                l.lineTo(26.12132f, 53.37868f);
                l.cubicTo(24.949747f, 54.55025f, 23.050253f, 54.55025f, 21.87868f, 53.37868f);
                l.lineTo(2.1213202f, 33.62132f);
                l.close();
                l.moveTo(40.5f, 19.5f);
                l.cubicTo(42.985283f, 19.5f, 45.0f, 17.485281f, 45.0f, 15.0f);
                l.cubicTo(45.0f, 12.514719f, 42.985283f, 10.5f, 40.5f, 10.5f);
                l.cubicTo(38.014717f, 10.5f, 36.0f, 12.514719f, 36.0f, 15.0f);
                l.cubicTo(36.0f, 17.485281f, 38.014717f, 19.5f, 40.5f, 19.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
