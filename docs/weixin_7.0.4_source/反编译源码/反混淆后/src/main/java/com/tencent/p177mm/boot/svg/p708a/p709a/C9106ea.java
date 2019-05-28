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

/* renamed from: com.tencent.mm.boot.svg.a.a.ea */
public final class C9106ea extends C5163c {
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -1463.0f, 0.0f, 1.0f, -215.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1463.0f, 0.0f, 1.0f, 215.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(8.0f);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(72.0f, 52.0f);
                l.lineTo(77.1435f, 52.0f);
                l.cubicTo(80.375984f, 52.0f, 81.20154f, 50.09575f, 78.983025f, 47.746735f);
                l.lineTo(53.01697f, 20.253265f);
                l.cubicTo(50.80398f, 17.910099f, 47.201538f, 17.904251f, 44.98303f, 20.253265f);
                l.lineTo(19.016973f, 47.746735f);
                l.cubicTo(16.803982f, 50.0899f, 17.622042f, 52.0f, 20.856497f, 52.0f);
                l.lineTo(26.0f, 52.0f);
                l.lineTo(26.0f, 74.07317f);
                l.cubicTo(26.0f, 75.69759f, 27.31177f, 77.0f, 28.92992f, 77.0f);
                l.lineTo(69.070076f, 77.0f);
                l.cubicTo(70.69741f, 77.0f, 72.0f, 75.68961f, 72.0f, 74.07317f);
                l.lineTo(72.0f, 52.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(54.0f, 63.0f);
                l2.lineTo(54.0f, 74.0f);
                l2.lineTo(45.0f, 74.0f);
                l2.lineTo(45.0f, 63.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
