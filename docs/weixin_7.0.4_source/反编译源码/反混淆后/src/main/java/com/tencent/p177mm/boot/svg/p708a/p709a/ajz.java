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

/* renamed from: com.tencent.mm.boot.svg.a.a.ajz */
public final class ajz extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(72.0f, 144.0f);
                l.cubicTo(32.235497f, 144.0f, 0.0f, 111.7645f, 0.0f, 72.0f);
                l.cubicTo(0.0f, 32.235497f, 32.235497f, 0.0f, 72.0f, 0.0f);
                l.cubicTo(111.7645f, 0.0f, 144.0f, 32.235497f, 144.0f, 72.0f);
                l.cubicTo(144.0f, 111.7645f, 111.7645f, 144.0f, 72.0f, 144.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-5066062);
                l = C5163c.m7884l(looper);
                l.moveTo(42.5f, 80.0f);
                l.cubicTo(38.357864f, 80.0f, 35.0f, 76.642136f, 35.0f, 72.5f);
                l.cubicTo(35.0f, 68.357864f, 38.357864f, 65.0f, 42.5f, 65.0f);
                l.cubicTo(46.642136f, 65.0f, 50.0f, 68.357864f, 50.0f, 72.5f);
                l.cubicTo(50.0f, 76.642136f, 46.642136f, 80.0f, 42.5f, 80.0f);
                l.close();
                l.moveTo(72.5f, 80.0f);
                l.cubicTo(68.357864f, 80.0f, 65.0f, 76.642136f, 65.0f, 72.5f);
                l.cubicTo(65.0f, 68.357864f, 68.357864f, 65.0f, 72.5f, 65.0f);
                l.cubicTo(76.642136f, 65.0f, 80.0f, 68.357864f, 80.0f, 72.5f);
                l.cubicTo(80.0f, 76.642136f, 76.642136f, 80.0f, 72.5f, 80.0f);
                l.close();
                l.moveTo(102.5f, 80.0f);
                l.cubicTo(98.357864f, 80.0f, 95.0f, 76.642136f, 95.0f, 72.5f);
                l.cubicTo(95.0f, 68.357864f, 98.357864f, 65.0f, 102.5f, 65.0f);
                l.cubicTo(106.642136f, 65.0f, 110.0f, 68.357864f, 110.0f, 72.5f);
                l.cubicTo(110.0f, 76.642136f, 106.642136f, 80.0f, 102.5f, 80.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
