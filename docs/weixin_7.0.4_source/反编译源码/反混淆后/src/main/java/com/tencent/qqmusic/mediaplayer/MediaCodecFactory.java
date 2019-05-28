package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Recognition;
import com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class MediaCodecFactory {
    private static final String TAG = "MediaCodecFactory";
    private static HashMap<AudioType, Class<? extends IAudioRecognition>> mDecoderMap = new HashMap();
    private static ArrayList<AudioType> mSupportAudioType = new ArrayList();

    static {
        AppMethodBeat.m2504i(128466);
        registerDecoder(AudioType.M4A, FfmpegRecognition.class);
        registerDecoder(AudioType.OGG, VorbisRecognition.class);
        registerDecoder(AudioType.FLAC, FLACRecognition.class);
        registerDecoder(AudioType.MP3, MP3Recognition.class);
        registerDecoder(AudioType.APE, ApeRecognition.class);
        registerDecoder(AudioType.WAV, WavRecognition.class);
        registerDecoder(AudioType.WMA, WmaRecognition.class);
        registerDecoder(AudioType.MP4, FfmpegRecognition.class);
        registerDecoder(AudioType.AAC, FfmpegRecognition.class);
        AppMethodBeat.m2505o(128466);
    }

    private static void registerDecoder(AudioType audioType, Class<? extends IAudioRecognition> cls) {
        AppMethodBeat.m2504i(128462);
        mDecoderMap.put(audioType, cls);
        mSupportAudioType.add(audioType);
        AppMethodBeat.m2505o(128462);
    }

    public static void unRegisterDecoder(AudioType audioType) {
        AppMethodBeat.m2504i(128463);
        mSupportAudioType.remove(audioType);
        mDecoderMap.remove(audioType);
        AppMethodBeat.m2505o(128463);
    }

    static IAudioRecognition createDecoderByType(AudioType audioType) {
        AppMethodBeat.m2504i(128464);
        if (AudioFormat.isAudioType(audioType)) {
            IAudioRecognition iAudioRecognition;
            if (mDecoderMap.containsKey(audioType)) {
                try {
                    iAudioRecognition = (IAudioRecognition) ((Class) mDecoderMap.get(audioType)).newInstance();
                } catch (Throwable th) {
                    Logger.m71022e(TAG, "createDecoderByType error", th);
                }
                AppMethodBeat.m2505o(128464);
                return iAudioRecognition;
            }
            iAudioRecognition = null;
            AppMethodBeat.m2505o(128464);
            return iAudioRecognition;
        }
        AppMethodBeat.m2505o(128464);
        return null;
    }

    public static ArrayList<AudioType> getSupportAudioType() {
        AppMethodBeat.m2504i(128465);
        ArrayList arrayList = new ArrayList(mSupportAudioType);
        AppMethodBeat.m2505o(128465);
        return arrayList;
    }
}
