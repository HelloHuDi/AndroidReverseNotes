package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecognizer {
    public abstract String getName();

    public abstract CharsetMatch match(CharsetDetector charsetDetector);

    CharsetRecognizer() {
    }

    public String getLanguage() {
        return null;
    }
}
