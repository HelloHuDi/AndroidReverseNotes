package com.tencent.p177mm.plugin.music.model.p998a.p999a;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCLong;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p198aw.C9060h;
import com.tencent.p177mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.p177mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.p1000e.C28576c;
import com.tencent.p177mm.plugin.music.model.p1000e.C34596d;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.music.model.a.a.a */
public final class C34587a {

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$m */
    public static final class C12674m implements C45413i<IPCAudioParamRequest, IPCVoid> {
        private C12674m() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104960);
            IPCVoid a = C12674m.m20676a((IPCAudioParamRequest) obj);
            AppMethodBeat.m2505o(104960);
            return a;
        }

        /* renamed from: a */
        private static IPCVoid m20676a(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.m2504i(104959);
            try {
                C4990ab.m7417i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", iPCAudioParamRequest.cFI, Integer.valueOf(iPCAudioParamRequest.oLm));
                String str = iPCAudioParamRequest.cFI;
                int i = iPCAudioParamRequest.oLm;
                C34596d bUm = C39445e.bUm();
                ContentValues contentValues = new ContentValues();
                contentValues.put("fileCacheComplete", Integer.valueOf(i));
                if (i == 1) {
                    contentValues.put("removeDirtyBit", Integer.valueOf(1));
                }
                int update = bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
                C4990ab.m7417i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", Integer.valueOf(update), str, Integer.valueOf(i));
                C28576c c28576c = (C28576c) bUm.oNq.get(str);
                if (c28576c != null) {
                    c28576c.field_fileCacheComplete = i;
                    if (i == 1) {
                        c28576c.field_removeDirtyBit = 1;
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updateMusicFileCacheComplete task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.m2505o(104959);
            return iPCVoid;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$d */
    public static final class C21346d implements C45413i<IPCString, IPCString> {
        private C21346d() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104942);
            IPCString c = C21346d.m32739c((IPCString) obj);
            AppMethodBeat.m2505o(104942);
            return c;
        }

        /* renamed from: c */
        private static IPCString m32739c(IPCString iPCString) {
            AppMethodBeat.m2504i(104941);
            IPCString iPCString2;
            try {
                String str;
                C4990ab.m7417i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getMusicMIMETypeByMusicId Task, musicId:%s", iPCString);
                C28576c Tq = C39445e.bUm().mo55153Tq(iPCString.value);
                if (Tq == null) {
                    C4990ab.m7412e("MicroMsg.Music.MusicDataSourceMainProcessImp", "getMusicMIMETypeByMusicId pMusic is null!'");
                    str = null;
                } else {
                    C4990ab.m7417i("MicroMsg.Music.MusicDataSourceMainProcessImp", "music field_pieceFileMIMEType:%s", Tq.field_pieceFileMIMEType);
                    if (TextUtils.isEmpty(Tq.field_pieceFileMIMEType)) {
                        C4990ab.m7412e("MicroMsg.Music.MusicDataSourceMainProcessImp", "field_pieceFileMIMEType is null!'");
                        str = null;
                    } else {
                        str = Tq.field_pieceFileMIMEType;
                    }
                }
                iPCString2 = new IPCString(str);
                AppMethodBeat.m2505o(104941);
                return iPCString2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getMusicMIMETypeByMusicId task", new Object[0]);
                iPCString2 = new IPCString("");
                AppMethodBeat.m2505o(104941);
                return iPCString2;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$e */
    public static final class C21347e implements C45413i<IPCString, IPCAudioParamResponse> {
        private C21347e() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104944);
            IPCAudioParamResponse d = C21347e.m32741d((IPCString) obj);
            AppMethodBeat.m2505o(104944);
            return d;
        }

        /* renamed from: d */
        private static IPCAudioParamResponse m32741d(IPCString iPCString) {
            AppMethodBeat.m2504i(104943);
            try {
                C9060h c9060h;
                C4990ab.m7411d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", iPCString);
                C28576c Tq = C39445e.bUm().mo55153Tq(iPCString.value);
                if (Tq == null) {
                    C4990ab.m7412e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
                    c9060h = null;
                } else {
                    C9060h c9060h2 = new C9060h();
                    c9060h2.cFI = Tq.field_musicId;
                    c9060h2.musicUrl = Tq.field_musicUrl;
                    c9060h2.fileName = Tq.field_fileName;
                    c9060h2.fKw = Tq.field_fileCacheComplete;
                    c9060h2.fKx = Tq.field_pieceFileMIMEType;
                    c9060h2.fKv = Tq.field_indexBitData;
                    c9060h2.fKy = Tq.field_removeDirtyBit;
                    c9060h = c9060h2;
                }
                IPCAudioParamResponse iPCAudioParamResponse;
                if (c9060h != null) {
                    iPCAudioParamResponse = new IPCAudioParamResponse(c9060h);
                    AppMethodBeat.m2505o(104943);
                    return iPCAudioParamResponse;
                }
                C4990ab.m7412e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
                iPCAudioParamResponse = new IPCAudioParamResponse();
                AppMethodBeat.m2505o(104943);
                return iPCAudioParamResponse;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getPieceMusicInfo task", new Object[0]);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$f */
    public static final class C21348f implements C45413i<IPCInteger, IPCInteger> {
        private C21348f() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104946);
            IPCInteger b = C21348f.m32743b((IPCInteger) obj);
            AppMethodBeat.m2505o(104946);
            return b;
        }

        /* renamed from: b */
        private static IPCInteger m32743b(IPCInteger iPCInteger) {
            AppMethodBeat.m2504i(104945);
            IPCInteger iPCInteger2;
            try {
                C4990ab.m7416i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
                iPCInteger2 = new IPCInteger(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(iPCInteger.value))).intValue());
                AppMethodBeat.m2505o(104945);
                return iPCInteger2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
                iPCInteger2 = new IPCInteger(iPCInteger.value);
                AppMethodBeat.m2505o(104945);
                return iPCInteger2;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$g */
    public static final class C34586g implements C45413i<IPCVoid, IPCBoolean> {
        private C34586g() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104948);
            IPCBoolean bUq = C34586g.bUq();
            AppMethodBeat.m2505o(104948);
            return bUq;
        }

        private static IPCBoolean bUq() {
            AppMethodBeat.m2504i(104947);
            IPCBoolean iPCBoolean;
            try {
                C4990ab.m7416i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc isSupportMixAudioByCP task");
                iPCBoolean = new IPCBoolean(((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIC_OPEN_MIX_AUDIO_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue());
                AppMethodBeat.m2505o(104947);
                return iPCBoolean;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc isSupportMixAudioByCP task", new Object[0]);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(104947);
                return iPCBoolean;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$a */
    public static final class C34588a implements C45413i<IPCString, IPCVoid> {
        private C34588a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104936);
            IPCVoid b = C34588a.m56722b((IPCString) obj);
            AppMethodBeat.m2505o(104936);
            return b;
        }

        /* renamed from: b */
        private static IPCVoid m56722b(IPCString iPCString) {
            AppMethodBeat.m2504i(104935);
            try {
                C4990ab.m7417i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", iPCString);
                String str = iPCString.value;
                C34596d bUm = C39445e.bUm();
                int delete = bUm.bSd.delete("PieceMusicInfo", "musicId=?", new String[]{str});
                C4990ab.m7417i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", Integer.valueOf(delete), str);
                bUm.oNq.remove(str);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc deletePieceMusicInfo task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.m2505o(104935);
            return iPCVoid;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$h */
    public static final class C34589h implements C45413i<IPCLong, IPCVoid> {
        private C34589h() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104950);
            IPCVoid a = C34589h.m56724a((IPCLong) obj);
            AppMethodBeat.m2505o(104950);
            return a;
        }

        /* renamed from: a */
        private static IPCVoid m56724a(IPCLong iPCLong) {
            AppMethodBeat.m2504i(104949);
            try {
                C4990ab.m7416i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setLastScanMusicPieceFileTime task");
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(iPCLong.value));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc setLastScanMusicPieceFileTime task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.m2505o(104949);
            return iPCVoid;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$b */
    public static final class C34590b implements C45413i<IPCVoid, IPCString> {
        private C34590b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104938);
            IPCString aIf = C34590b.aIf();
            AppMethodBeat.m2505o(104938);
            return aIf;
        }

        private static IPCString aIf() {
            AppMethodBeat.m2504i(104937);
            IPCString iPCString;
            try {
                C4990ab.m7416i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getAccPath task");
                iPCString = new IPCString(C1720g.m3536RP().eJM);
                AppMethodBeat.m2505o(104937);
                return iPCString;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getAccPath task", new Object[0]);
                iPCString = new IPCString("");
                AppMethodBeat.m2505o(104937);
                return iPCString;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$c */
    public static final class C34591c implements C45413i<IPCVoid, IPCLong> {
        private C34591c() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104940);
            IPCLong bUp = C34591c.bUp();
            AppMethodBeat.m2505o(104940);
            return bUp;
        }

        private static IPCLong bUp() {
            AppMethodBeat.m2504i(104939);
            IPCLong iPCLong;
            try {
                C4990ab.m7416i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getLastScanMusicPieceFileTime task");
                iPCLong = new IPCLong(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(0))).longValue());
                AppMethodBeat.m2505o(104939);
                return iPCLong;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getLastScanMusicPieceFileTime task", new Object[0]);
                iPCLong = new IPCLong(0);
                AppMethodBeat.m2505o(104939);
                return iPCLong;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$i */
    public static final class C34592i implements C45413i<IPCAudioParamRequest, IPCVoid> {
        private C34592i() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104952);
            IPCVoid a = C34592i.m56728a((IPCAudioParamRequest) obj);
            AppMethodBeat.m2505o(104952);
            return a;
        }

        /* renamed from: a */
        private static IPCVoid m56728a(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.m2504i(104951);
            try {
                C4990ab.m7417i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", iPCAudioParamRequest.cFI, iPCAudioParamRequest.mimeType);
                String str = iPCAudioParamRequest.cFI;
                String str2 = iPCAudioParamRequest.mimeType;
                C28576c Tq = C39445e.bUm().mo55153Tq(str);
                if (Tq == null) {
                    C4990ab.m7412e("MicroMsg.Music.MusicDataSourceMainProcessImp", "setMusicMIMETypeByMusicId pMusic is null!'");
                } else if (TextUtils.isEmpty(Tq.field_pieceFileMIMEType) || !Tq.field_pieceFileMIMEType.equals(str2)) {
                    C4990ab.m7416i("MicroMsg.Music.MusicDataSourceMainProcessImp", "updatePieceFileMIMEType()");
                    C34596d bUm = C39445e.bUm();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("pieceFileMIMEType", str2);
                    int update = bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
                    C4990ab.m7417i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", Integer.valueOf(update), str);
                    C28576c c28576c = (C28576c) bUm.oNq.get(str);
                    if (c28576c != null) {
                        c28576c.field_pieceFileMIMEType = str2;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.Music.MusicDataSourceMainProcessImp", "don't need update the piece file mime type");
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.m2505o(104951);
            return iPCVoid;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$j */
    public static final class C34593j implements C45413i<IPCVoid, IPCBoolean> {
        private C34593j() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104954);
            IPCBoolean bUq = C34593j.bUq();
            AppMethodBeat.m2505o(104954);
            return bUq;
        }

        private static IPCBoolean bUq() {
            AppMethodBeat.m2504i(104953);
            IPCBoolean iPCBoolean;
            try {
                C4990ab.m7416i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc showAudioToast");
                iPCBoolean = new IPCBoolean(((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue());
                AppMethodBeat.m2505o(104953);
                return iPCBoolean;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc showAudioToast task", new Object[0]);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(104953);
                return iPCBoolean;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$k */
    public static final class C34594k implements C45413i<IPCAudioParamRequest, IPCVoid> {
        private C34594k() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104956);
            IPCVoid a = C34594k.m56731a((IPCAudioParamRequest) obj);
            AppMethodBeat.m2505o(104956);
            return a;
        }

        /* renamed from: a */
        private static IPCVoid m56731a(IPCAudioParamRequest iPCAudioParamRequest) {
            boolean z = true;
            AppMethodBeat.m2504i(104955);
            try {
                String str = "MicroMsg.Audio.MusicDataSourceCrossProcessImp";
                String str2 = "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b";
                Object[] objArr = new Object[2];
                objArr[0] = iPCAudioParamRequest.cFI;
                if (iPCAudioParamRequest.fKv == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                String str3 = iPCAudioParamRequest.cFI;
                byte[] bArr = iPCAudioParamRequest.fKv;
                C34596d bUm = C39445e.bUm();
                ContentValues contentValues = new ContentValues();
                contentValues.put("indexBitData", bArr);
                if (bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str3}) <= 0) {
                    C4990ab.m7417i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", Integer.valueOf(bUm.bSd.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str3})), str3);
                }
                C28576c c28576c = (C28576c) bUm.oNq.get(str3);
                if (c28576c != null) {
                    c28576c.field_indexBitData = bArr;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updateMusicFileIndexBitCache task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.m2505o(104955);
            return iPCVoid;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$l */
    public static final class C34595l implements C45413i<IPCString, IPCString> {
        private C34595l() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(104958);
            IPCString c = C34595l.m56733c((IPCString) obj);
            AppMethodBeat.m2505o(104958);
            return c;
        }

        /* renamed from: c */
        private static IPCString m56733c(IPCString iPCString) {
            int i = 1;
            AppMethodBeat.m2504i(104957);
            IPCString iPCString2;
            try {
                C28576c c28576c;
                String str;
                C4990ab.m7417i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", iPCString);
                String str2 = iPCString.value;
                C34596d bUm = C39445e.bUm();
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7416i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
                    c28576c = null;
                } else {
                    String Tu = C12673b.m20671Tu(str2);
                    c28576c = bUm.mo55153Tq(Tu);
                    if (c28576c == null) {
                        c28576c = new C28576c();
                        i = 0;
                    }
                    c28576c.field_musicId = Tu;
                    c28576c.field_musicUrl = str2;
                    c28576c.field_fileName = C12673b.m20672Tv(str2);
                    C4990ab.m7417i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", Tu, c28576c.field_fileName);
                    if (i != 0) {
                        C4990ab.m7416i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
                        bUm.mo10103c(c28576c, new String[0]);
                    } else {
                        C4990ab.m7416i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
                        bUm.mo10101b((C4925c) c28576c);
                    }
                    bUm.oNq.put(Tu, c28576c);
                }
                if (c28576c != null) {
                    str = c28576c.field_musicId;
                } else {
                    str = null;
                }
                iPCString2 = new IPCString(str);
                AppMethodBeat.m2505o(104957);
                return iPCString2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc updatePieceMusicInfo task", new Object[0]);
                iPCString2 = new IPCString("");
                AppMethodBeat.m2505o(104957);
                return iPCString2;
            }
        }
    }
}
