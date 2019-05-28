package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class a implements o {
    private Queue<c> cqQ = new LinkedList();
    private Map<String, com.tencent.mm.compatible.util.g.a> cqS = new HashMap();
    boolean cqU = false;
    public int cqV = 0;
    long cqW = 0;
    public ap cra = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(5329);
            try {
                a.this.agK();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
            }
            AppMethodBeat.o(5329);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(5330);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(5330);
            return str;
        }
    }, false);
    private com.tencent.mm.i.g.a fFk = new com.tencent.mm.i.g.a() {
        public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(5331);
            if (cVar != null) {
                ab.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", cVar.cHr, Integer.valueOf(cVar.field_toltalLength), Integer.valueOf(cVar.field_finishedLength));
            }
            String str2 = "";
            if (cVar != null) {
                str2 = cVar.cHr;
            } else if (dVar != null) {
                str2 = dVar.cHr;
            }
            if (i == -21006 || i == -21005) {
                a.this.LW(str2);
                AppMethodBeat.o(5331);
                return 0;
            }
            if (!bo.isNullOrNil(str2)) {
                str = str2;
            }
            c LR = ((ae) g.M(ae.class)).getFavCdnStorage().LR(str);
            if (LR == null) {
                ab.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
                a.this.LW(str);
                AppMethodBeat.o(5331);
                return 0;
            }
            if (i != 0) {
                ab.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", Integer.valueOf(i));
                h.pYm.e(10660, Integer.valueOf(LR.field_type), Integer.valueOf(i));
                LR.field_status = 4;
                ((ae) g.M(ae.class)).getFavCdnStorage().a(LR, new String[0]);
                a.g(LR);
                a.this.LW(str);
            } else if (cVar != null) {
                LR.field_offset = cVar.field_finishedLength;
                LR.field_totalLen = cVar.field_toltalLength;
                LR.field_status = 1;
                ((ae) g.M(ae.class)).getFavCdnStorage().a(LR, new String[0]);
            } else if (dVar != null) {
                String str3;
                if (dVar.field_retCode >= 0) {
                    LR.field_status = 3;
                    if (1 == LR.field_type) {
                        str2 = LR.field_path + ".temp";
                        str3 = LR.field_path;
                        int i2 = LR.field_dataType;
                        if (!(str2 == null || str3 == null)) {
                            if (i2 == -2 && !a.LV(str2) && a.en(str2, str3)) {
                                ab.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
                            } else {
                                b bVar = new b(str2);
                                b bVar2 = new b(str3);
                                if (bVar.exists()) {
                                    boolean o = bVar.o(bVar2);
                                    ab.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(o), str2, bVar2);
                                }
                            }
                        }
                    } else {
                        LR.field_cdnKey = dVar.field_aesKey;
                        LR.field_cdnUrl = dVar.field_fileId;
                    }
                    ((ae) g.M(ae.class)).getFavCdnStorage().a(LR, new String[0]);
                    a.a(LR, dVar);
                    ((ae) g.M(ae.class)).getFavCdnStorage().b(LR, "dataId");
                    a.this.mgS.remove(LR.field_dataId);
                    ab.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", dVar.cHr, str, dVar.field_aesKey, dVar.toString());
                } else {
                    ab.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", dVar.cHr, Integer.valueOf(dVar.field_retCode));
                    a aVar = (a) a.this.mgS.get(LR.field_dataId);
                    if (aVar != null) {
                        aVar.errCode = dVar.field_retCode;
                    }
                    if (-6101 != dVar.field_retCode) {
                        switch (dVar.field_retCode) {
                            case -5103015:
                                h.pYm.a(141, 8, 1, true);
                                break;
                            case -21020:
                                h.pYm.a(141, 7, 1, true);
                                break;
                            case -21014:
                                h.pYm.a(141, 6, 1, true);
                                break;
                            case -21009:
                                h.pYm.a(141, 5, 1, true);
                                break;
                            case -21000:
                                h.pYm.a(141, 4, 1, true);
                                break;
                            case -10005:
                                h.pYm.a(141, 3, 1, true);
                                break;
                            case -10003:
                                h.pYm.a(141, 2, 1, true);
                                break;
                            default:
                                h.pYm.a(141, 0, 1, true);
                                break;
                        }
                    }
                    int i3;
                    LR.field_extFlag |= 1;
                    h.pYm.a(141, 1, 1, true);
                    str3 = "MicroMsg.Fav.FavCdnService";
                    String str4 = "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = dVar.cHr;
                    if (aVar != null) {
                        i3 = aVar.ghB;
                    } else {
                        i3 = 1;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = Integer.valueOf(LR.field_type);
                    objArr[3] = Integer.valueOf(LR.field_dataType);
                    ab.e(str3, str4, objArr);
                    LR.field_status = 4;
                    h.pYm.e(10660, Integer.valueOf(LR.field_type), Integer.valueOf(dVar.field_retCode));
                    ((ae) g.M(ae.class)).getFavCdnStorage().a(LR, new String[0]);
                    a.g(LR);
                }
                a.a(a.this, str);
                h.pYm.e(10625, Integer.valueOf(1), dVar.field_fileId, "", dVar.field_transInfo);
            }
            AppMethodBeat.o(5331);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    };
    public n fyJ = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(5325);
            try {
                boolean isWifi = at.isWifi(ah.getContext());
                ab.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(a.this.mgU));
                if (i == 4 || i == 6) {
                    a aVar;
                    if (a.this.mgU && !isWifi) {
                        c cVar;
                        aVar = a.this;
                        ab.i("MicroMsg.Fav.FavCdnService", "pauseAll");
                        Cursor buN = ((ae) g.M(ae.class)).getFavCdnStorage().buN();
                        if (buN != null && buN.moveToFirst()) {
                            while (buN.moveToNext()) {
                                cVar = new c();
                                cVar.d(buN);
                                ab.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", cVar.field_dataId);
                                cVar.field_status = 4;
                                ((ae) g.M(ae.class)).getFavCdnStorage().a(cVar, "dataId");
                                f.afx().rN(cVar.field_dataId);
                                a.g(((ae) g.M(ae.class)).getFavCdnStorage().LR(cVar.field_dataId));
                                aVar.LW(cVar.field_dataId);
                            }
                            buN.close();
                        }
                        buN = ((ae) g.M(ae.class)).getFavCdnStorage().buO();
                        if (buN != null && buN.moveToFirst()) {
                            while (buN.moveToNext()) {
                                cVar = new c();
                                cVar.d(buN);
                                ab.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", cVar.field_dataId);
                                cVar.field_status = 4;
                                ((ae) g.M(ae.class)).getFavCdnStorage().a(cVar, "dataId");
                                f.afx().rO(cVar.field_dataId);
                                a.g(((ae) g.M(ae.class)).getFavCdnStorage().LR(cVar.field_dataId));
                                aVar.LW(cVar.field_dataId);
                            }
                        }
                        if (buN != null) {
                            buN.close();
                        }
                    }
                    if (!a.this.mgU && isWifi) {
                        aVar = a.this;
                        ab.i("MicroMsg.Fav.FavCdnService", "startAll");
                        ((ae) g.M(ae.class)).getFavCdnStorage().buL();
                        aVar.run();
                    }
                    a.this.mgU = isWifi;
                    AppMethodBeat.o(5325);
                    return;
                }
                a.this.mgU = isWifi;
                AppMethodBeat.o(5325);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                AppMethodBeat.o(5325);
            }
        }
    };
    Map<String, a> mgS = new HashMap();
    Set<String> mgT = new HashSet();
    boolean mgU = at.isWifi(ah.getContext());
    int mgV = 0;
    boolean mgW = true;
    private Runnable mgX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(5327);
            long currentTimeMillis = System.currentTimeMillis() - a.this.cqW;
            if (a.this.running) {
                if (currentTimeMillis < 300000) {
                    AppMethodBeat.o(5327);
                    return;
                }
                ab.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.running);
            }
            ab.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", Long.valueOf(currentTimeMillis));
            a.this.cqU = false;
            a.this.running = true;
            a.this.mgV = 0;
            a.this.cqV = 3;
            a.this.cra.ae(100, 100);
            AppMethodBeat.o(5327);
        }

        public final String toString() {
            AppMethodBeat.i(5328);
            String str = super.toString() + "|run";
            AppMethodBeat.o(5328);
            return str;
        }
    };
    boolean running = false;

    class a {
        int errCode;
        int ghB;
        long mhb;

        private a() {
            this.errCode = 0;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(5332);
        g.RQ();
        g.RO().a(this.fyJ);
        AppMethodBeat.o(5332);
    }

    public final void hf(final boolean z) {
        AppMethodBeat.i(5333);
        g.RS().aa(new Runnable() {
            public final void run() {
                a.this.mgW = z;
                a.this.mgV = 0;
            }
        });
        AppMethodBeat.o(5333);
    }

    public final void LP(final String str) {
        AppMethodBeat.i(5334);
        ab.i("MicroMsg.Fav.FavCdnService", "add force job %s", str);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5326);
                a.this.mgT.add(str);
                AppMethodBeat.o(5326);
            }
        });
        AppMethodBeat.o(5334);
    }

    public final void run() {
        AppMethodBeat.i(5335);
        ab.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
        g.RS().doN().removeCallbacks(this.mgX);
        g.RS().aa(this.mgX);
        AppMethodBeat.o(5335);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void agK() {
        AppMethodBeat.i(5336);
        this.cqW = System.currentTimeMillis();
        if (!this.cqU && this.cqQ.size() == 0) {
            if (com.tencent.mm.compatible.util.f.Mn()) {
                LinkedList<c> buM = ((ae) g.M(ae.class)).getFavCdnStorage().buM();
                if (!(buM == null || buM.size() == 0)) {
                    for (c cVar : buM) {
                        if (this.cqS.containsKey(cVar.field_dataId)) {
                            ab.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + cVar.field_dataId);
                        } else {
                            this.cqQ.add(cVar);
                            this.cqS.put(cVar.field_dataId, null);
                        }
                    }
                    ab.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.cqS.size() + ",send:" + this.cqQ.size() + "]");
                    this.cqQ.size();
                }
            } else {
                ab.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
                Fb();
            }
        }
        if (this.cqU || this.cqQ.size() > 0) {
            if (!this.cqU && this.cqQ.size() > 0) {
                c cVar2;
                try {
                    cVar2 = (c) this.cqQ.poll();
                } catch (Throwable th) {
                    cVar2 = null;
                }
                if (!(cVar2 == null || bo.isNullOrNil(cVar2.field_dataId))) {
                    byte b;
                    a aVar = (a) this.mgS.get(cVar2.field_dataId);
                    if (aVar == null) {
                        aVar = new a(this, (byte) 0);
                        aVar.ghB = 1;
                        aVar.mhb = bo.anU();
                        this.mgS.put(cVar2.field_dataId, aVar);
                    } else if (bo.anU() - aVar.mhb > 180000 && aVar.errCode != -6101) {
                        aVar.ghB = 1;
                        aVar.mhb = bo.anU();
                        this.mgS.put(cVar2.field_dataId, aVar);
                    } else if (aVar.ghB <= 3) {
                        aVar.ghB++;
                        this.mgS.put(cVar2.field_dataId, aVar);
                    } else {
                        ab.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                        f(cVar2);
                        b = (byte) 0;
                        if (b != 0) {
                            this.cqU = true;
                            if (cVar2 != null) {
                                ab.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", cVar2.field_dataId);
                                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                gVar.egl = this.fFk;
                                gVar.field_mediaId = cVar2.field_dataId;
                                if (cVar2.field_type == 0) {
                                    gVar.cRY = true;
                                    gVar.field_priority = com.tencent.mm.i.a.efB;
                                    gVar.field_needStorage = true;
                                    gVar.field_totalLen = cVar2.field_totalLen;
                                    gVar.field_aesKey = cVar2.field_cdnKey;
                                    gVar.field_fileId = cVar2.field_cdnUrl;
                                    gVar.field_isStreamMedia = cVar2.buq();
                                    gVar.field_fullpath = cVar2.field_path;
                                    if (!e.ct(gVar.field_fullpath)) {
                                        ab.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", cVar2.field_path);
                                    }
                                    if (cVar2.buq()) {
                                        gVar.field_fileType = ee(cVar2.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
                                    } else {
                                        gVar.field_fileType = ee(cVar2.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
                                    }
                                    gVar.field_force_aeskeycdn = true;
                                    gVar.field_trysafecdn = false;
                                    ab.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn));
                                    f.afx().e(gVar);
                                    AppMethodBeat.o(5336);
                                    return;
                                }
                                gVar.cRY = false;
                                gVar.field_totalLen = cVar2.field_totalLen;
                                gVar.field_aesKey = cVar2.field_cdnKey;
                                gVar.field_fileId = cVar2.field_cdnUrl;
                                gVar.field_priority = com.tencent.mm.i.a.efC;
                                gVar.egl = this.fFk;
                                gVar.field_fullpath = cVar2.field_path + ".temp";
                                gVar.field_needStorage = true;
                                gVar.field_isStreamMedia = cVar2.buq();
                                if (cVar2.buq()) {
                                    gVar.field_fileType = ee(cVar2.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
                                } else {
                                    gVar.field_fileType = ee(cVar2.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
                                }
                                f.afx().b(gVar, -1);
                                g(cVar2);
                            }
                            AppMethodBeat.o(5336);
                            return;
                        } else if (this.mgV >= 10) {
                            Fb();
                            AppMethodBeat.o(5336);
                            return;
                        } else {
                            this.cra.ae(500, 500);
                        }
                    }
                    if (cVar2.field_type == 0) {
                        ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                    } else if (this.mgT.contains(cVar2.field_dataId) || com.tencent.mm.plugin.fav.a.b.LB(cVar2.field_dataId)) {
                        ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                    } else {
                        if (!at.isWifi(ah.getContext())) {
                            ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                            f(cVar2);
                            b = (byte) 0;
                        } else if (cVar2.field_type == 0) {
                            ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                        } else if (!this.mgW) {
                            ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                            this.mgV = 0;
                        } else if (this.mgV < 10) {
                            ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", Integer.valueOf(10), Integer.valueOf(this.mgV), Integer.valueOf(aVar.ghB), Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType));
                            if (aVar.ghB == 1) {
                                this.mgV++;
                            }
                        } else {
                            ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", Integer.valueOf(10));
                            b = (byte) 0;
                        }
                        if (b != 0) {
                        }
                    }
                    int b2 = 1;
                    if (b2 != 0) {
                    }
                }
            }
            AppMethodBeat.o(5336);
            return;
        }
        Fb();
        ab.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
        AppMethodBeat.o(5336);
    }

    private static void f(c cVar) {
        AppMethodBeat.i(5337);
        if (1 == cVar.field_type) {
            cVar.field_status = 2;
        } else {
            cVar.field_status = 4;
        }
        ((ae) g.M(ae.class)).getFavCdnStorage().a(cVar, "dataId");
        g(cVar);
        AppMethodBeat.o(5337);
    }

    public final void pauseDownload(String str) {
        AppMethodBeat.i(5338);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(5338);
            return;
        }
        if (this.cqS.containsKey(str)) {
            f.afx().rO(str);
            ab.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", str);
            g(((ae) g.M(ae.class)).getFavCdnStorage().LR(str));
            LW(str);
        }
        AppMethodBeat.o(5338);
    }

    public final void LQ(String str) {
        AppMethodBeat.i(5339);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(5339);
            return;
        }
        f.afx().rN(str);
        ab.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", str);
        g(((ae) g.M(ae.class)).getFavCdnStorage().LR(str));
        LW(str);
        AppMethodBeat.o(5339);
    }

    public final void Fb() {
        AppMethodBeat.i(5340);
        this.cqQ.clear();
        this.cqS.clear();
        this.running = false;
        this.cqU = false;
        AppMethodBeat.o(5340);
    }

    private static int ee(int i, int i2) {
        AppMethodBeat.i(5341);
        if ((i & 1) == 0) {
            AppMethodBeat.o(5341);
            return i2;
        }
        ab.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", Integer.valueOf(i2));
        if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == i2) {
            i2 = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
            AppMethodBeat.o(5341);
            return i2;
        }
        i2 = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
        AppMethodBeat.o(5341);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x008e A:{SYNTHETIC, Splitter:B:43:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A:{SYNTHETIC, Splitter:B:46:0x0093} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A:{SYNTHETIC, Splitter:B:17:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A:{SYNTHETIC, Splitter:B:20:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A:{SYNTHETIC, Splitter:B:17:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A:{SYNTHETIC, Splitter:B:20:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008e A:{SYNTHETIC, Splitter:B:43:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A:{SYNTHETIC, Splitter:B:46:0x0093} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean en(String str, String str2) {
        InputStream openRead;
        OutputStream L;
        Throwable e;
        boolean z;
        AppMethodBeat.i(5342);
        try {
            openRead = e.openRead(str);
            try {
                L = e.L(str2, false);
            } catch (Exception e2) {
                e = e2;
                L = null;
                try {
                    ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                            ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                        }
                    }
                    if (L != null) {
                        try {
                            L.close();
                            z = false;
                        } catch (IOException e32) {
                            ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e32, "", new Object[0]);
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    AppMethodBeat.o(5342);
                    return z;
                } catch (Throwable th) {
                    e = th;
                    if (openRead != null) {
                    }
                    if (L != null) {
                    }
                    AppMethodBeat.o(5342);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                L = null;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e4) {
                        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e4, "", new Object[0]);
                    }
                }
                if (L != null) {
                    try {
                        L.close();
                    } catch (IOException e5) {
                        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e5, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(5342);
                throw e;
            }
            try {
                byte[] bArr = new byte[16384];
                L.write("#!AMR\n".getBytes());
                while (true) {
                    int read = openRead.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    L.write(bArr, 0, read);
                }
                z = true;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e322) {
                        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e322, "", new Object[0]);
                        z = false;
                    }
                }
                if (L != null) {
                    try {
                        L.close();
                    } catch (IOException e3222) {
                        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3222, "", new Object[0]);
                        z = false;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                if (openRead != null) {
                }
                if (L != null) {
                }
                AppMethodBeat.o(5342);
                return z;
            }
        } catch (Exception e7) {
            e = e7;
            L = null;
            openRead = null;
            ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
            if (openRead != null) {
            }
            if (L != null) {
            }
            AppMethodBeat.o(5342);
            return z;
        } catch (Throwable th3) {
            e = th3;
            L = null;
            openRead = null;
            if (openRead != null) {
            }
            if (L != null) {
            }
            AppMethodBeat.o(5342);
            throw e;
        }
        AppMethodBeat.o(5342);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095 A:{SYNTHETIC, Splitter:B:33:0x0095} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean LV(String str) {
        Throwable e;
        AppMethodBeat.i(5343);
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                    }
                    AppMethodBeat.o(5343);
                    return false;
                }
                String str2 = new String(bArr);
                ab.i("MicroMsg.Fav.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
                boolean endsWith = str2.endsWith("#!AMR\n");
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                }
                AppMethodBeat.o(5343);
                return endsWith;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
            try {
                ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(5343);
                return false;
            } catch (Throwable th) {
                e = th;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(5343);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e32) {
                    ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e32, "", new Object[0]);
                }
            }
            AppMethodBeat.o(5343);
            throw e;
        }
    }

    /* Access modifiers changed, original: final */
    public final void LW(String str) {
        AppMethodBeat.i(5344);
        this.cqU = false;
        this.cqS.remove(str);
        pauseDownload(str);
        if (this.cqV > 0) {
            agK();
            AppMethodBeat.o(5344);
            return;
        }
        ab.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        Fb();
        AppMethodBeat.o(5344);
    }

    static void g(c cVar) {
        AppMethodBeat.i(5345);
        if (cVar.field_type == 0) {
            com.tencent.mm.plugin.fav.a.b.a(cVar);
            AppMethodBeat.o(5345);
        } else if (cVar.field_type == 1) {
            com.tencent.mm.plugin.fav.a.b.b(cVar);
            AppMethodBeat.o(5345);
        } else {
            AppMethodBeat.o(5345);
        }
    }

    public final void c(c cVar) {
        AppMethodBeat.i(5346);
        if (cVar != null) {
            this.cqQ.add(cVar);
        }
        AppMethodBeat.o(5346);
    }
}
