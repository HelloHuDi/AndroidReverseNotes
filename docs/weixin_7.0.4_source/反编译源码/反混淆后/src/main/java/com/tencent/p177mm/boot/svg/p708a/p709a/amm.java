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

/* renamed from: com.tencent.mm.boot.svg.a.a.amm */
public final class amm extends C5163c {
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(51.362026f, 6.0f);
                l.lineTo(61.99543f, 6.0f);
                l.cubicTo(64.20043f, 6.0f, 66.0f, 7.7952905f, 66.0f, 10.009893f);
                l.lineTo(66.0f, 49.99011f);
                l.cubicTo(66.0f, 52.205948f, 64.20709f, 54.0f, 61.99543f, 54.0f);
                l.lineTo(4.0045705f, 54.0f);
                l.cubicTo(1.7995698f, 54.0f, 0.0f, 52.20471f, 0.0f, 49.99011f);
                l.lineTo(0.0f, 10.009893f);
                l.cubicTo(0.0f, 7.7940526f, 1.7929074f, 6.0f, 4.0045705f, 6.0f);
                l.lineTo(14.637975f, 6.0f);
                l.lineTo(21.0f, 0.0f);
                l.lineTo(45.0f, 0.0f);
                l.lineTo(51.362026f, 6.0f);
                l.lineTo(51.362026f, 6.0f);
                l.close();
                l.moveTo(33.0f, 48.0f);
                l.cubicTo(44.045696f, 48.0f, 53.0f, 39.045696f, 53.0f, 28.0f);
                l.cubicTo(53.0f, 16.954306f, 44.045696f, 8.0f, 33.0f, 8.0f);
                l.cubicTo(21.954306f, 8.0f, 13.0f, 16.954306f, 13.0f, 28.0f);
                l.cubicTo(13.0f, 39.045696f, 21.954306f, 48.0f, 33.0f, 48.0f);
                l.lineTo(33.0f, 48.0f);
                l.close();
                l.moveTo(33.0f, 41.0f);
                l.cubicTo(40.179703f, 41.0f, 46.0f, 35.179703f, 46.0f, 28.0f);
                l.cubicTo(46.0f, 20.8203f, 40.179703f, 15.0f, 33.0f, 15.0f);
                l.cubicTo(25.8203f, 15.0f, 20.0f, 20.8203f, 20.0f, 28.0f);
                l.cubicTo(20.0f, 35.179703f, 25.8203f, 41.0f, 33.0f, 41.0f);
                l.lineTo(33.0f, 41.0f);
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
