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

/* renamed from: com.tencent.mm.boot.svg.a.a.afc */
public final class afc extends C5163c {
    private final int height = 70;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 70;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 4.4922566f);
                l.cubicTo(0.46f, 1.6837293f, 3.04f, -0.3052276f, 5.88f, 0.044588927f);
                l.cubicTo(31.95f, 0.02459941f, 58.02f, 0.03459417f, 84.09f, 0.044588927f);
                l.cubicTo(86.85f, -0.31522238f, 89.24f, 1.5438027f, 90.0f, 4.1324453f);
                l.lineTo(90.0f, 61.532345f);
                l.cubicTo(89.6f, 63.73119f, 88.0f, 65.33035f, 85.92f, 66.0f);
                l.lineTo(4.35f, 66.0f);
                l.cubicTo(2.2f, 65.55024f, 0.66f, 63.94108f, 0.0f, 61.892155f);
                l.lineTo(0.0f, 4.4922566f);
                l.close();
                l.moveTo(7.0f, 14.0f);
                l.lineTo(83.0f, 14.0f);
                l.lineTo(83.0f, 26.0f);
                l.lineTo(7.0f, 26.0f);
                l.lineTo(7.0f, 14.0f);
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
