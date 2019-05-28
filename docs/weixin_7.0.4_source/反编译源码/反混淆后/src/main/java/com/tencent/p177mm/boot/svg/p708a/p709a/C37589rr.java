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

/* renamed from: com.tencent.mm.boot.svg.a.a.rr */
public final class C37589rr extends C5163c {
    private final int height = 36;
    private final int width = 36;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                k.setColor(-855310);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.81802f, 18.0f);
                l.lineTo(8.454059f, 24.36396f);
                l.lineTo(11.636039f, 27.545942f);
                l.lineTo(18.0f, 21.18198f);
                l.lineTo(24.36396f, 27.545942f);
                l.lineTo(27.545942f, 24.36396f);
                l.lineTo(21.18198f, 18.0f);
                l.lineTo(27.545942f, 11.636039f);
                l.lineTo(24.36396f, 8.454059f);
                l.lineTo(18.0f, 14.81802f);
                l.lineTo(11.636039f, 8.454059f);
                l.lineTo(8.454059f, 11.636039f);
                l.lineTo(14.81802f, 18.0f);
                l.close();
                l.moveTo(18.0f, 36.0f);
                l.cubicTo(8.058874f, 36.0f, 0.0f, 27.941126f, 0.0f, 18.0f);
                l.cubicTo(0.0f, 8.058874f, 8.058874f, 0.0f, 18.0f, 0.0f);
                l.cubicTo(27.941126f, 0.0f, 36.0f, 8.058874f, 36.0f, 18.0f);
                l.cubicTo(36.0f, 27.941126f, 27.941126f, 36.0f, 18.0f, 36.0f);
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
