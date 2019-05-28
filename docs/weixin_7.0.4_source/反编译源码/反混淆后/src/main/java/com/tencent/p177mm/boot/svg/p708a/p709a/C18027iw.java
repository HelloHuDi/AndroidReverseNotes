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

/* renamed from: com.tencent.mm.boot.svg.a.a.iw */
public final class C18027iw extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-36352);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.346995f, 0.5783295f);
                l.cubicTo(22.18465f, -1.1732551f, 29.903292f, 1.1388365f, 34.658615f, 6.363563f);
                l.cubicTo(39.944534f, 11.888561f, 41.47625f, 20.57642f, 38.49291f, 27.612785f);
                l.cubicTo(35.00901f, 36.751053f, 24.08678f, 42.07587f, 14.7263f, 39.2333f);
                l.cubicTo(7.2579393f, 37.361607f, 1.3813599f, 30.705584f, 0.2901382f, 23.098701f);
                l.cubicTo(-1.5319017f, 13.179729f, 5.4358993f, 2.6401947f, 15.346995f, 0.5783295f);
                l.lineTo(15.346995f, 0.5783295f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-70474);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a3, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(13.42649f, 0.6276179f);
                l.cubicTo(22.175201f, -1.8918488f, 32.143734f, 3.4270253f, 34.983315f, 12.055199f);
                l.cubicTo(37.472946f, 18.893751f, 35.273273f, 27.092016f, 29.664099f, 31.721035f);
                l.cubicTo(23.984934f, 36.70998f, 15.086246f, 37.41983f, 8.687188f, 33.41068f);
                l.cubicTo(2.7280664f, 29.891422f, -0.7814165f, 22.712942f, 0.1484465f, 15.854395f);
                l.cubicTo(0.91833305f, 8.685912f, 6.4475183f, 2.3772476f, 13.42649f, 0.6276179f);
                l.lineTo(13.42649f, 0.6276179f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-36352);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(15.0255995f, 27.656855f);
                l2.lineTo(15.003011f, 27.679443f);
                l2.lineTo(17.831438f, 30.50787f);
                l2.lineTo(31.450668f, 16.88864f);
                l2.lineTo(28.622242f, 14.060212f);
                l2.lineTo(17.854027f, 24.828426f);
                l2.lineTo(11.996721f, 18.971123f);
                l2.lineTo(9.168295f, 21.79955f);
                l2.lineTo(15.0255995f, 27.656855f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
