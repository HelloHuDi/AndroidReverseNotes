package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.s;
import java.util.List;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20494);
        super.onCreate(bundle);
        ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(R.layout.rj);
        Intent intent = new Intent();
        int C = s.C(s.znD, 64, 16384);
        s.hs(C, 1);
        intent.putExtra("list_attr", C);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(R.string.eu));
        intent.putExtra("block_contact", r.Yz());
        d.b((Context) this, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(20494);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(20495);
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", Integer.valueOf(i2));
        if (i2 != -1) {
            finish();
            AppMethodBeat.o(20495);
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (aw.RK()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (bo.isNullOrNil(stringExtra)) {
                            list = null;
                        } else {
                            list = bo.P(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String Yz = r.Yz();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                for (int i3 = 0; i3 < list.size(); i3++) {
                                    aw.ZK();
                                    ad aoO = c.XM().aoO((String) list.get(i3));
                                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                        ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        AppMethodBeat.o(20495);
                                        return;
                                    }
                                    String Ft = b.Ft((String) list.get(i3));
                                    if (bo.isNullOrNil(Ft)) {
                                        ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        AppMethodBeat.o(20495);
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", b.SOURCE_KEY);
                                    contentValues.put("owner_id", b.Ft(Yz));
                                    contentValues.put("unique_id", Ft);
                                    contentValues.put("container", Integer.valueOf(1));
                                    contentValues.put("item_type", Integer.valueOf(b.C(aoO)));
                                    contentValues.put("name", com.tencent.mm.model.s.a(aoO, (String) list.get(i3)));
                                    o.acd();
                                    contentValues.put("icon_path", com.tencent.mm.ah.d.D((String) list.get(i3), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", Ft);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i3] = contentValues;
                                }
                                getContentResolver().bulkInsert(a.lRW, contentValuesArr);
                                Toast.makeText(this, R.string.bja, 0).show();
                                com.tencent.mm.plugin.extqlauncher.b.bsa().bsc();
                                break;
                            } catch (Exception e) {
                                ab.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", e.getMessage());
                                ab.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, R.string.bj_, 0).show();
                                break;
                            }
                        }
                        ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    ab.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, R.string.bj_, 0).show();
                    finish();
                    AppMethodBeat.o(20495);
                    return;
                }
                break;
        }
        finish();
        AppMethodBeat.o(20495);
    }
}
