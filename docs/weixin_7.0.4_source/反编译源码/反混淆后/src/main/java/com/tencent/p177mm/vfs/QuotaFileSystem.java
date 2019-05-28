package com.tencent.p177mm.vfs;

import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.vfs.QuotaFileSystem */
public class QuotaFileSystem extends FileSystemWrapper implements Callback {
    public static final Creator<QuotaFileSystem> CREATOR = new C57222();
    private final long inh;
    private HashMap<String, Long> zZA;
    private final Handler zZB;
    private final long zZC;
    private final long zZw;
    private final long zZx;
    private final boolean zZy;
    private final Object zZz;

    /* renamed from: com.tencent.mm.vfs.QuotaFileSystem$1 */
    class C57211 implements Comparator<C5712a> {
        private final long zZD = (System.currentTimeMillis() - QuotaFileSystem.this.inh);

        C57211() {
            AppMethodBeat.m2504i(54556);
            AppMethodBeat.m2505o(54556);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            int access$100;
            AppMethodBeat.m2504i(54557);
            C5712a c5712a = (C5712a) obj;
            C5712a c5712a2 = (C5712a) obj2;
            if (c5712a.zYM >= this.zZD || c5712a2.zYM >= this.zZD) {
                access$100 = QuotaFileSystem.access$100(c5712a2.zYM - c5712a.zYM);
                if (access$100 != 0) {
                    AppMethodBeat.m2505o(54557);
                    return access$100;
                }
            }
            access$100 = QuotaFileSystem.access$100(c5712a.zYL - c5712a2.zYL);
            AppMethodBeat.m2505o(54557);
            return access$100;
        }
    }

    /* renamed from: com.tencent.mm.vfs.QuotaFileSystem$2 */
    static class C57222 implements Creator<QuotaFileSystem> {
        C57222() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QuotaFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(54558);
            C5736j.m8647a(parcel, QuotaFileSystem.class);
            QuotaFileSystem quotaFileSystem = new QuotaFileSystem((FileSystem) parcel.readParcelable(getClass().getClassLoader()), parcel);
            AppMethodBeat.m2505o(54558);
            return quotaFileSystem;
        }
    }

    /* renamed from: com.tencent.mm.vfs.QuotaFileSystem$a */
    static final class C5723a {
        int jJF = 0;
        C5712a zZF;

        C5723a(C5712a c5712a) {
            this.zZF = c5712a;
        }

        public final String toString() {
            AppMethodBeat.m2504i(54559);
            String str = "children: " + this.jJF + " [" + this.zZF + "]";
            AppMethodBeat.m2505o(54559);
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
        AppMethodBeat.m2504i(54560);
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
        AppMethodBeat.m2505o(54560);
    }

    protected QuotaFileSystem(FileSystem fileSystem, Parcel parcel) {
        super(fileSystem);
        AppMethodBeat.m2504i(54561);
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
        AppMethodBeat.m2505o(54561);
    }

    private void dMz() {
        AppMethodBeat.m2504i(54562);
        if (this.zZx < this.zZw) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
            AppMethodBeat.m2505o(54562);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(54562);
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(54563);
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
                        AppMethodBeat.m2505o(54563);
                    }
                }
            }
            if (isEmpty) {
                this.zZB.sendMessageDelayed(Message.obtain(), 60000);
            }
        }
        AppMethodBeat.m2505o(54563);
        return openRead;
    }

    /* renamed from: L */
    public final OutputStream mo11607L(String str, boolean z) {
        AppMethodBeat.m2504i(54564);
        OutputStream L = this.zYO.mo11607L(str, z);
        if (this.zZy) {
            synchronized (this.zZz) {
                try {
                    this.zZA.remove(str);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(54564);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(54564);
        return L;
    }

    public boolean handleMessage(Message message) {
        HashMap hashMap;
        AppMethodBeat.m2504i(54566);
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
                    AppMethodBeat.m2505o(54566);
                }
            }
        }
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                this.zYO.mo11618t((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            C0926b.m2101d("VFS.QuotaFileSystem", "Flush access time cache entries: " + hashMap.size());
        }
        AppMethodBeat.m2505o(54566);
        return true;
    }

    public String toString() {
        AppMethodBeat.m2504i(54567);
        String str = "QuotaFS [" + ((this.zZw / 1024) / 1024) + "MB | " + this.zYO.toString() + "]";
        AppMethodBeat.m2505o(54567);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(54568);
        parcel.writeInt(1);
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.zZw);
        parcel.writeLong(this.zZx);
        parcel.writeLong(this.inh);
        if (!this.zZy) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        AppMethodBeat.m2505o(54568);
    }

    static {
        AppMethodBeat.m2504i(54569);
        AppMethodBeat.m2505o(54569);
    }

    /* renamed from: a */
    public final void mo11611a(CancellationSignal cancellationSignal) {
        Throwable th;
        int i;
        AppMethodBeat.m2504i(54565);
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        int i4;
        try {
            int aiR = this.zYO.aiR();
            if ((aiR & 1) == 0) {
                C0926b.m2107w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.zYO.toString());
            } else if ((aiR & 8) == 0) {
                C0926b.m2107w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.zYO.toString());
            } else {
                cancellationSignal.throwIfCanceled();
                mo15900j(1, "destination", this.zYO);
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
                            this.zYO.mo11618t((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                        }
                    }
                }
                cancellationSignal.throwIfCanceled();
                List<C5712a> M = this.zYO.mo11608M("", true);
                if (M == null) {
                    C0926b.m2103e("VFS.QuotaFileSystem", "Unable to list files in FS: " + toString());
                } else {
                    C5712a c5712a;
                    for (C5712a c5712a2 : M) {
                        j += c5712a2.zYL < 0 ? c5712a2.size : c5712a2.zYL;
                        if (c5712a2.zYN) {
                            i3++;
                        } else {
                            i2++;
                        }
                    }
                    C0926b.m2105i("VFS.QuotaFileSystem", "Total size: " + j + ", Cleaning threshold: " + this.zZx);
                    mo15900j(2, "fileCount", Integer.valueOf(i2), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j));
                    if (j <= this.zZx) {
                        C0926b.m2105i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
                        mo15900j(6, "fileCount", Integer.valueOf(i2), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j));
                    } else {
                        String ath;
                        HashMap hashMap2;
                        long j2;
                        C5723a c5723a;
                        cancellationSignal.throwIfCanceled();
                        if ((aiR & 32) != 0) {
                            HashMap hashMap3 = new HashMap();
                            for (C5712a c5712a22 : M) {
                                if (c5712a22.zYN && !hashMap3.containsKey(c5712a22.zYK)) {
                                    hashMap3.put(c5712a22.zYK, new C5723a(c5712a22));
                                }
                                ath = C5736j.ath(c5712a22.zYK);
                                if (ath != null) {
                                    C5723a c5723a2 = (C5723a) hashMap3.get(ath);
                                    if (c5723a2 == null) {
                                        c5723a2 = new C5723a(c5712a22);
                                        hashMap3.put(ath, c5723a2);
                                    }
                                    c5723a2.jJF++;
                                }
                            }
                            cancellationSignal.throwIfCanceled();
                            hashMap2 = hashMap3;
                        } else {
                            hashMap2 = null;
                        }
                        ArrayList arrayList = new ArrayList(M.size());
                        for (C5712a c5712a222 : M) {
                            if (!c5712a222.zYN) {
                                arrayList.add(c5712a222);
                            }
                        }
                        Collections.sort(arrayList, new C57211());
                        int size = arrayList.size() - 1;
                        i4 = i2;
                        while (j > this.zZw && size >= 0) {
                            try {
                                cancellationSignal.throwIfCanceled();
                                int i5 = size - 1;
                                c5712a222 = (C5712a) arrayList.get(size);
                                String str = c5712a222.zYK;
                                if (this.zYO.mo11617pI(str)) {
                                    j2 = j - (c5712a222.zYL < 0 ? c5712a222.size : c5712a222.zYL);
                                    i4--;
                                } else {
                                    j2 = j;
                                }
                                if (hashMap2 != null) {
                                    try {
                                        Object ath2 = C5736j.ath(str);
                                        size = i3;
                                        while (ath2 != null) {
                                            try {
                                                c5723a = (C5723a) hashMap2.get(ath2);
                                                if (c5723a == null) {
                                                    break;
                                                }
                                                i3 = c5723a.jJF - 1;
                                                c5723a.jJF = i3;
                                                if (i3 != 0 || !this.zYO.mo11609N(ath2, false)) {
                                                    break;
                                                }
                                                long j3;
                                                if (c5723a.zZF.zYL < 0) {
                                                    j3 = c5723a.zZF.size;
                                                } else {
                                                    j3 = c5723a.zZF.zYL;
                                                }
                                                j2 -= j3;
                                                i3 = size - 1;
                                                hashMap2.remove(ath2);
                                                ath = C5736j.ath(ath2);
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
                                            C0926b.m2105i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + i4 + ", dirs: " + i3 + ", totalSize: " + j);
                                            i = 4;
                                        } else {
                                            C0926b.m2098b("VFS.QuotaFileSystem", th, "Maintenance failed.");
                                            i = 5;
                                        }
                                        mo15900j(i, "fileCount", Integer.valueOf(i4), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j));
                                        AppMethodBeat.m2505o(54565);
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
                            for (C5723a c5723a3 : hashMap2.values()) {
                                if (c5723a3.jJF == 0) {
                                    cancellationSignal.throwIfCanceled();
                                    if (this.zYO.mo11609N(c5723a3.zZF.zYK, false)) {
                                        j2 -= c5723a3.zZF.zYL < 0 ? c5723a3.zZF.size : c5723a3.zZF.zYL;
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
                        C0926b.m2105i("VFS.QuotaFileSystem", "Maintenance done. files: " + i4 + ", dirs: " + i3 + ", totalSize: " + j2);
                        mo15900j(3, "fileCount", Integer.valueOf(i4), "dirCount", Integer.valueOf(i3), "totalSize", Long.valueOf(j2));
                    }
                }
            }
            this.zYO.mo11611a(cancellationSignal);
            AppMethodBeat.m2505o(54565);
        } catch (Exception e222) {
            th = e222;
            i4 = 0;
        } catch (Throwable th2) {
            while (true) {
                AppMethodBeat.m2505o(54565);
            }
        }
    }
}
