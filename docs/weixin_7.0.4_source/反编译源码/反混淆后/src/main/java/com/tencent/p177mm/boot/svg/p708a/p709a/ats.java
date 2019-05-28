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
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.boot.svg.a.a.ats */
public final class ats extends C5163c {
    private final int height = 216;
    private final int width = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            case 1:
                return 216;
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(1080.0f, 0.0f);
                l.lineTo(1080.0f, 216.0f);
                l.lineTo(0.0f, 216.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                g = C5163c.m7878a(g, 1080.0f, 0.0f, 0.0f, 0.0f, 216.0f, 0.0f);
                h.reset();
                h.setValues(g);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0727838f, 0.5f, 1.0f, new int[]{855638016, 0}, new float[]{0.0f, 1.0f}, h, 0);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
