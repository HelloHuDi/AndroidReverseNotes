package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ans */
public final class ans extends C5163c {
    private final int height = C33250az.CTRL_INDEX;
    private final int width = C33250az.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C33250az.CTRL_INDEX;
            case 1:
                return C33250az.CTRL_INDEX;
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
                a.setColor(-13421773);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(78.0f, 27.0f);
                l.lineTo(78.0f, 57.0f);
                l.cubicTo(78.0f, 58.656853f, 76.65685f, 60.0f, 75.0f, 60.0f);
                l.lineTo(3.0f, 60.0f);
                l.cubicTo(1.3431457f, 60.0f, 2.0290612E-16f, 58.656853f, 0.0f, 57.0f);
                l.lineTo(0.0f, 27.0f);
                l.lineTo(-1.3322676E-15f, 3.0f);
                l.cubicTo(-1.5351737E-15f, 1.3431457f, 1.3431457f, -3.2483544E-15f, 3.0f, -3.5527137E-15f);
                l.lineTo(25.947657f, 1.0214052E-14f);
                l.cubicTo(26.628872f, 1.06939544E-14f, 27.289803f, 0.23184225f, 27.821741f, 0.6573936f);
                l.lineTo(33.678257f, 5.3426065f);
                l.cubicTo(34.210197f, 5.768158f, 34.871128f, 6.0f, 35.55234f, 6.0f);
                l.lineTo(75.0f, 6.0f);
                l.cubicTo(76.65685f, 6.0f, 78.0f, 7.343146f, 78.0f, 9.0f);
                l.lineTo(78.0f, 27.0f);
                l.close();
                l.moveTo(75.0f, 18.802692f);
                l.lineTo(75.0f, 15.0f);
                l.cubicTo(75.0f, 13.343145f, 73.65685f, 12.0f, 72.0f, 12.0f);
                l.lineTo(6.0f, 12.0f);
                l.cubicTo(4.343146f, 12.0f, 3.0f, 13.343145f, 3.0f, 15.0f);
                l.lineTo(3.0f, 18.802692f);
                l.cubicTo(3.8825202f, 18.292183f, 4.9071383f, 18.0f, 6.0f, 18.0f);
                l.lineTo(72.0f, 18.0f);
                l.cubicTo(73.092865f, 18.0f, 74.11748f, 18.292183f, 75.0f, 18.802692f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
