package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d implements j {
    private Context context;

    public d(Context context) {
        this.context = context;
    }

    public final void A(EmojiInfo emojiInfo) {
        AppMethodBeat.i(22888);
        Toast.makeText(this.context, this.context.getString(R.string.cyu), 0).show();
        AppMethodBeat.o(22888);
    }

    public final void B(EmojiInfo emojiInfo) {
        AppMethodBeat.i(22889);
        Toast.makeText(this.context, this.context.getString(R.string.cyu), 0).show();
        AppMethodBeat.o(22889);
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
