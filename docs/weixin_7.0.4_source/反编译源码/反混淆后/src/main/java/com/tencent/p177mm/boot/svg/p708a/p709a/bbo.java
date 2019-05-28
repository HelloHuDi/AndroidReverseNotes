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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbo */
public final class bbo extends C5163c {
    private final int height = 14;
    private final int width = 14;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-5066062);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -140.0f, 0.0f, 1.0f, -747.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 143.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.429453f, 11.795271f);
                l.lineTo(15.915277f, 15.281094f);
                l.lineTo(15.19637f, 16.0f);
                l.lineTo(11.703301f, 12.506931f);
                l.cubicTo(10.678107f, 13.353059f, 9.3637495f, 13.861345f, 7.9306726f, 13.861345f);
                l.cubicTo(4.6552467f, 13.861345f, 2.0f, 11.206099f, 2.0f, 7.9306726f);
                l.cubicTo(2.0f, 4.6552467f, 4.6552467f, 2.0f, 7.9306726f, 2.0f);
                l.cubicTo(11.206099f, 2.0f, 13.861345f, 4.6552467f, 13.861345f, 7.9306726f);
                l.cubicTo(13.861345f, 9.406973f, 13.321936f, 10.757285f, 12.429453f, 11.795271f);
                l.close();
                l.moveTo(12.844656f, 7.930683f);
                l.cubicTo(12.844656f, 5.2167587f, 10.644594f, 3.0166972f, 7.9306703f, 3.0166972f);
                l.cubicTo(5.216746f, 3.0166972f, 3.016684f, 5.2167587f, 3.016684f, 7.930683f);
                l.cubicTo(3.016684f, 10.644608f, 5.216746f, 12.844669f, 7.9306703f, 12.844669f);
                l.cubicTo(10.644594f, 12.844669f, 12.844656f, 10.644608f, 12.844656f, 7.930683f);
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
