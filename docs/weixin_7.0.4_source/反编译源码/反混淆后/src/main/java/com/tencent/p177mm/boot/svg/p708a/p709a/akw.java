package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.akw */
public final class akw extends C5163c {
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
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-16896);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(5.2080674f, 81.84925f);
                l.cubicTo(3.9541583f, 83.99987f, 4.9507284f, 85.7433f, 7.4474754f, 85.7433f);
                l.lineTo(88.74638f, 85.7433f);
                l.cubicTo(91.23708f, 85.7433f, 92.23893f, 83.99854f, 90.985794f, 81.84925f);
                l.lineTo(50.367332f, 12.183118f);
                l.cubicTo(49.113426f, 10.032495f, 47.07966f, 10.033827f, 45.826527f, 12.183118f);
                l.lineTo(5.2080674f, 81.84925f);
                l.close();
                l.moveTo(45.896564f, 36.946117f);
                l.cubicTo(45.070587f, 36.946117f, 44.432064f, 37.61737f, 44.470753f, 38.453403f);
                l.lineTo(45.63274f, 63.56276f);
                l.lineTo(50.5597f, 63.56276f);
                l.lineTo(51.721687f, 38.453403f);
                l.cubicTo(51.760212f, 37.620953f, 51.122555f, 36.946117f, 50.295876f, 36.946117f);
                l.lineTo(45.896564f, 36.946117f);
                l.close();
                l.moveTo(48.096222f, 75.39238f);
                l.cubicTo(50.137035f, 75.39238f, 51.791443f, 73.73729f, 51.791443f, 71.695625f);
                l.cubicTo(51.791443f, 69.65396f, 50.137035f, 67.99887f, 48.096222f, 67.99887f);
                l.cubicTo(46.055405f, 67.99887f, 44.401f, 69.65396f, 44.401f, 71.695625f);
                l.cubicTo(44.401f, 73.73729f, 46.055405f, 75.39238f, 48.096222f, 75.39238f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
