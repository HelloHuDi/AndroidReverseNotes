package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.location.model.C39283e;
import com.tencent.p177mm.plugin.location.model.C43242c;
import com.tencent.p177mm.plugin.location.model.LocationInfo;
import com.tencent.p177mm.plugin.location.p446ui.C34411c;
import com.tencent.p177mm.plugin.location.p446ui.C34412d;
import com.tencent.p177mm.plugin.location.p446ui.RemarkUI;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.plugin.p443k.C39279a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.a */
public abstract class C28374a extends C39279a {
    public Activity activity;
    protected int czL = 0;
    protected String eUu = "";
    protected ProgressDialog ehJ = null;
    C7306ak handler = new C7306ak(Looper.getMainLooper());
    int nJw;
    protected String nKN = "";
    protected String nLz;
    public String nOE = "";
    protected boolean nOF = false;
    public boolean nOG = false;
    protected Addr nOH = null;
    protected C34412d nOI;
    protected LocationInfo nOJ = new LocationInfo((byte) 0);
    protected LocationInfo nOK = new LocationInfo((byte) 0);
    protected C28377a nOL;
    protected boolean nOM = false;
    protected HashMap<String, C34411c> nON = new HashMap();
    protected C18657c nOO;
    protected boolean nOP = false;
    protected ArrayList<String> nOQ = new ArrayList();
    protected boolean nOR = false;
    protected boolean nOS = false;
    protected C43242c nOT = null;
    protected C26443d nOU;
    public C18660a nOV = new C123863();
    protected float neG = 0.0f;
    protected float neH = 0.0f;
    DisplayMetrics njz = null;
    protected int type = 0;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$3 */
    class C123863 implements C18660a {
        C123863() {
        }

        /* renamed from: b */
        public final void mo8746b(Addr addr) {
            AppMethodBeat.m2504i(113591);
            C4990ab.m7411d("MicroMsg.BaseMapUI", "onGetAddrss  %s", addr.toString());
            C28374a.this.nOH = addr;
            String agv = addr.agv();
            C28374a.this.nOK.cIK = C28374a.this.activity.getResources().getString(C25738R.string.cn7);
            if (addr.tag != null && addr.tag.equals(C28374a.this.nOK.nJt)) {
                C28374a.this.nOK.nJx = agv;
            } else if (!C5046bo.isNullOrNil(addr.fBg)) {
                C28374a.this.nOL.nOY.setVisibility(0);
            }
            if (addr.tag != null && C28374a.this.nON.containsKey(addr.tag)) {
                C34411c c34411c = (C34411c) C28374a.this.nON.get(addr.tag);
                c34411c.setText(c34411c.getPreText() + agv);
            }
            AppMethodBeat.m2505o(113591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$1 */
    class C211781 implements OnClickListener {
        C211781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113589);
            Intent intent = new Intent(C28374a.this.activity, RemarkUI.class);
            intent.putExtra("key_nullable", true);
            intent.putExtra("key_value", C28374a.this.bKk());
            intent.putExtra("key_hint", C28374a.this.getString(C25738R.string.cnk));
            intent.putExtra("Kwebmap_locaion", C28374a.this.nOJ.nJx);
            intent.putExtra("kFavInfoLocalId", C28374a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kRemark", C28374a.this.activity.getIntent().getStringExtra("kRemark"));
            C28374a.this.activity.startActivityForResult(intent, 4096);
            AppMethodBeat.m2505o(113589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$2 */
    class C283752 implements OnClickListener {
        C283752() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113590);
            Intent intent = new Intent();
            intent.putExtra("key_fav_item_id", C28374a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("key_fav_result_list", C28374a.this.activity.getIntent().getStringArrayListExtra("kTags"));
            C39037b.m66352a(C28374a.this.activity, ".ui.FavTagEditUI", intent, 4100);
            AppMethodBeat.m2505o(113590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$5 */
    class C283765 implements OnClickListener {
        C283765() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$a */
    class C28377a {
        ImageView lnh;
        TextView nHi;
        C28354d nLY;
        FrameLayout nOX;
        RelativeLayout nOY;
        ImageButton nOZ;
        View nPa;
        TextView nPb;
        LinearLayout nPc;
        TextView nPd;
        TextView nPe;
        TextView titleView;

        C28377a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.a$4 */
    class C283784 implements OnClickListener {
        C283784() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113592);
            C28374a.this.bKl();
            C28374a.this.aqX();
            C28374a.this.activity.finish();
            AppMethodBeat.m2505o(113592);
        }
    }

    public abstract String aoy();

    public abstract void bKl();

    public abstract void bKm();

    public C28374a(Activity activity) {
        this.activity = activity;
        this.nOO = C18657c.agw();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onBackPressed() {
        this.activity.finish();
    }

    public void onCreate(Bundle bundle) {
        this.nOU = C26443d.agz();
        LocationInfo locationInfo = this.nOK;
        LocationInfo locationInfo2 = this.nOJ;
        String g = C4988aa.m7402g(C4996ah.doB());
        C4990ab.m7410d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(g)));
        if (g.equals("language_default")) {
            C4988aa.m7399a(this.activity, Locale.ENGLISH);
            g = "en";
        } else {
            C4988aa.m7399a(this.activity, C4988aa.amw(g));
        }
        locationInfo2.nJy = g;
        locationInfo.nJy = g;
        C4990ab.m7410d("MicroMsg.BaseMapUI", "sosomap " + this.nOJ.nJy);
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(2130969801);
        ((FrameLayout) findViewById(2131824670)).addView(C39293d.m66973ep(this.activity));
        this.nOI = new C34412d(this.activity);
        this.nOL = new C28377a();
        this.nLz = this.activity.getIntent().getStringExtra("kRemark");
        this.nOQ = this.activity.getIntent().getStringArrayListExtra("kTags");
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        this.nOG = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
        C4990ab.m7416i("MicroMsg.BaseMapUI", "isPickPoi " + this.nOG);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        C4990ab.m7410d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        bKl();
        this.activity.finish();
        return true;
    }

    public void onResume() {
        C5288y.m8058d(true, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onPause() {
        C5288y.m8058d(false, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onDestroy() {
        this.nOO.mo33925a(this.nOV);
        C4990ab.m7410d("MicroMsg.BaseMapUI", "destroy");
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        this.nOL.nLY.destroy();
        System.gc();
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKi() {
        if (this.nOL.nPd != null && this.nOL.nPe != null) {
            this.nOL.nPd.setText(C44089j.m79293b(this.nOL.nPd.getContext(), this.nLz, this.nOL.nPd.getTextSize()));
            if (this.nOQ == null || this.nOQ.isEmpty()) {
                this.nOL.nPe.setText("");
                return;
            }
            String str = (String) this.nOQ.get(0);
            String string = this.activity.getResources().getString(C25738R.string.bs0);
            CharSequence charSequence = str;
            for (int i = 1; i < this.nOQ.size(); i++) {
                charSequence = charSequence + string + ((String) this.nOQ.get(i));
            }
            this.nOL.nPe.setText(C44089j.m79293b(this.nOL.nPe.getContext(), charSequence, this.nOL.nPe.getTextSize()));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKj() {
        this.nOL.nOY.removeAllViews();
        View inflate = View.inflate(this.activity, 2130969944, null);
        this.nOL.nOY.addView(inflate, new LayoutParams(-1, -2));
        this.nOL.nPd = (TextView) inflate.findViewById(2131825270);
        this.nOL.nPd.setOnClickListener(new C211781());
        this.nOL.nPe = (TextView) inflate.findViewById(2131825271);
        this.nOL.nPe.setOnClickListener(new C283752());
        bKi();
    }

    /* Access modifiers changed, original: protected|final */
    public final String bKk() {
        return C5046bo.m7532bc(this.nLz, "");
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final boolean mo46347b(LocationInfo locationInfo) {
        if (this.nOL.nLY.getIController() == null || !C39283e.m66955j(locationInfo.nJu, locationInfo.nJv)) {
            return false;
        }
        this.nOL.nLY.getIController().animateTo(locationInfo.nJu, locationInfo.nJv);
        return true;
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        C4990ab.m7410d("MicroMsg.BaseMapUI", "initView");
        this.nOL.nPc = (LinearLayout) findViewById(2131825945);
        this.nOL.nLY = (C28354d) findViewById(2131820622);
        this.nOL.nOX = (FrameLayout) findViewById(2131824671);
        this.nOL.nOY = (RelativeLayout) findViewById(2131824673);
        this.nOL.lnh = (ImageView) findViewById(2131825947);
        this.nOL.nOZ = (ImageButton) findViewById(2131825951);
        this.nOL.nPa = findViewById(2131825952);
        this.nOL.nPb = (TextView) findViewById(2131820958);
        this.nOL.titleView = (TextView) findViewById(2131825948);
        this.nOL.nHi = (TextView) findViewById(2131824676);
        this.nOL.titleView.setText(aoy());
        this.nOL.nLY.getIController().setZoom(C34412d.bJM());
        if (!(this.type == 0 || this.type == 3)) {
            this.nOL.nOZ.setVisibility(0);
            this.nOL.nPa.setVisibility(8);
            this.nOL.nOZ.setEnabled(false);
            this.nOL.nOZ.setImageResource(C25738R.drawable.f6899uu);
        }
        this.nOL.nLY.setBuiltInZoomControls(false);
        this.nOL.lnh.setOnClickListener(new C283784());
        this.nOL.nPb.setOnClickListener(new C283765());
        bKm();
        mo46354xE(C4996ah.getResources().getColor(C25738R.color.f12206vy));
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: xE */
    public final void mo46354xE(int i) {
        this.nOL.nPc.setBackgroundColor(i);
        Boolean valueOf = Boolean.valueOf(C5225ah.m7958Nw(i));
        if (valueOf.booleanValue()) {
            this.nOL.lnh.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.nOL.nOZ.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.nOL.titleView.setTextColor(C4996ah.getResources().getColor(C25738R.color.a6a));
        } else {
            this.nOL.lnh.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.nOL.nOZ.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.nOL.titleView.setTextColor(C4996ah.getResources().getColor(C25738R.color.f11785h7));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(C8415j.INVALID_ID);
            if (VERSION.SDK_INT < 23 || C1448h.m3077Mt()) {
                i = VERSION.SDK_INT >= 21 ? C5225ah.m7964s(this.activity.getResources().getColor(C25738R.color.a1h), i) : 0;
            }
            this.activity.getWindow().setStatusBarColor(i);
            if (VERSION.SDK_INT >= 23) {
                View decorView = this.activity.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (valueOf.booleanValue()) {
                    systemUiVisibility &= -8193;
                } else {
                    systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                decorView.setSystemUiVisibility(systemUiVisibility);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            if (4096 == i) {
                if (this.nOL.nPd != null) {
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                    this.nLz = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                    bKi();
                }
            } else if (4100 == i && this.nOL.nPe != null) {
                this.nOQ = intent.getStringArrayListExtra("key_fav_result_list");
                bKi();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqX() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public boolean bKn() {
        return true;
    }
}
