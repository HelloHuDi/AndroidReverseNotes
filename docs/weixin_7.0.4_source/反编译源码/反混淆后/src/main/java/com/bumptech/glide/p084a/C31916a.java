package com.bumptech.glide.p084a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bumptech.glide.a.a */
public final class C31916a implements Closeable {
    private final int axA;
    private Writer axB;
    private final LinkedHashMap<String, C31920c> axC = new LinkedHashMap(0, 0.75f, true);
    private int axD;
    private long axE = 0;
    final ThreadPoolExecutor axF = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C31919a());
    private final Callable<Void> axG = new C253991();
    private final File axv;
    private final File axw;
    private final File axx;
    private final int axy;
    private long axz;
    private final File directory;
    private long size = 0;

    /* renamed from: com.bumptech.glide.a.a$1 */
    class C253991 implements Callable<Void> {
        C253991() {
        }

        private Void call() {
            AppMethodBeat.m2504i(51805);
            synchronized (C31916a.this) {
                try {
                    if (C31916a.this.axB == null) {
                    } else {
                        C31916a.m51809b(C31916a.this);
                        if (C31916a.m51810c(C31916a.this)) {
                            C31916a.m51811d(C31916a.this);
                            C31916a.this.axD = 0;
                        }
                        AppMethodBeat.m2505o(51805);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(51805);
                }
            }
            return null;
        }
    }

    /* renamed from: com.bumptech.glide.a.a$b */
    public final class C31917b {
        final C31920c axI;
        final boolean[] axJ;
        public boolean axK;

        /* synthetic */ C31917b(C31916a c31916a, C31920c c31920c, byte b) {
            this(c31920c);
        }

        private C31917b(C31920c c31920c) {
            AppMethodBeat.m2504i(51796);
            this.axI = c31920c;
            this.axJ = c31920c.axO ? null : new boolean[C31916a.this.axA];
            AppMethodBeat.m2505o(51796);
        }

        /* renamed from: lP */
        public final File mo52032lP() {
            File file;
            AppMethodBeat.m2504i(51797);
            synchronized (C31916a.this) {
                try {
                    if (this.axI.axP != this) {
                        Object illegalStateException = new IllegalStateException();
                        throw illegalStateException;
                    }
                    if (!this.axI.axO) {
                        this.axJ[0] = true;
                    }
                    file = this.axI.axN[0];
                    if (!C31916a.this.directory.exists()) {
                        C31916a.this.directory.mkdirs();
                    }
                } finally {
                    AppMethodBeat.m2505o(51797);
                }
            }
            AppMethodBeat.m2505o(51797);
            return file;
        }

        public final void abort() {
            AppMethodBeat.m2504i(51798);
            C31916a.m51807a(C31916a.this, this, false);
            AppMethodBeat.m2505o(51798);
        }

        /* renamed from: lQ */
        public final void mo52033lQ() {
            AppMethodBeat.m2504i(51799);
            if (!this.axK) {
                try {
                    abort();
                    AppMethodBeat.m2505o(51799);
                    return;
                } catch (IOException e) {
                }
            }
            AppMethodBeat.m2505o(51799);
        }
    }

    /* renamed from: com.bumptech.glide.a.a$d */
    public final class C31918d {
        private final long[] axL;
        private final long axQ;
        public final File[] files;
        private final String key;

        /* synthetic */ C31918d(C31916a c31916a, String str, long j, File[] fileArr, long[] jArr, byte b) {
            this(str, j, fileArr, jArr);
        }

        private C31918d(String str, long j, File[] fileArr, long[] jArr) {
            this.key = str;
            this.axQ = j;
            this.files = fileArr;
            this.axL = jArr;
        }
    }

    /* renamed from: com.bumptech.glide.a.a$a */
    static final class C31919a implements ThreadFactory {
        private C31919a() {
        }

        /* synthetic */ C31919a(byte b) {
            this();
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            AppMethodBeat.m2504i(51814);
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            AppMethodBeat.m2505o(51814);
            return thread;
        }
    }

    /* renamed from: com.bumptech.glide.a.a$c */
    final class C31920c {
        final long[] axL;
        File[] axM;
        File[] axN;
        boolean axO;
        C31917b axP;
        long axQ;
        final String key;

        /* synthetic */ C31920c(C31916a c31916a, String str, byte b) {
            this(str);
        }

        private C31920c(String str) {
            AppMethodBeat.m2504i(51800);
            this.key = str;
            this.axL = new long[C31916a.this.axA];
            this.axM = new File[C31916a.this.axA];
            this.axN = new File[C31916a.this.axA];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < C31916a.this.axA; i++) {
                append.append(i);
                this.axM[i] = new File(C31916a.this.directory, append.toString());
                append.append(".tmp");
                this.axN[i] = new File(C31916a.this.directory, append.toString());
                append.setLength(length);
            }
            AppMethodBeat.m2505o(51800);
        }

        /* renamed from: lR */
        public final String mo52036lR() {
            AppMethodBeat.m2504i(51801);
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.axL) {
                stringBuilder.append(' ').append(append);
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(51801);
            return stringBuilder2;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final void mo52035c(String[] strArr) {
            AppMethodBeat.m2504i(51802);
            IOException d;
            if (strArr.length != C31916a.this.axA) {
                d = C31920c.m51825d(strArr);
                AppMethodBeat.m2505o(51802);
                throw d;
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.axL[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    d = C31920c.m51825d(strArr);
                    AppMethodBeat.m2505o(51802);
                    throw d;
                }
            }
            AppMethodBeat.m2505o(51802);
        }

        /* renamed from: d */
        private static IOException m51825d(String[] strArr) {
            AppMethodBeat.m2504i(51803);
            IOException iOException = new IOException("unexpected journal line: " + Arrays.toString(strArr));
            AppMethodBeat.m2505o(51803);
            throw iOException;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m51809b(C31916a c31916a) {
        AppMethodBeat.m2504i(51792);
        c31916a.trimToSize();
        AppMethodBeat.m2505o(51792);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m51810c(C31916a c31916a) {
        AppMethodBeat.m2504i(51793);
        boolean lN = c31916a.m51819lN();
        AppMethodBeat.m2505o(51793);
        return lN;
    }

    /* renamed from: d */
    static /* synthetic */ void m51811d(C31916a c31916a) {
        AppMethodBeat.m2504i(51794);
        c31916a.m51818lM();
        AppMethodBeat.m2505o(51794);
    }

    private C31916a(File file, long j) {
        AppMethodBeat.m2504i(51777);
        this.directory = file;
        this.axy = 1;
        this.axv = new File(file, "journal");
        this.axw = new File(file, "journal.tmp");
        this.axx = new File(file, "journal.bkp");
        this.axA = 1;
        this.axz = j;
        AppMethodBeat.m2505o(51777);
    }

    /* renamed from: a */
    public static C31916a m51804a(File file, long j) {
        AppMethodBeat.m2504i(51778);
        if (j <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.m2505o(51778);
            throw illegalArgumentException;
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                C31916a.m51808a(file2, file3, false);
            }
        }
        C31916a c31916a = new C31916a(file, j);
        if (c31916a.axv.exists()) {
            try {
                c31916a.m51816lK();
                c31916a.m51817lL();
                AppMethodBeat.m2505o(51778);
                return c31916a;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                c31916a.close();
                C0740c.m1698l(c31916a.directory);
            }
        }
        file.mkdirs();
        c31916a = new C31916a(file, j);
        c31916a.m51818lM();
        AppMethodBeat.m2505o(51778);
        return c31916a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d A:{Catch:{ EOFException -> 0x00cf, all -> 0x00a3 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: lK */
    private void m51816lK() {
        Object obj;
        AppMethodBeat.m2504i(51779);
        C17510b c17510b = new C17510b(new FileInputStream(this.axv), C0740c.US_ASCII);
        int i;
        try {
            String readLine = c17510b.readLine();
            String readLine2 = c17510b.readLine();
            String readLine3 = c17510b.readLine();
            String readLine4 = c17510b.readLine();
            String readLine5 = c17510b.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.axy).equals(readLine3) && Integer.toString(this.axA).equals(readLine4) && "".equals(readLine5)) {
                IOException iOException;
                i = 0;
                while (true) {
                    readLine4 = c17510b.readLine();
                    int indexOf = readLine4.indexOf(32);
                    if (indexOf == -1) {
                        iOException = new IOException("unexpected journal line: ".concat(String.valueOf(readLine4)));
                        AppMethodBeat.m2505o(51779);
                        throw iOException;
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = readLine4.indexOf(32, i2);
                    Object substring;
                    C31920c c31920c;
                    if (indexOf2 != -1) {
                        substring = readLine4.substring(i2, indexOf2);
                        c31920c = (C31920c) this.axC.get(substring);
                        if (c31920c == null) {
                        }
                        if (indexOf2 == -1) {
                        }
                        if (indexOf2 != -1) {
                        }
                        if (indexOf2 != -1) {
                            break;
                        }
                        break;
                    }
                    readLine = readLine4.substring(i2);
                    if (indexOf == 6 && readLine4.startsWith("REMOVE")) {
                        this.axC.remove(readLine);
                    } else {
                        readLine3 = readLine;
                        c31920c = (C31920c) this.axC.get(substring);
                        if (c31920c == null) {
                            c31920c = new C31920c(this, substring, (byte) 0);
                            this.axC.put(substring, c31920c);
                        }
                        if (indexOf2 == -1 && indexOf == 5 && readLine4.startsWith("CLEAN")) {
                            String[] split = readLine4.substring(indexOf2 + 1).split(" ");
                            c31920c.axO = true;
                            c31920c.axP = null;
                            c31920c.mo52035c(split);
                        } else if (indexOf2 != -1 && indexOf == 5 && readLine4.startsWith("DIRTY")) {
                            c31920c.axP = new C31917b(this, c31920c, (byte) 0);
                        } else if (indexOf2 != -1 || indexOf != 4 || !readLine4.startsWith("READ")) {
                            iOException = new IOException("unexpected journal line: ".concat(String.valueOf(readLine4)));
                            AppMethodBeat.m2505o(51779);
                        }
                    }
                    i++;
                }
                iOException = new IOException("unexpected journal line: ".concat(String.valueOf(readLine4)));
                AppMethodBeat.m2505o(51779);
                throw iOException;
            }
            IOException iOException2 = new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            AppMethodBeat.m2505o(51779);
            throw iOException2;
        } catch (EOFException e) {
            this.axD = i - this.axC.size();
            if (c17510b.end == -1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m51818lM();
            } else {
                this.axB = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axv, true), C0740c.US_ASCII));
            }
            C0740c.closeQuietly(c17510b);
            AppMethodBeat.m2505o(51779);
        } catch (Throwable th) {
            C0740c.closeQuietly(c17510b);
            AppMethodBeat.m2505o(51779);
        }
    }

    /* renamed from: lL */
    private void m51817lL() {
        AppMethodBeat.m2504i(51780);
        C31916a.m51815k(this.axw);
        Iterator it = this.axC.values().iterator();
        while (it.hasNext()) {
            C31920c c31920c = (C31920c) it.next();
            int i;
            if (c31920c.axP == null) {
                for (i = 0; i < this.axA; i++) {
                    this.size += c31920c.axL[i];
                }
            } else {
                c31920c.axP = null;
                for (i = 0; i < this.axA; i++) {
                    C31916a.m51815k(c31920c.axM[i]);
                    C31916a.m51815k(c31920c.axN[i]);
                }
                it.remove();
            }
        }
        AppMethodBeat.m2505o(51780);
    }

    /* renamed from: lM */
    private synchronized void m51818lM() {
        AppMethodBeat.m2504i(51781);
        if (this.axB != null) {
            this.axB.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axw), C0740c.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write("1");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.axy));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.axA));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            for (C31920c c31920c : this.axC.values()) {
                if (c31920c.axP != null) {
                    bufferedWriter.write("DIRTY " + c31920c.key + 10);
                } else {
                    bufferedWriter.write("CLEAN " + c31920c.key + c31920c.mo52036lR() + 10);
                }
            }
            bufferedWriter.close();
            if (this.axv.exists()) {
                C31916a.m51808a(this.axv, this.axx, true);
            }
            C31916a.m51808a(this.axw, this.axv, false);
            this.axx.delete();
            this.axB = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axv, true), C0740c.US_ASCII));
            AppMethodBeat.m2505o(51781);
        } catch (Throwable th) {
            bufferedWriter.close();
            AppMethodBeat.m2505o(51781);
        }
    }

    /* renamed from: k */
    private static void m51815k(File file) {
        AppMethodBeat.m2504i(51782);
        if (!file.exists() || file.delete()) {
            AppMethodBeat.m2505o(51782);
            return;
        }
        IOException iOException = new IOException();
        AppMethodBeat.m2505o(51782);
        throw iOException;
    }

    /* renamed from: a */
    private static void m51808a(File file, File file2, boolean z) {
        AppMethodBeat.m2504i(51783);
        if (z) {
            C31916a.m51815k(file2);
        }
        if (file.renameTo(file2)) {
            AppMethodBeat.m2505o(51783);
            return;
        }
        IOException iOException = new IOException();
        AppMethodBeat.m2505o(51783);
        throw iOException;
    }

    /* renamed from: X */
    public final synchronized C31918d mo52028X(String str) {
        C31918d c31918d = null;
        synchronized (this) {
            AppMethodBeat.m2504i(51784);
            m51820lO();
            C31920c c31920c = (C31920c) this.axC.get(str);
            if (c31920c == null) {
                AppMethodBeat.m2505o(51784);
            } else if (c31920c.axO) {
                for (File exists : c31920c.axM) {
                    if (!exists.exists()) {
                        AppMethodBeat.m2505o(51784);
                        break;
                    }
                }
                this.axD++;
                this.axB.append("READ");
                this.axB.append(' ');
                this.axB.append(str);
                this.axB.append(10);
                if (m51819lN()) {
                    this.axF.submit(this.axG);
                }
                c31918d = new C31918d(this, str, c31920c.axQ, c31920c.axM, c31920c.axL, (byte) 0);
                AppMethodBeat.m2505o(51784);
            } else {
                AppMethodBeat.m2505o(51784);
            }
        }
        return c31918d;
    }

    /* renamed from: Y */
    public final synchronized C31917b mo52029Y(String str) {
        C31917b c31917b;
        AppMethodBeat.m2504i(51785);
        m51820lO();
        C31920c c31920c = (C31920c) this.axC.get(str);
        if (-1 == -1 || (c31920c != null && c31920c.axQ == -1)) {
            C31920c c31920c2;
            if (c31920c == null) {
                c31920c = new C31920c(this, str, (byte) 0);
                this.axC.put(str, c31920c);
                c31920c2 = c31920c;
            } else if (c31920c.axP != null) {
                AppMethodBeat.m2505o(51785);
                c31917b = null;
            } else {
                c31920c2 = c31920c;
            }
            c31917b = new C31917b(this, c31920c2, (byte) 0);
            c31920c2.axP = c31917b;
            this.axB.append("DIRTY");
            this.axB.append(' ');
            this.axB.append(str);
            this.axB.append(10);
            this.axB.flush();
            AppMethodBeat.m2505o(51785);
        } else {
            AppMethodBeat.m2505o(51785);
            c31917b = null;
        }
        return c31917b;
    }

    /* renamed from: lN */
    private boolean m51819lN() {
        AppMethodBeat.m2504i(51787);
        if (this.axD < 2000 || this.axD < this.axC.size()) {
            AppMethodBeat.m2505o(51787);
            return false;
        }
        AppMethodBeat.m2505o(51787);
        return true;
    }

    private synchronized boolean remove(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(51788);
            m51820lO();
            C31920c c31920c = (C31920c) this.axC.get(str);
            if (c31920c == null || c31920c.axP != null) {
                AppMethodBeat.m2505o(51788);
                z = false;
            } else {
                while (i < this.axA) {
                    File file = c31920c.axM[i];
                    if (!file.exists() || file.delete()) {
                        this.size -= c31920c.axL[i];
                        c31920c.axL[i] = 0;
                        i++;
                    } else {
                        IOException iOException = new IOException("failed to delete ".concat(String.valueOf(file)));
                        AppMethodBeat.m2505o(51788);
                        throw iOException;
                    }
                }
                this.axD++;
                this.axB.append("REMOVE");
                this.axB.append(' ');
                this.axB.append(str);
                this.axB.append(10);
                this.axC.remove(str);
                if (m51819lN()) {
                    this.axF.submit(this.axG);
                }
                z = true;
                AppMethodBeat.m2505o(51788);
            }
        }
        return z;
    }

    /* renamed from: lO */
    private void m51820lO() {
        AppMethodBeat.m2504i(51789);
        if (this.axB == null) {
            IllegalStateException illegalStateException = new IllegalStateException("cache is closed");
            AppMethodBeat.m2505o(51789);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(51789);
    }

    public final synchronized void close() {
        AppMethodBeat.m2504i(51790);
        if (this.axB == null) {
            AppMethodBeat.m2505o(51790);
        } else {
            Iterator it = new ArrayList(this.axC.values()).iterator();
            while (it.hasNext()) {
                C31920c c31920c = (C31920c) it.next();
                if (c31920c.axP != null) {
                    c31920c.axP.abort();
                }
            }
            trimToSize();
            this.axB.close();
            this.axB = null;
            AppMethodBeat.m2505o(51790);
        }
    }

    private void trimToSize() {
        AppMethodBeat.m2504i(51791);
        while (this.size > this.axz) {
            remove((String) ((Entry) this.axC.entrySet().iterator().next()).getKey());
        }
        AppMethodBeat.m2505o(51791);
    }

    /* renamed from: a */
    private synchronized void m51806a(C31917b c31917b, boolean z) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(51786);
            C31920c c31920c = c31917b.axI;
            IllegalStateException illegalStateException;
            if (c31920c.axP != c31917b) {
                illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(51786);
                throw illegalStateException;
            }
            if (z) {
                if (!c31920c.axO) {
                    int i2 = 0;
                    while (i2 < this.axA) {
                        if (!c31917b.axJ[i2]) {
                            c31917b.abort();
                            illegalStateException = new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                            AppMethodBeat.m2505o(51786);
                            throw illegalStateException;
                        } else if (!c31920c.axN[i2].exists()) {
                            c31917b.abort();
                            AppMethodBeat.m2505o(51786);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.axA) {
                File file = c31920c.axN[i];
                if (!z) {
                    C31916a.m51815k(file);
                } else if (file.exists()) {
                    File file2 = c31920c.axM[i];
                    file.renameTo(file2);
                    long j = c31920c.axL[i];
                    long length = file2.length();
                    c31920c.axL[i] = length;
                    this.size = (this.size - j) + length;
                }
                i++;
            }
            this.axD++;
            c31920c.axP = null;
            if ((c31920c.axO | z) != 0) {
                c31920c.axO = true;
                this.axB.append("CLEAN");
                this.axB.append(' ');
                this.axB.append(c31920c.key);
                this.axB.append(c31920c.mo52036lR());
                this.axB.append(10);
                if (z) {
                    long j2 = this.axE;
                    this.axE = 1 + j2;
                    c31920c.axQ = j2;
                }
            } else {
                this.axC.remove(c31920c.key);
                this.axB.append("REMOVE");
                this.axB.append(' ');
                this.axB.append(c31920c.key);
                this.axB.append(10);
            }
            this.axB.flush();
            if (this.size > this.axz || m51819lN()) {
                this.axF.submit(this.axG);
            }
            AppMethodBeat.m2505o(51786);
        }
    }
}
