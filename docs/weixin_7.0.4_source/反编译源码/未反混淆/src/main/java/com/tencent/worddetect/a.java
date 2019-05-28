package com.tencent.worddetect;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.worddetect.WordDetectNative.ConfigParam;
import java.io.File;
import java.nio.ByteBuffer;

public class a {
    private static WordDetectNative ALJ;

    private static ConfigParam jw(Context context) {
        AppMethodBeat.i(138529);
        try {
            File file = new File(e.eSi.replace("/data/user/0", "/data/data") + "files/", "word_detect");
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            String str = absolutePath + "/net_fc.bin";
            String str2 = absolutePath + "/net_fc.param";
            SharedPreferences doB = ah.doB();
            boolean z = doB.getBoolean("word_detect_mode_version_2", false);
            if (!z) {
                com.tencent.mm.a.e.deleteFile(str);
                com.tencent.mm.a.e.deleteFile(str2);
                doB.edit().putBoolean("word_detect_mode_version_2", true).apply();
            }
            if (!(z && com.tencent.mm.a.e.ct(str))) {
                m.copyAssets(context, "qbar/net_fc.bin", str);
                m.copyAssets(context, "qbar/net_fc.param", str2);
            }
            ConfigParam configParam = new ConfigParam();
            configParam.detect_model_bin = str;
            configParam.detect_model_param = str2;
            AppMethodBeat.o(138529);
            return configParam;
        } catch (Exception e) {
            ab.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", e.getMessage());
            AppMethodBeat.o(138529);
            return null;
        }
    }

    public static int ci(Context context, String str) {
        AppMethodBeat.i(138530);
        if (ALJ == null) {
            synchronized (a.class) {
                try {
                    if (ALJ == null) {
                        WordDetectNative wordDetectNative = new WordDetectNative();
                        ALJ = wordDetectNative;
                        wordDetectNative.init(jw(context));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(138530);
                    }
                }
            }
        }
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
            AppMethodBeat.o(138530);
            return 0;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Options amj = d.amj(str);
            if (amj != null) {
                amj.inJustDecodeBounds = false;
                if (((long) ((amj.outWidth * amj.outHeight) * 8)) * 4 > 268435456) {
                    ab.i("MicroMsg.WordDetectModHelper", "initial width %d, initial height %d", Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                    amj.inSampleSize = 4;
                }
            }
            Bitmap decodeFile = d.decodeFile(str, amj);
            if (decodeFile == null) {
                ab.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
                AppMethodBeat.o(138530);
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
            ab.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", Integer.valueOf(bArr.length), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()), Integer.valueOf(ALJ.scanImage(bArr, decodeFile.getWidth(), decodeFile.getHeight(), 3)));
            if (ALJ.scanImage(bArr, decodeFile.getWidth(), decodeFile.getHeight(), 3) != 0) {
                AppMethodBeat.o(138530);
                return 0;
            }
            ab.i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", Integer.valueOf(ALJ.getResult()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(138530);
            return i;
        } catch (Exception e) {
            ab.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", e.getMessage());
            AppMethodBeat.o(138530);
            return 0;
        }
    }
}
