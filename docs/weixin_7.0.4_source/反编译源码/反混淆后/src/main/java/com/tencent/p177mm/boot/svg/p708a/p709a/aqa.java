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

/* renamed from: com.tencent.mm.boot.svg.a.a.aqa */
public final class aqa extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.9f, 0.0f);
                l.lineTo(34.1f, 0.0f);
                l.cubicTo(33.86f, 7.5f, 29.44f, 14.06f, 24.1f, 19.0f);
                l.cubicTo(29.21f, 23.71f, 33.38f, 29.87f, 34.09f, 36.94f);
                l.cubicTo(23.03f, 37.05f, 11.96f, 37.01f, 0.9f, 36.97f);
                l.cubicTo(1.62f, 29.89f, 5.78f, 23.72f, 10.9f, 19.01f);
                l.cubicTo(5.57f, 14.06f, 1.14f, 7.5f, 0.9f, 0.0f);
                l.lineTo(0.9f, 0.0f);
                l.close();
                l.moveTo(8.27f, 6.01f);
                l.cubicTo(10.16f, 10.93f, 16.03f, 13.56f, 16.48f, 19.02f);
                l.cubicTo(16.19f, 24.12f, 10.8f, 26.53f, 8.87f, 30.95f);
                l.cubicTo(14.62f, 31.03f, 20.37f, 31.03f, 26.12f, 30.94f);
                l.cubicTo(24.2f, 26.52f, 18.8f, 24.11f, 18.52f, 19.01f);
                l.cubicTo(18.99f, 13.55f, 24.84f, 10.93f, 26.73f, 6.01f);
                l.cubicTo(20.58f, 6.0f, 14.42f, 6.0f, 8.27f, 6.01f);
                l.lineTo(8.27f, 6.01f);
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
