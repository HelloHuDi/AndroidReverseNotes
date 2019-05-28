package com.tencent.mm.plugin.sport.model;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class n {
    private static o rPQ;
    private static final String[] rPR = new String[]{"_id", "_begin_time", "_end_time", "_mode", "_steps"};
    private static final Uri rPS = Uri.parse("content://com.miui.providers.steps/item");

    public static long cwC() {
        AppMethodBeat.i(93709);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(93709);
        return timeInMillis;
    }

    public static int cwD() {
        AppMethodBeat.i(93710);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        int i = (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 1 : 0;
        i += rawOffset / 3600;
        AppMethodBeat.o(93710);
        return i;
    }

    public static final String fQ(long j) {
        AppMethodBeat.i(93711);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        AppMethodBeat.o(93711);
        return format;
    }

    public static boolean Y(long j, long j2) {
        AppMethodBeat.i(93712);
        long j3 = 3600000;
        try {
            JSONObject optJSONObject = h.cwt().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                j3 = ((long) (optJSONObject.optInt("backgroundTimeInterval", 60) * 60)) * 1000;
            }
        } catch (Exception e) {
        }
        if (j2 - j >= j3) {
            AppMethodBeat.o(93712);
            return true;
        }
        AppMethodBeat.o(93712);
        return false;
    }

    public static boolean Z(long j, long j2) {
        int i = 500;
        AppMethodBeat.i(93713);
        if (j != 0 || j2 <= 0) {
            try {
                JSONObject optJSONObject = h.cwt().optJSONObject("stepCountUploadConfig");
                if (optJSONObject != null) {
                    i = optJSONObject.optInt("backgroundStepCountInterval", 500);
                }
            } catch (Exception e) {
            }
            if (j2 - j >= ((long) i)) {
                AppMethodBeat.o(93713);
                return true;
            }
            AppMethodBeat.o(93713);
            return false;
        }
        AppMethodBeat.o(93713);
        return true;
    }

    public static boolean eU(Context context) {
        AppMethodBeat.i(93714);
        if (d.fP(19)) {
            ab.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
            AppMethodBeat.o(93714);
            return false;
        } else if (!context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
            ab.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
            AppMethodBeat.o(93714);
            return false;
        } else if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(19) == null) {
            ab.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
            AppMethodBeat.o(93714);
            return false;
        } else if (h.cwt().optInt("deviceStepSwitch") != 1) {
            ab.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
            AppMethodBeat.o(93714);
            return false;
        } else {
            AppMethodBeat.o(93714);
            return true;
        }
    }

    public static boolean cwE() {
        AppMethodBeat.i(93715);
        if (h.cwt().optInt("checkWeSportInstall") != 1) {
            ab.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
            AppMethodBeat.o(93715);
            return false;
        }
        AppMethodBeat.o(93715);
        return true;
    }

    public static boolean cwF() {
        AppMethodBeat.i(93716);
        if (h.cwt().optInt("extStepApiSwitch") != 1) {
            ab.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
            AppMethodBeat.o(93716);
            return false;
        }
        AppMethodBeat.o(93716);
        return true;
    }

    public static boolean cvY() {
        boolean jh;
        AppMethodBeat.i(93717);
        ad aoO = ((j) g.K(j.class)).XM().aoO("gh_43f2581f6fd6");
        if (aoO != null) {
            jh = a.jh(aoO.field_type);
        } else {
            jh = false;
        }
        if (!jh) {
            ab.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", Boolean.valueOf(jh));
        }
        AppMethodBeat.o(93717);
        return jh;
    }

    public static void d(Activity activity, String str) {
        AppMethodBeat.i(93718);
        if (rPQ != null && rPQ.isShowing()) {
            AppMethodBeat.o(93718);
        } else if (k.aa(5, 1) == 0) {
            AppMethodBeat.o(93718);
        } else {
            if (r.Yz().equals(str) && !((b) g.K(b.class)).eU(ah.getContext())) {
                rPQ = t.a(activity, ah.getContext().getString(R.string.ern), new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(93708);
                        k.ab(5, 0);
                        AppMethodBeat.o(93708);
                    }
                });
            }
            AppMethodBeat.o(93718);
        }
    }

    public static void cwG() {
        AppMethodBeat.i(93719);
        if (rPQ != null) {
            rPQ.dismiss();
            rPQ = null;
        }
        AppMethodBeat.o(93719);
    }

    public static long[] ZV(String str) {
        AppMethodBeat.i(93720);
        String[] split = str.split(",");
        long[] jArr = new long[split.length];
        jArr[0] = bo.getLong(split[0], 0);
        jArr[1] = bo.getLong(split[1], 0);
        jArr[2] = bo.getLong(split[2], 0);
        jArr[3] = bo.getLong(split[3], 0);
        jArr[4] = bo.getLong(split[4], 0);
        jArr[5] = bo.getLong(split[5], 0);
        jArr[6] = bo.getLong(split[6], 0);
        AppMethodBeat.o(93720);
        return jArr;
    }

    static {
        AppMethodBeat.i(93722);
        AppMethodBeat.o(93722);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int cwH() {
        int i;
        Throwable e;
        Throwable th;
        AppMethodBeat.i(93721);
        Cursor cursor = null;
        Cursor query;
        try {
            if (com.tencent.mm.sdk.h.b.dqw()) {
                Class cls = Class.forName("miui.util.FeatureParser");
                Object newInstance = cls.newInstance();
                Method declaredMethod = cls.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(newInstance, new Object[]{"support_steps_provider", Boolean.FALSE});
                if ((invoke instanceof Boolean) && ((Boolean) invoke).booleanValue()) {
                    long cwC = cwC();
                    ContentResolver contentResolver = ah.getContext().getContentResolver();
                    if (contentResolver != null) {
                        query = contentResolver.query(rPS, rPR, "_begin_time >= ? AND _end_time <= ? AND (_mode = 2 OR _mode = 3)", new String[]{String.valueOf(cwC), String.valueOf(cwC + 86400000)}, "_id asc");
                        if (query != null) {
                            i = 0;
                            while (query.moveToNext()) {
                                try {
                                    i += query.getInt(4);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.Sport.SportUtil", e, "getMIUIStep", new Object[0]);
                                        if (query != null) {
                                        }
                                        ab.i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
                                        AppMethodBeat.o(93721);
                                        return i;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = query;
                                        if (cursor != null) {
                                        }
                                        AppMethodBeat.o(93721);
                                        throw th;
                                    }
                                }
                            }
                            cursor = query;
                        } else {
                            cursor = query;
                            i = 0;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        ab.i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
                        AppMethodBeat.o(93721);
                        return i;
                    }
                }
            }
            i = 0;
            if (cursor != null) {
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            i = 0;
            ab.printErrStackTrace("MicroMsg.Sport.SportUtil", e, "getMIUIStep", new Object[0]);
            if (query != null) {
                query.close();
            }
            ab.i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
            AppMethodBeat.o(93721);
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(93721);
            throw th;
        }
        ab.i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
        AppMethodBeat.o(93721);
        return i;
    }
}
