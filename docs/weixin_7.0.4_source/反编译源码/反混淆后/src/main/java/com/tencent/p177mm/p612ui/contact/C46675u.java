package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.u */
public final class C46675u extends LinearLayout {
    private Context context;
    private LinearLayout mpt = null;
    private List<String> zog;
    private C23926a zoh;
    private C30668b zoi;

    /* renamed from: com.tencent.mm.ui.contact.u$a */
    public interface C23926a {
    }

    /* renamed from: com.tencent.mm.ui.contact.u$b */
    public interface C30668b {
        /* renamed from: qB */
        void mo27987qB(boolean z);
    }

    public C46675u(Context context, C23926a c23926a) {
        super(context);
        AppMethodBeat.m2504i(33807);
        this.context = context;
        this.zoh = c23926a;
        reset();
        AppMethodBeat.m2505o(33807);
    }

    public final int getOpenIMCount() {
        AppMethodBeat.m2504i(33808);
        if (this.zog == null) {
            AppMethodBeat.m2505o(33808);
            return 0;
        }
        int size = this.zog.size();
        AppMethodBeat.m2505o(33808);
        return size;
    }

    public final void reset() {
        AppMethodBeat.m2504i(33809);
        C9638aw.m17190ZK();
        this.zog = C18628c.m29078XM().dsq();
        if (this.zog == null || this.zog.size() <= 0) {
            C4990ab.m7416i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
            AppMethodBeat.m2505o(33809);
            return;
        }
        C4990ab.m7417i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", Integer.valueOf(this.zog.size()));
        if (this.mpt == null) {
            View.inflate(getContext(), 2130970337, this);
            this.mpt = (LinearLayout) findViewById(2131821064);
        }
        this.mpt.removeAllViews();
        for (int i = 0; i < this.zog.size(); i++) {
            C40846v c40846v = new C40846v(getContext(), (String) this.zog.get(i));
            this.mpt.addView(c40846v);
            if (i == this.zog.size() - 1) {
                View findViewById = c40846v.findViewById(2131823612);
                int paddingLeft = findViewById.getPaddingLeft();
                findViewById.setBackgroundResource(C25738R.drawable.a_q);
                findViewById.setPadding(paddingLeft, 0, 0, 0);
            } else {
                c40846v.findViewById(2131823612).setBackground(null);
                c40846v.findViewById(2131823612).findViewById(2131826449).setBackgroundResource(C25738R.drawable.a_q);
            }
        }
        AppMethodBeat.m2505o(33809);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(33810);
        if (!(this.zoi == null || i == getVisibility())) {
            this.zoi.mo27987qB(i == 0);
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(33810);
    }

    public final void setOnVisibilityChangeListener(C30668b c30668b) {
        this.zoi = c30668b;
    }
}
