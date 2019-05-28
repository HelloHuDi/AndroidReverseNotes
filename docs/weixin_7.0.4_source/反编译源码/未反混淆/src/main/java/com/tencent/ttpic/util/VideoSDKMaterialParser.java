package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;

public class VideoSDKMaterialParser {
    private static final DecryptListener decryptListener = new DecryptListener() {
        public final byte[] decrypt(byte[] bArr) {
            AppMethodBeat.i(84221);
            byte[] drink = Coffee.drink(bArr, Coffee.getDefaultSign());
            AppMethodBeat.o(84221);
            return drink;
        }
    };

    static {
        AppMethodBeat.i(84223);
        AppMethodBeat.o(84223);
    }

    public static VideoMaterial parseVideoMaterial(String str, String str2) {
        AppMethodBeat.i(84222);
        VideoMaterial parseVideoMaterial = VideoTemplateParser.parseVideoMaterial(str, str2, true, decryptListener);
        AppMethodBeat.o(84222);
        return parseVideoMaterial;
    }
}
