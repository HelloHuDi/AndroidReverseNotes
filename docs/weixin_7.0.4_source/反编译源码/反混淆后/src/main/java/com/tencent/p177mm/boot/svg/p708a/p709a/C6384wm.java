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

/* renamed from: com.tencent.mm.boot.svg.a.a.wm */
public final class C6384wm extends C5163c {
    private final int height = 36;
    private final int width = 40;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 36;
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
                a.setColor(-11048043);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.95f, 1.02f);
                l.cubicTo(12.96f, 0.94f, 22.98f, 1.06f, 32.99f, 0.97f);
                l.cubicTo(34.31f, 1.13f, 36.14f, 0.52f, 36.9f, 2.0f);
                l.cubicTo(37.18f, 8.98f, 36.88f, 15.98f, 37.03f, 22.97f);
                l.cubicTo(36.86f, 24.28f, 37.48f, 26.12f, 36.02f, 26.9f);
                l.cubicTo(28.94f, 27.17f, 21.85f, 26.9f, 14.76f, 27.0f);
                l.cubicTo(12.19f, 28.76f, 9.6f, 30.48f, 7.0f, 32.2f);
                l.cubicTo(7.0f, 30.47f, 6.99f, 28.75f, 7.0f, 27.02f);
                l.cubicTo(5.09f, 26.72f, 2.45f, 27.83f, 1.1f, 26.03f);
                l.cubicTo(0.84f, 18.67f, 1.09f, 11.3f, 0.98f, 3.93f);
                l.cubicTo(0.79f, 2.67f, 1.23f, 0.69f, 2.95f, 1.02f);
                l.close();
                l.moveTo(5.0f, 5.0f);
                l.lineTo(5.0f, 23.0f);
                l.lineTo(9.99f, 23.0f);
                l.cubicTo(9.99f, 23.67f, 10.0f, 25.03f, 10.0f, 25.7f);
                l.cubicTo(10.93f, 24.8f, 11.84f, 23.9f, 12.75f, 22.99f);
                l.cubicTo(19.5f, 23.01f, 26.25f, 23.0f, 33.0f, 23.0f);
                l.lineTo(33.0f, 5.0f);
                l.lineTo(5.0f, 5.0f);
                l.lineTo(5.0f, 5.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
