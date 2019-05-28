package com.tencent.p177mm.pluginsdk.p597ui;

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
import com.tencent.p177mm.pluginsdk.p597ui.C14943d.C4757a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.pluginsdk.ui.i */
public class C46507i extends BitmapDrawable implements C4757a {
    protected static final C7306ak feP = new C7306ak(Looper.getMainLooper());
    private Paint aFY = new Paint();
    private Path eAv;
    protected final Paint feO = new Paint();
    private Runnable feR;
    protected boolean oxB = false;
    protected final C14947a pqK;
    private Rect rect = new Rect();
    protected String tag;
    protected boolean vhI = false;
    private int vhJ = 0;
    private int vhK = 0;
    protected boolean vhL;
    protected boolean vhM;
    protected float vhN = 1.0f;
    private PaintFlagsDrawFilter vhO = new PaintFlagsDrawFilter(0, 3);

    /* renamed from: com.tencent.mm.pluginsdk.ui.i$a */
    public interface C14947a {
        /* renamed from: AZ */
        Bitmap mo8229AZ();

        /* renamed from: a */
        void mo8230a(C46507i c46507i);

        /* renamed from: b */
        Bitmap mo8231b(String str, int i, int i2, int i3);

        /* renamed from: cQ */
        Bitmap mo8232cQ(String str);

        /* renamed from: cR */
        Bitmap mo8233cR(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.i$1 */
    class C358741 implements Runnable {
        C358741() {
        }

        public final void run() {
            AppMethodBeat.m2504i(79691);
            C46507i.this.invalidateSelf();
            AppMethodBeat.m2505o(79691);
        }
    }

    static {
        AppMethodBeat.m2504i(79699);
        AppMethodBeat.m2505o(79699);
    }

    public C46507i(C14947a c14947a, String str) {
        super(c14947a.mo8229AZ());
        AppMethodBeat.m2504i(79692);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setFlags(1);
        this.aFY.setAntiAlias(true);
        this.eAv = new Path();
        this.feR = new C358741();
        this.feO.setAntiAlias(true);
        this.feO.setFilterBitmap(true);
        this.pqK = c14947a;
        this.tag = str;
        this.pqK.mo8230a(this);
        AppMethodBeat.m2505o(79692);
    }

    public C46507i(C14947a c14947a, String str, byte b) {
        super(c14947a.mo8229AZ());
        AppMethodBeat.m2504i(79693);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setFlags(1);
        this.aFY.setAntiAlias(true);
        this.eAv = new Path();
        this.feR = new C358741();
        this.feO.setAntiAlias(true);
        this.feO.setFilterBitmap(true);
        this.oxB = false;
        this.pqK = c14947a;
        this.tag = str;
        this.pqK.mo8230a(this);
        AppMethodBeat.m2505o(79693);
    }

    public final void setTag(String str) {
        AppMethodBeat.m2504i(79694);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(79694);
            return;
        }
        if (!str.equals(this.tag)) {
            this.tag = str;
            feP.post(this.feR);
        }
        AppMethodBeat.m2505o(79694);
    }

    /* renamed from: ox */
    public final void mo74729ox(boolean z) {
        this.vhI = z;
    }

    public void draw(Canvas canvas) {
        Bitmap b;
        AppMethodBeat.m2504i(79695);
        if (this.vhI) {
            b = this.pqK.mo8231b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.vhL) {
            b = this.pqK.mo8233cR(this.tag);
        } else {
            b = this.pqK.mo8232cQ(this.tag);
        }
        if (b == null || b.isRecycled()) {
            b = this.pqK.mo8229AZ();
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
        AppMethodBeat.m2505o(79695);
    }

    /* renamed from: qj */
    public void mo20342qj(String str) {
        AppMethodBeat.m2504i(79696);
        if (str == null || !str.equals(this.tag)) {
            AppMethodBeat.m2505o(79696);
            return;
        }
        C4990ab.m7419v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
        feP.post(this.feR);
        AppMethodBeat.m2505o(79696);
    }

    public final void diX() {
        this.vhL = true;
    }

    public final void diY() {
        AppMethodBeat.m2504i(79697);
        if (this.vhL) {
            this.vhL = false;
            if (this.vhM) {
                this.vhM = false;
                invalidateSelf();
            }
            AppMethodBeat.m2505o(79697);
            return;
        }
        AppMethodBeat.m2505o(79697);
    }

    public void onScrollStateChanged(boolean z) {
        AppMethodBeat.m2504i(79698);
        if (z) {
            this.vhL = true;
            AppMethodBeat.m2505o(79698);
            return;
        }
        diY();
        AppMethodBeat.m2505o(79698);
    }
}
