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

/* renamed from: com.tencent.mm.boot.svg.a.a.aez */
public final class aez extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-16139513);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -345.0f, 0.0f, 1.0f, -473.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 403.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 305.0f, 0.0f, 1.0f, 70.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(60.0f, 30.37037f);
                l.cubicTo(60.0f, 46.56889f, 46.56889f, 60.0f, 29.62963f, 60.0f);
                l.cubicTo(13.431111f, 60.0f, 0.0f, 46.56889f, 0.0f, 30.37037f);
                l.cubicTo(0.0f, 13.431111f, 13.431111f, 0.0f, 29.62963f, 0.0f);
                l.cubicTo(46.56889f, 0.0f, 60.0f, 13.431111f, 60.0f, 30.37037f);
                l.close();
                l.moveTo(15.577749f, 32.460346f);
                l.lineTo(24.47927f, 41.67298f);
                l.cubicTo(24.862179f, 42.06927f, 25.488976f, 42.073776f, 25.882545f, 41.686443f);
                l.lineTo(46.24788f, 21.643913f);
                l.cubicTo(46.63556f, 21.26238f, 46.64444f, 20.630444f, 46.25456f, 20.2454f);
                l.lineTo(45.93083f, 19.92568f);
                l.cubicTo(45.543224f, 19.542885f, 44.883877f, 19.512583f, 44.46322f, 19.863024f);
                l.lineTo(25.932226f, 35.30084f);
                l.cubicTo(25.518642f, 35.64539f, 24.817387f, 35.66468f, 24.381721f, 35.33077f);
                l.lineTo(17.411554f, 29.988533f);
                l.cubicTo(16.979122f, 29.657099f, 16.359636f, 29.7419f, 16.035114f, 30.183472f);
                l.lineTo(15.474698f, 30.946018f);
                l.cubicTo(15.1507f, 31.386875f, 15.196312f, 32.06558f, 15.577749f, 32.460346f);
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
