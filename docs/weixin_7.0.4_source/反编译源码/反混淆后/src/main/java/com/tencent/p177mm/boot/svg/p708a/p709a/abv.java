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

/* renamed from: com.tencent.mm.boot.svg.a.a.abv */
public final class abv extends C5163c {
    private final int height = 24;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                a.setColor(-436207616);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.0f, 0.0f);
                l.cubicTo(4.5f, 0.0f, 0.0f, 4.5f, 0.0f, 10.0f);
                l.cubicTo(0.0f, 15.5f, 4.5f, 20.0f, 10.0f, 20.0f);
                l.cubicTo(15.5f, 20.0f, 20.0f, 15.5f, 20.0f, 10.0f);
                l.cubicTo(20.0f, 4.5f, 15.5f, 0.0f, 10.0f, 0.0f);
                l.close();
                l.moveTo(18.0f, 6.3f);
                l.lineTo(14.2f, 10.0f);
                l.cubicTo(14.2f, 10.0f, 14.2f, 10.0f, 14.2f, 10.0f);
                l.lineTo(14.2f, 2.3f);
                l.cubicTo(15.8f, 3.2f, 17.2f, 4.6f, 18.0f, 6.3f);
                l.close();
                l.moveTo(12.1f, 12.1f);
                l.cubicTo(11.6f, 12.7f, 10.8f, 13.0f, 10.0f, 13.0f);
                l.cubicTo(9.2f, 13.0f, 8.4f, 12.7f, 7.9f, 12.1f);
                l.lineTo(7.9f, 12.1f);
                l.lineTo(7.9f, 12.1f);
                l.cubicTo(7.3f, 11.6f, 7.0f, 10.8f, 7.0f, 10.0f);
                l.cubicTo(7.0f, 8.3f, 8.3f, 7.0f, 10.0f, 7.0f);
                l.cubicTo(11.7f, 7.0f, 13.0f, 8.3f, 13.0f, 10.0f);
                l.cubicTo(13.0f, 10.8f, 12.7f, 11.6f, 12.1f, 12.1f);
                l.lineTo(12.1f, 12.1f);
                l.lineTo(12.1f, 12.1f);
                l.close();
                l.moveTo(13.0f, 1.7f);
                l.lineTo(13.0f, 7.0f);
                l.cubicTo(13.0f, 7.0f, 13.0f, 7.0f, 13.0f, 7.0f);
                l.lineTo(13.0f, 7.0f);
                l.lineTo(7.5f, 1.6f);
                l.cubicTo(8.3f, 1.4f, 9.1f, 1.2f, 10.0f, 1.2f);
                l.cubicTo(11.1f, 1.2f, 12.1f, 1.4f, 13.0f, 1.7f);
                l.close();
                l.moveTo(6.3f, 2.0f);
                l.lineTo(10.0f, 5.8f);
                l.cubicTo(10.0f, 5.8f, 10.0f, 5.8f, 10.0f, 5.8f);
                l.lineTo(2.3f, 5.8f);
                l.cubicTo(3.2f, 4.2f, 4.6f, 2.8f, 6.3f, 2.0f);
                l.close();
                l.moveTo(1.7f, 7.0f);
                l.lineTo(7.0f, 7.0f);
                l.cubicTo(7.0f, 7.0f, 7.0f, 7.0f, 7.0f, 7.0f);
                l.lineTo(7.0f, 7.0f);
                l.lineTo(1.5f, 12.5f);
                l.cubicTo(1.3f, 11.7f, 1.1f, 10.9f, 1.1f, 10.0f);
                l.cubicTo(1.2f, 8.9f, 1.4f, 7.9f, 1.7f, 7.0f);
                l.close();
                l.moveTo(2.0f, 13.7f);
                l.lineTo(5.8f, 10.0f);
                l.cubicTo(5.8f, 10.0f, 5.8f, 10.0f, 5.8f, 10.0f);
                l.lineTo(5.8f, 17.7f);
                l.cubicTo(4.2f, 16.8f, 2.8f, 15.4f, 2.0f, 13.7f);
                l.close();
                l.moveTo(7.0f, 18.3f);
                l.lineTo(7.0f, 13.0f);
                l.cubicTo(7.0f, 13.0f, 7.0f, 13.0f, 7.0f, 13.0f);
                l.lineTo(7.0f, 13.0f);
                l.lineTo(12.5f, 18.5f);
                l.cubicTo(11.7f, 18.7f, 10.9f, 18.9f, 10.0f, 18.9f);
                l.cubicTo(8.9f, 18.8f, 7.9f, 18.6f, 7.0f, 18.3f);
                l.close();
                l.moveTo(13.7f, 18.0f);
                l.lineTo(10.0f, 14.2f);
                l.cubicTo(10.0f, 14.2f, 10.0f, 14.2f, 10.0f, 14.2f);
                l.lineTo(17.7f, 14.2f);
                l.cubicTo(16.8f, 15.8f, 15.4f, 17.2f, 13.7f, 18.0f);
                l.close();
                l.moveTo(18.3f, 13.0f);
                l.lineTo(13.0f, 13.0f);
                l.cubicTo(13.0f, 13.0f, 13.0f, 13.0f, 13.0f, 13.0f);
                l.lineTo(13.0f, 13.0f);
                l.lineTo(18.5f, 7.5f);
                l.cubicTo(18.7f, 8.3f, 18.9f, 9.1f, 18.9f, 10.0f);
                l.cubicTo(18.8f, 11.1f, 18.6f, 12.1f, 18.3f, 13.0f);
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
