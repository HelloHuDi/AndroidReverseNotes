package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class js extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-8683388);
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1105.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1105.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(29.562593f, 41.259117f);
                l.lineTo(16.244278f, 48.80972f);
                l.lineTo(11.775919f, 32.292778f);
                l.cubicTo(11.038423f, 29.547104f, 12.686943f, 26.715628f, 15.4634f, 25.986307f);
                l.lineTo(32.12214f, 21.56749f);
                l.lineTo(32.165524f, 36.754498f);
                l.cubicTo(32.165524f, 38.599247f, 31.167734f, 40.315292f, 29.562593f, 41.259117f);
                l.close();
                l.moveTo(32.165524f, 60.82204f);
                l.lineTo(32.12214f, 76.00905f);
                l.lineTo(15.4634f, 71.59023f);
                l.cubicTo(12.686943f, 70.86091f, 11.038423f, 68.029434f, 11.775919f, 65.28376f);
                l.lineTo(16.244278f, 48.80972f);
                l.lineTo(29.562593f, 56.36032f);
                l.cubicTo(31.167734f, 57.261246f, 32.165524f, 58.97729f, 32.165524f, 60.82204f);
                l.close();
                l.moveTo(50.646313f, 68.37264f);
                l.lineTo(63.921246f, 76.00905f);
                l.lineTo(51.687485f, 88.06427f);
                l.cubicTo(49.64852f, 90.08063f, 46.351482f, 90.08063f, 44.31252f, 88.06427f);
                l.lineTo(32.12214f, 76.00905f);
                l.lineTo(45.397076f, 68.37264f);
                l.cubicTo(47.002213f, 67.42882f, 48.99779f, 67.42882f, 50.646313f, 68.37264f);
                l.close();
                l.moveTo(66.43741f, 56.31742f);
                l.lineTo(79.75572f, 48.76682f);
                l.lineTo(84.22408f, 65.24086f);
                l.cubicTo(84.96158f, 67.986534f, 83.31306f, 70.81801f, 80.536606f, 71.54733f);
                l.lineTo(63.877865f, 75.96615f);
                l.lineTo(63.83448f, 60.77914f);
                l.cubicTo(63.83448f, 58.97729f, 64.83227f, 57.261246f, 66.43741f, 56.31742f);
                l.close();
                l.moveTo(63.83448f, 36.754498f);
                l.lineTo(63.877865f, 21.56749f);
                l.lineTo(80.536606f, 25.986307f);
                l.cubicTo(83.31306f, 26.715628f, 84.96158f, 29.547104f, 84.22408f, 32.292778f);
                l.lineTo(79.75572f, 48.76682f);
                l.lineTo(66.43741f, 41.216217f);
                l.cubicTo(64.83227f, 40.315292f, 63.83448f, 38.599247f, 63.83448f, 36.754498f);
                l.close();
                l.moveTo(45.397076f, 29.203894f);
                l.lineTo(32.12214f, 21.56749f);
                l.lineTo(44.31252f, 9.512265f);
                l.cubicTo(46.351482f, 7.4959116f, 49.64852f, 7.4959116f, 51.687485f, 9.512265f);
                l.lineTo(63.877865f, 21.56749f);
                l.lineTo(50.60293f, 29.203894f);
                l.cubicTo(48.99779f, 30.147718f, 47.002213f, 30.147718f, 45.397076f, 29.203894f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
