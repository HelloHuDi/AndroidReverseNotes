package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;
import java.io.IOException;
import java.util.LinkedList;

public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, a {
    public MMFragmentActivity iWA;
    private int mDuration;
    private boolean mIsPause;
    private boolean mIsPlaying;
    public View ofJ;
    private boolean qAA;
    public String qAB;
    private boolean qAC;
    public String qAD;
    public float qAE;
    private b qAF;
    private boolean qAG;
    private boolean qAH;
    private c qAI;
    private boolean qAJ;
    private MediaPlayer qAK;
    public MainSightSelectContactView qAt;
    public SightCameraView qAu;
    private b qAv;
    public View qAw;
    public View qAx;
    public View qAy;
    private Dialog qAz;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25043);
        this.qAz = null;
        this.mIsPlaying = false;
        this.qAA = true;
        this.qAB = "";
        this.qAC = false;
        this.qAD = "";
        this.mDuration = 1;
        this.qAE = 1.0f;
        this.mIsPause = false;
        this.qAF = new b();
        this.qAG = false;
        this.qAH = false;
        this.qAI = new c<qt>() {
            {
                AppMethodBeat.i(25039);
                this.xxI = qt.class.getName().hashCode();
                AppMethodBeat.o(25039);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(25040);
                qt qtVar = (qt) bVar;
                String str = "MicroMsg.MainSightContainerView";
                String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = Integer.valueOf(qtVar.cMT.type);
                objArr[2] = Boolean.valueOf(MainSightForwardContainerView.this.qAz != null);
                objArr[3] = Boolean.valueOf(MainSightForwardContainerView.this.qAJ);
                ab.i(str, str2, objArr);
                switch (qtVar.cMT.type) {
                    case 0:
                        MainSightForwardContainerView.this.qAH = false;
                        if (!MainSightForwardContainerView.this.qAJ) {
                            if (!qtVar.cMT.cMV) {
                                MainSightForwardContainerView.this.postDelayed(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(25038);
                                        MainSightForwardContainerView.this.clE();
                                        AppMethodBeat.o(25038);
                                    }
                                }, 500);
                                break;
                            }
                            h.pYm.e(11443, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0));
                            MainSightForwardContainerView.this.kE(true);
                            break;
                        }
                        if (qtVar.cMT.cMV) {
                            h.pYm.e(11443, Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0));
                        }
                        MainSightForwardContainerView.this.removeListener();
                        break;
                }
                AppMethodBeat.o(25040);
                return false;
            }
        };
        this.qAJ = false;
        AppMethodBeat.o(25043);
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void removeListener() {
        AppMethodBeat.i(25044);
        a.xxA.d(this.qAI);
        AppMethodBeat.o(25044);
    }

    public final void clE() {
        boolean z = true;
        AppMethodBeat.i(25045);
        ab.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", this.qAD, Boolean.valueOf(this.qAA), Boolean.valueOf(this.mIsPlaying));
        if (!this.qAu.isPlaying()) {
            this.qAA = true;
        }
        this.qAu.bg(this.qAD, this.qAA);
        if (this.qAA) {
            kF(true);
        } else {
            kF(false);
        }
        this.mIsPlaying = true;
        if (this.qAA) {
            z = false;
        }
        this.qAA = z;
        AppMethodBeat.o(25045);
    }

    public final boolean DX() {
        return !this.qAA;
    }

    public void setIsMute(boolean z) {
        AppMethodBeat.i(25046);
        if (this.qAu == null) {
            AppMethodBeat.o(25046);
            return;
        }
        this.qAu.setIsMute(z);
        AppMethodBeat.o(25046);
    }

    public final void kE(boolean z) {
        AppMethodBeat.i(25047);
        if (this.qAC) {
            AppMethodBeat.o(25047);
            return;
        }
        this.qAC = true;
        bo.hideVKB(this);
        this.mIsPlaying = false;
        this.qAA = true;
        ab.d("MicroMsg.MainSightContainerView", "dismiss sight view");
        this.qAH = false;
        this.qAu.clS();
        if (this.qAv != null && z) {
            this.qAv.clG();
        }
        if (this.qAt != null) {
            MainSightSelectContactView mainSightSelectContactView = this.qAt;
            mainSightSelectContactView.qAC = true;
            bo.hideVKB(mainSightSelectContactView);
            mainSightSelectContactView.qBg.clN();
            mainSightSelectContactView.qBq.clear();
            mainSightSelectContactView.qBp.clear();
            mainSightSelectContactView.mListView.setAdapter(null);
            mainSightSelectContactView.mListView.clearAnimation();
            mainSightSelectContactView.setVisibility(8);
        }
        setCameraShadowAlpha(0.85f);
        clF();
        kF(false);
        this.qAB = "";
        removeListener();
        AppMethodBeat.o(25047);
    }

    public final void kF(boolean z) {
        AppMethodBeat.i(25048);
        if (this.qAG == z) {
            AppMethodBeat.o(25048);
            return;
        }
        this.qAG = z;
        if (!z) {
            this.qAx.setVisibility(8);
            this.ofJ.setVisibility(8);
            AppMethodBeat.o(25048);
        } else if (this.qAx.getVisibility() == 0) {
            AppMethodBeat.o(25048);
        } else {
            this.qAu.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25037);
                    if (!MainSightForwardContainerView.this.qAG || (MainSightForwardContainerView.this.qAt != null && MainSightForwardContainerView.this.qAt.qBg.clK())) {
                        MainSightForwardContainerView.this.qAG = false;
                        AppMethodBeat.o(25037);
                        return;
                    }
                    MainSightForwardContainerView.this.qAx.setVisibility(0);
                    if (!(MainSightForwardContainerView.this.qAt == null || MainSightForwardContainerView.this.qAt.clR() || MainSightForwardContainerView.this.ofJ.getVisibility() == 0)) {
                        MainSightForwardContainerView.this.ofJ.setVisibility(0);
                        MainSightForwardContainerView.this.ofJ.startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.this.iWA, R.anim.b5));
                    }
                    AppMethodBeat.o(25037);
                }
            }, 100);
            AppMethodBeat.o(25048);
        }
    }

    public void setIMainSightViewCallback(b bVar) {
        this.qAv = bVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(25049);
        int i2 = i - 1;
        if (MainSightSelectContactView.CH(i2) && this.mIsPlaying) {
            clE();
            AppMethodBeat.o(25049);
        } else if (c.WU(this.qAt.mW(i2))) {
            this.qAt.qBg.clL();
            AppMethodBeat.o(25049);
        } else if (c.WT(this.qAt.mW(i2))) {
            if (c.qAQ) {
                this.qAH = true;
                this.qAu.clS();
                Context context = this.iWA;
                String WO = d.WO(this.qAD);
                String str = this.qAD;
                String str2 = this.qAB;
                ab.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", str, WO);
                if (!e.ct(WO)) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(d.ag(str, 320, 240), 60, CompressFormat.JPEG, WO, true);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                        ab.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("KSightPath", str);
                intent.putExtra("KSightThumbPath", WO);
                intent.putExtra("sight_md5", str2);
                intent.putExtra("KSightDraftEntrance", false);
                intent.putExtra("Ksnsupload_source", 0);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bo.anT());
                com.tencent.mm.bp.d.b(context, "sns", ".ui.SightUploadUI", intent, 5985);
                if (this.qAJ) {
                    h.pYm.e(11442, Integer.valueOf(3), Integer.valueOf(3));
                    AppMethodBeat.o(25049);
                    return;
                }
                h.pYm.e(11442, Integer.valueOf(1), Integer.valueOf(3));
            }
            AppMethodBeat.o(25049);
        } else {
            ab.d("MicroMsg.MainSightContainerView", "on item click Item : %d", Integer.valueOf(i2));
            MainSightSelectContactView mainSightSelectContactView = this.qAt;
            if (i2 >= 0 && i2 <= mainSightSelectContactView.qBi.getCount()) {
                com.tencent.mm.ui.contact.a.a Pn = mainSightSelectContactView.qBi.getItem(i2);
                if (Pn != null) {
                    if (mainSightSelectContactView.qBq.contains(Pn.ehM.field_username)) {
                        mainSightSelectContactView.qBq.remove(Pn.ehM.field_username);
                    } else {
                        mainSightSelectContactView.qBq.add(Pn.ehM.field_username);
                    }
                    c.qAQ = mainSightSelectContactView.qBq.isEmpty();
                    c.qAR = !mainSightSelectContactView.qBq.isEmpty();
                }
            }
            mainSightSelectContactView = this.qAt;
            if (mainSightSelectContactView.qBi != null) {
                mainSightSelectContactView.qBi.notifyDataSetChanged();
            }
            if (!DX()) {
                clE();
            } else if (this.qAt.clR()) {
                if (this.ofJ.getVisibility() == 0) {
                    this.ofJ.setVisibility(8);
                    this.ofJ.startAnimation(AnimationUtils.loadAnimation(this.iWA, R.anim.b6));
                }
            } else if (this.ofJ.getVisibility() != 0) {
                this.ofJ.setVisibility(0);
                this.ofJ.startAnimation(AnimationUtils.loadAnimation(this.iWA, R.anim.b5));
            }
            if (this.qAt.qBg.clK()) {
                boolean z;
                mainSightSelectContactView = this.qAt;
                if (mainSightSelectContactView.qBi.getItem(i2) == null) {
                    z = false;
                } else if (mainSightSelectContactView.qBi.getItem(i2).ehM == null) {
                    z = false;
                } else {
                    z = mainSightSelectContactView.qBq.contains(mainSightSelectContactView.qBi.getItem(i2).ehM.field_username);
                }
                if (z) {
                    this.qAt.qBg.clL();
                }
            }
            AppMethodBeat.o(25049);
        }
    }

    public final void clH() {
        AppMethodBeat.i(25050);
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.qAz == null);
        ab.i(str, str2, objArr);
        if (bo.isNullOrNil(this.qAD) || this.qAt.clR()) {
            AppMethodBeat.o(25050);
            return;
        }
        String str3;
        boolean z;
        final LinkedList<String> selectedContact = this.qAt.getSelectedContact();
        h.pYm.e(11443, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(selectedContact.size()));
        AnonymousClass6 anonymousClass6 = new b.a() {
            public final void onError(int i) {
                AppMethodBeat.i(25041);
                if (selectedContact.size() <= 1 || -1 == i) {
                    com.tencent.mm.ui.base.h.bQ(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(R.string.e3n));
                }
                AppMethodBeat.o(25041);
            }
        };
        if (selectedContact.size() == 1) {
            b bVar = this.qAF;
            String str4 = this.qAD;
            int i = this.mDuration;
            str3 = this.qAB;
            str2 = (String) selectedContact.get(0);
            if (bo.isNullOrNil(str4)) {
                ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                b.a(anonymousClass6, -1);
            } else if (bo.isNullOrNil(str2)) {
                ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                b.a(anonymousClass6, -1);
            } else if (!e.ct(str4) || e.cs(str4) <= 0) {
                ab.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                com.tencent.mm.ui.base.h.bQ(ah.getContext(), ah.getContext().getString(R.string.ehc));
            } else {
                ab.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str3, g.cz(str4));
                if (bo.bc(str3, "").equals(g.cz(str4))) {
                    com.tencent.mm.kernel.g.RQ();
                    if (com.tencent.mm.kernel.g.RS().aa(new com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass3(str2, anonymousClass6, str4, i)) < 0) {
                        ab.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                        b.a(anonymousClass6, -1);
                    }
                } else {
                    ab.e("MicroMsg.SightRecorderHelper", "error md5, return");
                    b.a(anonymousClass6, -1);
                }
            }
        } else {
            b bVar2 = this.qAF;
            String str5 = this.qAD;
            int i2 = this.mDuration;
            String str6 = this.qAB;
            if (bo.isNullOrNil(str5)) {
                ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                b.a(anonymousClass6, -1);
            } else if (selectedContact == null || selectedContact.isEmpty()) {
                ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                b.a(anonymousClass6, -1);
            } else if (!e.ct(str5) || e.cs(str5) <= 0) {
                ab.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                com.tencent.mm.ui.base.h.bQ(ah.getContext(), ah.getContext().getString(R.string.ehc));
            } else {
                ab.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str6, g.cz(str5));
                if (bo.bc(str6, "").equals(g.cz(str5))) {
                    com.tencent.mm.kernel.g.RQ();
                    if (com.tencent.mm.kernel.g.RS().aa(new com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass4(str5, selectedContact, str6, anonymousClass6, i2)) < 0) {
                        ab.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                        b.a(anonymousClass6, -1);
                    }
                } else {
                    ab.e("MicroMsg.SightRecorderHelper", "error md5, return");
                    b.a(anonymousClass6, -1);
                }
            }
        }
        if (this.qAt.getSelectedContact().size() > 1 || this.qAv == null) {
            z = true;
        } else {
            this.qAv.startChattingUI((String) this.qAt.getSelectedContact().get(0));
            z = false;
        }
        if (this.iWA != null) {
            try {
                AssetFileDescriptor openFd = this.iWA.getAssets().openFd("sight_send_song.wav");
                this.qAK = new k();
                this.qAK.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                this.qAK.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(25042);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.o(25042);
                    }
                });
                this.qAK.setLooping(false);
                this.qAK.prepare();
                this.qAK.start();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.MainSightContainerView", e, "", new Object[0]);
            }
        }
        kE(z);
        for (String str32 : selectedContact) {
            if (str32.toLowerCase().endsWith("@chatroom")) {
                h.pYm.e(11442, Integer.valueOf(1), Integer.valueOf(2));
            } else {
                h.pYm.e(11442, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(25050);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(25053);
        super.onLayout(z, i, i2, i3, i4);
        if (!(!z || this.qAC || this.qAt == null)) {
            ab.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.qAt.clQ();
        }
        AppMethodBeat.o(25053);
    }

    public void setIsForSns(boolean z) {
        this.qAJ = z;
    }

    @TargetApi(11)
    public void setCameraShadowAlpha(float f) {
        AppMethodBeat.i(25054);
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (com.tencent.mm.compatible.util.d.iW(11)) {
            this.qAw.setAlpha(min);
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.qAw.startAnimation(alphaAnimation);
        }
        ab.d("MicroMsg.MainSightContainerView", "set alpha: %f", Float.valueOf(min));
        if (min <= 0.0f) {
            this.qAw.setVisibility(8);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.qAw.startAnimation(alphaAnimation2);
            AppMethodBeat.o(25054);
            return;
        }
        this.qAw.setVisibility(0);
        AppMethodBeat.o(25054);
    }

    public final void clF() {
        AppMethodBeat.i(25055);
        this.qAy.setVisibility(8);
        AppMethodBeat.o(25055);
    }

    public final void kD(boolean z) {
        AppMethodBeat.i(25056);
        if (z) {
            this.qAy.setVisibility(0);
            setIsMute(true);
            AppMethodBeat.o(25056);
            return;
        }
        clF();
        setIsMute(DX());
        AppMethodBeat.o(25056);
    }

    public final void clC() {
        AppMethodBeat.i(25057);
        this.qAu.setVisibility(0);
        kF(true);
        AppMethodBeat.o(25057);
    }

    public final void clD() {
        AppMethodBeat.i(25058);
        this.qAu.setVisibility(4);
        kF(false);
        AppMethodBeat.o(25058);
    }

    public int getViewHeight() {
        AppMethodBeat.i(25059);
        int height = getHeight();
        if (height <= 0) {
            height = getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.o(25059);
            return height;
        }
        AppMethodBeat.o(25059);
        return height;
    }

    public final void onPause() {
        AppMethodBeat.i(25051);
        if (this.qAH) {
            AppMethodBeat.o(25051);
            return;
        }
        this.qAu.setVisibility(0);
        kF(false);
        this.qAu.clS();
        this.mIsPause = true;
        AppMethodBeat.o(25051);
    }

    public final void onResume() {
        boolean z;
        AppMethodBeat.i(25052);
        if (this.qAC) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            a.xxA.d(this.qAI);
            a.xxA.c(this.qAI);
        } else {
            removeListener();
        }
        if (this.mIsPause) {
            clE();
            this.mIsPause = false;
        }
        AppMethodBeat.o(25052);
    }
}
