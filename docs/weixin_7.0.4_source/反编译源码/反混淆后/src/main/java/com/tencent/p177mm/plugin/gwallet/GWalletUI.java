package com.tencent.p177mm.plugin.gwallet;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.RemoteException;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.p802jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gwallet.p979a.C28276b;
import com.tencent.p177mm.plugin.gwallet.p979a.C28276b.C21047a;
import com.tencent.p177mm.plugin.gwallet.p979a.C28276b.C21048b;
import com.tencent.p177mm.plugin.gwallet.p979a.C28276b.C282772;
import com.tencent.p177mm.plugin.gwallet.p979a.C28276b.C282793;
import com.tencent.p177mm.plugin.gwallet.p979a.C28282c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.VError;
import java.util.ArrayList;

@JgClassChecked(author = 31, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK, EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.plugin.gwallet.GWalletUI */
public class GWalletUI extends Activity {
    BroadcastReceiver jIA = new C343283();
    private C28276b npw = null;

    /* renamed from: com.tencent.mm.plugin.gwallet.GWalletUI$1 */
    class C32791 implements C21047a {
        C32791() {
        }

        /* renamed from: a */
        public final void mo7648a(C28282c c28282c) {
            AppMethodBeat.m2504i(41674);
            C4990ab.m7410d("MicroMsg.GWalletUI", "Setup finished.");
            if (c28282c.isSuccess()) {
                if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(GWalletUI.this.getIntent().getAction())) {
                    GWalletUI.m56270a(GWalletUI.this);
                    AppMethodBeat.m2505o(41674);
                    return;
                }
                GWalletUI.this.mo54874hW(GWalletUI.this.getIntent().getBooleanExtra("is_direct", true));
                AppMethodBeat.m2505o(41674);
                return;
            }
            C4990ab.m7412e("MicroMsg.GWalletUI", "Problem setting up in-app billing: ".concat(String.valueOf(c28282c)));
            Intent intent = new Intent();
            intent.putExtra("RESPONSE_CODE", c28282c.bFQ());
            GWalletUI.m56271a(GWalletUI.this, -1, intent);
            AppMethodBeat.m2505o(41674);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.GWalletUI$2 */
    class C343272 implements C21048b {
        C343272() {
        }

        /* JADX WARNING: Missing block: B:8:0x004e, code skipped:
            if (r2 == 0) goto L_0x0050;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
        /* renamed from: b */
        public final void mo7649b(C28282c c28282c, Intent intent) {
            int i = 1;
            AppMethodBeat.m2504i(41675);
            C4990ab.m7410d("MicroMsg.GWalletUI", "Purchase finished: " + c28282c + ", purchase: " + intent);
            if (intent == null) {
                intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
                intent.putExtra("RESPONSE_CODE", c28282c.bFQ());
            } else {
                intent.setAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
            }
            GWalletUI.this.sendBroadcast(intent);
            if (!c28282c.isSuccess()) {
                int i2;
                if (c28282c.nqa == 7) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            }
            i = 0;
            if (i != 0) {
                GWalletUI.m56271a(GWalletUI.this, 0, null);
            }
            AppMethodBeat.m2505o(41675);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gwallet.GWalletUI$3 */
    class C343283 extends BroadcastReceiver {
        C343283() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(41677);
            if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(intent.getAction())) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("tokens");
                final boolean booleanExtra = intent.getBooleanExtra("IS_FAILED_CONSUME", false);
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    GWalletUI.m56271a(GWalletUI.this, 0, null);
                    AppMethodBeat.m2505o(41677);
                    return;
                }
                C7305d.post(new C282772(stringArrayListExtra, new C21048b() {
                    /* renamed from: b */
                    public final void mo7649b(C28282c c28282c, Intent intent) {
                        AppMethodBeat.m2504i(41676);
                        C4990ab.m7410d("MicroMsg.GWalletUI", "Purchase finished: " + c28282c + ", purchase: " + intent);
                        Intent intent2 = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
                        if (booleanExtra) {
                            intent2.putExtra("RESPONSE_CODE", 100000001);
                        } else {
                            intent2.putExtra("RESPONSE_CODE", 0);
                        }
                        GWalletUI.m56271a(GWalletUI.this, -1, intent2);
                        AppMethodBeat.m2505o(41676);
                    }
                }, new C7306ak()), "IabHelper_consumeAsync");
            }
            AppMethodBeat.m2505o(41677);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GWalletUI() {
        AppMethodBeat.m2504i(41679);
        AppMethodBeat.m2505o(41679);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41680);
        super.onCreate(bundle);
        requestWindowFeature(1);
        C4990ab.m7410d("MicroMsg.GWalletUI", "Creating IAB helper.");
        this.npw = new C28276b(this);
        C4990ab.m7410d("MicroMsg.GWalletUI", "Starting setup.");
        this.npw.mo46203a(new C32791());
        AppMethodBeat.m2505o(41680);
    }

    /* renamed from: hW */
    public final void mo54874hW(final boolean z) {
        AppMethodBeat.m2504i(41681);
        C28276b c28276b = this.npw;
        C343294 c343294 = new C21048b() {
            @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
            /* renamed from: b */
            public final void mo7649b(C28282c c28282c, Intent intent) {
                AppMethodBeat.m2504i(41678);
                C4990ab.m7410d("MicroMsg.GWalletUI", "Query inventory finished. data : ".concat(String.valueOf(intent)));
                if (intent == null) {
                    intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                    intent.putExtra("RESPONSE_CODE", c28282c.bFQ());
                } else {
                    intent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                }
                if (!z) {
                    intent.putExtra("is_direct", false);
                }
                GWalletUI.this.sendBroadcast(intent);
                AppMethodBeat.m2505o(41678);
            }
        };
        C7306ak c7306ak = new C7306ak();
        c28276b.mo46202Oz("queryInventory");
        C7305d.post(new C282793("inapp", c7306ak, c343294), "IabHelper_queryInventoryAsync");
        AppMethodBeat.m2505o(41681);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(41682);
        if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(intent.getAction())) {
            mo54874hW(intent.getBooleanExtra("is_direct", true));
        }
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(41682);
    }

    public void onStart() {
        AppMethodBeat.m2504i(41683);
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        registerReceiver(this.jIA, intentFilter);
        AppMethodBeat.m2505o(41683);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.m2504i(41684);
        super.onStop();
        unregisterReceiver(this.jIA);
        AppMethodBeat.m2505o(41684);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41685);
        C28276b c28276b = this.npw;
        if (i == c28276b.czV) {
            c28276b.mo46202Oz("handleActivityResult");
            if (intent == null) {
                C28276b.m44864OA("Null data in IAB activity result.");
                C28282c c28282c = new C28282c(VError.ERROR_FACE_MODEL_INIT, "Null data in IAB result");
                if (c28276b.npN != null) {
                    c28276b.npN.mo7649b(c28282c, null);
                }
                AppMethodBeat.m2505o(41685);
                return;
            }
            int i3;
            Object obj = intent.getExtras().get("RESPONSE_CODE");
            if (obj == null) {
                C28276b.m44864OA("Intent with no response code, assuming OK (known issue)");
                i3 = 0;
            } else if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                i3 = (int) ((Long) obj).longValue();
            } else {
                C28276b.m44864OA("Unexpected type for intent response code.");
                C28276b.m44864OA(obj.getClass().getName());
                RuntimeException runtimeException = new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
                AppMethodBeat.m2505o(41685);
                throw runtimeException;
            }
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            C4990ab.m7410d("MicroMsg.IabHelper", "Purchase data: ".concat(String.valueOf(stringExtra)));
            C4990ab.m7410d("MicroMsg.IabHelper", "Data signature: ".concat(String.valueOf(stringExtra2)));
            C4990ab.m7410d("MicroMsg.IabHelper", "Extras: " + intent.getExtras());
            C4990ab.m7410d("MicroMsg.IabHelper", "Expected item type: " + c28276b.npO);
            C28282c c28282c2 = new C28282c(i3, "Null data in IAB result");
            if (c28276b.npN != null) {
                c28276b.npN.mo7649b(c28282c2, intent);
            }
        }
        AppMethodBeat.m2505o(41685);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(41686);
        C4990ab.m7410d("MicroMsg.GWalletUI", "Destroying helper.");
        if (this.npw != null) {
            this.npw.dispose();
        }
        this.npw = null;
        super.onDestroy();
        AppMethodBeat.m2505o(41686);
    }

    /* renamed from: a */
    static /* synthetic */ void m56271a(GWalletUI gWalletUI, int i, Intent intent) {
        AppMethodBeat.m2504i(41687);
        C4990ab.m7410d("MicroMsg.GWalletUI", "Finish GWallet. setResult:".concat(String.valueOf(i)));
        gWalletUI.setResult(i, intent);
        gWalletUI.finish();
        AppMethodBeat.m2505o(41687);
    }

    /* renamed from: a */
    static /* synthetic */ void m56270a(GWalletUI gWalletUI) {
        AppMethodBeat.m2504i(41688);
        Intent intent = gWalletUI.getIntent();
        String stringExtra = intent.getStringExtra("product_id");
        String stringExtra2 = intent.getStringExtra("developer_pay_load");
        C28276b c28276b = gWalletUI.npw;
        String str = "inapp";
        C343272 c343272 = new C343272();
        c28276b.mo46202Oz("launchPurchaseFlow");
        if (!str.equals("subs") || c28276b.npM) {
            try {
                C4990ab.m7410d("MicroMsg.IabHelper", "Constructing buy intent for " + stringExtra + ", item type: " + str + ", extraData: " + stringExtra2);
                Bundle a = c28276b.npJ.mo18551a(3, c28276b.mContext.getPackageName(), stringExtra, str, stringExtra2);
                int J = C28276b.m44863J(a);
                if (J != 0) {
                    c343272.mo7649b(new C28282c(J, "Unable to buy item"), null);
                    AppMethodBeat.m2505o(41688);
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
                C4990ab.m7410d("MicroMsg.IabHelper", "Launching buy intent for " + stringExtra + ". Request code: 10001");
                c28276b.czV = 10001;
                c28276b.npN = c343272;
                c28276b.npO = str;
                gWalletUI.startIntentSenderForResult(pendingIntent.getIntentSender(), 10001, new Intent(), 0, 0, 0);
                AppMethodBeat.m2505o(41688);
                return;
            } catch (SendIntentException e) {
                C28276b.m44864OA("SendIntentException while launching purchase flow for sku ".concat(String.valueOf(stringExtra)));
                C4990ab.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                c343272.mo7649b(new C28282c(-1004, "Failed to send intent."), null);
                AppMethodBeat.m2505o(41688);
                return;
            } catch (RemoteException e2) {
                C28276b.m44864OA("RemoteException while launching purchase flow for sku ".concat(String.valueOf(stringExtra)));
                C4990ab.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                c343272.mo7649b(new C28282c(VError.ERROR_FACE_TXT_INIT, "Remote exception while starting purchase flow"), null);
                AppMethodBeat.m2505o(41688);
                return;
            }
        }
        c343272.mo7649b(new C28282c(-1009, "Subscriptions are not available."), null);
        AppMethodBeat.m2505o(41688);
    }
}
