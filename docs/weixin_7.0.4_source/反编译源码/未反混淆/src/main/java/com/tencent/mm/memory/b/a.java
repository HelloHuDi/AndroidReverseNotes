package com.tencent.mm.memory.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class a extends Drawable implements i {
    boolean DEBUG = false;
    protected final Paint feO = new Paint();
    private final ak feP;
    protected n feQ;
    private Runnable feR = new Runnable() {
        public final void run() {
            AppMethodBeat.i(115475);
            ab.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", a.this.tag);
            a.this.invalidateSelf();
            AppMethodBeat.o(115475);
        }
    };
    protected String tag;

    public a(String str, n nVar) {
        AppMethodBeat.i(115476);
        this.tag = str;
        this.feQ = nVar;
        this.feO.setAntiAlias(true);
        this.feO.setFilterBitmap(false);
        this.feO.setColor(-1118482);
        this.feP = new ak(Looper.getMainLooper());
        AppMethodBeat.o(115476);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(115477);
        Rect bounds = getBounds();
        n nVar = this.feQ;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            AppMethodBeat.o(115477);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, null, bounds, this.feO);
        AppMethodBeat.o(115477);
    }

    public final void Xd() {
        AppMethodBeat.i(115478);
        if (this.feQ != null) {
            this.feQ.Xd();
        }
        AppMethodBeat.o(115478);
    }

    public final void Xe() {
        AppMethodBeat.i(115479);
        if (this.feQ != null) {
            this.feQ.Xe();
        }
        AppMethodBeat.o(115479);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.i(115480);
        if (this.feQ == null) {
            AppMethodBeat.o(115480);
            return 0;
        }
        n nVar = this.feQ;
        if (nVar == null || nVar.isRecycled()) {
            AppMethodBeat.o(115480);
            return 0;
        }
        int width = nVar.bitmap.getWidth();
        AppMethodBeat.o(115480);
        return width;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.i(115481);
        if (this.feQ == null) {
            AppMethodBeat.o(115481);
            return 0;
        }
        n nVar = this.feQ;
        if (nVar == null || nVar.isRecycled()) {
            AppMethodBeat.o(115481);
            return 0;
        }
        int height = nVar.bitmap.getHeight();
        AppMethodBeat.o(115481);
        return height;
    }

    public final n Xx() {
        if (this.feQ != null) {
            return this.feQ;
        }
        return null;
    }

    public String toString() {
        AppMethodBeat.i(115482);
        String str;
        if (this.DEBUG) {
            str = super.toString() + " code: " + hashCode();
            if (this.feQ != null) {
                str = str + this.feQ;
            }
            AppMethodBeat.o(115482);
            return str;
        }
        str = super.toString();
        AppMethodBeat.o(115482);
        return str;
    }
}
