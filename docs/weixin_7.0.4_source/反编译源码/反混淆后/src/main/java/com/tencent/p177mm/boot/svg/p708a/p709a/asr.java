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

/* renamed from: com.tencent.mm.boot.svg.a.a.asr */
public final class asr extends C5163c {
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
                k2.setColor(-8806);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(108.41f, 0.0f);
                l.lineTo(113.56f, 0.0f);
                l.cubicTo(139.19f, 0.58f, 164.5f, 10.31f, 183.78f, 27.22f);
                l.cubicTo(206.99f, 47.15f, 221.11f, 77.02f, 222.0f, 107.59f);
                l.lineTo(222.0f, 111.72f);
                l.cubicTo(221.92f, 139.4f, 210.98f, 166.83f, 191.95f, 186.92f);
                l.cubicTo(171.7f, 208.74f, 142.35f, 221.7f, 112.58f, 222.0f);
                l.lineTo(107.9f, 222.0f);
                l.cubicTo(79.15f, 221.23f, 50.91f, 208.82f, 31.06f, 187.98f);
                l.cubicTo(12.03f, 168.43f, 0.85f, 141.66f, 0.0f, 114.41f);
                l.lineTo(0.0f, 107.69f);
                l.cubicTo(0.84f, 79.23f, 13.02f, 51.32f, 33.52f, 31.54f);
                l.cubicTo(53.31f, 12.06f, 80.65f, 0.61f, 108.41f, 0.0f);
                l.lineTo(108.41f, 0.0f);
                l.close();
                l.moveTo(166.8f, 67.65f);
                l.cubicTo(141.14f, 93.13f, 115.55f, 118.68f, 89.88f, 144.15f);
                l.cubicTo(78.41f, 132.89f, 67.14f, 121.42f, 55.64f, 110.2f);
                l.cubicTo(53.08f, 107.82f, 50.36f, 110.96f, 48.69f, 112.83f);
                l.cubicTo(47.23f, 114.01f, 46.74f, 116.38f, 48.25f, 117.73f);
                l.cubicTo(61.05f, 130.61f, 73.99f, 143.36f, 86.84f, 156.19f);
                l.cubicTo(88.39f, 158.28f, 91.57f, 158.14f, 93.05f, 156.06f);
                l.cubicTo(120.26f, 128.91f, 147.6f, 101.88f, 174.75f, 74.68f);
                l.cubicTo(177.24f, 72.19f, 174.13f, 69.37f, 172.24f, 67.73f);
                l.cubicTo(170.89f, 65.97f, 168.16f, 65.84f, 166.8f, 67.65f);
                l.lineTo(166.8f, 67.65f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1940159);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 66.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(119.8f, 1.65f);
                l.cubicTo(121.16f, -0.16f, 123.89f, -0.03f, 125.24f, 1.73f);
                l.cubicTo(127.13f, 3.37f, 130.24f, 6.19f, 127.75f, 8.68f);
                l.cubicTo(100.6f, 35.88f, 73.26f, 62.91f, 46.05f, 90.06f);
                l.cubicTo(44.57f, 92.14f, 41.39f, 92.28f, 39.84f, 90.19f);
                l.cubicTo(26.99f, 77.36f, 14.05f, 64.61f, 1.25f, 51.73f);
                l.cubicTo(-0.26f, 50.38f, 0.23f, 48.01f, 1.69f, 46.83f);
                l.cubicTo(3.36f, 44.96f, 6.08f, 41.82f, 8.64f, 44.2f);
                l.cubicTo(20.14f, 55.42f, 31.41f, 66.89f, 42.88f, 78.15f);
                l.cubicTo(68.55f, 52.68f, 94.14f, 27.13f, 119.8f, 1.65f);
                l.lineTo(119.8f, 1.65f);
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
