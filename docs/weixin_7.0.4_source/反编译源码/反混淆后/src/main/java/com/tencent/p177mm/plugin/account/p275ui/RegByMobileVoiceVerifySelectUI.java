package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.plugin.account.p275ui.LanguagePreference.C26617a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI */
public class RegByMobileVoiceVerifySelectUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private C26617a[] gGM;
    private String gGN;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI$1 */
    class C266381 implements OnMenuItemClickListener {
        C266381() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125454);
            RegByMobileVoiceVerifySelectUI.this.aqX();
            RegByMobileVoiceVerifySelectUI.this.finish();
            AppMethodBeat.m2505o(125454);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125455);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(125455);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125456);
        super.onDestroy();
        AppMethodBeat.m2505o(125456);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return 2130968845;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(125457);
        if (preference instanceof LanguagePreference) {
            C26617a c26617a = ((LanguagePreference) preference).gBB;
            if (c26617a == null) {
                AppMethodBeat.m2505o(125457);
                return false;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("voice_verify_language", c26617a.gBC);
            bundle.putString("voice_verify_code", c26617a.gBE);
            intent.putExtras(bundle);
            setResult(0, intent);
            finish();
            AppMethodBeat.m2505o(125457);
            return true;
        }
        AppMethodBeat.m2505o(125457);
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(125458);
        aqX();
        this.gGN = getIntent().getExtras().getString("voice_verify_code");
        setMMTitle((int) C25738R.string.a86);
        setBackBtn(new C266381());
        this.gGM = RegByMobileVoiceVerifySelectUI.arv();
        if (this.gGM == null || this.gGM.length <= 0) {
            AppMethodBeat.m2505o(125458);
            return;
        }
        this.ehK.removeAll();
        this.ehK.mo27713b(new PreferenceCategory(this));
        for (C26617a c26617a : this.gGM) {
            if (c26617a.gBE.equalsIgnoreCase(this.gGN)) {
                c26617a.gBF = true;
            }
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.mo44386a(c26617a);
            languagePreference.setKey(c26617a.gBE);
            this.ehK.mo27713b(languagePreference);
        }
        AppMethodBeat.m2505o(125458);
    }

    /* renamed from: wx */
    public static String m81304wx(String str) {
        String str2;
        AppMethodBeat.m2504i(125459);
        C26617a[] arv = RegByMobileVoiceVerifySelectUI.arv();
        String sN = C17950b.m28215sN(str);
        for (C26617a c26617a : arv) {
            if (c26617a.gBE.equalsIgnoreCase(sN)) {
                str2 = c26617a.gBC;
                AppMethodBeat.m2505o(125459);
                return str2;
            }
        }
        str2 = "English";
        AppMethodBeat.m2505o(125459);
        return str2;
    }

    private static C26617a[] arv() {
        AppMethodBeat.m2504i(125460);
        String[] split = C4996ah.getContext().getString(C25738R.string.a80).trim().split(",");
        C26617a[] c26617aArr = new C26617a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            c26617aArr[i] = new C26617a(split2[1], split2[2], split2[0], false);
        }
        AppMethodBeat.m2505o(125460);
        return c26617aArr;
    }
}
