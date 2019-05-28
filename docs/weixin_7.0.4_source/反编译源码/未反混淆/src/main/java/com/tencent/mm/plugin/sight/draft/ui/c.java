package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;

public abstract class c {
    f<String, Bitmap> qzU = new com.tencent.mm.memory.a.c(24);
    private Bitmap qzV;

    static final class a implements Runnable {
        String key;
        String path;
        boolean qzW;
        WeakReference<c> qzX;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(25022);
            Bitmap aml = d.aml(this.path);
            c cVar = (c) this.qzX.get();
            if (cVar != null) {
                if (!(bo.isNullOrNil(this.key) || aml == null)) {
                    cVar.qzU.put(this.key, aml);
                }
                b bVar = new b();
                bVar.key = this.key;
                bVar.mQQ = aml;
                bVar.qzX = this.qzX;
                if (this.qzW) {
                    al.d(bVar);
                }
            }
            AppMethodBeat.o(25022);
        }
    }

    static final class b implements Runnable {
        String key;
        Bitmap mQQ;
        WeakReference<c> qzX;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(25023);
            c cVar = (c) this.qzX.get();
            if (cVar != null) {
                cVar.r(this.key, this.mQQ);
            }
            AppMethodBeat.o(25023);
        }
    }

    public abstract void r(String str, Bitmap bitmap);

    public final Bitmap x(String str, String str2, boolean z) {
        if (bo.isNullOrNil(str)) {
            return cly();
        }
        Bitmap bitmap = (Bitmap) this.qzU.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        a aVar = new a();
        aVar.key = str;
        aVar.path = str2;
        aVar.qzW = z;
        aVar.qzX = new WeakReference(this);
        if (z) {
            aw.RS().aa(aVar);
        } else {
            aVar.run();
            bitmap = (Bitmap) this.qzU.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return cly();
    }

    private Bitmap cly() {
        if (this.qzV == null) {
            this.qzV = d.LV(R.raw.panel_icon_pic);
        }
        return this.qzV;
    }
}
