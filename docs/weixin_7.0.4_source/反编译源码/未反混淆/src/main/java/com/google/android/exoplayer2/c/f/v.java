package com.google.android.exoplayer2.c.f;

import android.support.v4.widget.j;
import android.util.SparseArray;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public interface v {

    public static final class b {
        public final String aOt;
        public final List<a> bdJ;
        public final byte[] bdK;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            List emptyList;
            AppMethodBeat.i(95178);
            this.streamType = i;
            this.aOt = str;
            if (list == null) {
                emptyList = Collections.emptyList();
            } else {
                emptyList = Collections.unmodifiableList(list);
            }
            this.bdJ = emptyList;
            this.bdK = bArr;
            AppMethodBeat.o(95178);
        }
    }

    public static final class d {
        private String bbx;
        private final String bdL;
        private final int bdM;
        private final int bdN;
        private int bdO;

        public d(int i, int i2) {
            this(j.INVALID_ID, i, i2);
        }

        public d(int i, int i2, int i3) {
            AppMethodBeat.i(95179);
            this.bdL = i != j.INVALID_ID ? i + "/" : "";
            this.bdM = i2;
            this.bdN = i3;
            this.bdO = j.INVALID_ID;
            AppMethodBeat.o(95179);
        }

        public final void rz() {
            AppMethodBeat.i(95180);
            this.bdO = this.bdO == j.INVALID_ID ? this.bdM : this.bdO + this.bdN;
            this.bbx = this.bdL + this.bdO;
            AppMethodBeat.o(95180);
        }

        public final int rA() {
            AppMethodBeat.i(95181);
            rC();
            int i = this.bdO;
            AppMethodBeat.o(95181);
            return i;
        }

        public final String rB() {
            AppMethodBeat.i(95182);
            rC();
            String str = this.bbx;
            AppMethodBeat.o(95182);
            return str;
        }

        private void rC() {
            AppMethodBeat.i(95183);
            if (this.bdO == j.INVALID_ID) {
                IllegalStateException illegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
                AppMethodBeat.o(95183);
                throw illegalStateException;
            }
            AppMethodBeat.o(95183);
        }
    }

    public static final class a {
        public final String aOt;
        public final byte[] bdI;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.aOt = str;
            this.type = i;
            this.bdI = bArr;
        }
    }

    public interface c {
        v a(int i, b bVar);

        SparseArray<v> rv();
    }

    void a(l lVar, boolean z);

    void a(s sVar, g gVar, d dVar);

    void rn();
}
