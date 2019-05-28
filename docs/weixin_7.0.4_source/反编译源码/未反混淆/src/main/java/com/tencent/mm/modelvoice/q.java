package com.tencent.mm.modelvoice;

import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.d;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class q {
    private static final HashMap<String, WeakReference<j>> gaj = new HashMap();
    public static volatile HashMap<String, Integer> gak = new HashMap();
    public static volatile HashMap<String, Integer> gal = new HashMap();
    public static volatile HashMap<String, Integer> gam = new HashMap();

    static {
        AppMethodBeat.i(116651);
        AppMethodBeat.o(116651);
    }

    public static boolean uM(String str) {
        AppMethodBeat.i(116614);
        if (str == null) {
            AppMethodBeat.o(116614);
            return false;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116614);
            return false;
        } else if (uZ.fXf >= 250) {
            AppMethodBeat.o(116614);
            return false;
        } else {
            uZ.fXf++;
            uZ.bJt = Utility.DEFAULT_STREAM_BUFFER_SIZE;
            boolean a = a(uZ);
            AppMethodBeat.o(116614);
            return a;
        }
    }

    public static int mt(int i) {
        return ((i - 6) / 32) * 20;
    }

    public static b aY(String str, String str2) {
        AppMethodBeat.i(116615);
        u ama = m.ama();
        String fullPath = getFullPath(str2);
        b bVar;
        switch (bo.getInt(str, -1)) {
            case 1:
                if (ama.gaw.get(fullPath) == null) {
                    ama.gaw.put(fullPath, new l(fullPath));
                }
                bVar = (b) ama.gaw.get(fullPath);
                AppMethodBeat.o(116615);
                return bVar;
            case 4:
                if (ama.gax.get(fullPath) == null) {
                    ama.gax.put(fullPath, new h(fullPath));
                }
                bVar = (b) ama.gax.get(fullPath);
                AppMethodBeat.o(116615);
                return bVar;
            default:
                if (ama.gav.get(fullPath) == null) {
                    ama.gav.put(fullPath, new a(fullPath));
                }
                bVar = (b) ama.gav.get(fullPath);
                AppMethodBeat.o(116615);
                return bVar;
        }
    }

    public static b uN(String str) {
        AppMethodBeat.i(116616);
        u ama = m.ama();
        String fullPath = getFullPath(str);
        b bVar;
        switch (o.uK(str)) {
            case 0:
                if (ama.gav.get(fullPath) == null) {
                    ama.gav.put(fullPath, new a(fullPath));
                }
                bVar = (b) ama.gav.get(fullPath);
                AppMethodBeat.o(116616);
                return bVar;
            case 1:
                if (ama.gaw.get(fullPath) == null) {
                    ama.gaw.put(fullPath, new l(fullPath));
                }
                bVar = (b) ama.gaw.get(fullPath);
                AppMethodBeat.o(116616);
                return bVar;
            case 2:
                if (ama.gax.get(fullPath) == null) {
                    ama.gax.put(fullPath, new h(fullPath));
                }
                bVar = (b) ama.gax.get(fullPath);
                AppMethodBeat.o(116616);
                return bVar;
            default:
                if (ama.gav.get(fullPath) == null) {
                    ama.gav.put(fullPath, new a(fullPath));
                }
                bVar = (b) ama.gav.get(fullPath);
                AppMethodBeat.o(116616);
                return bVar;
        }
    }

    private static void uO(String str) {
        AppMethodBeat.i(116617);
        u ama = m.ama();
        String fullPath = getFullPath(str);
        a aVar;
        switch (o.uK(str)) {
            case 0:
                aVar = (a) ama.gav.get(fullPath);
                if (aVar != null) {
                    aVar.alO();
                    ama.gav.remove(fullPath);
                }
                AppMethodBeat.o(116617);
                return;
            case 1:
                l lVar = (l) ama.gaw.get(fullPath);
                if (lVar != null) {
                    lVar.alO();
                    ama.gaw.remove(fullPath);
                }
                AppMethodBeat.o(116617);
                return;
            case 2:
                h hVar = (h) ama.gax.get(fullPath);
                if (hVar != null) {
                    hVar.alO();
                    ama.gax.remove(fullPath);
                }
                AppMethodBeat.o(116617);
                return;
            default:
                aVar = (a) ama.gav.get(fullPath);
                if (aVar != null) {
                    aVar.alO();
                    ama.gav.remove(fullPath);
                }
                AppMethodBeat.o(116617);
                return;
        }
    }

    public static String getFullPath(String str) {
        AppMethodBeat.i(116618);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116618);
            return null;
        }
        String U = U(str, false);
        AppMethodBeat.o(116618);
        return U;
    }

    public static String U(String str, boolean z) {
        AppMethodBeat.i(116619);
        a aVar = new a();
        String b = com.tencent.mm.sdk.platformtools.j.b(XY(), "msg_", str, ".amr", 2);
        ab.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.Mr() + " " + b);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(116619);
            return null;
        } else if (z) {
            AppMethodBeat.o(116619);
            return b;
        } else if (new b(b).exists()) {
            AppMethodBeat.o(116619);
            return b;
        } else {
            String str2 = amg() + str;
            if (new b(str2 + ".amr").exists()) {
                e.aQ(str2 + ".amr", b);
            } else if (new b(str2).exists()) {
                e.aQ(str2, b);
            }
            AppMethodBeat.o(116619);
            return b;
        }
    }

    public static String uP(String str) {
        AppMethodBeat.i(116620);
        String uY = u.uY(r.Yz());
        p pVar = new p();
        pVar.fileName = uY;
        pVar.cIS = str;
        pVar.createTime = System.currentTimeMillis() / 1000;
        pVar.clientId = uY;
        pVar.fXb = System.currentTimeMillis() / 1000;
        pVar.status = 1;
        pVar.fWW = r.Yz();
        pVar.bJt = -1;
        if (m.ama().b(pVar)) {
            ab.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
            AppMethodBeat.o(116620);
            return uY;
        }
        AppMethodBeat.o(116620);
        return null;
    }

    public static boolean a(String str, j jVar) {
        AppMethodBeat.i(116621);
        if (str == null) {
            AppMethodBeat.o(116621);
            return false;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            ab.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(str)));
            AppMethodBeat.o(116621);
            return false;
        } else if (uZ.status != 1) {
            AppMethodBeat.o(116621);
            return false;
        } else {
            uZ.status = 2;
            uZ.bJt = 64;
            synchronized (gaj) {
                try {
                    gaj.put(str, new WeakReference(jVar));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(116621);
                }
            }
            boolean a = a(uZ);
            return a;
        }
    }

    public static boolean uQ(String str) {
        AppMethodBeat.i(116622);
        if (str == null) {
            AppMethodBeat.o(116622);
            return false;
        }
        ab.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116622);
            return false;
        }
        uZ.status = 8;
        uZ.frO = o.uj(str);
        uZ.bJt = 96;
        boolean a = a(uZ);
        AppMethodBeat.o(116622);
        return a;
    }

    public static boolean uR(String str) {
        AppMethodBeat.i(116623);
        if (str == null) {
            AppMethodBeat.o(116623);
            return false;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            ab.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(str)));
            AppMethodBeat.o(116623);
            return true;
        }
        ab.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + uZ.cKK);
        if (uZ.cKK != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().aa(uZ.cIS, uZ.cKK);
        }
        boolean uT = uT(str);
        AppMethodBeat.o(116623);
        return uT;
    }

    public static boolean uS(String str) {
        AppMethodBeat.i(116624);
        if (str == null) {
            AppMethodBeat.o(116624);
            return false;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            ab.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(str)));
            AppMethodBeat.o(116624);
            return true;
        }
        ab.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + uZ.fXe);
        if (uZ.fXe != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jg((long) uZ.fXe);
        }
        boolean uT = uT(str);
        AppMethodBeat.o(116624);
        return uT;
    }

    public static boolean uT(String str) {
        AppMethodBeat.i(116625);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116625);
            return false;
        }
        m.ama().pI(str);
        uO(str);
        boolean delete = new b(getFullPath(str)).delete();
        AppMethodBeat.o(116625);
        return delete;
    }

    public static boolean ah(String str, int i) {
        AppMethodBeat.i(116626);
        boolean o = o(str, i, 0);
        AppMethodBeat.o(116626);
        return o;
    }

    private static boolean o(String str, int i, int i2) {
        boolean z = false;
        AppMethodBeat.i(116627);
        if (str == null) {
            AppMethodBeat.o(116627);
        } else {
            ab.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + getFullPath(str) + "]");
            p uZ = m.ama().uZ(str);
            if (uZ == null) {
                AppMethodBeat.o(116627);
            } else {
                if (!(uZ.status == 97 || uZ.status == 98)) {
                    uZ.status = 3;
                }
                uZ.frO = o.uj(str);
                if (uZ.frO <= 0) {
                    um(str);
                    AppMethodBeat.o(116627);
                } else {
                    uZ.fXb = System.currentTimeMillis() / 1000;
                    uZ.gaf = i;
                    uZ.bJt = 3424;
                    bi biVar = new bi();
                    biVar.ju(uZ.cIS);
                    biVar.setType(34);
                    biVar.hO(1);
                    biVar.jv(str);
                    if (uZ.status == 97) {
                        biVar.setStatus(2);
                        biVar.setContent(n.d(uZ.fWW, (long) uZ.gaf, false));
                    } else if (uZ.status == 98) {
                        biVar.setStatus(5);
                        biVar.setContent(n.d(uZ.fWW, -1, true));
                    } else {
                        biVar.setStatus(1);
                        biVar.setContent(n.d(uZ.fWW, (long) uZ.gaf, false));
                    }
                    biVar.eJ(bf.oC(uZ.cIS));
                    biVar.Mr(i2);
                    com.tencent.mm.l.a.a.KG().g(biVar);
                    uZ.fXe = (int) bf.l(biVar);
                    z = a(uZ);
                    synchronized (gaj) {
                        try {
                            gaj.remove(str);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(116627);
                        }
                    }
                }
            }
        }
        return z;
    }

    public static int a(String str, int i, long j, String str2, int i2, int i3) {
        AppMethodBeat.i(116628);
        if (str == null) {
            AppMethodBeat.o(116628);
            return -1;
        }
        ab.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i + " SvrID:" + j + " clientID:" + str2 + " hasSendEndFlag " + i2);
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116628);
            return -1;
        }
        uZ.fVG = i;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
        if (bo.isNullOrNil(uZ.clientId) && str2 != null) {
            uZ.clientId = str2;
            uZ.bJt |= 512;
        }
        if (uZ.cKK == 0 && j != 0) {
            uZ.cKK = j;
            uZ.bJt |= 4;
        }
        int i4 = 0;
        if (uZ.frO <= i && uZ.status == 3 && i2 == 1) {
            uZ.status = 99;
            uZ.bJt |= 64;
            bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf((long) uZ.fXe);
            jf.ju(uZ.cIS);
            jf.eI(uZ.cKK);
            jf.setStatus(2);
            jf.setContent(n.d(uZ.fWW, (long) uZ.gaf, false));
            jf.Mr(i3);
            Integer num = (Integer) gak.get(getFullPath(str));
            if (num != null) {
                uZ.gai = num.intValue();
                uZ.bJt |= SQLiteGlobal.journalSizeLimit;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a((long) uZ.fXe, jf);
            ab.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + uZ.frO + " status:" + uZ.status + " netTimes:" + uZ.fXf + " msgId:" + jf.field_msgId);
            i4 = 1;
            uO(str);
        }
        if (a(uZ)) {
            AppMethodBeat.o(116628);
            return i4;
        }
        AppMethodBeat.o(116628);
        return -4;
    }

    public static synchronized int b(int i, byte[] bArr, int i2) {
        int i3;
        int i4 = 0;
        synchronized (q.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    i3 = i;
                    while (i4 < i2) {
                        i3 += bArr[i4 + 0];
                        i4++;
                    }
                }
            }
            i3 = 0;
        }
        return i3;
    }

    public static int c(int i, byte[] bArr, int i2) {
        AppMethodBeat.i(116629);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(116629);
        } else {
            int hashCode;
            int i3;
            if (i == 0) {
                hashCode = bArr.hashCode() & 255;
                i3 = hashCode;
                i = hashCode;
            } else {
                i3 = i & 255;
            }
            for (hashCode = 0; hashCode < i2; hashCode++) {
                i += (bArr[hashCode + 0] & i3) * 256;
            }
            AppMethodBeat.o(116629);
        }
        return i;
    }

    public static int a(p pVar, byte[] bArr, int i, String str, String str2, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(116632);
        a aVar2 = new a();
        p fZ = m.ama().fZ(pVar.cKK);
        if (fZ != null && fZ.status == 99) {
            AppMethodBeat.o(116632);
            return 0;
        } else if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Q(pVar.cIS, pVar.cKK).field_msgSvrId == pVar.cKK && fZ == null) {
            AppMethodBeat.o(116632);
            return 0;
        } else {
            if (fZ != null) {
                pVar.fileName = fZ.fileName;
            } else {
                pVar.fileName = u.uY(pVar.fWW);
            }
            pVar.bJt |= 1;
            ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Mq() + "checktime :" + aVar2.Mr());
            boolean z = false;
            if (bArr != null && bArr.length > 1) {
                boolean z2;
                if (fZ != null) {
                    ab.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
                }
                String str3 = pVar.fYX;
                String str4 = pVar.fileName;
                int write = aY(str3, str4).write(bArr, bArr.length, 0);
                if (write < 0) {
                    ab.e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                    z2 = false;
                } else if (bArr.length != write) {
                    ab.e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                    z2 = false;
                } else {
                    ab.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                    uO(str4);
                    z2 = true;
                }
                pVar.gai = c(pVar.gai, bArr, bArr.length);
                pVar.bJt |= SQLiteGlobal.journalSizeLimit;
                z = z2;
            }
            ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Mq() + "checktime :" + aVar2.Mr());
            pVar.fXb = System.currentTimeMillis() / 1000;
            pVar.bJt |= 256;
            if (z) {
                pVar.status = 99;
            } else if (pVar.frO == 0) {
                pVar.status = 5;
            } else {
                pVar.status = 6;
            }
            pVar.bJt |= 64;
            if (fZ == null) {
                if (z) {
                    pVar.fXe = (int) a(pVar, z, i, str, str2, aVar);
                }
                if (aVar != null) {
                    pVar.dqI = bf.d(aVar);
                    if (aVar.eAB != null) {
                        pVar.gag = aVar.eAB.vEI;
                    }
                }
                ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Mq() + "checktime :" + aVar2.Mr());
                pVar.bJt = -1;
                ab.d("MicroMsg.VoiceLogic", "Insert fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.fVG + " total:" + pVar.frO);
                if (m.ama().b(pVar)) {
                    ab.d("MicroMsg.VoiceLogic", com.tencent.mm.compatible.util.g.Mq() + "checktime :" + aVar2.Mr());
                    if (z) {
                        AppMethodBeat.o(116632);
                        return 1;
                    }
                }
                ab.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + pVar.fileName + " stat:" + pVar.status + " net:" + pVar.fVG + " total:" + pVar.frO);
                AppMethodBeat.o(116632);
                return -2;
            }
            ab.d("MicroMsg.VoiceLogic", "Sync Update file:" + pVar.fileName + " stat:" + pVar.status);
            if (!a(pVar)) {
                AppMethodBeat.o(116632);
                return -44;
            } else if (z) {
                a(pVar, aVar);
                AppMethodBeat.o(116632);
                return 1;
            }
            if (fZ != null && fZ.fWY == pVar.frO) {
                a(fZ.fileName, fZ.fWY, aVar);
                ab.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + fZ.fileName);
            }
            ab.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", aVar, Boolean.valueOf(z), bo.dpG());
            m.amc().run();
            AppMethodBeat.o(116632);
            return 0;
        }
    }

    private static boolean a(p pVar, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(116633);
        try {
            pVar.fXe = (int) a(pVar, true, 3, "", pVar.dqJ, aVar);
            pVar.bJt |= 2048;
            boolean a = a(pVar);
            AppMethodBeat.o(116633);
            return a;
        } catch (Exception e) {
            ab.e("MicroMsg.VoiceLogic", "exception:%s", bo.l(e));
            AppMethodBeat.o(116633);
            return false;
        }
    }

    private static long a(p pVar, boolean z, int i, String str, String str2, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(116634);
        if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jh(pVar.cKK)) {
            ab.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar.cKK));
            if (bo.nullAsNil(pVar.fileName).length() > 0) {
                m.ama().pI(pVar.fileName);
            } else {
                ab.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            AppMethodBeat.o(116634);
            return -1;
        }
        bi biVar = new bi();
        biVar.eI(pVar.cKK);
        biVar.jv(pVar.fileName);
        biVar.eJ(bf.q(pVar.cIS, pVar.createTime));
        biVar.ju(pVar.cIS);
        biVar.hO(r.mG(pVar.fWW) ? 1 : 0);
        biVar.setType(34);
        biVar.jz(str);
        biVar.Mr(pVar.fZe);
        biVar.setStatus(i);
        if (aVar == null) {
            int i2 = pVar.dqI;
            if (i2 != 0) {
                ab.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i2));
                biVar.hY(i2);
                if (biVar.field_msgId == 0 && biVar.field_isSend == 0 && (i2 & 2) != 0) {
                    biVar.eJ(bf.g(biVar.field_talker, pVar.createTime, biVar.field_msgSeq));
                }
            }
            if (pVar.gag != 0) {
                biVar.eL((long) pVar.gag);
            }
            ab.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(pVar.gag));
        } else {
            bf.a(biVar, aVar);
        }
        ab.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!bo.isNullOrNil(str2)) {
            biVar.ix(str2);
            biVar.jA(bf.oF(str2));
        }
        if (z) {
            biVar.setContent(n.d(pVar.fWW, (long) pVar.gaf, false));
        } else {
            biVar.setContent(n.d(pVar.fWW, 0, false));
        }
        if (!bo.isNullOrNil(str2)) {
            biVar.ix(str2);
            biVar.jA(bf.oF(str2));
            bf.b oE = bf.oE(str2);
            if (oE != null) {
                biVar.jA(oE.fmu);
                biVar.jy(oE.fmt);
                ab.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", oE.fmt);
                if (oE.fmx != null) {
                    jf jfVar = new jf();
                    jfVar.cEs.csG = biVar;
                    jfVar.cEs.cEt = oE;
                    com.tencent.mm.sdk.b.a.xxA.m(jfVar);
                }
            }
        }
        ab.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(biVar.field_msgSvrId), Long.valueOf(biVar.field_msgSeq));
        long l = bf.l(biVar);
        AppMethodBeat.o(116634);
        return l;
    }

    public static int a(String str, int i, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(116635);
        if (str == null) {
            AppMethodBeat.o(116635);
            return -1;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116635);
            return -1;
        }
        uZ.fWY = i;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = 272;
        int i2 = 0;
        if (uZ.frO > 0 && i >= uZ.frO) {
            a(uZ, aVar);
            uZ.status = 99;
            uZ.bJt |= 64;
            ab.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + uZ.frO + " status:" + uZ.status + " netTimes:" + uZ.fXf);
            i2 = 1;
            uO(str);
        }
        ab.d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + uZ.frO + " status:" + uZ.status);
        if (a(uZ)) {
            AppMethodBeat.o(116635);
            return i2;
        }
        AppMethodBeat.o(116635);
        return -3;
    }

    public static boolean mu(int i) {
        AppMethodBeat.i(116637);
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf((long) i);
        if (jf.field_msgId == 0 || jf.field_imgPath == null) {
            AppMethodBeat.o(116637);
            return false;
        } else if (bo.isNullOrNil(jf.field_imgPath)) {
            AppMethodBeat.o(116637);
            return false;
        } else {
            p uZ = m.ama().uZ(jf.field_imgPath);
            if (uZ == null || bo.isNullOrNil(uZ.fileName)) {
                AppMethodBeat.o(116637);
                return false;
            }
            uZ.status = 3;
            uZ.fVG = 0;
            uZ.createTime = System.currentTimeMillis() / 1000;
            uZ.fXb = System.currentTimeMillis() / 1000;
            uZ.bJt = 8648;
            boolean a = a(uZ);
            ab.d("MicroMsg.VoiceLogic", " file:" + uZ.fileName + " msgid:" + uZ.fXe + "  stat:" + uZ.status);
            if (uZ.fXe == 0 || bo.isNullOrNil(uZ.cIS)) {
                ab.e("MicroMsg.VoiceLogic", " failed msg id:" + uZ.fXe + " user:" + uZ.cIS);
                AppMethodBeat.o(116637);
                return a;
            }
            jf.setStatus(1);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(jf.field_msgId, jf);
            m.amc().run();
            AppMethodBeat.o(116637);
            return true;
        }
    }

    public static String f(String str, String str2, int i) {
        AppMethodBeat.i(116638);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116638);
            return null;
        }
        if (!(bo.isNullOrNil(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String uP = uP(str);
        if (bo.isNullOrNil(uP)) {
            AppMethodBeat.o(116638);
            return null;
        } else if (e.y(getFullPath(str2), getFullPath(uP)) < 0) {
            AppMethodBeat.o(116638);
            return null;
        } else {
            o(uP, i, 1);
            AppMethodBeat.o(116638);
            return uP;
        }
    }

    public static boolean um(String str) {
        AppMethodBeat.i(116639);
        h.pYm.a(111, 234, 1, false);
        if (str == null) {
            AppMethodBeat.o(116639);
            return false;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            ab.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(str)));
            AppMethodBeat.o(116639);
            return false;
        }
        uZ.status = 98;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = 320;
        boolean a = a(uZ);
        ab.d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + uZ.fXe + " old stat:" + uZ.status);
        if (uZ.fXe == 0 || bo.isNullOrNil(uZ.cIS)) {
            ab.e("MicroMsg.VoiceLogic", "setError failed msg id:" + uZ.fXe + " user:" + uZ.cIS);
            AppMethodBeat.o(116639);
            return a;
        }
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf((long) uZ.fXe);
        com.tencent.mm.plugin.report.e.pXa.a(111, 33, 1, true);
        jf.setMsgId((long) uZ.fXe);
        jf.setStatus(5);
        jf.ju(uZ.cIS);
        jf.setContent(n.d(uZ.fWW, -1, true));
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(jf.field_msgId, jf);
        AppMethodBeat.o(116639);
        return a;
    }

    public static bi uV(String str) {
        AppMethodBeat.i(116640);
        if (str == null) {
            AppMethodBeat.o(116640);
            return null;
        }
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116640);
            return null;
        }
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf((long) uZ.fXe);
        AppMethodBeat.o(116640);
        return jf;
    }

    public static p uW(String str) {
        AppMethodBeat.i(139161);
        p uZ = m.ama().uZ(str);
        AppMethodBeat.o(139161);
        return uZ;
    }

    public static List<p> amf() {
        List<p> list = null;
        AppMethodBeat.i(116642);
        u ama = m.ama();
        Cursor a = ama.fni.a(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i = 0;
        if (a.moveToFirst()) {
            list = new ArrayList();
            do {
                p pVar = new p();
                pVar.d(a);
                list.add(pVar);
                i++;
            } while (a.moveToNext());
        }
        ab.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(i)));
        a.close();
        AppMethodBeat.o(116642);
        return list;
    }

    private static boolean a(p pVar) {
        AppMethodBeat.i(116643);
        if (pVar == null) {
            AppMethodBeat.o(116643);
            return false;
        } else if (pVar.bJt == -1) {
            AppMethodBeat.o(116643);
            return false;
        } else {
            boolean a = m.ama().a(pVar.fileName, pVar);
            AppMethodBeat.o(116643);
            return a;
        }
    }

    public static float fY(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        AppMethodBeat.i(116644);
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.o(116644);
        return f;
    }

    public static boolean K(bi biVar) {
        AppMethodBeat.i(116645);
        if (biVar == null || !biVar.drD()) {
            AppMethodBeat.o(116645);
            return false;
        }
        boolean z = new n(biVar.field_content).fWX;
        AppMethodBeat.o(116645);
        return z;
    }

    public static boolean L(bi biVar) {
        AppMethodBeat.i(116646);
        if (biVar == null || !biVar.drD() || biVar.field_isSend == 1) {
            AppMethodBeat.o(116646);
            return false;
        } else if (new n(biVar.field_content).time == 0) {
            AppMethodBeat.o(116646);
            return true;
        } else {
            AppMethodBeat.o(116646);
            return false;
        }
    }

    public static void M(bi biVar) {
        AppMethodBeat.i(116647);
        if (biVar == null || !biVar.drD()) {
            AppMethodBeat.o(116647);
            return;
        }
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(biVar.field_msgId);
        if (jf.field_msgId != biVar.field_msgId) {
            AppMethodBeat.o(116647);
            return;
        }
        n nVar = new n(jf.field_content);
        if (nVar.fWX) {
            AppMethodBeat.o(116647);
            return;
        }
        int i;
        nVar.fWX = true;
        StringBuilder append = new StringBuilder().append(nVar.fWW).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(nVar.time).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (nVar.fWX) {
            i = 1;
        } else {
            i = 0;
        }
        biVar.setContent(append.append(i).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(biVar.field_msgId, biVar);
        AppMethodBeat.o(116647);
    }

    public static int uX(String str) {
        int EV;
        AppMethodBeat.i(116648);
        synchronized (gaj) {
            try {
                if (gaj.get(str) != null) {
                    j jVar = (j) ((WeakReference) gaj.get(str)).get();
                    if (jVar != null) {
                        EV = (int) jVar.EV();
                    }
                }
                AppMethodBeat.o(116648);
                return -1;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(116648);
            }
        }
        return EV;
    }

    public static String amg() {
        AppMethodBeat.i(116649);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("voice/").toString();
        AppMethodBeat.o(116649);
        return stringBuilder2;
    }

    public static String XY() {
        AppMethodBeat.i(116650);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("voice2/").toString();
        AppMethodBeat.o(116650);
        return stringBuilder2;
    }

    public static int c(String str, byte[] bArr, int i) {
        AppMethodBeat.i(116630);
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116630);
            return -1;
        }
        uZ.gai = c(uZ.gai, bArr, i);
        uZ.bJt |= SQLiteGlobal.journalSizeLimit;
        if (a(uZ)) {
            int i2 = uZ.gai;
            AppMethodBeat.o(116630);
            return i2;
        }
        AppMethodBeat.o(116630);
        return 0;
    }

    public static boolean uU(String str) {
        AppMethodBeat.i(116631);
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116631);
            return true;
        }
        b bVar = new b(getFullPath(str));
        b uN = uN(str);
        if (uN != null && (uN instanceof a) && Math.abs(bVar.length() - ((long) uZ.frO)) == 6) {
            ab.i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", Long.valueOf(bVar.length()), Integer.valueOf(uZ.frO));
            AppMethodBeat.o(116631);
            return true;
        } else if (bVar.length() != ((long) uZ.frO)) {
            ab.e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", Long.valueOf(bVar.length()), Integer.valueOf(uZ.frO));
            AppMethodBeat.o(116631);
            return false;
        } else {
            g cF = uN.cF(0, uZ.frO);
            if (cF.ret != 0 || uZ.gai == 0 || uZ.gai == c(uZ.gai & 255, cF.buf, cF.cqs)) {
                AppMethodBeat.o(116631);
                return true;
            }
            ab.e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", Integer.valueOf(uZ.gai));
            AppMethodBeat.o(116631);
            return false;
        }
    }

    public static boolean un(String str) {
        AppMethodBeat.i(116636);
        p uZ = m.ama().uZ(str);
        if (uZ == null) {
            AppMethodBeat.o(116636);
            return false;
        }
        if (uZ.status == 3) {
            bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf((long) uZ.fXe);
            jf.setContent(n.d(uZ.fWW, (long) uZ.gaf, false));
            jf.setStatus(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a((long) uZ.fXe, jf);
        }
        uZ.status = 97;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = 320;
        boolean a = a(uZ);
        AppMethodBeat.o(116636);
        return a;
    }
}
