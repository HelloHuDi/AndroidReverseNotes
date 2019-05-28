package com.tencent.p177mm.plugin.location.p446ui.impl;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.location.model.LocationInfo;
import com.tencent.p177mm.plugin.location.p446ui.C12382f;
import com.tencent.p177mm.plugin.location.p446ui.C28389m;
import com.tencent.p177mm.plugin.location.p446ui.C34412d;
import com.tencent.p177mm.plugin.location.p446ui.C39302l;
import com.tencent.p177mm.plugin.location.p446ui.C39302l.C3357a;
import com.tencent.p177mm.plugin.location.p446ui.NewMyLocationButton;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
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

/* renamed from: com.tencent.mm.plugin.location.ui.impl.h */
public final class C28383h extends C21182i {
    C28389m nQG;
    private C39302l nQI;
    private NewMyLocationButton nQU;
    private C12382f nQV;
    View nQW;
    private C36356d nQX;
    Map<String, String> nQY;
    int nQZ;
    View nRa;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$5 */
    class C123925 implements OnClickListener {
        C123925() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113698);
            C28383h.this.bKl();
            C28383h.this.aqX();
            C28383h.this.activity.finish();
            AppMethodBeat.m2505o(113698);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$8 */
    class C123948 implements C36073c {
        C123948() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(113701);
            if (C28383h.this.nRr) {
                c44273l.mo70049a(1, C28383h.this.getString(C25738R.string.cnw), 0);
            }
            C28383h c28383h = C28383h.this;
            C34412d c34412d = C28383h.this.nOI;
            LocationInfo locationInfo = C28383h.this.nOJ;
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.tencent.map");
            arrayList.add("com.google.android.apps.maps");
            arrayList.add("com.baidu.BaiduMap");
            arrayList.add("com.autonavi.minimap");
            arrayList.add("com.sogou.map.android.maps");
            String str = "android.intent.action.VIEW";
            Intent intent = new Intent(str, Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(locationInfo.nJu), Double.valueOf(locationInfo.nJv)})));
            PackageManager packageManager = c34412d.context.getPackageManager();
            HashMap hashMap = new HashMap();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                    hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(c34412d.context.getPackageManager()).toString());
                }
            }
            c28383h.nQY = hashMap;
            if (!C5059g.dnY() && (C28383h.this.nQZ < 4 || C28383h.m45025a(C28383h.this))) {
                c44273l.mo70063ax(2, C25738R.string.evo, 0);
            }
            int i = 3;
            Iterator it = C28383h.this.nQY.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!((String) entry.getKey()).equals("com.tencent.map")) {
                        c44273l.mo70049a(i2, (CharSequence) entry.getValue(), 0);
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(113701);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$a */
    static class C12397a extends AsyncTask<String, Integer, String> {
        private final WeakReference<Context> nRe;
        private final WeakReference<View> nRf;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Object obj;
            String obj2;
            AppMethodBeat.m2504i(113709);
            String[] strArr = (String[]) objArr;
            String str = "";
            final Context context = (Context) this.nRe.get();
            if (context != null) {
                if (!C5023at.isNetworkConnected(context)) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(113703);
                            Toast.makeText(context, context.getString(C25738R.string.evl), 0).show();
                            AppMethodBeat.m2505o(113703);
                        }
                    });
                    C4990ab.m7412e("MicroMsg.TrackMapUI", "fail, network not ready");
                    obj2 = str;
                } else if (!C1445f.m3070Mn()) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(113704);
                            Toast.makeText(context, context.getString(C25738R.string.evn), 0).show();
                            AppMethodBeat.m2505o(113704);
                        }
                    });
                    C4990ab.m7412e("MicroMsg.TrackMapUI", "fail, sdcard not ready");
                    obj2 = str;
                } else if (strArr.length == 1) {
                    obj2 = C12397a.m20326Qd(strArr[0]);
                }
                AppMethodBeat.m2505o(113709);
                return obj2;
            }
            obj2 = str;
            AppMethodBeat.m2505o(113709);
            return obj2;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(113708);
            String str = (String) obj;
            View view = (View) this.nRf.get();
            if (view != null) {
                view.setVisibility(8);
            }
            Context context = (Context) this.nRe.get();
            if (context == null) {
                AppMethodBeat.m2505o(113708);
                return;
            }
            C4990ab.m7410d("MicroMsg.TrackMapUI", "json string: ".concat(String.valueOf(str)));
            try {
                if (!C5046bo.isNullOrNil(str)) {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("apkInfos");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        Intent intent = new Intent();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject == null) {
                                C4990ab.m7410d("MicroMsg.TrackMapUI", "get json item failure, index: ".concat(String.valueOf(i)));
                            } else if (optJSONObject.optString("cid").equals("00008")) {
                                String optString = optJSONObject.optString("apkPath");
                                long j = 0;
                                String optString2 = optJSONObject.optString("size");
                                if (TextUtils.isDigitsOnly(optString2)) {
                                    j = Long.valueOf(optString2).longValue();
                                }
                                C4990ab.m7411d("MicroMsg.TrackMapUI", "url: %s, md5: %s, size: %s", optString, optJSONObject.optString("md5"), Long.valueOf(j));
                                if (j > 0 && !C1445f.m3072eW(j)) {
                                    Toast.makeText(context, context.getString(C25738R.string.evm), 0).show();
                                    C4990ab.m7412e("MicroMsg.TrackMapUI", "fail, not enough space, require size = ".concat(String.valueOf(j)));
                                    AppMethodBeat.m2505o(113708);
                                    return;
                                } else if (C5046bo.isNullOrNil(optString)) {
                                    C4990ab.m7412e("MicroMsg.TrackMapUI", "doAddDownloadTask fail, url is null");
                                    AppMethodBeat.m2505o(113708);
                                    return;
                                } else {
                                    intent.putExtra("task_name", "TencentMap");
                                    intent.putExtra("task_url", optString);
                                    intent.putExtra("task_size", j);
                                    intent.putExtra("file_md5", r5);
                                    intent.putExtra("thumb_url", "https://3gimg.qq.com/tencentMapTouch/app/download/wx_android_download_ico.png");
                                    intent.putExtra("title", "腾讯地图");
                                    intent.addFlags(268435456);
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
                                    AppMethodBeat.m2505o(113708);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.m2505o(113708);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.TrackMapUI", "get json array failure, key=%s.", "apkInfos");
                    Toast.makeText(context, context.getString(C25738R.string.evk), 0).show();
                }
                AppMethodBeat.m2505o(113708);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.TrackMapUI", "deal json string failure, msg: %s.", e.getMessage());
                Toast.makeText(context, context.getString(C25738R.string.evk), 0).show();
                AppMethodBeat.m2505o(113708);
            }
        }

        C12397a(Context context, View view) {
            AppMethodBeat.m2504i(113705);
            this.nRe = new WeakReference(context);
            this.nRf = new WeakReference(view);
            AppMethodBeat.m2505o(113705);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(113706);
            View view = (View) this.nRf.get();
            if (view != null) {
                view.setVisibility(0);
            }
            AppMethodBeat.m2505o(113706);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A:{SYNTHETIC, Splitter:B:17:0x0066} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Qd */
        private static String m20326Qd(String str) {
            String str2;
            Exception e;
            AppMethodBeat.m2504i(113707);
            String str3 = "";
            InputStream inputStream = null;
            try {
                inputStream = new URL(str).openStream();
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                int read = inputStream.read(bArr);
                str2 = new String(bArr);
                try {
                    C4990ab.m7410d("MicroMsg.TrackMapUI", "json length: ".concat(String.valueOf(read)));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.TrackMapUI", "download json, close input stream failure, msg: %s.", e2.getMessage());
                        }
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        C4990ab.m7413e("MicroMsg.TrackMapUI", "download failure, msg: %s.", e2.getMessage());
                        if (inputStream != null) {
                        }
                        AppMethodBeat.m2505o(113707);
                        return str2;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.TrackMapUI", "download json, close input stream failure, msg: %s.", e22.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(113707);
                    }
                }
            } catch (Exception e4) {
                e22 = e4;
                str2 = str3;
                C4990ab.m7413e("MicroMsg.TrackMapUI", "download failure, msg: %s.", e22.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e222) {
                        C4990ab.m7413e("MicroMsg.TrackMapUI", "download json, close input stream failure, msg: %s.", e222.getMessage());
                    }
                }
                AppMethodBeat.m2505o(113707);
                return str2;
            }
            AppMethodBeat.m2505o(113707);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$4 */
    class C283814 implements C3357a {
        C283814() {
        }

        public final void bKd() {
        }

        /* renamed from: xD */
        public final void mo7765xD(int i) {
        }

        public final void bKe() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$6 */
    class C283826 implements OnClickListener {
        C283826() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113699);
            C28383h.this.nQG.mo46365a(C28383h.this.nOL.nLY);
            AppMethodBeat.m2505o(113699);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$1 */
    class C283841 implements OnInflateListener {

        /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$1$1 */
        class C283851 implements OnTouchListener {
            C283851() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        C283841() {
        }

        public final void onInflate(ViewStub viewStub, View view) {
            AppMethodBeat.m2504i(113695);
            view.findViewById(2131826350).setOnTouchListener(new C283851());
            AppMethodBeat.m2505o(113695);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$2 */
    class C283862 implements Runnable {
        C283862() {
        }

        public final void run() {
            AppMethodBeat.m2504i(113696);
            FrameLayout frameLayout = (FrameLayout) C28383h.this.findViewById(2131824670);
            RelativeLayout relativeLayout = (RelativeLayout) C28383h.this.nQW.findViewById(2131826350);
            if (frameLayout == null) {
                C4990ab.m7420w("MicroMsg.TrackMapUI", "mapcontent is null!");
                AppMethodBeat.m2505o(113696);
                return;
            }
            LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = frameLayout.getHeight() - relativeLayout.getHeight();
            frameLayout.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(113696);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$3 */
    class C283873 implements OnClickListener {
        C283873() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113697);
            C4990ab.m7410d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
            C28383h.this.czL = 0;
            C28383h.this.bKB();
            C28383h.this.bKK();
            AppMethodBeat.m2505o(113697);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.h$9 */
    class C283889 implements C5279d {
        C283889() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(113702);
            switch (menuItem.getItemId()) {
                case 1:
                    C28383h.this.bKI();
                    C7060h.pYm.mo8381e(12809, Integer.valueOf(4));
                    AppMethodBeat.m2505o(113702);
                    return;
                case 2:
                    C4990ab.m7417i("MicroMsg.TrackMapUI", "click tencent map: %s", Boolean.valueOf(C28383h.this.nQY.containsKey("com.tencent.map")));
                    if (C28383h.m45025a(C28383h.this)) {
                        C28383h.this.nOI.mo54920a(C28383h.this.nOJ, C28383h.this.nOK, "com.tencent.map", false);
                        C7060h.pYm.mo8381e(12809, Integer.valueOf(4), "com.tencent.map");
                        AppMethodBeat.m2505o(113702);
                        return;
                    }
                    int i2;
                    if (C28383h.this.nQZ < 4) {
                        C28383h c28383h = C28383h.this;
                        c28383h.nQZ++;
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(C28383h.this.nQZ));
                    }
                    if (1 == ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_tencent_map_download_page_direct, 0)) {
                        i2 = 1;
                    } else {
                        boolean i22 = false;
                    }
                    if (i22 != 0) {
                        new C12397a(C28383h.this.activity, C28383h.this.nRa).execute(new String[]{"https://3gimg.qq.com/tencentMapTouch/app/download/apkForWXAndroidConf.json"});
                        AppMethodBeat.m2505o(113702);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
                    C25985d.m41467b(C28383h.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                    C7060h.pYm.mo8381e(12809, Integer.valueOf(5));
                    AppMethodBeat.m2505o(113702);
                    return;
                default:
                    if (C28383h.this.nQY != null) {
                        for (Entry entry : C28383h.this.nQY.entrySet()) {
                            if (((String) entry.getValue()).equals(menuItem.getTitle())) {
                                C28383h.this.nOI.mo54920a(C28383h.this.nOJ, C28383h.this.nOK, (String) entry.getKey(), false);
                                C7060h.pYm.mo8381e(12809, Integer.valueOf(4), entry.getKey());
                                AppMethodBeat.m2505o(113702);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.m2505o(113702);
                    return;
            }
        }
    }

    public C28383h(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(113710);
        super.onCreate(bundle);
        this.nQZ = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0))).intValue();
        C4990ab.m7417i("MicroMsg.TrackMapUI", "count: %s", Integer.valueOf(this.nQZ));
        this.nOJ.nJB = this.activity.getIntent().getStringExtra("kPoiid");
        mo46354xE(C4996ah.getResources().getColor(C25738R.color.f12206vy));
        AppMethodBeat.m2505o(113710);
    }

    /* Access modifiers changed, original: final */
    public final void bKm() {
        AppMethodBeat.m2504i(113711);
        super.bKm();
        ((TextView) findViewById(2131825948)).setText(C25738R.string.cnb);
        findViewById(2131825950).setVisibility(8);
        ViewStub viewStub = (ViewStub) findViewById(2131824672);
        viewStub.setOnInflateListener(new C283841());
        this.nQW = viewStub.inflate();
        findViewById(2131824674).setVisibility(8);
        this.activity.getWindow().getDecorView().post(new C283862());
        this.nQG = new C28389m(this.activity, this.nOL.nLY, false);
        this.nQG.nNX = false;
        this.nQG.nNY = false;
        C28389m c28389m = this.nQG;
        c28389m.nNV = true;
        if (c28389m.nNO != null) {
            c28389m.nNO.setOnAvatarOnClickListener(null);
            c28389m.nNO.setOnLocationOnClickListener(null);
            c28389m.nNO.bKE();
        }
        this.nQG.nNS = false;
        this.nQI = new C39302l(this.activity, new C283814());
        findViewById(2131824677).setVisibility(8);
        this.nOL.lnh.setOnClickListener(new C123925());
        this.nQU = (NewMyLocationButton) this.nQW.findViewById(2131826349);
        this.nQU.setOnClickListener(new C283826());
        final String stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
        if (C5046bo.isNullOrNil(stringExtra)) {
            this.nOL.nHi.setVisibility(8);
        } else {
            this.nOL.nHi.setVisibility(0);
            this.nOL.nHi.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(113700);
                    Intent intent = new Intent();
                    intent.setClass(C28383h.this.activity, C5506m.class);
                    C4990ab.m7411d("MicroMsg.TrackMapUI", "click url %s", stringExtra);
                    intent.putExtra("rawUrl", stringExtra);
                    intent.putExtra("showShare", false);
                    C25985d.m41473f(C28383h.this.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(113700);
                }
            });
        }
        this.nRp.nOz.setImageResource(C25738R.drawable.bmf);
        this.nQV = new C12382f(this.nOL.nLY, this.activity);
        if (this.nOJ.bJp()) {
            if (!(this.eUu == null || this.eUu.equals(""))) {
                this.nQV.eUu = this.eUu;
            }
            this.nQV.setText(this.nRp.getPreText() + this.nOJ.nJx);
        }
        C283873 c283873 = new C283873();
        C12382f c12382f = this.nQV;
        c12382f.nMb.setOnClickListener(c283873);
        c12382f.nMb.setVisibility(0);
        this.nRa = findViewById(2131824681);
        AppMethodBeat.m2505o(113711);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(113712);
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(113712);
        return dispatchKeyEvent;
    }

    public final void bKA() {
        AppMethodBeat.m2504i(113713);
        super.bKA();
        AppMethodBeat.m2505o(113713);
    }

    public final void bKC() {
        AppMethodBeat.m2504i(113714);
        super.bKC();
        C4990ab.m7416i("MicroMsg.TrackMapUI", "onDown");
        AppMethodBeat.m2505o(113714);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKD() {
        AppMethodBeat.m2504i(113715);
        this.nQX = new C36356d(this.activity, 1, false);
        this.nQX.rBl = new C123948();
        this.nQX.rBm = new C283889();
        this.nQX.cpD();
        AppMethodBeat.m2505o(113715);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(113716);
        super.onDestroy();
        if (this.nQG != null) {
            this.nQG.destroy();
        }
        AppMethodBeat.m2505o(113716);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(113717);
        super.onResume();
        if (this.nQG != null) {
            this.nQG.onResume();
        }
        if (this.type == 2) {
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.cvv = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
            c37721gh.cAH.type = 4;
            C4879a.xxA.mo10055m(c37721gh);
            if (c37721gh.cAI.bka != null) {
                if (this.nOQ == null) {
                    this.nOQ = new ArrayList();
                } else {
                    this.nOQ.clear();
                }
                this.nOQ.addAll(c37721gh.cAI.bka);
                bKi();
            }
        }
        AppMethodBeat.m2505o(113717);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(113718);
        super.onPause();
        if (this.nQG != null) {
            this.nQG.onPause();
        }
        AppMethodBeat.m2505o(113718);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m45025a(C28383h c28383h) {
        AppMethodBeat.m2504i(113719);
        boolean containsKey = c28383h.nQY.containsKey("com.tencent.map");
        AppMethodBeat.m2505o(113719);
        return containsKey;
    }
}
