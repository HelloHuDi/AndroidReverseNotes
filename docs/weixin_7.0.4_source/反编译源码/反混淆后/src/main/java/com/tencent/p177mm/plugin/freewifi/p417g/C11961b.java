package com.tencent.p177mm.plugin.freewifi.p417g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.freewifi.g.b */
public final class C11961b extends C7563j<C11960a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C11960a.ccO, "FreeWifiConfig"), "CREATE INDEX IF NOT EXISTS idx_freewificonfig_key  on FreeWifiConfig  (  key )"};
    public static Map<String, String> mxL = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(20878);
        AppMethodBeat.m2505o(20878);
    }

    public C11961b(C4927e c4927e) {
        super(c4927e, C11960a.ccO, "FreeWifiConfig", null);
    }

    public final String bzw() {
        String message;
        AppMethodBeat.m2504i(20874);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key\tvalue\tmodifyTime\r\n");
        Cursor rawQuery = rawQuery("select key, value, modifyTime from FreeWifiConfig", new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                stringBuilder.append(rawQuery.getString(0)).append("\t").append(rawQuery.getString(1)).append("\t").append(rawQuery.getLong(2)).append(IOUtils.LINE_SEPARATOR_WINDOWS);
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + e.getMessage());
                message = e.getMessage();
            } finally {
                rawQuery.close();
                AppMethodBeat.m2505o(20874);
            }
        }
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + stringBuilder.toString());
        message = stringBuilder.toString();
        return message;
    }

    /* renamed from: MJ */
    public final String mo23801MJ(String str) {
        AppMethodBeat.m2504i(20875);
        String str2;
        if (C34189m.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(20875);
            return str2;
        }
        try {
            if (mxL != null) {
                str2 = (String) mxL.get(str);
                if (str2 != null) {
                    AppMethodBeat.m2505o(20875);
                    return str2;
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map get error!");
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
        if (rawQuery == null) {
            str2 = "";
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(20875);
            return str2;
        }
        try {
            if (rawQuery.moveToFirst()) {
                C11960a c11960a = new C11960a();
                c11960a.mo8995d(rawQuery);
                str2 = c11960a.field_value;
                return str2;
            }
            str2 = "";
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(20875);
            return str2;
        } finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.m2505o(20875);
        }
    }

    /* renamed from: et */
    public final void mo23804et(String str, String str2) {
        AppMethodBeat.m2504i(20876);
        if (C34189m.isEmpty(str) || C34189m.isEmpty(str2)) {
            AppMethodBeat.m2505o(20876);
            return;
        }
        try {
            if (mxL != null) {
                if (mxL.size() < 1000) {
                    mxL.put(str, str2);
                } else {
                    mxL.clear();
                    mxL.put(str, str2);
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map put error!");
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
        try {
            C11960a c11960a = new C11960a();
            c11960a.field_key = str;
            c11960a.field_value = str2;
            c11960a.field_modifyTime = System.currentTimeMillis();
            if (rawQuery.getCount() == 0) {
                mo10101b((C4925c) c11960a);
            } else {
                mo10103c(c11960a, new String[0]);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(20876);
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.m2505o(20876);
        }
    }

    public final void axQ() {
        AppMethodBeat.m2504i(20877);
        if (mxL != null) {
            mxL.clear();
        }
        super.mo16768hY("FreeWifiConfig", "delete from FreeWifiConfig");
        AppMethodBeat.m2505o(20877);
    }
}
