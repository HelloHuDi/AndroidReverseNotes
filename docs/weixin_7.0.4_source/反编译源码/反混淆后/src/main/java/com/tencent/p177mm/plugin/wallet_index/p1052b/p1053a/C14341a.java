package com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_index.p564c.C35525b;
import com.tencent.p177mm.plugin.wallet_index.p566ui.C4487d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.wallet_index.b.a.a */
public final class C14341a {

    /* renamed from: com.tencent.mm.plugin.wallet_index.b.a.a$a */
    public interface C14342a {
        /* renamed from: a */
        void mo26620a(C35525b c35525b, C29690b c29690b);
    }

    /* renamed from: a */
    public static C29690b m22520a(Intent intent, C4487d c4487d) {
        AppMethodBeat.m2504i(48165);
        C35525b bu;
        if (intent == null) {
            C14341a.m22518OA("Null data in IAB activity result.");
            bu = C35525b.m58303bu(5, "");
            if (c4487d != null) {
                c4487d.mo9553a(bu, null);
            }
            AppMethodBeat.m2505o(48165);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            C4990ab.m7410d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            C4990ab.m7410d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(stringExtra)));
            C4990ab.m7410d("MicroMsg.IabResolver", "Data signature: ".concat(String.valueOf(stringExtra2)));
            C4990ab.m7410d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                C14341a.m22518OA("BUG: either purchaseData or dataSignature is null.");
                bu = C35525b.m58303bu(5, "");
                if (c4487d != null) {
                    c4487d.mo9553a(bu, null);
                }
                AppMethodBeat.m2505o(48165);
                return null;
            }
            try {
                C22688c c22688c = new C22688c("inapp", stringExtra, stringExtra2);
                stringExtra = c22688c.kWz;
                C4990ab.m7410d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (c4487d != null) {
                    c4487d.mo9553a(C35525b.m58303bu(0, ""), c22688c);
                }
                C29690b c29690b = new C29690b(stringExtra, c22688c);
                AppMethodBeat.m2505o(48165);
                return c29690b;
            } catch (JSONException e) {
                C14341a.m22518OA("Failed to parse purchase data.");
                C4990ab.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                bu = C35525b.m58303bu(5, "");
                if (c4487d != null) {
                    c4487d.mo9553a(bu, null);
                }
                AppMethodBeat.m2505o(48165);
                return null;
            }
        }
        C14341a.m22518OA("Purchase failed. Response: ".concat(String.valueOf(intExtra)));
        bu = C35525b.m58303bu(intExtra, "");
        if (c4487d != null) {
            c4487d.mo9553a(bu, null);
        }
        AppMethodBeat.m2505o(48165);
        return null;
    }

    /* renamed from: a */
    public static int m22519a(Intent intent, C14342a c14342a) {
        AppMethodBeat.m2504i(48166);
        C29690b c29690b = new C29690b();
        int ay = C14341a.m22521ay(intent);
        C4990ab.m7410d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(ay));
        if (ay != 0) {
            c14342a.mo26620a(C35525b.m58303bu(ay, ""), null);
            AppMethodBeat.m2505o(48166);
            return ay;
        } else if (intent.hasExtra("INAPP_PURCHASE_ITEM_LIST") && intent.hasExtra("INAPP_PURCHASE_DATA_LIST") && intent.hasExtra("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
            ArrayList stringArrayListExtra3 = intent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
            int i = 0;
            while (i < stringArrayListExtra2.size()) {
                try {
                    String str = (String) stringArrayListExtra2.get(i);
                    String str2 = (String) stringArrayListExtra3.get(i);
                    C4990ab.m7410d("MicroMsg.IabResolver", "Sku is owned: ".concat(String.valueOf((String) stringArrayListExtra.get(i))));
                    C22688c c22688c = new C22688c("inapp", str, str2);
                    if (TextUtils.isEmpty(c22688c.gtl)) {
                        C4990ab.m7420w("MicroMsg.IabResolver", "In-app billing warning: ".concat(String.valueOf("BUG: empty/null token!")));
                        C4990ab.m7410d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str)));
                    }
                    c29690b.tQQ.put(c22688c.kWz, c22688c);
                    i++;
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                    c14342a.mo26620a(C35525b.m58303bu(5, ""), c29690b);
                }
            }
            c14342a.mo26620a(C35525b.m58303bu(0, ""), c29690b);
            AppMethodBeat.m2505o(48166);
            return 0;
        } else {
            C14341a.m22518OA("Bundle returned from getPurchases() doesn't contain required fields.");
            c14342a.mo26620a(C35525b.m58303bu(5, ""), null);
            AppMethodBeat.m2505o(48166);
            return 5;
        }
    }

    /* renamed from: OA */
    private static void m22518OA(String str) {
        AppMethodBeat.m2504i(48167);
        C4990ab.m7412e("MicroMsg.IabResolver", "In-app billing error: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(48167);
    }

    /* renamed from: ay */
    public static int m22521ay(Intent intent) {
        AppMethodBeat.m2504i(48168);
        if (intent == null) {
            C14341a.m22518OA("Intent with no response code, assuming OK (known issue)");
            AppMethodBeat.m2505o(48168);
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        int intValue;
        if (obj == null) {
            C14341a.m22518OA("Intent with no response code, assuming OK (known issue)");
            AppMethodBeat.m2505o(48168);
            return 0;
        } else if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            AppMethodBeat.m2505o(48168);
            return intValue;
        } else if (obj instanceof Long) {
            intValue = (int) ((Long) obj).longValue();
            AppMethodBeat.m2505o(48168);
            return intValue;
        } else {
            C14341a.m22518OA("Unexpected type for intent response code.");
            C14341a.m22518OA(obj.getClass().getName());
            RuntimeException runtimeException = new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
            AppMethodBeat.m2505o(48168);
            throw runtimeException;
        }
    }
}
