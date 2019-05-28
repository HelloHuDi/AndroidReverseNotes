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

/* renamed from: com.tencent.mm.boot.svg.a.a.gi */
public final class C18017gi extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1158579);
                Path l = C5163c.m7884l(looper);
                l.moveTo(28.12f, 0.0f);
                l.lineTo(31.27f, 0.0f);
                l.cubicTo(46.17f, 0.38f, 59.22f, 13.21f, 60.0f, 28.08f);
                l.lineTo(60.0f, 31.41f);
                l.cubicTo(59.54f, 46.48f, 46.34f, 59.63f, 31.27f, 60.0f);
                l.lineTo(28.62f, 60.0f);
                l.cubicTo(13.75f, 59.56f, 0.77f, 46.74f, 0.0f, 31.91f);
                l.lineTo(0.0f, 28.41f);
                l.cubicTo(0.57f, 13.61f, 13.35f, 0.76f, 28.12f, 0.0f);
                l.moveTo(13.33f, 25.52f);
                l.cubicTo(11.45f, 26.76f, 12.08f, 29.29f, 11.98f, 31.17f);
                l.cubicTo(11.71f, 32.93f, 12.93f, 35.04f, 14.88f, 34.94f);
                l.cubicTo(24.96f, 35.04f, 35.06f, 35.05f, 45.14f, 34.93f);
                l.cubicTo(47.09f, 35.04f, 48.25f, 32.9f, 48.02f, 31.17f);
                l.cubicTo(48.05f, 29.08f, 48.46f, 26.07f, 46.0f, 25.17f);
                l.cubicTo(36.68f, 24.75f, 27.32f, 25.15f, 17.99f, 24.97f);
                l.cubicTo(16.46f, 25.14f, 14.7f, 24.67f, 13.33f, 25.52f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(13.33f, 25.52f);
                l.cubicTo(14.7f, 24.67f, 16.46f, 25.14f, 17.99f, 24.97f);
                l.cubicTo(27.32f, 25.15f, 36.68f, 24.75f, 46.0f, 25.17f);
                l.cubicTo(48.46f, 26.07f, 48.05f, 29.08f, 48.02f, 31.17f);
                l.cubicTo(48.25f, 32.9f, 47.09f, 35.04f, 45.14f, 34.93f);
                l.cubicTo(35.06f, 35.05f, 24.96f, 35.04f, 14.88f, 34.94f);
                l.cubicTo(12.93f, 35.04f, 11.71f, 32.93f, 11.98f, 31.17f);
                l.cubicTo(12.08f, 29.29f, 11.45f, 26.76f, 13.33f, 25.52f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
