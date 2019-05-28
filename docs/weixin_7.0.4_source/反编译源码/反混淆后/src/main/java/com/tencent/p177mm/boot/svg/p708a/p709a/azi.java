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

/* renamed from: com.tencent.mm.boot.svg.a.a.azi */
public final class azi extends C5163c {
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
                k.setColor(-12799249);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(48.11264f, 11.0f);
                l.cubicTo(29.075232f, 11.190086f, 20.986343f, 26.826294f, 20.986343f, 40.877155f);
                l.cubicTo(9.261343f, 52.839657f, 12.905231f, 69.57371f, 16.54523f, 69.57371f);
                l.cubicTo(18.859121f, 69.951294f, 22.617083f, 63.59698f, 22.617083f, 63.59698f);
                l.cubicTo(22.617083f, 63.59698f, 22.73375f, 67.556465f, 25.812454f, 71.13836f);
                l.cubicTo(22.417454f, 72.655174f, 20.195602f, 75.13793f, 20.195602f, 77.949135f);
                l.cubicTo(20.195602f, 82.57069f, 26.175417f, 86.31681f, 33.553936f, 86.31681f);
                l.cubicTo(39.042454f, 86.31681f, 43.753193f, 84.242676f, 45.80912f, 81.27888f);
                l.lineTo(50.492638f, 81.27888f);
                l.cubicTo(52.547268f, 84.242676f, 57.25801f, 86.31681f, 62.74653f, 86.31681f);
                l.cubicTo(70.12375f, 86.31681f, 76.106155f, 82.57198f, 76.106155f, 77.949135f);
                l.cubicTo(76.106155f, 75.13793f, 73.88431f, 72.65646f, 70.4893f, 71.13836f);
                l.cubicTo(73.56801f, 67.556465f, 73.68468f, 63.59698f, 73.68468f, 63.59698f);
                l.cubicTo(73.68468f, 63.59698f, 77.441345f, 69.951294f, 79.75653f, 69.57371f);
                l.cubicTo(83.39653f, 69.57241f, 87.03912f, 52.838364f, 75.31412f, 40.875862f);
                l.cubicTo(75.31412f, 26.826294f, 67.14875f, 11.181034f, 48.11264f, 11.0f);
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
