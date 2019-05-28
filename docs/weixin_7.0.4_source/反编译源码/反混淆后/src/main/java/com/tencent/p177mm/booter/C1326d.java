package com.tencent.p177mm.booter;

import android.content.Context;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p267p.C1941a.C1940a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4992ac;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.xlog.app.XLogSetup;
import java.util.HashMap;

/* renamed from: com.tencent.mm.booter.d */
public final class C1326d {
    private static C1326d ebP;
    private final String[] columns = new String[]{"_id", "key", "type", "value"};
    private Context ctx;
    public int ebO = -1;
    private final HashMap<String, Object> values = new HashMap();

    /* renamed from: com.tencent.mm.booter.d$a */
    public static final class C1325a {
        /* renamed from: j */
        public static Object m2838j(int i, String str) {
            AppMethodBeat.m2504i(57753);
            Object valueOf;
            switch (i) {
                case 1:
                    valueOf = Integer.valueOf(str);
                    AppMethodBeat.m2505o(57753);
                    return valueOf;
                case 2:
                    valueOf = Long.valueOf(str);
                    AppMethodBeat.m2505o(57753);
                    return valueOf;
                case 3:
                    AppMethodBeat.m2505o(57753);
                    return str;
                case 4:
                    valueOf = Boolean.valueOf(str);
                    AppMethodBeat.m2505o(57753);
                    return valueOf;
                case 5:
                    valueOf = Float.valueOf(str);
                    AppMethodBeat.m2505o(57753);
                    return valueOf;
                case 6:
                    valueOf = Double.valueOf(str);
                    AppMethodBeat.m2505o(57753);
                    return valueOf;
                default:
                    try {
                        C4990ab.m7412e("MicroMsg.Debugger.Resolver", "unknown type");
                        break;
                    } catch (Exception e) {
                        break;
                    }
            }
            AppMethodBeat.m2505o(57753);
            return null;
        }
    }

    /* renamed from: bo */
    public static C1326d m2839bo(Context context) {
        AppMethodBeat.m2504i(57754);
        if (ebP == null) {
            ebP = new C1326d(context);
        }
        C1326d c1326d = ebP;
        AppMethodBeat.m2505o(57754);
        return c1326d;
    }

    private C1326d(Context context) {
        Cursor query;
        AppMethodBeat.m2504i(57755);
        this.ctx = context;
        try {
            query = context.getContentResolver().query(C1940a.CONTENT_URI, this.columns, null, null, null);
        } catch (Exception e) {
            query = null;
        }
        if (query == null) {
            AppMethodBeat.m2505o(57755);
        } else if (query.getCount() <= 0) {
            query.close();
            AppMethodBeat.m2505o(57755);
        } else if ("18c867f0717aa67b2ab7347505ba07ed".equals(C5046bo.m7573l("com.tencent.mm.coolassist", context))) {
            C4872b.dnN();
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), C1325a.m2838j(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            AppMethodBeat.m2505o(57755);
        } else {
            query.close();
            AppMethodBeat.m2505o(57755);
        }
    }

    /* renamed from: jE */
    public final void mo4656jE(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(57756);
        Integer integer = getInteger(".com.tencent.mm.debug.log.level");
        boolean a = C5046bo.m7517a(mo4657jF(".com.tencent.mm.debug.log.append_mode"), false);
        boolean z2 = C5046bo.isNullOrNil(getString(".com.tencent.mm.debug.log.mmlog")) && C5046bo.m7517a(mo4657jF(".com.tencent.mm.debug.test.uploadLog"), false);
        if (z2) {
            String string = getString(".com.tencent.mm.debug.log.tag.skey");
            if (string != null && string.length() > 0) {
                Xlog.logDecryptor = new C4992ac(string);
            }
        }
        boolean z3 = this.ctx.getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getBoolean("first_launch_weixin", true);
        if (!"MM".equalsIgnoreCase(str)) {
            z3 = false;
        }
        XLogSetup.keep_setupXLog(!z3, C5128ac.xIE, C6457e.euX, integer, Boolean.valueOf(a), Boolean.valueOf(z2), str);
        C4990ab.m7406LZ(C4990ab.getLogLevel());
        if (C5046bo.getInt(C5046bo.m7532bc(getString(".com.tencent.mm.debug.monkeyEnv"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        C5047bp.m7592pm(z3);
        C5047bp.dnM();
        if (getInteger(".com.tencent.mm.debug.log.level") != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        C5047bp.m7593pn(z3);
        if (C5047bp.dnM() || C5046bo.m7517a(mo4657jF(".com.tencent.mm.debug.blockReleasedPatch"), false)) {
            z = true;
        }
        C4872b.m7239pg(z);
        AppMethodBeat.m2505o(57756);
    }

    public final String getString(String str) {
        AppMethodBeat.m2504i(57757);
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            C4990ab.m7410d("MicroMsg.Debugger", "getString(): key=" + str + ", value=" + obj.toString());
            String str2 = (String) obj;
            AppMethodBeat.m2505o(57757);
            return str2;
        }
        AppMethodBeat.m2505o(57757);
        return null;
    }

    public final Integer getInteger(String str) {
        AppMethodBeat.m2504i(57758);
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            C4990ab.m7410d("MicroMsg.Debugger", "getInteger(): key=" + str + ", value=" + obj.toString());
            Integer num = (Integer) obj;
            AppMethodBeat.m2505o(57758);
            return num;
        }
        AppMethodBeat.m2505o(57758);
        return null;
    }

    /* renamed from: jF */
    public final Boolean mo4657jF(String str) {
        AppMethodBeat.m2504i(57759);
        Object obj = this.values.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(57759);
            return null;
        } else if (obj instanceof Boolean) {
            C4990ab.m7410d("MicroMsg.Debugger", "getBoolean(): key=" + str + ", value=" + obj.toString());
            Boolean bool = (Boolean) obj;
            AppMethodBeat.m2505o(57759);
            return bool;
        } else {
            AppMethodBeat.m2505o(57759);
            return null;
        }
    }
}
