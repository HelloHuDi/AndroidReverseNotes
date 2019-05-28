package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v4.app.v;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.c.d;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class VoipCSMainUI extends MMActivity implements b, com.tencent.mm.plugin.voip_cs.b.b.a.a {
    private String appId = "";
    public String cEh = ah.getContext().getString(R.string.f53);
    public String cQL = "";
    private com.tencent.mm.compatible.util.b cqx;
    private ak fbD;
    public String gEl = "";
    private TelephonyManager nva;
    PhoneStateListener nvb = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.i(135393);
            ab.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
            if (i == 2) {
                ab.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
                c.cMg().tdg = 4;
                VoipCSMainUI.this.GV(7);
            }
            AppMethodBeat.o(135393);
        }
    };
    private n qbK = new n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(135398);
            ab.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(i)));
            if (c.cMf().tdM == 2 && (i == 4 || i == 6)) {
                e cMf = c.cMf();
                com.tencent.mm.plugin.voip_cs.b.a aVar = c.cMe().tew;
                if (cMf.sPz == 0) {
                    cMf.sPz = aVar.sTX;
                }
                int netType = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
                if (netType != cMf.sPz) {
                    ab.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + cMf.sPz + " to " + netType);
                    try {
                        byte[] bArr = new byte[4];
                        bArr[0] = (byte) netType;
                        int appCmd = aVar.setAppCmd(301, bArr, 4);
                        if (appCmd < 0) {
                            ab.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + aVar.nwC + ", roomkey=" + aVar.nwv + "]");
                        }
                        cmm cmm = new cmm();
                        cmm.xko = 3;
                        cmm.xkp = new com.tencent.mm.bt.b(bArr, 0, 1);
                        aVar.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
                    } catch (Exception e) {
                        ab.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                    }
                    cMf.sPz = netType;
                }
                f cMf2 = c.cMf();
                ab.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + c.cMe().tew.sTZ + "roomkey:" + c.cMe().tew.nwv);
                g.Rg().a(285, cMf2);
                com.tencent.mm.plugin.voip_cs.b.a aVar2 = c.cMe().tew;
                g.Rg().a(new d(aVar2.sTZ, aVar2.nwv), 0);
            }
            AppMethodBeat.o(135398);
        }
    };
    private HeadsetPlugReceiver sRd = null;
    private BroadcastReceiver sSj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(135392);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) ah.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                ab.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
                VoipCSMainUI.this.teA.cAY = false;
                AppMethodBeat.o(135392);
                return;
            }
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                ab.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
                VoipCSMainUI.this.teA.cAY = false;
                if (!VoipCSMainUI.this.tdT.cKq() && c.cMf().tdM == 2) {
                    VoipCSMainUI.this.tdT.cMo();
                    AppMethodBeat.o(135392);
                    return;
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                ab.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
                VoipCSMainUI.this.teA.cAY = true;
                if (!VoipCSMainUI.this.tdT.cKq()) {
                    VoipCSMainUI.this.tdT.stopRing();
                }
            }
            AppMethodBeat.o(135392);
        }
    };
    private HeadsetPlugReceiver.a sSk = new HeadsetPlugReceiver.a() {
        public final void fS(boolean z) {
            AppMethodBeat.i(135391);
            ab.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", Boolean.valueOf(z));
            if (VoipCSMainUI.this.teC == z) {
                ab.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
                AppMethodBeat.o(135391);
                return;
            }
            VoipCSMainUI.this.teC = z;
            if (z) {
                VoipCSMainUI.this.teB.mr(false);
                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.f7f), 0).show();
                AppMethodBeat.o(135391);
                return;
            }
            VoipCSMainUI.this.teB.mr(true);
            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.f7g), 0).show();
            AppMethodBeat.o(135391);
        }
    };
    public String tdN = "";
    private com.tencent.mm.plugin.voip_cs.b.a.a tdT;
    private com.tencent.mm.plugin.voip_cs.b.a.b teA;
    private com.tencent.mm.plugin.voip_cs.b.a.c teB;
    private boolean teC = false;
    public String teD = "";
    public String teE = "";
    public String teF = "";
    public boolean teG = false;
    private ap teH = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(135406);
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 44, new Intent(ah.getContext(), VoipCSMainUI.class), 134217728);
            v.c e = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(VoipCSMainUI.this.tickerText).d(VoipCSMainUI.this.title).e(VoipCSMainUI.this.cEh);
            e.EI = activity;
            e.k(2, true);
            Notification build = e.build();
            build.icon = com.tencent.mm.bo.a.bWV();
            build.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, build, false);
            AppMethodBeat.o(135406);
            return true;
        }
    }, true);
    com.tencent.mm.compatible.b.g.a teI = new com.tencent.mm.compatible.b.g.a() {
        public final void gE(int i) {
            AppMethodBeat.i(135390);
            ab.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d", Integer.valueOf(i));
            switch (i) {
                case 1:
                    VoipCSMainUI.this.teB.mr(false);
                    AppMethodBeat.o(135390);
                    return;
                case 2:
                    com.tencent.mm.compatible.b.g.KK().KN();
                    VoipCSMainUI.this.teB.mr(true);
                    AppMethodBeat.o(135390);
                    return;
                case 3:
                    com.tencent.mm.compatible.b.g.KK().KM();
                    AppMethodBeat.o(135390);
                    return;
                case 4:
                    com.tencent.mm.compatible.b.g.KK().KN();
                    VoipCSMainUI.this.teB.mr(true);
                    AppMethodBeat.o(135390);
                    return;
                case 5:
                    com.tencent.mm.compatible.b.g.KK().KM();
                    break;
            }
            AppMethodBeat.o(135390);
        }
    };
    public CharSequence tickerText = ah.getContext().getString(R.string.f53);
    public CharSequence title = ah.getContext().getString(R.string.f4x);
    public String type = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoipCSMainUI() {
        AppMethodBeat.i(135407);
        AppMethodBeat.o(135407);
    }

    static /* synthetic */ boolean a(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.i(135424);
        boolean cMA = voipCSMainUI.cMA();
        AppMethodBeat.o(135424);
        return cMA;
    }

    static /* synthetic */ void b(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.i(135425);
        voipCSMainUI.cMz();
        AppMethodBeat.o(135425);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(135408);
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.tdN = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.cQL = bo.nullAsNil(getIntent().getStringExtra("voipCSScene"));
        this.type = bo.nullAsNil(getIntent().getStringExtra("voipCSType"));
        this.teD = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.teE = getIntent().getStringExtra("voipCSShowOther");
        this.gEl = getIntent().getStringExtra("voipCSAvatarUrl");
        this.teF = getIntent().getStringExtra("voipCSContext");
        this.teG = getIntent().getBooleanExtra("launch_from_appbrand", false);
        getWindow().addFlags(6946944);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.fbD = new ak();
        com.tencent.mm.plugin.voip_cs.b.d cMg = c.cMg();
        ab.d("MicroMsg.VoipCSReportHelper", "reset");
        cMg.dataType = 0;
        cMg.tcO = 0;
        cMg.tcP = 0;
        cMg.tcQ = 0;
        cMg.videoFps = 0;
        cMg.tcR = 0;
        cMg.tcS = 0;
        cMg.tcT = 0;
        cMg.tcU = 0;
        cMg.tcV = 0;
        cMg.tcW = 0;
        cMg.networkType = 0;
        cMg.tcX = 0;
        cMg.tcY = com.tencent.mm.plugin.voip_cs.b.d.tcM;
        cMg.tcZ = 0;
        cMg.tda = 0;
        cMg.nwv = 0;
        cMg.tdb = "";
        cMg.sTX = 0;
        cMg.tde = 0;
        cMg.tdf = 0;
        cMg.tdg = 0;
        cMg.sUr = 0;
        cMg.sUq = 0;
        cMg.tdh = 0;
        cMg.tdi = 0;
        cMg.tdj = 0;
        cMg.tdk = 0;
        cMg.tdl = 0;
        cMg.tdm = 0;
        cMg.tdn = 0;
        cMg.tdo = 0;
        cMg.tdp = 0;
        cMg.tdq = 0;
        cMg.tdr = 0;
        cMg.nxM = 0;
        cMg.tds = 0;
        cMg.tdt = 0;
        cMg.channelStrategy = 1;
        cMg.sVG = 0;
        cMg.sUs = 0;
        cMg.tdu = 0;
        cMg.tdv = 0;
        cMg.nxW = "";
        cMg.nxV = "";
        cMg.tdz = 0;
        cMg.tdA = 0;
        cMg.tdB = 0;
        cMg.tdC = 0;
        cMg.tdD = 0;
        this.nva = (TelephonyManager) ah.getContext().getSystemService("phone");
        c.cMf().tdN = this.tdN;
        this.teA = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
        this.teB = new com.tencent.mm.plugin.voip_cs.b.a.c();
        this.cqx = new com.tencent.mm.compatible.util.b(ah.getContext());
        this.tdT = com.tencent.mm.plugin.voip_cs.b.a.a.cMm();
        c.cMe().tey = this;
        c.cMf().tdF = this;
        if (c.cMf().tdM == 0 || c.cMf().tdM == 3) {
            c.cMf().tdM = 0;
        }
        com.tencent.mm.booter.a.Ib().Id();
        this.cqx.requestFocus();
        com.tencent.mm.compatible.b.g.KK().KM();
        com.tencent.mm.compatible.b.g.KK().a(this.teI);
        this.sRd = new HeadsetPlugReceiver();
        this.sRd.a(ah.getContext(), this.sSk);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ah.getContext().registerReceiver(this.sSj, intentFilter);
        g.RO().a(this.qbK);
        if (this.teG) {
            if (this.cQL.equals("1")) {
                if (this.type.equals("video")) {
                    this.title = ah.getContext().getString(R.string.f4v);
                    this.tickerText = ah.getContext().getString(R.string.f4z);
                    this.cEh = ah.getContext().getString(R.string.f4z);
                } else {
                    this.title = ah.getContext().getString(R.string.f4w);
                    this.tickerText = ah.getContext().getString(R.string.f50);
                    this.cEh = ah.getContext().getString(R.string.f50);
                }
            } else if (this.type.equals("video")) {
                this.title = ah.getContext().getString(R.string.f4x);
                this.tickerText = ah.getContext().getString(R.string.f51);
                this.cEh = ah.getContext().getString(R.string.f51);
            } else {
                this.title = ah.getContext().getString(R.string.f4w);
                this.tickerText = ah.getContext().getString(R.string.f50);
                this.cEh = ah.getContext().getString(R.string.f50);
            }
        } else if (this.cQL.equals("1")) {
            if (this.type.equals("video")) {
                this.title = ah.getContext().getString(R.string.f4v);
                this.tickerText = ah.getContext().getString(R.string.f4z);
                this.cEh = ah.getContext().getString(R.string.f4z);
            } else {
                this.title = ah.getContext().getString(R.string.f4w);
                this.tickerText = ah.getContext().getString(R.string.f53);
                this.cEh = ah.getContext().getString(R.string.f53);
            }
        } else if (this.type.equals("video")) {
            this.title = ah.getContext().getString(R.string.f4x);
            this.tickerText = ah.getContext().getString(R.string.f53);
            this.cEh = ah.getContext().getString(R.string.f53);
        } else {
            this.title = ah.getContext().getString(R.string.f4w);
            this.tickerText = ah.getContext().getString(R.string.f52);
            this.cEh = ah.getContext().getString(R.string.f52);
        }
        int callState = this.nva.getCallState();
        if (callState == 2 || callState == 1) {
            ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", Integer.valueOf(callState));
            h.a((Context) this, (int) R.string.f59, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(135389);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.GV(0);
                    AppMethodBeat.o(135389);
                }
            });
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ab.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            AppMethodBeat.o(135408);
            return;
        }
        this.nva.listen(this.nvb, 32);
        if (!at.isNetworkConnected(this)) {
            ab.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            h.a((Context) this, (int) R.string.f55, (int) R.string.f6g, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(135403);
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.GV(9);
                    AppMethodBeat.o(135403);
                }
            });
            z = false;
        } else if (at.isWifi((Context) this) || q.cJV()) {
            z = true;
        } else {
            ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            h.a((Context) this, (int) R.string.f56, (int) R.string.f6g, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(135404);
                    ab.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
                    q.cJU();
                    if (VoipCSMainUI.a(VoipCSMainUI.this)) {
                        VoipCSMainUI.b(VoipCSMainUI.this);
                    }
                    AppMethodBeat.o(135404);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(135405);
                    ab.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
                    dialogInterface.dismiss();
                    VoipCSMainUI.this.GV(8);
                    AppMethodBeat.o(135405);
                }
            });
            z = false;
        }
        if (z) {
            if (com.tencent.mm.plugin.voip.a.d.cLx()) {
                ab.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
                h.a((Context) this, (int) R.string.cdq, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(135399);
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.GV(0);
                        AppMethodBeat.o(135399);
                    }
                });
                callState = 1;
            } else if (com.tencent.mm.plugin.voip.a.d.cLw()) {
                ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
                h.a((Context) this, (int) R.string.cdr, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(135400);
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.GV(0);
                        AppMethodBeat.o(135400);
                    }
                });
                callState = 1;
            } else if (com.tencent.mm.r.a.Oo()) {
                ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
                h.a((Context) this, (int) R.string.cdl, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(135401);
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.GV(0);
                        AppMethodBeat.o(135401);
                    }
                });
                callState = 1;
            } else if (com.tencent.mm.bg.e.akK()) {
                ab.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
                h.a((Context) this, (int) R.string.cdm, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(135402);
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.GV(0);
                        AppMethodBeat.o(135402);
                    }
                });
                callState = 1;
            } else {
                z = false;
            }
            if (callState != 0) {
                ab.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
                AppMethodBeat.o(135408);
                return;
            }
            if (cMA()) {
                cMz();
            }
            AppMethodBeat.o(135408);
            return;
        }
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
        AppMethodBeat.o(135408);
    }

    private void cMz() {
        AppMethodBeat.i(135409);
        if (c.cMf().tdM <= 0) {
            this.teA.cMp();
            this.teA.cMq();
            c.cMe().init();
            c.cMf().ao(this.tdN, this.appId, this.teF);
        }
        if (c.cMf().tdM < 2) {
            this.tdT.cMo();
        }
        this.teA.cMt();
        AppMethodBeat.o(135409);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(135410);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.o(135410);
            return true;
        } else if (i == 25) {
            com.tencent.mm.compatible.b.g.KK().iK(bHJ());
            AppMethodBeat.o(135410);
            return true;
        } else if (i == 24) {
            com.tencent.mm.compatible.b.g.KK().iJ(bHJ());
            AppMethodBeat.o(135410);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(135410);
            return onKeyDown;
        }
    }

    private int bHJ() {
        int i = 2;
        AppMethodBeat.i(135411);
        if (com.tencent.mm.compatible.b.g.KK().KP()) {
            i = com.tencent.mm.compatible.b.g.KK().Lc();
        } else if (this.tdT.cKq()) {
            if (c.cMf().tdM == 2) {
                i = 0;
            } else {
                i = this.teB.cIt();
            }
        }
        ab.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", Integer.valueOf(i));
        AppMethodBeat.o(135411);
        return i;
    }

    public void onResume() {
        AppMethodBeat.i(135412);
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.teA != null) {
            this.teA.cAY = false;
            if (c.cMf().tdM > 1) {
                cMz();
                if (this.teE != null && this.teE.equals("1")) {
                    this.teA.cMw();
                }
            }
        }
        if (this.teH != null) {
            this.teH.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        AppMethodBeat.o(135412);
    }

    public void onPause() {
        AppMethodBeat.i(135413);
        super.onPause();
        if (!this.tdT.cKq()) {
            this.tdT.stopRing();
        }
        if (c.cMf().tdM == 1 || c.cMf().tdM == 2) {
            Intent intent = new Intent(ah.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.tdN);
            intent.putExtra("voipCSAppId", this.appId);
            intent.putExtra("voipCSScene", this.cQL);
            intent.putExtra("voipCSType", this.type);
            intent.putExtra("voipCSAllowBackCamera", this.teD);
            intent.putExtra("voipCSShowOther", this.teE);
            intent.putExtra("voipCSAvatarUrl", this.gEl);
            intent.putExtra("voipCSContext", this.teF);
            intent.putExtra("launch_from_appbrand", this.teG);
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 44, intent, 134217728);
            v.c e = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(this.tickerText).j(System.currentTimeMillis()).d(this.title).e(this.cEh);
            e.EI = activity;
            e.k(2, true);
            Notification build = e.build();
            build.icon = com.tencent.mm.bo.a.bWV();
            build.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, build, false);
            if (this.teH != null && this.teH.doT()) {
                this.teH.ae(5000, 5000);
            }
        } else {
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
            if (this.teH != null) {
                this.teH.stopTimer();
            }
        }
        this.teA.cMu();
        this.teA.cAY = true;
        AppMethodBeat.o(135413);
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        AppMethodBeat.i(135414);
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (cMA() && c.cMf().tdM <= 1) {
            cMz();
        }
        if (this.teA != null) {
            this.teA.cAY = false;
        }
        AppMethodBeat.o(135414);
    }

    public void onStop() {
        AppMethodBeat.i(135415);
        super.onStop();
        AppMethodBeat.o(135415);
    }

    public void onDestroy() {
        int i;
        int i2 = 2;
        AppMethodBeat.i(135416);
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
        if (this.cqx != null) {
            this.cqx.Mm();
        }
        sh shVar = new sh();
        if (c.cMf().tdO == -1) {
            shVar.cOB.status = 3;
        } else if (c.cMf().tdO == 823) {
            shVar.cOB.status = 4;
        } else if (c.cMf().tdM <= 1) {
            shVar.cOB.status = 1;
        } else if (c.cMf().tdM >= 2) {
            shVar.cOB.status = 2;
        }
        com.tencent.mm.sdk.b.a.xxA.m(shVar);
        com.tencent.mm.plugin.voip_cs.b.a.c cVar = this.teB;
        com.tencent.mm.plugin.voip_cs.b.d cMg = c.cMg();
        if (cVar.sPL == null || c.cMg().tdl != 1) {
            i = 0;
        } else {
            i = cVar.sPL.cIt();
        }
        cMg.tdv = (int) ((((float) com.tencent.mm.compatible.b.g.KK().getStreamVolume(i)) / ((float) com.tencent.mm.compatible.b.g.KK().getStreamMaxVolume(i))) * 100.0f);
        cMg = c.cMg();
        if (cVar.kzb == null || c.cMg().tdl != 1) {
            i = 0;
        } else {
            i = cVar.kzb.EO();
        }
        cMg.sUs = i;
        if (cVar.kzb != null) {
            cVar.kzb.EB();
        }
        if (cVar.sPL != null) {
            cVar.sPL.cIr();
        }
        this.tdT.stopRing();
        if (this.teA != null) {
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.teA;
            if (c.cMg().dataType == 0) {
                if (c.cMf().tdM < 2) {
                    c.cMg().dataType = 1;
                } else {
                    c.cMg().dataType = 3;
                }
            }
            bVar.sWU.cLI();
            bVar.sWV.cLI();
            bVar.cMu();
            bVar.cMx();
            f cMf = c.cMf();
            ab.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            g.Rg().b(823, cMf);
            g.Rg().b(106, cMf);
            g.Rg().b(818, cMf);
            g.Rg().b(795, cMf);
            g.Rg().b(285, cMf);
            g.Rg().b(312, cMf);
            cMf.tdM = 3;
            if (cMf.tdO != 823) {
                g.Rg().a(880, cMf);
                if (cMf.tdH == 0) {
                    i2 = 1;
                } else if (cMf.tdH != 2) {
                    if (cMf.tdH == 3) {
                        i2 = 3;
                    } else {
                        i2 = 4;
                    }
                }
                ab.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + cMf.tdN + ",inviteId：" + c.cMe().tew.nwx + ",csroomId:" + c.cMe().tew.sTZ + ",roomkey:" + c.cMe().tew.nwv + ",reason:" + i2);
                g.Rg().a(new com.tencent.mm.plugin.voip_cs.b.c.a(c.cMe().tew.nwx, c.cMe().tew.sTZ, c.cMe().tew.nwv, cMf.tdN, i2), 0);
            }
            cMf.tdQ.stopTimer();
            cMf.tdR.stopTimer();
            cMf.tdG = 0;
            cMf.tdc = 0;
            cMf.tdH = 0;
            cMf.tdI = 0;
            cMf.tdJ = null;
            cMf.nwE = 0;
            cMf.tdK = 0;
            cMf.tdM = 0;
            cMf.tdN = "";
            cMf.tdL = 0;
            cMf.tdO = 0;
            cMf.tdP = 999;
            com.tencent.mm.plugin.voip_cs.b.b.a cMe = c.cMe();
            ab.i("MicroMsg.VoipCSEngine", "now stop engine");
            cMe.tew.mx(true);
            com.tencent.mm.plugin.voip_cs.b.d cMg2 = c.cMg();
            if (bo.isNullOrNil(cMg2.nxW) && bo.isNullOrNil(cMg2.nxV)) {
                com.tencent.mm.plugin.voip_cs.b.a aVar = c.cMe().tew;
                if (cMg2.tdj == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                aVar.getVoipcsChannelInfo(aVar.tcD, aVar.tcD.length, i != 0 ? 1 : 0);
                ab.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", Integer.valueOf(aVar.field_voipcsChannelInfoLength));
                cMg2.nxW = new String(aVar.tcD, 0, aVar.field_voipcsChannelInfoLength);
                cMg2.nxV = c.cMe().tew.cMb();
                ab.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", cMg2.nxW);
                ab.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", cMg2.nxV);
            }
            g.Rg().a(312, c.cMf());
            g.Rg().a(new com.tencent.mm.plugin.voip_cs.b.c.e(c.cMe().tew.sTZ, c.cMe().tew.nwv), 0);
            cMe.tew.reset();
            p.cJR().cJT();
            p.cJR().a(null);
        }
        this.teA = null;
        this.teB = null;
        com.tencent.mm.compatible.b.g.KK().setMode(0);
        ah.getContext().unregisterReceiver(this.sSj);
        com.tencent.mm.compatible.b.g.KK().b(this.teI);
        com.tencent.mm.compatible.b.g.KK().KN();
        if (this.sRd != null) {
            this.sRd.fa(ah.getContext());
        }
        g.RO().b(this.qbK);
        if (this.teH != null) {
            this.teH.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if (!(this.nva == null || this.nvb == null)) {
            this.nva.listen(this.nvb, 0);
            this.nvb = null;
        }
        super.onDestroy();
        AppMethodBeat.o(135416);
    }

    public final int getLayoutId() {
        return R.layout.b2d;
    }

    public final void GV(int i) {
        AppMethodBeat.i(135417);
        ab.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i + ",CallingStatus:" + c.cMf().tdM);
        if (c.cMf().tdM == 0) {
            finish();
            AppMethodBeat.o(135417);
            return;
        }
        if (this.teA != null) {
            this.teA.GY(i);
        }
        AppMethodBeat.o(135417);
    }

    public final void onError(int i) {
        AppMethodBeat.i(135418);
        if (this.teA != null) {
            ab.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(i)));
            this.teA.GY(i);
        }
        AppMethodBeat.o(135418);
    }

    public final void gF(String str, String str2) {
        AppMethodBeat.i(135419);
        com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.teA;
        if (!bVar.tel.equals("") || !bo.isNullOrNil(str2)) {
            bVar.acd(str2);
        } else if (bVar.tdU.teG) {
            bVar.ejp.setText(R.string.f4k);
        } else {
            bVar.ejp.setText(R.string.f4j);
        }
        if (bVar.tek.equals("") && bo.isNullOrNil(str) && (bVar.tdU.gEl == null || bVar.tdU.gEl.equals(""))) {
            bVar.tea.setImageResource(R.drawable.ad2);
            AppMethodBeat.o(135419);
            return;
        }
        SharedPreferences doB = ah.doB();
        if (!(bo.isNullOrNil(str) || bVar.tek.equals(str))) {
            bVar.ace(str);
            doB.edit().putString(bVar.cMr(), str).commit();
        }
        if (!(bo.isNullOrNil(str2) || bVar.tel.equals(str2))) {
            bVar.acd(str2);
            doB.edit().putString(bVar.cMs(), str2).commit();
        }
        AppMethodBeat.o(135419);
    }

    private boolean cMA() {
        AppMethodBeat.i(135420);
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            ab.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")), bo.dpG(), this);
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
                AppMethodBeat.o(135420);
                return true;
            }
            ab.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            AppMethodBeat.o(135420);
            return false;
        }
        ab.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
        AppMethodBeat.o(135420);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(135421);
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            ab.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i));
            AppMethodBeat.o(135421);
            return;
        }
        ab.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(135396);
                            dialogInterface.dismiss();
                            VoipCSMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(135396);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(135397);
                            dialogInterface.dismiss();
                            VoipCSMainUI.this.GV(3);
                            AppMethodBeat.o(135397);
                        }
                    });
                    break;
                }
                cMz();
                AppMethodBeat.o(135421);
                return;
            case 82:
                if (iArr[0] == 0) {
                    ab.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
                        cMz();
                    }
                    AppMethodBeat.o(135421);
                    return;
                }
                h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(135394);
                        VoipCSMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        AppMethodBeat.o(135394);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(135395);
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.GV(2);
                        AppMethodBeat.o(135395);
                    }
                });
                AppMethodBeat.o(135421);
                return;
        }
        AppMethodBeat.o(135421);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bGQ() {
        int i;
        com.tencent.mm.plugin.voip_cs.b.d cMg;
        AppMethodBeat.i(135422);
        this.teA.bGQ();
        if (com.tencent.mm.compatible.b.g.KK().KV() || com.tencent.mm.compatible.b.g.KK().KP()) {
            this.teB.mr(false);
        } else {
            this.teB.mr(true);
        }
        com.tencent.mm.plugin.voip_cs.b.a.c cVar = this.teB;
        if (cVar.kzb != null) {
            boolean EL = cVar.kzb.EL();
            c.cMg().tdl = 1;
            if (EL) {
                i = 1;
                c.cMg().tdE = i;
                cVar = this.teB;
                if (cVar.sPL != null) {
                    c.cMe().tew.sUn = Math.abs(1);
                } else {
                    cVar.sPL.cIp();
                    if (cVar.sPL.cIp() <= 0) {
                        c.cMe().tew.sUn = Math.abs(1);
                    }
                }
                this.tdT.stopRing();
                cMg = c.cMg();
                if (cMg.tdz != 0) {
                    cMg.tdo = ((int) (System.currentTimeMillis() / 1000)) - cMg.tdz;
                }
                cMg = c.cMg();
                ab.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
                if (cMg.tdC == 0) {
                    cMg.tdC = (int) (System.currentTimeMillis() / 1000);
                }
                cMg = c.cMg();
                ab.d("MicroMsg.VoipCSReportHelper", "markConnect");
                if (cMg.tdB != 0) {
                    cMg.tdq = (long) (((int) (System.currentTimeMillis() / 1000)) - cMg.tdB);
                }
                AppMethodBeat.o(135422);
            }
        }
        i = -1;
        c.cMg().tdE = i;
        cVar = this.teB;
        if (cVar.sPL != null) {
        }
        this.tdT.stopRing();
        cMg = c.cMg();
        if (cMg.tdz != 0) {
        }
        cMg = c.cMg();
        ab.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
        if (cMg.tdC == 0) {
        }
        cMg = c.cMg();
        ab.d("MicroMsg.VoipCSReportHelper", "markConnect");
        if (cMg.tdB != 0) {
        }
        AppMethodBeat.o(135422);
    }

    public final void cMy() {
        AppMethodBeat.i(135423);
        ab.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.teA.GY(5);
        AppMethodBeat.o(135423);
    }
}
