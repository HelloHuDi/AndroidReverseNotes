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

public final class ch extends c {
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
                g = c.a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 27.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(44.0f, 21.962822f);
                l2.lineTo(44.0f, 4.0f);
                l2.lineTo(4.0f, 4.0f);
                l2.lineTo(4.0f, 20.913124f);
                l2.lineTo(14.878189f, 12.518221f);
                l2.cubicTo(15.9883175f, 11.620444f, 17.771101f, 11.663985f, 18.841188f, 12.6042f);
                l2.lineTo(29.616116f, 22.07142f);
                l2.lineTo(35.061848f, 17.385994f);
                l2.cubicTo(36.17116f, 16.44265f, 37.936134f, 16.461815f, 39.013035f, 17.428202f);
                l2.lineTo(44.0f, 21.962822f);
                l2.close();
                l2.moveTo(44.0f, 29.16303f);
                l2.lineTo(44.0f, 27.369196f);
                l2.lineTo(36.995003f, 20.999496f);
                l2.lineTo(32.650444f, 24.737488f);
                l2.lineTo(34.997852f, 26.8f);
                l2.lineTo(28.937702f, 26.8f);
                l2.lineTo(16.771114f, 16.110018f);
                l2.lineTo(4.0f, 25.965727f);
                l2.lineTo(4.0f, 32.0f);
                l2.lineTo(44.0f, 32.0f);
                l2.lineTo(44.0f, 29.16303f);
                l2.close();
                l2.moveTo(-2.220446E-15f, 2.4f);
                l2.cubicTo(-2.382771E-15f, 1.0745167f, 1.0745167f, 2.4348735E-16f, 2.4f, 0.0f);
                l2.lineTo(45.6f, -2.220446E-15f);
                l2.cubicTo(46.925484f, -2.4639335E-15f, 48.0f, 1.0745167f, 48.0f, 2.4f);
                l2.lineTo(48.0f, 33.6f);
                l2.cubicTo(48.0f, 34.925484f, 46.925484f, 36.0f, 45.6f, 36.0f);
                l2.lineTo(2.4f, 36.0f);
                l2.cubicTo(1.0745167f, 36.0f, 1.623249E-16f, 34.925484f, 0.0f, 33.6f);
                l2.lineTo(-2.220446E-15f, 2.4f);
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
