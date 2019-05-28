package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WmaRecognition implements IAudioRecognition {
    public static String TAG = "WmaRecognition";
    private final int HEARER_LENGTH = 16;
    private final byte[] WMA_HEADER = new byte[]{(byte) 48, (byte) 38, (byte) -78, (byte) 117, (byte) -114, (byte) 102, (byte) -49, (byte) 17, (byte) -90, (byte) -39, (byte) 0, (byte) -86, (byte) 0, (byte) 98, (byte) -50, (byte) 108};

    public WmaRecognition() {
        AppMethodBeat.m2504i(128584);
        AppMethodBeat.m2505o(128584);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043 A:{SYNTHETIC, Splitter:B:29:0x0043} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043 A:{SYNTHETIC, Splitter:B:29:0x0043} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A:{SYNTHETIC, Splitter:B:36:0x0052} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AudioType getAudioType(String str, byte[] bArr) {
        byte[] bArr2;
        Throwable e;
        int i;
        AudioType audioType;
        AppMethodBeat.m2504i(128585);
        if (bArr == null || bArr.length < 16) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    bArr2 = new byte[16];
                    try {
                        fileInputStream.read(bArr2);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            Logger.m71024e(TAG, e2);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        try {
                            Logger.m71024e(TAG, e2);
                            if (fileInputStream != null) {
                            }
                            i = 0;
                            while (i < 16) {
                            }
                            if (i == 16) {
                            }
                            audioType = AudioType.UNSUPPORT;
                            AppMethodBeat.m2505o(128585);
                            return audioType;
                        } catch (Throwable th) {
                            e2 = th;
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.m2505o(128585);
                            throw e2;
                        }
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    bArr2 = null;
                    Logger.m71024e(TAG, e2);
                    if (fileInputStream != null) {
                    }
                    i = 0;
                    while (i < 16) {
                    }
                    if (i == 16) {
                    }
                    audioType = AudioType.UNSUPPORT;
                    AppMethodBeat.m2505o(128585);
                    return audioType;
                }
            } catch (IOException e5) {
                e2 = e5;
                bArr2 = null;
                fileInputStream = null;
                Logger.m71024e(TAG, e2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        Logger.m71024e(TAG, e22);
                    }
                }
                i = 0;
                while (i < 16) {
                    i++;
                }
                if (i == 16) {
                }
                audioType = AudioType.UNSUPPORT;
                AppMethodBeat.m2505o(128585);
                return audioType;
            } catch (Throwable th2) {
                e22 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        Logger.m71024e(TAG, e6);
                    }
                }
                AppMethodBeat.m2505o(128585);
                throw e22;
            }
        }
        bArr2 = bArr;
        if (bArr2 != null && bArr2.length >= 16) {
            i = 0;
            while (i < 16 && bArr2[i] == this.WMA_HEADER[i]) {
                i++;
            }
            if (i == 16) {
                audioType = AudioType.WMA;
                AppMethodBeat.m2505o(128585);
                return audioType;
            }
        }
        audioType = AudioType.UNSUPPORT;
        AppMethodBeat.m2505o(128585);
        return audioType;
    }

    public AudioType guessAudioType(String str) {
        AppMethodBeat.m2504i(128586);
        AudioType audioType;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".wma")) {
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.m2505o(128586);
            return audioType;
        }
        audioType = AudioType.WMA;
        AppMethodBeat.m2505o(128586);
        return audioType;
    }
}
