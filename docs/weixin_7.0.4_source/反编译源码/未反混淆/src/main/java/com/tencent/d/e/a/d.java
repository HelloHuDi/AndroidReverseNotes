package com.tencent.d.e.a;

import android.content.Context;
import com.tencent.d.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    int Atn;
    long Ato;
    int action;
    Context context;
    int requestType;
    long xzH;

    public static final class a {
        int Atn;
        public long Ato;
        int action;
        Context context;
        int requestType;
        long xzH;

        public /* synthetic */ a(Context context, int i, int i2, byte b) {
            this(context, i, i2);
        }

        private a(Context context, int i, int i2) {
            AppMethodBeat.i(114534);
            this.requestType = 0;
            this.Atn = 0;
            this.action = 0;
            this.Ato = f.AtG * 12;
            this.xzH = 0;
            if (i < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(i)));
                AppMethodBeat.o(114534);
                throw illegalArgumentException;
            }
            this.context = context.getApplicationContext();
            this.Atn = i;
            this.action = i2;
            AppMethodBeat.o(114534);
        }
    }

    public /* synthetic */ d(a aVar, byte b) {
        this(aVar);
    }

    private d(a aVar) {
        this.requestType = aVar.requestType;
        this.Atn = aVar.Atn;
        this.action = aVar.action;
        this.Ato = aVar.Ato;
        this.xzH = aVar.xzH;
        this.context = aVar.context;
    }
}
