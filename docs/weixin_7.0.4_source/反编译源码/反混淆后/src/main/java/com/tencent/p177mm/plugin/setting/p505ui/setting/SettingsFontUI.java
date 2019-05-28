package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C6487gn;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.setting.p505ui.widget.FontSelectorView;
import com.tencent.p177mm.plugin.setting.p505ui.widget.FontSelectorView.C28982a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI */
public class SettingsFontUI extends MMActivity {
    private int qne = 0;
    private int qnf = 2;
    private int qng = C1338a.fromDPToPix(C4996ah.getContext(), C25738R.dimen.f10298x7);
    final float qnh = SetTextSizeUI.m57244eM(this.mController.ylL);

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI$2 */
    class C217612 implements OnMenuItemClickListener {
        C217612() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127222);
            C7060h.pYm.mo8381e(11609, Integer.valueOf(SettingsFontUI.this.qne), Integer.valueOf(SettingsFontUI.this.qnf), Integer.valueOf(0));
            C4990ab.m7417i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.this.qne), Integer.valueOf(SettingsFontUI.this.qnf));
            SettingsFontUI.this.finish();
            SettingsFontUI.m67803a(SettingsFontUI.this, SettingsFontUI.this.qnh);
            AppMethodBeat.m2505o(127222);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsFontUI() {
        AppMethodBeat.m2504i(127223);
        AppMethodBeat.m2505o(127223);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127224);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127224);
    }

    public final int getLayoutId() {
        return 2130970634;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127225);
        setMMTitle((int) C25738R.string.ebq);
        C4990ab.m7416i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.qnh);
        final MMNeat7extView mMNeat7extView = (MMNeat7extView) findViewById(2131827389);
        final MMNeat7extView mMNeat7extView2 = (MMNeat7extView) findViewById(2131827391);
        final MMNeat7extView mMNeat7extView3 = (MMNeat7extView) findViewById(2131827392);
        C40460b.m69434b((ImageView) findViewById(2131827390), C1853r.m3846Yz());
        this.qng = (int) (((float) C1338a.m2857am(this.mController.ylL, C25738R.dimen.f10298x7)) / C32432a.dmK());
        mMNeat7extView2.setMaxWidth(this.qng);
        mMNeat7extView3.setMaxWidth(this.qng);
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(2131827393);
        m67804a(fontSelectorView);
        fontSelectorView.setOnChangeListener(new C28982a() {
            /* renamed from: Cl */
            public final void mo47084Cl(int i) {
                float f = 1.0f;
                AppMethodBeat.m2504i(127221);
                switch (i) {
                    case 0:
                        f = 0.875f;
                        break;
                    case 2:
                        f = 1.125f;
                        break;
                    case 3:
                        f = 1.25f;
                        break;
                    case 4:
                        f = 1.375f;
                        break;
                    case 5:
                        f = 1.625f;
                        break;
                    case 6:
                        f = 1.875f;
                        break;
                    case 7:
                        f = 2.025f;
                        break;
                }
                if (f != SettingsFontUI.this.qnh) {
                    SettingsFontUI.this.qne = 1;
                } else {
                    SettingsFontUI.this.qne = 0;
                }
                C1338a.m2871h(SettingsFontUI.this.mController.ylL, f);
                Editor edit = SettingsFontUI.this.mController.ylL.getSharedPreferences(C4996ah.doA(), 0).edit();
                edit.putFloat("current_text_size_scale_key", f);
                edit.commit();
                SettingsFontUI.this.qnf = C1338a.m2861fX(SettingsFontUI.this.mController.ylL);
                AppCompatActivity appCompatActivity = SettingsFontUI.this.mController.ylL;
                mMNeat7extView.setTextSize(1, SetTextSizeUI.m57243aS(f));
                mMNeat7extView2.setTextSize(1, SetTextSizeUI.m57243aS(f));
                mMNeat7extView3.setTextSize(1, SetTextSizeUI.m57243aS(f));
                SettingsFontUI.this.mo17395bn(C1338a.m2862fY(appCompatActivity) * ((float) C1338a.m2857am(appCompatActivity, C25738R.dimen.f9720dk)));
                AppMethodBeat.m2505o(127221);
            }
        });
        setBackBtn(new C217612());
        AppMethodBeat.m2505o(127225);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127226);
        if (i == 4 && keyEvent.getAction() == 0) {
            C7060h.pYm.mo8381e(11609, Integer.valueOf(this.qne), Integer.valueOf(this.qnf), Integer.valueOf(0));
            C4990ab.m7417i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", Integer.valueOf(11609), Integer.valueOf(this.qne), Integer.valueOf(this.qnf));
            finish();
            m67805aT(this.qnh);
            AppMethodBeat.m2505o(127226);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127226);
        return onKeyDown;
    }

    /* renamed from: aT */
    private void m67805aT(float f) {
        AppMethodBeat.m2504i(127227);
        float f2 = this.mController.ylL.getSharedPreferences(C4996ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        C4990ab.m7416i("MicroMsg.SettingsFontUI", "fontSizeAfter=".concat(String.valueOf(f2)));
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            C24824b.gkE.mo38931p(intent, this.mController.ylL);
            C6487gn c6487gn = new C6487gn();
            c6487gn.cBi.cBj = f;
            c6487gn.cBi.cBk = f2;
            C4879a.xxA.mo10055m(c6487gn);
            C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        }
        AppMethodBeat.m2505o(127227);
    }

    /* renamed from: a */
    private void m67804a(FontSelectorView fontSelectorView) {
        int i;
        AppMethodBeat.m2504i(127228);
        float eM = SetTextSizeUI.m57244eM(this.mController.ylL);
        if (eM < 0.875f || eM > 2.025f) {
            eM = 1.0f;
        }
        if (eM == 0.875f) {
            i = 0;
        } else if (eM == 1.125f) {
            i = 2;
        } else if (eM == 1.25f) {
            i = 3;
        } else if (eM == 1.375f) {
            i = 4;
        } else if (eM == 1.625f) {
            i = 5;
        } else if (eM == 1.875f) {
            i = 6;
        } else if (eM == 2.025f) {
            i = 7;
        } else {
            i = 1;
        }
        fontSelectorView.setSliderIndex(i);
        AppMethodBeat.m2505o(127228);
    }
}
