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

/* renamed from: com.tencent.mm.boot.svg.a.a.aul */
public final class aul extends C5163c {
    private final int height = 80;
    private final int width = 80;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                k.setColor(-7960954);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(37.78f, 0.0f);
                l.lineTo(41.06f, 0.0f);
                l.cubicTo(50.72f, 0.32f, 60.25f, 4.09f, 67.28f, 10.76f);
                l.cubicTo(74.82f, 17.7f, 79.36f, 27.62f, 80.0f, 37.82f);
                l.lineTo(80.0f, 41.96f);
                l.cubicTo(79.4f, 53.2f, 73.96f, 64.11f, 65.11f, 71.1f);
                l.cubicTo(58.68f, 76.45f, 50.49f, 79.36f, 42.2f, 80.0f);
                l.lineTo(38.02f, 80.0f);
                l.cubicTo(29.65f, 79.43f, 21.38f, 76.49f, 14.9f, 71.1f);
                l.cubicTo(5.88f, 63.97f, 0.36f, 52.77f, 0.0f, 41.29f);
                l.lineTo(0.0f, 38.03f);
                l.cubicTo(0.57f, 27.75f, 5.14f, 17.73f, 12.73f, 10.75f);
                l.cubicTo(19.48f, 4.33f, 28.54f, 0.68f, 37.78f, 0.0f);
                l.lineTo(37.78f, 0.0f);
                l.close();
                l.moveTo(22.35f, 21.53f);
                l.cubicTo(17.6f, 23.92f, 17.99f, 32.16f, 23.16f, 33.8f);
                l.cubicTo(27.59f, 35.1f, 30.99f, 29.79f, 29.81f, 25.87f);
                l.cubicTo(29.31f, 22.58f, 25.55f, 19.78f, 22.35f, 21.53f);
                l.lineTo(22.35f, 21.53f);
                l.close();
                l.moveTo(53.4f, 21.51f);
                l.cubicTo(48.31f, 23.96f, 49.12f, 33.05f, 54.92f, 33.96f);
                l.cubicTo(59.09f, 34.44f, 61.82f, 29.6f, 60.82f, 25.93f);
                l.cubicTo(60.35f, 22.64f, 56.62f, 19.79f, 53.4f, 21.51f);
                l.lineTo(53.4f, 21.51f);
                l.close();
                l.moveTo(11.94f, 43.0f);
                l.cubicTo(12.98f, 52.49f, 18.9f, 61.77f, 28.15f, 65.02f);
                l.cubicTo(36.8f, 68.0f, 46.7f, 67.7f, 55.11f, 64.05f);
                l.cubicTo(63.24f, 60.48f, 68.0f, 51.67f, 68.07f, 43.0f);
                l.cubicTo(49.59f, 39.13f, 30.42f, 39.11f, 11.94f, 43.0f);
                l.lineTo(11.94f, 43.0f);
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
