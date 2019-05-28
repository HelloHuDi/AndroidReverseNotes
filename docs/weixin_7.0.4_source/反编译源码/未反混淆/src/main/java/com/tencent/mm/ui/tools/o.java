package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.g;
import android.support.v4.view.g.d;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class o {
    final String TAG;
    ak fbD;
    MenuItem mjk;
    boolean zGU;
    public boolean zGV;
    private boolean zGW;
    private boolean zGX;
    boolean zGY;
    public d zGZ;
    public b zHa;
    private com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a zHb;
    private boolean zHc;
    private ArrayList<String> zHd;
    private boolean zHe;
    public int zHf;
    private int zHg;
    a zHh;

    public interface a {
        void collapseActionView();

        void dJT();
    }

    public interface b {
        void apo();

        void app();

        void apq();

        void apr();

        boolean vN(String str);

        void vO(String str);
    }

    public o() {
        AppMethodBeat.i(107772);
        this.zGU = false;
        this.zGV = false;
        this.zGW = false;
        this.zGX = true;
        this.zGY = true;
        this.mjk = null;
        this.fbD = new ak(Looper.getMainLooper());
        this.zGZ = null;
        this.zHc = true;
        this.zHf = R.string.pl;
        this.zHg = 0;
        this.zHc = true;
        this.zGU = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(107772);
    }

    public o(byte b) {
        AppMethodBeat.i(107773);
        this.zGU = false;
        this.zGV = false;
        this.zGW = false;
        this.zGX = true;
        this.zGY = true;
        this.mjk = null;
        this.fbD = new ak(Looper.getMainLooper());
        this.zGZ = null;
        this.zHc = true;
        this.zHf = R.string.pl;
        this.zHg = 0;
        this.zHc = true;
        this.zGU = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(107773);
    }

    public final String getSearchContent() {
        AppMethodBeat.i(107774);
        String searchContent;
        if (this.zGZ != null) {
            searchContent = this.zGZ.getSearchContent();
            AppMethodBeat.o(107774);
            return searchContent;
        }
        searchContent = "";
        AppMethodBeat.o(107774);
        return searchContent;
    }

    public void setSearchContent(String str) {
        AppMethodBeat.i(107775);
        if (this.zGZ == null) {
            AppMethodBeat.o(107775);
            return;
        }
        this.zGZ.setSearchContent(str);
        AppMethodBeat.o(107775);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.i(107776);
        if (this.zGZ == null) {
            AppMethodBeat.o(107776);
            return;
        }
        this.zGZ.setHint(charSequence);
        AppMethodBeat.o(107776);
    }

    public final void clearFocus() {
        AppMethodBeat.i(107777);
        if (this.zGZ != null) {
            this.zGZ.dJr();
        }
        AppMethodBeat.o(107777);
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

    public void a(final FragmentActivity fragmentActivity, Menu menu) {
        AppMethodBeat.i(107778);
        ab.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            ab.w(this.TAG, "on add search menu, activity is null");
            AppMethodBeat.o(107778);
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
        this.zGZ.setCallBack(new com.tencent.mm.ui.tools.ActionBarSearchView.b() {
            public final void bKu() {
                AppMethodBeat.i(107755);
                if (o.this.zGV) {
                    o.this.amH();
                    AppMethodBeat.o(107755);
                    return;
                }
                ab.v(o.this.TAG, "onVoiceSearchRequired, but not in searching");
                AppMethodBeat.o(107755);
            }

            public final void bKt() {
                AppMethodBeat.i(107756);
                if (o.this.zHa != null) {
                    o.this.zHa.apr();
                }
                AppMethodBeat.o(107756);
            }

            public final void Qa(String str) {
                AppMethodBeat.i(107757);
                if (o.this.zGV) {
                    if (o.this.zHa != null) {
                        o.this.zHa.vO(str);
                    }
                    AppMethodBeat.o(107757);
                    return;
                }
                ab.v(o.this.TAG, "onSearchTextChange %s, but not in searching", str);
                AppMethodBeat.o(107757);
            }

            public final void apq() {
                AppMethodBeat.i(107758);
                if (o.this.zHa != null) {
                    o.this.zHa.apq();
                }
                AppMethodBeat.o(107758);
            }
        });
        this.zGZ.qN(amG());
        this.zGZ.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(107762);
                if (3 != i || o.this.zHa == null) {
                    AppMethodBeat.o(107762);
                    return false;
                }
                boolean vN = o.this.zHa.vN(o.this.getSearchContent());
                AppMethodBeat.o(107762);
                return vN;
            }
        });
        if (this.zHg != 0) {
            this.zGZ.setSearchTipIcon(this.zHg);
        }
        this.mjk = menu.add(0, R.id.c1, 0, this.zHf);
        this.mjk.setEnabled(this.zGX);
        this.mjk.setIcon(R.raw.actionbar_icon_dark_search);
        g.a(this.mjk, (View) this.zGZ);
        if (this.zGU) {
            g.a(this.mjk, 9);
        } else {
            g.a(this.mjk, 2);
        }
        if (this.zGU) {
            g.a(this.mjk, new d() {
                public final boolean eo() {
                    AppMethodBeat.i(107763);
                    o.this.a(fragmentActivity, false);
                    AppMethodBeat.o(107763);
                    return true;
                }

                public final boolean ep() {
                    AppMethodBeat.i(107764);
                    o.this.b(fragmentActivity, false);
                    AppMethodBeat.o(107764);
                    return true;
                }
            });
        } else {
            this.zHh = new a() {
                public final void dJT() {
                    AppMethodBeat.i(107765);
                    o.this.a(fragmentActivity, true);
                    AppMethodBeat.o(107765);
                }

                public final void collapseActionView() {
                    AppMethodBeat.i(107766);
                    o.this.b(fragmentActivity, true);
                    AppMethodBeat.o(107766);
                }
            };
        }
        this.zGZ.setBackClickCallback(new com.tencent.mm.ui.tools.ActionBarSearchView.a() {
            public final void bKv() {
                AppMethodBeat.i(107767);
                if (o.this.zGU) {
                    if (o.this.mjk != null) {
                        g.c(o.this.mjk);
                        AppMethodBeat.o(107767);
                        return;
                    }
                } else if (o.this.zHh != null) {
                    o.this.zHh.collapseActionView();
                }
                AppMethodBeat.o(107767);
            }
        });
        AppMethodBeat.o(107778);
    }

    public void a(Activity activity, Menu menu) {
        AppMethodBeat.i(107779);
        ab.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.zGV), Boolean.valueOf(this.zGW), Boolean.valueOf(this.zGX));
        if (activity == null) {
            ab.w(this.TAG, "on hanle status fail, activity is null");
            AppMethodBeat.o(107779);
            return;
        }
        this.mjk = menu.findItem(R.id.c1);
        if (this.mjk == null) {
            ab.w(this.TAG, "can not find search menu, error");
            AppMethodBeat.o(107779);
            return;
        }
        this.mjk.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
        AppMethodBeat.o(107779);
    }

    private void b(final Activity activity, Menu menu) {
        AppMethodBeat.i(107780);
        if (this.zGX && (this.zGV || this.zGW)) {
            this.zGW = false;
            if (activity instanceof MMActivity) {
                ((MMActivity) activity).xE(ah.getContext().getResources().getColor(R.color.vy));
            }
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != R.id.c1) {
                        item.setVisible(false);
                    }
                }
            }
            this.fbD.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107769);
                    if (o.this.mjk == null) {
                        ab.w(o.this.TAG, "on post expand search menu, but item is null");
                        AppMethodBeat.o(107769);
                        return;
                    }
                    ab.i(o.this.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(o.this.zGV));
                    if (o.this.zGU) {
                        if (!o.this.zGV) {
                            g.b(o.this.mjk);
                        }
                    } else if (o.this.zHh != null) {
                        o.this.zHh.dJT();
                    }
                    final View a = g.a(o.this.mjk);
                    if (a != null && o.this.zGV) {
                        a.findViewById(R.id.l3).requestFocus();
                        if (o.this.zGY) {
                            o.this.fbD.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(107768);
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(R.id.l3), 0);
                                    AppMethodBeat.o(107768);
                                }
                            }, 128);
                        }
                    }
                    AppMethodBeat.o(107769);
                }
            }, 128);
        }
        AppMethodBeat.o(107780);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(107781);
        ab.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.zGV));
        if (4 == i && this.zGV) {
            dJS();
            AppMethodBeat.o(107781);
            return true;
        }
        AppMethodBeat.o(107781);
        return false;
    }

    public final void qQ(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(107782);
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.zGV);
        if (this.mjk == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        ab.d(str, str2, objArr);
        if (this.zGV) {
            AppMethodBeat.o(107782);
        } else if (this.zGX) {
            this.zGY = z;
            if (this.mjk != null) {
                this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(107770);
                        if (o.this.mjk == null) {
                            ab.w(o.this.TAG, "post do expand search menu, but search menu item is null");
                            AppMethodBeat.o(107770);
                        } else if (o.this.zGU) {
                            g.b(o.this.mjk);
                            AppMethodBeat.o(107770);
                        } else {
                            if (o.this.zHh != null) {
                                o.this.zHh.dJT();
                            }
                            AppMethodBeat.o(107770);
                        }
                    }
                });
                AppMethodBeat.o(107782);
                return;
            }
            this.zGW = true;
            AppMethodBeat.o(107782);
        } else {
            ab.w(this.TAG, "can not expand now");
            AppMethodBeat.o(107782);
        }
    }

    public final void dJS() {
        AppMethodBeat.i(107783);
        ab.d(this.TAG, "do collapse");
        if (this.zGV && this.mjk != null) {
            if (this.zGU) {
                g.c(this.mjk);
                AppMethodBeat.o(107783);
                return;
            } else if (this.zHh != null) {
                this.zHh.collapseActionView();
            }
        }
        AppMethodBeat.o(107783);
    }

    public final boolean dJs() {
        AppMethodBeat.i(107784);
        if (this.zGZ != null) {
            boolean dJs = this.zGZ.dJs();
            AppMethodBeat.o(107784);
            return dJs;
        }
        AppMethodBeat.o(107784);
        return false;
    }

    public final boolean dJt() {
        AppMethodBeat.i(107785);
        if (this.zGZ != null) {
            boolean dJt = this.zGZ.dJt();
            AppMethodBeat.o(107785);
            return dJt;
        }
        AppMethodBeat.o(107785);
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z) {
        AppMethodBeat.i(107786);
        ab.d(this.TAG, "doNewExpand, searchViewExpand " + this.zGV);
        if (!this.zGV) {
            this.zGV = true;
            b((Activity) fragmentActivity, null);
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107771);
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        ab.w(o.this.TAG, "want to expand search view, but activity status error");
                        AppMethodBeat.o(107771);
                        return;
                    }
                    if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                    AppMethodBeat.o(107771);
                }
            });
            if (this.zHa != null) {
                this.zHa.app();
            }
        }
        AppMethodBeat.o(107786);
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z) {
        AppMethodBeat.i(107787);
        ab.d(this.TAG, "doNewCollapse, searchViewExpand " + this.zGV);
        if (this.zGV) {
            this.zGV = false;
            amI();
            if (this.zGZ != null) {
                this.zGZ.qO(false);
            }
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107759);
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        ab.w(o.this.TAG, "want to collapse search view, but activity status error");
                        AppMethodBeat.o(107759);
                        return;
                    }
                    if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                    AppMethodBeat.o(107759);
                }
            });
            if (this.zHa != null) {
                this.fbD.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(107760);
                        if (o.this.zHa != null) {
                            o.this.zHa.apo();
                        }
                        AppMethodBeat.o(107760);
                    }
                });
            }
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(107761);
                if (o.this.mjk == null) {
                    ab.w(o.this.TAG, "want to collapse search view, but search menu item is null");
                    AppMethodBeat.o(107761);
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
                View a = g.a(o.this.mjk);
                if (a != null) {
                    a.findViewById(R.id.l3).clearFocus();
                }
                AppMethodBeat.o(107761);
            }
        });
        AppMethodBeat.o(107787);
    }
}
