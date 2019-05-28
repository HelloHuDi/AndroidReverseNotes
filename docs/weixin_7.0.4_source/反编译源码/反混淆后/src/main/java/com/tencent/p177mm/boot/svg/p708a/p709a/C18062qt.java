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

/* renamed from: com.tencent.mm.boot.svg.a.a.qt */
public final class C18062qt extends C5163c {
    private final int height = 108;
    private final int width = 108;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-12206054);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.lineTo(108.0f, 108.0f);
                l.lineTo(0.0f, 108.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(47.0f, 61.0f);
                l2.cubicTo(53.445965f, 67.115555f, 59.40413f, 69.98397f, 62.0f, 70.0f);
                l2.cubicTo(63.810833f, 69.648026f, 69.2978f, 65.97824f, 72.0f, 66.0f);
                l2.cubicTo(73.13301f, 66.05056f, 81.268166f, 71.4013f, 82.0f, 72.0f);
                l2.cubicTo(83.237686f, 72.63856f, 84.15078f, 73.3612f, 84.0f, 74.0f);
                l2.cubicTo(83.807396f, 75.19006f, 80.232086f, 85.26249f, 71.0f, 84.0f);
                l2.cubicTo(61.976585f, 82.47289f, 49.251225f, 72.903206f, 42.0f, 66.0f);
                l2.lineTo(47.0f, 61.0f);
                l2.lineTo(47.0f, 61.0f);
                l2.close();
                l2.moveTo(47.0f, 61.0f);
                l2.cubicTo(40.88444f, 54.554035f, 38.01603f, 48.59587f, 38.0f, 46.0f);
                l2.cubicTo(38.35198f, 44.189167f, 42.021763f, 38.7022f, 42.0f, 36.0f);
                l2.cubicTo(41.94944f, 34.86699f, 36.598705f, 26.731834f, 36.0f, 26.0f);
                l2.cubicTo(35.36144f, 24.762312f, 34.638798f, 23.84922f, 34.0f, 24.0f);
                l2.cubicTo(32.80994f, 24.192604f, 22.737509f, 27.767912f, 24.0f, 37.0f);
                l2.cubicTo(25.52711f, 46.023415f, 35.096794f, 58.748775f, 42.0f, 66.0f);
                l2.lineTo(47.0f, 61.0f);
                l2.lineTo(47.0f, 61.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
