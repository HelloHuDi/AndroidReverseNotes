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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.sk */
public final class C32395sk extends C5163c {
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-8947849);
                canvas.saveLayerAlpha(null, C31128d.MIC_PTU_SHIGUANG, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(27.26f, 0.0f);
                l.lineTo(32.62f, 0.0f);
                l.cubicTo(46.7f, 1.17f, 58.74f, 13.2f, 60.0f, 27.26f);
                l.lineTo(60.0f, 32.63f);
                l.cubicTo(58.82f, 46.7f, 46.8f, 58.74f, 32.74f, 60.0f);
                l.lineTo(27.39f, 60.0f);
                l.cubicTo(13.31f, 58.84f, 1.26f, 46.81f, 0.0f, 32.75f);
                l.lineTo(0.0f, 27.37f);
                l.cubicTo(1.18f, 13.3f, 13.2f, 1.26f, 27.26f, 0.0f);
                l.lineTo(27.26f, 0.0f);
                l.close();
                l.moveTo(24.42f, 2.54f);
                l.cubicTo(10.35f, 5.18f, -0.2f, 19.83f, 2.27f, 34.03f);
                l.cubicTo(4.12f, 48.83f, 19.33f, 60.34f, 34.09f, 57.72f);
                l.cubicTo(48.99f, 55.83f, 60.51f, 40.38f, 57.66f, 25.54f);
                l.cubicTo(55.54f, 10.38f, 39.42f, -1.0f, 24.42f, 2.54f);
                l.lineTo(24.42f, 2.54f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(23.42f, 1.54f);
                l.cubicTo(38.42f, -2.0f, 54.54f, 9.38f, 56.66f, 24.54f);
                l.cubicTo(59.51f, 39.38f, 47.99f, 54.83f, 33.09f, 56.72f);
                l.cubicTo(18.33f, 59.34f, 3.12f, 47.83f, 1.27f, 33.03f);
                l.cubicTo(-1.2f, 18.83f, 9.35f, 4.18f, 23.42f, 1.54f);
                l.lineTo(23.42f, 1.54f);
                l.close();
                l.moveTo(15.79f, 19.84f);
                l.cubicTo(18.57f, 23.09f, 21.82f, 25.9f, 24.75f, 29.0f);
                l.cubicTo(21.83f, 32.09f, 18.61f, 34.89f, 15.83f, 38.11f);
                l.cubicTo(14.2f, 40.53f, 17.34f, 43.76f, 19.81f, 42.23f);
                l.cubicTo(23.07f, 39.45f, 25.89f, 36.19f, 29.0f, 33.25f);
                l.cubicTo(32.08f, 36.16f, 34.88f, 39.39f, 38.1f, 42.16f);
                l.cubicTo(40.53f, 43.85f, 43.82f, 40.58f, 42.18f, 38.13f);
                l.cubicTo(39.41f, 34.89f, 36.17f, 32.1f, 33.25f, 29.0f);
                l.cubicTo(36.17f, 25.91f, 39.4f, 23.11f, 42.17f, 19.89f);
                l.cubicTo(43.83f, 17.44f, 40.55f, 14.16f, 38.11f, 15.83f);
                l.cubicTo(34.89f, 18.6f, 32.09f, 21.83f, 29.0f, 24.75f);
                l.cubicTo(25.91f, 21.82f, 23.1f, 18.59f, 19.87f, 15.81f);
                l.cubicTo(17.43f, 14.21f, 14.22f, 17.39f, 15.79f, 19.84f);
                l.lineTo(15.79f, 19.84f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-8355712);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(0.79f, 4.84f);
                l.cubicTo(-0.78f, 2.39f, 2.43f, -0.79f, 4.87f, 0.81f);
                l.cubicTo(8.1f, 3.59f, 10.91f, 6.82f, 14.0f, 9.75f);
                l.cubicTo(17.09f, 6.83f, 19.89f, 3.6f, 23.11f, 0.83f);
                l.cubicTo(25.55f, -0.84f, 28.83f, 2.44f, 27.17f, 4.89f);
                l.cubicTo(24.4f, 8.11f, 21.17f, 10.91f, 18.25f, 14.0f);
                l.cubicTo(21.17f, 17.1f, 24.41f, 19.89f, 27.18f, 23.13f);
                l.cubicTo(28.82f, 25.58f, 25.53f, 28.85f, 23.1f, 27.16f);
                l.cubicTo(19.88f, 24.39f, 17.08f, 21.16f, 14.0f, 18.25f);
                l.cubicTo(10.89f, 21.19f, 8.07f, 24.45f, 4.81f, 27.23f);
                l.cubicTo(2.34f, 28.76f, -0.8f, 25.53f, 0.83f, 23.11f);
                l.cubicTo(3.61f, 19.89f, 6.83f, 17.09f, 9.75f, 14.0f);
                l.cubicTo(6.82f, 10.9f, 3.57f, 8.09f, 0.79f, 4.84f);
                l.lineTo(0.79f, 4.84f);
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
