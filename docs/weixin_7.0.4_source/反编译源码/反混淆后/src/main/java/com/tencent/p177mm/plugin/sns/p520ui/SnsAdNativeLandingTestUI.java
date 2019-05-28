package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29064ad;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoSightView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI */
public class SnsAdNativeLandingTestUI extends MMActivity {
    private int duration = 0;
    private C7306ak fbD = new C7306ak();
    private double qzd = 0.0d;
    private int rbG;
    private VideoSightView roV;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar roW;
    private int videoHeight;
    private int videoWidth;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$3 */
    class C220033 implements C3855b {
        C220033() {
        }

        public final void aFw() {
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(38704);
            C4990ab.m7416i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(i)));
            SnsAdNativeLandingTestUI.this.qzd = (double) i;
            SnsAdNativeLandingTestUI.this.roV.mo9052B((double) i);
            AppMethodBeat.m2505o(38704);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$4 */
    class C220044 implements OnClickListener {
        C220044() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38705);
            if (SnsAdNativeLandingTestUI.this.roV.isPlaying()) {
                SnsAdNativeLandingTestUI.m68136b(SnsAdNativeLandingTestUI.this);
                AppMethodBeat.m2505o(38705);
                return;
            }
            SnsAdNativeLandingTestUI.m68138c(SnsAdNativeLandingTestUI.this);
            AppMethodBeat.m2505o(38705);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$5 */
    class C220055 implements C14981a {
        C220055() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(38707);
            if (SnsAdNativeLandingTestUI.this.roW.getIsPlay()) {
                SnsAdNativeLandingTestUI.m68138c(SnsAdNativeLandingTestUI.this);
            }
            AppMethodBeat.m2505o(38707);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(38708);
            SnsAdNativeLandingTestUI.this.roV.stop();
            AppMethodBeat.m2505o(38708);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
        }

        /* renamed from: dG */
        public final int mo8554dG(final int i, final int i2) {
            AppMethodBeat.m2504i(38709);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38706);
                    C4990ab.m7416i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + i + " video time " + i2);
                    if (i2 > 0) {
                        SnsAdNativeLandingTestUI.this.duration = i2;
                        SnsAdNativeLandingTestUI.this.rbG = i2;
                    }
                    if (SnsAdNativeLandingTestUI.this.roW.getVideoTotalTime() != i2) {
                        SnsAdNativeLandingTestUI.this.roW.setVideoTotalTime(i2);
                    }
                    SnsAdNativeLandingTestUI.this.roW.seek(i);
                    AppMethodBeat.m2505o(38706);
                }
            });
            AppMethodBeat.m2505o(38709);
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
            AppMethodBeat.m2504i(38710);
            SnsAdNativeLandingTestUI.this.videoWidth = i;
            SnsAdNativeLandingTestUI.this.videoHeight = i2;
            AppMethodBeat.m2505o(38710);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$7 */
    class C220077 implements Runnable {
        C220077() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38712);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (SnsAdNativeLandingTestUI.this.mController.ylL instanceof MMActivity) {
                ((MMActivity) SnsAdNativeLandingTestUI.this.mController.ylL).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                SnsAdNativeLandingTestUI.this.roV.setDrawableWidth(displayMetrics.widthPixels);
            }
            SnsAdNativeLandingTestUI.this.roV.requestLayout();
            SnsAdNativeLandingTestUI.this.roV.postInvalidate();
            AppMethodBeat.m2505o(38712);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$a */
    static class C22009a extends AsyncTask<String, Void, Void> {
        private static Set<String> rpb = new HashSet();
        private static byte[] rpc = new byte[0];
        final String fileName;
        final String filePath;
        final C7306ak handler;
        final String rdP;
        final String rdQ;
        final int rdS;
        final String rdT;
        final C22008a rpd;

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$a$a */
        interface C22008a {
            /* renamed from: BD */
            void mo25692BD(String str);

            /* renamed from: de */
            void mo25693de(String str, int i);

            /* renamed from: lW */
            void mo25694lW(String str);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(38726);
            Void F = m33646F((String[]) objArr);
            AppMethodBeat.m2505o(38726);
            return F;
        }

        static {
            AppMethodBeat.m2504i(38727);
            AppMethodBeat.m2505o(38727);
        }

        public C22009a(String str, String str2, C7306ak c7306ak, C22008a c22008a) {
            this(str, str2, c7306ak, c22008a, 0);
        }

        public C22009a(String str, String str2, final C7306ak c7306ak, final C22008a c22008a, int i) {
            AppMethodBeat.m2504i(38724);
            C5730e.m8643tf(str);
            this.rdT = str;
            this.fileName = str2;
            this.filePath = str + "/" + str2;
            this.rdQ = "temp_".concat(String.valueOf(str2));
            this.rdP = str + "/" + this.rdQ;
            this.handler = c7306ak;
            this.rdS = i;
            this.rpd = new C22008a() {
                /* renamed from: de */
                public final void mo25693de(final String str, final int i) {
                    AppMethodBeat.m2504i(38721);
                    c7306ak.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(38718);
                            c22008a.mo25693de(str, i);
                            AppMethodBeat.m2505o(38718);
                        }
                    });
                    AppMethodBeat.m2505o(38721);
                }

                /* renamed from: BD */
                public final void mo25692BD(final String str) {
                    AppMethodBeat.m2504i(38722);
                    c7306ak.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(38719);
                            c22008a.mo25692BD(str);
                            AppMethodBeat.m2505o(38719);
                        }
                    });
                    AppMethodBeat.m2505o(38722);
                }

                /* renamed from: lW */
                public final void mo25694lW(final String str) {
                    AppMethodBeat.m2504i(38723);
                    c7306ak.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(38720);
                            c22008a.mo25694lW(str);
                            AppMethodBeat.m2505o(38720);
                        }
                    });
                    AppMethodBeat.m2505o(38723);
                }
            };
            AppMethodBeat.m2505o(38724);
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
        /* renamed from: F */
        private Void m33646F(String... strArr) {
            Exception e;
            HttpURLConnection httpURLConnection;
            Throwable th;
            AppMethodBeat.m2504i(38725);
            synchronized (rpc) {
                try {
                    if (rpb.contains(strArr[0])) {
                    } else {
                        rpb.add(strArr[0]);
                        InputStream inputStream;
                        OutputStream L;
                        try {
                            if (C5730e.m8628ct(this.filePath)) {
                                this.rpd.mo25694lW(this.filePath);
                                synchronized (rpc) {
                                    try {
                                        rpb.remove(strArr[0]);
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.m2505o(38725);
                                    }
                                }
                            } else {
                                if (C5730e.m8628ct(this.rdP)) {
                                    C5730e.deleteFile(this.rdP);
                                }
                                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                                try {
                                    httpURLConnection2.connect();
                                    if (httpURLConnection2.getResponseCode() != 200) {
                                        this.rpd.mo25692BD("Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage());
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (rpc) {
                                            try {
                                                rpb.remove(strArr[0]);
                                            } finally {
                                                while (true) {
                                                }
                                                AppMethodBeat.m2505o(38725);
                                            }
                                        }
                                    } else {
                                        httpURLConnection2.getContentLength();
                                        inputStream = httpURLConnection2.getInputStream();
                                        try {
                                            L = C5730e.m8617L(this.rdP, false);
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
                                                        this.rpd.mo25693de(this.rdP, read);
                                                        i = read;
                                                        i2 = read;
                                                    }
                                                }
                                                C5730e.m8623aQ(this.rdP, this.filePath);
                                                this.rpd.mo25694lW(this.filePath);
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
                                                        AppMethodBeat.m2505o(38725);
                                                    }
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                httpURLConnection = httpURLConnection2;
                                                try {
                                                    this.rpd.mo25692BD(e.getMessage());
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
                                            this.rpd.mo25692BD(e.getMessage());
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
                                                    AppMethodBeat.m2505o(38725);
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
                                            AppMethodBeat.m2505o(38725);
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
                            this.rpd.mo25692BD(e.getMessage());
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
                    AppMethodBeat.m2505o(38725);
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$6 */
    class C350166 implements OnClickListener {
        C350166() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38711);
            if (!("".equals(SnsAdNativeLandingTestUI.this.roV.getVideoPath()) || SnsAdNativeLandingTestUI.this.roV.getVideoPath() == null)) {
                if (SnsAdNativeLandingTestUI.this.roW.getVisibility() == 0) {
                    SnsAdNativeLandingTestUI.this.roW.setVisibility(4);
                    AppMethodBeat.m2505o(38711);
                    return;
                }
                SnsAdNativeLandingTestUI.this.roW.setVisibility(0);
            }
            AppMethodBeat.m2505o(38711);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$10 */
    class C3979510 implements Runnable {
        C3979510() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38717);
            SnsAdNativeLandingTestUI.this.roW.setIsPlay(true);
            AppMethodBeat.m2505o(38717);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$1 */
    class C397961 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$1$1 */
        class C220011 implements C5186a {
            C220011() {
            }

            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(38701);
                if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    if (str == null || str.length() == 0) {
                        C4990ab.m7412e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                        AppMethodBeat.m2505o(38701);
                        return;
                    }
                    final SnsAdNativeLandingTestUI snsAdNativeLandingTestUI = SnsAdNativeLandingTestUI.this;
                    C23281a.vlq.mo30687a(snsAdNativeLandingTestUI.mController, "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", true, snsAdNativeLandingTestUI.getResources().getString(C25738R.string.f9221tf), new C30111a() {
                        /* renamed from: a */
                        public final void mo6399a(boolean z, String str, int i) {
                            AppMethodBeat.m2504i(38700);
                            if (z) {
                                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                wXMediaMessage.title = "test title";
                                wXMediaMessage.description = "test desc";
                                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                wXWebpageObject.canvasPageXml = "<xml></xml>";
                                wXWebpageObject.webpageUrl = "http://www.baidu.com/";
                                wXMediaMessage.mediaObject = wXWebpageObject;
                                Bitmap bitmap = C29064ad.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    C4990ab.m7416i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                }
                                C26217py c26217py = new C26217py();
                                c26217py.cMe.cEl = wXMediaMessage;
                                c26217py.cMe.toUser = str;
                                c26217py.cMe.cMf = 49;
                                c26217py.cMe.cMg = "";
                                c26217py.cMe.cMh = "";
                                C4879a.xxA.mo10055m(c26217py);
                                if (!TextUtils.isEmpty(str)) {
                                    C18372qb c18372qb = new C18372qb();
                                    c18372qb.cMq.cMr = str;
                                    c18372qb.cMq.content = str;
                                    c18372qb.cMq.type = C1855t.m3925nK(str);
                                    c18372qb.cMq.flags = 0;
                                    C4879a.xxA.mo10055m(c18372qb);
                                }
                                C30379h.m48465bQ(snsAdNativeLandingTestUI, snsAdNativeLandingTestUI.getString(C25738R.string.f9229to));
                                AppMethodBeat.m2505o(38700);
                                return;
                            }
                            AppMethodBeat.m2505o(38700);
                        }
                    });
                }
                AppMethodBeat.m2505o(38701);
            }
        }

        C397961() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38702);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", C31128d.MIC_PTU_ZIPAI_MEDSEA);
            intent.putExtra("select_is_ret", true);
            C25985d.m41460a(SnsAdNativeLandingTestUI.this, ".ui.transmit.SelectConversationUI", intent, 0, new C220011());
            AppMethodBeat.m2505o(38702);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$2 */
    class C397972 implements Runnable {
        C397972() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38703);
            SnsAdNativeLandingTestUI.this.roW.setIsPlay(false);
            AppMethodBeat.m2505o(38703);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$8 */
    class C397988 implements C22008a {
        C397988() {
        }

        /* renamed from: de */
        public final void mo25693de(String str, int i) {
        }

        /* renamed from: BD */
        public final void mo25692BD(String str) {
        }

        /* renamed from: lW */
        public final void mo25694lW(String str) {
            AppMethodBeat.m2504i(38713);
            SnsAdNativeLandingTestUI.this.roV.setThumb(BitmapFactory.decodeFile(str));
            AppMethodBeat.m2505o(38713);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$9 */
    class C397999 implements C22008a {
        C397999() {
        }

        /* renamed from: de */
        public final void mo25693de(String str, int i) {
            AppMethodBeat.m2504i(38714);
            if (SnsAdNativeLandingTestUI.this.roV.isPlaying()) {
                AppMethodBeat.m2505o(38714);
                return;
            }
            SnsAdNativeLandingTestUI.this.roV.setLoop(false);
            if (!str.equals(SnsAdNativeLandingTestUI.this.roV.getVideoPath())) {
                SnsAdNativeLandingTestUI.this.roV.setVideoPath(str);
            }
            if (SnsAdNativeLandingTestUI.this.roW.getIsPlay()) {
                SnsAdNativeLandingTestUI.this.roV.mo9052B(SnsAdNativeLandingTestUI.this.qzd);
                SnsAdNativeLandingTestUI.this.roV.start();
            }
            AppMethodBeat.m2505o(38714);
        }

        /* renamed from: BD */
        public final void mo25692BD(String str) {
            AppMethodBeat.m2504i(38715);
            C4990ab.m7412e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
            AppMethodBeat.m2505o(38715);
        }

        /* renamed from: lW */
        public final void mo25694lW(String str) {
            AppMethodBeat.m2504i(38716);
            SnsAdNativeLandingTestUI.this.roV.setVideoPath(str);
            SnsAdNativeLandingTestUI.this.roV.setLoop(true);
            if (SnsAdNativeLandingTestUI.this.roW.getIsPlay()) {
                SnsAdNativeLandingTestUI.this.roV.mo9052B(SnsAdNativeLandingTestUI.this.qzd);
                SnsAdNativeLandingTestUI.this.roV.start();
            }
            AppMethodBeat.m2505o(38716);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsAdNativeLandingTestUI() {
        AppMethodBeat.m2504i(38728);
        AppMethodBeat.m2505o(38728);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38729);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ((Button) findViewById(2131827655)).setOnClickListener(new C397961());
        ViewGroup viewGroup = (ViewGroup) findViewById(2131827654);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.ylL.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.mController.ylL.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + C4995ag.m7428ck("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + C4995ag.m7428ck("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(2130970729, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(2131827642);
        this.roV = new VideoSightView(this.mController.ylL);
        this.roV.setLoop(false);
        viewGroup2.addView(this.roV, 0, new LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = C4977b.m7371b(this.mController.ylL, this.mController.ylL.getResources().getDimension(C25738R.dimen.f9970lu));
        this.roW = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.mController.ylL);
        this.roW.setVisibility(0);
        this.roV.setPlayProgressCallback(true);
        ((ViewGroup) inflate).addView(this.roW, layoutParams);
        this.roW.setIplaySeekCallback(new C220033());
        this.roW.setOnPlayButtonClickListener(new C220044());
        this.roW.setIsPlay(this.roV.isPlaying());
        this.roW.setVisibility(0);
        this.roW.seek(0);
        this.roV.setVideoCallback(new C220055());
        this.roV.setEnableConfigChanged(false);
        this.roV.setOnClickListener(new C350166());
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.roV.post(new C220077());
        new C22009a(str2, str3, C13373af.bCo(), new C397988()).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new C22009a(str2, str, C13373af.bCo(), new C397999(), Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
        AppMethodBeat.m2505o(38729);
    }

    public final int getLayoutId() {
        return 2130970735;
    }

    /* renamed from: b */
    static /* synthetic */ void m68136b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        AppMethodBeat.m2504i(38730);
        snsAdNativeLandingTestUI.qzd = snsAdNativeLandingTestUI.roV.getLastProgresstime();
        snsAdNativeLandingTestUI.roV.pause();
        snsAdNativeLandingTestUI.fbD.post(new C397972());
        AppMethodBeat.m2505o(38730);
    }

    /* renamed from: c */
    static /* synthetic */ void m68138c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        AppMethodBeat.m2504i(38731);
        snsAdNativeLandingTestUI.roV.mo9052B(snsAdNativeLandingTestUI.qzd);
        snsAdNativeLandingTestUI.roV.start();
        snsAdNativeLandingTestUI.fbD.post(new C3979510());
        AppMethodBeat.m2505o(38731);
    }
}
