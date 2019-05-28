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

/* renamed from: com.tencent.mm.boot.svg.a.a.oz */
public final class C37578oz extends C5163c {
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
                canvas.saveLayerAlpha(null, 128, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 80.0f);
                l.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                l.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                l.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                l.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-11711155);
                l = C5163c.m7884l(looper);
                l.moveTo(63.284435f, 77.0f);
                l.lineTo(89.0f, 104.0f);
                l.lineTo(58.0f, 104.0f);
                l.cubicTo(60.590897f, 100.16911f, 63.478912f, 93.10176f, 62.938694f, 80.91711f);
                l.cubicTo(63.001358f, 79.552414f, 63.116966f, 78.244446f, 63.284435f, 77.0f);
                l.moveTo(60.032513f, 81.31762f);
                l.cubicTo(60.91131f, 99.65149f, 53.0f, 104.66564f, 53.0f, 104.66564f);
                l.lineTo(53.0f, 107.0f);
                l.lineTo(97.0f, 107.0f);
                l.lineTo(61.79871f, 71.0f);
                l.cubicTo(60.848923f, 73.81619f, 60.213223f, 77.21763f, 60.032513f, 81.31762f);
                l.close();
                l.moveTo(84.02051f, 58.95267f);
                l.lineTo(84.02051f, 57.067513f);
                l.cubicTo(84.02051f, 54.063652f, 81.875374f, 52.031452f, 78.88457f, 52.031452f);
                l.cubicTo(75.90136f, 52.031452f, 74.00952f, 54.103878f, 74.00952f, 57.096867f);
                l.lineTo(74.00952f, 58.95267f);
                l.cubicTo(71.48619f, 59.716953f, 68.18386f, 61.1031f, 65.88232f, 63.578594f);
                l.lineTo(53.30372f, 51.0f);
                l.lineTo(51.0f, 53.30372f);
                l.lineTo(108.69628f, 111.0f);
                l.lineTo(111.0f, 108.69628f);
                l.lineTo(100.0663f, 97.76258f);
                l.cubicTo(98.537735f, 94.18687f, 97.3201f, 88.87494f, 97.69735f, 81.20276f);
                l.cubicTo(97.02982f, 66.39329f, 90.03693f, 60.812824f, 84.02051f, 58.95267f);
                l.close();
                l.moveTo(68.19256f, 66.0466f);
                l.lineTo(68.270584f, 65.963394f);
                l.cubicTo(69.93996f, 64.19877f, 71.999466f, 62.94311f, 74.38978f, 62.230995f);
                l.lineTo(76.99048f, 61.549137f);
                l.lineTo(76.99048f, 59.14372f);
                l.lineTo(76.99048f, 57.299133f);
                l.cubicTo(76.99048f, 56.115875f, 77.7955f, 54.989075f, 78.99451f, 54.989075f);
                l.cubicTo(80.19461f, 54.989075f, 81.000916f, 56.115875f, 81.000916f, 57.299133f);
                l.lineTo(81.000916f, 59.15777f);
                l.lineTo(81.000916f, 61.549137f);
                l.lineTo(83.40482f, 62.25477f);
                l.cubicTo(86.330345f, 63.144104f, 88.738235f, 64.84173f, 90.56147f, 67.300095f);
                l.cubicTo(93.02761f, 70.62295f, 94.42553f, 75.32356f, 94.71676f, 81.27227f);
                l.cubicTo(94.51565f, 85.521194f, 94.77281f, 89.40163f, 95.48276f, 92.88008f);
                l.lineTo(68.19256f, 66.0466f);
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
