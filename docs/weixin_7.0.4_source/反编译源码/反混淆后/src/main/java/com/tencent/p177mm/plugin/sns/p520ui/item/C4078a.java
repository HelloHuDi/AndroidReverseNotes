package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
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
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsCardAdTagListView;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.a */
public final class C4078a extends BaseTimeLineItem {

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.a$a */
    public static class C4081a extends BaseViewHolder {
        public View rGG;
        public View rGM;
        public MaskImageView rGX;
        public ViewGroup rIE;
        public ViewGroup rIF;
        public ViewGroup rIG;
        public Button rIH;
        public Button rII;
        public ImageView rIJ;
        public TextView rIK;
        public SnsCardAdTagListView rIL;
        public View rIM;
        public TextView rIN;
        public TextView rIO;
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40131);
        C4081a c4081a = (C4081a) baseViewHolder;
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(2130970713);
            if (!baseViewHolder.rHD) {
                c4081a.rIE = (ViewGroup) baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        } else if (!baseViewHolder.rHD) {
            c4081a.rIE = (ViewGroup) baseViewHolder.mRR.findViewById(2131827603);
            baseViewHolder.rHD = true;
        }
        c4081a.rIF = (ViewGroup) c4081a.rIE.findViewById(2131827604);
        c4081a.rIG = (ViewGroup) c4081a.rIE.findViewById(2131827607);
        c4081a.rGX = (MaskImageView) c4081a.rIE.findViewById(2131827605);
        c4081a.rGX.setOnClickListener(this.qPr.qOL.rjy);
        this.qPr.jMO.mo39887c(c4081a.rGX, this.qPr.qOL.rJV, this.qPr.qOL.rJH);
        c4081a.rIO = (TextView) c4081a.rIE.findViewById(2131827609);
        c4081a.rIO.setClickable(false);
        c4081a.rIO.setLongClickable(false);
        c4081a.rIN = (TextView) c4081a.rIE.findViewById(2131827608);
        c4081a.rIN.setClickable(false);
        c4081a.rIN.setLongClickable(false);
        c4081a.rGD = new C43589aj();
        c4081a.rGD.rnt = c4081a.rIE.findViewById(2131827606);
        c4081a.rGD.rns = c4081a.rGD.rnt;
        c4081a.rGD.rnt.setOnClickListener(this.qPr.qOL.rKe);
        c4081a.rGD.qzM = (C34915a) c4081a.rGD.rnt.findViewById(2131820629);
        c4081a.rGD.raP = (ImageView) c4081a.rGD.rnt.findViewById(2131820981);
        c4081a.rGD.rnu = (MMPinProgressBtn) c4081a.rGD.rnt.findViewById(2131821370);
        c4081a.rGD.rnv = (TextView) c4081a.rGD.rnt.findViewById(2131827571);
        c4081a.rGD.raQ = (TextView) c4081a.rGD.rnt.findViewById(2131827572);
        c4081a.rGM = c4081a.rIE.findViewById(2131827874);
        c4081a.rIJ = (ImageView) c4081a.rIE.findViewById(2131827875);
        c4081a.rIK = (TextView) c4081a.rIE.findViewById(2131827876);
        c4081a.rIM = c4081a.rIE.findViewById(2131827614);
        c4081a.rGG = c4081a.rIE.findViewById(2131827611);
        c4081a.rIH = (Button) c4081a.rIE.findViewById(2131827612);
        c4081a.rII = (Button) c4081a.rIE.findViewById(2131827613);
        c4081a.rIH.setOnClickListener(this.qPr.qOL.rKl);
        c4081a.rII.setOnClickListener(this.qPr.qOL.rKm);
        c4081a.rIL = (SnsCardAdTagListView) c4081a.rIE.findViewById(2131827610);
        c4081a.rIL.setActivityContext(this.mActivity);
        AppMethodBeat.m2505o(40131);
    }

    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40132);
        C4990ab.m7417i("MiroMsg.CardAdTimeLineItem", "fill card ad item %d", Integer.valueOf(i));
        if (baseViewHolder.eBB) {
            C4990ab.m7416i("MiroMsg.CardAdTimeLineItem", "holder is busy");
            AppMethodBeat.m2505o(40132);
            return;
        }
        bau bau;
        baseViewHolder.eBB = true;
        final C4081a c4081a = (C4081a) baseViewHolder;
        C46236n DP = c46251au.mo74340DP(i);
        c4081a.rIM.setVisibility(8);
        c4081a.rGG.setVisibility(8);
        c4081a.rIL.setVisibility(8);
        c4081a.rGM.setVisibility(8);
        c4081a.rGM.setTag("");
        if (baseViewHolder.rHz != null) {
            baseViewHolder.rHz.setVisibility(8);
        }
        WindowManager windowManager = (WindowManager) this.mActivity.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        ((C4081a) baseViewHolder).rHB.setOnClickListener(c46251au.qOL.rKn);
        LayoutParams layoutParams = new LayoutParams((((min - C1338a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9958le)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc), -2);
        layoutParams.topMargin = this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
        layoutParams.bottomMargin = C1338a.fromDPToPix(this.mActivity, 2);
        ((C4081a) baseViewHolder).rIE.setLayoutParams(layoutParams);
        c46251au.jMO.mo39887c(baseViewHolder.rHB, c46251au.qOL.rJZ, c46251au.qOL.rJH);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c4081a.rGX.getLayoutParams();
        layoutParams2.leftMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.rightMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.topMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.bottomMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        c4081a.rGX.setLayoutParams(layoutParams2);
        layoutParams2 = (RelativeLayout.LayoutParams) baseViewHolder.rGD.rns.getLayoutParams();
        layoutParams2.leftMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.rightMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.topMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.bottomMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        baseViewHolder.rGD.rns.setLayoutParams(layoutParams2);
        layoutParams2 = (RelativeLayout.LayoutParams) c4081a.rGM.getLayoutParams();
        layoutParams2.leftMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.rightMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        layoutParams2.topMargin = C1338a.m2856al(this.mActivity, C25738R.dimen.f9966lo);
        c4081a.rGM.setLayoutParams(layoutParams2);
        c4081a.rIE.setBackgroundResource(C25738R.drawable.a0o);
        if (c4081a.rIO != null) {
            c4081a.rIO.setVisibility(0);
        }
        if (c4081a.rIN != null) {
            if (C5046bo.isNullOrNil(DP.cqo().qUS)) {
                c4081a.rIN.setVisibility(8);
            } else {
                c4081a.rIN.setVisibility(0);
            }
        }
        C21980a cqq = DP.cqq();
        if (!(cqq == null || !cqq.coI() || DP.crg())) {
            c4081a.rIM.setVisibility(0);
        }
        String str = C5046bo.isNullOrNil(DP.cqo().qUT) ? timeLineObject.xfF : DP.cqo().qUT;
        if (C5046bo.isNullOrNil(str)) {
            c4081a.rIO.setVisibility(8);
        } else {
            c4081a.rIO.setText(str + " ");
            C44089j.m79307h(c4081a.rIO, 2);
            c4081a.rIO.setVisibility(0);
        }
        str = DP.cqo().qUS;
        if (C5046bo.isNullOrNil(str)) {
            c4081a.rIN.setVisibility(8);
        } else {
            c4081a.rIN.setText(str + " ");
            C44089j.m79307h(c4081a.rIN, 2);
            c4081a.rIN.setVisibility(0);
        }
        c4081a.rIL.removeAllViews();
        if (DP.cqo().qUW.size() > 0) {
            c4081a.rIL.setVisibility(0);
            c4081a.rIL.setTagSpace(C1338a.fromDPToPix(this.mActivity, 6));
            c4081a.rIL.mo37709dB(DP.cqo().qUW);
        }
        if (C5046bo.isNullOrNil(DP.cqo().qUU)) {
            c4081a.rIK.setVisibility(4);
        } else {
            c4081a.rGM.setVisibility(0);
            c4081a.rIK.setVisibility(0);
            c4081a.rIK.setText(DP.cqo().qUU);
        }
        if (DP.cqo().qUG == 1) {
            baseViewHolder.rHz.setContentWidth(((((min - C1338a.fromDPToPix(this.mActivity, 54)) - C1338a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9958le)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc));
            baseViewHolder.rHz.crz();
        } else if (DP.cqo().qUG == 2) {
            baseViewHolder.rHz.setContentWidth((((min - C1338a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9958le)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc));
            baseViewHolder.rHz.crz();
        }
        c4081a.rGM.setTag(DP.cqo().qUV);
        if (C5046bo.isNullOrNil(DP.cqo().qUV)) {
            c4081a.rIJ.setVisibility(4);
        } else {
            C13473h.m21620a(DP.cqo().qUV, new C3951a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                /* renamed from: YJ */
                public final void mo8627YJ(String str) {
                    AppMethodBeat.m2504i(40128);
                    C4990ab.m7417i("MiroMsg.CardAdTimeLineItem", "download img %s", str);
                    if (!C5046bo.m7510Q((String) c4081a.rGM.getTag(), str) && str.equals(C13473h.m21625gj("adId", (String) c4081a.rGM.getTag()))) {
                        Bitmap decodeFile = C5056d.decodeFile(str, null);
                        if (decodeFile != null) {
                            c4081a.rGM.setVisibility(0);
                            c4081a.rIJ.setImageBitmap(decodeFile);
                            c4081a.rIJ.setVisibility(0);
                        }
                    }
                    AppMethodBeat.m2505o(40128);
                }
            });
        }
        if (DP.cqo().coR() || DP.cqo().coS()) {
            c4081a.rGG.setVisibility(0);
            int parseColor = Color.parseColor("#cdcdcd");
            int parseColor2 = Color.parseColor("#ffffff");
            Object obj = 1;
            if (DP.cqo().coS()) {
                int gr = C35002v.m57491gr(DP.cqo().qVh.qVu, DP.crc());
                if (gr > 0 && gr <= 2) {
                    if (gr == 1) {
                        c4081a.rII.setBackgroundColor(parseColor2);
                        c4081a.rII.setTextColor(parseColor);
                        c4081a.rII.setText(DP.cqo().qVh.mo37532Dm(1));
                        c4081a.rIH.setBackgroundResource(C25738R.drawable.a0s);
                        c4081a.rIH.setTextColor(WebView.NIGHT_MODE_COLOR);
                        c4081a.rIH.setText(DP.cqo().qVh.mo37531Dl(0));
                    } else if (gr == 2) {
                        c4081a.rIH.setBackgroundColor(parseColor2);
                        c4081a.rIH.setTextColor(parseColor);
                        c4081a.rIH.setText(DP.cqo().qVh.mo37532Dm(0));
                        c4081a.rII.setBackgroundResource(C25738R.drawable.a0s);
                        c4081a.rII.setTextColor(WebView.NIGHT_MODE_COLOR);
                        c4081a.rII.setText(DP.cqo().qVh.mo37531Dl(1));
                    }
                    obj = null;
                }
            }
            if (obj != null) {
                c4081a.rIH.setTextColor(WebView.NIGHT_MODE_COLOR);
                c4081a.rIH.setBackgroundResource(C25738R.drawable.a0s);
                c4081a.rII.setTextColor(WebView.NIGHT_MODE_COLOR);
                c4081a.rII.setBackgroundResource(C25738R.drawable.a0s);
                c4081a.rIH.setText(DP.cqo().coL());
                c4081a.rII.setText(DP.cqo().coM());
            }
        }
        c4081a.rGX.setScaleType(C15991a.CENTER_CROP);
        ((SightPlayImageView) c4081a.rGD.qzM).qyI = true;
        ((SightPlayImageView) c4081a.rGD.qzM).setScaleType(C15991a.CENTER_CROP);
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) timeLineObject.xfI.wbK.get(0);
        }
        baseViewHolder.rGD.mo69200a(timeLineObject, i, c13633av.riA, c13633av.rgZ);
        baseViewHolder.rGD.raQ.setVisibility(8);
        C21925g cnC = C13373af.cnC();
        if (bau != null) {
            int fromDPToPix = (((((min - C1338a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
            min = (int) ((((float) fromDPToPix) * bau.wEK.wFy) / bau.wEK.wFx);
            if (baseViewHolder.timeLineObject.xfI.wbJ == 1) {
                c4081a.rGX.setVisibility(0);
                c4081a.rGD.rns.setVisibility(4);
                ViewGroup.LayoutParams layoutParams3 = c4081a.rGX.getLayoutParams();
                layoutParams3.width = fromDPToPix;
                layoutParams3.height = min;
                c4081a.rGX.setLayoutParams(layoutParams3);
                C21925g cnC2 = C13373af.cnC();
                View view = c4081a.rGX;
                min = this.mActivity.hashCode();
                C44222az dtg = C44222az.dtg();
                dtg.oyB = timeLineObject.pcX;
                cnC2.mo37457b(bau, view, -1, min, dtg);
                c4081a.rGX.setTag(c4081a);
                c4081a.rIH.setTag(c4081a);
                c4081a.rII.setTag(c4081a);
                c4081a.rGX.setOnClickListener(c46251au.qOL.rjy);
                c46251au.jMO.mo39887c(c4081a.rGX, c46251au.qOL.rJZ, c46251au.qOL.rJH);
            } else if (baseViewHolder.timeLineObject.xfI.wbJ == 5 || baseViewHolder.timeLineObject.xfI.wbJ == 15) {
                c4081a.rGD.rns.setVisibility(0);
                c4081a.rGX.setVisibility(4);
                c46251au.jMO.mo39887c(c4081a.rGD.rnt, c46251au.qOL.rJZ, c46251au.qOL.rJH);
                ViewGroup.LayoutParams layoutParams4 = c4081a.rGD.rns.getLayoutParams();
                layoutParams4.width = fromDPToPix;
                layoutParams4.height = min;
                c4081a.rGD.rns.setLayoutParams(layoutParams4);
                c4081a.rGD.qzM.mo8513fi(fromDPToPix, min);
                final C46251au c46251au2 = c46251au;
                final C13633av c13633av2 = c13633av;
                c4081a.rGD.qzM.setOnCompletionListener(new C13304e() {
                    /* renamed from: c */
                    public final void mo8940c(C13303b c13303b, int i) {
                        AppMethodBeat.m2504i(40129);
                        if (i != -1) {
                            if (c46251au2 == null || c46251au2.rxP == null || c46251au2.rxP.rhm == null) {
                                AppMethodBeat.m2505o(40129);
                                return;
                            }
                            c46251au2.rxP.rhm.mo25445u(c13633av2.rAt, false);
                        }
                        AppMethodBeat.m2505o(40129);
                    }
                });
                if (!c46251au.rxP.rhm.mo25439jO(c13633av.rAt)) {
                    c46251au2 = c46251au;
                    c13633av2 = c13633av;
                    c4081a.rGD.qzM.setOnDecodeDurationListener(new C13325f() {
                        /* renamed from: b */
                        public final void mo8946b(C13303b c13303b, long j) {
                            AppMethodBeat.m2504i(40130);
                            if (c46251au2 == null || c46251au2.rxP == null || c46251au2.rxP.rhm == null) {
                                AppMethodBeat.m2505o(40130);
                                return;
                            }
                            if (j >= 3) {
                                int cle = (int) c13303b.cle();
                                c46251au2.rxP.rhm.mo25433c(c13633av2.rAt, C5046bo.m7588yz(), false);
                                c46251au2.rxP.rhm.mo25436f(c13633av2.rAt, cle, false);
                                c46251au2.rxP.rhm.mo25429T(c13633av2.rAt, c13633av2.rAt);
                                c4081a.rGD.qzM.setOnDecodeDurationListener(null);
                            }
                            AppMethodBeat.m2505o(40130);
                        }
                    });
                }
                long nanoTime = System.nanoTime() - System.nanoTime();
                C4990ab.m7417i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(nanoTime));
                C43589aj c43589aj = c4081a.rGD;
                if (C21925g.m33541t(bau)) {
                    if (cnC.mo37468u(bau)) {
                        c43589aj.raP.setVisibility(0);
                        c43589aj.rnu.setVisibility(8);
                        c43589aj.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                        c43589aj.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                    } else if (cnC.mo37469v(bau)) {
                        c43589aj.raP.setVisibility(8);
                        c43589aj.rnu.setVisibility(8);
                    } else if (cnC.mo37453b(DP, null) <= 5) {
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
                        C4990ab.m7410d("MiroMsg.CardAdTimeLineItem", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH + " " + i);
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
                } else if (cnC.mo37453b(DP, null) == 5) {
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
                    if (cnC.mo37453b(DP, null) == 4) {
                        c43589aj.raQ.setVisibility(0);
                    }
                }
                c4081a.rIH.setTag(c4081a);
                c4081a.rII.setTag(c4081a);
                c43589aj.qzM.setTagObject(c43589aj);
                c43589aj.rnt.setTag(c4081a);
                C34915a c34915a = c43589aj.qzM;
                int hashCode = this.mActivity.hashCode();
                C44222az dtg2 = C44222az.dtg();
                dtg2.oyB = timeLineObject.pcX;
                cnC.mo37449a(DP, bau, c34915a, hashCode, i, dtg2, c13633av.rgZ, true);
                if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
                    c46251au.rxP.rhm.mo25446v(c13633av.rAt, true);
                } else {
                    c46251au.rxP.rhm.mo25446v(c13633av.rAt, false);
                }
                c46251au.rxP.rhm.mo25434c(c13633av.rAt, C13373af.cnC().mo37453b(DP, null) == 5, false);
            } else {
                cnC.mo37446a(baseViewHolder.rGD.qzM, this.mActivity.hashCode());
                baseViewHolder.rGD.rnv.setVisibility(8);
                baseViewHolder.rGD.qzM.setOnSightCompletionAction(null);
                baseViewHolder.rGD.qzM.setOnCompletionListener(null);
                baseViewHolder.rGD.qzM.setOnDecodeDurationListener(null);
            }
        }
        baseViewHolder.eBB = false;
        AppMethodBeat.m2505o(40132);
    }
}
