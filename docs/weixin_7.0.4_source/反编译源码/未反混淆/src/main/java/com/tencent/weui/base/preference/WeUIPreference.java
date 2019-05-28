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
import com.tencent.mm.R;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.ai;

public abstract class WeUIPreference extends BaseActivity {
    private b ALu;
    private boolean dirty = false;
    private SharedPreferences ehZ;
    private ListView nDp;
    private boolean szZ = false;
    protected RelativeLayout yCx;
    protected TextView yCy;
    protected ImageView yCz;

    public abstract int JC();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onResume() {
        this.ALu.notifyDataSetChanged();
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.ALu = new b(this, this.ehZ);
        this.nDp = (ListView) findViewById(16908298);
        this.yCx = (RelativeLayout) findViewById(R.id.dad);
        this.yCy = (TextView) findViewById(R.id.daf);
        this.yCz = (ImageView) findViewById(R.id.dae);
        b bVar = this.ALu;
        bVar.ALy = new OnPreferenceChangeListener() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                AppMethodBeat.i(113260);
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
                        AppMethodBeat.o(113260);
                        return true;
                    }
                }
                AppMethodBeat.o(113260);
                return false;
            }
        };
        bVar.notifyDataSetChanged();
        int JC = JC();
        if (JC != -1) {
            b bVar2 = this.ALu;
            bVar2.ALx = true;
            c cVar = bVar2.ALw;
            XmlResourceParser xml = cVar.mContext.getResources().getXml(JC);
            if (xml != null) {
                try {
                    cVar.a(xml, bVar2);
                } finally {
                    xml.close();
                }
            }
            bVar2.ALx = false;
            bVar2.notifyDataSetChanged();
        }
        this.nDp.setAdapter(this.ALu);
        this.nDp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(113261);
                Preference preference = (Preference) adapterView.getAdapter().getItem(i);
                if (preference == null) {
                    AppMethodBeat.o(113261);
                    return;
                }
                if (preference.isEnabled() && preference.isSelectable()) {
                    if (preference instanceof CheckBoxPreference) {
                        AppMethodBeat.o(113261);
                        return;
                    } else if (preference.getKey() != null) {
                        WeUIPreference.this.ALu;
                    }
                }
                AppMethodBeat.o(113261);
            }
        });
        this.nDp.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(113262);
                if (i < WeUIPreference.this.nDp.getHeaderViewsCount()) {
                    AppMethodBeat.o(113262);
                } else {
                    int headerViewsCount = i - WeUIPreference.this.nDp.getHeaderViewsCount();
                    if (headerViewsCount >= WeUIPreference.this.ALu.getCount()) {
                        ai.e("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(WeUIPreference.this.ALu.getCount()));
                        AppMethodBeat.o(113262);
                    } else {
                        WeUIPreference.this.ALu.getItem(headerViewsCount);
                        WeUIPreference.this.ALu;
                        WeUIPreference.this.nDp;
                        AppMethodBeat.o(113262);
                    }
                }
                return false;
            }
        });
        this.nDp.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(113263);
                if (1 == i) {
                    View currentFocus = WeUIPreference.this.getCurrentFocus();
                    if (currentFocus != null) {
                        currentFocus.clearFocus();
                    }
                }
                AppMethodBeat.o(113263);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }
}
