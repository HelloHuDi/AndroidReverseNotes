package com.tencent.p177mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.modelstat.C18691f;
import com.tencent.p177mm.modelstat.p874a.C42218c.C97071;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p1177ao.C17912c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C18235dh;
import com.tencent.p177mm.p230g.p231a.C18238di;
import com.tencent.p177mm.p230g.p231a.C18241dj;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26097bu;
import com.tencent.p177mm.p230g.p231a.C26138fq;
import com.tencent.p177mm.p230g.p231a.C26152hh;
import com.tencent.p177mm.p230g.p231a.C32557fk;
import com.tencent.p177mm.p230g.p231a.C32609ol;
import com.tencent.p177mm.p230g.p231a.C37691an;
import com.tencent.p177mm.p230g.p231a.C37713fn;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C37814vr;
import com.tencent.p177mm.p230g.p231a.C42020la;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45346ng;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p230g.p231a.C6489hv;
import com.tencent.p177mm.p230g.p231a.C6530og;
import com.tencent.p177mm.p230g.p231a.C9306cg;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.p230g.p231a.C9465sc;
import com.tencent.p177mm.p249m.C1766d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C39727a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C22760s;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.plugin.webview.fts.C43869b;
import com.tencent.p177mm.plugin.webview.fts.C43869b.C29767e;
import com.tencent.p177mm.plugin.webview.fts.C43877e;
import com.tencent.p177mm.plugin.webview.model.C14516o;
import com.tencent.p177mm.plugin.webview.model.C14517u;
import com.tencent.p177mm.plugin.webview.model.C14519x;
import com.tencent.p177mm.plugin.webview.model.C22881aj;
import com.tencent.p177mm.plugin.webview.model.C22888d.C22889a;
import com.tencent.p177mm.plugin.webview.model.C22890f;
import com.tencent.p177mm.plugin.webview.model.C22890f.C22891a;
import com.tencent.p177mm.plugin.webview.model.C29821w;
import com.tencent.p177mm.plugin.webview.model.C40252a.C22874b;
import com.tencent.p177mm.plugin.webview.model.C43907af;
import com.tencent.p177mm.plugin.webview.model.C43907af.C14506a;
import com.tencent.p177mm.plugin.webview.model.C43913ao;
import com.tencent.p177mm.plugin.webview.model.C43914ap;
import com.tencent.p177mm.plugin.webview.model.C46423ar;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.modelcache.C14526r;
import com.tencent.p177mm.plugin.webview.modelcache.C14526r.C45565;
import com.tencent.p177mm.plugin.webview.modelcache.C14526r.C4557a;
import com.tencent.p177mm.plugin.webview.modelcache.C29824c;
import com.tencent.p177mm.plugin.webview.modeltools.C14539f;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.webview.modeltools.C40277m;
import com.tencent.p177mm.plugin.webview.modeltools.C46430c;
import com.tencent.p177mm.plugin.webview.modeltools.C46433l;
import com.tencent.p177mm.plugin.webview.modeltools.C46433l.C46432a;
import com.tencent.p177mm.plugin.webview.p1068e.C43866c;
import com.tencent.p177mm.plugin.webview.p1068e.C43866c.C22786a;
import com.tencent.p177mm.plugin.webview.p1325c.C43863a;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewStubCallbackWrapper;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43949n.C35647a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g.C2301690;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C23018g.C23065b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i;
import com.tencent.p177mm.plugin.webview.stub.C22913c.C4566a;
import com.tencent.p177mm.plugin.webview.stub.C29853b.C29854a;
import com.tencent.p177mm.plugin.webview.stub.C46434d.C35624a;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.C46500q;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t.C23347a;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.protocal.C15045c;
import com.tencent.p177mm.protocal.C15045c.C15081g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.adl;
import com.tencent.p177mm.protocal.protobuf.ado;
import com.tencent.p177mm.protocal.protobuf.adp;
import com.tencent.p177mm.protocal.protobuf.anf;
import com.tencent.p177mm.protocal.protobuf.atp;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.protocal.protobuf.beq;
import com.tencent.p177mm.protocal.protobuf.bes;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.view.C31128d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService */
public class WebViewStubService extends Service implements C1202f {
    private List<WebViewStubCallbackWrapper> cAV = new ArrayList();
    private C4884c eFv = new C72132();
    private C7306ak handler;
    private C1923n mwl;
    private Map<String, Integer> uiP;
    private int uqA = -1;
    private final SparseArray<Bundle> uqu = new SparseArray();
    private C35624a uqv = new C72071();
    private int uqw = 0;
    private C11511k uqx;
    private C22889a uqy;
    private Set<Integer> uqz = new HashSet();

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$3 */
    class C45633 implements C11511k {
        C45633() {
        }

        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.m2504i(7194);
            C4990ab.m7416i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(j)));
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    C42911a hv = C2895c.m5147hv(j);
                    bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                    webViewStubCallbackWrapper.uuT.mo26784c(1012, bundle);
                }
                AppMethodBeat.m2505o(7194);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7194);
            }
        }

        /* renamed from: b */
        public final void mo7665b(long j, String str, boolean z) {
            AppMethodBeat.m2504i(7195);
            C4990ab.m7416i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = ".concat(String.valueOf(j)));
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    C42911a hv = C2895c.m5147hv(j);
                    bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                    webViewStubCallbackWrapper.uuT.mo26784c(1002, bundle);
                }
                AppMethodBeat.m2505o(7195);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7195);
            }
        }

        /* renamed from: b */
        public final void mo7664b(long j, int i, boolean z) {
            AppMethodBeat.m2504i(7196);
            C4990ab.m7416i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = ".concat(String.valueOf(j)));
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    C42911a hv = C2895c.m5147hv(j);
                    bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                    bundle.putInt("download_manager_errcode", i);
                    webViewStubCallbackWrapper.uuT.mo26784c(1003, bundle);
                }
                AppMethodBeat.m2505o(7196);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7196);
            }
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.m2504i(7197);
            C4990ab.m7416i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = ".concat(String.valueOf(j)));
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    C42911a hv = C2895c.m5147hv(j);
                    bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                    webViewStubCallbackWrapper.uuT.mo26784c(1008, bundle);
                }
                AppMethodBeat.m2505o(7197);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7197);
            }
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.m2504i(7198);
            C4990ab.m7416i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskPaused, downloadId = ".concat(String.valueOf(j)));
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    C42911a hv = C2895c.m5147hv(j);
                    bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                    webViewStubCallbackWrapper.uuT.mo26784c(1010, bundle);
                }
                AppMethodBeat.m2505o(7198);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7198);
            }
        }

        /* renamed from: gm */
        public final void mo7667gm(long j) {
            AppMethodBeat.m2504i(7199);
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    C42911a hv = C2895c.m5147hv(j);
                    if (hv == null || hv.field_totalSize == 0) {
                        C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = ".concat(String.valueOf(j)));
                        AppMethodBeat.m2505o(7199);
                        return;
                    }
                    int i = (int) ((((double) hv.field_downloadedSize) / ((double) hv.field_totalSize)) * 100.0d);
                    if (i == 0) {
                        i = 1;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    bundle.putInt("download_manager_progress", i);
                    bundle.putString("download_manager_appid", hv.field_appId);
                    webViewStubCallbackWrapper.uuT.mo26784c(1007, bundle);
                }
                AppMethodBeat.m2505o(7199);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7199);
            }
        }

        /* renamed from: i */
        public final void mo7669i(long j, String str) {
            AppMethodBeat.m2504i(7200);
            C4990ab.m7416i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskResumed, downloadId = ".concat(String.valueOf(j)));
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("download_manager_downloadid", j);
                    C42911a hv = C2895c.m5147hv(j);
                    bundle.putCharSequence("download_manager_appid", hv != null ? hv.field_appId : "");
                    webViewStubCallbackWrapper.uuT.mo26784c(1011, bundle);
                }
                AppMethodBeat.m2505o(7200);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                AppMethodBeat.m2505o(7200);
            }
        }

        /* renamed from: gn */
        public final void mo7668gn(long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$4 */
    class C45644 implements C22889a {
        C45644() {
        }

        /* renamed from: a */
        public final void mo9642a(boolean z, int i, int i2, String str, String str2) {
            Bundle bundle;
            AppMethodBeat.m2504i(7201);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
            if (z) {
                try {
                    bundle = new Bundle();
                    bundle.putString("webview_jssdk_file_item_local_id", str);
                    bundle.putInt("webview_jssdk_file_item_progreess", i2);
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        webViewStubCallbackWrapper.uuT.mo26784c(2011, bundle);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e.getMessage());
                }
            }
            switch (i) {
                case 1:
                    if (z) {
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_local_id", str);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : WebViewStubService.this.cAV) {
                                webViewStubCallbackWrapper2.uuT.mo26784c(2003, bundle);
                            }
                            AppMethodBeat.m2505o(7201);
                            return;
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.WebViewStubService", "notify upload image failed :%s", e2.getMessage());
                            AppMethodBeat.m2505o(7201);
                            return;
                        }
                    }
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_server_id", str2);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : WebViewStubService.this.cAV) {
                            webViewStubCallbackWrapper22.uuT.mo26784c(2004, bundle);
                        }
                        AppMethodBeat.m2505o(7201);
                        return;
                    } catch (Exception e22) {
                        C4990ab.m7413e("MicroMsg.WebViewStubService", "notify download image failed :%s", e22.getMessage());
                        AppMethodBeat.m2505o(7201);
                        return;
                    }
                case 2:
                    if (z) {
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_local_id", str);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : WebViewStubService.this.cAV) {
                                webViewStubCallbackWrapper222.uuT.mo26784c(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, bundle);
                            }
                            AppMethodBeat.m2505o(7201);
                            return;
                        } catch (Exception e222) {
                            C4990ab.m7413e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", e222.getMessage());
                            AppMethodBeat.m2505o(7201);
                            return;
                        }
                    }
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_server_id", str2);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : WebViewStubService.this.cAV) {
                            webViewStubCallbackWrapper2222.uuT.mo26784c(TXLiveConstants.PLAY_EVT_PLAY_END, bundle);
                        }
                        AppMethodBeat.m2505o(7201);
                        return;
                    } catch (Exception e2222) {
                        C4990ab.m7413e("MicroMsg.WebViewStubService", "notify download voice failed :%s", e2222.getMessage());
                        AppMethodBeat.m2505o(7201);
                        return;
                    }
                case 4:
                    if (z) {
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_local_id", str);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : WebViewStubService.this.cAV) {
                                webViewStubCallbackWrapper22222.uuT.mo26784c(2010, bundle);
                            }
                            AppMethodBeat.m2505o(7201);
                            return;
                        } catch (Exception e22222) {
                            C4990ab.m7413e("MicroMsg.WebViewStubService", "notify upload video failed :%s", e22222.getMessage());
                            AppMethodBeat.m2505o(7201);
                            return;
                        }
                    }
                    break;
                default:
                    C4990ab.m7413e("MicroMsg.WebViewStubService", "unsupport media type : %d", Integer.valueOf(i));
                    break;
            }
            AppMethodBeat.m2505o(7201);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$a */
    static class C4565a extends C29854a {
        public boolean csN;
        public int ret;
        public int type;
        public boolean uhJ;

        private C4565a() {
        }

        /* synthetic */ C4565a(byte b) {
            this();
        }

        public final boolean cYV() {
            return this.uhJ;
        }

        public final boolean getResult() {
            return this.csN;
        }

        public final int getRet() {
            return this.ret;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$5 */
    class C72045 extends C1924a {
        private final byte[] ecf = new byte[0];

        C72045() {
            AppMethodBeat.m2504i(7202);
            AppMethodBeat.m2505o(7202);
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(7203);
            synchronized (this.ecf) {
                try {
                    String cXS = C30152u.cXS();
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_network_type", cXS);
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        webViewStubCallbackWrapper.uuT.mo26784c(90, bundle);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WebViewStubService", "notify network change failed :%s", e.getMessage());
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(7203);
                    }
                }
            }
            AppMethodBeat.m2505o(7203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$b */
    public static class C7205b extends C4566a {
        public String aIm;
        public int errCode;
        public int errType;
        public Bundle mqu;
        public int type;

        public final int getType() {
            return this.type;
        }

        public final int cYW() {
            return this.errType;
        }

        public final int cYX() {
            return this.errCode;
        }

        public final String adx() {
            return this.aIm;
        }

        public final Bundle getData() {
            return this.mqu;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$1 */
    class C72071 extends C35624a {

        /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$1$6 */
        class C45616 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$1$6$1 */
            class C45621 implements C42206a {
                C45621() {
                }

                /* renamed from: a */
                public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                    AppMethodBeat.m2504i(7110);
                    C4990ab.m7417i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
                    C26443d.agz().mo44208c(this);
                    AppMethodBeat.m2505o(7110);
                    return false;
                }
            }

            C45616() {
            }

            public final void run() {
                AppMethodBeat.m2504i(7111);
                C26443d.agz().mo44204a(new C45621(), true);
                AppMethodBeat.m2505o(7111);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$1$7 */
        class C72097 extends C5039bj<String> {
            C72097() {
                super(1000, null, (byte) 0);
            }

            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(7112);
                if (C1720g.m3531RK()) {
                    Object Yz = C1853r.m3846Yz();
                    AppMethodBeat.m2505o(7112);
                    return Yz;
                }
                String str = "";
                AppMethodBeat.m2505o(7112);
                return str;
            }
        }

        C72071() {
        }

        /* renamed from: r */
        public final void mo15589r(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7113);
            C43863a cYA = C29833g.cYA();
            HashMap hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    cYA.mo69550ar(hashMap);
                    AppMethodBeat.m2505o(7113);
                    return;
                default:
                    C4990ab.m7421w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(7113);
                    return;
            }
        }

        /* renamed from: j */
        public final void mo15582j(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7114);
            C1202f cYC = C29833g.cYC();
            switch (i) {
                case 1:
                    int i2;
                    cYC.ufg.remove(Integer.valueOf(bundle.getInt("webview_id")));
                    C29767e c29767e = cYC.ufm;
                    if (c29767e.egk) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0 || C5046bo.isNullOrNil(c29767e.query)) {
                        C4990ab.m7419v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", c29767e.query);
                    } else {
                        C4990ab.m7419v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", Boolean.valueOf(c29767e.egk), c29767e.query, Boolean.valueOf(c29767e.ctn), Boolean.valueOf(c29767e.sAY), Integer.valueOf(c29767e.mFl));
                        C14423an.m22643a(c29767e.scene, c29767e.query, c29767e.sAY, c29767e.ctn, c29767e.mFl);
                        c29767e.egk = true;
                    }
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", Integer.valueOf(r4));
                    AppMethodBeat.m2505o(7114);
                    return;
                case 3:
                    if (cYC.mEx != null) {
                        ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(cYC.mEx);
                    }
                    C20846i c20846i = new C20846i();
                    c20846i.query = bundle.getString(SearchIntents.EXTRA_QUERY);
                    c20846i.mEt = bundle.getInt("count");
                    c20846i.mEw = cYC.plf;
                    c20846i.mEu.add("notifymessage");
                    cYC.mEx = ((C12029n) C1720g.m3530M(C12029n.class)).search(8, c20846i);
                    cYC.mEx.mDs = Integer.valueOf(bundle.getInt("webview_id"));
                    C22760s c22760s = new C22760s();
                    c22760s.scene = bundle.getInt("scene");
                    c22760s.ctj = bundle.getString(SearchIntents.EXTRA_QUERY);
                    c22760s.tZw = 1;
                    c22760s.cIv = bundle.getInt("webview_id");
                    if (cYC.ufj != null) {
                        C1720g.m3540Rg().mo14547c(cYC.ufj);
                    }
                    cYC.ufj = new C43877e(c22760s);
                    C1720g.m3540Rg().mo14539a(1161, cYC);
                    C1720g.m3540Rg().mo14541a(cYC.ufj, 0);
                    AppMethodBeat.m2505o(7114);
                    return;
                case 5:
                    ((C12029n) C1720g.m3530M(C12029n.class)).deleteSOSHistory(bundle.getString("history"));
                    AppMethodBeat.m2505o(7114);
                    return;
                case 6:
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", bundle.getString("reportString"));
                    bsj bsj = new bsj();
                    bsj.wUu = r0;
                    C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
                    break;
            }
            AppMethodBeat.m2505o(7114);
        }

        /* renamed from: p */
        public final Bundle mo15588p(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7115);
            C29833g.cYC();
            Bundle p = C43869b.m78673p(i, bundle);
            AppMethodBeat.m2505o(7115);
            return p;
        }

        /* renamed from: mJ */
        public final String mo15584mJ(String str) {
            AppMethodBeat.m2504i(7116);
            String Oi = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).mo16706Oi();
            AppMethodBeat.m2505o(7116);
            return Oi;
        }

        /* renamed from: mY */
        public final boolean mo15585mY(String str) {
            AppMethodBeat.m2504i(7117);
            boolean mY = C1855t.m3912mY(str);
            AppMethodBeat.m2505o(7117);
            return mY;
        }

        /* renamed from: nI */
        public final boolean mo15587nI(String str) {
            AppMethodBeat.m2504i(7118);
            boolean nI = C1855t.m3923nI(str);
            AppMethodBeat.m2505o(7118);
            return nI;
        }

        /* renamed from: mZ */
        public final boolean mo15586mZ(String str) {
            AppMethodBeat.m2504i(7119);
            boolean RK = C1720g.m3531RK();
            C4990ab.m7416i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = ".concat(String.valueOf(RK)));
            if (RK) {
                RK = C1855t.m3913mZ(str);
                AppMethodBeat.m2505o(7119);
                return RK;
            }
            AppMethodBeat.m2505o(7119);
            return false;
        }

        /* renamed from: Mn */
        public final boolean mo15523Mn() {
            AppMethodBeat.m2504i(7120);
            boolean Mn = C1445f.m3070Mn();
            AppMethodBeat.m2505o(7120);
            return Mn;
        }

        public final boolean cZd() {
            AppMethodBeat.m2504i(7121);
            boolean RK = C1720g.m3531RK();
            AppMethodBeat.m2505o(7121);
            return RK;
        }

        @Deprecated
        /* renamed from: a */
        public final void mo15526a(final int i, final Bundle bundle, final int i2) {
            AppMethodBeat.m2504i(7122);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", Integer.valueOf(i), Integer.valueOf(i2));
            WebViewStubService.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(7105);
                    int i;
                    int i2;
                    Intent intent;
                    String str;
                    Bundle bundle;
                    switch (i) {
                        case 1:
                            WebViewStubService.m12015a(WebViewStubService.this, 2, bundle, i2);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 2:
                            C23639t.m36492hO(WebViewStubService.this);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 3:
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("stat_scene", 4);
                            C23018g JR = C29944h.m47401JR(i2);
                            if (JR != null) {
                                bundle2.putString("stat_url", JR.getCurrentUrl());
                            }
                            C72071.m12028a(C72071.this, bundle, bundle2);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 4:
                            WebViewStubService.m12015a(WebViewStubService.this, 3, bundle, i2);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 5:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                WebViewStubService.this.uqz.add(Integer.valueOf(i2));
                            }
                            C4990ab.m7417i("MicroMsg.WebViewStubService", "add Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_inc_count[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.uqz.size()), Integer.valueOf(WebViewStubService.this.uqw));
                            if (i > 0) {
                                WebViewStubService.this.uqw = WebViewStubService.this.uqw + 1;
                                C4990ab.m7417i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", Integer.valueOf(i2));
                                C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, WebViewStubService.this);
                                C1720g.m3540Rg().mo14539a(673, WebViewStubService.this);
                                C1720g.m3540Rg().mo14539a(666, WebViewStubService.this);
                                C1720g.m3540Rg().mo14539a(1254, WebViewStubService.this);
                                C1720g.m3540Rg().mo14539a(1373, WebViewStubService.this);
                                AppMethodBeat.m2505o(7105);
                                return;
                            }
                            break;
                        case 6:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                WebViewStubService.this.uqz.remove(Integer.valueOf(i2));
                            }
                            C4990ab.m7417i("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_dec_count:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.uqz.size()), Integer.valueOf(WebViewStubService.this.uqw));
                            if (i > 0) {
                                WebViewStubService.this.uqw = WebViewStubService.this.uqw - 1;
                                if (WebViewStubService.this.uqw < 0) {
                                    C4990ab.m7413e("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set size:[%d], unexpected_count[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.this.uqz.size()), Integer.valueOf(WebViewStubService.this.uqw));
                                    WebViewStubService.this.uqw = 0;
                                }
                                if (WebViewStubService.this.uqw <= 0 && WebViewStubService.this.uqz.size() <= 0) {
                                    C4990ab.m7417i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", Integer.valueOf(i2));
                                    if (C1720g.m3531RK()) {
                                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, WebViewStubService.this);
                                        C1720g.m3540Rg().mo14546b(673, WebViewStubService.this);
                                        C1720g.m3540Rg().mo14546b(666, WebViewStubService.this);
                                        C1720g.m3540Rg().mo14546b(1254, WebViewStubService.this);
                                        C1720g.m3540Rg().mo14546b(1373, WebViewStubService.this);
                                        AppMethodBeat.m2505o(7105);
                                        return;
                                    }
                                }
                            }
                            break;
                        case 7:
                            intent = new Intent();
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
                            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
                            intent.addFlags(268435456);
                            C40211a.gkE.mo38933r(intent, WebViewStubService.this);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 8:
                            intent = new Intent();
                            intent.putExtras(bundle);
                            intent.addFlags(268435456);
                            C40211a.gkE.mo38934s(intent, WebViewStubService.this);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 20:
                            bundle.setClassLoader(getClass().getClassLoader());
                            C29944h.m47401JR(i2).uGh = bundle.getBundle("jsapiargs");
                            str = (String) bundle.getCharSequence("bizofstartfrom");
                            bundle = bundle.getBundle("startwebviewparams");
                            if (!(str == null || bundle == null)) {
                                C42020la c42020la = new C42020la();
                                c42020la.cGS.cGT = str;
                                c42020la.cGS.params = bundle;
                                C4879a.xxA.mo10055m(c42020la);
                            }
                            WebViewStubService.this.uqA = bundle.getInt("screen_orientation", -1);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 21:
                            C29944h.m47401JR(i2).dcv().putAll(bundle);
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 29:
                            str = bundle.getString("srcUsername");
                            C41747z.aeR();
                            C25764e.m40953qU(str);
                            C41747z.aeR();
                            C25764e.m40954qV(str);
                            C41747z.afc();
                            if (!C5046bo.isNullOrNil(str) && C17903f.m28110rd(str)) {
                                C41747z.afc().mo43732a(str, null, 0, null);
                            }
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 30:
                            str = bundle.getString("srcUsername");
                            C41747z.aeR();
                            C25764e.m40955qW(str);
                            C41747z.afc();
                            if (!C5046bo.isNullOrNil(str) && C17903f.m28110rd(str)) {
                                C41747z.afc().mo43731a(str, null);
                            }
                            AppMethodBeat.m2505o(7105);
                            return;
                        case 41:
                            if (C1720g.m3531RK()) {
                                C23018g JR2 = C29944h.m47401JR(i2);
                                bundle = bundle;
                                if (JR2.uGZ != null) {
                                    if (bundle == null || bundle.size() <= 0) {
                                        JR2.mo38616a(JR2.umI, JR2.uGZ, "showKeyboard:fail", null, true, true);
                                    } else {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("text", C5046bo.nullAsNil(bundle.getString("show_kb_input_callback_text")));
                                        JR2.mo38616a(JR2.umI, JR2.uGZ, "showKeyboard:ok", hashMap, true, true);
                                    }
                                    JR2.uGZ = null;
                                    AppMethodBeat.m2505o(7105);
                                    return;
                                }
                            }
                            break;
                        default:
                            C4990ab.m7413e("MicroMsg.WebViewStubService", "not support action code:[%d]", Integer.valueOf(i));
                            break;
                    }
                    AppMethodBeat.m2505o(7105);
                }
            });
            AppMethodBeat.m2505o(7122);
        }

        /* renamed from: Z */
        public final C29853b mo15524Z(Bundle bundle) {
            boolean a;
            AppMethodBeat.m2504i(7123);
            C4565a c4565a = new C4565a();
            long j = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            C45316cl c45316cl = new C45316cl();
            if (Long.MIN_VALUE != j) {
                c45316cl.cvA.cvE = bundle.getInt("message_index", 0);
                a = ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15153a(c45316cl, j);
            } else if (!C5046bo.isNullOrNil(string)) {
                C9465sc c9465sc = new C9465sc();
                c9465sc.cNZ.cOc = string;
                c9465sc.cNZ.cOd = c45316cl;
                c9465sc.cNZ.url = bundle.getString("rawUrl");
                c9465sc.cNZ.cOb = true;
                C4879a.xxA.mo10055m(c9465sc);
                a = c9465sc.cOa.cvi;
            } else if (i != 0) {
                C45346ng c45346ng = new C45346ng();
                c45346ng.cJw.opType = 3;
                c45346ng.cJw.cJy = c45316cl;
                c45346ng.cJw.cJz = i;
                c45346ng.cJw.cJA = string2;
                C4879a.xxA.mo10055m(c45346ng);
                a = c45346ng.cJx.cvi;
            } else {
                c4565a.uhJ = true;
                AppMethodBeat.m2505o(7123);
                return c4565a;
            }
            if (a) {
                string = C5046bo.nullAsNil(bundle.getString("prePublishId"));
                String nW = C37922v.m64078nW(string);
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("sendAppMsgScene", Integer.valueOf(2));
                y.mo53356j("preChatName", bundle.getString("preChatName"));
                y.mo53356j("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                y.mo53356j("prePublishId", string);
                y.mo53356j("preUsername", bundle.getString("preUsername"));
                y.mo53356j("getA8KeyScene", bundle.getString("getA8KeyScene"));
                y.mo53356j("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    y.mo53356j("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                c45316cl.cvA.cvF = nW;
                C4879a.xxA.mo10055m(c45316cl);
            } else {
                if (c45316cl.cvA.cvG == 0) {
                    c45316cl.cvA.cvG = C25738R.string.bop;
                }
                C4879a.xxA.mo10055m(c45316cl);
            }
            c4565a.ret = c45316cl.cvB.ret;
            AppMethodBeat.m2505o(7123);
            return c4565a;
        }

        public final boolean isSDCardAvailable() {
            AppMethodBeat.m2504i(7125);
            boolean isSDCardAvailable = C1720g.m3536RP().isSDCardAvailable();
            AppMethodBeat.m2505o(7125);
            return isSDCardAvailable;
        }

        /* renamed from: gw */
        public final int mo15577gw(int i, int i2) {
            AppMethodBeat.m2504i(7126);
            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(i, null), i2);
            AppMethodBeat.m2505o(7126);
            return a;
        }

        /* renamed from: gx */
        public final void mo15578gx(final int i, final int i2) {
            AppMethodBeat.m2504i(7127);
            WebViewStubService.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(7107);
                    C1720g.m3536RP().mo5239Ry().set(i, Integer.valueOf(i2));
                    AppMethodBeat.m2505o(7107);
                }
            });
            AppMethodBeat.m2505o(7127);
        }

        /* renamed from: bF */
        public final String mo15551bF(int i, String str) {
            AppMethodBeat.m2504i(7128);
            String bc = C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(i, null), str);
            AppMethodBeat.m2505o(7128);
            return bc;
        }

        /* renamed from: s */
        public final boolean mo15590s(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7129);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "doScene, type = %d", Integer.valueOf(i));
            String string;
            C1207m c6681h;
            int i2;
            boolean a;
            switch (i) {
                case C31128d.MIC_PTU_MEISHI /*233*/:
                    if (cZd()) {
                        string = bundle.getString("geta8key_data_req_url");
                        if (!C5046bo.isNullOrNil(bundle.getString("k_share_url"))) {
                            C46423ar.m87442hb(string, bundle.getString("k_share_url"));
                        }
                        if (C5046bo.isNullOrNil(string)) {
                            c6681h = new C6681h(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0));
                        } else {
                            c6681h = new C6681h(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), bundle.getString("geta8key_data_appid"), bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), bundle.getByteArray("k_a8key_cookie"));
                        }
                        c6681h.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        i2 = bundle.getInt("geta8key_data_subscene", -1);
                        if (i2 > 0) {
                            c6681h.mo14919lV(i2);
                        }
                        string = bundle.getString("geta8key_outer_url");
                        if (!C5046bo.isNullOrNil(string)) {
                            c6681h.mo14920tq(string);
                        }
                        a = C1720g.m3540Rg().mo14541a(c6681h, 0);
                        AppMethodBeat.m2505o(7129);
                        return a;
                    }
                    C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.m2505o(7129);
                    return false;
                case 666:
                    if (cZd()) {
                        a = WebViewStubService.m12011Y(bundle);
                        AppMethodBeat.m2505o(7129);
                        return a;
                    }
                    C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.m2505o(7129);
                    return false;
                case 673:
                    if (cZd()) {
                        C1207m c14516o = new C14516o(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height"));
                        c14516o.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        a = C1720g.m3540Rg().mo14541a(c14516o, 0);
                        AppMethodBeat.m2505o(7129);
                        return a;
                    }
                    C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.m2505o(7129);
                    return false;
                case 1254:
                    if (cZd()) {
                        C1207m c29821w = new C29821w(bundle.getString("oauth_url"), bundle.getString("biz_username"), bundle.getInt("scene"));
                        c29821w.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                        a = C1720g.m3540Rg().mo14541a(c29821w, 0);
                        AppMethodBeat.m2505o(7129);
                        return a;
                    }
                    C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.m2505o(7129);
                    return false;
                case 1295:
                    if (!cZd()) {
                        C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                        AppMethodBeat.m2505o(7129);
                        return false;
                    } else if (bundle == null) {
                        AppMethodBeat.m2505o(7129);
                        return false;
                    } else {
                        C4990ab.m7411d("MicroMsg.WebViewReportUtil", "doReportCgi : %s", bundle.getString("ad_report_data_str"));
                        ((C39727a) C1720g.m3528K(C39727a.class)).mo47109i(13791, string, (int) C5046bo.anT());
                        AppMethodBeat.m2505o(7129);
                        return true;
                    }
                case 1373:
                    if (cZd()) {
                        String string2 = bundle.getString("oauth_url");
                        int i3 = bundle.getInt("opt");
                        LinkedList linkedList = new LinkedList(bundle.getStringArrayList(Constants.KEY_SCOPES));
                        StringBuilder stringBuilder = new StringBuilder();
                        int i4 = 0;
                        while (true) {
                            i2 = i4;
                            if (i2 < linkedList.size()) {
                                stringBuilder.append((String) linkedList.get(i2)).append(",");
                                i4 = i2 + 1;
                            } else {
                                C4990ab.m7417i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
                                c6681h = new C14519x(string2, i3, linkedList);
                                c6681h.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
                                a = C1720g.m3540Rg().mo14541a(c6681h, 0);
                                AppMethodBeat.m2505o(7129);
                                return a;
                            }
                        }
                    }
                    C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.m2505o(7129);
                    return false;
                case 2836:
                    if (cZd()) {
                        a = WebViewStubService.m12016a(WebViewStubService.this, bundle);
                        AppMethodBeat.m2505o(7129);
                        return a;
                    }
                    C4990ab.m7420w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    AppMethodBeat.m2505o(7129);
                    return false;
                default:
                    C4990ab.m7413e("MicroMsg.WebViewStubService", "doScene fail, invalid type = %d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(7129);
                    return false;
            }
        }

        public final boolean aeD() {
            AppMethodBeat.m2504i(7130);
            boolean aeD = C17903f.aeD();
            AppMethodBeat.m2505o(7130);
            return aeD;
        }

        /* renamed from: k */
        public final void mo15583k(int i, List<String> list) {
            AppMethodBeat.m2504i(7132);
            C7060h c7060h = C7060h.pYm;
            C7060h.m11802g(i, list);
            AppMethodBeat.m2505o(7132);
        }

        public final String afg(String str) {
            AppMethodBeat.m2504i(7134);
            String x = ((C46500q) C1720g.m3528K(C46500q.class)).mo4550x(WebViewStubService.this, str);
            AppMethodBeat.m2505o(7134);
            return x;
        }

        /* renamed from: dB */
        public final void mo15570dB(String str, int i) {
            AppMethodBeat.m2504i(7135);
            new Bundle().putInt("webview_binder_id", i);
            WebViewStubService.m12015a(WebViewStubService.this, 5, null, i);
            AppMethodBeat.m2505o(7135);
        }

        /* renamed from: Ze */
        public final boolean mo15525Ze() {
            AppMethodBeat.m2504i(7137);
            boolean Ze = C1853r.m3851Ze();
            AppMethodBeat.m2505o(7137);
            return Ze;
        }

        /* renamed from: i */
        public final void mo15580i(String str, boolean z, int i) {
            AppMethodBeat.m2504i(7138);
            C23018g JR = C29944h.m47401JR(i);
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", str);
                JR.eBB = false;
                JR.uGg.add(str);
                if (z) {
                    JR.uGf.add(str);
                }
            }
            AppMethodBeat.m2505o(7138);
        }

        /* renamed from: Ja */
        public final Bundle mo15517Ja(int i) {
            AppMethodBeat.m2504i(7139);
            Bundle dcv = C29944h.m47401JR(i).dcv();
            AppMethodBeat.m2505o(7139);
            return dcv;
        }

        /* renamed from: Jb */
        public final boolean mo15518Jb(int i) {
            AppMethodBeat.m2504i(7140);
            C23018g JR = C29944h.m47401JR(i);
            boolean z = JR.eBB;
            boolean z2 = C7243d.vxr;
            if (z) {
                C4990ab.m7421w("MicroMsg.WebViewStubService", "isBusy(%d), doingFunction = %s", Integer.valueOf(i), JR.uGn);
            } else if (z2 && JR.uGo) {
                C4990ab.m7417i("MicroMsg.WebViewStubService", "isBusy(%d), awaiting proxyUI", Integer.valueOf(i));
                AppMethodBeat.m2505o(7140);
                return true;
            }
            AppMethodBeat.m2505o(7140);
            return z;
        }

        /* renamed from: L */
        public final void mo15522L(String str, String str2, int i) {
            AppMethodBeat.m2504i(7141);
            C29944h.m47401JR(i).dcv().putString(str, str2);
            AppMethodBeat.m2505o(7141);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo15532a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
            boolean z;
            AppMethodBeat.m2504i(7142);
            boolean afe = WebViewStubService.afe(str2);
            C4990ab.m7416i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + afe);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            if ("wcPrivacyPolicyResult".equals(str2)) {
                Bundle bundle3 = (Bundle) WebViewStubService.this.uqu.get(i);
                if (bundle3 != null && bundle3.getBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", false)) {
                    z = false;
                    if (z) {
                        C29945i c29945i = new C29945i();
                        c29945i.type = str;
                        c29945i.uIJ = str2;
                        c29945i.uIG = str3;
                        c29945i.puc = C29945i.m47403aq(bundle2.getBundle("compatParams"));
                        try {
                            c29945i.uIH = new JSONObject(bundle2.getString("rawParams"));
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.WebViewStubService", "get rawParams, e = %s", e);
                        }
                        C40281e c40281e = null;
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                            C40281e c40281e2;
                            if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.f16198id != i) {
                                c40281e2 = c40281e;
                            } else {
                                c40281e2 = webViewStubCallbackWrapper.uuT;
                            }
                            c40281e = c40281e2;
                        }
                        C29944h.m47401JR(i).dcu();
                        C29944h.m47401JR(i).mo38615a(WebViewStubService.this, c40281e, c40281e);
                        z = C29944h.m47401JR(i).mo38620a(c29945i, jsapiPermissionWrapper);
                        C4990ab.m7416i("MicroMsg.WebViewStubService", "handleRet = ".concat(String.valueOf(z)));
                        AppMethodBeat.m2505o(7142);
                        return z;
                    }
                    if (WebViewStubService.m12017a(WebViewStubService.this, str, str2, str3, jsapiPermissionWrapper, bundle2, i)) {
                        C29944h.m47401JR(i).mo38661oc(true);
                    }
                    AppMethodBeat.m2505o(7142);
                    return true;
                }
            }
            z = afe;
            if (z) {
            }
        }

        /* renamed from: a */
        public final void mo15529a(String str, Bundle bundle, int i) {
            AppMethodBeat.m2504i(7143);
            Bundle bundle2 = new Bundle();
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.fromBundle(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i);
            WebViewStubService.m12015a(WebViewStubService.this, 4, bundle2, i);
            AppMethodBeat.m2505o(7143);
        }

        public final void afh(String str) {
            AppMethodBeat.m2504i(7144);
            C40439f bT = C46494g.m87739bT(str, false);
            if (bT != null && C5046bo.isNullOrNil(bT.field_openId)) {
                C4990ab.m7416i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = ".concat(String.valueOf(str)));
                C26152hh c26152hh = new C26152hh();
                c26152hh.cCd.appId = str;
                C4879a.xxA.mo10055m(c26152hh);
            }
            AppMethodBeat.m2505o(7144);
        }

        public final String afi(String str) {
            AppMethodBeat.m2504i(7145);
            C40439f bT = C46494g.m87739bT(str, false);
            if (bT == null) {
                AppMethodBeat.m2505o(7145);
                return null;
            }
            String str2 = bT.field_packageName;
            AppMethodBeat.m2505o(7145);
            return str2;
        }

        /* renamed from: dq */
        public final boolean mo15573dq(String str) {
            AppMethodBeat.m2504i(7146);
            boolean dq = ((C46500q) C1720g.m3528K(C46500q.class)).mo4549dq(str);
            AppMethodBeat.m2505o(7146);
            return dq;
        }

        /* renamed from: ao */
        public final void mo15550ao(int i, int i2, int i3) {
            AppMethodBeat.m2504i(7147);
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i);
            bundle.putInt("proxyui_expired_errcode", i2);
            WebViewStubService.m12015a(WebViewStubService.this, 6, bundle, i3);
            AppMethodBeat.m2505o(7147);
        }

        public final boolean afj(String str) {
            AppMethodBeat.m2504i(7148);
            boolean afj = C25985d.afj(str);
            AppMethodBeat.m2505o(7148);
            return afj;
        }

        /* renamed from: Jc */
        public final void mo15519Jc(int i) {
            AppMethodBeat.m2504i(7149);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "removeCallback, id = %d", Integer.valueOf(i));
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                if (webViewStubCallbackWrapper.f16198id == i) {
                    WebViewStubService.this.cAV.remove(webViewStubCallbackWrapper);
                    AppMethodBeat.m2505o(7149);
                    return;
                }
            }
            WebViewStubService.this.uqu.remove(i);
            AppMethodBeat.m2505o(7149);
        }

        /* renamed from: a */
        public final void mo15528a(C40281e c40281e, int i) {
            AppMethodBeat.m2504i(7150);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", Integer.valueOf(c40281e.hashCode()), Integer.valueOf(i));
            WebViewStubService.this.cAV.add(new WebViewStubCallbackWrapper(c40281e, i));
            C29944h.m47401JR(i);
            AppMethodBeat.m2505o(7150);
        }

        public final String[] cZe() {
            AppMethodBeat.m2504i(7151);
            String O = C26373g.m41965Nv().mo5301O("WebViewConfig", "removeJavascriptInterface");
            if (C5046bo.isNullOrNil(O)) {
                AppMethodBeat.m2505o(7151);
                return null;
            }
            String[] split = O.split(";");
            AppMethodBeat.m2505o(7151);
            return split;
        }

        /* renamed from: aa */
        public final boolean mo15535aa(Bundle bundle) {
            AppMethodBeat.m2504i(7152);
            C9306cg c9306cg = new C9306cg();
            c9306cg.cvt.cvv = bundle.getLong("fav_local_id", -1);
            C4879a.xxA.mo10055m(c9306cg);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", Long.valueOf(c9306cg.cvt.cvv), Boolean.valueOf(c9306cg.cvu.cvi));
            boolean z = c9306cg.cvu.cvi;
            AppMethodBeat.m2505o(7152);
            return z;
        }

        public final String cZf() {
            AppMethodBeat.m2504i(7153);
            String str = (String) C1720g.m3536RP().mo5239Ry().get(-1535680990, null);
            AppMethodBeat.m2505o(7153);
            return str;
        }

        public final String aek(String str) {
            AppMethodBeat.m2504i(7154);
            String aek = C46423ar.aek(str);
            AppMethodBeat.m2505o(7154);
            return aek;
        }

        public final String cZg() {
            AppMethodBeat.m2504i(7155);
            String g = C4988aa.m7402g(WebViewStubService.this.getSharedPreferences(C4996ah.doA(), 0));
            AppMethodBeat.m2505o(7155);
            return g;
        }

        public final String afk(final String str) {
            AppMethodBeat.m2504i(7156);
            boolean RK = C1720g.m3531RK();
            C4990ab.m7416i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = ".concat(String.valueOf(RK)));
            String value;
            if (RK) {
                value = C26373g.m41964Nu().getValue(str);
                AppMethodBeat.m2505o(7156);
                return value;
            }
            value = (String) new C5039bj<String>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(7108);
                    if (C1720g.m3531RK()) {
                        String value = C26373g.m41964Nu().getValue(str);
                        AppMethodBeat.m2505o(7108);
                        return value;
                    }
                    AppMethodBeat.m2505o(7108);
                    return null;
                }
            }.mo10372b(WebViewStubService.this.handler);
            AppMethodBeat.m2505o(7156);
            return value;
        }

        public final void afl(final String str) {
            AppMethodBeat.m2504i(7157);
            boolean RK = C1720g.m3531RK();
            C4990ab.m7416i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = ".concat(String.valueOf(RK)));
            C72035 c72035 = new C5039bj<Void>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(7109);
                    if (C1720g.m3531RK()) {
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(str);
                            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                C26417a.flu.mo20966a(str, "", null);
                                AppMethodBeat.m2505o(7109);
                            } else {
                                C4990ab.m7418v("MicroMsg.WebViewStubService", "triggerGetContact, alias already exist, no need to getcontact");
                                AppMethodBeat.m2505o(7109);
                            }
                        } else {
                            C4990ab.m7418v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                            AppMethodBeat.m2505o(7109);
                        }
                    } else {
                        AppMethodBeat.m2505o(7109);
                    }
                    return null;
                }
            };
            if (RK) {
                c72035.mo10372b(null);
                AppMethodBeat.m2505o(7157);
                return;
            }
            c72035.mo10372b(WebViewStubService.this.handler);
            AppMethodBeat.m2505o(7157);
        }

        /* renamed from: dC */
        public final String mo15571dC(String str, int i) {
            AppMethodBeat.m2504i(7158);
            String aeC;
            switch (i) {
                case 1:
                    aeC = C43914ap.aeC(str);
                    AppMethodBeat.m2505o(7158);
                    return aeC;
                case 2:
                    aeC = C43914ap.aeD(str);
                    AppMethodBeat.m2505o(7158);
                    return aeC;
                default:
                    AppMethodBeat.m2505o(7158);
                    return null;
            }
        }

        public final int afm(String str) {
            AppMethodBeat.m2504i(7159);
            C45316cl c45316cl = new C45316cl();
            ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15151a(c45316cl, 1, str);
            C4879a.xxA.mo10055m(c45316cl);
            int i = c45316cl.cvB.ret;
            AppMethodBeat.m2505o(7159);
            return i;
        }

        public final void favEditTag() {
            AppMethodBeat.m2504i(7160);
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 35;
            C4879a.xxA.mo10055m(c37721gh);
            AppMethodBeat.m2505o(7160);
        }

        /* renamed from: x */
        public final boolean mo15591x(long j, String str) {
            AppMethodBeat.m2504i(7161);
            if (j == Long.MIN_VALUE && str == null) {
                AppMethodBeat.m2505o(7161);
                return false;
            }
            C9321dq c9321dq = new C9321dq();
            if (j != Long.MIN_VALUE) {
                c9321dq.cxc.cvx = j;
            }
            if (str != null) {
                c9321dq.cxc.cwT = str;
            }
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB) {
                AppMethodBeat.m2505o(7161);
                return true;
            }
            if (C1720g.m3531RK() && j != Long.MIN_VALUE) {
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                if (jf.getType() == 49) {
                    boolean kH = C1855t.m3896kH(jf.field_talker);
                    String str2 = jf.field_content;
                    int i = jf.field_isSend;
                    if (kH && str2 != null && i == 0) {
                        str2 = C1829bf.m3763oz(str2);
                    }
                    C8910b me = C8910b.m16064me(str2);
                    boolean o;
                    if (me.type == 3) {
                        o = C46494g.m87754o(C4996ah.getContext(), 16);
                        AppMethodBeat.m2505o(7161);
                        return o;
                    } else if (me.type == 4) {
                        o = C46494g.m87754o(C4996ah.getContext(), 8);
                        AppMethodBeat.m2505o(7161);
                        return o;
                    }
                }
            }
            AppMethodBeat.m2505o(7161);
            return false;
        }

        public final void afn(String str) {
            AppMethodBeat.m2504i(7162);
            if (C5063r.amo(str)) {
                EmojiInfo Jd;
                EmojiInfo Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(C1178g.m2587cz(str));
                if (Jd2 == null || !Jd2.duP()) {
                    C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                    C4996ah.getContext();
                    Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(emojiMgr.mo35598Jf(str));
                } else {
                    Jd = Jd2;
                }
                int cs = Jd == null ? 0 : C1173e.m2560cs(Jd.dve());
                if (Jd != null) {
                    str = Jd.dve();
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                int i;
                if ((C5056d.decodeFile(str, options) == null || options.outHeight <= C42164b.m74339Na()) && options.outWidth <= C42164b.m74339Na()) {
                    i = 0;
                } else {
                    i = true;
                }
                if (cs > C42164b.m74340Nb() || i != 0) {
                    C30379h.m48443a(C4996ah.getContext(), WebViewStubService.this.getString(C25738R.string.b9x), "", WebViewStubService.this.getString(C25738R.string.cd_), null);
                    AppMethodBeat.m2505o(7162);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", Jd == null ? "" : Jd.mo20410Aq());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(268435456);
                C40211a.gkE.mo38926k(intent, WebViewStubService.this);
                AppMethodBeat.m2505o(7162);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", str);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            C40211a.gkE.mo38926k(intent2, WebViewStubService.this);
            AppMethodBeat.m2505o(7162);
        }

        public final String getLanguage() {
            AppMethodBeat.m2504i(7163);
            String gw = C4988aa.m7403gw(C4996ah.getContext());
            AppMethodBeat.m2505o(7163);
            return gw;
        }

        public final String cZh() {
            AppMethodBeat.m2504i(7164);
            C6489hv c6489hv = new C6489hv();
            C4879a.xxA.mo10055m(c6489hv);
            String str = c6489hv.cCO.url;
            AppMethodBeat.m2505o(7164);
            return str;
        }

        public final Map cZi() {
            AppMethodBeat.m2504i(7165);
            C1766d Nf = C26373g.m41965Nv().mo5294Nf();
            if (Nf == null) {
                AppMethodBeat.m2505o(7165);
                return null;
            }
            Map map = Nf.evZ;
            AppMethodBeat.m2505o(7165);
            return map;
        }

        /* renamed from: hf */
        public final String mo15579hf(String str, String str2) {
            return "";
        }

        public final int cZj() {
            AppMethodBeat.m2504i(7166);
            C1720g.m3534RN();
            int QF = C1668a.m3383QF();
            AppMethodBeat.m2505o(7166);
            return QF;
        }

        public final int cZk() {
            AppMethodBeat.m2504i(7167);
            int h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(12304, null));
            AppMethodBeat.m2505o(7167);
            return h;
        }

        public final void cZl() {
            AppMethodBeat.m2504i(7168);
            Intent intent = new Intent();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
            intent.setFlags(268435456);
            intent.putExtra("sns_userName", str);
            intent.addFlags(67108864);
            intent.putExtra("sns_adapter_type", 1);
            C1720g.m3536RP().mo5239Ry().set(68389, Integer.valueOf(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68389, null), 0) + 1));
            intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI");
            WebViewStubService.this.startActivity(intent);
            AppMethodBeat.m2505o(7168);
        }

        public final void cZm() {
            AppMethodBeat.m2504i(7169);
            if (((C1853r.m3829YK() & 32768) == 0) && C25985d.afj("sns")) {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                WebViewStubService.this.startActivity(intent);
            }
            AppMethodBeat.m2505o(7169);
        }

        /* renamed from: IP */
        public final void mo15515IP(int i) {
            Iterator it;
            String str;
            AppMethodBeat.m2504i(7170);
            if (WebViewStubService.this.cAV.size() == 0) {
                C26138fq c26138fq = new C26138fq();
                c26138fq.czB.czE = 2;
                C4879a.xxA.mo10055m(c26138fq);
                C32557fk c32557fk = new C32557fk();
                c32557fk.czf.f1230op = 2;
                C4879a.xxA.mo10055m(c32557fk);
                C37713fn c37713fn = new C37713fn();
                c37713fn.czm.f16119op = 2;
                C4879a.xxA.mo10055m(c37713fn);
            }
            C23018g JR = C29944h.m47401JR(i);
            C4990ab.m7410d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
            JR.uGm = true;
            if (JR.dcC()) {
                WebViewJSSDKFileItem aex = C29833g.cYF().aex(JR.uGP);
                if (aex != null) {
                    C5004al.m7441d(new C2301690(aex));
                }
            }
            Entry entry;
            String str2;
            if ((JR.cZr() == 8 || JR.cZr() == -1) && JR.bFf() != 27) {
                if (JR.cZr() == 8) {
                    if (JR.uGj == null || JR.uGj.isEmpty()) {
                        C4990ab.m7416i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        it = JR.uGj.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                str2 = (String) entry.getKey();
                                str = (String) entry.getValue();
                                C4990ab.m7417i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                                C18241dj c18241dj = new C18241dj();
                                c18241dj.cwE.cwG = str2;
                                c18241dj.cwE.ceI = str;
                                C4879a.xxA.mo10055m(c18241dj);
                                if (!c18241dj.cwF.cwB) {
                                    try {
                                        C18235dh c18235dh = new C18235dh();
                                        c18235dh.cwx.cwA = false;
                                        c18235dh.cwx.cwz = str2;
                                        c18235dh.cwx.ceI = str;
                                        C4879a.xxA.mo10055m(c18235dh);
                                        C4990ab.m7416i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Exception e) {
                                        C4990ab.m7412e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        C4990ab.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        JR.uGj.clear();
                    }
                }
            } else if ((JR.uGk == null || JR.uGk.isEmpty()) && (JR.uGj == null || JR.uGj.isEmpty())) {
                C4990ab.m7416i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (!(JR.uGk == null || JR.uGk.isEmpty())) {
                    for (Entry entry2 : JR.uGk.entrySet()) {
                        C4990ab.m7417i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", (String) entry2.getKey(), (String) entry2.getValue());
                        try {
                            C18238di c18238di = new C18238di();
                            c18238di.cwC.cwA = false;
                            c18238di.cwC.cwz = str2;
                            c18238di.cwC.ceI = str;
                            C4879a.xxA.mo10055m(c18238di);
                            C4990ab.m7416i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Exception e2) {
                            C4990ab.m7412e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            C4990ab.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                        }
                    }
                    JR.uGk.clear();
                }
                if (!(JR.uGj == null || JR.uGj.isEmpty())) {
                    it = JR.uGj.entrySet().iterator();
                    C4990ab.m7417i("MicroMsg.MsgHandler", "Is in hard biz(%b)", Boolean.valueOf(C23018g.m34895Ke(JR.dcB())));
                    if (it != null) {
                        while (it.hasNext()) {
                            entry2 = (Entry) it.next();
                            str2 = (String) entry2.getKey();
                            str = (String) entry2.getValue();
                            C4990ab.m7417i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", str2, str);
                            if (r4) {
                                C18241dj c18241dj2 = new C18241dj();
                                c18241dj2.cwE.cwG = str2;
                                c18241dj2.cwE.ceI = str;
                                C4879a.xxA.mo10055m(c18241dj2);
                                if (c18241dj2.cwF.cwB) {
                                }
                            }
                            try {
                                C18235dh c18235dh2 = new C18235dh();
                                c18235dh2.cwx.cwA = false;
                                c18235dh2.cwx.cwz = str2;
                                c18235dh2.cwx.ceI = str;
                                C4879a.xxA.mo10055m(c18235dh2);
                                C4990ab.m7416i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                            } catch (Exception e22) {
                                C4990ab.m7412e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                C4990ab.printErrStackTrace("MicroMsg.MsgHandler", e22, "", new Object[0]);
                            }
                        }
                    }
                    JR.uGj.clear();
                }
            }
            if (JR.uGl != null) {
                C26417a.flu.mo20969or(JR.uGl);
            }
            C22890f cXv = C22891a.ulU;
            if (C5046bo.m7548ek(cXv.ulR)) {
                C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (C1720g.m3531RK()) {
                List list;
                cXv.ulO = C26373g.m41964Nu().getInt("MMUxAdLog2GSendSize", 20480);
                cXv.ulP = C26373g.m41964Nu().getInt("MMUxAdLog3GSendSize", 30720);
                cXv.ulQ = C26373g.m41964Nu().getInt("MMUxAdLogWifiSendSize", VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
                C4990ab.m7411d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", Integer.valueOf(cXv.ulO), Integer.valueOf(cXv.ulP), Integer.valueOf(cXv.ulQ));
                List<axc> list2 = cXv.ulR;
                if (C5046bo.m7548ek(list2)) {
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    list = null;
                } else {
                    axc axc;
                    int i2;
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (axc axc2 : list2) {
                        stringBuilder.append(axc2.wBd).append(", ");
                    }
                    stringBuilder.append(" }");
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    if (C5046bo.m7525az(cXv.ulT) >= 100 || cXv.ulS <= 0) {
                        cXv.ulT = SystemClock.elapsedRealtime();
                        int i3;
                        if (C5023at.isWifi(C4996ah.getContext())) {
                            i3 = cXv.ulQ;
                            cXv.ulS = i3;
                            i2 = i3;
                        } else if (C5023at.is3G(C4996ah.getContext()) || C5023at.is4G(C4996ah.getContext())) {
                            i3 = cXv.ulP;
                            cXv.ulS = i3;
                            i2 = i3;
                        } else {
                            C5023at.is2G(C4996ah.getContext());
                            i3 = cXv.ulO;
                            cXv.ulS = i3;
                            i2 = i3;
                        }
                    } else {
                        i2 = cXv.ulS;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(list2);
                    LinkedList<List> linkedList2 = new LinkedList();
                    LinkedList linkedList3 = null;
                    int i4 = 0;
                    while (linkedList.size() > 0) {
                        if (i4 <= 0) {
                            linkedList3 = new LinkedList();
                            axc2 = (axc) linkedList.remove();
                            i4 += axc2.wBe.f1226wR.length;
                            linkedList3.add(axc2);
                            linkedList2.add(linkedList3);
                        } else if (((axc) linkedList.peek()).wBe.f1226wR.length + i4 >= i2) {
                            i4 = 0;
                        } else {
                            axc2 = (axc) linkedList.remove();
                            i4 += axc2.wBe.f1226wR.length;
                            linkedList3.add(axc2);
                        }
                    }
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<axc> list3 : linkedList2) {
                        stringBuilder.setLength(0);
                        stringBuilder.append("{ ");
                        for (axc axc22 : list3) {
                            stringBuilder.append(axc22.wBd).append(", ");
                        }
                        stringBuilder.append(" }");
                        C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                        C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    Object list4 = linkedList2;
                }
                if (C5046bo.m7548ek(list4)) {
                    C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list42 : list42) {
                        if (!C5046bo.m7548ek(list42)) {
                            C4990ab.m7410d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            C1720g.m3540Rg().mo14541a(new C14517u(list42), 0);
                        }
                    }
                    cXv.ulR.clear();
                }
            } else {
                C4990ab.m7416i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            }
            if (JR.uGh != null) {
                JR.uGh.setClassLoader(JR.getClass().getClassLoader());
            }
            if (JR.uGh != null) {
                Parcelable parcelable = JR.uGh.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    C32609ol c32609ol = new C32609ol();
                    c32609ol.cKM.cKN = 1;
                    c32609ol.cKM.cKz = snsAdClick;
                    C4879a.xxA.mo10055m(c32609ol);
                }
            }
            str = "";
            if (JR.uGh != null) {
                JR.uGh.setClassLoader(JR.getClass().getClassLoader());
                str = JR.uGh.getString("KoriginUrl");
            }
            C37814vr c37814vr = new C37814vr();
            c37814vr.cSE.clP = str;
            C4879a.xxA.mo10055m(c37814vr);
            if (JR.uGh != null) {
                C37952b n = C37952b.m64172n(JR.uGh);
                if (n != null) {
                    n.update();
                    n.ajK();
                }
            }
            for (String str3 : JR.uGO.keySet()) {
                if (!C5046bo.isNullOrNil(str3)) {
                    C29833g.cYE();
                    C22881aj.m34725yC(str3);
                    C23065b c23065b = (C23065b) JR.uGO.get(str3);
                    if (c23065b != null) {
                        if (c23065b.uIC != null) {
                            C29833g.cYE().mo38474a(c23065b.uIC);
                        }
                        if (c23065b.uGd != null) {
                            JR.mo38617a(c23065b.uGd, "uploadVideo:cancel", null, false);
                        }
                    }
                }
            }
            JR.uGO.clear();
            for (C23347a c23347a : C40490t.dlE()) {
                C4990ab.m7416i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + c23347a.getName());
                c23347a.dbp();
            }
            C40490t.clear();
            C4879a.xxA.mo10053d(JR.qwg);
            C4879a.xxA.mo10053d(JR.qwh);
            C4879a.xxA.mo10053d(JR.uGN);
            C4879a.xxA.mo10053d(JR.uHa);
            if (JR.uGQ != null) {
                C4879a.xxA.mo10053d(JR.uGQ);
            }
            if (JR.hwv != null) {
                C4879a.xxA.mo10053d(JR.hwv);
            }
            if (JR.uGY != null) {
                JR.uGY.dead();
            }
            if (C1720g.m3531RK()) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_IBEACON_SHAKE_IS_RANGING_INTERFACE_BOOLEAN, Boolean.FALSE);
            }
            Editor edit = C4996ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            JR.uGe = null;
            JR.uGM = null;
            JR.mo38631b(JR.uGd, new int[0]);
            JR.uGp = null;
            JR.uGV.clear();
            C14526r cYq = C4557a.uor;
            List list5 = JR.uGR;
            if (!(C18172y.m28611Me() == 0 || !C1720g.m3531RK() || C5046bo.m7548ek(list5))) {
                cYq.aNS().mo10302aa(new C45565(list5));
            }
            C4557a.uor.mo26756IP(JR.cIv);
            C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI, JR.uGr);
            AppMethodBeat.m2505o(7170);
        }

        /* renamed from: dD */
        public final void mo15572dD(String str, int i) {
            AppMethodBeat.m2504i(7171);
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.m12015a(WebViewStubService.this, 8, bundle, i);
            AppMethodBeat.m2505o(7171);
        }

        public final boolean cZn() {
            AppMethodBeat.m2504i(7172);
            boolean YM = C1853r.m3831YM();
            AppMethodBeat.m2505o(7172);
            return YM;
        }

        /* renamed from: a */
        public final void mo15531a(String str, int[] iArr, int i, int i2) {
            AppMethodBeat.m2504i(7173);
            if (WebViewStubService.this.uiP == null) {
                WebViewStubService.this.uiP = new HashMap();
                C4879a.xxA.mo10052c(WebViewStubService.this.eFv);
            }
            C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
            y.mo53356j("key_basescanui_screen_x", Integer.valueOf(i));
            y.mo53356j("key_basescanui_screen_y", Integer.valueOf(i2));
            C45347np c45347np = new C45347np();
            c45347np.cJU.filePath = str;
            if (iArr != null && iArr.length > 0) {
                c45347np.cJU.cJV = new HashSet();
                for (int valueOf : iArr) {
                    c45347np.cJU.cJV.add(Integer.valueOf(valueOf));
                }
            }
            C4879a.xxA.mo10055m(c45347np);
            WebViewStubService.this.uiP.put(str, Integer.valueOf(1));
            AppMethodBeat.m2505o(7173);
        }

        public final void afo(String str) {
            AppMethodBeat.m2504i(7174);
            if (WebViewStubService.this.uiP == null || !WebViewStubService.this.uiP.containsKey(str)) {
                C4990ab.m7413e("MicroMsg.WebViewStubService", "%s is not recognizing", str);
                AppMethodBeat.m2505o(7174);
                return;
            }
            C37691an c37691an = new C37691an();
            c37691an.ctC.filePath = str;
            C4879a.xxA.mo10055m(c37691an);
            WebViewStubService.this.uiP.remove(str);
            AppMethodBeat.m2505o(7174);
        }

        /* renamed from: a */
        public final void mo15530a(String str, String str2, String str3, int i, int i2, Bundle bundle) {
            AppMethodBeat.m2504i(7175);
            if (str == null) {
                AppMethodBeat.m2505o(7175);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(C4996ah.getContext(), WebviewScanImageActivity.class);
            intent.setFlags(872415232);
            intent.putExtra("key_string_for_scan", str);
            intent.putExtra("key_string_for_url", str2);
            intent.putExtra("key_string_for_image_url", str3);
            intent.putExtra("key_codetype_for_scan", i);
            intent.putExtra("key_codeversion_for_scan", i2);
            if (bundle != null) {
                String string = bundle.getString("preUsername");
                String string2 = bundle.getString("preChatName");
                String string3 = bundle.getString("rawUrl");
                String nW = C37922v.m64078nW("WebviewQrCode");
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("preUsername", string);
                y.mo53356j("preChatName", string2);
                y.mo53356j("url", str2);
                y.mo53356j("rawUrl", string3);
                intent.putExtra("img_gallery_session_id", nW);
            }
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(7175);
        }

        public final String afp(String str) {
            AppMethodBeat.m2504i(7176);
            String str2 = "";
            C14827e.aiq(str);
            AppMethodBeat.m2505o(7176);
            return str2;
        }

        public final boolean cZo() {
            AppMethodBeat.m2504i(7177);
            if (C72071.m12029vn("EnableWebviewScanQRCode") == 1) {
                AppMethodBeat.m2505o(7177);
                return true;
            }
            AppMethodBeat.m2505o(7177);
            return false;
        }

        /* renamed from: vn */
        private static int m12029vn(String str) {
            int i = 1;
            AppMethodBeat.m2504i(7178);
            try {
                i = C5046bo.getInt(C26373g.m41964Nu().getValue(str), 1);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(7178);
            return i;
        }

        /* renamed from: Jd */
        public final void mo15520Jd(int i) {
            AppMethodBeat.m2504i(7179);
            C23018g JR = C29944h.m47401JR(i);
            WebViewStubService webViewStubService = WebViewStubService.this;
            JR.uGm = false;
            for (C23347a c23347a : C40490t.dlE()) {
                C4990ab.m7416i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + c23347a.getName());
                c23347a.mo27351ft(webViewStubService);
            }
            JR.uGs = false;
            if (JR.uGh != null) {
                Parcelable parcelable = JR.uGh.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    if (snsAdClick.fQd > 0) {
                        snsAdClick.fQe += C5046bo.m7525az(snsAdClick.fQd);
                        snsAdClick.fQd = 0;
                    }
                }
            }
            AppMethodBeat.m2505o(7179);
        }

        /* renamed from: Je */
        public final void mo15521Je(int i) {
            AppMethodBeat.m2504i(7180);
            C23018g JR = C29944h.m47401JR(i);
            JR.uGm = true;
            for (C23347a c23347a : C40490t.dlE()) {
                C4990ab.m7416i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + c23347a.getName());
                c23347a.dbq();
            }
            if (JR.uGh != null) {
                Parcelable parcelable = JR.uGh.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    ((SnsAdClick) parcelable).fQd = C5046bo.m7588yz();
                }
            }
            AppMethodBeat.m2505o(7180);
        }

        /* renamed from: g */
        public final Bundle mo15575g(int i, Bundle bundle) {
            AppMethodBeat.m2504i(7181);
            Bundle bundle2 = new Bundle();
            String nullAsNil;
            String string;
            Bundle bundle3;
            FileDownloadTaskInfo hm;
            String str;
            int i2;
            Bundle bundle4;
            boolean RK;
            C5141c c5141c;
            int i3;
            Object obj;
            switch (i) {
                case 14:
                    if (bundle == null) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    nullAsNil = C5046bo.nullAsNil(bundle.getString("task_url"));
                    C4990ab.m7417i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", nullAsNil, bundle.getString("task_name"));
                    if (C5046bo.isNullOrNil(nullAsNil)) {
                        C4990ab.m7412e("MicroMsg.WebViewStubService", "download url is null or nil");
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    C2901a c2901a = new C2901a();
                    c2901a.mo7055It(nullAsNil);
                    c2901a.mo7057Iv(string);
                    c2901a.mo7063ga(true);
                    c2901a.mo7069tN(1);
                    C4990ab.m7417i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", Long.valueOf(C2896d.bij().mo7042a(c2901a.kNl)));
                    bundle3 = new Bundle();
                    bundle3.putLong("download_id", r2);
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 15:
                    hm = C2896d.bij().mo7048hm(bundle.getLong("download_id", 0));
                    str = "MicroMsg.WebViewStubService";
                    String str2 = "query download task info, info == null ? %b task state = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(hm == null);
                    if (hm == null) {
                        i2 = 0;
                    } else {
                        i2 = hm.status;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    C4990ab.m7417i(str, str2, objArr);
                    i2 = 0;
                    if (hm != null) {
                        i2 = hm.status;
                    }
                    C4990ab.m7417i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(r2), Integer.valueOf(i2));
                    bundle4 = new Bundle();
                    bundle4.putInt("download_state", i2);
                    AppMethodBeat.m2505o(7181);
                    return bundle4;
                case 16:
                    C4990ab.m7417i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(C2896d.bij().mo7047hl(bundle.getLong("download_id", 0))));
                    bundle4 = new Bundle();
                    bundle4.putBoolean("cancel_result", C2896d.bij().mo7047hl(bundle.getLong("download_id", 0)) > 0);
                    AppMethodBeat.m2505o(7181);
                    return bundle4;
                case 17:
                    hm = C2896d.bij().mo7048hm(bundle.getLong("download_id"));
                    bundle3 = new Bundle();
                    if (hm == null) {
                        C4990ab.m7412e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle3.putBoolean("install_result", false);
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    } else if (hm.status != 3) {
                        C4990ab.m7412e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + hm.status);
                        bundle3.putBoolean("install_result", false);
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    } else if (C1173e.m2561ct(hm.path)) {
                        C35800q.m58697a(WebViewStubService.this, Uri.fromFile(new File(hm.path)), null);
                        bundle3.putBoolean("install_result", true);
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    } else {
                        C4990ab.m7413e("MicroMsg.WebViewStubService", "file not exists : %s", hm.path);
                        bundle3.putBoolean("install_result", false);
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    }
                case 19:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("webview_video_proxy_init", C43913ao.cXP().hasInit);
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 23:
                    RK = C1720g.m3531RK();
                    C72097 c72097 = new C72097();
                    if (RK) {
                        nullAsNil = (String) c72097.mo10372b(null);
                    } else {
                        nullAsNil = (String) c72097.mo10372b(WebViewStubService.this.handler);
                    }
                    bundle4 = new Bundle();
                    bundle4.putString("config_info_username", nullAsNil);
                    AppMethodBeat.m2505o(7181);
                    return bundle4;
                case 24:
                    bundle4 = new Bundle();
                    c5141c = null;
                    try {
                        c5141c = C18624c.abi().mo17131ll(C46430c.uoy);
                    } catch (AssertionFailedError e) {
                        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (C1819b e2) {
                        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (c5141c == null || !c5141c.isValid()) {
                        C4990ab.m7417i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", c5141c);
                        AppMethodBeat.m2505o(7181);
                        return bundle4;
                    }
                    Map dru = c5141c.dru();
                    long j = C5046bo.getLong((String) dru.get("interval"), 0);
                    long anT = C5046bo.anT();
                    C4990ab.m7417i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", Long.valueOf(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null))), Long.valueOf(anT), Long.valueOf(j));
                    if (C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, null)) >= anT) {
                        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        AppMethodBeat.m2505o(7181);
                        return bundle4;
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(j + anT));
                    i3 = C5046bo.getInt((String) dru.get("urlCount"), 0);
                    ArrayList arrayList = new ArrayList(i3);
                    for (i2 = 0; i2 < i3; i2++) {
                        arrayList.add(dru.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                    }
                    bundle4.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    AppMethodBeat.m2505o(7181);
                    return bundle4;
                case 26:
                    C29824c.cYl();
                    bundle3 = new Bundle(1);
                    bundle3.putBoolean("webview_resource_cache_inWhiteList", false);
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 31:
                    if (C1720g.m3531RK()) {
                        c5141c = C18624c.abi().mo17131ll("100036");
                        if (c5141c.isValid()) {
                            Map dru2 = c5141c.dru();
                            bundle4 = new Bundle();
                            i2 = C5046bo.getInt((String) dru2.get("controlFlag"), 0);
                            bundle4.putInt("webview_ad_intercept_control_flag", i2);
                            if (i2 == 0) {
                                C4990ab.m7416i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                                AppMethodBeat.m2505o(7181);
                                return bundle4;
                            }
                            int i4;
                            int i5 = C5046bo.getInt((String) dru2.get("blackListCount"), 0);
                            ArrayList arrayList2 = new ArrayList();
                            for (i4 = 0; i4 < i5; i4++) {
                                nullAsNil = (String) dru2.get("blackList" + (i4 + 1));
                                if (!(C5046bo.isNullOrNil(nullAsNil) || arrayList2.contains(nullAsNil))) {
                                    C4990ab.m7417i("MicroMsg.WebViewStubService", "add black list domin = %s", nullAsNil);
                                    arrayList2.add(nullAsNil);
                                }
                            }
                            i5 = C5046bo.getInt((String) dru2.get("whiteListCount"), 0);
                            ArrayList arrayList3 = new ArrayList();
                            for (i4 = 0; i4 < i5; i4++) {
                                nullAsNil = (String) dru2.get("whiteList" + (i4 + 1));
                                if (!(C5046bo.isNullOrNil(nullAsNil) || arrayList3.contains(nullAsNil))) {
                                    C4990ab.m7417i("MicroMsg.WebViewStubService", "add white list domin = %s", nullAsNil);
                                    arrayList3.add(nullAsNil);
                                }
                            }
                            bundle4.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                            bundle4.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                            AppMethodBeat.m2505o(7181);
                            return bundle4;
                        }
                        C4990ab.m7410d("MicroMsg.WebViewStubService", "test is valid");
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case 50:
                    if (bundle == null) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    string = bundle.getString("data");
                    if (string == null) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    bundle3 = new Bundle();
                    bundle3.putInt("key_biz_type", C17903f.m28104qX(string).field_type);
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 51:
                    try {
                        if (Looper.myLooper() == null) {
                            Looper.prepare();
                        }
                        C7305d.xDG.execute(new C45616());
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.WebViewStubService", e3, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case 71:
                    if (bundle == null) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    nullAsNil = bundle.getString("enterprise_action");
                    bundle4 = new Bundle();
                    if (nullAsNil.equals("enterprise_has_connector")) {
                        String str3 = "enterprise_has_connector";
                        C41747z.aeR();
                        if (C25764e.aev().size() > 0) {
                            RK = true;
                        } else {
                            RK = false;
                        }
                        bundle4.putBoolean(str3, RK);
                    } else if (nullAsNil.equals("enterprise_connectors")) {
                        C41747z.aeR();
                        List aev = C25764e.aev();
                        if (aev != null) {
                            bundle4.putStringArrayList("enterprise_connectors", new ArrayList(aev));
                        }
                    }
                    AppMethodBeat.m2505o(7181);
                    return bundle4;
                case 75:
                    C43913ao cXP = C43913ao.cXP();
                    if (cXP.hasInit) {
                        cXP.umI = null;
                        C43913ao.umH = null;
                        cXP.hasInit = false;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case 76:
                    if (bundle == null) {
                        bundle3 = Bundle.EMPTY;
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    }
                    bundle3 = new Bundle();
                    bundle3.putString("appId", C29944h.m47401JR(bundle.getInt("webview_binder_id")).mo38637bK(C5046bo.nullAsNil(bundle.getString("rawUrl"))));
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case C33294a.CTRL_INDEX /*78*/:
                    bundle2.putBoolean("isOpenForFaceBook", C1853r.m3842YX());
                    break;
                case 80:
                    if (bundle != null) {
                        nullAsNil = bundle.getString("KAppId");
                        string = bundle.getString("shortcut_user_name");
                        i3 = bundle.getInt("webviewui_binder_id");
                        if (!C5046bo.isNullOrNil(nullAsNil) && !C5046bo.isNullOrNil(string)) {
                            WebViewStubService.m12015a(WebViewStubService.this, 10, bundle, i3);
                            break;
                        }
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                    break;
                case 83:
                    WebViewStubService.this.uqA = bundle.getInt("screen_orientation", -1);
                    break;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    if (bundle != null) {
                        i2 = bundle.getInt("game_sourceScene");
                        C9365gt c9365gt = new C9365gt();
                        c9365gt.cBv.actionCode = 5;
                        c9365gt.cBv.scene = i2;
                        C4879a.xxA.mo10055m(c9365gt);
                        break;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case 92:
                    if (bundle != null) {
                        nullAsNil = bundle.getString("game_hv_menu_appid");
                        if (!C5046bo.isNullOrNil(nullAsNil)) {
                            C9367gu c9367gu = new C9367gu();
                            c9367gu.cBw.f2862Cn = 3;
                            c9367gu.cBw.cBy = nullAsNil;
                            C4879a.xxA.mo10055m(c9367gu);
                            bundle2.putString("game_hv_menu_pbcache", c9367gu.cBx.result);
                            break;
                        }
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                    bundle3 = new Bundle();
                    bundle3.putBoolean("is_oauth_native", false);
                    if (!C1720g.m3534RN().mo5161QY()) {
                        C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative account not ready");
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    } else if (C1720g.m3537RQ().eKi.eKC) {
                        C5141c ll = C18624c.abi().mo17131ll("100272");
                        if (ll.isValid()) {
                            Map dru3 = ll.dru();
                            if (dru3 == null) {
                                C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative args == null");
                                AppMethodBeat.m2505o(7181);
                                return bundle3;
                            } else if (dru3.containsKey("isUseNative") && "1".equals(dru3.get("isUseNative"))) {
                                bundle3.putBoolean("is_oauth_native", true);
                                AppMethodBeat.m2505o(7181);
                                return bundle3;
                            } else {
                                C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative not contain the isUseNative key or the value is not 1");
                                AppMethodBeat.m2505o(7181);
                                return bundle3;
                            }
                        }
                        C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "isABTestOauthNative item.isValid is false");
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    } else {
                        C4990ab.m7416i("MicroMsg.OauthAuthorizeLogic", "kernel has not startup done");
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    }
                case 94:
                    bundle3 = C14506a.cXG();
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 96:
                    if (bundle == null) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    Set<String> keySet = bundle.keySet();
                    if (keySet == null) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String nullAsNil2 : keySet) {
                            jSONObject.put(nullAsNil2, bundle.get(nullAsNil2));
                        }
                        C9367gu c9367gu2 = new C9367gu();
                        c9367gu2.cBw.f2862Cn = 4;
                        c9367gu2.cBw.cBy = jSONObject.toString();
                        C4879a.xxA.mo10055m(c9367gu2);
                        break;
                    } catch (JSONException e4) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                case 100:
                    bundle3 = C22874b.cXt();
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 102:
                    if (bundle != null) {
                        bundle2.putBoolean("is_enterprise_username", C17903f.m28107ra(bundle.getString("enterprise_biz_username")));
                        break;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case 103:
                    bundle3 = C35647a.m58499af(bundle);
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 104:
                    bundle3 = new Bundle();
                    C14539f.m22740V(bundle);
                    bundle3.putBoolean("open_result", false);
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 105:
                    if (bundle == null) {
                        bundle3 = new Bundle();
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    }
                    int i6 = bundle.getInt("WebViewShare_BinderID");
                    i3 = bundle.getInt("WebViewShare_type");
                    bundle2 = new Bundle();
                    str = bundle.getString("WebViewShare_wv_url", "");
                    C46432a c46432a = null;
                    C23018g JR;
                    String aef;
                    C46433l c46433l;
                    if (i3 == 1) {
                        JR = C29944h.m47401JR(i6);
                        aef = C30152u.aef(str);
                        c46433l = JR.uGv;
                        if (!c46433l.upC.containsKey(aef) || c46433l.upC.get(aef) == null) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            c46432a = null;
                        } else {
                            c46432a = (C46432a) JR.uGv.upC.get(aef);
                        }
                        bundle2.putBoolean("WebViewShare_reslut", c46432a != null);
                    } else if (i3 == 2) {
                        boolean z;
                        JR = C29944h.m47401JR(i6);
                        aef = C30152u.aef(str);
                        c46433l = JR.uGv;
                        if (!c46433l.upD.containsKey(aef) || c46433l.upD.get(aef) == null) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            c46432a = null;
                        } else {
                            c46432a = (C46432a) JR.uGv.upD.get(aef);
                        }
                        aef = "WebViewShare_reslut";
                        if (c46432a != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bundle2.putBoolean(aef, z);
                    }
                    if (c46432a != null) {
                        bundle2.putString("link", c46432a.link);
                        bundle2.putString("title", c46432a.title);
                        bundle2.putString("desc", c46432a.desc);
                        bundle2.putString("img_url", c46432a.rid);
                    }
                    AppMethodBeat.m2505o(7181);
                    return bundle2;
                case 106:
                    c5141c = C18624c.abi().mo17131ll("100484");
                    if (!c5141c.isValid()) {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    } else if ("1".equals(c5141c.dru().get("closeDelayInject"))) {
                        bundle3 = new Bundle();
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    } else {
                        AppMethodBeat.m2505o(7181);
                        return null;
                    }
                case 108:
                    C4879a.xxA.mo10055m(new C26097bu());
                    AppMethodBeat.m2505o(7181);
                    return null;
                case 109:
                    if (bundle == null) {
                        bundle3 = new Bundle();
                        AppMethodBeat.m2505o(7181);
                        return bundle3;
                    }
                    C22786a c22786a;
                    i2 = bundle.getInt("WebViewShare_BinderID");
                    string = bundle.getString("WebViewShare_wv_url", "");
                    C23018g JR2 = C29944h.m47401JR(i2);
                    string = C30152u.aef(string);
                    C43866c c43866c = JR2.uGw;
                    if (!c43866c.uKV.containsKey(string) || c43866c.uKV.get(string) == null) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        c22786a = null;
                    } else {
                        c22786a = JR2.uGw.agE(string);
                    }
                    bundle4 = new Bundle();
                    if (c22786a != null) {
                        bundle4.putInt("key_hao_kan_permission", c22786a.permission);
                        bundle4.putInt("key_hao_kan_recommand", c22786a.uKW);
                        bundle4.putString("key_hao_kan_title", c22786a.title);
                    }
                    AppMethodBeat.m2505o(7181);
                    return bundle4;
                case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                    i3 = bundle.getInt("webview_instance_id");
                    C40281e c40281e = null;
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        C40281e c40281e2;
                        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.f16198id != i3) {
                            c40281e2 = c40281e;
                        } else {
                            c40281e2 = webViewStubCallbackWrapper.uuT;
                        }
                        c40281e = c40281e2;
                    }
                    C29944h.m47401JR(i3).mo38614a(WebViewStubService.this, c40281e);
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", Integer.valueOf(bundle.getInt("scene")));
                    hashMap.put("webview_instance_id", Integer.valueOf(i3));
                    C29833g.cYC().mo69560aw(hashMap);
                    break;
                case 131:
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("logString", bundle.getString("logString"));
                    C43869b cYC = C29833g.cYC();
                    obj = C46400aa.m87342t(hashMap2, "logString");
                    HashMap hashMap3 = new HashMap();
                    if (!obj.contains("h5version=")) {
                        hashMap3.put("h5version", Integer.valueOf(C46400aa.m87305HV(0)));
                    }
                    if (hashMap3.keySet().size() > 0) {
                        if (obj.length() > 0) {
                            obj = obj + "&" + C46400aa.m87329an(hashMap3);
                        } else {
                            obj = C46400aa.m87329an(hashMap3);
                        }
                    }
                    hashMap2.put("logString", obj);
                    cYC.mo69562ay(hashMap2);
                    break;
                case 204:
                    if (bundle != null) {
                        try {
                            bundle.setClassLoader(getClass().getClassLoader());
                            if (bundle.getStringArrayList("reportAdH5Load") != null) {
                                ArrayList stringArrayList = bundle.getStringArrayList("reportAdH5Load");
                                C6530og c6530og = new C6530og();
                                c6530og.cKA.cKz = (SnsAdClick) bundle.getParcelable("snsAdClick");
                                c6530og.cKA.url = C18178q.encode((String) stringArrayList.get(0), "UTF-8");
                                c6530og.cKA.cKB = C5046bo.ank((String) stringArrayList.get(1));
                                c6530og.cKA.timestamp = C5046bo.anl((String) stringArrayList.get(2));
                                c6530og.cKA.errorCode = bundle.getInt("errCode", 0);
                                C4879a.xxA.mo10055m(c6530og);
                                break;
                            }
                        } catch (Exception e32) {
                            C4990ab.m7413e("MicroMsg.WebViewStubService", "report sns ad exception, %s", e32.getMessage());
                            break;
                        }
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                    break;
                case 250:
                    if (bundle != null) {
                        if (bundle != null) {
                            try {
                                C7305d.post(new C97071(bundle), "web_call_rpt");
                                break;
                            } catch (Exception e322) {
                                C4990ab.printErrStackTrace("MicroMsg.WebViewStubService", e322, "webview call back mm error", new Object[0]);
                                break;
                            }
                        }
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                    break;
                case 251:
                    if (bundle != null) {
                        C18691f.akh().mo33961u(WebViewUI.class.getName(), bundle.getLong("key_activity_browse_time", 0));
                        break;
                    }
                    AppMethodBeat.m2505o(7181);
                    return null;
                case WearableStatusCodes.DUPLICATE_CAPABILITY /*4006*/:
                    bundle3 = new Bundle();
                    string = C4996ah.doC().getString("nfc_open_url", null);
                    C4990ab.m7416i("MicroMsg.WebViewStubService", "nfc url=" + C5046bo.nullAsNil(string));
                    if (!(C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string.trim()))) {
                        bundle3.putString("debugConfig", string);
                    }
                    bundle3.putString("config", String.valueOf(C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null)));
                    AppMethodBeat.m2505o(7181);
                    return bundle3;
                case 10001:
                    StringBuilder stringBuilder = new StringBuilder("kwid_");
                    C1720g.m3534RN();
                    C45445b.fpE = stringBuilder.append(C1668a.m3383QF()).append("_").append(C5046bo.anU()).toString();
                    C4990ab.m7419v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", C45445b.fpE);
                    break;
                case 100000:
                    c5141c = C18624c.abi().mo17131ll("100248");
                    if (c5141c.isValid()) {
                        if (C5046bo.getInt((String) c5141c.dru().get("isForceSync"), 0) == 1) {
                            C4990ab.m7411d("MicroMsg.ConfigListDecoder", "host list = %s", C26373g.m41965Nv().mo5301O("WebViewConfig", "forceSyncA8KeyHostPath"));
                            bundle2.putString("force_geta8key_host_path", nullAsNil2);
                            break;
                        }
                    }
                    C4990ab.m7410d("MicroMsg.WebViewStubService", "force geta8key abtest is not invaild");
                    AppMethodBeat.m2505o(7181);
                    return null;
                    break;
                default:
                    C4990ab.m7413e("MicroMsg.WebViewStubService", "unknown action = %d", Integer.valueOf(i));
                    break;
            }
            AppMethodBeat.m2505o(7181);
            return bundle2;
        }

        public final boolean cZp() {
            AppMethodBeat.m2504i(7182);
            C1720g.m3534RN();
            if (!C1668a.m3395QX() || C1668a.m3393QT()) {
                AppMethodBeat.m2505o(7182);
                return true;
            }
            AppMethodBeat.m2505o(7182);
            return false;
        }

        /* renamed from: aB */
        public final void mo15534aB(Intent intent) {
            AppMethodBeat.m2504i(7183);
            Intent intent2 = new Intent(WebViewStubService.this, WebViewStubProxyUI.class);
            intent2.putExtra("proxyui_action_code_key", 9);
            intent2.putExtra("proxyui_next_intent_key", intent);
            intent2.setFlags(268435456);
            WebViewStubService.this.startActivity(intent2);
            AppMethodBeat.m2505o(7183);
        }

        /* renamed from: J */
        public final void mo15516J(int i, String str, String str2) {
            AppMethodBeat.m2504i(7184);
            WebViewJSSDKFileItem I = WebViewJSSDKFileItem.m22709I(i, str, str2);
            I.het = false;
            C29833g.cYF().mo48046b(I);
            C29833g.cYE().mo38479b(null, I.czD, null);
            AppMethodBeat.m2505o(7184);
        }

        public final List<String> cZq() {
            C40277m cYG;
            AppMethodBeat.m2504i(7185);
            if (C1720g.m3531RK()) {
                C29833g.cYz();
                cYG = C29833g.cYG();
            } else {
                cYG = null;
            }
            if (cYG == null) {
                ArrayList arrayList = new ArrayList();
                AppMethodBeat.m2505o(7185);
                return arrayList;
            }
            List<String> arrayList2 = new ArrayList(cYG.cYN());
            AppMethodBeat.m2505o(7185);
            return arrayList2;
        }

        /* renamed from: a */
        public final void mo15527a(Bundle bundle, int i) {
            AppMethodBeat.m2504i(7186);
            WebViewStubService.this.uqu.put(i, bundle);
            AppMethodBeat.m2505o(7186);
        }

        public final int cZr() {
            AppMethodBeat.m2504i(7187);
            int cZr = C14991i.cZr();
            AppMethodBeat.m2505o(7187);
            return cZr;
        }

        public final boolean cZs() {
            AppMethodBeat.m2504i(7188);
            if (C72071.m12029vn("WebViewDownLoadFileSwitch") == 1) {
                AppMethodBeat.m2505o(7188);
                return true;
            }
            AppMethodBeat.m2505o(7188);
            return false;
        }

        public final String[] cZt() {
            AppMethodBeat.m2504i(7189);
            String O = C26373g.m41965Nv().mo5301O("AsyncCheckUrl", "UrlHost");
            if (C5046bo.isNullOrNil(O)) {
                AppMethodBeat.m2505o(7189);
                return null;
            }
            String[] split = O.split(";");
            AppMethodBeat.m2505o(7189);
            return split;
        }

        public final String aff(String str) {
            AppMethodBeat.m2504i(7124);
            String pX = C41730b.m73505pX(str);
            AppMethodBeat.m2505o(7124);
            return pX;
        }

        public final List<String> aeC() {
            AppMethodBeat.m2504i(7131);
            List<String> aeC = C17903f.aeC();
            LinkedList linkedList = new LinkedList();
            for (String str : aeC) {
                if (!C17903f.m28107ra(str)) {
                    linkedList.add(str);
                }
            }
            AppMethodBeat.m2505o(7131);
            return linkedList;
        }

        /* renamed from: a */
        public final boolean mo15533a(String str, boolean z, Bundle bundle) {
            AppMethodBeat.m2504i(7133);
            boolean a = C23257a.vax.mo52972a(WebViewStubService.this, str, z, bundle);
            AppMethodBeat.m2505o(7133);
            return a;
        }

        /* renamed from: bG */
        public final void mo15552bG(String str, boolean z) {
            AppMethodBeat.m2504i(7136);
            C23257a.vax.mo52971a(WebViewStubService.this, str, z);
            AppMethodBeat.m2505o(7136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$2 */
    class C72132 extends C4884c<C18346nr> {
        C72132() {
            AppMethodBeat.m2504i(7191);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(7191);
        }

        /* renamed from: a */
        private boolean m12073a(C18346nr c18346nr) {
            AppMethodBeat.m2504i(7192);
            if (!(c18346nr instanceof C18346nr)) {
                AppMethodBeat.m2505o(7192);
            } else if (WebViewStubService.this.uiP == null || WebViewStubService.this.uiP.containsKey(c18346nr.cJX.filePath)) {
                if (WebViewStubService.this.uiP != null) {
                    WebViewStubService.this.uiP.remove(c18346nr.cJX.filePath);
                }
                C4990ab.m7410d("MicroMsg.WebViewStubService", "result: " + c18346nr.cJX.result);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.cAV) {
                        webViewStubCallbackWrapper.uuT.mo6225e(c18346nr.cJX.filePath, c18346nr.cJX.result, c18346nr.cJX.cvn, c18346nr.cJX.cvo);
                    }
                } catch (RemoteException e) {
                    C4990ab.printErrStackTrace("MicroMsg.WebViewStubService", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(7192);
            } else {
                AppMethodBeat.m2505o(7192);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebViewStubService$8 */
    class C72148 implements C1224a {
        C72148() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(7206);
            C4990ab.m7417i("MicroMsg.WebViewStubService", "ServiceClick CGI return, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                AppMethodBeat.m2505o(7206);
            } else {
                C4990ab.m7413e("MicroMsg.WebViewStubService", "ServiceClick CGI fail, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(7206);
            }
            return 0;
        }
    }

    public WebViewStubService() {
        AppMethodBeat.m2504i(7207);
        AppMethodBeat.m2505o(7207);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(7208);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new C7306ak();
        this.uqx = new C45633();
        C2896d.bij();
        C2886b.m5129a(this.uqx);
        this.uqy = new C45644();
        this.mwl = new C72045();
        C1720g.m3535RO().mo5187a(this.mwl);
        if (C1720g.m3531RK()) {
            C29833g.cYE().mo38473a(this.uqy);
        }
        AppMethodBeat.m2505o(7208);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(7209);
        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        C35624a c35624a = this.uqv;
        AppMethodBeat.m2505o(7209);
        return c35624a;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(7210);
        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        C29944h.detach();
        C46423ar.clear();
        C4557a.uor.release(false);
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(7210);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7211);
        C4990ab.m7416i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        C2896d.bij();
        C2886b.m5130b(this.uqx);
        if (C1720g.m3531RK()) {
            C29833g.cYE().mo38477b(this.uqy);
        }
        C1720g.m3535RO().mo5188b(this.mwl);
        this.mwl = null;
        this.uqx = null;
        this.cAV.clear();
        AppMethodBeat.m2505o(7211);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(7212);
        int type = c1207m.getType();
        C4990ab.m7417i("MicroMsg.WebViewStubService", "onSceneEnd :[%d], errCode = %d, errType = %d, errMsg = %s", Integer.valueOf(type), Integer.valueOf(i2), Integer.valueOf(i), str);
        Bundle bundle;
        Bundle bundle2;
        String str2;
        int i3;
        String str3;
        C7205b c7205b;
        if (type == 106) {
            C1720g.m3540Rg().mo14546b(106, (C1202f) this);
            if (i == 0 && i2 == 0) {
                buv bOj = ((C12518f) c1207m).bOj();
                String a = C1946aa.m4148a(bOj.wcB);
                C17884o.acd().mo67506n(a, C1946aa.m4150a(bOj.vEF));
                Intent intent = new Intent();
                ((C32250j) C1720g.m3528K(C32250j.class)).mo20992a(intent, bOj, 30);
                if (C5046bo.nullAsNil(a).length() > 0) {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(a);
                    if (!(aoO == null || C7486a.m12942jh(aoO.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((bOj.wBT & 8) > 0) {
                        C7060h.pYm.mo8374X(10298, a + ",30");
                    }
                    intent.addFlags(268435456);
                    C40211a.gkE.mo38912c(intent, this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.cAV) {
                            C7205b c7205b2 = new C7205b();
                            c7205b2.type = type;
                            c7205b2.errType = i;
                            c7205b2.errCode = i2;
                            c7205b2.aIm = str;
                            c7205b2.mqu = bundle;
                            c7205b2.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.f16198id);
                            webViewStubCallbackWrapper.uuT.mo26780a(c7205b2);
                        }
                        AppMethodBeat.m2505o(7212);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(7212);
                return;
            }
            C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
            AppMethodBeat.m2505o(7212);
        } else if (type == C31128d.MIC_PTU_MEISHI && (c1207m instanceof C6681h)) {
            C6681h c6681h = (C6681h) c1207m;
            bundle2 = new Bundle();
            byte[] aiW = c6681h.aiW();
            if (aiW == null || aiW.length <= 0) {
                C4990ab.m7412e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            str2 = "geta8key_result_jsapi_perm_control_bytes";
            if (aiW == null) {
                aiW = null;
            }
            bundle2.putByteArray(str2, aiW);
            adl adl = ((adp) c6681h.ehh.fsH.fsP).wlB;
            bundle2.putInt("geta8key_result_general_ctrl_b1", adl == null ? 0 : adl.wli);
            bundle2.putInt("geta8key_result_reason", ((ado) c6681h.ehh.fsG.fsP).vIw);
            bundle2.putString("geta8key_result_req_url", c6681h.aiU());
            bundle2.putString("geta8key_result_full_url", c6681h.aiT());
            bundle2.putString("geta8key_result_title", c6681h.getTitle());
            bundle2.putInt("geta8key_result_action_code", c6681h.aiV());
            bundle2.putString("geta8key_result_content", c6681h.getContent());
            bundle2.putString("geta8key_result_head_img", ((adp) c6681h.ehh.fsH.fsP).wlK);
            bundle2.putString("geta8key_result_wording", ((adp) c6681h.ehh.fsH.fsP).nzz);
            bundle2.putLong("geta8key_result_deep_link_bit_set", c6681h.aiZ());
            bundle2.putString("geta8key_data_username", ((adp) c6681h.ehh.fsH.fsP).jBB);
            bundle2.putByteArray("geta8key_result_cookie", c6681h.ajc());
            bundle2.putString("geta8key_result_menu_wording", ((adp) c6681h.ehh.fsH.fsP).wlL);
            C4990ab.m7411d("MicroMsg.WebViewStubService", "getA8KeyCookie:%s", C5046bo.m7543cd(c6681h.ajc()));
            List<atp> aja = c6681h.aja();
            if (!C5046bo.m7548ek(aja)) {
                atp atp;
                Object obj;
                for (atp atp2 : aja) {
                    if (atp2 != null && !C5046bo.isNullOrNil(atp2.vMU)) {
                        if (C5046bo.isNullOrNil(atp2.pXM)) {
                            C4990ab.m7412e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[aja.size()];
                    String[] strArr2 = new String[aja.size()];
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= aja.size()) {
                            break;
                        }
                        atp2 = (atp) aja.get(i3);
                        C4990ab.m7417i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", Integer.valueOf(i3), atp2.vMU, atp2.pXM);
                        strArr[i3] = r9;
                        strArr2[i3] = str3;
                        i4 = i3 + 1;
                    }
                    bundle2.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle2.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle2.putSerializable("geta8key_result_scope_list", c6681h.aiY());
            C4990ab.m7417i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", c6681h.aiX(), c6681h.aiT(), c6681h.aiU(), Boolean.TRUE);
            if (C5046bo.isNullOrNil(c6681h.aiX())) {
                C4990ab.m7413e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", c6681h.aiT(), c6681h.aiU());
            } else {
                C46423ar.m87442hb(c6681h.aiT(), c6681h.aiX());
            }
            try {
                if (c6681h.tag != null) {
                    i3 = ((Integer) c6681h.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.cAV) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper2.f16198id) {
                        c7205b = new C7205b();
                        c7205b.type = type;
                        c7205b.errType = i;
                        c7205b.errCode = i2;
                        c7205b.aIm = str;
                        c7205b.mqu = bundle2;
                        c7205b.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.f16198id);
                        webViewStubCallbackWrapper2.uuT.mo26780a(c7205b);
                    } else {
                        C4990ab.m7411d("MicroMsg.WebViewStubService", "geta8key hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper2.f16198id));
                    }
                }
                AppMethodBeat.m2505o(7212);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e2));
                AppMethodBeat.m2505o(7212);
            }
        } else if (type == 673) {
            C14516o c14516o = (C14516o) c1207m;
            bundle2 = new Bundle();
            str2 = "reading_mode_result_url";
            if (c14516o.ehh == null) {
                str3 = null;
            } else {
                str3 = ((anf) c14516o.ehh.fsH.fsP).URL;
            }
            bundle2.putString(str2, str3);
            try {
                if (c14516o.tag != null) {
                    i3 = ((Integer) c14516o.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.cAV) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper22.f16198id) {
                        c7205b = new C7205b();
                        c7205b.type = type;
                        c7205b.errType = i;
                        c7205b.errCode = i2;
                        c7205b.aIm = str;
                        c7205b.mqu = bundle2;
                        c7205b.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.f16198id);
                        webViewStubCallbackWrapper22.uuT.mo26780a(c7205b);
                    } else {
                        C4990ab.m7411d("MicroMsg.WebViewStubService", " get readingmodeinfo, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper22.f16198id));
                    }
                }
                AppMethodBeat.m2505o(7212);
            } catch (Exception e22) {
                C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e22));
                AppMethodBeat.m2505o(7212);
            }
        } else if (type == 666) {
            C17912c c17912c = (C17912c) c1207m;
            bundle2 = new Bundle();
            bundle2.putString("emoji_stroe_product_id", c17912c.agd().ProductID);
            if (i == 0 && i2 == 0) {
                str3 = bundle2.getString("emoji_stroe_product_id");
                C4990ab.m7417i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", str3);
                if (!C5046bo.isNullOrNil(str3)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", str3);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    C25985d.m41467b((Context) this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                if (c17912c.tag != null) {
                    i3 = ((Integer) c17912c.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.cAV) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper222.f16198id) {
                        c7205b = new C7205b();
                        c7205b.type = type;
                        c7205b.errType = i;
                        c7205b.errCode = i2;
                        c7205b.aIm = str;
                        c7205b.mqu = bundle2;
                        c7205b.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.f16198id);
                        webViewStubCallbackWrapper222.uuT.mo26780a(c7205b);
                    } else {
                        C4990ab.m7411d("MicroMsg.WebViewStubService", "jumpEmojiDetail, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper222.f16198id));
                    }
                }
                AppMethodBeat.m2505o(7212);
            } catch (Exception e222) {
                C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e222.getMessage());
                AppMethodBeat.m2505o(7212);
            }
        } else if (type == 1254) {
            try {
                int intValue;
                C29821w c29821w = (C29821w) c1207m;
                if (c29821w.tag != null) {
                    intValue = ((Integer) c29821w.tag).intValue();
                } else {
                    intValue = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper3 : this.cAV) {
                    if (intValue == 0 || intValue == webViewStubCallbackWrapper3.f16198id) {
                        Bundle bundle3;
                        C7205b c7205b3 = new C7205b();
                        c7205b3.type = type;
                        c7205b3.errType = i;
                        c7205b3.errCode = i2;
                        c7205b3.aIm = str;
                        Bundle bundle4 = new Bundle();
                        if (i != 0 || i2 != 0) {
                            bundle3 = bundle4;
                        } else if (c1207m instanceof C29821w) {
                            bes bes = (bes) ((C29821w) c1207m).ehh.fsH.fsP;
                            bundle4.putString("oauth_url", ((C29821w) c1207m).umb);
                            bundle4.putSerializable("scope_list", C43907af.m78751aA(bes.wIK));
                            bundle4.putString("appname", bes.fhH);
                            bundle4.putString("appicon_url", bes.wIL);
                            bundle4.putString("redirect_url", bes.vGi);
                            bundle4.putBoolean("is_recent_has_auth", bes.wIM);
                            bundle4.putBoolean("is_silence_auth", bes.wIN);
                            bundle4.putBoolean("is_call_server_when_confirm", bes.wIO);
                            bundle3 = bundle4;
                        } else {
                            bundle3 = bundle4;
                        }
                        c7205b3.mqu = bundle3;
                        c7205b3.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper3.f16198id);
                        webViewStubCallbackWrapper3.uuT.mo26780a(c7205b3);
                    } else {
                        C4990ab.m7411d("MicroMsg.WebViewStubService", "authorize, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue), Integer.valueOf(webViewStubCallbackWrapper3.f16198id));
                    }
                }
                AppMethodBeat.m2505o(7212);
            } catch (Exception e2222) {
                C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeReq fail, ex = " + Log.getStackTraceString(e2222));
                AppMethodBeat.m2505o(7212);
            }
        } else {
            if (type == 1373) {
                try {
                    int intValue2;
                    C14519x c14519x = (C14519x) c1207m;
                    if (c14519x.tag != null) {
                        intValue2 = ((Integer) c14519x.tag).intValue();
                    } else {
                        intValue2 = 0;
                    }
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.cAV) {
                        if (intValue2 == 0 || intValue2 == webViewStubCallbackWrapper2222.f16198id) {
                            C7205b c7205b4 = new C7205b();
                            c7205b4.type = type;
                            c7205b4.errType = i;
                            c7205b4.errCode = i2;
                            c7205b4.aIm = str;
                            bundle2 = new Bundle();
                            if (i != 0 || i2 != 0) {
                                bundle = bundle2;
                            } else if (c1207m instanceof C14519x) {
                                bundle2.putString("redirect_url", ((beq) ((C14519x) c1207m).ehh.fsH.fsP).vGi);
                                bundle = bundle2;
                            } else {
                                bundle = bundle2;
                            }
                            c7205b4.mqu = bundle;
                            c7205b4.mqu.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2222.f16198id);
                            webViewStubCallbackWrapper2222.uuT.mo26780a(c7205b4);
                        } else {
                            C4990ab.m7411d("MicroMsg.WebViewStubService", "authorizeconfirm, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue2), Integer.valueOf(webViewStubCallbackWrapper2222.f16198id));
                        }
                    }
                    AppMethodBeat.m2505o(7212);
                    return;
                } catch (Exception e22222) {
                    C4990ab.m7412e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeConfirmReq fail, ex = " + Log.getStackTraceString(e22222));
                }
            }
            AppMethodBeat.m2505o(7212);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m12015a(WebViewStubService webViewStubService, int i, Bundle bundle, int i2) {
        AppMethodBeat.m2504i(7213);
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.cAV) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.f16198id != i2) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.uuT == null) {
            AppMethodBeat.m2505o(7213);
            return;
        }
        final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", i);
        intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
        intent.putExtra("webview_binder_id", i2);
        intent.putExtra("screen_orientation", webViewStubService.uqA);
        intent.addFlags(268435456);
        C29916g.m47393a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.uuT, new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7205);
                WebViewStubService.this.startActivity(intent);
                AppMethodBeat.m2505o(7205);
            }
        });
        AppMethodBeat.m2505o(7213);
    }

    /* renamed from: Y */
    static /* synthetic */ boolean m12011Y(Bundle bundle) {
        AppMethodBeat.m2504i(7214);
        C1207m c17912c = new C17912c(bundle.getString("emoji_store_jump_url"));
        c17912c.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
        boolean a = C1720g.m3540Rg().mo14541a(c17912c, 0);
        AppMethodBeat.m2505o(7214);
        return a;
    }

    static /* synthetic */ boolean afe(String str) {
        AppMethodBeat.m2504i(7216);
        if (str == null) {
            C4990ab.m7412e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            C15081g akD = C15045c.akD(str);
            if (akD == null) {
                C4990ab.m7413e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", str);
            } else if (akD.dmc()) {
                AppMethodBeat.m2505o(7216);
                return true;
            }
        }
        AppMethodBeat.m2505o(7216);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m12017a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        AppMethodBeat.m2504i(7217);
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.cAV) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.f16198id != i) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.uuT == null) {
            AppMethodBeat.m2505o(7217);
            return false;
        }
        C29944h.m47401JR(i).dcu();
        final Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", 1);
        intent.putExtra("proxyui_type_key", str);
        intent.putExtra("proxyui_function_key", str2);
        intent.putExtra("proxyui_callback_key", str3);
        intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
        intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
        intent.putExtra("webview_binder_id", i);
        intent.putExtra("screen_orientation", webViewStubService.uqA);
        intent.addFlags(268435456);
        boolean a = C29916g.m47393a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.uuT, new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(7204);
                WebViewStubService.this.startActivity(intent);
                AppMethodBeat.m2505o(7204);
            }
        });
        AppMethodBeat.m2505o(7217);
        return a;
    }
}
