package com.tencent.p127d.p132e.p133a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.p134a.C41661f;

/* renamed from: com.tencent.d.e.a.d */
public final class C8766d {
    int Atn;
    long Ato;
    int action;
    Context context;
    int requestType;
    long xzH;

    /* renamed from: com.tencent.d.e.a.d$a */
    public static final class C8767a {
        int Atn;
        public long Ato;
        int action;
        Context context;
        int requestType;
        long xzH;

        public /* synthetic */ C8767a(Context context, int i, int i2, byte b) {
            this(context, i, i2);
        }

        private C8767a(Context context, int i, int i2) {
            AppMethodBeat.m2504i(114534);
            this.requestType = 0;
            this.Atn = 0;
            this.action = 0;
            this.Ato = C41661f.AtG * 12;
            this.xzH = 0;
            if (i < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(114534);
                throw illegalArgumentException;
            }
            this.context = context.getApplicationContext();
            this.Atn = i;
            this.action = i2;
            AppMethodBeat.m2505o(114534);
        }
    }

    public /* synthetic */ C8766d(C8767a c8767a, byte b) {
        this(c8767a);
    }

    private C8766d(C8767a c8767a) {
        this.requestType = c8767a.requestType;
        this.Atn = c8767a.Atn;
        this.action = c8767a.action;
        this.Ato = c8767a.Ato;
        this.xzH = c8767a.xzH;
        this.context = c8767a.context;
    }
}
