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

/* renamed from: com.tencent.mm.boot.svg.a.a.pj */
public final class C41853pj extends C5163c {
    private final int height = 292;
    private final int width = 378;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return 292;
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
                a.setColor(-13092808);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 81.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(213.0f, 273.9996f);
                l.cubicTo(213.0f, 280.0646f, 208.063f, 284.9996f, 201.994f, 284.9996f);
                l.lineTo(14.006f, 284.9996f);
                l.cubicTo(7.937f, 284.9996f, 3.0f, 280.0646f, 3.0f, 273.9996f);
                l.lineTo(3.0f, 13.9996f);
                l.cubicTo(3.0f, 7.9346f, 7.937f, 2.9996f, 14.006f, 2.9996f);
                l.lineTo(201.994f, 2.9996f);
                l.cubicTo(208.063f, 2.9996f, 213.0f, 7.9346f, 213.0f, 13.9996f);
                l.lineTo(213.0f, 273.9996f);
                l.close();
                l.moveTo(216.0f, 14.0006f);
                l.cubicTo(216.0f, 6.2666f, 209.729f, -4.0E-4f, 201.994f, -4.0E-4f);
                l.lineTo(14.006f, -4.0E-4f);
                l.cubicTo(6.26f, -4.0E-4f, 0.0f, 6.2686f, 0.0f, 14.0006f);
                l.lineTo(0.0f, 273.9996f);
                l.cubicTo(0.0f, 281.7336f, 6.271f, 287.9996f, 14.006f, 287.9996f);
                l.lineTo(201.994f, 287.9996f);
                l.cubicTo(209.74f, 287.9996f, 216.0f, 281.7316f, 216.0f, 273.9996f);
                l.lineTo(216.0f, 14.0006f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(14.0f, 256.0f);
                l2.lineTo(201.0f, 256.0f);
                l2.lineTo(201.0f, 30.0f);
                l2.lineTo(14.0f, 30.0f);
                l2.lineTo(14.0f, 256.0f);
                l2.close();
                l2.moveTo(13.0f, 257.0f);
                l2.lineTo(202.0f, 257.0f);
                l2.lineTo(202.0f, 29.0f);
                l2.lineTo(13.0f, 29.0f);
                l2.lineTo(13.0f, 257.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(108.5f, 278.4996f);
                l.cubicTo(104.641f, 278.4996f, 101.5f, 275.3586f, 101.5f, 271.4996f);
                l.cubicTo(101.5f, 267.6406f, 104.641f, 264.4996f, 108.5f, 264.4996f);
                l.cubicTo(112.359f, 264.4996f, 115.5f, 267.6406f, 115.5f, 271.4996f);
                l.cubicTo(115.5f, 275.3586f, 112.359f, 278.4996f, 108.5f, 278.4996f);
                l.moveTo(108.5f, 263.4996f);
                l.cubicTo(104.089f, 263.4996f, 100.5f, 267.0886f, 100.5f, 271.4996f);
                l.cubicTo(100.5f, 275.9106f, 104.089f, 279.4996f, 108.5f, 279.4996f);
                l.cubicTo(112.911f, 279.4996f, 116.5f, 275.9106f, 116.5f, 271.4996f);
                l.cubicTo(116.5f, 267.0886f, 112.911f, 263.4996f, 108.5f, 263.4996f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(108.0f, 12.5001f);
                l.cubicTo(109.379f, 12.5001f, 110.5f, 13.6221f, 110.5f, 15.0001f);
                l.cubicTo(110.5f, 16.3781f, 109.379f, 17.5001f, 108.0f, 17.5001f);
                l.cubicTo(106.621f, 17.5001f, 105.5f, 16.3781f, 105.5f, 15.0001f);
                l.cubicTo(105.5f, 13.6221f, 106.621f, 12.5001f, 108.0f, 12.5001f);
                l.moveTo(108.0f, 18.5001f);
                l.cubicTo(109.93f, 18.5001f, 111.5f, 16.9301f, 111.5f, 15.0001f);
                l.cubicTo(111.5f, 13.0701f, 109.93f, 11.5001f, 108.0f, 11.5001f);
                l.cubicTo(106.07f, 11.5001f, 104.5f, 13.0701f, 104.5f, 15.0001f);
                l.cubicTo(104.5f, 16.9301f, 106.07f, 18.5001f, 108.0f, 18.5001f);
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
