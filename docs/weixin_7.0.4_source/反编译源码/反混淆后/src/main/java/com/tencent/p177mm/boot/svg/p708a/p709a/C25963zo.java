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

/* renamed from: com.tencent.mm.boot.svg.a.a.zo */
public final class C25963zo extends C5163c {
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
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(7.5f, 15.0f);
                l.lineTo(46.5f, 15.0f);
                l.lineTo(7.5f, 15.0f);
                l.close();
                l.moveTo(46.235294f, 19.500006f);
                l.lineTo(43.832214f, 60.352333f);
                l.cubicTo(43.645664f, 63.52371f, 41.01943f, 66.0f, 37.84257f, 66.0f);
                l.lineTo(16.15743f, 66.0f);
                l.cubicTo(12.980573f, 66.0f, 10.354336f, 63.52371f, 10.167784f, 60.352333f);
                l.lineTo(7.764706f, 19.500006f);
                l.lineTo(46.235294f, 19.500006f);
                l.close();
                l.moveTo(18.0f, 26.999945f);
                l.lineTo(19.5f, 53.99998f);
                l.lineTo(24.0f, 53.99998f);
                l.lineTo(22.800001f, 26.999945f);
                l.lineTo(18.0f, 26.999945f);
                l.close();
                l.moveTo(31.5f, 26.999945f);
                l.lineTo(30.0f, 53.99998f);
                l.lineTo(34.5f, 53.99998f);
                l.lineTo(36.0f, 26.999945f);
                l.lineTo(31.5f, 26.999945f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(a2, 0.9848077f, -0.17364818f, 2.2268772f, 0.17364818f, 0.9848077f, -4.7796535f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(4.429283f, 11.836774f);
                l.lineTo(52.429283f, 11.836774f);
                l.cubicTo(53.25771f, 11.836774f, 53.929283f, 12.508347f, 53.929283f, 13.336774f);
                l.lineTo(53.929283f, 16.33678f);
                l.lineTo(2.9292831f, 16.33678f);
                l.lineTo(2.9292831f, 13.336774f);
                l.cubicTo(2.9292831f, 12.508347f, 3.6008558f, 11.836774f, 4.429283f, 11.836774f);
                l.close();
                l.moveTo(22.429283f, 4.336876f);
                l.lineTo(34.429283f, 4.336876f);
                l.cubicTo(35.25771f, 4.336876f, 35.929283f, 5.0084486f, 35.929283f, 5.836876f);
                l.lineTo(35.929283f, 8.836774f);
                l.lineTo(20.929283f, 8.836774f);
                l.lineTo(20.929283f, 5.836876f);
                l.cubicTo(20.929283f, 5.0084486f, 21.600857f, 4.336876f, 22.429283f, 4.336876f);
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
