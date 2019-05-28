package com.tencent.p177mm.plugin.sight.encode.p513ui;

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
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C18379qt;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.encode.p1022a.C46203b;
import com.tencent.p177mm.plugin.sight.encode.p1022a.C46203b.C133364;
import com.tencent.p177mm.plugin.sight.encode.p1022a.C46203b.C29022a;
import com.tencent.p177mm.plugin.sight.encode.p1022a.C46203b.C349233;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView */
public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, C43533a {
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
    private C46203b qAF;
    private boolean qAG;
    private boolean qAH;
    private C4884c qAI;
    private boolean qAJ;
    private MediaPlayer qAK;
    public MainSightSelectContactView qAt;
    public SightCameraView qAu;
    private C43534b qAv;
    public View qAw;
    public View qAx;
    public View qAy;
    private Dialog qAz;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$1 */
    public class C290231 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(25034);
            MainSightForwardContainerView.this.mo62692kE(true);
            AppMethodBeat.m2505o(25034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$2 */
    public class C290242 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(25035);
            MainSightForwardContainerView.this.clH();
            AppMethodBeat.m2505o(25035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$5 */
    class C397175 extends C4884c<C18379qt> {

        /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$5$1 */
        class C397181 implements Runnable {
            C397181() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25038);
                MainSightForwardContainerView.this.clE();
                AppMethodBeat.m2505o(25038);
            }
        }

        C397175() {
            AppMethodBeat.m2504i(25039);
            this.xxI = C18379qt.class.getName().hashCode();
            AppMethodBeat.m2505o(25039);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25040);
            C18379qt c18379qt = (C18379qt) c4883b;
            String str = "MicroMsg.MainSightContainerView";
            String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(hashCode());
            objArr[1] = Integer.valueOf(c18379qt.cMT.type);
            objArr[2] = Boolean.valueOf(MainSightForwardContainerView.this.qAz != null);
            objArr[3] = Boolean.valueOf(MainSightForwardContainerView.this.qAJ);
            C4990ab.m7417i(str, str2, objArr);
            switch (c18379qt.cMT.type) {
                case 0:
                    MainSightForwardContainerView.this.qAH = false;
                    if (!MainSightForwardContainerView.this.qAJ) {
                        if (!c18379qt.cMT.cMV) {
                            MainSightForwardContainerView.this.postDelayed(new C397181(), 500);
                            break;
                        }
                        C7060h.pYm.mo8381e(11443, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0));
                        MainSightForwardContainerView.this.mo62692kE(true);
                        break;
                    }
                    if (c18379qt.cMT.cMV) {
                        C7060h.pYm.mo8381e(11443, Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0));
                    }
                    MainSightForwardContainerView.this.removeListener();
                    break;
            }
            AppMethodBeat.m2505o(25040);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$3 */
    public class C397193 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(25036);
            MainSightSelectContactView a = MainSightForwardContainerView.this.qAt;
            a.qAC = false;
            a.mListView.clearAnimation();
            a.mListView.clearFocus();
            a.mListView.setAdapter(a.qBi);
            a.mo69087I(false, true);
            a.setVisibility(0);
            if (a.qBh == null) {
                a.qBh = new TranslateAnimation(0.0f, 0.0f, (float) a.qBf, 0.0f);
                a.qBh.setDuration(300);
            }
            a.mListView.startAnimation(a.qBh);
            AppMethodBeat.m2505o(25036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$7 */
    class C397207 implements OnCompletionListener {
        C397207() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(25042);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            AppMethodBeat.m2505o(25042);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView$4 */
    class C397214 implements Runnable {
        C397214() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25037);
            if (!MainSightForwardContainerView.this.qAG || (MainSightForwardContainerView.this.qAt != null && MainSightForwardContainerView.this.qAt.qBg.clK())) {
                MainSightForwardContainerView.this.qAG = false;
                AppMethodBeat.m2505o(25037);
                return;
            }
            MainSightForwardContainerView.this.qAx.setVisibility(0);
            if (!(MainSightForwardContainerView.this.qAt == null || MainSightForwardContainerView.this.qAt.clR() || MainSightForwardContainerView.this.ofJ.getVisibility() == 0)) {
                MainSightForwardContainerView.this.ofJ.setVisibility(0);
                MainSightForwardContainerView.this.ofJ.startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.this.iWA, C25738R.anim.f8332b5));
            }
            AppMethodBeat.m2505o(25037);
        }
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25043);
        this.qAz = null;
        this.mIsPlaying = false;
        this.qAA = true;
        this.qAB = "";
        this.qAC = false;
        this.qAD = "";
        this.mDuration = 1;
        this.qAE = 1.0f;
        this.mIsPause = false;
        this.qAF = new C46203b();
        this.qAG = false;
        this.qAH = false;
        this.qAI = new C397175();
        this.qAJ = false;
        AppMethodBeat.m2505o(25043);
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void removeListener() {
        AppMethodBeat.m2504i(25044);
        C4879a.xxA.mo10053d(this.qAI);
        AppMethodBeat.m2505o(25044);
    }

    public final void clE() {
        boolean z = true;
        AppMethodBeat.m2504i(25045);
        C4990ab.m7417i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", this.qAD, Boolean.valueOf(this.qAA), Boolean.valueOf(this.mIsPlaying));
        if (!this.qAu.isPlaying()) {
            this.qAA = true;
        }
        this.qAu.mo74207bg(this.qAD, this.qAA);
        if (this.qAA) {
            mo62693kF(true);
        } else {
            mo62693kF(false);
        }
        this.mIsPlaying = true;
        if (this.qAA) {
            z = false;
        }
        this.qAA = z;
        AppMethodBeat.m2505o(25045);
    }

    /* renamed from: DX */
    public final boolean mo62684DX() {
        return !this.qAA;
    }

    public void setIsMute(boolean z) {
        AppMethodBeat.m2504i(25046);
        if (this.qAu == null) {
            AppMethodBeat.m2505o(25046);
            return;
        }
        this.qAu.setIsMute(z);
        AppMethodBeat.m2505o(25046);
    }

    /* renamed from: kE */
    public final void mo62692kE(boolean z) {
        AppMethodBeat.m2504i(25047);
        if (this.qAC) {
            AppMethodBeat.m2505o(25047);
            return;
        }
        this.qAC = true;
        C5046bo.hideVKB(this);
        this.mIsPlaying = false;
        this.qAA = true;
        C4990ab.m7410d("MicroMsg.MainSightContainerView", "dismiss sight view");
        this.qAH = false;
        this.qAu.clS();
        if (this.qAv != null && z) {
            this.qAv.clG();
        }
        if (this.qAt != null) {
            MainSightSelectContactView mainSightSelectContactView = this.qAt;
            mainSightSelectContactView.qAC = true;
            C5046bo.hideVKB(mainSightSelectContactView);
            mainSightSelectContactView.qBg.clN();
            mainSightSelectContactView.qBq.clear();
            mainSightSelectContactView.qBp.clear();
            mainSightSelectContactView.mListView.setAdapter(null);
            mainSightSelectContactView.mListView.clearAnimation();
            mainSightSelectContactView.setVisibility(8);
        }
        setCameraShadowAlpha(0.85f);
        clF();
        mo62693kF(false);
        this.qAB = "";
        removeListener();
        AppMethodBeat.m2505o(25047);
    }

    /* renamed from: kF */
    public final void mo62693kF(boolean z) {
        AppMethodBeat.m2504i(25048);
        if (this.qAG == z) {
            AppMethodBeat.m2505o(25048);
            return;
        }
        this.qAG = z;
        if (!z) {
            this.qAx.setVisibility(8);
            this.ofJ.setVisibility(8);
            AppMethodBeat.m2505o(25048);
        } else if (this.qAx.getVisibility() == 0) {
            AppMethodBeat.m2505o(25048);
        } else {
            this.qAu.postDelayed(new C397214(), 100);
            AppMethodBeat.m2505o(25048);
        }
    }

    public void setIMainSightViewCallback(C43534b c43534b) {
        this.qAv = c43534b;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(25049);
        int i2 = i - 1;
        if (MainSightSelectContactView.m77794CH(i2) && this.mIsPlaying) {
            clE();
            AppMethodBeat.m2505o(25049);
        } else if (C46207c.m86403WU(this.qAt.mo69093mW(i2))) {
            this.qAt.qBg.clL();
            AppMethodBeat.m2505o(25049);
        } else if (C46207c.m86402WT(this.qAt.mo69093mW(i2))) {
            if (C46207c.qAQ) {
                this.qAH = true;
                this.qAu.clS();
                Context context = this.iWA;
                String WO = C21846d.m33385WO(this.qAD);
                String str = this.qAD;
                String str2 = this.qAB;
                C4990ab.m7417i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", str, WO);
                if (!C1173e.m2561ct(WO)) {
                    try {
                        C5056d.m7625a(C21846d.m33390ag(str, 320, 240), 60, CompressFormat.JPEG, WO, true);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("KSightPath", str);
                intent.putExtra("KSightThumbPath", WO);
                intent.putExtra("sight_md5", str2);
                intent.putExtra("KSightDraftEntrance", false);
                intent.putExtra("Ksnsupload_source", 0);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", C5046bo.anT());
                C25985d.m41468b(context, "sns", ".ui.SightUploadUI", intent, 5985);
                if (this.qAJ) {
                    C7060h.pYm.mo8381e(11442, Integer.valueOf(3), Integer.valueOf(3));
                    AppMethodBeat.m2505o(25049);
                    return;
                }
                C7060h.pYm.mo8381e(11442, Integer.valueOf(1), Integer.valueOf(3));
            }
            AppMethodBeat.m2505o(25049);
        } else {
            C4990ab.m7411d("MicroMsg.MainSightContainerView", "on item click Item : %d", Integer.valueOf(i2));
            MainSightSelectContactView mainSightSelectContactView = this.qAt;
            if (i2 >= 0 && i2 <= mainSightSelectContactView.qBi.getCount()) {
                C5445a Pn = mainSightSelectContactView.qBi.getItem(i2);
                if (Pn != null) {
                    if (mainSightSelectContactView.qBq.contains(Pn.ehM.field_username)) {
                        mainSightSelectContactView.qBq.remove(Pn.ehM.field_username);
                    } else {
                        mainSightSelectContactView.qBq.add(Pn.ehM.field_username);
                    }
                    C46207c.qAQ = mainSightSelectContactView.qBq.isEmpty();
                    C46207c.qAR = !mainSightSelectContactView.qBq.isEmpty();
                }
            }
            mainSightSelectContactView = this.qAt;
            if (mainSightSelectContactView.qBi != null) {
                mainSightSelectContactView.qBi.notifyDataSetChanged();
            }
            if (!mo62684DX()) {
                clE();
            } else if (this.qAt.clR()) {
                if (this.ofJ.getVisibility() == 0) {
                    this.ofJ.setVisibility(8);
                    this.ofJ.startAnimation(AnimationUtils.loadAnimation(this.iWA, C25738R.anim.f8333b6));
                }
            } else if (this.ofJ.getVisibility() != 0) {
                this.ofJ.setVisibility(0);
                this.ofJ.startAnimation(AnimationUtils.loadAnimation(this.iWA, C25738R.anim.f8332b5));
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
            AppMethodBeat.m2505o(25049);
        }
    }

    public final void clH() {
        AppMethodBeat.m2504i(25050);
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.qAz == null);
        C4990ab.m7417i(str, str2, objArr);
        if (C5046bo.isNullOrNil(this.qAD) || this.qAt.clR()) {
            AppMethodBeat.m2505o(25050);
            return;
        }
        String str3;
        boolean z;
        final LinkedList<String> selectedContact = this.qAt.getSelectedContact();
        C7060h.pYm.mo8381e(11443, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(selectedContact.size()));
        C397226 c397226 = new C29022a() {
            public final void onError(int i) {
                AppMethodBeat.m2504i(25041);
                if (selectedContact.size() <= 1 || -1 == i) {
                    C30379h.m48465bQ(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(C25738R.string.e3n));
                }
                AppMethodBeat.m2505o(25041);
            }
        };
        if (selectedContact.size() == 1) {
            C46203b c46203b = this.qAF;
            String str4 = this.qAD;
            int i = this.mDuration;
            str3 = this.qAB;
            str2 = (String) selectedContact.get(0);
            if (C5046bo.isNullOrNil(str4)) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                C46203b.m86397a(c397226, -1);
            } else if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                C46203b.m86397a(c397226, -1);
            } else if (!C1173e.m2561ct(str4) || C1173e.m2560cs(str4) <= 0) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                C30379h.m48465bQ(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.ehc));
            } else {
                C4990ab.m7417i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str3, C1178g.m2587cz(str4));
                if (C5046bo.m7532bc(str3, "").equals(C1178g.m2587cz(str4))) {
                    C1720g.m3537RQ();
                    if (C1720g.m3539RS().mo10302aa(new C349233(str2, c397226, str4, i)) < 0) {
                        C4990ab.m7412e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                        C46203b.m86397a(c397226, -1);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.SightRecorderHelper", "error md5, return");
                    C46203b.m86397a(c397226, -1);
                }
            }
        } else {
            C46203b c46203b2 = this.qAF;
            String str5 = this.qAD;
            int i2 = this.mDuration;
            String str6 = this.qAB;
            if (C5046bo.isNullOrNil(str5)) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                C46203b.m86397a(c397226, -1);
            } else if (selectedContact == null || selectedContact.isEmpty()) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                C46203b.m86397a(c397226, -1);
            } else if (!C1173e.m2561ct(str5) || C1173e.m2560cs(str5) <= 0) {
                C4990ab.m7420w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                C30379h.m48465bQ(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.ehc));
            } else {
                C4990ab.m7417i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str6, C1178g.m2587cz(str5));
                if (C5046bo.m7532bc(str6, "").equals(C1178g.m2587cz(str5))) {
                    C1720g.m3537RQ();
                    if (C1720g.m3539RS().mo10302aa(new C133364(str5, selectedContact, str6, c397226, i2)) < 0) {
                        C4990ab.m7412e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                        C46203b.m86397a(c397226, -1);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.SightRecorderHelper", "error md5, return");
                    C46203b.m86397a(c397226, -1);
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
                this.qAK = new C45289k();
                this.qAK.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                this.qAK.setOnCompletionListener(new C397207());
                this.qAK.setLooping(false);
                this.qAK.prepare();
                this.qAK.start();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.MainSightContainerView", e, "", new Object[0]);
            }
        }
        mo62692kE(z);
        for (String str32 : selectedContact) {
            if (str32.toLowerCase().endsWith("@chatroom")) {
                C7060h.pYm.mo8381e(11442, Integer.valueOf(1), Integer.valueOf(2));
            } else {
                C7060h.pYm.mo8381e(11442, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(25050);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(25053);
        super.onLayout(z, i, i2, i3, i4);
        if (!(!z || this.qAC || this.qAt == null)) {
            C4990ab.m7411d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.qAt.clQ();
        }
        AppMethodBeat.m2505o(25053);
    }

    public void setIsForSns(boolean z) {
        this.qAJ = z;
    }

    @TargetApi(11)
    public void setCameraShadowAlpha(float f) {
        AppMethodBeat.m2504i(25054);
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (C1443d.m3068iW(11)) {
            this.qAw.setAlpha(min);
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.qAw.startAnimation(alphaAnimation);
        }
        C4990ab.m7411d("MicroMsg.MainSightContainerView", "set alpha: %f", Float.valueOf(min));
        if (min <= 0.0f) {
            this.qAw.setVisibility(8);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.qAw.startAnimation(alphaAnimation2);
            AppMethodBeat.m2505o(25054);
            return;
        }
        this.qAw.setVisibility(0);
        AppMethodBeat.m2505o(25054);
    }

    public final void clF() {
        AppMethodBeat.m2504i(25055);
        this.qAy.setVisibility(8);
        AppMethodBeat.m2505o(25055);
    }

    /* renamed from: kD */
    public final void mo62691kD(boolean z) {
        AppMethodBeat.m2504i(25056);
        if (z) {
            this.qAy.setVisibility(0);
            setIsMute(true);
            AppMethodBeat.m2505o(25056);
            return;
        }
        clF();
        setIsMute(mo62684DX());
        AppMethodBeat.m2505o(25056);
    }

    public final void clC() {
        AppMethodBeat.m2504i(25057);
        this.qAu.setVisibility(0);
        mo62693kF(true);
        AppMethodBeat.m2505o(25057);
    }

    public final void clD() {
        AppMethodBeat.m2504i(25058);
        this.qAu.setVisibility(4);
        mo62693kF(false);
        AppMethodBeat.m2505o(25058);
    }

    public int getViewHeight() {
        AppMethodBeat.m2504i(25059);
        int height = getHeight();
        if (height <= 0) {
            height = getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.m2505o(25059);
            return height;
        }
        AppMethodBeat.m2505o(25059);
        return height;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(25051);
        if (this.qAH) {
            AppMethodBeat.m2505o(25051);
            return;
        }
        this.qAu.setVisibility(0);
        mo62693kF(false);
        this.qAu.clS();
        this.mIsPause = true;
        AppMethodBeat.m2505o(25051);
    }

    public final void onResume() {
        boolean z;
        AppMethodBeat.m2504i(25052);
        if (this.qAC) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            C4879a.xxA.mo10053d(this.qAI);
            C4879a.xxA.mo10052c(this.qAI);
        } else {
            removeListener();
        }
        if (this.mIsPause) {
            clE();
            this.mIsPause = false;
        }
        AppMethodBeat.m2505o(25052);
    }
}
