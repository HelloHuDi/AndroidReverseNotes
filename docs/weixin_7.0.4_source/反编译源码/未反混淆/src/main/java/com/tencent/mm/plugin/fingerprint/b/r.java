package com.tencent.mm.plugin.fingerprint.b;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.fingerprint.faceid.auth.a;
import com.tencent.mm.plugin.fingerprint.faceid.auth.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c;

public final class r implements i {
    public final void a(MMActivity mMActivity, a aVar, Bundle bundle) {
        AppMethodBeat.i(41566);
        b bVar = new b(mMActivity, aVar, bundle);
        bVar.setCancelable(false);
        mMActivity.getLifecycle().addObserver(bVar);
        bVar.show();
        AppMethodBeat.o(41566);
    }

    public final boolean g(final MMActivity mMActivity) {
        AppMethodBeat.i(41567);
        if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            ab.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
            AppMethodBeat.o(41567);
            return false;
        }
        Bundle bundle;
        final c aE = com.tencent.mm.wallet_core.a.aE(mMActivity);
        Bundle bundle2 = new Bundle();
        if (aE != null) {
            bundle = aE.mqu;
        } else {
            bundle = bundle2;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            ab.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
            AppMethodBeat.o(41567);
            return false;
        }
        l lVar = (l) g.K(l.class);
        ab.i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.cOQ()), Boolean.valueOf(lVar.bxo()), Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.cOR()), Boolean.valueOf(lVar.bxB()));
        if (!(lVar.bxe() || lVar.bxh())) {
            if (com.tencent.mm.plugin.wallet.b.a.cOQ() && lVar.bxo() && com.tencent.mm.plugin.wallet.b.a.cOR() && lVar.bxB()) {
                final i iVar = new i(mMActivity, R.style.zt);
                iVar.setContentView(R.layout.gq);
                final CheckBox checkBox = (CheckBox) iVar.findViewById(R.id.a6p);
                TextView textView = (TextView) iVar.findViewById(R.id.a6q);
                TextView textView2 = (TextView) iVar.findViewById(R.id.a6r);
                TextView textView3 = (TextView) iVar.findViewById(R.id.a6s);
                Bundle bundle3 = new Bundle();
                if (aE != null) {
                    bundle3 = aE.mqu;
                }
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(41563);
                        ab.i("MicroMsg.WalletSoterService", "click faceid btn");
                        Intent intent = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent.putExtra("pwd", bundle3.getString("key_pwd1"));
                        intent.putExtra("key_scene", 1);
                        mMActivity.startActivity(intent);
                        iVar.dismiss();
                        AppMethodBeat.o(41563);
                    }
                });
                final Activity activity = mMActivity;
                textView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(41564);
                        ab.i("MicroMsg.WalletSoterService", "click fingerprint btn");
                        if (aE != null) {
                            bundle3.putBoolean("key_show_guide", false);
                            Intent intent = new Intent();
                            intent.putExtras(bundle3);
                            d.b(activity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent);
                        }
                        iVar.dismiss();
                        AppMethodBeat.o(41564);
                    }
                });
                textView3.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(41565);
                        ab.i("MicroMsg.WalletSoterService", "click cancel btn");
                        if (checkBox.isChecked()) {
                            g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        iVar.dismiss();
                        AppMethodBeat.o(41565);
                    }
                });
                iVar.show();
                mMActivity.addDialog(iVar);
            } else if (com.tencent.mm.plugin.wallet.b.a.cOQ() && lVar.bxo() && !lVar.bxe()) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                d.b((Context) mMActivity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent);
            } else if (com.tencent.mm.plugin.wallet.b.a.cOR() && lVar.bxB() && !lVar.bxh()) {
                View inflate = LayoutInflater.from(mMActivity).inflate(R.layout.zv, null);
                final CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.btq);
                ((TextView) inflate.findViewById(R.id.btp)).setText(mMActivity.getString(R.string.bmq));
                h.a((Context) mMActivity, false, null, inflate, mMActivity.getString(R.string.abh), mMActivity.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(41561);
                        Intent intent = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent.putExtra("pwd", bundle.getString("key_pwd1"));
                        intent.putExtra("key_scene", 1);
                        mMActivity.startActivity(intent);
                        AppMethodBeat.o(41561);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(41562);
                        if (checkBox2.isChecked()) {
                            g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        AppMethodBeat.o(41562);
                    }
                });
            }
        }
        AppMethodBeat.o(41567);
        return true;
    }
}
