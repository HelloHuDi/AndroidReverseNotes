package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.cj.c;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class SettingsFontUI extends MMActivity {
    private int qne = 0;
    private int qnf = 2;
    private int qng = a.fromDPToPix(ah.getContext(), R.dimen.x7);
    final float qnh = SetTextSizeUI.eM(this.mController.ylL);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsFontUI() {
        AppMethodBeat.i(127223);
        AppMethodBeat.o(127223);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127224);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127224);
    }

    public final int getLayoutId() {
        return R.layout.ars;
    }

    public final void initView() {
        AppMethodBeat.i(127225);
        setMMTitle((int) R.string.ebq);
        ab.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.qnh);
        final MMNeat7extView mMNeat7extView = (MMNeat7extView) findViewById(R.id.e_1);
        final MMNeat7extView mMNeat7extView2 = (MMNeat7extView) findViewById(R.id.e_3);
        final MMNeat7extView mMNeat7extView3 = (MMNeat7extView) findViewById(R.id.e_4);
        b.b((ImageView) findViewById(R.id.e_2), r.Yz());
        this.qng = (int) (((float) a.am(this.mController.ylL, R.dimen.x7)) / com.tencent.mm.ca.a.dmK());
        mMNeat7extView2.setMaxWidth(this.qng);
        mMNeat7extView3.setMaxWidth(this.qng);
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(R.id.e_5);
        a(fontSelectorView);
        fontSelectorView.setOnChangeListener(new FontSelectorView.a() {
            public final void Cl(int i) {
                float f = 1.0f;
                AppMethodBeat.i(127221);
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
                a.h(SettingsFontUI.this.mController.ylL, f);
                Editor edit = SettingsFontUI.this.mController.ylL.getSharedPreferences(ah.doA(), 0).edit();
                edit.putFloat("current_text_size_scale_key", f);
                edit.commit();
                SettingsFontUI.this.qnf = a.fX(SettingsFontUI.this.mController.ylL);
                AppCompatActivity appCompatActivity = SettingsFontUI.this.mController.ylL;
                mMNeat7extView.setTextSize(1, SetTextSizeUI.aS(f));
                mMNeat7extView2.setTextSize(1, SetTextSizeUI.aS(f));
                mMNeat7extView3.setTextSize(1, SetTextSizeUI.aS(f));
                SettingsFontUI.this.bn(a.fY(appCompatActivity) * ((float) a.am(appCompatActivity, R.dimen.dk)));
                AppMethodBeat.o(127221);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127222);
                h.pYm.e(11609, Integer.valueOf(SettingsFontUI.this.qne), Integer.valueOf(SettingsFontUI.this.qnf), Integer.valueOf(0));
                ab.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.this.qne), Integer.valueOf(SettingsFontUI.this.qnf));
                SettingsFontUI.this.finish();
                SettingsFontUI.a(SettingsFontUI.this, SettingsFontUI.this.qnh);
                AppMethodBeat.o(127222);
                return true;
            }
        });
        AppMethodBeat.o(127225);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127226);
        if (i == 4 && keyEvent.getAction() == 0) {
            h.pYm.e(11609, Integer.valueOf(this.qne), Integer.valueOf(this.qnf), Integer.valueOf(0));
            ab.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", Integer.valueOf(11609), Integer.valueOf(this.qne), Integer.valueOf(this.qnf));
            finish();
            aT(this.qnh);
            AppMethodBeat.o(127226);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127226);
        return onKeyDown;
    }

    private void aT(float f) {
        AppMethodBeat.i(127227);
        float f2 = this.mController.ylL.getSharedPreferences(ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        ab.i("MicroMsg.SettingsFontUI", "fontSizeAfter=".concat(String.valueOf(f2)));
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.b.gkE.p(intent, this.mController.ylL);
            gn gnVar = new gn();
            gnVar.cBi.cBj = f;
            gnVar.cBi.cBk = f2;
            com.tencent.mm.sdk.b.a.xxA.m(gnVar);
            c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        }
        AppMethodBeat.o(127227);
    }

    private void a(FontSelectorView fontSelectorView) {
        int i;
        AppMethodBeat.i(127228);
        float eM = SetTextSizeUI.eM(this.mController.ylL);
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
        AppMethodBeat.o(127228);
    }
}
