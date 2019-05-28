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

/* renamed from: com.tencent.mm.boot.svg.a.a.vf */
public final class C32402vf extends C5163c {
    private final int height = 108;
    private final int width = 108;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                a.setColor(-499359);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.832836f, 23.632835f);
                l.lineTo(41.955223f, 12.99403f);
                l.cubicTo(42.54627f, 11.713433f, 42.54627f, 10.432836f, 42.05373f, 9.250747f);
                l.cubicTo(41.561195f, 8.068657f, 40.57612f, 7.1820893f, 39.197014f, 6.6895523f);
                l.lineTo(38.113434f, 6.295522f);
                l.cubicTo(37.620895f, 6.0985074f, 37.128357f, 6.0f, 36.635822f, 6.0f);
                l.cubicTo(34.46866f, 6.0f, 32.695522f, 7.477612f, 32.202984f, 9.644776f);
                l.lineTo(29.937313f, 21.170149f);
                l.cubicTo(29.34627f, 23.928358f, 30.232836f, 26.489552f, 31.808956f, 27.080597f);
                l.cubicTo(32.00597f, 27.179104f, 32.202984f, 27.179104f, 32.49851f, 27.179104f);
                l.cubicTo(33.97612f, 27.277613f, 35.749252f, 25.8f, 36.832836f, 23.632835f);
                l.close();
                l.moveTo(24.716417f, 31.119404f);
                l.cubicTo(24.913433f, 29.444777f, 22.844776f, 27.671642f, 20.086567f, 27.080597f);
                l.lineTo(11.614925f, 25.01194f);
                l.cubicTo(11.220896f, 24.913433f, 10.826866f, 24.913433f, 10.432836f, 24.913433f);
                l.cubicTo(8.167164f, 24.913433f, 6.295522f, 26.58806f, 6.0985074f, 28.853731f);
                l.lineTo(6.0f, 30.03582f);
                l.cubicTo(6.0f, 31.414925f, 6.4925375f, 32.695522f, 7.3791046f, 33.58209f);
                l.cubicTo(8.167164f, 34.370148f, 9.250747f, 34.76418f, 10.432836f, 34.76418f);
                l.cubicTo(10.531343f, 34.76418f, 10.62985f, 34.76418f, 10.728358f, 34.76418f);
                l.lineTo(19.397015f, 34.370148f);
                l.cubicTo(22.25373f, 34.074627f, 24.519403f, 32.695522f, 24.716417f, 31.119404f);
                l.close();
                l.moveTo(26.686567f, 39.689552f);
                l.cubicTo(25.01194f, 39.197014f, 22.74627f, 40.773136f, 21.662687f, 43.334328f);
                l.lineTo(13.38806f, 61.4597f);
                l.cubicTo(12.797015f, 62.7403f, 12.797015f, 64.0209f, 13.38806f, 65.20299f);
                l.cubicTo(13.979104f, 66.38507f, 14.964179f, 67.271645f, 16.343283f, 67.66567f);
                l.lineTo(17.426867f, 68.0597f);
                l.lineTo(17.525373f, 68.0597f);
                l.cubicTo(17.722387f, 68.0597f, 17.919403f, 68.0597f, 18.116419f, 68.0597f);
                l.cubicTo(20.480597f, 68.0597f, 23.140299f, 66.97612f, 23.731344f, 64.71045f);
                l.lineTo(28.558208f, 45.402985f);
                l.cubicTo(29.050747f, 42.743282f, 28.361195f, 40.18209f, 26.686567f, 39.689552f);
                l.close();
                l.moveTo(41.167164f, 41.856716f);
                l.cubicTo(39.886566f, 40.47761f, 38.21194f, 39.591045f, 36.832836f, 39.591045f);
                l.cubicTo(36.24179f, 39.591045f, 35.749252f, 39.78806f, 35.355225f, 40.083584f);
                l.cubicTo(34.074627f, 41.167164f, 34.27164f, 43.826866f, 35.94627f, 46.191044f);
                l.lineTo(51.608955f, 69.04478f);
                l.cubicTo(52.49552f, 70.42388f, 53.973133f, 71.113434f, 55.450745f, 71.113434f);
                l.cubicTo(56.53433f, 71.113434f, 57.617912f, 70.719406f, 58.50448f, 70.029854f);
                l.lineTo(59.391045f, 69.3403f);
                l.cubicTo(60.47463f, 68.45373f, 61.06567f, 67.271645f, 61.16418f, 65.89254f);
                l.cubicTo(61.262688f, 64.513435f, 60.77015f, 63.232838f, 59.883583f, 62.24776f);
                l.lineTo(41.167164f, 41.856716f);
                l.close();
                l.moveTo(71.90149f, 30.331343f);
                l.cubicTo(71.704475f, 27.474627f, 69.3403f, 25.40597f, 66.48358f, 25.8f);
                l.lineTo(43.23582f, 29.24776f);
                l.cubicTo(40.47761f, 29.64179f, 38.310448f, 31.316418f, 38.408955f, 33.089554f);
                l.cubicTo(38.50746f, 34.862686f, 40.773136f, 36.24179f, 43.629852f, 36.24179f);
                l.lineTo(66.58209f, 36.53731f);
                l.lineTo(66.680595f, 36.53731f);
                l.cubicTo(68.15821f, 36.53731f, 69.63582f, 35.847763f, 70.719406f, 34.76418f);
                l.cubicTo(71.60597f, 33.779106f, 72.0f, 32.597015f, 72.0f, 31.414925f);
                l.lineTo(71.90149f, 30.331343f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
