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

/* renamed from: com.tencent.mm.boot.svg.a.a.anj */
public final class anj extends C5163c {
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.0493919f, 4.9551387f);
                l.cubicTo(0.73974586f, 3.1585698f, 1.9383756f, 0.9428011f, 3.976046f, 1.1024961f);
                l.cubicTo(22.345047f, 0.9727439f, 40.724033f, 1.0725534f, 59.093037f, 1.0525914f);
                l.cubicTo(60.89098f, 0.72322047f, 63.00856f, 1.970838f, 62.908672f, 3.9570448f);
                l.cubicTo(63.04851f, 17.002132f, 62.948627f, 30.04722f, 62.958614f, 43.092308f);
                l.cubicTo(63.238297f, 44.82899f, 62.07962f, 46.994858f, 60.11187f, 46.895046f);
                l.cubicTo(53.07991f, 47.05474f, 46.03796f, 46.90503f, 38.99601f, 46.954933f);
                l.lineTo(38.99601f, 50.95729f);
                l.cubicTo(42.32221f, 50.927345f, 45.658394f, 50.8475f, 48.984592f, 51.17687f);
                l.cubicTo(48.984592f, 52.274773f, 48.914673f, 54.400715f, 47.17666f, 53.93161f);
                l.cubicTo(37.068214f, 53.951572f, 26.95977f, 53.951572f, 16.851326f, 53.93161f);
                l.cubicTo(15.083348f, 54.410694f, 14.993451f, 52.25481f, 15.093336f, 51.136948f);
                l.cubicTo(18.389568f, 50.87744f, 21.705776f, 50.917366f, 25.011997f, 50.95729f);
                l.lineTo(25.011997f, 46.954933f);
                l.cubicTo(17.980036f, 46.90503f, 10.948075f, 47.05474f, 3.926103f, 46.895046f);
                l.cubicTo(1.9084098f, 47.0248f, 0.73974586f, 44.80903f, 1.0493919f, 43.032425f);
                l.cubicTo(1.0294148f, 30.336668f, 1.0294148f, 17.650894f, 1.0493919f, 4.9551387f);
                l.lineTo(1.0493919f, 4.9551387f);
                l.close();
                l.moveTo(5.0f, 5.0f);
                l.lineTo(5.0f, 39.0f);
                l.lineTo(59.0f, 39.0f);
                l.lineTo(59.0f, 5.0f);
                l.lineTo(5.0f, 5.0f);
                l.lineTo(5.0f, 5.0f);
                l.close();
                l.moveTo(31.225903f, 41.13082f);
                l.cubicTo(28.789328f, 42.126995f, 30.338081f, 45.77963f, 32.794384f, 44.84987f);
                l.cubicTo(35.201366f, 43.844208f, 33.65261f, 40.276962f, 31.225903f, 41.13082f);
                l.lineTo(31.225903f, 41.13082f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-15658735);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 29.0f, 0.0f, 1.0f, 40.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 17, 4);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(2.2259018f, 1.130823f);
                l.cubicTo(4.6526113f, 0.2769606f, 6.2013645f, 3.8442078f, 3.7943847f, 4.849868f);
                l.cubicTo(1.3380812f, 5.779629f, -0.21067229f, 2.1269958f, 2.2259018f, 1.130823f);
                l.lineTo(2.2259018f, 1.130823f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
