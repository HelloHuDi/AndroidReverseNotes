package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.gallery.g.a;
import com.tencent.mm.plugin.fav.ui.gallery.g.b;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    private RecyclerView aiB;
    Activity czX;
    public long eEO = 0;
    public int ehv;
    private TextView emq;
    public long fAq = 0;
    public View jWH;
    private ProgressDialog kvA;
    boolean kvO = true;
    private int kvP;
    private abh mnG;
    public a mnI;
    TextView mnJ;
    public boolean mnK = false;
    public int mnL = -1;
    public com.tencent.matrix.trace.e.b mnM = new com.tencent.matrix.trace.e.b() {
        public final void a(String str, long j, int i) {
            AppMethodBeat.i(74540);
            super.a(str, j, i);
            if (i > 0 && !bo.isNullOrNil(str) && str.endsWith(c.this.getClass().getSimpleName())) {
                c.this.eEO += (long) i;
            }
            AppMethodBeat.o(74540);
        }
    };
    private TextView mnN;
    private TextView mnO;
    private OnClickListener mnP = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74547);
            c.this.bwq();
            AppMethodBeat.o(74547);
        }
    };
    private OnClickListener mnQ = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74548);
            c.this.bwr();
            AppMethodBeat.o(74548);
        }
    };
    private OnClickListener mnR = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74549);
            c.this.mnI.vH(((Integer) view.getTag()).intValue());
            AppMethodBeat.o(74549);
        }
    };
    public List<d> mnS = new ArrayList();

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        this.mnI = (a) aVar;
    }

    public c(Activity activity, View view) {
        AppMethodBeat.i(74551);
        this.czX = activity;
        this.jWH = view;
        this.mnK = true;
        a aVar = null;
        switch (com.tencent.mm.plugin.fav.ui.gallery.g.c.mou) {
            case mou:
                aVar = new h(activity);
                break;
        }
        aVar.a(this);
        this.mnG = new abh();
        this.mnG.scene = 2;
        this.mnG.jSW = 2;
        this.mnG.index = 0;
        this.mnG.cvF = "";
        this.mnG.query = "";
        this.mnG.mfg = "";
        this.mnN = (TextView) this.jWH.findViewById(R.id.bqw);
        this.mnN.setTag(Integer.valueOf(0));
        this.mnN.setOnClickListener(this.mnR);
        this.mnO = (TextView) this.jWH.findViewById(R.id.bqx);
        this.mnO.setOnClickListener(this.mnP);
        this.mnJ = (TextView) this.jWH.findViewById(R.id.bqy);
        this.emq = (TextView) this.jWH.findViewById(R.id.yi);
        this.aiB = (RecyclerView) this.jWH.findViewById(R.id.yj);
        this.aiB.setLayoutManager(this.mnI.bfC());
        this.aiB.b(this.mnI.dN(this.czX));
        this.aiB.setAdapter(this.mnI.bfB());
        ((f) this.mnI.bwx()).mnG = this.mnG;
        this.aiB.setHasFixedSize(true);
        this.aiB.setOnScrollListener(new m() {
            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(74541);
                super.a(recyclerView, i, i2);
                AppMethodBeat.o(74541);
            }
        });
        this.aiB.a(new m() {
            private Runnable kvR = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74542);
                    c.this.mnJ.startAnimation(AnimationUtils.loadAnimation(c.this.czX, R.anim.b6));
                    c.this.mnJ.setVisibility(8);
                    AppMethodBeat.o(74542);
                }
            };

            {
                AppMethodBeat.i(74543);
                AppMethodBeat.o(74543);
            }

            private void fQ(boolean z) {
                AppMethodBeat.i(74544);
                if (z) {
                    c.this.mnJ.removeCallbacks(this.kvR);
                    if (c.this.mnJ.getVisibility() != 0) {
                        c.this.mnJ.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(c.this.czX, R.anim.b5);
                        c.this.mnJ.setVisibility(0);
                        c.this.mnJ.startAnimation(loadAnimation);
                        AppMethodBeat.o(74544);
                        return;
                    }
                }
                c.this.mnJ.removeCallbacks(this.kvR);
                c.this.mnJ.postDelayed(this.kvR, 256);
                AppMethodBeat.o(74544);
            }

            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(74545);
                super.a(recyclerView, i, i2);
                f fVar = (f) c.this.mnI.bwx();
                com.tencent.mm.plugin.fav.ui.gallery.f.c vG = fVar.vG(((LinearLayoutManager) c.this.mnI.bfC()).iQ());
                if (vG == null) {
                    AppMethodBeat.o(74545);
                    return;
                }
                c.this.mnJ.setText(bo.bc(fVar.ha(vG.timeStamp), ""));
                AppMethodBeat.o(74545);
            }

            public final void c(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(74546);
                if (1 == i) {
                    fQ(true);
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.ehv);
                    c.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, WXHardCoderJNI.hcMediaGalleryScrollDelay, WXHardCoderJNI.hcMediaGalleryScrollCPU, WXHardCoderJNI.hcMediaGalleryScrollIO, WXHardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
                } else if (i == 0) {
                    fQ(false);
                }
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) recyclerView.getLayoutManager()).iQ() == 0 && !c.this.kvO) {
                        c.this.mnI.s(false, -1);
                    }
                    c.this.kvO = false;
                    o.ahp().cm(i);
                }
                AppMethodBeat.o(74546);
            }
        });
        AppMethodBeat.o(74551);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(74552);
        this.jWH.setVisibility(i);
        AppMethodBeat.o(74552);
    }

    public final void fO(boolean z) {
        AppMethodBeat.i(74553);
        if (z) {
            fP(true);
            AppMethodBeat.o(74553);
            return;
        }
        this.kvP = ((GridLayoutManager) this.aiB.getLayoutManager()).iS();
        AppMethodBeat.o(74553);
    }

    public final void p(boolean z, int i) {
        AppMethodBeat.i(74554);
        ab.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.mnL));
        if (z) {
            fP(false);
            this.aiB.getAdapter().aop.notifyChanged();
            if (this.mnL > 0) {
                if (this.mnL % 4 == 0) {
                    this.mnL++;
                }
                this.aiB.bY(this.mnL);
            } else {
                this.aiB.bY(this.aiB.getAdapter().getItemCount() - 1);
            }
            if (i <= 0) {
                this.emq.setVisibility(0);
                this.aiB.setVisibility(8);
                this.emq.setText(this.czX.getString(R.string.bnd));
                AppMethodBeat.o(74554);
                return;
            }
            this.emq.setVisibility(8);
            this.aiB.setVisibility(0);
            AppMethodBeat.o(74554);
        } else if (i > 0) {
            this.aiB.getAdapter().aop.notifyChanged();
            AppMethodBeat.o(74554);
        } else {
            this.aiB.getAdapter().cg(0);
            AppMethodBeat.o(74554);
        }
    }

    public final void vF(int i) {
        AppMethodBeat.i(74555);
        if (i > 0) {
            this.mnN.setText(this.czX.getString(R.string.exz) + "(" + i + ")");
            AppMethodBeat.o(74555);
            return;
        }
        this.mnN.setText(this.czX.getString(R.string.exz));
        AppMethodBeat.o(74555);
    }

    public final void bwq() {
        AppMethodBeat.i(74556);
        this.mnI.bwq();
        this.mnO.setText(R.string.bnc);
        this.mnN.setText(this.czX.getString(R.string.exz));
        this.mnN.setVisibility(0);
        this.mnO.setOnClickListener(this.mnQ);
        AppMethodBeat.o(74556);
    }

    public final void bwr() {
        AppMethodBeat.i(74557);
        this.mnI.bwr();
        this.mnO.setText(R.string.bne);
        this.mnN.setVisibility(8);
        this.mnO.setOnClickListener(this.mnP);
        AppMethodBeat.o(74557);
    }

    public final void bS(List<d> list) {
        AppMethodBeat.i(74558);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(74558);
            return;
        }
        d dVar;
        this.mnS.clear();
        this.mnS.addAll(list);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        if (this.mnS.size() == 1) {
            int i;
            dVar = (d) list.get(0);
            String c = com.tencent.mm.plugin.fav.a.b.c(dVar.cAJ);
            String b = com.tencent.mm.plugin.fav.a.b.b(dVar.cAJ);
            if (e.ct(c)) {
                intent.putExtra("image_path", c);
            } else {
                intent.putExtra("image_path", b);
            }
            if (dVar.bwt() || dVar.bws()) {
                i = 1;
            } else {
                i = 0;
            }
            intent.putExtra("Retr_Msg_Type", i);
            intent.putExtra("select_is_ret", true);
        } else {
            intent.putExtra("scene_from", 1);
            intent.putExtra("Retr_Msg_Type", 17);
            intent.putExtra("select_fav_select_count", this.mnS.size());
        }
        d.b(this.czX, ".ui.transmit.SelectConversationUI", intent, 1);
        for (d dVar2 : list) {
            h.j(dVar2.mnW.field_localId, 1, 0);
        }
        AppMethodBeat.o(74558);
    }

    private void fP(boolean z) {
        AppMethodBeat.i(74559);
        ab.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = p.b(this.czX, this.czX.getString(R.string.cn5), true, null);
            AppMethodBeat.o(74559);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.o(74559);
    }
}
