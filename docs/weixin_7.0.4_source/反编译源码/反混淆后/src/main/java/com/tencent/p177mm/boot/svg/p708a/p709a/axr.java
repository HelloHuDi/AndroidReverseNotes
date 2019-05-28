package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.axr */
public final class axr extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(48.7577f, 15.974849f);
                l.lineTo(27.774939f, 3.7349038f);
                l.cubicTo(27.466654f, 3.5550714f, 26.53348f, 3.554993f, 26.225061f, 3.7349038f);
                l.lineTo(5.2423f, 15.974849f);
                l.lineTo(27.0f, 28.536663f);
                l.lineTo(48.7577f, 15.974849f);
                l.close();
                l.moveTo(50.4f, 19.183588f);
                l.lineTo(28.8f, 31.654354f);
                l.lineTo(28.8f, 56.89739f);
                l.lineTo(49.59719f, 44.765697f);
                l.cubicTo(49.920998f, 44.57681f, 50.4f, 43.743988f, 50.4f, 43.37328f);
                l.lineTo(50.4f, 19.183588f);
                l.close();
                l.moveTo(3.6f, 19.183588f);
                l.lineTo(3.6f, 43.37328f);
                l.cubicTo(3.6f, 43.73662f, 4.0836716f, 44.579533f, 4.402809f, 44.765697f);
                l.lineTo(25.2f, 56.89739f);
                l.lineTo(25.2f, 31.654354f);
                l.lineTo(3.6f, 19.183588f);
                l.close();
                l.moveTo(24.411127f, 0.62529963f);
                l.cubicTo(25.840921f, -0.20874764f, 28.160156f, -0.20811874f, 29.588873f, 0.62529963f);
                l.lineTo(51.411125f, 13.354947f);
                l.cubicTo(52.840923f, 14.188994f, 54.0f, 16.21864f, 54.0f, 17.856966f);
                l.lineTo(54.0f, 43.37328f);
                l.cubicTo(54.0f, 45.02563f, 52.839844f, 47.04188f, 51.411125f, 47.8753f);
                l.lineTo(29.588873f, 60.604946f);
                l.cubicTo(28.159079f, 61.438995f, 25.839844f, 61.438366f, 24.411127f, 60.604946f);
                l.lineTo(2.5888736f, 47.8753f);
                l.cubicTo(1.1590781f, 47.041252f, 0.0f, 45.01161f, 0.0f, 43.37328f);
                l.lineTo(0.0f, 17.856966f);
                l.cubicTo(0.0f, 16.204617f, 1.1601562f, 14.188366f, 2.5888736f, 13.354947f);
                l.lineTo(24.411127f, 0.62529963f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
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
