package com.tencent.mm.plugin.music.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.c.db;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends db {
    public static com.tencent.mm.sdk.e.c.a ccO = db.Hm();
    public String fKs;
    public String playUrl;

    static {
        AppMethodBeat.i(105033);
        AppMethodBeat.o(105033);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final boolean bUu() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean bUv() {
        AppMethodBeat.i(105030);
        if (bo.isNullOrNil(this.field_songHAlbumUrl)) {
            AppMethodBeat.o(105030);
            return false;
        }
        AppMethodBeat.o(105030);
        return true;
    }

    public final boolean w(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean g(a aVar) {
        AppMethodBeat.i(105031);
        if (aVar == null) {
            AppMethodBeat.o(105031);
            return false;
        }
        boolean equals = this.field_musicId.equals(aVar.field_musicId);
        AppMethodBeat.o(105031);
        return equals;
    }

    public final e bUw() {
        AppMethodBeat.i(105032);
        e eVar = new e();
        eVar.fJU = this.field_originMusicId;
        eVar.fJS = this.field_musicType;
        eVar.fKh = this.field_appId;
        eVar.fJY = this.field_songAlbum;
        eVar.fKi = this.field_songAlbumType;
        eVar.fJZ = this.field_songAlbumUrl;
        eVar.fKa = this.field_songWifiUrl;
        eVar.fJW = this.field_songName;
        eVar.fJX = this.field_songSinger;
        eVar.fKb = this.field_songWapLinkUrl;
        eVar.fKc = this.field_songWebUrl;
        eVar.fKe = this.field_songAlbumLocalPath;
        eVar.fKk = this.field_songMediaId;
        eVar.fKm = this.field_songSnsAlbumUser;
        eVar.fKo = this.field_songSnsShareUser;
        eVar.fKq = this.field_hideBanner;
        eVar.fKr = this.field_jsWebUrlDomain;
        eVar.startTime = this.field_startTime;
        eVar.fKs = this.fKs;
        eVar.protocol = this.field_protocol;
        eVar.fKt = this.field_barBackToWebView;
        eVar.fKu = this.field_musicbar_url;
        eVar.playUrl = this.playUrl;
        AppMethodBeat.o(105032);
        return eVar;
    }
}
