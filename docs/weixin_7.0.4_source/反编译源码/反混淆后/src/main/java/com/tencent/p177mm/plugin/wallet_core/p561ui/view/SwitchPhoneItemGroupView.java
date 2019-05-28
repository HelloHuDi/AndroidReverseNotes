package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView */
public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> tNt = new ArrayList();
    private C4455a tNu;
    private OnClickListener tNv = new C355141();

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView$a */
    public interface C4455a {
        /* renamed from: eo */
        void mo9499eo(View view);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView$1 */
    class C355141 implements OnClickListener {
        C355141() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47880);
            for (SwitchPhoneItemView switchPhoneItemView : SwitchPhoneItemGroupView.this.tNt) {
                switchPhoneItemView.tNz.setImageResource(C1318a.radio_off);
            }
            ((SwitchPhoneItemView) view).tNz.setImageResource(C1318a.radio_on);
            if (SwitchPhoneItemGroupView.this.tNu != null) {
                SwitchPhoneItemGroupView.this.tNu.mo9499eo(view);
            }
            AppMethodBeat.m2505o(47880);
        }
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47881);
        AppMethodBeat.m2505o(47881);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47882);
        AppMethodBeat.m2505o(47882);
    }

    public void setOnItemSelectListener(C4455a c4455a) {
        this.tNu = c4455a;
    }

    /* renamed from: a */
    public final void mo69499a(SwitchPhoneItemView switchPhoneItemView, int i) {
        AppMethodBeat.m2504i(47883);
        addView(switchPhoneItemView, i);
        this.tNt.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.tNv);
        AppMethodBeat.m2505o(47883);
    }
}
