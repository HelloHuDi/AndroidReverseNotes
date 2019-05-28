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

/* renamed from: com.tencent.mm.boot.svg.a.a.aaa */
public final class aaa extends C5163c {
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(42.0f, 9.0f);
                l.lineTo(42.0f, 15.0f);
                l.lineTo(15.0f, 15.0f);
                l.lineTo(15.0f, 57.0f);
                l.lineTo(57.0f, 57.0f);
                l.lineTo(57.0f, 30.0f);
                l.lineTo(63.0f, 30.0f);
                l.lineTo(63.0f, 60.0f);
                l.cubicTo(63.0f, 61.656853f, 61.656853f, 63.0f, 60.0f, 63.0f);
                l.lineTo(12.0f, 63.0f);
                l.cubicTo(10.343145f, 63.0f, 9.0f, 61.656853f, 9.0f, 60.0f);
                l.lineTo(9.0f, 12.0f);
                l.cubicTo(9.0f, 10.343145f, 10.343145f, 9.0f, 12.0f, 9.0f);
                l.lineTo(42.0f, 9.0f);
                l.close();
                l.moveTo(59.8211f, 10.06066f);
                l.lineTo(61.94242f, 12.18198f);
                l.cubicTo(62.528206f, 12.767767f, 62.528206f, 13.717514f, 61.94242f, 14.303301f);
                l.lineTo(33.94283f, 42.302895f);
                l.lineTo(27.965082f, 45.2428f);
                l.cubicTo(27.51905f, 45.462166f, 26.979641f, 45.27841f, 26.760279f, 44.832382f);
                l.cubicTo(26.637094f, 44.581913f, 26.637094f, 44.288467f, 26.760279f, 44.038f);
                l.lineTo(29.700188f, 38.060253f);
                l.lineTo(57.69978f, 10.06066f);
                l.cubicTo(58.285564f, 9.474874f, 59.235313f, 9.474874f, 59.8211f, 10.06066f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
