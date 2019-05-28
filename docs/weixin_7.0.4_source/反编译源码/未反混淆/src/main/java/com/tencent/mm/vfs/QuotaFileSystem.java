package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class QuotaFileSystem extends FileSystemWrapper implements Callback {
    public static final Creator<QuotaFileSystem> CREATOR = new Creator<QuotaFileSystem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QuotaFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(54558);
            j.a(parcel, QuotaFileSystem.class);
            QuotaFileSystem quotaFileSystem = new QuotaFileSystem((FileSystem) parcel.readParcelable(getClass().getClassLoader()), parcel);
            AppMethodBeat.o(54558);
            return quotaFileSystem;
        }
    };
    private final long inh;
    private HashMap<String, Long> zZA;
    private final Handler zZB;
    private final long zZC;
    private final long zZw;
    private final long zZx;
    private final boolean zZy;
    private final Object zZz;

    static final class a {
        int jJF = 0;
        com.tencent.mm.vfs.FileSystem.a zZF;

        a(com.tencent.mm.vfs.FileSystem.a aVar) {
            this.zZF = aVar;
        }

        public final String toString() {
            AppMethodBeat.i(54559);
            String str = "children: " + this.jJF + " [" + this.zZF + "]";
            AppMethodBeat.o(54559);
            return str;
        }
    }

    static /* synthetic */ int access$100(long j) {
        if (j == 0) {
            return 0;
        }
        return j > 0 ? 1 : -1;
    }

    public QuotaFileSystem(FileSystem fileSystem) {
        super(fileSystem);
        AppMethodBeat.i(54560);
        this.zZz = new Object();
        this.zZC = 60000;
        this.zZw = 402653184;
        this.zZx = 536870912;
        this.inh = 7776000000L;
        this.zZy = true;
        if (this.zZy) {
            this.zZA = new HashMap();
            this.zZB = new Handler(FileSystemManager.dMy().Caj.getLooper(), this);
        } else {
            this.zZA = null;
            this.zZB = null;
        }
        dMz();
        AppMethodBeat.o(54560);
    }

    protected QuotaFileSystem(FileSystem fileSystem, Parcel parcel) {
        super(fileSystem);
        AppMethodBeat.i(54561);
        this.zZz = new Object();
        this.zZC = 60000;
        this.zZw = parcel.readLong();
        this.zZx = parcel.readLong();
        this.inh = parcel.readLong();
        this.zZy = parcel.readByte() != (byte) 0;
        if (this.zZy) {
            this.zZA = new HashMap();
            this.zZB = new Handler(FileSystemManager.dMy().Caj.getLooper(), this);
        } else {
            this.zZA = null;
            this.zZB = null;
        }
        dMz();
        AppMethodBeat.o(54561);
    }

    private void dMz() {
        AppMethodBeat.i(54562);
        if (this.zZx < this.zZw) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
            AppMethodBeat.o(54562);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(54562);
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(54563);
        InputStream openRead = this.zYO.openRead(str);
        if (this.zZy) {
            boolean isEmpty;
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            synchronized (this.zZz) {
                try {
                    isEmpty = this.zZA.isEmpty();
                    this.zZA.put(str, valueOf);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(54563);
                    }
                }
            }
            if (isEmpty) {
                this.zZB.sendMessageDelayed(Message.obtain(), 60000);
            }
        }
        AppMethodBeat.o(54563);
        return openRead;
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54564);
        OutputStream L = this.zYO.L(str, z);
        if (this.zZy) {
            synchronized (this.zZz) {
                try {
                    this.zZA.remove(str);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(54564);
                    }
                }
            }
        }
        AppMethodBeat.o(54564);
        return L;
    }

    public boolean handleMessage(Message message) {
        HashMap hashMap;
        AppMethodBeat.i(54566);
        synchronized (this.zZz) {
            try {
                if (this.zZA.isEmpty()) {
                    hashMap = null;
                } else {
                    HashMap hashMap2 = this.zZA;
                    this.zZA = new HashMap();
                    hashMap = hashMap2;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(54566);
                }
            }
        }
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                this.zYO.t((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            b.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + hashMap.size());
        }
        AppMethodBeat.o(54566);
        return true;
    }

    public String toString() {
        AppMethodBeat.i(54567);
        String str = "QuotaFS [" + ((this.zZw / 1024) / 1024) + "MB | " + this.zYO.toString() + "]";
        AppMethodBeat.o(54567);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.i(54568);
        parcel.writeInt(1);
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.zZw);
        parcel.writeLong(this.zZx);
        parcel.writeLong(this.inh);
        if (!this.zZy) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        AppMethodBeat.o(54568);
    }

    static {
        AppMethodBeat.i(54569);
        AppMethodBeat.o(54569);
    }

    public final void a(CancellationSignal cancellationSignal) {
        Throwable th;
        int i;
        AppMethodBeat.i(54565);
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        int i4;
        try {
            int aiR = this.zYO.aiR();
            if ((aiR & 1) == 0) {
                b.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.zYO.toString());
            } else if ((aiR & 8) == 0) {
                b.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.zYO.toString());
            } else {
                cancellationSignal.throwIfCanceled();
                j(1, "destination", this.zYO);
                if (this.zZy) {
                    HashMap hashMap = null;
                    synchronized (this.zZz) {
                        if (!this.zZA.isEmpty()) {
                            hashMap = this.zZA;
                            this.zZA = new HashMap();
                        }
                    }
                    if (hashMap != null) {
                        for (Entry entry : hashMap.entrySet()) {
                            cancellationSignal.throwIfCanceled();
                            this.zYO.t((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                        }
                    }
                }
                cancellationSignal.throwIfCanceled();
                List<com.tencent.mm.vfs.FileSystem.a> M = this.zYO.M("", true);
                if (M == null) {
                    b.e("VFS.QuotaFileSystem", "Unable to list files in FS: " + toString());
                } else {
                    com.tencent.mm.vfs.FileSystem.a aVar;
                    for (com.tencent.mm.vfs.FileSystem.a aVar2 : M) {
                        j += aVar2.zYL < 0 ? aVar2.size : aVar2.zYL;
                        if (aVar2.zYN) {
                            i3++;
                        } else {
                            i2++;
                        }
                    }
                    b.i("VFS.QuotaFileSystem", "Total size: " + j + ", Cleaning threshold: " + this.zZx);
                    j(2, "fileCount", Integer.valueOf(i2), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j));
                    if (j <= this.zZx) {
                        b.i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
                        j(6, "fileCount", Integer.valueOf(i2), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j));
                    } else {
                        String ath;
                        HashMap hashMap2;
                        long j2;
                        a aVar3;
                        cancellationSignal.throwIfCanceled();
                        if ((aiR & 32) != 0) {
                            HashMap hashMap3 = new HashMap();
                            for (com.tencent.mm.vfs.FileSystem.a aVar22 : M) {
                                if (aVar22.zYN && !hashMap3.containsKey(aVar22.zYK)) {
                                    hashMap3.put(aVar22.zYK, new a(aVar22));
                                }
                                ath = j.ath(aVar22.zYK);
                                if (ath != null) {
                                    a aVar4 = (a) hashMap3.get(ath);
                                    if (aVar4 == null) {
                                        aVar4 = new a(aVar22);
                                        hashMap3.put(ath, aVar4);
                                    }
                                    aVar4.jJF++;
                                }
                            }
                            cancellationSignal.throwIfCanceled();
                            hashMap2 = hashMap3;
                        } else {
                            hashMap2 = null;
                        }
                        ArrayList arrayList = new ArrayList(M.size());
                        for (com.tencent.mm.vfs.FileSystem.a aVar222 : M) {
                            if (!aVar222.zYN) {
                                arrayList.add(aVar222);
                            }
                        }
                        Collections.sort(arrayList, new Comparator<com.tencent.mm.vfs.FileSystem.a>() {
                            private final long zZD = (System.currentTimeMillis() - QuotaFileSystem.this.inh);

                            {
                                AppMethodBeat.i(54556);
                                AppMethodBeat.o(54556);
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                int access$100;
                                AppMethodBeat.i(54557);
                                com.tencent.mm.vfs.FileSystem.a aVar = (com.tencent.mm.vfs.FileSystem.a) obj;
                                com.tencent.mm.vfs.FileSystem.a aVar2 = (com.tencent.mm.vfs.FileSystem.a) obj2;
                                if (aVar.zYM >= this.zZD || aVar2.zYM >= this.zZD) {
                                    access$100 = QuotaFileSystem.access$100(aVar2.zYM - aVar.zYM);
                                    if (access$100 != 0) {
                                        AppMethodBeat.o(54557);
                                        return access$100;
                                    }
                                }
                                access$100 = QuotaFileSystem.access$100(aVar.zYL - aVar2.zYL);
                                AppMethodBeat.o(54557);
                                return access$100;
                            }
                        });
                        int size = arrayList.size() - 1;
                        i4 = i2;
                        while (j > this.zZw && size >= 0) {
                            try {
                                cancellationSignal.throwIfCanceled();
                                int i5 = size - 1;
                                aVar222 = (com.tencent.mm.vfs.FileSystem.a) arrayList.get(size);
                                String str = aVar222.zYK;
                                if (this.zYO.pI(str)) {
                                    j2 = j - (aVar222.zYL < 0 ? aVar222.size : aVar222.zYL);
                                    i4--;
                                } else {
                                    j2 = j;
                                }
                                if (hashMap2 != null) {
                                    try {
                                        Object ath2 = j.ath(str);
                                        size = i3;
                                        while (ath2 != null) {
                                            try {
                                                aVar3 = (a) hashMap2.get(ath2);
                                                if (aVar3 == null) {
                                                    break;
                                                }
                                                i3 = aVar3.jJF - 1;
                                                aVar3.jJF = i3;
                                                if (i3 != 0 || !this.zYO.N(ath2, false)) {
                                                    break;
                                                }
                                                long j3;
                                                if (aVar3.zZF.zYL < 0) {
                                                    j3 = aVar3.zZF.size;
                                                } else {
                                                    j3 = aVar3.zZF.zYL;
                                                }
                                                j2 -= j3;
                                                i3 = size - 1;
                                                hashMap2.remove(ath2);
                                                ath = j.ath(ath2);
                                                size = i3;
                                            } catch (Exception e) {
                                                th = e;
                                                i3 = size;
                                                j = j2;
                                            }
                                        }
                                        i = size;
                                    } catch (Exception e2) {
                                        th = e2;
                                        j = j2;
                                        if (th instanceof OperationCanceledException) {
                                            b.i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + i4 + ", dirs: " + i3 + ", totalSize: " + j);
                                            i = 4;
                                        } else {
                                            b.b("VFS.QuotaFileSystem", th, "Maintenance failed.");
                                            i = 5;
                                        }
                                        j(i, "fileCount", Integer.valueOf(i4), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j));
                                        AppMethodBeat.o(54565);
                                        throw th;
                                    }
                                }
                                i = i3;
                                size = i5;
                                i3 = i;
                                j = j2;
                            } catch (Exception e22) {
                                th = e22;
                            }
                        }
                        if (hashMap2 != null) {
                            j2 = j;
                            for (a aVar32 : hashMap2.values()) {
                                if (aVar32.jJF == 0) {
                                    cancellationSignal.throwIfCanceled();
                                    if (this.zYO.N(aVar32.zZF.zYK, false)) {
                                        j2 -= aVar32.zZF.zYL < 0 ? aVar32.zZF.size : aVar32.zZF.zYL;
                                        i = i3 - 1;
                                        i3 = i;
                                    }
                                }
                                i = i3;
                                i3 = i;
                            }
                        } else {
                            j2 = j;
                        }
                        b.i("VFS.QuotaFileSystem", "Maintenance done. files: " + i4 + ", dirs: " + i3 + ", totalSize: " + j2);
                        j(3, "fileCount", Integer.valueOf(i4), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j2));
                    }
                }
            }
            this.zYO.a(cancellationSignal);
            AppMethodBeat.o(54565);
        } catch (Exception e222) {
            th = e222;
            i4 = 0;
        } catch (Throwable th2) {
            while (true) {
                AppMethodBeat.o(54565);
            }
        }
    }
}
