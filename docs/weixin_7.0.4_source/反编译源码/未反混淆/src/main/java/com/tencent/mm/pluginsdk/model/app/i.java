package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.s;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class i extends j<f> {
    public static final String[] fnj = new String[]{j.a(f.ccO, "AppInfo")};
    public final f<String, f> vcc = new c(50);

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(79325);
        boolean n = n((f) cVar);
        AppMethodBeat.o(79325);
        return n;
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        AppMethodBeat.i(79323);
        boolean a = a((f) cVar, strArr);
        AppMethodBeat.o(79323);
        return a;
    }

    static {
        AppMethodBeat.i(79326);
        AppMethodBeat.o(79326);
    }

    public i(e eVar) {
        super(eVar, f.ccO, "AppInfo", s.diI);
        AppMethodBeat.i(79309);
        com.tencent.mm.sdk.e.c fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        if (!super.b(fVar, new String[0])) {
            fVar = new f();
            fVar.field_appId = "wx4310bbd51be7d979";
            fVar.field_appName = "weixinfile";
            fVar.field_packageName = "com.tencent.mm.openapi";
            fVar.field_status = -1;
            super.b(fVar);
        }
        AppMethodBeat.o(79309);
    }

    private void m(f fVar) {
        AppMethodBeat.i(79310);
        if (fVar == null || fVar.field_appId == null) {
            AppMethodBeat.o(79310);
            return;
        }
        this.vcc.k(fVar.field_appId, fVar);
        AppMethodBeat.o(79310);
    }

    private void MQ(String str) {
        AppMethodBeat.i(79311);
        if (!bo.isNullOrNil(str)) {
            this.vcc.remove(str);
        }
        AppMethodBeat.o(79311);
    }

    public final boolean n(f fVar) {
        AppMethodBeat.i(79312);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79312);
            return false;
        }
        if (f.vbQ.equals(fVar.field_appId) || f.vbS.equals(fVar.field_appId)) {
            ab.i("MicroMsg.AppInfoStorage", "insert appinfo: %s, %s, %s, %s, %s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_serviceShowFlag), Integer.valueOf(fVar.field_appInfoFlag), bo.dpG());
        }
        if (super.a((com.tencent.mm.sdk.e.c) fVar, false)) {
            b(fVar.field_appId, 2, fVar.field_appId);
            m(fVar);
            AppMethodBeat.o(79312);
            return true;
        }
        AppMethodBeat.o(79312);
        return false;
    }

    public final boolean a(f fVar, String... strArr) {
        boolean z = false;
        AppMethodBeat.i(79313);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79313);
        } else {
            if (f.vbQ.equals(fVar.field_appId) || f.vbS.equals(fVar.field_appId)) {
                ab.i("MicroMsg.AppInfoStorage", "update appinfo: %s, %s, %s, %s, %s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_serviceShowFlag), Integer.valueOf(fVar.field_appInfoFlag), bo.dpG());
            }
            MQ(fVar.field_appId);
            z = super.b(fVar, false, strArr);
            if (z) {
                b(fVar.field_appId, 3, fVar.field_appId);
            }
            AppMethodBeat.o(79313);
        }
        return z;
    }

    public final boolean b(f fVar, String... strArr) {
        boolean z = false;
        AppMethodBeat.i(79314);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79314);
        } else {
            if (f.vbQ.equals(fVar.field_appId) || f.vbS.equals(fVar.field_appId)) {
                ab.i("MicroMsg.AppInfoStorage", "delete appinfo: %s, %s, %s, %s, %s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_serviceShowFlag), Integer.valueOf(fVar.field_appInfoFlag), bo.dpG());
            }
            MQ(fVar.field_appId);
            z = super.a((com.tencent.mm.sdk.e.c) fVar, false, strArr);
            if (z) {
                b(fVar.field_appId, 5, fVar.field_appId);
            }
            AppMethodBeat.o(79314);
        }
        return z;
    }

    public final List<String> dhD() {
        AppMethodBeat.i(79315);
        ab.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.AppInfoStorage", "get null cursor");
            AppMethodBeat.o(79315);
        } else {
            int count = rawQuery.getCount();
            if (count <= 0) {
                ab.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = ".concat(String.valueOf(count)));
                rawQuery.close();
                AppMethodBeat.o(79315);
            } else {
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        count = rawQuery.getColumnIndex("appId");
                        if (count >= 0) {
                            String string = rawQuery.getString(count);
                            if (!bo.isNullOrNil(string)) {
                                arrayList.add(string);
                            }
                        }
                        rawQuery.moveToNext();
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(79315);
            }
        }
        return arrayList;
    }

    public final f aiJ(String str) {
        AppMethodBeat.i(79316);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoStorage", "appId is null");
            AppMethodBeat.o(79316);
            return null;
        }
        f fVar = (f) this.vcc.ai(str);
        if (fVar == null) {
            fVar = null;
        }
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            com.tencent.mm.sdk.e.c fVar2 = new f();
            fVar2.field_appId = str;
            if (super.b(fVar2, new String[0])) {
                m(fVar2);
                AppMethodBeat.o(79316);
                return fVar2;
            }
            AppMethodBeat.o(79316);
            return null;
        }
        AppMethodBeat.o(79316);
        return fVar;
    }

    public final Cursor eQ(int i, int i2) {
        AppMethodBeat.i(79317);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        if (i != 0) {
            stringBuilder.append(" ( serviceAppInfoFlag & ").append(i).append(" ) != 0 and ");
        }
        stringBuilder.append(" ( serviceShowFlag & ").append(i2).append(" ) != 0");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
            AppMethodBeat.o(79317);
            return null;
        }
        ab.i("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        AppMethodBeat.o(79317);
        return rawQuery;
    }

    public final Cursor dhE() {
        AppMethodBeat.i(79318);
        Cursor rawQuery = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
            AppMethodBeat.o(79318);
            return null;
        }
        AppMethodBeat.o(79318);
        return rawQuery;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String dY(String str, int i) {
        int i2 = 0;
        AppMethodBeat.i(79319);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
            AppMethodBeat.o(79319);
            return null;
        }
        b bVar = new b(a.bYG());
        if (!bVar.exists()) {
            if (!bVar.dMC().exists()) {
                b dMC = bVar.dMC();
                b bVar2 = new b(com.tencent.mm.vfs.j.w(dMC.dMD()) + System.currentTimeMillis());
                if (bVar2.mkdirs()) {
                    bVar2.o(dMC);
                } else {
                    ab.e("MicroMsg.AppInfoStorage", "mkdir error, %s", com.tencent.mm.vfs.j.w(dMC.dMD()));
                    if (i2 == 0) {
                        AppMethodBeat.o(79319);
                        return null;
                    }
                    String str2;
                    switch (i) {
                        case 1:
                            str2 = a.bYG() + g.x(str.getBytes()) + ".png";
                            AppMethodBeat.o(79319);
                            return str2;
                        case 2:
                            str2 = a.bYG() + g.x(str.getBytes()) + "_wm.png";
                            AppMethodBeat.o(79319);
                            return str2;
                        case 3:
                            str2 = a.bYG() + g.x(str.getBytes()) + "_sg.png";
                            AppMethodBeat.o(79319);
                            return str2;
                        case 4:
                            str2 = a.bYG() + g.x(str.getBytes()) + "_sp.png";
                            AppMethodBeat.o(79319);
                            return str2;
                        case 5:
                            str2 = a.bYG() + g.x(str.getBytes()) + "_sl.png";
                            AppMethodBeat.o(79319);
                            return str2;
                        default:
                            ab.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = ".concat(String.valueOf(i)));
                            AppMethodBeat.o(79319);
                            return null;
                    }
                }
            }
            if (!(bVar.mkdirs() && bVar.isDirectory())) {
                ab.e("MicroMsg.AppInfoStorage", "mkdir error. %s", r3);
                if (i2 == 0) {
                }
            }
        }
        i2 = 1;
        if (i2 == 0) {
        }
    }

    public final boolean t(String str, Bitmap bitmap) {
        AppMethodBeat.i(79320);
        if (str == null || str.length() == 0 || bitmap == null || bitmap.isRecycled()) {
            ab.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
            AppMethodBeat.o(79320);
            return false;
        }
        String dY = dY(str, 1);
        if (dY == null) {
            ab.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            AppMethodBeat.o(79320);
            return false;
        }
        b bVar = new b(dY);
        if (bVar.exists()) {
            bVar.delete();
        }
        try {
            OutputStream q = com.tencent.mm.vfs.e.q(bVar);
            bitmap.compress(CompressFormat.PNG, 100, q);
            q.close();
            anF(str);
            AppMethodBeat.o(79320);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
            ab.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
            AppMethodBeat.o(79320);
            return false;
        }
    }

    public final boolean e(String str, byte[] bArr, int i) {
        AppMethodBeat.i(79321);
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            ab.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
            AppMethodBeat.o(79321);
            return false;
        }
        String dY = dY(str, i);
        if (dY == null) {
            ab.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            AppMethodBeat.o(79321);
            return false;
        }
        b bVar = new b(dY);
        if (bVar.exists()) {
            bVar.delete();
        }
        OutputStream outputStream = null;
        try {
            outputStream = com.tencent.mm.vfs.e.q(bVar);
            outputStream.write(bArr);
            outputStream.close();
            anF(str);
            AppMethodBeat.o(79321);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
            ab.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(79321);
            return false;
        }
    }

    public static f dhF() {
        AppMethodBeat.i(79322);
        f fVar = new f();
        fVar.field_appName = "invalid_appname";
        fVar.field_packageName = "";
        fVar.field_signature = "";
        fVar.field_status = 3;
        AppMethodBeat.o(79322);
        return fVar;
    }
}
