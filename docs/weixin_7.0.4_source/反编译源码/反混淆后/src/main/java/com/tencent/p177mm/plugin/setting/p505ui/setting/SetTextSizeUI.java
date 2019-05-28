package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI */
public class SetTextSizeUI extends MMPreference {
    private C15541f ehK;
    private int jVE = 1;
    private float qlI;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI$a */
    class C13205a extends Preference {
        private float qlI;

        public C13205a(Context context, float f) {
            super(context);
            this.qlI = f;
        }

        public final void onBindView(View view) {
            AppMethodBeat.m2504i(127054);
            super.onBindView(view);
            TextView textView = (TextView) view.findViewById(16908310);
            if (textView != null) {
                textView.setTextSize(1, SetTextSizeUI.m57243aS(this.qlI));
            }
            AppMethodBeat.m2505o(127054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI$1 */
    class C348621 implements OnMenuItemClickListener {
        C348621() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127052);
            SetTextSizeUI.this.aqX();
            SetTextSizeUI.this.finish();
            AppMethodBeat.m2505o(127052);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI$2 */
    class C348632 implements OnMenuItemClickListener {
        C348632() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127053);
            C1338a.m2871h(SetTextSizeUI.this, SetTextSizeUI.this.qlI);
            SetTextSizeUI.this.finish();
            AppMethodBeat.m2505o(127053);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127055);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127055);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127056);
        this.qlI = SetTextSizeUI.m57244eM(this);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.ebq);
        setBackBtn(new C348621());
        mo17379a(0, getString(C25738R.string.e7s), (OnMenuItemClickListener) new C348632(), C5535b.GREEN);
        refresh();
        AppMethodBeat.m2505o(127056);
    }

    /* renamed from: eM */
    public static float m57244eM(Context context) {
        float f = 1.0f;
        AppMethodBeat.m2504i(127057);
        float dm = C1338a.m2860dm(context);
        if (dm == 1.0f || dm == 0.875f || dm == 1.125f || dm == 1.25f || dm == 1.375f || dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            f = dm;
        }
        AppMethodBeat.m2505o(127057);
        return f;
    }

    /* renamed from: eN */
    public static int m57245eN(Context context) {
        AppMethodBeat.m2504i(127058);
        float eM = SetTextSizeUI.m57244eM(context);
        if (eM == 0.875f) {
            AppMethodBeat.m2505o(127058);
            return C25738R.string.e4f;
        } else if (eM == 1.125f) {
            AppMethodBeat.m2505o(127058);
            return C25738R.string.e4d;
        } else if (eM == 1.25f) {
            AppMethodBeat.m2505o(127058);
            return C25738R.string.e4g;
        } else if (eM == 1.375f) {
            AppMethodBeat.m2505o(127058);
            return C25738R.string.e4b;
        } else {
            AppMethodBeat.m2505o(127058);
            return C25738R.string.e4e;
        }
    }

    /* renamed from: aS */
    public static float m57243aS(float f) {
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
        AppMethodBeat.m2504i(127060);
        this.ehK.removeAll();
        C13205a c13205a = new C13205a(this, 0.875f);
        c13205a.setKey("setting_text_size_small");
        c13205a.setLayoutResource(2130970127);
        if (this.qlI == 0.875f) {
            c13205a.setWidgetLayoutResource(2130970197);
        } else {
            c13205a.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(c13205a);
        c13205a = new C13205a(this, 1.0f);
        c13205a.setKey("setting_text_size_normal");
        c13205a.setLayoutResource(2130970127);
        if (this.qlI == 1.0f) {
            c13205a.setWidgetLayoutResource(2130970197);
        } else {
            c13205a.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(c13205a);
        c13205a = new C13205a(this, 1.125f);
        c13205a.setKey("setting_text_size_large");
        c13205a.setLayoutResource(2130970127);
        if (this.qlI == 1.125f) {
            c13205a.setWidgetLayoutResource(2130970197);
        } else {
            c13205a.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(c13205a);
        c13205a = new C13205a(this, 1.25f);
        c13205a.setKey("setting_text_size_super");
        c13205a.setLayoutResource(2130970127);
        if (this.qlI == 1.25f) {
            c13205a.setWidgetLayoutResource(2130970197);
        } else {
            c13205a.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(c13205a);
        c13205a = new C13205a(this, 1.375f);
        c13205a.setKey("setting_text_size_huge");
        c13205a.setLayoutResource(2130970127);
        if (this.qlI == 1.375f) {
            c13205a.setWidgetLayoutResource(2130970197);
        } else {
            c13205a.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(c13205a);
        this.ehK.mo27713b(new PreferenceCategory(this));
        this.ehK.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.mController.ylv;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                C4990ab.m7410d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
        AppMethodBeat.m2505o(127060);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127059);
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
        AppMethodBeat.m2505o(127059);
        return false;
    }
}
