package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.x.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.a.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class GestureGalleryUI extends MMActivity implements b {
    private String flh = "";
    private String flp = null;
    private Bundle jWy;
    private boolean jYD = false;
    private e jYE;
    private ImageView kkl;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private ak mHandler = new ak();
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(25379);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(25379);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25380);
            nr nrVar = (nr) bVar;
            if (nrVar == null) {
                ab.e("MicroMsg.GestureGalleryUI", "RecogQBarOfImageFileResultEvent is null.");
            } else if (nrVar == null || nrVar.cJX.filePath.equals(GestureGalleryUI.this.riz)) {
                ab.i("MicroMsg.GestureGalleryUI", "recog result: %s", nrVar.cJX.result);
                if (GestureGalleryUI.this.sue.isEmpty() || GestureGalleryUI.this.sue.contains(Integer.valueOf(nrVar.cJX.cvn))) {
                    GestureGalleryUI.this.sua = nrVar.cJX.cvn;
                    GestureGalleryUI.this.riC = nrVar.cJX.result;
                    GestureGalleryUI.this.sub = nrVar.cJX.cvo;
                    GestureGalleryUI.this.riz = null;
                    if (!bo.isNullOrNil(GestureGalleryUI.this.riC) && GestureGalleryUI.this.stY.isShowing()) {
                        GestureGalleryUI.b(GestureGalleryUI.this);
                    }
                } else {
                    ab.i("MicroMsg.GestureGalleryUI", "Result codeType(%s) error.", Integer.valueOf(nrVar.cJX.cvn));
                }
            } else {
                ab.e("MicroMsg.GestureGalleryUI", "not same filepath");
            }
            AppMethodBeat.o(25380);
            return false;
        }
    };
    private String riC;
    private c riJ = new c<kv>() {
        {
            AppMethodBeat.i(25381);
            this.xxI = kv.class.getName().hashCode();
            AppMethodBeat.o(25381);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25382);
            kv kvVar = (kv) bVar;
            if (kvVar != null) {
                ab.i("MicroMsg.GestureGalleryUI", "notify Event: %d", Integer.valueOf(kvVar.cGM.cGK));
                if (kvVar.cGM.activity == GestureGalleryUI.this && kvVar.cGM.ctB.equals(GestureGalleryUI.this.riC)) {
                    switch (kvVar.cGM.cGK) {
                        case 3:
                            GestureGalleryUI.this.finish();
                            break;
                    }
                }
                ab.e("MicroMsg.GestureGalleryUI", "not the same");
            } else {
                ab.e("MicroMsg.GestureGalleryUI", "NotifyDealQBarStrResultEvent is null.");
            }
            AppMethodBeat.o(25382);
            return false;
        }
    };
    private volatile String riz;
    private int rpA = 0;
    private int rpB = 0;
    private float rpz = 1.0f;
    private a stS;
    MMGestureGallery stT;
    private String stU;
    private x stV;
    private boolean stW = false;
    private boolean stX = false;
    private d stY;
    private volatile boolean stZ;
    private int sua;
    private int sub;
    private int suc;
    private final Set<Integer> sud = new HashSet();
    private final Set<Integer> sue = new HashSet();
    private boolean suf = false;
    private c<bu> sug = new c<bu>() {
        {
            AppMethodBeat.i(25375);
            this.xxI = bu.class.getName().hashCode();
            AppMethodBeat.o(25375);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25376);
            GestureGalleryUI.this.finish();
            AppMethodBeat.o(25376);
            return false;
        }
    };
    private List<String> suh = new ArrayList();
    private int sui = -1;
    private int suj = -1;
    private boolean suk = false;
    private OnItemSelectedListener sul = new OnItemSelectedListener() {
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(25378);
            GestureGalleryUI.this.sui = i;
            GestureGalleryUI.this.setMMTitle((GestureGalleryUI.this.sui + 1) + " / " + GestureGalleryUI.this.suh.size());
            ab.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(i)));
            GestureGalleryUI.this.stU = GestureGalleryUI.this.stV.c((String) GestureGalleryUI.this.suh.get(i), GestureGalleryUI.this.type, i, GestureGalleryUI.this.flp);
            if (bo.isNullOrNil(GestureGalleryUI.this.stU)) {
                GestureGalleryUI.this.stU = (String) GestureGalleryUI.this.suh.get(i);
            }
            GestureGalleryUI.e(GestureGalleryUI.this);
            AppMethodBeat.o(25378);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private int type = 0;

    class a extends BaseAdapter {

        class a {
            ProgressBar rte;
            MMAnimateView suq;

            a() {
            }
        }

        public final int getCount() {
            AppMethodBeat.i(25396);
            ab.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.this.suh.size());
            int size = GestureGalleryUI.this.suh.size();
            AppMethodBeat.o(25396);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(25397);
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.o(25397);
            return valueOf;
        }

        public final View cDI() {
            AppMethodBeat.i(25398);
            View Fp = Fp(GestureGalleryUI.this.stT.getSelectedItemPosition());
            AppMethodBeat.o(25398);
            return Fp;
        }

        private View Fp(int i) {
            AppMethodBeat.i(25399);
            int firstVisiblePosition = GestureGalleryUI.this.stT.getFirstVisiblePosition();
            int childCount = (GestureGalleryUI.this.stT.getChildCount() + firstVisiblePosition) - 1;
            View view;
            if (i < firstVisiblePosition || i > childCount) {
                view = GestureGalleryUI.this.stT.getAdapter().getView(i, null, GestureGalleryUI.this.stT);
                AppMethodBeat.o(25399);
                return view;
            }
            view = GestureGalleryUI.this.stT.getChildAt(i - firstVisiblePosition);
            AppMethodBeat.o(25399);
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(25400);
            if (view == null) {
                aVar = new a();
                view = View.inflate(GestureGalleryUI.this, R.layout.an2, null);
                aVar.rte = (ProgressBar) view.findViewById(R.id.rj);
                aVar.suq = (MMAnimateView) view.findViewById(R.id.bl);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            String str = (String) GestureGalleryUI.this.suh.get(i);
            if (!com.tencent.mm.vfs.e.ct(str)) {
                str = GestureGalleryUI.this.stV.c(str, GestureGalleryUI.this.type, i, GestureGalleryUI.this.flp);
            }
            if (bo.isNullOrNil(str)) {
                aVar.rte.setVisibility(0);
                aVar.suq.setVisibility(8);
                AppMethodBeat.o(25400);
            } else {
                Bitmap bitmap;
                aVar.rte.setVisibility(8);
                if (str == null) {
                    bitmap = null;
                } else {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(str, options);
                    if (bitmap != null) {
                        ab.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", bitmap.toString());
                        bitmap.recycle();
                    }
                    bitmap = com.tencent.mm.sdk.platformtools.d.aml(str);
                    if (bitmap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                        Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
                        String str2 = "MicroMsg.GestureGalleryUI";
                        String str3 = "Progressive jpeg, result isNull:%b";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
                        ab.i(str2, str3, objArr);
                        bitmap = decodeAsBitmap;
                    }
                    if (bitmap == null) {
                        ab.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                        bitmap = null;
                    }
                }
                if (GestureGalleryUI.this.stX && (bitmap == null || bitmap.isRecycled())) {
                    GestureGalleryUI.this.finish();
                    AppMethodBeat.o(25400);
                } else {
                    int i2;
                    if (bitmap == null || bitmap.isRecycled() || (bitmap.getWidth() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && bitmap.getHeight() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0 && r.amo(str)) {
                        if (i == GestureGalleryUI.this.suj) {
                            GestureGalleryUI.this.suf = false;
                        }
                        try {
                            aVar.suq.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            aVar.suq.setVisibility(0);
                            aVar.suq.setImageFilePath(str);
                        } catch (Exception e) {
                            ab.e("MicroMsg.GestureGalleryUI", bo.l(e));
                            aVar.suq.setVisibility(0);
                            aVar.suq.setImageBitmap(bitmap);
                        }
                        AppMethodBeat.o(25400);
                    } else {
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            aVar.suq.setVisibility(8);
                            view = new MultiTouchImageView(GestureGalleryUI.this, bitmap.getWidth(), bitmap.getHeight());
                            if (VERSION.SDK_INT == 20) {
                                view.setLayerType(1, null);
                            } else {
                                n.w(view, bitmap.getWidth(), bitmap.getHeight());
                            }
                            view.setEnableHorLongBmpMode(false);
                            view.setLayoutParams(new LayoutParams(-1, -1));
                            view.setImageBitmap(bitmap);
                            AppMethodBeat.o(25400);
                        }
                        AppMethodBeat.o(25400);
                    }
                }
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GestureGalleryUI() {
        AppMethodBeat.i(25401);
        AppMethodBeat.o(25401);
    }

    public final void d(String str, String str2, int i) {
        AppMethodBeat.i(25402);
        if (this.stS != null) {
            if (i == this.stT.getSelectedItemPosition()) {
                this.stU = str2;
                ab.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", this.stU, str);
            }
            this.stS.notifyDataSetChanged();
        }
        AppMethodBeat.o(25402);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25403);
        super.onCreate(bundle);
        this.jWy = bundle;
        this.sug.dnU();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            getWindow().addFlags(67108864);
        }
        fullScreenNoTitleBar(true);
        this.stW = getIntent().getBooleanExtra("isFromWebView", false);
        this.stX = getIntent().getBooleanExtra("isOuntLink", false);
        this.flh = getIntent().getStringExtra("IsFromWebViewReffer");
        this.stZ = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
        this.suf = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
        this.suc = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
        int[] intArrayExtra = getIntent().getIntArrayExtra("scanCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                this.sud.add(Integer.valueOf(valueOf));
            }
        }
        intArrayExtra = getIntent().getIntArrayExtra("scanResultCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf2 : intArrayExtra) {
                this.sue.add(Integer.valueOf(valueOf2));
            }
        }
        this.flp = getIntent().getStringExtra("cookie");
        ab.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s", Boolean.valueOf(this.stW), this.flh, this.flp);
        this.stV = new x(this.stW, this.flh);
        x xVar = this.stV;
        ab.d("MicroMsg.GetPicService", "addListener :" + hashCode());
        xVar.flj = this;
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        com.tencent.mm.sdk.b.a.xxA.c(this.riJ);
        initView();
        this.suk = false;
        AppMethodBeat.o(25403);
    }

    public void onDestroy() {
        AppMethodBeat.i(25404);
        super.onDestroy();
        x xVar = this.stV;
        ab.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        xVar.flj = null;
        xVar = this.stV;
        if (xVar.flf != null) {
            xVar.flf.fln = true;
        }
        xVar.flf = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        com.tencent.mm.sdk.b.a.xxA.d(this.riJ);
        this.sug.dead();
        eY(this);
        AppMethodBeat.o(25404);
    }

    public void onPause() {
        AppMethodBeat.i(25405);
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        o.JV(2);
        AppMethodBeat.o(25405);
    }

    public void onResume() {
        AppMethodBeat.i(25406);
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        o.JV(1);
        AppMethodBeat.o(25406);
    }

    public void onStop() {
        AppMethodBeat.i(25407);
        super.onStop();
        if (this.riC != null) {
            am amVar = new am();
            amVar.ctA.activity = this;
            amVar.ctA.ctB = this.riC;
            com.tencent.mm.sdk.b.a.xxA.m(amVar);
            this.riC = null;
            this.sub = 0;
            this.sua = 0;
        }
        AppMethodBeat.o(25407);
    }

    public final int getLayoutId() {
        return R.layout.an1;
    }

    public final void initView() {
        int i;
        AppMethodBeat.i(25408);
        String nullAsNil = bo.nullAsNil(getIntent().getStringExtra("nowUrl"));
        this.type = getIntent().getIntExtra("type", 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String nullAsNil2 = bo.nullAsNil(getIntent().getStringExtra("htmlData"));
            i = 0;
            while (i >= 0) {
                int indexOf = nullAsNil2.indexOf("weixin://viewimage/", i);
                if (indexOf < 0) {
                    break;
                }
                i = nullAsNil2.indexOf("\"", indexOf);
                if (i < 0) {
                    break;
                }
                String substring = nullAsNil2.substring(indexOf + 19, i);
                ab.d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i + " url:" + substring);
                this.suh.add(substring);
            }
        } else {
            this.suh = Arrays.asList(stringArrayExtra);
        }
        for (i = 0; i < this.suh.size(); i++) {
            if (nullAsNil.equals(this.suh.get(i))) {
                this.sui = i;
                break;
            }
        }
        this.suj = this.sui;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25383);
                GestureGalleryUI.this.bcW();
                AppMethodBeat.o(25383);
                return true;
            }
        });
        this.kkl = (ImageView) findViewById(R.id.adg);
        this.kkl.setLayerType(2, null);
        this.stS = new a();
        this.stT = (MMGestureGallery) findViewById(R.id.adi);
        this.stT.setVisibility(0);
        this.stT.setVerticalFadingEdgeEnabled(false);
        this.stT.setHorizontalFadingEdgeEnabled(false);
        this.stT.setAdapter(this.stS);
        this.stT.setSelection(this.sui);
        this.stT.setOnItemSelectedListener(this.sul);
        this.stT.setSingleClickOverListener(new f() {
            public final void bcX() {
                AppMethodBeat.i(25384);
                GestureGalleryUI.this.bcW();
                AppMethodBeat.o(25384);
            }
        });
        i = getIntent().getIntExtra("nevNext", 1);
        this.stT.setLongClickOverListener(new MMGestureGallery.c() {
            public final void bvE() {
                AppMethodBeat.i(25386);
                if (1 == i) {
                    v.b y = v.Zp().y("basescanui@datacenter", true);
                    y.j("key_basescanui_screen_x", Integer.valueOf(GestureGalleryUI.this.stT.getXDown()));
                    y.j("key_basescanui_screen_y", Integer.valueOf(GestureGalleryUI.this.stT.getYDown()));
                    GestureGalleryUI.b(GestureGalleryUI.this);
                    AppMethodBeat.o(25386);
                    return;
                }
                if (2 == i) {
                    h.a(GestureGalleryUI.this, null, GestureGalleryUI.this.mController.ylL.getResources().getStringArray(R.array.ag), "", false, new h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(25385);
                            switch (i) {
                                case 0:
                                    GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.this.stU);
                                    AppMethodBeat.o(25385);
                                    return;
                                case 1:
                                    GestureGalleryUI gestureGalleryUI = GestureGalleryUI.this;
                                    String c = GestureGalleryUI.this.stU;
                                    if (c != null && c.length() != 0) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Retr_File_Name", c);
                                        intent.putExtra("Retr_Msg_Type", 0);
                                        intent.putExtra("Retr_Compress_Type", 0);
                                        com.tencent.mm.plugin.subapp.b.gkE.k(intent, gestureGalleryUI.mController.ylL);
                                        break;
                                    }
                                    AppMethodBeat.o(25385);
                                    return;
                            }
                            AppMethodBeat.o(25385);
                        }
                    });
                }
                AppMethodBeat.o(25386);
            }
        });
        this.jYE = new e(this);
        AppMethodBeat.o(25408);
    }

    public void onStart() {
        AppMethodBeat.i(25409);
        Bundle bundle = this.jWy;
        if (!this.jYD && this.suf) {
            this.jYD = true;
            this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
            this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
            this.kks = getIntent().getIntExtra("img_gallery_width", 0);
            this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
            this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
            if (bundle == null) {
                this.stT.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        AppMethodBeat.i(25387);
                        GestureGalleryUI.this.stT.getViewTreeObserver().removeOnPreDrawListener(this);
                        GestureGalleryUI.this.jYE.a(GestureGalleryUI.this.stT, null, null);
                        GestureGalleryUI.e(GestureGalleryUI.this);
                        AppMethodBeat.o(25387);
                        return true;
                    }
                });
            }
        }
        super.onStart();
        AppMethodBeat.o(25409);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(25411);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.o(25411);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(25411);
        return dispatchKeyEvent;
    }

    private static void eY(Context context) {
        AppMethodBeat.i(138616);
        if (VERSION.SDK_INT < 19 || VERSION.SDK_INT > 22) {
            AppMethodBeat.o(138616);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(138616);
            return;
        }
        String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        AppMethodBeat.o(138616);
                        return;
                    }
                }
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(138616);
    }

    public final void bcW() {
        AppMethodBeat.i(25410);
        if (this.stT.getSelectedItemPosition() != this.suj || !this.suf) {
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(25410);
        } else if (this.suk || this.stS == null) {
            ab.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
            AppMethodBeat.o(25410);
        } else {
            int i;
            ab.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
            int width = this.stT.getWidth();
            int height = this.stT.getHeight();
            int selectedItemPosition = this.stT.getSelectedItemPosition();
            String str = (String) this.suh.get(selectedItemPosition);
            if (!com.tencent.mm.vfs.e.ct(str)) {
                str = this.stV.c(str, this.type, selectedItemPosition, this.flp);
            }
            if (bo.isNullOrNil(str)) {
                i = height;
            } else {
                Options amj = com.tencent.mm.sdk.platformtools.d.amj(str);
                i = (int) (((float) amj.outHeight) * (((float) width) / ((float) amj.outWidth)));
                if (i > this.stT.getHeight()) {
                    if (((double) i) < ((double) this.stT.getHeight()) * 2.5d) {
                        this.kkt = (this.stT.getHeight() * this.kkt) / i;
                    }
                    i = this.stT.getHeight();
                }
            }
            this.jYE.hw(width, i);
            this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
            if (((double) this.rpz) != 1.0d) {
                this.jYE.zEZ = 1.0f / this.rpz;
                if (!(this.rpA == 0 && this.rpB == 0)) {
                    this.jYE.hy(((int) (((float) (this.stT.getWidth() / 2)) * (1.0f - this.rpz))) + this.rpA, (int) (((float) ((this.stT.getHeight() / 2) + this.rpB)) - (((float) (i / 2)) * this.rpz)));
                }
            }
            this.jYE.a(this.stT, this.kkl, new e.b() {
                public final void onAnimationStart() {
                    AppMethodBeat.i(25390);
                    GestureGalleryUI.this.suk = true;
                    GestureGalleryUI.this.mHandler.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(25388);
                            View cDI = GestureGalleryUI.this.stS.cDI();
                            if (cDI instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) cDI).dzA();
                            }
                            AppMethodBeat.o(25388);
                        }
                    }, 20);
                    AppMethodBeat.o(25390);
                }

                public final void onAnimationEnd() {
                    AppMethodBeat.i(25391);
                    GestureGalleryUI.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(25389);
                            GestureGalleryUI.this.finish();
                            GestureGalleryUI.this.overridePendingTransition(0, 0);
                            AppMethodBeat.o(25389);
                        }
                    });
                    GestureGalleryUI.this.suk = false;
                    AppMethodBeat.o(25391);
                }
            }, null);
            AppMethodBeat.o(25410);
        }
    }

    static /* synthetic */ void b(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(25412);
        if (gestureGalleryUI.stY == null) {
            gestureGalleryUI.stY = new d(gestureGalleryUI.mController.ylL, 1, false);
        }
        gestureGalleryUI.stY.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(25394);
                lVar.clear();
                lVar.hi(1, R.string.dhh);
                lVar.hi(2, R.string.dwx);
                lVar.hi(3, R.string.dcq);
                if (GestureGalleryUI.i(GestureGalleryUI.this)) {
                    if (com.tencent.mm.plugin.scanner.a.BR(GestureGalleryUI.this.sua)) {
                        lVar.e(4, GestureGalleryUI.this.getString(R.string.diy));
                    } else if (com.tencent.mm.plugin.scanner.a.ba(GestureGalleryUI.this.sua, GestureGalleryUI.this.riC)) {
                        lVar.e(4, GestureGalleryUI.this.getString(R.string.diz));
                    } else if (com.tencent.mm.plugin.scanner.a.BQ(GestureGalleryUI.this.sua)) {
                        lVar.e(4, GestureGalleryUI.this.getString(R.string.dix));
                    } else {
                        lVar.e(4, GestureGalleryUI.this.getString(R.string.diy));
                    }
                }
                if (GestureGalleryUI.this.stZ && bo.isNullOrNil(GestureGalleryUI.this.riC) && aw.Rg().acS() != 0) {
                    np npVar = new np();
                    npVar.cJU.filePath = GestureGalleryUI.this.stU;
                    npVar.cJU.cJV = new HashSet(GestureGalleryUI.this.sud);
                    GestureGalleryUI.this.riz = GestureGalleryUI.this.stU;
                    com.tencent.mm.sdk.b.a.xxA.m(npVar);
                }
                AppMethodBeat.o(25394);
            }
        };
        gestureGalleryUI.stY.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(25395);
                switch (menuItem.getItemId()) {
                    case 1:
                        if (bo.isNullOrNil(GestureGalleryUI.this.stU)) {
                            ab.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
                            AppMethodBeat.o(25395);
                            return;
                        } else if (r.amo(GestureGalleryUI.this.stU)) {
                            EmojiInfo Jd;
                            EmojiInfo Jd2 = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(com.tencent.mm.vfs.e.atg(GestureGalleryUI.this.stU));
                            if (Jd2 == null) {
                                com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                                ah.getContext();
                                Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(emojiMgr.Jf(GestureGalleryUI.this.stU));
                            } else {
                                Jd = Jd2;
                            }
                            long asZ = Jd == null ? 0 : com.tencent.mm.vfs.e.asZ(Jd.dve());
                            String c = Jd == null ? GestureGalleryUI.this.stU : Jd.dve();
                            Options options = new Options();
                            options.inJustDecodeBounds = true;
                            int i2;
                            if ((com.tencent.mm.sdk.platformtools.d.decodeFile(c, options) == null || options.outHeight <= com.tencent.mm.m.b.Na()) && options.outWidth <= com.tencent.mm.m.b.Na()) {
                                i2 = 0;
                            } else {
                                i2 = true;
                            }
                            if (asZ > ((long) com.tencent.mm.m.b.Nb()) || i2 != 0) {
                                h.a(GestureGalleryUI.this.mController.ylL, GestureGalleryUI.this.getString(R.string.b9x), "", GestureGalleryUI.this.getString(R.string.cd_), null);
                                AppMethodBeat.o(25395);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", Jd == null ? "" : Jd.Aq());
                            intent.putExtra("Retr_Msg_Type", 5);
                            intent.putExtra("Retr_MsgImgScene", 1);
                            com.tencent.mm.plugin.subapp.b.gkE.k(intent, GestureGalleryUI.this.mController.ylL);
                            AppMethodBeat.o(25395);
                            return;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Retr_File_Name", GestureGalleryUI.this.stU);
                            intent2.putExtra("Retr_Compress_Type", 0);
                            intent2.putExtra("Retr_Msg_Type", 0);
                            com.tencent.mm.plugin.subapp.b.gkE.k(intent2, GestureGalleryUI.this.mController.ylL);
                            AppMethodBeat.o(25395);
                            return;
                        }
                    case 2:
                        if (!(GestureGalleryUI.this.stU == null || GestureGalleryUI.this.stU.equals(""))) {
                            aw.ZK();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                com.tencent.mm.pluginsdk.ui.tools.n.j(GestureGalleryUI.this.stU, GestureGalleryUI.this);
                                AppMethodBeat.o(25395);
                                return;
                            }
                            t.hO(GestureGalleryUI.this);
                            AppMethodBeat.o(25395);
                            return;
                        }
                    case 3:
                        cl clVar = new cl();
                        com.tencent.mm.pluginsdk.model.e.a(clVar, 1, GestureGalleryUI.this.stU);
                        clVar.cvA.activity = GestureGalleryUI.this;
                        clVar.cvA.cvH = 32;
                        com.tencent.mm.sdk.b.a.xxA.m(clVar);
                        AppMethodBeat.o(25395);
                        return;
                    case 4:
                        ab.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
                        cf cfVar = new cf();
                        cfVar.cvm.activity = GestureGalleryUI.this;
                        cfVar.cvm.ctB = GestureGalleryUI.this.riC;
                        cfVar.cvm.cvn = GestureGalleryUI.this.sua;
                        cfVar.cvm.cvo = GestureGalleryUI.this.sub;
                        cfVar.cvm.scene = GestureGalleryUI.this.suc;
                        cfVar.cvm.cvs = GestureGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
                        com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                        break;
                }
                AppMethodBeat.o(25395);
            }
        };
        gestureGalleryUI.stY.zQf = new com.tencent.mm.ui.widget.a.d.a() {
            public final void onDismiss() {
            }
        };
        if (!gestureGalleryUI.mController.ylL.isFinishing()) {
            gestureGalleryUI.stY.cpD();
        }
        AppMethodBeat.o(25412);
    }

    static /* synthetic */ void e(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(25414);
        if (gestureGalleryUI.suf) {
            gestureGalleryUI.stT.setGalleryScaleListener(new MMGestureGallery.b() {
                public final void aa(float f, float f2) {
                    float f3 = 1.0f;
                    AppMethodBeat.i(25392);
                    float height = 1.0f - (f2 / ((float) GestureGalleryUI.this.stT.getHeight()));
                    if (height <= 1.0f) {
                        f3 = height;
                    }
                    ab.d("MicroMsg.GestureGalleryUI", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
                    GestureGalleryUI.this.rpz = f3;
                    View cDI = GestureGalleryUI.this.stS.cDI();
                    if (cDI != null) {
                        cDI.setPivotX((float) (GestureGalleryUI.this.stT.getWidth() / 2));
                        cDI.setPivotY((float) (GestureGalleryUI.this.stT.getHeight() / 2));
                        cDI.setScaleX(f3);
                        cDI.setScaleY(f3);
                        cDI.setTranslationX(f);
                        cDI.setTranslationY(f2);
                        GestureGalleryUI.this.kkl.setAlpha(f3);
                        AppMethodBeat.o(25392);
                        return;
                    }
                    ab.d("MicroMsg.GestureGalleryUI", "runDragAnimation contentView is null !!");
                    AppMethodBeat.o(25392);
                }

                public final void ab(float f, float f2) {
                    AppMethodBeat.i(25393);
                    GestureGalleryUI.this.rpA = (int) f;
                    GestureGalleryUI.this.rpB = (int) f2;
                    AppMethodBeat.o(25393);
                }
            });
        }
        AppMethodBeat.o(25414);
    }

    static /* synthetic */ boolean i(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(25415);
        if (!gestureGalleryUI.stZ || bo.isNullOrNil(gestureGalleryUI.riC)) {
            AppMethodBeat.o(25415);
            return false;
        }
        AppMethodBeat.o(25415);
        return true;
    }
}
