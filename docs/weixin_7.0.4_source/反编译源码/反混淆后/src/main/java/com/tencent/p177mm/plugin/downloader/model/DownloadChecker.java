package com.tencent.p177mm.plugin.downloader.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCLong;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C33904d;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C38844j;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C42908k;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45833a;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker */
public final class DownloadChecker {

    /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$2 */
    static class C68332 implements C1224a {
        final /* synthetic */ String cgp;
        final /* synthetic */ C18507c eFW;
        final /* synthetic */ String kMo;
        final /* synthetic */ String val$downloadUrl;

        C68332(String str, String str2, String str3, C18507c c18507c) {
            this.val$downloadUrl = str;
            this.kMo = str2;
            this.cgp = str3;
            this.eFW = c18507c;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(2344);
            C4990ab.m7417i("MicroMsg.DownloadChecker", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean();
            if (i == 0 && i2 == 0) {
                C42908k c42908k = (C42908k) c7472b.fsH.fsP;
                if (c42908k != null) {
                    int i3 = c42908k.kKC;
                    String str2 = c42908k.kKD;
                    C33904d c33904d = c42908k.kKy;
                    if (DownloadInterceptBean.m31427a(c33904d)) {
                        downloadInterceptBean.csN = true;
                        downloadInterceptBean.kMp = i3;
                        downloadInterceptBean.kMq = str2;
                        downloadInterceptBean.appId = c33904d.kKr.kLw == null ? null : c33904d.kKr.kLw.csB;
                        downloadInterceptBean.appName = c33904d.kKr.kLw == null ? null : c33904d.kKr.kLw.kKY;
                        downloadInterceptBean.iconUrl = c33904d.kKr.kLw == null ? null : c33904d.kKr.kLw.kKZ;
                        downloadInterceptBean.downloadUrl = c33904d.kKr.kLy.kLn.egm;
                        downloadInterceptBean.kMr = c33904d.kKr.kLy.kLn.kKV;
                        downloadInterceptBean.size = c33904d.kKr.kLy.kLn.kKP;
                        downloadInterceptBean.packageName = c33904d.kKr.kLy.kLn.kKO;
                        downloadInterceptBean.cvZ = c33904d.kKr.kLy.kLn.kKQ;
                        downloadInterceptBean.cBA = c33904d.kKr.kLy.kLn.kKR;
                        downloadInterceptBean.kMs = c33904d.kKr.kLy.kLr;
                    } else {
                        downloadInterceptBean.csN = false;
                    }
                    C4990ab.m7417i("MicroMsg.DownloadChecker", "check download from net, ret: %d, confirmType: %d, appid: %s", Integer.valueOf(c42908k.kdT), Integer.valueOf(c42908k.kKC), downloadInterceptBean.appId);
                    if (c42908k.kdT != 0) {
                        downloadInterceptBean.csN = false;
                    } else if (!downloadInterceptBean.csN) {
                        c42908k.kdT = C20326c.kMx;
                    }
                    C20326c.m31429a(downloadInterceptBean.appId, this.val$downloadUrl, downloadInterceptBean.downloadUrl, String.valueOf(c42908k.kdT), this.kMo, this.cgp, String.valueOf(c42908k.kKC));
                } else {
                    downloadInterceptBean.csN = false;
                }
            } else {
                downloadInterceptBean.csN = false;
            }
            if (this.eFW != null) {
                this.eFW.mo5960ao(downloadInterceptBean);
            }
            AppMethodBeat.m2505o(2344);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$DownloadInterceptBean */
    static class DownloadInterceptBean implements Parcelable {
        public static final Creator<DownloadInterceptBean> CREATOR = new C203201();
        public String appId;
        public String appName;
        public int cBA;
        public boolean csN;
        public String cvZ;
        public String downloadUrl;
        public String iconUrl;
        public int kMp;
        public String kMq;
        public String kMr;
        public boolean kMs;
        public String packageName;
        public long size;

        /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$DownloadInterceptBean$1 */
        static class C203201 implements Creator<DownloadInterceptBean> {
            C203201() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DownloadInterceptBean[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(2345);
                DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean(parcel, (byte) 0);
                AppMethodBeat.m2505o(2345);
                return downloadInterceptBean;
            }
        }

        /* synthetic */ DownloadInterceptBean(Parcel parcel, byte b) {
            this(parcel);
        }

        private DownloadInterceptBean(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(2346);
            this.csN = parcel.readByte() != (byte) 0;
            this.kMp = parcel.readInt();
            this.kMq = parcel.readString();
            this.appId = parcel.readString();
            this.appName = parcel.readString();
            this.iconUrl = parcel.readString();
            this.downloadUrl = parcel.readString();
            this.kMr = parcel.readString();
            this.size = parcel.readLong();
            this.packageName = parcel.readString();
            this.cvZ = parcel.readString();
            this.cBA = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.kMs = z;
            AppMethodBeat.m2505o(2346);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(2347);
            parcel.writeByte((byte) (this.csN ? 1 : 0));
            parcel.writeInt(this.kMp);
            parcel.writeString(this.kMq);
            parcel.writeString(this.appId);
            parcel.writeString(this.appName);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.downloadUrl);
            parcel.writeString(this.kMr);
            parcel.writeLong(this.size);
            parcel.writeString(this.packageName);
            parcel.writeString(this.cvZ);
            parcel.writeInt(this.cBA);
            if (!this.kMs) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            AppMethodBeat.m2505o(2347);
        }

        static {
            AppMethodBeat.m2504i(2349);
            AppMethodBeat.m2505o(2349);
        }

        /* renamed from: a */
        static boolean m31427a(C33904d c33904d) {
            AppMethodBeat.m2504i(2348);
            if (c33904d == null || c33904d.kKr == null || c33904d.kKr.kLy == null || c33904d.kKr.kLy.kLn == null || !URLUtil.isNetworkUrl(c33904d.kKr.kLy.kLn.egm)) {
                C4990ab.m7416i("MicroMsg.DownloadChecker", "downloadInfo is invalid");
                AppMethodBeat.m2505o(2348);
                return false;
            }
            AppMethodBeat.m2505o(2348);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$b */
    static class C20325b implements C37866a<Bundle, DownloadInterceptBean> {
        private C20325b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(2351);
            Bundle bundle = (Bundle) obj;
            DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean();
            if (bundle == null) {
                downloadInterceptBean.csN = false;
                if (c18507c != null) {
                    c18507c.mo5960ao(downloadInterceptBean);
                }
                AppMethodBeat.m2505o(2351);
                return;
            }
            String string = bundle.getString("download_url");
            String string2 = bundle.getString("main_url");
            String string3 = bundle.getString("scene");
            if (C5046bo.isNullOrNil(string)) {
                downloadInterceptBean.csN = false;
                if (c18507c != null) {
                    c18507c.mo5960ao(downloadInterceptBean);
                }
                AppMethodBeat.m2505o(2351);
                return;
            }
            C38844j c38844j = new C38844j();
            c38844j.egm = string;
            c38844j.kKB = string2;
            c38844j.source = string3;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = c38844j;
            c1196a.fsK = new C42908k();
            c1196a.uri = "/cgi-bin/mmgame-bin/getdownloadinterceptinfo";
            c1196a.fsI = 2884;
            C1226w.m2654a(c1196a.acD(), new C68332(string, string2, string3, c18507c));
            AppMethodBeat.m2505o(2351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$c */
    static class C20326c {
        static int kMt = -2018122700;
        static int kMu = -2018122701;
        static int kMv = -2018122702;
        static int kMw = -2018122703;
        static int kMx = -2018122750;

        /* renamed from: a */
        static /* synthetic */ void m31429a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            String str8;
            String str9;
            AppMethodBeat.m2504i(2352);
            C4990ab.m7417i("MicroMsg.DownloadChecker", "reportInfo, appId:[ %s ], rawDownloadUrl:[ %s ], alterDownloadUrl:[ %s ], errCode:[ %s ], mainUrl:[ %s ], source:[ %s ], confirmType:[ %s ]", str, str2, str3, str4, str5, str6, str7);
            try {
                if (C5046bo.isNullOrNil(str2)) {
                    str8 = str2;
                } else {
                    str8 = URLEncoder.encode(str2, "UTF-8");
                }
                try {
                    if (C5046bo.isNullOrNil(str3)) {
                        str9 = str3;
                    } else {
                        str9 = URLEncoder.encode(str3, "UTF-8");
                    }
                    try {
                        if (!C5046bo.isNullOrNil(str5)) {
                            str5 = URLEncoder.encode(str5, "UTF-8");
                        }
                    } catch (UnsupportedEncodingException e) {
                    }
                } catch (UnsupportedEncodingException e2) {
                    str9 = str3;
                }
            } catch (UnsupportedEncodingException e3) {
                str9 = str3;
                str8 = str2;
            }
            C45406d b = C45406d.m83611b(16749, str, str8, str9, str4, str5, str6, str7);
            C7060h.pYm.mo8376a(b.eBH, b.eBI, true, false);
            AppMethodBeat.m2505o(2352);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$a */
    static class C20327a implements C45413i<DownloadInterceptBean, IPCLong> {
        private C20327a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(2350);
            DownloadInterceptBean downloadInterceptBean = (DownloadInterceptBean) obj;
            IPCLong iPCLong = new IPCLong();
            iPCLong.value = -1;
            if (downloadInterceptBean == null) {
                AppMethodBeat.m2505o(2350);
                return iPCLong;
            }
            if (downloadInterceptBean.kMs) {
                C45833a c45833a = new C45833a();
                c45833a.downloadUrl = downloadInterceptBean.downloadUrl;
                c45833a.kOB = downloadInterceptBean.kMr;
                c45833a.appId = downloadInterceptBean.appId;
                c45833a.appName = downloadInterceptBean.appName;
                c45833a.packageName = downloadInterceptBean.packageName;
                c45833a.kOC = downloadInterceptBean.size;
                c45833a.kOD = downloadInterceptBean.cvZ;
                c45833a.fileType = 1;
                c45833a.scene = 8070;
                c45833a.cBA = downloadInterceptBean.cBA;
                iPCLong.value = ((C38855d) C1720g.m3528K(C38855d.class)).mo61726a(c45833a, null);
            } else {
                C2901a c2901a = new C2901a();
                c2901a.mo7055It(downloadInterceptBean.downloadUrl);
                c2901a.mo7056Iu(downloadInterceptBean.kMr);
                c2901a.setAppId(downloadInterceptBean.appId);
                c2901a.mo7066hA(downloadInterceptBean.size);
                c2901a.mo7062cY(downloadInterceptBean.packageName);
                c2901a.mo7057Iv(C46494g.m87733b(C4996ah.getContext(), C46494g.m87739bT(downloadInterceptBean.appId, true), null));
                c2901a.mo7058Iw(downloadInterceptBean.cvZ);
                c2901a.mo7063ga(true);
                c2901a.mo7064gb(true);
                c2901a.mo7069tN(1);
                c2901a.setScene(8070);
                if (downloadInterceptBean.cBA == 1) {
                    iPCLong.value = C2896d.bij().mo7043b(c2901a.kNl);
                } else {
                    iPCLong.value = C2896d.bij().mo7042a(c2901a.kNl);
                }
            }
            C4990ab.m7417i("MicroMsg.DownloadChecker", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(iPCLong.value), downloadInterceptBean.appId, Integer.valueOf(downloadInterceptBean.cBA));
            AppMethodBeat.m2505o(2350);
            return iPCLong;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m31425a(final String str, String str2, WebView webView) {
        Exception e;
        AppMethodBeat.m2504i(2353);
        if (C5046bo.isNullOrNil(str) || C5059g.dnY()) {
            AppMethodBeat.m2505o(2353);
            return false;
        }
        String str3;
        try {
            List<String> bDm = C45985a.bDm();
            if (C5046bo.m7548ek(bDm)) {
                C4990ab.m7417i("MicroMsg.DownloadChecker", "raw check url: [ %s ], no regex to intercept", str);
                AppMethodBeat.m2505o(2353);
                return false;
            }
            C4990ab.m7417i("MicroMsg.DownloadChecker", "raw check url: [ %s ], have (%d) regexes to intercept", str, Integer.valueOf(bDm.size()));
            for (String str32 : bDm) {
                Matcher matcher = Pattern.compile(str32).matcher(str.trim());
                if (matcher.find()) {
                    String group = matcher.group();
                    try {
                        C4990ab.m7417i("MicroMsg.DownloadChecker", "match the regex: %s", str32);
                        str32 = group;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        str32 = group;
                        C4990ab.m7413e("MicroMsg.DownloadChecker", "err: %s", e.getMessage());
                        if (C5046bo.isNullOrNil(str32)) {
                        }
                    }
                }
            }
            str32 = null;
            if (C5046bo.isNullOrNil(str32)) {
                AppMethodBeat.m2505o(2353);
                return false;
            }
            final WeakReference weakReference = new WeakReference(webView);
            Bundle bundle = new Bundle();
            bundle.putString("download_url", str32);
            bundle.putString("main_url", webView.getUrl());
            bundle.putString("scene", str2);
            C9549f.m17012a("com.tencent.mm", bundle, C20325b.class, new C18507c<DownloadInterceptBean>() {
                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(2343);
                    final DownloadInterceptBean downloadInterceptBean = (DownloadInterceptBean) obj;
                    C5004al.m7441d(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$1$1$1 */
                        class C203231 implements OnClickListener {
                            C203231() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(2340);
                                if (((IPCLong) C9549f.m17010a("com.tencent.mm", downloadInterceptBean, C20327a.class)).value > 0) {
                                    Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.g7h), 0).show();
                                }
                                dialogInterface.dismiss();
                                AppMethodBeat.m2505o(2340);
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$1$1$2 */
                        class C203242 implements OnClickListener {
                            C203242() {
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(2341);
                                dialogInterface.dismiss();
                                AppMethodBeat.m2505o(2341);
                            }
                        }

                        public final void run() {
                            Context context;
                            WebView webView;
                            AppMethodBeat.m2504i(2342);
                            if (weakReference == null || weakReference.get() == null) {
                                context = null;
                                webView = null;
                            } else {
                                WebView webView2 = (WebView) weakReference.get();
                                if (webView2 != null) {
                                    context = webView2.getContext();
                                    webView = webView2;
                                } else {
                                    context = null;
                                    webView = webView2;
                                }
                            }
                            if (downloadInterceptBean != null && downloadInterceptBean.csN) {
                                Context context2;
                                C4990ab.m7417i("MicroMsg.DownloadChecker", "confirm type: %d", Integer.valueOf(downloadInterceptBean.kMp));
                                if (context == null) {
                                    context2 = C4996ah.getContext();
                                } else {
                                    context2 = context;
                                }
                                switch (downloadInterceptBean.kMp) {
                                    case 0:
                                        if (!C5023at.isNetworkConnected(C4996ah.getContext())) {
                                            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.c5d), 0).show();
                                            C4990ab.m7416i("MicroMsg.DownloadChecker", "startDownload fail, network not ready");
                                            AppMethodBeat.m2505o(2342);
                                            return;
                                        } else if (C5023at.isWifi(C4996ah.getContext()) || !(context2 instanceof MMActivity) || ((MMActivity) context2).isFinishing()) {
                                            if (((IPCLong) C9549f.m17010a("com.tencent.mm", downloadInterceptBean, C20327a.class)).value > 0) {
                                                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.g7h), 0).show();
                                            }
                                            AppMethodBeat.m2505o(2342);
                                            return;
                                        } else {
                                            C30379h.m48446a(context2, C4996ah.getResources().getString(C25738R.string.fy6), C4996ah.getResources().getString(C25738R.string.fy7), C4996ah.getResources().getString(C25738R.string.fy1), C4996ah.getResources().getString(C25738R.string.f9076or), false, new C203231(), new C203242(), (int) C25738R.color.a61);
                                            AppMethodBeat.m2505o(2342);
                                            return;
                                        }
                                    case 1:
                                        Intent intent = new Intent();
                                        intent.setClassName(context2, "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
                                        intent.putExtra("task_name", downloadInterceptBean.appName);
                                        intent.putExtra("title", downloadInterceptBean.appName);
                                        intent.putExtra("thumb_url", downloadInterceptBean.iconUrl);
                                        intent.putExtra("task_url", downloadInterceptBean.downloadUrl);
                                        intent.putExtra("alternative_url", downloadInterceptBean.kMr);
                                        intent.putExtra("task_size", downloadInterceptBean.size);
                                        intent.putExtra("file_md5", downloadInterceptBean.cvZ);
                                        intent.putExtra("fileType", 1);
                                        intent.putExtra("appid", downloadInterceptBean.appId);
                                        intent.putExtra("package_name", downloadInterceptBean.packageName);
                                        if (webView != null) {
                                            intent.putExtra("page_url", webView.getUrl());
                                        }
                                        intent.putExtra("page_scene", -1);
                                        intent.putExtra("task_scene", 8070);
                                        intent.addFlags(268435456);
                                        C4996ah.getContext().startActivity(intent);
                                        AppMethodBeat.m2505o(2342);
                                        return;
                                    case 2:
                                        C4990ab.m7417i("MicroMsg.DownloadChecker", "coonfirm url: %s", downloadInterceptBean.kMq);
                                        break;
                                }
                            } else if (webView != null) {
                                webView.loadUrl(str);
                                C4990ab.m7416i("MicroMsg.DownloadChecker", "reload apk");
                                AppMethodBeat.m2505o(2342);
                                return;
                            }
                            AppMethodBeat.m2505o(2342);
                        }
                    });
                    AppMethodBeat.m2505o(2343);
                }
            });
            AppMethodBeat.m2505o(2353);
            return true;
        } catch (Exception e3) {
            e = e3;
            str32 = null;
            C4990ab.m7413e("MicroMsg.DownloadChecker", "err: %s", e.getMessage());
            if (C5046bo.isNullOrNil(str32)) {
            }
        }
    }
}
