package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI extends MMPreference {
    private f ehK;
    private Profession[] tur = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.i(47662);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ft1);
        this.ehK = this.yCw;
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.mController.ylL);
        preferenceTitleCategory.setTitle((CharSequence) getString(R.string.ft0));
        preferenceTitleCategory.setKey("title_category");
        this.ehK.b(preferenceTitleCategory);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("key_profession_list");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length > 0) {
            this.tur = new Profession[parcelableArrayExtra.length];
            for (i = 0; i < this.tur.length; i++) {
                this.tur[i] = (Profession) parcelableArrayExtra[i];
            }
        }
        if (this.tur != null) {
            i = 0;
            for (Profession profession : this.tur) {
                if (!(profession == null || bo.isNullOrNil(profession.tvN))) {
                    Preference preference = new Preference(this.mController.ylL);
                    preference.setTitle(profession.tvN);
                    preference.setKey("index_".concat(String.valueOf(i)));
                    this.ehK.b(preference);
                }
                i++;
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47661);
                WalletSelectProfessionUI.this.setResult(0);
                WalletSelectProfessionUI.this.finish();
                AppMethodBeat.o(47661);
                return true;
            }
        });
        AppMethodBeat.o(47662);
    }

    public final int JC() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(47663);
        if (preference.mKey.startsWith("index_")) {
            String[] split = preference.mKey.split("_");
            if (split.length == 2) {
                Parcelable parcelable = this.tur[bo.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", parcelable);
                setResult(-1, intent);
            } else {
                ab.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", preference.mKey, preference.getTitle());
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(47663);
        return true;
    }
}
