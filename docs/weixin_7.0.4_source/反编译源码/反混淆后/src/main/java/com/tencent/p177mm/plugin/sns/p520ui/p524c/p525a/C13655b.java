package com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
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
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsCardAdTagListView;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
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

/* renamed from: com.tencent.mm.plugin.sns.ui.c.a.b */
public final class C13655b extends C35118a {
    private Context context;
    private C24088a jMO;
    public TextView rGE;
    public TextView rGF;
    public View rGG;
    public Button rGH;
    public Button rGI;
    public View rGJ;
    public MaskImageView rGK;
    public SnsCardAdTagListView rGL;
    public View rGM;
    public View rGN;
    public View rGO;
    C13342g rqn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.b$1 */
    class C136531 implements C13304e {
        C136531() {
        }

        /* renamed from: c */
        public final void mo8940c(C13303b c13303b, int i) {
            AppMethodBeat.m2504i(40088);
            if (!(i == -1 || C13655b.this.rqn == null)) {
                C13655b.this.rqn.mo25445u(C13655b.this.ros.field_snsId, false);
            }
            AppMethodBeat.m2505o(40088);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.b$3 */
    class C136543 implements C3951a {
        C136543() {
        }

        public final void cpu() {
        }

        public final void cmD() {
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(40090);
            if (!C5046bo.isNullOrNil(str)) {
                Bitmap decodeFile = C5056d.decodeFile(str, null);
                if (decodeFile != null) {
                    C13655b.this.rGM.setVisibility(0);
                    ImageView imageView = (ImageView) C13655b.this.rGM.findViewById(2131827875);
                    imageView.setImageBitmap(decodeFile);
                    imageView.setVisibility(0);
                }
            }
            AppMethodBeat.m2505o(40090);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.c.a.b$2 */
    class C136562 implements C13325f {
        C136562() {
        }

        /* renamed from: b */
        public final void mo8946b(C13303b c13303b, long j) {
            AppMethodBeat.m2504i(40089);
            int cle = (int) c13303b.cle();
            if (C13655b.this.rqn != null && j >= 3) {
                C13655b.this.rqn.mo25433c(C13655b.this.ros.field_snsId, C5046bo.m7588yz(), false);
                C13655b.this.rqn.mo25436f(C13655b.this.ros.field_snsId, cle, false);
                C13655b.this.rqn.mo25429T(C13655b.this.ros.field_snsId, C13655b.this.ros.field_snsId);
            }
            C13655b.this.rGD.qzM.setOnDecodeDurationListener(null);
            AppMethodBeat.m2505o(40089);
        }
    }

    public C13655b(TimeLineObject timeLineObject, C46236n c46236n, C22089b c22089b, C13342g c13342g) {
        this.timeLineObject = timeLineObject;
        this.ros = c46236n;
        this.rqo = c22089b;
        this.rqn = c13342g;
    }

    /* renamed from: g */
    public final void mo25860g(View view, View view2) {
        AppMethodBeat.m2504i(40091);
        this.contentView = view;
        this.rpP = view2;
        this.context = view.getContext();
        this.rGN = view.findViewById(2131827604);
        this.rGO = view.findViewById(2131827607);
        this.rGG = view.findViewById(2131827611);
        this.rGG.setVisibility(8);
        this.rGJ = view.findViewById(2131827614);
        this.rGJ.setVisibility(8);
        this.rGK = (MaskImageView) view.findViewById(2131827605);
        this.rGH = (Button) view.findViewById(2131827612);
        this.rGI = (Button) view.findViewById(2131827613);
        C21980a cqq = this.ros.cqq();
        if (!(cqq == null || !cqq.coI() || this.ros.crg())) {
            this.rGJ.setVisibility(0);
        }
        this.rGF = (TextView) view.findViewById(2131827609);
        this.rGF.setClickable(false);
        this.rGF.setLongClickable(false);
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = ((((Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight()) - C1338a.m2856al(this.context, C25738R.dimen.a94)) - C1338a.m2856al(this.context, C25738R.dimen.f10017nj)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9966lo);
        layoutParams.bottomMargin = 0;
        layoutParams.width = min;
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
        view.setBackground(this.context.getResources().getDrawable(C25738R.drawable.a0o));
        this.rGE = (TextView) view.findViewById(2131827608);
        this.rGE.setClickable(false);
        this.rGE.setLongClickable(false);
        if (C5046bo.isNullOrNil(this.ros.cqo().qUS)) {
            this.rGE.setVisibility(8);
        } else {
            this.rGE.setText(this.ros.cqo().qUS + " ");
            C44089j.m79307h(this.rGE, 2);
            this.rGE.setVisibility(0);
        }
        String str = C5046bo.isNullOrNil(this.ros.cqo().qUT) ? this.timeLineObject.xfF : this.ros.cqo().qUT;
        if (C5046bo.isNullOrNil(str)) {
            this.rGF.setVisibility(8);
        } else {
            this.rGF.setText(str + " ");
            C44089j.m79307h(this.rGF, 2);
            this.rGF.setVisibility(0);
        }
        this.jMO = new C24088a(this.context);
        this.jMO.mo39887c(view, this.rqo.rJZ, this.rqo.rJH);
        if (this.ros.cqo().coR() || this.ros.cqo().coS()) {
            this.rGG.setVisibility(0);
            m21873G(this.ros);
        } else {
            this.rGG.setVisibility(8);
        }
        this.rGD = new C43589aj();
        this.rGD.rnt = view.findViewById(2131827606);
        this.rGD.rns = this.rGD.rnt;
        this.rGD.rnt.setOnClickListener(this.rqo.rKe);
        this.rGD.qzM = (C34915a) this.rGD.rnt.findViewById(2131820629);
        this.rGD.raP = (ImageView) this.rGD.rnt.findViewById(2131820981);
        this.rGD.rnu = (MMPinProgressBtn) this.rGD.rnt.findViewById(2131821370);
        this.rGD.rnv = (TextView) this.rGD.rnt.findViewById(2131827571);
        this.rGD.raQ = (TextView) this.rGD.rnt.findViewById(2131827572);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.rGK.getLayoutParams();
        layoutParams2.leftMargin = C1338a.fromDPToPix(this.context, 10);
        layoutParams2.rightMargin = C1338a.fromDPToPix(this.context, 10);
        layoutParams2.topMargin = C1338a.fromDPToPix(this.context, 10);
        layoutParams2.bottomMargin = C1338a.fromDPToPix(this.context, 10);
        this.rGK.setLayoutParams(layoutParams2);
        layoutParams2 = (RelativeLayout.LayoutParams) this.rGD.rns.getLayoutParams();
        layoutParams2.leftMargin = C1338a.m2856al(this.context, C25738R.dimen.f9966lo);
        layoutParams2.rightMargin = C1338a.m2856al(this.context, C25738R.dimen.f9966lo);
        layoutParams2.topMargin = C1338a.fromDPToPix(this.context, 10);
        layoutParams2.bottomMargin = C1338a.m2856al(this.context, C25738R.dimen.f9966lo);
        this.rGD.rns.setLayoutParams(layoutParams2);
        this.rGM = view.findViewById(2131827874);
        layoutParams2 = (RelativeLayout.LayoutParams) this.rGM.getLayoutParams();
        layoutParams2.leftMargin = C1338a.fromDPToPix(this.context, 10);
        layoutParams2.rightMargin = C1338a.fromDPToPix(this.context, 10);
        layoutParams2.topMargin = C1338a.fromDPToPix(this.context, 10);
        this.rGM.setLayoutParams(layoutParams2);
        this.rGL = (SnsCardAdTagListView) this.contentView.findViewById(2131827610);
        this.rGL.setActivityContext((Activity) this.context);
        this.rGL.removeAllViews();
        if (this.ros.cqo().qUW.size() > 0) {
            this.rGL.setVisibility(0);
            this.rGL.setTagSpace(C1338a.fromDPToPix(this.context, 6));
            this.rGL.mo37709dB(this.ros.cqo().qUW);
        }
        if (!C5046bo.isNullOrNil(this.ros.cqo().qUU)) {
            this.rGM.setVisibility(0);
            this.rGM.findViewById(2131827876).setVisibility(0);
            ((TextView) this.rGM.findViewById(2131827876)).setText(this.ros.cqo().qUU);
        }
        if (!C5046bo.isNullOrNil(this.ros.cqo().qUV)) {
            C13473h.m21620a(this.ros.cqo().qUV, new C136543());
        }
        this.jMO.mo39887c(view, this.rqo.rJZ, this.rqo.rJH);
        this.rGK.setVisibility(8);
        this.rGK.setScaleType(C15991a.CENTER_CROP);
        this.rGD.rns.setVisibility(8);
        ((SightPlayImageView) this.rGD.qzM).qyI = true;
        ((SightPlayImageView) this.rGD.qzM).setScaleType(C15991a.CENTER_CROP);
        view.setBackgroundResource(C25738R.drawable.a0o);
        view.setOnClickListener(this.rqo.rKn);
        AppMethodBeat.m2505o(40091);
    }

    public final void refreshView() {
        bau bau;
        AppMethodBeat.m2504i(40092);
        this.ros = C21990h.m33615YS(this.ros.cqA());
        C4990ab.m7416i("MicroMsg.CardAdDetailItemView", "refreshView");
        m21873G(this.ros);
        this.rGD.raQ.setVisibility(8);
        C21925g cnC = C13373af.cnC();
        if (this.timeLineObject.xfI == null || this.timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) this.timeLineObject.xfI.wbK.get(0);
        }
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        if (bau != null) {
            width = (((((width - C1338a.fromDPToPix(this.context, 50)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo)) - this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo);
            int i = (int) ((((float) width) * bau.wEK.wFy) / bau.wEK.wFx);
            if (this.timeLineObject.xfI.wbJ == 1) {
                ViewGroup.LayoutParams layoutParams = this.rGK.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = i;
                this.rGK.setLayoutParams(layoutParams);
                C13373af.cnC().mo37457b(bau, this.rGK, -1, this.context.hashCode(), C44222az.xYT);
                this.rGK.setVisibility(0);
                this.rGK.setTag(this);
                this.contentView.setTag(this);
                this.rGH.setTag(this);
                this.rGI.setTag(this);
                this.rGK.setOnClickListener(this.rqo.rjy);
                this.jMO.mo39887c(this.rGK, this.rqo.rJZ, this.rqo.rJH);
                AppMethodBeat.m2505o(40092);
                return;
            } else if (this.timeLineObject.xfI.wbJ == 5 || this.timeLineObject.xfI.wbJ == 15) {
                this.rGD.rns.setVisibility(0);
                this.jMO.mo39887c(this.rGD.rnt, this.rqo.rJZ, this.rqo.rJH);
                ViewGroup.LayoutParams layoutParams2 = this.rGD.rns.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = i;
                this.rGD.rns.setLayoutParams(layoutParams2);
                this.rGD.qzM.mo8513fi(width, i);
                this.rGD.qzM.setOnCompletionListener(new C136531());
                if (!(this.rqn == null || this.rqn.mo25439jO(this.ros.field_snsId))) {
                    this.rGD.qzM.setOnDecodeDurationListener(new C136562());
                }
                long nanoTime = System.nanoTime() - System.nanoTime();
                C4990ab.m7417i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", Boolean.valueOf(C21925g.m33541t(bau)), Long.valueOf(nanoTime));
                C43589aj c43589aj = this.rGD;
                this.rGD.cwT = this.ros.cqU();
                if (C21925g.m33541t(bau)) {
                    if (cnC.mo37468u(bau)) {
                        c43589aj.raP.setVisibility(0);
                        c43589aj.rnu.setVisibility(8);
                        c43589aj.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        c43589aj.raP.setContentDescription(this.context.getResources().getString(C25738R.string.dco));
                    } else if (cnC.mo37469v(bau)) {
                        c43589aj.raP.setVisibility(8);
                        c43589aj.rnu.setVisibility(8);
                    } else if (cnC.mo37453b(this.ros, null) <= 5) {
                        c43589aj.raP.setVisibility(8);
                        c43589aj.rnu.setVisibility(8);
                    } else {
                        cnC.mo37472y(bau);
                        c43589aj.raP.setVisibility(0);
                        c43589aj.rnu.setVisibility(8);
                        c43589aj.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        c43589aj.raP.setContentDescription(this.context.getResources().getString(C25738R.string.dco));
                    }
                    if (c43589aj.qzM.ckY()) {
                        C4990ab.m7410d("MicroMsg.CardAdDetailItemView", "play video error " + bau.f17915Id + " " + bau.Url + " " + bau.wEH);
                        cnC.mo37472y(bau);
                        c43589aj.raP.setVisibility(0);
                        c43589aj.rnu.setVisibility(8);
                        c43589aj.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                        c43589aj.raP.setContentDescription(this.context.getResources().getString(C25738R.string.dco));
                    }
                } else if (cnC.mo37470w(bau)) {
                    c43589aj.raP.setVisibility(8);
                    c43589aj.rnu.setVisibility(0);
                    c43589aj.rnu.dKB();
                } else if (cnC.mo37453b(this.ros, null) == 5) {
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
                    c43589aj.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
                    c43589aj.raP.setContentDescription(this.context.getResources().getString(C25738R.string.dco));
                    if (cnC.mo37453b(this.ros, null) == 4) {
                        c43589aj.raQ.setVisibility(0);
                    }
                }
                this.rGD.rns.setVisibility(0);
                c43589aj.qzM.setTagObject(c43589aj);
                c43589aj.rnt.setTag(this);
                this.contentView.setTag(this);
                this.rGH.setTag(this);
                this.rGI.setTag(this);
                cnC.mo37449a(this.ros, bau, c43589aj.qzM, this.context.hashCode(), 0, C44222az.xYT, true, true);
                if (this.rqn != null) {
                    if (C5730e.m8628ct(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau))) {
                        this.rqn.mo25446v(this.ros.field_snsId, true);
                    } else {
                        this.rqn.mo25446v(this.ros.field_snsId, false);
                    }
                    this.rqn.mo25434c(this.ros.field_snsId, C13373af.cnC().mo37453b(this.ros, null) == 5, false);
                }
                AppMethodBeat.m2505o(40092);
                return;
            } else {
                cnC.mo37446a(this.rGD.qzM, this.context.hashCode());
                this.rGD.rnv.setVisibility(8);
                this.rGD.qzM.setOnSightCompletionAction(null);
                this.rGD.qzM.setOnCompletionListener(null);
                this.rGD.qzM.setOnDecodeDurationListener(null);
            }
        }
        AppMethodBeat.m2505o(40092);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: G */
    private void m21873G(C46236n c46236n) {
        int i = 0;
        AppMethodBeat.m2504i(40093);
        if (c46236n == null || !c46236n.coP()) {
            AppMethodBeat.m2505o(40093);
            return;
        }
        int parseColor = Color.parseColor("#cdcdcd");
        int parseColor2 = Color.parseColor("#ffffff");
        if (this.rGH == null || this.rGI == null) {
            AppMethodBeat.m2505o(40093);
            return;
        }
        this.rGH.setOnClickListener(this.rqo.rKl);
        this.rGI.setOnClickListener(this.rqo.rKm);
        if (c46236n.cqo().coS()) {
            int gr = C35002v.m57491gr(c46236n.cqo().qVh.qVu, c46236n.crc());
            if (gr > 0 && gr <= 2) {
                if (gr == 1) {
                    this.rGI.setBackgroundColor(parseColor2);
                    this.rGI.setTextColor(parseColor);
                    this.rGI.setText(c46236n.cqo().qVh.mo37532Dm(1));
                    this.rGH.setBackgroundResource(C25738R.drawable.a0s);
                    this.rGH.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGH.setText(c46236n.cqo().qVh.mo37531Dl(0));
                } else if (gr == 2) {
                    this.rGH.setBackgroundColor(parseColor2);
                    this.rGH.setTextColor(parseColor);
                    this.rGH.setText(c46236n.cqo().qVh.mo37532Dm(0));
                    this.rGI.setBackgroundResource(C25738R.drawable.a0s);
                    this.rGI.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGI.setText(c46236n.cqo().qVh.mo37531Dl(1));
                }
                if (i != 0) {
                    this.rGH.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGH.setBackgroundResource(C25738R.drawable.a0s);
                    this.rGI.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGI.setBackgroundResource(C25738R.drawable.a0s);
                    this.rGH.setText(c46236n.cqo().coL());
                    this.rGI.setText(c46236n.cqo().coM());
                }
                AppMethodBeat.m2505o(40093);
            }
        }
        i = 1;
        if (i != 0) {
        }
        AppMethodBeat.m2505o(40093);
    }
}
