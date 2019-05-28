package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.device.yearclass.DeviceInfo;
import com.facebook.device.yearclass.YearClass;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.ae;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.aa;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaLink;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xwalk.core.XWalkCoreWrapper;

public class g implements com.tencent.mm.ui.MMActivity.a {
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static final HashSet<String> uGK;
    private static final LinkedList<Runnable> uGS = new LinkedList();
    private static boolean uGT = false;
    private static a uGU = new a() {
        public final void aCB() {
            AppMethodBeat.i(9047);
            com.tencent.mm.plugin.webview.modelcache.r.a.uor.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9046);
                    Runnable runnable = (Runnable) g.uGS.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        AppMethodBeat.o(9046);
                        return;
                    }
                    ab.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
                    g.uGT = false;
                    AppMethodBeat.o(9046);
                }
            });
            AppMethodBeat.o(9047);
        }
    };
    private WXMediaMessage cEl;
    public final int cIv;
    private Context context;
    public boolean eBB = false;
    private com.tencent.mm.modelgeo.d ecr = null;
    private Map<String, atz> ecv = new ConcurrentHashMap();
    public ProgressDialog ehJ = null;
    public com.tencent.mm.sdk.b.c hwv;
    private String jMp = null;
    private ak mzp;
    private ProgressDialog nBv;
    private boolean nPX;
    private float qfA = 0.0f;
    public com.tencent.mm.sdk.b.c qwg = new com.tencent.mm.sdk.b.c<dt>() {
        {
            AppMethodBeat.i(9107);
            this.xxI = dt.class.getName().hashCode();
            AppMethodBeat.o(9107);
        }

        private boolean a(dt dtVar) {
            AppMethodBeat.i(9108);
            if (dtVar != null && (dtVar instanceof dt)) {
                System.currentTimeMillis();
                g.this.uGE;
                g.this.uGE = System.currentTimeMillis();
                String str = dtVar.cxk.cxi;
                int i = dtVar.cxk.cxl;
                int i2 = dtVar.cxk.cxm & CdnLogic.kBizGeneric;
                double d = dtVar.cxk.cxo;
                double d2 = dtVar.cxk.cxn;
                ab.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", str + "," + i + "," + i2 + "," + d);
                String str2 = str + "," + i + "," + i2;
                boolean z = false;
                List<aua> list;
                Iterator it;
                auc auc;
                if (g.this.ecv.containsKey(str2)) {
                    list = (List) g.this.uGB.get(str + "," + i);
                    if (list != null) {
                        for (aua aua : list) {
                            if (aua != null && aua.wxZ != null && !aua.wxZ.isEmpty()) {
                                it = aua.wxZ.iterator();
                                while (it.hasNext()) {
                                    auc = (auc) it.next();
                                    if (i2 >= auc.wya && i2 <= auc.wyb) {
                                        z = true;
                                        continue;
                                        break;
                                    }
                                }
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                } else {
                    atz atz = new atz();
                    atz.eCq = str;
                    atz.major = i;
                    atz.minor = i2;
                    g.this.ecv.put(str2, atz);
                    if (g.this.uGB.containsKey(str + "," + i)) {
                        list = (List) g.this.uGB.get(str + "," + i);
                        if (list != null) {
                            for (aua aua2 : list) {
                                boolean z2;
                                if (!(aua2 == null || aua2.wxZ == null || aua2.wxZ.isEmpty())) {
                                    Iterator it2 = aua2.wxZ.iterator();
                                    while (it2.hasNext()) {
                                        auc = (auc) it2.next();
                                        if (i2 >= auc.wya && i2 <= auc.wyb) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = z;
                                if (z2) {
                                    z = z2;
                                    break;
                                }
                                z = z2;
                            }
                        }
                    }
                    if (!z) {
                        g.this.uGC.add(atz);
                        String str3 = null;
                        if (!(g.this.uGd == null || g.this.uGd.puc == null)) {
                            Object obj = g.this.uGd.puc.get("url");
                            str3 = bo.nullAsNil(g.this.uGr.agj(obj != null ? obj.toString() : ""));
                        }
                        if (!g.this.uGD) {
                            g.this.uGD = true;
                            final m lVar = new l(g.this.uGC, bo.nullAsNil(str3));
                            g.this.uGC.clear();
                            com.tencent.mm.kernel.g.Rg().a(1704, new f() {
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(9106);
                                    if (i == 0 && i2 == 0) {
                                        afg afg = (afg) lVar.fAT.fsH.fsP;
                                        if (afg.luT == 0) {
                                            LinkedList<aua> linkedList = afg.wmG;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            for (aua aua : linkedList) {
                                                List list;
                                                String str2 = aua.eCq + "," + aua.major;
                                                if (g.this.uGB.containsKey(str2)) {
                                                    list = (List) g.this.uGB.get(str2);
                                                } else {
                                                    list = new ArrayList();
                                                    g.this.uGB.put(str2, list);
                                                }
                                                list.add(aua);
                                                stringBuilder.append("{uuid:" + aua.eCq + ",major:" + aua.major + ",minors:[");
                                                Iterator it = aua.wxZ.iterator();
                                                while (it.hasNext()) {
                                                    auc auc = (auc) it.next();
                                                    stringBuilder.append(auc.wya + "-" + auc.wyb + ",");
                                                }
                                                stringBuilder.append("]},");
                                            }
                                            ab.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + stringBuilder.toString());
                                        }
                                    }
                                    com.tencent.mm.kernel.g.Rg().b(1704, (f) this);
                                    g.this.uGD = false;
                                    AppMethodBeat.o(9106);
                                }
                            });
                            com.tencent.mm.kernel.g.Rg().a(lVar, 0);
                        }
                    }
                }
                ab.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", String.valueOf(z) + "," + str2);
                try {
                    e eVar = (e) g.this.uGF.get();
                    if (eVar == null) {
                        ab.i("FindBeaconBug", "callbacker is null");
                    } else if (z) {
                        ab.i("FindBeaconBug", "find Msghandler");
                        Bundle bundle = new Bundle();
                        bundle.putString("uuid", str);
                        bundle.putInt("major", i);
                        bundle.putInt("minor", i2);
                        bundle.putDouble("accuracy", d2);
                        bundle.putDouble("rssi", d);
                        bundle.putFloat("heading", g.this.qfA);
                        eVar.c(40002, bundle);
                    }
                } catch (RemoteException e) {
                    ab.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", e.getMessage());
                }
                ab.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", g.this.ecv.get(str2), Integer.valueOf(g.this.ecv.size()));
            }
            AppMethodBeat.o(9108);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c qwh = new com.tencent.mm.sdk.b.c<dz>() {
        {
            AppMethodBeat.i(9110);
            this.xxI = dz.class.getName().hashCode();
            AppMethodBeat.o(9110);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(9111);
            dz dzVar = (dz) bVar;
            if (dzVar != null && (dzVar instanceof dz)) {
                ab.d("MicroMsg.MsgHandler", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(dzVar.cxz.cxA));
                if (dzVar.cxz.cxA != 10 && dzVar.cxz.cxA == 12 && g.this.uGI) {
                    g.a(g.this, g.this.uGe, new int[]{1});
                }
            }
            AppMethodBeat.o(9111);
            return false;
        }
    };
    private Map<String, String> uGA = new ConcurrentHashMap();
    private Map<String, List<aua>> uGB = new ConcurrentHashMap();
    private List<atz> uGC = new CopyOnWriteArrayList();
    private boolean uGD = false;
    private long uGE = 0;
    private WeakReference<e> uGF;
    private String uGG = "-1000.0";
    private String uGH = "-1000.0";
    private boolean uGI = false;
    private SensorEventListener uGJ = new SensorEventListener() {
        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(9112);
            if (sensorEvent.sensor.getType() == 3) {
                g.this.qfA = sensorEvent.values[0];
            }
            AppMethodBeat.o(9112);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    private com.tencent.mm.modelgeo.b.b uGL = null;
    public i uGM;
    public com.tencent.mm.sdk.b.c uGN = new com.tencent.mm.sdk.b.c<sh>() {
        {
            AppMethodBeat.i(9140);
            this.xxI = sh.class.getName().hashCode();
            AppMethodBeat.o(9140);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(9141);
            sh shVar = (sh) bVar;
            if (shVar != null && (shVar instanceof sh)) {
                ab.d("MicroMsg.MsgHandler", "StartVoipCSResultEvent = %s", Integer.valueOf(shVar.cOB.status));
                g.a(g.this, shVar.cOB.status);
            }
            AppMethodBeat.o(9141);
            return false;
        }
    };
    public final Map<String, b> uGO = new HashMap();
    public String uGP;
    public com.tencent.mm.sdk.b.c uGQ = new com.tencent.mm.sdk.b.c<vs>() {
        {
            AppMethodBeat.i(9174);
            this.xxI = vs.class.getName().hashCode();
            AppMethodBeat.o(9174);
        }

        private boolean a(vs vsVar) {
            AppMethodBeat.i(9175);
            ab.d("TAG", "webViewWillCloseWindowEvent callback");
            if (g.this.umI != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("closeWindow. result: %d", vsVar.cSF.result);
                    g.this.umI.cZb();
                    g.this.umI.W(bundle);
                    ab.d("MicroMsg.MsgHandler", "closeWindow. result: %d", Integer.valueOf(vsVar.cSF.result));
                } catch (RemoteException e) {
                    ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                }
                if (vsVar.cSF.result == -1) {
                    g.a(g.this, g.this.uGd, "get_h5_transaction_request:ok", null);
                } else {
                    g.a(g.this, g.this.uGd, "get_h5_transaction_request:cancel", null);
                }
                com.tencent.mm.sdk.b.a.xxA.d(this);
                AppMethodBeat.o(9175);
                return true;
            }
            AppMethodBeat.o(9175);
            return false;
        }
    };
    public final List<String> uGR = new LinkedList();
    public final Map<Integer, c> uGV = new HashMap();
    private int uGW = 0;
    private int uGX = 1000;
    public com.tencent.mm.sdk.b.c uGY;
    public volatile i uGZ = null;
    public i uGd;
    public i uGe;
    public HashSet<String> uGf;
    public HashSet<String> uGg;
    public Bundle uGh;
    private String uGi = null;
    public HashMap<String, String> uGj = null;
    public HashMap<String, String> uGk = null;
    public String uGl = null;
    public boolean uGm = false;
    public String uGn = null;
    public boolean uGo = false;
    public e uGp;
    private e uGq;
    public c uGr = null;
    public boolean uGs = false;
    private final j uGt;
    private final com.tencent.mm.plugin.webview.modeltools.e uGu;
    public final com.tencent.mm.plugin.webview.modeltools.l uGv;
    public com.tencent.mm.plugin.webview.e.c uGw;
    private long uGx = 0;
    private int uGy;
    private int uGz = -1;
    public final com.tencent.mm.sdk.b.c uHa = new com.tencent.mm.sdk.b.c<ke>() {
        {
            AppMethodBeat.i(9087);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(9087);
        }

        private boolean a(ke keVar) {
            AppMethodBeat.i(9088);
            ab.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", keVar.cFH.state);
            int i = (int) (keVar.cFH.duration / 1000);
            if (keVar.cFH.cFJ) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("background_audio_state_player_state", r2);
                    bundle.putInt("background_audio_state_player_duration", i);
                    if (keVar.cFH.cFB != null) {
                        bundle.putString("background_audio_state_player_src", keVar.cFH.cFB.fKa);
                        bundle.putString("background_audio_state_player_src_id", keVar.cFH.cFB.fKs);
                    }
                    bundle.putInt("background_audio_state_player_err_code", keVar.cFH.errCode);
                    String str = "";
                    if (!TextUtils.isEmpty(keVar.cFH.aIm)) {
                        str = keVar.cFH.aIm;
                    }
                    bundle.putString("background_audio_state_player_err_msg", str);
                    if (g.this.umI != null) {
                        ab.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
                        g.this.umI.c(2100, bundle);
                    } else {
                        ab.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
                    }
                    AppMethodBeat.o(9088);
                    return true;
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", e.getMessage());
                    AppMethodBeat.o(9088);
                    return false;
                }
            }
            ab.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
            AppMethodBeat.o(9088);
            return false;
        }
    };
    public e umI;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$10 */
    class AnonymousClass10 implements com.tencent.mm.z.a.b.a<com.tencent.mm.z.a.b> {
        final /* synthetic */ int hmP;
        final /* synthetic */ a uHi;
        final /* synthetic */ i uqf;

        AnonymousClass10(i iVar, a aVar, int i) {
            this.uqf = iVar;
            this.uHi = aVar;
            this.hmP = i;
        }

        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(9053);
            com.tencent.mm.z.a.b bVar = (com.tencent.mm.z.a.b) mVar;
            ab.d("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                g.a(g.this, this.uqf, "authorize:fail", null);
                this.uHi.aCB();
                AppMethodBeat.o(9053);
            } else if (this.hmP == 2) {
                ab.d("MicroMsg.MsgHandler", "press reject button");
                this.uHi.aCB();
                AppMethodBeat.o(9053);
            } else {
                avv Qt = bVar.Qt();
                int i3 = Qt.wzH.cyE;
                String str2 = Qt.wzH.cyF;
                ab.i("MicroMsg.MsgHandler", "NetSceneJSAuthorizeConfirm jsErrcode %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    g.a(g.this, this.uqf, "authorize:ok", null);
                    this.uHi.aCB();
                    AppMethodBeat.o(9053);
                    return;
                }
                ab.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", str2);
                g.a(g.this, this.uqf, "authorize:fail", null);
                this.uHi.aCB();
                AppMethodBeat.o(9053);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$8 */
    class AnonymousClass8 implements com.tencent.mm.z.a.d.a<com.tencent.mm.z.a.d> {
        final /* synthetic */ int hmP;
        final /* synthetic */ a uHi;
        final /* synthetic */ i uqf;

        AnonymousClass8(i iVar, a aVar, int i) {
            this.uqf = iVar;
            this.uHi = aVar;
            this.hmP = i;
        }

        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(9049);
            com.tencent.mm.z.a.d dVar = (com.tencent.mm.z.a.d) mVar;
            ab.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                g.a(g.this, this.uqf, "login:fail", null);
                this.uHi.aCB();
                AppMethodBeat.o(9049);
            } else if (this.hmP == 2) {
                ab.d("MicroMsg.MsgHandler", "press reject button");
                this.uHi.aCB();
                AppMethodBeat.o(9049);
            } else {
                avz Qx = dVar.Qx();
                int i3 = Qx.wzH.cyE;
                String str2 = Qx.wzH.cyF;
                ab.i("MicroMsg.MsgHandler", "stev NetSceneJSLoginConfirm jsErrcode %d", Integer.valueOf(i3));
                if (i3 == 0) {
                    String str3 = Qx.wzO;
                    Map hashMap = new HashMap();
                    hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str3);
                    g.a(g.this, this.uqf, "login:ok", hashMap);
                    this.uHi.aCB();
                    ab.d("MicroMsg.MsgHandler", "resp data code [%s]", str3);
                    AppMethodBeat.o(9049);
                    return;
                }
                g.a(g.this, this.uqf, "login:fail", null);
                this.uHi.aCB();
                ab.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLoginConfirm %s", str2);
                AppMethodBeat.o(9049);
            }
        }
    }

    class c {
        public i uGd;
        public e umI;

        public c(i iVar, e eVar) {
            this.uGd = iVar;
            this.umI = eVar;
        }
    }

    static class d implements aj {
        volatile boolean cEn;
        volatile boolean ftW;
        volatile boolean hxt;
        volatile boolean hxu;
        a uID;

        interface a {
            void r(boolean z, boolean z2);
        }

        d(a aVar) {
            this.uID = aVar;
        }

        public final void dR(boolean z) {
            AppMethodBeat.i(9213);
            this.ftW = true;
            this.hxt = z;
            if (this.hxu && this.uID != null) {
                this.uID.r(this.cEn, z);
            }
            AppMethodBeat.o(9213);
        }

        /* Access modifiers changed, original: final */
        public final void dS(boolean z) {
            AppMethodBeat.i(9214);
            this.cEn = z;
            this.hxu = true;
            if (this.ftW && this.uID != null) {
                this.uID.r(z, this.hxt);
            }
            AppMethodBeat.o(9214);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.g$90 */
    public class AnonymousClass90 implements Runnable {
        final /* synthetic */ WebViewJSSDKFileItem uId;

        public AnonymousClass90(WebViewJSSDKFileItem webViewJSSDKFileItem) {
            this.uId = webViewJSSDKFileItem;
        }

        public final void run() {
            AppMethodBeat.i(9156);
            fn fnVar = new fn();
            fnVar.czm.op = 2;
            fnVar.czm.filePath = this.uId.heo;
            com.tencent.mm.sdk.b.a.xxA.m(fnVar);
            g.this.uGP = null;
            AppMethodBeat.o(9156);
        }
    }

    public interface a {
        void aCB();
    }

    public static final class b {
        public i uGd;
        public com.tencent.mm.plugin.webview.model.d.b uIC;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static /* synthetic */ boolean A(g gVar, i iVar) {
        AppMethodBeat.i(9514);
        boolean E = gVar.E(iVar);
        AppMethodBeat.o(9514);
        return E;
    }

    static /* synthetic */ boolean D(g gVar, i iVar) {
        AppMethodBeat.i(9517);
        boolean F = gVar.F(iVar);
        AppMethodBeat.o(9517);
        return F;
    }

    static /* synthetic */ boolean E(g gVar, i iVar) {
        AppMethodBeat.i(9518);
        boolean A = gVar.A(iVar);
        AppMethodBeat.o(9518);
        return A;
    }

    static /* synthetic */ boolean I(g gVar, i iVar) {
        AppMethodBeat.i(9522);
        boolean H = gVar.H(iVar);
        AppMethodBeat.o(9522);
        return H;
    }

    static /* synthetic */ boolean J(g gVar, i iVar) {
        AppMethodBeat.i(9523);
        boolean e = gVar.e(iVar);
        AppMethodBeat.o(9523);
        return e;
    }

    static /* synthetic */ boolean K(g gVar, i iVar) {
        AppMethodBeat.i(9524);
        boolean d = gVar.d(iVar);
        AppMethodBeat.o(9524);
        return d;
    }

    static /* synthetic */ boolean L(g gVar, i iVar) {
        AppMethodBeat.i(9525);
        boolean c = gVar.c(iVar);
        AppMethodBeat.o(9525);
        return c;
    }

    static /* synthetic */ boolean O(g gVar, i iVar) {
        AppMethodBeat.i(9528);
        boolean G = gVar.G(iVar);
        AppMethodBeat.o(9528);
        return G;
    }

    static /* synthetic */ boolean W(g gVar, i iVar) {
        AppMethodBeat.i(9536);
        boolean I = gVar.I(iVar);
        AppMethodBeat.o(9536);
        return I;
    }

    static /* synthetic */ boolean X(g gVar, i iVar) {
        AppMethodBeat.i(9537);
        boolean J = gVar.J(iVar);
        AppMethodBeat.o(9537);
        return J;
    }

    static /* synthetic */ boolean Y(g gVar, i iVar) {
        AppMethodBeat.i(9538);
        boolean ad = gVar.ad(iVar);
        AppMethodBeat.o(9538);
        return ad;
    }

    static /* synthetic */ boolean Z(g gVar, i iVar) {
        AppMethodBeat.i(9539);
        boolean ae = gVar.ae(iVar);
        AppMethodBeat.o(9539);
        return ae;
    }

    static /* synthetic */ boolean aA(g gVar, i iVar) {
        AppMethodBeat.i(9569);
        boolean L = gVar.L(iVar);
        AppMethodBeat.o(9569);
        return L;
    }

    static /* synthetic */ boolean aB(g gVar, i iVar) {
        AppMethodBeat.i(9570);
        boolean M = gVar.M(iVar);
        AppMethodBeat.o(9570);
        return M;
    }

    static /* synthetic */ boolean aC(g gVar, i iVar) {
        AppMethodBeat.i(9571);
        boolean N = gVar.N(iVar);
        AppMethodBeat.o(9571);
        return N;
    }

    static /* synthetic */ boolean aD(g gVar, i iVar) {
        AppMethodBeat.i(9572);
        boolean O = gVar.O(iVar);
        AppMethodBeat.o(9572);
        return O;
    }

    static /* synthetic */ boolean aE(g gVar, i iVar) {
        AppMethodBeat.i(9573);
        boolean P = gVar.P(iVar);
        AppMethodBeat.o(9573);
        return P;
    }

    static /* synthetic */ boolean aF(g gVar, i iVar) {
        AppMethodBeat.i(9574);
        boolean Q = gVar.Q(iVar);
        AppMethodBeat.o(9574);
        return Q;
    }

    static /* synthetic */ boolean aG(g gVar, i iVar) {
        AppMethodBeat.i(9575);
        boolean R = gVar.R(iVar);
        AppMethodBeat.o(9575);
        return R;
    }

    static /* synthetic */ boolean aH(g gVar, i iVar) {
        AppMethodBeat.i(9576);
        boolean S = gVar.S(iVar);
        AppMethodBeat.o(9576);
        return S;
    }

    static /* synthetic */ boolean aI(g gVar, i iVar) {
        AppMethodBeat.i(9577);
        boolean T = gVar.T(iVar);
        AppMethodBeat.o(9577);
        return T;
    }

    static /* synthetic */ boolean aJ(g gVar, i iVar) {
        AppMethodBeat.i(9578);
        boolean U = gVar.U(iVar);
        AppMethodBeat.o(9578);
        return U;
    }

    static /* synthetic */ boolean aN(g gVar, i iVar) {
        AppMethodBeat.i(9582);
        boolean ar = gVar.ar(iVar);
        AppMethodBeat.o(9582);
        return ar;
    }

    static /* synthetic */ boolean ad(g gVar, i iVar) {
        AppMethodBeat.i(9543);
        boolean af = gVar.af(iVar);
        AppMethodBeat.o(9543);
        return af;
    }

    static /* synthetic */ boolean ae(g gVar, i iVar) {
        AppMethodBeat.i(9544);
        boolean ag = gVar.ag(iVar);
        AppMethodBeat.o(9544);
        return ag;
    }

    static /* synthetic */ boolean af(g gVar, i iVar) {
        AppMethodBeat.i(9545);
        boolean W = gVar.W(iVar);
        AppMethodBeat.o(9545);
        return W;
    }

    static /* synthetic */ boolean ag(g gVar, i iVar) {
        AppMethodBeat.i(9546);
        boolean X = gVar.X(iVar);
        AppMethodBeat.o(9546);
        return X;
    }

    static /* synthetic */ boolean ah(g gVar, i iVar) {
        AppMethodBeat.i(9547);
        boolean Y = gVar.Y(iVar);
        AppMethodBeat.o(9547);
        return Y;
    }

    static /* synthetic */ boolean ai(g gVar, i iVar) {
        AppMethodBeat.i(9548);
        boolean ah = gVar.ah(iVar);
        AppMethodBeat.o(9548);
        return ah;
    }

    static /* synthetic */ boolean aj(g gVar, i iVar) {
        AppMethodBeat.i(9549);
        boolean ai = gVar.ai(iVar);
        AppMethodBeat.o(9549);
        return ai;
    }

    static /* synthetic */ boolean ak(g gVar, i iVar) {
        AppMethodBeat.i(9550);
        boolean aj = gVar.aj(iVar);
        AppMethodBeat.o(9550);
        return aj;
    }

    static /* synthetic */ boolean al(g gVar, i iVar) {
        AppMethodBeat.i(9551);
        boolean ak = gVar.ak(iVar);
        AppMethodBeat.o(9551);
        return ak;
    }

    static /* synthetic */ boolean am(g gVar, i iVar) {
        AppMethodBeat.i(9552);
        boolean al = gVar.al(iVar);
        AppMethodBeat.o(9552);
        return al;
    }

    static /* synthetic */ boolean an(g gVar, i iVar) {
        AppMethodBeat.i(9553);
        boolean an = gVar.an(iVar);
        AppMethodBeat.o(9553);
        return an;
    }

    static /* synthetic */ boolean ao(g gVar, i iVar) {
        AppMethodBeat.i(9554);
        boolean ap = gVar.ap(iVar);
        AppMethodBeat.o(9554);
        return ap;
    }

    static /* synthetic */ boolean ap(g gVar, i iVar) {
        AppMethodBeat.i(9555);
        boolean aq = gVar.aq(iVar);
        AppMethodBeat.o(9555);
        return aq;
    }

    static /* synthetic */ boolean ar(g gVar, i iVar) {
        AppMethodBeat.i(9557);
        boolean K = gVar.K(iVar);
        AppMethodBeat.o(9557);
        return K;
    }

    static /* synthetic */ boolean as(g gVar, i iVar) {
        AppMethodBeat.i(9558);
        boolean z = gVar.z(iVar);
        AppMethodBeat.o(9558);
        return z;
    }

    static /* synthetic */ boolean ax(g gVar, i iVar) {
        AppMethodBeat.i(9566);
        boolean am = gVar.am(iVar);
        AppMethodBeat.o(9566);
        return am;
    }

    static /* synthetic */ boolean ay(g gVar, i iVar) {
        AppMethodBeat.i(9567);
        boolean as = gVar.as(iVar);
        AppMethodBeat.o(9567);
        return as;
    }

    static /* synthetic */ boolean az(g gVar, i iVar) {
        AppMethodBeat.i(9568);
        boolean at = gVar.at(iVar);
        AppMethodBeat.o(9568);
        return at;
    }

    static /* synthetic */ boolean bA(g gVar, i iVar) {
        AppMethodBeat.i(9621);
        boolean bw = gVar.bw(iVar);
        AppMethodBeat.o(9621);
        return bw;
    }

    static /* synthetic */ boolean bB(g gVar, i iVar) {
        AppMethodBeat.i(9622);
        boolean bx = gVar.bx(iVar);
        AppMethodBeat.o(9622);
        return bx;
    }

    static /* synthetic */ boolean bI(g gVar, i iVar) {
        AppMethodBeat.i(9629);
        boolean aH = gVar.aH(iVar);
        AppMethodBeat.o(9629);
        return aH;
    }

    static /* synthetic */ boolean bJ(g gVar, i iVar) {
        AppMethodBeat.i(9630);
        boolean aK = gVar.aK(iVar);
        AppMethodBeat.o(9630);
        return aK;
    }

    static /* synthetic */ boolean bK(g gVar, i iVar) {
        AppMethodBeat.i(9631);
        boolean aL = gVar.aL(iVar);
        AppMethodBeat.o(9631);
        return aL;
    }

    static /* synthetic */ boolean bL(g gVar, i iVar) {
        AppMethodBeat.i(9632);
        boolean aM = gVar.aM(iVar);
        AppMethodBeat.o(9632);
        return aM;
    }

    static /* synthetic */ boolean bM(g gVar, i iVar) {
        AppMethodBeat.i(9633);
        boolean aI = gVar.aI(iVar);
        AppMethodBeat.o(9633);
        return aI;
    }

    static /* synthetic */ boolean bN(g gVar, i iVar) {
        AppMethodBeat.i(9634);
        boolean aJ = gVar.aJ(iVar);
        AppMethodBeat.o(9634);
        return aJ;
    }

    static /* synthetic */ boolean bO(g gVar, i iVar) {
        AppMethodBeat.i(9635);
        boolean aB = gVar.aB(iVar);
        AppMethodBeat.o(9635);
        return aB;
    }

    static /* synthetic */ boolean bQ(g gVar, i iVar) {
        AppMethodBeat.i(9637);
        boolean aC = gVar.aC(iVar);
        AppMethodBeat.o(9637);
        return aC;
    }

    static /* synthetic */ boolean bS(g gVar, i iVar) {
        AppMethodBeat.i(9639);
        boolean aN = gVar.aN(iVar);
        AppMethodBeat.o(9639);
        return aN;
    }

    static /* synthetic */ boolean bU(g gVar, i iVar) {
        AppMethodBeat.i(9641);
        boolean bv = gVar.bv(iVar);
        AppMethodBeat.o(9641);
        return bv;
    }

    static /* synthetic */ boolean bW(g gVar, i iVar) {
        AppMethodBeat.i(9643);
        boolean bs = gVar.bs(iVar);
        AppMethodBeat.o(9643);
        return bs;
    }

    static /* synthetic */ boolean bX(g gVar, i iVar) {
        AppMethodBeat.i(9644);
        boolean bt = gVar.bt(iVar);
        AppMethodBeat.o(9644);
        return bt;
    }

    static /* synthetic */ boolean bY(g gVar, i iVar) {
        AppMethodBeat.i(9645);
        boolean bu = gVar.bu(iVar);
        AppMethodBeat.o(9645);
        return bu;
    }

    static /* synthetic */ boolean bZ(g gVar, i iVar) {
        AppMethodBeat.i(9646);
        boolean bG = gVar.bG(iVar);
        AppMethodBeat.o(9646);
        return bG;
    }

    static /* synthetic */ boolean bb(g gVar, i iVar) {
        AppMethodBeat.i(9596);
        boolean av = gVar.av(iVar);
        AppMethodBeat.o(9596);
        return av;
    }

    static /* synthetic */ boolean bc(g gVar, i iVar) {
        AppMethodBeat.i(9597);
        boolean aw = gVar.aw(iVar);
        AppMethodBeat.o(9597);
        return aw;
    }

    static /* synthetic */ boolean bd(g gVar, i iVar) {
        AppMethodBeat.i(9598);
        boolean ax = gVar.ax(iVar);
        AppMethodBeat.o(9598);
        return ax;
    }

    static /* synthetic */ boolean be(g gVar, i iVar) {
        AppMethodBeat.i(9599);
        boolean ay = gVar.ay(iVar);
        AppMethodBeat.o(9599);
        return ay;
    }

    static /* synthetic */ boolean bf(g gVar, i iVar) {
        AppMethodBeat.i(9600);
        boolean az = gVar.az(iVar);
        AppMethodBeat.o(9600);
        return az;
    }

    static /* synthetic */ boolean bg(g gVar, i iVar) {
        AppMethodBeat.i(9601);
        boolean bd = gVar.bd(iVar);
        AppMethodBeat.o(9601);
        return bd;
    }

    static /* synthetic */ boolean bj(g gVar, i iVar) {
        AppMethodBeat.i(9604);
        boolean be = gVar.be(iVar);
        AppMethodBeat.o(9604);
        return be;
    }

    static /* synthetic */ boolean bk(g gVar, i iVar) {
        AppMethodBeat.i(9605);
        boolean bl = gVar.bl(iVar);
        AppMethodBeat.o(9605);
        return bl;
    }

    static /* synthetic */ boolean bl(g gVar, i iVar) {
        AppMethodBeat.i(9606);
        boolean bq = gVar.bq(iVar);
        AppMethodBeat.o(9606);
        return bq;
    }

    static /* synthetic */ boolean bm(g gVar, i iVar) {
        AppMethodBeat.i(9607);
        boolean br = gVar.br(iVar);
        AppMethodBeat.o(9607);
        return br;
    }

    static /* synthetic */ boolean bs(g gVar, i iVar) {
        AppMethodBeat.i(9613);
        boolean bf = gVar.bf(iVar);
        AppMethodBeat.o(9613);
        return bf;
    }

    static /* synthetic */ boolean cA(g gVar, i iVar) {
        AppMethodBeat.i(9676);
        boolean bS = gVar.bS(iVar);
        AppMethodBeat.o(9676);
        return bS;
    }

    static /* synthetic */ boolean cB(g gVar, i iVar) {
        AppMethodBeat.i(9677);
        boolean aV = gVar.aV(iVar);
        AppMethodBeat.o(9677);
        return aV;
    }

    static /* synthetic */ boolean cF(g gVar, i iVar) {
        AppMethodBeat.i(9681);
        boolean bU = gVar.bU(iVar);
        AppMethodBeat.o(9681);
        return bU;
    }

    static /* synthetic */ boolean cG(g gVar, i iVar) {
        AppMethodBeat.i(9682);
        boolean bW = gVar.bW(iVar);
        AppMethodBeat.o(9682);
        return bW;
    }

    static /* synthetic */ boolean cH(g gVar, i iVar) {
        AppMethodBeat.i(9683);
        boolean ab = gVar.ab(iVar);
        AppMethodBeat.o(9683);
        return ab;
    }

    static /* synthetic */ boolean cI(g gVar, i iVar) {
        AppMethodBeat.i(9684);
        boolean bX = gVar.bX(iVar);
        AppMethodBeat.o(9684);
        return bX;
    }

    static /* synthetic */ boolean cK(g gVar, i iVar) {
        AppMethodBeat.i(9686);
        boolean bY = gVar.bY(iVar);
        AppMethodBeat.o(9686);
        return bY;
    }

    static /* synthetic */ boolean cL(g gVar, i iVar) {
        AppMethodBeat.i(9687);
        boolean bZ = gVar.bZ(iVar);
        AppMethodBeat.o(9687);
        return bZ;
    }

    static /* synthetic */ boolean cM(g gVar, i iVar) {
        AppMethodBeat.i(9688);
        boolean b = gVar.b(iVar);
        AppMethodBeat.o(9688);
        return b;
    }

    static /* synthetic */ boolean cP(g gVar, i iVar) {
        AppMethodBeat.i(9691);
        boolean bT = gVar.bT(iVar);
        AppMethodBeat.o(9691);
        return bT;
    }

    static /* synthetic */ boolean cS(g gVar, i iVar) {
        AppMethodBeat.i(9694);
        boolean Z = gVar.Z(iVar);
        AppMethodBeat.o(9694);
        return Z;
    }

    static /* synthetic */ boolean cT(g gVar, i iVar) {
        AppMethodBeat.i(9695);
        boolean aQ = gVar.aQ(iVar);
        AppMethodBeat.o(9695);
        return aQ;
    }

    static /* synthetic */ boolean cU(g gVar, i iVar) {
        AppMethodBeat.i(9696);
        boolean aa = gVar.aa(iVar);
        AppMethodBeat.o(9696);
        return aa;
    }

    static /* synthetic */ boolean cV(g gVar, i iVar) {
        AppMethodBeat.i(9697);
        boolean bV = gVar.bV(iVar);
        AppMethodBeat.o(9697);
        return bV;
    }

    static /* synthetic */ boolean cW(g gVar, i iVar) {
        AppMethodBeat.i(9699);
        boolean p = gVar.p(iVar);
        AppMethodBeat.o(9699);
        return p;
    }

    static /* synthetic */ boolean cZ(g gVar, i iVar) {
        AppMethodBeat.i(9702);
        boolean ba = gVar.ba(iVar);
        AppMethodBeat.o(9702);
        return ba;
    }

    static /* synthetic */ boolean ca(g gVar, i iVar) {
        AppMethodBeat.i(9647);
        boolean bF = gVar.bF(iVar);
        AppMethodBeat.o(9647);
        return bF;
    }

    static /* synthetic */ boolean cc(g gVar, i iVar) {
        AppMethodBeat.i(9649);
        boolean bD = gVar.bD(iVar);
        AppMethodBeat.o(9649);
        return bD;
    }

    static /* synthetic */ boolean cd(g gVar, i iVar) {
        AppMethodBeat.i(9650);
        boolean bE = gVar.bE(iVar);
        AppMethodBeat.o(9650);
        return bE;
    }

    static /* synthetic */ boolean ce(g gVar, i iVar) {
        AppMethodBeat.i(9651);
        boolean bC = gVar.bC(iVar);
        AppMethodBeat.o(9651);
        return bC;
    }

    static /* synthetic */ boolean cf(g gVar, i iVar) {
        AppMethodBeat.i(9652);
        boolean bA = gVar.bA(iVar);
        AppMethodBeat.o(9652);
        return bA;
    }

    static /* synthetic */ boolean cg(g gVar, i iVar) {
        AppMethodBeat.i(9653);
        boolean bB = gVar.bB(iVar);
        AppMethodBeat.o(9653);
        return bB;
    }

    static /* synthetic */ boolean ch(g gVar, i iVar) {
        AppMethodBeat.i(9654);
        boolean aO = gVar.aO(iVar);
        AppMethodBeat.o(9654);
        return aO;
    }

    static /* synthetic */ boolean ck(g gVar, i iVar) {
        AppMethodBeat.i(9657);
        boolean aP = gVar.aP(iVar);
        AppMethodBeat.o(9657);
        return aP;
    }

    static /* synthetic */ boolean cl(g gVar, i iVar) {
        AppMethodBeat.i(9658);
        boolean aA = gVar.aA(iVar);
        AppMethodBeat.o(9658);
        return aA;
    }

    static /* synthetic */ boolean cm(g gVar, i iVar) {
        AppMethodBeat.i(9659);
        boolean aE = gVar.aE(iVar);
        AppMethodBeat.o(9659);
        return aE;
    }

    static /* synthetic */ boolean cn(g gVar, i iVar) {
        AppMethodBeat.i(9660);
        boolean aF = gVar.aF(iVar);
        AppMethodBeat.o(9660);
        return aF;
    }

    static /* synthetic */ boolean co(g gVar, i iVar) {
        AppMethodBeat.i(9661);
        boolean aG = gVar.aG(iVar);
        AppMethodBeat.o(9661);
        return aG;
    }

    static /* synthetic */ boolean cq(g gVar, i iVar) {
        AppMethodBeat.i(9663);
        boolean aT = gVar.aT(iVar);
        AppMethodBeat.o(9663);
        return aT;
    }

    static /* synthetic */ boolean cs(g gVar, i iVar) {
        AppMethodBeat.i(9666);
        boolean ac = gVar.ac(iVar);
        AppMethodBeat.o(9666);
        return ac;
    }

    static /* synthetic */ boolean ct(g gVar, i iVar) {
        AppMethodBeat.i(9667);
        boolean aS = gVar.aS(iVar);
        AppMethodBeat.o(9667);
        return aS;
    }

    static /* synthetic */ boolean cz(g gVar, i iVar) {
        AppMethodBeat.i(9675);
        boolean bR = gVar.bR(iVar);
        AppMethodBeat.o(9675);
        return bR;
    }

    static /* synthetic */ boolean dC(g gVar, i iVar) {
        AppMethodBeat.i(9734);
        boolean bi = gVar.bi(iVar);
        AppMethodBeat.o(9734);
        return bi;
    }

    static /* synthetic */ boolean dD(g gVar, i iVar) {
        AppMethodBeat.i(9735);
        boolean cg = gVar.cg(iVar);
        AppMethodBeat.o(9735);
        return cg;
    }

    static /* synthetic */ boolean dE(g gVar, i iVar) {
        AppMethodBeat.i(9736);
        boolean cd = gVar.cd(iVar);
        AppMethodBeat.o(9736);
        return cd;
    }

    static /* synthetic */ boolean dF(g gVar, i iVar) {
        AppMethodBeat.i(9737);
        boolean ce = gVar.ce(iVar);
        AppMethodBeat.o(9737);
        return ce;
    }

    static /* synthetic */ boolean dG(g gVar, i iVar) {
        AppMethodBeat.i(9738);
        boolean by = gVar.by(iVar);
        AppMethodBeat.o(9738);
        return by;
    }

    static /* synthetic */ boolean dH(g gVar, i iVar) {
        AppMethodBeat.i(9739);
        boolean ch = gVar.ch(iVar);
        AppMethodBeat.o(9739);
        return ch;
    }

    static /* synthetic */ boolean dI(g gVar, i iVar) {
        AppMethodBeat.i(9740);
        boolean ci = gVar.ci(iVar);
        AppMethodBeat.o(9740);
        return ci;
    }

    static /* synthetic */ boolean dJ(g gVar, i iVar) {
        AppMethodBeat.i(9741);
        boolean cj = gVar.cj(iVar);
        AppMethodBeat.o(9741);
        return cj;
    }

    static /* synthetic */ boolean dL(g gVar, i iVar) {
        AppMethodBeat.i(9743);
        boolean q = gVar.q(iVar);
        AppMethodBeat.o(9743);
        return q;
    }

    static /* synthetic */ boolean dM(g gVar, i iVar) {
        AppMethodBeat.i(9744);
        boolean bm = gVar.bm(iVar);
        AppMethodBeat.o(9744);
        return bm;
    }

    static /* synthetic */ boolean dO(g gVar, i iVar) {
        AppMethodBeat.i(9746);
        boolean bo = gVar.bo(iVar);
        AppMethodBeat.o(9746);
        return bo;
    }

    static /* synthetic */ boolean dP(g gVar, i iVar) {
        AppMethodBeat.i(9747);
        boolean bp = gVar.bp(iVar);
        AppMethodBeat.o(9747);
        return bp;
    }

    static /* synthetic */ boolean dR(g gVar, i iVar) {
        AppMethodBeat.i(9750);
        boolean bg = gVar.bg(iVar);
        AppMethodBeat.o(9750);
        return bg;
    }

    static /* synthetic */ boolean dS(g gVar, i iVar) {
        AppMethodBeat.i(9751);
        boolean ck = gVar.ck(iVar);
        AppMethodBeat.o(9751);
        return ck;
    }

    static /* synthetic */ boolean dV(g gVar, i iVar) {
        AppMethodBeat.i(9755);
        boolean cl = gVar.cl(iVar);
        AppMethodBeat.o(9755);
        return cl;
    }

    static /* synthetic */ boolean dW(g gVar, i iVar) {
        AppMethodBeat.i(9756);
        boolean cm = gVar.cm(iVar);
        AppMethodBeat.o(9756);
        return cm;
    }

    static /* synthetic */ boolean dX(g gVar, i iVar) {
        AppMethodBeat.i(9757);
        boolean cn = gVar.cn(iVar);
        AppMethodBeat.o(9757);
        return cn;
    }

    static /* synthetic */ boolean dY(g gVar, i iVar) {
        AppMethodBeat.i(9758);
        boolean co = gVar.co(iVar);
        AppMethodBeat.o(9758);
        return co;
    }

    static /* synthetic */ boolean dZ(g gVar, i iVar) {
        AppMethodBeat.i(9759);
        boolean bh = gVar.bh(iVar);
        AppMethodBeat.o(9759);
        return bh;
    }

    static /* synthetic */ boolean dc(g gVar, i iVar) {
        AppMethodBeat.i(9705);
        boolean cb = gVar.cb(iVar);
        AppMethodBeat.o(9705);
        return cb;
    }

    static /* synthetic */ boolean dd(g gVar, i iVar) {
        AppMethodBeat.i(9707);
        boolean ca = gVar.ca(iVar);
        AppMethodBeat.o(9707);
        return ca;
    }

    static /* synthetic */ boolean de(g gVar, i iVar) {
        AppMethodBeat.i(9709);
        boolean aR = gVar.aR(iVar);
        AppMethodBeat.o(9709);
        return aR;
    }

    static /* synthetic */ boolean dj(g gVar, i iVar) {
        AppMethodBeat.i(9715);
        boolean u = gVar.u(iVar);
        AppMethodBeat.o(9715);
        return u;
    }

    static /* synthetic */ boolean do(g gVar, i iVar) {
        AppMethodBeat.i(9720);
        boolean j = gVar.j(iVar);
        AppMethodBeat.o(9720);
        return j;
    }

    static /* synthetic */ boolean dp(g gVar, i iVar) {
        AppMethodBeat.i(9721);
        boolean i = gVar.i(iVar);
        AppMethodBeat.o(9721);
        return i;
    }

    static /* synthetic */ boolean dq(g gVar, i iVar) {
        AppMethodBeat.i(9722);
        boolean k = gVar.k(iVar);
        AppMethodBeat.o(9722);
        return k;
    }

    static /* synthetic */ boolean dr(g gVar, i iVar) {
        AppMethodBeat.i(9723);
        boolean l = gVar.l(iVar);
        AppMethodBeat.o(9723);
        return l;
    }

    static /* synthetic */ boolean ds(g gVar, i iVar) {
        AppMethodBeat.i(9724);
        boolean m = gVar.m(iVar);
        AppMethodBeat.o(9724);
        return m;
    }

    static /* synthetic */ boolean dv(g gVar, i iVar) {
        AppMethodBeat.i(9727);
        boolean h = gVar.h(iVar);
        AppMethodBeat.o(9727);
        return h;
    }

    static /* synthetic */ boolean dw(g gVar, i iVar) {
        AppMethodBeat.i(9728);
        boolean bk = gVar.bk(iVar);
        AppMethodBeat.o(9728);
        return bk;
    }

    static /* synthetic */ boolean dx(g gVar, i iVar) {
        AppMethodBeat.i(9729);
        boolean cf = gVar.cf(iVar);
        AppMethodBeat.o(9729);
        return cf;
    }

    static /* synthetic */ boolean dy(g gVar, i iVar) {
        AppMethodBeat.i(9730);
        boolean bj = gVar.bj(iVar);
        AppMethodBeat.o(9730);
        return bj;
    }

    static /* synthetic */ boolean e(g gVar, i iVar) {
        AppMethodBeat.i(9487);
        boolean o = gVar.o(iVar);
        AppMethodBeat.o(9487);
        return o;
    }

    static /* synthetic */ boolean ea(g gVar, i iVar) {
        AppMethodBeat.i(9760);
        boolean cq = gVar.cq(iVar);
        AppMethodBeat.o(9760);
        return cq;
    }

    static /* synthetic */ boolean eb(g gVar, i iVar) {
        AppMethodBeat.i(9761);
        boolean cp = gVar.cp(iVar);
        AppMethodBeat.o(9761);
        return cp;
    }

    static /* synthetic */ boolean ee(g gVar, i iVar) {
        AppMethodBeat.i(9764);
        boolean cu = gVar.cu(iVar);
        AppMethodBeat.o(9764);
        return cu;
    }

    static /* synthetic */ boolean ef(g gVar, i iVar) {
        AppMethodBeat.i(9765);
        boolean cv = gVar.cv(iVar);
        AppMethodBeat.o(9765);
        return cv;
    }

    static /* synthetic */ boolean eg(g gVar, i iVar) {
        AppMethodBeat.i(9766);
        boolean cx = gVar.cx(iVar);
        AppMethodBeat.o(9766);
        return cx;
    }

    static /* synthetic */ boolean eh(g gVar, i iVar) {
        AppMethodBeat.i(9767);
        boolean ct = gVar.ct(iVar);
        AppMethodBeat.o(9767);
        return ct;
    }

    static /* synthetic */ boolean ei(g gVar, i iVar) {
        AppMethodBeat.i(9768);
        boolean cz = gVar.cz(iVar);
        AppMethodBeat.o(9768);
        return cz;
    }

    static /* synthetic */ boolean ej(g gVar, i iVar) {
        AppMethodBeat.i(9769);
        boolean cy = gVar.cy(iVar);
        AppMethodBeat.o(9769);
        return cy;
    }

    static /* synthetic */ boolean ek(g gVar, i iVar) {
        AppMethodBeat.i(9770);
        boolean cA = gVar.cA(iVar);
        AppMethodBeat.o(9770);
        return cA;
    }

    static /* synthetic */ boolean el(g gVar, i iVar) {
        AppMethodBeat.i(9771);
        boolean cr = gVar.cr(iVar);
        AppMethodBeat.o(9771);
        return cr;
    }

    static /* synthetic */ boolean em(g gVar, i iVar) {
        AppMethodBeat.i(9772);
        boolean cs = gVar.cs(iVar);
        AppMethodBeat.o(9772);
        return cs;
    }

    static /* synthetic */ boolean ep(g gVar, i iVar) {
        AppMethodBeat.i(9775);
        boolean cw = gVar.cw(iVar);
        AppMethodBeat.o(9775);
        return cw;
    }

    static /* synthetic */ boolean eq(g gVar, i iVar) {
        AppMethodBeat.i(9776);
        boolean cB = gVar.cB(iVar);
        AppMethodBeat.o(9776);
        return cB;
    }

    static /* synthetic */ boolean er(g gVar, i iVar) {
        AppMethodBeat.i(9781);
        boolean r = gVar.r(iVar);
        AppMethodBeat.o(9781);
        return r;
    }

    static /* synthetic */ boolean es(g gVar, i iVar) {
        AppMethodBeat.i(9783);
        boolean C = gVar.C(iVar);
        AppMethodBeat.o(9783);
        return C;
    }

    static /* synthetic */ boolean et(g gVar, i iVar) {
        AppMethodBeat.i(9785);
        boolean D = gVar.D(iVar);
        AppMethodBeat.o(9785);
        return D;
    }

    static /* synthetic */ void ew(g gVar, i iVar) {
        AppMethodBeat.i(9800);
        gVar.bb(iVar);
        AppMethodBeat.o(9800);
    }

    static /* synthetic */ boolean h(g gVar, i iVar) {
        AppMethodBeat.i(9491);
        boolean s = gVar.s(iVar);
        AppMethodBeat.o(9491);
        return s;
    }

    static /* synthetic */ boolean k(g gVar, i iVar) {
        AppMethodBeat.i(9496);
        boolean t = gVar.t(iVar);
        AppMethodBeat.o(9496);
        return t;
    }

    static /* synthetic */ boolean l(g gVar, i iVar) {
        AppMethodBeat.i(9497);
        boolean v = gVar.v(iVar);
        AppMethodBeat.o(9497);
        return v;
    }

    static /* synthetic */ boolean m(g gVar, i iVar) {
        AppMethodBeat.i(9498);
        boolean w = gVar.w(iVar);
        AppMethodBeat.o(9498);
        return w;
    }

    static /* synthetic */ boolean n(g gVar, i iVar) {
        AppMethodBeat.i(9499);
        boolean x = gVar.x(iVar);
        AppMethodBeat.o(9499);
        return x;
    }

    static /* synthetic */ boolean q(g gVar, i iVar) {
        AppMethodBeat.i(9502);
        boolean y = gVar.y(iVar);
        AppMethodBeat.o(9502);
        return y;
    }

    static /* synthetic */ boolean t(g gVar, i iVar) {
        AppMethodBeat.i(9506);
        boolean B = gVar.B(iVar);
        AppMethodBeat.o(9506);
        return B;
    }

    g(int i) {
        AppMethodBeat.i(9215);
        this.cIv = i;
        this.eBB = false;
        this.uGf = new HashSet();
        this.uGg = new HashSet();
        this.uGr = new c(this.cIv);
        this.uGt = new j();
        this.uGu = new com.tencent.mm.plugin.webview.modeltools.e();
        this.uGv = new com.tencent.mm.plugin.webview.modeltools.l();
        this.uGw = new com.tencent.mm.plugin.webview.e.c();
        AppMethodBeat.o(9215);
    }

    public final void oc(boolean z) {
        AppMethodBeat.i(9216);
        this.uGo = z;
        ab.i("MicroMsg.MsgHandler", "markAwaitingProxyUI %d, %b", Integer.valueOf(this.cIv), Boolean.valueOf(z));
        AppMethodBeat.o(9216);
    }

    public final void dcu() {
        AppMethodBeat.i(9217);
        ab.i("MicroMsg.MsgHandler", "setIsBusy: true");
        this.eBB = true;
        AppMethodBeat.o(9217);
    }

    public final void a(Context context, e eVar) {
        AppMethodBeat.i(9218);
        String str = "MicroMsg.MsgHandler";
        String str2 = "set context and callbacker, callbacker %s";
        Object[] objArr = new Object[1];
        objArr[0] = eVar == null ? BuildConfig.COMMAND : eVar.toString();
        ab.i(str, str2, objArr);
        this.context = context;
        if (this.uGr != null) {
            this.uGr.a(context, eVar);
        }
        this.umI = eVar;
        AppMethodBeat.o(9218);
    }

    public final void a(Context context, e eVar, e eVar2) {
        AppMethodBeat.i(9219);
        ab.i("MicroMsg.MsgHandler", "set context, callbacker and service callbacker");
        this.context = context;
        if (this.uGr != null) {
            this.uGr.a(context, eVar);
        }
        this.umI = eVar;
        this.uGq = eVar2;
        AppMethodBeat.o(9219);
    }

    public final Bundle dcv() {
        AppMethodBeat.i(9220);
        if (this.uGh == null) {
            this.uGh = new Bundle();
        }
        Bundle bundle = this.uGh;
        AppMethodBeat.o(9220);
        return bundle;
    }

    public final String bK(String str) {
        AppMethodBeat.i(9221);
        if (this.uGr == null) {
            ab.i("MicroMsg.MsgHandler", "getCachedAppId, jsVerifyHelper is null, return null");
            AppMethodBeat.o(9221);
            return null;
        }
        String agj = this.uGr.agj(str);
        AppMethodBeat.o(9221);
        return agj;
    }

    public static boolean Ke(String str) {
        AppMethodBeat.i(9222);
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(str);
            if (qX != null) {
                com.tencent.mm.aj.d.b cJ = qX.cJ(false);
                if (!(cJ == null || cJ.aej() == null || !cJ.aej().aes())) {
                    AppMethodBeat.o(9222);
                    return true;
                }
            }
        }
        AppMethodBeat.o(9222);
        return false;
    }

    private void agv(String str) {
        AppMethodBeat.i(9223);
        if (this.uGh == null) {
            this.uGh = new Bundle();
        }
        int i = bo.getInt(str, 33);
        if (this.uGh.getBoolean("KFromBizSearch")) {
            Bundle bundle = this.uGh.getBundle("KBizSearchExtArgs");
            if (bundle != null) {
                i = bundle.getInt("Contact_Scene");
            }
        }
        this.uGh.putInt("Contact_Scene", i);
        AppMethodBeat.o(9223);
    }

    private boolean agw(String str) {
        AppMethodBeat.i(9224);
        ab.i("MicroMsg.MsgHandler", "getFromMenu, functionName = ".concat(String.valueOf(str)));
        if (this.uGf.contains(str)) {
            this.uGf.remove(str);
            AppMethodBeat.o(9224);
            return true;
        }
        AppMethodBeat.o(9224);
        return false;
    }

    public final boolean agx(String str) {
        AppMethodBeat.i(9225);
        ab.i("MicroMsg.MsgHandler", "removeInvokedJsApiFromMenu, functionName = %s, succ = %s.", str, Boolean.valueOf(this.uGg.remove(str)));
        AppMethodBeat.o(9225);
        return this.uGg.remove(str);
    }

    public final boolean a(final i iVar, final JsapiPermissionWrapper jsapiPermissionWrapper) {
        boolean z = false;
        AppMethodBeat.i(9226);
        if (this.eBB) {
            ab.w("MicroMsg.MsgHandler", "handleMsg, MsgHandler is busy, old msg will be overrided");
        }
        if (this.uGh != null) {
            this.uGh.setClassLoader(getClass().getClassLoader());
        }
        this.uGd = iVar;
        this.eBB = true;
        l.a(this.umI);
        if (iVar.type.equals("call")) {
            this.uGn = iVar.uIJ;
            int afq = com.tencent.mm.plugin.webview.ui.tools.b.afq(iVar.uIJ);
            if (-1 != afq) {
                h.pYm.a(157, (long) afq, 1, z);
            }
            final com.tencent.mm.protocal.c.g akD = com.tencent.mm.protocal.c.akD(bo.nullAsNil(this.uGn));
            if (akD == null) {
                Bundle dj;
                try {
                    dj = this.umI.dj(this.uGn, iVar.uIH.toString());
                } catch (RemoteException e) {
                    ab.printErrStackTrace("MicroMsg.MsgHandler", e, "proxy handleMsg:%s", this.uGn);
                    dj = null;
                }
                if (dj == null || !dj.getBoolean("handle")) {
                    ab.e("MicroMsg.MsgHandler", "unknown function = %s", this.uGn);
                    a(iVar, "system:function_not_exist", null, true);
                    AppMethodBeat.o(9226);
                    return true;
                }
                a(iVar, dj.getString("handle_result", ""), null, true);
                ab.i("MicroMsg.MsgHandler", "proxy function = %s", this.uGn);
                AppMethodBeat.o(9226);
                return true;
            } else if (akD.getName() == "recordHistory") {
                ab.e("MicroMsg.MsgHandler", "handleMsg access denied func: %s", akD.getName());
                a(iVar, "system:access_denied", null, true);
                AppMethodBeat.o(9226);
                return true;
            } else {
                if (this.uGg.contains(akD.getName()) || jsapiPermissionWrapper.Lx(akD.dmb()) != 0) {
                    try {
                        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c() {
                            public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a aVar, String str, LinkedList<cmu> linkedList, int i, int i2) {
                                boolean z;
                                AppMethodBeat.i(9037);
                                iVar.dcO().put("baseErrorCode", Integer.valueOf(i));
                                iVar.dcO().put("jsapiErrorCode", Integer.valueOf(i2));
                                if (g.this.agx(iVar.uIJ)) {
                                    ab.i("MicroMsg.MsgHandler", "current jsapi(%s) invoked is came from menu event.(original retCode : %s)", iVar.uIJ, aVar);
                                    aVar = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;
                                }
                                ab.i("MicroMsg.MsgHandler", "onJSVerifyEnd, put webviewID = %d", Integer.valueOf(g.this.cIv));
                                iVar.puc.put("webview_instance_id", Integer.valueOf(g.this.cIv));
                                if (aVar != com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK) {
                                    if (aVar == com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED) {
                                        ab.e("MicroMsg.MsgHandler", "handleMsg access denied %s", akD.getName());
                                        if (iVar.uIJ.equalsIgnoreCase("getBrandWCPayRequest")) {
                                            h.pYm.a(157, 1, 1, false);
                                        }
                                        g.a(g.this, iVar, "system:access_denied", null);
                                    } else if (aVar == com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_REJECT) {
                                        g.a(g.this, iVar, akD.dma() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str, null);
                                    } else if (bo.isNullOrNil(akD.dma())) {
                                        g.this.eBB = false;
                                        nY(false);
                                        g.d(g.this, iVar, false);
                                        AppMethodBeat.o(9037);
                                        return;
                                    } else if (bo.isNullOrNil(str)) {
                                        g.a(g.this, iVar, akD.dma() + ":fail", null);
                                    } else {
                                        g.a(g.this, iVar, akD.dma() + ":fail_" + str, null);
                                    }
                                    nY(true);
                                    z = false;
                                } else if (iVar.uIJ.equals("sendAppMessage")) {
                                    nY(g.a(g.this, iVar, jsapiPermissionWrapper));
                                    z = true;
                                } else if (iVar.uIJ.equals(Scopes.PROFILE)) {
                                    nY(g.a(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("shareWeibo")) {
                                    nY(g.b(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.share.f.NAME)) {
                                    nY(g.b(g.this, iVar, jsapiPermissionWrapper));
                                    z = true;
                                } else if (iVar.uIJ.equals("updateTimelineShareData")) {
                                    nY(g.c(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("updateAppMessageShareData")) {
                                    nY(g.d(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(z.NAME)) {
                                    nY(g.e(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("streamingVideoPlay")) {
                                    nY(g.f(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("addContact")) {
                                    nY(g.c(g.this, iVar, jsapiPermissionWrapper));
                                    z = true;
                                } else if (iVar.uIJ.equals("getWidgetCaptureImgUrl")) {
                                    nY(g.g(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("imagePreview")) {
                                    nY(g.h(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("log")) {
                                    nY(g.i(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("hideOptionMenu")) {
                                    nY(g.b(g.this));
                                    z = true;
                                } else if (iVar.uIJ.equals("showOptionMenu")) {
                                    nY(g.c(g.this));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.q.d.NAME)) {
                                    nY(g.j(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("closeWindow")) {
                                    nY(g.k(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(JsApiGetInstallState.NAME)) {
                                    nY(g.l(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("scanQRCode")) {
                                    nY(g.m(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("setFontSizeCallback")) {
                                    nY(g.n(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("jumpToInstallUrl")) {
                                    nY(g.o(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getBrandWCPayRequest")) {
                                    nY(g.p(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(com.tencent.mm.plugin.appbrand.jsapi.i.m.NAME)) {
                                    nY(g.q(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("editAddress")) {
                                    nY(g.r(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getLatestAddress")) {
                                    nY(g.d(g.this));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getHeadingAndPitch")) {
                                    nY(g.s(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("sendEmail")) {
                                    nY(g.t(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiAddDownloadTask.NAME)) {
                                    nY(g.u(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiCancelDownloadTask.NAME)) {
                                    nY(g.v(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiPauseDownloadTask.NAME)) {
                                    nY(g.w(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiResumeDownloadTask.NAME)) {
                                    nY(g.d(g.this, iVar, jsapiPermissionWrapper));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiQueryDownloadTask.NAME)) {
                                    nY(g.x(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiInstallDownloadTask.NAME)) {
                                    nY(g.y(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openSpecificView")) {
                                    nY(g.z(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("launch3rdApp")) {
                                    nY(g.A(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("jumpWCMall")) {
                                    nY(g.B(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiWriteCommData.NAME)) {
                                    nY(g.C(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openUrlByExtBrowser")) {
                                    nY(g.D(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openProductView")) {
                                    nY(g.E(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openProductViewWithPid")) {
                                    nY(g.F(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getBrandWCPayBindCardRequest")) {
                                    nY(g.G(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("geoLocation")) {
                                    nY(g.H(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("jumpToBizProfile")) {
                                    nY(g.I(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openTimelineCheckInList")) {
                                    nY(g.J(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(j.NAME)) {
                                    nY(g.K(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("timelineCheckIn")) {
                                    nY(g.L(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getBrandWCPayCreateCreditCardRequest")) {
                                    nY(g.M(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("sendServiceAppMessage")) {
                                    nY(g.N(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("mmsf0001")) {
                                    nY(g.O(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("musicPlay")) {
                                    nY(g.P(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("connectToWiFi")) {
                                    nY(g.Q(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getTransferMoneyRequest")) {
                                    nY(g.R(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openWCPaySpecificView")) {
                                    nY(g.S(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("chooseCard")) {
                                    nY(g.T(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(ae.NAME)) {
                                    nY(g.U(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("batchAddCard")) {
                                    nY(g.V(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setCloseWindowConfirmDialogInfo")) {
                                    nY(g.W(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("preVerifyJSAPI")) {
                                    nY(g.X(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiStartRecordVoice.NAME)) {
                                    nY(g.Y(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiStopRecordVoice.NAME)) {
                                    nY(g.Z(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiStartPlayVoice.NAME)) {
                                    nY(g.aa(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiPausePlayVoice.NAME)) {
                                    nY(g.ab(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiStopPlayVoice.NAME)) {
                                    nY(g.ac(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("uploadVoice")) {
                                    nY(g.ad(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("downloadVoice")) {
                                    nY(g.ae(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiChooseImage.NAME)) {
                                    nY(g.af(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("uploadImage")) {
                                    nY(g.ag(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("downloadImage")) {
                                    nY(g.ah(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("hideMenuItems")) {
                                    nY(g.ai(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("showMenuItems")) {
                                    nY(g.aj(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("hideAllNonBaseMenuItem")) {
                                    nY(g.ak(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("showAllNonBaseMenuItem")) {
                                    nY(g.al(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("checkJsApi")) {
                                    nY(g.am(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("translateVoice")) {
                                    nY(g.an(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("shareQQ")) {
                                    nY(g.ao(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("shareWeiboApp")) {
                                    nY(g.ap(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("configWXDeviceWiFi")) {
                                    nY(g.aq(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getCurrentSSID")) {
                                    nY(g.ar(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getPaymentOrderRequest")) {
                                    nY(g.as(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("verifyWCPayPassword")) {
                                    nY(g.at(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("startMonitoringBeacons")) {
                                    g.e(g.this);
                                    nY(g.a(g.this, iVar, new int[0]));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("stopMonitoringBeacons")) {
                                    g.e(g.this);
                                    nY(g.b(g.this, iVar, new int[0]));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSendC2CMessageRequest")) {
                                    nY(g.au(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("batchViewCard")) {
                                    nY(g.av(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("connectToFreeWifi")) {
                                    nY(g.aw(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setFreeWifiOwner")) {
                                    nY(g.ax(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setPageOwner")) {
                                    nY(g.ay(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getWechatVerifyTicket")) {
                                    nY(g.az(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openWXDeviceLib")) {
                                    nY(g.aA(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("closeWXDeviceLib")) {
                                    nY(g.aB(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("startScanWXDevice")) {
                                    nY(g.aC(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("stopScanWXDevice")) {
                                    nY(g.aD(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("connectWXDevice")) {
                                    nY(g.aE(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("disconnectWXDevice")) {
                                    nY(g.aF(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getWXDeviceTicket")) {
                                    nY(g.aG(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getWXDeviceInfos")) {
                                    nY(g.aH(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("sendDataToWXDevice")) {
                                    nY(g.aI(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setSendDataDirection")) {
                                    nY(g.aJ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openGameDetail")) {
                                    nY(g.aK(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openGameCenter")) {
                                    nY(g.aL(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setGameDebugConfig")) {
                                    nY(g.aM(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("shareQZone")) {
                                    nY(g.ao(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("startTempSession")) {
                                    nY(g.aN(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getRecevieBizHongBaoRequest")) {
                                    nY(g.aO(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openMyDeviceProfile")) {
                                    nY(g.aP(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("selectPedometerSource")) {
                                    nY(g.this.au(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getH5PrepayRequest")) {
                                    nY(g.aQ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getH5TransactionRequest")) {
                                    nY(g.aR(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("jumpToWXWallet")) {
                                    nY(g.aS(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("scanCover")) {
                                    nY(g.aT(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcIsConnect")) {
                                    nY(g.aU(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcConnect")) {
                                    nY(g.aV(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcTransceive")) {
                                    nY(g.aW(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcBatchTransceive")) {
                                    nY(g.aX(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcGetId")) {
                                    nY(g.aY(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcGetInfo")) {
                                    nY(g.aZ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("nfcCheckState")) {
                                    nY(g.ba(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("videoProxyInit")) {
                                    nY(g.bb(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("videoProxyStartPlay")) {
                                    nY(g.bc(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("videoProxyStopPlay")) {
                                    nY(g.bd(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("videoProxySetPlayerState")) {
                                    nY(g.be(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("videoProxySetRemainTime")) {
                                    nY(g.bf(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchData")) {
                                    nY(g.bg(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getPoiInfo")) {
                                    nY(g.bh(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("updateReddotTimeStamps")) {
                                    nY(g.bi(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reloadSearchWAWidgetData")) {
                                    nY(g.bj(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("insertSearchWAWidgetView")) {
                                    nY(g.bk(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("removeSearchWAWidgetView")) {
                                    nY(g.bl(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("updateSearchWAWidgetView")) {
                                    nY(g.bm(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getTeachSearchData")) {
                                    nY(g.bn(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchGuideData")) {
                                    nY(g.bo(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchAvatarList")) {
                                    nY(g.bp(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchSnsImageList")) {
                                    nY(g.bq(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchImageList")) {
                                    nY(g.br(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchDisplayNameList")) {
                                    nY(g.bs(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("startSearchItemDetailPage")) {
                                    nY(g.bt(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reportSearchStatistics")) {
                                    nY(g.bu(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reportSearchRealTimeStatistics")) {
                                    nY(g.bv(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("searchDataHasResult")) {
                                    nY(g.bw(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchSuggestionData")) {
                                    nY(g.bx(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openEmotionPage")) {
                                    nY(g.by(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setSearchInputWord")) {
                                    nY(g.bz(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openWeAppPage")) {
                                    nY(g.bA(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reportWeAppSearchRealtime")) {
                                    nY(g.bB(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("doSearchOperation")) {
                                    nY(g.bC(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("operateGameCenterMsg")) {
                                    nY(g.bD(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getWebPayCheckoutCounterRequst")) {
                                    nY(g.bE(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setSnsObjectXmlDescList")) {
                                    nY(g.bF(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("clickSnsMusicPlayButton")) {
                                    nY(g.bG(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("addCustomMenuItems")) {
                                    nY(g.bH(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openEnterpriseChat")) {
                                    nY(g.bI(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openEnterpriseContact")) {
                                    nY(g.bJ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("selectEnterpriseContact")) {
                                    nY(g.bK(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("sendEnterpriseChat")) {
                                    nY(g.bL(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("enterEnterpriseChat")) {
                                    nY(g.bM(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getEnterpriseChat")) {
                                    nY(g.bN(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reportActionInfo")) {
                                    nY(g.bO(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("showSearchOfBizHistory")) {
                                    nY(g.bP(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("cache")) {
                                    nY(g.bQ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("publicCache")) {
                                    nY(g.bR(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("changePayActivityView")) {
                                    nY(g.bS(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("scanLicence")) {
                                    nY(g.bT(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openWeApp")) {
                                    nY(g.bU(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openECard")) {
                                    nY(g.bV(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("sendDataToMiniProgram")) {
                                    nY(g.bW(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("preloadMiniProgramEnv")) {
                                    nY(g.bX(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("preloadMiniProgramContacts")) {
                                    nY(g.bY(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("enablePullDownRefresh")) {
                                    nY(g.this.bH(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(com.tencent.mm.plugin.appbrand.jsapi.k.z.NAME)) {
                                    nY(g.this.bI(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(aa.NAME)) {
                                    nY(g.this.bJ(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("disablePullDownRefresh")) {
                                    nY(g.this.dcI());
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("disableBounceScroll")) {
                                    nY(g.this.bM(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("clearBounceBackground")) {
                                    nY(g.this.bN(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("showKeyboard")) {
                                    nY(g.this.bK(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("showSmileyPanel")) {
                                    nY(g.this.bL(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openMapNavigateMenu")) {
                                    nY(g.this.bQ(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setNavigationBarButtons")) {
                                    nY(g.bZ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("enableFullScreen")) {
                                    nY(g.ca(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reportMiniProgramPageData")) {
                                    nY(g.cb(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setPageTitle")) {
                                    nY(g.cc(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setStatusBarStyle")) {
                                    nY(g.cd(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("forceUpdateWxaAttr")) {
                                    nY(g.ce(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiLaunchMiniProgram.NAME)) {
                                    nY(g.cf(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.NAME)) {
                                    nY(g.cg(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("reportIDKey")) {
                                    nY(g.ch(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("quicklyAddBrandContact")) {
                                    nY(g.ci(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("consumedShareCard")) {
                                    nY(g.cj(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("kvReport")) {
                                    nY(g.this.bz(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("realtimeReport")) {
                                    nY(g.this.bP(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openUrlWithExtraWebview")) {
                                    nY(g.ck(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("videoProxyPreload")) {
                                    nY(g.cl(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getLocalData")) {
                                    nY(g.cm(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("setLocalData")) {
                                    nY(g.cn(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("clearLocalData")) {
                                    nY(g.co(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("selectSingleContact")) {
                                    nY(g.cp(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("sendAppMessageToSpecifiedContact")) {
                                    nY(g.cq(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("deleteAccountSuccess")) {
                                    nY(g.f(g.this));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiChooseVideo.NAME)) {
                                    nY(g.cr(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("uploadVideo")) {
                                    nY(g.cs(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(o.NAME)) {
                                    nY(g.ct(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openDesignerEmojiView")) {
                                    nY(g.a(g.this, iVar, false));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openDesignerProfile")) {
                                    nY(g.b(g.this, iVar, false));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openEmoticonTopicList")) {
                                    nY(g.cu(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openDesignerEmojiViewLocal")) {
                                    nY(g.a(g.this, iVar, true));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openDesignerProfileLocal")) {
                                    nY(g.b(g.this, iVar, true));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openEmotionDetailViewLocal")) {
                                    nY(g.cv(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openNewPage")) {
                                    nY(g.cw(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getSearchEmotionData")) {
                                    nY(g.cx(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openEmotionUrl")) {
                                    nY(g.cy(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getWCPayRealnameVerify")) {
                                    nY(g.this.aU(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("selectWalletCurrency")) {
                                    nY(g.this.dcG());
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiOperateMusicPlayer.NAME)) {
                                    nY(g.cz(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiGetMusicPlayerState.NAME)) {
                                    nY(g.cA(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("clearWebviewCache")) {
                                    nY(g.cB(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("requireSoterBiometricAuthentication")) {
                                    nY(g.cC(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getSupportSoter")) {
                                    nY(g.cD(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("unbindBankCard")) {
                                    nY(g.cE(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("setBounceBackground")) {
                                    nY(g.this.bO(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("doExposePreparation")) {
                                    nY(g.cF(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getMsgProofItems")) {
                                    nY(g.cG(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("uploadMediaFile")) {
                                    nY(g.cH(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openSecurityView")) {
                                    nY(g.cI(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("startVoipCall")) {
                                    nY(g.cJ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getOpenDeviceId")) {
                                    nY(g.cK(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("getRouteUrl")) {
                                    nY(g.cL(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("idCardRealnameVerify")) {
                                    nY(g.this.aW(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("uploadIdCardSuccess")) {
                                    nY(g.this.aX(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getGameCommInfo")) {
                                    nY(g.this.aY(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openGameRegion")) {
                                    nY(g.this.dcH());
                                    z = true;
                                } else if (iVar.uIJ.equals("chooseIdCard")) {
                                    nY(g.this.aZ(iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.m.e.NAME)) {
                                    nY(g.cM(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openLuckyMoneyDetailView")) {
                                    nY(g.cN(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("resendRemittanceMsg")) {
                                    nY(g.cO(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getLocalImgData")) {
                                    nY(g.cP(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("recordVideo")) {
                                    nY(g.cQ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("previewVideo")) {
                                    nY(g.cR(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("uploadEncryptMediaFile")) {
                                    nY(g.cS(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openCustomWebview")) {
                                    nY(g.cT(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(JsApiChooseMedia.NAME)) {
                                    nY(g.cU(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openLuckyMoneyHistory")) {
                                    nY(g.cV(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("requestWxFacePictureVerify")) {
                                    nY(g.c(g.this, iVar, false));
                                    z = true;
                                } else if (iVar.uIJ.equals("getWePkgAuthResult")) {
                                    nY(g.cW(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getLocalWePkgInfo")) {
                                    nY(g.cX(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openGameWebView")) {
                                    nY(g.cY(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("launchApplication")) {
                                    nY(g.cZ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("login") || iVar.uIJ.equals("authorize")) {
                                    nY(g.da(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("requestWxFacePictureVerifyUnionVideo")) {
                                    nY(g.c(g.this, iVar, true));
                                    z = true;
                                } else if (iVar.uIJ.equals("checkIsSupportFaceDetect")) {
                                    nY(g.db(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(JsApiOperateBackgroundAudio.NAME)) {
                                    nY(g.dc(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(JsApiSetBackgroundAudioState.NAME)) {
                                    nY(g.e(g.this, iVar, jsapiPermissionWrapper));
                                    z = true;
                                } else if (iVar.uIJ.equals(JsApiGetBackgroundAudioState.NAME)) {
                                    nY(g.dd(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase(JsApiAddDownloadTaskStraight.NAME)) {
                                    nY(g.f(g.this, iVar, jsapiPermissionWrapper));
                                    z = true;
                                } else if (iVar.uIJ.equals("setScreenOrientation")) {
                                    nY(g.de(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("addToEmoticon")) {
                                    nY(g.df(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("shareEmoticon")) {
                                    nY(g.dg(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("requestWxFaceRegisterInternal")) {
                                    nY(g.dh(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("requestWxFaceVerifyInternal")) {
                                    nY(g.di(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(JsApiOpenAdCanvas.NAME)) {
                                    nY(g.a(g.this, iVar, 0));
                                    z = true;
                                } else if (iVar.uIJ.equals("openSearchCanvas")) {
                                    nY(g.a(g.this, iVar, 1));
                                    z = true;
                                } else if (iVar.uIJ.equals("opVoteAdData")) {
                                    nY(g.dj(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("selectContact")) {
                                    nY(g.dk(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(as.NAME)) {
                                    nY(g.dl(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("setWCPayPassword")) {
                                    nY(g.dm(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(af.NAME)) {
                                    nY(g.dn(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("showSearchActionSheet")) {
                                    nY(g.do(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("cancelSearchActionSheet")) {
                                    nY(g.dp(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("showSearchToast")) {
                                    nY(g.dq(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("showSearchLoading")) {
                                    nY(g.dr(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("hideSearchLoading")) {
                                    nY(g.ds(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("updateWASearchTemplate")) {
                                    nY(g.dt(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("preloadSearchWeapp")) {
                                    nY(g.du(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("uxSearchOpLog")) {
                                    nY(g.dv(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openSearchWAWidgetLogView")) {
                                    nY(g.dw(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openBizChat")) {
                                    nY(g.dx(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("tapSearchWAWidgetView")) {
                                    nY(g.dy(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getMatchContactList")) {
                                    nY(g.dz(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openSearchWebView")) {
                                    nY(g.dA(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equalsIgnoreCase("openWXSearchPage")) {
                                    nY(g.dB(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("viewTypeChange")) {
                                    nY(g.dC(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openGameUrlWithExtraWebView")) {
                                    nY(g.dD(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("requestWxVoicePrintVerifyInternal")) {
                                    nY(g.dE(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("closeWindowAndGoNext")) {
                                    nY(g.dF(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("invokeMiniProgramAPI")) {
                                    nY(g.dG(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("setGameData")) {
                                    nY(g.dH(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getGameData")) {
                                    nY(g.dI(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("clearGameData")) {
                                    nY(g.dJ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("handleWCPayWalletBuffer")) {
                                    nY(g.dK(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("reportGamePageTime")) {
                                    nY(g.dL(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.video.f.NAME)) {
                                    nY(g.dM(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.video.j.NAME)) {
                                    nY(g.dN(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(i.NAME)) {
                                    nY(g.dO(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.video.h.NAME)) {
                                    nY(g.dP(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getSearchHistory")) {
                                    nY(g.g(g.this));
                                    z = true;
                                } else if (iVar.uIJ.equals("deleteSearchHistory")) {
                                    nY(g.dQ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("doGoToRecVideoList") || iVar.uIJ.equals("jumpWSRecVideoList")) {
                                    nY(g.dR(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("recordHistory")) {
                                    nY(g.dS(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(ax.NAME)) {
                                    nY(g.dT(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openWCPayCardList")) {
                                    nY(g.dU(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("bindEmail")) {
                                    nY(g.h(g.this));
                                    z = true;
                                } else if (iVar.uIJ.equals("getSystemInfo")) {
                                    nY(g.dV(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("serviceClick")) {
                                    nY(g.dW(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME)) {
                                    nY(g.dX(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("sendSingleAppMessage")) {
                                    nY(g.dY(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openWebSearchOutLinkItem")) {
                                    nY(g.dZ(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("wcPrivacyPolicyResult")) {
                                    nY(g.ea(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("currentMpInfo")) {
                                    nY(g.eb(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME)) {
                                    nY(g.ec(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("jumpDownloaderWidget")) {
                                    nY(g.ed(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("batchUpdateWepkg")) {
                                    nY(g.ee(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("privateOpenWeappFunctionalPage")) {
                                    nY(g.ef(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("privateCommonApi")) {
                                    nY(g.eg(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("internelWxFaceVerify")) {
                                    nY(g.eh(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("openWebViewUseFastLoad")) {
                                    nY(g.ei(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("handleHaokanAction")) {
                                    nY(g.ej(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("confirmDialog")) {
                                    nY(g.ek(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getCCData")) {
                                    nY(g.el(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("calRqt")) {
                                    nY(g.em(g.this, iVar));
                                    z = true;
                                } else if (com.tencent.mm.plugin.webview.preload.e.afb(iVar.uIJ)) {
                                    nY(g.en(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("addGameDownloadTask")) {
                                    nY(g.eo(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("reportGameWeb")) {
                                    nY(g.ep(g.this, iVar));
                                    z = true;
                                } else if (iVar.uIJ.equals("getDownloadWidgetTaskInfos")) {
                                    nY(g.eq(g.this, iVar));
                                    z = true;
                                } else {
                                    ab.e("MicroMsg.MsgHandler", "unknown function = " + iVar.uIJ);
                                    g.a(g.this, iVar, "system:function_not_exist", null);
                                    nY(true);
                                    z = false;
                                }
                                Object obj = iVar.dcO().get("Internal@AsyncReport");
                                if (!(obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue())) {
                                    g.d(g.this, iVar, z);
                                }
                                if (!z) {
                                    g.b(g.this, iVar, aVar.getCode());
                                }
                                AppMethodBeat.o(9037);
                            }

                            public final boolean dcf() {
                                return this.uFl;
                            }
                        };
                        this.uGr.a(jsapiPermissionWrapper, getCurrentUrl(), akD.dmb(), iVar, anonymousClass1);
                        z = anonymousClass1.dcf();
                        AppMethodBeat.o(9226);
                        return z;
                    } catch (Exception e2) {
                        ab.e("MicroMsg.MsgHandler", "handleMsg excpetion %s", e2.getMessage());
                        ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[z]);
                    }
                } else {
                    ab.e("MicroMsg.MsgHandler", "handleMsg access denied func: %s", akD.getName());
                    a(iVar, "system:access_denied", null, true);
                    AppMethodBeat.o(9226);
                    return true;
                }
            }
        }
        ab.e("MicroMsg.MsgHandler", "unknown type = " + iVar.type);
        this.eBB = z;
        AppMethodBeat.o(9226);
        return z;
    }

    private boolean b(final i iVar) {
        AppMethodBeat.i(9227);
        ab.d("MicroMsg.MsgHandler", "doShowDatePicker");
        String str = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String format;
            String str2;
            String str3 = (String) iVar.puc.get("current");
            if (bo.isNullOrNil(str3)) {
                format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            } else {
                format = str3;
            }
            str3 = (String) iVar.puc.get("range");
            if (bo.isNullOrNil(str3)) {
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("start", "2013-01-01");
                str2 = jSONObject.optString("end", format);
                str = optString;
            }
            str3 = (String) iVar.puc.get(GraphRequest.FIELDS_PARAM);
            if (bo.isNullOrNil(str3)) {
                str3 = "month";
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(format));
            if (this.context == null || !(this.context instanceof Activity)) {
                ab.e("MicroMsg.MsgHandler", "context error!");
                AppMethodBeat.o(9227);
                return false;
            }
            boolean z;
            boolean z2;
            com.tencent.mm.ui.widget.picker.a aVar = new com.tencent.mm.ui.widget.picker.a(this.context);
            aVar.aB(instance.get(1), instance.get(2) + 1, instance.get(5));
            if (str3.equals("year")) {
                z = false;
                z2 = false;
            } else if (str3.equals("month")) {
                z = false;
                z2 = true;
            } else {
                z = true;
                z2 = true;
            }
            aVar.al(z2, z);
            String[] split = str.split("-");
            if (split.length >= 3) {
                aVar.aC(bo.ank(split[0]), bo.ank(split[1]), bo.ank(split[2]));
            }
            split = str2.split("-");
            if (split.length >= 3) {
                aVar.aD(bo.ank(split[0]), bo.ank(split[1]), bo.ank(split[2]));
            }
            aVar.zSj = new com.tencent.mm.ui.widget.picker.a.a() {
                public final void b(boolean z, int i, int i2, int i3) {
                    AppMethodBeat.i(9119);
                    ab.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("selectTime", String.format("%d-%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
                        g.a(g.this, iVar, "showDatePickerView:ok", hashMap);
                        AppMethodBeat.o(9119);
                        return;
                    }
                    ab.i("MicroMsg.MsgHandler", "cancel date set");
                    g.a(g.this, iVar, "showDatePickerView:cancel", null);
                    AppMethodBeat.o(9119);
                }
            };
            aVar.show();
            AppMethodBeat.o(9227);
            return true;
        } catch (JSONException e) {
            ab.e("MicroMsg.MsgHandler", "doShowDatePicker ex: %s", e.getMessage());
        } catch (ParseException e2) {
            ab.e("MicroMsg.MsgHandler", "doShowDatePicker ex: %s", e2.getMessage());
        }
    }

    private boolean c(i iVar) {
        AppMethodBeat.i(9228);
        try {
            String str = (String) this.uGd.puc.get("link");
            l.a(this.uGd.uII, agw(com.tencent.mm.plugin.appbrand.jsapi.share.f.NAME), str, null);
            if (str == null || str.length() == 0) {
                ab.e("MicroMsg.MsgHandler", "naerCheckIn fail, link is null");
                a(this.uGd, "timeline_check_in:fail", null);
                AppMethodBeat.o(9228);
                return true;
            }
            int intValue;
            agz((String) this.uGd.puc.get("desc"));
            ab.i("MicroMsg.MsgHandler", "naerCheckIn, img_url = " + ((String) this.uGd.puc.get("img_url")) + ", title = " + ((String) this.uGd.puc.get("title")) + ", desc = " + ((String) this.uGd.puc.get("desc")));
            str = (String) this.uGd.puc.get("img_width");
            String str2 = (String) this.uGd.puc.get("img_height");
            ab.i("MicroMsg.MsgHandler", "naerCheckIn, rawUrl:[%s], shareUrl:[%s]", (String) this.uGd.puc.get("link"), ar.aek((String) this.uGd.puc.get("link")));
            String str3 = (String) this.uGd.puc.get("type");
            this.uGd.puc.get("desc");
            String str4 = (String) this.uGd.puc.get("title");
            String str5 = (String) this.uGd.puc.get("img_url");
            try {
                intValue = Integer.valueOf(str).intValue();
                try {
                    Integer.valueOf(str2);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                intValue = -1;
            }
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_width", intValue);
            intent.putExtra("Ksnsupload_height", intValue);
            intent.putExtra("Ksnsupload_link", r8);
            intent.putExtra("Ksnsupload_title", str4);
            intent.putExtra("Ksnsupload_imgurl", str5);
            intent.putExtra("Ksnsupload_type", 1);
            if (!bo.isNullOrNil(str3) && str3.equals("music")) {
                intent.putExtra("ksnsis_music", true);
            }
            if (!bo.isNullOrNil(str3) && str3.equals("video")) {
                intent.putExtra("ksnsis_video", true);
            }
            str = (String) this.uGd.puc.get("poiId");
            str2 = (String) this.uGd.puc.get("poiName");
            str3 = (String) this.uGd.puc.get("poiAddress");
            float f = bo.getFloat((String) iVar.puc.get("latitude"), 0.0f);
            float f2 = bo.getFloat((String) iVar.puc.get("longitude"), 0.0f);
            intent.putExtra("kpoi_id", str);
            intent.putExtra("kpoi_name", str2);
            intent.putExtra("Kpoi_address", str3);
            intent.putExtra("k_lat", f);
            intent.putExtra("k_lng", f2);
            com.tencent.mm.bp.d.b(this.context, "sns", ".ui.SnsUploadUI", intent);
            this.eBB = false;
            AppMethodBeat.o(9228);
            return false;
        } catch (Exception e3) {
            AppMethodBeat.o(9228);
            return true;
        }
    }

    private boolean d(i iVar) {
        int i = 0;
        AppMethodBeat.i(9229);
        try {
            float f = bo.getFloat((String) iVar.puc.get("latitude"), 0.0f);
            float f2 = bo.getFloat((String) iVar.puc.get("longitude"), 0.0f);
            String Eh = Eh((String) iVar.puc.get("name"));
            String Eh2 = Eh((String) iVar.puc.get("address"));
            String Eh3 = Eh((String) iVar.puc.get("infoUrl"));
            try {
                i = bo.getInt((String) iVar.puc.get(WMElement.ANIMATE_TYPE_SCALE), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            if (bo.getInt((String) this.uGd.puc.get("webview_scene"), 0) == 25) {
                intent.putExtra("map_view_type", 9);
                intent.putExtra("kPoi_url", Eh3);
            } else {
                intent.putExtra("map_view_type", 7);
            }
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i > 0) {
                intent.putExtra("kwebmap_scale", i);
            }
            intent.putExtra("kPoiName", Eh);
            intent.putExtra("Kwebmap_locaion", Eh2);
            com.tencent.mm.bp.d.b(this.context, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
            a(this.uGd, "open_location:ok", null);
        } catch (Exception e2) {
            a(this.uGd, "open_location:invalid_coordinate", null);
        }
        AppMethodBeat.o(9229);
        return true;
    }

    static {
        AppMethodBeat.i(9805);
        HashSet hashSet = new HashSet();
        uGK = hashSet;
        hashSet.add("gcj02");
        uGK.add("wgs84");
        AppMethodBeat.o(9805);
    }

    private static String Eh(String str) {
        AppMethodBeat.i(9230);
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < iRk.length) {
                String str2 = iRl[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != iRk.length) {
                stringBuffer.append(iRk[i2]);
                i = iRl[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(9230);
        return stringBuffer2;
    }

    private boolean e(i iVar) {
        AppMethodBeat.i(9231);
        try {
            String str = (String) iVar.puc.get("bid");
            Intent intent = new Intent();
            intent.putExtra("sns_bid", str);
            com.tencent.mm.bp.d.b(this.context, "sns", ".ui.ClassifyTimeLineUI", intent);
            a(this.uGd, "open_timeline_checkin_list:ok", null);
        } catch (Exception e) {
        }
        AppMethodBeat.o(9231);
        return true;
    }

    private boolean b(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        AppMethodBeat.i(9232);
        this.cEl = g(iVar);
        if (this.cEl == null) {
            ab.e("MicroMsg.MsgHandler", "doSendAppMsg fail, appmsg is null");
            a(iVar, "send_app_msg:fail", null);
            AppMethodBeat.o(9232);
            return true;
        }
        String string = dcv().getString("scene");
        dcv().remove("scene");
        if (!"friend".equals(string)) {
            l.a(iVar.uII, agw("sendAppMessage"), null, (String) iVar.puc.get("appid"));
        }
        ab.i("MicroMsg.MsgHandler", "send appmsg scene is '%s'", string);
        String string2;
        Intent intent;
        if ("connector".equals(string)) {
            ab.i("MicroMsg.MsgHandler", "directly send to %s", dcw());
            c(1, -1, new Intent().putExtra("Select_Conv_User", string2));
        } else if ("favorite".equals(string)) {
            ab.i("MicroMsg.MsgHandler", "favorite url");
            cl clVar = new cl();
            com.tencent.mm.plugin.webview.model.c.a aVar = new com.tencent.mm.plugin.webview.model.c.a();
            ab.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", (String) this.uGd.puc.get("link"), ar.aek((String) this.uGd.puc.get("link")));
            aVar.url = r4;
            aVar.thumbUrl = (String) this.uGd.puc.get("img_url");
            aVar.title = (String) this.uGd.puc.get("title");
            aVar.desc = (String) this.uGd.puc.get("desc");
            aVar.csB = (String) this.uGd.puc.get("appid");
            if (this.uGh != null) {
                string2 = this.uGh.getString("key_snsad_statextstr");
                aVar.cMn = string2;
            } else {
                string2 = null;
            }
            try {
                Bundle g = this.umI.g(18, null);
                if (g != null) {
                    String nW = v.nW(bo.nullAsNil(g.getString("KPublisherId")));
                    com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                    y.j("sendAppMsgScene", Integer.valueOf(2));
                    y.j("preChatName", g.getString("preChatName"));
                    y.j("preMsgIndex", Integer.valueOf(g.getInt("preMsgIndex")));
                    y.j("prePublishId", g.getString("prePublishId"));
                    y.j("preUsername", g.getString("preUsername"));
                    y.j("getA8KeyScene", Integer.valueOf(g.getInt("getA8KeyScene")));
                    y.j("referUrl", g.getString("referUrl"));
                    if (!bo.isNullOrNil(string2)) {
                        y.j("adExtStr", string2);
                    }
                    clVar.cvA.cvF = nW;
                }
            } catch (RemoteException e) {
                ab.e("MicroMsg.MsgHandler", "try to report error, %s", e);
            }
            if (this.context instanceof Activity) {
                clVar.cvA.activity = (Activity) this.context;
                clVar.cvA.cvH = 36;
                try {
                    Object obj = this.uGd.puc.get("KPublisherId");
                    if (obj != null) {
                        if (obj.toString().startsWith("wrd")) {
                            clVar.cvA.scene = 2;
                        } else if (obj.toString().startsWith("gs")) {
                            clVar.cvA.scene = 3;
                        }
                    }
                } catch (Exception e2) {
                }
            }
            com.tencent.mm.plugin.webview.model.c.a(clVar, aVar);
            clVar.cvA.cvJ = new com.tencent.mm.ui.widget.snackbar.a.c() {
                public final void onShow() {
                }

                public final void onHide() {
                    AppMethodBeat.i(9132);
                    g.a(g.this, g.this.uGd, "send_app_msg:ok", null);
                    AppMethodBeat.o(9132);
                }

                public final void cLd() {
                }
            };
            com.tencent.mm.sdk.b.a.xxA.m(clVar);
            this.uGv.bE(3, (String) this.uGd.puc.get("use_update_jsapi_data"));
            if (clVar.cvB.ret == 0) {
                gB(3, 1);
                try {
                    a(aVar.csB, aVar.thumbUrl, 4, this.umI.g(85, null));
                } catch (RemoteException e3) {
                    ab.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", e3);
                }
            } else {
                gB(3, 2);
                a(this.uGd, "send_fav_msg:fail", null);
            }
        } else if ("enterprise".equals(string)) {
            String dcw = dcw();
            HashMap hashMap = new HashMap();
            hashMap.put("img_url", (String) iVar.puc.get("img_url"));
            hashMap.put("desc", (String) iVar.puc.get("desc"));
            hashMap.put("title", (String) iVar.puc.get("title"));
            hashMap.put("src_username", (String) iVar.puc.get("src_username"));
            hashMap.put("src_displayname", (String) iVar.puc.get("src_displayname"));
            ab.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s", (String) iVar.puc.get("img_url"), (String) iVar.puc.get("desc"), (String) iVar.puc.get("title"));
            Intent intent2;
            if (com.tencent.mm.aj.f.kq(dcw)) {
                intent2 = new Intent();
                intent2.setClassName(this.context, "com.tencent.mm.ui.bizchat.BizChatSelectConversationUI");
                intent2.putExtra("enterprise_biz_name", dcw);
                intent2.putExtra("biz_chat_scene", 1);
                intent2.putExtra("enterprise_extra_params", hashMap);
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).ifE = this;
                    ((MMActivity) this.context).b((com.tencent.mm.ui.MMActivity.a) this, intent2, 37);
                }
            } else if (com.tencent.mm.aj.f.rc(dcw)) {
                intent2 = new Intent();
                intent2.putExtra("enterprise_biz_name", dcw);
                intent2.putExtra("enterprise_scene", 3);
                intent2.putExtra("enterprise_extra_params", hashMap);
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).ifE = this;
                    com.tencent.mm.bp.d.b(this.context, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2, 37);
                }
            }
        } else if ("wework".equals(string)) {
            ao(iVar);
        } else if ("facebook".equals(string)) {
            intent = new Intent();
            intent.putExtra("title", (String) iVar.puc.get("title"));
            intent.putExtra("digest", (String) iVar.puc.get("desc"));
            intent.putExtra("img", (String) iVar.puc.get("img_url"));
            intent.putExtra("link", (String) iVar.puc.get("link"));
            intent.setClassName(this.context, "com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI");
            this.context.startActivity(intent);
            a(iVar, "shareQZone:ok", null);
        } else if ("qq".equals(string)) {
            ap(iVar);
        } else {
            this.uGv.bE(1, (String) iVar.puc.get("use_update_jsapi_data"));
            ab.i("MicroMsg.MsgHandler", "select user to send");
            HashMap hashMap2 = new HashMap();
            if (a(iVar, jsapiPermissionWrapper.jB(89))) {
                this.cEl = g(iVar);
            }
            if (jsapiPermissionWrapper.jB(290)) {
                this.uGd.puc.put("share_callback_with_scene", Boolean.TRUE);
            } else {
                this.uGd.puc.put("share_callback_with_scene", Boolean.FALSE);
            }
            string2 = (String) iVar.puc.get("img_url");
            hashMap2.put("img_url", string2);
            hashMap2.put("desc", (String) iVar.puc.get("desc"));
            hashMap2.put("title", (String) iVar.puc.get("title"));
            hashMap2.put("url", (String) iVar.puc.get("url"));
            ab.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s, url=%s", (String) iVar.puc.get("img_url"), (String) iVar.puc.get("desc"), (String) iVar.puc.get("title"), (String) iVar.puc.get("url"));
            h.pYm.a(157, 5, 1, false);
            intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 2);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("webview_params", hashMap2);
            intent.putExtra("Retr_Msg_Type", 2);
            if (this.context instanceof MMActivity) {
                iVar.uII.put("Internal@AsyncReport", Boolean.TRUE);
                if (bo.getInt((String) iVar.puc.get("open_from_scene"), 0) == 4) {
                    com.tencent.mm.plugin.fav.a.h.j(this.uGh.getLong("favlocalid", 0), 1, 0);
                }
                com.tencent.mm.bp.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 1, (com.tencent.mm.ui.MMActivity.a) this);
                k.agC(string2);
            } else {
                ab.e("MicroMsg.MsgHandler", "doSendAppMessage context is not activity");
                AppMethodBeat.o(9232);
                return false;
            }
        }
        AppMethodBeat.o(9232);
        return true;
    }

    private boolean hn(String str, String str2) {
        boolean z;
        AppMethodBeat.i(9233);
        c cVar = this.uGr;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d dVar;
        if (TextUtils.isEmpty(str2)) {
            dVar = null;
        } else {
            dVar = (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) cVar.ujx.get(str2);
            if (dVar == null) {
                dVar = (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) cVar.ujx.get(c.aef(str2));
            }
        }
        if (TextUtils.isEmpty(str) || dVar == null || dVar.uFm == null || dVar.uFm.size() <= 0) {
            z = false;
        } else {
            String substring;
            boolean z2;
            LinkedList<String> linkedList = new LinkedList();
            int indexOf = str.indexOf("://");
            String substring2 = str.substring((indexOf == -1 ? 1 : 3) + indexOf);
            for (String substring3 : dVar.uFm) {
                ab.i("MicroMsg.MsgHandler", "now domain : %s", substring3);
                if (!TextUtils.isEmpty(substring3)) {
                    int i;
                    int indexOf2 = substring3.indexOf("://");
                    if (indexOf2 == -1) {
                        i = 1;
                    } else {
                        i = 3;
                    }
                    substring3 = substring3.substring(i + indexOf2);
                    if (!substring3.contains("/")) {
                        linkedList.add(substring3);
                    } else if (substring2.equals(substring3)) {
                        z2 = false;
                        break;
                    } else {
                        if (!substring3.endsWith("/")) {
                            substring3 = substring3 + "/";
                        }
                        if (substring2.startsWith(substring3)) {
                            z2 = false;
                            break;
                        }
                    }
                }
            }
            z2 = true;
            if (z2 && !linkedList.isEmpty()) {
                URI create = URI.create(str);
                String host = create.getHost();
                indexOf = create.getPort();
                String str3 = host + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + indexOf;
                ab.i("MicroMsg.MsgHandler", "share domain : %s", host);
                if (!bo.isNullOrNil(host)) {
                    for (String substring32 : linkedList) {
                        if (host.equals(substring32) || host.endsWith(".".concat(String.valueOf(substring32))) || (indexOf != -1 && (str3.equals(substring32) || str3.endsWith(".".concat(String.valueOf(substring32)))))) {
                            z = false;
                            break;
                        }
                    }
                }
            }
            z = z2;
        }
        AppMethodBeat.o(9233);
        return z;
    }

    private boolean f(i iVar) {
        String string;
        AppMethodBeat.i(9234);
        Object obj = iVar.puc.get("__jsapi_fw_ext_info");
        String str = (String) iVar.puc.get("link");
        if (obj instanceof Bundle) {
            string = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        } else {
            string = null;
        }
        boolean hn = hn(str, string);
        AppMethodBeat.o(9234);
        return hn;
    }

    private boolean a(i iVar, boolean z) {
        AppMethodBeat.i(9235);
        Object obj = iVar.puc.get("__jsapi_fw_ext_info");
        String str = (String) iVar.puc.get("link");
        if (obj instanceof Bundle) {
            obj = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        } else {
            obj = null;
        }
        if (hn(str, obj) || !z) {
            try {
                Bundle g = this.umI.g(84, null);
                if (g != null) {
                    if (TextUtils.isEmpty(obj)) {
                        obj = ar.aek(g.getString("webview_current_url"));
                    }
                    iVar.puc.put("img_url", "");
                    iVar.puc.put("link", obj);
                    iVar.puc.put("desc", g.getString("webview_current_desc"));
                    iVar.puc.put("title", g.getString("webview_current_title"));
                    AppMethodBeat.o(9235);
                    return true;
                }
            } catch (RemoteException e) {
                ab.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", e);
            }
        }
        AppMethodBeat.o(9235);
        return false;
    }

    private String dcw() {
        AppMethodBeat.i(9236);
        String string = dcv().getString("connector_local_send");
        dcv().remove("connector_local_send");
        dcv().putString("connector_local_report", string);
        AppMethodBeat.o(9236);
        return string;
    }

    private String dcx() {
        AppMethodBeat.i(9237);
        String string = dcv().getString("connector_local_report");
        dcv().remove("connector_local_report");
        AppMethodBeat.o(9237);
        return string;
    }

    private static WXMediaMessage g(i iVar) {
        AppMethodBeat.i(9238);
        String str = (String) iVar.puc.get("link");
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgHandler", "convert fail, link is null");
            AppMethodBeat.o(9238);
            return null;
        }
        ab.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", str, ar.aek(str));
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = r1;
        wXWebpageObject.extInfo = (String) iVar.puc.get("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = (String) iVar.puc.get("title");
        wXMediaMessage.description = (String) iVar.puc.get("desc");
        AppMethodBeat.o(9238);
        return wXMediaMessage;
    }

    private boolean h(i iVar) {
        int i = 0;
        AppMethodBeat.i(9239);
        this.eBB = false;
        String obj = iVar.puc.get("list").toString();
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(obj);
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bfk bfk = new bfk();
                    bfk.wJl = optJSONObject.optInt("cmdId");
                    obj = optJSONObject.optString("cmdBuffer");
                    if (TextUtils.isEmpty(obj)) {
                        ab.e("MicroMsg.MsgHandler", "doUxSearchOpLog cmdId " + bfk.wJl + " , cmdBuffer is empty");
                    } else {
                        bfk.wJm = new com.tencent.mm.bt.b(obj.getBytes());
                        linkedList.add(bfk);
                    }
                }
                i++;
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.MsgHandler", bo.l(e));
        }
        Map hashMap = new HashMap();
        final long anU = bo.anU();
        hashMap.put("reqId", Long.valueOf(anU));
        if (!linkedList.isEmpty()) {
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new cso();
            aVar.fsK = new csp();
            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_opsearch";
            aVar.fsI = 1865;
            com.tencent.mm.ai.b acD = aVar.acD();
            ((cso) acD.fsG.fsP).xpQ = linkedList;
            w.a(acD, new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(9145);
                    ab.i("MicroMsg.MsgHandler", "doUxSearchOpLog rsp errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    csp csp = (csp) bVar.fsH.fsP;
                    Bundle bundle = new Bundle();
                    bundle.putLong("reqId", anU);
                    bundle.putInt("ret", i2);
                    if (csp.xpR != null) {
                        csp.xpR.dlY();
                        bundle.putString("json", csp.xpR.dlY());
                    }
                    try {
                        if (g.this.umI != null) {
                            g.this.umI.c(ErrorCode.NEEDDOWNLOAD_8, bundle);
                        }
                    } catch (RemoteException e) {
                        ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(9145);
                    return 0;
                }
            });
        }
        a(iVar, "uxSearchOpLog:succ", hashMap);
        AppMethodBeat.o(9239);
        return true;
    }

    private boolean i(i iVar) {
        AppMethodBeat.i(9240);
        this.eBB = false;
        if (iVar.puc.containsKey("actionSheetId")) {
            int ank = bo.ank((String) iVar.puc.get("actionSheetId"));
            Bundle bundle = new Bundle();
            bundle.putInt("actionSheetId", ank);
            try {
                this.umI.c(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, bundle);
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            }
        }
        a(iVar, "", null);
        AppMethodBeat.o(9240);
        return true;
    }

    private boolean j(i iVar) {
        AppMethodBeat.i(9241);
        this.eBB = false;
        Bundle bundle = new Bundle();
        if (iVar.puc.containsKey("title")) {
            bundle.putString("title", (String) iVar.puc.get("title"));
        }
        if (iVar.puc.containsKey("desc")) {
            bundle.putString("desc", (String) iVar.puc.get("desc"));
        }
        if (iVar.puc.containsKey("items")) {
            bundle.putString("items", (String) iVar.puc.get("items"));
        }
        try {
            this.umI.c(com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX, bundle);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Map hashMap = new HashMap();
        hashMap.put("actionSheetId", Integer.valueOf(bundle.getInt("actionSheetId")));
        a(iVar, hashMap);
        AppMethodBeat.o(9241);
        return true;
    }

    private boolean k(i iVar) {
        AppMethodBeat.i(9242);
        this.eBB = false;
        try {
            Bundle bundle = new Bundle();
            bundle.putString("title", com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "title"));
            bundle.putString("icon", com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "icon"));
            bundle.putInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 500));
            bundle.putInt("mask", com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "mask", 0));
            this.umI.c(148, bundle);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        a(iVar, "showSearchToast:succ", null);
        AppMethodBeat.o(9242);
        return true;
    }

    private boolean l(i iVar) {
        AppMethodBeat.i(9243);
        this.eBB = false;
        try {
            Bundle bundle = new Bundle();
            bundle.putString("title", com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "title"));
            bundle.putInt("mask", com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "mask", 0));
            this.umI.c(149, bundle);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        a(iVar, "showSearchLoading:succ", null);
        AppMethodBeat.o(9243);
        return true;
    }

    private boolean m(i iVar) {
        AppMethodBeat.i(9244);
        this.eBB = false;
        try {
            this.umI.c(150, new Bundle());
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        a(iVar, "hideSearchLoading:succ", null);
        AppMethodBeat.o(9244);
        return true;
    }

    public final boolean agy(final String str) {
        AppMethodBeat.i(9245);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgHandler", "doProfile fail, username is null");
            this.eBB = false;
            AppMethodBeat.o(9245);
            return false;
        } else if (bo.isNullOrNil(str)) {
            Toast.makeText(ah.getContext(), this.context.getString(R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            this.eBB = false;
            AppMethodBeat.o(9245);
            return false;
        } else {
            if (this.uGd != null) {
                l.a(this.uGd.uII, agw(Scopes.PROFILE), str, null);
            }
            com.tencent.mm.kernel.g.RN();
            if (com.tencent.mm.kernel.a.QX()) {
                com.tencent.mm.n.a aoK;
                com.tencent.mm.n.a aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                    aoK = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoK(str);
                } else {
                    aoK = aoO;
                }
                final Intent intent = new Intent();
                String str2 = "";
                if (!(this.uGd == null || this.uGd.puc == null || this.uGd.puc.get("profileReportInfo") == null)) {
                    str2 = (String) this.uGd.puc.get("profileReportInfo");
                }
                if (!bo.isNullOrNil(str2)) {
                    intent.putExtra("key_add_contact_report_info", str2);
                }
                if (this.uGh != null && this.uGh.getBoolean("KFromBizSearch")) {
                    intent.putExtra("Contact_Ext_Args", this.uGh.getBundle("KBizSearchExtArgs"));
                }
                if (aoK == null || ((int) aoK.ewQ) <= 0) {
                    if (this.uGl != null) {
                        com.tencent.mm.model.ao.a.flu.or(this.uGl);
                    }
                    this.uGl = str;
                    com.tencent.mm.model.ao.a.flu.a(str, "", new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(9158);
                            g.this.uGl = null;
                            if (g.this.context == null) {
                                ab.w("MicroMsg.MsgHandler", "getNow callback, msghandler has already been detached!");
                                g.a(g.this, g.this.uGd, "profile:fail", null);
                                AppMethodBeat.o(9158);
                                return;
                            }
                            com.tencent.mm.n.a aoK;
                            if (g.this.ehJ != null) {
                                g.this.ehJ.dismiss();
                            }
                            com.tencent.mm.n.a aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
                            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                aoK = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoK(str);
                            } else {
                                aoK = aoO;
                            }
                            if (aoK == null || ((int) aoK.ewQ) <= 0) {
                                z = false;
                            } else {
                                str = aoK.field_username;
                            }
                            if (z) {
                                com.tencent.mm.ah.b.U(str, 3);
                                com.tencent.mm.ah.o.acv().pZ(str);
                                intent.addFlags(268435456);
                                intent.putExtra("Contact_User", str);
                                if (aoK.dsf()) {
                                    int i;
                                    if (g.this.uGh == null) {
                                        i = 42;
                                    } else {
                                        i = g.this.uGh.getInt("Contact_Scene", 42);
                                    }
                                    h.pYm.X(10298, aoK.field_username + "," + i);
                                    intent.putExtra("Contact_Scene", i);
                                }
                                g.a(g.this, intent);
                                g.a(g.this, g.this.uGd, "profile:ok", null);
                                AppMethodBeat.o(9158);
                                return;
                            }
                            Toast.makeText(ah.getContext(), g.this.context.getString(R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                            g.a(g.this, g.this.uGd, "profile:fail", null);
                            AppMethodBeat.o(9158);
                        }
                    });
                    Context context = this.context;
                    this.context.getString(R.string.tz);
                    this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(9173);
                            com.tencent.mm.model.ao.a.flu.or(str);
                            g.a(g.this, g.this.uGd, "profile:cancel", null);
                            AppMethodBeat.o(9173);
                        }
                    });
                    AppMethodBeat.o(9245);
                    return true;
                }
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", aoK.field_username);
                if (aoK.dsf()) {
                    int i;
                    if (this.uGh == null) {
                        i = 42;
                    } else {
                        i = this.uGh.getInt("Contact_Scene", 42);
                    }
                    h.pYm.X(10298, aoK.field_username + "," + i);
                    intent.putExtra("Contact_Scene", i);
                }
                if (com.tencent.mm.n.a.jh(aoK.field_type)) {
                    qh qhVar = new qh();
                    qhVar.cMw.intent = intent;
                    qhVar.cMw.username = aoK.field_username;
                    com.tencent.mm.sdk.b.a.xxA.m(qhVar);
                }
                aD(intent);
                a(this.uGd, "profile:ok", null);
                AppMethodBeat.o(9245);
                return false;
            }
            ab.e("MicroMsg.MsgHandler", "doProfile, hasLogin is false");
            this.eBB = false;
            AppMethodBeat.o(9245);
            return false;
        }
    }

    private void aD(final Intent intent) {
        AppMethodBeat.i(9246);
        try {
            Bundle g = this.umI.g(18, null);
            if (g != null) {
                String string = g.getString("preChatName");
                String string2 = g.getString("preUsername");
                int i = g.getInt("preChatTYPE", 0);
                intent.putExtra("preChatName", string);
                intent.putExtra("preUsername", string2);
                intent.putExtra("preChatTYPE", i);
                intent.putExtra("preChatTYPE", i);
                intent.putExtra("url", g.getString("url"));
                intent.putExtra("rawUrl", g.getString("rawUrl"));
            }
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
        }
        com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), Scopes.PROFILE, ".ui.ContactInfoUI", this.umI, new Runnable() {
            public final void run() {
                AppMethodBeat.i(9190);
                com.tencent.mm.plugin.webview.a.a.gkE.c(intent, g.this.context);
                AppMethodBeat.o(9190);
            }
        });
        AppMethodBeat.o(9246);
    }

    private boolean n(final i iVar) {
        AppMethodBeat.i(9247);
        com.tencent.mm.ui.widget.a.c a;
        if (r.Ze()) {
            bq RA = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XU().RA("@t.qq.com");
            if (RA == null || bo.nullAsNil(RA.name).length() == 0) {
                a = com.tencent.mm.ui.base.h.a(this.context, (int) R.string.g1z, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                a.setCancelable(false);
                a.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(9068);
                        g.a(g.this, iVar, "share_weibo:no_weibo", null);
                        AppMethodBeat.o(9068);
                    }
                });
                AppMethodBeat.o(9247);
            } else {
                int i;
                int i2;
                String bc = bo.bc((String) iVar.puc.get("type"), "40");
                if (bc == null || bc.length() <= 0) {
                    i = 40;
                } else {
                    try {
                        i = bo.getInt(bc, 40);
                    } catch (Exception e) {
                        i = 40;
                    }
                }
                if (i == 11 || i == 20) {
                    i2 = i;
                } else {
                    i2 = 40;
                }
                bc = (String) iVar.puc.get(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
                String str = (String) iVar.puc.get("url");
                if (bc == null || bc.trim().length() == 0) {
                    bc = "";
                }
                if (str == null || str.length() == 0) {
                    ab.e("MicroMsg.MsgHandler", "doWeibo fail, invalid argument, content = " + bc + ", url = " + str);
                    a(iVar, "share_weibo:fail_-2", null);
                    AppMethodBeat.o(9247);
                } else {
                    l.a(iVar.uII, agw("shareWeibo"), null, null);
                    str = ar.aek(str);
                    Intent intent = new Intent(this.context, ShareToQQWeiboUI.class);
                    intent.putExtra("type", i2);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, bc);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).b((com.tencent.mm.ui.MMActivity.a) this, intent, 2);
                    }
                    AppMethodBeat.o(9247);
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "doWeibo fail, qq not binded");
            a = com.tencent.mm.ui.base.h.a(this.context, (int) R.string.g21, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9202);
                    com.tencent.mm.plugin.webview.a.a.gkE.g(new Intent(), g.this.context);
                    AppMethodBeat.o(9202);
                }
            }, null);
            a.setCancelable(false);
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(9038);
                    g.a(g.this, iVar, "share_weibo:not_bind_qq", null);
                    AppMethodBeat.o(9038);
                }
            });
            AppMethodBeat.o(9247);
        }
        return true;
    }

    private boolean c(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        AppMethodBeat.i(9248);
        this.uGv.bE(2, (String) iVar.puc.get("use_update_jsapi_data"));
        a(iVar, jsapiPermissionWrapper.jB(88));
        this.cEl = g(iVar);
        if (this.cEl == null) {
            ab.e("MicroMsg.MsgHandler", "doTimeline fail, appmsg is null");
        }
        String str = (String) iVar.puc.get("link");
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgHandler", "doTimeline fail, link is null");
            gB(2, 2);
            a(iVar, "share_timeline:fail", null);
            AppMethodBeat.o(9248);
            return true;
        }
        String str2;
        Bundle g;
        String str3 = (String) iVar.puc.get("desc");
        if (str3 != null) {
            agz(str3);
        }
        ab.i("MicroMsg.MsgHandler", "doTimeline, img_url = " + ((String) iVar.puc.get("img_url")) + ", title = " + ((String) iVar.puc.get("title")) + ", desc = " + ((String) iVar.puc.get("desc")));
        int i = 1;
        String str4 = "";
        int i2 = 0;
        if (this.uGh != null) {
            this.uGh.setClassLoader(getClass().getClassLoader());
            i = this.uGh.getInt("snsWebSource", 1);
            str4 = this.uGh.getString("jsapi_args_appid");
            i2 = bo.getInt(this.uGh.getString("urlAttribute"), 0);
            this.uGh.remove("urlAttribute");
        }
        int i3 = i2;
        int i4 = i;
        if (bo.isNullOrNil(str4)) {
            str2 = (String) iVar.puc.get("appid");
        } else {
            str2 = str4;
        }
        l.a(iVar.uII, agw(com.tencent.mm.plugin.appbrand.jsapi.share.f.NAME), str, str2);
        str3 = (String) iVar.puc.get("img_width");
        str4 = (String) iVar.puc.get("img_height");
        String aek = ar.aek((String) iVar.puc.get("link"));
        ab.i("MicroMsg.MsgHandler", "doTimeline, rawUrl:[%s], shareUrl:[%s]", r3, aek);
        iVar.puc.get("desc");
        String str5 = (String) iVar.puc.get("title");
        String str6 = (String) iVar.puc.get("img_url");
        String str7 = (String) iVar.puc.get("src_username");
        String str8 = (String) iVar.puc.get("src_displayname");
        try {
            i2 = Integer.valueOf(str3).intValue();
            try {
                Integer.valueOf(str4);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            i2 = -1;
        }
        ab.i("MicroMsg.MsgHandler", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", aek);
        intent.putExtra("Ksnsupload_title", str5);
        intent.putExtra("Ksnsupload_imgurl", str6);
        intent.putExtra("Ksnsupload_contentattribute", i3);
        if (t.mZ(str7)) {
            intent.putExtra("src_username", str7);
            intent.putExtra("src_displayname", str8);
        }
        intent.putExtra("Ksnsupload_source", i4);
        intent.putExtra("Ksnsupload_type", 1);
        if (str2 != null && str2.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str2);
        }
        str4 = "MicroMsg.MsgHandler";
        str5 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.uGh == null);
        ab.i(str4, str5, objArr);
        str3 = null;
        if (this.uGh != null) {
            str4 = this.uGh.getString("K_sns_thumb_url");
            str5 = this.uGh.getString("K_sns_raw_url");
            str6 = bo.bc(this.uGh.getString("KSnsStrId"), "");
            str7 = bo.bc(this.uGh.getString("KSnsLocalId"), "");
            str3 = this.uGh.getString("key_snsad_statextstr");
            intent.putExtra("key_snsad_statextstr", str3);
            ab.i("MicroMsg.MsgHandler", "currentUrl %s contentUrl %s thumbUrl %s", str, str5, str4);
            if (!(str5 == null || str == null || !str5.equals(str))) {
                intent.putExtra("KlinkThumb_url", str4);
            }
            intent.putExtra("KSnsStrId", str6);
            intent.putExtra("KSnsLocalId", str7);
            Parcelable parcelable = this.uGh.getParcelable("KSnsAdTag");
            ab.i("MicroMsg.MsgHandler", "doTimeline, snsAdTag : %s", parcelable);
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                intent.putExtra("KsnsAdTag", (SnsAdClick) parcelable);
            }
            if (str6 != null && this.uGh.getBoolean("KFromTimeline", false)) {
                rh rhVar = new rh();
                rhVar.cNm.cFc = str6;
                rhVar.cNm.cwT = str7;
                com.tencent.mm.sdk.b.a.xxA.m(rhVar);
            }
        }
        try {
            intent.putExtra("ShareUrlOriginal", this.umI.cYY());
            g = this.umI.g(18, null);
            intent.putExtra("KPublisherId", g == null ? "" : bo.nullAsNil(g.getString("KPublisherId")));
            str = this.umI.getCurrentUrl();
            intent.putExtra("ShareUrlOpen", str);
            intent.putExtra("JsAppId", this.uGr.agj(str));
        } catch (RemoteException e3) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
        }
        ab.i("MicroMsg.MsgHandler", "doTimeline, start activity");
        if (this.context instanceof MMActivity) {
            intent.putExtra("need_result", true);
            try {
                g = this.umI.g(18, null);
                if (g != null) {
                    str4 = v.nW(bo.nullAsNil(g.getString("KPublisherId")));
                    com.tencent.mm.model.v.b y = v.Zp().y(str4, true);
                    y.j("sendAppMsgScene", Integer.valueOf(2));
                    y.j("preChatName", g.getString("preChatName"));
                    y.j("preMsgIndex", Integer.valueOf(g.getInt("preMsgIndex")));
                    y.j("prePublishId", g.getString("prePublishId"));
                    y.j("preUsername", g.getString("preUsername"));
                    y.j("url", aek);
                    y.j("getA8KeyScene", Integer.valueOf(g.getInt("getA8KeyScene")));
                    y.j("referUrl", g.getString("referUrl"));
                    int i5 = g.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
                    if (i5 != -1) {
                        y.j("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(i5));
                        y.j("_tmpl_webview_transfer_scene", Integer.valueOf(10));
                    }
                    if (!bo.isNullOrNil(str3)) {
                        y.j("adExtStr", str3);
                    }
                    intent.putExtra("reportSessionId", str4);
                }
            } catch (RemoteException e32) {
                ab.e("MicroMsg.MsgHandler", "try to attach report args error, %s", e32);
            }
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.a(this.context, "sns", ".ui.SnsUploadUI", intent, 24, false);
        }
        AppMethodBeat.o(9248);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean o(i iVar) {
        Throwable e;
        AppMethodBeat.i(9249);
        String str = (String) iVar.puc.get("ad_info");
        String str2 = "";
        String Yz = r.Yz();
        try {
            Bundle g = this.umI.g(18, null);
            if (g != null) {
                String string = g.getString("prePublishId");
                String string2 = g.getString("preChatName");
                String string3 = g.getString("preUsername");
                int i = g.getInt("getA8KeyScene");
                int i2 = g.getInt("preChatTYPE", 0);
                String str3 = str2 + string + "," + string2 + "," + string3 + "," + i + ",";
                if (i2 == 0) {
                    i2 = u.ad(string3, string2);
                }
                if (string != null) {
                    try {
                        if (string.startsWith("msg_")) {
                            bi Q = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Q(string2, bo.anl(string.substring(4)));
                            str2 = str3 + Q.getType() + "," + n.mA(Q.field_talker) + "," + i2 + "," + aq.aEn() + ",";
                            str2 = (str2 + Yz) + "," + bo.gN(ah.getContext());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str2 = str3;
                    }
                }
                str2 = str3 + ",," + i2 + "," + aq.aEn() + ",";
                try {
                    str2 = (str2 + Yz) + "," + bo.gN(ah.getContext());
                } catch (Exception e3) {
                    e = e3;
                }
            }
            ab.v("MicroMsg.MsgHandler", "adDataReport adinfo:%s", str);
            ab.v("MicroMsg.MsgHandler", "adDataReport str:%s", str2);
            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.a.class)).i(13297, str + "," + str2, (int) bo.anT());
            if (bo.ank(bo.bc((String) iVar.puc.get("need_record_page_operation"), AppEventsConstants.EVENT_PARAM_VALUE_NO)) != 0) {
                Bundle bundle = new Bundle();
                bundle.putString("traceid", str);
                bundle.putString("username", Yz);
                try {
                    this.umI.g(90002, bundle);
                } catch (RemoteException e4) {
                    ab.e("MicroMsg.MsgHandler", "invokeAsResult ex: %s", e4.getMessage());
                }
            }
            a(iVar, "adDataReport：ok", null);
            AppMethodBeat.o(9249);
        } catch (RemoteException e42) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e42, "", new Object[0]);
            a(iVar, "adDataReport：fail", null);
            AppMethodBeat.o(9249);
        }
        return true;
        ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        ab.v("MicroMsg.MsgHandler", "adDataReport adinfo:%s", str);
        ab.v("MicroMsg.MsgHandler", "adDataReport str:%s", str2);
        ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.a.class)).i(13297, str + "," + str2, (int) bo.anT());
        if (bo.ank(bo.bc((String) iVar.puc.get("need_record_page_operation"), AppEventsConstants.EVENT_PARAM_VALUE_NO)) != 0) {
        }
        a(iVar, "adDataReport：ok", null);
        AppMethodBeat.o(9249);
        return true;
    }

    private boolean p(i iVar) {
        AppMethodBeat.i(9250);
        try {
            if (this.umI != null) {
                Bundle g = this.umI.g(87, null);
                if (g != null) {
                    if (bo.nullAsNil(g.getString("result")).equals("not_return")) {
                        a(iVar, "getWePkgAuthResult:fail_auth_result_not_return", null);
                    } else {
                        String string = g.getString("full_url");
                        int i = g.getInt("set_cookie");
                        if (bo.isNullOrNil(string)) {
                            a(iVar, "getWePkgAuthResult:fail_full_url_empty", null);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("full_url", string);
                            hashMap.put("set_cookie", Integer.valueOf(i));
                            a(iVar, "getWePkgAuthResult:ok", hashMap);
                        }
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doGetWePkgAuthResult exception, " + e.getMessage());
            a(iVar, "getWePkgAuthResult:fail", null);
        }
        AppMethodBeat.o(9250);
        return true;
    }

    private boolean q(i iVar) {
        AppMethodBeat.i(9251);
        String str = (String) iVar.puc.get("reportId");
        boolean equals = bo.nullAsNil((String) iVar.puc.get("reportInstantly")).equals("1");
        boolean equals2 = bo.nullAsNil((String) iVar.puc.get("reportTimeBegin")).equals("1");
        String str2 = (String) iVar.puc.get("reportFormatData");
        String str3 = (String) iVar.puc.get("reportTabsFormatData");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "reportId is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportId", null);
            AppMethodBeat.o(9251);
        } else if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.MsgHandler", "reportFormatData && reportTabsFormatData is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportFormatData_reportTabsFormatData", null);
            AppMethodBeat.o(9251);
        } else {
            ab.i("MicroMsg.MsgHandler", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", str, Boolean.valueOf(equals), Boolean.valueOf(equals2), str2, str3);
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", str);
            bundle.putBoolean("game_page_report_instantly", equals);
            bundle.putBoolean("game_page_report_time_begin", equals2);
            bundle.putString("game_page_report_format_data", str2);
            bundle.putString("game_page_report_tabs_format_data", str3);
            try {
                this.umI.g(95, bundle);
                a(iVar, "reportGamePageTime:ok", null);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "reportGamePageTime, exception = %s", e);
                a(iVar, "reportGamePageTime:fail", null);
            }
            AppMethodBeat.o(9251);
        }
        return true;
    }

    private static String agz(String str) {
        AppMethodBeat.i(9252);
        if (str.startsWith("http://")) {
            str = str.substring(7);
            AppMethodBeat.o(9252);
            return str;
        } else if (str.startsWith("https://")) {
            str = str.substring(8);
            AppMethodBeat.o(9252);
            return str;
        } else {
            AppMethodBeat.o(9252);
            return str;
        }
    }

    private boolean r(final i iVar) {
        AppMethodBeat.i(9253);
        String str = (String) iVar.puc.get("webtype");
        String str2 = (String) iVar.puc.get("username");
        String str3 = (String) iVar.puc.get("scene");
        String str4 = (String) iVar.puc.get("profileReportInfo");
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            ab.e("MicroMsg.MsgHandler", "doAddContact fail, invalid arguments, webType = " + str + ", username = " + str2);
            a(iVar, "add_contact:fail", null);
            AppMethodBeat.o(9253);
            return true;
        }
        agv(str3);
        int i = bo.getInt(str, -1);
        if (i == -1) {
            ab.e("MicroMsg.MsgHandler", "doAddContact fail, parseInt fail, str = ".concat(String.valueOf(str)));
            a(iVar, "add_contact:fail", null);
            AppMethodBeat.o(9253);
            return true;
        } else if (this.context instanceof Activity) {
            l.a(iVar.uII, false, str2, null);
            switch (i) {
                case 1:
                    int i2;
                    if (this.uGh == null) {
                        i2 = 33;
                    } else {
                        i2 = this.uGh.getInt("Contact_Scene", 33);
                    }
                    ((com.tencent.mm.pluginsdk.g) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.g.class)).a(this.context, str2, i2, new com.tencent.mm.pluginsdk.ui.applet.n() {
                        public final void nZ(int i) {
                            AppMethodBeat.i(9097);
                            switch (i) {
                                case -2:
                                    g.a(g.this, iVar, "add_contact:added", null);
                                    AppMethodBeat.o(9097);
                                    return;
                                case -1:
                                    g.a(g.this, iVar, "add_contact:fail", null);
                                    AppMethodBeat.o(9097);
                                    return;
                                case 0:
                                    g.a(g.this, iVar, "add_contact:cancel", null);
                                    AppMethodBeat.o(9097);
                                    return;
                                case 1:
                                    g.a(g.this, iVar, "add_contact:ok", null);
                                    AppMethodBeat.o(9097);
                                    return;
                                default:
                                    g.a(g.this, iVar, "add_contact:fail", null);
                                    AppMethodBeat.o(9097);
                                    return;
                            }
                        }
                    }, str4).show();
                    AppMethodBeat.o(9253);
                    return true;
                default:
                    ab.e("MicroMsg.MsgHandler", "unknown addScene = ".concat(String.valueOf(i)));
                    a(iVar, "add_contact:fail", null);
                    AppMethodBeat.o(9253);
                    return true;
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "doAddContact invalid context");
            a(iVar, "add_contact:fail", null);
            AppMethodBeat.o(9253);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean s(i iVar) {
        String str;
        boolean z;
        Exception e;
        Bundle bundle;
        AppMethodBeat.i(9254);
        String str2 = (String) iVar.puc.get("current");
        String[] strArr = (String[]) iVar.puc.get("urls");
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length == 0) {
            ab.e("MicroMsg.MsgHandler", "doImgPreview fail, urls is null");
            this.eBB = false;
            AppMethodBeat.o(9254);
            return false;
        }
        String str3;
        String string;
        ab.d("MicroMsg.MsgHandler", "doImgPreview ok");
        int i = 0;
        while (i < strArr.length) {
            if (bo.isNullOrNil(strArr[i]) || strArr[i].equalsIgnoreCase(BuildConfig.COMMAND)) {
                ab.e("MicroMsg.MsgHandler", "null url, i = %d", Integer.valueOf(i));
            } else {
                if (bo.nullAsNil(strArr[i]).startsWith("weixin://resourceid/")) {
                    strArr[i] = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(strArr[i]).heo;
                }
                arrayList.add(strArr[i]);
            }
            i++;
        }
        strArr = (String[]) arrayList.toArray(strArr);
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (bo.isNullOrNil(str2)) {
            str3 = strArr[0];
        } else if (str2.startsWith("weixin://resourceid/")) {
            str3 = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2).heo;
        } else {
            str3 = str2;
        }
        Intent intent = new Intent();
        if (iVar.puc.containsKey("key_wxapp_id")) {
            str2 = (String) iVar.puc.get("key_wxapp_id");
            if (!bo.isNullOrNil(str2)) {
                intent.putExtra("scanCodeTypes", new int[]{3});
                intent.putExtra("scanResultCodeTypes", new int[]{22});
            }
            str = str2;
        } else {
            str = null;
        }
        boolean z2 = true;
        str2 = "";
        try {
            Bundle g = this.umI.g(90001, new Bundle());
            float f = -1.0f;
            if (g != null) {
                string = g.getString("cookie", null);
                if (!bo.isNullOrNil(string)) {
                    intent.putExtra("cookie", string);
                }
                f = g.getFloat(Constants.PARAM_DENSITY, -1.0f);
            }
            g = this.umI.g(18, null);
            if (g != null) {
                string = g.getString("preChatName");
                String string2 = g.getString("preUsername");
                String string3 = g.getString("rawUrl");
                str2 = g.getString("url");
                int i2 = g.getInt("getA8KeyScene");
                String nW = v.nW("ImgPreview");
                com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                y.j("preUsername", string);
                y.j("preChatName", string2);
                y.j("url", str2);
                y.j("rawUrl", string3);
                if (i2 == 53 || i2 == 52) {
                    ab.i("MicroMsg.MsgHandler", "not allow to ScanQRCode");
                    z2 = false;
                }
                intent.putExtra("img_gallery_session_id", nW);
            }
            String str4 = str2;
            try {
                JSONObject jSONObject;
                str2 = (String) iVar.puc.get("currentInfo");
                if (bo.isNullOrNil(str2)) {
                    jSONObject = null;
                    string = str3;
                } else {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    string = com.tencent.mm.plugin.webview.modeltools.j.a(str3, strArr2, jSONObject2);
                    jSONObject = jSONObject2;
                }
                try {
                    if (com.tencent.mm.plugin.webview.modeltools.j.cYM() && jSONObject != null) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("pos");
                        if (optJSONObject != null) {
                            float density;
                            Bundle g2 = this.umI.g(107, new Bundle());
                            boolean z3 = g2 != null ? g2.getBoolean("isFullScreen", false) : false;
                            int de = com.tencent.mm.ui.ak.de(this.context);
                            int statusBarHeight = com.tencent.mm.ui.ak.getStatusBarHeight(this.context);
                            if (f <= 0.0f) {
                                density = com.tencent.mm.bz.a.getDensity(this.context);
                            } else {
                                density = f;
                            }
                            int optDouble = (int) (optJSONObject.optDouble("width") * ((double) density));
                            int optDouble2 = (int) (optJSONObject.optDouble("height") * ((double) density));
                            intent.putExtra("img_gallery_width", optDouble).putExtra("img_gallery_height", optDouble2).putExtra("img_gallery_left", (int) (optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_X) * ((double) density))).putExtra("img_gallery_top", (int) (((double) (z3 ? 0 : de + statusBarHeight)) + (optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_Y) * ((double) density))));
                            ab.d("MicroMsg.MsgHandler", "doPreviewImg left %d, top %d, w %d, h %d, density %f,screenHeight %d", Integer.valueOf(r16), Integer.valueOf(r2), Integer.valueOf(optDouble), Integer.valueOf(optDouble2), Float.valueOf(density), Integer.valueOf(com.tencent.mm.bz.a.ge(this.context)));
                            if (optDouble > 0 && optDouble2 > 0 && optDouble2 < r10) {
                                intent.putExtra("shouldRunDragAnimation", true);
                            }
                        }
                    }
                    str2 = str4;
                    z = z2;
                } catch (Exception e2) {
                    e = e2;
                    str2 = str4;
                    ab.e("MicroMsg.MsgHandler", "doImgPreview fail : %s", e.getMessage());
                    z = z2;
                    intent.putExtra("nowUrl", string);
                    intent.putExtra("urlList", strArr2);
                    intent.putExtra("type", -255);
                    intent.putExtra("isFromWebView", true);
                    intent.putExtra("shouldShowScanQrCodeMenu", z);
                    if (this.context instanceof Service) {
                    }
                    bundle = new Bundle();
                    bundle.putInt("stat_scene", 4);
                    bundle.putString("stat_url", str2);
                    if (!bo.isNullOrNil(str)) {
                    }
                    intent.putExtra("_stat_obj", bundle);
                    com.tencent.mm.plugin.webview.a.a.gkE.q(intent, this.context);
                    this.eBB = false;
                    AppMethodBeat.o(9254);
                    return false;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = str4;
                string = str3;
                ab.e("MicroMsg.MsgHandler", "doImgPreview fail : %s", e.getMessage());
                z = z2;
                intent.putExtra("nowUrl", string);
                intent.putExtra("urlList", strArr2);
                intent.putExtra("type", -255);
                intent.putExtra("isFromWebView", true);
                intent.putExtra("shouldShowScanQrCodeMenu", z);
                if (this.context instanceof Service) {
                }
                bundle = new Bundle();
                bundle.putInt("stat_scene", 4);
                bundle.putString("stat_url", str2);
                if (bo.isNullOrNil(str)) {
                }
                intent.putExtra("_stat_obj", bundle);
                com.tencent.mm.plugin.webview.a.a.gkE.q(intent, this.context);
                this.eBB = false;
                AppMethodBeat.o(9254);
                return false;
            }
        } catch (Exception e4) {
            e = e4;
            string = str3;
            ab.e("MicroMsg.MsgHandler", "doImgPreview fail : %s", e.getMessage());
            z = z2;
            intent.putExtra("nowUrl", string);
            intent.putExtra("urlList", strArr2);
            intent.putExtra("type", -255);
            intent.putExtra("isFromWebView", true);
            intent.putExtra("shouldShowScanQrCodeMenu", z);
            if (this.context instanceof Service) {
            }
            bundle = new Bundle();
            bundle.putInt("stat_scene", 4);
            bundle.putString("stat_url", str2);
            if (bo.isNullOrNil(str)) {
            }
            intent.putExtra("_stat_obj", bundle);
            com.tencent.mm.plugin.webview.a.a.gkE.q(intent, this.context);
            this.eBB = false;
            AppMethodBeat.o(9254);
            return false;
        }
        intent.putExtra("nowUrl", string);
        intent.putExtra("urlList", strArr2);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        intent.putExtra("shouldShowScanQrCodeMenu", z);
        if (this.context instanceof Service) {
            intent.addFlags(268435456);
        }
        bundle = new Bundle();
        bundle.putInt("stat_scene", 4);
        bundle.putString("stat_url", str2);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.MsgHandler", "[banjump] doImgPreview, wxappId:%s", str);
            bundle.putString("stat_app_id", str);
        }
        intent.putExtra("_stat_obj", bundle);
        com.tencent.mm.plugin.webview.a.a.gkE.q(intent, this.context);
        this.eBB = false;
        AppMethodBeat.o(9254);
        return false;
    }

    private boolean t(i iVar) {
        AppMethodBeat.i(9255);
        try {
            Bundle aP = i.aP(iVar.puc);
            this.umI.cZb();
            this.umI.W(aP);
            String str = "";
            if (this.uGh != null) {
                this.uGh.setClassLoader(getClass().getClassLoader());
                str = this.uGh.getString("KoriginUrl");
                this.uGh.getBoolean("KIsHKAgreeUrl");
            }
            vo voVar = new vo();
            voVar.cSB.clP = str;
            com.tencent.mm.sdk.b.a.xxA.m(voVar);
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
        }
        a(iVar, "close_window:ok", null);
        AppMethodBeat.o(9255);
        return true;
    }

    private void a(i iVar, int i, int i2) {
        AppMethodBeat.i(9256);
        String str = iVar.uIJ;
        if (str.equals("requireSoterBiometricAuthentication") || str.equals("getSupportSoter")) {
            String bK = bK(getCurrentUrl());
            com.tencent.mm.plugin.soter.d.l lVar = com.tencent.mm.plugin.soter.d.l.rOl;
            com.tencent.mm.plugin.soter.d.l.l(str, bK, i, i2);
        }
        AppMethodBeat.o(9256);
    }

    private boolean u(i iVar) {
        AppMethodBeat.i(9257);
        this.eBB = false;
        int ank = bo.ank(iVar.puc.get("voteResultIndex").toString());
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sns_landing_pages_ad_vote_index", ank);
            this.umI.c(150, bundle);
        } catch (Exception e) {
        }
        AppMethodBeat.o(9257);
        return false;
    }

    private boolean v(i iVar) {
        AppMethodBeat.i(9258);
        String str = (String) iVar.puc.get(DownloadInfoColumns.PACKAGENAME);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.MsgHandler", "packageName is null or nil");
            a(iVar, "get_install_state:no", null);
            AppMethodBeat.o(9258);
            return true;
        }
        l.a(iVar.uII, false, str, null);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(this.context, string);
                    int i2 = packageInfo == null ? 0 : packageInfo.versionCode;
                    String str2 = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                    ab.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + string + ", packageInfo = " + packageInfo + ", version = " + i2 + ", versionName = " + str2);
                    if (obj == null && i2 > 0) {
                        obj = 1;
                    }
                    jSONObject.put(string, i2);
                    jSONObject2.put(string, str2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                hashMap.put("versionName", jSONObject2);
                if (obj != null) {
                    a(iVar, "get_install_state:yes", hashMap);
                } else {
                    a(iVar, "get_install_state:no", null);
                }
                AppMethodBeat.o(9258);
                return true;
            }
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "it is not batch get install state");
        }
        PackageInfo packageInfo2 = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(this.context, str);
        int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
        String str3 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
        ab.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + str + ", packageInfo = " + packageInfo2 + ", version = " + i3 + ", versionName = " + str3);
        if (packageInfo2 == null) {
            a(iVar, "get_install_state:no", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("versionName", str3);
            a(iVar, "get_install_state:yes_".concat(String.valueOf(i3)), hashMap2);
        }
        AppMethodBeat.o(9258);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean w(i iVar) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(9259);
        String str = (String) iVar.puc.get("desc");
        int i4 = bo.getInt((String) iVar.puc.get("needResult"), 1);
        String str2 = (String) iVar.puc.get("scanType");
        ab.i("MicroMsg.MsgHandler", "desc : %s, scene : %d, scanType : %s", str, Integer.valueOf(i4), str2);
        if (bo.isNullOrNil(str2)) {
            i = 1;
            i2 = 1;
        } else {
            i = 0;
            i2 = 0;
        }
        int i5;
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                i5 = i;
                while (i3 < jSONArray.length()) {
                    try {
                        str = (String) jSONArray.get(i3);
                        if (str.equalsIgnoreCase("qrCode")) {
                            i = i5;
                            i2 = 1;
                        } else if (str.equalsIgnoreCase("barCode")) {
                            i = 1;
                        } else {
                            i = i5;
                        }
                        i3++;
                        i5 = i;
                    } catch (Exception e) {
                        ab.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                        if (i2 == 0) {
                        }
                        if (i2 == 0) {
                        }
                        i = 1;
                        if (i4 == 0) {
                        }
                        AppMethodBeat.o(9259);
                        return true;
                    }
                }
            } catch (Exception e2) {
                i5 = i;
                ab.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                if (i2 == 0) {
                }
                if (i2 == 0) {
                }
                i = 1;
                if (i4 == 0) {
                }
                AppMethodBeat.o(9259);
                return true;
            }
        }
        i5 = i;
        if (i2 == 0 && r1 == 0) {
            i = 8;
        } else if (i2 == 0 || r1 == 0) {
            i = 1;
        } else {
            i = 4;
        }
        Intent intent;
        if (i4 == 0) {
            ab.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            if (!(com.tencent.mm.r.a.bI(this.context) || com.tencent.mm.bg.e.akI())) {
                com.tencent.mm.bp.d.c(this.context, "scanner", ".ui.SingleTopScanUI", intent);
            }
            a(iVar, "scanQRCode:ok", null);
        } else if (i4 == 1) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("key_is_finish_on_scanned", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            if (!(com.tencent.mm.r.a.bI(this.context) || com.tencent.mm.bg.e.akI())) {
                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.cIv);
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "unkown scene");
            a(iVar, "scanQRCode:fail_invalid_scene", null);
        }
        AppMethodBeat.o(9259);
        return true;
    }

    private boolean x(i iVar) {
        AppMethodBeat.i(9260);
        String str = (String) iVar.puc.get("fontSize");
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize is null");
            this.eBB = false;
            AppMethodBeat.o(9260);
        } else {
            ab.i("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(str)));
            try {
                this.umI.afd(str);
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "setFontSizeCb, ex = " + e.getMessage());
            }
            this.eBB = false;
            AppMethodBeat.o(9260);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean y(final i iVar) {
        int cZa;
        Exception e;
        AppMethodBeat.i(9261);
        ab.i("MicroMsg.MsgHandler", "start secureTunnel");
        String currentUrl = getCurrentUrl();
        String bK = bK(currentUrl);
        try {
            cZa = this.umI.cZa();
            try {
                ab.e("MicroMsg.MsgHandler", "securetunnel getA8keyscene: " + this.umI.cZa());
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", e);
                if (bo.isNullOrNil((String) iVar.puc.get("type"))) {
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            cZa = 0;
        }
        if (bo.isNullOrNil((String) iVar.puc.get("type"))) {
            ab.e("MicroMsg.MsgHandler", "securetunnel type nil");
            a(iVar, "secureTunnel:fail", null);
            this.eBB = false;
            AppMethodBeat.o(9261);
        } else if (bo.isNullOrNil((String) iVar.puc.get("reqbuf"))) {
            ab.e("MicroMsg.MsgHandler", "securetunnel reqbuf nil");
            a(iVar, "secureTunnel:fail", null);
            this.eBB = false;
            AppMethodBeat.o(9261);
        } else if (bo.isNullOrNil((String) iVar.puc.get("cmd"))) {
            ab.e("MicroMsg.MsgHandler", "securetunnel cmd nil");
            a(iVar, "secureTunnel:fail", null);
            this.eBB = false;
            AppMethodBeat.o(9261);
        } else {
            if (iVar.puc.containsKey("timeout")) {
                int ank = bo.ank((String) iVar.puc.get("timeout"));
                if (ank != 0) {
                    iVar.puc.put("timeout", Integer.valueOf(ank));
                }
            }
            AnonymousClass46 anonymousClass46 = new com.tencent.mm.pluginsdk.wallet.b.a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(9101);
                    ab.i("MicroMsg.MsgHandler", "secureTunnel callback success");
                    Map hashMap = new HashMap();
                    hashMap.put("respbuf", str);
                    g.a(g.this, iVar, "secureTunnel:ok", hashMap);
                    AppMethodBeat.o(9101);
                }

                public final void BD(String str) {
                    AppMethodBeat.i(9102);
                    ab.i("MicroMsg.MsgHandler", "secureTunnel callback fail");
                    Map hashMap = new HashMap();
                    hashMap.put("err_desc", str);
                    g.a(g.this, iVar, "secureTunnel:fail", hashMap);
                    AppMethodBeat.o(9102);
                }
            };
            if (((String) iVar.puc.get("type")).equals("wxpay")) {
                ab.i("MicroMsg.MsgHandler", "secureTunnel doscene");
                ((com.tencent.mm.pluginsdk.wallet.b) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.wallet.b.class)).a(iVar.puc, currentUrl, bK, cZa, anonymousClass46);
                this.eBB = false;
                AppMethodBeat.o(9261);
            } else {
                ab.i("MicroMsg.MsgHandler", "secureTunnel callback fail: invalid type");
                Map hashMap = new HashMap();
                hashMap.put("err_desc", "invalid type");
                a(iVar, "secureTunnel:fail", hashMap);
                this.eBB = false;
                AppMethodBeat.o(9261);
            }
        }
        return true;
    }

    private boolean z(i iVar) {
        AppMethodBeat.i(9262);
        ab.d("MicroMsg.MsgHandler", "hy: doGetPayResultReq");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            mg mgVar = new mg();
            mgVar.cIc.appId = gVar.appId;
            mgVar.cIc.partnerId = gVar.partnerId;
            mgVar.cIc.signType = gVar.signType;
            mgVar.cIc.nonceStr = gVar.nonceStr;
            mgVar.cIc.timeStamp = gVar.timeStamp;
            mgVar.cIc.packageExt = gVar.packageExt;
            mgVar.cIc.cId = gVar.cId;
            mgVar.cIc.url = gVar.url;
            mgVar.cIc.cIe = gVar.cIe;
            mgVar.cIc.cIf = gVar.cIf;
            mgVar.cIc.cvS = gVar.cvS;
            mgVar.cIc.cIg = gVar.cIg;
            com.tencent.mm.sdk.b.a.xxA.m(mgVar);
            c(21, -1, null);
        }
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        AppMethodBeat.o(9262);
        return true;
    }

    private boolean A(i iVar) {
        AppMethodBeat.i(9263);
        ab.i("MicroMsg.MsgHandler", "doOpenProductView");
        String str = (String) iVar.puc.get("productInfo");
        String str2 = (String) iVar.puc.get("url");
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(new JSONObject(str).getInt("product_type"));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_info", str);
        intent.putExtra("key_source_url", str2);
        boolean a = a(valueOf, 3, 0, null, intent);
        AppMethodBeat.o(9263);
        return a;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Integer num, int i, int i2, String str, Intent intent) {
        AppMethodBeat.i(9264);
        intent.putExtra("key_product_scene", i);
        ab.e("MicroMsg.MsgHandler", "doOpenProductView, productType = %d", num);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).ifE = this;
            switch (num.intValue()) {
                case 0:
                    switch (i2) {
                        case 0:
                            com.tencent.mm.bp.d.b(this.context, "product", ".ui.MallProductUI", intent);
                            a(this.uGd, "open_product_view:ok", null);
                            break;
                        case 1:
                            intent.putExtra("key_Qrcode_Url", str);
                            intent.putExtra("key_ProductUI_getProductInfoScene", 4);
                            com.tencent.mm.bp.d.b(this.context, "scanner", ".ui.ProductUI", intent, 10);
                            break;
                        default:
                            ab.e("MicroMsg.MsgHandler", "doOpenProductView fail, productType = %d, viewType = %d", num, Integer.valueOf(i2));
                    }
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                case com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT /*20000*/:
                    com.tencent.mm.bp.d.b(this.context, "card", ".ui.CardProductUI", intent);
                    a(this.uGd, "open_product_view:ok", null);
                    break;
                default:
                    ab.e("MicroMsg.MsgHandler", "doOpenProductView fail, productType = %d", num);
                    if (i != 8) {
                        a(this.uGd, "open_product_view:fail", null);
                        break;
                    }
                    a(this.uGd, "open_product_view_with_id:fail", null);
                    break;
            }
        }
        a(this.uGd, "open_product_view:fail", null);
        AppMethodBeat.o(9264);
        return true;
    }

    private boolean a(final i iVar, int... iArr) {
        AppMethodBeat.i(9265);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT < 18) {
            a(iVar, "startMonitoringBeacons:system unsupported", null);
            AppMethodBeat.o(9265);
        } else {
            if (!(defaultAdapter == null || defaultAdapter.getState() == 12)) {
                if (defaultAdapter.getState() == 10) {
                    a(iVar, "startMonitoringBeacons:bluetooth power off", null);
                } else {
                    a(iVar, "startMonitoringBeacons:bluetooth state unknown", null);
                }
            }
            if (iArr == null || iArr.length == 0) {
                boolean isProviderEnabled = ((LocationManager) ah.getContext().getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps");
                boolean o = com.tencent.mm.pluginsdk.permission.b.o(ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
                ab.i("MicroMsg.MsgHandler", "startMonitoringBeacons isGPSEnable:%b, hasGPSPerm:%b", Boolean.valueOf(isProviderEnabled), Boolean.valueOf(o));
                if (!isProviderEnabled) {
                    a(iVar, "startMonitoringBeacons:location service disable", null);
                    ab.e("MicroMsg.MsgHandler", "startMonitoringBeacons:location service disable");
                }
                SensorManager sensorManager = (SensorManager) ah.getContext().getSystemService("sensor");
                sensorManager.registerListener(this.uGJ, sensorManager.getDefaultSensor(3), 0);
            }
            if (this.uGI) {
                a(iVar, "startMonitoringBeacons:already started", null);
            } else {
                this.uGI = true;
                a(iVar, "startMonitoringBeacons:ok", null);
            }
            if (!(iVar == null || iVar.puc == null)) {
                Object obj = iVar.puc.get("uuid");
                Object obj2 = iVar.puc.get("url");
                Object obj3 = iVar.puc.get("ticket");
                String obj4 = obj2 != null ? obj2.toString() : "";
                String obj5 = obj != null ? obj.toString() : "";
                h.pYm.e(12101, String.valueOf(bo.nullAsNil(this.uGr.agj(obj4))), String.valueOf(obj4), this.uGG, this.uGH, String.valueOf(obj3 != null ? obj3.toString() : ""));
                new StringBuilder("{\"UUID\":\"").append(obj5).append("\",\"Major\":0,\"Minor\":0}");
                final m aeVar = new com.tencent.mm.plugin.webview.model.ae(obj4, r4, obj);
                com.tencent.mm.kernel.g.Rg().a(1702, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(9113);
                        if (i == 0 && i2 == 0) {
                            cmr cmr = (cmr) aeVar.fAT.fsH.fsP;
                            if (cmr.luT == 0) {
                                LinkedList<String> linkedList = cmr.xks;
                                if (linkedList == null || linkedList.isEmpty()) {
                                    g.a(g.this, iVar, "startMonitoringBeacons:no uuids", null);
                                } else {
                                    for (String a : linkedList) {
                                        g.a(g.this, a);
                                    }
                                }
                            } else {
                                g.a(g.this, iVar, "startMonitoringBeacons:system error", null);
                                ab.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", cmr.luU);
                            }
                            com.tencent.mm.kernel.g.Rg().b(1702, (f) this);
                        }
                        AppMethodBeat.o(9113);
                    }
                });
                com.tencent.mm.kernel.g.Rg().a(aeVar, 0);
            }
            AppMethodBeat.o(9265);
        }
        return true;
    }

    private boolean agA(String str) {
        AppMethodBeat.i(9266);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT >= 18 && defaultAdapter != null) {
            com.tencent.mm.sdk.b.a.xxA.c(this.qwg);
            String nullAsNil = bo.nullAsNil(str);
            this.uGA.put(nullAsNil, nullAsNil);
            ab.i("MicroMsg.MsgHandler", "[MsgHandler][doStartIBeaconRange]op=true,iBeacon = %s", nullAsNil);
            Editor edit = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", true);
            edit.commit();
            if (com.tencent.mm.kernel.g.RK()) {
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.TRUE);
            }
            ds dsVar = new ds();
            dsVar.cxg.cxi = nullAsNil;
            dsVar.cxg.cxf = true;
            com.tencent.mm.sdk.b.a.xxA.m(dsVar);
        }
        AppMethodBeat.o(9266);
        return true;
    }

    public final boolean b(i iVar, int... iArr) {
        AppMethodBeat.i(9267);
        if (VERSION.SDK_INT >= 18) {
            boolean a;
            com.tencent.mm.sdk.b.a.xxA.d(this.qwg);
            if (com.tencent.mm.kernel.g.RK()) {
                a = bo.a((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false);
            } else {
                a = false;
            }
            for (String str : this.uGA.keySet()) {
                ds dsVar = new ds();
                ab.i("MicroMsg.MsgHandler", "[MsgHandler][doStopIBeaconRange]op=false,iBeacon = %s", str);
                dsVar.cxg.cxi = str;
                dsVar.cxg.cxf = false;
                if (!a) {
                    com.tencent.mm.sdk.b.a.xxA.m(dsVar);
                }
            }
            if (com.tencent.mm.kernel.g.RK()) {
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.FALSE);
            }
            Editor edit = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            this.uGA.clear();
            this.ecv.clear();
            this.uGB.clear();
            this.uGC.clear();
            this.uGI = false;
            if (iArr == null || iArr.length == 0) {
                a(iVar, "stopMonitoringBeacons:ok", null);
                this.uGI = false;
            }
        }
        if (this.uGJ != null) {
            ((SensorManager) ah.getContext().getSystemService("sensor")).unregisterListener(this.uGJ);
        }
        AppMethodBeat.o(9267);
        return true;
    }

    private boolean dcy() {
        String currentUrl;
        AppMethodBeat.i(9268);
        ab.i("MicroMsg.MsgHandler", "doGetLatestAddress JSOAUTH");
        String str = "";
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = str;
        }
        final String str2 = "get_recently_used_address:";
        if (currentUrl == null) {
            a(this.uGd, str2 + "fail", null);
        } else {
            final com.tencent.mm.sdk.b.b ndVar = new nd();
            ndVar.cJl.appId = (String) this.uGd.puc.get("appId");
            ndVar.cJl.url = currentUrl;
            ndVar.cJm.errCode = -119;
            ndVar.callback = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9069);
                    ab.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", Integer.valueOf(ndVar.cJm.errCode), Boolean.valueOf(ndVar.cJm.cJn));
                    if (ndVar.cJm.errCode == -119) {
                        AppMethodBeat.o(9069);
                    } else if (ndVar.cJm.errCode != 0) {
                        g.a(g.this, g.this.uGd, str2 + "fail", null);
                        AppMethodBeat.o(9069);
                    } else if (ndVar.cJm.cJn) {
                        Map hashMap = new HashMap();
                        hashMap.put("nationalCode", ndVar.cJm.cJo);
                        hashMap.put("userName", ndVar.cJm.userName);
                        hashMap.put("telNumber", ndVar.cJm.cJp);
                        hashMap.put("addressPostalCode", ndVar.cJm.cJq);
                        hashMap.put("proviceFirstStageName", ndVar.cJm.cJr);
                        hashMap.put("addressCitySecondStageName", ndVar.cJm.cJs);
                        hashMap.put("addressCountiesThirdStageName", ndVar.cJm.cJt);
                        hashMap.put("addressDetailInfo", ndVar.cJm.cJu);
                        g.a(g.this, g.this.uGd, str2 + "ok", hashMap);
                        AppMethodBeat.o(9069);
                    } else {
                        g.a(g.this, g.this.uGd, str2 + "cancel", null);
                        AppMethodBeat.o(9069);
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xxA.a(ndVar, Looper.getMainLooper());
        }
        AppMethodBeat.o(9268);
        return true;
    }

    private boolean C(i iVar) {
        int i;
        AppMethodBeat.i(9270);
        h.pYm.a(157, 27, 1, false);
        String str = (String) iVar.puc.get("task_name");
        String str2 = (String) iVar.puc.get("task_url");
        String str3 = (String) iVar.puc.get("alternative_url");
        long j = bo.getLong((String) iVar.puc.get("task_size"), 0);
        String str4 = (String) iVar.puc.get("file_md5");
        String str5 = (String) iVar.puc.get(IssueStorage.COLUMN_EXT_INFO);
        String str6 = (String) iVar.puc.get("fileType");
        String str7 = (String) iVar.puc.get("appid");
        String str8 = (String) iVar.puc.get("package_name");
        int i2 = bo.getInt((String) iVar.puc.get("scene"), 1000);
        ab.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6 + ", reportScene = " + i2);
        if (this.uGh != null) {
            i = this.uGh.getInt("key_download_restrict", 0);
            if (!bo.isNullOrNil(this.uGh.getString("key_function_id", ""))) {
                h.pYm.e(14596, r14, Integer.valueOf(i), Integer.valueOf(0));
            }
            if (i == 1) {
                ab.e("MicroMsg.MsgHandler", "not allow to download file");
                a(iVar, "add_download_task_straight:fail", null);
                AppMethodBeat.o(9270);
                return true;
            }
        }
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, url is null");
            a(iVar, "add_download_task_straight:fail_invalid_url", null);
            u(str7, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, str5);
            AppMethodBeat.o(9270);
            return true;
        }
        long b;
        if (bo.nullAsNil(str7).startsWith("wx")) {
            i = bo.getInt((String) iVar.puc.get("downloader_type"), 1);
        } else {
            i = bo.getInt((String) iVar.puc.get("downloader_type"), 0);
        }
        gw gwVar = new gw();
        gwVar.cBC.url = str2;
        gwVar.cBC.cvZ = str4;
        gwVar.cBC.extInfo = str5;
        gwVar.cBC.appId = str7;
        gwVar.cBC.scene = i2;
        com.tencent.mm.sdk.b.a.xxA.m(gwVar);
        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar.It(str2);
        aVar.Iu(str3);
        aVar.hA(j);
        aVar.Iv(str);
        aVar.Iw(str4);
        aVar.setAppId(str7);
        aVar.cY(str8);
        aVar.ga(true);
        aVar.tN(bo.getInt(str6, 1));
        aVar.setScene(i2);
        aVar.Ix(str5);
        com.tencent.mm.plugin.downloader.model.e eVar = aVar.kNl;
        if (i == 1) {
            b = com.tencent.mm.plugin.downloader.model.d.bij().b(eVar);
        } else {
            b = com.tencent.mm.plugin.downloader.model.d.bij().a(eVar);
        }
        ab.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(b)));
        com.tencent.mm.modelstat.d.b(10, "MsgHandler_doAddDownloadTaskStraight", hashCode());
        if (b <= 0) {
            ab.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(b)));
            a(iVar, "add_download_task_straight:fail", null);
        } else {
            Map hashMap = new HashMap();
            hashMap.put("download_id", Long.valueOf(b));
            a(iVar, "add_download_task_straight:ok", hashMap);
        }
        AppMethodBeat.o(9270);
        return true;
    }

    private static void u(String str, int i, String str2) {
        AppMethodBeat.i(9271);
        hc hcVar = new hc();
        hcVar.cBN.appId = str;
        hcVar.cBN.opType = 2;
        hcVar.cBN.cBO = i;
        hcVar.cBN.cvq = str2;
        com.tencent.mm.sdk.b.a.xxA.m(hcVar);
        AppMethodBeat.o(9271);
    }

    private boolean D(i iVar) {
        AppMethodBeat.i(9272);
        long j = bo.getLong((String) iVar.puc.get("download_id"), -1);
        ab.i("MicroMsg.MsgHandler", "doResumeDownloadTask, downloadId = ".concat(String.valueOf(j)));
        if (j <= 0) {
            ab.e("MicroMsg.MsgHandler", "doResumeDownloadTask fail, invalid downloadId = ".concat(String.valueOf(j)));
            a(iVar, "resume_download_task:fail", null);
            AppMethodBeat.o(9272);
        } else {
            com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
            if (hv != null && hv.field_fromDownloadApp) {
                hv.field_fromDownloadApp = false;
                hv.field_showNotification = true;
                com.tencent.mm.plugin.downloader.model.c.e(hv);
                ((com.tencent.mm.plugin.downloader_app.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).kP(hv.field_appId);
            }
            boolean ho = com.tencent.mm.plugin.downloader.model.d.bij().ho(j);
            ab.i("MicroMsg.MsgHandler", "doResumeDownloadTask, ret = ".concat(String.valueOf(ho)));
            com.tencent.mm.modelstat.d.b(10, "MsgHandler_doResumeDownloadTask", hashCode());
            if (ho) {
                a(iVar, "resume_download_task:ok", null);
            } else {
                a(iVar, "resume_download_task:fail", null);
            }
            AppMethodBeat.o(9272);
        }
        return true;
    }

    private boolean a(String str, i iVar) {
        AppMethodBeat.i(9273);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj;
                    String string = jSONArray.getString(i);
                    FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(string);
                    JSONObject jSONObject2 = new JSONObject();
                    switch (Ir.status) {
                        case -1:
                            obj = "api_not_support";
                            break;
                        case 1:
                            obj = "downloading";
                            break;
                        case 2:
                            obj = "download_pause";
                            break;
                        case 3:
                            if (!com.tencent.mm.vfs.e.ct(Ir.path)) {
                                obj = "default";
                                break;
                            }
                            obj = "download_succ";
                            break;
                        case 4:
                            obj = "download_fail";
                            break;
                        default:
                            obj = "default";
                            break;
                    }
                    jSONObject2.put("download_id", Ir.id);
                    jSONObject2.put("state", obj);
                    if (Ir.kNu) {
                        jSONObject2.put("reserve_for_wifi", 1);
                    }
                    if (Ir.jrb != 0) {
                        float f = (((float) Ir.kNr) * 100.0f) / ((float) Ir.jrb);
                        jSONObject2.put("progress", (Ir.kNr * 100) / Ir.jrb);
                        jSONObject2.put("progress_float", (double) f);
                    }
                    jSONObject.put(string, jSONObject2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                a(iVar, "query_download_task:ok", hashMap);
            } else {
                a(iVar, "query_download_task:fail", null);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.MsgHandler", e.getMessage());
            a(iVar, "query_download_task:fail", null);
        }
        AppMethodBeat.o(9273);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean E(final i iVar) {
        String currentUrl;
        int i;
        AppMethodBeat.i(9274);
        if (this.uGh != null) {
            int i2 = this.uGh.getInt("key_download_restrict", 0);
            if (!bo.isNullOrNil(this.uGh.getString("key_function_id", ""))) {
                h.pYm.e(14596, r1, Integer.valueOf(i2), Integer.valueOf(1));
            }
            if (i2 == 1) {
                ab.e("MicroMsg.MsgHandler", "not allow tolaunch 3rd app");
                a(iVar, "launch_3rdApp:fail", null);
                AppMethodBeat.o(9274);
                return true;
            }
        }
        String str = (String) iVar.puc.get("type");
        String str2 = (String) iVar.puc.get("appID");
        ab.i("MicroMsg.MsgHandler", "lauchTimeInterval = %d", Long.valueOf(bo.anT() - this.uGx));
        String str3 = "";
        String str4 = "";
        if (bo.anT() - this.uGx < 2 && this.uGx > 0) {
            try {
                currentUrl = this.umI.getCurrentUrl();
                str4 = this.uGr.agj(currentUrl);
                str3 = URLEncoder.encode(currentUrl, "UTF-8");
                h.pYm.e(13983, Integer.valueOf(5), str3, "");
                currentUrl = str4;
            } catch (Exception e) {
                str3 = "";
                ab.e("MicroMsg.MsgHandler", "report lauch3rd failed");
            }
            l.a(iVar.uII, false, null, str2);
            if (!bo.isNullOrNil(str)) {
                try {
                    i = bo.getInt(str, 0);
                } catch (Exception e2) {
                    ab.e("MicroMsg.MsgHandler", "invalid type", e2.getMessage());
                }
                ab.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str);
                if (i == 0) {
                    str = (String) iVar.puc.get(IssueStorage.COLUMN_EXT_INFO);
                    ab.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", str2, str);
                    if (bo.isNullOrNil(str2)) {
                        ab.e("MicroMsg.MsgHandler", "appid is null or nil");
                        a(iVar, "launch_3rdApp:fail", null);
                        AppMethodBeat.o(9274);
                    } else if (com.tencent.mm.plugin.webview.a.a.gkF.u(ah.getContext(), str2)) {
                        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                        wXAppExtendObject.extInfo = str;
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                        wXMediaMessage.sdkVer = Build.SDK_INT;
                        wXMediaMessage.messageExt = str;
                        jc jcVar = new jc();
                        jcVar.cEj.cEl = wXMediaMessage;
                        jcVar.cEj.appId = str2;
                        jcVar.cEj.context = this.context;
                        jcVar.cEj.cEm = new aj() {
                            public final void dR(boolean z) {
                                AppMethodBeat.i(9128);
                                g.a(g.this, iVar, "launch_3rdApp:ok", null);
                                AppMethodBeat.o(9128);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.m(jcVar);
                        AppMethodBeat.o(9274);
                    } else {
                        ab.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", str2);
                        a(iVar, "launch_3rdApp:fail", null);
                        AppMethodBeat.o(9274);
                    }
                } else if (i == 1) {
                    str = (String) iVar.puc.get("signature");
                    str2 = (String) iVar.puc.get(DownloadInfoColumns.PACKAGENAME);
                    ab.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", str, str2, (String) iVar.puc.get("param"));
                    if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                        ab.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                        a(iVar, "launch_3rdApp:fail_invalid_args", null);
                        AppMethodBeat.o(9274);
                    } else if (p.u(this.context, str2)) {
                        Signature[] bx = p.bx(this.context, str2);
                        if (!(bx == null || bx[0] == null)) {
                            String x = com.tencent.mm.a.g.x(bx[0].toByteArray());
                            if (x != null && x.equalsIgnoreCase(str)) {
                                try {
                                    Intent launchIntentForPackage = ah.getContext().getPackageManager().getLaunchIntentForPackage(str2);
                                    if (launchIntentForPackage != null) {
                                        Bundle bundle = new Bundle();
                                        p.j(bundle, str4);
                                        launchIntentForPackage.putExtras(bundle);
                                        launchIntentForPackage.addFlags(268435456);
                                        bundle = new Bundle();
                                        bundle.putString("current_page_url", str3);
                                        bundle.putString("current_page_appid", currentUrl);
                                        com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage, null, new aj() {
                                            public final void dR(boolean z) {
                                                AppMethodBeat.i(9129);
                                                g.a(g.this, iVar, "launch_3rdApp:ok", null);
                                                AppMethodBeat.o(9129);
                                            }
                                        }, bundle);
                                        AppMethodBeat.o(9274);
                                    }
                                } catch (Exception e3) {
                                    ab.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", e3.getMessage());
                                }
                                a(iVar, "launch_3rdApp:fail", null);
                                AppMethodBeat.o(9274);
                            }
                        }
                        ab.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                        a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                        AppMethodBeat.o(9274);
                    } else {
                        ab.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                        a(iVar, "launch_3rdApp:fail_not_install", null);
                        AppMethodBeat.o(9274);
                    }
                } else {
                    a(iVar, "launch_3rdApp:fail_invalid_type", null);
                    AppMethodBeat.o(9274);
                }
                return true;
            }
            i = 0;
            ab.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str);
            if (i == 0) {
            }
            return true;
        }
        currentUrl = str4;
        l.a(iVar.uII, false, null, str2);
        if (bo.isNullOrNil(str)) {
        }
        i = 0;
        ab.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", str);
        if (i == 0) {
        }
        return true;
    }

    private boolean F(i iVar) {
        AppMethodBeat.i(9275);
        String str = (String) iVar.puc.get("url");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, url is null");
            a(iVar, "open_url_by_ext_browser:fail", null);
            AppMethodBeat.o(9275);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                this.context.startActivity(intent);
                a(iVar, "open_url_by_ext_browser:ok", null);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, e = " + e.getMessage());
                a(iVar, "open_url_by_ext_browser:fail", null);
            }
            AppMethodBeat.o(9275);
        }
        return true;
    }

    private void dcz() {
        AppMethodBeat.i(9276);
        String str = (String) this.uGd.puc.get("type");
        ab.v("MicroMsg.MsgHandler", "doGeoLocation, geoType = %s", str);
        if (!(bo.isNullOrNil(str) || uGK.contains(str))) {
            ab.e("MicroMsg.MsgHandler", "doGeoLocation fail, unsupported type = %s", str);
            a(this.uGd, "geo_location:fail_unsupported_type", null);
        }
        this.ecr = com.tencent.mm.modelgeo.d.agz();
        if (this.ecr == null) {
            ab.e("MicroMsg.MsgHandler", "doGeoLocation fail, iGetLocation is null");
            a(this.uGd, "geo_location:fail", null);
        }
        str = (String) this.uGd.puc.get("type");
        if (this.uGL == null) {
            this.uGL = new com.tencent.mm.modelgeo.b.b() {
                public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                    return false;
                }

                public final boolean a(boolean z, float f, float f2, int i, double d, double d2, Bundle bundle) {
                    AppMethodBeat.i(9131);
                    if (z) {
                        ab.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
                        if (g.this.ecr != null) {
                            g.this.ecr.c(g.this.uGL);
                        }
                        if (g.this.uGL == null) {
                            ab.w("MicroMsg.MsgHandler", "already callback");
                            AppMethodBeat.o(9131);
                            return false;
                        }
                        g.this.uGL = null;
                        Map hashMap = new HashMap();
                        hashMap.put("longitude", Float.valueOf(f));
                        g.this.uGH = String.valueOf(f);
                        hashMap.put("latitude", Float.valueOf(f2));
                        g.this.uGG = String.valueOf(f2);
                        hashMap.put("speed", Double.valueOf(d));
                        hashMap.put("accuracy", Double.valueOf(d2));
                        hashMap.put("type", str);
                        if (bundle != null) {
                            hashMap.put("indoor_building_id", bundle.getString("indoor_building_id"));
                            hashMap.put("indoor_building_floor", bundle.getString("indoor_building_floor"));
                            hashMap.put("indoor_building_type", Integer.valueOf(bundle.getInt("indoor_building_type")));
                        }
                        g.a(g.this, g.this.uGd, "geo_location:ok", hashMap);
                        AppMethodBeat.o(9131);
                        return false;
                    }
                    if (!(g.this.nPX || com.tencent.mm.modelgeo.d.agA())) {
                        g.this.nPX = true;
                        if (g.this.context != null) {
                            WebViewStubTempUI.c(g.this.context, g.this.context.getString(R.string.c9z), g.this.context.getString(R.string.tz), g.this.context.getString(R.string.ckr), g.this.context.getString(R.string.or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(9130);
                                    if (g.this.context != null) {
                                        com.tencent.mm.modelgeo.d.bX(g.this.context);
                                    }
                                    AppMethodBeat.o(9130);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(9131);
                    return true;
                }
            };
        }
        if (this.mzp == null) {
            this.mzp = new ak(Looper.getMainLooper());
        }
        this.mzp.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(9133);
                if (g.this.ecr != null) {
                    g.this.ecr.c(g.this.uGL);
                }
                if (g.this.uGL == null) {
                    ab.w("MicroMsg.MsgHandler", "already callback");
                    AppMethodBeat.o(9133);
                    return;
                }
                g.this.uGL = null;
                g.a(g.this, g.this.uGd, "geo_location:fail_timeout", null);
                AppMethodBeat.o(9133);
            }
        }, 20000);
        if (bo.isNullOrNil(str) || str.equalsIgnoreCase("gcj02")) {
            this.ecr.b(this.uGL, false);
            AppMethodBeat.o(9276);
        } else if (str.equalsIgnoreCase("wgs84")) {
            this.ecr.a(this.uGL, false);
            AppMethodBeat.o(9276);
        } else {
            ab.e("MicroMsg.MsgHandler", "startGeoLocation, should not reach here !!!!!");
            this.uGL = null;
            a(this.uGd, "geo_location:fail_unsupported_type_startgeo", null);
            AppMethodBeat.o(9276);
        }
    }

    private boolean G(i iVar) {
        AppMethodBeat.i(9278);
        String str = "";
        try {
            str = this.umI.getCurrentUrl();
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
        }
        ab.i("MicroMsg.MsgHandler", "currentUrl %s", str);
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://szsupport.weixin.qq.com/security/") || str.startsWith("https://hksupport.weixin.qq.com/security/") || str.startsWith("https://mlsupport.weixin.qq.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            Object obj = "";
            Map hashMap = new HashMap();
            try {
                ab.i("MicroMsg.MsgHandler", "getDeviceInfo");
                obj = Base64.encodeToString(dcA(), 0);
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgHandler", "device info get error %s", e2.getMessage());
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            hashMap.put("securityInfo", obj);
            a(iVar, "mmsf0001:ok", hashMap);
            AppMethodBeat.o(9278);
        } else {
            a(iVar, "system:access_denied", null);
            AppMethodBeat.o(9278);
        }
        return true;
    }

    private boolean H(i iVar) {
        Map map = null;
        AppMethodBeat.i(9279);
        if (this.context instanceof MMActivity) {
            String map2;
            ab.d("MicroMsg.MsgHandler", "doJumpToBizProfile %s, %s", (String) iVar.puc.get("tousername"), (String) iVar.puc.get("extmsg"));
            try {
                map2 = this.umI.getCurrentUrl();
            } catch (RemoteException e) {
                ab.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
            }
            Intent intent = new Intent();
            intent.putExtra("toUserName", r0);
            intent.putExtra(IssueStorage.COLUMN_EXT_INFO, r1);
            intent.putExtra("fromURL", map2);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.gkE.a(intent, 8, (com.tencent.mm.ui.MMActivity.a) this, (MMActivity) this.context);
        } else {
            a(iVar, "jump_to_biz_profile:fail", map2);
        }
        AppMethodBeat.o(9279);
        return true;
    }

    private boolean I(i iVar) {
        AppMethodBeat.i(9280);
        ab.i("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo, switch value : %s, title_cn : %s, title_eng : %s, ok_cn : %s,  ok_eng : %s,  cancel_cn : %s,  cancel_eng : %s", (String) iVar.puc.get("switch"), (String) iVar.puc.get("title_cn"), (String) iVar.puc.get("title_eng"), (String) iVar.puc.get("ok_cn"), (String) iVar.puc.get("ok_eng"), (String) iVar.puc.get("cancel_cn"), (String) iVar.puc.get("cancel_eng"));
        Bundle bundle = new Bundle();
        bundle.putString("close_window_confirm_dialog_switch", r0);
        bundle.putString("close_window_confirm_dialog_title_cn", r1);
        bundle.putString("close_window_confirm_dialog_title_eng", r2);
        bundle.putString("close_window_confirm_dialog_ok_cn", r3);
        bundle.putString("close_window_confirm_dialog_ok_eng", r4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", r5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", r6);
        try {
            this.umI.c(13, bundle);
        } catch (RemoteException e) {
            ab.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", e.getMessage());
        }
        a(iVar, "setCloseWindowConfirmDialogInfo:ok", null);
        AppMethodBeat.o(9280);
        return true;
    }

    private boolean J(final i iVar) {
        AppMethodBeat.i(9281);
        String str = (String) iVar.puc.get("verifyAppId");
        String str2 = (String) iVar.puc.get("verifyJsApiList");
        ab.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI, appid : %s, %s, %s, %s, %s", str, (String) iVar.puc.get("verifySignature"), (String) iVar.puc.get("verifyNonceStr"), (String) iVar.puc.get("verifyTimestamp"), (String) iVar.puc.get("verifySignType"));
        l.a(iVar.uII, false, null, str);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            ab.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI jsItem length %s", Integer.valueOf(jSONArray.length()));
            if (jSONArray.length() == 0) {
                a(iVar, "checkJsApi:param is empty", null);
                AppMethodBeat.o(9281);
                return true;
            }
            String str3;
            int i;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            }
            final String currentUrl = this.umI.getCurrentUrl();
            int i3 = 0;
            String str4 = "";
            try {
                Bundle g = this.umI.g(140, null);
                i3 = g.getInt("key_webview_preverify_info_scene", 0);
                str4 = g.getString("key_webview_preverify_info_source_appid", "");
                g.getString("raw_url", "");
                str3 = str4;
                i = i3;
            } catch (Exception e) {
                ab.e("TAG", "doPreVerifyJSAPI: %s", e);
                str3 = str4;
                i = i3;
            }
            try {
                this.umI.g(252, null);
            } catch (Exception e2) {
            }
            final e eVar = this.umI;
            f fVar = this.uGr;
            AnonymousClass72 anonymousClass72 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c() {
                public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a aVar, String str, LinkedList<cmu> linkedList, int i, int i2) {
                    AppMethodBeat.i(9134);
                    try {
                        g.this.umI.g(com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA, null);
                    } catch (Exception e) {
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("_url", currentUrl);
                    try {
                        bundle = eVar.g(146, bundle);
                        if (bundle == null) {
                            ab.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, result is null", currentUrl);
                            g.a(g.this, iVar, "pre_verify_jsapi:fail", null);
                            AppMethodBeat.o(9134);
                            return;
                        }
                        bundle.setClassLoader(g.class.getClassLoader());
                        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) bundle.getParcelable("_permission_wrapper");
                        if (jsapiPermissionWrapper == null) {
                            ab.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, jsPerm is null", currentUrl);
                            g.a(g.this, iVar, "pre_verify_jsapi:fail", null);
                            AppMethodBeat.o(9134);
                        } else if (aVar != com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK || jsapiPermissionWrapper.vxM == null) {
                            if (eVar != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper.vxM);
                                try {
                                    ab.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
                                    eVar.c(1006, bundle2);
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", e2.getMessage());
                                }
                            }
                            if (bo.isNullOrNil(str)) {
                                g.a(g.this, iVar, "pre_verify_jsapi:fail", null);
                                AppMethodBeat.o(9134);
                                return;
                            }
                            g.a(g.this, iVar, "pre_verify_jsapi:fail_".concat(String.valueOf(str)), null);
                            AppMethodBeat.o(9134);
                        } else {
                            g.this.uGx = bo.anT();
                            Object obj = null;
                            StringBuilder stringBuilder = new StringBuilder();
                            if (linkedList != null && linkedList.size() > 0) {
                                stringBuilder.append("[");
                                Iterator it = linkedList.iterator();
                                Object obj2 = null;
                                while (it.hasNext()) {
                                    cmu cmu = (cmu) it.next();
                                    com.tencent.mm.protocal.c.g akD = com.tencent.mm.protocal.c.akD(bo.nullAsNil(cmu.wzd));
                                    if (akD == null) {
                                        ab.i("MicroMsg.MsgHandler", "updateJsApi permission failed, func do not exist(%s, %d)", cmu.wzd, Integer.valueOf(cmu.state));
                                    } else {
                                        if (jsapiPermissionWrapper.Lx(akD.dmb()) != cmu.state) {
                                            jsapiPermissionWrapper.a(akD.dmb(), (byte) cmu.state);
                                            obj2 = 1;
                                            stringBuilder.append(akD.dmb()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cmu.state).append(",");
                                        }
                                        obj2 = obj2;
                                    }
                                }
                                stringBuilder.append("]");
                                obj = obj2;
                            }
                            if (!(obj == null || eVar == null)) {
                                ab.i("MicroMsg.MsgHandler", "updateJsApis permission(%s)", stringBuilder);
                                Bundle bundle3 = new Bundle();
                                bundle3.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper.vxM);
                                try {
                                    String str2 = "MicroMsg.MsgHandler";
                                    String str3 = "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(jsapiPermissionWrapper.vxM == null ? 0 : jsapiPermissionWrapper.vxM.length);
                                    objArr[1] = jsapiPermissionWrapper;
                                    ab.i(str2, str3, objArr);
                                    eVar.c(1006, bundle3);
                                } catch (Exception e22) {
                                    ab.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", e22.getMessage());
                                }
                            }
                            g.a(g.this, iVar, "pre_verify_jsapi:ok", null);
                            AppMethodBeat.o(9134);
                        }
                    } catch (RemoteException e3) {
                        ab.e("MicroMsg.MsgHandler", "getWvPermission(%s) error, %s", currentUrl, Log.getStackTraceString(e3));
                        g.a(g.this, iVar, "pre_verify_jsapi:fail", null);
                        AppMethodBeat.o(9134);
                    }
                }

                public final boolean dcf() {
                    return this.uFl;
                }

                public final void agk(String str) {
                    AppMethodBeat.i(9135);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(9135);
                    } else if (eVar == null) {
                        AppMethodBeat.o(9135);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("key_bag_icon", str);
                        try {
                            eVar.c(72, bundle);
                            AppMethodBeat.o(9135);
                        } catch (Exception e) {
                            ab.e("MicroMsg.MsgHandler", "withExtInfo remote ex, %s", e.getMessage());
                            AppMethodBeat.o(9135);
                        }
                    }
                }
            };
            if (bo.isNullOrNil(str) || linkedList.size() <= 0) {
                ab.e("MicroMsg.webview.JSVerifyHelper", "handlePreVerify wrong args, %s", str);
                anonymousClass72.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL, null, null, 0, 0);
            } else {
                com.tencent.mm.kernel.g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI, fVar);
                com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.webview.model.r(anonymousClass72, currentUrl, str, linkedList, r6, r7, r8, r9, i, str3, fVar.ulX), 0);
            }
            AppMethodBeat.o(9281);
            return true;
        } catch (Exception e3) {
            ab.w("MicroMsg.MsgHandler", "exception occur " + e3.getMessage());
            a(iVar, "pre_verify_jsapi:fail", null);
            AppMethodBeat.o(9281);
            return true;
        }
    }

    private boolean K(i iVar) {
        AppMethodBeat.i(9282);
        Map hashMap = new HashMap();
        try {
            dl dlVar = new dl();
            dlVar.cwJ.cwA = true;
            com.tencent.mm.sdk.b.a.xxA.m(dlVar);
            if (dlVar.cwK.cwB) {
                hashMap.put("currentSSID", dlVar.cwK.cwL);
                a(iVar, "getCurrentSSID:ok", hashMap);
            } else {
                hashMap.put("err_desc", "not on wifi");
                a(iVar, "getCurrentSSID:fail", hashMap);
            }
            AppMethodBeat.o(9282);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "getCurrentSSID:fail");
            hashMap.put("err_desc", "not on wifi");
            a(iVar, "getCurrentSSID:fail", hashMap);
            AppMethodBeat.o(9282);
        }
        return true;
    }

    private boolean L(i iVar) {
        AppMethodBeat.i(9283);
        int cZr = cZr();
        int bFf = bFf();
        String dcB = dcB();
        ab.i("MicroMsg.MsgHandler", "Key Scene(%d)", Integer.valueOf(bFf));
        if (bFf == 27) {
            this.uGi = (String) iVar.puc.get("brandUserName");
            ab.i("MicroMsg.MsgHandler", "BrandUserName from shake(%s)", this.uGi);
        } else if (!(cZr == 8 || cZr == -1)) {
            this.jMp = (String) iVar.puc.get("brandUserName");
            ab.i("MicroMsg.MsgHandler", "BrandUserName from H5(%s)", this.jMp);
            if (!(bo.isNullOrNil(dcB) || bo.isNullOrNil(this.jMp))) {
                ab.i("MicroMsg.MsgHandler", "Chat name(%s)", dcB);
                com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(dcB);
                if (qX != null) {
                    com.tencent.mm.aj.d.b cJ = qX.cJ(false);
                    if (!(cJ == null || cJ.aej() == null || !cJ.aej().aes() || dcB.equals(this.jMp))) {
                        a(iVar, "openWXDeviceLib:fail_UsernameError", null);
                        AppMethodBeat.o(9283);
                        return true;
                    }
                }
            }
        }
        dcB = V(iVar);
        ab.i("MicroMsg.MsgHandler", "srcUsername(%s)", dcB);
        if (bo.isNullOrNil(dcB)) {
            a(iVar, "openWXDeviceLib:fail_UsernameError", null);
            AppMethodBeat.o(9283);
        } else {
            h.pYm.e(11533, String.valueOf(dcB), "openWXDeviceLib");
            String str = "";
            if (iVar.puc.containsKey("connType")) {
                str = (String) iVar.puc.get("connType");
            }
            Object obj;
            if (str.equalsIgnoreCase("lan")) {
                if (this.uGk == null) {
                    this.uGk = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.a dbo = com.tencent.mm.plugin.webview.ui.tools.a.a.dbo();
                    e eVar = this.umI;
                    ab.i("MicroMsg.webview.WebViewExDeviceLanMgr", "tryInit");
                    if (dbo.uzY == null) {
                        dbo.uzY = new com.tencent.mm.plugin.webview.ui.tools.a.a.a(eVar, dcB);
                        com.tencent.mm.sdk.b.a.xxA.c(dbo.uzY.uAd);
                        com.tencent.mm.sdk.b.a.xxA.c(dbo.uzY.uAe);
                        com.tencent.mm.sdk.b.a.xxA.c(dbo.uzY.uAg);
                        com.tencent.mm.sdk.b.a.xxA.c(dbo.uzY.uAf);
                        com.tencent.mm.sdk.b.a.xxA.c(dbo.uzY.uAh);
                    }
                    ee eeVar = new ee();
                    eeVar.cxF.cwA = true;
                    com.tencent.mm.sdk.b.a.xxA.m(eeVar);
                    dbo.hasInit = true;
                    dbo.cwz = dcB;
                    dbo.uAa = null;
                    com.tencent.mm.pluginsdk.ui.tools.t.a(com.tencent.mm.plugin.webview.ui.tools.a.a.dbo());
                    if (at.isWifi(this.context)) {
                        obj = "on";
                    } else {
                        obj = "off";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("minVersion", Integer.valueOf(1));
                    hashMap.put("maxVersion", Integer.valueOf(1));
                    hashMap.put("lanState", obj);
                    a(iVar, "openWXDeviceLib:ok", hashMap);
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", e.getMessage());
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                    AppMethodBeat.o(9283);
                }
            } else {
                if (this.uGj == null) {
                    this.uGj = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.b dbr = com.tencent.mm.plugin.webview.ui.tools.a.b.dbr();
                    e eVar2 = this.umI;
                    ab.i("MicroMsg.webview.WebViewExDeviceMgr", "tryInit");
                    if (dbr.uAj == null) {
                        dbr.uAj = new com.tencent.mm.plugin.webview.ui.tools.a.b.a(eVar2, dcB);
                        com.tencent.mm.sdk.b.a.xxA.c(dbr.uAj.uAn);
                        com.tencent.mm.sdk.b.a.xxA.c(dbr.uAj.uAo);
                        com.tencent.mm.sdk.b.a.xxA.c(dbr.uAj.uAp);
                        com.tencent.mm.sdk.b.a.xxA.c(dbr.uAj.uAd);
                        com.tencent.mm.sdk.b.a.xxA.c(dbr.uAj.qwh);
                    }
                    dy dyVar = new dy();
                    dyVar.cxy.op = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(dyVar);
                    dbr.hasInit = true;
                    dbr.cwz = dcB;
                    dbr.uAa = null;
                    com.tencent.mm.pluginsdk.ui.tools.t.a(com.tencent.mm.plugin.webview.ui.tools.a.b.dbr());
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        obj = "unknow";
                        switch (defaultAdapter.getState()) {
                            case 10:
                                obj = "off";
                                break;
                            case 11:
                                obj = "resetting";
                                break;
                            case 12:
                                obj = "on";
                                break;
                        }
                    }
                    obj = "unknow";
                    ah.getContext();
                    ab.i("MicroMsg.webview.ExDeviceBluetoothUtil", "isBLESupported, ret = %b", Boolean.valueOf(ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")));
                    Map hashMap2 = new HashMap();
                    hashMap2.put("minVersion", Integer.valueOf(1));
                    hashMap2.put("maxVersion", Integer.valueOf(1));
                    hashMap2.put("bluetoothState", obj);
                    hashMap2.put("isSupportBLE", ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "yes" : "no");
                    if (cZr == 1) {
                        hashMap2.put("OS", "android");
                    }
                    a(iVar, "openWXDeviceLib:ok", hashMap2);
                } catch (Exception e2) {
                    ab.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", e2.getMessage());
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                    AppMethodBeat.o(9283);
                }
            }
            AppMethodBeat.o(9283);
        }
        return true;
    }

    private boolean M(i iVar) {
        AppMethodBeat.i(9284);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            try {
                str = V(iVar);
                h.pYm.e(11533, String.valueOf(str), "closeWXDeviceLib");
                com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().dbp();
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", e.getMessage());
                a(iVar, "closeWXDeviceLib:fail_exception", null);
                AppMethodBeat.o(9284);
            }
        } else {
            try {
                str = V(iVar);
                h.pYm.e(11533, String.valueOf(str), "closeWXDeviceLib");
                com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().dbp();
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", e2.getMessage());
                a(iVar, "closeWXDeviceLib:fail_exception", null);
                AppMethodBeat.o(9284);
            }
        }
        a(iVar, "closeWXDeviceLib:ok", null);
        AppMethodBeat.o(9284);
        return true;
    }

    private boolean N(i iVar) {
        AppMethodBeat.i(9285);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
                try {
                    ab.i("MicroMsg.MsgHandler", "srcUsername(%s)", V(iVar));
                    h.pYm.e(11533, String.valueOf(str), "startScanWXDevice");
                    if (bo.isNullOrNil(V(iVar))) {
                        a(iVar, "startScanWXDevice:fail_UsernameError", null);
                        AppMethodBeat.o(9285);
                    } else {
                        ev evVar = new ev();
                        evVar.cyp.cwA = true;
                        com.tencent.mm.sdk.b.a.xxA.m(evVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().uAc = true;
                        a(iVar, "startScanWXDevice:ok", null);
                        AppMethodBeat.o(9285);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", e.getMessage());
                    a(iVar, "startScanWXDevice:fail_exception", null);
                    AppMethodBeat.o(9285);
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
                a(iVar, "startScanWXDevice:fail_notInit", null);
                AppMethodBeat.o(9285);
            }
        } else if (com.tencent.mm.compatible.util.d.iW(23) && !((LocationManager) this.context.getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            ab.d("MicroMsg.MsgHandler", "Android version realse code: %s", VERSION.RELEASE);
            ab.e("MicroMsg.MsgHandler", "ScannerInThisAndroidVersionRequireGPSServiceOn");
            a(iVar, "startScanWXDevice:fail_ThisAndroidVersionRequireGPSServiceOn", null);
            AppMethodBeat.o(9285);
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            try {
                String V = V(iVar);
                str = (String) iVar.puc.get("btVersion");
                ab.i("MicroMsg.MsgHandler", "BtVersion(%s), srcUsername(%s)", str, V);
                h.pYm.e(11533, String.valueOf(V), "startScanWXDevice");
                if (bo.isNullOrNil(V)) {
                    a(iVar, "startScanWXDevice:fail_UsernameError", null);
                    AppMethodBeat.o(9285);
                } else {
                    ef efVar = new ef();
                    efVar.cxG.cwA = true;
                    efVar.cxG.cwz = V;
                    if (bo.nullAsNil(str).equals("ble")) {
                        efVar.cxG.cxI = 0;
                    } else if (bo.nullAsNil(str).equals("bc")) {
                        efVar.cxG.cxI = 1;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().uAl = efVar.cxG.cxI;
                    com.tencent.mm.sdk.b.a.xxA.m(efVar);
                    if (efVar.cxH.cwB) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().uAc = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    } else {
                        a(iVar, "startScanWXDevice:fail", null);
                    }
                    AppMethodBeat.o(9285);
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", e2.getMessage());
                a(iVar, "startScanWXDevice:fail_exception", null);
                AppMethodBeat.o(9285);
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
            a(iVar, "startScanWXDevice:fail_notInit", null);
            AppMethodBeat.o(9285);
        }
        return true;
    }

    private boolean O(i iVar) {
        AppMethodBeat.i(9286);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
                try {
                    str = V(iVar);
                    h.pYm.e(11533, String.valueOf(str), "stopScanWXDevice");
                    if (bo.isNullOrNil(str)) {
                        a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                        AppMethodBeat.o(9286);
                    } else {
                        ev evVar = new ev();
                        evVar.cyp.cwA = false;
                        com.tencent.mm.sdk.b.a.xxA.m(evVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().uAc = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                        AppMethodBeat.o(9286);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    ab.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", e.getMessage());
                    a(iVar, "stopScanWXDevice:fail_exception", null);
                    AppMethodBeat.o(9286);
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
                a(iVar, "stopScanWXDevice:fail_notInit", null);
                AppMethodBeat.o(9286);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            try {
                str = V(iVar);
                h.pYm.e(11533, String.valueOf(str), "stopScanWXDevice");
                if (bo.isNullOrNil(str)) {
                    a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                    AppMethodBeat.o(9286);
                } else {
                    ef efVar = new ef();
                    efVar.cxG.cwA = false;
                    efVar.cxG.cwz = str;
                    efVar.cxG.cxI = com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().uAl;
                    com.tencent.mm.sdk.b.a.xxA.m(efVar);
                    if (efVar.cxH.cwB) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().uAc = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    } else {
                        ab.e("MicroMsg.MsgHandler", "stopScanWXDevice fail");
                        a(iVar, "stopScanWXDevice:fail", null);
                    }
                    AppMethodBeat.o(9286);
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                ab.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", e2.getMessage());
                a(iVar, "stopScanWXDevice:fail_exception", null);
                AppMethodBeat.o(9286);
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
            a(iVar, "stopScanWXDevice:fail_notInit", null);
            AppMethodBeat.o(9286);
        }
        return true;
    }

    private boolean P(i iVar) {
        AppMethodBeat.i(9287);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        String V;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
                str = (String) iVar.puc.get("deviceId");
                ab.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", str);
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "connectWXDevice:fail_noDeviceId", null);
                    AppMethodBeat.o(9287);
                } else {
                    V = V(iVar);
                    h.pYm.e(11533, String.valueOf(V), "connectWXDevice");
                    if (bo.isNullOrNil(V)) {
                        a(iVar, "connectWXDevice:fail_UsernameError", null);
                        AppMethodBeat.o(9287);
                    } else {
                        if (!(this.uGk == null || this.uGk.containsKey(V))) {
                            this.uGk.put(V, str);
                        }
                        try {
                            di diVar = new di();
                            diVar.cwC.cwA = true;
                            diVar.cwC.cwz = V;
                            diVar.cwC.ceI = str;
                            com.tencent.mm.sdk.b.a.xxA.m(diVar);
                            if (diVar.cwD.cwB) {
                                a(iVar, "connectWXDevice:ok", null);
                            } else {
                                a(iVar, "connectWXDevice:fail", null);
                            }
                            AppMethodBeat.o(9287);
                        } catch (Exception e) {
                            ab.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", e.getMessage());
                            a(iVar, "connectWXDevice:fail_exception", null);
                            AppMethodBeat.o(9287);
                        }
                    }
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "connectWXDevice not init");
                a(iVar, "connectWXDevice:fail_notInit", null);
                AppMethodBeat.o(9287);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            str = (String) iVar.puc.get("deviceId");
            ab.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", str);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "connectWXDevice:fail_noDeviceId", null);
                AppMethodBeat.o(9287);
            } else {
                V = V(iVar);
                h.pYm.e(11533, String.valueOf(V), "connectWXDevice");
                if (bo.isNullOrNil(V)) {
                    a(iVar, "connectWXDevice:fail_UsernameError", null);
                    AppMethodBeat.o(9287);
                } else {
                    if (!(this.uGj == null || this.uGj.containsValue(str))) {
                        this.uGj.put(V, str);
                    }
                    try {
                        dh dhVar = new dh();
                        dhVar.cwx.cwA = true;
                        dhVar.cwx.cwz = V;
                        dhVar.cwx.ceI = str;
                        com.tencent.mm.sdk.b.a.xxA.m(dhVar);
                        if (dhVar.cwy.cwB) {
                            a(iVar, "connectWXDevice:ok", null);
                        } else {
                            a(iVar, "connectWXDevice:fail", null);
                        }
                        AppMethodBeat.o(9287);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", e2.getMessage());
                        a(iVar, "connectWXDevice:fail_exception", null);
                        AppMethodBeat.o(9287);
                    }
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "connectWXDevice not init");
            a(iVar, "connectWXDevice:fail_notInit", null);
            AppMethodBeat.o(9287);
        }
        return true;
    }

    private boolean Q(i iVar) {
        AppMethodBeat.i(9288);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        String V;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
                str = (String) iVar.puc.get("deviceId");
                ab.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", str);
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
                    AppMethodBeat.o(9288);
                } else {
                    V = V(iVar);
                    h.pYm.e(11533, String.valueOf(V), "disconnectWXDevice");
                    if (bo.isNullOrNil(V)) {
                        a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                        AppMethodBeat.o(9288);
                    } else {
                        try {
                            di diVar = new di();
                            diVar.cwC.cwA = false;
                            diVar.cwC.cwz = V;
                            diVar.cwC.ceI = str;
                            com.tencent.mm.sdk.b.a.xxA.m(diVar);
                            if (diVar.cwD.cwB) {
                                a(iVar, "disconnectWXDevice:ok", null);
                                if (this.uGk != null && this.uGk.containsKey(V)) {
                                    this.uGk.remove(V);
                                }
                            } else {
                                a(iVar, "disconnectWXDevice:fail", null);
                            }
                            AppMethodBeat.o(9288);
                        } catch (Exception e) {
                            ab.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", e.getMessage());
                            a(iVar, "disconnectWXDevice:fail_exception", null);
                            AppMethodBeat.o(9288);
                        }
                    }
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
                a(iVar, "disconnectWXDevice:fail_notInit", null);
                AppMethodBeat.o(9288);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            str = (String) iVar.puc.get("deviceId");
            ab.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", str);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
                AppMethodBeat.o(9288);
            } else {
                V = V(iVar);
                h.pYm.e(11533, String.valueOf(V), "disconnectWXDevice");
                if (bo.isNullOrNil(V)) {
                    a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                    AppMethodBeat.o(9288);
                } else {
                    try {
                        dh dhVar = new dh();
                        dhVar.cwx.cwA = false;
                        dhVar.cwx.cwz = V;
                        dhVar.cwx.ceI = str;
                        com.tencent.mm.sdk.b.a.xxA.m(dhVar);
                        if (dhVar.cwy.cwB) {
                            a(iVar, "disconnectWXDevice:ok", null);
                            if (this.uGj != null && this.uGj.containsKey(V)) {
                                this.uGj.remove(V);
                            }
                        } else {
                            a(iVar, "disconnectWXDevice:fail", null);
                        }
                        AppMethodBeat.o(9288);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", e2.getMessage());
                        a(iVar, "disconnectWXDevice:fail_exception", null);
                        AppMethodBeat.o(9288);
                    }
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
            a(iVar, "disconnectWXDevice:fail_notInit", null);
            AppMethodBeat.o(9288);
        }
        return true;
    }

    private boolean R(final i iVar) {
        AppMethodBeat.i(9289);
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit || com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
            String str = (String) iVar.puc.get("deviceId");
            String str2 = (String) iVar.puc.get("type");
            ab.i("MicroMsg.MsgHandler", "doGetWXDeviceTicket, deviceId : %s, type : %s", str, str2);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "deviceId or type is null");
                a(iVar, "getWXDeviceTicket:fail_wrongParams", null);
                AppMethodBeat.o(9289);
            } else {
                try {
                    String V = V(iVar);
                    h.pYm.e(11533, String.valueOf(V), "getWXDeviceTicket");
                    if (bo.isNullOrNil(V)) {
                        a(iVar, "getWXDeviceTicket:fail_UsernameError", null);
                        AppMethodBeat.o(9289);
                    } else {
                        final com.tencent.mm.sdk.b.b dpVar = new dp();
                        dpVar.cwX.type = bo.getInt(str2, 0);
                        dpVar.cwX.cwz = V;
                        dpVar.cwX.ceI = str;
                        dpVar.cwX.cwZ = iVar.uIG;
                        dpVar.callback = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9137);
                                ab.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", Boolean.valueOf(dpVar.cwY.cxa), dpVar.cwY.cxb);
                                if (dpVar.cwY.cxa) {
                                    if (bo.isNullOrNil(dpVar.cwY.cxb)) {
                                        g.a(g.this, iVar, "getWXDeviceTicket:fail", null);
                                    } else {
                                        Map hashMap = new HashMap();
                                        ab.i("MicroMsg.MsgHandler", "ticket %s", dpVar.cwY.cxb);
                                        hashMap.put("ticket", dpVar.cwY.cxb);
                                        g.a(g.this, iVar, "getWXDeviceTicket:ok", hashMap);
                                        AppMethodBeat.o(9137);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(9137);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.a(dpVar, Looper.getMainLooper());
                        AppMethodBeat.o(9289);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "getWXDeviceTicket failed : %s", e.getMessage());
                    a(iVar, "getWXDeviceTicket:fail_exception", null);
                    AppMethodBeat.o(9289);
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "getWXDeviceTicket not init");
            a(iVar, "getWXDeviceTicket:fail_notInit", null);
            AppMethodBeat.o(9289);
        }
        return true;
    }

    private boolean S(i iVar) {
        AppMethodBeat.i(9290);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        Map hashMap;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
                try {
                    str = V(iVar);
                    h.pYm.e(11533, String.valueOf(str), "getWXDeviceInfos");
                    ab.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", str);
                    if (bo.isNullOrNil(str)) {
                        a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                        AppMethodBeat.o(9290);
                    } else {
                        dn dnVar = new dn();
                        dnVar.cwP.cwz = str;
                        dnVar.cwP.context = this.context;
                        com.tencent.mm.sdk.b.a.xxA.m(dnVar);
                        if (!dnVar.cwQ.cwB || dnVar.cwQ.cwO == null) {
                            a(iVar, "getWXDeviceInfos:fail", null);
                            AppMethodBeat.o(9290);
                        } else {
                            hashMap = new HashMap();
                            hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                            hashMap.put("deviceInfos", dnVar.cwQ.cwO.toString());
                            a(iVar, "getWXDeviceInfos:ok", hashMap);
                            AppMethodBeat.o(9290);
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", e.getMessage());
                    a(iVar, "getWXDeviceInfos:fail_exception", null);
                    AppMethodBeat.o(9290);
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
                a(iVar, "getWXDeviceInfos:fail_notInit", null);
                AppMethodBeat.o(9290);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            try {
                str = V(iVar);
                h.pYm.e(11533, String.valueOf(str), "getWXDeviceInfos");
                ab.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", str);
                if (bo.isNullOrNil(str)) {
                    a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                    AppMethodBeat.o(9290);
                } else {
                    dm dmVar = new dm();
                    dmVar.cwM.cwz = str;
                    dmVar.cwM.context = this.context;
                    com.tencent.mm.sdk.b.a.xxA.m(dmVar);
                    if (!dmVar.cwN.cwB || dmVar.cwN.cwO == null) {
                        a(iVar, "getWXDeviceInfos:fail", null);
                        AppMethodBeat.o(9290);
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                        hashMap.put("deviceInfos", dmVar.cwN.cwO.toString());
                        a(iVar, "getWXDeviceInfos:ok", hashMap);
                        AppMethodBeat.o(9290);
                    }
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", e2.getMessage());
                a(iVar, "getWXDeviceInfos:fail_exception", null);
                AppMethodBeat.o(9290);
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
            a(iVar, "getWXDeviceInfos:fail_notInit", null);
            AppMethodBeat.o(9290);
        }
        return true;
    }

    private boolean T(i iVar) {
        AppMethodBeat.i(9291);
        String str = "";
        if (iVar.puc.containsKey("connType")) {
            str = (String) iVar.puc.get("connType");
        }
        String str2;
        String str3;
        String str4;
        Object[] objArr;
        String V;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.dbo().hasInit) {
                str = (String) iVar.puc.get("deviceId");
                str2 = (String) iVar.puc.get("base64Data");
                str3 = "MicroMsg.MsgHandler";
                str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
                objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(!bo.isNullOrNil(str2));
                ab.i(str3, str4, objArr);
                if (bo.isNullOrNil(str) || str2 == null) {
                    ab.e("MicroMsg.MsgHandler", "deviceId or data is null");
                    a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
                    AppMethodBeat.o(9291);
                } else {
                    try {
                        V = V(iVar);
                        h.pYm.e(11533, String.valueOf(V), "sendDataToWXDevice");
                        if (bo.isNullOrNil(V)) {
                            a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                            AppMethodBeat.o(9291);
                        } else {
                            ei eiVar = new ei();
                            eiVar.cxN.cwz = V;
                            eiVar.cxN.data = str2;
                            eiVar.cxN.ceI = str;
                            com.tencent.mm.sdk.b.a.xxA.m(eiVar);
                            if (eiVar.cxO.cwB) {
                                a(iVar, "sendDataToWXDevice:ok", null);
                            } else {
                                a(iVar, "sendDataToWXDevice:fail", null);
                            }
                            AppMethodBeat.o(9291);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", e.getMessage());
                        a(iVar, "sendDataToWXDevice:fail_exception", null);
                        AppMethodBeat.o(9291);
                    }
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
                a(iVar, "sendDataToWXDevice:fail_notInit", null);
                AppMethodBeat.o(9291);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            str = (String) iVar.puc.get("deviceId");
            str2 = (String) iVar.puc.get("base64Data");
            str3 = "MicroMsg.MsgHandler";
            str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
            objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(!bo.isNullOrNil(str2));
            ab.i(str3, str4, objArr);
            if (bo.isNullOrNil(str) || str2 == null) {
                ab.e("MicroMsg.MsgHandler", "deviceId or data is null");
                a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
                AppMethodBeat.o(9291);
            } else {
                try {
                    V = V(iVar);
                    h.pYm.e(11533, String.valueOf(V), "sendDataToWXDevice");
                    if (bo.isNullOrNil(V)) {
                        a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                        AppMethodBeat.o(9291);
                    } else {
                        eh ehVar = new eh();
                        ehVar.cxL.cwz = V;
                        ehVar.cxL.data = Base64.decode(str2, 0);
                        ehVar.cxL.ceI = str;
                        com.tencent.mm.sdk.b.a.xxA.m(ehVar);
                        if (ehVar.cxM.cwB) {
                            a(iVar, "sendDataToWXDevice:ok", null);
                        } else {
                            a(iVar, "sendDataToWXDevice:fail", null);
                        }
                        AppMethodBeat.o(9291);
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", e2.getMessage());
                    a(iVar, "sendDataToWXDevice:fail_exception", null);
                    AppMethodBeat.o(9291);
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
            a(iVar, "sendDataToWXDevice:fail_notInit", null);
            AppMethodBeat.o(9291);
        }
        return true;
    }

    private boolean U(i iVar) {
        AppMethodBeat.i(9292);
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.dbr().hasInit) {
            try {
                String str = (String) iVar.puc.get("deviceId");
                String str2 = (String) iVar.puc.get(TencentLocation.EXTRA_DIRECTION);
                ab.i("MicroMsg.MsgHandler", "setSendDataDirection, deviceId = %s, direction = %s", str, str2);
                if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                    ab.e("MicroMsg.MsgHandler", "wrong args");
                    a(iVar, "setSendDataDirection:fail_wrongParams", null);
                    AppMethodBeat.o(9292);
                } else {
                    int i = bo.getInt(str2, 0);
                    String V = V(iVar);
                    h.pYm.e(11533, String.valueOf(V), "setSendDataDirection");
                    if (bo.isNullOrNil(V)) {
                        a(iVar, "setSendDataDirection:fail_UsernameError", null);
                        AppMethodBeat.o(9292);
                    } else {
                        el elVar = new el();
                        elVar.cxX.ceI = str;
                        elVar.cxX.direction = i;
                        elVar.cxX.clear = false;
                        com.tencent.mm.sdk.b.a.xxA.m(elVar);
                        if (elVar.cxY.cwB) {
                            a(iVar, "setSendDataDirection:ok", null);
                        } else {
                            a(iVar, "setSendDataDirection:fail", null);
                        }
                        AppMethodBeat.o(9292);
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "setSendDataDirection failed : %s", e.getMessage());
                a(iVar, "setSendDataDirection:fail_exception", null);
                AppMethodBeat.o(9292);
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "setSendDataDirection not init");
            a(iVar, "setSendDataDirection:fail_notInit", null);
            AppMethodBeat.o(9292);
        }
        return true;
    }

    public final String dcB() {
        String str = null;
        AppMethodBeat.i(9293);
        try {
            if (this.umI != null) {
                Bundle g = this.umI.g(18, null);
                if (g != null) {
                    str = g.getString("preChatName");
                }
            }
        } catch (RemoteException e) {
            ab.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e);
        }
        AppMethodBeat.o(9293);
        return str;
    }

    public final int cZr() {
        AppMethodBeat.i(9294);
        int i = -1;
        try {
            if (this.umI != null) {
                Bundle g = this.umI.g(22, null);
                if (g != null) {
                    i = g.getInt("pay_channel");
                }
            }
        } catch (RemoteException e) {
            ab.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e);
        }
        AppMethodBeat.o(9294);
        return i;
    }

    public final int bFf() {
        int i = 0;
        AppMethodBeat.i(9295);
        try {
            if (this.umI != null) {
                Bundle g = this.umI.g(25, null);
                if (g != null) {
                    i = g.getInt("scene");
                }
            }
        } catch (RemoteException e) {
            ab.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e);
        }
        AppMethodBeat.o(9295);
        return i;
    }

    private int aGu() {
        int i = 0;
        AppMethodBeat.i(9296);
        try {
            if (this.umI != null) {
                Bundle g = this.umI.g(99, null);
                if (g != null) {
                    i = g.getInt("geta8key_scene");
                }
            }
        } catch (RemoteException e) {
            ab.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", e);
        }
        AppMethodBeat.o(9296);
        return i;
    }

    private String V(i iVar) {
        AppMethodBeat.i(9297);
        String str = null;
        String dcB = dcB();
        if (bFf() == 27) {
            str = this.uGi;
        } else if (cZr() == 8 || cZr() == -1) {
            if (iVar != null) {
                str = (String) iVar.puc.get("src_username");
                ab.i("MicroMsg.MsgHandler", "key_src_username(%s)", (String) iVar.puc.get("src_username"));
            }
        } else if (this.jMp != null) {
            str = this.jMp;
        } else if (!bo.isNullOrNil(dcB)) {
            ab.i("MicroMsg.MsgHandler", "BrandUsername in H5 is null, check if it is in hardBiz chat");
            com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(dcB);
            if (qX != null) {
                com.tencent.mm.aj.d.b cJ = qX.cJ(false);
                if (!(cJ == null || cJ.aej() == null || !cJ.aej().aes())) {
                    str = (String) iVar.puc.get("src_username");
                    ab.i("MicroMsg.MsgHandler", "HardBiz chat, key_src_username(%s)", (String) iVar.puc.get("src_username"));
                }
            }
        }
        AppMethodBeat.o(9297);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7 A:{SYNTHETIC, Splitter:B:29:0x00c7} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7 A:{SYNTHETIC, Splitter:B:29:0x00c7} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean W(i iVar) {
        int i;
        int i2;
        int i3;
        Boolean bool;
        Boolean bool2;
        Serializable serializable;
        int i4;
        Intent intent;
        AppMethodBeat.i(9298);
        String str = (String) iVar.puc.get("sourceType");
        ab.i("MicroMsg.MsgHandler", "source Type = %s", str);
        if (bo.isNullOrNil(str)) {
            i = 0;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                i2 = 0;
                i = 0;
                while (i2 < jSONArray.length()) {
                    try {
                        if (jSONArray.getString(i2).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                            i |= 1;
                        } else if (jSONArray.getString(i2).equals("camera")) {
                            i |= 2;
                        }
                        i2++;
                    } catch (Exception e) {
                        ab.e("MicroMsg.MsgHandler", "doChooseImage: sizeType parsing error");
                        if (i == 0) {
                        }
                        ab.i("MicroMsg.MsgHandler", "real scene = %d", Integer.valueOf(i2));
                        ab.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 113, "", "")));
                        if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 113, "", "")) {
                        }
                        i3 = bo.getInt((String) iVar.puc.get("count"), 0);
                        str = (String) iVar.puc.get("sizeType");
                        bool = Boolean.FALSE;
                        bool2 = Boolean.FALSE;
                        if (bo.isNullOrNil(str)) {
                        }
                        if (!bool.booleanValue()) {
                        }
                        if (!bool.booleanValue()) {
                        }
                        serializable = Boolean.FALSE;
                        i4 = 8;
                        intent = new Intent();
                        intent.putExtra("key_pick_local_pic_capture", i2);
                        intent.putExtra("key_pick_local_pic_count", i3);
                        intent.putExtra("key_pick_local_pic_query_source_type", i4);
                        intent.putExtra("key_pick_local_pic_send_raw", serializable);
                        intent.putExtra("query_media_type", 1);
                        ab.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), serializable);
                        if (this.context instanceof MMActivity) {
                        }
                        AppMethodBeat.o(9298);
                        return true;
                    }
                }
            } catch (Exception e2) {
                i = 0;
                ab.e("MicroMsg.MsgHandler", "doChooseImage: sizeType parsing error");
                if (i == 0) {
                }
                ab.i("MicroMsg.MsgHandler", "real scene = %d", Integer.valueOf(i2));
                ab.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 113, "", "")));
                if (com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 113, "", "")) {
                }
                i3 = bo.getInt((String) iVar.puc.get("count"), 0);
                str = (String) iVar.puc.get("sizeType");
                bool = Boolean.FALSE;
                bool2 = Boolean.FALSE;
                if (bo.isNullOrNil(str)) {
                }
                if (!bool.booleanValue()) {
                }
                if (bool.booleanValue()) {
                }
                serializable = Boolean.FALSE;
                i4 = 8;
                intent = new Intent();
                intent.putExtra("key_pick_local_pic_capture", i2);
                intent.putExtra("key_pick_local_pic_count", i3);
                intent.putExtra("key_pick_local_pic_query_source_type", i4);
                intent.putExtra("key_pick_local_pic_send_raw", serializable);
                intent.putExtra("query_media_type", 1);
                ab.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), serializable);
                if (this.context instanceof MMActivity) {
                }
                AppMethodBeat.o(9298);
                return true;
            }
        }
        if (i == 0) {
            i2 = 3;
        } else {
            i2 = i;
        }
        ab.i("MicroMsg.MsgHandler", "real scene = %d", Integer.valueOf(i2));
        if (i2 == 2 || i2 == 3) {
            ab.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 113, "", "")));
            if (com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 113, "", "")) {
                AppMethodBeat.o(9298);
                return true;
            }
        }
        i3 = bo.getInt((String) iVar.puc.get("count"), 0);
        str = (String) iVar.puc.get("sizeType");
        bool = Boolean.FALSE;
        bool2 = Boolean.FALSE;
        Boolean bool3;
        if (bo.isNullOrNil(str)) {
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                int i5 = 0;
                bool3 = bool2;
                while (i5 < jSONArray2.length()) {
                    try {
                        if (jSONArray2.getString(i5).equals("original")) {
                            bool = Boolean.TRUE;
                        } else if (jSONArray2.getString(i5).equals("compressed")) {
                            bool3 = Boolean.TRUE;
                        }
                        i5++;
                    } catch (Exception e3) {
                        ab.e("MicroMsg.MsgHandler", "doChooseImage: sizeType parsing error");
                        if (!bool.booleanValue()) {
                        }
                        if (bool.booleanValue()) {
                        }
                        serializable = Boolean.FALSE;
                        i4 = 8;
                        intent = new Intent();
                        intent.putExtra("key_pick_local_pic_capture", i2);
                        intent.putExtra("key_pick_local_pic_count", i3);
                        intent.putExtra("key_pick_local_pic_query_source_type", i4);
                        intent.putExtra("key_pick_local_pic_send_raw", serializable);
                        intent.putExtra("query_media_type", 1);
                        ab.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), serializable);
                        if (this.context instanceof MMActivity) {
                        }
                        AppMethodBeat.o(9298);
                        return true;
                    }
                }
            } catch (Exception e4) {
                bool3 = bool2;
                ab.e("MicroMsg.MsgHandler", "doChooseImage: sizeType parsing error");
                if (!bool.booleanValue()) {
                }
                if (bool.booleanValue()) {
                }
                serializable = Boolean.FALSE;
                i4 = 8;
                intent = new Intent();
                intent.putExtra("key_pick_local_pic_capture", i2);
                intent.putExtra("key_pick_local_pic_count", i3);
                intent.putExtra("key_pick_local_pic_query_source_type", i4);
                intent.putExtra("key_pick_local_pic_send_raw", serializable);
                intent.putExtra("query_media_type", 1);
                ab.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), serializable);
                if (this.context instanceof MMActivity) {
                }
                AppMethodBeat.o(9298);
                return true;
            }
        }
        bool3 = bool2;
        if (!bool.booleanValue() && !r0.booleanValue()) {
            serializable = Boolean.TRUE;
            i4 = 7;
        } else if (bool.booleanValue() || !r0.booleanValue()) {
            serializable = Boolean.FALSE;
            i4 = 8;
        } else {
            serializable = Boolean.FALSE;
            i4 = 7;
        }
        intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i2);
        intent.putExtra("key_pick_local_pic_count", i3);
        intent.putExtra("key_pick_local_pic_query_source_type", i4);
        intent.putExtra("key_pick_local_pic_send_raw", serializable);
        intent.putExtra("query_media_type", 1);
        ab.i("MicroMsg.MsgHandler", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), serializable);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
        }
        AppMethodBeat.o(9298);
        return true;
    }

    private boolean X(i iVar) {
        boolean z;
        AppMethodBeat.i(9299);
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("localId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                boolean z2;
                if (bo.getInt(obj.toString(), 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            l.a(iVar.uII, false, null, str);
            ab.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadImage:fail_missing arguments", null);
                AppMethodBeat.o(9299);
            } else {
                a(iVar, str, str2, com.tencent.mm.i.a.MediaType_FILE, 0, 0, "uploadImage", z);
                AppMethodBeat.o(9299);
            }
            return true;
        }
        z = true;
        l.a(iVar.uII, false, null, str);
        ab.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
        }
        ab.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadImage:fail_missing arguments", null);
        AppMethodBeat.o(9299);
        return true;
    }

    private boolean Y(final i iVar) {
        int i;
        AppMethodBeat.i(9300);
        String str = (String) iVar.puc.get("appId");
        final String str2 = (String) iVar.puc.get("serverId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                if (bo.getInt(obj.toString(), 0) == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            l.a(iVar.uII, false, null, str);
            ab.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", str, str2);
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                a(iVar, "downloadImage:fail_missing arguments", null);
                AppMethodBeat.o(9300);
            } else {
                final AnonymousClass75 anonymousClass75 = new com.tencent.mm.plugin.webview.model.d.b() {
                    public final void b(boolean z, String str, String str2, String str3) {
                        AppMethodBeat.i(9138);
                        ab.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", Boolean.valueOf(z), str, str2);
                        if (!bo.isNullOrNil(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                            if (g.this.ehJ != null) {
                                g.this.ehJ.dismiss();
                                g.this.ehJ = null;
                            }
                            if (z) {
                                WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str);
                                if ((aex instanceof WebViewJSSDKImageItem) && bo.isNullOrNil(aex.hGG)) {
                                    ((WebViewJSSDKImageItem) aex).cXL();
                                }
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                g.a(g.this, iVar, "downloadImage:ok", hashMap);
                            } else {
                                g.a(g.this, iVar, "downloadImage:fail", null);
                                AppMethodBeat.o(9138);
                                return;
                            }
                        }
                        AppMethodBeat.o(9138);
                    }
                };
                com.tencent.mm.plugin.webview.modeltools.g.cYE().a(str, str2, anonymousClass75);
                ab.i("MicroMsg.MsgHandler", "doDownLoadImage, add cdn download task result : %b", Boolean.TRUE);
                if (i != 0) {
                    Context context = this.context;
                    this.context.getString(R.string.tz);
                    this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.g2_), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(9139);
                            com.tencent.mm.plugin.webview.modeltools.g.cYE().a(anonymousClass75);
                            com.tencent.mm.plugin.webview.modeltools.g.cYE();
                            com.tencent.mm.plugin.webview.model.aj.aet(str2);
                            g.a(g.this, iVar, "downloadImage:fail", null);
                            AppMethodBeat.o(9139);
                        }
                    });
                }
                AppMethodBeat.o(9300);
            }
            return true;
        }
        i = 1;
        l.a(iVar.uII, false, null, str);
        ab.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", str, str2);
        if (bo.isNullOrNil(str)) {
        }
        a(iVar, "downloadImage:fail_missing arguments", null);
        AppMethodBeat.o(9300);
        return true;
    }

    private boolean Z(i iVar) {
        boolean z;
        AppMethodBeat.i(9301);
        ab.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile()");
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("localId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bo.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            ab.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "appId or localid is null");
                a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
                AppMethodBeat.o(9301);
            } else {
                l.a(iVar.uII, false, null, str);
                WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
                if (aex == null) {
                    ab.e("MicroMsg.MsgHandler", "jssdk file item is null for localId:%s", str2);
                    a(iVar, "uploadEncryptMediaFile:file_not_exist", null);
                    AppMethodBeat.o(9301);
                } else {
                    switch (aex.cyQ) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.i.a.efH, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.i.a.efH, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.i.a.efH, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                    }
                    AppMethodBeat.o(9301);
                }
            }
            return true;
        }
        z = true;
        ab.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
        }
        ab.e("MicroMsg.MsgHandler", "appId or localid is null");
        a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
        AppMethodBeat.o(9301);
        return true;
    }

    private boolean aa(final i iVar) {
        AppMethodBeat.i(9302);
        ab.i("MicroMsg.MsgHandler", "doChooseMedia()");
        ab.i("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", com.tencent.view.d.MIC_AVROUND_BLUR, "", "")));
        if (com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", com.tencent.view.d.MIC_AVROUND_BLUR, "", "")) {
            ab.i("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")));
            if (com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")) {
                int i;
                String str;
                String nullAsNil = bo.nullAsNil((String) iVar.puc.get("sourceType"));
                String nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("mediaType"));
                int min = Math.min(bo.getInt((String) iVar.puc.get("maxDuration"), 10), 10);
                final String nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("camera"));
                int i2 = bo.getInt((String) iVar.puc.get("count"), 1);
                String nullAsNil4 = bo.nullAsNil((String) iVar.puc.get("sizeType"));
                ab.i("MicroMsg.MsgHandler", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", nullAsNil, nullAsNil2, Integer.valueOf(min), nullAsNil3, Integer.valueOf(i2), nullAsNil4);
                final Intent intent = new Intent();
                intent.putExtra("key_pick_local_pic_count", i2);
                if (min <= 0) {
                    i = 10;
                } else {
                    i = min;
                }
                intent.putExtra("key_pick_local_media_duration", i);
                intent.putExtra("query_media_type", 3);
                intent.putExtra("key_pick_local_media_video_type", 2);
                intent.putExtra("key_pick_local_media_sight_type", nullAsNil2);
                intent.putExtra("key_pick_local_pic_query_source_type", (nullAsNil4.contains("original") ^ nullAsNil4.contains("compressed")) != 0 ? 7 : 8);
                intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(nullAsNil4.contains("compressed")));
                if (bo.isNullOrNil(nullAsNil)) {
                    str = "album|camera";
                } else {
                    str = nullAsNil;
                }
                if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
                    com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this.context);
                    jVar.b(null, new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(9142);
                            contextMenu.add(0, 1, 0, g.this.context.getString(R.string.q4));
                            contextMenu.add(0, 2, 1, g.this.context.getString(R.string.qa));
                            AppMethodBeat.o(9142);
                        }
                    }, new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(9143);
                            switch (menuItem.getItemId()) {
                                case 1:
                                    g.a(g.this, nullAsNil3, intent);
                                    AppMethodBeat.o(9143);
                                    return;
                                case 2:
                                    g.b(g.this, intent);
                                    break;
                            }
                            AppMethodBeat.o(9143);
                        }
                    });
                    jVar.e(new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(9144);
                            g.a(g.this, iVar, "doChooseMedia:cancel", null);
                            AppMethodBeat.o(9144);
                        }
                    });
                    jVar.cuu();
                    AppMethodBeat.o(9302);
                    return true;
                } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                    aA(intent);
                    AppMethodBeat.o(9302);
                    return true;
                } else if (str.contains("camera")) {
                    b(nullAsNil3, intent);
                    AppMethodBeat.o(9302);
                    return true;
                } else {
                    a(iVar, "chooseMedia:fail_sourceType_error", null);
                    AppMethodBeat.o(9302);
                    return true;
                }
            }
            AppMethodBeat.o(9302);
            return true;
        }
        AppMethodBeat.o(9302);
        return true;
    }

    private void b(String str, Intent intent) {
        int i;
        AppMethodBeat.i(9303);
        ab.i("MicroMsg.MsgHandler", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        ((MMActivity) this.context).ifE = this;
        com.tencent.mm.bp.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
        AppMethodBeat.o(9303);
    }

    private void aA(Intent intent) {
        AppMethodBeat.i(9304);
        ab.i("MicroMsg.MsgHandler", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", 4096);
        ((MMActivity) this.context).ifE = this;
        com.tencent.mm.bp.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
        AppMethodBeat.o(9304);
    }

    private boolean a(i iVar, int i) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(9305);
        String nullAsNil = bo.nullAsNil((String) iVar.puc.get("sourceType"));
        ab.i("MicroMsg.MsgHandler", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", nullAsNil, bo.nullAsNil((String) iVar.puc.get("camera")), Integer.valueOf(i));
        int i5 = bo.getInt((String) iVar.puc.get("maxDuration"), 60);
        if (nullAsNil.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i2 = 4096;
        } else {
            i2 = 0;
        }
        if (nullAsNil.contains("camera")) {
            if (i5 <= 0) {
                a(iVar, "chooseVideo:fail", null);
                AppMethodBeat.o(9305);
                return true;
            } else if (r3.equals("front")) {
                i2 |= 16;
            } else {
                i2 |= 256;
            }
        }
        if (i2 == 0) {
            i3 = 4352;
        } else {
            i3 = i2;
        }
        if (i3 == 16 || i3 == 256 || i3 == 4352) {
            if (i == 1) {
                ab.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, "", "")));
                if (com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", com.tencent.view.d.MIC_ALPHA_ADJUST_REAL, "", "")) {
                    ab.d("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.RECORD_AUDIO", 118, "", "")));
                    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.RECORD_AUDIO", 118, "", "")) {
                        AppMethodBeat.o(9305);
                    }
                } else {
                    AppMethodBeat.o(9305);
                }
                return true;
            }
            ab.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 115, "", "")));
            if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) this.context, "android.permission.CAMERA", 115, "", "")) {
                AppMethodBeat.o(9305);
                return true;
            }
        }
        i2 = bo.getInt((String) iVar.puc.get("quality"), 1);
        if (i2 == 0 || i2 == 1) {
            i4 = i2;
        } else {
            i4 = 1;
        }
        if (i5 > 60) {
            i2 = 60;
        } else {
            i2 = i5;
        }
        ab.i("MicroMsg.MsgHandler", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(i4), Integer.valueOf(i2));
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i3);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i4);
        intent.putExtra("key_pick_local_media_duration", i2);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i);
        ab.i("MicroMsg.MsgHandler", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(7));
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).ifE = this;
            if (i == 1) {
                com.tencent.mm.bp.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
            } else {
                com.tencent.mm.bp.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
            }
        }
        AppMethodBeat.o(9305);
        return true;
    }

    private boolean ab(i iVar) {
        boolean z;
        AppMethodBeat.i(9306);
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("localId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bo.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            ab.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadMediaFile:fail_missing arguments", null);
                AppMethodBeat.o(9306);
            } else {
                l.a(iVar.uII, false, null, str);
                WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
                if (aex == null) {
                    a(iVar, "uploadMediaFile:fail", null);
                    AppMethodBeat.o(9306);
                } else {
                    switch (aex.cyQ) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.i.a.efJ, 202, 2, "uploadMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.i.a.efK, 202, 2, "uploadMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.i.a.efM, 202, 2, "uploadMediaFile", z);
                            break;
                    }
                    AppMethodBeat.o(9306);
                }
            }
            return true;
        }
        z = true;
        ab.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
        }
        ab.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadMediaFile:fail_missing arguments", null);
        AppMethodBeat.o(9306);
        return true;
    }

    private void a(final i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        AppMethodBeat.i(9307);
        final String str4 = str3;
        final String str5 = str2;
        AnonymousClass82 anonymousClass82 = new com.tencent.mm.plugin.webview.model.d.b() {
            public final void b(boolean z, String str, String str2, String str3) {
                AppMethodBeat.i(9146);
                ab.i("MicroMsg.MsgHandler", str4 + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (!bo.isNullOrNil(str) && str.equals(str5)) {
                    com.tencent.mm.plugin.webview.modeltools.g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                    if (g.this.ehJ != null) {
                        g.this.ehJ.dismiss();
                        g.this.ehJ = null;
                    }
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        g.a(g.this, iVar, str4 + ":ok", hashMap);
                    } else {
                        g.a(g.this, iVar, str4 + ":fail", null);
                        AppMethodBeat.o(9146);
                        return;
                    }
                }
                AppMethodBeat.o(9146);
            }
        };
        WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
        if (aex == null) {
            a(iVar, str3 + ":fail", null);
            AppMethodBeat.o(9307);
            return;
        }
        com.tencent.mm.at.e b = com.tencent.mm.at.o.ahl().b(Long.valueOf(com.tencent.mm.at.o.ahl().a(aex.heo, aex.hes ? 0 : 1, 0, new PString(), new PInt(), new PInt())));
        String str6 = aex.heo;
        aex.heo = com.tencent.mm.at.o.ahl().q(b.fDz, "", "");
        ab.i("MicroMsg.MsgHandler", "Image Inserted: %s", r2);
        ab.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.g.cYE().a(str, str2, i, i2, i3, anonymousClass82)));
        if (!com.tencent.mm.plugin.webview.modeltools.g.cYE().a(str, str2, i, i2, i3, anonymousClass82)) {
            a(iVar, str3 + ":fail", null);
        } else if (z) {
            Context context = this.context;
            this.context.getString(R.string.tz);
            final AnonymousClass82 anonymousClass822 = anonymousClass82;
            final String str7 = str2;
            final i iVar2 = iVar;
            final String str8 = str3;
            this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.g33), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(9147);
                    com.tencent.mm.plugin.webview.modeltools.g.cYE().a(anonymousClass822);
                    com.tencent.mm.plugin.webview.modeltools.g.cYE();
                    com.tencent.mm.plugin.webview.model.aj.yC(str7);
                    g.a(g.this, iVar2, str8 + ":fail", null);
                    AppMethodBeat.o(9147);
                }
            });
        } else if (this.context instanceof Activity) {
            ((Activity) this.context).finish();
            this.umI = this.uGq;
        }
        aex.heo = str6;
        AppMethodBeat.o(9307);
    }

    private void b(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        AppMethodBeat.i(9308);
        WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
        if (aex == null || bo.isNullOrNil(aex.heo) || !com.tencent.mm.vfs.e.ct(aex.heo)) {
            a(iVar, str3 + ":fail_file not exist", null);
            AppMethodBeat.o(9308);
        } else if (com.tencent.mm.network.ab.ch(this.context)) {
            c(iVar, str, str2, i, i2, i3, str3, z);
            AppMethodBeat.o(9308);
        } else {
            String my = bo.my(com.tencent.mm.vfs.e.asZ(aex.heo));
            Context context = this.context;
            String string = this.context.getString(R.string.fyw, new Object[]{my});
            String string2 = this.context.getString(R.string.tz);
            final i iVar2 = iVar;
            final String str4 = str;
            final String str5 = str2;
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str6 = str3;
            final boolean z2 = z;
            AnonymousClass84 anonymousClass84 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9148);
                    g.a(g.this, iVar2, str4, str5, i4, i5, i6, str6, z2);
                    AppMethodBeat.o(9148);
                }
            };
            final i iVar3 = iVar;
            final String str7 = str3;
            com.tencent.mm.ui.base.h.a(context, string, string2, false, (OnClickListener) anonymousClass84, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9149);
                    g.a(g.this, iVar3, str7 + ":cancel", null);
                    AppMethodBeat.o(9149);
                }
            });
            AppMethodBeat.o(9308);
        }
    }

    private void c(final i iVar, String str, final String str2, int i, int i2, int i3, String str3, boolean z) {
        AppMethodBeat.i(9309);
        final String str4 = str3;
        final AnonymousClass86 anonymousClass86 = new com.tencent.mm.plugin.webview.model.d.b() {
            public final void b(boolean z, String str, String str2, String str3) {
                AppMethodBeat.i(9150);
                ab.i("MicroMsg.MsgHandler", str4 + ", on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (bo.isNullOrNil(str) || !str.equals(str2)) {
                    AppMethodBeat.o(9150);
                    return;
                }
                g.this.uGO.remove(str2);
                com.tencent.mm.plugin.webview.modeltools.g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                if (g.this.ehJ != null) {
                    g.this.ehJ.dismiss();
                    g.this.ehJ = null;
                }
                g.F(g.this);
                if (z) {
                    Map hashMap = new HashMap();
                    hashMap.put("serverId", str2);
                    hashMap.put("mediaUrl", str3);
                    g.a(g.this, iVar, str4 + ":ok", hashMap);
                    AppMethodBeat.o(9150);
                    return;
                }
                g.a(g.this, iVar, str4 + ":fail", null);
                AppMethodBeat.o(9150);
            }
        };
        boolean a = com.tencent.mm.plugin.webview.modeltools.g.cYE().a(str, str2, i, i2, i3, anonymousClass86);
        ab.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", Boolean.valueOf(a));
        if (a) {
            b bVar = new b();
            bVar.uGd = iVar;
            bVar.uIC = anonymousClass86;
            this.uGO.put(str2, bVar);
            Bundle bundle = new Bundle();
            bundle.putString("close_window_confirm_dialog_switch", "true");
            bundle.putString("close_window_confirm_dialog_title_cn", this.context.getString(R.string.fyy));
            bundle.putString("close_window_confirm_dialog_title_eng", this.context.getString(R.string.fyy));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.context.getString(R.string.fyu));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.context.getString(R.string.fyu));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.context.getString(R.string.fyv));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.context.getString(R.string.fyv));
            try {
                this.umI.c(13, bundle);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", e.getMessage());
            }
            if (z) {
                Context context = this.context;
                this.context.getString(R.string.tz);
                final String str5 = str2;
                final i iVar2 = iVar;
                final String str6 = str3;
                this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.g33), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(9151);
                        com.tencent.mm.plugin.webview.modeltools.g.cYE().a(anonymousClass86);
                        com.tencent.mm.plugin.webview.modeltools.g.cYE();
                        com.tencent.mm.plugin.webview.model.aj.yC(str5);
                        g.F(g.this);
                        g.a(g.this, iVar2, str6 + ":cancel", null);
                        AppMethodBeat.o(9151);
                    }
                });
                this.ehJ.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(9153);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            com.tencent.mm.ui.base.h.a(g.this.context, true, g.this.context.getString(R.string.fyy), "", g.this.context.getString(R.string.fyu), g.this.context.getString(R.string.fyv), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(9152);
                                    g.this.ehJ.cancel();
                                    AppMethodBeat.o(9152);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(9153);
                            return true;
                        }
                        AppMethodBeat.o(9153);
                        return false;
                    }
                });
                AppMethodBeat.o(9309);
                return;
            }
            if (this.context instanceof Activity) {
                ((Activity) this.context).finish();
                this.umI = this.uGq;
            }
            AppMethodBeat.o(9309);
            return;
        }
        a(iVar, str3 + ":fail", null);
        AppMethodBeat.o(9309);
    }

    private boolean ac(i iVar) {
        boolean z;
        AppMethodBeat.i(9310);
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("localId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bo.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occurred : %s", e.getMessage());
            }
            ab.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVideo:fail_missing arguments", null);
                AppMethodBeat.o(9310);
            } else {
                b(iVar, str, str2, com.tencent.mm.i.a.MediaType_FILE, 0, 0, "uploadVideo", z);
                AppMethodBeat.o(9310);
            }
            return true;
        }
        z = true;
        ab.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
        }
        ab.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVideo:fail_missing arguments", null);
        AppMethodBeat.o(9310);
        return true;
    }

    public final boolean dcC() {
        AppMethodBeat.i(9311);
        boolean z = !bo.isNullOrNil(this.uGP);
        if (z) {
            ab.e("MicroMsg.MsgHandler", "in recording state.");
        }
        AppMethodBeat.o(9311);
        return z;
    }

    private boolean ad(final i iVar) {
        AppMethodBeat.i(9312);
        if (dcC()) {
            try {
                this.umI.c(TXLiveConstants.PLAY_EVT_PLAY_LOADING, null);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "callback start record failed");
            }
            a(iVar, "startRecord:fail_recording", null);
            AppMethodBeat.o(9312);
        } else {
            String str = (String) iVar.puc.get("appId");
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MsgHandler", "appId is null or nil.");
                a(iVar, "startRecord:fail_missing arguments", null);
                AppMethodBeat.o(9312);
            } else {
                l.a(iVar.uII, false, null, str);
                if (com.tencent.mm.pluginsdk.permission.b.o(this.context, "android.permission.RECORD_AUDIO")) {
                    final WebViewJSSDKFileItem aev = WebViewJSSDKFileItem.aev(ap.aeF(str));
                    aev.appId = str;
                    com.tencent.mm.plugin.webview.modeltools.g.cYF().b(aev);
                    ab.i("MicroMsg.MsgHandler", "start record appId : %s, voice file name : %s, voice file path : %s", str, r1, aev.heo);
                    this.uGP = aev.czD;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(9155);
                            final fn fnVar = new fn();
                            fnVar.czm.op = 1;
                            fnVar.czm.filePath = aev.heo;
                            fnVar.czm.duration = bo.getInt((String) iVar.puc.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION), 60);
                            fnVar.czm.chj = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(9154);
                                    ab.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", aev.czD);
                                    try {
                                        g.this.uGP = null;
                                        Bundle bundle = new Bundle();
                                        bundle.putString("localId", aev.czD);
                                        String str = "recordResult";
                                        StringBuilder stringBuilder = new StringBuilder("onVoiceRecordEnd:");
                                        String str2 = (fnVar.czn.czo != 2 || fnVar.czn.czo == 3) ? "ok" : "fail";
                                        bundle.putString(str, stringBuilder.append(str2).toString());
                                        if (g.this.umI != null) {
                                            g.this.umI.c(2008, bundle);
                                            AppMethodBeat.o(9154);
                                            return;
                                        }
                                        ab.e("MicroMsg.MsgHandler", "callbacker is null");
                                        AppMethodBeat.o(9154);
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.MsgHandler", "callback stop record failed");
                                        AppMethodBeat.o(9154);
                                    }
                                }
                            };
                            com.tencent.mm.sdk.b.a.xxA.m(fnVar);
                            AppMethodBeat.o(9155);
                        }
                    });
                    try {
                        this.umI.c(TXLiveConstants.PLAY_EVT_PLAY_LOADING, null);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.MsgHandler", "callback start record failed");
                    }
                    a(iVar, "startRecord:ok", null);
                    AppMethodBeat.o(9312);
                } else {
                    WebViewStubTempUI.a(this.context, this.umI, new String[]{"android.permission.RECORD_AUDIO"}, 116, this.cIv);
                    AppMethodBeat.o(9312);
                }
            }
        }
        return true;
    }

    private boolean ae(i iVar) {
        AppMethodBeat.i(9313);
        if (dcC()) {
            String str = (String) iVar.puc.get("appId");
            ab.i("MicroMsg.MsgHandler", "stop record appId : %s", str);
            l.a(iVar.uII, false, null, str);
            final WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(this.uGP);
            if (aex == null || !str.equals(aex.appId)) {
                ab.e("MicroMsg.MsgHandler", "get jssdk file item by id failed or the appid is not corrected, appid is : %s", str);
                a(iVar, "stopRecord:fail", null);
                AppMethodBeat.o(9313);
            } else {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9157);
                        fn fnVar = new fn();
                        fnVar.czm.op = 2;
                        fnVar.czm.filePath = aex.heo;
                        com.tencent.mm.sdk.b.a.xxA.m(fnVar);
                        g.this.uGP = null;
                        AppMethodBeat.o(9157);
                    }
                });
                ab.i("MicroMsg.MsgHandler", "stop record, file name  : %s, file path : %s, localid : %s", aex.fileName, aex.heo, aex.czD);
                Map hashMap = new HashMap();
                hashMap.put("localId", aex.czD);
                try {
                    this.umI.c(2009, null);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.MsgHandler", "callback on stop record failed.");
                }
                a(iVar, "stopRecord:ok", hashMap);
                AppMethodBeat.o(9313);
            }
        } else {
            ab.w("MicroMsg.MsgHandler", "Do not in recording state.");
            a(iVar, "stopRecord:fail", null);
            AppMethodBeat.o(9313);
        }
        return true;
    }

    private boolean af(final i iVar) {
        boolean z;
        AppMethodBeat.i(9314);
        String str = (String) iVar.puc.get("appId");
        final String str2 = (String) iVar.puc.get("localId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                if (bo.getInt(obj.toString(), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            l.a(iVar.uII, false, null, str);
            ab.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVoice:fail_missing arguments", null);
                AppMethodBeat.o(9314);
            } else {
                final AnonymousClass96 anonymousClass96 = new com.tencent.mm.plugin.webview.model.d.b() {
                    public final void b(boolean z, String str, String str2, String str3) {
                        AppMethodBeat.i(9164);
                        ab.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", Boolean.valueOf(z), str2, str);
                        if (!bo.isNullOrNil(str) && str.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                            if (g.this.ehJ != null) {
                                g.this.ehJ.dismiss();
                                g.this.ehJ = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("serverId", str2);
                                g.a(g.this, iVar, "uploadVoice:ok", hashMap);
                            } else {
                                g.a(g.this, iVar, "uploadVoice:fail", null);
                                AppMethodBeat.o(9164);
                                return;
                            }
                        }
                        AppMethodBeat.o(9164);
                    }
                };
                ab.i("MicroMsg.MsgHandler", "doUploadVoice, add cdn upload task result : %b", Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.g.cYE().b(str, str2, anonymousClass96)));
                if (!com.tencent.mm.plugin.webview.modeltools.g.cYE().b(str, str2, anonymousClass96)) {
                    a(iVar, "uploadVoice:fail", null);
                } else if (z) {
                    Context context = this.context;
                    this.context.getString(R.string.tz);
                    this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.g33), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(9165);
                            com.tencent.mm.plugin.webview.modeltools.g.cYE().a(anonymousClass96);
                            com.tencent.mm.plugin.webview.modeltools.g.cYE();
                            com.tencent.mm.plugin.webview.model.aj.yC(str2);
                            g.a(g.this, iVar, "uploadVoice:fail", null);
                            AppMethodBeat.o(9165);
                        }
                    });
                }
                AppMethodBeat.o(9314);
            }
            return true;
        }
        z = true;
        l.a(iVar.uII, false, null, str);
        ab.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
        }
        ab.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVoice:fail_missing arguments", null);
        AppMethodBeat.o(9314);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ag(final i iVar) {
        boolean z;
        AppMethodBeat.i(9315);
        String str = (String) iVar.puc.get("appId");
        final String str2 = (String) iVar.puc.get("serverId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                if (bo.getInt(obj.toString(), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            l.a(iVar.uII, false, null, str);
            ab.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", str, str2, Boolean.valueOf(z));
            if (bo.isNullOrNil(str2)) {
                final AnonymousClass98 anonymousClass98 = new com.tencent.mm.plugin.webview.model.d.b() {
                    public final void b(boolean z, String str, String str2, String str3) {
                        AppMethodBeat.i(9166);
                        ab.i("MicroMsg.MsgHandler", "doDownloadVoice, on cdn finish, is success : %b, local id : %s, media id is : %s", Boolean.valueOf(z), str, str2);
                        if (!bo.isNullOrNil(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                            if (g.this.ehJ != null) {
                                g.this.ehJ.dismiss();
                                g.this.ehJ = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                g.a(g.this, iVar, "downloadVoice:ok", hashMap);
                            } else {
                                g.a(g.this, iVar, "downloadVoice:fail", null);
                                AppMethodBeat.o(9166);
                                return;
                            }
                        }
                        AppMethodBeat.o(9166);
                    }
                };
                com.tencent.mm.plugin.webview.modeltools.g.cYE().a(str, str2, anonymousClass98);
                ab.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", Boolean.TRUE);
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.string.tz);
                    this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.g2_), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(9167);
                            com.tencent.mm.plugin.webview.modeltools.g.cYE().a(anonymousClass98);
                            com.tencent.mm.plugin.webview.modeltools.g.cYE();
                            com.tencent.mm.plugin.webview.model.aj.aet(str2);
                            g.a(g.this, iVar, "downloadVoice:fail", null);
                            AppMethodBeat.o(9167);
                        }
                    });
                }
                AppMethodBeat.o(9315);
            } else {
                a(iVar, "downloadVoice:fail_invaild_serverId", null);
                AppMethodBeat.o(9315);
            }
            return true;
        }
        z = true;
        l.a(iVar.uII, false, null, str);
        ab.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", str, str2, Boolean.valueOf(z));
        if (bo.isNullOrNil(str2)) {
        }
        return true;
    }

    private boolean ah(i iVar) {
        AppMethodBeat.i(9316);
        String str = (String) iVar.puc.get("menuList");
        if (bo.isNullOrNil(str)) {
            a(iVar, "hideMenuItems:param is empty", null);
            AppMethodBeat.o(9316);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.umI.q(3001, bundle);
                a(iVar, "hideMenuItems:ok", null);
                AppMethodBeat.o(9316);
            } catch (JSONException e) {
                ab.w("MicroMsg.MsgHandler", "JSONException : %s", e.getMessage());
                a(iVar, "hideMenuItems:param is empty", null);
                AppMethodBeat.o(9316);
            } catch (RemoteException e2) {
                a(iVar, "hideMenuItems:param is empty", null);
                AppMethodBeat.o(9316);
            }
        }
        return true;
    }

    private boolean ai(i iVar) {
        AppMethodBeat.i(9317);
        String str = (String) iVar.puc.get("menuList");
        if (bo.isNullOrNil(str)) {
            a(iVar, "showMenuItems:param is empty", null);
            AppMethodBeat.o(9317);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.umI.q(3002, bundle);
            } catch (JSONException e) {
                ab.w("MicroMsg.MsgHandler", "JSONException : %s", e.getMessage());
                a(iVar, "showMenuItems:param is empty", null);
                AppMethodBeat.o(9317);
            } catch (RemoteException e2) {
                ab.w("MicroMsg.MsgHandler", "RemoteException : %s", e2.getMessage());
                a(iVar, "showMenuItems:param is empty", null);
            }
            a(iVar, "showMenuItems:ok", null);
            AppMethodBeat.o(9317);
        }
        return true;
    }

    private boolean dcD() {
        AppMethodBeat.i(9318);
        try {
            this.umI.q(3003, null);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doShowOptionMenu, RemoteException : %s", e.getMessage());
        }
        this.eBB = false;
        AppMethodBeat.o(9318);
        return false;
    }

    private boolean dcE() {
        AppMethodBeat.i(9319);
        try {
            this.umI.q(3004, null);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "RemoteException : %s", e.getMessage());
        }
        this.eBB = false;
        AppMethodBeat.o(9319);
        return false;
    }

    private boolean aj(i iVar) {
        AppMethodBeat.i(9320);
        try {
            this.umI.q(3003, null);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "RemoteException : %s", e.getMessage());
            a(iVar, "hideAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "hideAllNonBaseMenuItem:ok", null);
        AppMethodBeat.o(9320);
        return true;
    }

    private boolean ak(i iVar) {
        AppMethodBeat.i(9321);
        try {
            this.umI.q(3004, null);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "RemoteException : %s", e.getMessage());
            a(iVar, "showAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "showAllNonBaseMenuItem:ok", null);
        AppMethodBeat.o(9321);
        return true;
    }

    private boolean al(i iVar) {
        AppMethodBeat.i(9322);
        String str = (String) iVar.puc.get("jsApiList");
        if (bo.isNullOrNil(str)) {
            a(iVar, "checkJsApi:param is empty", null);
            AppMethodBeat.o(9322);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    a(iVar, "checkJsApi:param is empty", null);
                    AppMethodBeat.o(9322);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        boolean z;
                        String string = jSONArray.getString(i);
                        if (com.tencent.mm.protocal.c.akD(string) == null) {
                            if (me.vxh == null) {
                                HashSet hashSet = new HashSet();
                                me.vxh = hashSet;
                                hashSet.add("menu:share:QZone");
                                me.vxh.add("onImageDownloadProgress");
                                me.vxh.add("onVoiceUploadProgress");
                                me.vxh.add("onVoiceDownloadProgress");
                                me.vxh.add("onVoiceRecordEnd");
                                me.vxh.add("onVoicePlayBegin");
                                me.vxh.add("onVoicePlayEnd");
                                me.vxh.add("onLocalImageUploadProgress");
                                me.vxh.add("wxdownload:state_change");
                                me.vxh.add("wxdownload:progress_change");
                                me.vxh.add("hdOnDeviceStateChanged");
                                me.vxh.add("activity:state_change");
                                me.vxh.add("onWXDeviceBluetoothStateChange");
                                me.vxh.add("onWXDeviceLanStateChange");
                                me.vxh.add("onWXDeviceBindStateChange");
                                me.vxh.add("onReceiveDataFromWXDevice");
                                me.vxh.add("onScanWXDeviceResult");
                                me.vxh.add("onWXDeviceStateChange");
                                me.vxh.add("onGetKeyboardHeight");
                                me.vxh.add("onGetSmiley");
                                me.vxh.add("onAddShortcutStatus");
                                me.vxh.add("onMediaFileUploadProgess");
                                me.vxh.add("onGetA8KeyUrl");
                                me.vxh.add("onPageStateChange");
                                me.vxh.add("onGetMsgProofItems");
                                me.vxh.add("onNavigationBarRightButtonClick");
                                me.vxh.add("onBackgroundAudioStateChange");
                                me.vxh.add("onNetWorkChange");
                                me.vxh.add("onCustomGameMenuClicked");
                                me.vxh.add("onArticleReadingBtnClicked");
                                me.vxh.add("onRecordHistory");
                                me.vxh.add("onBeaconsInRange");
                                me.vxh.add("onMiniProgramData");
                            }
                            if (!me.vxh.contains(string)) {
                                z = false;
                                jSONObject.put(string, z);
                            }
                        }
                        z = true;
                        jSONObject.put(string, z);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("checkResult", jSONObject.toString());
                    a(iVar, "checkJsApi:ok", hashMap);
                    AppMethodBeat.o(9322);
                }
            } catch (JSONException e) {
                ab.w("MicroMsg.MsgHandler", "JSONException : %s", e.getMessage());
                a(iVar, "checkJsApi:param is empty", null);
                AppMethodBeat.o(9322);
            }
        }
        return true;
    }

    private boolean am(i iVar) {
        AppMethodBeat.i(9323);
        try {
            int intValue;
            String str = (String) iVar.puc.get("userName");
            try {
                intValue = ((Integer) iVar.puc.get("type")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            a(iVar, "setFreeWifiOwner:ok", null);
            Intent intent = new Intent();
            intent.putExtra("wifi_owner_name", str);
            intent.putExtra("wifi_owner_type", intValue);
            com.tencent.mm.bp.d.c(this.context, "freewifi", ".ui.FreeWifiOwnerUI", intent);
        } catch (Exception e2) {
            ab.w("MicroMsg.MsgHandler", "setFreeWifiOwner, Exception: %s", e2.getMessage());
        }
        AppMethodBeat.o(9323);
        return false;
    }

    private boolean an(i iVar) {
        boolean z;
        AppMethodBeat.i(9324);
        String str = (String) iVar.puc.get("appId");
        final String str2 = (String) iVar.puc.get("localId");
        Object obj = iVar.puc.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bo.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                ab.w("MicroMsg.MsgHandler", "Exception has occured : %s", e.getMessage());
            }
            ab.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", Boolean.valueOf(z));
            l.a(iVar.uII, false, null, str);
            if (!bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", str2, str);
                a(iVar, "translateVoice:fail_missing arguments", null);
                AppMethodBeat.o(9324);
            } else {
                final WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
                if (aex != null) {
                    final i iVar2 = iVar;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(9171);
                            if (z) {
                                g gVar = g.this;
                                Context i = g.this.context;
                                g.this.context.getString(R.string.tz);
                                gVar.ehJ = com.tencent.mm.ui.base.h.b(i, g.this.context.getString(R.string.g32), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(9169);
                                        fq fqVar = new fq();
                                        fqVar.czB.czE = 3;
                                        com.tencent.mm.sdk.b.a.xxA.m(fqVar);
                                        g.a(g.this, iVar2, "translateVoice:fail", null);
                                        AppMethodBeat.o(9169);
                                    }
                                });
                            }
                            final fq fqVar = new fq();
                            fqVar.czB.czD = str2;
                            fqVar.czB.fileName = aex.fileName;
                            fqVar.czB.czE = 0;
                            fqVar.czB.scene = 8;
                            fqVar.czB.czF = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(9170);
                                    if (fqVar.czC.bcU) {
                                        if (g.this.ehJ != null) {
                                            g.this.ehJ.dismiss();
                                            g.this.ehJ = null;
                                        }
                                        if (bo.isNullOrNil(fqVar.czC.content)) {
                                            g.a(g.this, iVar2, "translateVoice:fail", null);
                                            AppMethodBeat.o(9170);
                                            return;
                                        }
                                        Map hashMap = new HashMap();
                                        hashMap.put("translateResult", fqVar.czC.content);
                                        g.a(g.this, iVar2, "translateVoice:ok", hashMap);
                                    }
                                    AppMethodBeat.o(9170);
                                }
                            };
                            com.tencent.mm.sdk.b.a.xxA.m(fqVar);
                            AppMethodBeat.o(9171);
                        }
                    });
                } else {
                    a(iVar, "translateVoice:fail_arguments error", null);
                }
                AppMethodBeat.o(9324);
            }
            return true;
        }
        z = true;
        ab.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", Boolean.valueOf(z));
        l.a(iVar.uII, false, null, str);
        if (bo.isNullOrNil(str)) {
        }
        ab.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", str2, str);
        a(iVar, "translateVoice:fail_missing arguments", null);
        AppMethodBeat.o(9324);
        return true;
    }

    private boolean ao(i iVar) {
        AppMethodBeat.i(9325);
        WWMediaLink wWMediaLink = new WWMediaLink();
        wWMediaLink.thumbUrl = (String) iVar.puc.get("img_url");
        try {
            wWMediaLink.webpageUrl = ar.aek(this.umI.getCurrentUrl());
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            wWMediaLink.webpageUrl = (String) iVar.puc.get("link");
        }
        wWMediaLink.title = (String) iVar.puc.get("title");
        wWMediaLink.description = (String) iVar.puc.get("desc");
        WWAPIFactory.jv(this.context).a(wWMediaLink);
        a(iVar, "shareWeWork:ok", null);
        AppMethodBeat.o(9325);
        return true;
    }

    private boolean ap(i iVar) {
        AppMethodBeat.i(9326);
        if (com.tencent.mm.plugin.webview.stub.a.fq(this.context)) {
            if (this.cEl == null) {
                this.cEl = g(iVar);
            }
            String str = (String) iVar.puc.get("img_url");
            String str2 = (String) iVar.puc.get("title");
            String str3 = (String) iVar.puc.get("desc");
            String string = this.context.getResources().getString(R.string.ru);
            String str4 = (String) iVar.puc.get("link");
            try {
                if (bo.isNullOrNil(str4)) {
                    str4 = this.umI.getCurrentUrl();
                }
            } catch (RemoteException e) {
                ab.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", e.getMessage());
            }
            str4 = ar.aek(str4);
            if (bo.isNullOrNil(str2)) {
                str2 = this.context.getString(R.string.fyo);
            }
            if (bo.isNullOrNil(str4) || bo.isNullOrNil(str2)) {
                ab.w("MicroMsg.MsgHandler", "url(%s) or title(%s) or description(%s) is null or nil.", str4, str2, str3);
                a(iVar, "shareQQ:fail", null);
                AppMethodBeat.o(9326);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(MessengerShareContentUtility.IMAGE_URL, com.tencent.mm.pluginsdk.ui.tools.u.akl(str));
                hashMap.put("title", com.tencent.mm.pluginsdk.ui.tools.u.akl(str2));
                hashMap.put("description", com.tencent.mm.pluginsdk.ui.tools.u.akl(str3));
                hashMap.put("url", com.tencent.mm.pluginsdk.ui.tools.u.akl(str4));
                hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, com.tencent.mm.pluginsdk.ui.tools.u.akl(string));
                hashMap.put("req_type", com.tencent.mm.pluginsdk.ui.tools.u.akl("1"));
                if (iVar.uIJ.equalsIgnoreCase("shareQZone")) {
                    hashMap.put("cflag", com.tencent.mm.pluginsdk.ui.tools.u.akl("1"));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mqqapi://share/to_fri?file_type=news&share_id=1103188687");
                stringBuilder.append("&");
                stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.u.aR(hashMap));
                ab.d("MicroMsg.MsgHandler", "Uri : %s", stringBuilder.toString());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
                intent.putExtra("pkg_name", "com.tencent.mm");
                intent.getStringExtra("pkg_name");
                intent.setFlags(268435456);
                int i = "shareQQ".equals(iVar.uIJ) ? 5 : 6;
                this.uGv.bE(i, (String) iVar.puc.get("use_update_jsapi_data"));
                if (bo.k(this.context, intent) && (this.context instanceof Activity)) {
                    gB(i, 1);
                    ((Activity) this.context).startActivityForResult(intent, 44);
                    a(iVar, iVar.uIJ + ":ok", null);
                } else {
                    gB(i, 2);
                    a(iVar, iVar.uIJ + ":fail", null);
                }
                AppMethodBeat.o(9326);
            }
        } else {
            ab.w("MicroMsg.MsgHandler", "Tencent QQ hasn't installed at all.");
            a(iVar, "shareQQ:fail", null);
            AppMethodBeat.o(9326);
        }
        return true;
    }

    private boolean aq(i iVar) {
        AppMethodBeat.i(9327);
        String str = (String) iVar.puc.get("desc");
        String str2 = (String) iVar.puc.get("img_url");
        String str3 = (String) iVar.puc.get("link");
        try {
            if (bo.isNullOrNil(str3)) {
                str3 = this.umI.getCurrentUrl();
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", e.getMessage());
        }
        str3 = ar.aek(str3);
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.MsgHandler", "link is null or nil.");
            a(iVar, "shareWeiboApp:fail", null);
            AppMethodBeat.o(9327);
        } else {
            if (bo.isNullOrNil(str)) {
                str = ((String) iVar.puc.get("title")) + " " + str3;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(0));
            hashMap.put("openLBS", Integer.valueOf(0));
            hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, com.tencent.mm.pluginsdk.ui.tools.u.akk(str));
            hashMap.put("url", com.tencent.mm.pluginsdk.ui.tools.u.akk(str2));
            hashMap.put("thumbnailurl", com.tencent.mm.pluginsdk.ui.tools.u.akk(str2));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("weibo://t.qq.com/proxy/write"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TencentWeibo://Edit?from=weixin&");
            stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.u.aR(hashMap));
            ab.i("MicroMsg.MsgHandler", "Uri : %s", stringBuilder.toString());
            intent.putExtra("microblog.intent.extra.ACTION", stringBuilder.toString());
            intent.setFlags(268435456);
            if (bo.k(this.context, intent)) {
                this.context.startActivity(intent);
                a(iVar, "shareWeiboApp:ok", null);
            } else {
                a(iVar, "shareWeiboApp:fail", null);
            }
            AppMethodBeat.o(9327);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6 A:{SYNTHETIC, Splitter:B:29:0x00d6} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a9 A:{Catch:{ Exception -> 0x00de }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ar(i iVar) {
        AppMethodBeat.i(9328);
        String str = (String) iVar.puc.get("sessionFrom");
        if (bo.isNullOrNil((String) iVar.puc.get("sessionId"))) {
            a(iVar, "startTempSession:fail_missing arguments", null);
            AppMethodBeat.o(9328);
        } else {
            String str2;
            int intValue;
            int i;
            String format;
            Intent intent;
            if (str != null) {
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
            } else {
                str = null;
            }
            str2 = str;
            Object obj = iVar.puc.get("showType");
            if (obj != null) {
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        intValue = bo.getInt((String) obj, 0);
                    } catch (NumberFormatException e2) {
                        intValue = 0;
                    }
                }
                i = bo.getInt(bo.nullAsNil((String) iVar.puc.get("scene")), 0);
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.uGr.agj(this.umI.getCurrentUrl()), bo.nullAsNil(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", i);
                } else {
                    intent.putExtra("translate_link_scene", 4);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
                AppMethodBeat.o(9328);
            }
            intValue = 0;
            i = bo.getInt(bo.nullAsNil((String) iVar.puc.get("scene")), 0);
            try {
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.uGr.agj(this.umI.getCurrentUrl()), bo.nullAsNil(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            } catch (Exception e3) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                a(iVar, "startTempSession:fail_exception", null);
            }
            AppMethodBeat.o(9328);
        }
        return true;
    }

    private boolean as(i iVar) {
        AppMethodBeat.i(9329);
        try {
            String str = (String) iVar.puc.get("userName");
            String str2 = (String) iVar.puc.get("nickName");
            if (bo.isNullOrNil(str)) {
                a(iVar, "setPageOwner:missing_arguments", null);
                AppMethodBeat.o(9329);
                return false;
            }
            this.umI.hd(str, str2);
            a(iVar, "setPageOwner:ok", null);
            AppMethodBeat.o(9329);
            return false;
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "setPageOwner, Exception: %s", e.getMessage());
        }
    }

    private boolean at(final i iVar) {
        AppMethodBeat.i(9330);
        try {
            String str = (String) iVar.puc.get("appId");
            String str2 = (String) iVar.puc.get("signature");
            l.a(iVar.uII, false, null, str);
            if (bo.isNullOrNil(str)) {
                a(iVar, "get_wechat_verify_ticket:fail ticket", null);
                AppMethodBeat.o(9330);
                return false;
            }
            com.tencent.mm.kernel.g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI, new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(9172);
                    if (i == 0 && i2 == 0) {
                        k kVar = (k) mVar;
                        Map hashMap = new HashMap();
                        hashMap.put("ticket", ((aem) kVar.lty.fsH.fsP).cxb);
                        g.a(g.this, iVar, "get_wechat_verify_ticket:ok ticket", hashMap);
                    } else {
                        ab.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + i + ", errCode = " + i2);
                        g.a(g.this, iVar, "get_wechat_verify_ticket:fail ticket", null);
                    }
                    com.tencent.mm.kernel.g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI, (f) this);
                    AppMethodBeat.o(9172);
                }
            });
            com.tencent.mm.kernel.g.Rg().a(new k(str, str2), 0);
            AppMethodBeat.o(9330);
            return false;
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "getWechatVerifyTicket, Exception: %s", e.getMessage());
        }
    }

    public final boolean au(i iVar) {
        AppMethodBeat.i(9331);
        ab.d("MicroMsg.MsgHandler", "doSelectPedometerSource");
        if (this.context == null || !(this.context instanceof MMActivity)) {
            ab.e("MicroMsg.MsgHandler", "context is null");
            a(iVar, "selectPedometerSource:fail", null);
        } else {
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.b(this.context, "exdevice", ".ui.ExdeviceAddDataSourceUI", new Intent(), 26);
        }
        AppMethodBeat.o(9331);
        return true;
    }

    private Bundle e(String str, int i, Bundle bundle) {
        AppMethodBeat.i(9332);
        try {
            Bundle g = this.umI.g(i, bundle);
            AppMethodBeat.o(9332);
            return g;
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback RemoteException!" + e.toString());
            AppMethodBeat.o(9332);
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:6:0x0051, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(9333);
     */
    /* JADX WARNING: Missing block: B:11:0x00c1, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(9333);
     */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:14:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f(String str, int i, Bundle bundle) {
        int i2 = -1;
        AppMethodBeat.i(9333);
        Bundle e = e(str, i, bundle);
        if (e != null) {
            i2 = e.getInt("status", -1);
        } else {
            ab.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback fail!");
        }
        ab.i("MicroMsg.MsgHandler", "[NFC] " + str + " result status : " + i2);
        switch (i2) {
            case 0:
                a(this.uGd, str + ":nfc_not_support", null);
                break;
            case 1:
                a(this.uGd, str + ":nfc_off", null);
                break;
            case 2:
                a(this.uGd, str + ":disconnect", null);
                break;
            case 3:
                break;
            case 4:
                a(this.uGd, str + ":card_not_support", null);
                break;
            default:
                a(this.uGd, str + ":fail", null);
                break;
        }
    }

    private boolean av(i iVar) {
        AppMethodBeat.i(9334);
        try {
            Bundle g = this.umI.g(ReaderCallback.HIDDEN_BAR, null);
            if (g != null) {
                int i = g.getInt("webview_video_proxy_init");
                ab.i("MicroMsg.MsgHandler", "int webview video proxy : %d", Integer.valueOf(i));
                Map hashMap = new HashMap();
                hashMap.put("videoProxyInitResult", Integer.valueOf(i));
                if (i == 0) {
                    ao cXP = ao.cXP();
                    cXP.umI = this.umI;
                    cXP.hasInit = true;
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(ErrorCode.NEEDDOWNLOAD_3);
                    iDKey.SetKey(0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    iDKey = new IDKey();
                    iDKey.SetID(ErrorCode.NEEDDOWNLOAD_3);
                    iDKey.SetKey(1);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    h.pYm.b(arrayList, false);
                    a(iVar, "videoProxyInit:ok", hashMap);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(ErrorCode.NEEDDOWNLOAD_3);
                    iDKey2.SetKey(0);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(ErrorCode.NEEDDOWNLOAD_3);
                    iDKey2.SetKey(2);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(ErrorCode.NEEDDOWNLOAD_3);
                    iDKey2.SetKey(com.tencent.mm.plugin.webview.ui.tools.b.Jg(i));
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    h.pYm.b(arrayList2, false);
                    a(iVar, "videoProxyInit:fail", hashMap);
                }
                AppMethodBeat.o(9334);
                return false;
            }
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "doinit webview proxy failed : %s", e.getMessage());
        }
        a(iVar, "videoProxyInit:fail", null);
        AppMethodBeat.o(9334);
        return false;
    }

    private boolean aw(i iVar) {
        AppMethodBeat.i(9335);
        if (ao.cXP().hasInit) {
            String str = (String) iVar.puc.get("webviewVideoProxyCdnUrls");
            ab.i("MicroMsg.MsgHandler", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d", str, (String) iVar.puc.get("webviewVideoProxyFileId"), Integer.valueOf(bo.getInt((String) iVar.puc.get("webviewVideoProxyFileSize"), 0)), Integer.valueOf(bo.getInt((String) iVar.puc.get("webviewVideoProxyFileDuration"), 0)), Integer.valueOf(bo.getInt((String) iVar.puc.get("webviewVideoProxyFileType"), 1)));
            if (bo.isNullOrNil(str)) {
                a(iVar, "videoProxyStartPlay:fail_cdnurl_is_null", null);
                AppMethodBeat.o(9335);
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_video_proxy_cdn_urls", str);
                    bundle.putString("webview_video_proxy_fileId", r1);
                    bundle.putInt("webview_video_proxy_file_size", r3);
                    bundle.putInt("webview_video_proxy_file_duration", r4);
                    bundle.putInt("webview_video_proxy_file_type", r2);
                    Bundle g = this.umI.g(ReaderCallback.SHOW_BAR, bundle);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(ErrorCode.NEEDDOWNLOAD_3);
                    iDKey.SetKey(15);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    if (g != null) {
                        int i = g.getInt("webview_video_proxy_play_data_id");
                        str = g.getString("webview_video_proxy_local_url");
                        ab.i("MicroMsg.MsgHandler", "invoke result palyDataId = %d, localUrl = %s", Integer.valueOf(i), str);
                        if (i > 0 && !bo.isNullOrNil(str)) {
                            h.pYm.b(arrayList, false);
                            Map hashMap = new HashMap();
                            hashMap.put("videoProxyPlayDataId", Integer.valueOf(i));
                            hashMap.put("videoProxyPlayLocalUrl", str);
                            a(iVar, "videoProxyStartPlay:ok", hashMap);
                            h.pYm.b(arrayList, false);
                            AppMethodBeat.o(9335);
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "proxy start play failed : %s", e.getMessage());
                }
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(ErrorCode.NEEDDOWNLOAD_3);
                iDKey2.SetKey(16);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                h.pYm.b(arrayList, false);
                a(iVar, "videoProxyStartPlay:fail", null);
                AppMethodBeat.o(9335);
            }
        } else {
            a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
            AppMethodBeat.o(9335);
        }
        return false;
    }

    private boolean ax(i iVar) {
        AppMethodBeat.i(9336);
        if (ao.cXP().hasInit) {
            int i = bo.getInt((String) iVar.puc.get("webviewVideoProxyPlaydataId"), 0);
            if (i > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                try {
                    this.umI.g(ReaderCallback.COPY_SELECT_TEXT, bundle);
                    a(iVar, "videoProxyStopPlay:ok", null);
                    AppMethodBeat.o(9336);
                    return false;
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "webview proxy stop play failed : %s", e.getMessage());
                }
            }
            a(iVar, "videoProxyStopPlay:fail", null);
            AppMethodBeat.o(9336);
            return false;
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        AppMethodBeat.o(9336);
        return true;
    }

    private boolean ay(i iVar) {
        AppMethodBeat.i(9337);
        if (ao.cXP().hasInit) {
            String str = (String) iVar.puc.get("webviewVideoProxyPlayState");
            ab.i("MicroMsg.MsgHandler", "set player state : %s", str);
            if (bo.isNullOrNil(str)) {
                a(iVar, "videoProxySetPlayerState:fail", null);
                AppMethodBeat.o(9337);
                return true;
            }
            int i = bo.getInt(str, 0);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_state", i);
                this.umI.g(ReaderCallback.SEARCH_SELECT_TEXT, bundle);
                a(iVar, "videoProxySetPlayerState:ok", null);
                AppMethodBeat.o(9337);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "set player state failed : %s", e.getMessage());
                a(iVar, "videoProxySetPlayerState:fail", null);
                AppMethodBeat.o(9337);
                return false;
            }
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        AppMethodBeat.o(9337);
        return true;
    }

    private boolean az(i iVar) {
        AppMethodBeat.i(9338);
        if (ao.cXP().hasInit) {
            int i = bo.getInt((String) iVar.puc.get("webviewVideoProxyPlaydataId"), 0);
            int i2 = bo.getInt((String) iVar.puc.get("webviewVideoProxyRemainTime"), 0);
            ab.i("MicroMsg.MsgHandler", "doWebviewProxySetRemainTime, id = %s, time = %s", r0, r1);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                bundle.putInt("webview_video_proxy_play_remain_time", i2);
                this.umI.g(ReaderCallback.SHOW_DIALOG, bundle);
                a(iVar, "videoProxySetRemainTime:ok", null);
                AppMethodBeat.o(9338);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "set remain time faild : %s", e.getMessage());
                a(iVar, "videoProxySetRemainTime:fail", null);
                AppMethodBeat.o(9338);
            }
        } else {
            a(iVar, "videoProxySetRemainTime:fail_has_not_init", null);
            AppMethodBeat.o(9338);
        }
        return false;
    }

    private boolean aA(i iVar) {
        AppMethodBeat.i(9339);
        if (ao.cXP().hasInit) {
            String str = (String) iVar.puc.get("webviewVideoProxyPlaydataId");
            ab.i("MicroMsg.MsgHandler", "doWebviewProxyPreload, playDataId = %s, duration = %d", str, Integer.valueOf(bo.getInt((String) iVar.puc.get("webviewVideoProxyPreloadTime"), 0)));
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MsgHandler", "playDataId is null or nil");
                a(iVar, "videoProxyPreload:fail_invaild_play_data_id", null);
                AppMethodBeat.o(9339);
            } else {
                try {
                    int i = bo.getInt(str, 0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("webview_video_proxy_play_data_id", i);
                    bundle.putInt("webview_video_proxy_preload_duration", r1);
                    ab.i("MicroMsg.MsgHandler", "preload video result = %d", Integer.valueOf(this.umI.g(5007, bundle).getInt("webview_video_proxy_pre_load_result")));
                    if (this.umI.g(5007, bundle).getInt("webview_video_proxy_pre_load_result") == 0) {
                        a(iVar, "videoProxyPreload:ok", null);
                    } else {
                        a(iVar, "videoProxyPreload:fail", null);
                    }
                    AppMethodBeat.o(9339);
                } catch (Exception e) {
                    a(iVar, "videoProxyPreload:fail", null);
                    AppMethodBeat.o(9339);
                }
            }
        } else {
            a(iVar, "videoProxyPreload:fail_has_not_init", null);
            AppMethodBeat.o(9339);
        }
        return false;
    }

    public final void K(int i, String str, String str2) {
        AppMethodBeat.i(9340);
        c JN = JN(i);
        if (JN == null) {
            ab.i("MicroMsg.MsgHandler", "onWebViewCacheCallback, get null MsgWrapperBin, may be the webview called cache api has been closed.");
            AppMethodBeat.o(9340);
            return;
        }
        i iVar = JN.uGd;
        JO(i);
        if (!bo.nullAsNil(str2).equalsIgnoreCase("ok")) {
            int a = q.a(iVar);
            if (-1 != a) {
                com.tencent.mm.plugin.webview.modelcache.n.IO(a);
            }
        }
        if (this.umI != null) {
            a(this.umI, iVar, String.format("%s:%s", new Object[]{str, str2}), null, false, true);
        }
        AppMethodBeat.o(9340);
    }

    private boolean aB(i iVar) {
        Throwable e;
        Object obj;
        AppMethodBeat.i(9341);
        String str = (String) iVar.puc.get("actionKey");
        String str2 = (String) iVar.puc.get("actionValue");
        ab.i("MicroMsg.MsgHandler", "doReportActionInfo, actionKey =  %s, actionValue =  %s", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue is null");
            a(iVar, "reportActionInfo:fail", null);
            AppMethodBeat.o(9341);
            return true;
        } else if (str.length() <= 0 || str.length() > 32 || str2.length() <= 0 || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            ab.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue size is bad");
            a(iVar, "reportActionInfo:fail", null);
            AppMethodBeat.o(9341);
            return true;
        } else {
            String str3 = " ";
            String str4 = " ";
            String str5 = " ";
            try {
                Bundle g = this.umI.g(77, null);
                if (g != null) {
                    str3 = bo.nullAsNil(g.getString("KSessionId"));
                    str4 = bo.nullAsNil(g.getString("KUserAgent"));
                    str5 = bo.nullAsNil(g.getString("KUrl"));
                    if (TextUtils.isEmpty(str5)) {
                        ab.e("MicroMsg.MsgHandler", "doReportActionInfo, url is empty");
                        a(iVar, "reportActionInfo:fail", null);
                        AppMethodBeat.o(9341);
                        return true;
                    }
                    ab.i("MicroMsg.MsgHandler", "doReportActionInfo, sessionId %s, userAgent %s, url %s", str3, str4, str5);
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgHandler", "get sessionId error, %s", e2);
            }
            if (TextUtils.isEmpty(bK(str5))) {
                ab.e("MicroMsg.MsgHandler", "doReportActionInfo, appId is empty");
                a(iVar, "reportActionInfo:fail", null);
                AppMethodBeat.o(9341);
                return true;
            }
            ab.i("MicroMsg.MsgHandler", "doReportActionInfo, appId %s", bK(str5));
            int i = 0;
            if (at.isConnected(this.context)) {
                if (at.isWifi(this.context)) {
                    i = 1;
                } else if (at.is4G(this.context)) {
                    i = 4;
                } else if (at.is3G(this.context)) {
                    i = 3;
                } else if (at.is2G(this.context)) {
                    i = 2;
                }
                ab.i("MicroMsg.MsgHandler", "doReportActionInfo, get networkType %d", Integer.valueOf(i));
            }
            long anT = bo.anT();
            ab.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Integer.valueOf(13379), Long.valueOf(anT), r10, Integer.valueOf(i), str4, str5, str3, str, str2);
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str6 = URLEncoder.encode(bo.nullAsNil(str4), "UTF-8");
                str4 = URLEncoder.encode(str5, "UTF-8");
                try {
                    str5 = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e3) {
                    e = e3;
                    str2 = str8;
                }
                try {
                    str = URLEncoder.encode(str2, "UTF-8");
                    obj = str5;
                } catch (UnsupportedEncodingException e4) {
                    e = e4;
                    str2 = str5;
                    ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    str = str9;
                    h.pYm.e(13379, Long.valueOf(anT), r10, Integer.valueOf(i), str6, str4, str3, obj, str);
                    a(iVar, "reportActionInfo:ok", null);
                    AppMethodBeat.o(9341);
                    return true;
                }
            } catch (UnsupportedEncodingException e5) {
                e = e5;
                obj = str8;
                str4 = str7;
            }
            h.pYm.e(13379, Long.valueOf(anT), r10, Integer.valueOf(i), str6, str4, str3, obj, str);
            a(iVar, "reportActionInfo:ok", null);
            AppMethodBeat.o(9341);
            return true;
        }
    }

    private boolean aC(i iVar) {
        AppMethodBeat.i(9342);
        int a = q.a(iVar);
        if (-1 == a) {
            a(this.umI, iVar, "cache:fail", null, true, false);
            AppMethodBeat.o(9342);
            return true;
        }
        int i = -1;
        if (2 == a) {
            i = 2;
        } else if (1 == a) {
            i = 1;
        }
        if (-1 != i) {
            h.pYm.a(238, (long) i, 1, false);
        }
        com.tencent.mm.plugin.webview.modelcache.c.cYl();
        ab.i("MicroMsg.MsgHandler", "user not in white list");
        com.tencent.mm.plugin.webview.modelcache.n.IO(a);
        a(this.umI, iVar, "cache:not in white list", null, true, false);
        AppMethodBeat.o(9342);
        return true;
    }

    private boolean aD(i iVar) {
        AppMethodBeat.i(9343);
        ab.i("MicroMsg.MsgHandler", "doAddCustomMenuItems start");
        int i;
        if (iVar.puc.containsKey("hideMenu")) {
            i = bo.getInt((String) iVar.puc.get("hideMenu"), 0);
            ab.e("MicroMsg.MsgHandler", "doAddCustomMenuItems hideMenu=".concat(String.valueOf(i)));
            if (od(i == 1)) {
                a(iVar, "doAddCustomMenuItems:ok", null);
            } else {
                a(iVar, "doAddCustomMenuItems:fail", null);
            }
            AppMethodBeat.o(9343);
        } else {
            od(false);
            String str = (String) iVar.puc.get("itemList");
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MsgHandler", "doAddCustomMenuItems fail: key or title must not be null");
                a(iVar, "doAddCustomMenuItems:params error", null);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("key");
                            String optString2 = optJSONObject.optString("title");
                            if (bo.isNullOrNil(optString) || bo.isNullOrNil("title")) {
                                ab.e("MicroMsg.MsgHandler", "key or title is null,ignore item: ".concat(String.valueOf(i)));
                            } else {
                                arrayList.add(optString);
                                arrayList2.add(optString2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("keys", arrayList);
                        bundle.putStringArrayList("titles", arrayList2);
                        try {
                            this.umI.X(bundle);
                            a(iVar, "doAddCustomMenuItems:ok", null);
                        } catch (RemoteException e) {
                            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                            ab.e("MicroMsg.MsgHandler", "doAddCustomMenuItems:fail");
                            a(iVar, "doAddCustomMenuItems:fail", null);
                        }
                    }
                } catch (JSONException e2) {
                    ab.e("MicroMsg.MsgHandler", "doAddCustomMenuItems eroor, parse itemList to jsonarray error");
                    a(iVar, "doAddCustomMenuItems:params parse error", null);
                    AppMethodBeat.o(9343);
                }
            }
            AppMethodBeat.o(9343);
        }
        return true;
    }

    private boolean aE(i iVar) {
        AppMethodBeat.i(9344);
        String str = (String) iVar.puc.get("key");
        if (bo.isNullOrNil(str)) {
            a(iVar, "getLocalData:fail_key_is_null", null);
            AppMethodBeat.o(9344);
        } else {
            try {
                String currentUrl = this.umI.getCurrentUrl();
                String str2 = new String(Base64.encode(str.getBytes(), 0));
                str = this.uGr.agj(currentUrl);
                am cYI = com.tencent.mm.plugin.webview.modeltools.g.cYI();
                String anB = bo.anB(currentUrl);
                ab.i("MicroMsg.WebViewLocalDataStorage", "get value by key = %s, appid = %s, domin = %s", str2, str, anB);
                if (bo.isNullOrNil(str2) || bo.isNullOrNil(str) || bo.isNullOrNil(currentUrl) || bo.isNullOrNil(anB)) {
                    str = null;
                } else {
                    str = "select value from WebviewLocalData where recordId = ".concat(String.valueOf(am.au(str, anB, str2)));
                    ab.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = cYI.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        ab.e("MicroMsg.WebViewLocalDataStorage", "get cursor is null");
                        str = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            str = rawQuery.getString(0);
                        } else {
                            str = null;
                        }
                        rawQuery.close();
                        ab.i("MicroMsg.WebViewLocalDataStorage", "get value : %s for key : %s", str, str2);
                    }
                }
                if (bo.isNullOrNil(str)) {
                    a(iVar, "getLocalData:fail", null);
                    AppMethodBeat.o(9344);
                } else {
                    String str3 = new String(Base64.decode(str.getBytes(), 0));
                    Map hashMap = new HashMap();
                    hashMap.put("data", str3);
                    ab.i("MicroMsg.MsgHandler", "get local data, key = %s, value = %s", str2, str3);
                    a(iVar, "getLocalData:ok", hashMap);
                    AppMethodBeat.o(9344);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "get url failed : %s", e.getMessage());
                a(iVar, "getLocalData:fail", null);
                AppMethodBeat.o(9344);
            }
        }
        return true;
    }

    private boolean aF(i iVar) {
        AppMethodBeat.i(9345);
        String str = (String) iVar.puc.get("key");
        String str2 = (String) iVar.puc.get("data");
        ab.i("MicroMsg.MsgHandler", "set local data, key = %s, data = %s", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            a(iVar, "setLocalData:fail_param_should_not_null", null);
            AppMethodBeat.o(9345);
            return true;
        } else if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            a(iVar, "setLocalData:fail_param_lenght_too_long", null);
            AppMethodBeat.o(9345);
            return true;
        } else {
            try {
                Object obj;
                String currentUrl = this.umI.getCurrentUrl();
                byte[] encode = Base64.encode(str.getBytes(), 0);
                byte[] encode2 = Base64.encode(str2.getBytes(), 0);
                String str3 = new String(encode);
                String str4 = new String(encode2);
                str2 = this.uGr.agj(currentUrl);
                am cYI = com.tencent.mm.plugin.webview.modeltools.g.cYI();
                String anB = bo.anB(currentUrl);
                ab.i("MicroMsg.WebViewLocalDataStorage", "set data, key = %s, value = %s, url = %s, appId = %s, domin = %s", str3, str4, currentUrl, str2, anB);
                if (bo.isNullOrNil(str3) || bo.isNullOrNil(currentUrl) || bo.isNullOrNil(str2) || bo.isNullOrNil(anB)) {
                    obj = "fail_params_invalid";
                } else {
                    int au = am.au(str2, anB, str3);
                    str = "select count(*) from WebviewLocalData where appId = '" + str2 + "' and domin = '" + anB + "'";
                    ab.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = cYI.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            ab.i("MicroMsg.WebViewLocalDataStorage", "now count = %d", Integer.valueOf(rawQuery.getInt(0)));
                            rawQuery.close();
                            if (rawQuery.getInt(0) >= 5) {
                                obj = "fail_exceed_max_count";
                            } else {
                                rawQuery = cYI.rawQuery("select count(*) from WebviewLocalData where recordId =".concat(String.valueOf(au)), new String[0]);
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        ab.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, count = %d", r7, Integer.valueOf(rawQuery.getInt(0)));
                                        rawQuery.close();
                                        if (rawQuery.getInt(0) > 0) {
                                            ab.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, ret = %b", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + au, Boolean.valueOf(cYI.hY("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + au)));
                                            if (cYI.hY("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + au)) {
                                                obj = "ok";
                                            } else {
                                                obj = "fail";
                                            }
                                        }
                                    }
                                    rawQuery.close();
                                }
                            }
                        }
                        rawQuery.close();
                    }
                    com.tencent.mm.plugin.webview.model.al alVar = new com.tencent.mm.plugin.webview.model.al();
                    alVar.field_appId = str2;
                    alVar.field_domin = anB;
                    alVar.field_key = str3;
                    alVar.field_value = str4;
                    alVar.field_recordId = au;
                    ab.i("MicroMsg.WebViewLocalDataStorage", "insert data, ret = %b", Boolean.valueOf(cYI.b((com.tencent.mm.sdk.e.c) alVar)));
                    obj = "ok";
                }
                ab.i("MicroMsg.MsgHandler", "doSetLocalData retValue = %s", obj);
                a(iVar, "setLocalData:".concat(String.valueOf(obj)), null);
                AppMethodBeat.o(9345);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "get url failed : %s", e.getMessage());
                a(iVar, "setLocalData:fail", null);
                AppMethodBeat.o(9345);
                return true;
            }
        }
    }

    private boolean aG(i iVar) {
        AppMethodBeat.i(9346);
        try {
            Object obj;
            String currentUrl = this.umI.getCurrentUrl();
            am cYI = com.tencent.mm.plugin.webview.modeltools.g.cYI();
            String agj = this.uGr.agj(currentUrl);
            String anB = bo.anB(currentUrl);
            ab.i("MicroMsg.WebViewLocalDataStorage", "appid = %s, url = %s, domin = %s", agj, currentUrl, anB);
            if (bo.isNullOrNil(agj) || bo.isNullOrNil(currentUrl) || bo.isNullOrNil(anB)) {
                obj = "fail";
            } else {
                if (cYI.hY("WebviewLocalData", "delete from WebviewLocalData where appId = '" + agj + "' and domin = '" + anB + "'")) {
                    obj = "ok";
                } else {
                    obj = "fail";
                }
            }
            ab.i("MicroMsg.MsgHandler", "doClearLocalData retValue = %s", obj);
            a(iVar, "clearLocalData:".concat(String.valueOf(obj)), null);
            AppMethodBeat.o(9346);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "get url failed : %s", e.getMessage());
            a(iVar, "clearLocalData:fail", null);
            AppMethodBeat.o(9346);
        }
        return true;
    }

    private boolean aH(final i iVar) {
        String currentUrl;
        AppMethodBeat.i(9347);
        String str = (String) iVar.puc.get("useridlist");
        String str2 = (String) iVar.puc.get("chatname");
        final String str3 = (String) iVar.puc.get("chatscene");
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = null;
        }
        currentUrl = bo.nullAsNil(this.uGr.agj(currentUrl));
        LinkedList linkedList = new LinkedList();
        String[] split = str.split(";");
        if (split == null || split.length <= 0) {
            a(iVar, "openEnterpriseChat:fail", null);
            AppMethodBeat.o(9347);
            return false;
        }
        for (Object add : split) {
            linkedList.add(add);
        }
        com.tencent.mm.aj.z.aeZ();
        com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.aj.a.t(currentUrl, str2, linkedList, new com.tencent.mm.aj.n() {
            public final void a(int i, m mVar) {
                AppMethodBeat.i(9183);
                if (i != 0) {
                    g.a(g.this, iVar, "openEnterpriseChat:fail", null);
                    AppMethodBeat.o(9183);
                    return;
                }
                auq afo = ((com.tencent.mm.aj.a.t) mVar).afo();
                String str;
                if (afo != null && afo.vNh != null && afo.vNh.ret == 0) {
                    str = afo.vNb;
                    String str2 = ((com.tencent.mm.aj.a.t) mVar).fye;
                    if (str2 == null) {
                        g.a(g.this, iVar, "openEnterpriseChat:fail", null);
                        AppMethodBeat.o(9183);
                        return;
                    }
                    com.tencent.mm.aj.a.c rq = com.tencent.mm.aj.z.aeT().rq(str2);
                    if (rq == null || bo.isNullOrNil(str)) {
                        g.a(g.this, iVar, "openEnterpriseChat:fail", null);
                        AppMethodBeat.o(9183);
                        return;
                    }
                    Intent intent;
                    if (bo.isNullOrNil(str3) || !str3.equals("long")) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("key_biz_chat_id", rq.field_bizChatLocalId);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.bp.d.f(g.this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                        intent.putExtra("Main_User", str);
                        intent.putExtra("biz_chat_chat_id", rq.field_bizChatLocalId);
                        intent.putExtra("biz_chat_from_scene", 8);
                        com.tencent.mm.bp.d.f(g.this.context, ".ui.LauncherUI", intent);
                    }
                    Map hashMap = new HashMap();
                    if (!(bo.isNullOrNil(afo.wbP) || bo.isNullOrNil(afo.wbQ))) {
                        hashMap.put("chat_type", afo.wbP);
                        hashMap.put("chat_id", afo.wbQ);
                    }
                    g.a(g.this, iVar, "openEnterpriseChat:ok", hashMap);
                    AppMethodBeat.o(9183);
                } else if (afo == null || afo.vNh == null) {
                    g.a(g.this, iVar, "openEnterpriseChat:fail", null);
                    AppMethodBeat.o(9183);
                } else {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("err_code", Integer.valueOf(afo.vNh.ret));
                    str = "openEnterpriseChat:fail";
                    if (afo.vNh.cyF != null) {
                        str = afo.vNh.cyF;
                    }
                    g.a(g.this, iVar, str, hashMap2);
                    AppMethodBeat.o(9183);
                }
            }
        }), 0);
        AppMethodBeat.o(9347);
        return true;
    }

    private boolean aI(final i iVar) {
        String currentUrl;
        AppMethodBeat.i(9348);
        String str = (String) iVar.puc.get("chatId");
        String str2 = (String) iVar.puc.get("chatType");
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = null;
        }
        currentUrl = bo.nullAsNil(this.uGr.agj(currentUrl));
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(currentUrl)) {
            a(iVar, "enterEnterpriseChat:fail_params error", null);
            AppMethodBeat.o(9348);
        } else {
            com.tencent.mm.aj.z.aeZ();
            com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.aj.a.m(currentUrl, str, str2, new com.tencent.mm.aj.n() {
                public final void a(int i, m mVar) {
                    AppMethodBeat.i(9184);
                    if (i != 0) {
                        g.a(g.this, iVar, "enterEnterpriseChat:fail", null);
                        AppMethodBeat.o(9184);
                        return;
                    }
                    uh afl = ((com.tencent.mm.aj.a.m) mVar).afl();
                    String str = "enterEnterpriseChat:fail";
                    if (i < 0) {
                        if (!(afl == null || afl.vNh == null || !bo.isNullOrNil(afl.vNh.cyF))) {
                            str = "enterEnterpriseChat:fail_" + afl.vNh.cyF;
                        }
                        g.a(g.this, iVar, str, null);
                        AppMethodBeat.o(9184);
                        return;
                    }
                    String str2 = afl.vNb;
                    String str3 = ((com.tencent.mm.aj.a.m) mVar).fye;
                    if (str3 == null) {
                        g.a(g.this, iVar, "enterEnterpriseChat:fail", null);
                        AppMethodBeat.o(9184);
                        return;
                    }
                    com.tencent.mm.aj.a.c rq = com.tencent.mm.aj.z.aeT().rq(str3);
                    if (rq == null || bo.isNullOrNil(str2)) {
                        g.a(g.this, iVar, str, null);
                        AppMethodBeat.o(9184);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    intent.putExtra("key_biz_chat_id", rq.field_bizChatLocalId);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("key_need_send_video", false);
                    intent.putExtra("key_is_biz_chat", true);
                    com.tencent.mm.bp.d.f(g.this.context, ".ui.chatting.ChattingUI", intent);
                    g.a(g.this, iVar, "enterEnterpriseChat:ok", null);
                    AppMethodBeat.o(9184);
                }
            }), 0);
            AppMethodBeat.o(9348);
        }
        return true;
    }

    private boolean aJ(final i iVar) {
        AppMethodBeat.i(9349);
        try {
            String nullAsNil = bo.nullAsNil(this.uGr.agj(this.umI.getCurrentUrl()));
            if (bo.isNullOrNil(nullAsNil)) {
                a(iVar, "getEnterpriseChat:fail", null);
                AppMethodBeat.o(9349);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
                bundle = this.umI.g(71, bundle);
                String string = bundle.getString("enterprise_context_biz");
                String fD = com.tencent.mm.aj.a.e.fD(bundle.getLong("enterprise_context_bizchatid", -1));
                if (bo.isNullOrNil(string) || bo.isNullOrNil(fD)) {
                    a(iVar, "getEnterpriseChat:fail_not in enterprise chat", null);
                    AppMethodBeat.o(9349);
                } else {
                    AnonymousClass109 anonymousClass109 = new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            afy afy;
                            String str2;
                            int i3 = -1;
                            AppMethodBeat.i(9185);
                            com.tencent.mm.aj.t.b(this);
                            String str3 = "getEnterpriseChat:fail";
                            if (i == 0 && i2 == 0) {
                                com.tencent.mm.aj.t tVar = (com.tencent.mm.aj.t) mVar;
                                if (tVar.ehh == null || tVar.ehh.fsH.fsP == null) {
                                    afy = null;
                                } else {
                                    afy = (afy) tVar.ehh.fsH.fsP;
                                }
                                if (afy == null || afy.vNh == null) {
                                    str2 = str3;
                                } else {
                                    i3 = afy.vNh.ret;
                                    if (afy.vNh.cyF == null || afy.vNh.cyF.length() <= 0) {
                                        str2 = str3;
                                    } else {
                                        str2 = "getEnterpriseChat:fail_" + afy.vNh.cyF;
                                    }
                                }
                            } else {
                                str2 = str3;
                                afy = null;
                            }
                            if (i3 != 0) {
                                g.a(g.this, iVar, str2, null);
                                AppMethodBeat.o(9185);
                                return;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("result", afy.result);
                            g.a(g.this, iVar, "getEnterpriseChat:ok", hashMap);
                            AppMethodBeat.o(9185);
                        }
                    };
                    com.tencent.mm.aj.t.a(anonymousClass109);
                    if (!com.tencent.mm.aj.t.o(nullAsNil, string, fD)) {
                        com.tencent.mm.aj.t.b(anonymousClass109);
                        a(iVar, "getEnterpriseChat:fail", null);
                    }
                    AppMethodBeat.o(9349);
                }
            }
        } catch (Exception e) {
            a(iVar, "getEnterpriseChat:fail", null);
        }
        return true;
    }

    private boolean aK(final i iVar) {
        String currentUrl;
        AppMethodBeat.i(9350);
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = null;
        }
        String nullAsNil = bo.nullAsNil(this.uGr.agj(currentUrl));
        if (bo.isNullOrNil(nullAsNil)) {
            a(iVar, "openEnterpriseContact:fail", null);
        }
        final m mVar = new com.tencent.mm.plugin.webview.model.m(nullAsNil, currentUrl, iVar.puc);
        com.tencent.mm.kernel.g.Rg().a(1393, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                afw cXw;
                int i3 = -1;
                AppMethodBeat.i(9186);
                if (g.this.ehJ != null && g.this.ehJ.isShowing()) {
                    g.this.ehJ.dismiss();
                    g.this.ehJ = null;
                }
                com.tencent.mm.kernel.g.Rg().b(1393, (f) this);
                String str2 = "openEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    cXw = ((com.tencent.mm.plugin.webview.model.m) mVar).cXw();
                    if (!(cXw == null || cXw.vNh == null)) {
                        i3 = cXw.vNh.ret;
                        if (cXw.vNh.cyF != null && cXw.vNh.cyF.length() > 0) {
                            str2 = cXw.vNh.cyF;
                        }
                    }
                } else {
                    cXw = null;
                }
                if (i3 != 0) {
                    g.a(g.this, iVar, str2, null);
                    AppMethodBeat.o(9186);
                    return;
                }
                str2 = cXw.vGi;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) g.this.context).ifE = this;
                com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent, 31);
                AppMethodBeat.o(9186);
            }
        });
        com.tencent.mm.kernel.g.Rg().a(mVar, 0);
        Context context = this.context;
        this.context.getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(9187);
                com.tencent.mm.kernel.g.Rg().c(mVar);
                AppMethodBeat.o(9187);
            }
        });
        AppMethodBeat.o(9350);
        return true;
    }

    private boolean aL(final i iVar) {
        String currentUrl;
        AppMethodBeat.i(9351);
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = null;
        }
        String nullAsNil = bo.nullAsNil(this.uGr.agj(currentUrl));
        if (bo.isNullOrNil(nullAsNil)) {
            a(iVar, "selectEnterpriseContact:fail", null);
        }
        iVar.puc.put("groupId", "");
        iVar.puc.put(Param.TIMESTAMP, "");
        iVar.puc.put("nonceStr", "");
        iVar.puc.put("signature", "");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray((String) iVar.puc.get("type"));
            jSONObject.put("fromDepartmentId", bo.ank((String) iVar.puc.get("fromDepartmentId")));
            jSONObject.put("mode", (String) iVar.puc.get("mode"));
            jSONObject.put("type", jSONArray);
            String str = (String) iVar.puc.get("selectedDepartmentIds");
            if (str != null) {
                jSONObject.put("selectedDepartmentIds", new JSONArray(str));
            }
            str = (String) iVar.puc.get("selectedUserIds");
            if (str != null) {
                jSONObject.put("selectedUserIds", new JSONArray(str));
            }
            iVar.puc.put("params", jSONObject);
        } catch (JSONException e2) {
            ab.e("MicroMsg.MsgHandler", "doSelectEnterpriseContact ex: %s", e2.getMessage());
        } catch (NumberFormatException e3) {
            ab.e("MicroMsg.MsgHandler", "doSelectEnterpriseContact ex: %s", e3.getMessage());
        }
        final m mVar = new com.tencent.mm.plugin.webview.model.m(nullAsNil, currentUrl, iVar.puc);
        final f anonymousClass112 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                afw cXw;
                int i3 = -1;
                AppMethodBeat.i(9188);
                if (g.this.ehJ != null && g.this.ehJ.isShowing()) {
                    g.this.ehJ.dismiss();
                    g.this.ehJ = null;
                }
                com.tencent.mm.kernel.g.Rg().b(1393, (f) this);
                String str2 = "selectEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    cXw = ((com.tencent.mm.plugin.webview.model.m) mVar).cXw();
                    if (!(cXw == null || cXw.vNh == null)) {
                        i3 = cXw.vNh.ret;
                        if (cXw.vNh.cyF != null && cXw.vNh.cyF.length() > 0) {
                            str2 = cXw.vNh.cyF;
                        }
                    }
                } else {
                    cXw = null;
                }
                if (i3 != 0) {
                    g.a(g.this, iVar, str2, null);
                    AppMethodBeat.o(9188);
                    return;
                }
                str2 = cXw.vGi;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) g.this.context).ifE = this;
                com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent, 53);
                AppMethodBeat.o(9188);
            }
        };
        com.tencent.mm.kernel.g.Rg().a(1393, anonymousClass112);
        com.tencent.mm.kernel.g.Rg().a(mVar, 0);
        Context context = this.context;
        this.context.getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(9189);
                com.tencent.mm.kernel.g.Rg().c(mVar);
                com.tencent.mm.kernel.g.Rg().b(1393, anonymousClass112);
                AppMethodBeat.o(9189);
            }
        });
        AppMethodBeat.o(9351);
        return true;
    }

    private boolean aM(i iVar) {
        AppMethodBeat.i(9352);
        if (this.umI == null) {
            a(iVar, "sendEnterpriseChat:fail", null);
            AppMethodBeat.o(9352);
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
            bundle = this.umI.g(71, bundle);
            final String string = bundle.getString("enterprise_context_biz");
            final long j = bundle.getLong("enterprise_context_bizchatid", -1);
            if (bo.isNullOrNil(string) || j < 0) {
                a(iVar, "sendEnterpriseChat:fail_not in enterprise chat", null);
                AppMethodBeat.o(9352);
                return true;
            }
            String str = (String) iVar.puc.get("type");
            if ("text".equals(str)) {
                boolean a = a(iVar, string, j);
                AppMethodBeat.o(9352);
                return a;
            } else if ("link".equals(str)) {
                JSONObject jSONObject = new JSONObject((String) iVar.puc.get("data"));
                str = jSONObject.optString("link");
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("desc");
                final String optString3 = jSONObject.optString("imgUrl");
                if (bo.isNullOrNil(optString) && bo.isNullOrNil(optString2)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    AppMethodBeat.o(9352);
                    return true;
                } else if (bo.isNullOrNil(str)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    AppMethodBeat.o(9352);
                    return true;
                } else {
                    String str2;
                    WXWebpageObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = str;
                    this.cEl = new WXMediaMessage();
                    this.cEl.mediaObject = wXWebpageObject;
                    this.cEl.title = optString;
                    this.cEl.description = optString2;
                    str = (String) iVar.puc.get("appid");
                    if (this.uGh == null || !TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = this.uGh.getString("jsapi_args_appid");
                    }
                    final com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str2, true);
                    if (this.context == null || this.context.getResources() == null) {
                        ab.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        AppMethodBeat.o(9352);
                        return true;
                    } else if (this.context instanceof Activity) {
                        final i iVar2 = iVar;
                        com.tencent.mm.pluginsdk.ui.applet.t.a.vlq.a(((MMActivity) this.context).mController, optString, optString3, optString2, true, this.context.getResources().getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                            public final void a(boolean z, final String str, int i) {
                                AppMethodBeat.i(9192);
                                if (!z) {
                                    g.a(g.this, iVar2, "sendEnterpriseChat:cancel", null);
                                    AppMethodBeat.o(9192);
                                } else if (bo.isNullOrNil(optString3)) {
                                    com.tencent.mm.aj.a.c aK = com.tencent.mm.aj.z.aeT().aK(j);
                                    synchronized (com.tencent.mm.aj.a.e.fxC) {
                                        try {
                                            String aae = com.tencent.mm.aj.a.e.aae();
                                            com.tencent.mm.aj.a.e.d(aK);
                                            g.a(g.this, bT, str2, string, optString3, null, null, str, null);
                                            com.tencent.mm.aj.a.e.rx(aae);
                                        } catch (Throwable th) {
                                            while (true) {
                                                AppMethodBeat.o(9192);
                                            }
                                        }
                                    }
                                    g.a(g.this, iVar2, "sendEnterpriseChat:ok", null);
                                    if (g.this.context != null) {
                                        com.tencent.mm.ui.base.h.bQ(g.this.context, g.this.context.getResources().getString(R.string.to));
                                    }
                                    AppMethodBeat.o(9192);
                                } else {
                                    com.tencent.mm.at.o.ahk().a(optString3, new com.tencent.mm.at.c.c() {
                                        public final void C(Bitmap bitmap) {
                                            AppMethodBeat.i(9191);
                                            if (g.this.nBv != null) {
                                                g.this.nBv.dismiss();
                                            }
                                            com.tencent.mm.aj.a.c aK = com.tencent.mm.aj.z.aeT().aK(j);
                                            synchronized (com.tencent.mm.aj.a.e.fxC) {
                                                try {
                                                    String aae = com.tencent.mm.aj.a.e.aae();
                                                    com.tencent.mm.aj.a.e.d(aK);
                                                    g.a(g.this, bT, str2, string, optString3, null, null, str, null);
                                                    com.tencent.mm.aj.a.e.rx(aae);
                                                } catch (Throwable th) {
                                                    while (true) {
                                                        AppMethodBeat.o(9191);
                                                    }
                                                }
                                            }
                                            g.a(g.this, iVar2, "sendEnterpriseChat:ok", null);
                                            if (g.this.context != null) {
                                                com.tencent.mm.ui.base.h.bQ(g.this.context, g.this.context.getResources().getString(R.string.to));
                                            }
                                            AppMethodBeat.o(9191);
                                        }
                                    });
                                    AppMethodBeat.o(9192);
                                }
                            }
                        });
                        AppMethodBeat.o(9352);
                        return true;
                    } else {
                        ab.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        AppMethodBeat.o(9352);
                        return true;
                    }
                }
            } else {
                a(iVar, "sendEnterpriseChat:fail_params error", null);
                AppMethodBeat.o(9352);
                return true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", e.getMessage());
            a(iVar, "sendEnterpriseChat:fail", null);
            AppMethodBeat.o(9352);
            return true;
        }
    }

    private boolean a(i iVar, String str, long j) {
        AppMethodBeat.i(9353);
        String optString = new JSONObject((String) iVar.puc.get("data")).optString(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
        if (bo.isNullOrNil(optString)) {
            a(iVar, "sendEnterpriseChat:fail_params error", null);
            AppMethodBeat.o(9353);
        } else {
            boolean m;
            com.tencent.mm.aj.a.c aK = com.tencent.mm.aj.z.aeT().aK(j);
            synchronized (com.tencent.mm.aj.a.e.fxC) {
                try {
                    String aae = com.tencent.mm.aj.a.e.aae();
                    com.tencent.mm.aj.a.e.d(aK);
                    qb qbVar = new qb();
                    qbVar.cMq.cMr = str;
                    qbVar.cMq.content = optString;
                    qbVar.cMq.type = t.nK(str);
                    qbVar.cMq.flags = 0;
                    m = com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                    com.tencent.mm.aj.a.e.rx(aae);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(9353);
                }
            }
            if (m) {
                a(iVar, "sendEnterpriseChat:ok", null);
                if (this.context != null) {
                    com.tencent.mm.ui.base.h.bQ(this.context, this.context.getResources().getString(R.string.to));
                }
                AppMethodBeat.o(9353);
            } else {
                a(iVar, "sendEnterpriseChat:fail", null);
            }
        }
        return true;
    }

    private boolean aN(i iVar) {
        AppMethodBeat.i(9354);
        ab.i("MicroMsg.MsgHandler", "start doChangePayActivityView");
        com.tencent.mm.g.a.aq aqVar = new com.tencent.mm.g.a.aq();
        String str = (String) iVar.puc.get("showInfo");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            AppMethodBeat.o(9354);
            return false;
        }
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            aqVar.ctH.ctJ = jSONObject.getString("buttonTitle");
            str = jSONObject.getString("isButtonEnable");
            String string = jSONObject.getString("isButtonHidden");
            String string2 = jSONObject.getString("isActivityViewHidden");
            ab.i("MicroMsg.MsgHandler", "isButtonEnable:" + str + " isButtonHidden:" + string + " isActivityViewHidden:" + string2);
            aqVar.ctH.ctK = bo.getInt(str, 0) > 0;
            com.tencent.mm.g.a.aq.a aVar = aqVar.ctH;
            if (bo.getInt(string, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.ctL = z;
            com.tencent.mm.g.a.aq.a aVar2 = aqVar.ctH;
            if (bo.getInt(string2, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar2.ctM = z;
            com.tencent.mm.sdk.b.a.xxA.m(aqVar);
            if (aqVar.ctI.csN) {
                ab.i("MicroMsg.MsgHandler", "changePayActivityView:ok");
                a(iVar, "changePayActivityView:ok", null);
            } else {
                ab.i("MicroMsg.MsgHandler", "changePayActivityView:fail");
                a(iVar, "changePayActivityView:fail", null);
            }
            AppMethodBeat.o(9354);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            AppMethodBeat.o(9354);
            return false;
        }
    }

    private boolean aO(i iVar) {
        AppMethodBeat.i(9355);
        String str = (String) iVar.puc.get("idKeyDataInfo");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "idkey data is null");
            a(iVar, "reportIDKey:fail_invaild_parms", null);
            AppMethodBeat.o(9355);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(bo.getInt(optJSONObject.optString("id"), 0));
                    iDKey.SetKey(bo.getInt(optJSONObject.optString("key"), 0));
                    iDKey.SetValue((long) bo.getInt(optJSONObject.optString("value"), 0));
                    arrayList.add(iDKey);
                }
                if (arrayList.size() > 0) {
                    h.pYm.b(arrayList, true);
                    a(iVar, "reportIDKey:ok", null);
                    AppMethodBeat.o(9355);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "parse json array faild : %s", e.getMessage());
            }
            a(iVar, "reportIDKey:fail", null);
            AppMethodBeat.o(9355);
        }
        return false;
    }

    private boolean aP(i iVar) {
        AppMethodBeat.i(9356);
        String str = (String) iVar.puc.get("url");
        String str2 = (String) iVar.puc.get("open_game_webview");
        ab.i("MicroMsg.MsgHandler", "open url with extra webview, url = %s, cityServiceId = %s, injectJs = %b", str, (String) iVar.puc.get("city_service_ext"), Boolean.valueOf(bo.getBoolean((String) iVar.puc.get("inject_city_service_js"), false)));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openUrlWithExtraWebview:fail_invalid_url", null);
            AppMethodBeat.o(9356);
        } else {
            String string;
            final Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("convertActivityFromTranslucent", false);
            intent.putExtra("city_service_ext_info", string);
            intent.putExtra("inject_city_service_js", r3);
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            try {
                Bundle g = this.umI.g(18, null);
                if (g != null) {
                    string = g.getString("prePublishId");
                    String string2 = g.getString("preChatName");
                    String string3 = g.getString("preUsername");
                    int i = g.getInt("preChatTYPE", 0);
                    intent.putExtra("prePublishId", string);
                    intent.putExtra("preUsername", string3);
                    intent.putExtra("preChatName", string2);
                    intent.putExtra("preChatTYPE", i);
                }
                int i2 = bo.getInt((String) iVar.puc.get("scene"), -1);
                str = (String) iVar.puc.get("bizUsername");
                if (!(bo.isNullOrNil(str) || i2 == -1)) {
                    intent.putExtra("geta8key_scene", i2);
                    intent.putExtra("geta8key_username", str);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            }
            if (bo.nullAsNil(str2).equals("1")) {
                com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", this.umI, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9195);
                        com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
                        AppMethodBeat.o(9195);
                    }
                });
            } else {
                com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", this.umI, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9196);
                        com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(9196);
                    }
                });
            }
            a(iVar, "openUrlWithExtraWebview:ok", null);
            AppMethodBeat.o(9356);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007e A:{Catch:{ Exception -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ed A:{Catch:{ Exception -> 0x01be }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean aQ(i iVar) {
        AppMethodBeat.i(9357);
        String str = (String) iVar.puc.get("url");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openCunstonWebview:fail_invalid_url", null);
            AppMethodBeat.o(9357);
            return true;
        }
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        boolean z4;
        String nullAsNil;
        String nullAsNil2;
        boolean z5;
        String nullAsNil3;
        final Intent intent;
        gu guVar;
        String nullAsNil4 = bo.nullAsNil((String) iVar.puc.get("orientation"));
        if (!bo.isNullOrNil(nullAsNil4)) {
            if (nullAsNil4.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                i = 0;
            } else if (nullAsNil4.equals("vertical")) {
                i = 1;
            } else if (nullAsNil4.equals("sensor")) {
                i = 4;
            }
            z = false;
            if (bo.nullAsNil((String) iVar.puc.get("fullscreen")).equals("true")) {
                z = true;
            }
            iVar.puc.get("top_url");
            iVar.puc.get("top_title");
            z2 = false;
            if (this.umI != null) {
                z2 = this.umI.g(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
            obj = null;
            if (bo.nullAsNil((String) iVar.puc.get("finish_recent_webview")).equals("1")) {
                obj = 1;
            }
            z4 = false;
            if (bo.nullAsNil((String) iVar.puc.get("disable_swipe_back")).equals("1")) {
                z4 = true;
            }
            nullAsNil = bo.nullAsNil((String) iVar.puc.get("username"));
            nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("open_game_webview"));
            z2 = false;
            if (this.umI != null) {
                z2 = this.umI.g(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
            nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z);
            intent.putExtra("disable_swipe_back", z4);
            intent.putExtra("from_shortcut", z3);
            intent.putExtra("shortcut_user_name", nullAsNil);
            intent.putExtra("is_from_keep_top", z5);
            intent.putExtra("game_hv_menu_appid", nullAsNil3);
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            if (!z3) {
                com.tencent.mm.bp.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
            } else if (bo.nullAsNil(nullAsNil2).equals("1")) {
                com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", this.umI, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9197);
                        com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
                        AppMethodBeat.o(9197);
                    }
                });
            } else {
                com.tencent.mm.bp.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            }
            if (!(obj == null || z3)) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9198);
                        try {
                            g.k(g.this, new i());
                            AppMethodBeat.o(9198);
                        } catch (Exception e) {
                            ab.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", e.getMessage());
                            AppMethodBeat.o(9198);
                        }
                    }
                }, 200);
            }
            guVar = new gu();
            guVar.cBw.Cn = 2;
            guVar.cBw.cBy = nullAsNil3;
            com.tencent.mm.sdk.b.a.xxA.m(guVar);
            a(iVar, "openCunstonWebview:ok", null);
            AppMethodBeat.o(9357);
            return true;
        }
        i = -1;
        z = false;
        if (bo.nullAsNil((String) iVar.puc.get("fullscreen")).equals("true")) {
        }
        iVar.puc.get("top_url");
        iVar.puc.get("top_title");
        z2 = false;
        try {
            if (this.umI != null) {
            }
            z3 = z2;
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from shortcut exception : %s", e.getMessage());
            z3 = false;
        }
        obj = null;
        if (bo.nullAsNil((String) iVar.puc.get("finish_recent_webview")).equals("1")) {
        }
        z4 = false;
        if (bo.nullAsNil((String) iVar.puc.get("disable_swipe_back")).equals("1")) {
        }
        nullAsNil = bo.nullAsNil((String) iVar.puc.get("username"));
        nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("open_game_webview"));
        z2 = false;
        try {
            if (this.umI != null) {
            }
            z5 = z2;
        } catch (Exception e2) {
            ab.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from keep top exception : %s", e2.getMessage());
            z5 = false;
        }
        nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("gameAppid"));
        intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("screen_orientation", i);
        intent.putExtra("show_full_screen", z);
        intent.putExtra("disable_swipe_back", z4);
        intent.putExtra("from_shortcut", z3);
        intent.putExtra("shortcut_user_name", nullAsNil);
        intent.putExtra("is_from_keep_top", z5);
        intent.putExtra("game_hv_menu_appid", nullAsNil3);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        if (!z3) {
        }
        al.n(/* anonymous class already generated */, 200);
        guVar = new gu();
        guVar.cBw.Cn = 2;
        guVar.cBw.cBy = nullAsNil3;
        com.tencent.mm.sdk.b.a.xxA.m(guVar);
        a(iVar, "openCunstonWebview:ok", null);
        AppMethodBeat.o(9357);
        return true;
    }

    private boolean aR(i iVar) {
        AppMethodBeat.i(9358);
        String nullAsNil = bo.nullAsNil((String) iVar.puc.get("orientation"));
        int i = -1;
        if (!bo.isNullOrNil(nullAsNil)) {
            if (nullAsNil.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                i = 0;
            } else if (nullAsNil.equals("vertical")) {
                i = 1;
            } else if (nullAsNil.equals("sensor")) {
                i = 4;
            } else if (nullAsNil.equals("horizontal_unforced")) {
                i = 1001;
            } else if (nullAsNil.equals("vertical_unforced")) {
                i = 1002;
            }
        }
        try {
            if (this.umI != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", i);
                this.umI.g(1009, bundle);
                a(iVar, "setScreenOrientation:ok", null);
            } else {
                a(iVar, "setScreenOrientation:fail", null);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doSetScreenOrientation exception, " + e.getMessage());
            a(iVar, "setScreenOrientation:fail", null);
        }
        AppMethodBeat.o(9358);
        return true;
    }

    private boolean aS(i iVar) {
        AppMethodBeat.i(9359);
        ab.i("MicroMsg.MsgHandler", o.NAME);
        boolean equals = "1".equals((String) iVar.puc.get("actionCode"));
        Bundle bundle = new Bundle();
        if (equals) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            int parseColor;
            int i;
            try {
                parseColor = Color.parseColor((String) iVar.puc.get("color")) | WebView.NIGHT_MODE_COLOR;
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", e.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                parseColor = -1;
            }
            try {
                i = (int) (bo.getFloat((String) iVar.puc.get("alpha"), 1.0f) * 255.0f);
                if (i < 0 || i > 255) {
                    i = 255;
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgHandler", e2.getMessage());
                i = -1;
            }
            bundle.putInt("set_navigation_bar_color_color", parseColor);
            bundle.putInt("set_navigation_bar_color_alpha", i);
        }
        try {
            this.umI.g(53, bundle);
            a(iVar, "setNavigationBarColor:ok", null);
        } catch (Exception e22) {
            ab.e("MicroMsg.MsgHandler", e22.getMessage());
            a(iVar, "setNavigationBarColor:fail", null);
        }
        AppMethodBeat.o(9359);
        return true;
    }

    public final void a(String str, boolean z, String str2, long j) {
        AppMethodBeat.i(9360);
        Bundle bundle = new Bundle();
        bundle.putString("emoji_store_json_data", str);
        bundle.putBoolean("emoji_store_new_query", z);
        bundle.putString("emoji_store_page_buf", str2);
        bundle.putLong("emoji_store_search_id", j);
        ab.d("MicroMsg.MsgHandler", "cpan emoji getSearchEmotionDataCallBack:%d", Long.valueOf(j));
        try {
            if (this.umI != null) {
                this.umI.c(XWalkCoreWrapper.INVOKE_RUNTIME_ID_CONTEXT_CHANGED, bundle);
            }
            AppMethodBeat.o(9360);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "getSearchEmotionDataCallBack exception" + e.getMessage());
            AppMethodBeat.o(9360);
        }
    }

    private boolean od(boolean z) {
        AppMethodBeat.i(9361);
        ab.e("MicroMsg.MsgHandler", "hideMenuEntry:".concat(String.valueOf(z)));
        try {
            this.umI.nL(z);
            ab.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            AppMethodBeat.o(9361);
            return true;
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            ab.e("MicroMsg.MsgHandler", "hideMenuEntry error");
            ab.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            AppMethodBeat.o(9361);
            return false;
        } catch (Throwable th) {
            ab.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            AppMethodBeat.o(9361);
            return true;
        }
    }

    private boolean aT(final i iVar) {
        AppMethodBeat.i(9362);
        ab.i("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact");
        String str = (String) iVar.puc.get(Scopes.OPEN_ID);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact openid is null");
            a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
            AppMethodBeat.o(9362);
        } else {
            String str2 = (String) iVar.puc.get("appId");
            if (this.uGh != null && TextUtils.isEmpty(str2)) {
                str2 = this.uGh.getString("jsapi_args_appid");
            }
            if (bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact appid is null");
                a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                AppMethodBeat.o(9362);
            } else {
                this.cEl = g(iVar);
                final m acVar = new ac(str2, str);
                com.tencent.mm.kernel.g.Rg().a(1142, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(9207);
                        if (g.this.ehJ != null && g.this.ehJ.isShowing()) {
                            g.this.ehJ.dismiss();
                            g.this.ehJ = null;
                        }
                        if (i == 0 && i2 == 0) {
                            cii cii;
                            ac acVar = (ac) mVar;
                            if (acVar.ehh == null) {
                                cii = null;
                            } else {
                                cii = (cii) acVar.ehh.fsH.fsP;
                            }
                            if (cii != null) {
                                String str2 = cii.username;
                                if (bo.isNullOrNil(str2)) {
                                    ab.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
                                } else if (g.this.context instanceof MMActivity) {
                                    if (g.a(g.this, str2, (String) iVar.puc.get("title"), (String) iVar.puc.get("img_url"), str2, (String) iVar.puc.get("desc"), (String) iVar.puc.get("src_username"), (String) iVar.puc.get("src_displayname"), "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") == null) {
                                        ab.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
                                        g.a(g.this, iVar, "sendAppMessageToSpecifiedContact:fail", null);
                                    } else {
                                        AppMethodBeat.o(9207);
                                        return;
                                    }
                                }
                            }
                            ab.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
                        } else {
                            ab.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
                        }
                        g.a(g.this, iVar, "sendAppMessageToSpecifiedContact:fail", null);
                        AppMethodBeat.o(9207);
                    }
                });
                com.tencent.mm.kernel.g.Rg().a(acVar, 0);
                Context context = this.context;
                this.context.getString(R.string.tz);
                this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(9208);
                        com.tencent.mm.kernel.g.Rg().c(acVar);
                        AppMethodBeat.o(9208);
                    }
                });
                AppMethodBeat.o(9362);
            }
        }
        return true;
    }

    private boolean dcF() {
        AppMethodBeat.i(9363);
        try {
            Bundle bundle = new Bundle(1);
            bundle.putString("place_holder", "place_holder");
            this.umI.cZb();
            this.umI.W(bundle);
        } catch (Exception e) {
        }
        AppMethodBeat.o(9363);
        return true;
    }

    public final boolean aU(i iVar) {
        AppMethodBeat.i(9364);
        ab.i("MicroMsg.MsgHandler", "doWCPayRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.umI.getCurrentUrl();
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bo.isNullOrNil(str)) {
            intent.putExtra("appId", this.uGr.agj(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.cId);
            try {
                intent.putExtra("url", this.umI.getCurrentUrl());
            } catch (RemoteException e2) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.setFlags(536870912);
            intent.putExtra("pay_channel", gVar.cvS);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 34);
        }
        AppMethodBeat.o(9364);
        return true;
    }

    public final boolean dcG() {
        AppMethodBeat.i(9365);
        ab.i("MicroMsg.MsgHandler", "doSwitchWalletCurrency call");
        ((MMActivity) this.context).ifE = this;
        com.tencent.mm.bp.d.b(this.context, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", null, 35);
        AppMethodBeat.o(9365);
        return true;
    }

    private boolean aV(i iVar) {
        boolean z;
        AppMethodBeat.i(9366);
        String str = (String) iVar.puc.get("clearCookie");
        ab.i("MicroMsg.MsgHandler", "clearflag = %s", str);
        if (bo.isNullOrNil(str) || !str.equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        str = (String) iVar.puc.get("url");
        if (!bo.isNullOrNil(str)) {
            str = q.aeJ(str);
            if (bo.isNullOrNil(str)) {
                str = null;
            } else {
                Uri parse = Uri.parse(str);
                str = parse.getHost() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + parse.getPort();
            }
            if (!bo.isNullOrNil(str)) {
                com.tencent.mm.plugin.webview.modelcache.r.a.uor.aNS().aa(new Runnable() {
                    public final void run() {
                        List list = null;
                        AppMethodBeat.i(9210);
                        com.tencent.mm.plugin.webview.modelcache.r.a.uor;
                        String str = str;
                        if (!bo.isNullOrNil(str)) {
                            com.tencent.mm.plugin.webview.modelcache.l cYo = com.tencent.mm.plugin.webview.modelcache.l.cYo();
                            if (cYo.hrm && !bo.isNullOrNil(str)) {
                                list = cYo.o(String.format("select * from %s where %s=? ", new Object[]{"WebViewResourceCache", "domain"}), str);
                            }
                            if (!bo.ek(list)) {
                                for (com.tencent.mm.plugin.webview.modelcache.g gVar : list) {
                                    com.tencent.mm.plugin.webview.modelcache.a aeH = com.tencent.mm.plugin.webview.modelcache.a.aeH(gVar.field_appId);
                                    if (aeH != null) {
                                        String str2 = gVar.field_localPath;
                                        if (!bo.isNullOrNil(str2)) {
                                            long asZ;
                                            if (str2.startsWith(aeH.path)) {
                                                asZ = com.tencent.mm.vfs.e.asZ(str2);
                                            } else {
                                                asZ = 0;
                                            }
                                            if (com.tencent.mm.vfs.e.deleteFile(str2) && str2.startsWith(aeH.path)) {
                                                com.tencent.mm.plugin.webview.modelcache.a.b bVar = aeH.unD;
                                                String str3 = aeH.appId;
                                                if (bVar.hrm) {
                                                    com.tencent.mm.plugin.webview.modelcache.a.a aVar = new com.tencent.mm.plugin.webview.modelcache.a.a();
                                                    aVar.field_appId = str3;
                                                    if (bVar.b((com.tencent.mm.sdk.e.c) aVar, new String[0])) {
                                                        aVar.field_occupation = Math.max(0, aVar.field_occupation - asZ);
                                                        bVar.c(aVar, new String[0]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.webview.modelcache.l cYo2 = com.tencent.mm.plugin.webview.modelcache.l.cYo();
                                if (cYo2.hrm && !bo.isNullOrNil(str)) {
                                    com.tencent.mm.plugin.webview.modelcache.g gVar2 = new com.tencent.mm.plugin.webview.modelcache.g();
                                    gVar2.field_domain = str;
                                    cYo2.a((com.tencent.mm.sdk.e.c) gVar2, "domain");
                                }
                            }
                        }
                        WebViewCacheDownloadHelper.cYs();
                        AppMethodBeat.o(9210);
                    }
                });
            }
        }
        if (this.umI != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("clear_webview_cache_clear_cookie", z);
            try {
                this.umI.g(6001, bundle);
                a(iVar, "clearWebviewCache:ok", null);
                AppMethodBeat.o(9366);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", e.getMessage());
                a(iVar, "clearWebviewCache:fail", null);
                AppMethodBeat.o(9366);
            }
        } else {
            a(iVar, "clearWebviewCache:fail", null);
            AppMethodBeat.o(9366);
        }
        return true;
    }

    public final boolean aW(i iVar) {
        AppMethodBeat.i(9367);
        ab.i("MicroMsg.MsgHandler", "doIdCardRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.umI.getCurrentUrl();
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bo.isNullOrNil(str)) {
            intent.putExtra("appId", this.uGr.agj(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.cId);
            try {
                intent.putExtra("url", this.umI.getCurrentUrl());
            } catch (RemoteException e2) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.putExtra("pay_channel", gVar.cvS);
            intent.putExtra("real_name_verify_mode", 2);
            intent.setFlags(536870912);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 41);
        }
        AppMethodBeat.o(9367);
        return true;
    }

    public final boolean aX(i iVar) {
        AppMethodBeat.i(9368);
        a(iVar, "uploadIdCardSuccess:ok", null);
        ab.i("MicroMsg.MsgHandler", "uploadIdCardSuccess");
        vd vdVar = new vd();
        vdVar.cSa.result = -1;
        com.tencent.mm.sdk.b.a.xxA.m(vdVar);
        AppMethodBeat.o(9368);
        return true;
    }

    public final boolean aY(i iVar) {
        AppMethodBeat.i(9369);
        ab.i("MicroMsg.MsgHandler", "getGameCommInfo call");
        int i = bo.getInt((String) iVar.puc.get("cmd"), 0);
        String str = (String) iVar.puc.get("param");
        Map hashMap;
        if (i != 10002) {
            gu guVar = new gu();
            guVar.cBw.Cn = i;
            guVar.cBw.cBy = str;
            guVar.cBw.context = this.context;
            com.tencent.mm.sdk.b.a.xxA.m(guVar);
            ab.i("MicroMsg.MsgHandler", "gameCommInfo:%s", guVar.cBx.result);
            if (bo.isNullOrNil(guVar.cBx.result)) {
                a(iVar, "getGameCommInfo:fail", null);
            } else {
                try {
                    hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(guVar.cBx.result);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    a(iVar, "getGameCommInfo:ok", hashMap);
                } catch (JSONException e) {
                    a(iVar, "getGameCommInfo:fail", null);
                }
            }
        } else if (this.umI != null) {
            try {
                Bundle g = this.umI.g(97, null);
                if (g != null) {
                    int i2 = g.getInt("web_page_count");
                    hashMap = new HashMap();
                    hashMap.put("webpageCount", Integer.valueOf(i2));
                    a(iVar, "getGameCommInfo:ok", hashMap);
                }
            } catch (RemoteException e2) {
                ab.e("MicroMsg.MsgHandler", "doGetGameCommInfo exception, " + e2.getMessage());
                a(iVar, "getGameCommInfo:fail", null);
            }
        }
        AppMethodBeat.o(9369);
        return true;
    }

    public final boolean dcH() {
        AppMethodBeat.i(9370);
        ab.i("MicroMsg.MsgHandler", "openGameRegion call");
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.a(this.context, "game", ".ui.GameRegionSelectUI", null, 42, false);
        }
        AppMethodBeat.o(9370);
        return true;
    }

    public final boolean aZ(final i iVar) {
        AppMethodBeat.i(9371);
        com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this.context);
        jVar.b(null, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(9211);
                contextMenu.add(0, 1, 0, g.this.context.getString(R.string.dxj));
                contextMenu.add(0, 2, 1, g.this.context.getString(R.string.dxe));
                AppMethodBeat.o(9211);
            }
        }, new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(9212);
                switch (menuItem.getItemId()) {
                    case 1:
                        g.eu(g.this, iVar);
                        AppMethodBeat.o(9212);
                        return;
                    case 2:
                        g.ev(g.this, iVar);
                        break;
                }
                AppMethodBeat.o(9212);
            }
        });
        jVar.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(9039);
                g.a(g.this, iVar, "chooseIdCard:cancel", null);
                AppMethodBeat.o(9039);
            }
        });
        jVar.cuu();
        AppMethodBeat.o(9371);
        return true;
    }

    private boolean ba(i iVar) {
        String str;
        AppMethodBeat.i(9372);
        if (this.uGh != null) {
            int i = this.uGh.getInt("key_download_restrict", 0);
            if (!bo.isNullOrNil(this.uGh.getString("key_function_id", ""))) {
                h.pYm.e(14596, str, Integer.valueOf(i), Integer.valueOf(1));
            }
            if (i == 1) {
                ab.e("MicroMsg.MsgHandler", "not allow to launch application");
                a(iVar, "launchApplication:fail", null);
                AppMethodBeat.o(9372);
                return true;
            }
        }
        ab.i("MicroMsg.MsgHandler", "launchTimeInterval = %d", Long.valueOf(bo.anT() - this.uGx));
        if (bo.anT() - this.uGx < 2 && this.uGx > 0) {
            try {
                String encode = URLEncoder.encode(this.umI.getCurrentUrl(), "UTF-8");
                h.pYm.e(13983, Integer.valueOf(5), encode, "");
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "report launchApplication failed");
            }
        }
        final String str2 = (String) iVar.puc.get("appID");
        final String str3 = (String) iVar.puc.get("schemeUrl");
        final String str4 = (String) iVar.puc.get("parameter");
        int i2 = bo.getInt((String) iVar.puc.get("alertType"), 0);
        l.a(iVar.uII, false, null, str2);
        final String str5 = (String) iVar.puc.get(IssueStorage.COLUMN_EXT_INFO);
        ab.i("MicroMsg.MsgHandler", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s", str2, str3, str5, str4);
        if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.MsgHandler", "appid and scheme is null or nil");
            a(iVar, "launchApplication:fail", null);
            AppMethodBeat.o(9372);
            return true;
        }
        Object obj = iVar.puc.get("__jsapi_fw_ext_info");
        str = null;
        if (obj instanceof Bundle) {
            str = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        }
        String agj = this.uGr.agj(str);
        final Bundle bundle = new Bundle();
        if (!bo.isNullOrNil(str)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
            }
        }
        bundle.putString("current_page_appid", agj);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new avj();
        aVar.fsK = new avk();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.fsI = 1125;
        com.tencent.mm.ai.b acD = aVar.acD();
        avj avj = (avj) acD.fsG.fsP;
        avj.csB = agj;
        avj.wzn = str2;
        avj.scene = aGu();
        avj.url = str;
        avj.wzo = str3;
        avj.kCo = i2;
        avj.wzp = 0;
        ab.i("MicroMsg.MsgHandler", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", agj, str2, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo));
        final i iVar2 = iVar;
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(final int i, final int i2, String str, final com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(9045);
                ab.i("MicroMsg.MsgHandler", "launchApplication check result errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                com.tencent.mm.ce.a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9044);
                        if (i == 0 && i2 == 0) {
                            avk avk = (avk) bVar.fsH.fsP;
                            ab.i("MicroMsg.MsgHandler", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE));
                            switch (avk.cyE) {
                                case 0:
                                    List H;
                                    Object b;
                                    boolean a;
                                    aj dVar = new d(new a() {
                                        public final void r(boolean z, boolean z2) {
                                            AppMethodBeat.i(9043);
                                            ab.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                            if (z) {
                                                g.a(g.this, iVar2, "launchApplication:ok", null);
                                                AppMethodBeat.o(9043);
                                                return;
                                            }
                                            g.a(g.this, iVar2, "launchApplication:fail", null);
                                            AppMethodBeat.o(9043);
                                        }
                                    });
                                    if (!bo.isNullOrNil(str3)) {
                                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
                                        intent.addFlags(268435456);
                                        H = bo.H(g.this.context, intent);
                                        if (!(H == null || H.isEmpty())) {
                                            if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                                                b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent.getPackage();
                                            }
                                            if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                                                dVar.dS(com.tencent.mm.pluginsdk.model.app.g.a(g.this.context, intent, null, avk.wzs, dVar, bundle));
                                                AppMethodBeat.o(9044);
                                                return;
                                            }
                                        }
                                    }
                                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                                    wXAppExtendObject.extInfo = str5;
                                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                                    wXMediaMessage.sdkVer = Build.SDK_INT;
                                    wXMediaMessage.messageExt = str5;
                                    jc jcVar = new jc();
                                    jcVar.cEj.cEl = wXMediaMessage;
                                    jcVar.cEj.appId = str2;
                                    jcVar.cEj.showType = avk.wzs;
                                    jcVar.cEj.context = g.this.context;
                                    jcVar.cEj.cvs = bundle;
                                    jcVar.cEj.cEm = dVar;
                                    com.tencent.mm.sdk.b.a.xxA.m(jcVar);
                                    boolean z = jcVar.cEk.cEn;
                                    if (!(z || bo.isNullOrNil(str2) || bo.isNullOrNil(str4))) {
                                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str2 + "://" + str4));
                                        ab.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                                        intent2.addFlags(268435456);
                                        H = bo.H(g.this.context, intent2);
                                        if (!(H == null || H.isEmpty())) {
                                            if (TextUtils.isEmpty(intent2.getPackage()) && H.size() == 1) {
                                                b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent2.getPackage();
                                            }
                                            if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                                                dVar.ftW = false;
                                                dVar.hxt = false;
                                                dVar.hxu = false;
                                                dVar.cEn = false;
                                                a = com.tencent.mm.pluginsdk.model.app.g.a(g.this.context, intent2, null, dVar, bundle);
                                                dVar.dS(a);
                                                AppMethodBeat.o(9044);
                                                return;
                                            }
                                        }
                                    }
                                    a = z;
                                    dVar.dS(a);
                                    AppMethodBeat.o(9044);
                                    return;
                                case 2:
                                    g.a(g.this, iVar2, "launchApplication:fail_check fail forbidden scene", null);
                                    AppMethodBeat.o(9044);
                                    return;
                                default:
                                    g.a(g.this, iVar2, "launchApplication:fail_check fail", null);
                                    AppMethodBeat.o(9044);
                                    return;
                            }
                        }
                        g.a(g.this, iVar2, "launchApplication:fail_check fail", null);
                        AppMethodBeat.o(9044);
                    }
                });
                AppMethodBeat.o(9045);
                return 0;
            }
        });
        AppMethodBeat.o(9372);
        return true;
    }

    private boolean a(final i iVar, final a aVar) {
        String currentUrl;
        AppMethodBeat.i(9373);
        ab.i("MicroMsg.MsgHandler", "doLogin!");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = null;
        }
        final String nullAsNil = bo.nullAsNil(this.uGr.agj(currentUrl));
        if (bo.isNullOrNil(nullAsNil)) {
            ab.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "doLogin:fail", null);
            aVar.aCB();
            AppMethodBeat.o(9373);
            return false;
        }
        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.z.a.c(nullAsNil, linkedList, str2, str, new com.tencent.mm.z.a.c.a<com.tencent.mm.z.a.c>() {
            public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(9052);
                com.tencent.mm.z.a.c cVar = (com.tencent.mm.z.a.c) mVar;
                ab.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    final awb Qv = cVar.Qv();
                    int i3 = Qv.wzH.cyE;
                    String str2 = Qv.wzH.cyF;
                    final String str3 = Qv.wzN;
                    ab.i("MicroMsg.MsgHandler", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                    if (i3 == -12000) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(9051);
                                LinkedList linkedList = Qv.wlE;
                                ab.d("MicroMsg.MsgHandler", "appName %s, appIconUrl %s", Qv.ncH, Qv.vDm);
                                com.tencent.mm.plugin.webview.ui.tools.widget.n nVar = new com.tencent.mm.plugin.webview.ui.tools.widget.n(g.this.context);
                                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.widget.n.a() {
                                    public final void f(int i, Bundle bundle) {
                                        AppMethodBeat.i(9050);
                                        ab.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", Integer.valueOf(i));
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                g gVar = g.this;
                                                String str = nullAsNil;
                                                String str2 = str3;
                                                i iVar = iVar;
                                                a aVar = aVar;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.z.a.d(str, linkedList, str2, i, new AnonymousClass8(iVar, aVar, i)), 0);
                                                if (i == 2) {
                                                    ab.e("MicroMsg.MsgHandler", "fail auth deny!");
                                                    g.a(g.this, iVar, "login:fail auth deny", null);
                                                    aVar.aCB();
                                                    AppMethodBeat.o(9050);
                                                    return;
                                                }
                                                break;
                                            default:
                                                ab.i("MicroMsg.MsgHandler", "press back button!");
                                                g.a(g.this, iVar, "login:fail auth cancel", null);
                                                aVar.aCB();
                                                break;
                                        }
                                        AppMethodBeat.o(9050);
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    ab.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                                    g.a(g.this, iVar, "login:fail", null);
                                    aVar.aCB();
                                    AppMethodBeat.o(9051);
                                    return;
                                }
                                if (!nVar.a(linkedList, r1, r2, anonymousClass1)) {
                                    aVar.aCB();
                                }
                                AppMethodBeat.o(9051);
                            }
                        });
                        AppMethodBeat.o(9052);
                        return;
                    } else if (i3 == 0) {
                        String str4 = Qv.wzO;
                        Map hashMap = new HashMap();
                        hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str4);
                        g.a(g.this, iVar, "login:ok", hashMap);
                        ab.d("MicroMsg.MsgHandler", "resp data code [%s]", str4);
                        aVar.aCB();
                        AppMethodBeat.o(9052);
                        return;
                    } else {
                        g.a(g.this, iVar, "login:fail", null);
                        ab.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLogin %s", str2);
                        aVar.aCB();
                        AppMethodBeat.o(9052);
                        return;
                    }
                }
                g.a(g.this, iVar, "login:fail", null);
                aVar.aCB();
                AppMethodBeat.o(9052);
            }
        }), 0);
        AppMethodBeat.o(9373);
        return true;
    }

    private boolean b(final i iVar, final a aVar) {
        AppMethodBeat.i(9374);
        ab.i("MicroMsg.MsgHandler", "doOauthAuthorize!");
        String str = (String) iVar.puc.get("scope");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "scope is null!");
            a(iVar, "authorize:fail", null);
            aVar.aCB();
            AppMethodBeat.o(9374);
            return true;
        }
        String currentUrl;
        try {
            currentUrl = this.umI.getCurrentUrl();
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", e.getMessage());
            currentUrl = null;
        }
        currentUrl = bo.nullAsNil(this.uGr.agj(currentUrl));
        if (bo.isNullOrNil(currentUrl)) {
            ab.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "authorize:fail", null);
            aVar.aCB();
            AppMethodBeat.o(9374);
            return false;
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.z.a.a(currentUrl, linkedList, new com.tencent.mm.z.a.a.a<com.tencent.mm.z.a.a>() {
                public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(9056);
                    com.tencent.mm.z.a.a aVar = (com.tencent.mm.z.a.a) mVar;
                    ab.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        final avx Qr = aVar.Qr();
                        int i3 = Qr.wzH.cyE;
                        String str2 = Qr.wzH.cyF;
                        ab.i("MicroMsg.MsgHandler", "NetSceneJSAuthorize jsErrcode %d", Integer.valueOf(i3));
                        if (i3 == -12000) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(9055);
                                    LinkedList linkedList = Qr.wlE;
                                    String str = Qr.ncH;
                                    String str2 = Qr.vDm;
                                    com.tencent.mm.plugin.webview.ui.tools.widget.n nVar = new com.tencent.mm.plugin.webview.ui.tools.widget.n(g.this.context);
                                    AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.widget.n.a() {
                                        public final void f(int i, Bundle bundle) {
                                            AppMethodBeat.i(9054);
                                            ab.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                            switch (i) {
                                                case 1:
                                                case 2:
                                                    g gVar = g.this;
                                                    String str = currentUrl;
                                                    i iVar = iVar;
                                                    a aVar = aVar;
                                                    ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                    LinkedList linkedList = new LinkedList();
                                                    Iterator it = arrayList.iterator();
                                                    while (it.hasNext()) {
                                                        linkedList.add((String) it.next());
                                                    }
                                                    com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.z.a.b(str, linkedList, i, new AnonymousClass10(iVar, aVar, i)), 0);
                                                    if (i == 2) {
                                                        g.a(g.this, iVar, "authorize:fail auth deny", null);
                                                        aVar.aCB();
                                                        AppMethodBeat.o(9054);
                                                        return;
                                                    }
                                                    break;
                                                default:
                                                    ab.d("MicroMsg.MsgHandler", "press back button!");
                                                    g.a(g.this, iVar, "authorize:fail auth cancel", null);
                                                    aVar.aCB();
                                                    break;
                                            }
                                            AppMethodBeat.o(9054);
                                        }
                                    };
                                    if (linkedList == null || linkedList.size() <= 0) {
                                        ab.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                                        g.a(g.this, iVar, "authorize:fail", null);
                                        aVar.aCB();
                                        AppMethodBeat.o(9055);
                                        return;
                                    }
                                    if (!nVar.a(linkedList, str, str2, anonymousClass1)) {
                                        aVar.aCB();
                                    }
                                    AppMethodBeat.o(9055);
                                }
                            });
                            AppMethodBeat.o(9056);
                            return;
                        } else if (i3 == 0) {
                            g.a(g.this, iVar, "authorize:ok", null);
                            aVar.aCB();
                            AppMethodBeat.o(9056);
                            return;
                        } else {
                            ab.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                            g.a(g.this, iVar, "authorize:fail", null);
                            aVar.aCB();
                            AppMethodBeat.o(9056);
                            return;
                        }
                    }
                    g.a(g.this, iVar, "authorize:fail", null);
                    aVar.aCB();
                    AppMethodBeat.o(9056);
                }
            }), 0);
            AppMethodBeat.o(9374);
            return true;
        } catch (Exception e2) {
            ab.e("MicroMsg.MsgHandler", "Exception %s", e2.getMessage());
            a(iVar, "authorize:fail", null);
            AppMethodBeat.o(9374);
            return true;
        }
    }

    public final void gB(int i, int i2) {
        AppMethodBeat.i(9375);
        String str = "";
        String str2 = " ";
        String str3 = "";
        Bundle bundle = null;
        try {
            if (this.umI != null) {
                bundle = this.umI.g(77, null);
            }
            if (bundle != null) {
                str = bundle.getString("KUrl");
                if (TextUtils.isEmpty(str)) {
                    ab.e("MicroMsg.MsgHandler", "url is empty");
                    AppMethodBeat.o(9375);
                    return;
                }
                str2 = bo.nullAsNil(bundle.getString("KSessionId"));
                ab.i("MicroMsg.MsgHandler", "sessionId %s", str2);
                str3 = bundle.getString("geta8key_username");
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "get sessionId error, %s", e);
        }
        String nullAsNil = bo.nullAsNil(bK(str));
        int type = this.cEl.mediaObject.type();
        int i3 = this.uGv.IS(i) ? 2 : 1;
        ab.i("MicroMsg.MsgHandler", "appId %s, type %d,publisher %s, opType %d", nullAsNil, Integer.valueOf(type), str3, Integer.valueOf(i3));
        if (type == 5) {
            long anT = bo.anT();
            ab.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(anT), nullAsNil, str, str2, Integer.valueOf(i), Integer.valueOf(i2));
            String str4 = "";
            try {
                str = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                str = str4;
            }
            h.pYm.e(13377, Long.valueOf(anT), nullAsNil, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3);
        }
        AppMethodBeat.o(9375);
    }

    private void bb(i iVar) {
        AppMethodBeat.i(9376);
        Bundle aP = i.aP(iVar.puc);
        try {
            this.umI.cZb();
            this.umI.W(aP);
            AppMethodBeat.o(9376);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "SendServiceAppMsg doCloseWindow, ex = " + e.getMessage());
            AppMethodBeat.o(9376);
        }
    }

    private static ArrayList<bi> f(long[] jArr) {
        AppMethodBeat.i(9377);
        ArrayList arrayList = new ArrayList();
        if (jArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jArr.length) {
                    break;
                }
                arrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(jArr[i2]));
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(9377);
        return arrayList;
    }

    private static void a(SnsAdClick snsAdClick) {
        AppMethodBeat.i(9378);
        of ofVar = new of();
        ofVar.cKy.cKz = snsAdClick;
        com.tencent.mm.sdk.b.a.xxA.m(ofVar);
        AppMethodBeat.o(9378);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:607:0x1b14  */
    /* JADX WARNING: Removed duplicated region for block: B:597:0x1aca  */
    /* JADX WARNING: Removed duplicated region for block: B:816:0x2249  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x226c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int i, int i2, Intent intent) {
        AppMethodBeat.i(9379);
        ab.i("MicroMsg.MsgHandler", "mmOnActivityResult, requestCode = " + i + ", resultCode = " + i2);
        String str;
        SnsAdClick snsAdClick;
        Object obj;
        String str2;
        final String str3;
        String str4;
        String str5;
        String dcx;
        int i3;
        int i4;
        int i5;
        final String str6;
        final String str7;
        final String str8;
        final String str9;
        String bc;
        String bc2;
        String bc3;
        Map hashMap;
        Map hashMap2;
        if (i == 1) {
            if (this.cEl == null) {
                ab.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                gB(1, 2);
                a(this.uGd, "send_app_msg:fail", null);
                AppMethodBeat.o(9379);
                return;
            }
            String string;
            str = (String) this.uGd.puc.get("appid");
            snsAdClick = null;
            if (this.uGh != null) {
                snsAdClick = (SnsAdClick) this.uGh.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.uGh.getString("jsapi_args_appid");
                    obj = this.uGd.dcO().get("Internal@AsyncReport");
                    this.uGd.puc.get("link");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.fPZ = 7;
                                a(snsAdClick);
                            }
                            final com.tencent.mm.pluginsdk.model.app.f Uq = com.tencent.mm.pluginsdk.model.app.g.Uq(string);
                            if (intent == null) {
                                str2 = null;
                            } else {
                                str2 = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str2 != null && str2.length() != 0) {
                                str3 = (String) this.uGd.puc.get("img_url");
                                this.uGd.puc.get("desc");
                                str4 = (String) this.uGd.puc.get("src_username");
                                str5 = (String) this.uGd.puc.get("src_displayname");
                                dcx = dcx();
                                l.a(this.uGd.dcO(), agw("sendAppMessage"), str2, string);
                                if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                    b(this.uGd, true);
                                }
                                String[] split = str2.split(",");
                                i3 = 0;
                                i4 = 0;
                                int length = split.length;
                                int i6 = 0;
                                while (i6 < length) {
                                    if (split[i6].endsWith("@chatroom")) {
                                        i5 = i3 + 1;
                                    } else {
                                        i4++;
                                        i5 = i3;
                                    }
                                    i6++;
                                    i3 = i5;
                                }
                                final HashMap hashMap3 = new HashMap();
                                if (this.uGd.puc.get("share_callback_with_scene") != null && ((Boolean) this.uGd.puc.get("share_callback_with_scene")).booleanValue()) {
                                    hashMap3.put("groupCount", Integer.valueOf(i3));
                                    hashMap3.put("singleCount", Integer.valueOf(i4));
                                }
                                if (!bo.isNullOrNil(dcx)) {
                                    if (!bo.isNullOrNil(str3)) {
                                        final com.tencent.mm.ui.base.p b = com.tencent.mm.ui.base.h.b(this.context, this.context.getResources().getString(R.string.th), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(9059);
                                                com.tencent.mm.at.o.ahk().rZ(str3);
                                                g.a(g.this, g.this.uGd, "send_app_msg:cancel", null);
                                                AppMethodBeat.o(9059);
                                            }
                                        });
                                        final String str10 = str2;
                                        str6 = str3;
                                        str7 = str4;
                                        str8 = str5;
                                        str9 = dcx;
                                        com.tencent.mm.at.o.ahk().a(str3, new com.tencent.mm.at.c.c() {
                                            public final void C(Bitmap bitmap) {
                                                AppMethodBeat.i(9060);
                                                if (b != null) {
                                                    b.dismiss();
                                                }
                                                g.a(g.this, Uq, string, str10, str6, str7, str8, null, str9);
                                                if (g.this.context != null) {
                                                    com.tencent.mm.ui.base.h.bQ(g.this.context, g.this.context.getString(R.string.td));
                                                }
                                                g.a(g.this, g.this.uGd, "send_app_msg:ok", hashMap3);
                                                AppMethodBeat.o(9060);
                                            }
                                        });
                                        break;
                                    }
                                    a(null, "", str2, str3, str4, str5, null, dcx);
                                    com.tencent.mm.ui.base.h.bN(this.context, this.context.getString(R.string.td));
                                    a(this.uGd, "send_app_msg:ok", (Map) hashMap3);
                                    AppMethodBeat.o(9379);
                                    return;
                                }
                                a(null, "", str2, str3, str4, str5, intent == null ? null : intent.getStringExtra("custom_send_text"), dcx);
                                if (this.context != null) {
                                    com.tencent.mm.ui.base.h.bN(this.context, this.context.getResources().getString(R.string.to));
                                }
                                gB(1, 1);
                                a(this.uGd, "send_app_msg:ok", (Map) hashMap3);
                                AppMethodBeat.o(9379);
                                return;
                            }
                            ab.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                            gB(1, 2);
                            a(this.uGd, "send_app_msg:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                            break;
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.fPZ = 8;
                                a(snsAdClick);
                            }
                            l.a(this.uGd.dcO(), agw("sendAppMessage"), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.uGd, true);
                            }
                            gB(1, 3);
                            a(this.uGd, "send_app_msg:ok", null);
                            AppMethodBeat.o(9379);
                            return;
                    }
                    AppMethodBeat.o(9379);
                }
            }
            string = str;
            obj = this.uGd.dcO().get("Internal@AsyncReport");
            this.uGd.puc.get("link");
            switch (i2) {
                case -1:
                    break;
                case 0:
                    break;
            }
            AppMethodBeat.o(9379);
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    com.tencent.mm.ui.base.h.bN(this.context, this.context.getResources().getString(R.string.to));
                    a(this.uGd, "share_weibo:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                case 0:
                    a(this.uGd, "share_weibo:cancel", null);
                    AppMethodBeat.o(9379);
                    return;
                case 1:
                    a(this.uGd, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    AppMethodBeat.o(9379);
                    return;
                default:
                    a(this.uGd, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    ab.e("MicroMsg.MsgHandler", "unknown resultCode");
                    AppMethodBeat.o(9379);
                    return;
            }
        } else if (i == 3) {
            ab.i("MicroMsg.MsgHandler", "get callback address, result code = %d", Integer.valueOf(i2));
            if (i2 == -1 && intent != null) {
                str = bo.bc(intent.getStringExtra("nationalCode"), "");
                bc = bo.bc(intent.getStringExtra("userName"), "");
                bc2 = bo.bc(intent.getStringExtra("telNumber"), "");
                str2 = bo.bc(intent.getStringExtra("addressPostalCode"), "");
                str3 = bo.bc(intent.getStringExtra("proviceFirstStageName"), "");
                str4 = bo.bc(intent.getStringExtra("addressCitySecondStageName"), "");
                str5 = bo.bc(intent.getStringExtra("addressCountiesThirdStageName"), "");
                bc3 = bo.bc(intent.getStringExtra("addressDetailInfo"), "");
                ab.i("MicroMsg.MsgHandler", "first =  " + str3 + " ; detail =" + bc3 + "; second = " + str4 + " ; tel = " + bc2 + "; third = " + str5);
                if (!bo.isNullOrNil(bc)) {
                    Map hashMap4 = new HashMap();
                    hashMap4.put("nationalCode", str);
                    hashMap4.put("userName", bc);
                    hashMap4.put("telNumber", bc2);
                    hashMap4.put("addressPostalCode", str2);
                    hashMap4.put("proviceFirstStageName", str3);
                    hashMap4.put("addressCitySecondStageName", str4);
                    hashMap4.put("addressCountiesThirdStageName", str5);
                    hashMap4.put("addressDetailInfo", bc3);
                    a(this.uGd, "edit_address:ok", hashMap4);
                    AppMethodBeat.o(9379);
                    return;
                }
            }
            if (i2 == 0) {
                a(this.uGd, "edit_address:cancel", null);
                AppMethodBeat.o(9379);
                return;
            }
            a(this.uGd, "edit_address:fail", null);
            AppMethodBeat.o(9379);
        } else if (i == 4) {
            ab.i("MicroMsg.MsgHandler", "request pay, resultCode = ".concat(String.valueOf(i2)));
            if (this.uGz != -1) {
                if (JN(this.uGz) != null) {
                    ab.d("MicroMsg.MsgHandler", "hy: has blocked ");
                    this.uGd = JN(this.uGz).uGd;
                    this.umI = JN(this.uGz).umI;
                }
            }
            this.uGz = -1;
            if (i2 == -1) {
                hashMap = new HashMap();
                if (intent != null) {
                    ab.i("MicroMsg.MsgHandler", "closePage: %s", Integer.valueOf(intent.getIntExtra("key_jsapi_close_page_after_pay", 0)));
                    if (intent.getIntExtra("key_jsapi_close_page_after_pay", 0) == 1) {
                        try {
                            if (this.context != null && (this.context instanceof Activity)) {
                                ((Activity) this.context).finish();
                            }
                            if (this.umI != null) {
                                this.umI.cZb();
                                this.umI.W(null);
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                        }
                    }
                    i5 = intent.getIntExtra("key_is_clear_failure", -1);
                    if (i5 == 0) {
                        hashMap.put("pay_status", "pending");
                    } else if (i5 == 1) {
                        hashMap.put("pay_status", "fail");
                    }
                }
                a(this.uGd, "get_brand_wcpay_request:ok", hashMap);
                AppMethodBeat.o(9379);
            } else if (i2 == 5) {
                hashMap2 = new HashMap();
                if (intent != null) {
                    i3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                    bc2 = bo.nullAsNil(intent.getStringExtra("key_jsapi_pay_err_msg"));
                    hashMap2.put("err_code", Integer.valueOf(i3));
                    hashMap2.put("err_desc", bc2);
                    ab.e("MicroMsg.MsgHandler", "hy: pay jsapi failed. errCode: %d, errMsg: %s", Integer.valueOf(i3), bc2);
                }
                a(this.uGd, "get_brand_wcpay_request:fail", hashMap2);
                AppMethodBeat.o(9379);
            } else {
                hashMap2 = new HashMap();
                if (intent != null) {
                    i3 = intent.getIntExtra("key_is_clear_failure", -1);
                    if (i3 == 0) {
                        hashMap2.put("pay_status", "pending");
                    } else if (i3 == 1) {
                        hashMap2.put("pay_status", "fail");
                    }
                }
                a(this.uGd, "get_brand_wcpay_request:cancel", hashMap2);
                AppMethodBeat.o(9379);
            }
        } else if (i == 27) {
            ab.i("MicroMsg.MsgHandler", "request ibg prepay request, resultCode = ".concat(String.valueOf(i2)));
            if (this.uGz != -1) {
                ab.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.uGd = JN(this.uGz).uGd;
                this.umI = JN(this.uGz).umI;
                this.uGz = -1;
            }
            if (i2 == -1) {
                if (intent != null) {
                    if (intent.hasExtra("url")) {
                        str = null;
                        if (intent.hasExtra("view_port_code")) {
                            str = intent.getStringExtra("view_port_code");
                        }
                        try {
                            this.umI.he(intent.getStringExtra("url"), str);
                        } catch (RemoteException e2) {
                            ab.e("MicroMsg.MsgHandler", "loadUrl ex: %s", e2.getMessage());
                        }
                    }
                }
                a(this.uGd, "get_h5_prepay_request:ok", null);
                AppMethodBeat.o(9379);
                return;
            }
            a(this.uGd, "get_h5_prepay_request:cancel", null);
            AppMethodBeat.o(9379);
        } else if (i == 5) {
            ab.i("MicroMsg.MsgHandler", "request jump to mall, resultCode = ".concat(String.valueOf(i2)));
            if (i2 == -1) {
                a(this.uGd, "jump_wcmall:ok", null);
                AppMethodBeat.o(9379);
                return;
            }
            a(this.uGd, "jump_wcmall:fail", null);
            AppMethodBeat.o(9379);
        } else if (i == 6) {
            ab.i("MicroMsg.MsgHandler", "request jump to product view, resultCode = ".concat(String.valueOf(i2)));
            if (i2 == -1) {
                a(this.uGd, "open_product_view:ok", null);
                AppMethodBeat.o(9379);
                return;
            }
            a(this.uGd, "open_product_view:fail", null);
            AppMethodBeat.o(9379);
        } else {
            WebViewJSSDKFileItem aex;
            WebViewJSSDKVideoItem webViewJSSDKVideoItem;
            Map hashMap5;
            Bundle bundleExtra;
            int i7;
            Context context;
            Bundle bundle;
            if (i == 7) {
                ab.i("MicroMsg.MsgHandler", "request bind card, resultCode = ".concat(String.valueOf(i2)));
                if (i2 == -1) {
                    a(this.uGd, "get_brand_wcpay_bind_card_request:ok", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_brand_wcpay_bind_card_request:ok");
                } else {
                    a(this.uGd, "get_brand_wcpay_bind_card_request:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_brand_wcpay_bind_card_request:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 9) {
                ab.i("MicroMsg.MsgHandler", "request open wxcredit, resultCode = ".concat(String.valueOf(i2)));
                if (i2 == -1) {
                    a(this.uGd, "get_wcpay_create_credit_card_request:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "get_wcpay_create_credit_card_request:fail", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 8) {
                ab.i("MicroMsg.MsgHandler", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(i2)));
                switch (i2) {
                    case -1:
                        a(this.uGd, "jump_to_biz_profile:ok", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        a(this.uGd, "jump_to_biz_profile:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 2:
                    case 3:
                        a(this.uGd, "jump_to_biz_profile:check_fail", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "jump_to_biz_profile:fail", null);
                        ab.e("MicroMsg.MsgHandler", "unknown resultCode");
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 10) {
                if (i2 == 0) {
                    ab.i("MicroMsg.MsgHandler", "open scan product ui back");
                    a(this.uGd, "open_scan_product_view:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 11) {
                ab.i("MicroMsg.MsgHandler", "request transfer_money, resultCode = ".concat(String.valueOf(i2)));
                if (i2 == -1) {
                    a(this.uGd, "get_transfer_money_request:ok", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_transfer_money_request:ok");
                } else {
                    a(this.uGd, "get_transfer_money_request:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_transfer_money_request:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 17) {
                ab.i("MicroMsg.MsgHandler", "request open_wcpay_specific_view, resultCode = ".concat(String.valueOf(i2)));
                if (intent != null) {
                    if ("1".equals(intent.getStringExtra("closeWebView"))) {
                        ab.i("MicroMsg.MsgHandler", "close web view");
                        try {
                            this.umI.cZb();
                            this.umI.W(null);
                        } catch (RemoteException e22) {
                            ab.e("MicroMsg.MsgHandler", "REQUEST_OPEN_WCPAY_SPECIFIC_VIEW ex: %s", e22.getMessage());
                        }
                    }
                }
                if (i2 == -1) {
                    a(this.uGd, "open_wcpay_specific_view:ok", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "open_wcpay_specific_view:ok");
                } else {
                    a(this.uGd, "open_wcpay_specific_view:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "open_wcpay_specific_view:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 18) {
                ab.i("MicroMsg.MsgHandler", "request request_wcpay_send_c2c_msg, resultCode = ".concat(String.valueOf(i2)));
                if (i2 == -1) {
                    a(this.uGd, "get_send_c2c_message_request:ok", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_send_c2c_message_request:ok");
                } else if (i2 == 0) {
                    a(this.uGd, "get_send_c2c_message_request:cancel", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_send_c2c_message_request:cancel");
                } else {
                    a(this.uGd, "get_send_c2c_message_request:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_send_c2c_message_request:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 13) {
                ab.d("MicroMsg.MsgHandler", "request choose card, resultCode = ".concat(String.valueOf(i2)));
                hashMap2 = new HashMap();
                if (i2 == -1) {
                    if (intent != null) {
                        hashMap2.put("choose_card_info", bo.bc(intent.getStringExtra("choose_card_info"), ""));
                    }
                    a(this.uGd, "choose_card:ok", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "choose_card:cancel", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    a(this.uGd, "choose_card:fail", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 36) {
                ab.d("MicroMsg.MsgHandler", "request choose invoice, resultCode = ".concat(String.valueOf(i2)));
                hashMap2 = new HashMap();
                if (i2 == -1) {
                    if (intent != null) {
                        hashMap2.put("choose_invoice_info", bo.bc(intent.getStringExtra("choose_invoice_info"), ""));
                    }
                    a(this.uGd, "choose_invoice:ok", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "choose_invoice:cancel", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    a(this.uGd, "choose_invoice:fail", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 16) {
                ab.d("MicroMsg.MsgHandler", "request batch add card, resultCode = ".concat(String.valueOf(i2)));
                hashMap = new HashMap();
                if (intent != null) {
                    hashMap.put("card_list", bo.bc(intent.getStringExtra("card_list"), ""));
                }
                if (i2 == -1) {
                    a(this.uGd, "batch_add_card:ok", hashMap);
                    AppMethodBeat.o(9379);
                    return;
                }
                i5 = 2;
                if (intent != null) {
                    i5 = intent.getIntExtra("result_code", 2);
                }
                if (i5 == 2) {
                    a(this.uGd, "batch_add_card:fail", hashMap);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "batch_add_card:cancel", hashMap);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 23) {
                if (i2 == -1) {
                    a(this.uGd, "batch_view_card:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "batch_view_card:fail", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 15) {
                if (this.uGd == null || bo.isNullOrNil(this.uGd.uIJ)) {
                    ab.e("MicroMsg.MsgHandler", "msg is null");
                    AppMethodBeat.o(9379);
                    return;
                }
                ab.i("MicroMsg.MsgHandler", "request to scan qr code, result code = %d, function is %s", Integer.valueOf(i2), this.uGd.uIJ);
                if (this.uGd.uIJ.equals("scanQRCode")) {
                    switch (i2) {
                        case -1:
                            hashMap2 = new HashMap();
                            if (intent != null) {
                                hashMap2.put("resultStr", intent.getStringExtra("key_scan_result"));
                            }
                            a(this.uGd, "scanQRCode:ok", hashMap2);
                            AppMethodBeat.o(9379);
                            return;
                        case 0:
                            a(this.uGd, "scanQRCode:cancel", null);
                            AppMethodBeat.o(9379);
                            return;
                        default:
                            a(this.uGd, "scanQRCode:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                    }
                }
            } else if (i == 14) {
                ab.i("MicroMsg.MsgHandler", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", Integer.valueOf(i2), Boolean.valueOf(intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false)));
                hashMap = new HashMap();
                if (intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false)) {
                    hashMap.put("memoryWarning", Boolean.TRUE);
                }
                switch (i2) {
                    case -1:
                        str = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                        ab.i("MicroMsg.MsgHandler", "localIds = %s", str);
                        if (!bo.isNullOrNil(str)) {
                            hashMap.put("localIds", str);
                            str = intent.getStringExtra("key_pick_local_pic_source_type");
                            if (str != null) {
                                hashMap.put("sourceType", str);
                            }
                            a(this.uGd, "chooseImage:ok", hashMap);
                            AppMethodBeat.o(9379);
                            return;
                        }
                        break;
                    case 0:
                        a(this.uGd, "chooseImage:cancel", hashMap);
                        AppMethodBeat.o(9379);
                        return;
                }
                a(this.uGd, "chooseImage:fail", hashMap);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 32) {
                switch (i2) {
                    case -1:
                        bc = intent.getStringExtra("key_pick_local_media_local_id");
                        if (!bo.isNullOrNil(bc)) {
                            aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(bc);
                            if (aex != null && (aex instanceof WebViewJSSDKVideoItem)) {
                                webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aex;
                                hashMap5 = new HashMap();
                                hashMap5.put("localId", bc);
                                hashMap5.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                hashMap5.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                hashMap5.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                hashMap5.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                a(this.uGd, "chooseVideo:ok", hashMap5);
                                AppMethodBeat.o(9379);
                                return;
                            }
                        }
                        a(this.uGd, "chooseVideo:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        a(this.uGd, "chooseVideo:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "chooseVideo:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 45) {
                switch (i2) {
                    case -1:
                        bc = intent.getStringExtra("key_pick_local_media_local_id");
                        bc2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                        ab.i("MicroMsg.MsgHandler", "localId:%s", bc);
                        ab.i("MicroMsg.MsgHandler", "thumbLocalId:%s", bc2);
                        if (!bo.isNullOrNil(bc)) {
                            aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(bc);
                            if (aex != null && (aex instanceof WebViewJSSDKVideoItem)) {
                                webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aex;
                                Map hashMap6 = new HashMap();
                                hashMap6.put("localId", bc);
                                hashMap6.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                hashMap6.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                hashMap6.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                hashMap6.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                hashMap6.put("thumbLocalId", bc2);
                                a(this.uGd, "recordVideo:ok", hashMap6);
                                AppMethodBeat.o(9379);
                                return;
                            }
                        }
                        a(this.uGd, "recordVideo:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        a(this.uGd, "recordVideo:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "recordVideo:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 47) {
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            ab.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA data is null,");
                            a(this.uGd, "chooseMedia:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        }
                        i5 = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                        if (i5 == 1) {
                            str = intent.getStringExtra("key_pick_local_media_local_id");
                            bc = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            ab.i("MicroMsg.MsgHandler", "video localId:%s", str);
                            ab.i("MicroMsg.MsgHandler", "video thumbLocalId:%s", bc);
                            if (bo.isNullOrNil(str)) {
                                ab.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                                a(this.uGd, "chooseMedia:fail", null);
                                AppMethodBeat.o(9379);
                                return;
                            }
                            WebViewJSSDKFileItem aex2 = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str);
                            if (aex2 == null || !(aex2 instanceof WebViewJSSDKVideoItem)) {
                                ab.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                                a(this.uGd, "chooseMedia:fail", null);
                                AppMethodBeat.o(9379);
                                return;
                            }
                            WebViewJSSDKVideoItem webViewJSSDKVideoItem2 = (WebViewJSSDKVideoItem) aex2;
                            ab.i("MicroMsg.MsgHandler", "after parse to json data : %s", ap.c(str, bc, webViewJSSDKVideoItem2.duration, webViewJSSDKVideoItem2.height, webViewJSSDKVideoItem2.width, webViewJSSDKVideoItem2.size));
                            hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(1));
                            hashMap.put("localIds", str);
                            a(this.uGd, "chooseMedia:ok", hashMap);
                            AppMethodBeat.o(9379);
                            return;
                        } else if (i5 == 2) {
                            str = intent.getStringExtra("key_pick_local_media_local_ids");
                            ab.i("MicroMsg.MsgHandler", "chooseMedia localIds:%s", str);
                            if (bo.isNullOrNil(str)) {
                                ab.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                                a(this.uGd, "chooseMedia:fail", null);
                                AppMethodBeat.o(9379);
                                return;
                            }
                            hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(2));
                            hashMap.put("localIds", str);
                            a(this.uGd, "chooseMedia:ok", hashMap);
                            AppMethodBeat.o(9379);
                            return;
                        } else {
                            ab.e("MicroMsg.MsgHandler", "type:%d is error", Integer.valueOf(i5));
                            a(this.uGd, "chooseMedia:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        }
                    case 0:
                        a(this.uGd, "chooseMedia:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "chooseMedia:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 46) {
                switch (i2) {
                    case -1:
                        a(this.uGd, "previewVideo:ok", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        a(this.uGd, "previewVideo:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "previewVideo:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 19) {
                ab.i("MicroMsg.MsgHandler", "request to config exdevice wifi connection, result code = ".concat(String.valueOf(i2)));
                switch (i2) {
                    case -1:
                        a(this.uGd, "configWXDeviceWiFi:ok", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        hashMap2 = null;
                        if (intent != null) {
                            if (!intent.getBooleanExtra("is_wifi_connected", true)) {
                                hashMap2 = new HashMap();
                                hashMap2.put("desc", "wifi_not_connected");
                            }
                        }
                        a(this.uGd, "configWXDeviceWiFi:cancel", hashMap2);
                        AppMethodBeat.o(9379);
                        return;
                    case 1:
                        a(this.uGd, "configWXDeviceWiFi:fail", null);
                        break;
                }
                AppMethodBeat.o(9379);
                return;
            } else if (i == 20) {
                ab.i("MicroMsg.MsgHandler", "request request_verify_wcpay_password, resultCode = ".concat(String.valueOf(i2)));
                hashMap = new HashMap();
                if (i2 == -1) {
                    CharSequence charSequence = "";
                    if (intent != null) {
                        charSequence = bo.bc(intent.getStringExtra("token"), "");
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        ab.i("MicroMsg.MsgHandler", "checkPwdToken is empty, verifyWCPayPassword:fail");
                        a(this.uGd, "verifyWCPayPassword:fail", null);
                        if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                            h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "verifyWCPayPassword:fail");
                        }
                    } else {
                        hashMap.put("token", charSequence);
                        a(this.uGd, "verifyWCPayPassword:ok", hashMap);
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "verifyWCPayPassword:ok");
                        ab.i("MicroMsg.MsgHandler", "checkPwdToken is valid, verifyWCPayPassword:ok");
                    }
                } else {
                    ab.i("MicroMsg.MsgHandler", "resultCode is canlcel, verifyWCPayPassword:fail");
                    a(this.uGd, "verifyWCPayPassword:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "verifyWCPayPassword:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                }
                AppMethodBeat.o(9379);
                return;
            } else if (21 == i) {
                ab.d("MicroMsg.MsgHandler", "hy: callback to see order. directly finish");
                a(this.uGd, "see_order_ok", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 22) {
                ab.i("MicroMsg.MsgHandler", "request get_recevie_biz_hongbao_request, resultCode = ".concat(String.valueOf(i2)));
                if (i2 == -1) {
                    a(this.uGd, "get_recevie_biz_hongbao_request:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i == 0) {
                    a(this.uGd, "get_recevie_biz_hongbao_request:cancel", null);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    a(this.uGd, "get_recevie_biz_hongbao_request:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 24) {
                SnsAdClick snsAdClick2 = null;
                if (this.uGh != null) {
                    snsAdClick2 = (SnsAdClick) this.uGh.getParcelable("KSnsAdTag");
                }
                if (i2 == -1) {
                    if (snsAdClick2 != null) {
                        snsAdClick2.fPZ = 9;
                        a(snsAdClick2);
                    }
                    gB(2, 1);
                    if (bo.getInt((String) this.uGd.puc.get("open_from_scene"), 0) == 4) {
                        com.tencent.mm.plugin.fav.a.h.j(this.uGh.getLong("favlocalid", 0), 0, 0);
                    }
                    try {
                        if (this.umI != null) {
                            str = (String) this.uGd.puc.get("appId");
                            if (TextUtils.isEmpty(str)) {
                                bc = (String) this.uGd.puc.get("appid");
                            } else {
                                bc = str;
                            }
                            a(bc, (String) this.uGd.puc.get("img_url"), 1, this.umI.g(85, null));
                        }
                    } catch (RemoteException e222) {
                        ab.e("MicroMsg.MsgHandler", "invokeAsResult : %s", e222);
                    }
                    a(this.uGd, "share_timeline:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                if (snsAdClick2 != null) {
                    snsAdClick2.fPZ = 10;
                    a(snsAdClick2);
                }
                gB(2, 3);
                a(this.uGd, "share_timeline:ok", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 26) {
                ab.d("MicroMsg.MsgHandler", "select pedometer source resultCode = ".concat(String.valueOf(i2)));
                if (i2 == -1) {
                    a(this.uGd, "selectPedometerSource:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    ab.i("MicroMsg.MsgHandler", "selectPedometerSource result cancel");
                    a(this.uGd, "selectPedometerSource:cancel", null);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    ab.e("MicroMsg.MsgHandler", "selectPedometerSource result fail");
                    a(this.uGd, "selectPedometerSource:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 25) {
                ab.i("MicroMsg.MsgHandler", "hy: get ibg order finish. result code: %d", Integer.valueOf(i2));
                if (this.uGy == 1 && this.umI != null) {
                    try {
                        this.umI.cZb();
                        this.umI.W(null);
                    } catch (RemoteException e2222) {
                        ab.printErrStackTrace("MicroMsg.MsgHandler", e2222, "", new Object[0]);
                    }
                }
                if (i2 == -1) {
                    a(this.uGd, "get_h5_transaction_request:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "get_h5_transaction_request:cancel", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 28) {
                ab.i("MicroMsg.MsgHandler", "get web pay checkout counter request finish. result code: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    hashMap2 = new HashMap();
                    bc = bo.bc(intent.getStringExtra("token"), "");
                    bc2 = bo.bc(intent.getStringExtra("bind_serial"), "");
                    hashMap2.put("token", bc);
                    hashMap2.put("bind_serial", bc2);
                    a(this.uGd, "getWebPayCheckoutCounterRequst:ok", hashMap2);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "getWebPayCheckoutCounterRequst:ok");
                } else {
                    a(this.uGd, "getWebPayCheckoutCounterRequst:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "getWebPayCheckoutCounterRequst:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 31) {
                if (i2 != -1) {
                    a(this.uGd, "openEnterpriseContact:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    str = bundleExtra.getString("result");
                    hashMap = new HashMap();
                    hashMap.put("result", str);
                    a(this.uGd, "openEnterpriseContact:ok", hashMap);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "openEnterpriseContact:ok", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 53) {
                if (i2 != -1) {
                    a(this.uGd, "selectEnterpriseContact:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null) {
                    str = bundleExtra.getString("result");
                    hashMap = new HashMap();
                    hashMap.put("result", str);
                    a(this.uGd, "selectEnterpriseContact:ok", hashMap);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "selectEnterpriseContact:ok", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 29) {
                bc = "MicroMsg.MsgHandler";
                bc2 = "consumedShareCard:ok(r : %b)";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(i2 == -1);
                ab.d(bc, bc2, objArr);
                if (i2 == -1) {
                    a(this.uGd, "consumedShareCard:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "consumedShareCard:fail", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 113) {
                if (i2 == -1) {
                    W(this.uGd);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "chooseImage:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 116) {
                if (i2 == -1) {
                    ad(this.uGd);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "startRecord:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 115) {
                if (i2 == -1) {
                    a(this.uGd, 0);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "chooseVideo:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 117) {
                if (i2 == -1) {
                    a(this.uGd, 1);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "recordVideo:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 118) {
                if (i2 == -1) {
                    a(this.uGd, 1);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "recordVideo:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 119) {
                if (i2 == -1) {
                    aa(this.uGd);
                    AppMethodBeat.o(9379);
                    return;
                }
                ab.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:CAMERA");
                a(this.uGd, "chooseMedia:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 120) {
                if (i2 == -1) {
                    aa(this.uGd);
                    AppMethodBeat.o(9379);
                    return;
                }
                ab.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:MICROPHONE");
                a(this.uGd, "chooseMedia:fail_android_permission_denied", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 30) {
                ab.i("MicroMsg.MsgHandler", "doSelectSingleContact activtiy callback");
                str = (String) this.uGd.puc.get("appId");
                if (this.uGh == null || !TextUtils.isEmpty(str)) {
                    bc = str;
                } else {
                    bc = this.uGh.getString("jsapi_args_appid");
                }
                i7 = bo.getInt((String) this.uGd.puc.get("selectMode"), 0);
                ab.i("MicroMsg.MsgHandler", "select single contact : appId:%s, busiId:%s, selectedMode:%d", bc, (String) this.uGd.puc.get("busiId"), Integer.valueOf(i7));
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            bc2 = null;
                        } else {
                            bc2 = intent.getStringExtra("Select_Conv_User");
                        }
                        if (bc2 != null && bc2.length() != 0) {
                            if (i7 != 0) {
                                if (i7 == 1) {
                                    final m vVar = new com.tencent.mm.plugin.webview.model.v(bc, str, bc2);
                                    com.tencent.mm.kernel.g.Rg().a(1177, new f() {
                                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                            AppMethodBeat.i(9063);
                                            if (g.this.ehJ != null && g.this.ehJ.isShowing()) {
                                                g.this.ehJ.dismiss();
                                                g.this.ehJ = null;
                                            }
                                            com.tencent.mm.kernel.g.Rg().b(1177, (f) this);
                                            if (i == 0 && i2 == 0) {
                                                ab.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
                                                com.tencent.mm.plugin.webview.model.v vVar = (com.tencent.mm.plugin.webview.model.v) mVar;
                                                Map hashMap = new HashMap();
                                                hashMap.put("package", vVar.ulZ);
                                                hashMap.put("sign", vVar.sign);
                                                hashMap.put("headImgUrl", vVar.kKx);
                                                hashMap.put("nickName", vVar.kKw);
                                                hashMap.put("friendRelation", Integer.valueOf(vVar.uma));
                                                ab.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", vVar.ulZ, vVar.sign, vVar.kKw, Integer.valueOf(vVar.uma));
                                                g.a(g.this, g.this.uGd, "selectSingleContact:ok", hashMap);
                                                AppMethodBeat.o(9063);
                                                return;
                                            }
                                            ab.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
                                            g.a(g.this, g.this.uGd, "selectSingleContact:fail", null);
                                            AppMethodBeat.o(9063);
                                        }
                                    });
                                    com.tencent.mm.kernel.g.Rg().d(vVar);
                                    context = this.context;
                                    this.context.getString(R.string.tz);
                                    this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.un), true, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(9064);
                                            com.tencent.mm.kernel.g.Rg().c(vVar);
                                            AppMethodBeat.o(9064);
                                        }
                                    });
                                    break;
                                }
                            }
                            final m pVar = new com.tencent.mm.plugin.webview.model.p(bc, bc2);
                            com.tencent.mm.kernel.g.Rg().a(1566, new f() {
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(9061);
                                    if (g.this.ehJ != null && g.this.ehJ.isShowing()) {
                                        g.this.ehJ.dismiss();
                                        g.this.ehJ = null;
                                    }
                                    com.tencent.mm.kernel.g.Rg().b(1566, (f) this);
                                    if (i == 0 && i2 == 0) {
                                        avm avm;
                                        ab.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
                                        com.tencent.mm.plugin.webview.model.p pVar = (com.tencent.mm.plugin.webview.model.p) mVar;
                                        if (pVar.ehh == null) {
                                            avm = null;
                                        } else {
                                            avm = (avm) pVar.ehh.fsH.fsP;
                                        }
                                        if (avm == null) {
                                            g.a(g.this, g.this.uGd, "selectSingleContact:fail", null);
                                            AppMethodBeat.o(9061);
                                            return;
                                        }
                                        int i3;
                                        Object obj = g.this.uGd.puc.get("result_sign_type");
                                        if (obj != null) {
                                            i3 = bo.getInt((String) obj, 0);
                                        } else {
                                            i3 = 0;
                                        }
                                        Map hashMap = new HashMap();
                                        hashMap.put("package", avm.vYP);
                                        hashMap.put("sign", avm.vYQ);
                                        if (i3 == 1) {
                                            hashMap.put("signType", avm.vYR);
                                        }
                                        hashMap.put(Param.TIMESTAMP, avm.vLo);
                                        hashMap.put("noncestr", avm.vYO);
                                        ab.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", avm.vYP, avm.vYQ);
                                        g.a(g.this, g.this.uGd, "selectSingleContact:ok", hashMap);
                                        AppMethodBeat.o(9061);
                                        return;
                                    }
                                    ab.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
                                    g.a(g.this, g.this.uGd, "selectSingleContact:fail", null);
                                    AppMethodBeat.o(9061);
                                }
                            });
                            com.tencent.mm.kernel.g.Rg().d(pVar);
                            Context context2 = this.context;
                            this.context.getString(R.string.tz);
                            this.ehJ = com.tencent.mm.ui.base.h.b(context2, this.context.getString(R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(9062);
                                    com.tencent.mm.kernel.g.Rg().c(pVar);
                                    AppMethodBeat.o(9062);
                                }
                            });
                            AppMethodBeat.o(9379);
                            return;
                        }
                        ab.e("MicroMsg.MsgHandler", "mmOnActivityResult,selectSingleContact fail, user is null");
                        a(this.uGd, "selectSingleContact:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                        break;
                    case 0:
                        a(this.uGd, "selectSingleContact:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                }
                AppMethodBeat.o(9379);
                return;
            } else if (i == 34) {
                if (i2 == -1) {
                    a(this.uGd, "get_wcpay_realname_verify:ok", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_wcpay_realname_verify:ok");
                } else if (i2 == 1) {
                    a(this.uGd, "get_wcpay_realname_verify:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_wcpay_realname_verify:fail");
                    }
                } else {
                    a(this.uGd, "get_wcpay_realname_verify:cancel", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "get_wcpay_realname_verify:cancel");
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 35) {
                if (i2 == -1) {
                    on onVar = new on();
                    onVar.cKQ.context = this.context;
                    com.tencent.mm.sdk.b.a.xxA.m(onVar);
                    try {
                        this.umI.cZb();
                        this.umI.W(null);
                        AppMethodBeat.o(9379);
                        return;
                    } catch (RemoteException e22222) {
                        ab.printErrStackTrace("MicroMsg.MsgHandler", e22222, "", new Object[0]);
                        AppMethodBeat.o(9379);
                        return;
                    }
                }
                a(this.uGd, "selectWalletCurrency:cancel", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 37) {
                if (this.cEl == null) {
                    ab.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                    a(this.uGd, "send_app_msg:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                str = (String) this.uGd.puc.get("appid");
                snsAdClick = null;
                if (this.uGh != null) {
                    snsAdClick = (SnsAdClick) this.uGh.getParcelable("KSnsAdTag");
                    if (TextUtils.isEmpty(str)) {
                        bc2 = this.uGh.getString("jsapi_args_appid");
                        obj = this.uGd.dcO().get("Internal@AsyncReport");
                        switch (i2) {
                            case -1:
                                if (snsAdClick != null) {
                                    snsAdClick.fPZ = 7;
                                    a(snsAdClick);
                                }
                                com.tencent.mm.pluginsdk.model.app.f Uq2 = com.tencent.mm.pluginsdk.model.app.g.Uq(bc2);
                                if (intent != null) {
                                    str2 = intent.getStringExtra("enterprise_biz_name");
                                    final long longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                    bc3 = intent.getStringExtra("enterprise_share_append_text");
                                    if (str2 != null && str2.length() != 0) {
                                        str3 = (String) this.uGd.puc.get("img_url");
                                        this.uGd.puc.get("desc");
                                        str4 = (String) this.uGd.puc.get("src_username");
                                        str5 = (String) this.uGd.puc.get("src_displayname");
                                        dcx = dcx();
                                        l.a(this.uGd.dcO(), agw("sendAppMessage"), str2, bc2);
                                        if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                            b(this.uGd, true);
                                        }
                                        if (!bo.isNullOrNil(str3)) {
                                            final com.tencent.mm.pluginsdk.model.app.f fVar = Uq2;
                                            str6 = bc2;
                                            str7 = str2;
                                            str8 = str3;
                                            str9 = str4;
                                            final String str11 = str5;
                                            final String str12 = bc3;
                                            final String str13 = dcx;
                                            com.tencent.mm.at.o.ahk().a(str3, new com.tencent.mm.at.c.c() {
                                                public final void C(Bitmap bitmap) {
                                                    AppMethodBeat.i(9065);
                                                    if (g.this.nBv != null) {
                                                        g.this.nBv.dismiss();
                                                    }
                                                    if (longExtra >= 0) {
                                                        com.tencent.mm.aj.a.c aK = com.tencent.mm.aj.z.aeT().aK(longExtra);
                                                        synchronized (com.tencent.mm.aj.a.e.fxC) {
                                                            try {
                                                                String aae = com.tencent.mm.aj.a.e.aae();
                                                                com.tencent.mm.aj.a.e.d(aK);
                                                                g.a(g.this, fVar, str6, str7, str8, str9, str11, str12, str13);
                                                                com.tencent.mm.aj.a.e.rx(aae);
                                                            } catch (Throwable th) {
                                                                while (true) {
                                                                    AppMethodBeat.o(9065);
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        g.a(g.this, fVar, str6, str7, str8, str9, str11, str12, str13);
                                                    }
                                                    if (g.this.context != null) {
                                                        com.tencent.mm.ui.base.h.bQ(g.this.context, g.this.context.getString(R.string.ate));
                                                    }
                                                    g.a(g.this, g.this.uGd, "send_app_msg:ok", null);
                                                    AppMethodBeat.o(9065);
                                                }
                                            });
                                            break;
                                        }
                                        if (longExtra >= 0) {
                                            com.tencent.mm.aj.a.c aK = com.tencent.mm.aj.z.aeT().aK(longExtra);
                                            synchronized (com.tencent.mm.aj.a.e.fxC) {
                                                try {
                                                    String aae = com.tencent.mm.aj.a.e.aae();
                                                    com.tencent.mm.aj.a.e.d(aK);
                                                    a(Uq2, bc2, str2, str3, str4, str5, bc3, dcx);
                                                    com.tencent.mm.aj.a.e.rx(aae);
                                                } catch (Throwable th) {
                                                    while (true) {
                                                        AppMethodBeat.o(9379);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        a(Uq2, bc2, str2, str3, str4, str5, bc3, dcx);
                                        com.tencent.mm.ui.base.h.bN(this.context, this.context.getString(R.string.ate));
                                        a(this.uGd, "send_app_msg:ok", null);
                                        AppMethodBeat.o(9379);
                                        return;
                                    }
                                    ab.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                    a(this.uGd, "send_app_msg:fail", null);
                                    AppMethodBeat.o(9379);
                                    return;
                                }
                                AppMethodBeat.o(9379);
                                return;
                                break;
                            case 0:
                                if (snsAdClick != null) {
                                    snsAdClick.fPZ = 8;
                                    a(snsAdClick);
                                }
                                l.a(this.uGd.dcO(), agw("sendAppMessage"), null, bc2);
                                if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                    b(this.uGd, true);
                                }
                                a(this.uGd, "send_app_msg:cancel", null);
                                AppMethodBeat.o(9379);
                                return;
                        }
                        AppMethodBeat.o(9379);
                        return;
                    }
                }
                bc2 = str;
                obj = this.uGd.dcO().get("Internal@AsyncReport");
                switch (i2) {
                    case -1:
                        break;
                    case 0:
                        break;
                }
                AppMethodBeat.o(9379);
                return;
            } else if (i == 38) {
                if (i2 == -1) {
                    ab.i("MicroMsg.MsgHandler", "hy: soter auth ok");
                    a(this.uGd, "soter_biometric_authentication:ok", i.aq(intent.getExtras()));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    ab.w("MicroMsg.MsgHandler", "hy: soter auth failed");
                    a(this.uGd, "soter_biometric_authentication:fail", i.aq(intent.getExtras()));
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    ab.e("MicroMsg.MsgHandler", "hy: soter user cancelled");
                    a(this.uGd, "soter_biometric_authentication:cancel", i.aq(intent.getExtras()));
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 39) {
                if (i2 == -1) {
                    a(this.uGd, "unbind_bank_card:ok", null);
                } else if (i2 == 1) {
                    a(this.uGd, "unbind_bank_card:fail", null);
                } else {
                    a(this.uGd, "unbind_bank_card:cancel", null);
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 40) {
                if (i2 == -1) {
                    bundle = new Bundle();
                    if (intent != null) {
                        ArrayList f = f(intent.getLongArrayExtra("k_outside_expose_proof_item_list"));
                        int size = f.size();
                        String[] strArr = new String[size];
                        String[] strArr2 = new String[size];
                        String[] strArr3 = new String[size];
                        int[] iArr = new int[size];
                        int[] iArr2 = new int[size];
                        for (i3 = 0; i3 < size; i3++) {
                            bi biVar = (bi) f.get(i3);
                            strArr[i3] = String.valueOf(biVar.HB());
                            if (intent.getBooleanExtra("k_is_group_chat", false)) {
                                if (biVar.bws()) {
                                    strArr2[i3] = bf.oz(biVar.HG());
                                } else {
                                    strArr2[i3] = bf.oz(biVar.getContent());
                                }
                                strArr3[i3] = bf.oy(biVar.getContent());
                            } else {
                                if (biVar.bws()) {
                                    strArr2[i3] = biVar.HG();
                                } else {
                                    strArr2[i3] = biVar.getContent();
                                }
                                strArr3[i3] = biVar.HE();
                            }
                            if (biVar.HC() == 1) {
                                strArr3[i3] = r.Yz();
                            }
                            if (strArr2[i3] == null) {
                                strArr2[i3] = "";
                            }
                            if (strArr3[i3] == null) {
                                strArr3[i3] = "";
                            }
                            if (biVar.bAA()) {
                                iArr[i3] = 49;
                            } else {
                                iArr[i3] = biVar.getType();
                            }
                            iArr2[i3] = (int) (biVar.HD() / 1000);
                        }
                        bundle.putStringArray("msgIds", strArr);
                        bundle.putStringArray("contents", strArr2);
                        bundle.putStringArray("senders", strArr3);
                        bundle.putIntArray("msgTypes", iArr);
                        bundle.putIntArray("msgTimes", iArr2);
                        try {
                            if (this.umI != null) {
                                this.umI.c(48, bundle);
                            }
                            a(this.uGd, "select chat record:ok", null);
                            AppMethodBeat.o(9379);
                            return;
                        } catch (RemoteException e222222) {
                            ab.w("MicroMsg.MsgHandler", "onGetMsgProofItems exception" + e222222.getMessage());
                            a(this.uGd, "select chat record:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        }
                    }
                    a(this.uGd, "select chat record:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "select chat record:cancel", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 41) {
                if (i2 == -1) {
                    a(this.uGd, "id_card_realname_verify:ok", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "id_card_realname_verify:ok");
                } else if (i2 == 1) {
                    a(this.uGd, "id_card_realname_verify:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "id_card_realname_verify:fail");
                    }
                } else {
                    a(this.uGd, "id_card_realname_verify:cancel", null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "id_card_realname_verify:cancel");
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 42) {
                if (i2 == -1) {
                    if (intent != null) {
                        str = bo.bc(intent.getStringExtra("gameRegionName"), "");
                        hashMap = new HashMap();
                        hashMap.put("gameRegionName", str);
                        a(this.uGd, "get game region:ok", hashMap);
                        AppMethodBeat.o(9379);
                        return;
                    }
                    a(this.uGd, "get game region:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    a(this.uGd, "get game region:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    a(this.uGd, "get game region:cancel", null);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 43) {
                ab.i("MicroMsg.MsgHandler", "request to open file chooser for id card image, result code = ".concat(String.valueOf(i2)));
                switch (i2) {
                    case -1:
                        hashMap2 = new HashMap();
                        bc = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                        ab.i("MicroMsg.MsgHandler", "localIds = %s", bc);
                        if (bo.isNullOrNil(bc)) {
                            a(this.uGd, "chooseIdCard:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        }
                        try {
                            JSONArray jSONArray = new JSONArray(bc);
                            if (jSONArray.length() > 0) {
                                hashMap2.put("localId", jSONArray.get(0).toString());
                                if (intent.getStringExtra("key_pick_local_pic_source_type") != null) {
                                    hashMap2.put("sourceType", FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                                }
                                a(this.uGd, "chooseIdCard:ok", hashMap2);
                                AppMethodBeat.o(9379);
                                return;
                            }
                            a(this.uGd, "chooseImage:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        } catch (Exception e3) {
                            ab.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                            a(this.uGd, "chooseImage:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        }
                    case 0:
                        a(this.uGd, "chooseIdCard:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "chooseImage:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 48) {
                ab.i("MicroMsg.MsgHandler", "alvinluo: requestWxFacePictureVerify resultCode: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "requestWxFacePictureVerify:ok", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    a(this.uGd, "requestWxFacePictureVerify:fail", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "requestWxFacePictureVerify:cancel", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 49) {
                ab.i("MicroMsg.MsgHandler", "hy: REQUEST_FACE_DETECT_WITH_VIDEO resultCode: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "requestWxFacePictureVerifyUnionVideo:ok", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    a(this.uGd, "requestWxFacePictureVerifyUnionVideo:fail", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "requestWxFacePictureVerifyUnionVideo:cancel", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 52) {
                ab.i("MicroMsg.MsgHandler", "share emmotion resultCode: %d", Integer.valueOf(i2));
                switch (i2) {
                    case -1:
                        EmojiInfo E;
                        bc2 = bo.bc(intent.getStringExtra("Select_Conv_User"), "");
                        bc = bo.bc(intent.getStringExtra("emoji_thumb_path"), "");
                        str2 = bo.bc(intent.getStringExtra("emoji_activity_id"), "");
                        EmojiInfo aqi = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().aUp().aqi(bc);
                        if (aqi == null) {
                            str3 = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", bc);
                            if (com.tencent.mm.vfs.e.ct(str3)) {
                                i5 = com.tencent.mm.sdk.platformtools.r.amo(str3) ? EmojiInfo.zYS : EmojiInfo.zYR;
                                EmojiInfo emojiInfo = new EmojiInfo();
                                emojiInfo.vS(bc);
                                emojiInfo.Vp(EmojiInfo.yau);
                                emojiInfo.setType(i5);
                                emojiInfo.setSize((int) com.tencent.mm.vfs.e.asZ(str3));
                                emojiInfo.duY();
                                if (!bo.isNullOrNil(str2)) {
                                    emojiInfo.field_activityid = str2;
                                }
                                E = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().aUp().E(emojiInfo);
                                for (String str14 : bo.P(bo.bc(bc2, "").split(","))) {
                                    if (E != null) {
                                        com.tencent.mm.plugin.emoji.model.j.bki().a(str14, E, null);
                                    }
                                }
                                str14 = intent.getStringExtra("custom_send_text");
                                if (!bo.isNullOrNil(str14)) {
                                    qb qbVar = new qb();
                                    qbVar.cMq.cMr = bc2;
                                    qbVar.cMq.content = str14;
                                    qbVar.cMq.type = t.nK(bc2);
                                    qbVar.cMq.flags = 0;
                                    com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                                }
                                com.tencent.mm.ui.base.h.bN(this.context, this.context.getResources().getString(R.string.to));
                                a(this.uGd, "shareEmoticon:ok", null);
                                AppMethodBeat.o(9379);
                                return;
                            }
                        }
                        E = aqi;
                        for (String str142 : bo.P(bo.bc(bc2, "").split(","))) {
                        }
                        str142 = intent.getStringExtra("custom_send_text");
                        if (bo.isNullOrNil(str142)) {
                        }
                        com.tencent.mm.ui.base.h.bN(this.context, this.context.getResources().getString(R.string.to));
                        a(this.uGd, "shareEmoticon:ok", null);
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        a(this.uGd, "shareEmoticon:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "shareEmoticon:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 50) {
                ab.i("MicroMsg.MsgHandler", "hy: requestWxFaceRegisterInternal resultCode: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "requestWxFaceRegisterInternal:ok", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    a(this.uGd, "requestWxFaceRegisterInternal:fail", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "requestWxFaceRegisterInternal:cancel", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 51) {
                ab.i("MicroMsg.MsgHandler", "hy: requestWxFaceVerifyInternal resultCode: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "requestWxFaceVerifyInternal:ok", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    a(this.uGd, "requestWxFaceVerifyInternal:fail", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "requestWxFaceVerifyInternal:cancel", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 54) {
                if (i2 != -1 || intent == null) {
                    a(this.uGd, "selectContact:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                str142 = intent.getStringExtra("Select_Contact");
                bc = s.mJ(str142);
                bundle = new Bundle();
                bundle.putString("username", str142);
                bundle.putString("nickname", bc);
                bundle.putInt("ret", 0);
                try {
                    if (this.umI != null) {
                        this.umI.c(128, bundle);
                    }
                } catch (RemoteException e2222222) {
                    ab.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e2222222.getMessage());
                }
                a(this.uGd, "selectContact:succ", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 65) {
                if (i2 != -1 || intent == null) {
                    a(this.uGd, "selectContact:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                bc = intent.getStringExtra("Select_Contact");
                str142 = s.mJ(bc);
                hashMap5 = new HashMap();
                hashMap5.put("username", bc);
                hashMap5.put("nickname", str142);
                com.tencent.mm.ah.h qo = com.tencent.mm.ah.o.act().qo(bc);
                if (qo != null) {
                    hashMap5.put("headurl", qo.acl());
                }
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(bc);
                if (!(aoO == null || bo.isNullOrNil(aoO.Hq()))) {
                    hashMap5.put("alias", aoO.Hq());
                }
                a(this.uGd, "selectContact:ok", hashMap5);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 55) {
                ab.i("MicroMsg.MsgHandler", "hy: REQUEST_SET_RESET_WALLET_PWD_REQUEST resultCode: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "setWCPayPassword:ok", i.aq(intent != null ? intent.getExtras() : null));
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "setWCPayPassword:ok");
                } else if (i2 == 0) {
                    a(this.uGd, "setWCPayPassword:cancel", i.aq(intent != null ? intent.getExtras() : null));
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "setWCPayPassword:cancel");
                } else {
                    a(this.uGd, "setWCPayPassword:fail", i.aq(intent != null ? intent.getExtras() : null));
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "setWCPayPassword:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                }
                ab.d("MicroMsg.MsgHandler", "WalletJsApiReqKey: " + com.tencent.mm.pluginsdk.wallet.f.dlI());
                AppMethodBeat.o(9379);
                return;
            } else if (i == 56) {
                ab.i("MicroMsg.MsgHandler", "request choose invoice title, resultCode = ".concat(String.valueOf(i2)));
                hashMap2 = new HashMap();
                if (i2 == -1) {
                    if (intent != null) {
                        hashMap2.put("choose_invoice_title_info", bo.bc(intent.getStringExtra("choose_invoice_title_info"), ""));
                    }
                    a(this.uGd, "chooseInvoiceTitle:ok", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "chooseInvoiceTitle:cancel", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    a(this.uGd, "chooseInvoiceTitle:fail", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 57) {
                ab.i("MicroMsg.MsgHandler", "request voice login verify, resultCode: %d", Integer.valueOf(i2));
                hashMap2 = new HashMap();
                if (i2 == -1) {
                    hashMap2.put("err_code", Integer.valueOf(0));
                    hashMap2.put("err_msg", "verify ok");
                    a(this.uGd, "request voice login verify:ok", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    hashMap2.put("err_code", Integer.valueOf(1));
                    hashMap2.put("err_msg", "verify cancel");
                    a(this.uGd, "request voice login verify:cancel", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    hashMap2.put("err_code", Integer.valueOf(2));
                    hashMap2.put("err_msg", "verify error");
                    a(this.uGd, "request voice login verify:error", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 59) {
                ab.i("MicroMsg.MsgHandler", "hy: REQUEST_OPEN_CARD_LIST resultCode: %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "openWCPayCardList:ok", i.aq(intent != null ? intent.getExtras() : null));
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openWCPayCardList:ok");
                } else if (i2 == 0) {
                    a(this.uGd, "openWCPayCardList:fail", i.aq(intent != null ? intent.getExtras() : null));
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openWCPayCardList:fail");
                    }
                } else {
                    a(this.uGd, "openWCPayCardList:fail", i.aq(intent != null ? intent.getExtras() : null));
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openWCPayCardList:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 60) {
                if (intent != null) {
                    str142 = intent.getStringExtra("key_callback");
                    ab.i("MicroMsg.MsgHandler", "open offline pay view callback: %s", str142);
                    a(this.uGd, String.format("openOfflinePayView:%s", new Object[]{str142}), null);
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openOfflinePayView:ok");
                } else {
                    a(this.uGd, "openOfflinePayView:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                        h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openOfflinePayView:fail");
                    }
                }
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 58) {
                ab.i("MicroMsg.MsgHandler", "request bind email, resultCode %d", Integer.valueOf(i2));
                if (i2 == -1) {
                    a(this.uGd, "bindEmail:ok", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "bindEmail:cancel", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 62) {
                ab.i("MicroMsg.MsgHandler", "[openRealnameAuth]resultCode:%d", Integer.valueOf(i2));
                hashMap2 = new HashMap();
                if (i2 == -1) {
                    ab.i("MicroMsg.MsgHandler", "openRealnameAuth ok");
                    bc = intent.getStringExtra("intent_auth_token");
                    if (bo.isNullOrNil(bc)) {
                        a(this.uGd, "openRealnameAuth:fail", hashMap2);
                        AppMethodBeat.o(9379);
                        return;
                    }
                    hashMap2.put("err_code", Integer.valueOf(0));
                    hashMap2.put("auth_token", bc);
                    ab.d("MicroMsg.MsgHandler", "authToken:%s", bc);
                    a(this.uGd, "openRealnameAuth:ok", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    ab.i("MicroMsg.MsgHandler", "openRealnameAuth cancel");
                    a(this.uGd, "openRealnameAuth:cancel", hashMap2);
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    if (i2 == 1) {
                        ab.i("MicroMsg.MsgHandler", "openRealnameAuth fail");
                        if (intent != null) {
                            i3 = intent.getIntExtra("intent_err_code", -1);
                            bc2 = intent.getStringExtra("intent_err_msg");
                            hashMap2.put("err_code", Integer.valueOf(i3));
                            hashMap2.put("err_msg", bc2);
                            a(this.uGd, "openRealnameAuth:fail", hashMap2);
                            ab.i("MicroMsg.MsgHandler", "openRealnameAuth errCode:%d, errMsg:%s", Integer.valueOf(i3), bc2);
                            AppMethodBeat.o(9379);
                            return;
                        }
                        a(this.uGd, "openRealnameAuth:fail", hashMap2);
                    }
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 61) {
                if (this.cEl == null) {
                    ab.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                    a(this.uGd, "sendSingleAppMessage:fail", null);
                    AppMethodBeat.o(9379);
                    return;
                }
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            bc2 = null;
                        } else {
                            bc2 = intent.getStringExtra("Select_Conv_User");
                        }
                        if (bc2 == null || bc2.length() == 0) {
                            ab.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                            a(this.uGd, "sendSingleAppMessage:fail", null);
                            AppMethodBeat.o(9379);
                            return;
                        }
                        obj = this.uGd.puc.get("__jsapi_fw_ext_info");
                        if (obj instanceof Bundle) {
                            str142 = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
                        } else {
                            str142 = null;
                        }
                        str142 = this.uGr.agj(str142);
                        if (bo.isNullOrNil(str142)) {
                            str142 = (String) this.uGd.puc.get("appId");
                        }
                        final m vVar2 = new com.tencent.mm.plugin.webview.model.v(str142, "", bc2);
                        final Intent intent2 = intent;
                        com.tencent.mm.kernel.g.Rg().a(1177, new f() {
                            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                AppMethodBeat.i(9066);
                                if (g.this.ehJ != null && g.this.ehJ.isShowing()) {
                                    g.this.ehJ.dismiss();
                                    g.this.ehJ = null;
                                }
                                com.tencent.mm.kernel.g.Rg().b(1177, (f) this);
                                if (i == 0 && i2 == 0) {
                                    ab.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
                                    com.tencent.mm.plugin.webview.model.v vVar = (com.tencent.mm.plugin.webview.model.v) mVar;
                                    Map hashMap = new HashMap();
                                    hashMap.put(Scopes.OPEN_ID, vVar.ulZ);
                                    hashMap.put("headImgUrl", vVar.kKx);
                                    hashMap.put("nickName", vVar.kKw);
                                    ab.d("MicroMsg.MsgHandler", "opnid:%s, nick_name:%s", vVar.ulZ, vVar.kKw);
                                    g.a(g.this, null, "", bc2, (String) g.this.uGd.puc.get("img_url"), (String) g.this.uGd.puc.get("src_username"), (String) g.this.uGd.puc.get("src_displayname"), intent2 == null ? null : intent2.getStringExtra("custom_send_text"), null);
                                    if (g.this.context != null) {
                                        com.tencent.mm.ui.base.h.bQ(g.this.context, g.this.context.getResources().getString(R.string.to));
                                    }
                                    g.a(g.this, g.this.uGd, "sendSingleAppMessage:ok", hashMap);
                                    AppMethodBeat.o(9066);
                                    return;
                                }
                                ab.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
                                g.a(g.this, g.this.uGd, "sendSingleAppMessage:fail", null);
                                AppMethodBeat.o(9066);
                            }
                        });
                        com.tencent.mm.kernel.g.Rg().d(vVar2);
                        context = this.context;
                        this.context.getString(R.string.tz);
                        this.ehJ = com.tencent.mm.ui.base.h.b(context, this.context.getString(R.string.un), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(9067);
                                com.tencent.mm.kernel.g.Rg().c(vVar2);
                                AppMethodBeat.o(9067);
                            }
                        });
                        AppMethodBeat.o(9379);
                        return;
                    case 0:
                        a(this.uGd, "sendSingleAppMessage:cancel", null);
                        AppMethodBeat.o(9379);
                        return;
                    default:
                        a(this.uGd, "sendSingleAppMessage:fail", null);
                        AppMethodBeat.o(9379);
                        return;
                }
            } else if (i == 75) {
                if (i2 == -1) {
                    dcz();
                    AppMethodBeat.o(9379);
                    return;
                }
                a(this.uGd, "geo_location:fail", null);
                AppMethodBeat.o(9379);
                return;
            } else if (i == 63) {
                ab.i("MicroMsg.MsgHandler", "REQUEST_FACE_VERIFY_FOR_PAY resultCode: %d", Integer.valueOf(i2));
                i5 = intent.getIntExtra("err_code", 0);
                intent.getStringExtra("err_msg");
                i3 = intent.getIntExtra("scene", 0);
                i4 = intent.getIntExtra("countFace", 0);
                long longExtra2 = intent.getLongExtra("totalTime", 0);
                i7 = intent.getIntExtra("err_type", 6);
                ab.i("MicroMsg.MsgHandler", "errCode： ".concat(String.valueOf(i5)));
                ab.i("MicroMsg.MsgHandler", "scene： ".concat(String.valueOf(i3)));
                ab.i("MicroMsg.MsgHandler", "countFace： ".concat(String.valueOf(i4)));
                ab.i("MicroMsg.MsgHandler", "totalTime： ".concat(String.valueOf(longExtra2)));
                ab.i("MicroMsg.MsgHandler", "errorType： ".concat(String.valueOf(i7)));
                if (i2 == -1) {
                    h.pYm.e(15711, Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(i4), Long.valueOf(longExtra2), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i5));
                    a(this.uGd, "faceVerifyForPay:ok", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    h.pYm.e(15711, Integer.valueOf(i3), Integer.valueOf(3), Integer.valueOf(i4), Long.valueOf(longExtra2), Integer.valueOf(2), Integer.valueOf(i7), Integer.valueOf(i5));
                    a(this.uGd, "faceVerifyForPay:fail", i.aq(intent != null ? intent.getExtras() : null));
                    AppMethodBeat.o(9379);
                    return;
                } else {
                    if (i2 == 0) {
                        h.pYm.e(15711, Integer.valueOf(i3), Integer.valueOf(2), Integer.valueOf(i4), Long.valueOf(longExtra2), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i5));
                        a(this.uGd, "faceVerifyForPay:cancel", i.aq(intent != null ? intent.getExtras() : null));
                    }
                    AppMethodBeat.o(9379);
                    return;
                }
            } else if (i == 64) {
                ab.i("MicroMsg.MsgHandler", "REQUEST_FACE_VERIFY resultCode: %d", Integer.valueOf(i2));
                bundleExtra = new Bundle();
                if (intent != null) {
                    bc = intent.getStringExtra("err_msg");
                    bc2 = intent.getStringExtra("k_bio_id");
                    str2 = intent.getStringExtra("key_pic_cdn_id");
                    str3 = intent.getStringExtra("key_cdn_aes_key");
                    int intExtra = intent.getIntExtra("check_alive_type", 0);
                    bundleExtra.putString("err_msg", bc);
                    bundleExtra.putInt("check_alive_type", intExtra);
                    bundleExtra.putString("bioid", bc2);
                    bundleExtra.putString("fileid", str2);
                    bundleExtra.putString("aeskey", str3);
                    ab.i("MicroMsg.MsgHandler", "errMsg： %s ,bioID：%s ,fileID： %s ,aesKey： %s ,check_alive_type： %d", bc, bc2, str2, str3, Integer.valueOf(intExtra));
                }
                if (i2 == -1) {
                    a(this.uGd, "internelWxFaceVerify:ok", i.aq(bundleExtra));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 1) {
                    a(this.uGd, "internelWxFaceVerify:fail", i.aq(bundleExtra));
                    AppMethodBeat.o(9379);
                    return;
                } else if (i2 == 0) {
                    a(this.uGd, "internelWxFaceVerify:cancel", i.aq(bundleExtra));
                }
            }
            AppMethodBeat.o(9379);
        }
    }

    private boolean a(com.tencent.mm.pluginsdk.model.app.f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(9380);
        if (this.cEl == null) {
            ab.w("MicroMsg.MsgHandler", "doSendAppMsg: but appmsg is null");
            AppMethodBeat.o(9380);
            return false;
        }
        com.tencent.mm.at.o.ahk();
        Bitmap kR = com.tencent.mm.at.c.kR(str3);
        if (!(kR == null || kR.isRecycled())) {
            ab.i("MicroMsg.MsgHandler", "thumb image is not null");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            this.cEl.thumbData = byteArrayOutputStream.toByteArray();
        }
        py pyVar = new py();
        pyVar.cMe.cEl = this.cEl;
        pyVar.cMe.appId = str;
        pyVar.cMe.appName = fVar == null ? "" : fVar.field_appName;
        pyVar.cMe.toUser = str2;
        pyVar.cMe.cMf = 2;
        if (bo.isNullOrNil(str4)) {
            pyVar.cMe.cMi = null;
        } else {
            pyVar.cMe.cMg = str4;
            pyVar.cMe.cMh = str5;
        }
        try {
            String string = this.uGh.getString("key_snsad_statextstr");
            pyVar.cMe.cMn = string;
            pyVar.cMe.cMj = this.umI.cYY();
            Bundle g = this.umI.g(18, null);
            if (g != null) {
                com.tencent.mm.g.a.py.a aVar = pyVar.cMe;
                String nullAsNil = bo.nullAsNil(g.getString("KPublisherId"));
                aVar.cMm = nullAsNil;
                String nW = v.nW(nullAsNil);
                com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
                y.j("sendAppMsgScene", Integer.valueOf(2));
                y.j("preChatName", g.getString("preChatName"));
                y.j("preMsgIndex", Integer.valueOf(g.getInt("preMsgIndex")));
                y.j("prePublishId", g.getString("prePublishId"));
                y.j("preUsername", g.getString("preUsername"));
                y.j("getA8KeyScene", Integer.valueOf(g.getInt("getA8KeyScene")));
                y.j("referUrl", g.getString("referUrl"));
                int i = g.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
                if (i != -1) {
                    y.j("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(i));
                    y.j("_tmpl_webview_transfer_scene", Integer.valueOf(11));
                }
                if (!bo.isNullOrNil(string)) {
                    y.j("adExtStr", string);
                }
                pyVar.cMe.cvF = nW;
            }
            string = this.umI.getCurrentUrl();
            pyVar.cMe.cMk = string;
            pyVar.cMe.cMl = this.uGr.agj(string);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "init bunddata failed : %s", e.getMessage());
        }
        boolean m = com.tencent.mm.sdk.b.a.xxA.m(pyVar);
        if (!bo.isNullOrNil(str6)) {
            qb qbVar = new qb();
            qbVar.cMq.cMr = str2;
            qbVar.cMq.content = str6;
            qbVar.cMq.type = t.nK(str2);
            qbVar.cMq.flags = 0;
            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
        }
        if (m) {
            try {
                if (this.umI != null) {
                    a(str, str3, t.kH(str2) ? 2 : 3, this.umI.g(85, null));
                }
            } catch (RemoteException e2) {
                ab.e("MicroMsg.MsgHandler", "invokeAsResult : %s", e2);
            }
        }
        if (!bo.isNullOrNil(str7)) {
            h.pYm.e(10424, Integer.valueOf(49), Integer.valueOf(128), str7);
        }
        AppMethodBeat.o(9380);
        return m;
    }

    private void a(String str, String str2, int i, Bundle bundle) {
        AppMethodBeat.i(9381);
        if (bundle == null) {
            AppMethodBeat.o(9381);
            return;
        }
        String string = bundle.getString("share_report_pre_msg_url");
        String string2 = bundle.getString("share_report_pre_msg_title");
        String string3 = bundle.getString("share_report_pre_msg_desc");
        String string4 = bundle.getString("share_report_pre_msg_icon_url");
        String string5 = bundle.getString("share_report_pre_msg_appid");
        int i2 = bundle.getInt("share_report_from_scene", 0);
        String string6 = bundle.getString("share_report_biz_username");
        String string7 = bundle.getString("share_report_current_url");
        String string8 = bundle.getString("share_report_current_title");
        String str3 = this.cEl.mediaObject instanceof WXWebpageObject ? ((WXWebpageObject) this.cEl.mediaObject).webpageUrl : "";
        String str4 = this.cEl.title;
        String str5 = this.cEl.description;
        h.pYm.e(14062, string, string2, string3, string4, string5, Integer.valueOf(i2), string6, string7, string8, str, str3, str4, str5, str2, Integer.valueOf(i));
        AppMethodBeat.o(9381);
    }

    private void a(i iVar, Map<String, Object> map) {
        AppMethodBeat.i(9382);
        a(iVar, iVar.uIJ + ":ok", (Map) map);
        AppMethodBeat.o(9382);
    }

    private void a(i iVar, String str, Map<String, Object> map) {
        AppMethodBeat.i(9383);
        a(iVar, str, (Map) map, true);
        AppMethodBeat.o(9383);
    }

    public final void a(i iVar, String str, Map<String, Object> map, boolean z) {
        AppMethodBeat.i(9384);
        this.eBB = false;
        try {
            if (this.umI != null) {
                this.umI.a(iVar == null ? null : iVar.uIG, str, i.aP(map), z);
            }
            AppMethodBeat.o(9384);
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
            AppMethodBeat.o(9384);
        }
    }

    public final void a(e eVar, i iVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        AppMethodBeat.i(9385);
        if (!z2) {
            this.eBB = false;
        }
        try {
            eVar.a(iVar == null ? null : iVar.uIG, str, i.aP(map), z);
            AppMethodBeat.o(9385);
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
            AppMethodBeat.o(9385);
        }
    }

    private void b(i iVar, boolean z) {
        AppMethodBeat.i(9386);
        if (iVar == null) {
            ab.e("MicroMsg.MsgHandler", "msg is null when report.");
            AppMethodBeat.o(9386);
            return;
        }
        String str = iVar.uIJ;
        Map map = iVar.uII;
        map.put("isSuccess", Boolean.valueOf(z));
        l.C(str, map);
        Object obj = "";
        if (this.uGh != null) {
            obj = this.uGh.getString("key_webview_container_env");
        }
        if ("miniProgram".equals(obj)) {
            n.a(this.umI, str, iVar);
        }
        AppMethodBeat.o(9386);
    }

    private int bc(i iVar) {
        AppMethodBeat.i(9387);
        int hashCode = iVar.hashCode();
        this.uGV.put(Integer.valueOf(hashCode), new c(iVar, this.umI));
        this.eBB = false;
        try {
            this.umI.cZc();
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "blockMsg, dealNext ex = %s", e.getMessage());
        }
        AppMethodBeat.o(9387);
        return hashCode;
    }

    private c JN(int i) {
        AppMethodBeat.i(9388);
        c cVar = (c) this.uGV.get(Integer.valueOf(i));
        AppMethodBeat.o(9388);
        return cVar;
    }

    private void JO(int i) {
        AppMethodBeat.i(9389);
        c cVar = (c) this.uGV.remove(Integer.valueOf(i));
        if (cVar != null) {
            cVar.uGd = null;
            cVar.umI = null;
        }
        AppMethodBeat.o(9389);
    }

    private boolean bd(i iVar) {
        AppMethodBeat.i(9390);
        this.eBB = false;
        boolean aD;
        if (com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "scene", 0) == 21) {
            aD = com.tencent.mm.plugin.webview.fts.f.cWo().aD(iVar.puc);
            AppMethodBeat.o(9390);
            return aD;
        }
        aD = com.tencent.mm.plugin.webview.modeltools.g.cYD().aD(iVar.puc);
        AppMethodBeat.o(9390);
        return aD;
    }

    private boolean be(i iVar) {
        AppMethodBeat.i(9391);
        iVar.puc.put("type", Integer.valueOf(262144));
        iVar.puc.put("subType", Integer.valueOf(8));
        com.tencent.mm.plugin.webview.modeltools.g.cYD().ugd = new cvf();
        com.tencent.mm.plugin.webview.modeltools.g.cYD().ugd.xrk = new li();
        com.tencent.mm.plugin.webview.modeltools.g.cYD().ugd.xrk.vOS = 1;
        a(iVar, iVar.uIJ + ":ok", new HashMap());
        boolean bd = bd(iVar);
        AppMethodBeat.o(9391);
        return bd;
    }

    private boolean bf(i iVar) {
        AppMethodBeat.i(9392);
        Map hashMap = new HashMap();
        com.tencent.mm.plugin.webview.modeltools.g.cYC();
        com.tencent.mm.plugin.webview.fts.b.c(iVar.puc, hashMap);
        a(iVar, "getSearchDisplayName:ok", hashMap);
        AppMethodBeat.o(9392);
        return true;
    }

    private boolean bg(i iVar) {
        AppMethodBeat.i(9393);
        this.eBB = false;
        com.tencent.mm.plugin.websearch.api.aa.a(this.context, com.tencent.mm.plugin.topstory.a.g.ag(iVar.puc));
        Map hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(0));
        a(iVar, AppEventsConstants.EVENT_PARAM_VALUE_NO, hashMap);
        AppMethodBeat.o(9393);
        return false;
    }

    private boolean bh(i iVar) {
        AppMethodBeat.i(9394);
        this.eBB = false;
        Map hashMap = new HashMap();
        if (com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "actionType", 0) == 1) {
            String t = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "jumpUrl");
            String t2 = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "publishId");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", t);
            intent.putExtra("KPublisherId", t2);
            com.tencent.mm.bp.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            ab.i("MicroMsg.MsgHandler", "doOpenWebSearchOutLinkItemClick actionType %d publishId %s url %s", Integer.valueOf(r1), t2, t);
            hashMap.put("ret", Integer.valueOf(0));
        } else {
            hashMap.put("ret", Integer.valueOf(-1));
        }
        a(iVar, AppEventsConstants.EVENT_PARAM_VALUE_NO, hashMap);
        AppMethodBeat.o(9394);
        return true;
    }

    private boolean bi(i iVar) {
        AppMethodBeat.i(9395);
        this.eBB = false;
        try {
            if (!(this.umI == null || iVar.puc == null || !iVar.puc.containsKey("view"))) {
                Bundle bundle = new Bundle();
                bundle.putString("fts_key_data", (String) iVar.puc.get("view"));
                this.umI.c(138, bundle);
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(9395);
        return false;
    }

    private boolean bj(i iVar) {
        AppMethodBeat.i(9396);
        this.eBB = false;
        int ank = bo.ank((String) iVar.puc.get(VideoMaterialUtil.CRAZYFACE_X));
        int ank2 = bo.ank((String) iVar.puc.get(VideoMaterialUtil.CRAZYFACE_Y));
        String str = (String) iVar.puc.get("eventId");
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.puc.get("widgetId"));
        bundle.putInt(VideoMaterialUtil.CRAZYFACE_X, ank);
        bundle.putInt(VideoMaterialUtil.CRAZYFACE_Y, ank2);
        bundle.putString("eventId", str);
        try {
            if (this.umI != null) {
                this.umI.c(100002, bundle);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doTapSearchWAWidgetView exception" + e.getMessage());
        }
        a(iVar, "tapSearchWAWidgetView:ok", null);
        AppMethodBeat.o(9396);
        return true;
    }

    private boolean bk(i iVar) {
        AppMethodBeat.i(9397);
        this.eBB = false;
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.puc.get("widgetId"));
        try {
            if (this.umI != null) {
                this.umI.c(100001, bundle);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doOpenSearchWAWidgetLogView exception" + e.getMessage());
        }
        a(iVar, "openSearchWAWidgetLogView:ok", null);
        AppMethodBeat.o(9397);
        return true;
    }

    private boolean bl(i iVar) {
        Object obj;
        AppMethodBeat.i(9398);
        this.eBB = false;
        this.uGW++;
        String jSONObject = new JSONObject(iVar.puc).toString();
        com.tencent.mm.plugin.websearch.widget.d.cVP();
        if (com.tencent.mm.plugin.websearch.widget.d.a(WidgetData.adQ(jSONObject))) {
            String str = ((String) iVar.puc.get("appid")) + "_" + this.uGW + "_" + System.currentTimeMillis();
            Bundle bundle = new Bundle();
            bundle.putString("fts_key_json_data", jSONObject);
            bundle.putString("fts_key_widget_view_cache_key", str);
            bundle.putInt("websearch_is_test_draw_json", ((com.tencent.mm.plugin.websearch.api.n) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.n.class)).cUM());
            String obj2;
            try {
                if (this.umI != null) {
                    this.umI.c(60, bundle);
                }
                obj2 = str;
            } catch (RemoteException e) {
                ab.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
                obj2 = str;
            }
        } else {
            obj2 = "";
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", obj2);
        a(iVar, "insertSearchWAWidgetView:ok", hashMap);
        AppMethodBeat.o(9398);
        return true;
    }

    private boolean bm(i iVar) {
        AppMethodBeat.i(9399);
        this.eBB = false;
        int i = this.uGX;
        this.uGX = i + 1;
        Bundle aP = i.aP(iVar.puc);
        if (aP.containsKey("playerId")) {
            i = bo.ank(aP.getString("playerId"));
        } else {
            aP.putString("playerId", String.valueOf(i));
        }
        ab.i("MicroMsg.MsgHandler", "inserting video player id %d, params %s", Integer.valueOf(i), iVar.puc);
        try {
            if (this.umI != null) {
                this.umI.c(200000, aP);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("playerId", Integer.valueOf(i));
        a(iVar, "insertVideoPlayer:ok", hashMap);
        AppMethodBeat.o(9399);
        return true;
    }

    private boolean bn(i iVar) {
        AppMethodBeat.i(9400);
        this.eBB = false;
        Bundle aP = i.aP(iVar.puc);
        ab.i("MicroMsg.MsgHandler", "update video player  params %s", iVar.puc);
        try {
            if (this.umI != null) {
                this.umI.c(200001, aP);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "updateVideoPlayer:ok", null);
        AppMethodBeat.o(9400);
        return true;
    }

    private boolean bo(i iVar) {
        AppMethodBeat.i(9401);
        this.eBB = false;
        Bundle aP = i.aP(iVar.puc);
        ab.i("MicroMsg.MsgHandler", "remove video player   params %s", iVar.puc);
        try {
            if (this.umI != null) {
                this.umI.c(200002, aP);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doRemoveVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "removeVideoPlayer:ok", null);
        AppMethodBeat.o(9401);
        return true;
    }

    private boolean bp(i iVar) {
        AppMethodBeat.i(9402);
        this.eBB = false;
        Bundle aP = i.aP(iVar.puc);
        ab.i("MicroMsg.MsgHandler", "operate video player  params %s", iVar.puc);
        try {
            if (this.umI != null) {
                this.umI.c(200003, aP);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "doOperateVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "operateVideoPlayer:ok", null);
        AppMethodBeat.o(9402);
        return true;
    }

    private boolean bq(i iVar) {
        AppMethodBeat.i(9403);
        this.eBB = false;
        JSONObject jSONObject = new JSONObject(iVar.puc);
        String str = (String) iVar.puc.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.umI != null) {
                this.umI.c(61, bundle);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "removeSearchWAWidgetView:ok", hashMap);
        AppMethodBeat.o(9403);
        return true;
    }

    private boolean br(i iVar) {
        AppMethodBeat.i(9404);
        this.eBB = false;
        JSONObject jSONObject = new JSONObject(iVar.puc);
        String str = (String) iVar.puc.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.umI != null) {
                this.umI.c(62, bundle);
            }
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "updateSearchWAWidgetView:ok", hashMap);
        AppMethodBeat.o(9404);
        return true;
    }

    private boolean bs(i iVar) {
        AppMethodBeat.i(9405);
        String str = (String) iVar.puc.get("miniprogramAppID");
        String str2 = (String) iVar.puc.get("data");
        if (bo.isNullOrNil(str)) {
            a(iVar, "sendDataToMiniProgram:fail invalid miniprogramAppID", null);
        } else {
            ((com.tencent.mm.plugin.appbrand.service.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.a.class)).i(str, str2, this.cIv);
            a(iVar, "sendDataToMiniProgram:ok", null);
        }
        AppMethodBeat.o(9405);
        return false;
    }

    private boolean bt(i iVar) {
        AppMethodBeat.i(9406);
        this.eBB = false;
        ((com.tencent.mm.plugin.appbrand.service.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.a.class)).xl(String.valueOf(iVar.puc.get("appId")));
        a(iVar, "preloadMiniProgramEnv:ok", null);
        AppMethodBeat.o(9406);
        return true;
    }

    private boolean bu(i iVar) {
        List J;
        String str;
        AppMethodBeat.i(9407);
        this.eBB = false;
        Object obj = iVar.puc.get("userNames");
        Object str2 = ":ok";
        if (obj instanceof String) {
            try {
                J = J(new JSONArray((String) obj));
            } catch (Exception e) {
                J = null;
                str2 = ":fail:param type mismatch";
            }
        } else if (obj instanceof JSONArray) {
            J = J((JSONArray) obj);
        } else if (obj instanceof String[]) {
            Object J2 = bo.P((String[]) obj);
        } else {
            J2 = null;
            str2 = ":fail:empty param";
        }
        if (!bo.ek(J2)) {
            ((com.tencent.mm.plugin.appbrand.service.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.a.class)).ax(J2);
        }
        a(iVar, "preloadMiniProgramContacts".concat(String.valueOf(str2)), null);
        AppMethodBeat.o(9407);
        return true;
    }

    private static List<String> J(JSONArray jSONArray) {
        AppMethodBeat.i(9408);
        if (jSONArray == null || jSONArray.length() <= 0) {
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(9408);
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList2.add(jSONArray.optString(i));
        }
        AppMethodBeat.o(9408);
        return linkedList2;
    }

    private boolean bv(i iVar) {
        AppMethodBeat.i(9409);
        this.eBB = false;
        se seVar = new se();
        seVar.cOf.context = this.context;
        seVar.cOf.userName = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "userName");
        seVar.cOf.appId = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "appId");
        seVar.cOf.cOh = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "relativeURL");
        seVar.cOf.axy = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "appVersion", 0);
        seVar.cOf.scene = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "scene", 1018);
        seVar.cOf.cst = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "sceneNote");
        if (bo.isNullOrNil(seVar.cOf.cst)) {
            seVar.cOf.cst = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(getCurrentUrl()));
        }
        seVar.cOf.cOj = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "downloadURL");
        seVar.cOf.cOi = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "openType", 0);
        seVar.cOf.cOk = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "checkSumMd5");
        seVar.cOf.cOm = false;
        seVar.cOf.cOn.fpI = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "extJsonInfo");
        seVar.cOf.cOs = bK(getCurrentUrl());
        if (bo.isNullOrNil(seVar.cOf.cOs)) {
            seVar.cOf.cOs = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "sourceAppId");
        }
        seVar.cOf.cOt = getCurrentUrl();
        seVar.cOf.cOu = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "privateExtraData");
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        if (seVar.cOg.cOw) {
            a(iVar, "openWeApp:ok", null);
        } else {
            a(iVar, "openWeApp:fail:" + bo.nullAsNil(seVar.cOg.cOx), null);
        }
        AppMethodBeat.o(9409);
        return true;
    }

    private boolean bw(i iVar) {
        int i;
        AppMethodBeat.i(9410);
        this.eBB = false;
        ab.i("MicroMsg.MsgHandler", "doOpenWeAppPage %s", iVar.puc);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "userName");
        String t2 = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "relativeURL");
        if (t2.contains("render_data")) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                JSONObject jSONObject = new JSONObject(Uri.parse(t2).getQueryParameter("widgetData"));
                jSONObject.remove("render_data");
                t2 = t2.replaceAll("(widgetData=.*&)|(widgetData=.*$)", "&") + "&widgetData=" + jSONObject.toString();
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            }
        }
        int d = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "appVersion", 0);
        String t3 = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "searchId");
        String t4 = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "docId");
        int d2 = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "position", 1);
        int d3 = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "scene", 1000);
        int d4 = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "debugMode", 0);
        if (d4 < 0) {
            d4 = 0;
        }
        if (com.tencent.mm.plugin.webview.modeltools.g.cYD().tZK != null) {
            i = 1;
        } else {
            i = d4;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        if (d3 == 201 || d3 == 14 || d3 == 22) {
            appBrandStatObject.scene = 1006;
        } else if (d3 == 3) {
            appBrandStatObject.scene = 1005;
        } else if (d3 == 16) {
            appBrandStatObject.scene = 1042;
        } else if (d3 == 20) {
            appBrandStatObject.scene = FilterEnum4Shaka.MIC_SHAKA_ADD2_18;
        } else {
            appBrandStatObject.scene = 1000;
        }
        String t5 = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "statSessionId");
        String t6 = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "statKeywordId");
        appBrandStatObject.cst = t5 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + t6 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + t3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + t4 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + d2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "subScene");
        ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(this.context, t, null, i, d, t2, appBrandStatObject);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new csq();
        aVar.fsK = new csr();
        aVar.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar.fsI = 1873;
        com.tencent.mm.ai.b acD = aVar.acD();
        csq csq = (csq) acD.fsG.fsP;
        csq.xpS = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "statSessionId");
        csq.xpT = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "statKeywordId");
        csq.wDM = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "searchId");
        csq.wUo = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "docId");
        csq.gtF = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "position", 1);
        csq.pdu = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "userName");
        csq.xpU = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "appVersion", 0);
        csq.xpV = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "adBuffer");
        csq.Scene = d3;
        csq.xpW = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "clickExtInfo");
        final com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20StatSessionId", csq.xpS + ",");
        dVar.l("21KeywordId", csq.xpT + ",");
        dVar.l("22SearchId", csq.wDM + ",");
        dVar.l("23DocId", csq.wUo + ",");
        dVar.l("24Pos", csq.gtF + ",");
        dVar.l("25AppUserName", csq.pdu + ",");
        dVar.l("26AppVersion", csq.xpU + ",");
        dVar.l("27AdBuffer", csq.xpV + ",");
        dVar.l("28AdClickBuffer", csq.xpW + ",");
        dVar.l("29scene", d3 + ",");
        ab.i("MicroMsg.MsgHandler", "doClickReportScene oreh" + dVar.Fk());
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(9070);
                ab.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (!(i == 0 && i2 == 0)) {
                    ab.i("MicroMsg.MsgHandler", "report oreh logbuffer(13927)");
                    h.pYm.e(13927, dVar);
                    h.pYm.a(457, 0, 1, false);
                }
                AppMethodBeat.o(9070);
                return 0;
            }
        });
        a(iVar, "openWeAppPage:ok", null);
        AppMethodBeat.o(9410);
        return true;
    }

    private boolean bx(i iVar) {
        AppMethodBeat.i(9411);
        int d = com.tencent.mm.plugin.websearch.api.aa.d(iVar.puc, "logId", 0);
        ab.i("MicroMsg.MsgHandler", "doSearchRailtime oreh id:%d, value:%s, params:%s", Integer.valueOf(d), com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "logString"), iVar.puc);
        ((com.tencent.mm.plugin.websearch.api.n) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.n.class)).bw(d, r2);
        a(iVar, "reportWeAppSearchRealtime:ok", null);
        AppMethodBeat.o(9411);
        return true;
    }

    private boolean by(i iVar) {
        AppMethodBeat.i(9412);
        String optString = iVar.uIH.optString("name");
        Object opt = iVar.uIH.opt("arg");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", optString);
            jSONObject.put("arg", opt);
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            this.umI.g(com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, bundle);
            a(iVar, "invokeMiniProgramAPI:ok", null);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doInvokeMiniProgramApi: %s", e);
            a(iVar, "invokeMiniProgramAPI:fail", null);
        }
        AppMethodBeat.o(9412);
        return true;
    }

    public final void a(String str, boolean z, String str2, Bundle bundle) {
        AppMethodBeat.i(9413);
        Bundle bundle2 = new Bundle();
        bundle2.putString("fts_key_json_data", str);
        bundle2.putString("fts_key_req_id", str2);
        bundle2.putBoolean("fts_key_new_query", z);
        if (bundle != null) {
            bundle2.putBundle("fts_key_data", bundle);
        }
        try {
            if (this.umI != null) {
                this.umI.c(com.tencent.view.d.MIC_AVROUND_BLUR, bundle2);
            }
            AppMethodBeat.o(9413);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
            AppMethodBeat.o(9413);
        }
    }

    public final void c(int i, String str, Map<String, Object> map) {
        AppMethodBeat.i(9414);
        Bundle bundle = new Bundle();
        bundle.putInt("FTS_KEY_onStartWebSearch_type", i);
        bundle.putString("FTS_KEY_onStartWebSearch_query", str);
        bundle.putSerializable("FTS_KEY_onStartWebSearch_params", new HashMap(map));
        try {
            if (this.umI != null) {
                this.umI.c(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX, bundle);
            }
            AppMethodBeat.o(9414);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
            AppMethodBeat.o(9414);
        }
    }

    public final void agq(String str) {
        AppMethodBeat.i(9415);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        try {
            if (this.umI != null) {
                this.umI.c(124, bundle);
            }
            AppMethodBeat.o(9415);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
            AppMethodBeat.o(9415);
        }
    }

    public final void aP(JSONObject jSONObject) {
        AppMethodBeat.i(9416);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        try {
            if (this.umI != null) {
                this.umI.c(137, bundle);
            }
            AppMethodBeat.o(9416);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
            AppMethodBeat.o(9416);
        }
    }

    public final void dN(String str, int i) {
        AppMethodBeat.i(9417);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_sns_id", str);
        bundle.putInt("fts_key_status", i);
        try {
            if (this.umI != null) {
                this.umI.c(125, bundle);
            }
            AppMethodBeat.o(9417);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onMusicStatusChanged exception" + e.getMessage());
            AppMethodBeat.o(9417);
        }
    }

    public final void bH(int i, String str) {
        AppMethodBeat.i(9418);
        ab.i("MicroMsg.MsgHandler", "onSearchImageListReady ret %d data %s", Integer.valueOf(i), str);
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_ret", i);
        bundle.putString("fts_key_data", str);
        try {
            if (this.umI != null) {
                this.umI.c(120, bundle);
            }
            AppMethodBeat.o(9418);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onSearchImageListReady exception" + e.getMessage());
            AppMethodBeat.o(9418);
        }
    }

    public final void d(int i, String str, int i2, String str2) {
        AppMethodBeat.i(9419);
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_teach_request_type", i);
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i2);
        bundle.putString("requestId", str2);
        try {
            if (this.umI != null) {
                this.umI.c(121, bundle);
            }
            AppMethodBeat.o(9419);
        } catch (RemoteException e) {
            ab.w("MicroMsg.MsgHandler", "onTeachSearchDataReady exception" + e.getMessage());
            AppMethodBeat.o(9419);
        }
    }

    public final void m(String str, int i, int i2, int i3) {
        AppMethodBeat.i(9420);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i);
        bundle.putInt("fts_key_is_expired", i2);
        bundle.putInt("fts_key_is_preload", i3);
        try {
            if (this.umI != null) {
                this.umI.c(ErrorCode.NEEDDOWNLOAD_3, bundle);
            }
            AppMethodBeat.o(9420);
        } catch (Exception e) {
            AppMethodBeat.o(9420);
        }
    }

    public final boolean bz(i iVar) {
        boolean z = false;
        AppMethodBeat.i(9421);
        int i = bo.getInt(bo.cD(iVar.puc.get("id")), 0);
        if (i <= 0) {
            a(iVar, "kvReport:fail", null);
            AppMethodBeat.o(9421);
        } else {
            boolean z2;
            String cD = bo.cD(iVar.puc.get("value"));
            if (bo.getInt(bo.cD(iVar.puc.get("is_important")), 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bo.getInt(bo.cD(iVar.puc.get("is_report_now")), 0) > 0) {
                z = true;
            }
            h.pYm.a(i, cD, z, z2);
            a(iVar, "kvReport:ok", null);
            AppMethodBeat.o(9421);
        }
        return true;
    }

    public final String getCurrentUrl() {
        String str = null;
        AppMethodBeat.i(9422);
        if (this.umI == null) {
            ab.i("MicroMsg.MsgHandler", "getCurrentUrl, callbacker is null");
            AppMethodBeat.o(9422);
        } else {
            try {
                str = this.umI.getCurrentUrl();
                AppMethodBeat.o(9422);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", e);
                AppMethodBeat.o(9422);
            }
        }
        return str;
    }

    private boolean bA(i iVar) {
        int i = 0;
        AppMethodBeat.i(9423);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "targetAppId");
        String currentUrl = getCurrentUrl();
        String bK = bK(currentUrl);
        if (bo.isNullOrNil(bK)) {
            bK = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "referrerAppId");
        }
        if (bo.isNullOrNil(t)) {
            a(iVar, "launchMiniProgram:fail_invalid_targetAppId", null);
        } else if (bo.isNullOrNil(bK)) {
            a(iVar, "launchMiniProgram:fail_invalid_referrerAppId", null);
        } else {
            String nullAsNil = bo.nullAsNil(com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "envVersion"));
            int i2 = -1;
            switch (nullAsNil.hashCode()) {
                case 110628630:
                    if (nullAsNil.equals("trial")) {
                        boolean i22 = true;
                        break;
                    }
                    break;
                case 1559690845:
                    if (nullAsNil.equals("develop")) {
                        i22 = 0;
                        break;
                    }
                    break;
            }
            switch (i22) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).b(this.context, currentUrl, bK, t, i, com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "path"), aGu());
            a(iVar, "launchMiniProgram:ok", null);
        }
        AppMethodBeat.o(9423);
        return true;
    }

    private boolean bB(final i iVar) {
        int i = 0;
        int i2 = -1;
        AppMethodBeat.i(9424);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "businessType");
        String currentUrl = getCurrentUrl();
        String bK = bK(currentUrl);
        if (bo.isNullOrNil(bK)) {
            bK = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "referrerAppId");
        }
        final Map hashMap = new HashMap();
        if (bo.isNullOrNil(t)) {
            hashMap.put("err_code", Integer.valueOf(-4));
            a(iVar, "openBusinessView:fail invalid businessType", hashMap);
        } else if (bo.isNullOrNil(bK)) {
            hashMap.put("err_code", Integer.valueOf(-1));
            a(iVar, "openBusinessView:fail invalid referrerAppId", hashMap);
        } else {
            String nullAsNil = bo.nullAsNil(com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "envVersion"));
            switch (nullAsNil.hashCode()) {
                case 110628630:
                    if (nullAsNil.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (nullAsNil.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(this.context, currentUrl, bK, t, com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "queryString"), i, aGu());
            this.uGY = new com.tencent.mm.sdk.b.c<kg>() {
                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(9074);
                    kg kgVar = (kg) bVar;
                    g.this.uGY.dead();
                    ab.i("MicroMsg.MsgHandler", "doOpenBusinessView errCode %d", Integer.valueOf(kgVar.cFL.errCode));
                    hashMap.put("err_code", Integer.valueOf(kgVar.cFL.errCode));
                    switch (kgVar.cFL.errCode) {
                        case -4:
                            g.a(g.this, iVar, "openBusinessView:fail invalid businessType", hashMap);
                            break;
                        case -3:
                            g.a(g.this, iVar, "openBusinessView:fail cancel", hashMap);
                            break;
                        case -2:
                            g.a(g.this, iVar, "openBusinessView:fail request CGI error", hashMap);
                            break;
                        case 0:
                            hashMap.put("extraData", kgVar.cFL.cFM);
                            g.a(g.this, iVar, "openBusinessView:ok", hashMap);
                            break;
                        default:
                            g.a(g.this, iVar, "openBusinessView:fail system error", hashMap);
                            break;
                    }
                    AppMethodBeat.o(9074);
                    return false;
                }
            };
            this.uGY.dnU();
        }
        AppMethodBeat.o(9424);
        return true;
    }

    private boolean bC(i iVar) {
        AppMethodBeat.i(9425);
        String str = (String) iVar.puc.get("username");
        if (!bo.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).b(str, null);
        }
        a(iVar, "forceUpdateWxaAttr:ok", null);
        AppMethodBeat.o(9425);
        return true;
    }

    private boolean bD(i iVar) {
        AppMethodBeat.i(9426);
        Bundle bundle = new Bundle(2);
        bundle.putString("set_page_title_text", (String) iVar.puc.get("title"));
        bundle.putString("set_page_title_color", (String) iVar.puc.get("color"));
        try {
            this.umI.g(43, bundle);
            a(iVar, "setPageTitle:ok", null);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doSetPageTitle, exception = %s", e);
            a(iVar, "setPageTitle:fail", null);
        }
        AppMethodBeat.o(9426);
        return true;
    }

    @Deprecated
    private boolean bE(i iVar) {
        AppMethodBeat.i(9427);
        String str = (String) iVar.puc.get("color");
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is null or nill");
            a(iVar, "setStatusBarStyle:fail", null);
            AppMethodBeat.o(9427);
        } else {
            int i;
            if (str.equalsIgnoreCase("black")) {
                i = 48;
            } else if (str.equalsIgnoreCase("white")) {
                i = 49;
            } else {
                i = -1;
            }
            if (-1 != i) {
                try {
                    this.umI.g(i, Bundle.EMPTY);
                    a(iVar, "setStatusBarStyle:ok", null);
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "doSetStatusBarStyle, exception = %s", e);
                    a(iVar, "setStatusBarStyle:fail", null);
                }
            } else {
                ab.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is neither black or white");
                a(iVar, "setStatusBarStyle:fail", null);
            }
            AppMethodBeat.o(9427);
        }
        return true;
    }

    private boolean bF(i iVar) {
        AppMethodBeat.i(9428);
        if (iVar.puc.containsKey("enable")) {
            try {
                boolean parseBoolean = Boolean.parseBoolean((String) iVar.puc.get("enable"));
                Bundle bundle = new Bundle(1);
                bundle.putBoolean("enable_fullscreen_params_enable", parseBoolean);
                this.umI.g(45, bundle);
                a(iVar, "enableFullScreen:ok", null);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "doEnableFullScreen, exception = %s", e);
                a(iVar, "enableFullScreen:fail", null);
            }
            AppMethodBeat.o(9428);
        } else {
            a(iVar, "enableFullScreen:fail_invalid_arguments", null);
            AppMethodBeat.o(9428);
        }
        return true;
    }

    private boolean bG(i iVar) {
        AppMethodBeat.i(9429);
        String str = (String) iVar.puc.get("left");
        String str2 = (String) iVar.puc.get("right");
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            a(iVar, "setNavigationBarButtons:fail", null);
            AppMethodBeat.o(9429);
        } else {
            Bundle bundle = new Bundle();
            try {
                str = new JSONObject(str).optString("color", "");
                if (!bo.isNullOrNil(str)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", str);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean optBoolean = jSONObject.optBoolean("hidden", false);
                String optString = jSONObject.optString("text", "");
                String nullAsNil = bo.nullAsNil(com.tencent.mm.pluginsdk.ui.tools.u.akm(jSONObject.optString("iconData", "")));
                String optString2 = jSONObject.optString("color", "");
                boolean optBoolean2 = jSONObject.optBoolean("needClickEvent", false);
                if (optBoolean) {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                } else {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", nullAsNil);
                    bundle.putString("set_navigation_bar_buttons_text_color", optString2);
                    bundle.putBoolean("set_navigation_bar_buttons_need_click_event", optBoolean2);
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                a(iVar, "setNavigationBarButtons:fail_invalid_params", null);
                AppMethodBeat.o(9429);
            } else {
                try {
                    this.umI.g(44, bundle);
                    a(iVar, "setNavigationBarButtons:ok", null);
                } catch (Exception e22) {
                    ab.printErrStackTrace("MicroMsg.MsgHandler", e22, " setNavigationBarButtons invoke ", new Object[0]);
                    a(iVar, "setNavigationBarButtons:fail_invoke", null);
                }
                AppMethodBeat.o(9429);
            }
        }
        return true;
    }

    public final boolean bH(i iVar) {
        AppMethodBeat.i(9430);
        try {
            this.umI.g(34, Bundle.EMPTY);
            a(iVar, "enablePullDownRefresh:ok", null);
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "doEnablePullDownRefresh, exception = %s", e);
            a(iVar, "enablePullDownRefresh:fail", null);
        }
        AppMethodBeat.o(9430);
        return true;
    }

    public final boolean bI(i iVar) {
        AppMethodBeat.i(9431);
        try {
            this.umI.g(35, Bundle.EMPTY);
            a(iVar, "startPullDownRefresh:ok", null);
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "doStartPullDownRefresh, exception = %s", e);
            a(iVar, "startPullDownRefresh:fail", null);
        }
        AppMethodBeat.o(9431);
        return true;
    }

    public final boolean bJ(i iVar) {
        AppMethodBeat.i(9432);
        try {
            this.umI.g(36, Bundle.EMPTY);
            a(iVar, "stopPullDownRefresh:ok", null);
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "doStopPullDownRefresh, exception = %s", e);
            a(iVar, "stopPullDownRefresh:fail", null);
        }
        AppMethodBeat.o(9432);
        return true;
    }

    public final boolean dcI() {
        AppMethodBeat.i(9433);
        try {
            this.umI.g(47, Bundle.EMPTY);
            a(this.uGd, "disablePullDownRefresh:ok", null);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            a(this.uGd, "disablePullDownRefresh:fail", null);
        }
        AppMethodBeat.o(9433);
        return true;
    }

    public final boolean bK(i iVar) {
        AppMethodBeat.i(9434);
        this.eBB = false;
        String nullAsNil = bo.nullAsNil((String) iVar.puc.get("placeholder"));
        int i = bo.getInt((String) iVar.puc.get("maxLength"), 0);
        try {
            Bundle bundle = new Bundle(2);
            bundle.putString("show_kb_placeholder", nullAsNil);
            bundle.putInt("show_kb_max_length", i);
            this.umI.g(37, bundle);
            this.uGZ = iVar;
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "doShowKeyBoard, exception = %s", e);
            a(this.umI, iVar, "showKeyboard:fail", null, true, true);
        }
        AppMethodBeat.o(9434);
        return true;
    }

    public final boolean bL(i iVar) {
        AppMethodBeat.i(9435);
        this.eBB = false;
        try {
            Bundle g = this.umI.g(79, new Bundle());
            HashMap hashMap = new HashMap();
            int i = g.getInt("height", 0);
            if (i > 0) {
                hashMap.put("height", Integer.valueOf(com.tencent.mm.bz.a.ao(ah.getContext(), i)));
                a(this.umI, iVar, "showSmileyPanel:ok", hashMap, true, true);
            } else {
                a(this.umI, iVar, "showSmileyPanel:fail", null, true, true);
            }
        } catch (Exception e) {
            ab.i("MicroMsg.MsgHandler", "doShowSmileyPanel, exception = %s", e);
            a(this.umI, iVar, "showSmileyPanel:fail", null, true, true);
        }
        AppMethodBeat.o(9435);
        return true;
    }

    public final boolean bM(i iVar) {
        AppMethodBeat.i(9436);
        String str = (String) iVar.puc.get("place");
        if (bo.isNullOrNil(str)) {
            a(iVar, "disableBounceScroll:fail", null);
            AppMethodBeat.o(9436);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if ("top".equalsIgnoreCase(jSONArray.getString(i2))) {
                        i = true;
                    }
                }
                if (i == 0) {
                    a(iVar, "disableBounceScroll:ok", null);
                    AppMethodBeat.o(9436);
                } else {
                    try {
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("webview_disable_bounce_scroll_top", 1);
                        this.umI.g(38, bundle);
                        a(iVar, "disableBounceScroll:ok", null);
                    } catch (Exception e) {
                        ab.i("MicroMsg.MsgHandler", "doDisableBounceScroll, exception = %s", e);
                        a(iVar, "disableBounceScroll:fail", null);
                    }
                    AppMethodBeat.o(9436);
                }
            } catch (JSONException e2) {
                ab.i("MicroMsg.MsgHandler", "doDisableBounceScroll, invalid json array, string = %s", str);
                a(iVar, "disableBounceScroll:fail", null);
                AppMethodBeat.o(9436);
            }
        }
        return true;
    }

    public final boolean bN(i iVar) {
        AppMethodBeat.i(9437);
        try {
            this.umI.g(39, new Bundle(0));
            a(iVar, "clearBounceBackground:ok", null);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doClearBounceBackground, exception = %s", e);
            a(iVar, "clearBounceBackground:fail", null);
        }
        AppMethodBeat.o(9437);
        return true;
    }

    public final boolean bO(i iVar) {
        AppMethodBeat.i(9438);
        Bundle bundle = new Bundle();
        bundle.putString("key_set_bounce_background_color", (String) iVar.puc.get("backgroundColor"));
        try {
            this.umI.g(72, bundle);
            a(iVar, "setBounceBackground:ok", null);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "setBounceBackground, exception = %s", e);
            a(iVar, "setBounceBackground:fail", null);
        }
        AppMethodBeat.o(9438);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bP(i iVar) {
        AppMethodBeat.i(9439);
        int i = bo.getInt(bo.cD(iVar.puc.get("id")), 0);
        if (i <= 0) {
            a(iVar, "realtimeReport:fail", null);
            AppMethodBeat.o(9439);
            return true;
        }
        Object obj;
        String cD = bo.cD(iVar.puc.get("value"));
        int i2 = bo.getInt(bo.cD(iVar.puc.get("type")), 0);
        com.tencent.mm.plugin.webview.model.f cXv = com.tencent.mm.plugin.webview.model.f.a.ulU;
        if (com.tencent.mm.kernel.g.RK()) {
            long longValue;
            com.tencent.mm.plugin.webview.model.e cYH = com.tencent.mm.plugin.webview.modeltools.g.cYH();
            Long l = (Long) cYH.ulM.get(Integer.valueOf(i));
            if (l != null) {
                longValue = l.longValue();
            } else {
                Cursor a = cYH.fni.a(String.format("select %s from %s where %s=?", new Object[]{"liftTime", "JsLogBlockList", "logId"}), new String[]{String.valueOf(i)}, 2);
                if (a == null) {
                    longValue = 0;
                } else if (a.moveToFirst()) {
                    longValue = a.getLong(0);
                    a.close();
                } else {
                    a.close();
                    longValue = 0;
                }
            }
            if (longValue != 0 && longValue < bo.anT()) {
                bb bbVar = cYH.ulM;
                Integer valueOf = Integer.valueOf(i);
                if (valueOf == null) {
                    NullPointerException nullPointerException = new NullPointerException("key == null");
                    AppMethodBeat.o(9439);
                    throw nullPointerException;
                }
                if (bbVar.get(valueOf) != null) {
                    bbVar.A(valueOf, null);
                }
                longValue = 0;
            }
            if (longValue == 0 || longValue < bo.anT()) {
                axc axc = new axc();
                axc.wBd = i;
                axc.wBe = com.tencent.mm.bt.b.akB(cD);
                axc.wBm = i2;
                cXv.ulR.add(axc);
                obj = 1;
                if (obj == null) {
                    a(iVar, "realtimeReport:ok", null);
                } else {
                    a(iVar, "realtimeReport:fail", null);
                }
                AppMethodBeat.o(9439);
                return true;
            }
        }
        ab.i("MicroMsg.WebView.JsLogHelper", "kvStat(), acc not ready, skip");
        obj = null;
        if (obj == null) {
        }
        AppMethodBeat.o(9439);
        return true;
    }

    public final boolean bQ(i iVar) {
        AppMethodBeat.i(9440);
        String str = (String) iVar.puc.get("latitude");
        String str2 = (String) iVar.puc.get("longitude");
        final String str3 = (String) iVar.puc.get("destinationName");
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            a(iVar, "openMapNavigateMenu:fail", null);
            AppMethodBeat.o(9440);
        } else {
            try {
                final double parseDouble = Double.parseDouble(str);
                final double parseDouble2 = Double.parseDouble(str2);
                final int i = bo.getInt((String) iVar.puc.get("preferMap"), com.tencent.mm.pluginsdk.model.a.a.TencentMap.code);
                if (this.context == null || !(this.context instanceof Activity) || ((Activity) this.context).isFinishing()) {
                    a(iVar, "openMapNavigateMenu:fail", null);
                } else {
                    final int bc = bc(iVar);
                    al.d(new Runnable() {
                        public final void run() {
                            byte b = (byte) 0;
                            AppMethodBeat.i(9080);
                            if (!(g.this.context == null || !(g.this.context instanceof Activity) || ((Activity) g.this.context).isFinishing())) {
                                j J = g.this.uGt;
                                Context i = g.this.context;
                                int i2 = i;
                                double d = parseDouble;
                                double d2 = parseDouble2;
                                String str = str3;
                                int i3 = bc;
                                AnonymousClass1 anonymousClass1 = new d() {
                                    public final void JP(int i) {
                                        AppMethodBeat.i(9075);
                                        bI(i, "cancel");
                                        AppMethodBeat.o(9075);
                                    }

                                    public final void onFail(int i) {
                                        AppMethodBeat.i(9076);
                                        bI(i, "fail");
                                        AppMethodBeat.o(9076);
                                    }

                                    public final void onSuccess(int i) {
                                        AppMethodBeat.i(9077);
                                        bI(i, "ok");
                                        AppMethodBeat.o(9077);
                                    }

                                    private void bI(int i, String str) {
                                        AppMethodBeat.i(9078);
                                        c b = g.b(g.this, i);
                                        if (!(b == null || b.uGd == null || b.umI == null)) {
                                            g.a(g.this, g.this.umI, g.this.uGd, "openMapNavigateMenu:" + bo.bc(str, "fail"));
                                        }
                                        AppMethodBeat.o(9078);
                                    }

                                    public final void JQ(int i) {
                                        AppMethodBeat.i(9079);
                                        g.c(g.this, i);
                                        AppMethodBeat.o(9079);
                                    }
                                };
                                if (!(i == null || !(i instanceof MMActivity) || ((MMActivity) i).isFinishing())) {
                                    J.unO = i3;
                                    J.uIK = true;
                                    J.uIL = i2;
                                    J.uIN = new e(d, d2, (byte) 0);
                                    J.uIO = str;
                                    J.aIq = new WeakReference(i);
                                    J.uIP = anonymousClass1;
                                    J.fwu = null;
                                    if (J.fwu == null) {
                                        J.dcP();
                                    } else {
                                        J.uIS = new com.tencent.mm.modelgeo.b.a() {
                                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                                AppMethodBeat.i(9823);
                                                if (j.this.fwu != null) {
                                                    j.this.fwu.c(this);
                                                }
                                                if (z) {
                                                    j.this.uIM = new e((double) f2, (double) f, (byte) 0);
                                                    if (j.this.nOO != null) {
                                                        j.this.uIQ = new com.tencent.mm.modelgeo.c.a() {
                                                            public final void b(Addr addr) {
                                                                AppMethodBeat.i(9822);
                                                                if (!(j.this.uIM == null || j.this.uIQ == null)) {
                                                                    j.this.uIM.uIW = addr.agv();
                                                                    j.this.dcP();
                                                                }
                                                                AppMethodBeat.o(9822);
                                                            }
                                                        };
                                                        j.this.nOO.a((double) f2, (double) f, j.this.uIQ);
                                                        AppMethodBeat.o(9823);
                                                        return false;
                                                    }
                                                }
                                                j.this.dcP();
                                                AppMethodBeat.o(9823);
                                                return false;
                                            }
                                        };
                                        if (J.nOO != null) {
                                            J.uIR = new com.tencent.mm.modelgeo.c.a() {
                                                public final void b(Addr addr) {
                                                    AppMethodBeat.i(9824);
                                                    if (!(j.this.uIN == null || j.this.uIR == null)) {
                                                        j.this.uIN.uIW = addr.agv();
                                                    }
                                                    AppMethodBeat.o(9824);
                                                }
                                            };
                                            J.nOO.a(J.uIN.latitude, J.uIN.longitude, J.uIR);
                                        }
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(9825);
                                                if (!(j.this.aIq == null || j.this.aIq.get() == null)) {
                                                    Toast.makeText((Context) j.this.aIq.get(), R.string.g2x, 0).show();
                                                }
                                                AppMethodBeat.o(9825);
                                            }
                                        });
                                        J.fwu.b(J.uIS);
                                        al.n(J.uIT, 4000);
                                    }
                                    b = (byte) 1;
                                }
                            }
                            if (b == (byte) 0) {
                                c b2 = g.b(g.this, bc);
                                if (!(b2.umI == null || b2.uGd == null)) {
                                    g.a(g.this, b2.umI, b2.uGd, "openMapNavigateMenu:fail");
                                }
                            }
                            AppMethodBeat.o(9080);
                        }
                    });
                }
                AppMethodBeat.o(9440);
            } catch (Exception e) {
                ab.e("MicroMsg.MsgHandler", "doOpenMapNavigateMenu, parse double, exception = %s");
                a(iVar, "openMapNavigateMenu:fail", null);
                AppMethodBeat.o(9440);
            }
        }
        return true;
    }

    public final Bundle dcJ() {
        Bundle bundle = null;
        AppMethodBeat.i(9441);
        try {
            bundle = this.umI.g(33, null);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        ab.i("MicroMsg.MsgHandler", "getWebViewIntentExtras(%s)", bundle);
        AppMethodBeat.o(9441);
        return bundle;
    }

    private boolean bR(i iVar) {
        AppMethodBeat.i(9442);
        String str = (String) iVar.puc.get("operationType");
        String str2 = (String) iVar.puc.get("dataUrl");
        l.a(iVar.uII, false, null, "");
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            a(iVar, "operateMusicPlayer:fail", null);
            AppMethodBeat.o(9442);
            return true;
        }
        Object obj;
        if (str.equalsIgnoreCase("play")) {
            String str3 = (String) iVar.puc.get("title");
            String str4 = (String) iVar.puc.get("singer");
            String str5 = (String) iVar.puc.get("epname");
            String str6 = (String) iVar.puc.get("coverImgUrl");
            String str7 = (String) iVar.puc.get("lowbandUrl");
            String str8 = (String) iVar.puc.get("webUrl");
            iVar.puc.get("lyric");
            ab.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", str3, str4, str5, str6, str2, str7, str8, "");
            if (bo.isNullOrNil(str3) || bo.isNullOrNil(str4) || bo.isNullOrNil(str5) || bo.isNullOrNil(str6) || bo.isNullOrNil(str7) || bo.isNullOrNil(str2) || bo.isNullOrNil(str8)) {
                a(iVar, "operateMusicPlayer:fail", null);
            } else {
                com.tencent.mm.aw.a.aic();
                com.tencent.mm.aw.a.b(com.tencent.mm.aw.f.a(7, str6, str3, str4, str8, str7, str2, str2.hashCode(), com.tencent.mm.compatible.util.e.eSn, com.tencent.mm.plugin.i.c.XW() + str6.hashCode(), str5, ""));
                a(iVar, "operateMusicPlayer:ok", null);
            }
        } else if (str.equalsIgnoreCase("resume")) {
            if (com.tencent.mm.aw.b.sT(str2) && com.tencent.mm.aw.a.aig() && !com.tencent.mm.aw.a.aie()) {
                com.tencent.mm.aw.a.KY();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("pause")) {
            if (com.tencent.mm.aw.b.sT(str2) && com.tencent.mm.aw.a.aie()) {
                com.tencent.mm.aw.a.KX();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.aw.a.aid();
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("seek")) {
            boolean lP;
            int i = bo.getInt(bo.cD(iVar.puc.get("position")), -1) * 1000;
            if (com.tencent.mm.aw.b.sT(str2)) {
                lP = com.tencent.mm.aw.a.lP(i);
            } else {
                lP = false;
            }
            if (lP) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            if (com.tencent.mm.aw.b.sT(str2) && com.tencent.mm.aw.a.aig()) {
                com.tencent.mm.aw.a.aic();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else {
            a(iVar, "operateMusicPlayer:fail", null);
        }
        AppMethodBeat.o(9442);
        return true;
    }

    private boolean bS(i iVar) {
        AppMethodBeat.i(9443);
        String str = (String) iVar.puc.get("dataUrl");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (bo.isNullOrNil(str)) {
            a(iVar, "getMusicPlayerState:fail_dataUrl_null", null);
            AppMethodBeat.o(9443);
        } else {
            ab.i("MicroMsg.MsgHandler", "dataUrl : %s, appid : %s", str, r1);
            com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
            if (aih == null || !aih.fKa.equals(str)) {
                a(iVar, "getMusicPlayerState:failed_dataUrl_diff", null);
            } else {
                int i;
                com.tencent.mm.aw.c aii = com.tencent.mm.aw.a.aii();
                int i2 = -1;
                if (aii != null) {
                    i2 = aii.mDuration;
                    i = aii.mPosition;
                } else {
                    i = 0;
                }
                if (aii == null || i2 < 0 || i < 0) {
                    a(iVar, "getMusicPlayerState:fail", null);
                    AppMethodBeat.o(9443);
                } else {
                    i2 /= 1000;
                    i /= 1000;
                    int i3 = aii.mStatus;
                    int i4 = aii.fJQ;
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i2));
                    hashMap.put("currentPosition", Integer.valueOf(i));
                    hashMap.put("status", Integer.valueOf(i3));
                    hashMap.put("downloadPercent", Integer.valueOf(i4));
                    a(iVar, "getMusicPlayerState:ok", hashMap);
                }
            }
            AppMethodBeat.o(9443);
        }
        return true;
    }

    private boolean bT(i iVar) {
        AppMethodBeat.i(9444);
        String str = (String) iVar.puc.get("localId");
        if (bo.isNullOrNil(str)) {
            a(iVar, "getLocalImgData:fail_invaild_localid", null);
            AppMethodBeat.o(9444);
        } else {
            WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str);
            if (!(aex == null || aex.hGG == null)) {
                int i;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(aex.hGG);
                int i2 = decodeFile != null ? 1 : 0;
                if (decodeFile.isRecycled()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i2 & i) != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    ab.i("MicroMsg.MsgHandler", "rawData lenght = %d, base64 lenght = %d", Integer.valueOf(byteArrayOutputStream.toByteArray().length), Integer.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0).length()));
                    Map hashMap = new HashMap();
                    hashMap.put("localData", r3);
                    a(iVar, "getLocalImgData:ok", hashMap);
                    ab.i("MicroMsg.MsgHandler", "bitmap recycle %s", decodeFile.toString());
                    decodeFile.recycle();
                    AppMethodBeat.o(9444);
                }
            }
            a(iVar, "getLocalImgData:fail", null);
            AppMethodBeat.o(9444);
        }
        return true;
    }

    private boolean bU(i iVar) {
        int i = 0;
        AppMethodBeat.i(9445);
        this.eBB = false;
        Bundle bundle = new Bundle();
        try {
            int i2 = bo.getInt(iVar.puc.get("scene").toString().trim(), 0);
            bundle.putInt("scene", i2);
            ab.i("MicroMsg.MsgHandler", "doExposePreparation scene:%d", Integer.valueOf(i2));
            if (-1 == bundle.getInt("scene")) {
                a(iVar, "doExposePreparation fail:unknown scene", null);
            } else {
                bundle = this.umI.g(73, bundle);
                Map hashMap = new HashMap();
                if (bundle.isEmpty()) {
                    a(iVar, "doExposePreparation fail", null);
                } else {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 35:
                        case 36:
                        case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                        case 38:
                        case 39:
                        case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                            break;
                        case 33:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            break;
                        case 34:
                            hashMap.put("webviewImg", bundle.getString("webviewImg"));
                            hashMap.put("webviewHtml", bundle.getString("webviewHtml"));
                            hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, bundle.getString("url"));
                            ab.i("MicroMsg.MsgHandler", "content = " + bundle.getString("url"));
                            break;
                        case 51:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            hashMap.put("msgType", Integer.valueOf(bundle.getInt("msgType")));
                            break;
                        default:
                            ab.w("MicroMsg.MsgHandler", "unknown scene %d", Integer.valueOf(i2));
                            break;
                    }
                    hashMap.put("username", bundle.getString("username"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList stringArrayList = bundle.getStringArrayList("proof");
                    if (stringArrayList != null) {
                        int size = stringArrayList.size();
                        while (i < size) {
                            jSONArray.put(stringArrayList.get(i));
                            i++;
                        }
                    }
                    if (!hashMap.containsKey(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT)) {
                        hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, jSONArray.toString());
                    }
                    a(iVar, "doExposePreparation ok", hashMap);
                }
            }
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "doExposePreparation exception " + e.getMessage());
            a(iVar, "doExposePreparation fail", null);
        }
        AppMethodBeat.o(9445);
        return true;
    }

    private boolean bV(i iVar) {
        AppMethodBeat.i(9446);
        try {
            String obj = iVar.puc.get("type").toString();
            if (bo.isNullOrNil(obj)) {
                a(iVar, "openLuckyMoneyHistory:fail", null);
                AppMethodBeat.o(9446);
                return true;
            }
            Intent intent;
            if (obj.equals("send")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bp.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            } else if (obj.equals("receive")) {
                intent = new Intent();
                intent.putExtra("key_type", 2);
                com.tencent.mm.bp.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            }
            AppMethodBeat.o(9446);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doOpenLuckyMoneyHistory error %s", e);
            a(iVar, "openLuckyMoneyHistory:fail", null);
        }
    }

    private boolean bW(i iVar) {
        AppMethodBeat.i(9447);
        String obj = iVar.puc.get("chat_username").toString();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", obj);
        intent.putExtra("finish_direct", true);
        intent.putExtra("expose_edit_mode", true);
        intent.setFlags(536870912);
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bp.d.a((MMActivity) this.context, ".ui.chatting.ChattingUI", intent, 40, (com.tencent.mm.ui.MMActivity.a) this);
        } else {
            ab.e("MicroMsg.MsgHandler", "getMsgProofItems invalid context");
            a(iVar, "select chat record:fail", null);
        }
        AppMethodBeat.o(9447);
        return true;
    }

    private boolean bX(i iVar) {
        AppMethodBeat.i(9448);
        this.eBB = false;
        String trim = iVar.puc.get("scene").toString().trim();
        if (!trim.equals("expose")) {
            a(iVar, "openSecurityView fail, scene error : ".concat(String.valueOf(trim)), null);
        } else if (iVar.puc.get("userData") != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(iVar.puc.get("userData").toString()).nextValue();
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", jSONObject.get("userName").toString());
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 1);
                intent.setFlags(536870912);
                com.tencent.mm.bp.d.b(this.context, "sns", ".ui.SnsPermissionUI", intent);
                a(iVar, "openSecurityView ok", null);
            } catch (JSONException e) {
                ab.w("MicroMsg.MsgHandler", "openSecurityView error, userData not in json");
                a(iVar, "openSecurityView error,userData not in json", null);
            }
        } else {
            a(iVar, "openSecurityView fail, no userData", null);
        }
        AppMethodBeat.o(9448);
        return true;
    }

    private boolean bY(i iVar) {
        AppMethodBeat.i(9449);
        String bK = bK(getCurrentUrl());
        String LK = com.tencent.mm.compatible.e.q.LK();
        String LM = com.tencent.mm.compatible.e.q.LM();
        if (bo.isNullOrNil(LK) || bo.isNullOrNil(bK) || bo.isNullOrNil(LM)) {
            a(iVar, "getOpenDeviceId:fail", null);
        } else {
            LK = ag.ck(ag.ck(bK + LK));
            bK = ag.ck(ag.ck(bK + LM));
            Map hashMap = new HashMap();
            hashMap.put("deviceid", LK);
            hashMap.put("newDeviceId", bK);
            a(iVar, "getOpenDeviceId:ok", hashMap);
        }
        AppMethodBeat.o(9449);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A:{Catch:{ Exception -> 0x00a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A:{Catch:{ Exception -> 0x00a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072 A:{LOOP_END, Catch:{ Exception -> 0x00a6 }, LOOP:0: B:21:0x0070->B:22:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A:{Catch:{ Exception -> 0x00a6 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bZ(i iVar) {
        AppMethodBeat.i(9450);
        try {
            Bundle g = this.umI.g(90000, null);
            if (g != null) {
                String str;
                String str2;
                String str3;
                Object[] objArr;
                Map hashMap;
                JSONArray jSONArray;
                String[] stringArray = g.getStringArray("webview_get_route_url_list");
                int i = g.getInt("webview_get_route_url_geta8key_scene");
                if (i == 7 || i == 56) {
                    String string = g.getString("geta8key_username");
                    if (!bo.isNullOrNil(string)) {
                        com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(string);
                        if (qX != null) {
                            str = qX.field_appId;
                            str2 = "MicroMsg.MsgHandler";
                            str3 = "routeUrl length = %d, scene = %d, appid = %s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = str;
                            ab.i(str2, str3, objArr);
                            if (stringArray != null && stringArray.length > 0) {
                                hashMap = new HashMap();
                                jSONArray = new JSONArray();
                                for (Object put : stringArray) {
                                    jSONArray.put(put);
                                }
                                hashMap.put("urls", jSONArray.toString());
                                hashMap.put("scene", Integer.valueOf(i));
                                if (!bo.isNullOrNil(str)) {
                                    hashMap.put("appid", str);
                                }
                                a(iVar, "getRouteUrl:ok", hashMap);
                                AppMethodBeat.o(9450);
                                return true;
                            }
                        }
                    }
                }
                str = null;
                str2 = "MicroMsg.MsgHandler";
                str3 = "routeUrl length = %d, scene = %d, appid = %s";
                objArr = new Object[3];
                if (stringArray == null) {
                }
                objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str;
                ab.i(str2, str3, objArr);
                hashMap = new HashMap();
                jSONArray = new JSONArray();
                while (r0 < r8) {
                }
                hashMap.put("urls", jSONArray.toString());
                hashMap.put("scene", Integer.valueOf(i));
                if (bo.isNullOrNil(str)) {
                }
                a(iVar, "getRouteUrl:ok", hashMap);
                AppMethodBeat.o(9450);
                return true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "get routeurl failed ; %s", e.getMessage());
        }
        a(iVar, "getRouteUrl:fail", null);
        AppMethodBeat.o(9450);
        return true;
    }

    private boolean ca(i iVar) {
        AppMethodBeat.i(9451);
        ab.i("MicroMsg.MsgHandler", "doGetBackgroundAudioState()");
        if (cc(iVar)) {
            com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
            if (aih != null) {
                int i;
                com.tencent.mm.aw.c aii = com.tencent.mm.aw.a.aii();
                int i2 = -1;
                if (aii != null) {
                    i2 = aii.mDuration;
                    i = aii.mPosition;
                } else {
                    i = 0;
                }
                if (aii == null || i2 < 0 || i < 0) {
                    ab.e("MicroMsg.MsgHandler", "return parameter is invalid");
                    a(iVar, "getBackgroundAudioState:fail", null);
                    AppMethodBeat.o(9451);
                } else {
                    com.tencent.mm.sdk.b.a.xxA.c(this.uHa);
                    i2 /= 1000;
                    int i3 = i / 1000;
                    int i4 = aii.mStatus;
                    i = aii.fJQ;
                    if (i2 > 0) {
                        i = (i * i2) / 100;
                    } else {
                        i = 0;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i2));
                    hashMap.put("currentTime", Integer.valueOf(i3));
                    hashMap.put("paused", Integer.valueOf(i4 == 1 ? 0 : 1));
                    hashMap.put("src", aih.fKa);
                    hashMap.put("buffered", Integer.valueOf(i));
                    hashMap.put("title", aih.fJW);
                    hashMap.put("epname", aih.fJY);
                    hashMap.put("singer", aih.fJX);
                    hashMap.put("coverImgUrl", aih.fJZ);
                    hashMap.put("isLive", Integer.valueOf(0));
                    hashMap.put("startTime", Integer.valueOf(aih.startTime / 1000));
                    hashMap.put("srcId", aih.fKs);
                    hashMap.put("protocol", aih.protocol == null ? "" : aih.protocol);
                    hashMap.put("webUrl", aih.fKc);
                    hashMap.put("playState", aii.fJR);
                    ab.i("MicroMsg.MsgHandler", "getBackgroundAudioState ok");
                    a(iVar, "getBackgroundAudioState:ok", hashMap);
                }
            } else {
                ab.e("MicroMsg.MsgHandler", "currentWrapper is null");
                a(iVar, "getBackgroundAudioState:fail", null);
            }
            AppMethodBeat.o(9451);
        } else {
            ab.e("MicroMsg.MsgHandler", "no permission to do get state");
            a(iVar, "getBackgroundAudioState:fail", null);
            AppMethodBeat.o(9451);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String agj;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        String str9;
        String str10;
        boolean jB;
        String str11;
        AppMethodBeat.i(9452);
        ab.i("MicroMsg.MsgHandler", "doSetBackgroundAudioState()");
        com.tencent.mm.sdk.b.a.xxA.c(this.uHa);
        CharSequence charSequence = (String) iVar.puc.get("appId");
        if (this.uGh != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.uGh.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                String aeL;
                agj = this.uGr.agj(getCurrentUrl());
                ab.i("MicroMsg.MsgHandler", "appId:%s", agj);
                l.a(iVar.uII, false, null, agj);
                str = (String) iVar.puc.get("url");
                if (bo.isNullOrNil(str)) {
                    aeL = q.aeL(str);
                } else {
                    aeL = null;
                }
                str2 = (String) iVar.puc.get("src");
                str3 = (String) iVar.puc.get("lowbandSrc");
                str4 = (String) iVar.puc.get("title");
                str5 = (String) iVar.puc.get("epname");
                str6 = (String) iVar.puc.get("singer");
                str = (String) iVar.puc.get("coverImgUrl");
                str7 = (String) iVar.puc.get("webUrl");
                i = bo.getInt((String) iVar.puc.get("startTime"), 0);
                str8 = (String) iVar.puc.get("srcId");
                str9 = (String) iVar.puc.get("protocol");
                str10 = (String) iVar.puc.get("musicbar_url");
                jB = jsapiPermissionWrapper.jB(308);
                if (str != null) {
                    str11 = "";
                } else {
                    str11 = str;
                }
                ab.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(jB), str10);
                if (!bo.isNullOrNil(str2) || bo.isNullOrNil(str4)) {
                    ab.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
                    a(iVar, "setBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.aw.e a = com.tencent.mm.aw.f.a(10, str11, str4, str6, str7, str3, str2, str2.hashCode(), com.tencent.mm.compatible.util.e.eSn, com.tencent.mm.plugin.i.c.XW() + str11.hashCode(), str5, agj);
                    a.fKr = aeL;
                    a.startTime = i * 1000;
                    a.fKs = str8;
                    a.protocol = str9;
                    a.fKt = jB;
                    a.fKu = str10;
                    com.tencent.mm.aw.a.b(a);
                    ab.i("MicroMsg.MsgHandler", "setBackgroundAudioState ok");
                    a(iVar, "setBackgroundAudioState:ok", null);
                }
                AppMethodBeat.o(9452);
                return true;
            }
        }
        CharSequence agj2 = charSequence;
        ab.i("MicroMsg.MsgHandler", "appId:%s", agj2);
        l.a(iVar.uII, false, null, agj2);
        str = (String) iVar.puc.get("url");
        if (bo.isNullOrNil(str)) {
        }
        str2 = (String) iVar.puc.get("src");
        str3 = (String) iVar.puc.get("lowbandSrc");
        str4 = (String) iVar.puc.get("title");
        str5 = (String) iVar.puc.get("epname");
        str6 = (String) iVar.puc.get("singer");
        str = (String) iVar.puc.get("coverImgUrl");
        str7 = (String) iVar.puc.get("webUrl");
        i = bo.getInt((String) iVar.puc.get("startTime"), 0);
        str8 = (String) iVar.puc.get("srcId");
        str9 = (String) iVar.puc.get("protocol");
        str10 = (String) iVar.puc.get("musicbar_url");
        jB = jsapiPermissionWrapper.jB(308);
        if (str != null) {
        }
        ab.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(jB), str10);
        if (bo.isNullOrNil(str2)) {
        }
        ab.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
        a(iVar, "setBackgroundAudioState:fail", null);
        AppMethodBeat.o(9452);
        return true;
    }

    private boolean cb(i iVar) {
        AppMethodBeat.i(9453);
        String str = (String) iVar.puc.get("operationType");
        ab.i("MicroMsg.MsgHandler", "doOperateBackgroundAudio(), optype:%s", str);
        String str2 = (String) iVar.puc.get("appId");
        if (this.uGh != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.uGh.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.uGr.agj(getCurrentUrl());
            }
        }
        l.a(iVar.uII, false, null, str2);
        if (!cc(iVar)) {
            ab.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio getMusicPermission is false");
            a(iVar, "operateBackgroundAudio:fail", null);
            AppMethodBeat.o(9453);
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio optype is empty");
            a(iVar, "operateBackgroundAudio:fail", null);
            AppMethodBeat.o(9453);
        } else {
            com.tencent.mm.sdk.b.a.xxA.c(this.uHa);
            if (str.equalsIgnoreCase("play")) {
                if (com.tencent.mm.aw.b.aij()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    ab.e("MicroMsg.MsgHandler", "operateBackgroundAudio play fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                if (com.tencent.mm.aw.b.aij()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    ab.e("MicroMsg.MsgHandler", "operateBackgroundAudio resume fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("pause")) {
                if (com.tencent.mm.aw.b.aik()) {
                    com.tencent.mm.aw.a.aid();
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    ab.e("MicroMsg.MsgHandler", "operateBackgroundAudio pause fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("seek")) {
                int i = bo.getInt((String) iVar.puc.get("currentTime"), -1);
                ab.i("MicroMsg.MsgHandler", "currentTime:%d", Integer.valueOf(i));
                if (i < 0) {
                    ab.e("MicroMsg.MsgHandler", "currentTime is invalid!");
                    a(iVar, "operateBackgroundAudio:fail", null);
                } else if (com.tencent.mm.aw.a.lP(i * 1000)) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    ab.e("MicroMsg.MsgHandler", "operateBackgroundAudio seek fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (!str.equalsIgnoreCase("stop")) {
                ab.e("MicroMsg.MsgHandler", "operateBackgroundAudio fail, invalid opeType");
                a(iVar, "operateBackgroundAudio:fail", null);
            } else if (com.tencent.mm.aw.b.ail()) {
                a(iVar, "operateBackgroundAudio:ok", null);
            } else {
                ab.e("MicroMsg.MsgHandler", "operateBackgroundAudio stop fail");
                a(iVar, "operateBackgroundAudio:fail", null);
            }
            AppMethodBeat.o(9453);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cc(i iVar) {
        CharSequence agj;
        String str;
        CharSequence charSequence;
        boolean z;
        String str2;
        String str3;
        Object[] objArr;
        int i = 1;
        AppMethodBeat.i(9454);
        com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
        CharSequence charSequence2 = (String) iVar.puc.get("appId");
        if (this.uGh != null) {
            if (TextUtils.isEmpty(charSequence2)) {
                charSequence2 = this.uGh.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence2)) {
                agj = this.uGr.agj(getCurrentUrl());
                str = (String) iVar.puc.get("url");
                charSequence = null;
                if (!bo.isNullOrNil(str)) {
                    charSequence = q.aeL(str);
                }
                if (aih == null) {
                    str = aih.fKh;
                    String aeL = q.aeL(aih.fKc);
                    String str4 = aih.fKr;
                    ab.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", agj, str);
                    ab.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", charSequence, aeL, str4);
                    if (TextUtils.isEmpty(agj) || !agj.equalsIgnoreCase(str)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(charSequence) && charSequence.equalsIgnoreCase(aeL)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(charSequence) && charSequence.equalsIgnoreCase(str4)) {
                        z = true;
                    }
                } else {
                    ab.e("MicroMsg.MsgHandler", "currentWrapper is null");
                    z = false;
                }
                str2 = "MicroMsg.MsgHandler";
                str3 = "getMusicPermission hasPermmision:%d";
                objArr = new Object[1];
                if (!z) {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                ab.i(str2, str3, objArr);
                AppMethodBeat.o(9454);
                return z;
            }
        }
        agj = charSequence2;
        str = (String) iVar.puc.get("url");
        charSequence = null;
        if (bo.isNullOrNil(str)) {
        }
        if (aih == null) {
        }
        str2 = "MicroMsg.MsgHandler";
        str3 = "getMusicPermission hasPermmision:%d";
        objArr = new Object[1];
        if (z) {
        }
        objArr[0] = Integer.valueOf(i);
        ab.i(str2, str3, objArr);
        AppMethodBeat.o(9454);
        return z;
    }

    private boolean cd(i iVar) {
        AppMethodBeat.i(9455);
        String T = av.fly.T("login_user_name", "");
        String str = (String) iVar.puc.get("request_ticket");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "requestVoiceLoginVerify, ticket is null");
            a(iVar, "requestVoiceLoginVerify:ticket is null", null);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Kusername", T);
            intent.putExtra("Kvertify_key", str);
            if (this.context instanceof MMActivity) {
                ((MMActivity) this.context).ifE = this;
                com.tencent.mm.bp.d.b(this.context, "voiceprint", ".ui.VoiceLoginUI", intent, 57);
            }
        }
        AppMethodBeat.o(9455);
        return true;
    }

    private boolean ce(i iVar) {
        AppMethodBeat.i(9456);
        Map hashMap = new HashMap();
        try {
            String str = (String) iVar.puc.get("next_step");
            ab.i("MicroMsg.MsgHandler", "next_step: %s", str);
            Bundle bundle = new Bundle();
            if (!bo.isNullOrNil(str)) {
                if ("auth_again".equals(str)) {
                    bundle.putString("go_next", "auth_again");
                } else if ("get_reg_verify_code".equals(str)) {
                    bundle.putString("go_next", "get_reg_verify_code");
                }
            }
            this.umI.cZb();
            this.umI.W(bundle);
            com.tencent.mm.sdk.b.a.xxA.m(new vo());
            hashMap.put("err_code", Integer.valueOf(0));
            hashMap.put("err_msg", "ok");
            a(iVar, "close window and next:ok", hashMap);
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
            hashMap.put("err_code", Integer.valueOf(1));
            hashMap.put("err_msg", "fail");
            a(iVar, "close window and next:fail", hashMap);
        }
        AppMethodBeat.o(9456);
        return true;
    }

    private boolean cf(i iVar) {
        AppMethodBeat.i(9457);
        String str = (String) iVar.puc.get("username");
        if (bo.isNullOrNil(str)) {
            a(iVar, "open_biz_chat:param_err", null);
            AppMethodBeat.o(9457);
        } else {
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
            if (aoO == null || !aoO.dsf()) {
                a(iVar, "open_biz_chat:not biz username", null);
                AppMethodBeat.o(9457);
            } else if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.bp.d.f(this.context, ".ui.chatting.ChattingUI", intent);
                a(iVar, "open_biz_chat:ok", null);
                AppMethodBeat.o(9457);
            } else {
                a(iVar, "open_biz_chat:unfollow", null);
                AppMethodBeat.o(9457);
            }
        }
        return true;
    }

    private boolean cg(i iVar) {
        AppMethodBeat.i(9458);
        String str = (String) iVar.puc.get("url");
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView, url is null");
            a(iVar, "openGameUrlWithExtraWebView:fail", null);
            AppMethodBeat.o(9458);
        } else {
            String str2 = (String) iVar.puc.get("statusBarColor");
            int i = 0;
            if (!bo.isNullOrNil(str2)) {
                try {
                    i = Color.parseColor(str2);
                } catch (IllegalArgumentException e) {
                    ab.e("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView: " + e.getMessage());
                    a(iVar, "openGameUrlWithExtraWebView:fail_invalid_color", null);
                    AppMethodBeat.o(9458);
                }
            }
            str2 = (String) iVar.puc.get("statusBarStyle");
            final Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("customize_status_bar_color", i);
            intent.putExtra("status_bar_style", str2);
            ab.i("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView, time: " + System.currentTimeMillis());
            intent.putExtra("start_time", System.currentTimeMillis());
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", this.umI, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9081);
                    com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
                    AppMethodBeat.o(9081);
                }
            });
            a(iVar, "openGameUrlWithExtraWebView:ok", null);
            AppMethodBeat.o(9458);
        }
        return true;
    }

    private boolean ch(i iVar) {
        AppMethodBeat.i(9459);
        String bK = bK(getCurrentUrl());
        if (bo.isNullOrNil(bK)) {
            ab.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "setGameData:fail_appid_null", null);
            AppMethodBeat.o(9459);
        } else {
            String str = (String) iVar.puc.get("key");
            String str2 = (String) iVar.puc.get("value");
            String str3 = (String) iVar.puc.get("weight");
            String str4 = (String) iVar.puc.get("expireTime");
            boolean z = bo.getBoolean((String) iVar.puc.get("autoClean"), true);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.i("MicroMsg.MsgHandler", "key or value is null");
                a(iVar, "setGameData:fail_null_key", null);
                AppMethodBeat.o(9459);
            } else {
                if (com.tencent.mm.plugin.webview.b.b.cWi().a(bK, str, str2, str3, str4, z)) {
                    a(iVar, "setGameData:ok", null);
                } else {
                    a(iVar, "setGameData:fail_exceed_size", null);
                }
                AppMethodBeat.o(9459);
            }
        }
        return true;
    }

    private boolean ci(i iVar) {
        AppMethodBeat.i(9460);
        String bK = bK(getCurrentUrl());
        if (bo.isNullOrNil(bK)) {
            ab.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "getGameData:fail", null);
            AppMethodBeat.o(9460);
        } else {
            String str = (String) iVar.puc.get("key");
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "getGameData:fail", null);
                AppMethodBeat.o(9460);
            } else {
                com.tencent.mm.plugin.webview.b.a gV = com.tencent.mm.plugin.webview.b.b.cWi().gV(bK, str);
                if (bo.isNullOrNil(gV.field_value)) {
                    a(iVar, "getGameData:ok", null);
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put("value", gV.field_value);
                    hashMap.put("weight", gV.field_weight);
                    hashMap.put("expireTime", Long.valueOf(gV.field_expireTime - (System.currentTimeMillis() / 1000)));
                    a(iVar, "getGameData:ok", hashMap);
                }
                AppMethodBeat.o(9460);
            }
        }
        return true;
    }

    private boolean cj(i iVar) {
        AppMethodBeat.i(9461);
        String bK = bK(getCurrentUrl());
        if (bo.isNullOrNil(bK)) {
            ab.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "clearData:fail", null);
            AppMethodBeat.o(9461);
        } else {
            String str = (String) iVar.puc.get("keys");
            boolean z = bo.getBoolean((String) iVar.puc.get("clearAllData"), false);
            if (!bo.isNullOrNil(str)) {
                try {
                    com.tencent.mm.plugin.webview.b.b.cWi().b(bK, new JSONArray(str));
                    a(iVar, "clearGameData:ok", null);
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "doClearData: " + e.getMessage());
                    a(iVar, "clearGameData:fail", null);
                }
            } else if (z) {
                com.tencent.mm.plugin.webview.b.b.cWi().adY(bK);
                a(iVar, "clearGameData:ok", null);
            } else {
                ab.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "clearGameData:fail", null);
            }
            AppMethodBeat.o(9461);
        }
        return true;
    }

    private boolean ck(i iVar) {
        boolean z;
        AppMethodBeat.i(9462);
        this.eBB = false;
        a(iVar, "recordHistory:ok", null);
        if ((com.tencent.mm.bd.b.aiC().fNf & 131072) == 131072) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String aek = ar.aek((String) iVar.puc.get("url"));
            if (bo.isNullOrNil(aek)) {
                a(iVar, "recordHistory:fail", null);
                AppMethodBeat.o(9462);
            } else {
                String str;
                String nullAsNil;
                int i = bo.getInt((String) iVar.puc.get("webview_scene"), 0);
                if (i == 33 || i == 46) {
                    ab.i("MicroMsg.MsgHandler", "hasRecordPermission false, getA8keyScene = ".concat(String.valueOf(i)));
                    z = false;
                } else if (aek.startsWith("http")) {
                    Uri parse = Uri.parse(aek);
                    str = parse.getHost() + parse.getPath();
                    ab.i("MicroMsg.MsgHandler", "hasRecordPermission, hostPath: ".concat(String.valueOf(str)));
                    String string = com.tencent.mm.plugin.webview.model.af.a.cXG().getString("oauth_host_paths");
                    if (bo.isNullOrNil(string)) {
                        string = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    String[] split = string.split(";");
                    if (str.contains("weixin110.qq.com")) {
                        z = false;
                    } else if ("weixin110.qq.com;res.wx.qq.com;weops.qq.com;wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;payapp.weixin.qq.com;pay.weixin.qq.com;wx.tenpay.com".contains(parse.getHost().toLowerCase())) {
                        ab.i("MicroMsg.MsgHandler", "forbidden host %s", parse.getHost());
                        z = false;
                    } else {
                        for (String nullAsNil2 : split) {
                            if (str.equalsIgnoreCase(nullAsNil2)) {
                                z = false;
                                break;
                            }
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("title"));
                    str = bo.nullAsNil((String) iVar.puc.get("source"));
                    String nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("img_url"));
                    ab.i("MicroMsg.MsgHandler", "doRecordHistory link %s,title %s,source %s,imgUrl %s", aek, nullAsNil2, str, nullAsNil3);
                    com.tencent.mm.plugin.webview.b.e cYJ = com.tencent.mm.plugin.webview.modeltools.g.cYJ();
                    com.tencent.mm.plugin.webview.b.d dVar = new com.tencent.mm.plugin.webview.b.d();
                    dVar.field_link = aek;
                    if (!cYJ.b((com.tencent.mm.sdk.e.c) dVar, "link")) {
                        dVar = null;
                    }
                    if (dVar != null) {
                        ab.i("MicroMsg.MsgHandler", "doRecordHistory update");
                        dVar.field_link = aek;
                        dVar.field_title = nullAsNil2;
                        dVar.field_source = str;
                        dVar.field_imgUrl = nullAsNil3;
                        dVar.field_timeStamp = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.webview.modeltools.g.cYJ().c(dVar, new String[0]);
                    } else {
                        ab.i("MicroMsg.MsgHandler", "doRecordHistory insert");
                        com.tencent.mm.plugin.webview.b.e cYJ2 = com.tencent.mm.plugin.webview.modeltools.g.cYJ();
                        com.tencent.mm.plugin.webview.b.d dVar2 = new com.tencent.mm.plugin.webview.b.d();
                        dVar2.field_link = aek;
                        dVar2.field_title = nullAsNil2;
                        dVar2.field_source = str;
                        dVar2.field_imgUrl = nullAsNil3;
                        dVar2.field_timeStamp = System.currentTimeMillis() / 1000;
                        dVar2.field_recordId = aek.hashCode() + "_" + System.currentTimeMillis();
                        ab.i("MicroMsg.WebViewHistoryStorage", "insert: ".concat(String.valueOf(cYJ2.b((com.tencent.mm.sdk.e.c) dVar2))));
                        com.tencent.mm.ce.a.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(5646);
                                e.this.hY("WebViewHistory", "delete from WebViewHistory where  timeStamp < ".concat(String.valueOf((System.currentTimeMillis() / 1000) - 604800)));
                                e.a(e.this);
                                AppMethodBeat.o(5646);
                            }
                        });
                    }
                    a(iVar, "recordHistory:ok", null);
                    AppMethodBeat.o(9462);
                } else {
                    a(iVar, "recordHistory:fail", null);
                    AppMethodBeat.o(9462);
                }
            }
        } else {
            ab.i("MicroMsg.MsgHandler", "doRecordHistory switch close");
            AppMethodBeat.o(9462);
        }
        return true;
    }

    private boolean cl(i iVar) {
        AppMethodBeat.i(9463);
        Map hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
        hashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
        hashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(ah.getContext())));
        hashMap.put("brand", android.os.Build.BRAND);
        hashMap.put("model", android.os.Build.MODEL);
        a(iVar, "getSystemInfo:ok", hashMap);
        AppMethodBeat.o(9463);
        return true;
    }

    private boolean cm(i iVar) {
        AppMethodBeat.i(9464);
        try {
            ab.i("MicroMsg.MsgHandler", "doServiceClick, tid = %s", (String) iVar.puc.get("tid"));
            Bundle bundle = new Bundle();
            bundle.putString("service_click_tid", r0);
            this.umI.c(70, bundle);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        this.eBB = false;
        AppMethodBeat.o(9464);
        return false;
    }

    private boolean cn(i iVar) {
        AppMethodBeat.i(9465);
        String bK = bK(getCurrentUrl());
        if (bo.isNullOrNil(bK)) {
            ab.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]appid is null, return");
            a(iVar, "openRealnameAuth:fail appid is null", null);
            AppMethodBeat.o(9465);
            return false;
        }
        String str = (String) iVar.puc.get("categoryId");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]categoryId is null, return");
            a(iVar, "openRealnameAuth:fail categoryId is null", null);
            AppMethodBeat.o(9465);
            return false;
        }
        Intent putExtra = new Intent().putExtra("intent_appid", bK).putExtra("intent_category_id", str);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).ifE = this;
            com.tencent.mm.bp.d.b(this.context, "appbrand", ".ui.autofill.AppBrandIDCardUI", putExtra, 62);
            AppMethodBeat.o(9465);
            return true;
        }
        ab.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]context is err, return");
        a(iVar, "openRealnameAuth:fail context is err", null);
        AppMethodBeat.o(9465);
        return false;
    }

    private boolean co(i iVar) {
        AppMethodBeat.i(9466);
        this.cEl = g(iVar);
        if (this.cEl == null) {
            ab.e("MicroMsg.MsgHandler", "doSendSingleAppMessage fail, appmsg is null");
            a(iVar, "sendSingleAppMessage:fail", null);
            AppMethodBeat.o(9466);
            return true;
        }
        HashMap hashMap = new HashMap();
        String str = (String) iVar.puc.get("img_url");
        hashMap.put("img_url", str);
        hashMap.put("desc", (String) iVar.puc.get("desc"));
        hashMap.put("title", (String) iVar.puc.get("title"));
        hashMap.put("url", (String) iVar.puc.get("link"));
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 7);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", r.Yz());
        intent.putExtra("Select_block_List", "filehelper," + r.Yz());
        intent.putExtra("scene_from", 10);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bp.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 61, (com.tencent.mm.ui.MMActivity.a) this);
            k.agC(str);
            AppMethodBeat.o(9466);
            return true;
        }
        ab.e("MicroMsg.MsgHandler", "doSendSingleAppMessage context is not activity");
        AppMethodBeat.o(9466);
        return false;
    }

    private boolean cp(i iVar) {
        AppMethodBeat.i(9467);
        String str = (String) iVar.puc.get("brandName");
        ab.i("MicroMsg.MsgHandler", "doCurrentMpInfo brandIcon:%s", (String) iVar.puc.get("brandIcon"));
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key_bag_icon", r0);
            bundle.putString("key_brand_name", str);
            this.umI.c(71, bundle);
            a(iVar, "currentMpInfo:ok", null);
            AppMethodBeat.o(9467);
        } catch (Exception e) {
            a(iVar, "currentMpInfo:fail", null);
            AppMethodBeat.o(9467);
        }
        return true;
    }

    /* JADX WARNING: Missing block: B:73:0x02da, code skipped:
            if (r0.equals("openSearch") != false) goto L_0x02b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cq(i iVar) {
        int i = 0;
        AppMethodBeat.i(9468);
        String str = (String) iVar.puc.get("opcode");
        String str2 = (String) iVar.puc.get("business");
        ab.i("MicroMsg.MsgHandler", "business %s,opcode %s", str2, str);
        if (!bo.Q(str, str2)) {
            Bundle bundle;
            if (str2.equals("regLogin")) {
                Bundle bundle2;
                if (str.equals("setIsAgree")) {
                    try {
                        bundle = new Bundle();
                        if (bo.getInt((String) iVar.puc.get("isAgree"), 0) == 1) {
                            bundle.putString("go_next", "agree_privacy");
                        }
                        this.umI.cZb();
                        this.umI.W(bundle);
                        com.tencent.mm.sdk.b.a.xxA.m(new vo());
                        a(iVar, "set wc privacy policy result:ok", null);
                    } catch (Exception e) {
                        ab.w("MicroMsg.MsgHandler", "setWcPrivacyPolicyResult, ex = " + e.getMessage());
                    }
                } else if (str.equals("setBirthday")) {
                    str2 = (String) iVar.puc.get("mobile");
                    ab.i("MicroMsg.MsgHandler", "mobile %s,birthday %s", str2, (String) iVar.puc.get("birthday"));
                    if (bo.isNullOrNil(str2) && com.tencent.mm.kernel.g.RK()) {
                        com.tencent.mm.kernel.g.RQ();
                        str2 = (String) com.tencent.mm.kernel.g.RP().Ry().get(6, null);
                    }
                    if (!bo.Q(str2, str)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("birthday", str);
                        hashMap.put("last_update_birthday_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        bn.fnk.g(str2, hashMap);
                    }
                    a(iVar, "setBirthday OK", null);
                } else if (str.equals("getBirthday")) {
                    long j;
                    Map hashMap2 = new HashMap();
                    str = (String) iVar.puc.get("mobile");
                    ab.i("MicroMsg.MsgHandler", "getBirthday of %s", str);
                    Object obj = "";
                    if (bo.isNullOrNil(str) && com.tencent.mm.kernel.g.RK()) {
                        com.tencent.mm.kernel.g.RQ();
                        str = (String) com.tencent.mm.kernel.g.RP().Ry().get(6, null);
                    }
                    if (bo.isNullOrNil(str)) {
                        j = 0;
                    } else {
                        String string = bn.fnk.getString(str, "birthday");
                        j = bo.anl(bn.fnk.getString(str, "last_update_birthday_time"));
                        obj = string;
                    }
                    ab.i("MicroMsg.MsgHandler", "updateTime %s", Long.valueOf(j));
                    hashMap2.put("birthday", obj);
                    hashMap2.put("updatetime", Long.valueOf(j));
                    a(iVar, "getBirthday OK", hashMap2);
                } else if (str.equals("birthdayComfirmOK")) {
                    try {
                        bundle2 = new Bundle();
                        bundle2.putString("go_next", "birthdayComfirmOK");
                        this.umI.cZb();
                        this.umI.W(bundle2);
                        com.tencent.mm.sdk.b.a.xxA.m(new vo());
                        a(iVar, "birthdayConfirmOK", null);
                    } catch (Exception e2) {
                        ab.w("MicroMsg.MsgHandler", "setWcPrivacyPolicyResult, ex = " + e2.getMessage());
                    }
                } else if (str.equals("continue")) {
                    try {
                        bundle2 = new Bundle();
                        bundle2.putString("go_next", "gdpr_confirm_continue");
                        this.umI.cZb();
                        this.umI.W(bundle2);
                        com.tencent.mm.sdk.b.a.xxA.m(new vo());
                        a(iVar, "h5 confirm continue OK", null);
                    } catch (Exception e22) {
                        ab.w("MicroMsg.MsgHandler", "setWcPrivacyPolicyResult, ex = " + e22.getMessage());
                    }
                }
            } else if (com.tencent.mm.model.gdpr.a.oX(str2)) {
                if ("setIsAgree".equals(str)) {
                    boolean z = bo.getInt((String) iVar.puc.get("isAgree"), 0) == 1;
                    bundle = new Bundle(1);
                    bundle.putBoolean("OnMPGdprPolicyAgreement_KIsAgree", z);
                    try {
                        this.umI.c(200, bundle);
                    } catch (Exception e222) {
                        ab.e("MicroMsg.MsgHandler", "wcPrivacyPolicyResult, [mp_gdpr], callback ex = %s", e222);
                    }
                }
                a(iVar, "wcPrivacyPolicyResult:ok", null);
            } else if (str2.equals(com.google.firebase.analytics.FirebaseAnalytics.a.SEARCH)) {
                switch (str.hashCode()) {
                    case 158651840:
                        if (str.equals("closeSearch")) {
                            i = 1;
                            break;
                        }
                    case 334239890:
                        break;
                    default:
                        i = -1;
                        break;
                }
                switch (i) {
                    case 0:
                        ((com.tencent.mm.plugin.websearch.api.m) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.m.class)).cUK();
                        break;
                    case 1:
                        ((com.tencent.mm.plugin.websearch.api.m) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.m.class)).cUL();
                        break;
                }
                try {
                    this.umI.W(null);
                } catch (Exception e3) {
                }
                com.tencent.mm.sdk.b.a.xxA.m(new vo());
                a(iVar, "wcPrivacyPolicyResult:ok", null);
            } else if (str2.equals("walletIndexGDPR")) {
                if (str.equals("setIsAgree")) {
                    try {
                        bundle = new Bundle();
                        if (bo.getInt((String) iVar.puc.get("isAgree"), 0) == 1) {
                            bundle.putString("go_next", "agree_privacy");
                        }
                        vw vwVar = new vw();
                        vwVar.cTd.cBp = "agree_privacy";
                        com.tencent.mm.sdk.b.a.xxA.m(vwVar);
                        ab.i("MicroMsg.MsgHandler", "walletIndexGDPR agreement %s", Integer.valueOf(r0));
                        this.umI.cZb();
                        this.umI.W(bundle);
                        com.tencent.mm.sdk.b.a.xxA.m(new vo());
                        a(iVar, "set walletIndexGDPR wc privacy policy result:ok", null);
                    } catch (Exception e2222) {
                        ab.w("MicroMsg.MsgHandler", "setwalletIndexGDPR WcPrivacyPolicyResult, ex = " + e2222.getMessage());
                    }
                }
            } else if (str2.equals(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION) && str.equals("setIsAgree")) {
                try {
                    bundle = new Bundle();
                    if (bo.getInt((String) iVar.puc.get("isAgree"), 0) == 1) {
                        bundle.putString("go_next", "gdpr_auth_location");
                    }
                    this.umI.cZb();
                    this.umI.W(bundle);
                    com.tencent.mm.sdk.b.a.xxA.m(new vo());
                    a(iVar, "hint location permission use scene result:ok", null);
                } catch (Exception e22222) {
                    ab.w("MicroMsg.MsgHandler", "setLocationPermissionUseScene Result, ex = " + e22222.getMessage());
                }
            }
        }
        AppMethodBeat.o(9468);
        return true;
    }

    private boolean cr(i iVar) {
        AppMethodBeat.i(9469);
        byte[] bVS = com.tencent.mm.plugin.normsg.a.b.oTO.bVS();
        if (bVS != null) {
            Map hashMap = new HashMap(1);
            hashMap.put("data", Base64.encodeToString(bVS, 2));
            a(iVar, iVar.uIJ + ":ok", hashMap);
            AppMethodBeat.o(9469);
            return true;
        }
        a(iVar, iVar.uIJ + ":fail", null);
        AppMethodBeat.o(9469);
        return false;
    }

    private boolean cs(i iVar) {
        AppMethodBeat.i(9470);
        Object obj = iVar.puc.get("rqt");
        if (obj == null) {
            ab.e("MicroMsg.MsgHandler", "calrqt, dataIn is null.");
            a(iVar, iVar.uIJ + ":fail", null);
            AppMethodBeat.o(9470);
            return false;
        }
        byte[] bytes;
        if (obj instanceof String) {
            bytes = ((String) obj).getBytes(Charset.forName("UTF-8"));
        } else if (obj instanceof byte[]) {
            bytes = (byte[]) obj;
        } else {
            ab.e("MicroMsg.MsgHandler", "calrqt, cannot determine type of rqt data.");
            a(iVar, iVar.uIJ + ":fail", null);
            AppMethodBeat.o(9470);
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PByteArray pByteArray = new PByteArray();
        if (com.tencent.mm.plugin.normsg.a.b.oTO.a(1, bytes, 0, bytes.length, pInt, pInt2, pByteArray)) {
            Map hashMap = new HashMap(5);
            hashMap.put("k1", Integer.valueOf(pInt.value));
            hashMap.put("k2", Integer.valueOf(pInt2.value));
            hashMap.put("data", Base64.encodeToString(pByteArray.value, 2));
            a(iVar, iVar.uIJ + ":ok", hashMap);
            AppMethodBeat.o(9470);
            return true;
        }
        ab.e("MicroMsg.MsgHandler", "calrqt, cannot calculate hash of rqt data.");
        a(iVar, iVar.uIJ + ":fail", null);
        AppMethodBeat.o(9470);
        return false;
    }

    private boolean ct(i iVar) {
        AppMethodBeat.i(9471);
        String str = (String) iVar.puc.get("user_ticket");
        int i = bo.getInt((String) iVar.puc.get("scene"), 0);
        int i2 = bo.getInt((String) iVar.puc.get("check_alive_type"), 1);
        float f = bo.getFloat((String) iVar.puc.get("light_threshold"), 4.0f);
        ((MMActivity) this.context).ifE = this;
        Bundle bundle = new Bundle();
        bundle.putInt("k_server_scene", 6);
        bundle.putInt("k_from_scene", i);
        bundle.putString("key_function_name", iVar.uIJ);
        bundle.putInt("key_business_type", 1);
        bundle.putInt("check_alive_type_response", i2);
        bundle.putString("k_ticket", str);
        bundle.putFloat("mLight_threshold", f);
        op opVar = new op();
        opVar.cKW.context = this.context;
        opVar.cKW.cKY = 64;
        opVar.cKW.extras = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(opVar);
        ab.i("MicroMsg.MsgHandler", "start face detect event result: %b", Boolean.valueOf(opVar.cKX.cKV));
        if (!opVar.cKX.cKV) {
            ((MMActivity) this.context).ifE = null;
            a(iVar, iVar.uIJ + ":fail", i.aq(opVar.cKX.extras));
        }
        AppMethodBeat.o(9471);
        return true;
    }

    private boolean cu(i iVar) {
        AppMethodBeat.i(9472);
        String str = (String) iVar.puc.get("pkgIdList");
        if (!bo.isNullOrNil(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                    if (!bo.ek(arrayList)) {
                        vv vvVar = new vv();
                        vvVar.cSX.cuy = 8;
                        vvVar.cSX.scene = 0;
                        vvVar.cSX.cTc = arrayList;
                        com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                        a(iVar, iVar.uIJ + ":ok", null);
                        AppMethodBeat.o(9472);
                        return true;
                    }
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.MsgHandler", "data is not json");
            }
        }
        a(iVar, iVar.uIJ + ":fail", null);
        AppMethodBeat.o(9472);
        return false;
    }

    private boolean cv(i iVar) {
        AppMethodBeat.i(9473);
        ((com.tencent.mm.plugin.appbrand.service.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.a.class)).bq((String) iVar.puc.get("uuid"), (String) iVar.puc.get("req_data"));
        try {
            this.umI.g(100000, Bundle.EMPTY);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "doPrivateOpenWeappFunctionalPage, AC_FINISH_ON_RESUME e = %s", e);
        }
        AppMethodBeat.o(9473);
        return false;
    }

    private boolean cw(i iVar) {
        Bundle g;
        AppMethodBeat.i(9474);
        TreeMap treeMap = new TreeMap(new Comparator<Integer>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(9084);
                int compareTo = ((Integer) obj).compareTo((Integer) obj2);
                AppMethodBeat.o(9084);
                return compareTo;
            }
        });
        try {
            g = this.umI.g(150, null);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            g = null;
        }
        if (g == null) {
            a(iVar, iVar.uIJ + ":fail", null);
            AppMethodBeat.o(9474);
        } else {
            JSONObject jSONObject;
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDu), g.getString("page_key"));
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDv), at.gB(ah.getContext()));
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDw), String.valueOf(YearClass.get(ah.getContext())));
            String string = g.getString("raw_url");
            if (!bo.isNullOrNil(string)) {
                try {
                    treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDx), com.tencent.mm.compatible.util.q.encode(string, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                }
            }
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDy), Integer.valueOf(g.getBoolean("is_used_wepkg", false) ? 1 : 0));
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDz), Integer.valueOf(0));
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDA), Integer.valueOf(0));
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDB), g.getString("wepkg_version"));
            treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.a.uDC), g.getString("comm_js_version"));
            String str = (String) iVar.puc.get("type");
            boolean equals = "1".equals((String) iVar.puc.get("isReportNow"));
            try {
                jSONObject = new JSONObject((String) iVar.puc.get("data"));
            } catch (JSONException e3) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                ab.i("MicroMsg.MsgHandler", "data is null or not json");
                a(iVar, iVar.uIJ + ":fail_data_is_null", null);
                AppMethodBeat.o(9474);
            } else {
                Map aO;
                if ("1".equals(str)) {
                    treeMap.put(Integer.valueOf(com.tencent.mm.plugin.webview.ui.tools.game.e.b.uDE), Boolean.valueOf(equals));
                    aO = com.tencent.mm.plugin.webview.ui.tools.game.f.aO(jSONObject);
                    for (Integer num : aO.keySet()) {
                        if (!treeMap.containsKey(num)) {
                            treeMap.put(num, aO.get(num));
                        }
                    }
                    com.tencent.mm.plugin.webview.ui.tools.game.f.y(string, treeMap);
                    a(iVar, iVar.uIJ + ":ok", null);
                } else if ("2".equals(str)) {
                    aO = com.tencent.mm.plugin.webview.ui.tools.game.f.aO(jSONObject);
                    for (Integer num2 : aO.keySet()) {
                        if (!treeMap.containsKey(num2)) {
                            treeMap.put(num2, aO.get(num2));
                        }
                    }
                    ab.i("MicroMsg.MsgHandler", "report web runtime. isReportNow:%b, reportData: [%s]", Boolean.valueOf(equals), com.tencent.mm.plugin.webview.ui.tools.game.e.aI(treeMap));
                    h.pYm.a(16145, str, equals, false);
                    a(iVar, iVar.uIJ + ":ok", null);
                } else {
                    ab.i("MicroMsg.MsgHandler", "type is error. type:%s", str);
                    a(iVar, iVar.uIJ + ":fail_type_not_right", null);
                }
                AppMethodBeat.o(9474);
            }
        }
        return true;
    }

    private boolean cx(i iVar) {
        AppMethodBeat.i(9475);
        String str = "";
        try {
            str = this.umI.getCurrentUrl();
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "doPrivateCommonApi exception in get currentUrl" + e.getMessage());
        }
        ab.i("MicroMsg.MsgHandler", "doPrivateCommonApi currentUrl %s", str);
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://szsupport.weixin.qq.com/security/") || str.startsWith("https://hksupport.weixin.qq.com/security/") || str.startsWith("https://mlsupport.weixin.qq.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            str = (String) iVar.puc.get("opcode");
            if (bo.isNullOrNil(str)) {
                a(iVar, "privateCommonApi:fail, opcode is empty", null);
                AppMethodBeat.o(9475);
                return false;
            } else if (str.equals("selectContact")) {
                ab.i("MicroMsg.MsgHandler", "doPrivateSelectContact");
                Intent intent = new Intent();
                intent.putExtra("list_type", 15);
                intent.putExtra("titile", this.context.getString(R.string.eu));
                intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.C(2, 16384, 1, 4));
                if (this.context instanceof MMActivity) {
                    com.tencent.mm.bp.d.a((MMActivity) this.context, ".ui.contact.SelectContactUI", intent, 65, (com.tencent.mm.ui.MMActivity.a) this);
                } else {
                    ab.e("MicroMsg.MsgHandler", "doSelectContact invalid context");
                    a(iVar, "selectContact:fail", null);
                }
                AppMethodBeat.o(9475);
                return true;
            } else {
                a(iVar, "privateCommonApi:fail, opcode is invalid", null);
                AppMethodBeat.o(9475);
                return false;
            }
        }
        a(iVar, "privateCommonApi:fail access_denied", null);
        AppMethodBeat.o(9475);
        return false;
    }

    private boolean cy(i iVar) {
        AppMethodBeat.i(9476);
        String str = (String) iVar.puc.get(NativeProtocol.WEB_DIALOG_ACTION);
        ab.i("MicroMsg.MsgHandler", "doHandleHaoKanAction action=%s", str);
        if (bo.isNullOrNil(str)) {
            a(iVar, "handleHaokanAction:fail action is empty", null);
            AppMethodBeat.o(9476);
            return false;
        }
        String str2 = (String) iVar.puc.get("server_data");
        String str3 = (String) iVar.puc.get("client_data");
        if ("submitMsgToTL".equals(str)) {
            im imVar = new im();
            imVar.cDD.cDE = str2;
            imVar.cDD.cDF = str3;
            com.tencent.mm.sdk.b.a.xxA.m(imVar);
            a(iVar, "handleHaokanAction:ok", null);
            AppMethodBeat.o(9476);
            return true;
        } else if ("update_recommend_status".equals(str)) {
            com.tencent.mm.plugin.webview.e.c.a aVar;
            str = (String) iVar.puc.get("url");
            com.tencent.mm.plugin.webview.e.c.a agE = this.uGw.agE(str);
            if (agE == null) {
                aVar = new com.tencent.mm.plugin.webview.e.c.a();
            } else {
                aVar = agE;
            }
            aVar.permission = bo.getInt((String) iVar.puc.get("permission"), 0);
            aVar.uKW = bo.getInt((String) iVar.puc.get("recommend"), -1);
            aVar.title = bo.bc((String) iVar.puc.get("title"), aVar.title);
            com.tencent.mm.plugin.webview.e.c cVar = this.uGw;
            cVar.uKV.put(com.tencent.mm.pluginsdk.ui.tools.u.aef(str), aVar);
            ab.i("MicroMsg.MsgHandler", "doHandleHaoKanAction Permission=%d,Recommend=%d", Integer.valueOf(aVar.permission), Integer.valueOf(aVar.uKW));
            a(iVar, "handleHaokanAction:ok", null);
            try {
                this.umI.g(203, null);
            } catch (RemoteException e) {
                ab.e("MicroMsg.MsgHandler", "doHandleHaoKanAction e=%s", e.getMessage());
            }
            AppMethodBeat.o(9476);
            return true;
        } else {
            a(iVar, "handleHaokanAction:fail, action not support", null);
            AppMethodBeat.o(9476);
            return false;
        }
    }

    private boolean cz(i iVar) {
        AppMethodBeat.i(9477);
        Map hashMap = new HashMap();
        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(5)) {
            hashMap.put("err_desc", "abtest closed");
            a(iVar, iVar.uIJ + ":fail", hashMap);
            AppMethodBeat.o(9477);
            return false;
        } else if (!iVar.uIH.has("url")) {
            hashMap.put("err_desc", "invalid url");
            a(iVar, iVar.uIJ + ":fail", hashMap);
            AppMethodBeat.o(9477);
            return false;
        } else if (!iVar.uIH.has("item_show_type")) {
            hashMap.put("err_desc", "invalid item_show_type");
            a(iVar, iVar.uIJ + ":fail", hashMap);
            AppMethodBeat.o(9477);
            return false;
        } else if (!iVar.uIH.has("scene")) {
            hashMap.put("err_desc", "invalid scene");
            a(iVar, iVar.uIJ + ":fail", hashMap);
            AppMethodBeat.o(9477);
            return false;
        } else if (iVar.uIH.has("openType")) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("url", iVar.uIH.getString("url"));
                bundle.putInt("item_show_type", iVar.uIH.getInt("item_show_type"));
                bundle.putInt("scene", iVar.uIH.getInt("scene"));
                bundle.putInt("openType", iVar.uIH.getInt("openType"));
                bundle = this.umI.g(200, bundle);
                if (bundle.getBoolean("success")) {
                    a(iVar, hashMap);
                } else {
                    hashMap.put("err_desc", bo.bc(bundle.getString("desc"), ""));
                    a(iVar, iVar.uIJ + ":fail", hashMap);
                }
                AppMethodBeat.o(9477);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e, "doOpenWebViewUseFastload", new Object[0]);
                hashMap.put("err_desc", e.toString());
                a(iVar, iVar.uIJ + ":fail", hashMap);
                AppMethodBeat.o(9477);
                return false;
            } catch (RemoteException e2) {
                ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "doOpenWebViewUseFastload", new Object[0]);
                hashMap.put("err_desc", e2.toString());
                a(iVar, iVar.uIJ + ":fail", hashMap);
                AppMethodBeat.o(9477);
                return false;
            }
        } else {
            hashMap.put("err_desc", "invalid openType");
            a(iVar, iVar.uIJ + ":fail", hashMap);
            AppMethodBeat.o(9477);
            return false;
        }
    }

    private static int parseColor(String str) {
        AppMethodBeat.i(9478);
        int parseColor = Color.parseColor(str) | WebView.NIGHT_MODE_COLOR;
        AppMethodBeat.o(9478);
        return parseColor;
    }

    private boolean cA(final i iVar) {
        AppMethodBeat.i(9479);
        final Map hashMap = new HashMap();
        try {
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.context);
            JSONObject jSONObject = iVar.uIH;
            if (jSONObject.has("title")) {
                aVar.asD(jSONObject.getString("title"));
            }
            if (jSONObject.has("titleDesc")) {
                aVar.aj(jSONObject.getString("titleDesc"));
            }
            if (jSONObject.has("titleColor")) {
                aVar.PW(parseColor(jSONObject.getString("titleColor")));
            }
            if (jSONObject.has("titleMaxLine")) {
                aVar.PX(jSONObject.getInt("titleMaxLine"));
            }
            if (jSONObject.has("titleGravity")) {
                aVar.PY(jSONObject.getInt("titleGravity"));
            }
            if (jSONObject.has("msg")) {
                aVar.asE(jSONObject.getString("msg"));
            }
            if (jSONObject.has("msgSubTitle")) {
                aVar.ak(jSONObject.getString("msgSubTitle"));
            }
            if (jSONObject.has("msgSubDesc")) {
                aVar.zQe.zPe = jSONObject.getString("msgSubDesc");
            }
            if (jSONObject.has("msgMaxLine")) {
                aVar.Qa(jSONObject.getInt("msgMaxLine"));
            }
            if (jSONObject.has("msgIconBase64")) {
                byte[] decode = Base64.decode(jSONObject.getString("msgIconBase64"), 0);
                aVar.ar(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            } else if (jSONObject.has("msgIconUrl")) {
                aVar.ar(Bitmap.createBitmap(1, 1, Config.ARGB_8888));
            }
            if (jSONObject.has("contentDesc")) {
                aVar.asG(jSONObject.getString("contentDesc"));
            }
            if (jSONObject.has("contentDescGravity")) {
                aVar.Qb(jSONObject.getInt("contentDescGravity"));
            }
            if (jSONObject.has("confirmText")) {
                aVar.asJ(jSONObject.getString("confirmText"));
            }
            if (jSONObject.has("confirmTextColor")) {
                aVar.Qe(parseColor(jSONObject.getString("confirmTextColor")));
            }
            if (jSONObject.has("cancelText")) {
                aVar.asK(jSONObject.getString("cancelText"));
            }
            if (jSONObject.has("cancelTextColor")) {
                aVar.Qf(parseColor(jSONObject.getString("cancelTextColor")));
            }
            aVar.f(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(9091);
                    g.a(g.this, iVar, iVar.uIJ + ":cancelled", hashMap);
                    AppMethodBeat.o(9091);
                }
            });
            aVar.a(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(9092);
                    g.a(g.this, iVar, iVar.uIJ + ":dismiss", hashMap);
                    AppMethodBeat.o(9092);
                }
            });
            aVar.a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9093);
                    g.a(g.this, iVar, iVar.uIJ + ":ok", hashMap);
                    AppMethodBeat.o(9093);
                }
            });
            aVar.b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9094);
                    g.a(g.this, iVar, iVar.uIJ + ":no", hashMap);
                    AppMethodBeat.o(9094);
                }
            });
            com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
            if (jSONObject.has("msgIconUrl")) {
                ImageView imageView = aMb.zPI;
                com.tencent.mm.at.a.a ahp = com.tencent.mm.at.o.ahp();
                String string = jSONObject.getString("msgIconUrl");
                com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePH = true;
                ahp.a(string, imageView, aVar2.ahG());
            }
            aMb.show();
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "doConfirmDialog", new Object[0]);
            a(iVar, iVar.uIJ + ":err", hashMap);
        }
        AppMethodBeat.o(9479);
        return true;
    }

    private boolean cB(i iVar) {
        AppMethodBeat.i(9480);
        LinkedList biz = ((com.tencent.mm.plugin.downloader_app.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).biz();
        if (bo.ek(biz)) {
            a(iVar, iVar.uIJ + ":ok", null);
            AppMethodBeat.o(9480);
        } else {
            Map hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray();
            Iterator it = biz.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader_app.a.b bVar = (com.tencent.mm.plugin.downloader_app.a.b) it.next();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appid", bVar.appId);
                    jSONObject.put("status", bVar.kOe);
                    jSONObject.put("download_id", bVar.crZ);
                    jSONObject.put("progress", bVar.progress);
                    if (bVar.kNu) {
                        jSONObject.put("reserve_for_wifi", 1);
                    }
                } catch (JSONException e) {
                }
                jSONArray.put(jSONObject);
            }
            hashMap.put("result", jSONArray);
            a(iVar, iVar.uIJ + ":ok", hashMap);
            AppMethodBeat.o(9480);
        }
        return true;
    }

    private boolean B(i iVar) {
        AppMethodBeat.i(9269);
        l.a(iVar.uII, agw("sendEmail"), null, null);
        String str = (String) iVar.puc.get("title");
        String str2 = "";
        try {
            str2 = ar.aek(this.umI.getCurrentUrl());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("composeType", 1);
        intent.putExtra("subject", str);
        intent.putExtra("mail_content", str2);
        com.tencent.mm.bp.d.c(this.context, "qqmail", ".ui.ComposeUI", intent);
        a(iVar, "send_email:ok", null);
        AppMethodBeat.o(9269);
        return true;
    }

    private static byte[] dcA() {
        AppMethodBeat.i(9277);
        try {
            com.tencent.mm.sdk.platformtools.i iVar = new com.tencent.mm.sdk.platformtools.i("softtype");
            ab.d("MicroMsg.AndroidDevicesReport", "cpu %s", bo.bc((String) com.tencent.mm.compatible.e.n.LA().get("Processor"), ""));
            iVar.cY("cpu", r0);
            iVar.cY(TencentLocationListener.RADIO, com.tencent.mm.compatible.e.q.LV());
            iVar.cY("osversion", VERSION.RELEASE);
            String deviceID = com.tencent.mm.compatible.e.q.getDeviceID(ah.getContext());
            String LX = com.tencent.mm.compatible.e.q.LX();
            String LY = com.tencent.mm.compatible.e.q.LY();
            iVar.cY("deviceId", deviceID);
            iVar.cY("imsi", LX);
            iVar.cY("iccid", LY);
            iVar.cY("androidid", com.tencent.mm.compatible.e.q.getAndroidId());
            iVar.cY("serial", com.tencent.mm.compatible.e.q.LZ());
            iVar.cY("model", com.tencent.mm.compatible.e.q.LS());
            iVar.cY("core_count", com.tencent.mm.compatible.e.n.getNumCores());
            iVar.cY("cpuhardware", bo.bc((String) com.tencent.mm.compatible.e.n.LF().get("Hardware"), ""));
            iVar.cY("cpureversion", bo.bc((String) com.tencent.mm.compatible.e.n.LF().get("CPU revision"), ""));
            iVar.cY("cpuserial", bo.bc((String) com.tencent.mm.compatible.e.n.LF().get("Serial"), ""));
            iVar.cY("Features", bo.bc((String) com.tencent.mm.compatible.e.n.LF().get("Features"), ""));
            iVar.cY("wifi-mac", bo.bc(com.tencent.mm.compatible.e.q.LP(), ""));
            iVar.cY("bluetooth", bo.bc(com.tencent.mm.compatible.e.q.LQ(), ""));
            if (!bo.isNullOrNil(iVar.xyh)) {
                iVar.Fj(iVar.xyh);
                iVar.xyh = "";
            }
            ab.d("MicroMsg.AndroidDevicesReport", "xmlStr %s", iVar.jvt.toString());
            ab.i("MicroMsg.MsgHandler", "xml %s", deviceID);
            ciw ciw = new ciw();
            ciw.xhL = com.tencent.mm.bt.b.bI(com.tencent.mm.compatible.e.q.LM().getBytes()).Lv(16);
            ab.i("MicroMsg.MsgHandler", bo.cd(ciw.xhL.wR));
            ciw.xhM = deviceID;
            SharedPreferences ZQ = com.tencent.mm.model.ax.ZQ();
            ab.i("MicroMsg.MsgHandler", "cpan aak string:%s md5:%s uin:%d", bo.cd(r2), com.tencent.mm.a.g.x(bo.anf(ZQ.getString("_auth_key", ""))), Integer.valueOf(ZQ.getInt("_auth_uin", 0)));
            ab.i("MicroMsg.MsgHandler", "aat len:%d", Integer.valueOf(r2.length));
            ciw.xhN = com.tencent.mm.bt.b.bI(r2);
            ciw.uin = r0;
            com.tencent.mm.protocal.z dmv = com.tencent.mm.protocal.z.dmv();
            byte[] toByteArray = ciw.toByteArray();
            PByteArray pByteArray = new PByteArray();
            if (MMProtocalJni.rsaPublicEncrypt(toByteArray, pByteArray, dmv.vyO.getBytes(), dmv.vyP.getBytes())) {
                toByteArray = pByteArray.value;
            }
            ab.d("MicroMsg.MsgHandler", "cpan buf string:%s ", bo.cd(toByteArray));
            cix cix = new cix();
            cix.xhP = dmv.ver;
            cix.xhO = com.tencent.mm.protocal.d.vxo;
            cix.xhQ = com.tencent.mm.protocal.d.eSg;
            cix.xhR = com.tencent.mm.bt.b.bI(toByteArray);
            ab.i("MicroMsg.MsgHandler", "getdevice done");
            toByteArray = cix.toByteArray();
            AppMethodBeat.o(9277);
            return toByteArray;
        } catch (Exception e) {
            ab.e("MicroMsg.MsgHandler", "report error");
            ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            AppMethodBeat.o(9277);
            return null;
        }
    }

    static /* synthetic */ boolean f(g gVar, i iVar) {
        AppMethodBeat.i(9488);
        ab.i("MicroMsg.MsgHandler", "doGoVideoPlayerUI");
        String str = (String) iVar.puc.get("streamingUrl");
        int i = (int) bo.getDouble((String) iVar.puc.get("streamingVideoTime"), 0.0d);
        String str2 = (String) iVar.puc.get("btnTitle");
        String str3 = (String) iVar.puc.get("jumpUrl");
        String str4 = (String) iVar.puc.get("shareTitle");
        String str5 = (String) iVar.puc.get("shareThumbUrl");
        int i2 = bo.getInt((String) iVar.puc.get("shareBtnHidden"), 0);
        String str6 = (String) iVar.puc.get("reportArgs");
        int i3 = bo.getInt((String) iVar.puc.get("needReportData"), 0);
        Intent intent = new Intent();
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", str);
        intent.putExtra("StreamWording", str2);
        intent.putExtra("StremWebUrl", str3);
        intent.putExtra("KThumUrl", str5);
        intent.putExtra("KMediaId", "fakeid_" + str5.hashCode());
        intent.putExtra("KMediaVideoTime", i);
        intent.putExtra("KMediaTitle", str4);
        intent.putExtra("ShareBtnHidden", i2);
        intent.putExtra("ReportArgs", str6);
        intent.putExtra("NeedReportData", i3);
        com.tencent.mm.bp.d.b(gVar.context, "sns", ".ui.VideoAdPlayerUI", intent);
        gVar.a(iVar, "playStreamingVideo:ok", null);
        AppMethodBeat.o(9488);
        return true;
    }

    static /* synthetic */ boolean g(g gVar, i iVar) {
        AppMethodBeat.i(9490);
        String obj = iVar.puc.get("widgetId").toString();
        String adC = ((com.tencent.mm.plugin.websearch.api.n) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.n.class)).adC(obj);
        Map hashMap = new HashMap();
        hashMap.put("widgetId", obj);
        hashMap.put("imgUrl", adC);
        gVar.a(iVar, String.format("%s:ok", new Object[]{iVar.uIJ}), hashMap);
        AppMethodBeat.o(9490);
        return false;
    }

    static /* synthetic */ boolean i(g gVar, i iVar) {
        AppMethodBeat.i(9492);
        ab.i("MicroMsg.MsgHandler", "jslog : " + iVar.puc.get("msg"));
        gVar.eBB = false;
        AppMethodBeat.o(9492);
        return false;
    }

    static /* synthetic */ boolean j(g gVar, i iVar) {
        AppMethodBeat.i(9495);
        if (at.isConnected(gVar.context)) {
            ab.i("MicroMsg.MsgHandler", "getNetworkType, type = ".concat(String.valueOf(at.getNetType(gVar.context))));
            Map hashMap = new HashMap();
            if (at.is2G(gVar.context)) {
                ab.i("MicroMsg.MsgHandler", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
                gVar.a(iVar, "network_type:wwan", hashMap);
                AppMethodBeat.o(9495);
            } else if (at.is3G(gVar.context)) {
                ab.i("MicroMsg.MsgHandler", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
                gVar.a(iVar, "network_type:wwan", hashMap);
                AppMethodBeat.o(9495);
            } else if (at.is4G(gVar.context)) {
                ab.i("MicroMsg.MsgHandler", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
                gVar.a(iVar, "network_type:wwan", hashMap);
                AppMethodBeat.o(9495);
            } else if (at.isWifi(gVar.context)) {
                ab.i("MicroMsg.MsgHandler", "getNetworkType, wifi");
                gVar.a(iVar, "network_type:wifi", null);
                AppMethodBeat.o(9495);
            } else {
                ab.w("MicroMsg.MsgHandler", "getNetworkType, unknown");
                gVar.a(iVar, "network_type:fail", null);
                AppMethodBeat.o(9495);
            }
        } else {
            ab.i("MicroMsg.MsgHandler", "getNetworkType, not connected");
            gVar.a(iVar, "network_type:fail", null);
            AppMethodBeat.o(9495);
        }
        return true;
    }

    static /* synthetic */ boolean o(g gVar, i iVar) {
        AppMethodBeat.i(9500);
        ab.i("MicroMsg.MsgHandler", "doJumpToInstallUrl");
        String str = (String) iVar.puc.get("url");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "jumpurl is null or nil");
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (bo.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
        }
        gVar.eBB = false;
        AppMethodBeat.o(9500);
        return false;
    }

    static /* synthetic */ boolean p(g gVar, i iVar) {
        String str;
        AppMethodBeat.i(9501);
        if (iVar.puc.get("pay_packageName") == null) {
            str = "";
        } else {
            str = (String) iVar.puc.get("pay_packageName");
        }
        String bc = bo.bc(str, "");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        ab.i("MicroMsg.MsgHandler", "doPay %s", bc);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            gVar2.vwu = 1;
            ab.i("MicroMsg.MsgHandler", "doPay, pay channel: %s, scene: %s", Integer.valueOf(gVar2.cvS), Integer.valueOf(gVar2.cIf));
            com.tencent.mm.pluginsdk.wallet.h.a((MMActivity) gVar.context, gVar2, 4, (com.tencent.mm.ui.MMActivity.a) gVar);
            long j = bo.getLong((String) iVar.puc.get("message_id"), 0);
            int i = bo.getInt((String) iVar.puc.get("message_index"), 0);
            h.pYm.e(10593, gVar2.cIe, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.cIf), gVar2.url);
            gVar.uGz = gVar.bc(iVar);
        }
        AppMethodBeat.o(9501);
        return true;
    }

    static /* synthetic */ boolean r(g gVar, i iVar) {
        AppMethodBeat.i(9503);
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        ab.i("MicroMsg.MsgHandler", "doEditAddress");
        Intent intent = new Intent();
        intent.putExtra("req_url", (String) iVar.puc.get("url"));
        intent.putExtra("req_app_id", (String) iVar.puc.get("appId"));
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "address", ".ui.WalletSelectAddrUI", intent, 3, false);
        }
        AppMethodBeat.o(9503);
        return true;
    }

    static /* synthetic */ boolean s(g gVar, i iVar) {
        AppMethodBeat.i(9505);
        Map hashMap = new HashMap();
        if (com.tencent.mm.pluginsdk.ui.tools.d.vup == null) {
            ab.w("MicroMsg.MsgHandler", "HeadingPitchSensorMgr.instance == null, init here");
            com.tencent.mm.pluginsdk.ui.tools.d dVar = new com.tencent.mm.pluginsdk.ui.tools.d();
            com.tencent.mm.pluginsdk.ui.tools.t.a(dVar);
            com.tencent.mm.pluginsdk.ui.tools.d.vup = dVar;
            dVar.fQ(gVar.context);
            com.tencent.mm.pluginsdk.ui.tools.d.vup = dVar;
        }
        hashMap.put("heading", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.d.vup.dlp()));
        hashMap.put("pitch", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.d.vup.getPitch()));
        ab.i("MicroMsg.MsgHandler", "doGetHeadingAndPitch, heading=[%s], pitch=[%s]", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.d.vup.dlp()), Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.d.vup.getPitch()));
        gVar.a(iVar, "get_heading_and_pitch:ok", hashMap);
        AppMethodBeat.o(9505);
        return true;
    }

    static /* synthetic */ boolean u(g gVar, i iVar) {
        AppMethodBeat.i(9507);
        if (com.tencent.mm.sdk.platformtools.g.dnY()) {
            ab.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, GP Version not allowed to download");
            gVar.a(iVar, "system:access_denied", null);
            AppMethodBeat.o(9507);
            return true;
        }
        String bK;
        String str = (String) iVar.puc.get("task_name");
        String str2 = (String) iVar.puc.get("task_url");
        String str3 = (String) iVar.puc.get("alternative_url");
        long j = bo.getLong((String) iVar.puc.get("task_size"), 0);
        String str4 = (String) iVar.puc.get("file_md5");
        String str5 = (String) iVar.puc.get(IssueStorage.COLUMN_EXT_INFO);
        String str6 = (String) iVar.puc.get("fileType");
        String str7 = (String) iVar.puc.get("appid");
        if (bo.isNullOrNil(str7)) {
            bK = gVar.bK((String) iVar.puc.get("url"));
        } else {
            bK = str7;
        }
        str7 = (String) iVar.puc.get("package_name");
        String str8 = (String) iVar.puc.get("thumb_url");
        String str9 = (String) iVar.puc.get("title");
        ab.i("MicroMsg.MsgHandler", "doAddDownloadTask, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6);
        if (gVar.uGh != null) {
            int i = gVar.uGh.getInt("key_download_restrict", 0);
            if (!bo.isNullOrNil(gVar.uGh.getString("key_function_id", ""))) {
                h.pYm.e(14596, r15, Integer.valueOf(i), Integer.valueOf(0));
            }
            if (i == 1) {
                ab.e("MicroMsg.MsgHandler", "not allow to download file");
                gVar.a(iVar, "add_download_task:fail", null);
                AppMethodBeat.o(9507);
                return true;
            }
        }
        if (!at.isNetworkConnected(gVar.context)) {
            gVar.a(iVar, "add_download_task:fail_network_not_connected", null);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9117);
                    Toast.makeText(g.this.context, g.this.context.getString(R.string.c5d), 0).show();
                    AppMethodBeat.o(9117);
                }
            });
            ab.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, network not ready");
            u(bK, com.tencent.mm.plugin.downloader.a.a.kJX, str5);
            AppMethodBeat.o(9507);
            return true;
        } else if (!com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            gVar.a(iVar, "add_download_task:fail_sdcard_not_ready", null);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9118);
                    Toast.makeText(g.this.context, g.this.context.getString(R.string.c5h), 0).show();
                    AppMethodBeat.o(9118);
                }
            });
            u(bK, com.tencent.mm.plugin.downloader.a.a.kJY, str5);
            ab.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, sdcard not ready");
            AppMethodBeat.o(9507);
            return true;
        } else if (j > 0 && !com.tencent.mm.compatible.util.f.eW(j)) {
            gVar.a(iVar, "add_download_task:fail_sdcard_has_not_enough_space", null);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9120);
                    Toast.makeText(g.this.context, g.this.context.getString(R.string.c5e), 0).show();
                    AppMethodBeat.o(9120);
                }
            });
            u(bK, com.tencent.mm.plugin.downloader.a.a.kJY, str5);
            ab.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, not enough space, require size = ".concat(String.valueOf(j)));
            AppMethodBeat.o(9507);
            return true;
        } else if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, url is null");
            gVar.a(iVar, "add_download_task:fail_invalid_url", null);
            u(bK, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, str5);
            AppMethodBeat.o(9507);
            return true;
        } else {
            Intent intent = new Intent();
            intent.setClass(gVar.context, WebViewDownloadUI.class);
            intent.putExtra("task_name", str);
            intent.putExtra("task_url", str2);
            intent.putExtra("alternative_url", str3);
            intent.putExtra("task_size", j);
            intent.putExtra("file_md5", str4);
            intent.putExtra(IssueStorage.COLUMN_EXT_INFO, str5);
            intent.putExtra("fileType", str6);
            intent.putExtra("appid", bK);
            intent.putExtra("package_name", str7);
            intent.putExtra("thumb_url", str8);
            intent.putExtra("title", str9);
            intent.putExtra("page_url", (String) iVar.puc.get("url"));
            intent.putExtra("page_scene", 0);
            intent.addFlags(268435456);
            gVar.context.startActivity(intent);
            final i iVar2 = iVar;
            gVar.hwv = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.h>() {
                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(9122);
                    com.tencent.mm.g.a.h hVar = (com.tencent.mm.g.a.h) bVar;
                    if (!(hVar instanceof com.tencent.mm.g.a.h)) {
                        ab.w("MicroMsg.MsgHandler", "mismatched event");
                        AppMethodBeat.o(9122);
                    } else if (hVar.crX.scene != 0) {
                        ab.i("MicroMsg.MsgHandler", "not jsapi api callback");
                        AppMethodBeat.o(9122);
                    } else if (hVar.crX.crY) {
                        ab.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
                        g.a(g.this, iVar2, "add_download_task:cancel", null);
                        AppMethodBeat.o(9122);
                    } else {
                        if (hVar.crX.crZ > 0) {
                            Map hashMap = new HashMap();
                            hashMap.put("download_id", Long.valueOf(hVar.crX.crZ));
                            ab.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
                            g.a(g.this, iVar2, "add_download_task:ok", hashMap);
                        } else {
                            ab.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
                            g.a(g.this, iVar2, "add_download_task:fail", null);
                        }
                        com.tencent.mm.sdk.b.a.xxA.d(g.this.hwv);
                        AppMethodBeat.o(9122);
                    }
                    return false;
                }
            };
            com.tencent.mm.sdk.b.a.xxA.b(gVar.hwv);
            AppMethodBeat.o(9507);
            return true;
        }
    }

    static /* synthetic */ boolean v(g gVar, i iVar) {
        AppMethodBeat.i(9508);
        long j = bo.getLong((String) iVar.puc.get("download_id"), -1);
        ab.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = ".concat(String.valueOf(j)));
        if (j <= 0) {
            ab.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = ".concat(String.valueOf(j)));
            gVar.a(iVar, "cancel_download_task:fail", null);
        } else {
            int hl = com.tencent.mm.plugin.downloader.model.d.bij().hl(j);
            ab.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = ".concat(String.valueOf(hl)));
            if (hl <= 0) {
                gVar.a(iVar, "cancel_download_task:fail", null);
            } else {
                gVar.a(iVar, "cancel_download_task:ok", null);
            }
        }
        AppMethodBeat.o(9508);
        return true;
    }

    static /* synthetic */ boolean w(g gVar, i iVar) {
        AppMethodBeat.i(9509);
        long j = bo.getLong((String) iVar.puc.get("download_id"), -1);
        ab.i("MicroMsg.MsgHandler", "doPauseDownloadTask, downloadId = ".concat(String.valueOf(j)));
        if (j <= 0) {
            ab.e("MicroMsg.MsgHandler", "doPauseDownloadTask fail, invalid downloadId = ".concat(String.valueOf(j)));
            gVar.a(iVar, "pause_download_task:fail", null);
        } else {
            com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
            if (hv != null && hv.field_downloadInWifi) {
                hv.field_downloadInWifi = false;
                com.tencent.mm.plugin.downloader.model.c.e(hv);
            }
            boolean hn = com.tencent.mm.plugin.downloader.model.d.bij().hn(j);
            ab.i("MicroMsg.MsgHandler", "doPauseDownloadTask, ret = ".concat(String.valueOf(hn)));
            if (hn) {
                gVar.a(iVar, "pause_download_task:ok", null);
            } else {
                gVar.a(iVar, "pause_download_task:fail", null);
            }
        }
        AppMethodBeat.o(9509);
        return true;
    }

    static /* synthetic */ boolean x(g gVar, final i iVar) {
        AppMethodBeat.i(9511);
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(9126);
                long j = bo.getLong((String) iVar.puc.get("download_id"), -1);
                String str = (String) iVar.puc.get("appid");
                String str2 = (String) iVar.puc.get("appIdArray");
                ab.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + j + ",appId = " + str + ",appIds = " + str2);
                if (bo.isNullOrNil(str2)) {
                    FileDownloadTaskInfo hm;
                    Object obj;
                    if (j > 0) {
                        hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(j);
                    } else if (bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + j + " or appid is null");
                        g.a(g.this, iVar, "query_download_task:fail", null);
                        AppMethodBeat.o(9126);
                        return;
                    } else {
                        hm = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
                    }
                    switch (hm.status) {
                        case -1:
                            ab.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
                            g.a(g.this, iVar, "query_download_task:fail_apilevel_too_low", null);
                            AppMethodBeat.o(9126);
                            return;
                        case 1:
                            obj = "downloading";
                            break;
                        case 2:
                            obj = "download_pause";
                            break;
                        case 3:
                            if (!com.tencent.mm.vfs.e.ct(hm.path)) {
                                obj = "default";
                                break;
                            } else {
                                obj = "download_succ";
                                break;
                            }
                        case 4:
                            obj = "download_fail";
                            break;
                        default:
                            obj = "default";
                            break;
                    }
                    ab.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = ".concat(String.valueOf(obj)));
                    Map hashMap = new HashMap();
                    hashMap.put("state", obj);
                    hashMap.put("download_id", Long.valueOf(hm.id));
                    if (hm.kNu) {
                        hashMap.put("reserve_for_wifi", Integer.valueOf(1));
                    }
                    if (hm.jrb != 0) {
                        long j2 = (hm.kNr * 100) / hm.jrb;
                        float f = (((float) hm.kNr) * 100.0f) / ((float) hm.jrb);
                        hashMap.put("progress", Long.valueOf(j2));
                        hashMap.put("progress_float", Float.valueOf(f));
                    }
                    g.a(g.this, iVar, "query_download_task:ok", hashMap);
                    AppMethodBeat.o(9126);
                    return;
                }
                g.a(g.this, str2, iVar);
                AppMethodBeat.o(9126);
            }
        });
        AppMethodBeat.o(9511);
        return true;
    }

    static /* synthetic */ boolean y(g gVar, final i iVar) {
        AppMethodBeat.i(9512);
        long j = bo.getLong((String) iVar.puc.get("download_id"), -1);
        bo.getInt((String) iVar.puc.get("scene"), 1000);
        ab.i("MicroMsg.MsgHandler", "doInstallDownloadTask, downloadId = ".concat(String.valueOf(j)));
        if (j <= 0) {
            ab.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid downloadId = ".concat(String.valueOf(j)));
            gVar.a(iVar, "install_download_task:fail", null);
            AppMethodBeat.o(9512);
        } else {
            com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
            if (hv == null) {
                ab.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, info is null");
                gVar.a(iVar, "install_download_task:fail", null);
                AppMethodBeat.o(9512);
            } else if (hv.field_status == -1) {
                ab.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, apilevel not supported");
                gVar.a(iVar, "install_download_task:fail_apilevel_too_low", null);
                AppMethodBeat.o(9512);
            } else if (hv.field_status != 3) {
                ab.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid status = " + hv.field_status);
                gVar.a(iVar, "install_download_task:fail", null);
                AppMethodBeat.o(9512);
            } else {
                com.tencent.mm.plugin.downloader.h.a.a(hv.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                    public final void dT(boolean z) {
                        AppMethodBeat.i(9127);
                        if (z) {
                            g.a(g.this, iVar, "install_download_task:ok", null);
                            AppMethodBeat.o(9127);
                            return;
                        }
                        g.a(g.this, iVar, "install_download_task:fail", null);
                        AppMethodBeat.o(9127);
                    }
                });
                AppMethodBeat.o(9512);
            }
        }
        return true;
    }

    static /* synthetic */ boolean z(g gVar, i iVar) {
        AppMethodBeat.i(9513);
        String str = (String) iVar.puc.get("specificview");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "doOpenSpecificView fail, invalid specificview");
            gVar.a(iVar, "specific_view:fail", null);
        } else {
            new Intent().addFlags(268435456);
            Bundle bundle = new Bundle();
            String str2 = (String) iVar.puc.get("url");
            String str3 = (String) iVar.puc.get(com.facebook.appevents.codeless.internal.Constants.EXTINFO);
            bundle.putInt("webview_scene", bo.getInt((String) iVar.puc.get("webview_scene"), 0));
            bundle.putString("url", str2);
            bundle.putString(com.facebook.appevents.codeless.internal.Constants.EXTINFO, str3);
            ab.i("MicroMsg.MsgHandler", "doOpenSpecificView, targetView = %s, ret = %b", str, Boolean.valueOf(com.tencent.mm.plugin.webview.a.a.gkE.b(gVar.context, str, bundle)));
            if (com.tencent.mm.plugin.webview.a.a.gkE.b(gVar.context, str, bundle)) {
                gVar.a(iVar, "specific_view:ok", null);
            } else {
                ab.e("MicroMsg.MsgHandler", "doOpenSpecificView, targetView not supported in current wechat version");
                gVar.a(iVar, "specific_view:not_supported", null);
            }
        }
        AppMethodBeat.o(9513);
        return true;
    }

    static /* synthetic */ boolean B(g gVar, i iVar) {
        AppMethodBeat.i(9515);
        ab.i("MicroMsg.MsgHandler", "doJumpToMall");
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("funcId");
        String str3 = (String) iVar.puc.get("url");
        l.a(iVar.uII, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str);
        intent.putExtra("key_func_id", str2);
        intent.putExtra("key_url", str3);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "mall", ".ui.MallIndexUI", intent, 5, false);
        }
        AppMethodBeat.o(9515);
        return true;
    }

    static /* synthetic */ boolean C(g gVar, i iVar) {
        AppMethodBeat.i(9516);
        String str = (String) iVar.puc.get(DownloadInfoColumns.PACKAGENAME);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "doWriteCommData fail, packageName is null");
        } else {
            int i;
            String str2 = (String) iVar.puc.get("data");
            boolean commit = gVar.context.getSharedPreferences(ah.getPackageName() + "_comm_preferences", 0).edit().putString(str, str2).commit();
            String str3 = "MicroMsg.MsgHandler";
            String str4 = "doWriteCommData, ret = %b, packageName = %s, data length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(commit);
            objArr[1] = str;
            if (str2 == null) {
                i = 0;
            } else {
                i = str2.length();
            }
            objArr[2] = Integer.valueOf(i);
            ab.i(str3, str4, objArr);
            if (commit) {
                gVar.a(iVar, "write_comm_data:ok", null);
                AppMethodBeat.o(9516);
                return true;
            }
        }
        gVar.a(iVar, "write_comm_data:fail", null);
        AppMethodBeat.o(9516);
        return true;
    }

    static /* synthetic */ boolean F(g gVar, i iVar) {
        AppMethodBeat.i(9519);
        ab.i("MicroMsg.MsgHandler", "doOpenProductViewWithPid");
        String str = (String) iVar.puc.get("pid");
        String str2 = (String) iVar.puc.get("url");
        Integer valueOf = Integer.valueOf(bo.getInt((String) iVar.puc.get("type"), 0));
        int i = bo.getInt((String) iVar.puc.get("view_type"), 0);
        String str3 = (String) iVar.puc.get("ext_info");
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_source_url", str2);
        boolean a = gVar.a(valueOf, 8, i, str3, intent);
        AppMethodBeat.o(9519);
        return a;
    }

    static /* synthetic */ boolean G(g gVar, i iVar) {
        AppMethodBeat.i(9520);
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        ab.i("MicroMsg.MsgHandler", "dogetBrandWCPayBindCardRequest JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            gVar2.cIg = 4;
            com.tencent.mm.pluginsdk.wallet.h.b((MMActivity) gVar.context, gVar2, 7, gVar);
        }
        AppMethodBeat.o(9520);
        return true;
    }

    static /* synthetic */ boolean H(g gVar, i iVar) {
        AppMethodBeat.i(9521);
        if (!gVar.uGm || com.tencent.mm.plugin.webview.modeltools.g.cYz().isAppActive) {
            ab.i("MicroMsg.MsgHandler", "location perm: %s", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.o(gVar.context, "android.permission.ACCESS_COARSE_LOCATION")));
            if (com.tencent.mm.pluginsdk.permission.b.o(gVar.context, "android.permission.ACCESS_COARSE_LOCATION")) {
                gVar.dcz();
                AppMethodBeat.o(9521);
            } else {
                WebViewStubTempUI.a(gVar.context, gVar.umI, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 75, gVar.cIv);
                gVar.a(iVar, "geo_location:fail_location_permission", null);
                AppMethodBeat.o(9521);
            }
        } else {
            gVar.a(iVar, "geo_location:fail_background", null);
            ab.i("MicroMsg.MsgHandler", "doGeoLocation fail inBackGround");
            AppMethodBeat.o(9521);
        }
        return true;
    }

    static /* synthetic */ boolean M(g gVar, i iVar) {
        AppMethodBeat.i(9526);
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        ab.i("MicroMsg.MsgHandler", "doOpenWXCredit JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            gVar2.cIg = 6;
            com.tencent.mm.pluginsdk.wallet.h.b((MMActivity) gVar.context, gVar2, 9, gVar);
        }
        AppMethodBeat.o(9526);
        return true;
    }

    static /* synthetic */ boolean N(g gVar, final i iVar) {
        AppMethodBeat.i(9527);
        if (gVar.uGh == null) {
            ab.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, jsapiArgs is null");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        } else if (gVar.uGh.getBoolean("isFromService", false)) {
            String string = gVar.uGh.getString("jsapi_args_appid");
            String string2 = gVar.uGh.getString("sendAppMsgToUserName");
            l.a(iVar.uII, false, null, string);
            gVar.cEl = g(iVar);
            if (gVar.cEl == null) {
                ab.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, appmsg is null");
                gVar.a(iVar, "send_service_app_msg:fail", null);
            } else {
                com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(string, true);
                if (bo.isNullOrNil(string2)) {
                    ab.e("MicroMsg.MsgHandler", "toUser is null");
                    gVar.a(iVar, "send_service_app_msg:fail", null);
                } else {
                    final String str = (String) iVar.puc.get("img_url");
                    h.pYm.e(10923, Integer.valueOf(13), bT.field_appId, Integer.valueOf(1));
                    if (bo.isNullOrNil(str)) {
                        gVar.a(bT, "", string2, str, null, null, null, null);
                        com.tencent.mm.ui.base.h.bQ(gVar.context, gVar.context.getString(R.string.td));
                        gVar.a(iVar, "send_service_app_msg:ok", null);
                        gVar.bb(iVar);
                    } else {
                        final com.tencent.mm.ui.base.p b = com.tencent.mm.ui.base.h.b(gVar.context, gVar.context.getResources().getString(R.string.th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(9057);
                                com.tencent.mm.at.o.ahk().rZ(str);
                                g.a(g.this, iVar, "send_service_app_msg:fail", null);
                                AppMethodBeat.o(9057);
                            }
                        });
                        final com.tencent.mm.pluginsdk.model.app.f fVar = bT;
                        final String str2 = string2;
                        final String str3 = str;
                        final i iVar2 = iVar;
                        com.tencent.mm.at.o.ahk().a(str, new com.tencent.mm.at.c.c() {
                            public final void C(Bitmap bitmap) {
                                AppMethodBeat.i(9058);
                                if (b != null) {
                                    b.dismiss();
                                }
                                g.a(g.this, fVar, "", str2, str3, null, null, null, null);
                                g.a(g.this, iVar2, "send_service_app_msg:ok", null);
                                g.ew(g.this, iVar2);
                                AppMethodBeat.o(9058);
                            }
                        });
                    }
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, not from service");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        }
        AppMethodBeat.o(9527);
        return true;
    }

    static /* synthetic */ boolean P(g gVar, i iVar) {
        String str;
        AppMethodBeat.i(9529);
        String str2 = (String) iVar.puc.get("title");
        String str3 = (String) iVar.puc.get("singer");
        String str4 = (String) iVar.puc.get("epname");
        String str5 = (String) iVar.puc.get("coverImgUrl");
        String str6 = (String) iVar.puc.get("dataUrl");
        String str7 = (String) iVar.puc.get("lowbandUrl");
        String str8 = (String) iVar.puc.get("webUrl");
        String str9 = (String) iVar.puc.get("appId");
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        l.a(iVar.uII, false, null, str9);
        ab.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", str2, str3, str4, str, str6, str7, str8, str9);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4) || bo.isNullOrNil(str) || bo.isNullOrNil(str7) || bo.isNullOrNil(str6) || bo.isNullOrNil(str8)) {
            gVar.a(iVar, "playMusic:fail", null);
        } else {
            com.tencent.mm.aw.a.aic();
            com.tencent.mm.aw.a.b(com.tencent.mm.aw.f.a(7, str, str2, str3, str8, str7, str6, str6.hashCode(), com.tencent.mm.compatible.util.e.eSn, com.tencent.mm.plugin.i.c.XW() + str.hashCode(), str4, str9));
            gVar.a(iVar, "playMusic:ok", null);
        }
        AppMethodBeat.o(9529);
        return true;
    }

    static /* synthetic */ boolean Q(g gVar, i iVar) {
        boolean z = false;
        AppMethodBeat.i(9530);
        final String str = (String) iVar.puc.get("ssid");
        final String str2 = (String) iVar.puc.get("password");
        ab.d("MicroMsg.MsgHandler", "doConnectToWifi, ssid : %s, password : %s, encryptType : %s, hidessid : %s", str, str2, (String) iVar.puc.get("type"), (String) iVar.puc.get("isHidden"));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "ssid is null");
            gVar.a(iVar, "connecttowifi:failed_ssid_invalid", null);
            AppMethodBeat.o(9530);
        } else {
            final int i = bo.getInt(r0, 0);
            if (i == 0 || !bo.isNullOrNil(str2)) {
                if (bo.getInt(r1, 0) == 1) {
                    z = true;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9136);
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_ssid", str);
                        intent.putExtra("free_wifi_source", 3);
                        intent.putExtra("free_wifi_passowrd", str2);
                        intent.putExtra("free_wifi_hide_ssid", z);
                        intent.putExtra("free_wifi_encrypt_type", i);
                        intent.addFlags(67108864);
                        com.tencent.mm.bp.d.b(g.this.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                        AppMethodBeat.o(9136);
                    }
                });
                gVar.a(iVar, "connecttowifi:ok", null);
                AppMethodBeat.o(9530);
            } else {
                ab.e("MicroMsg.MsgHandler", "encrypt type, while the password is null");
                gVar.a(iVar, "connecttowifi:failed_password_invalid", null);
                AppMethodBeat.o(9530);
            }
        }
        return true;
    }

    static /* synthetic */ boolean R(g gVar, i iVar) {
        AppMethodBeat.i(9531);
        ab.i("MicroMsg.MsgHandler", "doGetTransferMoneyRequest JSOAUTH");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            Intent intent = new Intent();
            intent.putExtra("scene", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.cId);
            intent.putExtra("url", gVar2.url);
            intent.putExtra("pay_channel", gVar2.cvS);
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.b(gVar.context, "remittance", ".ui.RemittanceAdapterUI", intent, 11);
        }
        AppMethodBeat.o(9531);
        return true;
    }

    static /* synthetic */ boolean S(g gVar, i iVar) {
        AppMethodBeat.i(9532);
        ab.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.cId);
            intent.putExtra("url", gVar2.url);
            intent.putExtra("pay_channel", gVar2.cvS);
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "wallet_index", ".ui.WalletOpenViewProxyUI", intent, 17, false);
        }
        AppMethodBeat.o(9532);
        return true;
    }

    static /* synthetic */ boolean T(g gVar, i iVar) {
        AppMethodBeat.i(9533);
        ab.i("MicroMsg.MsgHandler", "doChooseCard JSOAUTH");
        String str = (String) iVar.puc.get("app_id");
        int i = bo.getInt((String) iVar.puc.get("location_id"), 0);
        String str2 = (String) iVar.puc.get("sign_type");
        String str3 = (String) iVar.puc.get("card_sign");
        int i2 = bo.getInt((String) iVar.puc.get("time_stamp"), 0);
        String str4 = (String) iVar.puc.get("nonce_str");
        String str5 = (String) iVar.puc.get("card_id");
        String str6 = (String) iVar.puc.get("card_type");
        if ("INVOICE".equalsIgnoreCase(str6)) {
            gVar.a(iVar, "choose_card:fail", new HashMap());
            AppMethodBeat.o(9533);
            return false;
        }
        int i3 = bo.getInt((String) iVar.puc.get("can_multi_select"), 0);
        l.a(iVar.uII, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("shop_id", i);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i2);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("card_tp_id", str5);
        intent.putExtra("card_type", str6);
        intent.putExtra("can_multi_select", i3);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 13, false);
        }
        AppMethodBeat.o(9533);
        return true;
    }

    static /* synthetic */ boolean U(g gVar, i iVar) {
        AppMethodBeat.i(9534);
        ab.i("MicroMsg.MsgHandler", "doChooseInvoice JSOAUTH");
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("signType");
        String str3 = (String) iVar.puc.get("cardSign");
        int i = bo.getInt((String) iVar.puc.get(Param.TIMESTAMP), 0);
        String str4 = (String) iVar.puc.get("nonceStr");
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 36, false);
        }
        AppMethodBeat.o(9534);
        return true;
    }

    static /* synthetic */ boolean V(g gVar, i iVar) {
        AppMethodBeat.i(9535);
        String str = (String) iVar.puc.get("card_list");
        String str2 = (String) iVar.puc.get("src_username");
        String str3 = (String) iVar.puc.get("url");
        String str4 = (String) iVar.puc.get("tempalate_id");
        ab.i("MicroMsg.MsgHandler", "doBatchAddCard consumedCardId %s", (String) iVar.puc.get("consumedCardId"));
        ab.i("MicroMsg.MsgHandler", "doBatchAddCard %s", iVar.puc.toString());
        int i = bo.getInt((String) iVar.puc.get("webview_scene"), 0);
        int i2 = bo.getInt((String) iVar.puc.get("stastic_scene"), 0);
        if (i == 25) {
            i = 16;
        } else {
            i = 7;
        }
        ab.i("MicroMsg.MsgHandler", "doBatchAddCard src_username is %s, scene is %d, stasticScene is %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", str);
        intent.putExtra("key_from_scene", i);
        intent.putExtra("key_stastic_scene", i2);
        intent.putExtra("src_username", str2);
        intent.putExtra("js_url", str3);
        intent.putExtra("key_consumed_card_id", r4);
        intent.putExtra("key_template_id", str4);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "card", ".ui.CardAddEntranceUI", intent, 16, false);
        }
        AppMethodBeat.o(9535);
        return true;
    }

    static /* synthetic */ boolean aa(g gVar, i iVar) {
        AppMethodBeat.i(9540);
        String str = (String) iVar.puc.get("appId");
        final String str2 = (String) iVar.puc.get("localId");
        l.a(iVar.uII, false, null, str);
        ab.i("MicroMsg.MsgHandler", "doPlayVoice, appId : %s, localId : %s", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            gVar.a(iVar, "playVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
            if (aex != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9161);
                        fk fkVar = new fk();
                        fkVar.czf.op = 1;
                        fkVar.czf.fileName = aex.fileName;
                        fkVar.czf.com = true;
                        fkVar.czf.czi = new com.tencent.mm.ai.h.a() {
                            public final void EA() {
                                AppMethodBeat.i(9159);
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:ok");
                                    bundle.putString("localId", str2);
                                    g.this.umI.c(2002, bundle);
                                    AppMethodBeat.o(9159);
                                } catch (Exception e) {
                                    ab.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", e.getMessage());
                                    AppMethodBeat.o(9159);
                                }
                            }
                        };
                        fkVar.czf.czj = new com.tencent.mm.ai.h.b() {
                            public final void onError() {
                                AppMethodBeat.i(9160);
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:fail");
                                    bundle.putString("localId", str2);
                                    g.this.umI.c(2002, bundle);
                                    AppMethodBeat.o(9160);
                                } catch (Exception e) {
                                    ab.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", e.getMessage());
                                    AppMethodBeat.o(9160);
                                }
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.m(fkVar);
                        AppMethodBeat.o(9161);
                    }
                });
                gVar.a(iVar, "playVoice:ok", null);
            } else {
                gVar.a(iVar, "playVoice:fail_arguments error", null);
            }
        }
        AppMethodBeat.o(9540);
        return true;
    }

    static /* synthetic */ boolean ab(g gVar, i iVar) {
        AppMethodBeat.i(9541);
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("localId");
        l.a(iVar.uII, false, null, str);
        ab.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            gVar.a(iVar, "pauseVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
            if (aex != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9163);
                        fk fkVar = new fk();
                        fkVar.czf.op = 4;
                        fkVar.czf.fileName = aex.fileName;
                        com.tencent.mm.sdk.b.a.xxA.m(fkVar);
                        AppMethodBeat.o(9163);
                    }
                });
                gVar.a(iVar, "pauseVoice:ok", null);
            } else {
                gVar.a(iVar, "pauseVoice:fail_not playing", null);
            }
        }
        AppMethodBeat.o(9541);
        return true;
    }

    static /* synthetic */ boolean ac(g gVar, i iVar) {
        AppMethodBeat.i(9542);
        String str = (String) iVar.puc.get("appId");
        String str2 = (String) iVar.puc.get("localId");
        ab.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", str, str2);
        l.a(iVar.uII, false, null, str);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            gVar.a(iVar, "stopVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(str2);
            if (aex != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9162);
                        fk fkVar = new fk();
                        fkVar.czf.op = 2;
                        fkVar.czf.fileName = aex.fileName;
                        com.tencent.mm.sdk.b.a.xxA.m(fkVar);
                        AppMethodBeat.o(9162);
                    }
                });
                gVar.a(iVar, "stopVoice:ok", null);
            } else {
                gVar.a(iVar, "stopVoice:fail_not playing", null);
            }
        }
        AppMethodBeat.o(9542);
        return true;
    }

    static /* synthetic */ boolean aq(g gVar, i iVar) {
        AppMethodBeat.i(9556);
        if (gVar.context instanceof MMActivity) {
            String str = (String) iVar.puc.get("key");
            int i = bo.getInt((String) iVar.puc.get("procint"), 0);
            int i2 = bo.getInt((String) iVar.puc.get("dataint"), 0);
            Intent intent = new Intent();
            intent.putExtra("encryptKey", str);
            intent.putExtra("procInterval", i);
            intent.putExtra("dataInterval", i2);
            intent.putExtra("exdevice_airkiss_open_type", 1);
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.b(gVar.context, "exdevice", ".ui.ExdeviceConnectWifiUI", intent, 19);
        } else {
            gVar.a(iVar, "configWXDeviceWiFi:fail", null);
        }
        AppMethodBeat.o(9556);
        return true;
    }

    static /* synthetic */ boolean at(g gVar, i iVar) {
        AppMethodBeat.i(9559);
        ab.i("MicroMsg.MsgHandler", "doVerifyWCPayPassword JSOAUTH");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.cId);
            intent.putExtra("url", gVar2.url);
            intent.putExtra("scene", 1);
            intent.putExtra("pay_channel", gVar2.cvS);
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 20, false);
        }
        AppMethodBeat.o(9559);
        return true;
    }

    static /* synthetic */ boolean au(g gVar, i iVar) {
        AppMethodBeat.i(9563);
        ab.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView JSOAUTH");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.cId);
            intent.putExtra("url", gVar2.url);
            intent.putExtra("pay_channel", gVar2.cvS);
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "wallet_index", ".ui.WalletSendC2CMsgUI", intent, 18, false);
        }
        AppMethodBeat.o(9563);
        return true;
    }

    static /* synthetic */ boolean av(g gVar, i iVar) {
        AppMethodBeat.i(9564);
        ab.i("MicroMsg.MsgHandler", "doBatchViewCard JSOAUTH");
        String str = (String) iVar.puc.get("card_list");
        String str2 = (String) iVar.puc.get("tempalate_id");
        String str3 = (String) iVar.puc.get("appId");
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str3);
        intent.putExtra("card_list", str);
        intent.putExtra("key_template_id", str2);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "card", ".ui.CardViewEntranceUI", intent, 23, false);
        } else {
            ab.e("MicroMsg.MsgHandler", "doBatchViewCard invalid context");
            gVar.a(iVar, "batch_view_card:fail", null);
        }
        AppMethodBeat.o(9564);
        return true;
    }

    static /* synthetic */ boolean aw(g gVar, i iVar) {
        String str;
        AppMethodBeat.i(9565);
        Object obj = iVar.puc.get("type");
        if (obj == null) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = obj.toString();
        }
        ab.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, type is : %s", str);
        final String str2 = (String) iVar.puc.get("src_username");
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || str.equals("1") || str.equals("2")) {
            String str3;
            String str4 = (String) iVar.puc.get("apKey");
            ab.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, ap key is : %s", str4);
            if (bo.isNullOrNil(str4)) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && bo.isNullOrNil(str3)) {
                gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
                AppMethodBeat.o(9565);
            } else {
                final String str5 = (String) iVar.puc.get("sessionKey");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9168);
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_jsapi_param_type", str);
                        intent.putExtra("free_wifi_ap_key", str3);
                        intent.putExtra("free_wifi_jsapi_param_username", str2);
                        intent.putExtra("free_wifi_sessionkey", str5);
                        intent.putExtra("free_wifi_source", 4);
                        intent.addFlags(67108864);
                        if (!(bo.isNullOrNil(str) || !str.equalsIgnoreCase("2") || bo.isNullOrNil(str3))) {
                            Uri parse = Uri.parse(str3);
                            String host = parse.getHost();
                            String query = parse.getQuery();
                            if (!bo.isNullOrNil(host) && "connectToFreeWifi".equals(host) && !bo.isNullOrNil(query) && query.startsWith("apKey=")) {
                                host = parse.getQueryParameter("apKey");
                                ab.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", host);
                                query = parse.getQueryParameter("ticket");
                                if (!bo.isNullOrNil(host) && host.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                    intent.putExtra("free_wifi_schema_uri", parse.toString());
                                    intent.putExtra("free_wifi_ap_key", host);
                                    intent.putExtra("free_wifi_source", 5);
                                    intent.putExtra("free_wifi_threeone_startup_type", 4);
                                    if (!bo.isNullOrNil(query)) {
                                        intent.putExtra("free_wifi_schema_ticket", query);
                                    }
                                }
                            }
                        }
                        com.tencent.mm.bp.d.b(g.this.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                        AppMethodBeat.o(9168);
                    }
                });
                gVar.a(iVar, "connectToFreeWifi:ok", null);
                AppMethodBeat.o(9565);
            }
        } else {
            gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
            AppMethodBeat.o(9565);
        }
        return true;
    }

    static /* synthetic */ boolean aK(g gVar, i iVar) {
        AppMethodBeat.i(9579);
        String str = (String) iVar.puc.get("gameId");
        if (bo.isNullOrNil(str)) {
            str = (String) iVar.puc.get("appId");
        }
        ab.i("MicroMsg.MsgHandler", "openGameDetail, appid = %s", str);
        if (bo.isNullOrNil(str)) {
            gVar.a(iVar, "openGameDetail:fail", null);
            AppMethodBeat.o(9579);
        } else {
            gt gtVar = new gt();
            gtVar.cBv.appId = str;
            gtVar.cBv.scene = 5;
            gtVar.cBv.actionCode = 2;
            gtVar.cBv.context = gVar.context;
            com.tencent.mm.sdk.b.a.xxA.m(gtVar);
            gVar.a(iVar, "openGameDetail:ok", null);
            AppMethodBeat.o(9579);
        }
        return true;
    }

    static /* synthetic */ boolean aL(g gVar, i iVar) {
        AppMethodBeat.i(9580);
        int i = bo.getInt((String) iVar.puc.get("jumpView"), 0);
        int i2 = bo.getInt((String) iVar.puc.get("jumpType"), 0);
        String str = (String) iVar.puc.get(IssueStorage.COLUMN_EXT_INFO);
        lw lwVar = new lw();
        lwVar.cHK.cHL = i;
        lwVar.cHK.jumpType = i2;
        lwVar.cHK.extraInfo = str;
        lwVar.cHK.context = gVar.context;
        com.tencent.mm.sdk.b.a.xxA.m(lwVar);
        gVar.a(iVar, "gameCenterJump:ok", null);
        AppMethodBeat.o(9580);
        return true;
    }

    static /* synthetic */ boolean aM(g gVar, i iVar) {
        AppMethodBeat.i(9581);
        int i = bo.getInt((String) iVar.puc.get("downloaderType"), 0);
        String str = (String) iVar.puc.get("countryCode");
        int i2 = bo.getInt((String) iVar.puc.get("showAllLog"), 0);
        gv gvVar = new gv();
        gvVar.cBz.cBA = i;
        gvVar.cBz.cBB = i2;
        gvVar.cBz.countryCode = str;
        com.tencent.mm.sdk.b.a.xxA.m(gvVar);
        gVar.a(iVar, "setGameDebugConfig:ok", null);
        AppMethodBeat.o(9581);
        return true;
    }

    static /* synthetic */ boolean aO(g gVar, i iVar) {
        AppMethodBeat.i(9583);
        ab.i("MicroMsg.MsgHandler", "doGetRecevieBizHongBaoRequest");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.cId);
            intent.putExtra("url", gVar2.url);
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, 22);
        }
        AppMethodBeat.o(9583);
        return true;
    }

    static /* synthetic */ boolean aP(g gVar, i iVar) {
        AppMethodBeat.i(9584);
        ab.d("MicroMsg.MsgHandler", "doOpenMyDeviceProfile");
        if (gVar.context != null) {
            String str = (String) iVar.puc.get("deviceType");
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MsgHandler", "deviceType is null");
                gVar.a(iVar, "openMyDeviceProfile:fail_no deviceType", null);
            } else {
                String str2 = (String) iVar.puc.get("deviceId");
                if (bo.isNullOrNil(str2)) {
                    ab.e("MicroMsg.MsgHandler", "deviceId is null");
                    gVar.a(iVar, "openMyDeviceProfile:fail_no deviceId", null);
                } else {
                    Intent intent = new Intent();
                    if (!(gVar.context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("device_type", str);
                    intent.putExtra("device_id", str2);
                    com.tencent.mm.bp.d.b(gVar.context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent);
                    gVar.a(iVar, "openMyDeviceProfile:ok", null);
                }
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "context is null");
            gVar.a(iVar, "openMyDeviceProfile:fail", null);
        }
        AppMethodBeat.o(9584);
        return true;
    }

    static /* synthetic */ boolean aQ(g gVar, i iVar) {
        AppMethodBeat.i(9585);
        ab.i("MicroMsg.MsgHandler", "hy: doGetIbgPrepayRequest");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            gVar2.vwu = 2;
            com.tencent.mm.pluginsdk.wallet.h.a((MMActivity) gVar.context, gVar2, 27, (com.tencent.mm.ui.MMActivity.a) gVar);
            long j = bo.getLong((String) iVar.puc.get("message_id"), 0);
            int i = bo.getInt((String) iVar.puc.get("message_index"), 0);
            h.pYm.e(10593, gVar2.cIe, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.cIf), gVar2.url);
            gVar.uGz = gVar.bc(iVar);
        }
        AppMethodBeat.o(9585);
        return true;
    }

    static /* synthetic */ boolean aR(g gVar, i iVar) {
        AppMethodBeat.i(9586);
        ab.i("MicroMsg.MsgHandler", "hy: doGetIbgTransactionRequest");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
            gVar.uGy = bo.getInt((String) iVar.puc.get("closeWebAfterPayDetailBack"), 0);
            ab.i("MicroMsg.MsgHandler", "close window: %s", Integer.valueOf(gVar.uGy));
            Context context;
            if (gVar2.foo == 2) {
                com.tencent.mm.sdk.b.a.xxA.c(gVar.uGQ);
                if (gVar2.vws == 1) {
                    ab.i("MicroMsg.MsgHandler", "businessScene: %d", Integer.valueOf(gVar2.foo));
                    up upVar = new up();
                    upVar.cQN.appId = gVar2.appId;
                    upVar.cQN.timeStamp = gVar2.timeStamp;
                    upVar.cQN.nonceStr = gVar2.nonceStr;
                    upVar.cQN.packageExt = gVar2.packageExt;
                    upVar.cQN.czZ = gVar2.czZ;
                    upVar.cQN.cQO = gVar2.vws;
                    upVar.cQN.signType = gVar2.signType;
                    upVar.cQN.cQF = gVar2.cId;
                    com.tencent.mm.sdk.b.a.xxA.m(upVar);
                } else if (gVar2.vws == 2) {
                    context = (MMActivity) gVar.context;
                    Intent intent = new Intent();
                    intent.putExtra("appId", gVar2.appId);
                    intent.putExtra("timeStamp", gVar2.timeStamp);
                    intent.putExtra("nonceStr", gVar2.nonceStr);
                    intent.putExtra("packageExt", gVar2.packageExt);
                    intent.putExtra("reqKey", gVar2.czZ);
                    intent.putExtra("signtype", gVar2.signType);
                    intent.putExtra("paySignature", gVar2.cId);
                    intent.putExtra("payScene", gVar2.vws);
                    intent.putExtra("is_jsapi_offline_pay", true);
                    com.tencent.mm.bp.d.c(context, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                }
            } else {
                context = (MMActivity) gVar.context;
                Intent intent2 = new Intent();
                intent2.putExtra("appId", gVar2.appId);
                intent2.putExtra("timeStamp", gVar2.timeStamp);
                intent2.putExtra("nonceStr", gVar2.nonceStr);
                intent2.putExtra("packageExt", gVar2.packageExt);
                intent2.putExtra("signtype", gVar2.signType);
                intent2.putExtra("paySignature", gVar2.cId);
                intent2.putExtra("url", gVar2.url);
                context.ifE = gVar;
                ab.i("MicroMsg.WalletManager", "startIbgOrderResult context %s from %s", context, bo.dpG());
                com.tencent.mm.bp.d.a(context, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent2, 25, true);
            }
            long j = bo.getLong((String) iVar.puc.get("message_id"), 0);
            int i = bo.getInt((String) iVar.puc.get("message_index"), 0);
            h.pYm.e(10593, gVar2.cIe, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.cIf), gVar2.url);
        }
        AppMethodBeat.o(9586);
        return true;
    }

    static /* synthetic */ boolean aS(g gVar, i iVar) {
        AppMethodBeat.i(9587);
        ab.i("MicroMsg.MsgHandler", "doJumpToWXWallet");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        if (gVar.context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("key_wallet_region", 1);
            com.tencent.mm.bp.d.c(gVar.context, "mall", ".ui.MallIndexUI", intent);
            gVar.a(iVar, "jump_to_wx_wallet:ok", null);
        }
        AppMethodBeat.o(9587);
        return true;
    }

    static /* synthetic */ boolean aT(g gVar, i iVar) {
        AppMethodBeat.i(9588);
        ab.i("MicroMsg.MsgHandler", "doScanCover");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 2);
        if (com.tencent.mm.r.a.bI(gVar.context) || com.tencent.mm.bg.e.akI()) {
            ab.i("MicroMsg.MsgHandler", "VoipOutOfPackageUtil.checkCameraUsingAndShowToast fail");
            gVar.a(iVar, "scanCover:fail", null);
        } else {
            com.tencent.mm.bp.d.c(gVar.context, "scanner", ".ui.SingleTopScanUI", intent);
            gVar.a(iVar, "sacnCover:ok", null);
        }
        AppMethodBeat.o(9588);
        return true;
    }

    static /* synthetic */ boolean aU(g gVar, i iVar) {
        AppMethodBeat.i(9589);
        if (gVar.f("nfcIsConnect", (int) WearableStatusCodes.DUPLICATE_LISTENER, new Bundle())) {
            gVar.a(iVar, "nfcIsConnect:connect", null);
        }
        AppMethodBeat.o(9589);
        return true;
    }

    static /* synthetic */ boolean aV(g gVar, i iVar) {
        AppMethodBeat.i(9590);
        if (gVar.f("nfcConnect", (int) WearableStatusCodes.UNKNOWN_LISTENER, new Bundle())) {
            gVar.a(iVar, "nfcConnect:connect", null);
        }
        AppMethodBeat.o(9590);
        return true;
    }

    static /* synthetic */ boolean aW(g gVar, i iVar) {
        AppMethodBeat.i(9591);
        if (gVar.f("nfcTransceive", (int) WearableStatusCodes.UNKNOWN_LISTENER, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdu", (String) iVar.puc.get("apdu"));
            Bundle e = gVar.e("nfcTransceive", (int) WearableStatusCodes.DATA_ITEM_TOO_LARGE, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                ab.i("MicroMsg.MsgHandler", "[NFC] nfcTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcTransceive:ok", hashMap);
            } else {
                ab.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcTransceive:fail", null);
            }
        }
        AppMethodBeat.o(9591);
        return true;
    }

    static /* synthetic */ boolean aX(g gVar, i iVar) {
        AppMethodBeat.i(9592);
        if (gVar.f("nfcBatchTransceive", (int) WearableStatusCodes.UNKNOWN_LISTENER, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdus", (String) iVar.puc.get("apdus"));
            bundle.putBoolean("breakIfFail", bo.getInt((String) iVar.puc.get("breakIfFail"), 1) == 1);
            Bundle e = gVar.e("nfcBatchTransceive", (int) WearableStatusCodes.INVALID_TARGET_NODE, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                ab.i("MicroMsg.MsgHandler", "[NFC] nfcBatchTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcBatchTransceive:ok", hashMap);
            } else {
                ab.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcBatchTransceive:fail", null);
            }
        }
        AppMethodBeat.o(9592);
        return true;
    }

    static /* synthetic */ boolean aY(g gVar, i iVar) {
        AppMethodBeat.i(9593);
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetId", (int) WearableStatusCodes.UNKNOWN_LISTENER, bundle)) {
            bundle = gVar.e("nfcGetId", (int) WearableStatusCodes.ASSET_UNAVAILABLE, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("id", bundle.getString("id"));
                ab.i("MicroMsg.MsgHandler", "[NFC] nfcGetId result : " + bundle.getString("id"));
                gVar.a(iVar, "nfcGetId:ok", hashMap);
            } else {
                ab.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcGetId:fail", null);
            }
        }
        AppMethodBeat.o(9593);
        return true;
    }

    static /* synthetic */ boolean aZ(g gVar, i iVar) {
        AppMethodBeat.i(9594);
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetInfo", (int) WearableStatusCodes.UNKNOWN_LISTENER, bundle)) {
            bundle = gVar.e("nfcGetInfo", (int) WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("info", bundle.getString("info"));
                gVar.a(iVar, "nfcGetInfo:ok", hashMap);
            } else {
                ab.w("MicroMsg.MsgHandler", "[NFC] nfcGetInfo callback fail!");
                gVar.a(iVar, "nfcGetInfo:fail", null);
            }
        }
        AppMethodBeat.o(9594);
        return true;
    }

    static /* synthetic */ boolean ba(g gVar, final i iVar) {
        int i = 0;
        AppMethodBeat.i(9595);
        int i2 = bo.getInt((String) iVar.puc.get("isShowNfcSwitchGuide"), 1) == 1 ? 1 : 0;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(gVar.context);
        if (defaultAdapter == null) {
            gVar.a(iVar, "nfcCheckState:nfc_not_support", null);
        } else {
            int intValue = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            int intValue2 = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            if (intValue == 2 || (intValue == 0 && intValue2 != 1)) {
                i = 1;
            }
            if (i != 0) {
                if (i2 == 0) {
                    gVar.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                } else {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(9179);
                            com.tencent.mm.ui.base.h.d(g.this.context, g.this.context.getString(R.string.d6s), "", g.this.context.getString(R.string.d6x), g.this.context.getString(R.string.or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(9177);
                                    com.tencent.mm.bp.d.H(g.this.context, "setting", ".ui.setting.SettingsAboutSystemUI");
                                    g.a(g.this, iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                    AppMethodBeat.o(9177);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(9178);
                                    g.a(g.this, iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                    AppMethodBeat.o(9178);
                                }
                            });
                            AppMethodBeat.o(9179);
                        }
                    });
                }
            } else if (defaultAdapter.isEnabled()) {
                gVar.a(iVar, "nfcCheckState:nfc_ok", null);
            } else if (i2 == 0) {
                gVar.a(iVar, "nfcCheckState:nfc_off", null);
            } else {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9182);
                        com.tencent.mm.ui.base.h.d(g.this.context, g.this.context.getString(R.string.d6w), "", g.this.context.getString(R.string.d6x), g.this.context.getString(R.string.or), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(9180);
                                g.this.context.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                                g.a(g.this, iVar, "nfcCheckState:nfc_off", null);
                                AppMethodBeat.o(9180);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(9181);
                                g.a(g.this, iVar, "nfcCheckState:nfc_off", null);
                                AppMethodBeat.o(9181);
                            }
                        });
                        AppMethodBeat.o(9182);
                    }
                });
            }
        }
        AppMethodBeat.o(9595);
        return true;
    }

    static /* synthetic */ boolean bh(g gVar, i iVar) {
        AppMethodBeat.i(9602);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.fts.g cYD = com.tencent.mm.plugin.webview.modeltools.g.cYD();
        Map map = iVar.puc;
        int g = bo.g(map.get("webview_instance_id"), -1);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "searchId");
        String t2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "poiId");
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        bvp bvp = new bvp();
        bvp.wWD = t2;
        bvp.vQg = t;
        aVar.fsJ = bvp;
        aVar.fsK = new bvq();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchpoi";
        aVar.fsI = 2608;
        w.a(aVar.acD(), new com.tencent.mm.plugin.webview.fts.g.AnonymousClass3(g, t, t2));
        AppMethodBeat.o(9602);
        return false;
    }

    static /* synthetic */ boolean bi(g gVar, i iVar) {
        AppMethodBeat.i(9603);
        gVar.eBB = false;
        if (bo.ank((String) iVar.puc.get("isSearch")) == 1) {
            boolean lM = com.tencent.mm.plugin.websearch.api.aa.lM(bo.anl((String) iVar.puc.get("reddotTimeStamps")));
            AppMethodBeat.o(9603);
            return lM;
        }
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().lC(bo.anl((String) iVar.puc.get("reddotTimeStamps")));
        AppMethodBeat.o(9603);
        return false;
    }

    static /* synthetic */ boolean bn(g gVar, i iVar) {
        AppMethodBeat.i(9608);
        gVar.eBB = false;
        boolean aw = com.tencent.mm.plugin.webview.modeltools.g.cYC().aw(iVar.puc);
        AppMethodBeat.o(9608);
        return aw;
    }

    static /* synthetic */ boolean bo(g gVar, i iVar) {
        AppMethodBeat.i(9609);
        gVar.eBB = false;
        boolean ax = com.tencent.mm.plugin.webview.modeltools.g.cYC().ax(iVar.puc);
        AppMethodBeat.o(9609);
        return ax;
    }

    static /* synthetic */ boolean bp(g gVar, i iVar) {
        AppMethodBeat.i(9610);
        gVar.eBB = false;
        boolean as = com.tencent.mm.plugin.webview.modeltools.g.cYB().as(iVar.puc);
        AppMethodBeat.o(9610);
        return as;
    }

    static /* synthetic */ boolean bq(g gVar, i iVar) {
        AppMethodBeat.i(9611);
        gVar.eBB = false;
        boolean at = com.tencent.mm.plugin.webview.modeltools.g.cYB().at(iVar.puc);
        AppMethodBeat.o(9611);
        return at;
    }

    static /* synthetic */ boolean br(g gVar, i iVar) {
        AppMethodBeat.i(9612);
        gVar.eBB = false;
        boolean au = com.tencent.mm.plugin.webview.modeltools.g.cYB().au(iVar.puc);
        AppMethodBeat.o(9612);
        return au;
    }

    static /* synthetic */ boolean bt(g gVar, i iVar) {
        AppMethodBeat.i(9614);
        gVar.eBB = false;
        boolean a = com.tencent.mm.plugin.webview.modeltools.g.cYC().a(iVar.puc, gVar, "");
        AppMethodBeat.o(9614);
        return a;
    }

    static /* synthetic */ boolean bu(g gVar, i iVar) {
        AppMethodBeat.i(9615);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.modeltools.g.cYC();
        Map map = iVar.puc;
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics: %s", map.toString());
        int d = com.tencent.mm.plugin.websearch.api.aa.d(map, "logId", 0);
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics reporting %d, logString %s", Integer.valueOf(d), com.tencent.mm.plugin.websearch.api.aa.t(map, "logString"));
        an.by(d, r0);
        AppMethodBeat.o(9615);
        return false;
    }

    static /* synthetic */ boolean bv(g gVar, i iVar) {
        AppMethodBeat.i(9616);
        gVar.eBB = false;
        boolean ay = com.tencent.mm.plugin.webview.modeltools.g.cYC().ay(iVar.puc);
        AppMethodBeat.o(9616);
        return ay;
    }

    static /* synthetic */ boolean bw(g gVar, i iVar) {
        AppMethodBeat.i(9617);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.fts.b cYC = com.tencent.mm.plugin.webview.modeltools.g.cYC();
        Map map = iVar.puc;
        boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "hasResult");
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, SearchIntents.EXTRA_QUERY);
        int d = com.tencent.mm.plugin.websearch.api.aa.d(map, "type", 0);
        int d2 = com.tencent.mm.plugin.websearch.api.aa.d(map, "scene", 0);
        ab.d("MicroMsg.FTS.FTSWebViewLogic", "searchDataHashResult %b %s %d", Boolean.valueOf(u), t, Integer.valueOf(d));
        com.tencent.mm.plugin.webview.fts.b.e eVar = cYC.ufm;
        if (eVar.scene == d2 && eVar.query != null && eVar.query.equals(t) && eVar.mFl == d) {
            eVar.ctn = u;
        } else {
            ab.w("MicroMsg.FTS.FTSWebViewLogic", "setHasResultNotSame: %s VS %s | %d VS %d | %d VS %d", eVar.query, t, Integer.valueOf(eVar.mFl), Integer.valueOf(d), Integer.valueOf(eVar.scene), Integer.valueOf(d2));
        }
        AppMethodBeat.o(9617);
        return false;
    }

    static /* synthetic */ boolean bx(g gVar, i iVar) {
        AppMethodBeat.i(9618);
        gVar.eBB = false;
        boolean aG = com.tencent.mm.plugin.webview.modeltools.g.cYD().aG(iVar.puc);
        AppMethodBeat.o(9618);
        return aG;
    }

    static /* synthetic */ boolean by(g gVar, i iVar) {
        boolean z = true;
        AppMethodBeat.i(9619);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.modeltools.g.cYC();
        Map map = iVar.puc;
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "openEmotionPage %s", map);
        int d = com.tencent.mm.plugin.websearch.api.aa.d(map, "type", 0);
        int d2 = com.tencent.mm.plugin.websearch.api.aa.d(map, "scene", 0);
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "searchId");
        String t2 = com.tencent.mm.plugin.websearch.api.aa.t(map, "activityId");
        String str = "";
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("extra_scence", d2);
        intent.putExtra("extra_type", d);
        intent.putExtra("searchID", t);
        intent.putExtra("docID", com.tencent.mm.plugin.websearch.api.aa.t(map, "docID"));
        intent.putExtra("activityId", t2);
        switch (d) {
            case 1:
                intent.putExtra("extra_id", com.tencent.mm.plugin.websearch.api.aa.t(map, "productID"));
                intent.putExtra("preceding_scence", 18);
                intent.putExtra("download_entrance_scene", 27);
                intent.putExtra("searchID", bo.getLong(t, 0));
                str = ".ui.EmojiStoreDetailUI";
                break;
            case 2:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.websearch.api.aa.t(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.websearch.api.aa.t(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "thumb"));
                intent.putExtra("id", com.tencent.mm.plugin.websearch.api.aa.t(map, "designerId"));
                intent.putExtra("extra_product_id", com.tencent.mm.plugin.websearch.api.aa.t(map, "productID"));
                intent.putExtra("productUrl", com.tencent.mm.plugin.websearch.api.aa.t(map, "productUrl"));
                intent.putExtra("extra_product_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "productName"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.websearch.api.aa.d(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.websearch.api.aa.d(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 3:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.websearch.api.aa.t(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.websearch.api.aa.t(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "thumb"));
                intent.putExtra("id", com.tencent.mm.plugin.websearch.api.aa.t(map, "designerId"));
                intent.putExtra("name", com.tencent.mm.plugin.websearch.api.aa.t(map, "designerName"));
                intent.putExtra("headurl", com.tencent.mm.plugin.websearch.api.aa.t(map, "designerThumb"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.websearch.api.aa.d(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.websearch.api.aa.d(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 4:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "express"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "thumb"));
                intent.putExtra("extra_article_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "sourceTitle"));
                intent.putExtra("extra_article_url", com.tencent.mm.plugin.websearch.api.aa.t(map, "articleSource"));
                intent.putExtra("disableAddSticker", com.tencent.mm.plugin.websearch.api.aa.d(map, "disableAddSticker", 0) > 0);
                str = "needSavePhotosAlbum";
                if (com.tencent.mm.plugin.websearch.api.aa.d(map, "needSavePhotosAlbum", 0) <= 0) {
                    z = false;
                }
                intent.putExtra(str, z);
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.websearch.api.aa.t(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.websearch.api.aa.d(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.websearch.api.aa.d(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
        }
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.bp.d.b(ah.getContext(), "emoji", str, intent);
        }
        AppMethodBeat.o(9619);
        return false;
    }

    static /* synthetic */ boolean bz(g gVar, i iVar) {
        AppMethodBeat.i(9620);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.modeltools.g.cYC();
        boolean aB = com.tencent.mm.plugin.webview.fts.b.aB(iVar.puc);
        AppMethodBeat.o(9620);
        return aB;
    }

    static /* synthetic */ boolean bC(g gVar, i iVar) {
        AppMethodBeat.i(9623);
        gVar.eBB = false;
        boolean av = com.tencent.mm.plugin.webview.modeltools.g.cYC().av(iVar.puc);
        AppMethodBeat.o(9623);
        return av;
    }

    static /* synthetic */ boolean bD(g gVar, i iVar) {
        AppMethodBeat.i(9624);
        int i = bo.getInt((String) iVar.puc.get("cmd"), 0);
        String str = (String) iVar.puc.get("param");
        gx gxVar = new gx();
        gxVar.cBD.Cn = i;
        gxVar.cBD.cBy = str;
        com.tencent.mm.sdk.b.a.xxA.m(gxVar);
        Map hashMap = new HashMap();
        hashMap.put("result", gxVar.cBE.cBF);
        gVar.a(iVar, "getGameMessages:ok", hashMap);
        AppMethodBeat.o(9624);
        return true;
    }

    static /* synthetic */ boolean bE(g gVar, i iVar) {
        AppMethodBeat.i(9625);
        ab.i("MicroMsg.MsgHandler", "doGetWebPayCheckoutCounterRequst start");
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.cId);
        intent.putExtra("url", gVar2.url);
        intent.putExtra("pay_channel", gVar2.cvS);
        ((MMActivity) gVar.context).ifE = gVar;
        com.tencent.mm.bp.d.a(gVar.context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, 28, false);
        AppMethodBeat.o(9625);
        return true;
    }

    static /* synthetic */ boolean bF(g gVar, i iVar) {
        AppMethodBeat.i(9626);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.fts.b cYC = com.tencent.mm.plugin.webview.modeltools.g.cYC();
        Map map = iVar.puc;
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "setSnsObjectDescList");
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "data");
        boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "append");
        com.tencent.mm.plugin.webview.fts.b.a aVar = new com.tencent.mm.plugin.webview.fts.b.a(cYC, (byte) 0);
        aVar.data = t;
        aVar.ufy = u;
        com.tencent.mm.sdk.g.d.post(aVar, "append_music_list_task");
        AppMethodBeat.o(9626);
        return false;
    }

    static /* synthetic */ boolean bG(g gVar, i iVar) {
        AppMethodBeat.i(9627);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.fts.b cYC = com.tencent.mm.plugin.webview.modeltools.g.cYC();
        Map map = iVar.puc;
        ab.i("MicroMsg.FTS.FTSWebViewLogic", "clickSnsMusicPlayButton %s", map.toString());
        boolean u = com.tencent.mm.plugin.websearch.api.aa.u(map, "isLoop");
        boolean u2 = com.tencent.mm.plugin.websearch.api.aa.u(map, "needStartMusicUI");
        String t = com.tencent.mm.plugin.websearch.api.aa.t(map, "snsid");
        int g = bo.g(map.get("webview_instance_id"), -1);
        if (com.tencent.mm.aw.a.aie()) {
            com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
            if (aih.fJS == 9 && aih.fJU.equals(t)) {
                com.tencent.mm.aw.a.aic();
                if (!u2) {
                    AppMethodBeat.o(9627);
                    return false;
                }
            }
        }
        if (u2 && cYC.ufn != null) {
            al.d(new com.tencent.mm.aw.a.AnonymousClass9(cYC.ufn));
        }
        TimeLineObject tC = ((com.tencent.mm.plugin.sns.b.m) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.m.class)).tC(com.tencent.mm.plugin.websearch.api.aa.t(map, "objectXmlDesc"));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.aw.e a = com.tencent.mm.aw.g.a(com.tencent.mm.kernel.g.RP().eJM, tC, 9);
        a.fKp = u;
        com.tencent.mm.aw.a.a(a);
        if (u2) {
            Intent intent = new Intent();
            intent.putExtra("key_scene", 4);
            intent.setFlags(268435456);
            com.tencent.mm.bp.d.b(ah.getContext(), "music", ".ui.MusicMainUI", intent);
        }
        cYC.ufg.add(Integer.valueOf(g));
        AppMethodBeat.o(9627);
        return false;
    }

    static /* synthetic */ boolean bP(g gVar, i iVar) {
        AppMethodBeat.i(9636);
        gVar.eBB = false;
        String str = (String) iVar.puc.get("brandUsername");
        Intent cVd = com.tencent.mm.plugin.websearch.api.aa.cVd();
        cVd.putExtra("ftsneedkeyboard", true);
        cVd.putExtra("ftsbizscene", 19);
        cVd.putExtra("ftsType", 2);
        Map d = com.tencent.mm.plugin.websearch.api.aa.d(19, true, 2);
        d.put("userName", str);
        cVd.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.aa.E(d));
        cVd.putExtra("key_load_js_without_delay", true);
        cVd.putExtra("ftsbizusername", str);
        com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd);
        AppMethodBeat.o(9636);
        return false;
    }

    static /* synthetic */ boolean bR(g gVar, i iVar) {
        AppMethodBeat.i(9638);
        com.tencent.mm.plugin.webview.modelcache.c.cYl();
        gVar.a(iVar, "publicCache:not in white list", null);
        AppMethodBeat.o(9638);
        return true;
    }

    static /* synthetic */ boolean bT(g gVar, final i iVar) {
        AppMethodBeat.i(9640);
        final String str = (String) iVar.puc.get("cardType");
        if (bo.isNullOrNil(str) || gVar.context == null) {
            gVar.a(iVar, "scanLicence:fail", null);
            AppMethodBeat.o(9640);
        } else {
            if (gVar.uGu.a(str, gVar.context, new com.tencent.mm.plugin.webview.modeltools.e.a() {
                public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                    AppMethodBeat.i(9098);
                    if (!bo.nullAsNil(str).equalsIgnoreCase(str)) {
                        ab.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", str, str);
                        AppMethodBeat.o(9098);
                    } else if (jSONObject == null) {
                        ab.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", str);
                        BD(str);
                        AppMethodBeat.o(9098);
                    } else {
                        Map hashMap = new HashMap(2);
                        hashMap.put("cardType", str);
                        hashMap.put("cardInfo", jSONObject);
                        g.a(g.this, iVar, "scanLicence:ok", hashMap);
                        AppMethodBeat.o(9098);
                    }
                }

                public final void aeT(String str) {
                    AppMethodBeat.i(9099);
                    if (bo.nullAsNil(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        g.a(g.this, iVar, "scanLicence:cancel", hashMap);
                        AppMethodBeat.o(9099);
                        return;
                    }
                    AppMethodBeat.o(9099);
                }

                public final void BD(String str) {
                    AppMethodBeat.i(9100);
                    if (bo.nullAsNil(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        g.a(g.this, iVar, "scanLicence:fail", hashMap);
                        AppMethodBeat.o(9100);
                        return;
                    }
                    AppMethodBeat.o(9100);
                }
            })) {
                AppMethodBeat.o(9640);
            } else {
                Map hashMap = new HashMap(1);
                hashMap.put("cardType", str);
                gVar.a(iVar, "scanLicence:type not supported", hashMap);
                AppMethodBeat.o(9640);
            }
        }
        return true;
    }

    static /* synthetic */ boolean bV(g gVar, final i iVar) {
        AppMethodBeat.i(9642);
        ab.i("MicroMsg.MsgHandler", "do ecard jsapi check");
        final cr crVar = new cr();
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        crVar.cvM.appId = gVar2.appId;
        crVar.cvM.cvO = gVar2.timeStamp;
        crVar.cvM.nonceStr = gVar2.nonceStr;
        crVar.cvM.packageExt = gVar2.packageExt;
        crVar.cvM.signature = gVar2.cId;
        crVar.cvM.signType = gVar2.signType;
        crVar.cvM.cvP = gVar2.url;
        crVar.cvM.cvQ = (String) iVar.puc.get("ecardType");
        crVar.cvM.cvR = (String) iVar.puc.get("openScene");
        crVar.cvM.aIq = new WeakReference(gVar.context);
        crVar.cvM.token = (String) iVar.puc.get("token");
        crVar.cvM.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(9105);
                ab.i("MicroMsg.MsgHandler", "run ecard jsapi check callback");
                if (crVar.cvN.retCode == 0) {
                    g.a(g.this, iVar, "openECard:ok", null);
                    AppMethodBeat.o(9105);
                    return;
                }
                g.a(g.this, iVar, "openECard:fail", null);
                AppMethodBeat.o(9105);
            }
        };
        crVar.cvM.cvS = gVar2.cvS;
        com.tencent.mm.sdk.b.a.xxA.m(crVar);
        AppMethodBeat.o(9642);
        return true;
    }

    static /* synthetic */ boolean cb(g gVar, final i iVar) {
        AppMethodBeat.i(9648);
        String str = (String) iVar.puc.get("miniProgramAppId");
        if (!bo.isNullOrNil(str)) {
            ((com.tencent.mm.plugin.appbrand.service.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.a.class)).xk(str).a(new com.tencent.mm.vending.g.d.b<Integer>() {
                public final /* synthetic */ void az(Object obj) {
                    AppMethodBeat.i(9072);
                    Integer num = (Integer) obj;
                    int intValue = num == null ? 0 : num.intValue();
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("reportId", Integer.valueOf(intValue));
                    g.b(g.this, iVar, "reportMiniProgramPageData:ok", hashMap);
                    AppMethodBeat.o(9072);
                }
            }).a(new com.tencent.mm.vending.g.d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(9071);
                    g.b(g.this, iVar, "reportMiniProgramPageData:fail", null);
                    AppMethodBeat.o(9071);
                }
            });
        }
        AppMethodBeat.o(9648);
        return false;
    }

    static /* synthetic */ boolean ci(g gVar, final i iVar) {
        AppMethodBeat.i(9655);
        if (com.tencent.mm.model.gdpr.c.aaZ()) {
            ab.i("MicroMsg.MsgHandler", "eu user just return fail");
            gVar.a(iVar, "add_contact:fail EU user failed", null);
            AppMethodBeat.o(9655);
            return true;
        }
        String str = (String) iVar.puc.get("username");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "user name is null or nil");
            gVar.a(iVar, "add_contact:fail", null);
            AppMethodBeat.o(9655);
            return false;
        }
        String str2 = (String) iVar.puc.get("profileReportInfo");
        ab.i("MicroMsg.MsgHandler", "get scene = %s", (String) iVar.puc.get("scene"));
        final com.tencent.mm.pluginsdk.ui.applet.o a = ((com.tencent.mm.pluginsdk.g) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.g.class)).a(gVar.context, str, bo.getInt(r0, 91), new com.tencent.mm.pluginsdk.ui.applet.n() {
            public final void nZ(int i) {
                AppMethodBeat.i(9193);
                switch (i) {
                    case -2:
                        g.a(g.this, iVar, "quickly_add_contact:added", null);
                        AppMethodBeat.o(9193);
                        return;
                    case -1:
                        g.a(g.this, iVar, "quickly_add_contact:fail", null);
                        AppMethodBeat.o(9193);
                        return;
                    case 0:
                        g.a(g.this, iVar, "quickly_add_contact:cancel", null);
                        AppMethodBeat.o(9193);
                        return;
                    case 1:
                        g.a(g.this, iVar, "quickly_add_contact:ok", null);
                        AppMethodBeat.o(9193);
                        return;
                    default:
                        g.a(g.this, iVar, "quickly_add_contact:fail", null);
                        AppMethodBeat.o(9193);
                        return;
                }
            }
        }, false, str2);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(9194);
                a.show();
                AppMethodBeat.o(9194);
            }
        });
        AppMethodBeat.o(9655);
        return true;
    }

    static /* synthetic */ boolean cj(g gVar, i iVar) {
        AppMethodBeat.i(9656);
        String str = (String) iVar.puc.get("consumedCardId");
        String str2 = (String) iVar.puc.get("consumedCode");
        ab.i("MicroMsg.MsgHandler", "doConsumedShareCard consumedCardId is ".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.MsgHandler", "doConsumedShareCard failed, illegal params (id : %s, code : %s)", str, str2);
            gVar.a(iVar, "consumedShareCard:fail", null);
            AppMethodBeat.o(9656);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("key_consumed_card_id", str);
        intent.putExtra("key_consumed_Code", str2);
        ((MMActivity) gVar.context).ifE = gVar;
        com.tencent.mm.bp.d.b(gVar.context, "card", ".sharecard.ui.CardConsumeSuccessUI", intent, 29);
        AppMethodBeat.o(9656);
        return true;
    }

    static /* synthetic */ boolean cp(g gVar, i iVar) {
        AppMethodBeat.i(9662);
        ab.i("MicroMsg.MsgHandler", "doSelectSingleContact selectedMode:%d", Integer.valueOf(bo.getInt((String) iVar.puc.get("selectMode"), 0)));
        Intent intent = new Intent();
        if (bo.getInt((String) iVar.puc.get("selectMode"), 0) == 1) {
            intent.putExtra("Select_Conv_Type", com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_FASHION);
            intent.putExtra("jsapi_select_mode", 1);
        } else {
            intent.putExtra("Select_Conv_Type", com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA);
        }
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", r.Yz());
        intent.putExtra("scene_from", 4);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bp.d.a((MMActivity) gVar.context, ".ui.transmit.SelectConversationUI", intent, 30, (com.tencent.mm.ui.MMActivity.a) gVar);
        }
        AppMethodBeat.o(9662);
        return true;
    }

    static /* synthetic */ boolean cr(g gVar, i iVar) {
        AppMethodBeat.i(9665);
        ab.i("MicroMsg.MsgHandler", "doChooseVideo()");
        boolean a = gVar.a(iVar, 0);
        AppMethodBeat.o(9665);
        return a;
    }

    static /* synthetic */ boolean cu(g gVar, i iVar) {
        AppMethodBeat.i(9670);
        ab.i("MicroMsg.MsgHandler", "openEmoticonTopicList");
        int i = bo.getInt((String) iVar.puc.get("tid"), 0);
        String str = (String) iVar.puc.get("title");
        String str2 = (String) iVar.puc.get("desc");
        String str3 = (String) iVar.puc.get("iconUrl");
        String str4 = (String) iVar.puc.get("secondUrl");
        Intent intent = new Intent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_desc", str2);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("extra_scence", 12);
        com.tencent.mm.bp.d.b(gVar.context, "emoji", ".ui.EmojiStoreTopicUI", intent);
        gVar.a(iVar, "openEmoticonTopicList", null);
        AppMethodBeat.o(9670);
        return true;
    }

    static /* synthetic */ boolean cv(g gVar, i iVar) {
        AppMethodBeat.i(9671);
        ab.i("MicroMsg.MsgHandler", "openEmotionDetailView");
        String str = (String) iVar.puc.get("ProductId");
        ab.d("MicroMsg.MsgHandler", "cpan emoji openEmotionDetailView:%d", Long.valueOf(bo.getLong((String) iVar.puc.get("searchID"), 0)));
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.MsgHandler", "openEmotionDetailView failed product id is null.");
            gVar.a(iVar, "openEmotionDetailView", null);
            AppMethodBeat.o(9671);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("preceding_scence", 12);
        intent.putExtra("download_entrance_scene", 12);
        intent.putExtra("searchID", r4);
        if (gVar.uGs) {
            ab.i("MicroMsg.MsgHandler", "had start emoji stroe detail ui.");
        } else {
            com.tencent.mm.bp.d.b(gVar.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            gVar.uGs = true;
        }
        gVar.a(iVar, "openEmotionDetailView", null);
        h.pYm.e(13055, Integer.valueOf(0), str, "", "", Integer.valueOf(com.tencent.mm.ao.a.afW()), Long.valueOf(r4));
        AppMethodBeat.o(9671);
        return true;
    }

    static /* synthetic */ boolean cw(g gVar, i iVar) {
        AppMethodBeat.i(9672);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.modeltools.g.cYA();
        Map map = iVar.puc;
        String afU = com.tencent.mm.ao.a.afU();
        if (bo.isNullOrNil(afU)) {
            ab.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
            AppMethodBeat.o(9672);
            return false;
        }
        int v = com.tencent.mm.plugin.webview.c.a.v(map, "type");
        String t = com.tencent.mm.plugin.webview.c.a.t(map, "pageName");
        String t2 = com.tencent.mm.plugin.webview.c.a.t(map, "keyword");
        int v2 = com.tencent.mm.plugin.webview.c.a.v(map, "scene");
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("rawUrl", "file://" + afU + "/" + t + "?type=" + v + "&keyword=" + t2 + "&scene=" + v2 + "&lang=" + com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()) + "&clientType=1&version=" + com.tencent.mm.ao.a.afW());
        intent.putExtra("keyword", t2);
        intent.putExtra("type", v);
        intent.putExtra("sence", v2);
        com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        h.pYm.e(13055, Integer.valueOf(1), "", "", Integer.valueOf(v), Integer.valueOf(com.tencent.mm.ao.a.afW()), Long.valueOf(0));
        mq mqVar = new mq();
        mqVar.cIt.type = v;
        mqVar.cIt.query = t2;
        mqVar.cIt.cIu = "";
        com.tencent.mm.sdk.b.a.xxA.m(mqVar);
        AppMethodBeat.o(9672);
        return true;
    }

    static /* synthetic */ boolean cx(g gVar, i iVar) {
        AppMethodBeat.i(9673);
        gVar.eBB = false;
        boolean ar = com.tencent.mm.plugin.webview.modeltools.g.cYA().ar(iVar.puc);
        AppMethodBeat.o(9673);
        return ar;
    }

    static /* synthetic */ boolean cy(g gVar, i iVar) {
        AppMethodBeat.i(9674);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.modeltools.g.cYA();
        String t = com.tencent.mm.plugin.webview.c.a.t(iVar.puc, "urlString");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", t);
        com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(9674);
        return false;
    }

    static /* synthetic */ boolean cC(g gVar, i iVar) {
        AppMethodBeat.i(9678);
        ab.i("MicroMsg.MsgHandler", "hy: start soter auth");
        ((MMActivity) gVar.context).ifE = gVar;
        Bundle aP = i.aP(iVar.puc);
        Intent intent = new Intent(gVar.context, SoterAuthenticationUIWC.class);
        intent.putExtras(aP);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        String bK = gVar.bK(gVar.getCurrentUrl());
        if (bK == null) {
            bK = (String) iVar.puc.get("appId");
        }
        intent.putExtra("key_app_id", bK);
        ((MMActivity) gVar.context).startActivityForResult(intent, 38);
        AppMethodBeat.o(9678);
        return true;
    }

    static /* synthetic */ boolean cD(g gVar, i iVar) {
        int i;
        AppMethodBeat.i(9679);
        ab.i("MicroMsg.MsgHandler", "hy: do get soter support");
        hu huVar = new hu();
        com.tencent.mm.sdk.b.a.xxA.m(huVar);
        Map hashMap = new HashMap();
        hashMap.put("support_mode", Integer.valueOf(huVar.cCM.cCN));
        gVar.a(iVar, "getSupportSoter", hashMap);
        if (huVar.cCM.cCN == 1) {
            i = 1;
        } else {
            i = 0;
        }
        gVar.a(iVar, 0, i);
        AppMethodBeat.o(9679);
        return true;
    }

    static /* synthetic */ boolean cE(g gVar, i iVar) {
        AppMethodBeat.i(9680);
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        String str = (String) iVar.puc.get("appId");
        if (gVar.uGh != null) {
            if (TextUtils.isEmpty(str)) {
                str = gVar.uGh.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str)) {
                str = gVar.uGr.agj(gVar.getCurrentUrl());
            }
        }
        intent.putExtra("appId", str);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.cId);
        intent.putExtra("url", gVar.getCurrentUrl());
        ((MMActivity) gVar.context).ifE = gVar;
        com.tencent.mm.bp.d.a(gVar.context, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", intent, 39, false);
        AppMethodBeat.o(9680);
        return true;
    }

    static /* synthetic */ boolean cJ(g gVar, i iVar) {
        AppMethodBeat.i(9685);
        String nullAsNil = bo.nullAsNil((String) iVar.puc.get("toUsername"));
        String nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("scene"));
        String nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("type"));
        String nullAsNil4 = bo.nullAsNil((String) iVar.puc.get("allowBackCamera"));
        String nullAsNil5 = bo.nullAsNil((String) iVar.puc.get("showOther"));
        String nullAsNil6 = bo.nullAsNil((String) iVar.puc.get("avatarUrl"));
        String nullAsNil7 = bo.nullAsNil((String) iVar.puc.get("context"));
        ab.i("MicroMsg.MsgHandler", "doStartVoipCS,toUserName:" + nullAsNil + ",scene:" + nullAsNil2 + ",type:" + nullAsNil3 + ",allowBackCamera:" + nullAsNil4 + ",showOther:" + nullAsNil5 + ",avatarUrl:" + nullAsNil6 + ",voipCSContext:" + nullAsNil7);
        String str = (String) iVar.puc.get("appId");
        if (str == null || str.equals("") || nullAsNil == null || nullAsNil.equals("")) {
            gVar.a(iVar, "startVoipCall:param invalid", null);
            AppMethodBeat.o(9685);
        } else {
            gVar.uGM = iVar;
            com.tencent.mm.sdk.b.a.xxA.c(gVar.uGN);
            if (nullAsNil.equals("testacs")) {
                Intent intent = new Intent();
                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                com.tencent.mm.bp.d.b(ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                AppMethodBeat.o(9685);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("voipCSBizId", nullAsNil);
                intent2.putExtra("voipCSScene", nullAsNil2);
                intent2.putExtra("voipCSType", nullAsNil3);
                intent2.putExtra("voipCSAppId", str);
                intent2.putExtra("voipCSAllowBackCamera", nullAsNil4);
                intent2.putExtra("voipCSShowOther", nullAsNil5);
                intent2.putExtra("voipCSAvatarUrl", nullAsNil6);
                intent2.putExtra("voipCSContext", nullAsNil7);
                com.tencent.mm.bp.d.b(ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent2);
                AppMethodBeat.o(9685);
            }
        }
        return true;
    }

    static /* synthetic */ boolean cN(g gVar, i iVar) {
        AppMethodBeat.i(9689);
        ab.d("MicroMsg.MsgHandler", "doOpenLuckyMoneyDetailView");
        String str = (String) iVar.puc.get("sendId");
        int ank = bo.ank((String) iVar.puc.get("hbKind"));
        if (bo.isNullOrNil(str)) {
            gVar.a(iVar, "openLuckyMoneyDetailView:fail", null);
        } else {
            ab.i("MicroMsg.MsgHandler", "sendId: %s, hbKind: %s", str, Integer.valueOf(ank));
            Intent intent = new Intent();
            intent.putExtra("key_sendid", str);
            intent.putExtra("key_jump_from", 4);
            if (ank == 2) {
                com.tencent.mm.bp.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
            } else {
                com.tencent.mm.bp.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
            }
            gVar.a(iVar, "openLuckyMoneyDetailView:ok", null);
        }
        AppMethodBeat.o(9689);
        return true;
    }

    static /* synthetic */ boolean cO(g gVar, i iVar) {
        AppMethodBeat.i(9690);
        ab.d("MicroMsg.MsgHandler", "doResendRemittanceMsg");
        final String str = (String) iVar.puc.get("transactionId");
        final String str2 = (String) iVar.puc.get("transfer_id");
        final String str3 = (String) iVar.puc.get("receiverName");
        String str4 = (String) iVar.puc.get("title");
        String str5 = (String) iVar.puc.get("pic");
        String str6 = (String) iVar.puc.get("description");
        String str7 = (String) iVar.puc.get("left_button_wording");
        String str8 = (String) iVar.puc.get("right_button_wording");
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4) || bo.isNullOrNil(str5) || bo.isNullOrNil(str6) || bo.isNullOrNil(str7) || bo.isNullOrNil(str8)) {
            gVar.a(iVar, "doResendRemittanceMsg:fail", null);
        } else {
            final i iVar2 = iVar;
            ((com.tencent.mm.plugin.remittance.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.remittance.a.class)).a(gVar.context, str4, str5, str6, str7, str8, new com.tencent.mm.ui.widget.a.e.c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(9104);
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.TRANSACTION_ID, str);
                        intent.putExtra("transfer_id", str2);
                        intent.putExtra("receiver_name", str3);
                        intent.putExtra("resend_msg_from_flag", 4);
                        com.tencent.mm.bp.d.b(g.this.context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                        g.a(g.this, iVar2, "doResendRemittanceMsg:ok", null);
                        AppMethodBeat.o(9104);
                        return;
                    }
                    g.a(g.this, iVar2, "doResendRemittanceMsg:fail", null);
                    AppMethodBeat.o(9104);
                }
            });
        }
        AppMethodBeat.o(9690);
        return true;
    }

    static /* synthetic */ boolean cQ(g gVar, i iVar) {
        AppMethodBeat.i(9692);
        ab.i("MicroMsg.MsgHandler", "doRecordVideo()");
        boolean a = gVar.a(iVar, 1);
        AppMethodBeat.o(9692);
        return a;
    }

    static /* synthetic */ boolean cR(g gVar, i iVar) {
        AppMethodBeat.i(9693);
        ab.i("MicroMsg.MsgHandler", "doPreviewVideo(), localId:%s", (String) iVar.puc.get("localId"));
        WebViewJSSDKFileItem aex = com.tencent.mm.plugin.webview.modeltools.g.cYF().aex(r0);
        if (aex == null) {
            ab.e("MicroMsg.MsgHandler", "the item is null");
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (TextUtils.isEmpty(aex.heo)) {
            ab.e("MicroMsg.MsgHandler", "the File item not exist for localId:%s", aex.czD);
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (new com.tencent.mm.vfs.b(aex.heo).exists()) {
            Intent intent = new Intent();
            intent.putExtra("key_video_path", aex.heo);
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).ifE = gVar;
                com.tencent.mm.bp.d.b(gVar.context, "card", ".ui.CardGiftVideoUI", intent, 46);
            }
        } else {
            ab.e("MicroMsg.MsgHandler", "the File not exist for origFilePath:%s", aex.heo);
            gVar.a(iVar, "previewVideo:fail", null);
        }
        AppMethodBeat.o(9693);
        return true;
    }

    static /* synthetic */ boolean cX(g gVar, final i iVar) {
        AppMethodBeat.i(9700);
        ab.i("MicroMsg.MsgHandler", "getLocalWePkgInfo call");
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(9086);
                com.tencent.mm.plugin.wepkg.model.g.a(new com.tencent.mm.plugin.wepkg.model.g.a() {
                    public final void U(JSONObject jSONObject) {
                        AppMethodBeat.i(9085);
                        Map hashMap = new HashMap();
                        hashMap.put("wepkg_info", jSONObject);
                        g.a(g.this, iVar, "getLocalWePkgInfo:ok", hashMap);
                        AppMethodBeat.o(9085);
                    }
                });
                AppMethodBeat.o(9086);
            }
        });
        AppMethodBeat.o(9700);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean cY(g gVar, i iVar) {
        boolean z = false;
        AppMethodBeat.i(9701);
        String str = (String) iVar.puc.get("url");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openGameWebView:fail_invalid_url", null);
            AppMethodBeat.o(9701);
        } else {
            int i;
            boolean z2;
            String nullAsNil;
            final Intent intent;
            gu guVar;
            String nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("orientation"));
            if (!bo.isNullOrNil(nullAsNil2)) {
                if (nullAsNil2.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                    i = 0;
                } else if (nullAsNil2.equals("vertical")) {
                    i = 1;
                } else if (nullAsNil2.equals("sensor")) {
                    i = 4;
                }
                if (bo.nullAsNil((String) iVar.puc.get("fullscreen")).equals("true")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (bo.nullAsNil((String) iVar.puc.get("disable_swipe_back")).equals("1")) {
                    z = true;
                }
                nullAsNil = bo.nullAsNil((String) iVar.puc.get("gameAppid"));
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_scene", 32);
                intent.putExtra("KPublisherId", "game_webview");
                intent.putExtra("screen_orientation", i);
                intent.putExtra("show_full_screen", z2);
                intent.putExtra("disable_swipe_back", z);
                intent.putExtra("game_hv_menu_appid", nullAsNil);
                com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.umI, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9095);
                        com.tencent.mm.bp.d.b(g.this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
                        AppMethodBeat.o(9095);
                    }
                });
                guVar = new gu();
                guVar.cBw.Cn = 2;
                guVar.cBw.cBy = nullAsNil;
                com.tencent.mm.sdk.b.a.xxA.m(guVar);
                gVar.a(iVar, "openGameWebView:ok", null);
                AppMethodBeat.o(9701);
            }
            i = -1;
            if (bo.nullAsNil((String) iVar.puc.get("fullscreen")).equals("true")) {
            }
            if (bo.nullAsNil((String) iVar.puc.get("disable_swipe_back")).equals("1")) {
            }
            nullAsNil = bo.nullAsNil((String) iVar.puc.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", "game_webview");
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z2);
            intent.putExtra("disable_swipe_back", z);
            intent.putExtra("game_hv_menu_appid", nullAsNil);
            com.tencent.mm.plugin.webview.ui.tools.g.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.umI, /* anonymous class already generated */);
            guVar = new gu();
            guVar.cBw.Cn = 2;
            guVar.cBw.cBy = nullAsNil;
            com.tencent.mm.sdk.b.a.xxA.m(guVar);
            gVar.a(iVar, "openGameWebView:ok", null);
            AppMethodBeat.o(9701);
        }
        return true;
    }

    static /* synthetic */ boolean da(g gVar, final i iVar) {
        AppMethodBeat.i(9703);
        ab.i("MicroMsg.MsgHandler", "doLoginOrAuthorize!");
        AnonymousClass7 anonymousClass7 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(9048);
                if (iVar.uIJ.equals("login")) {
                    g.a(g.this, iVar, g.uGU);
                    AppMethodBeat.o(9048);
                    return;
                }
                if (iVar.uIJ.equals("authorize")) {
                    g.b(g.this, iVar, g.uGU);
                }
                AppMethodBeat.o(9048);
            }
        };
        if (uGT) {
            uGS.add(anonymousClass7);
            ab.i("MicroMsg.MsgHandler", "add to authJsApiQueue!");
        } else {
            uGT = true;
            anonymousClass7.run();
        }
        AppMethodBeat.o(9703);
        return true;
    }

    static /* synthetic */ boolean db(g gVar, i iVar) {
        AppMethodBeat.i(9704);
        ab.i("MicroMsg.MsgHandler", "hy: start do check is support face detect");
        ht htVar = new ht();
        com.tencent.mm.sdk.b.a.xxA.m(htVar);
        boolean z = htVar.cCH.cCI;
        int i = htVar.cCH.cCJ;
        ab.i("MicroMsg.MsgHandler", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", Boolean.valueOf(z), Integer.valueOf(i), htVar.cCH.cCK, Integer.valueOf(htVar.cCH.cCL));
        Map hashMap = new HashMap();
        hashMap.put("err_code", String.valueOf(i));
        hashMap.put("err_msg", r3);
        hashMap.put("lib_version_code", String.valueOf(r0));
        gVar.a(iVar, "doCheckIsSupportFaceDetect: ok", hashMap);
        AppMethodBeat.o(9704);
        return true;
    }

    static /* synthetic */ boolean df(g gVar, i iVar) {
        AppMethodBeat.i(9710);
        final String nullAsNil = bo.nullAsNil((String) iVar.puc.get("base64DataString"));
        final String nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("thumbUrl"));
        final String nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("url"));
        final String nullAsNil4 = bo.nullAsNil((String) iVar.puc.get("activityId"));
        if (!bo.isNullOrNil(nullAsNil)) {
            final i iVar2 = iVar;
            com.tencent.mm.plugin.webview.a.a.R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9199);
                    ab.i("MicroMsg.MsgHandler", "doAddToEmoticon use base64DataString");
                    int indexOf = nullAsNil.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = nullAsNil.substring(indexOf + 8, nullAsNil.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bo.cb(decode)) {
                            g.a(g.this, iVar2, "addToEmoticon:fail", null);
                            AppMethodBeat.o(9199);
                            return;
                        }
                        String x = com.tencent.mm.a.g.x(decode);
                        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", x);
                        if (!(com.tencent.mm.vfs.e.ct(L) && com.tencent.mm.vfs.e.atg(L).equalsIgnoreCase(x))) {
                            com.tencent.mm.vfs.e.b(L, decode, decode.length);
                        }
                        g.a(g.this, x, nullAsNil2, nullAsNil4);
                        AppMethodBeat.o(9199);
                    } catch (Exception e) {
                        ab.e("MicroMsg.MsgHandler", "doAddToEmoticon error:" + e.getMessage());
                        g.a(g.this, iVar2, "addToEmoticon:fail_" + e.getMessage(), null);
                        AppMethodBeat.o(9199);
                    }
                }
            });
        } else if (bo.isNullOrNil(nullAsNil3)) {
            ab.e("MicroMsg.MsgHandler", "doAddToEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "addToEmoticon:fail_base64DataString_and_url_is_null", null);
            AppMethodBeat.o(9710);
            return false;
        } else {
            ab.i("MicroMsg.MsgHandler", "doAddToEmoticon use url:%s", nullAsNil3);
            final com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(gVar.context.getCacheDir(), com.tencent.mm.a.g.x(nullAsNil3.getBytes()));
            if (bVar.exists()) {
                com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9200);
                        String atg = com.tencent.mm.vfs.e.atg(com.tencent.mm.vfs.j.w(bVar.mUri));
                        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", atg);
                        if (!com.tencent.mm.vfs.e.ct(L)) {
                            com.tencent.mm.vfs.e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), L);
                        }
                        g.a(g.this, atg, nullAsNil2, nullAsNil4);
                        AppMethodBeat.o(9200);
                    }
                });
            } else {
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePH = true;
                aVar.ePJ = com.tencent.mm.vfs.j.w(bVar.dMD());
                aVar.eQd = new Object[]{com.tencent.mm.vfs.j.w(bVar.dMD())};
                final i iVar3 = iVar;
                com.tencent.mm.plugin.emoji.model.j.bjW().a(nullAsNil3, null, aVar.ahG(), new com.tencent.mm.at.a.c.i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(9201);
                        ab.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", str);
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            g.a(g.this, iVar3, "addToEmoticon:fail", null);
                            AppMethodBeat.o(9201);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            g.a(g.this, iVar3, "addToEmoticon:fail", null);
                            AppMethodBeat.o(9201);
                        } else if (str.equals(nullAsNil3)) {
                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(objArr[0].toString());
                            if (bVar.exists()) {
                                String atg = com.tencent.mm.vfs.e.atg(com.tencent.mm.vfs.j.w(bVar.mUri));
                                com.tencent.mm.vfs.e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", atg));
                                g.a(g.this, atg, nullAsNil2, nullAsNil4);
                                AppMethodBeat.o(9201);
                                return;
                            }
                            g.a(g.this, iVar3, "addToEmoticon:fail", null);
                            AppMethodBeat.o(9201);
                        } else {
                            g.a(g.this, iVar3, "addToEmoticon:fail", null);
                            AppMethodBeat.o(9201);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(9710);
        return true;
    }

    static /* synthetic */ boolean dg(g gVar, final i iVar) {
        AppMethodBeat.i(9711);
        final String nullAsNil = bo.nullAsNil((String) iVar.puc.get("base64DataString"));
        final String nullAsNil2 = bo.nullAsNil((String) iVar.puc.get("url"));
        final String nullAsNil3 = bo.nullAsNil((String) iVar.puc.get("activityId"));
        if (!bo.isNullOrNil(nullAsNil)) {
            com.tencent.mm.plugin.webview.a.a.R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(9203);
                    ab.i("MicroMsg.MsgHandler", "doShareEmoticon use base64DataString");
                    int indexOf = nullAsNil.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = nullAsNil.substring(indexOf + 8, nullAsNil.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bo.cb(decode)) {
                            g.a(g.this, iVar, "shareEmoticon:fail", null);
                            AppMethodBeat.o(9203);
                            return;
                        }
                        String x = com.tencent.mm.a.g.x(decode);
                        if (bo.isNullOrNil(x)) {
                            g.a(g.this, iVar, "shareEmoticon:fail empty buffer", null);
                            AppMethodBeat.o(9203);
                            return;
                        }
                        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", x);
                        if (!(com.tencent.mm.vfs.e.ct(L) && com.tencent.mm.vfs.e.atg(L).equalsIgnoreCase(x))) {
                            com.tencent.mm.vfs.e.b(L, decode, decode.length);
                        }
                        g.a(g.this, x, nullAsNil3);
                        AppMethodBeat.o(9203);
                    } catch (Exception e) {
                        ab.e("MicroMsg.MsgHandler", "doShareEmoticon error:" + e.getMessage());
                        g.a(g.this, iVar, "shareEmoticon:fail_" + e.getMessage(), null);
                        AppMethodBeat.o(9203);
                    }
                }
            });
        } else if (bo.isNullOrNil(nullAsNil2)) {
            ab.e("MicroMsg.MsgHandler", "doShareEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "shareEmoticon:fail_base64DataString_and_url_is_null", null);
            AppMethodBeat.o(9711);
            return false;
        } else {
            ab.i("MicroMsg.MsgHandler", "doShareEmoticon use url:%s", nullAsNil2);
            final com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(gVar.context.getCacheDir(), com.tencent.mm.a.g.x(nullAsNil2.getBytes()));
            if (bVar.exists()) {
                com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(9204);
                        String atg = com.tencent.mm.vfs.e.atg(com.tencent.mm.vfs.j.w(bVar.mUri));
                        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", atg);
                        if (!com.tencent.mm.vfs.e.ct(L)) {
                            com.tencent.mm.vfs.e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), L);
                        }
                        g.a(g.this, atg, nullAsNil3);
                        AppMethodBeat.o(9204);
                    }
                });
            } else {
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.ePH = true;
                aVar.ePJ = com.tencent.mm.vfs.j.w(bVar.dMD());
                aVar.eQd = new Object[]{com.tencent.mm.vfs.j.w(bVar.dMD())};
                com.tencent.mm.plugin.emoji.model.j.bjW().a(nullAsNil2, null, aVar.ahG(), new com.tencent.mm.at.a.c.i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(9205);
                        ab.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", str);
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            g.a(g.this, iVar, "shareEmoticon:fail", null);
                            AppMethodBeat.o(9205);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            g.a(g.this, iVar, "shareEmoticon:fail", null);
                            AppMethodBeat.o(9205);
                        } else if (str.equals(nullAsNil2)) {
                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(objArr[0].toString());
                            if (bVar.exists()) {
                                String atg = com.tencent.mm.vfs.e.atg(com.tencent.mm.vfs.j.w(bVar.mUri));
                                com.tencent.mm.vfs.e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", atg));
                                g.a(g.this, atg, nullAsNil3);
                                AppMethodBeat.o(9205);
                                return;
                            }
                            g.a(g.this, iVar, "shareEmoticon:fail", null);
                            AppMethodBeat.o(9205);
                        } else {
                            g.a(g.this, iVar, "shareEmoticon:fail", null);
                            AppMethodBeat.o(9205);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(9711);
        return true;
    }

    static /* synthetic */ boolean dh(g gVar, i iVar) {
        AppMethodBeat.i(9712);
        ((MMActivity) gVar.context).ifE = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 3);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.puc.get("request_ticket"));
        bundle.putInt("check_alive_type", 0);
        or orVar = new or();
        orVar.cLd.context = gVar.context;
        orVar.cLd.cKY = 50;
        orVar.cLd.extras = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(orVar);
        ab.i("MicroMsg.MsgHandler", "hy: start face register rsa event result: %b", Boolean.valueOf(orVar.cLe.cKV));
        if (!orVar.cLe.cKV) {
            ((MMActivity) gVar.context).ifE = null;
            gVar.a(iVar, "requestWxFaceRegisterInternal:fail", i.aq(orVar.cLe.extras));
        }
        AppMethodBeat.o(9712);
        return true;
    }

    static /* synthetic */ boolean di(g gVar, i iVar) {
        AppMethodBeat.i(9713);
        ((MMActivity) gVar.context).ifE = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", av.fly.T("login_user_name", ""));
        bundle.putInt("k_server_scene", 4);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.puc.get("request_ticket"));
        bundle.putInt("check_alive_type", 0);
        or orVar = new or();
        orVar.cLd.context = gVar.context;
        orVar.cLd.cKY = 51;
        orVar.cLd.extras = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(orVar);
        ab.i("MicroMsg.MsgHandler", "hy: start face verify rsa event result: %b", Boolean.valueOf(orVar.cLe.cKV));
        if (!orVar.cLe.cKV) {
            ((MMActivity) gVar.context).ifE = null;
            gVar.a(iVar, "requestWxFaceVerifyInternal:fail", i.aq(orVar.cLe.extras));
        }
        AppMethodBeat.o(9713);
        return true;
    }

    static /* synthetic */ boolean dk(g gVar, i iVar) {
        AppMethodBeat.i(9716);
        String str = (String) iVar.puc.get("selected_user_name");
        Intent intent = new Intent();
        intent.putExtra("list_type", 15);
        intent.putExtra("already_select_contact", str);
        intent.putExtra("titile", gVar.context.getString(R.string.eu));
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.C(16384, 1, 4, 1048576));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bp.d.a((MMActivity) gVar.context, ".ui.contact.SelectContactUI", intent, 54, (com.tencent.mm.ui.MMActivity.a) gVar);
        } else {
            ab.e("MicroMsg.MsgHandler", "doSelectContact invalid context");
            gVar.a(iVar, "selectContact:fail", null);
        }
        AppMethodBeat.o(9716);
        return true;
    }

    static /* synthetic */ boolean dl(g gVar, i iVar) {
        AppMethodBeat.i(9717);
        gVar.eBB = false;
        String str = (String) iVar.puc.get("phoneNumber");
        ab.d("MicroMsg.MsgHandler", "jsapi makePhoneCall num %s", str);
        if (TextUtils.isEmpty(str)) {
            gVar.a(iVar, "makePhoneCall:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
            intent.addFlags(268435456);
            if (bo.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
            gVar.a(iVar, "makePhoneCall:succ", null);
        }
        AppMethodBeat.o(9717);
        return true;
    }

    static /* synthetic */ boolean dm(g gVar, i iVar) {
        AppMethodBeat.i(9718);
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        intent.putExtra("appId", bo.bc((String) iVar.puc.get("appid"), ""));
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.cId);
        intent.putExtra("url", gVar2.url);
        intent.putExtra("reset_pwd_token", gVar2.vwv);
        intent.putExtra("pay_channel", gVar2.cvS);
        ((MMActivity) gVar.context).ifE = gVar;
        com.tencent.mm.bp.d.b(gVar.context, "wallet", ".pwd.ui.WalletResetPwdAdapterUI", intent, 55);
        AppMethodBeat.o(9718);
        return true;
    }

    static /* synthetic */ boolean dn(g gVar, i iVar) {
        AppMethodBeat.i(9719);
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        ab.i("MicroMsg.MsgHandler", "doChooseInvoiceTitle");
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).ifE = gVar;
            com.tencent.mm.bp.d.a(gVar.context, "address", ".ui.InvoiceListUI", intent, 56, false);
        }
        AppMethodBeat.o(9719);
        return true;
    }

    static /* synthetic */ boolean dt(g gVar, i iVar) {
        int i = 0;
        AppMethodBeat.i(9725);
        gVar.eBB = false;
        com.tencent.mm.plugin.webview.fts.g cYD = com.tencent.mm.plugin.webview.modeltools.g.cYD();
        Map map = iVar.puc;
        Map hashMap = new HashMap();
        hashMap.put("errcode", Integer.valueOf(0));
        hashMap.put("msg", "success");
        if (map != null) {
            int d = com.tencent.mm.plugin.websearch.api.aa.d(map, "limit", 3);
            int d2 = com.tencent.mm.plugin.websearch.api.aa.d(map, "webview_instance_id", -1);
            if (d2 > 0) {
                String str = String.valueOf(d2) + '_' + String.valueOf(bo.anT() / 300);
                if (cYD.uge.containsKey(str)) {
                    i = ((Integer) cYD.uge.get(str)).intValue();
                }
                if (i < d) {
                    com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
                    com.tencent.mm.pluginsdk.g.a.a.b.Ky(40);
                    cYD.uge.put(str, Integer.valueOf(i + 1));
                } else {
                    hashMap.put("errcode", Integer.valueOf(-1));
                    hashMap.put("msg", "fail:over call");
                }
            }
        } else {
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
            com.tencent.mm.pluginsdk.g.a.a.b.Ky(40);
        }
        gVar.a(iVar, "updateWASearchTemplate:succ", hashMap);
        AppMethodBeat.o(9725);
        return true;
    }

    static /* synthetic */ boolean du(g gVar, i iVar) {
        AppMethodBeat.i(9726);
        gVar.eBB = false;
        String t = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "userName");
        if (t.length() > 0) {
            ((com.tencent.mm.plugin.appbrand.service.h) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.h.class)).xO(t);
            gVar.a(iVar, "preloadSearchWeapp:succ", null);
        } else {
            gVar.a(iVar, "preloadSearchWeapp:fail", null);
        }
        AppMethodBeat.o(9726);
        return true;
    }

    static /* synthetic */ boolean dz(g gVar, i iVar) {
        AppMethodBeat.i(9731);
        gVar.eBB = false;
        boolean aC = com.tencent.mm.plugin.webview.modeltools.g.cYC().aC(iVar.puc);
        AppMethodBeat.o(9731);
        return aC;
    }

    static /* synthetic */ boolean dA(g gVar, i iVar) {
        AppMethodBeat.i(9732);
        gVar.eBB = false;
        boolean a = com.tencent.mm.plugin.webview.modeltools.g.cYC().a(iVar.puc, gVar);
        AppMethodBeat.o(9732);
        return a;
    }

    static /* synthetic */ boolean dB(g gVar, i iVar) {
        AppMethodBeat.i(9733);
        gVar.eBB = false;
        Map hashMap = new HashMap();
        hashMap.put(SearchIntents.EXTRA_QUERY, com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, SearchIntents.EXTRA_QUERY));
        hashMap.put("scene", Integer.valueOf(33));
        hashMap.put("thirdExtParam", iVar.puc.get("thirdExtParam"));
        if (iVar.puc.containsKey("url")) {
            com.tencent.mm.plugin.webview.modeltools.g.cYD().ugd = new cvf();
            com.tencent.mm.plugin.webview.modeltools.g.cYD().ugd.xrk = new li();
            com.tencent.mm.plugin.webview.modeltools.g.cYD().ugd.xrk.vOV = com.tencent.mm.plugin.websearch.api.aa.t(iVar.puc, "url");
        }
        com.tencent.mm.plugin.webview.modeltools.g.cYC();
        String t = com.tencent.mm.plugin.websearch.api.aa.t(hashMap, SearchIntents.EXTRA_QUERY);
        if (bo.isNullOrNil(t)) {
            AppMethodBeat.o(9733);
        } else {
            int d = com.tencent.mm.plugin.websearch.api.aa.d(hashMap, "scene", 3);
            int d2 = com.tencent.mm.plugin.websearch.api.aa.d(hashMap, "type", 0);
            String obj = hashMap.get("thirdExtParam") == null ? "" : hashMap.get("thirdExtParam").toString();
            String HP = com.tencent.mm.plugin.websearch.api.aa.HP(d);
            Map d3 = com.tencent.mm.plugin.websearch.api.aa.d(d, true, 0);
            d3.put(SearchIntents.EXTRA_QUERY, t);
            d3.put("sessionId", HP);
            d3.put("thirdExtParam", com.tencent.mm.compatible.util.q.encode(obj));
            ((com.tencent.mm.plugin.websearch.api.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.j.class)).a(ah.getContext(), d, t, HP, d3, d2);
            AppMethodBeat.o(9733);
        }
        return false;
    }

    static /* synthetic */ boolean dK(g gVar, final i iVar) {
        AppMethodBeat.i(9742);
        ab.i("MicroMsg.MsgHandler", "do handle wcpay buffer");
        l.a(iVar.uII, false, null, (String) iVar.puc.get("appId"));
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        final uk ukVar = new uk();
        ukVar.cQC.action = (String) iVar.puc.get(NativeProtocol.WEB_DIALOG_ACTION);
        ukVar.cQC.buffer = (String) iVar.puc.get("buffer");
        ukVar.cQC.cQG = bo.getInt((String) iVar.puc.get("walletRegion"), 0);
        ukVar.cQC.appId = gVar2.appId;
        ukVar.cQC.cvO = gVar2.timeStamp;
        ukVar.cQC.nonceStr = gVar2.nonceStr;
        ukVar.cQC.cQF = gVar2.cId;
        ukVar.cQC.signType = gVar2.signType;
        ukVar.cQC.cQE = gVar2.packageExt;
        ukVar.cQC.url = gVar2.url;
        ukVar.cQD.cQH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(9103);
                if (ukVar.cQD.retCode == 0) {
                    Map hashMap = new HashMap();
                    hashMap.put("buffer", ukVar.cQD.buffer);
                    g.a(g.this, iVar, "handleWCPayWalletBuffer:ok", hashMap);
                    AppMethodBeat.o(9103);
                } else if (ukVar.cQD.retCode == -2) {
                    g.a(g.this, iVar, "handleWCPayWalletBuffer:null", null);
                    AppMethodBeat.o(9103);
                } else {
                    g.a(g.this, iVar, "handleWCPayWalletBuffer:fail", null);
                    AppMethodBeat.o(9103);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(ukVar);
        AppMethodBeat.o(9742);
        return true;
    }

    static /* synthetic */ boolean dQ(g gVar, i iVar) {
        AppMethodBeat.i(9749);
        gVar.eBB = false;
        if ("1".equals(iVar.puc.get("isDeleteAll"))) {
            com.tencent.mm.plugin.webview.modeltools.g.cYC();
            ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory();
        } else {
            com.tencent.mm.plugin.webview.modeltools.g.cYC();
            ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory((String) iVar.puc.get(SearchIntents.EXTRA_QUERY));
        }
        AppMethodBeat.o(9749);
        return false;
    }

    static /* synthetic */ boolean dT(g gVar, i iVar) {
        AppMethodBeat.i(9752);
        ab.i("MicroMsg.MsgHandler", "do open offline pay view");
        ((MMActivity) gVar.context).ifE = gVar;
        Context context = gVar.context;
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.cId);
        intent.putExtra("url", gVar2.url);
        intent.putExtra("key_from_scene", 6);
        intent.putExtra("pay_channel", gVar2.cvS);
        com.tencent.mm.bp.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent, 60);
        AppMethodBeat.o(9752);
        return true;
    }

    static /* synthetic */ boolean dU(g gVar, i iVar) {
        AppMethodBeat.i(9753);
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.puc);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.cId);
        intent.putExtra("url", gVar2.url);
        intent.putExtra("pay_channel", gVar2.cvS);
        intent.putExtra("jsapi_scene", 17);
        intent.putExtra("intent_jump_package", "wallet");
        ab.i("MicroMsg.MsgHandler", "appid %s timeStamp %s nonceStr %s packageExt %s signType %s", bo.bc((String) iVar.puc.get("appid"), ""), gVar2.timeStamp, gVar2.nonceStr, gVar2.packageExt, gVar2.signType);
        intent.putExtra("intent_jump_ui", ".bind.ui.WalletBankcardManageUI");
        ((MMActivity) gVar.context).ifE = gVar;
        com.tencent.mm.bp.d.b(gVar.context, "wallet", ".ui.WalletJsApiAdapterUI", intent, 59);
        AppMethodBeat.o(9753);
        return true;
    }

    static /* synthetic */ boolean ec(g gVar, i iVar) {
        int i;
        String obj;
        String obj2;
        String obj3;
        AppMethodBeat.i(9762);
        ab.i("MicroMsg.MsgHandler", "doFaceDetectForPay");
        ((MMActivity) gVar.context).ifE = gVar;
        if (iVar.puc.containsKey("scene")) {
            i = bo.getInt(iVar.puc.get("scene").toString(), 0);
        } else {
            i = 0;
        }
        if (iVar.puc.containsKey("package")) {
            obj = iVar.puc.get("package").toString();
        } else {
            obj = null;
        }
        if (iVar.puc.containsKey("package_sign")) {
            obj2 = iVar.puc.get("package_sign").toString();
        } else {
            obj2 = null;
        }
        if (iVar.puc.containsKey("other_verify_title")) {
            obj3 = iVar.puc.get("other_verify_title").toString();
        } else {
            obj3 = null;
        }
        h.pYm.a(917, 34, 1, false);
        oo ooVar = new oo();
        ooVar.cKR.scene = i;
        ooVar.cKR.packageName = obj;
        ooVar.cKR.cKT = obj2;
        ooVar.cKR.cKU = obj3;
        ooVar.cKR.requestCode = 63;
        if (gVar.context instanceof Activity) {
            ooVar.cKR.czX = (Activity) gVar.context;
        }
        com.tencent.mm.sdk.b.a.xxA.m(ooVar);
        if (!ooVar.cKS.cKV) {
            ((MMActivity) gVar.context).ifE = null;
            gVar.a(iVar, "faceVerifyForPay:fail", i.aq(ooVar.cKS.extras));
        }
        AppMethodBeat.o(9762);
        return true;
    }

    static /* synthetic */ boolean ed(g gVar, final i iVar) {
        AppMethodBeat.i(9763);
        String str = (String) iVar.puc.get("appid");
        Intent intent = new Intent();
        intent.putExtra("appId", str);
        intent.putExtra("view_task", true);
        ((com.tencent.mm.plugin.downloader_app.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(gVar.context, intent, new com.tencent.mm.plugin.downloader_app.a.a.c() {
            public final void biB() {
                AppMethodBeat.i(9082);
                g.a(g.this, iVar, iVar.uIJ + ":ok", null);
                AppMethodBeat.o(9082);
            }
        });
        AppMethodBeat.o(9763);
        return true;
    }

    static /* synthetic */ boolean en(g gVar, i iVar) {
        AppMethodBeat.i(9773);
        boolean a = com.tencent.mm.plugin.webview.preload.e.a(iVar, gVar.umI, new com.tencent.mm.plugin.webview.preload.e.a() {
            public final void a(i iVar, String str, Map<String, Object> map) {
                AppMethodBeat.i(9090);
                g.a(g.this, iVar, str, (Map) map);
                AppMethodBeat.o(9090);
            }
        });
        AppMethodBeat.o(9773);
        return a;
    }

    static /* synthetic */ boolean eo(g gVar, final i iVar) {
        AppMethodBeat.i(9774);
        com.tencent.mm.plugin.webview.ui.tools.game.i.a(gVar.context, com.tencent.mm.plugin.downloader_app.b.a.H(iVar.puc), new com.tencent.mm.plugin.webview.ui.tools.game.i.a() {
            public final void d(String str, JSONObject jSONObject) {
                AppMethodBeat.i(9083);
                if (bo.isNullOrNil(str)) {
                    g.a(g.this, iVar, iVar.uIJ + ":ok", g.aQ(jSONObject));
                    AppMethodBeat.o(9083);
                    return;
                }
                g.a(g.this, iVar, iVar.uIJ + ":fail_" + str, null);
                AppMethodBeat.o(9083);
            }
        });
        AppMethodBeat.o(9774);
        return true;
    }

    static /* synthetic */ com.tencent.mm.ui.widget.a.c a(g gVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        AppMethodBeat.i(9795);
        if (gVar.context == null || gVar.context.getResources() == null) {
            ab.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
            AppMethodBeat.o(9795);
            return null;
        } else if (gVar.context instanceof Activity) {
            final String dcx = gVar.dcx();
            final com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
            final String str10 = str;
            final String str11 = str4;
            final String str12 = str3;
            final String str13 = str6;
            final String str14 = str7;
            final String str15 = str8;
            final String str16 = str9;
            com.tencent.mm.ui.widget.a.c a = com.tencent.mm.pluginsdk.ui.applet.t.a.vlq.a(((MMActivity) gVar.context).mController, str2, str3, str5, true, gVar.context.getResources().getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                final /* synthetic */ boolean uIy = true;

                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(9209);
                    if (z) {
                        g.a(g.this, bT, str10, str11, str12, str13, str14, str, dcx);
                        if (this.uIy) {
                            com.tencent.mm.bp.d.f(g.this.context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", str11));
                        } else if (g.this.context != null) {
                            com.tencent.mm.ui.base.h.bQ(g.this.context, g.this.context.getResources().getString(R.string.to));
                        }
                        g.this.gB(1, 1);
                        g.a(g.this, g.this.uGd, str15, null);
                        AppMethodBeat.o(9209);
                        return;
                    }
                    g.this.gB(1, 3);
                    g.a(g.this, g.this.uGd, str16, null);
                    AppMethodBeat.o(9209);
                }
            });
            AppMethodBeat.o(9795);
            return a;
        } else {
            ab.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
            AppMethodBeat.o(9795);
            return null;
        }
    }

    static /* synthetic */ void eu(g gVar, final i iVar) {
        AppMethodBeat.i(9796);
        if (gVar.context == null) {
            gVar.a(iVar, "chooseIdCard:fail", null);
            AppMethodBeat.o(9796);
            return;
        }
        if (!gVar.uGu.a("identity_pay_auth", gVar.context, new com.tencent.mm.plugin.webview.modeltools.e.a() {
            public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                AppMethodBeat.i(9040);
                if (bitmap == null) {
                    g.a(g.this, iVar, "chooseIdCard:fail", null);
                    AppMethodBeat.o(9040);
                    return;
                }
                try {
                    String str2 = com.tencent.mm.compatible.util.e.eSj + "tmpScanLicense/";
                    ab.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", str2);
                    if (com.tencent.mm.vfs.e.ct(str2)) {
                        com.tencent.mm.vfs.e.N(str2, true);
                    }
                    com.tencent.mm.vfs.e.tf(str2);
                    com.tencent.mm.vfs.e.ate(str2);
                    str2 = str2 + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
                    ab.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", str2);
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, str2, true);
                    WebViewJSSDKFileItem aeu = WebViewJSSDKFileItem.aeu(str2);
                    com.tencent.mm.plugin.webview.modeltools.g.cYF().b(aeu);
                    Map hashMap = new HashMap();
                    hashMap.put("sourceType", "scan");
                    hashMap.put("localId", aeu.czD);
                    g.a(g.this, iVar, "chooseIdCard:ok", hashMap);
                    AppMethodBeat.o(9040);
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgHandler", "save scan license error: %s", e.getMessage());
                    g.a(g.this, iVar, "chooseIdCard:fail", null);
                    AppMethodBeat.o(9040);
                }
            }

            public final void aeT(String str) {
                AppMethodBeat.i(9041);
                g.a(g.this, iVar, "chooseIdCard:cancel", null);
                AppMethodBeat.o(9041);
            }

            public final void BD(String str) {
                AppMethodBeat.i(9042);
                g.a(g.this, iVar, "chooseIdCard:fail", null);
                AppMethodBeat.o(9042);
            }
        })) {
            gVar.a(iVar, "chooseIdCard:fail", null);
        }
        AppMethodBeat.o(9796);
    }

    static /* synthetic */ void ev(g gVar, i iVar) {
        AppMethodBeat.i(9797);
        ab.i("MicroMsg.MsgHandler", "real scene = %d", Integer.valueOf(3));
        ab.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", "")));
        if (com.tencent.mm.pluginsdk.permission.b.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_capture", 3);
            intent.putExtra("key_pick_local_pic_query_source_type", 8);
            intent.putExtra("query_media_type", 1);
            intent.putExtra("key_pick_local_pic_count", 1);
            ab.i("MicroMsg.MsgHandler", "doChooseImageIdCard: realScene: %d, querySourceType: %d", Integer.valueOf(3), Integer.valueOf(8));
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).ifE = gVar;
                com.tencent.mm.bp.d.a(gVar.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 43, false);
            }
            AppMethodBeat.o(9797);
            return;
        }
        gVar.a(iVar, "chooseIdCard:fail", null);
        AppMethodBeat.o(9797);
    }

    static /* synthetic */ void b(g gVar, i iVar, String str, Map map) {
        AppMethodBeat.i(9801);
        if (iVar == null) {
            AppMethodBeat.o(9801);
            return;
        }
        try {
            gVar.uGq.a(iVar.uIG, str, i.aP(map), false);
            AppMethodBeat.o(9801);
        } catch (Exception e) {
            ab.w("MicroMsg.MsgHandler", "callbackWithoutAffectingJsApiQueue, e = %s", e);
            AppMethodBeat.o(9801);
        }
    }
}
