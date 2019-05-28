package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.au.b;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private a[] gGM;
    private String gGN;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125455);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(125455);
    }

    public void onDestroy() {
        AppMethodBeat.i(125456);
        super.onDestroy();
        AppMethodBeat.o(125456);
    }

    public final int JC() {
        return R.layout.gk;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(125457);
        if (preference instanceof LanguagePreference) {
            a aVar = ((LanguagePreference) preference).gBB;
            if (aVar == null) {
                AppMethodBeat.o(125457);
                return false;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("voice_verify_language", aVar.gBC);
            bundle.putString("voice_verify_code", aVar.gBE);
            intent.putExtras(bundle);
            setResult(0, intent);
            finish();
            AppMethodBeat.o(125457);
            return true;
        }
        AppMethodBeat.o(125457);
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(125458);
        aqX();
        this.gGN = getIntent().getExtras().getString("voice_verify_code");
        setMMTitle((int) R.string.a86);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125454);
                RegByMobileVoiceVerifySelectUI.this.aqX();
                RegByMobileVoiceVerifySelectUI.this.finish();
                AppMethodBeat.o(125454);
                return true;
            }
        });
        this.gGM = arv();
        if (this.gGM == null || this.gGM.length <= 0) {
            AppMethodBeat.o(125458);
            return;
        }
        this.ehK.removeAll();
        this.ehK.b(new PreferenceCategory(this));
        for (a aVar : this.gGM) {
            if (aVar.gBE.equalsIgnoreCase(this.gGN)) {
                aVar.gBF = true;
            }
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            languagePreference.setKey(aVar.gBE);
            this.ehK.b(languagePreference);
        }
        AppMethodBeat.o(125458);
    }

    public static String wx(String str) {
        String str2;
        AppMethodBeat.i(125459);
        a[] arv = arv();
        String sN = b.sN(str);
        for (a aVar : arv) {
            if (aVar.gBE.equalsIgnoreCase(sN)) {
                str2 = aVar.gBC;
                AppMethodBeat.o(125459);
                return str2;
            }
        }
        str2 = "English";
        AppMethodBeat.o(125459);
        return str2;
    }

    private static a[] arv() {
        AppMethodBeat.i(125460);
        String[] split = ah.getContext().getString(R.string.a80).trim().split(",");
        a[] aVarArr = new a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            aVarArr[i] = new a(split2[1], split2[2], split2[0], false);
        }
        AppMethodBeat.o(125460);
        return aVarArr;
    }
}
