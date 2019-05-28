package com.tencent.p177mm.plugin.location.p446ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.tools.MMTextInputUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.location.ui.RemarkUI */
public class RemarkUI extends MMTextInputUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970502;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(113483);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.cnk);
        String stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (C5046bo.isNullOrNil(stringExtra)) {
            findViewById(2131825268).setVisibility(8);
            AppMethodBeat.m2505o(113483);
            return;
        }
        ((TextView) findViewById(2131825269)).setText(stringExtra);
        AppMethodBeat.m2505o(113483);
    }

    /* renamed from: I */
    public final void mo23730I(CharSequence charSequence) {
        AppMethodBeat.m2504i(113484);
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            C4990ab.m7417i("MicroMsg.MMTextInputUI", "same remark[%s]", charSequence2);
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                C45316cl c45316cl = new C45316cl();
                c45316cl.cvA.type = -2;
                c45316cl.cvA.cvq = Long.toString(longExtra);
                c45316cl.cvA.desc = charSequence2;
                C4990ab.m7411d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", c45316cl.cvA.cvq, c45316cl.cvA.desc);
                C4879a.xxA.mo10055m(c45316cl);
            }
        }
        AppMethodBeat.m2505o(113484);
    }
}
