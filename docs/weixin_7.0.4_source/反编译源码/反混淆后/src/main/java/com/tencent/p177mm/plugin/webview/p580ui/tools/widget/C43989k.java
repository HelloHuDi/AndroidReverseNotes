package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

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
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.downloader.model.DownloadChecker;
import com.tencent.p177mm.plugin.webview.C14445a;
import com.tencent.p177mm.plugin.webview.model.C22883an;
import com.tencent.p177mm.plugin.webview.model.C43911ah;
import com.tencent.p177mm.plugin.webview.modelcache.C14525q;
import com.tencent.p177mm.plugin.webview.modelcache.C46429p;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k.C40343b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43967b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f.C35691a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44791e;
import com.tencent.p177mm.plugin.webview.stub.C22913c;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.plugin.webview.stub.C46434d.C35624a;
import com.tencent.p177mm.plugin.webview.stub.WebViewStubService;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k */
public class C43989k extends C36592s {
    public MMWebView fow;
    protected Activity gNy;
    C7306ak mHandler;
    protected String mTH;
    public C44786d uDd;
    private C43986f uDh;
    public C40344k uFu;
    private boolean uJA;
    protected Map<String, String> uJB;
    protected C40350c uJC;
    public C46936m uJD;
    final Bundle uJm;
    protected boolean uJn;
    private String uJo;
    private Set<String> uJp;
    protected C43990b uJq;
    protected C14705a uJr;
    private C22883an uJs;
    protected String uJt;
    protected String uJu;
    private String uJv;
    private List<C43967b> uJw;
    private final Map<String, String> uJx;
    protected boolean uJy;
    protected boolean uJz;
    private final Map<String, Map<String, String>> uwr;
    public C46434d uzS;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$5 */
    class C146895 extends C46936m {
        private C46936m uJF = new C46936m();

        C146895() {
            AppMethodBeat.m2504i(9942);
            AppMethodBeat.m2505o(9942);
        }

        private C46936m dcW() {
            AppMethodBeat.m2504i(9943);
            C46936m aGt = C43989k.this.aGt();
            if (aGt == null) {
                aGt = this.uJF;
                AppMethodBeat.m2505o(9943);
                return aGt;
            }
            AppMethodBeat.m2505o(9943);
            return aGt;
        }

        /* renamed from: IZ */
        public final boolean mo26778IZ(int i) {
            AppMethodBeat.m2504i(9944);
            boolean IZ = dcW().mo26778IZ(i);
            AppMethodBeat.m2505o(9944);
            return IZ;
        }

        /* renamed from: c */
        public final boolean mo26784c(int i, final Bundle bundle) {
            AppMethodBeat.m2504i(9945);
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "callback, actionCode = ".concat(String.valueOf(i)));
            final String string;
            final HashMap hashMap;
            final String string2;
            final int i2;
            switch (i) {
                case 90:
                    if (C43989k.this.uDd != null) {
                        C43989k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(9929);
                                if (C43989k.this.uDd != null) {
                                    C43989k.this.uDd.ags(bundle.getString("webview_network_type"));
                                }
                                AppMethodBeat.m2505o(9929);
                            }
                        });
                        break;
                    }
                    break;
                case 1002:
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9925);
                            if (!(C43989k.this.uDd == null || C43989k.this.uFu == null || C43989k.this.uFu.cZS() == null || !C43989k.this.uFu.cZS().mo69833jB(42))) {
                                C43989k.this.uDd.mo71933i(bundle, "download_succ");
                            }
                            AppMethodBeat.m2505o(9925);
                        }
                    });
                    break;
                case 1003:
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9934);
                            if (!(C43989k.this.uDd == null || C43989k.this.uFu == null || C43989k.this.uFu.cZS() == null || !C43989k.this.uFu.cZS().mo69833jB(42))) {
                                C43989k.this.uDd.mo71933i(bundle, "download_fail");
                            }
                            AppMethodBeat.m2505o(9934);
                        }
                    });
                    break;
                case 1006:
                    if (C43989k.this.uDd != null) {
                        C43989k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                boolean z = false;
                                AppMethodBeat.m2504i(9928);
                                byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                if (byteArray == null || C43989k.this.uFu == null || C43989k.this.uFu.cZS() == null) {
                                    String str = "MicroMsg.MMWebViewClient";
                                    String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Boolean.valueOf(byteArray != null);
                                    if (C43989k.this.uFu != null) {
                                        z = true;
                                    }
                                    objArr[1] = Boolean.valueOf(z);
                                    C4990ab.m7413e(str, str2, objArr);
                                } else {
                                    C4990ab.m7417i("MicroMsg.MMWebViewClient", "update control bytes by preverify, %d", Integer.valueOf(byteArray.length));
                                    C43989k.this.uFu.cZS().vxM = byteArray;
                                }
                                if (C43989k.this.uDd != null) {
                                    C43989k.this.uDd.dcj();
                                }
                                AppMethodBeat.m2505o(9928);
                            }
                        });
                        break;
                    }
                    break;
                case 1007:
                    final long j = bundle.getLong("download_manager_downloadid");
                    final int i3 = bundle.getInt("download_manager_progress");
                    string = bundle.getString("download_manager_appid", "");
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9936);
                            if (!(C43989k.this.uDd == null || C43989k.this.uFu == null || C43989k.this.uFu.cZS() == null || !C43989k.this.uFu.cZS().mo69833jB(42))) {
                                C43989k.this.uDd.mo71937n(string, j, i3);
                            }
                            AppMethodBeat.m2505o(9936);
                        }
                    });
                    break;
                case 1008:
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9935);
                            if (!(C43989k.this.uDd == null || C43989k.this.uFu == null || C43989k.this.uFu.cZS() == null || !C43989k.this.uFu.cZS().mo69833jB(42))) {
                                C43989k.this.uDd.mo71933i(bundle, "download_removed");
                            }
                            AppMethodBeat.m2505o(9935);
                        }
                    });
                    break;
                case 2002:
                    hashMap = new HashMap();
                    hashMap.put("err_msg", bundle.getString("playResult"));
                    hashMap.put("localId", bundle.getString("localId"));
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9926);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71896aM(hashMap);
                            }
                            AppMethodBeat.m2505o(9926);
                        }
                    });
                    break;
                case 2003:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9937);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71914dH(string2, i2);
                            }
                            AppMethodBeat.m2505o(9937);
                        }
                    });
                    break;
                case 2004:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9938);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71915dI(string2, i2);
                            }
                            AppMethodBeat.m2505o(9938);
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9939);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71916dJ(string2, i2);
                            }
                            AppMethodBeat.m2505o(9939);
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9940);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71917dK(string2, i2);
                            }
                            AppMethodBeat.m2505o(9940);
                        }
                    });
                    break;
                case 2008:
                    hashMap = new HashMap();
                    hashMap.put("localId", bundle.getString("localId"));
                    hashMap.put("err_msg", bundle.getString("recordResult"));
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9927);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71897aN(hashMap);
                            }
                            AppMethodBeat.m2505o(9927);
                        }
                    });
                    break;
                case 2010:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    C43989k.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(9941);
                            if (C43989k.this.uDd != null) {
                                C43989k.this.uDd.mo71918dL(string2, i2);
                            }
                            AppMethodBeat.m2505o(9941);
                        }
                    });
                    break;
                case CdnLogic.kMediaTypeStoryAudio /*40001*/:
                    if (C43989k.this.uDd != null) {
                        string2 = bundle.getString("err_msg");
                        C43989k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(9930);
                                if (C43989k.this.uDd != null) {
                                    C43989k.this.uDd.agp(string2);
                                }
                                AppMethodBeat.m2505o(9930);
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
                    if (C43989k.this.uDd != null) {
                        final String string3 = bundle.getString("err_msg");
                        C43989k.this.mHandler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(9931);
                                if (C43989k.this.uDd != null) {
                                    C43989k.this.uDd.agp(string3);
                                    C43989k.this.uDd.mo71885a(string, i4, i5, d, d2, f);
                                }
                                AppMethodBeat.m2505o(9931);
                            }
                        });
                        break;
                    }
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                    break;
            }
            dcW().mo26784c(i, bundle);
            AppMethodBeat.m2505o(9945);
            return true;
        }

        /* renamed from: a */
        public final boolean mo26780a(C22913c c22913c) {
            AppMethodBeat.m2504i(9946);
            if (C43989k.this.fow == null) {
                AppMethodBeat.m2505o(9946);
                return true;
            }
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + C43989k.this.fow.hashCode());
            final int type = c22913c.getType();
            final int cYW = c22913c.cYW();
            final int cYX = c22913c.cYX();
            final String adx = c22913c.adx();
            final Bundle data = c22913c.getData();
            C43989k.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(9932);
                    try {
                        C43989k.m78926a(C43989k.this, type, cYW, cYX, data != null ? data : new Bundle());
                        AppMethodBeat.m2505o(9932);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.MMWebViewClient", e.getMessage());
                        AppMethodBeat.m2505o(9932);
                    }
                }
            });
            boolean a = dcW().mo26780a(c22913c);
            AppMethodBeat.m2505o(9946);
            return a;
        }

        /* renamed from: a */
        public final boolean mo26781a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.m2504i(9947);
            if (C43989k.this.uDd == null) {
                AppMethodBeat.m2505o(9947);
            } else {
                final String str3 = str;
                final String str4 = str2;
                final Bundle bundle2 = bundle;
                final boolean z2 = z;
                C43989k.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(9933);
                        C43989k.this.uDd.mo71886a(str3, str4, C29945i.m47403aq(bundle2), z2);
                        AppMethodBeat.m2505o(9933);
                    }
                });
                dcW().mo26781a(str, str2, bundle, z);
                AppMethodBeat.m2505o(9947);
            }
            return false;
        }

        public final String cYY() {
            return C43989k.this.uJt;
        }

        public final String getCurrentUrl() {
            AppMethodBeat.m2504i(9948);
            String c = C43989k.m78928c(C43989k.this);
            AppMethodBeat.m2505o(9948);
            return c;
        }

        public final String cYZ() {
            AppMethodBeat.m2504i(9949);
            String cYZ = dcW().cYZ();
            AppMethodBeat.m2505o(9949);
            return cYZ;
        }

        /* renamed from: nJ */
        public final void mo26794nJ(boolean z) {
            AppMethodBeat.m2504i(9950);
            dcW().mo26794nJ(z);
            AppMethodBeat.m2505o(9950);
        }

        /* renamed from: nK */
        public final void mo26795nK(boolean z) {
            AppMethodBeat.m2504i(9951);
            dcW().mo26795nK(z);
            AppMethodBeat.m2505o(9951);
        }

        /* renamed from: q */
        public final void mo26797q(int i, Bundle bundle) {
            AppMethodBeat.m2504i(9952);
            dcW().mo26797q(i, bundle);
            AppMethodBeat.m2505o(9952);
        }

        public final void cZb() {
            AppMethodBeat.m2504i(9953);
            if (C43989k.this.uDd != null) {
                C43989k.this.uDd.cZb();
            }
            AppMethodBeat.m2505o(9953);
        }

        /* renamed from: W */
        public final void mo9706W(Bundle bundle) {
            AppMethodBeat.m2504i(9954);
            dcW().mo9706W(bundle);
            AppMethodBeat.m2505o(9954);
        }

        public final void afd(String str) {
            AppMethodBeat.m2504i(9955);
            dcW().afd(str);
            AppMethodBeat.m2505o(9955);
        }

        /* renamed from: hd */
        public final void mo26792hd(String str, String str2) {
            AppMethodBeat.m2504i(9956);
            dcW().mo26792hd(str, str2);
            AppMethodBeat.m2505o(9956);
        }

        public final void cZc() {
            AppMethodBeat.m2504i(9957);
            if (C43989k.this.uDd != null) {
                C43989k.this.uDd.cZc();
            }
            AppMethodBeat.m2505o(9957);
        }

        /* renamed from: e */
        public final void mo6225e(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(9958);
            dcW().mo6225e(str, str2, i, i2);
            AppMethodBeat.m2505o(9958);
        }

        /* renamed from: g */
        public final Bundle mo6226g(int i, Bundle bundle) {
            AppMethodBeat.m2504i(9959);
            Bundle bundle2;
            if (i == 146) {
                bundle2 = new Bundle();
                String string = bundle.getString("_url");
                if (C5046bo.isNullOrNil(string)) {
                    AppMethodBeat.m2505o(9959);
                    return bundle2;
                }
                JsapiPermissionWrapper aei = C43989k.this.uFu.aei(string);
                if (aei == null) {
                    AppMethodBeat.m2505o(9959);
                    return bundle2;
                }
                bundle2.putParcelable("_permission_wrapper", aei);
                AppMethodBeat.m2505o(9959);
                return bundle2;
            }
            bundle2 = dcW().mo6226g(i, bundle);
            AppMethodBeat.m2505o(9959);
            return bundle2;
        }

        /* renamed from: X */
        public final void mo26779X(Bundle bundle) {
            AppMethodBeat.m2504i(9960);
            dcW().mo26779X(bundle);
            AppMethodBeat.m2505o(9960);
        }

        /* renamed from: nL */
        public final void mo26796nL(boolean z) {
            AppMethodBeat.m2504i(9961);
            dcW().mo26796nL(z);
            AppMethodBeat.m2505o(9961);
        }

        /* renamed from: he */
        public final void mo26793he(String str, String str2) {
            AppMethodBeat.m2504i(9962);
            dcW().mo26793he(str, str2);
            AppMethodBeat.m2505o(9962);
        }

        /* renamed from: dj */
        public final Bundle mo26790dj(String str, String str2) {
            AppMethodBeat.m2504i(9963);
            Bundle dj = dcW().mo26790dj(str, str2);
            AppMethodBeat.m2505o(9963);
            return dj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$a */
    public static class C14705a {
        private static final Pattern hnu = Pattern.compile(".*#.*wechat_redirect");
        private String jVi = null;

        static {
            AppMethodBeat.m2504i(9965);
            AppMethodBeat.m2505o(9965);
        }

        public C14705a(String str) {
            this.jVi = str;
        }

        public final int ael(String str) {
            AppMethodBeat.m2504i(9964);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
                AppMethodBeat.m2505o(9964);
                return 0;
            } else if (str.equals(this.jVi)) {
                AppMethodBeat.m2505o(9964);
                return 0;
            } else if (hnu.matcher(str).find()) {
                AppMethodBeat.m2505o(9964);
                return 2;
            } else {
                AppMethodBeat.m2505o(9964);
                return 1;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$3 */
    class C231583 implements C35691a {
        C231583() {
        }

        public final void aYk() {
            AppMethodBeat.m2504i(9923);
            C43989k.this.mo38562a(C43989k.this.uDd);
            AppMethodBeat.m2505o(9923);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$c */
    public class C40350c implements ServiceConnection {
        protected C40350c() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(9967);
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "onServiceConnected");
            if (C43989k.this.fow == null) {
                C4990ab.m7412e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
                AppMethodBeat.m2505o(9967);
                return;
            }
            try {
                C43989k.this.uzS = C35624a.m58467G(iBinder);
                C43989k.this.uzS.mo15528a(new C43991d(new WeakReference(C43989k.this.uJD)), C43989k.this.fow.hashCode());
                if (C43989k.this.uJm != null) {
                    C43989k.this.uzS.mo15527a(C43989k.this.uJm, C43989k.this.fow.hashCode());
                }
                C43989k.this.dcU();
                C43989k.this.dbU();
                C43989k.this.mo38561a(C43989k.this.uzS, C43989k.this.uFu);
                AppMethodBeat.m2505o(9967);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", e.getMessage());
                AppMethodBeat.m2505o(9967);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(9968);
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
            if (C43989k.this.gNy.isFinishing()) {
                C43989k.this.uzS = null;
                AppMethodBeat.m2505o(9968);
                return;
            }
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
            C43989k.m78924a(C43989k.this);
            AppMethodBeat.m2505o(9968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$1 */
    class C413331 implements C40343b {
        C413331() {
        }

        public final String aYj() {
            AppMethodBeat.m2504i(9921);
            String url = C43989k.this.fow.getUrl();
            AppMethodBeat.m2505o(9921);
            return url;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$b */
    protected class C43990b {
        int uxN = 0;

        protected C43990b() {
        }

        public final void daN() {
            AppMethodBeat.m2504i(9966);
            if (this.uxN == 0) {
                C43989k.m78927b(C43989k.this);
            }
            this.uxN++;
            AppMethodBeat.m2505o(9966);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.k$d */
    protected static class C43991d extends C46936m {
        private WeakReference<C46936m> iuM;

        public C43991d(WeakReference<C46936m> weakReference) {
            this.iuM = weakReference;
        }

        /* renamed from: IZ */
        public final boolean mo26778IZ(int i) {
            AppMethodBeat.m2504i(9969);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                boolean IZ = c46936m.mo26778IZ(i);
                AppMethodBeat.m2505o(9969);
                return IZ;
            }
            AppMethodBeat.m2505o(9969);
            return false;
        }

        /* renamed from: c */
        public final boolean mo26784c(int i, Bundle bundle) {
            AppMethodBeat.m2504i(9970);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                boolean c = c46936m.mo26784c(i, bundle);
                AppMethodBeat.m2505o(9970);
                return c;
            }
            AppMethodBeat.m2505o(9970);
            return false;
        }

        /* renamed from: a */
        public final boolean mo26780a(C22913c c22913c) {
            AppMethodBeat.m2504i(9971);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                boolean a = c46936m.mo26780a(c22913c);
                AppMethodBeat.m2505o(9971);
                return a;
            }
            AppMethodBeat.m2505o(9971);
            return false;
        }

        /* renamed from: a */
        public final boolean mo26781a(String str, String str2, Bundle bundle, boolean z) {
            AppMethodBeat.m2504i(9972);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                boolean a = c46936m.mo26781a(str, str2, bundle, z);
                AppMethodBeat.m2505o(9972);
                return a;
            }
            AppMethodBeat.m2505o(9972);
            return false;
        }

        public final String cYY() {
            AppMethodBeat.m2504i(9973);
            C46936m c46936m = (C46936m) this.iuM.get();
            String cYY;
            if (c46936m != null) {
                cYY = c46936m.cYY();
                AppMethodBeat.m2505o(9973);
                return cYY;
            }
            cYY = "";
            AppMethodBeat.m2505o(9973);
            return cYY;
        }

        public final String getCurrentUrl() {
            AppMethodBeat.m2504i(9974);
            C46936m c46936m = (C46936m) this.iuM.get();
            String currentUrl;
            if (c46936m != null) {
                currentUrl = c46936m.getCurrentUrl();
                AppMethodBeat.m2505o(9974);
                return currentUrl;
            }
            currentUrl = "";
            AppMethodBeat.m2505o(9974);
            return currentUrl;
        }

        public final String cYZ() {
            AppMethodBeat.m2504i(9975);
            C46936m c46936m = (C46936m) this.iuM.get();
            String cYZ;
            if (c46936m != null) {
                cYZ = c46936m.cYZ();
                AppMethodBeat.m2505o(9975);
                return cYZ;
            }
            cYZ = "";
            AppMethodBeat.m2505o(9975);
            return cYZ;
        }

        /* renamed from: nJ */
        public final void mo26794nJ(boolean z) {
            AppMethodBeat.m2504i(9976);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26794nJ(z);
            }
            AppMethodBeat.m2505o(9976);
        }

        /* renamed from: nK */
        public final void mo26795nK(boolean z) {
            AppMethodBeat.m2504i(9977);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26795nK(z);
            }
            AppMethodBeat.m2505o(9977);
        }

        /* renamed from: q */
        public final void mo26797q(int i, Bundle bundle) {
            AppMethodBeat.m2504i(9978);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26797q(i, bundle);
            }
            AppMethodBeat.m2505o(9978);
        }

        public final void cZb() {
            AppMethodBeat.m2504i(9979);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.cZb();
            }
            AppMethodBeat.m2505o(9979);
        }

        /* renamed from: W */
        public final void mo9706W(Bundle bundle) {
            AppMethodBeat.m2504i(9980);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo9706W(bundle);
            }
            AppMethodBeat.m2505o(9980);
        }

        public final void afd(String str) {
            AppMethodBeat.m2504i(9981);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.afd(str);
            }
            AppMethodBeat.m2505o(9981);
        }

        /* renamed from: hd */
        public final void mo26792hd(String str, String str2) {
            AppMethodBeat.m2504i(9982);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26792hd(str, str2);
            }
            AppMethodBeat.m2505o(9982);
        }

        public final void cZc() {
            AppMethodBeat.m2504i(9983);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.cZc();
            }
            AppMethodBeat.m2505o(9983);
        }

        /* renamed from: e */
        public final void mo6225e(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(9984);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo6225e(str, str2, i, i2);
            }
            AppMethodBeat.m2505o(9984);
        }

        /* renamed from: g */
        public final Bundle mo6226g(int i, Bundle bundle) {
            AppMethodBeat.m2504i(9985);
            C46936m c46936m = (C46936m) this.iuM.get();
            Bundle g;
            if (c46936m != null) {
                g = c46936m.mo6226g(i, bundle);
                AppMethodBeat.m2505o(9985);
                return g;
            }
            g = new Bundle();
            AppMethodBeat.m2505o(9985);
            return g;
        }

        /* renamed from: X */
        public final void mo26779X(Bundle bundle) {
            AppMethodBeat.m2504i(9986);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26779X(bundle);
            }
            AppMethodBeat.m2505o(9986);
        }

        /* renamed from: nL */
        public final void mo26796nL(boolean z) {
            AppMethodBeat.m2504i(9987);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26796nL(z);
            }
            AppMethodBeat.m2505o(9987);
        }

        /* renamed from: he */
        public final void mo26793he(String str, String str2) {
            AppMethodBeat.m2504i(9988);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                c46936m.mo26793he(str, str2);
            }
            AppMethodBeat.m2505o(9988);
        }

        /* renamed from: dj */
        public final Bundle mo26790dj(String str, String str2) {
            AppMethodBeat.m2504i(9989);
            C46936m c46936m = (C46936m) this.iuM.get();
            if (c46936m != null) {
                Bundle dj = c46936m.mo26790dj(str, str2);
                AppMethodBeat.m2505o(9989);
                return dj;
            }
            AppMethodBeat.m2505o(9989);
            return null;
        }
    }

    /* renamed from: c */
    static /* synthetic */ String m78928c(C43989k c43989k) {
        AppMethodBeat.m2504i(10020);
        String dae = c43989k.dae();
        AppMethodBeat.m2505o(10020);
        return dae;
    }

    public C43989k(MMWebView mMWebView) {
        this(mMWebView, (byte) 0);
    }

    public C43989k(MMWebView mMWebView, byte b) {
        this(mMWebView, false, null);
    }

    public C43989k(MMWebView mMWebView, boolean z, Bundle bundle) {
        AppMethodBeat.m2504i(9990);
        this.uDh = null;
        this.uDd = null;
        this.uJn = false;
        this.uJo = "";
        this.uJp = new HashSet();
        this.uJq = new C43990b();
        this.uJr = new C14705a(null);
        this.uJt = null;
        this.uJu = null;
        this.uJv = null;
        this.uJw = new ArrayList();
        this.uJx = new HashMap();
        this.uwr = new ConcurrentHashMap();
        this.uJy = false;
        this.uJz = false;
        this.uJA = false;
        this.uJC = new C40350c();
        this.uJD = new C146895();
        this.gNy = (Activity) mMWebView.getContext();
        this.fow = mMWebView;
        this.mHandler = new C7306ak();
        this.uFu = new C40344k((JsapiPermissionWrapper) this.gNy.getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) this.gNy.getIntent().getParcelableExtra("hardcode_general_ctrl"), new C413331());
        this.uJn = z;
        this.uJm = bundle;
        this.uJs = new C22883an(this.gNy);
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "MMWebViewClient init, webview: %d, resourceInterrupter: %d", Integer.valueOf(this.fow.hashCode()), Integer.valueOf(this.uJs.hashCode()));
        AppMethodBeat.m2505o(9990);
    }

    /* Access modifiers changed, original: protected */
    public void agd(String str) {
    }

    /* renamed from: a */
    public void mo38561a(C46434d c46434d, C40344k c40344k) {
    }

    /* Access modifiers changed, original: protected */
    public C46936m aGt() {
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
    /* renamed from: BZ */
    public String mo44749BZ(String str) {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public String getSource() {
        return "";
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo38562a(C44786d c44786d) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo38563a(C43986f c43986f) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo44752g(Bundle bundle, String str) {
    }

    /* Access modifiers changed, original: protected */
    public boolean afI(String str) {
        AppMethodBeat.m2504i(9991);
        if (this.fow != null) {
            this.fow.hashCode();
            boolean aeI = C46429p.aeI(str);
            AppMethodBeat.m2505o(9991);
            return aeI;
        }
        AppMethodBeat.m2505o(9991);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: oZ */
    public boolean mo44753oZ(String str) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo38564a(WebView webView, String str, Bitmap bitmap) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public void mo38573e(WebView webView, String str) {
    }

    /* Access modifiers changed, original: protected */
    public void dbT() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean agD(String str) {
        AppMethodBeat.m2504i(9992);
        for (C43967b c43967b : this.uJw) {
            if (c43967b.afS(str)) {
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "url handled, ret = " + c43967b.afM(str) + ", url = " + str);
                AppMethodBeat.m2505o(9992);
                return true;
            }
        }
        boolean oZ = mo44753oZ(str);
        AppMethodBeat.m2505o(9992);
        return oZ;
    }

    /* renamed from: a */
    public final boolean mo4762a(WebView webView, final String str) {
        AppMethodBeat.m2504i(9993);
        C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = ".concat(String.valueOf(str)));
        if (this.uzS == null) {
            C4990ab.m7412e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            AppMethodBeat.m2505o(9993);
            return true;
        } else if (!C43911ah.aes(str)) {
            C4990ab.m7414f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = ".concat(String.valueOf(str)));
            agd(str);
            AppMethodBeat.m2505o(9993);
            return true;
        } else if (str.equals(this.uJv)) {
            this.uJv = "";
            AppMethodBeat.m2505o(9993);
            return true;
        } else if (DownloadChecker.m31425a(str, getSource(), webView)) {
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "use the downloader to download");
            AppMethodBeat.m2505o(9993);
            return true;
        } else {
            boolean agD = agD(str);
            if (!agD && str.startsWith("weixin://")) {
                C4990ab.m7413e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                AppMethodBeat.m2505o(9993);
                return true;
            } else if (agD) {
                AppMethodBeat.m2505o(9993);
                return true;
            } else {
                int ael = this.uJr.ael(str);
                if ((ael == 0 || ael == 2) && !this.uJn) {
                    C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(ael)));
                    if (afI(str)) {
                        this.fow.stopLoading();
                        this.fow.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(9922);
                                C43989k.this.mo38560NT(str);
                                AppMethodBeat.m2505o(9922);
                            }
                        });
                    } else {
                        this.fow.stopLoading();
                    }
                    if (str.equals(this.uJo)) {
                        C4990ab.m7420w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                        AppMethodBeat.m2505o(9993);
                        return false;
                    }
                    mo38570bI(str, true);
                    AppMethodBeat.m2505o(9993);
                    return true;
                }
                AppMethodBeat.m2505o(9993);
                return false;
            }
        }
    }

    /* renamed from: a */
    public final void mo26819a(WebView webView, String str, boolean z) {
        AppMethodBeat.m2504i(9994);
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
        super.mo26819a(webView, str, z);
        String url = webView.getUrl();
        if (this.uJn) {
            mo38570bI(url, false);
        }
        if (!(this.uFu == null || this.uFu.has(url))) {
            C4990ab.m7417i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", url);
            mo38570bI(url, false);
        }
        AppMethodBeat.m2505o(9994);
    }

    /* renamed from: b */
    public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(9995);
        C4990ab.m7411d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", str);
        if (this.uzS == null || this.uJy) {
            this.uJy = false;
            AppMethodBeat.m2505o(9995);
        } else if (!C43911ah.aes(str)) {
            C4990ab.m7414f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            agd(str);
            AppMethodBeat.m2505o(9995);
        } else if (agD(str)) {
            this.uJv = str;
            AppMethodBeat.m2505o(9995);
        } else {
            this.uJu = str;
            super.mo7562b(webView, str, bitmap);
            this.uDh.dbY();
            if (afI(str)) {
                this.fow.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.uDd != null) {
                    this.uDd.mo71943z((String) this.uJx.get(str), (Map) this.uwr.get(str));
                }
            }
            mo38570bI(str, false);
            mo38564a(webView, str, bitmap);
            AppMethodBeat.m2505o(9995);
        }
    }

    /* renamed from: b */
    public final void mo5992b(WebView webView, String str) {
        AppMethodBeat.m2504i(9996);
        C4990ab.m7411d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", str);
        if (this.uzS == null) {
            AppMethodBeat.m2505o(9996);
            return;
        }
        super.mo5992b(webView, str);
        if (C43911ah.aes(str)) {
            this.uJv = "";
            if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                mo38573e(webView, str);
                AppMethodBeat.m2505o(9996);
                return;
            }
            this.uDh.dbZ();
            mo38573e(webView, str);
            AppMethodBeat.m2505o(9996);
            return;
        }
        C4990ab.m7414f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(str)));
        agd(str);
        AppMethodBeat.m2505o(9996);
    }

    /* renamed from: a */
    public final void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
        AppMethodBeat.m2504i(9997);
        super.mo7560a(webView, c36588j, sslError);
        AppMethodBeat.m2505o(9997);
    }

    /* renamed from: a */
    public void mo7559a(WebView webView, int i, String str, String str2) {
        AppMethodBeat.m2504i(9998);
        super.mo7559a(webView, i, str, str2);
        AppMethodBeat.m2505o(9998);
    }

    /* renamed from: h */
    public final void mo7563h(WebView webView, String str) {
        AppMethodBeat.m2504i(9999);
        C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = ".concat(String.valueOf(str)));
        super.mo7563h(webView, str);
        AppMethodBeat.m2505o(9999);
    }

    /* renamed from: c */
    public C31147o mo5993c(WebView webView, String str) {
        AppMethodBeat.m2504i(Downloads.MIN_WAIT_FOR_NETWORK);
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", str);
        C31147o a = this.uJs.mo38480a(str, true, this.uzS);
        AppMethodBeat.m2505o(Downloads.MIN_WAIT_FOR_NETWORK);
        return a;
    }

    /* renamed from: a */
    public C31147o mo5990a(WebView webView, C24530n c24530n) {
        AppMethodBeat.m2504i(10001);
        C31147o a;
        if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
            a = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(10001);
            return a;
        }
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", c24530n.getUrl(), c24530n.getMethod(), Boolean.valueOf(c24530n.isForMainFrame()));
        a = this.uJs.mo38480a(c24530n.getUrl().toString(), false, this.uzS);
        AppMethodBeat.m2505o(10001);
        return a;
    }

    /* renamed from: a */
    public C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
        AppMethodBeat.m2504i(10002);
        C31147o a;
        if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
            a = super.mo5991a(webView, c24530n, bundle);
            AppMethodBeat.m2505o(10002);
            return a;
        }
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", c24530n.getUrl(), c24530n.getMethod(), Boolean.valueOf(c24530n.isForMainFrame()));
        if (C45287c.m83505iv(this.gNy)) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    C4990ab.m7417i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                    m78930k(c24530n.getUrl().toString(), false, aGv());
                }
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", e.getMessage());
            } catch (Throwable th) {
                C4990ab.m7421w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", th.getMessage());
            }
        }
        a = this.uJs.mo38480a(c24530n.getUrl().toString(), true, this.uzS);
        AppMethodBeat.m2505o(10002);
        return a;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(10003);
        try {
            this.uzS.mo15519Jc(this.fow.hashCode());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMWebViewClient", e, "", new Object[0]);
        }
        if (this.uJC != null) {
            try {
                this.gNy.unbindService(this.uJC);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.MMWebViewClient", e2.getMessage());
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
        AppMethodBeat.m2505o(10003);
    }

    /* Access modifiers changed, original: protected */
    public void dbU() {
        AppMethodBeat.m2504i(10005);
        if (TextUtils.isEmpty(this.uJt)) {
            AppMethodBeat.m2505o(10005);
            return;
        }
        try {
            this.uzS.mo15533a(this.uJt, true, null);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (agD(this.uJt)) {
            AppMethodBeat.m2505o(10005);
            return;
        }
        Uri parse = Uri.parse(this.uJt);
        if (parse.getScheme() == null) {
            this.uJt += "http://";
            parse = Uri.parse(this.uJt);
        }
        if (parse.getScheme().startsWith("http")) {
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
            this.uJr = new C14705a(this.uJt);
            if (this.uJn || this.uFu.has(this.uJt)) {
                this.fow.loadUrl(this.uJt);
                AppMethodBeat.m2505o(10005);
                return;
            }
            mo38570bI(this.uJt, false);
            AppMethodBeat.m2505o(10005);
        } else if (C43911ah.aes(this.uJt)) {
            this.fow.loadUrl(this.uJt);
            AppMethodBeat.m2505o(10005);
        } else {
            agd(this.uJt);
            AppMethodBeat.m2505o(10005);
        }
    }

    private void cZX() {
        AppMethodBeat.m2504i(10006);
        C4990ab.m7416i("MicroMsg.MMWebViewClient", "tryBindService");
        this.gNy.bindService(new Intent(this.gNy, WebViewStubService.class), this.uJC, 1);
        AppMethodBeat.m2505o(10006);
    }

    /* Access modifiers changed, original: protected */
    public boolean agc(String str) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeFavoriteBigFile);
        if (this.uzS == null) {
            this.uJt = str;
            cZX();
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeFavoriteBigFile);
            return true;
        }
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeFavoriteBigFile);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NT */
    public void mo38560NT(String str) {
        AppMethodBeat.m2504i(10008);
        HashMap hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.fow.loadUrl(str, hashMap);
        AppMethodBeat.m2505o(10008);
    }

    /* renamed from: bI */
    public void mo38570bI(String str, boolean z) {
        AppMethodBeat.m2504i(10009);
        m78930k(str, z, aGu());
        AppMethodBeat.m2505o(10009);
    }

    /* renamed from: k */
    private void m78930k(String str, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(10010);
        if (this.gNy.isFinishing()) {
            AppMethodBeat.m2505o(10010);
        } else if (this.uFu == null) {
            C4990ab.m7412e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            AppMethodBeat.m2505o(10010);
        } else if (this.uJn) {
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
            this.uFu.mo63705a(str, null, null);
            AppMethodBeat.m2505o(10010);
        } else {
            boolean z3;
            if (this.uzS == null) {
                z3 = z2;
            } else {
                z3 = this.uJp.contains(str);
            }
            if ((this.uFu.has(str) || z3) && !z) {
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(10010);
                return;
            }
            String str2 = "";
            int ael = this.uJr.ael(str);
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + i + ", username = " + str2 + ", reason = " + ael + ", force = " + z);
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
            this.uJp.add(str);
            this.uFu.mo63705a(str, null, null);
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
            bundle.putString("geta8key_data_net_type", C30152u.cXS());
            bundle.putInt("webview_binder_id", this.fow.hashCode());
            bundle.putString("geta8key_outer_url", mo44749BZ(str));
            this.uJo = str;
            mo44752g(bundle, str);
            try {
                z2 = this.uzS.mo15590s(C31128d.MIC_PTU_MEISHI, bundle);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e.getMessage());
            }
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = ".concat(String.valueOf(z2)));
            AppMethodBeat.m2505o(10010);
        }
    }

    private void dcV() {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeBeatificFile);
        try {
            if (this.uzS != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", C31128d.MIC_PTU_MEISHI);
                bundle.putInt("scene_end_listener_hash_code", this.fow.hashCode());
                this.uzS.mo15526a(6, bundle, this.fow.hashCode());
            }
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeBeatificFile);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeBeatificFile);
        }
    }

    /* renamed from: of */
    public final void mo69681of(boolean z) {
        this.uJy = z;
    }

    /* renamed from: D */
    private void m78923D(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(10012);
        String bc = C5046bo.m7532bc(dae(), this.uJt);
        if (C5046bo.isNullOrNil(bc)) {
            C4990ab.m7412e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.fow.loadUrl(str);
            AppMethodBeat.m2505o(10012);
        } else if (this.uDd == null) {
            if (map.size() > 0) {
                this.fow.loadUrl(str, map);
                AppMethodBeat.m2505o(10012);
                return;
            }
            this.fow.loadUrl(str);
            AppMethodBeat.m2505o(10012);
        } else if (!C5046bo.nullAsNil(str).contains("#wechat_redirect")) {
            if (!m78929hh(bc, str)) {
                Object obj;
                String aeN = C14525q.aeN(bc);
                String aeN2 = C14525q.aeN(str);
                if (C5046bo.isNullOrNil(aeN2) || C5046bo.isNullOrNil(aeN) || !aeN2.equals(aeN) || this.uzS == null || !afI(bc)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    if (map.size() > 0) {
                        this.fow.loadUrl(str, map);
                        AppMethodBeat.m2505o(10012);
                        return;
                    }
                    this.fow.loadUrl(str);
                    AppMethodBeat.m2505o(10012);
                    return;
                }
            }
            this.uJx.put(bc, str);
            this.uwr.put(bc, map);
            this.uDd.mo71943z(str, map);
            AppMethodBeat.m2505o(10012);
        } else if (map.size() > 0) {
            this.fow.loadUrl(str, map);
            AppMethodBeat.m2505o(10012);
        } else {
            this.fow.loadUrl(str);
            AppMethodBeat.m2505o(10012);
        }
    }

    /* renamed from: hh */
    private boolean m78929hh(String str, String str2) {
        AppMethodBeat.m2504i(10013);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(10013);
            return false;
        }
        if (C14445a.uet.matcher(str).matches() && C14445a.uet.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.uzS != null && afI(str)) {
                AppMethodBeat.m2505o(10013);
                return true;
            }
        }
        AppMethodBeat.m2505o(10013);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: am */
    public boolean mo38569am(Bundle bundle) {
        AppMethodBeat.m2504i(10014);
        C4990ab.m7411d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        C4990ab.m7416i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
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
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "getA8key-text: ".concat(String.valueOf(string3)));
                if (string3 == null || string3.length() == 0) {
                    C4990ab.m7412e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    AppMethodBeat.m2505o(10014);
                    return false;
                }
                this.fow.getSettings().setJavaScriptEnabled(false);
                this.fow.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                AppMethodBeat.m2505o(10014);
                return true;
            case 2:
            case 7:
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    AppMethodBeat.m2505o(10014);
                    return false;
                } else if (C43911ah.aes(string2)) {
                    m78923D(string2, hashMap);
                    AppMethodBeat.m2505o(10014);
                    return true;
                } else {
                    C4990ab.m7414f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    agd(string2);
                    AppMethodBeat.m2505o(10014);
                    return true;
                }
            case 6:
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    AppMethodBeat.m2505o(10014);
                    return false;
                } else if (C43911ah.aes(string2)) {
                    this.fow.loadUrl(string2);
                    AppMethodBeat.m2505o(10014);
                    return true;
                } else {
                    C4990ab.m7414f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    agd(string2);
                    AppMethodBeat.m2505o(10014);
                    return true;
                }
            default:
                C4990ab.m7416i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(10014);
                return false;
        }
    }

    /* renamed from: a */
    private void m78925a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.m2504i(10015);
        if (!C5046bo.isNullOrNil(str2)) {
            this.uFu.mo63705a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.uJp.remove(str2);
            this.uJz = false;
            this.mTH = str2;
        }
        if (m78929hh(str, str2)) {
            this.uFu.mo63705a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uJp.remove(str);
            AppMethodBeat.m2505o(10015);
        } else if (this.uzS == null || C5046bo.isNullOrNil(str) || !afI(str2)) {
            AppMethodBeat.m2505o(10015);
        } else {
            this.uFu.mo63705a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uJp.remove(str);
            AppMethodBeat.m2505o(10015);
        }
    }

    private String dae() {
        AppMethodBeat.m2504i(10016);
        String str;
        if (!C5046bo.isNullOrNil(this.uJu)) {
            str = this.uJu;
            AppMethodBeat.m2505o(10016);
            return str;
        } else if (this.mHandler == null) {
            AppMethodBeat.m2505o(10016);
            return null;
        } else if (Thread.currentThread().getId() != this.mHandler.getLooper().getThread().getId()) {
            str = (String) new C5039bj<String>("") {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(9924);
                    if (C43989k.this.fow == null) {
                        String str = "";
                        AppMethodBeat.m2505o(9924);
                        return str;
                    }
                    Object url = C43989k.this.fow.getUrl();
                    AppMethodBeat.m2505o(9924);
                    return url;
                }
            }.mo10372b(this.mHandler);
            AppMethodBeat.m2505o(10016);
            return str;
        } else if (this.fow == null) {
            str = "";
            AppMethodBeat.m2505o(10016);
            return str;
        } else {
            str = this.fow.getUrl();
            AppMethodBeat.m2505o(10016);
            return str;
        }
    }

    public final void dcU() {
        int i;
        AppMethodBeat.m2504i(10004);
        HashMap hashMap = new HashMap();
        hashMap.put("init_url", this.uJt);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        this.uDd = new C44786d(this.fow, this.uFu, hashMap, this.uzS, this.fow.hashCode());
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "initJsApi， webview: %d, jsapi: %d", Integer.valueOf(this.fow.hashCode()), Integer.valueOf(this.uDd.hashCode()));
        this.uDd.uFt = null;
        this.fow.addJavascriptInterface(this.uDd, "__wx");
        this.uJw.add(this.uDd);
        this.uJw.add(new C44791e(this.fow, this.uDd));
        this.uDh = new C43986f(this.fow, this.uzS, this.uDd, new C231583(), false);
        mo38563a(this.uDh);
        try {
            i = C5046bo.getInt(this.uzS.afk("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.MMWebViewClient", "js digest verification config = %d", Integer.valueOf(i));
        if (i == 0 && this.gNy.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.uDd.dch();
            this.uJs.aey(this.uDd.uFw);
        }
        AppMethodBeat.m2505o(10004);
    }

    /* renamed from: b */
    static /* synthetic */ void m78927b(C43989k c43989k) {
        AppMethodBeat.m2504i(10018);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", C31128d.MIC_PTU_MEISHI);
            bundle.putInt("scene_end_listener_hash_code", c43989k.fow.hashCode());
            c43989k.uzS.mo15526a(5, bundle, c43989k.fow.hashCode());
            AppMethodBeat.m2505o(10018);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.m2505o(10018);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m78926a(C43989k c43989k, int i, int i2, int i3, Bundle bundle) {
        AppMethodBeat.m2504i(10019);
        if (!c43989k.gNy.isFinishing() && c43989k.uFu != null) {
            C4990ab.m7417i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", Integer.valueOf(bundle.getInt("scene_end_listener_hash_code")), Integer.valueOf(c43989k.fow.hashCode()));
            C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + i + ", errCode = " + i3 + ", errType = " + i2);
            if (bundle.getInt("scene_end_listener_hash_code") == c43989k.fow.hashCode()) {
                switch (i) {
                    case C31128d.MIC_PTU_MEISHI /*233*/:
                        C43990b c43990b = c43989k.uJq;
                        c43990b.uxN--;
                        if (c43990b.uxN <= 0) {
                            C43989k.this.dcV();
                        }
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1"));
                        int i4 = bundle.getInt("geta8key_result_reason");
                        C4990ab.m7416i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(i4)));
                        switch (i4) {
                            case 0:
                            case 2:
                                if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -2005)) {
                                    c43989k.m78925a(bundle.getString("geta8key_result_req_url"), bundle.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                    c43989k.mo38569am(bundle);
                                    break;
                                }
                            case 1:
                            case 5:
                                if (i2 != 0 || i3 != 0) {
                                    if (i2 != 4 || i3 != -2005) {
                                        if (i2 != 0 && i3 == -3300) {
                                            c43989k.uJA = true;
                                            break;
                                        }
                                    }
                                    c43989k.fow.stopLoading();
                                    c43989k.m78925a(bundle.getString("geta8key_result_req_url"), bundle.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                    c43989k.mo38569am(bundle);
                                    break;
                                }
                                String string = bundle.getString("geta8key_result_req_url");
                                c43989k.uFu.mo63705a(string, jsapiPermissionWrapper, generalControlWrapper);
                                c43989k.uJp.remove(string);
                                break;
                                break;
                        }
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.MMWebViewClient", "hash code not equal");
        } else {
            C4990ab.m7420w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
        }
        AppMethodBeat.m2505o(10019);
        return true;
    }
}
