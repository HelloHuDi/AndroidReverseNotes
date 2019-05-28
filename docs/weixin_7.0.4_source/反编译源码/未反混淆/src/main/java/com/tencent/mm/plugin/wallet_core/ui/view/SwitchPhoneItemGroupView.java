package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> tNt = new ArrayList();
    private a tNu;
    private OnClickListener tNv = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(47880);
            for (SwitchPhoneItemView switchPhoneItemView : SwitchPhoneItemGroupView.this.tNt) {
                switchPhoneItemView.tNz.setImageResource(R.raw.radio_off);
            }
            ((SwitchPhoneItemView) view).tNz.setImageResource(R.raw.radio_on);
            if (SwitchPhoneItemGroupView.this.tNu != null) {
                SwitchPhoneItemGroupView.this.tNu.eo(view);
            }
            AppMethodBeat.o(47880);
        }
    };

    public interface a {
        void eo(View view);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47881);
        AppMethodBeat.o(47881);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47882);
        AppMethodBeat.o(47882);
    }

    public void setOnItemSelectListener(a aVar) {
        this.tNu = aVar;
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i) {
        AppMethodBeat.i(47883);
        addView(switchPhoneItemView, i);
        this.tNt.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.tNv);
        AppMethodBeat.o(47883);
    }
}
