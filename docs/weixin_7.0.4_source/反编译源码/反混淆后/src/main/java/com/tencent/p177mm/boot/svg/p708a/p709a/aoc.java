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

/* renamed from: com.tencent.mm.boot.svg.a.a.aoc */
public final class aoc extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 0.8660254f, -0.5f, 48.0f, 0.5f, 0.8660254f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(33.0f, 18.0f);
                l.cubicTo(33.0f, 9.715729f, 39.71573f, 3.0f, 48.0f, 3.0f);
                l.lineTo(48.0f, 3.0f);
                l.cubicTo(56.28427f, 3.0f, 63.0f, 9.715729f, 63.0f, 18.0f);
                l.lineTo(63.0f, 42.0f);
                l.cubicTo(63.0f, 50.28427f, 56.28427f, 57.0f, 48.0f, 57.0f);
                l.lineTo(48.0f, 57.0f);
                l.cubicTo(39.71573f, 57.0f, 33.0f, 50.28427f, 33.0f, 42.0f);
                l.lineTo(33.0f, 18.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(27.0f, 33.0f);
                l.lineTo(27.0f, 42.0f);
                l.cubicTo(27.0f, 53.59798f, 36.40202f, 63.0f, 48.0f, 63.0f);
                l.cubicTo(59.59798f, 63.0f, 69.0f, 53.59798f, 69.0f, 42.0f);
                l.lineTo(69.0f, 33.0f);
                l.lineTo(75.0f, 33.0f);
                l.lineTo(75.0f, 42.0f);
                l.cubicTo(75.0f, 56.91169f, 62.91169f, 69.0f, 48.0f, 69.0f);
                l.cubicTo(33.08831f, 69.0f, 21.0f, 56.91169f, 21.0f, 42.0f);
                l.lineTo(21.0f, 33.0f);
                l.lineTo(27.0f, 33.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(45.0f, 66.0f);
                l2.lineTo(51.0f, 66.0f);
                l2.lineTo(51.0f, 75.0f);
                l2.lineTo(45.0f, 75.0f);
                l2.lineTo(45.0f, 66.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(45.0f, 78.0f);
                l.lineTo(51.0f, 78.0f);
                l.lineTo(48.55106f, 83.68582f);
                l.cubicTo(48.419975f, 83.990166f, 48.066994f, 84.130615f, 47.762653f, 83.999535f);
                l.cubicTo(47.62184f, 83.93888f, 47.50959f, 83.82663f, 47.44894f, 83.68582f);
                l.lineTo(45.0f, 78.0f);
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
