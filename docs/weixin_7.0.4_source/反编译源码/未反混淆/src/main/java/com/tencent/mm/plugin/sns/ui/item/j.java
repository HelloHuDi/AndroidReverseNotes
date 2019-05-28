package com.tencent.mm.plugin.sns.ui.item;

import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class j extends BaseTimeLineItem {
    private int mScreenHeight;
    private int mScreenWidth;
    private e rJj = new e() {
        public final void c(b bVar, int i) {
        }
    };

    public j() {
        AppMethodBeat.i(40169);
        AppMethodBeat.o(40169);
    }

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40170);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(R.layout.avp);
            baseViewHolder.rIq = (ViewStub) baseViewHolder.mRR.findViewById(R.id.ehw);
            if (!baseViewHolder.rIr) {
                baseViewHolder.rGD.rns = baseViewHolder.rIq.inflate();
                baseViewHolder.rIr = true;
            }
        } else {
            baseViewHolder.rGD.rns = baseViewHolder.mRR.findViewById(R.id.ek2);
            baseViewHolder.rIr = true;
        }
        baseViewHolder.rGD.rnt = baseViewHolder.rGD.rns.findViewById(R.id.ap9);
        baseViewHolder.rGD.qzM = (a) baseViewHolder.rGD.rns.findViewById(R.id.bl);
        baseViewHolder.rGD.rnt.setOnClickListener(this.qPr.qOL.rKe);
        baseViewHolder.rGD.raP = (ImageView) baseViewHolder.rGD.rns.findViewById(R.id.l4);
        baseViewHolder.rGD.rnu = (MMPinProgressBtn) baseViewHolder.rGD.rns.findViewById(R.id.vm);
        baseViewHolder.rGD.rnv = (TextView) baseViewHolder.rGD.rns.findViewById(R.id.edy);
        baseViewHolder.rGD.raQ = (TextView) baseViewHolder.rGD.rns.findViewById(R.id.edz);
        g.RQ();
        if (((Boolean) g.RP().Ry().get(344065, Boolean.FALSE)).booleanValue()) {
            baseViewHolder.rGD.qzM.setSightInfoView((TextView) ((ViewStub) baseViewHolder.rGD.rns.findViewById(R.id.as2)).inflate());
        }
        AppMethodBeat.o(40170);
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        bau bau;
        AppMethodBeat.i(40171);
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) timeLineObject.xfI.wbK.get(0);
        }
        ab.v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", Integer.valueOf(i));
        n YS = af.cnF().YS(baseViewHolder.cFc);
        if (avVar.rgZ && bau != null) {
            final long j = avVar.rAt;
            final au auVar2 = auVar;
            baseViewHolder.rGD.qzM.setOnCompletionListener(new e() {
                public final void c(b bVar, int i) {
                    AppMethodBeat.i(40167);
                    if (i != -1) {
                        if (auVar2 == null || auVar2.rxP == null || auVar2.rxP.rhm == null) {
                            AppMethodBeat.o(40167);
                            return;
                        }
                        auVar2.rxP.rhm.u(j, false);
                    }
                    AppMethodBeat.o(40167);
                }
            });
            if (!auVar.rxP.rhm.jO(j)) {
                final au auVar3 = auVar;
                final BaseViewHolder baseViewHolder2 = baseViewHolder;
                baseViewHolder.rGD.qzM.setOnDecodeDurationListener(new f() {
                    public final void b(b bVar, long j) {
                        AppMethodBeat.i(40168);
                        if (auVar3 == null || auVar3.rxP == null || auVar3.rxP.rhm == null) {
                            AppMethodBeat.o(40168);
                            return;
                        }
                        if (j >= 3) {
                            int cle = (int) bVar.cle();
                            auVar3.rxP.rhm.c(j, bo.yz(), false);
                            auVar3.rxP.rhm.f(j, cle, false);
                            auVar3.rxP.rhm.T(j, j);
                            baseViewHolder2.rGD.qzM.setOnDecodeDurationListener(null);
                        }
                        AppMethodBeat.o(40168);
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
        baseViewHolder.rGD.a(timeLineObject, i, avVar.riA, avVar.rgZ);
        baseViewHolder.rGD.raQ.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            cnC.a(baseViewHolder.rGD.qzM, this.mActivity.hashCode());
        } else {
            Pair create;
            int intValue;
            int intValue2;
            LayoutParams layoutParams;
            a aVar;
            int hashCode;
            az dtg;
            boolean z;
            long nanoTime = System.nanoTime() - System.nanoTime();
            ab.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(bau)), Long.valueOf(nanoTime));
            if (com.tencent.mm.plugin.sns.model.g.t(bau)) {
                if (cnC.u(bau)) {
                    baseViewHolder.rGD.raP.setVisibility(0);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                    baseViewHolder.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                    baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                } else if (cnC.v(bau)) {
                    baseViewHolder.rGD.raP.setVisibility(8);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                } else if (!avVar.rgZ || cnC.b(YS, null) > 5) {
                    cnC.y(bau);
                    baseViewHolder.rGD.raP.setVisibility(0);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                    baseViewHolder.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                    baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                } else {
                    baseViewHolder.rGD.raP.setVisibility(8);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                }
                if (baseViewHolder.rGD.qzM.ckY()) {
                    ab.d("MicroMsg.VideoTimeLineItem", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH + " " + i);
                    cnC.y(bau);
                    baseViewHolder.rGD.raP.setVisibility(0);
                    baseViewHolder.rGD.rnu.setVisibility(8);
                    baseViewHolder.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                    baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                }
            } else if (cnC.w(bau)) {
                baseViewHolder.rGD.raP.setVisibility(8);
                baseViewHolder.rGD.rnu.setVisibility(0);
                baseViewHolder.rGD.rnu.dKB();
            } else if (avVar.rgZ && cnC.b(YS, null) == 5) {
                cnC.A(bau);
                baseViewHolder.rGD.raP.setVisibility(8);
                baseViewHolder.rGD.rnu.setVisibility(0);
                baseViewHolder.rGD.rnu.dKB();
            } else if (cnC.x(bau)) {
                baseViewHolder.rGD.rnu.setVisibility(8);
                baseViewHolder.rGD.raP.setImageResource(R.drawable.atu);
                baseViewHolder.rGD.raP.setVisibility(0);
            } else {
                cnC.y(bau);
                baseViewHolder.rGD.raP.setVisibility(0);
                baseViewHolder.rGD.rnu.setVisibility(8);
                baseViewHolder.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                baseViewHolder.rGD.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                if (!avVar.rgZ && cnC.a(YS, null) == 4) {
                    baseViewHolder.rGD.raQ.setVisibility(0);
                } else if (avVar.rgZ && cnC.b(YS, null) == 4) {
                    baseViewHolder.rGD.raQ.setVisibility(0);
                }
            }
            Pair a = com.tencent.mm.modelsns.e.a(baseViewHolder.timeLineObject, baseViewHolder.rGD.qzM.getUIContext(), avVar.rgZ);
            if (avVar.rgZ) {
                com.tencent.mm.plugin.sns.storage.b cqo = avVar.qBY.cqo();
                int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
                if (cqo != null && cqo.qUH > 0.0f && cqo.qUI > 0.0f) {
                    float a2 = i.a((double) cqo.qUH, 1, cqo.qUJ, cqo.qUK);
                    float a3 = i.a((double) cqo.qUI, 1, cqo.qUJ, cqo.qUK);
                    int fromDPToPix;
                    Pair create2;
                    if (cqo.qUG == 0) {
                        if (a2 >= ((float) (((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12)))) {
                            a2 = (float) (((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12));
                            a3 = (float) ((int) ((cqo.qUI * a2) / cqo.qUH));
                        }
                        create = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) a3));
                    } else if (cqo.qUG == 1) {
                        fromDPToPix = (((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12);
                        create2 = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * cqo.qUI) / cqo.qUH)));
                        baseViewHolder.rHz.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix, -2));
                        create = create2;
                    } else if (cqo.qUG == 2) {
                        fromDPToPix = ((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 12);
                        create2 = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * cqo.qUI) / cqo.qUH)));
                        baseViewHolder.rHz.setLayoutParams(new LinearLayout.LayoutParams(fromDPToPix, -2));
                        create = create2;
                    }
                    intValue = ((Integer) create.first).intValue();
                    intValue2 = ((Integer) create.second).intValue();
                    baseViewHolder.rGD.qzM.fi(intValue, intValue2);
                    layoutParams = baseViewHolder.rGD.rnv.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = intValue2;
                    baseViewHolder.rGD.rnv.setLayoutParams(layoutParams);
                    baseViewHolder.rGD.qzM.setTagObject(baseViewHolder.rGD);
                    aVar = baseViewHolder.rGD.qzM;
                    hashCode = this.mActivity.hashCode();
                    dtg = az.dtg();
                    dtg.oyB = timeLineObject.pcX;
                    cnC.a(YS, bau, aVar, hashCode, i, dtg, avVar.rgZ);
                    baseViewHolder.rGD.rnt.setTag(baseViewHolder.rGD);
                    if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + com.tencent.mm.plugin.sns.data.i.j(bau))) {
                        auVar.rxP.rhm.v(avVar.rAt, false);
                    } else {
                        auVar.rxP.rhm.v(avVar.rAt, true);
                    }
                    z = avVar.rgZ ? af.cnC().b(YS, null) == 5 : af.cnC().a(YS, null) == 5;
                    auVar.rxP.rhm.c(avVar.rAt, z, false);
                }
            }
            create = a;
            intValue = ((Integer) create.first).intValue();
            intValue2 = ((Integer) create.second).intValue();
            baseViewHolder.rGD.qzM.fi(intValue, intValue2);
            layoutParams = baseViewHolder.rGD.rnv.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = intValue2;
            baseViewHolder.rGD.rnv.setLayoutParams(layoutParams);
            baseViewHolder.rGD.qzM.setTagObject(baseViewHolder.rGD);
            aVar = baseViewHolder.rGD.qzM;
            hashCode = this.mActivity.hashCode();
            dtg = az.dtg();
            dtg.oyB = timeLineObject.pcX;
            cnC.a(YS, bau, aVar, hashCode, i, dtg, avVar.rgZ);
            baseViewHolder.rGD.rnt.setTag(baseViewHolder.rGD);
            if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + com.tencent.mm.plugin.sns.data.i.j(bau))) {
            }
            if (avVar.rgZ) {
            }
            auVar.rxP.rhm.c(avVar.rAt, z, false);
        }
        if (!(YS == null || YS.coP())) {
            auVar.jMO.c(baseViewHolder.rGD.rnt, auVar.qOL.rJX, auVar.qOL.rJH);
        }
        AppMethodBeat.o(40171);
    }
}
