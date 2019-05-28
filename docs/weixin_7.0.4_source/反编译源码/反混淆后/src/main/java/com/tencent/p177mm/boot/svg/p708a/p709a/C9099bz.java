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
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.boot.svg.a.a.bz */
public final class C9099bz extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-855310);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(29.25f, 16.59649f);
                l2.cubicTo(29.25f, 9.496691f, 23.53672f, 3.75f, 16.5f, 3.75f);
                l2.cubicTo(9.46328f, 3.75f, 3.75f, 9.496691f, 3.75f, 16.59649f);
                l2.cubicTo(3.75f, 23.03143f, 7.8978143f, 30.246017f, 16.5f, 38.14612f);
                l2.cubicTo(25.102188f, 30.246014f, 29.25f, 23.031427f, 29.25f, 16.59649f);
                l2.close();
                l2.moveTo(17.825495f, 41.99967f);
                l2.cubicTo(17.068739f, 42.66942f, 15.931266f, 42.66942f, 15.174507f, 41.999672f);
                l2.cubicTo(5.058169f, 33.046417f, 0.0f, 24.578691f, 0.0f, 16.59649f);
                l2.cubicTo(4.3587476E-16f, 7.4305024f, 7.3873014f, 0.0f, 16.5f, 0.0f);
                l2.cubicTo(25.612698f, 0.0f, 33.0f, 7.4305024f, 33.0f, 16.59649f);
                l2.cubicTo(33.0f, 24.57869f, 27.941832f, 33.046417f, 17.825495f, 41.99967f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(16.5f, 19.614035f);
                l2.cubicTo(18.156855f, 19.614035f, 19.5f, 18.263035f, 19.5f, 16.59649f);
                l2.cubicTo(19.5f, 14.929948f, 18.156855f, 13.578947f, 16.5f, 13.578947f);
                l2.cubicTo(14.843145f, 13.578947f, 13.5f, 14.929948f, 13.5f, 16.59649f);
                l2.cubicTo(13.5f, 18.263035f, 14.843145f, 19.614035f, 16.5f, 19.614035f);
                l2.close();
                l2.moveTo(16.5f, 23.364035f);
                l2.cubicTo(12.767167f, 23.364035f, 9.75f, 20.329224f, 9.75f, 16.59649f);
                l2.cubicTo(9.75f, 12.863759f, 12.767167f, 9.828947f, 16.5f, 9.828947f);
                l2.cubicTo(20.232832f, 9.828947f, 23.25f, 12.863759f, 23.25f, 16.59649f);
                l2.cubicTo(23.25f, 20.329224f, 20.232832f, 23.364035f, 16.5f, 23.364035f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
