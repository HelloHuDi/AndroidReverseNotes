package com.tencent.p177mm.plugin.websearch.widget.view.footer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.C43862a.C43861a;

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter */
public class DirectionSwitchFooter extends LinearLayout implements C43862a {
    private Context context;
    private ImageView iPN;
    private C25814c udB;
    private TextView uei;
    private C43861a uel;
    private View uen;
    private View ueo;
    private View uep;
    private View ueq;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter$1 */
    class C144431 implements OnClickListener {
        C144431() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91569);
            if (DirectionSwitchFooter.this.uel != null) {
                DirectionSwitchFooter.this.uel.cWh();
            }
            AppMethodBeat.m2505o(91569);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter$2 */
    class C227802 implements OnClickListener {
        C227802() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91570);
            if (DirectionSwitchFooter.this.uel != null) {
                DirectionSwitchFooter.this.uel.cWg();
            }
            AppMethodBeat.m2505o(91570);
        }
    }

    public DirectionSwitchFooter(Context context) {
        super(context);
        AppMethodBeat.m2504i(91571);
        C17927a c17927a = new C17927a();
        this.udB = c17927a.ahG();
        this.context = context;
        init();
        AppMethodBeat.m2505o(91571);
    }

    public DirectionSwitchFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(91572);
        C17927a c17927a = new C17927a();
        this.udB = c17927a.ahG();
        this.context = context;
        init();
        AppMethodBeat.m2505o(91572);
    }

    private void init() {
        AppMethodBeat.m2504i(91573);
        ViewGroup viewGroup = (ViewGroup) C5616v.m8409hu(this.context).inflate(2130971238, this);
        this.uei = (TextView) viewGroup.findViewById(2131829226);
        this.iPN = (ImageView) viewGroup.findViewById(2131829225);
        this.uen = viewGroup.findViewById(2131829230);
        this.ueo = viewGroup.findViewById(2131821517);
        this.uep = viewGroup.findViewById(2131829229);
        this.ueq = viewGroup.findViewById(2131829231);
        this.uep.setOnClickListener(new C144431());
        this.ueq.setOnClickListener(new C227802());
        AppMethodBeat.m2505o(91573);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(91574);
        this.uei.setText(str);
        AppMethodBeat.m2505o(91574);
    }

    public void setIcon(String str) {
        AppMethodBeat.m2504i(91575);
        if (TextUtils.isEmpty(str)) {
            this.iPN.setVisibility(8);
            AppMethodBeat.m2505o(91575);
            return;
        }
        this.iPN.setVisibility(0);
        C25815a.ahv().mo43766a(str, this.iPN, this.udB);
        AppMethodBeat.m2505o(91575);
    }

    public void setCallback(C43861a c43861a) {
        AppMethodBeat.m2504i(91576);
        this.uel = c43861a;
        if (c43861a != null) {
            if (c43861a.getItemCount() == 1) {
                this.uep.setVisibility(8);
                this.ueq.setVisibility(8);
            }
            if (this.uel != null) {
                if (this.uel.hasNext()) {
                    this.ueo.setEnabled(true);
                    this.ueq.setEnabled(true);
                } else {
                    this.ueq.setEnabled(false);
                    this.ueo.setEnabled(false);
                }
                if (this.uel.hasPrevious()) {
                    this.uep.setEnabled(true);
                    this.uen.setEnabled(true);
                } else {
                    this.uen.setEnabled(false);
                    this.uep.setEnabled(false);
                    AppMethodBeat.m2505o(91576);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(91576);
    }
}
