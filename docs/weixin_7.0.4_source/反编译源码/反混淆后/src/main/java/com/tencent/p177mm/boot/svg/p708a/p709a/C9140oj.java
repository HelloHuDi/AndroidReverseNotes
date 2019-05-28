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

/* renamed from: com.tencent.mm.boot.svg.a.a.oj */
public final class C9140oj extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.lineTo(60.0f, 60.0f);
                l.lineTo(0.0f, 60.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-5592406);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 6.0f);
                l2.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0f, 0.0f);
                l2.lineTo(42.0f, 0.0f);
                l2.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0f);
                l2.lineTo(48.0f, 42.0f);
                l2.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 42.0f, 48.0f);
                l2.lineTo(6.0f, 48.0f);
                l2.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 42.0f);
                l2.lineTo(0.0f, 6.0f);
                l2.lineTo(0.0f, 6.0f);
                l2.close();
                l2.moveTo(3.0f, 5.0f);
                l2.cubicTo(3.0f, 3.9389288f, 3.936117f, 3.0f, 5.0f, 3.0f);
                l2.lineTo(43.0f, 3.0f);
                l2.cubicTo(44.06107f, 3.0f, 45.0f, 3.936117f, 45.0f, 5.0f);
                l2.lineTo(45.0f, 43.0f);
                l2.cubicTo(45.0f, 44.06107f, 44.063885f, 45.0f, 43.0f, 45.0f);
                l2.lineTo(5.0f, 45.0f);
                l2.cubicTo(3.9389288f, 45.0f, 3.0f, 44.063885f, 3.0f, 43.0f);
                l2.lineTo(3.0f, 5.0f);
                l2.lineTo(3.0f, 5.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
