package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.music.model.a;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends j<a> {
    public e bSd;
    public f<String, a> oNq = new c(20);
    public f<String, a> oNr = new c(10);

    public b(e eVar) {
        super(eVar, a.ccO, "Music", null);
        AppMethodBeat.i(105034);
        this.bSd = eVar;
        AppMethodBeat.o(105034);
    }

    public final a Tp(String str) {
        AppMethodBeat.i(105035);
        a aVar;
        if (this.oNq.get(str) != null) {
            aVar = (a) this.oNq.get(str);
            AppMethodBeat.o(105035);
            return aVar;
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor a = this.bSd.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(105035);
            return null;
        }
        aVar = new a();
        aVar.d(a);
        a.close();
        this.oNq.put(str, aVar);
        AppMethodBeat.o(105035);
        return aVar;
    }

    public final a b(a aVar, boolean z) {
        AppMethodBeat.i(105036);
        a aVar2;
        if (this.oNr.get(aVar.field_musicId) != null) {
            aVar2 = (a) this.oNr.get(aVar.field_musicId);
            AppMethodBeat.o(105036);
            return aVar2;
        }
        aVar2 = c(aVar, z);
        AppMethodBeat.o(105036);
        return aVar2;
    }

    public final a c(a aVar, boolean z) {
        AppMethodBeat.i(105037);
        a a = a.a(aVar.field_songLyric, ah.getContext().getString(R.string.d43), aVar.field_songSnsShareUser, d.a(aVar), aVar.field_songSinger, z);
        this.oNr.put(aVar.field_musicId, a);
        AppMethodBeat.o(105037);
        return a;
    }

    public final a ac(String str, int i, int i2) {
        AppMethodBeat.i(105038);
        ab.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        a Tp = Tp(str);
        if (Tp == null) {
            ab.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", str);
            AppMethodBeat.o(105038);
            return null;
        }
        Tp.field_songBgColor = i;
        Tp.field_songLyricColor = i2;
        c(Tp, "songBgColor", "songLyricColor");
        this.oNq.put(str, Tp);
        AppMethodBeat.o(105038);
        return Tp;
    }

    public final a x(com.tencent.mm.aw.e eVar) {
        int i;
        AppMethodBeat.i(105039);
        String K = com.tencent.mm.plugin.music.h.b.K(eVar);
        a Tp = Tp(K);
        if (Tp == null) {
            Tp = new a();
            i = 0;
        } else {
            i = 1;
        }
        Tp.field_musicId = K;
        Tp.field_originMusicId = eVar.fJU;
        Tp.field_musicType = eVar.fJS;
        Tp.field_appId = eVar.fKh;
        if (bo.isNullOrNil(Tp.field_appId)) {
            Tp.field_appId = d.v(eVar);
        }
        Tp.field_songAlbum = eVar.fJY;
        Tp.field_songAlbumType = eVar.fKi;
        Tp.field_songWifiUrl = eVar.fKa;
        Tp.field_songName = eVar.fJW;
        Tp.field_songSinger = eVar.fJX;
        Tp.field_songWapLinkUrl = eVar.fKb;
        Tp.field_songWebUrl = eVar.fKc;
        Tp.field_songAlbumLocalPath = eVar.fKe;
        Tp.field_songMediaId = eVar.fKk;
        Tp.field_songSnsAlbumUser = eVar.fKm;
        Tp.field_songAlbumUrl = eVar.fJZ;
        Tp.field_songSnsShareUser = eVar.fKo;
        if (!bo.isNullOrNil(eVar.fKl)) {
            Tp.field_songHAlbumUrl = eVar.fKl;
        }
        Tp.field_updateTime = System.currentTimeMillis();
        if (Tp.field_songId == 0) {
            com.tencent.mm.plugin.music.h.e.O(eVar);
            Tp.field_songId = eVar.fKj;
        }
        if ((bo.isNullOrNil(Tp.field_songWapLinkUrl) || Tp.field_songWapLinkUrl.equals(Tp.field_songWebUrl)) && !bo.isNullOrNil(Tp.field_songWifiUrl)) {
            Tp.field_songWapLinkUrl = Tp.field_songWifiUrl;
        }
        if (Tp.field_songId == 0 && eVar.fJS == 4) {
            try {
                Tp.field_songId = Integer.valueOf(eVar.fJU).intValue();
            } catch (Exception e) {
            }
        }
        Tp.field_hideBanner = eVar.fKq;
        Tp.field_jsWebUrlDomain = eVar.fKr;
        Tp.field_startTime = eVar.startTime;
        Tp.fKs = eVar.fKs;
        Tp.field_protocol = eVar.protocol;
        Tp.field_barBackToWebView = eVar.fKt;
        Tp.field_musicbar_url = eVar.fKu;
        if (i != 0) {
            ab.i("MicroMsg.Music.MusicStorage", "update music %s", K);
            c(Tp, new String[0]);
        } else {
            ab.i("MicroMsg.Music.MusicStorage", "insert music %s", K);
            b((com.tencent.mm.sdk.e.c) Tp);
        }
        this.oNq.put(K, Tp);
        AppMethodBeat.o(105039);
        return Tp;
    }
}
