package com.tencent.p177mm.plugin.music.model.p466d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p462e.C28559e;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.music.model.d.d */
public final class C3541d {
    public static long fqM;
    public static boolean oNi;
    public static boolean oNj;
    public static int oNk;
    public static int oNl;
    private static C28575a oNm;
    public static int scene;

    /* renamed from: ad */
    public static final void m5830ad(int i, int i2, int i3) {
        AppMethodBeat.m2504i(105011);
        if (((C28559e) C43329b.m77295ar(C28559e.class)).bTU() != null) {
            C4990ab.m7419v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", Integer.valueOf(13042), Integer.valueOf(i), Integer.valueOf(i2), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_musicId, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songName, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songAlbum, Integer.valueOf(((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songId), Integer.valueOf(i3), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songSinger, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_appId);
            C7060h.pYm.mo8381e(13042, Integer.valueOf(i), Integer.valueOf(i2), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i3), r0.field_songSinger, r0.field_appId);
        }
        AppMethodBeat.m2505o(105011);
    }

    /* renamed from: eJ */
    public static final void m5831eJ(int i, int i2) {
        AppMethodBeat.m2504i(105012);
        if (((C28559e) C43329b.m77295ar(C28559e.class)).bTU() != null) {
            C4990ab.m7419v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", Integer.valueOf(13232), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_musicId, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songName, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songAlbum, Integer.valueOf(((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songId), Integer.valueOf(i2), Integer.valueOf(i), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songSinger, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_appId);
            C7060h.pYm.mo8381e(13232, r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i2), Integer.valueOf(i), r0.field_songSinger, r0.field_appId);
        }
        AppMethodBeat.m2505o(105012);
    }

    /* renamed from: f */
    public static synchronized void m5832f(C28575a c28575a) {
        synchronized (C3541d.class) {
            oNm = c28575a;
        }
    }

    public static final synchronized void bUs() {
        int i = 1;
        synchronized (C3541d.class) {
            AppMethodBeat.m2504i(105013);
            if (oNm != null) {
                int i2;
                C3541d.m5828KX();
                String str = "MicroMsg.Music.MusicReportUtil";
                String str2 = "kvReportMusicPlayInfo: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
                Object[] objArr = new Object[12];
                objArr[0] = Integer.valueOf(13044);
                objArr[1] = oNm.field_musicId;
                objArr[2] = oNm.field_songName;
                objArr[3] = oNm.field_songAlbum;
                objArr[4] = Integer.valueOf(oNm.field_songId);
                objArr[5] = Integer.valueOf(oNk);
                objArr[6] = Integer.valueOf(oNl);
                objArr[7] = Integer.valueOf(oNi ? 1 : 2);
                objArr[8] = Integer.valueOf(oNj ? 1 : 2);
                objArr[9] = Integer.valueOf(scene);
                objArr[10] = oNm.field_songSinger;
                objArr[11] = oNm.field_appId;
                C4990ab.m7419v(str, str2, objArr);
                C7060h c7060h = C7060h.pYm;
                objArr = new Object[11];
                objArr[0] = oNm.field_musicId;
                objArr[1] = oNm.field_songName;
                objArr[2] = oNm.field_songAlbum;
                objArr[3] = Integer.valueOf(oNm.field_songId);
                objArr[4] = Integer.valueOf(oNk);
                objArr[5] = Integer.valueOf(oNl);
                if (oNi) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[6] = Integer.valueOf(i2);
                if (!oNj) {
                    i = 2;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = Integer.valueOf(scene);
                objArr[9] = oNm.field_songSinger;
                objArr[10] = oNm.field_appId;
                c7060h.mo8381e(13044, objArr);
            }
            oNm = null;
            oNi = false;
            oNj = false;
            oNk = 0;
            oNl = 0;
            fqM = 0;
            scene = 0;
            AppMethodBeat.m2505o(105013);
        }
    }

    /* renamed from: KX */
    public static final void m5828KX() {
        AppMethodBeat.m2504i(105014);
        if (fqM > 0) {
            oNl = (int) (((long) oNl) + ((System.currentTimeMillis() - fqM) / 1000));
            fqM = 0;
        }
        AppMethodBeat.m2505o(105014);
    }

    public static final void bUt() {
        AppMethodBeat.m2504i(105015);
        C7060h.pYm.mo8378a(285, 4, 1, false);
        AppMethodBeat.m2505o(105015);
    }

    /* renamed from: zO */
    public static final void m5834zO(int i) {
        AppMethodBeat.m2504i(105016);
        if (i == 2) {
            C9058e aih = C37494a.aih();
            if (aih != null) {
                C27968h.m44531j(C5046bo.getLong(aih.fKs, 0), 1, 0);
            }
        }
        AppMethodBeat.m2505o(105016);
    }

    /* renamed from: zP */
    public static final void m5835zP(int i) {
        AppMethodBeat.m2504i(105017);
        if (i == 2) {
            C9058e aih = C37494a.aih();
            if (aih != null) {
                C27968h.m44531j(C5046bo.getLong(aih.fKs, 0), 0, 0);
            }
        }
        AppMethodBeat.m2505o(105017);
    }

    /* renamed from: zQ */
    public static final void m5836zQ(int i) {
        AppMethodBeat.m2504i(105018);
        if (((C28559e) C43329b.m77295ar(C28559e.class)).bTU() != null) {
            C4990ab.m7417i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", Integer.valueOf(i), ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_musicId, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songName, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_songSinger, ((C28559e) C43329b.m77295ar(C28559e.class)).bTU().field_appId);
            C7060h.pYm.mo8381e(12836, Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songSinger, r0.field_appId);
        }
        AppMethodBeat.m2505o(105018);
    }

    /* renamed from: a */
    public static void m5829a(int i, C28575a c28575a) {
        AppMethodBeat.m2504i(105019);
        if (c28575a == null) {
            C4990ab.m7412e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
            AppMethodBeat.m2505o(105019);
            return;
        }
        C4990ab.m7417i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", Integer.valueOf(c28575a.field_musicType), Integer.valueOf(i), c28575a.field_songWifiUrl, c28575a.field_songName, c28575a.field_songSinger);
        C7060h.pYm.mo8381e(15106, Integer.valueOf(c28575a.field_musicType), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), c28575a.field_songWifiUrl, c28575a.field_songName, c28575a.field_songSinger);
        AppMethodBeat.m2505o(105019);
    }

    /* renamed from: s */
    public static void m5833s(C9058e c9058e) {
        AppMethodBeat.m2504i(105020);
        if (c9058e == null) {
            C4990ab.m7412e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
            AppMethodBeat.m2505o(105020);
            return;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey2.SetValue(1);
        iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey2.SetValue(1);
        iDKey2.SetKey(10);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(105020);
    }
}
