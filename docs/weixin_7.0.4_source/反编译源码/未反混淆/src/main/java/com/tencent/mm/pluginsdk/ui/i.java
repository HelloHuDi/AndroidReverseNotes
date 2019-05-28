package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class i extends BitmapDrawable implements com.tencent.mm.pluginsdk.ui.d.a {
    protected static final ak feP = new ak(Looper.getMainLooper());
    private Paint aFY = new Paint();
    private Path eAv;
    protected final Paint feO = new Paint();
    private Runnable feR;
    protected boolean oxB = false;
    protected final a pqK;
    private Rect rect = new Rect();
    protected String tag;
    protected boolean vhI = false;
    private int vhJ = 0;
    private int vhK = 0;
    protected boolean vhL;
    protected boolean vhM;
    protected float vhN = 1.0f;
    private PaintFlagsDrawFilter vhO = new PaintFlagsDrawFilter(0, 3);

    public interface a {
        Bitmap AZ();

        void a(i iVar);

        Bitmap b(String str, int i, int i2, int i3);

        Bitmap cQ(String str);

        Bitmap cR(String str);
    }

    static {
        AppMethodBeat.i(79699);
        AppMethodBeat.o(79699);
    }

    public i(a aVar, String str) {
        super(aVar.AZ());
        AppMethodBeat.i(79692);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setFlags(1);
        this.aFY.setAntiAlias(true);
        this.eAv = new Path();
        this.feR = new Runnable() {
            public final void run() {
                AppMethodBeat.i(79691);
                i.this.invalidateSelf();
                AppMethodBeat.o(79691);
            }
        };
        this.feO.setAntiAlias(true);
        this.feO.setFilterBitmap(true);
        this.pqK = aVar;
        this.tag = str;
        this.pqK.a(this);
        AppMethodBeat.o(79692);
    }

    public i(a aVar, String str, byte b) {
        super(aVar.AZ());
        AppMethodBeat.i(79693);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setFlags(1);
        this.aFY.setAntiAlias(true);
        this.eAv = new Path();
        this.feR = /* anonymous class already generated */;
        this.feO.setAntiAlias(true);
        this.feO.setFilterBitmap(true);
        this.oxB = false;
        this.pqK = aVar;
        this.tag = str;
        this.pqK.a(this);
        AppMethodBeat.o(79693);
    }

    public final void setTag(String str) {
        AppMethodBeat.i(79694);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(79694);
            return;
        }
        if (!str.equals(this.tag)) {
            this.tag = str;
            feP.post(this.feR);
        }
        AppMethodBeat.o(79694);
    }

    public final void ox(boolean z) {
        this.vhI = z;
    }

    public void draw(Canvas canvas) {
        Bitmap b;
        AppMethodBeat.i(79695);
        if (this.vhI) {
            b = this.pqK.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.vhL) {
            b = this.pqK.cR(this.tag);
        } else {
            b = this.pqK.cQ(this.tag);
        }
        if (b == null || b.isRecycled()) {
            b = this.pqK.AZ();
            if (this.vhL) {
                this.vhM = true;
            } else {
                this.vhM = false;
            }
        } else {
            this.vhM = false;
        }
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vhN > 1.0f || this.oxB) {
            int height = (b.getHeight() / 15) / 2;
            int width = (b.getWidth() / 15) / 2;
            rect = new Rect(width, height, b.getWidth() - width, b.getHeight() - height);
        }
        canvas.drawBitmap(b, rect, bounds, this.feO);
        AppMethodBeat.o(79695);
    }

    public void qj(String str) {
        AppMethodBeat.i(79696);
        if (str == null || !str.equals(this.tag)) {
            AppMethodBeat.o(79696);
            return;
        }
        ab.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
        feP.post(this.feR);
        AppMethodBeat.o(79696);
    }

    public final void diX() {
        this.vhL = true;
    }

    public final void diY() {
        AppMethodBeat.i(79697);
        if (this.vhL) {
            this.vhL = false;
            if (this.vhM) {
                this.vhM = false;
                invalidateSelf();
            }
            AppMethodBeat.o(79697);
            return;
        }
        AppMethodBeat.o(79697);
    }

    public void onScrollStateChanged(boolean z) {
        AppMethodBeat.i(79698);
        if (z) {
            this.vhL = true;
            AppMethodBeat.o(79698);
            return;
        }
        diY();
        AppMethodBeat.o(79698);
    }
}
