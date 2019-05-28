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

/* renamed from: com.tencent.mm.boot.svg.a.a.alp */
public final class alp extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-15028967);
                a2.setStrokeWidth(3.6f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(21.0f, 11.55f);
                l.lineTo(63.0f, 11.55f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-15028967);
                a2.setStrokeWidth(3.6f);
                l = C5163c.m7884l(looper);
                l.moveTo(21.0f, 31.8f);
                l.lineTo(63.0f, 31.8f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-15028967);
                a2.setStrokeWidth(3.6f);
                l = C5163c.m7884l(looper);
                l.moveTo(21.0f, 52.05f);
                l.lineTo(63.0f, 52.05f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-15028967);
                l = C5163c.m7884l(looper);
                l.moveTo(5.0906253f, 18.0f);
                l.lineTo(5.0906253f, 7.06875f);
                l.lineTo(5.034375f, 7.06875f);
                l.lineTo(1.584375f, 9.45f);
                l.lineTo(1.584375f, 6.8999996f);
                l.lineTo(5.08125f, 4.4718747f);
                l.lineTo(7.89375f, 4.4718747f);
                l.lineTo(7.89375f, 18.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(k, looper);
                a3.setColor(-15028967);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(6.375f, 27.75f);
                l2.cubicTo(8.238961f, 27.75f, 9.75f, 29.26104f, 9.75f, 31.125f);
                l2.cubicTo(9.75f, 32.98896f, 8.238961f, 34.5f, 6.375f, 34.5f);
                l2.cubicTo(4.511039f, 34.5f, 3.0f, 32.98896f, 3.0f, 31.125f);
                l2.cubicTo(3.0f, 29.26104f, 4.511039f, 27.75f, 6.375f, 27.75f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(k, looper);
                a2.setColor(-15028967);
                l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 48.0f);
                l.lineTo(9.75f, 48.0f);
                l.lineTo(9.75f, 54.75f);
                l.lineTo(3.0f, 54.75f);
                l.lineTo(3.0f, 48.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
