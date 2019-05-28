package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class g extends j<d> {
    public static final String[] fnj = new String[]{j.a(d.ccO, "GameSilentDownload")};

    static {
        AppMethodBeat.i(111533);
        AppMethodBeat.o(111533);
    }

    public g(e eVar) {
        super(eVar, d.ccO, "GameSilentDownload", null);
    }

    public final d bEY() {
        AppMethodBeat.i(111523);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[]{"GameSilentDownload", "isRunning"}), new String[0]);
        d dVar;
        if (rawQuery == null) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
            AppMethodBeat.o(111523);
            return null;
        } else if (rawQuery.moveToFirst()) {
            dVar = new d();
            dVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(111523);
            return dVar;
        } else {
            ab.i("MicroMsg.GameSilentDownloadStorage", "no running task");
            rawQuery.close();
            rawQuery = rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[]{"GameSilentDownload", "nextCheckTime"}), String.valueOf(bo.anT()));
            if (rawQuery == null) {
                ab.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
                AppMethodBeat.o(111523);
                return null;
            } else if (rawQuery.moveToFirst()) {
                dVar = new d();
                dVar.d(rawQuery);
                rawQuery.close();
                AppMethodBeat.o(111523);
                return dVar;
            } else {
                rawQuery.close();
                ab.i("MicroMsg.GameSilentDownloadStorage", "no record");
                AppMethodBeat.o(111523);
                return null;
            }
        }
    }

    public final d Ob(String str) {
        AppMethodBeat.i(111524);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
            AppMethodBeat.o(111524);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"GameSilentDownload", "appId"}), str);
        if (rawQuery == null) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            AppMethodBeat.o(111524);
            return null;
        } else if (rawQuery.moveToFirst()) {
            d dVar = new d();
            dVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(111524);
            return dVar;
        } else {
            ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", str);
            rawQuery.close();
            AppMethodBeat.o(111524);
            return null;
        }
    }

    public final List<d> bEZ() {
        List<d> list = null;
        AppMethodBeat.i(111525);
        Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"GameSilentDownload"}), new String[0]);
        if (rawQuery == null) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            AppMethodBeat.o(111525);
        } else if (rawQuery.moveToFirst()) {
            list = new ArrayList();
            do {
                d dVar = new d();
                dVar.d(rawQuery);
                list.add(dVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", Integer.valueOf(list.size()));
            AppMethodBeat.o(111525);
        } else {
            rawQuery.close();
            ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
            AppMethodBeat.o(111525);
        }
        return list;
    }

    public final boolean H(String str, long j) {
        AppMethodBeat.i(111526);
        if (bo.isNullOrNil(str) || j < 0) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
            AppMethodBeat.o(111526);
            return false;
        }
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", Boolean.valueOf(hY("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[]{"GameSilentDownload", "nextCheckTime", String.valueOf(j), "appId", str}))));
        AppMethodBeat.o(111526);
        return hY("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[]{"GameSilentDownload", "nextCheckTime", String.valueOf(j), "appId", str}));
    }

    public final boolean aQ(String str, boolean z) {
        AppMethodBeat.i(111527);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
            AppMethodBeat.o(111527);
            return false;
        }
        d Ob = Ob(str);
        if (Ob == null) {
            AppMethodBeat.o(111527);
            return false;
        }
        Ob.field_isRunning = z;
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", Boolean.valueOf(super.c(Ob, new String[0])));
        AppMethodBeat.o(111527);
        return super.c(Ob, new String[0]);
    }

    public final boolean Oc(String str) {
        AppMethodBeat.i(111528);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
            AppMethodBeat.o(111528);
            return false;
        }
        d Ob = Ob(str);
        if (Ob == null) {
            AppMethodBeat.o(111528);
            return false;
        }
        Ob.field_noWifi = false;
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", Boolean.valueOf(super.c(Ob, new String[0])));
        AppMethodBeat.o(111528);
        return super.c(Ob, new String[0]);
    }

    public final boolean Od(String str) {
        AppMethodBeat.i(111529);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
            AppMethodBeat.o(111529);
            return false;
        }
        d Ob = Ob(str);
        if (Ob == null) {
            AppMethodBeat.o(111529);
            return false;
        }
        Ob.field_noSdcard = false;
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", Boolean.valueOf(super.c(Ob, new String[0])));
        AppMethodBeat.o(111529);
        return super.c(Ob, new String[0]);
    }

    public final boolean Oe(String str) {
        AppMethodBeat.i(111530);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
            AppMethodBeat.o(111530);
            return false;
        }
        d Ob = Ob(str);
        if (Ob == null) {
            AppMethodBeat.o(111530);
            return false;
        }
        Ob.field_noEnoughSpace = false;
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", Boolean.valueOf(super.c(Ob, new String[0])));
        AppMethodBeat.o(111530);
        return super.c(Ob, new String[0]);
    }

    public final boolean Of(String str) {
        AppMethodBeat.i(111531);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
            AppMethodBeat.o(111531);
            return false;
        }
        d Ob = Ob(str);
        if (Ob == null) {
            AppMethodBeat.o(111531);
            return false;
        }
        Ob.field_lowBattery = false;
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", Boolean.valueOf(super.c(Ob, new String[0])));
        AppMethodBeat.o(111531);
        return super.c(Ob, new String[0]);
    }

    public final boolean Og(String str) {
        AppMethodBeat.i(111532);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
            AppMethodBeat.o(111532);
            return false;
        }
        d Ob = Ob(str);
        if (Ob == null) {
            AppMethodBeat.o(111532);
            return false;
        }
        Ob.field_continueDelay = false;
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", Boolean.valueOf(super.c(Ob, new String[0])));
        AppMethodBeat.o(111532);
        return super.c(Ob, new String[0]);
    }
}
