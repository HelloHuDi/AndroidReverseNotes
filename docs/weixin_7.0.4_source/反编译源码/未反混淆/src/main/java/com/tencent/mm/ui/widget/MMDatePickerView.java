package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class MMDatePickerView extends LinearLayout implements OnClickListener {
    private MMSpinnerDatePicker kHG;
    private Button zMi;
    private Button zMj;
    private Button zMk;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107870);
        init(context);
        AppMethodBeat.o(107870);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107871);
        init(context);
        AppMethodBeat.o(107871);
    }

    private void init(Context context) {
        AppMethodBeat.i(107872);
        View inflate = v.hu(context).inflate(R.layout.adm, this);
        this.zMi = (Button) inflate.findViewById(R.id.axi);
        this.zMj = (Button) inflate.findViewById(R.id.axj);
        this.zMk = (Button) inflate.findViewById(R.id.axk);
        this.kHG = (MMSpinnerDatePicker) inflate.findViewById(R.id.d9b);
        this.zMi.setOnClickListener(this);
        this.zMj.setOnClickListener(this);
        this.zMk.setOnClickListener(this);
        AppMethodBeat.o(107872);
    }

    public void onClick(View view) {
        AppMethodBeat.i(107873);
        int id = view.getId();
        if (id == R.id.axi) {
            this.kHG.setPickerMode(0);
            AppMethodBeat.o(107873);
        } else if (id == R.id.axj) {
            this.kHG.setPickerMode(1);
            AppMethodBeat.o(107873);
        } else {
            this.kHG.setPickerMode(2);
            AppMethodBeat.o(107873);
        }
    }
}
