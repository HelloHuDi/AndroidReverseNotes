package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.preference.Preference.a;

public abstract class MMPreferenceFragment extends MMFragment {
    private boolean dirty = false;
    private SharedPreferences ehZ;
    protected ListView nDp;
    private boolean szZ = false;
    private int yCO = 0;
    private int yCP = 0;
    protected boolean yCQ;
    protected h yCw;

    public abstract int JC();

    public abstract boolean a(f fVar, Preference preference);

    public int getLayoutId() {
        return R.layout.afg;
    }

    public View getLayoutView() {
        return b.SM().a(getContext(), "R.layout.mm_preference_fragment_list_content", (int) R.layout.afg);
    }

    public void onResume() {
        super.onResume();
        this.yCw.notifyDataSetChanged();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.yCQ = false;
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.nDp = (ListView) findViewById(16908298);
        this.yCw = new h(getContext(), this.nDp, this.ehZ);
        this.yCw.b(new a() {
            public final boolean a(Preference preference, Object obj) {
                AppMethodBeat.i(107237);
                if (!MMPreferenceFragment.this.szZ && preference.isEnabled() && preference.yDd) {
                    boolean z;
                    MMPreferenceFragment.this.szZ = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.uOT = checkBoxPreference.isChecked();
                        if (checkBoxPreference.yDf) {
                            MMPreferenceFragment.this.ehZ.edit().putBoolean(preference.mKey, checkBoxPreference.isChecked()).commit();
                        }
                        MMPreferenceFragment.this.dirty = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.mKey != null) {
                        MMPreferenceFragment.this.a(MMPreferenceFragment.this.yCw, preference);
                    }
                    if (z) {
                        MMPreferenceFragment.this.yCw.notifyDataSetChanged();
                    }
                    MMPreferenceFragment.this.szZ = false;
                    if (z) {
                        AppMethodBeat.o(107237);
                        return true;
                    }
                }
                AppMethodBeat.o(107237);
                return false;
            }
        });
        this.nDp.setAdapter(this.yCw);
        this.nDp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107240);
                if (i < MMPreferenceFragment.this.nDp.getHeaderViewsCount()) {
                    AppMethodBeat.o(107240);
                    return;
                }
                final Preference preference = (Preference) MMPreferenceFragment.this.yCw.getItem(i - MMPreferenceFragment.this.nDp.getHeaderViewsCount());
                if (preference.isEnabled() && preference.yDd) {
                    if (preference instanceof CheckBoxPreference) {
                        AppMethodBeat.o(107240);
                        return;
                    }
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.yBy = new DialogPreference.a() {
                            public final void dAx() {
                                AppMethodBeat.i(107238);
                                MMPreferenceFragment.this.dirty = true;
                                if (dialogPreference.yDf) {
                                    MMPreferenceFragment.this.ehZ.edit().putString(preference.mKey, dialogPreference.getValue()).commit();
                                }
                                MMPreferenceFragment.this.yCw.notifyDataSetChanged();
                                AppMethodBeat.o(107238);
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.yBA = new EditPreference.a() {
                            public final void dAx() {
                                AppMethodBeat.i(107239);
                                MMPreferenceFragment.this.dirty = true;
                                if (editPreference.yDf) {
                                    MMPreferenceFragment.this.ehZ.edit().putString(preference.mKey, editPreference.value).commit();
                                }
                                MMPreferenceFragment.this.yCw.notifyDataSetChanged();
                                AppMethodBeat.o(107239);
                            }
                        };
                    }
                    if (preference.mKey != null) {
                        MMPreferenceFragment.this.a(MMPreferenceFragment.this.yCw, preference);
                    }
                }
                AppMethodBeat.o(107240);
            }
        });
        this.nDp.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107241);
                if (i < MMPreferenceFragment.this.nDp.getHeaderViewsCount()) {
                    AppMethodBeat.o(107241);
                    return false;
                }
                boolean a = MMPreferenceFragment.this.a(MMPreferenceFragment.this.yCw, (Preference) MMPreferenceFragment.this.yCw.getItem(i - MMPreferenceFragment.this.nDp.getHeaderViewsCount()), MMPreferenceFragment.this.nDp);
                AppMethodBeat.o(107241);
                return a;
            }
        });
        if (this.yCP != 0) {
            this.nDp.setSelectionFromTop(0, this.yCP);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final void dAE() {
        if (!this.yCQ) {
            int JC = JC();
            if (JC != -1) {
                this.yCw.addPreferencesFromResource(JC);
                this.yCQ = true;
            }
        }
    }

    public boolean a(f fVar, Preference preference, View view) {
        return false;
    }
}
