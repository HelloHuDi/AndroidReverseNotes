package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;

public class CheckBoxPreference extends Preference {
    private MMSwitchBtn ixT;
    private View mView;
    private TextView ttD;
    private int ttE;
    private String ttF;
    private int ttG;
    boolean uOT;

    /* renamed from: com.tencent.weui.base.preference.CheckBoxPreference$1 */
    class C60291 implements C30795a {
        C60291() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(113248);
            CheckBoxPreference.m9482a(CheckBoxPreference.this, Boolean.valueOf(z));
            AppMethodBeat.m2505o(113248);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m9482a(CheckBoxPreference checkBoxPreference, Object obj) {
        AppMethodBeat.m2504i(113252);
        boolean callChangeListener = checkBoxPreference.callChangeListener(obj);
        AppMethodBeat.m2505o(113252);
        return callChangeListener;
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113249);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(113249);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(113250);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), 2130970207, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.m2505o(113250);
        return view;
    }

    public void onBindView(View view) {
        AppMethodBeat.m2504i(113251);
        super.onBindView(view);
        this.ixT = (MMSwitchBtn) view.findViewById(2131820932);
        this.ixT.setSwitchListener(new C60291());
        this.ixT.setCheck(this.uOT);
        if (!isEnabled()) {
            this.ixT.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(C25738R.color.f11786h8));
        }
        this.ttD = (TextView) view.findViewById(2131826079);
        String str = this.ttF;
        int i = this.ttE;
        this.ttE = i;
        this.ttF = str;
        if (this.ttD != null) {
            if (i > 0) {
                this.ttD.setBackgroundResource(this.ttE);
            }
            if (!TextUtils.isEmpty(this.ttF)) {
                this.ttD.setText(this.ttF);
            }
        }
        this.ttG = this.ttG;
        if (this.ttD != null) {
            this.ttD.setVisibility(this.ttG);
        }
        AppMethodBeat.m2505o(113251);
    }

    public final boolean isChecked() {
        if (this.ixT != null) {
            return this.ixT.zMU;
        }
        return this.uOT;
    }
}
