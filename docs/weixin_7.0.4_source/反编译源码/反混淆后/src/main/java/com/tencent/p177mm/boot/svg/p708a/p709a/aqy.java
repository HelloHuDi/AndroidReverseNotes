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

/* renamed from: com.tencent.mm.boot.svg.a.a.aqy */
public final class aqy extends C5163c {
    private final int height = 63;
    private final int width = 63;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(5.0f, 5.0f);
                l.lineTo(5.0f, 34.0f);
                l.lineTo(34.0f, 34.0f);
                l.lineTo(34.0f, 5.0f);
                l.lineTo(5.0f, 5.0f);
                l.close();
                l.moveTo(0.0f, 1.5049495f);
                l.cubicTo(0.0f, 0.67378885f, 0.676918f, 0.0f, 1.5049495f, 0.0f);
                l.lineTo(37.495052f, 0.0f);
                l.cubicTo(38.32621f, 0.0f, 39.0f, 0.676918f, 39.0f, 1.5049495f);
                l.lineTo(39.0f, 37.495052f);
                l.cubicTo(39.0f, 38.32621f, 38.323082f, 39.0f, 37.495052f, 39.0f);
                l.lineTo(1.5049495f, 39.0f);
                l.cubicTo(0.67378885f, 39.0f, 0.0f, 38.323082f, 0.0f, 37.495052f);
                l.lineTo(0.0f, 1.5049495f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(52.925938f, 23.0f);
                l.cubicTo(52.974922f, 22.49169f, 53.0f, 21.976135f, 53.0f, 21.454546f);
                l.cubicTo(53.0f, 12.919235f, 46.28427f, 6.0f, 38.0f, 6.0f);
                l.cubicTo(35.866688f, 6.0f, 33.837387f, 6.4588375f, 32.0f, 7.285953f);
                l.lineTo(32.0f, 10.252686f);
                l.cubicTo(33.60105f, 9.50638f, 35.378433f, 9.090909f, 37.25f, 9.090909f);
                l.cubicTo(44.29163f, 9.090909f, 50.0f, 14.9722595f, 50.0f, 22.227272f);
                l.cubicTo(50.0f, 22.486673f, 49.992702f, 22.744318f, 49.978306f, 23.0f);
                l.lineTo(52.925938f, 23.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(35.0f, 0.0f);
                l2.lineTo(26.0f, 7.4431515f);
                l2.lineTo(34.865273f, 15.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
