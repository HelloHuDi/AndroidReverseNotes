package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.ttpic.config.MediaConfig;
import java.io.File;
import java.io.IOException;

public final class h {
    public static final String ilL = b.eSn;

    public static String cE(String str, String str2) {
        String str3;
        AppMethodBeat.i(105635);
        File file = new File(ilL, "AudioRecord");
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder append = new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(ag.ck(String.valueOf(str2)));
        if (!TextUtils.isEmpty(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                str3 = MediaConfig.VIDEO_AAC_FILE_POSTFIX;
            } else if ("mp3".equalsIgnoreCase(str)) {
                str3 = ".mp3";
            } else if ("wav".equalsIgnoreCase(str)) {
                str3 = ".wav";
            }
            ab.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", append.append(str3).toString(), new File(file, append.append(str3).toString()).getAbsoluteFile());
            str3 = r2.getAbsolutePath();
            AppMethodBeat.o(105635);
            return str3;
        }
        str3 = "";
        ab.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", append.append(str3).toString(), new File(file, append.append(str3).toString()).getAbsoluteFile());
        str3 = r2.getAbsolutePath();
        AppMethodBeat.o(105635);
        return str3;
    }

    public static String Cy(String str) {
        AppMethodBeat.i(105636);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(105636);
            return str2;
        } else if ("aac".equalsIgnoreCase(str)) {
            str2 = "m4a";
            AppMethodBeat.o(105636);
            return str2;
        } else if ("mp3".equalsIgnoreCase(str)) {
            str2 = "mp3";
            AppMethodBeat.o(105636);
            return str2;
        } else if ("wav".equalsIgnoreCase(str)) {
            str2 = "wav";
            AppMethodBeat.o(105636);
            return str2;
        } else {
            str2 = "";
            AppMethodBeat.o(105636);
            return str2;
        }
    }

    public static boolean Cz(String str) {
        AppMethodBeat.i(105637);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(105637);
            return false;
        } else if ("aac".equalsIgnoreCase(str)) {
            AppMethodBeat.o(105637);
            return true;
        } else if ("mp3".equalsIgnoreCase(str)) {
            AppMethodBeat.o(105637);
            return true;
        } else if ("wav".equalsIgnoreCase(str)) {
            AppMethodBeat.o(105637);
            return false;
        } else {
            AppMethodBeat.o(105637);
            return false;
        }
    }

    public static boolean CA(String str) {
        boolean z = false;
        AppMethodBeat.i(105638);
        File file = new File(str);
        if (file.exists()) {
            ab.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
            file.delete();
            try {
                z = file.createNewFile();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e, "prepareCacheFile", new Object[z]);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e2, "prepareCacheFile", new Object[z]);
            }
        } else {
            try {
                ab.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
                z = file.createNewFile();
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e3, "prepareCacheFile", new Object[z]);
            } catch (Exception e22) {
                ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e22, "prepareCacheFile", new Object[z]);
            }
        }
        AppMethodBeat.o(105638);
        return z;
    }

    public static long CB(String str) {
        AppMethodBeat.i(105639);
        File file = new File(str);
        long j = -1;
        if (file.exists()) {
            ab.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
            j = file.length();
        } else {
            ab.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", str);
        }
        AppMethodBeat.o(105639);
        return j;
    }

    public static short[] D(byte[] bArr, int i) {
        short[] sArr = new short[(i / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
        }
        return sArr;
    }
}
