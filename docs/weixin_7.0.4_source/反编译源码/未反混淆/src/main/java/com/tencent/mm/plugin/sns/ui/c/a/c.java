package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
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
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import java.util.Collections;
import java.util.List;

public final class c extends a {
    Context context;
    public View rGQ;
    public View rGR;
    private TextView rGS;
    private TextView rGT;
    private TextView rGU;
    private TextView rGV;
    public View rGW;
    public MaskImageView rGX;
    SnsDrawGestureView rGY;
    com.tencent.mm.plugin.sns.storage.b.c rGZ;
    g rqn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.c$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ a rHd;
        final /* synthetic */ n rhJ;

        AnonymousClass4(a aVar, n nVar) {
            this.rHd = aVar;
            this.rhJ = nVar;
        }

        public final void run() {
            AppMethodBeat.i(40100);
            c.this.rGY.setVisibility(0);
            c.this.rGY.cvA();
            c.this.rGY.setPaintColor(this.rHd.color);
            c.this.rGY.setOnGestureListener(new SnsDrawGestureView.a() {
                public final void cuU() {
                    AppMethodBeat.i(40097);
                    i.kI(false);
                    c.this.rGY.setBackgroundColor(c.this.context.getResources().getColor(R.color.a08));
                    AppMethodBeat.o(40097);
                }

                public final void dv(List<PointF> list) {
                    int i = 2;
                    AppMethodBeat.i(40098);
                    i.kI(true);
                    List Xs = i.Xs(AnonymousClass4.this.rHd.qVp);
                    c.this.rGY.setBackgroundColor(0);
                    if (Xs.size() <= 0 || list.size() <= 0) {
                        AppMethodBeat.o(40098);
                        return;
                    }
                    try {
                        float r = com.tencent.mm.ui.tools.a.a.r(Xs, list);
                        Collections.reverse(Xs);
                        ab.i("MicroMsg.FullCardAdDetailItem", "similarity: %f,%f, distance:%f", Float.valueOf(r), Float.valueOf(com.tencent.mm.ui.tools.a.a.r(Xs, list)), Float.valueOf((float) Math.acos((double) Math.max(r, com.tencent.mm.ui.tools.a.a.r(Xs, list)))));
                        if (((float) Math.acos((double) Math.max(r, com.tencent.mm.ui.tools.a.a.r(Xs, list)))) <= AnonymousClass4.this.rHd.qVo) {
                            c.this.rqo.a(c.this);
                            i.e(new long[]{20, 100});
                            int[] iArr = new int[2];
                            c.this.contentView.getLocationInWindow(iArr);
                            Intent intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", c.this.contentView.getWidth());
                            intent.putExtra("img_gallery_height", c.this.contentView.getHeight());
                            intent.putExtra("sns_landing_pages_share_sns_id", AnonymousClass4.this.rhJ.cqA());
                            intent.putExtra("sns_landing_pages_rawSnsId", AnonymousClass4.this.rhJ.cqu().Id);
                            intent.putExtra("sns_landing_pages_ux_info", AnonymousClass4.this.rhJ.crc());
                            String coW = AnonymousClass4.this.rhJ.cqo().coW();
                            if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.go(AnonymousClass4.this.rhJ.cqo().cHz, "adFullCardGestureCanvasInfo")) {
                                coW.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
                            }
                            intent.putExtra("sns_landing_pages_xml", coW);
                            intent.setClass(c.this.context, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landig_pages_from_source", 2);
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            intent.putExtra("sns_landing_is_native_sight_ad", true);
                            c.this.context.startActivity(intent);
                            i.a(new SnsAdClick(1, 2, i.Xq(AnonymousClass4.this.rhJ.cqu().Id), 25, 21));
                        } else {
                            i = 1;
                        }
                        h.pYm.e(16552, AnonymousClass4.this.rhJ.cqu().Id, i.dd(Xs), i.dd(com.tencent.mm.ui.tools.a.a.v(list, 20)), Integer.valueOf((int) (100.0f * r9)), Integer.valueOf(i), Long.valueOf(bo.anl(AnonymousClass4.this.rhJ.cqZ())), AnonymousClass4.this.rhJ.cqq().qPj);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FullCardAdDetailItem", e, "recog gesture error!", new Object[0]);
                    } finally {
                        c.this.rGY.cvA();
                        AppMethodBeat.o(40098);
                    }
                }

                public final void onClick() {
                    AppMethodBeat.i(40099);
                    i.kI(true);
                    c.this.rGY.setBackgroundColor(0);
                    c.this.rGD.rns.performClick();
                    AppMethodBeat.o(40099);
                }
            });
            AppMethodBeat.o(40100);
        }
    }

    public c(TimeLineObject timeLineObject, n nVar, b bVar, g gVar) {
        this.timeLineObject = timeLineObject;
        this.ros = nVar;
        this.rqo = bVar;
        this.rqn = gVar;
    }

    public final void g(View view, View view2) {
        AppMethodBeat.i(40102);
        this.contentView = view;
        this.rpP = view2;
        this.context = view.getContext();
        this.rGQ = view.findViewById(R.id.ema);
        this.rGR = view.findViewById(R.id.emd);
        this.rGS = (TextView) view.findViewById(R.id.emb);
        this.rGT = (TextView) view.findViewById(R.id.emc);
        this.rGU = (TextView) view.findViewById(R.id.eme);
        this.rGV = (TextView) view.findViewById(R.id.emf);
        this.rGW = view.findViewById(R.id.emg);
        this.rGX = (MaskImageView) view.findViewById(R.id.em9);
        this.rGY = (SnsDrawGestureView) view.findViewById(R.id.emh);
        this.rGX.setScaleType(QImageView.a.CENTER_CROP);
        this.rGD = new aj();
        this.rGD.rnt = view.findViewById(R.id.em_);
        this.rGD.rns = this.rGD.rnt;
        this.rGD.rnt.setOnClickListener(this.rqo.rKe);
        this.rGD.qzM = (com.tencent.mm.plugin.sight.decode.a.a) this.rGD.rnt.findViewById(R.id.bl);
        this.rGD.raP = (ImageView) this.rGD.rnt.findViewById(R.id.l4);
        this.rGD.rnu = (MMPinProgressBtn) this.rGD.rnt.findViewById(R.id.vm);
        this.rGD.rnv = (TextView) this.rGD.rnt.findViewById(R.id.edy);
        this.rGD.raQ = (TextView) this.rGD.rnt.findViewById(R.id.edz);
        ((SightPlayImageView) this.rGD.qzM).qyI = true;
        ((SightPlayImageView) this.rGD.qzM).setScaleType(QImageView.a.CENTER_CROP);
        AppMethodBeat.o(40102);
    }

    public final void refreshView() {
        bau bau;
        AppMethodBeat.i(40103);
        this.ros = com.tencent.mm.plugin.sns.storage.h.YS(this.ros.cqA());
        this.rGZ = null;
        if (!(this.ros == null || this.ros.cqo() == null)) {
            this.rGZ = this.ros.cqo().qUY;
        }
        LayoutParams layoutParams = null;
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        this.rGQ.setVisibility(8);
        this.rGS.setVisibility(8);
        this.rGT.setVisibility(8);
        this.rGR.setVisibility(8);
        this.rGU.setVisibility(8);
        this.rGV.setVisibility(8);
        this.rGW.setVisibility(8);
        if (this.rGZ != null) {
            LayoutParams layoutParams2;
            GradientDrawable gradientDrawable;
            int al = ((((min - com.tencent.mm.bz.a.al(this.context, R.dimen.a94)) - com.tencent.mm.bz.a.al(this.context, R.dimen.nj)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.nc);
            if (this.rGZ.qVk == 0) {
                layoutParams2 = new LayoutParams(-2, -2);
                layoutParams2.width = al;
                layoutParams2.height = (int) (((float) layoutParams2.width) * 0.75f);
                layoutParams = layoutParams2;
            } else if (this.rGZ.qVk == 1) {
                layoutParams2 = new LayoutParams(-2, -2);
                layoutParams2.width = al;
                layoutParams2.height = layoutParams2.width;
                layoutParams = layoutParams2;
            }
            if (layoutParams != null) {
                layoutParams2 = this.contentView.getLayoutParams();
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.contentView.setLayoutParams(layoutParams2);
                ((RoundedCornerRelativeLayout) this.contentView).setRadius(8.0f);
                layoutParams2 = this.rGX.getLayoutParams();
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.rGX.setLayoutParams(layoutParams2);
                layoutParams2 = this.rGD.rns.getLayoutParams();
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.rGD.rns.setLayoutParams(layoutParams2);
                this.rGD.qzM.fi(layoutParams.width, layoutParams.height);
            }
            TextView textView;
            com.tencent.mm.cb.g dqQ;
            if (this.rGZ.qVm == 0) {
                gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) this.rGZ.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                this.rGQ.setBackground(gradientDrawable);
                if (!(bo.isNullOrNil(this.rGZ.title) && bo.isNullOrNil(this.rGZ.description))) {
                    this.rGQ.setVisibility(0);
                }
                this.rGR.setVisibility(8);
                if (!bo.isNullOrNil(this.rGZ.title)) {
                    this.rGS.setVisibility(0);
                    textView = this.rGS;
                    dqQ = com.tencent.mm.cb.g.dqQ();
                    this.rGS.getContext();
                    textView.setText(dqQ.b(this.rGZ.title, this.rGS.getTextSize()));
                }
                if (!bo.isNullOrNil(this.rGZ.description)) {
                    this.rGT.setVisibility(0);
                    textView = this.rGT;
                    dqQ = com.tencent.mm.cb.g.dqQ();
                    this.rGT.getContext();
                    textView.setText(dqQ.b(this.rGZ.description, this.rGT.getTextSize()));
                }
            } else if (this.rGZ.qVm == 1) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.rGZ.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                this.rGQ.setVisibility(8);
                this.rGR.setBackground(gradientDrawable);
                if (!(bo.isNullOrNil(this.rGZ.title) && bo.isNullOrNil(this.rGZ.description))) {
                    this.rGR.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.rGW.getLayoutParams();
                    layoutParams3.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 4);
                    this.rGW.setLayoutParams(layoutParams3);
                }
                if (!bo.isNullOrNil(this.rGZ.title)) {
                    this.rGU.setVisibility(0);
                    textView = this.rGU;
                    dqQ = com.tencent.mm.cb.g.dqQ();
                    this.rGU.getContext();
                    textView.setText(dqQ.b(this.rGZ.title, this.rGU.getTextSize()));
                }
                if (!bo.isNullOrNil(this.rGZ.description)) {
                    this.rGV.setVisibility(0);
                    textView = this.rGV;
                    dqQ = com.tencent.mm.cb.g.dqQ();
                    this.rGV.getContext();
                    textView.setText(dqQ.b(this.rGZ.description, this.rGV.getTextSize()));
                }
            }
            if (this.ros.cqq().coI()) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.rGZ.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                this.rGR.setVisibility(0);
                this.rGR.setBackground(gradientDrawable);
                this.rGW.setVisibility(0);
            }
        } else {
            ab.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
        }
        if (this.timeLineObject.xfI == null || this.timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) this.timeLineObject.xfI.wbK.get(0);
        }
        this.rGD.a(this.timeLineObject, 0, this.ros.cqU(), true);
        this.rGD.raQ.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
        if (bau != null) {
            final long j = this.ros.field_snsId;
            if (this.timeLineObject.xfI.wbJ == 1) {
                this.rGX.setVisibility(0);
                this.rGX.setTag(this);
                this.rGX.setOnClickListener(this.rqo.rKn);
                View view = this.rGX;
                int hashCode = this.context.hashCode();
                az dtg = az.dtg();
                dtg.oyB = this.timeLineObject.pcX;
                cnC.a(bau, view, -1, hashCode, dtg, 3);
                AppMethodBeat.o(40103);
                return;
            }
            if (this.timeLineObject.xfI.wbJ == 15 || this.timeLineObject.xfI.wbJ == 5) {
                long nanoTime = System.nanoTime() - System.nanoTime();
                ab.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(bau)), Long.valueOf(nanoTime));
                this.rGD.qzM.setOnCompletionListener(new e() {
                    public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                        AppMethodBeat.i(40094);
                        if (i != -1) {
                            c.this.rqn.u(j, false);
                        }
                        AppMethodBeat.o(40094);
                    }
                });
                if (!(this.rqn == null || this.rqn.jO(j))) {
                    this.rGD.qzM.setOnDecodeDurationListener(new f() {
                        public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                            int cle;
                            AppMethodBeat.i(40095);
                            if (j >= 3) {
                                cle = (int) bVar.cle();
                                c.this.rqn.c(j, bo.yz(), false);
                                c.this.rqn.f(j, cle, false);
                                c.this.rqn.T(j, j);
                            }
                            ab.d("MicroMsg.FullCardAdDetailItem", "sight play %d", Long.valueOf(j));
                            cle = (int) j;
                            c cVar = c.this;
                            com.tencent.mm.plugin.sns.storage.b.c cVar2 = c.this.rGZ;
                            n nVar = c.this.ros;
                            cle *= 1000;
                            a aVar = cVar2.qVn;
                            if (!bo.isNullOrNil(nVar.cqo().coW()) && aVar != null && aVar.startTime >= 0 && aVar.endTime > aVar.startTime) {
                                ab.i("MicroMsg.FullCardAdDetailItem", "%d-%d,%d", Long.valueOf(aVar.startTime), Long.valueOf(aVar.endTime), Integer.valueOf(cle));
                                if (aVar.startTime > ((long) cle) || aVar.endTime < ((long) cle)) {
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(40101);
                                            c.this.rGY.setVisibility(8);
                                            c.this.rGY.setBackgroundColor(0);
                                            c.this.rGY.cvA();
                                            c.this.rGY.setOnGestureListener(null);
                                            AppMethodBeat.o(40101);
                                        }
                                    });
                                } else if (cVar.rGY.getOnGestureListener() == null) {
                                    al.d(new AnonymousClass4(aVar, nVar));
                                    AppMethodBeat.o(40095);
                                    return;
                                }
                            }
                            AppMethodBeat.o(40095);
                        }
                    });
                }
                a aVar = this.rGZ.qVn;
                final String coW = this.ros.cqo().coW();
                if (!bo.isNullOrNil(coW) && aVar != null && aVar.startTime >= 0 && aVar.endTime > aVar.startTime) {
                    d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(40096);
                            j.cql().f("adId", coW, "adxml", 0);
                            AppMethodBeat.o(40096);
                        }
                    }, "preDownloadFloatPage");
                }
                if (r4) {
                    if (cnC.u(bau)) {
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                    } else if (cnC.v(bau)) {
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(8);
                    } else if (cnC.b(this.ros, null) <= 5) {
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(8);
                    } else {
                        cnC.y(bau);
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                    }
                    if (this.rGD.qzM.ckY()) {
                        ab.d("MicroMsg.FullCardAdDetailItem", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH);
                        cnC.y(bau);
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                    }
                } else if (cnC.w(bau)) {
                    this.rGD.raP.setVisibility(8);
                    this.rGD.rnu.setVisibility(0);
                    this.rGD.rnu.dKB();
                } else if (cnC.b(this.ros, null) == 5) {
                    cnC.A(bau);
                    this.rGD.raP.setVisibility(8);
                    this.rGD.rnu.setVisibility(0);
                    this.rGD.rnu.dKB();
                } else if (cnC.x(bau)) {
                    this.rGD.rnu.setVisibility(8);
                    this.rGD.raP.setImageResource(R.drawable.atu);
                    this.rGD.raP.setVisibility(0);
                } else {
                    cnC.y(bau);
                    this.rGD.raP.setVisibility(0);
                    this.rGD.rnu.setVisibility(8);
                    this.rGD.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                    this.rGD.raP.setContentDescription(this.context.getString(R.string.dco));
                    if (cnC.b(this.ros, null) == 4) {
                        this.rGD.raQ.setVisibility(0);
                    }
                }
                this.rGD.rns.setVisibility(0);
                this.rGD.qzM.setTagObject(this.rGD);
                this.rGD.rnt.setTag(this);
                this.rGD.rns.setOnClickListener(this.rqo.rKn);
                n nVar = this.ros;
                com.tencent.mm.plugin.sight.decode.a.a aVar2 = this.rGD.qzM;
                int hashCode2 = this.context.hashCode();
                az dtg2 = az.dtg();
                dtg2.oyB = this.timeLineObject.pcX;
                cnC.a(nVar, bau, aVar2, hashCode2, 0, dtg2, true, true);
                String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                String j2 = i.j(bau);
                if (this.rqn != null) {
                    if (com.tencent.mm.vfs.e.ct(fZ + j2)) {
                        this.rqn.v(j, true);
                    } else {
                        this.rqn.v(j, false);
                    }
                    this.rqn.c(j, af.cnC().b(this.ros, null) == 5, false);
                }
            }
            AppMethodBeat.o(40103);
            return;
        }
        cnC.a(this.rGD.qzM, this.context.hashCode());
        this.rGD.rnv.setVisibility(8);
        this.rGD.qzM.setOnSightCompletionAction(null);
        this.rGD.qzM.setOnCompletionListener(null);
        this.rGD.qzM.setOnDecodeDurationListener(null);
        AppMethodBeat.o(40103);
    }
}
