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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbc */
public final class bbc extends C5163c {
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-436207616);
                Path l = C5163c.m7884l(looper);
                l.moveTo(25.5f, 12.0f);
                l.lineTo(63.0f, 12.0f);
                l.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                l.lineTo(66.0f, 57.0f);
                l.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                l.lineTo(25.5f, 60.0f);
                l.cubicTo(24.555729f, 60.0f, 23.666563f, 59.555416f, 23.1f, 58.8f);
                l.lineTo(7.35f, 37.8f);
                l.cubicTo(6.55f, 36.733334f, 6.55f, 35.266666f, 7.35f, 34.2f);
                l.lineTo(23.1f, 13.2f);
                l.cubicTo(23.666563f, 12.444583f, 24.555729f, 12.0f, 25.5f, 12.0f);
                l.close();
                l.moveTo(42.0f, 33.454414f);
                l.lineTo(34.272793f, 25.727207f);
                l.cubicTo(33.569847f, 25.024263f, 32.430153f, 25.024263f, 31.727207f, 25.727207f);
                l.cubicTo(31.024263f, 26.430151f, 31.024263f, 27.569849f, 31.727207f, 28.272793f);
                l.lineTo(39.454414f, 36.0f);
                l.lineTo(31.727207f, 43.727207f);
                l.cubicTo(31.024263f, 44.430153f, 31.024263f, 45.569847f, 31.727207f, 46.272793f);
                l.cubicTo(32.430153f, 46.975735f, 33.569847f, 46.975735f, 34.272793f, 46.272793f);
                l.lineTo(42.0f, 38.545586f);
                l.lineTo(49.727207f, 46.272793f);
                l.cubicTo(50.430153f, 46.975735f, 51.569847f, 46.975735f, 52.272793f, 46.272793f);
                l.cubicTo(52.975735f, 45.569847f, 52.975735f, 44.430153f, 52.272793f, 43.727207f);
                l.lineTo(44.545586f, 36.0f);
                l.lineTo(52.272793f, 28.272793f);
                l.cubicTo(52.975735f, 27.569849f, 52.975735f, 26.430151f, 52.272793f, 25.727207f);
                l.cubicTo(51.569847f, 25.024263f, 50.430153f, 25.024263f, 49.727207f, 25.727207f);
                l.lineTo(42.0f, 33.454414f);
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
