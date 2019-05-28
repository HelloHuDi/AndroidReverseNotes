package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.LanguagePreference */
public class LanguagePreference extends Preference {
    public C26617a gBB;

    /* renamed from: com.tencent.mm.plugin.account.ui.LanguagePreference$a */
    public static class C26617a {
        String gBC;
        private String gBD;
        public String gBE;
        public boolean gBF;

        public C26617a(String str, String str2, String str3, boolean z) {
            this.gBC = str;
            this.gBD = str2;
            this.gBE = str3;
            this.gBF = z;
        }
    }

    public LanguagePreference(Context context) {
        this(context, null);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(124905);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(124905);
    }

    /* renamed from: a */
    public final void mo44386a(C26617a c26617a) {
        AppMethodBeat.m2504i(124906);
        if (c26617a == null || C5046bo.isNullOrNil(c26617a.gBE)) {
            C4990ab.m7412e("MicroMsg.LanguagePreference", "setInfo info error");
            AppMethodBeat.m2505o(124906);
            return;
        }
        this.gBB = c26617a;
        setKey(c26617a.gBE);
        AppMethodBeat.m2505o(124906);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(124907);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970155, viewGroup2);
        AppMethodBeat.m2505o(124907);
        return onCreateView;
    }

    public final void onBindView(View view) {
        int i = 1;
        AppMethodBeat.m2504i(124908);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131821776);
        CheckBox checkBox = (CheckBox) view.findViewById(2131824618);
        int i2 = textView != null ? 1 : 0;
        if (checkBox == null) {
            i = 0;
        }
        if ((i & i2) != 0) {
            textView.setText(this.gBB.gBC);
            checkBox.setChecked(this.gBB.gBF);
        }
        mo39406NW(8);
        AppMethodBeat.m2505o(124908);
    }
}
