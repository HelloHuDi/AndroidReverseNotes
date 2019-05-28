package com.tencent.p177mm.plugin.appbrand.p336ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C37899l;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.widget.a */
public final class C10929a implements C37932f {
    private final int eop;
    private final int eor;
    private final int eos = -1;

    public C10929a(int i, int i2) {
        this.eop = i;
        this.eor = i2;
    }

    /* renamed from: y */
    public final Bitmap mo22474y(Bitmap bitmap) {
        AppMethodBeat.m2504i(93769);
        Bitmap a = C5056d.m7617a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.eop, this.eop, false);
        if (a != createScaledBitmap) {
            C37899l.m63997Xf().mo60652v(a);
        }
        a = Bitmap.createBitmap(this.eop + (this.eor * 2), this.eop + (this.eor * 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(a);
        canvas.drawBitmap(createScaledBitmap, (float) this.eor, (float) this.eor, new Paint());
        C37899l.m63997Xf().mo60652v(createScaledBitmap);
        Paint paint = new Paint();
        paint.setColor(this.eos);
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) this.eor);
        canvas.drawCircle((float) ((this.eop / 2) + this.eor), (float) ((this.eop / 2) + this.eor), (float) (this.eop / 2), paint);
        AppMethodBeat.m2505o(93769);
        return a;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        return "WxaNearbyShowcaseIcon";
    }
}
