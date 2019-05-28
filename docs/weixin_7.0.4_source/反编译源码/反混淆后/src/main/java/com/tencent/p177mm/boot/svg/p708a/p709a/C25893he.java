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

/* renamed from: com.tencent.mm.boot.svg.a.a.he */
public final class C25893he extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(-372399);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                l.lineTo(120.0f, 108.0f);
                l.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                l.lineTo(12.0f, 120.0f);
                l.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 41.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(56.837322f, 34.38223f);
                l.lineTo(56.837322f, 4.36973f);
                l.lineTo(14.724756f, 4.36973f);
                l.lineTo(14.724756f, 34.38223f);
                l.lineTo(56.837322f, 34.38223f);
                l.close();
                l.moveTo(10.331462f, 1.1368684E-13f);
                l.lineTo(61.230618f, 1.1368684E-13f);
                l.lineTo(61.230618f, 38.7517f);
                l.lineTo(10.331462f, 38.7517f);
                l.lineTo(10.331462f, 1.1368684E-13f);
                l.close();
                l.moveTo(4.393229f, 38.7517f);
                l.lineTo(1.6966473f, 38.7517f);
                l.cubicTo(2.2737368E-13f, 38.7517f, 2.2746995E-13f, 37.909233f, 2.2746995E-13f, 37.909233f);
                l.lineTo(2.489629f, 0.842595f);
                l.cubicTo(2.515041f, 0.3670758f, 2.9129448f, -0.00428691f, 3.3924437f, -9.633928E-14f);
                l.lineTo(6.938233f, -3.6742225E-5f);
                l.lineTo(4.393229f, 38.7517f);
                l.close();
                l.moveTo(67.16885f, 38.7517f);
                l.lineTo(64.62385f, -3.6742225E-5f);
                l.lineTo(68.16964f, -9.633928E-14f);
                l.cubicTo(68.64913f, -0.00428691f, 69.047035f, 0.3670758f, 69.07245f, 0.842595f);
                l.lineTo(71.56208f, 37.909233f);
                l.cubicTo(71.56208f, 37.909233f, 71.56208f, 38.7517f, 69.86543f, 38.7517f);
                l.lineTo(67.16885f, 38.7517f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
