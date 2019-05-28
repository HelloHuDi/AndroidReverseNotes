package com.tencent.p177mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p213cd.C1359e;
import com.tencent.p177mm.p230g.p231a.C32588kn;
import com.tencent.p177mm.pluginsdk.p1077c.C46483b;
import com.tencent.p177mm.protocal.protobuf.axv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy */
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements C8915a {
    private static final String[] COLUMNS = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private static boolean eBB = false;
    private static C7564ap lQA = new C7564ap(new C117801(), false);
    private static final UriMatcher lQy;
    private boolean bCS;
    private C42206a ecy = new C340874();
    private C46483b eiw = new C206073();
    private C26443d fwu;
    private int lQr;
    private List<axv> lQs;
    private C1359e lQt;
    private Set<String> lQu;
    private CountDownLatch lQv;
    private CountDownLatch lQw;
    private axv lQx;
    private boolean lQz = false;

    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy$1 */
    static class C117801 implements C5015a {
        C117801() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(20362);
            ExtControlProviderNearBy.eBB = false;
            AppMethodBeat.m2505o(20362);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy$3 */
    class C206073 extends C46483b {
        C206073() {
        }

        /* renamed from: a */
        public final void mo14634a(int i, int i2, String str, C4883b c4883b) {
            AppMethodBeat.m2504i(20364);
            if (c4883b instanceof C32588kn) {
                if (ExtControlProviderNearBy.this.lQv == null) {
                    AppMethodBeat.m2505o(20364);
                    return;
                }
                C32588kn c32588kn = (C32588kn) c4883b;
                C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
                if (i == 0 && i2 == 0) {
                    ExtControlProviderNearBy.this.lQs = c32588kn.cGl.cGs;
                    if (ExtControlProviderNearBy.this.lQs == null || ExtControlProviderNearBy.this.lQs.size() == 0) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                        ExtControlProviderNearBy.this.lQv.countDown();
                    } else {
                        if (ExtControlProviderNearBy.this.lQs.size() > 10) {
                            C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.this.lQs.size());
                            ExtControlProviderNearBy.this.lQs.subList(10, ExtControlProviderNearBy.this.lQs.size()).clear();
                        }
                        ExtControlProviderNearBy.this.lQw = new CountDownLatch(ExtControlProviderNearBy.this.lQs.size());
                        ExtControlProviderNearBy.this.lQv.countDown();
                        ExtControlProviderNearBy.m55871e(ExtControlProviderNearBy.this);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                    ExtControlProviderNearBy.this.lQv.countDown();
                }
                ExtControlProviderNearBy.m55872f(ExtControlProviderNearBy.this);
            }
            AppMethodBeat.m2505o(20364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy$2 */
    class C279072 implements Runnable {
        C279072() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20363);
            if (ExtControlProviderNearBy.this.fwu == null) {
                ExtControlProviderNearBy.this.fwu = C26443d.agz();
            }
            ExtControlProviderNearBy.this.fwu.mo44204a(ExtControlProviderNearBy.this.ecy, true);
            AppMethodBeat.m2505o(20363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy$4 */
    class C340874 implements C42206a {
        C340874() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(20365);
            if (ExtControlProviderNearBy.this.lQz) {
                AppMethodBeat.m2505o(20365);
            } else {
                ExtControlProviderNearBy.this.lQz = true;
                if (z) {
                    C32588kn c32588kn = new C32588kn();
                    c32588kn.cGk.czE = ExtControlProviderNearBy.this.lQr;
                    c32588kn.cGk.cGm = f;
                    c32588kn.cGk.cEB = f2;
                    c32588kn.cGk.cGn = (int) d2;
                    c32588kn.cGk.cGo = i;
                    c32588kn.cGk.cGp = "";
                    c32588kn.cGk.cGq = "";
                    if (C4879a.xxA.mo10055m(c32588kn)) {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                    }
                    AppMethodBeat.m2505o(20365);
                } else {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                    ExtControlProviderNearBy.m55872f(ExtControlProviderNearBy.this);
                    ExtControlProviderNearBy.this.lQv.countDown();
                    AppMethodBeat.m2505o(20365);
                }
            }
            return false;
        }
    }

    public ExtControlProviderNearBy() {
        AppMethodBeat.m2504i(20366);
        AppMethodBeat.m2505o(20366);
    }

    static {
        AppMethodBeat.m2504i(20376);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQy = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        lQy.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        lQy.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
        AppMethodBeat.m2505o(20376);
    }

    /* renamed from: dJ */
    private static void m55870dJ(boolean z) {
        AppMethodBeat.m2504i(20367);
        if (z) {
            eBB = true;
            lQA.mo16770ae(15000, 15000);
            AppMethodBeat.m2505o(20367);
            return;
        }
        lQA.mo16770ae(0, 0);
        AppMethodBeat.m2505o(20367);
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20368);
        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(uri)));
        mo61882a(uri, getContext(), 15);
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20368);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20368);
            return null;
        } else if (eBB) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            mo61890vf(5);
            AppMethodBeat.m2505o(20368);
            return null;
        } else {
            ExtControlProviderNearBy.m55870dJ(true);
            Cursor cursor;
            if (!aVl()) {
                ExtControlProviderNearBy.m55870dJ(false);
                mo61890vf(1);
                cursor = this.jDN;
                AppMethodBeat.m2505o(20368);
                return cursor;
            } else if (mo61888dJ(getContext())) {
                C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.lQr);
                getType(uri);
                if (this.lQr < 0) {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    ExtControlProviderNearBy.m55870dJ(false);
                    mo61890vf(3);
                    AppMethodBeat.m2505o(20368);
                    return null;
                }
                try {
                    this.lQs = new ArrayList();
                    this.lQt = new C1359e(COLUMNS, (byte) 0);
                    this.lQv = new CountDownLatch(1);
                    this.lQw = null;
                    this.lQu = new HashSet();
                    this.lQs = new ArrayList();
                    this.bCS = false;
                    C4990ab.m7418v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (C9638aw.m17179RK()) {
                        C46483b.m87699a(C32588kn.class.getName(), this.eiw);
                        C5004al.m7441d(new C279072());
                    } else {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.lQv.await(15000, TimeUnit.MILLISECONDS)) {
                        C4990ab.m7420w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.lQw != null) {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.lQw.await(15000, TimeUnit.MILLISECONDS)) {
                            C4990ab.m7420w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e, "", new Object[0]);
                    mo61890vf(4);
                }
                ExtControlProviderNearBy.m55870dJ(false);
                C17884o.acd().mo67500b(this);
                this.bCS = true;
                brP();
                if (this.lQt == null || this.lQt.getCount() <= 0) {
                    mo61890vf(4);
                } else {
                    mo61890vf(0);
                }
                C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "return now");
                cursor = this.lQt;
                AppMethodBeat.m2505o(20368);
                return cursor;
            } else {
                C4990ab.m7420w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                ExtControlProviderNearBy.m55870dJ(false);
                mo61890vf(2);
                AppMethodBeat.m2505o(20368);
                return null;
            }
        }
    }

    /* renamed from: Lg */
    private axv m55860Lg(String str) {
        AppMethodBeat.m2504i(20369);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            AppMethodBeat.m2505o(20369);
            return null;
        }
        for (axv axv : this.lQs) {
            if (axv.jBB.equals(str)) {
                AppMethodBeat.m2505o(20369);
                return axv;
            }
        }
        AppMethodBeat.m2505o(20369);
        return null;
    }

    /* renamed from: a */
    private void m55866a(axv axv) {
        AppMethodBeat.m2504i(20370);
        if (axv == null || axv.jBB == null) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            AppMethodBeat.m2505o(20370);
            return;
        }
        this.lQu.add(axv.jBB);
        Bitmap a = C41730b.m73490a(axv.jBB, false, -1);
        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.lQw.getCount());
        if (a != null) {
            C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.lQu.remove(axv.jBB);
            this.lQt.addRow(new Object[]{axv.jCH, bArr, axv.wBS, axv.guQ, Integer.valueOf(axv.guN)});
            C4990ab.m7417i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a);
            a.recycle();
        }
        AppMethodBeat.m2505o(20370);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(20371);
        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(str)));
        if (this.bCS) {
            C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "has finished");
            AppMethodBeat.m2505o(20371);
            return;
        }
        m55866a(m55860Lg(str));
        this.lQw.countDown();
        AppMethodBeat.m2505o(20371);
    }

    private void brP() {
        AppMethodBeat.m2504i(20372);
        if (this.lQu.size() > 0) {
            for (String str : this.lQu) {
                C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
                this.lQx = m55860Lg(str);
                if (!(this.lQx == null || this.lQx.jBB == null)) {
                    this.lQt.addRow(new Object[]{this.lQx.jCH, null, this.lQx.wBS, this.lQx.guQ, Integer.valueOf(this.lQx.guN)});
                }
            }
            AppMethodBeat.m2505o(20372);
            return;
        }
        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
        AppMethodBeat.m2505o(20372);
    }

    public final String getType(Uri uri) {
        AppMethodBeat.m2504i(20373);
        this.lQr = -1;
        switch (lQy.match(uri)) {
            case 0:
                this.lQr = 1;
                break;
            case 1:
                this.lQr = 3;
                break;
            case 2:
                this.lQr = 4;
                break;
            default:
                this.lQr = -1;
                break;
        }
        AppMethodBeat.m2505o(20373);
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    static /* synthetic */ void m55871e(ExtControlProviderNearBy extControlProviderNearBy) {
        AppMethodBeat.m2504i(20374);
        C17884o.acd().mo67498a((C8915a) extControlProviderNearBy);
        if (extControlProviderNearBy.lQt == null) {
            extControlProviderNearBy.lQt = new C1359e(COLUMNS, (byte) 0);
        }
        for (axv a : extControlProviderNearBy.lQs) {
            extControlProviderNearBy.m55866a(a);
        }
        extControlProviderNearBy.lQw.countDown();
        AppMethodBeat.m2505o(20374);
    }

    /* renamed from: f */
    static /* synthetic */ void m55872f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        AppMethodBeat.m2504i(20375);
        C4990ab.m7418v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (C9638aw.m17179RK()) {
            C46483b.m87700b(C32588kn.class.getName(), extControlProviderNearBy.eiw);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.fwu != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7419v(str, str2, objArr);
            if (extControlProviderNearBy.fwu != null) {
                extControlProviderNearBy.fwu.mo44208c(extControlProviderNearBy.ecy);
            }
            AppMethodBeat.m2505o(20375);
            return;
        }
        C4990ab.m7416i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        AppMethodBeat.m2505o(20375);
    }
}
