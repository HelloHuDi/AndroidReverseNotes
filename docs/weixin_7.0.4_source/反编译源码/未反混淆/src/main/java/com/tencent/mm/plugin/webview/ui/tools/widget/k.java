package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class k extends s {
    public MMWebView fow;
    protected Activity gNy;
    ak mHandler;
    protected String mTH;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d uDd;
    private f uDh;
    public com.tencent.mm.plugin.webview.ui.tools.k uFu;
    private boolean uJA;
    protected Map<String, String> uJB;
    protected c uJC;
    public m uJD;
    final Bundle uJm;
    protected boolean uJn;
    private String uJo;
    private Set<String> uJp;
    protected b uJq;
    protected a uJr;
    private an uJs;
    protected String uJt;
    protected String uJu;
    private String uJv;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> uJw;
    private final Map<String, String> uJx;
    protected boolean uJy;
    protected boolean uJz;
    private final Map<String, Map<String, String>> uwr;
    public com.tencent.mm.plugin.webview.stub.d uzS;

    public static class a {
        private static final Pattern hnu = Pattern.compile(".*#.*wechat_redirect");
        private String jVi = null;

        static {
            AppMethodBeat.i(9965);
            AppMethodBeat.o(9965);
        }

        public a(String str) {
            this.jVi = str;
        }

        public final int ael(String str) {
            AppMethodBeat.i(9964);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
                AppMethodBeat.o(9964);
                return 0;
            } else if (str.equals(this.jVi)) {
                AppMethodBeat.o(9964);
                return 0;
            } else if (hnu.matcher(str).find()) {
                AppMethodBeat.o(9964);
                return 2;
            } else {
                AppMethodBeat.o(9964);
                return 1;
            }
        }
    }

    public class c implements ServiceConnection {
        protected c() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(9967);
            ab.i("MicroMsg.MMWebViewClient", "onServiceConnected");
            if (k.this.fow == null) {
                ab.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
                AppMethodBeat.o(9967);
                return;
            }
            try {
                k.this.uzS = com.tencent.mm.plugin.webview.stub.d.a.G(iBinder);
                k.this.uzS.a(new d(new WeakReference(k.this.uJD)), k.this.fow.hashCode());
                if (k.this.uJm != null) {
                    k.this.uzS.a(k.this.uJm, k.this.fow.hashCode());
                }
                k.this.dcU();
                k.this.dbU();
                k.this.a(k.this.uzS, k.this.uFu);
                AppMethodBeat.o(9967);
            } catch (Exception e) {
                ab.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", e.getMessage());
                AppMethodBeat.o(9967);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(9968);
            ab.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
            if (k.this.gNy.isFinishing()) {
                k.this.uzS = null;
                AppMethodBeat.o(9968);
                return;
            }
            ab.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
            k.a(k.this);
            AppMethodBeat.o(9968);
        }
    }

    protected class b {
        int uxN = 0;

        protected b() {
        }

        public final void daN() {
            AppMethodBeat.i(9966);
            if (this.uxN == 0) {
                k.b(k.this);
            }
            this.uxN++;
            AppMethodBeat.o(9966);
        }
    }

    protected static class d extends m {
        private WeakReference<m> iuM;

        public d(WeakReference<m> weakReference) {
            this.iuM = weakReference;
        }

        public final boolean IZ(int i) {
            AppMethodBeat.i(9969);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                boolean IZ = mVar.IZ(i);
                AppMethodBeat.o(9969);
                return IZ;
            }
            AppMethodBeat.o(9969);
            return false;
        }

        public final boolean c(int i, Bundle bundle) {
            AppMethodBeat.i(9970);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                boolean c = mVar.c(i, bundle);
                AppMethodBeat.o(9970);
                return c;
            }
            AppMethodBeat.o(9970);
            return false;
        }

        public final boolean a(com.tencent.mm.plugin.webview.stub.c cVar) {
            AppMethodBeat.i(9971);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                boolean a = mVar.a(cVar);
                AppMethodBeat.o(9971);
                return a;
            }
            AppMethodBeat.o(9971);
            return false;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.i(9972);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                boolean a = mVar.a(str, str2, bundle, z);
                AppMethodBeat.o(9972);
                return a;
            }
            AppMethodBeat.o(9972);
            return false;
        }

        public final String cYY() {
            AppMethodBeat.i(9973);
            m mVar = (m) this.iuM.get();
            String cYY;
            if (mVar != null) {
                cYY = mVar.cYY();
                AppMethodBeat.o(9973);
                return cYY;
            }
            cYY = "";
            AppMethodBeat.o(9973);
            return cYY;
        }

        public final String getCurrentUrl() {
            AppMethodBeat.i(9974);
            m mVar = (m) this.iuM.get();
            String currentUrl;
            if (mVar != null) {
                currentUrl = mVar.getCurrentUrl();
                AppMethodBeat.o(9974);
                return currentUrl;
            }
            currentUrl = "";
            AppMethodBeat.o(9974);
            return currentUrl;
        }

        public final String cYZ() {
            AppMethodBeat.i(9975);
            m mVar = (m) this.iuM.get();
            String cYZ;
            if (mVar != null) {
                cYZ = mVar.cYZ();
                AppMethodBeat.o(9975);
                return cYZ;
            }
            cYZ = "";
            AppMethodBeat.o(9975);
            return cYZ;
        }

        public final void nJ(boolean z) {
            AppMethodBeat.i(9976);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.nJ(z);
            }
            AppMethodBeat.o(9976);
        }

        public final void nK(boolean z) {
            AppMethodBeat.i(9977);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.nK(z);
            }
            AppMethodBeat.o(9977);
        }

        public final void q(int i, Bundle bundle) {
            AppMethodBeat.i(9978);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.q(i, bundle);
            }
            AppMethodBeat.o(9978);
        }

        public final void cZb() {
            AppMethodBeat.i(9979);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.cZb();
            }
            AppMethodBeat.o(9979);
        }

        public final void W(Bundle bundle) {
            AppMethodBeat.i(9980);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.W(bundle);
            }
            AppMethodBeat.o(9980);
        }

        public final void afd(String str) {
            AppMethodBeat.i(9981);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.afd(str);
            }
            AppMethodBeat.o(9981);
        }

        public final void hd(String str, String str2) {
            AppMethodBeat.i(9982);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.hd(str, str2);
            }
            AppMethodBeat.o(9982);
        }

        public final void cZc() {
            AppMethodBeat.i(9983);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.cZc();
            }
            AppMethodBeat.o(9983);
        }

        public final void e(String str, String str2, int i, int i2) {
            AppMethodBeat.i(9984);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.e(str, str2, i, i2);
            }
            AppMethodBeat.o(9984);
        }

        public final Bundle g(int i, Bundle bundle) {
            AppMethodBeat.i(9985);
            m mVar = (m) this.iuM.get();
            Bundle g;
            if (mVar != null) {
                g = mVar.g(i, bundle);
                AppMethodBeat.o(9985);
                return g;
            }
            g = new Bundle();
            AppMethodBeat.o(9985);
            return g;
        }

        public final void X(Bundle bundle) {
            AppMethodBeat.i(9986);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.X(bundle);
            }
            AppMethodBeat.o(9986);
        }

        public final void nL(boolean z) {
            AppMethodBeat.i(9987);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.nL(z);
            }
            AppMethodBeat.o(9987);
        }

        public final void he(String str, String str2) {
            AppMethodBeat.i(9988);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                mVar.he(str, str2);
            }
            AppMethodBeat.o(9988);
        }

        public final Bundle dj(String str, String str2) {
            AppMethodBeat.i(9989);
            m mVar = (m) this.iuM.get();
            if (mVar != null) {
                Bundle dj = mVar.dj(str, str2);
                AppMethodBeat.o(9989);
                return dj;
            }
            AppMethodBeat.o(9989);
            return null;
        }
    }

    static /* synthetic */ String c(k kVar) {
        AppMethodBeat.i(10020);
        String dae = kVar.dae();
        AppMethodBeat.o(10020);
        return dae;
    }

    public k(MMWebView mMWebView) {
        this(mMWebView, (byte) 0);
    }

    public k(MMWebView mMWebView, byte b) {
        this(mMWebView, false, null);
    }

    public k(MMWebView mMWebView, boolean z, Bundle bundle) {
        AppMethodBeat.i(9990);
        this.uDh = null;
        this.uDd = null;
        this.uJn = false;
        this.uJo = "";
        this.uJp = new HashSet();
        this.uJq = new b();
        this.uJr = new a(null);
        this.uJt = null;
        this.uJu = null;
        this.uJv = null;
        this.uJw = new ArrayList();
        this.uJx = new HashMap();
        this.uwr = new ConcurrentHashMap();
        this.uJy = false;
        this.uJz = false;
        this.uJA = false;
        this.uJC = new c();
        this.uJD = new m() {
            private m uJF = new m();

            {
                AppMethodBeat.i(9942);
                AppMethodBeat.o(9942);
            }

            private m dcW() {
                AppMethodBeat.i(9943);
                m aGt = k.this.aGt();
                if (aGt == null) {
                    aGt = this.uJF;
                    AppMethodBeat.o(9943);
                    return aGt;
                }
                AppMethodBeat.o(9943);
                return aGt;
            }

            public final boolean IZ(int i) {
                AppMethodBeat.i(9944);
                boolean IZ = dcW().IZ(i);
                AppMethodBeat.o(9944);
                return IZ;
            }

            public final boolean c(int i, final Bundle bundle) {
                AppMethodBeat.i(9945);
                ab.i("MicroMsg.MMWebViewClient", "callback, actionCode = ".concat(String.valueOf(i)));
                final String string;
                final HashMap hashMap;
                final String string2;
                final int i2;
                switch (i) {
                    case 90:
                        if (k.this.uDd != null) {
                            k.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(9929);
                                    if (k.this.uDd != null) {
                                        k.this.uDd.ags(bundle.getString("webview_network_type"));
                                    }
                                    AppMethodBeat.o(9929);
                                }
                            });
                            break;
                        }
                        break;
                    case 1002:
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9925);
                                if (!(k.this.uDd == null || k.this.uFu == null || k.this.uFu.cZS() == null || !k.this.uFu.cZS().jB(42))) {
                                    k.this.uDd.i(bundle, "download_succ");
                                }
                                AppMethodBeat.o(9925);
                            }
                        });
                        break;
                    case 1003:
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9934);
                                if (!(k.this.uDd == null || k.this.uFu == null || k.this.uFu.cZS() == null || !k.this.uFu.cZS().jB(42))) {
                                    k.this.uDd.i(bundle, "download_fail");
                                }
                                AppMethodBeat.o(9934);
                            }
                        });
                        break;
                    case 1006:
                        if (k.this.uDd != null) {
                            k.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    boolean z = false;
                                    AppMethodBeat.i(9928);
                                    byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                    if (byteArray == null || k.this.uFu == null || k.this.uFu.cZS() == null) {
                                        String str = "MicroMsg.MMWebViewClient";
                                        String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Boolean.valueOf(byteArray != null);
                                        if (k.this.uFu != null) {
                                            z = true;
                                        }
                                        objArr[1] = Boolean.valueOf(z);
                                        ab.e(str, str2, objArr);
                                    } else {
                                        ab.i("MicroMsg.MMWebViewClient", "update control bytes by preverify, %d", Integer.valueOf(byteArray.length));
                                        k.this.uFu.cZS().vxM = byteArray;
                                    }
                                    if (k.this.uDd != null) {
                                        k.this.uDd.dcj();
                                    }
                                    AppMethodBeat.o(9928);
                                }
                            });
                            break;
                        }
                        break;
                    case 1007:
                        final long j = bundle.getLong("download_manager_downloadid");
                        final int i3 = bundle.getInt("download_manager_progress");
                        string = bundle.getString("download_manager_appid", "");
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9936);
                                if (!(k.this.uDd == null || k.this.uFu == null || k.this.uFu.cZS() == null || !k.this.uFu.cZS().jB(42))) {
                                    k.this.uDd.n(string, j, i3);
                                }
                                AppMethodBeat.o(9936);
                            }
                        });
                        break;
                    case 1008:
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9935);
                                if (!(k.this.uDd == null || k.this.uFu == null || k.this.uFu.cZS() == null || !k.this.uFu.cZS().jB(42))) {
                                    k.this.uDd.i(bundle, "download_removed");
                                }
                                AppMethodBeat.o(9935);
                            }
                        });
                        break;
                    case 2002:
                        hashMap = new HashMap();
                        hashMap.put("err_msg", bundle.getString("playResult"));
                        hashMap.put("localId", bundle.getString("localId"));
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9926);
                                if (k.this.uDd != null) {
                                    k.this.uDd.aM(hashMap);
                                }
                                AppMethodBeat.o(9926);
                            }
                        });
                        break;
                    case 2003:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9937);
                                if (k.this.uDd != null) {
                                    k.this.uDd.dH(string2, i2);
                                }
                                AppMethodBeat.o(9937);
                            }
                        });
                        break;
                    case 2004:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9938);
                                if (k.this.uDd != null) {
                                    k.this.uDd.dI(string2, i2);
                                }
                                AppMethodBeat.o(9938);
                            }
                        });
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9939);
                                if (k.this.uDd != null) {
                                    k.this.uDd.dJ(string2, i2);
                                }
                                AppMethodBeat.o(9939);
                            }
                        });
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9940);
                                if (k.this.uDd != null) {
                                    k.this.uDd.dK(string2, i2);
                                }
                                AppMethodBeat.o(9940);
                            }
                        });
                        break;
                    case 2008:
                        hashMap = new HashMap();
                        hashMap.put("localId", bundle.getString("localId"));
                        hashMap.put("err_msg", bundle.getString("recordResult"));
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9927);
                                if (k.this.uDd != null) {
                                    k.this.uDd.aN(hashMap);
                                }
                                AppMethodBeat.o(9927);
                            }
                        });
                        break;
                    case 2010:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9941);
                                if (k.this.uDd != null) {
                                    k.this.uDd.dL(string2, i2);
                                }
                                AppMethodBeat.o(9941);
                            }
                        });
                        break;
                    case CdnLogic.kMediaTypeStoryAudio /*40001*/:
                        if (k.this.uDd != null) {
                            string2 = bundle.getString("err_msg");
                            k.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(9930);
                                    if (k.this.uDd != null) {
                                        k.this.uDd.agp(string2);
                                    }
                                    AppMethodBeat.o(9930);
                                }
                            });
                            break;
                        }
                        break;
                    case 40002:
                        string = bundle.getString("uuid");
                        final int i4 = bundle.getInt("major");
                        final int i5 = bundle.getInt("minor");
                        final double d = bundle.getDouble("accuracy");
                        final double d2 = bundle.getDouble("rssi");
                        final float f = bundle.getFloat("heading");
                        if (k.this.uDd != null) {
                            final String string3 = bundle.getString("err_msg");
                            k.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(9931);
                                    if (k.this.uDd != null) {
                                        k.this.uDd.agp(string3);
                                        k.this.uDd.a(string, i4, i5, d, d2, f);
                                    }
                                    AppMethodBeat.o(9931);
                                }
                            });
                            break;
                        }
                        break;
                    default:
                        ab.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                        break;
                }
                dcW().c(i, bundle);
                AppMethodBeat.o(9945);
                return true;
            }

            public final boolean a(com.tencent.mm.plugin.webview.stub.c cVar) {
                AppMethodBeat.i(9946);
                if (k.this.fow == null) {
                    AppMethodBeat.o(9946);
                    return true;
                }
                ab.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + k.this.fow.hashCode());
                final int type = cVar.getType();
                final int cYW = cVar.cYW();
                final int cYX = cVar.cYX();
                final String adx = cVar.adx();
                final Bundle data = cVar.getData();
                k.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9932);
                        try {
                            k.a(k.this, type, cYW, cYX, data != null ? data : new Bundle());
                            AppMethodBeat.o(9932);
                        } catch (Exception e) {
                            ab.e("MicroMsg.MMWebViewClient", e.getMessage());
                            AppMethodBeat.o(9932);
                        }
                    }
                });
                boolean a = dcW().a(cVar);
                AppMethodBeat.o(9946);
                return a;
            }

            public final boolean a(String str, String str2, Bundle bundle, boolean z) {
                AppMethodBeat.i(9947);
                if (k.this.uDd == null) {
                    AppMethodBeat.o(9947);
                } else {
                    final String str3 = str;
                    final String str4 = str2;
                    final Bundle bundle2 = bundle;
                    final boolean z2 = z;
                    k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(9933);
                            k.this.uDd.a(str3, str4, i.aq(bundle2), z2);
                            AppMethodBeat.o(9933);
                        }
                    });
                    dcW().a(str, str2, bundle, z);
                    AppMethodBeat.o(9947);
                }
                return false;
            }

            public final String cYY() {
                return k.this.uJt;
            }

            public final String getCurrentUrl() {
                AppMethodBeat.i(9948);
                String c = k.c(k.this);
                AppMethodBeat.o(9948);
                return c;
            }

            public final String cYZ() {
                AppMethodBeat.i(9949);
                String cYZ = dcW().cYZ();
                AppMethodBeat.o(9949);
                return cYZ;
            }

            public final void nJ(boolean z) {
                AppMethodBeat.i(9950);
                dcW().nJ(z);
                AppMethodBeat.o(9950);
            }

            public final void nK(boolean z) {
                AppMethodBeat.i(9951);
                dcW().nK(z);
                AppMethodBeat.o(9951);
            }

            public final void q(int i, Bundle bundle) {
                AppMethodBeat.i(9952);
                dcW().q(i, bundle);
                AppMethodBeat.o(9952);
            }

            public final void cZb() {
                AppMethodBeat.i(9953);
                if (k.this.uDd != null) {
                    k.this.uDd.cZb();
                }
                AppMethodBeat.o(9953);
            }

            public final void W(Bundle bundle) {
                AppMethodBeat.i(9954);
                dcW().W(bundle);
                AppMethodBeat.o(9954);
            }

            public final void afd(String str) {
                AppMethodBeat.i(9955);
                dcW().afd(str);
                AppMethodBeat.o(9955);
            }

            public final void hd(String str, String str2) {
                AppMethodBeat.i(9956);
                dcW().hd(str, str2);
                AppMethodBeat.o(9956);
            }

            public final void cZc() {
                AppMethodBeat.i(9957);
                if (k.this.uDd != null) {
                    k.this.uDd.cZc();
                }
                AppMethodBeat.o(9957);
            }

            public final void e(String str, String str2, int i, int i2) {
                AppMethodBeat.i(9958);
                dcW().e(str, str2, i, i2);
                AppMethodBeat.o(9958);
            }

            public final Bundle g(int i, Bundle bundle) {
                AppMethodBeat.i(9959);
                Bundle bundle2;
                if (i == 146) {
                    bundle2 = new Bundle();
                    String string = bundle.getString("_url");
                    if (bo.isNullOrNil(string)) {
                        AppMethodBeat.o(9959);
                        return bundle2;
                    }
                    JsapiPermissionWrapper aei = k.this.uFu.aei(string);
                    if (aei == null) {
                        AppMethodBeat.o(9959);
                        return bundle2;
                    }
                    bundle2.putParcelable("_permission_wrapper", aei);
                    AppMethodBeat.o(9959);
                    return bundle2;
                }
                bundle2 = dcW().g(i, bundle);
                AppMethodBeat.o(9959);
                return bundle2;
            }

            public final void X(Bundle bundle) {
                AppMethodBeat.i(9960);
                dcW().X(bundle);
                AppMethodBeat.o(9960);
            }

            public final void nL(boolean z) {
                AppMethodBeat.i(9961);
                dcW().nL(z);
                AppMethodBeat.o(9961);
            }

            public final void he(String str, String str2) {
                AppMethodBeat.i(9962);
                dcW().he(str, str2);
                AppMethodBeat.o(9962);
            }

            public final Bundle dj(String str, String str2) {
                AppMethodBeat.i(9963);
                Bundle dj = dcW().dj(str, str2);
                AppMethodBeat.o(9963);
                return dj;
            }
        };
        this.gNy = (Activity) mMWebView.getContext();
        this.fow = mMWebView;
        this.mHandler = new ak();
        this.uFu = new com.tencent.mm.plugin.webview.ui.tools.k((JsapiPermissionWrapper) this.gNy.getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) this.gNy.getIntent().getParcelableExtra("hardcode_general_ctrl"), new com.tencent.mm.plugin.webview.ui.tools.k.b() {
            public final String aYj() {
                AppMethodBeat.i(9921);
                String url = k.this.fow.getUrl();
                AppMethodBeat.o(9921);
                return url;
            }
        });
        this.uJn = z;
        this.uJm = bundle;
        this.uJs = new an(this.gNy);
        ab.i("MicroMsg.MMWebViewClient", "MMWebViewClient init, webview: %d, resourceInterrupter: %d", Integer.valueOf(this.fow.hashCode()), Integer.valueOf(this.uJs.hashCode()));
        AppMethodBeat.o(9990);
    }

    /* Access modifiers changed, original: protected */
    public void agd(String str) {
    }

    public void a(com.tencent.mm.plugin.webview.stub.d dVar, com.tencent.mm.plugin.webview.ui.tools.k kVar) {
    }

    /* Access modifiers changed, original: protected */
    public m aGt() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public int aGu() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int aGv() {
        return 5;
    }

    /* Access modifiers changed, original: protected */
    public String BZ(String str) {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public String getSource() {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
    }

    /* Access modifiers changed, original: protected */
    public void a(f fVar) {
    }

    /* Access modifiers changed, original: protected */
    public void g(Bundle bundle, String str) {
    }

    /* Access modifiers changed, original: protected */
    public boolean afI(String str) {
        AppMethodBeat.i(9991);
        if (this.fow != null) {
            this.fow.hashCode();
            boolean aeI = p.aeI(str);
            AppMethodBeat.o(9991);
            return aeI;
        }
        AppMethodBeat.o(9991);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean oZ(String str) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void a(WebView webView, String str, Bitmap bitmap) {
    }

    /* Access modifiers changed, original: protected */
    public void e(WebView webView, String str) {
    }

    /* Access modifiers changed, original: protected */
    public void dbT() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean agD(String str) {
        AppMethodBeat.i(9992);
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.uJw) {
            if (bVar.afS(str)) {
                ab.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bVar.afM(str) + ", url = " + str);
                AppMethodBeat.o(9992);
                return true;
            }
        }
        boolean oZ = oZ(str);
        AppMethodBeat.o(9992);
        return oZ;
    }

    public final boolean a(WebView webView, final String str) {
        AppMethodBeat.i(9993);
        ab.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = ".concat(String.valueOf(str)));
        if (this.uzS == null) {
            ab.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            AppMethodBeat.o(9993);
            return true;
        } else if (!ah.aes(str)) {
            ab.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = ".concat(String.valueOf(str)));
            agd(str);
            AppMethodBeat.o(9993);
            return true;
        } else if (str.equals(this.uJv)) {
            this.uJv = "";
            AppMethodBeat.o(9993);
            return true;
        } else if (DownloadChecker.a(str, getSource(), webView)) {
            ab.i("MicroMsg.MMWebViewClient", "use the downloader to download");
            AppMethodBeat.o(9993);
            return true;
        } else {
            boolean agD = agD(str);
            if (!agD && str.startsWith("weixin://")) {
                ab.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                AppMethodBeat.o(9993);
                return true;
            } else if (agD) {
                AppMethodBeat.o(9993);
                return true;
            } else {
                int ael = this.uJr.ael(str);
                if ((ael == 0 || ael == 2) && !this.uJn) {
                    ab.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(ael)));
                    if (afI(str)) {
                        this.fow.stopLoading();
                        this.fow.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9922);
                                k.this.NT(str);
                                AppMethodBeat.o(9922);
                            }
                        });
                    } else {
                        this.fow.stopLoading();
                    }
                    if (str.equals(this.uJo)) {
                        ab.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                        AppMethodBeat.o(9993);
                        return false;
                    }
                    bI(str, true);
                    AppMethodBeat.o(9993);
                    return true;
                }
                AppMethodBeat.o(9993);
                return false;
            }
        }
    }

    public final void a(WebView webView, String str, boolean z) {
        AppMethodBeat.i(9994);
        ab.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
        super.a(webView, str, z);
        String url = webView.getUrl();
        if (this.uJn) {
            bI(url, false);
        }
        if (!(this.uFu == null || this.uFu.has(url))) {
            ab.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", url);
            bI(url, false);
        }
        AppMethodBeat.o(9994);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(9995);
        ab.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", str);
        if (this.uzS == null || this.uJy) {
            this.uJy = false;
            AppMethodBeat.o(9995);
        } else if (!ah.aes(str)) {
            ab.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            agd(str);
            AppMethodBeat.o(9995);
        } else if (agD(str)) {
            this.uJv = str;
            AppMethodBeat.o(9995);
        } else {
            this.uJu = str;
            super.b(webView, str, bitmap);
            this.uDh.dbY();
            if (afI(str)) {
                this.fow.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.uDd != null) {
                    this.uDd.z((String) this.uJx.get(str), (Map) this.uwr.get(str));
                }
            }
            bI(str, false);
            a(webView, str, bitmap);
            AppMethodBeat.o(9995);
        }
    }

    public final void b(WebView webView, String str) {
        AppMethodBeat.i(9996);
        ab.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", str);
        if (this.uzS == null) {
            AppMethodBeat.o(9996);
            return;
        }
        super.b(webView, str);
        if (ah.aes(str)) {
            this.uJv = "";
            if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                ab.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                e(webView, str);
                AppMethodBeat.o(9996);
                return;
            }
            this.uDh.dbZ();
            e(webView, str);
            AppMethodBeat.o(9996);
            return;
        }
        ab.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(str)));
        agd(str);
        AppMethodBeat.o(9996);
    }

    public final void a(WebView webView, j jVar, SslError sslError) {
        AppMethodBeat.i(9997);
        super.a(webView, jVar, sslError);
        AppMethodBeat.o(9997);
    }

    public void a(WebView webView, int i, String str, String str2) {
        AppMethodBeat.i(9998);
        super.a(webView, i, str, str2);
        AppMethodBeat.o(9998);
    }

    public final void h(WebView webView, String str) {
        AppMethodBeat.i(9999);
        ab.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = ".concat(String.valueOf(str)));
        super.h(webView, str);
        AppMethodBeat.o(9999);
    }

    public o c(WebView webView, String str) {
        AppMethodBeat.i(Downloads.MIN_WAIT_FOR_NETWORK);
        ab.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", str);
        o a = this.uJs.a(str, true, this.uzS);
        AppMethodBeat.o(Downloads.MIN_WAIT_FOR_NETWORK);
        return a;
    }

    public o a(WebView webView, n nVar) {
        AppMethodBeat.i(10001);
        o a;
        if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
            a = super.a(webView, nVar);
            AppMethodBeat.o(10001);
            return a;
        }
        ab.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", nVar.getUrl(), nVar.getMethod(), Boolean.valueOf(nVar.isForMainFrame()));
        a = this.uJs.a(nVar.getUrl().toString(), false, this.uzS);
        AppMethodBeat.o(10001);
        return a;
    }

    public o a(WebView webView, n nVar, Bundle bundle) {
        AppMethodBeat.i(10002);
        o a;
        if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
            a = super.a(webView, nVar, bundle);
            AppMethodBeat.o(10002);
            return a;
        }
        ab.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", nVar.getUrl(), nVar.getMethod(), Boolean.valueOf(nVar.isForMainFrame()));
        if (com.tencent.mm.cj.c.iv(this.gNy)) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    ab.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                    k(nVar.getUrl().toString(), false, aGv());
                }
            } catch (Exception e) {
                ab.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", e.getMessage());
            } catch (Throwable th) {
                ab.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", th.getMessage());
            }
        }
        a = this.uJs.a(nVar.getUrl().toString(), true, this.uzS);
        AppMethodBeat.o(10002);
        return a;
    }

    public final void cleanup() {
        AppMethodBeat.i(10003);
        try {
            this.uzS.Jc(this.fow.hashCode());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMWebViewClient", e, "", new Object[0]);
        }
        if (this.uJC != null) {
            try {
                this.gNy.unbindService(this.uJC);
            } catch (Exception e2) {
                ab.e("MicroMsg.MMWebViewClient", e2.getMessage());
            }
        }
        if (this.uDd != null) {
            this.uDd.detach();
        }
        if (this.uDh != null) {
            this.uDh.detach();
        }
        dcV();
        this.uJD = null;
        dbT();
        AppMethodBeat.o(10003);
    }

    /* Access modifiers changed, original: protected */
    public void dbU() {
        AppMethodBeat.i(10005);
        if (TextUtils.isEmpty(this.uJt)) {
            AppMethodBeat.o(10005);
            return;
        }
        try {
            this.uzS.a(this.uJt, true, null);
        } catch (Exception e) {
            ab.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (agD(this.uJt)) {
            AppMethodBeat.o(10005);
            return;
        }
        Uri parse = Uri.parse(this.uJt);
        if (parse.getScheme() == null) {
            this.uJt += "http://";
            parse = Uri.parse(this.uJt);
        }
        if (parse.getScheme().startsWith("http")) {
            ab.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
            this.uJr = new a(this.uJt);
            if (this.uJn || this.uFu.has(this.uJt)) {
                this.fow.loadUrl(this.uJt);
                AppMethodBeat.o(10005);
                return;
            }
            bI(this.uJt, false);
            AppMethodBeat.o(10005);
        } else if (ah.aes(this.uJt)) {
            this.fow.loadUrl(this.uJt);
            AppMethodBeat.o(10005);
        } else {
            agd(this.uJt);
            AppMethodBeat.o(10005);
        }
    }

    private void cZX() {
        AppMethodBeat.i(10006);
        ab.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.gNy.bindService(new Intent(this.gNy, WebViewStubService.class), this.uJC, 1);
        AppMethodBeat.o(10006);
    }

    /* Access modifiers changed, original: protected */
    public boolean agc(String str) {
        AppMethodBeat.i(CdnLogic.kMediaTypeFavoriteBigFile);
        if (this.uzS == null) {
            this.uJt = str;
            cZX();
            AppMethodBeat.o(CdnLogic.kMediaTypeFavoriteBigFile);
            return true;
        }
        AppMethodBeat.o(CdnLogic.kMediaTypeFavoriteBigFile);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void NT(String str) {
        AppMethodBeat.i(10008);
        HashMap hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.fow.loadUrl(str, hashMap);
        AppMethodBeat.o(10008);
    }

    public void bI(String str, boolean z) {
        AppMethodBeat.i(10009);
        k(str, z, aGu());
        AppMethodBeat.o(10009);
    }

    private void k(String str, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(10010);
        if (this.gNy.isFinishing()) {
            AppMethodBeat.o(10010);
        } else if (this.uFu == null) {
            ab.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            AppMethodBeat.o(10010);
        } else if (this.uJn) {
            ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
            this.uFu.a(str, null, null);
            AppMethodBeat.o(10010);
        } else {
            boolean z3;
            if (this.uzS == null) {
                z3 = z2;
            } else {
                z3 = this.uJp.contains(str);
            }
            if ((this.uFu.has(str) || z3) && !z) {
                ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(str)));
                AppMethodBeat.o(10010);
                return;
            }
            String str2 = "";
            int ael = this.uJr.ael(str);
            ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + i + ", username = " + str2 + ", reason = " + ael + ", force = " + z);
            ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
            this.uJp.add(str);
            this.uFu.a(str, null, null);
            this.uJz = true;
            this.uJq.daN();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", str2);
            bundle.putInt("geta8key_data_scene", i);
            bundle.putInt("geta8key_data_reason", ael);
            if (this.fow.getIsX5Kernel()) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", z2);
            }
            bundle.putString("geta8key_data_net_type", u.cXS());
            bundle.putInt("webview_binder_id", this.fow.hashCode());
            bundle.putString("geta8key_outer_url", BZ(str));
            this.uJo = str;
            g(bundle, str);
            try {
                z2 = this.uzS.s(com.tencent.view.d.MIC_PTU_MEISHI, bundle);
            } catch (Exception e) {
                ab.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e.getMessage());
            }
            ab.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = ".concat(String.valueOf(z2)));
            AppMethodBeat.o(10010);
        }
    }

    private void dcV() {
        AppMethodBeat.i(CdnLogic.kMediaTypeBeatificFile);
        try {
            if (this.uzS != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", com.tencent.view.d.MIC_PTU_MEISHI);
                bundle.putInt("scene_end_listener_hash_code", this.fow.hashCode());
                this.uzS.a(6, bundle, this.fow.hashCode());
            }
            AppMethodBeat.o(CdnLogic.kMediaTypeBeatificFile);
        } catch (Exception e) {
            ab.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.o(CdnLogic.kMediaTypeBeatificFile);
        }
    }

    public final void of(boolean z) {
        this.uJy = z;
    }

    private void D(String str, Map<String, String> map) {
        AppMethodBeat.i(10012);
        String bc = bo.bc(dae(), this.uJt);
        if (bo.isNullOrNil(bc)) {
            ab.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.fow.loadUrl(str);
            AppMethodBeat.o(10012);
        } else if (this.uDd == null) {
            if (map.size() > 0) {
                this.fow.loadUrl(str, map);
                AppMethodBeat.o(10012);
                return;
            }
            this.fow.loadUrl(str);
            AppMethodBeat.o(10012);
        } else if (!bo.nullAsNil(str).contains("#wechat_redirect")) {
            if (!hh(bc, str)) {
                Object obj;
                String aeN = q.aeN(bc);
                String aeN2 = q.aeN(str);
                if (bo.isNullOrNil(aeN2) || bo.isNullOrNil(aeN) || !aeN2.equals(aeN) || this.uzS == null || !afI(bc)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    if (map.size() > 0) {
                        this.fow.loadUrl(str, map);
                        AppMethodBeat.o(10012);
                        return;
                    }
                    this.fow.loadUrl(str);
                    AppMethodBeat.o(10012);
                    return;
                }
            }
            this.uJx.put(bc, str);
            this.uwr.put(bc, map);
            this.uDd.z(str, map);
            AppMethodBeat.o(10012);
        } else if (map.size() > 0) {
            this.fow.loadUrl(str, map);
            AppMethodBeat.o(10012);
        } else {
            this.fow.loadUrl(str);
            AppMethodBeat.o(10012);
        }
    }

    private boolean hh(String str, String str2) {
        AppMethodBeat.i(10013);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(10013);
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.uet.matcher(str).matches() && com.tencent.mm.plugin.webview.a.uet.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.uzS != null && afI(str)) {
                AppMethodBeat.o(10013);
                return true;
            }
        }
        AppMethodBeat.o(10013);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean am(Bundle bundle) {
        AppMethodBeat.i(10014);
        ab.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        ab.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        HashMap hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.uJB = hashMap;
        switch (i) {
            case 1:
                ab.i("MicroMsg.MMWebViewClient", "getA8key-text: ".concat(String.valueOf(string3)));
                if (string3 == null || string3.length() == 0) {
                    ab.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    AppMethodBeat.o(10014);
                    return false;
                }
                this.fow.getSettings().setJavaScriptEnabled(false);
                this.fow.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                AppMethodBeat.o(10014);
                return true;
            case 2:
            case 7:
                ab.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    ab.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    AppMethodBeat.o(10014);
                    return false;
                } else if (ah.aes(string2)) {
                    D(string2, hashMap);
                    AppMethodBeat.o(10014);
                    return true;
                } else {
                    ab.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    agd(string2);
                    AppMethodBeat.o(10014);
                    return true;
                }
            case 6:
                ab.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    ab.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    AppMethodBeat.o(10014);
                    return false;
                } else if (ah.aes(string2)) {
                    this.fow.loadUrl(string2);
                    AppMethodBeat.o(10014);
                    return true;
                } else {
                    ab.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    agd(string2);
                    AppMethodBeat.o(10014);
                    return true;
                }
            default:
                ab.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(i)));
                AppMethodBeat.o(10014);
                return false;
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.i(10015);
        if (!bo.isNullOrNil(str2)) {
            this.uFu.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.uJp.remove(str2);
            this.uJz = false;
            this.mTH = str2;
        }
        if (hh(str, str2)) {
            this.uFu.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uJp.remove(str);
            AppMethodBeat.o(10015);
        } else if (this.uzS == null || bo.isNullOrNil(str) || !afI(str2)) {
            AppMethodBeat.o(10015);
        } else {
            this.uFu.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uJp.remove(str);
            AppMethodBeat.o(10015);
        }
    }

    private String dae() {
        AppMethodBeat.i(10016);
        String str;
        if (!bo.isNullOrNil(this.uJu)) {
            str = this.uJu;
            AppMethodBeat.o(10016);
            return str;
        } else if (this.mHandler == null) {
            AppMethodBeat.o(10016);
            return null;
        } else if (Thread.currentThread().getId() != this.mHandler.getLooper().getThread().getId()) {
            str = (String) new bj<String>("") {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(9924);
                    if (k.this.fow == null) {
                        String str = "";
                        AppMethodBeat.o(9924);
                        return str;
                    }
                    Object url = k.this.fow.getUrl();
                    AppMethodBeat.o(9924);
                    return url;
                }
            }.b(this.mHandler);
            AppMethodBeat.o(10016);
            return str;
        } else if (this.fow == null) {
            str = "";
            AppMethodBeat.o(10016);
            return str;
        } else {
            str = this.fow.getUrl();
            AppMethodBeat.o(10016);
            return str;
        }
    }

    public final void dcU() {
        int i;
        AppMethodBeat.i(10004);
        HashMap hashMap = new HashMap();
        hashMap.put("init_url", this.uJt);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        this.uDd = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.fow, this.uFu, hashMap, this.uzS, this.fow.hashCode());
        ab.i("MicroMsg.MMWebViewClient", "initJsApi， webview: %d, jsapi: %d", Integer.valueOf(this.fow.hashCode()), Integer.valueOf(this.uDd.hashCode()));
        this.uDd.uFt = null;
        this.fow.addJavascriptInterface(this.uDd, "__wx");
        this.uJw.add(this.uDd);
        this.uJw.add(new e(this.fow, this.uDd));
        this.uDh = new f(this.fow, this.uzS, this.uDd, new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a() {
            public final void aYk() {
                AppMethodBeat.i(9923);
                k.this.a(k.this.uDd);
                AppMethodBeat.o(9923);
            }
        }, false);
        a(this.uDh);
        try {
            i = bo.getInt(this.uzS.afk("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            ab.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        ab.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", Integer.valueOf(i));
        if (i == 0 && this.gNy.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.uDd.dch();
            this.uJs.aey(this.uDd.uFw);
        }
        AppMethodBeat.o(10004);
    }

    static /* synthetic */ void b(k kVar) {
        AppMethodBeat.i(10018);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", com.tencent.view.d.MIC_PTU_MEISHI);
            bundle.putInt("scene_end_listener_hash_code", kVar.fow.hashCode());
            kVar.uzS.a(5, bundle, kVar.fow.hashCode());
            AppMethodBeat.o(10018);
        } catch (Exception e) {
            ab.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.o(10018);
        }
    }

    static /* synthetic */ boolean a(k kVar, int i, int i2, int i3, Bundle bundle) {
        AppMethodBeat.i(10019);
        if (!kVar.gNy.isFinishing() && kVar.uFu != null) {
            ab.i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", Integer.valueOf(bundle.getInt("scene_end_listener_hash_code")), Integer.valueOf(kVar.fow.hashCode()));
            ab.i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + i + ", errCode = " + i3 + ", errType = " + i2);
            if (bundle.getInt("scene_end_listener_hash_code") == kVar.fow.hashCode()) {
                switch (i) {
                    case com.tencent.view.d.MIC_PTU_MEISHI /*233*/:
                        b bVar = kVar.uJq;
                        bVar.uxN--;
                        if (bVar.uxN <= 0) {
                            k.this.dcV();
                        }
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1"));
                        int i4 = bundle.getInt("geta8key_result_reason");
                        ab.i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(i4)));
                        switch (i4) {
                            case 0:
                            case 2:
                                if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -2005)) {
                                    kVar.a(bundle.getString("geta8key_result_req_url"), bundle.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                    kVar.am(bundle);
                                    break;
                                }
                            case 1:
                            case 5:
                                if (i2 != 0 || i3 != 0) {
                                    if (i2 != 4 || i3 != -2005) {
                                        if (i2 != 0 && i3 == -3300) {
                                            kVar.uJA = true;
                                            break;
                                        }
                                    }
                                    kVar.fow.stopLoading();
                                    kVar.a(bundle.getString("geta8key_result_req_url"), bundle.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                    kVar.am(bundle);
                                    break;
                                }
                                String string = bundle.getString("geta8key_result_req_url");
                                kVar.uFu.a(string, jsapiPermissionWrapper, generalControlWrapper);
                                kVar.uJp.remove(string);
                                break;
                                break;
                        }
                        break;
                }
            }
            ab.e("MicroMsg.MMWebViewClient", "hash code not equal");
        } else {
            ab.w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
        }
        AppMethodBeat.o(10019);
        return true;
    }
}
