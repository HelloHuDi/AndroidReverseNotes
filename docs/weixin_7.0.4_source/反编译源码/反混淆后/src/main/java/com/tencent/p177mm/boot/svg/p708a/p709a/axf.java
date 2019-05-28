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

/* renamed from: com.tencent.mm.boot.svg.a.a.axf */
public final class axf extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-8534461);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.62213f, 76.7455f);
                l.cubicTo(46.62213f, 76.7455f, 27.0f, 57.136356f, 27.0f, 41.21418f);
                l.cubicTo(27.0f, 29.446882f, 36.40202f, 20.0f, 48.304348f, 20.0f);
                l.cubicTo(59.59798f, 20.0f, 69.0f, 29.446882f, 69.0f, 41.21418f);
                l.cubicTo(69.0f, 57.136356f, 49.37787f, 76.7455f, 49.37787f, 76.7455f);
                l.cubicTo(48.628487f, 77.53978f, 47.383106f, 77.54187f, 46.62213f, 76.7455f);
                l.close();
                l.moveTo(48.0f, 48.0905f);
                l.cubicTo(51.865993f, 48.0905f, 55.0f, 44.94636f, 55.0f, 41.067875f);
                l.cubicTo(55.0f, 37.189384f, 51.865993f, 34.04525f, 48.0f, 34.04525f);
                l.cubicTo(44.134007f, 34.04525f, 41.0f, 37.189384f, 41.0f, 41.067875f);
                l.cubicTo(41.0f, 44.94636f, 44.134007f, 48.0905f, 48.0f, 48.0905f);
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
