package com.tencent.p177mm.p612ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p174e.C1153b;
import com.tencent.matrix.trace.p175f.C7469c;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.p1089a.C15565b;
import com.tencent.p177mm.p612ui.chatting.p1089a.C15565b.C15569c;
import com.tencent.p177mm.p612ui.chatting.p1092e.C30496a.C30497b;
import com.tencent.p177mm.p612ui.chatting.p1092e.C30496a.C30498c;
import com.tencent.p177mm.p612ui.chatting.p1092e.C30496a.C30499a;
import com.tencent.p177mm.p612ui.chatting.p619i.C30529e;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI */
public class MediaHistoryGalleryUI extends MMActivity implements OnClickListener, C30497b {
    private RecyclerView aiB;
    private long eEO = 0;
    private int ehv;
    private String emo;
    private TextView emq;
    private long fAq = 0;
    private ProgressDialog kvA;
    private boolean kvO = true;
    private int kvP;
    private TextView mnJ;
    private boolean mnK = false;
    private int mnL = -1;
    private C1153b mnM = new C305101();
    private long yNB;
    private View yUN;
    private View yUP;
    private View yUQ;
    private View yUR;
    private View yUS;
    private C30499a yXO;
    private boolean yXP;
    private boolean yXQ;
    private boolean yXR;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$a */
    static class C5339a {
        /* renamed from: a */
        public static C30499a m8096a(Context context, C30498c c30498c) {
            AppMethodBeat.m2504i(32416);
            C30499a c30499a = null;
            switch (C305117.yXU[c30498c.ordinal()]) {
                case 1:
                    c30499a = new C30529e(context);
                    break;
            }
            AppMethodBeat.m2505o(32416);
            return c30499a;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$6 */
    class C237756 implements OnMenuItemClickListener {
        C237756() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(32414);
            MediaHistoryGalleryUI.this.bwq();
            AppMethodBeat.m2505o(32414);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$1 */
    class C305101 extends C1153b {
        C305101() {
        }

        /* renamed from: a */
        public final void mo4386a(String str, long j, int i) {
            AppMethodBeat.m2504i(32405);
            super.mo4386a(str, j, i);
            if (i > 0 && !C5046bo.isNullOrNil(str) && str.endsWith(MediaHistoryGalleryUI.this.getClass().getSimpleName())) {
                MediaHistoryGalleryUI.this.eEO = MediaHistoryGalleryUI.this.eEO + ((long) i);
            }
            AppMethodBeat.m2505o(32405);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$7 */
    static /* synthetic */ class C305117 {
        static final /* synthetic */ int[] yXU = new int[C30498c.values().length];

        static {
            AppMethodBeat.m2504i(32415);
            try {
                yXU[C30498c.yTC.ordinal()] = 1;
                AppMethodBeat.m2505o(32415);
            } catch (NoSuchFieldError e) {
                AppMethodBeat.m2505o(32415);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$2 */
    class C368692 extends C41530m {
        C368692() {
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(32406);
            super.mo6642a(recyclerView, i, i2);
            AppMethodBeat.m2505o(32406);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$4 */
    class C368704 implements OnMenuItemClickListener {
        C368704() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(32412);
            MediaHistoryGalleryUI.this.finish();
            AppMethodBeat.m2505o(32412);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$5 */
    class C368715 implements OnMenuItemClickListener {
        C368715() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(32413);
            MediaHistoryGalleryUI.this.bwr();
            AppMethodBeat.m2505o(32413);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$3 */
    class C368723 extends C41530m {
        private Runnable kvR = new C368731();

        /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$3$1 */
        class C368731 implements Runnable {
            C368731() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32407);
                MediaHistoryGalleryUI.this.mnJ.startAnimation(AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.mController.ylL, C25738R.anim.f8333b6));
                MediaHistoryGalleryUI.this.mnJ.setVisibility(8);
                AppMethodBeat.m2505o(32407);
            }
        }

        C368723() {
            AppMethodBeat.m2504i(32408);
            AppMethodBeat.m2505o(32408);
        }

        /* renamed from: fQ */
        private void m61373fQ(boolean z) {
            AppMethodBeat.m2504i(32409);
            if (z) {
                MediaHistoryGalleryUI.this.mnJ.removeCallbacks(this.kvR);
                if (MediaHistoryGalleryUI.this.mnJ.getVisibility() != 0) {
                    MediaHistoryGalleryUI.this.mnJ.clearAnimation();
                    Animation loadAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.mController.ylL, C25738R.anim.f8332b5);
                    MediaHistoryGalleryUI.this.mnJ.setVisibility(0);
                    MediaHistoryGalleryUI.this.mnJ.startAnimation(loadAnimation);
                    AppMethodBeat.m2505o(32409);
                    return;
                }
            }
            MediaHistoryGalleryUI.this.mnJ.removeCallbacks(this.kvR);
            MediaHistoryGalleryUI.this.mnJ.postDelayed(this.kvR, 256);
            AppMethodBeat.m2505o(32409);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(32410);
            super.mo6642a(recyclerView, i, i2);
            C15565b c15565b = (C15565b) MediaHistoryGalleryUI.this.yXO.bwx();
            C15569c Ox = c15565b.mo27741Ox(((LinearLayoutManager) MediaHistoryGalleryUI.this.yXO.bfC()).mo1780iQ());
            if (Ox == null) {
                AppMethodBeat.m2505o(32410);
                return;
            }
            MediaHistoryGalleryUI.this.mnJ.setText(C5046bo.m7532bc(c15565b.mo27743ha(Ox.timeStamp), ""));
            AppMethodBeat.m2505o(32410);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(32411);
            if (1 == i) {
                m61373fQ(true);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.this.ehv);
                MediaHistoryGalleryUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, WXHardCoderJNI.hcMediaGalleryScrollDelay, WXHardCoderJNI.hcMediaGalleryScrollCPU, WXHardCoderJNI.hcMediaGalleryScrollIO, WXHardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            } else if (i == 0) {
                m61373fQ(false);
            }
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                if (!(((LinearLayoutManager) recyclerView.getLayoutManager()).mo1780iQ() != 0 || MediaHistoryGalleryUI.this.kvO || MediaHistoryGalleryUI.this.yXO == null)) {
                    MediaHistoryGalleryUI.this.yXO.mo48912s(false, -1);
                }
                MediaHistoryGalleryUI.this.kvO = false;
                C32291o.ahp().mo43773cm(i);
            }
            AppMethodBeat.m2505o(32411);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MediaHistoryGalleryUI() {
        AppMethodBeat.m2504i(32417);
        AppMethodBeat.m2505o(32417);
    }

    public void onCreate(Bundle bundle) {
        C30499a a;
        AppMethodBeat.m2504i(32418);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        this.mnK = true;
        Intent intent = getIntent();
        this.yXP = intent.getIntExtra("kintent_intent_source", 0) == 1;
        this.emo = intent.getStringExtra("kintent_talker");
        this.mnL = intent.getIntExtra("kintent_image_index", -1);
        this.yXQ = intent.getBooleanExtra("key_is_biz_chat", false);
        this.yNB = getIntent().getLongExtra("key_biz_chat_id", -1);
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 1:
                a = C5339a.m8096a(this, C30498c.yTC);
                break;
            default:
                a = C5339a.m8096a(this, C30498c.yTC);
                break;
        }
        a.mo39610a(this);
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f11906l8));
        mo17372Nb(this.mController.ylL.getResources().getColor(C25738R.color.f11906l8));
        initView();
        this.yXO.mo48912s(true, this.mnL);
        C30036f.m47545n(this);
        AppMethodBeat.m2505o(32418);
    }

    public void onResume() {
        AppMethodBeat.m2504i(32419);
        this.fAq = C5046bo.anT();
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16643a(this.mnM);
            }
        }
        super.onResume();
        this.yXO.onResume();
        if (this.mnK) {
            if (this.yXO.bwy()) {
                bwq();
            } else {
                bwr();
            }
        }
        this.mnK = false;
        AppMethodBeat.m2505o(32419);
    }

    public void onPause() {
        AppMethodBeat.m2504i(32420);
        super.onPause();
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.ehv);
        this.ehv = 0;
        if (C1060a.isInstalled() && C1060a.m2339yK().mo4192F(C7466a.class) != null) {
            C7469c c7469c = ((C7466a) C1060a.m2339yK().mo4192F(C7466a.class)).bYx;
            if (c7469c != null) {
                c7469c.mo16644b(this.mnM);
            }
        }
        this.fAq = C5046bo.anT() > this.fAq ? C5046bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.m2505o(32420);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(32421);
        super.onDestroy();
        this.yXO.onDetach();
        AppMethodBeat.m2505o(32421);
    }

    public final void initView() {
        AppMethodBeat.m2504i(32422);
        super.initView();
        dGJ();
        this.mnJ = (TextView) findViewById(2131823946);
        this.emq = (TextView) findViewById(2131821477);
        this.aiB = (RecyclerView) findViewById(2131821478);
        this.aiB.setBackgroundColor(getResources().getColor(C25738R.color.f11715eg));
        findViewById(2131821476).setBackgroundColor(getResources().getColor(C25738R.color.f11715eg));
        this.aiB.setLayoutManager(this.yXO.bfC());
        this.aiB.mo66330a(this.yXO.mo48910dN(this));
        this.aiB.setAdapter(this.yXO.mo48901aT(this.emo, this.yNB));
        this.aiB.setHasFixedSize(true);
        this.aiB.setOnScrollListener(new C368692());
        this.aiB.mo66332a(new C368723());
        setMMTitle(this.yXO.aoy());
        setBackBtn(new C368704());
        AppMethodBeat.m2505o(32422);
    }

    public final int getLayoutId() {
        return 2130970080;
    }

    /* renamed from: fO */
    public final void mo48897fO(boolean z) {
        AppMethodBeat.m2504i(32423);
        if (z) {
            m61366y(true, null);
            AppMethodBeat.m2505o(32423);
            return;
        }
        this.kvP = ((GridLayoutManager) this.aiB.getLayoutManager()).mo1782iS();
        AppMethodBeat.m2505o(32423);
    }

    /* renamed from: p */
    public final void mo48899p(boolean z, int i) {
        AppMethodBeat.m2504i(32424);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.mnL));
        if (z) {
            m61366y(false, null);
            this.aiB.getAdapter().aop.notifyChanged();
            if (this.mnL > 0) {
                if (this.mnL % 4 == 0) {
                    this.mnL++;
                }
                this.aiB.mo61465bY(Math.min(this.aiB.getAdapter().getItemCount() - 1, this.mnL));
            } else {
                this.aiB.mo61465bY(this.aiB.getAdapter().getItemCount() - 1);
            }
            if (i <= 0) {
                this.emq.setVisibility(0);
                this.aiB.setVisibility(8);
                this.emq.setText(getString(C25738R.string.ano));
                AppMethodBeat.m2505o(32424);
                return;
            }
            this.emq.setVisibility(8);
            this.aiB.setVisibility(0);
            AppMethodBeat.m2505o(32424);
        } else if (i > 0) {
            this.aiB.getAdapter().mo66310at(0, i);
            this.aiB.getAdapter().mo66308ar(i, this.kvP + i);
            AppMethodBeat.m2505o(32424);
        } else {
            this.aiB.getAdapter().mo66316cg(0);
            AppMethodBeat.m2505o(32424);
        }
    }

    public final View getChildAt(int i) {
        AppMethodBeat.m2504i(32425);
        View childAt = this.aiB.getChildAt(i);
        AppMethodBeat.m2505o(32425);
        return childAt;
    }

    /* renamed from: vF */
    public final void mo48900vF(int i) {
        AppMethodBeat.m2504i(32426);
        setMMTitle(getString(C25738R.string.c47, new Object[]{Integer.valueOf(i)}));
        m61357Ph(i);
        AppMethodBeat.m2505o(32426);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(32427);
        this.yXO.mo48913vH(((Integer) view.getTag()).intValue());
        AppMethodBeat.m2505o(32427);
    }

    private void dGJ() {
        AppMethodBeat.m2504i(32428);
        this.yUN = findViewById(2131824973);
        this.yUQ = findViewById(2131823944);
        this.yUS = findViewById(2131822772);
        this.yUR = findViewById(2131824975);
        this.yUP = findViewById(2131824974);
        this.yUP.setTag(Integer.valueOf(1));
        this.yUQ.setTag(Integer.valueOf(0));
        this.yUR.setTag(Integer.valueOf(3));
        this.yUS.setTag(Integer.valueOf(2));
        this.yUP.setOnClickListener(this);
        this.yUQ.setOnClickListener(this);
        this.yUR.setOnClickListener(this);
        this.yUS.setOnClickListener(this);
        AppMethodBeat.m2505o(32428);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(32429);
        super.onBackPressed();
        C4990ab.m7416i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.yXR) {
            this.yXO.dFC();
            AppMethodBeat.m2505o(32429);
            return;
        }
        finish();
        AppMethodBeat.m2505o(32429);
    }

    public final void bwq() {
        AppMethodBeat.m2504i(32430);
        this.yXO.bwq();
        setMMTitle(getString(C25738R.string.c47, new Object[]{Integer.valueOf(this.yXO.dFB())}));
        this.yUN.setVisibility(0);
        this.yUN.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8375cg));
        m61357Ph(this.yXO.dFB());
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(C25738R.string.c38), new C368715());
        AppMethodBeat.m2505o(32430);
    }

    public final void bwr() {
        AppMethodBeat.m2504i(32431);
        this.yXO.bwr();
        setMMTitle(this.yXO.aoy());
        this.yUN.setVisibility(8);
        this.yUN.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8373ce));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(C25738R.string.c39), new C237756());
        AppMethodBeat.m2505o(32431);
    }

    public final void dFD() {
        AppMethodBeat.m2504i(32432);
        this.yXR = true;
        m61366y(true, getString(C25738R.string.cde));
        AppMethodBeat.m2505o(32432);
    }

    public final void dFC() {
        AppMethodBeat.m2504i(32433);
        bwr();
        this.yXR = false;
        m61366y(false, "");
        AppMethodBeat.m2505o(32433);
    }

    public final void dFE() {
        AppMethodBeat.m2504i(32434);
        bwr();
        this.yXR = false;
        m61366y(false, "");
        String str = C6457e.euR;
        Toast.makeText(this, getString(C25738R.string.anp, new Object[]{str.substring(str.indexOf("tencent/MicroMsg"))}), 1).show();
        AppMethodBeat.m2505o(32434);
    }

    /* renamed from: OI */
    public final void mo48891OI(int i) {
        AppMethodBeat.m2504i(32435);
        bwr();
        m61366y(false, "");
        if (i == 0) {
            i = C25738R.string.c45;
        }
        if (this.yXR) {
            C30379h.m48433a((Context) this, i, (int) C25738R.string.f9238tz, true, null);
        }
        this.yXR = false;
        AppMethodBeat.m2505o(32435);
    }

    public final boolean dFF() {
        return this.yXR;
    }

    /* renamed from: Ph */
    private void m61357Ph(int i) {
        AppMethodBeat.m2504i(32436);
        if (!this.yXO.bwy() || i <= 0) {
            this.yUP.setEnabled(false);
            this.yUQ.setEnabled(false);
            this.yUR.setEnabled(false);
            this.yUS.setEnabled(false);
            AppMethodBeat.m2505o(32436);
            return;
        }
        this.yUP.setEnabled(true);
        this.yUQ.setEnabled(true);
        this.yUR.setEnabled(true);
        this.yUS.setEnabled(true);
        AppMethodBeat.m2505o(32436);
    }

    /* renamed from: y */
    private void m61366y(boolean z, String str) {
        AppMethodBeat.m2504i(32437);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            CharSequence str2;
            if (str2 == null) {
                str2 = getString(C25738R.string.cn5);
            }
            this.kvA = C44275p.m79966b(this, str2, true, null);
            AppMethodBeat.m2505o(32437);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.m2505o(32437);
    }
}
