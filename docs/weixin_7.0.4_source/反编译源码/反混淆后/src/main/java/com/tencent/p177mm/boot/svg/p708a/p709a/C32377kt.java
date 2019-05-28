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

/* renamed from: com.tencent.mm.boot.svg.a.a.kt */
public final class C32377kt extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-9276814);
                Path l = C5163c.m7884l(looper);
                l.moveTo(32.316944f, 114.45962f);
                l.cubicTo(17.49707f, 103.41242f, 8.0f, 86.3897f, 8.0f, 67.29348f);
                l.cubicTo(8.0f, 33.99431f, 36.877632f, 7.0f, 72.5f, 7.0f);
                l.cubicTo(108.12237f, 7.0f, 137.0f, 33.99431f, 137.0f, 67.29348f);
                l.cubicTo(137.0f, 100.59264f, 108.12237f, 127.58696f, 72.5f, 127.58696f);
                l.cubicTo(66.06798f, 127.58696f, 59.85585f, 126.70688f, 53.993908f, 125.06851f);
                l.lineTo(32.316944f, 136.89055f);
                l.lineTo(32.316944f, 114.45962f);
                l.close();
                l.moveTo(30.467037f, 88.38713f);
                l.lineTo(66.017456f, 50.875744f);
                l.lineTo(82.72663f, 68.6543f);
                l.lineTo(114.75198f, 50.19022f);
                l.lineTo(79.51087f, 88.32609f);
                l.lineTo(63.189262f, 70.64465f);
                l.lineTo(30.467037f, 88.38713f);
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
