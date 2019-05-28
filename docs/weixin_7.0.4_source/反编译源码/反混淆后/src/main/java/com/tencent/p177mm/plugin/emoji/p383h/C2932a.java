package com.tencent.p177mm.plugin.emoji.p383h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;

/* renamed from: com.tencent.mm.plugin.emoji.h.a */
public final class C2932a {
    public static boolean blE() {
        AppMethodBeat.m2504i(53863);
        boolean duy = C42952j.getEmojiStorageMgr().xYo.duy();
        AppMethodBeat.m2505o(53863);
        return duy;
    }

    /* renamed from: g */
    public static boolean m5218g(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(53864);
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(53864);
            return false;
        }
        boolean JW = C2932a.m5216JW(emotionSummary.ProductID);
        AppMethodBeat.m2505o(53864);
        return JW;
    }

    /* renamed from: b */
    public static boolean m5217b(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.m2504i(53865);
        if (emojiGroupInfo == null) {
            AppMethodBeat.m2505o(53865);
            return false;
        }
        boolean JW = C2932a.m5216JW(emojiGroupInfo.field_productID);
        AppMethodBeat.m2505o(53865);
        return JW;
    }

    /* renamed from: JW */
    public static boolean m5216JW(String str) {
        AppMethodBeat.m2504i(53866);
        if (str == null) {
            AppMethodBeat.m2505o(53866);
            return false;
        }
        boolean equals = str.equals(C2932a.bmu());
        AppMethodBeat.m2505o(53866);
        return equals;
    }

    public static final String bmu() {
        AppMethodBeat.m2504i(53867);
        String str = EmojiGroupInfo.yar;
        AppMethodBeat.m2505o(53867);
        return str;
    }
}
