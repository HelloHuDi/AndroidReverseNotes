package com.tencent.mm.plugin.sns.ui.item;

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
import com.tencent.mm.R;
import com.tencent.mm.cb.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import java.util.Collections;
import java.util.List;

public final class c extends BaseTimeLineItem {

    public static class a extends BaseViewHolder {
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

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40143);
        a aVar = (a) baseViewHolder;
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(R.layout.awm);
            if (!baseViewHolder.rHD) {
                aVar.roq = baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        } else if (!baseViewHolder.rHD) {
            aVar.roq = baseViewHolder.mRR.findViewById(R.id.em8);
            baseViewHolder.rHD = true;
        }
        aVar.rGQ = aVar.mRR.findViewById(R.id.ema);
        aVar.rGR = aVar.mRR.findViewById(R.id.emd);
        aVar.rGS = (TextView) aVar.mRR.findViewById(R.id.emb);
        aVar.rGT = (TextView) aVar.mRR.findViewById(R.id.emc);
        aVar.rGU = (TextView) aVar.mRR.findViewById(R.id.eme);
        aVar.rGV = (TextView) aVar.mRR.findViewById(R.id.emf);
        aVar.rGX = (MaskImageView) aVar.mRR.findViewById(R.id.em9);
        aVar.rGW = aVar.mRR.findViewById(R.id.emg);
        aVar.rGX.setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        aVar.rGD = new aj();
        aVar.rGD.rnt = aVar.roq.findViewById(R.id.em_);
        aVar.rGD.rns = aVar.rGD.rnt;
        aVar.rGD.rnt.setOnClickListener(this.qPr.qOL.rKe);
        aVar.rGD.qzM = (com.tencent.mm.plugin.sight.decode.a.a) aVar.rGD.rnt.findViewById(R.id.bl);
        aVar.rGD.raP = (ImageView) aVar.rGD.rnt.findViewById(R.id.l4);
        aVar.rGD.rnu = (MMPinProgressBtn) aVar.rGD.rnt.findViewById(R.id.vm);
        aVar.rGD.rnv = (TextView) aVar.rGD.rnt.findViewById(R.id.edy);
        aVar.rGD.raQ = (TextView) aVar.rGD.rnt.findViewById(R.id.edz);
        ((SightPlayImageView) aVar.rGD.qzM).qyI = true;
        ((SightPlayImageView) aVar.rGD.qzM).setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        aVar.rGY = (SnsDrawGestureView) aVar.mRR.findViewById(R.id.emh);
        AppMethodBeat.o(40143);
    }

    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40144);
        ab.i("MicroMsg.FullCardAdTimeLineItem", "fill full card ad item %d", Integer.valueOf(i));
        if (baseViewHolder.eBB) {
            ab.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
            AppMethodBeat.o(40144);
            return;
        }
        bau bau;
        final a aVar = (a) baseViewHolder;
        final n nVar = avVar.qBY;
        com.tencent.mm.plugin.sns.storage.b.c cVar = null;
        if (!(nVar == null || nVar.cqo() == null)) {
            cVar = nVar.cqo().qUY;
        }
        WindowManager windowManager = (WindowManager) this.mActivity.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        aVar.rGQ.setVisibility(8);
        aVar.rGS.setVisibility(8);
        aVar.rGT.setVisibility(8);
        aVar.rGR.setVisibility(8);
        aVar.rGU.setVisibility(8);
        aVar.rGV.setVisibility(8);
        aVar.rGW.setVisibility(8);
        aVar.rGY.setVisibility(8);
        aVar.rGD.qzM.setOnCompletionListener(null);
        aVar.rGD.qzM.setOnDecodeDurationListener(null);
        a(aVar);
        if (cVar != null) {
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            GradientDrawable gradientDrawable;
            min = (((min - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 54)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.le)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.nc);
            if (cVar.qVk == 0) {
                layoutParams = new LayoutParams(-2, -2);
                layoutParams.width = min;
                layoutParams.height = (int) (((float) layoutParams.width) * 0.75f);
                layoutParams2 = layoutParams;
            } else if (cVar.qVk == 1) {
                layoutParams = new LayoutParams(-2, -2);
                layoutParams.width = min;
                layoutParams.height = layoutParams.width;
                layoutParams2 = layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams = aVar.roq.getLayoutParams();
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                aVar.roq.setLayoutParams(layoutParams);
                ((RoundedCornerRelativeLayout) aVar.roq).setRadius(8.0f);
                layoutParams = aVar.rGX.getLayoutParams();
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                aVar.rGX.setLayoutParams(layoutParams);
                layoutParams = aVar.rGD.rns.getLayoutParams();
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                aVar.rGD.rns.setLayoutParams(layoutParams);
                aVar.rGD.qzM.fi(layoutParams2.width, layoutParams2.height);
            }
            TextView textView;
            g dqQ;
            if (cVar.qVm == 0) {
                gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) cVar.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                aVar.rGQ.setBackground(gradientDrawable);
                if (!(bo.isNullOrNil(cVar.title) && bo.isNullOrNil(cVar.description))) {
                    aVar.rGQ.setVisibility(0);
                }
                if (!bo.isNullOrNil(cVar.title)) {
                    aVar.rGS.setVisibility(0);
                    textView = aVar.rGS;
                    dqQ = g.dqQ();
                    aVar.rGS.getContext();
                    textView.setText(dqQ.b(cVar.title, aVar.rGS.getTextSize()));
                }
                if (!bo.isNullOrNil(cVar.description)) {
                    aVar.rGT.setVisibility(0);
                    textView = aVar.rGT;
                    dqQ = g.dqQ();
                    aVar.rGT.getContext();
                    textView.setText(dqQ.b(cVar.description, aVar.rGT.getTextSize()));
                }
            } else if (cVar.qVm == 1) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) cVar.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                aVar.rGR.setBackground(gradientDrawable);
                if (!(bo.isNullOrNil(cVar.title) && bo.isNullOrNil(cVar.description))) {
                    aVar.rGR.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aVar.rGW.getLayoutParams();
                    layoutParams3.topMargin = com.tencent.mm.bz.a.fromDPToPix(aVar.roq.getContext(), 4);
                    aVar.rGW.setLayoutParams(layoutParams3);
                }
                if (!bo.isNullOrNil(cVar.title)) {
                    aVar.rGU.setVisibility(0);
                    textView = aVar.rGU;
                    dqQ = g.dqQ();
                    aVar.rGU.getContext();
                    textView.setText(dqQ.b(cVar.title, aVar.rGU.getTextSize()));
                }
                if (!bo.isNullOrNil(cVar.description)) {
                    aVar.rGV.setVisibility(0);
                    textView = aVar.rGV;
                    dqQ = g.dqQ();
                    aVar.rGV.getContext();
                    textView.setText(dqQ.b(cVar.description, aVar.rGV.getTextSize()));
                }
            }
            if (nVar.cqq().coI()) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) cVar.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                aVar.rGR.setVisibility(0);
                aVar.rGR.setBackground(gradientDrawable);
                aVar.rGW.setVisibility(0);
            }
        } else {
            ab.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
        }
        if (timeLineObject.xfI == null || timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) timeLineObject.xfI.wbK.get(0);
        }
        baseViewHolder.rGD.a(timeLineObject, i, avVar.riA, avVar.rgZ);
        baseViewHolder.rGD.raQ.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
        if (bau == null) {
            cnC.a(baseViewHolder.rGD.qzM, this.mActivity.hashCode());
            baseViewHolder.rGD.rnv.setVisibility(8);
            baseViewHolder.rGD.qzM.setOnSightCompletionAction(null);
            baseViewHolder.rGD.qzM.setOnCompletionListener(null);
            baseViewHolder.rGD.qzM.setOnDecodeDurationListener(null);
        } else if (timeLineObject.xfI.wbJ == 1) {
            aVar.rGX.setVisibility(0);
            aVar.rGD.rns.setVisibility(4);
            View view = aVar.rGX;
            int hashCode = this.mActivity.hashCode();
            az dtg = az.dtg();
            dtg.oyB = timeLineObject.pcX;
            cnC.b(bau, view, -1, hashCode, dtg);
            aVar.rGX.setTag(baseViewHolder);
            aVar.rGX.setOnClickListener(auVar.qOL.rKn);
            AppMethodBeat.o(40144);
            return;
        } else if (timeLineObject.xfI.wbJ == 15 || timeLineObject.xfI.wbJ == 5) {
            final au auVar2 = auVar;
            final av avVar2 = avVar;
            aVar.rGD.qzM.setOnCompletionListener(new e() {
                public final void c(b bVar, int i) {
                    AppMethodBeat.i(40135);
                    ab.i("MicroMsg.FullCardAdTimeLineItem", "sight play completed!");
                    if (i != -1) {
                        if (auVar2 == null || auVar2.rxP == null || auVar2.rxP.rhm == null) {
                            AppMethodBeat.o(40135);
                            return;
                        }
                        auVar2.rxP.rhm.u(avVar2.rAt, false);
                    }
                    AppMethodBeat.o(40135);
                }
            });
            final au auVar3 = auVar;
            final av avVar3 = avVar;
            aVar.rGD.qzM.setOnDecodeDurationListener(new f() {
                public final void b(b bVar, long j) {
                    AppMethodBeat.i(40136);
                    if (auVar3 == null || auVar3.rxP == null || auVar3.rxP.rhm == null) {
                        AppMethodBeat.o(40136);
                        return;
                    }
                    if (!auVar3.rxP.rhm.jO(avVar3.rAt) && j >= 3) {
                        int cle = (int) bVar.cle();
                        auVar3.rxP.rhm.c(avVar3.rAt, bo.yz(), false);
                        auVar3.rxP.rhm.f(avVar3.rAt, cle, false);
                        auVar3.rxP.rhm.T(avVar3.rAt, avVar3.rAt);
                    }
                    ab.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", Long.valueOf(j));
                    c.a(c.this, aVar, cVar, nVar, ((int) j) * 1000);
                    AppMethodBeat.o(40136);
                }
            });
            com.tencent.mm.plugin.sns.storage.b.c.a aVar2 = cVar.qVn;
            final String coW = nVar.cqo().coW();
            if (!bo.isNullOrNil(coW) && aVar2 != null && aVar2.startTime >= 0 && aVar2.endTime > aVar2.startTime) {
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40137);
                        j.cql().f("adId", coW, "adxml", 0);
                        AppMethodBeat.o(40137);
                    }
                }, "preDownloadFloatPage");
            }
            long nanoTime = System.nanoTime() - System.nanoTime();
            ab.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(bau)), Long.valueOf(nanoTime));
            aj ajVar = aVar.rGD;
            if (com.tencent.mm.plugin.sns.model.g.t(bau)) {
                if (cnC.u(bau)) {
                    ajVar.raP.setVisibility(0);
                    ajVar.rnu.setVisibility(8);
                    ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.mActivity, R.raw.shortvideo_play_btn));
                    ajVar.raP.setContentDescription(this.mActivity.getString(R.string.dco));
                } else if (cnC.v(bau)) {
                    ajVar.raP.setVisibility(8);
                    ajVar.rnu.setVisibility(8);
                } else if (cnC.b(nVar, null) <= 5) {
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
                    ab.d("MicroMsg.FullCardAdTimeLineItem", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH + " " + i);
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
            } else if (cnC.b(nVar, null) == 5) {
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
                if (cnC.b(nVar, null) == 4) {
                    ajVar.raQ.setVisibility(0);
                }
            }
            aVar.rGD.rns.setVisibility(0);
            aVar.rGX.setVisibility(4);
            ajVar.qzM.setTagObject(ajVar);
            ajVar.rnt.setTag(baseViewHolder);
            aVar.rGD.rns.setOnClickListener(auVar.qOL.rKn);
            com.tencent.mm.plugin.sight.decode.a.a aVar3 = ajVar.qzM;
            int hashCode2 = this.mActivity.hashCode();
            az dtg2 = az.dtg();
            dtg2.oyB = timeLineObject.pcX;
            cnC.a(nVar, bau, aVar3, hashCode2, i, dtg2, avVar.rgZ, true);
            if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau))) {
                auVar.rxP.rhm.v(avVar.rAt, true);
            } else {
                auVar.rxP.rhm.v(avVar.rAt, false);
            }
            auVar.rxP.rhm.c(avVar.rAt, af.cnC().b(nVar, null) == 5, false);
            AppMethodBeat.o(40144);
            return;
        }
        AppMethodBeat.o(40144);
    }

    private void a(final a aVar) {
        AppMethodBeat.i(40145);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(40142);
                aVar.rGY.setVisibility(8);
                aVar.rGY.setBackgroundColor(0);
                aVar.rGY.cvA();
                aVar.rGY.setOnGestureListener(null);
                AppMethodBeat.o(40142);
            }
        });
        AppMethodBeat.o(40145);
    }

    static /* synthetic */ void a(c cVar, final a aVar, com.tencent.mm.plugin.sns.storage.b.c cVar2, final n nVar, int i) {
        AppMethodBeat.i(40146);
        final com.tencent.mm.plugin.sns.storage.b.c.a aVar2 = cVar2.qVn;
        if (!bo.isNullOrNil(nVar.cqo().coW()) && aVar2 != null && aVar2.startTime >= 0 && aVar2.endTime > aVar2.startTime) {
            ab.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", Long.valueOf(aVar2.startTime), Long.valueOf(aVar2.endTime), Integer.valueOf(i));
            if (aVar2.startTime > ((long) i) || aVar2.endTime < ((long) i)) {
                cVar.a(aVar);
            } else if (aVar.rGY.getOnGestureListener() == null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(40141);
                        aVar.rGY.setVisibility(0);
                        aVar.rGY.cvA();
                        aVar.rGY.setPaintColor(aVar2.color);
                        aVar.rGY.setOnGestureListener(new com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a() {
                            public final void cuU() {
                                AppMethodBeat.i(40138);
                                i.kI(false);
                                aVar.rGY.setBackgroundColor(c.this.mActivity.getResources().getColor(R.color.a08));
                                AppMethodBeat.o(40138);
                            }

                            public final void dv(List<PointF> list) {
                                int i = 2;
                                AppMethodBeat.i(40139);
                                i.kI(true);
                                List Xs = i.Xs(aVar2.qVp);
                                aVar.rGY.setBackgroundColor(0);
                                if (Xs.size() <= 0 || list.size() <= 0) {
                                    AppMethodBeat.o(40139);
                                    return;
                                }
                                try {
                                    float r = com.tencent.mm.ui.tools.a.a.r(Xs, list);
                                    String dd = i.dd(Xs);
                                    Collections.reverse(Xs);
                                    ab.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", Float.valueOf(r), Float.valueOf(com.tencent.mm.ui.tools.a.a.r(Xs, list)), Float.valueOf((float) Math.acos((double) Math.max(r, com.tencent.mm.ui.tools.a.a.r(Xs, list)))));
                                    if (((float) Math.acos((double) Math.max(r, com.tencent.mm.ui.tools.a.a.r(Xs, list)))) <= aVar2.qVo) {
                                        c.this.qPr.rxP.rhA.h(aVar);
                                        i.e(new long[]{20, 100});
                                        int[] iArr = new int[2];
                                        aVar.roq.getLocationInWindow(iArr);
                                        Intent intent = new Intent();
                                        intent.putExtra("img_gallery_left", iArr[0]);
                                        intent.putExtra("img_gallery_top", iArr[1]);
                                        intent.putExtra("img_gallery_width", aVar.roq.getWidth());
                                        intent.putExtra("img_gallery_height", aVar.roq.getHeight());
                                        intent.putExtra("sns_landing_pages_share_sns_id", nVar.cqA());
                                        intent.putExtra("sns_landing_pages_rawSnsId", nVar.cqu().Id);
                                        intent.putExtra("sns_landing_pages_ux_info", nVar.crc());
                                        String coW = nVar.cqo().coW();
                                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.go(nVar.cqo().cHz, "adFullCardGestureCanvasInfo")) {
                                            coW.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
                                        }
                                        intent.putExtra("sns_landing_pages_xml", coW);
                                        intent.setClass(c.this.mActivity, SnsAdNativeLandingPagesUI.class);
                                        intent.putExtra("sns_landig_pages_from_source", 1);
                                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                                        c.this.mActivity.startActivity(intent);
                                        i.a(new SnsAdClick(1, 1, i.Xq(nVar.cqu().Id), 25, 21));
                                    } else {
                                        i = 1;
                                    }
                                    h.pYm.e(16552, nVar.cqu().Id, dd, i.dd(com.tencent.mm.ui.tools.a.a.v(list, 20)), Integer.valueOf((int) (100.0f * r9)), Integer.valueOf(i), Long.valueOf(bo.anl(nVar.cqZ())), nVar.cqq().qPj);
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", e, "recog gesture error!", new Object[0]);
                                } finally {
                                    aVar.rGY.cvA();
                                    AppMethodBeat.o(40139);
                                }
                            }

                            public final void onClick() {
                                AppMethodBeat.i(40140);
                                i.kI(true);
                                aVar.rGY.setBackgroundColor(0);
                                aVar.rGD.rns.performClick();
                                AppMethodBeat.o(40140);
                            }
                        });
                        AppMethodBeat.o(40141);
                    }
                });
                AppMethodBeat.o(40146);
                return;
            }
        }
        AppMethodBeat.o(40146);
    }
}
