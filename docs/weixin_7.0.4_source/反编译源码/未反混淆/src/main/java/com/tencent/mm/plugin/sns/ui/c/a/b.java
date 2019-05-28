package com.tencent.mm.plugin.sns.ui.c.a;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.smtt.sdk.WebView;

public final class b extends a {
    private Context context;
    private a jMO;
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
    g rqn;

    public b(TimeLineObject timeLineObject, n nVar, com.tencent.mm.plugin.sns.ui.d.b bVar, g gVar) {
        this.timeLineObject = timeLineObject;
        this.ros = nVar;
        this.rqo = bVar;
        this.rqn = gVar;
    }

    public final void g(View view, View view2) {
        AppMethodBeat.i(40091);
        this.contentView = view;
        this.rpP = view2;
        this.context = view.getContext();
        this.rGN = view.findViewById(R.id.eeu);
        this.rGO = view.findViewById(R.id.eex);
        this.rGG = view.findViewById(R.id.ef1);
        this.rGG.setVisibility(8);
        this.rGJ = view.findViewById(R.id.ef4);
        this.rGJ.setVisibility(8);
        this.rGK = (MaskImageView) view.findViewById(R.id.eev);
        this.rGH = (Button) view.findViewById(R.id.ef2);
        this.rGI = (Button) view.findViewById(R.id.ef3);
        com.tencent.mm.plugin.sns.storage.a cqq = this.ros.cqq();
        if (!(cqq == null || !cqq.coI() || this.ros.crg())) {
            this.rGJ.setVisibility(0);
        }
        this.rGF = (TextView) view.findViewById(R.id.eez);
        this.rGF.setClickable(false);
        this.rGF.setLongClickable(false);
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = ((((Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight()) - com.tencent.mm.bz.a.al(this.context, R.dimen.a94)) - com.tencent.mm.bz.a.al(this.context, R.dimen.nj)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.nc);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = this.context.getResources().getDimensionPixelOffset(R.dimen.lo);
        layoutParams.bottomMargin = 0;
        layoutParams.width = min;
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
        view.setBackground(this.context.getResources().getDrawable(R.drawable.a0o));
        this.rGE = (TextView) view.findViewById(R.id.eey);
        this.rGE.setClickable(false);
        this.rGE.setLongClickable(false);
        if (bo.isNullOrNil(this.ros.cqo().qUS)) {
            this.rGE.setVisibility(8);
        } else {
            this.rGE.setText(this.ros.cqo().qUS + " ");
            j.h(this.rGE, 2);
            this.rGE.setVisibility(0);
        }
        String str = bo.isNullOrNil(this.ros.cqo().qUT) ? this.timeLineObject.xfF : this.ros.cqo().qUT;
        if (bo.isNullOrNil(str)) {
            this.rGF.setVisibility(8);
        } else {
            this.rGF.setText(str + " ");
            j.h(this.rGF, 2);
            this.rGF.setVisibility(0);
        }
        this.jMO = new a(this.context);
        this.jMO.c(view, this.rqo.rJZ, this.rqo.rJH);
        if (this.ros.cqo().coR() || this.ros.cqo().coS()) {
            this.rGG.setVisibility(0);
            G(this.ros);
        } else {
            this.rGG.setVisibility(8);
        }
        this.rGD = new aj();
        this.rGD.rnt = view.findViewById(R.id.eew);
        this.rGD.rns = this.rGD.rnt;
        this.rGD.rnt.setOnClickListener(this.rqo.rKe);
        this.rGD.qzM = (com.tencent.mm.plugin.sight.decode.a.a) this.rGD.rnt.findViewById(R.id.bl);
        this.rGD.raP = (ImageView) this.rGD.rnt.findViewById(R.id.l4);
        this.rGD.rnu = (MMPinProgressBtn) this.rGD.rnt.findViewById(R.id.vm);
        this.rGD.rnv = (TextView) this.rGD.rnt.findViewById(R.id.edy);
        this.rGD.raQ = (TextView) this.rGD.rnt.findViewById(R.id.edz);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.rGK.getLayoutParams();
        layoutParams2.leftMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        layoutParams2.rightMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        layoutParams2.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        this.rGK.setLayoutParams(layoutParams2);
        layoutParams2 = (RelativeLayout.LayoutParams) this.rGD.rns.getLayoutParams();
        layoutParams2.leftMargin = com.tencent.mm.bz.a.al(this.context, R.dimen.lo);
        layoutParams2.rightMargin = com.tencent.mm.bz.a.al(this.context, R.dimen.lo);
        layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        layoutParams2.bottomMargin = com.tencent.mm.bz.a.al(this.context, R.dimen.lo);
        this.rGD.rns.setLayoutParams(layoutParams2);
        this.rGM = view.findViewById(R.id.em5);
        layoutParams2 = (RelativeLayout.LayoutParams) this.rGM.getLayoutParams();
        layoutParams2.leftMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        layoutParams2.rightMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.context, 10);
        this.rGM.setLayoutParams(layoutParams2);
        this.rGL = (SnsCardAdTagListView) this.contentView.findViewById(R.id.ef0);
        this.rGL.setActivityContext((Activity) this.context);
        this.rGL.removeAllViews();
        if (this.ros.cqo().qUW.size() > 0) {
            this.rGL.setVisibility(0);
            this.rGL.setTagSpace(com.tencent.mm.bz.a.fromDPToPix(this.context, 6));
            this.rGL.dB(this.ros.cqo().qUW);
        }
        if (!bo.isNullOrNil(this.ros.cqo().qUU)) {
            this.rGM.setVisibility(0);
            this.rGM.findViewById(R.id.em7).setVisibility(0);
            ((TextView) this.rGM.findViewById(R.id.em7)).setText(this.ros.cqo().qUU);
        }
        if (!bo.isNullOrNil(this.ros.cqo().qUV)) {
            h.a(this.ros.cqo().qUV, new f.a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(40090);
                    if (!bo.isNullOrNil(str)) {
                        Bitmap decodeFile = d.decodeFile(str, null);
                        if (decodeFile != null) {
                            b.this.rGM.setVisibility(0);
                            ImageView imageView = (ImageView) b.this.rGM.findViewById(R.id.em6);
                            imageView.setImageBitmap(decodeFile);
                            imageView.setVisibility(0);
                        }
                    }
                    AppMethodBeat.o(40090);
                }
            });
        }
        this.jMO.c(view, this.rqo.rJZ, this.rqo.rJH);
        this.rGK.setVisibility(8);
        this.rGK.setScaleType(QImageView.a.CENTER_CROP);
        this.rGD.rns.setVisibility(8);
        ((SightPlayImageView) this.rGD.qzM).qyI = true;
        ((SightPlayImageView) this.rGD.qzM).setScaleType(QImageView.a.CENTER_CROP);
        view.setBackgroundResource(R.drawable.a0o);
        view.setOnClickListener(this.rqo.rKn);
        AppMethodBeat.o(40091);
    }

    public final void refreshView() {
        bau bau;
        AppMethodBeat.i(40092);
        this.ros = com.tencent.mm.plugin.sns.storage.h.YS(this.ros.cqA());
        ab.i("MicroMsg.CardAdDetailItemView", "refreshView");
        G(this.ros);
        this.rGD.raQ.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
        if (this.timeLineObject.xfI == null || this.timeLineObject.xfI.wbK.size() <= 0) {
            bau = null;
        } else {
            bau = (bau) this.timeLineObject.xfI.wbK.get(0);
        }
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        if (bau != null) {
            width = (((((width - com.tencent.mm.bz.a.fromDPToPix(this.context, 50)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.m4)) - this.context.getResources().getDimensionPixelSize(R.dimen.nc)) - this.context.getResources().getDimensionPixelSize(R.dimen.lo)) - this.context.getResources().getDimensionPixelSize(R.dimen.lo);
            int i = (int) ((((float) width) * bau.wEK.wFy) / bau.wEK.wFx);
            if (this.timeLineObject.xfI.wbJ == 1) {
                ViewGroup.LayoutParams layoutParams = this.rGK.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = i;
                this.rGK.setLayoutParams(layoutParams);
                af.cnC().b(bau, this.rGK, -1, this.context.hashCode(), az.xYT);
                this.rGK.setVisibility(0);
                this.rGK.setTag(this);
                this.contentView.setTag(this);
                this.rGH.setTag(this);
                this.rGI.setTag(this);
                this.rGK.setOnClickListener(this.rqo.rjy);
                this.jMO.c(this.rGK, this.rqo.rJZ, this.rqo.rJH);
                AppMethodBeat.o(40092);
                return;
            } else if (this.timeLineObject.xfI.wbJ == 5 || this.timeLineObject.xfI.wbJ == 15) {
                this.rGD.rns.setVisibility(0);
                this.jMO.c(this.rGD.rnt, this.rqo.rJZ, this.rqo.rJH);
                ViewGroup.LayoutParams layoutParams2 = this.rGD.rns.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = i;
                this.rGD.rns.setLayoutParams(layoutParams2);
                this.rGD.qzM.fi(width, i);
                this.rGD.qzM.setOnCompletionListener(new e() {
                    public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                        AppMethodBeat.i(40088);
                        if (!(i == -1 || b.this.rqn == null)) {
                            b.this.rqn.u(b.this.ros.field_snsId, false);
                        }
                        AppMethodBeat.o(40088);
                    }
                });
                if (!(this.rqn == null || this.rqn.jO(this.ros.field_snsId))) {
                    this.rGD.qzM.setOnDecodeDurationListener(new com.tencent.mm.plugin.sight.decode.a.b.f() {
                        public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                            AppMethodBeat.i(40089);
                            int cle = (int) bVar.cle();
                            if (b.this.rqn != null && j >= 3) {
                                b.this.rqn.c(b.this.ros.field_snsId, bo.yz(), false);
                                b.this.rqn.f(b.this.ros.field_snsId, cle, false);
                                b.this.rqn.T(b.this.ros.field_snsId, b.this.ros.field_snsId);
                            }
                            b.this.rGD.qzM.setOnDecodeDurationListener(null);
                            AppMethodBeat.o(40089);
                        }
                    });
                }
                long nanoTime = System.nanoTime() - System.nanoTime();
                ab.i("MicroMsg.CardAdDetailItemView", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(bau)), Long.valueOf(nanoTime));
                aj ajVar = this.rGD;
                this.rGD.cwT = this.ros.cqU();
                if (com.tencent.mm.plugin.sns.model.g.t(bau)) {
                    if (cnC.u(bau)) {
                        ajVar.raP.setVisibility(0);
                        ajVar.rnu.setVisibility(8);
                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                        ajVar.raP.setContentDescription(this.context.getResources().getString(R.string.dco));
                    } else if (cnC.v(bau)) {
                        ajVar.raP.setVisibility(8);
                        ajVar.rnu.setVisibility(8);
                    } else if (cnC.b(this.ros, null) <= 5) {
                        ajVar.raP.setVisibility(8);
                        ajVar.rnu.setVisibility(8);
                    } else {
                        cnC.y(bau);
                        ajVar.raP.setVisibility(0);
                        ajVar.rnu.setVisibility(8);
                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                        ajVar.raP.setContentDescription(this.context.getResources().getString(R.string.dco));
                    }
                    if (ajVar.qzM.ckY()) {
                        ab.d("MicroMsg.CardAdDetailItemView", "play video error " + bau.Id + " " + bau.Url + " " + bau.wEH);
                        cnC.y(bau);
                        ajVar.raP.setVisibility(0);
                        ajVar.rnu.setVisibility(8);
                        ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                        ajVar.raP.setContentDescription(this.context.getResources().getString(R.string.dco));
                    }
                } else if (cnC.w(bau)) {
                    ajVar.raP.setVisibility(8);
                    ajVar.rnu.setVisibility(0);
                    ajVar.rnu.dKB();
                } else if (cnC.b(this.ros, null) == 5) {
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
                    ajVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
                    ajVar.raP.setContentDescription(this.context.getResources().getString(R.string.dco));
                    if (cnC.b(this.ros, null) == 4) {
                        ajVar.raQ.setVisibility(0);
                    }
                }
                this.rGD.rns.setVisibility(0);
                ajVar.qzM.setTagObject(ajVar);
                ajVar.rnt.setTag(this);
                this.contentView.setTag(this);
                this.rGH.setTag(this);
                this.rGI.setTag(this);
                cnC.a(this.ros, bau, ajVar.qzM, this.context.hashCode(), 0, az.xYT, true, true);
                if (this.rqn != null) {
                    if (com.tencent.mm.vfs.e.ct(an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau))) {
                        this.rqn.v(this.ros.field_snsId, true);
                    } else {
                        this.rqn.v(this.ros.field_snsId, false);
                    }
                    this.rqn.c(this.ros.field_snsId, af.cnC().b(this.ros, null) == 5, false);
                }
                AppMethodBeat.o(40092);
                return;
            } else {
                cnC.a(this.rGD.qzM, this.context.hashCode());
                this.rGD.rnv.setVisibility(8);
                this.rGD.qzM.setOnSightCompletionAction(null);
                this.rGD.qzM.setOnCompletionListener(null);
                this.rGD.qzM.setOnDecodeDurationListener(null);
            }
        }
        AppMethodBeat.o(40092);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void G(n nVar) {
        int i = 0;
        AppMethodBeat.i(40093);
        if (nVar == null || !nVar.coP()) {
            AppMethodBeat.o(40093);
            return;
        }
        int parseColor = Color.parseColor("#cdcdcd");
        int parseColor2 = Color.parseColor("#ffffff");
        if (this.rGH == null || this.rGI == null) {
            AppMethodBeat.o(40093);
            return;
        }
        this.rGH.setOnClickListener(this.rqo.rKl);
        this.rGI.setOnClickListener(this.rqo.rKm);
        if (nVar.cqo().coS()) {
            int gr = v.gr(nVar.cqo().qVh.qVu, nVar.crc());
            if (gr > 0 && gr <= 2) {
                if (gr == 1) {
                    this.rGI.setBackgroundColor(parseColor2);
                    this.rGI.setTextColor(parseColor);
                    this.rGI.setText(nVar.cqo().qVh.Dm(1));
                    this.rGH.setBackgroundResource(R.drawable.a0s);
                    this.rGH.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGH.setText(nVar.cqo().qVh.Dl(0));
                } else if (gr == 2) {
                    this.rGH.setBackgroundColor(parseColor2);
                    this.rGH.setTextColor(parseColor);
                    this.rGH.setText(nVar.cqo().qVh.Dm(0));
                    this.rGI.setBackgroundResource(R.drawable.a0s);
                    this.rGI.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGI.setText(nVar.cqo().qVh.Dl(1));
                }
                if (i != 0) {
                    this.rGH.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGH.setBackgroundResource(R.drawable.a0s);
                    this.rGI.setTextColor(WebView.NIGHT_MODE_COLOR);
                    this.rGI.setBackgroundResource(R.drawable.a0s);
                    this.rGH.setText(nVar.cqo().coL());
                    this.rGI.setText(nVar.cqo().coM());
                }
                AppMethodBeat.o(40093);
            }
        }
        i = 1;
        if (i != 0) {
        }
        AppMethodBeat.o(40093);
    }
}
