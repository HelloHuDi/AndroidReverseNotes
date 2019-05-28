package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Process;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p174e.C1153b;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C39072f.C39073c;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C45938g.C20746c;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C45938g.C43080b;
import com.tencent.p177mm.plugin.fav.p410ui.gallery.C45938g.C45937a;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c */
public final class C28023c implements C43080b {
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
    public C45937a mnI;
    TextView mnJ;
    public boolean mnK = false;
    public int mnL = -1;
    public C1153b mnM = new C280221();
    private TextView mnN;
    private TextView mnO;
    private OnClickListener mnP = new C280284();
    private OnClickListener mnQ = new C280265();
    private OnClickListener mnR = new C31066();
    public List<C20742d> mnS = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$6 */
    class C31066 implements OnClickListener {
        C31066() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74549);
            C28023c.this.mnI.mo65945vH(((Integer) view.getTag()).intValue());
            AppMethodBeat.m2505o(74549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$1 */
    class C280221 extends C1153b {
        C280221() {
        }

        /* renamed from: a */
        public final void mo4386a(String str, long j, int i) {
            AppMethodBeat.m2504i(74540);
            super.mo4386a(str, j, i);
            if (i > 0 && !C5046bo.isNullOrNil(str) && str.endsWith(C28023c.this.getClass().getSimpleName())) {
                C28023c.this.eEO += (long) i;
            }
            AppMethodBeat.m2505o(74540);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$3 */
    class C280243 extends C41530m {
        private Runnable kvR = new C280251();

        /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$3$1 */
        class C280251 implements Runnable {
            C280251() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74542);
                C28023c.this.mnJ.startAnimation(AnimationUtils.loadAnimation(C28023c.this.czX, C25738R.anim.f8333b6));
                C28023c.this.mnJ.setVisibility(8);
                AppMethodBeat.m2505o(74542);
            }
        }

        C280243() {
            AppMethodBeat.m2504i(74543);
            AppMethodBeat.m2505o(74543);
        }

        /* renamed from: fQ */
        private void m44583fQ(boolean z) {
            AppMethodBeat.m2504i(74544);
            if (z) {
                C28023c.this.mnJ.removeCallbacks(this.kvR);
                if (C28023c.this.mnJ.getVisibility() != 0) {
                    C28023c.this.mnJ.clearAnimation();
                    Animation loadAnimation = AnimationUtils.loadAnimation(C28023c.this.czX, C25738R.anim.f8332b5);
                    C28023c.this.mnJ.setVisibility(0);
                    C28023c.this.mnJ.startAnimation(loadAnimation);
                    AppMethodBeat.m2505o(74544);
                    return;
                }
            }
            C28023c.this.mnJ.removeCallbacks(this.kvR);
            C28023c.this.mnJ.postDelayed(this.kvR, 256);
            AppMethodBeat.m2505o(74544);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(74545);
            super.mo6642a(recyclerView, i, i2);
            C39072f c39072f = (C39072f) C28023c.this.mnI.bwx();
            C39073c vG = c39072f.mo61984vG(((LinearLayoutManager) C28023c.this.mnI.bfC()).mo1780iQ());
            if (vG == null) {
                AppMethodBeat.m2505o(74545);
                return;
            }
            C28023c.this.mnJ.setText(C5046bo.m7532bc(c39072f.mo61983ha(vG.timeStamp), ""));
            AppMethodBeat.m2505o(74545);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(74546);
            if (1 == i) {
                m44583fQ(true);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, C28023c.this.ehv);
                C28023c.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, WXHardCoderJNI.hcMediaGalleryScrollDelay, WXHardCoderJNI.hcMediaGalleryScrollCPU, WXHardCoderJNI.hcMediaGalleryScrollIO, WXHardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            } else if (i == 0) {
                m44583fQ(false);
            }
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                if (((LinearLayoutManager) recyclerView.getLayoutManager()).mo1780iQ() == 0 && !C28023c.this.kvO) {
                    C28023c.this.mnI.mo65944s(false, -1);
                }
                C28023c.this.kvO = false;
                C32291o.ahp().mo43773cm(i);
            }
            AppMethodBeat.m2505o(74546);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$5 */
    class C280265 implements OnClickListener {
        C280265() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74548);
            C28023c.this.bwr();
            AppMethodBeat.m2505o(74548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$2 */
    class C280272 extends C41530m {
        C280272() {
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(74541);
            super.mo6642a(recyclerView, i, i2);
            AppMethodBeat.m2505o(74541);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.c$4 */
    class C280284 implements OnClickListener {
        C280284() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74547);
            C28023c.this.bwq();
            AppMethodBeat.m2505o(74547);
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo36044a(C43079a c43079a) {
        this.mnI = (C45937a) c43079a;
    }

    public C28023c(Activity activity, View view) {
        AppMethodBeat.m2504i(74551);
        this.czX = activity;
        this.jWH = view;
        this.mnK = true;
        C45937a c45937a = null;
        switch (C20746c.mou) {
            case mou:
                c45937a = new C41277h(activity);
                break;
        }
        c45937a.mo65934a(this);
        this.mnG = new abh();
        this.mnG.scene = 2;
        this.mnG.jSW = 2;
        this.mnG.index = 0;
        this.mnG.cvF = "";
        this.mnG.query = "";
        this.mnG.mfg = "";
        this.mnN = (TextView) this.jWH.findViewById(2131823944);
        this.mnN.setTag(Integer.valueOf(0));
        this.mnN.setOnClickListener(this.mnR);
        this.mnO = (TextView) this.jWH.findViewById(2131823945);
        this.mnO.setOnClickListener(this.mnP);
        this.mnJ = (TextView) this.jWH.findViewById(2131823946);
        this.emq = (TextView) this.jWH.findViewById(2131821477);
        this.aiB = (RecyclerView) this.jWH.findViewById(2131821478);
        this.aiB.setLayoutManager(this.mnI.bfC());
        this.aiB.mo66346b(this.mnI.mo65941dN(this.czX));
        this.aiB.setAdapter(this.mnI.bfB());
        ((C39072f) this.mnI.bwx()).mnG = this.mnG;
        this.aiB.setHasFixedSize(true);
        this.aiB.setOnScrollListener(new C280272());
        this.aiB.mo66332a(new C280243());
        AppMethodBeat.m2505o(74551);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(74552);
        this.jWH.setVisibility(i);
        AppMethodBeat.m2505o(74552);
    }

    /* renamed from: fO */
    public final void mo45951fO(boolean z) {
        AppMethodBeat.m2504i(74553);
        if (z) {
            m44577fP(true);
            AppMethodBeat.m2505o(74553);
            return;
        }
        this.kvP = ((GridLayoutManager) this.aiB.getLayoutManager()).mo1782iS();
        AppMethodBeat.m2505o(74553);
    }

    /* renamed from: p */
    public final void mo45952p(boolean z, int i) {
        AppMethodBeat.m2504i(74554);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.mnL));
        if (z) {
            m44577fP(false);
            this.aiB.getAdapter().aop.notifyChanged();
            if (this.mnL > 0) {
                if (this.mnL % 4 == 0) {
                    this.mnL++;
                }
                this.aiB.mo61465bY(this.mnL);
            } else {
                this.aiB.mo61465bY(this.aiB.getAdapter().getItemCount() - 1);
            }
            if (i <= 0) {
                this.emq.setVisibility(0);
                this.aiB.setVisibility(8);
                this.emq.setText(this.czX.getString(C25738R.string.bnd));
                AppMethodBeat.m2505o(74554);
                return;
            }
            this.emq.setVisibility(8);
            this.aiB.setVisibility(0);
            AppMethodBeat.m2505o(74554);
        } else if (i > 0) {
            this.aiB.getAdapter().aop.notifyChanged();
            AppMethodBeat.m2505o(74554);
        } else {
            this.aiB.getAdapter().mo66316cg(0);
            AppMethodBeat.m2505o(74554);
        }
    }

    /* renamed from: vF */
    public final void mo45954vF(int i) {
        AppMethodBeat.m2504i(74555);
        if (i > 0) {
            this.mnN.setText(this.czX.getString(C25738R.string.exz) + "(" + i + ")");
            AppMethodBeat.m2505o(74555);
            return;
        }
        this.mnN.setText(this.czX.getString(C25738R.string.exz));
        AppMethodBeat.m2505o(74555);
    }

    public final void bwq() {
        AppMethodBeat.m2504i(74556);
        this.mnI.bwq();
        this.mnO.setText(C25738R.string.bnc);
        this.mnN.setText(this.czX.getString(C25738R.string.exz));
        this.mnN.setVisibility(0);
        this.mnO.setOnClickListener(this.mnQ);
        AppMethodBeat.m2505o(74556);
    }

    public final void bwr() {
        AppMethodBeat.m2504i(74557);
        this.mnI.bwr();
        this.mnO.setText(C25738R.string.bne);
        this.mnN.setVisibility(8);
        this.mnO.setOnClickListener(this.mnP);
        AppMethodBeat.m2505o(74557);
    }

    /* renamed from: bS */
    public final void mo45948bS(List<C20742d> list) {
        AppMethodBeat.m2504i(74558);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(74558);
            return;
        }
        C20742d c20742d;
        this.mnS.clear();
        this.mnS.addAll(list);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        if (this.mnS.size() == 1) {
            int i;
            c20742d = (C20742d) list.get(0);
            String c = C39037b.m66379c(c20742d.cAJ);
            String b = C39037b.m66370b(c20742d.cAJ);
            if (C1173e.m2561ct(c)) {
                intent.putExtra("image_path", c);
            } else {
                intent.putExtra("image_path", b);
            }
            if (c20742d.bwt() || c20742d.bws()) {
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
        C25985d.m41466b(this.czX, ".ui.transmit.SelectConversationUI", intent, 1);
        for (C20742d c20742d2 : list) {
            C27968h.m44531j(c20742d2.mnW.field_localId, 1, 0);
        }
        AppMethodBeat.m2505o(74558);
    }

    /* renamed from: fP */
    private void m44577fP(boolean z) {
        AppMethodBeat.m2504i(74559);
        C4990ab.m7417i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.kvA = C44275p.m79966b(this.czX, this.czX.getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(74559);
            return;
        }
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
            this.kvA = null;
        }
        AppMethodBeat.m2505o(74559);
    }
}
