package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.i;

public class ArtistHeader extends LinearLayout implements com.tencent.mm.plugin.sns.model.b.b {
    private Context context = null;
    private View iVh;
    private i mst = null;
    private b rgE;
    private ImageView rgF;
    private ProgressBar rgG;
    private fq rgz = null;

    public interface a {
    }

    class b {
        ImageView eks;
        TextView gne;
        TextView hrg;
        TextView rgJ;
        TextView rgK;

        b() {
        }
    }

    public ArtistHeader(Context context) {
        super(context);
        AppMethodBeat.i(38108);
        init(context);
        AppMethodBeat.o(38108);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38109);
        init(context);
        AppMethodBeat.o(38109);
    }

    private void init(final Context context) {
        AppMethodBeat.i(38110);
        View inflate = LayoutInflater.from(context).inflate(R.layout.aus, this, true);
        this.context = context;
        this.rgE = new b();
        this.rgE.eks = (ImageView) inflate.findViewById(R.id.egt);
        this.rgE.hrg = (TextView) inflate.findViewById(R.id.egw);
        this.rgE.rgJ = (TextView) inflate.findViewById(R.id.egu);
        this.rgE.rgK = (TextView) inflate.findViewById(R.id.egx);
        this.rgE.gne = (TextView) inflate.findViewById(R.id.egv);
        this.rgE.eks.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38106);
                if (ArtistHeader.this.mst != null && ArtistHeader.this.mst.isShowing()) {
                    AppMethodBeat.o(38106);
                } else if (ArtistHeader.this.rgz == null) {
                    AppMethodBeat.o(38106);
                } else {
                    View inflate = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(R.layout.b1p, null);
                    ArtistHeader.this.mst = new i(ArtistHeader.this.getContext(), R.style.zs);
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(38105);
                            ArtistHeader.this.mst.dismiss();
                            AppMethodBeat.o(38105);
                        }
                    });
                    ArtistHeader.this.mst.setCanceledOnTouchOutside(true);
                    ArtistHeader.this.mst.setContentView(inflate);
                    ArtistHeader.this.mst.show();
                    ArtistHeader.this.rgF = (ImageView) inflate.findViewById(R.id.f19);
                    ArtistHeader.this.rgG = (ProgressBar) inflate.findViewById(R.id.f1a);
                    ArtistHeader.this.iVh = inflate.findViewById(R.id.f1_);
                    Bitmap a = af.cnC().a(ArtistHeader.this.rgz.vHA.vHB, ArtistHeader.this.rgF, context.hashCode(), true, az.xYU, false);
                    if (com.tencent.mm.plugin.sns.data.i.B(a)) {
                        ArtistHeader.a(ArtistHeader.this, a);
                        ArtistHeader.this.rgG.setVisibility(4);
                        ArtistHeader.this.iVh.setVisibility(4);
                        AppMethodBeat.o(38106);
                        return;
                    }
                    af.cnC().b(ArtistHeader.this.rgz.vHA.vHB, ArtistHeader.this.rgF, context.hashCode(), az.xYU);
                    AppMethodBeat.o(38106);
                }
            }
        });
        AppMethodBeat.o(38110);
    }

    public void setUserName(fq fqVar) {
        AppMethodBeat.i(38111);
        if (fqVar == null) {
            ab.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
            AppMethodBeat.o(38111);
            return;
        }
        this.rgz = fqVar;
        af.cnC().b(fqVar.vHA.vHB, this.rgE.eks, this.context.hashCode(), az.xYU);
        this.rgE.rgJ.setText(fqVar.Name);
        this.rgE.hrg.setText(fqVar.vEA);
        this.rgE.gne.setText(fqVar.Title);
        this.rgE.rgK.setText(fqVar.vHz);
        AppMethodBeat.o(38111);
    }

    public void setBackClickListener(a aVar) {
    }

    public final void Xw(String str) {
    }

    public final void bj(String str, boolean z) {
        AppMethodBeat.i(38112);
        if (this.rgz == null) {
            AppMethodBeat.o(38112);
            return;
        }
        if (this.mst != null && this.mst.isShowing()) {
            if (!z) {
                bau bau = this.rgz.vHA.vHB;
                if (bau.Id != null && bau.Id.equals(str)) {
                    Toast.makeText(this.context, this.context.getString(R.string.ek_), 0).show();
                    AppMethodBeat.o(38112);
                    return;
                }
            }
            if (this.rgF != null) {
                this.rgF.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38107);
                        Bitmap a = af.cnC().a(ArtistHeader.this.rgz.vHA.vHB, ArtistHeader.this.rgF, ArtistHeader.this.context.hashCode(), true, az.xYU, false);
                        if (com.tencent.mm.plugin.sns.data.i.B(a)) {
                            ArtistHeader.a(ArtistHeader.this, a);
                            ArtistHeader.this.rgG.setVisibility(4);
                            ArtistHeader.this.iVh.setVisibility(4);
                            AppMethodBeat.o(38107);
                            return;
                        }
                        AppMethodBeat.o(38107);
                    }
                });
            }
        }
        AppMethodBeat.o(38112);
    }

    public final void bk(String str, boolean z) {
    }

    public final void cmu() {
    }
}
