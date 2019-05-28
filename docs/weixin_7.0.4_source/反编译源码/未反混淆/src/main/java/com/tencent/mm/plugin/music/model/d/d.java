package com.tencent.mm.plugin.music.model.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class d {
    public static long fqM;
    public static boolean oNi;
    public static boolean oNj;
    public static int oNk;
    public static int oNl;
    private static a oNm;
    public static int scene;

    public static final void ad(int i, int i2, int i3) {
        AppMethodBeat.i(105011);
        if (((e) b.ar(e.class)).bTU() != null) {
            ab.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", Integer.valueOf(13042), Integer.valueOf(i), Integer.valueOf(i2), ((e) b.ar(e.class)).bTU().field_musicId, ((e) b.ar(e.class)).bTU().field_songName, ((e) b.ar(e.class)).bTU().field_songAlbum, Integer.valueOf(((e) b.ar(e.class)).bTU().field_songId), Integer.valueOf(i3), ((e) b.ar(e.class)).bTU().field_songSinger, ((e) b.ar(e.class)).bTU().field_appId);
            h.pYm.e(13042, Integer.valueOf(i), Integer.valueOf(i2), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i3), r0.field_songSinger, r0.field_appId);
        }
        AppMethodBeat.o(105011);
    }

    public static final void eJ(int i, int i2) {
        AppMethodBeat.i(105012);
        if (((e) b.ar(e.class)).bTU() != null) {
            ab.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", Integer.valueOf(13232), ((e) b.ar(e.class)).bTU().field_musicId, ((e) b.ar(e.class)).bTU().field_songName, ((e) b.ar(e.class)).bTU().field_songAlbum, Integer.valueOf(((e) b.ar(e.class)).bTU().field_songId), Integer.valueOf(i2), Integer.valueOf(i), ((e) b.ar(e.class)).bTU().field_songSinger, ((e) b.ar(e.class)).bTU().field_appId);
            h.pYm.e(13232, r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i2), Integer.valueOf(i), r0.field_songSinger, r0.field_appId);
        }
        AppMethodBeat.o(105012);
    }

    public static synchronized void f(a aVar) {
        synchronized (d.class) {
            oNm = aVar;
        }
    }

    public static final synchronized void bUs() {
        int i = 1;
        synchronized (d.class) {
            AppMethodBeat.i(105013);
            if (oNm != null) {
                int i2;
                KX();
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
                ab.v(str, str2, objArr);
                h hVar = h.pYm;
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
                hVar.e(13044, objArr);
            }
            oNm = null;
            oNi = false;
            oNj = false;
            oNk = 0;
            oNl = 0;
            fqM = 0;
            scene = 0;
            AppMethodBeat.o(105013);
        }
    }

    public static final void KX() {
        AppMethodBeat.i(105014);
        if (fqM > 0) {
            oNl = (int) (((long) oNl) + ((System.currentTimeMillis() - fqM) / 1000));
            fqM = 0;
        }
        AppMethodBeat.o(105014);
    }

    public static final void bUt() {
        AppMethodBeat.i(105015);
        h.pYm.a(285, 4, 1, false);
        AppMethodBeat.o(105015);
    }

    public static final void zO(int i) {
        AppMethodBeat.i(105016);
        if (i == 2) {
            com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
            if (aih != null) {
                com.tencent.mm.plugin.fav.a.h.j(bo.getLong(aih.fKs, 0), 1, 0);
            }
        }
        AppMethodBeat.o(105016);
    }

    public static final void zP(int i) {
        AppMethodBeat.i(105017);
        if (i == 2) {
            com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
            if (aih != null) {
                com.tencent.mm.plugin.fav.a.h.j(bo.getLong(aih.fKs, 0), 0, 0);
            }
        }
        AppMethodBeat.o(105017);
    }

    public static final void zQ(int i) {
        AppMethodBeat.i(105018);
        if (((e) b.ar(e.class)).bTU() != null) {
            ab.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", Integer.valueOf(i), ((e) b.ar(e.class)).bTU().field_musicId, ((e) b.ar(e.class)).bTU().field_songName, ((e) b.ar(e.class)).bTU().field_songSinger, ((e) b.ar(e.class)).bTU().field_appId);
            h.pYm.e(12836, Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songSinger, r0.field_appId);
        }
        AppMethodBeat.o(105018);
    }

    public static void a(int i, a aVar) {
        AppMethodBeat.i(105019);
        if (aVar == null) {
            ab.e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
            AppMethodBeat.o(105019);
            return;
        }
        ab.i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", Integer.valueOf(aVar.field_musicType), Integer.valueOf(i), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger);
        h.pYm.e(15106, Integer.valueOf(aVar.field_musicType), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger);
        AppMethodBeat.o(105019);
    }

    public static void s(com.tencent.mm.aw.e eVar) {
        AppMethodBeat.i(105020);
        if (eVar == null) {
            ab.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
            AppMethodBeat.o(105020);
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
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(105020);
    }
}
