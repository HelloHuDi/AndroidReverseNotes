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

/* renamed from: com.tencent.mm.boot.svg.a.a.ik */
public final class C37548ik extends C5163c {
    private final int height = 69;
    private final int width = 69;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                k.setColor(-1);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(41.076107f, 39.0f);
                l.lineTo(41.075874f, 39.00171f);
                l.lineTo(26.999348f, 38.992485f);
                l.cubicTo(26.693531f, 38.992287f, 26.404617f, 38.85216f, 26.21512f, 38.612133f);
                l.cubicTo(25.8729f, 38.178654f, 25.94688f, 37.549824f, 26.380358f, 37.207603f);
                l.lineTo(41.176712f, 25.526272f);
                l.cubicTo(41.389874f, 25.357986f, 41.66231f, 25.283638f, 41.931408f, 25.320316f);
                l.cubicTo(42.478634f, 25.394903f, 42.861782f, 25.898981f, 42.787193f, 26.446207f);
                l.lineTo(41.62131f, 35.0f);
                l.lineTo(59.995052f, 35.0f);
                l.cubicTo(61.102356f, 35.0f, 62.0f, 35.88773f, 62.0f, 37.0f);
                l.cubicTo(62.0f, 38.10457f, 61.102974f, 39.0f, 59.995052f, 39.0f);
                l.lineTo(41.076107f, 39.0f);
                l.close();
                l.moveTo(48.25757f, 43.016853f);
                l.lineTo(58.78785f, 43.02375f);
                l.cubicTo(59.093666f, 43.023952f, 59.382576f, 43.164078f, 59.572075f, 43.404106f);
                l.cubicTo(59.914295f, 43.837585f, 59.840317f, 44.466415f, 59.406837f, 44.808636f);
                l.lineTo(44.61048f, 56.489967f);
                l.cubicTo(44.39732f, 56.658253f, 44.12488f, 56.7326f, 43.855785f, 56.695923f);
                l.cubicTo(43.308563f, 56.621334f, 42.92541f, 56.117256f, 43.0f, 55.57003f);
                l.lineTo(44.1681f, 47.0f);
                l.lineTo(28.004946f, 47.0f);
                l.cubicTo(26.897646f, 47.0f, 26.0f, 46.11227f, 26.0f, 45.0f);
                l.cubicTo(26.0f, 43.89543f, 26.897026f, 43.0f, 28.004946f, 43.0f);
                l.lineTo(47.995052f, 43.0f);
                l.cubicTo(48.08403f, 43.0f, 48.171654f, 43.005733f, 48.25757f, 43.016853f);
                l.close();
                l.moveTo(57.0f, 31.0f);
                l.lineTo(53.0f, 31.0f);
                l.lineTo(53.0f, 18.0f);
                l.lineTo(13.0f, 18.0f);
                l.lineTo(13.0f, 50.0f);
                l.lineTo(37.96f, 50.0f);
                l.lineTo(37.32f, 54.0f);
                l.lineTo(12.0f, 54.0f);
                l.cubicTo(10.343145f, 54.0f, 9.0f, 52.656853f, 9.0f, 51.0f);
                l.lineTo(9.0f, 17.0f);
                l.lineTo(9.0f, 17.0f);
                l.cubicTo(9.0f, 15.343145f, 10.343145f, 14.0f, 12.0f, 14.0f);
                l.lineTo(12.0f, 14.0f);
                l.lineTo(54.0f, 14.0f);
                l.cubicTo(55.656853f, 14.0f, 57.0f, 15.343145f, 57.0f, 17.0f);
                l.lineTo(57.0f, 31.0f);
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
