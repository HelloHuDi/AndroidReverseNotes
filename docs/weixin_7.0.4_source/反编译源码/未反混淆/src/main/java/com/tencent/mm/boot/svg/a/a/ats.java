package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class ats extends c {
    private final int height = 216;
    private final int width = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            case 1:
                return 216;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(1080.0f, 0.0f);
                l.lineTo(1080.0f, 216.0f);
                l.lineTo(0.0f, 216.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                g = c.a(g, 1080.0f, 0.0f, 0.0f, 0.0f, 216.0f, 0.0f);
                h.reset();
                h.setValues(g);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0727838f, 0.5f, 1.0f, new int[]{855638016, 0}, new float[]{0.0f, 1.0f}, h, 0);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
