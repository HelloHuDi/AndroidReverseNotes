package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C14341a;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C14341a.C14342a;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C22688c;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C29690b;
import com.tencent.p177mm.plugin.wallet_index.p564c.C35525b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_index.ui.a */
public final class C35529a implements C4486b {
    public static long tRs = 0;
    BroadcastReceiver jIA = new C355301();
    String kWz;
    private String tQX;
    String tQY;
    private C4487d tRp = null;
    private C4487d tRq = null;
    private C14357c tRr;
    private C4487d tRt;
    private C14341a tRu;
    private C29690b tRv;
    String tRw;

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.a$1 */
    class C355301 extends BroadcastReceiver {
        C355301() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(48219);
            String action = intent.getAction();
            if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
                C35529a c35529a = C35529a.this;
                C35529a.this.tRu;
                c35529a.tRv = C14341a.m22520a(intent, C35529a.this.tRp);
                AppMethodBeat.m2505o(48219);
                return;
            }
            if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
                final boolean booleanExtra = intent.getBooleanExtra("is_direct", true);
                C35529a.this.tRu;
                C14341a.m22519a(intent, new C14342a() {
                    /* renamed from: a */
                    public final void mo26620a(C35525b c35525b, C29690b c29690b) {
                        AppMethodBeat.m2504i(48218);
                        C4990ab.m7410d("MicroMsg.GoogleWallet", "Query inventory finished.");
                        if (c35525b.cSV() || c29690b == null) {
                            C4990ab.m7420w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(c35525b)));
                            AppMethodBeat.m2505o(48218);
                            return;
                        }
                        C4990ab.m7410d("MicroMsg.GoogleWallet", "Query inventory was successful.");
                        C35529a.this.tRv = c29690b;
                        C14357c c = C35529a.this.tRr;
                        ArrayList arrayList = new ArrayList(c29690b.tQQ.keySet());
                        c.tRD.clear();
                        c.tRD.addAll(arrayList);
                        ArrayList<C22688c> arrayList2 = new ArrayList(c29690b.tQQ.values());
                        if (arrayList2.size() > 0) {
                            for (C22688c c22688c : arrayList2) {
                                C4990ab.m7416i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + c22688c.kWz + ",billNo:" + c22688c.tQV);
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14541a(C35529a.this.tRr.mo26627a(c22688c, true), 0);
                            }
                            AppMethodBeat.m2505o(48218);
                            return;
                        }
                        C35525b bu;
                        C4990ab.m7410d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
                        if (booleanExtra) {
                            C4990ab.m7410d("MicroMsg.GoogleWallet", "result ok");
                            bu = C35525b.m58303bu(0, "");
                        } else {
                            C4990ab.m7410d("MicroMsg.GoogleWallet", "unknown_purchase");
                            bu = C35525b.m58303bu(5, "");
                        }
                        if (C35529a.this.tRt != null) {
                            C35529a.this.tRt.mo9553a(bu, null);
                        }
                        AppMethodBeat.m2505o(48218);
                    }
                });
            }
            AppMethodBeat.m2505o(48219);
        }
    }

    public C35529a(Activity activity, C14357c c14357c, C4487d c4487d) {
        AppMethodBeat.m2504i(48220);
        this.tRt = c4487d;
        tRs = 0;
        this.tRr = c14357c;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        activity.registerReceiver(this.jIA, intentFilter);
        this.tRu = new C14341a();
        AppMethodBeat.m2505o(48220);
    }

    public final int cSW() {
        return 3;
    }

    /* renamed from: a */
    public final int mo9547a(MMActivity mMActivity, C4487d c4487d) {
        AppMethodBeat.m2504i(48221);
        this.tRp = c4487d;
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
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "";
        }
        if (C5046bo.isNullOrNil(str3)) {
            str3 = "";
        }
        if (C5046bo.isNullOrNil(str4)) {
            str4 = "";
        }
        intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
        if (mMActivity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            C4990ab.m7416i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
            C35525b bu = C35525b.m58303bu(3, "");
            if (this.tRp != null) {
                this.tRp.mo9553a(bu, null);
            }
        } else {
            tRs = C5046bo.anU();
            C4990ab.m7416i("MicroMsg.GoogleWallet", "GWallet Found!");
            mMActivity.startActivityForResult(intent, 10001);
        }
        AppMethodBeat.m2505o(48221);
        return 10001;
    }

    /* renamed from: l */
    public final void mo9552l(MMActivity mMActivity) {
        AppMethodBeat.m2504i(48222);
        try {
            mMActivity.unregisterReceiver(this.jIA);
        } catch (IllegalArgumentException e) {
            C4990ab.m7412e("MicroMsg.GoogleWallet", e.toString());
        }
        if (!C5046bo.m7544cv(mMActivity)) {
            C4990ab.m7410d("MicroMsg.GoogleWallet", "close front UI.");
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            mMActivity.sendBroadcast(intent);
        }
        C4990ab.m7410d("MicroMsg.GoogleWallet", "Destroying helper.");
        AppMethodBeat.m2505o(48222);
    }

    /* renamed from: a */
    public final boolean mo9549a(MMActivity mMActivity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48224);
        if (i == 10001) {
            C4990ab.m7417i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", Integer.valueOf(i2));
            if (intent != null) {
                int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                if (intExtra == 3 || intExtra == 105) {
                    C36381z.m59953d(this.tRw, this.kWz, this.tQY, intExtra, "");
                    C35529a.m58318b(mMActivity, intExtra);
                    AppMethodBeat.m2505o(48224);
                } else if (intExtra == 100000001) {
                    C35529a.m58318b(mMActivity, intExtra);
                    AppMethodBeat.m2505o(48224);
                }
            } else {
                C35529a.m58318b(mMActivity, 1);
                AppMethodBeat.m2505o(48224);
            }
            return true;
        }
        C4487d c4487d = this.tRq;
        String str = this.tRw;
        String str2 = this.kWz;
        String str3 = this.tQY;
        int ay = C14341a.m22521ay(intent);
        C4990ab.m7410d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(ay));
        C35525b bu = C35525b.m58303bu(ay, "");
        C36381z.m59953d(str, str2, str3, ay, bu.nqb);
        if (c4487d != null) {
            c4487d.mo9553a(bu, null);
        }
        AppMethodBeat.m2505o(48224);
        return true;
    }

    /* renamed from: b */
    public final void mo9550b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.m2504i(48225);
        C4990ab.m7410d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
        C4990ab.m7410d("MicroMsg.GoogleWallet", "is direct? ".concat(String.valueOf(z)));
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("is_direct", z);
        mMActivity.startActivityForResult(intent, 10001);
        AppMethodBeat.m2505o(48225);
    }

    /* renamed from: a */
    public final void mo9548a(MMActivity mMActivity, ArrayList<String> arrayList, C4487d c4487d, boolean z) {
        AppMethodBeat.m2504i(48226);
        this.tRq = c4487d;
        C4990ab.m7410d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
        C29690b c29690b = this.tRv;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            C22688c c22688c = (C22688c) c29690b.tQQ.get(str);
            if (c22688c != null) {
                arrayList2.add(c22688c.gtl);
            }
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putStringArrayListExtra("tokens", arrayList2);
            intent.putExtra("IS_FAILED_CONSUME", z);
            mMActivity.sendBroadcast(intent);
            AppMethodBeat.m2505o(48226);
            return;
        }
        C35525b bu = C35525b.m58303bu(0, "");
        if (this.tRq != null) {
            this.tRq.mo9553a(bu, null);
        }
        AppMethodBeat.m2505o(48226);
    }

    /* renamed from: b */
    private static void m58318b(MMActivity mMActivity, int i) {
        AppMethodBeat.m2504i(48223);
        C35525b bu = C35525b.m58303bu(i, "");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", bu.nqa);
        intent.putExtra("key_err_msg", bu.nqb);
        intent.putExtra("key_launch_ts", tRs);
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
        AppMethodBeat.m2505o(48223);
    }
}
