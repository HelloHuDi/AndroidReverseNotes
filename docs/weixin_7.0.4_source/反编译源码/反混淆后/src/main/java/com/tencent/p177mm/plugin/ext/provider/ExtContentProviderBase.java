package com.tencent.p177mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30033c.C14824b;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C46484b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtContentProviderBase */
public class ExtContentProviderBase extends ContentProvider {
    protected static boolean jDQ = false;
    private static HashMap<String, Long> lPZ = new HashMap();
    protected MatrixCursor jDN = new MatrixCursor(new String[0]);
    private long lPU = C5046bo.m7588yz();
    private String lPV;
    public String lPW = "";
    private String[] lPX;
    private int lPY = 0;

    public ExtContentProviderBase() {
        AppMethodBeat.m2504i(20326);
        AppMethodBeat.m2505o(20326);
    }

    static {
        AppMethodBeat.m2504i(20340);
        AppMethodBeat.m2505o(20340);
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
    /* renamed from: vf */
    public final void mo61890vf(int i) {
        AppMethodBeat.m2504i(20327);
        C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()));
        C7060h.pYm.mo8381e(10505, brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()));
        AppMethodBeat.m2505o(20327);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dZ */
    public final void mo61889dZ(int i, int i2) {
        AppMethodBeat.m2504i(20328);
        C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()));
        C7060h.pYm.mo8381e(10505, brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i), Integer.valueOf(brK()), Integer.valueOf(i2));
        AppMethodBeat.m2505o(20328);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: T */
    public final void mo61881T(int i, int i2, int i3) {
        AppMethodBeat.m2504i(20329);
        C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i2), Integer.valueOf(brK()));
        C7060h.pYm.mo8381e(10505, brL(), this.lPW, Integer.valueOf(this.lPY), Integer.valueOf(i2), Integer.valueOf(brK()), Integer.valueOf(i3));
        C7060h.pYm.mo8378a(300, (long) i, 1, false);
        AppMethodBeat.m2505o(20329);
    }

    private int brK() {
        AppMethodBeat.m2504i(20330);
        int az = (int) C5046bo.m7525az(this.lPU);
        AppMethodBeat.m2505o(20330);
        return az;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61884a(Uri uri, Context context, UriMatcher uriMatcher) {
        AppMethodBeat.m2504i(20331);
        this.lPW = ExtContentProviderBase.m66239p(uri);
        m66238dK(context);
        if (uriMatcher != null) {
            this.lPY = uriMatcher.match(uri);
            if (this.lPY < 0) {
                this.lPY = 0;
            }
        }
        this.lPU = C5046bo.m7588yz();
        AppMethodBeat.m2505o(20331);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61882a(Uri uri, Context context, int i) {
        AppMethodBeat.m2504i(20332);
        this.lPW = ExtContentProviderBase.m66239p(uri);
        m66238dK(context);
        this.lPY = i;
        this.lPU = C5046bo.m7588yz();
        AppMethodBeat.m2505o(20332);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo61883a(Uri uri, Context context, int i, String[] strArr) {
        AppMethodBeat.m2504i(20333);
        this.lPW = ExtContentProviderBase.m66239p(uri);
        if (strArr == null) {
            m66238dK(context);
        } else {
            this.lPX = strArr;
        }
        this.lPY = i;
        this.lPU = C5046bo.m7588yz();
        AppMethodBeat.m2505o(20333);
    }

    /* Access modifiers changed, original: protected|final */
    public final String brL() {
        AppMethodBeat.m2504i(20334);
        String str;
        if (!C5046bo.isNullOrNil(this.lPV)) {
            str = this.lPV;
            AppMethodBeat.m2505o(20334);
            return str;
        } else if (this.lPX == null || this.lPX.length <= 0) {
            str = "";
            AppMethodBeat.m2505o(20334);
            return str;
        } else {
            str = this.lPX[0];
            AppMethodBeat.m2505o(20334);
            return str;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aVl() {
        boolean z = false;
        AppMethodBeat.m2504i(20335);
        try {
            C4990ab.m7416i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
            if (!jDQ) {
                final C46484b c46484b = new C46484b();
                c46484b.mo74707b(4000, new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtContentProviderBase$1$1 */
                    class C68911 implements C1835a {
                        C68911() {
                        }

                        /* renamed from: a */
                        public final void mo4918a(C1902e c1902e) {
                            AppMethodBeat.m2504i(20324);
                            C4990ab.m7416i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                            c46484b.countDown();
                            AppMethodBeat.m2505o(20324);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(20325);
                        try {
                            if (C9638aw.m17179RK()) {
                                C9638aw.m17182Rg().mo14541a(new C6668bk(new C68911()), 0);
                                AppMethodBeat.m2505o(20325);
                                return;
                            }
                            AppMethodBeat.m2505o(20325);
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
                            c46484b.countDown();
                            AppMethodBeat.m2505o(20325);
                        }
                    }
                });
            }
            if (C9638aw.m17179RK() && C9638aw.m17192ZM() && !C9638aw.m17178QT()) {
                jDQ = true;
            } else {
                jDQ = false;
            }
            C4990ab.m7416i("MicroMsg.ExtContentProviderBase", "hasLogin = " + jDQ);
            z = jDQ;
            AppMethodBeat.m2505o(20335);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.ExtContentProviderBase", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
            AppMethodBeat.m2505o(20335);
        }
        return z;
    }

    /* renamed from: p */
    private static String m66239p(Uri uri) {
        AppMethodBeat.m2504i(20336);
        String str;
        if (uri == null) {
            str = "";
            AppMethodBeat.m2505o(20336);
            return str;
        }
        str = C5046bo.nullAsNil(uri.getQueryParameter("appid"));
        AppMethodBeat.m2505o(20336);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dJ */
    public final boolean mo61888dJ(Context context) {
        boolean z;
        Exception e;
        boolean z2;
        AppMethodBeat.m2504i(20337);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
            AppMethodBeat.m2505o(20337);
            return false;
        } else if (C5046bo.isNullOrNil(this.lPW)) {
            C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            AppMethodBeat.m2505o(20337);
            return false;
        } else if (this.lPX == null || this.lPX.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "packageList is null");
            AppMethodBeat.m2505o(20337);
            return false;
        } else {
            try {
                C40439f bT = C46494g.m87739bT(this.lPW, true);
                if (bT == null) {
                    C4990ab.m7420w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    AppMethodBeat.m2505o(20337);
                    return false;
                }
                boolean z3;
                if (bT.field_status == 3) {
                    C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", bT.field_packageName);
                    z3 = false;
                } else {
                    for (String str : this.lPX) {
                        if (str.equals(bT.field_packageName) && C35799p.m58686a(C4996ah.getContext(), bT, str, false)) {
                            C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.lPV = str;
                                z = true;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                z2 = true;
                                C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                                C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                                AppMethodBeat.m2505o(20337);
                                return z2;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        try {
                            Integer num = (Integer) C14824b.val.get(Integer.valueOf(this.lPY));
                            if (num == null) {
                                num = Integer.valueOf(64);
                            }
                            if (C46494g.m87737b(bT, num.intValue())) {
                                C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                            } else {
                                z3 = false;
                            }
                        } catch (Exception e22) {
                            e = e22;
                            z2 = z;
                            C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                            AppMethodBeat.m2505o(20337);
                            return z2;
                        }
                    }
                    z3 = z;
                }
                try {
                    C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(C5046bo.m7514a((Long) lPZ.get(this.lPW), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(C5046bo.m7514a((Long) lPZ.get(this.lPW), 0)).longValue() > 3600000) {
                        C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.lPW);
                        C3753a.bYQ().mo25135Us(this.lPW);
                        lPZ.put(this.lPW, Long.valueOf(System.currentTimeMillis()));
                    }
                    z2 = z3;
                } catch (Exception e3) {
                    e = e3;
                    z2 = z3;
                    C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                    AppMethodBeat.m2505o(20337);
                    return z2;
                }
                AppMethodBeat.m2505o(20337);
                return z2;
            } catch (Exception e222) {
                e = e222;
                z2 = false;
                C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                AppMethodBeat.m2505o(20337);
                return z2;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int brM() {
        int i;
        Exception e;
        AppMethodBeat.m2504i(20338);
        if (C5046bo.isNullOrNil(this.lPW)) {
            C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
            AppMethodBeat.m2505o(20338);
            return 7;
        } else if (this.lPX == null || this.lPX.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "packageList is null");
            AppMethodBeat.m2505o(20338);
            return 6;
        } else {
            int i2;
            try {
                C40439f bT = C46494g.m87739bT(this.lPW, true);
                if (bT == null) {
                    C4990ab.m7420w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
                    AppMethodBeat.m2505o(20338);
                    return 13;
                }
                int i3;
                if (bT.field_status == 3) {
                    C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", bT.field_packageName);
                    i3 = 10;
                } else {
                    for (String str : this.lPX) {
                        if (str.equals(bT.field_packageName) && C35799p.m58686a(C4996ah.getContext(), bT, str, false)) {
                            C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", str);
                            try {
                                this.lPV = str;
                                i = 1;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                i2 = 1;
                                C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                                C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                                AppMethodBeat.m2505o(20338);
                                return i2;
                            }
                        }
                    }
                    i = 0;
                    if (i == 1) {
                        try {
                            Integer num = (Integer) C14824b.val.get(Integer.valueOf(this.lPY));
                            if (num == null) {
                                mo61889dZ(5, 16);
                                C4990ab.m7416i("MicroMsg.ExtContentProviderBase", "api flag = null");
                                num = Integer.valueOf(64);
                            }
                            if (C46494g.m87737b(bT, num.intValue())) {
                                C4990ab.m7412e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
                            } else {
                                i3 = 11;
                            }
                        } catch (Exception e22) {
                            e = e22;
                            i2 = i;
                            C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                            AppMethodBeat.m2505o(20338);
                            return i2;
                        }
                    }
                    i3 = i;
                }
                try {
                    C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", Long.valueOf(C5046bo.m7514a((Long) lPZ.get(this.lPW), 0)), Long.valueOf(System.currentTimeMillis()));
                    if (System.currentTimeMillis() - Long.valueOf(C5046bo.m7514a((Long) lPZ.get(this.lPW), 0)).longValue() > 3600000) {
                        C4990ab.m7417i("MicroMsg.ExtContentProviderBase", "update appInfo %s", this.lPW);
                        C3753a.bYQ().mo25135Us(this.lPW);
                        lPZ.put(this.lPW, Long.valueOf(System.currentTimeMillis()));
                    }
                    i2 = i3;
                } catch (Exception e3) {
                    e = e3;
                    i2 = i3;
                    C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                    AppMethodBeat.m2505o(20338);
                    return i2;
                }
                AppMethodBeat.m2505o(20338);
                return i2;
            } catch (Exception e222) {
                e = e222;
                i2 = 0;
                C4990ab.m7413e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtContentProviderBase", e, "", new Object[0]);
                AppMethodBeat.m2505o(20338);
                return i2;
            }
        }
    }

    /* renamed from: dK */
    private void m66238dK(Context context) {
        AppMethodBeat.m2504i(20339);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
            AppMethodBeat.m2505o(20339);
            return;
        }
        C4990ab.m7416i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
        this.lPX = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (this.lPX == null) {
            C4990ab.m7420w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
        }
        AppMethodBeat.m2505o(20339);
    }
}
