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

/* renamed from: com.tencent.mm.boot.svg.a.a.hx */
public final class C37546hx extends C5163c {
    private final int height = 56;
    private final int width = 89;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 89;
            case 1:
                return 56;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-372399);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 27.0f);
                l.cubicTo(0.0f, 12.088312f, 12.096977f, 0.0f, 26.990974f, 0.0f);
                l.lineTo(60.009026f, 0.0f);
                l.cubicTo(74.915726f, 0.0f, 87.0f, 12.085033f, 87.0f, 27.0f);
                l.lineTo(87.0f, 27.0f);
                l.cubicTo(87.0f, 41.91169f, 74.90302f, 54.0f, 60.009026f, 54.0f);
                l.lineTo(26.990974f, 54.0f);
                l.cubicTo(12.084271f, 54.0f, 0.0f, 41.914967f, 0.0f, 27.0f);
                l.lineTo(0.0f, 27.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(30.3f, 24.0f);
                l.cubicTo(31.2f, 24.0f, 31.98f, 24.3f, 32.64f, 24.96f);
                l.cubicTo(33.27f, 25.59f, 33.6f, 26.37f, 33.6f, 27.27f);
                l.cubicTo(33.6f, 28.17f, 33.27f, 28.92f, 32.64f, 29.58f);
                l.cubicTo(31.98f, 30.24f, 31.2f, 30.57f, 30.3f, 30.57f);
                l.cubicTo(29.4f, 30.57f, 28.62f, 30.24f, 27.96f, 29.58f);
                l.cubicTo(27.3f, 28.92f, 27.0f, 28.17f, 27.0f, 27.27f);
                l.cubicTo(27.0f, 26.37f, 27.3f, 25.59f, 27.96f, 24.96f);
                l.cubicTo(28.59f, 24.3f, 29.37f, 24.0f, 30.3f, 24.0f);
                l.close();
                l.moveTo(42.9f, 24.0f);
                l.cubicTo(43.8f, 24.0f, 44.58f, 24.3f, 45.24f, 24.96f);
                l.cubicTo(45.87f, 25.59f, 46.2f, 26.37f, 46.2f, 27.27f);
                l.cubicTo(46.2f, 28.17f, 45.87f, 28.92f, 45.24f, 29.58f);
                l.cubicTo(44.58f, 30.24f, 43.8f, 30.57f, 42.9f, 30.57f);
                l.cubicTo(42.0f, 30.57f, 41.22f, 30.24f, 40.56f, 29.58f);
                l.cubicTo(39.9f, 28.92f, 39.6f, 28.17f, 39.6f, 27.27f);
                l.cubicTo(39.6f, 26.37f, 39.9f, 25.59f, 40.56f, 24.96f);
                l.cubicTo(41.19f, 24.3f, 41.97f, 24.0f, 42.9f, 24.0f);
                l.close();
                l.moveTo(55.5f, 24.0f);
                l.cubicTo(56.4f, 24.0f, 57.18f, 24.3f, 57.84f, 24.96f);
                l.cubicTo(58.47f, 25.59f, 58.8f, 26.37f, 58.8f, 27.27f);
                l.cubicTo(58.8f, 28.17f, 58.47f, 28.92f, 57.84f, 29.58f);
                l.cubicTo(57.18f, 30.24f, 56.4f, 30.57f, 55.5f, 30.57f);
                l.cubicTo(54.6f, 30.57f, 53.82f, 30.24f, 53.16f, 29.58f);
                l.cubicTo(52.5f, 28.92f, 52.2f, 28.17f, 52.2f, 27.27f);
                l.cubicTo(52.2f, 26.37f, 52.5f, 25.59f, 53.16f, 24.96f);
                l.cubicTo(53.79f, 24.3f, 54.57f, 24.0f, 55.5f, 24.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
