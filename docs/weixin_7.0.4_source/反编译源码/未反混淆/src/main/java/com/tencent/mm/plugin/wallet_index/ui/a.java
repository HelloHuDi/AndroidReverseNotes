package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.plugin.wallet_index.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.z;
import java.util.ArrayList;

public final class a implements b {
    public static long tRs = 0;
    BroadcastReceiver jIA = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(48219);
            String action = intent.getAction();
            if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
                a aVar = a.this;
                a.this.tRu;
                aVar.tRv = com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, a.this.tRp);
                AppMethodBeat.o(48219);
                return;
            }
            if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
                final boolean booleanExtra = intent.getBooleanExtra("is_direct", true);
                a.this.tRu;
                com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, new com.tencent.mm.plugin.wallet_index.b.a.a.a() {
                    public final void a(b bVar, com.tencent.mm.plugin.wallet_index.b.a.b bVar2) {
                        AppMethodBeat.i(48218);
                        ab.d("MicroMsg.GoogleWallet", "Query inventory finished.");
                        if (bVar.cSV() || bVar2 == null) {
                            ab.w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(bVar)));
                            AppMethodBeat.o(48218);
                            return;
                        }
                        ab.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
                        a.this.tRv = bVar2;
                        c c = a.this.tRr;
                        ArrayList arrayList = new ArrayList(bVar2.tQQ.keySet());
                        c.tRD.clear();
                        c.tRD.addAll(arrayList);
                        ArrayList<c> arrayList2 = new ArrayList(bVar2.tQQ.values());
                        if (arrayList2.size() > 0) {
                            for (c cVar : arrayList2) {
                                ab.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + cVar.kWz + ",billNo:" + cVar.tQV);
                                g.RQ();
                                g.RO().eJo.a(a.this.tRr.a(cVar, true), 0);
                            }
                            AppMethodBeat.o(48218);
                            return;
                        }
                        b bu;
                        ab.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
                        if (booleanExtra) {
                            ab.d("MicroMsg.GoogleWallet", "result ok");
                            bu = b.bu(0, "");
                        } else {
                            ab.d("MicroMsg.GoogleWallet", "unknown_purchase");
                            bu = b.bu(5, "");
                        }
                        if (a.this.tRt != null) {
                            a.this.tRt.a(bu, null);
                        }
                        AppMethodBeat.o(48218);
                    }
                });
            }
            AppMethodBeat.o(48219);
        }
    };
    String kWz;
    private String tQX;
    String tQY;
    private d tRp = null;
    private d tRq = null;
    private c tRr;
    private d tRt;
    private com.tencent.mm.plugin.wallet_index.b.a.a tRu;
    private com.tencent.mm.plugin.wallet_index.b.a.b tRv;
    String tRw;

    public a(Activity activity, c cVar, d dVar) {
        AppMethodBeat.i(48220);
        this.tRt = dVar;
        tRs = 0;
        this.tRr = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        activity.registerReceiver(this.jIA, intentFilter);
        this.tRu = new com.tencent.mm.plugin.wallet_index.b.a.a();
        AppMethodBeat.o(48220);
    }

    public final int cSW() {
        return 3;
    }

    public final int a(MMActivity mMActivity, d dVar) {
        AppMethodBeat.i(48221);
        this.tRp = dVar;
        this.kWz = this.tRr.tRe.pho;
        this.tQY = this.tRr.tRe.pdz;
        this.tQX = this.tRr.tRe.wma;
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("product_id", this.kWz);
        this.tRw = this.tRr.tRe.wym;
        String str = "developer_pay_load";
        String str2 = this.tRw;
        String str3 = this.tQY;
        String str4 = this.tQX;
        if (bo.isNullOrNil(str2)) {
            str2 = "";
        }
        if (bo.isNullOrNil(str3)) {
            str3 = "";
        }
        if (bo.isNullOrNil(str4)) {
            str4 = "";
        }
        intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
        if (mMActivity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            ab.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
            b bu = b.bu(3, "");
            if (this.tRp != null) {
                this.tRp.a(bu, null);
            }
        } else {
            tRs = bo.anU();
            ab.i("MicroMsg.GoogleWallet", "GWallet Found!");
            mMActivity.startActivityForResult(intent, 10001);
        }
        AppMethodBeat.o(48221);
        return 10001;
    }

    public final void l(MMActivity mMActivity) {
        AppMethodBeat.i(48222);
        try {
            mMActivity.unregisterReceiver(this.jIA);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.GoogleWallet", e.toString());
        }
        if (!bo.cv(mMActivity)) {
            ab.d("MicroMsg.GoogleWallet", "close front UI.");
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            mMActivity.sendBroadcast(intent);
        }
        ab.d("MicroMsg.GoogleWallet", "Destroying helper.");
        AppMethodBeat.o(48222);
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        AppMethodBeat.i(48224);
        if (i == 10001) {
            ab.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", Integer.valueOf(i2));
            if (intent != null) {
                int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                if (intExtra == 3 || intExtra == 105) {
                    z.d(this.tRw, this.kWz, this.tQY, intExtra, "");
                    b(mMActivity, intExtra);
                    AppMethodBeat.o(48224);
                } else if (intExtra == 100000001) {
                    b(mMActivity, intExtra);
                    AppMethodBeat.o(48224);
                }
            } else {
                b(mMActivity, 1);
                AppMethodBeat.o(48224);
            }
            return true;
        }
        d dVar = this.tRq;
        String str = this.tRw;
        String str2 = this.kWz;
        String str3 = this.tQY;
        int ay = com.tencent.mm.plugin.wallet_index.b.a.a.ay(intent);
        ab.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(ay));
        b bu = b.bu(ay, "");
        z.d(str, str2, str3, ay, bu.nqb);
        if (dVar != null) {
            dVar.a(bu, null);
        }
        AppMethodBeat.o(48224);
        return true;
    }

    public final void b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(48225);
        ab.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
        ab.d("MicroMsg.GoogleWallet", "is direct? ".concat(String.valueOf(z)));
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("is_direct", z);
        mMActivity.startActivityForResult(intent, 10001);
        AppMethodBeat.o(48225);
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        AppMethodBeat.i(48226);
        this.tRq = dVar;
        ab.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
        com.tencent.mm.plugin.wallet_index.b.a.b bVar = this.tRv;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            c cVar = (c) bVar.tQQ.get(str);
            if (cVar != null) {
                arrayList2.add(cVar.gtl);
            }
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putStringArrayListExtra("tokens", arrayList2);
            intent.putExtra("IS_FAILED_CONSUME", z);
            mMActivity.sendBroadcast(intent);
            AppMethodBeat.o(48226);
            return;
        }
        b bu = b.bu(0, "");
        if (this.tRq != null) {
            this.tRq.a(bu, null);
        }
        AppMethodBeat.o(48226);
    }

    private static void b(MMActivity mMActivity, int i) {
        AppMethodBeat.i(48223);
        b bu = b.bu(i, "");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", bu.nqa);
        intent.putExtra("key_err_msg", bu.nqb);
        intent.putExtra("key_launch_ts", tRs);
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
        AppMethodBeat.o(48223);
    }
}
