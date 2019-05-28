package com.tencent.mm.ui.base.preference;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference.a;

public abstract class MMPreference extends MMActivity {
    private boolean dirty = false;
    public SharedPreferences ehZ;
    public ListView nDp;
    private boolean szZ = false;
    public h yCw;
    protected RelativeLayout yCx;
    protected TextView yCy;
    protected ImageView yCz;

    public abstract int JC();

    public abstract boolean a(f fVar, Preference preference);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public int getLayoutId() {
        return R.layout.afw;
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
        this.yCw = a(this.ehZ);
        this.yCx = (RelativeLayout) findViewById(R.id.dad);
        this.yCy = (TextView) findViewById(R.id.daf);
        this.yCz = (ImageView) findViewById(R.id.dae);
        int aWi = aWi();
        if (aWi != -1) {
            this.nDp.addHeaderView(getLayoutInflater().inflate(aWi, null));
        }
        View aWz = aWz();
        if (aWz != null) {
            if (aWz.getLayoutParams() != null) {
                aWz.setLayoutParams(new LayoutParams(aWz.getLayoutParams()));
            } else {
                ab.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.nDp.addFooterView(aWz);
        }
        View ciC = ciC();
        if (ciC != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.dag);
            frameLayout.addView(ciC);
            frameLayout.setVisibility(0);
        }
        this.yCw.b(new a() {
            public final boolean a(Preference preference, Object obj) {
                AppMethodBeat.i(107208);
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
                        MMPreference.this.a(MMPreference.this.yCw, preference);
                    }
                    if (z) {
                        MMPreference.this.yCw.notifyDataSetChanged();
                    }
                    MMPreference.this.szZ = false;
                    if (z) {
                        AppMethodBeat.o(107208);
                        return true;
                    }
                }
                AppMethodBeat.o(107208);
                return false;
            }
        });
        aWi = JC();
        if (aWi != -1) {
            this.yCw.addPreferencesFromResource(aWi);
        }
        this.nDp.setAdapter(this.yCw);
        this.nDp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107211);
                final Preference preference = (Preference) adapterView.getAdapter().getItem(i);
                if (preference == null) {
                    AppMethodBeat.o(107211);
                    return;
                }
                if (preference.isEnabled() && preference.yDd) {
                    if (preference instanceof CheckBoxPreference) {
                        AppMethodBeat.o(107211);
                        return;
                    }
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.yBy = new DialogPreference.a() {
                            public final void dAx() {
                                AppMethodBeat.i(107209);
                                MMPreference.this.dirty = true;
                                if (dialogPreference.yDf) {
                                    MMPreference.this.ehZ.edit().putString(preference.mKey, dialogPreference.getValue()).commit();
                                }
                                MMPreference.this.yCw.notifyDataSetChanged();
                                AppMethodBeat.o(107209);
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.yBA = new EditPreference.a() {
                            public final void dAx() {
                                AppMethodBeat.i(107210);
                                MMPreference.this.dirty = true;
                                if (editPreference.yDf) {
                                    MMPreference.this.ehZ.edit().putString(preference.mKey, editPreference.value).commit();
                                }
                                MMPreference.this.yCw.notifyDataSetChanged();
                                AppMethodBeat.o(107210);
                            }
                        };
                    }
                    if (preference.mKey != null) {
                        MMPreference.this.a(MMPreference.this.yCw, preference);
                    }
                }
                AppMethodBeat.o(107211);
            }
        });
        this.nDp.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(107212);
                if (i < MMPreference.this.nDp.getHeaderViewsCount()) {
                    AppMethodBeat.o(107212);
                } else {
                    int headerViewsCount = i - MMPreference.this.nDp.getHeaderViewsCount();
                    if (headerViewsCount >= MMPreference.this.yCw.getCount()) {
                        ab.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(MMPreference.this.yCw.getCount()));
                        AppMethodBeat.o(107212);
                    } else {
                        MMPreference.this.yCw.getItem(headerViewsCount);
                        MMPreference.this.yCw;
                        MMPreference.this.nDp;
                        AppMethodBeat.o(107212);
                    }
                }
                return false;
            }
        });
        this.nDp.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(107213);
                if (1 == i) {
                    View currentFocus = MMPreference.this.getCurrentFocus();
                    if (currentFocus != null) {
                        currentFocus.clearFocus();
                    }
                }
                AppMethodBeat.o(107213);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
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

    public h a(SharedPreferences sharedPreferences) {
        return new h(this, this.nDp, sharedPreferences);
    }
}
