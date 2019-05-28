package com.tencent.p177mm.plugin.dbbackup.p938a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5732g;
import com.tencent.p177mm.vfs.C5736j;
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

/* renamed from: com.tencent.mm.plugin.dbbackup.a.b */
public final class C27700b {
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0056 A:{SYNTHETIC, Splitter:B:5:0x0056} */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0056 A:{SYNTHETIC, Splitter:B:5:0x0056} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Collection<String> bib() {
        int i;
        Throwable e;
        Object obj;
        Closeable obj2 = null;
        AppMethodBeat.m2504i(19031);
        C5728b c5728b = new C5728b(C4996ah.getContext().getFileStreamPath("KeyInfo.bin"));
        C5728b c5728b2 = new C5728b(C6457e.eSn, "KeyInfo.txt");
        C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Load IMEI from files, withDefaults: true, withExternals: true");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(C1427q.m3026LK());
        linkedHashSet.add(C1427q.getDeviceID(C4996ah.getContext()));
        if (c5728b2.exists()) {
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new C5732g(c5728b2));
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
                            C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load external information.", new Object[0]);
                            C5046bo.m7527b(bufferedReader);
                            if (c5728b.exists()) {
                            }
                            linkedHashSet.add("1234567890ABCDEF");
                            AppMethodBeat.m2505o(19031);
                            return linkedHashSet;
                        } catch (Throwable th) {
                            e = th;
                            C5046bo.m7527b(bufferedReader);
                            AppMethodBeat.m2505o(19031);
                            throw e;
                        }
                    }
                }
                C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Loaded external information, entries: ".concat(String.valueOf(i)));
                C5046bo.m7527b(bufferedReader);
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load external information.", new Object[0]);
                C5046bo.m7527b(bufferedReader);
                if (c5728b.exists()) {
                }
                linkedHashSet.add("1234567890ABCDEF");
                AppMethodBeat.m2505o(19031);
                return linkedHashSet;
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = null;
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(19031);
                throw e;
            }
        }
        C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "External file does not exist.");
        if (c5728b.exists()) {
            try {
                Cipher instance = Cipher.getInstance("RC4");
                instance.init(2, new SecretKeySpec("_wEcHAT_".getBytes(), "RC4"));
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new CipherInputStream(C5730e.m8638p(c5728b), instance)));
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
                            C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                            C5046bo.m7527b(obj2);
                            linkedHashSet.add("1234567890ABCDEF");
                            AppMethodBeat.m2505o(19031);
                            return linkedHashSet;
                        } catch (Throwable th3) {
                            e = th3;
                            C5046bo.m7527b(obj2);
                            AppMethodBeat.m2505o(19031);
                            throw e;
                        }
                    } catch (Throwable th4) {
                        e = th4;
                        obj2 = bufferedReader2;
                        C5046bo.m7527b(obj2);
                        AppMethodBeat.m2505o(19031);
                        throw e;
                    }
                }
                C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Loaded key information, entries: ".concat(String.valueOf(i)));
                C5046bo.m7527b(bufferedReader2);
            } catch (Exception e5) {
                e = e5;
                C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                C5046bo.m7527b(obj2);
                linkedHashSet.add("1234567890ABCDEF");
                AppMethodBeat.m2505o(19031);
                return linkedHashSet;
            }
        }
        linkedHashSet.add("1234567890ABCDEF");
        AppMethodBeat.m2505o(19031);
        return linkedHashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A:{Catch:{ Exception -> 0x00d8, all -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A:{Catch:{ Exception -> 0x00d8, all -> 0x0126 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Ii */
    public static boolean m44016Ii(String str) {
        Throwable e;
        PrintWriter printWriter;
        Iterator it;
        boolean o;
        Closeable closeable = null;
        AppMethodBeat.m2504i(19032);
        C5728b c5728b = new C5728b(C4996ah.getContext().getFileStreamPath("KeyInfo.bin"));
        C5728b c5728b2 = new C5728b(C5736j.m8649w(c5728b.mUri) + ".tmp");
        SecretKeySpec secretKeySpec = new SecretKeySpec("_wEcHAT_".getBytes(), "RC4");
        try {
            Cipher instance = Cipher.getInstance("RC4");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Closeable bufferedReader;
            try {
                instance.init(2, secretKeySpec);
                bufferedReader = new BufferedReader(new InputStreamReader(new CipherInputStream(C5730e.m8638p(c5728b), instance)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            C5046bo.m7527b(bufferedReader);
                            break;
                        } else if (readLine.equals(str)) {
                            C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Key information is already backed up.");
                            C5046bo.m7527b(bufferedReader);
                            AppMethodBeat.m2505o(19032);
                            return true;
                        } else {
                            linkedHashSet.add(readLine);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                            C5046bo.m7527b(bufferedReader);
                            instance.init(1, secretKeySpec);
                            printWriter = new PrintWriter(new OutputStreamWriter(new CipherOutputStream(C5730e.m8641q(c5728b2), instance)));
                            printWriter.println(str);
                            it = linkedHashSet.iterator();
                            while (it.hasNext()) {
                            }
                            printWriter.close();
                            c5728b.delete();
                            o = c5728b2.mo11675o(c5728b);
                            C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Backup key information succeeded: ".concat(String.valueOf(o)));
                            C5046bo.m7527b(null);
                            AppMethodBeat.m2505o(19032);
                            return o;
                        } catch (Throwable th) {
                            e = th;
                            C5046bo.m7527b(bufferedReader);
                            AppMethodBeat.m2505o(19032);
                            throw e;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to load key information.", new Object[0]);
                C5046bo.m7527b(bufferedReader);
                instance.init(1, secretKeySpec);
                printWriter = new PrintWriter(new OutputStreamWriter(new CipherOutputStream(C5730e.m8641q(c5728b2), instance)));
                printWriter.println(str);
                it = linkedHashSet.iterator();
                while (it.hasNext()) {
                }
                printWriter.close();
                c5728b.delete();
                o = c5728b2.mo11675o(c5728b);
                C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Backup key information succeeded: ".concat(String.valueOf(o)));
                C5046bo.m7527b(null);
                AppMethodBeat.m2505o(19032);
                return o;
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = null;
                C5046bo.m7527b(bufferedReader);
                AppMethodBeat.m2505o(19032);
                throw e;
            }
            try {
                instance.init(1, secretKeySpec);
                printWriter = new PrintWriter(new OutputStreamWriter(new CipherOutputStream(C5730e.m8641q(c5728b2), instance)));
                try {
                    printWriter.println(str);
                    it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        printWriter.println((String) it.next());
                    }
                    printWriter.close();
                    c5728b.delete();
                    o = c5728b2.mo11675o(c5728b);
                    C4990ab.m7416i("MicroMsg.DBRecoveryUtils", "Backup key information succeeded: ".concat(String.valueOf(o)));
                    C5046bo.m7527b(null);
                    AppMethodBeat.m2505o(19032);
                    return o;
                } catch (Exception e4) {
                    e = e4;
                    closeable = printWriter;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to backup key information.", new Object[0]);
                        C5046bo.m7527b(closeable);
                        AppMethodBeat.m2505o(19032);
                        return false;
                    } catch (Throwable th3) {
                        e = th3;
                        C5046bo.m7527b(closeable);
                        AppMethodBeat.m2505o(19032);
                        throw e;
                    }
                } catch (Throwable th4) {
                    e = th4;
                    Object obj = printWriter;
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(19032);
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e, "Failed to backup key information.", new Object[0]);
                C5046bo.m7527b(closeable);
                AppMethodBeat.m2505o(19032);
                return false;
            }
        } catch (Exception e6) {
            C4990ab.printErrStackTrace("MicroMsg.DBRecoveryUtils", e6, "", new Object[0]);
            AppMethodBeat.m2505o(19032);
            return false;
        }
    }
}
