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
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.boot.svg.a.a.gu */
public final class C37541gu extends C5163c {
    private final int height = 160;
    private final int width = C31128d.MIC_PTU_AUTOLEVEL;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C31128d.MIC_PTU_AUTOLEVEL;
            case 1:
                return 160;
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
                a.setColor(-15028967);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(212.0f, 0.0f);
                l.cubicTo(216.63023f, 5.5596924f, 222.31512f, 11.159097f, 228.0f, 16.0f);
                l.cubicTo(200.60638f, 43.807625f, 144.0f, 96.0f, 144.0f, 96.0f);
                l.cubicTo(144.0f, 96.0f, 103.635574f, 139.2875f, 84.0f, 160.0f);
                l.cubicTo(55.03448f, 132.87665f, 27.537401f, 105.75329f, 0.0f, 80.0f);
                l.cubicTo(5.6445622f, 72.9511f, 11.329443f, 67.31199f, 16.0f, 60.0f);
                l.cubicTo(38.94748f, 83.276245f, 60.719364f, 104.83991f, 84.0f, 128.0f);
                l.cubicTo(125.47056f, 84.22934f, 168.12732f, 42.0551f, 212.0f, 0.0f);
                l.lineTo(212.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
