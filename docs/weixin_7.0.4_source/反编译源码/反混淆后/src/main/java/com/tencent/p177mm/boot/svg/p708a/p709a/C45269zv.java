package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.zv */
public final class C45269zv extends C5163c {
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
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(28.5f, 65.05487f);
                l.lineTo(28.5f, 45.470562f);
                l.lineTo(46.96314f, 63.933704f);
                l.cubicTo(43.567234f, 65.26753f, 39.869156f, 66.0f, 36.0f, 66.0f);
                l.cubicTo(33.41025f, 66.0f, 30.89715f, 65.67185f, 28.5f, 65.05487f);
                l.close();
                l.moveTo(24.0f, 63.50374f);
                l.cubicTo(18.196375f, 60.968025f, 13.350096f, 56.649204f, 10.153644f, 51.239754f);
                l.lineTo(24.0f, 37.3934f);
                l.lineTo(24.0f, 63.50374f);
                l.close();
                l.moveTo(8.066298f, 46.96314f);
                l.cubicTo(6.7324653f, 43.567234f, 6.0f, 39.869156f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 33.41025f, 6.3281474f, 30.89715f, 6.9451313f, 28.5f);
                l.lineTo(26.529438f, 28.5f);
                l.lineTo(8.066298f, 46.96314f);
                l.close();
                l.moveTo(8.496263f, 24.0f);
                l.cubicTo(11.031974f, 18.196375f, 15.350795f, 13.350096f, 20.760244f, 10.153644f);
                l.lineTo(34.6066f, 24.0f);
                l.lineTo(8.496263f, 24.0f);
                l.close();
                l.moveTo(25.03686f, 8.066298f);
                l.cubicTo(28.432766f, 6.7324653f, 32.130844f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(38.58975f, 6.0f, 41.10285f, 6.3281474f, 43.5f, 6.9451313f);
                l.lineTo(43.5f, 26.529438f);
                l.lineTo(25.03686f, 8.066298f);
                l.close();
                l.moveTo(48.0f, 8.496263f);
                l.cubicTo(53.803627f, 11.031974f, 58.649906f, 15.350795f, 61.846355f, 20.760244f);
                l.lineTo(48.0f, 34.6066f);
                l.lineTo(48.0f, 8.496263f);
                l.close();
                l.moveTo(63.933704f, 25.03686f);
                l.cubicTo(65.26753f, 28.432766f, 66.0f, 32.130844f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 38.58975f, 65.67185f, 41.10285f, 65.05487f, 43.5f);
                l.lineTo(45.470562f, 43.5f);
                l.lineTo(63.933704f, 25.03686f);
                l.close();
                l.moveTo(63.50374f, 48.0f);
                l.cubicTo(60.968025f, 53.803627f, 56.649204f, 58.649906f, 51.239754f, 61.846355f);
                l.lineTo(37.3934f, 48.0f);
                l.lineTo(63.50374f, 48.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
