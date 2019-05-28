package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.y;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a extends com.tencent.mm.plugin.k.a {
    public Activity activity;
    protected int czL = 0;
    protected String eUu = "";
    protected ProgressDialog ehJ = null;
    ak handler = new ak(Looper.getMainLooper());
    int nJw;
    protected String nKN = "";
    protected String nLz;
    public String nOE = "";
    protected boolean nOF = false;
    public boolean nOG = false;
    protected Addr nOH = null;
    protected d nOI;
    protected LocationInfo nOJ = new LocationInfo((byte) 0);
    protected LocationInfo nOK = new LocationInfo((byte) 0);
    protected a nOL;
    protected boolean nOM = false;
    protected HashMap<String, c> nON = new HashMap();
    protected com.tencent.mm.modelgeo.c nOO;
    protected boolean nOP = false;
    protected ArrayList<String> nOQ = new ArrayList();
    protected boolean nOR = false;
    protected boolean nOS = false;
    protected com.tencent.mm.plugin.location.model.c nOT = null;
    protected com.tencent.mm.modelgeo.d nOU;
    public com.tencent.mm.modelgeo.c.a nOV = new com.tencent.mm.modelgeo.c.a() {
        public final void b(Addr addr) {
            AppMethodBeat.i(113591);
            ab.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", addr.toString());
            a.this.nOH = addr;
            String agv = addr.agv();
            a.this.nOK.cIK = a.this.activity.getResources().getString(R.string.cn7);
            if (addr.tag != null && addr.tag.equals(a.this.nOK.nJt)) {
                a.this.nOK.nJx = agv;
            } else if (!bo.isNullOrNil(addr.fBg)) {
                a.this.nOL.nOY.setVisibility(0);
            }
            if (addr.tag != null && a.this.nON.containsKey(addr.tag)) {
                c cVar = (c) a.this.nON.get(addr.tag);
                cVar.setText(cVar.getPreText() + agv);
            }
            AppMethodBeat.o(113591);
        }
    };
    protected float neG = 0.0f;
    protected float neH = 0.0f;
    DisplayMetrics njz = null;
    protected int type = 0;

    class a {
        ImageView lnh;
        TextView nHi;
        com.tencent.mm.plugin.k.d nLY;
        FrameLayout nOX;
        RelativeLayout nOY;
        ImageButton nOZ;
        View nPa;
        TextView nPb;
        LinearLayout nPc;
        TextView nPd;
        TextView nPe;
        TextView titleView;

        a() {
        }
    }

    public abstract String aoy();

    public abstract void bKl();

    public abstract void bKm();

    public a(Activity activity) {
        this.activity = activity;
        this.nOO = com.tencent.mm.modelgeo.c.agw();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onBackPressed() {
        this.activity.finish();
    }

    public void onCreate(Bundle bundle) {
        this.nOU = com.tencent.mm.modelgeo.d.agz();
        LocationInfo locationInfo = this.nOK;
        LocationInfo locationInfo2 = this.nOJ;
        String g = aa.g(ah.doB());
        ab.d("MicroMsg.BaseMapUI", " initLanguage ".concat(String.valueOf(g)));
        if (g.equals("language_default")) {
            aa.a(this.activity, Locale.ENGLISH);
            g = "en";
        } else {
            aa.a(this.activity, aa.amw(g));
        }
        locationInfo2.nJy = g;
        locationInfo.nJy = g;
        ab.d("MicroMsg.BaseMapUI", "sosomap " + this.nOJ.nJy);
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(R.layout.a6a);
        ((FrameLayout) findViewById(R.id.c_i)).addView(d.ep(this.activity));
        this.nOI = new d(this.activity);
        this.nOL = new a();
        this.nLz = this.activity.getIntent().getStringExtra("kRemark");
        this.nOQ = this.activity.getIntent().getStringArrayListExtra("kTags");
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        this.nOG = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
        ab.i("MicroMsg.BaseMapUI", "isPickPoi " + this.nOG);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        ab.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        bKl();
        this.activity.finish();
        return true;
    }

    public void onResume() {
        y.d(true, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onPause() {
        y.d(false, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onDestroy() {
        this.nOO.a(this.nOV);
        ab.d("MicroMsg.BaseMapUI", "destroy");
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
            this.nOL.nPd.setText(j.b(this.nOL.nPd.getContext(), this.nLz, this.nOL.nPd.getTextSize()));
            if (this.nOQ == null || this.nOQ.isEmpty()) {
                this.nOL.nPe.setText("");
                return;
            }
            String str = (String) this.nOQ.get(0);
            String string = this.activity.getResources().getString(R.string.bs0);
            CharSequence charSequence = str;
            for (int i = 1; i < this.nOQ.size(); i++) {
                charSequence = charSequence + string + ((String) this.nOQ.get(i));
            }
            this.nOL.nPe.setText(j.b(this.nOL.nPe.getContext(), charSequence, this.nOL.nPe.getTextSize()));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKj() {
        this.nOL.nOY.removeAllViews();
        View inflate = View.inflate(this.activity, R.layout.a_6, null);
        this.nOL.nOY.addView(inflate, new LayoutParams(-1, -2));
        this.nOL.nPd = (TextView) inflate.findViewById(R.id.cpr);
        this.nOL.nPd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113589);
                Intent intent = new Intent(a.this.activity, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", a.this.bKk());
                intent.putExtra("key_hint", a.this.getString(R.string.cnk));
                intent.putExtra("Kwebmap_locaion", a.this.nOJ.nJx);
                intent.putExtra("kFavInfoLocalId", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", a.this.activity.getIntent().getStringExtra("kRemark"));
                a.this.activity.startActivityForResult(intent, 4096);
                AppMethodBeat.o(113589);
            }
        });
        this.nOL.nPe = (TextView) inflate.findViewById(R.id.cps);
        this.nOL.nPe.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113590);
                Intent intent = new Intent();
                intent.putExtra("key_fav_item_id", a.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("key_fav_result_list", a.this.activity.getIntent().getStringArrayListExtra("kTags"));
                b.a(a.this.activity, ".ui.FavTagEditUI", intent, 4100);
                AppMethodBeat.o(113590);
            }
        });
        bKi();
    }

    /* Access modifiers changed, original: protected|final */
    public final String bKk() {
        return bo.bc(this.nLz, "");
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean b(LocationInfo locationInfo) {
        if (this.nOL.nLY.getIController() == null || !e.j(locationInfo.nJu, locationInfo.nJv)) {
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
        ab.d("MicroMsg.BaseMapUI", "initView");
        this.nOL.nPc = (LinearLayout) findViewById(R.id.d80);
        this.nOL.nLY = (com.tencent.mm.plugin.k.d) findViewById(R.id.be);
        this.nOL.nOX = (FrameLayout) findViewById(R.id.c_j);
        this.nOL.nOY = (RelativeLayout) findViewById(R.id.c_l);
        this.nOL.lnh = (ImageView) findViewById(R.id.d82);
        this.nOL.nOZ = (ImageButton) findViewById(R.id.d86);
        this.nOL.nPa = findViewById(R.id.d87);
        this.nOL.nPb = (TextView) findViewById(R.id.kh);
        this.nOL.titleView = (TextView) findViewById(R.id.d83);
        this.nOL.nHi = (TextView) findViewById(R.id.c_o);
        this.nOL.titleView.setText(aoy());
        this.nOL.nLY.getIController().setZoom(d.bJM());
        if (!(this.type == 0 || this.type == 3)) {
            this.nOL.nOZ.setVisibility(0);
            this.nOL.nPa.setVisibility(8);
            this.nOL.nOZ.setEnabled(false);
            this.nOL.nOZ.setImageResource(R.drawable.uu);
        }
        this.nOL.nLY.setBuiltInZoomControls(false);
        this.nOL.lnh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113592);
                a.this.bKl();
                a.this.aqX();
                a.this.activity.finish();
                AppMethodBeat.o(113592);
            }
        });
        this.nOL.nPb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        bKm();
        xE(ah.getResources().getColor(R.color.vy));
    }

    /* Access modifiers changed, original: protected|final */
    public final void xE(int i) {
        this.nOL.nPc.setBackgroundColor(i);
        Boolean valueOf = Boolean.valueOf(com.tencent.mm.ui.ah.Nw(i));
        if (valueOf.booleanValue()) {
            this.nOL.lnh.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.nOL.nOZ.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.nOL.titleView.setTextColor(ah.getResources().getColor(R.color.a6a));
        } else {
            this.nOL.lnh.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.nOL.nOZ.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            this.nOL.titleView.setTextColor(ah.getResources().getColor(R.color.h7));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(android.support.v4.widget.j.INVALID_ID);
            if (VERSION.SDK_INT < 23 || h.Mt()) {
                i = VERSION.SDK_INT >= 21 ? com.tencent.mm.ui.ah.s(this.activity.getResources().getColor(R.color.a1h), i) : 0;
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
