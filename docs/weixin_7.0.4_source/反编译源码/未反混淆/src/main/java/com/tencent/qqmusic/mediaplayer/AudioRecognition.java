package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AudioRecognition {
    private static final int READ_FILE_HEADER_SIZE = 64;
    private static String TAG = "AudioRecognition";
    private static HashMap<String, AudioType> mGuessFormatResultCache = new HashMap();
    private static HashMap<String, AudioType> mRecognitionResultCache = new HashMap();

    static {
        AppMethodBeat.i(128376);
        AppMethodBeat.o(128376);
    }

    public static AudioType recognitionAudioFormatByExtensions(String str) {
        AppMethodBeat.i(128370);
        AudioType audioType;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(128370);
            return null;
        } else if (mRecognitionResultCache.containsKey(str)) {
            audioType = (AudioType) mRecognitionResultCache.get(str);
            Logger.w(TAG, "Get from cache " + audioType + ",filepath = " + str + ",retType = " + audioType);
            AppMethodBeat.o(128370);
            return audioType;
        } else {
            audioType = guessFormat(str);
            if (!AudioFormat.isAudioType(audioType)) {
                Logger.i(TAG, "recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly filepath = ".concat(String.valueOf(str)));
                try {
                    audioType = recognitionAudioFormatExactly(str);
                } catch (IOException e) {
                    Logger.e(TAG, e);
                }
            }
            Logger.i(TAG, "recognitionAudioFormatByExtensions filepath = " + str + ",guessAudioType = " + audioType);
            AppMethodBeat.o(128370);
            return audioType;
        }
    }

    public static AudioType guessFormat(String str) {
        AppMethodBeat.i(128371);
        AudioType guessAudioType;
        if (mGuessFormatResultCache == null || !mGuessFormatResultCache.containsKey(str)) {
            Iterator it = MediaCodecFactory.getSupportAudioType().iterator();
            while (it.hasNext()) {
                IAudioRecognition createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                if (createDecoderByType != null) {
                    guessAudioType = createDecoderByType.guessAudioType(str);
                    if (AudioFormat.isAudioType(guessAudioType)) {
                        mGuessFormatResultCache.put(str, guessAudioType);
                        AppMethodBeat.o(128371);
                        return guessAudioType;
                    }
                }
            }
            guessAudioType = AudioType.UNSUPPORT;
            AppMethodBeat.o(128371);
            return guessAudioType;
        }
        guessAudioType = (AudioType) mGuessFormatResultCache.get(str);
        AppMethodBeat.o(128371);
        return guessAudioType;
    }

    public static NativeDecoder getDecoderFormFile(String str) {
        AppMethodBeat.i(128372);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(128372);
            return null;
        }
        NativeDecoder nativeDecoder = new NativeDecoder();
        nativeDecoder.init(str, false);
        AppMethodBeat.o(128372);
        return nativeDecoder;
    }

    public static int getAudioBitDept(BaseDecoder baseDecoder, AudioInformation audioInformation) {
        int i = 0;
        AppMethodBeat.i(128373);
        int i2 = audioInformation.getAudioType() == AudioType.FLAC ? 1 : 0;
        if (i2 != 0) {
            try {
                i = (int) baseDecoder.getMinBufferSize();
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
        int minBufferSize = AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), audioInformation.getChannels(), 2);
        i2 = i2 == 0 ? minBufferSize % 2048 != 0 ? ((minBufferSize / 2048) + 1) * 2048 : minBufferSize : i;
        i = baseDecoder.decodeData(i2, new byte[i2]);
        if (i <= 0) {
            i2 *= 2;
        } else {
            i2 = i;
        }
        i2 = calcBitDept((long) i2, baseDecoder.getCurrentTime(), audioInformation.getChannels(), audioInformation.getSampleRate());
        AppMethodBeat.o(128373);
        return i2;
    }

    public static int calcBitDept(long j, long j2, int i, long j3) {
        AppMethodBeat.i(128374);
        if (0 == j2 || i == 0) {
            AppMethodBeat.o(128374);
            return 0;
        }
        double d = (double) ((1000.0f * ((float) j)) / ((float) ((((long) i) * j2) * j3)));
        int round = (int) Math.round(d);
        Logger.i(TAG, "byteNumbers = " + j + ",time = " + j2 + ",channels = " + i + ",sampleRate = " + j3 + ",bitDept = " + d);
        AppMethodBeat.o(128374);
        return round;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0189 A:{SYNTHETIC, Splitter:B:52:0x0189} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0189 A:{SYNTHETIC, Splitter:B:52:0x0189} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x019c A:{SYNTHETIC, Splitter:B:60:0x019c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static AudioType recognitionAudioFormatExactly(String str) {
        Throwable e;
        Iterator it;
        AudioType audioType;
        Throwable th;
        AppMethodBeat.i(128375);
        if (str == null) {
            AppMethodBeat.o(128375);
            return null;
        }
        mGuessFormatResultCache.remove(str);
        Logger.i(TAG, "recognitionAudioFormatExactly  path = ".concat(String.valueOf(str)));
        File file = new File(str);
        if (!file.exists()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("File not found :".concat(String.valueOf(str)));
            AppMethodBeat.o(128375);
            throw fileNotFoundException;
        } else if (file.canRead()) {
            byte[] bArr;
            Logger.i(TAG, "recognitionAudioFormatExactly file length = " + file.length());
            long currentTimeMillis = System.currentTimeMillis();
            AudioType guessFormat = guessFormat(str);
            ArrayList supportAudioType = MediaCodecFactory.getSupportAudioType();
            if (guessFormat != null && supportAudioType.contains(guessFormat)) {
                supportAudioType.remove(guessFormat);
                supportAudioType.add(0, guessFormat);
                if (AudioType.MP3.equals(guessFormat)) {
                    supportAudioType.remove(AudioType.FLAC);
                    supportAudioType.add(0, AudioType.FLAC);
                }
            }
            InputStream fileInputStream;
            byte[] bArr2;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    bArr = CacheBytesManager.getStatic(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    int read = fileInputStream.read(bArr);
                    if (read >= 64) {
                        bArr2 = new byte[64];
                        try {
                            System.arraycopy(bArr, 0, bArr2, 0, 64);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Logger.e(TAG, e);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        bArr = bArr2;
                                    } catch (Exception e3) {
                                        Logger.e(TAG, e3);
                                        bArr = bArr2;
                                    }
                                } else {
                                    bArr = bArr2;
                                }
                                it = supportAudioType.iterator();
                                while (it.hasNext()) {
                                }
                                audioType = null;
                                if (audioType != null) {
                                }
                                Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                                AppMethodBeat.o(128375);
                                return audioType;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                }
                                AppMethodBeat.o(128375);
                                throw th;
                            }
                        }
                    }
                    bArr2 = null;
                    CacheBytesManager.recycle(bArr);
                    Logger.i(TAG, "recognitionAudioFormatExactly header = " + new String(bArr, 0, read) + ",path = " + str);
                    try {
                        fileInputStream.close();
                        bArr = bArr2;
                    } catch (Exception e32) {
                        Logger.e(TAG, e32);
                        bArr = bArr2;
                    }
                } catch (Exception e4) {
                    e32 = e4;
                    bArr2 = null;
                    Logger.e(TAG, e32);
                    if (fileInputStream != null) {
                    }
                    it = supportAudioType.iterator();
                    while (it.hasNext()) {
                    }
                    audioType = null;
                    if (audioType != null) {
                    }
                    Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                    AppMethodBeat.o(128375);
                    return audioType;
                }
            } catch (Exception e5) {
                e32 = e5;
                bArr2 = null;
                fileInputStream = null;
                Logger.e(TAG, e32);
                if (fileInputStream != null) {
                }
                it = supportAudioType.iterator();
                while (it.hasNext()) {
                }
                audioType = null;
                if (audioType != null) {
                }
                Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                AppMethodBeat.o(128375);
                return audioType;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e322) {
                        Logger.e(TAG, e322);
                    }
                }
                AppMethodBeat.o(128375);
                throw th;
            }
            it = supportAudioType.iterator();
            while (it.hasNext()) {
                IAudioRecognition createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                if (createDecoderByType != null) {
                    try {
                        audioType = createDecoderByType.getAudioType(str, bArr);
                    } catch (SoNotFindException th4) {
                        Logger.e(TAG, "so not find!", th4);
                        audioType = AudioType.UNSUPPORT;
                    }
                    if (AudioFormat.isAudioType(audioType)) {
                        Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                        break;
                    }
                }
            }
            audioType = null;
            if (audioType != null) {
                audioType = AudioType.UNSUPPORT;
            } else {
                Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType + "].");
                mRecognitionResultCache.put(str, audioType);
                mGuessFormatResultCache.put(str, audioType);
            }
            Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
            AppMethodBeat.o(128375);
            return audioType;
        } else {
            IOException iOException = new IOException("Can not read file :".concat(String.valueOf(str)));
            AppMethodBeat.o(128375);
            throw iOException;
        }
    }
}
