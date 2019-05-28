package com.tencent.p177mm.p612ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.DialogPreference.C15534a;
import com.tencent.p177mm.p612ui.base.preference.EditPreference.C40672a;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.preference.MMPreference */
public abstract class MMPreference extends MMActivity {
    private boolean dirty = false;
    public SharedPreferences ehZ;
    public ListView nDp;
    private boolean szZ = false;
    public C40675h yCw;
    protected RelativeLayout yCx;
    protected TextView yCy;
    protected ImageView yCz;

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreference$4 */
    class C52814 implements OnScrollListener {
        C52814() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(107213);
            if (1 == i) {
                View currentFocus = MMPreference.this.getCurrentFocus();
                if (currentFocus != null) {
                    currentFocus.clearFocus();
                }
            }
            AppMethodBeat.m2505o(107213);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreference$1 */
    class C360761 implements C23632a {
        C360761() {
        }

        /* renamed from: a */
        public final boolean mo39405a(Preference preference, Object obj) {
            AppMethodBeat.m2504i(107208);
            if (!MMPreference.this.szZ && preference.isEnabled() && preference.yDd) {
                boolean z;
                MMPreference.this.szZ = true;
                if (preference instanceof CheckBoxPreference) {
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                    checkBoxPreference.uOT = checkBoxPreference.isChecked();
                    if (checkBoxPreference.yDf) {
                        MMPreference.this.ehZ.edit().putBoolean(preference.mKey, checkBoxPreference.isChecked()).commit();
                    }
                    MMPreference.this.dirty = true;
                    z = true;
                } else {
                    z = false;
                }
                if (preference.mKey != null) {
                    MMPreference.this.mo8453a(MMPreference.this.yCw, preference);
                }
                if (z) {
                    MMPreference.this.yCw.notifyDataSetChanged();
                }
                MMPreference.this.szZ = false;
                if (z) {
                    AppMethodBeat.m2505o(107208);
                    return true;
                }
            }
            AppMethodBeat.m2505o(107208);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreference$2 */
    class C360772 implements OnItemClickListener {
        C360772() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107211);
            final Preference preference = (Preference) adapterView.getAdapter().getItem(i);
            if (preference == null) {
                AppMethodBeat.m2505o(107211);
                return;
            }
            if (preference.isEnabled() && preference.yDd) {
                if (preference instanceof CheckBoxPreference) {
                    AppMethodBeat.m2505o(107211);
                    return;
                }
                if (preference instanceof DialogPreference) {
                    final DialogPreference dialogPreference = (DialogPreference) preference;
                    dialogPreference.showDialog();
                    dialogPreference.yBy = new C15534a() {
                        public final void dAx() {
                            AppMethodBeat.m2504i(107209);
                            MMPreference.this.dirty = true;
                            if (dialogPreference.yDf) {
                                MMPreference.this.ehZ.edit().putString(preference.mKey, dialogPreference.getValue()).commit();
                            }
                            MMPreference.this.yCw.notifyDataSetChanged();
                            AppMethodBeat.m2505o(107209);
                        }
                    };
                }
                if (preference instanceof EditPreference) {
                    final EditPreference editPreference = (EditPreference) preference;
                    editPreference.showDialog();
                    editPreference.yBA = new C40672a() {
                        public final void dAx() {
                            AppMethodBeat.m2504i(107210);
                            MMPreference.this.dirty = true;
                            if (editPreference.yDf) {
                                MMPreference.this.ehZ.edit().putString(preference.mKey, editPreference.value).commit();
                            }
                            MMPreference.this.yCw.notifyDataSetChanged();
                            AppMethodBeat.m2505o(107210);
                        }
                    };
                }
                if (preference.mKey != null) {
                    MMPreference.this.mo8453a(MMPreference.this.yCw, preference);
                }
            }
            AppMethodBeat.m2505o(107211);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.MMPreference$3 */
    class C360793 implements OnItemLongClickListener {
        C360793() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(107212);
            if (i < MMPreference.this.nDp.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(107212);
            } else {
                int headerViewsCount = i - MMPreference.this.nDp.getHeaderViewsCount();
                if (headerViewsCount >= MMPreference.this.yCw.getCount()) {
                    C4990ab.m7413e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(MMPreference.this.yCw.getCount()));
                    AppMethodBeat.m2505o(107212);
                } else {
                    MMPreference.this.yCw.getItem(headerViewsCount);
                    MMPreference.this.yCw;
                    MMPreference.this.nDp;
                    AppMethodBeat.m2505o(107212);
                }
            }
            return false;
        }
    }

    /* renamed from: JC */
    public abstract int mo8452JC();

    /* renamed from: a */
    public abstract boolean mo8453a(C15541f c15541f, Preference preference);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public int getLayoutId() {
        return 2130970193;
    }

    /* Access modifiers changed, original: protected */
    public boolean aqT() {
        return true;
    }

    public void onResume() {
        if (aqT()) {
            this.yCw.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.nDp = (ListView) findViewById(16908298);
        this.yCw = mo14627a(this.ehZ);
        this.yCx = (RelativeLayout) findViewById(2131826070);
        this.yCy = (TextView) findViewById(2131826072);
        this.yCz = (ImageView) findViewById(2131826071);
        int aWi = aWi();
        if (aWi != -1) {
            this.nDp.addHeaderView(getLayoutInflater().inflate(aWi, null));
        }
        View aWz = aWz();
        if (aWz != null) {
            if (aWz.getLayoutParams() != null) {
                aWz.setLayoutParams(new LayoutParams(aWz.getLayoutParams()));
            } else {
                C4990ab.m7412e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.nDp.addFooterView(aWz);
        }
        View ciC = ciC();
        if (ciC != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(2131826073);
            frameLayout.addView(ciC);
            frameLayout.setVisibility(0);
        }
        this.yCw.mo64172b(new C360761());
        aWi = mo8452JC();
        if (aWi != -1) {
            this.yCw.addPreferencesFromResource(aWi);
        }
        this.nDp.setAdapter(this.yCw);
        this.nDp.setOnItemClickListener(new C360772());
        this.nDp.setOnItemLongClickListener(new C360793());
        this.nDp.setOnScrollListener(new C52814());
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final void setSelection(int i) {
        this.nDp.setSelection(i);
    }

    public int aWi() {
        return -1;
    }

    public View aWz() {
        return null;
    }

    public View ciC() {
        return null;
    }

    /* renamed from: a */
    public C40675h mo14627a(SharedPreferences sharedPreferences) {
        return new C40675h(this, this.nDp, sharedPreferences);
    }
}
