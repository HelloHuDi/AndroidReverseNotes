package com.tencent.mm.plugin.account.model;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI;
import com.tencent.mm.sdk.platformtools.ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class AccountAuthenticatorService extends Service {
    private static a gyy = null;

    static class a extends AbstractAccountAuthenticator {
        private Context mContext;

        public a(Context context) {
            super(context);
            this.mContext = context;
        }

        public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
            AppMethodBeat.i(124645);
            Bundle bundle2 = new Bundle();
            Intent intent = new Intent(this.mContext, ContactsSyncUI.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            intent.putExtra("contact_sync_scene", 1);
            bundle2.putParcelable("intent", intent);
            AppMethodBeat.o(124645);
            return bundle2;
        }

        public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
            AppMethodBeat.i(124646);
            ab.i("MicroMsg.AccountAuthenticatorService", "confirmCredentials");
            AppMethodBeat.o(124646);
            return null;
        }

        public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            AppMethodBeat.i(124647);
            ab.i("MicroMsg.AccountAuthenticatorService", "editProperties");
            AppMethodBeat.o(124647);
            return null;
        }

        public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            AppMethodBeat.i(124648);
            ab.i("MicroMsg.AccountAuthenticatorService", "getAuthToken");
            AppMethodBeat.o(124648);
            return null;
        }

        public final String getAuthTokenLabel(String str) {
            AppMethodBeat.i(124649);
            ab.i("MicroMsg.AccountAuthenticatorService", "getAuthTokenLabel");
            AppMethodBeat.o(124649);
            return null;
        }

        public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
            AppMethodBeat.i(124650);
            ab.i("MicroMsg.AccountAuthenticatorService", "hasFeatures: ".concat(String.valueOf(strArr)));
            AppMethodBeat.o(124650);
            return null;
        }

        public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            AppMethodBeat.i(124651);
            ab.i("MicroMsg.AccountAuthenticatorService", "updateCredentials");
            AppMethodBeat.o(124651);
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(124652);
        if (intent == null) {
            AppMethodBeat.o(124652);
            return null;
        } else if (intent.getAction() == null || !intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            AppMethodBeat.o(124652);
            return null;
        } else {
            if (gyy == null) {
                gyy = new a(this);
            }
            IBinder iBinder = gyy.getIBinder();
            AppMethodBeat.o(124652);
            return iBinder;
        }
    }
}
