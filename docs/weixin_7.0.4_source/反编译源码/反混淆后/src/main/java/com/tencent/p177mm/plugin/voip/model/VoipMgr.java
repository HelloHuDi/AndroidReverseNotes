package com.tencent.p177mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.C1321a;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C45379vj;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver.C14032a;
import com.tencent.p177mm.plugin.voip.model.C35355p.C35357a;
import com.tencent.p177mm.plugin.voip.model.C4286s.C42856;
import com.tencent.p177mm.plugin.voip.model.C4286s.C42875;
import com.tencent.p177mm.plugin.voip.p1417a.C29487c;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip.p546ui.C14085b;
import com.tencent.p177mm.plugin.voip.p546ui.C46324c;
import com.tencent.p177mm.plugin.voip.p546ui.VoipScoreDialog;
import com.tencent.p177mm.plugin.voip.video.C14088g;
import com.tencent.p177mm.plugin.voip.video.C40042e;
import com.tencent.p177mm.plugin.voip.video.C43741k;
import com.tencent.p177mm.plugin.voip.video.C43741k.C22477a;
import com.tencent.p177mm.plugin.voip.video.C43741k.C43740b;
import com.tencent.p177mm.plugin.voip.video.C46326a;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.plugin.voip.widget.C22480b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import com.tencent.p177mm.sdk.platformtools.SensorController.C4986a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Timer;

/* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr */
public final class VoipMgr implements C1406a, C35357a, C35358u, C46324c, C14088g, C22477a, C4986a {
    static int idk = 0;
    static int[] sSf = new int[2];
    C45293b cqx;
    String edV;
    C7306ak iGP;
    private boolean mIsMute = false;
    private int mUIType;
    SensorController mfW;
    private long mui = 0;
    TelephonyManager nva;
    PhoneStateListener nvb = new C169064();
    C4884c nvc = new C1403512();
    private long nxl = 0;
    private boolean oue = false;
    long sQP = 0;
    long sQQ = 0;
    private C7564ap sRA = null;
    private C5004al sRB;
    private boolean sRC = false;
    private boolean sRD = false;
    private int sRE = 0;
    private boolean sRF = false;
    boolean sRG = false;
    private C22480b sRH;
    private boolean sRI = false;
    private boolean sRJ = false;
    public String sRK = null;
    boolean sRL = false;
    public C40042e sRM = null;
    public int sRN = -1;
    public int sRO = 0;
    private long sRP = -1;
    private boolean sRQ = false;
    private long sRR = 0;
    private long sRS = -1;
    int sRT = 0;
    boolean sRU = false;
    boolean sRV = false;
    private int sRW = 0;
    private byte[] sRX = null;
    private boolean sRY = true;
    int sRZ = 0;
    C29487c sRc;
    HeadsetPlugReceiver sRd;
    volatile C14085b sRe;
    private C46326a sRf;
    private CaptureView sRg;
    private C16914a sRh = null;
    private boolean sRi = false;
    private boolean sRj = false;
    private Object sRk = new Object();
    C7616ad sRl;
    boolean sRm;
    boolean sRn;
    boolean sRo = false;
    private int sRp = 4096;
    private boolean sRq = false;
    int sRr = 1;
    private long sRs = -1;
    private boolean sRt = false;
    boolean sRu = false;
    private boolean sRv = false;
    private boolean sRw = false;
    private int sRx = 0;
    private int sRy = 0;
    C43741k sRz = new C43741k();
    boolean sSa = false;
    NetChangedBroadcastReceiver sSb;
    PhoneStateListener sSc;
    C5004al sSd = new C5004al("getSignalStrength");
    C7306ak sSe = new C7306ak(this.sSd.oAl.getLooper());
    TelephonyManager sSg = null;
    private long sSh = 0;
    private boolean sSi = false;
    BroadcastReceiver sSj = new C42781();
    C14032a sSk = new C427715();
    int sSl = 0;
    C4884c sSm = new C716813();

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$14 */
    class C427614 implements OnClickListener {
        final /* synthetic */ Context sSy;

        C427614(Context context) {
            this.sSy = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4476);
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            C37657b.m63683bE(this.sSy);
            if (VoipMgr.this.sRm) {
                if (VoipMgr.this.sRn) {
                    VoipMgr.this.cJr();
                    AppMethodBeat.m2505o(4476);
                    return;
                }
                VoipMgr.this.cJs();
                AppMethodBeat.m2505o(4476);
            } else if (VoipMgr.this.sRn) {
                VoipMgr.this.cJm();
                AppMethodBeat.m2505o(4476);
            } else {
                VoipMgr.this.cJp();
                AppMethodBeat.m2505o(4476);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$15 */
    class C427715 implements C14032a {
        C427715() {
        }

        /* renamed from: fS */
        public final void mo9263fS(boolean z) {
            AppMethodBeat.m2504i(4477);
            boolean KP = C1407g.m2946KK().mo4819KP();
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b, bluetooth: %s", Boolean.valueOf(z), Boolean.valueOf(KP));
            if (!(z && 3 == VoipMgr.this.sRr) && (z || 3 == VoipMgr.this.sRr)) {
                if (C40025b.m68549GO(VoipMgr.this.sRc.mState)) {
                    if (z || KP) {
                        VoipMgr.m26095b(VoipMgr.this, false);
                        if (z) {
                            VoipMgr.this.sRr = 3;
                        } else {
                            VoipMgr.this.sRr = 4;
                        }
                    } else if (C43727b.cIj().sSP.cKq()) {
                        Toast.makeText(VoipMgr.m26114g(VoipMgr.this), VoipMgr.m26114g(VoipMgr.this).getString(C25738R.string.f7g), 0).show();
                        VoipMgr.m26095b(VoipMgr.this, true);
                        VoipMgr.this.sRr = 1;
                    } else {
                        VoipMgr.m26095b(VoipMgr.this, false);
                        VoipMgr.this.sRr = 2;
                    }
                } else if (z || KP) {
                    if (1 == VoipMgr.this.sRr) {
                        VoipMgr.m26095b(VoipMgr.this, false);
                        VoipMgr.this.sRt = true;
                    } else {
                        VoipMgr.this.sRt = false;
                    }
                    if (z) {
                        VoipMgr.this.sRr = 3;
                    } else {
                        VoipMgr.this.sRr = 4;
                    }
                } else if (C43727b.cIj().sSP.cKq()) {
                    if (VoipMgr.this.sRt || 2 == VoipMgr.this.mUIType) {
                        Toast.makeText(VoipMgr.m26114g(VoipMgr.this), VoipMgr.m26114g(VoipMgr.this).getString(C25738R.string.f7g), 0).show();
                        VoipMgr.m26095b(VoipMgr.this, true);
                        VoipMgr.this.sRr = 1;
                    } else {
                        Toast.makeText(VoipMgr.m26114g(VoipMgr.this), VoipMgr.m26114g(VoipMgr.this).getString(C25738R.string.f7f), 0).show();
                        VoipMgr.this.sRr = 2;
                    }
                    VoipMgr.this.sRt = false;
                } else {
                    VoipMgr.m26095b(VoipMgr.this, false);
                    VoipMgr.this.sRr = 2;
                }
                C43727b.cIj().mo26362jj(z);
                VoipMgr.m26094b(VoipMgr.this, VoipMgr.this.sRr);
                AppMethodBeat.m2505o(4477);
                return;
            }
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "same status, no changed");
            AppMethodBeat.m2505o(4477);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$1 */
    class C42781 extends BroadcastReceiver {
        C42781() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(4457);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) C4996ah.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                VoipMgr.this.sRw = false;
                AppMethodBeat.m2505o(4457);
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                VoipMgr.this.sRw = false;
                AppMethodBeat.m2505o(4457);
            } else {
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    VoipMgr.this.sRw = true;
                    if (!(C40025b.m68548GN(VoipMgr.this.sRc.mState) || VoipMgr.this.sRm)) {
                        C43727b.cIj().sSP.stopRing();
                    }
                }
                AppMethodBeat.m2505o(4457);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$3 */
    class C42793 implements Runnable {
        C42793() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4459);
            VoipMgr.m26131t(VoipMgr.this);
            AppMethodBeat.m2505o(4459);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$13 */
    class C716813 extends C4884c<C45379vj> {
        C716813() {
            AppMethodBeat.m2504i(4474);
            this.xxI = C45379vj.class.getName().hashCode();
            AppMethodBeat.m2505o(4474);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(4475);
            final C45379vj c45379vj = (C45379vj) c4883b;
            if (c45379vj instanceof C45379vj) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(4473);
                        switch (c45379vj.cSr.cuy) {
                            case 1:
                                if (C40025b.m68549GO(VoipMgr.this.sRc.mState)) {
                                    VoipMgr.this.cJn();
                                    AppMethodBeat.m2505o(4473);
                                    return;
                                }
                                VoipMgr.this.cJq();
                                AppMethodBeat.m2505o(4473);
                                return;
                            case 2:
                                if (C40025b.m68549GO(VoipMgr.this.sRc.mState)) {
                                    VoipMgr.this.cJm();
                                    AppMethodBeat.m2505o(4473);
                                    return;
                                }
                                VoipMgr.this.cJp();
                                AppMethodBeat.m2505o(4473);
                                return;
                            case 3:
                                VoipMgr.this.cJk();
                                break;
                        }
                        AppMethodBeat.m2505o(4473);
                    }
                });
            }
            AppMethodBeat.m2505o(4475);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$12 */
    class C1403512 extends C4884c<C18411uh> {
        C1403512() {
            AppMethodBeat.m2504i(4471);
            this.xxI = C18411uh.class.getName().hashCode();
            AppMethodBeat.m2505o(4471);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(4472);
            C18411uh c18411uh = (C18411uh) c4883b;
            if (c18411uh instanceof C18411uh) {
                c18411uh.cQt.cQu = C40025b.m68549GO(VoipMgr.this.sRc.mState);
                c18411uh.cQt.cQv = VoipMgr.this.sRf != null;
                c18411uh.cQt.cQw = true;
                c18411uh.cQt.talker = VoipMgr.this.edV;
                AppMethodBeat.m2505o(4472);
            } else {
                AppMethodBeat.m2505o(4472);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$2 */
    class C168982 implements Runnable {
        C168982() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4458);
            VoipMgr.m26099c(VoipMgr.this, VoipMgr.this.sRZ);
            VoipMgr.this.sSe.postDelayed(this, 5000);
            AppMethodBeat.m2505o(4458);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$9 */
    class C168999 implements Runnable {
        C168999() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4468);
            VoipMgr.m26081G(VoipMgr.this);
            AppMethodBeat.m2505o(4468);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$NetChangedBroadcastReceiver */
    public class NetChangedBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            int i = 0;
            AppMethodBeat.m2504i(4484);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                int i2;
                int aSQ;
                int i3;
                switch (C46317a.getNetType(context)) {
                    case 4:
                        if (VoipMgr.this.sRZ != 4) {
                            i2 = VoipMgr.sSf[0];
                            if (VoipMgr.this.sSl == 0) {
                                VoipMgr.m26099c(VoipMgr.this, 5);
                            }
                            aSQ = VoipMgr.idk / VoipMgr.this.sSl;
                            VoipMgr.m26099c(VoipMgr.this, 4);
                            i3 = VoipMgr.sSf[1];
                            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.this.mui);
                            if (!VoipMgr.this.sRm) {
                                i = 1;
                            }
                            C46317a.m86986a(i, System.currentTimeMillis(), VoipMgr.this.sRZ, 4, i2, i3, aSQ);
                            VoipMgr.this.sSa = true;
                            VoipMgr.this.sRZ = 4;
                            VoipMgr.idk = 0;
                            VoipMgr.this.sSl = 0;
                            break;
                        }
                        break;
                    case 5:
                        if (VoipMgr.this.sRZ != 5) {
                            i2 = VoipMgr.sSf[1];
                            if (VoipMgr.this.sSl == 0) {
                                VoipMgr.m26099c(VoipMgr.this, 4);
                            }
                            aSQ = VoipMgr.idk / VoipMgr.this.sSl;
                            VoipMgr.m26099c(VoipMgr.this, 5);
                            i3 = VoipMgr.sSf[0];
                            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.this.mui);
                            if (!VoipMgr.this.sRm) {
                                i = 1;
                            }
                            C46317a.m86986a(i, System.currentTimeMillis(), VoipMgr.this.sRZ, 5, i2, i3, aSQ);
                            VoipMgr.this.sSa = true;
                            VoipMgr.this.sRZ = 5;
                            VoipMgr.idk = 0;
                            VoipMgr.this.sSl = 0;
                            AppMethodBeat.m2505o(4484);
                            return;
                        }
                        break;
                }
                AppMethodBeat.m2505o(4484);
            } else if (intent.getAction().equals("android.net.wifi.STATE_CHANGE") && VoipMgr.this.sSh == 0) {
                VoipMgr.this.sSh = System.currentTimeMillis();
                AppMethodBeat.m2505o(4484);
            } else {
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && VoipMgr.this.sSh != 0) {
                    VoipMgr.this.mui = System.currentTimeMillis() - VoipMgr.this.sSh;
                    VoipMgr.this.sSh = 0;
                }
                AppMethodBeat.m2505o(4484);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$20 */
    class C1690020 implements Runnable {
        C1690020() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4482);
            VoipMgr voipMgr = VoipMgr.this;
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
            voipMgr.sSe.removeCallbacksAndMessages(null);
            voipMgr.sSd = null;
            if (!voipMgr.sSa) {
                if (voipMgr.sSl == 0) {
                    voipMgr.mo30875Gp(voipMgr.sRZ);
                }
                if (voipMgr.sSl != 0) {
                    voipMgr.sSa = true;
                    C46317a.m86986a(voipMgr.sRm ? 0 : 1, System.currentTimeMillis(), voipMgr.sRZ, voipMgr.sRZ, 0, 0, VoipMgr.idk / voipMgr.sSl);
                }
            }
            VoipMgr.idk = 0;
            VoipMgr.sSf[0] = 0;
            VoipMgr.sSf[1] = 0;
            voipMgr.sSl = 0;
            if (voipMgr.sSg != null) {
                voipMgr.sSg.listen(voipMgr.sSc, 0);
            }
            if (voipMgr.sSb != null) {
                C4996ah.getContext().unregisterReceiver(voipMgr.sSb);
                voipMgr.sSb = null;
            }
            VoipMgr.m26129r(VoipMgr.this);
            AppMethodBeat.m2505o(4482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$8 */
    class C169018 implements OnClickListener {
        C169018() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4467);
            VoipMgr.this.cJN();
            AppMethodBeat.m2505o(4467);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$10 */
    class C1690210 implements C5015a {
        C1690210() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(4469);
            VoipMgr.m26086H(VoipMgr.this);
            AppMethodBeat.m2505o(4469);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$18 */
    class C1690418 implements Runnable {
        C1690418() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4480);
            C43727b.cIj().sSP.stopRing();
            if (VoipMgr.this.sRn) {
                C43727b.cIj().mo26341Gx(0);
                AppMethodBeat.m2505o(4480);
                return;
            }
            C43727b.cIj().mo26341Gx(1);
            AppMethodBeat.m2505o(4480);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$4 */
    class C169064 extends PhoneStateListener {

        /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$4$1 */
        class C169071 implements Runnable {
            C169071() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4460);
                VoipMgr.m26095b(VoipMgr.this, true);
                AppMethodBeat.m2505o(4460);
            }
        }

        C169064() {
        }

        public final void onCallStateChanged(int i, String str) {
            int i2 = true;
            AppMethodBeat.m2504i(4461);
            super.onCallStateChanged(i, str);
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", Integer.valueOf(i), Boolean.valueOf(VoipMgr.this.sRG), Integer.valueOf(VoipMgr.this.sRW));
            if (VoipMgr.this.sRG) {
                if ((VoipMgr.this.sRW == 0 && i == 1) || (VoipMgr.this.sRW == 0 && i == 2)) {
                    VoipMgr.this.sRT = VoipMgr.this.sRT + 1;
                }
                if (i == 1) {
                    VoipMgr.this.sRI = true;
                    if (VoipMgr.this.sRW == 0) {
                        VoipMgr.this.sQP = System.currentTimeMillis();
                    }
                    VoipMgr.this.sRW = 1;
                    C43727b.cIj().mo26338Gj(1);
                    VoipMgr.this.sSi = true;
                    AppMethodBeat.m2505o(4461);
                    return;
                } else if (i == 2) {
                    String string;
                    VoipMgr.this.sRI = false;
                    if (VoipMgr.this.sRW == 1) {
                        VoipMgr.this.sQQ = System.currentTimeMillis();
                    }
                    VoipMgr.this.sRW = 2;
                    C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                    if (VoipMgr.this.sRm && !C40025b.m68548GN(VoipMgr.this.sRc.mState)) {
                        C4286s c4286s = C43727b.cIj().sSP;
                        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + c4286s.sNl.sPp.nwu);
                        if (c4286s.sNl.sPp.nwu != 0) {
                            c4286s.sNl.sPp.sVH.sQe = 102;
                            c4286s.sNl.sPp.sVH.sQq = 6;
                            if (C43727b.cIj().sSQ != null) {
                                c4286s.sNl.sPp.sVH.sQR = C43727b.cIj().sSQ.sRT;
                                c4286s.sNl.sPp.sVH.sQP = C43727b.cIj().sSQ.sQP / 1000;
                                c4286s.sNl.sPp.sVH.sQQ = C43727b.cIj().sSQ.sQQ / 1000;
                            }
                            C7060h.pYm.mo8377a(11521, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                            c4286s.cKk();
                        }
                    }
                    if (C40025b.m68548GN(VoipMgr.this.sRc.mState)) {
                        string = C4996ah.getContext().getString(C25738R.string.f47, new Object[]{VoipMgr.m26120lH(C5046bo.m7549fp(VoipMgr.this.sRs))});
                    } else {
                        string = C4996ah.getContext().getString(C25738R.string.f43);
                    }
                    C4286s c4286s2 = C43727b.cIj().sSP;
                    C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
                    if (c4286s2.sNl.sPp.nwu == 0) {
                        c4286s2.sNl.sPr.cIY();
                        c4286s2.reset();
                    } else {
                        c4286s2.sNl.sPp.sVH.sQe = 109;
                        c4286s2.sNl.sPp.sVH.sQw = 4;
                        c4286s2.cKn();
                    }
                    String str2 = VoipMgr.this.sRl.field_username;
                    String str3 = VoipMgr.this.sRn ? C7620bi.xZc : C7620bi.xZb;
                    if (!VoipMgr.this.sRm) {
                        i2 = 0;
                    }
                    C14055q.m22208a(str2, str3, i2, 6, string);
                    VoipMgr.m26111f(VoipMgr.this, 4107);
                    VoipMgr.m26076B(VoipMgr.this);
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                    c7620bi.mo14775eJ(System.currentTimeMillis());
                    c7620bi.setStatus(6);
                    c7620bi.setContent(C4996ah.getContext().getString(C25738R.string.f45) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.this.edV + "&isvideocall=" + VoipMgr.this.sRn + "\">" + C4996ah.getContext().getString(C25738R.string.f40) + "</a>");
                    if (!(VoipMgr.this.edV == null || VoipMgr.this.edV.equals(""))) {
                        c7620bi.mo14794ju(VoipMgr.this.edV);
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                    }
                    C43727b.cIj().mo26338Gj(2);
                    VoipMgr.this.sSi = false;
                    AppMethodBeat.m2505o(4461);
                    return;
                } else {
                    if (i == 0) {
                        if (VoipMgr.this.sRW == 1 || VoipMgr.this.sRW == 2) {
                            VoipMgr.this.sQQ = System.currentTimeMillis();
                        }
                        VoipMgr.this.sRW = 0;
                        C43727b.cIj().mo26338Gj(2);
                        if (1 == VoipMgr.this.sRr && C40025b.m68548GN(VoipMgr.this.sRc.mState) && VoipMgr.this.sRI) {
                            C5004al.m7441d(new C169071());
                        }
                        VoipMgr.this.sRI = false;
                        if (C1407g.m2946KK() != null && C1407g.m2946KK().eoY.isBluetoothScoOn()) {
                            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
                            C1407g.m2946KK().mo4817KM();
                        }
                        VoipMgr.this.sSi = false;
                    }
                    AppMethodBeat.m2505o(4461);
                    return;
                }
            }
            AppMethodBeat.m2505o(4461);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$5 */
    class C169085 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$5$1 */
        class C169091 implements Runnable {
            C169091() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4462);
                VoipMgr.m26129r(VoipMgr.this);
                AppMethodBeat.m2505o(4462);
            }
        }

        C169085() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4463);
            VoipMgr.m26091a(VoipMgr.this, VoipMgr.m26114g(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0));
            if (4096 != VoipMgr.this.sRp) {
                VoipMgr.m26111f(VoipMgr.this, VoipMgr.this.sRp);
                VoipMgr.this.sRp = 4096;
            }
            if (VoipMgr.this.iGP != null) {
                VoipMgr.this.iGP.post(new C169091());
            }
            AppMethodBeat.m2505o(4463);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$17 */
    class C1691117 implements Runnable {
        C1691117() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4479);
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.this.sRf);
            if (VoipMgr.this.sRf != null) {
                VoipMgr.this.sRf.cLC();
            }
            AppMethodBeat.m2505o(4479);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$16 */
    class C1691316 extends PhoneStateListener {
        C1691316() {
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            AppMethodBeat.m2504i(4478);
            super.onSignalStrengthsChanged(signalStrength);
            super.onSignalStrengthsChanged(signalStrength);
            String[] split = signalStrength.toString().split(" ");
            try {
                if (VoipMgr.this.sSg.getNetworkType() == 13 && split.length > 9) {
                    VoipMgr.sSf[0] = C5046bo.ank(split[9]);
                }
                AppMethodBeat.m2505o(4478);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Voip.VoipMgr", e, "", new Object[0]);
                AppMethodBeat.m2505o(4478);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$a */
    class C16914a implements Runnable {
        C16914a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4483);
            VoipMgr.m26132u(VoipMgr.this);
            VoipMgr.this.sRh = null;
            AppMethodBeat.m2505o(4483);
        }
    }

    public VoipMgr() {
        AppMethodBeat.m2504i(4485);
        AppMethodBeat.m2505o(4485);
    }

    /* renamed from: B */
    static /* synthetic */ void m26076B(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4562);
        voipMgr.cJz();
        AppMethodBeat.m2505o(4562);
    }

    /* renamed from: G */
    static /* synthetic */ void m26081G(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4565);
        voipMgr.mo30912mu(true);
        AppMethodBeat.m2505o(4565);
    }

    /* renamed from: g */
    static /* synthetic */ Context m26114g(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4554);
        Context context = voipMgr.getContext();
        AppMethodBeat.m2505o(4554);
        return context;
    }

    /* renamed from: lH */
    static /* synthetic */ String m26120lH(long j) {
        AppMethodBeat.m2504i(4560);
        String fQ = VoipMgr.m26113fQ(j);
        AppMethodBeat.m2505o(4560);
        return fQ;
    }

    /* renamed from: t */
    static /* synthetic */ void m26131t(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4558);
        voipMgr.cJF();
        AppMethodBeat.m2505o(4558);
    }

    /* renamed from: u */
    static /* synthetic */ void m26132u(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4559);
        voipMgr.cJH();
        AppMethodBeat.m2505o(4559);
    }

    /* renamed from: he */
    public final void mo10257he(boolean z) {
        AppMethodBeat.m2504i(4486);
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", Boolean.valueOf(z), Boolean.valueOf(this.sRQ), Long.valueOf(this.sRP));
        if (this.sRc == null) {
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
            AppMethodBeat.m2505o(4486);
        } else if (Math.abs(C5046bo.m7588yz() - this.sRS) >= 500 || this.sRS == -1) {
            if (C40025b.m68548GN(this.sRc.mState) && (this.sRQ != z || this.sRP == -1)) {
                if (!(this.sRQ || !z || C40025b.m68549GO(this.sRc.mState) || this.mUIType == 2 || this.sRP == -1)) {
                    C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", Long.valueOf(C5046bo.m7525az(this.sRP)));
                    this.sRR = r0 + this.sRR;
                }
                this.sRP = C5046bo.m7588yz();
                this.sRQ = z;
            }
            if (this.sRe == null) {
                C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
                AppMethodBeat.m2505o(4486);
                return;
            }
            if (!((!this.sRm && !C40025b.m68548GN(this.sRc.mState)) || C40025b.m68549GO(this.sRc.mState) || this.mUIType == 2)) {
                C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(z)));
                this.sRe.setScreenEnable(z);
                this.sRS = C5046bo.m7588yz();
            }
            AppMethodBeat.m2505o(4486);
        } else {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
            AppMethodBeat.m2505o(4486);
        }
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(4487);
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b, isHeadsetPlugged: %s", Integer.valueOf(i), Boolean.valueOf(this.sRu), Boolean.valueOf(C1407g.m2946KK().mo4822KV()));
        switch (i) {
            case 1:
                if (!C40025b.m68549GO(this.sRc.mState)) {
                    this.sRu = 1 == this.sRr;
                }
                C1407g.m2946KK().mo4830b(false, C43727b.cIj().sSP.sNl.cIt(), false);
                C43727b.cIj().mo26363mj(false);
                C43727b.cIj().mo26365mp(false);
                m26082Go(4);
                this.sRL = false;
                C43727b.cIj().mo26362jj(true);
                AppMethodBeat.m2505o(4487);
                return;
            case 2:
                if (!this.sSi) {
                    C1407g.m2946KK().mo4818KN();
                    cJj();
                    this.sRU = true;
                    AppMethodBeat.m2505o(4487);
                    return;
                }
                break;
            case 3:
                C1407g.m2946KK().mo4817KM();
                this.sRL = false;
                AppMethodBeat.m2505o(4487);
                return;
            case 4:
                C1407g.m2946KK().mo4818KN();
                C1407g.m2946KK().mo4816KL();
                cJj();
                AppMethodBeat.m2505o(4487);
                return;
            case 5:
                C1407g.m2946KK().mo4817KM();
                break;
        }
        AppMethodBeat.m2505o(4487);
    }

    private void cJj() {
        AppMethodBeat.m2504i(4488);
        boolean KV = C1407g.m2946KK().mo4822KV();
        String str = "MicroMsg.Voip.VoipMgr";
        String str2 = "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s";
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(this.sRL);
        objArr[1] = Boolean.valueOf(C40025b.m68549GO(this.sRc.mState));
        objArr[2] = Boolean.valueOf(C43727b.cIj().sSP.cKq());
        objArr[3] = Boolean.valueOf(this.sRu);
        objArr[4] = Boolean.valueOf(2 == this.mUIType);
        objArr[5] = Boolean.valueOf(KV);
        C4990ab.m7417i(str, str2, objArr);
        if (!this.sRL) {
            if (C40025b.m68549GO(this.sRc.mState)) {
                if (!C43727b.cIj().sSP.cKq()) {
                    m26122mr(false);
                    this.sRr = 2;
                } else if (KV) {
                    m26122mr(false);
                    this.sRr = 2;
                } else {
                    m26087P(true, true);
                    this.sRr = 1;
                }
            } else if (C43727b.cIj().sSP.cKq()) {
                if ((this.sRu || 2 == this.mUIType) && !KV) {
                    m26087P(true, true);
                    this.sRr = 1;
                } else if (KV) {
                    this.sRr = 3;
                } else {
                    this.sRr = 2;
                }
                this.sRu = false;
            } else {
                m26122mr(false);
                this.sRr = 2;
            }
            m26082Go(this.sRr);
            this.sRL = true;
            C43727b.cIj().mo26362jj(false);
        }
        AppMethodBeat.m2505o(4488);
    }

    /* renamed from: Go */
    private void m26082Go(int i) {
        AppMethodBeat.m2504i(4489);
        this.sRr = i;
        if (this.sRe != null) {
            this.sRe.mo26389GC(this.sRr);
        }
        AppMethodBeat.m2505o(4489);
    }

    /* renamed from: mr */
    private void m26122mr(boolean z) {
        AppMethodBeat.m2504i(4490);
        m26087P(z, this.sRU);
        AppMethodBeat.m2505o(4490);
    }

    /* renamed from: P */
    private void m26087P(boolean z, boolean z2) {
        AppMethodBeat.m2504i(4491);
        C4990ab.m7408b("MicroMsg.Voip.VoipMgr", "enableSpeaker: %s, ignoreBluetooth: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.sRt = z;
        this.sRu = z;
        C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + C1407g.m2946KK().mo4820KT());
        if (!z2 && C1407g.m2946KK().mo4819KP()) {
            z = false;
        }
        if (C1427q.etd.epG) {
            C1427q.etd.dump();
            if (C1427q.etd.epH > 0) {
                C43727b.cIj().mo26363mj(z);
            }
        }
        if (C1427q.etd.eqj >= 0 || C1427q.etd.eqk >= 0) {
            C43727b.cIj().mo26363mj(z);
        }
        C1407g.m2946KK().mo4830b(z, C43727b.cIj().sSP.cIt(), z2);
        C43727b.cIj().mo26365mp(z);
        this.sRv = z;
        AppMethodBeat.m2505o(4491);
    }

    /* renamed from: ms */
    public final void mo30911ms(boolean z) {
        int i;
        AppMethodBeat.m2504i(4492);
        C4990ab.m7411d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", Boolean.valueOf(z));
        if (C43727b.cIj().sSP.cKq()) {
            m26122mr(z);
        } else {
            C4286s c4286s = C43727b.cIj().sSP;
            if (c4286s.sTj != null) {
                c4286s.sTj.mo38024mE(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        m26082Go(i);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        c7060h.mo8381e(11080, objArr);
        AppMethodBeat.m2505o(4492);
    }

    /* renamed from: jg */
    public final void mo30910jg(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(4493);
        C40031m c40031m;
        if (z) {
            c40031m = C43727b.cIj().sSP.sNl.sPr;
            if (c40031m.kzb != null) {
                c40031m.kzb.mo4597bs(true);
            }
            C43727b.cIj().mo26337Gh(9);
            C43727b.cIj().mo26364mo(true);
        } else {
            c40031m = C43727b.cIj().sSP.sNl.sPr;
            if (c40031m.kzb != null) {
                c40031m.kzb.mo4597bs(false);
            }
            C43727b.cIj().mo26337Gh(8);
            C43727b.cIj().mo26364mo(false);
        }
        this.mIsMute = z;
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        c7060h.mo8381e(11080, objArr);
        AppMethodBeat.m2505o(4493);
    }

    public final boolean cJk() {
        AppMethodBeat.m2504i(4494);
        if (this.sRc.mo47747GQ(4103)) {
            m26083Gq(4103);
            C43727b.cIj().cKe();
            AppMethodBeat.m2505o(4494);
            return true;
        }
        AppMethodBeat.m2505o(4494);
        return false;
    }

    public final boolean cJl() {
        AppMethodBeat.m2504i(4495);
        if (this.sRc.mo47747GQ(4101)) {
            C43727b.cIj().sSP.stopRing();
            C43727b.cIj().mo26337Gh(1);
            C43727b.cIj().mo26343R(true, this.sRn);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv);
            objArr[2] = Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(this.sRm ? 1 : 0);
            c7060h.mo8381e(11046, objArr);
            C7060h.pYm.mo8381e(11080, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
            m26126oE(4111);
            m26126oE(4101);
            m26126oE(4100);
            AppMethodBeat.m2505o(4495);
            return true;
        }
        AppMethodBeat.m2505o(4495);
        return false;
    }

    public final boolean cJm() {
        int i = 0;
        AppMethodBeat.m2504i(4496);
        if (this.sRc.mo47747GQ(4099)) {
            String str = this.sRl.field_username;
            String str2 = this.sRn ? C7620bi.xZc : C7620bi.xZb;
            if (this.sRm) {
                i = 1;
            }
            C14055q.m22208a(str, str2, i, 6, C4996ah.getContext().getString(C25738R.string.f4_));
            C43727b.cIj().sSP.stopRing();
            C43727b.cIj().sSP.cKl();
            m26126oE(4099);
            cJz();
            AppMethodBeat.m2505o(4496);
            return true;
        }
        AppMethodBeat.m2505o(4496);
        return false;
    }

    public final boolean cJn() {
        AppMethodBeat.m2504i(4497);
        if (this.sRc.mo47747GQ(4100)) {
            if (C1427q.etc.eqU == 1 && this.sRn) {
                m26123mt(true);
            }
            if ((!this.sRY || C1427q.etc.eqU == 1 || C1427q.etc.eqV == 1) && this.sRn) {
                boolean z = this.sRf == null || this.sRf.cLE();
                m26123mt(z);
                this.sRY = true;
            }
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
            C43727b.cIj().sSP.stopRing();
            C43727b.cIj().mo26343R(false, this.sRn);
            m26126oE(4100);
            AppMethodBeat.m2505o(4497);
            return true;
        }
        AppMethodBeat.m2505o(4497);
        return false;
    }

    public final void cJo() {
        this.sRY = false;
    }

    public final boolean cJp() {
        int i = 0;
        AppMethodBeat.m2504i(4498);
        if (this.sRc.mo47747GQ(4099)) {
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
            String str = this.sRl.field_username;
            String str2 = this.sRn ? C7620bi.xZc : C7620bi.xZb;
            if (this.sRm) {
                i = 1;
            }
            C14055q.m22208a(str, str2, i, 6, C4996ah.getContext().getString(C25738R.string.f4_));
            C43727b.cIj().sSP.stopRing();
            C43727b.cIj().sSP.cKl();
            m26126oE(4099);
            cJz();
            AppMethodBeat.m2505o(4498);
            return true;
        }
        AppMethodBeat.m2505o(4498);
        return false;
    }

    public final boolean cJq() {
        AppMethodBeat.m2504i(4499);
        if (this.sRc.mo47747GQ(4100)) {
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
            C43727b.cIj().sSP.stopRing();
            C43727b.cIj().mo26343R(true, this.sRn);
            m26126oE(4111);
            m26126oE(4100);
            AppMethodBeat.m2505o(4499);
            return true;
        }
        AppMethodBeat.m2505o(4499);
        return false;
    }

    public final boolean cJr() {
        AppMethodBeat.m2504i(4500);
        if (this.sRc.mo47747GQ(4098)) {
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
            m26083Gq(4098);
            C43727b.cIj().cKe();
            AppMethodBeat.m2505o(4500);
            return true;
        }
        AppMethodBeat.m2505o(4500);
        return false;
    }

    public final boolean cJs() {
        AppMethodBeat.m2504i(4501);
        if (this.sRc.mo47747GQ(4098)) {
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
            m26083Gq(4098);
            C43727b.cIj().cKe();
            AppMethodBeat.m2505o(4501);
            return true;
        }
        AppMethodBeat.m2505o(4501);
        return false;
    }

    /* renamed from: a */
    public final void mo30879a(C14085b c14085b, int i) {
        AppMethodBeat.m2504i(4502);
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s", Integer.valueOf(i), this.sRf);
        if (1 == i && this.sRe != null) {
            this.sRe.uninit();
        }
        this.sRe = c14085b;
        this.mUIType = i;
        if (this.sRf == null && C40025b.m68549GO(this.sRc.mState)) {
            this.sRg = new CaptureView(C4996ah.getContext());
        }
        if (this.sRn) {
            this.sRe.setCaptureView(this.sRg);
            if (C1427q.etc.eqU == 0) {
                boolean z = this.sRf == null || this.sRf.cLE();
                m26123mt(z);
            }
        }
        this.sRe.mo26399fY(-1, this.sRc.mState);
        this.sRe.setConnectSec(this.sRs);
        this.sRe.mo26389GC(this.sRr);
        this.sRe.setMute(this.mIsMute);
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", Integer.valueOf(this.sRN), Integer.valueOf(this.sRO));
        if (this.sRN != -1) {
            this.sRe.setHWDecMode(this.sRN);
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", Integer.valueOf(this.sRN));
        }
        this.sRe.setVoipBeauty(this.sRO);
        AppMethodBeat.m2505o(4502);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Gp */
    public final void mo30875Gp(int i) {
        AppMethodBeat.m2504i(4503);
        if (i == 5) {
            idk += sSf[0];
            this.sSl++;
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + sSf[0] + " and index is " + this.sSl);
            AppMethodBeat.m2505o(4503);
            return;
        }
        if (i == 4) {
            WifiManager wifiManager = (WifiManager) C4996ah.getContext().getApplicationContext().getSystemService("wifi");
            idk += wifiManager.getConnectionInfo().getRssi();
            sSf[1] = wifiManager.getConnectionInfo().getRssi();
            this.sSl++;
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + wifiManager.getConnectionInfo().getRssi() + " and index is " + this.sSl);
        }
        AppMethodBeat.m2505o(4503);
    }

    public final void cJt() {
        AppMethodBeat.m2504i(4504);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "it is init voip report");
        this.sSb = new NetChangedBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        C4996ah.getContext().registerReceiver(this.sSb, intentFilter);
        this.sSg = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        this.sRZ = C46317a.getNetType(getContext());
        this.sSc = new C1691316();
        this.sSg.listen(this.sSc, 256);
        AppMethodBeat.m2505o(4504);
    }

    /* renamed from: mt */
    private void m26123mt(boolean z) {
        AppMethodBeat.m2504i(4505);
        if (this.sRn) {
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", Boolean.valueOf(z));
            int i = 320;
            int i2 = 240;
            if (v2protocal.sTV) {
                C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i = 640;
                i2 = 480;
            }
            if (this.sRf == null) {
                this.sRf = new C46326a(i, i2);
            }
            this.sRY = this.sRf.mo74532a((C14088g) this, z) == 1;
            if (this.sRY && this.sRg != null) {
                this.sRf.mo74533a(this.sRg);
                C43727b.cIj().mo26340Gw(this.sRf.cLG());
                if (this.iGP != null) {
                    this.iGP.postDelayed(new C1691117(), 50);
                }
            }
        }
        AppMethodBeat.m2505o(4505);
    }

    /* renamed from: a */
    public final void mo30878a(C14085b c14085b) {
        AppMethodBeat.m2504i(4506);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.sRe == c14085b) {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.sRe = null;
        }
        if (this.iGP != null) {
            this.iGP = null;
        }
        AppMethodBeat.m2505o(4506);
    }

    public final void cJu() {
        AppMethodBeat.m2504i(4507);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.sRf != null) {
            this.sRf.cLB();
        }
        C7060h.pYm.mo8381e(11079, Integer.valueOf(1));
        AppMethodBeat.m2505o(4507);
    }

    public final void cJv() {
        AppMethodBeat.m2504i(4508);
        if (true != this.sRf.cLE()) {
            cJu();
        }
        AppMethodBeat.m2505o(4508);
    }

    /* renamed from: Gq */
    private void m26083Gq(int i) {
        String string;
        int i2 = 0;
        AppMethodBeat.m2504i(4509);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == cJJ()) {
            this.sRp = i;
        }
        Context context = C4996ah.getContext();
        if (C40025b.m68548GN(this.sRc.mState)) {
            string = context.getString(C25738R.string.f47, new Object[]{VoipMgr.m26113fQ(C5046bo.m7549fp(this.sRs))});
        } else if (this.sRm) {
            string = context.getString(C25738R.string.f42);
        } else {
            string = context.getString(C25738R.string.f41);
        }
        String str = this.sRl.field_username;
        String str2 = this.sRn ? C7620bi.xZc : C7620bi.xZb;
        if (this.sRm) {
            i2 = 1;
        }
        C14055q.m22208a(str, str2, i2, 6, string);
        if (!this.sRm || C40025b.m68548GN(this.sRc.mState)) {
            C7305d.post(new C1690418(), "VoipMgr_play_end_sound");
            this.sRi = true;
            this.sRj = true;
            C43727b.cIj().sSP.cKm();
            if (4096 == this.sRp) {
                m26126oE(i);
                cJz();
            }
        } else {
            C43727b.cIj().sSP.stopRing();
            if (this.sRm && !C40025b.m68548GN(this.sRc.mState)) {
                C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
                C43727b.cIj().sSP.cKj();
            }
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
            C43727b.cIj().sSP.cKm();
            if (4096 == this.sRp) {
                m26126oE(i);
                cJz();
                AppMethodBeat.m2505o(4509);
                return;
            }
        }
        AppMethodBeat.m2505o(4509);
    }

    /* renamed from: b */
    public final void mo30882b(MMTextureView mMTextureView) {
        AppMethodBeat.m2504i(4510);
        if (this.sRM != null) {
            C40042e c40042e = this.sRM;
            C4990ab.m7416i("DecodeTextureView", "steve: init hwview, recreateView: ".concat(String.valueOf(mMTextureView)));
            c40042e.mdt = mMTextureView;
            c40042e.mdt.setSurfaceTextureListener(c40042e);
            if (!(c40042e.sZW == null || c40042e.sZW == mMTextureView.getSurfaceTexture())) {
                C4990ab.m7416i("DecodeTextureView", "using saved st=" + c40042e.sZW);
                mMTextureView.setSurfaceTexture(c40042e.sZW);
            }
        }
        AppMethodBeat.m2505o(4510);
    }

    public final boolean cJw() {
        AppMethodBeat.m2504i(4511);
        if (C43727b.cIj().sSP.sNl.sPp.nwu == 0) {
            this.sRq = true;
            AppMethodBeat.m2505o(4511);
            return true;
        }
        boolean cJx = cJx();
        AppMethodBeat.m2505o(4511);
        return cJx;
    }

    private boolean cJx() {
        AppMethodBeat.m2504i(4512);
        if (this.sRc.mo47747GQ(4101)) {
            Object[] objArr;
            C7060h c7060h;
            int i;
            int i2;
            Object[] objArr2;
            int i3;
            m26126oE(4101);
            Object[] objArr3;
            if (C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW == this.sRc.mState || 7 == this.sRc.mState) {
                C43727b.cIj().mo26337Gh(1);
                C7060h c7060h2 = C7060h.pYm;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv);
                objArr[2] = Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(this.sRm ? 1 : 0);
                c7060h2.mo8381e(11046, objArr);
                c7060h = C7060h.pYm;
                i = 11080;
                objArr3 = new Object[3];
                objArr3[0] = Integer.valueOf(2);
                objArr3[1] = Integer.valueOf(0);
                i2 = 2;
                objArr2 = objArr3;
                objArr = objArr3;
            } else {
                if (1 == this.sRc.mState || 3 == this.sRc.mState) {
                    C43727b.cIj().mo26337Gh(1);
                    c7060h = C7060h.pYm;
                    i = 11046;
                    objArr3 = new Object[5];
                    objArr3[0] = Integer.valueOf(1);
                    objArr3[1] = Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv);
                    objArr3[2] = Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu);
                    objArr3[3] = Integer.valueOf(0);
                    i2 = 4;
                    if (this.sRm) {
                        i3 = 1;
                        objArr2 = objArr3;
                        objArr = objArr3;
                        objArr2[i2] = Integer.valueOf(i3);
                        c7060h.mo8381e(i, objArr);
                    } else {
                        objArr2 = objArr3;
                        objArr = objArr3;
                    }
                }
                C43727b.cIj().sSP.sNl.cIP();
                C43727b.cIj().sSP.sNl.cIQ();
                this.sRn = false;
                AppMethodBeat.m2505o(4512);
                return true;
            }
            i3 = 0;
            objArr2[i2] = Integer.valueOf(i3);
            c7060h.mo8381e(i, objArr);
            C43727b.cIj().sSP.sNl.cIP();
            C43727b.cIj().sSP.sNl.cIQ();
            this.sRn = false;
            AppMethodBeat.m2505o(4512);
            return true;
        }
        AppMethodBeat.m2505o(4512);
        return false;
    }

    public final void cJy() {
        AppMethodBeat.m2504i(4513);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.sRq && C43727b.cIj().sSP.sNl.sPp.nwu != 0) {
            this.sRq = false;
            cJx();
        }
        if (this.sRm) {
            m26126oE(4097);
        }
        AppMethodBeat.m2505o(4513);
    }

    /* renamed from: oE */
    private void m26126oE(final int i) {
        AppMethodBeat.m2504i(4514);
        C4990ab.m7408b("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", C40025b.m68545GK(i), C40025b.m68545GK(this.sRc.mState));
        if (4101 == i && C40025b.m68549GO(this.sRc.mState)) {
            cJI();
            this.sRn = false;
        }
        if (m26084Gr(i) && 1 == this.mUIType && 1 == this.sRr) {
            this.sRJ = true;
            m26122mr(false);
            m26082Go(2);
        }
        this.sRc.mo47748GR(i);
        if (this.iGP != null) {
            this.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(4481);
                    if (VoipMgr.this.sRe != null) {
                        VoipMgr.this.sRe.mo26399fY(i, VoipMgr.this.sRc.mState);
                    }
                    AppMethodBeat.m2505o(4481);
                }
            });
        }
        switch (this.sRc.mState) {
            case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
            case C31128d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                VoipMgr.m26085Gs(5);
                AppMethodBeat.m2505o(4514);
                return;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                VoipMgr.m26085Gs(6);
                break;
        }
        AppMethodBeat.m2505o(4514);
    }

    /* renamed from: Gr */
    private boolean m26084Gr(int i) {
        AppMethodBeat.m2504i(4515);
        if (4111 == i) {
            AppMethodBeat.m2505o(4515);
            return true;
        } else if (4101 == i && (C40025b.m68548GN(this.sRc.mState) || this.sRm)) {
            AppMethodBeat.m2505o(4515);
            return true;
        } else {
            AppMethodBeat.m2505o(4515);
            return false;
        }
    }

    /* renamed from: Gs */
    private static void m26085Gs(int i) {
        AppMethodBeat.m2504i(4516);
        C45379vj c45379vj = new C45379vj();
        c45379vj.cSr.cuy = i;
        C4879a.xxA.mo10055m(c45379vj);
        AppMethodBeat.m2505o(4516);
    }

    public final void onError(int i, String str) {
        String string;
        AppMethodBeat.m2504i(4517);
        if (this.sRn) {
            C43727b.cIj().mo26341Gx(0);
        } else {
            C43727b.cIj().mo26341Gx(1);
        }
        if (i == C31128d.MIC_PTU_QINGCONG && C5046bo.isNullOrNil(str)) {
            str = getContext().getString(C25738R.string.f6k);
        }
        if (this.sRe != null) {
            this.sRe.mo26393br(i, str);
        }
        m26126oE(4109);
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", Integer.valueOf(i), Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu));
        Context context = C4996ah.getContext();
        C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(i)));
        if (i == C31128d.MIC_PTU_AUTOLEVEL) {
            string = context.getString(C25738R.string.f4b);
        } else if (i == C31128d.MIC_PTU_MEISHI) {
            string = context.getString(C25738R.string.f44);
        } else if (i == C31128d.MIC_PTU_LENGMEIREN) {
            string = context.getString(C25738R.string.f4b);
        } else if (i == 236) {
            string = context.getString(C25738R.string.f44);
        } else if (i == 211) {
            string = context.getString(C25738R.string.f4a);
        } else {
            string = context.getString(C25738R.string.f43);
        }
        String str2;
        String str3;
        int i2;
        if (C43727b.cIj().sSP.sNl.sPp.nwu != 0 && C43727b.cIj().sSU.get(Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu)) == null) {
            str2 = this.sRl.field_username;
            if (this.sRn) {
                str3 = C7620bi.xZc;
            } else {
                str3 = C7620bi.xZb;
            }
            if (this.sRm) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (C40025b.m68548GN(this.sRc.mState)) {
                string = C4996ah.getContext().getString(C25738R.string.f48, new Object[]{VoipMgr.m26113fQ(C5046bo.m7549fp(this.sRs))});
            }
            C43727b.cIj().sSU.put(Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C14055q.m22209a(str2, str3, i2, 6, string, true)));
        } else if (C43727b.cIj().sSP.sNl.sPp.nwu == 0) {
            str2 = this.sRl.field_username;
            if (this.sRn) {
                str3 = C7620bi.xZc;
            } else {
                str3 = C7620bi.xZb;
            }
            if (this.sRm) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (C40025b.m68548GN(this.sRc.mState)) {
                string = C4996ah.getContext().getString(C25738R.string.f48, new Object[]{VoipMgr.m26113fQ(C5046bo.m7549fp(this.sRs))});
            }
            C14055q.m22209a(str2, str3, i2, 6, string, true);
        }
        C43727b.cIj().cKe();
        cJz();
        AppMethodBeat.m2505o(4517);
    }

    public final void bGL() {
        AppMethodBeat.m2504i(4518);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "on accept");
        C43727b.cIj().sSP.stopRing();
        m26126oE(4100);
        AppMethodBeat.m2505o(4518);
    }

    public final void onReject() {
        AppMethodBeat.m2504i(4519);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onReject");
        m26126oE(4099);
        C14055q.m22208a(this.sRl.field_username, this.sRn ? C7620bi.xZc : C7620bi.xZb, this.sRm ? 1 : 0, 6, C4996ah.getContext().getString(C25738R.string.f4d));
        cJz();
        AppMethodBeat.m2505o(4519);
    }

    private void cJz() {
        AppMethodBeat.m2504i(4520);
        C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.sRK = null;
        if (this.iGP != null) {
            this.iGP.postDelayed(new C1690020(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(4520);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mu */
    public final void mo30912mu(boolean z) {
        C14058r cIj;
        AppMethodBeat.m2504i(4521);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "finish");
        this.sRG = false;
        this.sRI = false;
        if (this.sRx != -1) {
            C7060h.pYm.mo8381e(11700, Integer.valueOf(this.sRx), Long.valueOf(C5046bo.m7549fp(this.sRs)));
            this.sRx = -1;
        }
        try {
            C4996ah.getContext().unregisterReceiver(this.sSj);
        } catch (Exception e) {
        }
        C4879a.xxA.mo10053d(this.nvc);
        C4879a.xxA.mo10053d(this.sSm);
        if (this.sRe != null) {
            this.sRe.uninit();
            this.sRe = null;
        }
        this.sRg = null;
        this.sRM = null;
        C1407g.m2946KK().mo4829b((C1406a) this);
        C1407g.m2946KK().mo4818KN();
        if (C43727b.cIj() != null) {
            C43727b.cIj().sSP.stopRing();
            if (z) {
                C43727b.cIj().sSP.cKo();
            } else {
                C43727b.cIj().sSP.cKm();
            }
            if (this.sRn) {
                C43727b.cIj().mo26350b(false, true, this.edV);
            } else {
                C43727b.cIj().mo26350b(false, false, this.edV);
            }
            cIj = C43727b.cIj();
            Context context = C4996ah.getContext();
            C4286s c4286s = cIj.sSP;
            if (context == c4286s.sNl.jiq && this == c4286s.sNl.sPq) {
                c4286s.sNl.jiq = null;
                c4286s.sNl.sPq = C35358u.sTD;
                C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                C46317a.flushLogFile();
            } else {
                C46317a.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        cIj = C43727b.cIj();
        cIj.sSQ = null;
        cIj.sSY = null;
        cIj.sSZ = false;
        cIj.sTe = false;
        if (this.sRi) {
            this.sRh = new C16914a();
            C7305d.post(this.sRh, "VoipMgr_clean");
        } else {
            cJH();
        }
        if (!(this.nva == null || this.nvb == null)) {
            this.nva.listen(this.nvb, 0);
            this.nvb = null;
        }
        if (this.sRd != null) {
            this.sRd.mo26277fa(C4996ah.getContext());
        }
        this.nva = null;
        C1321a.m2829Ib().mo4648Ic();
        C35355p.cJR().cJT();
        C35355p.cJR().mo56094a(null);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        if (this.mfW != null) {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
            this.mfW.dps();
            this.mfW = null;
            this.sRQ = false;
            this.sRR = 0;
            this.sRP = -1;
        }
        this.sRS = -1;
        C43727b.cIj().cKe();
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", Boolean.valueOf(this.sRj));
        if (this.sRj) {
            Object obj;
            VoipScoreState voipScoreState = C43727b.cIj().sSP.sNl.sPB;
            C1720g.m3537RQ();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOIP_LAST_SCORE_TIME_LONG, Long.valueOf(-1))).longValue();
            voipScoreState.sSO = longValue > 0 ? longValue : 0;
            C4990ab.m7417i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", Long.valueOf(C1829bf.aaa()), Long.valueOf(longValue), Integer.valueOf(voipScoreState.sSN));
            if (C5046bo.isNullOrNil(voipScoreState.sSM) || voipScoreState.sSN <= 0 || (longValue > 0 && r0 - longValue <= ((long) voipScoreState.sSN) * 86400000)) {
                obj = null;
            } else {
                C4990ab.m7416i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
                obj = 1;
            }
            if (obj != null) {
                C43727b.cIj();
                VoipScoreState.cJX();
                Intent intent = new Intent(getContext(), VoipScoreDialog.class);
                intent.putExtra("key_score_state", C43727b.cIj().sSP.sNl.sPB);
                if (!(getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                getContext().startActivity(intent);
            }
        }
        C43727b.cIj().sSP.sNl.sPB = new VoipScoreState();
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 11;
        C4879a.xxA.mo10055m(c26250ui);
        if (!this.sRV) {
            C46317a.m86991c(C43727b.cIj().sSP.sNl.sPp.nwu, C43727b.cIj().sSP.sNl.sPp.nwv, this.sRm ? 0 : 1, 4);
            this.sRV = true;
        }
        this.sRX = null;
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        AppMethodBeat.m2505o(4521);
    }

    public final void cJA() {
        AppMethodBeat.m2504i(4522);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onNoResp");
        m26126oE(4105);
        C14055q.m22208a(this.sRl.field_username, this.sRn ? C7620bi.xZc : C7620bi.xZb, this.sRm ? 1 : 0, 4, C4996ah.getContext().getString(C25738R.string.f4c));
        C7060h.pYm.mo8377a(11518, true, true, Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(C43727b.cIj().sSP.sNl.cIK()), Integer.valueOf(6), Integer.valueOf(C5023at.getNetWorkType(getContext())));
        cJz();
        AppMethodBeat.m2505o(4522);
    }

    public final void onConnected() {
        AppMethodBeat.m2504i(4523);
        m26126oE(4102);
        this.sRs = C5046bo.anT();
        if (this.sRe != null) {
            this.sRe.setConnectSec(this.sRs);
        }
        boolean cIM = C43727b.cIj().sSP.sNl.cIM();
        boolean cIL = C43727b.cIj().sSP.sNl.cIL();
        if (this.sRn && this.sRm && !cIL && !cIM) {
            C43727b.cIj().mo26337Gh(1);
        }
        if (!C40025b.m68549GO(this.sRc.mState)) {
            C7060h.pYm.mo8381e(11080, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
        }
        C5046bo.m7589z(C4996ah.getContext(), true);
        C14058r cIj = C43727b.cIj();
        int i = C43727b.cIj().sSP.sNl.sPp.sUk;
        C4286s c4286s = cIj.sSP;
        c4286s.bJj = null;
        c4286s.sTq = null;
        c4286s.sTo = 0;
        if (i > 0) {
            C4286s.sTm = i;
        }
        c4286s.bJj = (WifiManager) C4996ah.getContext().getApplicationContext().getSystemService("wifi");
        c4286s.sTp = new Timer();
        c4286s.sTp.schedule(new C42856(), 0, (long) (C4286s.sTm * 1000));
        TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(new C42875(telephonyManager), 256);
        }
        C35355p.cJR().cJS();
        C35355p.cJR().mo56094a(this);
        AppMethodBeat.m2505o(4523);
    }

    public final void cJB() {
        int i = 0;
        AppMethodBeat.m2504i(4524);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(C43727b.cIj().sSP.sNl.sPp.nwu);
        objArr[1] = Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv);
        objArr[2] = Long.valueOf(C43727b.cIj().sSP.sNl.cIK());
        objArr[3] = Integer.valueOf(this.sRm ? 0 : 1);
        objArr[4] = Integer.valueOf(1);
        c7060h.mo8377a(11522, true, true, objArr);
        int i2 = C43727b.cIj().sSP.sNl.sPp.nwu;
        long j = C43727b.cIj().sSP.sNl.sPp.nwv;
        if (!this.sRm) {
            i = 1;
        }
        C46317a.m86991c(i2, j, i, 3);
        this.sSe.post(new C168982());
        AppMethodBeat.m2505o(4524);
    }

    public final void cJC() {
        String string;
        int i = 0;
        AppMethodBeat.m2504i(4525);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (C40025b.m68548GN(this.sRc.mState)) {
            string = C4996ah.getContext().getString(C25738R.string.f47, new Object[]{VoipMgr.m26113fQ(C5046bo.m7549fp(this.sRs))});
        } else {
            string = C4996ah.getContext().getString(C25738R.string.f43);
        }
        if (this.sRm || C40025b.m68548GN(this.sRc.mState)) {
            C14055q.m22208a(this.sRl.field_username, this.sRn ? C7620bi.xZc : C7620bi.xZb, this.sRm ? 1 : 0, 6, string);
        }
        if (this.sRn) {
            C43727b.cIj().mo26341Gx(0);
        } else {
            C43727b.cIj().mo26341Gx(1);
        }
        this.sRj = C40025b.m68548GN(this.sRc.mState);
        if (cJJ()) {
            this.sRp = 4106;
        } else {
            m26126oE(4106);
            cJz();
        }
        C43727b.cIj().cKe();
        if (!this.sRV) {
            int i2 = C43727b.cIj().sSP.sNl.sPp.nwu;
            long j = C43727b.cIj().sSP.sNl.sPp.nwv;
            if (!this.sRm) {
                i = 1;
            }
            C46317a.m86991c(i2, j, i, 4);
            this.sRV = true;
        }
        AppMethodBeat.m2505o(4525);
    }

    /* renamed from: Gt */
    public final void mo30876Gt(int i) {
        AppMethodBeat.m2504i(4526);
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", Integer.valueOf(i));
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            m26126oE(4101);
            C43727b.cIj().sSP.sNl.cIP();
            C43727b.cIj().sSP.sNl.cIQ();
        }
        AppMethodBeat.m2505o(4526);
    }

    /* renamed from: b */
    public final void mo30881b(int i, int i2, int[] iArr) {
        AppMethodBeat.m2504i(4527);
        if (this.sRe != null) {
            this.sRe.mo26394c(i, i2, iArr);
        }
        AppMethodBeat.m2505o(4527);
    }

    public final void cJD() {
        AppMethodBeat.m2504i(4528);
        if (this.sRe != null) {
            this.sRe.cJD();
        }
        AppMethodBeat.m2505o(4528);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.m2504i(4529);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + i + "，mVoipUI: " + this.sRe);
        if (this.sRe != null) {
            this.sRe.setVoipBeauty(i);
        }
        if (!(i == 0 || this.sRO == i)) {
            C7060h.pYm.mo15419k(914, 20, 1);
        }
        this.sRO = i;
        AppMethodBeat.m2505o(4529);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.m2504i(4530);
        this.sRN = i;
        if (this.sRe != null) {
            this.sRe.setHWDecMode(i);
        }
        AppMethodBeat.m2505o(4530);
    }

    /* renamed from: Gu */
    public final void mo30877Gu(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(4531);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(i)));
        if (this.sRc.mo47747GQ(4110)) {
            C14058r cIj = C43727b.cIj();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            cIj.mo26343R(z2, z);
            C43727b.cIj().sSP.stopRing();
            if (i == 1 && C40025b.m68549GO(this.sRc.mState)) {
                m26126oE(4101);
            }
            m26126oE(4110);
            AppMethodBeat.m2505o(4531);
            return;
        }
        AppMethodBeat.m2505o(4531);
    }

    public final void cJE() {
        boolean z = false;
        AppMethodBeat.m2504i(4532);
        C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
            m26122mr(false);
        } else {
            boolean z2;
            if (1 == this.sRr) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!this.sRJ) {
                if (this.sRn) {
                    z = true;
                } else {
                    z = z2;
                }
            }
            m26122mr(z);
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C5004al.m7441d(new C42793());
            AppMethodBeat.m2505o(4532);
            return;
        }
        cJF();
        AppMethodBeat.m2505o(4532);
    }

    private void cJF() {
        AppMethodBeat.m2504i(4533);
        if (!(!C1443d.m3068iW(28) || !this.sRn || this.sRf == null || this.sRf.bPu() || this.sRe == null)) {
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", Integer.valueOf(VERSION.SDK_INT));
            this.sRf.cLD();
            this.sRe.cKT();
            int i = 320;
            int i2 = 240;
            if (this.sRf == null && C40025b.m68549GO(this.sRc.mState)) {
                this.sRg = new CaptureView(C4996ah.getContext());
                if (v2protocal.sTV) {
                    C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                    i = 640;
                    i2 = 480;
                }
            }
            this.sRf = new C46326a(i, i2);
            this.sRf.mo74532a((C14088g) this, true);
            this.sRf.mo74533a(this.sRg);
            this.sRf.cLC();
        }
        AppMethodBeat.m2505o(4533);
    }

    public final long cJG() {
        AppMethodBeat.m2504i(4534);
        C4990ab.m7409c("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", Long.valueOf(this.sRR));
        long j = this.sRR / 1000;
        AppMethodBeat.m2505o(4534);
        return j;
    }

    /* renamed from: fQ */
    private static String m26113fQ(long j) {
        AppMethodBeat.m2504i(4535);
        String format = String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
        AppMethodBeat.m2505o(4535);
        return format;
    }

    /* renamed from: a */
    public final void mo26415a(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(4536);
        if (this.sRw) {
            AppMethodBeat.m2505o(4536);
        } else if (this.sRf == null) {
            C4990ab.m7412e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
            AppMethodBeat.m2505o(4536);
        } else {
            int i5;
            int i6 = this.sRf.cLE() ? OpenGlRender.FLAG_Mirror : 0;
            if (this.sRf.cLF()) {
                i5 = OpenGlRender.FLAG_Angle270;
            } else {
                i5 = OpenGlRender.FLAG_Angle90;
            }
            if (this.sRe != null) {
                int i7 = i3 + i4;
                byte[] bArr2 = null;
                if (this.sRf.cLE()) {
                    if (OpenGlRender.getGLVersion() != 1 && this.sRe.cKU() != null && this.sRe.cKU().length == (i * i2) * 4) {
                        bArr2 = this.sRe.cKU();
                        i7 = 4;
                        this.sRX = bArr2;
                    } else if (OpenGlRender.getGLVersion() != 2 || this.sRX == null || this.sRO == 0) {
                        i7 = i3 + i4;
                        bArr2 = bArr;
                    } else {
                        bArr2 = this.sRX;
                        i7 = 4;
                    }
                }
                if (bArr2 == null) {
                    i7 = i3 + i4;
                    bArr2 = bArr;
                }
                this.sRe.mo26390a(bArr, j, i, i2, i3 + i4, i6, i5, C43727b.cIj().sSP.sNl.sPr.mo63259b(bArr2, bArr2.length, i7, i, i2));
            }
            this.sRD = i6 == OpenGlRender.FLAG_Mirror;
            this.sRE = i5 == OpenGlRender.FLAG_Angle270 ? 270 : 90;
            C43741k c43741k = this.sRz;
            c43741k.tbA = i2;
            c43741k.tbz = i;
            AppMethodBeat.m2505o(4536);
        }
    }

    private void cJH() {
        AppMethodBeat.m2504i(4537);
        synchronized (this.sRk) {
            try {
                C43727b.cIj().sSP.stopRing();
                cJI();
                C1407g.m2946KK().setMode(0);
                if (this.cqx != null) {
                    this.cqx.mo73178Mm();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(4537);
            }
        }
    }

    private void cJI() {
        AppMethodBeat.m2504i(4538);
        C4990ab.m7408b("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.sRf != null) {
            cJO();
            try {
                this.sRf.cLD();
            } catch (Exception e) {
                C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.sRf = null;
        }
        AppMethodBeat.m2505o(4538);
    }

    /* renamed from: ig */
    public final void mo30909ig(boolean z) {
        int i = 2;
        AppMethodBeat.m2504i(4539);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.sRe != null) {
            this.sRe.mo26400my(z);
        }
        if (!(C40025b.m68549GO(this.sRc.mState) || this.sRv)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.nxl > 30000) {
                this.nxl = currentTimeMillis;
                C43727b.cIj().sSP.cKp();
            }
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "report the bad net toast room key is " + C43727b.cIj().sSP.sNl.sPp.nwv + "and in the side" + (z ? 1 : 2));
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(C43727b.cIj().sSP.sNl.sPp.nwv);
        if (z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        c7060h.mo8377a(17151, true, true, objArr);
        AppMethodBeat.m2505o(4539);
    }

    public final void bGR() {
        AppMethodBeat.m2504i(4540);
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.sRe != null) {
            this.sRe.bIK();
        }
        AppMethodBeat.m2505o(4540);
    }

    private boolean cJJ() {
        AppMethodBeat.m2504i(4541);
        if (C40025b.m68548GN(this.sRc.mState)) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
            if (!sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
                boolean e = m26106e(sharedPreferences);
                AppMethodBeat.m2505o(4541);
                return e;
            }
        }
        AppMethodBeat.m2505o(4541);
        return false;
    }

    /* renamed from: e */
    private boolean m26106e(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(4542);
        String value = C26373g.m41964Nu().getValue("VOIPShortcutAutoadd");
        C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", value);
        if (value != null && value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && C5046bo.m7549fp(this.sRs) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i < 3 && !z) {
                cJK();
                sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
                AppMethodBeat.m2505o(4542);
                return true;
            }
        } else if (value != null && value.equals("1") && C5046bo.m7549fp(this.sRs) > 15) {
            m26110f(sharedPreferences);
            AppMethodBeat.m2505o(4542);
            return false;
        }
        AppMethodBeat.m2505o(4542);
        return false;
    }

    /* renamed from: f */
    private void m26110f(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(4543);
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == C5046bo.getInt(C26373g.m41964Nu().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(C25738R.string.f9132qh));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), C25738R.drawable.aa3));
            intent.putExtra("shortcut_icon_resource_id", C25738R.drawable.aa3);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(C25738R.string.f9134qj));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), C25738R.drawable.aa4));
            intent.putExtra("shortcut_icon_resource_id", C25738R.drawable.aa4);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        C42781b.m75869r(getContext(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
        AppMethodBeat.m2505o(4543);
    }

    /* Access modifiers changed, original: final */
    public final Context getContext() {
        AppMethodBeat.m2504i(4544);
        Context context = null;
        if (this.sRe != null) {
            context = this.sRe.cKS();
        }
        if (context == null) {
            context = C4996ah.getContext();
        }
        AppMethodBeat.m2505o(4544);
        return context;
    }

    private void cJK() {
        AppMethodBeat.m2504i(4545);
        Context context = getContext();
        View inflate = View.inflate(context, 2130970090, null);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(2131825970);
        checkBox.setChecked(false);
        TextView textView = (TextView) inflate.findViewById(2131825969);
        if (1 == C5046bo.getInt(C26373g.m41964Nu().getValue("VOIPCallType"), 0)) {
            textView.setText(C25738R.string.f3q);
        } else {
            textView.setText(C25738R.string.f3r);
        }
        C30379h.m48451a(context, false, context.getString(C25738R.string.f9238tz), inflate, context.getString(C25738R.string.f9262up), context.getString(C25738R.string.f9183s2), new C169085(), new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$6$1 */
            class C42801 implements Runnable {
                C42801() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(4464);
                    VoipMgr.m26129r(VoipMgr.this);
                    AppMethodBeat.m2505o(4464);
                }
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(4465);
                if (checkBox != null) {
                    VoipMgr.m26114g(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                }
                if (4096 != VoipMgr.this.sRp) {
                    VoipMgr.m26111f(VoipMgr.this, VoipMgr.this.sRp);
                    VoipMgr.this.sRp = 4096;
                }
                if (VoipMgr.this.iGP != null) {
                    VoipMgr.this.iGP.post(new C42801());
                }
                AppMethodBeat.m2505o(4465);
            }
        });
        AppMethodBeat.m2505o(4545);
    }

    /* renamed from: mv */
    public final boolean mo30913mv(final boolean z) {
        AppMethodBeat.m2504i(4546);
        if (!this.sRI || z) {
            C4990ab.m7408b("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", Boolean.valueOf(z));
            C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.sRe != null) {
                this.sRe.uninit();
                this.sRe = null;
            }
            if (this.iGP != null) {
                this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(4466);
                        VoipMgr.m26112f(VoipMgr.this, z);
                        AppMethodBeat.m2505o(4466);
                    }
                });
            }
            AppMethodBeat.m2505o(4546);
            return true;
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
        AppMethodBeat.m2505o(4546);
        return false;
    }

    public final void cJL() {
        AppMethodBeat.m2504i(4547);
        if (256 != this.sRc.mState && C31128d.MIC_PTU_ZIPAI_TOKYO != this.sRc.mState) {
            AppMethodBeat.m2505o(4547);
        } else if (C1720g.m3536RP().mo5239Ry().getInt(327945, 0) != 0 || this.sRe.cKS() == null) {
            C29488d.m46805fh(C4996ah.getContext());
            cJN();
            AppMethodBeat.m2505o(4547);
        } else {
            C1720g.m3536RP().mo5239Ry().setInt(327945, 1);
            C5653c a = C30379h.m48431a(this.sRe.cKS(), (int) C25738R.string.f5u, (int) C25738R.string.f9238tz, new C169018());
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
            AppMethodBeat.m2505o(4547);
        }
    }

    public final void cJM() {
        AppMethodBeat.m2504i(4548);
        this.sRC = !this.sRC;
        if (this.sRC) {
            this.sRA.stopTimer();
            AppMethodBeat.m2505o(4548);
            return;
        }
        if (this.sRA == null) {
            this.sRB = new C5004al("faceDetect");
            this.sRA = new C7564ap(this.sRB.oAl.getLooper(), new C1690210(), true);
        }
        this.sRA.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        this.sRC = false;
        AppMethodBeat.m2505o(4548);
    }

    public final void cJN() {
        AppMethodBeat.m2504i(4549);
        C43727b.cIj().sSV = C43727b.cIj().sSP.sNl.sPp.nwu;
        C14055q.m22208a(this.sRl.field_username, this.sRn ? C7620bi.xZc : C7620bi.xZb, this.sRm ? 1 : 0, 6, C4996ah.getContext().getString(C25738R.string.f49));
        C43727b.cIj().sSP.stopRing();
        m26126oE(4108);
        if (this.iGP != null) {
            this.iGP.postDelayed(new C168999(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(4549);
    }

    public final void bSo() {
        AppMethodBeat.m2504i(4550);
        if (true == this.oue || this.sRe == null || this.sRe.cKS() == null) {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
            AppMethodBeat.m2505o(4550);
        } else if (this.sRf.bPu()) {
            AppMethodBeat.m2505o(4550);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("meizu") && !C37657b.m63681Mj()) {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
            AppMethodBeat.m2505o(4550);
        } else if (C1443d.m3068iW(28) && ((KeyguardManager) C4996ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            C4990ab.m7417i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.m2505o(4550);
        } else {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.sRn ? 0 : 1);
            objArr[1] = Integer.valueOf(0);
            c7060h.mo8381e(11306, objArr);
            C5653c g = C30379h.m48467g(this.sRe.cKS(), C25738R.string.f6d, C25738R.string.f9238tz);
            if (g == null) {
                C4990ab.m7412e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                AppMethodBeat.m2505o(4550);
                return;
            }
            g.setCancelable(false);
            g.setCanceledOnTouchOutside(false);
            g.show();
            this.oue = true;
            AppMethodBeat.m2505o(4550);
        }
    }

    private void cJO() {
        AppMethodBeat.m2504i(4551);
        if (this.sRz != null) {
            this.sRz.mo69434a(this);
        }
        if (this.sRA != null) {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
            this.sRA.stopTimer();
        }
        if (!(this.sRB == null || this.sRB.oAl.getLooper() == null)) {
            C4990ab.m7410d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
            this.sRB.oAl.getLooper().quit();
        }
        AppMethodBeat.m2505o(4551);
    }

    /* renamed from: a */
    public final void mo30880a(final int[] iArr, final boolean z, final int i) {
        AppMethodBeat.m2504i(4552);
        if (!this.sRY && this.sRn) {
            m26123mt(true);
            this.sRY = true;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(4470);
                if (VoipMgr.this.sRf != null) {
                    VoipMgr.this.sRf.mo74542y(iArr);
                }
                if (VoipMgr.this.sRe != null) {
                    VoipMgr.this.sRe;
                }
                AppMethodBeat.m2505o(4470);
            }
        });
        AppMethodBeat.m2505o(4552);
    }

    /* renamed from: r */
    static /* synthetic */ void m26129r(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4557);
        voipMgr.mo30912mu(false);
        AppMethodBeat.m2505o(4557);
    }

    /* renamed from: H */
    static /* synthetic */ void m26086H(VoipMgr voipMgr) {
        AppMethodBeat.m2504i(4566);
        if (C40025b.m68548GN(voipMgr.sRc.mState)) {
            voipMgr.sRz.tby = voipMgr.sRD;
            voipMgr.sRz.mRotateAngle = voipMgr.sRE;
            C43741k c43741k = voipMgr.sRz;
            int[] iArr = new int[2];
            if (voipMgr.sRF) {
                iArr[0] = 1;
                iArr[1] = 0;
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.asIntBuffer().put(iArr);
            byte[] array = allocate.array();
            if (c43741k.sSz.setAppCmd(13, array, array.length) >= 0) {
                int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                allocate2.put(array);
                allocate2.order(ByteOrder.nativeOrder());
                allocate2.rewind();
                int[] iArr2 = new int[length];
                allocate2.asIntBuffer().get(iArr2);
                int i = iArr2[0];
                length = iArr2[1];
                if (i + length != 0) {
                    C43740b c43740b = new C43740b();
                    c43740b = new C43740b();
                    c43740b.tbB = i & CdnLogic.kBizGeneric;
                    c43740b.tbC = (i >> 16) & CdnLogic.kBizGeneric;
                    c43740b.tbD = length & CdnLogic.kBizGeneric;
                    c43740b.tbE = (length >> 16) & CdnLogic.kBizGeneric;
                    C4990ab.m7411d("MicroMsg.VoipFaceDetector", "detect face, location:%s", c43740b);
                    Iterator it = c43741k.jFO.iterator();
                    while (it.hasNext()) {
                        ((C22477a) it.next()).mo30880a(new int[]{c43740b.tbB, c43740b.tbC, c43740b.tbD, c43740b.tbE}, c43741k.tby, c43741k.mRotateAngle);
                    }
                    AppMethodBeat.m2505o(4566);
                    return;
                }
                Iterator it2 = c43741k.jFO.iterator();
                while (it2.hasNext()) {
                    ((C22477a) it2.next()).mo30880a(null, c43741k.tby, c43741k.mRotateAngle);
                }
            }
        }
        AppMethodBeat.m2505o(4566);
    }
}
