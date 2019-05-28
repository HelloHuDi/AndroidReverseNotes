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

/* renamed from: com.tencent.mm.boot.svg.a.a.mx */
public final class C25912mx extends C5163c {
    private final int height = 45;
    private final int width = 45;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                canvas.saveLayerAlpha(null, 38, 4);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(18.0743f, 25.9257f);
                l.cubicTo(21.81657f, 29.66797f, 25.362413f, 31.423225f, 26.673681f, 31.320438f);
                l.cubicTo(27.98495f, 31.217651f, 31.250372f, 28.972013f, 32.791916f, 29.001904f);
                l.cubicTo(33.5328f, 29.01627f, 38.37422f, 32.290524f, 38.960274f, 32.669083f);
                l.cubicTo(39.54633f, 33.047638f, 40.089733f, 33.48984f, 39.987553f, 34.049404f);
                l.cubicTo(39.885376f, 34.608967f, 37.757626f, 40.772552f, 32.325485f, 39.919037f);
                l.cubicTo(26.893343f, 39.06552f, 19.320179f, 33.20958f, 15.004804f, 28.995195f);
                l.lineTo(18.0743f, 25.9257f);
                l.lineTo(18.0743f, 25.9257f);
                l.close();
                l.moveTo(18.0743f, 25.9257f);
                l.cubicTo(14.33203f, 22.18343f, 12.576774f, 18.637587f, 12.679562f, 17.326319f);
                l.cubicTo(12.782349f, 16.01505f, 15.027987f, 12.749629f, 14.998096f, 11.208082f);
                l.cubicTo(14.983731f, 10.467202f, 11.709476f, 5.625779f, 11.330918f, 5.0397243f);
                l.cubicTo(10.952361f, 4.45367f, 10.510159f, 3.9102678f, 9.950595f, 4.012446f);
                l.cubicTo(9.391031f, 4.1146235f, 3.2274485f, 6.2423735f, 4.080963f, 11.674515f);
                l.cubicTo(4.9344783f, 17.106657f, 10.790419f, 24.679821f, 15.004804f, 28.995195f);
                l.lineTo(18.0743f, 25.9257f);
                l.lineTo(18.0743f, 25.9257f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(39.25f, 16.954916f);
                l.cubicTo(39.652576f, 17.12634f, 40.0f, 16.78943f, 40.0f, 16.273945f);
                l.lineTo(40.0f, 7.7189007f);
                l.cubicTo(40.0f, 7.1419024f, 39.615803f, 6.899748f, 39.25f, 7.03793f);
                l.cubicTo(39.033016f, 7.2903256f, 36.0f, 10.012693f, 36.0f, 10.012693f);
                l.lineTo(36.0f, 13.939582f);
                l.cubicTo(36.0f, 13.939582f, 39.103306f, 16.747684f, 39.25f, 16.954916f);
                l.close();
                l.moveTo(22.0f, 8.47057f);
                l.cubicTo(22.0f, 8.210681f, 22.25619f, 8.0f, 22.570713f, 8.0f);
                l.lineTo(33.429287f, 8.0f);
                l.cubicTo(33.744484f, 8.0f, 34.0f, 8.209868f, 34.0f, 8.47057f);
                l.lineTo(34.0f, 15.52943f);
                l.cubicTo(34.0f, 15.789319f, 33.743813f, 16.0f, 33.429287f, 16.0f);
                l.lineTo(22.570713f, 16.0f);
                l.cubicTo(22.255516f, 16.0f, 22.0f, 15.790132f, 22.0f, 15.52943f);
                l.lineTo(22.0f, 8.47057f);
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
