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

public final class air extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -168.0f, 0.0f, 1.0f, -60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 168.0f, 0.0f, 1.0f, 60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(24.0f, 24.0f);
                l.lineTo(0.0f, 24.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(1.5f);
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(0.75f, 5.266332f);
                l.lineTo(0.75f, 12.733709f);
                l.lineTo(5.1924944f, 12.733709f);
                l.lineTo(11.25f, 17.016748f);
                l.lineTo(11.25f, 0.9832927f);
                l.lineTo(5.1924944f, 5.266332f);
                l.lineTo(0.75f, 5.266332f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(21.336575f, 12.275914f);
                l2.lineTo(23.49325f, 14.4325905f);
                l2.cubicTo(23.571356f, 14.510695f, 23.571356f, 14.637328f, 23.49325f, 14.715433f);
                l2.lineTo(22.715433f, 15.49325f);
                l2.cubicTo(22.637327f, 15.571355f, 22.510695f, 15.571355f, 22.43259f, 15.49325f);
                l2.lineTo(20.275915f, 13.336575f);
                l2.lineTo(18.119238f, 15.49325f);
                l2.cubicTo(18.041134f, 15.571355f, 17.914501f, 15.571355f, 17.836395f, 15.49325f);
                l2.lineTo(17.058578f, 14.715433f);
                l2.cubicTo(16.980474f, 14.637328f, 16.980474f, 14.510695f, 17.058578f, 14.4325905f);
                l2.lineTo(19.215254f, 12.275914f);
                l2.lineTo(17.058578f, 10.119239f);
                l2.cubicTo(16.980474f, 10.041134f, 16.980474f, 9.914501f, 17.058578f, 9.836396f);
                l2.lineTo(17.836395f, 9.0585785f);
                l2.cubicTo(17.914501f, 8.9804735f, 18.041134f, 8.9804735f, 18.119238f, 9.0585785f);
                l2.lineTo(20.275915f, 11.215254f);
                l2.lineTo(22.43259f, 9.0585785f);
                l2.cubicTo(22.510695f, 8.9804735f, 22.637327f, 8.9804735f, 22.715433f, 9.0585785f);
                l2.lineTo(23.49325f, 9.836396f);
                l2.cubicTo(23.571356f, 9.914501f, 23.571356f, 10.041134f, 23.49325f, 10.119239f);
                l2.lineTo(21.336575f, 12.275914f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
