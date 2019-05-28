package com.tencent.p177mm.plugin.multitalk.p459ui;

import android.app.KeyguardManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p230g.p231a.C37750kc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.multitalk.model.C12630f;
import com.tencent.p177mm.plugin.multitalk.model.C12630f.C126446;
import com.tencent.p177mm.plugin.multitalk.model.C12650n;
import com.tencent.p177mm.plugin.multitalk.model.C34571j;
import com.tencent.p177mm.plugin.multitalk.model.C34571j.C34570a;
import com.tencent.p177mm.plugin.multitalk.model.C34572p;
import com.tencent.p177mm.plugin.multitalk.model.C46088b;
import com.tencent.p177mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C16836f;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C16836f.C16838b;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C16836f.C16839a;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C43321c;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C46090e;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.wecall.talkroom.model.C6001c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI */
public class MultiTalkMainUI extends MMActivity implements ServiceConnection, C46088b {
    protected C7306ak lda;
    private C43321c oHG;
    private C16836f oHH;
    private boolean oHI;
    private Notification oHJ;
    private boolean oHK = true;
    private boolean oHL = false;
    boolean oHM = false;
    private ScreenActionReceiver oHN;
    private Runnable oHO = new C213311();
    private boolean oHP;
    private BroadcastReceiver oHQ = new C126525();
    C7306ak oHR = new C2133210();

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$6 */
    class C35186 implements OnClickListener {
        C35186() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(54123);
            MultiTalkMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(54123);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$7 */
    class C35197 implements OnClickListener {
        C35197() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(54124);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(54124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$8 */
    class C35208 implements OnClickListener {
        C35208() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(54125);
            MultiTalkMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(54125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$5 */
    class C126525 extends BroadcastReceiver {
        C126525() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(54122);
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && C34572p.bSf().oGg == C46090e.Inviting) {
                C34572p.bSf().stopRing();
                MultiTalkMainUI.this.oHK = false;
            }
            AppMethodBeat.m2505o(54122);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$3 */
    class C213293 implements OnClickListener {
        C213293() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(54120);
            C34572p.bSf().mo24587h(false, false, false);
            AppMethodBeat.m2505o(54120);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$4 */
    class C213304 implements Runnable {
        C213304() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54121);
            MultiTalkMainUI.this.oHH.mo30836jt(false);
            AppMethodBeat.m2505o(54121);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$1 */
    class C213311 implements Runnable {
        C213311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54118);
            C34572p.bSf().bRP();
            AppMethodBeat.m2505o(54118);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$10 */
    class C2133210 extends C7306ak {
        C2133210() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(54127);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (!MultiTalkMainUI.this.oHM) {
                        MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                        C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
                        try {
                            if (C1443d.m3068iW(26)) {
                                multiTalkMainUI.oHM = true;
                                Intent intent = new Intent();
                                intent.setClass(C4996ah.getContext(), MultiTalkingForegroundService.class);
                                C4996ah.getContext().bindService(intent, multiTalkMainUI, 1);
                            }
                            AppMethodBeat.m2505o(54127);
                            return;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", e, "bindVoiceServiceIfNeed error: %s", e.getMessage());
                            AppMethodBeat.m2505o(54127);
                            return;
                        }
                    }
                    break;
                case 1:
                    ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(43);
                    break;
            }
            AppMethodBeat.m2505o(54127);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$ScreenActionReceiver */
    public class ScreenActionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(54128);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.SCREEN_OFF")) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "receive action screen off");
                MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                multiTalkMainUI.oHR.removeCallbacksAndMessages(null);
                multiTalkMainUI.oHR.sendEmptyMessage(0);
            }
            AppMethodBeat.m2505o(54128);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI$9 */
    class C213349 implements OnClickListener {
        C213349() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(54126);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(54126);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MultiTalkMainUI() {
        AppMethodBeat.m2504i(54129);
        AppMethodBeat.m2505o(54129);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(54130);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        C1407g.m2946KK().mo4817KM();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8293s);
        } else {
            overridePendingTransition(C25738R.anim.f8405dh, C25738R.anim.f8406di);
        }
        getWindow().addFlags(6815872);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        C34572p.bSf().bGT();
        if (C34572p.bSf().bRd()) {
            this.oHG = new C43321c(this);
            this.oHH = new C16836f(this);
            C34572p.bSf().mo24591jo(C34572p.bSf().oGb);
            C34572p.bSf().oGq = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.oHQ, intentFilter);
            this.oHL = true;
            this.lda = new C7306ak();
            if (!C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
            }
            if (C1443d.m3068iW(26)) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
                this.oHN = new ScreenActionReceiver();
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                C4996ah.getContext().registerReceiver(this.oHN, intentFilter);
            }
            this.oHJ = (Notification) getIntent().getParcelableExtra("notification");
            AppMethodBeat.m2505o(54130);
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
        AppMethodBeat.m2505o(54130);
    }

    public final int getLayoutId() {
        return 2130970266;
    }

    public void onResume() {
        AppMethodBeat.m2504i(54131);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "onResume");
        super.onResume();
        switch (C34572p.bSf().oGg) {
            case Inviting:
                this.oHH.oIL.setVisibility(8);
                this.oHG.mo68868n(C34572p.bSf().oGh);
                if (C5023at.is4G(this)) {
                    C34572p.bSd().mo55141R(this);
                } else if (C5023at.is2G(this) || C5023at.is3G(this)) {
                    C34572p.bSd().mo55140Q(this);
                }
                if (this.oHK) {
                    C34572p.bSf().mo24592jp(false);
                    break;
                }
                break;
            case Starting:
            case Creating:
                this.oHG.bSm();
                this.oHH.mo30837o(C34572p.bSf().oGh);
                if (C5023at.is4G(this)) {
                    C34572p.bSd().mo55141R(this);
                } else if (C5023at.is2G(this) || C5023at.is3G(this)) {
                    C34572p.bSd().mo55140Q(this);
                }
                C34572p.bSf().mo24592jp(true);
                break;
            case Talking:
                this.oHG.bSm();
                this.oHH.mo30837o(C34572p.bSf().oGh);
                break;
        }
        if (C34572p.bSf().bRH()) {
            if (C34572p.bSf().bRF()) {
                this.oHH.mo30834jr(true);
            }
            this.lda.postDelayed(this.oHO, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(54131);
    }

    public void onPause() {
        AppMethodBeat.m2504i(54132);
        PowerManager powerManager = (PowerManager) C4996ah.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) C4996ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.oHI = z;
        C4990ab.m7417i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", Boolean.valueOf(this.oHI));
        if (C34572p.bSf().bRH()) {
            C34572p.bSf().bRQ();
            this.oHH.mo30835js(true);
        }
        super.onPause();
        AppMethodBeat.m2505o(54132);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(54133);
        if (this.oHP) {
            C34572p.bSf().mo24590jn(false);
        }
        if (this.oHL) {
            unregisterReceiver(this.oHQ);
        }
        this.oHR.removeCallbacksAndMessages(null);
        this.oHR.sendEmptyMessage(1);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
        try {
            if (C1443d.m3068iW(26) && this.oHM) {
                C4996ah.getContext().unbindService(this);
                this.oHM = false;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", e, "unbindVoiceServiceIfNeed error: %s", e.getMessage());
        }
        if (C1443d.m3068iW(26)) {
            C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
            if (this.oHN != null) {
                try {
                    C4996ah.getContext().unregisterReceiver(this.oHN);
                } catch (Exception e2) {
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", e2.getMessage());
                }
                this.oHN = null;
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(54133);
    }

    public void onStop() {
        AppMethodBeat.m2504i(54134);
        if (!this.oHP && this.oHI) {
            C34572p.bSf().mo24590jn(false);
        }
        super.onStop();
        AppMethodBeat.m2505o(54134);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(54135);
        if (keyEvent.getKeyCode() == 4) {
            C30379h.m48428a((Context) this, (int) C25738R.string.d2l, (int) C25738R.string.d21, (int) C25738R.string.f8819fx, (int) C25738R.string.f9076or, new C213293(), null);
            AppMethodBeat.m2505o(54135);
            return true;
        }
        if (C34572p.bSf().oGg == C46090e.Inviting) {
            if (i == 25 || i == 24) {
                C34572p.bSf().stopRing();
                this.oHK = false;
                AppMethodBeat.m2505o(54135);
                return true;
            }
        } else if (i == 25) {
            C1407g.m2946KK().mo4839iK(MultiTalkMainUI.bHJ());
            AppMethodBeat.m2505o(54135);
            return true;
        } else if (i == 24) {
            C1407g.m2946KK().mo4838iJ(MultiTalkMainUI.bHJ());
            AppMethodBeat.m2505o(54135);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(54135);
        return onKeyDown;
    }

    private static int bHJ() {
        AppMethodBeat.m2504i(54136);
        if (C1407g.m2946KK().mo4819KP()) {
            int Lc = C1407g.m2946KK().mo4827Lc();
            AppMethodBeat.m2505o(54136);
            return Lc;
        } else if (C34572p.bSf().nwe.mo38019DB()) {
            AppMethodBeat.m2505o(54136);
            return 0;
        } else {
            AppMethodBeat.m2505o(54136);
            return 3;
        }
    }

    public final void bSk() {
        AppMethodBeat.m2504i(54137);
        this.oHP = true;
        Intent intent = new Intent(this, MultiTalkAddMembersUI.class);
        List arrayList = new ArrayList();
        if (C34572p.bSf().oGh != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : C34572p.bSf().oGh.Aqg) {
                if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                    arrayList.add(multiTalkGroupMember.Aqh);
                }
            }
            intent.putExtra("titile", getString(C25738R.string.d22));
            intent.putExtra("chatroomName", C34572p.bSf().oGh.Aqe);
            intent.putExtra("always_select_contact", C5046bo.m7536c(arrayList, ","));
            intent.putExtra("key_need_gallery", false);
            startActivityForResult(intent, 1);
        }
        AppMethodBeat.m2505o(54137);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(54138);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.oHP = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(stringExtra)));
            ArrayList P = C5046bo.m7508P(stringExtra.split(","));
            if (P == null) {
                AppMethodBeat.m2505o(54138);
                return;
            }
            C12630f bSf = C34572p.bSf();
            if (bSf.bRd()) {
                stringExtra = bSf.oGh.Aqc;
                if (C5046bo.isNullOrNil(stringExtra)) {
                    stringExtra = bSf.oGh.Aqd;
                }
                C34572p.bSe().oFP.mo58355B(stringExtra, P);
            }
        }
        AppMethodBeat.m2505o(54138);
    }

    public final void bRf() {
        AppMethodBeat.m2504i(54139);
        switch (C34572p.bSf().oGg) {
            case Inviting:
                this.oHG.mo68868n(C34572p.bSf().oGh);
                break;
            case Starting:
            case Creating:
            case Talking:
                this.oHH.mo30837o(C34572p.bSf().oGh);
                AppMethodBeat.m2505o(54139);
                return;
        }
        AppMethodBeat.m2505o(54139);
    }

    public final void bNY() {
        AppMethodBeat.m2504i(54140);
        this.oHG.bSm();
        this.oHH.mo30837o(C34572p.bSf().oGh);
        AppMethodBeat.m2505o(54140);
    }

    public final void bGZ() {
        AppMethodBeat.m2504i(54141);
        C37750kc c37750kc = new C37750kc();
        c37750kc.cFw.action = 0;
        C4879a.xxA.mo10055m(c37750kc);
        this.oHH.mo30836jt(true);
        C34572p.bSf().oGq = null;
        C34572p.bSf().stopRing();
        finish();
        AppMethodBeat.m2505o(54141);
    }

    public final void bRe() {
        AppMethodBeat.m2504i(54142);
        C1407g.m2946KK().mo4818KN();
        C7305d.post(new C126446(), "MultiTalkManager_play_end_sound");
        C37750kc c37750kc = new C37750kc();
        c37750kc.cFw.action = 0;
        C4879a.xxA.mo10055m(c37750kc);
        this.lda.post(new C213304());
        C34572p.bSf().oGq = null;
        C34572p.bSf().stopRing();
        finish();
        AppMethodBeat.m2505o(54142);
    }

    public final void onError(int i) {
        AppMethodBeat.m2504i(54143);
        if (i == -1700) {
            C16836f c16836f = this.oHH;
            C4990ab.m7416i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
            c16836f.mo30835js(false);
            C34572p.bSf().mo24599zf(1);
            c16836f.oIP.setChecked(false);
        }
        AppMethodBeat.m2505o(54143);
    }

    public final void bRg() {
        AppMethodBeat.m2504i(54144);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + C34572p.bSf().oGf.size());
        if (C34572p.bSf().bRH()) {
            if (C34572p.bSf().oGf.size() > 0) {
                C34571j.bRW();
                C34572p.bSf().bRP();
            } else {
                C34572p.bSf().bRQ();
            }
            C16836f c16836f = this.oHH;
            HashSet hashSet = new HashSet();
            hashSet.addAll(C34572p.bSf().oGf);
            if (C34572p.bSf().bRG()) {
                c16836f.mo30833d(hashSet);
            }
        }
        AppMethodBeat.m2505o(54144);
    }

    /* renamed from: jg */
    public final void mo36767jg(boolean z) {
        AppMethodBeat.m2504i(54145);
        if (C34572p.bSf().bRH()) {
            this.oHH.oIQ.setChecked(z);
        }
        AppMethodBeat.m2505o(54145);
    }

    /* renamed from: jh */
    public final void mo36768jh(boolean z) {
        AppMethodBeat.m2504i(54146);
        if (C34572p.bSf().bRH()) {
            C16836f c16836f = this.oHH;
            c16836f.oIR.setChecked(z);
            c16836f.bSp();
        }
        AppMethodBeat.m2505o(54146);
    }

    /* renamed from: eB */
    public final void mo36766eB(int i, int i2) {
        AppMethodBeat.m2504i(54147);
        if (C34572p.bSf().bRH()) {
            C16836f c16836f = this.oHH;
            RelativeLayout Sq = c16836f.mo30827Sq(C1853r.m3846Yz());
            if (Sq != null) {
                C16839a c16839a = (C16839a) Sq.getTag();
                if (!C34571j.m56707zg(i2)) {
                    if (C34571j.m56707zg(i)) {
                        c16836f.oIP.setChecked(false);
                        c16839a.oJe.bSr();
                        c16836f.oIO.setVisibility(8);
                        if (c16836f.oIZ.equals(C1853r.m3846Yz()) && c16836f.oIJ.getVisibility() == 0) {
                            c16836f.oIZ = "";
                            c16836f.oII.setVisibility(0);
                            c16836f.oIJ.setVisibility(8);
                        }
                    }
                    c16836f.mo30835js(false);
                } else if (C34571j.m56707zg(i2) && !C34571j.m56707zg(i)) {
                    c16836f.oIP.setChecked(true);
                    c16839a.oJe.bSs();
                    c16839a.oJh.setVisibility(8);
                    C5004al.m7442n(new C16838b(c16839a), 1500);
                    c16836f.oIO.setVisibility(0);
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(C34572p.bSf().oGf);
                if (C34571j.m56708zh(i2)) {
                    if (C34571j.m56708zh(i2) && !C34571j.m56708zh(i)) {
                        c16836f.mo30833d(hashSet);
                    }
                } else if (C34571j.m56708zh(i)) {
                    c16836f.bSn();
                    AppMethodBeat.m2505o(54147);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(54147);
    }

    /* renamed from: ji */
    public final void mo36769ji(boolean z) {
        AppMethodBeat.m2504i(54148);
        if (C34572p.bSf().bRH()) {
            C16836f c16836f = this.oHH;
            if (c16836f.oIR != null) {
                c16836f.oIR.setEnabled(z);
            }
        }
        AppMethodBeat.m2505o(54148);
    }

    /* renamed from: a */
    public final void mo36756a(String str, int[] iArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(54149);
        if (C34572p.bSf().bRH()) {
            this.oHH.mo30829a(str, iArr, i, i2, i3);
        }
        AppMethodBeat.m2505o(54149);
    }

    /* renamed from: a */
    public final void mo36755a(String str, Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(54150);
        this.oHH.mo30828a(str, bitmap, i, i2);
        AppMethodBeat.m2505o(54150);
    }

    /* renamed from: Sg */
    public final int mo36752Sg(String str) {
        AppMethodBeat.m2504i(54151);
        RelativeLayout Sq = this.oHH.mo30827Sq(str);
        if (Sq == null) {
            AppMethodBeat.m2505o(54151);
            return -1;
        }
        int position = ((C16839a) Sq.getTag()).oJe.getPosition();
        AppMethodBeat.m2505o(54151);
        return position;
    }

    /* renamed from: a */
    public final void mo36754a(C46090e c46090e) {
        AppMethodBeat.m2504i(54152);
        if (c46090e == C46090e.Talking) {
            C16836f c16836f = this.oHH;
            if (c16836f.oJb > 0) {
                c16836f.oJb = System.currentTimeMillis();
            }
        }
        AppMethodBeat.m2505o(54152);
    }

    /* renamed from: a */
    public final void mo36753a(C34570a c34570a) {
        AppMethodBeat.m2504i(54153);
        if (c34570a == C34570a._4G) {
            C34572p.bSd().mo55141R(this);
            AppMethodBeat.m2505o(54153);
        } else if (c34570a == C34570a._3GOr_2G) {
            C34572p.bSd().mo55140Q(this);
            AppMethodBeat.m2505o(54153);
        } else {
            if (c34570a == C34570a.None) {
                C17981e.m28295a(this, C25738R.string.f6c, null);
            }
            AppMethodBeat.m2505o(54153);
        }
    }

    public final void bHa() {
        Iterator it;
        C16839a c16839a;
        AppMethodBeat.m2504i(54154);
        C16836f c16836f = this.oHH;
        long j = (long) C34572p.bSf().oGk;
        c16836f.enf.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        C12630f bSf = C34572p.bSf();
        String str = bSf.oGh.Aqc;
        if (C5046bo.isNullOrNil(str)) {
            str = bSf.oGh.Aqd;
        }
        List atK = C34572p.bSe().oFP.atK(str);
        HashSet hashSet = C34572p.bSf().oGf;
        if (atK != null) {
            it = c16836f.oIU.iterator();
            while (it.hasNext()) {
                c16839a = (C16839a) ((RelativeLayout) it.next()).getTag();
                String username = c16839a.oJe.getUsername();
                if ((C1853r.m3846Yz().equals(username) && c16836f.bRh()) || !atK.contains(username) || hashSet.contains(username)) {
                    c16839a.oJf.setVisibility(8);
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", username);
                } else {
                    c16839a.oJf.setVisibility(0);
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", username);
                }
            }
        }
        bSf = C34572p.bSf();
        str = bSf.oGh.Aqc;
        if (C5046bo.isNullOrNil(str)) {
            str = bSf.oGh.Aqd;
        }
        if (C12650n.oHu == null) {
            C12650n.oHu = new C12650n();
        }
        C12650n c12650n = C12650n.oHu;
        ArrayList arrayList = new ArrayList();
        c12650n.oHv = C6001c.dTg().auE(str);
        if (c12650n.oHv != null) {
            for (C24193av c24193av : c12650n.oHv.dTa()) {
                int i = c24193av.kyZ;
                if (i >= 0) {
                    byte[] bArr = new byte[4];
                    if (C34572p.bSe().oFP.setAppCmd(10, bArr, i) < 0) {
                        C4990ab.m7411d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", Integer.valueOf(i));
                        i = -1;
                    } else {
                        i = C5046bo.m7533bf(bArr);
                        C4990ab.m7411d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", Integer.valueOf(i));
                    }
                    if (i == -1 || i >= 5) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        arrayList.add(c24193av.Aop);
                    }
                }
            }
        }
        Iterator it2 = c16836f.oIU.iterator();
        while (it2.hasNext()) {
            c16839a = (C16839a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(c16839a.oJe.getUsername())) {
                c16839a.oJg.setVisibility(0);
            } else {
                c16839a.oJg.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(54154);
    }

    public final boolean bRh() {
        AppMethodBeat.m2504i(54155);
        if (this.oHH != null) {
            boolean bRh = this.oHH.bRh();
            AppMethodBeat.m2505o(54155);
            return bRh;
        }
        AppMethodBeat.m2505o(54155);
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(54156);
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            C4990ab.m7413e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i));
            AppMethodBeat.m2505o(54156);
            return;
        }
        C4990ab.m7411d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 22:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C35208(), new C213349());
                    break;
                }
                C4990ab.m7410d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
                AppMethodBeat.m2505o(54156);
                return;
            case 82:
                if (iArr[0] == 0) {
                    C4990ab.m7410d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    AppMethodBeat.m2505o(54156);
                    return;
                }
                C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C35186(), new C35197());
                AppMethodBeat.m2505o(54156);
                return;
        }
        AppMethodBeat.m2505o(54156);
    }

    public final ViewGroup bSl() {
        AppMethodBeat.m2504i(54157);
        ViewGroup viewGroup = (ViewGroup) findViewById(2131826214);
        AppMethodBeat.m2505o(54157);
        return viewGroup;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
