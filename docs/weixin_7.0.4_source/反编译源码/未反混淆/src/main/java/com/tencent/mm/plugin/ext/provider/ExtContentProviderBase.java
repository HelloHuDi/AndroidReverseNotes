package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean jDQ = false;
    private static HashMap<String, Long> lPZ = new HashMap();
    protected MatrixCursor jDN = new MatrixCursor(new String[0]);
    private long lPU = bo.yz();
    private String lPV;
    public String lPW = "";
    private String[] lPX;
    private int lPY = 0;

    public ExtContentProviderBase() {
        AppMethodBeat.i(20326);
        AppMethodBeat.o(20326);
    }

    static {
        AppMethodBeat.i(20340);
        AppMethodBeat.o(20340);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void vf(int i) {
        AppMethodBeat.i(20327);
        ab.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()));
        h.pYm.e(10505, brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()));
        AppMethodBeat.o(20327);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dZ(int i, int i2) {
        AppMethodBeat.i(20328);
        ab.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()));
        h.pYm.e(10505, brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()), Integer.valueOf(i2));
        AppMethodBeat.o(20328);
    }

    /* Access modifiers changed, original: protected|final */
    public final void T(int i, int i2, int i3) {
        AppMethodBeat.i(20329);
        ab.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i2), Integer.valueOf(brK()));
        h.pYm.e(10505, brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i2), Integer.valueOf(brK()), Integer.valueOf(i3));
        h.pYm.a(300, (long) i, 1, false);
        AppMethodBeat.o(20329);
    }

    private int brK() {
        AppMethodBeat.i(20330);
        int az = (int) bo.az(this.lPU);
        AppMethodBeat.o(20330);
        return az;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Uri uri, Context context, UriMatcher uriMatcher) {
        AppMethodBeat.i(20331);
        this.lPW = p(uri);
        dK(context);
        if (uriMatcher != null) {
            this.lPY = uriMatcher.match(uri);
            if (this.lPY < 0) {
                this.lPY = 0;
            }
        }
        this.lPU = bo.yz();
        AppMethodBeat.o(20331);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Uri uri, Context context, int i) {
        AppMethodBeat.i(20332);
        this.lPW = p(uri);
        dK(context);
        this.lPY = i;
        this.lPU = bo.yz();
        AppMethodBeat.o(20332);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Uri uri, Context context, int i, String[] strArr) {
        AppMethodBeat.i(20333);
        this.lPW = p(uri);
        if (strArr == null) {
            dK(context);
        } else {
            this.lPX = strArr;
        }
        this.lPY = i;
        this.lPU = bo.yz();
        AppMethodBeat.o(20333);
    }

    /* Access modifiers changed, original: protected|final */
    public final String brL() {
        AppMethodBeat.i(20334);
        String str;
        if (!bo.isNullOrNil(this.lPV)) {
            str = this.lPV;
            AppMethodBeat.o(20334);
            return str;
        } else if (this.lPX == null || this.lPX.length <= 0) {
            str = "";
            AppMethodBeat.o(20334);
            return str;
        } else {
            str = this.lPX[0];
            AppMethodBeat.o(20334);
            return str;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aVl() {
        boolean z = false;
        AppMethodBeat.i(20335);
        try {
            ab.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!jDQ) {
                final b bVar = new b();
                bVar.b(4000, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20325);
                        try {
                            if (aw.RK()) {
                                aw.Rg().a(new bk(new a() {
                                    public final void a(e eVar) {
                                        AppMethodBeat.i(20324);
                                        ab.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                                        bVar.countDown();
                                        AppMethodBeat.o(20324);
                                    }
                                }), 0);
                                AppMethodBeat.o(20325);
                                return;
                            }
                            AppMethodBeat.o(20325);
                        } catch (Exception e) {
                            ab.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                            AppMethodBeat.o(20325);
                        }
                    }
                });
            }
            if (aw.RK() && aw.ZM() && !aw.QT()) {
                jDQ = true;
            } else {
                jDQ = false;
            }
            ab.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + jDQ);
            z = jDQ;
            AppMethodBeat.o(20335);
        } catch (Exception e) {
            ab.w("MicroMsg.ExtContentProviderBase", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
            AppMethodBeat.o(20335);
        }
        return z;
    }

    private static String p(Uri uri) {
        AppMethodBeat.i(20336);
        String str;
        if (uri == null) {
            str = "";
            AppMethodBeat.o(20336);
            return str;
        }
        str = bo.nullAsNil(uri.getQueryParameter("appid"));
        AppMethodBeat.o(20336);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dJ(Context context) {
        boolean z;
        Exception e;
        boolean z2;
        AppMethodBeat.i(20337);
        if (context == null) {
            ab.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            AppMethodBeat.o(20337);
            return false;
        } else if (bo.isNullOrNil(this.lPW)) {
            ab.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            AppMethodBeat.o(20337);
            return false;
        } else if (this.lPX == null || this.lPX.length <= 0) {
            ab.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            AppMethodBeat.o(20337);
            return false;
        } else {
            try {
                f bT = g.bT(this.lPW, true);
                if (bT == null) {
                    ab.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    AppMethodBeat.o(20337);
                    return false;
                }
                boolean z3;
                if (bT.field_status == 3) {
                    ab.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", bT.field_packageName);
                    z3 = false;
                } else {
                    for (String str : this.lPX) {
                        if (str.equals(bT.field_packageName) && p.a(ah.getContext(), bT, str, false)) {
                            ab.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.lPV = str;
                                z = true;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                z2 = true;
                                ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                                ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                                AppMethodBeat.o(20337);
                                return z2;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        try {
                            Integer num = (Integer) c.b.val.get(Integer.valueOf(this.lPY));
                            if (num == null) {
                                num = Integer.valueOf(64);
                            }
                            if (g.b(bT, num.intValue())) {
                                ab.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                            } else {
                                z3 = false;
                            }
                        } catch (Exception e22) {
                            e = e22;
                            z2 = z;
                            ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                            AppMethodBeat.o(20337);
                            return z2;
                        }
                    }
                    z3 = z;
                }
                try {
                    ab.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(bo.a((Long) lPZ.get(this.lPW), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(bo.a((Long) lPZ.get(this.lPW), 0)).longValue() > 3600000) {
                        ab.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.lPW);
                        com.tencent.mm.plugin.s.a.a.a.bYQ().Us(this.lPW);
                        lPZ.put(this.lPW, Long.valueOf(System.currentTimeMillis()));
                    }
                    z2 = z3;
                } catch (Exception e3) {
                    e = e3;
                    z2 = z3;
                    ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                    AppMethodBeat.o(20337);
                    return z2;
                }
                AppMethodBeat.o(20337);
                return z2;
            } catch (Exception e222) {
                e = e222;
                z2 = false;
                ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                AppMethodBeat.o(20337);
                return z2;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int brM() {
        int i;
        Exception e;
        AppMethodBeat.i(20338);
        if (bo.isNullOrNil(this.lPW)) {
            ab.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            AppMethodBeat.o(20338);
            return 7;
        } else if (this.lPX == null || this.lPX.length <= 0) {
            ab.e("MicroMsg.ExtContentProviderBase", "packageList is null");
            AppMethodBeat.o(20338);
            return 6;
        } else {
            int i2;
            try {
                f bT = g.bT(this.lPW, true);
                if (bT == null) {
                    ab.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    AppMethodBeat.o(20338);
                    return 13;
                }
                int i3;
                if (bT.field_status == 3) {
                    ab.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", bT.field_packageName);
                    i3 = 10;
                } else {
                    for (String str : this.lPX) {
                        if (str.equals(bT.field_packageName) && p.a(ah.getContext(), bT, str, false)) {
                            ab.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.lPV = str;
                                i = 1;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                i2 = 1;
                                ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                                ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                                AppMethodBeat.o(20338);
                                return i2;
                            }
                        }
                    }
                    i = 0;
                    if (i == 1) {
                        try {
                            Integer num = (Integer) c.b.val.get(Integer.valueOf(this.lPY));
                            if (num == null) {
                                dZ(5, 16);
                                ab.i("MicroMsg.ExtContentProviderBase", "api flag = null");
                                num = Integer.valueOf(64);
                            }
                            if (g.b(bT, num.intValue())) {
                                ab.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                            } else {
                                i3 = 11;
                            }
                        } catch (Exception e22) {
                            e = e22;
                            i2 = i;
                            ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                            AppMethodBeat.o(20338);
                            return i2;
                        }
                    }
                    i3 = i;
                }
                try {
                    ab.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(bo.a((Long) lPZ.get(this.lPW), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(bo.a((Long) lPZ.get(this.lPW), 0)).longValue() > 3600000) {
                        ab.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.lPW);
                        com.tencent.mm.plugin.s.a.a.a.bYQ().Us(this.lPW);
                        lPZ.put(this.lPW, Long.valueOf(System.currentTimeMillis()));
                    }
                    i2 = i3;
                } catch (Exception e3) {
                    e = e3;
                    i2 = i3;
                    ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                    AppMethodBeat.o(20338);
                    return i2;
                }
                AppMethodBeat.o(20338);
                return i2;
            } catch (Exception e222) {
                e = e222;
                i2 = 0;
                ab.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                AppMethodBeat.o(20338);
                return i2;
            }
        }
    }

    private void dK(Context context) {
        AppMethodBeat.i(20339);
        if (context == null) {
            ab.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            AppMethodBeat.o(20339);
            return;
        }
        ab.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.lPX = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.lPX == null) {
            ab.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
        AppMethodBeat.o(20339);
    }
}
