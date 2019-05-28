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

public final class lb extends c {
    private final int height = 102;
    private final int width = 102;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -1766.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(2716.0f, 1819.1445f);
                l.lineTo(2716.0f, 1793.4993f);
                l.cubicTo(2716.0f, 1792.396f, 2715.1057f, 1791.5f, 2714.0024f, 1791.5f);
                l.lineTo(2675.9976f, 1791.5f);
                l.cubicTo(2674.8967f, 1791.5f, 2674.0f, 1792.3951f, 2674.0f, 1793.4993f);
                l.lineTo(2674.0f, 1840.5007f);
                l.cubicTo(2674.0f, 1841.604f, 2674.8943f, 1842.5f, 2675.9976f, 1842.5f);
                l.lineTo(2714.0024f, 1842.5f);
                l.cubicTo(2715.1033f, 1842.5f, 2716.0f, 1841.6049f, 2716.0f, 1840.5007f);
                l.lineTo(2716.0f, 1821.9503f);
                l.lineTo(2694.9534f, 1833.2782f);
                l.lineTo(2694.801f, 1833.36f);
                l.cubicTo(2694.6123f, 1833.4487f, 2694.3997f, 1833.5f, 2694.1743f, 1833.5f);
                l.cubicTo(2693.6523f, 1833.5f, 2693.1985f, 1833.2317f, 2692.96f, 1832.836f);
                l.lineTo(2692.8687f, 1832.6495f);
                l.lineTo(2689.067f, 1824.8727f);
                l.cubicTo(2689.0254f, 1824.7877f, 2689.0f, 1824.692f, 2689.0f, 1824.5991f);
                l.cubicTo(2689.0f, 1824.241f, 2689.3118f, 1823.9498f, 2689.6965f, 1823.9498f);
                l.cubicTo(2689.8528f, 1823.9498f, 2689.9968f, 1823.9979f, 2690.113f, 1824.0787f);
                l.lineTo(2694.5994f, 1827.0565f);
                l.cubicTo(2694.9272f, 1827.2567f, 2695.3188f, 1827.3739f, 2695.74f, 1827.3739f);
                l.cubicTo(2695.991f, 1827.3739f, 2696.2307f, 1827.3301f, 2696.4539f, 1827.2546f);
                l.lineTo(2716.0f, 1819.1445f);
                l.close();
                l.moveTo(2695.0f, 1868.0f);
                l.cubicTo(2666.8335f, 1868.0f, 2644.0f, 1845.1665f, 2644.0f, 1817.0f);
                l.cubicTo(2644.0f, 1788.8335f, 2666.8335f, 1766.0f, 2695.0f, 1766.0f);
                l.cubicTo(2723.1665f, 1766.0f, 2746.0f, 1788.8335f, 2746.0f, 1817.0f);
                l.cubicTo(2746.0f, 1845.1665f, 2723.1665f, 1868.0f, 2695.0f, 1868.0f);
                l.close();
                l.moveTo(2695.0f, 1865.0f);
                l.cubicTo(2668.4902f, 1865.0f, 2647.0f, 1843.5096f, 2647.0f, 1817.0f);
                l.cubicTo(2647.0f, 1790.4904f, 2668.4902f, 1769.0f, 2695.0f, 1769.0f);
                l.cubicTo(2721.5098f, 1769.0f, 2743.0f, 1790.4904f, 2743.0f, 1817.0f);
                l.cubicTo(2743.0f, 1843.5096f, 2721.5098f, 1865.0f, 2695.0f, 1865.0f);
                l.close();
                l.moveTo(2681.5f, 1799.0f);
                l.lineTo(2696.5f, 1799.0f);
                l.lineTo(2696.5f, 1802.0f);
                l.lineTo(2681.5f, 1802.0f);
                l.lineTo(2681.5f, 1799.0f);
                l.close();
                l.moveTo(2681.5f, 1806.5f);
                l.lineTo(2696.5f, 1806.5f);
                l.lineTo(2696.5f, 1809.5f);
                l.lineTo(2681.5f, 1809.5f);
                l.lineTo(2681.5f, 1806.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
