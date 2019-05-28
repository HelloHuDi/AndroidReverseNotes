package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.up */
public final class C18073up extends C5163c {
    private final int height = C44697b.CTRL_INDEX;
    private final int width = C44697b.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C44697b.CTRL_INDEX;
            case 1:
                return C44697b.CTRL_INDEX;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(64.25f, 0.0f);
                l.lineTo(70.53f, 0.0f);
                l.cubicTo(86.47f, 0.81f, 102.08f, 7.28f, 113.67f, 18.29f);
                l.cubicTo(126.42f, 30.08f, 134.07f, 46.96f, 135.0f, 64.26f);
                l.lineTo(135.0f, 70.55f);
                l.cubicTo(134.14f, 87.93f, 126.45f, 104.9f, 113.65f, 116.74f);
                l.cubicTo(102.12f, 127.68f, 86.62f, 134.11f, 70.79f, 135.0f);
                l.lineTo(64.41f, 135.0f);
                l.cubicTo(48.49f, 134.17f, 32.91f, 127.71f, 21.33f, 116.72f);
                l.cubicTo(8.58f, 104.93f, 0.94f, 88.04f, 0.0f, 70.73f);
                l.lineTo(0.0f, 64.48f);
                l.cubicTo(0.86f, 47.1f, 8.53f, 30.12f, 21.33f, 18.28f);
                l.cubicTo(32.87f, 7.32f, 48.39f, 0.88f, 64.25f, 0.0f);
                l.lineTo(64.25f, 0.0f);
                l.close();
                l.moveTo(57.52f, 3.77f);
                l.cubicTo(42.5f, 6.08f, 28.42f, 13.93f, 18.57f, 25.5f);
                l.cubicTo(8.68f, 36.91f, 3.06f, 51.91f, 3.01f, 67.01f);
                l.cubicTo(2.84f, 81.94f, 8.09f, 96.86f, 17.62f, 108.37f);
                l.cubicTo(28.03f, 121.18f, 43.53f, 129.71f, 59.94f, 131.55f);
                l.cubicTo(73.75f, 133.2f, 88.08f, 130.26f, 100.06f, 123.18f);
                l.cubicTo(112.83f, 115.74f, 122.9f, 103.78f, 127.99f, 89.9f);
                l.cubicTo(133.51f, 75.11f, 133.31f, 58.27f, 127.42f, 43.62f);
                l.cubicTo(121.38f, 28.33f, 109.23f, 15.59f, 94.26f, 8.81f);
                l.cubicTo(82.86f, 3.56f, 69.91f, 1.85f, 57.52f, 3.77f);
                l.lineTo(57.52f, 3.77f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(71.48f, 36.66f);
                l.cubicTo(72.83f, 35.99f, 74.57f, 36.22f, 75.64f, 37.3f);
                l.cubicTo(83.56f, 45.03f, 88.42f, 55.92f, 88.48f, 67.02f);
                l.cubicTo(88.67f, 78.18f, 84.03f, 89.26f, 76.17f, 97.15f);
                l.cubicTo(74.45f, 99.09f, 70.93f, 98.32f, 70.08f, 95.91f);
                l.cubicTo(68.99f, 93.68f, 70.93f, 91.82f, 72.27f, 90.3f);
                l.cubicTo(79.57f, 82.18f, 82.68f, 70.48f, 80.12f, 59.83f);
                l.cubicTo(78.66f, 53.24f, 74.97f, 47.37f, 70.39f, 42.5f);
                l.cubicTo(68.62f, 40.81f, 69.29f, 37.63f, 71.48f, 36.66f);
                l.lineTo(71.48f, 36.66f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(59.3f, 46.31f);
                l.cubicTo(60.57f, 45.47f, 62.43f, 45.46f, 63.59f, 46.49f);
                l.cubicTo(68.45f, 50.72f, 71.98f, 56.57f, 73.07f, 62.95f);
                l.cubicTo(74.85f, 72.35f, 70.86f, 82.39f, 63.57f, 88.45f);
                l.cubicTo(61.49f, 90.24f, 57.87f, 88.68f, 57.65f, 85.97f);
                l.cubicTo(57.22f, 83.91f, 59.11f, 82.64f, 60.26f, 81.26f);
                l.cubicTo(65.65f, 75.95f, 67.57f, 67.36f, 64.59f, 60.34f);
                l.cubicTo(63.43f, 57.09f, 61.06f, 54.54f, 58.76f, 52.06f);
                l.cubicTo(56.99f, 50.55f, 57.36f, 47.51f, 59.3f, 46.31f);
                l.lineTo(59.3f, 46.31f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(46.43f, 61.47f);
                l.cubicTo(46.3f, 59.41f, 46.86f, 56.89f, 49.2f, 56.39f);
                l.cubicTo(52.91f, 55.56f, 55.53f, 59.18f, 57.13f, 62.0f);
                l.cubicTo(60.25f, 67.57f, 57.7f, 75.02f, 52.41f, 78.25f);
                l.cubicTo(49.41f, 79.96f, 45.5f, 77.16f, 46.46f, 73.72f);
                l.cubicTo(48.18f, 72.01f, 50.78f, 70.71f, 50.99f, 68.0f);
                l.cubicTo(51.36f, 64.94f, 48.63f, 62.98f, 46.43f, 61.47f);
                l.lineTo(46.43f, 61.47f);
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
