package com.tencent.mm.plugin.gwallet;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.RemoteException;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.VError;
import java.util.ArrayList;

@JgClassChecked(author = 31, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK, EType.RECEIVERCHECK})
public class GWalletUI extends Activity {
    BroadcastReceiver jIA = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(41677);
            if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(intent.getAction())) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("tokens");
                final boolean booleanExtra = intent.getBooleanExtra("IS_FAILED_CONSUME", false);
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    GWalletUI.a(GWalletUI.this, 0, null);
                    AppMethodBeat.o(41677);
                    return;
                }
                d.post(new com.tencent.mm.plugin.gwallet.a.b.AnonymousClass2(stringArrayListExtra, new b() {
                    public final void b(c cVar, Intent intent) {
                        AppMethodBeat.i(41676);
                        ab.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
                        Intent intent2 = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
                        if (booleanExtra) {
                            intent2.putExtra("RESPONSE_CODE", 100000001);
                        } else {
                            intent2.putExtra("RESPONSE_CODE", 0);
                        }
                        GWalletUI.a(GWalletUI.this, -1, intent2);
                        AppMethodBeat.o(41676);
                    }
                }, new ak()), "IabHelper_consumeAsync");
            }
            AppMethodBeat.o(41677);
        }
    };
    private com.tencent.mm.plugin.gwallet.a.b npw = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GWalletUI() {
        AppMethodBeat.i(41679);
        AppMethodBeat.o(41679);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41680);
        super.onCreate(bundle);
        requestWindowFeature(1);
        ab.d("MicroMsg.GWalletUI", "Creating IAB helper.");
        this.npw = new com.tencent.mm.plugin.gwallet.a.b(this);
        ab.d("MicroMsg.GWalletUI", "Starting setup.");
        this.npw.a(new a() {
            public final void a(c cVar) {
                AppMethodBeat.i(41674);
                ab.d("MicroMsg.GWalletUI", "Setup finished.");
                if (cVar.isSuccess()) {
                    if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(GWalletUI.this.getIntent().getAction())) {
                        GWalletUI.a(GWalletUI.this);
                        AppMethodBeat.o(41674);
                        return;
                    }
                    GWalletUI.this.hW(GWalletUI.this.getIntent().getBooleanExtra("is_direct", true));
                    AppMethodBeat.o(41674);
                    return;
                }
                ab.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: ".concat(String.valueOf(cVar)));
                Intent intent = new Intent();
                intent.putExtra("RESPONSE_CODE", cVar.bFQ());
                GWalletUI.a(GWalletUI.this, -1, intent);
                AppMethodBeat.o(41674);
            }
        });
        AppMethodBeat.o(41680);
    }

    public final void hW(final boolean z) {
        AppMethodBeat.i(41681);
        com.tencent.mm.plugin.gwallet.a.b bVar = this.npw;
        AnonymousClass4 anonymousClass4 = new b() {
            @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
            public final void b(c cVar, Intent intent) {
                AppMethodBeat.i(41678);
                ab.d("MicroMsg.GWalletUI", "Query inventory finished. data : ".concat(String.valueOf(intent)));
                if (intent == null) {
                    intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                    intent.putExtra("RESPONSE_CODE", cVar.bFQ());
                } else {
                    intent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                }
                if (!z) {
                    intent.putExtra("is_direct", false);
                }
                GWalletUI.this.sendBroadcast(intent);
                AppMethodBeat.o(41678);
            }
        };
        ak akVar = new ak();
        bVar.Oz("queryInventory");
        d.post(new com.tencent.mm.plugin.gwallet.a.b.AnonymousClass3("inapp", akVar, anonymousClass4), "IabHelper_queryInventoryAsync");
        AppMethodBeat.o(41681);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(41682);
        if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(intent.getAction())) {
            hW(intent.getBooleanExtra("is_direct", true));
        }
        super.onNewIntent(intent);
        AppMethodBeat.o(41682);
    }

    public void onStart() {
        AppMethodBeat.i(41683);
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        registerReceiver(this.jIA, intentFilter);
        AppMethodBeat.o(41683);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.i(41684);
        super.onStop();
        unregisterReceiver(this.jIA);
        AppMethodBeat.o(41684);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41685);
        com.tencent.mm.plugin.gwallet.a.b bVar = this.npw;
        if (i == bVar.czV) {
            bVar.Oz("handleActivityResult");
            if (intent == null) {
                com.tencent.mm.plugin.gwallet.a.b.OA("Null data in IAB activity result.");
                c cVar = new c(VError.ERROR_FACE_MODEL_INIT, "Null data in IAB result");
                if (bVar.npN != null) {
                    bVar.npN.b(cVar, null);
                }
                AppMethodBeat.o(41685);
                return;
            }
            int i3;
            Object obj = intent.getExtras().get("RESPONSE_CODE");
            if (obj == null) {
                com.tencent.mm.plugin.gwallet.a.b.OA("Intent with no response code, assuming OK (known issue)");
                i3 = 0;
            } else if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                i3 = (int) ((Long) obj).longValue();
            } else {
                com.tencent.mm.plugin.gwallet.a.b.OA("Unexpected type for intent response code.");
                com.tencent.mm.plugin.gwallet.a.b.OA(obj.getClass().getName());
                RuntimeException runtimeException = new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
                AppMethodBeat.o(41685);
                throw runtimeException;
            }
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            ab.d("MicroMsg.IabHelper", "Purchase data: ".concat(String.valueOf(stringExtra)));
            ab.d("MicroMsg.IabHelper", "Data signature: ".concat(String.valueOf(stringExtra2)));
            ab.d("MicroMsg.IabHelper", "Extras: " + intent.getExtras());
            ab.d("MicroMsg.IabHelper", "Expected item type: " + bVar.npO);
            c cVar2 = new c(i3, "Null data in IAB result");
            if (bVar.npN != null) {
                bVar.npN.b(cVar2, intent);
            }
        }
        AppMethodBeat.o(41685);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(41686);
        ab.d("MicroMsg.GWalletUI", "Destroying helper.");
        if (this.npw != null) {
            this.npw.dispose();
        }
        this.npw = null;
        super.onDestroy();
        AppMethodBeat.o(41686);
    }

    static /* synthetic */ void a(GWalletUI gWalletUI, int i, Intent intent) {
        AppMethodBeat.i(41687);
        ab.d("MicroMsg.GWalletUI", "Finish GWallet. setResult:".concat(String.valueOf(i)));
        gWalletUI.setResult(i, intent);
        gWalletUI.finish();
        AppMethodBeat.o(41687);
    }

    static /* synthetic */ void a(GWalletUI gWalletUI) {
        AppMethodBeat.i(41688);
        Intent intent = gWalletUI.getIntent();
        String stringExtra = intent.getStringExtra("product_id");
        String stringExtra2 = intent.getStringExtra("developer_pay_load");
        com.tencent.mm.plugin.gwallet.a.b bVar = gWalletUI.npw;
        String str = "inapp";
        AnonymousClass2 anonymousClass2 = new b() {
            /* JADX WARNING: Missing block: B:8:0x004e, code skipped:
            if (r2 == 0) goto L_0x0050;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
            public final void b(c cVar, Intent intent) {
                int i = 1;
                AppMethodBeat.i(41675);
                ab.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
                if (intent == null) {
                    intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
                    intent.putExtra("RESPONSE_CODE", cVar.bFQ());
                } else {
                    intent.setAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
                }
                GWalletUI.this.sendBroadcast(intent);
                if (!cVar.isSuccess()) {
                    int i2;
                    if (cVar.nqa == 7) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                }
                i = 0;
                if (i != 0) {
                    GWalletUI.a(GWalletUI.this, 0, null);
                }
                AppMethodBeat.o(41675);
            }
        };
        bVar.Oz("launchPurchaseFlow");
        if (!str.equals("subs") || bVar.npM) {
            try {
                ab.d("MicroMsg.IabHelper", "Constructing buy intent for " + stringExtra + ", item type: " + str + ", extraData: " + stringExtra2);
                Bundle a = bVar.npJ.a(3, bVar.mContext.getPackageName(), stringExtra, str, stringExtra2);
                int J = com.tencent.mm.plugin.gwallet.a.b.J(a);
                if (J != 0) {
                    anonymousClass2.b(new c(J, "Unable to buy item"), null);
                    AppMethodBeat.o(41688);
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
                ab.d("MicroMsg.IabHelper", "Launching buy intent for " + stringExtra + ". Request code: 10001");
                bVar.czV = 10001;
                bVar.npN = anonymousClass2;
                bVar.npO = str;
                gWalletUI.startIntentSenderForResult(pendingIntent.getIntentSender(), 10001, new Intent(), 0, 0, 0);
                AppMethodBeat.o(41688);
                return;
            } catch (SendIntentException e) {
                com.tencent.mm.plugin.gwallet.a.b.OA("SendIntentException while launching purchase flow for sku ".concat(String.valueOf(stringExtra)));
                ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                anonymousClass2.b(new c(-1004, "Failed to send intent."), null);
                AppMethodBeat.o(41688);
                return;
            } catch (RemoteException e2) {
                com.tencent.mm.plugin.gwallet.a.b.OA("RemoteException while launching purchase flow for sku ".concat(String.valueOf(stringExtra)));
                ab.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                anonymousClass2.b(new c(VError.ERROR_FACE_TXT_INIT, "Remote exception while starting purchase flow"), null);
                AppMethodBeat.o(41688);
                return;
            }
        }
        anonymousClass2.b(new c(-1009, "Subscriptions are not available."), null);
        AppMethodBeat.o(41688);
    }
}
