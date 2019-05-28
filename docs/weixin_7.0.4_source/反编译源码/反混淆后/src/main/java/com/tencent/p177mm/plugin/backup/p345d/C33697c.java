package com.tencent.p177mm.plugin.backup.p345d;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19936a;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.backup.p342b.C45732c;
import com.tencent.p177mm.plugin.backup.p344c.C33682a.C11132a;
import com.tencent.p177mm.plugin.backup.p344c.C33689d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19979c;
import com.tencent.p177mm.plugin.backup.p920g.C24713a;
import com.tencent.p177mm.plugin.backup.p920g.C33704j.C33705a;
import com.tencent.p177mm.plugin.backup.p920g.C38655k;
import com.tencent.p177mm.plugin.backup.p920g.C42773e;
import com.tencent.p177mm.plugin.backup.p921i.C11152ag;
import com.tencent.p177mm.plugin.backup.p921i.C11154f;
import com.tencent.p177mm.plugin.backup.p921i.C19992o;
import com.tencent.p177mm.plugin.backup.p921i.C27492af;
import com.tencent.p177mm.plugin.backup.p921i.C27493e;
import com.tencent.p177mm.plugin.backup.p921i.C27495x;
import com.tencent.p177mm.plugin.backup.p921i.C38665y;
import com.tencent.p177mm.plugin.backup.p921i.C45749a;
import com.tencent.p177mm.plugin.backup.p921i.C45752j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.protobuf.C7284ua;
import com.tencent.p177mm.protocal.protobuf.ahq;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C15443m;
import com.tencent.p177mm.storage.C15444n;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.backup.d.c */
public final class C33697c implements C19939d, C19977d {
    private static boolean aGz = false;
    private static int eRu = 0;
    private static boolean jtr = false;
    private static boolean jts = false;
    String ceI;
    private boolean eVT = false;
    private long jrb = 0;
    private boolean jsA = false;
    public C19939d jsv;
    private boolean jtA = false;
    private int jtB;
    public String jtC;
    String jtD;
    int jtE;
    private C7564ap jtF;
    final C1202f jtG = new C336991();
    private final C1202f jtH = new C111465();
    private final C1202f jtI = new C111476();
    public long jtJ;
    private int jtK;
    C19979c jtL = new C3133710();
    private final C33705a jtM = new C1114511();
    private C33689d jti;
    private LinkedList<String> jtj;
    private LinkedList<Long> jtk;
    private LinkedList<String> jtl;
    private LinkedList<Long> jtm;
    public C19936a jtn;
    private HashSet<String> jto = new HashSet();
    private long jtp = 0;
    private long jtq = 0;
    private boolean jtt = true;
    private HashSet<String> jtu = new HashSet();
    private int jtv = 0;
    public boolean jtw = false;
    private boolean jtx = true;
    private boolean jty = true;
    private boolean jtz = false;
    private Object lock = new Object();
    private long recvSize = 0;

    /* renamed from: com.tencent.mm.plugin.backup.d.c$a */
    class C2650a {
        byte[] buf;
        int fQi;
        boolean iae = false;
        int type;

        C2650a(int i, int i2, byte[] bArr) {
            AppMethodBeat.m2504i(17259);
            this.fQi = i;
            this.type = i2;
            this.buf = (byte[]) bArr.clone();
            AppMethodBeat.m2505o(17259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.c$4 */
    class C67924 implements C5015a {
        C67924() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(17249);
            if (!C33697c.aGz) {
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
                if (C33697c.this.jtF != null) {
                    C33697c.this.jtF.stopTimer();
                }
                C33697c.m55052d(C33697c.this);
            }
            AppMethodBeat.m2505o(17249);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.c$11 */
    class C1114511 implements C33705a {
        C1114511() {
        }

        public final void aTn() {
            AppMethodBeat.m2504i(17256);
            C33697c.this.mo6681rj(C41258b.aSZ().aSu().jqW);
            AppMethodBeat.m2505o(17256);
        }

        /* renamed from: ro */
        public final void mo15077ro(int i) {
            AppMethodBeat.m2504i(17257);
            int i2 = C41258b.aSZ().aSu().jqW;
            if (i == 1) {
                if (i2 == 23) {
                    C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
                    C41258b.aSZ().aSu().jqW = 4;
                    C33697c.this.mo6681rj(4);
                    C7060h.pYm.mo8381e(11789, Integer.valueOf(8));
                    AppMethodBeat.m2505o(17257);
                    return;
                }
            } else if (i == 0 && i2 == 4) {
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
                C41258b.aSZ().aSu().jqW = 23;
                C33697c.this.mo6681rj(23);
                C7060h.pYm.mo8381e(11789, Integer.valueOf(9));
            }
            AppMethodBeat.m2505o(17257);
        }

        public final void aTo() {
            AppMethodBeat.m2504i(17258);
            int i = C41258b.aSZ().aSu().jqW;
            C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", Integer.valueOf(i));
            if (i == 23 || i == 4) {
                C33697c.this.mo54257c(true, false, -4);
                C7060h.pYm.mo8378a(485, 43, 1, false);
                C33697c.this.mo54259rn(4);
                C41258b.aSZ().aTa().stop();
            }
            AppMethodBeat.m2505o(17258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.c$5 */
    class C111465 implements C1202f {
        C111465() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17250);
            C33697c.aGz = true;
            C7060h.pYm.mo8378a(485, 42, 1, false);
            C7060h.pYm.mo8381e(11787, Integer.valueOf(0));
            C19978b.m30886b(1, C33697c.this.jtH);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
                C24713a c24713a = (C24713a) c1207m;
                if (c24713a.jwY.Version < C45732c.jqG) {
                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", Integer.valueOf(c24713a.jwY.Version));
                    C7060h.pYm.mo8378a(485, 104, 1, false);
                    C41258b.aSZ().aSu().jqW = -12;
                    C33697c.this.mo6681rj(-12);
                    AppMethodBeat.m2505o(17250);
                    return;
                }
                boolean z;
                int i3 = c24713a.jwY.jCt;
                C33697c c33697c = C33697c.this;
                if ((c24713a.jwY.jCu & C45732c.jqK) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                c33697c.jtx = z;
                C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", Integer.valueOf(c24713a.jwY.Version), Integer.valueOf(i3), Boolean.valueOf(C33697c.this.jtx));
                if (i3 == C45732c.jqI && C33697c.aTe()) {
                    C33697c.this.jtz = true;
                    C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
                } else {
                    C33697c.this.aTf();
                    C33697c.this.jtz = false;
                    C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
                }
                C33697c.m55055g(C33697c.this);
                C19978b.m30879a(3, C33697c.this.jtI);
                new C38655k(C41258b.aSZ().jqO).aUc();
                C41258b.aSZ().aSu().jqW = 22;
                C33697c.this.mo6681rj(22);
                AppMethodBeat.m2505o(17250);
                return;
            }
            C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
            C41258b.aSZ().aSu().jqW = -5;
            C33697c.this.mo6681rj(-5);
            C33697c.this.mo54259rn(3);
            AppMethodBeat.m2505o(17250);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.c$6 */
    class C111476 implements C1202f {
        C111476() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17251);
            C19978b.m30886b(3, C33697c.this.jtI);
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C38655k c38655k = (C38655k) c1207m;
                C19992o c19992o = c38655k.jyg;
                if (C41258b.aSZ().jqO.equals(c19992o.f4367ID)) {
                    Object obj;
                    double d;
                    C41258b.aSZ().aSu().jrc = c19992o.jBL;
                    C33697c.this.ceI = c38655k.jyg.jBO.jBE;
                    if (c38655k.jyg.jBO.jBH.toLowerCase().contains("ios")) {
                        C33697c.this.jtB = 1;
                    } else {
                        C33697c.this.jtB = 2;
                    }
                    C33697c.this.jrb = c38655k.jyg.jBS;
                    C33697c.this.jtv = c38655k.jyg.jBU;
                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], and wait old mobile's pushData", Long.valueOf(c38655k.jyg.jBR), Long.valueOf(c38655k.jyg.jBS));
                    if (C33697c.this.jty && C33697c.this.jtx) {
                        int i3;
                        C7060h c7060h = C7060h.pYm;
                        if (C33697c.this.jtw || C33697c.this.jtv == 1) {
                            i3 = 66;
                        } else {
                            i3 = 65;
                        }
                        c7060h.mo8378a(485, (long) i3, 1, false);
                    }
                    if (c38655k.jyg.jBQ == 3) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        C33697c.this.jsA = true;
                        C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                    } else {
                        C33697c.this.jsA = false;
                    }
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    C9638aw.m17190ZK();
                    C38635g.m65515a(pLong, pLong2, C18628c.getAccPath());
                    long l = C33697c.this.jrb;
                    if (((double) C33697c.this.jrb) * 0.1d > 5.24288E8d) {
                        d = 5.24288E8d;
                    } else {
                        d = ((double) C33697c.this.jrb) * 0.1d;
                    }
                    long j = ((long) d) + l;
                    C33697c.this.jtJ = j;
                    if (pLong2.value < j) {
                        C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", Long.valueOf(pLong2.value), Long.valueOf(j), Long.valueOf(C33697c.this.jrb));
                        C7060h.pYm.mo8381e(11787, Integer.valueOf(5));
                        C41258b.aSZ().aTa().stop();
                        C41258b.aSZ().aSu().jqW = -13;
                        C33697c.this.mo6681rj(-13);
                        C7060h.pYm.mo8378a(485, 5, 1, false);
                        AppMethodBeat.m2505o(17251);
                        return;
                    }
                    C33697c.this.jtp = C5046bo.anU();
                    C19978b.aTU();
                    AppMethodBeat.m2505o(17251);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
                C41258b.aSZ().aSu().jqW = -5;
                C33697c.this.mo6681rj(-5);
                AppMethodBeat.m2505o(17251);
                return;
            }
            C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(str)));
            C41258b.aSZ().aSu().jqW = -5;
            C33697c.this.mo6681rj(-5);
            AppMethodBeat.m2505o(17251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.c$10 */
    class C3133710 implements C19979c {
        C3133710() {
        }

        public final void aTm() {
            AppMethodBeat.m2504i(17255);
            C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
            C19978b.aTV();
            C41258b.aSZ().aSw();
            AppMethodBeat.m2505o(17255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.c$1 */
    class C336991 implements C1202f {
        C336991() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17246);
            C9638aw.m17182Rg().mo14546b((int) C19320l.CTRL_INDEX, C33697c.this.jtG);
            if (i == 0 && i2 == 0) {
                ahq aUk = ((C42773e) c1207m).aUk();
                C9638aw.m17190ZK();
                if (C5046bo.nullAsNil((String) C18628c.m29072Ry().get(2, null)).equals(aUk.vIQ)) {
                    String str2;
                    C41258b.aSZ().jqO = aUk.f2976ID;
                    C41258b.aSZ().jqP = aUk.vIW;
                    C41258b.aSZ().jqQ = aUk.vIX;
                    C19978b.m30882a(C33697c.this.jtL);
                    C41258b.aSZ().aSv();
                    C19978b.m30883a(C41258b.aSZ().aTc());
                    C19978b.m30880a(C41258b.aSZ().aTa());
                    C19978b.m30890rk(2);
                    C19978b.m30885a(C33697c.this.jtM);
                    int i3 = 0;
                    if (aUk.vIN > 0) {
                        C7284ua c7284ua = (C7284ua) aUk.vIO.getFirst();
                        String str3 = c7284ua.vYA;
                        i3 = ((Integer) c7284ua.wbp.getFirst()).intValue();
                        str2 = str3;
                    } else {
                        C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
                        str2 = null;
                    }
                    C33697c c33697c = C33697c.this;
                    c33697c.jtC = aUk.vIR;
                    c33697c.jtD = str2;
                    c33697c.jtE = i3;
                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(aUk.jCt), Integer.valueOf(aUk.Scene), aUk.vIR, str2, Integer.valueOf(i3));
                    C38634d.m65498rk(22);
                    C41258b.aSZ().aSu().jqW = 1;
                    Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "backup_move_notification");
                    C4996ah.getContext().startActivity(className);
                    C7060h.pYm.mo8378a(485, 41, 1, false);
                    C33697c.aGz = false;
                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", str2, aUk.vIR, C38635g.m65526ds(C4996ah.getContext()));
                    C33697c.eRu = 2;
                    C33697c.m55038a(C33697c.this, str2, i3);
                    AppMethodBeat.m2505o(17246);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
                C41258b.aSZ().aSu().jqW = -5;
                C33697c.this.mo6681rj(-5);
                AppMethodBeat.m2505o(17246);
                return;
            }
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 4 && i2 == -2011) {
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
            }
            C41258b.aSZ().aSu().jqW = -5;
            C33697c.this.mo6681rj(-5);
            AppMethodBeat.m2505o(17246);
        }
    }

    public C33697c() {
        AppMethodBeat.m2504i(17260);
        AppMethodBeat.m2505o(17260);
    }

    /* renamed from: d */
    static /* synthetic */ void m55052d(C33697c c33697c) {
        AppMethodBeat.m2504i(17277);
        c33697c.aTg();
        AppMethodBeat.m2505o(17277);
    }

    public static boolean aTe() {
        AppMethodBeat.m2504i(17261);
        boolean drz = C9638aw.m17190ZK().mo33890Yr().drz();
        AppMethodBeat.m2505o(17261);
        return drz;
    }

    public final void aTf() {
        AppMethodBeat.m2504i(17262);
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.jto.clear();
        AppMethodBeat.m2505o(17262);
    }

    /* renamed from: c */
    public final void mo54257c(boolean z, boolean z2, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(17263);
        C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), C5007an.doQ());
        if (!z) {
            C33697c.aTj();
        }
        synchronized (this.lock) {
            try {
                this.eVT = true;
                if (this.jti == null || !this.jti.jsp) {
                    i2 = 1;
                } else {
                    this.jti.mo54247l(z2, i);
                }
                this.jti = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(17263);
                }
            }
        }
        if (!(i2 == 0 || i == 0)) {
            C41258b.aSZ().aSu().jqW = i;
            mo6681rj(i);
        }
        if (z2) {
            aTf();
        }
        C19978b.aTV();
        C19978b.aTX();
        C41258b.aSZ().aTa().jrq = null;
        AppMethodBeat.m2505o(17263);
    }

    /* renamed from: bD */
    private void m55048bD(String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(17264);
        C41258b.aSZ().aTa().connect(str, i);
        C19978b.m30879a(1, this.jtH);
        try {
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.jty = z;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "getInt", new Object[0]);
        }
        C24713a c24713a = new C24713a(C41258b.aSZ().jqP, C41258b.aSZ().jqQ, C38634d.aSy(), C41258b.aSZ().jqO, C45732c.jqG, 22);
        c24713a.mo41608u(this.jty, false);
        c24713a.aUc();
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
        if (this.jtF == null) {
            this.jtF = new C7564ap(new C67924(), false);
        }
        this.jtF.mo16770ae(3000, 3000);
        AppMethodBeat.m2505o(17264);
    }

    /* renamed from: a */
    public final void mo6669a(boolean z, final int i, final byte[] bArr, final int i2) {
        AppMethodBeat.m2504i(17266);
        String str = "MicroMsg.BackupMoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        if (z && CdnLogic.kMediaTypeBeatificFile == i) {
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(C41258b.aSZ().aSu().jqW));
            switch (C41258b.aSZ().aSu().jqW) {
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -13:
                case -5:
                    C41258b.aSZ().aTa().stop();
                    AppMethodBeat.m2505o(17266);
                    return;
                case -4:
                    mo54257c(true, false, 0);
                    break;
                case 1:
                    C41258b.aSZ().aTa().stop();
                    if (aGz) {
                        C41258b.aSZ().aSu().jqW = -4;
                        mo6681rj(-4);
                        AppMethodBeat.m2505o(17266);
                        return;
                    }
                    if (this.jtF != null) {
                        C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
                        this.jtF.stopTimer();
                    }
                    aTg();
                    AppMethodBeat.m2505o(17266);
                    return;
                case 22:
                case 23:
                    mo54257c(true, false, -4);
                    C41258b.aSZ().aTa().stop();
                    jts = true;
                    C7060h.pYm.mo8378a(485, 43, 1, false);
                    mo54259rn(4);
                    long j = 0;
                    if (this.jtp != 0) {
                        j = C5046bo.m7566gb(this.jtp);
                    }
                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(this.jrb), Long.valueOf(j));
                    AppMethodBeat.m2505o(17266);
                    return;
            }
            AppMethodBeat.m2505o(17266);
        } else if (i == 9) {
            C27493e c27493e = (C27493e) C38635g.m65510a(new C27493e(), bArr);
            if (c27493e == null) {
                C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
                AppMethodBeat.m2505o(17266);
                return;
            }
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", c27493e, Long.valueOf(c27493e.jxD));
            C11154f c11154f = new C11154f();
            c11154f.jxD = c27493e.jxD;
            try {
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
                C19978b.m30889r(c11154f.toByteArray(), 10, i2);
                AppMethodBeat.m2505o(17266);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
                AppMethodBeat.m2505o(17266);
            }
        } else if (i == 10) {
            C11154f c11154f2 = (C11154f) C38635g.m65510a(new C11154f(), bArr);
            str2 = "MicroMsg.BackupMoveRecoverServer";
            String str3 = "summerbak receive heartbeat response, resp:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = c11154f2;
            objArr2[1] = Long.valueOf(c11154f2 != null ? c11154f2.jxD : -1);
            C4990ab.m7417i(str2, str3, objArr2);
            AppMethodBeat.m2505o(17266);
        } else {
            if (i == 5) {
                C7060h.pYm.mo8378a(485, 51, 1, false);
                mo54257c(true, false, -100);
            }
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17252);
                    if (i == 11) {
                        C33697c.m55040a(C33697c.this, bArr, i2);
                        AppMethodBeat.m2505o(17252);
                    } else if (i == 6) {
                        C33697c.m55046b(C33697c.this, bArr, i2);
                        AppMethodBeat.m2505o(17252);
                    } else if (i == 13) {
                        C33697c.m55034I(bArr, i2);
                        AppMethodBeat.m2505o(17252);
                    } else if (i == 15) {
                        C33697c.m55050c(C33697c.this, bArr, i2);
                        AppMethodBeat.m2505o(17252);
                    } else if (i == 8) {
                        C33697c.m55039a(C33697c.this, bArr);
                        AppMethodBeat.m2505o(17252);
                    } else {
                        AppMethodBeat.m2505o(17252);
                    }
                }
            });
            AppMethodBeat.m2505o(17266);
        }
    }

    /* renamed from: fk */
    public final void mo54258fk(boolean z) {
        AppMethodBeat.m2504i(17267);
        this.jtA = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        C41258b.aSZ().aTa().jrq = new C11132a() {
            /* renamed from: c */
            public final void mo22838c(int i, int i2, byte[] bArr) {
                AppMethodBeat.m2504i(17253);
                while (!C33697c.this.eVT) {
                    try {
                        if (linkedBlockingQueue.offer(new C2650a(i, i2, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", e.getMessage());
                    }
                }
                C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", Integer.valueOf(linkedBlockingQueue.size()));
                AppMethodBeat.m2505o(17253);
            }
        };
        C7305d.m12301h(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17254);
                while (!C33697c.this.eVT && !C33697c.jtr) {
                    C2650a c2650a;
                    try {
                        c2650a = (C2650a) linkedBlockingQueue.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        c2650a = null;
                    }
                    C4990ab.m7411d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", Integer.valueOf(linkedBlockingQueue.size()), c2650a);
                    if (c2650a != null) {
                        C33697c.this.mo6669a(c2650a.iae, c2650a.type, c2650a.buf, c2650a.fQi);
                    }
                }
                AppMethodBeat.m2505o(17254);
            }
        }, "startSendRequestSessionResponse.onNotifyWorker").start();
        this.jtl = new LinkedList();
        this.jtm = new LinkedList();
        C9638aw.m17190ZK().mo33889Yq().mo27487a(this.jtj, this.jtk, this.jtl, this.jtm);
        if (!(this.jsA || z)) {
            LinkedList linkedList = this.jtl;
            LinkedList linkedList2 = this.jtm;
            this.jtl = new LinkedList();
            this.jtm = new LinkedList();
            C9638aw.m17190ZK().mo33888Yp().mo48593a(this.ceI, linkedList, linkedList2, this.jtl, this.jtm);
        }
        C45752j c45752j = new C45752j();
        c45752j.jBx = this.jtl;
        c45752j.jBy = this.jtm;
        try {
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(this.jtj.size()), Integer.valueOf(c45752j.jBy.size()));
            C19978b.m30889r(c45752j.toByteArray(), 12, this.jtK);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        C19978b.aTW();
        if (this.jtz) {
            C41258b.aSZ().aSu().mo68222O(23, 1, this.jtj.size());
            this.recvSize = C41258b.aSZ().aSu().jra;
        } else {
            C41258b.aSZ().aSu().mo68223a(23, 1, this.jtj.size(), 0, this.jrb);
        }
        mo6681rj(23);
        AppMethodBeat.m2505o(17267);
    }

    /* renamed from: a */
    private static void m55041a(String str, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(17268);
        C38665y c38665y = new C38665y();
        c38665y.jCx = str;
        c38665y.jCy = i;
        c38665y.jCA = i2;
        c38665y.jCB = i3;
        c38665y.jBT = i4;
        try {
            C19978b.m30889r(c38665y.toByteArray(), 7, i5);
            AppMethodBeat.m2505o(17268);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "sendResp", new Object[0]);
            AppMethodBeat.m2505o(17268);
        }
    }

    /* renamed from: rn */
    public final void mo54259rn(int i) {
        AppMethodBeat.m2504i(17269);
        long j = 0;
        if (this.jtp != 0) {
            j = C5046bo.m7566gb(this.jtp);
        }
        C7060h.pYm.mo8381e(11789, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.jtB), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000));
        C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recoverCostTime[%d s]", Integer.valueOf(11789), Integer.valueOf(i), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000));
        AppMethodBeat.m2505o(17269);
    }

    public final void aTh() {
        AppMethodBeat.m2504i(17270);
        mo54257c(true, false, 28);
        C41258b.aSZ().aTa().stop();
        AppMethodBeat.m2505o(17270);
    }

    public final void aSL() {
        AppMethodBeat.m2504i(17271);
        synchronized (this.lock) {
            try {
                if (this.jti == null || !this.jti.jsp) {
                    int drA;
                    if (this.jti != null) {
                        this.jti.mo54247l(false, 0);
                    }
                    if (this.jto == null || this.jto.size() <= 0) {
                        drA = C9638aw.m17190ZK().mo33890Yr().drA();
                    } else {
                        drA = this.jto.size();
                    }
                    C41258b.aSZ().aSu().jqW = 26;
                    C41258b.aSZ().aSu().jqZ = 0;
                    mo6681rj(26);
                    this.jtq = C5046bo.anU();
                    this.jti = new C33689d(C41258b.aSZ(), 22, this, drA, false, new LinkedList(), new LinkedList());
                    this.jti.aSL();
                    C7060h.pYm.mo8378a(485, 46, 1, false);
                    AppMethodBeat.m2505o(17271);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
            } finally {
                AppMethodBeat.m2505o(17271);
            }
        }
    }

    public static String aTi() {
        AppMethodBeat.m2504i(17272);
        String aTY = C19978b.aTY();
        AppMethodBeat.m2505o(17272);
        return aTY;
    }

    private static void aTj() {
        AppMethodBeat.m2504i(17273);
        C45749a c45749a = new C45749a();
        c45749a.f17890ID = C41258b.aSZ().jqO;
        try {
            C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            C19978b.m30877K(c45749a.toByteArray(), 5);
            AppMethodBeat.m2505o(17273);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupCancelRequest err.", new Object[0]);
            AppMethodBeat.m2505o(17273);
        }
    }

    /* renamed from: rj */
    public final void mo6681rj(final int i) {
        AppMethodBeat.m2504i(17274);
        if (this.jsv != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17247);
                    if (C33697c.this.jsv != null) {
                        C33697c.this.jsv.mo6681rj(i);
                    }
                    AppMethodBeat.m2505o(17247);
                }
            });
        }
        if (this.jtn != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17248);
                    if (C33697c.this.jtn != null) {
                        C33697c.this.jtn.mo35185ri(i);
                    }
                    AppMethodBeat.m2505o(17248);
                }
            });
        }
        AppMethodBeat.m2505o(17274);
    }

    public final void aSt() {
        AppMethodBeat.m2504i(17275);
        C7060h.pYm.mo8378a(485, 49, 1, false);
        C7060h.pYm.mo8378a(485, 50, C5046bo.m7566gb(this.jtq) / 1000, false);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.TRUE);
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (!this.jsA) {
            C15444n Yq = C9638aw.m17190ZK().mo33889Yq();
            LinkedList linkedList = new LinkedList();
            Cursor baR = Yq.baR();
            if (baR == null) {
                C4990ab.m7412e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            } else {
                while (baR.moveToNext()) {
                    C15443m c15443m = new C15443m();
                    c15443m.mo8995d(baR);
                    linkedList.add(c15443m);
                }
                baR.close();
            }
            if (linkedList.size() <= 0) {
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                C9638aw.m17190ZK().mo33888Yp().mo48595f(this.ceI, linkedList);
            }
        }
        aTf();
        C19978b.m30891rx(22);
        C19978b.aTV();
        C19978b.aTX();
        AppMethodBeat.m2505o(17275);
    }

    private void aTg() {
        AppMethodBeat.m2504i(17265);
        String str = this.jtC;
        String str2 = this.jtD;
        String ds = C38635g.m65526ds(C4996ah.getContext());
        C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", ds, str, str2, Integer.valueOf(eRu));
        if (ds == null || ds.equals("")) {
            C7060h.pYm.mo8378a(485, 1, 1, false);
            C7060h.pYm.mo8381e(11787, Integer.valueOf(1));
            C41258b.aSZ().aSu().jqW = -1;
            mo6681rj(-1);
            AppMethodBeat.m2505o(17265);
        } else if (str == null || !str.equals(ds)) {
            C7060h.pYm.mo8378a(485, 2, 1, false);
            C7060h.pYm.mo8381e(11787, Integer.valueOf(2));
            C41258b.aSZ().aSu().jqW = -2;
            mo6681rj(-2);
            AppMethodBeat.m2505o(17265);
        } else if (!C38635g.m65505Fc(str2)) {
            C7060h.pYm.mo8378a(485, 3, 1, false);
            C7060h.pYm.mo8381e(11787, Integer.valueOf(3));
            C41258b.aSZ().aSu().jqW = -3;
            mo6681rj(-3);
            AppMethodBeat.m2505o(17265);
        } else if (eRu <= 0) {
            C41258b.aSZ().aSu().jqW = -5;
            mo6681rj(-5);
            C7060h.pYm.mo8378a(485, 4, 1, false);
            C7060h.pYm.mo8381e(11787, Integer.valueOf(6));
            AppMethodBeat.m2505o(17265);
        } else {
            eRu--;
            m55048bD(this.jtD, this.jtE);
            AppMethodBeat.m2505o(17265);
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m55055g(C33697c c33697c) {
        AppMethodBeat.m2504i(17278);
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "move recover init");
        jtr = false;
        jts = false;
        c33697c.jrb = 0;
        c33697c.recvSize = 0;
        c33697c.eVT = false;
        c33697c.jto.clear();
        c33697c.jtt = true;
        c33697c.jtu.clear();
        AppMethodBeat.m2505o(17278);
    }

    /* renamed from: b */
    static /* synthetic */ void m55046b(C33697c c33697c, byte[] bArr, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(17280);
        if (c33697c.jtt) {
            c33697c.jtt = false;
        }
        C27495x c27495x = (C27495x) C38635g.m65510a(new C27495x(), bArr);
        if (c27495x == null) {
            C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
            C33697c.m55041a("", 0, 0, 0, 1, i);
            AppMethodBeat.m2505o(17280);
            return;
        }
        C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", c27495x.jCx, Integer.valueOf(c27495x.jCy), Integer.valueOf(c27495x.jCA), Integer.valueOf(c27495x.jCB));
        if (c27495x.jCy == 1 && c27495x.jBi != null) {
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", c27495x.jCx, C38635g.m65502EZ(c27495x.jCx));
            C38635g.m65518b(r2, c27495x);
            c33697c.recvSize += (long) c27495x.jBi.f1226wR.length;
        }
        if (c27495x.jCy == 2) {
            C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", c27495x.jCx, C38635g.m65503Fa(c27495x.jCx));
            C38635g.m65514a(r2, c27495x);
            c33697c.recvSize += (long) c27495x.jBi.f1226wR.length;
            c33697c.jtu.add(c27495x.jCx);
        }
        C4990ab.m7417i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(c33697c.recvSize), Long.valueOf(c33697c.jrb));
        if (c33697c.jrb < c33697c.recvSize) {
            c33697c.jrb = c33697c.recvSize;
        }
        C33697c.m55041a(c27495x.jCx, c27495x.jCy, c27495x.jCA, c27495x.jCB, 0, i);
        C42758e aSu = C41258b.aSZ().aSu();
        long j = c33697c.recvSize;
        double d = 0.0d;
        if (aSu.jrb != 0) {
            d = (double) (((j - aSu.jra) * 100) / aSu.jrb);
        }
        aSu.jra = j;
        if (d < 0.5d) {
            i2 = 0;
        }
        if (i2 != 0) {
            c33697c.mo6681rj(aSu.jqW);
        }
        AppMethodBeat.m2505o(17280);
    }

    /* renamed from: I */
    static /* synthetic */ void m55034I(byte[] bArr, int i) {
        AppMethodBeat.m2504i(17281);
        C27492af c27492af = (C27492af) C38635g.m65510a(new C27492af(), bArr);
        if (c27492af == null) {
            C4990ab.m7413e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
            AppMethodBeat.m2505o(17281);
            return;
        }
        C11152ag c11152ag = new C11152ag();
        c11152ag.jCP = c27492af.jCP;
        c11152ag.jCR = c27492af.jCR;
        c11152ag.jCQ = c27492af.jCQ;
        c11152ag.jBt = c27492af.jBt;
        try {
            C4990ab.m7416i("MicroMsg.BackupMoveRecoverServer", "send SvrID resp");
            C19978b.m30889r(c11152ag.toByteArray(), 14, i);
            AppMethodBeat.m2505o(17281);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to PacketSvrIDResponse err.", new Object[0]);
            AppMethodBeat.m2505o(17281);
        }
    }
}
