package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;

public class VideoSDKMaterialParser {
    private static final DecryptListener decryptListener = new C445661();

    /* renamed from: com.tencent.ttpic.util.VideoSDKMaterialParser$1 */
    static class C445661 implements DecryptListener {
        C445661() {
        }

        public final byte[] decrypt(byte[] bArr) {
            AppMethodBeat.m2504i(84221);
            byte[] drink = Coffee.drink(bArr, Coffee.getDefaultSign());
            AppMethodBeat.m2505o(84221);
            return drink;
        }
    }

    static {
        AppMethodBeat.m2504i(84223);
        AppMethodBeat.m2505o(84223);
    }

    public static VideoMaterial parseVideoMaterial(String str, String str2) {
        AppMethodBeat.m2504i(84222);
        VideoMaterial parseVideoMaterial = VideoTemplateParser.parseVideoMaterial(str, str2, true, decryptListener);
        AppMethodBeat.m2505o(84222);
        return parseVideoMaterial;
    }
}
