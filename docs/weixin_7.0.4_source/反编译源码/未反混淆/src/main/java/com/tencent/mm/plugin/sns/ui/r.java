package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class r extends LinearLayout implements u {
    private Context context;
    private String czD = "";
    private boolean czr = false;
    private int czs;
    private String ecX = "";
    private int klY = 0;
    b riN = new b();
    private n riO = null;
    private a riP;
    private OnTouchListener riQ = bo.dpE();
    private boolean riR = true;

    public interface a {
        void cry();
    }

    class b {
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

        b() {
        }
    }

    public final void setVisibility(int i) {
        boolean z = false;
        AppMethodBeat.i(38240);
        if (this.klY == 2 || this.klY == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.riR = z;
            AppMethodBeat.o(38240);
        } else if (this.riO != null && !this.riO.cqT()) {
            AppMethodBeat.o(38240);
        } else if (i == 8) {
            this.riN.riU.setVisibility(8);
            this.riR = false;
            AppMethodBeat.o(38240);
        } else {
            if (i == 0) {
                this.riN.riU.setVisibility(0);
                this.riR = true;
            }
            AppMethodBeat.o(38240);
        }
    }

    public r(Context context, int i, boolean z) {
        super(context);
        AppMethodBeat.i(38241);
        this.klY = i;
        this.czr = z;
        init(context);
        AppMethodBeat.o(38241);
    }

    public final void setSnsSource(int i) {
        this.czs = i;
    }

    public final void setType(int i) {
        AppMethodBeat.i(38242);
        this.klY = i;
        init(this.context);
        AppMethodBeat.o(38242);
    }

    public final void setCallBack(a aVar) {
        this.riP = aVar;
    }

    private void init(final Context context) {
        AppMethodBeat.i(38243);
        this.context = context;
        if (this.klY == -1) {
            AppMethodBeat.o(38243);
            return;
        }
        this.ecX = com.tencent.mm.model.r.Yz();
        View inflate = LayoutInflater.from(context).inflate(R.layout.av8, this, true);
        this.riN.riU = (LinearLayout) inflate.findViewById(R.id.eiw);
        this.riN.rje = (LinearLayout) inflate.findViewById(R.id.eiq);
        this.riN.riX = (LinearLayout) inflate.findViewById(R.id.eix);
        this.riN.riX.setOnTouchListener(this.riQ);
        this.riN.riY = (ImageView) inflate.findViewById(R.id.eiy);
        this.riN.riZ = (LinearLayout) inflate.findViewById(R.id.ej0);
        this.riN.riZ.setOnTouchListener(this.riQ);
        this.riN.rja = (LinearLayout) inflate.findViewById(R.id.ej1);
        this.riN.rjc = (TextView) inflate.findViewById(R.id.ej2);
        this.riN.rjd = (TextView) inflate.findViewById(R.id.ej3);
        this.riN.rjb = (TextView) inflate.findViewById(R.id.eiz);
        this.riN.riV = (TextView) inflate.findViewById(R.id.eip);
        this.riN.riW = (LinearLayout) inflate.findViewById(R.id.eio);
        this.riN.hrg = (TextView) inflate.findViewById(R.id.eit);
        this.riN.rji = (LinearLayout) inflate.findViewById(R.id.eir);
        ((LinearLayout) inflate.findViewById(R.id.eir)).getBackground().setAlpha(50);
        this.riN.eks = (ImageView) inflate.findViewById(R.id.eis);
        this.riN.rjf = (ImageView) inflate.findViewById(R.id.eiu);
        this.riN.rjg = (ImageView) inflate.findViewById(R.id.eiv);
        this.riN.rjh = (LinearLayout) inflate.findViewById(R.id.eim);
        this.riN.rjj = (TextView) inflate.findViewById(R.id.ein);
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
        this.riN.riX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38235);
                if (r.this.riO == null) {
                    AppMethodBeat.o(38235);
                    return;
                }
                if (r.this.riO.field_likeFlag == 0) {
                    if (r.this.riO.cqT()) {
                        com.tencent.mm.plugin.sns.model.am.a.a(r.this.riO, 1, "", "", r.this.czs);
                    } else {
                        com.tencent.mm.plugin.sns.model.am.a.a(r.this.riO.field_userName, 5, "", r.this.riO, r.this.czs);
                    }
                    r.this.riO.field_likeFlag = 1;
                    af.cnF().B(r.this.riO);
                } else {
                    r.this.riO.field_likeFlag = 0;
                    af.cnF().B(r.this.riO);
                    com.tencent.mm.plugin.sns.model.am.a.Yd(r.this.riO.cqA());
                    r.this.riO = af.cnF().kD(r.this.riO.field_snsId);
                }
                String jV = r.this.riO.field_snsId == 0 ? "" : i.jV(r.this.riO.field_snsId);
                h.pYm.e(11989, Integer.valueOf(1), jV, Integer.valueOf(0));
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38234);
                        r.this.refresh();
                        AppMethodBeat.o(38234);
                    }
                }, 500);
                AppMethodBeat.o(38235);
            }
        });
        this.riN.riZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38236);
                ab.d("MicroMsg.GalleryFooter", "comment cmd");
                if (r.this.riO == null) {
                    AppMethodBeat.o(38236);
                    return;
                }
                int i = r.this.riO.reX;
                Intent intent = new Intent();
                intent.putExtra("sns_comment_localId", i);
                intent.putExtra("sns_source", r.this.czs);
                intent.setClass(context, SnsCommentUI.class);
                String jV = r.this.riO.field_snsId == 0 ? "" : i.jV(r.this.riO.field_snsId);
                h.pYm.e(11989, Integer.valueOf(2), jV, Integer.valueOf(0));
                context.startActivity(intent);
                AppMethodBeat.o(38236);
            }
        });
        this.riN.rja.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38237);
                if (r.this.riO == null) {
                    AppMethodBeat.o(38237);
                    return;
                }
                String jV = r.this.riO.field_snsId == 0 ? "" : i.jV(r.this.riO.field_snsId);
                h.pYm.e(11989, Integer.valueOf(3), jV, Integer.valueOf(0));
                int i = r.this.riO.reX;
                Intent intent = new Intent();
                intent.setClass(context, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", r.this.riO.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", v.ap("sns_table_", (long) i));
                intent.putExtra("INTENT_FROMGALLERY", true);
                ((MMActivity) context).startActivityForResult(intent, 1);
                AppMethodBeat.o(38237);
            }
        });
        this.riN.riV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38238);
                if (r.this.riP != null) {
                    r.this.riP.cry();
                }
                AppMethodBeat.o(38238);
            }
        });
        this.riN.rjj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38239);
                if (r.this.riP != null) {
                    r.this.riP;
                }
                AppMethodBeat.o(38239);
            }
        });
        AppMethodBeat.o(38243);
    }

    public final void refresh() {
        AppMethodBeat.i(38244);
        if (this.klY == -1) {
            AppMethodBeat.o(38244);
            return;
        }
        this.riO = af.cnF().YT(this.czD);
        if (bo.isNullOrNil(this.czD) || this.riO == null) {
            AppMethodBeat.o(38244);
            return;
        }
        this.riN.rjg.setVisibility(8);
        if (aj.ab(this.riO.field_localPrivate, this.czr)) {
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
        cbf q = aj.q(this.riO);
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
                ab.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                if (this.riO.field_likeFlag == 1) {
                    this.riN.rjb.setText(getResources().getString(R.string.el0));
                    this.riN.riY.setImageResource(R.raw.friendactivity_comment_likeicon_havon);
                } else {
                    this.riN.rjb.setText(String.valueOf(getResources().getString(R.string.el1)));
                    this.riN.riY.setImageResource(R.raw.friendactivity_comment_likeicon_normal);
                }
            }
            if (this.ecX.equals(this.riO.field_userName) || !this.czr) {
                this.riN.eks.setVisibility(8);
            } else {
                this.riN.eks.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.a.b.b(this.riN.eks, this.riO.field_userName);
            }
        }
        if (this.riO.cqu() == null) {
            this.riN.hrg.setVisibility(8);
            AppMethodBeat.o(38244);
            return;
        }
        String str = this.riO.cqu().xfF;
        if (str == null || str.equals("")) {
            this.riN.hrg.setText("");
            this.riN.hrg.setVisibility(8);
        } else {
            this.riN.hrg.setText(j.b(getContext(), str + " ", this.riN.hrg.getTextSize()));
            this.riN.hrg.setVisibility(0);
        }
        if (aj.ab(this.riO.field_localPrivate, this.czr)) {
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
        AppMethodBeat.o(38244);
    }

    public final void setFooter(String str) {
        AppMethodBeat.i(38245);
        this.czD = str;
        refresh();
        AppMethodBeat.o(38245);
    }

    public final void Zv(String str) {
        AppMethodBeat.i(38246);
        setFooter(str);
        AppMethodBeat.o(38246);
    }

    public final int getFooterH() {
        AppMethodBeat.i(38247);
        if (this.riN.riU != null) {
            int height = this.riN.riU.getHeight();
            AppMethodBeat.o(38247);
            return height;
        }
        AppMethodBeat.o(38247);
        return 10;
    }
}
