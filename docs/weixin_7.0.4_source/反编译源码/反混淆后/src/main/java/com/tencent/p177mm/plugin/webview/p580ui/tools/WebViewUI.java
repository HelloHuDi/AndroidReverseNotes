package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.support.p057v4.content.C0380b;
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
import android.view.View.OnClickListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p211cb.C26005f;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C42040qg;
import com.tencent.p177mm.p230g.p231a.C42079vp;
import com.tencent.p177mm.p249m.C1766d;
import com.tencent.p177mm.p249m.C1766d.C1764a;
import com.tencent.p177mm.p249m.C1766d.C1765b;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.MMFalseProgressBar;
import com.tencent.p177mm.p612ui.statusbar.C5540a;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C15990d;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.p839bm.C9086a;
import com.tencent.p177mm.p839bm.C9086a.C9087b;
import com.tencent.p177mm.p839bm.C9086a.C9088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.compat.p1389b.C38158a.C268251;
import com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C2294a;
import com.tencent.p177mm.plugin.appbrand.service.C27297a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.downloader.model.DownloadChecker;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.websearch.api.C35571ah;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.webview.C14445a;
import com.tencent.p177mm.plugin.webview.C14447b;
import com.tencent.p177mm.plugin.webview.model.C22883an;
import com.tencent.p177mm.plugin.webview.model.C40252a;
import com.tencent.p177mm.plugin.webview.model.C40259aq;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C14510a;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C14511h;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C22884i;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C22886o;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40257d;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40258f;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40261l;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40262m;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40263n;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40264b;
import com.tencent.p177mm.plugin.webview.model.C43907af;
import com.tencent.p177mm.plugin.webview.model.C43907af.C14507b;
import com.tencent.p177mm.plugin.webview.model.C43907af.C14508d;
import com.tencent.p177mm.plugin.webview.model.C43907af.C29814c;
import com.tencent.p177mm.plugin.webview.model.C43907af.C29814c.C228772;
import com.tencent.p177mm.plugin.webview.model.C43907af.C29814c.C228783;
import com.tencent.p177mm.plugin.webview.model.C43907af.C29814c.C249284;
import com.tencent.p177mm.plugin.webview.model.C43907af.C29814c.C298165;
import com.tencent.p177mm.plugin.webview.model.C46424b;
import com.tencent.p177mm.plugin.webview.model.C46424b.C356131;
import com.tencent.p177mm.plugin.webview.modelcache.C14525q;
import com.tencent.p177mm.plugin.webview.modelcache.C46429p;
import com.tencent.p177mm.plugin.webview.modelcache.C46429p.C40275a;
import com.tencent.p177mm.plugin.webview.modeltools.C29849n;
import com.tencent.p177mm.plugin.webview.modeltools.C35618a;
import com.tencent.p177mm.plugin.webview.modeltools.C40276k;
import com.tencent.p177mm.plugin.webview.modeltools.C43923d;
import com.tencent.p177mm.plugin.webview.modeltools.C46430c;
import com.tencent.p177mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.p177mm.plugin.webview.p1068e.C22784a;
import com.tencent.p177mm.plugin.webview.p1068e.C43867e;
import com.tencent.p177mm.plugin.webview.p1068e.C44781d;
import com.tencent.p177mm.plugin.webview.p1068e.C44781d.C144501;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k.C40343b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C43987l.C35692a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.LogoWebViewWrapper.C29857a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22944q;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C40291o;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C46437p;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameWebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C22986a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43967b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f.C35691a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2299122;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2994057;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C4398163;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44791e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40353n;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.FontChooserView;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.FontChooserView.C4653a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MovingImageButton;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.WebViewSearchContentInputFooter.C23150a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter.C14683a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter.C29963b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewInputFooter.C35728c;
import com.tencent.p177mm.plugin.webview.stub.C22913c;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.plugin.webview.stub.C46434d.C35624a;
import com.tencent.p177mm.plugin.webview.stub.WebViewStubService;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.pluginsdk.model.app.C30071u;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4782m;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C36589p.C6033a;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.C6031l.C6032a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C41116b;
import com.tencent.xweb.util.C24532f;
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
import org.p1430a.C41166a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI */
public class WebViewUI extends MMActivity implements OnCreateContextMenuListener, C15990d {
    private static final Pattern uiv = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern uiw = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Set<String> ums;
    private static final ArrayList<C16979z> uvK = new ArrayList();
    private static RenderPriority uvQ = RenderPriority.NORMAL;
    protected static int uwz = 0;
    protected String cMm;
    public volatile String cOG = null;
    protected int cSQ;
    protected String cvF = "";
    private int fromScene;
    public C7306ak handler;
    private long iBE = 0;
    private String iCz;
    private int iJp;
    C46696j icA;
    private final C43923d icH = new C43923d();
    public C46434d icy = null;
    public C40344k icz = null;
    protected String ium = "";
    protected int jLX;
    protected int jLY;
    private int jQp = 0;
    public String jUg;
    public int jYe = -1;
    private ServiceConnection ktl = new C1694733();
    protected C24109b mUw = new C1457651();
    private int networkType;
    public int nfs = 0;
    public String nft = null;
    private long oes = 0;
    public MMWebView pzf;
    protected boolean rpm = true;
    protected int screenOrientation = -1;
    public C44786d uhz = null;
    private C35652d uic;
    protected C22935h uie;
    public C40259aq ulI = new C40259aq();
    protected C40281e umI;
    protected volatile String unr;
    private final C35618a utt = new C35618a();
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
    private C7564ap uvI;
    private List<C43967b> uvJ = new ArrayList();
    private boolean uvL = false;
    private CustomViewCallback uvM;
    private View uvN;
    protected C6031l uvO;
    private ProgressBar uvP;
    protected C16977l uvR = new C16977l(null);
    protected C16950m uvS = new C16950m();
    protected C16951o uvT = new C16951o();
    protected C14585q uvU = new C14585q();
    private final C4884c<SendDataToH5FromMiniProgramEvent> uvV = new C145691();
    private boolean uvW = false;
    private int uvX = 0;
    public C43986f uvY;
    protected boolean uvZ = false;
    private ImageButton uva;
    protected View uvb;
    protected FrameLayout uvc;
    public FrameLayout uvd;
    protected MovingImageButton uve;
    protected boolean uvf = false;
    private boolean uvg = false;
    protected C9086a uvh;
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
    private C44781d uwE = new C44781d();
    private C46424b uwF = new C46424b(this.ulI);
    protected C29849n uwG = new C29849n();
    protected C46444i uwH;
    public C40326j uwI;
    protected IUtils uwJ = null;
    private WebViewClipBoardHelper uwK;
    protected C14447b uwL;
    protected volatile String uwM;
    protected volatile long uwN;
    private C23144o uwO;
    protected C22883an uwP = new C22883an(this);
    protected C36591r uwQ = new C1696912();
    private C4884c<C42040qg> uwR = new C1698023();
    private boolean uwS = true;
    protected View uwT;
    private View uwU;
    private C9087b uwV = new C169494();
    private boolean uwW = false;
    protected final C43987l uwX = new C43987l();
    private boolean uwY;
    private OnLongClickListener uwZ = new C1697025();
    protected HashMap<String, Boolean> uwa = new HashMap();
    protected HashMap<String, String> uwb = new HashMap();
    protected HashMap<String, ArrayList<C1765b>> uwc = new HashMap();
    protected HashMap<String, Boolean> uwd = new HashMap();
    protected C16967d uwe;
    protected C5653c uwf = null;
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
    public OnLongClickListener uxc = new C1698230();
    private String uxd = "";
    protected volatile String uxe = "";
    protected volatile String uxf = null;
    private volatile String uxg = "";
    protected volatile String uxh = "";
    private long uxi = 0;
    private C44275p uxj;
    private C14508d uxk = new C1696043();
    protected C14507b uxl = new C1697345();
    private C15532i uxm;
    private long uxn = 0;
    private String[] uxo = null;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$17 */
    class C457917 implements FindListener {
        C457917() {
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            AppMethodBeat.m2504i(7836);
            if (!(!z || WebViewUI.this.uvk || C5046bo.isNullOrNil(WebViewUI.this.uvj.getSearchContent()))) {
                if (i2 == 0) {
                    C7060h.pYm.mo8378a(480, 3, 1, false);
                } else {
                    C7060h.pYm.mo8378a(480, 2, 1, false);
                }
                WebViewUI.this.uvk = true;
            }
            WebViewUI.this.uvj.mo38766t(i, i2, z);
            AppMethodBeat.m2505o(7836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$40 */
    class C458040 implements OnClickListener {
        C458040() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7863);
            if (WebViewUI.this.pzf != null) {
                WebViewUI.this.pzf.reload();
            }
            AppMethodBeat.m2505o(7863);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$54 */
    class C458154 implements OnLayoutChangeListener {
        C458154() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(7883);
            WebViewUI.this.cZY();
            AppMethodBeat.m2505o(7883);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$9 */
    class C45829 implements OnMenuItemClickListener {
        C45829() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7816);
            try {
                WebViewUI.this.loadUrl(WebViewUI.this.icy.afp(null));
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", e.getMessage());
            }
            AppMethodBeat.m2505o(7816);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$e */
    class C4583e implements C43967b {
        private C4583e() {
        }

        /* synthetic */ C4583e(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7897);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7897);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://critical_update/");
            AppMethodBeat.m2505o(7897);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7898);
            C7060h.pYm.mo8378a(405, 25, 1, true);
            WebViewUI.m26229f(WebViewUI.this, 1);
            AppMethodBeat.m2505o(7898);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$g */
    public class C7216g extends C6031l {
        private Dialog dialog = null;
        public volatile boolean eBB = false;
        private final List<String> uxC = new LinkedList();

        protected C7216g() {
            AppMethodBeat.m2504i(7912);
            AppMethodBeat.m2505o(7912);
        }

        /* renamed from: a */
        public final void mo13205a(WebView webView, int i) {
            AppMethodBeat.m2504i(7913);
            if (i < 100) {
                WebViewUI.m26215b(WebViewUI.this, false);
                AppMethodBeat.m2505o(7913);
                return;
            }
            if (i >= 100) {
                WebViewUI.m26215b(WebViewUI.this, true);
            }
            AppMethodBeat.m2505o(7913);
        }

        /* renamed from: d */
        public final void mo7557d(WebView webView, String str) {
            AppMethodBeat.m2504i(7914);
            C4990ab.m7417i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", str, WebViewUI.this.uxf);
            super.mo7557d(webView, str);
            if (WebViewUI.this.uuW) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(7914);
            } else if (str == null) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "null title");
                AppMethodBeat.m2505o(7914);
            } else if (WebViewUI.this.rpm) {
                if (!(C5046bo.nullAsNil(WebViewUI.this.uxf).equals(str) || C14525q.m22728Ed(str))) {
                    WebViewUI.this.setMMTitle(str);
                }
                AppMethodBeat.m2505o(7914);
            } else {
                AppMethodBeat.m2505o(7914);
            }
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.m2504i(7915);
            C4990ab.m7416i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
            try {
                WebViewUI.this.mController.ylL.getWindow().addFlags(128);
                if (WebViewUI.this.uvN != null) {
                    customViewCallback.onCustomViewHidden();
                    AppMethodBeat.m2505o(7915);
                    return;
                }
                WebViewUI.this.mo31013nP(false);
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
                    AppMethodBeat.m2505o(7915);
                    return;
                }
                WebViewUI.this.pzf.setVisibility(8);
                WebViewUI.this.uvd.addView(view);
                WebViewUI.this.setTitleVisibility(4);
                AppMethodBeat.m2505o(7915);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
                AppMethodBeat.m2505o(7915);
            }
        }

        public final void onHideCustomView() {
            AppMethodBeat.m2504i(7916);
            C4990ab.m7416i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
            WebViewUI.this.mController.ylL.getWindow().clearFlags(128);
            if (WebViewUI.this.uvN == null) {
                AppMethodBeat.m2505o(7916);
                return;
            }
            try {
                WebViewUI.this.mo31013nP(false);
                if (WebViewUI.this.pzf.isXWalkKernel()) {
                    WebViewUI.this.fullScreenNoTitleBar(false);
                    WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(C25738R.color.a1f));
                    if (WebViewUI.this.uwT != null) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WebViewUI.this.uwT.getLayoutParams();
                        int r = WebViewUI.m26246r(WebViewUI.this);
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
                AppMethodBeat.m2505o(7916);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
                AppMethodBeat.m2505o(7916);
            }
        }

        public final View getVideoLoadingProgressView() {
            AppMethodBeat.m2504i(7917);
            if (WebViewUI.this.uvP == null) {
                WebViewUI.this.uvP = new ProgressBar(WebViewUI.this);
                WebViewUI.this.uvP.setIndeterminate(true);
            }
            ProgressBar t = WebViewUI.this.uvP;
            AppMethodBeat.m2505o(7917);
            return t;
        }

        public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
            AppMethodBeat.m2504i(7918);
            C4990ab.m7417i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", str);
            if (!C35805b.m58714o(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION")) {
                C35805b.m58709b(WebViewUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64);
            }
            C30379h.m48453a(WebViewUI.this, false, WebViewUI.this.getString(C25738R.string.g2e, new Object[]{str}), WebViewUI.this.getString(C25738R.string.g2f), WebViewUI.this.getString(C25738R.string.f9187s6), WebViewUI.this.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7901);
                    C4990ab.m7416i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
                    callback.invoke(str, true, true);
                    C29916g.m47392a(WebViewUI.this.icy, 14340, WebViewUI.this.cOG, WebViewUI.this.dae(), Integer.valueOf(WebViewUI.this.cSQ), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(C40259aq.aEn()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.m2505o(7901);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7904);
                    C4990ab.m7416i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
                    callback.invoke(str, false, false);
                    C29916g.m47392a(WebViewUI.this.icy, 14340, WebViewUI.this.cOG, WebViewUI.this.dae(), Integer.valueOf(WebViewUI.this.cSQ), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(C40259aq.aEn()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.m2505o(7904);
                }
            });
            AppMethodBeat.m2505o(7918);
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.m2504i(7919);
            WebViewUI.this.icH.mo69604a(WebViewUI.this, WebViewUI.this.icz, valueCallback, null, str, str2);
            AppMethodBeat.m2505o(7919);
        }

        /* renamed from: a */
        public final boolean mo13206a(WebView webView, ValueCallback<Uri[]> valueCallback, C6032a c6032a) {
            AppMethodBeat.m2504i(7920);
            if (c6032a.getMode() != 0 && c6032a.getMode() != 1) {
                AppMethodBeat.m2505o(7920);
                return false;
            } else if (c6032a.getAcceptTypes() == null || c6032a.getAcceptTypes().length <= 0) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                AppMethodBeat.m2505o(7920);
                return true;
            } else {
                String str = c6032a.getAcceptTypes()[0];
                String str2 = "*";
                if (c6032a.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                WebViewUI.this.icH.mo69604a(WebViewUI.this, WebViewUI.this.icz, null, valueCallback, str, str2);
                AppMethodBeat.m2505o(7920);
                return true;
            }
        }

        /* renamed from: b */
        public final boolean mo13211b(WebView webView, final String str, String str2, final C46945h c46945h) {
            AppMethodBeat.m2504i(7921);
            C4990ab.m7410d("MicroMsg.WebViewUI", "onJsConfirm");
            final PBool pBool = new PBool();
            pBool.value = false;
            if (WebViewUI.this.isFinishing() || WebViewUI.this.uiu) {
                C4990ab.m7410d("MicroMsg.WebViewUI", "onJsConfirm finish");
                c46945h.cancel();
                AppMethodBeat.m2505o(7921);
                return true;
            }
            WebViewUI.this.uwu = WebViewUI.this.uwu + 1;
            if (WebViewUI.this.uwu > 2) {
                this.dialog = C30379h.m48444a(WebViewUI.this, str2, "", WebViewUI.this.getString(C25738R.string.g28), WebViewUI.this.getString(C25738R.string.f9187s6), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7905);
                        C7060h.pYm.mo8381e(11683, str, Integer.valueOf(1), Integer.valueOf(WebViewUI.this.uwu));
                        c46945h.cancel();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        WebViewUI.this.finish();
                        AppMethodBeat.m2505o(7905);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7906);
                        pBool.value = true;
                        c46945h.confirm();
                        AppMethodBeat.m2505o(7906);
                    }
                }, (int) C25738R.color.f11809hy);
            } else {
                this.dialog = C30379h.m48453a(WebViewUI.this.mController.ylL, false, str2, "", WebViewUI.this.getString(C25738R.string.f9187s6), WebViewUI.this.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7907);
                        pBool.value = true;
                        c46945h.confirm();
                        AppMethodBeat.m2505o(7907);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7908);
                        c46945h.cancel();
                        AppMethodBeat.m2505o(7908);
                    }
                });
            }
            if (this.dialog != null) {
                this.dialog.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(7909);
                        C4990ab.m7410d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
                        if (!pBool.value) {
                            c46945h.cancel();
                        }
                        AppMethodBeat.m2505o(7909);
                    }
                });
                this.dialog.setCancelable(false);
                this.dialog.setCanceledOnTouchOutside(false);
                AppMethodBeat.m2505o(7921);
                return true;
            }
            boolean b = super.mo13211b(webView, str, str2, c46945h);
            AppMethodBeat.m2505o(7921);
            return b;
        }

        /* renamed from: a */
        public final boolean mo13208a(WebView webView, String str, String str2, String str3, C41127g c41127g) {
            AppMethodBeat.m2504i(7922);
            boolean a = super.mo13208a(webView, str, str2, str3, c41127g);
            AppMethodBeat.m2505o(7922);
            return a;
        }

        /* renamed from: a */
        public final boolean mo13207a(WebView webView, final String str, String str2, final C46945h c46945h) {
            AppMethodBeat.m2504i(7923);
            C4990ab.m7410d("MicroMsg.WebViewUI", "onJsAlert");
            final PBool pBool = new PBool();
            pBool.value = false;
            if (WebViewUI.this.isFinishing() || WebViewUI.this.uiu) {
                C4990ab.m7410d("MicroMsg.WebViewUI", "onJsAlert finish");
                c46945h.cancel();
                AppMethodBeat.m2505o(7923);
                return true;
            }
            C5653c a;
            WebViewUI.this.uwu = WebViewUI.this.uwu + 1;
            if (WebViewUI.this.uwu > 2) {
                a = C30379h.m48444a(WebViewUI.this, str2, "", WebViewUI.this.getString(C25738R.string.g28), WebViewUI.this.getString(C25738R.string.f9187s6), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7910);
                        C7060h.pYm.mo8381e(11683, str, Integer.valueOf(1), Integer.valueOf(WebViewUI.this.uwu));
                        c46945h.cancel();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        WebViewUI.this.finish();
                        AppMethodBeat.m2505o(7910);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7911);
                        pBool.value = true;
                        c46945h.confirm();
                        AppMethodBeat.m2505o(7911);
                    }
                }, (int) C25738R.color.f12123t7);
            } else {
                a = C30379h.m48443a(WebViewUI.this, str2, "", WebViewUI.this.getString(C25738R.string.f9187s6), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7902);
                        pBool.value = true;
                        c46945h.confirm();
                        AppMethodBeat.m2505o(7902);
                    }
                });
            }
            if (a != null) {
                a.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(7903);
                        C4990ab.m7410d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
                        if (!pBool.value) {
                            c46945h.cancel();
                        }
                        AppMethodBeat.m2505o(7903);
                    }
                });
                a.setCanceledOnTouchOutside(false);
                a.mo11498qZ(false);
                AppMethodBeat.m2505o(7923);
                return true;
            }
            boolean a2 = super.mo13207a(webView, str, str2, c46945h);
            AppMethodBeat.m2505o(7923);
            return a2;
        }

        public final void aJY() {
            AppMethodBeat.m2504i(7924);
            super.aJY();
            C4990ab.m7416i("MicroMsg.WebViewUI", "WebChromeClient onEnterFullscreen");
            AppMethodBeat.m2505o(7924);
        }

        public final void aDI() {
            AppMethodBeat.m2504i(7925);
            super.aDI();
            C4990ab.m7416i("MicroMsg.WebViewUI", "WebChromeClient onExitFullscreen");
            AppMethodBeat.m2505o(7925);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$1 */
    class C145691 extends C4884c<SendDataToH5FromMiniProgramEvent> {
        C145691() {
            AppMethodBeat.m2504i(7807);
            this.xxI = SendDataToH5FromMiniProgramEvent.class.getName().hashCode();
            AppMethodBeat.m2505o(7807);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(7808);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = (SendDataToH5FromMiniProgramEvent) c4883b;
            if (WebViewUI.this.hashCode() == sendDataToH5FromMiniProgramEvent.hJV && WebViewUI.this.uhz != null) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("miniprogramAppID", sendDataToH5FromMiniProgramEvent.hJU);
                hashMap.put("data", sendDataToH5FromMiniProgramEvent.data);
                C44786d c44786d = WebViewUI.this.uhz;
                C5004al.m7441d(new C4398163(C23124a.m35500b("onMiniProgramData", hashMap, c44786d.uFv, c44786d.uFw)));
            }
            AppMethodBeat.m2505o(7808);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$36 */
    class C1457136 implements Runnable {
        C1457136() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7859);
            if (WebViewUI.this.uhz != null) {
                WebViewUI.this.uhz.mo71879JM(0);
            }
            AppMethodBeat.m2505o(7859);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$46 */
    class C1457246 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$46$1 */
        class C145731 implements AnimationListener {
            C145731() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(7875);
                WebViewUI.this.uvb.setVisibility(8);
                AppMethodBeat.m2505o(7875);
            }
        }

        C1457246() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7876);
            Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, C25738R.anim.f8337b_);
            loadAnimation.setAnimationListener(new C145731());
            WebViewUI.this.uvb.startAnimation(loadAnimation);
            WebViewUI.this.uvb.setVisibility(8);
            AppMethodBeat.m2505o(7876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$49 */
    class C1457549 implements DialogInterface.OnClickListener {
        C1457549() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(7878);
            WebViewUI.this.uwA = true;
            C40346m.uuj.close();
            WebViewUI.this.finish();
            AppMethodBeat.m2505o(7878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$51 */
    class C1457651 implements C24109b {
        C1457651() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(7880);
            try {
                WebViewUI.this.icy.favEditTag();
                AppMethodBeat.m2505o(7880);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7880);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$f */
    class C14577f implements C43967b {
        private C14577f() {
        }

        /* synthetic */ C14577f(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7899);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7899);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://");
            AppMethodBeat.m2505o(7899);
            return t;
        }

        public final boolean afM(String str) {
            boolean z = true;
            AppMethodBeat.m2504i(7900);
            int afH = WebViewUI.this.afH(C5046bo.nullAsNil(WebViewUI.this.uwi));
            if (C14827e.m23075aH(str, WebViewUI.this.uxn)) {
                try {
                    if ("weixin://dl/shopping".equals(str)) {
                        String cZh = WebViewUI.this.icy.cZh();
                        if (!C5046bo.isNullOrNil(cZh)) {
                            WebViewUI.this.loadUrl(cZh);
                        }
                    } else if ("weixin://dl/faq".equals(str)) {
                        int cZj = WebViewUI.this.icy.cZj();
                        int cZk = WebViewUI.this.icy.cZk();
                        WebViewUI.this.loadUrl(C4996ah.getContext().getString(C25738R.string.ebk, new Object[]{Integer.valueOf(cZj), Integer.valueOf(cZk)}));
                    } else if ("weixin://dl/posts".equals(str)) {
                        WebViewUI.this.icy.cZl();
                    } else if ("weixin://dl/moments".equals(str)) {
                        WebViewUI.this.icy.cZm();
                    } else if (str.startsWith("weixin://dl/feedback")) {
                        WebViewUI.this.icy.afp(str);
                    } else if ("weixin://dl/scan".equals(str)) {
                        C25985d.m41472c(WebViewUI.this, "scanner", ".ui.SingleTopScanUI", new Intent());
                    } else {
                        C14827e.aiq(str);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    arrayList.add("1");
                    arrayList.add(String.valueOf(afH));
                    arrayList.add(C5046bo.nullAsNil(WebViewUI.this.uwi));
                    arrayList.add(C5046bo.nullAsNil(WebViewUI.this.cOG));
                    WebViewUI.this.icy.mo15583k(11405, arrayList);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WebViewUI", "kv report fail, ex = %s", e.getMessage());
                }
            } else {
                z = false;
            }
            AppMethodBeat.m2505o(7900);
            return z;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$h */
    public class C14579h extends C36592s {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$h$4 */
        class C145834 implements Runnable {
            C145834() {
            }

            public final void run() {
                AppMethodBeat.m2504i(7930);
                if (WebViewUI.this.pzf != null) {
                    WebViewUI.this.pzf.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                }
                WebViewUI webViewUI = WebViewUI.this;
                C169582 c169582 = new C169582();
                if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                    c169582.run();
                    AppMethodBeat.m2505o(7930);
                    return;
                }
                webViewUI.handler.post(c169582);
                AppMethodBeat.m2505o(7930);
            }
        }

        protected C14579h() {
        }

        public boolean aft(String str) {
            AppMethodBeat.m2504i(7931);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw mmShouldOverride");
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                AppMethodBeat.m2505o(7931);
                return true;
            } else if (WebViewUI.m26222d(WebViewUI.this, str)) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "custom scheme url deal success, url = ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(7931);
                return true;
            } else {
                WebViewUI.this.uxf = str;
                AppMethodBeat.m2505o(7931);
                return false;
            }
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(7932);
            boolean i = m22816i(webView, str);
            if (i) {
                WebViewUI.this.uvG = false;
            }
            AppMethodBeat.m2505o(7932);
            return i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:58:0x01cd  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x01cd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: i */
        private boolean m22816i(WebView webView, final String str) {
            AppMethodBeat.m2504i(138039);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = ".concat(String.valueOf(str)));
            WebViewUI.this.uvG = true;
            int intExtra;
            if (!WebViewUI.m26218c(WebViewUI.this, str)) {
                C4990ab.m7414f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(str)));
                WebViewUI.m26237k(WebViewUI.this);
                AppMethodBeat.m2505o(138039);
                return true;
            } else if (C30152u.m47751t(str, "about:blank")) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
                AppMethodBeat.m2505o(138039);
                return true;
            } else if (DownloadChecker.m31425a(str, WebViewUI.this.cMm, webView)) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "use the downloader to download");
                AppMethodBeat.m2505o(138039);
                return true;
            } else if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                WebViewUI.this.afL(str);
                AppMethodBeat.m2505o(138039);
                return true;
            } else if (str.startsWith("weixin://dl/business") && C14827e.m23079s(Uri.parse(str))) {
                String host = Uri.parse(WebViewUI.this.cOG).getHost();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(str + "&domain=" + host));
                intExtra = WebViewUI.this.getIntent().getIntExtra("pay_channel", -1);
                if (intExtra != -1) {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", str, Integer.valueOf(intExtra));
                    intent.putExtra("pay_channel", intExtra);
                }
                intent.putExtra("translate_link_scene", 13);
                WebViewUI.this.startActivity(intent);
                AppMethodBeat.m2505o(138039);
                return true;
            } else {
                try {
                    if (str.startsWith("weixinpreinject://iframe") && WebViewUI.this.uvY != null) {
                        C4990ab.m7416i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                        if (str.equals(WebViewUI.this.uxd)) {
                        }
                    } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                        if ((WebViewUI.this.cOG.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && WebViewUI.this.uvw) {
                            C14827e.m23077bu(WebViewUI.this.mController.ylL, str);
                            WebViewUI.this.finish();
                            AppMethodBeat.m2505o(138039);
                            return true;
                        }
                        if (str.equals(WebViewUI.this.uxd)) {
                            WebViewUI.this.uxd = "";
                            AppMethodBeat.m2505o(138039);
                            return true;
                        } else if (WebViewUI.this.afM(str)) {
                            AppMethodBeat.m2505o(138039);
                            return true;
                        } else if (str.startsWith("weixin://")) {
                            C4990ab.m7413e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                            AppMethodBeat.m2505o(138039);
                            return true;
                        } else {
                            intExtra = WebViewUI.this.uvR.ael(str);
                            boolean aft;
                            if ((intExtra == 0 || intExtra == 2 || intExtra == 8) && !WebViewUI.this.uvs) {
                                C4990ab.m7416i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(intExtra)));
                                if (WebViewUI.this.afI(str)) {
                                    WebViewUI.this.pzf.stopLoading();
                                    WebViewUI.this.pzf.post(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(7926);
                                            WebViewUI.this.mo30970b(str, null, true);
                                            AppMethodBeat.m2505o(7926);
                                        }
                                    });
                                } else if (!str.equals(WebViewUI.this.uvC)) {
                                    WebViewUI.this.pzf.stopLoading();
                                }
                                if (str.equals(WebViewUI.this.uvC)) {
                                    C4990ab.m7420w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                    aft = aft(str);
                                    AppMethodBeat.m2505o(138039);
                                    return aft;
                                }
                                WebViewUI.m26199a(WebViewUI.this, str, true, intExtra);
                                AppMethodBeat.m2505o(138039);
                                return true;
                            }
                            aft = aft(str);
                            AppMethodBeat.m2505o(138039);
                            return aft;
                        }
                    } else {
                        if (str.startsWith("weixin://webview/initReady/") || str.startsWith("weixin://webview/preInjectJSBridge/")) {
                            AppMethodBeat.m2505o(138039);
                            return true;
                        }
                        if (str.equals(WebViewUI.this.uxd)) {
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                    if (WebViewUI.this.icz == null) {
                        C4990ab.m7412e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                        AppMethodBeat.m2505o(138039);
                        return true;
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo26819a(WebView webView, String str, boolean z) {
            AppMethodBeat.m2504i(7933);
            C4990ab.m7417i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
            super.mo26819a(webView, str, z);
            if (C30152u.m47751t(str, "about:blank")) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
                AppMethodBeat.m2505o(7933);
                return;
            }
            String url = webView.getUrl();
            if (WebViewUI.this.uvs) {
                WebViewUI.this.mo30966as(url, false);
            }
            boolean z2 = WebViewUI.m26170A(WebViewUI.this) && (WebViewUI.this.unr == null || C5046bo.isEqual(url, WebViewUI.this.unr));
            if (z2 || !(WebViewUI.this.icz == null || WebViewUI.this.icz.has(url) || C5046bo.isEqual(url, WebViewUI.this.uvC))) {
                C4990ab.m7417i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", url);
                WebViewUI.this.mo30966as(url, z2);
                WebViewUI.this.mo30947X(true, false);
                WebViewUI.this.uww = true;
            }
            WebViewUI.this.uwX.cZU();
            WebViewUI.this.uxf = str;
            WebViewUI.this.uie.afY(str);
            AppMethodBeat.m2505o(7933);
        }

        /* renamed from: b */
        public void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(7934);
            super.mo7562b(webView, str, bitmap);
            WebViewUI.this.uvG = true;
            WebViewUI.this.uwE.mo69758aI("onPageStarted", System.currentTimeMillis());
            C40252a.m69033c(WebViewUI.this.pzf);
            C43867e.m78659h(str, WebViewUI.this.mController.ylL);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = ".concat(String.valueOf(str)));
            C7060h.pYm.mo8378a(155, 0, 1, false);
            if (!WebViewUI.this.uxb) {
                WebViewUI.this.uwI.cZL();
            }
            C46297h.m86868do(WebViewUI.this.cMm, 0);
            if (WebViewUI.this.aYd()) {
                if (TextUtils.isEmpty(str) || !str.equals(webView.getUrl())) {
                    C4990ab.m7419v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", str, webView.getUrl());
                } else {
                    C4990ab.m7416i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
                    WebViewUI.this.daq();
                    if (WebViewUI.this.uvY != null) {
                        WebViewUI.this.uvY.uCf = false;
                    }
                    WebViewUI.this.daF();
                }
            }
            if (C4872b.dnO() && "http://www.dktest-mmcrash.com/".equals(str)) {
                Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
            }
            WebViewUI.this.unr = WebViewUI.this.uxf;
            WebViewUI.this.mo31009l(str, C5046bo.anT(), 1);
            WebViewUI.this.ulI.cXX().unr = WebViewUI.this.unr;
            WebViewUI.this.uxf = str;
            C40346m c40346m = C40346m.uuj;
            C4990ab.m7419v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", str, c40346m.uuk, c40346m.qTK);
            String str2 = c40346m.uuk;
            c40346m.uuk = str;
            if (!C5046bo.isNullOrNil(c40346m.qTK)) {
                c40346m.mo63713h(1, str2, 0);
            }
            C4990ab.m7411d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", WebViewUI.this.unr, WebViewUI.this.uxf);
            if (WebViewUI.m26218c(WebViewUI.this, str)) {
                WebViewUI.this.uwX.cZU();
                WebViewUI.this.uwX.setCurrentURL(str);
                if (WebViewUI.this.afM(str)) {
                    WebViewUI.this.uxd = str;
                    AppMethodBeat.m2505o(7934);
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
                        WebViewUI.this.uhz.mo71943z((String) WebViewUI.this.uwx.get(str), (Map) WebViewUI.this.uwr.get(str));
                    }
                } else {
                    WebViewUI.this.uwn = false;
                    if (!WebViewUI.this.uwp) {
                        WebViewUI.this.uuX.start();
                    }
                }
                WebViewUI.this.uwI.afE(str);
                if (C16953w.NO_NEED.equals(WebViewUI.this.mo30966as(str, false))) {
                    WebViewUI.this.uwG.mo48062wy(str);
                    if (!WebViewUI.this.uxb) {
                        WebViewUI.this.uwI.utI = true;
                    }
                }
                WebViewUI.this.mo30947X(true, false);
                WebViewUI.this.uww = false;
                C40263n cXV = WebViewUI.this.ulI.cXV();
                int i = WebViewUI.this.cSQ;
                String str3 = WebViewUI.this.cMm;
                cXV.cSQ = i;
                cXV.uni = str3;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
                } else if (!cXV.unv.containsKey(str)) {
                    cXV.unv.put(str, Long.valueOf(C5046bo.anU()));
                }
                Bundle bundle = (Bundle) WebViewUI.this.getIntent().getParcelableExtra("jsapiargs");
                if (bundle != null) {
                    Parcelable parcelable = bundle.getParcelable("KSnsAdTag");
                    if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                        WebViewUI.this.ulI.cYg().pmI = (SnsAdClick) parcelable;
                        WebViewUI.this.ulI.cYg().mo56328L(str, AppEventsConstants.EVENT_PARAM_VALUE_NO, System.currentTimeMillis());
                        WebViewUI.this.ulI.cYg().mo56329b(WebViewUI.this.icy);
                    }
                }
                WebViewUI.this.uwu = 0;
                if (!(WebViewUI.this.uwO == null || WebViewUI.this.uwO.uxW)) {
                    C23144o F = WebViewUI.this.uwO;
                    C4990ab.m7417i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", str);
                    F.iCz = str;
                    F.daR();
                }
                AppMethodBeat.m2505o(7934);
                return;
            }
            C4990ab.m7414f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            WebViewUI.m26237k(WebViewUI.this);
            AppMethodBeat.m2505o(7934);
        }

        /* renamed from: b */
        public void mo5992b(WebView webView, final String str) {
            AppMethodBeat.m2504i(7935);
            super.mo5992b(webView, str);
            WebViewUI.this.uvG = false;
            WebViewUI.this.uwE.mo69758aI("onPageFinished", System.currentTimeMillis());
            WebViewUI.this.uvF = true;
            C40252a.m69033c(WebViewUI.this.pzf);
            WebViewUI.this.uie.afY(str);
            if (!WebViewUI.this.uwj) {
                WebViewUI.this.uwj = true;
                WebViewUI.this.ulI.cYa().loadFinished = true;
            }
            C4990ab.m7417i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", str);
            C40257d cYf = WebViewUI.this.ulI.cYf();
            if (cYf.mlA && !cYf.und) {
                try {
                    Uri parse = Uri.parse(str);
                    if (str.startsWith("http")) {
                        String host = parse.getHost();
                        if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                            C7060h.pYm.mo8378a(283, 0, 1, true);
                            cYf.und = true;
                            C4990ab.m7417i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", str);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", str);
                }
            }
            C40346m c40346m = C40346m.uuj;
            C4990ab.m7419v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", c40346m.qTK);
            if (!C5046bo.isNullOrNil(c40346m.qTK)) {
                c40346m.mo63715kT(2);
            }
            if (WebViewUI.this.pzf == null) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
                AppMethodBeat.m2505o(7935);
                return;
            }
            WebViewUI.this.uwG.mo48062wy(str);
            String title = WebViewUI.this.pzf.getTitle();
            C4990ab.m7417i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", WebViewUI.this.mController.getMMTitle(), title, Boolean.valueOf(WebViewUI.this.uuW), Boolean.valueOf(WebViewUI.this.rpm), WebViewUI.this.uxf);
            if (WebViewUI.this.pzf.getIsX5Kernel() && !C5046bo.isNullOrNil(title) && title.length() > 0 && !title.equals(WebViewUI.this.mController.getMMTitle()) && !title.startsWith("http") && ((WebViewUI.this.uxf == null || !WebViewUI.this.uxf.equals(title)) && !WebViewUI.this.uuW && WebViewUI.this.rpm)) {
                C4990ab.m7410d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
                WebViewUI.this.setMMTitle(title);
            }
            WebViewUI.this.uwX.setCurrentURL(WebViewUI.this.dae());
            boolean booleanExtra = WebViewUI.this.getIntent().getBooleanExtra("shouldForceViewPort", false);
            C4990ab.m7410d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: ".concat(String.valueOf(booleanExtra)));
            if (booleanExtra) {
                webView.evaluateJavascript(WebViewUI.this.getIntent().getStringExtra("view_port_code"), null);
            }
            WebViewUI.m26180J(WebViewUI.this);
            if (WebViewUI.m26218c(WebViewUI.this, str)) {
                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                WebViewUI.this.uuX.finish();
                WebViewUI.this.uxd = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    C4990ab.m7416i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                    AppMethodBeat.m2505o(7935);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.this.uwv);
                if (WebViewUI.this.uvY != null) {
                    WebViewUI.this.uvY.uFU = WebViewUI.this.getIntent().getBooleanExtra("inject_city_service_js", false);
                    WebViewUI.this.uvY.uFV = WebViewUI.this.getIntent().getStringExtra("city_service_ext_info");
                    WebViewUI.this.uvY.dbZ();
                }
                if (!(WebViewUI.this.icz == null || WebViewUI.this.icz.aei(str) == null)) {
                    WebViewUI.m26205a(WebViewUI.this, WebViewUI.this.icz.aei(str).mo69833jB(34), WebViewUI.this.icz.aei(str).mo69833jB(75));
                }
                WebViewUI.this.mo31013nP(false);
                C40263n cXV = WebViewUI.this.ulI.cXV();
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                } else if (cXV.unv.containsKey(str)) {
                    cXV.unv.put(str, Long.valueOf(C5046bo.anU() - ((Long) cXV.unv.get(str)).longValue()));
                }
                C40258f cXW = WebViewUI.this.ulI.cXW();
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
                } else if (cXW.ung.containsKey(str)) {
                    cXW.ung.put(str, Long.valueOf(C5046bo.anU() - ((Long) cXW.ung.get(str)).longValue()));
                }
                C14511h cXZ = WebViewUI.this.ulI.cXZ();
                C46434d c46434d = WebViewUI.this.icy;
                if (!(c46434d == null || cXZ.cph)) {
                    cXZ.cph = true;
                    int aEn = C40259aq.aEn();
                    long anU = C5046bo.anU() - cXZ.startTime;
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
                        objArr[7] = Integer.valueOf(C40259aq.umY);
                        objArr[8] = Integer.valueOf(C40259aq.umZ);
                        objArr[9] = Integer.valueOf(cXZ.cSQ);
                        objArr[10] = cXZ.uni;
                        C40259aq.m69040b(c46434d, str2, objArr);
                        C4990ab.m7417i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", cXZ.url, Long.valueOf(anU), Integer.valueOf(aEn), Integer.valueOf(C40259aq.umY), Integer.valueOf(C40259aq.umZ), Integer.valueOf(cXZ.cSQ), cXZ.uni);
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
                        WebViewUI.this.ulI.cYg().mo56328L(str, "1", System.currentTimeMillis());
                        WebViewUI.this.ulI.cYg().mo56329b(WebViewUI.this.icy);
                    }
                }
                WebViewUI.this.mo31012nO(((Boolean) WebViewUI.this.uwa.get(str)).booleanValue());
                Boolean bool = (Boolean) WebViewUI.this.uwd.get(str);
                if (bool == null || !bool.booleanValue()) {
                    WebViewUI.this.showOptionMenu(0, true);
                } else {
                    WebViewUI.this.showOptionMenu(0, false);
                }
                if (WebViewUI.this.uvu && C5046bo.isNullOrNil(WebViewUI.this.uxe)) {
                    WebViewUI.this.uxe = WebViewUI.this.uxf;
                }
                WebViewUI.this.uxi = C5046bo.anT();
                C4879a.xxA.mo10055m(new C42079vp());
                if (!(WebViewUI.this.uwO == null || WebViewUI.this.uwO.uxW)) {
                    C23144o F = WebViewUI.this.uwO;
                    C4990ab.m7417i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", str);
                    F.iCz = str;
                }
                C44781d B = WebViewUI.this.uwE;
                MMWebView mMWebView = WebViewUI.this.pzf;
                if (mMWebView != null) {
                    mMWebView.evaluateJavascript("JSON.stringify({timing:((window.performance && window.performance.timing) ? window.performance.timing : null)});", new C144501());
                }
                if (C5058f.IS_FLAVOR_RED) {
                    C41930g.dOW().mo60487b(new C268251(webView)).mo11587a(new C5691b<String>() {

                        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$h$2$1 */
                        class C145821 implements Runnable {
                            C145821() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(7927);
                                WebViewUI.this.finish();
                                AppMethodBeat.m2505o(7927);
                            }
                        }

                        /* renamed from: az */
                        public final /* synthetic */ void mo5270az(Object obj) {
                            AppMethodBeat.m2504i(7928);
                            String str = (String) obj;
                            if (!(TextUtils.isEmpty(str) || BuildConfig.COMMAND.equals(str))) {
                                ((C27297a) C1720g.m3528K(C27297a.class)).mo34266bq(Uri.parse(str).getQueryParameter("uuid"), str);
                                WebViewUI.this.runOnUiThread(new C145821());
                            }
                            AppMethodBeat.m2505o(7928);
                        }
                    });
                }
                AppMethodBeat.m2505o(7935);
                return;
            }
            C4990ab.m7414f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            WebViewUI.m26237k(WebViewUI.this);
            AppMethodBeat.m2505o(7935);
        }

        /* renamed from: a */
        public final void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
            String str;
            AppMethodBeat.m2504i(7936);
            C24532f.m38190rB(true);
            String url = webView.getUrl() == null ? WebViewUI.this.uxf : webView.getUrl();
            if (url == null || !url.startsWith(((C20023b) C1720g.m3528K(C20023b.class)).aVQ())) {
                str = url;
            } else {
                str = WebViewUI.this.cWL();
            }
            C7060h.pYm.mo8378a(155, 1, 1, false);
            C7060h.pYm.mo8378a(155, 30, 1, false);
            C46297h.m86868do(WebViewUI.this.cMm, 1);
            C46297h.m86868do(WebViewUI.this.cMm, 30);
            C46297h.m86867c(WebViewUI.this.cMm, WebViewUI.this.cOG, 30, WebViewUI.this.ulI.cXY().edh);
            if (WebViewUI.this.uic == null) {
                WebViewUI.this.uic = new C35652d(WebViewUI.this, WebViewUI.this.pzf);
            }
            WebViewUI.this.uic.mo56360a(str, c36588j, sslError);
            AppMethodBeat.m2505o(7936);
        }

        /* renamed from: a */
        public void mo7559a(WebView webView, final int i, String str, final String str2) {
            AppMethodBeat.m2504i(7937);
            C24532f.m38190rB(false);
            boolean isConnected = C5023at.isConnected(WebViewUI.this);
            C4990ab.m7413e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected));
            C7060h.pYm.mo8378a(155, 1, 1, false);
            C7060h.pYm.mo8378a(155, (long) C35641b.m58492Jf(i), 1, false);
            C46297h.m86868do(WebViewUI.this.cMm, 1);
            C46297h.m86868do(WebViewUI.this.cMm, C35641b.m58492Jf(i));
            C46297h.m86867c(WebViewUI.this.cMm, WebViewUI.this.cOG, C35641b.m58492Jf(i), WebViewUI.this.ulI.cXY().edh);
            super.mo7559a(webView, i, str, str2);
            C40346m.uuj.mo63711Jq(i);
            WebViewUI.this.ulI.cYg().errCode = i;
            WebViewUI.this.uwI.utI = false;
            if (WebViewUI.this.uvy) {
                WebViewUI.this.finish();
            }
            try {
                if (new URL(str2).getHost().equals("mp.weixin.qq.com")) {
                    C7305d.xDG.mo10151b(new Runnable() {
                        public final void run() {
                            String str;
                            AppMethodBeat.m2504i(7929);
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = str2;
                            objArr[1] = Integer.valueOf(i);
                            Context context = C4996ah.getContext();
                            if (C5023at.isWifi(context)) {
                                str = "wifi";
                            } else if (C5023at.is4G(context)) {
                                str = "4g";
                            } else if (C5023at.is3G(context)) {
                                str = "3g";
                            } else if (C5023at.is2G(context)) {
                                str = "2g";
                            } else {
                                str = "none";
                            }
                            objArr[2] = str;
                            objArr[3] = C14579h.afT("mp.weixin.qq.com");
                            c7060h.mo8381e(17082, objArr);
                            AppMethodBeat.m2505o(7929);
                        }
                    }, "WebViewUI.CheckDNS");
                }
                AppMethodBeat.m2505o(7937);
            } catch (MalformedURLException e) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e, "check mp url", new Object[0]);
                AppMethodBeat.m2505o(7937);
            }
        }

        public static String afT(String str) {
            AppMethodBeat.m2504i(7938);
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
                AppMethodBeat.m2505o(7938);
                return stringBuilder2;
            } catch (UnknownHostException e) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e, "dnsIps", new Object[0]);
                AppMethodBeat.m2505o(7938);
                return null;
            }
        }

        /* renamed from: h */
        public final void mo7563h(WebView webView, String str) {
            AppMethodBeat.m2504i(7939);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = ".concat(String.valueOf(str)));
            if (WebViewUI.m26218c(WebViewUI.this, str)) {
                C40258f cXW = WebViewUI.this.ulI.cXW();
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
                } else if (!(C5046bo.isNullOrNil(cXW.iCz) || str.equals(cXW.iCz) || !cXW.unh)) {
                    if (cXW.unf.containsKey(cXW.iCz)) {
                        cXW.unf.put(cXW.iCz, Long.valueOf(C5046bo.anU() - ((Long) cXW.unf.get(cXW.iCz)).longValue()));
                    }
                    cXW.unh = false;
                }
                super.mo7563h(webView, str);
                AppMethodBeat.m2505o(7939);
                return;
            }
            C4990ab.m7414f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            super.mo7563h(webView, str);
            WebViewUI.m26237k(WebViewUI.this);
            AppMethodBeat.m2505o(7939);
        }

        /* renamed from: c */
        public C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(7940);
            C4990ab.m7417i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", str);
            if (afU(str)) {
                AppMethodBeat.m2505o(7940);
                return null;
            }
            C31147o afV = afV(str);
            AppMethodBeat.m2505o(7940);
            return afV;
        }

        /* renamed from: a */
        public C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(7941);
            C31147o a;
            if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
                a = super.mo5990a(webView, c24530n);
                AppMethodBeat.m2505o(7941);
                return a;
            }
            C4990ab.m7417i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", c24530n.getUrl(), c24530n.getMethod(), Boolean.valueOf(c24530n.isForMainFrame()));
            if (afU(c24530n.getUrl().toString())) {
                AppMethodBeat.m2505o(7941);
                return null;
            }
            a = afV(c24530n.getUrl().toString());
            AppMethodBeat.m2505o(7941);
            return a;
        }

        /* renamed from: a */
        public C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(7942);
            C31147o a;
            if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
                a = super.mo5990a(webView, c24530n);
                AppMethodBeat.m2505o(7942);
                return a;
            }
            C4990ab.m7417i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", c24530n.getUrl(), c24530n.getMethod(), Boolean.valueOf(c24530n.isForMainFrame()));
            if (afU(c24530n.getUrl().toString())) {
                AppMethodBeat.m2505o(7942);
                return null;
            }
            if (C45287c.m83505iv(WebViewUI.this)) {
                try {
                    int i = bundle.getInt("resourceType");
                    if ((i == 1 || i == 7) && !WebViewUI.this.uvE) {
                        C4990ab.m7417i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                        WebViewUI.m26199a(WebViewUI.this, c24530n.getUrl().toString(), false, 5);
                    }
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", e.getMessage());
                } catch (Throwable th) {
                    C4990ab.m7421w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", th.getMessage());
                }
            }
            a = afV(c24530n.getUrl().toString());
            AppMethodBeat.m2505o(7942);
            return a;
        }

        private boolean afU(String str) {
            AppMethodBeat.m2504i(7943);
            if (WebViewUI.m26218c(WebViewUI.this, str)) {
                AppMethodBeat.m2505o(7943);
                return false;
            }
            C4990ab.m7414f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            WebViewUI.m26237k(WebViewUI.this);
            AppMethodBeat.m2505o(7943);
            return true;
        }

        private C31147o afV(String str) {
            AppMethodBeat.m2504i(7944);
            String dae = WebViewUI.this.dae();
            C31147o a = WebViewUI.this.uwP.mo38480a(str, !WebViewUI.this.uwk, WebViewUI.this.icy);
            if (a != null) {
                m22815hi(dae, str);
                AppMethodBeat.m2505o(7944);
                return a;
            }
            AppMethodBeat.m2505o(7944);
            return null;
        }

        /* renamed from: hi */
        private void m22815hi(String str, String str2) {
            AppMethodBeat.m2504i(7945);
            if (str2.equals(str) || WebViewUI.m26208a(WebViewUI.this, str, str2)) {
                WebViewUI.this.handler.post(new C145834());
            }
            AppMethodBeat.m2505o(7945);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$n */
    class C14584n implements C43967b {
        private C14584n() {
        }

        /* synthetic */ C14584n(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7958);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7958);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://gethtml/");
            AppMethodBeat.m2505o(7958);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7959);
            if (!C5046bo.isNullOrNil(str)) {
                String substring = str.substring(17);
                C4990ab.m7416i("MicroMsg.WebViewUI", "[oneliang]get html content :".concat(String.valueOf(substring)));
                WebViewUI.this.afG(substring);
            }
            AppMethodBeat.m2505o(7959);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$q */
    protected class C14585q {
        int uxP = 0;

        protected C14585q() {
        }

        public final boolean daP() {
            return this.uxP > 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$14 */
    class C1693114 implements C14683a {
        C1693114() {
        }

        /* renamed from: EH */
        public final boolean mo26953EH(String str) {
            AppMethodBeat.m2504i(7827);
            if (WebViewUI.this.uhz != null) {
                C44786d c44786d = WebViewUI.this.uhz;
                HashMap hashMap = new HashMap();
                hashMap.put("smiley", str);
                C5004al.m7441d(new C2299122(C23124a.m35500b("onGetSmiley", hashMap, c44786d.uFv, c44786d.uFw)));
            }
            AppMethodBeat.m2505o(7827);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$16 */
    class C1693216 implements C23150a {
        C1693216() {
        }

        public final void cWV() {
            AppMethodBeat.m2504i(7830);
            WebViewUI.m26213b(WebViewUI.this, 0);
            WebViewUI.this.pzf.clearMatches();
            WebViewUI.this.uvj.dcX();
            AppMethodBeat.m2505o(7830);
        }

        /* renamed from: a */
        public final void mo31017a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
            AppMethodBeat.m2504i(7831);
            if (webViewSearchContentInputFooter.getVisibility() == 0) {
                mo31018b(webViewSearchContentInputFooter);
            }
            AppMethodBeat.m2505o(7831);
        }

        public final void cWW() {
            AppMethodBeat.m2504i(7832);
            C7060h.pYm.mo8378a(480, 5, 1, false);
            WebViewUI.this.pzf.findNext(false);
            AppMethodBeat.m2505o(7832);
        }

        public final void cWX() {
            AppMethodBeat.m2504i(7833);
            C7060h.pYm.mo8378a(480, 4, 1, false);
            WebViewUI.this.pzf.findNext(true);
            AppMethodBeat.m2505o(7833);
        }

        /* renamed from: b */
        public final void mo31018b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
            AppMethodBeat.m2504i(7834);
            WebViewUI.this.pzf.clearMatches();
            webViewSearchContentInputFooter.reset();
            WebViewUI.this.uvj.mo38766t(0, 0, true);
            WebViewUI.this.uvk = false;
            WebViewUI.this.pzf.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
            AppMethodBeat.m2505o(7834);
        }

        /* renamed from: c */
        public final boolean mo31019c(int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(7835);
            if (i == 67 && keyEvent.getAction() == 0) {
                C7060h.pYm.mo8378a(480, 6, 1, false);
            }
            AppMethodBeat.m2505o(7835);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$20 */
    class C1693320 implements OnCancelListener {
        C1693320() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7840);
            if (!(WebViewUI.this.uwH.icE == null || WebViewUI.this.icy == null)) {
                try {
                    WebViewUI.this.icy.afo(WebViewUI.this.uwH.icE.upr);
                    WebViewUI.this.uwH.icE.cYK();
                    AppMethodBeat.m2505o(7840);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "cancel capture failed");
                }
            }
            AppMethodBeat.m2505o(7840);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$21 */
    class C1693421 implements OnMenuItemClickListener {
        C1693421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7841);
            WebViewUI.this.aqX();
            WebViewUI.this.daC();
            C4990ab.m7416i("MicroMsg.WebViewUI", "on back btn press");
            AppMethodBeat.m2505o(7841);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$27 */
    class C1693527 implements C35691a {
        C1693527() {
        }

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
            AppMethodBeat.m2504i(7849);
            try {
                if (WebViewUI.this.icy.cZd()) {
                    if (WebViewUI.this.dax() || WebViewUI.this.day()) {
                        i = WebViewUI.m26234i(WebViewUI.this);
                        if (i > 0 && i <= 4) {
                            i2 = i;
                        }
                        WebViewUI.m26216c(WebViewUI.this, i2);
                        WebViewUI.this.mo30947X(true, true);
                        if (!(WebViewUI.this.pzf == null || WebViewUI.this.icz == null || WebViewUI.this.uhz == null)) {
                            url = WebViewUI.this.pzf.getUrl();
                            if (!C5046bo.isNullOrNil(url) && WebViewUI.this.uwy.add(url)) {
                                cZT = WebViewUI.this.icz.cZT();
                                z = (cZT.vxG & 512) > 0;
                                C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
                                if (z) {
                                    C44786d c44786d = WebViewUI.this.uhz;
                                    C4990ab.m7417i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", Boolean.valueOf(c44786d.ready));
                                    if (c44786d.uFo != null && c44786d.ready) {
                                        c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:get_all_hosts", new HashMap(), c44786d.uFv, c44786d.uFw) + ")", null);
                                    }
                                }
                                z = (cZT.vxG & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0;
                                C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
                                if (z) {
                                    WebViewUI.this.uhz.mo71941ob(false);
                                    AppMethodBeat.m2505o(7849);
                                    return;
                                }
                                C22883an c22883an = WebViewUI.this.uwP;
                                if (!C5046bo.isNullOrNil(url)) {
                                    url = Uri.parse(url).getHost();
                                    if (!C5046bo.isNullOrNil(url)) {
                                        i3 = c22883an.umF.remove(url);
                                    }
                                }
                                if (i3 != 0) {
                                    WebViewUI.this.uhz.mo71941ob(true);
                                }
                            }
                        }
                        AppMethodBeat.m2505o(7849);
                        return;
                    }
                    if (C5046bo.isNullOrNil(WebViewUI.this.cOG) || !C14445a.uet.matcher(WebViewUI.this.cOG).matches()) {
                        i = WebViewUI.this.icy.mo15577gw(16384, 2);
                    } else {
                        i = WebViewUI.this.icy.mo15577gw(16388, 2);
                    }
                    i2 = i;
                    WebViewUI.m26216c(WebViewUI.this, i2);
                    WebViewUI.this.mo30947X(true, true);
                    url = WebViewUI.this.pzf.getUrl();
                    cZT = WebViewUI.this.icz.cZT();
                    if ((cZT.vxG & 512) > 0) {
                    }
                    C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
                    if (z) {
                    }
                    if ((cZT.vxG & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                    }
                    C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
                    if (z) {
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
            }
            i = 2;
            i2 = i;
            WebViewUI.m26216c(WebViewUI.this, i2);
            WebViewUI.this.mo30947X(true, true);
            url = WebViewUI.this.pzf.getUrl();
            cZT = WebViewUI.this.icz.cZT();
            if ((cZT.vxG & 512) > 0) {
            }
            C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
            if (z) {
            }
            if ((cZT.vxG & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
            }
            C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
            if (z) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$53 */
    class C1694053 implements Runnable {
        C1694053() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7882);
            C26005f.dqL();
            C37626b.dqD();
            AppMethodBeat.m2505o(7882);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$v */
    class C16941v implements C43967b {
        private final String uxR;

        private C16941v() {
            this.uxR = "weixin://openapi/openwebview/result?";
        }

        /* synthetic */ C16941v(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7971);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7971);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://openapi/openwebview/result?");
            AppMethodBeat.m2505o(7971);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7972);
            Resp resp = new Resp();
            Uri parse = Uri.parse(str);
            resp.result = parse.getQuery();
            resp.errCode = C5046bo.getInt(parse.getQueryParameter("errCode"), 0);
            resp.errStr = parse.getQueryParameter("errMsg");
            resp.transaction = WebViewUI.this.getIntent().getStringExtra("transaction_for_openapi_openwebview");
            String queryParameter = parse.getQueryParameter("appid");
            if (C5046bo.isNullOrNil(queryParameter)) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
                AppMethodBeat.m2505o(7972);
            } else {
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                C35799p.m58687at(bundle);
                Args args = new Args();
                try {
                    args.targetPkgName = WebViewUI.this.icy.afi(queryParameter);
                    args.bundle = bundle;
                    C4990ab.m7411d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", args);
                    MMessageActV2.send(WebViewUI.this, args);
                    WebViewUI.this.finish();
                    AppMethodBeat.m2505o(7972);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                    AppMethodBeat.m2505o(7972);
                }
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$x */
    class C16942x implements C43967b {
        private C16942x() {
        }

        /* synthetic */ C16942x(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7976);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7976);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://private/gethtml/");
            AppMethodBeat.m2505o(7976);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7977);
            try {
                String decode = URLDecoder.decode(str.substring(25));
                Bundle bundle = new Bundle();
                bundle.putString("nowUrl", WebViewUI.this.iCz);
                bundle.putString("tweetid", C5046bo.nullAsNil(WebViewUI.this.getIntent().getStringExtra("tweetid")));
                bundle.putString("htmlData", decode);
                bundle.putInt("type", WebViewUI.this.getIntent().getIntExtra("type", 0));
                WebViewUI.this.icy.mo15526a(3, bundle, WebViewUI.this.hashCode());
                AppMethodBeat.m2505o(7977);
                return true;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7977);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$y */
    class C16943y implements C43967b {
        private C16943y() {
        }

        /* synthetic */ C16943y(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7978);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7978);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://viewimage/");
            AppMethodBeat.m2505o(7978);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7979);
            try {
                if (WebViewUI.this.icy.isSDCardAvailable()) {
                    WebViewUI.this.iCz = str.substring(19);
                    C4990ab.m7416i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.this.iCz);
                    C30152u.m47745a(WebViewUI.this.pzf, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.this.uvA);
                    AppMethodBeat.m2505o(7979);
                    return true;
                }
                WebViewUI.this.icy.mo15526a(2, null, WebViewUI.this.hashCode());
                AppMethodBeat.m2505o(7979);
                return true;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7979);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$22 */
    class C1694422 implements Runnable {
        C1694422() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7842);
            WebViewUI.m26232h(WebViewUI.this);
            AppMethodBeat.m2505o(7842);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$32 */
    class C1694632 implements OnMenuItemClickListener {
        C1694632() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7853);
            WebViewUI.this.cZM();
            AppMethodBeat.m2505o(7853);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$33 */
    class C1694733 implements ServiceConnection {
        C1694733() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(7854);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw onServiceConnected");
            if (WebViewUI.this.pzf == null) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
                AppMethodBeat.m2505o(7854);
                return;
            }
            boolean z;
            WebViewUI.this.icy = C35624a.m58467G(iBinder);
            try {
                WebViewUI.this.icy.mo15528a(WebViewUI.this.umI, WebViewUI.this.hashCode());
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", e.getMessage());
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
            C4990ab.m7417i(str, str2, objArr);
            C40346m.uuj.icy = WebViewUI.this.icy;
            if (!C5046bo.isNullOrNil(WebViewUI.this.getIntent().getStringExtra("ad_info"))) {
                C40346m c40346m = C40346m.uuj;
                String stringExtra = WebViewUI.this.getIntent().getStringExtra("ad_info");
                String str3 = "";
                if (c40346m.icy != null) {
                    try {
                        str3 = c40346m.icy.mo15575g(23, null).getString("config_info_username");
                    } catch (RemoteException e2) {
                        C4990ab.m7413e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", e2);
                    }
                }
                c40346m.mo63714hg(stringExtra, str3);
            }
            if (WebViewUI.this.icy == null) {
                C4990ab.m7414f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
                WebViewUI.this.finish();
                AppMethodBeat.m2505o(7854);
                return;
            }
            WebViewUI.this.aMh();
            AppMethodBeat.m2505o(7854);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(7855);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
            if ((WebViewUI.this.uwA && WebViewUI.uwz <= 0) || (!WebViewUI.this.uwA && WebViewUI.uwz <= 1)) {
                C46430c.m87451c(WebViewUI.this.icy);
                C46429p cYp = C40275a.uob;
                for (int i = 0; i < cYp.unZ.size(); i++) {
                    cYp.unZ.valueAt(i);
                }
                cYp.unZ.clear();
                cYp.uoa.clear();
            }
            if (WebViewUI.this.uwA || WebViewUI.this.uwB || WebViewUI.this.isFinishing()) {
                WebViewUI.this.icy = null;
                AppMethodBeat.m2505o(7855);
                return;
            }
            C4990ab.m7416i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
            WebViewUI.m26212b(WebViewUI.this);
            AppMethodBeat.m2505o(7855);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$48 */
    class C1694848 implements DialogInterface.OnClickListener {
        C1694848() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            WebViewUI.this.uwf = null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$4 */
    class C169494 implements C9087b {
        C169494() {
        }

        /* renamed from: a */
        public final void mo20572a(C9088a c9088a, C9088a c9088a2) {
            AppMethodBeat.m2504i(7811);
            C4990ab.m7416i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + c9088a.name() + "; newOrientation:" + c9088a2.name());
            WebViewUI.this.screenOrientation = 4;
            WebViewUI.this.aBS();
            if (WebViewUI.this.uvh != null) {
                WebViewUI.this.uvh.disable();
            }
            AppMethodBeat.m2505o(7811);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$m */
    protected class C16950m {
        private int uxN = 0;

        protected C16950m() {
        }

        public final void daN() {
            AppMethodBeat.m2504i(7955);
            C4990ab.m7411d("MicroMsg.WebViewUI", "addGetA8KeySceneEndListener, before inc count=%d", Integer.valueOf(this.uxN));
            if (this.uxN == 0) {
                WebViewUI.m26221d(WebViewUI.this, (int) C31128d.MIC_PTU_MEISHI);
            }
            this.uxN++;
            AppMethodBeat.m2505o(7955);
        }

        public final void daO() {
            AppMethodBeat.m2504i(7956);
            C4990ab.m7411d("MicroMsg.WebViewUI", "removeGetA8KeySceneEndListener, before dec count=%d", Integer.valueOf(this.uxN));
            this.uxN--;
            if (this.uxN <= 0) {
                WebViewUI.m26224e(WebViewUI.this, (int) C31128d.MIC_PTU_MEISHI);
            }
            AppMethodBeat.m2505o(7956);
        }

        public final boolean daP() {
            AppMethodBeat.m2504i(7957);
            C4990ab.m7411d("MicroMsg.WebViewUI", "GetA8KeySceneEndController.hasAddListener count=%d", Integer.valueOf(this.uxN));
            if (this.uxN > 0) {
                AppMethodBeat.m2505o(7957);
                return true;
            }
            AppMethodBeat.m2505o(7957);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$o */
    protected class C16951o {
        int uxO = 0;

        protected C16951o() {
        }

        public final boolean daP() {
            return this.uxO > 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$p */
    class C16952p implements C43967b {
        private C16952p() {
        }

        /* synthetic */ C16952p(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7960);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7960);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://profile/");
            AppMethodBeat.m2505o(7960);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7961);
            String substring = str.substring(17);
            if (substring == null || substring.length() == 0) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
                AppMethodBeat.m2505o(7961);
            } else {
                if (!(WebViewUI.this.icz == null || WebViewUI.this.icz.cZS() == null || !WebViewUI.this.icz.cZS().mo69833jB(2))) {
                    WebViewUI.this.uhz.ago(substring);
                }
                AppMethodBeat.m2505o(7961);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$w */
    public enum C16953w {
        NO_NEED,
        WILL_GET,
        FAILED;

        static {
            AppMethodBeat.m2505o(7975);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$15 */
    class C1695415 implements C29963b {
        C1695415() {
        }

        public final void cWT() {
            AppMethodBeat.m2504i(7828);
            WebViewUI.m26202a(WebViewUI.this, 0);
            AppMethodBeat.m2505o(7828);
        }

        public final void cWU() {
            AppMethodBeat.m2504i(7829);
            WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) WebViewUI.this.findViewById(2131823600);
            if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.getKeyBoardHeight() > 0) {
                WebViewUI.m26202a(WebViewUI.this, webViewKeyboardLinearLayout.getKeyBoardHeight());
            }
            AppMethodBeat.m2505o(7829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$18 */
    class C1695518 implements DownloadListener {
        C1695518() {
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            int i = 1;
            AppMethodBeat.m2504i(7837);
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
            int intExtra = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
            if (!C5046bo.isNullOrNil(WebViewUI.this.getIntent().getStringExtra("key_function_id"))) {
                C7060h.pYm.mo8381e(14596, WebViewUI.this.getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(0));
            }
            if (intExtra == 1) {
                C4990ab.m7413e("MicroMsg.WebViewUI", "not allow download file : %s", str);
                AppMethodBeat.m2505o(7837);
                return;
            }
            if (str4 != null && str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                C4990ab.m7419v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", str);
                C29916g.m47392a(WebViewUI.this.icy, 11154, str);
            }
            if (WebViewUI.this.icz == null || WebViewUI.this.icz.cZS() == null) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
                AppMethodBeat.m2505o(7837);
                return;
            }
            if (str4 != null) {
                C4990ab.m7417i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", Boolean.valueOf(WebViewUI.m26230f(WebViewUI.this)));
                String afR = WebViewUI.afR(str3);
                intExtra = (afR == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", afR)) ? 0 : 1;
                boolean contains = C22986a.uFa.contains(str4.toLowerCase());
                if (!r3 || (intExtra == 0 && !contains)) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (i != 0 || WebViewUI.this.icz.cZS().mo69833jB(24) || WebViewUI.this.uvW) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                try {
                    WebViewUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(7837);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
                    AppMethodBeat.m2505o(7837);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            AppMethodBeat.m2505o(7837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$19 */
    class C1695619 implements OnTouchListener {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$19$1 */
        class C169571 implements AnimationListener {
            C169571() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(7838);
                WebViewUI.this.uvb.setVisibility(8);
                AppMethodBeat.m2505o(7838);
            }
        }

        C1695619() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(7839);
            if (WebViewUI.this.uvb != null && WebViewUI.this.uvb.getVisibility() == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, C25738R.anim.f8337b_);
                loadAnimation.setAnimationListener(new C169571());
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
                AppMethodBeat.m2505o(7839);
            } else {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW || motionEvent.getAction() == C2294a.CTRL_INDEX) {
                    if (motionEvent.getPointerCount() > 1) {
                        WebViewUI.this.pzf.getSettings().setBuiltInZoomControls(true);
                        WebViewUI.this.pzf.getSettings().setSupportZoom(true);
                    } else {
                        WebViewUI.this.pzf.getSettings().setBuiltInZoomControls(false);
                        WebViewUI.this.pzf.getSettings().setSupportZoom(false);
                    }
                }
                AppMethodBeat.m2505o(7839);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$2 */
    class C169582 implements Runnable {
        C169582() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7809);
            if (WebViewUI.this.uuX != null) {
                WebViewUI.this.uuX.finish();
                WebViewUI.this.uwI.cZJ();
            }
            AppMethodBeat.m2505o(7809);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$43 */
    class C1696043 implements C14508d {
        C1696043() {
        }

        public final void aeq(String str) {
            AppMethodBeat.m2504i(7866);
            WebViewUI.m26199a(WebViewUI.this, str, true, 9);
            AppMethodBeat.m2505o(7866);
        }

        public final void goBack() {
            AppMethodBeat.m2504i(7867);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7867);
            } else if (WebViewUI.this.uwj) {
                AppMethodBeat.m2505o(7867);
            } else if (WebViewUI.this.pzf.canGoBack() && WebViewUI.this.uvn) {
                WebViewUI.this.dai();
                AppMethodBeat.m2505o(7867);
            } else {
                C40346m.uuj.close();
                WebViewUI.this.finish();
                AppMethodBeat.m2505o(7867);
            }
        }

        /* renamed from: d */
        public final void mo26749d(OnCancelListener onCancelListener) {
            AppMethodBeat.m2504i(7868);
            if (WebViewUI.this.uxj != null) {
                WebViewUI.this.uxj.dismiss();
            }
            WebViewUI.this.uxj = C30379h.m48458b(WebViewUI.this, WebViewUI.this.getString(C25738R.string.da2), true, onCancelListener);
            AppMethodBeat.m2505o(7868);
        }

        public final void blb() {
            AppMethodBeat.m2504i(7869);
            if (WebViewUI.this.uxj != null) {
                WebViewUI.this.uxj.dismiss();
            }
            AppMethodBeat.m2505o(7869);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$44 */
    class C1696144 implements Runnable {
        C1696144() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7870);
            C26483d.m42196b(3, "WebViewUI_" + WebViewUI.this.afH(C5046bo.nullAsNil(WebViewUI.this.uwi)), WebViewUI.this.hashCode());
            AppMethodBeat.m2505o(7870);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$52 */
    class C1696252 implements C40343b {
        C1696252() {
        }

        public final String aYj() {
            AppMethodBeat.m2504i(7881);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7881);
                return null;
            }
            String url = WebViewUI.this.pzf.getUrl();
            AppMethodBeat.m2505o(7881);
            return url;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$8 */
    class C169648 implements OnClickListener {
        C169648() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7815);
            WebViewUI.this.cZM();
            AppMethodBeat.m2505o(7815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$a */
    class C16965a implements C43967b {
        private C16965a() {
        }

        /* synthetic */ C16965a(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7885);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7885);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://jump/");
            AppMethodBeat.m2505o(7885);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7886);
            if (WebViewUI.this.icz.cZT().dmk()) {
                try {
                    WebViewUI.this.icy.mo15552bG(str, WebViewUI.this.icz.cZS().mo69833jB(7));
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
                }
                AppMethodBeat.m2505o(7886);
            } else {
                C4990ab.m7413e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", str);
                AppMethodBeat.m2505o(7886);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$b */
    class C16966b implements C43967b {
        public final String uxA;

        private C16966b() {
            this.uxA = "weixin://addfriend/";
        }

        /* synthetic */ C16966b(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7887);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7887);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://addfriend/");
            AppMethodBeat.m2505o(7887);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7888);
            if (WebViewUI.this.icz.cZS().mo69833jB(5)) {
                String substring = str.substring(19);
                if (C5046bo.isNullOrNil(substring)) {
                    AppMethodBeat.m2505o(7888);
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_webview", true);
                bundle.putString("userName", substring);
                try {
                    WebViewUI.this.icy.mo15526a(8, bundle, WebViewUI.this.hashCode());
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                }
                AppMethodBeat.m2505o(7888);
                return true;
            }
            C4990ab.m7412e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
            AppMethodBeat.m2505o(7888);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$d */
    protected static final class C16967d {
        private String lang;
        private String ujA;
        private String ujB;
        private String ujC;
        private String ujD;
        private String ujE;
        private String ujz;
        private String uxB;

        private C16967d(Bundle bundle) {
            AppMethodBeat.m2504i(7891);
            this.uxB = bundle.getString("close_window_confirm_dialog_switch");
            this.ujz = bundle.getString("close_window_confirm_dialog_title_cn");
            this.ujA = bundle.getString("close_window_confirm_dialog_title_eng");
            this.ujB = bundle.getString("close_window_confirm_dialog_ok_cn");
            this.ujC = bundle.getString("close_window_confirm_dialog_ok_eng");
            this.ujD = bundle.getString("close_window_confirm_dialog_cancel_cn");
            this.ujE = bundle.getString("close_window_confirm_dialog_cancel_eng");
            this.lang = bundle.getString("application_language");
            AppMethodBeat.m2505o(7891);
        }

        /* renamed from: ad */
        public static C16967d m26292ad(Bundle bundle) {
            AppMethodBeat.m2504i(7892);
            C16967d c16967d = new C16967d(bundle);
            AppMethodBeat.m2505o(7892);
            return c16967d;
        }

        public final boolean cXi() {
            AppMethodBeat.m2504i(7893);
            if (C5046bo.isNullOrNil(this.uxB)) {
                AppMethodBeat.m2505o(7893);
                return false;
            }
            boolean equals = this.uxB.equals("true");
            AppMethodBeat.m2505o(7893);
            return equals;
        }

        public final String daM() {
            AppMethodBeat.m2504i(7894);
            String str;
            if ("zh_CN".equals(this.lang)) {
                str = this.ujz;
                AppMethodBeat.m2505o(7894);
                return str;
            }
            str = this.ujA;
            AppMethodBeat.m2505o(7894);
            return str;
        }

        public final String cXk() {
            AppMethodBeat.m2504i(7895);
            String str;
            if ("zh_CN".equals(this.lang)) {
                str = this.ujB;
                AppMethodBeat.m2505o(7895);
                return str;
            }
            str = this.ujC;
            AppMethodBeat.m2505o(7895);
            return str;
        }

        public final String cXl() {
            AppMethodBeat.m2504i(7896);
            String str;
            if ("zh_CN".equals(this.lang)) {
                str = this.ujD;
                AppMethodBeat.m2505o(7896);
                return str;
            }
            str = this.ujE;
            AppMethodBeat.m2505o(7896);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$5 */
    class C169685 implements C35692a {
        C169685() {
        }

        public final void cZV() {
            AppMethodBeat.m2504i(7812);
            C4990ab.m7410d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
            if (WebViewUI.this.uhz != null) {
                C44786d c44786d = WebViewUI.this.uhz;
                if (c44786d.ready) {
                    C4990ab.m7416i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                    C5004al.m7441d(new C2994057(C44786d.agr(C23124a.m35500b("onPullDownRefresh", null, c44786d.uFv, c44786d.uFw))));
                } else {
                    C4990ab.m7412e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
                    AppMethodBeat.m2505o(7812);
                    return;
                }
            }
            AppMethodBeat.m2505o(7812);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$12 */
    class C1696912 implements C36591r {
        C1696912() {
        }

        /* renamed from: A */
        public final boolean mo31055A(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(7819);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7819);
                return false;
            }
            boolean Q = WebViewUI.this.pzf.mo49216Q(motionEvent);
            AppMethodBeat.m2505o(7819);
            return Q;
        }

        /* renamed from: b */
        public final boolean mo31059b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.m2504i(7820);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7820);
                return false;
            }
            C14510a cXY = WebViewUI.this.ulI.cXY();
            if (i4 > cXY.una) {
                cXY.una = i4;
            }
            cXY.rCb = i6;
            boolean c = WebViewUI.this.pzf.mo49221c(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.m2505o(7820);
            return c;
        }

        public final void aGs() {
            AppMethodBeat.m2504i(7821);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7821);
                return;
            }
            WebViewUI.this.pzf.dKK();
            AppMethodBeat.m2505o(7821);
        }

        @TargetApi(9)
        /* renamed from: d */
        public final void mo31060d(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(7822);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7822);
                return;
            }
            WebViewUI.this.pzf.mo49227e(i, i2, z, z2);
            if (z2 && WebViewUI.this.ulI != null) {
                WebViewUI.this.ulI.mo63618q("mm_scroll_bottom", Boolean.TRUE);
            }
            AppMethodBeat.m2505o(7822);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(7823);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7823);
                return;
            }
            WebViewUI.this.pzf.mo49215M(i, i2, i3, i4);
            WebViewUI.this.onWebViewScrollChanged(i, i2, i3, i4);
            AppMethodBeat.m2505o(7823);
        }

        /* renamed from: B */
        public final boolean mo31056B(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(7824);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7824);
                return false;
            }
            boolean R = WebViewUI.this.pzf.mo49217R(motionEvent);
            AppMethodBeat.m2505o(7824);
            return R;
        }

        /* renamed from: C */
        public final boolean mo31057C(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(7825);
            if (WebViewUI.this.pzf == null) {
                AppMethodBeat.m2505o(7825);
                return false;
            }
            boolean S = WebViewUI.this.pzf.mo49218S(motionEvent);
            AppMethodBeat.m2505o(7825);
            return S;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$25 */
    class C1697025 implements OnLongClickListener {
        C1697025() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(7846);
            if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                boolean daL = daL();
                AppMethodBeat.m2505o(7846);
                return daL;
            }
            AppMethodBeat.m2505o(7846);
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
            AppMethodBeat.m2504i(7847);
            C41116b c41116b = null;
            try {
                c41116b = WebViewUI.this.pzf.getHitTestResult();
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.WebViewUI", "getHitTestResult exp %s", e2.getMessage());
            }
            if (c41116b == null || C5046bo.isNullOrNil(c41116b.mExtra)) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
                AppMethodBeat.m2505o(7847);
                return false;
            }
            try {
                dq = WebViewUI.this.icy.mo15573dq(c41116b.mExtra);
                if (dq) {
                    try {
                        WebViewUI.this.icy.mo15570dB(c41116b.mExtra, WebViewUI.this.hashCode());
                    } catch (Exception e3) {
                        e = e3;
                        C4990ab.m7420w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                        z = dq;
                        if (z) {
                        }
                        AppMethodBeat.m2505o(7847);
                        return z2;
                    }
                }
                z = dq;
            } catch (Exception e4) {
                e = e4;
                dq = true;
            }
            if (z) {
                WebViewUI.m26214b(WebViewUI.this, c41116b.mExtra);
            } else {
                z2 = z;
            }
            AppMethodBeat.m2505o(7847);
            return z2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$31 */
    class C1697131 implements OnMenuItemClickListener {
        C1697131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7852);
            Intent intent = new Intent();
            intent.setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
            intent.putExtra("entry_fix_tools", 1);
            WebViewUI.this.startActivity(intent);
            AppMethodBeat.m2505o(7852);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$38 */
    class C1697238 implements OnClickListener {
        C1697238() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7861);
            WebViewUI.m26243o(WebViewUI.this);
            AppMethodBeat.m2505o(7861);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$45 */
    class C1697345 implements C14507b {
        private Map<Integer, Integer> uxx = new HashMap();

        C1697345() {
            AppMethodBeat.m2504i(7871);
            AppMethodBeat.m2505o(7871);
        }

        public final void add(int i) {
            AppMethodBeat.m2504i(7872);
            WebViewUI.m26221d(WebViewUI.this, i);
            if (this.uxx.containsKey(Integer.valueOf(i))) {
                this.uxx.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.uxx.get(Integer.valueOf(i))).intValue() + 1));
                AppMethodBeat.m2505o(7872);
                return;
            }
            this.uxx.put(Integer.valueOf(i), Integer.valueOf(1));
            AppMethodBeat.m2505o(7872);
        }

        public final void remove(int i) {
            AppMethodBeat.m2504i(7873);
            WebViewUI.m26224e(WebViewUI.this, i);
            if (this.uxx.containsKey(Integer.valueOf(i))) {
                this.uxx.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.uxx.get(Integer.valueOf(i))).intValue() - 1));
                AppMethodBeat.m2505o(7873);
                return;
            }
            this.uxx.put(Integer.valueOf(i), Integer.valueOf(0));
            AppMethodBeat.m2505o(7873);
        }

        public final boolean cXH() {
            AppMethodBeat.m2504i(7874);
            for (Entry value : this.uxx.entrySet()) {
                if (((Integer) value.getValue()).intValue() > 0) {
                    AppMethodBeat.m2505o(7874);
                    return true;
                }
            }
            AppMethodBeat.m2505o(7874);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$6 */
    class C169746 implements ValueCallback<String> {
        C169746() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(7813);
            String str = (String) obj;
            C4990ab.m7411d("MicroMsg.WebViewUI", "get background color s = %s", str);
            if (!C5046bo.isNullOrNil(str)) {
                int color = WebViewUI.this.getResources().getColor(C25738R.color.a5v);
                String[] split;
                if (WebViewUI.uiv.matcher(str).matches()) {
                    split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                    if (split.length == 4) {
                        try {
                            color = Color.argb(C5046bo.getInt(C5046bo.nullAsNil(split[3]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[0]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[1]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[2]).trim(), 0));
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", str, e);
                            AppMethodBeat.m2505o(7813);
                            return;
                        }
                    }
                } else if (WebViewUI.uiw.matcher(str).matches()) {
                    split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                    if (split.length == 3) {
                        try {
                            color = Color.argb(255, C5046bo.getInt(C5046bo.nullAsNil(split[0]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[1]).trim(), 0), C5046bo.getInt(C5046bo.nullAsNil(split[2]).trim(), 0));
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", str, e2);
                            AppMethodBeat.m2505o(7813);
                            return;
                        }
                    }
                } else {
                    C4990ab.m7411d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", str);
                }
                WebViewUI.this.uwX.mo69666Jp(color);
            }
            AppMethodBeat.m2505o(7813);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$j */
    class C16976j implements C4653a {
        private C16976j() {
        }

        /* synthetic */ C16976j(WebViewUI webViewUI, byte b) {
            this();
        }

        /* renamed from: Cl */
        public final void mo9748Cl(int i) {
            int i2 = 2;
            AppMethodBeat.m2504i(7948);
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
            WebViewUI.m26216c(WebViewUI.this, i2);
            try {
                if (WebViewUI.this.icy.cZd()) {
                    WebViewUI.this.icy.mo15578gx(16384, i2);
                    WebViewUI.this.icy.mo15578gx(16388, i2);
                }
                AppMethodBeat.m2505o(7948);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7948);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$l */
    public static class C16977l {
        private static final Pattern hnu = Pattern.compile(".*#.*wechat_redirect");
        public String jVi = null;
        private LinkedList<String> uxM = new LinkedList();
        String[] uxa = null;

        static {
            AppMethodBeat.m2504i(7954);
            AppMethodBeat.m2505o(7954);
        }

        public C16977l(String str) {
            AppMethodBeat.m2504i(7951);
            this.jVi = str;
            AppMethodBeat.m2505o(7951);
        }

        public final int ael(String str) {
            AppMethodBeat.m2504i(7952);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "getReason fail, url is null");
                AppMethodBeat.m2505o(7952);
                return 0;
            } else if (str.equals(this.jVi)) {
                AppMethodBeat.m2505o(7952);
                return 0;
            } else if (hnu.matcher(str).find()) {
                AppMethodBeat.m2505o(7952);
                return 2;
            } else if (afW(str)) {
                AppMethodBeat.m2505o(7952);
                return 8;
            } else {
                AppMethodBeat.m2505o(7952);
                return 1;
            }
        }

        private boolean afW(String str) {
            AppMethodBeat.m2504i(7953);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7953);
                return false;
            } else if (this.uxa == null || this.uxa.length == 0) {
                AppMethodBeat.m2505o(7953);
                return false;
            } else if (this.uxM.contains(str)) {
                AppMethodBeat.m2505o(7953);
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
                C4990ab.m7417i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", str, substring);
                for (String str2 : this.uxa) {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "force geta8key path = %s", str2);
                    if (substring.startsWith(r4[r3])) {
                        this.uxM.add(str);
                        AppMethodBeat.m2505o(7953);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(7953);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$s */
    class C16978s implements C43967b {
        private C16978s() {
        }

        /* synthetic */ C16978s(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7964);
            C46434d c46434d = WebViewUI.this.icy;
            if (6 == WebViewUI.this.getIntent().getIntExtra("geta8key_scene", 0)) {
                C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
            } else if (!C5046bo.isNullOrNil(str) && c46434d != null && C29814c.m47269a(c46434d) && C29814c.m47270a(str, c46434d)) {
                AppMethodBeat.m2505o(7964);
                return true;
            }
            AppMethodBeat.m2505o(7964);
            return false;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7965);
            String stringExtra = WebViewUI.this.getIntent().getStringExtra("geta8key_username");
            boolean a = C29814c.m47271a(str, stringExtra, WebViewUI.this.afH(stringExtra), WebViewUI.this.icy, WebViewUI.this.uxk, WebViewUI.this.uxl, WebViewUI.this.hashCode());
            AppMethodBeat.m2505o(7965);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$z */
    static final class C16979z {
        final WeakReference<WebViewUI> hiC;
        /* renamed from: id */
        final int f3579id;

        public C16979z(WebViewUI webViewUI) {
            AppMethodBeat.m2504i(7980);
            this.hiC = new WeakReference(webViewUI);
            this.f3579id = webViewUI.hashCode();
            AppMethodBeat.m2505o(7980);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$23 */
    class C1698023 extends C4884c<C42040qg> {
        C1698023() {
            AppMethodBeat.m2504i(7843);
            this.xxI = C42040qg.class.getName().hashCode();
            AppMethodBeat.m2505o(7843);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(7845);
            boolean daK = daK();
            AppMethodBeat.m2505o(7845);
            return daK;
        }

        private boolean daK() {
            AppMethodBeat.m2504i(7844);
            if (WebViewUI.this.icy == null) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
                AppMethodBeat.m2505o(7844);
            } else if (WebViewUI.this.uwM == null || WebViewUI.this.uwM.length() == 0) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "Cli Event, tid is null");
                AppMethodBeat.m2505o(7844);
            } else {
                try {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", WebViewUI.this.uwM, Long.valueOf(WebViewUI.this.uwN), Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("service_click_tid", new String(WebViewUI.this.uwM));
                    bundle.putLong("service_click_stime", WebViewUI.this.uwN);
                    bundle.putLong("service_click_etime", r0);
                    WebViewUI.this.icy.mo15590s(2836, bundle);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", e.getMessage());
                }
                WebViewUI.this.uwM = null;
                AppMethodBeat.m2505o(7844);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$24 */
    class C1698124 implements OnLongClickListener {
        C1698124() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$30 */
    class C1698230 implements OnLongClickListener {
        C1698230() {
        }

        public final boolean onLongClick(View view) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$39 */
    class C1698339 implements OnClickListener {
        C1698339() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7862);
            if (WebViewUI.this.pzf != null) {
                WebViewUI.this.uvo = System.currentTimeMillis();
                WebViewUI.this.pzf.goBack();
                WebViewUI.this.uvC = null;
            }
            AppMethodBeat.m2505o(7862);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$11 */
    class C1698411 implements C29857a {
        C1698411() {
        }

        public final void cZy() {
            AppMethodBeat.m2504i(7818);
            if (WebViewUI.this.pzf.getIsX5Kernel()) {
                C22884i cYb = WebViewUI.this.ulI.cYb();
                cYb.une = new Object[]{WebViewUI.this.cOG, Integer.valueOf(10)};
                cYb.mo38482b(WebViewUI.this.icy);
            }
            AppMethodBeat.m2505o(7818);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$c */
    class C16985c implements C43967b {
        private C16985c() {
        }

        /* synthetic */ C16985c(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7889);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7889);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://webview/close/");
            AppMethodBeat.m2505o(7889);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7890);
            if (WebViewUI.this.icz.cZS().mo69833jB(17)) {
                WebViewUI.this.finish();
                AppMethodBeat.m2505o(7890);
            } else {
                C4990ab.m7412e("MicroMsg.WebViewUI", "close window permission fail");
                AppMethodBeat.m2505o(7890);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$t */
    class C16986t implements C43967b {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$t$1 */
        class C169871 implements C30391c {
            C169871() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(7966);
                if (i == 0) {
                    C16986t c16986t = C16986t.this;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("shortUrl", WebViewUI.this.getIntent().getStringExtra("shortUrl"));
                        bundle.putInt("type", WebViewUI.this.getIntent().getIntExtra("type", 0));
                        WebViewUI.this.icy.mo15526a(4, bundle, c16986t.hashCode());
                        AppMethodBeat.m2505o(7966);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(7966);
            }
        }

        private C16986t() {
        }

        /* synthetic */ C16986t(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7967);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7967);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://readershare/");
            AppMethodBeat.m2505o(7967);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7968);
            C30379h.m48422a(WebViewUI.this, "", new String[]{WebViewUI.this.getString(C25738R.string.di1)}, "", new C169871());
            AppMethodBeat.m2505o(7968);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$u */
    class C16988u implements C43967b {
        private C16988u() {
        }

        /* synthetic */ C16988u(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7969);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7969);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://recommend_update/");
            AppMethodBeat.m2505o(7969);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7970);
            C7060h.pYm.mo8378a(405, 24, 1, true);
            WebViewUI.m26229f(WebViewUI.this, 2);
            AppMethodBeat.m2505o(7970);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$10 */
    class C1698910 implements OnClickListener {
        C1698910() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(7817);
            WebViewUI.this.mo30966as(WebViewUI.this.uvC, true);
            C22884i cYb = WebViewUI.this.ulI.cYb();
            cYb.une = new Object[]{WebViewUI.this.cOG, Integer.valueOf(4)};
            cYb.mo38482b(WebViewUI.this.icy);
            AppMethodBeat.m2505o(7817);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$13 */
    class C1699013 implements C35728c {
        C1699013() {
        }

        public final void aee(String str) {
            AppMethodBeat.m2504i(7826);
            WebViewUI.m26204a(WebViewUI.this, str);
            AppMethodBeat.m2505o(7826);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$26 */
    class C1699126 implements Runnable {
        C1699126() {
        }

        public final void run() {
            AppMethodBeat.m2504i(7848);
            WebViewUI.this.pzf.getCurWebviewClient().mo5992b(WebViewUI.this.pzf, WebViewUI.this.pzf.getUrl());
            AppMethodBeat.m2505o(7848);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$37 */
    class C1699237 implements C5015a {
        C1699237() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(7860);
            WebViewUI.m26243o(WebViewUI.this);
            AppMethodBeat.m2505o(7860);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$50 */
    class C1699450 implements DialogInterface.OnClickListener {
        C1699450() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(7879);
            WebViewUI.this.uwA = true;
            C40346m.uuj.close();
            WebViewUI.this.finish();
            AppMethodBeat.m2505o(7879);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$i */
    class C16995i implements C43967b {
        private final String uxL;

        private C16995i() {
            this.uxL = "weixin://feedback/";
        }

        /* synthetic */ C16995i(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7946);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7946);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://feedback/");
            AppMethodBeat.m2505o(7946);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7947);
            Bundle bundle = new Bundle();
            bundle.putInt(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
            bundle.putInt(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            try {
                WebViewUI.this.icy.mo15526a(7, bundle, WebViewUI.this.hashCode());
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            AppMethodBeat.m2505o(7947);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$k */
    class C16996k implements C43967b {
        private C16996k() {
        }

        /* synthetic */ C16996k(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7949);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7949);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://connectToFreeWifi/");
            AppMethodBeat.m2505o(7949);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7950);
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            C4990ab.m7417i("MicroMsg.WebViewUI", "apKey value = %s", queryParameter);
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!C5046bo.isNullOrNil(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!C5046bo.isNullOrNil(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                C25985d.m41467b(C4996ah.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            AppMethodBeat.m2505o(7950);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewUI$r */
    class C16997r implements C43967b {
        private C16997r() {
        }

        /* synthetic */ C16997r(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean afS(String str) {
            AppMethodBeat.m2504i(7962);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(7962);
                return false;
            }
            boolean t = C30152u.m47751t(str, "weixin://manual_update/");
            AppMethodBeat.m2505o(7962);
            return t;
        }

        public final boolean afM(String str) {
            AppMethodBeat.m2504i(7963);
            C7060h.pYm.mo8378a(405, 26, 1, true);
            WebViewUI.m26229f(WebViewUI.this, 3);
            AppMethodBeat.m2505o(7963);
            return true;
        }
    }

    public WebViewUI() {
        AppMethodBeat.m2504i(7981);
        AppMethodBeat.m2505o(7981);
    }

    /* renamed from: A */
    static /* synthetic */ boolean m26170A(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8127);
        boolean dav = webViewUI.dav();
        AppMethodBeat.m2505o(8127);
        return dav;
    }

    /* renamed from: J */
    static /* synthetic */ void m26180J(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8128);
        webViewUI.daA();
        AppMethodBeat.m2505o(8128);
    }

    static /* synthetic */ String afR(String str) {
        AppMethodBeat.m2504i(8113);
        String afJ = WebViewUI.afJ(str);
        AppMethodBeat.m2505o(8113);
        return afJ;
    }

    /* renamed from: eq */
    static /* synthetic */ void m26227eq(View view) {
        AppMethodBeat.m2504i(8108);
        WebViewUI.m26211af(view, 5894);
        AppMethodBeat.m2505o(8108);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m26230f(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8112);
        boolean cZs = webViewUI.cZs();
        AppMethodBeat.m2505o(8112);
        return cZs;
    }

    /* renamed from: i */
    static /* synthetic */ int m26234i(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8116);
        int daz = webViewUI.daz();
        AppMethodBeat.m2505o(8116);
        return daz;
    }

    /* renamed from: k */
    static /* synthetic */ void m26237k(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8119);
        webViewUI.dah();
        AppMethodBeat.m2505o(8119);
    }

    /* renamed from: o */
    static /* synthetic */ void m26243o(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8122);
        webViewUI.dau();
        AppMethodBeat.m2505o(8122);
    }

    /* renamed from: r */
    static /* synthetic */ int m26246r(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8124);
        int daa = webViewUI.daa();
        AppMethodBeat.m2505o(8124);
        return daa;
    }

    static {
        AppMethodBeat.m2504i(8134);
        HashSet hashSet = new HashSet();
        ums = hashSet;
        hashSet.add("file:///android_asset/");
        String str = C6457e.eSk;
        if (!C5046bo.isNullOrNil(str)) {
            str = C6457e.eSk.replace("/data/user/0", "/data/data");
        }
        ums.add("file://" + new File(C46400aa.m87310Ia(0)).getAbsolutePath());
        ums.add("file://" + new File(C6457e.eSn, "fts/res").getAbsolutePath());
        ums.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        ums.add("file://" + new File(C6457e.eSn, "wenote/res").getAbsolutePath());
        ums.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        C4990ab.m7417i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath());
        ums.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        ums.add("file://" + new File(C6457e.eSn, "emoji/res").getAbsolutePath());
        C4990ab.m7417i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r1.getAbsolutePath(), r0.getAbsolutePath());
        ums.add("file://" + new File(C46400aa.m87310Ia(1)).getAbsolutePath());
        ums.add("file://" + new File(C6457e.eSn, "fts_browse/res").getAbsolutePath());
        C4990ab.m7417i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", r0.getAbsolutePath(), r1.getAbsolutePath());
        Iterator it = ums.iterator();
        while (it.hasNext()) {
            C4990ab.m7417i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", (String) it.next());
        }
        AppMethodBeat.m2505o(8134);
    }

    public final C44781d cZW() {
        return this.uwE;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo30969b(String str, String str2, Map<String, String> map) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: FY */
    public void mo30940FY(String str) {
        AppMethodBeat.m2504i(7982);
        C4990ab.m7417i("MicroMsg.WebViewUI", "[notifyPageInfo]pageInfo:%s", str);
        AppMethodBeat.m2505o(7982);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ab */
    public void mo9701ab(Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public boolean aMj() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ac */
    public void mo30958ac(Bundle bundle) {
        int color;
        int i;
        AppMethodBeat.m2504i(7983);
        if (bundle.getBoolean("set_navigation_bar_color_reset", false)) {
            color = this.uwO == null ? getResources().getColor(C25738R.color.a5s) : this.uwO.daW();
            i = 255;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        mo17446xE((color & 16777215) | (i << 24));
        AppMethodBeat.m2505o(7983);
    }

    /* renamed from: xE */
    public final void mo17446xE(int i) {
        AppMethodBeat.m2504i(7984);
        super.mo17446xE(i);
        if (this.uwl) {
            setStatusBarColor(i);
        }
        AppMethodBeat.m2505o(7984);
    }

    public void initSwipeBack() {
        AppMethodBeat.m2504i(7985);
        super.initSwipeBack();
        if (getSwipeBackLayout() == null) {
            AppMethodBeat.m2505o(7985);
        } else if (this.uwl) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            C7355b c7355b = new C7355b(this);
            if (childAt instanceof FrameLayout) {
                View childAt2 = ((FrameLayout) childAt).getChildAt(0);
                LayoutParams layoutParams = childAt2.getLayoutParams();
                ((FrameLayout) childAt).removeView(childAt2);
                c7355b.addView(childAt2, layoutParams);
            } else {
                c7355b.addView(childAt);
            }
            getSwipeBackLayout().addView(c7355b);
            getSwipeBackLayout().setContentView(c7355b);
            this.uwm = true;
            AppMethodBeat.m2505o(7985);
        } else {
            AppMethodBeat.m2505o(7985);
        }
    }

    /* renamed from: nN */
    private void m26241nN(boolean z) {
        if (!z) {
            this.uvL = true;
        }
    }

    public void onResume() {
        Bundle bundle;
        AppMethodBeat.m2504i(7986);
        super.onResume();
        if (dae() != null) {
            C43867e.m78659h(dae(), this);
        } else {
            C43867e.m78659h(cWL(), this);
        }
        this.ulI.cXX().lastResumeTime = C5046bo.m7588yz();
        this.ulI.cXY().lastResumeTime = C5046bo.m7588yz();
        C40346m c40346m = C40346m.uuj;
        C4990ab.m7419v("MicroMsg.WebViewReportUtil", "onResume traceid %s", c40346m.qTK);
        if (!C5046bo.isNullOrNil(c40346m.qTK)) {
            c40346m.mo63715kT(7);
        }
        if (!this.uwS) {
            int hashCode = hashCode();
            for (int size = uvK.size() - 1; size >= 0; size--) {
                if (((C16979z) uvK.get(size)).f3579id == hashCode) {
                    uvK.remove(size);
                    break;
                }
            }
            uvK.add(new C16979z(this));
        }
        this.uwS = false;
        if (this.uvL) {
            m26241nN(true);
            this.uvL = false;
        }
        dak();
        if (this.icy != null) {
            try {
                bundle = new Bundle();
                bundle.putInt("screen_orientation", this.screenOrientation);
                this.icy.mo15575g(83, bundle);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e.getMessage());
            }
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        m26179IB("onResume");
        try {
            if (this.icy != null) {
                bundle = this.icy.mo15575g(19, null);
                if (bundle != null) {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "onResume, has init = %b", Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")));
                    if (bundle.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "notify app tofront failed : %s", e2.getMessage());
        }
        this.oes = C5046bo.anT();
        this.uwF.aNS().mo10302aa(new C1696144());
        if (this.uwD) {
            finish();
        }
        AppMethodBeat.m2505o(7986);
    }

    public void onPause() {
        AppMethodBeat.m2504i(7987);
        super.onPause();
        C26483d.m42196b(4, "WebViewUI_" + afH(C5046bo.nullAsNil(this.uwi)), hashCode());
        C26483d.m42198h("WebViewUI_" + afH(C5046bo.nullAsNil(this.uwi)), this.oes, C5046bo.anT());
        C40261l cXX = this.ulI.cXX();
        if (cXX.lastResumeTime != -1) {
            cXX.iBA += C5046bo.m7525az(cXX.lastResumeTime) / 1000;
        }
        C14510a cXY = this.ulI.cXY();
        if (cXY.lastResumeTime != -1) {
            cXY.iBA += C5046bo.m7525az(cXY.lastResumeTime);
        }
        C40346m c40346m = C40346m.uuj;
        C4990ab.m7419v("MicroMsg.WebViewReportUtil", "onPause traceid %s", c40346m.qTK);
        if (c40346m.foa) {
            C4990ab.m7416i("MicroMsg.WebViewReportUtil", "isFinish is true");
        } else if (!C5046bo.isNullOrNil(c40346m.qTK)) {
            c40346m.mo63715kT(6);
        }
        try {
            if (this.icy != null) {
                Bundle g = this.icy.mo15575g(19, null);
                if (g != null) {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "onPause, has init = %b", Boolean.valueOf(g.getBoolean("webview_video_proxy_init")));
                    if (g.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "notify app toback failed : %s", e.getMessage());
        }
        dau();
        m26179IB("onPause");
        if (this.uvO != null) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.uvO.onHideCustomView();
                AppMethodBeat.m2505o(7987);
                return;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e2, "onPause", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(7987);
    }

    public void finish() {
        AppMethodBeat.m2504i(7988);
        if (this.uvt) {
            setResult(-1);
        }
        try {
            if (this.icy != null) {
                this.icy.mo15519Jc(hashCode());
                this.icy.mo15515IP(hashCode());
                this.umI = null;
            }
            C4990ab.m7420w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(e)));
        }
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.uwB = true;
        super.finish();
        AppMethodBeat.m2505o(7988);
    }

    public int getLayoutId() {
        return 2130971207;
    }

    public boolean convertActivityFromTranslucent() {
        AppMethodBeat.m2504i(7989);
        boolean booleanExtra = getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
        AppMethodBeat.m2505o(7989);
        return booleanExtra;
    }

    public void setMMTitle(String str) {
        AppMethodBeat.m2504i(7990);
        if (this.uvx) {
            super.setMMTitle((int) C25738R.string.fz6);
            AppMethodBeat.m2505o(7990);
            return;
        }
        super.setMMTitle(str);
        AppMethodBeat.m2505o(7990);
    }

    /* renamed from: M */
    public final void mo17368M(CharSequence charSequence) {
        AppMethodBeat.m2504i(7991);
        if (this.uvx) {
            super.setMMTitle((int) C25738R.string.fz6);
            AppMethodBeat.m2505o(7991);
            return;
        }
        super.mo17368M(charSequence);
        AppMethodBeat.m2505o(7991);
    }

    /* renamed from: IB */
    private void m26179IB(String str) {
        AppMethodBeat.m2504i(7992);
        if (this.uhz != null) {
            this.uhz.agn(str);
            try {
                if (str.equals("onPause")) {
                    this.icy.mo15521Je(hashCode());
                    AppMethodBeat.m2505o(7992);
                    return;
                }
                if (str.equals("onResume")) {
                    this.icy.mo15520Jd(hashCode());
                }
                AppMethodBeat.m2505o(7992);
                return;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "onResume, ex = " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(7992);
    }

    /* Access modifiers changed, original: protected */
    public boolean cZA() {
        return false;
    }

    private void cZX() {
        AppMethodBeat.m2504i(7993);
        this.uwE.mo69758aI("onTryBindServiceStart", System.currentTimeMillis());
        C4990ab.m7416i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.ktl, 1);
        this.uwE.mo69758aI("onTryBindServiceEnd", System.currentTimeMillis());
        AppMethodBeat.m2505o(7993);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        AppMethodBeat.m2504i(7994);
        C43923d c43923d = this.icH;
        if (c43923d.uoE == null) {
            c43923d.cYx();
        } else {
            if (C31128d.MIC_AVROUND_BLUR == i) {
                if (iArr[0] == 0) {
                    Intent intent = (Intent) c43923d.uoE.first;
                    int intValue = ((Integer) c43923d.uoE.second).intValue();
                    c43923d.uoE = null;
                    startActivityForResult(intent, intValue);
                } else {
                    c43923d.uoE = null;
                    c43923d.mo69605b(this, 0, null);
                }
            }
            i2 = 1;
        }
        if (i2 != 0) {
            AppMethodBeat.m2505o(7994);
        } else {
            AppMethodBeat.m2505o(7994);
        }
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(7995);
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
        AppMethodBeat.m2505o(7995);
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
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r0) == false) goto L_0x0123;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        Integer valueOf;
        Bundle bundle2;
        boolean z;
        String str;
        AppMethodBeat.m2504i(7996);
        C44781d c44781d = this.uwE;
        c44781d.startTime = System.currentTimeMillis();
        c44781d.mo69758aI("onCreate", c44781d.startTime);
        if (this.uwl) {
            this.yll = false;
        }
        super.onCreate(bundle);
        this.uwE.mo69758aI("onUIInitStart", System.currentTimeMillis());
        C4990ab.m7416i("MicroMsg.WebViewUI", "onCreate" + hashCode());
        this.umI = new C35698n(this);
        this.uwH = new C46444i(this);
        this.uwI = new C40326j(this);
        C43867e.m78659h(cWL(), this);
        this.uwO = new C23144o(this);
        C23144o c23144o = this.uwO;
        if (c23144o.uxX != null) {
            if (c23144o.daQ()) {
                c23144o.uxW = true;
            } else {
                c23144o.uxW = false;
            }
            C4990ab.m7417i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", c23144o.uxX, Boolean.valueOf(c23144o.uxW));
        }
        this.uxb = true;
        this.uvB = getIntent().getIntExtra("geta8key_session_id", (int) System.currentTimeMillis());
        this.uvD = getIntent().getByteArrayExtra("geta8key_cookie");
        this.uvm = cWL();
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.uvz = getIntent().getBooleanExtra("from_shortcut", false);
        this.uvq = getIntent().getIntExtra(C5506m.ygo, -1);
        this.nft = getIntent().getStringExtra("status_bar_style");
        this.nfs = getIntent().getIntExtra("customize_status_bar_color", 0);
        String stringExtra = getIntent() == null ? "" : getIntent().getStringExtra("custom_action_bar_color");
        C4990ab.m7417i("MicroMsg.WebViewUI", "initCustomActionBarColorIfNeed isNativeStyle is %b", Boolean.valueOf(getIntent() == null ? false : getIntent().getBooleanExtra("open_custom_style_url", false)));
        if (getIntent() == null ? false : getIntent().getBooleanExtra("open_custom_style_url", false)) {
            stringExtra = "white";
            mo30943Jt(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
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
            mo30958ac(bundle2);
            if (!getIntent().hasExtra("customize_status_bar_color")) {
                this.nfs = valueOf.intValue();
            }
        }
        this.cOG = cWL();
        this.uwp = getIntent().getBooleanExtra("show_native_web_view", false);
        this.uvl = getIntent().getBooleanExtra("key_trust_url", false);
        uwz++;
        uvK.add(new C16979z(this));
        if (uvK.size() > 1) {
            ArrayList arrayList = uvK;
            C16979z c16979z = (C16979z) arrayList.get(arrayList.size() - 2);
            if (!(c16979z.hiC == null || c16979z.hiC.get() == null)) {
                ((WebViewUI) c16979z.hiC.get()).m26241nN(false);
            }
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "initView trust:%b, rawUrl = %s ", Boolean.valueOf(this.uvl), this.cOG);
        this.cMm = C5046bo.nullAsNil(getIntent().getStringExtra("KPublisherId"));
        this.cSQ = afH(getIntent().getStringExtra("geta8key_username"));
        C22886o cXT = this.ulI.cXT();
        int i = this.cSQ;
        String str2 = this.cMm;
        cXT.cSQ = i;
        cXT.uni = str2;
        this.handler = new C7306ak();
        if (this.ulI != null) {
            C40259aq c40259aq = this.ulI;
            bundle2 = getIntent().getBundleExtra("mm_report_bundle");
            if (bundle2 != null) {
                if (c40259aq.umW != null) {
                    c40259aq.umW.mqu = null;
                }
                c40259aq.umW = new C40264b(bundle2);
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
            this.uwe = C16967d.m26292ad(bundleExtra);
        }
        getWindow().setFlags(16777216, 16777216);
        getWindow().setFormat(-3);
        this.uwI.cZI();
        C30086a.m47650fH(this);
        boolean booleanExtra = getIntent().getBooleanExtra("usePlugin", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("zoom", true);
        boolean booleanExtra3 = getIntent().getBooleanExtra("useJs", true);
        stringExtra = cWL();
        if (WebView.isX5() && C43867e.agF(stringExtra) && !"true".equals(C44572a.m80959iG("disable_apk_hook", "tools"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.pzf = C30798a.m49144im(this);
            C24532f.m38181nI(173);
            if (this.pzf == null) {
                this.pzf = aXX();
            }
        } else {
            this.pzf = aXX();
        }
        this.pzf.zNv = this;
        MMWebView mMWebView = this.pzf;
        if (!(mMWebView == null || mMWebView.getIsX5Kernel() || C1443d.m3068iW(19))) {
            try {
                C4990ab.m7411d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new C1438c(mMWebView, "mSysWebView", null).get());
                C4990ab.m7411d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new C1438c(r0, "mProvider", null).get());
                C4990ab.m7411d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new C1438c(r0, "mWebViewCore", null).get());
                C4990ab.m7411d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new C1438c(r0, "sWebCoreHandler", null).get());
                C4990ab.m7411d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new C1438c(r0, "mLooper", null).get());
                Object obj = new C1438c(obj, "mThread", null).get();
                C4990ab.m7411d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    C4990ab.m7417i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
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
        this.pzf.getSettings().setDatabasePath(C6457e.eSi + "databases/");
        C44576b.dTR().dTS();
        C44576b.dTR().mo71378f(this.pzf);
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
        C40326j c40326j = this.uwI;
        if (c40326j.cZv() instanceof GameWebViewUI) {
            c40326j.utK.add(Integer.valueOf(11));
            c40326j.utK.add(Integer.valueOf(28));
        } else {
            c40326j.utK.add(Integer.valueOf(7));
            c40326j.utK.add(Integer.valueOf(11));
            c40326j.utK.add(Integer.valueOf(28));
        }
        this.uwL = new C14447b();
        if (getIntent().getBooleanExtra("translate_webview", false)) {
            this.uvx = true;
            setMMTitle((int) C25738R.string.fz6);
            mMWebView = this.pzf;
            str = this.cOG;
            if (mMWebView.getX5WebViewExtension() != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("destLanguage", C4988aa.dor());
                bundle3.putString("url", str);
                bundle3.putString("translateTips", getString(C25738R.string.fza));
                bundle3.putString("translateFinish", getString(C25738R.string.fz8));
                bundle3.putString("errorWording", getString(C25738R.string.fz7));
                try {
                    C41166a.m71622ep(mMWebView.getX5WebViewExtension()).mo65761u("invokeMiscMethod", "translateWebSite", bundle3);
                } catch (Exception e22) {
                    C4990ab.m7413e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", e22.getMessage());
                }
            }
        }
        this.uie = C40291o.m69086a(new C22944q(this, this.pzf), cWO());
        this.uie.afY(this.cOG);
        cZX();
        this.icz = new C40344k((JsapiPermissionWrapper) getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) getIntent().getParcelableExtra("hardcode_general_ctrl"), new C1696252());
        initView();
        m26179IB("onCreate");
        this.ium = this.pzf.getSettings().getUserAgentString();
        this.fromScene = getIntent().getIntExtra("from_scence", 0);
        C4990ab.m7411d("MicroMsg.WebViewUI", " onCreate fromScene %d", Integer.valueOf(this.fromScene));
        this.cvF = C37922v.m64078nW(C5046bo.nullAsNil(hashCode()));
        C4990ab.m7417i("MicroMsg.WebViewUI", " onCreate sessionId %s", this.cvF);
        C14511h cXZ = this.ulI.cXZ();
        i = this.cSQ;
        String str3 = this.cMm;
        cXZ.cSQ = i;
        cXZ.uni = str3;
        cXZ.url = this.cOG;
        C40257d cYf = this.ulI.cYf();
        C4990ab.m7417i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", this.cOG);
        try {
            Uri parse = Uri.parse(this.cOG);
            if (parse.getScheme() == null || parse.getScheme().toLowerCase().startsWith("http")) {
                str3 = parse.getHost();
                if (str3 == null || str3.toLowerCase().endsWith(".qq.com")) {
                    C4990ab.m7417i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", str3);
                    try {
                        this.uwT = this.mController.contentView;
                        if (this.uwT != null) {
                            cZY();
                            ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new C458154());
                        }
                    } catch (Exception e222) {
                        C4990ab.m7413e("MicroMsg.WebViewUI", "fixContentMargin error : %s", e222.getMessage());
                    }
                    try {
                        if (this.uwl) {
                            if (dab()) {
                                dad();
                            }
                        } else if (C1443d.m3068iW(21)) {
                            final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                            viewGroup.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    AppMethodBeat.m2504i(7884);
                                    WebViewUI.this.mo30948a(viewGroup, windowInsets);
                                    WebViewUI.this.uwm = true;
                                    WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
                                    AppMethodBeat.m2505o(7884);
                                    return consumeSystemWindowInsets;
                                }
                            });
                        } else {
                            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                        }
                    } catch (Exception e2222) {
                        C4990ab.m7413e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", e2222.getMessage());
                    }
                    this.uvh = new C9086a(this.mController.ylL, this.uwV);
                    this.uwF.aNS().mo10302aa(new C1694053());
                    this.uwK = new WebViewClipBoardHelper(this);
                    this.uwR.dnU();
                    this.uvV.dnU();
                    if (this.uwO != null) {
                        c23144o = this.uwO;
                        if (c23144o.uxX != null) {
                            c23144o.pzp = c23144o.uxX.pzf;
                            if (c23144o.uxW) {
                                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle true");
                            } else {
                                C4990ab.m7416i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleIfNeed, disableLightActionbarStyle false");
                                c23144o.daR();
                            }
                        }
                    }
                    WebViewUI.m26211af(getWindow().getDecorView(), 256);
                    C40259aq.m69041lP(getIntent().getLongExtra("start_activity_time", 0));
                    this.uwE.mo69758aI("onUIInitEnd", System.currentTimeMillis());
                    AppMethodBeat.m2505o(7996);
                }
                cYf.mlA = true;
                this.uwT = this.mController.contentView;
                if (this.uwT != null) {
                }
                if (this.uwl) {
                }
                this.uvh = new C9086a(this.mController.ylL, this.uwV);
                this.uwF.aNS().mo10302aa(new C1694053());
                this.uwK = new WebViewClipBoardHelper(this);
                this.uwR.dnU();
                this.uvV.dnU();
                if (this.uwO != null) {
                }
                WebViewUI.m26211af(getWindow().getDecorView(), 256);
                C40259aq.m69041lP(getIntent().getLongExtra("start_activity_time", 0));
                this.uwE.mo69758aI("onUIInitEnd", System.currentTimeMillis());
                AppMethodBeat.m2505o(7996);
            }
            C4990ab.m7417i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", parse.getScheme());
            this.uwT = this.mController.contentView;
            if (this.uwT != null) {
            }
            if (this.uwl) {
            }
            this.uvh = new C9086a(this.mController.ylL, this.uwV);
            this.uwF.aNS().mo10302aa(new C1694053());
            this.uwK = new WebViewClipBoardHelper(this);
            this.uwR.dnU();
            this.uvV.dnU();
            if (this.uwO != null) {
            }
            WebViewUI.m26211af(getWindow().getDecorView(), 256);
            C40259aq.m69041lP(getIntent().getLongExtra("start_activity_time", 0));
            this.uwE.mo69758aI("onUIInitEnd", System.currentTimeMillis());
            AppMethodBeat.m2505o(7996);
        } catch (Exception e4) {
            C4990ab.m7413e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", str);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int getActionBarHeight() {
        AppMethodBeat.m2504i(7997);
        int dimensionPixelSize;
        if (getResources().getDimensionPixelSize(C25738R.dimen.f9647a5) > C1338a.fromDPToPix(this, 48)) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9647a5);
            AppMethodBeat.m2505o(7997);
            return dimensionPixelSize;
        } else if (C40619x.m70075gu(this)) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
            AppMethodBeat.m2505o(7997);
            return dimensionPixelSize;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9777fc);
            AppMethodBeat.m2505o(7997);
            return dimensionPixelSize;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cZY() {
        AppMethodBeat.m2504i(7998);
        if (this.uwT == null || cZZ()) {
            AppMethodBeat.m2505o(7998);
            return;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.uwT.getLayoutParams();
        int daa = daa();
        if (daa != marginLayoutParams.topMargin) {
            marginLayoutParams.topMargin = daa;
            this.uwT.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(7998);
    }

    private int daa() {
        AppMethodBeat.m2504i(7999);
        int i = this.uwl ? 0 : this.iJp;
        if (getSupportActionBar() == null || !getSupportActionBar().isShowing()) {
            AppMethodBeat.m2505o(7999);
            return i;
        }
        i += getActionBarHeight();
        AppMethodBeat.m2505o(7999);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(21)
    /* renamed from: a */
    public final void mo30948a(ViewGroup viewGroup, WindowInsets windowInsets) {
        AppMethodBeat.m2504i(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        if (this.iJp == windowInsets.getSystemWindowInsetTop()) {
            AppMethodBeat.m2505o(TXRecordCommon.AUDIO_SAMPLERATE_8000);
            return;
        }
        View viewGroup2;
        this.iJp = windowInsets.getSystemWindowInsetTop();
        cZY();
        if (viewGroup2 instanceof SwipeBackLayout) {
            viewGroup2 = viewGroup2.getChildAt(0);
        }
        View findViewById = viewGroup2.findViewById(2131820940);
        if (findViewById != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
            findViewById.setLayoutParams(marginLayoutParams);
            findViewById.requestLayout();
        }
        if (dab()) {
            dad();
        }
        AppMethodBeat.m2505o(TXRecordCommon.AUDIO_SAMPLERATE_8000);
    }

    /* Access modifiers changed, original: protected */
    public boolean dab() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean dac() {
        AppMethodBeat.m2504i(8002);
        if (C5046bo.isNullOrNil(this.nft) || !this.nft.equals("black")) {
            AppMethodBeat.m2505o(8002);
            return false;
        }
        AppMethodBeat.m2505o(8002);
        return true;
    }

    /* renamed from: at */
    public final void mo30967at(int i, boolean z) {
        AppMethodBeat.m2504i(8004);
        if (VERSION.SDK_INT < 23 || C4971b.m7364Mt()) {
            if (VERSION.SDK_INT >= 21) {
                if (z) {
                    i = C29916g.m47390Jj(i);
                }
                setStatusBarColor(i);
            }
            AppMethodBeat.m2505o(8004);
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
        AppMethodBeat.m2505o(8004);
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(8005);
        if (this.uwl) {
            View view = this.mController.contentView;
            if (!C5225ah.m7958Nw(i)) {
                z = true;
            }
            C5540a.m8360d(view, i, z);
            AppMethodBeat.m2505o(8005);
        } else if (this.iJp <= 0 || C1443d.m3067fP(21)) {
            AppMethodBeat.m2505o(8005);
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
            AppMethodBeat.m2505o(8005);
        }
    }

    public final String dae() {
        AppMethodBeat.m2504i(8006);
        String str;
        if (this.handler == null) {
            str = this.uxf;
            AppMethodBeat.m2505o(8006);
            return str;
        } else if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            if (this.pzf == null) {
                str = "";
                AppMethodBeat.m2505o(8006);
                return str;
            }
            str = this.pzf.getUrl();
            AppMethodBeat.m2505o(8006);
            return str;
        } else if (C5046bo.isNullOrNil(this.uxf)) {
            this.uxf = (String) new C5039bj<String>("") {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(7810);
                    if (WebViewUI.this.pzf == null) {
                        String str = "";
                        AppMethodBeat.m2505o(7810);
                        return str;
                    }
                    Object url = WebViewUI.this.pzf.getUrl();
                    AppMethodBeat.m2505o(7810);
                    return url;
                }
            }.mo10372b(this.handler);
            str = this.uxf;
            AppMethodBeat.m2505o(8006);
            return str;
        } else {
            str = this.uxf;
            AppMethodBeat.m2505o(8006);
            return str;
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(8008);
        C4990ab.m7419v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!(this.uwO == null || this.uwO.uxW)) {
            this.uwO.daU();
        }
        AppMethodBeat.m2505o(8008);
    }

    public final void daf() {
        AppMethodBeat.m2504i(138973);
        C30086a.m47650fH(this);
        AppMethodBeat.m2505o(138973);
    }

    public void aBS() {
        AppMethodBeat.m2504i(8010);
        if (VERSION.SDK_INT <= 10) {
            super.aBS();
            AppMethodBeat.m2505o(8010);
        } else if (getForceOrientation() == -1) {
            this.ylk = getSharedPreferences(C4996ah.doA(), 4).getBoolean("settings_landscape_mode", false);
            if (this.ylk) {
                setRequestedOrientation(-1);
                AppMethodBeat.m2505o(8010);
                return;
            }
            setRequestedOrientation(1);
            AppMethodBeat.m2505o(8010);
        } else {
            setRequestedOrientation(getForceOrientation());
            AppMethodBeat.m2505o(8010);
        }
    }

    public int getForceOrientation() {
        return this.screenOrientation;
    }

    private View dag() {
        int identifier;
        AppMethodBeat.m2504i(8011);
        View view = null;
        try {
            identifier = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", e);
            identifier = -1;
        }
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", Integer.valueOf(identifier), view);
        AppMethodBeat.m2505o(8011);
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(8012);
        super.onConfigurationChanged(configuration);
        if (this.jQp != configuration.orientation) {
            View dag = dag();
            if (dag == null) {
                dag = null;
            } else {
                dag = (View) dag.getParent();
            }
            if (dag == null) {
                AppMethodBeat.m2505o(8012);
                return;
            }
            dag.dispatchConfigurationChanged(configuration);
            dag.requestLayout();
            this.jQp = configuration.orientation;
        }
        AppMethodBeat.m2505o(8012);
    }

    public void onStart() {
        AppMethodBeat.m2504i(8013);
        super.onStart();
        C4990ab.m7416i("MicroMsg.WebViewUI", "edw onStart");
        AppMethodBeat.m2505o(8013);
    }

    public void onStop() {
        AppMethodBeat.m2504i(8014);
        C4990ab.m7416i("MicroMsg.WebViewUI", "edw onStop");
        mo30947X(true, true);
        super.onStop();
        AppMethodBeat.m2505o(8014);
    }

    /* renamed from: Jr */
    private void m26181Jr(int i) {
        AppMethodBeat.m2504i(8015);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.icy.mo15526a(5, bundle, hashCode());
            AppMethodBeat.m2505o(8015);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.m2505o(8015);
        }
    }

    /* renamed from: Js */
    private void m26182Js(int i) {
        AppMethodBeat.m2504i(8016);
        try {
            if (this.icy != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.icy.mo15526a(6, bundle, hashCode());
            }
            AppMethodBeat.m2505o(8016);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
            AppMethodBeat.m2505o(8016);
        }
    }

    public void onDestroy() {
        Bundle bundle;
        AppMethodBeat.m2504i(8017);
        C4990ab.m7416i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        super.onDestroy();
        C46430c.cYw();
        String dae = dae();
        if (dae != null) {
            String string = getSharedPreferences("webview_url_prefs", 4).getString("url", null);
            if (string != null && dae.equals(string)) {
                Editor edit = getSharedPreferences("webview_url_prefs", 4).edit();
                edit.remove("url");
                edit.apply();
            }
        } else {
            C4990ab.m7420w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
        }
        this.uie.dbc();
        if (!this.uwB) {
            try {
                if (this.icy != null) {
                    this.icy.mo15519Jc(hashCode());
                    this.icy.mo15515IP(hashCode());
                }
                C4990ab.m7420w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(e)));
            }
        }
        if (this.uvh != null) {
            this.uvh.disable();
        }
        this.uwA = true;
        uwz--;
        int hashCode = hashCode();
        for (int size = uvK.size() - 1; size >= 0; size--) {
            if (((C16979z) uvK.get(size)).f3579id == hashCode) {
                uvK.remove(size);
                break;
            }
        }
        mo31009l("", C5046bo.anT(), 0);
        C46429p cYp = C40275a.uob;
        cYp.uoa.put(hashCode(), Boolean.FALSE);
        C22884i cYb = this.ulI.cYb();
        cYb.une = new Object[]{this.cOG, Integer.valueOf(2)};
        cYb.mo38482b(this.icy);
        this.ulI.mo63603b(this.icy);
        C40259aq c40259aq = this.ulI;
        c40259aq.umM = null;
        c40259aq.umK = null;
        c40259aq.umL = null;
        c40259aq.umJ = null;
        c40259aq.umO = null;
        c40259aq.umP = null;
        c40259aq.umQ = null;
        c40259aq.umR = null;
        if (c40259aq.umW != null) {
            c40259aq.umW.mqu = null;
            c40259aq.umW = null;
        }
        m26179IB("onDestroy");
        this.uwa.clear();
        C46424b c46424b = this.uwF;
        if (!(c46424b.ulH == null || c46424b.ulH.oAl.getLooper() == null)) {
            c46424b.ulH.oAl.getLooper().quit();
        }
        c46424b.ulH = null;
        C22883an c22883an = this.uwP;
        c22883an.umD.clear();
        c22883an.umE.clear();
        c22883an.umF.clear();
        c22883an.umB.clear();
        c22883an.umC.clear();
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
            m26182Js(C31128d.MIC_PTU_MEISHI);
        }
        if (this.uvT.daP()) {
            m26182Js(673);
        }
        if (this.uvU.daP()) {
            m26182Js(666);
        }
        this.uwb.clear();
        this.uwI.onDestroy();
        this.uwR.dead();
        this.uvV.dead();
        if (C24526c.m38159jx(C4996ah.getContext()) != null) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            C24526c.sync();
        }
        if (das()) {
            try {
                if (this.icy != null) {
                    bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.icy.mo15526a(30, bundle, hashCode());
                }
            } catch (Exception e2) {
            }
        }
        C4990ab.m7419v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", Boolean.valueOf(this.uvp));
        if (this.uvp) {
            try {
                bundle = getIntent().getBundleExtra("mm_report_bundle");
                if (C5046bo.isNullOrNil(bundle.getString("mm_event_class"))) {
                    C4990ab.m7420w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                } else if (this.icy != null) {
                    bundle.putLong("key_activity_browse_time", dyi());
                    this.icy.mo15575g(250, bundle);
                }
            } catch (Exception e3) {
                C4990ab.m7413e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e3.toString());
            }
        }
        try {
            if (this.icy != null) {
                bundle = new Bundle();
                bundle.putLong("key_activity_browse_time", dyi());
                this.icy.mo15575g(251, bundle);
            }
        } catch (Exception e32) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e32.toString());
        }
        try {
            if (this.icy != null) {
                bundle = this.icy.mo15575g(19, null);
                if (bundle != null) {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(uwz));
                    if (bundle.getBoolean("webview_video_proxy_init") && uwz <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.icy.mo15575g(75, null);
                    }
                }
            }
        } catch (Exception e322) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "deinit video player failed : %s", e322.getMessage());
        }
        if (this.ktl != null) {
            try {
                unbindService(this.ktl);
            } catch (Exception e3222) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e3222, "unbindService", new Object[0]);
            }
        }
        boolean a = C40276k.m69057a(this.uhz, this.pzf);
        if (this.uhz != null) {
            this.uhz.detach();
        }
        this.uvJ.clear();
        if (this.uic != null) {
            C35652d c35652d = this.uic;
            C4990ab.m7416i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            c35652d.context = null;
            c35652d.urJ = null;
            c35652d.urK.clear();
            c35652d.urL.clear();
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
            C4990ab.m7413e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", e32222.getMessage());
        }
        this.uwG.cYP();
        if (this.icz != null) {
            C40344k c40344k = this.icz;
            C4990ab.m7416i("MicroMsg.WebViewPermission", "detach");
            c40344k.ulm.clear();
            c40344k.ulm = null;
            this.icz = null;
        }
        try {
            this.uwX.release();
        } catch (Exception e322222) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e322222.getMessage());
        }
        if (!a) {
            try {
                this.pzf.destroy();
            } catch (Exception e3222222) {
                C4990ab.m7421w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", e3222222.getMessage());
            }
        }
        try {
            if (this.mController.contentView instanceof ViewGroup) {
                ((ViewGroup) this.mController.contentView).removeAllViews();
            }
        } catch (Throwable th) {
            C4990ab.m7421w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", th);
        }
        WebViewClipBoardHelper webViewClipBoardHelper = this.uwK;
        try {
            webViewClipBoardHelper.upx.removePrimaryClipChangedListener(webViewClipBoardHelper);
            webViewClipBoardHelper.upx = null;
        } catch (Exception e4) {
        }
        C14447b c14447b = this.uwL;
        if (c14447b.tipDialog != null && c14447b.tipDialog.isShowing()) {
            c14447b.tipDialog.dismiss();
            c14447b.tipDialog = null;
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
        AppMethodBeat.m2505o(8017);
    }

    private void dah() {
        AppMethodBeat.m2504i(8018);
        try {
            this.uwX.release();
            this.pzf.stopLoading();
            this.uvG = false;
            this.pzf.removeAllViews();
            this.pzf.clearView();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.uhz != null) {
            this.uhz.detach();
        }
        try {
            this.pzf.destroy();
        } catch (Exception e2) {
            C4990ab.m7421w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", e2.getMessage());
        }
        this.pzf = null;
        finish();
        C4990ab.dot();
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(8018);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(8019);
        if (i != 82 || this.uwW) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.m2505o(8019);
            return onKeyUp;
        }
        AppMethodBeat.m2505o(8019);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(8020);
        C4990ab.m7417i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", Integer.valueOf(i));
        C22884i cYb;
        if (i == 4 && this.pzf != null && this.pzf.hasEnteredFullscreen()) {
            this.pzf.leaveFullscreen();
            AppMethodBeat.m2505o(8020);
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
                    AppMethodBeat.m2505o(8020);
                    return true;
                }
            }
            if (i == 4) {
                if (this.pzf != null && this.pzf.canGoBack() && this.uvn) {
                    dai();
                    cYb = this.ulI.cYb();
                    cYb.une = new Object[]{this.cOG, Integer.valueOf(1)};
                    cYb.mo38482b(this.icy);
                    AppMethodBeat.m2505o(8020);
                    return true;
                }
                C40346m.uuj.close();
            }
            if (i == 4 && daB() && cWG()) {
                AppMethodBeat.m2505o(8020);
                return true;
            } else if (i == 4 && this.uie.mo38526Jx(22)) {
                AppMethodBeat.m2505o(8020);
                return true;
            } else {
                if (i == 4) {
                    daD();
                }
                boolean onKeyDown = super.onKeyDown(i, keyEvent);
                AppMethodBeat.m2505o(8020);
                return onKeyDown;
            }
        } else {
            try {
                this.uvO.onHideCustomView();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
            }
            cYb = this.ulI.cYb();
            cYb.une = new Object[]{this.cOG, Integer.valueOf(1)};
            cYb.mo38482b(this.icy);
            AppMethodBeat.m2505o(8020);
            return true;
        }
    }

    /* Access modifiers changed, original: protected */
    public void dai() {
        AppMethodBeat.m2504i(8021);
        this.uvo = System.currentTimeMillis();
        this.pzf.goBack();
        this.uvC = null;
        if (this.uvZ) {
            this.uvZ = false;
        }
        C40346m c40346m = C40346m.uuj;
        C4990ab.m7419v("MicroMsg.WebViewReportUtil", "goBack traceid %s", c40346m.qTK);
        if (!C5046bo.isNullOrNil(c40346m.qTK)) {
            c40346m.mo63715kT(5);
        }
        AppMethodBeat.m2505o(8021);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dE */
    public void mo30984dE(String str, int i) {
        AppMethodBeat.m2504i(8022);
        if (this.uvi == null) {
            AppMethodBeat.m2505o(8022);
            return;
        }
        WebViewInputFooter webViewInputFooter = this.uvi;
        webViewInputFooter.setVisibility(0);
        if (webViewInputFooter.uKu != null) {
            webViewInputFooter.uKu.setVisibility(0);
        }
        if (webViewInputFooter.uKt != null) {
            webViewInputFooter.uKt.setEnabled(true);
            webViewInputFooter.uKt.setBackgroundResource(C25738R.drawable.b77);
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
        if (!C5046bo.isNullOrNil(str)) {
            this.uvi.setText(str);
        }
        if (i >= 0) {
            this.uvi.setMaxCount(i);
        }
        AppMethodBeat.m2505o(8022);
    }

    /* Access modifiers changed, original: protected */
    public int cWF() {
        AppMethodBeat.m2504i(8023);
        if (this.uvi == null) {
            AppMethodBeat.m2505o(8023);
            return 0;
        }
        int dcZ = this.uvi.dcZ();
        AppMethodBeat.m2505o(8023);
        return dcZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void daj() {
        AppMethodBeat.m2504i(8024);
        this.uwX.utS = new C169685();
        C43987l c43987l = this.uwX;
        c43987l.hfA = true;
        if (c43987l.utU != null) {
            c43987l.utU.setVisibility(0);
            c43987l.utU.setMMOverScrollOffsetListener(c43987l);
            c43987l.utU.setFastScrollBack(true);
            c43987l.utU.mo48081nM(false);
            c43987l.utU.setReleaseTargetHeight(c43987l.utV);
        }
        if (c43987l.utT != null) {
            c43987l.utT.setWillNotDraw(true);
            c43987l.utT.setImageResource(C43987l.utW);
            c43987l.utT.setVisibility(0);
            c43987l.utT.setAlpha(0.0f);
            c43987l.utT.setWillNotDraw(false);
            c43987l.utT.invalidate();
        }
        if (c43987l.uue != null) {
            c43987l.uue.setVisibility(8);
        }
        AppMethodBeat.m2505o(8024);
    }

    /* Access modifiers changed, original: protected */
    public void cZH() {
        AppMethodBeat.m2504i(8025);
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.mController.contentView == null) {
            this.pzf.setBackgroundColor(getResources().getColor(C25738R.color.f11637y));
            AppMethodBeat.m2505o(8025);
            return;
        }
        setBackGroundColorResource(intExtra);
        this.mController.contentView.setBackgroundResource(intExtra);
        this.pzf.setBackgroundResource(17170445);
        findViewById(2131823600).setBackgroundResource(17170445);
        AppMethodBeat.m2505o(8025);
    }

    /* Access modifiers changed, original: protected */
    public void dak() {
        AppMethodBeat.m2504i(8026);
        if (getIntent() == null) {
            AppMethodBeat.m2505o(8026);
            return;
        }
        if (getIntent().hasExtra("show_full_screen")) {
            mo30946W(getIntent().getBooleanExtra("show_full_screen", false), true);
        }
        AppMethodBeat.m2505o(8026);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: W */
    public final void mo30946W(boolean z, boolean z2) {
        AppMethodBeat.m2504i(8027);
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
                C5540a.m8358D(this.uwT, true);
            } else if (this.uwU != null) {
                this.uwU.setVisibility(8);
            }
            getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    AppMethodBeat.m2504i(7814);
                    if ((i & 4) == 0 && WebViewUI.this.uvf) {
                        WebViewUI.m26227eq(decorView);
                    }
                    AppMethodBeat.m2505o(7814);
                }
            });
            WebViewUI.m26211af(decorView, 5894);
            if (z2) {
                this.uve.setOnClickListener(new C169648());
                this.uve.setVisibility(0);
                AppMethodBeat.m2505o(8027);
                return;
            }
            this.uve.setVisibility(8);
            AppMethodBeat.m2505o(8027);
            return;
        }
        this.uve.setVisibility(8);
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        WebViewUI.m26226ep(getWindow().getDecorView());
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            if (this.uwT != null) {
                marginLayoutParams = (MarginLayoutParams) this.uwT.getLayoutParams();
                marginLayoutParams.topMargin = daa();
                this.uwT.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.uwl) {
            C5540a.m8358D(this.uwT, false);
            AppMethodBeat.m2505o(8027);
            return;
        }
        if (this.uwU != null) {
            this.uwU.setVisibility(0);
        }
        AppMethodBeat.m2505o(8027);
    }

    /* renamed from: af */
    private static void m26211af(View view, int i) {
        AppMethodBeat.m2504i(8028);
        if (view == null) {
            AppMethodBeat.m2505o(8028);
            return;
        }
        view.setSystemUiVisibility(view.getSystemUiVisibility() | i);
        AppMethodBeat.m2505o(8028);
    }

    /* renamed from: ep */
    private static void m26226ep(View view) {
        AppMethodBeat.m2504i(8029);
        if (view == null) {
            AppMethodBeat.m2505o(8029);
            return;
        }
        view.setSystemUiVisibility(view.getSystemUiVisibility() & -5895);
        AppMethodBeat.m2505o(8029);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.m2504i(8030);
        super.onWindowFocusChanged(z);
        if (z && this.uvf) {
            WebViewUI.m26211af(getWindow().getDecorView(), 5894);
        }
        AppMethodBeat.m2503at(this, z);
        AppMethodBeat.m2505o(8030);
    }

    public void initView() {
        String str;
        AppMethodBeat.m2504i(8031);
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.uvy = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.uvu = getIntent().getBooleanExtra("is_favorite_item", false);
        this.rpm = getIntent().getBooleanExtra("isWebwx", true);
        this.uvs = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.uwk = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.uvw = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.uwg = LayoutInflater.from(this.mController.ylL).inflate(2130970906, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.uwi = C5046bo.nullAsNil(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            addTextOptionMenu(1, getString(C25738R.string.e75), new C45829());
        }
        this.uuY = (ProgressBar) findViewById(2131824558);
        this.uwh = findViewById(2131823604);
        this.uwh.setOnClickListener(new C1698910());
        if (this.rpm) {
            CharSequence nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("title"));
            if (nullAsNil.length() > 0) {
                this.uuW = true;
            }
            mo17368M(nullAsNil);
        } else {
            setMMTitle("");
        }
        mo31013nP(false);
        m26242nQ(false);
        if (uvQ == RenderPriority.NORMAL) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.pzf.getSettings().setRenderPriority(RenderPriority.HIGH);
            uvQ = RenderPriority.HIGH;
        }
        C43987l c43987l = this.uwX;
        View view = this.mController.contentView;
        c43987l.utU = (LogoWebViewWrapper) view.findViewById(2131823602);
        c43987l.utT = (ImageView) view.findViewById(2131824657);
        c43987l.uud = view.findViewById(2131824656);
        if (c43987l.uud != null) {
            c43987l.uue = c43987l.uud.findViewById(2131829178);
            c43987l.uuf = (TextView) c43987l.uue.findViewById(2131829179);
        }
        c43987l.utV = C4977b.m7371b(c43987l.utU.getContext(), 72.0f);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        if (c43987l.utT == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(c43987l.utT.getId());
        }
        objArr[0] = str;
        if (c43987l.utU == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(c43987l.utU.getId());
        }
        objArr[1] = str;
        C4990ab.m7411d(str2, str3, objArr);
        C4990ab.m7411d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", Integer.valueOf(c43987l.utV));
        c43987l = this.uwX;
        MMWebView mMWebView = this.pzf;
        mMWebView.setCompetitorView(c43987l.utU);
        mMWebView.dKJ();
        if (VERSION.SDK_INT <= 10) {
            c43987l.utU.getWebViewContainer().setBackgroundColor(c43987l.utU.getResources().getColor(C25738R.color.a5v));
        }
        LogoWebViewWrapper logoWebViewWrapper = c43987l.utU;
        logoWebViewWrapper.getWebViewContainer();
        if (logoWebViewWrapper.uro != null) {
            logoWebViewWrapper.ejN = mMWebView;
            logoWebViewWrapper.uro.addView(logoWebViewWrapper.ejN);
        }
        str2 = "";
        if (mMWebView.isXWalkKernel() || mMWebView.getIsX5Kernel()) {
            c43987l.uug = true;
        } else {
            c43987l.uug = false;
        }
        if (!(c43987l.uue == null || mMWebView.getIsX5Kernel())) {
            ((ImageView) c43987l.uue.findViewById(2131829180)).setVisibility(8);
            ((TextView) c43987l.uue.findViewById(2131829181)).setText(str2);
        }
        if (!c43987l.uug || c43987l.uuh) {
            c43987l.mo69669nM(true);
        } else {
            c43987l.mo69669nM(false);
            if (c43987l.uue != null) {
                c43987l.uue.setVisibility(0);
            }
        }
        cZH();
        this.uvc = (FrameLayout) findViewById(2131823601);
        this.uvd = (FrameLayout) findViewById(2131821064);
        C4990ab.m7416i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pzf.getIsX5Kernel());
        this.pzf.setWebViewClientExtension(new C35650c(this));
        if (this.pzf.getIsX5Kernel()) {
            this.pzf.setWebViewCallbackClient(this.uwQ);
            C43987l c43987l2 = this.uwX;
            C1698411 c1698411 = new C1698411();
            if (c43987l2.utU != null) {
                c43987l2.utU.setMMOverScrollListener(c1698411);
            }
        }
        this.uvi = (WebViewInputFooter) findViewById(2131824560);
        if (this.uvi != null) {
            this.uvi.hide();
            this.uvi.setOnTextSendListener(new C1699013());
            this.uvi.setOnSmileyChosenListener(new C1693114());
            this.uvi.setOnSmileyPanelVisibilityChangedListener(new C1695415());
        }
        this.uvj = (WebViewSearchContentInputFooter) findViewById(2131824561);
        if (this.uvj != null) {
            this.uvj.setActionDelegate(new C1693216());
            this.pzf.setFindListener(new C457917());
        }
        this.uve = (MovingImageButton) findViewById(2131824562);
        this.uvH = findViewById(2131829160);
        if (this.uvH != null) {
            this.uvH.setVisibility(8);
        }
        if (!booleanExtra) {
            this.pzf.setVerticalScrollBarEnabled(false);
        }
        this.pzf.setWebChromeClient(dal());
        this.pzf.setWebViewClient(aXZ());
        this.pzf.setDownloadListener(new C1695518());
        this.pzf.requestFocus(130);
        this.pzf.setOnTouchListener(new C1695619());
        this.pzf.getSettings().setUserAgentString(C30152u.m47747bh(this, this.pzf.getSettings().getUserAgentString()));
        this.pzf.dKH();
        this.icA = new C46696j(this.mController.ylL);
        this.icA.mo75005a(this.pzf, this, null);
        this.icA.mo75012e(new C1693320());
        setBackBtn(new C1693421(), dam());
        if (dan()) {
            final WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(2131823600);
            webViewKeyboardLinearLayout.setOnkbdStateListener(new C44246a() {
                /* renamed from: sD */
                public final void mo7486sD(int i) {
                    AppMethodBeat.m2504i(7857);
                    C4990ab.m7416i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(i)));
                    WebViewUI.m26203a(WebViewUI.this, webViewKeyboardLinearLayout, i);
                    if (i == -3) {
                        WebViewUI.this.ulI.cXX().unt = 1;
                        final int keyBoardHeight = webViewKeyboardLinearLayout.getKeyBoardHeight();
                        if (keyBoardHeight > 0) {
                            WebViewUI.m26213b(WebViewUI.this, keyBoardHeight);
                            WebViewUI.m26202a(WebViewUI.this, keyBoardHeight);
                        }
                        if (WebViewUI.this.pzf.getIsX5Kernel() || VERSION.SDK_INT >= 19) {
                            WebViewUI.this.handler.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(7856);
                                    if (WebViewUI.this.uhz != null) {
                                        WebViewUI.this.uhz.mo71879JM(keyBoardHeight);
                                    }
                                    AppMethodBeat.m2505o(7856);
                                }
                            });
                        }
                        if (WebViewUI.m26239m(WebViewUI.this)) {
                            WebViewUI.this.uvi.dda();
                        }
                    } else {
                        WebViewUI.m26213b(WebViewUI.this, 0);
                        WebViewUI.m26202a(WebViewUI.this, 0);
                    }
                    WebViewUI.this.mo30944Ju(i);
                    WebViewUI.this.jYe = i;
                    AppMethodBeat.m2505o(7857);
                }
            });
        }
        this.uuX = (MMFalseProgressBar) findViewById(2131823605);
        super.setTitleBarDoubleClickListener(new C1694422());
        AppMethodBeat.m2505o(8031);
    }

    /* Access modifiers changed, original: protected */
    public C36592s aXZ() {
        AppMethodBeat.m2504i(8032);
        C14579h c14579h = new C14579h();
        AppMethodBeat.m2505o(8032);
        return c14579h;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized C6031l dal() {
        C6031l c6031l;
        AppMethodBeat.m2504i(8033);
        if (this.uvO == null) {
            this.uvO = new C7216g();
        }
        c6031l = this.uvO;
        AppMethodBeat.m2505o(8033);
        return c6031l;
    }

    /* Access modifiers changed, original: protected */
    public int dam() {
        AppMethodBeat.m2504i(8034);
        if (aXL()) {
            AppMethodBeat.m2505o(8034);
            return 0;
        }
        AppMethodBeat.m2505o(8034);
        return C1318a.actionbar_icon_dark_close;
    }

    /* Access modifiers changed, original: protected */
    public boolean aXL() {
        return this.uwp;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Jt */
    public final void mo30943Jt(int i) {
        AppMethodBeat.m2504i(8035);
        Drawable mutate = getResources().getDrawable(C1318a.actionbar_icon_dark_close).mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        mo17445x(mutate);
        AppMethodBeat.m2505o(8035);
    }

    /* Access modifiers changed, original: protected */
    public boolean dan() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(8036);
        super.onActivityResult(i, i2, intent);
        if (this.icH.mo69606b(this, i, i2, intent)) {
            AppMethodBeat.m2505o(8036);
        } else if (C35618a.m58462d(this, i, i2, intent)) {
            AppMethodBeat.m2505o(8036);
        } else {
            if (i == 777) {
                Bundle bundle = null;
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle == null || !bundle.getString("go_next", "").equals("gdpr_confirm_continue")) {
                    C4990ab.m7416i("MicroMsg.WebViewUI", "gdpr continue:false");
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("go_next", "gdpr_confirm_logout");
                    intent2.putExtra("result_data", bundle2);
                    this.uwA = true;
                    C40346m.uuj.close();
                    setResult(-1, intent2);
                    finish();
                } else {
                    C4990ab.m7416i("MicroMsg.WebViewUI", "gdpr continue:true");
                    AppMethodBeat.m2505o(8036);
                    return;
                }
            }
            AppMethodBeat.m2505o(8036);
        }
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(8037);
        if (this.pzf != null) {
            if (this.uwY) {
                this.pzf.setOnLongClickListener(this.uwZ);
            } else {
                this.pzf.setOnLongClickListener(null);
            }
        }
        aqX();
        super.onSwipeBack();
        AppMethodBeat.m2505o(8037);
    }

    public void onCancel() {
        AppMethodBeat.m2504i(8038);
        if (this.pzf != null) {
            if (this.uwY) {
                this.pzf.setOnLongClickListener(this.uwZ);
            } else {
                this.pzf.setOnLongClickListener(null);
            }
        }
        super.onCancel();
        AppMethodBeat.m2505o(8038);
    }

    public void onDrag() {
        AppMethodBeat.m2504i(8039);
        if (this.pzf != null) {
            this.pzf.setOnLongClickListener(new C1698124());
        }
        super.onDrag();
        AppMethodBeat.m2505o(8039);
    }

    public final boolean apx() {
        String url;
        AppMethodBeat.m2504i(8040);
        this.uwC = true;
        C22884i cYb = this.ulI.cYb();
        Object[] objArr = new Object[2];
        if (this.pzf != null) {
            url = this.pzf.getUrl();
        } else {
            url = this.cOG;
        }
        objArr[0] = url;
        objArr[1] = Integer.valueOf(15);
        cYb.une = objArr;
        cYb.mo38482b(this.icy);
        boolean apx = super.apx();
        AppMethodBeat.m2505o(8040);
        return apx;
    }

    /* renamed from: a */
    private static boolean m26210a(C43967b c43967b, String str) {
        AppMethodBeat.m2504i(8041);
        if (C5046bo.isNullOrNil(str) || c43967b == null) {
            AppMethodBeat.m2505o(8041);
            return false;
        }
        boolean afS = c43967b.afS(str);
        AppMethodBeat.m2505o(8041);
        return afS;
    }

    /* Access modifiers changed, original: protected */
    public void aMh() {
        String afk;
        boolean z;
        int cZr;
        Map hashMap;
        AppMethodBeat.m2504i(8042);
        this.uwE.mo69758aI("onPostBindedStart", System.currentTimeMillis());
        C4990ab.m7416i("MicroMsg.WebViewUI", "edw postBinded");
        this.uie.mo38527a(new C46437p(this.icy));
        daA();
        C46424b c46424b = this.uwF;
        C46434d c46434d = this.icy;
        try {
            afk = c46434d.afk("DNSAdvanceOpen");
            C4990ab.m7417i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", afk);
            if (C5046bo.isNullOrNil(afk)) {
                C4990ab.m7412e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = afk.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    afk = c46434d.afk("DNSAdvanceRelateDomain");
                    if (C5046bo.isNullOrNil(afk)) {
                        C4990ab.m7412e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        c46424b.aNS().mo10302aa(new C356131(afk, c46434d));
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                C4990ab.m7416i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        if (aYd() && aYa()) {
            C5004al.m7441d(new C1699126());
        }
        this.uwE.mo69758aI("onJSAPIStart", System.currentTimeMillis());
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        bundleExtra.putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        C4990ab.m7417i("MicroMsg.WebViewUI", "KDownloadRestrict = %d, KFunctionID = %s", Integer.valueOf(bundleExtra.getInt("key_download_restrict", 0)), bundleExtra.getString("key_function_id", ""));
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle.putInt("screen_orientation", this.screenOrientation);
        try {
            this.icy.mo15526a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
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
        if (C5046bo.isNullOrNil(afk)) {
            afk = getIntent().getStringExtra("title");
        }
        if (C5046bo.isNullOrNil(afk)) {
            afk = getIntent().getStringExtra("webpageTitle");
        }
        C40261l cXX = this.ulI.cXX();
        cXX.username = stringExtra;
        cXX.uns = intExtra;
        cXX.cOG = this.cOG;
        cXX.uno = intExtra2;
        cXX.scene = afH(stringExtra);
        cXX.unn = longExtra;
        cXX.unp = new C1183p(longExtra).toString();
        cXX.unl = stringExtra2;
        cXX.unm = stringExtra3;
        cXX.fjS = stringExtra4;
        cXX.appId = stringExtra5;
        cXX.unq = stringExtra6;
        cXX.unr = this.unr;
        cXX.rjC = string;
        cXX.title = C5046bo.m7532bc(afk, "");
        cXX.dJE = stringExtra7;
        C14510a cXY = this.ulI.cXY();
        cXY.fjS = stringExtra4;
        cXY.scene = afH(stringExtra);
        this.ulI.cYa().cOG = this.cOG;
        if (das()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.icy.mo15526a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            try {
                this.icy.afl(stringExtra2);
            } catch (Exception e5) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                C4990ab.m7417i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
            } else {
                cZr = this.icy.cZr();
                if (cZr != -1) {
                    C4990ab.m7417i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", Integer.valueOf(cZr));
                    getIntent().putExtra("pay_channel", cZr);
                }
            }
        } catch (Exception e6) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.uvJ.clear();
        this.uhz = aXY();
        C44786d c44786d = this.uhz;
        stringExtra = getIntent().getStringExtra("geta8key_username");
        if (!C5046bo.isNullOrNil(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (C5046bo.isNullOrNil(stringExtra)) {
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
        if (!C5046bo.isNullOrNil(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        int intExtra3 = getIntent().getIntExtra("pay_scene", -1);
        if (intExtra3 != -1) {
            C4990ab.m7417i("MicroMsg.WebViewUI", "get pay scene from extra: %s", Integer.valueOf(intExtra3));
        } else {
            intExtra3 = 3;
            C4990ab.m7417i("MicroMsg.WebViewUI", "default pay scene to: %s", Integer.valueOf(3));
        }
        hashMap.put("pay_scene", Integer.valueOf(intExtra3));
        c44786d.uFt = hashMap;
        if (dap() != null) {
            dap().uaz = this.uhz;
        }
        this.pzf.addJavascriptInterface(this.uhz, "__wx");
        this.uvJ.add(this.uhz);
        this.uvJ.add(new C16978s(this, (byte) 0));
        this.uvJ.add(new C16952p(this, (byte) 0));
        this.uvJ.add(new C4583e(this, (byte) 0));
        this.uvJ.add(new C16997r(this, (byte) 0));
        this.uvJ.add(new C16988u(this, (byte) 0));
        this.uvJ.add(new C16965a(this, (byte) 0));
        this.uvJ.add(new C16943y(this, (byte) 0));
        this.uvJ.add(new C16986t(this, (byte) 0));
        this.uvJ.add(new C16995i(this, (byte) 0));
        this.uvJ.add(new C16966b(this, (byte) 0));
        this.uvJ.add(new C16985c(this, (byte) 0));
        this.uvJ.add(new C44791e(this.pzf, this.uhz));
        this.uvJ.add(new C16942x(this, (byte) 0));
        this.uvJ.add(new C16941v(this, (byte) 0));
        this.uvJ.add(new C14584n(this, (byte) 0));
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.uvJ.add(new C16996k(this, (byte) 0));
        }
        this.uvJ.add(new C14577f(this, (byte) 0));
        try {
            cZr = C5046bo.getInt(this.icy.afk("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            cZr = 0;
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", Integer.valueOf(cZr), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false)));
        if (cZr == 1 || r1) {
            this.uwX.mo69669nM(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.uwX.mo69669nM(true);
        }
        try {
            this.uvX = C5046bo.getInt(this.icy.afk("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", Integer.valueOf(this.uvX));
        this.uwE.mo69758aI("onJSAPIEnd", System.currentTimeMillis());
        C40259aq.m69038V(this.pzf.getIsX5Kernel(), C5046bo.nullAsNil(this.cOG).startsWith("https://"));
        if (this.pzf.getIsX5Kernel()) {
            C4782m.m7141kT(7);
            C7060h.pYm.mo8375a(64, 64, 1, 0, 1, 1, false);
        } else {
            C7060h.pYm.mo8378a(64, 0, 1, false);
        }
        this.uvY = new C43986f(this.pzf, this.icy, this.uhz, new C1693527(), getIntent().getBooleanExtra("key_load_js_without_delay", false), aYd());
        try {
            cZr = C5046bo.getInt(this.icy.afk("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            cZr = 0;
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "js digest verification config = %d", Integer.valueOf(cZr));
        if (cZr == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && aYb()) {
            this.uhz.dch();
            this.uwP.aey(this.uhz.uFw);
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            mo31012nO(false);
            C4990ab.m7411d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", Long.valueOf(System.currentTimeMillis()));
        } else {
            mo31012nO(getIntent().getBooleanExtra("showShare", true));
            C4990ab.m7411d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z));
        }
        this.uvb = LayoutInflater.from(this).inflate(2130971202, null);
        FontChooserView fontChooserView = (FontChooserView) this.uvb.findViewById(2131829157);
        View findViewById = this.uvb.findViewById(2131829158);
        if (!this.pzf.getIsX5Kernel()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new C1457246());
        }
        fontChooserView.setOnChangeListener(new C16976j(this, (byte) 0));
        this.uvb.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.uvc.addView(this.uvb);
        this.uvb.setVisibility(8);
        cZr = 2;
        try {
            if (this.icy.cZd()) {
                cZr = (dax() || day()) ? daz() : (C5046bo.isNullOrNil(this.cOG) || !C14445a.uet.matcher(this.cOG).matches()) ? this.icy.mo15577gw(16384, 0) : this.icy.mo15577gw(16388, 0);
            }
        } catch (Exception e7) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (cZr <= 0 || cZr > 4) {
            cZr = 2;
        }
        m26183Jv(cZr);
        mo30945Jw(cZr);
        try {
            this.icy.mo15533a(this.cOG, true, null);
        } catch (Exception e52222) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (C43967b c43967b : this.uvJ) {
            if (WebViewUI.m26210a(c43967b, this.cOG)) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "initView, url handled, result = " + c43967b.afM(this.cOG) + ", url = " + this.cOG);
                AppMethodBeat.m2505o(8042);
                return;
            }
        }
        if (cZA()) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            AppMethodBeat.m2505o(8042);
            return;
        }
        String stringExtra8 = getIntent().getStringExtra("data");
        if (stringExtra8 != null) {
            C4990ab.m7416i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.icy.afg(stringExtra8);
                } catch (Exception e522222) {
                    C4990ab.m7420w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.pzf.setOnLongClickListener(this.uwZ);
            this.uwY = true;
            this.pzf.getSettings().setUseWideViewPort(false);
            this.pzf.getSettings().setLoadWithOverviewMode(false);
            if (afQ(null)) {
                this.pzf.getSettings().setJavaScriptEnabled(false);
                this.pzf.loadDataWithBaseURL(null, stringExtra8, "text/html", ProtocolPackage.ServerEncoding, null);
                C4990ab.m7416i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = ".concat(String.valueOf(stringExtra8)));
            } else {
                C4990ab.m7414f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
                dah();
                AppMethodBeat.m2505o(8042);
                return;
            }
        }
        if (C5046bo.isNullOrNil(this.cOG)) {
            mo31008jD(false);
        }
        if (this.cOG == null || this.cOG.length() == 0) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            AppMethodBeat.m2505o(8042);
            return;
        }
        Uri parse = Uri.parse(this.cOG);
        if (parse == null) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "initView uri is null");
            AppMethodBeat.m2505o(8042);
            return;
        }
        if (parse.getScheme() == null) {
            this.cOG = "http://" + this.cOG;
        } else if (!parse.getScheme().startsWith("http")) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (!afQ(this.cOG)) {
                C4990ab.m7414f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.cOG);
                dah();
                AppMethodBeat.m2505o(8042);
                return;
            } else if (aYd()) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "webview ispreloaded , do not reload url");
                AppMethodBeat.m2505o(8042);
                return;
            } else {
                mo30970b(this.cOG, null, false);
                AppMethodBeat.m2505o(8042);
                return;
            }
        }
        this.uvR = new C16977l(this.cOG);
        try {
            bundleExtra = this.icy.mo15575g(100000, null);
            if (!(bundleExtra == null || bundleExtra.getString("force_geta8key_host_path") == null)) {
                this.uxa = bundleExtra.getString("force_geta8key_host_path").split(";");
                this.uvR.uxa = this.uxa;
            }
        } catch (Exception e5222222) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "get force geta8key paths failed : %s", e5222222.getMessage());
        }
        if (this.uvs || this.icz.has(this.cOG)) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.uvs);
            if (!afQ(this.cOG)) {
                C4990ab.m7414f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.cOG);
                dah();
                AppMethodBeat.m2505o(8042);
                return;
            } else if (afI(this.cOG)) {
                this.uwn = true;
                this.uuX.finish();
                this.uuX.setVisibility(8);
                mo30970b(this.cOG, null, true);
            } else {
                mo30970b(this.cOG, null, false);
            }
        } else {
            if (afI(this.cOG)) {
                mo30970b(this.cOG, null, true);
                this.uxf = this.cOG;
                this.uwn = true;
                this.uuX.finish();
                this.uuX.setVisibility(8);
            }
            if (this.uwA || this.uwB || isFinishing()) {
                AppMethodBeat.m2505o(8042);
                return;
            }
            C4990ab.m7416i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            mo30966as(this.cOG, false);
            C4990ab.m7416i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.cOG);
        }
        this.uwE.mo69758aI("onPostBindedEnd", System.currentTimeMillis());
        AppMethodBeat.m2505o(8042);
    }

    /* Access modifiers changed, original: protected */
    public boolean afI(String str) {
        AppMethodBeat.m2504i(8043);
        hashCode();
        boolean aeI = C46429p.aeI(str);
        AppMethodBeat.m2505o(8043);
        return aeI;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(138974);
        mo30970b(str, null, false);
        AppMethodBeat.m2505o(138974);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo30970b(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.m2504i(8045);
        if (z) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("Pragma", "no-cache");
            hashMap.put("Cache-Control", "no-cache");
            if (this.pzf != null) {
                this.pzf.loadUrl(str, hashMap);
            }
            AppMethodBeat.m2505o(8045);
            return;
        }
        if (this.pzf != null) {
            if (map != null) {
                this.pzf.loadUrl(str, map);
                AppMethodBeat.m2505o(8045);
                return;
            }
            this.pzf.loadUrl(str);
        }
        AppMethodBeat.m2505o(8045);
    }

    /* Access modifiers changed, original: protected|final */
    public final C43987l dao() {
        return this.uwX;
    }

    public final boolean needShowIdcError() {
        return false;
    }

    private boolean cZs() {
        boolean z = false;
        AppMethodBeat.m2504i(8046);
        try {
            if (this.icy == null) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "invoker is null");
                AppMethodBeat.m2505o(8046);
                return z;
            }
            z = this.icy.cZs();
            AppMethodBeat.m2505o(8046);
            return z;
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
        }
    }

    private static String afJ(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(8047);
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
                AppMethodBeat.m2505o(8047);
                return str2;
            }
            AppMethodBeat.m2505o(8047);
            return str2;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
            AppMethodBeat.m2505o(8047);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(8048);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.uwH.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.m2505o(8048);
    }

    public final String cWL() {
        String str = null;
        AppMethodBeat.m2504i(8049);
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "getRawUrl exception:%s", e.getMessage());
            if (e instanceof ClassNotFoundException) {
                finish();
                AppMethodBeat.m2505o(8049);
                return str;
            }
        }
        if (str == null || str.length() <= 0) {
            Uri data = getIntent().getData();
            if (data == null) {
                str = "";
                AppMethodBeat.m2505o(8049);
                return str;
            }
            str = data.toString();
            AppMethodBeat.m2505o(8049);
            return str;
        }
        AppMethodBeat.m2505o(8049);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public C44786d aXY() {
        AppMethodBeat.m2504i(8050);
        MMWebView mMWebView = this.pzf;
        C40344k c40344k = this.icz;
        HashMap hashMap = new HashMap();
        hashMap.put("webview_type", "1");
        hashMap.put("init_url", this.cOG);
        hashMap.put("init_font_size", "1");
        hashMap.put("short_url", C5046bo.nullAsNil(getIntent().getStringExtra("shortUrl")));
        C44786d c44786d = new C44786d(mMWebView, c40344k, hashMap, this.icy, hashCode());
        AppMethodBeat.m2505o(8050);
        return c44786d;
    }

    /* Access modifiers changed, original: protected */
    public C35571ah dap() {
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
        AppMethodBeat.m2504i(8051);
        this.uwI.cZR();
        AppMethodBeat.m2505o(8051);
    }

    /* Access modifiers changed, original: protected */
    public void cZM() {
        AppMethodBeat.m2504i(8052);
        this.uwI.cZM();
        AppMethodBeat.m2505o(8052);
    }

    /* Access modifiers changed, original: protected */
    public void aYe() {
        AppMethodBeat.m2504i(8053);
        if (this.pzf != null) {
            this.pzf.reload();
        }
        AppMethodBeat.m2505o(8053);
    }

    public final void cZO() {
        AppMethodBeat.m2504i(8054);
        this.uwI.cZO();
        AppMethodBeat.m2505o(8054);
    }

    public final void afG(String str) {
        AppMethodBeat.m2504i(8055);
        this.uwI.afG(str);
        AppMethodBeat.m2505o(8055);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:7:0x0029, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r1) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final LinkedList<C1764a> dar() {
        LinkedList<C1764a> linkedList = null;
        AppMethodBeat.m2504i(8056);
        if (this.pzf == null) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            AppMethodBeat.m2505o(8056);
        } else {
            String url;
            String str = this.cOG;
            if (this.pzf != null) {
                url = this.pzf.getUrl();
            }
            url = str;
            if (url == null) {
                AppMethodBeat.m2505o(8056);
            } else {
                try {
                    URL url2 = new URL(url);
                    Pattern compile = Pattern.compile(".*(\\.wanggou\\.com|\\.jd\\.com)");
                    CharSequence host = url2.getHost();
                    if (C5046bo.isNullOrNil(host)) {
                        AppMethodBeat.m2505o(8056);
                    } else {
                        if (!host.startsWith(".")) {
                            host = ".".concat(String.valueOf(host));
                        }
                        C4990ab.m7411d("MicroMsg.WebViewUI", "host = %s", host);
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
                                C4990ab.m7411d(str2, str3, objArr);
                            }
                            if (this.uwt != null && this.uwt.size() > 0) {
                                linkedList = C1766d.m3640g(this.uwt);
                                AppMethodBeat.m2505o(8056);
                            }
                        }
                        AppMethodBeat.m2505o(8056);
                    }
                } catch (Exception e) {
                    C4990ab.m7411d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", e.getMessage());
                }
            }
        }
        return linkedList;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean das() {
        AppMethodBeat.m2504i(8057);
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        if (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) {
            AppMethodBeat.m2505o(8057);
            return false;
        }
        AppMethodBeat.m2505o(8057);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo30971c(String str, Drawable drawable) {
        AppMethodBeat.m2504i(8058);
        final boolean das = das();
        final String stringExtra = getIntent().getStringExtra("srcUsername");
        mo17378a(0, str, drawable, (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(7851);
                if (das) {
                    WebViewUI.this.afK(stringExtra);
                } else {
                    WebViewUI.this.cZM();
                }
                AppMethodBeat.m2505o(7851);
                return true;
            }
        });
        AppMethodBeat.m2505o(8058);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: nO */
    public void mo31012nO(boolean z) {
        AppMethodBeat.m2504i(8059);
        this.uwW = z;
        if (this.pzf == null) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            AppMethodBeat.m2505o(8059);
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
            dat = C1318a.mm_title_btn_jd;
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", Boolean.valueOf(getIntent().getBooleanExtra("KRightBtn", false)), Boolean.valueOf(getIntent().getBooleanExtra("KShowFixToolsBtn", false)));
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            if (r4) {
                addIconOptionMenu(1, C1318a.fix_tools_entry, new C1697131());
            }
            mo17377a(dat, (OnMenuItemClickListener) new C1694632(), this.uxc);
        }
        if (z) {
            booleanExtra = false;
        } else {
            booleanExtra = true;
        }
        mo31014nR(booleanExtra);
        AppMethodBeat.m2505o(8059);
    }

    public final void showOptionMenu(boolean z) {
        AppMethodBeat.m2504i(8060);
        if (getIntent().getBooleanExtra("hide_option_menu", false)) {
            super.showOptionMenu(false);
            AppMethodBeat.m2505o(8060);
            return;
        }
        super.showOptionMenu(z);
        AppMethodBeat.m2505o(8060);
    }

    public final void showOptionMenu(int i, boolean z) {
        AppMethodBeat.m2504i(8061);
        if (getIntent().getBooleanExtra("hide_option_menu", false)) {
            super.showOptionMenu(i, false);
            AppMethodBeat.m2505o(8061);
            return;
        }
        super.showOptionMenu(i, z);
        AppMethodBeat.m2505o(8061);
    }

    /* Access modifiers changed, original: protected|final */
    public final int dat() {
        AppMethodBeat.m2504i(8063);
        int i = C25738R.drawable.f6899uu;
        if (dar() != null) {
            i = C1318a.mm_title_btn_jd;
        }
        AppMethodBeat.m2505o(8063);
        return i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Ju */
    public final void mo30944Ju(int i) {
        AppMethodBeat.m2504i(8064);
        if (i != -3) {
            AppMethodBeat.m2505o(8064);
        } else if (this.uvH == null) {
            AppMethodBeat.m2505o(8064);
        } else {
            boolean z = (this.icz.cZT().vxG & 1) > 0;
            C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(z)));
            if (z) {
                if (this.uvH.getVisibility() == 0 || this.uvj.isShown()) {
                    AppMethodBeat.m2505o(8064);
                    return;
                }
                if (this.uvI == null) {
                    this.uvI = new C7564ap(Looper.getMainLooper(), new C1699237(), false);
                }
                this.uvI.mo16770ae(4000, 4000);
                View view = this.uvH;
                ((ImageView) view.findViewById(2131825261)).setImageResource(C1318a.net_warn_icon);
                TextView textView = (TextView) view.findViewById(2131825262);
                textView.setTextSize(14.0f);
                textView.setText(C25738R.string.g1y);
                ((ImageButton) view.findViewById(2131825263)).setOnClickListener(new C1697238());
                this.uvH.setVisibility(0);
                C7060h.pYm.mo8374X(13125, cWL());
            }
            AppMethodBeat.m2505o(8064);
        }
    }

    private void dau() {
        AppMethodBeat.m2504i(8065);
        if (this.uvH != null) {
            this.uvH.setVisibility(8);
        }
        if (this.uvI != null) {
            this.uvI.stopTimer();
        }
        AppMethodBeat.m2505o(8065);
    }

    /* Access modifiers changed, original: protected|final */
    public final void afK(String str) {
        AppMethodBeat.m2504i(8066);
        this.uhz.mo71910bJ(Scopes.PROFILE, true);
        this.uhz.ago(str);
        AppMethodBeat.m2505o(8066);
    }

    public final void clH() {
        AppMethodBeat.m2504i(8067);
        this.uhz.mo71910bJ("sendAppMessage", true);
        this.uhz.mo71942q(this.uwI.cZP());
        this.ulI.aeG("mm_send_friend_count");
        AppMethodBeat.m2505o(8067);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: nP */
    public final void mo31013nP(boolean z) {
        AppMethodBeat.m2504i(8068);
        if (findViewById(2131823606) == null) {
            AppMethodBeat.m2505o(8068);
            return;
        }
        boolean z2;
        if (findViewById(2131823606).getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            findViewById(2131823606).startAnimation(AnimationUtils.loadAnimation(this.mController.ylL, z ? C25738R.anim.f8288n : C25738R.anim.f8289o));
        }
        if (z) {
            findViewById(2131823606).setVisibility(0);
            this.uuZ = (ImageButton) findViewById(2131823607);
            ImageButton imageButton = this.uuZ;
            z2 = this.pzf != null && this.pzf.canGoBack();
            imageButton.setEnabled(z2);
            this.uuZ.setOnClickListener(new C1698339());
            this.uva = (ImageButton) findViewById(2131823608);
            this.uva.setOnClickListener(new C458040());
            AppMethodBeat.m2505o(8068);
            return;
        }
        findViewById(2131823606).setVisibility(8);
        AppMethodBeat.m2505o(8068);
    }

    /* renamed from: nQ */
    private void m26242nQ(boolean z) {
        AppMethodBeat.m2504i(8069);
        if (this.uva != null) {
            this.uva.setEnabled(z);
        }
        AppMethodBeat.m2505o(8069);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: X */
    public final void mo30947X(boolean z, boolean z2) {
        AppMethodBeat.m2504i(8070);
        enableOptionMenu(z);
        C4990ab.m7411d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", Boolean.valueOf(z));
        setProgressBarIndeterminateVisibility(false);
        if (z2) {
            this.uuX.finish();
            this.uwI.cZJ();
            AppMethodBeat.m2505o(8070);
            return;
        }
        if (!(this.uwn || this.uwp)) {
            this.uuX.start();
        }
        AppMethodBeat.m2505o(8070);
    }

    /* Access modifiers changed, original: protected */
    public void afL(String str) {
        AppMethodBeat.m2504i(8071);
        if (this.icz.cZT().dmk()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.icy.mo15533a(str, this.icz.cZS().mo69833jB(7), bundle)) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = ".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(8071);
            return;
        }
        C4990ab.m7420w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
        AppMethodBeat.m2505o(8071);
    }

    /* Access modifiers changed, original: protected */
    public boolean afM(String str) {
        AppMethodBeat.m2504i(8072);
        for (C43967b c43967b : this.uvJ) {
            if (WebViewUI.m26210a(c43967b, str)) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "url handled, url = ".concat(String.valueOf(str)));
                if (this.uxd.equals(str)) {
                    C4990ab.m7416i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    AppMethodBeat.m2505o(8072);
                    return true;
                }
                C4990ab.m7416i("MicroMsg.WebViewUI", "url handled, ret = " + c43967b.afM(str) + ", url = " + str);
                AppMethodBeat.m2505o(8072);
                return true;
            }
        }
        AppMethodBeat.m2505o(8072);
        return false;
    }

    public final String afN(String str) {
        AppMethodBeat.m2504i(8073);
        String str2 = "";
        if (!(TextUtils.isEmpty(str) || this.icy == null)) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_binder_id", hashCode());
            bundle.putString("rawUrl", str);
            try {
                str2 = C5046bo.nullAsNil(this.icy.mo15575g(76, bundle).getString("appId"));
                C4990ab.m7417i("MicroMsg.WebViewUI", "stev cachedAppId %s", str2);
            } catch (RemoteException e) {
                C4990ab.m7421w("MicroMsg.WebViewUI", "get cachedAppId error ", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(8073);
        return str2;
    }

    /* renamed from: l */
    public final void mo31009l(String str, long j, int i) {
        AppMethodBeat.m2504i(8074);
        final String str2 = str;
        final long j2 = j;
        final int i2 = i;
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.m2504i(7864);
                Looper.myQueue().removeIdleHandler(this);
                WebViewUI.this.mo31011m(str2, j2, i2);
                AppMethodBeat.m2505o(7864);
                return false;
            }
        });
        AppMethodBeat.m2505o(8074);
    }

    private boolean dav() {
        AppMethodBeat.m2504i(8076);
        if (System.currentTimeMillis() - this.uvo < 300) {
            AppMethodBeat.m2505o(8076);
            return true;
        }
        AppMethodBeat.m2505o(8076);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: as */
    public C16953w mo30966as(String str, boolean z) {
        AppMethodBeat.m2504i(8077);
        C16953w j = m26235j(str, z, -1);
        AppMethodBeat.m2505o(8077);
        return j;
    }

    /* renamed from: j */
    private C16953w m26235j(String str, boolean z, int i) {
        AppMethodBeat.m2504i(8078);
        C16953w c16953w;
        if (this.uwA || this.uwB || isFinishing()) {
            c16953w = C16953w.FAILED;
            AppMethodBeat.m2505o(8078);
            return c16953w;
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
            C4990ab.m7412e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            c16953w = C16953w.FAILED;
            AppMethodBeat.m2505o(8078);
            return c16953w;
        } else if (this.uvs) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.icz.mo63705a(str, null, null);
            c16953w = C16953w.NO_NEED;
            AppMethodBeat.m2505o(8078);
            return c16953w;
        } else {
            Object obj = (this.icy != null && this.uwo.contains(str) && afI(str)) ? 1 : null;
            if ((this.icz.has(str) || obj != null) && !z) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(str)));
                this.uvW = this.icz.cZS().mo69833jB(24);
                c16953w = C16953w.NO_NEED;
                AppMethodBeat.m2505o(8078);
                return c16953w;
            }
            int ael;
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int afH = afH(stringExtra);
            if (i == -1) {
                ael = this.uvR.ael(str);
            } else {
                ael = i;
            }
            C4990ab.m7417i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, subScene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", str, Integer.valueOf(afH), Integer.valueOf(i2), stringExtra, Integer.valueOf(ael), Boolean.valueOf(z), getIntent().getStringExtra("key_function_id"), Integer.valueOf(getIntent().getIntExtra("key_wallet_region", 0)));
            if (i != 5) {
                mo30947X(true, false);
            }
            this.uwo.add(str);
            this.icz.mo63705a(str, null, null);
            this.uvW = this.icz.cZS().mo69833jB(24);
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
            bundle.putString("geta8key_data_net_type", C40259aq.cXS());
            bundle.putInt("geta8key_session_id", this.uvB);
            if (!C5046bo.isNullOrNil(getIntent().getStringExtra("k_share_url"))) {
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
                z2 = this.icy.mo15590s(C31128d.MIC_PTU_MEISHI, bundle);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
            }
            C4990ab.m7416i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = ".concat(String.valueOf(z2)));
            C40262m cXU = this.ulI.cXU();
            ael = this.cSQ;
            stringExtra = this.cMm;
            cXU.cSQ = ael;
            cXU.uni = stringExtra;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!cXU.unu.containsKey(str)) {
                cXU.unu.put(str, Long.valueOf(C5046bo.anU()));
            }
            C7060h.pYm.mo8378a(154, 11, 1, false);
            this.uwE.mo69758aI("getA8KeyStart", System.currentTimeMillis());
            c16953w = C16953w.WILL_GET;
            AppMethodBeat.m2505o(8078);
            return c16953w;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int afH(String str) {
        AppMethodBeat.m2504i(8079);
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.icy == null) {
                intExtra = 1;
            } else {
                try {
                    if (this.icy.mo15587nI(str)) {
                        intExtra = 8;
                    } else if (this.icy.mo15586mZ(str)) {
                        intExtra = 7;
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_biz_username", str);
                        try {
                            bundle = this.icy.mo15575g(102, bundle);
                            if (bundle != null && bundle.getBoolean("is_enterprise_username")) {
                                intExtra = 51;
                            }
                        } catch (RemoteException e) {
                            C4990ab.m7412e("MicroMsg.WebViewUI", "invoke the check enterprise failed");
                        }
                    } else {
                        intExtra = 1;
                    }
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "getScene fail, ex = " + e2.getMessage());
                    intExtra = 1;
                }
            }
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", Integer.valueOf(intExtra));
        AppMethodBeat.m2505o(8079);
        return intExtra;
    }

    private boolean afO(String str) {
        AppMethodBeat.m2504i(8080);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            AppMethodBeat.m2505o(8080);
            return false;
        }
        m26181Jr(106);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        bundle.putInt("webview_binder_id", hashCode());
        try {
            this.icy.mo15590s(106, bundle);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        AppMethodBeat.m2505o(8080);
        return true;
    }

    private boolean afP(String str) {
        AppMethodBeat.m2504i(8081);
        C4990ab.m7416i("MicroMsg.WebViewUI", "dealCustomScheme, url = ".concat(String.valueOf(str)));
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(8081);
            return false;
        }
        try {
            if (this.icy.mo15573dq(str)) {
                C4990ab.m7416i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(str)));
                this.icy.mo15570dB(str, hashCode());
                AppMethodBeat.m2505o(8081);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        final Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            String replace;
            Intent intent;
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                replace = str.replace(com.tencent.smtt.sdk.WebView.SCHEME_TEL, "");
                if (!C5046bo.isNullOrNil(replace)) {
                    try {
                        this.icy.mo15572dD(replace, hashCode());
                    } catch (Exception e2) {
                        C4990ab.m7421w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", e2.getMessage());
                    }
                }
                AppMethodBeat.m2505o(8081);
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(268435456);
                try {
                    startActivity(intent);
                } catch (Exception e22) {
                    C4990ab.m7413e("MicroMsg.WebViewUI", "start sms app failed:[%s]", e22.getMessage());
                }
                AppMethodBeat.m2505o(8081);
                return true;
            } else if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_MAILTO)) {
                intent = new Intent("android.intent.action.SENDTO");
                intent.addFlags(268435456);
                intent.setData(parse);
                try {
                    startActivity(intent);
                } catch (Exception e222) {
                    C4990ab.m7413e("MicroMsg.WebViewUI", "start mailto app failed:[%s]", e222.getMessage());
                }
                AppMethodBeat.m2505o(8081);
                return true;
            } else {
                try {
                    boolean z = (this.icz.cZT().vxG & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
                    C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(z)));
                    if (z || this.icy == null || !this.icy.cZd()) {
                        int intExtra = getIntent().getIntExtra("key_download_restrict", 0);
                        if (!C5046bo.isNullOrNil(getIntent().getStringExtra("key_function_id"))) {
                            C7060h.pYm.mo8381e(14596, getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(1));
                        }
                        if (intExtra == 1) {
                            C4990ab.m7413e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", str);
                            AppMethodBeat.m2505o(8081);
                            return true;
                        }
                        C4990ab.m7417i("MicroMsg.WebViewUI", "scheme launch interval ; %d", Long.valueOf(C5046bo.anT() - this.uxi));
                        if (C5046bo.anT() - this.uxi <= 2) {
                            replace = dae();
                            try {
                                replace = C18178q.encode(replace, "UTF-8");
                                str = C18178q.encode(str, "UTF-8");
                            } catch (Exception e3) {
                                C4990ab.m7416i("MicroMsg.WebViewUI", "formate url failed");
                            }
                            C7060h.pYm.mo8381e(13983, Integer.valueOf(4), replace, str);
                        }
                        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                            z = C26006a.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(7865);
                                    WebViewUI webViewUI = WebViewUI.this;
                                    Uri uri = parse;
                                    if (webViewUI == null || uri == null) {
                                        C4990ab.m7416i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
                                        AppMethodBeat.m2505o(7865);
                                        return;
                                    }
                                    C4990ab.m7416i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
                                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                                    intent.addFlags(268435456);
                                    C46494g.m87725a(webViewUI, intent, null, null, null);
                                    AppMethodBeat.m2505o(7865);
                                }
                            });
                            AppMethodBeat.m2505o(8081);
                            return z;
                        }
                        intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(268435456);
                        if (C5046bo.m7572k((Context) this, intent)) {
                            startActivity(intent);
                            AppMethodBeat.m2505o(8081);
                            return true;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                    AppMethodBeat.m2505o(8081);
                    return true;
                } catch (RemoteException e4) {
                    C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e4, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(8081);
        return false;
    }

    /* renamed from: a */
    private void m26206a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.m2504i(8082);
        if (!C5046bo.isNullOrNil(str2)) {
            this.icz.mo63705a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.uwo.remove(str2);
            this.uwq = false;
            this.jUg = str2;
        }
        if (m26233hh(str, str2)) {
            this.icz.mo63705a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uwo.remove(str);
            AppMethodBeat.m2505o(8082);
        } else if (this.icy == null || C5046bo.isNullOrNil(str) || !afI(str)) {
            AppMethodBeat.m2505o(8082);
        } else {
            this.icz.mo63705a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.uwo.remove(str);
            AppMethodBeat.m2505o(8082);
        }
    }

    /* Access modifiers changed, original: protected */
    public void daw() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo30968b(C22913c c22913c) {
        AppMethodBeat.m2504i(8083);
        C4990ab.m7416i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
        if (this.pzf == null) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
            AppMethodBeat.m2505o(8083);
        } else if (isFinishing() || this.icz == null) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
            AppMethodBeat.m2505o(8083);
        } else {
            int i;
            int i2;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            String str = null;
            Bundle bundle = null;
            try {
                i3 = c22913c.getType();
                i4 = c22913c.cYW();
                i5 = c22913c.cYX();
                str = c22913c.adx();
                bundle = c22913c.getData();
                i = i5;
                i2 = i4;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + e.getMessage());
                i = i5;
                i2 = i4;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            C4990ab.m7417i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", Integer.valueOf(bundle.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode()));
            C4990ab.m7416i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + i3 + ", errCode = " + i + ", errType = " + i2);
            if (bundle.getInt("scene_end_listener_hash_code") != hashCode()) {
                C4990ab.m7412e("MicroMsg.WebViewUI", "hash code not equal");
                AppMethodBeat.m2505o(8083);
            } else if (i3 == C31128d.MIC_PTU_MEISHI || i3 == 131 || i3 == 106 || i3 == 673 || i3 == 666 || i3 == 1254 || i3 == 1373) {
                String str2;
                boolean z;
                switch (i3) {
                    case 106:
                        finish();
                        AppMethodBeat.m2505o(8083);
                        return;
                    case C31128d.MIC_PTU_MEISHI /*233*/:
                        this.uvS.daO();
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1"));
                        this.uxn = bundle.getLong("geta8key_result_deep_link_bit_set", 0);
                        this.uwI.utF = bundle.getString("geta8key_result_menu_wording");
                        int i6 = bundle.getInt("geta8key_result_reason");
                        C4990ab.m7416i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(i6)));
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
                                    C40346m.uuj.mo63711Jq(i2);
                                    str = bundle.getString("geta8key_result_req_url");
                                    if (!(this.uwh == null || afI(str))) {
                                        this.uwh.setVisibility(0);
                                        mo30947X(true, true);
                                    }
                                    this.ulI.cYa().unc = false;
                                    this.ulI.cXU().mo63620bE(str, false);
                                    C7060h.pYm.mo8378a(154, 12, 1, false);
                                    i3 = C35641b.m58494Jh(i6);
                                    if (-1 != i3) {
                                        C7060h.pYm.mo8378a(154, (long) i3, 1, false);
                                    }
                                    mo30941G(bundle);
                                    if (this.uvy) {
                                        finish();
                                        break;
                                    }
                                }
                                str2 = bundle.getString("geta8key_result_full_url");
                                m26206a(bundle.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                mo30942H(bundle);
                                this.uvW = jsapiPermissionWrapper.mo69833jB(24);
                                this.ulI.cYa().unc = true;
                                this.uvD = bundle.getByteArray("geta8key_result_cookie");
                                C4990ab.m7411d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", C5046bo.m7543cd(this.uvD));
                                break;
                                break;
                            case 1:
                            case 5:
                                if (i2 != 0 || i != 0) {
                                    if (i2 != 4 || i != -2005) {
                                        if (i2 != 0 && i == -3300) {
                                            C4990ab.m7413e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", Integer.valueOf(i2), Integer.valueOf(i));
                                            this.uvE = true;
                                            break;
                                        }
                                        C7060h.pYm.mo8378a(154, 12, 1, false);
                                        C7060h.pYm.mo8378a(154, (long) C35641b.m58494Jh(i6), 1, false);
                                        mo30947X(true, true);
                                        break;
                                    }
                                    this.pzf.stopLoading();
                                    this.uvG = false;
                                    str2 = bundle.getString("geta8key_result_full_url");
                                    m26206a(bundle.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                    mo30942H(bundle);
                                    this.uvD = bundle.getByteArray("geta8key_result_cookie");
                                    C4990ab.m7411d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", C5046bo.m7543cd(this.uvD));
                                    break;
                                }
                                str2 = bundle.getString("geta8key_result_req_url");
                                this.icz.mo63705a(str2, jsapiPermissionWrapper, generalControlWrapper);
                                this.uwo.remove(str2);
                                if (this.uww) {
                                    mo30947X(true, true);
                                    this.uww = false;
                                }
                                if (i6 != 5) {
                                    this.uvW = jsapiPermissionWrapper.mo69833jB(24);
                                }
                                this.uvD = bundle.getByteArray("geta8key_result_cookie");
                                C4990ab.m7411d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", C5046bo.m7543cd(this.uvD));
                                break;
                                break;
                        }
                        m26194Y(this.icz.aei(str2).mo69833jB(34), this.icz.aei(str2).mo69833jB(75));
                        if (i2 == 0 && i == 0) {
                            C40326j c40326j = this.uwI;
                            c40326j.utK.add(Integer.valueOf(6));
                            c40326j.utK.add(Integer.valueOf(1));
                            c40326j.utK.add(Integer.valueOf(3));
                            c40326j.utK.add(Integer.valueOf(2));
                            this.uwI.utI = true;
                            if (this.uwI.utJ) {
                                cZM();
                            }
                        } else {
                            this.uwI.utI = false;
                        }
                        this.uwE.mo69758aI("getA8KeyEnd", System.currentTimeMillis());
                        daw();
                        AppMethodBeat.m2505o(8083);
                        return;
                    case 666:
                        C14585q c14585q = this.uvU;
                        c14585q.uxP--;
                        if (c14585q.uxP <= 0) {
                            WebViewUI.this.m26182Js(666);
                        }
                        finish();
                        AppMethodBeat.m2505o(8083);
                        return;
                    case 673:
                        C16951o c16951o = this.uvT;
                        c16951o.uxO--;
                        if (c16951o.uxO <= 0) {
                            WebViewUI.this.m26182Js(673);
                        }
                        if (i2 == 0 && i == 0) {
                            str2 = bundle != null ? bundle.getString("reading_mode_result_url") : null;
                            C4990ab.m7417i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", str2);
                            if (C5046bo.isNullOrNil(str2)) {
                                C4990ab.m7416i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                                AppMethodBeat.m2505o(8083);
                                return;
                            }
                            mo30970b(str2, null, false);
                            AppMethodBeat.m2505o(8083);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                        AppMethodBeat.m2505o(8083);
                        return;
                    case 1254:
                        z = i2 == 0 && i == 0;
                        C46434d c46434d = this.icy;
                        C14508d c14508d = this.uxk;
                        C14507b c14507b = this.uxl;
                        int hashCode = hashCode();
                        C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", Boolean.valueOf(z));
                        c14508d.blb();
                        c14507b.remove(1254);
                        long currentTimeMillis = System.currentTimeMillis();
                        String aep = bundle == null ? "" : C29814c.aep(bundle.getString("oauth_url"));
                        C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "parse appID:%s", aep);
                        if (!z) {
                            C30379h.m48438a((Context) this, str, C4996ah.getContext().getString(C25738R.string.g0a), new C228772(c14508d));
                            C22784a c22784a = C22784a.uKJ;
                            if (aep == null) {
                                str = "";
                            } else {
                                str = aep;
                            }
                            C22784a.m34564a(str, currentTimeMillis, 2, 1, 0, 0, i);
                            AppMethodBeat.m2505o(8083);
                            return;
                        } else if (bundle == null) {
                            C4990ab.m7412e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                            AppMethodBeat.m2505o(8083);
                            return;
                        } else {
                            z = bundle.getBoolean("is_recent_has_auth");
                            boolean z2 = bundle.getBoolean("is_silence_auth");
                            if (z || z2) {
                                String string = bundle.getString("redirect_url");
                                if (C5046bo.isNullOrNil(string)) {
                                    C4990ab.m7412e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                    AppMethodBeat.m2505o(8083);
                                    return;
                                }
                                C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", Boolean.valueOf(z), Boolean.valueOf(z2), string);
                                C37918c.m64041a(this, C32791a.OPENSDK, aep, new C228783(c14508d, aep, currentTimeMillis, i, string));
                                AppMethodBeat.m2505o(8083);
                                return;
                            }
                            C249284 c249284 = new C249284(this, aep, c14508d, currentTimeMillis, i, bundle, c46434d, c14507b, hashCode);
                            if ((this instanceof WebViewUI) && isFinishing()) {
                                C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                                AppMethodBeat.m2505o(8083);
                                return;
                            }
                            new C40353n(this).mo63720a(C43907af.m78752aa((ArrayList) bundle.getSerializable("scope_list")), bundle.getString("appname"), bundle.getString("appicon_url"), getString(C25738R.string.g0l), c249284);
                            AppMethodBeat.m2505o(8083);
                            return;
                        }
                    case 1373:
                        z = i2 == 0 && i == 0;
                        C14508d c14508d2 = this.uxk;
                        C14507b c14507b2 = this.uxl;
                        C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", Boolean.valueOf(z));
                        c14507b2.remove(1373);
                        if (z) {
                            if (bundle != null) {
                                str2 = bundle.getString("redirect_url");
                                if (!C5046bo.isNullOrNil(str2)) {
                                    c14508d2.aeq(str2);
                                    C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", str2);
                                    break;
                                }
                                C4990ab.m7412e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                                AppMethodBeat.m2505o(8083);
                                return;
                            }
                            C4990ab.m7412e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                            AppMethodBeat.m2505o(8083);
                            return;
                        }
                        C30379h.m48438a((Context) this, str, C4996ah.getContext().getString(C25738R.string.g0a), new C298165(c14508d2));
                        AppMethodBeat.m2505o(8083);
                        return;
                }
                AppMethodBeat.m2505o(8083);
            } else {
                AppMethodBeat.m2505o(8083);
            }
        }
    }

    /* renamed from: Y */
    private void m26194Y(boolean z, boolean z2) {
        AppMethodBeat.m2504i(8084);
        if (z) {
            setMMSubTitle((int) C25738R.string.g0d);
            if (!this.uvv) {
                this.uvv = true;
                AppMethodBeat.m2505o(8084);
                return;
            }
        } else if (z2) {
            setMMSubTitle((int) C25738R.string.g0p);
            AppMethodBeat.m2505o(8084);
            return;
        } else {
            setMMSubTitle(null);
        }
        AppMethodBeat.m2505o(8084);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo30972c(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(8085);
        String bc = C5046bo.m7532bc(dae(), this.cOG);
        if (C5046bo.isNullOrNil(bc)) {
            C4990ab.m7412e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            mo30970b(str2, null, false);
            AppMethodBeat.m2505o(8085);
        } else if (this.uhz == null) {
            if (map == null || map.size() <= 0) {
                mo30970b(str2, null, false);
                AppMethodBeat.m2505o(8085);
                return;
            }
            mo30970b(str2, (Map) map, false);
            AppMethodBeat.m2505o(8085);
        } else if (!C5046bo.nullAsNil(str2).contains("#wechat_redirect") && !C5046bo.nullAsNil(str).contains("#wechat_redirect")) {
            if (!m26233hh(bc, str2)) {
                boolean z;
                String aeN = C14525q.aeN(bc);
                String aeN2 = C14525q.aeN(str2);
                if (C5046bo.isNullOrNil(aeN2) || C5046bo.isNullOrNil(aeN) || !aeN2.equals(aeN) || this.icy == null || !afI(bc)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    if (map == null || map.size() <= 0) {
                        mo30970b(str2, null, false);
                        AppMethodBeat.m2505o(8085);
                        return;
                    }
                    mo30970b(str2, (Map) map, false);
                    AppMethodBeat.m2505o(8085);
                    return;
                }
            }
            this.uwx.put(bc, str2);
            this.uwr.put(bc, map);
            this.uwx.put(str, str2);
            this.uwr.put(str, map);
            this.uhz.mo71943z(str2, map);
            AppMethodBeat.m2505o(8085);
        } else if (map == null || map.size() <= 0) {
            mo30970b(str2, null, false);
            AppMethodBeat.m2505o(8085);
        } else {
            mo30970b(str2, (Map) map, false);
            AppMethodBeat.m2505o(8085);
        }
    }

    /* renamed from: hh */
    private boolean m26233hh(String str, String str2) {
        AppMethodBeat.m2504i(8086);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(8086);
            return false;
        }
        if (C14445a.uet.matcher(str).matches() && C14445a.uet.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.icy != null && afI(str)) {
                AppMethodBeat.m2505o(8086);
                return true;
            }
        }
        AppMethodBeat.m2505o(8086);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: H */
    public boolean mo30942H(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(8087);
        C4990ab.m7411d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        if (getIntent().getBooleanExtra("k_has_http_header", false) && (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0)) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "use intent httpheader info");
            getIntent().putExtra("k_has_http_header", false);
            stringArray = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
            stringArray2 = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
            getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
            getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", Integer.valueOf(i), string, string2, string3);
        HashMap hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.uws = hashMap;
        if (C5046bo.isNullOrNil(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        C40259aq.m69038V(this.pzf.getIsX5Kernel(), C5046bo.nullAsNil(str).startsWith("https://"));
        this.ulI.cXU().mo63620bE(string4, true);
        C40258f cXW = this.ulI.cXW();
        int i3 = this.cSQ;
        String str2 = this.cMm;
        cXW.cSQ = i3;
        cXW.uni = str2;
        if (C5046bo.isNullOrNil(string2)) {
            C4990ab.m7412e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            cXW.iCz = string2;
            cXW.unh = true;
            if (!cXW.unf.containsKey(string2)) {
                cXW.unf.put(string2, Long.valueOf(C5046bo.anU()));
            }
            if (!cXW.ung.containsKey(string2)) {
                cXW.ung.put(string2, Long.valueOf(C5046bo.anU()));
            }
        }
        boolean afP;
        switch (i) {
            case 1:
                C4990ab.m7416i("MicroMsg.WebViewUI", "getA8key-text: ".concat(String.valueOf(string3)));
                if (string3 == null || string3.length() == 0) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    AppMethodBeat.m2505o(8087);
                    return false;
                }
                this.pzf.getSettings().setJavaScriptEnabled(false);
                this.pzf.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                AppMethodBeat.m2505o(8087);
                return true;
            case 2:
                C4990ab.m7416i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    AppMethodBeat.m2505o(8087);
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (afQ(string2)) {
                    mo30972c(string4, string2, hashMap);
                    AppMethodBeat.m2505o(8087);
                    return true;
                }
                C4990ab.m7414f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                dah();
                AppMethodBeat.m2505o(8087);
                return true;
            case 3:
                C4990ab.m7416i("MicroMsg.WebViewUI", "getA8key-app: ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                    AppMethodBeat.m2505o(8087);
                    return false;
                }
                afP = afP(string2);
                AppMethodBeat.m2505o(8087);
                return afP;
            case 4:
                afP = afO(string2);
                AppMethodBeat.m2505o(8087);
                return afP;
            case 6:
                C4990ab.m7416i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(string2)));
                if (string2 == null || string2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    AppMethodBeat.m2505o(8087);
                    return false;
                } else if (afQ(string2)) {
                    mo30970b(string2, null, false);
                    mo31012nO(false);
                    AppMethodBeat.m2505o(8087);
                    return true;
                } else {
                    C4990ab.m7414f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                    dah();
                    AppMethodBeat.m2505o(8087);
                    return true;
                }
            case 7:
            case 30:
                C4990ab.m7416i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    AppMethodBeat.m2505o(8087);
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (afQ(string2)) {
                    mo30972c(string4, string2, hashMap);
                    AppMethodBeat.m2505o(8087);
                    return true;
                }
                C4990ab.m7414f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = ".concat(String.valueOf(string2)));
                dah();
                AppMethodBeat.m2505o(8087);
                return true;
            case 20:
                if (C5046bo.isNullOrNil(string2)) {
                    C4990ab.m7412e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    C14585q c14585q = this.uvU;
                    if (c14585q.uxP == 0) {
                        WebViewUI.this.m26181Jr(666);
                    }
                    c14585q.uxP++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    bundle2.putInt("webview_binder_id", hashCode());
                    try {
                        this.icy.mo15590s(666, bundle2);
                    } catch (Exception e) {
                        C4990ab.m7420w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(8087);
                return true;
            default:
                C4990ab.m7416i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(8087);
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: G */
    public void mo30941G(Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public boolean dax() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean day() {
        return false;
    }

    /* renamed from: Jv */
    private void m26183Jv(int i) {
        AppMethodBeat.m2504i(8089);
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.uhz != null) {
            this.uhz.mo71877JK(i);
        }
        FontChooserView fontChooserView = (FontChooserView) this.uvb.findViewById(2131829157);
        if (fontChooserView != null) {
            fontChooserView.setSliderIndex(i - 1);
        }
        AppMethodBeat.m2505o(8089);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Jw */
    public void mo30945Jw(int i) {
        AppMethodBeat.m2504i(8090);
        if (this.pzf == null || this.pzf.getSettings() == null) {
            AppMethodBeat.m2505o(8090);
            return;
        }
        C4990ab.m7416i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(i)));
        switch (i) {
            case 1:
                this.pzf.getSettings().mo58389a(C6033a.SMALLER);
                AppMethodBeat.m2505o(8090);
                return;
            case 3:
                this.pzf.getSettings().mo58389a(C6033a.LARGER);
                AppMethodBeat.m2505o(8090);
                return;
            case 4:
                this.pzf.getSettings().mo58389a(C6033a.LARGEST);
                AppMethodBeat.m2505o(8090);
                return;
            default:
                this.pzf.getSettings().mo58389a(C6033a.NORMAL);
                AppMethodBeat.m2505o(8090);
                return;
        }
    }

    private final boolean afQ(String str) {
        AppMethodBeat.m2504i(8091);
        if (C1947ae.giw) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            AppMethodBeat.m2505o(8091);
            return true;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(8091);
            return true;
        } else if (this.uvl) {
            C4990ab.m7417i("MicroMsg.WebViewUI", "albie: trust this url(%s)", str);
            AppMethodBeat.m2505o(8091);
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("file://")) {
                for (String t : ums) {
                    if (C30152u.m47751t(toLowerCase, t)) {
                        AppMethodBeat.m2505o(8091);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(8091);
                return false;
            }
            AppMethodBeat.m2505o(8091);
            return true;
        }
    }

    private void daA() {
        AppMethodBeat.m2504i(8092);
        if (this.pzf == null || this.icy == null) {
            C4990ab.m7416i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
            AppMethodBeat.m2505o(8092);
            return;
        }
        try {
            this.pzf.removeJavascriptInterface("searchBoxJavaBridge_");
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", e.getMessage());
        }
        if (this.uxo == null) {
            try {
                if (this.icy.cZd()) {
                    this.uxo = this.icy.cZe();
                }
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", e2.getMessage());
            }
        }
        String str = "MicroMsg.WebViewUI";
        String str2 = "removeConfigJsInterface, to remove list size = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.uxo == null ? 0 : this.uxo.length);
        C4990ab.m7417i(str, str2, objArr);
        if (this.uxo == null || this.uxo.length == 0) {
            AppMethodBeat.m2505o(8092);
            return;
        }
        try {
            for (String str3 : this.uxo) {
                C4990ab.m7417i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", str3);
                this.pzf.removeJavascriptInterface(str3);
            }
            AppMethodBeat.m2505o(8092);
        } catch (Exception e22) {
            C4990ab.m7413e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", e22.getMessage());
            AppMethodBeat.m2505o(8092);
        }
    }

    public final boolean cWG() {
        AppMethodBeat.m2504i(8093);
        if (this.uwe == null || !this.uwe.cXi() || C5046bo.isNullOrNil(this.uwe.daM()) || C5046bo.isNullOrNil(this.uwe.cXk()) || C5046bo.isNullOrNil(this.uwe.cXl())) {
            AppMethodBeat.m2505o(8093);
            return false;
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", this.uwe.daM(), this.uwe.cXk(), this.uwe.cXl());
        View inflate = View.inflate(this.mController.ylL, 2130970090, null);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(2131825970);
        checkBox.setChecked(false);
        checkBox.setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(2131825969);
        textView.setText(r6);
        textView.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        textView = (TextView) inflate.findViewById(2131825971);
        textView.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        textView.setVisibility(8);
        this.uwf = C30379h.m48451a(this.mController.ylL, true, "", inflate, r4, r5, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(7877);
                if (checkBox != null && checkBox.isChecked()) {
                    try {
                        if (WebViewUI.this.icy.cZd()) {
                            WebViewUI.this.icy.mo15578gx(327792, 1);
                        }
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
                    }
                }
                WebViewUI.this.uwA = true;
                WebViewUI.this.uwf = null;
                C40346m.uuj.close();
                WebViewUI.this.finish();
                AppMethodBeat.m2505o(7877);
            }
        }, new C1694848());
        AppMethodBeat.m2505o(8093);
        return true;
    }

    private boolean daB() {
        AppMethodBeat.m2504i(8094);
        int intExtra = getIntent().getIntExtra("key_close_action", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("key_close_data");
        C4990ab.m7417i("MicroMsg.WebViewUI", "close action %s", Integer.valueOf(intExtra));
        switch (intExtra) {
            case 1:
                if (bundleExtra != null) {
                    String string = bundleExtra.getString("close_dialog_title");
                    String string2 = bundleExtra.getString("close_dialog_msg");
                    String string3 = bundleExtra.getString("close_dialog_ok");
                    String string4 = bundleExtra.getString("close_dialog_cancel");
                    boolean z = bundleExtra.getBoolean("close_dialog_ok_close", true);
                    if (!C5046bo.m7510Q(string2, string3, string4)) {
                        if (z) {
                            C30379h.m48445a((Context) this, string, string2, string3, string4, false, new C1457549(), null);
                        } else {
                            C30379h.m48445a((Context) this, string, string2, string3, string4, false, null, new C1699450());
                        }
                        AppMethodBeat.m2505o(8094);
                        return true;
                    }
                }
                break;
            case 2:
                if (bundleExtra != null) {
                    String string5 = bundleExtra.getString("close_jump_url");
                    int i = bundleExtra.getInt("close_jump_url_request_code", 0);
                    if (!C5046bo.isNullOrNil(string5)) {
                        Intent intent = new Intent(this, WebViewUI.class);
                        intent.putExtra("rawUrl", string5);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                        startActivityForResult(intent, i);
                        C5274b.m8055hN(this);
                        AppMethodBeat.m2505o(8094);
                        return true;
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(8094);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void daC() {
        AppMethodBeat.m2504i(8095);
        if (daB()) {
            AppMethodBeat.m2505o(8095);
            return;
        }
        daD();
        if (!cWG()) {
            this.uwA = true;
            C40346m.uuj.close();
            if (this.uie.mo38526Jx(20)) {
                AppMethodBeat.m2505o(8095);
                return;
            }
            finish();
        }
        AppMethodBeat.m2505o(8095);
    }

    private void daD() {
        AppMethodBeat.m2504i(8096);
        if (this.uwC) {
            C4990ab.m7410d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
            AppMethodBeat.m2505o(8096);
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
            C9549f.m17012a("com.tencent.mm", bundle, C30071u.class, null);
        }
        AppMethodBeat.m2505o(8096);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: jD */
    public void mo31008jD(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: j */
    public void mo9685j(int i, Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public boolean aYb() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: t */
    public void mo9678t(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8097);
        C4990ab.m7416i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
        AppMethodBeat.m2505o(8097);
    }

    /* renamed from: nR */
    public final void mo31014nR(boolean z) {
        AppMethodBeat.m2504i(8098);
        String url = this.pzf.getUrl();
        if (z) {
            showOptionMenu(0, false);
            this.uwd.put(url, Boolean.TRUE);
            AppMethodBeat.m2505o(8098);
            return;
        }
        showOptionMenu(0, true);
        if (this.uwd.containsKey(url)) {
            this.uwd.remove(url);
        }
        AppMethodBeat.m2505o(8098);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean daE() {
        AppMethodBeat.m2504i(8099);
        if (this.jYe != -3) {
            showVKB();
            AppMethodBeat.m2505o(8099);
            return true;
        }
        AppMethodBeat.m2505o(8099);
        return false;
    }

    public final void aqX() {
        AppMethodBeat.m2504i(8100);
        super.aqX();
        this.jYe = -2;
        AppMethodBeat.m2505o(8100);
    }

    public final void showVKB() {
        AppMethodBeat.m2504i(8101);
        super.showVKB();
        if (this.jYe == -3) {
            this.jYe = -2;
            AppMethodBeat.m2505o(8101);
            return;
        }
        this.jYe = -3;
        AppMethodBeat.m2505o(8101);
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        AppMethodBeat.m2504i(8102);
        super.setBackBtn(onMenuItemClickListener, i);
        if (C1443d.m3068iW(21) && dac()) {
            dxZ();
        }
        AppMethodBeat.m2505o(8102);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cWO() {
        AppMethodBeat.m2504i(8103);
        C4990ab.m7417i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", Boolean.valueOf(getIntent().getBooleanExtra("forceHideShare", false)), Boolean.valueOf(getIntent().getBooleanExtra("showShare", true)), Boolean.valueOf(aYc()));
        if (!getIntent().getBooleanExtra("forceHideShare", false) && r3 && aYc()) {
            AppMethodBeat.m2505o(8103);
            return true;
        }
        AppMethodBeat.m2505o(8103);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aYc() {
        boolean z;
        AppMethodBeat.m2504i(8104);
        if (!getClass().equals(WebViewUI.class) || getIntent().getBooleanExtra("disable_minimize", false)) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", getClass(), Boolean.valueOf(z));
        AppMethodBeat.m2505o(8104);
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
        AppMethodBeat.m2504i(8105);
        if (C5046bo.isEqual(intent.getType(), "application/vnd.android.package-archive")) {
            C35800q.m58697a(C4996ah.getContext(), intent.getData(), null);
            AppMethodBeat.m2505o(8105);
            return;
        }
        super.startActivity(intent);
        AppMethodBeat.m2505o(8105);
    }

    /* Access modifiers changed, original: protected|final */
    public final void daG() {
        AppMethodBeat.m2504i(8106);
        overridePendingTransition(C25738R.anim.f8374cf, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(8106);
    }

    private boolean cZZ() {
        return this.uvf || this.uvg;
    }

    /* Access modifiers changed, original: protected */
    public int aMi() {
        AppMethodBeat.m2504i(8001);
        int dyj = this.mController.dyj();
        AppMethodBeat.m2505o(8001);
        return dyj;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dad() {
        AppMethodBeat.m2504i(8003);
        if (!C1443d.m3068iW(21) || this.nfs == 0) {
            setStatusBarColor(aMi());
            AppMethodBeat.m2505o(8003);
            return;
        }
        mo17446xE(this.nfs);
        if (dac()) {
            dxZ();
            mo17443ta(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
        }
        mo30967at(this.nfs, dac());
        AppMethodBeat.m2505o(8003);
    }

    /* Access modifiers changed, original: protected */
    public MMWebView aXX() {
        AppMethodBeat.m2504i(8007);
        MMWebView in = C30798a.m49145in(this);
        AppMethodBeat.m2505o(8007);
        return in;
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.m2504i(8062);
        if (C1443d.m3068iW(21)) {
            Drawable g = C0380b.m649g(this, i2);
            if (g == null) {
                AppMethodBeat.m2505o(8062);
                return;
            }
            if (dac()) {
                g.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            } else if (this.uwO == null || this.uwO.uxW) {
                g.clearColorFilter();
            } else {
                g.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
            }
            mo17378a(i, getString(C25738R.string.f9169rn), g, onMenuItemClickListener);
            AppMethodBeat.m2505o(8062);
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        AppMethodBeat.m2505o(8062);
    }

    /* renamed from: m */
    public final void mo31011m(String str, long j, int i) {
        AppMethodBeat.m2504i(8075);
        if (C5023at.isConnected(getApplicationContext())) {
            if (C5023at.isWifi(getApplicationContext())) {
                this.networkType = 1;
            } else if (C5023at.is4G(getApplicationContext())) {
                this.networkType = 4;
            } else if (C5023at.is3G(getApplicationContext())) {
                this.networkType = 3;
            } else if (C5023at.is2G(getApplicationContext())) {
                this.networkType = 2;
            }
            C4990ab.m7417i("MicroMsg.WebViewUI", "get networkType %d", Integer.valueOf(this.networkType));
        }
        String afN = afN(this.uxh);
        if (this.fromScene != 0) {
            this.uxg = " ";
        }
        if (this.icz == null) {
            C4990ab.m7420w("MicroMsg.WebViewUI", "webpageVisitInfoReport wvPerm is null");
            AppMethodBeat.m2505o(8075);
            return;
        }
        GeneralControlWrapper cZT = this.icz.cZT();
        C4990ab.m7411d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", Boolean.valueOf(cZT != null ? cZT.dmm() : false));
        if (this.iBE > 0 && this.uxi > this.iBE && j > this.uxi && !TextUtils.isEmpty(afN) && r4) {
            long j2 = this.uxi - this.iBE;
            long j3 = j - this.uxi;
            C4990ab.m7411d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", Integer.valueOf(13376), Long.valueOf(this.iBE), afN, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.ium, this.uxh, this.cvF, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.uxg);
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            try {
                str2 = C18178q.encode(C5046bo.nullAsNil(this.ium), "UTF-8");
                str3 = C18178q.encode(C5046bo.nullAsNil(this.uxh), "UTF-8");
                str4 = C18178q.encode(C5046bo.nullAsNil(str), "UTF-8");
                str5 = C18178q.encode(C5046bo.nullAsNil(this.uxg), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            C7060h.pYm.mo8381e(13376, Long.valueOf(this.iBE), afN, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.cvF, Integer.valueOf(i), str4, Integer.valueOf(this.fromScene), str5);
            this.fromScene = 0;
        }
        if (i == 1) {
            this.uxg = this.uxh;
            this.uxh = str;
            this.iBE = j;
        }
        AppMethodBeat.m2505o(8075);
    }

    private int daz() {
        AppMethodBeat.m2504i(8088);
        float f = this.mController.ylL.getSharedPreferences(C4996ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            AppMethodBeat.m2505o(8088);
            return 1;
        } else if (f == 1.125f) {
            AppMethodBeat.m2505o(8088);
            return 3;
        } else if (f == 1.25f || f == 1.375f || f == 1.625f) {
            AppMethodBeat.m2505o(8088);
            return 4;
        } else {
            AppMethodBeat.m2505o(8088);
            return 2;
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m26232h(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8114);
        View view = webViewUI.pzf.getView();
        view.scrollTo(view.getScrollX(), 0);
        C22884i cYb = webViewUI.ulI.cYb();
        cYb.une = new Object[]{webViewUI.cOG, Integer.valueOf(7)};
        cYb.mo38482b(webViewUI.icy);
        AppMethodBeat.m2505o(8114);
    }

    /* renamed from: m */
    static /* synthetic */ boolean m26239m(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(8121);
        if (webViewUI.uvi == null || !webViewUI.uvi.isShown()) {
            AppMethodBeat.m2505o(8121);
            return false;
        }
        AppMethodBeat.m2505o(8121);
        return true;
    }
}
