package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;

/* renamed from: com.tencent.mm.ui.base.preference.CheckBoxPreference */
public class CheckBoxPreference extends Preference {
    private MMSwitchBtn ixT;
    private View mView;
    private TextView ttD;
    private int ttE;
    private String ttF;
    private int ttG;
    public boolean uOT;

    /* renamed from: com.tencent.mm.ui.base.preference.CheckBoxPreference$1 */
    class C360741 implements C30795a {
        C360741() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(107134);
            CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z));
            AppMethodBeat.m2505o(107134);
        }
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107135);
        this.uOT = false;
        this.ttE = -1;
        this.ttF = "";
        this.ttG = 8;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107135);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107136);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970207, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.m2505o(107136);
        return view;
    }

    public void onBindView(View view) {
        AppMethodBeat.m2504i(107137);
        super.onBindView(view);
        mo39406NW(8);
        this.ixT = (MMSwitchBtn) view.findViewById(2131820932);
        this.ixT.setSwitchListener(new C360741());
        this.ixT.setCheck(this.uOT);
        if (!isEnabled()) {
            this.ixT.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(C25738R.color.f11943mh));
            ((TextView) view.findViewById(16908304)).setTextColor(view.getResources().getColor(C25738R.color.f11943mh));
        }
        this.ttD = (TextView) view.findViewById(2131826079);
        mo9404ds(this.ttF, this.ttE);
        mo9403Hm(this.ttG);
        AppMethodBeat.m2505o(107137);
    }

    public final boolean isChecked() {
        if (this.ixT != null) {
            return this.ixT.zMU;
        }
        return this.uOT;
    }

    /* renamed from: qg */
    public final void mo74839qg(boolean z) {
        AppMethodBeat.m2504i(107138);
        if (this.ixT != null) {
            this.uOT = z;
            this.ixT.setCheck(z);
        }
        AppMethodBeat.m2505o(107138);
    }

    /* renamed from: ds */
    public void mo9404ds(String str, int i) {
        AppMethodBeat.m2504i(107139);
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
        AppMethodBeat.m2505o(107139);
    }

    /* renamed from: Hm */
    public void mo9403Hm(int i) {
        AppMethodBeat.m2504i(107140);
        this.ttG = i;
        if (this.ttD != null) {
            this.ttD.setVisibility(this.ttG);
        }
        AppMethodBeat.m2505o(107140);
    }
}
