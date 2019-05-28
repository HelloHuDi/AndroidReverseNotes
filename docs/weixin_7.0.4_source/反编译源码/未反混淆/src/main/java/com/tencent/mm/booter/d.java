package com.tencent.mm.booter;

import android.content.Context;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class d {
    private static d ebP;
    private final String[] columns = new String[]{"_id", "key", "type", "value"};
    private Context ctx;
    public int ebO = -1;
    private final HashMap<String, Object> values = new HashMap();

    public static final class a {
        public static Object j(int i, String str) {
            AppMethodBeat.i(57753);
            Object valueOf;
            switch (i) {
                case 1:
                    valueOf = Integer.valueOf(str);
                    AppMethodBeat.o(57753);
                    return valueOf;
                case 2:
                    valueOf = Long.valueOf(str);
                    AppMethodBeat.o(57753);
                    return valueOf;
                case 3:
                    AppMethodBeat.o(57753);
                    return str;
                case 4:
                    valueOf = Boolean.valueOf(str);
                    AppMethodBeat.o(57753);
                    return valueOf;
                case 5:
                    valueOf = Float.valueOf(str);
                    AppMethodBeat.o(57753);
                    return valueOf;
                case 6:
                    valueOf = Double.valueOf(str);
                    AppMethodBeat.o(57753);
                    return valueOf;
                default:
                    try {
                        ab.e("MicroMsg.Debugger.Resolver", "unknown type");
                        break;
                    } catch (Exception e) {
                        break;
                    }
            }
            AppMethodBeat.o(57753);
            return null;
        }
    }

    public static d bo(Context context) {
        AppMethodBeat.i(57754);
        if (ebP == null) {
            ebP = new d(context);
        }
        d dVar = ebP;
        AppMethodBeat.o(57754);
        return dVar;
    }

    private d(Context context) {
        Cursor query;
        AppMethodBeat.i(57755);
        this.ctx = context;
        try {
            query = context.getContentResolver().query(com.tencent.mm.p.a.a.CONTENT_URI, this.columns, null, null, null);
        } catch (Exception e) {
            query = null;
        }
        if (query == null) {
            AppMethodBeat.o(57755);
        } else if (query.getCount() <= 0) {
            query.close();
            AppMethodBeat.o(57755);
        } else if ("18c867f0717aa67b2ab7347505ba07ed".equals(bo.l("com.tencent.mm.coolassist", context))) {
            b.dnN();
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), a.j(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            AppMethodBeat.o(57755);
        } else {
            query.close();
            AppMethodBeat.o(57755);
        }
    }

    public final void jE(String str) {
        boolean z = false;
        AppMethodBeat.i(57756);
        Integer integer = getInteger(".com.tencent.mm.debug.log.level");
        boolean a = bo.a(jF(".com.tencent.mm.debug.log.append_mode"), false);
        boolean z2 = bo.isNullOrNil(getString(".com.tencent.mm.debug.log.mmlog")) && bo.a(jF(".com.tencent.mm.debug.test.uploadLog"), false);
        if (z2) {
            String string = getString(".com.tencent.mm.debug.log.tag.skey");
            if (string != null && string.length() > 0) {
                Xlog.logDecryptor = new ac(string);
            }
        }
        boolean z3 = this.ctx.getSharedPreferences("system_config_prefs", h.Mu()).getBoolean("first_launch_weixin", true);
        if (!"MM".equalsIgnoreCase(str)) {
            z3 = false;
        }
        XLogSetup.keep_setupXLog(!z3, com.tencent.mm.storage.ac.xIE, e.euX, integer, Boolean.valueOf(a), Boolean.valueOf(z2), str);
        ab.LZ(ab.getLogLevel());
        if (bo.getInt(bo.bc(getString(".com.tencent.mm.debug.monkeyEnv"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        bp.pm(z3);
        bp.dnM();
        if (getInteger(".com.tencent.mm.debug.log.level") != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        bp.pn(z3);
        if (bp.dnM() || bo.a(jF(".com.tencent.mm.debug.blockReleasedPatch"), false)) {
            z = true;
        }
        b.pg(z);
        AppMethodBeat.o(57756);
    }

    public final String getString(String str) {
        AppMethodBeat.i(57757);
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            ab.d("MicroMsg.Debugger", "getString(): key=" + str + ", value=" + obj.toString());
            String str2 = (String) obj;
            AppMethodBeat.o(57757);
            return str2;
        }
        AppMethodBeat.o(57757);
        return null;
    }

    public final Integer getInteger(String str) {
        AppMethodBeat.i(57758);
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            ab.d("MicroMsg.Debugger", "getInteger(): key=" + str + ", value=" + obj.toString());
            Integer num = (Integer) obj;
            AppMethodBeat.o(57758);
            return num;
        }
        AppMethodBeat.o(57758);
        return null;
    }

    public final Boolean jF(String str) {
        AppMethodBeat.i(57759);
        Object obj = this.values.get(str);
        if (obj == null) {
            AppMethodBeat.o(57759);
            return null;
        } else if (obj instanceof Boolean) {
            ab.d("MicroMsg.Debugger", "getBoolean(): key=" + str + ", value=" + obj.toString());
            Boolean bool = (Boolean) obj;
            AppMethodBeat.o(57759);
            return bool;
        } else {
            AppMethodBeat.o(57759);
            return null;
        }
    }
}
