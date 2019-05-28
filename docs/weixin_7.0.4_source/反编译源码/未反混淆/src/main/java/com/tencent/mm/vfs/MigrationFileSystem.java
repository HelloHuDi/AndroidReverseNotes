package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.FileSystem.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MigrationFileSystem extends AbstractFileSystem {
    public static final Creator<MigrationFileSystem> CREATOR = new Creator<MigrationFileSystem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MigrationFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(54535);
            MigrationFileSystem migrationFileSystem = new MigrationFileSystem(parcel);
            AppMethodBeat.o(54535);
            return migrationFileSystem;
        }
    };
    private final FileSystem[] zYB;
    private final boolean zZv;

    public MigrationFileSystem(FileSystem fileSystem, FileSystem... fileSystemArr) {
        AppMethodBeat.i(54536);
        this.zZv = true;
        FileSystem[] fileSystemArr2 = new FileSystem[2];
        fileSystemArr2[0] = fileSystem;
        int i = 1;
        for (int i2 = 0; i2 <= 0; i2++) {
            FileSystem fileSystem2 = fileSystemArr[0];
            if (fileSystem2 != null) {
                i++;
                fileSystemArr2[1] = fileSystem2;
            }
        }
        this.zYB = i == 2 ? fileSystemArr2 : (FileSystem[]) Arrays.copyOf(fileSystemArr2, 1);
        AppMethodBeat.o(54536);
    }

    protected MigrationFileSystem(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(54537);
        j.a(parcel, getClass());
        int readInt = parcel.readInt();
        this.zYB = new FileSystem[readInt];
        for (int i = 0; i < readInt; i++) {
            this.zYB[i] = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        }
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.zZv = z;
        AppMethodBeat.o(54537);
    }

    public final int aiR() {
        AppMethodBeat.i(54538);
        int aiR = this.zYB[0].aiR();
        AppMethodBeat.o(54538);
        return aiR;
    }

    public final b tn(String str) {
        AppMethodBeat.i(54539);
        b tn = this.zYB[0].tn(str);
        AppMethodBeat.o(54539);
        return tn;
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(54540);
        FileSystem[] fileSystemArr = this.zYB;
        int length = fileSystemArr.length;
        int i = 0;
        while (i < length) {
            try {
                InputStream openRead = fileSystemArr[i].openRead(str);
                if (openRead != null) {
                    AppMethodBeat.o(54540);
                    return openRead;
                }
                i++;
            } catch (IOException e) {
            }
        }
        FileNotFoundException fileNotFoundException = new FileNotFoundException(str + " not found on all file systems.");
        AppMethodBeat.o(54540);
        throw fileNotFoundException;
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54541);
        OutputStream L = this.zYB[0].L(str, z);
        AppMethodBeat.o(54541);
        return L;
    }

    public final boolean exists(String str) {
        AppMethodBeat.i(54542);
        for (FileSystem exists : this.zYB) {
            if (exists.exists(str)) {
                AppMethodBeat.o(54542);
                return true;
            }
        }
        AppMethodBeat.o(54542);
        return false;
    }

    public final a to(String str) {
        AppMethodBeat.i(54543);
        for (FileSystem to : this.zYB) {
            a to2 = to.to(str);
            if (to2 != null) {
                AppMethodBeat.o(54543);
                return to2;
            }
        }
        AppMethodBeat.o(54543);
        return null;
    }

    public final boolean t(String str, long j) {
        AppMethodBeat.i(54544);
        boolean t = this.zYB[0].t(str, j);
        AppMethodBeat.o(54544);
        return t;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(54545);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].pI(str) | i2;
        }
        AppMethodBeat.o(54545);
        return i2;
    }

    public final List<a> M(String str, boolean z) {
        AppMethodBeat.i(54546);
        ArrayList arrayList = new ArrayList();
        for (FileSystem M : this.zYB) {
            List M2 = M.M(str, z);
            if (M2 != null && M2.size() > 0) {
                arrayList.addAll(M2);
            }
        }
        AppMethodBeat.o(54546);
        return arrayList;
    }

    public final boolean tf(String str) {
        AppMethodBeat.i(54547);
        boolean tf = this.zYB[0].tf(str);
        AppMethodBeat.o(54547);
        return tf;
    }

    public final boolean N(String str, boolean z) {
        AppMethodBeat.i(54548);
        FileSystem[] fileSystemArr = this.zYB;
        int i = 0;
        int i2 = 0;
        while (i < fileSystemArr.length) {
            i++;
            i2 = fileSystemArr[i].N(str, z) | i2;
        }
        AppMethodBeat.o(54548);
        return i2;
    }

    public final boolean aS(String str, String str2) {
        AppMethodBeat.i(54549);
        for (FileSystem aS : this.zYB) {
            if (aS.aS(str, str2)) {
                AppMethodBeat.o(54549);
                return true;
            }
        }
        AppMethodBeat.o(54549);
        return false;
    }

    public final String O(String str, boolean z) {
        AppMethodBeat.i(54550);
        String O;
        if (z) {
            O = this.zYB[0].O(str, true);
            AppMethodBeat.o(54550);
            return O;
        }
        for (FileSystem fileSystem : this.zYB) {
            if (fileSystem.exists(str)) {
                O = fileSystem.O(str, false);
                AppMethodBeat.o(54550);
                return O;
            }
        }
        O = this.zYB[0].O(str, false);
        AppMethodBeat.o(54550);
        return O;
    }

    public final void p(Map<String, String> map) {
        AppMethodBeat.i(54551);
        for (FileSystem p : this.zYB) {
            p.p(map);
        }
        AppMethodBeat.o(54551);
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(CancellationSignal cancellationSignal) {
        int i;
        int i2;
        Exception exception;
        AppMethodBeat.i(54552);
        if (this.zZv) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            i = 0;
            int i9 = 0;
            long j = 0;
            try {
                FileSystem fileSystem = this.zYB[0];
                HashSet hashSet = new HashSet();
                byte[] bArr = new byte[4096];
                cancellationSignal.throwIfCanceled();
                j(1, "destination", fileSystem);
                int length = this.zYB.length;
                int i10 = 1;
                while (i10 < length) {
                    int i11;
                    cancellationSignal.throwIfCanceled();
                    FileSystem fileSystem2 = this.zYB[i10];
                    List<a> M = fileSystem2.M("", true);
                    if (M == null || M.isEmpty()) {
                        i2 = i8;
                        i11 = i5;
                    } else {
                        TreeSet treeSet;
                        i11 = i5;
                        for (a aVar : M) {
                            if (aVar.zYN) {
                                i4++;
                            } else {
                                i3++;
                            }
                            i11 = (int) (((long) i11) + aVar.zYL);
                        }
                        if ((fileSystem2.aiR() & 33) == 33) {
                            treeSet = new TreeSet();
                        } else {
                            treeSet = null;
                        }
                        i5 = i8;
                        for (a aVar2 : M) {
                            try {
                                cancellationSignal.throwIfCanceled();
                                if (aVar2.zYN) {
                                    if (hashSet.add(aVar2.zYK)) {
                                        fileSystem.tf(aVar2.zYK);
                                        i8 = i6 + 1;
                                    } else {
                                        i8 = i6;
                                    }
                                    if (treeSet != null) {
                                        try {
                                            treeSet.add(aVar2.zYK);
                                            i6 = i8;
                                        } catch (Exception e) {
                                            exception = e;
                                            i6 = i8;
                                            if (exception instanceof OperationCanceledException) {
                                            }
                                            j(exception instanceof OperationCanceledException ? 4 : 5, "destination", this.zYB[0], "dirsCreated", Integer.valueOf(i6), "dirsDeleted", Integer.valueOf(i7), "destOverride", Integer.valueOf(i5), "filesCopied", Integer.valueOf(i), "filesFailed", Integer.valueOf(i9), "sizeCopied", Long.valueOf(j));
                                            AppMethodBeat.o(54552);
                                            throw exception;
                                        }
                                    }
                                }
                                String ath = j.ath(aVar2.zYK);
                                if (ath != null) {
                                    if (hashSet.add(ath)) {
                                        fileSystem.tf(ath);
                                        i6++;
                                    }
                                    if (treeSet != null) {
                                        treeSet.add(ath);
                                    }
                                }
                                i8 = i6;
                                if (fileSystem.exists(aVar2.zYK)) {
                                    fileSystem2.pI(aVar2.zYK);
                                    i5++;
                                    i6 = i8;
                                } else {
                                    InputStream inputStream = null;
                                    OutputStream outputStream = null;
                                    try {
                                        inputStream = fileSystem2.openRead(aVar2.zYK);
                                        outputStream = fileSystem.L(aVar2.zYK, false);
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            outputStream.write(bArr, 0, read);
                                        }
                                        inputStream.close();
                                        outputStream.close();
                                        outputStream = null;
                                        fileSystem2.pI(aVar2.zYK);
                                        i++;
                                        j += aVar2.zYL;
                                        i6 = i8;
                                    } catch (IOException e2) {
                                        i9++;
                                        com.tencent.e.a.b.e("VFS.MigrationFileSystem", "Failed to migrate file: " + aVar2.zYK + " [" + toString() + "]");
                                        if (treeSet != null) {
                                            for (Object obj = ath; obj != null; obj = j.ath(obj)) {
                                                treeSet.remove(obj);
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                                i6 = i8;
                                            } catch (IOException e4) {
                                                i6 = i8;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e5) {
                                            }
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e6) {
                                            }
                                        }
                                        AppMethodBeat.o(54552);
                                    }
                                }
                                i9 = i9;
                                i6 = i8;
                            } catch (Exception e7) {
                                exception = e7;
                                if (exception instanceof OperationCanceledException) {
                                }
                                j(exception instanceof OperationCanceledException ? 4 : 5, "destination", this.zYB[0], "dirsCreated", Integer.valueOf(i6), "dirsDeleted", Integer.valueOf(i7), "destOverride", Integer.valueOf(i5), "filesCopied", Integer.valueOf(i), "filesFailed", Integer.valueOf(i9), "sizeCopied", Long.valueOf(j));
                                AppMethodBeat.o(54552);
                                throw exception;
                            }
                        }
                        if (treeSet != null) {
                            i8 = i7;
                            for (String str : treeSet.descendingSet()) {
                                try {
                                    cancellationSignal.throwIfCanceled();
                                    fileSystem2.N(str, false);
                                    i8++;
                                } catch (Exception e72) {
                                    exception = e72;
                                    i7 = i8;
                                    j(exception instanceof OperationCanceledException ? 4 : 5, "destination", this.zYB[0], "dirsCreated", Integer.valueOf(i6), "dirsDeleted", Integer.valueOf(i7), "destOverride", Integer.valueOf(i5), "filesCopied", Integer.valueOf(i), "filesFailed", Integer.valueOf(i9), "sizeCopied", Long.valueOf(j));
                                    AppMethodBeat.o(54552);
                                    throw exception;
                                }
                            }
                            i2 = i5;
                            i7 = i8;
                        } else {
                            i2 = i5;
                        }
                    }
                    i10++;
                    i8 = i2;
                    i5 = i11;
                }
                j(3, "destination", fileSystem, "filesBefore", Integer.valueOf(i3), "dirsBefore", Integer.valueOf(i4), "sizeBefore", Integer.valueOf(i5), "dirsCreated", Integer.valueOf(i6), "dirsDeleted", Integer.valueOf(i7), "destOverride", Integer.valueOf(i8), "filesCopied", Integer.valueOf(i), "filesFailed", Integer.valueOf(i9), "sizeCopied", Long.valueOf(j));
            } catch (Exception e722) {
                exception = e722;
                i5 = i8;
                if (exception instanceof OperationCanceledException) {
                }
                j(exception instanceof OperationCanceledException ? 4 : 5, "destination", this.zYB[0], "dirsCreated", Integer.valueOf(i6), "dirsDeleted", Integer.valueOf(i7), "destOverride", Integer.valueOf(i5), "filesCopied", Integer.valueOf(i), "filesFailed", Integer.valueOf(i9), "sizeCopied", Long.valueOf(j));
                AppMethodBeat.o(54552);
                throw exception;
            }
        }
        for (FileSystem fileSystem3 : this.zYB) {
            cancellationSignal.throwIfCanceled();
            fileSystem3.a(cancellationSignal);
        }
        AppMethodBeat.o(54552);
    }

    public String toString() {
        AppMethodBeat.i(54553);
        StringBuilder append = new StringBuilder("MigrationFS [").append(this.zYB[0].toString()).append(" <= ");
        for (int i = 1; i < this.zYB.length; i++) {
            append.append(this.zYB[i].toString()).append(", ");
        }
        append.setLength(append.length() - 2);
        String stringBuilder = append.append(']').toString();
        AppMethodBeat.o(54553);
        return stringBuilder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.i(54554);
        parcel.writeInt(1);
        parcel.writeInt(this.zYB.length);
        for (Parcelable writeParcelable : this.zYB) {
            parcel.writeParcelable(writeParcelable, i);
        }
        if (!this.zZv) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
        AppMethodBeat.o(54554);
    }

    static {
        AppMethodBeat.i(54555);
        AppMethodBeat.o(54555);
    }
}
