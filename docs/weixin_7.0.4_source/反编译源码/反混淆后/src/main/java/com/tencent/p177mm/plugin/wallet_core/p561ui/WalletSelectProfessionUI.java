package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI */
public class WalletSelectProfessionUI extends MMPreference {
    private C15541f ehK;
    private Profession[] tur = null;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI$1 */
    class C226151 implements OnMenuItemClickListener {
        C226151() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47661);
            WalletSelectProfessionUI.this.setResult(0);
            WalletSelectProfessionUI.this.finish();
            AppMethodBeat.m2505o(47661);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.m2504i(47662);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ft1);
        this.ehK = this.yCw;
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.mController.ylL);
        preferenceTitleCategory.setTitle((CharSequence) getString(C25738R.string.ft0));
        preferenceTitleCategory.setKey("title_category");
        this.ehK.mo27713b(preferenceTitleCategory);
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
                if (!(profession == null || C5046bo.isNullOrNil(profession.tvN))) {
                    Preference preference = new Preference(this.mController.ylL);
                    preference.setTitle(profession.tvN);
                    preference.setKey("index_".concat(String.valueOf(i)));
                    this.ehK.mo27713b(preference);
                }
                i++;
            }
        }
        setBackBtn(new C226151());
        AppMethodBeat.m2505o(47662);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(47663);
        if (preference.mKey.startsWith("index_")) {
            String[] split = preference.mKey.split("_");
            if (split.length == 2) {
                Parcelable parcelable = this.tur[C5046bo.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", parcelable);
                setResult(-1, intent);
            } else {
                C4990ab.m7421w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", preference.mKey, preference.getTitle());
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.m2505o(47663);
        return true;
    }
}
