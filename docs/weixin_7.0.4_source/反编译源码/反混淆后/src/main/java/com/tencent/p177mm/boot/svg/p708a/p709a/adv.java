package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.adv */
public final class adv extends C5163c {
    private final int height = 384;
    private final int width = JsApiInstallDownloadTask.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiInstallDownloadTask.CTRL_INDEX;
            case 1:
                return 384;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -638.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(1080.0f, 0.0f);
                l.lineTo(1080.0f, 384.0f);
                l.lineTo(0.0f, 384.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(700.6798f, 213.73169f);
                l2.cubicTo(697.973f, 173.42755f, 710.4088f, 134.17123f, 738.70874f, 105.26089f);
                l2.cubicTo(796.09906f, 46.63267f, 896.9981f, 52.75353f, 964.07306f, 118.932205f);
                l2.cubicTo(1031.1481f, 185.11089f, 1038.999f, 286.28687f, 981.6087f, 344.91507f);
                l2.cubicTo(950.7191f, 376.47092f, 907.22516f, 389.26904f, 863.185f, 384.04095f);
                l2.cubicTo(858.7008f, 393.6198f, 852.6391f, 402.50076f, 844.97217f, 410.33347f);
                l2.cubicTo(803.2441f, 452.9637f, 729.76733f, 448.40085f, 680.8573f, 400.142f);
                l2.cubicTo(631.94727f, 351.88315f, 626.1251f, 278.20294f, 667.8532f, 235.5727f);
                l2.cubicTo(677.36743f, 225.85278f, 688.53217f, 218.58626f, 700.6798f, 213.73169f);
                l2.close();
                l2.moveTo(700.6798f, 213.73169f);
                l2.cubicTo(703.4623f, 255.16158f, 722.245f, 297.69867f, 756.2444f, 331.24374f);
                l2.cubicTo(787.21716f, 361.80264f, 825.4021f, 379.55566f, 863.185f, 384.04095f);
                l2.cubicTo(883.1062f, 341.486f, 871.8916f, 285.15613f, 831.9681f, 245.76416f);
                l2.cubicTo(794.2098f, 208.50858f, 741.8103f, 197.29474f, 700.6798f, 213.73169f);
                l2.close();
                canvas.saveLayerAlpha(null, 7, 4);
                k2 = C5163c.m7876a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
