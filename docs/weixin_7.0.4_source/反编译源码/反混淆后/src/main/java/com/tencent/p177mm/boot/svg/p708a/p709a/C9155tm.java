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

/* renamed from: com.tencent.mm.boot.svg.a.a.tm */
public final class C9155tm extends C5163c {
    private final int height = 30;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 30;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = C5163c.m7884l(looper);
                l.moveTo(22.0f, 14.999688f);
                l.lineTo(7.130435f, 29.999374f);
                l.lineTo(3.826087f, 26.666111f);
                l.lineTo(15.391304f, 14.999688f);
                l.lineTo(3.0f, 3.3332639f);
                l.lineTo(6.304348f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.saveLayerAlpha(null, 51, 4);
                k = C5163c.m7876a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 0.0f);
                l2.lineTo(24.0f, 0.0f);
                l2.lineTo(24.0f, 30.0f);
                l2.lineTo(0.0f, 30.0f);
                l2.lineTo(0.0f, 0.0f);
                l2.close();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
