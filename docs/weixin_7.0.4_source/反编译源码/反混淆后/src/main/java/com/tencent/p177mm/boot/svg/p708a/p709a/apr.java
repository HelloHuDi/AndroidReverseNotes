package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
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

/* renamed from: com.tencent.mm.boot.svg.a.a.apr */
public final class apr extends C5163c {
    private final int height = 125;
    private final int width = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            case 1:
                return 125;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-2664127);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.08785249f, -2.7755576E-16f);
                l.cubicTo(0.029366853f, 0.41979796f, 0.0f, 0.8405075f, 0.0f, 1.2620968f);
                l.cubicTo(0.0f, 39.514496f, 150.4436f, 125.0f, 540.0f, 125.0f);
                l.cubicTo(929.5564f, 125.0f, 1080.0f, 39.514496f, 1080.0f, 1.2620968f);
                l.cubicTo(1080.0f, 0.8405075f, 1079.9706f, 0.41979796f, 1079.9121f, 2.220446E-16f);
                l.lineTo(0.08785249f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
