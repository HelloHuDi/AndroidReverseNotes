package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class DialogPreference extends Preference {
    private c gud;
    public com.tencent.mm.ui.base.preference.Preference.a yBv;
    private final d yBx;
    a yBy;

    public interface a {
        void dAx();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107155);
        this.yBx = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.ad.a.a.ChoicePreference, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.yBx.yBt = context.getResources().getStringArray(resourceId);
        }
        this.yBx.yBu = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
        this.yBx.dAw();
        AppMethodBeat.o(107155);
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.yBv = aVar;
    }

    public final String getValue() {
        return this.yBx.value;
    }

    public final void setValue(String str) {
        AppMethodBeat.i(107156);
        this.yBx.value = str;
        c cVar = (c) this.yBx.values.get(str);
        if (cVar == null) {
            this.yBx.piC = -1;
            AppMethodBeat.o(107156);
            return;
        }
        this.yBx.piC = cVar.id;
        AppMethodBeat.o(107156);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(107157);
        c cVar = (c) this.yBx.values.get(this.yBx.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
        AppMethodBeat.o(107157);
    }

    /* Access modifiers changed, original: protected|final */
    public final void showDialog() {
        AppMethodBeat.i(107158);
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this.mContext, R.layout.adx, null);
        listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107154);
                if (DialogPreference.this.gud != null) {
                    DialogPreference.this.gud.dismiss();
                }
                DialogPreference.this.setValue((String) DialogPreference.this.yBx.yBu[i]);
                if (DialogPreference.this.yBy != null) {
                    DialogPreference.this.yBy.dAx();
                }
                if (DialogPreference.this.yBv != null) {
                    DialogPreference.this.yBv.a(DialogPreference.this, DialogPreference.this.getValue());
                }
                AppMethodBeat.o(107154);
            }
        });
        listViewInScrollView.setAdapter(this.yBx);
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.mContext);
        aVar.asD(getTitle().toString());
        aVar.fn(listViewInScrollView);
        this.gud = aVar.aMb();
        this.gud.show();
        h.a(this.mContext, this.gud);
        AppMethodBeat.o(107158);
    }
}
