package com.tencent.p177mm.plugin.voip_cs.p549ui;

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
import android.support.p057v4.app.C0363v.C0358c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C32630sh;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver.C14032a;
import com.tencent.p177mm.plugin.voip.model.C14055q;
import com.tencent.p177mm.plugin.voip.model.C35355p;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C22488e;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43746a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43748b;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43750d;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C14096a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C14097d;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1046c.C46329e;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1310b.C43747a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p1310b.C43747a.C22486a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p548a.C43744a;
import com.tencent.p177mm.plugin.voip_cs.p547b.p548a.C43745c;
import com.tencent.p177mm.plugin.voip_cs.p547b.p548a.C44768b;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.cmm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI */
public class VoipCSMainUI extends MMActivity implements C43748b, C22486a {
    private String appId = "";
    public String cEh = C4996ah.getContext().getString(C25738R.string.f53);
    public String cQL = "";
    private C45293b cqx;
    private C7306ak fbD;
    public String gEl = "";
    private TelephonyManager nva;
    PhoneStateListener nvb = new C43065();
    private C1923n qbK = new C4004710();
    private HeadsetPlugReceiver sRd = null;
    private BroadcastReceiver sSj = new C140994();
    private C14032a sSk = new C43053();
    public String tdN = "";
    private C43744a tdT;
    private C44768b teA;
    private C43745c teB;
    private boolean teC = false;
    public String teD = "";
    public String teE = "";
    public String teF = "";
    public boolean teG = false;
    private C7564ap teH = new C7564ap(Looper.getMainLooper(), new C2952618(), true);
    C1406a teI = new C71732();
    public CharSequence tickerText = C4996ah.getContext().getString(C25738R.string.f53);
    public CharSequence title = C4996ah.getContext().getString(C25738R.string.f4x);
    public String type = "";

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$3 */
    class C43053 implements C14032a {
        C43053() {
        }

        /* renamed from: fS */
        public final void mo9263fS(boolean z) {
            AppMethodBeat.m2504i(135391);
            C4990ab.m7411d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", Boolean.valueOf(z));
            if (VoipCSMainUI.this.teC == z) {
                C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
                AppMethodBeat.m2505o(135391);
                return;
            }
            VoipCSMainUI.this.teC = z;
            if (z) {
                VoipCSMainUI.this.teB.mo69452mr(false);
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.f7f), 0).show();
                AppMethodBeat.m2505o(135391);
                return;
            }
            VoipCSMainUI.this.teB.mo69452mr(true);
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.f7g), 0).show();
            AppMethodBeat.m2505o(135391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$5 */
    class C43065 extends PhoneStateListener {
        C43065() {
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.m2504i(135393);
            C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
            if (i == 2) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
                C43749c.cMg().tdg = 4;
                VoipCSMainUI.this.mo69456GV(7);
            }
            AppMethodBeat.m2505o(135393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$2 */
    class C71732 implements C1406a {
        C71732() {
        }

        /* renamed from: gE */
        public final void mo4815gE(int i) {
            AppMethodBeat.m2504i(135390);
            C4990ab.m7411d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d", Integer.valueOf(i));
            switch (i) {
                case 1:
                    VoipCSMainUI.this.teB.mo69452mr(false);
                    AppMethodBeat.m2505o(135390);
                    return;
                case 2:
                    C1407g.m2946KK().mo4818KN();
                    VoipCSMainUI.this.teB.mo69452mr(true);
                    AppMethodBeat.m2505o(135390);
                    return;
                case 3:
                    C1407g.m2946KK().mo4817KM();
                    AppMethodBeat.m2505o(135390);
                    return;
                case 4:
                    C1407g.m2946KK().mo4818KN();
                    VoipCSMainUI.this.teB.mo69452mr(true);
                    AppMethodBeat.m2505o(135390);
                    return;
                case 5:
                    C1407g.m2946KK().mo4817KM();
                    break;
            }
            AppMethodBeat.m2505o(135390);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$15 */
    class C1409815 implements OnClickListener {
        C1409815() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135403);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(9);
            AppMethodBeat.m2505o(135403);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$4 */
    class C140994 extends BroadcastReceiver {
        C140994() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(135392);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) C4996ah.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
                VoipCSMainUI.this.teA.cAY = false;
                AppMethodBeat.m2505o(135392);
                return;
            }
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
                VoipCSMainUI.this.teA.cAY = false;
                if (!VoipCSMainUI.this.tdT.cKq() && C43749c.cMf().tdM == 2) {
                    VoipCSMainUI.this.tdT.cMo();
                    AppMethodBeat.m2505o(135392);
                    return;
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
                VoipCSMainUI.this.teA.cAY = true;
                if (!VoipCSMainUI.this.tdT.cKq()) {
                    VoipCSMainUI.this.tdT.stopRing();
                }
            }
            AppMethodBeat.m2505o(135392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$17 */
    class C2249117 implements OnClickListener {
        C2249117() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135405);
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(8);
            AppMethodBeat.m2505o(135405);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$16 */
    class C2952516 implements OnClickListener {
        C2952516() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135404);
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            C14055q.cJU();
            if (VoipCSMainUI.m81713a(VoipCSMainUI.this)) {
                VoipCSMainUI.m81715b(VoipCSMainUI.this);
            }
            AppMethodBeat.m2505o(135404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$18 */
    class C2952618 implements C5015a {
        C2952618() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(135406);
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 44, new Intent(C4996ah.getContext(), VoipCSMainUI.class), 134217728);
            C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(VoipCSMainUI.this.tickerText).mo621d(VoipCSMainUI.this.title).mo623e(VoipCSMainUI.this.cEh);
            e.f362EI = activity;
            e.mo627k(2, true);
            Notification build = e.build();
            build.icon = C45186a.bWV();
            build.flags |= 32;
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(44, build, false);
            AppMethodBeat.m2505o(135406);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$6 */
    class C353886 implements OnClickListener {
        C353886() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135394);
            VoipCSMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(135394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$7 */
    class C353897 implements OnClickListener {
        C353897() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135395);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(2);
            AppMethodBeat.m2505o(135395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$10 */
    class C4004710 extends C1924a {
        C4004710() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(135398);
            C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(i)));
            if (C43749c.cMf().tdM == 2 && (i == 4 || i == 6)) {
                C22488e cMf = C43749c.cMf();
                C43746a c43746a = C43749c.cMe().tew;
                if (cMf.sPz == 0) {
                    cMf.sPz = c43746a.sTX;
                }
                int netType = C46317a.getNetType(C4996ah.getContext());
                if (netType != cMf.sPz) {
                    C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + cMf.sPz + " to " + netType);
                    try {
                        byte[] bArr = new byte[4];
                        bArr[0] = (byte) netType;
                        int appCmd = c43746a.setAppCmd(301, bArr, 4);
                        if (appCmd < 0) {
                            C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + c43746a.nwC + ", roomkey=" + c43746a.nwv + "]");
                        }
                        cmm cmm = new cmm();
                        cmm.xko = 3;
                        cmm.xkp = new C1332b(bArr, 0, 1);
                        c43746a.SendRUDP(cmm.toByteArray(), cmm.toByteArray().length);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
                    }
                    cMf.sPz = netType;
                }
                C1202f cMf2 = C43749c.cMf();
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + C43749c.cMe().tew.sTZ + "roomkey:" + C43749c.cMe().tew.nwv);
                C1720g.m3540Rg().mo14539a(285, cMf2);
                C43746a c43746a2 = C43749c.cMe().tew;
                C1720g.m3540Rg().mo14541a(new C14097d(c43746a2.sTZ, c43746a2.nwv), 0);
            }
            AppMethodBeat.m2505o(135398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$9 */
    class C400489 implements OnClickListener {
        C400489() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135397);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(3);
            AppMethodBeat.m2505o(135397);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$12 */
    class C4375212 implements OnClickListener {
        C4375212() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135400);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(0);
            AppMethodBeat.m2505o(135400);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$13 */
    class C4375313 implements OnClickListener {
        C4375313() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135401);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(0);
            AppMethodBeat.m2505o(135401);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$11 */
    class C4477011 implements OnClickListener {
        C4477011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135399);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(0);
            AppMethodBeat.m2505o(135399);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$14 */
    class C4477114 implements OnClickListener {
        C4477114() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135402);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(0);
            AppMethodBeat.m2505o(135402);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$1 */
    class C447721 implements OnClickListener {
        C447721() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135389);
            dialogInterface.dismiss();
            VoipCSMainUI.this.mo69456GV(0);
            AppMethodBeat.m2505o(135389);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI$8 */
    class C447738 implements OnClickListener {
        C447738() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(135396);
            dialogInterface.dismiss();
            VoipCSMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(135396);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VoipCSMainUI() {
        AppMethodBeat.m2504i(135407);
        AppMethodBeat.m2505o(135407);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m81713a(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.m2504i(135424);
        boolean cMA = voipCSMainUI.cMA();
        AppMethodBeat.m2505o(135424);
        return cMA;
    }

    /* renamed from: b */
    static /* synthetic */ void m81715b(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.m2504i(135425);
        voipCSMainUI.cMz();
        AppMethodBeat.m2505o(135425);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(135408);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.tdN = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.cQL = C5046bo.nullAsNil(getIntent().getStringExtra("voipCSScene"));
        this.type = C5046bo.nullAsNil(getIntent().getStringExtra("voipCSType"));
        this.teD = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.teE = getIntent().getStringExtra("voipCSShowOther");
        this.gEl = getIntent().getStringExtra("voipCSAvatarUrl");
        this.teF = getIntent().getStringExtra("voipCSContext");
        this.teG = getIntent().getBooleanExtra("launch_from_appbrand", false);
        getWindow().addFlags(6946944);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.fbD = new C7306ak();
        C43750d cMg = C43749c.cMg();
        C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "reset");
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
        cMg.tcY = C43750d.tcM;
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
        this.nva = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        C43749c.cMf().tdN = this.tdN;
        this.teA = new C44768b(this);
        this.teB = new C43745c();
        this.cqx = new C45293b(C4996ah.getContext());
        this.tdT = C43744a.cMm();
        C43749c.cMe().tey = this;
        C43749c.cMf().tdF = this;
        if (C43749c.cMf().tdM == 0 || C43749c.cMf().tdM == 3) {
            C43749c.cMf().tdM = 0;
        }
        C1321a.m2829Ib().mo4649Id();
        this.cqx.requestFocus();
        C1407g.m2946KK().mo4817KM();
        C1407g.m2946KK().mo4828a(this.teI);
        this.sRd = new HeadsetPlugReceiver();
        this.sRd.mo26276a(C4996ah.getContext(), this.sSk);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        C4996ah.getContext().registerReceiver(this.sSj, intentFilter);
        C1720g.m3535RO().mo5187a(this.qbK);
        if (this.teG) {
            if (this.cQL.equals("1")) {
                if (this.type.equals("video")) {
                    this.title = C4996ah.getContext().getString(C25738R.string.f4v);
                    this.tickerText = C4996ah.getContext().getString(C25738R.string.f4z);
                    this.cEh = C4996ah.getContext().getString(C25738R.string.f4z);
                } else {
                    this.title = C4996ah.getContext().getString(C25738R.string.f4w);
                    this.tickerText = C4996ah.getContext().getString(C25738R.string.f50);
                    this.cEh = C4996ah.getContext().getString(C25738R.string.f50);
                }
            } else if (this.type.equals("video")) {
                this.title = C4996ah.getContext().getString(C25738R.string.f4x);
                this.tickerText = C4996ah.getContext().getString(C25738R.string.f51);
                this.cEh = C4996ah.getContext().getString(C25738R.string.f51);
            } else {
                this.title = C4996ah.getContext().getString(C25738R.string.f4w);
                this.tickerText = C4996ah.getContext().getString(C25738R.string.f50);
                this.cEh = C4996ah.getContext().getString(C25738R.string.f50);
            }
        } else if (this.cQL.equals("1")) {
            if (this.type.equals("video")) {
                this.title = C4996ah.getContext().getString(C25738R.string.f4v);
                this.tickerText = C4996ah.getContext().getString(C25738R.string.f4z);
                this.cEh = C4996ah.getContext().getString(C25738R.string.f4z);
            } else {
                this.title = C4996ah.getContext().getString(C25738R.string.f4w);
                this.tickerText = C4996ah.getContext().getString(C25738R.string.f53);
                this.cEh = C4996ah.getContext().getString(C25738R.string.f53);
            }
        } else if (this.type.equals("video")) {
            this.title = C4996ah.getContext().getString(C25738R.string.f4x);
            this.tickerText = C4996ah.getContext().getString(C25738R.string.f53);
            this.cEh = C4996ah.getContext().getString(C25738R.string.f53);
        } else {
            this.title = C4996ah.getContext().getString(C25738R.string.f4w);
            this.tickerText = C4996ah.getContext().getString(C25738R.string.f52);
            this.cEh = C4996ah.getContext().getString(C25738R.string.f52);
        }
        int callState = this.nva.getCallState();
        if (callState == 2 || callState == 1) {
            C4990ab.m7417i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", Integer.valueOf(callState));
            C30379h.m48431a((Context) this, (int) C25738R.string.f59, (int) C25738R.string.f9238tz, new C447721());
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            AppMethodBeat.m2505o(135408);
            return;
        }
        this.nva.listen(this.nvb, 32);
        if (!C5023at.isNetworkConnected(this)) {
            C4990ab.m7412e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            C30379h.m48431a((Context) this, (int) C25738R.string.f55, (int) C25738R.string.f6g, new C1409815());
            z = false;
        } else if (C5023at.isWifi((Context) this) || C14055q.cJV()) {
            z = true;
        } else {
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            C30379h.m48432a((Context) this, (int) C25738R.string.f56, (int) C25738R.string.f6g, new C2952516(), new C2249117());
            z = false;
        }
        if (z) {
            if (C29488d.cLx()) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
                C30379h.m48431a((Context) this, (int) C25738R.string.cdq, (int) C25738R.string.f9238tz, new C4477011());
                callState = 1;
            } else if (C29488d.cLw()) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
                C30379h.m48431a((Context) this, (int) C25738R.string.cdr, (int) C25738R.string.f9238tz, new C4375212());
                callState = 1;
            } else if (C35973a.m59176Oo()) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
                C30379h.m48431a((Context) this, (int) C25738R.string.cdl, (int) C25738R.string.f9238tz, new C4375313());
                callState = 1;
            } else if (C17981e.akK()) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
                C30379h.m48431a((Context) this, (int) C25738R.string.cdm, (int) C25738R.string.f9238tz, new C4477114());
                callState = 1;
            } else {
                z = false;
            }
            if (callState != 0) {
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
                AppMethodBeat.m2505o(135408);
                return;
            }
            if (cMA()) {
                cMz();
            }
            AppMethodBeat.m2505o(135408);
            return;
        }
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
        AppMethodBeat.m2505o(135408);
    }

    private void cMz() {
        AppMethodBeat.m2504i(135409);
        if (C43749c.cMf().tdM <= 0) {
            this.teA.cMp();
            this.teA.cMq();
            C43749c.cMe().init();
            C43749c.cMf().mo38044ao(this.tdN, this.appId, this.teF);
        }
        if (C43749c.cMf().tdM < 2) {
            this.tdT.cMo();
        }
        this.teA.cMt();
        AppMethodBeat.m2505o(135409);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(135410);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.m2505o(135410);
            return true;
        } else if (i == 25) {
            C1407g.m2946KK().mo4839iK(bHJ());
            AppMethodBeat.m2505o(135410);
            return true;
        } else if (i == 24) {
            C1407g.m2946KK().mo4838iJ(bHJ());
            AppMethodBeat.m2505o(135410);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(135410);
            return onKeyDown;
        }
    }

    private int bHJ() {
        int i = 2;
        AppMethodBeat.m2504i(135411);
        if (C1407g.m2946KK().mo4819KP()) {
            i = C1407g.m2946KK().mo4827Lc();
        } else if (this.tdT.cKq()) {
            if (C43749c.cMf().tdM == 2) {
                i = 0;
            } else {
                i = this.teB.cIt();
            }
        }
        C4990ab.m7411d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", Integer.valueOf(i));
        AppMethodBeat.m2505o(135411);
        return i;
    }

    public void onResume() {
        AppMethodBeat.m2504i(135412);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.teA != null) {
            this.teA.cAY = false;
            if (C43749c.cMf().tdM > 1) {
                cMz();
                if (this.teE != null && this.teE.equals("1")) {
                    this.teA.cMw();
                }
            }
        }
        if (this.teH != null) {
            this.teH.stopTimer();
        }
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(44);
        AppMethodBeat.m2505o(135412);
    }

    public void onPause() {
        AppMethodBeat.m2504i(135413);
        super.onPause();
        if (!this.tdT.cKq()) {
            this.tdT.stopRing();
        }
        if (C43749c.cMf().tdM == 1 || C43749c.cMf().tdM == 2) {
            Intent intent = new Intent(C4996ah.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.tdN);
            intent.putExtra("voipCSAppId", this.appId);
            intent.putExtra("voipCSScene", this.cQL);
            intent.putExtra("voipCSType", this.type);
            intent.putExtra("voipCSAllowBackCamera", this.teD);
            intent.putExtra("voipCSShowOther", this.teE);
            intent.putExtra("voipCSAvatarUrl", this.gEl);
            intent.putExtra("voipCSContext", this.teF);
            intent.putExtra("launch_from_appbrand", this.teG);
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 44, intent, 134217728);
            C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(this.tickerText).mo626j(System.currentTimeMillis()).mo621d(this.title).mo623e(this.cEh);
            e.f362EI = activity;
            e.mo627k(2, true);
            Notification build = e.build();
            build.icon = C45186a.bWV();
            build.flags |= 32;
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(44, build, false);
            if (this.teH != null && this.teH.doT()) {
                this.teH.mo16770ae(5000, 5000);
            }
        } else {
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(44);
            if (this.teH != null) {
                this.teH.stopTimer();
            }
        }
        this.teA.cMu();
        this.teA.cAY = true;
        AppMethodBeat.m2505o(135413);
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        AppMethodBeat.m2504i(135414);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (cMA() && C43749c.cMf().tdM <= 1) {
            cMz();
        }
        if (this.teA != null) {
            this.teA.cAY = false;
        }
        AppMethodBeat.m2505o(135414);
    }

    public void onStop() {
        AppMethodBeat.m2504i(135415);
        super.onStop();
        AppMethodBeat.m2505o(135415);
    }

    public void onDestroy() {
        int i;
        int i2 = 2;
        AppMethodBeat.m2504i(135416);
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
        if (this.cqx != null) {
            this.cqx.mo73178Mm();
        }
        C32630sh c32630sh = new C32630sh();
        if (C43749c.cMf().tdO == -1) {
            c32630sh.cOB.status = 3;
        } else if (C43749c.cMf().tdO == 823) {
            c32630sh.cOB.status = 4;
        } else if (C43749c.cMf().tdM <= 1) {
            c32630sh.cOB.status = 1;
        } else if (C43749c.cMf().tdM >= 2) {
            c32630sh.cOB.status = 2;
        }
        C4879a.xxA.mo10055m(c32630sh);
        C43745c c43745c = this.teB;
        C43750d cMg = C43749c.cMg();
        if (c43745c.sPL == null || C43749c.cMg().tdl != 1) {
            i = 0;
        } else {
            i = c43745c.sPL.cIt();
        }
        cMg.tdv = (int) ((((float) C1407g.m2946KK().getStreamVolume(i)) / ((float) C1407g.m2946KK().getStreamMaxVolume(i))) * 100.0f);
        cMg = C43749c.cMg();
        if (c43745c.kzb == null || C43749c.cMg().tdl != 1) {
            i = 0;
        } else {
            i = c43745c.kzb.mo4594EO();
        }
        cMg.sUs = i;
        if (c43745c.kzb != null) {
            c43745c.kzb.mo4590EB();
        }
        if (c43745c.sPL != null) {
            c43745c.sPL.cIr();
        }
        this.tdT.stopRing();
        if (this.teA != null) {
            C44768b c44768b = this.teA;
            if (C43749c.cMg().dataType == 0) {
                if (C43749c.cMf().tdM < 2) {
                    C43749c.cMg().dataType = 1;
                } else {
                    C43749c.cMg().dataType = 3;
                }
            }
            c44768b.sWU.cLI();
            c44768b.sWV.cLI();
            c44768b.cMu();
            c44768b.cMx();
            C1202f cMf = C43749c.cMf();
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "now stop service");
            C1720g.m3540Rg().mo14546b(823, cMf);
            C1720g.m3540Rg().mo14546b(106, cMf);
            C1720g.m3540Rg().mo14546b(818, cMf);
            C1720g.m3540Rg().mo14546b(795, cMf);
            C1720g.m3540Rg().mo14546b(285, cMf);
            C1720g.m3540Rg().mo14546b(312, cMf);
            cMf.tdM = 3;
            if (cMf.tdO != 823) {
                C1720g.m3540Rg().mo14539a(880, cMf);
                if (cMf.tdH == 0) {
                    i2 = 1;
                } else if (cMf.tdH != 2) {
                    if (cMf.tdH == 3) {
                        i2 = 3;
                    } else {
                        i2 = 4;
                    }
                }
                C4990ab.m7416i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + cMf.tdN + ",inviteId：" + C43749c.cMe().tew.nwx + ",csroomId:" + C43749c.cMe().tew.sTZ + ",roomkey:" + C43749c.cMe().tew.nwv + ",reason:" + i2);
                C1720g.m3540Rg().mo14541a(new C14096a(C43749c.cMe().tew.nwx, C43749c.cMe().tew.sTZ, C43749c.cMe().tew.nwv, cMf.tdN, i2), 0);
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
            C43747a cMe = C43749c.cMe();
            C4990ab.m7416i("MicroMsg.VoipCSEngine", "now stop engine");
            cMe.tew.mo63320mx(true);
            C43750d cMg2 = C43749c.cMg();
            if (C5046bo.isNullOrNil(cMg2.nxW) && C5046bo.isNullOrNil(cMg2.nxV)) {
                C43746a c43746a = C43749c.cMe().tew;
                if (cMg2.tdj == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                c43746a.getVoipcsChannelInfo(c43746a.tcD, c43746a.tcD.length, i != 0 ? 1 : 0);
                C4990ab.m7411d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", Integer.valueOf(c43746a.field_voipcsChannelInfoLength));
                cMg2.nxW = new String(c43746a.tcD, 0, c43746a.field_voipcsChannelInfoLength);
                cMg2.nxV = C43749c.cMe().tew.cMb();
                C4990ab.m7411d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", cMg2.nxW);
                C4990ab.m7411d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", cMg2.nxV);
            }
            C1720g.m3540Rg().mo14539a(312, C43749c.cMf());
            C1720g.m3540Rg().mo14541a(new C46329e(C43749c.cMe().tew.sTZ, C43749c.cMe().tew.nwv), 0);
            cMe.tew.reset();
            C35355p.cJR().cJT();
            C35355p.cJR().mo56094a(null);
        }
        this.teA = null;
        this.teB = null;
        C1407g.m2946KK().setMode(0);
        C4996ah.getContext().unregisterReceiver(this.sSj);
        C1407g.m2946KK().mo4829b(this.teI);
        C1407g.m2946KK().mo4818KN();
        if (this.sRd != null) {
            this.sRd.mo26277fa(C4996ah.getContext());
        }
        C1720g.m3535RO().mo5188b(this.qbK);
        if (this.teH != null) {
            this.teH.stopTimer();
        }
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(44);
        if (!(this.nva == null || this.nvb == null)) {
            this.nva.listen(this.nvb, 0);
            this.nvb = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(135416);
    }

    public final int getLayoutId() {
        return 2130971029;
    }

    /* renamed from: GV */
    public final void mo69456GV(int i) {
        AppMethodBeat.m2504i(135417);
        C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i + ",CallingStatus:" + C43749c.cMf().tdM);
        if (C43749c.cMf().tdM == 0) {
            finish();
            AppMethodBeat.m2505o(135417);
            return;
        }
        if (this.teA != null) {
            this.teA.mo71848GY(i);
        }
        AppMethodBeat.m2505o(135417);
    }

    public final void onError(int i) {
        AppMethodBeat.m2504i(135418);
        if (this.teA != null) {
            C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(i)));
            this.teA.mo71848GY(i);
        }
        AppMethodBeat.m2505o(135418);
    }

    /* renamed from: gF */
    public final void mo69457gF(String str, String str2) {
        AppMethodBeat.m2504i(135419);
        C44768b c44768b = this.teA;
        if (!c44768b.tel.equals("") || !C5046bo.isNullOrNil(str2)) {
            c44768b.acd(str2);
        } else if (c44768b.tdU.teG) {
            c44768b.ejp.setText(C25738R.string.f4k);
        } else {
            c44768b.ejp.setText(C25738R.string.f4j);
        }
        if (c44768b.tek.equals("") && C5046bo.isNullOrNil(str) && (c44768b.tdU.gEl == null || c44768b.tdU.gEl.equals(""))) {
            c44768b.tea.setImageResource(C25738R.drawable.ad2);
            AppMethodBeat.m2505o(135419);
            return;
        }
        SharedPreferences doB = C4996ah.doB();
        if (!(C5046bo.isNullOrNil(str) || c44768b.tek.equals(str))) {
            c44768b.ace(str);
            doB.edit().putString(c44768b.cMr(), str).commit();
        }
        if (!(C5046bo.isNullOrNil(str2) || c44768b.tel.equals(str2))) {
            c44768b.acd(str2);
            doB.edit().putString(c44768b.cMs(), str2).commit();
        }
        AppMethodBeat.m2505o(135419);
    }

    private boolean cMA() {
        AppMethodBeat.m2504i(135420);
        if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            C4990ab.m7411d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")), C5046bo.dpG(), this);
            if (C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")) {
                AppMethodBeat.m2505o(135420);
                return true;
            }
            C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            AppMethodBeat.m2505o(135420);
            return false;
        }
        C4990ab.m7416i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
        AppMethodBeat.m2505o(135420);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(135421);
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            C4990ab.m7413e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i));
            AppMethodBeat.m2505o(135421);
            return;
        }
        C4990ab.m7411d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C447738(), new C400489());
                    break;
                }
                cMz();
                AppMethodBeat.m2505o(135421);
                return;
            case 82:
                if (iArr[0] == 0) {
                    C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")) {
                        cMz();
                    }
                    AppMethodBeat.m2505o(135421);
                    return;
                }
                C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C353886(), new C353897());
                AppMethodBeat.m2505o(135421);
                return;
        }
        AppMethodBeat.m2505o(135421);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bGQ() {
        int i;
        C43750d cMg;
        AppMethodBeat.m2504i(135422);
        this.teA.bGQ();
        if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
            this.teB.mo69452mr(false);
        } else {
            this.teB.mo69452mr(true);
        }
        C43745c c43745c = this.teB;
        if (c43745c.kzb != null) {
            boolean EL = c43745c.kzb.mo4592EL();
            C43749c.cMg().tdl = 1;
            if (EL) {
                i = 1;
                C43749c.cMg().tdE = i;
                c43745c = this.teB;
                if (c43745c.sPL != null) {
                    C43749c.cMe().tew.sUn = Math.abs(1);
                } else {
                    c43745c.sPL.cIp();
                    if (c43745c.sPL.cIp() <= 0) {
                        C43749c.cMe().tew.sUn = Math.abs(1);
                    }
                }
                this.tdT.stopRing();
                cMg = C43749c.cMg();
                if (cMg.tdz != 0) {
                    cMg.tdo = ((int) (System.currentTimeMillis() / 1000)) - cMg.tdz;
                }
                cMg = C43749c.cMg();
                C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "markStartTalk");
                if (cMg.tdC == 0) {
                    cMg.tdC = (int) (System.currentTimeMillis() / 1000);
                }
                cMg = C43749c.cMg();
                C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "markConnect");
                if (cMg.tdB != 0) {
                    cMg.tdq = (long) (((int) (System.currentTimeMillis() / 1000)) - cMg.tdB);
                }
                AppMethodBeat.m2505o(135422);
            }
        }
        i = -1;
        C43749c.cMg().tdE = i;
        c43745c = this.teB;
        if (c43745c.sPL != null) {
        }
        this.tdT.stopRing();
        cMg = C43749c.cMg();
        if (cMg.tdz != 0) {
        }
        cMg = C43749c.cMg();
        C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "markStartTalk");
        if (cMg.tdC == 0) {
        }
        cMg = C43749c.cMg();
        C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "markConnect");
        if (cMg.tdB != 0) {
        }
        AppMethodBeat.m2505o(135422);
    }

    public final void cMy() {
        AppMethodBeat.m2504i(135423);
        C4990ab.m7410d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.teA.mo71848GY(5);
        AppMethodBeat.m2505o(135423);
    }
}
