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

/* renamed from: com.tencent.mm.boot.svg.a.a.xr */
public final class C6388xr extends C5163c {
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
                a.setColor(-4187622);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 1.0f);
                l.cubicTo(29.125349f, -1.4006271f, 38.745907f, 1.5796907f, 45.0f, 8.0f);
                l.cubicTo(51.066624f, 14.551074f, 53.526768f, 24.332117f, 51.0f, 33.0f);
                l.cubicTo(48.626484f, 42.064007f, 40.82603f, 49.454796f, 32.0f, 51.0f);
                l.cubicTo(22.374956f, 53.495228f, 12.184362f, 50.06486f, 6.0f, 43.0f);
                l.cubicTo(0.45367983f, 36.153378f, -1.5164348f, 26.532352f, 1.0f, 18.0f);
                l.cubicTo(3.8838794f, 9.480534f, 11.474321f, 2.50979f, 20.0f, 1.0f);
                l.lineTo(20.0f, 1.0f);
                l.close();
                l.moveTo(24.0f, 11.0f);
                l.lineTo(24.0f, 34.0f);
                l.lineTo(28.0f, 34.0f);
                l.lineTo(28.0f, 11.0f);
                l.lineTo(24.0f, 11.0f);
                l.lineTo(24.0f, 11.0f);
                l.close();
                l.moveTo(24.0f, 37.0f);
                l.lineTo(24.0f, 41.0f);
                l.cubicTo(25.330078f, 41.000427f, 26.670155f, 41.000427f, 28.0f, 41.0f);
                l.cubicTo(28.000233f, 39.670284f, 28.000233f, 38.330143f, 28.0f, 37.0f);
                l.lineTo(24.0f, 37.0f);
                l.lineTo(24.0f, 37.0f);
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
