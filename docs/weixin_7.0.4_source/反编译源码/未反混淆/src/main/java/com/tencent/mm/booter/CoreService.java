package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.facebook.login.widget.ToolTipPopup;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.om;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.AnonymousClass12;
import com.tencent.mm.network.w;
import com.tencent.mm.network.y;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class CoreService extends Service implements IResetProcess, com.tencent.mm.network.aa.a, m {
    private f ebA = new f();
    private boolean ebB = true;
    private a ebC = null;
    private final b ebD = new b() {
        public final void prepare() {
            AppMethodBeat.i(57723);
            AlarmReceiver.bp(CoreService.this.getApplicationContext());
            AppMethodBeat.o(57723);
        }

        public final void cancel() {
            AppMethodBeat.i(57724);
            AlarmReceiver.bq(CoreService.this.getApplicationContext());
            AppMethodBeat.o(57724);
        }
    };
    private int ebE = -1;
    private int ebF = -1;
    private long ebG = 0;
    private long ebH = 0;
    private long ebI = 0;
    private WakerLock ebJ = null;
    private s ebK = new s();
    private ap ebL = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            int i;
            AppMethodBeat.i(57729);
            s a = CoreService.this.ebK;
            if (bo.az(a.ghi) < a.ghg) {
                ab.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.ghi + ", cur=" + bo.yz() + ", retries=" + a.ghj);
                if (a.ghj <= 0) {
                    i = 0;
                } else {
                    a.ghj--;
                    a.ghi = bo.yz();
                    i = 1;
                }
            } else {
                a.ghj = a.ghh;
                a.ghi = bo.yz();
                i = 1;
            }
            if (i == 0) {
                ab.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
            } else {
                ab.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", Boolean.valueOf(CoreService.this.ebz.gcU.adb()), Boolean.valueOf(aa.ano().amV()));
                if (CoreService.this.ebz.gcU.adb() && !r3 && g.a(1, 0, null, CoreService.this.ebz.gcU.jQ(1), bo.anU())) {
                    ab.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                    AppMethodBeat.o(57729);
                    return true;
                }
                CoreService.Ie();
            }
            ab.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(CoreService.this.ebG), Long.valueOf(CoreService.this.ebI), Long.valueOf(bo.anU() - CoreService.this.ebH));
            CoreService.this.ebG = 0;
            CoreService.this.ebI = 0;
            CoreService.this.ebH = 0;
            new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(57728);
                    CoreService.this.ebJ.unLock();
                    AppMethodBeat.o(57728);
                    return false;
                }
            }, false).ae(500, 500);
            AppMethodBeat.o(57729);
            return true;
        }
    }, false);
    private t ebz;

    public static class InnerService extends Service {
        public void onCreate() {
            AppMethodBeat.i(57730);
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e) {
                ab.e("MicroMsg.CoreService", "set service for push exception:%s.", e);
            }
            stopSelf();
            AppMethodBeat.o(57730);
        }

        public void onDestroy() {
            AppMethodBeat.i(57731);
            stopForeground(true);
            super.onDestroy();
            AppMethodBeat.o(57731);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    public interface a {
        void registerBroadcasts();

        void unRegisterBroadcasts();
    }

    public CoreService() {
        AppMethodBeat.i(57732);
        AppMethodBeat.o(57732);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String string;
        String string2;
        String str;
        NetworkInfo networkInfo = null;
        AppMethodBeat.i(57733);
        ab.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        try {
            this.ebC = (a) Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance();
            ab.d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", this.ebC);
            this.ebC.registerBroadcasts();
        } catch (Exception e) {
            ab.e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", e.getMessage());
        }
        if (d.fP(26) && VERSION.SDK_INT < 24 && !h.Ms()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", h.Mu()).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                ab.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        ak akVar = new ak(Looper.getMainLooper());
        Mars.init(ah.getContext(), akVar);
        StnLogic.setCallBack(new af());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.Qi();
        com.tencent.mm.sdk.b.a.xxA.c(new c<om>() {
            {
                AppMethodBeat.i(57725);
                this.xxI = om.class.getName().hashCode();
                AppMethodBeat.o(57725);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(57726);
                String str = ((om) bVar).cKO.cKP;
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(57726);
                    return false;
                }
                e.pXa.a(12900, str, true, false);
                AppMethodBeat.o(57726);
                return true;
            }
        });
        aa.ani();
        com.tencent.mm.sdk.platformtools.af.a(this.ebD);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        aa.a(akVar);
        aa.setContext(getApplicationContext());
        aa.a(new com.tencent.mm.network.ab());
        aa.a(new ac());
        aa.a((com.tencent.mm.network.aa.a) this);
        aa.a(new w());
        this.ebz = aa.ano();
        if (this.ebz == null) {
            ab.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.ebz = new t(aa.anm());
            aa.b(this.ebz);
        } else {
            ab.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.ebz.reset();
        }
        Mars.onCreate(true);
        if (aa.anp() == null) {
            ab.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            aa.a(new z());
        } else {
            ab.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            aa.anp().reset();
        }
        if (aa.anq() == null) {
            ab.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            aa.a(new y());
            aa.anq().gdO = this;
        }
        d dVar = ((com.tencent.mm.kernel.b.h) g.RM().Rn()).ecL;
        if (dVar == null) {
            ((com.tencent.mm.kernel.b.h) g.RM().Rn()).ecL = d.bo(getApplicationContext());
            dVar = ((com.tencent.mm.kernel.b.h) g.RM().Rn()).ecL;
            ab.i("MicroMsg.CoreService", "summerauths init debug here[%s]", dVar);
        }
        if (dVar != null) {
            this.ebz.d(dVar.getString(".com.tencent.mm.debug.server.host.http"), dVar.getString(".com.tencent.mm.debug.server.ports.http"), dVar.getString(".com.tencent.mm.debug.server.host.socket"), dVar.getString(".com.tencent.mm.debug.server.ports.socket"));
            string = dVar.getString(".com.tencent.mm.debug.server.wallet.host");
            string2 = dVar.getString(".com.tencent.mm.debug.server.wallet.ip");
            t tVar = this.ebz;
            if (!(bo.isNullOrNil(string) || bo.Q(new String[0]))) {
                new AnonymousClass12(string, string2).b(tVar.handler);
            }
        }
        if (dVar == null) {
            string = networkInfo;
        } else {
            string = dVar.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (string == null || !string.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            Object str2 = networkInfo;
        } else {
            String[] split = string.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            string = split[0];
            str2 = split[1];
        }
        this.ebz.setNewDnsDebugHost(string, str2);
        AlarmReceiver.bs(getApplicationContext());
        AlarmReceiver.br(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.CoreService", e2, "", new Object[0]);
            ab.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", e2.getMessage());
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            string = "MicroMsg.CoreService";
            string2 = "networkInfo.state: %s";
            Object[] objArr = new Object[1];
            objArr[0] = networkInfo == null ? BuildConfig.COMMAND : networkInfo.getState();
            ab.e(string, string2, objArr);
            aa.ank().geh = false;
            aa.anl().mF(0);
        } else {
            aa.ank().geh = true;
            aa.anl().mF(6);
        }
        ((PluginZero) g.M(PluginZero.class)).yah.a(this);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(57727);
                if (VERSION.SDK_INT > 23) {
                    ab.i("MicroMsg.CoreService", "KeepAliveService.scheduleKeepAliveJob() flag:%s", Boolean.valueOf(KeepAliveService.Ik()));
                }
                AppMethodBeat.o(57727);
            }
        }, 1000);
        ab.i("MicroMsg.CoreService", "CoreService OnCreate ");
        AppMethodBeat.o(57733);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(57734);
        int myPid = Process.myPid();
        ab.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", Integer.valueOf(this.ebE), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2));
        if (myPid != this.ebE) {
            this.ebE = myPid;
            e.pXa.a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                e.pXa.a(99, 140, 1, false);
            }
        }
        AppMethodBeat.o(57734);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(57735);
        ab.i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        ((PluginZero) g.M(PluginZero.class)).yah.b(this);
        com.tencent.mm.jni.a.a.Qj();
        super.onDestroy();
        If();
        if (this.ebC != null) {
            try {
                this.ebC.unRegisterBroadcasts();
                AppMethodBeat.o(57735);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", e.getMessage());
            }
        }
        AppMethodBeat.o(57735);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(57736);
        ab.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        aa.ank().geg = null;
        aa.ans().gdH = null;
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(57736);
        return onUnbind;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(57737);
        int myPid = Process.myPid();
        ab.d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), Integer.valueOf(this.ebF), Integer.valueOf(myPid));
        if (myPid != this.ebF) {
            this.ebF = myPid;
            e.pXa.a(99, 147, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                e.pXa.a(99, 146, 1, false);
            }
        }
        t tVar = this.ebz;
        AppMethodBeat.o(57737);
        return tVar;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(57738);
        ab.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
        AppMethodBeat.o(57738);
    }

    public final boolean e(int i, byte[] bArr) {
        AppMethodBeat.i(57739);
        if (l.bL(this)) {
            ab.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            AppMethodBeat.o(57739);
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = aa.anh().getBoolean("is_in_notify_mode", false);
        boolean adb = this.ebz.gcU.adb();
        boolean amV = aa.ano().amV();
        if (z && adb && !amV) {
            if (g.a(2, i2, bArr, this.ebz.gcU.jQ(1), bo.anU())) {
                ab.i("MicroMsg.CoreService", "deal with notify sync in push");
                AppMethodBeat.o(57739);
                return true;
            }
        }
        ab.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", Boolean.valueOf(adb), Boolean.valueOf(amV), Boolean.valueOf(z));
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.ebz.gcU.QF());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", bo.anU());
        intent.putExtra("notify_skey", this.ebz.gcU.jQ(1));
        ab.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            ab.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(bo.l(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length));
            sendBroadcast(intent);
            com.tencent.mm.an.a.ll(i2);
        } catch (Throwable th) {
            ab.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", bo.l(th));
        }
        AppMethodBeat.o(57739);
        return true;
    }

    public final void bt(boolean z) {
        AppMethodBeat.i(57740);
        if (z) {
            ab.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            aa.ank().geh = true;
            boolean Il = this.ebA.Il();
            if (!this.ebB || Il) {
                if (Il) {
                    aa.ano().amN();
                }
                this.ebB = true;
                aa.anl().mF(6);
                if (this.ebJ == null) {
                    this.ebJ = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
                }
                if (!this.ebJ.isLocking()) {
                    this.ebJ.lock(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, "CoreService.setNetworkAvailable");
                    this.ebG++;
                }
                if (0 == this.ebI) {
                    this.ebH = bo.anU();
                }
                this.ebI++;
                ab.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.ebG), Long.valueOf(this.ebI), Long.valueOf(bo.anU() - this.ebH));
                this.ebL.ae(3000, 3000);
                AppMethodBeat.o(57740);
                return;
            }
            ab.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", Boolean.valueOf(this.ebB));
            AppMethodBeat.o(57740);
            return;
        }
        ab.w("MicroMsg.CoreService", "[NETWORK LOST]");
        aa.ank().geh = false;
        aa.anl().mF(0);
        if (this.ebB) {
            aa.ano().amN();
            this.ebA.ebY = null;
        }
        this.ebB = false;
        AppMethodBeat.o(57740);
    }

    public static void Ie() {
        AppMethodBeat.i(57741);
        Intent intent = new Intent(aa.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", aa.ano().gcU.QF());
        try {
            aa.getContext().sendBroadcast(intent);
            AppMethodBeat.o(57741);
        } catch (Exception e) {
            ab.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", e.toString());
            AppMethodBeat.o(57741);
        }
    }

    private void If() {
        AppMethodBeat.i(57742);
        ab.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        aa.anp().i(3, Downloads.MIN_WAIT_FOR_NETWORK, "");
        Mars.onDestroy();
        try {
            AlarmReceiver.bs(getApplicationContext());
            AlarmReceiver.bq(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
        }
        ab.appenderClose();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(57742);
    }

    public void restartProcess() {
        AppMethodBeat.i(57743);
        ab.w("MicroMsg.CoreService", "restartProcess");
        If();
        AppMethodBeat.o(57743);
    }
}
