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

/* renamed from: com.tencent.mm.boot.svg.a.a.kk */
public final class C37558kk extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-8683387);
                Path l = C5163c.m7884l(looper);
                l.moveTo(53.089928f, 45.616577f);
                l.lineTo(53.623455f, 47.1627f);
                l.cubicTo(53.623455f, 47.1627f, 53.01152f, 44.28202f, 54.975307f, 42.67076f);
                l.cubicTo(54.863106f, 42.752514f, 54.75811f, 42.829773f, 54.656723f, 42.90524f);
                l.lineTo(73.0f, 26.94896f);
                l.lineTo(48.666668f, 26.94896f);
                l.cubicTo(48.666668f, 26.94896f, 45.512344f, 26.898201f, 45.06173f, 24.253796f);
                l.cubicTo(45.0784f, 24.353516f, 45.093723f, 24.444702f, 45.109043f, 24.537237f);
                l.lineTo(36.420692f, 0.0f);
                l.lineTo(27.904024f, 24.459076f);
                l.cubicTo(27.915741f, 24.39035f, 27.926556f, 24.326115f, 27.938272f, 24.253796f);
                l.cubicTo(27.916191f, 24.383163f, 27.882845f, 24.5013f, 27.848598f, 24.61854f);
                l.lineTo(27.758926f, 24.875479f);
                l.cubicTo(26.960882f, 26.899998f, 24.333334f, 26.94896f, 24.333334f, 26.94896f);
                l.lineTo(0.0f, 26.94896f);
                l.lineTo(18.472155f, 43.11681f);
                l.cubicTo(19.523445f, 44.34356f, 19.512178f, 45.986263f, 19.435574f, 46.74495f);
                l.lineTo(11.566444f, 71.87288f);
                l.lineTo(34.679054f, 56.182972f);
                l.lineTo(34.246914f, 56.59578f);
                l.cubicTo(34.246914f, 56.59578f, 36.448177f, 54.918938f, 38.753086f, 56.59578f);
                l.cubicTo(38.745876f, 56.588593f, 38.740017f, 56.583202f, 38.732807f, 56.57557f);
                l.lineTo(61.149216f, 72.0f);
                l.lineTo(53.089928f, 45.616577f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
