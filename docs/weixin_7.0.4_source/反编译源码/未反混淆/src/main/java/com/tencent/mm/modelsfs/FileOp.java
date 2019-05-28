package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.EnumSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class FileOp {
    private static ReentrantReadWriteLock fNT = new ReentrantReadWriteLock();
    private static TreeMap<String, SFSContextRec> fNU = new TreeMap();
    private static String fNV = "";
    private static final EnumSet<com.tencent.mm.modelsfs.g.a> fNW = EnumSet.of(com.tencent.mm.modelsfs.g.a.PATHNAME, com.tencent.mm.modelsfs.g.a.PERIOD);

    class a {
        File dir;
        File[] fNX = null;
        int pos = 0;

        a(File file) {
            this.dir = file;
        }
    }

    static class SFSContextRec implements Parcelable {
        public static final Creator<SFSContextRec> CREATOR = new Creator<SFSContextRec>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SFSContextRec[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(93176);
                SFSContextRec sFSContextRec = new SFSContextRec(parcel);
                AppMethodBeat.o(93176);
                return sFSContextRec;
            }
        };
        String fNY;
        String[] fNZ;
        boolean fOa;
        boolean fOb;
        SFSContext fOc;
        Builder fOd;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(93177);
            parcel.writeString(this.fNY);
            parcel.writeStringArray(this.fNZ);
            parcel.writeByte((byte) (this.fOa ? 1 : 0));
            parcel.writeParcelable(this.fOd, i);
            AppMethodBeat.o(93177);
        }

        SFSContextRec(Parcel parcel) {
            boolean z;
            AppMethodBeat.i(93178);
            this.fNY = parcel.readString();
            this.fNZ = parcel.createStringArray();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.fOa = z;
            this.fOc = null;
            this.fOb = false;
            this.fOd = (Builder) parcel.readParcelable(Builder.class.getClassLoader());
            AppMethodBeat.o(93178);
        }

        static {
            AppMethodBeat.i(93179);
            AppMethodBeat.o(93179);
        }
    }

    static {
        AppMethodBeat.i(93199);
        AppMethodBeat.o(93199);
    }

    public static Map<String, Statistics> aiP() {
        AppMethodBeat.i(93180);
        fNT.readLock().lock();
        TreeMap treeMap = new TreeMap();
        for (SFSContextRec sFSContextRec : fNU.values()) {
            if (!(sFSContextRec == null || sFSContextRec.fOb)) {
                if (sFSContextRec.fOc == null) {
                    synchronized (sFSContextRec) {
                        try {
                            if (sFSContextRec.fOc == null) {
                                sFSContextRec.fOc = sFSContextRec.fOd.create();
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.fNY, e.getMessage());
                            sFSContextRec.fOb = true;
                        } catch (Throwable th) {
                            AppMethodBeat.o(93180);
                        }
                    }
                }
                SFSContext sFSContext = sFSContextRec.fOc;
                if (sFSContext.mNativePtr == 0) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
                    AppMethodBeat.o(93180);
                    throw illegalArgumentException;
                }
                treeMap.put(sFSContextRec.fOd.mName, SFSContext.nativeStatistics(sFSContext.mNativePtr));
            }
        }
        fNT.readLock().unlock();
        AppMethodBeat.o(93180);
        return treeMap;
    }

    private static boolean a(String str, SFSContextRec sFSContextRec) {
        AppMethodBeat.i(93181);
        if (sFSContextRec.fNZ == null) {
            AppMethodBeat.o(93181);
            return false;
        }
        String substring = str.substring(sFSContextRec.fNY.length());
        int lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf == -1) {
            AppMethodBeat.o(93181);
            return false;
        }
        String substring2 = substring.substring(lastIndexOf + 1);
        if (substring2.length() == 0) {
            AppMethodBeat.o(93181);
            return false;
        }
        for (String a : sFSContextRec.fNZ) {
            if (g.a(a, 0, substring2, 0, fNW)) {
                AppMethodBeat.o(93181);
                return true;
            }
        }
        AppMethodBeat.o(93181);
        return false;
    }

    private static boolean ta(String str) {
        boolean z;
        AppMethodBeat.i(93182);
        fNT.readLock().lock();
        Entry floorEntry = fNU.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.fOb || a(str, sFSContextRec))) {
                z = false;
                fNT.readLock().unlock();
                AppMethodBeat.o(93182);
                return z;
            }
        }
        z = true;
        fNT.readLock().unlock();
        AppMethodBeat.o(93182);
        return z;
    }

    private static SFSContextRec tb(String str) {
        AppMethodBeat.i(93183);
        fNT.readLock().lock();
        Entry floorEntry = fNU.floorEntry(str);
        if (floorEntry == null) {
            AppMethodBeat.o(93183);
            return null;
        }
        SFSContextRec sFSContextRec;
        if (str.startsWith((String) floorEntry.getKey())) {
            sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (a(str, sFSContextRec)) {
                sFSContextRec = null;
            }
        } else {
            sFSContextRec = null;
        }
        if (sFSContextRec == null || sFSContextRec.fOb) {
            AppMethodBeat.o(93183);
            return null;
        }
        if (sFSContextRec.fOc == null) {
            synchronized (sFSContextRec) {
                try {
                    if (sFSContextRec.fOc == null) {
                        sFSContextRec.fOc = sFSContextRec.fOd.create();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.fNY, e.getMessage());
                    sFSContextRec.fOb = true;
                    AppMethodBeat.o(93183);
                    return null;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(93183);
                    }
                }
            }
        }
        AppMethodBeat.o(93183);
        return sFSContextRec;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0020, B:22:0x0071] */
    /* JADX WARNING: Missing block: B:20:0x0064, code skipped:
            fNT.readLock().unlock();
            com.tencent.matrix.trace.core.AppMethodBeat.o(93184);
     */
    /* JADX WARNING: Missing block: B:24:0x0082, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x0085, code skipped:
            if (r1.fOa == false) goto L_0x0087;
     */
    /* JADX WARNING: Missing block: B:28:0x0087, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(93184);
     */
    /* JADX WARNING: Missing block: B:29:0x008d, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:30:0x008e, code skipped:
            r0 = new java.io.FileInputStream(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static InputStream openRead(String str) {
        AppMethodBeat.i(93184);
        if (str == null || str.length() == 0) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path == null");
            AppMethodBeat.o(93184);
            throw fileNotFoundException;
        }
        SFSContextRec tb = tb(str);
        InputStream bVar = tb == null ? f.th(str) ? new b(f.ti(str), f.tj(str)) : new FileInputStream(str) : tb.fOc.openRead(str.substring(tb.fNY.length()));
        fNT.readLock().unlock();
        String str2 = "MicroMsg.FileOp";
        String str3 = "openRead: %s [%s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = "ok";
        objArr[2] = tb == null ? "regular" : "SFS";
        ab.d(str2, str3, objArr);
        AppMethodBeat.o(93184);
        return bVar;
    }

    @Deprecated
    private static OutputStream aP(String str, String str2) {
        AppMethodBeat.i(93186);
        if (str == null || str.length() == 0) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path == null");
            AppMethodBeat.o(93186);
            throw fileNotFoundException;
        }
        OutputStream fileOutputStream;
        SFSContextRec tb = tb(str);
        if (tb == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    fileOutputStream = new FileOutputStream(str);
                } else {
                    fileOutputStream = new c(str, str2);
                }
            } catch (Throwable th) {
                fNT.readLock().unlock();
                AppMethodBeat.o(93186);
            }
        } else {
            fileOutputStream = tb.fOc.aR(str.substring(tb.fNY.length()), str2);
        }
        fNT.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "openWrite: %s [%s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = "ok";
        objArr[2] = tb == null ? "regular" : "SFS";
        ab.d(str3, str4, objArr);
        AppMethodBeat.o(93186);
        return fileOutputStream;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad A:{SYNTHETIC, Splitter:B:40:0x00ad} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2 A:{SYNTHETIC, Splitter:B:43:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A:{SYNTHETIC, Splitter:B:26:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083 A:{SYNTHETIC, Splitter:B:29:0x0083} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad A:{SYNTHETIC, Splitter:B:40:0x00ad} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2 A:{SYNTHETIC, Splitter:B:43:0x00b2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static boolean tc(String str) {
        InputStream openRead;
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        AppMethodBeat.i(93187);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(93187);
            return false;
        }
        SFSContextRec tb = tb(str);
        if (tb == null) {
            fNT.readLock().unlock();
            AppMethodBeat.o(93187);
            return true;
        }
        try {
            openRead = tb.fOc.openRead(str.substring(tb.fNY.length()));
            try {
                String parent = new File(str).getParent();
                if (!bo.isNullOrNil(parent)) {
                    new File(parent).mkdirs();
                }
                fileOutputStream = new FileOutputStream(str);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    ab.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    fNT.readLock().unlock();
                    AppMethodBeat.o(93187);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    fNT.readLock().unlock();
                    AppMethodBeat.o(93187);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (openRead != null) {
                }
                if (fileOutputStream != null) {
                }
                fNT.readLock().unlock();
                AppMethodBeat.o(93187);
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e7) {
                        }
                    }
                }
                openRead.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
                fNT.readLock().unlock();
                AppMethodBeat.o(93187);
                return true;
            } catch (IOException e9) {
                e = e9;
                ab.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                if (openRead != null) {
                }
                if (fileOutputStream != null) {
                }
                fNT.readLock().unlock();
                AppMethodBeat.o(93187);
                return false;
            }
        } catch (IOException e10) {
            e = e10;
            fileOutputStream = null;
            openRead = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            openRead = null;
            if (openRead != null) {
            }
            if (fileOutputStream != null) {
            }
            fNT.readLock().unlock();
            AppMethodBeat.o(93187);
            throw th;
        }
    }

    @Deprecated
    public static long td(String str) {
        long j = 0;
        AppMethodBeat.i(93188);
        if (str == null) {
            AppMethodBeat.o(93188);
        } else {
            SFSContextRec tb = tb(str);
            String ti;
            if (tb != null) {
                FileEntry tm = tb.fOc.tm(str.substring(tb.fNY.length()));
                if (tm != null) {
                    j = tm.size;
                } else if (tb.fOa) {
                    if (f.th(str)) {
                        ti = f.ti(str);
                    } else {
                        ti = str;
                    }
                    j = new File(ti).length();
                }
            } else {
                if (f.th(str)) {
                    ti = f.ti(str);
                } else {
                    ti = str;
                }
                j = new File(ti).length();
            }
            fNT.readLock().unlock();
            String str2 = "MicroMsg.FileOp";
            String str3 = "readFileLength: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            objArr[2] = tb == null ? "regular" : "SFS";
            ab.d(str2, str3, objArr);
            AppMethodBeat.o(93188);
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038 A:{SYNTHETIC, Splitter:B:16:0x0038} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085 A:{SYNTHETIC, Splitter:B:27:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090 A:{SYNTHETIC, Splitter:B:33:0x0090} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static byte[] te(String str) {
        IOException e;
        Throwable th;
        byte[] bArr = null;
        AppMethodBeat.i(93189);
        if (str == null) {
            AppMethodBeat.o(93189);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
            InputStream openRead;
            try {
                openRead = openRead(str);
                try {
                    byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    int i = BaseClientBuilder.API_PRIORITY_OTHER;
                    while (true) {
                        int read = openRead.read(bArr2, 0, Math.min(i, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
                        if (read != -1 && i > 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i -= read;
                        } else if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e2) {
                            }
                        }
                    }
                    if (openRead != null) {
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                    }
                    ab.d("MicroMsg.FileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
                    AppMethodBeat.o(93189);
                } catch (IOException e4) {
                    e = e4;
                    try {
                        ab.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                        }
                        AppMethodBeat.o(93189);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        AppMethodBeat.o(93189);
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                openRead = null;
                ab.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.o(93189);
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                openRead = null;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                AppMethodBeat.o(93189);
                throw th;
            }
        }
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A:{SYNTHETIC, Splitter:B:16:0x0046} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static String cy(String str) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(93190);
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(93190);
                return stringBuilder2;
            } catch (IOException e3) {
                e = e3;
                try {
                    ab.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    AppMethodBeat.o(93190);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(93190);
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            ab.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            AppMethodBeat.o(93190);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
            }
            AppMethodBeat.o(93190);
            throw th;
        }
    }

    @Deprecated
    public static int q(String str, byte[] bArr) {
        AppMethodBeat.i(93191);
        int b = b(str, bArr, bArr.length);
        AppMethodBeat.o(93191);
        return b;
    }

    @Deprecated
    private static int b(String str, byte[] bArr, int i) {
        AppMethodBeat.i(93192);
        if (bArr == null) {
            AppMethodBeat.o(93192);
            return -2;
        } else if (bArr.length < i + 0) {
            AppMethodBeat.o(93192);
            return -3;
        } else {
            OutputStream outputStream = null;
            try {
                outputStream = pH(str);
                outputStream.write(bArr, 0, i);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(93192);
                return 0;
            } catch (IOException e2) {
                ab.e("MicroMsg.FileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.o(93192);
                return -1;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(93192);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static boolean tf(String str) {
        AppMethodBeat.i(93193);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(93193);
            return false;
        }
        boolean z;
        String ti = f.ti(str);
        fNT.readLock().lock();
        Entry floorEntry = fNU.floorEntry(ti);
        if (floorEntry != null && ti.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.fOb || sFSContextRec.fNZ != null || sFSContextRec.fOa)) {
                z = false;
                fNT.readLock().unlock();
                if (z) {
                    AppMethodBeat.o(93193);
                    return true;
                }
                File file = new File(ti);
                if (file.exists() && file.isDirectory()) {
                    AppMethodBeat.o(93193);
                    return true;
                }
                boolean mkdirs = file.mkdirs();
                AppMethodBeat.o(93193);
                return mkdirs;
            }
        }
        z = true;
        fNT.readLock().unlock();
        if (z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A:{SYNTHETIC, Splitter:B:32:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007c A:{SYNTHETIC, Splitter:B:35:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A:{SYNTHETIC, Splitter:B:41:0x008a} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A:{SYNTHETIC, Splitter:B:44:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A:{SYNTHETIC, Splitter:B:41:0x008a} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A:{SYNTHETIC, Splitter:B:44:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A:{SYNTHETIC, Splitter:B:41:0x008a} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A:{SYNTHETIC, Splitter:B:44:0x008f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public static long y(String str, String str2) {
        IOException e;
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStream2 = null;
        AppMethodBeat.i(93194);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.o(93194);
            return -1;
        }
        long j = 0;
        InputStream openRead;
        try {
            openRead = openRead(str);
            try {
                outputStream2 = pH(str2);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openRead.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                        j += (long) read;
                    }
                    ab.d("MicroMsg.FileOp", "copyFile: %s -> %s", str, str2);
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    AppMethodBeat.o(93194);
                    return j;
                } catch (IOException e4) {
                    e = e4;
                    outputStream = outputStream2;
                    try {
                        ab.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                        if (openRead != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.o(93194);
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.o(93194);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    if (openRead != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(93194);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                outputStream = outputStream2;
                ab.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e6) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e7) {
                    }
                }
                AppMethodBeat.o(93194);
                return -1;
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e8) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e9) {
                    }
                }
                AppMethodBeat.o(93194);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            outputStream = outputStream2;
            openRead = outputStream2;
        } catch (Throwable th5) {
            th = th5;
            outputStream = outputStream2;
            openRead = outputStream2;
            if (openRead != null) {
            }
            if (outputStream != null) {
            }
            AppMethodBeat.o(93194);
            throw th;
        }
    }

    @Deprecated
    public static boolean ct(String str) {
        AppMethodBeat.i(93195);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(93195);
            return false;
        }
        boolean exists;
        SFSContextRec tb = tb(str);
        if (tb != null) {
            exists = tb.fOc.exists(str.substring(tb.fNY.length()));
            if (!exists && tb.fOa) {
                exists = new File(str).exists();
            }
        } else {
            exists = new File(str).exists();
        }
        fNT.readLock().unlock();
        String str2 = "MicroMsg.FileOp";
        String str3 = "fileExists: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(exists);
        objArr[2] = tb == null ? "regular" : "SFS";
        ab.d(str2, str3, objArr);
        AppMethodBeat.o(93195);
        return exists;
    }

    @Deprecated
    public static boolean deleteFile(String str) {
        AppMethodBeat.i(93196);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(93196);
            return false;
        }
        boolean pI;
        SFSContextRec tb = tb(str);
        String ti;
        if (tb != null) {
            pI = tb.fOc.pI(str.substring(tb.fNY.length()));
            if (!pI && tb.fOa) {
                if (f.th(str)) {
                    ti = f.ti(str);
                } else {
                    ti = str;
                }
                pI = new File(ti).delete();
            }
        } else {
            if (f.th(str)) {
                ti = f.ti(str);
            } else {
                ti = str;
            }
            pI = new File(ti).delete();
        }
        fNT.readLock().unlock();
        String str2 = "MicroMsg.FileOp";
        String str3 = "deleteFile: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(pI);
        objArr[2] = tb == null ? "regular" : "SFS";
        ab.d(str2, str3, objArr);
        AppMethodBeat.o(93196);
        return pI;
    }

    @Deprecated
    public static boolean aQ(String str, String str2) {
        AppMethodBeat.i(93197);
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            AppMethodBeat.o(93197);
            return false;
        }
        if (ta(str) && ta(str2)) {
            if (f.th(str)) {
                str = f.ti(str);
            }
            if (f.th(str2)) {
                str2 = f.ti(str2);
            }
            if (new File(str).renameTo(new File(str2))) {
                AppMethodBeat.o(93197);
                return true;
            }
        }
        if (y(str, str2) < 0) {
            AppMethodBeat.o(93197);
            return false;
        }
        deleteFile(str);
        AppMethodBeat.o(93197);
        return true;
    }

    @Deprecated
    public static boolean tg(String str) {
        AppMethodBeat.i(93198);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(93198);
            return false;
        }
        boolean z;
        SFSContextRec tb = tb(str);
        if (tb != null) {
            IOException iOException;
            try {
                if (str.equals(tb.fNY)) {
                    SFSContext sFSContext = tb.fOc;
                    if (sFSContext.mNativePtr == 0) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Reuse already released SFSContext.");
                        AppMethodBeat.o(93198);
                        throw illegalArgumentException;
                    } else if (SFSContext.nativeClear(sFSContext.mNativePtr) != 0) {
                        iOException = new IOException(SFSContext.nativeErrorMessage());
                        AppMethodBeat.o(93198);
                        throw iOException;
                    }
                }
                for (FileEntry fileEntry : tb.fOc.tl(str.substring(tb.fNY.length()))) {
                    tb.fOc.pI(fileEntry.name);
                }
                z = true;
            } catch (IOException iOException2) {
                ab.printErrStackTrace("MicroMsg.FileOp", iOException2, "deleteDirIncludedFiles failed: ".concat(String.valueOf(str)), new Object[0]);
                z = false;
            }
        } else {
            File file = new File(str);
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new a(file));
            do {
                a aVar = (a) arrayDeque.getLast();
                if (aVar.fNX == null) {
                    aVar.fNX = aVar.dir.listFiles();
                }
                if (aVar.fNX != null) {
                    File[] fileArr = aVar.fNX;
                    for (int i = aVar.pos; i < fileArr.length; i++) {
                        File file2 = fileArr[i];
                        if (file2.isFile()) {
                            file2.delete();
                        } else if (file2.isDirectory()) {
                            aVar.pos = i;
                            arrayDeque.add(new a(file2));
                            break;
                        }
                    }
                    arrayDeque.removeLast();
                }
            } while (!arrayDeque.isEmpty());
            z = true;
        }
        fNT.readLock().unlock();
        AppMethodBeat.o(93198);
        return z;
    }

    @Deprecated
    public static OutputStream pH(String str) {
        AppMethodBeat.i(93185);
        if (str == null || str.length() == 0) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("path == null");
            AppMethodBeat.o(93185);
            throw fileNotFoundException;
        }
        String str2 = "";
        if (f.th(str)) {
            str2 = f.tk(str);
            str = f.ti(str);
        }
        OutputStream aP = aP(str, str2);
        AppMethodBeat.o(93185);
        return aP;
    }
}
