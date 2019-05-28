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

public final class ahq extends c {
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
                k2 = c.a(k, looper);
                k2.setColor(-14046139);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(k2, looper));
                canvas.restore();
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(48.7577f, 15.974849f);
                l2.lineTo(27.774939f, 3.7349038f);
                l2.cubicTo(27.466654f, 3.5550714f, 26.53348f, 3.554993f, 26.225061f, 3.7349038f);
                l2.lineTo(5.2423f, 15.974849f);
                l2.lineTo(27.0f, 28.536663f);
                l2.lineTo(48.7577f, 15.974849f);
                l2.close();
                l2.moveTo(50.4f, 19.183588f);
                l2.lineTo(28.8f, 31.654354f);
                l2.lineTo(28.8f, 56.89739f);
                l2.lineTo(49.59719f, 44.765697f);
                l2.cubicTo(49.920998f, 44.57681f, 50.4f, 43.743988f, 50.4f, 43.37328f);
                l2.lineTo(50.4f, 19.183588f);
                l2.close();
                l2.moveTo(3.6f, 19.183588f);
                l2.lineTo(3.6f, 43.37328f);
                l2.cubicTo(3.6f, 43.73662f, 4.0836716f, 44.579533f, 4.402809f, 44.765697f);
                l2.lineTo(25.2f, 56.89739f);
                l2.lineTo(25.2f, 31.654354f);
                l2.lineTo(3.6f, 19.183588f);
                l2.close();
                l2.moveTo(24.411127f, 0.62529963f);
                l2.cubicTo(25.840921f, -0.20874764f, 28.160156f, -0.20811874f, 29.588873f, 0.62529963f);
                l2.lineTo(51.411125f, 13.354947f);
                l2.cubicTo(52.840923f, 14.188994f, 54.0f, 16.21864f, 54.0f, 17.856966f);
                l2.lineTo(54.0f, 43.37328f);
                l2.cubicTo(54.0f, 45.02563f, 52.839844f, 47.04188f, 51.411125f, 47.8753f);
                l2.lineTo(29.588873f, 60.604946f);
                l2.cubicTo(28.159079f, 61.438995f, 25.839844f, 61.438366f, 24.411127f, 60.604946f);
                l2.lineTo(2.5888736f, 47.8753f);
                l2.cubicTo(1.1590781f, 47.041252f, 0.0f, 45.01161f, 0.0f, 43.37328f);
                l2.lineTo(0.0f, 17.856966f);
                l2.cubicTo(0.0f, 16.204617f, 1.1601562f, 14.188366f, 2.5888736f, 13.354947f);
                l2.lineTo(24.411127f, 0.62529963f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
