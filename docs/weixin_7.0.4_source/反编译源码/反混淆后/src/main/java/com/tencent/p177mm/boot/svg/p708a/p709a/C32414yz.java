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

/* renamed from: com.tencent.mm.boot.svg.a.a.yz */
public final class C32414yz extends C5163c {
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
                l.moveTo(61.5f, 42.408176f);
                l.lineTo(61.5f, 16.5f);
                l.lineTo(10.5f, 16.5f);
                l.lineTo(10.5f, 41.548817f);
                l.lineTo(24.597736f, 30.147776f);
                l.cubicTo(25.985397f, 29.025555f, 28.213877f, 29.07998f, 29.551487f, 30.25525f);
                l.lineTo(42.98077f, 42.05468f);
                l.lineTo(49.82731f, 36.232494f);
                l.cubicTo(51.21395f, 35.053314f, 53.42017f, 35.077267f, 54.766293f, 36.28525f);
                l.lineTo(61.5f, 42.408176f);
                l.close();
                l.moveTo(8.9754095f, 12.0f);
                l.lineTo(63.02459f, 12.0f);
                l.cubicTo(64.63409f, 12.0f, 66.0f, 13.443411f, 66.0f, 15.2239485f);
                l.lineTo(66.0f, 56.77605f);
                l.cubicTo(66.0f, 58.563454f, 64.66786f, 60.0f, 63.02459f, 60.0f);
                l.lineTo(8.9754095f, 60.0f);
                l.cubicTo(7.3659167f, 60.0f, 6.0f, 58.556587f, 6.0f, 56.77605f);
                l.lineTo(6.0f, 15.2239485f);
                l.cubicTo(6.0f, 13.436544f, 7.332136f, 12.0f, 8.9754095f, 12.0f);
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
