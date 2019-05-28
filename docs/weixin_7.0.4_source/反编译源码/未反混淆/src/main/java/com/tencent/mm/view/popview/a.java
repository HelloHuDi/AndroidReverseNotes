package com.tencent.mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class a {
    public static AbstractPopView b(Context context, Object obj) {
        AppMethodBeat.i(63068);
        if (obj instanceof f) {
            SmileyPopView smileyPopView = new SmileyPopView(context);
            AppMethodBeat.o(63068);
            return smileyPopView;
        }
        AbstractPopView emojiPopView = new EmojiPopView(context);
        AppMethodBeat.o(63068);
        return emojiPopView;
    }

    public static void a(AbstractPopView abstractPopView, Object obj) {
        AppMethodBeat.i(63069);
        if (abstractPopView instanceof EmojiPopView) {
            ((EmojiPopView) abstractPopView).setEmojiInfo((EmojiInfo) obj);
            AppMethodBeat.o(63069);
            return;
        }
        if (abstractPopView instanceof SmileyPopView) {
            ((SmileyPopView) abstractPopView).setSmileyItem((f) obj);
        }
        AppMethodBeat.o(63069);
    }
}
