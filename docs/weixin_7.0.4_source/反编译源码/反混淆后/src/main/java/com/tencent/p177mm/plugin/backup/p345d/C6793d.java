package com.tencent.p177mm.plugin.backup.p345d;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C2600b;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C45732c;
import com.tencent.p177mm.plugin.backup.p344c.C33685b;
import com.tencent.p177mm.plugin.backup.p344c.C33688c;
import com.tencent.p177mm.plugin.backup.p345d.C2651e.C2655a;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19979c;
import com.tencent.p177mm.plugin.backup.p920g.C33704j.C33705a;
import com.tencent.p177mm.plugin.backup.p921i.C11154f;
import com.tencent.p177mm.plugin.backup.p921i.C19990m;
import com.tencent.p177mm.plugin.backup.p921i.C19992o;
import com.tencent.p177mm.plugin.backup.p921i.C19994v;
import com.tencent.p177mm.plugin.backup.p921i.C27493e;
import com.tencent.p177mm.plugin.backup.p921i.C27494w;
import com.tencent.p177mm.plugin.backup.p921i.C38662i;
import com.tencent.p177mm.plugin.backup.p921i.C45749a;
import com.tencent.p177mm.plugin.backup.p921i.C45752j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.d.d */
public final class C6793d implements C2600b, C19977d {
    public static boolean jsA = false;
    public static boolean jtX = false;
    public byte[] bitmapData;
    public C19939d jsv;
    public C19979c jtL = new C67952();
    public final C33705a jtM = new C67963();
    public LinkedList<String> jtQ;
    private C33685b jtR;
    private C33688c jtS;
    public long jtT = 0;
    public long jtU = 0;
    public boolean jtV = false;
    public int jtW = 0;
    private int jtY;
    private int jtZ;
    public boolean jtw = false;
    private int jua = 0;
    public C2651e jub = new C2651e(new C67944(), C41258b.aSZ().aSu());

    /* renamed from: com.tencent.mm.plugin.backup.d.d$4 */
    class C67944 implements C2655a {
        C67944() {
        }

        /* renamed from: k */
        public final void mo6718k(int i, byte[] bArr) {
            AppMethodBeat.m2504i(17289);
            if (bArr != null) {
                C6793d.this.bitmapData = bArr;
            }
            C6793d.this.mo6651rj(i);
            AppMethodBeat.m2505o(17289);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.d$2 */
    class C67952 implements C19979c {
        C67952() {
        }

        public final void aTm() {
            AppMethodBeat.m2504i(17285);
            C4990ab.m7416i("MicroMsg.BackupMoveServer", "stopCallback ");
            C19978b.aTV();
            C41258b.aSZ().aSw();
            AppMethodBeat.m2505o(17285);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.d$3 */
    class C67963 implements C33705a {
        C67963() {
        }

        public final void aTn() {
            AppMethodBeat.m2504i(17286);
            C6793d.this.mo6651rj(C41258b.aSZ().aSu().jqW);
            AppMethodBeat.m2505o(17286);
        }

        /* renamed from: ro */
        public final void mo15077ro(int i) {
            AppMethodBeat.m2504i(17287);
            int i2 = C41258b.aSZ().aSu().jqW;
            if (i == 1) {
                if (i2 == 14) {
                    C4990ab.m7416i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
                    C41258b.aSZ().aSu().jqW = 4;
                    C6793d.this.mo6651rj(4);
                    AppMethodBeat.m2505o(17287);
                    return;
                }
            } else if (i == 0 && i2 == 4) {
                C4990ab.m7416i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
                C41258b.aSZ().aSu().jqW = 14;
                C6793d.this.mo6651rj(14);
            }
            AppMethodBeat.m2505o(17287);
        }

        public final void aTo() {
            AppMethodBeat.m2504i(17288);
            int i = C41258b.aSZ().aSu().jqW;
            C4990ab.m7413e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", Integer.valueOf(i));
            if (i == 14 || i == 4) {
                C6793d.this.cancel(true);
                C41258b.aSZ().aTa().stop();
                C41258b.aSZ().aSu().jqW = -4;
                C6793d.this.mo6651rj(-4);
            }
            AppMethodBeat.m2505o(17288);
        }
    }

    public C6793d() {
        AppMethodBeat.m2504i(17290);
        AppMethodBeat.m2505o(17290);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.m2504i(17291);
        C4990ab.m7413e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", C5007an.doQ());
        if (!z) {
            C6793d.aTj();
        }
        if (this.jtS != null) {
            this.jtS.cancel();
        }
        if (this.jtR != null) {
            this.jtR.cancel();
            this.jtR = null;
        }
        C4990ab.m7416i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        C19978b.aTV();
        C19978b.aTX();
        AppMethodBeat.m2505o(17291);
    }

    /* renamed from: d */
    public static void m11230d(int i, long j, long j2, int i2) {
        AppMethodBeat.m2504i(17292);
        C4990ab.m7417i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2));
        if (i == 0) {
            j2 = 0;
            j = 0;
        }
        C41258b.aSZ();
        Editor edit = C38634d.aSz().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j2);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i2);
        edit.commit();
        AppMethodBeat.m2505o(17292);
    }

    /* renamed from: a */
    public final void mo6669a(boolean z, int i, byte[] bArr, int i2) {
        AppMethodBeat.m2504i(17293);
        String str = "MicroMsg.BackupMoveServer";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        if (z && bArr != null && CdnLogic.kMediaTypeBeatificFile == i) {
            C4990ab.m7417i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(C41258b.aSZ().aSu().jqW));
            switch (C41258b.aSZ().aSu().jqW) {
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    C41258b.aSZ().aTa().stop();
                    break;
                case -4:
                    cancel(true);
                    break;
                case 1:
                    C41258b.aSZ().aTa().stop();
                    C41258b.aSZ().aSu().jqW = -100;
                    mo6651rj(-100);
                    break;
                case 12:
                case 14:
                    cancel(true);
                    C41258b.aSZ().aTa().stop();
                    C41258b.aSZ().aSu().jqW = -4;
                    mo6651rj(-4);
                    C7060h.pYm.mo8378a(485, 24, 1, false);
                    if (!(this.jtS == null || this.jtS.jrH == 0)) {
                        long gb = C5046bo.m7566gb(this.jtS.jrH);
                        C4990ab.m7417i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", Long.valueOf(this.jtS.aSH()), Long.valueOf(gb / 1000));
                        break;
                    }
            }
        }
        if (i == 1) {
            C19994v c19994v = (C19994v) C38635g.m65510a(new C19994v(), bArr);
            if (c19994v == null) {
                C4990ab.m7413e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
                C41258b.aSZ().aSu().jqW = -5;
                mo6651rj(-5);
                AppMethodBeat.m2505o(17293);
                return;
            }
            if (C5046bo.isNullOrNil(C41258b.aSZ().jqO)) {
                C41258b.aSZ().jqO = c19994v.f4368ID;
            }
            if (c19994v.f4368ID.equals(C41258b.aSZ().jqO)) {
                C4990ab.m7417i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", c19994v.f4368ID, Integer.valueOf(c19994v.jCs));
                if (c19994v.jCs == 0) {
                    if (!C41258b.aSZ().jqP.equals(new String(C1182l.m2607c(c19994v.jBi.f1226wR, C38634d.aSy())))) {
                        C27494w c27494w = new C27494w();
                        c27494w.jCs = 0;
                        c27494w.f13685ID = C41258b.aSZ().jqO;
                        c27494w.jBT = 1;
                        C4990ab.m7412e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
                        try {
                            C4990ab.m7416i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
                            C19978b.m30889r(c27494w.toByteArray(), 2, i2);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
                        }
                        C41258b.aSZ().aSu().jqW = -5;
                        mo6651rj(-5);
                    }
                    if (c19994v.Version < C45732c.jqG) {
                        C4990ab.m7417i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", Integer.valueOf(c19994v.Version));
                        C7060h.pYm.mo8378a(485, 103, 1, false);
                        C41258b.aSZ().aSu().jqW = -12;
                        mo6651rj(-12);
                        AppMethodBeat.m2505o(17293);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.BackupMoveServer", "summerbak start move");
                    this.jtZ = i2;
                    if (jtX || jsA) {
                        if (jtX && jsA && (c19994v.jCu & C45732c.jqL) == 0 && (c19994v.jCu & C45732c.jqM) == 0) {
                            C41258b.aSZ().aSu().jqW = -31;
                            mo6651rj(-31);
                            this.jua = 1;
                            AppMethodBeat.m2505o(17293);
                            return;
                        } else if (jtX && (c19994v.jCu & C45732c.jqL) == 0) {
                            C41258b.aSZ().aSu().jqW = -32;
                            mo6651rj(-32);
                            this.jua = 2;
                            AppMethodBeat.m2505o(17293);
                            return;
                        } else if (jsA && (c19994v.jCu & C45732c.jqM) == 0) {
                            C41258b.aSZ().aSu().jqW = -33;
                            mo6651rj(-33);
                            this.jua = 3;
                            AppMethodBeat.m2505o(17293);
                            return;
                        }
                    }
                    mo15073fl(false);
                    AppMethodBeat.m2505o(17293);
                    return;
                }
                if (c19994v.jCs == 1) {
                    if (!C41258b.aSZ().jqQ.equals(new String(C1182l.m2607c(c19994v.jBi.f1226wR, C38634d.aSy())))) {
                        C4990ab.m7412e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        C41258b.aSZ().aSu().jqW = -5;
                        mo6651rj(-5);
                    }
                    C4990ab.m7416i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    C41258b.aSZ().aSu().jqW = 2;
                    mo6651rj(2);
                }
                AppMethodBeat.m2505o(17293);
                return;
            }
            C4990ab.m7413e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", C41258b.aSZ().jqO, c19994v.f4368ID);
            cancel(false);
            C41258b.aSZ().aSu().jqW = -5;
            mo6651rj(-5);
            AppMethodBeat.m2505o(17293);
        } else if (i == 3) {
            this.jtY = i2;
            if (C41258b.aSZ().aTd().jsZ) {
                aTp();
                AppMethodBeat.m2505o(17293);
                return;
            }
            this.jtV = true;
            AppMethodBeat.m2505o(17293);
        } else if (i == 9) {
            C27493e c27493e = (C27493e) C38635g.m65510a(new C27493e(), bArr);
            if (c27493e == null) {
                C4990ab.m7413e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
                AppMethodBeat.m2505o(17293);
                return;
            }
            C4990ab.m7417i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", c27493e, Long.valueOf(c27493e.jxD));
            C11154f c11154f = (C11154f) C38635g.m65510a(new C11154f(), bArr);
            c11154f.jxD = c27493e.jxD;
            try {
                C4990ab.m7416i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
                C19978b.m30889r(c11154f.toByteArray(), 10, i2);
                AppMethodBeat.m2505o(17293);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
                AppMethodBeat.m2505o(17293);
            }
        } else if (i == 10) {
            try {
                new C11154f().parseFrom(bArr);
                AppMethodBeat.m2505o(17293);
            } catch (Exception e22) {
                C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e22, "summerbak heartbeatResp parse from buf error.", new Object[0]);
                AppMethodBeat.m2505o(17293);
            }
        } else if (i == 5) {
            C4990ab.m7416i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
            cancel(true);
            C41258b.aSZ().aSu().jqW = -100;
            mo6651rj(-100);
            AppMethodBeat.m2505o(17293);
        } else {
            if (i == 12) {
                C45752j c45752j = (C45752j) C38635g.m65510a(new C45752j(), bArr);
                if (c45752j == null) {
                    C4990ab.m7413e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
                    C41258b.aSZ().aSu().jqW = -5;
                    mo6651rj(-5);
                    AppMethodBeat.m2505o(17293);
                    return;
                }
                int i3;
                LinkedList b = C38635g.m65517b(c45752j.jBx, c45752j.jBy);
                str2 = "MicroMsg.BackupMoveServer";
                String str3 = "summerbak backup receive requestsession response. backupSessionList:%d ";
                Object[] objArr2 = new Object[1];
                if (b == null) {
                    i3 = -1;
                } else {
                    i3 = b.size();
                }
                objArr2[0] = Integer.valueOf(i3);
                C4990ab.m7417i(str2, str3, objArr2);
                if (b == null) {
                    C4990ab.m7412e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                    C6793d.aTj();
                    C41258b.aSZ().aSu().jqW = -21;
                    mo6651rj(-21);
                    AppMethodBeat.m2505o(17293);
                    return;
                }
                C19978b.aTU();
                this.jtS = new C33688c(C41258b.aSZ(), 2, this);
                this.jtS.mo54245fj(false);
                this.jtS.mo54240a(b, C41258b.aSZ().aSu().jrc, jsA);
            }
            AppMethodBeat.m2505o(17293);
        }
    }

    /* renamed from: fl */
    public final void mo15073fl(boolean z) {
        AppMethodBeat.m2504i(17294);
        if (z) {
            switch (this.jua) {
                case 1:
                    jtX = false;
                    jsA = false;
                    this.jtT = 0;
                    this.jtU = 0;
                    break;
                case 2:
                    jtX = false;
                    this.jtT = 0;
                    this.jtU = 0;
                    break;
                case 3:
                    jsA = false;
                    break;
            }
        }
        C27494w c27494w = new C27494w();
        c27494w.jCs = 0;
        c27494w.f13685ID = C41258b.aSZ().jqO;
        c27494w.Version = C45732c.jqG;
        c27494w.jBT = 0;
        c27494w.jCt = this.jtW;
        c27494w.jBi = new C1332b(C1182l.m2608d(C41258b.aSZ().jqQ.getBytes(), C38634d.aSy()));
        if (C5046bo.getInt(C26373g.m41964Nu().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            c27494w.jCu |= C45732c.jqK;
        }
        c27494w.jCu |= C45732c.jqL;
        c27494w.jCu |= C45732c.jqM;
        try {
            C4990ab.m7416i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
            C19978b.m30889r(c27494w.toByteArray(), 2, this.jtZ);
            AppMethodBeat.m2505o(17294);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
            AppMethodBeat.m2505o(17294);
        }
    }

    public final void aTp() {
        AppMethodBeat.m2504i(17295);
        C4990ab.m7416i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
        this.jtV = false;
        C41258b.aSZ().aSu().jqW = 12;
        mo6651rj(12);
        C38658d.aUr().aUu();
        if (this.jtQ == null) {
            AppMethodBeat.m2505o(17295);
            return;
        }
        C4990ab.m7417i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", Integer.valueOf(this.jtQ.size()));
        C19992o c19992o = new C19992o();
        c19992o.f4367ID = C41258b.aSZ().jqO;
        c19992o.jBR = (long) this.jtQ.size();
        c19992o.jBS = C41258b.aSZ().aTd().aSY();
        c19992o.jBT = 0;
        c19992o.jBU = this.jtw ? C45732c.jqF : C45732c.jqE;
        if (jsA) {
            c19992o.jBQ = 3;
        }
        C19990m c19990m = new C19990m();
        c19990m.jBE = C1427q.m3028LM();
        c19990m.jBF = Build.MANUFACTURER;
        c19990m.jBG = Build.MODEL;
        c19990m.jBH = "Android";
        c19990m.jBI = VERSION.RELEASE;
        c19990m.jBJ = C7243d.vxo;
        c19990m.jBK = 0;
        C4990ab.m7417i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", Integer.valueOf(C7243d.vxo));
        c19992o.jBO = c19990m;
        try {
            C19978b.m30889r(c19992o.toByteArray(), 4, this.jtY);
            m11228A(this.jtT, this.jtU);
            AppMethodBeat.m2505o(17295);
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "", new Object[0]);
            AppMethodBeat.m2505o(17295);
        }
    }

    /* renamed from: A */
    private void m11228A(long j, long j2) {
        AppMethodBeat.m2504i(17296);
        C4990ab.m7417i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(this.jtQ.size()), Long.valueOf(j), Long.valueOf(j2));
        C38662i c38662i = new C38662i();
        c38662i.jBx = this.jtQ;
        c38662i.jBy = new LinkedList();
        Iterator it = this.jtQ.iterator();
        while (it.hasNext()) {
            it.next();
            c38662i.jBy.add(Long.valueOf(j));
            c38662i.jBy.add(Long.valueOf(j2));
        }
        try {
            C4990ab.m7417i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", Integer.valueOf(this.jtQ.size()));
            C19978b.m30877K(c38662i.toByteArray(), 11);
            AppMethodBeat.m2505o(17296);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
            AppMethodBeat.m2505o(17296);
        }
    }

    private static void aTj() {
        AppMethodBeat.m2504i(17297);
        C45749a c45749a = new C45749a();
        c45749a.f17890ID = C41258b.aSZ().jqO;
        try {
            C4990ab.m7416i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
            C19978b.m30877K(c45749a.toByteArray(), 5);
            AppMethodBeat.m2505o(17297);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to BackupCancelRequest err.", new Object[0]);
            AppMethodBeat.m2505o(17297);
        }
    }

    public static String aTq() {
        AppMethodBeat.m2504i(17298);
        String aTY = C19978b.aTY();
        AppMethodBeat.m2505o(17298);
        return aTY;
    }

    /* renamed from: rj */
    public final void mo6651rj(final int i) {
        AppMethodBeat.m2504i(17299);
        if (this.jsv != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17284);
                    if (C6793d.this.jsv != null) {
                        C6793d.this.jsv.mo6681rj(i);
                    }
                    AppMethodBeat.m2505o(17284);
                }
            });
        }
        AppMethodBeat.m2505o(17299);
    }

    public final void aSq() {
        AppMethodBeat.m2504i(17300);
        C19978b.m30891rx(21);
        AppMethodBeat.m2505o(17300);
    }

    public final void aSr() {
        AppMethodBeat.m2504i(17301);
        cancel(false);
        AppMethodBeat.m2505o(17301);
    }
}
