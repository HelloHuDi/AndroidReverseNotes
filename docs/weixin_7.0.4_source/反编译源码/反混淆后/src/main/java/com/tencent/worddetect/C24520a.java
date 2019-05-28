package com.tencent.worddetect;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C40616m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.worddetect.WordDetectNative.ConfigParam;
import java.io.File;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.worddetect.a */
public class C24520a {
    private static WordDetectNative ALJ;

    /* renamed from: jw */
    private static ConfigParam m38148jw(Context context) {
        AppMethodBeat.m2504i(138529);
        try {
            File file = new File(C6457e.eSi.replace("/data/user/0", "/data/data") + "files/", "word_detect");
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            String str = absolutePath + "/net_fc.bin";
            String str2 = absolutePath + "/net_fc.param";
            SharedPreferences doB = C4996ah.doB();
            boolean z = doB.getBoolean("word_detect_mode_version_2", false);
            if (!z) {
                C1173e.deleteFile(str);
                C1173e.deleteFile(str2);
                doB.edit().putBoolean("word_detect_mode_version_2", true).apply();
            }
            if (!(z && C1173e.m2561ct(str))) {
                C40616m.copyAssets(context, "qbar/net_fc.bin", str);
                C40616m.copyAssets(context, "qbar/net_fc.param", str2);
            }
            ConfigParam configParam = new ConfigParam();
            configParam.detect_model_bin = str;
            configParam.detect_model_param = str2;
            AppMethodBeat.m2505o(138529);
            return configParam;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", e.getMessage());
            AppMethodBeat.m2505o(138529);
            return null;
        }
    }

    /* renamed from: ci */
    public static int m38147ci(Context context, String str) {
        AppMethodBeat.m2504i(138530);
        if (ALJ == null) {
            synchronized (C24520a.class) {
                try {
                    if (ALJ == null) {
                        WordDetectNative wordDetectNative = new WordDetectNative();
                        ALJ = wordDetectNative;
                        wordDetectNative.init(C24520a.m38148jw(context));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(138530);
                    }
                }
            }
        }
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
            AppMethodBeat.m2505o(138530);
            return 0;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Options amj = C5056d.amj(str);
            if (amj != null) {
                amj.inJustDecodeBounds = false;
                if (((long) ((amj.outWidth * amj.outHeight) * 8)) * 4 > 268435456) {
                    C4990ab.m7417i("MicroMsg.WordDetectModHelper", "initial width %d, initial height %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                    amj.inSampleSize = 4;
                }
            }
            Bitmap decodeFile = C5056d.decodeFile(str, amj);
            if (decodeFile == null) {
                C4990ab.m7412e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
                AppMethodBeat.m2505o(138530);
                return 0;
            }
            int i;
            ByteBuffer allocate = ByteBuffer.allocate(decodeFile.getByteCount());
            decodeFile.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            byte[] bArr = new byte[((array.length / 4) * 3)];
            for (i = 0; i < array.length / 4; i++) {
                bArr[i * 3] = array[(i * 4) + 2];
                bArr[(i * 3) + 1] = array[(i * 4) + 1];
                bArr[(i * 3) + 2] = array[i * 4];
            }
            C4990ab.m7417i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", Integer.valueOf(bArr.length), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()), Integer.valueOf(ALJ.scanImage(bArr, decodeFile.getWidth(), decodeFile.getHeight(), 3)));
            if (ALJ.scanImage(bArr, decodeFile.getWidth(), decodeFile.getHeight(), 3) != 0) {
                AppMethodBeat.m2505o(138530);
                return 0;
            }
            C4990ab.m7417i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", Integer.valueOf(ALJ.getResult()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(138530);
            return i;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", e.getMessage());
            AppMethodBeat.m2505o(138530);
            return 0;
        }
    }
}
