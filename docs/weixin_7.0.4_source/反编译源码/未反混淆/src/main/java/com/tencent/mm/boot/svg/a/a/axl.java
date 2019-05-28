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

public final class axl extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(10.320658f, 10.199991f);
                l2.lineTo(12.757717f, 51.142605f);
                l2.cubicTo(12.833185f, 52.410458f, 13.88338f, 53.4f, 15.153477f, 53.4f);
                l2.lineTo(36.846523f, 53.4f);
                l2.cubicTo(38.11662f, 53.4f, 39.166817f, 52.410458f, 39.242283f, 51.142605f);
                l2.lineTo(41.679344f, 10.199991f);
                l2.lineTo(10.320658f, 10.199991f);
                l2.close();
                l2.moveTo(45.285713f, 10.199991f);
                l2.lineTo(42.835922f, 51.35651f);
                l2.cubicTo(42.647255f, 54.526142f, 40.021767f, 57.0f, 36.846523f, 57.0f);
                l2.lineTo(15.153477f, 57.0f);
                l2.cubicTo(11.978235f, 57.0f, 9.352747f, 54.526142f, 9.164078f, 51.35651f);
                l2.lineTo(6.714286f, 10.199991f);
                l2.lineTo(0.5f, 10.199991f);
                l2.lineTo(0.5f, 8.099991f);
                l2.cubicTo(0.5f, 7.2715635f, 1.1715729f, 6.599991f, 2.0f, 6.599991f);
                l2.lineTo(50.0f, 6.599991f);
                l2.cubicTo(50.828426f, 6.599991f, 51.5f, 7.2715635f, 51.5f, 8.099991f);
                l2.lineTo(51.5f, 10.199991f);
                l2.lineTo(45.285713f, 10.199991f);
                l2.close();
                l2.moveTo(32.0f, 8.1856706E-5f);
                l2.cubicTo(32.828426f, 8.1856706E-5f, 33.5f, 0.67165476f, 33.5f, 1.5000819f);
                l2.lineTo(33.5f, 3.6000726f);
                l2.lineTo(18.5f, 3.6000726f);
                l2.lineTo(18.5f, 1.5000819f);
                l2.cubicTo(18.5f, 0.67165476f, 19.171574f, 8.1856706E-5f, 20.0f, 8.1856706E-5f);
                l2.lineTo(32.0f, 8.1856706E-5f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l3 = c.l(looper);
                l3.moveTo(18.5f, 18.0f);
                l3.lineTo(22.100037f, 18.0f);
                l3.lineTo(23.600037f, 45.0f);
                l3.lineTo(20.0f, 45.0f);
                l3.lineTo(18.5f, 18.0f);
                l3.close();
                l3.moveTo(29.899963f, 18.0f);
                l3.lineTo(33.5f, 18.0f);
                l3.lineTo(32.0f, 45.0f);
                l3.lineTo(28.399963f, 45.0f);
                l3.lineTo(29.899963f, 18.0f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
