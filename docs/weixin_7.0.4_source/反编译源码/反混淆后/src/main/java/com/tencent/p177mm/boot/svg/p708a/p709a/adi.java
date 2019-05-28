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

/* renamed from: com.tencent.mm.boot.svg.a.a.adi */
public final class adi extends C5163c {
    private final int height = 108;
    private final int width = 108;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-14187817);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.lineTo(108.0f, 108.0f);
                l.lineTo(0.0f, 108.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 32.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(60.154037f, 3.58796f);
                l2.lineTo(60.154037f, 40.412003f);
                l2.lineTo(3.845964f, 40.40884f);
                l2.lineTo(3.845964f, 3.58796f);
                l2.lineTo(60.154037f, 3.58796f);
                l2.close();
                l2.moveTo(0.0f, 2.3516667f);
                l2.lineTo(0.0f, 41.64496f);
                l2.cubicTo(0.0f, 42.94329f, 1.0471251f, 43.996597f, 2.3367088f, 43.99667f);
                l2.lineTo(61.66312f, 44.0f);
                l2.cubicTo(62.953594f, 44.000072f, 64.0f, 42.948074f, 64.0f, 41.64831f);
                l2.lineTo(64.0f, 2.3517354f);
                l2.cubicTo(64.0f, 1.0533575f, 62.95285f, 0.0f, 61.663208f, 0.0f);
                l2.lineTo(2.3367934f, 0.0f);
                l2.cubicTo(1.046383f, 0.0f, 0.0f, 1.0519472f, 0.0f, 2.3516667f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(2.9155135f, 0.0f);
                l3.lineTo(-3.5527137E-15f, 2.9199913f);
                l3.lineTo(32.030815f, 35.0f);
                l3.lineTo(62.492252f, 4.491779f);
                l3.lineTo(63.02122f, 2.0014334f);
                l3.lineTo(61.084488f, 0.061725732f);
                l3.lineTo(32.030815f, 29.160017f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l3 = C5163c.m7884l(looper);
                l3.moveTo(2.874115f, 43.0f);
                l3.lineTo(23.0f, 22.874115f);
                l3.lineTo(20.125885f, 20.0f);
                l3.lineTo(0.0f, 40.125885f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l3 = C5163c.m7884l(looper);
                l3.moveTo(63.0f, 41.125885f);
                l3.lineTo(42.874115f, 21.0f);
                l3.lineTo(40.0f, 23.874115f);
                l3.lineTo(60.125885f, 44.0f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
