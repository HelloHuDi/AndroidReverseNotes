package com.tencent.p177mm.plugin.voip.p546ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p230g.p231a.C18299iq;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C42008in;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.C43728c;
import com.tencent.p177mm.plugin.voip.model.C14047k;
import com.tencent.p177mm.plugin.voip.model.VoipMgr;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip.p546ui.VoipBaseFragment.C40038d;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.p1045a.C29511d;
import com.tencent.p177mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;

@SuppressLint({"SimpleDateFormat"})
@C18524i
@C5271a(3)
/* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity */
public class VideoActivity extends MMActivity implements ServiceConnection, C40038d, C14085b {
    private String edV;
    private C7306ak iGP;
    private boolean mIsMute = false;
    private int mStatus;
    private boolean maH = false;
    private C4884c oCY = new C353639();
    private Point qLw;
    private CaptureView sRg;
    private C7616ad sRl;
    private boolean sRm;
    private boolean sRn;
    private int sRr = 1;
    private VoipBaseFragment sVX;
    private WeakReference<C46324c> sVY;
    private long sVZ = -1;
    private long sWa = 0;
    private boolean sWb = false;
    private int sWc = 1;
    private boolean sWd = false;
    private boolean sWe = false;
    private boolean sWf = false;
    private ScreenActionReceiver sWg;
    private byte[] sWh;
    private boolean sWi = false;
    private C4884c sWj = new C353591();
    private long sWk;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$5 */
    class C42975 implements OnClickListener {
        C42975() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4792);
            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(4792);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$6 */
    class C42986 implements Runnable {
        C42986() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4793);
            if (!(!C40025b.m68550GP(VideoActivity.this.mStatus) || VideoActivity.this.maH || VideoActivity.this.sVX == null)) {
                VideoActivity.this.sVX.mo56114fZ(C25738R.string.f4e, Downloads.MIN_WAIT_FOR_NETWORK);
            }
            AppMethodBeat.m2505o(4793);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$7 */
    class C42997 implements Runnable {
        C42997() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4794);
            VideoActivity.this.finish();
            AppMethodBeat.m2505o(4794);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$8 */
    class C140638 implements Runnable {
        C140638() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4795);
            VideoActivity.m78409e(VideoActivity.this);
            AppMethodBeat.m2505o(4795);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$13 */
    class C2950213 implements Runnable {
        C2950213() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4801);
            if (VideoActivity.this.sVX != null) {
                VideoActivity.this.sVX.mo56114fZ(C25738R.string.f6z, -1);
            }
            VideoActivity.m78409e(VideoActivity.this);
            AppMethodBeat.m2505o(4801);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$1 */
    class C353591 extends C4884c<C26171jl> {

        /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$1$1 */
        class C353601 implements Runnable {
            C353601() {
            }

            public final void run() {
                AppMethodBeat.m2504i(4786);
                if (!(VideoActivity.this.sVY == null || VideoActivity.this.sVY.get() == null)) {
                    boolean cJs = ((C46324c) VideoActivity.this.sVY.get()).cJs();
                    boolean cJr = ((C46324c) VideoActivity.this.sVY.get()).cJr();
                    boolean cJk = ((C46324c) VideoActivity.this.sVY.get()).cJk();
                    C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(cJs), Boolean.valueOf(cJr), Boolean.valueOf(cJk));
                }
                AppMethodBeat.m2505o(4786);
            }
        }

        C353591() {
            AppMethodBeat.m2504i(4787);
            this.xxI = C26171jl.class.getName().hashCode();
            AppMethodBeat.m2505o(4787);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(4788);
            if (((C26171jl) c4883b) instanceof C26171jl) {
                C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                C5004al.m7441d(new C353601());
            }
            AppMethodBeat.m2505o(4788);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$2 */
    class C353612 implements Runnable {
        C353612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4789);
            VideoActivity.m78409e(VideoActivity.this);
            AppMethodBeat.m2505o(4789);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$3 */
    class C353623 implements OnClickListener {
        C353623() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4790);
            dialogInterface.dismiss();
            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(4790);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$9 */
    class C353639 extends C4884c<C42008in> {
        C353639() {
            AppMethodBeat.m2504i(4796);
            this.xxI = C42008in.class.getName().hashCode();
            AppMethodBeat.m2505o(4796);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(4797);
            C42008in c42008in = (C42008in) c4883b;
            if (!(c42008in == null || c42008in.cDG == null)) {
                C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "summerhardcoder system event [%s]", Integer.valueOf(c42008in.cDG.keycode));
                if (c42008in.cDG.keycode == 1) {
                    VideoActivity.m78410f(VideoActivity.this);
                }
            }
            AppMethodBeat.m2505o(4797);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$ScreenActionReceiver */
    public class ScreenActionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(4802);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.SCREEN_OFF")) {
                C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "receive action screen off");
                VideoActivity.this.cKW();
            }
            AppMethodBeat.m2505o(4802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$10 */
    class C4373510 implements C29511d {
        C4373510() {
        }

        /* renamed from: bu */
        public final void mo26429bu(byte[] bArr) {
            AppMethodBeat.m2504i(4798);
            if (bArr != null) {
                VideoActivity.this.sWh = bArr;
            }
            AppMethodBeat.m2505o(4798);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VideoActivity$4 */
    class C437364 implements OnClickListener {
        C437364() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4791);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(4791);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VideoActivity() {
        AppMethodBeat.m2504i(4803);
        AppMethodBeat.m2505o(4803);
    }

    /* renamed from: e */
    static /* synthetic */ void m78409e(VideoActivity videoActivity) {
        AppMethodBeat.m2504i(4841);
        videoActivity.cJz();
        AppMethodBeat.m2505o(4841);
    }

    /* renamed from: f */
    static /* synthetic */ void m78410f(VideoActivity videoActivity) {
        AppMethodBeat.m2504i(4842);
        videoActivity.cKV();
        AppMethodBeat.m2505o(4842);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(4804);
        super.onCreate(bundle);
        try {
            mo17446xE(getResources().getColor(C25738R.color.a3p));
            if (!C29488d.m46801fd(this.mController.ylL)) {
                C29488d.m46802fe(this.mController.ylL);
            }
            C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
            getSupportActionBar().hide();
            getWindow().setSoftInputMode(3);
            getWindow().addFlags(6815872);
            if (C1720g.m3531RK()) {
                C43727b.cIj().mo26342Q(false, false);
            }
            C1407g.m2946KK().mo4817KM();
            this.iGP = new C7306ak();
            PBool pBool = new PBool();
            PBool pBool2 = new PBool();
            PString pString = new PString();
            PInt pInt = new PInt();
            pString.value = getIntent().getStringExtra("Voip_User");
            pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
            pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
            this.sWk = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
            pInt.value = C40025b.m68551T(pBool.value, pBool2.value);
            this.sWh = null;
            if (pBool.value) {
                try {
                    if (VideoActivity.bRR() && !isFinishing()) {
                        Toast.makeText(this, C25738R.string.f5v, 0).show();
                        C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                        super.finish();
                        AppMethodBeat.m2505o(4804);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.Voip.VideoActivity", "not ready now!");
                }
            }
            VoipMgr a = C43727b.cIj().mo26345a((Context) this, pString, pBool, pBool2, pInt);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
                AppMethodBeat.m2505o(4804);
                return;
            }
            this.sVY = new WeakReference(a);
            this.edV = pString.value;
            this.sRn = pBool2.value;
            this.sRm = pBool.value;
            this.mStatus = pInt.value;
            this.sRl = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.edV);
            if (!C43727b.cIj().sSP.cKq()) {
                cKW();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_username", this.sRl.field_username);
            bundle2.putBoolean("key_isoutcall", this.sRm);
            bundle2.putInt("key_status", C40025b.m68551T(this.sRm, this.sRn));
            if (C40025b.m68549GO(this.mStatus)) {
                this.sVX = new VoipVideoFragment();
            } else {
                this.sVX = new VoipVoiceFragment();
            }
            this.sVX.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().mo556b(2131828504, this.sVX).commit();
            setTitleVisibility(8);
            if (C40025b.m68550GP(this.mStatus) && this.sRm) {
                this.iGP.postDelayed(new C42986(), 20000);
            }
            this.sVX.setVoipUIListener((C46324c) this.sVY.get());
            this.sVX.mo63343a((C40038d) this);
            this.sVX.mo56104GC(this.sRr);
            this.sVX.setMute(this.mIsMute);
            if (C43727b.cIj().sSQ.sRK != null) {
                abY(C43727b.cIj().sSQ.sRK);
            }
            if (!(this.sVY == null || this.sVY.get() == null)) {
                ((C46324c) this.sVY.get()).mo30879a(this, 1);
            }
            C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", Boolean.valueOf(this.sRm), Boolean.valueOf(this.sRn), this.edV, Integer.valueOf(this.mStatus));
            boolean a2;
            if (C40025b.m68549GO(this.mStatus)) {
                C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")), C5046bo.dpG(), this);
                if (!C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")) {
                    ((C46324c) this.sVY.get()).cJo();
                }
                a2 = C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), C5046bo.dpG(), this);
            } else {
                a2 = C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), C5046bo.dpG(), this);
            }
            C4879a.xxA.mo10052c(this.sWj);
            C4879a.xxA.mo10052c(this.oCY);
            if (C1443d.m3068iW(26)) {
                this.sWg = new ScreenActionReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                C4996ah.getContext().registerReceiver(this.sWg, intentFilter);
            }
            if (C1443d.m3068iW(17)) {
                this.qLw = new Point();
                if (getWindow().getDecorView().getDisplay() != null) {
                    getWindow().getDecorView().getDisplay().getRealSize(this.qLw);
                }
            }
            AppMethodBeat.m2505o(4804);
        } catch (Exception e2) {
            C46317a.m86983GI(2);
            C4990ab.printErrStackTrace("MicroMsg.Voip.VideoActivity", e2, "", new Object[0]);
            AppMethodBeat.m2505o(4804);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(4805);
        super.onConfigurationChanged(configuration);
        if (this.qLw != null && C1443d.m3068iW(17)) {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getRealSize(point);
            if (!(point.equals(this.qLw) || this.sVX == null)) {
                this.qLw = point;
                this.sVX.cKZ();
            }
        }
        AppMethodBeat.m2505o(4805);
    }

    private static boolean bRR() {
        boolean z;
        Exception e;
        AppMethodBeat.m2504i(4806);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getCallState()) {
                    case 0:
                    case 1:
                        z = false;
                        break;
                    case 2:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                try {
                    C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", Integer.valueOf(r2));
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.m7413e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e.getLocalizedMessage());
                    AppMethodBeat.m2505o(4806);
                    return z;
                }
            }
            z = false;
        } catch (Exception e3) {
            e = e3;
            z = false;
            C4990ab.m7413e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e.getLocalizedMessage());
            AppMethodBeat.m2505o(4806);
            return z;
        }
        AppMethodBeat.m2505o(4806);
        return z;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void cJz() {
        AppMethodBeat.m2504i(4807);
        this.iGP.postDelayed(new C42997(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(4807);
    }

    /* renamed from: fY */
    public final void mo26399fY(int i, int i2) {
        AppMethodBeat.m2504i(4808);
        this.mStatus = i2;
        if (1 != this.sWc && i2 != 8 && i2 != C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM) {
            C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
            AppMethodBeat.m2505o(4808);
        } else if (this.sVX == null) {
            C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
            AppMethodBeat.m2505o(4808);
        } else {
            this.sVX.mo56113fY(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case C31128d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                case C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                    this.sRn = false;
                    if (this.sVX == null || !(this.sVX instanceof VoipVoiceFragment)) {
                        if (this.sVX != null) {
                            this.sVX.uninit();
                            getSupportFragmentManager().beginTransaction().mo554a(this.sVX).commit();
                            this.sVX = null;
                        }
                        C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.sRl.field_username);
                        bundle.putBoolean("key_isoutcall", this.sRm);
                        bundle.putInt("key_status", this.mStatus);
                        this.sVX = new VoipVoiceFragment();
                        this.sVX.setArguments(bundle);
                        this.sVX.setVoipUIListener((C46324c) this.sVY.get());
                        this.sVX.mo63347lI(this.sVZ);
                        this.sVX.mo63343a((C40038d) this);
                        this.sVX.mo56104GC(this.sRr);
                        this.sVX.setMute(this.mIsMute);
                        this.sVX.mo56105a(this.sRg);
                        getSupportFragmentManager().beginTransaction().mo556b(2131828504, this.sVX).commit();
                    }
                    AppMethodBeat.m2505o(4808);
                    return;
                case 8:
                case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                    switch (i) {
                        case 4098:
                            this.iGP.postDelayed(new C140638(), 50);
                            break;
                        case 4099:
                            if (this.sRm) {
                                this.sVX.mo56114fZ(this.sRn ? C25738R.string.f7a : C25738R.string.f3t, -1);
                            }
                            cJz();
                            break;
                        case 4103:
                        case 4104:
                            cJz();
                            break;
                        case 4106:
                            this.iGP.post(new C2950213());
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.iGP.post(new C353612());
                            break;
                    }
                    cJz();
                    break;
            }
            AppMethodBeat.m2505o(4808);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(4809);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.m2505o(4809);
            return true;
        } else if (i == 25) {
            if (C43727b.cIj().sSP.cKq() || this.sRm) {
                C1407g.m2946KK().mo4839iK(C1407g.m2946KK().mo4819KP() ? C1407g.m2946KK().mo4827Lc() : bHJ());
            } else {
                C43727b.cIj().sSP.stopRing();
            }
            AppMethodBeat.m2505o(4809);
            return true;
        } else if (i == 24) {
            if (C43727b.cIj().sSP.cKq() || this.sRm) {
                C1407g.m2946KK().mo4838iJ(C1407g.m2946KK().mo4819KP() ? C1407g.m2946KK().mo4827Lc() : bHJ());
            } else {
                C43727b.cIj().sSP.stopRing();
            }
            AppMethodBeat.m2505o(4809);
            return true;
        } else if (C1427q.etc.eqV == 1 && i == 700) {
            cKV();
            AppMethodBeat.m2505o(4809);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(4809);
            return onKeyDown;
        }
    }

    private void cKV() {
        AppMethodBeat.m2504i(4810);
        if (!(this.sVY == null || this.sVY.get() == null || this.sRm)) {
            if (this.sRn) {
                ((C46324c) this.sVY.get()).cJn();
            } else {
                ((C46324c) this.sVY.get()).cJq();
            }
            if (C43727b.cIj().con && this.sRn) {
                ((C46324c) this.sVY.get()).cJv();
            }
        }
        AppMethodBeat.m2505o(4810);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(4811);
        this.sWc = 4;
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", C40025b.m68545GK(this.mStatus));
        if (!this.sWe) {
            finish();
        }
        if (!(this.sVY == null || this.sVY.get() == null)) {
            ((C46324c) this.sVY.get()).mo30878a(this);
        }
        C4879a.xxA.mo10053d(this.sWj);
        C4879a.xxA.mo10053d(this.oCY);
        setScreenEnable(true);
        cKX();
        if (C1443d.m3068iW(26) && this.sWg != null) {
            try {
                C4996ah.getContext().unregisterReceiver(this.sWg);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "unregisterBatteryChange err:%s", e.getMessage());
            }
            this.sWg = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(4811);
    }

    public void onStop() {
        AppMethodBeat.m2504i(4812);
        this.sWc = 2;
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", C40025b.m68545GK(this.mStatus));
        super.onStop();
        if (!(C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM == this.mStatus || 8 == this.mStatus || !this.sWd || this.sWe || this.sVY == null || this.sVY.get() == null || !((C46324c) this.sVY.get()).mo30913mv(false))) {
            mo63352S(false, true);
            if (C40025b.m68548GN(this.mStatus)) {
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(C40025b.m68549GO(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                c7060h.mo8381e(11618, objArr);
            }
        }
        AppMethodBeat.m2505o(4812);
    }

    public void onStart() {
        AppMethodBeat.m2504i(4813);
        super.onStart();
        if (!this.sWe) {
            C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "onStart");
            this.sWc = 1;
            mo26399fY(4096, this.mStatus);
        }
        AppMethodBeat.m2505o(4813);
    }

    public void finish() {
        int i;
        AppMethodBeat.m2504i(4814);
        this.sWc = 3;
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", Boolean.valueOf(this.sWb), C40025b.m68545GK(this.mStatus));
        if (!(this.sWb || !C40025b.m68548GN(this.mStatus) || 4 == this.sWc)) {
            C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.edV);
            C43728c.gkE.mo38915d(intent, (Context) this);
        }
        if (this.sWi) {
            this.sWi = false;
            C46317a.m86991c(C43727b.cIj().cJZ(), C43727b.cIj().cKa(), this.sRm ? 0 : 1, 5);
            C46317a.m86983GI(1);
        }
        if (this.sVX != null) {
            if (this.sVX.sWs == 4105) {
                i = 1;
            } else {
                i = 0;
            }
            this.sVX.uninit();
            this.sVX = null;
        } else {
            i = 0;
        }
        this.sVY = null;
        this.sRg = null;
        this.sWe = true;
        super.finish();
        C18299iq c18299iq;
        if (i != 0) {
            c18299iq = new C18299iq();
            c18299iq.cDO.cDR = true;
            c18299iq.cDO.cDQ = this.sWk;
            C4879a.xxA.mo10055m(c18299iq);
        } else {
            c18299iq = new C18299iq();
            c18299iq.cDO.cDR = false;
            c18299iq.cDO.cDQ = 0;
            C4879a.xxA.mo10055m(c18299iq);
        }
        VoipBaseFragment.sWt = -1;
        cKX();
        AppMethodBeat.m2505o(4814);
    }

    public final void cKW() {
        AppMethodBeat.m2504i(4815);
        C4990ab.m7409c("MicroMsg.Voip.VideoActivity", "bindVoipForegroundIfNeed and isBindVoipForegroundService" + this.sWf, new Object[0]);
        try {
            if (C1443d.m3068iW(26) && !this.sWf) {
                Intent intent = new Intent();
                intent.putExtra("Voip_User", this.sRl.field_username);
                intent.putExtra("Voip_VideoCall", this.sRn);
                intent.setClass(C4996ah.getContext(), VoipForegroundService.class);
                C4996ah.getContext().startForegroundService(intent);
                this.sWf = true;
            }
            AppMethodBeat.m2505o(4815);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VideoActivity", e, "bindVoipForegroundIfNeed error: %s", e.getMessage());
            AppMethodBeat.m2505o(4815);
        }
    }

    private void cKX() {
        AppMethodBeat.m2504i(4816);
        C4990ab.m7409c("MicroMsg.Voip.VideoActivity", "unbindVoiceServiceIfNeed and isBindVoipForegroundService" + this.sWf, new Object[0]);
        try {
            if (C1443d.m3068iW(26) && this.sWf) {
                Intent intent = new Intent();
                intent.setClass(C4996ah.getContext(), VoipForegroundService.class);
                C4996ah.getContext().stopService(intent);
                this.sWf = false;
            }
            AppMethodBeat.m2505o(4816);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VideoActivity", e, "unBind vidoeforeground error: %s", e.getMessage());
            AppMethodBeat.m2505o(4816);
        }
    }

    public final void setScreenEnable(boolean z) {
        AppMethodBeat.m2504i(4817);
        super.setScreenEnable(z);
        if (this.sVY != null) {
            this.sVY.get();
        }
        if (!(z || this.sWf)) {
            cKW();
        }
        AppMethodBeat.m2505o(4817);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(4818);
        C4990ab.m7416i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(4818);
    }

    public void onPause() {
        AppMethodBeat.m2504i(4819);
        super.onPause();
        PowerManager powerManager = (PowerManager) C4996ah.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) C4996ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.sWd = z;
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", C40025b.m68545GK(this.mStatus), Boolean.valueOf(this.sWd), Boolean.valueOf(r5), Boolean.valueOf(r4), Boolean.valueOf(r1));
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(4819);
    }

    public void onResume() {
        AppMethodBeat.m2504i(4820);
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", C40025b.m68545GK(this.mStatus));
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        C14047k c14047k = C43727b.cIj().sSP.sNl;
        if (c14047k.sPb) {
            c14047k.sPb = false;
        }
        super.onResume();
        setScreenEnable(true);
        this.sWa = C5046bo.m7588yz();
        if (this.sRm && C40025b.m68550GP(this.mStatus) && C43727b.cIj().sSP.cKq()) {
            C43727b.cIj().mo26347an(this.sRn ? 0 : 1, this.sRm);
        }
        C29970o.m47417JV(1);
        this.sWi = true;
        if (!(this.sVY == null || this.sVY.get() == null)) {
            ((C46324c) this.sVY.get()).cJt();
        }
        AppMethodBeat.m2505o(4820);
    }

    /* renamed from: a */
    public final void mo26390a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(4821);
        if (this.sVX != null) {
            this.sVX.mo56106a(bArr, j, i, i2, i3, i4, i5, i6);
        }
        AppMethodBeat.m2505o(4821);
    }

    public final byte[] cKU() {
        AppMethodBeat.m2504i(4822);
        if (!(this.sVX == null || this.sVX.getFilterData() == null)) {
            this.sVX.getFilterData().mo63359a(new C4373510());
        }
        byte[] bArr = this.sWh;
        AppMethodBeat.m2505o(4822);
        return bArr;
    }

    /* renamed from: br */
    public final void mo26393br(final int i, String str) {
        AppMethodBeat.m2504i(4823);
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", Integer.valueOf(i), Boolean.valueOf(this.sRn));
        this.maH = true;
        if (i == C31128d.MIC_PTU_QINGCONG) {
            C30379h.m48461b((Context) this, str, null, true);
            AppMethodBeat.m2505o(4823);
            return;
        }
        this.iGP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(4799);
                VideoActivity.m78404a(VideoActivity.this, i);
                AppMethodBeat.m2505o(4799);
            }
        });
        AppMethodBeat.m2505o(4823);
    }

    public final void abY(final String str) {
        AppMethodBeat.m2504i(4824);
        if (this.sVX != null) {
            this.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(4800);
                    if (VideoActivity.this.sVX != null) {
                        VideoActivity.this.sVX.abY(str);
                    }
                    AppMethodBeat.m2505o(4800);
                }
            });
        }
        AppMethodBeat.m2505o(4824);
    }

    public final int getLayoutId() {
        return 2130971030;
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(4825);
        C5222ae.m7946h(C5222ae.m7934a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
        AppMethodBeat.m2505o(4825);
    }

    private int bHJ() {
        AppMethodBeat.m2504i(4826);
        int Lc;
        if (C1407g.m2946KK().mo4819KP()) {
            Lc = C1407g.m2946KK().mo4827Lc();
            AppMethodBeat.m2505o(4826);
            return Lc;
        }
        if (C40025b.m68548GN(this.mStatus)) {
            Lc = C43727b.cIj().cIt();
        } else {
            Lc = 2;
            if (this.sRm) {
                if (this.sRn) {
                    Lc = 3;
                    if (C1407g.m2946KK().mo4822KV()) {
                        if (C1427q.etd.eqm >= 0) {
                            Lc = C1427q.etd.eqm;
                        }
                        Lc = 0;
                    } else if (C1427q.etd.eqj >= 0) {
                        Lc = C1427q.etd.eqj;
                    }
                } else {
                    if (C1427q.etd.eqm >= 0) {
                        Lc = C1427q.etd.eqm;
                    }
                    Lc = 0;
                }
            } else if (C1407g.m2946KK().mo4822KV()) {
                if (C1427q.etd.eqm >= 0) {
                    Lc = C1427q.etd.eqm;
                }
                Lc = 0;
            }
            if (!C1407g.m2946KK().mo4819KP() && C1427q.etd.eqo >= 0) {
                Lc = C1427q.etd.eqo;
            }
        }
        C4990ab.m7411d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", Integer.valueOf(Lc));
        AppMethodBeat.m2505o(4826);
        return Lc;
    }

    /* renamed from: GC */
    public final void mo26389GC(int i) {
        AppMethodBeat.m2504i(4827);
        this.sRr = i;
        if (this.sVX != null) {
            this.sVX.mo56104GC(i);
        }
        AppMethodBeat.m2505o(4827);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(4828);
        this.mIsMute = z;
        if (this.sVX != null) {
            this.sVX.setMute(z);
        }
        AppMethodBeat.m2505o(4828);
    }

    /* renamed from: c */
    public final void mo26394c(int i, int i2, int[] iArr) {
        AppMethodBeat.m2504i(4829);
        if (this.sVX != null) {
            this.sVX.mo56108c(i, i2, iArr);
        }
        AppMethodBeat.m2505o(4829);
    }

    public final void cJD() {
        AppMethodBeat.m2504i(4830);
        if (this.sVX != null) {
            this.sVX.cJD();
        }
        AppMethodBeat.m2505o(4830);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.m2504i(4831);
        if (this.sVX != null) {
            this.sVX.setVoipBeauty(i);
        }
        AppMethodBeat.m2505o(4831);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.m2504i(4832);
        if (this.sVX != null) {
            this.sVX.setHWDecMode(i);
        }
        AppMethodBeat.m2505o(4832);
    }

    public final void uninit() {
        AppMethodBeat.m2504i(4833);
        if (this.sVX != null) {
            this.sVX.uninit();
        }
        AppMethodBeat.m2505o(4833);
    }

    public final void setConnectSec(long j) {
        AppMethodBeat.m2504i(4834);
        this.sVZ = j;
        if (this.sVX != null) {
            this.sVX.mo63347lI(this.sVZ);
        }
        AppMethodBeat.m2505o(4834);
    }

    /* renamed from: my */
    public final void mo26400my(boolean z) {
        AppMethodBeat.m2504i(4835);
        C4990ab.m7410d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(z)));
        if (this.sVX != null) {
            this.sVX.mo56116mz(z);
        }
        AppMethodBeat.m2505o(4835);
    }

    public final void bIK() {
        AppMethodBeat.m2504i(4836);
        C4990ab.m7410d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.sVX != null) {
            this.sVX.cKY();
        }
        AppMethodBeat.m2505o(4836);
    }

    /* renamed from: S */
    public final void mo63352S(boolean z, boolean z2) {
        AppMethodBeat.m2504i(4837);
        this.sWb = z2;
        if (z) {
            cJz();
            AppMethodBeat.m2505o(4837);
            return;
        }
        cKX();
        finish();
        AppMethodBeat.m2505o(4837);
    }

    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.m2504i(4838);
        this.sRg = captureView;
        if (this.sVX != null) {
            this.sVX.mo56105a(captureView);
        }
        AppMethodBeat.m2505o(4838);
    }

    public final void cKT() {
        AppMethodBeat.m2504i(4839);
        if (this.sVX instanceof VoipVideoFragment) {
            ((VoipVideoFragment) this.sVX).cKT();
        }
        AppMethodBeat.m2505o(4839);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(4840);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(4840);
            return;
        }
        C4990ab.m7417i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C353623(), new C437364());
                    AppMethodBeat.m2505o(4840);
                    return;
                }
                break;
            case 82:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C42975(), null);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(4840);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public final Context cKS() {
        return this.mController.ylL;
    }
}
