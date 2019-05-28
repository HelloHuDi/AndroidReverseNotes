package com.tencent.p177mm.plugin.music.p1362g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C45139e;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

/* renamed from: com.tencent.mm.plugin.music.g.a */
public final class C46100a implements IDataSource {
    public C45139e fqV;

    public C46100a(C45139e c45139e) {
        this.fqV = c45139e;
    }

    public final void open() {
        AppMethodBeat.m2504i(137669);
        Logger.m71025i("MicroMsg.Audio.InputStreamDataSource", "open");
        if (this.fqV != null) {
            this.fqV.open();
        }
        AppMethodBeat.m2505o(137669);
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(137670);
        if (this.fqV == null) {
            Logger.m71021e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
            AppMethodBeat.m2505o(137670);
            return -1;
        }
        int readAt = this.fqV.readAt(j, bArr, i, i2);
        AppMethodBeat.m2505o(137670);
        return readAt;
    }

    public final long getSize() {
        AppMethodBeat.m2504i(137671);
        if (this.fqV != null) {
            long size = this.fqV.getSize();
            AppMethodBeat.m2505o(137671);
            return size;
        }
        AppMethodBeat.m2505o(137671);
        return 0;
    }

    public final AudioType getAudioType() {
        AppMethodBeat.m2504i(137672);
        AudioType audioType;
        if (this.fqV == null) {
            Logger.m71021e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.m2505o(137672);
            return audioType;
        }
        Logger.m71025i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.fqV.acc());
        switch (this.fqV.acc()) {
            case 0:
                audioType = AudioType.UNSUPPORT;
                AppMethodBeat.m2505o(137672);
                return audioType;
            case 1:
                audioType = AudioType.AAC;
                AppMethodBeat.m2505o(137672);
                return audioType;
            case 2:
                audioType = AudioType.MP3;
                AppMethodBeat.m2505o(137672);
                return audioType;
            case 3:
                audioType = AudioType.WAV;
                AppMethodBeat.m2505o(137672);
                return audioType;
            case 4:
                audioType = AudioType.OGG;
                AppMethodBeat.m2505o(137672);
                return audioType;
            default:
                Logger.m71021e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
                audioType = AudioType.UNSUPPORT;
                AppMethodBeat.m2505o(137672);
                return audioType;
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(137673);
        Logger.m71025i("MicroMsg.Audio.InputStreamDataSource", "close");
        if (this.fqV != null) {
            this.fqV.close();
        }
        AppMethodBeat.m2505o(137673);
    }
}
