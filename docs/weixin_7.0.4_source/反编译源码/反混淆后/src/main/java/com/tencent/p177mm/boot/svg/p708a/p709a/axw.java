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

/* renamed from: com.tencent.mm.boot.svg.a.a.axw */
public final class axw extends C5163c {
    private final int height = 66;
    private final int width = 66;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.6f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1.8f, 27.0f);
                l.cubicTo(1.8f, 13.082423f, 13.082423f, 1.8f, 27.0f, 1.8f);
                l.lineTo(39.000004f, 1.8f);
                l.cubicTo(52.91758f, 1.8f, 64.200005f, 13.082423f, 64.200005f, 27.0f);
                l.lineTo(64.200005f, 27.0f);
                l.cubicTo(64.200005f, 40.917576f, 52.91758f, 52.2f, 39.000004f, 52.2f);
                l.lineTo(27.0f, 52.2f);
                l.cubicTo(13.082423f, 52.2f, 1.8f, 40.917576f, 1.8f, 27.0f);
                l.lineTo(1.8f, 27.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                g = C5163c.m7878a(a2, 0.70710677f, -0.70710677f, 28.757359f, 0.70710677f, 0.70710677f, -15.426407f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(31.0f, 25.0f);
                l.lineTo(31.0f, 15.0f);
                l.lineTo(35.0f, 15.0f);
                l.lineTo(35.0f, 25.0f);
                l.lineTo(45.0f, 25.0f);
                l.lineTo(45.0f, 29.0f);
                l.lineTo(35.0f, 29.0f);
                l.lineTo(35.0f, 39.0f);
                l.lineTo(31.0f, 39.0f);
                l.lineTo(31.0f, 29.0f);
                l.lineTo(21.0f, 29.0f);
                l.lineTo(21.0f, 25.0f);
                l.lineTo(31.0f, 25.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
