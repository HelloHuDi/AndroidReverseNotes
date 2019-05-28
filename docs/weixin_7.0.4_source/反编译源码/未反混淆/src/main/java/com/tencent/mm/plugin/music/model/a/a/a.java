package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {

    public static final class m implements com.tencent.mm.ipcinvoker.i<IPCAudioParamRequest, IPCVoid> {
        private m() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104960);
            IPCVoid a = a((IPCAudioParamRequest) obj);
            AppMethodBeat.o(104960);
            return a;
        }

        private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(104959);
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", iPCAudioParamRequest.cFI, Integer.valueOf(iPCAudioParamRequest.oLm));
                String str = iPCAudioParamRequest.cFI;
                int i = iPCAudioParamRequest.oLm;
                com.tencent.mm.plugin.music.model.e.d bUm = com.tencent.mm.plugin.music.model.e.bUm();
                ContentValues contentValues = new ContentValues();
                contentValues.put("fileCacheComplete", Integer.valueOf(i));
                if (i == 1) {
                    contentValues.put("removeDirtyBit", Integer.valueOf(1));
                }
                int update = bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
                ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", Integer.valueOf(update), str, Integer.valueOf(i));
                com.tencent.mm.plugin.music.model.e.c cVar = (com.tencent.mm.plugin.music.model.e.c) bUm.oNq.get(str);
                if (cVar != null) {
                    cVar.field_fileCacheComplete = i;
                    if (i == 1) {
                        cVar.field_removeDirtyBit = 1;
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updateMusicFileCacheComplete task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(104959);
            return iPCVoid;
        }
    }

    public static final class d implements com.tencent.mm.ipcinvoker.i<IPCString, IPCString> {
        private d() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104942);
            IPCString c = c((IPCString) obj);
            AppMethodBeat.o(104942);
            return c;
        }

        private static IPCString c(IPCString iPCString) {
            AppMethodBeat.i(104941);
            IPCString iPCString2;
            try {
                String str;
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getMusicMIMETypeByMusicId Task, musicId:%s", iPCString);
                com.tencent.mm.plugin.music.model.e.c Tq = com.tencent.mm.plugin.music.model.e.bUm().Tq(iPCString.value);
                if (Tq == null) {
                    ab.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "getMusicMIMETypeByMusicId pMusic is null!'");
                    str = null;
                } else {
                    ab.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "music field_pieceFileMIMEType:%s", Tq.field_pieceFileMIMEType);
                    if (TextUtils.isEmpty(Tq.field_pieceFileMIMEType)) {
                        ab.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "field_pieceFileMIMEType is null!'");
                        str = null;
                    } else {
                        str = Tq.field_pieceFileMIMEType;
                    }
                }
                iPCString2 = new IPCString(str);
                AppMethodBeat.o(104941);
                return iPCString2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getMusicMIMETypeByMusicId task", new Object[0]);
                iPCString2 = new IPCString("");
                AppMethodBeat.o(104941);
                return iPCString2;
            }
        }
    }

    public static final class e implements com.tencent.mm.ipcinvoker.i<IPCString, IPCAudioParamResponse> {
        private e() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104944);
            IPCAudioParamResponse d = d((IPCString) obj);
            AppMethodBeat.o(104944);
            return d;
        }

        private static IPCAudioParamResponse d(IPCString iPCString) {
            AppMethodBeat.i(104943);
            try {
                com.tencent.mm.aw.h hVar;
                ab.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", iPCString);
                com.tencent.mm.plugin.music.model.e.c Tq = com.tencent.mm.plugin.music.model.e.bUm().Tq(iPCString.value);
                if (Tq == null) {
                    ab.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
                    hVar = null;
                } else {
                    com.tencent.mm.aw.h hVar2 = new com.tencent.mm.aw.h();
                    hVar2.cFI = Tq.field_musicId;
                    hVar2.musicUrl = Tq.field_musicUrl;
                    hVar2.fileName = Tq.field_fileName;
                    hVar2.fKw = Tq.field_fileCacheComplete;
                    hVar2.fKx = Tq.field_pieceFileMIMEType;
                    hVar2.fKv = Tq.field_indexBitData;
                    hVar2.fKy = Tq.field_removeDirtyBit;
                    hVar = hVar2;
                }
                IPCAudioParamResponse iPCAudioParamResponse;
                if (hVar != null) {
                    iPCAudioParamResponse = new IPCAudioParamResponse(hVar);
                    AppMethodBeat.o(104943);
                    return iPCAudioParamResponse;
                }
                ab.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
                iPCAudioParamResponse = new IPCAudioParamResponse();
                AppMethodBeat.o(104943);
                return iPCAudioParamResponse;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getPieceMusicInfo task", new Object[0]);
            }
        }
    }

    public static final class f implements com.tencent.mm.ipcinvoker.i<IPCInteger, IPCInteger> {
        private f() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104946);
            IPCInteger b = b((IPCInteger) obj);
            AppMethodBeat.o(104946);
            return b;
        }

        private static IPCInteger b(IPCInteger iPCInteger) {
            AppMethodBeat.i(104945);
            IPCInteger iPCInteger2;
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
                iPCInteger2 = new IPCInteger(((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(iPCInteger.value))).intValue());
                AppMethodBeat.o(104945);
                return iPCInteger2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
                iPCInteger2 = new IPCInteger(iPCInteger.value);
                AppMethodBeat.o(104945);
                return iPCInteger2;
            }
        }
    }

    public static final class g implements com.tencent.mm.ipcinvoker.i<IPCVoid, IPCBoolean> {
        private g() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104948);
            IPCBoolean bUq = bUq();
            AppMethodBeat.o(104948);
            return bUq;
        }

        private static IPCBoolean bUq() {
            AppMethodBeat.i(104947);
            IPCBoolean iPCBoolean;
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc isSupportMixAudioByCP task");
                iPCBoolean = new IPCBoolean(((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_OPEN_MIX_AUDIO_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue());
                AppMethodBeat.o(104947);
                return iPCBoolean;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc isSupportMixAudioByCP task", new Object[0]);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(104947);
                return iPCBoolean;
            }
        }
    }

    public static final class a implements com.tencent.mm.ipcinvoker.i<IPCString, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104936);
            IPCVoid b = b((IPCString) obj);
            AppMethodBeat.o(104936);
            return b;
        }

        private static IPCVoid b(IPCString iPCString) {
            AppMethodBeat.i(104935);
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", iPCString);
                String str = iPCString.value;
                com.tencent.mm.plugin.music.model.e.d bUm = com.tencent.mm.plugin.music.model.e.bUm();
                int delete = bUm.bSd.delete("PieceMusicInfo", "musicId=?", new String[]{str});
                ab.i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", Integer.valueOf(delete), str);
                bUm.oNq.remove(str);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc deletePieceMusicInfo task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(104935);
            return iPCVoid;
        }
    }

    public static final class h implements com.tencent.mm.ipcinvoker.i<IPCLong, IPCVoid> {
        private h() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104950);
            IPCVoid a = a((IPCLong) obj);
            AppMethodBeat.o(104950);
            return a;
        }

        private static IPCVoid a(IPCLong iPCLong) {
            AppMethodBeat.i(104949);
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setLastScanMusicPieceFileTime task");
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(iPCLong.value));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc setLastScanMusicPieceFileTime task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(104949);
            return iPCVoid;
        }
    }

    public static final class b implements com.tencent.mm.ipcinvoker.i<IPCVoid, IPCString> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104938);
            IPCString aIf = aIf();
            AppMethodBeat.o(104938);
            return aIf;
        }

        private static IPCString aIf() {
            AppMethodBeat.i(104937);
            IPCString iPCString;
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getAccPath task");
                iPCString = new IPCString(com.tencent.mm.kernel.g.RP().eJM);
                AppMethodBeat.o(104937);
                return iPCString;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getAccPath task", new Object[0]);
                iPCString = new IPCString("");
                AppMethodBeat.o(104937);
                return iPCString;
            }
        }
    }

    public static final class c implements com.tencent.mm.ipcinvoker.i<IPCVoid, IPCLong> {
        private c() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104940);
            IPCLong bUp = bUp();
            AppMethodBeat.o(104940);
            return bUp;
        }

        private static IPCLong bUp() {
            AppMethodBeat.i(104939);
            IPCLong iPCLong;
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getLastScanMusicPieceFileTime task");
                iPCLong = new IPCLong(((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(0))).longValue());
                AppMethodBeat.o(104939);
                return iPCLong;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getLastScanMusicPieceFileTime task", new Object[0]);
                iPCLong = new IPCLong(0);
                AppMethodBeat.o(104939);
                return iPCLong;
            }
        }
    }

    public static final class i implements com.tencent.mm.ipcinvoker.i<IPCAudioParamRequest, IPCVoid> {
        private i() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104952);
            IPCVoid a = a((IPCAudioParamRequest) obj);
            AppMethodBeat.o(104952);
            return a;
        }

        private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(104951);
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", iPCAudioParamRequest.cFI, iPCAudioParamRequest.mimeType);
                String str = iPCAudioParamRequest.cFI;
                String str2 = iPCAudioParamRequest.mimeType;
                com.tencent.mm.plugin.music.model.e.c Tq = com.tencent.mm.plugin.music.model.e.bUm().Tq(str);
                if (Tq == null) {
                    ab.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "setMusicMIMETypeByMusicId pMusic is null!'");
                } else if (TextUtils.isEmpty(Tq.field_pieceFileMIMEType) || !Tq.field_pieceFileMIMEType.equals(str2)) {
                    ab.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "updatePieceFileMIMEType()");
                    com.tencent.mm.plugin.music.model.e.d bUm = com.tencent.mm.plugin.music.model.e.bUm();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("pieceFileMIMEType", str2);
                    int update = bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
                    ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", Integer.valueOf(update), str);
                    com.tencent.mm.plugin.music.model.e.c cVar = (com.tencent.mm.plugin.music.model.e.c) bUm.oNq.get(str);
                    if (cVar != null) {
                        cVar.field_pieceFileMIMEType = str2;
                    }
                } else {
                    ab.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "don't need update the piece file mime type");
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(104951);
            return iPCVoid;
        }
    }

    public static final class j implements com.tencent.mm.ipcinvoker.i<IPCVoid, IPCBoolean> {
        private j() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104954);
            IPCBoolean bUq = bUq();
            AppMethodBeat.o(104954);
            return bUq;
        }

        private static IPCBoolean bUq() {
            AppMethodBeat.i(104953);
            IPCBoolean iPCBoolean;
            try {
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc showAudioToast");
                iPCBoolean = new IPCBoolean(((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue());
                AppMethodBeat.o(104953);
                return iPCBoolean;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc showAudioToast task", new Object[0]);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(104953);
                return iPCBoolean;
            }
        }
    }

    public static final class k implements com.tencent.mm.ipcinvoker.i<IPCAudioParamRequest, IPCVoid> {
        private k() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104956);
            IPCVoid a = a((IPCAudioParamRequest) obj);
            AppMethodBeat.o(104956);
            return a;
        }

        private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
            boolean z = true;
            AppMethodBeat.i(104955);
            try {
                String str = "MicroMsg.Audio.MusicDataSourceCrossProcessImp";
                String str2 = "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b";
                Object[] objArr = new Object[2];
                objArr[0] = iPCAudioParamRequest.cFI;
                if (iPCAudioParamRequest.fKv == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                String str3 = iPCAudioParamRequest.cFI;
                byte[] bArr = iPCAudioParamRequest.fKv;
                com.tencent.mm.plugin.music.model.e.d bUm = com.tencent.mm.plugin.music.model.e.bUm();
                ContentValues contentValues = new ContentValues();
                contentValues.put("indexBitData", bArr);
                if (bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str3}) <= 0) {
                    ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", Integer.valueOf(bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str3})), str3);
                }
                com.tencent.mm.plugin.music.model.e.c cVar = (com.tencent.mm.plugin.music.model.e.c) bUm.oNq.get(str3);
                if (cVar != null) {
                    cVar.field_indexBitData = bArr;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updateMusicFileIndexBitCache task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(104955);
            return iPCVoid;
        }
    }

    public static final class l implements com.tencent.mm.ipcinvoker.i<IPCString, IPCString> {
        private l() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(104958);
            IPCString c = c((IPCString) obj);
            AppMethodBeat.o(104958);
            return c;
        }

        private static IPCString c(IPCString iPCString) {
            int i = 1;
            AppMethodBeat.i(104957);
            IPCString iPCString2;
            try {
                com.tencent.mm.plugin.music.model.e.c cVar;
                String str;
                ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", iPCString);
                String str2 = iPCString.value;
                com.tencent.mm.plugin.music.model.e.d bUm = com.tencent.mm.plugin.music.model.e.bUm();
                if (TextUtils.isEmpty(str2)) {
                    ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
                    cVar = null;
                } else {
                    String Tu = com.tencent.mm.plugin.music.h.b.Tu(str2);
                    cVar = bUm.Tq(Tu);
                    if (cVar == null) {
                        cVar = new com.tencent.mm.plugin.music.model.e.c();
                        i = 0;
                    }
                    cVar.field_musicId = Tu;
                    cVar.field_musicUrl = str2;
                    cVar.field_fileName = com.tencent.mm.plugin.music.h.b.Tv(str2);
                    ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", Tu, cVar.field_fileName);
                    if (i != 0) {
                        ab.i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
                        bUm.c(cVar, new String[0]);
                    } else {
                        ab.i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
                        bUm.b((com.tencent.mm.sdk.e.c) cVar);
                    }
                    bUm.oNq.put(Tu, cVar);
                }
                if (cVar != null) {
                    str = cVar.field_musicId;
                } else {
                    str = null;
                }
                iPCString2 = new IPCString(str);
                AppMethodBeat.o(104957);
                return iPCString2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updatePieceMusicInfo task", new Object[0]);
                iPCString2 = new IPCString("");
                AppMethodBeat.o(104957);
                return iPCString2;
            }
        }
    }
}
