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

/* renamed from: com.tencent.mm.boot.svg.a.a.fc */
public final class C45200fc extends C5163c {
    private final int height = 20;
    private final int width = 20;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -20.0f, 0.0f, 1.0f, -194.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 80.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 83.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 31.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-772816);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.0f, 20.0f);
                l.cubicTo(15.522847f, 20.0f, 20.0f, 15.522847f, 20.0f, 10.0f);
                l.cubicTo(20.0f, 4.4771523f, 15.522847f, 0.0f, 10.0f, 0.0f);
                l.cubicTo(4.4771523f, 0.0f, 0.0f, 4.4771523f, 0.0f, 10.0f);
                l.cubicTo(0.0f, 15.522847f, 4.4771523f, 20.0f, 10.0f, 20.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(5.5f, 10.0f);
                l.cubicTo(5.5f, 9.723858f, 5.7238574f, 9.5f, 6.0f, 9.5f);
                l.lineTo(14.0f, 9.5f);
                l.cubicTo(14.276142f, 9.5f, 14.5f, 9.723858f, 14.5f, 10.0f);
                l.lineTo(14.5f, 10.0f);
                l.cubicTo(14.5f, 10.276142f, 14.276142f, 10.5f, 14.0f, 10.5f);
                l.lineTo(6.0f, 10.5f);
                l.cubicTo(5.7238574f, 10.5f, 5.5f, 10.276142f, 5.5f, 10.0f);
                l.lineTo(5.5f, 10.0f);
                l.close();
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
