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

/* renamed from: com.tencent.mm.boot.svg.a.a.dz */
public final class C25881dz extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -921.0f, 0.0f, 1.0f, -39.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 921.0f, 0.0f, 1.0f, 39.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(855638016);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 60.0f);
                l.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                l.lineTo(120.0f, 60.0f);
                l.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                l.lineTo(60.0f, 120.0f);
                l.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                l.lineTo(0.0f, 60.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(40.5f, 60.75f);
                l.cubicTo(40.5f, 64.47735f, 37.47735f, 67.5f, 33.75f, 67.5f);
                l.cubicTo(30.02265f, 67.5f, 27.0f, 64.47735f, 27.0f, 60.75f);
                l.cubicTo(27.0f, 57.0213f, 30.02265f, 54.0f, 33.75f, 54.0f);
                l.cubicTo(37.47735f, 54.0f, 40.5f, 57.0213f, 40.5f, 60.75f);
                l.close();
                l.moveTo(59.25f, 49.5f);
                l.cubicTo(65.46225f, 49.5f, 70.5f, 54.5355f, 70.5f, 60.75f);
                l.cubicTo(70.5f, 66.96225f, 65.46225f, 72.0f, 59.25f, 72.0f);
                l.cubicTo(53.03775f, 72.0f, 48.0f, 66.96225f, 48.0f, 60.75f);
                l.cubicTo(48.0f, 54.5355f, 53.03775f, 49.5f, 59.25f, 49.5f);
                l.close();
                l.moveTo(93.0f, 60.75f);
                l.cubicTo(93.0f, 64.47735f, 89.97735f, 67.5f, 86.25f, 67.5f);
                l.cubicTo(82.52265f, 67.5f, 79.5f, 64.47735f, 79.5f, 60.75f);
                l.cubicTo(79.5f, 57.0213f, 82.52265f, 54.0f, 86.25f, 54.0f);
                l.cubicTo(89.97735f, 54.0f, 93.0f, 57.0213f, 93.0f, 60.75f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
