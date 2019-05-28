package com.tencent.mm.modelsfs;

import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystem.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SFSFileSystem implements FileSystem {
    public static final Creator<SFSFileSystem> CREATOR = new Creator<SFSFileSystem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SFSFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(93241);
            SFSFileSystem sFSFileSystem = new SFSFileSystem(parcel, (byte) 0);
            AppMethodBeat.o(93241);
            return sFSFileSystem;
        }
    };
    private SFSContext fOk;
    private final Builder fOl;

    /* synthetic */ SFSFileSystem(Parcel parcel, byte b) {
        this(parcel);
    }

    private SFSFileSystem(Parcel parcel) {
        AppMethodBeat.i(93242);
        this.fOl = (Builder) parcel.readParcelable(SFSContext.class.getClassLoader());
        AppMethodBeat.o(93242);
    }

    private void aiQ() {
        AppMethodBeat.i(93243);
        if (this.fOk == null) {
            this.fOk = this.fOl.create();
        }
        AppMethodBeat.o(93243);
    }

    public final int aiR() {
        return 9;
    }

    public final b tn(String str) {
        AppMethodBeat.i(93244);
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        b bVar = new b();
        bVar.xBy = (long) statFs.getBlockSize();
        bVar.xBx = (long) statFs.getAvailableBlocks();
        bVar.xBv = (long) statFs.getBlockCount();
        bVar.zYP = bVar.xBx * bVar.xBy;
        bVar.zYQ = bVar.xBv * bVar.xBy;
        AppMethodBeat.o(93244);
        return bVar;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(93245);
        aiQ();
        InputStream openRead = this.fOk.openRead(str);
        AppMethodBeat.o(93245);
        return openRead;
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(93246);
        aiQ();
        OutputStream pH = this.fOk.pH(str);
        AppMethodBeat.o(93246);
        return pH;
    }

    public final boolean exists(String str) {
        AppMethodBeat.i(93247);
        aiQ();
        boolean exists = this.fOk.exists(str);
        AppMethodBeat.o(93247);
        return exists;
    }

    private a a(FileEntry fileEntry) {
        AppMethodBeat.i(93248);
        a aVar = new a(this, fileEntry.name, fileEntry.name.substring(fileEntry.name.lastIndexOf(47) + 1), fileEntry.size, (fileEntry.size + 4095) & -4096, fileEntry.timestamp, false);
        AppMethodBeat.o(93248);
        return aVar;
    }

    public final a to(String str) {
        AppMethodBeat.i(93249);
        aiQ();
        FileEntry tm = this.fOk.tm(str);
        if (tm == null) {
            AppMethodBeat.o(93249);
            return null;
        }
        a a = a(tm);
        AppMethodBeat.o(93249);
        return a;
    }

    public final boolean t(String str, long j) {
        return false;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(93250);
        aiQ();
        boolean pI = this.fOk.pI(str);
        AppMethodBeat.o(93250);
        return pI;
    }

    public final List<a> M(String str, boolean z) {
        AppMethodBeat.i(93251);
        aiQ();
        try {
            List<FileEntry> tl = this.fOk.tl(str);
            ArrayList arrayList = new ArrayList(tl.size());
            for (FileEntry a : tl) {
                arrayList.add(a(a));
            }
            AppMethodBeat.o(93251);
            return arrayList;
        } catch (IOException e) {
            AppMethodBeat.o(93251);
            return null;
        }
    }

    public final boolean tf(String str) {
        return true;
    }

    public final boolean N(String str, boolean z) {
        AppMethodBeat.i(93252);
        aiQ();
        try {
            for (FileEntry fileEntry : this.fOk.tl(str)) {
                this.fOk.pI(fileEntry.name);
            }
            AppMethodBeat.o(93252);
            return true;
        } catch (IOException e) {
            AppMethodBeat.o(93252);
            return false;
        }
    }

    public final boolean aS(String str, String str2) {
        return false;
    }

    public final String O(String str, boolean z) {
        return null;
    }

    public final void p(Map<String, String> map) {
    }

    public final void a(CancellationSignal cancellationSignal) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(93253);
        parcel.writeParcelable(this.fOl, i);
        AppMethodBeat.o(93253);
    }

    static {
        AppMethodBeat.i(93254);
        AppMethodBeat.o(93254);
    }
}
