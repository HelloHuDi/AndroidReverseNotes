package com.tencent.p177mm.plugin.subapp.p537ui.friend;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageTransferUI */
public class FMessageTransferUI extends MMActivity {
    private int cfR;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25374);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        if (C5046bo.isNullOrNil(stringExtra)) {
            finish();
        }
        C41789d.akP().apt(stringExtra);
        C41789d.akP().dte();
        String action = getIntent().getAction();
        String concat = "friend_message_accept_".concat(String.valueOf(stringExtra));
        this.cfR = 2130706432 | (BaseClientBuilder.API_PRIORITY_OTHER & stringExtra.hashCode());
        C9638aw.getNotification().cancel(this.cfR);
        if (concat.equals(action)) {
            C39940a.m68403h(this.mController.ylL, stringExtra, true);
        }
        finish();
        AppMethodBeat.m2505o(25374);
    }

    public final int getLayoutId() {
        return -1;
    }
}
