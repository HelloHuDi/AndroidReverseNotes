package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private ad ehM;
    private ImageView eks;
    private TextView gKr;
    private TextView gnh;
    private boolean gqJ = false;
    private TextView pnE;
    private a pnF;

    public interface a {
        void a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23638);
        this.eks = (ImageView) view.findViewById(R.id.y1);
        this.gnh = (TextView) view.findViewById(R.id.b2c);
        this.pnE = (TextView) view.findViewById(R.id.y2);
        this.gKr = (TextView) view.findViewById(R.id.y3);
        this.gqJ = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(23638);
    }

    private void pZ(String str) {
        AppMethodBeat.i(23639);
        ab.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(str)));
        if (this.eks != null && this.ehM.field_username.equals(str)) {
            b.b(this.eks, str);
        }
        AppMethodBeat.o(23639);
    }

    public final void jR(boolean z) {
        AppMethodBeat.i(23640);
        if (this.pnF == null) {
            AppMethodBeat.o(23640);
        } else if (z) {
            this.gnh.setTextColor(q.ii(this.mContext));
            this.gnh.setText(R.string.e_a);
            this.gnh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap2, 0, 0, 0);
            AppMethodBeat.o(23640);
        } else {
            this.gnh.setTextColor(q.ij(this.mContext));
            this.gnh.setText(R.string.e_i);
            this.gnh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap1, 0, 0, 0);
            AppMethodBeat.o(23640);
        }
    }

    private void initView() {
        AppMethodBeat.i(23641);
        if (!this.gqJ || this.ehM == null) {
            ab.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.gqJ + "contact = " + this.ehM);
            AppMethodBeat.o(23641);
            return;
        }
        pZ(this.ehM.field_username);
        if (this.pnE != null) {
            this.pnE.setText(this.ehM.Oi());
        }
        if (this.pnF != null) {
            this.pnF.a(this);
            CharSequence hint = this.pnF.getHint();
            if (hint != null) {
                this.gKr.setText(hint);
                this.gKr.setVisibility(0);
                AppMethodBeat.o(23641);
                return;
            }
            this.gKr.setVisibility(8);
        }
        AppMethodBeat.o(23641);
    }

    public final void a(ad adVar, a aVar) {
        AppMethodBeat.i(23642);
        Assert.assertTrue(adVar != null);
        this.ehM = adVar;
        this.pnF = aVar;
        initView();
        AppMethodBeat.o(23642);
    }
}
