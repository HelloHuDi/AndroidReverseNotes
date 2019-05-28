package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.model.af;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass57;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass63;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.State;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.json.JSONObject;

public class WebViewUI extends MMActivity implements OnCreateContextMenuListener, com.tencent.mm.ui.widget.MMWebView.d {
    private static final Pattern uiv = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern uiw = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Set<String> ums;
    private static final ArrayList<z> uvK = new ArrayList();
    private static RenderPriority uvQ = RenderPriority.NORMAL;
    protected static int uwz = 0;
    protected String cMm;
    public volatile String cOG = null;
    protected int cSQ;
    protected String cvF = "";
    private int fromScene;
    public ak handler;
    private long iBE = 0;
    private String iCz;
    private int iJp;
    com.tencent.mm.ui.tools.j icA;
    private final com.tencent.mm.plugin.webview.modeltools.d icH = new com.tencent.mm.plugin.webview.modeltools.d();
    public com.tencent.mm.plugin.webview.stub.d icy = null;
    public k icz = null;
    protected String ium = "";
    protected int jLX;
    protected int jLY;
    private int jQp = 0;
    public String jUg;
    public int jYe = -1;
    private ServiceConnection ktl = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(7854);
            ab.i("MicroMsg.WebViewUI", "edw onServiceConnected");
            if (WebViewUI.this.pzf == null) {
                ab.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
                AppMethodBeat.o(7854);
                return;
            }
            boolean z;
            WebViewUI.this.icy = com.tencent.mm.plugin.webview.stub.d.a.G(iBinder);
            try {
                WebViewUI.this.icy.a(WebViewUI.this.umI, WebViewUI.this.hashCode());
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", e.getMessage());
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "onServiceConnected, invoker == null ? %b";
            Object[] objArr = new Object[1];
            if (WebViewUI.this.icy == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            m.uuj.icy = WebViewUI.this.icy;
            if (!bo.isNullOrNil(WebViewUI.this.getIntent().getStringExtra("ad_info"))) {
                m mVar = m.uuj;
                String stringExtra = WebViewUI.this.getIntent().getStringExtra("ad_info");
                String str3 = "";
                if (mVar.icy != null) {
                    try {
                        str3 = mVar.icy.g(23, null).getString("config_info_username");
                    } catch (RemoteException e2) {
                        ab.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", e2);
                    }
                }
                mVar.hg(stringExtra, str3);
            }
            if (WebViewUI.this.icy == null) {
                ab.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
                WebViewUI.this.finish();
                AppMethodBeat.o(7854);
                return;
            }
            WebViewUI.this.aMh();
            AppMethodBeat.o(7854);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(7855);
            ab.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
            if ((WebViewUI.this.uwA && WebViewUI.uwz <= 0) || (!WebViewUI.this.uwA && WebViewUI.uwz <= 1)) {
                com.tencent.mm.plugin.webview.modeltools.c.c(WebViewUI.this.icy);
                com.tencent.mm.plugin.webview.modelcache.p cYp = com.tencent.mm.plugin.webview.modelcache.p.a.uob;
                for (int i = 0; i < cYp.unZ.size(); i++) {
                    cYp.unZ.valueAt(i);
                }
                cYp.unZ.clear();
                cYp.uoa.clear();
            }
            if (WebViewUI.this.uwA || WebViewUI.this.uwB || WebViewUI.this.isFinishing()) {
                WebViewUI.this.icy = null;
                AppMethodBeat.o(7855);
                return;
            }
            ab.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
            WebViewUI.b(WebViewUI.this);
            AppMethodBeat.o(7855);
        }
    };
    protected com.tencent.mm.ui.widget.snackbar.a.b mUw = new com.tencent.mm.ui.widget.snackbar.a.b() {
        public final void aIu() {
            AppMethodBeat.i(7880);
            try {
                WebViewUI.this.icy.favEditTag();
                AppMethodBeat.o(7880);
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
                AppMethodBeat.o(7880);
            }
        }
    };
    private int networkType;
    public int nfs = 0;
    public String nft = null;
    private long oes = 0;
    public MMWebView pzf;
    protected boolean rpm = true;
    protected int screenOrientation = -1;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d uhz = null;
    private d uic;
    protected com.tencent.mm.plugin.webview.ui.tools.bag.h uie;
    public aq ulI = new aq();
    protected com.tencent.mm.plugin.webview.stub.e umI;
    protected volatile String unr;
    private final com.tencent.mm.plugin.webview.modeltools.a utt = new com.tencent.mm.plugin.webview.modeltools.a();
    protected boolean uuW = false;
    public MMFalseProgressBar uuX;
    public ProgressBar uuY;
    private ImageButton uuZ;
    private boolean uvA = true;
    protected int uvB;
    private String uvC = null;
    protected byte[] uvD = new byte[0];
    private boolean uvE = false;
    private boolean uvF = false;
    public boolean uvG = false;
    private View uvH;
    private ap uvI;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> uvJ = new ArrayList();
    private boolean uvL = false;
    private CustomViewCallback uvM;
    private View uvN;
    protected com.tencent.xweb.l uvO;
    private ProgressBar uvP;
    protected l uvR = new l(null);
    protected m uvS = new m();
    protected o uvT = new o();
    protected q uvU = new q();
    private final com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent> uvV = new com.tencent.mm.sdk.b.c<SendDataToH5FromMiniProgramEvent>() {
        {
            AppMethodBeat.i(7807);
            this.xxI = SendDataToH5FromMiniProgramEvent.class.getName().hashCode();
            AppMethodBeat.o(7807);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(7808);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = (SendDataToH5FromMiniProgramEvent) bVar;
            if (WebViewUI.this.hashCode() == sendDataToH5FromMiniProgramEvent.hJV && WebViewUI.this.uhz != null) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("miniprogramAppID", sendDataToH5FromMiniProgramEvent.hJU);
                hashMap.put("data", sendDataToH5FromMiniProgramEvent.data);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.uhz;
                al.d(new AnonymousClass63(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onMiniProgramData", hashMap, dVar.uFv, dVar.uFw)));
            }
            AppMethodBeat.o(7808);
            return false;
        }
    };
    private boolean uvW = false;
    private int uvX = 0;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.f uvY;
    protected boolean uvZ = false;
    private ImageButton uva;
    protected View uvb;
    protected FrameLayout uvc;
    public FrameLayout uvd;
    protected MovingImageButton uve;
    protected boolean uvf = false;
    private boolean uvg = false;
    protected com.tencent.mm.bm.a uvh;
    private WebViewInputFooter uvi;
    protected WebViewSearchContentInputFooter uvj;
    private boolean uvk;
    private boolean uvl;
    public String uvm = null;
    protected boolean uvn = true;
    protected long uvo = 0;
    private boolean uvp = false;
    int uvq = -1;
    public boolean uvr = false;
    private boolean uvs = false;
    private boolean uvt = false;
    protected boolean uvu = true;
    private boolean uvv = false;
    private boolean uvw = false;
    private boolean uvx = false;
    private boolean uvy = false;
    protected boolean uvz = false;
    public boolean uwA = false;
    private boolean uwB = false;
    private boolean uwC = false;
    protected volatile boolean uwD = false;
    private com.tencent.mm.plugin.webview.e.d uwE = new com.tencent.mm.plugin.webview.e.d();
    private com.tencent.mm.plugin.webview.model.b uwF = new com.tencent.mm.plugin.webview.model.b(this.ulI);
    protected com.tencent.mm.plugin.webview.modeltools.n uwG = new com.tencent.mm.plugin.webview.modeltools.n();
    protected i uwH;
    public j uwI;
    protected IUtils uwJ = null;
    private WebViewClipBoardHelper uwK;
    protected com.tencent.mm.plugin.webview.b uwL;
    protected volatile String uwM;
    protected volatile long uwN;
    private o uwO;
    protected an uwP = new an(this);
    protected com.tencent.xweb.r uwQ = new com.tencent.xweb.r() {
        public final boolean A(MotionEvent motionEvent) {
            AppMethodBeat.i(7819);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7819);
                return false;
            }
            boolean Q = WebViewUI.this.pzf.Q(motionEvent);
            AppMethodBeat.o(7819);
            return Q;
        }

        public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.i(7820);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7820);
                return false;
            }
            com.tencent.mm.plugin.webview.model.aq.a cXY = WebViewUI.this.ulI.cXY();
            if (i4 > cXY.una) {
                cXY.una = i4;
            }
            cXY.rCb = i6;
            boolean c = WebViewUI.this.pzf.c(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.o(7820);
            return c;
        }

        public final void aGs() {
            AppMethodBeat.i(7821);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7821);
                return;
            }
            WebViewUI.this.pzf.dKK();
            AppMethodBeat.o(7821);
        }

        @TargetApi(9)
        public final void d(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.i(7822);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7822);
                return;
            }
            WebViewUI.this.pzf.e(i, i2, z, z2);
            if (z2 && WebViewUI.this.ulI != null) {
                WebViewUI.this.ulI.q("mm_scroll_bottom", Boolean.TRUE);
            }
            AppMethodBeat.o(7822);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.i(7823);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7823);
                return;
            }
            WebViewUI.this.pzf.M(i, i2, i3, i4);
            WebViewUI.this.onWebViewScrollChanged(i, i2, i3, i4);
            AppMethodBeat.o(7823);
        }

        public final boolean B(MotionEvent motionEvent) {
            AppMethodBeat.i(7824);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7824);
                return false;
            }
            boolean R = WebViewUI.this.pzf.R(motionEvent);
            AppMethodBeat.o(7824);
            return R;
        }

        public final boolean C(MotionEvent motionEvent) {
            AppMethodBeat.i(7825);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7825);
                return false;
            }
            boolean S = WebViewUI.this.pzf.S(motionEvent);
            AppMethodBeat.o(7825);
            return S;
        }
    };
    private com.tencent.mm.sdk.b.c<qg> uwR = new com.tencent.mm.sdk.b.c<qg>() {
        {
            AppMethodBeat.i(7843);
            this.xxI = qg.class.getName().hashCode();
            AppMethodBeat.o(7843);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(7845);
            boolean daK = daK();
            AppMethodBeat.o(7845);
            return daK;
        }

        private boolean daK() {
            AppMethodBeat.i(7844);
            if (WebViewUI.this.icy == null) {
                ab.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
                AppMethodBeat.o(7844);
            } else if (WebViewUI.this.uwM == null || WebViewUI.this.uwM.length() == 0) {
                ab.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
                AppMethodBeat.o(7844);
            } else {
                try {
                    ab.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", WebViewUI.this.uwM, Long.valueOf(WebViewUI.this.uwN), Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("service_click_tid", new String(WebViewUI.this.uwM));
                    bundle.putLong("service_click_stime", WebViewUI.this.uwN);
                    bundle.putLong("service_click_etime", r0);
                    WebViewUI.this.icy.s(2836, bundle);
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", e.getMessage());
                }
                WebViewUI.this.uwM = null;
                AppMethodBeat.o(7844);
            }
            return false;
        }
    };
    private boolean uwS = true;
    protected View uwT;
    private View uwU;
    private com.tencent.mm.bm.a.b uwV = new com.tencent.mm.bm.a.b() {
        public final void a(com.tencent.mm.bm.a.a aVar, com.tencent.mm.bm.a.a aVar2) {
            AppMethodBeat.i(7811);
            ab.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
            WebViewUI.this.screenOrientation = 4;
            WebViewUI.this.aBS();
            if (WebViewUI.this.uvh != null) {
                WebViewUI.this.uvh.disable();
            }
            AppMethodBeat.o(7811);
        }
    };
    private boolean uwW = false;
    protected final l uwX = new l();
    private boolean uwY;
    private OnLongClickListener uwZ = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(7846);
            if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                boolean daL = daL();
                AppMethodBeat.o(7846);
                return daL;
            }
            AppMethodBeat.o(7846);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean daL() {
            boolean dq;
            Exception e;
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(7847);
            com.tencent.xweb.WebView.b bVar = null;
            try {
                bVar = WebViewUI.this.pzf.getHitTestResult();
            } catch (Exception e2) {
                ab.e("MicroMsg.WebViewUI", "getHitTestResult exp %s", e2.getMessage());
            }
            if (bVar == null || bo.isNullOrNil(bVar.mExtra)) {
                ab.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
                AppMethodBeat.o(7847);
                return false;
            }
            try {
                dq = WebViewUI.this.icy.dq(bVar.mExtra);
                if (dq) {
                    try {
                        WebViewUI.this.icy.dB(bVar.mExtra, WebViewUI.this.hashCode());
                    } catch (Exception e3) {
                        e = e3;
                        ab.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                        z = dq;
                        if (z) {
                        }
                        AppMethodBeat.o(7847);
                        return z2;
                    }
                }
                z = dq;
            } catch (Exception e4) {
                e = e4;
                dq = true;
            }
            if (z) {
                WebViewUI.b(WebViewUI.this, bVar.mExtra);
            } else {
                z2 = z;
            }
            AppMethodBeat.o(7847);
            return z2;
        }
    };
    protected HashMap<String, Boolean> uwa = new HashMap();
    protected HashMap<String, String> uwb = new HashMap();
    protected HashMap<String, ArrayList<com.tencent.mm.m.d.b>> uwc = new HashMap();
    protected HashMap<String, Boolean> uwd = new HashMap();
    protected d uwe;
    protected com.tencent.mm.ui.widget.a.c uwf = null;
    private View uwg;
    public View uwh = null;
    protected String uwi = null;
    private boolean uwj = false;
    private volatile boolean uwk = false;
    private final boolean uwl = true;
    private boolean uwm = false;
    protected volatile boolean uwn = false;
    private final Set<String> uwo = new HashSet();
    public boolean uwp = false;
    protected boolean uwq = false;
    private final Map<String, Map<String, String>> uwr = new ConcurrentHashMap();
    protected Map<String, String> uws;
    private Map uwt;
    private int uwu = 0;
    private String uwv = "";
    private boolean uww = false;
    private final Map<String, String> uwx = new HashMap();
    private final Set<String> uwy = new HashSet();
    String[] uxa;
    protected boolean uxb = false;
    public OnLongClickListener uxc = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            return false;
        }
    };
    private String uxd = "";
    protected volatile String uxe = "";
    protected volatile String uxf = null;
    private volatile String uxg = "";
    protected volatile String uxh = "";
    private long uxi = 0;
    private com.tencent.mm.ui.base.p uxj;
    private com.tencent.mm.plugin.webview.model.af.d uxk = new com.tencent.mm.plugin.webview.model.af.d() {
        public final void aeq(String str) {
            AppMethodBeat.i(7866);
            WebViewUI.a(WebViewUI.this, str, true, 9);
            AppMethodBeat.o(7866);
        }

        public final void goBack() {
            AppMethodBeat.i(7867);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.o(7867);
            } else if (WebViewUI.this.uwj) {
                AppMethodBeat.o(7867);
            } else if (WebViewUI.this.pzf.canGoBack() && WebViewUI.this.uvn) {
                WebViewUI.this.dai();
                AppMethodBeat.o(7867);
            } else {
                m.uuj.close();
                WebViewUI.this.finish();
                AppMethodBeat.o(7867);
            }
        }

        public final void d(OnCancelListener onCancelListener) {
            AppMethodBeat.i(7868);
            if (WebViewUI.this.uxj != null) {
                WebViewUI.this.uxj.dismiss();
            }
            WebViewUI.this.uxj = com.tencent.mm.ui.base.h.b(WebViewUI.this, WebViewUI.this.getString(R.string.da2), true, onCancelListener);
            AppMethodBeat.o(7868);
        }

        public final void blb() {
            AppMethodBeat.i(7869);
            if (WebViewUI.this.uxj != null) {
                WebViewUI.this.uxj.dismiss();
            }
            AppMethodBeat.o(7869);
        }
    };
    protected com.tencent.mm.plugin.webview.model.af.b uxl = new com.tencent.mm.plugin.webview.model.af.b() {
        private Map<Integer, Integer> uxx = new HashMap();

        {
            AppMethodBeat.i(7871);
            AppMethodBeat.o(7871);
        }

        public final void add(int i) {
            AppMethodBeat.i(7872);
            WebViewUI.d(WebViewUI.this, i);
            if (this.uxx.containsKey(Integer.valueOf(i))) {
                this.uxx.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.uxx.get(Integer.valueOf(i))).intValue() + 1));
                AppMethodBeat.o(7872);
                return;
            }
            this.uxx.put(Integer.valueOf(i), Integer.valueOf(1));
            AppMethodBeat.o(7872);
        }

        public final void remove(int i) {
            AppMethodBeat.i(7873);
            WebViewUI.e(WebViewUI.this, i);
            if (this.uxx.containsKey(Integer.valueOf(i))) {
                this.uxx.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.uxx.get(Integer.valueOf(i))).intValue() - 1));
                AppMethodBeat.o(7873);
                return;
            }
            this.uxx.put(Integer.valueOf(i), Integer.valueOf(0));
            AppMethodBeat.o(7873);
        }

        public final boolean cXH() {
            AppMethodBeat.i(7874);
            for (Entry value : this.uxx.entrySet()) {
                if (((Integer) value.getValue()).intValue() > 0) {
                    AppMethodBeat.o(7874);
                    return true;
                }
            }
            AppMethodBeat.o(7874);
            return false;
        }
    };
    private com.tencent.mm.ui.base.i uxm;
    private long uxn = 0;
    private String[] uxo = null;

    class e implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private e() {
        }

        /* synthetic */ e(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7897);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7897);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://critical_update/");
            AppMethodBeat.o(7897);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7898);
            com.tencent.mm.plugin.report.service.h.pYm.a(405, 25, 1, true);
            WebViewUI.f(WebViewUI.this, 1);
            AppMethodBeat.o(7898);
            return true;
        }
    }

    public class g extends com.tencent.xweb.l {
        private Dialog dialog = null;
        public volatile boolean eBB = false;
        private final List<String> uxC = new LinkedList();

        protected g() {
            AppMethodBeat.i(7912);
            AppMethodBeat.o(7912);
        }

        public final void a(WebView webView, int i) {
            AppMethodBeat.i(7913);
            if (i < 100) {
                WebViewUI.b(WebViewUI.this, false);
                AppMethodBeat.o(7913);
                return;
            }
            if (i >= 100) {
                WebViewUI.b(WebViewUI.this, true);
            }
            AppMethodBeat.o(7913);
        }

        public final void d(WebView webView, String str) {
            AppMethodBeat.i(7914);
            ab.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", str, WebViewUI.this.uxf);
            super.d(webView, str);
            if (WebViewUI.this.uuW) {
                ab.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(str)));
                AppMethodBeat.o(7914);
            } else if (str == null) {
                ab.e("MicroMsg.WebViewUI", "null title");
                AppMethodBeat.o(7914);
            } else if (WebViewUI.this.rpm) {
                if (!(bo.nullAsNil(WebViewUI.this.uxf).equals(str) || com.tencent.mm.plugin.webview.modelcache.q.Ed(str))) {
                    WebViewUI.this.setMMTitle(str);
                }
                AppMethodBeat.o(7914);
            } else {
                AppMethodBeat.o(7914);
            }
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.i(7915);
            ab.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
            try {
                WebViewUI.this.mController.ylL.getWindow().addFlags(128);
                if (WebViewUI.this.uvN != null) {
                    customViewCallback.onCustomViewHidden();
                    AppMethodBeat.o(7915);
                    return;
                }
                WebViewUI.this.nP(false);
                WebViewUI.this.uvN = view;
                WebViewUI.this.uvM = customViewCallback;
                if (WebViewUI.this.pzf.isXWalkKernel()) {
                    WebViewUI.this.uvd.addView(view, 0);
                    WebViewUI.this.fullScreenNoTitleBar(true);
                    WebViewUI.this.setStatusBarColor(0);
                    if (WebViewUI.this.uwT != null) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WebViewUI.this.uwT.getLayoutParams();
                        marginLayoutParams.topMargin = 0;
                        WebViewUI.this.uwT.setLayoutParams(marginLayoutParams);
                    }
                    AppMethodBeat.o(7915);
                    return;
                }
                WebViewUI.this.pzf.setVisibility(8);
                WebViewUI.this.uvd.addView(view);
                WebViewUI.this.setTitleVisibility(4);
                AppMethodBeat.o(7915);
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
                AppMethodBeat.o(7915);
            }
        }

        public final void onHideCustomView() {
            AppMethodBeat.i(7916);
            ab.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
            WebViewUI.this.mController.ylL.getWindow().clearFlags(128);
            if (WebViewUI.this.uvN == null) {
                AppMethodBeat.o(7916);
                return;
            }
            try {
                WebViewUI.this.nP(false);
                if (WebViewUI.this.pzf.isXWalkKernel()) {
                    WebViewUI.this.fullScreenNoTitleBar(false);
                    WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(R.color.a1f));
                    if (WebViewUI.this.uwT != null) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WebViewUI.this.uwT.getLayoutParams();
                        int r = WebViewUI.r(WebViewUI.this);
                        if (r != marginLayoutParams.topMargin) {
                            marginLayoutParams.topMargin = r;
                            WebViewUI.this.uwT.setLayoutParams(marginLayoutParams);
                        }
                    }
                } else {
                    WebViewUI.this.pzf.setVisibility(0);
                    WebViewUI.this.setTitleVisibility(0);
                }
                if (WebViewUI.this.uvd != null) {
                    WebViewUI.this.uvd.removeView(WebViewUI.this.uvN);
                }
                WebViewUI.this.uvN = null;
                if (WebViewUI.this.uvM != null) {
                    WebViewUI.this.uvM.onCustomViewHidden();
                }
                AppMethodBeat.o(7916);
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
                AppMethodBeat.o(7916);
            }
        }

        public final View getVideoLoadingProgressView() {
            AppMethodBeat.i(7917);
            if (WebViewUI.this.uvP == null) {
                WebViewUI.this.uvP = new ProgressBar(WebViewUI.this);
                WebViewUI.this.uvP.setIndeterminate(true);
            }
            ProgressBar t = WebViewUI.this.uvP;
            AppMethodBeat.o(7917);
            return t;
        }

        public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
            AppMethodBeat.i(7918);
            ab.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", str);
            if (!com.tencent.mm.pluginsdk.permission.b.o(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
                com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
            }
            com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(R.string.g2e, new Object[]{str}), WebViewUI.this.getString(R.string.g2f), WebViewUI.this.getString(R.string.s6), WebViewUI.this.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(7901);
                    ab.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
                    callback.invoke(str, true, true);
                    g.a(WebViewUI.this.icy, 14340, WebViewUI.this.cOG, WebViewUI.this.dae(), Integer.valueOf(WebViewUI.this.cSQ), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(aq.aEn()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(7901);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(7904);
                    ab.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
                    callback.invoke(str, false, false);
                    g.a(WebViewUI.this.icy, 14340, WebViewUI.this.cOG, WebViewUI.this.dae(), Integer.valueOf(WebViewUI.this.cSQ), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(aq.aEn()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(7904);
                }
            });
            AppMethodBeat.o(7918);
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.i(7919);
            WebViewUI.this.icH.a(WebViewUI.this, WebViewUI.this.icz, valueCallback, null, str, str2);
            AppMethodBeat.o(7919);
        }

        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, com.tencent.xweb.l.a aVar) {
            AppMethodBeat.i(7920);
            if (aVar.getMode() != 0 && aVar.getMode() != 1) {
                AppMethodBeat.o(7920);
                return false;
            } else if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                ab.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                AppMethodBeat.o(7920);
                return true;
            } else {
                String str = aVar.getAcceptTypes()[0];
                String str2 = "*";
                if (aVar.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                WebViewUI.this.icH.a(WebViewUI.this, WebViewUI.this.icz, null, valueCallback, str, str2);
                AppMethodBeat.o(7920);
                return true;
            }
        }

        public final boolean b(WebView webView, final String str, String str2, final com.tencent.xweb.h hVar) {
            AppMethodBeat.i(7921);
            ab.d("MicroMsg.WebViewUI", "onJsConfirm");
            final PBool pBool = new PBool();
            pBool.value = false;
            if (WebViewUI.this.isFinishing() || WebViewUI.this.uiu) {
                ab.d("MicroMsg.WebViewUI", "onJsConfirm finish");
                hVar.cancel();
                AppMethodBeat.o(7921);
                return true;
            }
            WebViewUI.this.uwu = WebViewUI.this.uwu + 1;
            if (WebViewUI.this.uwu > 2) {
                this.dialog = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(R.string.g28), WebViewUI.this.getString(R.string.s6), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7905);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11683, str, Integer.valueOf(1), Integer.valueOf(WebViewUI.this.uwu));
                        hVar.cancel();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        WebViewUI.this.finish();
                        AppMethodBeat.o(7905);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7906);
                        pBool.value = true;
                        hVar.confirm();
                        AppMethodBeat.o(7906);
                    }
                }, (int) R.color.hy);
            } else {
                this.dialog = com.tencent.mm.ui.base.h.a(WebViewUI.this.mController.ylL, false, str2, "", WebViewUI.this.getString(R.string.s6), WebViewUI.this.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7907);
                        pBool.value = true;
                        hVar.confirm();
                        AppMethodBeat.o(7907);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7908);
                        hVar.cancel();
                        AppMethodBeat.o(7908);
                    }
                });
            }
            if (this.dialog != null) {
                this.dialog.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(7909);
                        ab.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
                        if (!pBool.value) {
                            hVar.cancel();
                        }
                        AppMethodBeat.o(7909);
                    }
                });
                this.dialog.setCancelable(false);
                this.dialog.setCanceledOnTouchOutside(false);
                AppMethodBeat.o(7921);
                return true;
            }
            boolean b = super.b(webView, str, str2, hVar);
            AppMethodBeat.o(7921);
            return b;
        }

        public final boolean a(WebView webView, String str, String str2, String str3, com.tencent.xweb.g gVar) {
            AppMethodBeat.i(7922);
            boolean a = super.a(webView, str, str2, str3, gVar);
            AppMethodBeat.o(7922);
            return a;
        }

        public final boolean a(WebView webView, final String str, String str2, final com.tencent.xweb.h hVar) {
            AppMethodBeat.i(7923);
            ab.d("MicroMsg.WebViewUI", "onJsAlert");
            final PBool pBool = new PBool();
            pBool.value = false;
            if (WebViewUI.this.isFinishing() || WebViewUI.this.uiu) {
                ab.d("MicroMsg.WebViewUI", "onJsAlert finish");
                hVar.cancel();
                AppMethodBeat.o(7923);
                return true;
            }
            com.tencent.mm.ui.widget.a.c a;
            WebViewUI.this.uwu = WebViewUI.this.uwu + 1;
            if (WebViewUI.this.uwu > 2) {
                a = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(R.string.g28), WebViewUI.this.getString(R.string.s6), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7910);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11683, str, Integer.valueOf(1), Integer.valueOf(WebViewUI.this.uwu));
                        hVar.cancel();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        WebViewUI.this.finish();
                        AppMethodBeat.o(7910);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7911);
                        pBool.value = true;
                        hVar.confirm();
                        AppMethodBeat.o(7911);
                    }
                }, (int) R.color.t7);
            } else {
                a = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(R.string.s6), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(7902);
                        pBool.value = true;
                        hVar.confirm();
                        AppMethodBeat.o(7902);
                    }
                });
            }
            if (a != null) {
                a.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(7903);
                        ab.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
                        if (!pBool.value) {
                            hVar.cancel();
                        }
                        AppMethodBeat.o(7903);
                    }
                });
                a.setCanceledOnTouchOutside(false);
                a.qZ(false);
                AppMethodBeat.o(7923);
                return true;
            }
            boolean a2 = super.a(webView, str, str2, hVar);
            AppMethodBeat.o(7923);
            return a2;
        }

        public final void aJY() {
            AppMethodBeat.i(7924);
            super.aJY();
            ab.i("MicroMsg.WebViewUI", "WebChromeClient onEnterFullscreen");
            AppMethodBeat.o(7924);
        }

        public final void aDI() {
            AppMethodBeat.i(7925);
            super.aDI();
            ab.i("MicroMsg.WebViewUI", "WebChromeClient onExitFullscreen");
            AppMethodBeat.o(7925);
        }
    }

    class f implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private f() {
        }

        /* synthetic */ f(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7899);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7899);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://");
            AppMethodBeat.o(7899);
            return t;
        }

        public final boolean afM(String str) {
            boolean z = true;
            AppMethodBeat.i(7900);
            int afH = WebViewUI.this.afH(bo.nullAsNil(WebViewUI.this.uwi));
            if (com.tencent.mm.pluginsdk.e.aH(str, WebViewUI.this.uxn)) {
                try {
                    if ("weixin://dl/shopping".equals(str)) {
                        String cZh = WebViewUI.this.icy.cZh();
                        if (!bo.isNullOrNil(cZh)) {
                            WebViewUI.this.loadUrl(cZh);
                        }
                    } else if ("weixin://dl/faq".equals(str)) {
                        int cZj = WebViewUI.this.icy.cZj();
                        int cZk = WebViewUI.this.icy.cZk();
                        WebViewUI.this.loadUrl(ah.getContext().getString(R.string.ebk, new Object[]{Integer.valueOf(cZj), Integer.valueOf(cZk)}));
                    } else if ("weixin://dl/posts".equals(str)) {
                        WebViewUI.this.icy.cZl();
                    } else if ("weixin://dl/moments".equals(str)) {
                        WebViewUI.this.icy.cZm();
                    } else if (str.startsWith("weixin://dl/feedback")) {
                        WebViewUI.this.icy.afp(str);
                    } else if ("weixin://dl/scan".equals(str)) {
                        com.tencent.mm.bp.d.c(WebViewUI.this, "scanner", ".ui.SingleTopScanUI", new Intent());
                    } else {
                        com.tencent.mm.pluginsdk.e.aiq(str);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    arrayList.add("1");
                    arrayList.add(String.valueOf(afH));
                    arrayList.add(bo.nullAsNil(WebViewUI.this.uwi));
                    arrayList.add(bo.nullAsNil(WebViewUI.this.cOG));
                    WebViewUI.this.icy.k(11405, arrayList);
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", e.getMessage());
                }
            } else {
                z = false;
            }
            AppMethodBeat.o(7900);
            return z;
        }
    }

    public class h extends com.tencent.xweb.s {
        protected h() {
        }

        public boolean aft(String str) {
            AppMethodBeat.i(7931);
            ab.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                AppMethodBeat.o(7931);
                return true;
            } else if (WebViewUI.d(WebViewUI.this, str)) {
                ab.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = ".concat(String.valueOf(str)));
                AppMethodBeat.o(7931);
                return true;
            } else {
                WebViewUI.this.uxf = str;
                AppMethodBeat.o(7931);
                return false;
            }
        }

        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(7932);
            boolean i = i(webView, str);
            if (i) {
                WebViewUI.this.uvG = false;
            }
            AppMethodBeat.o(7932);
            return i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:58:0x01cd  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x01cd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean i(WebView webView, final String str) {
            AppMethodBeat.i(138039);
            ab.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = ".concat(String.valueOf(str)));
            WebViewUI.this.uvG = true;
            int intExtra;
            if (!WebViewUI.c(WebViewUI.this, str)) {
                ab.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(str)));
                WebViewUI.k(WebViewUI.this);
                AppMethodBeat.o(138039);
                return true;
            } else if (com.tencent.mm.pluginsdk.ui.tools.u.t(str, "about:blank")) {
                ab.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
                AppMethodBeat.o(138039);
                return true;
            } else if (DownloadChecker.a(str, WebViewUI.this.cMm, webView)) {
                ab.i("MicroMsg.WebViewUI", "use the downloader to download");
                AppMethodBeat.o(138039);
                return true;
            } else if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                WebViewUI.this.afL(str);
                AppMethodBeat.o(138039);
                return true;
            } else if (str.startsWith("weixin://dl/business") && com.tencent.mm.pluginsdk.e.s(Uri.parse(str))) {
                String host = Uri.parse(WebViewUI.this.cOG).getHost();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(str + "&domain=" + host));
                intExtra = WebViewUI.this.getIntent().getIntExtra("pay_channel", -1);
                if (intExtra != -1) {
                    ab.i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", str, Integer.valueOf(intExtra));
                    intent.putExtra("pay_channel", intExtra);
                }
                intent.putExtra("translate_link_scene", 13);
                WebViewUI.this.startActivity(intent);
                AppMethodBeat.o(138039);
                return true;
            } else {
                try {
                    if (str.startsWith("weixinpreinject://iframe") && WebViewUI.this.uvY != null) {
                        ab.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                        if (str.equals(WebViewUI.this.uxd)) {
                        }
                    } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                        if ((WebViewUI.this.cOG.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && WebViewUI.this.uvw) {
                            com.tencent.mm.pluginsdk.e.bu(WebViewUI.this.mController.ylL, str);
                            WebViewUI.this.finish();
                            AppMethodBeat.o(138039);
                            return true;
                        }
                        if (str.equals(WebViewUI.this.uxd)) {
                            WebViewUI.this.uxd = "";
                            AppMethodBeat.o(138039);
                            return true;
                        } else if (WebViewUI.this.afM(str)) {
                            AppMethodBeat.o(138039);
                            return true;
                        } else if (str.startsWith("weixin://")) {
                            ab.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                            AppMethodBeat.o(138039);
                            return true;
                        } else {
                            intExtra = WebViewUI.this.uvR.ael(str);
                            boolean aft;
                            if ((intExtra == 0 || intExtra == 2 || intExtra == 8) && !WebViewUI.this.uvs) {
                                ab.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(intExtra)));
                                if (WebViewUI.this.afI(str)) {
                                    WebViewUI.this.pzf.stopLoading();
                                    WebViewUI.this.pzf.post(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(7926);
                                            WebViewUI.this.b(str, null, true);
                                            AppMethodBeat.o(7926);
                                        }
                                    });
                                } else if (!str.equals(WebViewUI.this.uvC)) {
                                    WebViewUI.this.pzf.stopLoading();
                                }
                                if (str.equals(WebViewUI.this.uvC)) {
                                    ab.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                    aft = aft(str);
                                    AppMethodBeat.o(138039);
                                    return aft;
                                }
                                WebViewUI.a(WebViewUI.this, str, true, intExtra);
                                AppMethodBeat.o(138039);
                                return true;
                            }
                            aft = aft(str);
                            AppMethodBeat.o(138039);
                            return aft;
                        }
                    } else {
                        if (str.startsWith("weixin://webview/initReady/") || str.startsWith("weixin://webview/preInjectJSBridge/")) {
                            AppMethodBeat.o(138039);
                            return true;
                        }
                        if (str.equals(WebViewUI.this.uxd)) {
                        }
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                    if (WebViewUI.this.icz == null) {
                        ab.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                        AppMethodBeat.o(138039);
                        return true;
                    }
                }
            }
        }

        public void a(WebView webView, String str, boolean z) {
            AppMethodBeat.i(7933);
            ab.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
            super.a(webView, str, z);
            if (com.tencent.mm.pluginsdk.ui.tools.u.t(str, "about:blank")) {
                ab.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
                AppMethodBeat.o(7933);
                return;
            }
            String url = webView.getUrl();
            if (WebViewUI.this.uvs) {
                WebViewUI.this.as(url, false);
            }
            boolean z2 = WebViewUI.A(WebViewUI.this) && (WebViewUI.this.unr == null || bo.isEqual(url, WebViewUI.this.unr));
            if (z2 || !(WebViewUI.this.icz == null || WebViewUI.this.icz.has(url) || bo.isEqual(url, WebViewUI.this.uvC))) {
                ab.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", url);
                WebViewUI.this.as(url, z2);
                WebViewUI.this.X(true, false);
                WebViewUI.this.uww = true;
            }
            WebViewUI.this.uwX.cZU();
            WebViewUI.this.uxf = str;
            WebViewUI.this.uie.afY(str);
            AppMethodBeat.o(7933);
        }

        public void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(7934);
            super.b(webView, str, bitmap);
            WebViewUI.this.uvG = true;
            WebViewUI.this.uwE.aI("onPageStarted", System.currentTimeMillis());
            com.tencent.mm.plugin.webview.model.a.c(WebViewUI.this.pzf);
            com.tencent.mm.plugin.webview.e.e.h(str, WebViewUI.this.mController.ylL);
            ab.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = ".concat(String.valueOf(str)));
            com.tencent.mm.plugin.report.service.h.pYm.a(155, 0, 1, false);
            if (!WebViewUI.this.uxb) {
                WebViewUI.this.uwI.cZL();
            }
            com.tencent.mm.plugin.topstory.a.h.m25do(WebViewUI.this.cMm, 0);
            if (WebViewUI.this.aYd()) {
                if (TextUtils.isEmpty(str) || !str.equals(webView.getUrl())) {
                    ab.v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", str, webView.getUrl());
                } else {
                    ab.i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
                    WebViewUI.this.daq();
                    if (WebViewUI.this.uvY != null) {
                        WebViewUI.this.uvY.uCf = false;
                    }
                    WebViewUI.this.daF();
                }
            }
            if (com.tencent.mm.sdk.a.b.dnO() && "http://www.dktest-mmcrash.com/".equals(str)) {
                Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
            }
            WebViewUI.this.unr = WebViewUI.this.uxf;
            WebViewUI.this.l(str, bo.anT(), 1);
            WebViewUI.this.ulI.cXX().unr = WebViewUI.this.unr;
            WebViewUI.this.uxf = str;
            m mVar = m.uuj;
            ab.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", str, mVar.uuk, mVar.qTK);
            String str2 = mVar.uuk;
            mVar.uuk = str;
            if (!bo.isNullOrNil(mVar.qTK)) {
                mVar.h(1, str2, 0);
            }
            ab.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", WebViewUI.this.unr, WebViewUI.this.uxf);
            if (WebViewUI.c(WebViewUI.this, str)) {
                WebViewUI.this.uwX.cZU();
                WebViewUI.this.uwX.setCurrentURL(str);
                if (WebViewUI.this.afM(str)) {
                    WebViewUI.this.uxd = str;
                    AppMethodBeat.o(7934);
                    return;
                }
                if (WebViewUI.this.uvY != null) {
                    WebViewUI.this.uvY.dbY();
                }
                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                if (WebViewUI.this.afI(str)) {
                    WebViewUI.this.uwn = true;
                    WebViewUI.this.uuX.finish();
                    WebViewUI.this.pzf.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (WebViewUI.this.uhz != null) {
                        WebViewUI.this.uhz.z((String) WebViewUI.this.uwx.get(str), (Map) WebViewUI.this.uwr.get(str));
                    }
                } else {
                    WebViewUI.this.uwn = false;
                    if (!WebViewUI.this.uwp) {
                        WebViewUI.this.uuX.start();
                    }
                }
                WebViewUI.this.uwI.afE(str);
                if (w.NO_NEED.equals(WebViewUI.this.as(str, false))) {
                    WebViewUI.this.uwG.wy(str);
                    if (!WebViewUI.this.uxb) {
                        WebViewUI.this.uwI.utI = true;
                    }
                }
                WebViewUI.this.X(true, false);
                WebViewUI.this.uww = false;
                com.tencent.mm.plugin.webview.model.aq.n cXV = WebViewUI.this.ulI.cXV();
                int i = WebViewUI.this.cSQ;
                String str3 = WebViewUI.this.cMm;
                cXV.cSQ = i;
                cXV.uni = str3;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
                } else if (!cXV.unv.containsKey(str)) {
                    cXV.unv.put(str, Long.valueOf(bo.anU()));
                }
                Bundle bundle = (Bundle) WebViewUI.this.getIntent().getParcelableExtra("jsapiargs");
                if (bundle != null) {
                    Parcelable parcelable = bundle.getParcelable("KSnsAdTag");
                    if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                        WebViewUI.this.ulI.cYg().pmI = (SnsAdClick) parcelable;
                        WebViewUI.this.ulI.cYg().L(str, AppEventsConstants.EVENT_PARAM_VALUE_NO, System.currentTimeMillis());
                        WebViewUI.this.ulI.cYg().b(WebViewUI.this.icy);
                    }
                }
                WebViewUI.this.uwu = 0;
                if (!(WebViewUI.this.uwO == null || WebViewUI.this.uwO.uxW)) {
                    o F = WebViewUI.this.uwO;
                    ab.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", str);
                    F.iCz = str;
                    F.daR();
                }
                AppMethodBeat.o(7934);
                return;
            }
            ab.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            WebViewUI.k(WebViewUI.this);
            AppMethodBeat.o(7934);
        }

        public void b(WebView webView, final String str) {
            AppMethodBeat.i(7935);
            super.b(webView, str);
            WebViewUI.this.uvG = false;
            WebViewUI.this.uwE.aI("onPageFinished", System.currentTimeMillis());
            WebViewUI.this.uvF = true;
            com.tencent.mm.plugin.webview.model.a.c(WebViewUI.this.pzf);
            WebViewUI.this.uie.afY(str);
            if (!WebViewUI.this.uwj) {
                WebViewUI.this.uwj = true;
                WebViewUI.this.ulI.cYa().loadFinished = true;
            }
            ab.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", str);
            com.tencent.mm.plugin.webview.model.aq.d cYf = WebViewUI.this.ulI.cYf();
            if (cYf.mlA && !cYf.und) {
                try {
                    Uri parse = Uri.parse(str);
                    if (str.startsWith("http")) {
                        String host = parse.getHost();
                        if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(283, 0, 1, true);
                            cYf.und = true;
                            ab.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", str);
                        }
                    } else {
                        ab.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", str);
                }
            }
            m mVar = m.uuj;
            ab.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", mVar.qTK);
            if (!bo.isNullOrNil(mVar.qTK)) {
                mVar.kT(2);
            }
            if (WebViewUI.this.pzf == null) {
                ab.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
                AppMethodBeat.o(7935);
                return;
            }
            WebViewUI.this.uwG.wy(str);
            String title = WebViewUI.this.pzf.getTitle();
            ab.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", WebViewUI.this.mController.getMMTitle(), title, Boolean.valueOf(WebViewUI.this.uuW), Boolean.valueOf(WebViewUI.this.rpm), WebViewUI.this.uxf);
            if (WebViewUI.this.pzf.getIsX5Kernel() && !bo.isNullOrNil(title) && title.length() > 0 && !title.equals(WebViewUI.this.mController.getMMTitle()) && !title.startsWith("http") && ((WebViewUI.this.uxf == null || !WebViewUI.this.uxf.equals(title)) && !WebViewUI.this.uuW && WebViewUI.this.rpm)) {
                ab.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
                WebViewUI.this.setMMTitle(title);
            }
            WebViewUI.this.uwX.setCurrentURL(WebViewUI.this.dae());
            boolean booleanExtra = WebViewUI.this.getIntent().getBooleanExtra("shouldForceViewPort", false);
            ab.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: ".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                webView.evaluateJavascript(WebViewUI.this.getIntent().getStringExtra("view_port_code"), null);
            }
            WebViewUI.J(WebViewUI.this);
            if (WebViewUI.c(WebViewUI.this, str)) {
                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                WebViewUI.this.uuX.finish();
                WebViewUI.this.uxd = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    ab.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                    AppMethodBeat.o(7935);
                    return;
                }
                ab.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.this.uwv);
                if (WebViewUI.this.uvY != null) {
                    WebViewUI.this.uvY.uFU = WebViewUI.this.getIntent().getBooleanExtra("inject_city_service_js", false);
                    WebViewUI.this.uvY.uFV = WebViewUI.this.getIntent().getStringExtra("city_service_ext_info");
                    WebViewUI.this.uvY.dbZ();
                }
                if (!(WebViewUI.this.icz == null || WebViewUI.this.icz.aei(str) == null)) {
                    WebViewUI.a(WebViewUI.this, WebViewUI.this.icz.aei(str).jB(34), WebViewUI.this.icz.aei(str).jB(75));
                }
                WebViewUI.this.nP(false);
                com.tencent.mm.plugin.webview.model.aq.n cXV = WebViewUI.this.ulI.cXV();
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                } else if (cXV.unv.containsKey(str)) {
                    cXV.unv.put(str, Long.valueOf(bo.anU() - ((Long) cXV.unv.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.model.aq.f cXW = WebViewUI.this.ulI.cXW();
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
                } else if (cXW.ung.containsKey(str)) {
                    cXW.ung.put(str, Long.valueOf(bo.anU() - ((Long) cXW.ung.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.model.aq.h cXZ = WebViewUI.this.ulI.cXZ();
                com.tencent.mm.plugin.webview.stub.d dVar = WebViewUI.this.icy;
                if (!(dVar == null || cXZ.cph)) {
                    cXZ.cph = true;
                    int aEn = aq.aEn();
                    long anU = bo.anU() - cXZ.startTime;
                    if (anU >= 0 && anU <= 180000) {
                        String str2 = cXZ.uni;
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(4);
                        objArr[1] = Long.valueOf(anU);
                        objArr[2] = Integer.valueOf(aEn);
                        if (cXZ.url == null) {
                            title = cXZ.url;
                        } else {
                            title = cXZ.url.replace(",", "!");
                        }
                        objArr[3] = title;
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(aq.umY);
                        objArr[8] = Integer.valueOf(aq.umZ);
                        objArr[9] = Integer.valueOf(cXZ.cSQ);
                        objArr[10] = cXZ.uni;
                        aq.b(dVar, str2, objArr);
                        ab.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", cXZ.url, Long.valueOf(anU), Integer.valueOf(aEn), Integer.valueOf(aq.umY), Integer.valueOf(aq.umZ), Integer.valueOf(cXZ.cSQ), cXZ.uni);
                    }
                }
                if (!WebViewUI.this.uwa.containsKey(str)) {
                    WebViewUI.this.uwa.put(str, Boolean.valueOf(WebViewUI.this.dxY()));
                }
                Bundle bundle = (Bundle) WebViewUI.this.getIntent().getParcelableExtra("jsapiargs");
                if (bundle != null) {
                    Parcelable parcelable = bundle.getParcelable("KSnsAdTag");
                    if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                        WebViewUI.this.ulI.cYg().pmI = (SnsAdClick) parcelable;
                        WebViewUI.this.ulI.cYg().L(str, "1", System.currentTimeMillis());
                        WebViewUI.this.ulI.cYg().b(WebViewUI.this.icy);
                    }
                }
                WebViewUI.this.nO(((Boolean) WebViewUI.this.uwa.get(str)).booleanValue());
                Boolean bool = (Boolean) WebViewUI.this.uwd.get(str);
                if (bool == null || !bool.booleanValue()) {
                    WebViewUI.this.showOptionMenu(0, true);
                } else {
                    WebViewUI.this.showOptionMenu(0, false);
                }
                if (WebViewUI.this.uvu && bo.isNullOrNil(WebViewUI.this.uxe)) {
                    WebViewUI.this.uxe = WebViewUI.this.uxf;
                }
                WebViewUI.this.uxi = bo.anT();
                com.tencent.mm.sdk.b.a.xxA.m(new vp());
                if (!(WebViewUI.this.uwO == null || WebViewUI.this.uwO.uxW)) {
                    o F = WebViewUI.this.uwO;
                    ab.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", str);
                    F.iCz = str;
                }
                com.tencent.mm.plugin.webview.e.d B = WebViewUI.this.uwE;
                MMWebView mMWebView = WebViewUI.this.pzf;
                if (mMWebView != null) {
                    mMWebView.evaluateJavascript("JSON.stringify({timing:((window.performance && window.performance.timing) ? window.performance.timing : null)});", new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            AppMethodBeat.i(10143);
                            final String str = (String) obj;
                            Looper.myQueue().addIdleHandler(new IdleHandler() {
                                public final boolean queueIdle() {
                                    AppMethodBeat.i(10142);
                                    Looper.myQueue().removeIdleHandler(this);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        JSONObject optJSONObject = new JSONObject(str.substring(1, str.length() - 1).replace("\\\"", "\"")).optJSONObject("timing");
                                        Iterator keys = optJSONObject.keys();
                                        while (keys.hasNext()) {
                                            String str = (String) keys.next();
                                            d.this.aI(str, optJSONObject.optLong(str));
                                        }
                                    } catch (Exception e) {
                                        ab.w("MicroMsg.WebViewPerformanceHelper", "fetchDocumentTime ex: %s", e.getMessage());
                                    }
                                    d.this.ddc();
                                    ab.v("MicroMsg.WebViewPerformanceHelper", "onReceiveValue cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(10142);
                                    return false;
                                }
                            });
                            AppMethodBeat.o(10143);
                        }
                    });
                }
                if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
                    com.tencent.mm.ci.g.dOW().b(new com.tencent.mm.plugin.appbrand.compat.b.a.AnonymousClass1(webView)).a(new com.tencent.mm.vending.g.d.b<String>() {
                        public final /* synthetic */ void az(Object obj) {
                            AppMethodBeat.i(7928);
                            String str = (String) obj;
                            if (!(TextUtils.isEmpty(str) || BuildConfig.COMMAND.equals(str))) {
                                ((com.tencent.mm.plugin.appbrand.service.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.a.class)).bq(Uri.parse(str).getQueryParameter("uuid"), str);
                                WebViewUI.this.runOnUiThread(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(7927);
                                        WebViewUI.this.finish();
                                        AppMethodBeat.o(7927);
                                    }
                                });
                            }
                            AppMethodBeat.o(7928);
                        }
                    });
                }
                AppMethodBeat.o(7935);
                return;
            }
            ab.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            WebViewUI.k(WebViewUI.this);
            AppMethodBeat.o(7935);
        }

        public final void a(WebView webView, com.tencent.xweb.j jVar, SslError sslError) {
            String str;
            AppMethodBeat.i(7936);
            com.tencent.xweb.util.f.rB(true);
            String url = webView.getUrl() == null ? WebViewUI.this.uxf : webView.getUrl();
            if (url == null || !url.startsWith(((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).aVQ())) {
                str = url;
            } else {
                str = WebViewUI.this.cWL();
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.h.pYm.a(155, 30, 1, false);
            com.tencent.mm.plugin.topstory.a.h.m25do(WebViewUI.this.cMm, 1);
            com.tencent.mm.plugin.topstory.a.h.m25do(WebViewUI.this.cMm, 30);
            com.tencent.mm.plugin.topstory.a.h.c(WebViewUI.this.cMm, WebViewUI.this.cOG, 30, WebViewUI.this.ulI.cXY().edh);
            if (WebViewUI.this.uic == null) {
                WebViewUI.this.uic = new d(WebViewUI.this, WebViewUI.this.pzf);
            }
            WebViewUI.this.uic.a(str, jVar, sslError);
            AppMethodBeat.o(7936);
        }

        public void a(WebView webView, final int i, String str, final String str2) {
            AppMethodBeat.i(7937);
            com.tencent.xweb.util.f.rB(false);
            boolean isConnected = at.isConnected(WebViewUI.this);
            ab.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected));
            com.tencent.mm.plugin.report.service.h.pYm.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.h.pYm.a(155, (long) b.Jf(i), 1, false);
            com.tencent.mm.plugin.topstory.a.h.m25do(WebViewUI.this.cMm, 1);
            com.tencent.mm.plugin.topstory.a.h.m25do(WebViewUI.this.cMm, b.Jf(i));
            com.tencent.mm.plugin.topstory.a.h.c(WebViewUI.this.cMm, WebViewUI.this.cOG, b.Jf(i), WebViewUI.this.ulI.cXY().edh);
            super.a(webView, i, str, str2);
            m.uuj.Jq(i);
            WebViewUI.this.ulI.cYg().errCode = i;
            WebViewUI.this.uwI.utI = false;
            if (WebViewUI.this.uvy) {
                WebViewUI.this.finish();
            }
            try {
                if (new URL(str2).getHost().equals("mp.weixin.qq.com")) {
                    com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                        public final void run() {
                            String str;
                            AppMethodBeat.i(7929);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = str2;
                            objArr[1] = Integer.valueOf(i);
                            Context context = ah.getContext();
                            if (at.isWifi(context)) {
                                str = "wifi";
                            } else if (at.is4G(context)) {
                                str = "4g";
                            } else if (at.is3G(context)) {
                                str = "3g";
                            } else if (at.is2G(context)) {
                                str = "2g";
                            } else {
                                str = "none";
                            }
                            objArr[2] = str;
                            objArr[3] = h.afT("mp.weixin.qq.com");
                            hVar.e(17082, objArr);
                            AppMethodBeat.o(7929);
                        }
                    }, "WebViewUI.CheckDNS");
                }
                AppMethodBeat.o(7937);
            } catch (MalformedURLException e) {
                ab.printErrStackTrace("MicroMsg.WebViewUI", e, "check mp url", new Object[0]);
                AppMethodBeat.o(7937);
            }
        }

        public static String afT(String str) {
            AppMethodBeat.i(7938);
            StringBuilder stringBuilder = new StringBuilder();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    for (InetAddress hostAddress : allByName) {
                        stringBuilder.append(hostAddress.getHostAddress());
                        stringBuilder.append(";");
                    }
                }
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(7938);
                return stringBuilder2;
            } catch (UnknownHostException e) {
                ab.printErrStackTrace("MicroMsg.WebViewUI", e, "dnsIps", new Object[0]);
                AppMethodBeat.o(7938);
                return null;
            }
        }

        public final void h(WebView webView, String str) {
            AppMethodBeat.i(7939);
            ab.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = ".concat(String.valueOf(str)));
            if (WebViewUI.c(WebViewUI.this, str)) {
                com.tencent.mm.plugin.webview.model.aq.f cXW = WebViewUI.this.ulI.cXW();
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
                } else if (!(bo.isNullOrNil(cXW.iCz) || str.equals(cXW.iCz) || !cXW.unh)) {
                    if (cXW.unf.containsKey(cXW.iCz)) {
                        cXW.unf.put(cXW.iCz, Long.valueOf(bo.anU() - ((Long) cXW.unf.get(cXW.iCz)).longValue()));
                    }
                    cXW.unh = false;
                }
                super.h(webView, str);
                AppMethodBeat.o(7939);
                return;
            }
            ab.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            super.h(webView, str);
            WebViewUI.k(WebViewUI.this);
            AppMethodBeat.o(7939);
        }

        public com.tencent.xweb.o c(WebView webView, String str) {
            AppMethodBeat.i(7940);
            ab.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", str);
            if (afU(str)) {
                AppMethodBeat.o(7940);
                return null;
            }
            com.tencent.xweb.o afV = afV(str);
            AppMethodBeat.o(7940);
            return afV;
        }

        public com.tencent.xweb.o a(WebView webView, com.tencent.xweb.n nVar) {
            AppMethodBeat.i(7941);
            com.tencent.xweb.o a;
            if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
                a = super.a(webView, nVar);
                AppMethodBeat.o(7941);
                return a;
            }
            ab.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", nVar.getUrl(), nVar.getMethod(), Boolean.valueOf(nVar.isForMainFrame()));
            if (afU(nVar.getUrl().toString())) {
                AppMethodBeat.o(7941);
                return null;
            }
            a = afV(nVar.getUrl().toString());
            AppMethodBeat.o(7941);
            return a;
        }

        public com.tencent.xweb.o a(WebView webView, com.tencent.xweb.n nVar, Bundle bundle) {
            AppMethodBeat.i(7942);
            com.tencent.xweb.o a;
            if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
                a = super.a(webView, nVar);
                AppMethodBeat.o(7942);
                return a;
            }
            ab.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", nVar.getUrl(), nVar.getMethod(), Boolean.valueOf(nVar.isForMainFrame()));
            if (afU(nVar.getUrl().toString())) {
                AppMethodBeat.o(7942);
                return null;
            }
            if (com.tencent.mm.cj.c.iv(WebViewUI.this)) {
                try {
                    int i = bundle.getInt("resourceType");
                    if ((i == 1 || i == 7) && !WebViewUI.this.uvE) {
                        ab.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                        WebViewUI.a(WebViewUI.this, nVar.getUrl().toString(), false, 5);
                    }
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", e.getMessage());
                } catch (Throwable th) {
                    ab.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", th.getMessage());
                }
            }
            a = afV(nVar.getUrl().toString());
            AppMethodBeat.o(7942);
            return a;
        }

        private boolean afU(String str) {
            AppMethodBeat.i(7943);
            if (WebViewUI.c(WebViewUI.this, str)) {
                AppMethodBeat.o(7943);
                return false;
            }
            ab.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            WebViewUI.k(WebViewUI.this);
            AppMethodBeat.o(7943);
            return true;
        }

        private com.tencent.xweb.o afV(String str) {
            AppMethodBeat.i(7944);
            String dae = WebViewUI.this.dae();
            com.tencent.xweb.o a = WebViewUI.this.uwP.a(str, !WebViewUI.this.uwk, WebViewUI.this.icy);
            if (a != null) {
                hi(dae, str);
                AppMethodBeat.o(7944);
                return a;
            }
            AppMethodBeat.o(7944);
            return null;
        }

        private void hi(String str, String str2) {
            AppMethodBeat.i(7945);
            if (str2.equals(str) || WebViewUI.a(WebViewUI.this, str, str2)) {
                WebViewUI.this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7930);
                        if (WebViewUI.this.pzf != null) {
                            WebViewUI.this.pzf.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        }
                        WebViewUI webViewUI = WebViewUI.this;
                        AnonymousClass2 anonymousClass2 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(7809);
                                if (WebViewUI.this.uuX != null) {
                                    WebViewUI.this.uuX.finish();
                                    WebViewUI.this.uwI.cZJ();
                                }
                                AppMethodBeat.o(7809);
                            }
                        };
                        if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                            anonymousClass2.run();
                            AppMethodBeat.o(7930);
                            return;
                        }
                        webViewUI.handler.post(anonymousClass2);
                        AppMethodBeat.o(7930);
                    }
                });
            }
            AppMethodBeat.o(7945);
        }
    }

    class n implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private n() {
        }

        /* synthetic */ n(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7958);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7958);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://gethtml/");
            AppMethodBeat.o(7958);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7959);
            if (!bo.isNullOrNil(str)) {
                String substring = str.substring(17);
                ab.i("MicroMsg.WebViewUI", "[oneliang]get html content :".concat(String.valueOf(substring)));
                WebViewUI.this.afG(substring);
            }
            AppMethodBeat.o(7959);
            return false;
        }
    }

    protected class q {
        int uxP = 0;

        protected q() {
        }

        public final boolean daP() {
            return this.uxP > 0;
        }
    }

    class v implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private final String uxR;

        private v() {
            this.uxR = "weixin://openapi/openwebview/result?";
        }

        /* synthetic */ v(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7971);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7971);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://openapi/openwebview/result?");
            AppMethodBeat.o(7971);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7972);
            Resp resp = new Resp();
            Uri parse = Uri.parse(str);
            resp.result = parse.getQuery();
            resp.errCode = bo.getInt(parse.getQueryParameter("errCode"), 0);
            resp.errStr = parse.getQueryParameter("errMsg");
            resp.transaction = WebViewUI.this.getIntent().getStringExtra("transaction_for_openapi_openwebview");
            String queryParameter = parse.getQueryParameter("appid");
            if (bo.isNullOrNil(queryParameter)) {
                ab.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
                AppMethodBeat.o(7972);
            } else {
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                com.tencent.mm.pluginsdk.model.app.p.at(bundle);
                Args args = new Args();
                try {
                    args.targetPkgName = WebViewUI.this.icy.afi(queryParameter);
                    args.bundle = bundle;
                    ab.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", args);
                    MMessageActV2.send(WebViewUI.this, args);
                    WebViewUI.this.finish();
                    AppMethodBeat.o(7972);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                    AppMethodBeat.o(7972);
                }
            }
            return true;
        }
    }

    class x implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private x() {
        }

        /* synthetic */ x(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7976);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7976);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://private/gethtml/");
            AppMethodBeat.o(7976);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7977);
            try {
                String decode = URLDecoder.decode(str.substring(25));
                Bundle bundle = new Bundle();
                bundle.putString("nowUrl", WebViewUI.this.iCz);
                bundle.putString("tweetid", bo.nullAsNil(WebViewUI.this.getIntent().getStringExtra("tweetid")));
                bundle.putString("htmlData", decode);
                bundle.putInt("type", WebViewUI.this.getIntent().getIntExtra("type", 0));
                WebViewUI.this.icy.a(3, bundle, WebViewUI.this.hashCode());
                AppMethodBeat.o(7977);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
                AppMethodBeat.o(7977);
                return false;
            }
        }
    }

    class y implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private y() {
        }

        /* synthetic */ y(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7978);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7978);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://viewimage/");
            AppMethodBeat.o(7978);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7979);
            try {
                if (WebViewUI.this.icy.isSDCardAvailable()) {
                    WebViewUI.this.iCz = str.substring(19);
                    ab.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.this.iCz);
                    com.tencent.mm.pluginsdk.ui.tools.u.a(WebViewUI.this.pzf, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.this.uvA);
                    AppMethodBeat.o(7979);
                    return true;
                }
                WebViewUI.this.icy.a(2, null, WebViewUI.this.hashCode());
                AppMethodBeat.o(7979);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
                AppMethodBeat.o(7979);
                return false;
            }
        }
    }

    protected class m {
        private int uxN = 0;

        protected m() {
        }

        public final void daN() {
            AppMethodBeat.i(7955);
            ab.d("MicroMsg.WebViewUI", "addGetA8KeySceneEndListener, before inc count=%d", Integer.valueOf(this.uxN));
            if (this.uxN == 0) {
                WebViewUI.d(WebViewUI.this, (int) com.tencent.view.d.MIC_PTU_MEISHI);
            }
            this.uxN++;
            AppMethodBeat.o(7955);
        }

        public final void daO() {
            AppMethodBeat.i(7956);
            ab.d("MicroMsg.WebViewUI", "removeGetA8KeySceneEndListener, before dec count=%d", Integer.valueOf(this.uxN));
            this.uxN--;
            if (this.uxN <= 0) {
                WebViewUI.e(WebViewUI.this, (int) com.tencent.view.d.MIC_PTU_MEISHI);
            }
            AppMethodBeat.o(7956);
        }

        public final boolean daP() {
            AppMethodBeat.i(7957);
            ab.d("MicroMsg.WebViewUI", "GetA8KeySceneEndController.hasAddListener count=%d", Integer.valueOf(this.uxN));
            if (this.uxN > 0) {
                AppMethodBeat.o(7957);
                return true;
            }
            AppMethodBeat.o(7957);
            return false;
        }
    }

    protected class o {
        int uxO = 0;

        protected o() {
        }

        public final boolean daP() {
            return this.uxO > 0;
        }
    }

    class p implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private p() {
        }

        /* synthetic */ p(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7960);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7960);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://profile/");
            AppMethodBeat.o(7960);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7961);
            String substring = str.substring(17);
            if (substring == null || substring.length() == 0) {
                ab.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
                AppMethodBeat.o(7961);
            } else {
                if (!(WebViewUI.this.icz == null || WebViewUI.this.icz.cZS() == null || !WebViewUI.this.icz.cZS().jB(2))) {
                    WebViewUI.this.uhz.ago(substring);
                }
                AppMethodBeat.o(7961);
            }
            return true;
        }
    }

    public enum w {
        NO_NEED,
        WILL_GET,
        FAILED;

        static {
            AppMethodBeat.o(7975);
        }
    }

    class a implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private a() {
        }

        /* synthetic */ a(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7885);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7885);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://jump/");
            AppMethodBeat.o(7885);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7886);
            if (WebViewUI.this.icz.cZT().dmk()) {
                try {
                    WebViewUI.this.icy.bG(str, WebViewUI.this.icz.cZS().jB(7));
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
                }
                AppMethodBeat.o(7886);
            } else {
                ab.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", str);
                AppMethodBeat.o(7886);
            }
            return true;
        }
    }

    class b implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        public final String uxA;

        private b() {
            this.uxA = "weixin://addfriend/";
        }

        /* synthetic */ b(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7887);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7887);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://addfriend/");
            AppMethodBeat.o(7887);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7888);
            if (WebViewUI.this.icz.cZS().jB(5)) {
                String substring = str.substring(19);
                if (bo.isNullOrNil(substring)) {
                    AppMethodBeat.o(7888);
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_webview", true);
                bundle.putString("userName", substring);
                try {
                    WebViewUI.this.icy.a(8, bundle, WebViewUI.this.hashCode());
                } catch (Exception e) {
                    ab.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                }
                AppMethodBeat.o(7888);
                return true;
            }
            ab.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
            AppMethodBeat.o(7888);
            return true;
        }
    }

    protected static final class d {
        private String lang;
        private String ujA;
        private String ujB;
        private String ujC;
        private String ujD;
        private String ujE;
        private String ujz;
        private String uxB;

        private d(Bundle bundle) {
            AppMethodBeat.i(7891);
            this.uxB = bundle.getString("close_window_confirm_dialog_switch");
            this.ujz = bundle.getString("close_window_confirm_dialog_title_cn");
            this.ujA = bundle.getString("close_window_confirm_dialog_title_eng");
            this.ujB = bundle.getString("close_window_confirm_dialog_ok_cn");
            this.ujC = bundle.getString("close_window_confirm_dialog_ok_eng");
            this.ujD = bundle.getString("close_window_confirm_dialog_cancel_cn");
            this.ujE = bundle.getString("close_window_confirm_dialog_cancel_eng");
            this.lang = bundle.getString("application_language");
            AppMethodBeat.o(7891);
        }

        public static d ad(Bundle bundle) {
            AppMethodBeat.i(7892);
            d dVar = new d(bundle);
            AppMethodBeat.o(7892);
            return dVar;
        }

        public final boolean cXi() {
            AppMethodBeat.i(7893);
            if (bo.isNullOrNil(this.uxB)) {
                AppMethodBeat.o(7893);
                return false;
            }
            boolean equals = this.uxB.equals("true");
            AppMethodBeat.o(7893);
            return equals;
        }

        public final String daM() {
            AppMethodBeat.i(7894);
            String str;
            if ("zh_CN".equals(this.lang)) {
                str = this.ujz;
                AppMethodBeat.o(7894);
                return str;
            }
            str = this.ujA;
            AppMethodBeat.o(7894);
            return str;
        }

        public final String cXk() {
            AppMethodBeat.i(7895);
            String str;
            if ("zh_CN".equals(this.lang)) {
                str = this.ujB;
                AppMethodBeat.o(7895);
                return str;
            }
            str = this.ujC;
            AppMethodBeat.o(7895);
            return str;
        }

        public final String cXl() {
            AppMethodBeat.i(7896);
            String str;
            if ("zh_CN".equals(this.lang)) {
                str = this.ujD;
                AppMethodBeat.o(7896);
                return str;
            }
            str = this.ujE;
            AppMethodBeat.o(7896);
            return str;
        }
    }

    class j implements com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a {
        private j() {
        }

        /* synthetic */ j(WebViewUI webViewUI, byte b) {
            this();
        }

        public final void Cl(int i) {
            int i2 = 2;
            AppMethodBeat.i(7948);
            switch (i) {
                case 0:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 4;
                    break;
            }
            WebViewUI.c(WebViewUI.this, i2);
            try {
                if (WebViewUI.this.icy.cZd()) {
                    WebViewUI.this.icy.gx(16384, i2);
                    WebViewUI.this.icy.gx(16388, i2);
                }
                AppMethodBeat.o(7948);
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
                AppMethodBeat.o(7948);
            }
        }
    }

    public static class l {
        private static final Pattern hnu = Pattern.compile(".*#.*wechat_redirect");
        public String jVi = null;
        private LinkedList<String> uxM = new LinkedList();
        String[] uxa = null;

        static {
            AppMethodBeat.i(7954);
            AppMethodBeat.o(7954);
        }

        public l(String str) {
            AppMethodBeat.i(7951);
            this.jVi = str;
            AppMethodBeat.o(7951);
        }

        public final int ael(String str) {
            AppMethodBeat.i(7952);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.WebViewUI", "getReason fail, url is null");
                AppMethodBeat.o(7952);
                return 0;
            } else if (str.equals(this.jVi)) {
                AppMethodBeat.o(7952);
                return 0;
            } else if (hnu.matcher(str).find()) {
                AppMethodBeat.o(7952);
                return 2;
            } else if (afW(str)) {
                AppMethodBeat.o(7952);
                return 8;
            } else {
                AppMethodBeat.o(7952);
                return 1;
            }
        }

        private boolean afW(String str) {
            AppMethodBeat.i(7953);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7953);
                return false;
            } else if (this.uxa == null || this.uxa.length == 0) {
                AppMethodBeat.o(7953);
                return false;
            } else if (this.uxM.contains(str)) {
                AppMethodBeat.o(7953);
                return false;
            } else {
                String substring;
                if (URLUtil.isHttpUrl(str)) {
                    substring = str.substring(7);
                } else {
                    substring = str;
                }
                if (URLUtil.isHttpsUrl(substring)) {
                    substring = str.substring(8);
                }
                ab.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", str, substring);
                for (String str2 : this.uxa) {
                    ab.i("MicroMsg.WebViewUI", "force geta8key path = %s", str2);
                    if (substring.startsWith(r4[r3])) {
                        this.uxM.add(str);
                        AppMethodBeat.o(7953);
                        return true;
                    }
                }
                AppMethodBeat.o(7953);
                return false;
            }
        }
    }

    class s implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private s() {
        }

        /* synthetic */ s(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7964);
            com.tencent.mm.plugin.webview.stub.d dVar = WebViewUI.this.icy;
            if (6 == WebViewUI.this.getIntent().getIntExtra("geta8key_scene", 0)) {
                ab.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
            } else if (!bo.isNullOrNil(str) && dVar != null && com.tencent.mm.plugin.webview.model.af.c.a(dVar) && com.tencent.mm.plugin.webview.model.af.c.a(str, dVar)) {
                AppMethodBeat.o(7964);
                return true;
            }
            AppMethodBeat.o(7964);
            return false;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7965);
            String stringExtra = WebViewUI.this.getIntent().getStringExtra("geta8key_username");
            boolean a = com.tencent.mm.plugin.webview.model.af.c.a(str, stringExtra, WebViewUI.this.afH(stringExtra), WebViewUI.this.icy, WebViewUI.this.uxk, WebViewUI.this.uxl, WebViewUI.this.hashCode());
            AppMethodBeat.o(7965);
            return a;
        }
    }

    static final class z {
        final WeakReference<WebViewUI> hiC;
        final int id;

        public z(WebViewUI webViewUI) {
            AppMethodBeat.i(7980);
            this.hiC = new WeakReference(webViewUI);
            this.id = webViewUI.hashCode();
            AppMethodBeat.o(7980);
        }
    }

    class c implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private c() {
        }

        /* synthetic */ c(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7889);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7889);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://webview/close/");
            AppMethodBeat.o(7889);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7890);
            if (WebViewUI.this.icz.cZS().jB(17)) {
                WebViewUI.this.finish();
                AppMethodBeat.o(7890);
            } else {
                ab.e("MicroMsg.WebViewUI", "close window permission fail");
                AppMethodBeat.o(7890);
            }
            return true;
        }
    }

    class t implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private t() {
        }

        /* synthetic */ t(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7967);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7967);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://readershare/");
            AppMethodBeat.o(7967);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7968);
            com.tencent.mm.ui.base.h.a(WebViewUI.this, "", new String[]{WebViewUI.this.getString(R.string.di1)}, "", new com.tencent.mm.ui.base.h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(7966);
                    if (i == 0) {
                        t tVar = t.this;
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("shortUrl", WebViewUI.this.getIntent().getStringExtra("shortUrl"));
                            bundle.putInt("type", WebViewUI.this.getIntent().getIntExtra("type", 0));
                            WebViewUI.this.icy.a(4, bundle, tVar.hashCode());
                            AppMethodBeat.o(7966);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                        }
                    }
                    AppMethodBeat.o(7966);
                }
            });
            AppMethodBeat.o(7968);
            return true;
        }
    }

    class u implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private u() {
        }

        /* synthetic */ u(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7969);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7969);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://recommend_update/");
            AppMethodBeat.o(7969);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7970);
            com.tencent.mm.plugin.report.service.h.pYm.a(405, 24, 1, true);
            WebViewUI.f(WebViewUI.this, 2);
            AppMethodBeat.o(7970);
            return true;
        }
    }

    class i implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private final String uxL;

        private i() {
            this.uxL = "weixin://feedback/";
        }

        /* synthetic */ i(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7946);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7946);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://feedback/");
            AppMethodBeat.o(7946);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7947);
            Bundle bundle = new Bundle();
            bundle.putInt(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
            bundle.putInt(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
            try {
                WebViewUI.this.icy.a(7, bundle, WebViewUI.this.hashCode());
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            AppMethodBeat.o(7947);
            return true;
        }
    }

    class k implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private k() {
        }

        /* synthetic */ k(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7949);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7949);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://connectToFreeWifi/");
            AppMethodBeat.o(7949);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7950);
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            ab.i("MicroMsg.WebViewUI", "apKey value = %s", queryParameter);
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!bo.isNullOrNil(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!bo.isNullOrNil(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.bp.d.b(ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            AppMethodBeat.o(7950);
            return true;
        }
    }

    class r implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private r() {
        }

        /* synthetic */ r(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.i(7962);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(7962);
                return false;
            }
            boolean t = com.tencent.mm.pluginsdk.ui.tools.u.t(str, "weixin://manual_update/");
            AppMethodBeat.o(7962);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.i(7963);
            com.tencent.mm.plugin.report.service.h.pYm.a(405, 26, 1, true);
            WebViewUI.f(WebViewUI.this, 3);
            AppMethodBeat.o(7963);
            return true;
        }
    }

    public WebViewUI() {
        AppMethodBeat.i(7981);
        AppMethodBeat.o(7981);
    }

    static /* synthetic */ boolean A(WebViewUI webViewUI) {
        AppMethodBeat.i(8127);
        boolean dav = webViewUI.dav();
        AppMethodBeat.o(8127);
        return dav;
    }

    static /* synthetic */ void J(WebViewUI webViewUI) {
        AppMethodBeat.i(8128);
        webViewUI.daA();
        AppMethodBeat.o(8128);
    }

    static /* synthetic */ String afR(String str) {
        AppMethodBeat.i(8113);
        String afJ = afJ(str);
        AppMethodBeat.o(8113);
        return afJ;
    }

    static /* synthetic */ void eq(View view) {
        AppMethodBeat.i(8108);
        af(view, 5894);
        AppMethodBeat.o(8108);
    }

    static /* synthetic */ boolean f(WebViewUI webViewUI) {
        AppMethodBeat.i(8112);
        boolean cZs = webViewUI.cZs();
        AppMethodBeat.o(8112);
        return cZs;
    }

    static /* synthetic */ int i(WebViewUI webViewUI) {
        AppMethodBeat.i(8116);
        int daz = webViewUI.daz();
        AppMethodBeat.o(8116);
        return daz;
    }

    static /* synthetic */ void k(WebViewUI webViewUI) {
        AppMethodBeat.i(8119);
        webViewUI.dah();
        AppMethodBeat.o(8119);
    }

    static /* synthetic */ void o(WebViewUI webViewUI) {
        AppMethodBeat.i(8122);
        webViewUI.dau();
        AppMethodBeat.o(8122);
    }

    static /* synthetic */ int r(WebViewUI webViewUI) {
        AppMethodBeat.i(8124);
        int daa = webViewUI.daa();
        AppMethodBeat.o(8124);
        return daa;
    }

    static {
        AppMethodBeat.i(8134);
        HashSet hashSet = new HashSet();
        ums = hashSet;
        hashSet.add("file:///android_asset/");
        String str = com.tencent.mm.compatible.util.e.eSk;
        if (!bo.isNullOrNil(str)) {
            str = com.tencent.mm.compatible.util.e.eSk.replace("/data/user/0", "/data/data");
        }
        ums.add("file://" + new File(aa.Ia(0)).getAbsolutePath());
        ums.add("file://" + new File(com.tencent.mm.compatible.util.e.eSn, "fts/res").getAbsolutePath());
        ums.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        ums.add("file://" + new File(com.tencent.mm.compatible.util.e.eSn, "wenote/res").getAbsolutePath());
        ums.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        ab.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath());
        ums.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        ums.add("file://" + new File(com.tencent.mm.compatible.util.e.eSn, "emoji/res").getAbsolutePath());
        ab.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r1.getAbsolutePath(), r0.getAbsolutePath());
        ums.add("file://" + new File(aa.Ia(1)).getAbsolutePath());
        ums.add("file://" + new File(com.tencent.mm.compatible.util.e.eSn, "fts_browse/res").getAbsolutePath());
        ab.i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", r0.getAbsolutePath(), r1.getAbsolutePath());
        Iterator it = ums.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", (String) it.next());
        }
        AppMethodBeat.o(8134);
    }

    public final com.tencent.mm.plugin.webview.e.d cZW() {
        return this.uwE;
    }

    /* Access modifiers changed, original: protected */
    public void b(String str, String str2, Map<String, String> map) {
    }

    /* Access modifiers changed, original: protected */
    public void FY(String str) {
        AppMethodBeat.i(7982);
        ab.i("MicroMsg.WebViewUI", "[notifyPageInfo]pageInfo:%s", str);
        AppMethodBeat.o(7982);
    }

    /* Access modifiers changed, original: protected */
    public void ab(Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public boolean aMj() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void ac(Bundle bundle) {
        int color;
        int i;
        AppMethodBeat.i(7983);
        if (bundle.getBoolean("set_navigation_bar_color_reset", false)) {
            color = this.uwO == null ? getResources().getColor(R.color.a5s) : this.uwO.daW();
            i = 255;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        xE((color & 16777215) | (i << 24));
        AppMethodBeat.o(7983);
    }

    public final void xE(int i) {
        AppMethodBeat.i(7984);
        super.xE(i);
        if (this.uwl) {
            setStatusBarColor(i);
        }
        AppMethodBeat.o(7984);
    }

    public void initSwipeBack() {
        AppMethodBeat.i(7985);
        super.initSwipeBack();
        if (getSwipeBackLayout() == null) {
            AppMethodBeat.o(7985);
        } else if (this.uwl) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            com.tencent.mm.ui.statusbar.b bVar = new com.tencent.mm.ui.statusbar.b(this);
            if (childAt instanceof FrameLayout) {
                View childAt2 = ((FrameLayout) childAt).getChildAt(0);
                LayoutParams layoutParams = childAt2.getLayoutParams();
                ((FrameLayout) childAt).removeView(childAt2);
                bVar.addView(childAt2, layoutParams);
            } else {
                bVar.addView(childAt);
            }
            getSwipeBackLayout().addView(bVar);
            getSwipeBackLayout().setContentView(bVar);
            this.uwm = true;
            AppMethodBeat.o(7985);
        } else {
            AppMethodBeat.o(7985);
        }
    }

    private void nN(boolean z) {
        if (!z) {
            this.uvL = true;
        }
    }

    public void onResume() {
        Bundle bundle;
        AppMethodBeat.i(7986);
        super.onResume();
        if (dae() != null) {
            com.tencent.mm.plugin.webview.e.e.h(dae(), this);
        } else {
            com.tencent.mm.plugin.webview.e.e.h(cWL(), this);
        }
        this.ulI.cXX().lastResumeTime = bo.yz();
        this.ulI.cXY().lastResumeTime = bo.yz();
        m mVar = m.uuj;
        ab.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", mVar.qTK);
        if (!bo.isNullOrNil(mVar.qTK)) {
            mVar.kT(7);
        }
        if (!this.uwS) {
            int hashCode = hashCode();
            for (int size = uvK.size() - 1; size >= 0; size--) {
                if (((z) uvK.get(size)).id == hashCode) {
                    uvK.remove(size);
                    break;
                }
            }
            uvK.add(new z(this));
        }
        this.uwS = false;
        if (this.uvL) {
            nN(true);
            this.uvL = false;
        }
        dak();
        if (this.icy != null) {
            try {
                bundle = new Bundle();
                bundle.putInt("screen_orientation", this.screenOrientation);
                this.icy.g(83, bundle);
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e.getMessage());
            }
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        IB("onResume");
        try {
            if (this.icy != null) {
                bundle = this.icy.g(19, null);
                if (bundle != null) {
                    ab.i("MicroMsg.WebViewUI", "onResume, has init = %b", Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")));
                    if (bundle.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", e2.getMessage());
        }
        this.oes = bo.anT();
        this.uwF.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7870);
                com.tencent.mm.modelstat.d.b(3, "WebViewUI_" + WebViewUI.this.afH(bo.nullAsNil(WebViewUI.this.uwi)), WebViewUI.this.hashCode());
                AppMethodBeat.o(7870);
            }
        });
        if (this.uwD) {
            finish();
        }
        AppMethodBeat.o(7986);
    }

    public void onPause() {
        AppMethodBeat.i(7987);
        super.onPause();
        com.tencent.mm.modelstat.d.b(4, "WebViewUI_" + afH(bo.nullAsNil(this.uwi)), hashCode());
        com.tencent.mm.modelstat.d.h("WebViewUI_" + afH(bo.nullAsNil(this.uwi)), this.oes, bo.anT());
        com.tencent.mm.plugin.webview.model.aq.l cXX = this.ulI.cXX();
        if (cXX.lastResumeTime != -1) {
            cXX.iBA += bo.az(cXX.lastResumeTime) / 1000;
        }
        com.tencent.mm.plugin.webview.model.aq.a cXY = this.ulI.cXY();
        if (cXY.lastResumeTime != -1) {
            cXY.iBA += bo.az(cXY.lastResumeTime);
        }
        m mVar = m.uuj;
        ab.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", mVar.qTK);
        if (mVar.foa) {
            ab.i("MicroMsg.WebViewReportUtil", "isFinish is true");
        } else if (!bo.isNullOrNil(mVar.qTK)) {
            mVar.kT(6);
        }
        try {
            if (this.icy != null) {
                Bundle g = this.icy.g(19, null);
                if (g != null) {
                    ab.i("MicroMsg.WebViewUI", "onPause, has init = %b", Boolean.valueOf(g.getBoolean("webview_video_proxy_init")));
                    if (g.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "notify app toback failed : %s", e.getMessage());
        }
        dau();
        IB("onPause");
        if (this.uvO != null) {
            ab.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.uvO.onHideCustomView();
                AppMethodBeat.o(7987);
                return;
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.WebViewUI", e2, "onPause", new Object[0]);
            }
        }
        AppMethodBeat.o(7987);
    }

    public void finish() {
        AppMethodBeat.i(7988);
        if (this.uvt) {
            setResult(-1);
        }
        try {
            if (this.icy != null) {
                this.icy.Jc(hashCode());
                this.icy.IP(hashCode());
                this.umI = null;
            }
            ab.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            ab.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(e)));
        }
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.uwB = true;
        super.finish();
        AppMethodBeat.o(7988);
    }

    public int getLayoutId() {
        return R.layout.b77;
    }

    public boolean convertActivityFromTranslucent() {
        AppMethodBeat.i(7989);
        boolean booleanExtra = getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
        AppMethodBeat.o(7989);
        return booleanExtra;
    }

    public void setMMTitle(String str) {
        AppMethodBeat.i(7990);
        if (this.uvx) {
            super.setMMTitle((int) R.string.fz6);
            AppMethodBeat.o(7990);
            return;
        }
        super.setMMTitle(str);
        AppMethodBeat.o(7990);
    }

    public final void M(CharSequence charSequence) {
        AppMethodBeat.i(7991);
        if (this.uvx) {
            super.setMMTitle((int) R.string.fz6);
            AppMethodBeat.o(7991);
            return;
        }
        super.M(charSequence);
        AppMethodBeat.o(7991);
    }

    private void IB(String str) {
        AppMethodBeat.i(7992);
        if (this.uhz != null) {
            this.uhz.agn(str);
            try {
                if (str.equals("onPause")) {
                    this.icy.Je(hashCode());
                    AppMethodBeat.o(7992);
                    return;
                }
                if (str.equals("onResume")) {
                    this.icy.Jd(hashCode());
                }
                AppMethodBeat.o(7992);
                return;
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewUI", "onResume, ex = " + e.getMessage());
            }
        }
        AppMethodBeat.o(7992);
    }

    /* Access modifiers changed, original: protected */
    public boolean cZA() {
        return false;
    }

    private void cZX() {
        AppMethodBeat.i(7993);
        this.uwE.aI("onTryBindServiceStart", System.currentTimeMillis());
        ab.i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.ktl, 1);
        this.uwE.aI("onTryBindServiceEnd", System.currentTimeMillis());
        AppMethodBeat.o(7993);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        AppMethodBeat.i(7994);
        com.tencent.mm.plugin.webview.modeltools.d dVar = this.icH;
        if (dVar.uoE == null) {
            dVar.cYx();
        } else {
            if (com.tencent.view.d.MIC_AVROUND_BLUR == i) {
                if (iArr[0] == 0) {
                    Intent intent = (Intent) dVar.uoE.first;
                    int intValue = ((Integer) dVar.uoE.second).intValue();
                    dVar.uoE = null;
                    startActivityForResult(intent, intValue);
                } else {
                    dVar.uoE = null;
                    dVar.b(this, 0, null);
                }
            }
            i2 = 1;
        }
        if (i2 != 0) {
            AppMethodBeat.o(7994);
        } else {
            AppMethodBeat.o(7994);
        }
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(7995);
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
        AppMethodBeat.o(7995);
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x0629 A:{Catch:{ Exception -> 0x079b }} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x07af  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0649 A:{Catch:{ Exception -> 0x07d2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0682  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0629 A:{Catch:{ Exception -> 0x079b }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0649 A:{Catch:{ Exception -> 0x07d2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x07af  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0682  */
    /* JADX WARNING: Missing block: B:109:0x06ec, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r0) == false) goto L_0x0123;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        Integer valueOf;
        Bundle bundle2;
        boolean z;
        String str;
        AppMethodBeat.i(7996);
        com.tencent.mm.plugin.webview.e.d dVar = this.uwE;
        dVar.startTime = System.currentTimeMillis();
        dVar.aI("onCreate", dVar.startTime);
        if (this.uwl) {
            this.yll = false;
        }
        super.onCreate(bundle);
        this.uwE.aI("onUIInitStart", System.currentTimeMillis());
        ab.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
        this.umI = new n(this);
        this.uwH = new i(this);
        this.uwI = new j(this);
        com.tencent.mm.plugin.webview.e.e.h(cWL(), this);
        this.uwO = new o(this);
        o oVar = this.uwO;
        if (oVar.uxX != null) {
            if (oVar.daQ()) {
                oVar.uxW = true;
            } else {
                oVar.uxW = false;
            }
            ab.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", oVar.uxX, Boolean.valueOf(oVar.uxW));
        }
        this.uxb = true;
        this.uvB = getIntent().getIntExtra("geta8key_session_id", (int) System.currentTimeMillis());
        this.uvD = getIntent().getByteArrayExtra("geta8key_cookie");
        this.uvm = cWL();
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.uvz = getIntent().getBooleanExtra("from_shortcut", false);
        this.uvq = getIntent().getIntExtra(com.tencent.mm.ui.e.m.ygo, -1);
        this.nft = getIntent().getStringExtra("status_bar_style");
        this.nfs = getIntent().getIntExtra("customize_status_bar_color", 0);
        String stringExtra = getIntent() == null ? "" : getIntent().getStringExtra("custom_action_bar_color");
        ab.i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", Boolean.valueOf(getIntent() == null ? false : getIntent().getBooleanExtra("open_custom_style_url", false)));
        if (getIntent() == null ? false : getIntent().getBooleanExtra("open_custom_style_url", false)) {
            stringExtra = "white";
            Jt(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
        }
        try {
            valueOf = Integer.valueOf(Color.parseColor(stringExtra));
        } catch (Exception e) {
            valueOf = null;
        }
        if (valueOf != null) {
            bundle2 = new Bundle(1);
            bundle2.putInt("set_navigation_bar_color_color", valueOf.intValue());
            bundle2.putInt("set_navigation_bar_color_alpha", 255);
            ac(bundle2);
            if (!getIntent().hasExtra("customize_status_bar_color")) {
                this.nfs = valueOf.intValue();
            }
        }
        this.cOG = cWL();
        this.uwp = getIntent().getBooleanExtra("show_native_web_view", false);
        this.uvl = getIntent().getBooleanExtra("key_trust_url", false);
        uwz++;
        uvK.add(new z(this));
        if (uvK.size() > 1) {
            ArrayList arrayList = uvK;
            z zVar = (z) arrayList.get(arrayList.size() - 2);
            if (!(zVar.hiC == null || zVar.hiC.get() == null)) {
                ((WebViewUI) zVar.hiC.get()).nN(false);
            }
        }
        ab.i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", Boolean.valueOf(this.uvl), this.cOG);
        this.cMm = bo.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.cSQ = afH(getIntent().getStringExtra("geta8key_username"));
        com.tencent.mm.plugin.webview.model.aq.o cXT = this.ulI.cXT();
        int i = this.cSQ;
        String str2 = this.cMm;
        cXT.cSQ = i;
        cXT.uni = str2;
        this.handler = new ak();
        if (this.ulI != null) {
            aq aqVar = this.ulI;
            bundle2 = getIntent().getBundleExtra("mm_report_bundle");
            if (bundle2 != null) {
                if (aqVar.umW != null) {
                    aqVar.umW.mqu = null;
                }
                aqVar.umW = new com.tencent.mm.plugin.webview.model.aq.b(bundle2);
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.uvp = z;
        Bundle bundleExtra = getIntent().getBundleExtra("close_window_confirm_info");
        if (bundleExtra != null) {
            this.uwe = d.ad(bundleExtra);
        }
        getWindow().setFlags(16777216, 16777216);
        getWindow().setFormat(-3);
        this.uwI.cZI();
        com.tencent.mm.pluginsdk.model.v.a.fH(this);
        boolean booleanExtra = getIntent().getBooleanExtra("usePlugin", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("zoom", true);
        boolean booleanExtra3 = getIntent().getBooleanExtra("useJs", true);
        stringExtra = cWL();
        if (WebView.isX5() && com.tencent.mm.plugin.webview.e.e.agF(stringExtra) && !"true".equals(com.tencent.xweb.a.iG("disable_apk_hook", "tools"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.pzf = com.tencent.mm.ui.widget.MMWebView.a.im(this);
            com.tencent.xweb.util.f.nI(173);
            if (this.pzf == null) {
                this.pzf = aXX();
            }
        } else {
            this.pzf = aXX();
        }
        this.pzf.zNv = this;
        MMWebView mMWebView = this.pzf;
        if (!(mMWebView == null || mMWebView.getIsX5Kernel() || com.tencent.mm.compatible.util.d.iW(19))) {
            try {
                ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new com.tencent.mm.compatible.loader.c(mMWebView, "mSysWebView", null).get());
                ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get());
                ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get());
                ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get());
                ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get());
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                ab.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    ab.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
            }
        }
        this.pzf.getSettings().setJavaScriptEnabled(booleanExtra3);
        this.pzf.getSettings().setPluginsEnabled(booleanExtra);
        this.pzf.getSettings().dUh();
        this.pzf.getSettings().setBuiltInZoomControls(booleanExtra2);
        this.pzf.getSettings().setUseWideViewPort(true);
        this.pzf.getSettings().setLoadWithOverviewMode(true);
        this.pzf.getSettings().dUc();
        this.pzf.getSettings().dUb();
        this.pzf.getSettings().setGeolocationEnabled(true);
        this.pzf.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.pzf.getSettings().dUj();
        this.pzf.getSettings().dUf();
        this.pzf.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
        this.pzf.getSettings().dUe();
        this.pzf.getSettings().dUg();
        this.pzf.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eSi + "databases/");
        com.tencent.xweb.b.dTR().dTS();
        com.tencent.xweb.b.dTR().f(this.pzf);
        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e3) {
        }
        j jVar = this.uwI;
        if (jVar.cZv() instanceof GameWebViewUI) {
            jVar.utK.add(Integer.valueOf(11));
            jVar.utK.add(Integer.valueOf(28));
        } else {
            jVar.utK.add(Integer.valueOf(7));
            jVar.utK.add(Integer.valueOf(11));
            jVar.utK.add(Integer.valueOf(28));
        }
        this.uwL = new com.tencent.mm.plugin.webview.b();
        if (getIntent().getBooleanExtra("translate_webview", false)) {
            this.uvx = true;
            setMMTitle((int) R.string.fz6);
            mMWebView = this.pzf;
            str = this.cOG;
            if (mMWebView.getX5WebViewExtension() != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("destLanguage", com.tencent.mm.sdk.platformtools.aa.dor());
                bundle3.putString("url", str);
                bundle3.putString("translateTips", getString(R.string.fza));
                bundle3.putString("translateFinish", getString(R.string.fz8));
                bundle3.putString("errorWording", getString(R.string.fz7));
                try {
                    org.a.a.ep(mMWebView.getX5WebViewExtension()).u("invokeMiscMethod", "translateWebSite", bundle3);
                } catch (Exception e22) {
                    ab.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", e22.getMessage());
                }
            }
        }
        this.uie = com.tencent.mm.plugin.webview.ui.tools.bag.o.a(new com.tencent.mm.plugin.webview.ui.tools.bag.q(this, this.pzf), cWO());
        this.uie.afY(this.cOG);
        cZX();
        this.icz = new k((JsapiPermissionWrapper) getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) getIntent().getParcelableExtra("hardcode_general_ctrl"), new com.tencent.mm.plugin.webview.ui.tools.k.b() {
            public final String aYj() {
                AppMethodBeat.i(7881);
                if (WebViewUI.this.pzf == null) {
                    AppMethodBeat.o(7881);
                    return null;
                }
                String url = WebViewUI.this.pzf.getUrl();
                AppMethodBeat.o(7881);
                return url;
            }
        });
        initView();
        IB("onCreate");
        this.ium = this.pzf.getSettings().getUserAgentString();
        this.fromScene = getIntent().getIntExtra("from_scence", 0);
        ab.d("MicroMsg.WebViewUI", " onCreate fromScene %d", Integer.valueOf(this.fromScene));
        this.cvF = com.tencent.mm.model.v.nW(bo.nullAsNil(hashCode()));
        ab.i("MicroMsg.WebViewUI", " onCreate sessionId %s", this.cvF);
        com.tencent.mm.plugin.webview.model.aq.h cXZ = this.ulI.cXZ();
        i = this.cSQ;
        String str3 = this.cMm;
        cXZ.cSQ = i;
        cXZ.uni = str3;
        cXZ.url = this.cOG;
        com.tencent.mm.plugin.webview.model.aq.d cYf = this.ulI.cYf();
        ab.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", this.cOG);
        try {
            Uri parse = Uri.parse(this.cOG);
            if (parse.getScheme() == null || parse.getScheme().toLowerCase().startsWith("http")) {
                str3 = parse.getHost();
                if (str3 == null || str3.toLowerCase().endsWith(".qq.com")) {
                    ab.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", str3);
                    try {
                        this.uwT = this.mController.contentView;
                        if (this.uwT != null) {
                            cZY();
                            ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new OnLayoutChangeListener() {
                                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                    AppMethodBeat.i(7883);
                                    WebViewUI.this.cZY();
                                    AppMethodBeat.o(7883);
                                }
                            });
                        }
                    } catch (Exception e222) {
                        ab.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", e222.getMessage());
                    }
                    try {
                        if (this.uwl) {
                            if (dab()) {
                                dad();
                            }
                        } else if (com.tencent.mm.compatible.util.d.iW(21)) {
                            final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                            viewGroup.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    AppMethodBeat.i(7884);
                                    WebViewUI.this.a(viewGroup, windowInsets);
                                    WebViewUI.this.uwm = true;
                                    WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
                                    AppMethodBeat.o(7884);
                                    return consumeSystemWindowInsets;
                                }
                            });
                        } else {
                            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                        }
                    } catch (Exception e2222) {
                        ab.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", e2222.getMessage());
                    }
                    this.uvh = new com.tencent.mm.bm.a(this.mController.ylL, this.uwV);
                    this.uwF.aNS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(7882);
                            com.tencent.mm.cb.f.dqL();
                            com.tencent.mm.cb.b.dqD();
                            AppMethodBeat.o(7882);
                        }
                    });
                    this.uwK = new WebViewClipBoardHelper(this);
                    this.uwR.dnU();
                    this.uvV.dnU();
                    if (this.uwO != null) {
                        oVar = this.uwO;
                        if (oVar.uxX != null) {
                            oVar.pzp = oVar.uxX.pzf;
                            if (oVar.uxW) {
                                ab.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                            } else {
                                ab.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                                oVar.daR();
                            }
                        }
                    }
                    af(getWindow().getDecorView(), 256);
                    aq.lP(getIntent().getLongExtra("start_activity_time", 0));
                    this.uwE.aI("onUIInitEnd", System.currentTimeMillis());
                    AppMethodBeat.o(7996);
                }
                cYf.mlA = true;
                this.uwT = this.mController.contentView;
                if (this.uwT != null) {
                }
                if (this.uwl) {
                }
                this.uvh = new com.tencent.mm.bm.a(this.mController.ylL, this.uwV);
                this.uwF.aNS().aa(/* anonymous class already generated */);
                this.uwK = new WebViewClipBoardHelper(this);
                this.uwR.dnU();
                this.uvV.dnU();
                if (this.uwO != null) {
                }
                af(getWindow().getDecorView(), 256);
                aq.lP(getIntent().getLongExtra("start_activity_time", 0));
                this.uwE.aI("onUIInitEnd", System.currentTimeMillis());
                AppMethodBeat.o(7996);
            }
            ab.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", parse.getScheme());
            this.uwT = this.mController.contentView;
            if (this.uwT != null) {
            }
            if (this.uwl) {
            }
            this.uvh = new com.tencent.mm.bm.a(this.mController.ylL, this.uwV);
            this.uwF.aNS().aa(/* anonymous class already generated */);
            this.uwK = new WebViewClipBoardHelper(this);
            this.uwR.dnU();
            this.uvV.dnU();
            if (this.uwO != null) {
            }
            af(getWindow().getDecorView(), 256);
            aq.lP(getIntent().getLongExtra("start_activity_time", 0));
            this.uwE.aI("onUIInitEnd", System.currentTimeMillis());
            AppMethodBeat.o(7996);
        } catch (Exception e4) {
            ab.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", str);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int getActionBarHeight() {
        AppMethodBeat.i(7997);
        int dimensionPixelSize;
        if (getResources().getDimensionPixelSize(R.dimen.a5) > com.tencent.mm.bz.a.fromDPToPix(this, 48)) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a5);
            AppMethodBeat.o(7997);
            return dimensionPixelSize;
        } else if (com.tencent.mm.sdk.platformtools.x.gu(this)) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fd);
            AppMethodBeat.o(7997);
            return dimensionPixelSize;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fc);
            AppMethodBeat.o(7997);
            return dimensionPixelSize;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZY() {
        AppMethodBeat.i(7998);
        if (this.uwT == null || cZZ()) {
            AppMethodBeat.o(7998);
            return;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.uwT.getLayoutParams();
        int daa = daa();
        if (daa != marginLayoutParams.topMargin) {
            marginLayoutParams.topMargin = daa;
            this.uwT.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(7998);
    }

    private int daa() {
        AppMethodBeat.i(7999);
        int i = this.uwl ? 0 : this.iJp;
        if (getSupportActionBar() == null || !getSupportActionBar().isShowing()) {
            AppMethodBeat.o(7999);
            return i;
        }
        i += getActionBarHeight();
        AppMethodBeat.o(7999);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(21)
    public final void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        AppMethodBeat.i(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        if (this.iJp == windowInsets.getSystemWindowInsetTop()) {
            AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_8000);
            return;
        }
        View viewGroup2;
        this.iJp = windowInsets.getSystemWindowInsetTop();
        cZY();
        if (viewGroup2 instanceof SwipeBackLayout) {
            viewGroup2 = viewGroup2.getChildAt(0);
        }
        View findViewById = viewGroup2.findViewById(R.id.k0);
        if (findViewById != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
            findViewById.setLayoutParams(marginLayoutParams);
            findViewById.requestLayout();
        }
        if (dab()) {
            dad();
        }
        AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_8000);
    }

    /* Access modifiers changed, original: protected */
    public boolean dab() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean dac() {
        AppMethodBeat.i(8002);
        if (bo.isNullOrNil(this.nft) || !this.nft.equals("black")) {
            AppMethodBeat.o(8002);
            return false;
        }
        AppMethodBeat.o(8002);
        return true;
    }

    public final void at(int i, boolean z) {
        AppMethodBeat.i(8004);
        if (VERSION.SDK_INT < 23 || com.tencent.mm.sdk.h.b.Mt()) {
            if (VERSION.SDK_INT >= 21) {
                if (z) {
                    i = g.Jj(i);
                }
                setStatusBarColor(i);
            }
            AppMethodBeat.o(8004);
            return;
        }
        setStatusBarColor(i);
        Window window = getWindow();
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z) {
            systemUiVisibility |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            systemUiVisibility &= -8193;
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        AppMethodBeat.o(8004);
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        boolean z = false;
        AppMethodBeat.i(8005);
        if (this.uwl) {
            View view = this.mController.contentView;
            if (!com.tencent.mm.ui.ah.Nw(i)) {
                z = true;
            }
            com.tencent.mm.ui.statusbar.a.d(view, i, z);
            AppMethodBeat.o(8005);
        } else if (this.iJp <= 0 || com.tencent.mm.compatible.util.d.fP(21)) {
            AppMethodBeat.o(8005);
        } else {
            getWindow().setStatusBarColor(0);
            if (this.uwU == null) {
                this.uwU = new View(this);
                ((ViewGroup) findViewById(16908290)).addView(this.uwU, new LayoutParams(-1, this.iJp));
            } else {
                LayoutParams layoutParams = this.uwU.getLayoutParams();
                if (layoutParams.height != this.iJp) {
                    layoutParams.height = this.iJp;
                    this.uwU.setLayoutParams(layoutParams);
                }
            }
            this.uwU.setBackgroundColor(i);
            AppMethodBeat.o(8005);
        }
    }

    public final String dae() {
        AppMethodBeat.i(8006);
        String str;
        if (this.handler == null) {
            str = this.uxf;
            AppMethodBeat.o(8006);
            return str;
        } else if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            if (this.pzf == null) {
                str = "";
                AppMethodBeat.o(8006);
                return str;
            }
            str = this.pzf.getUrl();
            AppMethodBeat.o(8006);
            return str;
        } else if (bo.isNullOrNil(this.uxf)) {
            this.uxf = (String) new bj<String>("") {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(7810);
                    if (WebViewUI.this.pzf == null) {
                        String str = "";
                        AppMethodBeat.o(7810);
                        return str;
                    }
                    Object url = WebViewUI.this.pzf.getUrl();
                    AppMethodBeat.o(7810);
                    return url;
                }
            }.b(this.handler);
            str = this.uxf;
            AppMethodBeat.o(8006);
            return str;
        } else {
            str = this.uxf;
            AppMethodBeat.o(8006);
            return str;
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(8008);
        ab.v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!(this.uwO == null || this.uwO.uxW)) {
            this.uwO.daU();
        }
        AppMethodBeat.o(8008);
    }

    public final void daf() {
        AppMethodBeat.i(138973);
        com.tencent.mm.pluginsdk.model.v.a.fH(this);
        AppMethodBeat.o(138973);
    }

    public void aBS() {
        AppMethodBeat.i(8010);
        if (VERSION.SDK_INT <= 10) {
            super.aBS();
            AppMethodBeat.o(8010);
        } else if (getForceOrientation() == -1) {
            this.ylk = getSharedPreferences(ah.doA(), 4).getBoolean("settings_landscape_mode", false);
            if (this.ylk) {
                setRequestedOrientation(-1);
                AppMethodBeat.o(8010);
                return;
            }
            setRequestedOrientation(1);
            AppMethodBeat.o(8010);
        } else {
            setRequestedOrientation(getForceOrientation());
            AppMethodBeat.o(8010);
        }
    }

    public int getForceOrientation() {
        return this.screenOrientation;
    }

    private View dag() {
        int identifier;
        AppMethodBeat.i(8011);
        View view = null;
        try {
            identifier = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", e);
            identifier = -1;
        }
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        ab.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", Integer.valueOf(identifier), view);
        AppMethodBeat.o(8011);
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(8012);
        super.onConfigurationChanged(configuration);
        if (this.jQp != configuration.orientation) {
            View dag = dag();
            if (dag == null) {
                dag = null;
            } else {
                dag = (View) dag.getParent();
            }
            if (dag == null) {
                AppMethodBeat.o(8012);
                return;
            }
            dag.dispatchConfigurationChanged(configuration);
            dag.requestLayout();
            this.jQp = configuration.orientation;
        }
        AppMethodBeat.o(8012);
    }

    public void onStart() {
        AppMethodBeat.i(8013);
        super.onStart();
        ab.i("MicroMsg.WebViewUI", "edw onStart");
        AppMethodBeat.o(8013);
    }

    public void onStop() {
        AppMethodBeat.i(8014);
        ab.i("MicroMsg.WebViewUI", "edw onStop");
        X(true, true);
        super.onStop();
        AppMethodBeat.o(8014);
    }

    private void Jr(int i) {
        AppMethodBeat.i(8015);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.icy.a(5, bundle, hashCode());
            AppMethodBeat.o(8015);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.o(8015);
        }
    }

    private void Js(int i) {
        AppMethodBeat.i(8016);
        try {
            if (this.icy != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.icy.a(6, bundle, hashCode());
            }
            AppMethodBeat.o(8016);
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.o(8016);
        }
    }

    public void onDestroy() {
        Bundle bundle;
        AppMethodBeat.i(8017);
        ab.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        super.onDestroy();
        com.tencent.mm.plugin.webview.modeltools.c.cYw();
        String dae = dae();
        if (dae != null) {
            String string = getSharedPreferences("webview_url_prefs", 4).getString("url", null);
            if (string != null && dae.equals(string)) {
                Editor edit = getSharedPreferences("webview_url_prefs", 4).edit();
                edit.remove("url");
                edit.apply();
            }
        } else {
            ab.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
        }
        this.uie.dbc();
        if (!this.uwB) {
            try {
                if (this.icy != null) {
                    this.icy.Jc(hashCode());
                    this.icy.IP(hashCode());
                }
                ab.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(e)));
            }
        }
        if (this.uvh != null) {
            this.uvh.disable();
        }
        this.uwA = true;
        uwz--;
        int hashCode = hashCode();
        for (int size = uvK.size() - 1; size >= 0; size--) {
            if (((z) uvK.get(size)).id == hashCode) {
                uvK.remove(size);
                break;
            }
        }
        l("", bo.anT(), 0);
        com.tencent.mm.plugin.webview.modelcache.p cYp = com.tencent.mm.plugin.webview.modelcache.p.a.uob;
        cYp.uoa.put(hashCode(), Boolean.FALSE);
        com.tencent.mm.plugin.webview.model.aq.i cYb = this.ulI.cYb();
        cYb.une = new Object[]{this.cOG, Integer.valueOf(2)};
        cYb.b(this.icy);
        this.ulI.b(this.icy);
        aq aqVar = this.ulI;
        aqVar.umM = null;
        aqVar.umK = null;
        aqVar.umL = null;
        aqVar.umJ = null;
        aqVar.umO = null;
        aqVar.umP = null;
        aqVar.umQ = null;
        aqVar.umR = null;
        if (aqVar.umW != null) {
            aqVar.umW.mqu = null;
            aqVar.umW = null;
        }
        IB("onDestroy");
        this.uwa.clear();
        com.tencent.mm.plugin.webview.model.b bVar = this.uwF;
        if (!(bVar.ulH == null || bVar.ulH.oAl.getLooper() == null)) {
            bVar.ulH.oAl.getLooper().quit();
        }
        bVar.ulH = null;
        an anVar = this.uwP;
        anVar.umD.clear();
        anVar.umE.clear();
        anVar.umF.clear();
        anVar.umB.clear();
        anVar.umC.clear();
        if (this.uxm != null) {
            this.uxm.dismiss();
            this.uxm = null;
        }
        if (this.uxj != null) {
            this.uxj.dismiss();
            this.uxj = null;
        }
        if (this.uwf != null) {
            this.uwf.dismiss();
            this.uwf = null;
        }
        if (this.uvi != null) {
            this.uvi.setOnTextSendListener(null);
        }
        if (this.uvS.daP()) {
            Js(com.tencent.view.d.MIC_PTU_MEISHI);
        }
        if (this.uvT.daP()) {
            Js(673);
        }
        if (this.uvU.daP()) {
            Js(666);
        }
        this.uwb.clear();
        this.uwI.onDestroy();
        this.uwR.dead();
        this.uvV.dead();
        if (com.tencent.xweb.c.jx(ah.getContext()) != null) {
            ab.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
        }
        if (das()) {
            try {
                if (this.icy != null) {
                    bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.icy.a(30, bundle, hashCode());
                }
            } catch (Exception e2) {
            }
        }
        ab.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", Boolean.valueOf(this.uvp));
        if (this.uvp) {
            try {
                bundle = getIntent().getBundleExtra("mm_report_bundle");
                if (bo.isNullOrNil(bundle.getString("mm_event_class"))) {
                    ab.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                } else if (this.icy != null) {
                    bundle.putLong("key_activity_browse_time", dyi());
                    this.icy.g(250, bundle);
                }
            } catch (Exception e3) {
                ab.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e3.toString());
            }
        }
        try {
            if (this.icy != null) {
                bundle = new Bundle();
                bundle.putLong("key_activity_browse_time", dyi());
                this.icy.g(251, bundle);
            }
        } catch (Exception e32) {
            ab.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e32.toString());
        }
        try {
            if (this.icy != null) {
                bundle = this.icy.g(19, null);
                if (bundle != null) {
                    ab.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(uwz));
                    if (bundle.getBoolean("webview_video_proxy_init") && uwz <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.icy.g(75, null);
                    }
                }
            }
        } catch (Exception e322) {
            ab.e("MicroMsg.WebViewUI", "deinit video player failed : %s", e322.getMessage());
        }
        if (this.ktl != null) {
            try {
                unbindService(this.ktl);
            } catch (Exception e3222) {
                ab.printErrStackTrace("MicroMsg.WebViewUI", e3222, "unbindService", new Object[0]);
            }
        }
        boolean a = com.tencent.mm.plugin.webview.modeltools.k.a(this.uhz, this.pzf);
        if (this.uhz != null) {
            this.uhz.detach();
        }
        this.uvJ.clear();
        if (this.uic != null) {
            d dVar = this.uic;
            ab.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            dVar.context = null;
            dVar.urJ = null;
            dVar.urK.clear();
            dVar.urL.clear();
        }
        if (this.uvY != null) {
            this.uvY.detach();
        }
        this.pzf.removeJavascriptInterface("MicroMsg");
        this.pzf.removeJavascriptInterface("JsApi");
        this.pzf.removeJavascriptInterface("__wx");
        try {
            this.pzf.setWebChromeClient(null);
            this.pzf.setWebViewClient(null);
            this.pzf.setOnTouchListener(null);
            this.pzf.setOnLongClickListener(null);
            this.pzf.setVisibility(8);
            this.pzf.removeAllViews();
            this.pzf.clearView();
        } catch (Exception e32222) {
            ab.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", e32222.getMessage());
        }
        this.uwG.cYP();
        if (this.icz != null) {
            k kVar = this.icz;
            ab.i("MicroMsg.WebViewPermission", "detach");
            kVar.ulm.clear();
            kVar.ulm = null;
            this.icz = null;
        }
        try {
            this.uwX.release();
        } catch (Exception e322222) {
            ab.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e322222.getMessage());
        }
        if (!a) {
            try {
                this.pzf.destroy();
            } catch (Exception e3222222) {
                ab.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", e3222222.getMessage());
            }
        }
        try {
            if (this.mController.contentView instanceof ViewGroup) {
                ((ViewGroup) this.mController.contentView).removeAllViews();
            }
        } catch (Throwable th) {
            ab.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", th);
        }
        WebViewClipBoardHelper webViewClipBoardHelper = this.uwK;
        try {
            webViewClipBoardHelper.upx.removePrimaryClipChangedListener(webViewClipBoardHelper);
            webViewClipBoardHelper.upx = null;
        } catch (Exception e4) {
        }
        com.tencent.mm.plugin.webview.b bVar2 = this.uwL;
        if (bVar2.tipDialog != null && bVar2.tipDialog.isShowing()) {
            bVar2.tipDialog.dismiss();
            bVar2.tipDialog = null;
        }
        this.pzf = null;
        if (this.uwJ != null) {
            this.uwJ = null;
            FactoryProxyManager.getPlayManager().setUtilsObject(null);
        }
        System.gc();
        if (this.uvc != null) {
            this.uvc.removeAllViews();
            this.uvc = null;
        }
        AppMethodBeat.o(8017);
    }

    private void dah() {
        AppMethodBeat.i(8018);
        try {
            this.uwX.release();
            this.pzf.stopLoading();
            this.uvG = false;
            this.pzf.removeAllViews();
            this.pzf.clearView();
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.uhz != null) {
            this.uhz.detach();
        }
        try {
            this.pzf.destroy();
        } catch (Exception e2) {
            ab.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", e2.getMessage());
        }
        this.pzf = null;
        finish();
        ab.dot();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(8018);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(8019);
        if (i != 82 || this.uwW) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.o(8019);
            return onKeyUp;
        }
        AppMethodBeat.o(8019);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(8020);
        ab.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", Integer.valueOf(i));
        com.tencent.mm.plugin.webview.model.aq.i cYb;
        if (i == 4 && this.pzf != null && this.pzf.hasEnteredFullscreen()) {
            this.pzf.leaveFullscreen();
            AppMethodBeat.o(8020);
            return true;
        } else if (i != 4 || this.uvN == null || this.uvM == null || this.uvO == null) {
            if (i == 4) {
                boolean z;
                if (this.uvi == null || !this.uvi.isShown()) {
                    z = false;
                } else {
                    this.uvi.hide();
                    dau();
                    z = true;
                }
                if (z) {
                    AppMethodBeat.o(8020);
                    return true;
                }
            }
            if (i == 4) {
                if (this.pzf != null && this.pzf.canGoBack() && this.uvn) {
                    dai();
                    cYb = this.ulI.cYb();
                    cYb.une = new Object[]{this.cOG, Integer.valueOf(1)};
                    cYb.b(this.icy);
                    AppMethodBeat.o(8020);
                    return true;
                }
                m.uuj.close();
            }
            if (i == 4 && daB() && cWG()) {
                AppMethodBeat.o(8020);
                return true;
            } else if (i == 4 && this.uie.Jx(22)) {
                AppMethodBeat.o(8020);
                return true;
            } else {
                if (i == 4) {
                    daD();
                }
                boolean onKeyDown = super.onKeyDown(i, keyEvent);
                AppMethodBeat.o(8020);
                return onKeyDown;
            }
        } else {
            try {
                this.uvO.onHideCustomView();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
            }
            cYb = this.ulI.cYb();
            cYb.une = new Object[]{this.cOG, Integer.valueOf(1)};
            cYb.b(this.icy);
            AppMethodBeat.o(8020);
            return true;
        }
    }

    /* Access modifiers changed, original: protected */
    public void dai() {
        AppMethodBeat.i(8021);
        this.uvo = System.currentTimeMillis();
        this.pzf.goBack();
        this.uvC = null;
        if (this.uvZ) {
            this.uvZ = false;
        }
        m mVar = m.uuj;
        ab.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", mVar.qTK);
        if (!bo.isNullOrNil(mVar.qTK)) {
            mVar.kT(5);
        }
        AppMethodBeat.o(8021);
    }

    /* Access modifiers changed, original: protected */
    public void dE(String str, int i) {
        AppMethodBeat.i(8022);
        if (this.uvi == null) {
            AppMethodBeat.o(8022);
            return;
        }
        WebViewInputFooter webViewInputFooter = this.uvi;
        webViewInputFooter.setVisibility(0);
        if (webViewInputFooter.uKu != null) {
            webViewInputFooter.uKu.setVisibility(0);
        }
        if (webViewInputFooter.uKt != null) {
            webViewInputFooter.uKt.setEnabled(true);
            webViewInputFooter.uKt.setBackgroundResource(R.drawable.b77);
        }
        if (webViewInputFooter.uKq != null) {
            webViewInputFooter.uKq.setVisibility(0);
        }
        webViewInputFooter.uKv = false;
        if (webViewInputFooter.uKt != null) {
            webViewInputFooter.uKt.setFocusable(true);
            webViewInputFooter.uKt.setFocusableInTouchMode(true);
            webViewInputFooter.uKt.requestFocus();
        }
        if (webViewInputFooter.crP != null) {
            webViewInputFooter.crP.showVKB();
        }
        webViewInputFooter.state = 0;
        if (!bo.isNullOrNil(str)) {
            this.uvi.setText(str);
        }
        if (i >= 0) {
            this.uvi.setMaxCount(i);
        }
        AppMethodBeat.o(8022);
    }

    /* Access modifiers changed, original: protected */
    public int cWF() {
        AppMethodBeat.i(8023);
        if (this.uvi == null) {
            AppMethodBeat.o(8023);
            return 0;
        }
        int dcZ = this.uvi.dcZ();
        AppMethodBeat.o(8023);
        return dcZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void daj() {
        AppMethodBeat.i(8024);
        this.uwX.utS = new com.tencent.mm.plugin.webview.ui.tools.l.a() {
            public final void cZV() {
                AppMethodBeat.i(7812);
                ab.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
                if (WebViewUI.this.uhz != null) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.uhz;
                    if (dVar.ready) {
                        ab.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                        al.d(new AnonymousClass57(com.tencent.mm.plugin.webview.ui.tools.jsapi.d.agr(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onPullDownRefresh", null, dVar.uFv, dVar.uFw))));
                    } else {
                        ab.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
                        AppMethodBeat.o(7812);
                        return;
                    }
                }
                AppMethodBeat.o(7812);
            }
        };
        l lVar = this.uwX;
        lVar.hfA = true;
        if (lVar.utU != null) {
            lVar.utU.setVisibility(0);
            lVar.utU.setMMOverScrollOffsetListener(lVar);
            lVar.utU.setFastScrollBack(true);
            lVar.utU.nM(false);
            lVar.utU.setReleaseTargetHeight(lVar.utV);
        }
        if (lVar.utT != null) {
            lVar.utT.setWillNotDraw(true);
            lVar.utT.setImageResource(l.utW);
            lVar.utT.setVisibility(0);
            lVar.utT.setAlpha(0.0f);
            lVar.utT.setWillNotDraw(false);
            lVar.utT.invalidate();
        }
        if (lVar.uue != null) {
            lVar.uue.setVisibility(8);
        }
        AppMethodBeat.o(8024);
    }

    /* Access modifiers changed, original: protected */
    public void cZH() {
        AppMethodBeat.i(8025);
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.mController.contentView == null) {
            this.pzf.setBackgroundColor(getResources().getColor(R.color.y));
            AppMethodBeat.o(8025);
            return;
        }
        setBackGroundColorResource(intExtra);
        this.mController.contentView.setBackgroundResource(intExtra);
        this.pzf.setBackgroundResource(17170445);
        findViewById(R.id.bhl).setBackgroundResource(17170445);
        AppMethodBeat.o(8025);
    }

    /* Access modifiers changed, original: protected */
    public void dak() {
        AppMethodBeat.i(8026);
        if (getIntent() == null) {
            AppMethodBeat.o(8026);
            return;
        }
        if (getIntent().hasExtra("show_full_screen")) {
            W(getIntent().getBooleanExtra("show_full_screen", false), true);
        }
        AppMethodBeat.o(8026);
    }

    /* Access modifiers changed, original: protected|final */
    public final void W(boolean z, boolean z2) {
        AppMethodBeat.i(8027);
        this.uvf = z;
        MarginLayoutParams marginLayoutParams;
        if (z) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            if (this.uwT != null) {
                marginLayoutParams = (MarginLayoutParams) this.uwT.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                this.uwT.setLayoutParams(marginLayoutParams);
            }
            if (this.uwl) {
                com.tencent.mm.ui.statusbar.a.D(this.uwT, true);
            } else if (this.uwU != null) {
                this.uwU.setVisibility(8);
            }
            getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    AppMethodBeat.i(7814);
                    if ((i & 4) == 0 && WebViewUI.this.uvf) {
                        WebViewUI.eq(decorView);
                    }
                    AppMethodBeat.o(7814);
                }
            });
            af(decorView, 5894);
            if (z2) {
                this.uve.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(7815);
                        WebViewUI.this.cZM();
                        AppMethodBeat.o(7815);
                    }
                });
                this.uve.setVisibility(0);
                AppMethodBeat.o(8027);
                return;
            }
            this.uve.setVisibility(8);
            AppMethodBeat.o(8027);
            return;
        }
        this.uve.setVisibility(8);
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ep(getWindow().getDecorView());
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            if (this.uwT != null) {
                marginLayoutParams = (MarginLayoutParams) this.uwT.getLayoutParams();
                marginLayoutParams.topMargin = daa();
                this.uwT.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.uwl) {
            com.tencent.mm.ui.statusbar.a.D(this.uwT, false);
            AppMethodBeat.o(8027);
            return;
        }
        if (this.uwU != null) {
            this.uwU.setVisibility(0);
        }
        AppMethodBeat.o(8027);
    }

    private static void af(View view, int i) {
        AppMethodBeat.i(8028);
        if (view == null) {
            AppMethodBeat.o(8028);
            return;
        }
        view.setSystemUiVisibility(view.getSystemUiVisibility() | i);
        AppMethodBeat.o(8028);
    }

    private static void ep(View view) {
        AppMethodBeat.i(8029);
        if (view == null) {
            AppMethodBeat.o(8029);
            return;
        }
        view.setSystemUiVisibility(view.getSystemUiVisibility() & -5895);
        AppMethodBeat.o(8029);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(8030);
        super.onWindowFocusChanged(z);
        if (z && this.uvf) {
            af(getWindow().getDecorView(), 5894);
        }
        AppMethodBeat.at(this, z);
        AppMethodBeat.o(8030);
    }

    public void initView() {
        String str;
        AppMethodBeat.i(8031);
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.uvy = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.uvu = getIntent().getBooleanExtra("is_favorite_item", false);
        this.rpm = getIntent().getBooleanExtra("isWebwx", true);
        this.uvs = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.uwk = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.uvw = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.uwg = LayoutInflater.from(this.mController.ylL).inflate(R.layout.az6, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.uwi = bo.nullAsNil(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            addTextOptionMenu(1, getString(R.string.e75), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(7816);
                    try {
                        WebViewUI.this.loadUrl(WebViewUI.this.icy.afp(null));
                    } catch (RemoteException e) {
                        ab.printErrStackTrace("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", e.getMessage());
                    }
                    AppMethodBeat.o(7816);
                    return false;
                }
            });
        }
        this.uuY = (ProgressBar) findViewById(R.id.c7h);
        this.uwh = findViewById(R.id.bhp);
        this.uwh.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7817);
                WebViewUI.this.as(WebViewUI.this.uvC, true);
                com.tencent.mm.plugin.webview.model.aq.i cYb = WebViewUI.this.ulI.cYb();
                cYb.une = new Object[]{WebViewUI.this.cOG, Integer.valueOf(4)};
                cYb.b(WebViewUI.this.icy);
                AppMethodBeat.o(7817);
            }
        });
        if (this.rpm) {
            CharSequence nullAsNil = bo.nullAsNil(getIntent().getStringExtra("title"));
            if (nullAsNil.length() > 0) {
                this.uuW = true;
            }
            M(nullAsNil);
        } else {
            setMMTitle("");
        }
        nP(false);
        nQ(false);
        if (uvQ == RenderPriority.NORMAL) {
            ab.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.pzf.getSettings().setRenderPriority(RenderPriority.HIGH);
            uvQ = RenderPriority.HIGH;
        }
        l lVar = this.uwX;
        View view = this.mController.contentView;
        lVar.utU = (LogoWebViewWrapper) view.findViewById(R.id.bhn);
        lVar.utT = (ImageView) view.findViewById(R.id.c_6);
        lVar.uud = view.findViewById(R.id.c_5);
        if (lVar.uud != null) {
            lVar.uue = lVar.uud.findViewById(R.id.fkd);
            lVar.uuf = (TextView) lVar.uue.findViewById(R.id.fke);
        }
        lVar.utV = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(lVar.utU.getContext(), 72.0f);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        if (lVar.utT == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(lVar.utT.getId());
        }
        objArr[0] = str;
        if (lVar.utU == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(lVar.utU.getId());
        }
        objArr[1] = str;
        ab.d(str2, str3, objArr);
        ab.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", Integer.valueOf(lVar.utV));
        lVar = this.uwX;
        MMWebView mMWebView = this.pzf;
        mMWebView.setCompetitorView(lVar.utU);
        mMWebView.dKJ();
        if (VERSION.SDK_INT <= 10) {
            lVar.utU.getWebViewContainer().setBackgroundColor(lVar.utU.getResources().getColor(R.color.a5v));
        }
        LogoWebViewWrapper logoWebViewWrapper = lVar.utU;
        logoWebViewWrapper.getWebViewContainer();
        if (logoWebViewWrapper.uro != null) {
            logoWebViewWrapper.ejN = mMWebView;
            logoWebViewWrapper.uro.addView(logoWebViewWrapper.ejN);
        }
        str2 = "";
        if (mMWebView.isXWalkKernel() || mMWebView.getIsX5Kernel()) {
            lVar.uug = true;
        } else {
            lVar.uug = false;
        }
        if (!(lVar.uue == null || mMWebView.getIsX5Kernel())) {
            ((ImageView) lVar.uue.findViewById(R.id.fkf)).setVisibility(8);
            ((TextView) lVar.uue.findViewById(R.id.fkg)).setText(str2);
        }
        if (!lVar.uug || lVar.uuh) {
            lVar.nM(true);
        } else {
            lVar.nM(false);
            if (lVar.uue != null) {
                lVar.uue.setVisibility(0);
            }
        }
        cZH();
        this.uvc = (FrameLayout) findViewById(R.id.bhm);
        this.uvd = (FrameLayout) findViewById(R.id.nc);
        ab.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pzf.getIsX5Kernel());
        this.pzf.setWebViewClientExtension(new c(this));
        if (this.pzf.getIsX5Kernel()) {
            this.pzf.setWebViewCallbackClient(this.uwQ);
            l lVar2 = this.uwX;
            AnonymousClass11 anonymousClass11 = new com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a() {
                public final void cZy() {
                    AppMethodBeat.i(7818);
                    if (WebViewUI.this.pzf.getIsX5Kernel()) {
                        com.tencent.mm.plugin.webview.model.aq.i cYb = WebViewUI.this.ulI.cYb();
                        cYb.une = new Object[]{WebViewUI.this.cOG, Integer.valueOf(10)};
                        cYb.b(WebViewUI.this.icy);
                    }
                    AppMethodBeat.o(7818);
                }
            };
            if (lVar2.utU != null) {
                lVar2.utU.setMMOverScrollListener(anonymousClass11);
            }
        }
        this.uvi = (WebViewInputFooter) findViewById(R.id.c7j);
        if (this.uvi != null) {
            this.uvi.hide();
            this.uvi.setOnTextSendListener(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c() {
                public final void aee(String str) {
                    AppMethodBeat.i(7826);
                    WebViewUI.a(WebViewUI.this, str);
                    AppMethodBeat.o(7826);
                }
            });
            this.uvi.setOnSmileyChosenListener(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a() {
                public final boolean EH(String str) {
                    AppMethodBeat.i(7827);
                    if (WebViewUI.this.uhz != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.uhz;
                        HashMap hashMap = new HashMap();
                        hashMap.put("smiley", str);
                        al.d(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass22(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onGetSmiley", hashMap, dVar.uFv, dVar.uFw)));
                    }
                    AppMethodBeat.o(7827);
                    return true;
                }
            });
            this.uvi.setOnSmileyPanelVisibilityChangedListener(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b() {
                public final void cWT() {
                    AppMethodBeat.i(7828);
                    WebViewUI.a(WebViewUI.this, 0);
                    AppMethodBeat.o(7828);
                }

                public final void cWU() {
                    AppMethodBeat.i(7829);
                    WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) WebViewUI.this.findViewById(R.id.bhl);
                    if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.getKeyBoardHeight() > 0) {
                        WebViewUI.a(WebViewUI.this, webViewKeyboardLinearLayout.getKeyBoardHeight());
                    }
                    AppMethodBeat.o(7829);
                }
            });
        }
        this.uvj = (WebViewSearchContentInputFooter) findViewById(R.id.c7k);
        if (this.uvj != null) {
            this.uvj.setActionDelegate(new com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a() {
                public final void cWV() {
                    AppMethodBeat.i(7830);
                    WebViewUI.b(WebViewUI.this, 0);
                    WebViewUI.this.pzf.clearMatches();
                    WebViewUI.this.uvj.dcX();
                    AppMethodBeat.o(7830);
                }

                public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                    AppMethodBeat.i(7831);
                    if (webViewSearchContentInputFooter.getVisibility() == 0) {
                        b(webViewSearchContentInputFooter);
                    }
                    AppMethodBeat.o(7831);
                }

                public final void cWW() {
                    AppMethodBeat.i(7832);
                    com.tencent.mm.plugin.report.service.h.pYm.a(480, 5, 1, false);
                    WebViewUI.this.pzf.findNext(false);
                    AppMethodBeat.o(7832);
                }

                public final void cWX() {
                    AppMethodBeat.i(7833);
                    com.tencent.mm.plugin.report.service.h.pYm.a(480, 4, 1, false);
                    WebViewUI.this.pzf.findNext(true);
                    AppMethodBeat.o(7833);
                }

                public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                    AppMethodBeat.i(7834);
                    WebViewUI.this.pzf.clearMatches();
                    webViewSearchContentInputFooter.reset();
                    WebViewUI.this.uvj.t(0, 0, true);
                    WebViewUI.this.uvk = false;
                    WebViewUI.this.pzf.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
                    AppMethodBeat.o(7834);
                }

                public final boolean c(int i, KeyEvent keyEvent) {
                    AppMethodBeat.i(7835);
                    if (i == 67 && keyEvent.getAction() == 0) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(480, 6, 1, false);
                    }
                    AppMethodBeat.o(7835);
                    return false;
                }
            });
            this.pzf.setFindListener(new FindListener() {
                public final void onFindResultReceived(int i, int i2, boolean z) {
                    AppMethodBeat.i(7836);
                    if (!(!z || WebViewUI.this.uvk || bo.isNullOrNil(WebViewUI.this.uvj.getSearchContent()))) {
                        if (i2 == 0) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(480, 3, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.h.pYm.a(480, 2, 1, false);
                        }
                        WebViewUI.this.uvk = true;
                    }
                    WebViewUI.this.uvj.t(i, i2, z);
                    AppMethodBeat.o(7836);
                }
            });
        }
        this.uve = (MovingImageButton) findViewById(R.id.c7l);
        this.uvH = findViewById(R.id.fjw);
        if (this.uvH != null) {
            this.uvH.setVisibility(8);
        }
        if (!booleanExtra) {
            this.pzf.setVerticalScrollBarEnabled(false);
        }
        this.pzf.setWebChromeClient(dal());
        this.pzf.setWebViewClient(aXZ());
        this.pzf.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i = 1;
                AppMethodBeat.i(7837);
                ab.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
                int intExtra = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
                if (!bo.isNullOrNil(WebViewUI.this.getIntent().getStringExtra("key_function_id"))) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14596, WebViewUI.this.getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(0));
                }
                if (intExtra == 1) {
                    ab.e("MicroMsg.WebViewUI", "not allow download file : %s", str);
                    AppMethodBeat.o(7837);
                    return;
                }
                if (str4 != null && str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                    ab.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", str);
                    g.a(WebViewUI.this.icy, 11154, str);
                }
                if (WebViewUI.this.icz == null || WebViewUI.this.icz.cZS() == null) {
                    ab.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
                    AppMethodBeat.o(7837);
                    return;
                }
                if (str4 != null) {
                    ab.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", Boolean.valueOf(WebViewUI.f(WebViewUI.this)));
                    String afR = WebViewUI.afR(str3);
                    intExtra = (afR == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", afR)) ? 0 : 1;
                    boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.a.uFa.contains(str4.toLowerCase());
                    if (!r3 || (intExtra == 0 && !contains)) {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (i != 0 || WebViewUI.this.icz.cZS().jB(24) || WebViewUI.this.uvW) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addFlags(268435456);
                    try {
                        WebViewUI.this.startActivity(intent);
                        AppMethodBeat.o(7837);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
                        AppMethodBeat.o(7837);
                        return;
                    }
                }
                ab.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
                AppMethodBeat.o(7837);
            }
        });
        this.pzf.requestFocus(130);
        this.pzf.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(7839);
                if (WebViewUI.this.uvb != null && WebViewUI.this.uvb.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, R.anim.b_);
                    loadAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(7838);
                            WebViewUI.this.uvb.setVisibility(8);
                            AppMethodBeat.o(7838);
                        }
                    });
                    WebViewUI.this.uvb.startAnimation(loadAnimation);
                    WebViewUI.this.uvb.setVisibility(8);
                }
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                        }
                        if (motionEvent.getAction() == 0) {
                            WebViewUI.this.jLX = (int) motionEvent.getRawX();
                            WebViewUI.this.jLY = (int) motionEvent.getRawY();
                            break;
                        }
                        break;
                }
                if (WebViewUI.this.pzf == null) {
                    AppMethodBeat.o(7839);
                } else {
                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW || motionEvent.getAction() == com.tencent.mm.plugin.appbrand.jsapi.j.a.CTRL_INDEX) {
                        if (motionEvent.getPointerCount() > 1) {
                            WebViewUI.this.pzf.getSettings().setBuiltInZoomControls(true);
                            WebViewUI.this.pzf.getSettings().setSupportZoom(true);
                        } else {
                            WebViewUI.this.pzf.getSettings().setBuiltInZoomControls(false);
                            WebViewUI.this.pzf.getSettings().setSupportZoom(false);
                        }
                    }
                    AppMethodBeat.o(7839);
                }
                return false;
            }
        });
        this.pzf.getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.u.bh(this, this.pzf.getSettings().getUserAgentString()));
        this.pzf.dKH();
        this.icA = new com.tencent.mm.ui.tools.j(this.mController.ylL);
        this.icA.a(this.pzf, this, null);
        this.icA.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(7840);
                if (!(WebViewUI.this.uwH.icE == null || WebViewUI.this.icy == null)) {
                    try {
                        WebViewUI.this.icy.afo(WebViewUI.this.uwH.icE.upr);
                        WebViewUI.this.uwH.icE.cYK();
                        AppMethodBeat.o(7840);
                        return;
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewUI", "cancel capture failed");
                    }
                }
                AppMethodBeat.o(7840);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7841);
                WebViewUI.this.aqX();
                WebViewUI.this.daC();
                ab.i("MicroMsg.WebViewUI", "on back btn press");
                AppMethodBeat.o(7841);
                return true;
            }
        }, dam());
        if (dan()) {
            final WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(R.id.bhl);
            webViewKeyboardLinearLayout.setOnkbdStateListener(new com.tencent.mm.ui.KeyboardLinearLayout.a() {
                public final void sD(int i) {
                    AppMethodBeat.i(7857);
                    ab.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(i)));
                    WebViewUI.a(WebViewUI.this, webViewKeyboardLinearLayout, i);
                    if (i == -3) {
                        WebViewUI.this.ulI.cXX().unt = 1;
                        final int keyBoardHeight = webViewKeyboardLinearLayout.getKeyBoardHeight();
                        if (keyBoardHeight > 0) {
                            WebViewUI.b(WebViewUI.this, keyBoardHeight);
                            WebViewUI.a(WebViewUI.this, keyBoardHeight);
                        }
                        if (WebViewUI.this.pzf.getIsX5Kernel() || VERSION.SDK_INT >= 19) {
                            WebViewUI.this.handler.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(7856);
                                    if (WebViewUI.this.uhz != null) {
                                        WebViewUI.this.uhz.JM(keyBoardHeight);
                                    }
                                    AppMethodBeat.o(7856);
                                }
                            });
                        }
                        if (WebViewUI.m(WebViewUI.this)) {
                            WebViewUI.this.uvi.dda();
                        }
                    } else {
                        WebViewUI.b(WebViewUI.this, 0);
                        WebViewUI.a(WebViewUI.this, 0);
                    }
                    WebViewUI.this.Ju(i);
                    WebViewUI.this.jYe = i;
                    AppMethodBeat.o(7857);
                }
            });
        }
        this.uuX = (MMFalseProgressBar) findViewById(R.id.bhq);
        super.setTitleBarDoubleClickListener(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7842);
                WebViewUI.h(WebViewUI.this);
                AppMethodBeat.o(7842);
            }
        });
        AppMethodBeat.o(8031);
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.xweb.s aXZ() {
        AppMethodBeat.i(8032);
        h hVar = new h();
        AppMethodBeat.o(8032);
        return hVar;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized com.tencent.xweb.l dal() {
        com.tencent.xweb.l lVar;
        AppMethodBeat.i(8033);
        if (this.uvO == null) {
            this.uvO = new g();
        }
        lVar = this.uvO;
        AppMethodBeat.o(8033);
        return lVar;
    }

    /* Access modifiers changed, original: protected */
    public int dam() {
        AppMethodBeat.i(8034);
        if (aXL()) {
            AppMethodBeat.o(8034);
            return 0;
        }
        AppMethodBeat.o(8034);
        return R.raw.actionbar_icon_dark_close;
    }

    /* Access modifiers changed, original: protected */
    public boolean aXL() {
        return this.uwp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Jt(int i) {
        AppMethodBeat.i(8035);
        Drawable mutate = getResources().getDrawable(R.raw.actionbar_icon_dark_close).mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        x(mutate);
        AppMethodBeat.o(8035);
    }

    /* Access modifiers changed, original: protected */
    public boolean dan() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(8036);
        super.onActivityResult(i, i2, intent);
        if (this.icH.b(this, i, i2, intent)) {
            AppMethodBeat.o(8036);
        } else if (com.tencent.mm.plugin.webview.modeltools.a.d(this, i, i2, intent)) {
            AppMethodBeat.o(8036);
        } else {
            if (i == 777) {
                Bundle bundle = null;
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle == null || !bundle.getString("go_next", "").equals("gdpr_confirm_continue")) {
                    ab.i("MicroMsg.WebViewUI", "gdpr continue:false");
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("go_next", "gdpr_confirm_logout");
                    intent2.putExtra("result_data", bundle2);
                    this.uwA = true;
                    m.uuj.close();
                    setResult(-1, intent2);
                    finish();
                } else {
                    ab.i("MicroMsg.WebViewUI", "gdpr continue:true");
                    AppMethodBeat.o(8036);
                    return;
                }
            }
            AppMethodBeat.o(8036);
        }
    }

    public void onSwipeBack() {
        AppMethodBeat.i(8037);
        if (this.pzf != null) {
            if (this.uwY) {
                this.pzf.setOnLongClickListener(this.uwZ);
            } else {
                this.pzf.setOnLongClickListener(null);
            }
        }
        aqX();
        super.onSwipeBack();
        AppMethodBeat.o(8037);
    }

    public void onCancel() {
        AppMethodBeat.i(8038);
        if (this.pzf != null) {
            if (this.uwY) {
                this.pzf.setOnLongClickListener(this.uwZ);
            } else {
                this.pzf.setOnLongClickListener(null);
            }
        }
        super.onCancel();
        AppMethodBeat.o(8038);
    }

    public void onDrag() {
        AppMethodBeat.i(8039);
        if (this.pzf != null) {
            this.pzf.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        super.onDrag();
        AppMethodBeat.o(8039);
    }

    public final boolean apx() {
        String url;
        AppMethodBeat.i(8040);
        this.uwC = true;
        com.tencent.mm.plugin.webview.model.aq.i cYb = this.ulI.cYb();
        Object[] objArr = new Object[2];
        if (this.pzf != null) {
            url = this.pzf.getUrl();
        } else {
            url = this.cOG;
        }
        objArr[0] = url;
        objArr[1] = Integer.valueOf(15);
        cYb.une = objArr;
        cYb.b(this.icy);
        boolean apx = super.apx();
        AppMethodBeat.o(8040);
        return apx;
    }

    private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar, String str) {
        AppMethodBeat.i(8041);
        if (bo.isNullOrNil(str) || bVar == null) {
            AppMethodBeat.o(8041);
            return false;
        }
        boolean afS = bVar.afS(str);
        AppMethodBeat.o(8041);
        return afS;
    }

    /* Access modifiers changed, original: protected */
    public void aMh() {
        String afk;
        boolean z;
        int cZr;
        Map hashMap;
        AppMethodBeat.i(8042);
        this.uwE.aI("onPostBindedStart", System.currentTimeMillis());
        ab.i("MicroMsg.WebViewUI", "edw postBinded");
        this.uie.a(new com.tencent.mm.plugin.webview.ui.tools.bag.p(this.icy));
        daA();
        com.tencent.mm.plugin.webview.model.b bVar = this.uwF;
        com.tencent.mm.plugin.webview.stub.d dVar = this.icy;
        try {
            afk = dVar.afk("DNSAdvanceOpen");
            ab.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", afk);
            if (bo.isNullOrNil(afk)) {
                ab.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = afk.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    afk = dVar.afk("DNSAdvanceRelateDomain");
                    if (bo.isNullOrNil(afk)) {
                        ab.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        bVar.aNS().aa(new com.tencent.mm.plugin.webview.model.b.AnonymousClass1(afk, dVar));
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                ab.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        if (aYd() && aYa()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(7848);
                    WebViewUI.this.pzf.getCurWebviewClient().b(WebViewUI.this.pzf, WebViewUI.this.pzf.getUrl());
                    AppMethodBeat.o(7848);
                }
            });
        }
        this.uwE.aI("onJSAPIStart", System.currentTimeMillis());
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        bundleExtra.putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        ab.i("MicroMsg.WebViewUI", "KDownloadRestrict = %d, KFunctionID = %s", Integer.valueOf(bundleExtra.getInt("key_download_restrict", 0)), bundleExtra.getString("key_function_id", ""));
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle.putInt("screen_orientation", this.screenOrientation);
        try {
            this.icy.a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            ab.e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra2 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra3 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra4 = getIntent().getStringExtra("KPublisherId");
        String stringExtra5 = getIntent().getStringExtra("KAppId");
        String stringExtra6 = getIntent().getStringExtra("pre_username");
        String stringExtra7 = getIntent().getStringExtra("expid_str");
        String string = bundleExtra.getString("key_snsad_statextstr");
        afk = null;
        if (this.pzf != null) {
            afk = this.pzf.getTitle();
        }
        if (bo.isNullOrNil(afk)) {
            afk = getIntent().getStringExtra("title");
        }
        if (bo.isNullOrNil(afk)) {
            afk = getIntent().getStringExtra("webpageTitle");
        }
        com.tencent.mm.plugin.webview.model.aq.l cXX = this.ulI.cXX();
        cXX.username = stringExtra;
        cXX.uns = intExtra;
        cXX.cOG = this.cOG;
        cXX.uno = intExtra2;
        cXX.scene = afH(stringExtra);
        cXX.unn = longExtra;
        cXX.unp = new com.tencent.mm.a.p(longExtra).toString();
        cXX.unl = stringExtra2;
        cXX.unm = stringExtra3;
        cXX.fjS = stringExtra4;
        cXX.appId = stringExtra5;
        cXX.unq = stringExtra6;
        cXX.unr = this.unr;
        cXX.rjC = string;
        cXX.title = bo.bc(afk, "");
        cXX.dJE = stringExtra7;
        com.tencent.mm.plugin.webview.model.aq.a cXY = this.ulI.cXY();
        cXY.fjS = stringExtra4;
        cXY.scene = afH(stringExtra);
        this.ulI.cYa().cOG = this.cOG;
        if (das()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.icy.a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!bo.isNullOrNil(stringExtra2)) {
            try {
                this.icy.afl(stringExtra2);
            } catch (Exception e5) {
                ab.e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                ab.i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
            } else {
                cZr = this.icy.cZr();
                if (cZr != -1) {
                    ab.i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", Integer.valueOf(cZr));
                    getIntent().putExtra("pay_channel", cZr);
                }
            }
        } catch (Exception e6) {
            ab.e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.uvJ.clear();
        this.uhz = aXY();
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = this.uhz;
        stringExtra = getIntent().getStringExtra("geta8key_username");
        if (!bo.isNullOrNil(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (bo.isNullOrNil(stringExtra)) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            hashMap.put("srcUsername", stringExtra);
        }
        hashMap.put("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0)));
        hashMap.put("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0)));
        hashMap.put("scene", Integer.valueOf(afH(stringExtra)));
        hashMap.put("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0)));
        hashMap.put("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0)));
        hashMap.put("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0)));
        if (!bo.isNullOrNil(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        int intExtra3 = getIntent().getIntExtra("pay_scene", -1);
        if (intExtra3 != -1) {
            ab.i("MicroMsg.WebViewUI", "get pay scene from extra: %s", Integer.valueOf(intExtra3));
        } else {
            intExtra3 = 3;
            ab.i("MicroMsg.WebViewUI", "default pay scene to: %s", Integer.valueOf(3));
        }
        hashMap.put("pay_scene", Integer.valueOf(intExtra3));
        dVar2.uFt = hashMap;
        if (dap() != null) {
            dap().uaz = this.uhz;
        }
        this.pzf.addJavascriptInterface(this.uhz, "__wx");
        this.uvJ.add(this.uhz);
        this.uvJ.add(new s(this, (byte) 0));
        this.uvJ.add(new p(this, (byte) 0));
        this.uvJ.add(new e(this, (byte) 0));
        this.uvJ.add(new r(this, (byte) 0));
        this.uvJ.add(new u(this, (byte) 0));
        this.uvJ.add(new a(this, (byte) 0));
        this.uvJ.add(new y(this, (byte) 0));
        this.uvJ.add(new t(this, (byte) 0));
        this.uvJ.add(new i(this, (byte) 0));
        this.uvJ.add(new b(this, (byte) 0));
        this.uvJ.add(new c(this, (byte) 0));
        this.uvJ.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.pzf, this.uhz));
        this.uvJ.add(new x(this, (byte) 0));
        this.uvJ.add(new v(this, (byte) 0));
        this.uvJ.add(new n(this, (byte) 0));
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.uvJ.add(new k(this, (byte) 0));
        }
        this.uvJ.add(new f(this, (byte) 0));
        try {
            cZr = bo.getInt(this.icy.afk("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            ab.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            cZr = 0;
        }
        ab.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", Integer.valueOf(cZr), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false)));
        if (cZr == 1 || r1) {
            this.uwX.nM(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.uwX.nM(true);
        }
        try {
            this.uvX = bo.getInt(this.icy.afk("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            ab.w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        ab.i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", Integer.valueOf(this.uvX));
        this.uwE.aI("onJSAPIEnd", System.currentTimeMillis());
        aq.V(this.pzf.getIsX5Kernel(), bo.nullAsNil(this.cOG).startsWith("https://"));
        if (this.pzf.getIsX5Kernel()) {
            com.tencent.mm.pluginsdk.ui.tools.m.kT(7);
            com.tencent.mm.plugin.report.service.h.pYm.a(64, 64, 1, 0, 1, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.h.pYm.a(64, 0, 1, false);
        }
        this.uvY = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this.pzf, this.icy, this.uhz, new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a() {
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0148  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x014b  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7  */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x014d  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0148  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x014b  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb  */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x014d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void aYk() {
                int i;
                String url;
                GeneralControlWrapper cZT;
                boolean z;
                int i2 = 2;
                int i3 = 0;
                AppMethodBeat.i(7849);
                try {
                    if (WebViewUI.this.icy.cZd()) {
                        if (WebViewUI.this.dax() || WebViewUI.this.day()) {
                            i = WebViewUI.i(WebViewUI.this);
                            if (i > 0 && i <= 4) {
                                i2 = i;
                            }
                            WebViewUI.c(WebViewUI.this, i2);
                            WebViewUI.this.X(true, true);
                            if (!(WebViewUI.this.pzf == null || WebViewUI.this.icz == null || WebViewUI.this.uhz == null)) {
                                url = WebViewUI.this.pzf.getUrl();
                                if (!bo.isNullOrNil(url) && WebViewUI.this.uwy.add(url)) {
                                    cZT = WebViewUI.this.icz.cZT();
                                    z = (cZT.vxG & 512) > 0;
                                    ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
                                    if (z) {
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.uhz;
                                        ab.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", Boolean.valueOf(dVar.ready));
                                        if (dVar.uFo != null && dVar.ready) {
                                            dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:get_all_hosts", new HashMap(), dVar.uFv, dVar.uFw) + ")", null);
                                        }
                                    }
                                    z = (cZT.vxG & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0;
                                    ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
                                    if (z) {
                                        WebViewUI.this.uhz.ob(false);
                                        AppMethodBeat.o(7849);
                                        return;
                                    }
                                    an anVar = WebViewUI.this.uwP;
                                    if (!bo.isNullOrNil(url)) {
                                        url = Uri.parse(url).getHost();
                                        if (!bo.isNullOrNil(url)) {
                                            i3 = anVar.umF.remove(url);
                                        }
                                    }
                                    if (i3 != 0) {
                                        WebViewUI.this.uhz.ob(true);
                                    }
                                }
                            }
                            AppMethodBeat.o(7849);
                            return;
                        }
                        if (bo.isNullOrNil(WebViewUI.this.cOG) || !com.tencent.mm.plugin.webview.a.uet.matcher(WebViewUI.this.cOG).matches()) {
                            i = WebViewUI.this.icy.gw(16384, 2);
                        } else {
                            i = WebViewUI.this.icy.gw(16388, 2);
                        }
                        i2 = i;
                        WebViewUI.c(WebViewUI.this, i2);
                        WebViewUI.this.X(true, true);
                        url = WebViewUI.this.pzf.getUrl();
                        cZT = WebViewUI.this.icz.cZT();
                        if ((cZT.vxG & 512) > 0) {
                        }
                        ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
                        if (z) {
                        }
                        if ((cZT.vxG & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                        }
                        ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
                        if (z) {
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
                }
                i = 2;
                i2 = i;
                WebViewUI.c(WebViewUI.this, i2);
                WebViewUI.this.X(true, true);
                url = WebViewUI.this.pzf.getUrl();
                cZT = WebViewUI.this.icz.cZT();
                if ((cZT.vxG & 512) > 0) {
                }
                ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
                if (z) {
                }
                if ((cZT.vxG & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                }
                ab.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
                if (z) {
                }
            }
        }, getIntent().getBooleanExtra("key_load_js_without_delay", false), aYd());
        try {
            cZr = bo.getInt(this.icy.afk("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            ab.w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            cZr = 0;
        }
        ab.i("MicroMsg.WebViewUI", "js digest verification config = %d", Integer.valueOf(cZr));
        if (cZr == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && aYb()) {
            this.uhz.dch();
            this.uwP.aey(this.uhz.uFw);
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            nO(false);
            ab.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", Long.valueOf(System.currentTimeMillis()));
        } else {
            nO(getIntent().getBooleanExtra("showShare", true));
            ab.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z));
        }
        this.uvb = LayoutInflater.from(this).inflate(R.layout.b72, null);
        FontChooserView fontChooserView = (FontChooserView) this.uvb.findViewById(R.id.fjt);
        View findViewById = this.uvb.findViewById(R.id.fju);
        if (!this.pzf.getIsX5Kernel()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(7876);
                    Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, R.anim.b_);
                    loadAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(7875);
                            WebViewUI.this.uvb.setVisibility(8);
                            AppMethodBeat.o(7875);
                        }
                    });
                    WebViewUI.this.uvb.startAnimation(loadAnimation);
                    WebViewUI.this.uvb.setVisibility(8);
                    AppMethodBeat.o(7876);
                }
            });
        }
        fontChooserView.setOnChangeListener(new j(this, (byte) 0));
        this.uvb.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.uvc.addView(this.uvb);
        this.uvb.setVisibility(8);
        cZr = 2;
        try {
            if (this.icy.cZd()) {
                cZr = (dax() || day()) ? daz() : (bo.isNullOrNil(this.cOG) || !com.tencent.mm.plugin.webview.a.uet.matcher(this.cOG).matches()) ? this.icy.gw(16384, 0) : this.icy.gw(16388, 0);
            }
        } catch (Exception e7) {
            ab.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (cZr <= 0 || cZr > 4) {
            cZr = 2;
        }
        Jv(cZr);
        Jw(cZr);
        try {
            this.icy.a(this.cOG, true, null);
        } catch (Exception e52222) {
            ab.w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar2 : this.uvJ) {
            if (a(bVar2, this.cOG)) {
                ab.i("MicroMsg.WebViewUI", "initView, url handled, result = " + bVar2.afM(this.cOG) + ", url = " + this.cOG);
                AppMethodBeat.o(8042);
                return;
            }
        }
        if (cZA()) {
            ab.w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            AppMethodBeat.o(8042);
            return;
        }
        String stringExtra8 = getIntent().getStringExtra("data");
        if (stringExtra8 != null) {
            ab.i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.icy.afg(stringExtra8);
                } catch (Exception e522222) {
                    ab.w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.pzf.setOnLongClickListener(this.uwZ);
            this.uwY = true;
            this.pzf.getSettings().setUseWideViewPort(false);
            this.pzf.getSettings().setLoadWithOverviewMode(false);
            if (afQ(null)) {
                this.pzf.getSettings().setJavaScriptEnabled(false);
                this.pzf.loadDataWithBaseURL(null, stringExtra8, "text/html", ProtocolPackage.ServerEncoding, null);
                ab.i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = ".concat(String.valueOf(stringExtra8)));
            } else {
                ab.f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
                dah();
                AppMethodBeat.o(8042);
                return;
            }
        }
        if (bo.isNullOrNil(this.cOG)) {
            jD(false);
        }
        if (this.cOG == null || this.cOG.length() == 0) {
            ab.e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            AppMethodBeat.o(8042);
            return;
        }
        Uri parse = Uri.parse(this.cOG);
        if (parse == null) {
            ab.e("MicroMsg.WebViewUI", "initView uri is null");
            AppMethodBeat.o(8042);
            return;
        }
        if (parse.getScheme() == null) {
            this.cOG = "http://" + this.cOG;
        } else if (!parse.getScheme().startsWith("http")) {
            ab.i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (!afQ(this.cOG)) {
                ab.f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.cOG);
                dah();
                AppMethodBeat.o(8042);
                return;
            } else if (aYd()) {
                ab.i("MicroMsg.WebViewUI", "webview ispreloaded , do not reload url");
                AppMethodBeat.o(8042);
                return;
            } else {
                b(this.cOG, null, false);
                AppMethodBeat.o(8042);
                return;
            }
        }
        this.uvR = new l(this.cOG);
        try {
            bundleExtra = this.icy.g(100000, null);
            if (!(bundleExtra == null || bundleExtra.getString("force_geta8key_host_path") == null)) {
                this.uxa = bundleExtra.getString("force_geta8key_host_path").split(";");
                this.uvR.uxa = this.uxa;
            }
        } catch (Exception e5222222) {
            ab.e("MicroMsg.WebViewUI", "get force geta8key paths failed : %s", e5222222.getMessage());
        }
        if (this.uvs || this.icz.has(this.cOG)) {
            ab.i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.uvs);
            if (!afQ(this.cOG)) {
                ab.f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.cOG);
                dah();
                AppMethodBeat.o(8042);
                return;
            } else if (afI(this.cOG)) {
                this.uwn = true;
                this.uuX.finish();
                this.uuX.setVisibility(8);
                b(this.cOG, null, true);
            } else {
                b(this.cOG, null, false);
            }
        } else {
            if (afI(this.cOG)) {
                b(this.cOG, null, true);
                this.uxf = this.cOG;
                this.uwn = true;
                this.uuX.finish();
                this.uuX.setVisibility(8);
            }
            if (this.uwA || this.uwB || isFinishing()) {
                AppMethodBeat.o(8042);
                return;
            }
            ab.i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            as(this.cOG, false);
            ab.i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.cOG);
        }
        this.uwE.aI("onPostBindedEnd", System.currentTimeMillis());
        AppMethodBeat.o(8042);
    }

    /* Access modifiers changed, original: protected */
    public boolean afI(String str) {
        AppMethodBeat.i(8043);
        hashCode();
        boolean aeI = com.tencent.mm.plugin.webview.modelcache.p.aeI(str);
        AppMethodBeat.o(8043);
        return aeI;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(138974);
        b(str, null, false);
        AppMethodBeat.o(138974);
    }

    /* Access modifiers changed, original: protected */
    public void b(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.i(8045);
        if (z) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Cache-Control", "no-cache");
            if (this.pzf != null) {
                this.pzf.loadUrl(str, hashMap);
            }
            AppMethodBeat.o(8045);
            return;
        }
        if (this.pzf != null) {
            if (map != null) {
                this.pzf.loadUrl(str, map);
                AppMethodBeat.o(8045);
                return;
            }
            this.pzf.loadUrl(str);
        }
        AppMethodBeat.o(8045);
    }

    /* Access modifiers changed, original: protected|final */
    public final l dao() {
        return this.uwX;
    }

    public final boolean needShowIdcError() {
        return false;
    }

    private boolean cZs() {
        boolean z = false;
        AppMethodBeat.i(8046);
        try {
            if (this.icy == null) {
                ab.w("MicroMsg.WebViewUI", "invoker is null");
                AppMethodBeat.o(8046);
                return z;
            }
            z = this.icy.cZs();
            AppMethodBeat.o(8046);
            return z;
        } catch (RemoteException e) {
            ab.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
        }
    }

    private static String afJ(String str) {
        String str2 = null;
        AppMethodBeat.i(8047);
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
                AppMethodBeat.o(8047);
                return str2;
            }
            AppMethodBeat.o(8047);
            return str2;
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
            AppMethodBeat.o(8047);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(8048);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.uwH.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.o(8048);
    }

    public final String cWL() {
        String str = null;
        AppMethodBeat.i(8049);
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", e.getMessage());
            if (e instanceof ClassNotFoundException) {
                finish();
                AppMethodBeat.o(8049);
                return str;
            }
        }
        if (str == null || str.length() <= 0) {
            Uri data = getIntent().getData();
            if (data == null) {
                str = "";
                AppMethodBeat.o(8049);
                return str;
            }
            str = data.toString();
            AppMethodBeat.o(8049);
            return str;
        }
        AppMethodBeat.o(8049);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d aXY() {
        AppMethodBeat.i(8050);
        MMWebView mMWebView = this.pzf;
        k kVar = this.icz;
        HashMap hashMap = new HashMap();
        hashMap.put("webview_type", "1");
        hashMap.put("init_url", this.cOG);
        hashMap.put("init_font_size", "1");
        hashMap.put("short_url", bo.nullAsNil(getIntent().getStringExtra("shortUrl")));
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(mMWebView, kVar, hashMap, this.icy, hashCode());
        AppMethodBeat.o(8050);
        return dVar;
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.websearch.api.ah dap() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public boolean aYa() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean aYd() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void daq() {
    }

    public final void cZR() {
        AppMethodBeat.i(8051);
        this.uwI.cZR();
        AppMethodBeat.o(8051);
    }

    /* Access modifiers changed, original: protected */
    public void cZM() {
        AppMethodBeat.i(8052);
        this.uwI.cZM();
        AppMethodBeat.o(8052);
    }

    /* Access modifiers changed, original: protected */
    public void aYe() {
        AppMethodBeat.i(8053);
        if (this.pzf != null) {
            this.pzf.reload();
        }
        AppMethodBeat.o(8053);
    }

    public final void cZO() {
        AppMethodBeat.i(8054);
        this.uwI.cZO();
        AppMethodBeat.o(8054);
    }

    public final void afG(String str) {
        AppMethodBeat.i(8055);
        this.uwI.afG(str);
        AppMethodBeat.o(8055);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:7:0x0029, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r1) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final LinkedList<com.tencent.mm.m.d.a> dar() {
        LinkedList<com.tencent.mm.m.d.a> linkedList = null;
        AppMethodBeat.i(8056);
        if (this.pzf == null) {
            ab.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            AppMethodBeat.o(8056);
        } else {
            String url;
            String str = this.cOG;
            if (this.pzf != null) {
                url = this.pzf.getUrl();
            }
            url = str;
            if (url == null) {
                AppMethodBeat.o(8056);
            } else {
                try {
                    URL url2 = new URL(url);
                    Pattern compile = Pattern.compile(".*(\\.wanggou\\.com|\\.jd\\.com)");
                    CharSequence host = url2.getHost();
                    if (bo.isNullOrNil(host)) {
                        AppMethodBeat.o(8056);
                    } else {
                        if (!host.startsWith(".")) {
                            host = ".".concat(String.valueOf(host));
                        }
                        ab.d("MicroMsg.WebViewUI", "host = %s", host);
                        if (compile.matcher(host).matches()) {
                            if (this.uwt == null) {
                                boolean z;
                                long currentTimeMillis = System.currentTimeMillis();
                                this.uwt = this.icy.cZi();
                                String str2 = "MicroMsg.WebViewUI";
                                String str3 = "[hakon] getConfigListMap %b, cost %d";
                                Object[] objArr = new Object[2];
                                if (this.uwt != null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                ab.d(str2, str3, objArr);
                            }
                            if (this.uwt != null && this.uwt.size() > 0) {
                                linkedList = com.tencent.mm.m.d.g(this.uwt);
                                AppMethodBeat.o(8056);
                            }
                        }
                        AppMethodBeat.o(8056);
                    }
                } catch (Exception e) {
                    ab.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", e.getMessage());
                }
            }
        }
        return linkedList;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean das() {
        AppMethodBeat.i(8057);
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        if (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) {
            AppMethodBeat.o(8057);
            return false;
        }
        AppMethodBeat.o(8057);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(String str, Drawable drawable) {
        AppMethodBeat.i(8058);
        final boolean das = das();
        final String stringExtra = getIntent().getStringExtra("srcUsername");
        a(0, str, drawable, (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7851);
                if (das) {
                    WebViewUI.this.afK(stringExtra);
                } else {
                    WebViewUI.this.cZM();
                }
                AppMethodBeat.o(7851);
                return true;
            }
        });
        AppMethodBeat.o(8058);
    }

    /* Access modifiers changed, original: protected */
    public void nO(boolean z) {
        AppMethodBeat.i(8059);
        this.uwW = z;
        if (this.pzf == null) {
            ab.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            AppMethodBeat.o(8059);
            return;
        }
        enableOptionMenu(z);
        showOptionMenu(z);
        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
        if (booleanExtra) {
            showOptionMenu(booleanExtra);
        }
        int dat = dat();
        if (dar() != null) {
            dat = R.raw.mm_title_btn_jd;
        }
        ab.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", Boolean.valueOf(getIntent().getBooleanExtra("KRightBtn", false)), Boolean.valueOf(getIntent().getBooleanExtra("KShowFixToolsBtn", false)));
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            if (r4) {
                addIconOptionMenu(1, R.raw.fix_tools_entry, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(7852);
                        Intent intent = new Intent();
                        intent.setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
                        intent.putExtra("entry_fix_tools", 1);
                        WebViewUI.this.startActivity(intent);
                        AppMethodBeat.o(7852);
                        return true;
                    }
                });
            }
            a(dat, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(7853);
                    WebViewUI.this.cZM();
                    AppMethodBeat.o(7853);
                    return true;
                }
            }, this.uxc);
        }
        if (z) {
            booleanExtra = false;
        } else {
            booleanExtra = true;
        }
        nR(booleanExtra);
        AppMethodBeat.o(8059);
    }

    public final void showOptionMenu(boolean z) {
        AppMethodBeat.i(8060);
        if (getIntent().getBooleanExtra("hide_option_menu", false)) {
            super.showOptionMenu(false);
            AppMethodBeat.o(8060);
            return;
        }
        super.showOptionMenu(z);
        AppMethodBeat.o(8060);
    }

    public final void showOptionMenu(int i, boolean z) {
        AppMethodBeat.i(8061);
        if (getIntent().getBooleanExtra("hide_option_menu", false)) {
            super.showOptionMenu(i, false);
            AppMethodBeat.o(8061);
            return;
        }
        super.showOptionMenu(i, z);
        AppMethodBeat.o(8061);
    }

    /* Access modifiers changed, original: protected|final */
    public final int dat() {
        AppMethodBeat.i(8063);
        int i = R.drawable.uu;
        if (dar() != null) {
            i = R.raw.mm_title_btn_jd;
        }
        AppMethodBeat.o(8063);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Ju(int i) {
        AppMethodBeat.i(8064);
        if (i != -3) {
            AppMethodBeat.o(8064);
        } else if (this.uvH == null) {
            AppMethodBeat.o(8064);
        } else {
            boolean z = (this.icz.cZT().vxG & 1) > 0;
            ab.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(z)));
            if (z) {
                if (this.uvH.getVisibility() == 0 || this.uvj.isShown()) {
                    AppMethodBeat.o(8064);
                    return;
                }
                if (this.uvI == null) {
                    this.uvI = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(7860);
                            WebViewUI.o(WebViewUI.this);
                            AppMethodBeat.o(7860);
                            return false;
                        }
                    }, false);
                }
                this.uvI.ae(4000, 4000);
                View view = this.uvH;
                ((ImageView) view.findViewById(R.id.cpi)).setImageResource(R.raw.net_warn_icon);
                TextView textView = (TextView) view.findViewById(R.id.cpj);
                textView.setTextSize(14.0f);
                textView.setText(R.string.g1y);
                ((ImageButton) view.findViewById(R.id.cpk)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(7861);
                        WebViewUI.o(WebViewUI.this);
                        AppMethodBeat.o(7861);
                    }
                });
                this.uvH.setVisibility(0);
                com.tencent.mm.plugin.report.service.h.pYm.X(13125, cWL());
            }
            AppMethodBeat.o(8064);
        }
    }

    private void dau() {
        AppMethodBeat.i(8065);
        if (this.uvH != null) {
            this.uvH.setVisibility(8);
        }
        if (this.uvI != null) {
            this.uvI.stopTimer();
        }
        AppMethodBeat.o(8065);
    }

    /* Access modifiers changed, original: protected|final */
    public final void afK(String str) {
        AppMethodBeat.i(8066);
        this.uhz.bJ(Scopes.PROFILE, true);
        this.uhz.ago(str);
        AppMethodBeat.o(8066);
    }

    public final void clH() {
        AppMethodBeat.i(8067);
        this.uhz.bJ("sendAppMessage", true);
        this.uhz.q(this.uwI.cZP());
        this.ulI.aeG("mm_send_friend_count");
        AppMethodBeat.o(8067);
    }

    /* Access modifiers changed, original: protected|final */
    public final void nP(boolean z) {
        AppMethodBeat.i(8068);
        if (findViewById(R.id.bhr) == null) {
            AppMethodBeat.o(8068);
            return;
        }
        boolean z2;
        if (findViewById(R.id.bhr).getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            findViewById(R.id.bhr).startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, z ? R.anim.n : R.anim.o));
        }
        if (z) {
            findViewById(R.id.bhr).setVisibility(0);
            this.uuZ = (ImageButton) findViewById(R.id.bhs);
            ImageButton imageButton = this.uuZ;
            z2 = this.pzf != null && this.pzf.canGoBack();
            imageButton.setEnabled(z2);
            this.uuZ.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(7862);
                    if (WebViewUI.this.pzf != null) {
                        WebViewUI.this.uvo = System.currentTimeMillis();
                        WebViewUI.this.pzf.goBack();
                        WebViewUI.this.uvC = null;
                    }
                    AppMethodBeat.o(7862);
                }
            });
            this.uva = (ImageButton) findViewById(R.id.bht);
            this.uva.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(7863);
                    if (WebViewUI.this.pzf != null) {
                        WebViewUI.this.pzf.reload();
                    }
                    AppMethodBeat.o(7863);
                }
            });
            AppMethodBeat.o(8068);
            return;
        }
        findViewById(R.id.bhr).setVisibility(8);
        AppMethodBeat.o(8068);
    }

    private void nQ(boolean z) {
        AppMethodBeat.i(8069);
        if (this.uva != null) {
            this.uva.setEnabled(z);
        }
        AppMethodBeat.o(8069);
    }

    /* Access modifiers changed, original: protected|final */
    public final void X(boolean z, boolean z2) {
        AppMethodBeat.i(8070);
        enableOptionMenu(z);
        ab.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", Boolean.valueOf(z));
        setProgressBarIndeterminateVisibility(false);
        if (z2) {
            this.uuX.finish();
            this.uwI.cZJ();
            AppMethodBeat.o(8070);
            return;
        }
        if (!(this.uwn || this.uwp)) {
            this.uuX.start();
        }
        AppMethodBeat.o(8070);
    }

    /* Access modifiers changed, original: protected */
    public void afL(String str) {
        AppMethodBeat.i(8071);
        if (this.icz.cZT().dmk()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.icy.a(str, this.icz.cZS().jB(7), bundle)) {
                ab.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(8071);
            return;
        }
        ab.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
        AppMethodBeat.o(8071);
    }

    /* Access modifiers changed, original: protected */
    public boolean afM(String str) {
        AppMethodBeat.i(8072);
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.uvJ) {
            if (a(bVar, str)) {
                ab.i("MicroMsg.WebViewUI", "url handled, url = ".concat(String.valueOf(str)));
                if (this.uxd.equals(str)) {
                    ab.i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    AppMethodBeat.o(8072);
                    return true;
                }
                ab.i("MicroMsg.WebViewUI", "url handled, ret = " + bVar.afM(str) + ", url = " + str);
                AppMethodBeat.o(8072);
                return true;
            }
        }
        AppMethodBeat.o(8072);
        return false;
    }

    public final String afN(String str) {
        AppMethodBeat.i(8073);
        String str2 = "";
        if (!(TextUtils.isEmpty(str) || this.icy == null)) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_binder_id", hashCode());
            bundle.putString("rawUrl", str);
            try {
                str2 = bo.nullAsNil(this.icy.g(76, bundle).getString("appId"));
                ab.i("MicroMsg.WebViewUI", "stev cachedAppId %s", str2);
            } catch (RemoteException e) {
                ab.w("MicroMsg.WebViewUI", "get cachedAppId error ", e.getMessage());
            }
        }
        AppMethodBeat.o(8073);
        return str2;
    }

    public final void l(String str, long j, int i) {
        AppMethodBeat.i(8074);
        final String str2 = str;
        final long j2 = j;
        final int i2 = i;
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(7864);
                Looper.myQueue().removeIdleHandler(this);
                WebViewUI.this.m(str2, j2, i2);
                AppMethodBeat.o(7864);
                return false;
            }
        });
        AppMethodBeat.o(8074);
    }

    private boolean dav() {
        AppMethodBeat.i(8076);
        if (System.currentTimeMillis() - this.uvo < 300) {
            AppMethodBeat.o(8076);
            return true;
        }
        AppMethodBeat.o(8076);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public w as(String str, boolean z) {
        AppMethodBeat.i(8077);
        w j = j(str, z, -1);
        AppMethodBeat.o(8077);
        return j;
    }

    private w j(String str, boolean z, int i) {
        AppMethodBeat.i(8078);
        w wVar;
        if (this.uwA || this.uwB || isFinishing()) {
            wVar = w.FAILED;
            AppMethodBeat.o(8078);
            return wVar;
        }
        int i2 = -1;
        if (this.uvo > 0) {
            if (dav()) {
                i2 = 4;
            }
            this.uvo = 0;
        }
        if (this.uwh != null) {
            this.uwh.setVisibility(8);
        }
        if (this.icz == null) {
            ab.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            wVar = w.FAILED;
            AppMethodBeat.o(8078);
            return wVar;
        } else if (this.uvs) {
            ab.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.icz.a(str, null, null);
            wVar = w.NO_NEED;
            AppMethodBeat.o(8078);
            return wVar;
        } else {
            Object obj = (this.icy != null && this.uwo.contains(str) && afI(str)) ? 1 : null;
            if ((this.icz.has(str) || obj != null) && !z) {
                ab.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(str)));
                this.uvW = this.icz.cZS().jB(24);
                wVar = w.NO_NEED;
                AppMethodBeat.o(8078);
                return wVar;
            }
            int ael;
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int afH = afH(stringExtra);
            if (i == -1) {
                ael = this.uvR.ael(str);
            } else {
                ael = i;
            }
            ab.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, subScene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", str, Integer.valueOf(afH), Integer.valueOf(i2), stringExtra, Integer.valueOf(ael), Boolean.valueOf(z), getIntent().getStringExtra("key_function_id"), Integer.valueOf(getIntent().getIntExtra("key_wallet_region", 0)));
            if (i != 5) {
                X(true, false);
            }
            this.uwo.add(str);
            this.icz.a(str, null, null);
            this.uvW = this.icz.cZS().jB(24);
            if (!(ael == 5 || ael == 1)) {
                this.uwq = true;
            }
            this.uvS.daN();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", stringExtra);
            bundle.putInt("geta8key_data_scene", afH);
            bundle.putInt("geta8key_data_subscene", i2);
            bundle.putInt("geta8key_data_reason", ael);
            if (this.pzf.getIsX5Kernel()) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", aq.cXS());
            bundle.putInt("geta8key_session_id", this.uvB);
            if (!bo.isNullOrNil(getIntent().getStringExtra("k_share_url"))) {
                bundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
                getIntent().putExtra("k_share_url", "");
            }
            bundle.putInt("key_wallet_region", r5);
            bundle.putString("key_function_id", r4);
            bundle.putInt("webview_binder_id", hashCode());
            bundle.putByteArray("k_a8key_cookie", this.uvD);
            bundle.putString("geta8key_data_appid", getIntent().getStringExtra("geta8key_open_webview_appid"));
            this.uvC = str;
            boolean z2 = false;
            try {
                z2 = this.icy.s(com.tencent.view.d.MIC_PTU_MEISHI, bundle);
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
            }
            ab.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = ".concat(String.valueOf(z2)));
            com.tencent.mm.plugin.webview.model.aq.m cXU = this.ulI.cXU();
            ael = this.cSQ;
            stringExtra = this.cMm;
            cXU.cSQ = ael;
            cXU.uni = stringExtra;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!cXU.unu.containsKey(str)) {
                cXU.unu.put(str, Long.valueOf(bo.anU()));
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(154, 11, 1, false);
            this.uwE.aI("getA8KeyStart", System.currentTimeMillis());
            wVar = w.WILL_GET;
            AppMethodBeat.o(8078);
            return wVar;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int afH(String str) {
        AppMethodBeat.i(8079);
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.icy == null) {
                intExtra = 1;
            } else {
                try {
                    if (this.icy.nI(str)) {
                        intExtra = 8;
                    } else if (this.icy.mZ(str)) {
                        intExtra = 7;
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_biz_username", str);
                        try {
                            bundle = this.icy.g(102, bundle);
                            if (bundle != null && bundle.getBoolean("is_enterprise_username")) {
                                intExtra = 51;
                            }
                        } catch (RemoteException e) {
                            ab.e("MicroMsg.WebViewUI", "invoke the check enterprise failed");
                        }
                    } else {
                        intExtra = 1;
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.WebViewUI", "getScene fail, ex = " + e2.getMessage());
                    intExtra = 1;
                }
            }
        }
        ab.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", Integer.valueOf(intExtra));
        AppMethodBeat.o(8079);
        return intExtra;
    }

    private boolean afO(String str) {
        AppMethodBeat.i(8080);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            AppMethodBeat.o(8080);
            return false;
        }
        Jr(106);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        bundle.putInt("webview_binder_id", hashCode());
        try {
            this.icy.s(106, bundle);
        } catch (Exception e) {
            ab.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        AppMethodBeat.o(8080);
        return true;
    }

    private boolean afP(String str) {
        AppMethodBeat.i(8081);
        ab.i("MicroMsg.WebViewUI", "dealCustomScheme, url = ".concat(String.valueOf(str)));
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(8081);
            return false;
        }
        try {
            if (this.icy.dq(str)) {
                ab.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(str)));
                this.icy.dB(str, hashCode());
                AppMethodBeat.o(8081);
                return true;
            }
        } catch (Exception e) {
            ab.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        final Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            String replace;
            Intent intent;
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                replace = str.replace(com.tencent.smtt.sdk.WebView.SCHEME_TEL, "");
                if (!bo.isNullOrNil(replace)) {
                    try {
                        this.icy.dD(replace, hashCode());
                    } catch (Exception e2) {
                        ab.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", e2.getMessage());
                    }
                }
                AppMethodBeat.o(8081);
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(268435456);
                try {
                    startActivity(intent);
                } catch (Exception e22) {
                    ab.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", e22.getMessage());
                }
                AppMethodBeat.o(8081);
                return true;
            } else if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_MAILTO)) {
                intent = new Intent("android.intent.action.SENDTO");
                intent.addFlags(268435456);
                intent.setData(parse);
                try {
                    startActivity(intent);
                } catch (Exception e222) {
                    ab.e("MicroMsg.WebViewUI", "start mailto app failed:[%s]", e222.getMessage());
                }
                AppMethodBeat.o(8081);
                return true;
            } else {
                try {
                    boolean z = (this.icz.cZT().vxG & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
                    ab.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(z)));
                    if (z || this.icy == null || !this.icy.cZd()) {
                        int intExtra = getIntent().getIntExtra("key_download_restrict", 0);
                        if (!bo.isNullOrNil(getIntent().getStringExtra("key_function_id"))) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14596, getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(1));
                        }
                        if (intExtra == 1) {
                            ab.e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", str);
                            AppMethodBeat.o(8081);
                            return true;
                        }
                        ab.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", Long.valueOf(bo.anT() - this.uxi));
                        if (bo.anT() - this.uxi <= 2) {
                            replace = dae();
                            try {
                                replace = com.tencent.mm.compatible.util.q.encode(replace, "UTF-8");
                                str = com.tencent.mm.compatible.util.q.encode(str, "UTF-8");
                            } catch (Exception e3) {
                                ab.i("MicroMsg.WebViewUI", "formate url failed");
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(13983, Integer.valueOf(4), replace, str);
                        }
                        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                            z = com.tencent.mm.ce.a.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(7865);
                                    WebViewUI webViewUI = WebViewUI.this;
                                    Uri uri = parse;
                                    if (webViewUI == null || uri == null) {
                                        ab.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
                                        AppMethodBeat.o(7865);
                                        return;
                                    }
                                    ab.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
                                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                                    intent.addFlags(268435456);
                                    com.tencent.mm.pluginsdk.model.app.g.a(webViewUI, intent, null, null, null);
                                    AppMethodBeat.o(7865);
                                }
                            });
                            AppMethodBeat.o(8081);
                            return z;
                        }
                        intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(268435456);
                        if (bo.k((Context) this, intent)) {
                            startActivity(intent);
                            AppMethodBeat.o(8081);
                            return true;
                        }
                    }
                    ab.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                    AppMethodBeat.o(8081);
                    return true;
                } catch (RemoteException e4) {
                    ab.printErrStackTrace("MicroMsg.WebViewUI", e4, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(8081);
        return false;
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.i(8082);
        if (!bo.isNullOrNil(str2)) {
            this.icz.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.uwo.remove(str2);
            this.uwq = false;
            this.jUg = str2;
        }
        if (hh(str, str2)) {
            this.icz.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uwo.remove(str);
            AppMethodBeat.o(8082);
        } else if (this.icy == null || bo.isNullOrNil(str) || !afI(str)) {
            AppMethodBeat.o(8082);
        } else {
            this.icz.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uwo.remove(str);
            AppMethodBeat.o(8082);
        }
    }

    /* Access modifiers changed, original: protected */
    public void daw() {
    }

    /* Access modifiers changed, original: protected */
    public void b(com.tencent.mm.plugin.webview.stub.c cVar) {
        AppMethodBeat.i(8083);
        ab.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
        if (this.pzf == null) {
            ab.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
            AppMethodBeat.o(8083);
        } else if (isFinishing() || this.icz == null) {
            ab.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
            AppMethodBeat.o(8083);
        } else {
            int i;
            int i2;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            String str = null;
            Bundle bundle = null;
            try {
                i3 = cVar.getType();
                i4 = cVar.cYW();
                i5 = cVar.cYX();
                str = cVar.adx();
                bundle = cVar.getData();
                i = i5;
                i2 = i4;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + e.getMessage());
                i = i5;
                i2 = i4;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            ab.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", Integer.valueOf(bundle.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode()));
            ab.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + i3 + ", errCode = " + i + ", errType = " + i2);
            if (bundle.getInt("scene_end_listener_hash_code") != hashCode()) {
                ab.e("MicroMsg.WebViewUI", "hash code not equal");
                AppMethodBeat.o(8083);
            } else if (i3 == com.tencent.view.d.MIC_PTU_MEISHI || i3 == 131 || i3 == 106 || i3 == 673 || i3 == 666 || i3 == 1254 || i3 == 1373) {
                String str2;
                boolean z;
                switch (i3) {
                    case 106:
                        finish();
                        AppMethodBeat.o(8083);
                        return;
                    case com.tencent.view.d.MIC_PTU_MEISHI /*233*/:
                        this.uvS.daO();
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1"));
                        this.uxn = bundle.getLong("geta8key_result_deep_link_bit_set", 0);
                        this.uwI.utF = bundle.getString("geta8key_result_menu_wording");
                        int i6 = bundle.getInt("geta8key_result_reason");
                        ab.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(i6)));
                        if (this.pzf != null) {
                            this.pzf.setA8keyReason(i6);
                        }
                        str2 = null;
                        switch (i6) {
                            case 0:
                            case 2:
                            case 8:
                            case 9:
                                if ((i2 != 0 || i != 0) && (i2 != 4 || i != -2005)) {
                                    m.uuj.Jq(i2);
                                    str = bundle.getString("geta8key_result_req_url");
                                    if (!(this.uwh == null || afI(str))) {
                                        this.uwh.setVisibility(0);
                                        X(true, true);
                                    }
                                    this.ulI.cYa().unc = false;
                                    this.ulI.cXU().bE(str, false);
                                    com.tencent.mm.plugin.report.service.h.pYm.a(154, 12, 1, false);
                                    i3 = b.Jh(i6);
                                    if (-1 != i3) {
                                        com.tencent.mm.plugin.report.service.h.pYm.a(154, (long) i3, 1, false);
                                    }
                                    G(bundle);
                                    if (this.uvy) {
                                        finish();
                                        break;
                                    }
                                }
                                str2 = bundle.getString("geta8key_result_full_url");
                                a(bundle.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                H(bundle);
                                this.uvW = jsapiPermissionWrapper.jB(24);
                                this.ulI.cYa().unc = true;
                                this.uvD = bundle.getByteArray("geta8key_result_cookie");
                                ab.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", bo.cd(this.uvD));
                                break;
                                break;
                            case 1:
                            case 5:
                                if (i2 != 0 || i != 0) {
                                    if (i2 != 4 || i != -2005) {
                                        if (i2 != 0 && i == -3300) {
                                            ab.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", Integer.valueOf(i2), Integer.valueOf(i));
                                            this.uvE = true;
                                            break;
                                        }
                                        com.tencent.mm.plugin.report.service.h.pYm.a(154, 12, 1, false);
                                        com.tencent.mm.plugin.report.service.h.pYm.a(154, (long) b.Jh(i6), 1, false);
                                        X(true, true);
                                        break;
                                    }
                                    this.pzf.stopLoading();
                                    this.uvG = false;
                                    str2 = bundle.getString("geta8key_result_full_url");
                                    a(bundle.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                    H(bundle);
                                    this.uvD = bundle.getByteArray("geta8key_result_cookie");
                                    ab.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", bo.cd(this.uvD));
                                    break;
                                }
                                str2 = bundle.getString("geta8key_result_req_url");
                                this.icz.a(str2, jsapiPermissionWrapper, generalControlWrapper);
                                this.uwo.remove(str2);
                                if (this.uww) {
                                    X(true, true);
                                    this.uww = false;
                                }
                                if (i6 != 5) {
                                    this.uvW = jsapiPermissionWrapper.jB(24);
                                }
                                this.uvD = bundle.getByteArray("geta8key_result_cookie");
                                ab.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", bo.cd(this.uvD));
                                break;
                                break;
                        }
                        Y(this.icz.aei(str2).jB(34), this.icz.aei(str2).jB(75));
                        if (i2 == 0 && i == 0) {
                            j jVar = this.uwI;
                            jVar.utK.add(Integer.valueOf(6));
                            jVar.utK.add(Integer.valueOf(1));
                            jVar.utK.add(Integer.valueOf(3));
                            jVar.utK.add(Integer.valueOf(2));
                            this.uwI.utI = true;
                            if (this.uwI.utJ) {
                                cZM();
                            }
                        } else {
                            this.uwI.utI = false;
                        }
                        this.uwE.aI("getA8KeyEnd", System.currentTimeMillis());
                        daw();
                        AppMethodBeat.o(8083);
                        return;
                    case 666:
                        q qVar = this.uvU;
                        qVar.uxP--;
                        if (qVar.uxP <= 0) {
                            WebViewUI.this.Js(666);
                        }
                        finish();
                        AppMethodBeat.o(8083);
                        return;
                    case 673:
                        o oVar = this.uvT;
                        oVar.uxO--;
                        if (oVar.uxO <= 0) {
                            WebViewUI.this.Js(673);
                        }
                        if (i2 == 0 && i == 0) {
                            str2 = bundle != null ? bundle.getString("reading_mode_result_url") : null;
                            ab.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", str2);
                            if (bo.isNullOrNil(str2)) {
                                ab.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                                AppMethodBeat.o(8083);
                                return;
                            }
                            b(str2, null, false);
                            AppMethodBeat.o(8083);
                            return;
                        }
                        ab.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                        AppMethodBeat.o(8083);
                        return;
                    case 1254:
                        z = i2 == 0 && i == 0;
                        com.tencent.mm.plugin.webview.stub.d dVar = this.icy;
                        com.tencent.mm.plugin.webview.model.af.d dVar2 = this.uxk;
                        com.tencent.mm.plugin.webview.model.af.b bVar = this.uxl;
                        int hashCode = hashCode();
                        ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", Boolean.valueOf(z));
                        dVar2.blb();
                        bVar.remove(1254);
                        long currentTimeMillis = System.currentTimeMillis();
                        String aep = bundle == null ? "" : com.tencent.mm.plugin.webview.model.af.c.aep(bundle.getString("oauth_url"));
                        ab.i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", aep);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a((Context) this, str, ah.getContext().getString(R.string.g0a), new com.tencent.mm.plugin.webview.model.af.c.AnonymousClass2(dVar2));
                            com.tencent.mm.plugin.webview.e.a aVar = com.tencent.mm.plugin.webview.e.a.uKJ;
                            if (aep == null) {
                                str = "";
                            } else {
                                str = aep;
                            }
                            com.tencent.mm.plugin.webview.e.a.a(str, currentTimeMillis, 2, 1, 0, 0, i);
                            AppMethodBeat.o(8083);
                            return;
                        } else if (bundle == null) {
                            ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                            AppMethodBeat.o(8083);
                            return;
                        } else {
                            z = bundle.getBoolean("is_recent_has_auth");
                            boolean z2 = bundle.getBoolean("is_silence_auth");
                            if (z || z2) {
                                String string = bundle.getString("redirect_url");
                                if (bo.isNullOrNil(string)) {
                                    ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                    AppMethodBeat.o(8083);
                                    return;
                                }
                                ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", Boolean.valueOf(z), Boolean.valueOf(z2), string);
                                com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, aep, new com.tencent.mm.plugin.webview.model.af.c.AnonymousClass3(dVar2, aep, currentTimeMillis, i, string));
                                AppMethodBeat.o(8083);
                                return;
                            }
                            com.tencent.mm.plugin.webview.model.af.c.AnonymousClass4 anonymousClass4 = new com.tencent.mm.plugin.webview.model.af.c.AnonymousClass4(this, aep, dVar2, currentTimeMillis, i, bundle, dVar, bVar, hashCode);
                            if ((this instanceof WebViewUI) && isFinishing()) {
                                ab.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                                AppMethodBeat.o(8083);
                                return;
                            }
                            new com.tencent.mm.plugin.webview.ui.tools.widget.n(this).a(af.aa((ArrayList) bundle.getSerializable("scope_list")), bundle.getString("appname"), bundle.getString("appicon_url"), getString(R.string.g0l), anonymousClass4);
                            AppMethodBeat.o(8083);
                            return;
                        }
                    case 1373:
                        z = i2 == 0 && i == 0;
                        com.tencent.mm.plugin.webview.model.af.d dVar3 = this.uxk;
                        com.tencent.mm.plugin.webview.model.af.b bVar2 = this.uxl;
                        ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", Boolean.valueOf(z));
                        bVar2.remove(1373);
                        if (z) {
                            if (bundle != null) {
                                str2 = bundle.getString("redirect_url");
                                if (!bo.isNullOrNil(str2)) {
                                    dVar3.aeq(str2);
                                    ab.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", str2);
                                    break;
                                }
                                ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                                AppMethodBeat.o(8083);
                                return;
                            }
                            ab.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                            AppMethodBeat.o(8083);
                            return;
                        }
                        com.tencent.mm.ui.base.h.a((Context) this, str, ah.getContext().getString(R.string.g0a), new com.tencent.mm.plugin.webview.model.af.c.AnonymousClass5(dVar3));
                        AppMethodBeat.o(8083);
                        return;
                }
                AppMethodBeat.o(8083);
            } else {
                AppMethodBeat.o(8083);
            }
        }
    }

    private void Y(boolean z, boolean z2) {
        AppMethodBeat.i(8084);
        if (z) {
            setMMSubTitle((int) R.string.g0d);
            if (!this.uvv) {
                this.uvv = true;
                AppMethodBeat.o(8084);
                return;
            }
        } else if (z2) {
            setMMSubTitle((int) R.string.g0p);
            AppMethodBeat.o(8084);
            return;
        } else {
            setMMSubTitle(null);
        }
        AppMethodBeat.o(8084);
    }

    /* Access modifiers changed, original: protected */
    public void c(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(8085);
        String bc = bo.bc(dae(), this.cOG);
        if (bo.isNullOrNil(bc)) {
            ab.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            b(str2, null, false);
            AppMethodBeat.o(8085);
        } else if (this.uhz == null) {
            if (map == null || map.size() <= 0) {
                b(str2, null, false);
                AppMethodBeat.o(8085);
                return;
            }
            b(str2, (Map) map, false);
            AppMethodBeat.o(8085);
        } else if (!bo.nullAsNil(str2).contains("#wechat_redirect") && !bo.nullAsNil(str).contains("#wechat_redirect")) {
            if (!hh(bc, str2)) {
                boolean z;
                String aeN = com.tencent.mm.plugin.webview.modelcache.q.aeN(bc);
                String aeN2 = com.tencent.mm.plugin.webview.modelcache.q.aeN(str2);
                if (bo.isNullOrNil(aeN2) || bo.isNullOrNil(aeN) || !aeN2.equals(aeN) || this.icy == null || !afI(bc)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    if (map == null || map.size() <= 0) {
                        b(str2, null, false);
                        AppMethodBeat.o(8085);
                        return;
                    }
                    b(str2, (Map) map, false);
                    AppMethodBeat.o(8085);
                    return;
                }
            }
            this.uwx.put(bc, str2);
            this.uwr.put(bc, map);
            this.uwx.put(str, str2);
            this.uwr.put(str, map);
            this.uhz.z(str2, map);
            AppMethodBeat.o(8085);
        } else if (map == null || map.size() <= 0) {
            b(str2, null, false);
            AppMethodBeat.o(8085);
        } else {
            b(str2, (Map) map, false);
            AppMethodBeat.o(8085);
        }
    }

    private boolean hh(String str, String str2) {
        AppMethodBeat.i(8086);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(8086);
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.uet.matcher(str).matches() && com.tencent.mm.plugin.webview.a.uet.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.icy != null && afI(str)) {
                AppMethodBeat.o(8086);
                return true;
            }
        }
        AppMethodBeat.o(8086);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean H(Bundle bundle) {
        String str;
        AppMethodBeat.i(8087);
        ab.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        if (getIntent().getBooleanExtra("k_has_http_header", false) && (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0)) {
            ab.i("MicroMsg.WebViewUI", "use intent httpheader info");
            getIntent().putExtra("k_has_http_header", false);
            stringArray = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
            stringArray2 = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
            getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
            getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        }
        ab.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", Integer.valueOf(i), string, string2, string3);
        HashMap hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.uws = hashMap;
        if (bo.isNullOrNil(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        aq.V(this.pzf.getIsX5Kernel(), bo.nullAsNil(str).startsWith("https://"));
        this.ulI.cXU().bE(string4, true);
        com.tencent.mm.plugin.webview.model.aq.f cXW = this.ulI.cXW();
        int i3 = this.cSQ;
        String str2 = this.cMm;
        cXW.cSQ = i3;
        cXW.uni = str2;
        if (bo.isNullOrNil(string2)) {
            ab.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            cXW.iCz = string2;
            cXW.unh = true;
            if (!cXW.unf.containsKey(string2)) {
                cXW.unf.put(string2, Long.valueOf(bo.anU()));
            }
            if (!cXW.ung.containsKey(string2)) {
                cXW.ung.put(string2, Long.valueOf(bo.anU()));
            }
        }
        boolean afP;
        switch (i) {
            case 1:
                ab.i("MicroMsg.WebViewUI", "getA8key-text: ".concat(String.valueOf(string3)));
                if (string3 == null || string3.length() == 0) {
                    ab.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    AppMethodBeat.o(8087);
                    return false;
                }
                this.pzf.getSettings().setJavaScriptEnabled(false);
                this.pzf.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                AppMethodBeat.o(8087);
                return true;
            case 2:
                ab.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    ab.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    AppMethodBeat.o(8087);
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (afQ(string2)) {
                    c(string4, string2, hashMap);
                    AppMethodBeat.o(8087);
                    return true;
                }
                ab.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                dah();
                AppMethodBeat.o(8087);
                return true;
            case 3:
                ab.i("MicroMsg.WebViewUI", "getA8key-app: ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    ab.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                    AppMethodBeat.o(8087);
                    return false;
                }
                afP = afP(string2);
                AppMethodBeat.o(8087);
                return afP;
            case 4:
                afP = afO(string2);
                AppMethodBeat.o(8087);
                return afP;
            case 6:
                ab.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    ab.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    AppMethodBeat.o(8087);
                    return false;
                } else if (afQ(string2)) {
                    b(string2, null, false);
                    nO(false);
                    AppMethodBeat.o(8087);
                    return true;
                } else {
                    ab.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    dah();
                    AppMethodBeat.o(8087);
                    return true;
                }
            case 7:
            case 30:
                ab.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    ab.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    AppMethodBeat.o(8087);
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (afQ(string2)) {
                    c(string4, string2, hashMap);
                    AppMethodBeat.o(8087);
                    return true;
                }
                ab.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                dah();
                AppMethodBeat.o(8087);
                return true;
            case 20:
                if (bo.isNullOrNil(string2)) {
                    ab.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    q qVar = this.uvU;
                    if (qVar.uxP == 0) {
                        WebViewUI.this.Jr(666);
                    }
                    qVar.uxP++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    bundle2.putInt("webview_binder_id", hashCode());
                    try {
                        this.icy.s(666, bundle2);
                    } catch (Exception e) {
                        ab.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                AppMethodBeat.o(8087);
                return true;
            default:
                ab.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(i)));
                AppMethodBeat.o(8087);
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void G(Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public boolean dax() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean day() {
        return false;
    }

    private void Jv(int i) {
        AppMethodBeat.i(8089);
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.uhz != null) {
            this.uhz.JK(i);
        }
        FontChooserView fontChooserView = (FontChooserView) this.uvb.findViewById(R.id.fjt);
        if (fontChooserView != null) {
            fontChooserView.setSliderIndex(i - 1);
        }
        AppMethodBeat.o(8089);
    }

    /* Access modifiers changed, original: protected */
    public void Jw(int i) {
        AppMethodBeat.i(8090);
        if (this.pzf == null || this.pzf.getSettings() == null) {
            AppMethodBeat.o(8090);
            return;
        }
        ab.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(i)));
        switch (i) {
            case 1:
                this.pzf.getSettings().a(com.tencent.xweb.p.a.SMALLER);
                AppMethodBeat.o(8090);
                return;
            case 3:
                this.pzf.getSettings().a(com.tencent.xweb.p.a.LARGER);
                AppMethodBeat.o(8090);
                return;
            case 4:
                this.pzf.getSettings().a(com.tencent.xweb.p.a.LARGEST);
                AppMethodBeat.o(8090);
                return;
            default:
                this.pzf.getSettings().a(com.tencent.xweb.p.a.NORMAL);
                AppMethodBeat.o(8090);
                return;
        }
    }

    private final boolean afQ(String str) {
        AppMethodBeat.i(8091);
        if (ae.giw) {
            ab.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            AppMethodBeat.o(8091);
            return true;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(8091);
            return true;
        } else if (this.uvl) {
            ab.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", str);
            AppMethodBeat.o(8091);
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("file://")) {
                for (String t : ums) {
                    if (com.tencent.mm.pluginsdk.ui.tools.u.t(toLowerCase, t)) {
                        AppMethodBeat.o(8091);
                        return true;
                    }
                }
                AppMethodBeat.o(8091);
                return false;
            }
            AppMethodBeat.o(8091);
            return true;
        }
    }

    private void daA() {
        AppMethodBeat.i(8092);
        if (this.pzf == null || this.icy == null) {
            ab.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
            AppMethodBeat.o(8092);
            return;
        }
        try {
            this.pzf.removeJavascriptInterface("searchBoxJavaBridge_");
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", e.getMessage());
        }
        if (this.uxo == null) {
            try {
                if (this.icy.cZd()) {
                    this.uxo = this.icy.cZe();
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", e2.getMessage());
            }
        }
        String str = "MicroMsg.WebViewUI";
        String str2 = "removeConfigJsInterface, to remove list size = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.uxo == null ? 0 : this.uxo.length);
        ab.i(str, str2, objArr);
        if (this.uxo == null || this.uxo.length == 0) {
            AppMethodBeat.o(8092);
            return;
        }
        try {
            for (String str3 : this.uxo) {
                ab.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", str3);
                this.pzf.removeJavascriptInterface(str3);
            }
            AppMethodBeat.o(8092);
        } catch (Exception e22) {
            ab.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", e22.getMessage());
            AppMethodBeat.o(8092);
        }
    }

    public final boolean cWG() {
        AppMethodBeat.i(8093);
        if (this.uwe == null || !this.uwe.cXi() || bo.isNullOrNil(this.uwe.daM()) || bo.isNullOrNil(this.uwe.cXk()) || bo.isNullOrNil(this.uwe.cXl())) {
            AppMethodBeat.o(8093);
            return false;
        }
        ab.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", this.uwe.daM(), this.uwe.cXk(), this.uwe.cXl());
        View inflate = View.inflate(this.mController.ylL, R.layout.ad4, null);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
        checkBox.setChecked(false);
        checkBox.setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.d8n);
        textView.setText(r6);
        textView.setTextColor(getResources().getColor(R.color.w4));
        textView = (TextView) inflate.findViewById(R.id.d8p);
        textView.setTextColor(getResources().getColor(R.color.w4));
        textView.setVisibility(8);
        this.uwf = com.tencent.mm.ui.base.h.a(this.mController.ylL, true, "", inflate, r4, r5, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(7877);
                if (checkBox != null && checkBox.isChecked()) {
                    try {
                        if (WebViewUI.this.icy.cZd()) {
                            WebViewUI.this.icy.gx(327792, 1);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
                    }
                }
                WebViewUI.this.uwA = true;
                WebViewUI.this.uwf = null;
                m.uuj.close();
                WebViewUI.this.finish();
                AppMethodBeat.o(7877);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WebViewUI.this.uwf = null;
            }
        });
        AppMethodBeat.o(8093);
        return true;
    }

    private boolean daB() {
        AppMethodBeat.i(8094);
        int intExtra = getIntent().getIntExtra("key_close_action", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("key_close_data");
        ab.i("MicroMsg.WebViewUI", "close action %s", Integer.valueOf(intExtra));
        switch (intExtra) {
            case 1:
                if (bundleExtra != null) {
                    String string = bundleExtra.getString("close_dialog_title");
                    String string2 = bundleExtra.getString("close_dialog_msg");
                    String string3 = bundleExtra.getString("close_dialog_ok");
                    String string4 = bundleExtra.getString("close_dialog_cancel");
                    boolean z = bundleExtra.getBoolean("close_dialog_ok_close", true);
                    if (!bo.Q(string2, string3, string4)) {
                        if (z) {
                            com.tencent.mm.ui.base.h.a((Context) this, string, string2, string3, string4, false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(7878);
                                    WebViewUI.this.uwA = true;
                                    m.uuj.close();
                                    WebViewUI.this.finish();
                                    AppMethodBeat.o(7878);
                                }
                            }, null);
                        } else {
                            com.tencent.mm.ui.base.h.a((Context) this, string, string2, string3, string4, false, null, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(7879);
                                    WebViewUI.this.uwA = true;
                                    m.uuj.close();
                                    WebViewUI.this.finish();
                                    AppMethodBeat.o(7879);
                                }
                            });
                        }
                        AppMethodBeat.o(8094);
                        return true;
                    }
                }
                break;
            case 2:
                if (bundleExtra != null) {
                    String string5 = bundleExtra.getString("close_jump_url");
                    int i = bundleExtra.getInt("close_jump_url_request_code", 0);
                    if (!bo.isNullOrNil(string5)) {
                        Intent intent = new Intent(this, WebViewUI.class);
                        intent.putExtra("rawUrl", string5);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                        startActivityForResult(intent, i);
                        com.tencent.mm.ui.base.b.hN(this);
                        AppMethodBeat.o(8094);
                        return true;
                    }
                }
                break;
        }
        AppMethodBeat.o(8094);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void daC() {
        AppMethodBeat.i(8095);
        if (daB()) {
            AppMethodBeat.o(8095);
            return;
        }
        daD();
        if (!cWG()) {
            this.uwA = true;
            m.uuj.close();
            if (this.uie.Jx(20)) {
                AppMethodBeat.o(8095);
                return;
            }
            finish();
        }
        AppMethodBeat.o(8095);
    }

    private void daD() {
        AppMethodBeat.i(8096);
        if (this.uwC) {
            ab.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
            AppMethodBeat.o(8096);
            return;
        }
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("webview_invoke_launch_app_when_back", false);
        String stringExtra = intent.getStringExtra("KAppId");
        String stringExtra2 = intent.getStringExtra("webview_invoke_launch_app_ext_info_when_back");
        if (booleanExtra && stringExtra != null && stringExtra.length() > 0 && stringExtra2 != null && stringExtra2.length() > 0) {
            Bundle bundle = new Bundle();
            bundle.putString("appId", stringExtra);
            bundle.putString(IssueStorage.COLUMN_EXT_INFO, stringExtra2);
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, com.tencent.mm.pluginsdk.model.app.u.class, null);
        }
        AppMethodBeat.o(8096);
    }

    /* Access modifiers changed, original: protected */
    public void jD(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void j(int i, Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public boolean aYb() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void t(int i, Bundle bundle) {
        AppMethodBeat.i(8097);
        ab.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
        AppMethodBeat.o(8097);
    }

    public final void nR(boolean z) {
        AppMethodBeat.i(8098);
        String url = this.pzf.getUrl();
        if (z) {
            showOptionMenu(0, false);
            this.uwd.put(url, Boolean.TRUE);
            AppMethodBeat.o(8098);
            return;
        }
        showOptionMenu(0, true);
        if (this.uwd.containsKey(url)) {
            this.uwd.remove(url);
        }
        AppMethodBeat.o(8098);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean daE() {
        AppMethodBeat.i(8099);
        if (this.jYe != -3) {
            showVKB();
            AppMethodBeat.o(8099);
            return true;
        }
        AppMethodBeat.o(8099);
        return false;
    }

    public final void aqX() {
        AppMethodBeat.i(8100);
        super.aqX();
        this.jYe = -2;
        AppMethodBeat.o(8100);
    }

    public final void showVKB() {
        AppMethodBeat.i(8101);
        super.showVKB();
        if (this.jYe == -3) {
            this.jYe = -2;
            AppMethodBeat.o(8101);
            return;
        }
        this.jYe = -3;
        AppMethodBeat.o(8101);
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        AppMethodBeat.i(8102);
        super.setBackBtn(onMenuItemClickListener, i);
        if (com.tencent.mm.compatible.util.d.iW(21) && dac()) {
            dxZ();
        }
        AppMethodBeat.o(8102);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cWO() {
        AppMethodBeat.i(8103);
        ab.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", Boolean.valueOf(getIntent().getBooleanExtra("forceHideShare", false)), Boolean.valueOf(getIntent().getBooleanExtra("showShare", true)), Boolean.valueOf(aYc()));
        if (!getIntent().getBooleanExtra("forceHideShare", false) && r3 && aYc()) {
            AppMethodBeat.o(8103);
            return true;
        }
        AppMethodBeat.o(8103);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aYc() {
        boolean z;
        AppMethodBeat.i(8104);
        if (!getClass().equals(WebViewUI.class) || getIntent().getBooleanExtra("disable_minimize", false)) {
            z = false;
        } else {
            z = true;
        }
        ab.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", getClass(), Boolean.valueOf(z));
        AppMethodBeat.o(8104);
        return z;
    }

    /* Access modifiers changed, original: protected */
    public void daF() {
    }

    /* Access modifiers changed, original: protected */
    public boolean aYf() {
        return false;
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(8105);
        if (bo.isEqual(intent.getType(), "application/vnd.android.package-archive")) {
            com.tencent.mm.pluginsdk.model.app.q.a(ah.getContext(), intent.getData(), null);
            AppMethodBeat.o(8105);
            return;
        }
        super.startActivity(intent);
        AppMethodBeat.o(8105);
    }

    /* Access modifiers changed, original: protected|final */
    public final void daG() {
        AppMethodBeat.i(8106);
        overridePendingTransition(R.anim.cf, R.anim.ce);
        AppMethodBeat.o(8106);
    }

    private boolean cZZ() {
        return this.uvf || this.uvg;
    }

    /* Access modifiers changed, original: protected */
    public int aMi() {
        AppMethodBeat.i(8001);
        int dyj = this.mController.dyj();
        AppMethodBeat.o(8001);
        return dyj;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dad() {
        AppMethodBeat.i(8003);
        if (!com.tencent.mm.compatible.util.d.iW(21) || this.nfs == 0) {
            setStatusBarColor(aMi());
            AppMethodBeat.o(8003);
            return;
        }
        xE(this.nfs);
        if (dac()) {
            dxZ();
            ta(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
        }
        at(this.nfs, dac());
        AppMethodBeat.o(8003);
    }

    /* Access modifiers changed, original: protected */
    public MMWebView aXX() {
        AppMethodBeat.i(8007);
        MMWebView in = com.tencent.mm.ui.widget.MMWebView.a.in(this);
        AppMethodBeat.o(8007);
        return in;
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(8062);
        if (com.tencent.mm.compatible.util.d.iW(21)) {
            Drawable g = android.support.v4.content.b.g(this, i2);
            if (g == null) {
                AppMethodBeat.o(8062);
                return;
            }
            if (dac()) {
                g.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            } else if (this.uwO == null || this.uwO.uxW) {
                g.clearColorFilter();
            } else {
                g.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            }
            a(i, getString(R.string.rn), g, onMenuItemClickListener);
            AppMethodBeat.o(8062);
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        AppMethodBeat.o(8062);
    }

    public final void m(String str, long j, int i) {
        AppMethodBeat.i(8075);
        if (at.isConnected(getApplicationContext())) {
            if (at.isWifi(getApplicationContext())) {
                this.networkType = 1;
            } else if (at.is4G(getApplicationContext())) {
                this.networkType = 4;
            } else if (at.is3G(getApplicationContext())) {
                this.networkType = 3;
            } else if (at.is2G(getApplicationContext())) {
                this.networkType = 2;
            }
            ab.i("MicroMsg.WebViewUI", "get networkType %d", Integer.valueOf(this.networkType));
        }
        String afN = afN(this.uxh);
        if (this.fromScene != 0) {
            this.uxg = " ";
        }
        if (this.icz == null) {
            ab.w("MicroMsg.WebViewUI", "webpageVisitInfoReport wvPerm is null");
            AppMethodBeat.o(8075);
            return;
        }
        GeneralControlWrapper cZT = this.icz.cZT();
        ab.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", Boolean.valueOf(cZT != null ? cZT.dmm() : false));
        if (this.iBE > 0 && this.uxi > this.iBE && j > this.uxi && !TextUtils.isEmpty(afN) && r4) {
            long j2 = this.uxi - this.iBE;
            long j3 = j - this.uxi;
            ab.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", Integer.valueOf(13376), Long.valueOf(this.iBE), afN, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.ium, this.uxh, this.cvF, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.uxg);
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            try {
                str2 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(this.ium), "UTF-8");
                str3 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(this.uxh), "UTF-8");
                str4 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(str), "UTF-8");
                str5 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(this.uxg), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(13376, Long.valueOf(this.iBE), afN, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.cvF, Integer.valueOf(i), str4, Integer.valueOf(this.fromScene), str5);
            this.fromScene = 0;
        }
        if (i == 1) {
            this.uxg = this.uxh;
            this.uxh = str;
            this.iBE = j;
        }
        AppMethodBeat.o(8075);
    }

    private int daz() {
        AppMethodBeat.i(8088);
        float f = this.mController.ylL.getSharedPreferences(ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            AppMethodBeat.o(8088);
            return 1;
        } else if (f == 1.125f) {
            AppMethodBeat.o(8088);
            return 3;
        } else if (f == 1.25f || f == 1.375f || f == 1.625f) {
            AppMethodBeat.o(8088);
            return 4;
        } else {
            AppMethodBeat.o(8088);
            return 2;
        }
    }

    static /* synthetic */ void h(WebViewUI webViewUI) {
        AppMethodBeat.i(8114);
        View view = webViewUI.pzf.getView();
        view.scrollTo(view.getScrollX(), 0);
        com.tencent.mm.plugin.webview.model.aq.i cYb = webViewUI.ulI.cYb();
        cYb.une = new Object[]{webViewUI.cOG, Integer.valueOf(7)};
        cYb.b(webViewUI.icy);
        AppMethodBeat.o(8114);
    }

    static /* synthetic */ boolean m(WebViewUI webViewUI) {
        AppMethodBeat.i(8121);
        if (webViewUI.uvi == null || !webViewUI.uvi.isShown()) {
            AppMethodBeat.o(8121);
            return false;
        }
        AppMethodBeat.o(8121);
        return true;
    }
}
