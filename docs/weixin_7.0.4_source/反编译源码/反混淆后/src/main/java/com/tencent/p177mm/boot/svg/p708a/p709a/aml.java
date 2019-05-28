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

/* renamed from: com.tencent.mm.boot.svg.a.a.aml */
public final class aml extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(49.0f, 1.0f);
                l.cubicTo(50.03636f, 0.7465073f, 51.038017f, 0.3981372f, 52.0f, 3.5527137E-15f);
                l.cubicTo(53.99339f, 0.82613474f, 55.77851f, 2.0006394f, 58.0f, 3.0f);
                l.cubicTo(57.7124f, 4.230208f, 57.81157f, 5.394759f, 58.0f, 7.0f);
                l.cubicTo(56.819836f, 8.440509f, 56.145454f, 10.958727f, 54.0f, 12.0f);
                l.cubicTo(52.33719f, 12.790158f, 51.761982f, 14.65145f, 51.0f, 16.0f);
                l.cubicTo(51.2562f, 20.22537f, 52.545456f, 24.34609f, 52.0f, 29.0f);
                l.cubicTo(51.01818f, 31.761396f, 48.935535f, 34.598125f, 47.0f, 38.0f);
                l.cubicTo(42.261158f, 39.564888f, 36.717354f, 40.769253f, 31.0f, 39.0f);
                l.cubicTo(27.960331f, 38.66908f, 25.014875f, 36.648533f, 22.0f, 35.0f);
                l.cubicTo(25.49091f, 29.19341f, 28.565289f, 23.161633f, 32.0f, 18.0f);
                l.cubicTo(35.646282f, 14.820658f, 40.19835f, 14.104012f, 44.0f, 12.0f);
                l.cubicTo(44.83967f, 10.978634f, 45.603306f, 9.664781f, 46.0f, 8.0f);
                l.cubicTo(45.047935f, 5.603781f, 47.99339f, 3.3642595f, 49.0f, 1.0f);
                l.lineTo(49.0f, 1.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 43.0f);
                l.cubicTo(3.5738575f, 39.33729f, 8.595227f, 36.552418f, 14.0f, 37.0f);
                l.cubicTo(21.173609f, 36.99999f, 26.105131f, 43.375362f, 33.0f, 44.0f);
                l.cubicTo(39.242554f, 44.976665f, 45.06255f, 42.430492f, 51.0f, 41.0f);
                l.cubicTo(55.235065f, 38.959347f, 59.85712f, 40.670055f, 64.0f, 42.0f);
                l.cubicTo(60.615818f, 42.24152f, 57.091873f, 41.953087f, 54.0f, 43.0f);
                l.cubicTo(48.96584f, 45.076122f, 44.802994f, 48.408028f, 40.0f, 50.0f);
                l.cubicTo(37.5255f, 53.669453f, 35.86835f, 57.647846f, 33.0f, 61.0f);
                l.cubicTo(31.595695f, 61.29802f, 30.228046f, 60.243744f, 29.0f, 60.0f);
                l.cubicTo(24.26829f, 57.279842f, 19.586336f, 55.06189f, 15.0f, 53.0f);
                l.cubicTo(13.686477f, 52.03831f, 12.867884f, 50.347492f, 14.0f, 49.0f);
                l.cubicTo(14.684761f, 46.617752f, 16.232101f, 44.459473f, 17.0f, 42.0f);
                l.cubicTo(11.769771f, 39.188103f, 5.240992f, 40.11308f, 0.0f, 43.0f);
                l.lineTo(0.0f, 43.0f);
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
