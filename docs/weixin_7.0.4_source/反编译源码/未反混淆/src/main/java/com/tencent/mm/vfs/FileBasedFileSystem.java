package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class FileBasedFileSystem extends AbstractFileSystem {
    final boolean mReadOnly;
    private final String zYG;
    private final boolean zYH;
    private volatile String zYI;
    private volatile long zYJ = 512;

    @TargetApi(21)
    static final class a {
        static com.tencent.mm.vfs.FileSystem.a a(File file, FileSystem fileSystem, String str, String str2) {
            AppMethodBeat.i(54503);
            try {
                StructStat stat = Os.stat(file.getPath());
                if (stat == null) {
                    AppMethodBeat.o(54503);
                    return null;
                }
                boolean S_ISDIR = OsConstants.S_ISDIR(stat.st_mode);
                com.tencent.mm.vfs.FileSystem.a aVar = new com.tencent.mm.vfs.FileSystem.a(fileSystem, str, str2, stat.st_size, stat.st_blocks * 512, 1000 * stat.st_mtime, S_ISDIR);
                AppMethodBeat.o(54503);
                return aVar;
            } catch (ErrnoException e) {
                AppMethodBeat.o(54503);
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
        String H = j.H(this.zYG, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        if (H != null) {
            asW(H);
            this.zYH = true;
            return;
        }
        this.zYI = null;
        this.zYH = false;
    }

    protected FileBasedFileSystem(Parcel parcel) {
        j.a(parcel, getClass());
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
        readString = j.H(this.zYG, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
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
                b.e("VFS.FileBasedFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + file.getPath());
                file.delete();
            }
            if (!file.mkdirs()) {
                b.e("VFS.FileBasedFileSystem", "Base directory cannot be created. Base path: " + file.getPath());
            }
        }
        try {
            int blockSize = new StatFs(file.getPath()).getBlockSize();
            if (((blockSize - 1) & blockSize) == 0) {
                this.zYJ = (long) blockSize;
            } else {
                b.w("VFS.FileBasedFileSystem", "Non-power-of-two block size: " + blockSize + ", use default: 4096");
                this.zYJ = 4096;
            }
        } catch (Exception e2) {
            b.b("VFS.FileBasedFileSystem", e2, "Failed to retrieve block size.");
            this.zYJ = 4096;
        }
        this.zYI = file.getPath();
        b.i("VFS.FileBasedFileSystem", "Real path resolved: " + this.zYG + " => " + this.zYI);
    }

    public int aiR() {
        if (this.mReadOnly) {
            return 56;
        }
        return 57;
    }

    public final FileSystem.b tn(String str) {
        if (str == null) {
            str = "";
        }
        try {
            StatFs statFs = new StatFs(O(str, false));
            FileSystem.b bVar = new FileSystem.b();
            if (VERSION.SDK_INT >= 18) {
                bVar.xBy = statFs.getBlockSizeLong();
                bVar.xBx = statFs.getAvailableBlocksLong();
                bVar.xBv = statFs.getBlockCountLong();
            } else {
                bVar.xBy = (long) statFs.getBlockSize();
                bVar.xBx = (long) statFs.getAvailableBlocks();
                bVar.xBv = (long) statFs.getBlockCount();
            }
            bVar.zYP = bVar.xBx * bVar.xBy;
            bVar.zYQ = bVar.xBv * bVar.xBy;
            return bVar;
        } catch (RuntimeException e) {
            return null;
        }
    }

    public final boolean exists(String str) {
        String O = O(str, false);
        if (O == null || !new File(O).exists()) {
            return false;
        }
        return true;
    }

    public final com.tencent.mm.vfs.FileSystem.a to(String str) {
        return ad(new File(O(str, false)));
    }

    public final boolean t(String str, long j) {
        return new File(O(str, true)).setLastModified(j);
    }

    public final List<com.tencent.mm.vfs.FileSystem.a> M(String str, boolean z) {
        File file = new File(O(str, false));
        if (!file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            return a(file, arrayList);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File ad : listFiles) {
            com.tencent.mm.vfs.FileSystem.a ad2 = ad(ad);
            if (ad2 != null) {
                arrayList.add(ad2);
            }
        }
        return arrayList;
    }

    private List<com.tencent.mm.vfs.FileSystem.a> a(File file, ArrayList<com.tencent.mm.vfs.FileSystem.a> arrayList) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            com.tencent.mm.vfs.FileSystem.a ad = ad(file2);
            if (ad != null) {
                arrayList.add(ad);
                if (ad.zYN) {
                    a(file2, arrayList);
                }
            }
        }
        return arrayList;
    }

    private com.tencent.mm.vfs.FileSystem.a ad(File file) {
        String str;
        String str2 = this.zYI;
        if (file.getPath().length() == str2.length()) {
            str = "";
        } else {
            str = file.getPath().substring(str2.length() + 1);
        }
        String name = file.getName();
        if (VERSION.SDK_INT >= 21) {
            return a.a(file, this, str, name);
        }
        if (!file.exists()) {
            return null;
        }
        boolean isDirectory = file.isDirectory();
        long length = file.length();
        return new com.tencent.mm.vfs.FileSystem.a(this, str, name, length, ((this.zYJ - 1) ^ -1) & ((this.zYJ + length) - 1), file.lastModified(), isDirectory);
    }

    public final boolean pI(String str) {
        String O = O(str, false);
        if (O == null) {
            return false;
        }
        return new File(O).delete();
    }

    public final boolean tf(String str) {
        String O = O(str, true);
        if (O == null) {
            return false;
        }
        return new File(O).mkdirs();
    }

    public final boolean N(String str, boolean z) {
        boolean z2 = str.isEmpty() || str.equals("/");
        File file = new File(O(str, false));
        if (file.isDirectory()) {
            return z ? d(file, z2) : file.delete();
        } else {
            return false;
        }
    }

    private static boolean d(File file, boolean z) {
        boolean z2 = true;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                int d;
                if (file2.isDirectory()) {
                    d = d(file2, false);
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

    public final boolean aS(String str, String str2) {
        String O = O(str, false);
        String O2 = O(str2, true);
        if (O == null || O2 == null) {
            return false;
        }
        return new File(O).renameTo(new File(O2));
    }

    public final String O(String str, boolean z) {
        String str2 = this.zYI;
        if (str2 != null) {
            return str.isEmpty() ? str2 : str2 + IOUtils.DIR_SEPARATOR_UNIX + str;
        } else {
            throw new IllegalStateException("Base path cannot be resolved: " + this.zYG);
        }
    }

    public void p(Map<String, String> map) {
        if (!this.zYH) {
            String str = this.zYI;
            String H = j.H(this.zYG, map);
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
