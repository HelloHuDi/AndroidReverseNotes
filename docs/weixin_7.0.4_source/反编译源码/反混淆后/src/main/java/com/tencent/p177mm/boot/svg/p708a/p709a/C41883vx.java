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

/* renamed from: com.tencent.mm.boot.svg.a.a.vx */
public final class C41883vx extends C5163c {
    private final int height = 60;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 60;
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
                a.setColor(117440512);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(84.0f, 0.0f);
                l.cubicTo(90.62742f, 0.0f, 96.0f, 5.3725824f, 96.0f, 12.0f);
                l.lineTo(96.0f, 48.0f);
                l.cubicTo(96.0f, 54.62742f, 90.62742f, 60.0f, 84.0f, 60.0f);
                l.lineTo(12.0f, 60.0f);
                l.cubicTo(5.3725824f, 60.0f, 0.0f, 54.62742f, 0.0f, 48.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-11048043);
                l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 36.0f);
                l.cubicTo(32.68629f, 36.0f, 30.0f, 33.31371f, 30.0f, 30.0f);
                l.cubicTo(30.0f, 26.68629f, 32.68629f, 24.0f, 36.0f, 24.0f);
                l.cubicTo(39.31371f, 24.0f, 42.0f, 26.68629f, 42.0f, 30.0f);
                l.cubicTo(42.0f, 33.31371f, 39.31371f, 36.0f, 36.0f, 36.0f);
                l.close();
                l.moveTo(60.0f, 36.0f);
                l.cubicTo(56.68629f, 36.0f, 54.0f, 33.31371f, 54.0f, 30.0f);
                l.cubicTo(54.0f, 26.68629f, 56.68629f, 24.0f, 60.0f, 24.0f);
                l.cubicTo(63.31371f, 24.0f, 66.0f, 26.68629f, 66.0f, 30.0f);
                l.cubicTo(66.0f, 33.31371f, 63.31371f, 36.0f, 60.0f, 36.0f);
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
