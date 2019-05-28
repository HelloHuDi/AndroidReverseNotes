package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.base.preference.ChoicePreference */
public final class ChoicePreference extends Preference {
    private int piC;
    String value;
    private final HashMap<CharSequence, C40674b> values;
    private RadioGroup yBs;
    private CharSequence[] yBt;
    private CharSequence[] yBu;
    public C23632a yBv;

    /* renamed from: com.tencent.mm.ui.base.preference.ChoicePreference$1 */
    class C236311 implements OnCheckedChangeListener {
        C236311() {
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            AppMethodBeat.m2504i(107145);
            if (ChoicePreference.this.yBv != null) {
                if (i != -1) {
                    ChoicePreference.this.value = ChoicePreference.this.yBu[i - 1048576];
                } else {
                    ChoicePreference.this.value = null;
                }
                ChoicePreference.this.piC = i;
                ChoicePreference.this.yBv.mo39405a(ChoicePreference.this, ChoicePreference.this.value);
            }
            AppMethodBeat.m2505o(107145);
        }
    }

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107146);
        this.values = new HashMap();
        this.piC = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.ChoicePreference, i, 0);
        this.yBt = obtainStyledAttributes.getTextArray(0);
        this.yBu = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        dAw();
        AppMethodBeat.m2505o(107146);
    }

    /* renamed from: a */
    public final void mo27696a(C23632a c23632a) {
        this.yBv = c23632a;
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107147);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970146, viewGroup2);
        this.yBs = (RadioGroup) onCreateView.findViewById(2131826032);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.yBu.length) {
                C40674b c40674b = (C40674b) this.values.get(this.yBu[i2]);
                if (c40674b != null) {
                    RadioButton radioButton;
                    if (i2 == 0) {
                        radioButton = (RadioButton) layoutInflater.inflate(2130970104, null);
                        c40674b.mo64171a(radioButton);
                        this.yBs.addView(radioButton);
                    } else if (i2 == this.yBu.length - 1) {
                        radioButton = (RadioButton) layoutInflater.inflate(2130970106, null);
                        c40674b.mo64171a(radioButton);
                        this.yBs.addView(radioButton);
                    } else {
                        radioButton = (RadioButton) layoutInflater.inflate(2130970105, null);
                        c40674b.mo64171a(radioButton);
                        this.yBs.addView(radioButton);
                    }
                }
                i = i2 + 1;
            } else {
                this.yBs.setOnCheckedChangeListener(new C236311());
                AppMethodBeat.m2505o(107147);
                return onCreateView;
            }
        }
    }

    private void dAw() {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(107148);
        if (this.yBt == null) {
            this.yBt = new CharSequence[0];
        }
        if (this.yBu == null) {
            this.yBu = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.yBt.length == this.yBu.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.yBu.length) {
            this.values.put(this.yBu[i], new C40674b(this.yBt[i], 1048576 + i));
            i++;
        }
        AppMethodBeat.m2505o(107148);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107149);
        super.onBindView(view);
        if (this.yBs != null) {
            this.yBs.check(this.piC);
        }
        AppMethodBeat.m2505o(107149);
    }

    public final void setValue(String str) {
        AppMethodBeat.m2504i(107150);
        this.value = str;
        C40674b c40674b = (C40674b) this.values.get(str);
        if (c40674b == null) {
            this.piC = -1;
            AppMethodBeat.m2505o(107150);
            return;
        }
        this.piC = c40674b.f16209id;
        AppMethodBeat.m2505o(107150);
    }
}
