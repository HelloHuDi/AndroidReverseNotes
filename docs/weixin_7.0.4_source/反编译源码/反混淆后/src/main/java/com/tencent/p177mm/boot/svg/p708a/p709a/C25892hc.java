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

/* renamed from: com.tencent.mm.boot.svg.a.a.hc */
public final class C25892hc extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(-15432210);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                l.lineTo(120.0f, 108.0f);
                l.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                l.lineTo(12.0f, 120.0f);
                l.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(35.78873f, 51.0f);
                l.lineTo(24.0f, 51.0f);
                l.cubicTo(22.343145f, 51.0f, 21.0f, 49.656853f, 21.0f, 48.0f);
                l.cubicTo(21.0f, 46.343147f, 22.343145f, 45.0f, 24.0f, 45.0f);
                l.lineTo(52.90141f, 45.0f);
                l.cubicTo(54.59155f, 45.0f, 56.070423f, 43.94366f, 56.28169f, 42.25352f);
                l.lineTo(56.28169f, 41.619717f);
                l.lineTo(56.28169f, 36.338028f);
                l.cubicTo(56.28169f, 34.64789f, 56.915493f, 32.957745f, 58.183098f, 31.690142f);
                l.cubicTo(58.816902f, 30.84507f, 60.084507f, 30.0f, 61.140846f, 30.0f);
                l.cubicTo(62.619717f, 30.0f, 63.676056f, 31.267605f, 63.46479f, 32.74648f);
                l.cubicTo(63.46479f, 32.74648f, 63.25352f, 34.859154f, 63.25352f, 35.915493f);
                l.cubicTo(63.25352f, 38.239437f, 63.46479f, 40.774647f, 64.098595f, 43.09859f);
                l.cubicTo(64.30986f, 43.94366f, 64.521126f, 44.577465f, 64.73239f, 45.21127f);
                l.cubicTo(65.57746f, 47.957745f, 66.0f, 50.704224f, 66.0f, 53.661972f);
                l.lineTo(66.0f, 55.985916f);
                l.cubicTo(65.788734f, 57.887325f, 64.943665f, 59.78873f, 63.887325f, 61.267605f);
                l.cubicTo(61.985916f, 64.014084f, 58.816902f, 65.70422f, 55.225353f, 66.0f);
                l.lineTo(49.732395f, 66.0f);
                l.cubicTo(46.56338f, 65.91549f, 43.605633f, 64.43662f, 41.492958f, 62.323944f);
                l.cubicTo(41.070423f, 61.90141f, 40.64789f, 61.267605f, 40.225353f, 60.633804f);
                l.cubicTo(38.112675f, 58.09859f, 36.633804f, 54.929577f, 35.78873f, 51.0f);
                l.close();
                l.moveTo(36.21127f, 21.0f);
                l.lineTo(48.0f, 21.0f);
                l.cubicTo(49.656853f, 21.0f, 51.0f, 22.343145f, 51.0f, 24.0f);
                l.cubicTo(51.0f, 25.656855f, 49.656853f, 27.0f, 48.0f, 27.0f);
                l.lineTo(19.09859f, 27.0f);
                l.cubicTo(17.408451f, 27.0f, 15.929578f, 28.056337f, 15.71831f, 29.746479f);
                l.lineTo(15.71831f, 30.380281f);
                l.lineTo(15.71831f, 35.661972f);
                l.cubicTo(15.71831f, 37.35211f, 15.084507f, 39.042255f, 13.816901f, 40.30986f);
                l.cubicTo(13.183099f, 41.15493f, 11.915493f, 42.0f, 10.859155f, 42.0f);
                l.cubicTo(9.380281f, 42.0f, 8.323944f, 40.732395f, 8.535212f, 39.25352f);
                l.cubicTo(8.535212f, 39.25352f, 8.746479f, 37.140846f, 8.746479f, 36.084507f);
                l.cubicTo(8.746479f, 33.760563f, 8.535212f, 31.225351f, 7.9014087f, 28.90141f);
                l.cubicTo(7.6901407f, 28.056337f, 7.4788733f, 27.422535f, 7.267606f, 26.788733f);
                l.cubicTo(6.4225354f, 24.042253f, 6.0f, 21.295774f, 6.0f, 18.338028f);
                l.lineTo(6.0f, 16.014084f);
                l.cubicTo(6.2112675f, 14.112676f, 7.056338f, 12.211267f, 8.112676f, 10.732394f);
                l.cubicTo(10.014085f, 7.9859157f, 13.183099f, 6.2957745f, 16.774649f, 6.0f);
                l.lineTo(22.267605f, 6.0f);
                l.cubicTo(25.436619f, 6.084507f, 28.394365f, 7.5633802f, 30.507042f, 9.676056f);
                l.cubicTo(30.929577f, 10.098592f, 31.352112f, 10.732394f, 31.774649f, 11.366198f);
                l.cubicTo(33.887325f, 13.901408f, 35.366196f, 17.070423f, 36.21127f, 21.0f);
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
