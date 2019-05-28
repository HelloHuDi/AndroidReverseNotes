package com.tencent.p177mm.memory.p1205b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C26406i;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.memory.b.a */
public class C18602a extends Drawable implements C26406i {
    boolean DEBUG = false;
    protected final Paint feO = new Paint();
    private final C7306ak feP;
    protected C45434n feQ;
    private Runnable feR = new C186031();
    protected String tag;

    /* renamed from: com.tencent.mm.memory.b.a$1 */
    class C186031 implements Runnable {
        C186031() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115475);
            C4990ab.m7411d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", C18602a.this.tag);
            C18602a.this.invalidateSelf();
            AppMethodBeat.m2505o(115475);
        }
    }

    public C18602a(String str, C45434n c45434n) {
        AppMethodBeat.m2504i(115476);
        this.tag = str;
        this.feQ = c45434n;
        this.feO.setAntiAlias(true);
        this.feO.setFilterBitmap(false);
        this.feO.setColor(-1118482);
        this.feP = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(115476);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(115477);
        Rect bounds = getBounds();
        C45434n c45434n = this.feQ;
        if (c45434n == null || c45434n.isRecycled()) {
            canvas.drawColor(-1118482);
            AppMethodBeat.m2505o(115477);
            return;
        }
        canvas.drawBitmap(c45434n.bitmap, null, bounds, this.feO);
        AppMethodBeat.m2505o(115477);
    }

    /* renamed from: Xd */
    public final void mo33853Xd() {
        AppMethodBeat.m2504i(115478);
        if (this.feQ != null) {
            this.feQ.mo33853Xd();
        }
        AppMethodBeat.m2505o(115478);
    }

    /* renamed from: Xe */
    public final void mo33854Xe() {
        AppMethodBeat.m2504i(115479);
        if (this.feQ != null) {
            this.feQ.mo33854Xe();
        }
        AppMethodBeat.m2505o(115479);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.m2504i(115480);
        if (this.feQ == null) {
            AppMethodBeat.m2505o(115480);
            return 0;
        }
        C45434n c45434n = this.feQ;
        if (c45434n == null || c45434n.isRecycled()) {
            AppMethodBeat.m2505o(115480);
            return 0;
        }
        int width = c45434n.bitmap.getWidth();
        AppMethodBeat.m2505o(115480);
        return width;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.m2504i(115481);
        if (this.feQ == null) {
            AppMethodBeat.m2505o(115481);
            return 0;
        }
        C45434n c45434n = this.feQ;
        if (c45434n == null || c45434n.isRecycled()) {
            AppMethodBeat.m2505o(115481);
            return 0;
        }
        int height = c45434n.bitmap.getHeight();
        AppMethodBeat.m2505o(115481);
        return height;
    }

    /* renamed from: Xx */
    public final C45434n mo33855Xx() {
        if (this.feQ != null) {
            return this.feQ;
        }
        return null;
    }

    public String toString() {
        AppMethodBeat.m2504i(115482);
        String str;
        if (this.DEBUG) {
            str = super.toString() + " code: " + hashCode();
            if (this.feQ != null) {
                str = str + this.feQ;
            }
            AppMethodBeat.m2505o(115482);
            return str;
        }
        str = super.toString();
        AppMethodBeat.m2505o(115482);
        return str;
    }
}
