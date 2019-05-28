package com.tencent.p177mm.p612ui.chatting.p616c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C18609d;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C37964e;
import com.tencent.p177mm.modelvoice.C45461f;
import com.tencent.p177mm.modelvoice.C9744r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p201az.C32325e;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.C36866d;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.voip.C14034e;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35867d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.view.C31128d;

@C15590a(dFp = C15611aj.class)
/* renamed from: com.tencent.mm.ui.chatting.c.as */
public class C44809as extends C44291a implements C1202f, C15611aj {
    public boolean mfQ = false;
    private C18609d svH = new C361321();
    private C36866d yTf = null;
    private View yTg = null;
    public C35867d yTh = new C368652();

    /* renamed from: com.tencent.mm.ui.chatting.c.as$1 */
    class C361321 implements C18609d {
        C361321() {
        }

        /* renamed from: p */
        public final void mo33872p(String str, final long j) {
            AppMethodBeat.m2504i(31866);
            C4990ab.m7410d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + str + " time " + j);
            if (C1855t.m3954nw(C9638aw.getNotification().mo41567IG())) {
                C30379h.m48453a(C44809as.this.cgL.yTx.getContext(), false, str, C44809as.this.cgL.yTx.getMMResources().getString(C25738R.string.f34), C44809as.this.cgL.yTx.getMMResources().getString(C25738R.string.f31), C44809as.this.cgL.yTx.getMMResources().getString(C25738R.string.f33), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(31865);
                        C9638aw.m17190ZK();
                        if (C18628c.m29080XO().mo15278X(C9638aw.getNotification().mo41567IG(), j)) {
                            int dCP = ((C15612h) C44809as.this.cgL.mo74857aF(C15612h.class)).dCP();
                            int count = ((C15612h) C44809as.this.cgL.mo74857aF(C15612h.class)).getCount();
                            C9638aw.m17190ZK();
                            dCP = C18628c.m29080XO().mo15329e(C9638aw.getNotification().mo41567IG(), j, dCP - count);
                            if (dCP < 0) {
                                AppMethodBeat.m2505o(31865);
                                return;
                            } else if (count > dCP) {
                                C44809as.this.cgL.mo74853Oq(dCP);
                            }
                        }
                        AppMethodBeat.m2505o(31865);
                    }
                }, null);
            }
            AppMethodBeat.m2505o(31866);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.as$2 */
    class C368652 implements C35867d {
        C368652() {
        }

        /* renamed from: i */
        public final void mo56658i(Boolean bool) {
            AppMethodBeat.m2504i(31867);
            if (bool.booleanValue()) {
                if (C44809as.this.yTg == null) {
                    C44809as.this.yTg = ((ViewStub) C44809as.this.cgL.findViewById(2131822387)).inflate();
                }
                C44809as.this.yTg.setVisibility(0);
                AppMethodBeat.m2505o(31867);
                return;
            }
            if (C44809as.this.yTg != null && C44809as.this.yTg.getVisibility() == 0) {
                C44809as.this.yTg.setVisibility(8);
            }
            AppMethodBeat.m2505o(31867);
        }
    }

    public C44809as() {
        AppMethodBeat.m2504i(31868);
        AppMethodBeat.m2505o(31868);
    }

    public final C36866d dFm() {
        return this.yTf;
    }

    /* renamed from: d */
    private boolean m81932d(int i, KeyEvent keyEvent) {
        int i2 = 0;
        AppMethodBeat.m2504i(31869);
        if (i == 25 && this.yTf != null && this.yTf.isPlaying() && (this.mfQ || !this.yTf.mfP)) {
            if (keyEvent.getAction() == 0) {
                if (C9638aw.m17191ZL().mo4819KP() && !C9638aw.m17191ZL().mo4822KV()) {
                    i2 = C9638aw.m17191ZL().mo4827Lc();
                }
                C9638aw.m17191ZL().mo4839iK(i2);
            }
            AppMethodBeat.m2505o(31869);
            return true;
        } else if (i != 24 || this.yTf == null || !this.yTf.isPlaying() || (!this.mfQ && this.yTf.mfP)) {
            AppMethodBeat.m2505o(31869);
            return false;
        } else {
            if (keyEvent.getAction() == 0) {
                if (C9638aw.m17191ZL().mo4819KP() && !C9638aw.m17191ZL().mo4822KV()) {
                    i2 = C9638aw.m17191ZL().mo4827Lc();
                }
                C9638aw.m17191ZL().mo4838iJ(i2);
            }
            AppMethodBeat.m2505o(31869);
            return true;
        }
    }

    /* renamed from: DX */
    public final boolean mo27789DX() {
        AppMethodBeat.m2504i(31870);
        boolean dDm = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm();
        boolean dDn = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn();
        int i = (this.cgL.dFw() || dDn) ? 1 : 0;
        if (dDm) {
            boolean lc;
            if (dDn) {
                lc = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDk().mo73052lc(1);
                AppMethodBeat.m2505o(31870);
                return lc;
            }
            lc = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDl().mo73056lc(1);
            AppMethodBeat.m2505o(31870);
            return lc;
        } else if ((i == 0 || this.cgL.sRl.dua != 0) && !this.cgL.sRl.mo16673DX()) {
            AppMethodBeat.m2505o(31870);
            return false;
        } else {
            AppMethodBeat.m2505o(31870);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dFn() {
        AppMethodBeat.m2504i(31871);
        C44299r c44299r = (C44299r) this.cgL.mo74857aF(C44299r.class);
        if (((C15613i) this.cgL.mo74857aF(C15613i.class)).dDN()) {
            C4990ab.m7410d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
            this.cgL.mo74883qv(false);
            c44299r.setTitlePhoneIconVisibility(8);
            c44299r.setTitleMuteIconVisibility(8);
            AppMethodBeat.m2505o(31871);
            return;
        }
        Boolean bool;
        int i;
        if (((C20772b) C1720g.m3528K(C20772b.class)).mo36068Mp(this.cgL.getTalkerUserName())) {
            c44299r.mo64256Nd(0);
        } else {
            c44299r.mo64256Nd(8);
            if (mo27789DX()) {
                c44299r.setTitleMuteIconVisibility(0);
                C9638aw.m17190ZK();
                bool = (Boolean) C18628c.m29072Ry().get(26, null);
                if (bool != null) {
                    this.mfQ = false;
                } else {
                    this.mfQ = bool.booleanValue();
                }
                if (this.mfQ) {
                    i = 8;
                } else {
                    i = 0;
                }
                c44299r.setTitlePhoneIconVisibility(i);
                AppMethodBeat.m2505o(31871);
            }
        }
        c44299r.setTitleMuteIconVisibility(8);
        C9638aw.m17190ZK();
        bool = (Boolean) C18628c.m29072Ry().get(26, null);
        if (bool != null) {
        }
        if (this.mfQ) {
        }
        c44299r.setTitlePhoneIconVisibility(i);
        AppMethodBeat.m2505o(31871);
    }

    public final void acquireWakeLock() {
        AppMethodBeat.m2504i(31872);
        this.cgL.setKeepScreenOn(true);
        AppMethodBeat.m2505o(31872);
    }

    public final void releaseWakeLock() {
        AppMethodBeat.m2504i(31873);
        this.cgL.setKeepScreenOn(false);
        AppMethodBeat.m2505o(31873);
    }

    public final boolean dFo() {
        return this.mfQ;
    }

    /* renamed from: qu */
    public final void mo27796qu(boolean z) {
        AppMethodBeat.m2504i(31874);
        if (this.yTf == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
            AppMethodBeat.m2505o(31874);
            return;
        }
        C44299r c44299r = (C44299r) this.cgL.mo74857aF(C44299r.class);
        if (z) {
            this.yTf.mfP = false;
            this.mfQ = true;
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(26, Boolean.TRUE);
            c44299r.setTitlePhoneIconVisibility(0);
            Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.byh), 0).show();
            this.yTf.dBA();
            this.cgL.mo74852Na(C1318a.actionbar_ear_icon);
            AppMethodBeat.m2505o(31874);
            return;
        }
        if (C9638aw.m17191ZL().mo4819KP()) {
            C4990ab.m7416i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
        } else {
            this.yTf.mfP = true;
        }
        this.mfQ = false;
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(26, Boolean.FALSE);
        c44299r.setTitlePhoneIconVisibility(8);
        Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.byi), 0).show();
        this.yTf.dBA();
        this.cgL.mo74852Na(C1318a.actionbar_loud_icon);
        AppMethodBeat.m2505o(31874);
    }

    /* renamed from: bn */
    public final boolean mo27791bn(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31875);
        if (c7620bi.drD()) {
            if (c7620bi.field_msgId == this.yTf.yGO) {
                this.yTf.dBB();
            }
            AppMethodBeat.m2505o(31875);
            return true;
        }
        AppMethodBeat.m2505o(31875);
        return false;
    }

    /* renamed from: bo */
    public final boolean mo27792bo(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31876);
        if (c7620bi.drD()) {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                if (c7620bi.field_msgId == this.yTf.yGO) {
                    this.yTf.dBB();
                }
                if (!this.cgL.getTalkerUserName().equals("medianote")) {
                    C9638aw.m17190ZK();
                    C18628c.m29077XL().mo7920c(new C32325e(c7620bi.field_talker, c7620bi.field_msgSvrId));
                }
                C36121ak.m59475aQ(c7620bi);
                AppMethodBeat.m2505o(31876);
                return true;
            }
            C23639t.m36492hO(this.cgL.yTx.getContext());
            AppMethodBeat.m2505o(31876);
            return true;
        }
        AppMethodBeat.m2505o(31876);
        return false;
    }

    @TargetApi(9)
    /* renamed from: a */
    public final void mo27790a(MMFragment mMFragment, boolean z) {
        AppMethodBeat.m2504i(31877);
        if (mMFragment.getLandscapeMode()) {
            if (!z) {
                mMFragment.setRequestedOrientation(-1);
            } else if (VERSION.SDK_INT >= 9) {
                C4990ab.m7417i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", Integer.valueOf(mMFragment.getWindowManager().getDefaultDisplay().getOrientation()));
                switch (mMFragment.getWindowManager().getDefaultDisplay().getOrientation()) {
                    case 0:
                        mMFragment.setRequestedOrientation(1);
                        AppMethodBeat.m2505o(31877);
                        return;
                    case 1:
                        mMFragment.setRequestedOrientation(0);
                        AppMethodBeat.m2505o(31877);
                        return;
                    case 2:
                        mMFragment.setRequestedOrientation(9);
                        AppMethodBeat.m2505o(31877);
                        return;
                    case 3:
                        mMFragment.setRequestedOrientation(8);
                        AppMethodBeat.m2505o(31877);
                        return;
                    default:
                        AppMethodBeat.m2505o(31877);
                        return;
                }
            } else if (this.cgL.yTx.getMMResources().getConfiguration().orientation == 2) {
                mMFragment.setRequestedOrientation(0);
                AppMethodBeat.m2505o(31877);
                return;
            } else if (this.cgL.yTx.getMMResources().getConfiguration().orientation == 1) {
                mMFragment.setRequestedOrientation(1);
                AppMethodBeat.m2505o(31877);
                return;
            }
        }
        AppMethodBeat.m2505o(31877);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31878);
        super.dDh();
        C9744r.m17382b(this.yTf);
        C37964e.m64233b(this.yTf);
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_SketchMark, (C1202f) this);
        releaseWakeLock();
        if (this.yTf != null) {
            this.yTf.dBw();
            C36866d c36866d = this.yTf;
            c36866d.release();
            c36866d.context = null;
            c36866d.yGU = false;
            C4879a.xxA.mo10053d(c36866d.yGZ);
            C9638aw.m17176Cc().mo4651b(c36866d);
        }
        AppMethodBeat.m2505o(31878);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(31879);
        boolean d = m81932d(i, keyEvent);
        AppMethodBeat.m2505o(31879);
        return d;
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31880);
        dFn();
        AppMethodBeat.m2505o(31880);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31881);
        C9638aw.m17182Rg().mo14539a((int) C31128d.MIC_SketchMark, (C1202f) this);
        AppMethodBeat.m2505o(31881);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31884);
        C9638aw.m17182Rg().mo14546b((int) C31128d.MIC_SketchMark, (C1202f) this);
        AppMethodBeat.m2505o(31884);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(31885);
        C4990ab.m7416i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + c1207m.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.m2505o(31885);
        } else if (C5046bo.m7544cv(this.cgL.yTx.getContext())) {
            Activity context = this.cgL.yTx.getContext();
            if (!(C30784a.m49123a(context, i, i2, str, 7) || C30777u.m49118a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str))) {
                z = false;
            }
            if (z) {
                AppMethodBeat.m2505o(31885);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case C31128d.MIC_SketchMark /*127*/:
                        C32849p uW = C32850q.m53736uW(((C45461f) c1207m).fileName);
                        if (uW != null && uW.status == 99) {
                            C35988ay.m59201au(this.cgL.yTx.getContext(), C25738R.string.f8793f6);
                            break;
                        }
                }
            }
            AppMethodBeat.m2505o(31885);
        } else {
            AppMethodBeat.m2505o(31885);
        }
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31882);
        C4990ab.m7417i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", this.yTf, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
        if (this.yTf == null) {
            this.yTf = new C36866d(this.cgL, this, this.cgL.getTalkerUserName());
            C9744r.m17383c(this.yTf);
            C37964e.m64231a(this.yTf);
        } else {
            this.yTf.aqZ(this.cgL.getTalkerUserName());
        }
        C9638aw.m17190ZK();
        boolean a = C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(16387, null), true);
        C36866d c36866d = this.yTf;
        if (!c36866d.yGU) {
            c36866d.yGS = a;
            c36866d.dBw();
        }
        C16527d dDj = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDj();
        if (dDj != null) {
            C16529b cJ = dDj.mo30481cJ(false);
            if (cJ != null) {
                if (cJ.fvc != null) {
                    cJ.fvr = cJ.fvc.optInt("AudioPlayType", 0) == 1;
                }
                if (cJ.fvr) {
                    this.yTf.yGT = false;
                }
            }
        }
        c36866d = this.yTf;
        if (this.mfQ) {
            a = false;
        } else {
            a = true;
        }
        c36866d.mfP = a;
        this.yTf.mo58735qn(true);
        C4990ab.m7417i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (C1855t.m3954nw(this.cgL.getTalkerUserName()) && C26417a.flx != null) {
            C26417a.flx.mo44186a(this.svH);
        }
        if (!C17950b.ahK()) {
            ((C15614o) this.cgL.mo74857aF(C15614o.class)).setVoiceInputShowCallback(this.yTh);
        }
        dFn();
        AppMethodBeat.m2505o(31882);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31883);
        if (C1855t.m3954nw(this.cgL.getTalkerUserName()) && C26417a.flx != null) {
            C26417a.flx.mo44187b(this.svH);
        }
        if (this.yTg != null && this.yTg.getVisibility() == 0) {
            C4990ab.m7416i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
            this.yTg.setVisibility(8);
        }
        ((C15614o) this.cgL.mo74857aF(C15614o.class)).setVoiceInputShowCallback(null);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(26, Boolean.valueOf(this.mfQ));
        if (!(C5536q.dyk() || this.yTf == null)) {
            this.yTf.dBw();
            this.yTf.dBB();
            this.yTf.release();
        }
        if (!(!C9638aw.m17191ZL().mo4819KP() || C14034e.cIm() || C35973a.m59176Oo())) {
            C9638aw.m17191ZL().mo4818KN();
        }
        AppMethodBeat.m2505o(31883);
    }
}
