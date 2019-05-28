package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q.b;

public class SetTextSizeUI extends MMPreference {
    private f ehK;
    private int jVE = 1;
    private float qlI;

    class a extends Preference {
        private float qlI;

        public a(Context context, float f) {
            super(context);
            this.qlI = f;
        }

        public final void onBindView(View view) {
            AppMethodBeat.i(127054);
            super.onBindView(view);
            TextView textView = (TextView) view.findViewById(16908310);
            if (textView != null) {
                textView.setTextSize(1, SetTextSizeUI.aS(this.qlI));
            }
            AppMethodBeat.o(127054);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127055);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127055);
    }

    public final void initView() {
        AppMethodBeat.i(127056);
        this.qlI = eM(this);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.ebq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127052);
                SetTextSizeUI.this.aqX();
                SetTextSizeUI.this.finish();
                AppMethodBeat.o(127052);
                return true;
            }
        });
        a(0, getString(R.string.e7s), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127053);
                com.tencent.mm.bz.a.h(SetTextSizeUI.this, SetTextSizeUI.this.qlI);
                SetTextSizeUI.this.finish();
                AppMethodBeat.o(127053);
                return true;
            }
        }, b.GREEN);
        refresh();
        AppMethodBeat.o(127056);
    }

    public static float eM(Context context) {
        float f = 1.0f;
        AppMethodBeat.i(127057);
        float dm = com.tencent.mm.bz.a.dm(context);
        if (dm == 1.0f || dm == 0.875f || dm == 1.125f || dm == 1.25f || dm == 1.375f || dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            f = dm;
        }
        AppMethodBeat.o(127057);
        return f;
    }

    public static int eN(Context context) {
        AppMethodBeat.i(127058);
        float eM = eM(context);
        if (eM == 0.875f) {
            AppMethodBeat.o(127058);
            return R.string.e4f;
        } else if (eM == 1.125f) {
            AppMethodBeat.o(127058);
            return R.string.e4d;
        } else if (eM == 1.25f) {
            AppMethodBeat.o(127058);
            return R.string.e4g;
        } else if (eM == 1.375f) {
            AppMethodBeat.o(127058);
            return R.string.e4b;
        } else {
            AppMethodBeat.o(127058);
            return R.string.e4e;
        }
    }

    public static float aS(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 17.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        if (f == 1.375f) {
            return 22.0f;
        }
        if (f == 1.625f) {
            return 26.0f;
        }
        if (f == 1.875f) {
            return 28.0f;
        }
        if (f == 2.025f) {
            return 30.0f;
        }
        return 17.0f;
    }

    private void refresh() {
        AppMethodBeat.i(127060);
        this.ehK.removeAll();
        a aVar = new a(this, 0.875f);
        aVar.setKey("setting_text_size_small");
        aVar.setLayoutResource(R.layout.ae4);
        if (this.qlI == 0.875f) {
            aVar.setWidgetLayoutResource(R.layout.ag0);
        } else {
            aVar.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(aVar);
        aVar = new a(this, 1.0f);
        aVar.setKey("setting_text_size_normal");
        aVar.setLayoutResource(R.layout.ae4);
        if (this.qlI == 1.0f) {
            aVar.setWidgetLayoutResource(R.layout.ag0);
        } else {
            aVar.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(aVar);
        aVar = new a(this, 1.125f);
        aVar.setKey("setting_text_size_large");
        aVar.setLayoutResource(R.layout.ae4);
        if (this.qlI == 1.125f) {
            aVar.setWidgetLayoutResource(R.layout.ag0);
        } else {
            aVar.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(aVar);
        aVar = new a(this, 1.25f);
        aVar.setKey("setting_text_size_super");
        aVar.setLayoutResource(R.layout.ae4);
        if (this.qlI == 1.25f) {
            aVar.setWidgetLayoutResource(R.layout.ag0);
        } else {
            aVar.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(aVar);
        aVar = new a(this, 1.375f);
        aVar.setKey("setting_text_size_huge");
        aVar.setLayoutResource(R.layout.ae4);
        if (this.qlI == 1.375f) {
            aVar.setWidgetLayoutResource(R.layout.ag0);
        } else {
            aVar.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(aVar);
        this.ehK.b(new PreferenceCategory(this));
        this.ehK.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.mController.ylv;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                ab.d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
        AppMethodBeat.o(127060);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127059);
        String str = preference.mKey;
        this.jVE = 1;
        if (str.equals("setting_text_size_small")) {
            this.qlI = 0.875f;
            this.jVE = 0;
        } else if (str.equals("setting_text_size_normal")) {
            this.qlI = 1.0f;
            this.jVE = 1;
        } else if (str.equals("setting_text_size_large")) {
            this.qlI = 1.125f;
            this.jVE = 2;
        } else if (str.equals("setting_text_size_super")) {
            this.qlI = 1.25f;
            this.jVE = 3;
        } else if (str.equals("setting_text_size_huge")) {
            this.qlI = 1.375f;
            this.jVE = 4;
        } else if (str.equals("setting_text_size_huger")) {
            this.qlI = 1.625f;
            this.jVE = 5;
        } else if (str.equals("setting_text_size_hugers")) {
            this.qlI = 1.625f;
            this.jVE = 6;
        } else if (str.equals("setting_text_size_hugerss")) {
            this.qlI = 1.625f;
            this.jVE = 7;
        }
        refresh();
        AppMethodBeat.o(127059);
        return false;
    }
}
