package com.tencent.p177mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.vfs.FileSystem */
public interface FileSystem extends Parcelable {

    /* renamed from: com.tencent.mm.vfs.FileSystem$a */
    public static class C5712a {
        public final String name;
        public final long size;
        public final String zYK;
        public final long zYL;
        public final long zYM;
        public final boolean zYN;
        private final FileSystem zYO;

        public C5712a(FileSystem fileSystem, String str, String str2, long j, long j2, long j3, boolean z) {
            this.zYO = fileSystem;
            this.zYK = str;
            this.name = str2;
            this.size = j;
            this.zYL = j2;
            this.zYM = j3;
            this.zYN = z;
        }

        public final InputStream dMu() {
            AppMethodBeat.m2504i(54504);
            InputStream openRead = this.zYO.openRead(this.zYK);
            AppMethodBeat.m2505o(54504);
            return openRead;
        }

        public final boolean delete() {
            AppMethodBeat.m2504i(54505);
            boolean N;
            if (this.zYN) {
                N = this.zYO.mo11609N(this.zYK, false);
                AppMethodBeat.m2505o(54505);
                return N;
            }
            N = this.zYO.mo11617pI(this.zYK);
            AppMethodBeat.m2505o(54505);
            return N;
        }

        public final String toString() {
            AppMethodBeat.m2504i(54506);
            String str = this.zYK + " -> " + this.zYO.toString();
            if (this.zYN) {
                str = "[DIR] ".concat(String.valueOf(str));
                AppMethodBeat.m2505o(54506);
                return str;
            }
            AppMethodBeat.m2505o(54506);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.vfs.FileSystem$b */
    public static class C5713b {
        public long xBv;
        public long xBx;
        public long xBy;
        public long zYP;
        public long zYQ;
    }

    /* renamed from: L */
    OutputStream mo11607L(String str, boolean z);

    /* renamed from: M */
    List<C5712a> mo11608M(String str, boolean z);

    /* renamed from: N */
    boolean mo11609N(String str, boolean z);

    /* renamed from: O */
    String mo11610O(String str, boolean z);

    /* renamed from: a */
    void mo11611a(CancellationSignal cancellationSignal);

    /* renamed from: aS */
    boolean mo11612aS(String str, String str2);

    int aiR();

    boolean exists(String str);

    InputStream openRead(String str);

    /* renamed from: p */
    void mo11616p(Map<String, String> map);

    /* renamed from: pI */
    boolean mo11617pI(String str);

    /* renamed from: t */
    boolean mo11618t(String str, long j);

    /* renamed from: tf */
    boolean mo11619tf(String str);

    /* renamed from: tn */
    C5713b mo11620tn(String str);

    /* renamed from: to */
    C5712a mo11621to(String str);
}
