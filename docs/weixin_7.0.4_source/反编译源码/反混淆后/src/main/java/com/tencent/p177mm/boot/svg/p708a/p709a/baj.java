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

/* renamed from: com.tencent.mm.boot.svg.a.a.baj */
public final class baj extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-12863723);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 16.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.334797f, 4.3112025f);
                l.cubicTo(21.186792f, -1.572559f, 33.55958f, -1.422463f, 42.261543f, 4.6914454f);
                l.cubicTo(48.87303f, 9.174312f, 53.184006f, 17.00932f, 52.99396f, 25.054462f);
                l.cubicTo(52.903942f, 31.708717f, 50.01329f, 37.97272f, 46.38247f, 43.416203f);
                l.cubicTo(40.95125f, 51.47135f, 33.95967f, 58.28571f, 27.008104f, 65.0f);
                l.cubicTo(20.046535f, 58.315727f, 13.094969f, 51.481358f, 7.6637444f, 43.456226f);
                l.cubicTo(3.8228788f, 37.70255f, 0.7821936f, 31.028282f, 1.0122454f, 23.973772f);
                l.cubicTo(1.2122905f, 16.068718f, 5.713305f, 8.543908f, 12.334797f, 4.3112025f);
                l.lineTo(12.334797f, 4.3112025f);
                l.close();
                l.moveTo(23.398994f, 14.60051f);
                l.cubicTo(19.540892f, 15.836599f, 16.380636f, 19.116222f, 15.413617f, 23.063734f);
                l.cubicTo(13.429734f, 29.89213f, 18.853012f, 37.448223f, 25.90128f, 37.91674f);
                l.cubicTo(33.079147f, 38.83384f, 39.858246f, 32.02538f, 38.911163f, 24.848087f);
                l.cubicTo(38.442608f, 17.531237f, 30.3376f, 12.148268f, 23.398994f, 14.60051f);
                l.lineTo(23.398994f, 14.60051f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
