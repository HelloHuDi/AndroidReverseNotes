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

/* renamed from: com.tencent.mm.boot.svg.a.a.bh */
public final class C25871bh extends C5163c {
    private final int height = 24;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                k.setColor(-15028967);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(11.488281f, 9.3671875f);
                l.cubicTo(10.421875f, 9.3671875f, 9.777344f, 10.28125f, 9.777344f, 11.8046875f);
                l.cubicTo(9.777344f, 13.328125f, 10.410156f, 14.2421875f, 11.488281f, 14.2421875f);
                l.cubicTo(12.566406f, 14.2421875f, 13.2109375f, 13.316406f, 13.2109375f, 11.8046875f);
                l.cubicTo(13.2109375f, 10.292969f, 12.5546875f, 9.3671875f, 11.488281f, 9.3671875f);
                l.close();
                l.moveTo(11.8515625f, 1.9375f);
                l.cubicTo(17.464844f, 1.9375f, 21.34375f, 5.4414062f, 21.34375f, 10.6796875f);
                l.cubicTo(21.34375f, 14.347656f, 19.550781f, 16.65625f, 16.632812f, 16.65625f);
                l.cubicTo(15.121094f, 16.65625f, 14.03125f, 16.011719f, 13.714844f, 14.886719f);
                l.lineTo(13.515625f, 14.886719f);
                l.cubicTo(13.035156f, 16.058594f, 12.109375f, 16.667969f, 10.761719f, 16.667969f);
                l.cubicTo(8.324219f, 16.667969f, 6.7070312f, 14.699219f, 6.7070312f, 11.722656f);
                l.cubicTo(6.7070312f, 8.875f, 8.265625f, 6.953125f, 10.574219f, 6.953125f);
                l.cubicTo(11.8515625f, 6.953125f, 12.871094f, 7.5742188f, 13.339844f, 8.6171875f);
                l.lineTo(13.5390625f, 8.6171875f);
                l.lineTo(13.5390625f, 7.234375f);
                l.lineTo(16.222656f, 7.234375f);
                l.lineTo(16.222656f, 13.1875f);
                l.cubicTo(16.222656f, 14.0078125f, 16.585938f, 14.511719f, 17.242188f, 14.511719f);
                l.cubicTo(18.261719f, 14.511719f, 18.929688f, 13.175781f, 18.929688f, 10.9609375f);
                l.cubicTo(18.929688f, 6.7070312f, 16.128906f, 4.0f, 11.816406f, 4.0f);
                l.cubicTo(7.328125f, 4.0f, 4.234375f, 7.1523438f, 4.234375f, 11.769531f);
                l.cubicTo(4.234375f, 16.503906f, 7.4101562f, 19.351562f, 12.296875f, 19.351562f);
                l.cubicTo(13.386719f, 19.351562f, 14.5f, 19.210938f, 15.109375f, 19.023438f);
                l.lineTo(15.109375f, 21.109375f);
                l.cubicTo(14.265625f, 21.332031f, 13.175781f, 21.460938f, 12.050781f, 21.460938f);
                l.cubicTo(5.9921875f, 21.460938f, 1.8203125f, 17.640625f, 1.8203125f, 11.7109375f);
                l.cubicTo(1.8203125f, 5.921875f, 5.9335938f, 1.9375f, 11.8515625f, 1.9375f);
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
