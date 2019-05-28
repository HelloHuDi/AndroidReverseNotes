package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.protocal.protobuf.C35917fq;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.ui.ArtistHeader */
public class ArtistHeader extends LinearLayout implements C43559b {
    private Context context = null;
    private View iVh;
    private C15532i mst = null;
    private C29103b rgE;
    private ImageView rgF;
    private ProgressBar rgG;
    private C35917fq rgz = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistHeader$2 */
    class C291012 implements Runnable {
        C291012() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38107);
            Bitmap a = C13373af.cnC().mo37435a(ArtistHeader.this.rgz.vHA.vHB, ArtistHeader.this.rgF, ArtistHeader.this.context.hashCode(), true, C44222az.xYU, false);
            if (C29036i.m46072B(a)) {
                ArtistHeader.m46264a(ArtistHeader.this, a);
                ArtistHeader.this.rgG.setVisibility(4);
                ArtistHeader.this.iVh.setVisibility(4);
                AppMethodBeat.m2505o(38107);
                return;
            }
            AppMethodBeat.m2505o(38107);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistHeader$a */
    public interface C29102a {
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistHeader$b */
    class C29103b {
        ImageView eks;
        TextView gne;
        TextView hrg;
        TextView rgJ;
        TextView rgK;

        C29103b() {
        }
    }

    public ArtistHeader(Context context) {
        super(context);
        AppMethodBeat.m2504i(38108);
        init(context);
        AppMethodBeat.m2505o(38108);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38109);
        init(context);
        AppMethodBeat.m2505o(38109);
    }

    private void init(final Context context) {
        AppMethodBeat.m2504i(38110);
        View inflate = LayoutInflater.from(context).inflate(2130970745, this, true);
        this.context = context;
        this.rgE = new C29103b();
        this.rgE.eks = (ImageView) inflate.findViewById(2131827677);
        this.rgE.hrg = (TextView) inflate.findViewById(2131827680);
        this.rgE.rgJ = (TextView) inflate.findViewById(2131827678);
        this.rgE.rgK = (TextView) inflate.findViewById(2131827681);
        this.rgE.gne = (TextView) inflate.findViewById(2131827679);
        this.rgE.eks.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.sns.ui.ArtistHeader$1$1 */
            class C291001 implements OnClickListener {
                C291001() {
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(38105);
                    ArtistHeader.this.mst.dismiss();
                    AppMethodBeat.m2505o(38105);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38106);
                if (ArtistHeader.this.mst != null && ArtistHeader.this.mst.isShowing()) {
                    AppMethodBeat.m2505o(38106);
                } else if (ArtistHeader.this.rgz == null) {
                    AppMethodBeat.m2505o(38106);
                } else {
                    View inflate = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(2130971002, null);
                    ArtistHeader.this.mst = new C15532i(ArtistHeader.this.getContext(), C25738R.style.f11414zs);
                    inflate.setOnClickListener(new C291001());
                    ArtistHeader.this.mst.setCanceledOnTouchOutside(true);
                    ArtistHeader.this.mst.setContentView(inflate);
                    ArtistHeader.this.mst.show();
                    ArtistHeader.this.rgF = (ImageView) inflate.findViewById(2131828433);
                    ArtistHeader.this.rgG = (ProgressBar) inflate.findViewById(2131828435);
                    ArtistHeader.this.iVh = inflate.findViewById(2131828434);
                    Bitmap a = C13373af.cnC().mo37435a(ArtistHeader.this.rgz.vHA.vHB, ArtistHeader.this.rgF, context.hashCode(), true, C44222az.xYU, false);
                    if (C29036i.m46072B(a)) {
                        ArtistHeader.m46264a(ArtistHeader.this, a);
                        ArtistHeader.this.rgG.setVisibility(4);
                        ArtistHeader.this.iVh.setVisibility(4);
                        AppMethodBeat.m2505o(38106);
                        return;
                    }
                    C13373af.cnC().mo37455b(ArtistHeader.this.rgz.vHA.vHB, ArtistHeader.this.rgF, context.hashCode(), C44222az.xYU);
                    AppMethodBeat.m2505o(38106);
                }
            }
        });
        AppMethodBeat.m2505o(38110);
    }

    public void setUserName(C35917fq c35917fq) {
        AppMethodBeat.m2504i(38111);
        if (c35917fq == null) {
            C4990ab.m7412e("MicroMsg.ArtistHeader", "userName or selfName is null ");
            AppMethodBeat.m2505o(38111);
            return;
        }
        this.rgz = c35917fq;
        C13373af.cnC().mo37455b(c35917fq.vHA.vHB, this.rgE.eks, this.context.hashCode(), C44222az.xYU);
        this.rgE.rgJ.setText(c35917fq.Name);
        this.rgE.hrg.setText(c35917fq.vEA);
        this.rgE.gne.setText(c35917fq.Title);
        this.rgE.rgK.setText(c35917fq.vHz);
        AppMethodBeat.m2505o(38111);
    }

    public void setBackClickListener(C29102a c29102a) {
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
        AppMethodBeat.m2504i(38112);
        if (this.rgz == null) {
            AppMethodBeat.m2505o(38112);
            return;
        }
        if (this.mst != null && this.mst.isShowing()) {
            if (!z) {
                bau bau = this.rgz.vHA.vHB;
                if (bau.f17915Id != null && bau.f17915Id.equals(str)) {
                    Toast.makeText(this.context, this.context.getString(C25738R.string.ek_), 0).show();
                    AppMethodBeat.m2505o(38112);
                    return;
                }
            }
            if (this.rgF != null) {
                this.rgF.post(new C291012());
            }
        }
        AppMethodBeat.m2505o(38112);
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
    }

    public final void cmu() {
    }
}
