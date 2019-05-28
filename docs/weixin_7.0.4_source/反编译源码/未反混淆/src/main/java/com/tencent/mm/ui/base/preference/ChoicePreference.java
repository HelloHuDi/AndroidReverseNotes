package com.tencent.mm.ui.base.preference;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference.a;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    private int piC;
    String value;
    private final HashMap<CharSequence, b> values;
    private RadioGroup yBs;
    private CharSequence[] yBt;
    private CharSequence[] yBu;
    public a yBv;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107146);
        this.values = new HashMap();
        this.piC = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.ad.a.a.ChoicePreference, i, 0);
        this.yBt = obtainStyledAttributes.getTextArray(0);
        this.yBu = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        dAw();
        AppMethodBeat.o(107146);
    }

    public final void a(a aVar) {
        this.yBv = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107147);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.aem, viewGroup2);
        this.yBs = (RadioGroup) onCreateView.findViewById(R.id.d_c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.yBu.length) {
                b bVar = (b) this.values.get(this.yBu[i2]);
                if (bVar != null) {
                    RadioButton radioButton;
                    if (i2 == 0) {
                        radioButton = (RadioButton) layoutInflater.inflate(R.layout.adh, null);
                        bVar.a(radioButton);
                        this.yBs.addView(radioButton);
                    } else if (i2 == this.yBu.length - 1) {
                        radioButton = (RadioButton) layoutInflater.inflate(R.layout.adj, null);
                        bVar.a(radioButton);
                        this.yBs.addView(radioButton);
                    } else {
                        radioButton = (RadioButton) layoutInflater.inflate(R.layout.adi, null);
                        bVar.a(radioButton);
                        this.yBs.addView(radioButton);
                    }
                }
                i = i2 + 1;
            } else {
                this.yBs.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                        AppMethodBeat.i(107145);
                        if (ChoicePreference.this.yBv != null) {
                            if (i != -1) {
                                ChoicePreference.this.value = ChoicePreference.this.yBu[i - 1048576];
                            } else {
                                ChoicePreference.this.value = null;
                            }
                            ChoicePreference.this.piC = i;
                            ChoicePreference.this.yBv.a(ChoicePreference.this, ChoicePreference.this.value);
                        }
                        AppMethodBeat.o(107145);
                    }
                });
                AppMethodBeat.o(107147);
                return onCreateView;
            }
        }
    }

    private void dAw() {
        boolean z;
        int i = 0;
        AppMethodBeat.i(107148);
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
            this.values.put(this.yBu[i], new b(this.yBt[i], 1048576 + i));
            i++;
        }
        AppMethodBeat.o(107148);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107149);
        super.onBindView(view);
        if (this.yBs != null) {
            this.yBs.check(this.piC);
        }
        AppMethodBeat.o(107149);
    }

    public final void setValue(String str) {
        AppMethodBeat.i(107150);
        this.value = str;
        b bVar = (b) this.values.get(str);
        if (bVar == null) {
            this.piC = -1;
            AppMethodBeat.o(107150);
            return;
        }
        this.piC = bVar.id;
        AppMethodBeat.o(107150);
    }
}
