package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C24054q;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.HelperHeaderPreference */
public class HelperHeaderPreference extends Preference {
    private C7616ad ehM;
    private ImageView eks;
    private TextView gKr;
    private TextView gnh;
    private boolean gqJ = false;
    private TextView pnE;
    private C39507a pnF;

    /* renamed from: com.tencent.mm.plugin.profile.ui.HelperHeaderPreference$a */
    public interface C39507a {
        /* renamed from: a */
        void mo36975a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23638);
        this.eks = (ImageView) view.findViewById(2131821459);
        this.gnh = (TextView) view.findViewById(2131822999);
        this.pnE = (TextView) view.findViewById(2131821460);
        this.gKr = (TextView) view.findViewById(2131821461);
        this.gqJ = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.m2505o(23638);
    }

    /* renamed from: pZ */
    private void m67507pZ(String str) {
        AppMethodBeat.m2504i(23639);
        C4990ab.m7410d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(str)));
        if (this.eks != null && this.ehM.field_username.equals(str)) {
            C40460b.m69434b(this.eks, str);
        }
        AppMethodBeat.m2505o(23639);
    }

    /* renamed from: jR */
    public final void mo62463jR(boolean z) {
        AppMethodBeat.m2504i(23640);
        if (this.pnF == null) {
            AppMethodBeat.m2505o(23640);
        } else if (z) {
            this.gnh.setTextColor(C24054q.m37013ii(this.mContext));
            this.gnh.setText(C25738R.string.e_a);
            this.gnh.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.ap2, 0, 0, 0);
            AppMethodBeat.m2505o(23640);
        } else {
            this.gnh.setTextColor(C24054q.m37014ij(this.mContext));
            this.gnh.setText(C25738R.string.e_i);
            this.gnh.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.ap1, 0, 0, 0);
            AppMethodBeat.m2505o(23640);
        }
    }

    private void initView() {
        AppMethodBeat.m2504i(23641);
        if (!this.gqJ || this.ehM == null) {
            C4990ab.m7420w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.gqJ + "contact = " + this.ehM);
            AppMethodBeat.m2505o(23641);
            return;
        }
        m67507pZ(this.ehM.field_username);
        if (this.pnE != null) {
            this.pnE.setText(this.ehM.mo16706Oi());
        }
        if (this.pnF != null) {
            this.pnF.mo36975a(this);
            CharSequence hint = this.pnF.getHint();
            if (hint != null) {
                this.gKr.setText(hint);
                this.gKr.setVisibility(0);
                AppMethodBeat.m2505o(23641);
                return;
            }
            this.gKr.setVisibility(8);
        }
        AppMethodBeat.m2505o(23641);
    }

    /* renamed from: a */
    public final void mo62462a(C7616ad c7616ad, C39507a c39507a) {
        AppMethodBeat.m2504i(23642);
        Assert.assertTrue(c7616ad != null);
        this.ehM = c7616ad;
        this.pnF = c39507a;
        initView();
        AppMethodBeat.m2505o(23642);
    }
}
