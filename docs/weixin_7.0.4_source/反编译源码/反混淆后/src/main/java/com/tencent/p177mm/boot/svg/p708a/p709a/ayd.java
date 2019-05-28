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

/* renamed from: com.tencent.mm.boot.svg.a.a.ayd */
public final class ayd extends C5163c {
    private final int height = 66;
    private final int width = 66;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.285f, 0.0f);
                l.cubicTo(9.692f, 0.139f, 9.13f, 0.44f, 8.668f, 0.902f);
                l.lineTo(8.503f, 1.066f);
                l.lineTo(0.018f, 9.551f);
                l.lineTo(2.732f, 12.268f);
                l.lineTo(9.193f, 5.807f);
                l.lineTo(9.193f, 34.219f);
                l.lineTo(13.033f, 34.219f);
                l.lineTo(13.033f, 5.702f);
                l.lineTo(19.764f, 12.432f);
                l.lineTo(22.375f, 9.821f);
                l.lineTo(13.455f, 0.902f);
                l.cubicTo(12.992f, 0.44f, 12.43f, 0.139f, 11.838f, 0.0f);
                l.lineTo(10.285f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(48.0f, 57.09f);
                l.lineTo(48.0f, 17.065f);
                l.cubicTo(48.0f, 15.372f, 46.563f, 14.0f, 44.803f, 14.0f);
                l.lineTo(38.4f, 14.0f);
                l.lineTo(38.4f, 17.9f);
                l.lineTo(44.1f, 17.9f);
                l.lineTo(44.1f, 56.254f);
                l.lineTo(3.9f, 56.254f);
                l.lineTo(3.9f, 17.9f);
                l.lineTo(9.6f, 17.9f);
                l.lineTo(9.6f, 14.0f);
                l.lineTo(3.197f, 14.0f);
                l.cubicTo(1.432f, 14.0f, 0.0f, 15.382f, 0.0f, 17.065f);
                l.lineTo(0.0f, 57.09f);
                l.cubicTo(0.0f, 58.782f, 1.437f, 60.154f, 3.187f, 60.154f);
                l.lineTo(44.813f, 60.154f);
                l.cubicTo(46.573f, 60.154f, 48.0f, 58.774f, 48.0f, 57.09f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
