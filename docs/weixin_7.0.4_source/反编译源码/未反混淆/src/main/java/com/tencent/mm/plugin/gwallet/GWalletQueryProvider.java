package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GWalletQueryProvider extends ContentProvider {
    public static final String[] COLUMNS = new String[]{"_id", "product_id", "full_price", "product_state", "price_currency", "price_amount"};
    private final String TAG = "MicroMsg.GWalletQueryProvider";
    private Context mContext = null;
    private ArrayList<String> npA;
    private int npB;
    private b npw = null;
    private boolean npx;
    private boolean npy;
    private ArrayList<String> npz;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(41671);
        ab.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
        AppMethodBeat.o(41671);
        return true;
    }

    /* JADX WARNING: Missing block: B:79:0x0267, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(41672);
     */
    /* JADX WARNING: Missing block: B:100:?, code skipped:
            return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        JSONException e;
        AppMethodBeat.i(41672);
        synchronized (GWalletQueryProvider.class) {
            try {
                ab.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
                if (strArr2 == null || strArr2.length == 0) {
                    ab.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("no product id selected or size is 0");
                    AppMethodBeat.o(41672);
                    throw illegalArgumentException;
                }
                int i;
                int i2;
                this.mContext = getContext();
                this.npw = new b(this.mContext);
                this.npx = true;
                this.npy = false;
                this.npA = new ArrayList();
                for (Object add : strArr2) {
                    this.npA.add(add);
                }
                ab.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
                this.npw.a(new a() {
                    public final void a(c cVar) {
                        AppMethodBeat.i(41669);
                        ab.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
                        if (cVar.isSuccess()) {
                            g.RS().a(new al.a() {
                                public final boolean acf() {
                                    AppMethodBeat.i(41666);
                                    GWalletQueryProvider.d(GWalletQueryProvider.this);
                                    AppMethodBeat.o(41666);
                                    return true;
                                }

                                public final boolean acg() {
                                    AppMethodBeat.i(41667);
                                    if (GWalletQueryProvider.this.npw != null) {
                                        GWalletQueryProvider.this.npw.dispose();
                                    }
                                    GWalletQueryProvider.this.npw = null;
                                    AppMethodBeat.o(41667);
                                    return true;
                                }

                                public final String toString() {
                                    AppMethodBeat.i(41668);
                                    String str = super.toString() + "|onIabSetupFinished";
                                    AppMethodBeat.o(41668);
                                    return str;
                                }
                            });
                            AppMethodBeat.o(41669);
                            return;
                        }
                        ab.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: ".concat(String.valueOf(cVar)));
                        GWalletQueryProvider.this.npx = false;
                        if (GWalletQueryProvider.this.npw != null) {
                            GWalletQueryProvider.this.npw.dispose();
                        }
                        GWalletQueryProvider.this.npw = null;
                        AppMethodBeat.o(41669);
                    }
                });
                long j = 0;
                while (j <= 30000 && this.npx && !this.npy) {
                    Thread.sleep(100);
                    j += 100;
                }
                MatrixCursor matrixCursor;
                Iterator it;
                String str3;
                if (!this.npx) {
                    ab.d("MicroMsg.GWalletQueryProvider", "unable to setup");
                    matrixCursor = new MatrixCursor(COLUMNS);
                    it = this.npA.iterator();
                    while (it.hasNext()) {
                        str3 = (String) it.next();
                        matrixCursor.addRow(new Object[]{Integer.valueOf(0), str3, "", Integer.valueOf(10234), "", ""});
                    }
                    AppMethodBeat.o(41672);
                    return matrixCursor;
                } else if (j > 30000) {
                    ab.d("MicroMsg.GWalletQueryProvider", "time's out");
                    matrixCursor = new MatrixCursor(COLUMNS);
                    it = this.npA.iterator();
                    while (it.hasNext()) {
                        str3 = (String) it.next();
                        matrixCursor.addRow(new Object[]{Integer.valueOf(0), str3, "", Integer.valueOf(10235), "", ""});
                    }
                    AppMethodBeat.o(41672);
                    return matrixCursor;
                } else {
                    ab.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
                    MatrixCursor matrixCursor2 = new MatrixCursor(COLUMNS);
                    if (this.npB == 0) {
                        Iterator it2;
                        i = 0;
                        if (this.npz != null) {
                            it2 = this.npz.iterator();
                            i2 = 0;
                            while (it2.hasNext()) {
                                str3 = (String) it2.next();
                                if (bo.isNullOrNil(str3)) {
                                    i = i2;
                                    i2 = i;
                                } else {
                                    try {
                                        JSONObject jSONObject = new JSONObject(str3);
                                        String string = jSONObject.getString("productId");
                                        String string2 = jSONObject.getString(FirebaseAnalytics.b.PRICE);
                                        String string3 = jSONObject.getString("price_currency_code");
                                        String string4 = jSONObject.getString("price_amount_micros");
                                        Integer valueOf = Integer.valueOf(10232);
                                        Object[] objArr = new Object[6];
                                        i = i2 + 1;
                                        try {
                                            objArr[0] = Integer.valueOf(i2);
                                            objArr[1] = string;
                                            objArr[2] = string2;
                                            objArr[3] = valueOf;
                                            objArr[4] = string3;
                                            objArr[5] = string4;
                                            matrixCursor2.addRow(objArr);
                                            this.npA.remove(string);
                                            i2 = i;
                                        } catch (JSONException e2) {
                                            e = e2;
                                            ab.d("MicroMsg.GWalletQueryProvider", e.toString());
                                            i2 = i;
                                        }
                                    } catch (JSONException e3) {
                                        e = e3;
                                        i = i2;
                                        ab.d("MicroMsg.GWalletQueryProvider", e.toString());
                                        i2 = i;
                                    }
                                }
                            }
                            i = i2;
                        }
                        it2 = this.npA.iterator();
                        i2 = i;
                        while (it2.hasNext()) {
                            str3 = (String) it2.next();
                            r8 = new Object[6];
                            int i3 = i2 + 1;
                            r8[0] = Integer.valueOf(i2);
                            r8[1] = str3;
                            r8[2] = "";
                            r8[3] = Integer.valueOf(10233);
                            r8[4] = "";
                            r8[5] = "";
                            matrixCursor2.addRow(r8);
                            i2 = i3;
                        }
                    } else {
                        Iterator it3 = this.npA.iterator();
                        while (it3.hasNext()) {
                            str3 = (String) it3.next();
                            matrixCursor2.addRow(new Object[]{Integer.valueOf(0), str3, "", Integer.valueOf(10236), "", ""});
                        }
                    }
                }
            } catch (InterruptedException e4) {
                ab.e("MicroMsg.GWalletQueryProvider", e4.toString());
            } catch (Throwable th) {
                AppMethodBeat.o(41672);
            }
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static /* synthetic */ void d(GWalletQueryProvider gWalletQueryProvider) {
        AppMethodBeat.i(41673);
        if (gWalletQueryProvider.npw != null) {
            gWalletQueryProvider.npw.a(gWalletQueryProvider.npA, new b.c() {
                public final void a(c cVar, Intent intent) {
                    AppMethodBeat.i(41670);
                    ab.d("MicroMsg.GWalletQueryProvider", "query detail done! Result ".concat(String.valueOf(cVar)));
                    GWalletQueryProvider.this.npy = true;
                    GWalletQueryProvider.this.npz = intent.getStringArrayListExtra("RESPONSE_QUERY_DETAIL_INFO");
                    GWalletQueryProvider.this.npB = intent.getIntExtra("RESPONSE_CODE", 0);
                    AppMethodBeat.o(41670);
                }
            });
        }
        AppMethodBeat.o(41673);
    }
}
