package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.e */
public final class C35836e implements C9014g {
    private int jNL;
    private int vkb;
    private int vkc;
    C35837a vkd;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.e$1 */
    class C232701 implements Runnable {
        C232701() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11685);
            C35836e.this.vkd.onFinish();
            AppMethodBeat.m2505o(11685);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.e$a */
    public interface C35837a {
        void onFinish();
    }

    public C35836e() {
        this(0, 0, 0, null);
    }

    public C35836e(int i, int i2, int i3, C35837a c35837a) {
        this.vkb = i;
        this.vkc = i2;
        this.jNL = i3;
        this.vkd = c35837a;
    }

    /* renamed from: sH */
    public final void mo7596sH(String str) {
        AppMethodBeat.m2504i(11686);
        C4990ab.m7411d("MicroMsg.ReaderAppUI", "onImageLoadStart, url: %s", str);
        C7060h.pYm.mo8378a(86, 0, 1, false);
        AppMethodBeat.m2505o(11686);
    }

    /* renamed from: a */
    public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
        AppMethodBeat.m2504i(11687);
        if (this.vkb == 0) {
            AppMethodBeat.m2505o(11687);
            return null;
        } else if (c37477b == null || c37477b.bitmap == null || c37477b.bitmap.isRecycled()) {
            C4990ab.m7420w("MicroMsg.ReaderAppUI", "onProcessBitmap bitmap is null");
            AppMethodBeat.m2505o(11687);
            return null;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ReaderAppUI", "onProcessBitmap url is null");
            AppMethodBeat.m2505o(11687);
            return null;
        } else {
            try {
                Bitmap b = C5056d.m7649b(c37477b.bitmap, this.vkc, this.jNL, true);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, this.vkc, this.jNL, true);
                if (!(createScaledBitmap == b || b == null || b.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.ReaderAppUI", "bitmap recycle %s", b.toString());
                    b.recycle();
                }
                b = C5056d.m7658d(createScaledBitmap, this.vkb);
                if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.ReaderAppUI", "bitmap recycle %s", createScaledBitmap.toString());
                    createScaledBitmap.recycle();
                }
                AppMethodBeat.m2505o(11687);
                return b;
            } catch (OutOfMemoryError e) {
                C4990ab.m7421w("MicroMsg.ReaderAppUI", "onProcessBitmap OutOfMemoryError %s", e.getMessage());
                AppMethodBeat.m2505o(11687);
                return null;
            }
        }
    }

    /* renamed from: b */
    public final void mo7595b(String str, View view, C37477b c37477b) {
        AppMethodBeat.m2504i(11688);
        if (!(this.vkd == null || c37477b.bitmap == null || c37477b.bitmap.isRecycled())) {
            C232701 c232701 = new C232701();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                c232701.run();
            } else {
                C5004al.m7441d(c232701);
            }
        }
        if (c37477b.from != 2) {
            AppMethodBeat.m2505o(11688);
            return;
        }
        C4990ab.m7411d("MicroMsg.ReaderAppUI", "onImageLoadFinish, url:%s, contentType: %s", str, c37477b.bqF);
        boolean z = false;
        if (C41764q.ahs() && !C5046bo.isNullOrNil(c37477b.bqF) && C41764q.m73704sz(str) && c37477b.bqF.equals("image/webp")) {
            z = true;
        }
        C4990ab.m7411d("MicroMsg.ReaderAppUI", "onImageLoadFinish, isDownloadWebp: %b, status: %d", Boolean.valueOf(z), Integer.valueOf(c37477b.status));
        switch (c37477b.status) {
            case 0:
                if (z) {
                    C7060h.pYm.mo8378a(86, 13, 1, false);
                    AppMethodBeat.m2505o(11688);
                    return;
                }
                break;
            case 1:
                C7060h.pYm.mo8378a(86, 2, 1, false);
                if (z) {
                    C7060h.pYm.mo8378a(86, 15, 1, false);
                    AppMethodBeat.m2505o(11688);
                    return;
                }
                break;
            case 3:
                if (z) {
                    C7060h.pYm.mo8378a(86, 14, 1, false);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(11688);
    }
}
