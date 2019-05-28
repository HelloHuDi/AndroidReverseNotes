package com.tencent.p177mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.p177mm.vfs.FileSystem.C5713b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.vfs.CombinedFileSystem */
public class CombinedFileSystem extends AbstractFileSystem {
    public static final Creator<CombinedFileSystem> CREATOR = new C363701();
    private final FileSystem[] zYB;
    private final C36371a[] zYC;
    private final int zYD;

    /* renamed from: com.tencent.mm.vfs.CombinedFileSystem$1 */
    static class C363701 implements Creator<CombinedFileSystem> {
        C363701() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CombinedFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(54483);
            CombinedFileSystem combinedFileSystem = new CombinedFileSystem(parcel, (byte) 0);
            AppMethodBeat.m2505o(54483);
            return combinedFileSystem;
        }
    }

    /* renamed from: com.tencent.mm.vfs.CombinedFileSystem$a */
    static final class C36371a {
        final Pattern hnu;
        final int zYE;
        final FileSystem zYF;

        C36371a(Pattern pattern, int i, FileSystem fileSystem) {
            this.hnu = pattern;
            this.zYE = i;
            this.zYF = fileSystem;
        }
    }

    /* synthetic */ CombinedFileSystem(Parcel parcel, byte b) {
        this(parcel);
    }

    private CombinedFileSystem(Parcel parcel) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(54484);
        C5736j.m8647a(parcel, getClass());
        int readInt = parcel.readInt();
        this.zYB = new FileSystem[readInt];
        int i3 = 0;
        for (i = 0; i < readInt; i++) {
            FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
            if (fileSystem == null) {
                ParcelFormatException parcelFormatException = new ParcelFormatException();
                AppMethodBeat.m2505o(54484);
                throw parcelFormatException;
            }
            this.zYB[i] = fileSystem;
            i3 |= fileSystem.aiR();
        }
        this.zYD = i3;
        i = parcel.readInt();
        this.zYC = new C36371a[i];
        while (i2 < i) {
            String readString = parcel.readString();
            Pattern compile = readString == null ? null : Pattern.compile(readString);
            i3 = parcel.readInt();
            this.zYC[i2] = new C36371a(compile, i3, this.zYB[i3]);
            i2++;
        }
        AppMethodBeat.m2505o(54484);
    }

    public final int aiR() {
        return this.zYD;
    }

    /* renamed from: tn */
    public final C5713b mo11620tn(String str) {
        AppMethodBeat.m2504i(54485);
        C5713b tn = this.zYB[this.zYB.length - 1].mo11620tn(str);
        AppMethodBeat.m2505o(54485);
        return tn;
    }

    private FileSystem asV(String str) {
        AppMethodBeat.m2504i(54486);
        for (C36371a c36371a : this.zYC) {
            if (c36371a.hnu == null || c36371a.hnu.matcher(str).matches()) {
                FileSystem fileSystem = c36371a.zYF;
                AppMethodBeat.m2505o(54486);
                return fileSystem;
            }
        }
        AppMethodBeat.m2505o(54486);
        return null;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(54487);
        FileSystem asV = asV(str);
        if (asV == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("No file system matches the path.");
            AppMethodBeat.m2505o(54487);
            throw fileNotFoundException;
        }
        InputStream openRead = asV.openRead(str);
        AppMethodBeat.m2505o(54487);
        return openRead;
    }

    /* renamed from: L */
    public final OutputStream mo11607L(String str, boolean z) {
        AppMethodBeat.m2504i(54488);
        FileSystem asV = asV(str);
        if (asV == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("No file system matches the path.");
            AppMethodBeat.m2505o(54488);
            throw fileNotFoundException;
        }
        OutputStream L = asV.mo11607L(str, z);
        AppMethodBeat.m2505o(54488);
        return L;
    }

    public final boolean exists(String str) {
        AppMethodBeat.m2504i(54489);
        FileSystem asV = asV(str);
        if (asV == null || !asV.exists(str)) {
            AppMethodBeat.m2505o(54489);
            return false;
        }
        AppMethodBeat.m2505o(54489);
        return true;
    }

    /* renamed from: to */
    public final C5712a mo11621to(String str) {
        AppMethodBeat.m2504i(54490);
        FileSystem asV = asV(str);
        if (asV == null) {
            AppMethodBeat.m2505o(54490);
            return null;
        }
        C5712a to = asV.mo11621to(str);
        AppMethodBeat.m2505o(54490);
        return to;
    }

    /* renamed from: t */
    public final boolean mo11618t(String str, long j) {
        AppMethodBeat.m2504i(54491);
        FileSystem asV = asV(str);
        if (asV == null || !asV.mo11618t(str, j)) {
            AppMethodBeat.m2505o(54491);
            return false;
        }
        AppMethodBeat.m2505o(54491);
        return true;
    }

    /* renamed from: pI */
    public final boolean mo11617pI(String str) {
        AppMethodBeat.m2504i(54492);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].mo11617pI(str) | i2;
        }
        AppMethodBeat.m2505o(54492);
        return i2;
    }

    /* renamed from: M */
    public final List<C5712a> mo11608M(String str, boolean z) {
        AppMethodBeat.m2504i(54493);
        ArrayList arrayList = new ArrayList();
        for (FileSystem M : this.zYB) {
            List M2 = M.mo11608M(str, z);
            if (M2 != null && M2.size() > 0) {
                arrayList.addAll(M2);
            }
        }
        AppMethodBeat.m2505o(54493);
        return arrayList;
    }

    /* renamed from: tf */
    public final boolean mo11619tf(String str) {
        AppMethodBeat.m2504i(54494);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].mo11619tf(str) | i2;
        }
        AppMethodBeat.m2505o(54494);
        return i2;
    }

    /* renamed from: N */
    public final boolean mo11609N(String str, boolean z) {
        AppMethodBeat.m2504i(54495);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].mo11609N(str, z) | i2;
        }
        AppMethodBeat.m2505o(54495);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d A:{SYNTHETIC, Splitter:B:20:0x003d} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042 A:{SYNTHETIC, Splitter:B:23:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A:{SYNTHETIC, Splitter:B:36:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0065 A:{SYNTHETIC, Splitter:B:39:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d A:{SYNTHETIC, Splitter:B:20:0x003d} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042 A:{SYNTHETIC, Splitter:B:23:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A:{SYNTHETIC, Splitter:B:36:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0065 A:{SYNTHETIC, Splitter:B:39:0x0065} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aS */
    public final boolean mo11612aS(String str, String str2) {
        Throwable th;
        AppMethodBeat.m2504i(54496);
        FileSystem asV = asV(str);
        FileSystem asV2 = asV(str2);
        boolean aS;
        if (asV == null || asV2 == null) {
            AppMethodBeat.m2505o(54496);
            return false;
        } else if (asV == asV2) {
            aS = asV.mo11612aS(str, str2);
            AppMethodBeat.m2505o(54496);
            return aS;
        } else {
            InputStream openRead;
            OutputStream L;
            try {
                openRead = asV.openRead(str);
                try {
                    L = asV2.mo11607L(str2, false);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = openRead.read(bArr);
                            if (read < 0) {
                                break;
                            }
                            L.write(bArr, 0, read);
                        }
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e) {
                            }
                        }
                        if (L != null) {
                            try {
                                L.close();
                            } catch (IOException e2) {
                            }
                        }
                        aS = asV.mo11617pI(str);
                        AppMethodBeat.m2505o(54496);
                        return aS;
                    } catch (IOException e3) {
                        if (openRead != null) {
                        }
                        if (L != null) {
                        }
                        AppMethodBeat.m2505o(54496);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        if (L != null) {
                        }
                        AppMethodBeat.m2505o(54496);
                        throw th;
                    }
                } catch (IOException e4) {
                    L = null;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (L != null) {
                        try {
                            L.close();
                        } catch (IOException e6) {
                        }
                    }
                    AppMethodBeat.m2505o(54496);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    L = null;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e7) {
                        }
                    }
                    if (L != null) {
                        try {
                            L.close();
                        } catch (IOException e8) {
                        }
                    }
                    AppMethodBeat.m2505o(54496);
                    throw th;
                }
            } catch (IOException e9) {
                L = null;
                openRead = null;
                if (openRead != null) {
                }
                if (L != null) {
                }
                AppMethodBeat.m2505o(54496);
                return false;
            } catch (Throwable th4) {
                th = th4;
                L = null;
                openRead = null;
                if (openRead != null) {
                }
                if (L != null) {
                }
                AppMethodBeat.m2505o(54496);
                throw th;
            }
        }
    }

    /* renamed from: O */
    public final String mo11610O(String str, boolean z) {
        AppMethodBeat.m2504i(54497);
        FileSystem asV = asV(str);
        if (asV == null) {
            AppMethodBeat.m2505o(54497);
            return null;
        }
        String O = asV.mo11610O(str, z);
        AppMethodBeat.m2505o(54497);
        return O;
    }

    /* renamed from: p */
    public final void mo11616p(Map<String, String> map) {
        AppMethodBeat.m2504i(54498);
        for (FileSystem p : this.zYB) {
            p.mo11616p(map);
        }
        AppMethodBeat.m2505o(54498);
    }

    /* renamed from: a */
    public final void mo11611a(CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(54499);
        for (FileSystem fileSystem : this.zYB) {
            if (cancellationSignal.isCanceled()) {
                break;
            }
            fileSystem.mo11611a(cancellationSignal);
        }
        AppMethodBeat.m2505o(54499);
    }

    public String toString() {
        AppMethodBeat.m2504i(54500);
        StringBuilder stringBuilder = new StringBuilder("CombinedFS [");
        for (Object obj : this.zYB) {
            stringBuilder.append(obj.toString()).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        String stringBuilder2 = stringBuilder.append(']').toString();
        AppMethodBeat.m2505o(54500);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(54501);
        parcel.writeInt(1);
        parcel.writeInt(this.zYB.length);
        for (Parcelable writeParcelable : this.zYB) {
            parcel.writeParcelable(writeParcelable, i);
        }
        parcel.writeInt(this.zYC.length);
        for (C36371a c36371a : this.zYC) {
            parcel.writeString(c36371a.hnu == null ? null : c36371a.hnu.pattern());
            parcel.writeInt(c36371a.zYE);
        }
        AppMethodBeat.m2505o(54501);
    }

    static {
        AppMethodBeat.m2504i(54502);
        AppMethodBeat.m2505o(54502);
    }
}
