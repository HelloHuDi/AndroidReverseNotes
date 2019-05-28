package com.tencent.p177mm.p612ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.view.C0464g;
import android.support.p057v4.view.C0464g.C0463d;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5553a;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5554b;
import com.tencent.p177mm.p612ui.tools.SearchViewNotRealTimeHelper.C5576a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.tools.o */
public class C5601o {
    final String TAG;
    C7306ak fbD;
    MenuItem mjk;
    boolean zGU;
    public boolean zGV;
    private boolean zGW;
    private boolean zGX;
    boolean zGY;
    public C5582d zGZ;
    public C5600b zHa;
    private C5576a zHb;
    private boolean zHc;
    private ArrayList<String> zHd;
    private boolean zHe;
    public int zHf;
    private int zHg;
    C5599a zHh;

    /* renamed from: com.tencent.mm.ui.tools.o$11 */
    class C559211 implements Runnable {
        C559211() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107770);
            if (C5601o.this.mjk == null) {
                C4990ab.m7420w(C5601o.this.TAG, "post do expand search menu, but search menu item is null");
                AppMethodBeat.m2505o(107770);
            } else if (C5601o.this.zGU) {
                C0464g.m812b(C5601o.this.mjk);
                AppMethodBeat.m2505o(107770);
            } else {
                if (C5601o.this.zHh != null) {
                    C5601o.this.zHh.dJT();
                }
                AppMethodBeat.m2505o(107770);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.o$3 */
    class C55953 implements Runnable {
        C55953() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107760);
            if (C5601o.this.zHa != null) {
                C5601o.this.zHa.apo();
            }
            AppMethodBeat.m2505o(107760);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.o$5 */
    class C55975 implements OnEditorActionListener {
        C55975() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(107762);
            if (3 != i || C5601o.this.zHa == null) {
                AppMethodBeat.m2505o(107762);
                return false;
            }
            boolean vN = C5601o.this.zHa.mo7459vN(C5601o.this.getSearchContent());
            AppMethodBeat.m2505o(107762);
            return vN;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.o$9 */
    class C55989 implements OnMenuItemClickListener {
        C55989() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.o$a */
    public interface C5599a {
        void collapseActionView();

        void dJT();
    }

    /* renamed from: com.tencent.mm.ui.tools.o$b */
    public interface C5600b {
        void apo();

        void app();

        void apq();

        void apr();

        /* renamed from: vN */
        boolean mo7459vN(String str);

        /* renamed from: vO */
        void mo7460vO(String str);
    }

    /* renamed from: com.tencent.mm.ui.tools.o$1 */
    class C56021 implements C5554b {
        C56021() {
        }

        public final void bKu() {
            AppMethodBeat.m2504i(107755);
            if (C5601o.this.zGV) {
                C5601o.this.amH();
                AppMethodBeat.m2505o(107755);
                return;
            }
            C4990ab.m7418v(C5601o.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.m2505o(107755);
        }

        public final void bKt() {
            AppMethodBeat.m2504i(107756);
            if (C5601o.this.zHa != null) {
                C5601o.this.zHa.apr();
            }
            AppMethodBeat.m2505o(107756);
        }

        /* renamed from: Qa */
        public final void mo11263Qa(String str) {
            AppMethodBeat.m2504i(107757);
            if (C5601o.this.zGV) {
                if (C5601o.this.zHa != null) {
                    C5601o.this.zHa.mo7460vO(str);
                }
                AppMethodBeat.m2505o(107757);
                return;
            }
            C4990ab.m7419v(C5601o.this.TAG, "onSearchTextChange %s, but not in searching", str);
            AppMethodBeat.m2505o(107757);
        }

        public final void apq() {
            AppMethodBeat.m2504i(107758);
            if (C5601o.this.zHa != null) {
                C5601o.this.zHa.apq();
            }
            AppMethodBeat.m2505o(107758);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.o$8 */
    class C56058 implements C5553a {
        C56058() {
        }

        public final void bKv() {
            AppMethodBeat.m2504i(107767);
            if (C5601o.this.zGU) {
                if (C5601o.this.mjk != null) {
                    C0464g.m813c(C5601o.this.mjk);
                    AppMethodBeat.m2505o(107767);
                    return;
                }
            } else if (C5601o.this.zHh != null) {
                C5601o.this.zHh.collapseActionView();
            }
            AppMethodBeat.m2505o(107767);
        }
    }

    public C5601o() {
        AppMethodBeat.m2504i(107772);
        this.zGU = false;
        this.zGV = false;
        this.zGW = false;
        this.zGX = true;
        this.zGY = true;
        this.mjk = null;
        this.fbD = new C7306ak(Looper.getMainLooper());
        this.zGZ = null;
        this.zHc = true;
        this.zHf = C25738R.string.f9104pl;
        this.zHg = 0;
        this.zHc = true;
        this.zGU = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
        AppMethodBeat.m2505o(107772);
    }

    public C5601o(byte b) {
        AppMethodBeat.m2504i(107773);
        this.zGU = false;
        this.zGV = false;
        this.zGW = false;
        this.zGX = true;
        this.zGY = true;
        this.mjk = null;
        this.fbD = new C7306ak(Looper.getMainLooper());
        this.zGZ = null;
        this.zHc = true;
        this.zHf = C25738R.string.f9104pl;
        this.zHg = 0;
        this.zHc = true;
        this.zGU = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
        AppMethodBeat.m2505o(107773);
    }

    public final String getSearchContent() {
        AppMethodBeat.m2504i(107774);
        String searchContent;
        if (this.zGZ != null) {
            searchContent = this.zGZ.getSearchContent();
            AppMethodBeat.m2505o(107774);
            return searchContent;
        }
        searchContent = "";
        AppMethodBeat.m2505o(107774);
        return searchContent;
    }

    public void setSearchContent(String str) {
        AppMethodBeat.m2504i(107775);
        if (this.zGZ == null) {
            AppMethodBeat.m2505o(107775);
            return;
        }
        this.zGZ.setSearchContent(str);
        AppMethodBeat.m2505o(107775);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.m2504i(107776);
        if (this.zGZ == null) {
            AppMethodBeat.m2505o(107776);
            return;
        }
        this.zGZ.setHint(charSequence);
        AppMethodBeat.m2505o(107776);
    }

    public final void clearFocus() {
        AppMethodBeat.m2504i(107777);
        if (this.zGZ != null) {
            this.zGZ.dJr();
        }
        AppMethodBeat.m2505o(107777);
    }

    /* Access modifiers changed, original: protected */
    public boolean amG() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void amH() {
    }

    /* Access modifiers changed, original: protected */
    public void amI() {
    }

    /* renamed from: a */
    public void mo11359a(final FragmentActivity fragmentActivity, Menu menu) {
        AppMethodBeat.m2504i(107778);
        C4990ab.m7418v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            C4990ab.m7420w(this.TAG, "on add search menu, activity is null");
            AppMethodBeat.m2505o(107778);
            return;
        }
        if (this.zGZ == null) {
            if (this.zHc) {
                this.zGZ = new ActionBarSearchView(fragmentActivity);
            } else {
                this.zGZ = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.zGZ.setNotRealCallBack(this.zHb);
            }
            this.zGZ.setAutoMatchKeywords(this.zHe);
            this.zGZ.setKeywords(this.zHd);
        }
        this.zGZ.setCallBack(new C56021());
        this.zGZ.mo11322qN(amG());
        this.zGZ.setOnEditorActionListener(new C55975());
        if (this.zHg != 0) {
            this.zGZ.setSearchTipIcon(this.zHg);
        }
        this.mjk = menu.add(0, 2131820645, 0, this.zHf);
        this.mjk.setEnabled(this.zGX);
        this.mjk.setIcon(C1318a.actionbar_icon_dark_search);
        C0464g.m803a(this.mjk, (View) this.zGZ);
        if (this.zGU) {
            C0464g.m806a(this.mjk, 9);
        } else {
            C0464g.m806a(this.mjk, 2);
        }
        if (this.zGU) {
            C0464g.m802a(this.mjk, new C0463d() {
                /* renamed from: eo */
                public final boolean mo1062eo() {
                    AppMethodBeat.m2504i(107763);
                    C5601o.this.mo11360a(fragmentActivity, false);
                    AppMethodBeat.m2505o(107763);
                    return true;
                }

                /* renamed from: ep */
                public final boolean mo1063ep() {
                    AppMethodBeat.m2504i(107764);
                    C5601o.this.mo11364b(fragmentActivity, false);
                    AppMethodBeat.m2505o(107764);
                    return true;
                }
            });
        } else {
            this.zHh = new C5599a() {
                public final void dJT() {
                    AppMethodBeat.m2504i(107765);
                    C5601o.this.mo11360a(fragmentActivity, true);
                    AppMethodBeat.m2505o(107765);
                }

                public final void collapseActionView() {
                    AppMethodBeat.m2504i(107766);
                    C5601o.this.mo11364b(fragmentActivity, true);
                    AppMethodBeat.m2505o(107766);
                }
            };
        }
        this.zGZ.setBackClickCallback(new C56058());
        AppMethodBeat.m2505o(107778);
    }

    /* renamed from: a */
    public void mo11358a(Activity activity, Menu menu) {
        AppMethodBeat.m2504i(107779);
        C4990ab.m7419v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.zGV), Boolean.valueOf(this.zGW), Boolean.valueOf(this.zGX));
        if (activity == null) {
            C4990ab.m7420w(this.TAG, "on hanle status fail, activity is null");
            AppMethodBeat.m2505o(107779);
            return;
        }
        this.mjk = menu.findItem(2131820645);
        if (this.mjk == null) {
            C4990ab.m7420w(this.TAG, "can not find search menu, error");
            AppMethodBeat.m2505o(107779);
            return;
        }
        this.mjk.setOnMenuItemClickListener(new C55989());
        m8393b(activity, menu);
        AppMethodBeat.m2505o(107779);
    }

    /* renamed from: b */
    private void m8393b(final Activity activity, Menu menu) {
        AppMethodBeat.m2504i(107780);
        if (this.zGX && (this.zGV || this.zGW)) {
            this.zGW = false;
            if (activity instanceof MMActivity) {
                ((MMActivity) activity).mo17446xE(C4996ah.getContext().getResources().getColor(C25738R.color.f12206vy));
            }
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != 2131820645) {
                        item.setVisible(false);
                    }
                }
            }
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(107769);
                    if (C5601o.this.mjk == null) {
                        C4990ab.m7420w(C5601o.this.TAG, "on post expand search menu, but item is null");
                        AppMethodBeat.m2505o(107769);
                        return;
                    }
                    C4990ab.m7417i(C5601o.this.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(C5601o.this.zGV));
                    if (C5601o.this.zGU) {
                        if (!C5601o.this.zGV) {
                            C0464g.m812b(C5601o.this.mjk);
                        }
                    } else if (C5601o.this.zHh != null) {
                        C5601o.this.zHh.dJT();
                    }
                    final View a = C0464g.m804a(C5601o.this.mjk);
                    if (a != null && C5601o.this.zGV) {
                        a.findViewById(2131820980).requestFocus();
                        if (C5601o.this.zGY) {
                            C5601o.this.fbD.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(107768);
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(2131820980), 0);
                                    AppMethodBeat.m2505o(107768);
                                }
                            }, 128);
                        }
                    }
                    AppMethodBeat.m2505o(107769);
                }
            }, 128);
        }
        AppMethodBeat.m2505o(107780);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(107781);
        C4990ab.m7419v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.zGV));
        if (4 == i && this.zGV) {
            dJS();
            AppMethodBeat.m2505o(107781);
            return true;
        }
        AppMethodBeat.m2505o(107781);
        return false;
    }

    /* renamed from: qQ */
    public final void mo11371qQ(boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(107782);
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.zGV);
        if (this.mjk == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        C4990ab.m7411d(str, str2, objArr);
        if (this.zGV) {
            AppMethodBeat.m2505o(107782);
        } else if (this.zGX) {
            this.zGY = z;
            if (this.mjk != null) {
                this.fbD.post(new C559211());
                AppMethodBeat.m2505o(107782);
                return;
            }
            this.zGW = true;
            AppMethodBeat.m2505o(107782);
        } else {
            C4990ab.m7420w(this.TAG, "can not expand now");
            AppMethodBeat.m2505o(107782);
        }
    }

    public final void dJS() {
        AppMethodBeat.m2504i(107783);
        C4990ab.m7410d(this.TAG, "do collapse");
        if (this.zGV && this.mjk != null) {
            if (this.zGU) {
                C0464g.m813c(this.mjk);
                AppMethodBeat.m2505o(107783);
                return;
            } else if (this.zHh != null) {
                this.zHh.collapseActionView();
            }
        }
        AppMethodBeat.m2505o(107783);
    }

    public final boolean dJs() {
        AppMethodBeat.m2504i(107784);
        if (this.zGZ != null) {
            boolean dJs = this.zGZ.dJs();
            AppMethodBeat.m2505o(107784);
            return dJs;
        }
        AppMethodBeat.m2505o(107784);
        return false;
    }

    public final boolean dJt() {
        AppMethodBeat.m2504i(107785);
        if (this.zGZ != null) {
            boolean dJt = this.zGZ.dJt();
            AppMethodBeat.m2505o(107785);
            return dJt;
        }
        AppMethodBeat.m2505o(107785);
        return false;
    }

    /* renamed from: a */
    public final void mo11360a(final FragmentActivity fragmentActivity, final boolean z) {
        AppMethodBeat.m2504i(107786);
        C4990ab.m7410d(this.TAG, "doNewExpand, searchViewExpand " + this.zGV);
        if (!this.zGV) {
            this.zGV = true;
            m8393b((Activity) fragmentActivity, null);
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(107771);
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        C4990ab.m7420w(C5601o.this.TAG, "want to expand search view, but activity status error");
                        AppMethodBeat.m2505o(107771);
                        return;
                    }
                    if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                    AppMethodBeat.m2505o(107771);
                }
            });
            if (this.zHa != null) {
                this.zHa.app();
            }
        }
        AppMethodBeat.m2505o(107786);
    }

    /* renamed from: b */
    public final void mo11364b(final FragmentActivity fragmentActivity, final boolean z) {
        AppMethodBeat.m2504i(107787);
        C4990ab.m7410d(this.TAG, "doNewCollapse, searchViewExpand " + this.zGV);
        if (this.zGV) {
            this.zGV = false;
            amI();
            if (this.zGZ != null) {
                this.zGZ.mo11323qO(false);
            }
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(107759);
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        C4990ab.m7420w(C5601o.this.TAG, "want to collapse search view, but activity status error");
                        AppMethodBeat.m2505o(107759);
                        return;
                    }
                    if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                    AppMethodBeat.m2505o(107759);
                }
            });
            if (this.zHa != null) {
                this.fbD.post(new C55953());
            }
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(107761);
                if (C5601o.this.mjk == null) {
                    C4990ab.m7420w(C5601o.this.TAG, "want to collapse search view, but search menu item is null");
                    AppMethodBeat.m2505o(107761);
                    return;
                }
                if (!(fragmentActivity == null || fragmentActivity.isFinishing())) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        View currentFocus = fragmentActivity.getCurrentFocus();
                        if (currentFocus != null) {
                            IBinder windowToken = currentFocus.getWindowToken();
                            if (windowToken != null) {
                                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                            }
                        }
                    }
                }
                View a = C0464g.m804a(C5601o.this.mjk);
                if (a != null) {
                    a.findViewById(2131820980).clearFocus();
                }
                AppMethodBeat.m2505o(107761);
            }
        });
        AppMethodBeat.m2505o(107787);
    }
}
