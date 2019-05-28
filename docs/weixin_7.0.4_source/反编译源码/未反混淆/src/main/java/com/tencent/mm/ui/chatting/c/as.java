package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.az.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.u;

@a(dFp = aj.class)
public class as extends a implements f, aj {
    public boolean mfQ = false;
    private d svH = new d() {
        public final void p(String str, final long j) {
            AppMethodBeat.i(31866);
            ab.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + str + " time " + j);
            if (t.nw(aw.getNotification().IG())) {
                h.a(as.this.cgL.yTx.getContext(), false, str, as.this.cgL.yTx.getMMResources().getString(R.string.f34), as.this.cgL.yTx.getMMResources().getString(R.string.f31), as.this.cgL.yTx.getMMResources().getString(R.string.f33), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31865);
                        aw.ZK();
                        if (c.XO().X(aw.getNotification().IG(), j)) {
                            int dCP = ((com.tencent.mm.ui.chatting.c.b.h) as.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCP();
                            int count = ((com.tencent.mm.ui.chatting.c.b.h) as.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).getCount();
                            aw.ZK();
                            dCP = c.XO().e(aw.getNotification().IG(), j, dCP - count);
                            if (dCP < 0) {
                                AppMethodBeat.o(31865);
                                return;
                            } else if (count > dCP) {
                                as.this.cgL.Oq(dCP);
                            }
                        }
                        AppMethodBeat.o(31865);
                    }
                }, null);
            }
            AppMethodBeat.o(31866);
        }
    };
    private com.tencent.mm.ui.chatting.d yTf = null;
    private View yTg = null;
    public ChatFooter.d yTh = new ChatFooter.d() {
        public final void i(Boolean bool) {
            AppMethodBeat.i(31867);
            if (bool.booleanValue()) {
                if (as.this.yTg == null) {
                    as.this.yTg = ((ViewStub) as.this.cgL.findViewById(R.id.als)).inflate();
                }
                as.this.yTg.setVisibility(0);
                AppMethodBeat.o(31867);
                return;
            }
            if (as.this.yTg != null && as.this.yTg.getVisibility() == 0) {
                as.this.yTg.setVisibility(8);
            }
            AppMethodBeat.o(31867);
        }
    };

    public as() {
        AppMethodBeat.i(31868);
        AppMethodBeat.o(31868);
    }

    public final com.tencent.mm.ui.chatting.d dFm() {
        return this.yTf;
    }

    private boolean d(int i, KeyEvent keyEvent) {
        int i2 = 0;
        AppMethodBeat.i(31869);
        if (i == 25 && this.yTf != null && this.yTf.isPlaying() && (this.mfQ || !this.yTf.mfP)) {
            if (keyEvent.getAction() == 0) {
                if (aw.ZL().KP() && !aw.ZL().KV()) {
                    i2 = aw.ZL().Lc();
                }
                aw.ZL().iK(i2);
            }
            AppMethodBeat.o(31869);
            return true;
        } else if (i != 24 || this.yTf == null || !this.yTf.isPlaying() || (!this.mfQ && this.yTf.mfP)) {
            AppMethodBeat.o(31869);
            return false;
        } else {
            if (keyEvent.getAction() == 0) {
                if (aw.ZL().KP() && !aw.ZL().KV()) {
                    i2 = aw.ZL().Lc();
                }
                aw.ZL().iJ(i2);
            }
            AppMethodBeat.o(31869);
            return true;
        }
    }

    public final boolean DX() {
        AppMethodBeat.i(31870);
        boolean dDm = ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm();
        boolean dDn = ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn();
        int i = (this.cgL.dFw() || dDn) ? 1 : 0;
        if (dDm) {
            boolean lc;
            if (dDn) {
                lc = ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDk().lc(1);
                AppMethodBeat.o(31870);
                return lc;
            }
            lc = ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDl().lc(1);
            AppMethodBeat.o(31870);
            return lc;
        } else if ((i == 0 || this.cgL.sRl.dua != 0) && !this.cgL.sRl.DX()) {
            AppMethodBeat.o(31870);
            return false;
        } else {
            AppMethodBeat.o(31870);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dFn() {
        AppMethodBeat.i(31871);
        r rVar = (r) this.cgL.aF(r.class);
        if (((i) this.cgL.aF(i.class)).dDN()) {
            ab.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
            this.cgL.qv(false);
            rVar.setTitlePhoneIconVisibility(8);
            rVar.setTitleMuteIconVisibility(8);
            AppMethodBeat.o(31871);
            return;
        }
        Boolean bool;
        int i;
        if (((b) g.K(b.class)).Mp(this.cgL.getTalkerUserName())) {
            rVar.Nd(0);
        } else {
            rVar.Nd(8);
            if (DX()) {
                rVar.setTitleMuteIconVisibility(0);
                aw.ZK();
                bool = (Boolean) c.Ry().get(26, null);
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
                rVar.setTitlePhoneIconVisibility(i);
                AppMethodBeat.o(31871);
            }
        }
        rVar.setTitleMuteIconVisibility(8);
        aw.ZK();
        bool = (Boolean) c.Ry().get(26, null);
        if (bool != null) {
        }
        if (this.mfQ) {
        }
        rVar.setTitlePhoneIconVisibility(i);
        AppMethodBeat.o(31871);
    }

    public final void acquireWakeLock() {
        AppMethodBeat.i(31872);
        this.cgL.setKeepScreenOn(true);
        AppMethodBeat.o(31872);
    }

    public final void releaseWakeLock() {
        AppMethodBeat.i(31873);
        this.cgL.setKeepScreenOn(false);
        AppMethodBeat.o(31873);
    }

    public final boolean dFo() {
        return this.mfQ;
    }

    public final void qu(boolean z) {
        AppMethodBeat.i(31874);
        if (this.yTf == null) {
            ab.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
            AppMethodBeat.o(31874);
            return;
        }
        r rVar = (r) this.cgL.aF(r.class);
        if (z) {
            this.yTf.mfP = false;
            this.mfQ = true;
            aw.ZK();
            c.Ry().set(26, Boolean.TRUE);
            rVar.setTitlePhoneIconVisibility(0);
            Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.byh), 0).show();
            this.yTf.dBA();
            this.cgL.Na(R.raw.actionbar_ear_icon);
            AppMethodBeat.o(31874);
            return;
        }
        if (aw.ZL().KP()) {
            ab.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
        } else {
            this.yTf.mfP = true;
        }
        this.mfQ = false;
        aw.ZK();
        c.Ry().set(26, Boolean.FALSE);
        rVar.setTitlePhoneIconVisibility(8);
        Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.byi), 0).show();
        this.yTf.dBA();
        this.cgL.Na(R.raw.actionbar_loud_icon);
        AppMethodBeat.o(31874);
    }

    public final boolean bn(bi biVar) {
        AppMethodBeat.i(31875);
        if (biVar.drD()) {
            if (biVar.field_msgId == this.yTf.yGO) {
                this.yTf.dBB();
            }
            AppMethodBeat.o(31875);
            return true;
        }
        AppMethodBeat.o(31875);
        return false;
    }

    public final boolean bo(bi biVar) {
        AppMethodBeat.i(31876);
        if (biVar.drD()) {
            aw.ZK();
            if (c.isSDCardAvailable()) {
                if (biVar.field_msgId == this.yTf.yGO) {
                    this.yTf.dBB();
                }
                if (!this.cgL.getTalkerUserName().equals("medianote")) {
                    aw.ZK();
                    c.XL().c(new e(biVar.field_talker, biVar.field_msgSvrId));
                }
                ak.aQ(biVar);
                AppMethodBeat.o(31876);
                return true;
            }
            com.tencent.mm.ui.base.t.hO(this.cgL.yTx.getContext());
            AppMethodBeat.o(31876);
            return true;
        }
        AppMethodBeat.o(31876);
        return false;
    }

    @TargetApi(9)
    public final void a(MMFragment mMFragment, boolean z) {
        AppMethodBeat.i(31877);
        if (mMFragment.getLandscapeMode()) {
            if (!z) {
                mMFragment.setRequestedOrientation(-1);
            } else if (VERSION.SDK_INT >= 9) {
                ab.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", Integer.valueOf(mMFragment.getWindowManager().getDefaultDisplay().getOrientation()));
                switch (mMFragment.getWindowManager().getDefaultDisplay().getOrientation()) {
                    case 0:
                        mMFragment.setRequestedOrientation(1);
                        AppMethodBeat.o(31877);
                        return;
                    case 1:
                        mMFragment.setRequestedOrientation(0);
                        AppMethodBeat.o(31877);
                        return;
                    case 2:
                        mMFragment.setRequestedOrientation(9);
                        AppMethodBeat.o(31877);
                        return;
                    case 3:
                        mMFragment.setRequestedOrientation(8);
                        AppMethodBeat.o(31877);
                        return;
                    default:
                        AppMethodBeat.o(31877);
                        return;
                }
            } else if (this.cgL.yTx.getMMResources().getConfiguration().orientation == 2) {
                mMFragment.setRequestedOrientation(0);
                AppMethodBeat.o(31877);
                return;
            } else if (this.cgL.yTx.getMMResources().getConfiguration().orientation == 1) {
                mMFragment.setRequestedOrientation(1);
                AppMethodBeat.o(31877);
                return;
            }
        }
        AppMethodBeat.o(31877);
    }

    public final void dDh() {
        AppMethodBeat.i(31878);
        super.dDh();
        com.tencent.mm.modelvoice.r.b(this.yTf);
        com.tencent.mm.modelvoice.e.b(this.yTf);
        aw.Rg().b((int) com.tencent.view.d.MIC_SketchMark, (f) this);
        releaseWakeLock();
        if (this.yTf != null) {
            this.yTf.dBw();
            com.tencent.mm.ui.chatting.d dVar = this.yTf;
            dVar.release();
            dVar.context = null;
            dVar.yGU = false;
            com.tencent.mm.sdk.b.a.xxA.d(dVar.yGZ);
            aw.Cc().b(dVar);
        }
        AppMethodBeat.o(31878);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(31879);
        boolean d = d(i, keyEvent);
        AppMethodBeat.o(31879);
        return d;
    }

    public final void dxy() {
        AppMethodBeat.i(31880);
        dFn();
        AppMethodBeat.o(31880);
    }

    public final void dxz() {
        AppMethodBeat.i(31881);
        aw.Rg().a((int) com.tencent.view.d.MIC_SketchMark, (f) this);
        AppMethodBeat.o(31881);
    }

    public final void dxC() {
        AppMethodBeat.i(31884);
        aw.Rg().b((int) com.tencent.view.d.MIC_SketchMark, (f) this);
        AppMethodBeat.o(31884);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(31885);
        ab.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + mVar.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(31885);
        } else if (bo.cv(this.cgL.yTx.getContext())) {
            Activity context = this.cgL.yTx.getContext();
            if (!(u.a.a(context, i, i2, str, 7) || u.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str))) {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(31885);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case com.tencent.view.d.MIC_SketchMark /*127*/:
                        p uW = q.uW(((com.tencent.mm.modelvoice.f) mVar).fileName);
                        if (uW != null && uW.status == 99) {
                            ay.au(this.cgL.yTx.getContext(), R.string.f6);
                            break;
                        }
                }
            }
            AppMethodBeat.o(31885);
        } else {
            AppMethodBeat.o(31885);
        }
    }

    public final void dxA() {
        AppMethodBeat.i(31882);
        ab.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", this.yTf, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
        if (this.yTf == null) {
            this.yTf = new com.tencent.mm.ui.chatting.d(this.cgL, this, this.cgL.getTalkerUserName());
            com.tencent.mm.modelvoice.r.c(this.yTf);
            com.tencent.mm.modelvoice.e.a(this.yTf);
        } else {
            this.yTf.aqZ(this.cgL.getTalkerUserName());
        }
        aw.ZK();
        boolean a = bo.a((Boolean) c.Ry().get(16387, null), true);
        com.tencent.mm.ui.chatting.d dVar = this.yTf;
        if (!dVar.yGU) {
            dVar.yGS = a;
            dVar.dBw();
        }
        com.tencent.mm.aj.d dDj = ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDj();
        if (dDj != null) {
            com.tencent.mm.aj.d.b cJ = dDj.cJ(false);
            if (cJ != null) {
                if (cJ.fvc != null) {
                    cJ.fvr = cJ.fvc.optInt("AudioPlayType", 0) == 1;
                }
                if (cJ.fvr) {
                    this.yTf.yGT = false;
                }
            }
        }
        dVar = this.yTf;
        if (this.mfQ) {
            a = false;
        } else {
            a = true;
        }
        dVar.mfP = a;
        this.yTf.qn(true);
        ab.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (t.nw(this.cgL.getTalkerUserName()) && ao.a.flx != null) {
            ao.a.flx.a(this.svH);
        }
        if (!com.tencent.mm.au.b.ahK()) {
            ((o) this.cgL.aF(o.class)).setVoiceInputShowCallback(this.yTh);
        }
        dFn();
        AppMethodBeat.o(31882);
    }

    public final void dxB() {
        AppMethodBeat.i(31883);
        if (t.nw(this.cgL.getTalkerUserName()) && ao.a.flx != null) {
            ao.a.flx.b(this.svH);
        }
        if (this.yTg != null && this.yTg.getVisibility() == 0) {
            ab.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
            this.yTg.setVisibility(8);
        }
        ((o) this.cgL.aF(o.class)).setVoiceInputShowCallback(null);
        aw.ZK();
        c.Ry().set(26, Boolean.valueOf(this.mfQ));
        if (!(com.tencent.mm.ui.q.dyk() || this.yTf == null)) {
            this.yTf.dBw();
            this.yTf.dBB();
            this.yTf.release();
        }
        if (!(!aw.ZL().KP() || com.tencent.mm.plugin.voip.e.cIm() || com.tencent.mm.r.a.Oo())) {
            aw.ZL().KN();
        }
        AppMethodBeat.o(31883);
    }
}
