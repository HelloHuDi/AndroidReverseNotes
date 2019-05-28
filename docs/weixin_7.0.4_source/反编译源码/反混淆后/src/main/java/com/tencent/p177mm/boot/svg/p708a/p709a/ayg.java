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

/* renamed from: com.tencent.mm.boot.svg.a.a.ayg */
public final class ayg extends C5163c {
    private final int height = 24;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -65.0f, 0.0f, 1.0f, -131.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 65.0f, 0.0f, 1.0f, 131.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 24.0f);
                l.cubicTo(5.372583f, 24.0f, 0.0f, 18.627417f, 0.0f, 12.0f);
                l.cubicTo(0.0f, 5.372583f, 5.372583f, 0.0f, 12.0f, 0.0f);
                l.cubicTo(18.627417f, 0.0f, 24.0f, 5.372583f, 24.0f, 12.0f);
                l.cubicTo(24.0f, 18.627417f, 18.627417f, 24.0f, 12.0f, 24.0f);
                l.close();
                l.moveTo(12.0f, 22.333334f);
                l.cubicTo(17.706942f, 22.333334f, 22.333334f, 17.706942f, 22.333334f, 12.0f);
                l.cubicTo(22.333334f, 6.2930574f, 17.706942f, 1.6666666f, 12.0f, 1.6666666f);
                l.cubicTo(6.2930574f, 1.6666666f, 1.6666666f, 6.2930574f, 1.6666666f, 12.0f);
                l.cubicTo(1.6666666f, 17.706942f, 6.2930574f, 22.333334f, 12.0f, 22.333334f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(13.666667f, 11.666667f);
                l.lineTo(13.666667f, 13.624764f);
                l.lineTo(13.666667f, 14.916196f);
                l.cubicTo(13.666667f, 15.154654f, 13.482121f, 15.333324f, 13.254474f, 15.333315f);
                l.lineTo(6.4121933f, 15.333003f);
                l.cubicTo(6.189514f, 15.332993f, 6.0f, 15.146587f, 6.0f, 14.916656f);
                l.lineTo(6.0f, 9.093866f);
                l.cubicTo(6.0f, 8.869545f, 6.184545f, 8.677277f, 6.4121933f, 8.676953f);
                l.lineTo(13.254474f, 8.667252f);
                l.cubicTo(13.477153f, 8.666935f, 13.666667f, 8.853425f, 13.666667f, 9.083804f);
                l.lineTo(13.666667f, 11.666667f);
                l.close();
                l.moveTo(14.666667f, 10.752296f);
                l.cubicTo(15.714527f, 9.888178f, 17.115644f, 8.891267f, 17.5f, 8.677538f);
                l.cubicTo(17.615805f, 8.618451f, 18.0f, 8.80178f, 18.0f, 9.189495f);
                l.lineTo(18.0f, 14.821027f);
                l.cubicTo(18.0f, 15.089015f, 17.652575f, 15.344082f, 17.5f, 15.332984f);
                l.cubicTo(17.179924f, 15.098051f, 15.743977f, 14.046944f, 14.666667f, 13.185655f);
                l.lineTo(14.666667f, 10.752296f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
