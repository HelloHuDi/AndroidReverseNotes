package com.tencent.p177mm.plugin.account.p275ui;

import android.accounts.AccountAuthenticatorResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C26529w.C26530a;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.model.C38041b.C18842b;
import com.tencent.p177mm.plugin.account.model.C38041b.C26601a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.plugin.account.ui.ContactsSyncUI */
public final class ContactsSyncUI extends MMActivity {
    private AccountAuthenticatorResponse gAw = null;
    Bundle gAx = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.ContactsSyncUI$a */
    final class C2014a implements C26601a {
        private boolean gAA;
        private C26530a gAB = new C20161();

        /* renamed from: com.tencent.mm.plugin.account.ui.ContactsSyncUI$a$1 */
        class C20161 implements C26530a {
            C20161() {
            }

            /* renamed from: o */
            public final void mo5767o(Bundle bundle) {
                AppMethodBeat.m2504i(124744);
                ContactsSyncUI contactsSyncUI = ContactsSyncUI.this;
                contactsSyncUI.gAx = bundle;
                contactsSyncUI.finish();
                AppMethodBeat.m2505o(124744);
            }
        }

        public C2014a(boolean z) {
            AppMethodBeat.m2504i(124747);
            this.gAA = z;
            AppMethodBeat.m2505o(124747);
        }

        /* renamed from: cy */
        public final int mo5765cy(final Context context) {
            AppMethodBeat.m2504i(124748);
            C1720g.m3534RN();
            if (!C1668a.m3395QX() || C1668a.m3393QT()) {
                AppMethodBeat.m2505o(124748);
                return 4;
            } else if (this.gAA) {
                final String str = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
                    AppMethodBeat.m2505o(124748);
                    return 2;
                } else if (C38033l.apR()) {
                    C30379h.m48428a(context, (int) C25738R.string.b2t, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(124745);
                            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
                            ContactsSyncUI.this.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            C2014a.this.mo5764P(context, str);
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                            AppMethodBeat.m2505o(124745);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(124746);
                            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
                            ContactsSyncUI.this.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
                            if (context instanceof Activity) {
                                ((Activity) context).finish();
                            }
                            AppMethodBeat.m2505o(124746);
                        }
                    });
                    AppMethodBeat.m2505o(124748);
                    return 5;
                } else {
                    int P = mo5764P(context, str);
                    AppMethodBeat.m2505o(124748);
                    return P;
                }
            } else {
                C4990ab.m7416i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
                C26529w.m42354a(ContactsSyncUI.this, this.gAB);
                AppMethodBeat.m2505o(124748);
                return 0;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: P */
        public final int mo5764P(Context context, String str) {
            AppMethodBeat.m2504i(124749);
            if (context == null) {
                AppMethodBeat.m2505o(124749);
                return 1;
            }
            int a = C26529w.m42355a(context, str, this.gAB);
            if (a == 2) {
                Toast.makeText(context, ContactsSyncUI.this.getString(C25738R.string.b2v), 1).show();
                AppMethodBeat.m2505o(124749);
                return 1;
            } else if (a == 3) {
                Toast.makeText(context, ContactsSyncUI.this.getString(C25738R.string.b2u), 1).show();
                AppMethodBeat.m2505o(124749);
                return 1;
            } else {
                AppMethodBeat.m2505o(124749);
                return 0;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.ContactsSyncUI$3 */
    class C188663 implements OnClickListener {
        C188663() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124743);
            dialogInterface.dismiss();
            ContactsSyncUI.this.finish();
            AppMethodBeat.m2505o(124743);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.ContactsSyncUI$2 */
    class C188672 implements OnClickListener {
        C188672() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124742);
            dialogInterface.dismiss();
            ContactsSyncUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(124742);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124750);
        super.onCreate(bundle);
        setMMTitle("");
        int a = C5068w.m7682a(getIntent(), "wizard_activity_result_code", 0);
        C4990ab.m7417i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", Integer.valueOf(a));
        switch (a) {
            case -1:
            case 0:
                C4990ab.m7417i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)), C5046bo.dpG());
                if (C35805b.m58707a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    C4990ab.m7417i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.WRITE_CONTACTS", 48, null, null)), C5046bo.dpG());
                    if (C35805b.m58707a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                        initView();
                        AppMethodBeat.m2505o(124750);
                        return;
                    }
                    AppMethodBeat.m2505o(124750);
                    return;
                }
                AppMethodBeat.m2505o(124750);
                return;
            case 1:
                finish();
                AppMethodBeat.m2505o(124750);
                return;
            default:
                C4990ab.m7412e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.m2505o(124750);
                return;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        boolean z = true;
        AppMethodBeat.m2504i(124751);
        C1720g.m3534RN();
        if (!C1668a.m3395QX() || C1668a.m3393QT()) {
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            AppMethodBeat.m2505o(124751);
        } else if (getIntent() == null) {
            C4990ab.m7412e("MicroMsg.ContactsSyncUI", "initView fail, intent is null");
            finish();
            AppMethodBeat.m2505o(124751);
        } else {
            int a = C5068w.m7682a(getIntent(), "contact_sync_scene", -1);
            if (getIntent().getAction() == null || !getIntent().getAction().equalsIgnoreCase("com.tencent.mm.login.ACTION_LOGIN")) {
                String resolveType = getIntent().resolveType(this);
                C4990ab.m7416i("MicroMsg.ContactsSyncUI", "scheme = " + resolveType + ", action = " + getIntent().getAction());
                if (!C5046bo.isNullOrNil(resolveType)) {
                    a = resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile") ? 2 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip") ? 12 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") ? 13 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline") ? 3 : resolveType.equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum") ? 6 : -1;
                }
            } else {
                a = 4;
            }
            if (a == -1) {
                C4990ab.m7412e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
                finish();
                AppMethodBeat.m2505o(124751);
                return;
            }
            C26601a c2014a;
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
                    if (C5068w.m7683a(getIntent(), "k_login_without_bind_mobile", false)) {
                        z = false;
                    }
                    c2014a = new C2014a(z);
                    break;
                case 2:
                case 6:
                    c2014a = new C18842b(1, C5068w.m7689n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 3:
                    c2014a = new C18842b(2, C5068w.m7689n(getIntent(), "k_phone_num"), getIntent().getData());
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
                    if (!getSharedPreferences(C4996ah.doA(), 0).getBoolean("upload_contacts_already_displayed", false)) {
                        Object c2014a2 = new C2014a(!C5068w.m7683a(getIntent(), "k_login_without_bind_mobile", false));
                        break;
                    }
                case 12:
                    c2014a2 = new C18842b(3, C5068w.m7689n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                case 13:
                    c2014a2 = new C18842b(4, C5068w.m7689n(getIntent(), "k_phone_num"), getIntent().getData());
                    break;
                default:
                    c2014a2 = null;
                    break;
            }
            if (c2014a2 != null) {
                Intent intent;
                Intent intent2;
                switch (c2014a2.mo5765cy(this)) {
                    case 2:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, BindMContactIntroUI.class);
                        intent2.putExtra("key_upload_scene", 2);
                        intent2.putExtra("bind_scene", 2);
                        MMWizardActivity.m23792b(this, intent2, intent);
                        finish();
                        break;
                    case 3:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, SimpleLoginUI.class);
                        MMWizardActivity.m23792b(this, intent2, intent);
                        finish();
                        break;
                    case 4:
                        intent = getIntent();
                        intent.setClass(this, ContactsSyncUI.class);
                        intent2 = new Intent();
                        intent2.setClass(this, SimpleLoginUI.class);
                        intent2.putExtra("accountAuthenticatorResponse", this.gAw);
                        MMWizardActivity.m23792b(this, intent2, intent);
                        finish();
                        break;
                    case 5:
                        AppMethodBeat.m2505o(124751);
                        return;
                }
            }
            C4990ab.m7412e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
            finish();
            AppMethodBeat.m2505o(124751);
        }
    }

    public final void finish() {
        AppMethodBeat.m2504i(124752);
        if (this.gAw != null) {
            if (this.gAx != null) {
                this.gAw.onResult(this.gAx);
            } else {
                this.gAw.onError(4, "canceled");
            }
            this.gAw = null;
        }
        super.finish();
        AppMethodBeat.m2505o(124752);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(124753);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(124753);
            return;
        }
        C4990ab.m7417i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbu), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C188672(), new C188663());
                    break;
                }
                final String str = strArr[0];
                new C7306ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(124740);
                        C4990ab.m7417i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", Boolean.valueOf(C35805b.m58707a(ContactsSyncUI.this, str.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)), str, C5046bo.dpG());
                        if (C35805b.m58707a(ContactsSyncUI.this, str.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)) {
                            ContactsSyncUI.this.initView();
                        }
                        AppMethodBeat.m2505o(124740);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(124741);
                        String str = super.toString() + "|checkContacts";
                        AppMethodBeat.m2505o(124741);
                        return str;
                    }
                });
                AppMethodBeat.m2505o(124753);
                return;
        }
        AppMethodBeat.m2505o(124753);
    }
}
