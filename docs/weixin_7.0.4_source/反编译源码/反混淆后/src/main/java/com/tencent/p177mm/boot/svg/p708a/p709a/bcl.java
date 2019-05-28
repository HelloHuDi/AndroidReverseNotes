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

/* renamed from: com.tencent.mm.boot.svg.a.a.bcl */
public final class bcl extends C5163c {
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(55.381916f, 0.0f);
                l.lineTo(56.457024f, 0.0f);
                l.cubicTo(56.297745f, 7.262626f, 57.5819f, 14.484849f, 58.0f, 21.727272f);
                l.cubicTo(50.484203f, 22.0f, 42.968407f, 22.222221f, 35.45261f, 22.50505f);
                l.cubicTo(38.090603f, 19.474747f, 40.93765f, 16.626263f, 43.515915f, 13.535354f);
                l.cubicTo(35.60193f, 10.222222f, 26.085238f, 10.989899f, 19.09704f, 16.161615f);
                l.cubicTo(12.01925f, 21.11111f, 8.166781f, 29.89899f, 8.52515f, 38.525253f);
                l.cubicTo(6.036476f, 38.67677f, 3.5577564f, 38.838383f, 1.0690819f, 39.0f);
                l.cubicTo(0.20302321f, 25.969698f, 7.5495906f, 12.848485f, 19.196587f, 7.2222223f);
                l.cubicTo(28.434547f, 2.4747474f, 39.82272f, 2.89899f, 48.921314f, 7.79798f);
                l.cubicTo(50.75298f, 5.79798f, 52.495052f, 3.6969697f, 54.62536f, 2.0f);
                l.cubicTo(54.814495f, 1.5050505f, 55.192776f, 0.5050505f, 55.381916f, 0.0f);
                l.lineTo(55.381916f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(48.933964f, 55.03601f);
                l.cubicTo(55.348537f, 49.984196f, 58.860096f, 41.66891f, 58.411175f, 33.484974f);
                l.cubicTo(60.915154f, 33.323315f, 63.409153f, 33.16166f, 65.90316f, 33.0f);
                l.cubicTo(67.14018f, 48.397926f, 56.386044f, 63.33109f, 41.681408f, 67.190674f);
                l.lineTo(41.491863f, 68.039375f);
                l.lineTo(41.47191f, 67.13005f);
                l.cubicTo(33.65072f, 69.251816f, 25.15116f, 68.00906f, 18.028288f, 64.189896f);
                l.cubicTo(15.614094f, 66.77643f, 13.229828f, 69.403366f, 10.815634f, 72.0f);
                l.cubicTo(10.197121f, 64.59404f, 9.608537f, 57.188084f, 9.0f, 49.782124f);
                l.lineTo(30.927269f, 49.782124f);
                l.cubicTo(28.443243f, 52.631348f, 25.959215f, 55.48057f, 23.415333f, 58.269173f);
                l.cubicTo(31.62559f, 62.21969f, 41.890903f, 60.77487f, 48.933964f, 55.03601f);
                l.lineTo(48.933964f, 55.03601f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
