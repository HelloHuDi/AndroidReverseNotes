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

/* renamed from: com.tencent.mm.boot.svg.a.a.arc */
public final class arc extends C5163c {
    private final int height = 49;
    private final int width = 56;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 56;
            case 1:
                return 49;
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
                k.setColor(-27648);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(52.0f, 0.0f);
                l.cubicTo(53.5f, 1.0525777f, 54.73f, 2.1051555f, 56.0f, 3.0f);
                l.lineTo(56.0f, 5.0f);
                l.cubicTo(53.09f, 7.1074057f, 50.94f, 10.395458f, 49.0f, 13.0f);
                l.cubicTo(39.47f, 25.301964f, 30.39f, 37.161007f, 21.0f, 49.0f);
                l.cubicTo(13.57f, 41.7723f, 7.51f, 33.00082f, 0.0f, 26.0f);
                l.lineTo(0.0f, 24.0f);
                l.cubicTo(0.87f, 22.956219f, 1.72f, 21.643003f, 3.0f, 20.0f);
                l.cubicTo(8.66f, 25.121523f, 14.88f, 29.762888f, 21.0f, 34.0f);
                l.cubicTo(31.45f, 22.986294f, 41.91f, 11.538257f, 52.0f, 0.0f);
                l.lineTo(52.0f, 0.0f);
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
