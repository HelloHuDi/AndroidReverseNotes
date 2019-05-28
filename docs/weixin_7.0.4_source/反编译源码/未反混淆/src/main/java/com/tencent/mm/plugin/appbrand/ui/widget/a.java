package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements f {
    private final int eop;
    private final int eor;
    private final int eos = -1;

    public a(int i, int i2) {
        this.eop = i;
        this.eor = i2;
    }

    public final Bitmap y(Bitmap bitmap) {
        AppMethodBeat.i(93769);
        Bitmap a = d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.eop, this.eop, false);
        if (a != createScaledBitmap) {
            l.Xf().v(a);
        }
        a = Bitmap.createBitmap(this.eop + (this.eor * 2), this.eop + (this.eor * 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(a);
        canvas.drawBitmap(createScaledBitmap, (float) this.eor, (float) this.eor, new Paint());
        l.Xf().v(createScaledBitmap);
        Paint paint = new Paint();
        paint.setColor(this.eos);
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) this.eor);
        canvas.drawCircle((float) ((this.eop / 2) + this.eor), (float) ((this.eop / 2) + this.eor), (float) (this.eop / 2), paint);
        AppMethodBeat.o(93769);
        return a;
    }

    public final String wP() {
        return "WxaNearbyShowcaseIcon";
    }
}
