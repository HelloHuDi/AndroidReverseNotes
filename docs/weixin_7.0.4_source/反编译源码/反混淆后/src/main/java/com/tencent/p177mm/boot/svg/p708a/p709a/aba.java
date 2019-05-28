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

/* renamed from: com.tencent.mm.boot.svg.a.a.aba */
public final class aba extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-14513167);
                Path l = C5163c.m7884l(looper);
                l.moveTo(57.05529f, 26.537308f);
                l.cubicTo(57.34599f, 25.177156f, 57.580128f, 23.656338f, 57.7577f, 21.974848f);
                l.lineTo(36.774937f, 9.734903f);
                l.cubicTo(36.466652f, 9.555071f, 35.53348f, 9.554993f, 35.225063f, 9.734903f);
                l.lineTo(14.2423f, 21.974848f);
                l.lineTo(36.0f, 34.536663f);
                l.cubicTo(38.0953f, 34.90591f, 40.012356f, 35.184734f, 41.751175f, 35.373142f);
                l.lineTo(37.8f, 37.654354f);
                l.lineTo(34.2f, 37.654354f);
                l.lineTo(12.6f, 25.183588f);
                l.lineTo(9.0f, 23.856966f);
                l.cubicTo(9.0f, 22.204617f, 10.160156f, 20.188366f, 11.588874f, 19.354948f);
                l.lineTo(33.411125f, 6.6252995f);
                l.cubicTo(34.840923f, 5.791252f, 37.160156f, 5.791881f, 38.588875f, 6.6252995f);
                l.lineTo(60.411125f, 19.354948f);
                l.cubicTo(61.840923f, 20.188995f, 63.0f, 22.21864f, 63.0f, 23.856966f);
                l.lineTo(59.4f, 25.183588f);
                l.lineTo(57.05529f, 26.537308f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-568490);
                l = C5163c.m7884l(looper);
                l.moveTo(34.582882f, 62.76065f);
                l.lineTo(37.8f, 62.89739f);
                l.lineTo(58.59719f, 50.765697f);
                l.cubicTo(58.920998f, 50.57681f, 59.4f, 49.743988f, 59.4f, 49.37328f);
                l.lineTo(59.4f, 25.183588f);
                l.lineTo(37.8f, 37.654354f);
                l.lineTo(35.855362f, 39.0928f);
                l.lineTo(36.00463f, 36.316406f);
                l.lineTo(36.00463f, 34.52065f);
                l.lineTo(61.200527f, 19.958323f);
                l.cubicTo(62.244278f, 20.956034f, 63.0f, 22.53407f, 63.0f, 23.856966f);
                l.lineTo(63.0f, 49.37328f);
                l.cubicTo(63.0f, 51.02563f, 61.839844f, 53.04188f, 60.411125f, 53.8753f);
                l.lineTo(38.588875f, 66.60495f);
                l.cubicTo(37.443314f, 67.27319f, 35.726795f, 67.40563f, 34.354786f, 67.003235f);
                l.lineTo(34.582882f, 62.76065f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-81363);
                l = C5163c.m7884l(looper);
                l.moveTo(37.8f, 66.9551f);
                l.cubicTo(36.403755f, 67.4152f, 34.599426f, 67.29812f, 33.411125f, 66.60495f);
                l.lineTo(11.588874f, 53.8753f);
                l.cubicTo(10.159078f, 53.041252f, 9.0f, 51.01161f, 9.0f, 49.37328f);
                l.lineTo(9.0f, 23.856966f);
                l.cubicTo(9.0f, 23.631493f, 9.021603f, 23.399242f, 9.062542f, 23.164148f);
                l.lineTo(12.6f, 25.204777f);
                l.lineTo(12.6f, 49.37328f);
                l.cubicTo(12.6f, 49.73662f, 13.083672f, 50.579533f, 13.402809f, 50.765697f);
                l.lineTo(34.2f, 62.89739f);
                l.lineTo(34.2f, 37.665016f);
                l.lineTo(34.217228f, 37.674953f);
                l.lineTo(36.008614f, 36.302216f);
                l.lineTo(37.8f, 37.674953f);
                l.lineTo(37.8f, 66.9551f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
