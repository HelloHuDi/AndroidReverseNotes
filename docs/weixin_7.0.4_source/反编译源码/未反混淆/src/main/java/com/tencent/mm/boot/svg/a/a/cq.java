package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import org.xwalk.core.XWalkEnvironment;

public final class cq extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-855310);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 0.70710677f, -0.70710677f, 55.691124f, 0.70710677f, 0.70710677f, 21.750002f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(0.0f, 33.0f);
                l2.lineTo(3.75f, 33.0f);
                l2.lineTo(3.75f, 39.0f);
                l2.cubicTo(3.75f, 41.899494f, 6.100505f, 44.25f, 9.0f, 44.25f);
                l2.cubicTo(11.899495f, 44.25f, 14.25f, 41.899494f, 14.25f, 39.0f);
                l2.lineTo(14.25f, 27.0f);
                l2.cubicTo(14.25f, 24.100506f, 11.899495f, 21.75f, 9.0f, 21.75f);
                l2.lineTo(9.0f, 18.0f);
                l2.cubicTo(13.970563f, 18.0f, 18.0f, 22.029438f, 18.0f, 27.0f);
                l2.lineTo(18.0f, 39.0f);
                l2.cubicTo(18.0f, 43.970562f, 13.970563f, 48.0f, 9.0f, 48.0f);
                l2.cubicTo(4.029437f, 48.0f, 0.0f, 43.970562f, 0.0f, 39.0f);
                l2.lineTo(0.0f, 33.0f);
                l2.close();
                l2.moveTo(0.0f, 33.0f);
                l2.lineTo(3.75f, 33.0f);
                l2.lineTo(3.75f, 39.0f);
                l2.cubicTo(3.75f, 41.899494f, 6.100505f, 44.25f, 9.0f, 44.25f);
                l2.cubicTo(11.899495f, 44.25f, 14.25f, 41.899494f, 14.25f, 39.0f);
                l2.lineTo(14.25f, 27.0f);
                l2.cubicTo(14.25f, 24.100506f, 11.899495f, 21.75f, 9.0f, 21.75f);
                l2.lineTo(9.0f, 18.0f);
                l2.cubicTo(13.970563f, 18.0f, 18.0f, 22.029438f, 18.0f, 27.0f);
                l2.lineTo(18.0f, 39.0f);
                l2.cubicTo(18.0f, 43.970562f, 13.970563f, 48.0f, 9.0f, 48.0f);
                l2.cubicTo(4.029437f, 48.0f, 0.0f, 43.970562f, 0.0f, 39.0f);
                l2.lineTo(0.0f, 33.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l2 = c.l(looper);
                l2.moveTo(18.0f, 15.0f);
                l2.lineTo(14.25f, 15.0f);
                l2.lineTo(14.25f, 9.0f);
                l2.cubicTo(14.25f, 6.100505f, 11.899495f, 3.75f, 9.0f, 3.75f);
                l2.cubicTo(6.100505f, 3.75f, 3.75f, 6.100505f, 3.75f, 9.0f);
                l2.lineTo(3.75f, 21.0f);
                l2.cubicTo(3.75f, 23.899494f, 6.100505f, 26.25f, 9.0f, 26.25f);
                l2.lineTo(9.0f, 30.0f);
                l2.cubicTo(4.029437f, 30.0f, 0.0f, 25.970562f, 0.0f, 21.0f);
                l2.lineTo(0.0f, 9.0f);
                l2.cubicTo(0.0f, 4.029437f, 4.029437f, 9.130776E-16f, 9.0f, 0.0f);
                l2.cubicTo(13.970563f, -9.130776E-16f, 18.0f, 4.029437f, 18.0f, 9.0f);
                l2.lineTo(18.0f, 15.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
