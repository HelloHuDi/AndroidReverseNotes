package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ahn extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-14046139);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(k2, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 13.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(3.6f, 5.1f);
                l2.lineTo(3.6f, 39.9f);
                l2.lineTo(56.4f, 39.9f);
                l2.lineTo(56.4f, 5.1f);
                l2.lineTo(3.6f, 5.1f);
                l2.close();
                l2.moveTo(0.0f, 4.5f);
                l2.cubicTo(-2.0290612E-16f, 2.8431458f, 1.3431457f, 1.5f, 3.0f, 1.5f);
                l2.lineTo(57.0f, 1.5f);
                l2.cubicTo(58.656853f, 1.5f, 60.0f, 2.8431458f, 60.0f, 4.5f);
                l2.lineTo(60.0f, 40.5f);
                l2.cubicTo(60.0f, 42.156853f, 58.656853f, 43.5f, 57.0f, 43.5f);
                l2.lineTo(3.0f, 43.5f);
                l2.cubicTo(1.3431457f, 43.5f, -2.7402583E-15f, 42.156853f, 0.0f, 40.5f);
                l2.lineTo(0.0f, 4.5f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l2 = c.l(looper);
                l2.moveTo(2.5124738f, 6.5230727f);
                l2.lineTo(25.253035f, 23.99735f);
                l2.cubicTo(28.055511f, 26.150826f, 31.955736f, 26.150826f, 34.758213f, 23.99735f);
                l2.lineTo(57.498775f, 6.5230727f);
                l2.lineTo(55.30527f, 3.6685066f);
                l2.lineTo(32.56471f, 21.142784f);
                l2.cubicTo(31.055685f, 22.30235f, 28.955564f, 22.30235f, 27.446539f, 21.142784f);
                l2.lineTo(4.7059765f, 3.6685066f);
                l2.lineTo(2.5124738f, 6.5230727f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
