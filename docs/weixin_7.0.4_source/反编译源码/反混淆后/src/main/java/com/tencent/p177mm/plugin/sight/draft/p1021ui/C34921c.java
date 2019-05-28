package com.tencent.p177mm.plugin.sight.draft.p1021ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.sight.draft.ui.c */
public abstract class C34921c {
    C1177f<String, Bitmap> qzU = new C7598c(24);
    private Bitmap qzV;

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.c$a */
    static final class C13335a implements Runnable {
        String key;
        String path;
        boolean qzW;
        WeakReference<C34921c> qzX;

        private C13335a() {
        }

        /* synthetic */ C13335a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(25022);
            Bitmap aml = C5056d.aml(this.path);
            C34921c c34921c = (C34921c) this.qzX.get();
            if (c34921c != null) {
                if (!(C5046bo.isNullOrNil(this.key) || aml == null)) {
                    c34921c.qzU.put(this.key, aml);
                }
                C29021b c29021b = new C29021b();
                c29021b.key = this.key;
                c29021b.mQQ = aml;
                c29021b.qzX = this.qzX;
                if (this.qzW) {
                    C5004al.m7441d(c29021b);
                }
            }
            AppMethodBeat.m2505o(25022);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.c$b */
    static final class C29021b implements Runnable {
        String key;
        Bitmap mQQ;
        WeakReference<C34921c> qzX;

        private C29021b() {
        }

        /* synthetic */ C29021b(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(25023);
            C34921c c34921c = (C34921c) this.qzX.get();
            if (c34921c != null) {
                c34921c.mo25419r(this.key, this.mQQ);
            }
            AppMethodBeat.m2505o(25023);
        }
    }

    /* renamed from: r */
    public abstract void mo25419r(String str, Bitmap bitmap);

    /* renamed from: x */
    public final Bitmap mo55516x(String str, String str2, boolean z) {
        if (C5046bo.isNullOrNil(str)) {
            return cly();
        }
        Bitmap bitmap = (Bitmap) this.qzU.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        C13335a c13335a = new C13335a();
        c13335a.key = str;
        c13335a.path = str2;
        c13335a.qzW = z;
        c13335a.qzX = new WeakReference(this);
        if (z) {
            C9638aw.m17180RS().mo10302aa(c13335a);
        } else {
            c13335a.run();
            bitmap = (Bitmap) this.qzU.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return cly();
    }

    private Bitmap cly() {
        if (this.qzV == null) {
            this.qzV = C5056d.m7610LV(C1318a.panel_icon_pic);
        }
        return this.qzV;
    }
}
