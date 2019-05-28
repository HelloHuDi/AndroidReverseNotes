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

/* renamed from: com.tencent.mm.boot.svg.a.a.aed */
public final class aed extends C5163c {
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
                k.setColor(-13026753);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(47.9983f, 37.61686f);
                l.cubicTo(47.74289f, 37.61725f, 47.48804f, 37.71553f, 47.293037f, 37.910534f);
                l.lineTo(32.00577f, 53.1978f);
                l.cubicTo(31.617527f, 53.58605f, 31.61592f, 54.22187f, 32.007095f, 54.613045f);
                l.lineTo(34.765827f, 57.371777f);
                l.cubicTo(35.160282f, 57.76623f, 35.790627f, 57.763542f, 36.18107f, 57.373096f);
                l.lineTo(48.0f, 45.55417f);
                l.lineTo(59.81893f, 57.373096f);
                l.cubicTo(60.207176f, 57.761345f, 60.843f, 57.76295f, 61.234173f, 57.371777f);
                l.lineTo(63.992905f, 54.613045f);
                l.cubicTo(64.38736f, 54.218586f, 64.384674f, 53.588245f, 63.99423f, 53.1978f);
                l.lineTo(48.706963f, 37.910534f);
                l.cubicTo(48.513058f, 37.71663f, 48.257397f, 37.619167f, 48.0013f, 37.61891f);
                l.close();
                l.moveTo(17.0f, 20.996428f);
                l.cubicTo(17.0f, 18.78926f, 18.788675f, 17.0f, 20.996428f, 17.0f);
                l.lineTo(75.00357f, 17.0f);
                l.cubicTo(77.21074f, 17.0f, 79.0f, 18.788675f, 79.0f, 20.996428f);
                l.lineTo(79.0f, 75.00357f);
                l.cubicTo(79.0f, 77.21074f, 77.21133f, 79.0f, 75.00357f, 79.0f);
                l.lineTo(20.996428f, 79.0f);
                l.cubicTo(18.78926f, 79.0f, 17.0f, 77.21133f, 17.0f, 75.00357f);
                l.lineTo(17.0f, 20.996428f);
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
