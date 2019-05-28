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

/* renamed from: com.tencent.mm.boot.svg.a.a.axb */
public final class axb extends C5163c {
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 0.70710677f, 0.70710677f, -19.882248f, -0.70710677f, 0.70710677f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(50.0f, 24.0f);
                l2.lineTo(46.0f, 24.0f);
                l2.lineTo(46.0f, 46.0f);
                l2.lineTo(24.0f, 46.0f);
                l2.lineTo(24.0f, 50.0f);
                l2.lineTo(46.0f, 50.0f);
                l2.lineTo(46.0f, 72.0f);
                l2.lineTo(50.0f, 72.0f);
                l2.lineTo(50.0f, 50.0f);
                l2.lineTo(72.0f, 50.0f);
                l2.lineTo(72.0f, 46.0f);
                l2.lineTo(50.0f, 46.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.saveLayerAlpha(null, 51, 4);
                k = C5163c.m7876a(a, looper);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
