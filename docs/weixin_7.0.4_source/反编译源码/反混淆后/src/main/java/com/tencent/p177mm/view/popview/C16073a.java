package com.tencent.p177mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C1511f;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.view.popview.a */
public final class C16073a {
    /* renamed from: b */
    public static AbstractPopView m24392b(Context context, Object obj) {
        AppMethodBeat.m2504i(63068);
        if (obj instanceof C1511f) {
            SmileyPopView smileyPopView = new SmileyPopView(context);
            AppMethodBeat.m2505o(63068);
            return smileyPopView;
        }
        AbstractPopView emojiPopView = new EmojiPopView(context);
        AppMethodBeat.m2505o(63068);
        return emojiPopView;
    }

    /* renamed from: a */
    public static void m24391a(AbstractPopView abstractPopView, Object obj) {
        AppMethodBeat.m2504i(63069);
        if (abstractPopView instanceof EmojiPopView) {
            ((EmojiPopView) abstractPopView).setEmojiInfo((EmojiInfo) obj);
            AppMethodBeat.m2505o(63069);
            return;
        }
        if (abstractPopView instanceof SmileyPopView) {
            ((SmileyPopView) abstractPopView).setSmileyItem((C1511f) obj);
        }
        AppMethodBeat.m2505o(63069);
    }
}
