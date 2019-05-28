package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.cd.e;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements a {
    private static final String[] COLUMNS = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private static boolean eBB = false;
    private static ap lQA = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(20362);
            ExtControlProviderNearBy.eBB = false;
            AppMethodBeat.o(20362);
            return false;
        }
    }, false);
    private static final UriMatcher lQy;
    private boolean bCS;
    private b.a ecy = new b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(20365);
            if (ExtControlProviderNearBy.this.lQz) {
                AppMethodBeat.o(20365);
            } else {
                ExtControlProviderNearBy.this.lQz = true;
                if (z) {
                    kn knVar = new kn();
                    knVar.cGk.czE = ExtControlProviderNearBy.this.lQr;
                    knVar.cGk.cGm = f;
                    knVar.cGk.cEB = f2;
                    knVar.cGk.cGn = (int) d2;
                    knVar.cGk.cGo = i;
                    knVar.cGk.cGp = "";
                    knVar.cGk.cGq = "";
                    if (com.tencent.mm.sdk.b.a.xxA.m(knVar)) {
                        ab.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                    }
                    AppMethodBeat.o(20365);
                } else {
                    ab.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                    ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
                    ExtControlProviderNearBy.this.lQv.countDown();
                    AppMethodBeat.o(20365);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.pluginsdk.c.b eiw = new com.tencent.mm.pluginsdk.c.b() {
        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(20364);
            if (bVar instanceof kn) {
                if (ExtControlProviderNearBy.this.lQv == null) {
                    AppMethodBeat.o(20364);
                    return;
                }
                kn knVar = (kn) bVar;
                ab.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
                if (i == 0 && i2 == 0) {
                    ExtControlProviderNearBy.this.lQs = knVar.cGl.cGs;
                    if (ExtControlProviderNearBy.this.lQs == null || ExtControlProviderNearBy.this.lQs.size() == 0) {
                        ab.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                        ExtControlProviderNearBy.this.lQv.countDown();
                    } else {
                        if (ExtControlProviderNearBy.this.lQs.size() > 10) {
                            ab.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.this.lQs.size());
                            ExtControlProviderNearBy.this.lQs.subList(10, ExtControlProviderNearBy.this.lQs.size()).clear();
                        }
                        ExtControlProviderNearBy.this.lQw = new CountDownLatch(ExtControlProviderNearBy.this.lQs.size());
                        ExtControlProviderNearBy.this.lQv.countDown();
                        ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
                    }
                } else {
                    ab.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                    ExtControlProviderNearBy.this.lQv.countDown();
                }
                ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
            }
            AppMethodBeat.o(20364);
        }
    };
    private d fwu;
    private int lQr;
    private List<axv> lQs;
    private e lQt;
    private Set<String> lQu;
    private CountDownLatch lQv;
    private CountDownLatch lQw;
    private axv lQx;
    private boolean lQz = false;

    public ExtControlProviderNearBy() {
        AppMethodBeat.i(20366);
        AppMethodBeat.o(20366);
    }

    static {
        AppMethodBeat.i(20376);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQy = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        lQy.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        lQy.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
        AppMethodBeat.o(20376);
    }

    private static void dJ(boolean z) {
        AppMethodBeat.i(20367);
        if (z) {
            eBB = true;
            lQA.ae(15000, 15000);
            AppMethodBeat.o(20367);
            return;
        }
        lQA.ae(0, 0);
        AppMethodBeat.o(20367);
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(20368);
        ab.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(uri)));
        a(uri, getContext(), 15);
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20368);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            AppMethodBeat.o(20368);
            return null;
        } else if (eBB) {
            ab.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            vf(5);
            AppMethodBeat.o(20368);
            return null;
        } else {
            dJ(true);
            Cursor cursor;
            if (!aVl()) {
                dJ(false);
                vf(1);
                cursor = this.jDN;
                AppMethodBeat.o(20368);
                return cursor;
            } else if (dJ(getContext())) {
                ab.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.lQr);
                getType(uri);
                if (this.lQr < 0) {
                    ab.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    dJ(false);
                    vf(3);
                    AppMethodBeat.o(20368);
                    return null;
                }
                try {
                    this.lQs = new ArrayList();
                    this.lQt = new e(COLUMNS, (byte) 0);
                    this.lQv = new CountDownLatch(1);
                    this.lQw = null;
                    this.lQu = new HashSet();
                    this.lQs = new ArrayList();
                    this.bCS = false;
                    ab.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (aw.RK()) {
                        com.tencent.mm.pluginsdk.c.b.a(kn.class.getName(), this.eiw);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(20363);
                                if (ExtControlProviderNearBy.this.fwu == null) {
                                    ExtControlProviderNearBy.this.fwu = d.agz();
                                }
                                ExtControlProviderNearBy.this.fwu.a(ExtControlProviderNearBy.this.ecy, true);
                                AppMethodBeat.o(20363);
                            }
                        });
                    } else {
                        ab.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    ab.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.lQv.await(15000, TimeUnit.MILLISECONDS)) {
                        ab.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.lQw != null) {
                        ab.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.lQw.await(15000, TimeUnit.MILLISECONDS)) {
                            ab.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        ab.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e, "", new Object[0]);
                    vf(4);
                }
                dJ(false);
                o.acd().b(this);
                this.bCS = true;
                brP();
                if (this.lQt == null || this.lQt.getCount() <= 0) {
                    vf(4);
                } else {
                    vf(0);
                }
                ab.i("MicroMsg.ExtControlProviderNearBy", "return now");
                cursor = this.lQt;
                AppMethodBeat.o(20368);
                return cursor;
            } else {
                ab.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                dJ(false);
                vf(2);
                AppMethodBeat.o(20368);
                return null;
            }
        }
    }

    private axv Lg(String str) {
        AppMethodBeat.i(20369);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            AppMethodBeat.o(20369);
            return null;
        }
        for (axv axv : this.lQs) {
            if (axv.jBB.equals(str)) {
                AppMethodBeat.o(20369);
                return axv;
            }
        }
        AppMethodBeat.o(20369);
        return null;
    }

    private void a(axv axv) {
        AppMethodBeat.i(20370);
        if (axv == null || axv.jBB == null) {
            ab.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            AppMethodBeat.o(20370);
            return;
        }
        this.lQu.add(axv.jBB);
        Bitmap a = com.tencent.mm.ah.b.a(axv.jBB, false, -1);
        ab.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.lQw.getCount());
        if (a != null) {
            ab.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.lQu.remove(axv.jBB);
            this.lQt.addRow(new Object[]{axv.jCH, bArr, axv.wBS, axv.guQ, Integer.valueOf(axv.guN)});
            ab.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a);
            a.recycle();
        }
        AppMethodBeat.o(20370);
    }

    public final void qj(String str) {
        AppMethodBeat.i(20371);
        ab.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(str)));
        if (this.bCS) {
            ab.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            AppMethodBeat.o(20371);
            return;
        }
        a(Lg(str));
        this.lQw.countDown();
        AppMethodBeat.o(20371);
    }

    private void brP() {
        AppMethodBeat.i(20372);
        if (this.lQu.size() > 0) {
            for (String str : this.lQu) {
                ab.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
                this.lQx = Lg(str);
                if (!(this.lQx == null || this.lQx.jBB == null)) {
                    this.lQt.addRow(new Object[]{this.lQx.jCH, null, this.lQx.wBS, this.lQx.guQ, Integer.valueOf(this.lQx.guN)});
                }
            }
            AppMethodBeat.o(20372);
            return;
        }
        ab.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
        AppMethodBeat.o(20372);
    }

    public final String getType(Uri uri) {
        AppMethodBeat.i(20373);
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
        AppMethodBeat.o(20373);
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

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        AppMethodBeat.i(20374);
        o.acd().a((a) extControlProviderNearBy);
        if (extControlProviderNearBy.lQt == null) {
            extControlProviderNearBy.lQt = new e(COLUMNS, (byte) 0);
        }
        for (axv a : extControlProviderNearBy.lQs) {
            extControlProviderNearBy.a(a);
        }
        extControlProviderNearBy.lQw.countDown();
        AppMethodBeat.o(20374);
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        AppMethodBeat.i(20375);
        ab.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (aw.RK()) {
            com.tencent.mm.pluginsdk.c.b.b(kn.class.getName(), extControlProviderNearBy.eiw);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.fwu != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.v(str, str2, objArr);
            if (extControlProviderNearBy.fwu != null) {
                extControlProviderNearBy.fwu.c(extControlProviderNearBy.ecy);
            }
            AppMethodBeat.o(20375);
            return;
        }
        ab.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
        AppMethodBeat.o(20375);
    }
}
