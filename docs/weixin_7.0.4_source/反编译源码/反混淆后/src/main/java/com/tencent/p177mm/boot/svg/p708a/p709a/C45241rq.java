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

/* renamed from: com.tencent.mm.boot.svg.a.a.rq */
public final class C45241rq extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1686720);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 10.5f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(13.207434f, 22.39999f);
                l.lineTo(16.05067f, 70.166374f);
                l.cubicTo(16.138716f, 71.64553f, 17.363943f, 72.8f, 18.845724f, 72.8f);
                l.lineTo(44.154278f, 72.8f);
                l.cubicTo(45.636055f, 72.8f, 46.861286f, 71.64553f, 46.94933f, 70.166374f);
                l.lineTo(49.792564f, 22.39999f);
                l.lineTo(13.207434f, 22.39999f);
                l.close();
                l.moveTo(8.75f, 18.19999f);
                l.lineTo(54.25f, 18.19999f);
                l.lineTo(51.14191f, 70.41593f);
                l.cubicTo(50.921795f, 74.11384f, 47.858727f, 77.0f, 44.154278f, 77.0f);
                l.lineTo(18.845724f, 77.0f);
                l.cubicTo(15.141274f, 77.0f, 12.078204f, 74.11384f, 11.858091f, 70.41593f);
                l.lineTo(8.75f, 18.19999f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(a2, 0.98162717f, -0.190809f, 3.6336305f, 0.190809f, 0.98162717f, 0.028710395f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(3.5f, 7.6999893f);
                l.lineTo(59.5f, 7.6999893f);
                l.cubicTo(60.4665f, 7.6999893f, 61.25f, 8.483491f, 61.25f, 9.449989f);
                l.lineTo(61.25f, 11.899989f);
                l.lineTo(1.75f, 11.899989f);
                l.lineTo(1.75f, 9.449989f);
                l.cubicTo(1.75f, 8.483491f, 2.5335016f, 7.6999893f, 3.5f, 7.6999893f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(38.5f, 9.549949E-5f);
                l.cubicTo(39.4665f, 9.549949E-5f, 40.25f, 0.7835972f, 40.25f, 1.7500955f);
                l.lineTo(40.25f, 4.2000847f);
                l.lineTo(22.75f, 4.2000847f);
                l.lineTo(22.75f, 1.7500955f);
                l.cubicTo(22.75f, 0.7835972f, 23.533503f, 9.549949E-5f, 24.5f, 9.549949E-5f);
                l.lineTo(38.5f, 9.549949E-5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint a5 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(22.75f, 31.5f);
                l2.lineTo(26.950043f, 31.5f);
                l2.lineTo(28.700043f, 63.0f);
                l2.lineTo(24.5f, 63.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a5);
                canvas.restore();
                canvas.save();
                a5 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(36.049957f, 31.5f);
                l2.lineTo(40.25f, 31.5f);
                l2.lineTo(38.5f, 63.0f);
                l2.lineTo(34.299957f, 63.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
