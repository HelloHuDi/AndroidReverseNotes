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

/* renamed from: com.tencent.mm.boot.svg.a.a.adx */
public final class adx extends C5163c {
    private final int height = 45;
    private final int width = 45;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                a.setColor(-16139513);
                a2.setColor(-16139513);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Paint a4 = C5163c.m7876a(a2, looper);
                g = C5163c.m7878a(g, 0.70710677f, -0.70710677f, 10.0f, 0.70710677f, 0.70710677f, -4.1421356f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(-1.3137084f, 7.1715727f);
                l.lineTo(21.313707f, 7.1715727f);
                l.lineTo(21.313707f, 12.828427f);
                l.lineTo(-1.3137084f, 12.828427f);
                l.lineTo(-1.3137084f, 7.1715727f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a2 = C5163c.m7876a(a2, looper);
                g = C5163c.m7878a(g, -0.70710677f, -0.70710677f, 44.62742f, 0.70710677f, -0.70710677f, 1.514719f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(10.686292f, 7.1715727f);
                l2.lineTo(33.31371f, 7.1715727f);
                l2.lineTo(33.31371f, 12.828427f);
                l2.lineTo(10.686292f, 12.828427f);
                l2.lineTo(10.686292f, 7.1715727f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
