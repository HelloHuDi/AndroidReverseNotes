package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.widget.j;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class q {
    private static WakeLock wakeLock = null;
    private static boolean ylO = false;
    public static final int ylZ = R.layout.ah;
    public static long ymb;
    private static byte[] ymd = new byte[]{(byte) 0};
    private int bsz = this.yeY;
    String className;
    public View contentView;
    private o elS;
    private LayoutInflater ezi;
    AudioManager fZh;
    TextView jcI;
    private Button lXZ;
    public ActionBar mActionBar;
    public Context mContext;
    private int mQh = 0;
    protected ak mty = new ak(Looper.getMainLooper());
    boolean qlP = false;
    private final long ryi = 300;
    private long ryj = SystemClock.elapsedRealtime();
    private View yeM;
    private int yeO = 0;
    public ImageButton yeP;
    TextView yeR;
    private int yeY;
    private int yeZ;
    LinkedList<a> yfa = new LinkedList();
    private String ylA = " ";
    private int ylB = 0;
    private int ylC = 0;
    private com.tencent.mm.ui.widget.a ylD = null;
    private com.tencent.mm.ui.widget.a ylE = null;
    private com.tencent.mm.ui.widget.a ylF = null;
    private com.tencent.mm.ui.widget.a ylG = null;
    private com.tencent.mm.ui.widget.a ylH = null;
    private boolean ylI = false;
    boolean ylJ = false;
    boolean ylK = false;
    public AppCompatActivity ylL;
    private boolean ylM;
    private a ylN = new a();
    private ArrayList<Dialog> ylP;
    public TextView ylQ;
    public View ylR;
    ImageView ylS;
    int ylT = 0;
    private ImageView ylU;
    private int ylV = 0;
    private boolean ylW = false;
    private c ylX = new c<tm>() {
        {
            AppMethodBeat.i(105994);
            this.xxI = tm.class.getName().hashCode();
            AppMethodBeat.o(105994);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(105995);
            com.tencent.mm.g.a.tm.a aVar = ((tm) bVar).cPH;
            if (aVar.cts == 2) {
                String str = aVar.ctu;
                int i = aVar.position;
                ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i), str);
                if (i <= 0 || i == q.this.ylV) {
                    q.this.a(aVar.ctt, aVar.aIB, aVar.url, aVar.desc, str, i, false);
                } else {
                    ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(q.this.ylV));
                }
            }
            AppMethodBeat.o(105995);
            return false;
        }
    };
    private int ylY = R.layout.af;
    protected boolean ylk = false;
    private View ylu;
    public View ylv;
    View ylw;
    private TextView ylx;
    FrameLayout yly;
    public boolean ylz = true;
    private int yma = -1;
    public int ymc = 0;
    private a yme;
    private MenuItem ymf;
    private Runnable ymg = new Runnable() {
        public final void run() {
            AppMethodBeat.i(105996);
            q.this.ylL.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (q.this.mActionBar != null) {
                q.this.mActionBar.hide();
            }
            AppMethodBeat.o(105996);
        }
    };
    private Runnable ymh = new Runnable() {
        public final void run() {
            AppMethodBeat.i(105997);
            if (q.this.mActionBar != null) {
                q.this.mActionBar.show();
            }
            AppMethodBeat.o(105997);
        }
    };

    /* renamed from: com.tencent.mm.ui.q$5 */
    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ Runnable ymk;
        final /* synthetic */ Runnable yml;

        AnonymousClass5(Runnable runnable, Runnable runnable2) {
            this.ymk = runnable;
            this.yml = runnable2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(105999);
            if (SystemClock.elapsedRealtime() - q.this.ryj < 300) {
                if (this.ymk != null) {
                    this.ymk.run();
                }
            } else if (this.yml != null) {
                this.yml.run();
            }
            q.this.ryj = SystemClock.elapsedRealtime();
            AppMethodBeat.o(105999);
        }
    }

    public static final class a {
        public boolean aIB = true;
        public boolean enable = true;
        public OnMenuItemClickListener gzB;
        public OnLongClickListener mlV;
        public String text;
        public int textColor;
        public int yfi = -1;
        public int yfj;
        public View yfk;
        public View yfl;
        public int ymp = 0;
        public Drawable ymq;
        public b ymr = b.NORMAL;
        public boolean yms = false;
    }

    public enum b {
        NORMAL,
        GREEN,
        RED,
        BLACK,
        TRANSPARENT,
        TRANSPARENT_RED_TEXT,
        TRANSPARENT_GREEN_TEXT,
        GOLDEN,
        TRANSPARENT_GOLD_TEXT,
        TRANSPARENT_GB_GREEN_TEXT,
        TRANSPARENT_BG_BLACK_TEXT,
        YELLOW;

        static {
            AppMethodBeat.o(106015);
        }
    }

    public abstract String bJj();

    public abstract void dealContentView(View view);

    public abstract boolean dxT();

    public abstract String getClassName();

    public abstract int getLayoutId();

    public abstract View getLayoutView();

    public abstract void onCreateBeforeSetContentView();

    public abstract void onKeyboardStateChanged();

    private void a(int i, final boolean z, final String str, final String str2, final String str3, final int i2, boolean z2) {
        ab.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i2), this.ylw);
        if (!needShowIdcError()) {
            return;
        }
        if (!z && this.ylw == null) {
            return;
        }
        if (this.mActionBar == null || this.mActionBar.isShowing()) {
            if (this.yly == null) {
                this.yly = (FrameLayout) this.contentView.findViewById(R.id.d88);
            }
            if (this.ylw != null) {
                this.yly.removeView(this.ylw);
            }
            if (i <= 0) {
                i = R.layout.agw;
            }
            this.ylw = this.ezi.inflate(i, null);
            this.ylx = (TextView) this.ylw.findViewById(R.id.b_t);
            this.ylw.findViewById(R.id.dbb).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(106004);
                    com.tencent.mm.g.a.ak akVar = new com.tencent.mm.g.a.ak();
                    akVar.cto.type = 1;
                    akVar.cto.ctq = str3;
                    akVar.cto.position = i2;
                    com.tencent.mm.sdk.b.a.xxA.m(akVar);
                    q.this.ylw.setVisibility(8);
                    AppMethodBeat.o(106004);
                }
            });
            this.ylw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(106005);
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        q.this.mContext.startActivity(intent);
                    }
                    AppMethodBeat.o(106005);
                }
            });
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            if (this.ylW && VERSION.SDK_INT >= 16) {
                layoutParams.setMargins(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.ylL, 48.0f), 0, 0);
                ab.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
            }
            this.yly.addView(this.ylw, this.yly.getChildCount(), layoutParams);
            if (this.ylw == null) {
                return;
            }
            if (z2) {
                this.ylw.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(R.string.cdc);
                if (bo.isNullOrNil(str2)) {
                    str2 = this.mContext.getString(R.string.b6_);
                }
                if (str != null) {
                    SpannableString spannableString = new SpannableString(str2 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str2.length(), string.length() + str2.length(), 33);
                    this.ylx.setText(spannableString);
                } else {
                    ab.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                    this.ylx.setText(str2);
                }
                this.ylw.invalidate();
                this.yly.invalidate();
                return;
            }
            this.ylw.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106006);
                    q.this.ylw.setVisibility(z ? 0 : 8);
                    String string = q.this.mContext.getString(R.string.cdc);
                    String string2 = bo.isNullOrNil(str2) ? q.this.mContext.getString(R.string.b6_) : str2;
                    if (str != null) {
                        SpannableString spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        q.this.ylx.setText(spannableString);
                    } else {
                        ab.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                        q.this.ylx.setText(string2);
                    }
                    q.this.ylw.invalidate();
                    q.this.yly.invalidate();
                    AppMethodBeat.o(106006);
                }
            });
            return;
        }
        ab.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
    }

    private View findViewById(int i) {
        View findViewById = this.contentView.findViewById(i);
        return findViewById != null ? findViewById : this.ylL.findViewById(i);
    }

    public final void setBackGroundColorResource(int i) {
        if (this.contentView != null) {
            if (this.yly == null) {
                this.yly = (FrameLayout) this.contentView.findViewById(R.id.d88);
            }
            this.yly.setBackgroundResource(i);
            this.ylv.setBackgroundResource(i);
        }
    }

    public final void aC(int i, boolean z) {
        this.ylV = i;
        this.ylW = z;
    }

    public static Locale initLanguage(Context context) {
        return bM(context, aa.g(context.getSharedPreferences(ah.doA(), 0)));
    }

    public static Locale bM(Context context, String str) {
        if (str.equals("language_default")) {
            aa.a(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale amw = aa.amw(str);
        aa.a(context, amw);
        return amw;
    }

    public ActionBar getSupportActionBar() {
        return this.ylL.getSupportActionBar();
    }

    public final void a(Context context, AppCompatActivity appCompatActivity) {
        this.mContext = appCompatActivity;
        this.ylL = appCompatActivity;
        if (VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = this.ylL.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.ylL.getWindow().setAttributes(attributes);
        }
        boolean z = ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
        ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).getBoolean("dark_actionbar", false);
        if (!z) {
            ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
            ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
        }
        onCreateBeforeSetContentView();
        this.className = getClass().getName();
        ac.bL(3, this.className);
        initLanguage(context);
        this.fZh = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int layoutId = getLayoutId();
        this.ezi = LayoutInflater.from(this.mContext);
        this.contentView = com.tencent.mm.kiss.a.b.SM().a((Activity) appCompatActivity, "R.layout.mm_activity", (int) R.layout.ad1);
        this.ylu = this.contentView.findViewById(R.id.d89);
        this.yly = (FrameLayout) this.contentView.findViewById(R.id.d88);
        this.mQh = this.mContext.getResources().getDimensionPixelSize(R.dimen.n7);
        if (layoutId != -1) {
            this.ylv = getLayoutView();
            if (this.ylv == null) {
                this.ylv = this.ezi.inflate(getLayoutId(), null);
            } else if (this.ylv.getParent() != null) {
                ((ViewGroup) this.ylv.getParent()).removeView(this.ylv);
            }
            this.yly.addView(this.ylv, 0);
        }
        dealContentView(this.contentView);
        if (dxT()) {
            int dimensionPixelSize;
            ae.h(ae.a(this.ylL.getWindow(), this.ylv), this.ylv);
            ((ViewGroup) this.ylv.getParent()).removeView(this.ylv);
            ((ViewGroup) this.ylL.getWindow().getDecorView()).addView(this.ylv, 0);
            layoutId = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.fc);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.fd);
            }
            this.ylv.setPadding(this.ylv.getPaddingLeft(), dimensionPixelSize + (layoutId + this.ylv.getPaddingTop()), this.ylv.getPaddingRight(), this.ylv.getPaddingBottom());
        }
        this.mActionBar = getSupportActionBar();
        ab.d("MicroMsg.MMActivityController", "onCreate, before.");
        ap(appCompatActivity);
        this.yeY = aj.am(this.mContext, R.dimen.fd);
        this.yeZ = aj.am(this.mContext, R.dimen.n4);
        if (this.yly == null || !(this.yly instanceof LayoutListenerView)) {
            ab.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.yly).setOnResizedListener(new LayoutListenerView.c() {
                private final int ymn = com.tencent.mm.bz.a.fromDPToPix(q.this.mContext, 100);

                {
                    AppMethodBeat.i(106007);
                    AppMethodBeat.o(106007);
                }

                public final void onSizeChanged(int i, int i2, int i3, int i4) {
                    AppMethodBeat.i(106008);
                    if (q.f(q.this)) {
                        AppMethodBeat.o(106008);
                        return;
                    }
                    if (!(i == 0 || i2 == 0 || i3 == 0 || i4 == 0 || i != i3)) {
                        if (i2 > i4 && i2 - i4 > this.ymn) {
                            q.g(q.this);
                            AppMethodBeat.o(106008);
                            return;
                        } else if (i4 > i2 && i4 - i2 > this.ymn) {
                            q.h(q.this);
                        }
                    }
                    AppMethodBeat.o(106008);
                }
            });
        }
        com.tencent.mm.g.a.ak akVar = new com.tencent.mm.g.a.ak();
        akVar.cto.type = 2;
        akVar.cto.position = this.ylV;
        com.tencent.mm.sdk.b.a.xxA.m(akVar);
        if (akVar.ctp.cts == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = akVar.ctp.ctu;
            int i = akVar.ctp.position;
            ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i), str, bo.dpG());
            if (i <= 0 || i == this.ylV) {
                a(akVar.ctp.ctt, akVar.ctp.aIB, akVar.ctp.url, akVar.ctp.desc, str, i, true);
            } else {
                ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.ylV));
            }
            ab.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (VERSION.SDK_INT >= 21) {
            if (this.yeO == 0) {
                this.yeO = dyj();
            }
            Window window = appCompatActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(j.INVALID_ID);
            l(appCompatActivity, this.yeO);
            dyo();
        }
    }

    public boolean noActionBar() {
        return false;
    }

    public final int dyj() {
        this.qlP = false;
        if (this.yeO == 0) {
            this.yeO = this.mContext.getResources().getColor(R.color.vy);
        }
        return this.yeO;
    }

    public final void ap(Activity activity) {
        if (this.mActionBar != null && !noActionBar()) {
            ab.d("MicroMsg.MMActivityController", "onCreate, after");
            if (this.yeO == 0) {
                this.yeO = dyj();
            }
            this.qlP = ah.Nw(this.yeO);
            xE(this.yeO);
            this.mActionBar.setLogo(new ColorDrawable(this.ylL.getResources().getColor(17170445)));
            this.mActionBar.fc();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.fb();
            this.mActionBar.fd();
            this.mActionBar.fa();
            if (this.yma == -1) {
                this.mActionBar.setCustomView(v.hu(this.ylL).inflate(this.ylY, new LinearLayout(this.ylL), false));
            } else {
                this.mActionBar.setCustomView(v.hu(this.ylL).inflate(this.yma, new LinearLayout(this.ylL), false));
            }
            this.ylQ = (TextView) findViewById(16908308);
            this.jcI = (TextView) findViewById(16908309);
            this.yeM = findViewById(R.id.l5);
            this.ylR = findViewById(R.id.kw);
            this.ylS = (ImageView) findViewById(R.id.kx);
            this.ylR.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(106009);
                    if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                        q.ymb = System.currentTimeMillis();
                    }
                    AppMethodBeat.o(106009);
                    return false;
                }
            });
            if (this.ylS != null) {
                this.ylS.setContentDescription(this.ylL.getString(R.string.g1));
            }
            if (this.ylQ != null) {
                this.ylQ.setText(R.string.ru);
            }
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.ylS != null) {
                    this.ylS.setVisibility(0);
                }
                if (this.ylR != null) {
                    this.ylR.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.ylS != null) {
                    this.ylS.setVisibility(0);
                }
                if (this.ylR != null) {
                    this.ylR.setVisibility(0);
                }
                if (this.ylQ != null) {
                    this.ylQ.setVisibility(0);
                }
            } else {
                if (this.ylS != null) {
                    this.ylS.setVisibility(8);
                }
                if (this.ylR != null) {
                    this.ylR.setVisibility(8);
                }
            }
            dyn();
        }
    }

    public final void setScreenEnable(boolean z) {
        boolean z2 = true;
        this.ylz = z;
        if (this.ylu == null && this.contentView != null) {
            this.ylu = this.contentView.findViewById(R.id.d89);
        }
        if (this.ylu == null) {
            ab.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
            return;
        }
        this.ylu.setFocusable(!z);
        View view = this.ylu;
        if (z) {
            z2 = false;
        }
        view.setFocusableInTouchMode(z2);
        if (z) {
            releaseWakeLock();
        } else {
            hp(this.ylL);
        }
    }

    private void hp(Context context) {
        synchronized (ymd) {
            if (wakeLock == null) {
                wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(32, "screen Lock");
            }
            if (wakeLock.isHeld()) {
                ab.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.acquire();
                ab.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
            }
        }
    }

    private void releaseWakeLock() {
        synchronized (ymd) {
            if (wakeLock == null || !wakeLock.isHeld()) {
                ab.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.release();
                ab.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
                wakeLock = null;
            }
        }
    }

    public static boolean dyk() {
        boolean isHeld;
        synchronized (ymd) {
            isHeld = wakeLock != null ? wakeLock.isHeld() : false;
        }
        return isHeld;
    }

    public final void onStart() {
        this.ylk = this.mContext.getSharedPreferences(ah.doA(), 0).getBoolean("settings_landscape_mode", false);
        if (this.ylk) {
            this.ylL.setRequestedOrientation(-1);
        } else {
            this.ylL.setRequestedOrientation(1);
        }
    }

    public final boolean getLandscapeMode() {
        return this.ylk;
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.yme == null || !this.yme.enable) {
            return true;
        }
        a(this.ymf, this.yme);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        g.KO();
        g.KO();
        if (!this.ylM || this.elS == null || !this.elS.onKeyDown(i, keyEvent)) {
            return false;
        }
        ab.d("MicroMsg.MMActivityController", "match search view on key down");
        if (this.qlP) {
            xE(this.ylL.getResources().getColor(R.color.l8));
        } else {
            xE(this.ylL.getResources().getColor(R.color.vy));
        }
        return true;
    }

    public boolean needShowIdcError() {
        return true;
    }

    public final void onResume() {
        activateBroadcast(true);
        com.tencent.mm.sdk.b.a.xxA.c(this.ylX);
        com.tencent.mm.g.a.ak akVar = new com.tencent.mm.g.a.ak();
        akVar.cto.type = 2;
        akVar.cto.position = this.ylV;
        com.tencent.mm.sdk.b.a.xxA.m(akVar);
        if (akVar.ctp.cts == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = akVar.ctp.ctu;
            int i = akVar.ctp.position;
            ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i), str);
            if (i <= 0 || i == this.ylV) {
                a(akVar.ctp.ctt, akVar.ctp.aIB, akVar.ctp.url, akVar.ctp.desc, str, i, true);
            } else {
                ab.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.ylV));
            }
            ab.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!com.tencent.mm.kernel.g.RK() || !com.tencent.mm.kernel.g.RN().eJb || ah.getContext().getSharedPreferences(ah.doA() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)) {
            return;
        }
        if (1.0f != com.tencent.mm.bz.a.dm(ah.getContext())) {
            ah.getContext().getSharedPreferences(ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        } else if (1.0f != ah.getContext().getResources().getConfiguration().fontScale) {
            h.pYm.e(15181, Integer.valueOf(1));
            com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(ah.getContext());
            com.tencent.mm.ui.widget.a.e.a asL = aVar.al(this.ylL.getResources().getString(R.string.bz9)).asL(this.ylL.getResources().getString(R.string.bz6));
            asL.zQJ = this.ylL.getResources().getString(R.string.bz8);
            asL.zQK = this.ylL.getResources().getString(R.string.bz7);
            aVar.c(new e.c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(106010);
                    if (z) {
                        h.pYm.e(15181, Integer.valueOf(3));
                        Intent intent = new Intent();
                        intent.setClassName(ah.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                        intent.addFlags(268435456);
                        ah.getContext().startActivity(intent);
                        AppMethodBeat.o(106010);
                        return;
                    }
                    h.pYm.e(15181, Integer.valueOf(2));
                    AppMethodBeat.o(106010);
                }
            }).show();
            ah.getContext().getSharedPreferences(ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        }
    }

    public final void addDialog(Dialog dialog) {
        if (dialog != null) {
            if (this.ylP == null) {
                this.ylP = new ArrayList();
            }
            this.ylP.add(dialog);
        }
    }

    public final void hq(Context context) {
        com.tencent.mm.sdk.b.a.xxA.d(this.ylX);
        if (this.ylP != null) {
            int size = this.ylP.size();
            for (int i = 0; i < size; i++) {
                Dialog dialog = (Dialog) this.ylP.get(i);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.ylP.clear();
            this.ylP = null;
        }
        eY(context);
    }

    public final void activateBroadcast(boolean z) {
        if (ylO || !z) {
            y.d(z, new Intent().putExtra("classname", getClassName() + bJj()));
        } else {
            y.d(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void dxV() {
        ylO = true;
    }

    public final void onPause() {
        activateBroadcast(false);
        com.tencent.mm.sdk.b.a.xxA.d(this.ylX);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        ab.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.yfa.size()));
        if (this.mActionBar == null || this.yfa.size() == 0) {
            ab.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.yfa.size()));
            return false;
        }
        this.yme = null;
        this.ymf = null;
        if (this.mActionBar.getHeight() == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.mContext.getResources().getDimensionPixelSize(R.dimen.fc);
            } else {
                this.mContext.getResources().getDimensionPixelSize(R.dimen.fd);
            }
        }
        Iterator it = this.yfa.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            if (aVar.yfi == 16908332) {
                ab.v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (aVar.yfi == R.id.c1) {
                boolean z;
                String str = "MicroMsg.MMActivityController";
                String str2 = "match search menu, enable search view[%B], search view helper is null[%B]";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.ylM);
                if (this.elS == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                ab.v(str, str2, objArr);
                if (this.ylM && this.elS != null) {
                    this.elS.a(this.ylL, menu);
                }
            } else {
                final MenuItem add = menu.add(0, aVar.yfi, 0, aVar.text);
                com.tencent.mm.compatible.i.a.a(add, getClass().getName());
                AnonymousClass15 anonymousClass15 = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(106011);
                        q.this.a(add, aVar);
                        AppMethodBeat.o(106011);
                    }
                };
                AnonymousClass16 anonymousClass16 = new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(106012);
                        boolean a = q.a(q.this, view, aVar);
                        AppMethodBeat.o(106012);
                        return a;
                    }
                };
                if (aVar.yfj == 0 && aVar.ymq == null) {
                    if (aVar.yfk == null) {
                        aVar.yfk = View.inflate(this.mContext, R.layout.a9, null);
                    }
                    this.yeR = (TextView) aVar.yfk.findViewById(R.id.kh);
                    this.yeR.setVisibility(0);
                    this.lXZ = (Button) aVar.yfk.findViewById(R.id.ki);
                    this.lXZ.setVisibility(8);
                    if (aVar.ymr == b.RED || aVar.ymr == b.TRANSPARENT_RED_TEXT) {
                        this.yeR.setTextColor(com.tencent.mm.bz.a.h(this.ylL, (int) R.color.a89));
                        this.lXZ.setVisibility(0);
                        this.lXZ.setBackgroundResource(R.drawable.ft);
                        this.yeR.setVisibility(8);
                    } else if (aVar.ymr == b.GREEN || aVar.ymr == b.TRANSPARENT_GREEN_TEXT) {
                        this.lXZ.setVisibility(0);
                        this.lXZ.setBackgroundResource(R.drawable.fq);
                        this.yeR.setVisibility(8);
                    } else {
                        if (aVar.ymr != b.BLACK) {
                            if (aVar.ymr == b.TRANSPARENT_GOLD_TEXT) {
                                this.yeR.setTextColor(this.ylL.getResources().getColor(R.color.u2));
                            } else if (aVar.ymr == b.GOLDEN) {
                                this.yeR.setTextColor(-2601405);
                            } else if (aVar.ymr == b.YELLOW) {
                                this.lXZ.setVisibility(0);
                                this.lXZ.setBackgroundResource(R.drawable.fv);
                                this.yeR.setVisibility(8);
                            } else if (this.ylT != 0) {
                                this.yeR.setTextColor(this.ylT);
                            } else if (this.qlP) {
                                this.yeR.setTextColor(com.tencent.mm.bz.a.h(this.ylL, (int) R.color.a8m));
                            }
                        }
                        this.yeR.setTextColor(com.tencent.mm.bz.a.h(this.ylL, (int) R.color.a73));
                    }
                    this.yeR.setText(aVar.text);
                    if (aVar.textColor != 0) {
                        this.yeR.setTextColor(aVar.textColor);
                    }
                    this.yeR.setOnClickListener(anonymousClass15);
                    this.yeR.setOnLongClickListener(anonymousClass16);
                    this.yeR.setEnabled(aVar.enable);
                    this.lXZ.setText(aVar.text);
                    this.lXZ.setOnClickListener(anonymousClass15);
                    this.lXZ.setOnLongClickListener(anonymousClass16);
                    this.lXZ.setEnabled(aVar.enable);
                    android.support.v4.view.g.a(add, aVar.yfk);
                } else {
                    if (aVar.yfl == null) {
                        aVar.yfl = View.inflate(this.mContext, R.layout.a9, null);
                    }
                    ImageView imageView = (ImageView) aVar.yfl.findViewById(R.id.p3);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.yeP = (ImageButton) aVar.yfl.findViewById(R.id.kj);
                    this.yeP.setVisibility(0);
                    if (aVar.ymq != null) {
                        this.yeP.setImageDrawable(aVar.ymq);
                    } else {
                        this.yeP.setImageResource(aVar.yfj);
                    }
                    if (this.ylT != 0) {
                        this.yeP.getDrawable().setColorFilter(this.ylT, Mode.SRC_ATOP);
                    } else if (aVar.ymp == 0) {
                        if (this.qlP) {
                            this.yeP.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                        } else {
                            this.yeP.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                        }
                    }
                    this.yeP.setOnClickListener(anonymousClass15);
                    this.yeP.setEnabled(aVar.enable);
                    this.yeP.setContentDescription(aVar.text);
                    if (aVar.mlV != null) {
                        this.yeP.setOnLongClickListener(anonymousClass16);
                    }
                    this.ylU = (ImageView) aVar.yfl.findViewById(R.id.kk);
                    if (this.ylU != null) {
                        if (aVar.yms) {
                            this.ylU.setVisibility(0);
                        } else {
                            this.ylU.setVisibility(8);
                        }
                    }
                    android.support.v4.view.g.a(add, aVar.yfl);
                }
                add.setEnabled(aVar.enable);
                add.setVisible(aVar.aIB);
                android.support.v4.view.g.a(add, 2);
                if (aVar.yfj == R.drawable.uu) {
                    this.yme = aVar;
                    this.ymf = add;
                }
                ab.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(aVar.yfi), aVar.text, Boolean.valueOf(aVar.enable), Boolean.valueOf(aVar.aIB));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        ab.d("MicroMsg.MMActivityController", "on prepare option menu");
        if (this.ylM && this.elS != null) {
            this.elS.a(this.ylL, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        ab.v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.ylz) {
            ab.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.ylN.yfi && this.ylN.enable) {
            a(menuItem, this.ylN);
            return true;
        } else {
            Iterator it = this.yfa.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (menuItem.getItemId() == aVar.yfi) {
                    ab.d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, aVar);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean callBackMenu() {
        if (this.ylN == null || !this.ylN.enable) {
            return false;
        }
        a(null, this.ylN);
        return true;
    }

    private void a(MenuItem menuItem, a aVar) {
        if (!this.ylz) {
            ab.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (aVar.gzB != null) {
            aVar.gzB.onMenuItemClick(menuItem);
        }
    }

    public final void fullScreenNoTitleBar(boolean z) {
        if (z) {
            if (this.mActionBar != null) {
                this.mActionBar.hide();
            }
            this.mty.removeCallbacks(this.ymh);
            this.mty.removeCallbacks(this.ymg);
            this.mty.postDelayed(this.ymg, 256);
            return;
        }
        this.ylL.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mty.removeCallbacks(this.ymg);
        this.mty.removeCallbacks(this.ymh);
        this.mty.postDelayed(this.ymh, 256);
    }

    public final void dyl() {
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
        this.mty.removeCallbacks(this.ymh);
        this.mty.removeCallbacks(this.ymg);
        this.mty.postDelayed(this.ymg, 0);
    }

    public final void setTitleVisibility(int i) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.mActionBar.show();
                l(this.ylL, this.yeO);
                return;
            }
            this.mActionBar.hide();
            l(this.ylL, this.ylL.getResources().getColor(R.color.h4));
        }
    }

    public final void setMMTitle(String str) {
        if (this.mActionBar != null) {
            this.ylA = str;
            if (com.tencent.mm.bz.a.ga(this.ylL)) {
                this.ylQ.setTextSize(0, ((float) com.tencent.mm.bz.a.am(this.ylL, R.dimen.dk)) * com.tencent.mm.bz.a.fY(this.ylL));
            }
            dym();
            updateDescription(str);
        }
    }

    public final void M(CharSequence charSequence) {
        if (this.mActionBar != null) {
            this.ylA = charSequence.toString();
            this.ylQ.setText(charSequence);
            if (com.tencent.mm.bz.a.ga(this.ylL)) {
                this.ylQ.setTextSize(0, ((float) com.tencent.mm.bz.a.am(this.ylL, R.dimen.dk)) * com.tencent.mm.bz.a.fY(this.ylL));
            }
            updateDescription(charSequence.toString());
        }
    }

    public final void setMMTitle(int i) {
        setMMTitle(this.mContext.getString(i));
    }

    public final void bn(float f) {
        if (this.mActionBar != null && this.ylQ != null) {
            this.ylQ.setTextSize(0, f);
        }
    }

    public final void setMMSubTitle(String str) {
        if (this.mActionBar != null) {
            if (str == null) {
                this.jcI.setVisibility(8);
                return;
            }
            this.jcI.setText(str);
            if (com.tencent.mm.bz.a.ga(this.ylL)) {
                this.jcI.setTextSize(1, 14.0f);
                this.ylQ.setTextSize(1, 18.0f);
            }
            this.jcI.setVisibility(0);
            updateDescription(str);
        }
    }

    public final void setMMSubTitle(int i) {
        if (this.mActionBar != null) {
            this.jcI.setText(this.mContext.getString(i));
            if (com.tencent.mm.bz.a.ga(this.ylL)) {
                this.jcI.setTextSize(1, 14.0f);
                this.ylQ.setTextSize(1, 18.0f);
            }
            this.jcI.setVisibility(0);
            updateDescription(this.mContext.getString(i));
        }
    }

    public final void setTitleLogo(int i, int i2) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.ylB = 0;
                this.ylD = null;
            } else if (this.ylB != i) {
                this.ylB = i;
                this.ylD = hb(this.mContext.getResources().getDimensionPixelSize(R.dimen.dt), this.ylB);
            }
            if (i2 == 0) {
                this.ylC = 0;
                this.ylE = null;
            } else if (this.ylC != i2) {
                this.ylC = i2;
                this.ylE = hb(this.mContext.getResources().getDimensionPixelSize(R.dimen.dt), this.ylC);
            }
            dym();
        }
    }

    private com.tencent.mm.ui.widget.a hb(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        if (this.qlP) {
            drawable = ah.f(this.ylL, i2, -1);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        aVar.zLT = (drawable.getIntrinsicHeight() - i) / 2;
        return aVar;
    }

    /* Access modifiers changed, original: final */
    public final void dym() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.dk);
        if (this.ylB != 0) {
            str = "# ".concat(String.valueOf(str));
        }
        if (this.ylC != 0) {
            str = str + " #";
            i = 1;
        } else {
            i = 0;
        }
        if (this.ylJ || !this.ylI) {
            i2 = 0;
        } else {
            str = str + " #";
            i += 2;
            i2 = 1;
        }
        if (this.ylJ) {
            str = str + " #";
            i += 2;
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.ylK) {
            str = str + " #";
            i2 += 2;
            i4 = 1;
            i5 = i + 2;
        } else {
            i4 = 0;
            i5 = i;
        }
        String format = String.format(str, new Object[]{this.ylA});
        ab.v("MicroMsg.MMActivityController", "span title format %s", str);
        CharSequence h = com.tencent.mm.ui.e.c.b.h(this.mContext, format, dimensionPixelSize);
        if (h instanceof SpannableString) {
            int length;
            SpannableString spannableString = (SpannableString) h;
            if (this.ylB != 0) {
                spannableString.setSpan(this.ylD, 0, 1, 33);
            }
            if (this.ylC != 0) {
                length = spannableString.length() - i5;
                spannableString.setSpan(this.ylE, length, length + 1, 33);
            }
            if (this.ylJ) {
                if (this.ylG == null) {
                    this.ylG = hb(dimensionPixelSize, R.raw.chat_force_notify_icon);
                }
                length = spannableString.length() - i3;
                spannableString.setSpan(this.ylG, length, length + 1, 33);
            }
            if (!this.ylJ && this.ylI) {
                if (this.ylF == null) {
                    this.ylF = hb(dimensionPixelSize, R.raw.chat_mute_notify_title_icon);
                }
                length = spannableString.length() - i2;
                spannableString.setSpan(this.ylF, length, length + 1, 33);
            }
            if (this.ylK) {
                if (this.ylH == null) {
                    this.ylH = hb(dimensionPixelSize, R.raw.chat_phone_notify_title_icon);
                }
                length = spannableString.length() - i4;
                spannableString.setSpan(this.ylH, length, length + 1, 33);
            }
        }
        this.ylQ.setText(h);
    }

    public final void showHomeBtn(boolean z) {
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayHomeAsUpEnabled(z);
            if (this.ylR != null) {
                this.ylR.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        this.ylL.supportInvalidateOptionsMenu();
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        return false;
    }

    public final void enableBackMenu(boolean z) {
        if (this.ylN != null && this.ylN.enable != z) {
            this.ylN.enable = z;
            supportInvalidateOptionsMenu();
        }
    }

    /* Access modifiers changed, original: final */
    public final void d(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.yfa.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.enable != z2) {
                    aVar.enable = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.yfa.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.yfi != i || aVar.enable == z2) {
                    z4 = z3;
                } else {
                    aVar.enable = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (this.elS == null) {
            z4 = false;
        } else {
            z4 = this.elS.zGV;
        }
        if (!z4) {
            supportInvalidateOptionsMenu();
        }
        ab.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    /* Access modifiers changed, original: final */
    public final void e(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.yfa.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.aIB != z2) {
                    aVar.aIB = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.yfa.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.yfi != i || aVar.aIB == z2) {
                    z4 = z3;
                } else {
                    aVar.aIB = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (this.elS == null) {
            z4 = false;
        } else {
            z4 = this.elS.zGV;
        }
        if (z3 && !z4) {
            supportInvalidateOptionsMenu();
        }
        ab.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void addSearchMenu(boolean z, o oVar) {
        ab.v("MicroMsg.MMActivityController", "add search menu");
        a aVar = new a();
        aVar.yfi = R.id.c1;
        aVar.text = this.mContext.getString(R.string.te);
        aVar.yfj = R.raw.actionbar_icon_dark_search;
        aVar.gzB = null;
        aVar.mlV = null;
        removeOptionMenu(aVar.yfi);
        this.yfa.add(0, aVar);
        this.ylM = z;
        this.elS = oVar;
        supportInvalidateOptionsMenu();
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, 0, str, false, onMenuItemClickListener, null, b.NORMAL);
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, b bVar) {
        a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, bVar);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, "", false, onMenuItemClickListener, null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, str, false, onMenuItemClickListener, null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, boolean z, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), z, onMenuItemClickListener, null, b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a(i, i2, "", false, onMenuItemClickListener, onLongClickListener, b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, onLongClickListener, b.NORMAL);
    }

    public final void updateOptionMenuIcon(int i, int i2) {
        a Ng = Ng(i);
        if (Ng != null && Ng.yfj != i2) {
            Ng.yfj = i2;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuText(int i, String str) {
        a Ng = Ng(i);
        if (Ng != null && !bo.bc(str, "").equals(Ng.text)) {
            Ng.text = str;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a Ng = Ng(i);
        if (Ng != null) {
            Ng.gzB = onMenuItemClickListener;
            Ng.mlV = onLongClickListener;
        }
    }

    public final void setTitleBarDoubleClickListener(final Runnable runnable) {
        if (this.mActionBar != null && runnable != null) {
            this.mActionBar.getCustomView().setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(105998);
                    if (SystemClock.elapsedRealtime() - q.this.ryj < 300) {
                        runnable.run();
                    }
                    q.this.ryj = SystemClock.elapsedRealtime();
                    AppMethodBeat.o(105998);
                }
            });
        }
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener, int i) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.ylR != null) {
                    this.ylR.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(106001);
                            view.setSelected(false);
                            view.setPressed(false);
                            view.clearFocus();
                            view.invalidate();
                            view.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(106000);
                                    onMenuItemClickListener.onMenuItemClick(null);
                                    AppMethodBeat.o(106000);
                                }
                            });
                            AppMethodBeat.o(106001);
                        }
                    });
                }
            }
            if (i == 0) {
                i = R.raw.actionbar_icon_dark_back;
            }
            if (!(this.ylS == null || i == 0)) {
                this.ylS.setImageResource(i);
            }
            this.ylN.yfi = 16908332;
            this.ylN.gzB = onMenuItemClickListener;
        }
    }

    public final void removeAllOptionMenu() {
        if (!this.yfa.isEmpty()) {
            this.yfa.clear();
            supportInvalidateOptionsMenu();
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean Nf(int i) {
        for (int i2 = 0; i2 < this.yfa.size(); i2++) {
            if (((a) this.yfa.get(i2)).yfi == i) {
                ab.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.yfa.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean removeOptionMenu(int i) {
        for (int i2 = 0; i2 < this.yfa.size(); i2++) {
            if (((a) this.yfa.get(i2)).yfi == i) {
                ab.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.yfa.remove(i2);
                supportInvalidateOptionsMenu();
                return true;
            }
        }
        return false;
    }

    public final void a(a aVar) {
        Nf(aVar.yfi);
        this.yfa.add(aVar);
        supportInvalidateOptionsMenu();
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, int i2, String str, boolean z, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, b bVar) {
        a aVar = new a();
        aVar.yfi = i;
        aVar.yfj = i2;
        aVar.text = str;
        aVar.gzB = onMenuItemClickListener;
        aVar.mlV = onLongClickListener;
        aVar.ymr = bVar;
        aVar.yms = z;
        if (aVar.yfj == R.drawable.uu && bo.isNullOrNil(str)) {
            aVar.text = this.mContext.getString(R.string.rn);
        }
        Nf(aVar.yfi);
        this.yfa.add(aVar);
        supportInvalidateOptionsMenu();
    }

    public final a Ng(int i) {
        Iterator it = this.yfa.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.yfi == i) {
                return aVar;
            }
        }
        return null;
    }

    public final CharSequence getMMTitle() {
        if (this.mActionBar == null) {
            return null;
        }
        return this.ylA != null ? this.ylA : this.mActionBar.getTitle();
    }

    public final void hideTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "hideTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
    }

    public final void showTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "showTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.show();
        }
    }

    public final boolean isTitleShowing() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "isTitleShowing hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        if (this.mActionBar == null) {
            return false;
        }
        return this.mActionBar.isShowing();
    }

    public final int getTitleLocation() {
        if (this.mActionBar == null) {
            return 0;
        }
        return this.mActionBar.getHeight();
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.ylI = i == 0;
        dym();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = this.ylL.getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.MMActivityController", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        ab.v("MicroMsg.MMActivityController", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }

    public final boolean hideVKB(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void dyn() {
        if (this.qlP) {
            if (this.ylS != null) {
                this.ylS.setColorFilter(-1, Mode.SRC_ATOP);
                this.ylR.setBackgroundResource(R.drawable.zd);
            }
            if (this.ylQ != null && this.ylQ.getVisibility() == 0) {
                this.ylQ.setTextColor(this.mContext.getResources().getColor(R.color.a6a));
            }
            if (this.jcI != null && this.jcI.getVisibility() == 0) {
                this.jcI.setTextColor(this.mContext.getResources().getColor(R.color.a6a));
            }
            if (this.yeP == null || this.yeP.getVisibility() != 0) {
                if (this.yeR != null && this.yeR.getVisibility() == 0) {
                    this.yeR.setTextColor(com.tencent.mm.bz.a.h(this.mContext, (int) R.color.a8m));
                    return;
                }
                return;
            } else if (this.yeP.getDrawable() != null) {
                this.yeP.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                return;
            } else {
                this.yeP.setColorFilter(-1, Mode.SRC_ATOP);
                return;
            }
        }
        if (this.ylS != null) {
            this.ylS.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.ylR.setBackgroundResource(R.drawable.al);
        }
        if (this.ylQ != null && this.ylQ.getVisibility() == 0) {
            this.ylQ.setTextColor(this.mContext.getResources().getColor(R.color.h7));
        }
        if (this.jcI != null && this.jcI.getVisibility() == 0) {
            this.jcI.setTextColor(this.mContext.getResources().getColor(R.color.h7));
        }
        if (this.yeP == null || this.yeP.getVisibility() != 0) {
            if (this.yeR != null && this.yeR.getVisibility() == 0) {
                this.yeR.setTextColor(com.tencent.mm.bz.a.h(this.mContext, (int) R.color.a73));
            }
        } else if (this.yeP.getDrawable() != null) {
            this.yeP.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        } else {
            this.yeP.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }

    /* Access modifiers changed, original: final */
    public final void dyo() {
        if (VERSION.SDK_INT >= 23) {
            View decorView = this.ylL.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            ab.d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", Boolean.valueOf(this.qlP));
            if (this.qlP) {
                systemUiVisibility &= -8193;
            } else {
                systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }

    private static boolean il(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return bo.isEqual(str.toLowerCase(), str2.toLowerCase());
    }

    private static boolean aqE(String str) {
        String str2 = Build.MODEL;
        String str3 = Build.DEVICE;
        if (str2 == null && str3 == null) {
            return false;
        }
        if (il(str2, str) || il(str3, str)) {
            return true;
        }
        return false;
    }

    private static boolean dyp() {
        return aqE("y83a") || aqE("y83") || aqE("v1732a") || aqE("v1732t");
    }

    public final void Nb(int i) {
        if (VERSION.SDK_INT >= 26 && !dyp()) {
            int i2;
            this.ylL.getWindow().setNavigationBarColor(i);
            boolean Nw = ah.Nw(i);
            View decorView = this.ylL.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (Nw) {
                i2 = systemUiVisibility & -17;
            } else {
                i2 = systemUiVisibility | 16;
            }
            decorView.setSystemUiVisibility(i2);
        }
    }

    public final void xE(int i) {
        if (this.mActionBar != null) {
            this.yeO = i;
            this.qlP = ah.Nw(this.yeO);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yeO));
            l(this.ylL, this.yeO);
            dyo();
            dyn();
        }
    }

    @TargetApi(21)
    public final void l(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            if (VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.h.Mt()) {
                if (VERSION.SDK_INT >= 21) {
                    i = ah.s(activity.getResources().getColor(R.color.a1h), i);
                } else {
                    i = 0;
                }
            }
            if ((activity instanceof MMActivity) && ((MMActivity) activity).yll && ((MMActivity) activity).isSupportNavigationSwipeBack()) {
                com.tencent.mm.ui.statusbar.a.d(this.contentView, i, d.b(activity.getWindow()));
            } else {
                activity.getWindow().setStatusBarColor(i);
            }
            Nb(this.ylL.getResources().getColor(R.color.a0));
        }
    }

    private static void eY(Context context) {
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
                for (int i = 0; i < 3; i++) {
                    try {
                        Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(inputMethodManager);
                        if (obj != null && (obj instanceof View) && ((View) obj).getContext() == context) {
                            declaredField.set(inputMethodManager, null);
                        }
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.MMActivityController", th, "", new Object[0]);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void updateDescription(String str) {
        com.tencent.mm.ui.a.a.a.yqY.h(this.ylL, str);
    }

    static /* synthetic */ boolean f(q qVar) {
        return (qVar.ylL.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    static /* synthetic */ void g(q qVar) {
        qVar.ymc = 2;
        qVar.onKeyboardStateChanged();
    }

    static /* synthetic */ void h(q qVar) {
        qVar.ymc = 1;
        qVar.onKeyboardStateChanged();
    }
}
