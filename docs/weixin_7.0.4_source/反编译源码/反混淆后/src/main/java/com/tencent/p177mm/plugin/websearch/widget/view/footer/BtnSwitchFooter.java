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

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter */
public class BtnSwitchFooter extends LinearLayout implements C43862a {
    private Context context;
    private ImageView iPN;
    private C25814c udB;
    private TextView uei;
    private View uej;
    private View uek;
    private C43861a uel;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter$1 */
    class C45351 implements OnClickListener {
        C45351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91560);
            if (BtnSwitchFooter.this.uel != null) {
                BtnSwitchFooter.this.uel.cWf();
            }
            AppMethodBeat.m2505o(91560);
        }
    }

    public BtnSwitchFooter(Context context) {
        super(context);
        AppMethodBeat.m2504i(91561);
        C17927a c17927a = new C17927a();
        this.udB = c17927a.ahG();
        this.context = context;
        init();
        AppMethodBeat.m2505o(91561);
    }

    public BtnSwitchFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(91562);
        C17927a c17927a = new C17927a();
        this.udB = c17927a.ahG();
        this.context = context;
        init();
        AppMethodBeat.m2505o(91562);
    }

    private void init() {
        AppMethodBeat.m2504i(91563);
        ViewGroup viewGroup = (ViewGroup) C5616v.m8409hu(this.context).inflate(2130971237, this);
        this.uek = viewGroup.findViewById(2131829227);
        this.uej = viewGroup.findViewById(2131829228);
        this.uei = (TextView) viewGroup.findViewById(2131829226);
        this.iPN = (ImageView) viewGroup.findViewById(2131829225);
        this.uek.setVisibility(8);
        this.uej.setOnClickListener(new C45351());
        AppMethodBeat.m2505o(91563);
    }

    public void setSwitchClickLsn(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(91564);
        this.uej.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(91564);
    }

    public void setSwitchVisible(int i) {
        AppMethodBeat.m2504i(91565);
        this.uej.setVisibility(i);
        AppMethodBeat.m2505o(91565);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(91566);
        this.uei.setText(str);
        AppMethodBeat.m2505o(91566);
    }

    public void setIcon(String str) {
        AppMethodBeat.m2504i(91567);
        if (TextUtils.isEmpty(str)) {
            this.iPN.setVisibility(8);
            AppMethodBeat.m2505o(91567);
            return;
        }
        this.iPN.setVisibility(0);
        C25815a.ahv().mo43766a(str, this.iPN, this.udB);
        AppMethodBeat.m2505o(91567);
    }

    public void setCallback(C43861a c43861a) {
        AppMethodBeat.m2504i(91568);
        this.uel = c43861a;
        if (c43861a != null) {
            if (c43861a.getItemCount() > 1) {
                this.uej.setVisibility(0);
                AppMethodBeat.m2505o(91568);
                return;
            }
            this.uej.setVisibility(8);
        }
        AppMethodBeat.m2505o(91568);
    }
}
