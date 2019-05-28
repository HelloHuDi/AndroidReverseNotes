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

/* renamed from: com.tencent.mm.boot.svg.a.a.jd */
public final class C25901jd extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-8617851);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(48.0f, 80.0f);
                l.lineTo(44.0f, 76.0f);
                l.lineTo(48.0f, 64.0f);
                l.lineTo(52.0f, 76.0f);
                l.lineTo(48.0f, 80.0f);
                l.close();
                l.moveTo(78.666664f, 72.46489f);
                l.lineTo(78.666664f, 72.44444f);
                l.lineTo(58.234665f, 65.333336f);
                l.lineTo(58.666668f, 65.333336f);
                l.cubicTo(58.666668f, 65.333336f, 56.0f, 64.88355f, 56.0f, 62.666668f);
                l.lineTo(56.0f, 64.55556f);
                l.lineTo(56.0f, 64.55556f);
                l.lineTo(56.0f, 61.333332f);
                l.cubicTo(56.0f, 59.977333f, 57.333332f, 58.666668f, 57.333332f, 58.666668f);
                l.lineTo(57.319557f, 58.666668f);
                l.cubicTo(63.177776f, 54.190224f, 67.138664f, 45.516445f, 67.13022f, 35.05378f);
                l.cubicTo(67.11867f, 21.260445f, 58.55467f, 12.0f, 48.0f, 12.0f);
                l.cubicTo(37.44533f, 12.0f, 28.896444f, 21.260445f, 28.908f, 35.05378f);
                l.cubicTo(28.916445f, 45.514668f, 32.88978f, 54.189335f, 38.753777f, 58.666668f);
                l.lineTo(38.666668f, 58.666668f);
                l.cubicTo(38.666668f, 58.666668f, 40.0f, 59.977333f, 40.0f, 61.333332f);
                l.lineTo(40.0f, 62.666668f);
                l.cubicTo(40.0f, 64.88355f, 37.333332f, 65.333336f, 37.333332f, 65.333336f);
                l.lineTo(37.765335f, 65.333336f);
                l.lineTo(17.333334f, 72.44444f);
                l.lineTo(17.333334f, 72.46489f);
                l.cubicTo(14.228f, 73.564445f, 12.0f, 76.51822f, 12.0f, 80.0f);
                l.lineTo(12.0f, 84.0f);
                l.lineTo(84.0f, 84.0f);
                l.lineTo(84.0f, 80.0f);
                l.cubicTo(84.0f, 76.51822f, 81.77155f, 73.564445f, 78.666664f, 72.46489f);
                l.lineTo(78.666664f, 72.46489f);
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
