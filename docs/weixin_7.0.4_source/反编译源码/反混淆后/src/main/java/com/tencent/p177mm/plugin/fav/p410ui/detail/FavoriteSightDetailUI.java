package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39038m;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C20677d;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C27971a;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C27972c;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i;
import com.tencent.p177mm.plugin.fav.p410ui.C3105g;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI */
public class FavoriteSightDetailUI extends BaseFavDetailReportUI implements C11855p, C4931a {
    private aar cAv;
    private C41268k mjD = new C41268k();
    private C27966g mjP;
    private boolean mlN = false;
    private boolean mlT = false;
    private VideoPlayerTextureView mmA;
    private ImageView mmB;
    private long mmC;
    private boolean mmD = true;
    private boolean mmE = false;
    private Runnable mmF = new C31035();
    private boolean mmG = false;
    private View mmx;
    private ImageView mmy;
    private MMPinProgressBtn mmz;

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$4 */
    class C30984 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$4$1 */
        class C30991 implements C36073c {
            C30991() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(74415);
                int i = (!FavoriteSightDetailUI.this.mjP.but() || FavoriteSightDetailUI.this.mjD.mo61948t(FavoriteSightDetailUI.this.mjP)) ? 0 : 1;
                if (i != 0 && FavoriteSightDetailUI.this.cAv.whh == 0) {
                    c44273l.mo70068e(0, FavoriteSightDetailUI.this.getString(C25738R.string.bri));
                }
                c44273l.mo70068e(4, FavoriteSightDetailUI.this.getString(C25738R.string.br7));
                c44273l.mo70068e(3, FavoriteSightDetailUI.this.getString(C25738R.string.bo8));
                c44273l.mo70068e(2, FavoriteSightDetailUI.this.mController.ylL.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(74415);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$4$2 */
        class C31002 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$4$2$1 */
            class C31011 implements OnClickListener {
                C31011() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(74417);
                    final C44275p b = C30379h.m48458b(FavoriteSightDetailUI.this.mController.ylL, FavoriteSightDetailUI.this.getString(C25738R.string.f9089p5), false, null);
                    C39037b.m66365a(FavoriteSightDetailUI.this.mjP.field_localId, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(74416);
                            FavoriteSightDetailUI.this.mlz.mfd = true;
                            b.dismiss();
                            C4990ab.m7417i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteSightDetailUI.this.mjP.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.mjP.field_id));
                            FavoriteSightDetailUI.this.finish();
                            AppMethodBeat.m2505o(74416);
                        }
                    });
                    AppMethodBeat.m2505o(74417);
                }
            }

            C31002() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(74418);
                Intent intent;
                C27969a c27969a;
                switch (menuItem.getItemId()) {
                    case 0:
                        C27968h.m44531j(FavoriteSightDetailUI.this.mjP.field_localId, 1, 0);
                        intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("scene_from", 1);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("select_fav_local_id", FavoriteSightDetailUI.this.mjP.field_localId);
                        C25985d.m41466b(FavoriteSightDetailUI.this.mController.ylL, ".ui.transmit.SelectConversationUI", intent, 1);
                        c27969a = FavoriteSightDetailUI.this.mlz;
                        c27969a.meZ++;
                        AppMethodBeat.m2505o(74418);
                        return;
                    case 2:
                        C30379h.m48440a(FavoriteSightDetailUI.this.mController.ylL, FavoriteSightDetailUI.this.getString(C25738R.string.f9089p5), "", new C31011(), null);
                        AppMethodBeat.m2505o(74418);
                        return;
                    case 3:
                        c27969a = FavoriteSightDetailUI.this.mlz;
                        c27969a.mfc++;
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavoriteSightDetailUI.this.mjP.field_localId);
                        C39037b.m66371b(FavoriteSightDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        AppMethodBeat.m2505o(74418);
                        return;
                    case 4:
                        C3105g.m5347a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.this.mmC, FavoriteSightDetailUI.this.mlz);
                        break;
                }
                AppMethodBeat.m2505o(74418);
            }
        }

        C30984() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74419);
            C36356d c36356d = new C36356d(FavoriteSightDetailUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C30991();
            c36356d.rBm = new C31002();
            c36356d.cpD();
            AppMethodBeat.m2505o(74419);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$5 */
    class C31035 implements Runnable {
        C31035() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74420);
            if (FavoriteSightDetailUI.this.mjP.isDone() && C39037b.m66393f(FavoriteSightDetailUI.this.cAv) && FavoriteSightDetailUI.this.mmA != null && FavoriteSightDetailUI.this.mmA.isPlaying()) {
                AppMethodBeat.m2505o(74420);
                return;
            }
            FavoriteSightDetailUI.m76539a(FavoriteSightDetailUI.this, true);
            AppMethodBeat.m2505o(74420);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$3 */
    class C119013 implements OnMenuItemClickListener {
        C119013() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74414);
            FavoriteSightDetailUI.this.finish();
            AppMethodBeat.m2505o(74414);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$1 */
    class C341681 implements View.OnClickListener {
        C341681() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74408);
            if (C35973a.m59179bJ(view.getContext()) || C35973a.m59177bH(view.getContext())) {
                AppMethodBeat.m2505o(74408);
                return;
            }
            C4990ab.m7417i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteSightDetailUI.this.mjP.field_id), Long.valueOf(FavoriteSightDetailUI.this.mjP.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.mjP.field_itemStatus));
            if (FavoriteSightDetailUI.this.mjP.isDone()) {
                if (C39037b.m66393f(FavoriteSightDetailUI.this.cAv)) {
                    C39038m.m66421a(C27971a.EnterFullScreen, FavoriteSightDetailUI.this.mjP);
                    FavoriteSightDetailUI.m76540a(FavoriteSightDetailUI.this, true, view.getContext());
                    AppMethodBeat.m2505o(74408);
                    return;
                } else if (C5046bo.isNullOrNil(FavoriteSightDetailUI.this.cAv.wfZ)) {
                    FavoriteSightDetailUI.m76540a(FavoriteSightDetailUI.this, false, view.getContext());
                    AppMethodBeat.m2505o(74408);
                    return;
                } else {
                    C4990ab.m7420w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                }
            } else if (FavoriteSightDetailUI.this.mjP.buy()) {
                if (C5046bo.isNullOrNil(FavoriteSightDetailUI.this.cAv.wfZ)) {
                    FavoriteSightDetailUI.m76540a(FavoriteSightDetailUI.this, false, view.getContext());
                    AppMethodBeat.m2505o(74408);
                    return;
                }
            } else if (FavoriteSightDetailUI.this.mjP.isDownloading() || FavoriteSightDetailUI.this.mjP.buw()) {
                if (FavoriteSightDetailUI.this.mmz.getVisibility() == 8) {
                    FavoriteSightDetailUI.m76539a(FavoriteSightDetailUI.this, false);
                }
                AppMethodBeat.m2505o(74408);
                return;
            }
            if (FavoriteSightDetailUI.this.mjP.bux()) {
                C39037b.m66410l(FavoriteSightDetailUI.this.mjP);
            } else {
                C39037b.m66411m(FavoriteSightDetailUI.this.mjP);
            }
            FavoriteSightDetailUI.m76539a(FavoriteSightDetailUI.this, false);
            AppMethodBeat.m2505o(74408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$2 */
    class C412762 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$2$1 */
        class C30971 implements Runnable {
            C30971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74409);
                FavoriteSightDetailUI.this.mmB.setVisibility(8);
                AppMethodBeat.m2505o(74409);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI$2$2 */
        class C280132 implements Runnable {
            C280132() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74410);
                C30379h.m48467g(FavoriteSightDetailUI.this.mController.ylL, C25738R.string.f1a, C25738R.string.f1j);
                AppMethodBeat.m2505o(74410);
            }
        }

        C412762() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(74411);
            C4990ab.m7416i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
            FavoriteSightDetailUI.this.mmA.setLoop(true);
            FavoriteSightDetailUI.this.mmE = FavoriteSightDetailUI.this.mmA.start();
            C5004al.m7441d(new C30971());
            AppMethodBeat.m2505o(74411);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(74412);
            C4990ab.m7413e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == -1) {
                FavoriteSightDetailUI.this.mmA.stop();
                if (C5730e.m8628ct(C39037b.m66370b(FavoriteSightDetailUI.this.cAv))) {
                    FavoriteSightDetailUI.m76546f(FavoriteSightDetailUI.this);
                    AppMethodBeat.m2505o(74412);
                    return;
                }
                if (C5730e.m8628ct(C39037b.m66379c(FavoriteSightDetailUI.this.cAv))) {
                    FavoriteSightDetailUI.this.mmB.setVisibility(0);
                }
                AppMethodBeat.m2505o(74412);
            } else if (FavoriteSightDetailUI.this.mmE) {
                mo8553EA();
                AppMethodBeat.m2505o(74412);
            } else {
                FavoriteSightDetailUI.this.mmA.stop();
                if (FavoriteSightDetailUI.this.mlN) {
                    AppMethodBeat.m2505o(74412);
                    return;
                }
                FavoriteSightDetailUI.this.mlN = true;
                C5004al.m7441d(new C280132());
                AppMethodBeat.m2505o(74412);
            }
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(74413);
            FavoriteSightDetailUI.this.mmA.mo9052B(0.0d);
            AppMethodBeat.m2505o(74413);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavoriteSightDetailUI() {
        AppMethodBeat.m2504i(74423);
        AppMethodBeat.m2505o(74423);
    }

    /* renamed from: f */
    static /* synthetic */ void m76546f(FavoriteSightDetailUI favoriteSightDetailUI) {
        AppMethodBeat.m2504i(74436);
        favoriteSightDetailUI.bwo();
        AppMethodBeat.m2505o(74436);
    }

    public final int getLayoutId() {
        return 2130969540;
    }

    /* Access modifiers changed, original: protected|final */
    public final MMLoadScrollView bwd() {
        AppMethodBeat.m2504i(74424);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(2131823999);
        AppMethodBeat.m2505o(74424);
        return mMLoadScrollView;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74425);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        this.mmC = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mjP = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mmC);
        if (this.mjP == null) {
            C4990ab.m7421w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", Long.valueOf(this.mmC));
            finish();
            AppMethodBeat.m2505o(74425);
            return;
        }
        mo54744F(this.mjP);
        C39038m.m66423w(this.mjP);
        C20728a.m31955a(this, this.mjP);
        this.cAv = C39037b.m66378c(this.mjP);
        this.mmy = (ImageView) findViewById(2131820981);
        this.mmz = (MMPinProgressBtn) findViewById(2131822136);
        this.mmx = findViewById(2131824001);
        this.mmA = (VideoPlayerTextureView) findViewById(2131821402);
        this.mmB = (ImageView) findViewById(2131822133);
        this.mmx.setOnClickListener(new C341681());
        this.mmA.setVideoCallback(new C412762());
        setMMTitle(getString(C25738R.string.bns));
        setBackBtn(new C119013());
        addIconOptionMenu(0, C25738R.string.ewm, C25738R.drawable.f6899uu, new C30984());
        if (C5730e.m8628ct(C39037b.m66379c(this.cAv))) {
            Bitmap a = C45939l.m85275a(this.cAv, this.mjP);
            if (a != null) {
                int width = a.getWidth();
                int height = a.getHeight();
                if (!this.mmG) {
                    this.mmG = true;
                    DisplayMetrics displayMetrics = this.mmx.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 36.0f) + 0.5f;
                    LayoutParams layoutParams = this.mmx.getLayoutParams();
                    if (layoutParams == null) {
                        C4990ab.m7412e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.mmx.setLayoutParams(layoutParams);
                    }
                }
                this.mmB.setImageBitmap(a);
                this.mmB.setVisibility(0);
            }
        } else if (!C5046bo.isNullOrNil(this.cAv.fgE)) {
            C39037b.m66359a(this.mjP, this.cAv);
        }
        m76549hm(false);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(this);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this);
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(74425);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74426);
        if (this.mmA != null) {
            this.mmA.setVideoCallback(null);
            this.mmA.stop();
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(this);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this);
        super.onDestroy();
        AppMethodBeat.m2505o(74426);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74427);
        super.onResume();
        if (this.mmA != null) {
            if (!this.mmD) {
                bwo();
            } else if (!this.mmA.isPlaying()) {
                this.mmA.start();
            }
            this.mmD = false;
        }
        AppMethodBeat.m2505o(74427);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74428);
        if (this.mmA != null) {
            this.mmA.stop();
        }
        super.onPause();
        AppMethodBeat.m2505o(74428);
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: hm */
    private void m76549hm(boolean z) {
        AppMethodBeat.m2504i(74429);
        if (this.mjP.isDone()) {
            if (C39037b.m66393f(this.cAv)) {
                this.mmy.setVisibility(8);
                this.mmz.setVisibility(8);
                bwo();
                AppMethodBeat.m2505o(74429);
                return;
            } else if (C5046bo.isNullOrNil(this.cAv.wfZ)) {
                this.mmy.setImageResource(C1318a.shortvideo_play_btn);
            } else {
                C4990ab.m7420w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                this.mmy.setImageResource(C1318a.shortvideo_play_btn);
            }
        } else if (this.mjP.buy()) {
            if (C5046bo.isNullOrNil(this.cAv.wfZ)) {
                this.mmy.setImageResource(C1318a.shortvideo_play_btn);
                if (z) {
                }
            } else {
                this.mmy.setImageResource(C1318a.shortvideo_play_btn);
                if (z) {
                    C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.b6p));
                }
            }
        } else if (this.mjP.bux()) {
            this.mmy.setImageResource(C1318a.shortvideo_play_btn);
            if (z) {
                C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.bnk));
            }
        } else if (this.mjP.isDownloading() || this.mjP.buw()) {
            this.mmy.setVisibility(8);
            this.mmz.setVisibility(0);
            C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd);
            if (LR != null) {
                this.mmz.setProgress((int) LR.getProgress());
            } else {
                this.mmz.setProgress(0);
            }
            this.mmB.setVisibility(0);
            AppMethodBeat.m2505o(74429);
            return;
        } else {
            C4990ab.m7420w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            this.mmy.setImageResource(C1318a.shortvideo_play_btn);
        }
        this.mmy.setVisibility(0);
        this.mmz.setVisibility(8);
        this.mmB.setVisibility(0);
        AppMethodBeat.m2505o(74429);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(74430);
        C4990ab.m7417i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.mjP.field_localId));
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mjP.field_localId);
        if (iE == null) {
            C4990ab.m7420w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            AppMethodBeat.m2505o(74430);
            return;
        }
        boolean z;
        this.mjP = iE;
        this.cAv = C39037b.m66378c(iE);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd);
        if (LR == null) {
            z = false;
        } else if (this.mlT) {
            z = false;
        } else {
            if (LR.field_status == 4 && ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd).field_extFlag != 0) {
                C39037b.m66360a(this.mjP, this.cAv, true);
                this.mlT = true;
            }
            C4990ab.m7417i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.mlT));
            z = this.mlT;
        }
        if (z) {
            AppMethodBeat.m2505o(74430);
            return;
        }
        C5004al.m7439af(this.mmF);
        C5004al.m7442n(this.mmF, 500);
        AppMethodBeat.m2505o(74430);
    }

    /* renamed from: d */
    public final void mo23673d(C45925c c45925c) {
        AppMethodBeat.m2504i(74431);
        if (c45925c == null || c45925c.field_dataId == null) {
            C4990ab.m7420w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            AppMethodBeat.m2505o(74431);
            return;
        }
        C4990ab.m7417i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", this.cAv.mnd, c45925c.field_dataId, Integer.valueOf(c45925c.field_offset), Integer.valueOf(c45925c.field_totalLen), Integer.valueOf(c45925c.field_status), Integer.valueOf(c45925c.field_type));
        if (c45925c.field_offset > c45925c.field_totalLen) {
            C4990ab.m7412e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == c45925c.field_type) {
                c45925c.field_status = 2;
            } else {
                c45925c.field_status = 4;
            }
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(c45925c, new String[0]);
            if (c45925c.field_type == 0) {
                C39037b.m66356a(c45925c);
            }
            if (c45925c.field_type == 1) {
                C39037b.m66373b(c45925c);
            }
        }
        if (c45925c.field_dataId.equals(this.cAv.mnd)) {
            final int progress = (int) c45925c.getProgress();
            this.mmz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74421);
                    FavoriteSightDetailUI.this.mmz.setProgress(progress);
                    AppMethodBeat.m2505o(74421);
                }
            });
        }
        AppMethodBeat.m2505o(74431);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74432);
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C11909i.m19791a(this.mController.ylL, stringExtra, str, this.mjP, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74422);
                    b.dismiss();
                    AppMethodBeat.m2505o(74422);
                }
            });
            boolean kH = C1855t.m3896kH(stringExtra);
            C39038m.m66422a(kH ? C27972c.Chatroom : C27972c.Chat, this.mjP, C20677d.Samll, kH ? C37921n.m64060mA(stringExtra) : 0);
            C5670b.m8523i(this, getString(C25738R.string.bnf));
            AppMethodBeat.m2505o(74432);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74432);
    }

    private void bwo() {
        AppMethodBeat.m2504i(74433);
        String b = C39037b.m66370b(this.cAv);
        if (C5730e.m8628ct(b)) {
            this.mmA.stop();
            this.mmA.setMute(true);
            this.mmA.setVideoPath(b);
            AppMethodBeat.m2505o(74433);
            return;
        }
        AppMethodBeat.m2505o(74433);
    }

    /* renamed from: a */
    static /* synthetic */ void m76540a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        AppMethodBeat.m2504i(74434);
        aar c = C39037b.m66378c(favoriteSightDetailUI.mjP);
        Intent intent;
        if (c == null) {
            C4990ab.m7412e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.m2505o(74434);
        } else if (c.wgZ == null || (C5046bo.isNullOrNil(c.wgZ.fiG) && C5046bo.isNullOrNil(c.wgZ.fiK))) {
            intent = new Intent();
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.mjP.field_localId);
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.mlz.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.mlz.jSW);
            intent.putExtra("key_detail_fav_path", C39037b.m66370b(c));
            intent.putExtra("key_detail_fav_thumb_path", C39037b.m66379c(c));
            intent.putExtra("key_detail_fav_video_duration", c.duration);
            intent.putExtra("key_detail_statExtStr", c.cMn);
            intent.putExtra("key_detail_data_valid", z);
            C39037b.m66371b(context, ".ui.detail.FavoriteVideoPlayUI", intent);
            AppMethodBeat.m2505o(74434);
        } else {
            C4990ab.m7416i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            intent = new Intent();
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.mlz.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.mlz.jSW);
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.mjP.field_localId);
            intent.putExtra("key_detail_data_id", c.mnd);
            intent.putExtra("key_detail_can_delete", false);
            C39037b.m66371b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.m2505o(74434);
        }
    }
}
