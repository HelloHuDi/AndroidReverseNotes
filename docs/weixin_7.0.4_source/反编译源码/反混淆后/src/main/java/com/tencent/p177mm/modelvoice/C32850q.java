package com.tencent.p177mm.modelvoice;

import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C41737j;
import com.tencent.p177mm.p230g.p231a.C9388jf;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoice.q */
public final class C32850q {
    private static final HashMap<String, WeakReference<C41737j>> gaj = new HashMap();
    public static volatile HashMap<String, Integer> gak = new HashMap();
    public static volatile HashMap<String, Integer> gal = new HashMap();
    public static volatile HashMap<String, Integer> gam = new HashMap();

    static {
        AppMethodBeat.m2504i(116651);
        AppMethodBeat.m2505o(116651);
    }

    /* renamed from: uM */
    public static boolean m53726uM(String str) {
        AppMethodBeat.m2504i(116614);
        if (str == null) {
            AppMethodBeat.m2505o(116614);
            return false;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116614);
            return false;
        } else if (uZ.fXf >= 250) {
            AppMethodBeat.m2505o(116614);
            return false;
        } else {
            uZ.fXf++;
            uZ.bJt = Utility.DEFAULT_STREAM_BUFFER_SIZE;
            boolean a = C32850q.m53713a(uZ);
            AppMethodBeat.m2505o(116614);
            return a;
        }
    }

    /* renamed from: mt */
    public static int m53723mt(int i) {
        return ((i - 6) / 32) * 20;
    }

    /* renamed from: aY */
    public static C26497b m53716aY(String str, String str2) {
        AppMethodBeat.m2504i(116615);
        C18719u ama = C26500m.ama();
        String fullPath = C32850q.getFullPath(str2);
        C26497b c26497b;
        switch (C5046bo.getInt(str, -1)) {
            case 1:
                if (ama.gaw.get(fullPath) == null) {
                    ama.gaw.put(fullPath, new C1884l(fullPath));
                }
                c26497b = (C26497b) ama.gaw.get(fullPath);
                AppMethodBeat.m2505o(116615);
                return c26497b;
            case 4:
                if (ama.gax.get(fullPath) == null) {
                    ama.gax.put(fullPath, new C45462h(fullPath));
                }
                c26497b = (C26497b) ama.gax.get(fullPath);
                AppMethodBeat.m2505o(116615);
                return c26497b;
            default:
                if (ama.gav.get(fullPath) == null) {
                    ama.gav.put(fullPath, new C31277a(fullPath));
                }
                c26497b = (C26497b) ama.gav.get(fullPath);
                AppMethodBeat.m2505o(116615);
                return c26497b;
        }
    }

    /* renamed from: uN */
    public static C26497b m53727uN(String str) {
        AppMethodBeat.m2504i(116616);
        C18719u ama = C26500m.ama();
        String fullPath = C32850q.getFullPath(str);
        C26497b c26497b;
        switch (C32848o.m53699uK(str)) {
            case 0:
                if (ama.gav.get(fullPath) == null) {
                    ama.gav.put(fullPath, new C31277a(fullPath));
                }
                c26497b = (C26497b) ama.gav.get(fullPath);
                AppMethodBeat.m2505o(116616);
                return c26497b;
            case 1:
                if (ama.gaw.get(fullPath) == null) {
                    ama.gaw.put(fullPath, new C1884l(fullPath));
                }
                c26497b = (C26497b) ama.gaw.get(fullPath);
                AppMethodBeat.m2505o(116616);
                return c26497b;
            case 2:
                if (ama.gax.get(fullPath) == null) {
                    ama.gax.put(fullPath, new C45462h(fullPath));
                }
                c26497b = (C26497b) ama.gax.get(fullPath);
                AppMethodBeat.m2505o(116616);
                return c26497b;
            default:
                if (ama.gav.get(fullPath) == null) {
                    ama.gav.put(fullPath, new C31277a(fullPath));
                }
                c26497b = (C26497b) ama.gav.get(fullPath);
                AppMethodBeat.m2505o(116616);
                return c26497b;
        }
    }

    /* renamed from: uO */
    private static void m53728uO(String str) {
        AppMethodBeat.m2504i(116617);
        C18719u ama = C26500m.ama();
        String fullPath = C32850q.getFullPath(str);
        C31277a c31277a;
        switch (C32848o.m53699uK(str)) {
            case 0:
                c31277a = (C31277a) ama.gav.get(fullPath);
                if (c31277a != null) {
                    c31277a.alO();
                    ama.gav.remove(fullPath);
                }
                AppMethodBeat.m2505o(116617);
                return;
            case 1:
                C1884l c1884l = (C1884l) ama.gaw.get(fullPath);
                if (c1884l != null) {
                    c1884l.alO();
                    ama.gaw.remove(fullPath);
                }
                AppMethodBeat.m2505o(116617);
                return;
            case 2:
                C45462h c45462h = (C45462h) ama.gax.get(fullPath);
                if (c45462h != null) {
                    c45462h.alO();
                    ama.gax.remove(fullPath);
                }
                AppMethodBeat.m2505o(116617);
                return;
            default:
                c31277a = (C31277a) ama.gav.get(fullPath);
                if (c31277a != null) {
                    c31277a.alO();
                    ama.gav.remove(fullPath);
                }
                AppMethodBeat.m2505o(116617);
                return;
        }
    }

    public static String getFullPath(String str) {
        AppMethodBeat.m2504i(116618);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116618);
            return null;
        }
        String U = C32850q.m53707U(str, false);
        AppMethodBeat.m2505o(116618);
        return U;
    }

    /* renamed from: U */
    public static String m53707U(String str, boolean z) {
        AppMethodBeat.m2504i(116619);
        C1446a c1446a = new C1446a();
        String b = C15428j.m23709b(C32850q.m53708XY(), "msg_", str, ".amr", 2);
        C4990ab.m7416i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + c1446a.mo4908Mr() + " " + b);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(116619);
            return null;
        } else if (z) {
            AppMethodBeat.m2505o(116619);
            return b;
        } else if (new C5728b(b).exists()) {
            AppMethodBeat.m2505o(116619);
            return b;
        } else {
            String str2 = C32850q.amg() + str;
            if (new C5728b(str2 + ".amr").exists()) {
                C5730e.m8623aQ(str2 + ".amr", b);
            } else if (new C5728b(str2).exists()) {
                C5730e.m8623aQ(str2, b);
            }
            AppMethodBeat.m2505o(116619);
            return b;
        }
    }

    /* renamed from: uP */
    public static String m53729uP(String str) {
        AppMethodBeat.m2504i(116620);
        String uY = C18719u.m29275uY(C1853r.m3846Yz());
        C32849p c32849p = new C32849p();
        c32849p.fileName = uY;
        c32849p.cIS = str;
        c32849p.createTime = System.currentTimeMillis() / 1000;
        c32849p.clientId = uY;
        c32849p.fXb = System.currentTimeMillis() / 1000;
        c32849p.status = 1;
        c32849p.fWW = C1853r.m3846Yz();
        c32849p.bJt = -1;
        if (C26500m.ama().mo33983b(c32849p)) {
            C4990ab.m7416i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
            AppMethodBeat.m2505o(116620);
            return uY;
        }
        AppMethodBeat.m2505o(116620);
        return null;
    }

    /* renamed from: a */
    public static boolean m53715a(String str, C41737j c41737j) {
        AppMethodBeat.m2504i(116621);
        if (str == null) {
            AppMethodBeat.m2505o(116621);
            return false;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            C4990ab.m7410d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(116621);
            return false;
        } else if (uZ.status != 1) {
            AppMethodBeat.m2505o(116621);
            return false;
        } else {
            uZ.status = 2;
            uZ.bJt = 64;
            synchronized (gaj) {
                try {
                    gaj.put(str, new WeakReference(c41737j));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(116621);
                }
            }
            boolean a = C32850q.m53713a(uZ);
            return a;
        }
    }

    /* renamed from: uQ */
    public static boolean m53730uQ(String str) {
        AppMethodBeat.m2504i(116622);
        if (str == null) {
            AppMethodBeat.m2505o(116622);
            return false;
        }
        C4990ab.m7410d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116622);
            return false;
        }
        uZ.status = 8;
        uZ.frO = C32848o.m53701uj(str);
        uZ.bJt = 96;
        boolean a = C32850q.m53713a(uZ);
        AppMethodBeat.m2505o(116622);
        return a;
    }

    /* renamed from: uR */
    public static boolean m53731uR(String str) {
        AppMethodBeat.m2504i(116623);
        if (str == null) {
            AppMethodBeat.m2505o(116623);
            return false;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            C4990ab.m7410d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(116623);
            return true;
        }
        C4990ab.m7410d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + uZ.cKK);
        if (uZ.cKK != 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15291aa(uZ.cIS, uZ.cKK);
        }
        boolean uT = C32850q.m53733uT(str);
        AppMethodBeat.m2505o(116623);
        return uT;
    }

    /* renamed from: uS */
    public static boolean m53732uS(String str) {
        AppMethodBeat.m2504i(116624);
        if (str == null) {
            AppMethodBeat.m2505o(116624);
            return false;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            C4990ab.m7416i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(116624);
            return true;
        }
        C4990ab.m7416i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + uZ.fXe);
        if (uZ.fXe != 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15341jg((long) uZ.fXe);
        }
        boolean uT = C32850q.m53733uT(str);
        AppMethodBeat.m2505o(116624);
        return uT;
    }

    /* renamed from: uT */
    public static boolean m53733uT(String str) {
        AppMethodBeat.m2504i(116625);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116625);
            return false;
        }
        C26500m.ama().mo33986pI(str);
        C32850q.m53728uO(str);
        boolean delete = new C5728b(C32850q.getFullPath(str)).delete();
        AppMethodBeat.m2505o(116625);
        return delete;
    }

    /* renamed from: ah */
    public static boolean m53717ah(String str, int i) {
        AppMethodBeat.m2504i(116626);
        boolean o = C32850q.m53725o(str, i, 0);
        AppMethodBeat.m2505o(116626);
        return o;
    }

    /* renamed from: o */
    private static boolean m53725o(String str, int i, int i2) {
        boolean z = false;
        AppMethodBeat.m2504i(116627);
        if (str == null) {
            AppMethodBeat.m2505o(116627);
        } else {
            C4990ab.m7410d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + C32850q.getFullPath(str) + "]");
            C32849p uZ = C26500m.ama().mo33987uZ(str);
            if (uZ == null) {
                AppMethodBeat.m2505o(116627);
            } else {
                if (!(uZ.status == 97 || uZ.status == 98)) {
                    uZ.status = 3;
                }
                uZ.frO = C32848o.m53701uj(str);
                if (uZ.frO <= 0) {
                    C32850q.m53738um(str);
                    AppMethodBeat.m2505o(116627);
                } else {
                    uZ.fXb = System.currentTimeMillis() / 1000;
                    uZ.gaf = i;
                    uZ.bJt = 3424;
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo14794ju(uZ.cIS);
                    c7620bi.setType(34);
                    c7620bi.mo14781hO(1);
                    c7620bi.mo14795jv(str);
                    if (uZ.status == 97) {
                        c7620bi.setStatus(2);
                        c7620bi.setContent(C42230n.m74526d(uZ.fWW, (long) uZ.gaf, false));
                    } else if (uZ.status == 98) {
                        c7620bi.setStatus(5);
                        c7620bi.setContent(C42230n.m74526d(uZ.fWW, -1, true));
                    } else {
                        c7620bi.setStatus(1);
                        c7620bi.setContent(C42230n.m74526d(uZ.fWW, (long) uZ.gaf, false));
                    }
                    c7620bi.mo14775eJ(C1829bf.m3756oC(uZ.cIS));
                    c7620bi.mo17082Mr(i2);
                    C26350a.m41930KG().mo35238g(c7620bi);
                    uZ.fXe = (int) C1829bf.m3752l(c7620bi);
                    z = C32850q.m53713a(uZ);
                    synchronized (gaj) {
                        try {
                            gaj.remove(str);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(116627);
                        }
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static int m53710a(String str, int i, long j, String str2, int i2, int i3) {
        AppMethodBeat.m2504i(116628);
        if (str == null) {
            AppMethodBeat.m2505o(116628);
            return -1;
        }
        C4990ab.m7410d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i + " SvrID:" + j + " clientID:" + str2 + " hasSendEndFlag " + i2);
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116628);
            return -1;
        }
        uZ.fVG = i;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
        if (C5046bo.isNullOrNil(uZ.clientId) && str2 != null) {
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
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) uZ.fXe);
            jf.mo14794ju(uZ.cIS);
            jf.mo14774eI(uZ.cKK);
            jf.setStatus(2);
            jf.setContent(C42230n.m74526d(uZ.fWW, (long) uZ.gaf, false));
            jf.mo17082Mr(i3);
            Integer num = (Integer) gak.get(C32850q.getFullPath(str));
            if (num != null) {
                uZ.gai = num.intValue();
                uZ.bJt |= SQLiteGlobal.journalSizeLimit;
            }
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) uZ.fXe, jf);
            C4990ab.m7410d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + uZ.frO + " status:" + uZ.status + " netTimes:" + uZ.fXf + " msgId:" + jf.field_msgId);
            i4 = 1;
            C32850q.m53728uO(str);
        }
        if (C32850q.m53713a(uZ)) {
            AppMethodBeat.m2505o(116628);
            return i4;
        }
        AppMethodBeat.m2505o(116628);
        return -4;
    }

    /* renamed from: b */
    public static synchronized int m53718b(int i, byte[] bArr, int i2) {
        int i3;
        int i4 = 0;
        synchronized (C32850q.class) {
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

    /* renamed from: c */
    public static int m53719c(int i, byte[] bArr, int i2) {
        AppMethodBeat.m2504i(116629);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(116629);
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
            AppMethodBeat.m2505o(116629);
        }
        return i;
    }

    /* renamed from: a */
    public static int m53709a(C32849p c32849p, byte[] bArr, int i, String str, String str2, C1197a c1197a) {
        AppMethodBeat.m2504i(116632);
        C1446a c1446a = new C1446a();
        C32849p fZ = C26500m.ama().mo33984fZ(c32849p.cKK);
        if (fZ != null && fZ.status == 99) {
            AppMethodBeat.m2505o(116632);
            return 0;
        } else if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(c32849p.cIS, c32849p.cKK).field_msgSvrId == c32849p.cKK && fZ == null) {
            AppMethodBeat.m2505o(116632);
            return 0;
        } else {
            if (fZ != null) {
                c32849p.fileName = fZ.fileName;
            } else {
                c32849p.fileName = C18719u.m29275uY(c32849p.fWW);
            }
            c32849p.bJt |= 1;
            C4990ab.m7410d("MicroMsg.VoiceLogic", C1447g.m3075Mq() + "checktime :" + c1446a.mo4908Mr());
            boolean z = false;
            if (bArr != null && bArr.length > 1) {
                boolean z2;
                if (fZ != null) {
                    C4990ab.m7412e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
                }
                String str3 = c32849p.fYX;
                String str4 = c32849p.fileName;
                int write = C32850q.m53716aY(str3, str4).write(bArr, bArr.length, 0);
                if (write < 0) {
                    C4990ab.m7412e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                    z2 = false;
                } else if (bArr.length != write) {
                    C4990ab.m7412e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                    z2 = false;
                } else {
                    C4990ab.m7416i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                    C32850q.m53728uO(str4);
                    z2 = true;
                }
                c32849p.gai = C32850q.m53719c(c32849p.gai, bArr, bArr.length);
                c32849p.bJt |= SQLiteGlobal.journalSizeLimit;
                z = z2;
            }
            C4990ab.m7410d("MicroMsg.VoiceLogic", C1447g.m3075Mq() + "checktime :" + c1446a.mo4908Mr());
            c32849p.fXb = System.currentTimeMillis() / 1000;
            c32849p.bJt |= 256;
            if (z) {
                c32849p.status = 99;
            } else if (c32849p.frO == 0) {
                c32849p.status = 5;
            } else {
                c32849p.status = 6;
            }
            c32849p.bJt |= 64;
            if (fZ == null) {
                if (z) {
                    c32849p.fXe = (int) C32850q.m53712a(c32849p, z, i, str, str2, c1197a);
                }
                if (c1197a != null) {
                    c32849p.dqI = C1829bf.m3747d(c1197a);
                    if (c1197a.eAB != null) {
                        c32849p.gag = c1197a.eAB.vEI;
                    }
                }
                C4990ab.m7410d("MicroMsg.VoiceLogic", C1447g.m3075Mq() + "checktime :" + c1446a.mo4908Mr());
                c32849p.bJt = -1;
                C4990ab.m7410d("MicroMsg.VoiceLogic", "Insert fileName:" + c32849p.fileName + " stat:" + c32849p.status + " net:" + c32849p.fVG + " total:" + c32849p.frO);
                if (C26500m.ama().mo33983b(c32849p)) {
                    C4990ab.m7410d("MicroMsg.VoiceLogic", C1447g.m3075Mq() + "checktime :" + c1446a.mo4908Mr());
                    if (z) {
                        AppMethodBeat.m2505o(116632);
                        return 1;
                    }
                }
                C4990ab.m7410d("MicroMsg.VoiceLogic", "Insert Error fileName:" + c32849p.fileName + " stat:" + c32849p.status + " net:" + c32849p.fVG + " total:" + c32849p.frO);
                AppMethodBeat.m2505o(116632);
                return -2;
            }
            C4990ab.m7410d("MicroMsg.VoiceLogic", "Sync Update file:" + c32849p.fileName + " stat:" + c32849p.status);
            if (!C32850q.m53713a(c32849p)) {
                AppMethodBeat.m2505o(116632);
                return -44;
            } else if (z) {
                C32850q.m53714a(c32849p, c1197a);
                AppMethodBeat.m2505o(116632);
                return 1;
            }
            if (fZ != null && fZ.fWY == c32849p.frO) {
                C32850q.m53711a(fZ.fileName, fZ.fWY, c1197a);
                C4990ab.m7420w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + fZ.fileName);
            }
            C4990ab.m7417i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", c1197a, Boolean.valueOf(z), C5046bo.dpG());
            C26500m.amc().run();
            AppMethodBeat.m2505o(116632);
            return 0;
        }
    }

    /* renamed from: a */
    private static boolean m53714a(C32849p c32849p, C1197a c1197a) {
        AppMethodBeat.m2504i(116633);
        try {
            c32849p.fXe = (int) C32850q.m53712a(c32849p, true, 3, "", c32849p.dqJ, c1197a);
            c32849p.bJt |= 2048;
            boolean a = C32850q.m53713a(c32849p);
            AppMethodBeat.m2505o(116633);
            return a;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.VoiceLogic", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(116633);
            return false;
        }
    }

    /* renamed from: a */
    private static long m53712a(C32849p c32849p, boolean z, int i, String str, String str2, C1197a c1197a) {
        AppMethodBeat.m2504i(116634);
        if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15342jh(c32849p.cKK)) {
            C4990ab.m7417i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(c32849p.cKK));
            if (C5046bo.nullAsNil(c32849p.fileName).length() > 0) {
                C26500m.ama().mo33986pI(c32849p.fileName);
            } else {
                C4990ab.m7416i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            AppMethodBeat.m2505o(116634);
            return -1;
        }
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14774eI(c32849p.cKK);
        c7620bi.mo14795jv(c32849p.fileName);
        c7620bi.mo14775eJ(C1829bf.m3764q(c32849p.cIS, c32849p.createTime));
        c7620bi.mo14794ju(c32849p.cIS);
        c7620bi.mo14781hO(C1853r.m3858mG(c32849p.fWW) ? 1 : 0);
        c7620bi.setType(34);
        c7620bi.mo14799jz(str);
        c7620bi.mo17082Mr(c32849p.fZe);
        c7620bi.setStatus(i);
        if (c1197a == null) {
            int i2 = c32849p.dqI;
            if (i2 != 0) {
                C4990ab.m7417i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i2));
                c7620bi.mo14783hY(i2);
                if (c7620bi.field_msgId == 0 && c7620bi.field_isSend == 0 && (i2 & 2) != 0) {
                    c7620bi.mo14775eJ(C1829bf.m3749g(c7620bi.field_talker, c32849p.createTime, c7620bi.field_msgSeq));
                }
            }
            if (c32849p.gag != 0) {
                c7620bi.mo14777eL((long) c32849p.gag);
            }
            C4990ab.m7417i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(c32849p.gag));
        } else {
            C1829bf.m3743a(c7620bi, c1197a);
        }
        C4990ab.m7417i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!C5046bo.isNullOrNil(str2)) {
            c7620bi.mo14791ix(str2);
            c7620bi.mo14792jA(C1829bf.m3759oF(str2));
        }
        if (z) {
            c7620bi.setContent(C42230n.m74526d(c32849p.fWW, (long) c32849p.gaf, false));
        } else {
            c7620bi.setContent(C42230n.m74526d(c32849p.fWW, 0, false));
        }
        if (!C5046bo.isNullOrNil(str2)) {
            c7620bi.mo14791ix(str2);
            c7620bi.mo14792jA(C1829bf.m3759oF(str2));
            C1828b oE = C1829bf.m3758oE(str2);
            if (oE != null) {
                c7620bi.mo14792jA(oE.fmu);
                c7620bi.mo14798jy(oE.fmt);
                C4990ab.m7417i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", oE.fmt);
                if (oE.fmx != null) {
                    C9388jf c9388jf = new C9388jf();
                    c9388jf.cEs.csG = c7620bi;
                    c9388jf.cEs.cEt = oE;
                    C4879a.xxA.mo10055m(c9388jf);
                }
            }
        }
        C4990ab.m7417i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(c7620bi.field_msgSvrId), Long.valueOf(c7620bi.field_msgSeq));
        long l = C1829bf.m3752l(c7620bi);
        AppMethodBeat.m2505o(116634);
        return l;
    }

    /* renamed from: a */
    public static int m53711a(String str, int i, C1197a c1197a) {
        AppMethodBeat.m2504i(116635);
        if (str == null) {
            AppMethodBeat.m2505o(116635);
            return -1;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116635);
            return -1;
        }
        uZ.fWY = i;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = 272;
        int i2 = 0;
        if (uZ.frO > 0 && i >= uZ.frO) {
            C32850q.m53714a(uZ, c1197a);
            uZ.status = 99;
            uZ.bJt |= 64;
            C4990ab.m7410d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + uZ.frO + " status:" + uZ.status + " netTimes:" + uZ.fXf);
            i2 = 1;
            C32850q.m53728uO(str);
        }
        C4990ab.m7410d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + uZ.frO + " status:" + uZ.status);
        if (C32850q.m53713a(uZ)) {
            AppMethodBeat.m2505o(116635);
            return i2;
        }
        AppMethodBeat.m2505o(116635);
        return -3;
    }

    /* renamed from: mu */
    public static boolean m53724mu(int i) {
        AppMethodBeat.m2504i(116637);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) i);
        if (jf.field_msgId == 0 || jf.field_imgPath == null) {
            AppMethodBeat.m2505o(116637);
            return false;
        } else if (C5046bo.isNullOrNil(jf.field_imgPath)) {
            AppMethodBeat.m2505o(116637);
            return false;
        } else {
            C32849p uZ = C26500m.ama().mo33987uZ(jf.field_imgPath);
            if (uZ == null || C5046bo.isNullOrNil(uZ.fileName)) {
                AppMethodBeat.m2505o(116637);
                return false;
            }
            uZ.status = 3;
            uZ.fVG = 0;
            uZ.createTime = System.currentTimeMillis() / 1000;
            uZ.fXb = System.currentTimeMillis() / 1000;
            uZ.bJt = 8648;
            boolean a = C32850q.m53713a(uZ);
            C4990ab.m7410d("MicroMsg.VoiceLogic", " file:" + uZ.fileName + " msgid:" + uZ.fXe + "  stat:" + uZ.status);
            if (uZ.fXe == 0 || C5046bo.isNullOrNil(uZ.cIS)) {
                C4990ab.m7412e("MicroMsg.VoiceLogic", " failed msg id:" + uZ.fXe + " user:" + uZ.cIS);
                AppMethodBeat.m2505o(116637);
                return a;
            }
            jf.setStatus(1);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
            C26500m.amc().run();
            AppMethodBeat.m2505o(116637);
            return true;
        }
    }

    /* renamed from: f */
    public static String m53721f(String str, String str2, int i) {
        AppMethodBeat.m2504i(116638);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116638);
            return null;
        }
        if (!(C5046bo.isNullOrNil(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String uP = C32850q.m53729uP(str);
        if (C5046bo.isNullOrNil(uP)) {
            AppMethodBeat.m2505o(116638);
            return null;
        } else if (C5730e.m8644y(C32850q.getFullPath(str2), C32850q.getFullPath(uP)) < 0) {
            AppMethodBeat.m2505o(116638);
            return null;
        } else {
            C32850q.m53725o(uP, i, 1);
            AppMethodBeat.m2505o(116638);
            return uP;
        }
    }

    /* renamed from: um */
    public static boolean m53738um(String str) {
        AppMethodBeat.m2504i(116639);
        C7060h.pYm.mo8378a(111, 234, 1, false);
        if (str == null) {
            AppMethodBeat.m2505o(116639);
            return false;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            C4990ab.m7412e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(116639);
            return false;
        }
        uZ.status = 98;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = 320;
        boolean a = C32850q.m53713a(uZ);
        C4990ab.m7410d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + uZ.fXe + " old stat:" + uZ.status);
        if (uZ.fXe == 0 || C5046bo.isNullOrNil(uZ.cIS)) {
            C4990ab.m7412e("MicroMsg.VoiceLogic", "setError failed msg id:" + uZ.fXe + " user:" + uZ.cIS);
            AppMethodBeat.m2505o(116639);
            return a;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) uZ.fXe);
        C7053e.pXa.mo8378a(111, 33, 1, true);
        jf.setMsgId((long) uZ.fXe);
        jf.setStatus(5);
        jf.mo14794ju(uZ.cIS);
        jf.setContent(C42230n.m74526d(uZ.fWW, -1, true));
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
        AppMethodBeat.m2505o(116639);
        return a;
    }

    /* renamed from: uV */
    public static C7620bi m53735uV(String str) {
        AppMethodBeat.m2504i(116640);
        if (str == null) {
            AppMethodBeat.m2505o(116640);
            return null;
        }
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116640);
            return null;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) uZ.fXe);
        AppMethodBeat.m2505o(116640);
        return jf;
    }

    /* renamed from: uW */
    public static C32849p m53736uW(String str) {
        AppMethodBeat.m2504i(139161);
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        AppMethodBeat.m2505o(139161);
        return uZ;
    }

    public static List<C32849p> amf() {
        List<C32849p> list = null;
        AppMethodBeat.m2504i(116642);
        C18719u ama = C26500m.ama();
        Cursor a = ama.fni.mo10104a(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i = 0;
        if (a.moveToFirst()) {
            list = new ArrayList();
            do {
                C32849p c32849p = new C32849p();
                c32849p.mo53420d(a);
                list.add(c32849p);
                i++;
            } while (a.moveToNext());
        }
        C4990ab.m7410d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(i)));
        a.close();
        AppMethodBeat.m2505o(116642);
        return list;
    }

    /* renamed from: a */
    private static boolean m53713a(C32849p c32849p) {
        AppMethodBeat.m2504i(116643);
        if (c32849p == null) {
            AppMethodBeat.m2505o(116643);
            return false;
        } else if (c32849p.bJt == -1) {
            AppMethodBeat.m2505o(116643);
            return false;
        } else {
            boolean a = C26500m.ama().mo33982a(c32849p.fileName, c32849p);
            AppMethodBeat.m2505o(116643);
            return a;
        }
    }

    /* renamed from: fY */
    public static float m53722fY(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        AppMethodBeat.m2504i(116644);
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.m2505o(116644);
        return f;
    }

    /* renamed from: K */
    public static boolean m53704K(C7620bi c7620bi) {
        AppMethodBeat.m2504i(116645);
        if (c7620bi == null || !c7620bi.drD()) {
            AppMethodBeat.m2505o(116645);
            return false;
        }
        boolean z = new C42230n(c7620bi.field_content).fWX;
        AppMethodBeat.m2505o(116645);
        return z;
    }

    /* renamed from: L */
    public static boolean m53705L(C7620bi c7620bi) {
        AppMethodBeat.m2504i(116646);
        if (c7620bi == null || !c7620bi.drD() || c7620bi.field_isSend == 1) {
            AppMethodBeat.m2505o(116646);
            return false;
        } else if (new C42230n(c7620bi.field_content).time == 0) {
            AppMethodBeat.m2505o(116646);
            return true;
        } else {
            AppMethodBeat.m2505o(116646);
            return false;
        }
    }

    /* renamed from: M */
    public static void m53706M(C7620bi c7620bi) {
        AppMethodBeat.m2504i(116647);
        if (c7620bi == null || !c7620bi.drD()) {
            AppMethodBeat.m2505o(116647);
            return;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c7620bi.field_msgId);
        if (jf.field_msgId != c7620bi.field_msgId) {
            AppMethodBeat.m2505o(116647);
            return;
        }
        C42230n c42230n = new C42230n(jf.field_content);
        if (c42230n.fWX) {
            AppMethodBeat.m2505o(116647);
            return;
        }
        int i;
        c42230n.fWX = true;
        StringBuilder append = new StringBuilder().append(c42230n.fWW).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c42230n.time).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (c42230n.fWX) {
            i = 1;
        } else {
            i = 0;
        }
        c7620bi.setContent(append.append(i).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c7620bi.field_msgId, c7620bi);
        AppMethodBeat.m2505o(116647);
    }

    /* renamed from: uX */
    public static int m53737uX(String str) {
        int EV;
        AppMethodBeat.m2504i(116648);
        synchronized (gaj) {
            try {
                if (gaj.get(str) != null) {
                    C41737j c41737j = (C41737j) ((WeakReference) gaj.get(str)).get();
                    if (c41737j != null) {
                        EV = (int) c41737j.mo47619EV();
                    }
                }
                AppMethodBeat.m2505o(116648);
                return -1;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(116648);
            }
        }
        return EV;
    }

    public static String amg() {
        AppMethodBeat.m2504i(116649);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("voice/").toString();
        AppMethodBeat.m2505o(116649);
        return stringBuilder2;
    }

    /* renamed from: XY */
    public static String m53708XY() {
        AppMethodBeat.m2504i(116650);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("voice2/").toString();
        AppMethodBeat.m2505o(116650);
        return stringBuilder2;
    }

    /* renamed from: c */
    public static int m53720c(String str, byte[] bArr, int i) {
        AppMethodBeat.m2504i(116630);
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116630);
            return -1;
        }
        uZ.gai = C32850q.m53719c(uZ.gai, bArr, i);
        uZ.bJt |= SQLiteGlobal.journalSizeLimit;
        if (C32850q.m53713a(uZ)) {
            int i2 = uZ.gai;
            AppMethodBeat.m2505o(116630);
            return i2;
        }
        AppMethodBeat.m2505o(116630);
        return 0;
    }

    /* renamed from: uU */
    public static boolean m53734uU(String str) {
        AppMethodBeat.m2504i(116631);
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116631);
            return true;
        }
        C5728b c5728b = new C5728b(C32850q.getFullPath(str));
        C26497b uN = C32850q.m53727uN(str);
        if (uN != null && (uN instanceof C31277a) && Math.abs(c5728b.length() - ((long) uZ.frO)) == 6) {
            C4990ab.m7417i("MicroMsg.VoiceLogic", "maybe amr, ignore for the moment. %d %d", Long.valueOf(c5728b.length()), Integer.valueOf(uZ.frO));
            AppMethodBeat.m2505o(116631);
            return true;
        } else if (c5728b.length() != ((long) uZ.frO)) {
            C4990ab.m7413e("MicroMsg.VoiceLogic", "checkChecksum fail. %d, %d", Long.valueOf(c5728b.length()), Integer.valueOf(uZ.frO));
            AppMethodBeat.m2505o(116631);
            return false;
        } else {
            C37965g cF = uN.mo5461cF(0, uZ.frO);
            if (cF.ret != 0 || uZ.gai == 0 || uZ.gai == C32850q.m53719c(uZ.gai & 255, cF.buf, cF.cqs)) {
                AppMethodBeat.m2505o(116631);
                return true;
            }
            C4990ab.m7413e("MicroMsg.VoiceLogic", "checkChecksum fail2. %d", Integer.valueOf(uZ.gai));
            AppMethodBeat.m2505o(116631);
            return false;
        }
    }

    /* renamed from: un */
    public static boolean m53739un(String str) {
        AppMethodBeat.m2504i(116636);
        C32849p uZ = C26500m.ama().mo33987uZ(str);
        if (uZ == null) {
            AppMethodBeat.m2505o(116636);
            return false;
        }
        if (uZ.status == 3) {
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) uZ.fXe);
            jf.setContent(C42230n.m74526d(uZ.fWW, (long) uZ.gaf, false));
            jf.setStatus(2);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) uZ.fXe, jf);
        }
        uZ.status = 97;
        uZ.fXb = System.currentTimeMillis() / 1000;
        uZ.bJt = 320;
        boolean a = C32850q.m53713a(uZ);
        AppMethodBeat.m2505o(116636);
        return a;
    }
}
