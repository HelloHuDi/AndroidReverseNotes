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

/* renamed from: com.tencent.mm.boot.svg.a.a.apx */
public final class apx extends C5163c {
    private final int height = 74;
    private final int width = ErrorCode.STARTDOWNLOAD_6;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ErrorCode.STARTDOWNLOAD_6;
            case 1:
                return 74;
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
                a.setColor(-7683054);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(87.71f, 1.02f);
                l.cubicTo(97.18f, 0.98f, 106.65f, 1.01f, 116.11f, 1.0f);
                l.cubicTo(122.86f, 0.94f, 129.37f, 4.23f, 133.81f, 9.23f);
                l.cubicTo(138.87f, 14.77f, 141.51f, 22.18f, 142.0f, 29.61f);
                l.lineTo(142.0f, 36.95f);
                l.cubicTo(141.63f, 45.0f, 138.59f, 53.09f, 132.81f, 58.82f);
                l.cubicTo(128.22f, 63.52f, 121.67f, 66.29f, 115.07f, 66.0f);
                l.cubicTo(76.95f, 65.86f, 38.82f, 66.27f, 0.7f, 65.79f);
                l.cubicTo(14.4f, 65.13f, 27.91f, 61.47f, 40.08f, 55.19f);
                l.cubicTo(62.05f, 44.0f, 79.39f, 24.21f, 87.71f, 1.02f);
                l.lineTo(87.71f, 1.02f);
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
