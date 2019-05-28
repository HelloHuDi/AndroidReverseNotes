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

/* renamed from: com.tencent.mm.boot.svg.a.a.lr */
public final class C25908lr extends C5163c {
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-3289392);
                Path l = C5163c.m7884l(looper);
                l.moveTo(17.0f, 48.02f);
                l.cubicTo(27.66f, 37.34f, 38.34f, 26.66f, 49.02f, 16.0f);
                l.cubicTo(50.92f, 17.88f, 52.82f, 19.78f, 54.7f, 21.68f);
                l.cubicTo(47.27f, 29.13f, 39.82f, 36.56f, 32.39f, 44.01f);
                l.cubicTo(48.6f, 44.03f, 64.81f, 44.01f, 81.02f, 44.02f);
                l.cubicTo(81.02f, 46.71f, 81.02f, 49.39f, 81.01f, 52.08f);
                l.cubicTo(64.83f, 52.1f, 48.64f, 52.07f, 32.45f, 52.09f);
                l.cubicTo(39.86f, 59.52f, 47.29f, 66.93f, 54.7f, 74.36f);
                l.cubicTo(52.82f, 76.26f, 50.92f, 78.16f, 49.02f, 80.04f);
                l.cubicTo(38.34f, 69.38f, 27.66f, 58.7f, 17.0f, 48.02f);
                l.lineTo(17.0f, 48.02f);
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
