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

/* renamed from: com.tencent.mm.boot.svg.a.a.auy */
public final class auy extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-3487030);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.04f, 5.81f);
                l.cubicTo(0.91f, 1.08f, 7.16f, -1.81f, 10.71f, 1.3f);
                l.cubicTo(14.01f, 3.84f, 12.8f, 8.42f, 13.0f, 12.0f);
                l.cubicTo(18.34f, 12.05f, 23.69f, 11.9f, 29.04f, 12.06f);
                l.cubicTo(32.6f, 11.89f, 35.62f, 15.51f, 34.91f, 18.99f);
                l.cubicTo(34.51f, 21.75f, 31.93f, 24.02f, 29.12f, 23.95f);
                l.cubicTo(23.75f, 24.1f, 18.38f, 23.95f, 13.01f, 24.0f);
                l.cubicTo(13.22f, 27.54f, 11.9f, 32.22f, 15.35f, 34.62f);
                l.cubicTo(19.65f, 37.31f, 25.03f, 34.96f, 29.6f, 36.6f);
                l.cubicTo(33.23f, 38.19f, 34.16f, 43.54f, 31.23f, 46.24f);
                l.cubicTo(28.55f, 48.93f, 24.42f, 47.74f, 21.03f, 48.02f);
                l.cubicTo(15.1f, 48.47f, 8.72f, 46.94f, 4.53f, 42.5f);
                l.cubicTo(1.84f, 39.75f, 0.9f, 35.8f, 1.0f, 32.05f);
                l.cubicTo(1.03f, 23.3f, 0.94f, 14.55f, 1.04f, 5.81f);
                l.lineTo(1.04f, 5.81f);
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
