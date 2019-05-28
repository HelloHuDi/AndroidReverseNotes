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

/* renamed from: com.tencent.mm.boot.svg.a.a.apa */
public final class apa extends C5163c {
    private final int height = 76;
    private final int width = 76;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 4.0f);
                l.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                l.lineTo(72.0f, 0.0f);
                l.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                l.lineTo(76.0f, 72.0f);
                l.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                l.lineTo(4.0f, 76.0f);
                l.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                l.lineTo(0.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-5658199);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 16.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(3.48f, 15.58f);
                l.cubicTo(0.27f, 9.35f, 5.54f, 1.93f, 12.02f, 1.02f);
                l.cubicTo(19.31f, 0.03f, 26.72f, 0.53f, 34.05f, 0.82f);
                l.cubicTo(31.62f, 2.59f, 28.84f, 3.78f, 26.06f, 4.88f);
                l.cubicTo(27.11f, 7.45f, 28.81f, 10.09f, 28.19f, 12.99f);
                l.cubicTo(27.4f, 16.84f, 23.67f, 19.21f, 22.68f, 22.96f);
                l.cubicTo(24.4f, 28.11f, 31.25f, 30.9f, 30.73f, 37.03f);
                l.cubicTo(30.28f, 45.11f, 21.25f, 49.65f, 13.94f, 49.09f);
                l.cubicTo(7.06f, 49.13f, -1.04f, 43.72f, 0.23f, 36.06f);
                l.cubicTo(1.82f, 28.82f, 9.89f, 26.16f, 16.44f, 25.72f);
                l.cubicTo(16.46f, 24.71f, 16.49f, 23.69f, 16.52f, 22.68f);
                l.cubicTo(11.51f, 22.11f, 5.72f, 20.65f, 3.48f, 15.58f);
                l.lineTo(3.48f, 15.58f);
                l.close();
                l.moveTo(13.2f, 4.24f);
                l.cubicTo(8.59f, 5.84f, 8.82f, 12.22f, 11.58f, 15.43f);
                l.cubicTo(13.94f, 18.89f, 19.98f, 20.67f, 22.69f, 16.69f);
                l.cubicTo(26.26f, 10.87f, 19.77f, 2.34f, 13.2f, 4.24f);
                l.lineTo(13.2f, 4.24f);
                l.close();
                l.moveTo(13.31f, 30.24f);
                l.cubicTo(10.57f, 31.12f, 7.7f, 32.69f, 6.5f, 35.46f);
                l.cubicTo(5.37f, 38.41f, 7.39f, 41.77f, 10.27f, 42.73f);
                l.cubicTo(14.73f, 44.28f, 19.99f, 43.53f, 23.85f, 40.82f);
                l.cubicTo(25.12f, 39.87f, 26.66f, 38.07f, 25.41f, 36.51f);
                l.cubicTo(22.73f, 32.79f, 18.37f, 28.18f, 13.31f, 30.24f);
                l.lineTo(13.31f, 30.24f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(40.61f, 12.53f);
                l.lineTo(45.05f, 12.53f);
                l.cubicTo(45.05f, 15.02f, 45.05f, 17.5f, 45.06f, 19.99f);
                l.cubicTo(47.58f, 20.0f, 50.09f, 20.01f, 52.61f, 20.02f);
                l.cubicTo(52.6f, 21.52f, 52.59f, 23.02f, 52.58f, 24.52f);
                l.cubicTo(50.08f, 24.52f, 47.57f, 24.53f, 45.06f, 24.54f);
                l.cubicTo(45.05f, 27.02f, 45.05f, 29.51f, 45.05f, 31.99f);
                l.cubicTo(43.57f, 32.0f, 42.08f, 32.0f, 40.6f, 32.0f);
                l.cubicTo(40.6f, 29.51f, 40.59f, 27.03f, 40.58f, 24.54f);
                l.cubicTo(38.07f, 24.53f, 35.56f, 24.52f, 33.05f, 24.52f);
                l.lineTo(33.05f, 20.01f);
                l.cubicTo(35.56f, 20.0f, 38.08f, 19.99f, 40.59f, 19.99f);
                l.cubicTo(40.6f, 17.5f, 40.6f, 15.02f, 40.61f, 12.53f);
                l.lineTo(40.61f, 12.53f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
