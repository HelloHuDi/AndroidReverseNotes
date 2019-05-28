package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class RawFileSystem extends FileBasedFileSystem {
    public static final Creator<RawFileSystem> CREATOR = new Creator<RawFileSystem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RawFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(54579);
            RawFileSystem rawFileSystem = new RawFileSystem(parcel, (byte) 0);
            AppMethodBeat.o(54579);
            return rawFileSystem;
        }
    };
    private volatile boolean zZJ;

    static class a extends FileInputStream {
        private long aMp = 0;

        a(String str) {
            super(str);
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i) {
            AppMethodBeat.i(54580);
            try {
                this.aMp = getChannel().position();
                AppMethodBeat.o(54580);
            } catch (IOException e) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.o(54580);
                throw runtimeException;
            }
        }

        public final void reset() {
            AppMethodBeat.i(54581);
            getChannel().position(this.aMp);
            AppMethodBeat.o(54581);
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
        AppMethodBeat.i(54582);
        j.a(parcel, getClass());
        AppMethodBeat.o(54582);
    }

    public final int aiR() {
        AppMethodBeat.i(54583);
        int aiR = super.aiR() | 2;
        if (this.zZJ) {
            aiR |= 4;
        }
        AppMethodBeat.o(54583);
        return aiR;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(54584);
        String O = O(str, false);
        if (O == null) {
            IOException iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
            AppMethodBeat.o(54584);
            throw iOException;
        }
        a aVar = new a(O);
        AppMethodBeat.o(54584);
        return aVar;
    }

    public final void p(Map<String, String> map) {
        AppMethodBeat.i(54586);
        super.p(map);
        String dMt = dMt();
        String str = (String) map.get("data");
        boolean z = dMt == null || str == null || !dMt.startsWith(str);
        this.zZJ = z;
        AppMethodBeat.o(54586);
    }

    public String toString() {
        AppMethodBeat.i(54587);
        StringBuilder append = new StringBuilder("RawFS [").append(dMt());
        if (this.mReadOnly) {
            append.append(", read-only");
        }
        String stringBuilder = append.append(']').toString();
        AppMethodBeat.o(54587);
        return stringBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(54588);
        super.writeToParcel(parcel, i);
        parcel.writeInt(1);
        AppMethodBeat.o(54588);
    }

    static {
        AppMethodBeat.i(54589);
        AppMethodBeat.o(54589);
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54585);
        IOException iOException;
        if (this.mReadOnly) {
            iOException = new IOException("Cannot open files for writing on read-only file systems");
            AppMethodBeat.o(54585);
            throw iOException;
        }
        String O = O(str, true);
        if (O == null) {
            iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
            AppMethodBeat.o(54585);
            throw iOException;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(O, z);
        AppMethodBeat.o(54585);
        return fileOutputStream;
    }
}
