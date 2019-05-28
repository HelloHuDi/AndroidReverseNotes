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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.bcu */
public final class bcu extends C5163c {
    private final int height = C31128d.MIC_PTU_TRANS_ROUHE;
    private final int width = C31128d.MIC_PTU_TRANS_ROUHE;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C31128d.MIC_PTU_TRANS_ROUHE;
            case 1:
                return C31128d.MIC_PTU_TRANS_ROUHE;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -401.0f, 0.0f, 1.0f, -470.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 390.0f, 0.0f, 1.0f, 470.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-2245500);
                Path l = C5163c.m7884l(looper);
                l.moveTo(279.0f, 141.22223f);
                l.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                l.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                l.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                l.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(69.47473f, 146.5967f);
                l.lineTo(75.88924f, 137.86859f);
                l.cubicTo(76.37983f, 137.20105f, 77.31869f, 137.0576f, 77.98622f, 137.5482f);
                l.cubicTo(77.99435f, 137.55417f, 78.0024f, 137.56023f, 78.01041f, 137.56635f);
                l.lineTo(115.591606f, 166.3702f);
                l.cubicTo(116.14801f, 166.79663f, 116.92558f, 166.78082f, 117.464195f, 166.33212f);
                l.lineTo(208.74998f, 90.283676f);
                l.cubicTo(209.34323f, 89.78945f, 210.21474f, 89.826324f, 210.76411f, 90.36889f);
                l.lineTo(216.78378f, 96.313896f);
                l.cubicTo(217.37321f, 96.89602f, 217.37914f, 97.84574f, 216.79703f, 98.43517f);
                l.cubicTo(216.79202f, 98.44024f, 216.78699f, 98.44527f, 216.78192f, 98.45026f);
                l.lineTo(117.6191f, 196.04128f);
                l.cubicTo(117.028656f, 196.62236f, 116.07894f, 196.61478f, 115.49785f, 196.02432f);
                l.cubicTo(115.49463f, 196.02106f, 115.491425f, 196.01776f, 115.488235f, 196.01447f);
                l.lineTo(69.6047f, 148.52728f);
                l.cubicTo(69.09662f, 148.00145f, 69.04172f, 147.18588f, 69.47473f, 146.5967f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
