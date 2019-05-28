package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;

/* renamed from: com.tencent.mm.ui.base.preference.DialogPreference */
public final class DialogPreference extends Preference {
    private C5653c gud;
    public C23632a yBv;
    private final C15539d yBx;
    C15534a yBy;

    /* renamed from: com.tencent.mm.ui.base.preference.DialogPreference$1 */
    class C155331 implements OnItemClickListener {
        C155331() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107154);
            if (DialogPreference.this.gud != null) {
                DialogPreference.this.gud.dismiss();
            }
            DialogPreference.this.setValue((String) DialogPreference.this.yBx.yBu[i]);
            if (DialogPreference.this.yBy != null) {
                DialogPreference.this.yBy.dAx();
            }
            if (DialogPreference.this.yBv != null) {
                DialogPreference.this.yBv.mo39405a(DialogPreference.this, DialogPreference.this.getValue());
            }
            AppMethodBeat.m2505o(107154);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.DialogPreference$a */
    public interface C15534a {
        void dAx();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107155);
        this.yBx = new C15539d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.ChoicePreference, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.yBx.yBt = context.getResources().getStringArray(resourceId);
        }
        this.yBx.yBu = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        this.yBx.dAw();
        AppMethodBeat.m2505o(107155);
    }

    /* renamed from: a */
    public final void mo27696a(C23632a c23632a) {
        this.yBv = c23632a;
    }

    public final String getValue() {
        return this.yBx.value;
    }

    public final void setValue(String str) {
        AppMethodBeat.m2504i(107156);
        this.yBx.value = str;
        C15538c c15538c = (C15538c) this.yBx.values.get(str);
        if (c15538c == null) {
            this.yBx.piC = -1;
            AppMethodBeat.m2505o(107156);
            return;
        }
        this.yBx.piC = c15538c.f2986id;
        AppMethodBeat.m2505o(107156);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107157);
        C15538c c15538c = (C15538c) this.yBx.values.get(this.yBx.value);
        if (c15538c != null) {
            setSummary(c15538c.text);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(107157);
    }

    /* Access modifiers changed, original: protected|final */
    public final void showDialog() {
        AppMethodBeat.m2504i(107158);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this.mContext, 2130970120, null);
        listViewInScrollView.setOnItemClickListener(new C155331());
        listViewInScrollView.setAdapter(this.yBx);
        C5652a c5652a = new C5652a(this.mContext);
        c5652a.asD(getTitle().toString());
        c5652a.mo11479fn(listViewInScrollView);
        this.gud = c5652a.aMb();
        this.gud.show();
        C30379h.m48455a(this.mContext, this.gud);
        AppMethodBeat.m2505o(107158);
    }
}
