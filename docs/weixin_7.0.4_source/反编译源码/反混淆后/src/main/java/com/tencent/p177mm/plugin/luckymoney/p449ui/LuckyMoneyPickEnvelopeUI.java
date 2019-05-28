package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5510e.C5499f;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.luckymoney.model.C21199b;
import com.tencent.p177mm.plugin.luckymoney.model.C46059c;
import com.tencent.p177mm.plugin.luckymoney.model.C46061f;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyEnvelopeTouchRecyclerView.C21222a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a.C12406a;
import com.tencent.p177mm.plugin.luckymoney.scaledLayout.C34452a;
import com.tencent.p177mm.plugin.luckymoney.scaledLayout.C34457d;
import com.tencent.p177mm.plugin.luckymoney.scaledLayout.C39325c;
import com.tencent.p177mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40576ty;
import com.tencent.p177mm.protocal.protobuf.aoj;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.p649c.C44421a.C40926a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@C5271a(1)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI */
public class LuckyMoneyPickEnvelopeUI extends MMActivity {
    /* renamed from: Ek */
    private View f15058Ek;
    private Dialog gII;
    private boolean isLoading = false;
    private int nSY = 0;
    private View oaV;
    private LuckyMoneyEnvelopeTouchRecyclerView ogP;
    private C28443a ogQ;
    private C39325c ogR;
    private List<C28447b> ogS = new ArrayList();
    private int ogT = -1;
    private boolean ogU = false;
    private String ogV;
    private C34452a ogW;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$13 */
    class C2123813 implements Runnable {
        C2123813() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42913);
            if (LuckyMoneyPickEnvelopeUI.this.ogT >= 0 && LuckyMoneyPickEnvelopeUI.this.ogT < LuckyMoneyPickEnvelopeUI.this.ogQ.getItemCount()) {
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.ogT));
                LuckyMoneyEnvelopeTouchRecyclerView m = LuckyMoneyPickEnvelopeUI.this.ogP;
                C39325c c = LuckyMoneyPickEnvelopeUI.this.ogR;
                int qY = c.mo36594qY(LuckyMoneyPickEnvelopeUI.this.ogT);
                if (c.mOrientation == 1) {
                    m.scrollBy(0, qY);
                    AppMethodBeat.m2505o(42913);
                    return;
                }
                m.scrollBy(qY, 0);
            }
            AppMethodBeat.m2505o(42913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$6 */
    class C284416 implements OnMenuItemClickListener {
        C284416() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            String str;
            AppMethodBeat.m2504i(42906);
            C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.ogT));
            String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (LuckyMoneyPickEnvelopeUI.this.ogT >= 0 && LuckyMoneyPickEnvelopeUI.this.ogT < LuckyMoneyPickEnvelopeUI.this.ogS.size()) {
                C28447b c28447b = (C28447b) LuckyMoneyPickEnvelopeUI.this.ogS.get(LuckyMoneyPickEnvelopeUI.this.ogT);
                if (c28447b.kfW && c28447b.nZq != null) {
                    str = c28447b.nZq.materialId;
                    LuckyMoneyPickEnvelopeUI.m56536a(LuckyMoneyPickEnvelopeUI.this, str);
                    C7060h.pYm.mo8381e(16822, Integer.valueOf(3));
                    AppMethodBeat.m2505o(42906);
                    return false;
                }
            }
            str = str2;
            LuckyMoneyPickEnvelopeUI.m56536a(LuckyMoneyPickEnvelopeUI.this, str);
            C7060h.pYm.mo8381e(16822, Integer.valueOf(3));
            AppMethodBeat.m2505o(42906);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$8 */
    class C284428 implements C21222a {
        C284428() {
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(42908);
            if (motionEvent.getAction() == 0) {
                LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI = LuckyMoneyPickEnvelopeUI.this;
                LuckyMoneyPickEnvelopeUI.this.ogW;
                luckyMoneyPickEnvelopeUI.oaV = C34452a.m56457h(LuckyMoneyPickEnvelopeUI.this.ogR);
                LuckyMoneyPickEnvelopeUI.this.ogW.oaV = LuckyMoneyPickEnvelopeUI.this.oaV;
            }
            AppMethodBeat.m2505o(42908);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$a */
    class C28443a extends C41523a<C28448c> {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$a$1 */
        class C284441 implements OnClickListener {
            C284441() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(42914);
                LuckyMoneyPickEnvelopeUI.this.ogP;
                int bo = RecyclerView.m72547bo(view);
                LuckyMoneyPickEnvelopeUI.this.ogW;
                if (C34452a.m56457h(LuckyMoneyPickEnvelopeUI.this.ogR) != view) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to target view");
                    LuckyMoneyEnvelopeTouchRecyclerView m = LuckyMoneyPickEnvelopeUI.this.ogP;
                    C17480i layoutManager = m.getLayoutManager();
                    if (layoutManager instanceof ViewPagerLayoutManager) {
                        int i;
                        ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) layoutManager;
                        for (int i2 = 0; i2 < viewPagerLayoutManager.obh.size(); i2++) {
                            int keyAt = viewPagerLayoutManager.obh.keyAt(i2);
                            if (((View) viewPagerLayoutManager.obh.get(keyAt)) == view) {
                                i = keyAt;
                                break;
                            }
                        }
                        i = -1;
                        C34457d.m56483a(m, (ViewPagerLayoutManager) layoutManager, i);
                    }
                }
                C4990ab.m7411d("MicroMsg.LuckyMoneyPickEnvelopeUI", "touch pos: %s", Integer.valueOf(bo));
                if (bo >= 0 && bo < LuckyMoneyPickEnvelopeUI.this.ogS.size()) {
                    C28447b c28447b = (C28447b) LuckyMoneyPickEnvelopeUI.this.ogS.get(bo);
                    if (c28447b.nZq == null || c28447b.nZq.wwS != 1) {
                        if (c28447b.kfW) {
                            c28447b.kfW = false;
                            LuckyMoneyPickEnvelopeUI.this.ogT = -1;
                        } else {
                            C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", Integer.valueOf(bo));
                            if (LuckyMoneyPickEnvelopeUI.this.ogT >= 0) {
                                ((C28447b) LuckyMoneyPickEnvelopeUI.this.ogS.get(LuckyMoneyPickEnvelopeUI.this.ogT)).kfW = false;
                                LuckyMoneyPickEnvelopeUI.this.ogQ.mo66316cg(LuckyMoneyPickEnvelopeUI.this.ogT);
                            }
                            c28447b.kfW = true;
                            LuckyMoneyPickEnvelopeUI.this.ogT = bo;
                            LuckyMoneyPickEnvelopeUI.this.ogQ.mo66316cg(LuckyMoneyPickEnvelopeUI.this.ogT);
                        }
                        LuckyMoneyPickEnvelopeUI.this.enableOptionMenu(1, true);
                        LuckyMoneyPickEnvelopeUI.this.ogP.getAdapter().aop.notifyChanged();
                    } else {
                        C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", Integer.valueOf(bo));
                        AppMethodBeat.m2505o(42914);
                        return;
                    }
                }
                AppMethodBeat.m2505o(42914);
            }
        }

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$a$2 */
        class C284452 implements OnLongClickListener {

            /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$a$2$1 */
            class C284461 implements C36073c {
                C284461() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(42915);
                    c44273l.mo70048a(0, LuckyMoneyPickEnvelopeUI.this.getResources().getColor(C25738R.color.f11671ct), LuckyMoneyPickEnvelopeUI.this.getString(C25738R.string.g7u));
                    AppMethodBeat.m2505o(42915);
                }
            }

            C284452() {
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(42917);
                if (LuckyMoneyPickEnvelopeUI.this.ogU) {
                    LuckyMoneyPickEnvelopeUI.this.ogP;
                    int bo = RecyclerView.m72547bo(view);
                    LuckyMoneyPickEnvelopeUI.this.ogW;
                    View h = C34452a.m56457h(LuckyMoneyPickEnvelopeUI.this.ogR);
                    C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", Integer.valueOf(bo));
                    if (bo >= 0 && bo < LuckyMoneyPickEnvelopeUI.this.ogS.size() && view == h) {
                        final C28447b c28447b = (C28447b) LuckyMoneyPickEnvelopeUI.this.ogS.get(bo);
                        if (!(c28447b == null || c28447b.nZq == null)) {
                            C36356d c36356d = new C36356d(LuckyMoneyPickEnvelopeUI.this.mController.ylL, 1, true);
                            TextView textView = new TextView(LuckyMoneyPickEnvelopeUI.this.mController.ylL);
                            textView.setPadding(0, 0, 0, C1338a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.mController.ylL, 9));
                            textView.setMinHeight(C1338a.m2856al(LuckyMoneyPickEnvelopeUI.this.mController.ylL, C25738R.dimen.f9737e3));
                            textView.setTextSize(14.0f);
                            textView.setTextColor(LuckyMoneyPickEnvelopeUI.this.getResources().getColor(C25738R.color.f12084rr));
                            textView.setText(C25738R.string.g7v);
                            textView.setGravity(81);
                            c36356d.mo57234F(textView, true);
                            c36356d.rBl = new C284461();
                            c36356d.rBm = new C5279d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    AppMethodBeat.m2504i(42916);
                                    if (menuItem.getItemId() == 0) {
                                        LuckyMoneyPickEnvelopeUI.m56547e(LuckyMoneyPickEnvelopeUI.this, c28447b.nZq.materialId);
                                    }
                                    AppMethodBeat.m2505o(42916);
                                }
                            };
                            c36356d.cpD();
                        }
                    }
                }
                AppMethodBeat.m2505o(42917);
                return false;
            }
        }

        private C28443a() {
        }

        /* synthetic */ C28443a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, byte b) {
            this();
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(42918);
            int size = LuckyMoneyPickEnvelopeUI.this.ogS.size();
            AppMethodBeat.m2505o(42918);
            return size;
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(42919);
            long hashCode = (long) ((C28447b) LuckyMoneyPickEnvelopeUI.this.ogS.get(i)).hashCode();
            AppMethodBeat.m2505o(42919);
            return hashCode;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$b */
    static class C28447b {
        public boolean kfW;
        public atb nZq;

        private C28447b() {
            this.kfW = false;
        }

        /* synthetic */ C28447b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$c */
    class C28448c extends C41531v {
        ImageView eks;
        private Dialog gII = null;
        TextView gtb;
        TextView hrg;
        TextView jXx;
        ImageView ohc;
        RadioButton ohd;
        View ohe;
        ImageView ohf;
        ProgressBar ohg;
        TextView ohh;

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$c$2 */
        class C34232 implements C12406a {
            C34232() {
            }

            /* renamed from: iH */
            public final void mo7846iH(final boolean z) {
                AppMethodBeat.m2504i(42924);
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", Boolean.valueOf(z));
                C34241 c34241 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42923);
                        if (C28448c.this.gII != null && C28448c.this.gII.isShowing()) {
                            C28448c.this.gII.dismiss();
                        }
                        if (z) {
                            C28448c.this.ohe.setVisibility(8);
                            AppMethodBeat.m2505o(42923);
                            return;
                        }
                        C28448c.this.ohe.setVisibility(0);
                        C28448c.this.ohf.setVisibility(0);
                        C28448c.this.ohg.setVisibility(8);
                        C28448c.this.ohh.setVisibility(0);
                        AppMethodBeat.m2505o(42923);
                    }
                };
                if (C5004al.isMainThread()) {
                    c34241.run();
                    AppMethodBeat.m2505o(42924);
                    return;
                }
                C28448c.this.ohe.post(c34241);
                AppMethodBeat.m2505o(42924);
            }
        }

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$c$1 */
        class C212411 implements OnClickListener {
            final /* synthetic */ C28447b ohb;

            C212411(C28447b c28447b) {
                this.ohb = c28447b;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(42922);
                C28448c.m45132a(C28448c.this, this.ohb.nZq);
                AppMethodBeat.m2505o(42922);
            }
        }

        public C28448c(View view) {
            super(view);
            AppMethodBeat.m2504i(42925);
            this.ohc = (ImageView) view.findViewById(2131825600);
            this.gtb = (TextView) view.findViewById(2131825605);
            this.hrg = (TextView) view.findViewById(2131825607);
            this.ohd = (RadioButton) view.findViewById(2131825606);
            this.eks = (ImageView) view.findViewById(2131825602);
            this.jXx = (TextView) view.findViewById(2131825603);
            this.ohe = view.findViewById(2131825608);
            this.ohf = (ImageView) view.findViewById(2131825609);
            this.ohg = (ProgressBar) view.findViewById(2131825610);
            this.ohh = (TextView) view.findViewById(2131825611);
            AppMethodBeat.m2505o(42925);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo46428a(atb atb, boolean z) {
            AppMethodBeat.m2504i(42926);
            C4990ab.m7416i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try load cover image");
            if (z) {
                this.ohf.setVisibility(8);
                this.ohg.setVisibility(0);
                this.ohh.setVisibility(8);
            }
            ((C12405a) C1720g.m3528K(C12405a.class)).mo24255a(this.ohc, atb, new C34232());
            AppMethodBeat.m2505o(42926);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$9 */
    class C344899 extends C41530m {
        C344899() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(42909);
            super.mo6643c(recyclerView, i);
            AppMethodBeat.m2505o(42909);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(42910);
            super.mo6642a(recyclerView, i, i2);
            C4990ab.m7419v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.ogR.mo1782iS()));
            if (!LuckyMoneyPickEnvelopeUI.this.isLoading && LuckyMoneyPickEnvelopeUI.this.nSY == 1 && r0 == LuckyMoneyPickEnvelopeUI.this.ogQ.getItemCount() - 1) {
                C4990ab.m7411d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", Integer.valueOf(r0));
                LuckyMoneyPickEnvelopeUI.m56551i(LuckyMoneyPickEnvelopeUI.this);
            }
            AppMethodBeat.m2505o(42910);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$10 */
    class C3449010 implements OnCancelListener {
        C3449010() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$11 */
    class C3449111 implements C40926a<aoj> {
        C3449111() {
        }

        /* renamed from: bX */
        public final /* synthetic */ void mo9356bX(Object obj) {
            AppMethodBeat.m2504i(42911);
            aoj aoj = (aoj) obj;
            if (LuckyMoneyPickEnvelopeUI.this.gII != null && LuckyMoneyPickEnvelopeUI.this.gII.isShowing()) {
                LuckyMoneyPickEnvelopeUI.this.gII.dismiss();
            }
            LuckyMoneyPickEnvelopeUI.this.isLoading = false;
            C4990ab.m7416i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source net callback");
            if (aoj != null) {
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(aoj.kCl));
                if (aoj.kCl == 0) {
                    LuckyMoneyPickEnvelopeUI.this.nSY = aoj.wsC;
                    LuckyMoneyPickEnvelopeUI.this.ogV = aoj.wsB;
                    C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "hasMore: %s, pagedata: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.nSY), LuckyMoneyPickEnvelopeUI.this.ogV);
                    LuckyMoneyPickEnvelopeUI.m56535a(LuckyMoneyPickEnvelopeUI.this, aoj);
                    AppMethodBeat.m2505o(42911);
                    return;
                }
                C36391e.atC(aoj.kCm);
                AppMethodBeat.m2505o(42911);
                return;
            }
            C36391e.m59994aj(LuckyMoneyPickEnvelopeUI.this.mController.ylL, "");
            AppMethodBeat.m2505o(42911);
        }

        /* renamed from: bY */
        public final /* synthetic */ void mo9357bY(Object obj) {
            AppMethodBeat.m2504i(42912);
            aoj aoj = (aoj) obj;
            if (LuckyMoneyPickEnvelopeUI.this.gII != null && LuckyMoneyPickEnvelopeUI.this.gII.isShowing()) {
                LuckyMoneyPickEnvelopeUI.this.gII.dismiss();
            }
            C4990ab.m7416i("MicroMsg.LuckyMoneyPickEnvelopeUI", "get show source cache callback");
            if (aoj != null) {
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(aoj.kCl));
                if (aoj.kCl == 0) {
                    LuckyMoneyPickEnvelopeUI.m56535a(LuckyMoneyPickEnvelopeUI.this, aoj);
                }
            }
            AppMethodBeat.m2505o(42912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$12 */
    class C3449212 implements DialogInterface.OnClickListener {
        C3449212() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$1 */
    class C344931 implements OnMenuItemClickListener {
        C344931() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42902);
            LuckyMoneyPickEnvelopeUI.this.finish();
            AppMethodBeat.m2505o(42902);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$2 */
    class C344942 implements OnCancelListener {
        C344942() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI$4 */
    class C344964 implements OnCancelListener {
        C344964() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyPickEnvelopeUI() {
        AppMethodBeat.m2504i(42928);
        AppMethodBeat.m2505o(42928);
    }

    /* renamed from: i */
    static /* synthetic */ void m56551i(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI) {
        AppMethodBeat.m2504i(42936);
        luckyMoneyPickEnvelopeUI.bMJ();
        AppMethodBeat.m2505o(42936);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42930);
        this.ogP = (LuckyMoneyEnvelopeTouchRecyclerView) findViewById(2131825612);
        this.f15058Ek = findViewById(2131825613);
        this.ogQ = new C28443a(this, (byte) 0);
        this.ogQ.mo66319jR();
        this.ogP.setAdapter(this.ogQ);
        this.ogP.setItemAnimator(null);
        this.ogP.setItemViewCacheSize(-1);
        this.ogR = new C39325c(this) {
            public final void bLV() {
                AppMethodBeat.m2504i(42907);
                super.bLV();
                this.obq -= 31.0f;
                AppMethodBeat.m2505o(42907);
            }
        };
        this.ogR.bLS();
        this.ogP.setLayoutManager(this.ogR);
        this.ogW = new C34452a();
        this.ogW.context = this;
        this.ogW.mo42393i(this.ogP);
        this.ogP.oeF = new C284428();
        this.ogP.mo66332a((C41530m) new C344899());
        AppMethodBeat.m2505o(42930);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42931);
        super.onDestroy();
        AppMethodBeat.m2505o(42931);
    }

    public final int getLayoutId() {
        return 2130969993;
    }

    private void bMJ() {
        AppMethodBeat.m2504i(42932);
        C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s", this.ogV);
        this.gII = C30379h.m48426a(this.mController.ylL, 3, (int) C25738R.style.f10970kd, getString(C25738R.string.cn5), false, new C3449010());
        this.isLoading = true;
        C46061f bLp = C46061f.bLp();
        bLp.mo70317b(new C46059c(this.ogV));
        bLp.mo70316a(new C3449111());
        AppMethodBeat.m2505o(42932);
    }

    /* renamed from: a */
    private void m56537a(aoj aoj) {
        AppMethodBeat.m2504i(42933);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
        if (C5046bo.isNullOrNil(aoj.nWx)) {
            AppMethodBeat.m2505o(42933);
            return;
        }
        List arrayList = new ArrayList(C5046bo.m7569hT((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL2_STRING_SYNC, (Object) ""), ","));
        int i = 0;
        for (String str : aoj.wsD) {
            int i2;
            if (arrayList.contains(str)) {
                i2 = i;
            } else {
                arrayList.add(str);
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", str);
                i2 = 1;
            }
            i = i2;
        }
        if (i != 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL2_STRING_SYNC, C5046bo.m7536c(arrayList, ","));
            C30379h.m48447a((Context) this, aoj.nWx, "", getString(C25738R.string.f9151r4), false, new C3449212());
        }
        AppMethodBeat.m2505o(42933);
    }

    /* renamed from: b */
    private void m56541b(aoj aoj) {
        AppMethodBeat.m2504i(42934);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
        this.ogU = aoj.wsE == 1;
        m56537a(aoj);
        if (aoj.wsA != null) {
            if (aoj.wsA.isEmpty()) {
                this.f15058Ek.setVisibility(0);
                this.ogP.setVisibility(8);
            } else {
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", Integer.valueOf(aoj.wsA.size()));
                Iterator it = aoj.wsA.iterator();
                int i = 0;
                while (it.hasNext()) {
                    atb atb = (atb) it.next();
                    C28447b c28447b = new C28447b();
                    c28447b.nZq = atb;
                    boolean z = atb.wwT == 1 && atb.wwS != 1;
                    c28447b.kfW = z;
                    this.ogS.add(c28447b);
                    if (c28447b.kfW) {
                        this.ogT = i;
                    }
                    i++;
                }
            }
        }
        this.ogQ.aop.notifyChanged();
        this.ogP.post(new C2123813());
        AppMethodBeat.m2505o(42934);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42929);
        this.yll = true;
        super.onCreate(bundle);
        dyb();
        mo17446xE(Color.parseColor("#f1f1f1"));
        initView();
        setMMTitle((int) C25738R.string.csj);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra(C5499f.yfY);
        if (byteArrayExtra != null) {
            try {
                aoj aoj = (aoj) new aoj().parseFrom(byteArrayExtra);
                if (aoj.kCl == 0) {
                    this.ogV = aoj.wsB;
                    this.nSY = aoj.wsC;
                    m56541b(aoj);
                } else {
                    bMJ();
                }
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", e, "", new Object[0]);
            }
            setBackBtn(new C344931());
            mo17379a(1, getString(C25738R.string.csg), (OnMenuItemClickListener) new C284416(), C5535b.RED);
            enableOptionMenu(1, false);
            AppMethodBeat.m2505o(42929);
        }
        bMJ();
        setBackBtn(new C344931());
        mo17379a(1, getString(C25738R.string.csg), (OnMenuItemClickListener) new C284416(), C5535b.RED);
        enableOptionMenu(1, false);
        AppMethodBeat.m2505o(42929);
    }

    /* renamed from: c */
    static /* synthetic */ atb m56543c(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        AppMethodBeat.m2504i(42938);
        for (C28447b c28447b : luckyMoneyPickEnvelopeUI.ogS) {
            if (c28447b.nZq.materialId.equals(str)) {
                atb atb = c28447b.nZq;
                AppMethodBeat.m2505o(42938);
                return atb;
            }
        }
        AppMethodBeat.m2505o(42938);
        return null;
    }

    /* renamed from: d */
    static /* synthetic */ void m56545d(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        AppMethodBeat.m2504i(42939);
        for (C28447b c28447b : luckyMoneyPickEnvelopeUI.ogS) {
            if (c28447b.nZq.materialId.equals(str)) {
                luckyMoneyPickEnvelopeUI.ogS.remove(c28447b);
                AppMethodBeat.m2505o(42939);
                return;
            }
        }
        AppMethodBeat.m2505o(42939);
    }

    /* renamed from: e */
    static /* synthetic */ void m56547e(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, final String str) {
        AppMethodBeat.m2504i(42940);
        C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do delete show source: %s", str);
        luckyMoneyPickEnvelopeUI.gII = C30379h.m48426a(luckyMoneyPickEnvelopeUI.mController.ylL, 3, (int) C25738R.style.f10970kd, luckyMoneyPickEnvelopeUI.getString(C25738R.string.cn5), false, new C344964());
        new C21199b(str).acy().mo60487b(new C5681a<Object, C37441a<C40576ty>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(42905);
                C37441a c37441a = (C37441a) obj;
                C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do confirm errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                if (LuckyMoneyPickEnvelopeUI.this.gII != null) {
                    LuckyMoneyPickEnvelopeUI.this.gII.dismiss();
                }
                if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    C4990ab.m7417i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(((C40576ty) c37441a.fsy).kCl));
                    if (((C40576ty) c37441a.fsy).kCl == 0) {
                        LuckyMoneyPickEnvelopeUI.m56545d(LuckyMoneyPickEnvelopeUI.this, str);
                        if (LuckyMoneyPickEnvelopeUI.this.ogS.isEmpty()) {
                            LuckyMoneyPickEnvelopeUI.this.f15058Ek.setVisibility(0);
                            LuckyMoneyPickEnvelopeUI.this.ogP.setVisibility(8);
                        }
                        LuckyMoneyPickEnvelopeUI.this.ogQ.aop.notifyChanged();
                    } else if (!C5046bo.isNullOrNil(((C40576ty) c37441a.fsy).kCm)) {
                        Toast.makeText(LuckyMoneyPickEnvelopeUI.this.mController.ylL, ((C40576ty) c37441a.fsy).kCm, 1).show();
                    }
                }
                AppMethodBeat.m2505o(42905);
                return null;
            }
        });
        AppMethodBeat.m2505o(42940);
    }
}
