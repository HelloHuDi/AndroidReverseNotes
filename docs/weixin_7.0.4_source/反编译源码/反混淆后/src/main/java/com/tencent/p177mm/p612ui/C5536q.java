package com.tencent.p177mm.p612ui;

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
import android.support.p057v4.view.C0464g;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.app.AppCompatActivity;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p223i.C1435a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.p230g.p231a.C6549tm;
import com.tencent.p177mm.p230g.p231a.C6549tm.C1578a;
import com.tencent.p177mm.p612ui.LayoutListenerView.C5185c;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.p612ui.statusbar.C5540a;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.q */
public abstract class C5536q {
    private static WakeLock wakeLock = null;
    private static boolean ylO = false;
    public static final int ylZ = 2130968620;
    public static long ymb;
    private static byte[] ymd = new byte[]{(byte) 0};
    private int bsz = this.yeY;
    String className;
    public View contentView;
    private C5601o elS;
    private LayoutInflater ezi;
    AudioManager fZh;
    TextView jcI;
    private Button lXZ;
    public ActionBar mActionBar;
    public Context mContext;
    private int mQh = 0;
    protected C7306ak mty = new C7306ak(Looper.getMainLooper());
    boolean qlP = false;
    private final long ryi = 300;
    private long ryj = SystemClock.elapsedRealtime();
    private View yeM;
    private int yeO = 0;
    public ImageButton yeP;
    TextView yeR;
    private int yeY;
    private int yeZ;
    LinkedList<C5534a> yfa = new LinkedList();
    private String ylA = " ";
    private int ylB = 0;
    private int ylC = 0;
    private C5664a ylD = null;
    private C5664a ylE = null;
    private C5664a ylF = null;
    private C5664a ylG = null;
    private C5664a ylH = null;
    private boolean ylI = false;
    boolean ylJ = false;
    boolean ylK = false;
    public AppCompatActivity ylL;
    private boolean ylM;
    private C5534a ylN = new C5534a();
    private ArrayList<Dialog> ylP;
    public TextView ylQ;
    public View ylR;
    ImageView ylS;
    int ylT = 0;
    private ImageView ylU;
    private int ylV = 0;
    private boolean ylW = false;
    private C4884c ylX = new C55391();
    private int ylY = 2130968618;
    protected boolean ylk = false;
    private View ylu;
    public View ylv;
    View ylw;
    private TextView ylx;
    FrameLayout yly;
    public boolean ylz = true;
    private int yma = -1;
    public int ymc = 0;
    private C5534a yme;
    private MenuItem ymf;
    private Runnable ymg = new C55252();
    private Runnable ymh = new C55263();

    /* renamed from: com.tencent.mm.ui.q$13 */
    class C552213 implements OnTouchListener {
        C552213() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106009);
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                C5536q.ymb = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(106009);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.q$2 */
    class C55252 implements Runnable {
        C55252() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105996);
            C5536q.this.ylL.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (C5536q.this.mActionBar != null) {
                C5536q.this.mActionBar.hide();
            }
            AppMethodBeat.m2505o(105996);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$3 */
    class C55263 implements Runnable {
        C55263() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105997);
            if (C5536q.this.mActionBar != null) {
                C5536q.this.mActionBar.show();
            }
            AppMethodBeat.m2505o(105997);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$5 */
    class C55285 implements OnClickListener {
        final /* synthetic */ Runnable ymk;
        final /* synthetic */ Runnable yml;

        C55285(Runnable runnable, Runnable runnable2) {
            this.ymk = runnable;
            this.yml = runnable2;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(105999);
            if (SystemClock.elapsedRealtime() - C5536q.this.ryj < 300) {
                if (this.ymk != null) {
                    this.ymk.run();
                }
            } else if (this.yml != null) {
                this.yml.run();
            }
            C5536q.this.ryj = SystemClock.elapsedRealtime();
            AppMethodBeat.m2505o(105999);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$7 */
    class C55317 implements Runnable {
        C55317() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106002);
            C5536q.this.supportInvalidateOptionsMenu();
            AppMethodBeat.m2505o(106002);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$8 */
    class C55328 implements Runnable {
        C55328() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106003);
            C5536q.this.supportInvalidateOptionsMenu();
            AppMethodBeat.m2505o(106003);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$a */
    public static final class C5534a {
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
        public C5535b ymr = C5535b.NORMAL;
        public boolean yms = false;
    }

    /* renamed from: com.tencent.mm.ui.q$b */
    public enum C5535b {
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
            AppMethodBeat.m2505o(106015);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$12 */
    class C553712 implements C5185c {
        private final int ymn = C1338a.fromDPToPix(C5536q.this.mContext, 100);

        C553712() {
            AppMethodBeat.m2504i(106007);
            AppMethodBeat.m2505o(106007);
        }

        public final void onSizeChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(106008);
            if (C5536q.m8332f(C5536q.this)) {
                AppMethodBeat.m2505o(106008);
                return;
            }
            if (!(i == 0 || i2 == 0 || i3 == 0 || i4 == 0 || i != i3)) {
                if (i2 > i4 && i2 - i4 > this.ymn) {
                    C5536q.m8333g(C5536q.this);
                    AppMethodBeat.m2505o(106008);
                    return;
                } else if (i4 > i2 && i4 - i2 > this.ymn) {
                    C5536q.m8334h(C5536q.this);
                }
            }
            AppMethodBeat.m2505o(106008);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$14 */
    class C553814 implements C5662c {
        C553814() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(106010);
            if (z) {
                C7060h.pYm.mo8381e(15181, Integer.valueOf(3));
                Intent intent = new Intent();
                intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                intent.addFlags(268435456);
                C4996ah.getContext().startActivity(intent);
                AppMethodBeat.m2505o(106010);
                return;
            }
            C7060h.pYm.mo8381e(15181, Integer.valueOf(2));
            AppMethodBeat.m2505o(106010);
        }
    }

    /* renamed from: com.tencent.mm.ui.q$1 */
    class C55391 extends C4884c<C6549tm> {
        C55391() {
            AppMethodBeat.m2504i(105994);
            this.xxI = C6549tm.class.getName().hashCode();
            AppMethodBeat.m2505o(105994);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(105995);
            C1578a c1578a = ((C6549tm) c4883b).cPH;
            if (c1578a.cts == 2) {
                String str = c1578a.ctu;
                int i = c1578a.position;
                C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i), str);
                if (i <= 0 || i == C5536q.this.ylV) {
                    C5536q.this.m8321a(c1578a.ctt, c1578a.aIB, c1578a.url, c1578a.desc, str, i, false);
                } else {
                    C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(C5536q.this.ylV));
                }
            }
            AppMethodBeat.m2505o(105995);
            return false;
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

    /* renamed from: a */
    private void m8321a(int i, final boolean z, final String str, final String str2, final String str3, final int i2, boolean z2) {
        C4990ab.m7417i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i2), this.ylw);
        if (!needShowIdcError()) {
            return;
        }
        if (!z && this.ylw == null) {
            return;
        }
        if (this.mActionBar == null || this.mActionBar.isShowing()) {
            if (this.yly == null) {
                this.yly = (FrameLayout) this.contentView.findViewById(2131825953);
            }
            if (this.ylw != null) {
                this.yly.removeView(this.ylw);
            }
            if (i <= 0) {
                i = 2130970230;
            }
            this.ylw = this.ezi.inflate(i, null);
            this.ylx = (TextView) this.ylw.findViewById(2131823312);
            this.ylw.findViewById(2131826105).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(106004);
                    C6459ak c6459ak = new C6459ak();
                    c6459ak.cto.type = 1;
                    c6459ak.cto.ctq = str3;
                    c6459ak.cto.position = i2;
                    C4879a.xxA.mo10055m(c6459ak);
                    C5536q.this.ylw.setVisibility(8);
                    AppMethodBeat.m2505o(106004);
                }
            });
            this.ylw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(106005);
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        C5536q.this.mContext.startActivity(intent);
                    }
                    AppMethodBeat.m2505o(106005);
                }
            });
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            if (this.ylW && VERSION.SDK_INT >= 16) {
                layoutParams.setMargins(0, C4977b.m7371b(this.ylL, 48.0f), 0, 0);
                C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
            }
            this.yly.addView(this.ylw, this.yly.getChildCount(), layoutParams);
            if (this.ylw == null) {
                return;
            }
            if (z2) {
                this.ylw.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(C25738R.string.cdc);
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = this.mContext.getString(C25738R.string.b6_);
                }
                if (str != null) {
                    SpannableString spannableString = new SpannableString(str2 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str2.length(), string.length() + str2.length(), 33);
                    this.ylx.setText(spannableString);
                } else {
                    C4990ab.m7416i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                    this.ylx.setText(str2);
                }
                this.ylw.invalidate();
                this.yly.invalidate();
                return;
            }
            this.ylw.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(106006);
                    C5536q.this.ylw.setVisibility(z ? 0 : 8);
                    String string = C5536q.this.mContext.getString(C25738R.string.cdc);
                    String string2 = C5046bo.isNullOrNil(str2) ? C5536q.this.mContext.getString(C25738R.string.b6_) : str2;
                    if (str != null) {
                        SpannableString spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        C5536q.this.ylx.setText(spannableString);
                    } else {
                        C4990ab.m7416i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                        C5536q.this.ylx.setText(string2);
                    }
                    C5536q.this.ylw.invalidate();
                    C5536q.this.yly.invalidate();
                    AppMethodBeat.m2505o(106006);
                }
            });
            return;
        }
        C4990ab.m7416i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
    }

    private View findViewById(int i) {
        View findViewById = this.contentView.findViewById(i);
        return findViewById != null ? findViewById : this.ylL.findViewById(i);
    }

    public final void setBackGroundColorResource(int i) {
        if (this.contentView != null) {
            if (this.yly == null) {
                this.yly = (FrameLayout) this.contentView.findViewById(2131825953);
            }
            this.yly.setBackgroundResource(i);
            this.ylv.setBackgroundResource(i);
        }
    }

    /* renamed from: aC */
    public final void mo11176aC(int i, boolean z) {
        this.ylV = i;
        this.ylW = z;
    }

    public static Locale initLanguage(Context context) {
        return C5536q.m8327bM(context, C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0)));
    }

    /* renamed from: bM */
    public static Locale m8327bM(Context context, String str) {
        if (str.equals("language_default")) {
            C4988aa.m7399a(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale amw = C4988aa.amw(str);
        C4988aa.m7399a(context, amw);
        return amw;
    }

    public ActionBar getSupportActionBar() {
        return this.ylL.getSupportActionBar();
    }

    /* renamed from: a */
    public final void mo11174a(Context context, AppCompatActivity appCompatActivity) {
        this.mContext = appCompatActivity;
        this.ylL = appCompatActivity;
        if (VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = this.ylL.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.ylL.getWindow().setAttributes(attributes);
        }
        boolean z = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).getBoolean("dark_actionbar_init_new", false);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).getBoolean("dark_actionbar", false);
        if (!z) {
            C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
            C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar_init_new", true).commit();
        }
        onCreateBeforeSetContentView();
        this.className = getClass().getName();
        C5219ac.m7928bL(3, this.className);
        C5536q.initLanguage(context);
        this.fZh = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int layoutId = getLayoutId();
        this.ezi = LayoutInflater.from(this.mContext);
        this.contentView = C1742b.m3596SM().mo5274a((Activity) appCompatActivity, "R.layout.mm_activity", 2130970087);
        this.ylu = this.contentView.findViewById(2131825954);
        this.yly = (FrameLayout) this.contentView.findViewById(2131825953);
        this.mQh = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10005n7);
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
            C5222ae.m7946h(C5222ae.m7934a(this.ylL.getWindow(), this.ylv), this.ylv);
            ((ViewGroup) this.ylv.getParent()).removeView(this.ylv);
            ((ViewGroup) this.ylL.getWindow().getDecorView()).addView(this.ylv, 0);
            layoutId = C1338a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            }
            this.ylv.setPadding(this.ylv.getPaddingLeft(), dimensionPixelSize + (layoutId + this.ylv.getPaddingTop()), this.ylv.getPaddingRight(), this.ylv.getPaddingBottom());
        }
        this.mActionBar = getSupportActionBar();
        C4990ab.m7410d("MicroMsg.MMActivityController", "onCreate, before.");
        mo11188ap(appCompatActivity);
        this.yeY = C5229aj.m7981am(this.mContext, C25738R.dimen.f9778fd);
        this.yeZ = C5229aj.m7981am(this.mContext, C25738R.dimen.f10002n4);
        if (this.yly == null || !(this.yly instanceof LayoutListenerView)) {
            C4990ab.m7420w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.yly).setOnResizedListener(new C553712());
        }
        C6459ak c6459ak = new C6459ak();
        c6459ak.cto.type = 2;
        c6459ak.cto.position = this.ylV;
        C4879a.xxA.mo10055m(c6459ak);
        if (c6459ak.ctp.cts == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = c6459ak.ctp.ctu;
            int i = c6459ak.ctp.position;
            C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i), str, C5046bo.dpG());
            if (i <= 0 || i == this.ylV) {
                m8321a(c6459ak.ctp.ctt, c6459ak.ctp.aIB, c6459ak.ctp.url, c6459ak.ctp.desc, str, i, true);
            } else {
                C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.ylV));
            }
            C4990ab.m7418v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (VERSION.SDK_INT >= 21) {
            if (this.yeO == 0) {
                this.yeO = dyj();
            }
            Window window = appCompatActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(C8415j.INVALID_ID);
            mo11216l(appCompatActivity, this.yeO);
            dyo();
        }
    }

    public boolean noActionBar() {
        return false;
    }

    public final int dyj() {
        this.qlP = false;
        if (this.yeO == 0) {
            this.yeO = this.mContext.getResources().getColor(C25738R.color.f12206vy);
        }
        return this.yeO;
    }

    /* renamed from: ap */
    public final void mo11188ap(Activity activity) {
        if (this.mActionBar != null && !noActionBar()) {
            C4990ab.m7410d("MicroMsg.MMActivityController", "onCreate, after");
            if (this.yeO == 0) {
                this.yeO = dyj();
            }
            this.qlP = C5225ah.m7958Nw(this.yeO);
            mo11249xE(this.yeO);
            this.mActionBar.setLogo(new ColorDrawable(this.ylL.getResources().getColor(17170445)));
            this.mActionBar.mo1339fc();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.mo1338fb();
            this.mActionBar.mo1340fd();
            this.mActionBar.mo1337fa();
            if (this.yma == -1) {
                this.mActionBar.setCustomView(C5616v.m8409hu(this.ylL).inflate(this.ylY, new LinearLayout(this.ylL), false));
            } else {
                this.mActionBar.setCustomView(C5616v.m8409hu(this.ylL).inflate(this.yma, new LinearLayout(this.ylL), false));
            }
            this.ylQ = (TextView) findViewById(16908308);
            this.jcI = (TextView) findViewById(16908309);
            this.yeM = findViewById(2131820982);
            this.ylR = findViewById(2131820973);
            this.ylS = (ImageView) findViewById(2131820974);
            this.ylR.setOnTouchListener(new C552213());
            if (this.ylS != null) {
                this.ylS.setContentDescription(this.ylL.getString(C25738R.string.f8823g1));
            }
            if (this.ylQ != null) {
                this.ylQ.setText(C25738R.string.f9176ru);
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
            this.ylu = this.contentView.findViewById(2131825954);
        }
        if (this.ylu == null) {
            C4990ab.m7412e("MicroMsg.MMActivityController", "jacks error npe translayer !");
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
            m8336hp(this.ylL);
        }
    }

    /* renamed from: hp */
    private void m8336hp(Context context) {
        synchronized (ymd) {
            if (wakeLock == null) {
                wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(32, "screen Lock");
            }
            if (wakeLock.isHeld()) {
                C4990ab.m7421w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.acquire();
                C4990ab.m7417i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
            }
        }
    }

    private void releaseWakeLock() {
        synchronized (ymd) {
            if (wakeLock == null || !wakeLock.isHeld()) {
                C4990ab.m7421w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.release();
                C4990ab.m7417i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
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
        this.ylk = this.mContext.getSharedPreferences(C4996ah.doA(), 0).getBoolean("settings_landscape_mode", false);
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
        m8322a(this.ymf, this.yme);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        C1407g.m2947KO();
        C1407g.m2947KO();
        if (!this.ylM || this.elS == null || !this.elS.onKeyDown(i, keyEvent)) {
            return false;
        }
        C4990ab.m7410d("MicroMsg.MMActivityController", "match search view on key down");
        if (this.qlP) {
            mo11249xE(this.ylL.getResources().getColor(C25738R.color.f11906l8));
        } else {
            mo11249xE(this.ylL.getResources().getColor(C25738R.color.f12206vy));
        }
        return true;
    }

    public boolean needShowIdcError() {
        return true;
    }

    public final void onResume() {
        activateBroadcast(true);
        C4879a.xxA.mo10052c(this.ylX);
        C6459ak c6459ak = new C6459ak();
        c6459ak.cto.type = 2;
        c6459ak.cto.position = this.ylV;
        C4879a.xxA.mo10055m(c6459ak);
        if (c6459ak.ctp.cts == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = c6459ak.ctp.ctu;
            int i = c6459ak.ctp.position;
            C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i), str);
            if (i <= 0 || i == this.ylV) {
                m8321a(c6459ak.ctp.ctt, c6459ak.ctp.aIB, c6459ak.ctp.url, c6459ak.ctp.desc, str, i, true);
            } else {
                C4990ab.m7417i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.ylV));
            }
            C4990ab.m7418v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!C1720g.m3531RK() || !C1720g.m3534RN().eJb || C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).getBoolean("font_scale_tip", true)) {
            return;
        }
        if (1.0f != C1338a.m2860dm(C4996ah.getContext())) {
            C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
        } else if (1.0f != C4996ah.getContext().getResources().getConfiguration().fontScale) {
            C7060h.pYm.mo8381e(15181, Integer.valueOf(1));
            C5659a c5659a = new C5659a(C4996ah.getContext());
            C5659a asL = c5659a.mo11514al(this.ylL.getResources().getString(C25738R.string.bz9)).asL(this.ylL.getResources().getString(C25738R.string.bz6));
            asL.zQJ = this.ylL.getResources().getString(C25738R.string.bz8);
            asL.zQK = this.ylL.getResources().getString(C25738R.string.bz7);
            c5659a.mo11523c(new C553814()).show();
            C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", true).apply();
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

    /* renamed from: hq */
    public final void mo11213hq(Context context) {
        C4879a.xxA.mo10053d(this.ylX);
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
        C5536q.m8331eY(context);
    }

    public final void activateBroadcast(boolean z) {
        if (ylO || !z) {
            C5288y.m8058d(z, new Intent().putExtra("classname", getClassName() + bJj()));
        } else {
            C5288y.m8058d(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void dxV() {
        ylO = true;
    }

    public final void onPause() {
        activateBroadcast(false);
        C4879a.xxA.mo10053d(this.ylX);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        C4990ab.m7411d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.yfa.size()));
        if (this.mActionBar == null || this.yfa.size() == 0) {
            C4990ab.m7421w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.yfa.size()));
            return false;
        }
        this.yme = null;
        this.ymf = null;
        if (this.mActionBar.getHeight() == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
            } else {
                this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            }
        }
        Iterator it = this.yfa.iterator();
        while (it.hasNext()) {
            final C5534a c5534a = (C5534a) it.next();
            if (c5534a.yfi == 16908332) {
                C4990ab.m7418v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (c5534a.yfi == 2131820645) {
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
                C4990ab.m7419v(str, str2, objArr);
                if (this.ylM && this.elS != null) {
                    this.elS.mo11359a(this.ylL, menu);
                }
            } else {
                final MenuItem add = menu.add(0, c5534a.yfi, 0, c5534a.text);
                C1435a.m3060a(add, getClass().getName());
                C552315 c552315 = new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(106011);
                        C5536q.this.m8322a(add, c5534a);
                        AppMethodBeat.m2505o(106011);
                    }
                };
                C552416 c552416 = new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.m2504i(106012);
                        boolean a = C5536q.m8325a(C5536q.this, view, c5534a);
                        AppMethodBeat.m2505o(106012);
                        return a;
                    }
                };
                if (c5534a.yfj == 0 && c5534a.ymq == null) {
                    if (c5534a.yfk == null) {
                        c5534a.yfk = View.inflate(this.mContext, 2130968611, null);
                    }
                    this.yeR = (TextView) c5534a.yfk.findViewById(2131820958);
                    this.yeR.setVisibility(0);
                    this.lXZ = (Button) c5534a.yfk.findViewById(2131820959);
                    this.lXZ.setVisibility(8);
                    if (c5534a.ymr == C5535b.RED || c5534a.ymr == C5535b.TRANSPARENT_RED_TEXT) {
                        this.yeR.setTextColor(C1338a.m2870h(this.ylL, (int) C25738R.color.a89));
                        this.lXZ.setVisibility(0);
                        this.lXZ.setBackgroundResource(C25738R.drawable.f6488ft);
                        this.yeR.setVisibility(8);
                    } else if (c5534a.ymr == C5535b.GREEN || c5534a.ymr == C5535b.TRANSPARENT_GREEN_TEXT) {
                        this.lXZ.setVisibility(0);
                        this.lXZ.setBackgroundResource(C25738R.drawable.f6485fq);
                        this.yeR.setVisibility(8);
                    } else {
                        if (c5534a.ymr != C5535b.BLACK) {
                            if (c5534a.ymr == C5535b.TRANSPARENT_GOLD_TEXT) {
                                this.yeR.setTextColor(this.ylL.getResources().getColor(C25738R.color.f12148u2));
                            } else if (c5534a.ymr == C5535b.GOLDEN) {
                                this.yeR.setTextColor(-2601405);
                            } else if (c5534a.ymr == C5535b.YELLOW) {
                                this.lXZ.setVisibility(0);
                                this.lXZ.setBackgroundResource(C25738R.drawable.f6490fv);
                                this.yeR.setVisibility(8);
                            } else if (this.ylT != 0) {
                                this.yeR.setTextColor(this.ylT);
                            } else if (this.qlP) {
                                this.yeR.setTextColor(C1338a.m2870h(this.ylL, (int) C25738R.color.a8m));
                            }
                        }
                        this.yeR.setTextColor(C1338a.m2870h(this.ylL, (int) C25738R.color.a73));
                    }
                    this.yeR.setText(c5534a.text);
                    if (c5534a.textColor != 0) {
                        this.yeR.setTextColor(c5534a.textColor);
                    }
                    this.yeR.setOnClickListener(c552315);
                    this.yeR.setOnLongClickListener(c552416);
                    this.yeR.setEnabled(c5534a.enable);
                    this.lXZ.setText(c5534a.text);
                    this.lXZ.setOnClickListener(c552315);
                    this.lXZ.setOnLongClickListener(c552416);
                    this.lXZ.setEnabled(c5534a.enable);
                    C0464g.m803a(add, c5534a.yfk);
                } else {
                    if (c5534a.yfl == null) {
                        c5534a.yfl = View.inflate(this.mContext, 2130968611, null);
                    }
                    ImageView imageView = (ImageView) c5534a.yfl.findViewById(2131821128);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.yeP = (ImageButton) c5534a.yfl.findViewById(2131820960);
                    this.yeP.setVisibility(0);
                    if (c5534a.ymq != null) {
                        this.yeP.setImageDrawable(c5534a.ymq);
                    } else {
                        this.yeP.setImageResource(c5534a.yfj);
                    }
                    if (this.ylT != 0) {
                        this.yeP.getDrawable().setColorFilter(this.ylT, Mode.SRC_ATOP);
                    } else if (c5534a.ymp == 0) {
                        if (this.qlP) {
                            this.yeP.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                        } else {
                            this.yeP.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                        }
                    }
                    this.yeP.setOnClickListener(c552315);
                    this.yeP.setEnabled(c5534a.enable);
                    this.yeP.setContentDescription(c5534a.text);
                    if (c5534a.mlV != null) {
                        this.yeP.setOnLongClickListener(c552416);
                    }
                    this.ylU = (ImageView) c5534a.yfl.findViewById(2131820961);
                    if (this.ylU != null) {
                        if (c5534a.yms) {
                            this.ylU.setVisibility(0);
                        } else {
                            this.ylU.setVisibility(8);
                        }
                    }
                    C0464g.m803a(add, c5534a.yfl);
                }
                add.setEnabled(c5534a.enable);
                add.setVisible(c5534a.aIB);
                C0464g.m806a(add, 2);
                if (c5534a.yfj == C25738R.drawable.f6899uu) {
                    this.yme = c5534a;
                    this.ymf = add;
                }
                C4990ab.m7419v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(c5534a.yfi), c5534a.text, Boolean.valueOf(c5534a.enable), Boolean.valueOf(c5534a.aIB));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        C4990ab.m7410d("MicroMsg.MMActivityController", "on prepare option menu");
        if (this.ylM && this.elS != null) {
            this.elS.mo11358a(this.ylL, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        C4990ab.m7418v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.ylz) {
            C4990ab.m7420w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.ylN.yfi && this.ylN.enable) {
            m8322a(menuItem, this.ylN);
            return true;
        } else {
            Iterator it = this.yfa.iterator();
            while (it.hasNext()) {
                C5534a c5534a = (C5534a) it.next();
                if (menuItem.getItemId() == c5534a.yfi) {
                    C4990ab.m7411d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    m8322a(menuItem, c5534a);
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
        m8322a(null, this.ylN);
        return true;
    }

    /* renamed from: a */
    private void m8322a(MenuItem menuItem, C5534a c5534a) {
        if (!this.ylz) {
            C4990ab.m7420w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (c5534a.gzB != null) {
            c5534a.gzB.onMenuItemClick(menuItem);
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
                mo11216l(this.ylL, this.yeO);
                return;
            }
            this.mActionBar.hide();
            mo11216l(this.ylL, this.ylL.getResources().getColor(C25738R.color.f11782h4));
        }
    }

    public final void setMMTitle(String str) {
        if (this.mActionBar != null) {
            this.ylA = str;
            if (C1338a.m2865ga(this.ylL)) {
                this.ylQ.setTextSize(0, ((float) C1338a.m2857am(this.ylL, C25738R.dimen.f9720dk)) * C1338a.m2862fY(this.ylL));
            }
            dym();
            updateDescription(str);
        }
    }

    /* renamed from: M */
    public final void mo11169M(CharSequence charSequence) {
        if (this.mActionBar != null) {
            this.ylA = charSequence.toString();
            this.ylQ.setText(charSequence);
            if (C1338a.m2865ga(this.ylL)) {
                this.ylQ.setTextSize(0, ((float) C1338a.m2857am(this.ylL, C25738R.dimen.f9720dk)) * C1338a.m2862fY(this.ylL));
            }
            updateDescription(charSequence.toString());
        }
    }

    public final void setMMTitle(int i) {
        setMMTitle(this.mContext.getString(i));
    }

    /* renamed from: bn */
    public final void mo11190bn(float f) {
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
            if (C1338a.m2865ga(this.ylL)) {
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
            if (C1338a.m2865ga(this.ylL)) {
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
                this.ylD = m8335hb(this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9728dt), this.ylB);
            }
            if (i2 == 0) {
                this.ylC = 0;
                this.ylE = null;
            } else if (this.ylC != i2) {
                this.ylC = i2;
                this.ylE = m8335hb(this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9728dt), this.ylC);
            }
            dym();
        }
    }

    /* renamed from: hb */
    private C5664a m8335hb(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        if (this.qlP) {
            drawable = C5225ah.m7962f(this.ylL, i2, -1);
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        C5664a c5664a = new C5664a(drawable);
        c5664a.zLT = (drawable.getIntrinsicHeight() - i) / 2;
        return c5664a;
    }

    /* Access modifiers changed, original: final */
    public final void dym() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9720dk);
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
        C4990ab.m7419v("MicroMsg.MMActivityController", "span title format %s", str);
        CharSequence h = C5509b.m8296h(this.mContext, format, dimensionPixelSize);
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
                    this.ylG = m8335hb(dimensionPixelSize, C1318a.chat_force_notify_icon);
                }
                length = spannableString.length() - i3;
                spannableString.setSpan(this.ylG, length, length + 1, 33);
            }
            if (!this.ylJ && this.ylI) {
                if (this.ylF == null) {
                    this.ylF = m8335hb(dimensionPixelSize, C1318a.chat_mute_notify_title_icon);
                }
                length = spannableString.length() - i2;
                spannableString.setSpan(this.ylF, length, length + 1, 33);
            }
            if (this.ylK) {
                if (this.ylH == null) {
                    this.ylH = m8335hb(dimensionPixelSize, C1318a.chat_phone_notify_title_icon);
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
    /* renamed from: d */
    public final void mo11192d(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        C5534a c5534a;
        if (z) {
            it = this.yfa.iterator();
            z3 = false;
            while (it.hasNext()) {
                c5534a = (C5534a) it.next();
                if (c5534a.enable != z2) {
                    c5534a.enable = z2;
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
                c5534a = (C5534a) it.next();
                if (c5534a.yfi != i || c5534a.enable == z2) {
                    z4 = z3;
                } else {
                    c5534a.enable = z2;
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
        C4990ab.m7419v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo11200e(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        C5534a c5534a;
        if (z) {
            it = this.yfa.iterator();
            z3 = false;
            while (it.hasNext()) {
                c5534a = (C5534a) it.next();
                if (c5534a.aIB != z2) {
                    c5534a.aIB = z2;
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
                c5534a = (C5534a) it.next();
                if (c5534a.yfi != i || c5534a.aIB == z2) {
                    z4 = z3;
                } else {
                    c5534a.aIB = z2;
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
        C4990ab.m7417i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void addSearchMenu(boolean z, C5601o c5601o) {
        C4990ab.m7418v("MicroMsg.MMActivityController", "add search menu");
        C5534a c5534a = new C5534a();
        c5534a.yfi = 2131820645;
        c5534a.text = this.mContext.getString(C25738R.string.f9220te);
        c5534a.yfj = C1318a.actionbar_icon_dark_search;
        c5534a.gzB = null;
        c5534a.mlV = null;
        removeOptionMenu(c5534a.yfi);
        this.yfa.add(0, c5534a);
        this.ylM = z;
        this.elS = c5601o;
        supportInvalidateOptionsMenu();
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        mo11173a(i, 0, str, false, onMenuItemClickListener, null, C5535b.NORMAL);
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, C5535b c5535b) {
        mo11173a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, c5535b);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        mo11173a(i, i2, "", false, onMenuItemClickListener, null, C5535b.NORMAL);
    }

    public final void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        mo11173a(i, i2, str, false, onMenuItemClickListener, null, C5535b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        mo11173a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, null, C5535b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, boolean z, OnMenuItemClickListener onMenuItemClickListener) {
        mo11173a(i, i3, this.mContext.getString(i2), z, onMenuItemClickListener, null, C5535b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        mo11173a(i, i2, "", false, onMenuItemClickListener, onLongClickListener, C5535b.NORMAL);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        mo11173a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, onLongClickListener, C5535b.NORMAL);
    }

    public final void updateOptionMenuIcon(int i, int i2) {
        C5534a Ng = mo11172Ng(i);
        if (Ng != null && Ng.yfj != i2) {
            Ng.yfj = i2;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuText(int i, String str) {
        C5534a Ng = mo11172Ng(i);
        if (Ng != null && !C5046bo.m7532bc(str, "").equals(Ng.text)) {
            Ng.text = str;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        C5534a Ng = mo11172Ng(i);
        if (Ng != null) {
            Ng.gzB = onMenuItemClickListener;
            Ng.mlV = onLongClickListener;
        }
    }

    public final void setTitleBarDoubleClickListener(final Runnable runnable) {
        if (this.mActionBar != null && runnable != null) {
            this.mActionBar.getCustomView().setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(105998);
                    if (SystemClock.elapsedRealtime() - C5536q.this.ryj < 300) {
                        runnable.run();
                    }
                    C5536q.this.ryj = SystemClock.elapsedRealtime();
                    AppMethodBeat.m2505o(105998);
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

                        /* renamed from: com.tencent.mm.ui.q$6$1 */
                        class C55291 implements Runnable {
                            C55291() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(106000);
                                onMenuItemClickListener.onMenuItemClick(null);
                                AppMethodBeat.m2505o(106000);
                            }
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(106001);
                            view.setSelected(false);
                            view.setPressed(false);
                            view.clearFocus();
                            view.invalidate();
                            view.post(new C55291());
                            AppMethodBeat.m2505o(106001);
                        }
                    });
                }
            }
            if (i == 0) {
                i = C1318a.actionbar_icon_dark_back;
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
    /* renamed from: Nf */
    public final boolean mo11171Nf(int i) {
        for (int i2 = 0; i2 < this.yfa.size(); i2++) {
            if (((C5534a) this.yfa.get(i2)).yfi == i) {
                C4990ab.m7411d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.yfa.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean removeOptionMenu(int i) {
        for (int i2 = 0; i2 < this.yfa.size(); i2++) {
            if (((C5534a) this.yfa.get(i2)).yfi == i) {
                C4990ab.m7411d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.yfa.remove(i2);
                supportInvalidateOptionsMenu();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo11175a(C5534a c5534a) {
        mo11171Nf(c5534a.yfi);
        this.yfa.add(c5534a);
        supportInvalidateOptionsMenu();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo11173a(int i, int i2, String str, boolean z, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, C5535b c5535b) {
        C5534a c5534a = new C5534a();
        c5534a.yfi = i;
        c5534a.yfj = i2;
        c5534a.text = str;
        c5534a.gzB = onMenuItemClickListener;
        c5534a.mlV = onLongClickListener;
        c5534a.ymr = c5535b;
        c5534a.yms = z;
        if (c5534a.yfj == C25738R.drawable.f6899uu && C5046bo.isNullOrNil(str)) {
            c5534a.text = this.mContext.getString(C25738R.string.f9169rn);
        }
        mo11171Nf(c5534a.yfi);
        this.yfa.add(c5534a);
        supportInvalidateOptionsMenu();
    }

    /* renamed from: Ng */
    public final C5534a mo11172Ng(int i) {
        Iterator it = this.yfa.iterator();
        while (it.hasNext()) {
            C5534a c5534a = (C5534a) it.next();
            if (c5534a.yfi == i) {
                return c5534a;
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
        C4990ab.m7419v(str, str2, objArr);
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
        C4990ab.m7419v(str, str2, objArr);
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
        C4990ab.m7419v(str, str2, objArr);
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
            C4990ab.m7413e("MicroMsg.MMActivityController", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        C4990ab.m7419v("MicroMsg.MMActivityController", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
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
            C4990ab.m7413e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e);
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
                this.ylR.setBackgroundResource(C25738R.drawable.f7041zd);
            }
            if (this.ylQ != null && this.ylQ.getVisibility() == 0) {
                this.ylQ.setTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            }
            if (this.jcI != null && this.jcI.getVisibility() == 0) {
                this.jcI.setTextColor(this.mContext.getResources().getColor(C25738R.color.a6a));
            }
            if (this.yeP == null || this.yeP.getVisibility() != 0) {
                if (this.yeR != null && this.yeR.getVisibility() == 0) {
                    this.yeR.setTextColor(C1338a.m2870h(this.mContext, (int) C25738R.color.a8m));
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
            this.ylR.setBackgroundResource(C25738R.drawable.f6332al);
        }
        if (this.ylQ != null && this.ylQ.getVisibility() == 0) {
            this.ylQ.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11785h7));
        }
        if (this.jcI != null && this.jcI.getVisibility() == 0) {
            this.jcI.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11785h7));
        }
        if (this.yeP == null || this.yeP.getVisibility() != 0) {
            if (this.yeR != null && this.yeR.getVisibility() == 0) {
                this.yeR.setTextColor(C1338a.m2870h(this.mContext, (int) C25738R.color.a73));
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
            C4990ab.m7411d("MicroMsg.MMActivityController", "dancy test actionbar isDark:%s", Boolean.valueOf(this.qlP));
            if (this.qlP) {
                systemUiVisibility &= -8193;
            } else {
                systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }

    /* renamed from: il */
    private static boolean m8338il(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return C5046bo.isEqual(str.toLowerCase(), str2.toLowerCase());
    }

    private static boolean aqE(String str) {
        String str2 = Build.MODEL;
        String str3 = Build.DEVICE;
        if (str2 == null && str3 == null) {
            return false;
        }
        if (C5536q.m8338il(str2, str) || C5536q.m8338il(str3, str)) {
            return true;
        }
        return false;
    }

    private static boolean dyp() {
        return C5536q.aqE("y83a") || C5536q.aqE("y83") || C5536q.aqE("v1732a") || C5536q.aqE("v1732t");
    }

    /* renamed from: Nb */
    public final void mo11170Nb(int i) {
        if (VERSION.SDK_INT >= 26 && !C5536q.dyp()) {
            int i2;
            this.ylL.getWindow().setNavigationBarColor(i);
            boolean Nw = C5225ah.m7958Nw(i);
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

    /* renamed from: xE */
    public final void mo11249xE(int i) {
        if (this.mActionBar != null) {
            this.yeO = i;
            this.qlP = C5225ah.m7958Nw(this.yeO);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yeO));
            mo11216l(this.ylL, this.yeO);
            dyo();
            dyn();
        }
    }

    @TargetApi(21)
    /* renamed from: l */
    public final void mo11216l(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            if (VERSION.SDK_INT < 23 || C1448h.m3077Mt()) {
                if (VERSION.SDK_INT >= 21) {
                    i = C5225ah.m7964s(activity.getResources().getColor(C25738R.color.a1h), i);
                } else {
                    i = 0;
                }
            }
            if ((activity instanceof MMActivity) && ((MMActivity) activity).yll && ((MMActivity) activity).isSupportNavigationSwipeBack()) {
                C5540a.m8360d(this.contentView, i, C5546d.m8370b(activity.getWindow()));
            } else {
                activity.getWindow().setStatusBarColor(i);
            }
            mo11170Nb(this.ylL.getResources().getColor(C25738R.color.f11639a0));
        }
    }

    /* renamed from: eY */
    private static void m8331eY(Context context) {
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
                        C4990ab.printErrStackTrace("MicroMsg.MMActivityController", th, "", new Object[0]);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void updateDescription(String str) {
        C5215a.yqY.mo10718h(this.ylL, str);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m8332f(C5536q c5536q) {
        return (c5536q.ylL.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    /* renamed from: g */
    static /* synthetic */ void m8333g(C5536q c5536q) {
        c5536q.ymc = 2;
        c5536q.onKeyboardStateChanged();
    }

    /* renamed from: h */
    static /* synthetic */ void m8334h(C5536q c5536q) {
        c5536q.ymc = 1;
        c5536q.onKeyboardStateChanged();
    }
}
