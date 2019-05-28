package com.tencent.p177mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.report.p499b.C3732a;
import com.tencent.p177mm.protocal.protobuf.ate;
import com.tencent.p177mm.protocal.protobuf.bdf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.report.service.e */
public class C3744e {
    private static boolean pWV = false;
    private static Map<Long, Long> pXT;
    private static C3732a pXU = new C3732a();
    private static int pXV = -1;
    private static boolean pXW = false;

    static {
        AppMethodBeat.m2504i(72728);
        AppMethodBeat.m2505o(72728);
    }

    /* renamed from: a */
    public static void m6058a(long j, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(72721);
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j, str, z, z3);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.KVEasyReport", "localReport :%s", C5046bo.m7574l(e));
            }
        } else {
            try {
                SmcLogic.writeKvData(j, str, z, z3);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (C1443d.m3067fP(20)) {
                    SmcLogic.writeKvData(j, str, z, z3);
                } else {
                    AppMethodBeat.m2505o(72721);
                }
            }
        }
        if (pWV) {
            C7063j.cgu().mo15423t(j, str);
        }
        AppMethodBeat.m2505o(72721);
    }

    /* renamed from: a */
    public static void m6057a(long j, long j2, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(72722);
        if (z2) {
            try {
                SmcLogic.writeImportKvDataWithType(j, j2, str, z, z3);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.KVEasyReport", "localReport :%s", C5046bo.m7574l(e));
            }
        } else {
            try {
                SmcLogic.writeKvDataWithType(j, j2, str, z, z3);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (C1443d.m3067fP(20)) {
                    SmcLogic.writeKvDataWithType(j, j2, str, z, z3);
                } else {
                    AppMethodBeat.m2505o(72722);
                }
            }
        }
        if (pWV) {
            C7063j.cgu().mo15423t(j, str);
        }
        AppMethodBeat.m2505o(72722);
    }

    /* renamed from: a */
    public static void m6059a(long j, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.m2504i(72723);
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j, bArr, z);
                AppMethodBeat.m2505o(72723);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.KVEasyReport", "localReport :%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(72723);
                return;
            }
        }
        SmcLogic.writeKvPbData(j, bArr, z);
        AppMethodBeat.m2505o(72723);
    }

    /* renamed from: b */
    public static void m6060b(long j, long j2, long j3, boolean z) {
        AppMethodBeat.m2504i(72724);
        long j4 = j;
        do {
            int i;
            String str = "MicroMsg.KVEasyReport";
            String str2 = "SmcLogic.reportIDKey class loader %s, %s ";
            Object[] objArr = new Object[2];
            if (C3744e.class.getClassLoader() == null) {
                i = -1;
            } else {
                i = C3744e.class.getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            C4990ab.m7417i(str, str2, objArr);
            try {
                SmcLogic.reportIDKey(j4, j2, j3, z);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (C1443d.m3067fP(20)) {
                    SmcLogic.reportIDKey(j4, j2, j3, z);
                } else {
                    AppMethodBeat.m2505o(72724);
                }
            }
            if (!pXW) {
                break;
            }
            if (pXT == null) {
                C3744e.cgp();
            }
            j4 = C5046bo.m7514a((Long) pXT.get(Long.valueOf(j4)), 0);
        } while (j4 > 0);
        AppMethodBeat.m2505o(72724);
    }

    /* renamed from: d */
    public static void m6061d(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.m2504i(72725);
        if (arrayList != null) {
            try {
                SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                AppMethodBeat.m2505o(72725);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (C1443d.m3067fP(20)) {
                    SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                    AppMethodBeat.m2505o(72725);
                    return;
                }
                AppMethodBeat.m2505o(72725);
            }
        } else {
            AppMethodBeat.m2505o(72725);
        }
    }

    /* renamed from: ki */
    public static void m6063ki(boolean z) {
        AppMethodBeat.m2504i(72726);
        C4990ab.m7417i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", Boolean.valueOf(pXW), Boolean.valueOf(z), C5046bo.dpG());
        pXW = z;
        AppMethodBeat.m2505o(72726);
    }

    public static synchronized void cgp() {
        synchronized (C3744e.class) {
            AppMethodBeat.m2504i(72727);
            if (pXT == null) {
                pXT = new HashMap(20);
            }
            ate cgh = C3732a.cgh();
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
            C4990ab.m7417i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", Integer.valueOf(pXV), Integer.valueOf(pXT.size()), pXT, C5046bo.dpG());
            AppMethodBeat.m2505o(72727);
        }
    }

    /* renamed from: kh */
    public static void m6062kh(boolean z) {
        pWV = z;
    }
}
