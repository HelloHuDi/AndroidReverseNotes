package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.c.b;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONException;

public final class a {

    public interface a {
        void a(b bVar, b bVar2);
    }

    public static b a(Intent intent, d dVar) {
        AppMethodBeat.i(48165);
        b bu;
        if (intent == null) {
            OA("Null data in IAB activity result.");
            bu = b.bu(5, "");
            if (dVar != null) {
                dVar.a(bu, null);
            }
            AppMethodBeat.o(48165);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            ab.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            ab.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(stringExtra)));
            ab.d("MicroMsg.IabResolver", "Data signature: ".concat(String.valueOf(stringExtra2)));
            ab.d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                OA("BUG: either purchaseData or dataSignature is null.");
                bu = b.bu(5, "");
                if (dVar != null) {
                    dVar.a(bu, null);
                }
                AppMethodBeat.o(48165);
                return null;
            }
            try {
                c cVar = new c("inapp", stringExtra, stringExtra2);
                stringExtra = cVar.kWz;
                ab.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (dVar != null) {
                    dVar.a(b.bu(0, ""), cVar);
                }
                b bVar = new b(stringExtra, cVar);
                AppMethodBeat.o(48165);
                return bVar;
            } catch (JSONException e) {
                OA("Failed to parse purchase data.");
                ab.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                bu = b.bu(5, "");
                if (dVar != null) {
                    dVar.a(bu, null);
                }
                AppMethodBeat.o(48165);
                return null;
            }
        }
        OA("Purchase failed. Response: ".concat(String.valueOf(intExtra)));
        bu = b.bu(intExtra, "");
        if (dVar != null) {
            dVar.a(bu, null);
        }
        AppMethodBeat.o(48165);
        return null;
    }

    public static int a(Intent intent, a aVar) {
        AppMethodBeat.i(48166);
        b bVar = new b();
        int ay = ay(intent);
        ab.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(ay));
        if (ay != 0) {
            aVar.a(b.bu(ay, ""), null);
            AppMethodBeat.o(48166);
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
                    ab.d("MicroMsg.IabResolver", "Sku is owned: ".concat(String.valueOf((String) stringArrayListExtra.get(i))));
                    c cVar = new c("inapp", str, str2);
                    if (TextUtils.isEmpty(cVar.gtl)) {
                        ab.w("MicroMsg.IabResolver", "In-app billing warning: ".concat(String.valueOf("BUG: empty/null token!")));
                        ab.d("MicroMsg.IabResolver", "Purchase data: ".concat(String.valueOf(str)));
                    }
                    bVar.tQQ.put(cVar.kWz, cVar);
                    i++;
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                    aVar.a(b.bu(5, ""), bVar);
                }
            }
            aVar.a(b.bu(0, ""), bVar);
            AppMethodBeat.o(48166);
            return 0;
        } else {
            OA("Bundle returned from getPurchases() doesn't contain required fields.");
            aVar.a(b.bu(5, ""), null);
            AppMethodBeat.o(48166);
            return 5;
        }
    }

    private static void OA(String str) {
        AppMethodBeat.i(48167);
        ab.e("MicroMsg.IabResolver", "In-app billing error: ".concat(String.valueOf(str)));
        AppMethodBeat.o(48167);
    }

    public static int ay(Intent intent) {
        AppMethodBeat.i(48168);
        if (intent == null) {
            OA("Intent with no response code, assuming OK (known issue)");
            AppMethodBeat.o(48168);
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        int intValue;
        if (obj == null) {
            OA("Intent with no response code, assuming OK (known issue)");
            AppMethodBeat.o(48168);
            return 0;
        } else if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(48168);
            return intValue;
        } else if (obj instanceof Long) {
            intValue = (int) ((Long) obj).longValue();
            AppMethodBeat.o(48168);
            return intValue;
        } else {
            OA("Unexpected type for intent response code.");
            OA(obj.getClass().getName());
            RuntimeException runtimeException = new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
            AppMethodBeat.o(48168);
            throw runtimeException;
        }
    }
}
