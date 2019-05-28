package com.tencent.p177mm.p612ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.preference.DialogPreference.C15534a;
import com.tencent.p177mm.p612ui.base.preference.EditPreference.C40672a;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;

/* renamed from: com.tencent.mm.ui.base.preference.MMPreferenceFragment */
public abstract class MMPreferenceFragment extends MMFragment {
    private boolean dirty = false;
    private SharedPreferences ehZ;
    protected ListView nDp;
    private boolean szZ = false;
    private int yCO = 0;
    private int yCP = 0;
    protected boolean yCQ;
    protected C40675h yCw;

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreferenceFragment$2 */
    class C52822 implements OnItemClickListener {
        C52822() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107240);
            if (i < MMPreferenceFragment.this.nDp.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(107240);
                return;
            }
            final Preference preference = (Preference) MMPreferenceFragment.this.yCw.getItem(i - MMPreferenceFragment.this.nDp.getHeaderViewsCount());
            if (preference.isEnabled() && preference.yDd) {
                if (preference instanceof CheckBoxPreference) {
                    AppMethodBeat.m2505o(107240);
                    return;
                }
                if (preference instanceof DialogPreference) {
                    final DialogPreference dialogPreference = (DialogPreference) preference;
                    dialogPreference.showDialog();
                    dialogPreference.yBy = new C15534a() {
                        public final void dAx() {
                            AppMethodBeat.m2504i(107238);
                            MMPreferenceFragment.this.dirty = true;
                            if (dialogPreference.yDf) {
                                MMPreferenceFragment.this.ehZ.edit().putString(preference.mKey, dialogPreference.getValue()).commit();
                            }
                            MMPreferenceFragment.this.yCw.notifyDataSetChanged();
                            AppMethodBeat.m2505o(107238);
                        }
                    };
                }
                if (preference instanceof EditPreference) {
                    final EditPreference editPreference = (EditPreference) preference;
                    editPreference.showDialog();
                    editPreference.yBA = new C40672a() {
                        public final void dAx() {
                            AppMethodBeat.m2504i(107239);
                            MMPreferenceFragment.this.dirty = true;
                            if (editPreference.yDf) {
                                MMPreferenceFragment.this.ehZ.edit().putString(preference.mKey, editPreference.value).commit();
                            }
                            MMPreferenceFragment.this.yCw.notifyDataSetChanged();
                            AppMethodBeat.m2505o(107239);
                        }
                    };
                }
                if (preference.mKey != null) {
                    MMPreferenceFragment.this.mo48648a(MMPreferenceFragment.this.yCw, preference);
                }
            }
            AppMethodBeat.m2505o(107240);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreferenceFragment$3 */
    class C52853 implements OnItemLongClickListener {
        C52853() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107241);
            if (i < MMPreferenceFragment.this.nDp.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(107241);
                return false;
            }
            boolean a = MMPreferenceFragment.this.mo48649a(MMPreferenceFragment.this.yCw, (Preference) MMPreferenceFragment.this.yCw.getItem(i - MMPreferenceFragment.this.nDp.getHeaderViewsCount()), MMPreferenceFragment.this.nDp);
            AppMethodBeat.m2505o(107241);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreferenceFragment$1 */
    class C360801 implements C23632a {
        C360801() {
        }

        /* renamed from: a */
        public final boolean mo39405a(Preference preference, Object obj) {
            AppMethodBeat.m2504i(107237);
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
                    MMPreferenceFragment.this.mo48648a(MMPreferenceFragment.this.yCw, preference);
                }
                if (z) {
                    MMPreferenceFragment.this.yCw.notifyDataSetChanged();
                }
                MMPreferenceFragment.this.szZ = false;
                if (z) {
                    AppMethodBeat.m2505o(107237);
                    return true;
                }
            }
            AppMethodBeat.m2505o(107237);
            return false;
        }
    }

    /* renamed from: JC */
    public abstract int mo48647JC();

    /* renamed from: a */
    public abstract boolean mo48648a(C15541f c15541f, Preference preference);

    public int getLayoutId() {
        return 2130970177;
    }

    public View getLayoutView() {
        return C1742b.m3596SM().mo5274a(getContext(), "R.layout.mm_preference_fragment_list_content", 2130970177);
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
        this.yCw = new C40675h(getContext(), this.nDp, this.ehZ);
        this.yCw.mo64172b(new C360801());
        this.nDp.setAdapter(this.yCw);
        this.nDp.setOnItemClickListener(new C52822());
        this.nDp.setOnItemLongClickListener(new C52853());
        if (this.yCP != 0) {
            this.nDp.setSelectionFromTop(0, this.yCP);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final void dAE() {
        if (!this.yCQ) {
            int JC = mo48647JC();
            if (JC != -1) {
                this.yCw.addPreferencesFromResource(JC);
                this.yCQ = true;
            }
        }
    }

    /* renamed from: a */
    public boolean mo48649a(C15541f c15541f, Preference preference, View view) {
        return false;
    }
}
