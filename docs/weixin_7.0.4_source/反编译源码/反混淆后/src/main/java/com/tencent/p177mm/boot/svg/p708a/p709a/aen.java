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

/* renamed from: com.tencent.mm.boot.svg.a.a.aen */
public final class aen extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-5592406);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -70.0f, 0.0f, 1.0f, -199.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 69.0f, 0.0f, 1.0f, 98.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 101.67347f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 6.3265305f);
                l.cubicTo(0.0f, 2.9596574f, 2.6835413f, 0.3265306f, 6.0f, 0.3265306f);
                l.lineTo(42.0f, 0.3265306f);
                l.cubicTo(45.31085f, 0.3265306f, 48.0f, 2.9541647f, 48.0f, 6.3265305f);
                l.lineTo(48.0f, 41.32653f);
                l.cubicTo(48.0f, 44.693405f, 45.31646f, 47.32653f, 42.0f, 47.32653f);
                l.lineTo(6.0f, 47.32653f);
                l.cubicTo(2.6891508f, 47.32653f, 0.0f, 44.698895f, 0.0f, 41.32653f);
                l.lineTo(0.0f, 6.3265305f);
                l.lineTo(0.0f, 6.3265305f);
                l.close();
                l.moveTo(4.0f, 6.3265305f);
                l.cubicTo(4.0f, 5.198393f, 4.89154f, 4.3265305f, 6.0f, 4.3265305f);
                l.lineTo(42.0f, 4.3265305f);
                l.cubicTo(43.10578f, 4.3265305f, 44.0f, 5.195782f, 44.0f, 6.3265305f);
                l.lineTo(44.0f, 41.32653f);
                l.cubicTo(44.0f, 42.45467f, 43.10846f, 43.32653f, 42.0f, 43.32653f);
                l.lineTo(6.0f, 43.32653f);
                l.cubicTo(4.894218f, 43.32653f, 4.0f, 42.45728f, 4.0f, 41.32653f);
                l.lineTo(4.0f, 6.3265305f);
                l.lineTo(4.0f, 6.3265305f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
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
