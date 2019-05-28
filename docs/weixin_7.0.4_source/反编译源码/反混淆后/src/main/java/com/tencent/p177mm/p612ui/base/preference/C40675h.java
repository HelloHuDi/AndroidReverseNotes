package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.base.preference.h */
public class C40675h extends BaseAdapter implements C15541f {
    private final Context context;
    private final SharedPreferences ehZ;
    private ListView gGW;
    private C23632a yBv;
    private final C44276i yCE;
    private final LinkedList<String> yCF = new LinkedList();
    private final HashMap<String, Preference> yCG = new HashMap();
    private final HashSet<String> yCH = new HashSet();
    private final LinkedList<String> yCI = new LinkedList();
    private final HashMap<String, Integer> yCJ = new HashMap();
    private final HashMap<String, String> yCK = new HashMap();
    private int[] yCL = new int[0];
    private boolean yCM = false;
    private boolean yCN = false;

    public C40675h(Context context, ListView listView, SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(107214);
        this.yCE = new C44276i(context);
        this.context = context;
        this.gGW = listView;
        this.ehZ = sharedPreferences;
        AppMethodBeat.m2505o(107214);
    }

    /* renamed from: e */
    private static String m70255e(Preference preference) {
        AppMethodBeat.m2504i(107215);
        String str = preference.getClass().getName() + "L" + preference.getLayoutResource() + QLog.TAG_REPORTLEVEL_COLORUSER + preference.yDl;
        AppMethodBeat.m2505o(107215);
        return str;
    }

    public final int indexOf(String str) {
        AppMethodBeat.m2504i(107217);
        int indexOf = this.yCF.indexOf(str);
        AppMethodBeat.m2505o(107217);
        return indexOf;
    }

    public final int aqQ(String str) {
        AppMethodBeat.m2504i(107218);
        if (this.yCI == null) {
            AppMethodBeat.m2505o(107218);
            return -1;
        }
        int indexOf = this.yCI.indexOf(str);
        AppMethodBeat.m2505o(107218);
        return indexOf;
    }

    /* renamed from: b */
    public final void mo27713b(Preference preference) {
        AppMethodBeat.m2504i(139075);
        mo27708a(preference, -1);
        AppMethodBeat.m2505o(139075);
    }

    /* renamed from: c */
    public final void mo27714c(Preference preference) {
        AppMethodBeat.m2504i(107220);
        m70254b(preference, -1);
        AppMethodBeat.m2505o(107220);
    }

    /* renamed from: a */
    public final void mo27708a(Preference preference, int i) {
        AppMethodBeat.m2504i(107221);
        m70254b(preference, i);
        if (!this.yCM) {
            notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(107221);
    }

    /* renamed from: b */
    private void m70254b(Preference preference, int i) {
        AppMethodBeat.m2504i(107222);
        String f = C40675h.m70256f(preference);
        this.yCG.put(f, preference);
        LinkedList linkedList = this.yCF;
        if (i == -1) {
            i = this.yCF.size();
        }
        linkedList.add(i, f);
        if (!this.yCJ.containsKey(C40675h.m70255e(preference)) && this.yCM) {
            this.yCJ.put(C40675h.m70255e(preference), Integer.valueOf(this.yCJ.size()));
        }
        if (preference.yDg != null) {
            this.yCK.put(preference.yDg + "|" + preference.mKey, preference.mKey);
        }
        AppMethodBeat.m2505o(107222);
    }

    public final Preference aqO(String str) {
        AppMethodBeat.m2504i(107223);
        Preference preference = (Preference) this.yCG.get(str);
        AppMethodBeat.m2505o(107223);
        return preference;
    }

    /* renamed from: ce */
    public final void mo27715ce(String str, boolean z) {
        AppMethodBeat.m2504i(107224);
        if (z) {
            if (this.yCH.contains(str)) {
                AppMethodBeat.m2505o(107224);
                return;
            }
            this.yCH.add(str);
        } else if (!this.yCH.remove(str)) {
            AppMethodBeat.m2505o(107224);
            return;
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(107224);
    }

    /* renamed from: d */
    public final boolean mo27716d(Preference preference) {
        AppMethodBeat.m2504i(107225);
        if (preference == null) {
            AppMethodBeat.m2505o(107225);
            return false;
        }
        String f = C40675h.m70256f(preference);
        this.yCF.remove(f);
        this.yCG.remove(f);
        this.yCH.remove(preference.mKey);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(107225);
        return true;
    }

    public final boolean aqP(String str) {
        AppMethodBeat.m2504i(107226);
        boolean d = mo27716d(aqO(str));
        AppMethodBeat.m2505o(107226);
        return d;
    }

    public final void removeAll() {
        AppMethodBeat.m2504i(107227);
        this.yCI.clear();
        this.yCG.clear();
        this.yCF.clear();
        this.yCH.clear();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(107227);
    }

    public final void addPreferencesFromResource(int i) {
        AppMethodBeat.m2504i(107228);
        this.yCM = true;
        this.yCE.mo70138a(i, (C15541f) this);
        this.yCM = false;
        if (this.gGW != null) {
            this.gGW.setAdapter(this);
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(107228);
    }

    /* renamed from: b */
    public final void mo64172b(C23632a c23632a) {
        AppMethodBeat.m2504i(107229);
        this.yBv = c23632a;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(107229);
    }

    /* renamed from: NU */
    private static boolean m70252NU(int i) {
        return i == 2130970127 || i == 2130970204 || i == 2130970207;
    }

    /* renamed from: a */
    private static void m70253a(Preference preference, SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(107231);
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
        AppMethodBeat.m2505o(107231);
    }

    public int getCount() {
        AppMethodBeat.m2504i(107232);
        int size = this.yCI.size();
        AppMethodBeat.m2505o(107232);
        return size;
    }

    public Object getItem(int i) {
        AppMethodBeat.m2504i(107233);
        Object obj = this.yCG.get(this.yCI.get(i));
        AppMethodBeat.m2505o(107233);
        return obj;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        AppMethodBeat.m2504i(107234);
        if (!this.yCN) {
            this.yCN = true;
        }
        int max = Math.max(1, this.yCJ.size());
        AppMethodBeat.m2505o(107234);
        return max;
    }

    public int getItemViewType(int i) {
        AppMethodBeat.m2504i(107235);
        if (i > this.yCI.size()) {
            AppMethodBeat.m2505o(107235);
            return -1;
        }
        Integer num = (Integer) this.yCJ.get(C40675h.m70255e((Preference) this.yCG.get(this.yCI.get(i))));
        if (num == null) {
            AppMethodBeat.m2505o(107235);
            return -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(107235);
        return intValue;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107236);
        if (i > this.yCI.size()) {
            AppMethodBeat.m2505o(107236);
        } else {
            Preference preference = (Preference) this.yCG.get(this.yCI.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.mo27696a(this.yBv);
            }
            if (!this.yCJ.containsKey(C40675h.m70255e(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.yCL[i];
            View findViewById = view.findViewById(2131821019);
            View findViewById2 = view.findViewById(2131826013);
            if (findViewById == null) {
                C4990ab.m7410d("MicroMsg.MMPreferenceAdapter", "find content view error");
                AppMethodBeat.m2505o(107236);
            } else {
                View findViewById3 = findViewById.findViewById(2131820982);
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
                    findViewById.setBackgroundResource(C25738R.drawable.a_q);
                    findViewById.setPadding(paddingLeft2, 0, 0, 0);
                    if (!(findViewById3 == null || findViewById3.getBackground() == null)) {
                        findViewById3.setBackground(null);
                    }
                } else if (findViewById3 != null) {
                    paddingLeft2 = findViewById3.getPaddingTop();
                    int paddingBottom2 = findViewById3.getPaddingBottom();
                    findViewById3.setBackgroundResource(C25738R.drawable.a_q);
                    findViewById3.setPadding(0, paddingLeft2, 0, paddingBottom2);
                    if (!(findViewById == null || findViewById.getBackground() == null)) {
                        findViewById.setBackground(null);
                    }
                }
                view.setBackgroundResource(C25738R.drawable.f7046zj);
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                if (!((i2 & 1) == 0 || findViewById2 == null)) {
                    findViewById2.setBackgroundResource(C25738R.drawable.a7r);
                }
                AppMethodBeat.m2505o(107236);
            }
        }
        return view;
    }

    /* renamed from: f */
    private static String m70256f(Preference preference) {
        AppMethodBeat.m2504i(107216);
        String str;
        if (preference.mKey == null || preference.mKey.length() <= 0) {
            str = "_anonymous_pref@" + preference.hashCode();
            AppMethodBeat.m2505o(107216);
            return str;
        }
        str = preference.mKey;
        AppMethodBeat.m2505o(107216);
        return str;
    }

    public void notifyDataSetChanged() {
        Preference preference;
        int i = 0;
        AppMethodBeat.m2504i(107230);
        this.yCI.clear();
        Iterator it = this.yCF.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.yCH.contains(str)) {
                if (this.yCG.get(str) == null) {
                    C4990ab.m7412e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(str)));
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
            if ((preference instanceof PreferenceCategory) && C5046bo.isNullOrNil(preference.mKey) && i2 != 0) {
                Preference preference2 = (Preference) this.yCG.get(this.yCI.get(i2 - 1));
                if (preference2 instanceof PreferenceCategory) {
                    if (C5046bo.isNullOrNil(preference2.mKey) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(C40675h.m70256f(preference2));
                    } else if (C5046bo.isNullOrNil(preference.mKey) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(C40675h.m70256f(preference));
                    }
                }
            }
            i2++;
        }
        this.yCI.removeAll(hashSet);
        this.yCL = new int[this.yCI.size()];
        int[] iArr;
        if (this.yCL.length <= 0) {
            AppMethodBeat.m2505o(107230);
        } else if (this.yCL.length == 1) {
            preference = (Preference) this.yCG.get(this.yCI.get(0));
            if (!C40675h.m70252NU(((Preference) this.yCG.get(this.yCI.get(0))).getLayoutResource())) {
                this.yCL[0] = 4;
            } else if (preference instanceof CheckBoxPreference) {
                iArr = this.yCL;
                iArr[0] = iArr[0] | 8;
                iArr = this.yCL;
                iArr[0] = iArr[0] | 1;
            } else {
                this.yCL[0] = 3;
            }
            C40675h.m70253a((Preference) this.yCG.get(this.yCI.get(0)), this.ehZ);
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(107230);
        } else {
            while (i < this.yCI.size()) {
                C40675h.m70253a((Preference) this.yCG.get(this.yCI.get(i)), this.ehZ);
                preference = (Preference) this.yCG.get(this.yCI.get(i));
                int layoutResource = preference.getLayoutResource();
                int layoutResource2;
                if (C40675h.m70252NU(layoutResource)) {
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
                        if (layoutResource2 != 2130970127 || layoutResource2 == 2130970204 || layoutResource2 == 2130970207) {
                            iArr = this.yCL;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != 2130970184) {
                    iArr = this.yCL;
                    iArr[i] = iArr[i] | 4;
                    if (i == 0) {
                        iArr = this.yCL;
                        iArr[i] = iArr[i] | 16;
                    } else {
                        layoutResource2 = ((Preference) this.yCG.get(this.yCI.get(i - 1))).getLayoutResource();
                        if (C40675h.m70252NU(layoutResource2) || layoutResource2 == 2130970184) {
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
                    if (layoutResource2 == 2130970127 || layoutResource2 == 2130970204 || layoutResource2 == 2130970207) {
                        iArr = this.yCL;
                        layoutResource = i - 1;
                        iArr[layoutResource] = iArr[layoutResource] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(107230);
        }
    }
}
