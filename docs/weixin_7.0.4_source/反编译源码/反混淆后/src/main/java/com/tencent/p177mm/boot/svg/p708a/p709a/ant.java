package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ant */
public final class ant extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                a.setColor(-13421773);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.002084f, 68.210526f);
                l.cubicTo(1.3440788f, 68.210526f, 2.1281295E-14f, 66.87234f, 1.4251356E-14f, 65.205696f);
                l.lineTo(0.0f, 61.82702f);
                l.cubicTo(-1.17800506E-14f, 59.230892f, 1.8877298f, 56.205124f, 4.2218437f, 55.0661f);
                l.lineTo(25.671602f, 44.598858f);
                l.cubicTo(28.782482f, 43.080784f, 29.505823f, 39.718468f, 27.25937f, 37.055893f);
                l.lineTo(25.889353f, 35.432102f);
                l.cubicTo(23.101835f, 32.12824f, 20.842106f, 25.955986f, 20.842106f, 21.635206f);
                l.lineTo(20.842106f, 15.156304f);
                l.cubicTo(20.842106f, 6.785709f, 27.64556f, 0.0f, 36.0f, 0.0f);
                l.cubicTo(44.371475f, 0.0f, 51.157894f, 6.794451f, 51.157894f, 15.158681f);
                l.lineTo(51.157894f, 21.638597f);
                l.cubicTo(51.157894f, 25.955227f, 48.887745f, 32.145576f, 46.110645f, 35.43754f);
                l.lineTo(44.740627f, 37.061554f);
                l.cubicTo(42.50665f, 39.70971f, 43.204502f, 43.080242f, 46.328396f, 44.60404f);
                l.lineTo(67.77816f, 55.066956f);
                l.cubicTo(70.10982f, 56.204308f, 72.0f, 59.21117f, 72.0f, 61.82702f);
                l.lineTo(72.0f, 65.205696f);
                l.cubicTo(72.0f, 66.86522f, 70.65759f, 68.210526f, 68.99792f, 68.210526f);
                l.lineTo(3.002084f, 68.210526f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
