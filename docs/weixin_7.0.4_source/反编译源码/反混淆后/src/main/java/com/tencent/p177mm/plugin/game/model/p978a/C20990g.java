package com.tencent.p177mm.plugin.game.model.p978a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.a.g */
public final class C20990g extends C7563j<C20985d> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C20985d.ccO, "GameSilentDownload")};

    static {
        AppMethodBeat.m2504i(111533);
        AppMethodBeat.m2505o(111533);
    }

    public C20990g(C4927e c4927e) {
        super(c4927e, C20985d.ccO, "GameSilentDownload", null);
    }

    public final C20985d bEY() {
        AppMethodBeat.m2504i(111523);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[]{"GameSilentDownload", "isRunning"}), new String[0]);
        C20985d c20985d;
        if (rawQuery == null) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
            AppMethodBeat.m2505o(111523);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c20985d = new C20985d();
            c20985d.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(111523);
            return c20985d;
        } else {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "no running task");
            rawQuery.close();
            rawQuery = rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[]{"GameSilentDownload", "nextCheckTime"}), String.valueOf(C5046bo.anT()));
            if (rawQuery == null) {
                C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
                AppMethodBeat.m2505o(111523);
                return null;
            } else if (rawQuery.moveToFirst()) {
                c20985d = new C20985d();
                c20985d.mo8995d(rawQuery);
                rawQuery.close();
                AppMethodBeat.m2505o(111523);
                return c20985d;
            } else {
                rawQuery.close();
                C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "no record");
                AppMethodBeat.m2505o(111523);
                return null;
            }
        }
    }

    /* renamed from: Ob */
    public final C20985d mo36303Ob(String str) {
        AppMethodBeat.m2504i(111524);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
            AppMethodBeat.m2505o(111524);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"GameSilentDownload", "appId"}), str);
        if (rawQuery == null) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            AppMethodBeat.m2505o(111524);
            return null;
        } else if (rawQuery.moveToFirst()) {
            C20985d c20985d = new C20985d();
            c20985d.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(111524);
            return c20985d;
        } else {
            C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", str);
            rawQuery.close();
            AppMethodBeat.m2505o(111524);
            return null;
        }
    }

    public final List<C20985d> bEZ() {
        List<C20985d> list = null;
        AppMethodBeat.m2504i(111525);
        Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"GameSilentDownload"}), new String[0]);
        if (rawQuery == null) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            AppMethodBeat.m2505o(111525);
        } else if (rawQuery.moveToFirst()) {
            list = new ArrayList();
            do {
                C20985d c20985d = new C20985d();
                c20985d.mo8995d(rawQuery);
                list.add(c20985d);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", Integer.valueOf(list.size()));
            AppMethodBeat.m2505o(111525);
        } else {
            rawQuery.close();
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
            AppMethodBeat.m2505o(111525);
        }
        return list;
    }

    /* renamed from: H */
    public final boolean mo36302H(String str, long j) {
        AppMethodBeat.m2504i(111526);
        if (C5046bo.isNullOrNil(str) || j < 0) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
            AppMethodBeat.m2505o(111526);
            return false;
        }
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", Boolean.valueOf(mo16768hY("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[]{"GameSilentDownload", "nextCheckTime", String.valueOf(j), "appId", str}))));
        AppMethodBeat.m2505o(111526);
        return mo16768hY("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[]{"GameSilentDownload", "nextCheckTime", String.valueOf(j), "appId", str}));
    }

    /* renamed from: aQ */
    public final boolean mo36309aQ(String str, boolean z) {
        AppMethodBeat.m2504i(111527);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
            AppMethodBeat.m2505o(111527);
            return false;
        }
        C20985d Ob = mo36303Ob(str);
        if (Ob == null) {
            AppMethodBeat.m2505o(111527);
            return false;
        }
        Ob.field_isRunning = z;
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", Boolean.valueOf(super.mo10103c(Ob, new String[0])));
        AppMethodBeat.m2505o(111527);
        return super.mo10103c(Ob, new String[0]);
    }

    /* renamed from: Oc */
    public final boolean mo36304Oc(String str) {
        AppMethodBeat.m2504i(111528);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
            AppMethodBeat.m2505o(111528);
            return false;
        }
        C20985d Ob = mo36303Ob(str);
        if (Ob == null) {
            AppMethodBeat.m2505o(111528);
            return false;
        }
        Ob.field_noWifi = false;
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", Boolean.valueOf(super.mo10103c(Ob, new String[0])));
        AppMethodBeat.m2505o(111528);
        return super.mo10103c(Ob, new String[0]);
    }

    /* renamed from: Od */
    public final boolean mo36305Od(String str) {
        AppMethodBeat.m2504i(111529);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
            AppMethodBeat.m2505o(111529);
            return false;
        }
        C20985d Ob = mo36303Ob(str);
        if (Ob == null) {
            AppMethodBeat.m2505o(111529);
            return false;
        }
        Ob.field_noSdcard = false;
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", Boolean.valueOf(super.mo10103c(Ob, new String[0])));
        AppMethodBeat.m2505o(111529);
        return super.mo10103c(Ob, new String[0]);
    }

    /* renamed from: Oe */
    public final boolean mo36306Oe(String str) {
        AppMethodBeat.m2504i(111530);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
            AppMethodBeat.m2505o(111530);
            return false;
        }
        C20985d Ob = mo36303Ob(str);
        if (Ob == null) {
            AppMethodBeat.m2505o(111530);
            return false;
        }
        Ob.field_noEnoughSpace = false;
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", Boolean.valueOf(super.mo10103c(Ob, new String[0])));
        AppMethodBeat.m2505o(111530);
        return super.mo10103c(Ob, new String[0]);
    }

    /* renamed from: Of */
    public final boolean mo36307Of(String str) {
        AppMethodBeat.m2504i(111531);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
            AppMethodBeat.m2505o(111531);
            return false;
        }
        C20985d Ob = mo36303Ob(str);
        if (Ob == null) {
            AppMethodBeat.m2505o(111531);
            return false;
        }
        Ob.field_lowBattery = false;
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", Boolean.valueOf(super.mo10103c(Ob, new String[0])));
        AppMethodBeat.m2505o(111531);
        return super.mo10103c(Ob, new String[0]);
    }

    /* renamed from: Og */
    public final boolean mo36308Og(String str) {
        AppMethodBeat.m2504i(111532);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
            AppMethodBeat.m2505o(111532);
            return false;
        }
        C20985d Ob = mo36303Ob(str);
        if (Ob == null) {
            AppMethodBeat.m2505o(111532);
            return false;
        }
        Ob.field_continueDelay = false;
        C4990ab.m7417i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", Boolean.valueOf(super.mo10103c(Ob, new String[0])));
        AppMethodBeat.m2505o(111532);
        return super.mo10103c(Ob, new String[0]);
    }
}
