package com.tencent.mm.plugin.sns.ui.item;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.smtt.sdk.WebView;

public final class a extends BaseTimeLineItem {

    public static class a extends BaseViewHolder {
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

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40131);
        a aVar = (a) baseViewHolder;
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(R.layout.atx);
            if (!baseViewHolder.rHD) {
                aVar.rIE = (ViewGroup) baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        } else if (!baseViewHolder.rHD) {
            aVar.rIE = (ViewGroup) baseViewHolder.mRR.findViewById(R.id.eet);
            baseViewHolder.rHD = true;
        }
        aVar.rIF = (ViewGroup) aVar.rIE.findViewById(R.id.eeu);
        aVar.rIG = (ViewGroup) aVar.rIE.findViewById(R.id.eex);
        aVar.rGX = (MaskImageView) aVar.rIE.findViewById(R.id.eev);
        aVar.rGX.setOnClickListener(this.qPr.qOL.rjy);
        this.qPr.jMO.c(aVar.rGX, this.qPr.qOL.rJV, this.qPr.qOL.rJH);
        aVar.rIO = (TextView) aVar.rIE.findViewById(R.id.eez);
        aVar.rIO.setClickable(false);
        aVar.rIO.setLongClickable(false);
        aVar.rIN = (TextView) aVar.rIE.findViewById(R.id.eey);
        aVar.rIN.setClickable(false);
        aVar.rIN.setLongClickable(false);
        aVar.rGD = new aj();
        aVar.rGD.rnt = aVar.rIE.findViewById(R.id.eew);
        aVar.rGD.rns = aVar.rGD.rnt;
        aVar.rGD.rnt.setOnClickListener(this.qPr.qOL.rKe);
        aVar.rGD.qzM = (com.tencent.mm.plugin.sight.decode.a.a) aVar.rGD.rnt.findViewById(R.id.bl);
        aVar.rGD.raP = (ImageView) aVar.rGD.rnt.findViewById(R.id.l4);
        aVar.rGD.rnu = (MMPinProgressBtn) aVar.rGD.rnt.findViewById(R.id.vm);
        aVar.rGD.rnv = (TextView) aVar.rGD.rnt.findViewById(R.id.edy);
        aVar.rGD.raQ = (TextView) aVar.rGD.rnt.findViewById(R.id.edz);
        aVar.rGM = aVar.rIE.findViewById(R.id.em5);
        aVar.rIJ = (ImageView) aVar.rIE.findViewById(R.id.em6);
        aVar.rIK = (TextView) aVar.rIE.findViewById(R.id.em7);
        aVar.rIM = aVar.rIE.findViewById(R.id.ef4);
        aVar.rGG = aVar.rIE.findViewById(R.id.ef1);
        aVar.rIH = (Button) aVar.rIE.findViewById(R.id.ef2);
        aVar.rII = (Button) aVar.rIE.findViewById(R.id.ef3);
        aVar.rIH.setOnClickListener(this.qPr.qOL.rKl);
        aVar.rII.setOnClickListener(this.qPr.qOL.rKm);
        aVar.rIL = (SnsCardAdTagListView) aVar.rIE.findViewById(R.id.ef0);
        aVar.rIL.setActivityContext(this.mActivity);
        AppMethodBeat.o(40131);
    }

    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40132);
        ab.i("MiroMsg.CardAdTimeLineItem", "fill card ad item %d", Integer.valueOf(i));
        if (baseViewHolder.eBB) {
            ab.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
            AppMethodBeat.o(40132);
            return;
        }
        bau bau;
        baseViewHolder.eBB = true;
        final a aVar = (a) baseViewHolder;
        n DP = auVar.DP(i);
        aVar.rIM.setVisibility(8);
        aVar.rGG.setVisibility(8);
        aVar.rIL.setVisibility(8);
        aVar.rGM.setVisibility(8);
        aVar.rGM.setTag("");
        if (baseViewHolder.rHz != null) {
            baseViewHolder.rHz.setVisibility(8);
        }
        WindowManager windowManager = (WindowManager) this.mActivity.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        ((a) baseViewHolder).rHB.setOnClickListener(auVar.qOL.rKn);
        LayoutParams layoutParams = new LayoutParams((((min - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.le)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc), -2);
        layoutParams.topMargin = this.mActivity.getResources().getDimensionPixelSize(R.dimen.lo);
        layoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 2);
        ((a) baseViewHolder).rIE.setLayoutParams(layoutParams);
        auVar.jMO.c(baseViewHolder.rHB, auVar.qOL.rJZ, auVar.qOL.rJH);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.rGX.getLayoutParams();
        layoutParams2.leftMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.rightMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.topMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.bottomMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        aVar.rGX.setLayoutParams(layoutParams2);
        layoutParams2 = (RelativeLayout.LayoutParams) baseViewHolder.rGD.rns.getLayoutParams();
        layoutParams2.leftMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.rightMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.topMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.bottomMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        baseViewHolder.rGD.rns.setLayoutParams(layoutParams2);
        layoutParams2 = (RelativeLayout.LayoutParams) aVar.rGM.getLayoutParams();
        layoutParams2.leftMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.rightMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        layoutParams2.topMargin = com.tencent.mm.bz.a.al(this.mActivity, R.dimen.lo);
        aVar.rGM.setLayoutParams(layoutParams2);
        aVar.rIE.setBackgroundResource(R.drawable.a0o);
        if (aVar.rIO != null) {
            aVar.rIO.setVisibility(0);
        }
        if (aVar.rIN != null) {
            if (bo.isNullOrNil(DP.cqo().qUS)) {
                aVar.rIN.setVisibility(8);
            } else {
                aVar.rIN.setVisibility(0);
            }
        }
        com.tencent.mm.plugin.sns.storage.a cqq = DP.cqq();
        if (!(cqq == null || !cqq.coI() || DP.crg())) {
            aVar.rIM.setVisibility(0);
        }
        String str = bo.isNullOrNil(DP.cqo().qUT) ? timeLineObject.xfF : DP.cqo().qUT;
        if (bo.isNullOrNil(str)) {
            aVar.rIO.setVisibility(8);
        } else {
            aVar.rIO.setText(str + " ");
            j.h(aVar.rIO, 2);
            aVar.rIO.setVisibility(0);
        }
        str = DP.cqo().qUS;
        if (bo.isNullOrNil(str)) {
            aVar.rIN.setVisibility(8);
        } else {
            aVar.rIN.setText(str + " ");
            j.h(aVar.rIN, 2);
            aVar.rIN.setVisibility(0);
        }
        aVar.rIL.removeAllViews();
        if (DP.cqo().qUW.size() > 0) {
            aVar.rIL.setVisibility(0);
            aVar.rIL.setTagSpace(com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 6));
            aVar.rIL.dB(DP.cqo().qUW);
        }
        if (bo.isNullOrNil(DP.cqo().qUU)) {
            aVar.rIK.setVisibility(4);
        } else {
            aVar.rGM.setVisibility(0);
            aVar.rIK.setVisibility(0);
            aVar.rIK.setText(DP.cqo().qUU);
        }
        if (DP.cqo().qUG == 1) {
            baseViewHolder.rHz.setContentWidth(((((min - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.le)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc));
            baseViewHolder.rHz.crz();
        } else if (DP.cqo().qUG == 2) {
            baseViewHolder.rHz.setContentWidth((((min - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.le)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc));
            baseViewHolder.rHz.crz();
        }
        aVar.rGM.setTag(DP.cqo().qUV);
        if (bo.isNullOrNil(DP.cqo().qUV)) {
            aVar.rIJ.setVisibility(4);
        } else {
            h.a(DP.cqo().qUV, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(40128);
                    ab.i("MiroMsg.CardAdTimeLineItem", "download img %s", str);
                    if (!bo.Q((String) aVar.rGM.getTag(), str) && str.equals(h.gj("adId", (String) aVar.rGM.getTag()))) {
                        Bitmap decodeFile = d.decodeFile(str, null);
                        if (decodeFile != null) {
                            aVar.rGM.setVisibility(0);
                            aVar.rIJ.setImageBitmap(decodeFile);
                            aVar.rIJ.setVisibility(0);
                        }
                    }
                    AppMethodBeat.o(40128);
                }
            });
        }
        if (DP.cqo().coR() || DP.cqo().coS()) {
            aVar.rGG.setVisibility(0);
            int parseColor = Color.parseColor("#cdcdcd");
            int parseColor2 = Color.parseColor("#ffffff");
            Object obj = 1;
            if (DP.cqo().coS()) {
                int gr = v.gr(DP.cqo().qVh.qVu, DP.crc());
                if (gr > 0 && gr <= 2) {
                    if (gr == 1) {
                        aVar.rII.setBackgroundColor(parseColor2);
                        aVar.rII.setTextColor(parseColor);
                        aVar.rII.setText(DP.cqo().qVh.Dm(1));
                        aVar.rIH.setBackgroundResource(R.drawable.a0s);
                        aVar.rIH.setTextColor(WebView.NIGHT_MODE_COLOR);
                        aVar.rIH.setText(DP.cqo().qVh.Dl(0));
                    } else if (gr == 2) {
                        aVar.rIH.setBackgroundColor(parseColor2);
                        aVar.rIH.setTextColor(parseColor);
                        aVar.rIH.setText(DP.cqo().qVh.Dm(0));
                        aVar.rII.setBackgroundResource(R.drawable.a0s);
                        aVar.rII.setTextColor(WebView.NIGHT_MODE_COLOR);
                        aVar.rII.setText(DP.cqo().qVh.Dl(1));
                    }
                    obj = null;
                }
            }
            if (obj != null) {
                aVar.rIH.setTextColor(WebView.NIGHT_MODE_COLOR);
                aVar.rIH.setBackgroundResource(R.drawable.a0s);
                aVar.rII.setTextColor(WebView.NIGHT_MODE_COLOR);
                aVar.rII.setBackgroundResource(R.drawable.a0s);
                aVar.rIH.setText(DP.cqo().coL());
                aVar.rII.setText(DP.cqo().coM());
            }
        }
        aVar.rGX.setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        ((SightPlayImageView) aVar.rGD.qzM).qyI = true;
        ((SightPlayImageView) aVar.rGD.qzM).setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) timeLineObject.xfI.wbK.get(0);
        }
        baseViewHolder.rGD.a(timeLineObject, i, avVar.riA, avVar.rgZ);
        baseViewHolder.rGD.raQ.setVisibility(8);
        g cnC = af.cnC();
        if (bau != null) {
            int fromDPToPix = (((((min - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.lo)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.lo);
            min = (int) ((((float) fromDPToPix) * bau.wEK.wFy) / bau.wEK.wFx);
            if (baseViewHolder.timeLineObject.xfI.wbJ == 1) {
                aVar.rGX.setVisibility(0);
                aVar.rGD.rns.setVisibility(4);
                ViewGroup.LayoutParams layoutParams3 = aVar.rGX.getLayoutParams();
                layoutParams3.width = fromDPToPix;
                layoutParams3.height = min;
                aVar.rGX.setLayoutParams(layoutParams3);
                g cnC2 = af.cnC();
                View view = aVar.rGX;
                min = this.mActivity.hashCode();
                az dtg = az.dtg();
                dtg.oyB = timeLineObject.pcX;
                cnC2.b(bau, view, -1, min, dtg);
                aVar.rGX.setTag(aVar);
                aVar.rIH.setTag(aVar);
                aVar.rII.setTag(aVar);
                aVar.rGX.setOnClickListener(auVar.qOL.rjy);
                auVar.jMO.c(aVar.rGX, auVar.qOL.rJZ, auVar.qOL.rJH);
            } else if (baseViewHolder.timeLineObject.xfI.wbJ == 5 || baseViewHolder.timeLineObject.xfI.wbJ == 15) {
                aVar.rGD.rns.setVisibility(0);
                aVar.rGX.setVisibility(4);
                auVar.jMO.c(aVar.rGD.rnt, auVar.qOL.rJZ, auVar.qOL.rJH);
                ViewGroup.LayoutParams layoutParams4 = aVar.rGD.rns.getLayoutParams();
                layoutParams4.width = fromDPToPix;
                layoutParams4.height = min;
                aVar.rGD.rns.setLayoutParams(layoutParams4);
                aVar.rGD.qzM.fi(fromDPToPix, min);
                final au auVar2 = auVar;
                final av avVar2 = avVar;
                aVar.rGD.qzM.setOnCompletionListener(new e() {
                    public final void c(b bVar, int i) {
                        AppMethodBeat.i(40129);
                        if (i != -1) {
                            if (auVar2 == null || auVar2.rxP == null || auVar2.rxP.rhm == null) {
                                AppMethodBeat.o(40129);
                                return;
                            }
                            auVar2.rxP.rhm.u(avVar2.rAt, false);
                        }
                        AppMethodBeat.o(40129);
                    }
                });
                if (!auVar.rxP.rhm.jO(avVar.rAt)) {
                    auVar2 = auVar;
                    avVar2 = avVar;
                    aVar.rGD.qzM.setOnDecodeDurationListener(new f() {
                        public final void b(b bVar, long j) {
                            AppMethodBeat.i(40130);
                            if (auVar2 == null || auVar2.rxP == null || auVar2.rxP.rhm == null) {
                                AppMethodBeat.o(40130);
                                return;
                            }
                            if (j >= 3) {
                                int cle = (int) bVar.cle();
                                auVar2.rxP.rhm.c(avVar2.rAt, bo.yz(), false);
                                auVar2.rxP.rhm.f(avVar2.rAt, cle, false);
                                auVar2.rxP.rhm.T(avVar2.rAt, avVar2.rAt);
                                aVar.rGD.qzM.setOnDecodeDurationListener(null);
                            }
                            AppMethodBeat.o(40130);
                        }
                    });
                }
                long nanoTime = System.nanoTime() - System.nanoTime();
                ab.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(g.t(bau)), Long.valueOf(nanoTime));
                aj ajVar = aVar.rGD;
                if (g.t(bau)) {
                    if (cnC.u(bau)) {
                        ajVar.raP.setVisibility(0);
                        ajVar.rnu.setVisibility(8);
                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                        ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                    } else if (cnC.v(bau)) {
                        ajVar.raP.setVisibility(8);
                        ajVar.rnu.setVisibility(8);
                    } else if (cnC.b(DP, null) <= 5) {
                        ajVar.raP.setVisibility(8);
                        ajVar.rnu.setVisibility(8);
                    } else {
                        cnC.y(bau);
                        ajVar.raP.setVisibility(0);
                        ajVar.rnu.setVisibility(8);
                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                        ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                    }
                    if (ajVar.qzM.ckY()) {
                        ab.d("MiroMsg.CardAdTimeLineItem", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH + " " + i);
                        cnC.y(bau);
                        ajVar.raP.setVisibility(0);
                        ajVar.rnu.setVisibility(8);
                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                        ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                    }
                } else if (cnC.w(bau)) {
                    ajVar.raP.setVisibility(8);
                    ajVar.rnu.setVisibility(0);
                    ajVar.rnu.dKB();
                } else if (cnC.b(DP, null) == 5) {
                    cnC.A(bau);
                    ajVar.raP.setVisibility(8);
                    ajVar.rnu.setVisibility(0);
                    ajVar.rnu.dKB();
                } else if (cnC.x(bau)) {
                    ajVar.rnu.setVisibility(8);
                    ajVar.raP.setImageResource(R.drawable.atu);
                    ajVar.raP.setVisibility(0);
                } else {
                    cnC.y(bau);
                    ajVar.raP.setVisibility(0);
                    ajVar.rnu.setVisibility(8);
                    ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                    ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                    if (cnC.b(DP, null) == 4) {
                        ajVar.raQ.setVisibility(0);
                    }
                }
                aVar.rIH.setTag(aVar);
                aVar.rII.setTag(aVar);
                ajVar.qzM.setTagObject(ajVar);
                ajVar.rnt.setTag(aVar);
                com.tencent.mm.plugin.sight.decode.a.a aVar2 = ajVar.qzM;
                int hashCode = this.mActivity.hashCode();
                az dtg2 = az.dtg();
                dtg2.oyB = timeLineObject.pcX;
                cnC.a(DP, bau, aVar2, hashCode, i, dtg2, avVar.rgZ, true);
                if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau))) {
                    auVar.rxP.rhm.v(avVar.rAt, true);
                } else {
                    auVar.rxP.rhm.v(avVar.rAt, false);
                }
                auVar.rxP.rhm.c(avVar.rAt, af.cnC().b(DP, null) == 5, false);
            } else {
                cnC.a(baseViewHolder.rGD.qzM, this.mActivity.hashCode());
                baseViewHolder.rGD.rnv.setVisibility(8);
                baseViewHolder.rGD.qzM.setOnSightCompletionAction(null);
                baseViewHolder.rGD.qzM.setOnCompletionListener(null);
                baseViewHolder.rGD.qzM.setOnDecodeDurationListener(null);
            }
        }
        baseViewHolder.eBB = false;
        AppMethodBeat.o(40132);
    }
}
