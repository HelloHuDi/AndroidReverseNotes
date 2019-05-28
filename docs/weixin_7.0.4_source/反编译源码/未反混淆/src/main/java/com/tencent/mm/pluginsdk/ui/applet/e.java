package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.at.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class e implements g {
    private int jNL;
    private int vkb;
    private int vkc;
    a vkd;

    public interface a {
        void onFinish();
    }

    public e() {
        this(0, 0, 0, null);
    }

    public e(int i, int i2, int i3, a aVar) {
        this.vkb = i;
        this.vkc = i2;
        this.jNL = i3;
        this.vkd = aVar;
    }

    public final void sH(String str) {
        AppMethodBeat.i(11686);
        ab.d("MicroMsg.ReaderAppUI", "onImageLoadStart, url: %s", str);
        h.pYm.a(86, 0, 1, false);
        AppMethodBeat.o(11686);
    }

    public final Bitmap a(String str, View view, b bVar) {
        AppMethodBeat.i(11687);
        if (this.vkb == 0) {
            AppMethodBeat.o(11687);
            return null;
        } else if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
            ab.w("MicroMsg.ReaderAppUI", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(11687);
            return null;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ReaderAppUI", "onProcessBitmap url is null");
            AppMethodBeat.o(11687);
            return null;
        } else {
            try {
                Bitmap b = d.b(bVar.bitmap, this.vkc, this.jNL, true);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, this.vkc, this.jNL, true);
                if (!(createScaledBitmap == b || b == null || b.isRecycled())) {
                    ab.i("MicroMsg.ReaderAppUI", "bitmap recycle %s", b.toString());
                    b.recycle();
                }
                b = d.d(createScaledBitmap, this.vkb);
                if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                    ab.i("MicroMsg.ReaderAppUI", "bitmap recycle %s", createScaledBitmap.toString());
                    createScaledBitmap.recycle();
                }
                AppMethodBeat.o(11687);
                return b;
            } catch (OutOfMemoryError e) {
                ab.w("MicroMsg.ReaderAppUI", "onProcessBitmap OutOfMemoryError %s", e.getMessage());
                AppMethodBeat.o(11687);
                return null;
            }
        }
    }

    public final void b(String str, View view, b bVar) {
        AppMethodBeat.i(11688);
        if (!(this.vkd == null || bVar.bitmap == null || bVar.bitmap.isRecycled())) {
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(11685);
                    e.this.vkd.onFinish();
                    AppMethodBeat.o(11685);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
            } else {
                al.d(anonymousClass1);
            }
        }
        if (bVar.from != 2) {
            AppMethodBeat.o(11688);
            return;
        }
        ab.d("MicroMsg.ReaderAppUI", "onImageLoadFinish, url:%s, contentType: %s", str, bVar.bqF);
        boolean z = false;
        if (q.ahs() && !bo.isNullOrNil(bVar.bqF) && q.sz(str) && bVar.bqF.equals("image/webp")) {
            z = true;
        }
        ab.d("MicroMsg.ReaderAppUI", "onImageLoadFinish, isDownloadWebp: %b, status: %d", Boolean.valueOf(z), Integer.valueOf(bVar.status));
        switch (bVar.status) {
            case 0:
                if (z) {
                    h.pYm.a(86, 13, 1, false);
                    AppMethodBeat.o(11688);
                    return;
                }
                break;
            case 1:
                h.pYm.a(86, 2, 1, false);
                if (z) {
                    h.pYm.a(86, 15, 1, false);
                    AppMethodBeat.o(11688);
                    return;
                }
                break;
            case 3:
                if (z) {
                    h.pYm.a(86, 14, 1, false);
                    break;
                }
                break;
        }
        AppMethodBeat.o(11688);
    }
}
