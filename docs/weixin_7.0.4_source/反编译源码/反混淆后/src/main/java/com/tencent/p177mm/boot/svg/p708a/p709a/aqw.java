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

/* renamed from: com.tencent.mm.boot.svg.a.a.aqw */
public final class aqw extends C5163c {
    private final int height = 186;
    private final int width = 186;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                a.setColor(-15683841);
                Path l = C5163c.m7884l(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(96.53957f, 101.59992f);
                l.lineTo(93.96079f, 37.990128f);
                l.cubicTo(93.93903f, 37.45337f, 93.475f, 37.0f, 92.925255f, 37.0f);
                l.lineTo(84.91605f, 37.0f);
                l.cubicTo(84.37632f, 37.0f, 83.90268f, 37.443295f, 83.880516f, 37.990128f);
                l.lineTo(81.00167f, 109.00153f);
                l.cubicTo(80.974144f, 109.68064f, 81.28838f, 110.28124f, 81.79111f, 110.64247f);
                l.cubicTo(81.98214f, 110.944756f, 82.25776f, 111.19843f, 82.60479f, 111.36398f);
                l.lineTo(129.58261f, 133.77519f);
                l.cubicTo(130.08742f, 134.016f, 130.7105f, 133.8202f, 130.98582f, 133.34332f);
                l.lineTo(133.9888f, 128.14203f);
                l.cubicTo(134.26079f, 127.67092f, 134.11714f, 127.02809f, 133.66052f, 126.71911f);
                l.lineTo(96.53957f, 101.59992f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
