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

/* renamed from: com.tencent.mm.boot.svg.a.a.ard */
public final class ard extends C5163c {
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(57.74f, 0.0f);
                l.lineTo(61.88f, 0.0f);
                l.cubicTo(76.5f, 0.47f, 90.87f, 6.44f, 101.42f, 16.6f);
                l.cubicTo(112.63f, 27.2f, 119.36f, 42.25f, 120.0f, 57.65f);
                l.lineTo(120.0f, 62.03f);
                l.cubicTo(119.47f, 77.56f, 112.7f, 92.75f, 101.39f, 103.42f);
                l.cubicTo(90.95f, 113.49f, 76.75f, 119.41f, 62.28f, 120.0f);
                l.lineTo(58.1f, 120.0f);
                l.cubicTo(42.07f, 119.5f, 26.38f, 112.32f, 15.65f, 100.39f);
                l.cubicTo(6.15f, 90.08f, 0.61f, 76.34f, 0.0f, 62.36f);
                l.lineTo(0.0f, 57.99f);
                l.cubicTo(0.53f, 42.26f, 7.48f, 26.86f, 19.05f, 16.16f);
                l.cubicTo(29.45f, 6.34f, 43.46f, 0.59f, 57.74f, 0.0f);
                l.lineTo(57.74f, 0.0f);
                l.close();
                l.moveTo(50.53f, 4.81f);
                l.cubicTo(34.94f, 7.39f, 20.71f, 17.0f, 12.43f, 30.46f);
                l.cubicTo(4.17f, 43.58f, 1.85f, 60.21f, 6.07f, 75.11f);
                l.cubicTo(9.83f, 88.74f, 19.02f, 100.74f, 31.15f, 108.0f);
                l.cubicTo(44.42f, 116.08f, 61.13f, 118.16f, 76.0f, 113.67f);
                l.cubicTo(89.73f, 109.64f, 101.71f, 100.06f, 108.73f, 87.6f);
                l.cubicTo(115.52f, 75.74f, 117.64f, 61.35f, 114.7f, 48.02f);
                l.cubicTo(111.63f, 33.64f, 102.57f, 20.7f, 90.16f, 12.83f);
                l.cubicTo(78.57f, 5.32f, 64.13f, 2.44f, 50.53f, 4.81f);
                l.lineTo(50.53f, 4.81f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(42.0f, 32.01f);
                l.cubicTo(57.32f, 41.34f, 72.66f, 50.64f, 87.97f, 60.0f);
                l.cubicTo(72.67f, 69.37f, 57.32f, 78.66f, 42.01f, 88.0f);
                l.cubicTo(42.0f, 69.33f, 42.0f, 50.67f, 42.0f, 32.01f);
                l.lineTo(42.0f, 32.01f);
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
