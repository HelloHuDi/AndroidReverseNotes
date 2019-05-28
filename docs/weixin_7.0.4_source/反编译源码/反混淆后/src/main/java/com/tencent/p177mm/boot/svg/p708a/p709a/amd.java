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

/* renamed from: com.tencent.mm.boot.svg.a.a.amd */
public final class amd extends C5163c {
    private final int height = 73;
    private final int width = 68;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 73;
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
                a.setColor(-757915);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.45f, 0.0f, 1.0f, 6.75f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 2.533342f);
                l.cubicTo(0.0f, 1.1342157f, 1.1371257f, 0.0f, 2.5456994f, 0.0f);
                l.lineTo(47.4043f, 0.0f);
                l.cubicTo(48.810253f, 0.0f, 49.95f, 1.1335528f, 49.95f, 2.533342f);
                l.lineTo(49.95f, 56.866657f);
                l.cubicTo(49.95f, 58.265785f, 48.812874f, 59.4f, 47.4043f, 59.4f);
                l.lineTo(2.5456994f, 59.4f);
                l.cubicTo(1.1397485f, 59.4f, 0.0f, 58.26645f, 0.0f, 56.866657f);
                l.lineTo(0.0f, 2.533342f);
                l.close();
                l.moveTo(4.2814283f, 4.242857f);
                l.lineTo(45.66857f, 4.242857f);
                l.lineTo(45.66857f, 55.157143f);
                l.lineTo(4.2814283f, 55.157143f);
                l.lineTo(4.2814283f, 4.242857f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(24.975f, 21.214287f);
                l.cubicTo(27.733664f, 21.214287f, 29.970001f, 23.430477f, 29.970001f, 26.164286f);
                l.cubicTo(29.970001f, 28.898094f, 27.733664f, 31.114285f, 24.975f, 31.114285f);
                l.cubicTo(22.216337f, 31.114285f, 19.98f, 28.898094f, 19.98f, 26.164286f);
                l.cubicTo(19.98f, 23.430477f, 22.216337f, 21.214287f, 24.975f, 21.214287f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(32.8229f, 26.016615f);
                l.cubicTo(42.771538f, 23.7808f, 49.95f, 17.410063f, 49.95f, 9.9f);
                l.cubicTo(49.95f, 7.916405f, 49.449215f, 6.0122924f, 48.528873f, 4.242857f);
                l.lineTo(45.262028f, 4.242857f);
                l.cubicTo(45.528664f, 5.0701585f, 45.66857f, 5.96271f, 45.66857f, 6.9225564f);
                l.cubicTo(45.66857f, 13.030636f, 40.002968f, 20.055094f, 32.067444f, 22.827524f);
                l.cubicTo(32.532673f, 23.796925f, 32.801483f, 24.876797f, 32.8229f, 26.016615f);
                l.close();
                l.moveTo(17.1271f, 26.016615f);
                l.cubicTo(7.178464f, 23.7808f, 0.0f, 17.410063f, 0.0f, 9.9f);
                l.cubicTo(0.0f, 7.916405f, 0.5007839f, 6.0122924f, 1.421125f, 4.242857f);
                l.lineTo(4.6879735f, 4.242857f);
                l.cubicTo(4.4213357f, 5.0701585f, 4.2814283f, 5.96271f, 4.2814283f, 6.9225564f);
                l.cubicTo(4.2814283f, 13.030636f, 9.947033f, 20.055094f, 17.882557f, 22.827524f);
                l.cubicTo(17.417328f, 23.796925f, 17.148516f, 24.876797f, 17.1271f, 26.016615f);
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
