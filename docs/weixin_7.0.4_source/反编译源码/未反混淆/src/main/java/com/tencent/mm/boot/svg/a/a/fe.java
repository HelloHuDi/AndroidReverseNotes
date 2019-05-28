package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class fe extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-2565928);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(144.0f, 0.0f);
                l.lineTo(144.0f, 144.0f);
                l.lineTo(0.0f, 144.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(k2, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(72.0f, 102.0f);
                l2.cubicTo(55.431458f, 102.0f, 42.0f, 88.56854f, 42.0f, 72.0f);
                l2.cubicTo(42.0f, 55.431458f, 55.431458f, 42.0f, 72.0f, 42.0f);
                l2.cubicTo(88.56854f, 42.0f, 102.0f, 55.431458f, 102.0f, 72.0f);
                l2.cubicTo(102.0f, 88.56854f, 88.56854f, 102.0f, 72.0f, 102.0f);
                l2.close();
                l2.moveTo(72.0f, 96.0f);
                l2.cubicTo(85.25484f, 96.0f, 96.0f, 85.25484f, 96.0f, 72.0f);
                l2.cubicTo(96.0f, 58.745167f, 85.25484f, 48.0f, 72.0f, 48.0f);
                l2.cubicTo(72.0f, 64.35864f, 72.0f, 82.30664f, 72.0f, 96.0f);
                l2.close();
                l2.moveTo(3.0f, 69.0f);
                l2.lineTo(30.0f, 69.0f);
                l2.lineTo(30.0f, 75.0f);
                l2.lineTo(3.0f, 75.0f);
                l2.lineTo(3.0f, 69.0f);
                l2.close();
                l2.moveTo(69.0f, 3.0f);
                l2.lineTo(75.0f, 3.0f);
                l2.lineTo(75.0f, 30.0f);
                l2.lineTo(69.0f, 30.0f);
                l2.lineTo(69.0f, 3.0f);
                l2.close();
                l2.moveTo(69.0f, 114.0f);
                l2.lineTo(75.0f, 114.0f);
                l2.lineTo(75.0f, 141.0f);
                l2.lineTo(69.0f, 141.0f);
                l2.lineTo(69.0f, 114.0f);
                l2.close();
                l2.moveTo(114.0f, 69.0f);
                l2.lineTo(141.0f, 69.0f);
                l2.lineTo(141.0f, 75.0f);
                l2.lineTo(114.0f, 75.0f);
                l2.lineTo(114.0f, 69.0f);
                l2.close();
                l2.moveTo(25.330952f, 21.088312f);
                l2.lineTo(44.422836f, 40.180195f);
                l2.lineTo(40.180195f, 44.422836f);
                l2.lineTo(21.088312f, 25.330952f);
                l2.lineTo(25.330952f, 21.088312f);
                l2.close();
                l2.moveTo(118.669044f, 21.088312f);
                l2.lineTo(122.91169f, 25.330952f);
                l2.lineTo(103.8198f, 44.422836f);
                l2.lineTo(99.57716f, 40.180195f);
                l2.lineTo(118.669044f, 21.088312f);
                l2.close();
                l2.moveTo(40.180195f, 99.57716f);
                l2.lineTo(44.422836f, 103.8198f);
                l2.lineTo(25.330952f, 122.91169f);
                l2.lineTo(21.088312f, 118.669044f);
                l2.lineTo(40.180195f, 99.57716f);
                l2.close();
                l2.moveTo(103.8198f, 99.57716f);
                l2.lineTo(122.91169f, 118.669044f);
                l2.lineTo(118.669044f, 122.91169f);
                l2.lineTo(99.57716f, 103.8198f);
                l2.lineTo(103.8198f, 99.57716f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
