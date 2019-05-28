package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.InputStream;

public class FLACRecognition implements IAudioRecognition {
    public static final String TAG = "FLACRecognition";

    public AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.m2504i(128581);
        AudioType audioType;
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith("flaC")) {
            audioType = AudioType.FLAC;
            AppMethodBeat.m2505o(128581);
            return audioType;
        } else if (checkFormatBySoftDecoder(str)) {
            audioType = AudioType.FLAC;
            AppMethodBeat.m2505o(128581);
            return audioType;
        } else {
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.m2505o(128581);
            return audioType;
        }
    }

    private boolean checkFormatBySoftDecoder(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(128582);
        NativeDecoder nativeDecoder = new NativeDecoder();
        try {
            if (nativeDecoder.init(str, false) == 0) {
                AudioInformation audioInformation = nativeDecoder.getAudioInformation();
                if (audioInformation != null && audioInformation.getAudioType() == AudioType.FLAC) {
                    z = true;
                }
                try {
                    nativeDecoder.release();
                } catch (Throwable th) {
                    Logger.m71024e(TAG, th);
                }
                AppMethodBeat.m2505o(128582);
                return z;
            }
            try {
                nativeDecoder.release();
            } catch (Throwable th2) {
                Logger.m71024e(TAG, th2);
            }
            AppMethodBeat.m2505o(128582);
            return z;
        } catch (Throwable th22) {
            Logger.m71024e(TAG, th22);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005e A:{SYNTHETIC, Splitter:B:29:0x005e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AudioType guessAudioType(String str) {
        AudioType audioType;
        Throwable e;
        AppMethodBeat.m2504i(128583);
        if (!TextUtils.isEmpty(str)) {
            if (str.toLowerCase().contains(".flac")) {
                audioType = AudioType.FLAC;
                AppMethodBeat.m2505o(128583);
                return audioType;
            }
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[64];
                    fileInputStream.read(bArr);
                    audioType = getAudioType(str, bArr);
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        Logger.m71024e(TAG, e2);
                    }
                    AppMethodBeat.m2505o(128583);
                    return audioType;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                try {
                    Logger.m71024e(TAG, e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            Logger.m71024e(TAG, e5);
                        }
                    }
                    audioType = AudioType.UNSUPPORT;
                    AppMethodBeat.m2505o(128583);
                    return audioType;
                } catch (Throwable th) {
                    e5 = th;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(128583);
                    throw e5;
                }
            } catch (Throwable th2) {
                e5 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e22) {
                        Logger.m71024e(TAG, e22);
                    }
                }
                AppMethodBeat.m2505o(128583);
                throw e5;
            }
        }
        audioType = AudioType.UNSUPPORT;
        AppMethodBeat.m2505o(128583);
        return audioType;
    }
}
