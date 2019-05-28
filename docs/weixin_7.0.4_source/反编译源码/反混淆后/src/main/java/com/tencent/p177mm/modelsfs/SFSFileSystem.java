package com.tencent.p177mm.modelsfs;

import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsfs.SFSContext.Builder;
import com.tencent.p177mm.modelsfs.SFSContext.FileEntry;
import com.tencent.p177mm.vfs.FileSystem;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystem.C5713b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.modelsfs.SFSFileSystem */
public class SFSFileSystem implements FileSystem {
    public static final Creator<SFSFileSystem> CREATOR = new C422171();
    private SFSContext fOk;
    private final Builder fOl;

    /* renamed from: com.tencent.mm.modelsfs.SFSFileSystem$1 */
    static class C422171 implements Creator<SFSFileSystem> {
        C422171() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SFSFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(93241);
            SFSFileSystem sFSFileSystem = new SFSFileSystem(parcel, (byte) 0);
            AppMethodBeat.m2505o(93241);
            return sFSFileSystem;
        }
    }

    /* synthetic */ SFSFileSystem(Parcel parcel, byte b) {
        this(parcel);
    }

    private SFSFileSystem(Parcel parcel) {
        AppMethodBeat.m2504i(93242);
        this.fOl = (Builder) parcel.readParcelable(SFSContext.class.getClassLoader());
        AppMethodBeat.m2505o(93242);
    }

    private void aiQ() {
        AppMethodBeat.m2504i(93243);
        if (this.fOk == null) {
            this.fOk = this.fOl.create();
        }
        AppMethodBeat.m2505o(93243);
    }

    public final int aiR() {
        return 9;
    }

    /* renamed from: tn */
    public final C5713b mo11620tn(String str) {
        AppMethodBeat.m2504i(93244);
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        C5713b c5713b = new C5713b();
        c5713b.xBy = (long) statFs.getBlockSize();
        c5713b.xBx = (long) statFs.getAvailableBlocks();
        c5713b.xBv = (long) statFs.getBlockCount();
        c5713b.zYP = c5713b.xBx * c5713b.xBy;
        c5713b.zYQ = c5713b.xBv * c5713b.xBy;
        AppMethodBeat.m2505o(93244);
        return c5713b;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(93245);
        aiQ();
        InputStream openRead = this.fOk.openRead(str);
        AppMethodBeat.m2505o(93245);
        return openRead;
    }

    /* renamed from: L */
    public final OutputStream mo11607L(String str, boolean z) {
        AppMethodBeat.m2504i(93246);
        aiQ();
        OutputStream pH = this.fOk.mo44222pH(str);
        AppMethodBeat.m2505o(93246);
        return pH;
    }

    public final boolean exists(String str) {
        AppMethodBeat.m2504i(93247);
        aiQ();
        boolean exists = this.fOk.exists(str);
        AppMethodBeat.m2505o(93247);
        return exists;
    }

    /* renamed from: a */
    private C5712a m74496a(FileEntry fileEntry) {
        AppMethodBeat.m2504i(93248);
        C5712a c5712a = new C5712a(this, fileEntry.name, fileEntry.name.substring(fileEntry.name.lastIndexOf(47) + 1), fileEntry.size, (fileEntry.size + 4095) & -4096, fileEntry.timestamp, false);
        AppMethodBeat.m2505o(93248);
        return c5712a;
    }

    /* renamed from: to */
    public final C5712a mo11621to(String str) {
        AppMethodBeat.m2504i(93249);
        aiQ();
        FileEntry tm = this.fOk.mo44226tm(str);
        if (tm == null) {
            AppMethodBeat.m2505o(93249);
            return null;
        }
        C5712a a = m74496a(tm);
        AppMethodBeat.m2505o(93249);
        return a;
    }

    /* renamed from: t */
    public final boolean mo11618t(String str, long j) {
        return false;
    }

    /* renamed from: pI */
    public final boolean mo11617pI(String str) {
        AppMethodBeat.m2504i(93250);
        aiQ();
        boolean pI = this.fOk.mo44223pI(str);
        AppMethodBeat.m2505o(93250);
        return pI;
    }

    /* renamed from: M */
    public final List<C5712a> mo11608M(String str, boolean z) {
        AppMethodBeat.m2504i(93251);
        aiQ();
        try {
            List<FileEntry> tl = this.fOk.mo44225tl(str);
            ArrayList arrayList = new ArrayList(tl.size());
            for (FileEntry a : tl) {
                arrayList.add(m74496a(a));
            }
            AppMethodBeat.m2505o(93251);
            return arrayList;
        } catch (IOException e) {
            AppMethodBeat.m2505o(93251);
            return null;
        }
    }

    /* renamed from: tf */
    public final boolean mo11619tf(String str) {
        return true;
    }

    /* renamed from: N */
    public final boolean mo11609N(String str, boolean z) {
        AppMethodBeat.m2504i(93252);
        aiQ();
        try {
            for (FileEntry fileEntry : this.fOk.mo44225tl(str)) {
                this.fOk.mo44223pI(fileEntry.name);
            }
            AppMethodBeat.m2505o(93252);
            return true;
        } catch (IOException e) {
            AppMethodBeat.m2505o(93252);
            return false;
        }
    }

    /* renamed from: aS */
    public final boolean mo11612aS(String str, String str2) {
        return false;
    }

    /* renamed from: O */
    public final String mo11610O(String str, boolean z) {
        return null;
    }

    /* renamed from: p */
    public final void mo11616p(Map<String, String> map) {
    }

    /* renamed from: a */
    public final void mo11611a(CancellationSignal cancellationSignal) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(93253);
        parcel.writeParcelable(this.fOl, i);
        AppMethodBeat.m2505o(93253);
    }

    static {
        AppMethodBeat.m2504i(93254);
        AppMethodBeat.m2505o(93254);
    }
}
