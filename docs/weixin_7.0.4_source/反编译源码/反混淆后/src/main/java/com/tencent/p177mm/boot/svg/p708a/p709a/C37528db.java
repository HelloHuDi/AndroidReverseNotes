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

/* renamed from: com.tencent.mm.boot.svg.a.a.db */
public final class C37528db extends C5163c {
    private final int height = 61;
    private final int width = 68;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 61;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -296.0f, 0.0f, 1.0f, -485.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 295.0f, 0.0f, 1.0f, 485.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(53.0f, 31.0f);
                l.lineTo(59.0f, 31.0f);
                l.lineTo(38.0f, 9.956522f);
                l.lineTo(36.0f, 8.043478f);
                l.lineTo(12.0f, 31.0f);
                l.lineTo(17.0f, 31.0f);
                l.lineTo(17.0f, 55.04348f);
                l.lineTo(53.0f, 55.04348f);
                l.lineTo(53.0f, 31.0f);
                l.close();
                l.moveTo(59.0f, 37.0f);
                l.lineTo(59.0f, 59.001785f);
                l.cubicTo(59.0f, 60.10537f, 58.10506f, 61.0f, 56.99861f, 61.0f);
                l.lineTo(13.0013895f, 61.0f);
                l.cubicTo(11.896052f, 61.0f, 11.0f, 60.105663f, 11.0f, 59.001785f);
                l.lineTo(11.0f, 37.0f);
                l.lineTo(3.993048f, 37.0f);
                l.cubicTo(0.68317896f, 37.0f, -0.102572955f, 35.102573f, 2.2484722f, 32.75153f);
                l.lineTo(33.17487f, 1.825131f);
                l.cubicTo(34.735146f, 0.26485425f, 37.228786f, 0.29705298f, 38.750225f, 1.9030144f);
                l.lineTo(67.870346f, 32.640915f);
                l.cubicTo(70.15109f, 35.04837f, 69.322586f, 37.0f, 66.00695f, 37.0f);
                l.lineTo(59.0f, 37.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(40.0f, 42.0f);
                l2.lineTo(40.0f, 58.0f);
                l2.lineTo(30.0f, 58.0f);
                l2.lineTo(30.0f, 42.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
