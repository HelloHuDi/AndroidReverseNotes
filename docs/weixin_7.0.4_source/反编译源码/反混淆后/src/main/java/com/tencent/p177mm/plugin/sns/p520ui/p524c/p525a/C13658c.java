package com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a;

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
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13342g;
import com.tencent.p177mm.plugin.sns.p520ui.C43589aj;
import com.tencent.p177mm.plugin.sns.p520ui.MaskImageView;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdNativeLandingPagesUI;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsDrawGestureView;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsDrawGestureView.C35145a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C34998j;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C13475c;
import com.tencent.p177mm.plugin.sns.storage.C21984b.C13475c.C13476a;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
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

/* renamed from: com.tencent.mm.plugin.sns.ui.c.a.c */
public final class C13658c extends C35118a {
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
    C13475c rGZ;
    C13342g rqn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.c$5 */
    class C136605 implements Runnable {
        C136605() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40101);
            C13658c.this.rGY.setVisibility(8);
            C13658c.this.rGY.setBackgroundColor(0);
            C13658c.this.rGY.cvA();
            C13658c.this.rGY.setOnGestureListener(null);
            AppMethodBeat.m2505o(40101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.c$4 */
    class C136614 implements Runnable {
        final /* synthetic */ C13476a rHd;
        final /* synthetic */ C46236n rhJ;

        /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.c$4$1 */
        class C136621 implements C35145a {
            C136621() {
            }

            public final void cuU() {
                AppMethodBeat.m2504i(40097);
                C29036i.m46120kI(false);
                C13658c.this.rGY.setBackgroundColor(C13658c.this.context.getResources().getColor(C25738R.color.a08));
                AppMethodBeat.m2505o(40097);
            }

            /* renamed from: dv */
            public final void mo25866dv(List<PointF> list) {
                int i = 2;
                AppMethodBeat.m2504i(40098);
                C29036i.m46120kI(true);
                List Xs = C29036i.m46096Xs(C136614.this.rHd.qVp);
                C13658c.this.rGY.setBackgroundColor(0);
                if (Xs.size() <= 0 || list.size() <= 0) {
                    AppMethodBeat.m2505o(40098);
                    return;
                }
                try {
                    float r = C44380a.m80240r(Xs, list);
                    Collections.reverse(Xs);
                    C4990ab.m7417i("MicroMsg.FullCardAdDetailItem", "similarity: %f,%f, distance:%f", Float.valueOf(r), Float.valueOf(C44380a.m80240r(Xs, list)), Float.valueOf((float) Math.acos((double) Math.max(r, C44380a.m80240r(Xs, list)))));
                    if (((float) Math.acos((double) Math.max(r, C44380a.m80240r(Xs, list)))) <= C136614.this.rHd.qVo) {
                        C13658c.this.rqo.mo37646a(C13658c.this);
                        C29036i.m46109e(new long[]{20, 100});
                        int[] iArr = new int[2];
                        C13658c.this.contentView.getLocationInWindow(iArr);
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", C13658c.this.contentView.getWidth());
                        intent.putExtra("img_gallery_height", C13658c.this.contentView.getHeight());
                        intent.putExtra("sns_landing_pages_share_sns_id", C136614.this.rhJ.cqA());
                        intent.putExtra("sns_landing_pages_rawSnsId", C136614.this.rhJ.cqu().f15074Id);
                        intent.putExtra("sns_landing_pages_ux_info", C136614.this.rhJ.crc());
                        String coW = C136614.this.rhJ.cqo().coW();
                        if (!C3953i.m6305go(C136614.this.rhJ.cqo().cHz, "adFullCardGestureCanvasInfo")) {
                            coW.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
                        }
                        intent.putExtra("sns_landing_pages_xml", coW);
                        intent.setClass(C13658c.this.context, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landig_pages_from_source", 2);
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        C13658c.this.context.startActivity(intent);
                        C29036i.m46098a(new SnsAdClick(1, 2, C29036i.m46094Xq(C136614.this.rhJ.cqu().f15074Id), 25, 21));
                    } else {
                        i = 1;
                    }
                    C7060h.pYm.mo8381e(16552, C136614.this.rhJ.cqu().f15074Id, C29036i.m46107dd(Xs), C29036i.m46107dd(C44380a.m80241v(list, 20)), Integer.valueOf((int) (100.0f * r9)), Integer.valueOf(i), Long.valueOf(C5046bo.anl(C136614.this.rhJ.cqZ())), C136614.this.rhJ.cqq().qPj);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FullCardAdDetailItem", e, "recog gesture error!", new Object[0]);
                } finally {
                    C13658c.this.rGY.cvA();
                    AppMethodBeat.m2505o(40098);
                }
            }

            public final void onClick() {
                AppMethodBeat.m2504i(40099);
                C29036i.m46120kI(true);
                C13658c.this.rGY.setBackgroundColor(0);
                C13658c.this.rGD.rns.performClick();
                AppMethodBeat.m2505o(40099);
            }
        }

        C136614(C13476a c13476a, C46236n c46236n) {
            this.rHd = c13476a;
            this.rhJ = c46236n;
        }

        public final void run() {
            AppMethodBeat.m2504i(40100);
            C13658c.this.rGY.setVisibility(0);
            C13658c.this.rGY.cvA();
            C13658c.this.rGY.setPaintColor(this.rHd.color);
            C13658c.this.rGY.setOnGestureListener(new C136621());
            AppMethodBeat.m2505o(40100);
        }
    }

    public C13658c(TimeLineObject timeLineObject, C46236n c46236n, C22089b c22089b, C13342g c13342g) {
        this.timeLineObject = timeLineObject;
        this.ros = c46236n;
        this.rqo = c22089b;
        this.rqn = c13342g;
    }

    /* renamed from: g */
    public final void mo25860g(View view, View view2) {
        AppMethodBeat.m2504i(40102);
        this.contentView = view;
        this.rpP = view2;
        this.context = view.getContext();
        this.rGQ = view.findViewById(2131827880);
        this.rGR = view.findViewById(2131827883);
        this.rGS = (TextView) view.findViewById(2131827881);
        this.rGT = (TextView) view.findViewById(2131827882);
        this.rGU = (TextView) view.findViewById(2131827884);
        this.rGV = (TextView) view.findViewById(2131827885);
        this.rGW = view.findViewById(2131827886);
        this.rGX = (MaskImageView) view.findViewById(2131827878);
        this.rGY = (SnsDrawGestureView) view.findViewById(2131827887);
        this.rGX.setScaleType(C15991a.CENTER_CROP);
        this.rGD = new C43589aj();
        this.rGD.rnt = view.findViewById(2131827879);
        this.rGD.rns = this.rGD.rnt;
        this.rGD.rnt.setOnClickListener(this.rqo.rKe);
        this.rGD.qzM = (C34915a) this.rGD.rnt.findViewById(2131820629);
        this.rGD.raP = (ImageView) this.rGD.rnt.findViewById(2131820981);
        this.rGD.rnu = (MMPinProgressBtn) this.rGD.rnt.findViewById(2131821370);
        this.rGD.rnv = (TextView) this.rGD.rnt.findViewById(2131827571);
        this.rGD.raQ = (TextView) this.rGD.rnt.findViewById(2131827572);
        ((SightPlayImageView) this.rGD.qzM).qyI = true;
        ((SightPlayImageView) this.rGD.qzM).setScaleType(C15991a.CENTER_CROP);
        AppMethodBeat.m2505o(40102);
    }

    public final void refreshView() {
        bau bau;
        AppMethodBeat.m2504i(40103);
        this.ros = C21990h.m33615YS(this.ros.cqA());
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
            int al = ((((min - C1338a.m2856al(this.context, C25738R.dimen.a94)) - C1338a.m2856al(this.context, C25738R.dimen.f10017nj)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
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
                this.rGD.qzM.mo8513fi(layoutParams.width, layoutParams.height);
            }
            TextView textView;
            C9212g dqQ;
            if (this.rGZ.qVm == 0) {
                gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) this.rGZ.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                this.rGQ.setBackground(gradientDrawable);
                if (!(C5046bo.isNullOrNil(this.rGZ.title) && C5046bo.isNullOrNil(this.rGZ.description))) {
                    this.rGQ.setVisibility(0);
                }
                this.rGR.setVisibility(8);
                if (!C5046bo.isNullOrNil(this.rGZ.title)) {
                    this.rGS.setVisibility(0);
                    textView = this.rGS;
                    dqQ = C9212g.dqQ();
                    this.rGS.getContext();
                    textView.setText(dqQ.mo20622b(this.rGZ.title, this.rGS.getTextSize()));
                }
                if (!C5046bo.isNullOrNil(this.rGZ.description)) {
                    this.rGT.setVisibility(0);
                    textView = this.rGT;
                    dqQ = C9212g.dqQ();
                    this.rGT.getContext();
                    textView.setText(dqQ.mo20622b(this.rGZ.description, this.rGT.getTextSize()));
                }
            } else if (this.rGZ.qVm == 1) {
                gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.rGZ.qVl) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                this.rGQ.setVisibility(8);
                this.rGR.setBackground(gradientDrawable);
                if (!(C5046bo.isNullOrNil(this.rGZ.title) && C5046bo.isNullOrNil(this.rGZ.description))) {
                    this.rGR.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.rGW.getLayoutParams();
                    layoutParams3.topMargin = C1338a.fromDPToPix(this.context, 4);
                    this.rGW.setLayoutParams(layoutParams3);
                }
                if (!C5046bo.isNullOrNil(this.rGZ.title)) {
                    this.rGU.setVisibility(0);
                    textView = this.rGU;
                    dqQ = C9212g.dqQ();
                    this.rGU.getContext();
                    textView.setText(dqQ.mo20622b(this.rGZ.title, this.rGU.getTextSize()));
                }
                if (!C5046bo.isNullOrNil(this.rGZ.description)) {
                    this.rGV.setVisibility(0);
                    textView = this.rGV;
                    dqQ = C9212g.dqQ();
                    this.rGV.getContext();
                    textView.setText(dqQ.mo20622b(this.rGZ.description, this.rGV.getTextSize()));
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
            C4990ab.m7412e("MicroMsg.FullCardAdDetailItem", "invalid full card");
        }
        if (this.timeLineObject.xfI == null || this.timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) this.timeLineObject.xfI.wbK.get(0);
        }
        this.rGD.mo69200a(this.timeLineObject, 0, this.ros.cqU(), true);
        this.rGD.raQ.setVisibility(8);
        C21925g cnC = C13373af.cnC();
        if (bau != null) {
            final long j = this.ros.field_snsId;
            if (this.timeLineObject.xfI.wbJ == 1) {
                this.rGX.setVisibility(0);
                this.rGX.setTag(this);
                this.rGX.setOnClickListener(this.rqo.rKn);
                View view = this.rGX;
                int hashCode = this.context.hashCode();
                C44222az dtg = C44222az.dtg();
                dtg.oyB = this.timeLineObject.pcX;
                cnC.mo37450a(bau, view, -1, hashCode, dtg, 3);
                AppMethodBeat.m2505o(40103);
                return;
            }
            if (this.timeLineObject.xfI.wbJ == 15 || this.timeLineObject.xfI.wbJ == 5) {
                long nanoTime = System.nanoTime() - System.nanoTime();
                C4990ab.m7417i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(nanoTime));
                this.rGD.qzM.setOnCompletionListener(new C13304e() {
                    /* renamed from: c */
                    public final void mo8940c(C13303b c13303b, int i) {
                        AppMethodBeat.m2504i(40094);
                        if (i != -1) {
                            C13658c.this.rqn.mo25445u(j, false);
                        }
                        AppMethodBeat.m2505o(40094);
                    }
                });
                if (!(this.rqn == null || this.rqn.mo25439jO(j))) {
                    this.rGD.qzM.setOnDecodeDurationListener(new C13325f() {
                        /* renamed from: b */
                        public final void mo8946b(C13303b c13303b, long j) {
                            int cle;
                            AppMethodBeat.m2504i(40095);
                            if (j >= 3) {
                                cle = (int) c13303b.cle();
                                C13658c.this.rqn.mo25433c(j, C5046bo.m7588yz(), false);
                                C13658c.this.rqn.mo25436f(j, cle, false);
                                C13658c.this.rqn.mo25429T(j, j);
                            }
                            C4990ab.m7411d("MicroMsg.FullCardAdDetailItem", "sight play %d", Long.valueOf(j));
                            cle = (int) j;
                            C13658c c13658c = C13658c.this;
                            C13475c c13475c = C13658c.this.rGZ;
                            C46236n c46236n = C13658c.this.ros;
                            cle *= 1000;
                            C13476a c13476a = c13475c.qVn;
                            if (!C5046bo.isNullOrNil(c46236n.cqo().coW()) && c13476a != null && c13476a.startTime >= 0 && c13476a.endTime > c13476a.startTime) {
                                C4990ab.m7417i("MicroMsg.FullCardAdDetailItem", "%d-%d,%d", Long.valueOf(c13476a.startTime), Long.valueOf(c13476a.endTime), Integer.valueOf(cle));
                                if (c13476a.startTime > ((long) cle) || c13476a.endTime < ((long) cle)) {
                                    C5004al.m7441d(new C136605());
                                } else if (c13658c.rGY.getOnGestureListener() == null) {
                                    C5004al.m7441d(new C136614(c13476a, c46236n));
                                    AppMethodBeat.m2505o(40095);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(40095);
                        }
                    });
                }
                C13476a c13476a = this.rGZ.qVn;
                final String coW = this.ros.cqo().coW();
                if (!C5046bo.isNullOrNil(coW) && c13476a != null && c13476a.startTime >= 0 && c13476a.endTime > c13476a.startTime) {
                    C7305d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(40096);
                            C34998j.cql().mo55575f("adId", coW, "adxml", 0);
                            AppMethodBeat.m2505o(40096);
                        }
                    }, "preDownloadFloatPage");
                }
                if (r4) {
                    if (cnC.mo37468u(bau)) {
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                    } else if (cnC.mo37469v(bau)) {
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(8);
                    } else if (cnC.mo37453b(this.ros, null) <= 5) {
                        this.rGD.raP.setVisibility(8);
                        this.rGD.rnu.setVisibility(8);
                    } else {
                        cnC.mo37472y(bau);
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                    }
                    if (this.rGD.qzM.ckY()) {
                        C4990ab.m7410d("MicroMsg.FullCardAdDetailItem", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH);
                        cnC.mo37472y(bau);
                        this.rGD.raP.setVisibility(0);
                        this.rGD.rnu.setVisibility(8);
                        this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                    }
                } else if (cnC.mo37470w(bau)) {
                    this.rGD.raP.setVisibility(8);
                    this.rGD.rnu.setVisibility(0);
                    this.rGD.rnu.dKB();
                } else if (cnC.mo37453b(this.ros, null) == 5) {
                    cnC.mo37428A(bau);
                    this.rGD.raP.setVisibility(8);
                    this.rGD.rnu.setVisibility(0);
                    this.rGD.rnu.dKB();
                } else if (cnC.mo37471x(bau)) {
                    this.rGD.rnu.setVisibility(8);
                    this.rGD.raP.setImageResource(C25738R.drawable.atu);
                    this.rGD.raP.setVisibility(0);
                } else {
                    cnC.mo37472y(bau);
                    this.rGD.raP.setVisibility(0);
                    this.rGD.rnu.setVisibility(8);
                    this.rGD.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                    this.rGD.raP.setContentDescription(this.context.getString(C25738R.string.dco));
                    if (cnC.mo37453b(this.ros, null) == 4) {
                        this.rGD.raQ.setVisibility(0);
                    }
                }
                this.rGD.rns.setVisibility(0);
                this.rGD.qzM.setTagObject(this.rGD);
                this.rGD.rnt.setTag(this);
                this.rGD.rns.setOnClickListener(this.rqo.rKn);
                C46236n c46236n = this.ros;
                C34915a c34915a = this.rGD.qzM;
                int hashCode2 = this.context.hashCode();
                C44222az dtg2 = C44222az.dtg();
                dtg2.oyB = this.timeLineObject.pcX;
                cnC.mo37449a(c46236n, bau, c34915a, hashCode2, 0, dtg2, true, true);
                String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                String j2 = C29036i.m46116j(bau);
                if (this.rqn != null) {
                    if (C5730e.m8628ct(fZ + j2)) {
                        this.rqn.mo25446v(j, true);
                    } else {
                        this.rqn.mo25446v(j, false);
                    }
                    this.rqn.mo25434c(j, C13373af.cnC().mo37453b(this.ros, null) == 5, false);
                }
            }
            AppMethodBeat.m2505o(40103);
            return;
        }
        cnC.mo37446a(this.rGD.qzM, this.context.hashCode());
        this.rGD.rnv.setVisibility(8);
        this.rGD.qzM.setOnSightCompletionAction(null);
        this.rGD.qzM.setOnCompletionListener(null);
        this.rGD.qzM.setOnDecodeDurationListener(null);
        AppMethodBeat.m2505o(40103);
    }
}
