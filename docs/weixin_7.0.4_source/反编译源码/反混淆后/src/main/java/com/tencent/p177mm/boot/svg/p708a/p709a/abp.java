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

/* renamed from: com.tencent.mm.boot.svg.a.a.abp */
public final class abp extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 21.0f);
                l.lineTo(12.0f, 12.0f);
                l.cubicTo(12.0f, 5.372583f, 17.372583f, 0.0f, 24.0f, 0.0f);
                l.cubicTo(30.627417f, 0.0f, 36.0f, 5.372583f, 36.0f, 12.0f);
                l.lineTo(36.0f, 21.0f);
                l.lineTo(44.997383f, 21.0f);
                l.cubicTo(46.65568f, 21.0f, 48.0f, 22.342468f, 48.0f, 23.995506f);
                l.lineTo(48.0f, 57.004494f);
                l.cubicTo(48.0f, 58.658867f, 46.666107f, 60.0f, 44.997383f, 60.0f);
                l.lineTo(3.002615f, 60.0f);
                l.cubicTo(1.3443165f, 60.0f, 0.0f, 58.65753f, 0.0f, 57.004494f);
                l.lineTo(0.0f, 23.995506f);
                l.cubicTo(0.0f, 22.341135f, 1.3338926f, 21.0f, 3.002615f, 21.0f);
                l.lineTo(12.0f, 21.0f);
                l.close();
                l.moveTo(15.6f, 21.0f);
                l.lineTo(32.399998f, 21.0f);
                l.lineTo(32.399998f, 12.0f);
                l.cubicTo(32.39999f, 7.360799f, 28.639183f, 3.5999908f, 23.99999f, 3.5999908f);
                l.cubicTo(19.3608f, 3.5999908f, 15.599991f, 7.360799f, 15.599991f, 11.99999f);
                l.lineTo(15.6f, 21.0f);
                l.close();
                l.moveTo(3.6f, 24.6f);
                l.lineTo(3.6f, 56.4f);
                l.lineTo(44.4f, 56.4f);
                l.lineTo(44.4f, 24.6f);
                l.lineTo(3.6f, 24.6f);
                l.close();
                l.moveTo(22.199999f, 41.62556f);
                l.cubicTo(20.610685f, 40.93116f, 19.5f, 39.345287f, 19.5f, 37.5f);
                l.cubicTo(19.5f, 35.014717f, 21.514719f, 33.0f, 24.0f, 33.0f);
                l.cubicTo(26.485281f, 33.0f, 28.5f, 35.014717f, 28.5f, 37.5f);
                l.cubicTo(28.5f, 39.345287f, 27.389315f, 40.93116f, 25.8f, 41.62556f);
                l.lineTo(25.8f, 48.0f);
                l.lineTo(22.199999f, 48.0f);
                l.lineTo(22.199999f, 41.62556f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
