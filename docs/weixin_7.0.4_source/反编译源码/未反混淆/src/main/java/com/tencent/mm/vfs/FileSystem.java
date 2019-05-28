package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface FileSystem extends Parcelable {

    public static class a {
        public final String name;
        public final long size;
        public final String zYK;
        public final long zYL;
        public final long zYM;
        public final boolean zYN;
        private final FileSystem zYO;

        public a(FileSystem fileSystem, String str, String str2, long j, long j2, long j3, boolean z) {
            this.zYO = fileSystem;
            this.zYK = str;
            this.name = str2;
            this.size = j;
            this.zYL = j2;
            this.zYM = j3;
            this.zYN = z;
        }

        public final InputStream dMu() {
            AppMethodBeat.i(54504);
            InputStream openRead = this.zYO.openRead(this.zYK);
            AppMethodBeat.o(54504);
            return openRead;
        }

        public final boolean delete() {
            AppMethodBeat.i(54505);
            boolean N;
            if (this.zYN) {
                N = this.zYO.N(this.zYK, false);
                AppMethodBeat.o(54505);
                return N;
            }
            N = this.zYO.pI(this.zYK);
            AppMethodBeat.o(54505);
            return N;
        }

        public final String toString() {
            AppMethodBeat.i(54506);
            String str = this.zYK + " -> " + this.zYO.toString();
            if (this.zYN) {
                str = "[DIR] ".concat(String.valueOf(str));
                AppMethodBeat.o(54506);
                return str;
            }
            AppMethodBeat.o(54506);
            return str;
        }
    }

    public static class b {
        public long xBv;
        public long xBx;
        public long xBy;
        public long zYP;
        public long zYQ;
    }

    OutputStream L(String str, boolean z);

    List<a> M(String str, boolean z);

    boolean N(String str, boolean z);

    String O(String str, boolean z);

    void a(CancellationSignal cancellationSignal);

    boolean aS(String str, String str2);

    int aiR();

    boolean exists(String str);

    InputStream openRead(String str);

    void p(Map<String, String> map);

    boolean pI(String str);

    boolean t(String str, long j);

    boolean tf(String str);

    b tn(String str);

    a to(String str);
}
