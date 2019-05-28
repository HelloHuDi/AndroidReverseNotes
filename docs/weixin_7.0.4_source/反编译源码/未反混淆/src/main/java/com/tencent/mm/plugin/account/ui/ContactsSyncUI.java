package com.tencent.mm.plugin.account.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public final class ContactsSyncUI extends MMActivity {
    private AccountAuthenticatorResponse gAw = null;
    Bundle gAx = null;

    final class a implements com.tencent.mm.plugin.account.model.b.a {
        private boolean gAA;
        private com.tencent.mm.platformtools.w.a gAB = new com.tencent.mm.platformtools.w.a() {
            public final void o(Bundle bundle) {
                AppMethodBeat.i(124744);
                ContactsSyncUI contactsSyncUI = ContactsSyncUI.this;
                contactsSyncUI.gAx = bundle;
                contactsSyncUI.finish();
                AppMethodBeat.o(124744);
            }
        };

        public a(boolean z) {
            AppMethodBeat.i(124747);
            this.gAA = z;
            AppMethodBeat.o(124747);
        }

        public final int cy(final Context context) {
            AppMethodBeat.i(124748);
            g.RN();
            if (!com.tencent.mm.kernel.a.QX() || com.tencent.mm.kernel.a.QT()) {
                AppMethodBeat.o(124748);
                return 4;
            } else if (this.gAA) {
                final String str = (String) g.RP().Ry().get(6, (Object) "");
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
                    AppMethodBeat.o(124748);
                    return 2;
                } else if (l.apR()) {
                    h.a(context, (int) R.string.b2t, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(124745);
                            g.RP().Ry().set(12322, Boolean.TRUE);
                            ContactsSyncUI.this.getSharedPreferences(ah.doA(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            a.this.P(context, str);
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                            AppMethodBeat.o(124745);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(124746);
                            g.RP().Ry().set(12322, Boolean.FALSE);
                            ContactsSyncUI.this.getSharedPreferences(ah.doA(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                            AppMethodBeat.o(124746);
                        }
                    });
                    AppMethodBeat.o(124748);
                    return 5;
                } else {
                    int P = P(context, str);
                    AppMethodBeat.o(124748);
                    return P;
                }
            } else {
                ab.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
                w.a(ContactsSyncUI.this, this.gAB);
                AppMethodBeat.o(124748);
                return 0;
            }
        }

        /* Access modifiers changed, original: final */
        public final int P(Context context, String str) {
            AppMethodBeat.i(124749);
            if (context == null) {
                AppMethodBeat.o(124749);
                return 1;
            }
            int a = w.a(context, str, this.gAB);
            if (a == 2) {
                Toast.makeText(context, ContactsSyncUI.this.getString(R.string.b2v), 1).show();
                AppMethodBeat.o(124749);
                return 1;
            } else if (a == 3) {
                Toast.makeText(context, ContactsSyncUI.this.getString(R.string.b2u), 1).show();
                AppMethodBeat.o(124749);
                return 1;
            } else {
                AppMethodBeat.o(124749);
                return 0;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(124750);
        super.onCreate(bundle);
        setMMTitle("");
        int a = com.tencent.mm.sdk.platformtools.w.a(getIntent(), "wizard_activity_result_code", 0);
        ab.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", Integer.valueOf(a));
        switch (a) {
            case -1:
            case 0:
                ab.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bo.dpG());
                if (b.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    ab.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", Boolean.valueOf(b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)), bo.dpG());
                    if (b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                        initView();
                        AppMethodBeat.o(124750);
                        return;
                    }
                    AppMethodBeat.o(124750);
                    return;
                }
                AppMethodBeat.o(124750);
                return;
            case 1:
                finish();
                AppMethodBeat.o(124750);
                return;
            default:
                ab.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.o(124750);
                return;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        boolean z = true;
        AppMethodBeat.i(124751);
        g.RN();
        if (!com.tencent.mm.kernel.a.QX() || com.tencent.mm.kernel.a.QT()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.o(124751);
        } else if (getIntent() == null) {
            ab.e("MicroMsg.ContactsSyncUI", "initView fail, intent is null");
            finish();
            AppMethodBeat.o(124751);
        } else {
            int a = com.tencent.mm.sdk.platformtools.w.a(getIntent(), "contact_sync_scene", -1);
            if (getIntent().getAction() == null || !getIntent().getAction().equalsIgnoreCase("com.tencent.mm.login.ACTION_LOGIN")) {
                String resolveType = getIntent().resolveType(this);
                ab.i("MicroMsg.ContactsSyncUI", "scheme = " + resolveType + ", action = " + getIntent().getAction());
                if (!bo.isNullOrNil(resolveType)) {
                    a = resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile") ? 2 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip") ? 12 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") ? 13 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline") ? 3 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum") ? 6 : -1;
                }
            } else {
                a = 4;
            }
            if (a == -1) {
                ab.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
                finish();
                AppMethodBeat.o(124751);
                return;
            }
            com.tencent.mm.plugin.account.model.b.a aVar;
            Parcelable parcelableExtra;
            switch (a) {
                case 1:
                    parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
                    this.gAw = null;
                    if (parcelableExtra != null && (parcelableExtra instanceof AccountAuthenticatorResponse)) {
                        this.gAw = (AccountAuthenticatorResponse) parcelableExtra;
                    }
                    if (this.gAw != null) {
                        this.gAw.onRequestContinued();
                    }
                    if (com.tencent.mm.sdk.platformtools.w.a(getIntent(), "k_login_without_bind_mobile", false)) {
                        z = false;
                    }
                    aVar = new a(z);
                    break;
                case 2:
                case 6:
                    aVar = new com.tencent.mm.plugin.account.model.b.b(1, com.tencent.mm.sdk.platformtools.w.n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 3:
                    aVar = new com.tencent.mm.plugin.account.model.b.b(2, com.tencent.mm.sdk.platformtools.w.n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 4:
                    parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
                    this.gAw = null;
                    if (parcelableExtra != null && (parcelableExtra instanceof AccountAuthenticatorResponse)) {
                        this.gAw = (AccountAuthenticatorResponse) parcelableExtra;
                    }
                    if (this.gAw != null) {
                        this.gAw.onRequestContinued();
                    }
                    if (!getSharedPreferences(ah.doA(), 0).getBoolean("upload_contacts_already_displayed", false)) {
                        Object aVar2 = new a(!com.tencent.mm.sdk.platformtools.w.a(getIntent(), "k_login_without_bind_mobile", false));
                        break;
                    }
                case 12:
                    aVar2 = new com.tencent.mm.plugin.account.model.b.b(3, com.tencent.mm.sdk.platformtools.w.n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 13:
                    aVar2 = new com.tencent.mm.plugin.account.model.b.b(4, com.tencent.mm.sdk.platformtools.w.n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                default:
                    aVar2 = null;
                    break;
            }
            if (aVar2 != null) {
                Intent intent;
                Intent intent2;
                switch (aVar2.cy(this)) {
                    case 2:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, BindMContactIntroUI.class);
                        intent2.putExtra("key_upload_scene", 2);
                        intent2.putExtra("bind_scene", 2);
                        MMWizardActivity.b(this, intent2, intent);
                        finish();
                        break;
                    case 3:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, SimpleLoginUI.class);
                        MMWizardActivity.b(this, intent2, intent);
                        finish();
                        break;
                    case 4:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, SimpleLoginUI.class);
                        intent2.putExtra("accountAuthenticatorResponse", this.gAw);
                        MMWizardActivity.b(this, intent2, intent);
                        finish();
                        break;
                    case 5:
                        AppMethodBeat.o(124751);
                        return;
                }
            }
            ab.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
            finish();
            AppMethodBeat.o(124751);
        }
    }

    public final void finish() {
        AppMethodBeat.i(124752);
        if (this.gAw != null) {
            if (this.gAx != null) {
                this.gAw.onResult(this.gAx);
            } else {
                this.gAw.onError(4, "canceled");
            }
            this.gAw = null;
        }
        super.finish();
        AppMethodBeat.o(124752);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(124753);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(124753);
            return;
        }
        ab.i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbu), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(124742);
                            dialogInterface.dismiss();
                            ContactsSyncUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(124742);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(124743);
                            dialogInterface.dismiss();
                            ContactsSyncUI.this.finish();
                            AppMethodBeat.o(124743);
                        }
                    });
                    break;
                }
                final String str = strArr[0];
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(124740);
                        ab.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", Boolean.valueOf(b.a(ContactsSyncUI.this, str.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)), str, bo.dpG());
                        if (b.a(ContactsSyncUI.this, str.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)) {
                            ContactsSyncUI.this.initView();
                        }
                        AppMethodBeat.o(124740);
                    }

                    public final String toString() {
                        AppMethodBeat.i(124741);
                        String str = super.toString() + "|checkContacts";
                        AppMethodBeat.o(124741);
                        return str;
                    }
                });
                AppMethodBeat.o(124753);
                return;
        }
        AppMethodBeat.o(124753);
    }
}
