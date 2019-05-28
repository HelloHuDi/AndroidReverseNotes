package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p612ui.tools.p1626a.C44380a;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.p612ui.widget.RoundedCornerRelativeLayout;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.MaskImageView;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdNativeLandingPagesUI;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsDrawGestureView;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsDrawGestureView.C35145a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C34998j;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C13475c;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C13475c.C13476a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.c */
public final class C41313c extends BaseTimeLineItem {

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.c$a */
    public static class C13687a extends BaseViewHolder {
        public View rGQ;
        public View rGR;
        public TextView rGS;
        public TextView rGT;
        public TextView rGU;
        public TextView rGV;
        public View rGW;
        public MaskImageView rGX;
        private SnsDrawGestureView rGY;
        public View roq;
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40143);
        C13687a c13687a = (C13687a) baseViewHolder;
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(2130970812);
            if (!baseViewHolder.rHD) {
                c13687a.roq = baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        } else if (!baseViewHolder.rHD) {
            c13687a.roq = baseViewHolder.mRR.findViewById(2131827877);
            baseViewHolder.rHD = true;
        }
        c13687a.rGQ = c13687a.mRR.findViewById(2131827880);
        c13687a.rGR = c13687a.mRR.findViewById(2131827883);
        c13687a.rGS = (TextView) c13687a.mRR.findViewById(2131827881);
        c13687a.rGT = (TextView) c13687a.mRR.findViewById(2131827882);
        c13687a.rGU = (TextView) c13687a.mRR.findViewById(2131827884);
        c13687a.rGV = (TextView) c13687a.mRR.findViewById(2131827885);
        c13687a.rGX = (MaskImageView) c13687a.mRR.findViewById(2131827878);
        c13687a.rGW = c13687a.mRR.findViewById(2131827886);
        c13687a.rGX.setScaleType(C15991a.CENTER_CROP);
        c13687a.rGD = new C43589aj();
        c13687a.rGD.rnt = c13687a.roq.findViewById(2131827879);
        c13687a.rGD.rns = c13687a.rGD.rnt;
        c13687a.rGD.rnt.setOnClickListener(this.qPr.qOL.rKe);
        c13687a.rGD.qzM = (C34915a) c13687a.rGD.rnt.findViewById(2131820629);
        c13687a.rGD.raP = (ImageView) c13687a.rGD.rnt.findViewById(2131820981);
        c13687a.rGD.rnu = (MMPinProgressBtn) c13687a.rGD.rnt.findViewById(2131821370);
        c13687a.rGD.rnv = (TextView) c13687a.rGD.rnt.findViewById(2131827571);
        c13687a.rGD.raQ = (TextView) c13687a.rGD.rnt.findViewById(2131827572);
        ((SightPlayImageView) c13687a.rGD.qzM).qyI = true;
        ((SightPlayImageView) c13687a.rGD.qzM).setScaleType(C15991a.CENTER_CROP);
        c13687a.rGY = (SnsDrawGestureView) c13687a.mRR.findViewById(2131827887);
        AppMethodBeat.m2505o(40143);
    }

    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40144);
        C4990ab.m7417i("MicroMsg.FullCardAdTimeLineItem", "fill full card ad item %d", Integer.valueOf(i));
        if (baseViewHolder.eBB) {
            C4990ab.m7416i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
            AppMethodBeat.m2505o(40144);
            return;
        }
        bau bau;
        final C13687a c13687a = (C13687a) baseViewHolder;
        final C46236n c46236n = c13633av.qBY;
        C13475c c13475c = null;
        if (!(c46236n == null || c46236n.cqo() == null)) {
            c13475c = c46236n.cqo().qUY;
        }
        WindowManager windowManager = (WindowManager) this.mActivity.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        c13687a.rGQ.setVisibility(8);
        c13687a.rGS.setVisibility(8);
        c13687a.rGT.setVisibility(8);
        c13687a.rGR.setVisibility(8);
        c13687a.rGU.setVisibility(8);
        c13687a.rGV.setVisibility(8);
        c13687a.rGW.setVisibility(8);
        c13687a.rGY.setVisibility(8);
        c13687a.rGD.qzM.setOnCompletionListener(null);
        c13687a.rGD.qzM.setOnDecodeDurationListener(null);
        m71977a(c13687a);
        if (c13475c != null) {
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            GradientDrawable gradientDrawable;
            min = (((min - C1338a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9958le)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            if (c13475c.qVk == 0) {
                layoutParams = new LayoutParams(-2, -2);
                layoutParams.width = min;
                layoutParams.height = (int) (((float) layoutParams.width) * 0.75f);
                layoutParams2 = layoutParams;
            } else if (c13475c.qVk == 1) {
                layoutParams = new LayoutParams(-2, -2);
                layoutParams.width = min;
                layoutParams.height = layoutParams.width;
                layoutParams2 = layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams = c13687a.roq.getLayoutParams();
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                c13687a.roq.setLayoutParams(layoutParams);
                ((RoundedCornerRelativeLayout) c13687a.roq).setRadius(8.0f);
                layoutParams = c13687a.rGX.getLayoutParams();
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                c13687a.rGX.setLayoutParams(layoutParams);
                layoutParams = c13687a.rGD.rns.getLayoutParams();
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                c13687a.rGD.rns.setLayoutParams(layoutParams);
                c13687a.rGD.qzM.mo8513fi(layoutParams2.width, layoutParams2.height);
            }
            TextView textView;
            C9212g dqQ;
            if (c13475c.qVm == 0) {
                gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) c13475c.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                c13687a.rGQ.setBackground(gradientDrawable);
                if (!(C5046bo.isNullOrNil(c13475c.title) && C5046bo.isNullOrNil(c13475c.description))) {
                    c13687a.rGQ.setVisibility(0);
                }
                if (!C5046bo.isNullOrNil(c13475c.title)) {
                    c13687a.rGS.setVisibility(0);
                    textView = c13687a.rGS;
                    dqQ = C9212g.dqQ();
                    c13687a.rGS.getContext();
                    textView.setText(dqQ.mo20622b(c13475c.title, c13687a.rGS.getTextSize()));
                }
                if (!C5046bo.isNullOrNil(c13475c.description)) {
                    c13687a.rGT.setVisibility(0);
                    textView = c13687a.rGT;
                    dqQ = C9212g.dqQ();
                    c13687a.rGT.getContext();
                    textView.setText(dqQ.mo20622b(c13475c.description, c13687a.rGT.getTextSize()));
                }
            } else if (c13475c.qVm == 1) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) c13475c.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                c13687a.rGR.setBackground(gradientDrawable);
                if (!(C5046bo.isNullOrNil(c13475c.title) && C5046bo.isNullOrNil(c13475c.description))) {
                    c13687a.rGR.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c13687a.rGW.getLayoutParams();
                    layoutParams3.topMargin = C1338a.fromDPToPix(c13687a.roq.getContext(), 4);
                    c13687a.rGW.setLayoutParams(layoutParams3);
                }
                if (!C5046bo.isNullOrNil(c13475c.title)) {
                    c13687a.rGU.setVisibility(0);
                    textView = c13687a.rGU;
                    dqQ = C9212g.dqQ();
                    c13687a.rGU.getContext();
                    textView.setText(dqQ.mo20622b(c13475c.title, c13687a.rGU.getTextSize()));
                }
                if (!C5046bo.isNullOrNil(c13475c.description)) {
                    c13687a.rGV.setVisibility(0);
                    textView = c13687a.rGV;
                    dqQ = C9212g.dqQ();
                    c13687a.rGV.getContext();
                    textView.setText(dqQ.mo20622b(c13475c.description, c13687a.rGV.getTextSize()));
                }
            }
            if (c46236n.cqq().coI()) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) c13475c.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                c13687a.rGR.setVisibility(0);
                c13687a.rGR.setBackground(gradientDrawable);
                c13687a.rGW.setVisibility(0);
            }
        } else {
            C4990ab.m7412e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
        }
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) timeLineObject.xfI.wbK.get(0);
        }
        baseViewHolder.rGD.mo69200a(timeLineObject, i, c13633av.riA, c13633av.rgZ);
        baseViewHolder.rGD.raQ.setVisibility(8);
        C21925g cnC = C13373af.cnC();
        if (bau == null) {
            cnC.mo37446a(baseViewHolder.rGD.qzM, this.mActivity.hashCode());
            baseViewHolder.rGD.rnv.setVisibility(8);
            baseViewHolder.rGD.qzM.setOnSightCompletionAction(null);
            baseViewHolder.rGD.qzM.setOnCompletionListener(null);
            baseViewHolder.rGD.qzM.setOnDecodeDurationListener(null);
        } else if (timeLineObject.xfI.wbJ == 1) {
            c13687a.rGX.setVisibility(0);
            c13687a.rGD.rns.setVisibility(4);
            View view = c13687a.rGX;
            int hashCode = this.mActivity.hashCode();
            C44222az dtg = C44222az.dtg();
            dtg.oyB = timeLineObject.pcX;
            cnC.mo37457b(bau, view, -1, hashCode, dtg);
            c13687a.rGX.setTag(baseViewHolder);
            c13687a.rGX.setOnClickListener(c46251au.qOL.rKn);
            AppMethodBeat.m2505o(40144);
            return;
        } else if (timeLineObject.xfI.wbJ == 15 || timeLineObject.xfI.wbJ == 5) {
            final C46251au c46251au2 = c46251au;
            final C13633av c13633av2 = c13633av;
            c13687a.rGD.qzM.setOnCompletionListener(new C13304e() {
                /* renamed from: c */
                public final void mo8940c(C13303b c13303b, int i) {
                    AppMethodBeat.m2504i(40135);
                    C4990ab.m7416i("MicroMsg.FullCardAdTimeLineItem", "sight play completed!");
                    if (i != -1) {
                        if (c46251au2 == null || c46251au2.rxP == null || c46251au2.rxP.rhm == null) {
                            AppMethodBeat.m2505o(40135);
                            return;
                        }
                        c46251au2.rxP.rhm.mo25445u(c13633av2.rAt, false);
                    }
                    AppMethodBeat.m2505o(40135);
                }
            });
            final C46251au c46251au3 = c46251au;
            final C13633av c13633av3 = c13633av;
            c13687a.rGD.qzM.setOnDecodeDurationListener(new C13325f() {
                /* renamed from: b */
                public final void mo8946b(C13303b c13303b, long j) {
                    AppMethodBeat.m2504i(40136);
                    if (c46251au3 == null || c46251au3.rxP == null || c46251au3.rxP.rhm == null) {
                        AppMethodBeat.m2505o(40136);
                        return;
                    }
                    if (!c46251au3.rxP.rhm.mo25439jO(c13633av3.rAt) && j >= 3) {
                        int cle = (int) c13303b.cle();
                        c46251au3.rxP.rhm.mo25433c(c13633av3.rAt, C5046bo.m7588yz(), false);
                        c46251au3.rxP.rhm.mo25436f(c13633av3.rAt, cle, false);
                        c46251au3.rxP.rhm.mo25429T(c13633av3.rAt, c13633av3.rAt);
                    }
                    C4990ab.m7411d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", Long.valueOf(j));
                    C41313c.m71978a(C41313c.this, c13687a, c13475c, c46236n, ((int) j) * 1000);
                    AppMethodBeat.m2505o(40136);
                }
            });
            C13476a c13476a = c13475c.qVn;
            final String coW = c46236n.cqo().coW();
            if (!C5046bo.isNullOrNil(coW) && c13476a != null && c13476a.startTime >= 0 && c13476a.endTime > c13476a.startTime) {
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(40137);
                        C34998j.cql().mo55575f("adId", coW, "adxml", 0);
                        AppMethodBeat.m2505o(40137);
                    }
                }, "preDownloadFloatPage");
            }
            long nanoTime = System.nanoTime() - System.nanoTime();
            C4990ab.m7417i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(nanoTime));
            C43589aj c43589aj = c13687a.rGD;
            if (C21925g.m33541t(bau)) {
                if (cnC.mo37468u(bau)) {
                    c43589aj.raP.setVisibility(0);
                    c43589aj.rnu.setVisibility(8);
                    c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                    c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                } else if (cnC.mo37469v(bau)) {
                    c43589aj.raP.setVisibility(8);
                    c43589aj.rnu.setVisibility(8);
                } else if (cnC.mo37453b(c46236n, null) <= 5) {
                    c43589aj.raP.setVisibility(8);
                    c43589aj.rnu.setVisibility(8);
                } else {
                    cnC.mo37472y(bau);
                    c43589aj.raP.setVisibility(0);
                    c43589aj.rnu.setVisibility(8);
                    c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                    c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                }
                if (c43589aj.qzM.ckY()) {
                    C4990ab.m7410d("MicroMsg.FullCardAdTimeLineItem", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH + " " + i);
                    cnC.mo37472y(bau);
                    c43589aj.raP.setVisibility(0);
                    c43589aj.rnu.setVisibility(8);
                    c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                    c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                }
            } else if (cnC.mo37470w(bau)) {
                c43589aj.raP.setVisibility(8);
                c43589aj.rnu.setVisibility(0);
                c43589aj.rnu.dKB();
            } else if (cnC.mo37453b(c46236n, null) == 5) {
                cnC.mo37428A(bau);
                c43589aj.raP.setVisibility(8);
                c43589aj.rnu.setVisibility(0);
                c43589aj.rnu.dKB();
            } else if (cnC.mo37471x(bau)) {
                c43589aj.rnu.setVisibility(8);
                c43589aj.raP.setImageResource(C25738R.drawable.atu);
                c43589aj.raP.setVisibility(0);
            } else {
                cnC.mo37472y(bau);
                c43589aj.raP.setVisibility(0);
                c43589aj.rnu.setVisibility(8);
                c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                if (cnC.mo37453b(c46236n, null) == 4) {
                    c43589aj.raQ.setVisibility(0);
                }
            }
            c13687a.rGD.rns.setVisibility(0);
            c13687a.rGX.setVisibility(4);
            c43589aj.qzM.setTagObject(c43589aj);
            c43589aj.rnt.setTag(baseViewHolder);
            c13687a.rGD.rns.setOnClickListener(c46251au.qOL.rKn);
            C34915a c34915a = c43589aj.qzM;
            int hashCode2 = this.mActivity.hashCode();
            C44222az dtg2 = C44222az.dtg();
            dtg2.oyB = timeLineObject.pcX;
            cnC.mo37449a(c46236n, bau, c34915a, hashCode2, i, dtg2, c13633av.rgZ, true);
            if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
                c46251au.rxP.rhm.mo25446v(c13633av.rAt, true);
            } else {
                c46251au.rxP.rhm.mo25446v(c13633av.rAt, false);
            }
            c46251au.rxP.rhm.mo25434c(c13633av.rAt, C13373af.cnC().mo37453b(c46236n, null) == 5, false);
            AppMethodBeat.m2505o(40144);
            return;
        }
        AppMethodBeat.m2505o(40144);
    }

    /* renamed from: a */
    private void m71977a(final C13687a c13687a) {
        AppMethodBeat.m2504i(40145);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(40142);
                c13687a.rGY.setVisibility(8);
                c13687a.rGY.setBackgroundColor(0);
                c13687a.rGY.cvA();
                c13687a.rGY.setOnGestureListener(null);
                AppMethodBeat.m2505o(40142);
            }
        });
        AppMethodBeat.m2505o(40145);
    }

    /* renamed from: a */
    static /* synthetic */ void m71978a(C41313c c41313c, final C13687a c13687a, C13475c c13475c, final C46236n c46236n, int i) {
        AppMethodBeat.m2504i(40146);
        final C13476a c13476a = c13475c.qVn;
        if (!C5046bo.isNullOrNil(c46236n.cqo().coW()) && c13476a != null && c13476a.startTime >= 0 && c13476a.endTime > c13476a.startTime) {
            C4990ab.m7417i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", Long.valueOf(c13476a.startTime), Long.valueOf(c13476a.endTime), Integer.valueOf(i));
            if (c13476a.startTime > ((long) i) || c13476a.endTime < ((long) i)) {
                c41313c.m71977a(c13687a);
            } else if (c13687a.rGY.getOnGestureListener() == null) {
                C5004al.m7441d(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.ui.item.c$4$1 */
                    class C136861 implements C35145a {
                        C136861() {
                        }

                        public final void cuU() {
                            AppMethodBeat.m2504i(40138);
                            C29036i.m46120kI(false);
                            c13687a.rGY.setBackgroundColor(C41313c.this.mActivity.getResources().getColor(C25738R.color.a08));
                            AppMethodBeat.m2505o(40138);
                        }

                        /* renamed from: dv */
                        public final void mo25866dv(List<PointF> list) {
                            int i = 2;
                            AppMethodBeat.m2504i(40139);
                            C29036i.m46120kI(true);
                            List Xs = C29036i.m46096Xs(c13476a.qVp);
                            c13687a.rGY.setBackgroundColor(0);
                            if (Xs.size() <= 0 || list.size() <= 0) {
                                AppMethodBeat.m2505o(40139);
                                return;
                            }
                            try {
                                float r = C44380a.m80240r(Xs, list);
                                String dd = C29036i.m46107dd(Xs);
                                Collections.reverse(Xs);
                                C4990ab.m7417i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", Float.valueOf(r), Float.valueOf(C44380a.m80240r(Xs, list)), Float.valueOf((float) Math.acos((double) Math.max(r, C44380a.m80240r(Xs, list)))));
                                if (((float) Math.acos((double) Math.max(r, C44380a.m80240r(Xs, list)))) <= c13476a.qVo) {
                                    C41313c.this.qPr.rxP.rhA.mo37648h(c13687a);
                                    C29036i.m46109e(new long[]{20, 100});
                                    int[] iArr = new int[2];
                                    c13687a.roq.getLocationInWindow(iArr);
                                    Intent intent = new Intent();
                                    intent.putExtra("img_gallery_left", iArr[0]);
                                    intent.putExtra("img_gallery_top", iArr[1]);
                                    intent.putExtra("img_gallery_width", c13687a.roq.getWidth());
                                    intent.putExtra("img_gallery_height", c13687a.roq.getHeight());
                                    intent.putExtra("sns_landing_pages_share_sns_id", c46236n.cqA());
                                    intent.putExtra("sns_landing_pages_rawSnsId", c46236n.cqu().f15074Id);
                                    intent.putExtra("sns_landing_pages_ux_info", c46236n.crc());
                                    String coW = c46236n.cqo().coW();
                                    if (!C3953i.m6305go(c46236n.cqo().cHz, "adFullCardGestureCanvasInfo")) {
                                        coW.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
                                    }
                                    intent.putExtra("sns_landing_pages_xml", coW);
                                    intent.setClass(C41313c.this.mActivity, SnsAdNativeLandingPagesUI.class);
                                    intent.putExtra("sns_landig_pages_from_source", 1);
                                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                    intent.putExtra("sns_landing_is_native_sight_ad", true);
                                    C41313c.this.mActivity.startActivity(intent);
                                    C29036i.m46098a(new SnsAdClick(1, 1, C29036i.m46094Xq(c46236n.cqu().f15074Id), 25, 21));
                                } else {
                                    i = 1;
                                }
                                C7060h.pYm.mo8381e(16552, c46236n.cqu().f15074Id, dd, C29036i.m46107dd(C44380a.m80241v(list, 20)), Integer.valueOf((int) (100.0f * r9)), Integer.valueOf(i), Long.valueOf(C5046bo.anl(c46236n.cqZ())), c46236n.cqq().qPj);
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", e, "recog gesture error!", new Object[0]);
                            } finally {
                                c13687a.rGY.cvA();
                                AppMethodBeat.m2505o(40139);
                            }
                        }

                        public final void onClick() {
                            AppMethodBeat.m2504i(40140);
                            C29036i.m46120kI(true);
                            c13687a.rGY.setBackgroundColor(0);
                            c13687a.rGD.rns.performClick();
                            AppMethodBeat.m2505o(40140);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(40141);
                        c13687a.rGY.setVisibility(0);
                        c13687a.rGY.cvA();
                        c13687a.rGY.setPaintColor(c13476a.color);
                        c13687a.rGY.setOnGestureListener(new C136861());
                        AppMethodBeat.m2505o(40141);
                    }
                });
                AppMethodBeat.m2505o(40146);
                return;
            }
        }
        AppMethodBeat.m2505o(40146);
    }
}
