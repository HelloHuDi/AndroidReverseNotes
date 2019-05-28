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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbf */
public final class bbf extends C5163c {
    private final int height = 16;
    private final int width = 12;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 12;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -202.0f, 0.0f, 1.0f, -603.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 133.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.9f, 2.4f);
                l.lineTo(3.9f, 15.6f);
                l.lineTo(14.1f, 15.6f);
                l.lineTo(14.1f, 2.4f);
                l.lineTo(3.9f, 2.4f);
                l.close();
                l.moveTo(3.0f, 2.25f);
                l.cubicTo(3.0f, 1.8357865f, 3.3357863f, 1.5f, 3.75f, 1.5f);
                l.lineTo(14.25f, 1.5f);
                l.cubicTo(14.664213f, 1.5f, 15.0f, 1.8357865f, 15.0f, 2.25f);
                l.lineTo(15.0f, 15.75f);
                l.cubicTo(15.0f, 16.164213f, 14.664213f, 16.5f, 14.25f, 16.5f);
                l.lineTo(3.75f, 16.5f);
                l.cubicTo(3.3357863f, 16.5f, 3.0f, 16.164213f, 3.0f, 15.75f);
                l.lineTo(3.0f, 2.25f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(6.375f, 3.75f);
                l.cubicTo(6.9963202f, 3.75f, 7.5f, 4.2536798f, 7.5f, 4.875f);
                l.cubicTo(7.5f, 5.4963202f, 6.9963202f, 6.0f, 6.375f, 6.0f);
                l.cubicTo(5.7536798f, 6.0f, 5.25f, 5.4963202f, 5.25f, 4.875f);
                l.cubicTo(5.25f, 4.2536798f, 5.7536798f, 3.75f, 6.375f, 3.75f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(5.25f, 7.5f);
                l2.lineTo(10.875f, 7.5f);
                l2.lineTo(10.875f, 8.5f);
                l2.lineTo(5.25f, 8.5f);
                l2.lineTo(5.25f, 7.5f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(5.25f, 9.75f);
                l2.lineTo(8.25f, 9.75f);
                l2.lineTo(8.25f, 10.75f);
                l2.lineTo(5.25f, 10.75f);
                l2.lineTo(5.25f, 9.75f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(5.25f, 12.0f);
                l2.lineTo(8.25f, 12.0f);
                l2.lineTo(8.25f, 13.0f);
                l2.lineTo(5.25f, 13.0f);
                l2.lineTo(5.25f, 12.0f);
                l2.close();
                canvas.drawPath(l2, a3);
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
