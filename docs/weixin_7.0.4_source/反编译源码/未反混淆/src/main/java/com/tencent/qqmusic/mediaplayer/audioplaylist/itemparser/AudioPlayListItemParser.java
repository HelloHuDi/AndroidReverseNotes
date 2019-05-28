package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetMatch;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public abstract class AudioPlayListItemParser {
    public static final String TAG = "AudioListItemParser";
    protected CharsetDetector charsetDetector = new CharsetDetector();
    protected String mUri;

    public abstract boolean isParseSuccess();

    public abstract Iterator<TrackInfo> iterator();

    public abstract void parse();

    protected static String delSeprator(String str) {
        return str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b A:{SYNTHETIC, Splitter:B:17:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e A:{SYNTHETIC, Splitter:B:24:0x006e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String guessCharsetEncoding(InputStream inputStream) {
        Throwable e;
        Throwable th;
        String str = "unicode";
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                this.charsetDetector.setText((InputStream) bufferedInputStream);
                CharsetMatch detect = this.charsetDetector.detect();
                if (detect != null) {
                    int confidence = detect.getConfidence();
                    str = detect.getName();
                    Logger.i(TAG, "Audio list file encode: " + str + " ,confidence: " + confidence);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                    Logger.e(TAG, "guess encoding close fis ex", e2);
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Logger.e(TAG, "guess encoding ex", e2);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e22) {
                            Logger.e(TAG, "guess encoding close fis ex", e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e222) {
                            Logger.e(TAG, "guess encoding close fis ex", e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            bufferedInputStream = null;
            Logger.e(TAG, "guess encoding ex", e222);
            if (bufferedInputStream != null) {
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            throw th;
        }
        return str;
    }
}
