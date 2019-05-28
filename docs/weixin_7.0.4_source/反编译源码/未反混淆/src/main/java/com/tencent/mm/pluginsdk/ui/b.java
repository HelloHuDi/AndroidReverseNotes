package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class b extends a implements a {
    Bitmap jMX;
    private float vgO;

    private b(String str) {
        super(com.tencent.mm.pluginsdk.ui.a.b.diS(), str);
        AppMethodBeat.i(79665);
        this.vgO = 0.5f;
        this.jMX = null;
        AppMethodBeat.o(79665);
    }

    public b(String str, float f) {
        this(str);
        this.vgO = f;
    }

    public final void qj(String str) {
        AppMethodBeat.i(79666);
        super.qj(str);
        AppMethodBeat.o(79666);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        AppMethodBeat.i(79667);
        String str = this.tag + "-" + this.vgO;
        com.tencent.mm.bv.a.a aVar = com.tencent.mm.bv.a.a.a.xtT;
        if (aVar != null) {
            bitmap = com.tencent.mm.bv.a.a.a.xtT.PO(str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            if (this.vhI) {
                bitmap = this.pqK.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
            } else {
                bitmap = this.pqK.cQ(this.tag);
            }
            if (bitmap != null) {
                bitmap = d.a(bitmap, false, this.vgO * ((float) bitmap.getWidth()));
                if (aVar != null) {
                    aVar.p(str, bitmap);
                }
                if (!(bitmap == null || bitmap.isRecycled())) {
                    a(canvas, bitmap);
                    AppMethodBeat.o(79667);
                    return;
                }
            } else if (bitmap == null || bitmap.isRecycled()) {
                if (this.jMX == null) {
                    try {
                        this.jMX = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
                        this.jMX = d.a(this.jMX, false, this.vgO * ((float) this.jMX.getWidth()));
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e, "", new Object[0]);
                    }
                }
                bitmap = this.jMX;
                if (!(bitmap == null || bitmap.isRecycled())) {
                    a(canvas, bitmap);
                }
            }
            AppMethodBeat.o(79667);
            return;
        }
        a(canvas, bitmap);
        AppMethodBeat.o(79667);
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        AppMethodBeat.i(79668);
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vhN > 1.0f || this.oxB) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, this.feO);
        AppMethodBeat.o(79668);
    }

    public final void KK(int i) {
        AppMethodBeat.i(138584);
        this.feO.setAlpha(i);
        AppMethodBeat.o(138584);
    }
}
