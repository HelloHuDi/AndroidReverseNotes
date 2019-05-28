package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends i {
    m nQG;
    private l nQI;
    private NewMyLocationButton nQU;
    private f nQV;
    View nQW;
    private d nQX;
    Map<String, String> nQY;
    int nQZ;
    View nRa;

    static class a extends AsyncTask<String, Integer, String> {
        private final WeakReference<Context> nRe;
        private final WeakReference<View> nRf;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Object obj;
            String obj2;
            AppMethodBeat.i(113709);
            String[] strArr = (String[]) objArr;
            String str = "";
            final Context context = (Context) this.nRe.get();
            if (context != null) {
                if (!at.isNetworkConnected(context)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(113703);
                            Toast.makeText(context, context.getString(R.string.evl), 0).show();
                            AppMethodBeat.o(113703);
                        }
                    });
                    ab.e("MicroMsg.TrackMapUI", "fail, network not ready");
                    obj2 = str;
                } else if (!com.tencent.mm.compatible.util.f.Mn()) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(113704);
                            Toast.makeText(context, context.getString(R.string.evn), 0).show();
                            AppMethodBeat.o(113704);
                        }
                    });
                    ab.e("MicroMsg.TrackMapUI", "fail, sdcard not ready");
                    obj2 = str;
                } else if (strArr.length == 1) {
                    obj2 = Qd(strArr[0]);
                }
                AppMethodBeat.o(113709);
                return obj2;
            }
            obj2 = str;
            AppMethodBeat.o(113709);
            return obj2;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(113708);
            String str = (String) obj;
            View view = (View) this.nRf.get();
            if (view != null) {
                view.setVisibility(8);
            }
            Context context = (Context) this.nRe.get();
            if (context == null) {
                AppMethodBeat.o(113708);
                return;
            }
            ab.d("MicroMsg.TrackMapUI", "json string: ".concat(String.valueOf(str)));
            try {
                if (!bo.isNullOrNil(str)) {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("apkInfos");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        Intent intent = new Intent();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject == null) {
                                ab.d("MicroMsg.TrackMapUI", "get json item failure, index: ".concat(String.valueOf(i)));
                            } else if (optJSONObject.optString("cid").equals("00008")) {
                                String optString = optJSONObject.optString("apkPath");
                                long j = 0;
                                String optString2 = optJSONObject.optString("size");
                                if (TextUtils.isDigitsOnly(optString2)) {
                                    j = Long.valueOf(optString2).longValue();
                                }
                                ab.d("MicroMsg.TrackMapUI", "url: %s, md5: %s, size: %s", optString, optJSONObject.optString("md5"), Long.valueOf(j));
                                if (j > 0 && !com.tencent.mm.compatible.util.f.eW(j)) {
                                    Toast.makeText(context, context.getString(R.string.evm), 0).show();
                                    ab.e("MicroMsg.TrackMapUI", "fail, not enough space, require size = ".concat(String.valueOf(j)));
                                    AppMethodBeat.o(113708);
                                    return;
                                } else if (bo.isNullOrNil(optString)) {
                                    ab.e("MicroMsg.TrackMapUI", "doAddDownloadTask fail, url is null");
                                    AppMethodBeat.o(113708);
                                    return;
                                } else {
                                    intent.putExtra("task_name", "TencentMap");
                                    intent.putExtra("task_url", optString);
                                    intent.putExtra("task_size", j);
                                    intent.putExtra("file_md5", r5);
                                    intent.putExtra("thumb_url", "https://3gimg.qq.com/tencentMapTouch/app/download/wx_android_download_ico.png");
                                    intent.putExtra("title", "腾讯地图");
                                    intent.addFlags(268435456);
                                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
                                    AppMethodBeat.o(113708);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.o(113708);
                        return;
                    }
                    ab.d("MicroMsg.TrackMapUI", "get json array failure, key=%s.", "apkInfos");
                    Toast.makeText(context, context.getString(R.string.evk), 0).show();
                }
                AppMethodBeat.o(113708);
            } catch (Exception e) {
                ab.e("MicroMsg.TrackMapUI", "deal json string failure, msg: %s.", e.getMessage());
                Toast.makeText(context, context.getString(R.string.evk), 0).show();
                AppMethodBeat.o(113708);
            }
        }

        a(Context context, View view) {
            AppMethodBeat.i(113705);
            this.nRe = new WeakReference(context);
            this.nRf = new WeakReference(view);
            AppMethodBeat.o(113705);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.i(113706);
            View view = (View) this.nRf.get();
            if (view != null) {
                view.setVisibility(0);
            }
            AppMethodBeat.o(113706);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A:{SYNTHETIC, Splitter:B:17:0x0066} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static String Qd(String str) {
            String str2;
            Exception e;
            AppMethodBeat.i(113707);
            String str3 = "";
            InputStream inputStream = null;
            try {
                inputStream = new URL(str).openStream();
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                int read = inputStream.read(bArr);
                str2 = new String(bArr);
                try {
                    ab.d("MicroMsg.TrackMapUI", "json length: ".concat(String.valueOf(read)));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            ab.e("MicroMsg.TrackMapUI", "download json, close input stream failure, msg: %s.", e2.getMessage());
                        }
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        ab.e("MicroMsg.TrackMapUI", "download failure, msg: %s.", e2.getMessage());
                        if (inputStream != null) {
                        }
                        AppMethodBeat.o(113707);
                        return str2;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                                ab.e("MicroMsg.TrackMapUI", "download json, close input stream failure, msg: %s.", e22.getMessage());
                            }
                        }
                        AppMethodBeat.o(113707);
                    }
                }
            } catch (Exception e4) {
                e22 = e4;
                str2 = str3;
                ab.e("MicroMsg.TrackMapUI", "download failure, msg: %s.", e22.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e222) {
                        ab.e("MicroMsg.TrackMapUI", "download json, close input stream failure, msg: %s.", e222.getMessage());
                    }
                }
                AppMethodBeat.o(113707);
                return str2;
            }
            AppMethodBeat.o(113707);
            return str2;
        }
    }

    public h(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(113710);
        super.onCreate(bundle);
        this.nQZ = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0))).intValue();
        ab.i("MicroMsg.TrackMapUI", "count: %s", Integer.valueOf(this.nQZ));
        this.nOJ.nJB = this.activity.getIntent().getStringExtra("kPoiid");
        xE(ah.getResources().getColor(R.color.vy));
        AppMethodBeat.o(113710);
    }

    /* Access modifiers changed, original: final */
    public final void bKm() {
        AppMethodBeat.i(113711);
        super.bKm();
        ((TextView) findViewById(R.id.d83)).setText(R.string.cnb);
        findViewById(R.id.d85).setVisibility(8);
        ViewStub viewStub = (ViewStub) findViewById(R.id.c_k);
        viewStub.setOnInflateListener(new OnInflateListener() {
            public final void onInflate(ViewStub viewStub, View view) {
                AppMethodBeat.i(113695);
                view.findViewById(R.id.dhy).setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
                AppMethodBeat.o(113695);
            }
        });
        this.nQW = viewStub.inflate();
        findViewById(R.id.c_m).setVisibility(8);
        this.activity.getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113696);
                FrameLayout frameLayout = (FrameLayout) h.this.findViewById(R.id.c_i);
                RelativeLayout relativeLayout = (RelativeLayout) h.this.nQW.findViewById(R.id.dhy);
                if (frameLayout == null) {
                    ab.w("MicroMsg.TrackMapUI", "mapcontent is null!");
                    AppMethodBeat.o(113696);
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LayoutParams(-1, -1);
                }
                layoutParams.height = frameLayout.getHeight() - relativeLayout.getHeight();
                frameLayout.setLayoutParams(layoutParams);
                AppMethodBeat.o(113696);
            }
        });
        this.nQG = new m(this.activity, this.nOL.nLY, false);
        this.nQG.nNX = false;
        this.nQG.nNY = false;
        m mVar = this.nQG;
        mVar.nNV = true;
        if (mVar.nNO != null) {
            mVar.nNO.setOnAvatarOnClickListener(null);
            mVar.nNO.setOnLocationOnClickListener(null);
            mVar.nNO.bKE();
        }
        this.nQG.nNS = false;
        this.nQI = new l(this.activity, new com.tencent.mm.plugin.location.ui.l.a() {
            public final void bKd() {
            }

            public final void xD(int i) {
            }

            public final void bKe() {
            }
        });
        findViewById(R.id.c_p).setVisibility(8);
        this.nOL.lnh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113698);
                h.this.bKl();
                h.this.aqX();
                h.this.activity.finish();
                AppMethodBeat.o(113698);
            }
        });
        this.nQU = (NewMyLocationButton) this.nQW.findViewById(R.id.dhx);
        this.nQU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113699);
                h.this.nQG.a(h.this.nOL.nLY);
                AppMethodBeat.o(113699);
            }
        });
        final String stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
        if (bo.isNullOrNil(stringExtra)) {
            this.nOL.nHi.setVisibility(8);
        } else {
            this.nOL.nHi.setVisibility(0);
            this.nOL.nHi.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(113700);
                    Intent intent = new Intent();
                    intent.setClass(h.this.activity, e.m.class);
                    ab.d("MicroMsg.TrackMapUI", "click url %s", stringExtra);
                    intent.putExtra("rawUrl", stringExtra);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bp.d.f(h.this.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(113700);
                }
            });
        }
        this.nRp.nOz.setImageResource(R.drawable.bmf);
        this.nQV = new f(this.nOL.nLY, this.activity);
        if (this.nOJ.bJp()) {
            if (!(this.eUu == null || this.eUu.equals(""))) {
                this.nQV.eUu = this.eUu;
            }
            this.nQV.setText(this.nRp.getPreText() + this.nOJ.nJx);
        }
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113697);
                ab.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
                h.this.czL = 0;
                h.this.bKB();
                h.this.bKK();
                AppMethodBeat.o(113697);
            }
        };
        f fVar = this.nQV;
        fVar.nMb.setOnClickListener(anonymousClass3);
        fVar.nMb.setVisibility(0);
        this.nRa = findViewById(R.id.c_t);
        AppMethodBeat.o(113711);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(113712);
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(113712);
        return dispatchKeyEvent;
    }

    public final void bKA() {
        AppMethodBeat.i(113713);
        super.bKA();
        AppMethodBeat.o(113713);
    }

    public final void bKC() {
        AppMethodBeat.i(113714);
        super.bKC();
        ab.i("MicroMsg.TrackMapUI", "onDown");
        AppMethodBeat.o(113714);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKD() {
        AppMethodBeat.i(113715);
        this.nQX = new d(this.activity, 1, false);
        this.nQX.rBl = new c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(113701);
                if (h.this.nRr) {
                    lVar.a(1, h.this.getString(R.string.cnw), 0);
                }
                h hVar = h.this;
                com.tencent.mm.plugin.location.ui.d dVar = h.this.nOI;
                LocationInfo locationInfo = h.this.nOJ;
                ArrayList arrayList = new ArrayList();
                arrayList.add("com.tencent.map");
                arrayList.add("com.google.android.apps.maps");
                arrayList.add("com.baidu.BaiduMap");
                arrayList.add("com.autonavi.minimap");
                arrayList.add("com.sogou.map.android.maps");
                String str = "android.intent.action.VIEW";
                Intent intent = new Intent(str, Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)})));
                PackageManager packageManager = dVar.context.getPackageManager();
                HashMap hashMap = new HashMap();
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                    if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                        hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(dVar.context.getPackageManager()).toString());
                    }
                }
                hVar.nQY = hashMap;
                if (!com.tencent.mm.sdk.platformtools.g.dnY() && (h.this.nQZ < 4 || h.a(h.this))) {
                    lVar.ax(2, R.string.evo, 0);
                }
                int i = 3;
                Iterator it = h.this.nQY.entrySet().iterator();
                while (true) {
                    int i2 = i;
                    if (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        if (!((String) entry.getKey()).equals("com.tencent.map")) {
                            lVar.a(i2, (CharSequence) entry.getValue(), 0);
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(113701);
                        return;
                    }
                }
            }
        };
        this.nQX.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(113702);
                switch (menuItem.getItemId()) {
                    case 1:
                        h.this.bKI();
                        com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(4));
                        AppMethodBeat.o(113702);
                        return;
                    case 2:
                        ab.i("MicroMsg.TrackMapUI", "click tencent map: %s", Boolean.valueOf(h.this.nQY.containsKey("com.tencent.map")));
                        if (h.a(h.this)) {
                            h.this.nOI.a(h.this.nOJ, h.this.nOK, "com.tencent.map", false);
                            com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(4), "com.tencent.map");
                            AppMethodBeat.o(113702);
                            return;
                        }
                        int i2;
                        if (h.this.nQZ < 4) {
                            h hVar = h.this;
                            hVar.nQZ++;
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(h.this.nQZ));
                        }
                        if (1 == ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_tencent_map_download_page_direct, 0)) {
                            i2 = 1;
                        } else {
                            boolean i22 = false;
                        }
                        if (i22 != 0) {
                            new a(h.this.activity, h.this.nRa).execute(new String[]{"https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json"});
                            AppMethodBeat.o(113702);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
                        com.tencent.mm.bp.d.b(h.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                        com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(5));
                        AppMethodBeat.o(113702);
                        return;
                    default:
                        if (h.this.nQY != null) {
                            for (Entry entry : h.this.nQY.entrySet()) {
                                if (((String) entry.getValue()).equals(menuItem.getTitle())) {
                                    h.this.nOI.a(h.this.nOJ, h.this.nOK, (String) entry.getKey(), false);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(12809, Integer.valueOf(4), entry.getKey());
                                    AppMethodBeat.o(113702);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.o(113702);
                        return;
                }
            }
        };
        this.nQX.cpD();
        AppMethodBeat.o(113715);
    }

    public final void onDestroy() {
        AppMethodBeat.i(113716);
        super.onDestroy();
        if (this.nQG != null) {
            this.nQG.destroy();
        }
        AppMethodBeat.o(113716);
    }

    public final void onResume() {
        AppMethodBeat.i(113717);
        super.onResume();
        if (this.nQG != null) {
            this.nQG.onResume();
        }
        if (this.type == 2) {
            gh ghVar = new gh();
            ghVar.cAH.cvv = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
            ghVar.cAH.type = 4;
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            if (ghVar.cAI.bka != null) {
                if (this.nOQ == null) {
                    this.nOQ = new ArrayList();
                } else {
                    this.nOQ.clear();
                }
                this.nOQ.addAll(ghVar.cAI.bka);
                bKi();
            }
        }
        AppMethodBeat.o(113717);
    }

    public final void onPause() {
        AppMethodBeat.i(113718);
        super.onPause();
        if (this.nQG != null) {
            this.nQG.onPause();
        }
        AppMethodBeat.o(113718);
    }

    static /* synthetic */ boolean a(h hVar) {
        AppMethodBeat.i(113719);
        boolean containsKey = hVar.nQY.containsKey("com.tencent.map");
        AppMethodBeat.o(113719);
        return containsKey;
    }
}
