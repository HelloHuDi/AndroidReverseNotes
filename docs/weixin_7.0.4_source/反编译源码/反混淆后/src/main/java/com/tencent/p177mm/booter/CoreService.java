package com.tencent.p177mm.booter;

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
import com.p802jg.EType;
import com.p802jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.jni.p236a.C1639a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.network.C1892aa.C1893a;
import com.tencent.p177mm.network.C1922m;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.network.C32858ac;
import com.tencent.p177mm.network.C32861af;
import com.tencent.p177mm.network.C32862p;
import com.tencent.p177mm.network.C32871t;
import com.tencent.p177mm.network.C32871t.C2650912;
import com.tencent.p177mm.network.C37973z;
import com.tencent.p177mm.network.C45463y;
import com.tencent.p177mm.network.C9762w;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.p230g.p231a.C6532om;
import com.tencent.p177mm.platformtools.C45478s;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.PluginZero;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C35986af;
import com.tencent.p177mm.sdk.platformtools.C35986af.C30282b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.booter.CoreService */
public class CoreService extends Service implements IResetProcess, C1893a, C1922m {
    private C32424f ebA = new C32424f();
    private boolean ebB = true;
    private C9177a ebC = null;
    private final C30282b ebD = new C13201();
    private int ebE = -1;
    private int ebF = -1;
    private long ebG = 0;
    private long ebH = 0;
    private long ebI = 0;
    private WakerLock ebJ = null;
    private C45478s ebK = new C45478s();
    private C7564ap ebL = new C7564ap(new C91804(), false);
    private C32871t ebz;

    /* renamed from: com.tencent.mm.booter.CoreService$1 */
    class C13201 implements C30282b {
        C13201() {
        }

        public final void prepare() {
            AppMethodBeat.m2504i(57723);
            AlarmReceiver.m16678bp(CoreService.this.getApplicationContext());
            AppMethodBeat.m2505o(57723);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(57724);
            AlarmReceiver.m16679bq(CoreService.this.getApplicationContext());
            AppMethodBeat.m2505o(57724);
        }
    }

    /* renamed from: com.tencent.mm.booter.CoreService$InnerService */
    public static class InnerService extends Service {
        public void onCreate() {
            AppMethodBeat.m2504i(57730);
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e) {
                C4990ab.m7413e("MicroMsg.CoreService", "set service for push exception:%s.", e);
            }
            stopSelf();
            AppMethodBeat.m2505o(57730);
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(57731);
            stopForeground(true);
            super.onDestroy();
            AppMethodBeat.m2505o(57731);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.booter.CoreService$a */
    public interface C9177a {
        void registerBroadcasts();

        void unRegisterBroadcasts();
    }

    /* renamed from: com.tencent.mm.booter.CoreService$2 */
    class C91782 extends C4884c<C6532om> {
        C91782() {
            AppMethodBeat.m2504i(57725);
            this.xxI = C6532om.class.getName().hashCode();
            AppMethodBeat.m2505o(57725);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(57726);
            String str = ((C6532om) c4883b).cKO.cKP;
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(57726);
                return false;
            }
            C7053e.pXa.mo8376a(12900, str, true, false);
            AppMethodBeat.m2505o(57726);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.booter.CoreService$3 */
    class C91793 implements Runnable {
        C91793() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57727);
            if (VERSION.SDK_INT > 23) {
                C4990ab.m7417i("MicroMsg.CoreService", "KeepAliveService.scheduleKeepAliveJob() flag:%s", Boolean.valueOf(KeepAliveService.m41393Ik()));
            }
            AppMethodBeat.m2505o(57727);
        }
    }

    /* renamed from: com.tencent.mm.booter.CoreService$4 */
    class C91804 implements C5015a {

        /* renamed from: com.tencent.mm.booter.CoreService$4$1 */
        class C91761 implements C5015a {
            C91761() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(57728);
                CoreService.this.ebJ.unLock();
                AppMethodBeat.m2505o(57728);
                return false;
            }
        }

        C91804() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            int i;
            AppMethodBeat.m2504i(57729);
            C45478s a = CoreService.this.ebK;
            if (C5046bo.m7525az(a.ghi) < a.ghg) {
                C4990ab.m7416i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.ghi + ", cur=" + C5046bo.m7588yz() + ", retries=" + a.ghj);
                if (a.ghj <= 0) {
                    i = 0;
                } else {
                    a.ghj--;
                    a.ghi = C5046bo.m7588yz();
                    i = 1;
                }
            } else {
                a.ghj = a.ghh;
                a.ghi = C5046bo.m7588yz();
                i = 1;
            }
            if (i == 0) {
                C4990ab.m7412e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
            } else {
                C4990ab.m7417i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isLogin:%b", Boolean.valueOf(CoreService.this.ebz.gcU.adb()), Boolean.valueOf(C1892aa.ano().amV()));
                if (CoreService.this.ebz.gcU.adb() && !r3 && C37617g.m63508a(1, 0, null, CoreService.this.ebz.gcU.mo5509jQ(1), C5046bo.anU())) {
                    C4990ab.m7416i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                    AppMethodBeat.m2505o(57729);
                    return true;
                }
                CoreService.m16662Ie();
            }
            C4990ab.m7417i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(CoreService.this.ebG), Long.valueOf(CoreService.this.ebI), Long.valueOf(C5046bo.anU() - CoreService.this.ebH));
            CoreService.this.ebG = 0;
            CoreService.this.ebI = 0;
            CoreService.this.ebH = 0;
            new C7564ap(new C91761(), false).mo16770ae(500, 500);
            AppMethodBeat.m2505o(57729);
            return true;
        }
    }

    public CoreService() {
        AppMethodBeat.m2504i(57732);
        AppMethodBeat.m2505o(57732);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String string;
        String string2;
        String str;
        NetworkInfo networkInfo = null;
        AppMethodBeat.m2504i(57733);
        C4990ab.m7410d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        try {
            this.ebC = (C9177a) Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance();
            C4990ab.m7411d("MicroMsg.CoreService", "broadcastRegisterHelper = %s", this.ebC);
            this.ebC.registerBroadcasts();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CoreService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", e.getMessage());
        }
        if (C1443d.m3067fP(26) && VERSION.SDK_INT < 24 && !C1448h.m3076Ms()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                C4990ab.m7416i("MicroMsg.CoreService", "set service for push.");
            }
        }
        C7306ak c7306ak = new C7306ak(Looper.getMainLooper());
        Mars.init(C4996ah.getContext(), c7306ak);
        StnLogic.setCallBack(new C32861af());
        IPxxLogic.setCallBack(new C32862p());
        C1639a.m3307Qi();
        C4879a.xxA.mo10052c(new C91782());
        C1892aa.ani();
        C35986af.m59195a(this.ebD);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        C1892aa.m4012a(c7306ak);
        C1892aa.setContext(getApplicationContext());
        C1892aa.m4007a(new C32856ab());
        C1892aa.m4008a(new C32858ac());
        C1892aa.m4006a((C1893a) this);
        C1892aa.m4009a(new C9762w());
        this.ebz = C1892aa.ano();
        if (this.ebz == null) {
            C4990ab.m7416i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.ebz = new C32871t(C1892aa.anm());
            C1892aa.m4013b(this.ebz);
        } else {
            C4990ab.m7420w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.ebz.reset();
        }
        Mars.onCreate(true);
        if (C1892aa.anp() == null) {
            C4990ab.m7416i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            C1892aa.m4011a(new C37973z());
        } else {
            C4990ab.m7420w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            C1892aa.anp().reset();
        }
        if (C1892aa.anq() == null) {
            C4990ab.m7416i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            C1892aa.m4010a(new C45463y());
            C1892aa.anq().gdO = this;
        }
        C1326d c1326d = ((C6624h) C1720g.m3533RM().mo5224Rn()).ecL;
        if (c1326d == null) {
            ((C6624h) C1720g.m3533RM().mo5224Rn()).ecL = C1326d.m2839bo(getApplicationContext());
            c1326d = ((C6624h) C1720g.m3533RM().mo5224Rn()).ecL;
            C4990ab.m7417i("MicroMsg.CoreService", "summerauths init debug here[%s]", c1326d);
        }
        if (c1326d != null) {
            this.ebz.mo5570d(c1326d.getString(".com.tencent.mm.debug.server.host.http"), c1326d.getString(".com.tencent.mm.debug.server.ports.http"), c1326d.getString(".com.tencent.mm.debug.server.host.socket"), c1326d.getString(".com.tencent.mm.debug.server.ports.socket"));
            string = c1326d.getString(".com.tencent.mm.debug.server.wallet.host");
            string2 = c1326d.getString(".com.tencent.mm.debug.server.wallet.ip");
            C32871t c32871t = this.ebz;
            if (!(C5046bo.isNullOrNil(string) || C5046bo.m7510Q(new String[0]))) {
                new C2650912(string, string2).mo10372b(c32871t.handler);
            }
        }
        if (c1326d == null) {
            string = networkInfo;
        } else {
            string = c1326d.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (string == null || !string.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            Object str2 = networkInfo;
        } else {
            String[] split = string.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            string = split[0];
            str2 = split[1];
        }
        this.ebz.setNewDnsDebugHost(string, str2);
        AlarmReceiver.m16681bs(getApplicationContext());
        AlarmReceiver.m16680br(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.CoreService", e2, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", e2.getMessage());
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            string = "MicroMsg.CoreService";
            string2 = "networkInfo.state: %s";
            Object[] objArr = new Object[1];
            objArr[0] = networkInfo == null ? BuildConfig.COMMAND : networkInfo.getState();
            C4990ab.m7413e(string, string2, objArr);
            C1892aa.ank().geh = false;
            C1892aa.anl().mo53427mF(0);
        } else {
            C1892aa.ank().geh = true;
            C1892aa.anl().mo53427mF(6);
        }
        ((PluginZero) C1720g.m3530M(PluginZero.class)).yah.mo48264a(this);
        C5004al.m7442n(new C91793(), 1000);
        C4990ab.m7416i("MicroMsg.CoreService", "CoreService OnCreate ");
        AppMethodBeat.m2505o(57733);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(57734);
        int myPid = Process.myPid();
        C4990ab.m7417i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", Integer.valueOf(this.ebE), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2));
        if (myPid != this.ebE) {
            this.ebE = myPid;
            C7053e.pXa.mo8378a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                C7053e.pXa.mo8378a(99, 140, 1, false);
            }
        }
        AppMethodBeat.m2505o(57734);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(57735);
        C4990ab.m7416i("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        ((PluginZero) C1720g.m3530M(PluginZero.class)).yah.mo48265b(this);
        C1639a.m3308Qj();
        super.onDestroy();
        m16663If();
        if (this.ebC != null) {
            try {
                this.ebC.unRegisterBroadcasts();
                AppMethodBeat.m2505o(57735);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CoreService", "onDestroy unRegisterBroadcasts() Exception = %s ", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(57735);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(57736);
        C4990ab.m7410d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        C1892aa.ank().geg = null;
        C1892aa.ans().gdH = null;
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(57736);
        return onUnbind;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(57737);
        int myPid = Process.myPid();
        C4990ab.m7411d("MicroMsg.CoreService", "onBind~~~ lastpid:%d  pid:%d threadID:" + Thread.currentThread(), Integer.valueOf(this.ebF), Integer.valueOf(myPid));
        if (myPid != this.ebF) {
            this.ebF = myPid;
            C7053e.pXa.mo8378a(99, 147, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                C7053e.pXa.mo8378a(99, 146, 1, false);
            }
        }
        C32871t c32871t = this.ebz;
        AppMethodBeat.m2505o(57737);
        return c32871t;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.m2504i(57738);
        C4990ab.m7410d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
        AppMethodBeat.m2505o(57738);
    }

    /* renamed from: e */
    public final boolean mo5610e(int i, byte[] bArr) {
        AppMethodBeat.m2504i(57739);
        if (C1737l.m3591bL(this)) {
            C4990ab.m7416i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            AppMethodBeat.m2505o(57739);
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = C1892aa.anh().getBoolean("is_in_notify_mode", false);
        boolean adb = this.ebz.gcU.adb();
        boolean amV = C1892aa.ano().amV();
        if (z && adb && !amV) {
            if (C37617g.m63508a(2, i2, bArr, this.ebz.gcU.mo5509jQ(1), C5046bo.anU())) {
                C4990ab.m7416i("MicroMsg.CoreService", "deal with notify sync in push");
                AppMethodBeat.m2505o(57739);
                return true;
            }
        }
        C4990ab.m7417i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isLogin:%b, isMMProcessExist:%b, isInNotifyMode:%b", Boolean.valueOf(adb), Boolean.valueOf(amV), Boolean.valueOf(z));
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.ebz.gcU.mo5495QF());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", C5046bo.anU());
        intent.putExtra("notify_skey", this.ebz.gcU.mo5509jQ(1));
        C4990ab.m7416i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            C4990ab.m7417i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(C5046bo.m7575l(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length));
            sendBroadcast(intent);
            C41753a.m73606ll(i2);
        } catch (Throwable th) {
            C4990ab.m7413e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", C5046bo.m7574l(th));
        }
        AppMethodBeat.m2505o(57739);
        return true;
    }

    /* renamed from: bt */
    public final void mo5479bt(boolean z) {
        AppMethodBeat.m2504i(57740);
        if (z) {
            C4990ab.m7420w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            C1892aa.ank().geh = true;
            boolean Il = this.ebA.mo53065Il();
            if (!this.ebB || Il) {
                if (Il) {
                    C1892aa.ano().amN();
                }
                this.ebB = true;
                C1892aa.anl().mo53427mF(6);
                if (this.ebJ == null) {
                    this.ebJ = new WakerLock(getApplicationContext(), "MicroMsg.CoreService");
                }
                if (!this.ebJ.isLocking()) {
                    this.ebJ.lock(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, "CoreService.setNetworkAvailable");
                    this.ebG++;
                }
                if (0 == this.ebI) {
                    this.ebH = C5046bo.anU();
                }
                this.ebI++;
                C4990ab.m7417i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.ebG), Long.valueOf(this.ebI), Long.valueOf(C5046bo.anU() - this.ebH));
                this.ebL.mo16770ae(3000, 3000);
                AppMethodBeat.m2505o(57740);
                return;
            }
            C4990ab.m7417i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", Boolean.valueOf(this.ebB));
            AppMethodBeat.m2505o(57740);
            return;
        }
        C4990ab.m7420w("MicroMsg.CoreService", "[NETWORK LOST]");
        C1892aa.ank().geh = false;
        C1892aa.anl().mo53427mF(0);
        if (this.ebB) {
            C1892aa.ano().amN();
            this.ebA.ebY = null;
        }
        this.ebB = false;
        AppMethodBeat.m2505o(57740);
    }

    /* renamed from: Ie */
    public static void m16662Ie() {
        AppMethodBeat.m2504i(57741);
        Intent intent = new Intent(C1892aa.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", C1892aa.ano().gcU.mo5495QF());
        try {
            C1892aa.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(57741);
        } catch (Exception e) {
            C4990ab.m7415f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", e.toString());
            AppMethodBeat.m2505o(57741);
        }
    }

    /* renamed from: If */
    private void m16663If() {
        AppMethodBeat.m2504i(57742);
        C4990ab.m7420w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        C1892aa.anp().mo60745i(3, Downloads.MIN_WAIT_FOR_NETWORK, "");
        Mars.onDestroy();
        try {
            AlarmReceiver.m16681bs(getApplicationContext());
            AlarmReceiver.m16679bq(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
        }
        C4990ab.appenderClose();
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(57742);
    }

    public void restartProcess() {
        AppMethodBeat.m2504i(57743);
        C4990ab.m7420w("MicroMsg.CoreService", "restartProcess");
        m16663If();
        AppMethodBeat.m2505o(57743);
    }
}
