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

/* renamed from: com.tencent.mm.boot.svg.a.a.ado */
public final class ado extends C5163c {
    private final int height = 75;
    private final int width = 75;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                k.setColor(-15028967);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(37.5f, 45.0f);
                l.cubicTo(41.642136f, 45.0f, 45.0f, 41.642136f, 45.0f, 37.5f);
                l.cubicTo(45.0f, 33.357864f, 41.642136f, 30.0f, 37.5f, 30.0f);
                l.cubicTo(33.357864f, 30.0f, 30.0f, 33.357864f, 30.0f, 37.5f);
                l.cubicTo(30.0f, 41.642136f, 33.357864f, 45.0f, 37.5f, 45.0f);
                l.close();
                l.moveTo(64.5f, 45.0f);
                l.cubicTo(68.642136f, 45.0f, 72.0f, 41.642136f, 72.0f, 37.5f);
                l.cubicTo(72.0f, 33.357864f, 68.642136f, 30.0f, 64.5f, 30.0f);
                l.cubicTo(60.357864f, 30.0f, 57.0f, 33.357864f, 57.0f, 37.5f);
                l.cubicTo(57.0f, 41.642136f, 60.357864f, 45.0f, 64.5f, 45.0f);
                l.close();
                l.moveTo(10.5f, 45.0f);
                l.cubicTo(14.642136f, 45.0f, 18.0f, 41.642136f, 18.0f, 37.5f);
                l.cubicTo(18.0f, 33.357864f, 14.642136f, 30.0f, 10.5f, 30.0f);
                l.cubicTo(6.3578644f, 30.0f, 3.0f, 33.357864f, 3.0f, 37.5f);
                l.cubicTo(3.0f, 41.642136f, 6.3578644f, 45.0f, 10.5f, 45.0f);
                l.close();
                l.moveTo(37.5f, 72.0f);
                l.cubicTo(41.642136f, 72.0f, 45.0f, 68.642136f, 45.0f, 64.5f);
                l.cubicTo(45.0f, 60.357864f, 41.642136f, 57.0f, 37.5f, 57.0f);
                l.cubicTo(33.357864f, 57.0f, 30.0f, 60.357864f, 30.0f, 64.5f);
                l.cubicTo(30.0f, 68.642136f, 33.357864f, 72.0f, 37.5f, 72.0f);
                l.close();
                l.moveTo(64.5f, 72.0f);
                l.cubicTo(68.642136f, 72.0f, 72.0f, 68.642136f, 72.0f, 64.5f);
                l.cubicTo(72.0f, 60.357864f, 68.642136f, 57.0f, 64.5f, 57.0f);
                l.cubicTo(60.357864f, 57.0f, 57.0f, 60.357864f, 57.0f, 64.5f);
                l.cubicTo(57.0f, 68.642136f, 60.357864f, 72.0f, 64.5f, 72.0f);
                l.close();
                l.moveTo(10.5f, 72.0f);
                l.cubicTo(14.642136f, 72.0f, 18.0f, 68.642136f, 18.0f, 64.5f);
                l.cubicTo(18.0f, 60.357864f, 14.642136f, 57.0f, 10.5f, 57.0f);
                l.cubicTo(6.3578644f, 57.0f, 3.0f, 60.357864f, 3.0f, 64.5f);
                l.cubicTo(3.0f, 68.642136f, 6.3578644f, 72.0f, 10.5f, 72.0f);
                l.close();
                l.moveTo(37.5f, 18.0f);
                l.cubicTo(41.642136f, 18.0f, 45.0f, 14.642136f, 45.0f, 10.5f);
                l.cubicTo(45.0f, 6.3578644f, 41.642136f, 3.0f, 37.5f, 3.0f);
                l.cubicTo(33.357864f, 3.0f, 30.0f, 6.3578644f, 30.0f, 10.5f);
                l.cubicTo(30.0f, 14.642136f, 33.357864f, 18.0f, 37.5f, 18.0f);
                l.close();
                l.moveTo(64.5f, 18.0f);
                l.cubicTo(68.642136f, 18.0f, 72.0f, 14.642136f, 72.0f, 10.5f);
                l.cubicTo(72.0f, 6.3578644f, 68.642136f, 3.0f, 64.5f, 3.0f);
                l.cubicTo(60.357864f, 3.0f, 57.0f, 6.3578644f, 57.0f, 10.5f);
                l.cubicTo(57.0f, 14.642136f, 60.357864f, 18.0f, 64.5f, 18.0f);
                l.close();
                l.moveTo(10.5f, 18.0f);
                l.cubicTo(14.642136f, 18.0f, 18.0f, 14.642136f, 18.0f, 10.5f);
                l.cubicTo(18.0f, 6.3578644f, 14.642136f, 3.0f, 10.5f, 3.0f);
                l.cubicTo(6.3578644f, 3.0f, 3.0f, 6.3578644f, 3.0f, 10.5f);
                l.cubicTo(3.0f, 14.642136f, 6.3578644f, 18.0f, 10.5f, 18.0f);
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
