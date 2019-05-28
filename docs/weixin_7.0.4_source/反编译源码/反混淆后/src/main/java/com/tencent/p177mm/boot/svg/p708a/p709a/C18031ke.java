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

/* renamed from: com.tencent.mm.boot.svg.a.a.ke */
public final class C18031ke extends C5163c {
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
                l.moveTo(77.0f, 71.0f);
                l.lineTo(53.0f, 76.0f);
                l.lineTo(53.0f, 26.0f);
                l.lineTo(77.0f, 21.0f);
                l.lineTo(77.0f, 71.0f);
                l.close();
                l.moveTo(20.0f, 21.0f);
                l.lineTo(44.0f, 26.0f);
                l.lineTo(44.0f, 76.0f);
                l.lineTo(20.0f, 71.0f);
                l.lineTo(20.0f, 21.0f);
                l.close();
                l.moveTo(85.0f, 18.0f);
                l.cubicTo(85.0f, 14.723531f, 82.27647f, 12.0f, 79.0f, 12.0f);
                l.cubicTo(78.840515f, 12.0f, 78.76661f, 12.008562f, 79.0f, 12.0f);
                l.lineTo(79.0f, 12.0f);
                l.lineTo(79.0f, 12.0f);
                l.cubicTo(77.96046f, 12.0468645f, 77.32959f, 12.18205f, 77.0f, 12.0f);
                l.lineTo(49.0f, 18.0f);
                l.lineTo(20.0f, 12.0f);
                l.cubicTo(19.670408f, 12.18205f, 19.039543f, 12.0468645f, 18.0f, 12.0f);
                l.lineTo(18.0f, 12.0f);
                l.lineTo(18.0f, 12.0f);
                l.cubicTo(18.233389f, 12.008562f, 18.159487f, 12.0f, 18.0f, 12.0f);
                l.cubicTo(14.723531f, 12.0f, 12.0f, 14.723531f, 12.0f, 18.0f);
                l.cubicTo(12.0f, 18.159487f, 12.008562f, 18.233389f, 12.0f, 18.0f);
                l.lineTo(12.0f, 18.0f);
                l.lineTo(12.0f, 72.0f);
                l.lineTo(12.0f, 72.0f);
                l.cubicTo(12.008562f, 72.45797f, 12.0f, 72.53187f, 12.0f, 73.0f);
                l.cubicTo(12.0f, 75.96783f, 14.723531f, 78.69136f, 18.0f, 79.0f);
                l.cubicTo(18.159487f, 78.69136f, 18.233389f, 78.68279f, 18.0f, 79.0f);
                l.lineTo(18.0f, 79.0f);
                l.lineTo(49.0f, 85.0f);
                l.lineTo(79.0f, 79.0f);
                l.lineTo(79.0f, 79.0f);
                l.cubicTo(78.76661f, 78.68279f, 78.840515f, 78.69136f, 79.0f, 79.0f);
                l.cubicTo(82.27647f, 78.69136f, 85.0f, 75.96783f, 85.0f, 73.0f);
                l.cubicTo(85.0f, 72.53187f, 84.99144f, 72.45797f, 85.0f, 72.0f);
                l.lineTo(85.0f, 72.0f);
                l.lineTo(85.0f, 18.0f);
                l.lineTo(85.0f, 18.0f);
                l.cubicTo(84.99144f, 18.233389f, 85.0f, 18.159487f, 85.0f, 18.0f);
                l.lineTo(85.0f, 18.0f);
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
