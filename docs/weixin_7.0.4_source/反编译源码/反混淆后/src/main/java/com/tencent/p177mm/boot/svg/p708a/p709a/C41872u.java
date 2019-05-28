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

/* renamed from: com.tencent.mm.boot.svg.a.a.u */
public final class C41872u extends C5163c {
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
                l.moveTo(18.0f, 37.5f);
                l.cubicTo(18.0f, 39.9849f, 15.9849f, 42.0f, 13.5f, 42.0f);
                l.cubicTo(11.0151f, 42.0f, 9.0f, 39.9849f, 9.0f, 37.5f);
                l.cubicTo(9.0f, 35.0142f, 11.0151f, 33.0f, 13.5f, 33.0f);
                l.cubicTo(15.9849f, 33.0f, 18.0f, 35.0142f, 18.0f, 37.5f);
                l.close();
                l.moveTo(34.5f, 33.0f);
                l.cubicTo(36.9849f, 33.0f, 39.0f, 35.0142f, 39.0f, 37.5f);
                l.cubicTo(39.0f, 39.9849f, 36.9849f, 42.0f, 34.5f, 42.0f);
                l.cubicTo(32.0151f, 42.0f, 30.0f, 39.9849f, 30.0f, 37.5f);
                l.cubicTo(30.0f, 35.0142f, 32.0151f, 33.0f, 34.5f, 33.0f);
                l.close();
                l.moveTo(55.5f, 33.0f);
                l.cubicTo(57.9849f, 33.0f, 60.0f, 35.0142f, 60.0f, 37.5f);
                l.cubicTo(60.0f, 39.9849f, 57.9849f, 42.0f, 55.5f, 42.0f);
                l.cubicTo(53.0151f, 42.0f, 51.0f, 39.9849f, 51.0f, 37.5f);
                l.cubicTo(51.0f, 35.0142f, 53.0151f, 33.0f, 55.5f, 33.0f);
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
