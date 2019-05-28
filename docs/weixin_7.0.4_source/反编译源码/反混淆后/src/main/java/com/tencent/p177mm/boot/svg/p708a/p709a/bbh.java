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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbh */
public final class bbh extends C5163c {
    private final int height = 16;
    private final int width = 16;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-5066062);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -72.0f, 0.0f, 1.0f, -603.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.5f, 0.0f, 1.0f, 1.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(7.5f, 14.1f);
                l.cubicTo(11.14508f, 14.1f, 14.1f, 11.14508f, 14.1f, 7.5f);
                l.cubicTo(14.1f, 3.8549206f, 11.14508f, 0.9f, 7.5f, 0.9f);
                l.cubicTo(3.8549206f, 0.9f, 0.9f, 3.8549206f, 0.9f, 7.5f);
                l.cubicTo(0.9f, 11.14508f, 3.8549206f, 14.1f, 7.5f, 14.1f);
                l.close();
                l.moveTo(7.5f, 15.0f);
                l.cubicTo(3.3578644f, 15.0f, 0.0f, 11.642136f, 0.0f, 7.5f);
                l.cubicTo(0.0f, 3.3578644f, 3.3578644f, 0.0f, 7.5f, 0.0f);
                l.cubicTo(11.642136f, 0.0f, 15.0f, 3.3578644f, 15.0f, 7.5f);
                l.cubicTo(15.0f, 11.642136f, 11.642136f, 15.0f, 7.5f, 15.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(7.5f, 11.475f);
                l.cubicTo(9.177456f, 11.475f, 10.586946f, 10.327704f, 10.986585f, 8.775f);
                l.lineTo(4.013416f, 8.775f);
                l.cubicTo(4.4130545f, 10.327704f, 5.8225446f, 11.475f, 7.5f, 11.475f);
                l.close();
                l.moveTo(3.0f, 7.875f);
                l.lineTo(12.0f, 7.875f);
                l.cubicTo(12.0f, 10.360281f, 9.985281f, 12.375f, 7.5f, 12.375f);
                l.cubicTo(5.0147185f, 12.375f, 3.0f, 10.360281f, 3.0f, 7.875f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(4.875f, 6.375f);
                l.cubicTo(4.2536798f, 6.375f, 3.75f, 5.8713202f, 3.75f, 5.25f);
                l.cubicTo(3.75f, 4.6286798f, 4.2536798f, 4.125f, 4.875f, 4.125f);
                l.cubicTo(5.4963202f, 4.125f, 6.0f, 4.6286798f, 6.0f, 5.25f);
                l.cubicTo(6.0f, 5.8713202f, 5.4963202f, 6.375f, 4.875f, 6.375f);
                l.close();
                l.moveTo(10.125f, 6.375f);
                l.cubicTo(9.503679f, 6.375f, 9.0f, 5.8713202f, 9.0f, 5.25f);
                l.cubicTo(9.0f, 4.6286798f, 9.503679f, 4.125f, 10.125f, 4.125f);
                l.cubicTo(10.746321f, 4.125f, 11.25f, 4.6286798f, 11.25f, 5.25f);
                l.cubicTo(11.25f, 5.8713202f, 10.746321f, 6.375f, 10.125f, 6.375f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
