package com.tencent.p177mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/* renamed from: com.tencent.mm.vfs.RawFileSystem */
public class RawFileSystem extends FileBasedFileSystem {
    public static final Creator<RawFileSystem> CREATOR = new C57251();
    private volatile boolean zZJ;

    /* renamed from: com.tencent.mm.vfs.RawFileSystem$1 */
    static class C57251 implements Creator<RawFileSystem> {
        C57251() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RawFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(54579);
            RawFileSystem rawFileSystem = new RawFileSystem(parcel, (byte) 0);
            AppMethodBeat.m2505o(54579);
            return rawFileSystem;
        }
    }

    /* renamed from: com.tencent.mm.vfs.RawFileSystem$a */
    static class C5726a extends FileInputStream {
        private long aMp = 0;

        C5726a(String str) {
            super(str);
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i) {
            AppMethodBeat.m2504i(54580);
            try {
                this.aMp = getChannel().position();
                AppMethodBeat.m2505o(54580);
            } catch (IOException e) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.m2505o(54580);
                throw runtimeException;
            }
        }

        public final void reset() {
            AppMethodBeat.m2504i(54581);
            getChannel().position(this.aMp);
            AppMethodBeat.m2505o(54581);
        }
    }

    public RawFileSystem(String str) {
        super(str);
    }

    public RawFileSystem(String str, byte b) {
        super(str);
    }

    private RawFileSystem(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(54582);
        C5736j.m8647a(parcel, getClass());
        AppMethodBeat.m2505o(54582);
    }

    public final int aiR() {
        AppMethodBeat.m2504i(54583);
        int aiR = super.aiR() | 2;
        if (this.zZJ) {
            aiR |= 4;
        }
        AppMethodBeat.m2505o(54583);
        return aiR;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(54584);
        String O = mo11610O(str, false);
        if (O == null) {
            IOException iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(54584);
            throw iOException;
        }
        C5726a c5726a = new C5726a(O);
        AppMethodBeat.m2505o(54584);
        return c5726a;
    }

    /* renamed from: p */
    public final void mo11616p(Map<String, String> map) {
        AppMethodBeat.m2504i(54586);
        super.mo11616p(map);
        String dMt = dMt();
        String str = (String) map.get("data");
        boolean z = dMt == null || str == null || !dMt.startsWith(str);
        this.zZJ = z;
        AppMethodBeat.m2505o(54586);
    }

    public String toString() {
        AppMethodBeat.m2504i(54587);
        StringBuilder append = new StringBuilder("RawFS [").append(dMt());
        if (this.mReadOnly) {
            append.append(", read-only");
        }
        String stringBuilder = append.append(']').toString();
        AppMethodBeat.m2505o(54587);
        return stringBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(54588);
        super.writeToParcel(parcel, i);
        parcel.writeInt(1);
        AppMethodBeat.m2505o(54588);
    }

    static {
        AppMethodBeat.m2504i(54589);
        AppMethodBeat.m2505o(54589);
    }

    /* renamed from: L */
    public final OutputStream mo11607L(String str, boolean z) {
        AppMethodBeat.m2504i(54585);
        IOException iOException;
        if (this.mReadOnly) {
            iOException = new IOException("Cannot open files for writing on read-only file systems");
            AppMethodBeat.m2505o(54585);
            throw iOException;
        }
        String O = mo11610O(str, true);
        if (O == null) {
            iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(54585);
            throw iOException;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(O, z);
        AppMethodBeat.m2505o(54585);
        return fileOutputStream;
    }
}
