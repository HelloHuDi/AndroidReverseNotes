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

/* renamed from: com.tencent.mm.boot.svg.a.a.axo */
public final class axo extends C5163c {
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-14046139);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, C5163c.m7876a(k2, looper));
                canvas.restore();
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 53.63604f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(37.79998f, 15.784549f);
                l2.lineTo(37.79998f, 43.5f);
                l2.lineTo(34.19998f, 43.5f);
                l2.lineTo(34.19998f, 15.784586f);
                l2.lineTo(27.938982f, 22.045584f);
                l2.lineTo(25.393398f, 19.5f);
                l2.lineTo(33.87868f, 11.014719f);
                l2.cubicTo(35.05025f, 9.843145f, 36.94975f, 9.843145f, 38.12132f, 11.014719f);
                l2.lineTo(38.545586f, 11.438983f);
                l2.lineTo(46.6066f, 19.5f);
                l2.lineTo(44.061016f, 22.045584f);
                l2.lineTo(37.79998f, 15.784549f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(56.4f, 24.6f);
                l2.lineTo(48.0f, 24.6f);
                l2.lineTo(48.0f, 21.0f);
                l2.lineTo(57.00313f, 21.0f);
                l2.cubicTo(58.65261f, 21.0f, 60.0f, 22.337517f, 60.0f, 23.987425f);
                l2.lineTo(60.0f, 63.012573f);
                l2.cubicTo(60.0f, 64.65324f, 58.662483f, 66.0f, 57.012573f, 66.0f);
                l2.lineTo(14.987426f, 66.0f);
                l2.cubicTo(13.346761f, 66.0f, 12.0f, 64.66248f, 12.0f, 63.012573f);
                l2.lineTo(12.0f, 23.987425f);
                l2.cubicTo(12.0f, 22.34676f, 13.341744f, 21.0f, 14.99687f, 21.0f);
                l2.lineTo(24.0f, 21.0f);
                l2.lineTo(24.0f, 24.6f);
                l2.lineTo(15.6f, 24.6f);
                l2.lineTo(15.6f, 62.4f);
                l2.lineTo(56.4f, 62.4f);
                l2.lineTo(56.4f, 24.6f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
