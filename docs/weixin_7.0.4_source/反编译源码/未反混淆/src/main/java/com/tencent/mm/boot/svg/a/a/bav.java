package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bav extends c {
    private final int height = 102;
    private final int width = 102;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-1250068);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(102.0f, 0.0f);
                l.lineTo(102.0f, 102.0f);
                l.lineTo(0.0f, 102.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(k2, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-352965);
                Path l2 = c.l(looper);
                l2.moveTo(63.63156f, 32.550247f);
                l2.cubicTo(75.09288f, 38.508724f, 83.25293f, 51.791027f, 83.25293f, 63.84621f);
                l2.cubicTo(83.25293f, 79.99414f, 68.611664f, 87.82541f, 51.00678f, 87.82541f);
                l2.cubicTo(33.401894f, 87.82541f, 19.5f, 79.99414f, 19.5f, 63.84621f);
                l2.cubicTo(19.5f, 51.74594f, 27.306032f, 38.40936f, 38.626804f, 32.483704f);
                l2.cubicTo(36.242176f, 30.331757f, 31.298382f, 24.12442f, 32.533047f, 19.040112f);
                l2.cubicTo(32.985134f, 17.178434f, 35.765137f, 15.0f, 41.421295f, 15.0f);
                l2.cubicTo(47.07745f, 15.0f, 53.052776f, 19.531132f, 58.69562f, 19.531132f);
                l2.cubicTo(63.543755f, 19.531132f, 67.75456f, 16.320612f, 70.28289f, 19.040112f);
                l2.cubicTo(72.71456f, 21.655647f, 66.70847f, 29.404749f, 63.63156f, 32.550247f);
                l2.close();
                l2.moveTo(43.35897f, 30.520924f);
                l2.cubicTo(45.80165f, 29.762579f, 48.362442f, 29.348583f, 51.00678f, 29.348583f);
                l2.cubicTo(53.602345f, 29.348583f, 56.13349f, 29.747448f, 58.562794f, 30.479317f);
                l2.cubicTo(59.680264f, 28.81376f, 61.609486f, 25.761576f, 62.010014f, 25.23725f);
                l2.cubicTo(60.884056f, 25.436415f, 59.851704f, 25.531132f, 58.69562f, 25.531132f);
                l2.cubicTo(55.32233f, 25.531132f, 52.970524f, 24.838364f, 47.88444f, 22.855907f);
                l2.cubicTo(47.79554f, 22.821255f, 47.79554f, 22.821255f, 47.707146f, 22.786812f);
                l2.cubicTo(44.254536f, 21.441628f, 42.73305f, 21.0f, 41.421295f, 21.0f);
                l2.cubicTo(40.116314f, 21.0f, 39.107048f, 21.153767f, 38.407772f, 21.383652f);
                l2.cubicTo(38.582615f, 22.199299f, 39.062702f, 23.344135f, 39.880257f, 24.636806f);
                l2.cubicTo(40.307247f, 25.311932f, 42.24616f, 28.74818f, 43.35897f, 30.520924f);
                l2.close();
                l2.moveTo(51.00678f, 81.82541f);
                l2.cubicTo(67.22918f, 81.82541f, 77.25293f, 75.02486f, 77.25293f, 63.84621f);
                l2.cubicTo(77.25293f, 49.93904f, 64.30792f, 35.348583f, 51.00678f, 35.348583f);
                l2.cubicTo(37.86723f, 35.348583f, 25.5f, 49.74176f, 25.5f, 63.84621f);
                l2.cubicTo(25.5f, 75.17643f, 34.99126f, 81.82541f, 51.00678f, 81.82541f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
