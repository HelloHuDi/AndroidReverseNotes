package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sns.ui.r */
public final class C22140r extends LinearLayout implements C43610u {
    private Context context;
    private String czD = "";
    private boolean czr = false;
    private int czs;
    private String ecX = "";
    private int klY = 0;
    C22144b riN = new C22144b();
    private C46236n riO = null;
    private C4097a riP;
    private OnTouchListener riQ = C5046bo.dpE();
    private boolean riR = true;

    /* renamed from: com.tencent.mm.plugin.sns.ui.r$a */
    public interface C4097a {
        void cry();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.r$5 */
    class C221395 implements OnClickListener {
        C221395() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38239);
            if (C22140r.this.riP != null) {
                C22140r.this.riP;
            }
            AppMethodBeat.m2505o(38239);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.r$4 */
    class C221414 implements OnClickListener {
        C221414() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38238);
            if (C22140r.this.riP != null) {
                C22140r.this.riP.cry();
            }
            AppMethodBeat.m2505o(38238);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.r$1 */
    class C221421 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.r$1$1 */
        class C221431 implements Runnable {
            C221431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(38234);
                C22140r.this.refresh();
                AppMethodBeat.m2505o(38234);
            }
        }

        C221421() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38235);
            if (C22140r.this.riO == null) {
                AppMethodBeat.m2505o(38235);
                return;
            }
            if (C22140r.this.riO.field_likeFlag == 0) {
                if (C22140r.this.riO.cqT()) {
                    C3890a.m6184a(C22140r.this.riO, 1, "", "", C22140r.this.czs);
                } else {
                    C3890a.m6186a(C22140r.this.riO.field_userName, 5, "", C22140r.this.riO, C22140r.this.czs);
                }
                C22140r.this.riO.field_likeFlag = 1;
                C13373af.cnF().mo62912B(C22140r.this.riO);
            } else {
                C22140r.this.riO.field_likeFlag = 0;
                C13373af.cnF().mo62912B(C22140r.this.riO);
                C3890a.m6181Yd(C22140r.this.riO.cqA());
                C22140r.this.riO = C13373af.cnF().mo62941kD(C22140r.this.riO.field_snsId);
            }
            String jV = C22140r.this.riO.field_snsId == 0 ? "" : C29036i.m46117jV(C22140r.this.riO.field_snsId);
            C7060h.pYm.mo8381e(11989, Integer.valueOf(1), jV, Integer.valueOf(0));
            new C7306ak().postDelayed(new C221431(), 500);
            AppMethodBeat.m2505o(38235);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.r$b */
    class C22144b {
        ImageView eks;
        TextView hrg;
        LinearLayout riU;
        TextView riV;
        LinearLayout riW;
        LinearLayout riX;
        ImageView riY;
        LinearLayout riZ;
        LinearLayout rja;
        TextView rjb;
        TextView rjc;
        TextView rjd;
        LinearLayout rje;
        ImageView rjf;
        ImageView rjg;
        LinearLayout rjh;
        LinearLayout rji;
        TextView rjj;

        C22144b() {
        }
    }

    public final void setVisibility(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(38240);
        if (this.klY == 2 || this.klY == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.riR = z;
            AppMethodBeat.m2505o(38240);
        } else if (this.riO != null && !this.riO.cqT()) {
            AppMethodBeat.m2505o(38240);
        } else if (i == 8) {
            this.riN.riU.setVisibility(8);
            this.riR = false;
            AppMethodBeat.m2505o(38240);
        } else {
            if (i == 0) {
                this.riN.riU.setVisibility(0);
                this.riR = true;
            }
            AppMethodBeat.m2505o(38240);
        }
    }

    public C22140r(Context context, int i, boolean z) {
        super(context);
        AppMethodBeat.m2504i(38241);
        this.klY = i;
        this.czr = z;
        init(context);
        AppMethodBeat.m2505o(38241);
    }

    public final void setSnsSource(int i) {
        this.czs = i;
    }

    public final void setType(int i) {
        AppMethodBeat.m2504i(38242);
        this.klY = i;
        init(this.context);
        AppMethodBeat.m2505o(38242);
    }

    public final void setCallBack(C4097a c4097a) {
        this.riP = c4097a;
    }

    private void init(final Context context) {
        AppMethodBeat.m2504i(38243);
        this.context = context;
        if (this.klY == -1) {
            AppMethodBeat.m2505o(38243);
            return;
        }
        this.ecX = C1853r.m3846Yz();
        View inflate = LayoutInflater.from(context).inflate(2130970760, this, true);
        this.riN.riU = (LinearLayout) inflate.findViewById(2131827754);
        this.riN.rje = (LinearLayout) inflate.findViewById(2131827748);
        this.riN.riX = (LinearLayout) inflate.findViewById(2131827755);
        this.riN.riX.setOnTouchListener(this.riQ);
        this.riN.riY = (ImageView) inflate.findViewById(2131827756);
        this.riN.riZ = (LinearLayout) inflate.findViewById(2131827758);
        this.riN.riZ.setOnTouchListener(this.riQ);
        this.riN.rja = (LinearLayout) inflate.findViewById(2131827759);
        this.riN.rjc = (TextView) inflate.findViewById(2131827760);
        this.riN.rjd = (TextView) inflate.findViewById(2131827761);
        this.riN.rjb = (TextView) inflate.findViewById(2131827757);
        this.riN.riV = (TextView) inflate.findViewById(2131827747);
        this.riN.riW = (LinearLayout) inflate.findViewById(2131827746);
        this.riN.hrg = (TextView) inflate.findViewById(2131827751);
        this.riN.rji = (LinearLayout) inflate.findViewById(2131827749);
        ((LinearLayout) inflate.findViewById(2131827749)).getBackground().setAlpha(50);
        this.riN.eks = (ImageView) inflate.findViewById(2131827750);
        this.riN.rjf = (ImageView) inflate.findViewById(2131827752);
        this.riN.rjg = (ImageView) inflate.findViewById(2131827753);
        this.riN.rjh = (LinearLayout) inflate.findViewById(2131827744);
        this.riN.rjj = (TextView) inflate.findViewById(2131827745);
        if (this.klY == 2) {
            this.riN.rje.setVisibility(8);
            this.riN.rjh.setVisibility(8);
            this.riN.riW.setVisibility(0);
        } else if (this.klY == 3) {
            this.riN.rje.setVisibility(8);
            this.riN.riW.setVisibility(8);
            this.riN.rjh.setVisibility(0);
        } else {
            this.riN.rje.setVisibility(0);
            this.riN.riW.setVisibility(8);
            this.riN.rjh.setVisibility(8);
        }
        this.riN.riX.setOnClickListener(new C221421());
        this.riN.riZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(38236);
                C4990ab.m7410d("MicroMsg.GalleryFooter", "comment cmd");
                if (C22140r.this.riO == null) {
                    AppMethodBeat.m2505o(38236);
                    return;
                }
                int i = C22140r.this.riO.reX;
                Intent intent = new Intent();
                intent.putExtra("sns_comment_localId", i);
                intent.putExtra("sns_source", C22140r.this.czs);
                intent.setClass(context, SnsCommentUI.class);
                String jV = C22140r.this.riO.field_snsId == 0 ? "" : C29036i.m46117jV(C22140r.this.riO.field_snsId);
                C7060h.pYm.mo8381e(11989, Integer.valueOf(2), jV, Integer.valueOf(0));
                context.startActivity(intent);
                AppMethodBeat.m2505o(38236);
            }
        });
        this.riN.rja.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(38237);
                if (C22140r.this.riO == null) {
                    AppMethodBeat.m2505o(38237);
                    return;
                }
                String jV = C22140r.this.riO.field_snsId == 0 ? "" : C29036i.m46117jV(C22140r.this.riO.field_snsId);
                C7060h.pYm.mo8381e(11989, Integer.valueOf(3), jV, Integer.valueOf(0));
                int i = C22140r.this.riO.reX;
                Intent intent = new Intent();
                intent.setClass(context, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", C22140r.this.riO.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", C35002v.m57490ap("sns_table_", (long) i));
                intent.putExtra("INTENT_FROMGALLERY", true);
                ((MMActivity) context).startActivityForResult(intent, 1);
                AppMethodBeat.m2505o(38237);
            }
        });
        this.riN.riV.setOnClickListener(new C221414());
        this.riN.rjj.setOnClickListener(new C221395());
        AppMethodBeat.m2505o(38243);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(38244);
        if (this.klY == -1) {
            AppMethodBeat.m2505o(38244);
            return;
        }
        this.riO = C13373af.cnF().mo62918YT(this.czD);
        if (C5046bo.isNullOrNil(this.czD) || this.riO == null) {
            AppMethodBeat.m2505o(38244);
            return;
        }
        this.riN.rjg.setVisibility(8);
        if (C34955aj.m57399ab(this.riO.field_localPrivate, this.czr)) {
            this.riN.riZ.setVisibility(8);
            this.riN.riX.setVisibility(8);
        } else if (this.riO.cqT()) {
            if (this.riR) {
                this.riN.riU.setVisibility(0);
            }
            this.riN.rja.setVisibility(0);
            this.riN.riZ.setVisibility(0);
            this.riN.riX.setVisibility(0);
            this.riN.rje.setVisibility(0);
        } else {
            this.riN.rji.setVisibility(0);
            this.riN.rje.setVisibility(0);
            this.riN.riU.setVisibility(8);
            this.riN.rja.setVisibility(8);
            this.riN.riZ.setVisibility(8);
            this.riN.riX.setVisibility(8);
        }
        cbf q = C34955aj.m57409q(this.riO);
        if (q != null) {
            if (this.riO.cqT()) {
                int i = q.xar;
                if (i > 0) {
                    this.riN.rjd.setText(String.valueOf(i));
                    this.riN.rjd.setVisibility(0);
                } else {
                    this.riN.rjd.setVisibility(8);
                }
                int i2 = q.xao;
                if (i2 > 0) {
                    this.riN.rjc.setText(String.valueOf(i2));
                    this.riN.rjc.setVisibility(0);
                } else {
                    this.riN.rjc.setVisibility(8);
                }
                C4990ab.m7410d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                if (this.riO.field_likeFlag == 1) {
                    this.riN.rjb.setText(getResources().getString(C25738R.string.el0));
                    this.riN.riY.setImageResource(C1318a.friendactivity_comment_likeicon_havon);
                } else {
                    this.riN.rjb.setText(String.valueOf(getResources().getString(C25738R.string.el1)));
                    this.riN.riY.setImageResource(C1318a.friendactivity_comment_likeicon_normal);
                }
            }
            if (this.ecX.equals(this.riO.field_userName) || !this.czr) {
                this.riN.eks.setVisibility(8);
            } else {
                this.riN.eks.setVisibility(0);
                C40460b.m69434b(this.riN.eks, this.riO.field_userName);
            }
        }
        if (this.riO.cqu() == null) {
            this.riN.hrg.setVisibility(8);
            AppMethodBeat.m2505o(38244);
            return;
        }
        String str = this.riO.cqu().xfF;
        if (str == null || str.equals("")) {
            this.riN.hrg.setText("");
            this.riN.hrg.setVisibility(8);
        } else {
            this.riN.hrg.setText(C44089j.m79293b(getContext(), str + " ", this.riN.hrg.getTextSize()));
            this.riN.hrg.setVisibility(0);
        }
        if (C34955aj.m57399ab(this.riO.field_localPrivate, this.czr)) {
            this.riN.rjf.setVisibility(0);
            this.riN.hrg.setVisibility(0);
        } else {
            this.riN.rjf.setVisibility(8);
        }
        if (this.czr && this.riO.cqW()) {
            this.riN.rja.setVisibility(0);
            this.riN.hrg.setVisibility(0);
            this.riN.rjg.setVisibility(0);
        }
        AppMethodBeat.m2505o(38244);
    }

    public final void setFooter(String str) {
        AppMethodBeat.m2504i(38245);
        this.czD = str;
        refresh();
        AppMethodBeat.m2505o(38245);
    }

    /* renamed from: Zv */
    public final void mo37695Zv(String str) {
        AppMethodBeat.m2504i(38246);
        setFooter(str);
        AppMethodBeat.m2505o(38246);
    }

    public final int getFooterH() {
        AppMethodBeat.m2504i(38247);
        if (this.riN.riU != null) {
            int height = this.riN.riU.getHeight();
            AppMethodBeat.m2505o(38247);
            return height;
        }
        AppMethodBeat.m2505o(38247);
        return 10;
    }
}
