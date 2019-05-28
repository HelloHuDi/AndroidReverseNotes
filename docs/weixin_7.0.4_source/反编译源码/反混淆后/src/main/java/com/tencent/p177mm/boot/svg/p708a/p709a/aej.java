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

/* renamed from: com.tencent.mm.boot.svg.a.a.aej */
public final class aej extends C5163c {
    private final int height = 92;
    private final int width = 92;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 92;
            case 1:
                return 92;
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
                a.setColor(-3355444);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(17.932604f, 2.0969148f);
                l.cubicTo(25.994081f, -0.5536036f, 35.3458f, 1.7168405f, 41.396908f, 7.6379986f);
                l.cubicTo(47.988117f, 13.789202f, 50.418564f, 23.60112f, 48.198154f, 32.24281f);
                l.cubicTo(44.57749f, 46.585617f, 34.955727f, 58.447937f, 24.993898f, 69.0f);
                l.cubicTo(17.072445f, 60.688374f, 9.661086f, 51.646606f, 4.860205f, 41.13455f);
                l.cubicTo(2.0196838f, 34.84332f, 0.079327956f, 27.781939f, 1.4495794f, 20.860584f);
                l.cubicTo(2.989862f, 12.228896f, 9.511058f, 4.6574154f, 17.932604f, 2.0969148f);
                l.lineTo(17.932604f, 2.0969148f);
                l.lineTo(17.932604f, 2.0969148f);
                l.close();
                l.moveTo(22.660744f, 14.37389f);
                l.cubicTo(16.35458f, 15.838051f, 12.456952f, 23.040936f, 14.585656f, 29.035152f);
                l.cubicTo(16.224659f, 34.636303f, 22.740694f, 38.291794f, 28.477203f, 36.57214f);
                l.cubicTo(34.683426f, 35.098152f, 38.49111f, 27.983707f, 36.442356f, 22.068104f);
                l.cubicTo(34.853325f, 16.447298f, 28.407246f, 12.781983f, 22.660744f, 14.37389f);
                l.lineTo(22.660744f, 14.37389f);
                l.lineTo(22.660744f, 14.37389f);
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
