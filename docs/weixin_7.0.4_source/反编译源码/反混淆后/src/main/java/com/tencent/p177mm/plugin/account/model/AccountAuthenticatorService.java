package com.tencent.p177mm.plugin.account.model;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.account.p275ui.ContactsSyncUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
/* renamed from: com.tencent.mm.plugin.account.model.AccountAuthenticatorService */
public class AccountAuthenticatorService extends Service {
    private static C18837a gyy = null;

    /* renamed from: com.tencent.mm.plugin.account.model.AccountAuthenticatorService$a */
    static class C18837a extends AbstractAccountAuthenticator {
        private Context mContext;

        public C18837a(Context context) {
            super(context);
            this.mContext = context;
        }

        public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
            AppMethodBeat.m2504i(124645);
            Bundle bundle2 = new Bundle();
            Intent intent = new Intent(this.mContext, ContactsSyncUI.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            intent.putExtra("contact_sync_scene", 1);
            bundle2.putParcelable("intent", intent);
            AppMethodBeat.m2505o(124645);
            return bundle2;
        }

        public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
            AppMethodBeat.m2504i(124646);
            C4990ab.m7416i("MicroMsg.AccountAuthenticatorService", "confirmCredentials");
            AppMethodBeat.m2505o(124646);
            return null;
        }

        public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            AppMethodBeat.m2504i(124647);
            C4990ab.m7416i("MicroMsg.AccountAuthenticatorService", "editProperties");
            AppMethodBeat.m2505o(124647);
            return null;
        }

        public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            AppMethodBeat.m2504i(124648);
            C4990ab.m7416i("MicroMsg.AccountAuthenticatorService", "getAuthToken");
            AppMethodBeat.m2505o(124648);
            return null;
        }

        public final String getAuthTokenLabel(String str) {
            AppMethodBeat.m2504i(124649);
            C4990ab.m7416i("MicroMsg.AccountAuthenticatorService", "getAuthTokenLabel");
            AppMethodBeat.m2505o(124649);
            return null;
        }

        public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
            AppMethodBeat.m2504i(124650);
            C4990ab.m7416i("MicroMsg.AccountAuthenticatorService", "hasFeatures: ".concat(String.valueOf(strArr)));
            AppMethodBeat.m2505o(124650);
            return null;
        }

        public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            AppMethodBeat.m2504i(124651);
            C4990ab.m7416i("MicroMsg.AccountAuthenticatorService", "updateCredentials");
            AppMethodBeat.m2505o(124651);
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(124652);
        if (intent == null) {
            AppMethodBeat.m2505o(124652);
            return null;
        } else if (intent.getAction() == null || !intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            AppMethodBeat.m2505o(124652);
            return null;
        } else {
            if (gyy == null) {
                gyy = new C18837a(this);
            }
            IBinder iBinder = gyy.getIBinder();
            AppMethodBeat.m2505o(124652);
            return iBinder;
        }
    }
}
