package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioPlayListItemParserFactory {
    public static AudioPlayListItemParser createParser(String str) {
        AppMethodBeat.i(104771);
        if (str.startsWith("http") || !str.endsWith(".cue")) {
            AppMethodBeat.o(104771);
            return null;
        }
        CueItemParser cueItemParser = new CueItemParser(str);
        AppMethodBeat.o(104771);
        return cueItemParser;
    }
}
