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

/* renamed from: com.tencent.mm.boot.svg.a.a.asz */
public final class asz extends C5163c {
    private final int height = 20;
    private final int width = 40;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 20;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(18.736526f, 15.312118f);
                l.cubicTo(18.68855f, 15.287715f, 18.641708f, 15.259116f, 18.596445f, 15.226229f);
                l.lineTo(0.76661897f, 2.2721026f);
                l.cubicTo(0.31868246f, 1.9466575f, 0.21645539f, 1.3237382f, 0.5433434f, 0.87381536f);
                l.cubicTo(0.86796826f, 0.42700762f, 1.4962001f, 0.33003822f, 1.9398534f, 0.6523712f);
                l.lineTo(19.354612f, 13.3049345f);
                l.lineTo(19.457281f, 13.379528f);
                l.lineTo(19.457281f, 13.379528f);
                l.lineTo(19.559952f, 13.3049345f);
                l.lineTo(36.97471f, 0.6523712f);
                l.cubicTo(37.41836f, 0.33003822f, 38.046597f, 0.42700762f, 38.37122f, 0.87381536f);
                l.cubicTo(38.69811f, 1.3237382f, 38.595882f, 1.9466575f, 38.147945f, 2.2721026f);
                l.lineTo(20.623741f, 15.004182f);
                l.lineTo(19.49353f, 15.865662f);
                l.lineTo(18.736526f, 15.312118f);
                l.close();
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
