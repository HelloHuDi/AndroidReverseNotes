package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.BaseActivity;
import com.tencent.p177mm.p612ui.C5227ai;

public abstract class WeUIPreference extends BaseActivity {
    private C41115b ALu;
    private boolean dirty = false;
    private SharedPreferences ehZ;
    private ListView nDp;
    private boolean szZ = false;
    protected RelativeLayout yCx;
    protected TextView yCy;
    protected ImageView yCz;

    /* renamed from: com.tencent.weui.base.preference.WeUIPreference$4 */
    class C245194 implements OnScrollListener {
        C245194() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(113263);
            if (1 == i) {
                View currentFocus = WeUIPreference.this.getCurrentFocus();
                if (currentFocus != null) {
                    currentFocus.clearFocus();
                }
            }
            AppMethodBeat.m2505o(113263);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.weui.base.preference.WeUIPreference$1 */
    class C365791 implements OnPreferenceChangeListener {
        C365791() {
        }

        public final boolean onPreferenceChange(Preference preference, Object obj) {
            AppMethodBeat.m2504i(113260);
            if (!WeUIPreference.this.szZ && preference.isEnabled() && preference.isSelectable()) {
                boolean z;
                WeUIPreference.this.szZ = true;
                if (preference instanceof CheckBoxPreference) {
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                    checkBoxPreference.uOT = checkBoxPreference.isChecked();
                    if (checkBoxPreference.isPersistent()) {
                        WeUIPreference.this.ehZ.edit().putBoolean(preference.getKey(), checkBoxPreference.isChecked()).commit();
                    }
                    WeUIPreference.this.dirty = true;
                    z = true;
                } else {
                    z = false;
                }
                if (preference.getKey() != null) {
                    WeUIPreference.this.ALu;
                }
                if (z) {
                    WeUIPreference.this.ALu.notifyDataSetChanged();
                }
                WeUIPreference.this.szZ = false;
                if (z) {
                    AppMethodBeat.m2505o(113260);
                    return true;
                }
            }
            AppMethodBeat.m2505o(113260);
            return false;
        }
    }

    /* renamed from: com.tencent.weui.base.preference.WeUIPreference$3 */
    class C365803 implements OnItemLongClickListener {
        C365803() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(113262);
            if (i < WeUIPreference.this.nDp.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(113262);
            } else {
                int headerViewsCount = i - WeUIPreference.this.nDp.getHeaderViewsCount();
                if (headerViewsCount >= WeUIPreference.this.ALu.getCount()) {
                    C5227ai.m7972e("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(WeUIPreference.this.ALu.getCount()));
                    AppMethodBeat.m2505o(113262);
                } else {
                    WeUIPreference.this.ALu.getItem(headerViewsCount);
                    WeUIPreference.this.ALu;
                    WeUIPreference.this.nDp;
                    AppMethodBeat.m2505o(113262);
                }
            }
            return false;
        }
    }

    /* renamed from: com.tencent.weui.base.preference.WeUIPreference$2 */
    class C365812 implements OnItemClickListener {
        C365812() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(113261);
            Preference preference = (Preference) adapterView.getAdapter().getItem(i);
            if (preference == null) {
                AppMethodBeat.m2505o(113261);
                return;
            }
            if (preference.isEnabled() && preference.isSelectable()) {
                if (preference instanceof CheckBoxPreference) {
                    AppMethodBeat.m2505o(113261);
                    return;
                } else if (preference.getKey() != null) {
                    WeUIPreference.this.ALu;
                }
            }
            AppMethodBeat.m2505o(113261);
        }
    }

    /* renamed from: JC */
    public abstract int mo58383JC();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onResume() {
        this.ALu.notifyDataSetChanged();
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.ALu = new C41115b(this, this.ehZ);
        this.nDp = (ListView) findViewById(16908298);
        this.yCx = (RelativeLayout) findViewById(2131826070);
        this.yCy = (TextView) findViewById(2131826072);
        this.yCz = (ImageView) findViewById(2131826071);
        C41115b c41115b = this.ALu;
        c41115b.ALy = new C365791();
        c41115b.notifyDataSetChanged();
        int JC = mo58383JC();
        if (JC != -1) {
            C41115b c41115b2 = this.ALu;
            c41115b2.ALx = true;
            C46826c c46826c = c41115b2.ALw;
            XmlResourceParser xml = c46826c.mContext.getResources().getXml(JC);
            if (xml != null) {
                try {
                    c46826c.mo75869a(xml, c41115b2);
                } finally {
                    xml.close();
                }
            }
            c41115b2.ALx = false;
            c41115b2.notifyDataSetChanged();
        }
        this.nDp.setAdapter(this.ALu);
        this.nDp.setOnItemClickListener(new C365812());
        this.nDp.setOnItemLongClickListener(new C365803());
        this.nDp.setOnScrollListener(new C245194());
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }
}
