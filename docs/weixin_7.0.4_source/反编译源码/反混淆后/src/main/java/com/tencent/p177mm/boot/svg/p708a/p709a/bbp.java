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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbp */
public final class bbp extends C5163c {
    private final int height = 14;
    private final int width = 16;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 16;
            case 1:
                return 14;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Paint a2 = C5163c.m7876a(k2, looper);
                a.setColor(-5066062);
                a2.setColor(-5066062);
                a2.setStrokeWidth(0.5f);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -330.0f, 0.0f, 1.0f, -672.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 263.0f, 0.0f, 1.0f, 68.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.6499178f, 12.45301f);
                l.cubicTo(1.6374226f, 12.45301f, 0.0f, 10.992746f, 0.0f, 9.19892f);
                l.cubicTo(0.0f, 7.617091f, 1.2467835f, 6.2798753f, 2.9635198f, 6.019696f);
                l.cubicTo(2.9635198f, 6.019696f, 3.25409f, 5.993011f, 3.3000476f, 6.226505f);
                l.cubicTo(3.357865f, 6.519299f, 2.9731562f, 6.577858f, 2.7404034f, 6.6356754f);
                l.cubicTo(1.4365437f, 6.9499655f, 0.5218404f, 8.0047655f, 0.5218404f, 9.19892f);
                l.cubicTo(0.5218404f, 10.683645f, 1.9072378f, 11.891142f, 3.6106317f, 11.891142f);
                l.cubicTo(5.3140254f, 11.891142f, 6.699423f, 10.683645f, 6.699423f, 9.19892f);
                l.lineTo(6.699423f, 3.2533488f);
                l.cubicTo(6.699423f, 1.4587811f, 8.336845f, 0.0f, 10.34934f, 0.0f);
                l.cubicTo(12.361836f, 0.0f, 14.0f, 1.4587811f, 14.0f, 3.2533488f);
                l.cubicTo(14.0f, 4.8462963f, 12.805845f, 6.1449676f, 11.04834f, 6.4711175f);
                l.cubicTo(10.7644415f, 6.5237465f, 10.430879f, 6.110129f, 11.246995f, 5.859586f);
                l.cubicTo(12.561974f, 5.4556046f, 13.477418f, 4.490496f, 13.477418f, 3.2533488f);
                l.cubicTo(13.477418f, 1.768624f, 12.092762f, 0.5611267f, 10.389368f, 0.5611267f);
                l.cubicTo(8.685974f, 0.5611267f, 7.301318f, 1.768624f, 7.301318f, 3.2533488f);
                l.lineTo(7.301318f, 9.19892f);
                l.cubicTo(7.301318f, 10.992746f, 5.6638956f, 12.45301f, 3.6499178f, 12.45301f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
