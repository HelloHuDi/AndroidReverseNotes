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

/* renamed from: com.tencent.mm.boot.svg.a.a.aep */
public final class aep extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                g = C5163c.m7878a(g, 2.4f, 0.0f, 0.0f, 0.0f, 2.4f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                k = C5163c.m7876a(a2, looper);
                k2 = C5163c.m7876a(a, looper);
                k.setColor(201326592);
                k2.setColor(-3552823);
                Path l = C5163c.m7884l(looper);
                l.moveTo(19.5f, 10.123457f);
                l.cubicTo(19.5f, 4.7531796f, 15.24682f, 0.5f, 9.876543f, 0.5f);
                l.cubicTo(4.71725f, 0.5f, 0.5f, 4.789796f, 0.5f, 10.123457f);
                l.cubicTo(0.5f, 15.24682f, 4.7531796f, 19.5f, 9.876543f, 19.5f);
                l.cubicTo(15.210204f, 19.5f, 19.5f, 15.28275f, 19.5f, 10.123457f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.drawPath(l, k2);
                canvas.restore();
                a2 = C5163c.m7876a(a2, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                l = C5163c.m7884l(looper);
                l.moveTo(5.456435f, 10.368831f);
                l.lineTo(5.506938f, 10.300112f);
                l.cubicTo(5.663359f, 10.087274f, 5.962703f, 10.041537f, 6.1755424f, 10.197958f);
                l.cubicTo(6.1781316f, 10.199862f, 6.1807017f, 10.201791f, 6.1832523f, 10.203745f);
                l.lineTo(8.341835f, 11.858175f);
                l.cubicTo(8.519238f, 11.994144f, 8.767159f, 11.989105f, 8.938891f, 11.846039f);
                l.lineTo(15.01762f, 6.7819657f);
                l.cubicTo(15.194826f, 6.634339f, 15.455153f, 6.645353f, 15.619257f, 6.8074207f);
                l.lineTo(15.619257f, 6.8074207f);
                l.cubicTo(15.776759f, 6.9629693f, 15.778342f, 7.2167473f, 15.622794f, 7.3742495f);
                l.cubicTo(15.621458f, 7.375602f, 15.620112f, 7.376945f, 15.618758f, 7.3782783f);
                l.lineTo(8.9890175f, 13.902933f);
                l.cubicTo(8.800759f, 14.088207f, 8.497951f, 14.085789f, 8.312676f, 13.897531f);
                l.cubicTo(8.311649f, 13.896486f, 8.310627f, 13.895438f, 8.309609f, 13.894385f);
                l.lineTo(5.497875f, 10.98438f);
                l.cubicTo(5.3358793f, 10.816722f, 5.318373f, 10.556688f, 5.456435f, 10.368831f);
                l.close();
                canvas.saveLayerAlpha(null, 76, 4);
                Paint a3 = C5163c.m7876a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
