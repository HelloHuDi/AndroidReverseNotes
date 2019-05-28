package com.tencent.mm.plugin.dbbackup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0056 A:{SYNTHETIC, Splitter:B:5:0x0056} */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0056 A:{SYNTHETIC, Splitter:B:5:0x0056} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Collection<String> bib() {
        int i;
        Throwable e;
        Object obj;
        Closeable obj2 = null;
        AppMethodBeat.i(19031);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ah.getContext().getFileStreamPath("KeyInfo.bin"));
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(e.eSn, "KeyInfo.txt");
        ab.i("MicroMsg.DBRecoveryUtils", "Load IMEI from files, withDefaults: true, withExternals: true");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(q.LK());
        linkedHashSet.add(q.getDeviceID(ah.getContext()));
        if (bVar2.exists()) {
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new g(bVar2));
                i = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        linkedHashSet.add(readLine);
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load external information.", new Object[0]);
                            bo.b(bufferedReader);
                            if (bVar.exists()) {
                            }
                            linkedHashSet.add("1234567890ABCDEF");
                            AppMethodBeat.o(19031);
                            return linkedHashSet;
                        } catch (Throwable th) {
                            e = th;
                            bo.b(bufferedReader);
                            AppMethodBeat.o(19031);
                            throw e;
                        }
                    }
                }
                ab.i("MicroMsg.DBRecoveryUtils", "Loaded external information, entries: ".concat(String.valueOf(i)));
                bo.b(bufferedReader);
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load external information.", new Object[0]);
                bo.b(bufferedReader);
                if (bVar.exists()) {
                }
                linkedHashSet.add("1234567890ABCDEF");
                AppMethodBeat.o(19031);
                return linkedHashSet;
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = null;
                bo.b(bufferedReader);
                AppMethodBeat.o(19031);
                throw e;
            }
        }
        ab.i("MicroMsg.DBRecoveryUtils", "External file does not exist.");
        if (bVar.exists()) {
            try {
                Cipher instance = Cipher.getInstance("RC4");
                instance.init(2, new SecretKeySpec("_wEcHAT_".getBytes(), "RC4"));
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new CipherInputStream(com.tencent.mm.vfs.e.p(bVar), instance)));
                i = 0;
                while (true) {
                    try {
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        linkedHashSet.add(readLine2);
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        obj2 = bufferedReader2;
                        try {
                            ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                            bo.b(obj2);
                            linkedHashSet.add("1234567890ABCDEF");
                            AppMethodBeat.o(19031);
                            return linkedHashSet;
                        } catch (Throwable th3) {
                            e = th3;
                            bo.b(obj2);
                            AppMethodBeat.o(19031);
                            throw e;
                        }
                    } catch (Throwable th4) {
                        e = th4;
                        obj2 = bufferedReader2;
                        bo.b(obj2);
                        AppMethodBeat.o(19031);
                        throw e;
                    }
                }
                ab.i("MicroMsg.DBRecoveryUtils", "Loaded key information, entries: ".concat(String.valueOf(i)));
                bo.b(bufferedReader2);
            } catch (Exception e5) {
                e = e5;
                ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                bo.b(obj2);
                linkedHashSet.add("1234567890ABCDEF");
                AppMethodBeat.o(19031);
                return linkedHashSet;
            }
        }
        linkedHashSet.add("1234567890ABCDEF");
        AppMethodBeat.o(19031);
        return linkedHashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A:{Catch:{ Exception -> 0x00d8, all -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A:{Catch:{ Exception -> 0x00d8, all -> 0x0126 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Ii(String str) {
        Throwable e;
        PrintWriter printWriter;
        Iterator it;
        boolean o;
        Closeable closeable = null;
        AppMethodBeat.i(19032);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ah.getContext().getFileStreamPath("KeyInfo.bin"));
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(j.w(bVar.mUri) + ".tmp");
        SecretKeySpec secretKeySpec = new SecretKeySpec("_wEcHAT_".getBytes(), "RC4");
        try {
            Cipher instance = Cipher.getInstance("RC4");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Closeable bufferedReader;
            try {
                instance.init(2, secretKeySpec);
                bufferedReader = new BufferedReader(new InputStreamReader(new CipherInputStream(com.tencent.mm.vfs.e.p(bVar), instance)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bo.b(bufferedReader);
                            break;
                        } else if (readLine.equals(str)) {
                            ab.i("MicroMsg.DBRecoveryUtils", "Key information is already backed up.");
                            bo.b(bufferedReader);
                            AppMethodBeat.o(19032);
                            return true;
                        } else {
                            linkedHashSet.add(readLine);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                            bo.b(bufferedReader);
                            instance.init(1, secretKeySpec);
                            printWriter = new PrintWriter(new OutputStreamWriter(new CipherOutputStream(com.tencent.mm.vfs.e.q(bVar2), instance)));
                            printWriter.println(str);
                            it = linkedHashSet.iterator();
                            while (it.hasNext()) {
                            }
                            printWriter.close();
                            bVar.delete();
                            o = bVar2.o(bVar);
                            ab.i("MicroMsg.DBRecoveryUtils", "Backup key information succeeded: ".concat(String.valueOf(o)));
                            bo.b(null);
                            AppMethodBeat.o(19032);
                            return o;
                        } catch (Throwable th) {
                            e = th;
                            bo.b(bufferedReader);
                            AppMethodBeat.o(19032);
                            throw e;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                bo.b(bufferedReader);
                instance.init(1, secretKeySpec);
                printWriter = new PrintWriter(new OutputStreamWriter(new CipherOutputStream(com.tencent.mm.vfs.e.q(bVar2), instance)));
                printWriter.println(str);
                it = linkedHashSet.iterator();
                while (it.hasNext()) {
                }
                printWriter.close();
                bVar.delete();
                o = bVar2.o(bVar);
                ab.i("MicroMsg.DBRecoveryUtils", "Backup key information succeeded: ".concat(String.valueOf(o)));
                bo.b(null);
                AppMethodBeat.o(19032);
                return o;
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = null;
                bo.b(bufferedReader);
                AppMethodBeat.o(19032);
                throw e;
            }
            try {
                instance.init(1, secretKeySpec);
                printWriter = new PrintWriter(new OutputStreamWriter(new CipherOutputStream(com.tencent.mm.vfs.e.q(bVar2), instance)));
                try {
                    printWriter.println(str);
                    it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        printWriter.println((String) it.next());
                    }
                    printWriter.close();
                    bVar.delete();
                    o = bVar2.o(bVar);
                    ab.i("MicroMsg.DBRecoveryUtils", "Backup key information succeeded: ".concat(String.valueOf(o)));
                    bo.b(null);
                    AppMethodBeat.o(19032);
                    return o;
                } catch (Exception e4) {
                    e = e4;
                    closeable = printWriter;
                    try {
                        ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to backup key information.", new Object[0]);
                        bo.b(closeable);
                        AppMethodBeat.o(19032);
                        return false;
                    } catch (Throwable th3) {
                        e = th3;
                        bo.b(closeable);
                        AppMethodBeat.o(19032);
                        throw e;
                    }
                } catch (Throwable th4) {
                    e = th4;
                    Object obj = printWriter;
                    bo.b(closeable);
                    AppMethodBeat.o(19032);
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to backup key information.", new Object[0]);
                bo.b(closeable);
                AppMethodBeat.o(19032);
                return false;
            }
        } catch (Exception e6) {
            ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e6, "", new Object[0]);
            AppMethodBeat.o(19032);
            return false;
        }
    }
}
