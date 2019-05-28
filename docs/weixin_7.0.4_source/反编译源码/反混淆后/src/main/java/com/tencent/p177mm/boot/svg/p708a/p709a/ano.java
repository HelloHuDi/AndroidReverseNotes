package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ano */
public final class ano extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-13421773);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(52.114727f, 1.7835636f);
                l.lineTo(58.5f, 12.0f);
                l.lineTo(73.50182f, 12.0f);
                l.cubicTo(75.9866f, 12.0f, 78.0f, 14.012099f, 78.0f, 16.49415f);
                l.lineTo(78.0f, 55.505848f);
                l.cubicTo(78.0f, 57.98341f, 75.98428f, 60.0f, 73.49778f, 60.0f);
                l.lineTo(4.502223f, 60.0f);
                l.cubicTo(2.0064843f, 60.0f, 0.0f, 57.9879f, 0.0f, 55.505848f);
                l.lineTo(0.0f, 16.49415f);
                l.cubicTo(0.0f, 14.016589f, 2.0139031f, 12.0f, 4.4981785f, 12.0f);
                l.lineTo(19.5f, 12.0f);
                l.lineTo(25.885273f, 1.7835636f);
                l.cubicTo(26.502096f, 0.79664683f, 27.944145f, 0.0f, 29.108805f, 0.0f);
                l.lineTo(48.891193f, 0.0f);
                l.cubicTo(50.05917f, 0.0f, 51.49908f, 0.7985287f, 52.114727f, 1.7835636f);
                l.close();
                l.moveTo(39.0f, 51.0f);
                l.cubicTo(48.941124f, 51.0f, 57.0f, 42.941124f, 57.0f, 33.0f);
                l.cubicTo(57.0f, 23.058874f, 48.941124f, 15.0f, 39.0f, 15.0f);
                l.cubicTo(29.058874f, 15.0f, 21.0f, 23.058874f, 21.0f, 33.0f);
                l.cubicTo(21.0f, 42.941124f, 29.058874f, 51.0f, 39.0f, 51.0f);
                l.close();
                l.moveTo(39.0f, 45.0f);
                l.cubicTo(32.37258f, 45.0f, 27.0f, 39.62742f, 27.0f, 33.0f);
                l.cubicTo(27.0f, 26.372583f, 32.37258f, 21.0f, 39.0f, 21.0f);
                l.cubicTo(45.62742f, 21.0f, 51.0f, 26.372583f, 51.0f, 33.0f);
                l.cubicTo(51.0f, 39.62742f, 45.62742f, 45.0f, 39.0f, 45.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
