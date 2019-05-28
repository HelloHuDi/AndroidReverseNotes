package com.tencent.mm.plugin.choosemsgfile.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;

public final class a implements com.tencent.mm.choosemsgfile.compat.a {
    public final void h(Context context, String str, String str2) {
        AppMethodBeat.i(54250);
        ChooseMsgFileShowUI.q(context, str, str2);
        AppMethodBeat.o(54250);
    }

    public final void a(MMActivity mMActivity, String str, String str2, int i, String str3, com.tencent.mm.choosemsgfile.compat.a.a aVar) {
        AppMethodBeat.i(54251);
        if ("file".equals(str2)) {
            ChooseMsgFileListUI.b(mMActivity, str, i, str3, aVar);
            AppMethodBeat.o(54251);
            return;
        }
        ChooseMsgFileUI.a(mMActivity, str, str2, i, str3, aVar);
        AppMethodBeat.o(54251);
    }

    public final void a(MMActivity mMActivity, String str, int i, String str2, final com.tencent.mm.choosemsgfile.compat.a.a aVar) {
        AppMethodBeat.i(54252);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 11);
        intent.putExtra("Select_Conv_ui_title", mMActivity.mController.ylL.getString(R.string.apr));
        intent.putExtra("KChooseMsgFileType", str);
        intent.putExtra("KChooseMsgFileCount", i);
        intent.putExtra("KChooseMsgFileExtension", str2);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.cg);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
        d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, 291, new com.tencent.mm.ui.MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(54249);
                ab.i("MicroMsg.ChooseMsgFileService", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                ab.d("MicroMsg.ChooseMsgFileService", "data:%s", intent);
                b.a(i, i2, intent, aVar);
                AppMethodBeat.o(54249);
            }
        });
        AppMethodBeat.o(54252);
    }
}
