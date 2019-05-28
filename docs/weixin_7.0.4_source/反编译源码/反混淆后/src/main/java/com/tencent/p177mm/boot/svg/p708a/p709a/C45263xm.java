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

/* renamed from: com.tencent.mm.boot.svg.a.a.xm */
public final class C45263xm extends C5163c {
    private final int height = 80;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 80;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(28.0f, 38.0f);
                l.cubicTo(33.522846f, 38.0f, 38.0f, 33.522846f, 38.0f, 28.0f);
                l.cubicTo(38.0f, 22.477152f, 33.522846f, 18.0f, 28.0f, 18.0f);
                l.cubicTo(22.477152f, 18.0f, 18.0f, 22.477152f, 18.0f, 28.0f);
                l.cubicTo(18.0f, 33.522846f, 22.477152f, 38.0f, 28.0f, 38.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(26.0f, 0.0f);
                l2.lineTo(30.0f, 0.0f);
                l2.lineTo(30.0f, 9.0f);
                l2.lineTo(26.0f, 9.0f);
                l2.lineTo(26.0f, 0.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(26.0f, 47.0f);
                l2.lineTo(30.0f, 47.0f);
                l2.lineTo(30.0f, 56.0f);
                l2.lineTo(26.0f, 56.0f);
                l2.lineTo(26.0f, 47.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(47.0f, 25.0f);
                l2.lineTo(56.0f, 25.0f);
                l2.lineTo(56.0f, 29.0f);
                l2.lineTo(47.0f, 29.0f);
                l2.lineTo(47.0f, 25.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(-1.9984014E-16f, 25.0f);
                l2.lineTo(9.0f, 25.0f);
                l2.lineTo(9.0f, 29.0f);
                l2.lineTo(-1.9984014E-16f, 29.0f);
                l2.lineTo(-1.9984014E-16f, 25.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
