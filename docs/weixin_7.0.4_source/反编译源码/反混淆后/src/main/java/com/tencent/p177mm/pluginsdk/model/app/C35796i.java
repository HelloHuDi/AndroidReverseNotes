package com.tencent.p177mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p711c.C26315s;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.app.i */
public final class C35796i extends C7563j<C40439f> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C40439f.ccO, "AppInfo")};
    public final C1177f<String, C40439f> vcc = new C7598c(50);

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(79325);
        boolean n = mo56573n((C40439f) c4925c);
        AppMethodBeat.m2505o(79325);
        return n;
    }

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(79323);
        boolean a = mo56566a((C40439f) c4925c, strArr);
        AppMethodBeat.m2505o(79323);
        return a;
    }

    static {
        AppMethodBeat.m2504i(79326);
        AppMethodBeat.m2505o(79326);
    }

    public C35796i(C4927e c4927e) {
        super(c4927e, C40439f.ccO, "AppInfo", C26315s.diI);
        AppMethodBeat.m2504i(79309);
        C4925c c40439f = new C40439f();
        c40439f.field_appId = "wx4310bbd51be7d979";
        if (!super.mo10102b(c40439f, new String[0])) {
            c40439f = new C40439f();
            c40439f.field_appId = "wx4310bbd51be7d979";
            c40439f.field_appName = "weixinfile";
            c40439f.field_packageName = "com.tencent.mm.openapi";
            c40439f.field_status = -1;
            super.mo10101b(c40439f);
        }
        AppMethodBeat.m2505o(79309);
    }

    /* renamed from: m */
    private void m58671m(C40439f c40439f) {
        AppMethodBeat.m2504i(79310);
        if (c40439f == null || c40439f.field_appId == null) {
            AppMethodBeat.m2505o(79310);
            return;
        }
        this.vcc.mo4412k(c40439f.field_appId, c40439f);
        AppMethodBeat.m2505o(79310);
    }

    /* renamed from: MQ */
    private void m58669MQ(String str) {
        AppMethodBeat.m2504i(79311);
        if (!C5046bo.isNullOrNil(str)) {
            this.vcc.remove(str);
        }
        AppMethodBeat.m2505o(79311);
    }

    /* renamed from: n */
    public final boolean mo56573n(C40439f c40439f) {
        AppMethodBeat.m2504i(79312);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79312);
            return false;
        }
        if (C40439f.vbQ.equals(c40439f.field_appId) || C40439f.vbS.equals(c40439f.field_appId)) {
            C4990ab.m7417i("MicroMsg.AppInfoStorage", "insert appinfo: %s, %s, %s, %s, %s", c40439f.field_appId, c40439f.field_appName, Integer.valueOf(c40439f.field_serviceShowFlag), Integer.valueOf(c40439f.field_appInfoFlag), C5046bo.dpG());
        }
        if (super.mo16759a((C4925c) c40439f, false)) {
            mo15641b(c40439f.field_appId, 2, c40439f.field_appId);
            m58671m(c40439f);
            AppMethodBeat.m2505o(79312);
            return true;
        }
        AppMethodBeat.m2505o(79312);
        return false;
    }

    /* renamed from: a */
    public final boolean mo56566a(C40439f c40439f, String... strArr) {
        boolean z = false;
        AppMethodBeat.m2504i(79313);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79313);
        } else {
            if (C40439f.vbQ.equals(c40439f.field_appId) || C40439f.vbS.equals(c40439f.field_appId)) {
                C4990ab.m7417i("MicroMsg.AppInfoStorage", "update appinfo: %s, %s, %s, %s, %s", c40439f.field_appId, c40439f.field_appName, Integer.valueOf(c40439f.field_serviceShowFlag), Integer.valueOf(c40439f.field_appInfoFlag), C5046bo.dpG());
            }
            m58669MQ(c40439f.field_appId);
            z = super.mo16762b(c40439f, false, strArr);
            if (z) {
                mo15641b(c40439f.field_appId, 3, c40439f.field_appId);
            }
            AppMethodBeat.m2505o(79313);
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo56568b(C40439f c40439f, String... strArr) {
        boolean z = false;
        AppMethodBeat.m2504i(79314);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79314);
        } else {
            if (C40439f.vbQ.equals(c40439f.field_appId) || C40439f.vbS.equals(c40439f.field_appId)) {
                C4990ab.m7417i("MicroMsg.AppInfoStorage", "delete appinfo: %s, %s, %s, %s, %s", c40439f.field_appId, c40439f.field_appName, Integer.valueOf(c40439f.field_serviceShowFlag), Integer.valueOf(c40439f.field_appInfoFlag), C5046bo.dpG());
            }
            m58669MQ(c40439f.field_appId);
            z = super.mo10100a((C4925c) c40439f, false, strArr);
            if (z) {
                mo15641b(c40439f.field_appId, 5, c40439f.field_appId);
            }
            AppMethodBeat.m2505o(79314);
        }
        return z;
    }

    public final List<String> dhD() {
        AppMethodBeat.m2504i(79315);
        C4990ab.m7410d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "get null cursor");
            AppMethodBeat.m2505o(79315);
        } else {
            int count = rawQuery.getCount();
            if (count <= 0) {
                C4990ab.m7420w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = ".concat(String.valueOf(count)));
                rawQuery.close();
                AppMethodBeat.m2505o(79315);
            } else {
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        count = rawQuery.getColumnIndex("appId");
                        if (count >= 0) {
                            String string = rawQuery.getString(count);
                            if (!C5046bo.isNullOrNil(string)) {
                                arrayList.add(string);
                            }
                        }
                        rawQuery.moveToNext();
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(79315);
            }
        }
        return arrayList;
    }

    public final C40439f aiJ(String str) {
        AppMethodBeat.m2504i(79316);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "appId is null");
            AppMethodBeat.m2505o(79316);
            return null;
        }
        C40439f c40439f = (C40439f) this.vcc.mo4404ai(str);
        if (c40439f == null) {
            c40439f = null;
        }
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            C4925c c40439f2 = new C40439f();
            c40439f2.field_appId = str;
            if (super.mo10102b(c40439f2, new String[0])) {
                m58671m(c40439f2);
                AppMethodBeat.m2505o(79316);
                return c40439f2;
            }
            AppMethodBeat.m2505o(79316);
            return null;
        }
        AppMethodBeat.m2505o(79316);
        return c40439f;
    }

    /* renamed from: eQ */
    public final Cursor mo56572eQ(int i, int i2) {
        AppMethodBeat.m2504i(79317);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        if (i != 0) {
            stringBuilder.append(" ( serviceAppInfoFlag & ").append(i).append(" ) != 0 and ");
        }
        stringBuilder.append(" ( serviceShowFlag & ").append(i2).append(" ) != 0");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
            AppMethodBeat.m2505o(79317);
            return null;
        }
        C4990ab.m7417i("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        AppMethodBeat.m2505o(79317);
        return rawQuery;
    }

    public final Cursor dhE() {
        AppMethodBeat.m2504i(79318);
        Cursor rawQuery = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
            AppMethodBeat.m2505o(79318);
            return null;
        }
        AppMethodBeat.m2505o(79318);
        return rawQuery;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dY */
    public static String m58670dY(String str, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(79319);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
            AppMethodBeat.m2505o(79319);
            return null;
        }
        C5728b c5728b = new C5728b(C34832a.bYG());
        if (!c5728b.exists()) {
            if (!c5728b.dMC().exists()) {
                C5728b dMC = c5728b.dMC();
                C5728b c5728b2 = new C5728b(C5736j.m8649w(dMC.dMD()) + System.currentTimeMillis());
                if (c5728b2.mkdirs()) {
                    c5728b2.mo11675o(dMC);
                } else {
                    C4990ab.m7413e("MicroMsg.AppInfoStorage", "mkdir error, %s", C5736j.m8649w(dMC.dMD()));
                    if (i2 == 0) {
                        AppMethodBeat.m2505o(79319);
                        return null;
                    }
                    String str2;
                    switch (i) {
                        case 1:
                            str2 = C34832a.bYG() + C1178g.m2591x(str.getBytes()) + ".png";
                            AppMethodBeat.m2505o(79319);
                            return str2;
                        case 2:
                            str2 = C34832a.bYG() + C1178g.m2591x(str.getBytes()) + "_wm.png";
                            AppMethodBeat.m2505o(79319);
                            return str2;
                        case 3:
                            str2 = C34832a.bYG() + C1178g.m2591x(str.getBytes()) + "_sg.png";
                            AppMethodBeat.m2505o(79319);
                            return str2;
                        case 4:
                            str2 = C34832a.bYG() + C1178g.m2591x(str.getBytes()) + "_sp.png";
                            AppMethodBeat.m2505o(79319);
                            return str2;
                        case 5:
                            str2 = C34832a.bYG() + C1178g.m2591x(str.getBytes()) + "_sl.png";
                            AppMethodBeat.m2505o(79319);
                            return str2;
                        default:
                            C4990ab.m7412e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = ".concat(String.valueOf(i)));
                            AppMethodBeat.m2505o(79319);
                            return null;
                    }
                }
            }
            if (!(c5728b.mkdirs() && c5728b.isDirectory())) {
                C4990ab.m7413e("MicroMsg.AppInfoStorage", "mkdir error. %s", r3);
                if (i2 == 0) {
                }
            }
        }
        i2 = 1;
        if (i2 == 0) {
        }
    }

    /* renamed from: t */
    public final boolean mo56574t(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(79320);
        if (str == null || str.length() == 0 || bitmap == null || bitmap.isRecycled()) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
            AppMethodBeat.m2505o(79320);
            return false;
        }
        String dY = C35796i.m58670dY(str, 1);
        if (dY == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            AppMethodBeat.m2505o(79320);
            return false;
        }
        C5728b c5728b = new C5728b(dY);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        try {
            OutputStream q = C5730e.m8641q(c5728b);
            bitmap.compress(CompressFormat.PNG, 100, q);
            q.close();
            anF(str);
            AppMethodBeat.m2505o(79320);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
            AppMethodBeat.m2505o(79320);
            return false;
        }
    }

    /* renamed from: e */
    public final boolean mo56571e(String str, byte[] bArr, int i) {
        AppMethodBeat.m2504i(79321);
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
            AppMethodBeat.m2505o(79321);
            return false;
        }
        String dY = C35796i.m58670dY(str, i);
        if (dY == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            AppMethodBeat.m2505o(79321);
            return false;
        }
        C5728b c5728b = new C5728b(dY);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        OutputStream outputStream = null;
        try {
            outputStream = C5730e.m8641q(c5728b);
            outputStream.write(bArr);
            outputStream.close();
            anF(str);
            AppMethodBeat.m2505o(79321);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppInfoStorage", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(79321);
            return false;
        }
    }

    public static C40439f dhF() {
        AppMethodBeat.m2504i(79322);
        C40439f c40439f = new C40439f();
        c40439f.field_appName = "invalid_appname";
        c40439f.field_packageName = "";
        c40439f.field_signature = "";
        c40439f.field_status = 3;
        AppMethodBeat.m2505o(79322);
        return c40439f;
    }
}
