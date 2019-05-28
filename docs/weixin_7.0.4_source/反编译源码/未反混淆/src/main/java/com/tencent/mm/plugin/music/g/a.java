package com.tencent.mm.plugin.music.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class a implements IDataSource {
    public e fqV;

    public a(e eVar) {
        this.fqV = eVar;
    }

    public final void open() {
        AppMethodBeat.i(137669);
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
        if (this.fqV != null) {
            this.fqV.open();
        }
        AppMethodBeat.o(137669);
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(137670);
        if (this.fqV == null) {
            Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
            AppMethodBeat.o(137670);
            return -1;
        }
        int readAt = this.fqV.readAt(j, bArr, i, i2);
        AppMethodBeat.o(137670);
        return readAt;
    }

    public final long getSize() {
        AppMethodBeat.i(137671);
        if (this.fqV != null) {
            long size = this.fqV.getSize();
            AppMethodBeat.o(137671);
            return size;
        }
        AppMethodBeat.o(137671);
        return 0;
    }

    public final AudioType getAudioType() {
        AppMethodBeat.i(137672);
        AudioType audioType;
        if (this.fqV == null) {
            Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.o(137672);
            return audioType;
        }
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.fqV.acc());
        switch (this.fqV.acc()) {
            case 0:
                audioType = AudioType.UNSUPPORT;
                AppMethodBeat.o(137672);
                return audioType;
            case 1:
                audioType = AudioType.AAC;
                AppMethodBeat.o(137672);
                return audioType;
            case 2:
                audioType = AudioType.MP3;
                AppMethodBeat.o(137672);
                return audioType;
            case 3:
                audioType = AudioType.WAV;
                AppMethodBeat.o(137672);
                return audioType;
            case 4:
                audioType = AudioType.OGG;
                AppMethodBeat.o(137672);
                return audioType;
            default:
                Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
                audioType = AudioType.UNSUPPORT;
                AppMethodBeat.o(137672);
                return audioType;
        }
    }

    public final void close() {
        AppMethodBeat.i(137673);
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
        if (this.fqV != null) {
            this.fqV.close();
        }
        AppMethodBeat.o(137673);
    }
}
