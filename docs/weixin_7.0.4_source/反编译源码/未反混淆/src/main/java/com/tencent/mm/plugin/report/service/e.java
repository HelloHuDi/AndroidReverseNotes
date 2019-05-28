package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class e {
    private static boolean pWV = false;
    private static Map<Long, Long> pXT;
    private static a pXU = new a();
    private static int pXV = -1;
    private static boolean pXW = false;

    static {
        AppMethodBeat.i(72728);
        AppMethodBeat.o(72728);
    }

    public static void a(long j, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(72721);
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j, str, z, z3);
            } catch (Exception e) {
                ab.e("MicroMsg.KVEasyReport", "localReport :%s", bo.l(e));
            }
        } else {
            try {
                SmcLogic.writeKvData(j, str, z, z3);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.fP(20)) {
                    SmcLogic.writeKvData(j, str, z, z3);
                } else {
                    AppMethodBeat.o(72721);
                }
            }
        }
        if (pWV) {
            j.cgu().t(j, str);
        }
        AppMethodBeat.o(72721);
    }

    public static void a(long j, long j2, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(72722);
        if (z2) {
            try {
                SmcLogic.writeImportKvDataWithType(j, j2, str, z, z3);
            } catch (Exception e) {
                ab.e("MicroMsg.KVEasyReport", "localReport :%s", bo.l(e));
            }
        } else {
            try {
                SmcLogic.writeKvDataWithType(j, j2, str, z, z3);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.fP(20)) {
                    SmcLogic.writeKvDataWithType(j, j2, str, z, z3);
                } else {
                    AppMethodBeat.o(72722);
                }
            }
        }
        if (pWV) {
            j.cgu().t(j, str);
        }
        AppMethodBeat.o(72722);
    }

    public static void a(long j, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(72723);
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j, bArr, z);
                AppMethodBeat.o(72723);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.KVEasyReport", "localReport :%s", bo.l(e));
                AppMethodBeat.o(72723);
                return;
            }
        }
        SmcLogic.writeKvPbData(j, bArr, z);
        AppMethodBeat.o(72723);
    }

    public static void b(long j, long j2, long j3, boolean z) {
        AppMethodBeat.i(72724);
        long j4 = j;
        do {
            int i;
            String str = "MicroMsg.KVEasyReport";
            String str2 = "SmcLogic.reportIDKey class loader %s, %s ";
            Object[] objArr = new Object[2];
            if (e.class.getClassLoader() == null) {
                i = -1;
            } else {
                i = e.class.getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            ab.i(str, str2, objArr);
            try {
                SmcLogic.reportIDKey(j4, j2, j3, z);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.fP(20)) {
                    SmcLogic.reportIDKey(j4, j2, j3, z);
                } else {
                    AppMethodBeat.o(72724);
                }
            }
            if (!pXW) {
                break;
            }
            if (pXT == null) {
                cgp();
            }
            j4 = bo.a((Long) pXT.get(Long.valueOf(j4)), 0);
        } while (j4 > 0);
        AppMethodBeat.o(72724);
    }

    public static void d(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(72725);
        if (arrayList != null) {
            try {
                SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                AppMethodBeat.o(72725);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.fP(20)) {
                    SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                    AppMethodBeat.o(72725);
                    return;
                }
                AppMethodBeat.o(72725);
            }
        } else {
            AppMethodBeat.o(72725);
        }
    }

    public static void ki(boolean z) {
        AppMethodBeat.i(72726);
        ab.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", Boolean.valueOf(pXW), Boolean.valueOf(z), bo.dpG());
        pXW = z;
        AppMethodBeat.o(72726);
    }

    public static synchronized void cgp() {
        synchronized (e.class) {
            AppMethodBeat.i(72727);
            if (pXT == null) {
                pXT = new HashMap(20);
            }
            ate cgh = a.cgh();
            if (!(cgh == null || cgh.wxc == pXV)) {
                pXV = cgh.wxc;
                pXT.clear();
                LinkedList linkedList = cgh.wxd;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bdf bdf = (bdf) it.next();
                        pXT.put(new Long((long) bdf.wHk), new Long((long) bdf.wHl));
                    }
                }
            }
            ab.i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", Integer.valueOf(pXV), Integer.valueOf(pXT.size()), pXT, bo.dpG());
            AppMethodBeat.o(72727);
        }
    }

    public static void kh(boolean z) {
        pWV = z;
    }
}
