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

/* renamed from: com.tencent.mm.boot.svg.a.a.ry */
public final class C41863ry extends C5163c {
    private final int height = 54;
    private final int width = 54;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                k.setColor(-10658467);
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(27.0f, 10.48036f);
                l.cubicTo(28.520756f, 7.5187073f, 31.927713f, 3.0f, 38.559685f, 3.0f);
                l.cubicTo(48.42443f, 3.0f, 55.286037f, 9.86097f, 53.796867f, 19.960094f);
                l.cubicTo(51.85492f, 31.37217f, 31.893957f, 47.352608f, 27.419691f, 51.072113f);
                l.cubicTo(27.187933f, 51.26478f, 26.997726f, 51.424545f, 26.853727f, 51.549076f);
                l.cubicTo(26.85368f, 51.566315f, 26.853643f, 51.58329f, 26.85362f, 51.6f);
                l.cubicTo(26.844093f, 51.591694f, 26.83434f, 51.583206f, 26.824354f, 51.574547f);
                l.cubicTo(26.819895f, 51.578423f, 26.815485f, 51.582264f, 26.811125f, 51.586067f);
                l.cubicTo(26.811113f, 51.57845f, 26.8111f, 51.570774f, 26.811085f, 51.563046f);
                l.cubicTo(23.89057f, 49.03434f, 2.2456808f, 31.963354f, 0.20313297f, 19.960094f);
                l.cubicTo(-1.2860388f, 9.86097f, 5.5755696f, 3.0f, 15.440317f, 3.0f);
                l.cubicTo(22.072287f, 3.0f, 25.479244f, 7.5187073f, 27.0f, 10.48036f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
