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

/* renamed from: com.tencent.mm.boot.svg.a.a.arl */
public final class arl extends C5163c {
    private final int height = 78;
    private final int width = 38;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 78;
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
                a.setColor(-16139513);
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 14.0f);
                l.lineTo(38.0f, 14.0f);
                l.lineTo(38.0f, 17.0f);
                l.lineTo(0.0f, 17.0f);
                l.lineTo(0.0f, 14.0f);
                l.close();
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(28.086956f, 36.567226f);
                l2.lineTo(38.0f, 29.382353f);
                l2.lineTo(0.0f, 29.382353f);
                l2.lineTo(9.913043f, 36.567226f);
                l2.lineTo(9.913043f, 78.0f);
                l2.lineTo(28.086956f, 78.0f);
                l2.lineTo(28.086956f, 36.567226f);
                l2.close();
                l2.moveTo(0.0f, 21.0f);
                l2.lineTo(38.0f, 21.0f);
                l2.lineTo(38.0f, 29.382353f);
                l2.lineTo(0.0f, 29.382353f);
                l2.lineTo(0.0f, 21.0f);
                l2.close();
                l2.moveTo(19.0f, 41.117645f);
                l2.cubicTo(20.368706f, 41.117645f, 21.47826f, 39.991776f, 21.47826f, 38.60294f);
                l2.cubicTo(21.47826f, 37.214108f, 20.368706f, 36.088234f, 19.0f, 36.088234f);
                l2.cubicTo(17.631294f, 36.088234f, 16.52174f, 37.214108f, 16.52174f, 38.60294f);
                l2.cubicTo(16.52174f, 39.991776f, 17.631294f, 41.117645f, 19.0f, 41.117645f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 3.257143f, 0.0f, 1.0f, 0.272208f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                k2 = C5163c.m7876a(a, looper);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(14.914286f, 0.0f);
                l3.lineTo(16.571428f, 0.0f);
                l3.lineTo(16.571428f, 8.339977f);
                l3.lineTo(14.914286f, 8.339977f);
                l3.lineTo(14.914286f, 0.0f);
                l3.close();
                canvas.drawPath(l3, k2);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a3 = C5163c.m7878a(a3, -0.70710677f, -0.70710677f, 51.878563f, -0.70710677f, 0.70710677f, 21.488804f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                l = C5163c.m7884l(looper);
                l.moveTo(26.958014f, 2.9486272f);
                l.lineTo(28.615156f, 2.9486272f);
                l.lineTo(28.615156f, 9.620609f);
                l.lineTo(26.958014f, 9.620609f);
                l.lineTo(26.958014f, 2.9486272f);
                l.close();
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(a, looper);
                a3 = C5163c.m7878a(a3, 0.70710677f, 0.70710677f, -3.360446f, -0.70710677f, 0.70710677f, 4.4564013f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(2.8705575f, 2.9486272f);
                l2.lineTo(4.5277004f, 2.9486272f);
                l2.lineTo(4.5277004f, 9.620609f);
                l2.lineTo(2.8705575f, 9.620609f);
                l2.lineTo(2.8705575f, 2.9486272f);
                l2.close();
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
