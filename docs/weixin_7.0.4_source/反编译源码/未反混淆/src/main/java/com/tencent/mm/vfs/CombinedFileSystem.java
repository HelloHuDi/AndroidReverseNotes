package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CombinedFileSystem extends AbstractFileSystem {
    public static final Creator<CombinedFileSystem> CREATOR = new Creator<CombinedFileSystem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CombinedFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(54483);
            CombinedFileSystem combinedFileSystem = new CombinedFileSystem(parcel, (byte) 0);
            AppMethodBeat.o(54483);
            return combinedFileSystem;
        }
    };
    private final FileSystem[] zYB;
    private final a[] zYC;
    private final int zYD;

    static final class a {
        final Pattern hnu;
        final int zYE;
        final FileSystem zYF;

        a(Pattern pattern, int i, FileSystem fileSystem) {
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
        AppMethodBeat.i(54484);
        j.a(parcel, getClass());
        int readInt = parcel.readInt();
        this.zYB = new FileSystem[readInt];
        int i3 = 0;
        for (i = 0; i < readInt; i++) {
            FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
            if (fileSystem == null) {
                ParcelFormatException parcelFormatException = new ParcelFormatException();
                AppMethodBeat.o(54484);
                throw parcelFormatException;
            }
            this.zYB[i] = fileSystem;
            i3 |= fileSystem.aiR();
        }
        this.zYD = i3;
        i = parcel.readInt();
        this.zYC = new a[i];
        while (i2 < i) {
            String readString = parcel.readString();
            Pattern compile = readString == null ? null : Pattern.compile(readString);
            i3 = parcel.readInt();
            this.zYC[i2] = new a(compile, i3, this.zYB[i3]);
            i2++;
        }
        AppMethodBeat.o(54484);
    }

    public final int aiR() {
        return this.zYD;
    }

    public final b tn(String str) {
        AppMethodBeat.i(54485);
        b tn = this.zYB[this.zYB.length - 1].tn(str);
        AppMethodBeat.o(54485);
        return tn;
    }

    private FileSystem asV(String str) {
        AppMethodBeat.i(54486);
        for (a aVar : this.zYC) {
            if (aVar.hnu == null || aVar.hnu.matcher(str).matches()) {
                FileSystem fileSystem = aVar.zYF;
                AppMethodBeat.o(54486);
                return fileSystem;
            }
        }
        AppMethodBeat.o(54486);
        return null;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(54487);
        FileSystem asV = asV(str);
        if (asV == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("No file system matches the path.");
            AppMethodBeat.o(54487);
            throw fileNotFoundException;
        }
        InputStream openRead = asV.openRead(str);
        AppMethodBeat.o(54487);
        return openRead;
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54488);
        FileSystem asV = asV(str);
        if (asV == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("No file system matches the path.");
            AppMethodBeat.o(54488);
            throw fileNotFoundException;
        }
        OutputStream L = asV.L(str, z);
        AppMethodBeat.o(54488);
        return L;
    }

    public final boolean exists(String str) {
        AppMethodBeat.i(54489);
        FileSystem asV = asV(str);
        if (asV == null || !asV.exists(str)) {
            AppMethodBeat.o(54489);
            return false;
        }
        AppMethodBeat.o(54489);
        return true;
    }

    public final com.tencent.mm.vfs.FileSystem.a to(String str) {
        AppMethodBeat.i(54490);
        FileSystem asV = asV(str);
        if (asV == null) {
            AppMethodBeat.o(54490);
            return null;
        }
        com.tencent.mm.vfs.FileSystem.a to = asV.to(str);
        AppMethodBeat.o(54490);
        return to;
    }

    public final boolean t(String str, long j) {
        AppMethodBeat.i(54491);
        FileSystem asV = asV(str);
        if (asV == null || !asV.t(str, j)) {
            AppMethodBeat.o(54491);
            return false;
        }
        AppMethodBeat.o(54491);
        return true;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(54492);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].pI(str) | i2;
        }
        AppMethodBeat.o(54492);
        return i2;
    }

    public final List<com.tencent.mm.vfs.FileSystem.a> M(String str, boolean z) {
        AppMethodBeat.i(54493);
        ArrayList arrayList = new ArrayList();
        for (FileSystem M : this.zYB) {
            List M2 = M.M(str, z);
            if (M2 != null && M2.size() > 0) {
                arrayList.addAll(M2);
            }
        }
        AppMethodBeat.o(54493);
        return arrayList;
    }

    public final boolean tf(String str) {
        AppMethodBeat.i(54494);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].tf(str) | i2;
        }
        AppMethodBeat.o(54494);
        return i2;
    }

    public final boolean N(String str, boolean z) {
        AppMethodBeat.i(54495);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].N(str, z) | i2;
        }
        AppMethodBeat.o(54495);
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
    public final boolean aS(String str, String str2) {
        Throwable th;
        AppMethodBeat.i(54496);
        FileSystem asV = asV(str);
        FileSystem asV2 = asV(str2);
        boolean aS;
        if (asV == null || asV2 == null) {
            AppMethodBeat.o(54496);
            return false;
        } else if (asV == asV2) {
            aS = asV.aS(str, str2);
            AppMethodBeat.o(54496);
            return aS;
        } else {
            InputStream openRead;
            OutputStream L;
            try {
                openRead = asV.openRead(str);
                try {
                    L = asV2.L(str2, false);
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
                        aS = asV.pI(str);
                        AppMethodBeat.o(54496);
                        return aS;
                    } catch (IOException e3) {
                        if (openRead != null) {
                        }
                        if (L != null) {
                        }
                        AppMethodBeat.o(54496);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        if (L != null) {
                        }
                        AppMethodBeat.o(54496);
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
                    AppMethodBeat.o(54496);
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
                    AppMethodBeat.o(54496);
                    throw th;
                }
            } catch (IOException e9) {
                L = null;
                openRead = null;
                if (openRead != null) {
                }
                if (L != null) {
                }
                AppMethodBeat.o(54496);
                return false;
            } catch (Throwable th4) {
                th = th4;
                L = null;
                openRead = null;
                if (openRead != null) {
                }
                if (L != null) {
                }
                AppMethodBeat.o(54496);
                throw th;
            }
        }
    }

    public final String O(String str, boolean z) {
        AppMethodBeat.i(54497);
        FileSystem asV = asV(str);
        if (asV == null) {
            AppMethodBeat.o(54497);
            return null;
        }
        String O = asV.O(str, z);
        AppMethodBeat.o(54497);
        return O;
    }

    public final void p(Map<String, String> map) {
        AppMethodBeat.i(54498);
        for (FileSystem p : this.zYB) {
            p.p(map);
        }
        AppMethodBeat.o(54498);
    }

    public final void a(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(54499);
        for (FileSystem fileSystem : this.zYB) {
            if (cancellationSignal.isCanceled()) {
                break;
            }
            fileSystem.a(cancellationSignal);
        }
        AppMethodBeat.o(54499);
    }

    public String toString() {
        AppMethodBeat.i(54500);
        StringBuilder stringBuilder = new StringBuilder("CombinedFS [");
        for (Object obj : this.zYB) {
            stringBuilder.append(obj.toString()).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        String stringBuilder2 = stringBuilder.append(']').toString();
        AppMethodBeat.o(54500);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(54501);
        parcel.writeInt(1);
        parcel.writeInt(this.zYB.length);
        for (Parcelable writeParcelable : this.zYB) {
            parcel.writeParcelable(writeParcelable, i);
        }
        parcel.writeInt(this.zYC.length);
        for (a aVar : this.zYC) {
            parcel.writeString(aVar.hnu == null ? null : aVar.hnu.pattern());
            parcel.writeInt(aVar.zYE);
        }
        AppMethodBeat.o(54501);
    }

    static {
        AppMethodBeat.i(54502);
        AppMethodBeat.o(54502);
    }
}
