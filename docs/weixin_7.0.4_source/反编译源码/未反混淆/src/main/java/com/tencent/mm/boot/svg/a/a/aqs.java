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

public final class aqs extends c {
    private final int height = 186;
    private final int width = 186;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                a.setColor(-16896);
                Path l = c.l(looper);
                l.moveTo(186.0f, 94.14815f);
                l.cubicTo(186.0f, 41.636444f, 144.36356f, 0.0f, 91.85185f, 0.0f);
                l.cubicTo(41.636444f, 0.0f, 0.0f, 41.636444f, 0.0f, 94.14815f);
                l.cubicTo(0.0f, 144.36356f, 41.636444f, 186.0f, 91.85185f, 186.0f);
                l.cubicTo(144.36356f, 186.0f, 186.0f, 144.36356f, 186.0f, 94.14815f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(107.577896f, 70.84931f);
                l.cubicTo(122.7227f, 70.84931f, 135.0f, 83.19187f, 135.0f, 98.42466f);
                l.cubicTo(135.0f, 113.6541f, 122.72481f, 126.0f, 107.577896f, 126.0f);
                l.lineTo(55.890526f, 126.0f);
                l.cubicTo(55.3987f, 126.0f, 55.0f, 125.58803f, 55.0f, 125.10005f);
                l.lineTo(55.0f, 117.85886f);
                l.cubicTo(55.0f, 117.361824f, 55.39301f, 116.9589f, 55.890583f, 116.9589f);
                l.lineTo(107.58115f, 116.9589f);
                l.cubicTo(117.75454f, 116.9589f, 126.01124f, 108.660835f, 126.01124f, 98.42466f);
                l.cubicTo(126.01124f, 88.186226f, 117.7598f, 79.89041f, 107.58115f, 79.89041f);
                l.lineTo(75.55843f, 79.89041f);
                l.lineTo(75.55843f, 89.56726f);
                l.cubicTo(75.55843f, 90.5657f, 74.91493f, 90.89319f, 74.12114f, 90.29675f);
                l.lineTo(55.596493f, 76.37788f);
                l.cubicTo(54.799637f, 75.779144f, 54.8027f, 74.81443f, 55.596493f, 74.217995f);
                l.lineTo(74.12114f, 60.299118f);
                l.cubicTo(74.918f, 59.700382f, 75.55843f, 60.02929f, 75.55843f, 61.02861f);
                l.lineTo(75.55843f, 70.84931f);
                l.lineTo(107.577896f, 70.84931f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
