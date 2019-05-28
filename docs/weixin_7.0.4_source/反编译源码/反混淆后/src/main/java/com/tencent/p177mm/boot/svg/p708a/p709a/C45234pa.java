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
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.pa */
public final class C45234pa extends C5163c {
    private final int height = ErrorCode.STARTDOWNLOAD_3;
    private final int width = ErrorCode.STARTDOWNLOAD_3;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ErrorCode.STARTDOWNLOAD_3;
            case 1:
                return ErrorCode.STARTDOWNLOAD_3;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 80.0f);
                l.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                l.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                l.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                l.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-16139513);
                l = C5163c.m7884l(looper);
                l.moveTo(62.284435f, 76.0f);
                l.lineTo(88.0f, 103.0f);
                l.lineTo(57.0f, 103.0f);
                l.cubicTo(59.590897f, 99.16911f, 62.478912f, 92.10176f, 61.938694f, 79.91711f);
                l.cubicTo(62.001358f, 78.552414f, 62.116966f, 77.244446f, 62.284435f, 76.0f);
                l.moveTo(59.032513f, 80.31762f);
                l.cubicTo(59.91131f, 98.65149f, 52.0f, 103.66564f, 52.0f, 103.66564f);
                l.lineTo(52.0f, 106.0f);
                l.lineTo(96.0f, 106.0f);
                l.lineTo(60.79871f, 70.0f);
                l.cubicTo(59.848923f, 72.81619f, 59.213223f, 76.21763f, 59.032513f, 80.31762f);
                l.close();
                l.moveTo(83.02051f, 57.95267f);
                l.lineTo(83.02051f, 56.067513f);
                l.cubicTo(83.02051f, 53.063652f, 80.875374f, 51.031452f, 77.88457f, 51.031452f);
                l.cubicTo(74.90136f, 51.031452f, 73.00952f, 53.103878f, 73.00952f, 56.096867f);
                l.lineTo(73.00952f, 57.95267f);
                l.cubicTo(70.48619f, 58.716953f, 67.18386f, 60.1031f, 64.88232f, 62.578594f);
                l.lineTo(52.30372f, 50.0f);
                l.lineTo(50.0f, 52.30372f);
                l.lineTo(107.69628f, 110.0f);
                l.lineTo(110.0f, 107.69628f);
                l.lineTo(99.0663f, 96.76258f);
                l.cubicTo(97.537735f, 93.18687f, 96.3201f, 87.87494f, 96.69735f, 80.20276f);
                l.cubicTo(96.02982f, 65.39329f, 89.03693f, 59.812824f, 83.02051f, 57.95267f);
                l.close();
                l.moveTo(67.19256f, 65.0466f);
                l.lineTo(67.270584f, 64.963394f);
                l.cubicTo(68.93996f, 63.198772f, 70.999466f, 61.94311f, 73.38978f, 61.230995f);
                l.lineTo(75.99048f, 60.549137f);
                l.lineTo(75.99048f, 58.14372f);
                l.lineTo(75.99048f, 56.299133f);
                l.cubicTo(75.99048f, 55.115875f, 76.7955f, 53.989075f, 77.99451f, 53.989075f);
                l.cubicTo(79.19461f, 53.989075f, 80.000916f, 55.115875f, 80.000916f, 56.299133f);
                l.lineTo(80.000916f, 58.15777f);
                l.lineTo(80.000916f, 60.549137f);
                l.lineTo(82.40482f, 61.25477f);
                l.cubicTo(85.330345f, 62.144104f, 87.738235f, 63.84173f, 89.56147f, 66.300095f);
                l.cubicTo(92.02761f, 69.62295f, 93.42553f, 74.32356f, 93.71676f, 80.27227f);
                l.cubicTo(93.51565f, 84.521194f, 93.77281f, 88.40163f, 94.48276f, 91.88008f);
                l.lineTo(67.19256f, 65.0466f);
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
