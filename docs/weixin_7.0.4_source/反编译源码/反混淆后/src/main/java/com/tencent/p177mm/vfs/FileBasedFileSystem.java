package com.tencent.p177mm.vfs;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystem.C5713b;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.vfs.FileBasedFileSystem */
public abstract class FileBasedFileSystem extends AbstractFileSystem {
    final boolean mReadOnly;
    private final String zYG;
    private final boolean zYH;
    private volatile String zYI;
    private volatile long zYJ = 512;

    @TargetApi(21)
    /* renamed from: com.tencent.mm.vfs.FileBasedFileSystem$a */
    static final class C5711a {
        /* renamed from: a */
        static C5712a m8578a(File file, FileSystem fileSystem, String str, String str2) {
            AppMethodBeat.m2504i(54503);
            try {
                StructStat stat = Os.stat(file.getPath());
                if (stat == null) {
                    AppMethodBeat.m2505o(54503);
                    return null;
                }
                boolean S_ISDIR = OsConstants.S_ISDIR(stat.st_mode);
                C5712a c5712a = new C5712a(fileSystem, str, str2, stat.st_size, stat.st_blocks * 512, 1000 * stat.st_mtime, S_ISDIR);
                AppMethodBeat.m2505o(54503);
                return c5712a;
            } catch (ErrnoException e) {
                AppMethodBeat.m2505o(54503);
                return null;
            }
        }
    }

    protected FileBasedFileSystem(String str) {
        this.zYG = str;
        this.mReadOnly = false;
        if (this.zYG.isEmpty()) {
            this.zYI = this.zYG;
            this.zYH = true;
            return;
        }
        String H = C5736j.m8646H(this.zYG, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        if (H != null) {
            asW(H);
            this.zYH = true;
            return;
        }
        this.zYI = null;
        this.zYH = false;
    }

    protected FileBasedFileSystem(Parcel parcel) {
        C5736j.m8647a(parcel, getClass());
        String readString = parcel.readString();
        if (readString == null) {
            readString = "";
        }
        this.zYG = readString;
        this.mReadOnly = parcel.readByte() != (byte) 0;
        if (this.zYG.isEmpty()) {
            this.zYI = this.zYG;
            this.zYH = true;
            return;
        }
        readString = C5736j.m8646H(this.zYG, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        if (readString != null) {
            asW(readString);
            this.zYH = true;
            return;
        }
        this.zYI = null;
        this.zYH = false;
    }

    private void asW(String str) {
        File file = new File(str);
        try {
            file = file.getCanonicalFile();
        } catch (IOException e) {
            file = file.getAbsoluteFile();
        }
        if (!file.isDirectory()) {
            if (file.exists()) {
                C0926b.m2103e("VFS.FileBasedFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + file.getPath());
                file.delete();
            }
            if (!file.mkdirs()) {
                C0926b.m2103e("VFS.FileBasedFileSystem", "Base directory cannot be created. Base path: " + file.getPath());
            }
        }
        try {
            int blockSize = new StatFs(file.getPath()).getBlockSize();
            if (((blockSize - 1) & blockSize) == 0) {
                this.zYJ = (long) blockSize;
            } else {
                C0926b.m2107w("VFS.FileBasedFileSystem", "Non-power-of-two block size: " + blockSize + ", use default: 4096");
                this.zYJ = 4096;
            }
        } catch (Exception e2) {
            C0926b.m2098b("VFS.FileBasedFileSystem", e2, "Failed to retrieve block size.");
            this.zYJ = 4096;
        }
        this.zYI = file.getPath();
        C0926b.m2105i("VFS.FileBasedFileSystem", "Real path resolved: " + this.zYG + " => " + this.zYI);
    }

    public int aiR() {
        if (this.mReadOnly) {
            return 56;
        }
        return 57;
    }

    /* renamed from: tn */
    public final C5713b mo11620tn(String str) {
        if (str == null) {
            str = "";
        }
        try {
            StatFs statFs = new StatFs(mo11610O(str, false));
            C5713b c5713b = new C5713b();
            if (VERSION.SDK_INT >= 18) {
                c5713b.xBy = statFs.getBlockSizeLong();
                c5713b.xBx = statFs.getAvailableBlocksLong();
                c5713b.xBv = statFs.getBlockCountLong();
            } else {
                c5713b.xBy = (long) statFs.getBlockSize();
                c5713b.xBx = (long) statFs.getAvailableBlocks();
                c5713b.xBv = (long) statFs.getBlockCount();
            }
            c5713b.zYP = c5713b.xBx * c5713b.xBy;
            c5713b.zYQ = c5713b.xBv * c5713b.xBy;
            return c5713b;
        } catch (RuntimeException e) {
            return null;
        }
    }

    public final boolean exists(String str) {
        String O = mo11610O(str, false);
        if (O == null || !new File(O).exists()) {
            return false;
        }
        return true;
    }

    /* renamed from: to */
    public final C5712a mo11621to(String str) {
        return m13458ad(new File(mo11610O(str, false)));
    }

    /* renamed from: t */
    public final boolean mo11618t(String str, long j) {
        return new File(mo11610O(str, true)).setLastModified(j);
    }

    /* renamed from: M */
    public final List<C5712a> mo11608M(String str, boolean z) {
        File file = new File(mo11610O(str, false));
        if (!file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            return m13457a(file, arrayList);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File ad : listFiles) {
            C5712a ad2 = m13458ad(ad);
            if (ad2 != null) {
                arrayList.add(ad2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C5712a> m13457a(File file, ArrayList<C5712a> arrayList) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            C5712a ad = m13458ad(file2);
            if (ad != null) {
                arrayList.add(ad);
                if (ad.zYN) {
                    m13457a(file2, arrayList);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ad */
    private C5712a m13458ad(File file) {
        String str;
        String str2 = this.zYI;
        if (file.getPath().length() == str2.length()) {
            str = "";
        } else {
            str = file.getPath().substring(str2.length() + 1);
        }
        String name = file.getName();
        if (VERSION.SDK_INT >= 21) {
            return C5711a.m8578a(file, this, str, name);
        }
        if (!file.exists()) {
            return null;
        }
        boolean isDirectory = file.isDirectory();
        long length = file.length();
        return new C5712a(this, str, name, length, ((this.zYJ - 1) ^ -1) & ((this.zYJ + length) - 1), file.lastModified(), isDirectory);
    }

    /* renamed from: pI */
    public final boolean mo11617pI(String str) {
        String O = mo11610O(str, false);
        if (O == null) {
            return false;
        }
        return new File(O).delete();
    }

    /* renamed from: tf */
    public final boolean mo11619tf(String str) {
        String O = mo11610O(str, true);
        if (O == null) {
            return false;
        }
        return new File(O).mkdirs();
    }

    /* renamed from: N */
    public final boolean mo11609N(String str, boolean z) {
        boolean z2 = str.isEmpty() || str.equals("/");
        File file = new File(mo11610O(str, false));
        if (file.isDirectory()) {
            return z ? FileBasedFileSystem.m13459d(file, z2) : file.delete();
        } else {
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m13459d(File file, boolean z) {
        boolean z2 = true;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                int d;
                if (file2.isDirectory()) {
                    d = FileBasedFileSystem.m13459d(file2, false);
                } else {
                    d = file2.delete();
                }
                z2 &= d;
            }
        }
        if (z) {
            return z2;
        }
        return z2 & file.delete();
    }

    /* renamed from: aS */
    public final boolean mo11612aS(String str, String str2) {
        String O = mo11610O(str, false);
        String O2 = mo11610O(str2, true);
        if (O == null || O2 == null) {
            return false;
        }
        return new File(O).renameTo(new File(O2));
    }

    /* renamed from: O */
    public final String mo11610O(String str, boolean z) {
        String str2 = this.zYI;
        if (str2 != null) {
            return str.isEmpty() ? str2 : str2 + IOUtils.DIR_SEPARATOR_UNIX + str;
        } else {
            throw new IllegalStateException("Base path cannot be resolved: " + this.zYG);
        }
    }

    /* renamed from: p */
    public void mo11616p(Map<String, String> map) {
        if (!this.zYH) {
            String str = this.zYI;
            String H = C5736j.m8646H(this.zYG, map);
            if (H == null || H.equals(str)) {
                this.zYI = H;
            } else {
                asW(H);
            }
        }
    }

    public final String dMt() {
        String str = this.zYI;
        return str == null ? this.zYG : str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(1);
        parcel.writeString(this.zYG);
        if (!this.mReadOnly) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }
}
