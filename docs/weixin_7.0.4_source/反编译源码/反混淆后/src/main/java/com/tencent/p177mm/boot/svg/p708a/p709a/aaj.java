package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aaj */
public final class aaj extends C5163c {
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
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(30.0f, 60.0f);
                l.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                l.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                l.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                l.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                l.close();
                l.moveTo(30.0f, 48.0f);
                l.cubicTo(38.607063f, 48.0f, 45.674892f, 41.40975f, 46.432735f, 33.0f);
                l.lineTo(13.567265f, 33.0f);
                l.cubicTo(14.325108f, 41.40975f, 21.392937f, 48.0f, 30.0f, 48.0f);
                l.close();
                l.moveTo(19.5f, 25.5f);
                l.cubicTo(21.985281f, 25.5f, 24.0f, 23.485281f, 24.0f, 21.0f);
                l.cubicTo(24.0f, 18.514719f, 21.985281f, 16.5f, 19.5f, 16.5f);
                l.cubicTo(17.014719f, 16.5f, 15.0f, 18.514719f, 15.0f, 21.0f);
                l.cubicTo(15.0f, 23.485281f, 17.014719f, 25.5f, 19.5f, 25.5f);
                l.close();
                l.moveTo(40.5f, 25.5f);
                l.cubicTo(42.985283f, 25.5f, 45.0f, 23.485281f, 45.0f, 21.0f);
                l.cubicTo(45.0f, 18.514719f, 42.985283f, 16.5f, 40.5f, 16.5f);
                l.cubicTo(38.014717f, 16.5f, 36.0f, 18.514719f, 36.0f, 21.0f);
                l.cubicTo(36.0f, 23.485281f, 38.014717f, 25.5f, 40.5f, 25.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
