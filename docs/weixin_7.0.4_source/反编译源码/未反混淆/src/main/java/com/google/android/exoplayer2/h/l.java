package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

public final class l implements f {
    private f aSF;
    private final u<? super f> bpJ;
    private final f bql;
    private f bqm;
    private f bqn;
    private f bqo;
    private f bqp;
    private final Context context;

    public l(Context context, u<? super f> uVar, f fVar) {
        AppMethodBeat.i(95816);
        this.context = context.getApplicationContext();
        this.bpJ = uVar;
        this.bql = (f) a.checkNotNull(fVar);
        AppMethodBeat.o(95816);
    }

    public final long a(i iVar) {
        AppMethodBeat.i(95817);
        a.checkState(this.aSF == null);
        String scheme = iVar.uri.getScheme();
        if (v.o(iVar.uri)) {
            if (iVar.uri.getPath().startsWith("/android_asset/")) {
                this.aSF = ts();
            } else {
                if (this.bqm == null) {
                    this.bqm = new p(this.bpJ);
                }
                this.aSF = this.bqm;
            }
        } else if ("asset".equals(scheme)) {
            this.aSF = ts();
        } else if (b.CONTENT.equals(scheme)) {
            if (this.bqo == null) {
                this.bqo = new e(this.context, this.bpJ);
            }
            this.aSF = this.bqo;
        } else if ("rtmp".equals(scheme)) {
            this.aSF = tt();
        } else {
            this.aSF = this.bql;
        }
        long a = this.aSF.a(iVar);
        AppMethodBeat.o(95817);
        return a;
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95818);
        int read = this.aSF.read(bArr, i, i2);
        AppMethodBeat.o(95818);
        return read;
    }

    public final Uri getUri() {
        AppMethodBeat.i(95819);
        if (this.aSF == null) {
            AppMethodBeat.o(95819);
            return null;
        }
        Uri uri = this.aSF.getUri();
        AppMethodBeat.o(95819);
        return uri;
    }

    public final void close() {
        AppMethodBeat.i(95820);
        if (this.aSF != null) {
            try {
                this.aSF.close();
            } finally {
                this.aSF = null;
                AppMethodBeat.o(95820);
            }
        } else {
            AppMethodBeat.o(95820);
        }
    }

    private f ts() {
        AppMethodBeat.i(95821);
        if (this.bqn == null) {
            this.bqn = new c(this.context, this.bpJ);
        }
        f fVar = this.bqn;
        AppMethodBeat.o(95821);
        return fVar;
    }

    private f tt() {
        AppMethodBeat.i(95822);
        if (this.bqp == null) {
            try {
                this.bqp = (f) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            }
            if (this.bqp == null) {
                this.bqp = this.bql;
            }
        }
        f fVar = this.bqp;
        AppMethodBeat.o(95822);
        return fVar;
    }
}
