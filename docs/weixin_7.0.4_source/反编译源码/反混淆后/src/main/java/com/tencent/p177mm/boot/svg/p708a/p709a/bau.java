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

/* renamed from: com.tencent.mm.boot.svg.a.a.bau */
public final class bau extends C5163c {
    private final int height = 102;
    private final int width = 102;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-789517);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(102.0f, 0.0f);
                l.lineTo(102.0f, 102.0f);
                l.lineTo(0.0f, 102.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, C5163c.m7876a(k2, looper));
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-12354608);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(50.655247f, 48.301735f);
                l2.lineTo(26.15658f, 30.9727f);
                l2.cubicTo(26.750633f, 30.543125f, 35.86884f, 24.124636f, 50.655247f, 23.766985f);
                l2.cubicTo(65.46684f, 24.124636f, 74.612946f, 30.543125f, 75.207f, 30.9727f);
                l2.lineTo(50.655247f, 48.301735f);
                l2.close();
                l2.moveTo(50.655247f, 76.95833f);
                l2.cubicTo(32.996593f, 65.54555f, 28.063675f, 44.621784f, 26.588911f, 34.82606f);
                l2.lineTo(50.655247f, 58.75586f);
                l2.lineTo(74.774666f, 34.82606f);
                l2.cubicTo(73.299904f, 44.621784f, 68.18205f, 65.54555f, 50.655247f, 76.95833f);
                l2.lineTo(50.655247f, 76.95833f);
                l2.close();
                l2.moveTo(80.50583f, 27.418613f);
                l2.cubicTo(78.234055f, 25.462376f, 67.93515f, 18.0f, 50.655247f, 18.0f);
                l2.cubicTo(33.36769f, 18.0f, 23.094215f, 25.462376f, 20.822441f, 27.418613f);
                l2.cubicTo(20.739235f, 27.489798f, 20.0f, 28.14746f, 20.0f, 28.14746f);
                l2.lineTo(20.033085f, 31.721006f);
                l2.cubicTo(20.03827f, 32.07693f, 20.300978f, 40.503387f, 23.987518f, 51.028694f);
                l2.cubicTo(28.894264f, 65.03814f, 37.481873f, 76.145f, 49.090115f, 83.07533f);
                l2.lineTo(50.655247f, 84.0f);
                l2.lineTo(52.24013f, 83.07533f);
                l2.cubicTo(63.848377f, 76.145f, 72.40265f, 65.03814f, 77.309395f, 51.028694f);
                l2.cubicTo(80.99594f, 40.503387f, 81.26309f, 32.07693f, 81.26827f, 31.721006f);
                l2.lineTo(81.310005f, 28.14746f);
                l2.cubicTo(81.310005f, 28.14746f, 80.58879f, 27.489798f, 80.50583f, 27.418613f);
                l2.lineTo(80.50583f, 27.418613f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
