package com.google.android.exoplayer2.p110h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.exoplayer2.h.l */
public final class C45038l implements C0867f {
    private C0867f aSF;
    private final C41615u<? super C0867f> bpJ;
    private final C0867f bql;
    private C0867f bqm;
    private C0867f bqn;
    private C0867f bqo;
    private C0867f bqp;
    private final Context context;

    public C45038l(Context context, C41615u<? super C0867f> c41615u, C0867f c0867f) {
        AppMethodBeat.m2504i(95816);
        this.context = context.getApplicationContext();
        this.bpJ = c41615u;
        this.bql = (C0867f) C45039a.checkNotNull(c0867f);
        AppMethodBeat.m2505o(95816);
    }

    /* renamed from: a */
    public final long mo2583a(C17665i c17665i) {
        AppMethodBeat.m2504i(95817);
        C45039a.checkState(this.aSF == null);
        String scheme = c17665i.uri.getScheme();
        if (C17675v.m27577o(c17665i.uri)) {
            if (c17665i.uri.getPath().startsWith("/android_asset/")) {
                this.aSF = m82570ts();
            } else {
                if (this.bqm == null) {
                    this.bqm = new C17666p(this.bpJ);
                }
                this.aSF = this.bqm;
            }
        } else if ("asset".equals(scheme)) {
            this.aSF = m82570ts();
        } else if (C8741b.CONTENT.equals(scheme)) {
            if (this.bqo == null) {
                this.bqo = new C37260e(this.context, this.bpJ);
            }
            this.aSF = this.bqo;
        } else if ("rtmp".equals(scheme)) {
            this.aSF = m82571tt();
        } else {
            this.aSF = this.bql;
        }
        long a = this.aSF.mo2583a(c17665i);
        AppMethodBeat.m2505o(95817);
        return a;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95818);
        int read = this.aSF.read(bArr, i, i2);
        AppMethodBeat.m2505o(95818);
        return read;
    }

    public final Uri getUri() {
        AppMethodBeat.m2504i(95819);
        if (this.aSF == null) {
            AppMethodBeat.m2505o(95819);
            return null;
        }
        Uri uri = this.aSF.getUri();
        AppMethodBeat.m2505o(95819);
        return uri;
    }

    public final void close() {
        AppMethodBeat.m2504i(95820);
        if (this.aSF != null) {
            try {
                this.aSF.close();
            } finally {
                this.aSF = null;
                AppMethodBeat.m2505o(95820);
            }
        } else {
            AppMethodBeat.m2505o(95820);
        }
    }

    /* renamed from: ts */
    private C0867f m82570ts() {
        AppMethodBeat.m2504i(95821);
        if (this.bqn == null) {
            this.bqn = new C32054c(this.context, this.bpJ);
        }
        C0867f c0867f = this.bqn;
        AppMethodBeat.m2505o(95821);
        return c0867f;
    }

    /* renamed from: tt */
    private C0867f m82571tt() {
        AppMethodBeat.m2504i(95822);
        if (this.bqp == null) {
            try {
                this.bqp = (C0867f) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            }
            if (this.bqp == null) {
                this.bqp = this.bql;
            }
        }
        C0867f c0867f = this.bqp;
        AppMethodBeat.m2505o(95822);
        return c0867f;
    }
}
