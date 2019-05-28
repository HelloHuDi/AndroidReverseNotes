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
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.xw */
public final class C32410xw extends C5163c {
    private final int height = 111;
    private final int width = 111;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 111;
            case 1:
                return 111;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                k = C5163c.m7876a(k, looper);
                k.setColor(-16074);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(55.5f, 0.0f);
                l.cubicTo(86.15181f, 0.0f, 111.0f, 24.848194f, 111.0f, 55.5f);
                l.cubicTo(111.0f, 86.15181f, 86.15181f, 111.0f, 55.5f, 111.0f);
                l.cubicTo(24.848194f, 111.0f, 0.0f, 86.15181f, 0.0f, 55.5f);
                l.cubicTo(0.0f, 24.848194f, 24.848194f, 0.0f, 55.5f, 0.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.0f);
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                float[] a5 = C5163c.m7878a(a3, 0.89879405f, -0.43837115f, 23.489042f, 0.43837115f, 0.89879405f, -15.173922f);
                h.reset();
                h.setValues(a5);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(22.994629f, 17.339851f);
                l.cubicTo(22.39213f, 17.121492f, 21.726933f, 17.43036f, 21.509315f, 18.025713f);
                l.lineTo(10.605188f, 47.85707f);
                l.cubicTo(10.388678f, 48.4494f, 10.695863f, 49.10536f, 11.295349f, 49.322624f);
                l.lineTo(66.219894f, 69.228455f);
                l.cubicTo(66.822395f, 69.446815f, 67.487595f, 69.13795f, 67.70521f, 68.542595f);
                l.lineTo(78.60934f, 38.711235f);
                l.cubicTo(78.82584f, 38.118908f, 78.51866f, 37.46295f, 77.919174f, 37.245686f);
                l.lineTo(22.994629f, 17.339851f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                a4.setStrokeCap(Cap.ROUND);
                a4.setStrokeJoin(Join.MITER);
                a3 = C5163c.m7878a(a5, 1.0f, 0.0f, 13.269231f, 0.0f, 1.0f, 10.468085f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                a4 = C5163c.m7876a(a4, looper);
                a3 = C5163c.m7878a(a3, 0.9975641f, 0.06975647f, -1.867919f, -0.06975647f, 0.9975641f, 2.5683162f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(39.538136f, 6.3106236f);
                l.cubicTo(43.65822f, 4.154688f, 48.062016f, 2.915408f, 52.74952f, 2.5927842f);
                l.cubicTo(59.98247f, 2.5454812f, 65.71933f, 4.7730365f, 68.3616f, 9.330113f);
                l.cubicTo(73.88385f, 18.854218f, 63.797997f, 34.946922f, 45.83423f, 45.274174f);
                l.cubicTo(27.870462f, 55.60143f, 8.831288f, 56.25251f, 3.3090456f, 46.728405f);
                l.cubicTo(2.6508272f, 45.59319f, 2.2143564f, 44.36465f, 1.9865427f, 43.06368f);
                l.cubicTo(1.6337932f, 40.273342f, 1.7985677f, 37.926987f, 2.4808657f, 36.02461f);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
