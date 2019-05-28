package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C24054q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference */
public class AppHeaderPreference extends Preference {
    private boolean cPT = false;
    private ImageView eks;
    private TextView gKr;
    private TextView gnh;
    private boolean gqJ = false;
    private TextView pnE;
    private C43670a sux;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference$a */
    public interface C43670a {
        String cDK();

        Bitmap cDL();

        String getHint();

        /* renamed from: lY */
        String mo63139lY(boolean z);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(25439);
        this.eks = (ImageView) view.findViewById(2131821459);
        this.gnh = (TextView) view.findViewById(2131822999);
        this.pnE = (TextView) view.findViewById(2131821460);
        this.gKr = (TextView) view.findViewById(2131821461);
        this.gqJ = true;
        if (!this.gqJ || this.sux == null) {
            C4990ab.m7420w("MicroMsg.HeaderPreference", "initView : bindView = " + this.gqJ);
        } else {
            Bitmap cDL = this.sux.cDL();
            if (!(this.eks == null || cDL == null || cDL.isRecycled())) {
                this.eks.setImageBitmap(cDL);
            }
            String cDK = this.sux.cDK();
            if (!(this.pnE == null || cDK == null || cDK.length() <= 0)) {
                this.pnE.setText(cDK);
            }
            cDK = this.sux.getHint();
            if (cDK != null) {
                this.gKr.setText(cDK);
                this.gKr.setVisibility(0);
            } else {
                this.gKr.setVisibility(8);
            }
            boolean z = this.cPT;
            if (this.gnh != null) {
                String lY = this.sux.mo63139lY(z);
                if (z) {
                    if (lY == null || lY.length() <= 0) {
                        this.gnh.setVisibility(8);
                    } else {
                        this.gnh.setTextColor(C24054q.m37013ii(this.mContext));
                        this.gnh.setText(lY);
                        this.gnh.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.ap2, 0, 0, 0);
                    }
                } else if (lY == null || lY.length() <= 0) {
                    this.gnh.setVisibility(8);
                } else {
                    this.gnh.setTextColor(C24054q.m37014ij(this.mContext));
                    this.gnh.setText(lY);
                    this.gnh.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.ap1, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(25439);
    }

    /* renamed from: a */
    public final void mo74454a(C43670a c43670a, boolean z) {
        AppMethodBeat.m2504i(25440);
        Assert.assertTrue(c43670a != null);
        this.sux = c43670a;
        this.cPT = z;
        AppMethodBeat.m2505o(25440);
    }
}
