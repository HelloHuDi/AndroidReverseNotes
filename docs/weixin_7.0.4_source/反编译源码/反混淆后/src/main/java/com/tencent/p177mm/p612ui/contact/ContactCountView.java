package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.contact.ContactCountView */
public class ContactCountView extends FrameLayout {
    private boolean aIB = true;
    private int count = 0;
    private View gbS;
    private TextView nBf;
    private int zlu = 1;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(33601);
        init();
        AppMethodBeat.m2505o(33601);
    }

    public ContactCountView(Context context) {
        super(context);
        AppMethodBeat.m2504i(33602);
        init();
        AppMethodBeat.m2505o(33602);
    }

    private void init() {
        AppMethodBeat.m2504i(33603);
        ContactCountView.inflate(getContext(), 2130969195, this);
        AppMethodBeat.m2505o(33603);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(33604);
        C4990ab.m7410d("MicroMsg.ContactCountView", "onMeasure");
        if (this.gbS == null) {
            this.gbS = (FrameLayout) findViewById(2131822964);
            this.nBf = (TextView) findViewById(2131822965);
        }
        dHF();
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(33604);
    }

    public void setContactType(int i) {
        this.zlu = i;
    }

    public final void dHF() {
        AppMethodBeat.m2504i(33605);
        String[] strArr = C1855t.fkY;
        if (this.zlu == 1) {
            C9638aw.m17190ZK();
            this.count = C18628c.m29078XM().mo15725b(strArr, C1853r.m3846Yz(), "weixin", "helper_entry", "filehelper");
        } else {
            C9638aw.m17190ZK();
            this.count = C18628c.m29078XM().mo15733c(strArr, C1853r.m3846Yz(), "weixin", "helper_entry", "filehelper");
        }
        C4990ab.m7411d("MicroMsg.ContactCountView", "contact count %d", Integer.valueOf(this.count));
        if (this.nBf != null) {
            if (this.zlu == 1) {
                this.nBf.setText(getContext().getResources().getQuantityString(C25738R.plurals.f9590b, this.count, new Object[]{Integer.valueOf(this.count)}));
            } else {
                this.nBf.setText(getContext().getResources().getQuantityString(C25738R.plurals.f9589a, this.count, new Object[]{Integer.valueOf(this.count)}));
            }
        }
        setVisible(this.aIB);
        AppMethodBeat.m2505o(33605);
    }

    public void setVisible(boolean z) {
        AppMethodBeat.m2504i(33606);
        this.aIB = z;
        if (this.gbS != null) {
            View view = this.gbS;
            int i = (!z || this.count <= 0) ? 8 : 0;
            view.setVisibility(i);
        }
        AppMethodBeat.m2505o(33606);
    }
}
