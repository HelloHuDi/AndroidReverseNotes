package com.tencent.mm.plugin.location.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI extends MMTextInputUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ao8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113483);
        super.onCreate(bundle);
        setMMTitle((int) R.string.cnk);
        String stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bo.isNullOrNil(stringExtra)) {
            findViewById(R.id.cpp).setVisibility(8);
            AppMethodBeat.o(113483);
            return;
        }
        ((TextView) findViewById(R.id.cpq)).setText(stringExtra);
        AppMethodBeat.o(113483);
    }

    public final void I(CharSequence charSequence) {
        AppMethodBeat.i(113484);
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            ab.i("MicroMsg.MMTextInputUI", "same remark[%s]", charSequence2);
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                cl clVar = new cl();
                clVar.cvA.type = -2;
                clVar.cvA.cvq = Long.toString(longExtra);
                clVar.cvA.desc = charSequence2;
                ab.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", clVar.cvA.cvq, clVar.cvA.desc);
                a.xxA.m(clVar);
            }
        }
        AppMethodBeat.o(113484);
    }
}
