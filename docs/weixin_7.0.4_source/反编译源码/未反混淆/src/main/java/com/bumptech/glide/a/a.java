package com.bumptech.glide.a;

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

public final class a implements Closeable {
    private final int axA;
    private Writer axB;
    private final LinkedHashMap<String, c> axC = new LinkedHashMap(0, 0.75f, true);
    private int axD;
    private long axE = 0;
    final ThreadPoolExecutor axF = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
    private final Callable<Void> axG = new Callable<Void>() {
        private Void call() {
            AppMethodBeat.i(51805);
            synchronized (a.this) {
                try {
                    if (a.this.axB == null) {
                    } else {
                        a.b(a.this);
                        if (a.c(a.this)) {
                            a.d(a.this);
                            a.this.axD = 0;
                        }
                        AppMethodBeat.o(51805);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(51805);
                }
            }
            return null;
        }
    };
    private final File axv;
    private final File axw;
    private final File axx;
    private final int axy;
    private long axz;
    private final File directory;
    private long size = 0;

    public final class b {
        final c axI;
        final boolean[] axJ;
        public boolean axK;

        /* synthetic */ b(a aVar, c cVar, byte b) {
            this(cVar);
        }

        private b(c cVar) {
            AppMethodBeat.i(51796);
            this.axI = cVar;
            this.axJ = cVar.axO ? null : new boolean[a.this.axA];
            AppMethodBeat.o(51796);
        }

        public final File lP() {
            File file;
            AppMethodBeat.i(51797);
            synchronized (a.this) {
                try {
                    if (this.axI.axP != this) {
                        Object illegalStateException = new IllegalStateException();
                        throw illegalStateException;
                    }
                    if (!this.axI.axO) {
                        this.axJ[0] = true;
                    }
                    file = this.axI.axN[0];
                    if (!a.this.directory.exists()) {
                        a.this.directory.mkdirs();
                    }
                } finally {
                    AppMethodBeat.o(51797);
                }
            }
            AppMethodBeat.o(51797);
            return file;
        }

        public final void abort() {
            AppMethodBeat.i(51798);
            a.a(a.this, this, false);
            AppMethodBeat.o(51798);
        }

        public final void lQ() {
            AppMethodBeat.i(51799);
            if (!this.axK) {
                try {
                    abort();
                    AppMethodBeat.o(51799);
                    return;
                } catch (IOException e) {
                }
            }
            AppMethodBeat.o(51799);
        }
    }

    public final class d {
        private final long[] axL;
        private final long axQ;
        public final File[] files;
        private final String key;

        /* synthetic */ d(a aVar, String str, long j, File[] fileArr, long[] jArr, byte b) {
            this(str, j, fileArr, jArr);
        }

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.key = str;
            this.axQ = j;
            this.files = fileArr;
            this.axL = jArr;
        }
    }

    static final class a implements ThreadFactory {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            AppMethodBeat.i(51814);
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            AppMethodBeat.o(51814);
            return thread;
        }
    }

    final class c {
        final long[] axL;
        File[] axM;
        File[] axN;
        boolean axO;
        b axP;
        long axQ;
        final String key;

        /* synthetic */ c(a aVar, String str, byte b) {
            this(str);
        }

        private c(String str) {
            AppMethodBeat.i(51800);
            this.key = str;
            this.axL = new long[a.this.axA];
            this.axM = new File[a.this.axA];
            this.axN = new File[a.this.axA];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < a.this.axA; i++) {
                append.append(i);
                this.axM[i] = new File(a.this.directory, append.toString());
                append.append(".tmp");
                this.axN[i] = new File(a.this.directory, append.toString());
                append.setLength(length);
            }
            AppMethodBeat.o(51800);
        }

        public final String lR() {
            AppMethodBeat.i(51801);
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.axL) {
                stringBuilder.append(' ').append(append);
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(51801);
            return stringBuilder2;
        }

        /* Access modifiers changed, original: final */
        public final void c(String[] strArr) {
            AppMethodBeat.i(51802);
            IOException d;
            if (strArr.length != a.this.axA) {
                d = d(strArr);
                AppMethodBeat.o(51802);
                throw d;
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.axL[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    d = d(strArr);
                    AppMethodBeat.o(51802);
                    throw d;
                }
            }
            AppMethodBeat.o(51802);
        }

        private static IOException d(String[] strArr) {
            AppMethodBeat.i(51803);
            IOException iOException = new IOException("unexpected journal line: " + Arrays.toString(strArr));
            AppMethodBeat.o(51803);
            throw iOException;
        }
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(51792);
        aVar.trimToSize();
        AppMethodBeat.o(51792);
    }

    static /* synthetic */ boolean c(a aVar) {
        AppMethodBeat.i(51793);
        boolean lN = aVar.lN();
        AppMethodBeat.o(51793);
        return lN;
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(51794);
        aVar.lM();
        AppMethodBeat.o(51794);
    }

    private a(File file, long j) {
        AppMethodBeat.i(51777);
        this.directory = file;
        this.axy = 1;
        this.axv = new File(file, "journal");
        this.axw = new File(file, "journal.tmp");
        this.axx = new File(file, "journal.bkp");
        this.axA = 1;
        this.axz = j;
        AppMethodBeat.o(51777);
    }

    public static a a(File file, long j) {
        AppMethodBeat.i(51778);
        if (j <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.o(51778);
            throw illegalArgumentException;
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, j);
        if (aVar.axv.exists()) {
            try {
                aVar.lK();
                aVar.lL();
                AppMethodBeat.o(51778);
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.close();
                c.l(aVar.directory);
            }
        }
        file.mkdirs();
        aVar = new a(file, j);
        aVar.lM();
        AppMethodBeat.o(51778);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d A:{Catch:{ EOFException -> 0x00cf, all -> 0x00a3 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void lK() {
        Object obj;
        AppMethodBeat.i(51779);
        b bVar = new b(new FileInputStream(this.axv), c.US_ASCII);
        int i;
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.axy).equals(readLine3) && Integer.toString(this.axA).equals(readLine4) && "".equals(readLine5)) {
                IOException iOException;
                i = 0;
                while (true) {
                    readLine4 = bVar.readLine();
                    int indexOf = readLine4.indexOf(32);
                    if (indexOf == -1) {
                        iOException = new IOException("unexpected journal line: ".concat(String.valueOf(readLine4)));
                        AppMethodBeat.o(51779);
                        throw iOException;
                    }
                    int i2 = indexOf + 1;
                    int indexOf2 = readLine4.indexOf(32, i2);
                    Object substring;
                    c cVar;
                    if (indexOf2 != -1) {
                        substring = readLine4.substring(i2, indexOf2);
                        cVar = (c) this.axC.get(substring);
                        if (cVar == null) {
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
                        cVar = (c) this.axC.get(substring);
                        if (cVar == null) {
                            cVar = new c(this, substring, (byte) 0);
                            this.axC.put(substring, cVar);
                        }
                        if (indexOf2 == -1 && indexOf == 5 && readLine4.startsWith("CLEAN")) {
                            String[] split = readLine4.substring(indexOf2 + 1).split(" ");
                            cVar.axO = true;
                            cVar.axP = null;
                            cVar.c(split);
                        } else if (indexOf2 != -1 && indexOf == 5 && readLine4.startsWith("DIRTY")) {
                            cVar.axP = new b(this, cVar, (byte) 0);
                        } else if (indexOf2 != -1 || indexOf != 4 || !readLine4.startsWith("READ")) {
                            iOException = new IOException("unexpected journal line: ".concat(String.valueOf(readLine4)));
                            AppMethodBeat.o(51779);
                        }
                    }
                    i++;
                }
                iOException = new IOException("unexpected journal line: ".concat(String.valueOf(readLine4)));
                AppMethodBeat.o(51779);
                throw iOException;
            }
            IOException iOException2 = new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            AppMethodBeat.o(51779);
            throw iOException2;
        } catch (EOFException e) {
            this.axD = i - this.axC.size();
            if (bVar.end == -1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                lM();
            } else {
                this.axB = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axv, true), c.US_ASCII));
            }
            c.closeQuietly(bVar);
            AppMethodBeat.o(51779);
        } catch (Throwable th) {
            c.closeQuietly(bVar);
            AppMethodBeat.o(51779);
        }
    }

    private void lL() {
        AppMethodBeat.i(51780);
        k(this.axw);
        Iterator it = this.axC.values().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int i;
            if (cVar.axP == null) {
                for (i = 0; i < this.axA; i++) {
                    this.size += cVar.axL[i];
                }
            } else {
                cVar.axP = null;
                for (i = 0; i < this.axA; i++) {
                    k(cVar.axM[i]);
                    k(cVar.axN[i]);
                }
                it.remove();
            }
        }
        AppMethodBeat.o(51780);
    }

    private synchronized void lM() {
        AppMethodBeat.i(51781);
        if (this.axB != null) {
            this.axB.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axw), c.US_ASCII));
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
            for (c cVar : this.axC.values()) {
                if (cVar.axP != null) {
                    bufferedWriter.write("DIRTY " + cVar.key + 10);
                } else {
                    bufferedWriter.write("CLEAN " + cVar.key + cVar.lR() + 10);
                }
            }
            bufferedWriter.close();
            if (this.axv.exists()) {
                a(this.axv, this.axx, true);
            }
            a(this.axw, this.axv, false);
            this.axx.delete();
            this.axB = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axv, true), c.US_ASCII));
            AppMethodBeat.o(51781);
        } catch (Throwable th) {
            bufferedWriter.close();
            AppMethodBeat.o(51781);
        }
    }

    private static void k(File file) {
        AppMethodBeat.i(51782);
        if (!file.exists() || file.delete()) {
            AppMethodBeat.o(51782);
            return;
        }
        IOException iOException = new IOException();
        AppMethodBeat.o(51782);
        throw iOException;
    }

    private static void a(File file, File file2, boolean z) {
        AppMethodBeat.i(51783);
        if (z) {
            k(file2);
        }
        if (file.renameTo(file2)) {
            AppMethodBeat.o(51783);
            return;
        }
        IOException iOException = new IOException();
        AppMethodBeat.o(51783);
        throw iOException;
    }

    public final synchronized d X(String str) {
        d dVar = null;
        synchronized (this) {
            AppMethodBeat.i(51784);
            lO();
            c cVar = (c) this.axC.get(str);
            if (cVar == null) {
                AppMethodBeat.o(51784);
            } else if (cVar.axO) {
                for (File exists : cVar.axM) {
                    if (!exists.exists()) {
                        AppMethodBeat.o(51784);
                        break;
                    }
                }
                this.axD++;
                this.axB.append("READ");
                this.axB.append(' ');
                this.axB.append(str);
                this.axB.append(10);
                if (lN()) {
                    this.axF.submit(this.axG);
                }
                dVar = new d(this, str, cVar.axQ, cVar.axM, cVar.axL, (byte) 0);
                AppMethodBeat.o(51784);
            } else {
                AppMethodBeat.o(51784);
            }
        }
        return dVar;
    }

    public final synchronized b Y(String str) {
        b bVar;
        AppMethodBeat.i(51785);
        lO();
        c cVar = (c) this.axC.get(str);
        if (-1 == -1 || (cVar != null && cVar.axQ == -1)) {
            c cVar2;
            if (cVar == null) {
                cVar = new c(this, str, (byte) 0);
                this.axC.put(str, cVar);
                cVar2 = cVar;
            } else if (cVar.axP != null) {
                AppMethodBeat.o(51785);
                bVar = null;
            } else {
                cVar2 = cVar;
            }
            bVar = new b(this, cVar2, (byte) 0);
            cVar2.axP = bVar;
            this.axB.append("DIRTY");
            this.axB.append(' ');
            this.axB.append(str);
            this.axB.append(10);
            this.axB.flush();
            AppMethodBeat.o(51785);
        } else {
            AppMethodBeat.o(51785);
            bVar = null;
        }
        return bVar;
    }

    private boolean lN() {
        AppMethodBeat.i(51787);
        if (this.axD < 2000 || this.axD < this.axC.size()) {
            AppMethodBeat.o(51787);
            return false;
        }
        AppMethodBeat.o(51787);
        return true;
    }

    private synchronized boolean remove(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(51788);
            lO();
            c cVar = (c) this.axC.get(str);
            if (cVar == null || cVar.axP != null) {
                AppMethodBeat.o(51788);
                z = false;
            } else {
                while (i < this.axA) {
                    File file = cVar.axM[i];
                    if (!file.exists() || file.delete()) {
                        this.size -= cVar.axL[i];
                        cVar.axL[i] = 0;
                        i++;
                    } else {
                        IOException iOException = new IOException("failed to delete ".concat(String.valueOf(file)));
                        AppMethodBeat.o(51788);
                        throw iOException;
                    }
                }
                this.axD++;
                this.axB.append("REMOVE");
                this.axB.append(' ');
                this.axB.append(str);
                this.axB.append(10);
                this.axC.remove(str);
                if (lN()) {
                    this.axF.submit(this.axG);
                }
                z = true;
                AppMethodBeat.o(51788);
            }
        }
        return z;
    }

    private void lO() {
        AppMethodBeat.i(51789);
        if (this.axB == null) {
            IllegalStateException illegalStateException = new IllegalStateException("cache is closed");
            AppMethodBeat.o(51789);
            throw illegalStateException;
        }
        AppMethodBeat.o(51789);
    }

    public final synchronized void close() {
        AppMethodBeat.i(51790);
        if (this.axB == null) {
            AppMethodBeat.o(51790);
        } else {
            Iterator it = new ArrayList(this.axC.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.axP != null) {
                    cVar.axP.abort();
                }
            }
            trimToSize();
            this.axB.close();
            this.axB = null;
            AppMethodBeat.o(51790);
        }
    }

    private void trimToSize() {
        AppMethodBeat.i(51791);
        while (this.size > this.axz) {
            remove((String) ((Entry) this.axC.entrySet().iterator().next()).getKey());
        }
        AppMethodBeat.o(51791);
    }

    private synchronized void a(b bVar, boolean z) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(51786);
            c cVar = bVar.axI;
            IllegalStateException illegalStateException;
            if (cVar.axP != bVar) {
                illegalStateException = new IllegalStateException();
                AppMethodBeat.o(51786);
                throw illegalStateException;
            }
            if (z) {
                if (!cVar.axO) {
                    int i2 = 0;
                    while (i2 < this.axA) {
                        if (!bVar.axJ[i2]) {
                            bVar.abort();
                            illegalStateException = new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                            AppMethodBeat.o(51786);
                            throw illegalStateException;
                        } else if (!cVar.axN[i2].exists()) {
                            bVar.abort();
                            AppMethodBeat.o(51786);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.axA) {
                File file = cVar.axN[i];
                if (!z) {
                    k(file);
                } else if (file.exists()) {
                    File file2 = cVar.axM[i];
                    file.renameTo(file2);
                    long j = cVar.axL[i];
                    long length = file2.length();
                    cVar.axL[i] = length;
                    this.size = (this.size - j) + length;
                }
                i++;
            }
            this.axD++;
            cVar.axP = null;
            if ((cVar.axO | z) != 0) {
                cVar.axO = true;
                this.axB.append("CLEAN");
                this.axB.append(' ');
                this.axB.append(cVar.key);
                this.axB.append(cVar.lR());
                this.axB.append(10);
                if (z) {
                    long j2 = this.axE;
                    this.axE = 1 + j2;
                    cVar.axQ = j2;
                }
            } else {
                this.axC.remove(cVar.key);
                this.axB.append("REMOVE");
                this.axB.append(' ');
                this.axB.append(cVar.key);
                this.axB.append(10);
            }
            this.axB.flush();
            if (this.size > this.axz || lN()) {
                this.axF.submit(this.axG);
            }
            AppMethodBeat.o(51786);
        }
    }
}
