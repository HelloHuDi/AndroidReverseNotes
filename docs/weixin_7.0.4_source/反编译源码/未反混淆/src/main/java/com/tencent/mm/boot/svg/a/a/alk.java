package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class alk extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-855638017);
                Path l = c.l(looper);
                l.moveTo(0.0f, 28.8f);
                l.cubicTo(0.0f, 12.894198f, 12.894198f, 0.0f, 28.8f, 0.0f);
                l.lineTo(115.2f, 0.0f);
                l.cubicTo(131.1058f, 0.0f, 144.0f, 12.894198f, 144.0f, 28.8f);
                l.lineTo(144.0f, 115.2f);
                l.cubicTo(144.0f, 131.1058f, 131.1058f, 144.0f, 115.2f, 144.0f);
                l.lineTo(28.8f, 144.0f);
                l.cubicTo(12.894198f, 144.0f, 0.0f, 131.1058f, 0.0f, 115.2f);
                l.lineTo(0.0f, 28.8f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                l = c.l(looper);
                l.moveTo(55.95f, 100.0f);
                l.lineTo(55.95f, 45.325f);
                l.lineTo(71.025f, 45.325f);
                l.cubicTo(82.05f, 45.325f, 89.25f, 49.375f, 89.25f, 58.6f);
                l.cubicTo(89.25f, 64.225f, 86.325f, 68.875f, 80.85f, 70.525f);
                l.lineTo(80.85f, 70.9f);
                l.cubicTo(87.9f, 72.1f, 92.55f, 76.525f, 92.55f, 84.025f);
                l.cubicTo(92.55f, 94.6f, 84.45f, 100.0f, 72.15f, 100.0f);
                l.lineTo(55.95f, 100.0f);
                l.close();
                l.moveTo(60.45f, 69.175f);
                l.lineTo(69.6f, 69.175f);
                l.cubicTo(80.4f, 69.175f, 84.75f, 65.35f, 84.75f, 59.125f);
                l.cubicTo(84.75f, 51.7f, 79.725f, 49.0f, 70.05f, 49.0f);
                l.lineTo(60.45f, 49.0f);
                l.lineTo(60.45f, 69.175f);
                l.close();
                l.moveTo(60.45f, 96.25f);
                l.lineTo(71.1f, 96.25f);
                l.cubicTo(81.675f, 96.25f, 88.125f, 92.5f, 88.125f, 84.025f);
                l.cubicTo(88.125f, 76.375f, 81.975f, 72.775f, 71.1f, 72.775f);
                l.lineTo(60.45f, 72.775f);
                l.lineTo(60.45f, 96.25f);
                l.close();
                canvas.saveLayerAlpha(null, 230, 4);
                Paint a2 = c.a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
