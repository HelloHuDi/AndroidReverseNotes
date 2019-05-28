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

/* renamed from: com.tencent.mm.boot.svg.a.a.wz */
public final class C45261wz extends C5163c {
    private final int height = 20;
    private final int width = 15;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 15;
            case 1:
                return 20;
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
                canvas.save();
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -278.0f, 0.0f, 1.0f, -114.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(286.1f, 115.882835f);
                l.lineTo(286.1f, 125.12132f);
                l.lineTo(284.9f, 125.12132f);
                l.lineTo(284.9f, 115.88285f);
                l.lineTo(282.813f, 117.96985f);
                l.lineTo(281.96448f, 117.12132f);
                l.lineTo(284.7929f, 114.29289f);
                l.cubicTo(285.1834f, 113.90237f, 285.8166f, 113.90237f, 286.2071f, 114.29289f);
                l.lineTo(286.34854f, 114.43432f);
                l.lineTo(289.03552f, 117.12132f);
                l.lineTo(288.187f, 117.96985f);
                l.lineTo(286.1f, 115.882835f);
                l.close();
                l.moveTo(281.0f, 118.62132f);
                l.lineTo(281.0f, 119.82132f);
                l.lineTo(279.2f, 119.82132f);
                l.lineTo(279.2f, 132.42133f);
                l.lineTo(291.8f, 132.42133f);
                l.lineTo(291.8f, 119.82132f);
                l.lineTo(290.0f, 119.82132f);
                l.lineTo(290.0f, 118.62132f);
                l.lineTo(292.00104f, 118.62132f);
                l.cubicTo(292.55087f, 118.62132f, 293.0f, 119.06716f, 293.0f, 119.61713f);
                l.lineTo(293.0f, 132.62552f);
                l.cubicTo(293.0f, 133.1724f, 292.55417f, 133.62132f, 292.00418f, 133.62132f);
                l.lineTo(278.99582f, 133.62132f);
                l.cubicTo(278.4489f, 133.62132f, 278.0f, 133.17548f, 278.0f, 132.62552f);
                l.lineTo(278.0f, 119.61713f);
                l.cubicTo(278.0f, 119.070244f, 278.44724f, 118.62132f, 278.99896f, 118.62132f);
                l.lineTo(281.0f, 118.62132f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
