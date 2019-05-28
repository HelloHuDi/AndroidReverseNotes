package com.tencent.mm.plugin.downloader.model;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.d;
import com.tencent.mm.plugin.downloader.c.a.a.j;
import com.tencent.mm.plugin.downloader.c.a.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DownloadChecker {

    /* renamed from: com.tencent.mm.plugin.downloader.model.DownloadChecker$2 */
    static class AnonymousClass2 implements com.tencent.mm.ai.w.a {
        final /* synthetic */ String cgp;
        final /* synthetic */ com.tencent.mm.ipcinvoker.c eFW;
        final /* synthetic */ String kMo;
        final /* synthetic */ String val$downloadUrl;

        AnonymousClass2(String str, String str2, String str3, com.tencent.mm.ipcinvoker.c cVar) {
            this.val$downloadUrl = str;
            this.kMo = str2;
            this.cgp = str3;
            this.eFW = cVar;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            AppMethodBeat.i(2344);
            ab.i("MicroMsg.DownloadChecker", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean();
            if (i == 0 && i2 == 0) {
                k kVar = (k) bVar.fsH.fsP;
                if (kVar != null) {
                    int i3 = kVar.kKC;
                    String str2 = kVar.kKD;
                    d dVar = kVar.kKy;
                    if (DownloadInterceptBean.a(dVar)) {
                        downloadInterceptBean.csN = true;
                        downloadInterceptBean.kMp = i3;
                        downloadInterceptBean.kMq = str2;
                        downloadInterceptBean.appId = dVar.kKr.kLw == null ? null : dVar.kKr.kLw.csB;
                        downloadInterceptBean.appName = dVar.kKr.kLw == null ? null : dVar.kKr.kLw.kKY;
                        downloadInterceptBean.iconUrl = dVar.kKr.kLw == null ? null : dVar.kKr.kLw.kKZ;
                        downloadInterceptBean.downloadUrl = dVar.kKr.kLy.kLn.egm;
                        downloadInterceptBean.kMr = dVar.kKr.kLy.kLn.kKV;
                        downloadInterceptBean.size = dVar.kKr.kLy.kLn.kKP;
                        downloadInterceptBean.packageName = dVar.kKr.kLy.kLn.kKO;
                        downloadInterceptBean.cvZ = dVar.kKr.kLy.kLn.kKQ;
                        downloadInterceptBean.cBA = dVar.kKr.kLy.kLn.kKR;
                        downloadInterceptBean.kMs = dVar.kKr.kLy.kLr;
                    } else {
                        downloadInterceptBean.csN = false;
                    }
                    ab.i("MicroMsg.DownloadChecker", "check download from net, ret: %d, confirmType: %d, appid: %s", Integer.valueOf(kVar.kdT), Integer.valueOf(kVar.kKC), downloadInterceptBean.appId);
                    if (kVar.kdT != 0) {
                        downloadInterceptBean.csN = false;
                    } else if (!downloadInterceptBean.csN) {
                        kVar.kdT = c.kMx;
                    }
                    c.a(downloadInterceptBean.appId, this.val$downloadUrl, downloadInterceptBean.downloadUrl, String.valueOf(kVar.kdT), this.kMo, this.cgp, String.valueOf(kVar.kKC));
                } else {
                    downloadInterceptBean.csN = false;
                }
            } else {
                downloadInterceptBean.csN = false;
            }
            if (this.eFW != null) {
                this.eFW.ao(downloadInterceptBean);
            }
            AppMethodBeat.o(2344);
            return 0;
        }
    }

    static class DownloadInterceptBean implements Parcelable {
        public static final Creator<DownloadInterceptBean> CREATOR = new Creator<DownloadInterceptBean>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DownloadInterceptBean[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(2345);
                DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean(parcel, (byte) 0);
                AppMethodBeat.o(2345);
                return downloadInterceptBean;
            }
        };
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

        /* synthetic */ DownloadInterceptBean(Parcel parcel, byte b) {
            this(parcel);
        }

        private DownloadInterceptBean(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(2346);
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
            AppMethodBeat.o(2346);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            AppMethodBeat.i(2347);
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
            AppMethodBeat.o(2347);
        }

        static {
            AppMethodBeat.i(2349);
            AppMethodBeat.o(2349);
        }

        static boolean a(d dVar) {
            AppMethodBeat.i(2348);
            if (dVar == null || dVar.kKr == null || dVar.kKr.kLy == null || dVar.kKr.kLy.kLn == null || !URLUtil.isNetworkUrl(dVar.kKr.kLy.kLn.egm)) {
                ab.i("MicroMsg.DownloadChecker", "downloadInfo is invalid");
                AppMethodBeat.o(2348);
                return false;
            }
            AppMethodBeat.o(2348);
            return true;
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, DownloadInterceptBean> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(2351);
            Bundle bundle = (Bundle) obj;
            DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean();
            if (bundle == null) {
                downloadInterceptBean.csN = false;
                if (cVar != null) {
                    cVar.ao(downloadInterceptBean);
                }
                AppMethodBeat.o(2351);
                return;
            }
            String string = bundle.getString("download_url");
            String string2 = bundle.getString("main_url");
            String string3 = bundle.getString("scene");
            if (bo.isNullOrNil(string)) {
                downloadInterceptBean.csN = false;
                if (cVar != null) {
                    cVar.ao(downloadInterceptBean);
                }
                AppMethodBeat.o(2351);
                return;
            }
            j jVar = new j();
            jVar.egm = string;
            jVar.kKB = string2;
            jVar.source = string3;
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = jVar;
            aVar.fsK = new k();
            aVar.uri = "/cgi-bin/mmgame-bin/getdownloadinterceptinfo";
            aVar.fsI = 2884;
            w.a(aVar.acD(), new AnonymousClass2(string, string2, string3, cVar));
            AppMethodBeat.o(2351);
        }
    }

    static class c {
        static int kMt = -2018122700;
        static int kMu = -2018122701;
        static int kMv = -2018122702;
        static int kMw = -2018122703;
        static int kMx = -2018122750;

        static /* synthetic */ void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            String str8;
            String str9;
            AppMethodBeat.i(2352);
            ab.i("MicroMsg.DownloadChecker", "reportInfo, appId:[ %s ], rawDownloadUrl:[ %s ], alterDownloadUrl:[ %s ], errCode:[ %s ], mainUrl:[ %s ], source:[ %s ], confirmType:[ %s ]", str, str2, str3, str4, str5, str6, str7);
            try {
                if (bo.isNullOrNil(str2)) {
                    str8 = str2;
                } else {
                    str8 = URLEncoder.encode(str2, "UTF-8");
                }
                try {
                    if (bo.isNullOrNil(str3)) {
                        str9 = str3;
                    } else {
                        str9 = URLEncoder.encode(str3, "UTF-8");
                    }
                    try {
                        if (!bo.isNullOrNil(str5)) {
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
            com.tencent.mm.game.report.api.d b = com.tencent.mm.game.report.api.d.b(16749, str, str8, str9, str4, str5, str6, str7);
            h.pYm.a(b.eBH, b.eBI, true, false);
            AppMethodBeat.o(2352);
        }
    }

    static class a implements i<DownloadInterceptBean, IPCLong> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2350);
            DownloadInterceptBean downloadInterceptBean = (DownloadInterceptBean) obj;
            IPCLong iPCLong = new IPCLong();
            iPCLong.value = -1;
            if (downloadInterceptBean == null) {
                AppMethodBeat.o(2350);
                return iPCLong;
            }
            if (downloadInterceptBean.kMs) {
                com.tencent.mm.plugin.downloader_app.b.a aVar = new com.tencent.mm.plugin.downloader_app.b.a();
                aVar.downloadUrl = downloadInterceptBean.downloadUrl;
                aVar.kOB = downloadInterceptBean.kMr;
                aVar.appId = downloadInterceptBean.appId;
                aVar.appName = downloadInterceptBean.appName;
                aVar.packageName = downloadInterceptBean.packageName;
                aVar.kOC = downloadInterceptBean.size;
                aVar.kOD = downloadInterceptBean.cvZ;
                aVar.fileType = 1;
                aVar.scene = 8070;
                aVar.cBA = downloadInterceptBean.cBA;
                iPCLong.value = ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(aVar, null);
            } else {
                com.tencent.mm.plugin.downloader.model.e.a aVar2 = new com.tencent.mm.plugin.downloader.model.e.a();
                aVar2.It(downloadInterceptBean.downloadUrl);
                aVar2.Iu(downloadInterceptBean.kMr);
                aVar2.setAppId(downloadInterceptBean.appId);
                aVar2.hA(downloadInterceptBean.size);
                aVar2.cY(downloadInterceptBean.packageName);
                aVar2.Iv(com.tencent.mm.pluginsdk.model.app.g.b(ah.getContext(), com.tencent.mm.pluginsdk.model.app.g.bT(downloadInterceptBean.appId, true), null));
                aVar2.Iw(downloadInterceptBean.cvZ);
                aVar2.ga(true);
                aVar2.gb(true);
                aVar2.tN(1);
                aVar2.setScene(8070);
                if (downloadInterceptBean.cBA == 1) {
                    iPCLong.value = d.bij().b(aVar2.kNl);
                } else {
                    iPCLong.value = d.bij().a(aVar2.kNl);
                }
            }
            ab.i("MicroMsg.DownloadChecker", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(iPCLong.value), downloadInterceptBean.appId, Integer.valueOf(downloadInterceptBean.cBA));
            AppMethodBeat.o(2350);
            return iPCLong;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final String str, String str2, WebView webView) {
        Exception e;
        AppMethodBeat.i(2353);
        if (bo.isNullOrNil(str) || com.tencent.mm.sdk.platformtools.g.dnY()) {
            AppMethodBeat.o(2353);
            return false;
        }
        String str3;
        try {
            List<String> bDm = com.tencent.mm.plugin.game.commlib.a.bDm();
            if (bo.ek(bDm)) {
                ab.i("MicroMsg.DownloadChecker", "raw check url: [ %s ], no regex to intercept", str);
                AppMethodBeat.o(2353);
                return false;
            }
            ab.i("MicroMsg.DownloadChecker", "raw check url: [ %s ], have (%d) regexes to intercept", str, Integer.valueOf(bDm.size()));
            for (String str32 : bDm) {
                Matcher matcher = Pattern.compile(str32).matcher(str.trim());
                if (matcher.find()) {
                    String group = matcher.group();
                    try {
                        ab.i("MicroMsg.DownloadChecker", "match the regex: %s", str32);
                        str32 = group;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        str32 = group;
                        ab.e("MicroMsg.DownloadChecker", "err: %s", e.getMessage());
                        if (bo.isNullOrNil(str32)) {
                        }
                    }
                }
            }
            str32 = null;
            if (bo.isNullOrNil(str32)) {
                AppMethodBeat.o(2353);
                return false;
            }
            final WeakReference weakReference = new WeakReference(webView);
            Bundle bundle = new Bundle();
            bundle.putString("download_url", str32);
            bundle.putString("main_url", webView.getUrl());
            bundle.putString("scene", str2);
            f.a("com.tencent.mm", bundle, b.class, new com.tencent.mm.ipcinvoker.c<DownloadInterceptBean>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(2343);
                    final DownloadInterceptBean downloadInterceptBean = (DownloadInterceptBean) obj;
                    al.d(new Runnable() {
                        public final void run() {
                            Context context;
                            WebView webView;
                            AppMethodBeat.i(2342);
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
                                ab.i("MicroMsg.DownloadChecker", "confirm type: %d", Integer.valueOf(downloadInterceptBean.kMp));
                                if (context == null) {
                                    context2 = ah.getContext();
                                } else {
                                    context2 = context;
                                }
                                switch (downloadInterceptBean.kMp) {
                                    case 0:
                                        if (!at.isNetworkConnected(ah.getContext())) {
                                            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.c5d), 0).show();
                                            ab.i("MicroMsg.DownloadChecker", "startDownload fail, network not ready");
                                            AppMethodBeat.o(2342);
                                            return;
                                        } else if (at.isWifi(ah.getContext()) || !(context2 instanceof MMActivity) || ((MMActivity) context2).isFinishing()) {
                                            if (((IPCLong) f.a("com.tencent.mm", downloadInterceptBean, a.class)).value > 0) {
                                                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.g7h), 0).show();
                                            }
                                            AppMethodBeat.o(2342);
                                            return;
                                        } else {
                                            com.tencent.mm.ui.base.h.a(context2, ah.getResources().getString(R.string.fy6), ah.getResources().getString(R.string.fy7), ah.getResources().getString(R.string.fy1), ah.getResources().getString(R.string.or), false, new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.i(2340);
                                                    if (((IPCLong) f.a("com.tencent.mm", downloadInterceptBean, a.class)).value > 0) {
                                                        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.g7h), 0).show();
                                                    }
                                                    dialogInterface.dismiss();
                                                    AppMethodBeat.o(2340);
                                                }
                                            }, new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.i(2341);
                                                    dialogInterface.dismiss();
                                                    AppMethodBeat.o(2341);
                                                }
                                            }, (int) R.color.a61);
                                            AppMethodBeat.o(2342);
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
                                        ah.getContext().startActivity(intent);
                                        AppMethodBeat.o(2342);
                                        return;
                                    case 2:
                                        ab.i("MicroMsg.DownloadChecker", "coonfirm url: %s", downloadInterceptBean.kMq);
                                        break;
                                }
                            } else if (webView != null) {
                                webView.loadUrl(str);
                                ab.i("MicroMsg.DownloadChecker", "reload apk");
                                AppMethodBeat.o(2342);
                                return;
                            }
                            AppMethodBeat.o(2342);
                        }
                    });
                    AppMethodBeat.o(2343);
                }
            });
            AppMethodBeat.o(2353);
            return true;
        } catch (Exception e3) {
            e = e3;
            str32 = null;
            ab.e("MicroMsg.DownloadChecker", "err: %s", e.getMessage());
            if (bo.isNullOrNil(str32)) {
            }
        }
    }
}
