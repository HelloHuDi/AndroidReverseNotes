package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.C0464g;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.BaseActivity */
public abstract class BaseActivity extends AppCompatActivity {
    private int bsz = this.yeY;
    private TextView iUy;
    private TextView jao;
    private ImageView kiE;
    private ActionBar mActionBar;
    private Context mContext;
    private boolean qlP = false;
    private int theme;
    private View yeM;
    private View yeN;
    private int yeO = 0;
    private ImageButton yeP;
    private ImageButton yeQ;
    private TextView yeR;
    private MenuItem yeS;
    private MenuItem yeT;
    private int yeU;
    private int yeV;
    private C23528c yeW;
    private C23527a yeX = C23527a.BACK;
    private int yeY;
    private int yeZ;
    LinkedList<C30321b> yfa = new LinkedList();

    /* renamed from: com.tencent.mm.ui.BaseActivity$6 */
    class C51716 implements Runnable {
        C51716() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112450);
            BaseActivity.this.supportInvalidateOptionsMenu();
            AppMethodBeat.m2505o(112450);
        }
    }

    /* renamed from: com.tencent.mm.ui.BaseActivity$a */
    public enum C23527a {
        CUSTOM,
        BACK,
        CLOSE,
        NONE;

        static {
            AppMethodBeat.m2505o(112453);
        }
    }

    /* renamed from: com.tencent.mm.ui.BaseActivity$c */
    public enum C23528c {
        CUSTOM,
        TEXT,
        GREEN_TEXT,
        ADD,
        MORE,
        SEARCH,
        NONE;

        static {
            AppMethodBeat.m2505o(112456);
        }
    }

    /* renamed from: com.tencent.mm.ui.BaseActivity$b */
    public static final class C30321b {
        boolean aIB = true;
        boolean enable = true;
        OnMenuItemClickListener gzB;
        OnLongClickListener mlV;
        String text;
        int yfi = -1;
        int yfj;
        View yfk;
        View yfl;
        View yfm;
        C23528c yfn = C23528c.CUSTOM;
    }

    /* renamed from: com.tencent.mm.ui.BaseActivity$1 */
    class C406421 implements OnMenuItemClickListener {
        C406421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112445);
            BaseActivity.this.finish();
            AppMethodBeat.m2505o(112445);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", WebView.NIGHT_MODE_COLOR);
        switch (i) {
            case WebView.NIGHT_MODE_COLOR /*-16777216*/:
                this.theme = C25738R.style.f11310wa;
                break;
            case -16711936:
                this.theme = C25738R.style.f11311wb;
                break;
        }
        setTheme(i);
        setContentView(2130970010);
        this.mContext = this;
        this.mActionBar = getSupportActionBar();
        if (this.mActionBar != null) {
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.mo1339fc();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.mo1338fb();
            this.mActionBar.mo1340fd();
            this.mActionBar.setCustomView(LayoutInflater.from(this).inflate(2130968618, null));
            if (this.yeO == 0) {
                this.yeO = C5229aj.m7983hE(this.mContext);
            }
            this.qlP = C5225ah.m7958Nw(this.yeO);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yeO));
            this.jao = (TextView) findViewById(16908308);
            this.iUy = (TextView) findViewById(16908309);
            this.yeM = findViewById(2131820982);
            this.yeN = findViewById(2131820973);
            this.kiE = (ImageView) findViewById(2131820974);
            setBackBtn(new C406421());
        }
        this.yeY = C5229aj.m7981am(this.mContext, C25738R.dimen.f9778fd);
        this.yeZ = C5229aj.m7981am(this.mContext, C25738R.dimen.f10002n4);
        if (VERSION.SDK_INT >= 21) {
            if (this.yeO == 0) {
                this.yeO = C5229aj.m7983hE(this.mContext);
            }
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(this.yeO);
            if (VERSION.SDK_INT >= 23) {
                View decorView = getWindow().getDecorView();
                i = decorView.getSystemUiVisibility();
                if (this.qlP) {
                    i &= -8193;
                } else {
                    i |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                decorView.setSystemUiVisibility(i);
            }
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        m70200a(onMenuItemClickListener, C23527a.BACK);
    }

    /* renamed from: a */
    private void m70200a(final OnMenuItemClickListener onMenuItemClickListener, C23527a c23527a) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.yeN != null) {
                    this.yeN.setVisibility(0);
                    this.yeN.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(112446);
                            onMenuItemClickListener.onMenuItemClick(null);
                            AppMethodBeat.m2505o(112446);
                        }
                    });
                }
            }
            this.yeX = c23527a;
            if (this.yeX == C23527a.NONE) {
                this.yeU = 0;
            }
            if (this.yeX == C23527a.BACK) {
                this.yeU = C25738R.drawable.auq;
            } else if (this.yeX == C23527a.CLOSE) {
                this.yeU = C25738R.drawable.aus;
            }
            if (!(this.kiE == null || this.yeU == 0)) {
                dwm();
                this.kiE.setImageResource(this.yeU);
            }
            dwo();
        }
    }

    private void dwm() {
        if (this.kiE != null) {
            this.kiE.setVisibility(0);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (this.mActionBar != null && this.jao != null) {
            this.jao.setText(charSequence.toString());
            if (this.jao == null) {
                return;
            }
            if (this.qlP) {
                this.jao.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11705e5));
            } else {
                this.jao.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11704e4));
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        C5227ai.m7971d("BaseActivity", "on create option menu, menuCache size:%d", Integer.valueOf(this.yfa.size()));
        if (this.mActionBar == null || this.yfa.size() == 0) {
            C5227ai.m7975w("BaseActivity", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.yfa.size()));
            i = 0;
        } else {
            Iterator it = this.yfa.iterator();
            while (it.hasNext()) {
                final C30321b c30321b = (C30321b) it.next();
                if (c30321b.yfi != 16908332) {
                    if (c30321b.yfn == C23528c.SEARCH) {
                        this.yeS = menu.add(0, c30321b.yfi, 0, c30321b.text);
                        C360073 c360073 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(112447);
                                BaseActivity.m70201a(BaseActivity.this.yeS, c30321b);
                                AppMethodBeat.m2505o(112447);
                            }
                        };
                        if (c30321b.yfm == null) {
                            c30321b.yfm = View.inflate(this.mContext, 2130968611, null);
                        }
                        this.yeQ = (ImageButton) c30321b.yfm.findViewById(2131820960);
                        this.yeQ.setVisibility(0);
                        if (this.yeQ != null) {
                            if (this.qlP) {
                                this.yeQ.setImageResource(C25738R.drawable.av0);
                            } else {
                                this.yeQ.setImageResource(C25738R.drawable.auu);
                            }
                        }
                        this.yeQ.setOnClickListener(c360073);
                        this.yeQ.setEnabled(c30321b.enable);
                        C0464g.m803a(this.yeS, c30321b.yfm);
                        this.yeS.setEnabled(c30321b.enable);
                        this.yeS.setVisible(c30321b.aIB);
                    } else {
                        this.yeT = menu.add(0, c30321b.yfi, 0, c30321b.text);
                        C360084 c360084 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(112448);
                                BaseActivity.m70201a(BaseActivity.this.yeT, c30321b);
                                AppMethodBeat.m2505o(112448);
                            }
                        };
                        C51705 c51705 = new OnLongClickListener() {
                            public final boolean onLongClick(View view) {
                                AppMethodBeat.m2504i(112449);
                                boolean a = BaseActivity.m70202a(view, c30321b);
                                AppMethodBeat.m2505o(112449);
                                return a;
                            }
                        };
                        this.yeW = c30321b.yfn;
                        if (c30321b.yfn == C23528c.GREEN_TEXT || c30321b.yfn == C23528c.TEXT) {
                            if (c30321b.yfk == null) {
                                c30321b.yfk = View.inflate(this.mContext, 2130968611, null);
                            }
                            this.yeR = (TextView) c30321b.yfk.findViewById(2131820958);
                            this.yeR.setVisibility(0);
                            this.yeR.setText(c30321b.text);
                            if (c30321b.yfn == C23528c.GREEN_TEXT) {
                                this.yeR.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a74));
                            } else {
                                dwn();
                            }
                            this.yeR.setOnClickListener(c360084);
                            this.yeR.setOnLongClickListener(c51705);
                            this.yeR.setEnabled(c30321b.enable);
                            C0464g.m803a(this.yeT, c30321b.yfk);
                        } else {
                            if (c30321b.yfj != 0) {
                                this.yeV = c30321b.yfj;
                            }
                            if (c30321b.yfn == C23528c.NONE) {
                                this.yeV = 0;
                            }
                            if (c30321b.yfl == null) {
                                c30321b.yfl = View.inflate(this.mContext, 2130968611, null);
                            }
                            this.yeP = (ImageButton) c30321b.yfl.findViewById(2131820960);
                            dwn();
                            if (this.yeV != 0) {
                                this.yeP.setVisibility(0);
                                this.yeP.setOnClickListener(c360084);
                                this.yeP.setOnLongClickListener(c51705);
                                this.yeP.setEnabled(c30321b.enable);
                                C0464g.m803a(this.yeT, c30321b.yfl);
                            }
                        }
                        this.yeT.setEnabled(c30321b.enable);
                        this.yeT.setVisible(c30321b.aIB);
                        if (this.yeT != null) {
                            C0464g.m806a(this.yeT, 2);
                        }
                    }
                }
            }
            if (this.yeS != null) {
                C0464g.m806a(this.yeS, 2);
            }
            i = 1;
        }
        if (i != 0) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void dwn() {
        if (this.yeW != C23528c.TEXT) {
            if (this.yeW == C23528c.ADD) {
                this.yeV = C25738R.drawable.aup;
            } else if (this.yeW == C23528c.MORE) {
                this.yeV = C25738R.drawable.aut;
            } else if (this.yeW == C23528c.SEARCH) {
                this.yeV = C25738R.drawable.auu;
            }
            if (this.yeP != null && this.yeV != 0) {
                this.yeP.setImageResource(this.yeV);
                if (this.qlP) {
                    this.yeP.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                } else {
                    this.yeP.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                }
            }
        } else if (this.yeR != null) {
            if (this.qlP) {
                this.yeR.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
            } else {
                this.yeR.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a73));
            }
        }
    }

    private void dwo() {
        if (this.qlP) {
            this.kiE.setColorFilter(-1, Mode.SRC_ATOP);
        } else {
            this.kiE.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }
}
