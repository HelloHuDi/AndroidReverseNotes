package com.tencent.p177mm.plugin.fav.p408b.p409e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.fav.p407a.C3071o;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.fav.b.e.a */
public final class C6896a implements C3071o {
    private Queue<C45925c> cqQ = new LinkedList();
    private Map<String, C1446a> cqS = new HashMap();
    boolean cqU = false;
    public int cqV = 0;
    long cqW = 0;
    public C7564ap cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C69025(), false);
    private C1628a fFk = new C69016();
    public C1923n fyJ = new C68971();
    Map<String, C6900a> mgS = new HashMap();
    Set<String> mgT = new HashSet();
    boolean mgU = C5023at.isWifi(C4996ah.getContext());
    int mgV = 0;
    boolean mgW = true;
    private Runnable mgX = new C68994();
    boolean running = false;

    /* renamed from: com.tencent.mm.plugin.fav.b.e.a$1 */
    class C68971 extends C1924a {
        C68971() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(5325);
            try {
                boolean isWifi = C5023at.isWifi(C4996ah.getContext());
                C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(C6896a.this.mgU));
                if (i == 4 || i == 6) {
                    C6896a c6896a;
                    if (C6896a.this.mgU && !isWifi) {
                        C45925c c45925c;
                        c6896a = C6896a.this;
                        C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "pauseAll");
                        Cursor buN = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().buN();
                        if (buN != null && buN.moveToFirst()) {
                            while (buN.moveToNext()) {
                                c45925c = new C45925c();
                                c45925c.mo8995d(buN);
                                C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", c45925c.field_dataId);
                                c45925c.field_status = 4;
                                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(c45925c, "dataId");
                                C37461f.afx().mo51227rN(c45925c.field_dataId);
                                C6896a.m11413g(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(c45925c.field_dataId));
                                c6896a.mo15175LW(c45925c.field_dataId);
                            }
                            buN.close();
                        }
                        buN = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().buO();
                        if (buN != null && buN.moveToFirst()) {
                            while (buN.moveToNext()) {
                                c45925c = new C45925c();
                                c45925c.mo8995d(buN);
                                C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", c45925c.field_dataId);
                                c45925c.field_status = 4;
                                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(c45925c, "dataId");
                                C37461f.afx().mo51228rO(c45925c.field_dataId);
                                C6896a.m11413g(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(c45925c.field_dataId));
                                c6896a.mo15175LW(c45925c.field_dataId);
                            }
                        }
                        if (buN != null) {
                            buN.close();
                        }
                    }
                    if (!C6896a.this.mgU && isWifi) {
                        c6896a = C6896a.this;
                        C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "startAll");
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().buL();
                        c6896a.run();
                    }
                    C6896a.this.mgU = isWifi;
                    AppMethodBeat.m2505o(5325);
                    return;
                }
                C6896a.this.mgU = isWifi;
                AppMethodBeat.m2505o(5325);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                AppMethodBeat.m2505o(5325);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.a$4 */
    class C68994 implements Runnable {
        C68994() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5327);
            long currentTimeMillis = System.currentTimeMillis() - C6896a.this.cqW;
            if (C6896a.this.running) {
                if (currentTimeMillis < 300000) {
                    AppMethodBeat.m2505o(5327);
                    return;
                }
                C4990ab.m7412e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + C6896a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C6896a.this.running);
            }
            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", Long.valueOf(currentTimeMillis));
            C6896a.this.cqU = false;
            C6896a.this.running = true;
            C6896a.this.mgV = 0;
            C6896a.this.cqV = 3;
            C6896a.this.cra.mo16770ae(100, 100);
            AppMethodBeat.m2505o(5327);
        }

        public final String toString() {
            AppMethodBeat.m2504i(5328);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(5328);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.a$a */
    class C6900a {
        int errCode;
        int ghB;
        long mhb;

        private C6900a() {
            this.errCode = 0;
        }

        /* synthetic */ C6900a(C6896a c6896a, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.a$6 */
    class C69016 implements C1628a {
        C69016() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(5331);
            if (c18496c != null) {
                C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", c18496c.cHr, Integer.valueOf(c18496c.field_toltalLength), Integer.valueOf(c18496c.field_finishedLength));
            }
            String str2 = "";
            if (c18496c != null) {
                str2 = c18496c.cHr;
            } else if (c9545d != null) {
                str2 = c9545d.cHr;
            }
            if (i == -21006 || i == -21005) {
                C6896a.this.mo15175LW(str2);
                AppMethodBeat.m2505o(5331);
                return 0;
            }
            if (!C5046bo.isNullOrNil(str2)) {
                str = str2;
            }
            C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(str);
            if (LR == null) {
                C4990ab.m7412e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
                C6896a.this.mo15175LW(str);
                AppMethodBeat.m2505o(5331);
                return 0;
            }
            if (i != 0) {
                C4990ab.m7421w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", Integer.valueOf(i));
                C7060h.pYm.mo8381e(10660, Integer.valueOf(LR.field_type), Integer.valueOf(i));
                LR.field_status = 4;
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, new String[0]);
                C6896a.m11413g(LR);
                C6896a.this.mo15175LW(str);
            } else if (c18496c != null) {
                LR.field_offset = c18496c.field_finishedLength;
                LR.field_totalLen = c18496c.field_toltalLength;
                LR.field_status = 1;
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, new String[0]);
            } else if (c9545d != null) {
                String str3;
                if (c9545d.field_retCode >= 0) {
                    LR.field_status = 3;
                    if (1 == LR.field_type) {
                        str2 = LR.field_path + ".temp";
                        str3 = LR.field_path;
                        int i2 = LR.field_dataType;
                        if (!(str2 == null || str3 == null)) {
                            if (i2 == -2 && !C6896a.m11407LV(str2) && C6896a.m11411en(str2, str3)) {
                                C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
                            } else {
                                C5728b c5728b = new C5728b(str2);
                                C5728b c5728b2 = new C5728b(str3);
                                if (c5728b.exists()) {
                                    boolean o = c5728b.mo11675o(c5728b2);
                                    C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(o), str2, c5728b2);
                                }
                            }
                        }
                    } else {
                        LR.field_cdnKey = c9545d.field_aesKey;
                        LR.field_cdnUrl = c9545d.field_fileId;
                    }
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, new String[0]);
                    C6896a.m11408a(LR, c9545d);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15160b(LR, "dataId");
                    C6896a.this.mgS.remove(LR.field_dataId);
                    C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", c9545d.cHr, str, c9545d.field_aesKey, c9545d.toString());
                } else {
                    C4990ab.m7413e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", c9545d.cHr, Integer.valueOf(c9545d.field_retCode));
                    C6900a c6900a = (C6900a) C6896a.this.mgS.get(LR.field_dataId);
                    if (c6900a != null) {
                        c6900a.errCode = c9545d.field_retCode;
                    }
                    if (-6101 != c9545d.field_retCode) {
                        switch (c9545d.field_retCode) {
                            case -5103015:
                                C7060h.pYm.mo8378a(141, 8, 1, true);
                                break;
                            case -21020:
                                C7060h.pYm.mo8378a(141, 7, 1, true);
                                break;
                            case -21014:
                                C7060h.pYm.mo8378a(141, 6, 1, true);
                                break;
                            case -21009:
                                C7060h.pYm.mo8378a(141, 5, 1, true);
                                break;
                            case -21000:
                                C7060h.pYm.mo8378a(141, 4, 1, true);
                                break;
                            case -10005:
                                C7060h.pYm.mo8378a(141, 3, 1, true);
                                break;
                            case -10003:
                                C7060h.pYm.mo8378a(141, 2, 1, true);
                                break;
                            default:
                                C7060h.pYm.mo8378a(141, 0, 1, true);
                                break;
                        }
                    }
                    int i3;
                    LR.field_extFlag |= 1;
                    C7060h.pYm.mo8378a(141, 1, 1, true);
                    str3 = "MicroMsg.Fav.FavCdnService";
                    String str4 = "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = c9545d.cHr;
                    if (c6900a != null) {
                        i3 = c6900a.ghB;
                    } else {
                        i3 = 1;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = Integer.valueOf(LR.field_type);
                    objArr[3] = Integer.valueOf(LR.field_dataType);
                    C4990ab.m7413e(str3, str4, objArr);
                    LR.field_status = 4;
                    C7060h.pYm.mo8381e(10660, Integer.valueOf(LR.field_type), Integer.valueOf(c9545d.field_retCode));
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(LR, new String[0]);
                    C6896a.m11413g(LR);
                }
                C6896a.m11409a(C6896a.this, str);
                C7060h.pYm.mo8381e(10625, Integer.valueOf(1), c9545d.field_fileId, "", c9545d.field_transInfo);
            }
            AppMethodBeat.m2505o(5331);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.b.e.a$5 */
    class C69025 implements C5015a {
        C69025() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5329);
            try {
                C6896a.this.agK();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(5329);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(5330);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(5330);
            return str;
        }
    }

    public C6896a() {
        AppMethodBeat.m2504i(5332);
        C1720g.m3537RQ();
        C1720g.m3535RO().mo5187a(this.fyJ);
        AppMethodBeat.m2505o(5332);
    }

    /* renamed from: hf */
    public final void mo7318hf(final boolean z) {
        AppMethodBeat.m2504i(5333);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                C6896a.this.mgW = z;
                C6896a.this.mgV = 0;
            }
        });
        AppMethodBeat.m2505o(5333);
    }

    /* renamed from: LP */
    public final void mo7315LP(final String str) {
        AppMethodBeat.m2504i(5334);
        C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "add force job %s", str);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(5326);
                C6896a.this.mgT.add(str);
                AppMethodBeat.m2505o(5326);
            }
        });
        AppMethodBeat.m2505o(5334);
    }

    public final void run() {
        AppMethodBeat.m2504i(5335);
        C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
        C1720g.m3539RS().doN().removeCallbacks(this.mgX);
        C1720g.m3539RS().mo10302aa(this.mgX);
        AppMethodBeat.m2505o(5335);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void agK() {
        AppMethodBeat.m2504i(5336);
        this.cqW = System.currentTimeMillis();
        if (!this.cqU && this.cqQ.size() == 0) {
            if (C1445f.m3070Mn()) {
                LinkedList<C45925c> buM = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().buM();
                if (!(buM == null || buM.size() == 0)) {
                    for (C45925c c45925c : buM) {
                        if (this.cqS.containsKey(c45925c.field_dataId)) {
                            C4990ab.m7410d("MicroMsg.Fav.FavCdnService", "File is Already running:" + c45925c.field_dataId);
                        } else {
                            this.cqQ.add(c45925c);
                            this.cqS.put(c45925c.field_dataId, null);
                        }
                    }
                    C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.cqS.size() + ",send:" + this.cqQ.size() + "]");
                    this.cqQ.size();
                }
            } else {
                C4990ab.m7412e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
                mo15174Fb();
            }
        }
        if (this.cqU || this.cqQ.size() > 0) {
            if (!this.cqU && this.cqQ.size() > 0) {
                C45925c c45925c2;
                try {
                    c45925c2 = (C45925c) this.cqQ.poll();
                } catch (Throwable th) {
                    c45925c2 = null;
                }
                if (!(c45925c2 == null || C5046bo.isNullOrNil(c45925c2.field_dataId))) {
                    byte b;
                    C6900a c6900a = (C6900a) this.mgS.get(c45925c2.field_dataId);
                    if (c6900a == null) {
                        c6900a = new C6900a(this, (byte) 0);
                        c6900a.ghB = 1;
                        c6900a.mhb = C5046bo.anU();
                        this.mgS.put(c45925c2.field_dataId, c6900a);
                    } else if (C5046bo.anU() - c6900a.mhb > 180000 && c6900a.errCode != -6101) {
                        c6900a.ghB = 1;
                        c6900a.mhb = C5046bo.anU();
                        this.mgS.put(c45925c2.field_dataId, c6900a);
                    } else if (c6900a.ghB <= 3) {
                        c6900a.ghB++;
                        this.mgS.put(c45925c2.field_dataId, c6900a);
                    } else {
                        C4990ab.m7413e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                        C6896a.m11412f(c45925c2);
                        b = (byte) 0;
                        if (b != 0) {
                            this.cqU = true;
                            if (c45925c2 != null) {
                                C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", c45925c2.field_dataId);
                                C42130g c42130g = new C42130g();
                                c42130g.egl = this.fFk;
                                c42130g.field_mediaId = c45925c2.field_dataId;
                                if (c45925c2.field_type == 0) {
                                    c42130g.cRY = true;
                                    c42130g.field_priority = C42129a.efB;
                                    c42130g.field_needStorage = true;
                                    c42130g.field_totalLen = c45925c2.field_totalLen;
                                    c42130g.field_aesKey = c45925c2.field_cdnKey;
                                    c42130g.field_fileId = c45925c2.field_cdnUrl;
                                    c42130g.field_isStreamMedia = c45925c2.buq();
                                    c42130g.field_fullpath = c45925c2.field_path;
                                    if (!C5730e.m8628ct(c42130g.field_fullpath)) {
                                        C4990ab.m7413e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", c45925c2.field_path);
                                    }
                                    if (c45925c2.buq()) {
                                        c42130g.field_fileType = C6896a.m11410ee(c45925c2.field_extFlag, C42129a.MediaType_FAVORITE_VIDEO);
                                    } else {
                                        c42130g.field_fileType = C6896a.m11410ee(c45925c2.field_extFlag, C42129a.MediaType_FAVORITE_FILE);
                                    }
                                    c42130g.field_force_aeskeycdn = true;
                                    c42130g.field_trysafecdn = false;
                                    C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn));
                                    C37461f.afx().mo51225e(c42130g);
                                    AppMethodBeat.m2505o(5336);
                                    return;
                                }
                                c42130g.cRY = false;
                                c42130g.field_totalLen = c45925c2.field_totalLen;
                                c42130g.field_aesKey = c45925c2.field_cdnKey;
                                c42130g.field_fileId = c45925c2.field_cdnUrl;
                                c42130g.field_priority = C42129a.efC;
                                c42130g.egl = this.fFk;
                                c42130g.field_fullpath = c45925c2.field_path + ".temp";
                                c42130g.field_needStorage = true;
                                c42130g.field_isStreamMedia = c45925c2.buq();
                                if (c45925c2.buq()) {
                                    c42130g.field_fileType = C6896a.m11410ee(c45925c2.field_extFlag, C42129a.MediaType_FAVORITE_VIDEO);
                                } else {
                                    c42130g.field_fileType = C6896a.m11410ee(c45925c2.field_extFlag, C42129a.MediaType_FAVORITE_FILE);
                                }
                                C37461f.afx().mo51222b(c42130g, -1);
                                C6896a.m11413g(c45925c2);
                            }
                            AppMethodBeat.m2505o(5336);
                            return;
                        } else if (this.mgV >= 10) {
                            mo15174Fb();
                            AppMethodBeat.m2505o(5336);
                            return;
                        } else {
                            this.cra.mo16770ae(500, 500);
                        }
                    }
                    if (c45925c2.field_type == 0) {
                        C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                    } else if (this.mgT.contains(c45925c2.field_dataId) || C39037b.m66337LB(c45925c2.field_dataId)) {
                        C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                    } else {
                        if (!C5023at.isWifi(C4996ah.getContext())) {
                            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                            C6896a.m11412f(c45925c2);
                            b = (byte) 0;
                        } else if (c45925c2.field_type == 0) {
                            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                        } else if (!this.mgW) {
                            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                            this.mgV = 0;
                        } else if (this.mgV < 10) {
                            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", Integer.valueOf(10), Integer.valueOf(this.mgV), Integer.valueOf(c6900a.ghB), Long.valueOf(c45925c2.field_favLocalId), c45925c2.field_dataId, Integer.valueOf(c45925c2.field_type), Integer.valueOf(c45925c2.field_dataType));
                            if (c6900a.ghB == 1) {
                                this.mgV++;
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", Integer.valueOf(10));
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
            AppMethodBeat.m2505o(5336);
            return;
        }
        mo15174Fb();
        C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
        AppMethodBeat.m2505o(5336);
    }

    /* renamed from: f */
    private static void m11412f(C45925c c45925c) {
        AppMethodBeat.m2504i(5337);
        if (1 == c45925c.field_type) {
            c45925c.field_status = 2;
        } else {
            c45925c.field_status = 4;
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15158a(c45925c, "dataId");
        C6896a.m11413g(c45925c);
        AppMethodBeat.m2505o(5337);
    }

    public final void pauseDownload(String str) {
        AppMethodBeat.m2504i(5338);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(5338);
            return;
        }
        if (this.cqS.containsKey(str)) {
            C37461f.afx().mo51228rO(str);
            C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "pause download md5%s", str);
            C6896a.m11413g(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(str));
            mo15175LW(str);
        }
        AppMethodBeat.m2505o(5338);
    }

    /* renamed from: LQ */
    public final void mo7316LQ(String str) {
        AppMethodBeat.m2504i(5339);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(5339);
            return;
        }
        C37461f.afx().mo51227rN(str);
        C4990ab.m7417i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", str);
        C6896a.m11413g(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(str));
        mo15175LW(str);
        AppMethodBeat.m2505o(5339);
    }

    /* renamed from: Fb */
    public final void mo15174Fb() {
        AppMethodBeat.m2504i(5340);
        this.cqQ.clear();
        this.cqS.clear();
        this.running = false;
        this.cqU = false;
        AppMethodBeat.m2505o(5340);
    }

    /* renamed from: ee */
    private static int m11410ee(int i, int i2) {
        AppMethodBeat.m2504i(5341);
        if ((i & 1) == 0) {
            AppMethodBeat.m2505o(5341);
            return i2;
        }
        C4990ab.m7421w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", Integer.valueOf(i2));
        if (C42129a.MediaType_FAVORITE_VIDEO == i2) {
            i2 = C42129a.MediaType_FAVORITE_FILE;
            AppMethodBeat.m2505o(5341);
            return i2;
        }
        i2 = C42129a.MediaType_FAVORITE_VIDEO;
        AppMethodBeat.m2505o(5341);
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
    /* renamed from: en */
    static boolean m11411en(String str, String str2) {
        InputStream openRead;
        OutputStream L;
        Throwable e;
        boolean z;
        AppMethodBeat.m2504i(5342);
        try {
            openRead = C5730e.openRead(str);
            try {
                L = C5730e.m8617L(str2, false);
            } catch (Exception e2) {
                e = e2;
                L = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                        }
                    }
                    if (L != null) {
                        try {
                            L.close();
                            z = false;
                        } catch (IOException e32) {
                            C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e32, "", new Object[0]);
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    AppMethodBeat.m2505o(5342);
                    return z;
                } catch (Throwable th) {
                    e = th;
                    if (openRead != null) {
                    }
                    if (L != null) {
                    }
                    AppMethodBeat.m2505o(5342);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                L = null;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e4) {
                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e4, "", new Object[0]);
                    }
                }
                if (L != null) {
                    try {
                        L.close();
                    } catch (IOException e5) {
                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e5, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(5342);
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
                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e322, "", new Object[0]);
                        z = false;
                    }
                }
                if (L != null) {
                    try {
                        L.close();
                    } catch (IOException e3222) {
                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3222, "", new Object[0]);
                        z = false;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                if (openRead != null) {
                }
                if (L != null) {
                }
                AppMethodBeat.m2505o(5342);
                return z;
            }
        } catch (Exception e7) {
            e = e7;
            L = null;
            openRead = null;
            C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
            if (openRead != null) {
            }
            if (L != null) {
            }
            AppMethodBeat.m2505o(5342);
            return z;
        } catch (Throwable th3) {
            e = th3;
            L = null;
            openRead = null;
            if (openRead != null) {
            }
            if (L != null) {
            }
            AppMethodBeat.m2505o(5342);
            throw e;
        }
        AppMethodBeat.m2505o(5342);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095 A:{SYNTHETIC, Splitter:B:33:0x0095} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: LV */
    static boolean m11407LV(String str) {
        Throwable e;
        AppMethodBeat.m2504i(5343);
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(5343);
                    return false;
                }
                String str2 = new String(bArr);
                C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
                boolean endsWith = str2.endsWith("#!AMR\n");
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                }
                AppMethodBeat.m2505o(5343);
                return endsWith;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
            try {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(5343);
                return false;
            } catch (Throwable th) {
                e = th;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(5343);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e32) {
                    C4990ab.printErrStackTrace("MicroMsg.Fav.FavCdnService", e32, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(5343);
            throw e;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: LW */
    public final void mo15175LW(String str) {
        AppMethodBeat.m2504i(5344);
        this.cqU = false;
        this.cqS.remove(str);
        pauseDownload(str);
        if (this.cqV > 0) {
            agK();
            AppMethodBeat.m2505o(5344);
            return;
        }
        C4990ab.m7416i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        mo15174Fb();
        AppMethodBeat.m2505o(5344);
    }

    /* renamed from: g */
    static void m11413g(C45925c c45925c) {
        AppMethodBeat.m2504i(5345);
        if (c45925c.field_type == 0) {
            C39037b.m66356a(c45925c);
            AppMethodBeat.m2505o(5345);
        } else if (c45925c.field_type == 1) {
            C39037b.m66373b(c45925c);
            AppMethodBeat.m2505o(5345);
        } else {
            AppMethodBeat.m2505o(5345);
        }
    }

    /* renamed from: c */
    public final void mo7317c(C45925c c45925c) {
        AppMethodBeat.m2504i(5346);
        if (c45925c != null) {
            this.cqQ.add(c45925c);
        }
        AppMethodBeat.m2505o(5346);
    }
}
