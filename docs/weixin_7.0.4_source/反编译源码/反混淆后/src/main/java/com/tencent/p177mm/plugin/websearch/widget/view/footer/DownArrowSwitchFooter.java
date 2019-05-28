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

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter */
public class DownArrowSwitchFooter extends LinearLayout implements C43862a {
    private Context context;
    private ImageView iPN;
    private C25814c udB;
    private TextView uei;
    private View uej;
    private C43861a uel;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter$1 */
    class C144441 implements OnClickListener {
        C144441() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91577);
            if (DownArrowSwitchFooter.this.uel != null) {
                DownArrowSwitchFooter.this.uel.cWf();
            }
            AppMethodBeat.m2505o(91577);
        }
    }

    public DownArrowSwitchFooter(Context context) {
        super(context);
        AppMethodBeat.m2504i(91578);
        C17927a c17927a = new C17927a();
        this.udB = c17927a.ahG();
        this.context = context;
        init();
        AppMethodBeat.m2505o(91578);
    }

    public DownArrowSwitchFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(91579);
        C17927a c17927a = new C17927a();
        this.udB = c17927a.ahG();
        this.context = context;
        init();
        AppMethodBeat.m2505o(91579);
    }

    private void init() {
        AppMethodBeat.m2504i(91580);
        ViewGroup viewGroup = (ViewGroup) C5616v.m8409hu(this.context).inflate(2130971239, this);
        this.uej = viewGroup.findViewById(2131829232);
        this.uei = (TextView) viewGroup.findViewById(2131829226);
        this.iPN = (ImageView) viewGroup.findViewById(2131829225);
        viewGroup.setOnClickListener(new C144441());
        AppMethodBeat.m2505o(91580);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(91581);
        this.uei.setText(str);
        AppMethodBeat.m2505o(91581);
    }

    public void setIcon(String str) {
        AppMethodBeat.m2504i(91582);
        if (TextUtils.isEmpty(str)) {
            this.iPN.setVisibility(8);
            AppMethodBeat.m2505o(91582);
            return;
        }
        this.iPN.setVisibility(0);
        C25815a.ahv().mo43766a(str, this.iPN, this.udB);
        AppMethodBeat.m2505o(91582);
    }

    public void setCallback(C43861a c43861a) {
        AppMethodBeat.m2504i(91583);
        this.uel = c43861a;
        if (c43861a != null) {
            if (c43861a.getItemCount() > 1) {
                this.uej.setVisibility(0);
                AppMethodBeat.m2505o(91583);
                return;
            }
            this.uej.setVisibility(8);
        }
        AppMethodBeat.m2505o(91583);
    }
}
