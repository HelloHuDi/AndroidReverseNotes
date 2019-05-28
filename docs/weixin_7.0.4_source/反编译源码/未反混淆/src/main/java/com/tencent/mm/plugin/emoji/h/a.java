package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    public static boolean blE() {
        AppMethodBeat.i(53863);
        boolean duy = j.getEmojiStorageMgr().xYo.duy();
        AppMethodBeat.o(53863);
        return duy;
    }

    public static boolean g(EmotionSummary emotionSummary) {
        AppMethodBeat.i(53864);
        if (emotionSummary == null) {
            AppMethodBeat.o(53864);
            return false;
        }
        boolean JW = JW(emotionSummary.ProductID);
        AppMethodBeat.o(53864);
        return JW;
    }

    public static boolean b(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(53865);
        if (emojiGroupInfo == null) {
            AppMethodBeat.o(53865);
            return false;
        }
        boolean JW = JW(emojiGroupInfo.field_productID);
        AppMethodBeat.o(53865);
        return JW;
    }

    public static boolean JW(String str) {
        AppMethodBeat.i(53866);
        if (str == null) {
            AppMethodBeat.o(53866);
            return false;
        }
        boolean equals = str.equals(bmu());
        AppMethodBeat.o(53866);
        return equals;
    }

    public static final String bmu() {
        AppMethodBeat.i(53867);
        String str = EmojiGroupInfo.yar;
        AppMethodBeat.o(53867);
        return str;
    }
}
