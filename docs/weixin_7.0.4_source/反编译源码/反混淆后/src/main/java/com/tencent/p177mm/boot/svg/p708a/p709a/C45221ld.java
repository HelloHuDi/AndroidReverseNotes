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

/* renamed from: com.tencent.mm.boot.svg.a.a.ld */
public final class C45221ld extends C5163c {
    private final int height = 50;
    private final int width = 47;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 47;
            case 1:
                return 50;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-3355444);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(25.0f, 0.0f);
                l.cubicTo(32.22f, 3.53f, 39.56f, 5.91f, 47.0f, 8.0f);
                l.lineTo(47.0f, 17.0f);
                l.cubicTo(45.57f, 25.23f, 44.335155f, 42.1625f, 23.5f, 50.0f);
                l.cubicTo(2.3484375f, 42.671486f, 1.27f, 23.62f, 0.0f, 16.0f);
                l.lineTo(0.0f, 8.0f);
                l.cubicTo(7.48f, 5.95f, 14.89f, 3.62f, 22.0f, 0.0f);
                l.lineTo(25.0f, 0.0f);
                l.close();
                l.moveTo(13.723477f, 35.03351f);
                l.cubicTo(15.033922f, 34.624176f, 18.0f, 33.0f, 18.0f, 33.0f);
                l.cubicTo(18.0f, 33.0f, 21.632812f, 34.032497f, 24.0f, 33.91982f);
                l.cubicTo(29.694897f, 34.032497f, 37.07939f, 29.353098f, 37.03392f, 22.234169f);
                l.cubicTo(37.001835f, 17.474546f, 31.714815f, 12.0f, 24.0f, 12.0f);
                l.cubicTo(17.745829f, 12.0f, 11.291461f, 15.644713f, 11.042147f, 22.234169f);
                l.cubicTo(11.042147f, 26.79235f, 12.733758f, 29.797903f, 14.712788f, 31.306128f);
                l.cubicTo(14.712788f, 31.306128f, 14.148407f, 33.51768f, 13.723477f, 35.03351f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 23.0f);
                l.cubicTo(21.10457f, 23.0f, 22.0f, 22.10457f, 22.0f, 21.0f);
                l.cubicTo(22.0f, 19.89543f, 21.10457f, 19.0f, 20.0f, 19.0f);
                l.cubicTo(18.89543f, 19.0f, 18.0f, 19.89543f, 18.0f, 21.0f);
                l.cubicTo(18.0f, 22.10457f, 18.89543f, 23.0f, 20.0f, 23.0f);
                l.lineTo(20.0f, 23.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(29.0f, 23.0f);
                l.cubicTo(30.10457f, 23.0f, 31.0f, 22.10457f, 31.0f, 21.0f);
                l.cubicTo(31.0f, 19.89543f, 30.10457f, 19.0f, 29.0f, 19.0f);
                l.cubicTo(27.89543f, 19.0f, 27.0f, 19.89543f, 27.0f, 21.0f);
                l.cubicTo(27.0f, 22.10457f, 27.89543f, 23.0f, 29.0f, 23.0f);
                l.lineTo(29.0f, 23.0f);
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
