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

/* renamed from: com.tencent.mm.boot.svg.a.a.ass */
public final class ass extends C5163c {
    private final int height = 222;
    private final int width = 222;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 222;
            case 1:
                return 222;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-11286451);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(106.78f, 0.0f);
                l.lineTo(114.26f, 0.0f);
                l.cubicTo(143.67f, 0.83f, 172.5f, 13.86f, 192.4f, 35.56f);
                l.cubicTo(210.27f, 54.61f, 220.71f, 80.13f, 222.0f, 106.17f);
                l.lineTo(222.0f, 115.49f);
                l.cubicTo(220.85f, 140.93f, 210.93f, 165.91f, 193.85f, 184.84f);
                l.cubicTo(173.91f, 207.48f, 144.4f, 221.16f, 114.26f, 222.0f);
                l.lineTo(107.88f, 222.0f);
                l.cubicTo(78.88f, 221.22f, 50.43f, 208.59f, 30.55f, 187.44f);
                l.cubicTo(12.11f, 168.27f, 1.27f, 142.3f, 0.0f, 115.78f);
                l.lineTo(0.0f, 107.09f);
                l.cubicTo(1.01f, 80.27f, 11.92f, 53.95f, 30.53f, 34.57f);
                l.cubicTo(50.17f, 13.67f, 78.16f, 1.14f, 106.78f, 0.0f);
                l.lineTo(106.78f, 0.0f);
                l.close();
                l.moveTo(166.75f, 67.7f);
                l.cubicTo(141.11f, 93.18f, 115.52f, 118.69f, 89.88f, 144.16f);
                l.cubicTo(78.65f, 133.04f, 67.47f, 121.87f, 56.26f, 110.74f);
                l.cubicTo(55.32f, 109.66f, 53.84f, 108.99f, 52.43f, 109.53f);
                l.cubicTo(49.78f, 111.27f, 45.1f, 115.1f, 48.7f, 118.23f);
                l.cubicTo(60.56f, 130.06f, 72.47f, 141.86f, 84.32f, 153.7f);
                l.cubicTo(85.66f, 154.99f, 86.88f, 156.46f, 88.47f, 157.46f);
                l.cubicTo(90.13f, 158.14f, 91.93f, 157.42f, 93.02f, 156.09f);
                l.cubicTo(120.24f, 128.93f, 147.59f, 101.89f, 174.75f, 74.68f);
                l.cubicTo(177.24f, 72.17f, 174.1f, 69.35f, 172.21f, 67.69f);
                l.cubicTo(170.84f, 65.92f, 168.1f, 65.88f, 166.75f, 67.7f);
                l.lineTo(166.75f, 67.7f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 66.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(119.75f, 1.7f);
                l.cubicTo(121.1f, -0.12f, 123.84f, -0.08f, 125.21f, 1.69f);
                l.cubicTo(127.1f, 3.35f, 130.24f, 6.17f, 127.75f, 8.68f);
                l.cubicTo(100.59f, 35.89f, 73.24f, 62.93f, 46.02f, 90.09f);
                l.cubicTo(44.93f, 91.42f, 43.13f, 92.14f, 41.47f, 91.46f);
                l.cubicTo(39.88f, 90.46f, 38.66f, 88.99f, 37.32f, 87.7f);
                l.cubicTo(25.47f, 75.86f, 13.56f, 64.06f, 1.7f, 52.23f);
                l.cubicTo(-1.9f, 49.1f, 2.78f, 45.27f, 5.43f, 43.53f);
                l.cubicTo(6.84f, 42.99f, 8.32f, 43.66f, 9.26f, 44.74f);
                l.cubicTo(20.47f, 55.87f, 31.65f, 67.04f, 42.88f, 78.16f);
                l.cubicTo(68.52f, 52.69f, 94.11f, 27.18f, 119.75f, 1.7f);
                l.lineTo(119.75f, 1.7f);
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
