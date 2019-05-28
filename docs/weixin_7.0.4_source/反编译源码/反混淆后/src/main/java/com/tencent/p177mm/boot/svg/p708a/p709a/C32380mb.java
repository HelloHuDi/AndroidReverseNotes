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

/* renamed from: com.tencent.mm.boot.svg.a.a.mb */
public final class C32380mb extends C5163c {
    private final int height = 48;
    private final int width = 63;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 48;
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
                k.setColor(-5066062);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.0f, 0.0f);
                l.lineTo(61.0f, 0.0f);
                l.cubicTo(61.11f, 1.2f, 61.67f, 1.83f, 63.0f, 2.0f);
                l.lineTo(63.0f, 46.0f);
                l.cubicTo(61.8f, 46.1f, 61.18f, 46.66f, 61.0f, 48.0f);
                l.lineTo(2.0f, 48.0f);
                l.cubicTo(1.89f, 46.8f, 1.34f, 46.17f, 0.0f, 46.0f);
                l.lineTo(0.0f, 2.0f);
                l.cubicTo(1.2f, 1.9f, 1.82f, 1.34f, 2.0f, 0.0f);
                l.lineTo(2.0f, 0.0f);
                l.close();
                l.moveTo(6.0f, 6.0f);
                l.cubicTo(6.009992f, 14.688017f, 6.0399685f, 23.386019f, 6.0f, 32.0f);
                l.cubicTo(9.807014f, 26.681475f, 14.5433f, 21.658401f, 20.0f, 19.0f);
                l.cubicTo(23.536245f, 16.894972f, 26.683777f, 19.161846f, 29.0f, 21.0f);
                l.cubicTo(33.98805f, 25.31336f, 38.404583f, 30.196625f, 43.0f, 35.0f);
                l.cubicTo(41.642044f, 32.88292f, 40.32308f, 30.815771f, 39.0f, 29.0f);
                l.cubicTo(41.272335f, 26.441805f, 43.51058f, 23.286158f, 47.0f, 23.0f);
                l.cubicTo(51.614223f, 24.234848f, 54.332092f, 28.59883f, 57.0f, 32.0f);
                l.cubicTo(56.96003f, 23.425964f, 56.99001f, 14.707989f, 57.0f, 6.0f);
                l.lineTo(6.0f, 6.0f);
                l.lineTo(6.0f, 6.0f);
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
