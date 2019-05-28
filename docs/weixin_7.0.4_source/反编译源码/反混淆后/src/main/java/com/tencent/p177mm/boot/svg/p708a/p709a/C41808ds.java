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

/* renamed from: com.tencent.mm.boot.svg.a.a.ds */
public final class C41808ds extends C5163c {
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
                l.moveTo(36.0f, 0.0f);
                l.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                l.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                l.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                l.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-372399);
                l = C5163c.m7884l(looper);
                l.moveTo(23.48519f, 27.72783f);
                l.cubicTo(21.91463f, 30.099129f, 21.0f, 32.942753f, 21.0f, 36.0f);
                l.cubicTo(21.0f, 44.28427f, 27.715729f, 51.0f, 36.0f, 51.0f);
                l.cubicTo(39.057247f, 51.0f, 41.90087f, 50.08537f, 44.27217f, 48.51481f);
                l.lineTo(23.48519f, 27.72783f);
                l.close();
                l.moveTo(27.72783f, 23.48519f);
                l.lineTo(48.51481f, 44.27217f);
                l.cubicTo(50.08537f, 41.90087f, 51.0f, 39.057247f, 51.0f, 36.0f);
                l.cubicTo(51.0f, 27.715729f, 44.28427f, 21.0f, 36.0f, 21.0f);
                l.cubicTo(32.942753f, 21.0f, 30.099129f, 21.91463f, 27.72783f, 23.48519f);
                l.close();
                l.moveTo(36.0f, 57.0f);
                l.cubicTo(24.40202f, 57.0f, 15.0f, 47.59798f, 15.0f, 36.0f);
                l.cubicTo(15.0f, 24.40202f, 24.40202f, 15.0f, 36.0f, 15.0f);
                l.cubicTo(47.59798f, 15.0f, 57.0f, 24.40202f, 57.0f, 36.0f);
                l.cubicTo(57.0f, 47.59798f, 47.59798f, 57.0f, 36.0f, 57.0f);
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
