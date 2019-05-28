package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.InputStream;

public class FfmpegRecognition implements IAudioRecognition {
    private static final String SO_AUDIO_COMMON = "audio_common";
    private static final String SO_BASE_NAME = "FFmpeg";
    private static final String SO_NAME = "ffmpeg_decoder";
    private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
    private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
    private static final String TAG = "FfmpegRecognition";

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045 A:{SYNTHETIC, Splitter:B:23:0x0045} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A:{SYNTHETIC, Splitter:B:30:0x0055} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AudioType getAudioType(String str, byte[] bArr) {
        Throwable e;
        AudioType audioType;
        String str2 = null;
        AppMethodBeat.m2504i(128579);
        if (bArr == null || bArr.length == 0) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr2 = new byte[64];
                    fileInputStream.read(bArr2);
                    String str3 = new String(bArr2);
                    try {
                        fileInputStream.close();
                        str2 = str3;
                    } catch (Exception e2) {
                        Logger.m71024e(TAG, e2);
                        str2 = str3;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Logger.m71024e(TAG, e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                Logger.m71024e(TAG, e4);
                            }
                        }
                        if (str2 == null) {
                        }
                        audioType = AudioType.UNSUPPORT;
                        AppMethodBeat.m2505o(128579);
                        return audioType;
                    } catch (Throwable th) {
                        e4 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e22) {
                                Logger.m71024e(TAG, e22);
                            }
                        }
                        AppMethodBeat.m2505o(128579);
                        throw e4;
                    }
                }
            } catch (Exception e5) {
                e4 = e5;
                fileInputStream = null;
                Logger.m71024e(TAG, e4);
                if (fileInputStream != null) {
                }
                if (str2 == null) {
                }
                audioType = AudioType.UNSUPPORT;
                AppMethodBeat.m2505o(128579);
                return audioType;
            } catch (Throwable th2) {
                e4 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(128579);
                throw e4;
            }
        }
        str2 = new String(bArr);
        if (str2 == null && str2.contains("ftyp")) {
            audioType = AudioType.M4A;
            AppMethodBeat.m2505o(128579);
            return audioType;
        }
        audioType = AudioType.UNSUPPORT;
        AppMethodBeat.m2505o(128579);
        return audioType;
    }

    public AudioType guessAudioType(String str) {
        AppMethodBeat.m2504i(128580);
        AudioType audioType = getAudioType(str, null);
        AppMethodBeat.m2505o(128580);
        return audioType;
    }
}
