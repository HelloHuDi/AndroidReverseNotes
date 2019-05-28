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

/* renamed from: com.tencent.mm.boot.svg.a.a.jf */
public final class C32373jf extends C5163c {
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
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, -102.0f, 0.0f, 1.0f, -1105.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                canvas.restore();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-8683388);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(27.860264f, 42.224224f);
                l.lineTo(16.244278f, 48.80972f);
                l.lineTo(11.775919f, 32.292778f);
                l.cubicTo(11.293263f, 30.495869f, 11.832553f, 28.662212f, 13.041141f, 27.405102f);
                l.lineTo(27.860264f, 42.224224f);
                l.close();
                l.moveTo(22.487175f, 24.123215f);
                l.lineTo(32.12214f, 21.56749f);
                l.lineTo(32.157063f, 33.793102f);
                l.lineTo(22.487175f, 24.123215f);
                l.close();
                l.moveTo(58.56243f, 72.92639f);
                l.lineTo(62.774803f, 77.13876f);
                l.lineTo(51.687485f, 88.06427f);
                l.cubicTo(49.64852f, 90.08063f, 46.351482f, 90.08063f, 44.31252f, 88.06427f);
                l.lineTo(32.12214f, 76.00905f);
                l.lineTo(45.397076f, 68.37264f);
                l.cubicTo(47.002213f, 67.42882f, 48.99779f, 67.42882f, 50.646313f, 68.37264f);
                l.lineTo(58.56243f, 72.92639f);
                l.close();
                l.moveTo(72.13884f, 73.77488f);
                l.lineTo(63.84792f, 65.48396f);
                l.lineTo(63.83448f, 60.77914f);
                l.cubicTo(63.83448f, 58.97729f, 64.83227f, 57.261246f, 66.43741f, 56.31742f);
                l.lineTo(79.75572f, 48.76682f);
                l.lineTo(84.22408f, 65.24086f);
                l.cubicTo(84.96158f, 67.986534f, 83.31306f, 70.81801f, 80.536606f, 71.54733f);
                l.lineTo(72.13884f, 73.77488f);
                l.close();
                l.moveTo(32.165524f, 60.82204f);
                l.lineTo(32.12214f, 76.00905f);
                l.lineTo(15.4634f, 71.59023f);
                l.cubicTo(12.686943f, 70.86091f, 11.038423f, 68.029434f, 11.775919f, 65.28376f);
                l.lineTo(16.244278f, 48.80972f);
                l.lineTo(29.562593f, 56.36032f);
                l.cubicTo(31.167734f, 57.261246f, 32.165524f, 58.97729f, 32.165524f, 60.82204f);
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
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-8683388);
                g = C5163c.m7878a(a, 0.70710677f, -0.70710677f, 48.001785f, 0.70710677f, 0.70710677f, -19.882988f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(2.0017858f, 45.401787f);
                l.cubicTo(2.0017858f, 44.90473f, 2.4047296f, 44.501785f, 2.9017859f, 44.501785f);
                l.lineTo(93.10178f, 44.501785f);
                l.cubicTo(93.59884f, 44.501785f, 94.001785f, 44.90473f, 94.001785f, 45.401787f);
                l.lineTo(94.001785f, 50.601784f);
                l.cubicTo(94.001785f, 51.09884f, 93.59884f, 51.501785f, 93.10178f, 51.501785f);
                l.lineTo(2.9017859f, 51.501785f);
                l.cubicTo(2.4047296f, 51.501785f, 2.0017858f, 51.09884f, 2.0017858f, 50.601784f);
                l.lineTo(2.0017858f, 45.401787f);
                l.close();
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
