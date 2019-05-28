package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;
import junit.framework.Assert;

public class AppHeaderPreference extends Preference {
    private boolean cPT = false;
    private ImageView eks;
    private TextView gKr;
    private TextView gnh;
    private boolean gqJ = false;
    private TextView pnE;
    private a sux;

    public interface a {
        String cDK();

        Bitmap cDL();

        String getHint();

        String lY(boolean z);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(25439);
        this.eks = (ImageView) view.findViewById(R.id.y1);
        this.gnh = (TextView) view.findViewById(R.id.b2c);
        this.pnE = (TextView) view.findViewById(R.id.y2);
        this.gKr = (TextView) view.findViewById(R.id.y3);
        this.gqJ = true;
        if (!this.gqJ || this.sux == null) {
            ab.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.gqJ);
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
                String lY = this.sux.lY(z);
                if (z) {
                    if (lY == null || lY.length() <= 0) {
                        this.gnh.setVisibility(8);
                    } else {
                        this.gnh.setTextColor(q.ii(this.mContext));
                        this.gnh.setText(lY);
                        this.gnh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap2, 0, 0, 0);
                    }
                } else if (lY == null || lY.length() <= 0) {
                    this.gnh.setVisibility(8);
                } else {
                    this.gnh.setTextColor(q.ij(this.mContext));
                    this.gnh.setText(lY);
                    this.gnh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap1, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.o(25439);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(25440);
        Assert.assertTrue(aVar != null);
        this.sux = aVar;
        this.cPT = z;
        AppMethodBeat.o(25440);
    }
}
