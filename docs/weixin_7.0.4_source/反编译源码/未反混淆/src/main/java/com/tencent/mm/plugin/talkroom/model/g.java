package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.a;
import com.tencent.mm.bg.c;
import com.tencent.mm.model.af;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.component.e;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass10;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass11;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.QbSdk;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements f, a, c, af {
    public static final int[] syP = new int[]{80, 8080, 16285};
    public static final byte[][] syQ = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    private final ServiceConnection ktl = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(25801);
            ab.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
            if (iBinder == null) {
                g.this.syO.l("enterTalkRoom bindServie or protocalInit failed", 3, -1);
                AppMethodBeat.o(25801);
                return;
            }
            g.this.syI = com.tencent.mm.plugin.talkroom.component.a.a.C(iBinder);
            if (g.this.state >= 2) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25800);
                        g.this.mb(true);
                        AppMethodBeat.o(25800);
                    }
                });
            }
            AppMethodBeat.o(25801);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(25802);
            ab.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
            AppMethodBeat.o(25802);
        }
    };
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
    private com.tencent.mm.plugin.talkroom.component.a syI;
    private b syJ;
    private e syK;
    private d syL;
    private com.tencent.mm.sdk.platformtools.af syM;
    private ap syN;
    private i syO = new i();
    public boolean syR = false;

    static /* synthetic */ void c(g gVar) {
        AppMethodBeat.i(25842);
        gVar.ma(true);
        AppMethodBeat.o(25842);
    }

    static /* synthetic */ void c(g gVar, int i) {
        AppMethodBeat.i(25845);
        gVar.Fu(i);
        AppMethodBeat.o(25845);
    }

    static /* synthetic */ void d(g gVar) {
        AppMethodBeat.i(25843);
        gVar.cEy();
        AppMethodBeat.o(25843);
    }

    public g() {
        AppMethodBeat.i(25811);
        TalkRoomReceiver.init();
        AppMethodBeat.o(25811);
    }

    public final int cEt() {
        AppMethodBeat.i(25812);
        if (this.syA == 1 || (com.tencent.mm.bh.d.fUu != null && com.tencent.mm.bh.d.fUu.tQ(this.syD))) {
            AppMethodBeat.o(25812);
            return 1;
        }
        AppMethodBeat.o(25812);
        return 0;
    }

    public final List bJF() {
        AppMethodBeat.i(25813);
        LinkedList tM = b.cEi().tM(this.syD);
        AppMethodBeat.o(25813);
        return tM;
    }

    public final String cEu() {
        AppMethodBeat.i(25814);
        Iterator it = b.cEi().tM(this.syD).iterator();
        while (it.hasNext()) {
            cgm cgm = (cgm) it.next();
            if (cgm.xft == this.syG) {
                String str = cgm.jBB;
                AppMethodBeat.o(25814);
                return str;
            }
        }
        AppMethodBeat.o(25814);
        return null;
    }

    public final void a(com.tencent.mm.bg.d dVar) {
        AppMethodBeat.i(25815);
        i iVar = this.syO;
        synchronized (dVar) {
            try {
                if (iVar.callbacks.contains(dVar)) {
                } else {
                    iVar.callbacks.add(dVar);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(25815);
            }
        }
        this.syO.tO(cEu());
        AppMethodBeat.o(25815);
    }

    public final void b(com.tencent.mm.bg.d dVar) {
        AppMethodBeat.i(25816);
        i iVar = this.syO;
        synchronized (dVar) {
            try {
                iVar.callbacks.remove(dVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(25816);
            }
        }
    }

    private boolean cEv() {
        AppMethodBeat.i(25817);
        if (cEt() == 1) {
            b(b.cEg().sxK);
        } else {
            a(b.cEg().sxK);
        }
        if (this.syB > 0) {
            ab.i("MicroMsg.TalkRoomServer", "addListener has init before");
            AppMethodBeat.o(25817);
        } else {
            aw.Rg().a(332, (f) this);
            aw.Rg().a(334, (f) this);
            aw.Rg().a(336, (f) this);
            aw.Rg().a(335, (f) this);
            b.cEi().a(this);
            aw.Cc().a(this);
            this.syB = 1;
            if (this.syI != null) {
                try {
                    this.syI.Close();
                    this.syI.uninitLive();
                } catch (RemoteException e) {
                    ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            ah.getContext().bindService(new Intent(ah.getContext(), TalkRoomService.class), this.ktl, 1);
            this.syJ = new b.a() {
                public final void keep_OnOpenSuccess() {
                    AppMethodBeat.i(25805);
                    ab.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
                    if (g.this.state != 1) {
                        ab.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", Integer.valueOf(g.this.state));
                        AppMethodBeat.o(25805);
                        return;
                    }
                    b.cEk().cEp();
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(25803);
                            g.c(g.this);
                            AppMethodBeat.o(25803);
                        }
                    });
                    g.d(g.this);
                    g.this.syO.akC();
                    AppMethodBeat.o(25805);
                }

                public final void keep_OnError(int i) {
                    AppMethodBeat.i(25806);
                    ab.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", Integer.valueOf(i));
                    b.cEk().cEp();
                    b.cEk().sxX = 1;
                    g.this.syO.l("component OnError ".concat(String.valueOf(i)), 99, i);
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(25804);
                            g.this.cEw();
                            AppMethodBeat.o(25804);
                        }
                    });
                    AppMethodBeat.o(25806);
                }
            };
            AppMethodBeat.o(25817);
        }
        return true;
    }

    private void removeListener() {
        AppMethodBeat.i(25818);
        this.syB = 0;
        aw.Rg().b(332, (f) this);
        aw.Rg().b(334, (f) this);
        aw.Rg().b(336, (f) this);
        aw.Rg().b(335, (f) this);
        b.cEi().b(this);
        aw.Cc().b(this);
        b(b.cEg().sxK);
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.syI != null) {
            try {
                i = this.syI.uninitLive();
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        ah.getContext().unbindService(this.ktl);
        ah.getContext().stopService(new Intent(ah.getContext(), TalkRoomService.class));
        this.syI = null;
        if (i < 0) {
            ab.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", Integer.valueOf(i));
        }
        AppMethodBeat.o(25818);
    }

    public final void ac(String str, int i) {
        AppMethodBeat.i(25819);
        ab.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", str, Integer.valueOf(i));
        this.syA = i;
        cEv();
        if (str.equals(this.syD)) {
            ab.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", str);
            if (this.state == 2) {
                this.syO.akC();
            }
            AppMethodBeat.o(25819);
            return;
        }
        ab.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", str);
        this.syD = str;
        aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.a(this.syD, cEt()), 0);
        b.cEg().sxM = new f();
        b.cEk().syu = bo.yz();
        b.cEk().syr = str;
        if (cEt() == 0) {
            b.cEg().sxK.nNp = true;
        }
        i iVar = this.syO;
        AnonymousClass11 anonymousClass11 = new AnonymousClass11(str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass11.run();
            AppMethodBeat.o(25819);
            return;
        }
        iVar.handler.post(anonymousClass11);
        AppMethodBeat.o(25819);
    }

    public final void cEw() {
        AppMethodBeat.i(25820);
        ab.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        ma(false);
        if (bo.isNullOrNil(this.syD)) {
            ab.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            AppMethodBeat.o(25820);
            return;
        }
        b.cEk().cEq();
        this.state = 0;
        this.syC = false;
        aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.b(this.nwu, this.nwv, this.nwu != 0 ? this.syD : "", cEt()), 0);
        if (this.syI != null) {
            int Close;
            try {
                Close = this.syI.Close();
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = QbSdk.EXTENSION_INIT_FAILURE;
            }
            if (Close < 0) {
                ab.e("MicroMsg.TalkRoomServer", "engine.Close error %d", Integer.valueOf(Close));
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, s.mJ(this.syD)) == 0) {
                ab.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", Integer.valueOf(pByteArray.value.length), new String(pByteArray.value));
                LinkedList linkedList = new LinkedList();
                cgn cgn = new cgn();
                cgn.wBd = 10402;
                cgn.xfu = new bts().alV(r1);
                cgn cgn2 = new cgn();
                cgn2.wBd = 10404;
                cgn2.xfu = new bts().alV(b.cEk().toString());
                linkedList.add(cgn);
                linkedList.add(cgn2);
                aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, cEt()), 0);
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
        b.cEg().sxK.cEm();
        removeListener();
        AppMethodBeat.o(25820);
    }

    private void cEx() {
        AppMethodBeat.i(25821);
        if (this.syK != null) {
            try {
                this.syK.release();
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.syK = null;
        }
        if (this.syL != null) {
            try {
                this.syL.release();
            } catch (RemoteException e2) {
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
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
        AppMethodBeat.o(25821);
    }

    private void ma(boolean z) {
        AppMethodBeat.i(25822);
        if (bo.isNullOrNil(this.syD)) {
            AppMethodBeat.o(25822);
            return;
        }
        aw.ZK();
        com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(this.syD);
        if (aoZ == null) {
            AppMethodBeat.o(25822);
            return;
        }
        int i;
        if (z) {
            i = 5;
        } else {
            i = 6;
        }
        aoZ.eE(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aoZ, i, aoZ.field_conversationTime));
        aw.ZK();
        com.tencent.mm.model.c.XR().a(aoZ, this.syD);
        AppMethodBeat.o(25822);
    }

    public final boolean akz() {
        AppMethodBeat.i(25823);
        ab.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            ab.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.syO.g(3, -1, "seizeMic in outside room state");
            }
            AppMethodBeat.o(25823);
            return false;
        }
        if (this.syK != null) {
            try {
                this.syK.cpN();
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.d(this.nwu, this.nwv, 1, this.syD, cEt()), 0);
        b.cEk().syw = bo.yz();
        b.cEk().syz = true;
        AppMethodBeat.o(25823);
        return true;
    }

    public final void akA() {
        AppMethodBeat.i(25824);
        ab.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f cEk = b.cEk();
        if (cEk.syz && !cEk.syy) {
            cEk.syt++;
        }
        cEk.syy = false;
        cEk.syz = false;
        if (this.state < 3) {
            ab.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            AppMethodBeat.o(25824);
            return;
        }
        if (this.syN != null) {
            this.syN.stopTimer();
            this.syN = null;
        }
        cEy();
        aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.d(this.nwu, this.nwv, 2, this.syD, cEt()), 0);
        AppMethodBeat.o(25824);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25825);
        ab.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        com.tencent.mm.plugin.talkroom.b.f fVar = (com.tencent.mm.plugin.talkroom.b.f) mVar;
        if (fVar.cED() == null || !fVar.cED().equals(this.syD)) {
            ab.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", fVar.cED(), this.syD);
            AppMethodBeat.o(25825);
            return;
        }
        f cEk;
        if (!(i == 0 && i2 == 0)) {
            if (mVar.getType() == 332) {
                b.cEk().Fs(2);
                if (i == 4) {
                    b.cEk().sys = i2;
                }
                this.syO.l("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                cEw();
                AppMethodBeat.o(25825);
                return;
            } else if (mVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) mVar).actionType != 1) {
                    AppMethodBeat.o(25825);
                    return;
                }
                cEk = b.cEk();
                cEk.syb++;
                cEk.syw = 0;
                cEy();
                ab.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                if (i == 4 && (i2 == com.tencent.view.d.MIC_PTU_HONGKONG || i2 == 340)) {
                    this.syO.mk(i2);
                    AppMethodBeat.o(25825);
                    return;
                }
                this.syO.g(i, i2, "TalkMicAction failed!!");
                AppMethodBeat.o(25825);
                return;
            } else if (mVar.getType() == 336) {
                this.syC = false;
                this.syO.g(i, i2, "TalkGetMember failed!!");
                cEw();
                AppMethodBeat.o(25825);
                return;
            } else if (mVar.getType() == 335) {
                this.syO.g(i, i2, "TalkNoop failed!!");
                cEw();
                AppMethodBeat.o(25825);
                return;
            }
        }
        if (mVar.getType() == 332) {
            b.cEk().Fs(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) mVar;
            this.nwu = aVar.nwu;
            this.nwv = aVar.nwv;
            this.syE = aVar.syE;
            this.syF = aVar.syF;
            this.syH = aVar.syH;
            cEk = b.cEk();
            int i3 = this.nwu;
            long j = this.nwv;
            cEk.nwu = i3;
            cEk.nwv = j;
            b.cEi().a(this.syD, aVar.sza, null, null, fVar.cEE());
            Ft(100);
            AppMethodBeat.o(25825);
        } else if (mVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) mVar;
            if (dVar.actionType == 1) {
                cEk = b.cEk();
                if (cEk.syw != 0) {
                    cEk.sxZ = (bo.az(cEk.syw) + (cEk.sxZ * ((long) cEk.syv))) / ((long) (cEk.syv + 1));
                    cEk.syv++;
                    cEk.sya++;
                    cEk.syw = 0;
                }
                ab.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.syE < this.syE) {
                    ab.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", Integer.valueOf(dVar.syE), Integer.valueOf(this.syE));
                    cEy();
                    this.syO.mk(com.tencent.view.d.MIC_PTU_HONGKONG);
                    AppMethodBeat.o(25825);
                    return;
                }
                this.syE = dVar.syE;
                int i4 = QbSdk.EXTENSION_INIT_FAILURE;
                try {
                    i4 = this.syI.SetCurrentMicId(this.syE);
                } catch (RemoteException e) {
                    ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    ab.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    AppMethodBeat.o(25825);
                    return;
                }
                i iVar = this.syO;
                com.tencent.mm.plugin.talkroom.model.i.AnonymousClass6 anonymousClass6 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25852);
                        synchronized (i.this.callbacks) {
                            try {
                                for (com.tencent.mm.bg.d akD : i.this.callbacks) {
                                    akD.akD();
                                }
                            } finally {
                                AppMethodBeat.o(25852);
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass6.run();
                } else {
                    iVar.handler.post(anonymousClass6);
                }
                this.state = 4;
                if (i4 < 0) {
                    ab.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", Integer.valueOf(i4));
                }
                if (this.syN == null) {
                    this.syN = new ap(new ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(25807);
                            int e = g.this.nwu;
                            long f = g.this.nwv;
                            String g = g.this.syD;
                            g gVar = g.this;
                            g.this.syD;
                            aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.d(e, f, 1, g, gVar.cEt()), 0);
                            AppMethodBeat.o(25807);
                            return true;
                        }
                    }, true);
                    this.syN.ae(5000, 5000);
                }
                AppMethodBeat.o(25825);
                return;
            }
            ab.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
            AppMethodBeat.o(25825);
        } else {
            if (mVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) mVar;
                b.cEi().a(this.syD, cVar.sza, null, null, fVar.cEE());
                Fu(cVar.syE);
                this.syC = false;
                this.syO.tO(cEu());
            }
            if (mVar.getType() == 335 && this.state == 0) {
                this.syO.g(3, -1, "talknoop success but in outside room state");
            }
            AppMethodBeat.o(25825);
        }
    }

    private void cEy() {
        AppMethodBeat.i(25826);
        try {
            b.cEk().cEs();
            if (this.syL != null) {
                this.syL.cEd();
            }
            if (this.syK != null) {
                this.syK.cEf();
            }
            this.state = 2;
            AppMethodBeat.o(25826);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            AppMethodBeat.o(25826);
        }
    }

    public final void akw() {
        AppMethodBeat.i(25827);
        ab.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", Integer.valueOf(this.state));
        if (this.state != 4) {
            AppMethodBeat.o(25827);
            return;
        }
        f cEk = b.cEk();
        cEk.syy = true;
        cEk.syx = bo.yz();
        try {
            this.syL.akw();
            AppMethodBeat.o(25827);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            AppMethodBeat.o(25827);
        }
    }

    private void Ft(final int i) {
        AppMethodBeat.i(25828);
        if (this.syI != null) {
            try {
                cEz();
                AppMethodBeat.o(25828);
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                AppMethodBeat.o(25828);
            }
        } else if (i == 0) {
            this.syO.l("bind talkroomService timeout", 3, -1);
            AppMethodBeat.o(25828);
        } else {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25808);
                    g.a(g.this, i - 1);
                    AppMethodBeat.o(25808);
                }
            }, 50);
            AppMethodBeat.o(25828);
        }
    }

    private void cEz() {
        AppMethodBeat.i(25829);
        this.state = 1;
        this.syC = false;
        if (cEA()) {
            cEx();
            cEC();
            cEB();
            if (this.syM != null) {
                ab.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                AppMethodBeat.o(25829);
                return;
            }
            this.syM = new com.tencent.mm.sdk.platformtools.af(new com.tencent.mm.sdk.platformtools.af.a() {
                public final boolean BI() {
                    AppMethodBeat.i(25809);
                    if (g.this.nwu == 0 || bo.isNullOrNil(g.this.syD)) {
                        ab.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(g.this.nwu), g.this.syD);
                        g.this.syM = null;
                        AppMethodBeat.o(25809);
                        return false;
                    }
                    String g = g.this.syD;
                    int e = g.this.nwu;
                    long f = g.this.nwv;
                    g gVar = g.this;
                    g.this.syD;
                    aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.e(g, e, f, gVar.cEt()), 0);
                    AppMethodBeat.o(25809);
                    return true;
                }
            });
            this.syM.dow();
            AppMethodBeat.o(25829);
            return;
        }
        AppMethodBeat.o(25829);
    }

    private boolean cEA() {
        AppMethodBeat.i(25830);
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        try {
            i = this.syI.cEb();
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        ab.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            AppMethodBeat.o(25830);
            return true;
        }
        this.syI = null;
        ab.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", Integer.valueOf(i));
        this.syO.l("enterTalkRoom protocalInit failed", 3, -1);
        AppMethodBeat.o(25830);
        return false;
    }

    private void Fu(int i) {
        AppMethodBeat.i(25831);
        if (i > this.syE) {
            this.syE = i;
            if (this.state >= 3) {
                this.syO.mk(com.tencent.view.d.MIC_PTU_HONGKONG);
            }
            cEy();
        }
        AppMethodBeat.o(25831);
    }

    public final void mb(boolean z) {
        AppMethodBeat.i(25832);
        ab.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", this.syD);
        if (bo.isNullOrNil(this.syD) || this.state < 2) {
            AppMethodBeat.o(25832);
            return;
        }
        b.cEk().cEr();
        if (z) {
            if (cEA()) {
                try {
                    cEB();
                } catch (RemoteException e) {
                    ab.e("MicroMsg.TalkRoomServer", e.toString());
                    ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            } else {
                AppMethodBeat.o(25832);
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
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
        }
        if (this.nwu != 0) {
            cEC();
        }
        if (!z) {
            this.syO.akH();
        }
        AppMethodBeat.o(25832);
    }

    private void cEB() {
        AppMethodBeat.i(25833);
        if (this.syI == null) {
            ab.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            AppMethodBeat.o(25833);
            return;
        }
        this.syK = this.syI.a(new com.tencent.mm.plugin.talkroom.component.c.a() {
            public final void p(int i, int i2, boolean z) {
                AppMethodBeat.i(25810);
                if (z) {
                    g.this.syG = 0;
                    g.this.syO.tO("");
                    AppMethodBeat.o(25810);
                    return;
                }
                g.c(g.this, i2);
                if (g.this.syG == i) {
                    AppMethodBeat.o(25810);
                    return;
                }
                g.this.syG = i;
                String cEu = g.this.cEu();
                if (!g.this.syC && cEu == null) {
                    g.this.syC = true;
                    int e = g.this.nwu;
                    long f = g.this.nwv;
                    String g = g.this.syD;
                    g gVar = g.this;
                    g.this.syD;
                    aw.Rg().a(new com.tencent.mm.plugin.talkroom.b.c(e, f, g, gVar.cEt()), 0);
                    f cEk = b.cEk();
                    cEk.syf++;
                    cEk = b.cEk();
                    cEk.syg++;
                }
                g.this.syO.tO(cEu);
                ay.au(ah.getContext(), R.string.ev3);
                AppMethodBeat.o(25810);
            }
        });
        this.syK.start();
        this.syL = this.syI.cEc();
        this.syL.start();
        AppMethodBeat.o(25833);
    }

    private void cEC() {
        AppMethodBeat.i(25835);
        if (this.syH.size() == 0) {
            ab.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.syO.g(3, -1, "engine.talk relay addr list empty");
            AppMethodBeat.o(25835);
            return;
        }
        int[] iArr = new int[this.syH.size()];
        int[] iArr2 = new int[this.syH.size()];
        ab.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", Integer.valueOf(this.syH.size()));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.syH.size()) {
                break;
            }
            iArr[i2] = ((cgl) this.syH.get(i2)).xfs;
            iArr2[i2] = ((cgl) this.syH.get(i2)).wOO;
            ab.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", Fv(((cgl) this.syH.get(i2)).xfs), Integer.valueOf(((cgl) this.syH.get(i2)).wOO));
            i = i2 + 1;
        }
        ab.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", Integer.valueOf(this.syF), Integer.valueOf(this.nwu), Long.valueOf(this.nwv));
        try {
            com.tencent.mm.plugin.talkroom.component.a aVar = this.syI;
            b bVar = this.syJ;
            aw.ZK();
            i = aVar.a(bVar, com.tencent.mm.model.c.QF(), this.syF, this.nwu, this.nwv, iArr, iArr2, 0);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            i = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (i < 0 && i != -3) {
            ab.e("MicroMsg.TalkRoomServer", "engine.Open error %d", Integer.valueOf(i));
            this.syO.g(3, i, "engine.Open error");
        }
        AppMethodBeat.o(25835);
    }

    public final short akx() {
        short s = (short) 0;
        AppMethodBeat.i(25836);
        if (this.syL == null) {
            AppMethodBeat.o(25836);
            return s;
        }
        try {
            s = (short) this.syL.cEe();
            AppMethodBeat.o(25836);
            return s;
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            AppMethodBeat.o(25836);
            return s;
        }
    }

    public final short aky() {
        short s = (short) 0;
        AppMethodBeat.i(25837);
        if (this.syK == null) {
            AppMethodBeat.o(25837);
            return s;
        }
        try {
            s = (short) this.syK.cEe();
            AppMethodBeat.o(25837);
            return s;
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            AppMethodBeat.o(25837);
            return s;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        AppMethodBeat.i(25838);
        if (this.syI != null) {
            int[] iArr = new int[1];
            try {
                pByteArray.value = this.syI.e(iArr, str);
            } catch (RemoteException e) {
                iArr[0] = QbSdk.EXTENSION_INIT_FAILURE;
                ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            int i = iArr[0];
            AppMethodBeat.o(25838);
            return i;
        }
        AppMethodBeat.o(25838);
        return -99;
    }

    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(25839);
        if (str.equals(this.syD)) {
            i iVar = this.syO;
            AnonymousClass10 anonymousClass10 = new AnonymousClass10(str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass10.run();
                AppMethodBeat.o(25839);
                return;
            }
            iVar.handler.post(anonymousClass10);
            AppMethodBeat.o(25839);
            return;
        }
        AppMethodBeat.o(25839);
    }

    public final boolean akB() {
        return this.syR;
    }

    private static String Fv(int i) {
        AppMethodBeat.i(25834);
        try {
            String hostAddress = InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
            AppMethodBeat.o(25834);
            return hostAddress;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            AppMethodBeat.o(25834);
            return null;
        }
    }

    public final void Zs() {
        AppMethodBeat.i(25840);
        ab.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (bo.isNullOrNil(this.syD)) {
            ab.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            cEy();
        }
        this.syR = false;
        i iVar = this.syO;
        com.tencent.mm.plugin.talkroom.model.i.AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25849);
                synchronized (i.this.callbacks) {
                    try {
                        for (com.tencent.mm.bg.d akG : i.this.callbacks) {
                            akG.akG();
                        }
                    } finally {
                        AppMethodBeat.o(25849);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass3.run();
            AppMethodBeat.o(25840);
            return;
        }
        iVar.handler.post(anonymousClass3);
        AppMethodBeat.o(25840);
    }

    public final void Zt() {
        AppMethodBeat.i(25841);
        ab.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (bo.isNullOrNil(this.syD)) {
                ab.d("MicroMsg.TalkRoomServer", "pause");
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
            ab.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.syR = true;
        i iVar = this.syO;
        com.tencent.mm.plugin.talkroom.model.i.AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25848);
                synchronized (i.this.callbacks) {
                    try {
                        for (com.tencent.mm.bg.d akF : i.this.callbacks) {
                            akF.akF();
                        }
                    } finally {
                        AppMethodBeat.o(25848);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
            AppMethodBeat.o(25841);
            return;
        }
        iVar.handler.post(anonymousClass2);
        AppMethodBeat.o(25841);
    }
}
