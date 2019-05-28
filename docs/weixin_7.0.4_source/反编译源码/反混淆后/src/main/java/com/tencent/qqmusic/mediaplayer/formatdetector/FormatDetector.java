package com.tencent.qqmusic.mediaplayer.formatdetector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class FormatDetector {
    private static final String TAG = "FormatDetector";
    private static final FormatDetector mInstance = new FormatDetector();
    public static boolean sIsLoadSuccess;

    private native int getFormat(String str, boolean z);

    private native int getFormatFromDataSource(IDataSource iDataSource, boolean z);

    static {
        AppMethodBeat.m2504i(128401);
        sIsLoadSuccess = false;
        sIsLoadSuccess = NativeLibs.loadAll(NativeLibs.audioCommon, NativeLibs.formatDetector);
        AppMethodBeat.m2505o(128401);
    }

    public static AudioType getAudioFormat(String str) {
        AppMethodBeat.m2504i(128395);
        AudioType audioFormat = getAudioFormat(str, true);
        AppMethodBeat.m2505o(128395);
        return audioFormat;
    }

    public static AudioType getAudioFormat(String str, boolean z) {
        AppMethodBeat.m2504i(128396);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("filePath can't be null!");
            AppMethodBeat.m2505o(128396);
            throw illegalArgumentException;
        }
        AudioType audioType;
        try {
            audioType = AudioFormat.getAudioType(mInstance.getFormat(str, z));
        } catch (UnsatisfiedLinkError e) {
            Logger.m71024e(TAG, e);
            audioType = AudioRecognition.guessFormat(str);
        }
        AppMethodBeat.m2505o(128396);
        return audioType;
    }

    public static AudioType getAudioFormat(IDataSource iDataSource, boolean z) {
        AppMethodBeat.m2504i(128397);
        if (iDataSource == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataSource can't be null!");
            AppMethodBeat.m2505o(128397);
            throw illegalArgumentException;
        }
        AudioType audioType = AudioType.UNSUPPORT;
        try {
            audioType = AudioFormat.getAudioType(mInstance.getFormatFromDataSource(iDataSource, z));
        } catch (UnsatisfiedLinkError e) {
            Logger.m71024e(TAG, e);
        }
        AppMethodBeat.m2505o(128397);
        return audioType;
    }

    public static AudioType getAudioTypeFromExtension(String str) {
        AppMethodBeat.m2504i(128398);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(128398);
            return null;
        }
        for (AudioType audioType : AudioType.values()) {
            if (audioType.getExtension().equalsIgnoreCase(str)) {
                AppMethodBeat.m2505o(128398);
                return audioType;
            }
        }
        AudioType audioType2 = AudioType.UNSUPPORT;
        AppMethodBeat.m2505o(128398);
        return audioType2;
    }

    /* JADX WARNING: Missing block: B:6:0x001d, code skipped:
            if (com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static AudioType getAudioType(String str) {
        AppMethodBeat.m2504i(128399);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(128399);
            return null;
        }
        AudioType audioFormat;
        if (sIsLoadSuccess) {
            audioFormat = getAudioFormat(str);
        }
        audioFormat = null;
        if (!AudioFormat.isAudioType(audioFormat)) {
            audioFormat = getAudioTypeFromExtension(str.substring(str.lastIndexOf(46) + 1).toLowerCase());
        }
        AppMethodBeat.m2505o(128399);
        return audioFormat;
    }

    /* JADX WARNING: Missing block: B:7:0x0023, code skipped:
            if (com.tencent.qqmusic.mediaplayer.AudioFormat.isAudioType(r0) != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static AudioType getAudioType(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128400);
        if (iDataSource == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataSource can't be null!");
            AppMethodBeat.m2505o(128400);
            throw illegalArgumentException;
        }
        AudioType audioFormat;
        AudioType audioType = AudioType.UNSUPPORT;
        if (sIsLoadSuccess) {
            audioFormat = getAudioFormat(iDataSource, false);
        }
        audioFormat = audioType;
        AppMethodBeat.m2505o(128400);
        return audioFormat;
    }
}
