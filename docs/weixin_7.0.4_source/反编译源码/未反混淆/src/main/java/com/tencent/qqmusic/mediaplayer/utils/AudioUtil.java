package com.tencent.qqmusic.mediaplayer.utils;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioUtil {
    private static final int DEFAULT_DECODE_BUFFER_SIZE = 8192;
    private static final String TAG = "AudioUtil";

    public static int getDecodeBufferSize(NativeDecoder nativeDecoder) {
        AppMethodBeat.i(104695);
        AudioInformation audioInformation = nativeDecoder.getAudioInformation();
        int i = 0;
        if (audioInformation != null && audioInformation.getAudioType() == AudioType.FLAC) {
            i = (int) nativeDecoder.getMinBufferSize();
        }
        if (i <= 0) {
            i = 8192;
        }
        AppMethodBeat.o(104695);
        return i;
    }

    public static int getDecodeBufferSizeForPlay(NativeDecoder nativeDecoder) {
        int i = 12;
        int i2 = 2;
        AppMethodBeat.i(104696);
        int decodeBufferSize = getDecodeBufferSize(nativeDecoder);
        AudioInformation audioInformation = nativeDecoder.getAudioInformation();
        if (audioInformation == null || audioInformation.getAudioType() == AudioType.FLAC) {
            i = decodeBufferSize;
        } else {
            int channels = audioInformation.getChannels();
            if (channels == 1) {
                i = 4;
            } else if (channels != 2) {
                if (channels == 6) {
                    i = 252;
                } else if (channels == 8) {
                    i = 1020;
                }
            }
            if (audioInformation.getBitDept() == 1) {
                i2 = 3;
            }
            i = Math.max(AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), i, i2), decodeBufferSize);
        }
        AppMethodBeat.o(104696);
        return i;
    }

    public static NativeDecoder getDecoderFromTrack(String str, long j, long j2) {
        AppMethodBeat.i(104697);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(104697);
            return null;
        } else if (j >= j2) {
            AppMethodBeat.o(104697);
            return null;
        } else {
            NativeDecoder nativeDecoder = new NativeDecoder();
            TrackInfo trackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
            trackInfo.setFilePath(str);
            trackInfo.setStartPosition(j);
            trackInfo.setEndPostion(j2);
            try {
                IDataSource trackDataSource = new TrackDataSource(trackInfo);
                if (nativeDecoder.init(trackDataSource) != 0) {
                    Logger.e(TAG, "init decoder from track failed!");
                    AppMethodBeat.o(104697);
                    return null;
                }
                long seek = new NativeSeekTable(nativeDecoder).seek(j2);
                if (seek <= 0) {
                    Logger.e(TAG, "endPos from track <= 0");
                    AppMethodBeat.o(104697);
                    return null;
                }
                trackDataSource.setEndBytePosition(seek);
                nativeDecoder.seekTo((int) j);
                AppMethodBeat.o(104697);
                return nativeDecoder;
            } catch (Exception e) {
                Logger.e(TAG, e);
                AppMethodBeat.o(104697);
                return null;
            }
        }
    }

    public static NativeDecoder getDecoder(String str, boolean z, long j, long j2) {
        AppMethodBeat.i(104698);
        NativeDecoder decoderFormFile;
        if (z) {
            decoderFormFile = AudioRecognition.getDecoderFormFile(str);
            AppMethodBeat.o(104698);
            return decoderFormFile;
        }
        decoderFormFile = getDecoderFromTrack(str, j, j2);
        AppMethodBeat.o(104698);
        return decoderFormFile;
    }

    public static int getPlaybackHeadPositionSafely(AudioTrack audioTrack) {
        AppMethodBeat.i(104699);
        int i = 0;
        if (audioTrack != null) {
            try {
                i = audioTrack.getPlaybackHeadPosition();
            } catch (Exception e) {
                Logger.e(TAG, "getPlaybackHeadPositionSafely", e);
            }
        }
        AppMethodBeat.o(104699);
        return i;
    }
}
