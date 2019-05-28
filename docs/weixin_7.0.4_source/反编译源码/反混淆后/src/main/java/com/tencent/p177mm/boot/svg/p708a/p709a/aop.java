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

/* renamed from: com.tencent.mm.boot.svg.a.a.aop */
public final class aop extends C5163c {
    private final int height = 34;
    private final int width = 28;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 34;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -39.0f, 0.0f, 1.0f, -37.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 33.0f, 0.0f, 1.0f, 34.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.57191f, 29.428091f);
                l.cubicTo(8.159051f, 27.015232f, 6.6666665f, 23.681898f, 6.6666665f, 20.0f);
                l.cubicTo(6.6666665f, 12.636204f, 12.636204f, 6.6666665f, 20.0f, 6.6666665f);
                l.lineTo(20.0f, 8.666667f);
                l.cubicTo(13.740773f, 8.666667f, 8.666667f, 13.740773f, 8.666667f, 20.0f);
                l.cubicTo(8.666667f, 23.048483f, 9.87313f, 25.900885f, 11.986123f, 28.013876f);
                l.moveTo(20.0f, 31.333334f);
                l.cubicTo(26.259228f, 31.333334f, 31.333334f, 26.259228f, 31.333334f, 20.0f);
                l.cubicTo(31.333334f, 16.951517f, 30.12687f, 14.099116f, 28.013876f, 11.986123f);
                l.lineTo(29.428091f, 10.57191f);
                l.cubicTo(31.84095f, 12.984768f, 33.333332f, 16.318102f, 33.333332f, 20.0f);
                l.cubicTo(33.333332f, 27.363796f, 27.363796f, 33.333332f, 20.0f, 33.333332f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a2 = C5163c.m7878a(a2, -0.70710677f, -0.70710677f, 36.499157f, -0.70710677f, 0.70710677f, 15.118446f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(16.714045f, 6.7140455f);
                l.lineTo(16.714045f, 11.380712f);
                l.lineTo(14.714046f, 11.380712f);
                l.lineTo(14.714046f, 6.7140455f);
                l.lineTo(14.714046f, 5.214045f);
                l.cubicTo(14.714046f, 4.937903f, 14.937902f, 4.714045f, 15.214046f, 4.714045f);
                l.lineTo(21.380713f, 4.714045f);
                l.lineTo(21.380713f, 6.7140455f);
                l.lineTo(16.714045f, 6.7140455f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(a2, 0.70710677f, 0.70710677f, -16.161968f, -0.70710677f, 0.70710677f, 24.876308f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(20.614046f, 30.614046f);
                l.lineTo(20.614046f, 35.280712f);
                l.lineTo(18.614046f, 35.280712f);
                l.lineTo(18.614046f, 30.614046f);
                l.lineTo(18.614046f, 29.114046f);
                l.cubicTo(18.614046f, 28.837904f, 18.837904f, 28.614046f, 19.114046f, 28.614046f);
                l.lineTo(25.280712f, 28.614046f);
                l.lineTo(25.280712f, 30.614046f);
                l.lineTo(20.614046f, 30.614046f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
