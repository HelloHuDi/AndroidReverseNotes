package com.tencent.p177mm.plugin.music.model.p998a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCLong;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p198aw.C9060h;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.music.cache.C21343c;
import com.tencent.p177mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.p177mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.p1000e.C12680b;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C12674m;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C21346d;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C21347e;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C21348f;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34586g;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34588a;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34589h;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34590b;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34591c;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34592i;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34593j;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34594k;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C34587a.C34595l;
import com.tencent.p177mm.plugin.music.model.p998a.p999a.C39439b;
import com.tencent.p177mm.plugin.music.p1282c.C34577a;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.model.a.c */
public final class C43330c implements C21343c {
    public final boolean bTC() {
        AppMethodBeat.m2504i(104933);
        C4990ab.m7417i("MicroMsg.PieceDataSourceService", "open_mix_audio:%d", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_open_mix_audio, 0)));
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_open_mix_audio, 0) == 1) {
            AppMethodBeat.m2505o(104933);
            return true;
        }
        AppMethodBeat.m2505o(104933);
        return false;
    }

    public final boolean bTz() {
        AppMethodBeat.m2504i(104917);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", null, C34593j.class);
        if (iPCBoolean == null) {
            AppMethodBeat.m2505o(104917);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.m2505o(104917);
        return z;
    }

    public final int bTA() {
        AppMethodBeat.m2504i(104918);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.m83628a("com.tencent.mm", new IPCInteger(3), C21348f.class);
        if (iPCInteger == null) {
            AppMethodBeat.m2505o(104918);
            return 3;
        }
        int i = iPCInteger.value;
        AppMethodBeat.m2505o(104918);
        return i;
    }

    public final String getAccPath() {
        AppMethodBeat.m2504i(104919);
        IPCString iPCString = (IPCString) XIPCInvoker.m83628a("com.tencent.mm", null, C34590b.class);
        if (iPCString == null) {
            AppMethodBeat.m2505o(104919);
            return null;
        }
        String str = iPCString.value;
        AppMethodBeat.m2505o(104919);
        return str;
    }

    /* renamed from: SP */
    public final String mo36784SP(String str) {
        AppMethodBeat.m2504i(104920);
        String SP = C21349b.m32745SP(str);
        AppMethodBeat.m2505o(104920);
        return SP;
    }

    public final long bTB() {
        AppMethodBeat.m2504i(104921);
        IPCLong iPCLong = (IPCLong) XIPCInvoker.m83628a("com.tencent.mm", null, C34591c.class);
        if (iPCLong == null) {
            AppMethodBeat.m2505o(104921);
            return 0;
        }
        long j = iPCLong.value;
        AppMethodBeat.m2505o(104921);
        return j;
    }

    /* renamed from: jm */
    public final void mo36800jm(long j) {
        AppMethodBeat.m2504i(104922);
        XIPCInvoker.m83628a("com.tencent.mm", new IPCLong(j), C34589h.class);
        AppMethodBeat.m2505o(104922);
    }

    /* renamed from: SQ */
    public final C9060h mo36785SQ(String str) {
        AppMethodBeat.m2504i(104923);
        IPCAudioParamResponse iPCAudioParamResponse = (IPCAudioParamResponse) XIPCInvoker.m83628a("com.tencent.mm", new IPCString(str), C21347e.class);
        if (iPCAudioParamResponse != null) {
            C9060h c9060h = new C9060h();
            c9060h.cFI = iPCAudioParamResponse.cFI;
            c9060h.musicUrl = iPCAudioParamResponse.musicUrl;
            c9060h.fileName = iPCAudioParamResponse.fileName;
            c9060h.fKw = iPCAudioParamResponse.fKw;
            c9060h.fKx = iPCAudioParamResponse.fKx;
            c9060h.fKv = iPCAudioParamResponse.fKv;
            c9060h.fKy = iPCAudioParamResponse.fKy;
            AppMethodBeat.m2505o(104923);
            return c9060h;
        }
        AppMethodBeat.m2505o(104923);
        return null;
    }

    /* renamed from: SR */
    public final String mo36786SR(String str) {
        AppMethodBeat.m2504i(104924);
        IPCString iPCString = (IPCString) XIPCInvoker.m83628a("com.tencent.mm", new IPCString(str), C34595l.class);
        String Tu;
        if (iPCString == null) {
            Tu = C12673b.m20671Tu(str);
            AppMethodBeat.m2505o(104924);
            return Tu;
        }
        Tu = iPCString.value;
        AppMethodBeat.m2505o(104924);
        return Tu;
    }

    /* renamed from: SS */
    public final void mo36787SS(String str) {
        AppMethodBeat.m2504i(104925);
        XIPCInvoker.m83628a("com.tencent.mm", new IPCString(str), C34588a.class);
        AppMethodBeat.m2505o(104925);
    }

    /* renamed from: y */
    public final void mo36801y(String str, byte[] bArr) {
        AppMethodBeat.m2504i(104926);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.cFI = str;
        iPCAudioParamRequest.fKv = bArr;
        XIPCInvoker.m83628a("com.tencent.mm", iPCAudioParamRequest, C34594k.class);
        AppMethodBeat.m2505o(104926);
    }

    /* renamed from: cH */
    public final void mo36796cH(String str, int i) {
        AppMethodBeat.m2504i(104927);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.cFI = str;
        iPCAudioParamRequest.oLm = i;
        XIPCInvoker.m83628a("com.tencent.mm", iPCAudioParamRequest, C12674m.class);
        AppMethodBeat.m2505o(104927);
    }

    /* renamed from: fm */
    public final void mo36797fm(String str, String str2) {
        AppMethodBeat.m2504i(104928);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.cFI = str;
        iPCAudioParamRequest.mimeType = str2;
        XIPCInvoker.m83628a("com.tencent.mm", iPCAudioParamRequest, C34592i.class);
        AppMethodBeat.m2505o(104928);
    }

    /* renamed from: ST */
    public final String mo36788ST(String str) {
        AppMethodBeat.m2504i(104929);
        IPCString iPCString = (IPCString) XIPCInvoker.m83628a("com.tencent.mm", new IPCString(str), C21346d.class);
        if (iPCString == null) {
            AppMethodBeat.m2505o(104929);
            return null;
        }
        String str2 = iPCString.value;
        AppMethodBeat.m2505o(104929);
        return str2;
    }

    /* renamed from: SU */
    public final C34577a mo36789SU(String str) {
        AppMethodBeat.m2504i(104930);
        C28575a Tp = C39445e.bUk().mo24653Tp(C39439b.m67376Tm(str));
        C34577a c34577a = new C34577a();
        if (Tp != null) {
            c34577a.oLp = Tp.field_wifiDownloadedLength;
            c34577a.oLr = Tp.field_songWifiFileLength;
            c34577a.oLq = Tp.field_wifiEndFlag;
            c34577a.oLn = Tp.field_downloadedLength;
            c34577a.oLo = Tp.field_songFileLength;
            c34577a.endFlag = Tp.field_endFlag;
            c34577a.mimeType = Tp.field_mimetype;
        }
        AppMethodBeat.m2505o(104930);
        return c34577a;
    }

    /* renamed from: a */
    public final void mo36790a(String str, C34577a c34577a) {
        AppMethodBeat.m2504i(104931);
        String Tm = C39439b.m67376Tm(str);
        C12680b bUk = C39445e.bUk();
        long j = c34577a.oLp;
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        C28575a c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_wifiDownloadedLength = j;
        }
        bUk = C39445e.bUk();
        int i = c34577a.oLq;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("wifiEndFlag", Integer.valueOf(i));
        int update2 = bUk.bSd.update("Music", contentValues2, "musicId=?", new String[]{Tm});
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", Integer.valueOf(update2), Tm, Integer.valueOf(i));
        c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_wifiEndFlag = i;
        }
        bUk = C39445e.bUk();
        j = c34577a.oLr;
        contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_songWifiFileLength = j;
        }
        bUk = C39445e.bUk();
        j = c34577a.oLn;
        contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_downloadedLength = j;
        }
        bUk = C39445e.bUk();
        i = c34577a.endFlag;
        contentValues2 = new ContentValues();
        contentValues2.put("endFlag", Integer.valueOf(i));
        update2 = bUk.bSd.update("Music", contentValues2, "musicId=?", new String[]{Tm});
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", Integer.valueOf(update2), Tm, Integer.valueOf(i));
        c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_endFlag = i;
        }
        bUk = C39445e.bUk();
        j = c34577a.oLo;
        contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        update = bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", Integer.valueOf(update), Tm, Long.valueOf(j));
        c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_songFileLength = j;
        }
        AppMethodBeat.m2505o(104931);
    }

    /* renamed from: fn */
    public final void mo36798fn(String str, String str2) {
        AppMethodBeat.m2504i(104932);
        String Tm = C39439b.m67376Tm(str);
        C12680b bUk = C39445e.bUk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", str2);
        bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{Tm});
        C28575a c28575a = (C28575a) bUk.oNq.get(Tm);
        if (c28575a != null) {
            c28575a.field_mimetype = str2;
        }
        AppMethodBeat.m2505o(104932);
    }

    public final boolean bTD() {
        AppMethodBeat.m2504i(104934);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", null, C34586g.class);
        if (iPCBoolean == null) {
            AppMethodBeat.m2505o(104934);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.m2505o(104934);
        return z;
    }
}
