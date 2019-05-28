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

/* renamed from: com.tencent.mm.boot.svg.a.a.aqt */
public final class aqt extends C5163c {
    private final int height = 270;
    private final int width = 270;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
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
                k.setColor(-12601288);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(131.16f, 0.0f);
                l.lineTo(138.59f, 0.0f);
                l.cubicTo(169.69f, 0.83f, 200.36f, 12.7f, 223.71f, 33.28f);
                l.cubicTo(251.77f, 57.44f, 268.83f, 93.6f, 270.0f, 130.59f);
                l.lineTo(270.0f, 137.53f);
                l.cubicTo(269.48f, 168.53f, 257.86f, 199.15f, 237.66f, 222.67f);
                l.cubicTo(213.11f, 251.69f, 175.86f, 269.39f, 137.83f, 270.0f);
                l.lineTo(132.41f, 270.0f);
                l.cubicTo(106.69f, 269.5f, 81.14f, 261.55f, 59.82f, 247.12f);
                l.cubicTo(35.24f, 230.72f, 16.33f, 205.99f, 7.01f, 177.95f);
                l.cubicTo(2.53f, 164.82f, 0.31f, 150.97f, 0.0f, 137.13f);
                l.lineTo(0.0f, 133.07f);
                l.cubicTo(0.36f, 94.51f, 18.29f, 56.6f, 47.89f, 31.9f);
                l.cubicTo(70.96f, 12.2f, 100.85f, 0.89f, 131.16f, 0.0f);
                l.lineTo(131.16f, 0.0f);
                l.close();
                l.moveTo(203.02f, 82.05f);
                l.cubicTo(171.35f, 113.7f, 139.71f, 145.38f, 108.03f, 177.02f);
                l.cubicTo(95.98f, 165.08f, 84.03f, 153.03f, 72.01f, 141.05f);
                l.cubicTo(71.22f, 140.01f, 69.44f, 139.34f, 68.41f, 140.39f);
                l.cubicTo(65.92f, 142.65f, 63.6f, 145.1f, 61.23f, 147.49f);
                l.cubicTo(59.98f, 148.45f, 60.3f, 150.46f, 61.49f, 151.33f);
                l.cubicTo(76.33f, 166.21f, 91.18f, 181.09f, 106.08f, 195.91f);
                l.cubicTo(107.0f, 197.16f, 108.96f, 197.19f, 109.91f, 195.94f);
                l.cubicTo(144.3f, 161.65f, 178.59f, 127.26f, 212.96f, 92.94f);
                l.cubicTo(214.03f, 91.97f, 215.05f, 90.77f, 214.44f, 89.23f);
                l.cubicTo(211.96f, 86.51f, 209.35f, 83.91f, 206.66f, 81.41f);
                l.cubicTo(205.59f, 80.26f, 203.84f, 81.02f, 203.02f, 82.05f);
                l.lineTo(203.02f, 82.05f);
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
