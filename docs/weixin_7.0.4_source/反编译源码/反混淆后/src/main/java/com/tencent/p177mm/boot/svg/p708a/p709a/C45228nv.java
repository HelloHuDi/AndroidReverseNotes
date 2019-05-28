package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.nv */
public final class C45228nv extends C5163c {
    private final int height = C19395n.CTRL_INDEX;
    private final int width = C19395n.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C19395n.CTRL_INDEX;
            case 1:
                return C19395n.CTRL_INDEX;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-921103);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(136.0f, 0.0f);
                l.lineTo(136.0f, 136.0f);
                l.lineTo(0.0f, 136.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 42.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-3552823);
                a2.setStrokeWidth(3.0f);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(1.5f, 6.0f);
                l2.cubicTo(1.5f, 3.5147185f, 3.5147185f, 1.5f, 6.0f, 1.5f);
                l2.lineTo(63.0f, 1.5f);
                l2.cubicTo(65.48528f, 1.5f, 67.5f, 3.5147185f, 67.5f, 6.0f);
                l2.lineTo(67.5f, 47.0f);
                l2.cubicTo(67.5f, 49.485283f, 65.48528f, 51.5f, 63.0f, 51.5f);
                l2.lineTo(6.0f, 51.5f);
                l2.cubicTo(3.5147185f, 51.5f, 1.5f, 49.485283f, 1.5f, 47.0f);
                l2.lineTo(1.5f, 6.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-3552823);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(2.0f, 40.47622f);
                l3.lineTo(23.9226f, 20.0f);
                l3.lineTo(48.016544f, 43.06765f);
                l3.lineTo(44.84195f, 35.311966f);
                l3.lineTo(54.734417f, 27.538553f);
                l3.lineTo(68.0f, 40.47622f);
                l3.lineTo(68.0f, 50.245495f);
                l3.lineTo(2.0f, 50.245495f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 2);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
