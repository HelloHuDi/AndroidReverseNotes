package com.tencent.p177mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26411af;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p203bg.C1309c;
import com.tencent.p177mm.p203bg.C32335a;
import com.tencent.p177mm.p203bg.C32336d;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C43298a;
import com.tencent.p177mm.plugin.talkroom.component.C22380d;
import com.tencent.p177mm.plugin.talkroom.component.C22381e;
import com.tencent.p177mm.plugin.talkroom.component.C39948a;
import com.tencent.p177mm.plugin.talkroom.component.C39948a.C22379a;
import com.tencent.p177mm.plugin.talkroom.component.C43680c.C39950a;
import com.tencent.p177mm.plugin.talkroom.component.C46295b;
import com.tencent.p177mm.plugin.talkroom.component.C46295b.C39949a;
import com.tencent.p177mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.p177mm.plugin.talkroom.model.C43686i.C139352;
import com.tencent.p177mm.plugin.talkroom.model.C43686i.C294213;
import com.tencent.p177mm.plugin.talkroom.model.C43686i.C352846;
import com.tencent.p177mm.plugin.talkroom.model.C43686i.C3995410;
import com.tencent.p177mm.plugin.talkroom.model.C43686i.C4368711;
import com.tencent.p177mm.plugin.talkroom.p1041b.C13929a;
import com.tencent.p177mm.plugin.talkroom.p1041b.C22378g;
import com.tencent.p177mm.plugin.talkroom.p1041b.C29415f;
import com.tencent.p177mm.plugin.talkroom.p1041b.C39946c;
import com.tencent.p177mm.plugin.talkroom.p1041b.C39947e;
import com.tencent.p177mm.plugin.talkroom.p1041b.C46293b;
import com.tencent.p177mm.plugin.talkroom.p1041b.C46294d;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cgl;
import com.tencent.p177mm.protocal.protobuf.cgm;
import com.tencent.p177mm.protocal.protobuf.cgn;
import com.tencent.p177mm.sdk.platformtools.C35986af;
import com.tencent.p177mm.sdk.platformtools.C35986af.C23496a;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.view.C31128d;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.talkroom.model.g */
public final class C43683g implements C1202f, C32335a, C1309c, C26411af {
    public static final int[] syP = new int[]{80, 8080, 16285};
    public static final byte[][] syQ = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    private final ServiceConnection ktl = new C352811();
    private int nwu;
    private long nwv;
    private int state = 0;
    private int syA = 0;
    private int syB = 0;
    private boolean syC = false;
    public String syD;
    private int syE;
    private int syF;
    private int syG;
    private LinkedList<cgl> syH = new LinkedList();
    private C39948a syI;
    private C46295b syJ;
    private C22381e syK;
    private C22380d syL;
    private C35986af syM;
    private C7564ap syN;
    private C43686i syO = new C43686i();
    public boolean syR = false;

    /* renamed from: com.tencent.mm.plugin.talkroom.model.g$6 */
    class C139346 extends C39950a {
        C139346() {
        }

        /* renamed from: p */
        public final void mo26156p(int i, int i2, boolean z) {
            AppMethodBeat.m2504i(25810);
            if (z) {
                C43683g.this.syG = 0;
                C43683g.this.syO.mo69334tO("");
                AppMethodBeat.m2505o(25810);
                return;
            }
            C43683g.m78253c(C43683g.this, i2);
            if (C43683g.this.syG == i) {
                AppMethodBeat.m2505o(25810);
                return;
            }
            C43683g.this.syG = i;
            String cEu = C43683g.this.cEu();
            if (!C43683g.this.syC && cEu == null) {
                C43683g.this.syC = true;
                int e = C43683g.this.nwu;
                long f = C43683g.this.nwv;
                String g = C43683g.this.syD;
                C43683g c43683g = C43683g.this;
                C43683g.this.syD;
                C9638aw.m17182Rg().mo14541a(new C39946c(e, f, g, c43683g.cEt()), 0);
                C22391f cEk = C39952b.cEk();
                cEk.syf++;
                cEk = C39952b.cEk();
                cEk.syg++;
            }
            C43683g.this.syO.mo69334tO(cEu);
            C35988ay.m59201au(C4996ah.getContext(), C25738R.string.ev3);
            AppMethodBeat.m2505o(25810);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.g$5 */
    class C294205 implements C23496a {
        C294205() {
        }

        /* renamed from: BI */
        public final boolean mo39161BI() {
            AppMethodBeat.m2504i(25809);
            if (C43683g.this.nwu == 0 || C5046bo.isNullOrNil(C43683g.this.syD)) {
                C4990ab.m7421w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(C43683g.this.nwu), C43683g.this.syD);
                C43683g.this.syM = null;
                AppMethodBeat.m2505o(25809);
                return false;
            }
            String g = C43683g.this.syD;
            int e = C43683g.this.nwu;
            long f = C43683g.this.nwv;
            C43683g c43683g = C43683g.this;
            C43683g.this.syD;
            C9638aw.m17182Rg().mo14541a(new C39947e(g, e, f, c43683g.cEt()), 0);
            AppMethodBeat.m2505o(25809);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.g$1 */
    class C352811 implements ServiceConnection {

        /* renamed from: com.tencent.mm.plugin.talkroom.model.g$1$1 */
        class C223921 implements Runnable {
            C223921() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25800);
                C43683g.this.mo69327mb(true);
                AppMethodBeat.m2505o(25800);
            }
        }

        C352811() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(25801);
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "onServiceConnected ");
            if (iBinder == null) {
                C43683g.this.syO.mo69332l("enterTalkRoom bindServie or protocalInit failed", 3, -1);
                AppMethodBeat.m2505o(25801);
                return;
            }
            C43683g.this.syI = C22379a.m34100C(iBinder);
            if (C43683g.this.state >= 2) {
                new C7306ak(Looper.getMainLooper()).post(new C223921());
            }
            AppMethodBeat.m2505o(25801);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(25802);
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
            AppMethodBeat.m2505o(25802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.g$2 */
    class C352822 extends C39949a {

        /* renamed from: com.tencent.mm.plugin.talkroom.model.g$2$1 */
        class C223931 implements Runnable {
            C223931() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25803);
                C43683g.m78252c(C43683g.this);
                AppMethodBeat.m2505o(25803);
            }
        }

        /* renamed from: com.tencent.mm.plugin.talkroom.model.g$2$2 */
        class C352832 implements Runnable {
            C352832() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25804);
                C43683g.this.cEw();
                AppMethodBeat.m2505o(25804);
            }
        }

        C352822() {
        }

        public final void keep_OnOpenSuccess() {
            AppMethodBeat.m2504i(25805);
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
            if (C43683g.this.state != 1) {
                C4990ab.m7421w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", Integer.valueOf(C43683g.this.state));
                AppMethodBeat.m2505o(25805);
                return;
            }
            C39952b.cEk().cEp();
            new C7306ak(Looper.getMainLooper()).post(new C223931());
            C43683g.m78254d(C43683g.this);
            C43683g.this.syO.akC();
            AppMethodBeat.m2505o(25805);
        }

        public final void keep_OnError(int i) {
            AppMethodBeat.m2504i(25806);
            C4990ab.m7413e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", Integer.valueOf(i));
            C39952b.cEk().cEp();
            C39952b.cEk().sxX = 1;
            C43683g.this.syO.mo69332l("component OnError ".concat(String.valueOf(i)), 99, i);
            new C7306ak(Looper.getMainLooper()).post(new C352832());
            AppMethodBeat.m2505o(25806);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.g$3 */
    class C436843 implements C5015a {
        C436843() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25807);
            int e = C43683g.this.nwu;
            long f = C43683g.this.nwv;
            String g = C43683g.this.syD;
            C43683g c43683g = C43683g.this;
            C43683g.this.syD;
            C9638aw.m17182Rg().mo14541a(new C46294d(e, f, 1, g, c43683g.cEt()), 0);
            AppMethodBeat.m2505o(25807);
            return true;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m78252c(C43683g c43683g) {
        AppMethodBeat.m2504i(25842);
        c43683g.m78262ma(true);
        AppMethodBeat.m2505o(25842);
    }

    /* renamed from: c */
    static /* synthetic */ void m78253c(C43683g c43683g, int i) {
        AppMethodBeat.m2504i(25845);
        c43683g.m78244Fu(i);
        AppMethodBeat.m2505o(25845);
    }

    /* renamed from: d */
    static /* synthetic */ void m78254d(C43683g c43683g) {
        AppMethodBeat.m2504i(25843);
        c43683g.cEy();
        AppMethodBeat.m2505o(25843);
    }

    public C43683g() {
        AppMethodBeat.m2504i(25811);
        TalkRoomReceiver.init();
        AppMethodBeat.m2505o(25811);
    }

    public final int cEt() {
        AppMethodBeat.m2504i(25812);
        if (this.syA == 1 || (C25859d.fUu != null && C25859d.fUu.mo20565tQ(this.syD))) {
            AppMethodBeat.m2505o(25812);
            return 1;
        }
        AppMethodBeat.m2505o(25812);
        return 0;
    }

    public final List bJF() {
        AppMethodBeat.m2504i(25813);
        LinkedList tM = C39952b.cEi().mo4624tM(this.syD);
        AppMethodBeat.m2505o(25813);
        return tM;
    }

    public final String cEu() {
        AppMethodBeat.m2504i(25814);
        Iterator it = C39952b.cEi().mo4624tM(this.syD).iterator();
        while (it.hasNext()) {
            cgm cgm = (cgm) it.next();
            if (cgm.xft == this.syG) {
                String str = cgm.jBB;
                AppMethodBeat.m2505o(25814);
                return str;
            }
        }
        AppMethodBeat.m2505o(25814);
        return null;
    }

    /* renamed from: a */
    public final void mo4626a(C32336d c32336d) {
        AppMethodBeat.m2504i(25815);
        C43686i c43686i = this.syO;
        synchronized (c32336d) {
            try {
                if (c43686i.callbacks.contains(c32336d)) {
                } else {
                    c43686i.callbacks.add(c32336d);
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(25815);
            }
        }
        this.syO.mo69334tO(cEu());
        AppMethodBeat.m2505o(25815);
    }

    /* renamed from: b */
    public final void mo4634b(C32336d c32336d) {
        AppMethodBeat.m2504i(25816);
        C43686i c43686i = this.syO;
        synchronized (c32336d) {
            try {
                c43686i.callbacks.remove(c32336d);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(25816);
            }
        }
    }

    private boolean cEv() {
        AppMethodBeat.m2504i(25817);
        if (cEt() == 1) {
            mo4634b(C39952b.cEg().sxK);
        } else {
            mo4626a(C39952b.cEg().sxK);
        }
        if (this.syB > 0) {
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "addListener has init before");
            AppMethodBeat.m2505o(25817);
        } else {
            C9638aw.m17182Rg().mo14539a(332, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(334, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(336, (C1202f) this);
            C9638aw.m17182Rg().mo14539a(335, (C1202f) this);
            C39952b.cEi().mo4620a(this);
            C9638aw.m17176Cc().mo4650a(this);
            this.syB = 1;
            if (this.syI != null) {
                try {
                    this.syI.Close();
                    this.syI.uninitLive();
                } catch (RemoteException e) {
                    C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            C4996ah.getContext().bindService(new Intent(C4996ah.getContext(), TalkRoomService.class), this.ktl, 1);
            this.syJ = new C352822();
            AppMethodBeat.m2505o(25817);
        }
        return true;
    }

    private void removeListener() {
        AppMethodBeat.m2504i(25818);
        this.syB = 0;
        C9638aw.m17182Rg().mo14546b(332, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(334, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(336, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(335, (C1202f) this);
        C39952b.cEi().mo4623b(this);
        C9638aw.m17176Cc().mo4651b(this);
        mo4634b(C39952b.cEg().sxK);
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.syI != null) {
            try {
                i = this.syI.uninitLive();
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        C4996ah.getContext().unbindService(this.ktl);
        C4996ah.getContext().stopService(new Intent(C4996ah.getContext(), TalkRoomService.class));
        this.syI = null;
        if (i < 0) {
            C4990ab.m7413e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(25818);
    }

    /* renamed from: ac */
    public final void mo4627ac(String str, int i) {
        AppMethodBeat.m2504i(25819);
        C4990ab.m7417i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", str, Integer.valueOf(i));
        this.syA = i;
        cEv();
        if (str.equals(this.syD)) {
            C4990ab.m7411d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", str);
            if (this.state == 2) {
                this.syO.akC();
            }
            AppMethodBeat.m2505o(25819);
            return;
        }
        C4990ab.m7411d("MicroMsg.TalkRoomServer", "%s enter the talkroom", str);
        this.syD = str;
        C9638aw.m17182Rg().mo14541a(new C13929a(this.syD, cEt()), 0);
        C39952b.cEg().sxM = new C22391f();
        C39952b.cEk().syu = C5046bo.m7588yz();
        C39952b.cEk().syr = str;
        if (cEt() == 0) {
            C39952b.cEg().sxK.nNp = true;
        }
        C43686i c43686i = this.syO;
        C4368711 c4368711 = new C4368711(str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c4368711.run();
            AppMethodBeat.m2505o(25819);
            return;
        }
        c43686i.handler.post(c4368711);
        AppMethodBeat.m2505o(25819);
    }

    public final void cEw() {
        AppMethodBeat.m2504i(25820);
        C4990ab.m7416i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        m78262ma(false);
        if (C5046bo.isNullOrNil(this.syD)) {
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            AppMethodBeat.m2505o(25820);
            return;
        }
        C39952b.cEk().cEq();
        this.state = 0;
        this.syC = false;
        C9638aw.m17182Rg().mo14541a(new C46293b(this.nwu, this.nwv, this.nwu != 0 ? this.syD : "", cEt()), 0);
        if (this.syI != null) {
            int Close;
            try {
                Close = this.syI.Close();
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = QbSdk.EXTENSION_INIT_FAILURE;
            }
            if (Close < 0) {
                C4990ab.m7413e("MicroMsg.TalkRoomServer", "engine.Close error %d", Integer.valueOf(Close));
            }
            PByteArray pByteArray = new PByteArray();
            if (m78246a(pByteArray, C1854s.m3866mJ(this.syD)) == 0) {
                C4990ab.m7417i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", Integer.valueOf(pByteArray.value.length), new String(pByteArray.value));
                LinkedList linkedList = new LinkedList();
                cgn cgn = new cgn();
                cgn.wBd = 10402;
                cgn.xfu = new bts().alV(r1);
                cgn cgn2 = new cgn();
                cgn2.wBd = 10404;
                cgn2.xfu = new bts().alV(C39952b.cEk().toString());
                linkedList.add(cgn);
                linkedList.add(cgn2);
                C9638aw.m17182Rg().mo14541a(new C22378g(linkedList, cEt()), 0);
            }
        }
        this.syD = "";
        this.nwu = 0;
        this.nwv = 0;
        this.syE = 0;
        this.syF = 0;
        this.syG = 0;
        this.syH.clear();
        cEx();
        this.syO.akE();
        C39952b.cEg().sxK.cEm();
        removeListener();
        AppMethodBeat.m2505o(25820);
    }

    private void cEx() {
        AppMethodBeat.m2504i(25821);
        if (this.syK != null) {
            try {
                this.syK.release();
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.syK = null;
        }
        if (this.syL != null) {
            try {
                this.syL.release();
            } catch (RemoteException e2) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.syL = null;
        }
        if (this.syM != null) {
            this.syM.stopTimer();
            this.syM = null;
        }
        if (this.syN != null) {
            this.syN.stopTimer();
            this.syN = null;
        }
        AppMethodBeat.m2505o(25821);
    }

    /* renamed from: ma */
    private void m78262ma(boolean z) {
        AppMethodBeat.m2504i(25822);
        if (C5046bo.isNullOrNil(this.syD)) {
            AppMethodBeat.m2505o(25822);
            return;
        }
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ(this.syD);
        if (aoZ == null) {
            AppMethodBeat.m2505o(25822);
            return;
        }
        int i;
        if (z) {
            i = 5;
        } else {
            i = 6;
        }
        aoZ.mo14743eE(C43298a.m77176a(aoZ, i, aoZ.field_conversationTime));
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15767a(aoZ, this.syD);
        AppMethodBeat.m2505o(25822);
    }

    public final boolean akz() {
        AppMethodBeat.m2504i(25823);
        C4990ab.m7416i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.syO.mo69331g(3, -1, "seizeMic in outside room state");
            }
            AppMethodBeat.m2505o(25823);
            return false;
        }
        if (this.syK != null) {
            try {
                this.syK.cpN();
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        C9638aw.m17182Rg().mo14541a(new C46294d(this.nwu, this.nwv, 1, this.syD, cEt()), 0);
        C39952b.cEk().syw = C5046bo.m7588yz();
        C39952b.cEk().syz = true;
        AppMethodBeat.m2505o(25823);
        return true;
    }

    public final void akA() {
        AppMethodBeat.m2504i(25824);
        C4990ab.m7416i("MicroMsg.TalkRoomServer", "putAwayMic");
        C22391f cEk = C39952b.cEk();
        if (cEk.syz && !cEk.syy) {
            cEk.syt++;
        }
        cEk.syy = false;
        cEk.syz = false;
        if (this.state < 3) {
            C4990ab.m7420w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            AppMethodBeat.m2505o(25824);
            return;
        }
        if (this.syN != null) {
            this.syN.stopTimer();
            this.syN = null;
        }
        cEy();
        C9638aw.m17182Rg().mo14541a(new C46294d(this.nwu, this.nwv, 2, this.syD, cEt()), 0);
        AppMethodBeat.m2505o(25824);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25825);
        C4990ab.m7417i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        C29415f c29415f = (C29415f) c1207m;
        if (c29415f.cED() == null || !c29415f.cED().equals(this.syD)) {
            C4990ab.m7421w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", c29415f.cED(), this.syD);
            AppMethodBeat.m2505o(25825);
            return;
        }
        C22391f cEk;
        if (!(i == 0 && i2 == 0)) {
            if (c1207m.getType() == 332) {
                C39952b.cEk().mo37928Fs(2);
                if (i == 4) {
                    C39952b.cEk().sys = i2;
                }
                this.syO.mo69332l("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                cEw();
                AppMethodBeat.m2505o(25825);
                return;
            } else if (c1207m.getType() == 334) {
                if (((C46294d) c1207m).actionType != 1) {
                    AppMethodBeat.m2505o(25825);
                    return;
                }
                cEk = C39952b.cEk();
                cEk.syb++;
                cEk.syw = 0;
                cEy();
                C4990ab.m7420w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                if (i == 4 && (i2 == C31128d.MIC_PTU_HONGKONG || i2 == 340)) {
                    this.syO.mo69333mk(i2);
                    AppMethodBeat.m2505o(25825);
                    return;
                }
                this.syO.mo69331g(i, i2, "TalkMicAction failed!!");
                AppMethodBeat.m2505o(25825);
                return;
            } else if (c1207m.getType() == 336) {
                this.syC = false;
                this.syO.mo69331g(i, i2, "TalkGetMember failed!!");
                cEw();
                AppMethodBeat.m2505o(25825);
                return;
            } else if (c1207m.getType() == 335) {
                this.syO.mo69331g(i, i2, "TalkNoop failed!!");
                cEw();
                AppMethodBeat.m2505o(25825);
                return;
            }
        }
        if (c1207m.getType() == 332) {
            C39952b.cEk().mo37928Fs(1);
            C13929a c13929a = (C13929a) c1207m;
            this.nwu = c13929a.nwu;
            this.nwv = c13929a.nwv;
            this.syE = c13929a.syE;
            this.syF = c13929a.syF;
            this.syH = c13929a.syH;
            cEk = C39952b.cEk();
            int i3 = this.nwu;
            long j = this.nwv;
            cEk.nwu = i3;
            cEk.nwv = j;
            C39952b.cEi().mo4621a(this.syD, c13929a.sza, null, null, c29415f.cEE());
            m78243Ft(100);
            AppMethodBeat.m2505o(25825);
        } else if (c1207m.getType() == 334) {
            C46294d c46294d = (C46294d) c1207m;
            if (c46294d.actionType == 1) {
                cEk = C39952b.cEk();
                if (cEk.syw != 0) {
                    cEk.sxZ = (C5046bo.m7525az(cEk.syw) + (cEk.sxZ * ((long) cEk.syv))) / ((long) (cEk.syv + 1));
                    cEk.syv++;
                    cEk.sya++;
                    cEk.syw = 0;
                }
                C4990ab.m7416i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (c46294d.syE < this.syE) {
                    C4990ab.m7421w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", Integer.valueOf(c46294d.syE), Integer.valueOf(this.syE));
                    cEy();
                    this.syO.mo69333mk(C31128d.MIC_PTU_HONGKONG);
                    AppMethodBeat.m2505o(25825);
                    return;
                }
                this.syE = c46294d.syE;
                int i4 = QbSdk.EXTENSION_INIT_FAILURE;
                try {
                    i4 = this.syI.SetCurrentMicId(this.syE);
                } catch (RemoteException e) {
                    C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    C4990ab.m7416i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    AppMethodBeat.m2505o(25825);
                    return;
                }
                C43686i c43686i = this.syO;
                C352846 c352846 = new C352846();
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    c352846.run();
                } else {
                    c43686i.handler.post(c352846);
                }
                this.state = 4;
                if (i4 < 0) {
                    C4990ab.m7413e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", Integer.valueOf(i4));
                }
                if (this.syN == null) {
                    this.syN = new C7564ap(new C436843(), true);
                    this.syN.mo16770ae(5000, 5000);
                }
                AppMethodBeat.m2505o(25825);
                return;
            }
            C4990ab.m7416i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
            AppMethodBeat.m2505o(25825);
        } else {
            if (c1207m.getType() == 336) {
                C39946c c39946c = (C39946c) c1207m;
                C39952b.cEi().mo4621a(this.syD, c39946c.sza, null, null, c29415f.cEE());
                m78244Fu(c39946c.syE);
                this.syC = false;
                this.syO.mo69334tO(cEu());
            }
            if (c1207m.getType() == 335 && this.state == 0) {
                this.syO.mo69331g(3, -1, "talknoop success but in outside room state");
            }
            AppMethodBeat.m2505o(25825);
        }
    }

    private void cEy() {
        AppMethodBeat.m2504i(25826);
        try {
            C39952b.cEk().cEs();
            if (this.syL != null) {
                this.syL.cEd();
            }
            if (this.syK != null) {
                this.syK.cEf();
            }
            this.state = 2;
            AppMethodBeat.m2505o(25826);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            AppMethodBeat.m2505o(25826);
        }
    }

    public final void akw() {
        AppMethodBeat.m2504i(25827);
        C4990ab.m7417i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", Integer.valueOf(this.state));
        if (this.state != 4) {
            AppMethodBeat.m2505o(25827);
            return;
        }
        C22391f cEk = C39952b.cEk();
        cEk.syy = true;
        cEk.syx = C5046bo.m7588yz();
        try {
            this.syL.akw();
            AppMethodBeat.m2505o(25827);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            AppMethodBeat.m2505o(25827);
        }
    }

    /* renamed from: Ft */
    private void m78243Ft(final int i) {
        AppMethodBeat.m2504i(25828);
        if (this.syI != null) {
            try {
                cEz();
                AppMethodBeat.m2505o(25828);
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                AppMethodBeat.m2505o(25828);
            }
        } else if (i == 0) {
            this.syO.mo69332l("bind talkroomService timeout", 3, -1);
            AppMethodBeat.m2505o(25828);
        } else {
            new C7306ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(25808);
                    C43683g.m78249a(C43683g.this, i - 1);
                    AppMethodBeat.m2505o(25808);
                }
            }, 50);
            AppMethodBeat.m2505o(25828);
        }
    }

    private void cEz() {
        AppMethodBeat.m2504i(25829);
        this.state = 1;
        this.syC = false;
        if (cEA()) {
            cEx();
            cEC();
            cEB();
            if (this.syM != null) {
                C4990ab.m7420w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                AppMethodBeat.m2505o(25829);
                return;
            }
            this.syM = new C35986af(new C294205());
            this.syM.dow();
            AppMethodBeat.m2505o(25829);
            return;
        }
        AppMethodBeat.m2505o(25829);
    }

    private boolean cEA() {
        AppMethodBeat.m2504i(25830);
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        try {
            i = this.syI.cEb();
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        C4990ab.m7416i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            AppMethodBeat.m2505o(25830);
            return true;
        }
        this.syI = null;
        C4990ab.m7415f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", Integer.valueOf(i));
        this.syO.mo69332l("enterTalkRoom protocalInit failed", 3, -1);
        AppMethodBeat.m2505o(25830);
        return false;
    }

    /* renamed from: Fu */
    private void m78244Fu(int i) {
        AppMethodBeat.m2504i(25831);
        if (i > this.syE) {
            this.syE = i;
            if (this.state >= 3) {
                this.syO.mo69333mk(C31128d.MIC_PTU_HONGKONG);
            }
            cEy();
        }
        AppMethodBeat.m2505o(25831);
    }

    /* renamed from: mb */
    public final void mo69327mb(boolean z) {
        AppMethodBeat.m2504i(25832);
        C4990ab.m7417i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", this.syD);
        if (C5046bo.isNullOrNil(this.syD) || this.state < 2) {
            AppMethodBeat.m2505o(25832);
            return;
        }
        C39952b.cEk().cEr();
        if (z) {
            if (cEA()) {
                try {
                    cEB();
                } catch (RemoteException e) {
                    C4990ab.m7412e("MicroMsg.TalkRoomServer", e.toString());
                    C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            } else {
                AppMethodBeat.m2505o(25832);
                return;
            }
        }
        cEy();
        this.state = 1;
        try {
            if (this.syI != null) {
                this.syI.Close();
            }
        } catch (RemoteException e2) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
        }
        if (this.nwu != 0) {
            cEC();
        }
        if (!z) {
            this.syO.akH();
        }
        AppMethodBeat.m2505o(25832);
    }

    private void cEB() {
        AppMethodBeat.m2504i(25833);
        if (this.syI == null) {
            C4990ab.m7412e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            AppMethodBeat.m2505o(25833);
            return;
        }
        this.syK = this.syI.mo26146a(new C139346());
        this.syK.start();
        this.syL = this.syI.cEc();
        this.syL.start();
        AppMethodBeat.m2505o(25833);
    }

    private void cEC() {
        AppMethodBeat.m2504i(25835);
        if (this.syH.size() == 0) {
            C4990ab.m7412e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.syO.mo69331g(3, -1, "engine.talk relay addr list empty");
            AppMethodBeat.m2505o(25835);
            return;
        }
        int[] iArr = new int[this.syH.size()];
        int[] iArr2 = new int[this.syH.size()];
        C4990ab.m7417i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", Integer.valueOf(this.syH.size()));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.syH.size()) {
                break;
            }
            iArr[i2] = ((cgl) this.syH.get(i2)).xfs;
            iArr2[i2] = ((cgl) this.syH.get(i2)).wOO;
            C4990ab.m7417i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", C43683g.m78245Fv(((cgl) this.syH.get(i2)).xfs), Integer.valueOf(((cgl) this.syH.get(i2)).wOO));
            i = i2 + 1;
        }
        C4990ab.m7417i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", Integer.valueOf(this.syF), Integer.valueOf(this.nwu), Long.valueOf(this.nwv));
        try {
            C39948a c39948a = this.syI;
            C46295b c46295b = this.syJ;
            C9638aw.m17190ZK();
            i = c39948a.mo26145a(c46295b, C18628c.m29064QF(), this.syF, this.nwu, this.nwv, iArr, iArr2, 0);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            i = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (i < 0 && i != -3) {
            C4990ab.m7413e("MicroMsg.TalkRoomServer", "engine.Open error %d", Integer.valueOf(i));
            this.syO.mo69331g(3, i, "engine.Open error");
        }
        AppMethodBeat.m2505o(25835);
    }

    public final short akx() {
        short s = (short) 0;
        AppMethodBeat.m2504i(25836);
        if (this.syL == null) {
            AppMethodBeat.m2505o(25836);
            return s;
        }
        try {
            s = (short) this.syL.cEe();
            AppMethodBeat.m2505o(25836);
            return s;
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            AppMethodBeat.m2505o(25836);
            return s;
        }
    }

    public final short aky() {
        short s = (short) 0;
        AppMethodBeat.m2504i(25837);
        if (this.syK == null) {
            AppMethodBeat.m2505o(25837);
            return s;
        }
        try {
            s = (short) this.syK.cEe();
            AppMethodBeat.m2505o(25837);
            return s;
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            AppMethodBeat.m2505o(25837);
            return s;
        }
    }

    /* renamed from: a */
    private int m78246a(PByteArray pByteArray, String str) {
        AppMethodBeat.m2504i(25838);
        if (this.syI != null) {
            int[] iArr = new int[1];
            try {
                pByteArray.value = this.syI.mo26150e(iArr, str);
            } catch (RemoteException e) {
                iArr[0] = QbSdk.EXTENSION_INIT_FAILURE;
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            int i = iArr[0];
            AppMethodBeat.m2505o(25838);
            return i;
        }
        AppMethodBeat.m2505o(25838);
        return -99;
    }

    /* renamed from: k */
    public final void mo14628k(String str, String str2, String str3) {
        AppMethodBeat.m2504i(25839);
        if (str.equals(this.syD)) {
            C43686i c43686i = this.syO;
            C3995410 c3995410 = new C3995410(str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c3995410.run();
                AppMethodBeat.m2505o(25839);
                return;
            }
            c43686i.handler.post(c3995410);
            AppMethodBeat.m2505o(25839);
            return;
        }
        AppMethodBeat.m2505o(25839);
    }

    public final boolean akB() {
        return this.syR;
    }

    /* renamed from: Fv */
    private static String m78245Fv(int i) {
        AppMethodBeat.m2504i(25834);
        try {
            String hostAddress = InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
            AppMethodBeat.m2505o(25834);
            return hostAddress;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            AppMethodBeat.m2505o(25834);
            return null;
        }
    }

    /* renamed from: Zs */
    public final void mo44182Zs() {
        AppMethodBeat.m2504i(25840);
        C4990ab.m7418v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (C5046bo.isNullOrNil(this.syD)) {
            C4990ab.m7410d("MicroMsg.TalkRoomServer", "pause");
        } else {
            cEy();
        }
        this.syR = false;
        C43686i c43686i = this.syO;
        C294213 c294213 = new C294213();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c294213.run();
            AppMethodBeat.m2505o(25840);
            return;
        }
        c43686i.handler.post(c294213);
        AppMethodBeat.m2505o(25840);
    }

    /* renamed from: Zt */
    public final void mo44183Zt() {
        AppMethodBeat.m2504i(25841);
        C4990ab.m7418v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (C5046bo.isNullOrNil(this.syD)) {
                C4990ab.m7410d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.syL != null) {
                    this.syL.cEd();
                }
                if (this.syK != null) {
                    this.syK.cpN();
                }
                this.state = 2;
            }
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.syR = true;
        C43686i c43686i = this.syO;
        C139352 c139352 = new C139352();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c139352.run();
            AppMethodBeat.m2505o(25841);
            return;
        }
        c43686i.handler.post(c139352);
        AppMethodBeat.m2505o(25841);
    }
}
