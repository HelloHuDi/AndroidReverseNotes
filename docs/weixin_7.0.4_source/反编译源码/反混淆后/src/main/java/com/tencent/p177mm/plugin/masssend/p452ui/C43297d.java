package com.tencent.p177mm.plugin.masssend.p452ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23297j;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.plugin.masssend.ui.d */
public final class C43297d implements C23297j {
    private Context context;

    public C43297d(Context context) {
        this.context = context;
    }

    /* renamed from: A */
    public final void mo39016A(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(22888);
        Toast.makeText(this.context, this.context.getString(C25738R.string.cyu), 0).show();
        AppMethodBeat.m2505o(22888);
    }

    /* renamed from: B */
    public final void mo39017B(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(22889);
        Toast.makeText(this.context, this.context.getString(C25738R.string.cyu), 0).show();
        AppMethodBeat.m2505o(22889);
    }

    public final boolean bOe() {
        return false;
    }

    public final boolean bOf() {
        return false;
    }

    public final void bOg() {
    }
}
