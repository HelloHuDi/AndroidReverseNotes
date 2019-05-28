package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.C11932a;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.C34180b;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.p177mm.plugin.wallet.p1658b.C46333a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.r */
public final class C3117r implements C11927i {
    /* renamed from: a */
    public final void mo7361a(MMActivity mMActivity, C11932a c11932a, Bundle bundle) {
        AppMethodBeat.m2504i(41566);
        C34180b c34180b = new C34180b(mMActivity, c11932a, bundle);
        c34180b.setCancelable(false);
        mMActivity.getLifecycle().addObserver(c34180b);
        c34180b.show();
        AppMethodBeat.m2505o(41566);
    }

    /* renamed from: g */
    public final boolean mo7362g(final MMActivity mMActivity) {
        AppMethodBeat.m2504i(41567);
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            C4990ab.m7416i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
            AppMethodBeat.m2505o(41567);
            return false;
        }
        Bundle bundle;
        final C40931c aE = C24143a.m37112aE(mMActivity);
        Bundle bundle2 = new Bundle();
        if (aE != null) {
            bundle = aE.mqu;
        } else {
            bundle = bundle2;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            C4990ab.m7416i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
            AppMethodBeat.m2505o(41567);
            return false;
        }
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        C4990ab.m7417i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", Boolean.valueOf(C46333a.cOQ()), Boolean.valueOf(c30052l.bxo()), Boolean.valueOf(C46333a.cOR()), Boolean.valueOf(c30052l.bxB()));
        if (!(c30052l.bxe() || c30052l.bxh())) {
            if (C46333a.cOQ() && c30052l.bxo() && C46333a.cOR() && c30052l.bxB()) {
                final C15532i c15532i = new C15532i(mMActivity, C25738R.style.f11415zt);
                c15532i.setContentView(2130968851);
                final CheckBox checkBox = (CheckBox) c15532i.findViewById(2131821792);
                TextView textView = (TextView) c15532i.findViewById(2131821793);
                TextView textView2 = (TextView) c15532i.findViewById(2131821794);
                TextView textView3 = (TextView) c15532i.findViewById(2131821795);
                Bundle bundle3 = new Bundle();
                if (aE != null) {
                    bundle3 = aE.mqu;
                }
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(41563);
                        C4990ab.m7416i("MicroMsg.WalletSoterService", "click faceid btn");
                        Intent intent = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent.putExtra("pwd", bundle3.getString("key_pwd1"));
                        intent.putExtra("key_scene", 1);
                        mMActivity.startActivity(intent);
                        c15532i.dismiss();
                        AppMethodBeat.m2505o(41563);
                    }
                });
                final Activity activity = mMActivity;
                textView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(41564);
                        C4990ab.m7416i("MicroMsg.WalletSoterService", "click fingerprint btn");
                        if (aE != null) {
                            bundle3.putBoolean("key_show_guide", false);
                            Intent intent = new Intent();
                            intent.putExtras(bundle3);
                            C25985d.m41467b(activity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent);
                        }
                        c15532i.dismiss();
                        AppMethodBeat.m2505o(41564);
                    }
                });
                textView3.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(41565);
                        C4990ab.m7416i("MicroMsg.WalletSoterService", "click cancel btn");
                        if (checkBox.isChecked()) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        c15532i.dismiss();
                        AppMethodBeat.m2505o(41565);
                    }
                });
                c15532i.show();
                mMActivity.addDialog(c15532i);
            } else if (C46333a.cOQ() && c30052l.bxo() && !c30052l.bxe()) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                C25985d.m41467b((Context) mMActivity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent);
            } else if (C46333a.cOR() && c30052l.bxB() && !c30052l.bxh()) {
                View inflate = LayoutInflater.from(mMActivity).inflate(2130969563, null);
                final CheckBox checkBox2 = (CheckBox) inflate.findViewById(2131824049);
                ((TextView) inflate.findViewById(2131824048)).setText(mMActivity.getString(C25738R.string.bmq));
                C30379h.m48451a((Context) mMActivity, false, null, inflate, mMActivity.getString(C25738R.string.abh), mMActivity.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41561);
                        Intent intent = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent.putExtra("pwd", bundle.getString("key_pwd1"));
                        intent.putExtra("key_scene", 1);
                        mMActivity.startActivity(intent);
                        AppMethodBeat.m2505o(41561);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41562);
                        if (checkBox2.isChecked()) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        AppMethodBeat.m2505o(41562);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(41567);
        return true;
    }
}
