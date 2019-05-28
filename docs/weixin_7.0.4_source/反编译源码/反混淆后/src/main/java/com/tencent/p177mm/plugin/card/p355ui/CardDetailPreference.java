package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11286b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.widget.CardTextPreference;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.ui.CardDetailPreference */
public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    C15541f iFE;
    private C42837b kaS;
    private List<C11286b> kaW = new ArrayList();
    private TextView kiK;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardDetailPreference$1 */
    class C201621 implements OnMenuItemClickListener {
        C201621() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88256);
            CardDetailPreference.this.finish();
            AppMethodBeat.m2505o(88256);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardDetailPreference() {
        AppMethodBeat.m2504i(88257);
        AppMethodBeat.m2505o(88257);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88258);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(88258);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88259);
        this.kaS = (C42837b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.kaS == null || this.kaS.aZV() == null || this.kaS.aZW() == null) {
            C4990ab.m7412e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            AppMethodBeat.m2505o(88259);
            return;
        }
        bbC();
        setBackBtn(new C201621());
        this.iFE = this.yCw;
        bca();
        bcb();
        bch();
        AppMethodBeat.m2505o(88259);
    }

    private void bbC() {
        AppMethodBeat.m2504i(88260);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kaS.aZV().kdf)) {
            stringBuilder.append(this.kaS.aZV().kdf);
        }
        stringBuilder.append(getString(C25738R.string.adj));
        setMMTitle(stringBuilder.toString());
        AppMethodBeat.m2505o(88260);
    }

    private void bca() {
        AppMethodBeat.m2504i(88261);
        this.kaW.clear();
        if (this.kaS.aZW().vRX != null && this.kaS.aZW().vRX.size() > 0) {
            this.kaW.addAll(C38736l.m65722bj(this.kaS.aZW().vRX));
        }
        if (this.kaS.aZW().vRY != null && this.kaS.aZW().vRY.size() > 0) {
            List bj = C38736l.m65722bj(this.kaS.aZW().vRY);
            ((C11286b) bj.get(0)).kch = true;
            this.kaW.addAll(bj);
        }
        AppMethodBeat.m2505o(88261);
    }

    private void bcb() {
        AppMethodBeat.m2504i(88262);
        bce();
        bcd();
        bcc();
        bcf();
        bcg();
        AppMethodBeat.m2505o(88262);
    }

    private void bcc() {
        AppMethodBeat.m2504i(88263);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaW.size()) {
                C11286b c11286b = (C11286b) this.kaW.get(i2);
                Preference preference = new Preference(this);
                preference.setLayoutResource(2130970127);
                preference.setKey(c11286b.title);
                preference.setTitle(c11286b.title);
                if (!TextUtils.isEmpty(c11286b.kbW)) {
                    preference.setSummary(c11286b.kbW);
                }
                if (c11286b.kch) {
                    bce();
                }
                this.iFE.mo27713b(preference);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(88263);
                return;
            }
        }
    }

    private void bcd() {
        AppMethodBeat.m2504i(88264);
        if (!(this.kaS.aZV().vTX == null || this.kaS.aZV().vTX == null)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kaS.aZV().vTX.size()) {
                    break;
                }
                C23446tm c23446tm = (C23446tm) this.kaS.aZV().vTX.get(i2);
                if (!TextUtils.isEmpty(c23446tm.kbW)) {
                    CardTextPreference cardTextPreference = new CardTextPreference(this);
                    cardTextPreference.setLayoutResource(2130970127);
                    cardTextPreference.setTitle((CharSequence) c23446tm.kbW);
                    cardTextPreference.beH();
                    m31198GP(c23446tm.title);
                    this.iFE.mo27713b(cardTextPreference);
                }
                i = i2 + 1;
            }
            bce();
        }
        AppMethodBeat.m2505o(88264);
    }

    private void bce() {
        AppMethodBeat.m2504i(88265);
        this.iFE.mo27713b(new PreferenceSmallCategory(this));
        AppMethodBeat.m2505o(88265);
    }

    /* renamed from: GP */
    private void m31198GP(String str) {
        AppMethodBeat.m2504i(88266);
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle((CharSequence) " ");
        } else {
            preferenceTitleCategory.setTitle((CharSequence) str);
        }
        this.iFE.mo27713b(preferenceTitleCategory);
        AppMethodBeat.m2505o(88266);
    }

    private void bcf() {
        AppMethodBeat.m2504i(88267);
        if (!TextUtils.isEmpty(this.kaS.aZV().vTY)) {
            CardTextPreference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(2130970127);
            cardTextPreference.setTitle((CharSequence) getString(C25738R.string.agd));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.beH();
            bce();
            this.iFE.mo27713b(cardTextPreference);
        }
        AppMethodBeat.m2505o(88267);
    }

    private void bcg() {
        AppMethodBeat.m2504i(88268);
        if (!TextUtils.isEmpty(this.kaS.aZV().vTV)) {
            bce();
            CardTextPreference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(2130970127);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle((int) C25738R.string.afq);
            cardTextPreference.setSummary((CharSequence) this.kaS.aZV().vTV);
            cardTextPreference.mo61655tp(getResources().getColor(C25738R.color.f12123t7));
            this.iFE.mo27713b(cardTextPreference);
            m31198GP("");
        }
        AppMethodBeat.m2505o(88268);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8475p;
    }

    private void bch() {
        AppMethodBeat.m2504i(88270);
        if (!(this.kaS.aZV() == null || TextUtils.isEmpty(this.kaS.aZV().source) || this.kiK == null)) {
            this.kiK.setText(this.kaS.aZV().source);
            this.kiK.setVisibility(0);
        }
        AppMethodBeat.m2505o(88270);
    }

    public final View aWz() {
        AppMethodBeat.m2504i(88271);
        View inflate = getLayoutInflater().inflate(2130970843, null);
        this.kiK = (TextView) inflate.findViewById(2131826911);
        this.kiK.setVisibility(8);
        AppMethodBeat.m2505o(88271);
        return inflate;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(88269);
        if (preference.mKey.equals("card_phone")) {
            String str = this.kaS.aZV().vTV;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
            startActivity(intent);
        }
        if (preference.mKey.equals("key_pic_detail")) {
            C45774b.m84626a((MMActivity) this, this.kaS.aZV().vTY, 0);
        } else {
            for (int i = 0; i < this.kaW.size(); i++) {
                C11286b c11286b = (C11286b) this.kaW.get(i);
                if (!(c11286b.title == null || !c11286b.title.equals(preference.mKey) || TextUtils.isEmpty(c11286b.url))) {
                    if (C45774b.m84634d(this.kaS.aZZ(), c11286b.vTL, c11286b.vTM, 1028, 0)) {
                        AppMethodBeat.m2505o(88269);
                        break;
                    }
                    C45774b.m84626a((MMActivity) this, c11286b.url, 1);
                }
            }
        }
        AppMethodBeat.m2505o(88269);
        return false;
    }
}
