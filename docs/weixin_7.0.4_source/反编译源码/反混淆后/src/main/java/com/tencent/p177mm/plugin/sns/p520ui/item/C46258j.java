package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.j */
public final class C46258j extends BaseTimeLineItem {
    private int mScreenHeight;
    private int mScreenWidth;
    private C13304e rJj = new C40841();

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.j$1 */
    class C40841 implements C13304e {
        C40841() {
        }

        /* renamed from: c */
        public final void mo8940c(C13303b c13303b, int i) {
        }
    }

    public C46258j() {
        AppMethodBeat.m2504i(40169);
        AppMethodBeat.m2505o(40169);
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40170);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(2130970778);
            baseViewHolder.rIq = (ViewStub) baseViewHolder.mRR.findViewById(2131827717);
            if (!baseViewHolder.rIr) {
                baseViewHolder.rGD.rns = baseViewHolder.rIq.inflate();
                baseViewHolder.rIr = true;
            }
        } else {
            baseViewHolder.rGD.rns = baseViewHolder.mRR.findViewById(2131827797);
            baseViewHolder.rIr = true;
        }
        baseViewHolder.rGD.rnt = baseViewHolder.rGD.rns.findViewById(2131822515);
        baseViewHolder.rGD.qzM = (C34915a) baseViewHolder.rGD.rns.findViewById(2131820629);
        baseViewHolder.rGD.rnt.setOnClickListener(this.qPr.qOL.rKe);
        baseViewHolder.rGD.raP = (ImageView) baseViewHolder.rGD.rns.findViewById(2131820981);
        baseViewHolder.rGD.rnu = (MMPinProgressBtn) baseViewHolder.rGD.rns.findViewById(2131821370);
        baseViewHolder.rGD.rnv = (TextView) baseViewHolder.rGD.rns.findViewById(2131827571);
        baseViewHolder.rGD.raQ = (TextView) baseViewHolder.rGD.rns.findViewById(2131827572);
        C1720g.m3537RQ();
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(344065, Boolean.FALSE)).booleanValue()) {
            baseViewHolder.rGD.qzM.setSightInfoView((TextView) ((ViewStub) baseViewHolder.rGD.rns.findViewById(2131822619)).inflate());
        }
        AppMethodBeat.m2505o(40170);
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        bau bau;
        AppMethodBeat.m2504i(40171);
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) timeLineObject.xfI.wbK.get(0);
        }
        C4990ab.m7419v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", Integer.valueOf(i));
        C46236n YS = C13373af.cnF().mo62917YS(baseViewHolder.cFc);
        if (c13633av.rgZ && bau != null) {
            final long j = c13633av.rAt;
            final C46251au c46251au2 = c46251au;
            baseViewHolder.rGD.qzM.setOnCompletionListener(new C13304e() {
                /* renamed from: c */
                public final void mo8940c(C13303b c13303b, int i) {
                    AppMethodBeat.m2504i(40167);
                    if (i != -1) {
                        if (c46251au2 == null || c46251au2.rxP == null || c46251au2.rxP.rhm == null) {
                            AppMethodBeat.m2505o(40167);
                            return;
                        }
                        c46251au2.rxP.rhm.mo25445u(j, false);
                    }
                    AppMethodBeat.m2505o(40167);
                }
            });
            if (!c46251au.rxP.rhm.mo25439jO(j)) {
                final C46251au c46251au3 = c46251au;
                final BaseViewHolder baseViewHolder2 = baseViewHolder;
                baseViewHolder.rGD.qzM.setOnDecodeDurationListener(new C13325f() {
                    /* renamed from: b */
                    public final void mo8946b(C13303b c13303b, long j) {
                        AppMethodBeat.m2504i(40168);
                        if (c46251au3 == null || c46251au3.rxP == null || c46251au3.rxP.rhm == null) {
                            AppMethodBeat.m2505o(40168);
                            return;
                        }
                        if (j >= 3) {
                            int cle = (int) c13303b.cle();
                            c46251au3.rxP.rhm.mo25433c(j, C5046bo.m7588yz(), false);
                            c46251au3.rxP.rhm.mo25436f(j, cle, false);
                            c46251au3.rxP.rhm.mo25429T(j, j);
                            baseViewHolder2.rGD.qzM.setOnDecodeDurationListener(null);
                        }
                        AppMethodBeat.m2505o(40168);
                    }
                });
            }
        } else if (baseViewHolder.rGD != null) {
            if (baseViewHolder.rGD.rnv != null) {
                baseViewHolder.rGD.rnv.setVisibility(8);
            }
            if (baseViewHolder.rGD.qzM != null) {
                baseViewHolder.rGD.qzM.setOnSightCompletionAction(null);
                baseViewHolder.rGD.qzM.setOnCompletionListener(null);
                baseViewHolder.rGD.qzM.setOnDecodeDurationListener(null);
            }
        }
        baseViewHolder.rGD.mo69200a(timeLineObject, i, c13633av.riA, c13633av.rgZ);
        baseViewHolder.rGD.raQ.setVisibility(8);
        C21925g cnC = C13373af.cnC();
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            cnC.mo37446a(baseViewHolder.rGD.qzM, this.mActivity.hashCode());
        } else {
            Pair create;
            int intValue;
            int intValue2;
            LayoutParams layoutParams;
            C34915a c34915a;
            int hashCode;
            C44222az dtg;
            boolean z;
            long nanoTime = System.nanoTime() - System.nanoTime();
            C4990ab.m7417i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(nanoTime));
            if (C21925g.m33541t(bau)) {
                if (cnC.mo37468u(bau)) {
                    baseViewHolder.rGD.raP.setVisibility(0);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                    baseViewHolder.rGD.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                    baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                } else if (cnC.mo37469v(bau)) {
                    baseViewHolder.rGD.raP.setVisibility(8);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                } else if (!c13633av.rgZ || cnC.mo37453b(YS, null) > 5) {
                    cnC.mo37472y(bau);
                    baseViewHolder.rGD.raP.setVisibility(0);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                    baseViewHolder.rGD.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                    baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                } else {
                    baseViewHolder.rGD.raP.setVisibility(8);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                }
                if (baseViewHolder.rGD.qzM.ckY()) {
                    C4990ab.m7410d("MicroMsg.VideoTimeLineItem", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH + " " + i);
                    cnC.mo37472y(bau);
                    baseViewHolder.rGD.raP.setVisibility(0);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                    baseViewHolder.rGD.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                    baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                }
            } else if (cnC.mo37470w(bau)) {
                baseViewHolder.rGD.raP.setVisibility(8);
                baseViewHolder.rGD.rnu.setVisibility(0);
                baseViewHolder.rGD.rnu.dKB();
            } else if (c13633av.rgZ && cnC.mo37453b(YS, null) == 5) {
                cnC.mo37428A(bau);
                baseViewHolder.rGD.raP.setVisibility(8);
                baseViewHolder.rGD.rnu.setVisibility(0);
                baseViewHolder.rGD.rnu.dKB();
            } else if (cnC.mo37471x(bau)) {
                baseViewHolder.rGD.rnu.setVisibility(8);
                baseViewHolder.rGD.raP.setImageResource(C25738R.drawable.atu);
                baseViewHolder.rGD.raP.setVisibility(0);
            } else {
                cnC.mo37472y(bau);
                baseViewHolder.rGD.raP.setVisibility(0);
                baseViewHolder.rGD.rnu.setVisibility(8);
                baseViewHolder.rGD.raP.setImageDrawable(C1338a.m2864g(this.mActivity, C1318a.shortvideo_play_btn));
                baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(C25738R.string.dco));
                if (!c13633av.rgZ && cnC.mo37433a(YS, null) == 4) {
                    baseViewHolder.rGD.raQ.setVisibility(0);
                } else if (c13633av.rgZ && cnC.mo37453b(YS, null) == 4) {
                    baseViewHolder.rGD.raQ.setVisibility(0);
                }
            }
            Pair a = C37953e.m64183a(baseViewHolder.timeLineObject, baseViewHolder.rGD.qzM.getUIContext(), c13633av.rgZ);
            if (c13633av.rgZ) {
                C21984b cqo = c13633av.qBY.cqo();
                int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
                if (cqo != null && cqo.qUH > 0.0f && cqo.qUI > 0.0f) {
                    float a2 = C3953i.m6289a((double) cqo.qUH, 1, cqo.qUJ, cqo.qUK);
                    float a3 = C3953i.m6289a((double) cqo.qUI, 1, cqo.qUJ, cqo.qUK);
                    int fromDPToPix;
                    Pair create2;
                    if (cqo.qUG == 0) {
                        if (a2 >= ((float) (((width - C1338a.fromDPToPix(this.mActivity, 50)) - C1338a.fromDPToPix(this.mActivity, 12)) - C1338a.fromDPToPix(this.mActivity, 12)))) {
                            a2 = (float) (((width - C1338a.fromDPToPix(this.mActivity, 50)) - C1338a.fromDPToPix(this.mActivity, 12)) - C1338a.fromDPToPix(this.mActivity, 12));
                            a3 = (float) ((int) ((cqo.qUI * a2) / cqo.qUH));
                        }
                        create = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) a3));
                    } else if (cqo.qUG == 1) {
                        fromDPToPix = (((width - C1338a.fromDPToPix(this.mActivity, 50)) - C1338a.fromDPToPix(this.mActivity, 50)) - C1338a.fromDPToPix(this.mActivity, 12)) - C1338a.fromDPToPix(this.mActivity, 12);
                        create2 = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * cqo.qUI) / cqo.qUH)));
                        baseViewHolder.rHz.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix, -2));
                        create = create2;
                    } else if (cqo.qUG == 2) {
                        fromDPToPix = ((width - C1338a.fromDPToPix(this.mActivity, 50)) - C1338a.fromDPToPix(this.mActivity, 12)) - C1338a.fromDPToPix(this.mActivity, 12);
                        create2 = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * cqo.qUI) / cqo.qUH)));
                        baseViewHolder.rHz.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix, -2));
                        create = create2;
                    }
                    intValue = ((Integer) create.first).intValue();
                    intValue2 = ((Integer) create.second).intValue();
                    baseViewHolder.rGD.qzM.mo8513fi(intValue, intValue2);
                    layoutParams = baseViewHolder.rGD.rnv.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = intValue2;
                    baseViewHolder.rGD.rnv.setLayoutParams(layoutParams);
                    baseViewHolder.rGD.qzM.setTagObject(baseViewHolder.rGD);
                    c34915a = baseViewHolder.rGD.qzM;
                    hashCode = this.mActivity.hashCode();
                    dtg = C44222az.dtg();
                    dtg.oyB = timeLineObject.pcX;
                    cnC.mo37448a(YS, bau, c34915a, hashCode, i, dtg, c13633av.rgZ);
                    baseViewHolder.rGD.rnt.setTag(baseViewHolder.rGD);
                    if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
                        c46251au.rxP.rhm.mo25446v(c13633av.rAt, false);
                    } else {
                        c46251au.rxP.rhm.mo25446v(c13633av.rAt, true);
                    }
                    z = c13633av.rgZ ? C13373af.cnC().mo37453b(YS, null) == 5 : C13373af.cnC().mo37433a(YS, null) == 5;
                    c46251au.rxP.rhm.mo25434c(c13633av.rAt, z, false);
                }
            }
            create = a;
            intValue = ((Integer) create.first).intValue();
            intValue2 = ((Integer) create.second).intValue();
            baseViewHolder.rGD.qzM.mo8513fi(intValue, intValue2);
            layoutParams = baseViewHolder.rGD.rnv.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = intValue2;
            baseViewHolder.rGD.rnv.setLayoutParams(layoutParams);
            baseViewHolder.rGD.qzM.setTagObject(baseViewHolder.rGD);
            c34915a = baseViewHolder.rGD.qzM;
            hashCode = this.mActivity.hashCode();
            dtg = C44222az.dtg();
            dtg.oyB = timeLineObject.pcX;
            cnC.mo37448a(YS, bau, c34915a, hashCode, i, dtg, c13633av.rgZ);
            baseViewHolder.rGD.rnt.setTag(baseViewHolder.rGD);
            if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
            }
            if (c13633av.rgZ) {
            }
            c46251au.rxP.rhm.mo25434c(c13633av.rAt, z, false);
        }
        if (!(YS == null || YS.coP())) {
            c46251au.jMO.mo39887c(baseViewHolder.rGD.rnt, c46251au.qOL.rJX, c46251au.qOL.rJH);
        }
        AppMethodBeat.m2505o(40171);
    }
}
