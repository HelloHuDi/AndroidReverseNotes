package com.tencent.mm.plugin.music.model.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.a.a.a.b;
import com.tencent.mm.plugin.music.model.a.a.a.d;
import com.tencent.mm.plugin.music.model.a.a.a.e;
import com.tencent.mm.plugin.music.model.a.a.a.f;
import com.tencent.mm.plugin.music.model.a.a.a.h;
import com.tencent.mm.plugin.music.model.a.a.a.i;
import com.tencent.mm.plugin.music.model.a.a.a.j;
import com.tencent.mm.plugin.music.model.a.a.a.k;
import com.tencent.mm.plugin.music.model.a.a.a.l;
import com.tencent.mm.plugin.music.model.a.a.a.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class c implements com.tencent.mm.plugin.music.cache.c {
    public final boolean bTC() {
        AppMethodBeat.i(104933);
        ab.i("MicroMsg.PieceDataSourceService", "open_mix_audio:%d", Integer.valueOf(((a) g.K(a.class)).a(a.a.clicfg_open_mix_audio, 0)));
        if (((a) g.K(a.class)).a(a.a.clicfg_open_mix_audio, 0) == 1) {
            AppMethodBeat.o(104933);
            return true;
        }
        AppMethodBeat.o(104933);
        return false;
    }

    public final boolean bTz() {
        AppMethodBeat.i(104917);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", null, j.class);
        if (iPCBoolean == null) {
            AppMethodBeat.o(104917);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.o(104917);
        return z;
    }

    public final int bTA() {
        AppMethodBeat.i(104918);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a("com.tencent.mm", new IPCInteger(3), f.class);
        if (iPCInteger == null) {
            AppMethodBeat.o(104918);
            return 3;
        }
        int i = iPCInteger.value;
        AppMethodBeat.o(104918);
        return i;
    }

    public final String getAccPath() {
        AppMethodBeat.i(104919);
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", null, b.class);
        if (iPCString == null) {
            AppMethodBeat.o(104919);
            return null;
        }
        String str = iPCString.value;
        AppMethodBeat.o(104919);
        return str;
    }

    public final String SP(String str) {
        AppMethodBeat.i(104920);
        String SP = b.SP(str);
        AppMethodBeat.o(104920);
        return SP;
    }

    public final long bTB() {
        AppMethodBeat.i(104921);
        IPCLong iPCLong = (IPCLong) XIPCInvoker.a("com.tencent.mm", null, com.tencent.mm.plugin.music.model.a.a.a.c.class);
        if (iPCLong == null) {
            AppMethodBeat.o(104921);
            return 0;
        }
        long j = iPCLong.value;
        AppMethodBeat.o(104921);
        return j;
    }

    public final void jm(long j) {
        AppMethodBeat.i(104922);
        XIPCInvoker.a("com.tencent.mm", new IPCLong(j), h.class);
        AppMethodBeat.o(104922);
    }

    public final com.tencent.mm.aw.h SQ(String str) {
        AppMethodBeat.i(104923);
        IPCAudioParamResponse iPCAudioParamResponse = (IPCAudioParamResponse) XIPCInvoker.a("com.tencent.mm", new IPCString(str), e.class);
        if (iPCAudioParamResponse != null) {
            com.tencent.mm.aw.h hVar = new com.tencent.mm.aw.h();
            hVar.cFI = iPCAudioParamResponse.cFI;
            hVar.musicUrl = iPCAudioParamResponse.musicUrl;
            hVar.fileName = iPCAudioParamResponse.fileName;
            hVar.fKw = iPCAudioParamResponse.fKw;
            hVar.fKx = iPCAudioParamResponse.fKx;
            hVar.fKv = iPCAudioParamResponse.fKv;
            hVar.fKy = iPCAudioParamResponse.fKy;
            AppMethodBeat.o(104923);
            return hVar;
        }
        AppMethodBeat.o(104923);
        return null;
    }

    public final String SR(String str) {
        AppMethodBeat.i(104924);
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", new IPCString(str), l.class);
        String Tu;
        if (iPCString == null) {
            Tu = com.tencent.mm.plugin.music.h.b.Tu(str);
            AppMethodBeat.o(104924);
            return Tu;
        }
        Tu = iPCString.value;
        AppMethodBeat.o(104924);
        return Tu;
    }

    public final void SS(String str) {
        AppMethodBeat.i(104925);
        XIPCInvoker.a("com.tencent.mm", new IPCString(str), com.tencent.mm.plugin.music.model.a.a.a.a.class);
        AppMethodBeat.o(104925);
    }

    public final void y(String str, byte[] bArr) {
        AppMethodBeat.i(104926);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.cFI = str;
        iPCAudioParamRequest.fKv = bArr;
        XIPCInvoker.a("com.tencent.mm", iPCAudioParamRequest, k.class);
        AppMethodBeat.o(104926);
    }

    public final void cH(String str, int i) {
        AppMethodBeat.i(104927);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.cFI = str;
        iPCAudioParamRequest.oLm = i;
        XIPCInvoker.a("com.tencent.mm", iPCAudioParamRequest, m.class);
        AppMethodBeat.o(104927);
    }

    public final void fm(String str, String str2) {
        AppMethodBeat.i(104928);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.cFI = str;
        iPCAudioParamRequest.mimeType = str2;
        XIPCInvoker.a("com.tencent.mm", iPCAudioParamRequest, i.class);
        AppMethodBeat.o(104928);
    }

    public final String ST(String str) {
        AppMethodBeat.i(104929);
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", new IPCString(str), d.class);
        if (iPCString == null) {
            AppMethodBeat.o(104929);
            return null;
        }
        String str2 = iPCString.value;
        AppMethodBeat.o(104929);
        return str2;
    }

    public final com.tencent.mm.plugin.music.c.a SU(String str) {
        AppMethodBeat.i(104930);
        com.tencent.mm.plugin.music.model.e.a Tp = com.tencent.mm.plugin.music.model.e.bUk().Tp(com.tencent.mm.plugin.music.model.a.a.b.Tm(str));
        com.tencent.mm.plugin.music.c.a aVar = new com.tencent.mm.plugin.music.c.a();
        if (Tp != null) {
            aVar.oLp = Tp.field_wifiDownloadedLength;
            aVar.oLr = Tp.field_songWifiFileLength;
            aVar.oLq = Tp.field_wifiEndFlag;
            aVar.oLn = Tp.field_downloadedLength;
            aVar.oLo = Tp.field_songFileLength;
            aVar.endFlag = Tp.field_endFlag;
            aVar.mimeType = Tp.field_mimetype;
        }
        AppMethodBeat.o(104930);
        return aVar;
    }

    public final void a(String str, com.tencent.mm.plugin.music.c.a aVar) {
        AppMethodBeat.i(104931);
        String Tm = com.tencent.mm.plugin.music.model.a.a.b.Tm(str);
        com.tencent.mm.plugin.music.model.e.b bUk = com.tencent.mm.plugin.music.model.e.bUk();
        long j = aVar.oLp;
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        com.tencent.mm.plugin.music.model.e.a aVar2 = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar2 != null) {
            aVar2.field_wifiDownloadedLength = j;
        }
        bUk = com.tencent.mm.plugin.music.model.e.bUk();
        int i = aVar.oLq;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("wifiEndFlag", Integer.valueOf(i));
        int update2 = bUk.bSd.update("Music", contentValues2, "musicId=?", new String[]{Tm});
        ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", Integer.valueOf(update2), Tm, Integer.valueOf(i));
        aVar2 = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar2 != null) {
            aVar2.field_wifiEndFlag = i;
        }
        bUk = com.tencent.mm.plugin.music.model.e.bUk();
        j = aVar.oLr;
        contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        aVar2 = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar2 != null) {
            aVar2.field_songWifiFileLength = j;
        }
        bUk = com.tencent.mm.plugin.music.model.e.bUk();
        j = aVar.oLn;
        contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        aVar2 = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar2 != null) {
            aVar2.field_downloadedLength = j;
        }
        bUk = com.tencent.mm.plugin.music.model.e.bUk();
        i = aVar.endFlag;
        contentValues2 = new ContentValues();
        contentValues2.put("endFlag", Integer.valueOf(i));
        update2 = bUk.bSd.update("Music", contentValues2, "musicId=?", new String[]{Tm});
        ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", Integer.valueOf(update2), Tm, Integer.valueOf(i));
        aVar2 = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar2 != null) {
            aVar2.field_endFlag = i;
        }
        bUk = com.tencent.mm.plugin.music.model.e.bUk();
        j = aVar.oLo;
        contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        aVar2 = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar2 != null) {
            aVar2.field_songFileLength = j;
        }
        AppMethodBeat.o(104931);
    }

    public final void fn(String str, String str2) {
        AppMethodBeat.i(104932);
        String Tm = com.tencent.mm.plugin.music.model.a.a.b.Tm(str);
        com.tencent.mm.plugin.music.model.e.b bUk = com.tencent.mm.plugin.music.model.e.bUk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", str2);
        bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        com.tencent.mm.plugin.music.model.e.a aVar = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(Tm);
        if (aVar != null) {
            aVar.field_mimetype = str2;
        }
        AppMethodBeat.o(104932);
    }

    public final boolean bTD() {
        AppMethodBeat.i(104934);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", null, com.tencent.mm.plugin.music.model.a.a.a.g.class);
        if (iPCBoolean == null) {
            AppMethodBeat.o(104934);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.o(104934);
        return z;
    }
}
