package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class h extends BaseAdapter implements f {
    private final Context context;
    private final SharedPreferences ehZ;
    private ListView gGW;
    private a yBv;
    private final i yCE;
    private final LinkedList<String> yCF = new LinkedList();
    private final HashMap<String, Preference> yCG = new HashMap();
    private final HashSet<String> yCH = new HashSet();
    private final LinkedList<String> yCI = new LinkedList();
    private final HashMap<String, Integer> yCJ = new HashMap();
    private final HashMap<String, String> yCK = new HashMap();
    private int[] yCL = new int[0];
    private boolean yCM = false;
    private boolean yCN = false;

    public h(Context context, ListView listView, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(107214);
        this.yCE = new i(context);
        this.context = context;
        this.gGW = listView;
        this.ehZ = sharedPreferences;
        AppMethodBeat.o(107214);
    }

    private static String e(Preference preference) {
        AppMethodBeat.i(107215);
        String str = preference.getClass().getName() + "L" + preference.getLayoutResource() + QLog.TAG_REPORTLEVEL_COLORUSER + preference.yDl;
        AppMethodBeat.o(107215);
        return str;
    }

    public final int indexOf(String str) {
        AppMethodBeat.i(107217);
        int indexOf = this.yCF.indexOf(str);
        AppMethodBeat.o(107217);
        return indexOf;
    }

    public final int aqQ(String str) {
        AppMethodBeat.i(107218);
        if (this.yCI == null) {
            AppMethodBeat.o(107218);
            return -1;
        }
        int indexOf = this.yCI.indexOf(str);
        AppMethodBeat.o(107218);
        return indexOf;
    }

    public final void b(Preference preference) {
        AppMethodBeat.i(139075);
        a(preference, -1);
        AppMethodBeat.o(139075);
    }

    public final void c(Preference preference) {
        AppMethodBeat.i(107220);
        b(preference, -1);
        AppMethodBeat.o(107220);
    }

    public final void a(Preference preference, int i) {
        AppMethodBeat.i(107221);
        b(preference, i);
        if (!this.yCM) {
            notifyDataSetChanged();
        }
        AppMethodBeat.o(107221);
    }

    private void b(Preference preference, int i) {
        AppMethodBeat.i(107222);
        String f = f(preference);
        this.yCG.put(f, preference);
        LinkedList linkedList = this.yCF;
        if (i == -1) {
            i = this.yCF.size();
        }
        linkedList.add(i, f);
        if (!this.yCJ.containsKey(e(preference)) && this.yCM) {
            this.yCJ.put(e(preference), Integer.valueOf(this.yCJ.size()));
        }
        if (preference.yDg != null) {
            this.yCK.put(preference.yDg + "|" + preference.mKey, preference.mKey);
        }
        AppMethodBeat.o(107222);
    }

    public final Preference aqO(String str) {
        AppMethodBeat.i(107223);
        Preference preference = (Preference) this.yCG.get(str);
        AppMethodBeat.o(107223);
        return preference;
    }

    public final void ce(String str, boolean z) {
        AppMethodBeat.i(107224);
        if (z) {
            if (this.yCH.contains(str)) {
                AppMethodBeat.o(107224);
                return;
            }
            this.yCH.add(str);
        } else if (!this.yCH.remove(str)) {
            AppMethodBeat.o(107224);
            return;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(107224);
    }

    public final boolean d(Preference preference) {
        AppMethodBeat.i(107225);
        if (preference == null) {
            AppMethodBeat.o(107225);
            return false;
        }
        String f = f(preference);
        this.yCF.remove(f);
        this.yCG.remove(f);
        this.yCH.remove(preference.mKey);
        notifyDataSetChanged();
        AppMethodBeat.o(107225);
        return true;
    }

    public final boolean aqP(String str) {
        AppMethodBeat.i(107226);
        boolean d = d(aqO(str));
        AppMethodBeat.o(107226);
        return d;
    }

    public final void removeAll() {
        AppMethodBeat.i(107227);
        this.yCI.clear();
        this.yCG.clear();
        this.yCF.clear();
        this.yCH.clear();
        notifyDataSetChanged();
        AppMethodBeat.o(107227);
    }

    public final void addPreferencesFromResource(int i) {
        AppMethodBeat.i(107228);
        this.yCM = true;
        this.yCE.a(i, (f) this);
        this.yCM = false;
        if (this.gGW != null) {
            this.gGW.setAdapter(this);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(107228);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(107229);
        this.yBv = aVar;
        notifyDataSetChanged();
        AppMethodBeat.o(107229);
    }

    private static boolean NU(int i) {
        return i == R.layout.ae4 || i == R.layout.ag7 || i == R.layout.ag_;
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(107231);
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.yDf) {
                checkBoxPreference.uOT = sharedPreferences.getBoolean(preference.mKey, ((CheckBoxPreference) preference).isChecked());
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.yDf) {
                dialogPreference.setValue(sharedPreferences.getString(preference.mKey, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.yDf) {
                editPreference.value = sharedPreferences.getString(preference.mKey, null);
                editPreference.setSummary((CharSequence) editPreference.value);
            }
        }
        AppMethodBeat.o(107231);
    }

    public int getCount() {
        AppMethodBeat.i(107232);
        int size = this.yCI.size();
        AppMethodBeat.o(107232);
        return size;
    }

    public Object getItem(int i) {
        AppMethodBeat.i(107233);
        Object obj = this.yCG.get(this.yCI.get(i));
        AppMethodBeat.o(107233);
        return obj;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        AppMethodBeat.i(107234);
        if (!this.yCN) {
            this.yCN = true;
        }
        int max = Math.max(1, this.yCJ.size());
        AppMethodBeat.o(107234);
        return max;
    }

    public int getItemViewType(int i) {
        AppMethodBeat.i(107235);
        if (i > this.yCI.size()) {
            AppMethodBeat.o(107235);
            return -1;
        }
        Integer num = (Integer) this.yCJ.get(e((Preference) this.yCG.get(this.yCI.get(i))));
        if (num == null) {
            AppMethodBeat.o(107235);
            return -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(107235);
        return intValue;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107236);
        if (i > this.yCI.size()) {
            AppMethodBeat.o(107236);
        } else {
            Preference preference = (Preference) this.yCG.get(this.yCI.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.a(this.yBv);
            }
            if (!this.yCJ.containsKey(e(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.yCL[i];
            View findViewById = view.findViewById(R.id.m5);
            View findViewById2 = view.findViewById(R.id.d9u);
            if (findViewById == null) {
                ab.d("MicroMsg.MMPreferenceAdapter", "find content view error");
                AppMethodBeat.o(107236);
            } else {
                View findViewById3 = findViewById.findViewById(R.id.l5);
                view.findViewById(16908312);
                findViewById.getPaddingLeft();
                findViewById.getPaddingRight();
                findViewById.getPaddingTop();
                findViewById.getPaddingBottom();
                int paddingLeft = view.getPaddingLeft();
                int paddingRight = view.getPaddingRight();
                int paddingTop = view.getPaddingTop();
                int paddingBottom = view.getPaddingBottom();
                int paddingLeft2;
                if ((i2 & 2) != 0) {
                    paddingLeft2 = findViewById.getPaddingLeft();
                    findViewById.setBackgroundResource(R.drawable.a_q);
                    findViewById.setPadding(paddingLeft2, 0, 0, 0);
                    if (!(findViewById3 == null || findViewById3.getBackground() == null)) {
                        findViewById3.setBackground(null);
                    }
                } else if (findViewById3 != null) {
                    paddingLeft2 = findViewById3.getPaddingTop();
                    int paddingBottom2 = findViewById3.getPaddingBottom();
                    findViewById3.setBackgroundResource(R.drawable.a_q);
                    findViewById3.setPadding(0, paddingLeft2, 0, paddingBottom2);
                    if (!(findViewById == null || findViewById.getBackground() == null)) {
                        findViewById.setBackground(null);
                    }
                }
                view.setBackgroundResource(R.drawable.zj);
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                if (!((i2 & 1) == 0 || findViewById2 == null)) {
                    findViewById2.setBackgroundResource(R.drawable.a7r);
                }
                AppMethodBeat.o(107236);
            }
        }
        return view;
    }

    private static String f(Preference preference) {
        AppMethodBeat.i(107216);
        String str;
        if (preference.mKey == null || preference.mKey.length() <= 0) {
            str = "_anonymous_pref@" + preference.hashCode();
            AppMethodBeat.o(107216);
            return str;
        }
        str = preference.mKey;
        AppMethodBeat.o(107216);
        return str;
    }

    public void notifyDataSetChanged() {
        Preference preference;
        int i = 0;
        AppMethodBeat.i(107230);
        this.yCI.clear();
        Iterator it = this.yCF.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.yCH.contains(str)) {
                if (this.yCG.get(str) == null) {
                    ab.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)));
                } else {
                    this.yCI.add(str);
                }
            }
        }
        if (!this.yCI.isEmpty()) {
            this.yCG.get(this.yCI.get(0));
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (i2 < this.yCI.size()) {
            preference = (Preference) this.yCG.get(this.yCI.get(i2));
            if ((preference instanceof PreferenceCategory) && bo.isNullOrNil(preference.mKey) && i2 != 0) {
                Preference preference2 = (Preference) this.yCG.get(this.yCI.get(i2 - 1));
                if (preference2 instanceof PreferenceCategory) {
                    if (bo.isNullOrNil(preference2.mKey) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(f(preference2));
                    } else if (bo.isNullOrNil(preference.mKey) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(f(preference));
                    }
                }
            }
            i2++;
        }
        this.yCI.removeAll(hashSet);
        this.yCL = new int[this.yCI.size()];
        int[] iArr;
        if (this.yCL.length <= 0) {
            AppMethodBeat.o(107230);
        } else if (this.yCL.length == 1) {
            preference = (Preference) this.yCG.get(this.yCI.get(0));
            if (!NU(((Preference) this.yCG.get(this.yCI.get(0))).getLayoutResource())) {
                this.yCL[0] = 4;
            } else if (preference instanceof CheckBoxPreference) {
                iArr = this.yCL;
                iArr[0] = iArr[0] | 8;
                iArr = this.yCL;
                iArr[0] = iArr[0] | 1;
            } else {
                this.yCL[0] = 3;
            }
            a((Preference) this.yCG.get(this.yCI.get(0)), this.ehZ);
            super.notifyDataSetChanged();
            AppMethodBeat.o(107230);
        } else {
            while (i < this.yCI.size()) {
                a((Preference) this.yCG.get(this.yCI.get(i)), this.ehZ);
                preference = (Preference) this.yCG.get(this.yCI.get(i));
                int layoutResource = preference.getLayoutResource();
                int layoutResource2;
                if (NU(layoutResource)) {
                    if (preference instanceof CheckBoxPreference) {
                        iArr = this.yCL;
                        iArr[i] = iArr[i] | 8;
                    }
                    if (i == 0) {
                        iArr = this.yCL;
                        iArr[i] = iArr[i] | 1;
                        iArr = this.yCL;
                        iArr[i] = iArr[i] | 16;
                    } else {
                        if (i == this.yCI.size() - 1) {
                            iArr = this.yCL;
                            iArr[i] = iArr[i] | 2;
                        }
                        layoutResource2 = ((Preference) this.yCG.get(this.yCI.get(i - 1))).getLayoutResource();
                        if (layoutResource2 != R.layout.ae4 || layoutResource2 == R.layout.ag7 || layoutResource2 == R.layout.ag_) {
                            iArr = this.yCL;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != R.layout.afn) {
                    iArr = this.yCL;
                    iArr[i] = iArr[i] | 4;
                    if (i == 0) {
                        iArr = this.yCL;
                        iArr[i] = iArr[i] | 16;
                    } else {
                        layoutResource2 = ((Preference) this.yCG.get(this.yCI.get(i - 1))).getLayoutResource();
                        if (NU(layoutResource2) || layoutResource2 == R.layout.afn) {
                            iArr = this.yCL;
                            layoutResource = i - 1;
                            iArr[layoutResource] = iArr[layoutResource] | 2;
                        }
                    }
                } else if (i == 0) {
                    iArr = this.yCL;
                    iArr[i] = iArr[i] | 4;
                    iArr = this.yCL;
                    iArr[i] = iArr[i] | 16;
                } else {
                    layoutResource2 = ((Preference) this.yCG.get(this.yCI.get(i - 1))).getLayoutResource();
                    if (layoutResource2 == R.layout.ae4 || layoutResource2 == R.layout.ag7 || layoutResource2 == R.layout.ag_) {
                        iArr = this.yCL;
                        layoutResource = i - 1;
                        iArr[layoutResource] = iArr[layoutResource] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(107230);
        }
    }
}
