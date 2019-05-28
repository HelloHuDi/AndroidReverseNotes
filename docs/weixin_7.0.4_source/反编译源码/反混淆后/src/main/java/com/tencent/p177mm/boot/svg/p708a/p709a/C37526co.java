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

/* renamed from: com.tencent.mm.boot.svg.a.a.co */
public final class C37526co extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1710619);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.lineTo(68.0f, 87.0f);
                l.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                l.lineTo(3.0f, 90.0f);
                l.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(46.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-2434342);
                l = C5163c.m7884l(looper);
                l.moveTo(68.0f, 22.0f);
                l.lineTo(49.0f, 22.0f);
                l.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                l.lineTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-5723992);
                l = C5163c.m7884l(looper);
                l.moveTo(26.177734f, 50.26172f);
                l.cubicTo(26.371094f, 46.464844f, 28.902344f, 43.441406f, 33.841797f, 43.441406f);
                l.cubicTo(38.271484f, 43.441406f, 41.29492f, 46.183594f, 41.29492f, 49.804688f);
                l.cubicTo(41.29492f, 52.564453f, 39.871094f, 54.515625f, 37.621094f, 55.86914f);
                l.cubicTo(35.38867f, 57.1875f, 34.75586f, 58.171875f, 34.75586f, 60.01758f);
                l.lineTo(34.75586f, 61.160156f);
                l.lineTo(31.679688f, 61.160156f);
                l.lineTo(31.679688f, 59.54297f);
                l.cubicTo(31.66211f, 57.222656f, 32.78711f, 55.640625f, 35.195312f, 54.19922f);
                l.cubicTo(37.234375f, 52.95117f, 38.02539f, 51.84375f, 38.02539f, 49.96289f);
                l.cubicTo(38.02539f, 47.783203f, 36.33789f, 46.183594f, 33.71875f, 46.183594f);
                l.cubicTo(31.064453f, 46.183594f, 29.376953f, 47.748047f, 29.183594f, 50.26172f);
                l.lineTo(26.177734f, 50.26172f);
                l.close();
                l.moveTo(33.226562f, 69.17578f);
                l.cubicTo(32.101562f, 69.17578f, 31.222656f, 68.296875f, 31.222656f, 67.171875f);
                l.cubicTo(31.222656f, 66.0293f, 32.101562f, 65.16797f, 33.226562f, 65.16797f);
                l.cubicTo(34.36914f, 65.16797f, 35.23047f, 66.0293f, 35.23047f, 67.171875f);
                l.cubicTo(35.23047f, 68.296875f, 34.36914f, 69.17578f, 33.226562f, 69.17578f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
