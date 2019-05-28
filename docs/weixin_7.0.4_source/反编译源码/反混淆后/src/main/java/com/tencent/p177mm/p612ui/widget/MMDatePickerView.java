package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.ui.widget.MMDatePickerView */
public class MMDatePickerView extends LinearLayout implements OnClickListener {
    private MMSpinnerDatePicker kHG;
    private Button zMi;
    private Button zMj;
    private Button zMk;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107870);
        init(context);
        AppMethodBeat.m2505o(107870);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107871);
        init(context);
        AppMethodBeat.m2505o(107871);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(107872);
        View inflate = C5616v.m8409hu(context).inflate(2130970109, this);
        this.zMi = (Button) inflate.findViewById(2131822820);
        this.zMj = (Button) inflate.findViewById(2131822821);
        this.zMk = (Button) inflate.findViewById(2131822822);
        this.kHG = (MMSpinnerDatePicker) inflate.findViewById(2131825994);
        this.zMi.setOnClickListener(this);
        this.zMj.setOnClickListener(this);
        this.zMk.setOnClickListener(this);
        AppMethodBeat.m2505o(107872);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(107873);
        int id = view.getId();
        if (id == 2131822820) {
            this.kHG.setPickerMode(0);
            AppMethodBeat.m2505o(107873);
        } else if (id == 2131822821) {
            this.kHG.setPickerMode(1);
            AppMethodBeat.m2505o(107873);
        } else {
            this.kHG.setPickerMode(2);
            AppMethodBeat.m2505o(107873);
        }
    }
}
