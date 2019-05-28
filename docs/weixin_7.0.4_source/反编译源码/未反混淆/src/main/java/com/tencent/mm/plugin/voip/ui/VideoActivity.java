package com.tencent.mm.plugin.voip.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.VoipMgr;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.ui.VoipBaseFragment.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;

@SuppressLint({"SimpleDateFormat"})
@i
@a(3)
public class VideoActivity extends MMActivity implements ServiceConnection, d, b {
    private String edV;
    private ak iGP;
    private boolean mIsMute = false;
    private int mStatus;
    private boolean maH = false;
    private c oCY = new c<in>() {
        {
            AppMethodBeat.i(4796);
            this.xxI = in.class.getName().hashCode();
            AppMethodBeat.o(4796);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(4797);
            in inVar = (in) bVar;
            if (!(inVar == null || inVar.cDG == null)) {
                ab.i("MicroMsg.Voip.VideoActivity", "summerhardcoder system event [%s]", Integer.valueOf(inVar.cDG.keycode));
                if (inVar.cDG.keycode == 1) {
                    VideoActivity.f(VideoActivity.this);
                }
            }
            AppMethodBeat.o(4797);
            return false;
        }
    };
    private Point qLw;
    private CaptureView sRg;
    private ad sRl;
    private boolean sRm;
    private boolean sRn;
    private int sRr = 1;
    private VoipBaseFragment sVX;
    private WeakReference<c> sVY;
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
    private c sWj = new c<jl>() {
        {
            AppMethodBeat.i(4787);
            this.xxI = jl.class.getName().hashCode();
            AppMethodBeat.o(4787);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(4788);
            if (((jl) bVar) instanceof jl) {
                ab.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4786);
                        if (!(VideoActivity.this.sVY == null || VideoActivity.this.sVY.get() == null)) {
                            boolean cJs = ((c) VideoActivity.this.sVY.get()).cJs();
                            boolean cJr = ((c) VideoActivity.this.sVY.get()).cJr();
                            boolean cJk = ((c) VideoActivity.this.sVY.get()).cJk();
                            ab.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(cJs), Boolean.valueOf(cJr), Boolean.valueOf(cJk));
                        }
                        AppMethodBeat.o(4786);
                    }
                });
            }
            AppMethodBeat.o(4788);
            return false;
        }
    };
    private long sWk;

    public class ScreenActionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(4802);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.SCREEN_OFF")) {
                ab.i("MicroMsg.Voip.VideoActivity", "receive action screen off");
                VideoActivity.this.cKW();
            }
            AppMethodBeat.o(4802);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoActivity() {
        AppMethodBeat.i(4803);
        AppMethodBeat.o(4803);
    }

    static /* synthetic */ void e(VideoActivity videoActivity) {
        AppMethodBeat.i(4841);
        videoActivity.cJz();
        AppMethodBeat.o(4841);
    }

    static /* synthetic */ void f(VideoActivity videoActivity) {
        AppMethodBeat.i(4842);
        videoActivity.cKV();
        AppMethodBeat.o(4842);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(4804);
        super.onCreate(bundle);
        try {
            xE(getResources().getColor(R.color.a3p));
            if (!com.tencent.mm.plugin.voip.a.d.fd(this.mController.ylL)) {
                com.tencent.mm.plugin.voip.a.d.fe(this.mController.ylL);
            }
            ab.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
            getSupportActionBar().hide();
            getWindow().setSoftInputMode(3);
            getWindow().addFlags(6815872);
            if (g.RK()) {
                com.tencent.mm.plugin.voip.b.cIj().Q(false, false);
            }
            com.tencent.mm.compatible.b.g.KK().KM();
            this.iGP = new ak();
            PBool pBool = new PBool();
            PBool pBool2 = new PBool();
            PString pString = new PString();
            PInt pInt = new PInt();
            pString.value = getIntent().getStringExtra("Voip_User");
            pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
            pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
            this.sWk = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
            pInt.value = com.tencent.mm.plugin.voip.a.b.T(pBool.value, pBool2.value);
            this.sWh = null;
            if (pBool.value) {
                try {
                    if (bRR() && !isFinishing()) {
                        Toast.makeText(this, R.string.f5v, 0).show();
                        ab.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                        super.finish();
                        AppMethodBeat.o(4804);
                        return;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.Voip.VideoActivity", "not ready now!");
                }
            }
            VoipMgr a = com.tencent.mm.plugin.voip.b.cIj().a((Context) this, pString, pBool, pBool2, pInt);
            if (a == null) {
                ab.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
                AppMethodBeat.o(4804);
                return;
            }
            this.sVY = new WeakReference(a);
            this.edV = pString.value;
            this.sRn = pBool2.value;
            this.sRm = pBool.value;
            this.mStatus = pInt.value;
            this.sRl = ((j) g.K(j.class)).XM().aoO(this.edV);
            if (!com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
                cKW();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_username", this.sRl.field_username);
            bundle2.putBoolean("key_isoutcall", this.sRm);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.a.b.T(this.sRm, this.sRn));
            if (com.tencent.mm.plugin.voip.a.b.GO(this.mStatus)) {
                this.sVX = new VoipVideoFragment();
            } else {
                this.sVX = new VoipVoiceFragment();
            }
            this.sVX.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().b(R.id.f36, this.sVX).commit();
            setTitleVisibility(8);
            if (com.tencent.mm.plugin.voip.a.b.GP(this.mStatus) && this.sRm) {
                this.iGP.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4793);
                        if (!(!com.tencent.mm.plugin.voip.a.b.GP(VideoActivity.this.mStatus) || VideoActivity.this.maH || VideoActivity.this.sVX == null)) {
                            VideoActivity.this.sVX.fZ(R.string.f4e, Downloads.MIN_WAIT_FOR_NETWORK);
                        }
                        AppMethodBeat.o(4793);
                    }
                }, 20000);
            }
            this.sVX.setVoipUIListener((c) this.sVY.get());
            this.sVX.a((d) this);
            this.sVX.GC(this.sRr);
            this.sVX.setMute(this.mIsMute);
            if (com.tencent.mm.plugin.voip.b.cIj().sSQ.sRK != null) {
                abY(com.tencent.mm.plugin.voip.b.cIj().sSQ.sRK);
            }
            if (!(this.sVY == null || this.sVY.get() == null)) {
                ((c) this.sVY.get()).a(this, 1);
            }
            ab.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", Boolean.valueOf(this.sRm), Boolean.valueOf(this.sRn), this.edV, Integer.valueOf(this.mStatus));
            boolean a2;
            if (com.tencent.mm.plugin.voip.a.b.GO(this.mStatus)) {
                ab.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")), bo.dpG(), this);
                if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
                    ((c) this.sVY.get()).cJo();
                }
                a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                ab.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), bo.dpG(), this);
            } else {
                a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                ab.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), bo.dpG(), this);
            }
            com.tencent.mm.sdk.b.a.xxA.c(this.sWj);
            com.tencent.mm.sdk.b.a.xxA.c(this.oCY);
            if (com.tencent.mm.compatible.util.d.iW(26)) {
                this.sWg = new ScreenActionReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                ah.getContext().registerReceiver(this.sWg, intentFilter);
            }
            if (com.tencent.mm.compatible.util.d.iW(17)) {
                this.qLw = new Point();
                if (getWindow().getDecorView().getDisplay() != null) {
                    getWindow().getDecorView().getDisplay().getRealSize(this.qLw);
                }
            }
            AppMethodBeat.o(4804);
        } catch (Exception e2) {
            com.tencent.mm.plugin.voip.a.a.GI(2);
            ab.printErrStackTrace("MicroMsg.Voip.VideoActivity", e2, "", new Object[0]);
            AppMethodBeat.o(4804);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(4805);
        super.onConfigurationChanged(configuration);
        if (this.qLw != null && com.tencent.mm.compatible.util.d.iW(17)) {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getRealSize(point);
            if (!(point.equals(this.qLw) || this.sVX == null)) {
                this.qLw = point;
                this.sVX.cKZ();
            }
        }
        AppMethodBeat.o(4805);
    }

    private static boolean bRR() {
        boolean z;
        Exception e;
        AppMethodBeat.i(4806);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
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
                    ab.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", Integer.valueOf(r2));
                } catch (Exception e2) {
                    e = e2;
                    ab.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e.getLocalizedMessage());
                    AppMethodBeat.o(4806);
                    return z;
                }
            }
            z = false;
        } catch (Exception e3) {
            e = e3;
            z = false;
            ab.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e.getLocalizedMessage());
            AppMethodBeat.o(4806);
            return z;
        }
        AppMethodBeat.o(4806);
        return z;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void cJz() {
        AppMethodBeat.i(4807);
        this.iGP.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4794);
                VideoActivity.this.finish();
                AppMethodBeat.o(4794);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(4807);
    }

    public final void fY(int i, int i2) {
        AppMethodBeat.i(4808);
        this.mStatus = i2;
        if (1 != this.sWc && i2 != 8 && i2 != com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM) {
            ab.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
            AppMethodBeat.o(4808);
        } else if (this.sVX == null) {
            ab.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
            AppMethodBeat.o(4808);
        } else {
            this.sVX.fY(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                    this.sRn = false;
                    if (this.sVX == null || !(this.sVX instanceof VoipVoiceFragment)) {
                        if (this.sVX != null) {
                            this.sVX.uninit();
                            getSupportFragmentManager().beginTransaction().a(this.sVX).commit();
                            this.sVX = null;
                        }
                        ab.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.sRl.field_username);
                        bundle.putBoolean("key_isoutcall", this.sRm);
                        bundle.putInt("key_status", this.mStatus);
                        this.sVX = new VoipVoiceFragment();
                        this.sVX.setArguments(bundle);
                        this.sVX.setVoipUIListener((c) this.sVY.get());
                        this.sVX.lI(this.sVZ);
                        this.sVX.a((d) this);
                        this.sVX.GC(this.sRr);
                        this.sVX.setMute(this.mIsMute);
                        this.sVX.a(this.sRg);
                        getSupportFragmentManager().beginTransaction().b(R.id.f36, this.sVX).commit();
                    }
                    AppMethodBeat.o(4808);
                    return;
                case 8:
                case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                    switch (i) {
                        case 4098:
                            this.iGP.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(4795);
                                    VideoActivity.e(VideoActivity.this);
                                    AppMethodBeat.o(4795);
                                }
                            }, 50);
                            break;
                        case 4099:
                            if (this.sRm) {
                                this.sVX.fZ(this.sRn ? R.string.f7a : R.string.f3t, -1);
                            }
                            cJz();
                            break;
                        case 4103:
                        case 4104:
                            cJz();
                            break;
                        case 4106:
                            this.iGP.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(4801);
                                    if (VideoActivity.this.sVX != null) {
                                        VideoActivity.this.sVX.fZ(R.string.f6z, -1);
                                    }
                                    VideoActivity.e(VideoActivity.this);
                                    AppMethodBeat.o(4801);
                                }
                            });
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.iGP.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(4789);
                                    VideoActivity.e(VideoActivity.this);
                                    AppMethodBeat.o(4789);
                                }
                            });
                            break;
                    }
                    cJz();
                    break;
            }
            AppMethodBeat.o(4808);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(4809);
        if (keyEvent.getKeyCode() == 4) {
            AppMethodBeat.o(4809);
            return true;
        } else if (i == 25) {
            if (com.tencent.mm.plugin.voip.b.cIj().sSP.cKq() || this.sRm) {
                com.tencent.mm.compatible.b.g.KK().iK(com.tencent.mm.compatible.b.g.KK().KP() ? com.tencent.mm.compatible.b.g.KK().Lc() : bHJ());
            } else {
                com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            }
            AppMethodBeat.o(4809);
            return true;
        } else if (i == 24) {
            if (com.tencent.mm.plugin.voip.b.cIj().sSP.cKq() || this.sRm) {
                com.tencent.mm.compatible.b.g.KK().iJ(com.tencent.mm.compatible.b.g.KK().KP() ? com.tencent.mm.compatible.b.g.KK().Lc() : bHJ());
            } else {
                com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            }
            AppMethodBeat.o(4809);
            return true;
        } else if (q.etc.eqV == 1 && i == 700) {
            cKV();
            AppMethodBeat.o(4809);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(4809);
            return onKeyDown;
        }
    }

    private void cKV() {
        AppMethodBeat.i(4810);
        if (!(this.sVY == null || this.sVY.get() == null || this.sRm)) {
            if (this.sRn) {
                ((c) this.sVY.get()).cJn();
            } else {
                ((c) this.sVY.get()).cJq();
            }
            if (com.tencent.mm.plugin.voip.b.cIj().con && this.sRn) {
                ((c) this.sVY.get()).cJv();
            }
        }
        AppMethodBeat.o(4810);
    }

    public void onDestroy() {
        AppMethodBeat.i(4811);
        this.sWc = 4;
        ab.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", com.tencent.mm.plugin.voip.a.b.GK(this.mStatus));
        if (!this.sWe) {
            finish();
        }
        if (!(this.sVY == null || this.sVY.get() == null)) {
            ((c) this.sVY.get()).a(this);
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.sWj);
        com.tencent.mm.sdk.b.a.xxA.d(this.oCY);
        setScreenEnable(true);
        cKX();
        if (com.tencent.mm.compatible.util.d.iW(26) && this.sWg != null) {
            try {
                ah.getContext().unregisterReceiver(this.sWg);
            } catch (Exception e) {
                ab.i("MicroMsg.Voip.VideoActivity", "unregisterBatteryChange err:%s", e.getMessage());
            }
            this.sWg = null;
        }
        super.onDestroy();
        AppMethodBeat.o(4811);
    }

    public void onStop() {
        AppMethodBeat.i(4812);
        this.sWc = 2;
        ab.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", com.tencent.mm.plugin.voip.a.b.GK(this.mStatus));
        super.onStop();
        if (!(com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM == this.mStatus || 8 == this.mStatus || !this.sWd || this.sWe || this.sVY == null || this.sVY.get() == null || !((c) this.sVY.get()).mv(false))) {
            S(false, true);
            if (com.tencent.mm.plugin.voip.a.b.GN(this.mStatus)) {
                h hVar = h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.a.b.GO(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                hVar.e(11618, objArr);
            }
        }
        AppMethodBeat.o(4812);
    }

    public void onStart() {
        AppMethodBeat.i(4813);
        super.onStart();
        if (!this.sWe) {
            ab.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.sWc = 1;
            fY(4096, this.mStatus);
        }
        AppMethodBeat.o(4813);
    }

    public void finish() {
        int i;
        AppMethodBeat.i(4814);
        this.sWc = 3;
        ab.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", Boolean.valueOf(this.sWb), com.tencent.mm.plugin.voip.a.b.GK(this.mStatus));
        if (!(this.sWb || !com.tencent.mm.plugin.voip.a.b.GN(this.mStatus) || 4 == this.sWc)) {
            ab.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.edV);
            com.tencent.mm.plugin.voip.c.gkE.d(intent, (Context) this);
        }
        if (this.sWi) {
            this.sWi = false;
            com.tencent.mm.plugin.voip.a.a.c(com.tencent.mm.plugin.voip.b.cIj().cJZ(), com.tencent.mm.plugin.voip.b.cIj().cKa(), this.sRm ? 0 : 1, 5);
            com.tencent.mm.plugin.voip.a.a.GI(1);
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
        iq iqVar;
        if (i != 0) {
            iqVar = new iq();
            iqVar.cDO.cDR = true;
            iqVar.cDO.cDQ = this.sWk;
            com.tencent.mm.sdk.b.a.xxA.m(iqVar);
        } else {
            iqVar = new iq();
            iqVar.cDO.cDR = false;
            iqVar.cDO.cDQ = 0;
            com.tencent.mm.sdk.b.a.xxA.m(iqVar);
        }
        VoipBaseFragment.sWt = -1;
        cKX();
        AppMethodBeat.o(4814);
    }

    public final void cKW() {
        AppMethodBeat.i(4815);
        ab.c("MicroMsg.Voip.VideoActivity", "bindVoipForegroundIfNeed and isBindVoipForegroundService" + this.sWf, new Object[0]);
        try {
            if (com.tencent.mm.compatible.util.d.iW(26) && !this.sWf) {
                Intent intent = new Intent();
                intent.putExtra("Voip_User", this.sRl.field_username);
                intent.putExtra("Voip_VideoCall", this.sRn);
                intent.setClass(ah.getContext(), VoipForegroundService.class);
                ah.getContext().startForegroundService(intent);
                this.sWf = true;
            }
            AppMethodBeat.o(4815);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Voip.VideoActivity", e, "bindVoipForegroundIfNeed error: %s", e.getMessage());
            AppMethodBeat.o(4815);
        }
    }

    private void cKX() {
        AppMethodBeat.i(4816);
        ab.c("MicroMsg.Voip.VideoActivity", "unbindVoiceServiceIfNeed and isBindVoipForegroundService" + this.sWf, new Object[0]);
        try {
            if (com.tencent.mm.compatible.util.d.iW(26) && this.sWf) {
                Intent intent = new Intent();
                intent.setClass(ah.getContext(), VoipForegroundService.class);
                ah.getContext().stopService(intent);
                this.sWf = false;
            }
            AppMethodBeat.o(4816);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Voip.VideoActivity", e, "unBind vidoeforeground error: %s", e.getMessage());
            AppMethodBeat.o(4816);
        }
    }

    public final void setScreenEnable(boolean z) {
        AppMethodBeat.i(4817);
        super.setScreenEnable(z);
        if (this.sVY != null) {
            this.sVY.get();
        }
        if (!(z || this.sWf)) {
            cKW();
        }
        AppMethodBeat.o(4817);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(4818);
        ab.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(4818);
    }

    public void onPause() {
        AppMethodBeat.i(4819);
        super.onPause();
        PowerManager powerManager = (PowerManager) ah.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.sWd = z;
        ab.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", com.tencent.mm.plugin.voip.a.b.GK(this.mStatus), Boolean.valueOf(this.sWd), Boolean.valueOf(r5), Boolean.valueOf(r4), Boolean.valueOf(r1));
        o.JV(2);
        AppMethodBeat.o(4819);
    }

    public void onResume() {
        AppMethodBeat.i(4820);
        ab.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", com.tencent.mm.plugin.voip.a.b.GK(this.mStatus));
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        k kVar = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl;
        if (kVar.sPb) {
            kVar.sPb = false;
        }
        super.onResume();
        setScreenEnable(true);
        this.sWa = bo.yz();
        if (this.sRm && com.tencent.mm.plugin.voip.a.b.GP(this.mStatus) && com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
            com.tencent.mm.plugin.voip.b.cIj().an(this.sRn ? 0 : 1, this.sRm);
        }
        o.JV(1);
        this.sWi = true;
        if (!(this.sVY == null || this.sVY.get() == null)) {
            ((c) this.sVY.get()).cJt();
        }
        AppMethodBeat.o(4820);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(4821);
        if (this.sVX != null) {
            this.sVX.a(bArr, j, i, i2, i3, i4, i5, i6);
        }
        AppMethodBeat.o(4821);
    }

    public final byte[] cKU() {
        AppMethodBeat.i(4822);
        if (!(this.sVX == null || this.sVX.getFilterData() == null)) {
            this.sVX.getFilterData().a(new com.tencent.mm.plugin.voip.video.a.d() {
                public final void bu(byte[] bArr) {
                    AppMethodBeat.i(4798);
                    if (bArr != null) {
                        VideoActivity.this.sWh = bArr;
                    }
                    AppMethodBeat.o(4798);
                }
            });
        }
        byte[] bArr = this.sWh;
        AppMethodBeat.o(4822);
        return bArr;
    }

    public final void br(final int i, String str) {
        AppMethodBeat.i(4823);
        ab.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", Integer.valueOf(i), Boolean.valueOf(this.sRn));
        this.maH = true;
        if (i == com.tencent.view.d.MIC_PTU_QINGCONG) {
            com.tencent.mm.ui.base.h.b((Context) this, str, null, true);
            AppMethodBeat.o(4823);
            return;
        }
        this.iGP.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4799);
                VideoActivity.a(VideoActivity.this, i);
                AppMethodBeat.o(4799);
            }
        });
        AppMethodBeat.o(4823);
    }

    public final void abY(final String str) {
        AppMethodBeat.i(4824);
        if (this.sVX != null) {
            this.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4800);
                    if (VideoActivity.this.sVX != null) {
                        VideoActivity.this.sVX.abY(str);
                    }
                    AppMethodBeat.o(4800);
                }
            });
        }
        AppMethodBeat.o(4824);
    }

    public final int getLayoutId() {
        return R.layout.b2e;
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(4825);
        ae.h(ae.a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
        AppMethodBeat.o(4825);
    }

    private int bHJ() {
        AppMethodBeat.i(4826);
        int Lc;
        if (com.tencent.mm.compatible.b.g.KK().KP()) {
            Lc = com.tencent.mm.compatible.b.g.KK().Lc();
            AppMethodBeat.o(4826);
            return Lc;
        }
        if (com.tencent.mm.plugin.voip.a.b.GN(this.mStatus)) {
            Lc = com.tencent.mm.plugin.voip.b.cIj().cIt();
        } else {
            Lc = 2;
            if (this.sRm) {
                if (this.sRn) {
                    Lc = 3;
                    if (com.tencent.mm.compatible.b.g.KK().KV()) {
                        if (q.etd.eqm >= 0) {
                            Lc = q.etd.eqm;
                        }
                        Lc = 0;
                    } else if (q.etd.eqj >= 0) {
                        Lc = q.etd.eqj;
                    }
                } else {
                    if (q.etd.eqm >= 0) {
                        Lc = q.etd.eqm;
                    }
                    Lc = 0;
                }
            } else if (com.tencent.mm.compatible.b.g.KK().KV()) {
                if (q.etd.eqm >= 0) {
                    Lc = q.etd.eqm;
                }
                Lc = 0;
            }
            if (!com.tencent.mm.compatible.b.g.KK().KP() && q.etd.eqo >= 0) {
                Lc = q.etd.eqo;
            }
        }
        ab.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", Integer.valueOf(Lc));
        AppMethodBeat.o(4826);
        return Lc;
    }

    public final void GC(int i) {
        AppMethodBeat.i(4827);
        this.sRr = i;
        if (this.sVX != null) {
            this.sVX.GC(i);
        }
        AppMethodBeat.o(4827);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(4828);
        this.mIsMute = z;
        if (this.sVX != null) {
            this.sVX.setMute(z);
        }
        AppMethodBeat.o(4828);
    }

    public final void c(int i, int i2, int[] iArr) {
        AppMethodBeat.i(4829);
        if (this.sVX != null) {
            this.sVX.c(i, i2, iArr);
        }
        AppMethodBeat.o(4829);
    }

    public final void cJD() {
        AppMethodBeat.i(4830);
        if (this.sVX != null) {
            this.sVX.cJD();
        }
        AppMethodBeat.o(4830);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.i(4831);
        if (this.sVX != null) {
            this.sVX.setVoipBeauty(i);
        }
        AppMethodBeat.o(4831);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.i(4832);
        if (this.sVX != null) {
            this.sVX.setHWDecMode(i);
        }
        AppMethodBeat.o(4832);
    }

    public final void uninit() {
        AppMethodBeat.i(4833);
        if (this.sVX != null) {
            this.sVX.uninit();
        }
        AppMethodBeat.o(4833);
    }

    public final void setConnectSec(long j) {
        AppMethodBeat.i(4834);
        this.sVZ = j;
        if (this.sVX != null) {
            this.sVX.lI(this.sVZ);
        }
        AppMethodBeat.o(4834);
    }

    public final void my(boolean z) {
        AppMethodBeat.i(4835);
        ab.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(z)));
        if (this.sVX != null) {
            this.sVX.mz(z);
        }
        AppMethodBeat.o(4835);
    }

    public final void bIK() {
        AppMethodBeat.i(4836);
        ab.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.sVX != null) {
            this.sVX.cKY();
        }
        AppMethodBeat.o(4836);
    }

    public final void S(boolean z, boolean z2) {
        AppMethodBeat.i(4837);
        this.sWb = z2;
        if (z) {
            cJz();
            AppMethodBeat.o(4837);
            return;
        }
        cKX();
        finish();
        AppMethodBeat.o(4837);
    }

    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.i(4838);
        this.sRg = captureView;
        if (this.sVX != null) {
            this.sVX.a(captureView);
        }
        AppMethodBeat.o(4838);
    }

    public final void cKT() {
        AppMethodBeat.i(4839);
        if (this.sVX instanceof VoipVideoFragment) {
            ((VoipVideoFragment) this.sVX).cKT();
        }
        AppMethodBeat.o(4839);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(4840);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(4840);
            return;
        }
        ab.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(4790);
                            dialogInterface.dismiss();
                            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(4790);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(4791);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(4791);
                        }
                    });
                    AppMethodBeat.o(4840);
                    return;
                }
                break;
            case 82:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(4792);
                            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(4792);
                        }
                    }, null);
                    break;
                }
                break;
        }
        AppMethodBeat.o(4840);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public final Context cKS() {
        return this.mController.ylL;
    }
}
