package com.tencent.p177mm.plugin.choosemsgfile.p358b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.C9236a;
import com.tencent.p177mm.choosemsgfile.compat.C9236a.C9237a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.ChooseMsgFileListUI;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.ChooseMsgFileShowUI;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.ChooseMsgFileUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a */
public final class C27638a implements C9236a {
    /* renamed from: h */
    public final void mo20658h(Context context, String str, String str2) {
        AppMethodBeat.m2504i(54250);
        ChooseMsgFileShowUI.m31265q(context, str, str2);
        AppMethodBeat.m2505o(54250);
    }

    /* renamed from: a */
    public final void mo20657a(MMActivity mMActivity, String str, String str2, int i, String str3, C9237a c9237a) {
        AppMethodBeat.m2504i(54251);
        if ("file".equals(str2)) {
            ChooseMsgFileListUI.m81467b(mMActivity, str, i, str3, c9237a);
            AppMethodBeat.m2505o(54251);
            return;
        }
        ChooseMsgFileUI.m65819a(mMActivity, str, str2, i, str3, c9237a);
        AppMethodBeat.m2505o(54251);
    }

    /* renamed from: a */
    public final void mo20656a(MMActivity mMActivity, String str, int i, String str2, final C9237a c9237a) {
        AppMethodBeat.m2504i(54252);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 11);
        intent.putExtra("Select_Conv_ui_title", mMActivity.mController.ylL.getString(C25738R.string.apr));
        intent.putExtra("KChooseMsgFileType", str);
        intent.putExtra("KChooseMsgFileCount", i);
        intent.putExtra("KChooseMsgFileExtension", str2);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8375cg);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
        C25985d.m41460a(mMActivity, ".ui.transmit.SelectConversationUI", intent, 291, new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(54249);
                C4990ab.m7417i("MicroMsg.ChooseMsgFileService", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                C4990ab.m7411d("MicroMsg.ChooseMsgFileService", "data:%s", intent);
                C42887b.m76157a(i, i2, intent, c9237a);
                AppMethodBeat.m2505o(54249);
            }
        });
        AppMethodBeat.m2505o(54252);
    }
}
