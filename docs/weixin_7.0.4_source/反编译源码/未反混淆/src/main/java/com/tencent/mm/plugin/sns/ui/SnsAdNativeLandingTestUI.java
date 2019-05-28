package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private int duration = 0;
    private ak fbD = new ak();
    private double qzd = 0.0d;
    private int rbG;
    private VideoSightView roV;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar roW;
    private int videoHeight;
    private int videoWidth;

    static class a extends AsyncTask<String, Void, Void> {
        private static Set<String> rpb = new HashSet();
        private static byte[] rpc = new byte[0];
        final String fileName;
        final String filePath;
        final ak handler;
        final String rdP;
        final String rdQ;
        final int rdS;
        final String rdT;
        final a rpd;

        interface a {
            void BD(String str);

            void de(String str, int i);

            void lW(String str);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(38726);
            Void F = F((String[]) objArr);
            AppMethodBeat.o(38726);
            return F;
        }

        static {
            AppMethodBeat.i(38727);
            AppMethodBeat.o(38727);
        }

        public a(String str, String str2, ak akVar, a aVar) {
            this(str, str2, akVar, aVar, 0);
        }

        public a(String str, String str2, final ak akVar, final a aVar, int i) {
            AppMethodBeat.i(38724);
            e.tf(str);
            this.rdT = str;
            this.fileName = str2;
            this.filePath = str + "/" + str2;
            this.rdQ = "temp_".concat(String.valueOf(str2));
            this.rdP = str + "/" + this.rdQ;
            this.handler = akVar;
            this.rdS = i;
            this.rpd = new a() {
                public final void de(final String str, final int i) {
                    AppMethodBeat.i(38721);
                    akVar.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(38718);
                            aVar.de(str, i);
                            AppMethodBeat.o(38718);
                        }
                    });
                    AppMethodBeat.o(38721);
                }

                public final void BD(final String str) {
                    AppMethodBeat.i(38722);
                    akVar.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(38719);
                            aVar.BD(str);
                            AppMethodBeat.o(38719);
                        }
                    });
                    AppMethodBeat.o(38722);
                }

                public final void lW(final String str) {
                    AppMethodBeat.i(38723);
                    akVar.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(38720);
                            aVar.lW(str);
                            AppMethodBeat.o(38720);
                        }
                    });
                    AppMethodBeat.o(38723);
                }
            };
            AppMethodBeat.o(38724);
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x015c A:{SYNTHETIC, Splitter:B:101:0x015c} */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0161 A:{Catch:{ IOException -> 0x017f }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x016c A:{SYNTHETIC, Splitter:B:109:0x016c} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0131 A:{SYNTHETIC, Splitter:B:83:0x0131} */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0136 A:{Catch:{ IOException -> 0x0190 }} */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0141 A:{SYNTHETIC, Splitter:B:91:0x0141} */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x015c A:{SYNTHETIC, Splitter:B:101:0x015c} */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0161 A:{Catch:{ IOException -> 0x017f }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x016c A:{SYNTHETIC, Splitter:B:109:0x016c} */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x015c A:{SYNTHETIC, Splitter:B:101:0x015c} */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0161 A:{Catch:{ IOException -> 0x017f }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x016c A:{SYNTHETIC, Splitter:B:109:0x016c} */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0141 A:{SYNTHETIC, Splitter:B:91:0x0141} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0131 A:{SYNTHETIC, Splitter:B:83:0x0131} */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0136 A:{Catch:{ IOException -> 0x0190 }} */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0141 A:{SYNTHETIC, Splitter:B:91:0x0141} */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x015c A:{SYNTHETIC, Splitter:B:101:0x015c} */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0161 A:{Catch:{ IOException -> 0x017f }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x016c A:{SYNTHETIC, Splitter:B:109:0x016c} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x016c A:{SYNTHETIC, Splitter:B:109:0x016c} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Void F(String... strArr) {
            Exception e;
            HttpURLConnection httpURLConnection;
            Throwable th;
            AppMethodBeat.i(38725);
            synchronized (rpc) {
                try {
                    if (rpb.contains(strArr[0])) {
                    } else {
                        rpb.add(strArr[0]);
                        InputStream inputStream;
                        OutputStream L;
                        try {
                            if (e.ct(this.filePath)) {
                                this.rpd.lW(this.filePath);
                                synchronized (rpc) {
                                    try {
                                        rpb.remove(strArr[0]);
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(38725);
                                    }
                                }
                            } else {
                                if (e.ct(this.rdP)) {
                                    e.deleteFile(this.rdP);
                                }
                                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                                try {
                                    httpURLConnection2.connect();
                                    if (httpURLConnection2.getResponseCode() != 200) {
                                        this.rpd.BD("Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage());
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (rpc) {
                                            try {
                                                rpb.remove(strArr[0]);
                                            } finally {
                                                while (true) {
                                                }
                                                AppMethodBeat.o(38725);
                                            }
                                        }
                                    } else {
                                        httpURLConnection2.getContentLength();
                                        inputStream = httpURLConnection2.getInputStream();
                                        try {
                                            L = e.L(this.rdP, false);
                                            try {
                                                byte[] bArr = new byte[4096];
                                                int i = 0;
                                                int i2 = 0;
                                                while (true) {
                                                    int read = inputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    L.write(bArr, 0, read);
                                                    read += i2;
                                                    if (this.rdS == 0 || read - i < this.rdS) {
                                                        i2 = read;
                                                    } else {
                                                        this.rpd.de(this.rdP, read);
                                                        i = read;
                                                        i2 = read;
                                                    }
                                                }
                                                e.aQ(this.rdP, this.filePath);
                                                this.rpd.lW(this.filePath);
                                                if (L != null) {
                                                    try {
                                                        L.close();
                                                    } catch (IOException e2) {
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (httpURLConnection2 != null) {
                                                    httpURLConnection2.disconnect();
                                                }
                                                synchronized (rpc) {
                                                    try {
                                                        rpb.remove(strArr[0]);
                                                    } finally {
                                                        while (true) {
                                                        }
                                                        AppMethodBeat.o(38725);
                                                    }
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                httpURLConnection = httpURLConnection2;
                                                try {
                                                    this.rpd.BD(e.getMessage());
                                                    if (L != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    synchronized (rpc) {
                                                    }
                                                    return null;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (L != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    synchronized (rpc) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                httpURLConnection = httpURLConnection2;
                                                if (L != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                synchronized (rpc) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            httpURLConnection = httpURLConnection2;
                                            L = null;
                                            this.rpd.BD(e.getMessage());
                                            if (L != null) {
                                                try {
                                                    L.close();
                                                } catch (IOException e5) {
                                                    if (httpURLConnection != null) {
                                                    }
                                                    synchronized (rpc) {
                                                    }
                                                    return null;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (rpc) {
                                                try {
                                                    rpb.remove(strArr[0]);
                                                } finally {
                                                    while (true) {
                                                    }
                                                    AppMethodBeat.o(38725);
                                                }
                                            }
                                            return null;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            httpURLConnection = httpURLConnection2;
                                            L = null;
                                            if (L != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            synchronized (rpc) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    httpURLConnection = httpURLConnection2;
                                    L = null;
                                    inputStream = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    httpURLConnection = httpURLConnection2;
                                    L = null;
                                    inputStream = null;
                                    if (L != null) {
                                        try {
                                            L.close();
                                        } catch (IOException e7) {
                                            if (httpURLConnection != null) {
                                            }
                                            synchronized (rpc) {
                                            }
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    synchronized (rpc) {
                                        try {
                                            rpb.remove(strArr[0]);
                                        } finally {
                                            while (true) {
                                            }
                                            AppMethodBeat.o(38725);
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            httpURLConnection = null;
                            L = null;
                            inputStream = null;
                            this.rpd.BD(e.getMessage());
                            if (L != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            synchronized (rpc) {
                            }
                            return null;
                        } catch (Throwable th22) {
                            th = th22;
                            httpURLConnection = null;
                            L = null;
                            inputStream = null;
                            if (L != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            synchronized (rpc) {
                            }
                            throw th;
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(38725);
                }
            }
            return null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsAdNativeLandingTestUI() {
        AppMethodBeat.i(38728);
        AppMethodBeat.o(38728);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38729);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ((Button) findViewById(R.id.eg8)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38702);
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", d.MIC_PTU_ZIPAI_MEDSEA);
                intent.putExtra("select_is_ret", true);
                com.tencent.mm.bp.d.a(SnsAdNativeLandingTestUI.this, ".ui.transmit.SelectConversationUI", intent, 0, new com.tencent.mm.ui.MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(38701);
                        if (i2 == -1) {
                            String str;
                            if (intent == null) {
                                str = null;
                            } else {
                                str = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str == null || str.length() == 0) {
                                ab.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                                AppMethodBeat.o(38701);
                                return;
                            }
                            final SnsAdNativeLandingTestUI snsAdNativeLandingTestUI = SnsAdNativeLandingTestUI.this;
                            com.tencent.mm.pluginsdk.ui.applet.t.a.vlq.a(snsAdNativeLandingTestUI.mController, "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", true, snsAdNativeLandingTestUI.getResources().getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                                public final void a(boolean z, String str, int i) {
                                    AppMethodBeat.i(38700);
                                    if (z) {
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.title = "test title";
                                        wXMediaMessage.description = "test desc";
                                        WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                        wXWebpageObject.canvasPageXml = "<xml></xml>";
                                        wXWebpageObject.webpageUrl = "http://www.baidu.com/";
                                        wXMediaMessage.mediaObject = wXWebpageObject;
                                        Bitmap bitmap = ad.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
                                        if (!(bitmap == null || bitmap.isRecycled())) {
                                            ab.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        py pyVar = new py();
                                        pyVar.cMe.cEl = wXMediaMessage;
                                        pyVar.cMe.toUser = str;
                                        pyVar.cMe.cMf = 49;
                                        pyVar.cMe.cMg = "";
                                        pyVar.cMe.cMh = "";
                                        com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                                        if (!TextUtils.isEmpty(str)) {
                                            qb qbVar = new qb();
                                            qbVar.cMq.cMr = str;
                                            qbVar.cMq.content = str;
                                            qbVar.cMq.type = t.nK(str);
                                            qbVar.cMq.flags = 0;
                                            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                                        }
                                        h.bQ(snsAdNativeLandingTestUI, snsAdNativeLandingTestUI.getString(R.string.to));
                                        AppMethodBeat.o(38700);
                                        return;
                                    }
                                    AppMethodBeat.o(38700);
                                }
                            });
                        }
                        AppMethodBeat.o(38701);
                    }
                });
                AppMethodBeat.o(38702);
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.eg7);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.ylL.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.mController.ylL.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + ag.ck("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + ag.ck("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(R.layout.auc, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.efv);
        this.roV = new VideoSightView(this.mController.ylL);
        this.roV.setLoop(false);
        viewGroup2.addView(this.roV, 0, new LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.b(this.mController.ylL, this.mController.ylL.getResources().getDimension(R.dimen.lu));
        this.roW = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.mController.ylL);
        this.roW.setVisibility(0);
        this.roV.setPlayProgressCallback(true);
        ((ViewGroup) inflate).addView(this.roW, layoutParams);
        this.roW.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void aFw() {
            }

            public final void oA(int i) {
                AppMethodBeat.i(38704);
                ab.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(i)));
                SnsAdNativeLandingTestUI.this.qzd = (double) i;
                SnsAdNativeLandingTestUI.this.roV.B((double) i);
                AppMethodBeat.o(38704);
            }
        });
        this.roW.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38705);
                if (SnsAdNativeLandingTestUI.this.roV.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
                    AppMethodBeat.o(38705);
                    return;
                }
                SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                AppMethodBeat.o(38705);
            }
        });
        this.roW.setIsPlay(this.roV.isPlaying());
        this.roW.setVisibility(0);
        this.roW.seek(0);
        this.roV.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.e.a() {
            public final void pL() {
                AppMethodBeat.i(38707);
                if (SnsAdNativeLandingTestUI.this.roW.getIsPlay()) {
                    SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
                }
                AppMethodBeat.o(38707);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(38708);
                SnsAdNativeLandingTestUI.this.roV.stop();
                AppMethodBeat.o(38708);
            }

            public final void EA() {
            }

            public final int dG(final int i, final int i2) {
                AppMethodBeat.i(38709);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38706);
                        ab.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            SnsAdNativeLandingTestUI.this.duration = i2;
                            SnsAdNativeLandingTestUI.this.rbG = i2;
                        }
                        if (SnsAdNativeLandingTestUI.this.roW.getVideoTotalTime() != i2) {
                            SnsAdNativeLandingTestUI.this.roW.setVideoTotalTime(i2);
                        }
                        SnsAdNativeLandingTestUI.this.roW.seek(i);
                        AppMethodBeat.o(38706);
                    }
                });
                AppMethodBeat.o(38709);
                return 0;
            }

            public final void dH(int i, int i2) {
                AppMethodBeat.i(38710);
                SnsAdNativeLandingTestUI.this.videoWidth = i;
                SnsAdNativeLandingTestUI.this.videoHeight = i2;
                AppMethodBeat.o(38710);
            }
        });
        this.roV.setEnableConfigChanged(false);
        this.roV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38711);
                if (!("".equals(SnsAdNativeLandingTestUI.this.roV.getVideoPath()) || SnsAdNativeLandingTestUI.this.roV.getVideoPath() == null)) {
                    if (SnsAdNativeLandingTestUI.this.roW.getVisibility() == 0) {
                        SnsAdNativeLandingTestUI.this.roW.setVisibility(4);
                        AppMethodBeat.o(38711);
                        return;
                    }
                    SnsAdNativeLandingTestUI.this.roW.setVisibility(0);
                }
                AppMethodBeat.o(38711);
            }
        });
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.roV.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38712);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (SnsAdNativeLandingTestUI.this.mController.ylL instanceof MMActivity) {
                    ((MMActivity) SnsAdNativeLandingTestUI.this.mController.ylL).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    SnsAdNativeLandingTestUI.this.roV.setDrawableWidth(displayMetrics.widthPixels);
                }
                SnsAdNativeLandingTestUI.this.roV.requestLayout();
                SnsAdNativeLandingTestUI.this.roV.postInvalidate();
                AppMethodBeat.o(38712);
            }
        });
        new a(str2, str3, af.bCo(), new a() {
            public final void de(String str, int i) {
            }

            public final void BD(String str) {
            }

            public final void lW(String str) {
                AppMethodBeat.i(38713);
                SnsAdNativeLandingTestUI.this.roV.setThumb(BitmapFactory.decodeFile(str));
                AppMethodBeat.o(38713);
            }
        }).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new a(str2, str, af.bCo(), new a() {
            public final void de(String str, int i) {
                AppMethodBeat.i(38714);
                if (SnsAdNativeLandingTestUI.this.roV.isPlaying()) {
                    AppMethodBeat.o(38714);
                    return;
                }
                SnsAdNativeLandingTestUI.this.roV.setLoop(false);
                if (!str.equals(SnsAdNativeLandingTestUI.this.roV.getVideoPath())) {
                    SnsAdNativeLandingTestUI.this.roV.setVideoPath(str);
                }
                if (SnsAdNativeLandingTestUI.this.roW.getIsPlay()) {
                    SnsAdNativeLandingTestUI.this.roV.B(SnsAdNativeLandingTestUI.this.qzd);
                    SnsAdNativeLandingTestUI.this.roV.start();
                }
                AppMethodBeat.o(38714);
            }

            public final void BD(String str) {
                AppMethodBeat.i(38715);
                ab.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
                AppMethodBeat.o(38715);
            }

            public final void lW(String str) {
                AppMethodBeat.i(38716);
                SnsAdNativeLandingTestUI.this.roV.setVideoPath(str);
                SnsAdNativeLandingTestUI.this.roV.setLoop(true);
                if (SnsAdNativeLandingTestUI.this.roW.getIsPlay()) {
                    SnsAdNativeLandingTestUI.this.roV.B(SnsAdNativeLandingTestUI.this.qzd);
                    SnsAdNativeLandingTestUI.this.roV.start();
                }
                AppMethodBeat.o(38716);
            }
        }, Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
        AppMethodBeat.o(38729);
    }

    public final int getLayoutId() {
        return R.layout.aui;
    }

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        AppMethodBeat.i(38730);
        snsAdNativeLandingTestUI.qzd = snsAdNativeLandingTestUI.roV.getLastProgresstime();
        snsAdNativeLandingTestUI.roV.pause();
        snsAdNativeLandingTestUI.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38703);
                SnsAdNativeLandingTestUI.this.roW.setIsPlay(false);
                AppMethodBeat.o(38703);
            }
        });
        AppMethodBeat.o(38730);
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        AppMethodBeat.i(38731);
        snsAdNativeLandingTestUI.roV.B(snsAdNativeLandingTestUI.qzd);
        snsAdNativeLandingTestUI.roV.start();
        snsAdNativeLandingTestUI.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38717);
                SnsAdNativeLandingTestUI.this.roW.setIsPlay(true);
                AppMethodBeat.o(38717);
            }
        });
        AppMethodBeat.o(38731);
    }
}
