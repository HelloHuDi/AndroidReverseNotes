package com.tencent.p177mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.ttpic.config.MediaConfig;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.h */
public final class C27202h {
    public static final String ilL = C1761b.eSn;

    /* renamed from: cE */
    public static String m43225cE(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(105635);
        File file = new File(ilL, "AudioRecord");
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder append = new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(C4995ag.m7428ck(String.valueOf(str2)));
        if (!TextUtils.isEmpty(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                str3 = MediaConfig.VIDEO_AAC_FILE_POSTFIX;
            } else if ("mp3".equalsIgnoreCase(str)) {
                str3 = ".mp3";
            } else if ("wav".equalsIgnoreCase(str)) {
                str3 = ".wav";
            }
            C4990ab.m7411d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", append.append(str3).toString(), new File(file, append.append(str3).toString()).getAbsoluteFile());
            str3 = r2.getAbsolutePath();
            AppMethodBeat.m2505o(105635);
            return str3;
        }
        str3 = "";
        C4990ab.m7411d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", append.append(str3).toString(), new File(file, append.append(str3).toString()).getAbsoluteFile());
        str3 = r2.getAbsolutePath();
        AppMethodBeat.m2505o(105635);
        return str3;
    }

    /* renamed from: Cy */
    public static String m43222Cy(String str) {
        AppMethodBeat.m2504i(105636);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(105636);
            return str2;
        } else if ("aac".equalsIgnoreCase(str)) {
            str2 = "m4a";
            AppMethodBeat.m2505o(105636);
            return str2;
        } else if ("mp3".equalsIgnoreCase(str)) {
            str2 = "mp3";
            AppMethodBeat.m2505o(105636);
            return str2;
        } else if ("wav".equalsIgnoreCase(str)) {
            str2 = "wav";
            AppMethodBeat.m2505o(105636);
            return str2;
        } else {
            str2 = "";
            AppMethodBeat.m2505o(105636);
            return str2;
        }
    }

    /* renamed from: Cz */
    public static boolean m43223Cz(String str) {
        AppMethodBeat.m2504i(105637);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(105637);
            return false;
        } else if ("aac".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105637);
            return true;
        } else if ("mp3".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105637);
            return true;
        } else if ("wav".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(105637);
            return false;
        } else {
            AppMethodBeat.m2505o(105637);
            return false;
        }
    }

    /* renamed from: CA */
    public static boolean m43220CA(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(105638);
        File file = new File(str);
        if (file.exists()) {
            C4990ab.m7416i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
            file.delete();
            try {
                z = file.createNewFile();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e, "prepareCacheFile", new Object[z]);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e2, "prepareCacheFile", new Object[z]);
            }
        } else {
            try {
                C4990ab.m7416i("MicroMsg.Record.AudioRecordUtil", "new audio file");
                z = file.createNewFile();
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e3, "prepareCacheFile", new Object[z]);
            } catch (Exception e22) {
                C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e22, "prepareCacheFile", new Object[z]);
            }
        }
        AppMethodBeat.m2505o(105638);
        return z;
    }

    /* renamed from: CB */
    public static long m43221CB(String str) {
        AppMethodBeat.m2504i(105639);
        File file = new File(str);
        long j = -1;
        if (file.exists()) {
            C4990ab.m7416i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
            j = file.length();
        } else {
            C4990ab.m7417i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", str);
        }
        AppMethodBeat.m2505o(105639);
        return j;
    }

    /* renamed from: D */
    public static short[] m43224D(byte[] bArr, int i) {
        short[] sArr = new short[(i / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
        }
        return sArr;
    }
}
