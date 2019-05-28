package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.e.a.c;
import com.tencent.mm.ui.chatting.i.e;

public class MediaHistoryGalleryUI extends MMActivity implements OnClickListener, b {
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
    private com.tencent.matrix.trace.e.b mnM = new com.tencent.matrix.trace.e.b() {
        public final void a(String str, long j, int i) {
            AppMethodBeat.i(32405);
            super.a(str, j, i);
            if (i > 0 && !bo.isNullOrNil(str) && str.endsWith(MediaHistoryGalleryUI.this.getClass().getSimpleName())) {
                MediaHistoryGalleryUI.this.eEO = MediaHistoryGalleryUI.this.eEO + ((long) i);
            }
            AppMethodBeat.o(32405);
        }
    };
    private long yNB;
    private View yUN;
    private View yUP;
    private View yUQ;
    private View yUR;
    private View yUS;
    private com.tencent.mm.ui.chatting.e.a.a yXO;
    private boolean yXP;
    private boolean yXQ;
    private boolean yXR;

    static class a {
        public static com.tencent.mm.ui.chatting.e.a.a a(Context context, c cVar) {
            AppMethodBeat.i(32416);
            com.tencent.mm.ui.chatting.e.a.a aVar = null;
            switch (AnonymousClass7.yXU[cVar.ordinal()]) {
                case 1:
                    aVar = new e(context);
                    break;
            }
            AppMethodBeat.o(32416);
            return aVar;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$7 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] yXU = new int[c.values().length];

        static {
            AppMethodBeat.i(32415);
            try {
                yXU[c.yTC.ordinal()] = 1;
                AppMethodBeat.o(32415);
            } catch (NoSuchFieldError e) {
                AppMethodBeat.o(32415);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MediaHistoryGalleryUI() {
        AppMethodBeat.i(32417);
        AppMethodBeat.o(32417);
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.ui.chatting.e.a.a a;
        AppMethodBeat.i(32418);
        f.m(this);
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
                a = a.a(this, c.yTC);
                break;
            default:
                a = a.a(this, c.yTC);
                break;
        }
        a.a(this);
        xE(this.mController.ylL.getResources().getColor(R.color.l8));
        Nb(this.mController.ylL.getResources().getColor(R.color.l8));
        initView();
        this.yXO.s(true, this.mnL);
        f.n(this);
        AppMethodBeat.o(32418);
    }

    public void onResume() {
        AppMethodBeat.i(32419);
        this.fAq = bo.anT();
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.a(this.mnM);
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
        AppMethodBeat.o(32419);
    }

    public void onPause() {
        AppMethodBeat.i(32420);
        super.onPause();
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.ehv);
        this.ehv = 0;
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.b(this.mnM);
            }
        }
        this.fAq = bo.anT() > this.fAq ? bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.o(32420);
    }

    public void onDestroy() {
        AppMethodBeat.i(32421);
        super.onDestroy();
        this.yXO.onDetach();
        AppMethodBeat.o(32421);
    }

    public final void initView() {
        AppMethodBeat.i(32422);
        super.initView();
        dGJ();
        this.mnJ = (TextView) findViewById(R.id.bqy);
        this.emq = (TextView) findViewById(R.id.yi);
        this.aiB = (RecyclerView) findViewById(R.id.yj);
        this.aiB.setBackgroundColor(getResources().getColor(R.color.eg));
        findViewById(R.id.yh).setBackgroundColor(getResources().getColor(R.color.eg));
        this.aiB.setLayoutManager(this.yXO.bfC());
        this.aiB.a(this.yXO.dN(this));
        this.aiB.setAdapter(this.yXO.aT(this.emo, this.yNB));
        this.aiB.setHasFixedSize(true);
        this.aiB.setOnScrollListener(new m() {
            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(32406);
                super.a(recyclerView, i, i2);
                AppMethodBeat.o(32406);
            }
        });
        this.aiB.a(new m() {
            private Runnable kvR = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32407);
                    MediaHistoryGalleryUI.this.mnJ.startAnimation(AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.mController.ylL, R.anim.b6));
                    MediaHistoryGalleryUI.this.mnJ.setVisibility(8);
                    AppMethodBeat.o(32407);
                }
            };

            {
                AppMethodBeat.i(32408);
                AppMethodBeat.o(32408);
            }

            private void fQ(boolean z) {
                AppMethodBeat.i(32409);
                if (z) {
                    MediaHistoryGalleryUI.this.mnJ.removeCallbacks(this.kvR);
                    if (MediaHistoryGalleryUI.this.mnJ.getVisibility() != 0) {
                        MediaHistoryGalleryUI.this.mnJ.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.mController.ylL, R.anim.b5);
                        MediaHistoryGalleryUI.this.mnJ.setVisibility(0);
                        MediaHistoryGalleryUI.this.mnJ.startAnimation(loadAnimation);
                        AppMethodBeat.o(32409);
                        return;
                    }
                }
                MediaHistoryGalleryUI.this.mnJ.removeCallbacks(this.kvR);
                MediaHistoryGalleryUI.this.mnJ.postDelayed(this.kvR, 256);
                AppMethodBeat.o(32409);
            }

            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(32410);
                super.a(recyclerView, i, i2);
                com.tencent.mm.ui.chatting.a.b bVar = (com.tencent.mm.ui.chatting.a.b) MediaHistoryGalleryUI.this.yXO.bwx();
                com.tencent.mm.ui.chatting.a.b.c Ox = bVar.Ox(((LinearLayoutManager) MediaHistoryGalleryUI.this.yXO.bfC()).iQ());
                if (Ox == null) {
                    AppMethodBeat.o(32410);
                    return;
                }
                MediaHistoryGalleryUI.this.mnJ.setText(bo.bc(bVar.ha(Ox.timeStamp), ""));
                AppMethodBeat.o(32410);
            }

            public final void c(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(32411);
                if (1 == i) {
                    fQ(true);
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.this.ehv);
                    MediaHistoryGalleryUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, WXHardCoderJNI.hcMediaGalleryScrollDelay, WXHardCoderJNI.hcMediaGalleryScrollCPU, WXHardCoderJNI.hcMediaGalleryScrollIO, WXHardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
                } else if (i == 0) {
                    fQ(false);
                }
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    if (!(((LinearLayoutManager) recyclerView.getLayoutManager()).iQ() != 0 || MediaHistoryGalleryUI.this.kvO || MediaHistoryGalleryUI.this.yXO == null)) {
                        MediaHistoryGalleryUI.this.yXO.s(false, -1);
                    }
                    MediaHistoryGalleryUI.this.kvO = false;
                    o.ahp().cm(i);
                }
                AppMethodBeat.o(32411);
            }
        });
        setMMTitle(this.yXO.aoy());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(32412);
                MediaHistoryGalleryUI.this.finish();
                AppMethodBeat.o(32412);
                return true;
            }
        });
        AppMethodBeat.o(32422);
    }

    public final int getLayoutId() {
        return R.layout.acu;
    }

    public final void fO(boolean z) {
        AppMethodBeat.i(32423);
        if (z) {
            y(true, null);
            AppMethodBeat.o(32423);
            return;
        }
        this.kvP = ((GridLayoutManager) this.aiB.getLayoutManager()).iS();
        AppMethodBeat.o(32423);
    }

    public final void p(boolean z, int i) {
        AppMethodBeat.i(32424);
        ab.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.mnL));
        if (z) {
            y(false, null);
            this.aiB.getAdapter().aop.notifyChanged();
            if (this.mnL > 0) {
                if (this.mnL % 4 == 0) {
                    this.mnL++;
                }
                this.aiB.bY(Math.min(this.aiB.getAdapter().getItemCount() - 1, this.mnL));
            } else {
                this.aiB.bY(this.aiB.getAdapter().getItemCount() - 1);
            }
            if (i <= 0) {
                this.emq.setVisibility(0);
                this.aiB.setVisibility(8);
                this.emq.setText(getString(R.string.ano));
                AppMethodBeat.o(32424);
                return;
            }
            this.emq.setVisibility(8);
            this.aiB.setVisibility(0);
            AppMethodBeat.o(32424);
        } else if (i > 0) {
            this.aiB.getAdapter().at(0, i);
            this.aiB.getAdapter().ar(i, this.kvP + i);
            AppMethodBeat.o(32424);
        } else {
            this.aiB.getAdapter().cg(0);
            AppMethodBeat.o(32424);
        }
    }

    public final View getChildAt(int i) {
        AppMethodBeat.i(32425);
        View childAt = this.aiB.getChildAt(i);
        AppMethodBeat.o(32425);
        return childAt;
    }

    public final void vF(int i) {
        AppMethodBeat.i(32426);
        setMMTitle(getString(R.string.c47, new Object[]{Integer.valueOf(i)}));
        Ph(i);
        AppMethodBeat.o(32426);
    }

    public void onClick(View view) {
        AppMethodBeat.i(32427);
        this.yXO.vH(((Integer) view.getTag()).intValue());
        AppMethodBeat.o(32427);
    }

    private void dGJ() {
        AppMethodBeat.i(32428);
        this.yUN = findViewById(R.id.chp);
        this.yUQ = findViewById(R.id.bqw);
        this.yUS = findViewById(R.id.aw8);
        this.yUR = findViewById(R.id.chr);
        this.yUP = findViewById(R.id.chq);
        this.yUP.setTag(Integer.valueOf(1));
        this.yUQ.setTag(Integer.valueOf(0));
        this.yUR.setTag(Integer.valueOf(3));
        this.yUS.setTag(Integer.valueOf(2));
        this.yUP.setOnClickListener(this);
        this.yUQ.setOnClickListener(this);
        this.yUR.setOnClickListener(this);
        this.yUS.setOnClickListener(this);
        AppMethodBeat.o(32428);
    }

    public void onBackPressed() {
        AppMethodBeat.i(32429);
        super.onBackPressed();
        ab.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.yXR) {
            this.yXO.dFC();
            AppMethodBeat.o(32429);
            return;
        }
        finish();
        AppMethodBeat.o(32429);
    }

    public final void bwq() {
        AppMethodBeat.i(32430);
        this.yXO.bwq();
        setMMTitle(getString(R.string.c47, new Object[]{Integer.valueOf(this.yXO.dFB())}));
        this.yUN.setVisibility(0);
        this.yUN.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cg));
        Ph(this.yXO.dFB());
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.c38), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(32413);
                MediaHistoryGalleryUI.this.bwr();
                AppMethodBeat.o(32413);
                return true;
            }
        });
        AppMethodBeat.o(32430);
    }

    public final void bwr() {
        AppMethodBeat.i(32431);
        this.yXO.bwr();
        setMMTitle(this.yXO.aoy());
        this.yUN.setVisibility(8);
        this.yUN.startAnimation(AnimationUtils.loadAnimation(this, R.anim.ce));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.c39), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(32414);
                MediaHistoryGalleryUI.this.bwq();
                AppMethodBeat.o(32414);
                return true;
            }
        });
        AppMethodBeat.o(32431);
    }

    public final void dFD() {
        AppMethodBeat.i(32432);
        this.yXR = true;
        y(true, getString(R.string.cde));
        AppMethodBeat.o(32432);
    }

    public final void dFC() {
        AppMethodBeat.i(32433);
        bwr();
        this.yXR = false;
        y(false, "");
        AppMethodBeat.o(32433);
    }

    public final void dFE() {
        AppMethodBeat.i(32434);
        bwr();
        this.yXR = false;
        y(false, "");
        String str = com.tencent.mm.compatible.util.e.euR;
        Toast.makeText(this, getString(R.string.anp, new Object[]{str.substring(str.indexOf("tencent/MicroMsg"))}), 1).show();
        AppMethodBeat.o(32434);
    }

    public final void OI(int i) {
        AppMethodBeat.i(32435);
        bwr();
        y(false, "");
        if (i == 0) {
            i = R.string.c45;
        }
        if (this.yXR) {
            h.a((Context) this, i, (int) R.string.tz, true, null);
        }
        this.yXR = false;
        AppMethodBeat.o(32435);
    }

    public final boolean dFF() {
        return this.yXR;
    }

    private void Ph(int i) {
        AppMethodBeat.i(32436);
        if (!this.yXO.bwy() || i <= 0) {
            this.yUP.setEnabled(false);
            this.yUQ.setEnabled(false);
            this.yUR.setEnabled(false);
            this.yUS.setEnabled(false);
            AppMethodBeat.o(32436);
            return;
        }
        this.yUP.setEnabled(true);
        this.yUQ.setEnabled(true);
        this.yUR.setEnabled(true);
        this.yUS.setEnabled(true);
        AppMethodBeat.o(32436);
    }

    private void y(boolean z, String str) {
        AppMethodBeat.i(32437);
        ab.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            CharSequence str2;
            if (str2 == null) {
                str2 = getString(R.string.cn5);
            }
            this.kvA = p.b(this, str2, true, null);
            AppMethodBeat.o(32437);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.o(32437);
    }
}
