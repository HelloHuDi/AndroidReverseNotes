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

/* renamed from: com.tencent.mm.boot.svg.a.a.ajs */
public final class ajs extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(30.0f, 0.0f);
                l.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                l.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                l.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                l.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1686720);
                g = C5163c.m7878a(g, 6.123234E-17f, 1.0f, -1.3117828f, -1.0f, 6.123234E-17f, 61.688217f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(36.14667f, 51.0f);
                l.cubicTo(40.93666f, 45.963642f, 43.87644f, 39.151093f, 43.87644f, 31.651924f);
                l.cubicTo(43.87644f, 24.000854f, 40.81636f, 17.064505f, 35.85333f, 12.0f);
                l.lineTo(32.543938f, 15.309392f);
                l.cubicTo(36.660168f, 19.526825f, 39.196537f, 25.293175f, 39.196537f, 31.651924f);
                l.cubicTo(39.196537f, 37.858765f, 36.779907f, 43.50117f, 32.836227f, 47.689556f);
                l.lineTo(36.14667f, 51.0f);
                l.close();
                l.moveTo(28.464663f, 43.31799f);
                l.cubicTo(31.478422f, 40.347473f, 33.34667f, 36.217873f, 33.34667f, 31.651924f);
                l.cubicTo(33.34667f, 26.934067f, 31.352043f, 22.682077f, 28.160082f, 19.693247f);
                l.lineTo(24.848375f, 23.004953f);
                l.cubicTo(27.194576f, 25.144638f, 28.666769f, 28.226358f, 28.666769f, 31.651924f);
                l.cubicTo(28.666769f, 34.925556f, 27.322275f, 37.885162f, 25.155354f, 40.008682f);
                l.lineTo(28.464663f, 43.31799f);
                l.close();
                l.moveTo(21.018442f, 35.871773f);
                l.cubicTo(22.12694f, 34.807247f, 22.816896f, 33.31016f, 22.816896f, 31.651924f);
                l.cubicTo(22.816896f, 29.841587f, 21.994562f, 28.223316f, 20.703054f, 27.150274f);
                l.lineTo(16.5f, 31.353329f);
                l.lineTo(21.018442f, 35.871773f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 0.70710677f, 0.70710677f, -8.70495f, -0.70710677f, 0.70710677f, 31.622213f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(31.568913f, 8.3189125f);
                l2.lineTo(36.068913f, 8.3189125f);
                l2.lineTo(36.068913f, 44.318913f);
                l2.lineTo(31.568913f, 44.318913f);
                l2.lineTo(31.568913f, 8.3189125f);
                l2.close();
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1686720);
                a2 = C5163c.m7878a(a2, 0.70710677f, 0.70710677f, -11.485281f, -0.70710677f, 0.70710677f, 30.909903f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(29.568913f, 11.3189125f);
                l.lineTo(33.568913f, 11.3189125f);
                l.lineTo(33.568913f, 47.318913f);
                l.lineTo(29.568913f, 47.318913f);
                l.lineTo(29.568913f, 11.3189125f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
