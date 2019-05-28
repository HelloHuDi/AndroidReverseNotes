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

/* renamed from: com.tencent.mm.boot.svg.a.a.nk */
public final class C32385nk extends C5163c {
    private final int height = 115;
    private final int width = 115;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -122.0f, 0.0f, 1.0f, -1170.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 122.0f, 0.0f, 1.0f, 1170.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-5066062);
                a2.setStrokeWidth(6.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(57.391304f, 3.0f);
                l.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                l.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                l.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                l.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-5066062);
                l = C5163c.m7884l(looper);
                l.moveTo(76.75181f, 59.59088f);
                l.lineTo(50.76934f, 76.80847f);
                l.cubicTo(49.6515f, 77.549225f, 48.144814f, 77.24353f, 47.404064f, 76.125694f);
                l.cubicTo(47.140537f, 75.72801f, 47.0f, 75.26151f, 47.0f, 74.78445f);
                l.lineTo(47.0f, 40.34926f);
                l.cubicTo(47.0f, 39.00826f, 48.087093f, 37.921165f, 49.428093f, 37.921165f);
                l.cubicTo(49.905163f, 37.921165f, 50.371662f, 38.061703f, 50.76934f, 38.32523f);
                l.lineTo(76.75181f, 55.542824f);
                l.cubicTo(77.86965f, 56.283573f, 78.17534f, 57.79026f, 77.43459f, 58.9081f);
                l.cubicTo(77.255005f, 59.179108f, 77.02282f, 59.411293f, 76.75181f, 59.59088f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
