package com.tencent.mm.plugin.multitalk.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.multitalk.model.b;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MultiTalkMainUI extends MMActivity implements ServiceConnection, b {
    protected ak lda;
    private c oHG;
    private f oHH;
    private boolean oHI;
    private Notification oHJ;
    private boolean oHK = true;
    private boolean oHL = false;
    boolean oHM = false;
    private ScreenActionReceiver oHN;
    private Runnable oHO = new Runnable() {
        public final void run() {
            AppMethodBeat.i(54118);
            p.bSf().bRP();
            AppMethodBeat.o(54118);
        }
    };
    private boolean oHP;
    private BroadcastReceiver oHQ = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(54122);
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && p.bSf().oGg == e.Inviting) {
                p.bSf().stopRing();
                MultiTalkMainUI.this.oHK = false;
            }
            AppMethodBeat.o(54122);
        }
    };
    ak oHR = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(54127);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (!MultiTalkMainUI.this.oHM) {
                        MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                        ab.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
                        try {
                            if (d.iW(26)) {
                                multiTalkMainUI.oHM = true;
                                Intent intent = new Intent();
                                intent.setClass(ah.getContext(), MultiTalkingForegroundService.class);
                                ah.getContext().bindService(intent, multiTalkMainUI, 1);
                            }
                            AppMethodBeat.o(54127);
                            return;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", e, "bindVoiceServiceIfNeed error: %s", e.getMessage());
                            AppMethodBeat.o(54127);
                            return;
                        }
                    }
                    break;
                case 1:
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(43);
                    break;
            }
            AppMethodBeat.o(54127);
        }
    };

    public class ScreenActionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(54128);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.SCREEN_OFF")) {
                ab.i("MicroMsg.MT.MultiTalkMainUI", "receive action screen off");
                MultiTalkMainUI multiTalkMainUI = MultiTalkMainUI.this;
                multiTalkMainUI.oHR.removeCallbacksAndMessages(null);
                multiTalkMainUI.oHR.sendEmptyMessage(0);
            }
            AppMethodBeat.o(54128);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MultiTalkMainUI() {
        AppMethodBeat.i(54129);
        AppMethodBeat.o(54129);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(54130);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        com.tencent.mm.compatible.b.g.KK().KM();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(R.anim.c4, R.anim.s);
        } else {
            overridePendingTransition(R.anim.dh, R.anim.di);
        }
        getWindow().addFlags(6815872);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        p.bSf().bGT();
        if (p.bSf().bRd()) {
            this.oHG = new c(this);
            this.oHH = new f(this);
            p.bSf().jo(p.bSf().oGb);
            p.bSf().oGq = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.oHQ, intentFilter);
            this.oHL = true;
            this.lda = new ak();
            if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
                ab.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
            }
            if (d.iW(26)) {
                ab.i("MicroMsg.MT.MultiTalkMainUI", "initScreenObserver");
                this.oHN = new ScreenActionReceiver();
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                ah.getContext().registerReceiver(this.oHN, intentFilter);
            }
            this.oHJ = (Notification) getIntent().getParcelableExtra("notification");
            AppMethodBeat.o(54130);
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
        AppMethodBeat.o(54130);
    }

    public final int getLayoutId() {
        return R.layout.ahv;
    }

    public void onResume() {
        AppMethodBeat.i(54131);
        ab.i("MicroMsg.MT.MultiTalkMainUI", "onResume");
        super.onResume();
        switch (p.bSf().oGg) {
            case Inviting:
                this.oHH.oIL.setVisibility(8);
                this.oHG.n(p.bSf().oGh);
                if (at.is4G(this)) {
                    p.bSd().R(this);
                } else if (at.is2G(this) || at.is3G(this)) {
                    p.bSd().Q(this);
                }
                if (this.oHK) {
                    p.bSf().jp(false);
                    break;
                }
                break;
            case Starting:
            case Creating:
                this.oHG.bSm();
                this.oHH.o(p.bSf().oGh);
                if (at.is4G(this)) {
                    p.bSd().R(this);
                } else if (at.is2G(this) || at.is3G(this)) {
                    p.bSd().Q(this);
                }
                p.bSf().jp(true);
                break;
            case Talking:
                this.oHG.bSm();
                this.oHH.o(p.bSf().oGh);
                break;
        }
        if (p.bSf().bRH()) {
            if (p.bSf().bRF()) {
                this.oHH.jr(true);
            }
            this.lda.postDelayed(this.oHO, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(54131);
    }

    public void onPause() {
        AppMethodBeat.i(54132);
        PowerManager powerManager = (PowerManager) ah.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.oHI = z;
        ab.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", Boolean.valueOf(this.oHI));
        if (p.bSf().bRH()) {
            p.bSf().bRQ();
            this.oHH.js(true);
        }
        super.onPause();
        AppMethodBeat.o(54132);
    }

    public void onDestroy() {
        AppMethodBeat.i(54133);
        if (this.oHP) {
            p.bSf().jn(false);
        }
        if (this.oHL) {
            unregisterReceiver(this.oHQ);
        }
        this.oHR.removeCallbacksAndMessages(null);
        this.oHR.sendEmptyMessage(1);
        ab.i("MicroMsg.MT.MultiTalkMainUI", "unbindVoiceServiceIfNeed");
        try {
            if (d.iW(26) && this.oHM) {
                ah.getContext().unbindService(this);
                this.oHM = false;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", e, "unbindVoiceServiceIfNeed error: %s", e.getMessage());
        }
        if (d.iW(26)) {
            ab.i("MicroMsg.MT.MultiTalkMainUI", "unInitScreenObserver");
            if (this.oHN != null) {
                try {
                    ah.getContext().unregisterReceiver(this.oHN);
                } catch (Exception e2) {
                    ab.i("MicroMsg.MT.MultiTalkMainUI", "unregisterBatteryChange err:%s", e2.getMessage());
                }
                this.oHN = null;
            }
        }
        super.onDestroy();
        AppMethodBeat.o(54133);
    }

    public void onStop() {
        AppMethodBeat.i(54134);
        if (!this.oHP && this.oHI) {
            p.bSf().jn(false);
        }
        super.onStop();
        AppMethodBeat.o(54134);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(54135);
        if (keyEvent.getKeyCode() == 4) {
            h.a((Context) this, (int) R.string.d2l, (int) R.string.d21, (int) R.string.fx, (int) R.string.or, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(54120);
                    p.bSf().h(false, false, false);
                    AppMethodBeat.o(54120);
                }
            }, null);
            AppMethodBeat.o(54135);
            return true;
        }
        if (p.bSf().oGg == e.Inviting) {
            if (i == 25 || i == 24) {
                p.bSf().stopRing();
                this.oHK = false;
                AppMethodBeat.o(54135);
                return true;
            }
        } else if (i == 25) {
            com.tencent.mm.compatible.b.g.KK().iK(bHJ());
            AppMethodBeat.o(54135);
            return true;
        } else if (i == 24) {
            com.tencent.mm.compatible.b.g.KK().iJ(bHJ());
            AppMethodBeat.o(54135);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(54135);
        return onKeyDown;
    }

    private static int bHJ() {
        AppMethodBeat.i(54136);
        if (com.tencent.mm.compatible.b.g.KK().KP()) {
            int Lc = com.tencent.mm.compatible.b.g.KK().Lc();
            AppMethodBeat.o(54136);
            return Lc;
        } else if (p.bSf().nwe.DB()) {
            AppMethodBeat.o(54136);
            return 0;
        } else {
            AppMethodBeat.o(54136);
            return 3;
        }
    }

    public final void bSk() {
        AppMethodBeat.i(54137);
        this.oHP = true;
        Intent intent = new Intent(this, MultiTalkAddMembersUI.class);
        List arrayList = new ArrayList();
        if (p.bSf().oGh != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : p.bSf().oGh.Aqg) {
                if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                    arrayList.add(multiTalkGroupMember.Aqh);
                }
            }
            intent.putExtra("titile", getString(R.string.d22));
            intent.putExtra("chatroomName", p.bSf().oGh.Aqe);
            intent.putExtra("always_select_contact", bo.c(arrayList, ","));
            intent.putExtra("key_need_gallery", false);
            startActivityForResult(intent, 1);
        }
        AppMethodBeat.o(54137);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(54138);
        ab.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.oHP = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            ab.i("MicroMsg.MT.MultiTalkMainUI", "add member ".concat(String.valueOf(stringExtra)));
            ArrayList P = bo.P(stringExtra.split(","));
            if (P == null) {
                AppMethodBeat.o(54138);
                return;
            }
            com.tencent.mm.plugin.multitalk.model.f bSf = p.bSf();
            if (bSf.bRd()) {
                stringExtra = bSf.oGh.Aqc;
                if (bo.isNullOrNil(stringExtra)) {
                    stringExtra = bSf.oGh.Aqd;
                }
                p.bSe().oFP.B(stringExtra, P);
            }
        }
        AppMethodBeat.o(54138);
    }

    public final void bRf() {
        AppMethodBeat.i(54139);
        switch (p.bSf().oGg) {
            case Inviting:
                this.oHG.n(p.bSf().oGh);
                break;
            case Starting:
            case Creating:
            case Talking:
                this.oHH.o(p.bSf().oGh);
                AppMethodBeat.o(54139);
                return;
        }
        AppMethodBeat.o(54139);
    }

    public final void bNY() {
        AppMethodBeat.i(54140);
        this.oHG.bSm();
        this.oHH.o(p.bSf().oGh);
        AppMethodBeat.o(54140);
    }

    public final void bGZ() {
        AppMethodBeat.i(54141);
        kc kcVar = new kc();
        kcVar.cFw.action = 0;
        com.tencent.mm.sdk.b.a.xxA.m(kcVar);
        this.oHH.jt(true);
        p.bSf().oGq = null;
        p.bSf().stopRing();
        finish();
        AppMethodBeat.o(54141);
    }

    public final void bRe() {
        AppMethodBeat.i(54142);
        com.tencent.mm.compatible.b.g.KK().KN();
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(53948);
                f.this.nwe.stop();
                f.this.nwe.Gx(1);
                AppMethodBeat.o(53948);
            }
        }, "MultiTalkManager_play_end_sound");
        kc kcVar = new kc();
        kcVar.cFw.action = 0;
        com.tencent.mm.sdk.b.a.xxA.m(kcVar);
        this.lda.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54121);
                MultiTalkMainUI.this.oHH.jt(false);
                AppMethodBeat.o(54121);
            }
        });
        p.bSf().oGq = null;
        p.bSf().stopRing();
        finish();
        AppMethodBeat.o(54142);
    }

    public final void onError(int i) {
        AppMethodBeat.i(54143);
        if (i == -1700) {
            f fVar = this.oHH;
            ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
            fVar.js(false);
            p.bSf().zf(1);
            fVar.oIP.setChecked(false);
        }
        AppMethodBeat.o(54143);
    }

    public final void bRg() {
        AppMethodBeat.i(54144);
        ab.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + p.bSf().oGf.size());
        if (p.bSf().bRH()) {
            if (p.bSf().oGf.size() > 0) {
                j.bRW();
                p.bSf().bRP();
            } else {
                p.bSf().bRQ();
            }
            f fVar = this.oHH;
            HashSet hashSet = new HashSet();
            hashSet.addAll(p.bSf().oGf);
            if (p.bSf().bRG()) {
                fVar.d(hashSet);
            }
        }
        AppMethodBeat.o(54144);
    }

    public final void jg(boolean z) {
        AppMethodBeat.i(54145);
        if (p.bSf().bRH()) {
            this.oHH.oIQ.setChecked(z);
        }
        AppMethodBeat.o(54145);
    }

    public final void jh(boolean z) {
        AppMethodBeat.i(54146);
        if (p.bSf().bRH()) {
            f fVar = this.oHH;
            fVar.oIR.setChecked(z);
            fVar.bSp();
        }
        AppMethodBeat.o(54146);
    }

    public final void eB(int i, int i2) {
        AppMethodBeat.i(54147);
        if (p.bSf().bRH()) {
            f fVar = this.oHH;
            RelativeLayout Sq = fVar.Sq(r.Yz());
            if (Sq != null) {
                f.a aVar = (f.a) Sq.getTag();
                if (!j.zg(i2)) {
                    if (j.zg(i)) {
                        fVar.oIP.setChecked(false);
                        aVar.oJe.bSr();
                        fVar.oIO.setVisibility(8);
                        if (fVar.oIZ.equals(r.Yz()) && fVar.oIJ.getVisibility() == 0) {
                            fVar.oIZ = "";
                            fVar.oII.setVisibility(0);
                            fVar.oIJ.setVisibility(8);
                        }
                    }
                    fVar.js(false);
                } else if (j.zg(i2) && !j.zg(i)) {
                    fVar.oIP.setChecked(true);
                    aVar.oJe.bSs();
                    aVar.oJh.setVisibility(8);
                    al.n(new f.b(aVar), 1500);
                    fVar.oIO.setVisibility(0);
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(p.bSf().oGf);
                if (j.zh(i2)) {
                    if (j.zh(i2) && !j.zh(i)) {
                        fVar.d(hashSet);
                    }
                } else if (j.zh(i)) {
                    fVar.bSn();
                    AppMethodBeat.o(54147);
                    return;
                }
            }
        }
        AppMethodBeat.o(54147);
    }

    public final void ji(boolean z) {
        AppMethodBeat.i(54148);
        if (p.bSf().bRH()) {
            f fVar = this.oHH;
            if (fVar.oIR != null) {
                fVar.oIR.setEnabled(z);
            }
        }
        AppMethodBeat.o(54148);
    }

    public final void a(String str, int[] iArr, int i, int i2, int i3) {
        AppMethodBeat.i(54149);
        if (p.bSf().bRH()) {
            this.oHH.a(str, iArr, i, i2, i3);
        }
        AppMethodBeat.o(54149);
    }

    public final void a(String str, Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(54150);
        this.oHH.a(str, bitmap, i, i2);
        AppMethodBeat.o(54150);
    }

    public final int Sg(String str) {
        AppMethodBeat.i(54151);
        RelativeLayout Sq = this.oHH.Sq(str);
        if (Sq == null) {
            AppMethodBeat.o(54151);
            return -1;
        }
        int position = ((f.a) Sq.getTag()).oJe.getPosition();
        AppMethodBeat.o(54151);
        return position;
    }

    public final void a(e eVar) {
        AppMethodBeat.i(54152);
        if (eVar == e.Talking) {
            f fVar = this.oHH;
            if (fVar.oJb > 0) {
                fVar.oJb = System.currentTimeMillis();
            }
        }
        AppMethodBeat.o(54152);
    }

    public final void a(j.a aVar) {
        AppMethodBeat.i(54153);
        if (aVar == j.a._4G) {
            p.bSd().R(this);
            AppMethodBeat.o(54153);
        } else if (aVar == j.a._3GOr_2G) {
            p.bSd().Q(this);
            AppMethodBeat.o(54153);
        } else {
            if (aVar == j.a.None) {
                com.tencent.mm.bg.e.a(this, R.string.f6c, null);
            }
            AppMethodBeat.o(54153);
        }
    }

    public final void bHa() {
        Iterator it;
        f.a aVar;
        AppMethodBeat.i(54154);
        f fVar = this.oHH;
        long j = (long) p.bSf().oGk;
        fVar.enf.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        com.tencent.mm.plugin.multitalk.model.f bSf = p.bSf();
        String str = bSf.oGh.Aqc;
        if (bo.isNullOrNil(str)) {
            str = bSf.oGh.Aqd;
        }
        List atK = p.bSe().oFP.atK(str);
        HashSet hashSet = p.bSf().oGf;
        if (atK != null) {
            it = fVar.oIU.iterator();
            while (it.hasNext()) {
                aVar = (f.a) ((RelativeLayout) it.next()).getTag();
                String username = aVar.oJe.getUsername();
                if ((r.Yz().equals(username) && fVar.bRh()) || !atK.contains(username) || hashSet.contains(username)) {
                    aVar.oJf.setVisibility(8);
                    ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", username);
                } else {
                    aVar.oJf.setVisibility(0);
                    ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", username);
                }
            }
        }
        bSf = p.bSf();
        str = bSf.oGh.Aqc;
        if (bo.isNullOrNil(str)) {
            str = bSf.oGh.Aqd;
        }
        if (n.oHu == null) {
            n.oHu = new n();
        }
        n nVar = n.oHu;
        ArrayList arrayList = new ArrayList();
        nVar.oHv = com.tencent.wecall.talkroom.model.c.dTg().auE(str);
        if (nVar.oHv != null) {
            for (av avVar : nVar.oHv.dTa()) {
                int i = avVar.kyZ;
                if (i >= 0) {
                    byte[] bArr = new byte[4];
                    if (p.bSe().oFP.setAppCmd(10, bArr, i) < 0) {
                        ab.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", Integer.valueOf(i));
                        i = -1;
                    } else {
                        i = bo.bf(bArr);
                        ab.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", Integer.valueOf(i));
                    }
                    if (i == -1 || i >= 5) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        arrayList.add(avVar.Aop);
                    }
                }
            }
        }
        Iterator it2 = fVar.oIU.iterator();
        while (it2.hasNext()) {
            aVar = (f.a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(aVar.oJe.getUsername())) {
                aVar.oJg.setVisibility(0);
            } else {
                aVar.oJg.setVisibility(8);
            }
        }
        AppMethodBeat.o(54154);
    }

    public final boolean bRh() {
        AppMethodBeat.i(54155);
        if (this.oHH != null) {
            boolean bRh = this.oHH.bRh();
            AppMethodBeat.o(54155);
            return bRh;
        }
        AppMethodBeat.o(54155);
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(54156);
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            ab.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i));
            AppMethodBeat.o(54156);
            return;
        }
        ab.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 22:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(54125);
                            MultiTalkMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(54125);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(54126);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(54126);
                        }
                    });
                    break;
                }
                ab.d("MicroMsg.MT.MultiTalkMainUI", "granted record camera!");
                AppMethodBeat.o(54156);
                return;
            case 82:
                if (iArr[0] == 0) {
                    ab.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    AppMethodBeat.o(54156);
                    return;
                }
                h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(54123);
                        MultiTalkMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        AppMethodBeat.o(54123);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(54124);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(54124);
                    }
                });
                AppMethodBeat.o(54156);
                return;
        }
        AppMethodBeat.o(54156);
    }

    public final ViewGroup bSl() {
        AppMethodBeat.i(54157);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.de_);
        AppMethodBeat.o(54157);
        return viewGroup;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
