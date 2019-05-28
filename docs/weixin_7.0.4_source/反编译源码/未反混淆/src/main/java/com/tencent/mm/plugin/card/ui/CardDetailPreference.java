package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    f iFE;
    private b kaS;
    private List<com.tencent.mm.plugin.card.model.b> kaW = new ArrayList();
    private TextView kiK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardDetailPreference() {
        AppMethodBeat.i(88257);
        AppMethodBeat.o(88257);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88258);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(88258);
    }

    public final void initView() {
        AppMethodBeat.i(88259);
        this.kaS = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.kaS == null || this.kaS.aZV() == null || this.kaS.aZW() == null) {
            ab.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            AppMethodBeat.o(88259);
            return;
        }
        bbC();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88256);
                CardDetailPreference.this.finish();
                AppMethodBeat.o(88256);
                return true;
            }
        });
        this.iFE = this.yCw;
        bca();
        bcb();
        bch();
        AppMethodBeat.o(88259);
    }

    private void bbC() {
        AppMethodBeat.i(88260);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kaS.aZV().kdf)) {
            stringBuilder.append(this.kaS.aZV().kdf);
        }
        stringBuilder.append(getString(R.string.adj));
        setMMTitle(stringBuilder.toString());
        AppMethodBeat.o(88260);
    }

    private void bca() {
        AppMethodBeat.i(88261);
        this.kaW.clear();
        if (this.kaS.aZW().vRX != null && this.kaS.aZW().vRX.size() > 0) {
            this.kaW.addAll(l.bj(this.kaS.aZW().vRX));
        }
        if (this.kaS.aZW().vRY != null && this.kaS.aZW().vRY.size() > 0) {
            List bj = l.bj(this.kaS.aZW().vRY);
            ((com.tencent.mm.plugin.card.model.b) bj.get(0)).kch = true;
            this.kaW.addAll(bj);
        }
        AppMethodBeat.o(88261);
    }

    private void bcb() {
        AppMethodBeat.i(88262);
        bce();
        bcd();
        bcc();
        bcf();
        bcg();
        AppMethodBeat.o(88262);
    }

    private void bcc() {
        AppMethodBeat.i(88263);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaW.size()) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kaW.get(i2);
                Preference preference = new Preference(this);
                preference.setLayoutResource(R.layout.ae4);
                preference.setKey(bVar.title);
                preference.setTitle(bVar.title);
                if (!TextUtils.isEmpty(bVar.kbW)) {
                    preference.setSummary(bVar.kbW);
                }
                if (bVar.kch) {
                    bce();
                }
                this.iFE.b(preference);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(88263);
                return;
            }
        }
    }

    private void bcd() {
        AppMethodBeat.i(88264);
        if (!(this.kaS.aZV().vTX == null || this.kaS.aZV().vTX == null)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kaS.aZV().vTX.size()) {
                    break;
                }
                tm tmVar = (tm) this.kaS.aZV().vTX.get(i2);
                if (!TextUtils.isEmpty(tmVar.kbW)) {
                    CardTextPreference cardTextPreference = new CardTextPreference(this);
                    cardTextPreference.setLayoutResource(R.layout.ae4);
                    cardTextPreference.setTitle((CharSequence) tmVar.kbW);
                    cardTextPreference.beH();
                    GP(tmVar.title);
                    this.iFE.b(cardTextPreference);
                }
                i = i2 + 1;
            }
            bce();
        }
        AppMethodBeat.o(88264);
    }

    private void bce() {
        AppMethodBeat.i(88265);
        this.iFE.b(new PreferenceSmallCategory(this));
        AppMethodBeat.o(88265);
    }

    private void GP(String str) {
        AppMethodBeat.i(88266);
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle((CharSequence) " ");
        } else {
            preferenceTitleCategory.setTitle((CharSequence) str);
        }
        this.iFE.b(preferenceTitleCategory);
        AppMethodBeat.o(88266);
    }

    private void bcf() {
        AppMethodBeat.i(88267);
        if (!TextUtils.isEmpty(this.kaS.aZV().vTY)) {
            CardTextPreference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.layout.ae4);
            cardTextPreference.setTitle((CharSequence) getString(R.string.agd));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.beH();
            bce();
            this.iFE.b(cardTextPreference);
        }
        AppMethodBeat.o(88267);
    }

    private void bcg() {
        AppMethodBeat.i(88268);
        if (!TextUtils.isEmpty(this.kaS.aZV().vTV)) {
            bce();
            CardTextPreference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.layout.ae4);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle((int) R.string.afq);
            cardTextPreference.setSummary((CharSequence) this.kaS.aZV().vTV);
            cardTextPreference.tp(getResources().getColor(R.color.t7));
            this.iFE.b(cardTextPreference);
            GP("");
        }
        AppMethodBeat.o(88268);
    }

    public final int JC() {
        return R.xml.p;
    }

    private void bch() {
        AppMethodBeat.i(88270);
        if (!(this.kaS.aZV() == null || TextUtils.isEmpty(this.kaS.aZV().source) || this.kiK == null)) {
            this.kiK.setText(this.kaS.aZV().source);
            this.kiK.setVisibility(0);
        }
        AppMethodBeat.o(88270);
    }

    public final View aWz() {
        AppMethodBeat.i(88271);
        View inflate = getLayoutInflater().inflate(R.layout.axg, null);
        this.kiK = (TextView) inflate.findViewById(R.id.dx4);
        this.kiK.setVisibility(8);
        AppMethodBeat.o(88271);
        return inflate;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(88269);
        if (preference.mKey.equals("card_phone")) {
            String str = this.kaS.aZV().vTV;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
            startActivity(intent);
        }
        if (preference.mKey.equals("key_pic_detail")) {
            com.tencent.mm.plugin.card.d.b.a((MMActivity) this, this.kaS.aZV().vTY, 0);
        } else {
            for (int i = 0; i < this.kaW.size(); i++) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kaW.get(i);
                if (!(bVar.title == null || !bVar.title.equals(preference.mKey) || TextUtils.isEmpty(bVar.url))) {
                    if (com.tencent.mm.plugin.card.d.b.d(this.kaS.aZZ(), bVar.vTL, bVar.vTM, 1028, 0)) {
                        AppMethodBeat.o(88269);
                        break;
                    }
                    com.tencent.mm.plugin.card.d.b.a((MMActivity) this, bVar.url, 1);
                }
            }
        }
        AppMethodBeat.o(88269);
        return false;
    }
}
