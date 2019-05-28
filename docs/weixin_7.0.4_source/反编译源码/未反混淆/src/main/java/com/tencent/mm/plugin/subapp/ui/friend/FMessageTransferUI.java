package com.tencent.mm.plugin.subapp.ui.friend;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class FMessageTransferUI extends MMActivity {
    private int cfR;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25374);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        if (bo.isNullOrNil(stringExtra)) {
            finish();
        }
        d.akP().apt(stringExtra);
        d.akP().dte();
        String action = getIntent().getAction();
        String concat = "friend_message_accept_".concat(String.valueOf(stringExtra));
        this.cfR = 2130706432 | (BaseClientBuilder.API_PRIORITY_OTHER & stringExtra.hashCode());
        aw.getNotification().cancel(this.cfR);
        if (concat.equals(action)) {
            a.h(this.mController.ylL, stringExtra, true);
        }
        finish();
        AppMethodBeat.o(25374);
    }

    public final int getLayoutId() {
        return -1;
    }
}
