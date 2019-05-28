package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.g;
import android.support.v4.widget.j;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedList;

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
    private c yeW;
    private a yeX = a.BACK;
    private int yeY;
    private int yeZ;
    LinkedList<b> yfa = new LinkedList();

    public enum a {
        CUSTOM,
        BACK,
        CLOSE,
        NONE;

        static {
            AppMethodBeat.o(112453);
        }
    }

    public enum c {
        CUSTOM,
        TEXT,
        GREEN_TEXT,
        ADD,
        MORE,
        SEARCH,
        NONE;

        static {
            AppMethodBeat.o(112456);
        }
    }

    public static final class b {
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
        c yfn = c.CUSTOM;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", WebView.NIGHT_MODE_COLOR);
        switch (i) {
            case WebView.NIGHT_MODE_COLOR /*-16777216*/:
                this.theme = R.style.wa;
                break;
            case -16711936:
                this.theme = R.style.wb;
                break;
        }
        setTheme(i);
        setContentView((int) R.layout.aay);
        this.mContext = this;
        this.mActionBar = getSupportActionBar();
        if (this.mActionBar != null) {
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.fc();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.fb();
            this.mActionBar.fd();
            this.mActionBar.setCustomView(LayoutInflater.from(this).inflate(R.layout.af, null));
            if (this.yeO == 0) {
                this.yeO = aj.hE(this.mContext);
            }
            this.qlP = ah.Nw(this.yeO);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yeO));
            this.jao = (TextView) findViewById(16908308);
            this.iUy = (TextView) findViewById(16908309);
            this.yeM = findViewById(R.id.l5);
            this.yeN = findViewById(R.id.kw);
            this.kiE = (ImageView) findViewById(R.id.kx);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(112445);
                    BaseActivity.this.finish();
                    AppMethodBeat.o(112445);
                    return true;
                }
            });
        }
        this.yeY = aj.am(this.mContext, R.dimen.fd);
        this.yeZ = aj.am(this.mContext, R.dimen.n4);
        if (VERSION.SDK_INT >= 21) {
            if (this.yeO == 0) {
                this.yeO = aj.hE(this.mContext);
            }
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(j.INVALID_ID);
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
        a(onMenuItemClickListener, a.BACK);
    }

    private void a(final OnMenuItemClickListener onMenuItemClickListener, a aVar) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.yeN != null) {
                    this.yeN.setVisibility(0);
                    this.yeN.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(112446);
                            onMenuItemClickListener.onMenuItemClick(null);
                            AppMethodBeat.o(112446);
                        }
                    });
                }
            }
            this.yeX = aVar;
            if (this.yeX == a.NONE) {
                this.yeU = 0;
            }
            if (this.yeX == a.BACK) {
                this.yeU = R.drawable.auq;
            } else if (this.yeX == a.CLOSE) {
                this.yeU = R.drawable.aus;
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
                this.jao.setTextColor(this.mContext.getResources().getColor(R.color.e5));
            } else {
                this.jao.setTextColor(this.mContext.getResources().getColor(R.color.e4));
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        ai.d("BaseActivity", "on create option menu, menuCache size:%d", Integer.valueOf(this.yfa.size()));
        if (this.mActionBar == null || this.yfa.size() == 0) {
            ai.w("BaseActivity", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.yfa.size()));
            i = 0;
        } else {
            Iterator it = this.yfa.iterator();
            while (it.hasNext()) {
                final b bVar = (b) it.next();
                if (bVar.yfi != 16908332) {
                    if (bVar.yfn == c.SEARCH) {
                        this.yeS = menu.add(0, bVar.yfi, 0, bVar.text);
                        AnonymousClass3 anonymousClass3 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(112447);
                                BaseActivity.a(BaseActivity.this.yeS, bVar);
                                AppMethodBeat.o(112447);
                            }
                        };
                        if (bVar.yfm == null) {
                            bVar.yfm = View.inflate(this.mContext, R.layout.a9, null);
                        }
                        this.yeQ = (ImageButton) bVar.yfm.findViewById(R.id.kj);
                        this.yeQ.setVisibility(0);
                        if (this.yeQ != null) {
                            if (this.qlP) {
                                this.yeQ.setImageResource(R.drawable.av0);
                            } else {
                                this.yeQ.setImageResource(R.drawable.auu);
                            }
                        }
                        this.yeQ.setOnClickListener(anonymousClass3);
                        this.yeQ.setEnabled(bVar.enable);
                        g.a(this.yeS, bVar.yfm);
                        this.yeS.setEnabled(bVar.enable);
                        this.yeS.setVisible(bVar.aIB);
                    } else {
                        this.yeT = menu.add(0, bVar.yfi, 0, bVar.text);
                        AnonymousClass4 anonymousClass4 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(112448);
                                BaseActivity.a(BaseActivity.this.yeT, bVar);
                                AppMethodBeat.o(112448);
                            }
                        };
                        AnonymousClass5 anonymousClass5 = new OnLongClickListener() {
                            public final boolean onLongClick(View view) {
                                AppMethodBeat.i(112449);
                                boolean a = BaseActivity.a(view, bVar);
                                AppMethodBeat.o(112449);
                                return a;
                            }
                        };
                        this.yeW = bVar.yfn;
                        if (bVar.yfn == c.GREEN_TEXT || bVar.yfn == c.TEXT) {
                            if (bVar.yfk == null) {
                                bVar.yfk = View.inflate(this.mContext, R.layout.a9, null);
                            }
                            this.yeR = (TextView) bVar.yfk.findViewById(R.id.kh);
                            this.yeR.setVisibility(0);
                            this.yeR.setText(bVar.text);
                            if (bVar.yfn == c.GREEN_TEXT) {
                                this.yeR.setTextColor(this.mContext.getResources().getColorStateList(R.color.a74));
                            } else {
                                dwn();
                            }
                            this.yeR.setOnClickListener(anonymousClass4);
                            this.yeR.setOnLongClickListener(anonymousClass5);
                            this.yeR.setEnabled(bVar.enable);
                            g.a(this.yeT, bVar.yfk);
                        } else {
                            if (bVar.yfj != 0) {
                                this.yeV = bVar.yfj;
                            }
                            if (bVar.yfn == c.NONE) {
                                this.yeV = 0;
                            }
                            if (bVar.yfl == null) {
                                bVar.yfl = View.inflate(this.mContext, R.layout.a9, null);
                            }
                            this.yeP = (ImageButton) bVar.yfl.findViewById(R.id.kj);
                            dwn();
                            if (this.yeV != 0) {
                                this.yeP.setVisibility(0);
                                this.yeP.setOnClickListener(anonymousClass4);
                                this.yeP.setOnLongClickListener(anonymousClass5);
                                this.yeP.setEnabled(bVar.enable);
                                g.a(this.yeT, bVar.yfl);
                            }
                        }
                        this.yeT.setEnabled(bVar.enable);
                        this.yeT.setVisible(bVar.aIB);
                        if (this.yeT != null) {
                            g.a(this.yeT, 2);
                        }
                    }
                }
            }
            if (this.yeS != null) {
                g.a(this.yeS, 2);
            }
            i = 1;
        }
        if (i != 0) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void dwn() {
        if (this.yeW != c.TEXT) {
            if (this.yeW == c.ADD) {
                this.yeV = R.drawable.aup;
            } else if (this.yeW == c.MORE) {
                this.yeV = R.drawable.aut;
            } else if (this.yeW == c.SEARCH) {
                this.yeV = R.drawable.auu;
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
                this.yeR.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
            } else {
                this.yeR.setTextColor(this.mContext.getResources().getColorStateList(R.color.a73));
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
