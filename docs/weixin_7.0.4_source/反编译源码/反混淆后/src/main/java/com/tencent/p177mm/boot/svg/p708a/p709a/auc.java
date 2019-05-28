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

/* renamed from: com.tencent.mm.boot.svg.a.a.auc */
public final class auc extends C5163c {
    private final int height = 45;
    private final int width = 45;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-9312);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 1.0f);
                l.lineTo(3.0f, 1.0f);
                l.lineTo(3.0f, 34.0f);
                l.lineTo(0.0f, 34.0f);
                l.lineTo(0.0f, 1.0f);
                l.close();
                l.moveTo(0.0f, 12.0f);
                l.lineTo(3.0f, 12.0f);
                l.lineTo(3.0f, 16.0f);
                l.lineTo(0.0f, 16.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                l.moveTo(0.0f, 20.0f);
                l.lineTo(3.0f, 20.0f);
                l.lineTo(3.0f, 24.0f);
                l.lineTo(0.0f, 24.0f);
                l.lineTo(0.0f, 20.0f);
                l.close();
                l.moveTo(36.0f, 1.0f);
                l.lineTo(39.0f, 1.0f);
                l.lineTo(39.0f, 34.0f);
                l.lineTo(36.0f, 34.0f);
                l.lineTo(36.0f, 1.0f);
                l.close();
                l.moveTo(36.0f, 20.0f);
                l.lineTo(39.0f, 20.0f);
                l.lineTo(39.0f, 24.0f);
                l.lineTo(36.0f, 24.0f);
                l.lineTo(36.0f, 20.0f);
                l.close();
                l.moveTo(36.0f, 12.0f);
                l.lineTo(39.0f, 12.0f);
                l.lineTo(39.0f, 16.0f);
                l.lineTo(36.0f, 16.0f);
                l.lineTo(36.0f, 12.0f);
                l.close();
                l.moveTo(18.0f, 29.5f);
                l.cubicTo(16.461456f, 29.5f, 13.0798645f, 34.0f, 10.5f, 34.0f);
                l.cubicTo(10.5f, 34.0f, 23.911882f, 34.0f, 25.5f, 34.0f);
                l.cubicTo(25.5f, 34.0f, 20.59497f, 29.5f, 18.0f, 29.5f);
                l.close();
                l.moveTo(12.400916f, 5.933368f);
                l.cubicTo(13.413912f, 8.198693f, 15.042143f, 9.521335f, 16.935621f, 11.160607f);
                l.cubicTo(18.481054f, 12.498559f, 18.704428f, 13.840594f, 18.704428f, 13.840594f);
                l.cubicTo(18.704428f, 13.840594f, 22.41539f, 9.37187f, 24.088566f, 8.198693f);
                l.cubicTo(25.761744f, 7.0255156f, 26.796274f, 2.6699219f, 26.796274f, 2.6699219f);
                l.cubicTo(26.796274f, 2.6699219f, 23.044596f, 5.933368f, 19.713867f, 5.933368f);
                l.cubicTo(16.383139f, 5.933368f, 16.935621f, 6.7753158f, 12.400916f, 5.933368f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-9312);
                a2.setStrokeWidth(3.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(7.531052f, 0.8899055f);
                l.cubicTo(7.5f, 10.796076f, 9.671387f, 9.194105f, 15.0f, 15.2649f);
                l.cubicTo(17.19315f, 17.659187f, 16.830078f, 19.011608f, 15.0f, 21.053797f);
                l.cubicTo(12.047792f, 24.348173f, 7.5f, 24.034626f, 7.5f, 34.089428f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-9312);
                a2.setStrokeWidth(3.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(29.968988f, 1.0f);
                l.cubicTo(30.0f, 10.90617f, 27.83145f, 9.304199f, 22.509796f, 15.374994f);
                l.cubicTo(20.31951f, 17.769281f, 20.682108f, 19.121702f, 22.509796f, 21.16389f);
                l.cubicTo(25.458147f, 24.458267f, 30.0f, 24.14472f, 30.0f, 34.199524f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
