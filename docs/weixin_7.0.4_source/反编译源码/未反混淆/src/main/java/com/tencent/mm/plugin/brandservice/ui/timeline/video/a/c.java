package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.e;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.af.r;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0007J \u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0007H\u0007J8\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0007JP\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0003J\u0018\u00101\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "maxVideoPlaySaveTime", "playTimeHashMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/VideoPlayTime;", "Lkotlin/collections/HashMap;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "goToWebViewUI", "", "url", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "view", "Landroid/view/View;", "bundle", "Landroid/os/Bundle;", "left", "top", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class c {
    private static final String TAG = TAG;
    private static final HashMap<String, h> jYu = new HashMap();
    public static final c jYv = new c();

    static {
        AppMethodBeat.i(15324);
        AppMethodBeat.o(15324);
    }

    private c() {
    }

    public static final void a(Context context, long j, long j2, int i, View view, Bundle bundle) {
        AppMethodBeat.i(15318);
        j.p(context, "context");
        j.p(view, "view");
        j.p(bundle, "bundle");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        Intent intent = new Intent(context, BizVideoDetailUI.class);
        intent.putExtra("img_gallery_width", width);
        intent.putExtra("img_gallery_height", height);
        intent.putExtra("img_gallery_left", i2);
        intent.putExtra("img_gallery_top", i3);
        ab.d(TAG, "onVideoMsgClick left %d, top %d, w %d, h %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(width), Integer.valueOf(height));
        intent.putExtra("biz_video_msg_id", j);
        intent.putExtra("biz_video_msg_svr_index", j2);
        intent.putExtra("KPublisherId", "msg_".concat(String.valueOf(j2)));
        intent.putExtra("biz_video_msg_index", i);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.o(15318);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final r R(Intent intent) {
        int i;
        AppMethodBeat.i(15319);
        j.p(intent, "intent");
        r rVar = new r();
        rVar.fjS = intent.getStringExtra("KPublisherId");
        rVar.cwT = intent.getStringExtra("sns_local_id");
        rVar.cvx = intent.getLongExtra("biz_video_msg_id", -1);
        if (rVar.cvx > -1) {
            a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
            bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOr().jf(rVar.cvx);
            j.o(jf, "msgInfo");
            if (jf.drC() || jf.bAA()) {
                p pVar;
                j.p(intent, "intent");
                j.p(rVar, "mpMsgInfo");
                j.p(jf, "msgInfo");
                rVar.cKK = intent.getLongExtra("biz_video_msg_svr_index", 0);
                rVar.fjQ = intent.getIntExtra("biz_video_msg_index", 0);
                rVar.userName = jf.HE();
                j.p(jf, "msgInfo");
                j.p(rVar, "mpMsgInfo");
                if (jf.drC() || !jf.bAA()) {
                    o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(jf.HA(), jf.getContent());
                    if (b == null || bo.ek(b.fjr)) {
                        ab.w(TAG, "getBizReaderItem reader is null");
                        pVar = null;
                    } else if (rVar.fjQ >= b.fjr.size()) {
                        pVar = (p) b.fjr.get(0);
                    } else {
                        pVar = (p) b.fjr.get(rVar.fjQ);
                    }
                } else {
                    j.p(jf, "msgInfo");
                    j.p(rVar, "mpMsgInfo");
                    b me = b.me(jf.getContent());
                    if (me == null) {
                        ab.w(TAG, "parse content fail");
                        pVar = null;
                    } else {
                        p pVar2 = new p();
                        rVar.cwG = me.cMg;
                        rVar.fjR = me.cMh;
                        pVar2.url = me.url;
                        pVar2.title = me.title;
                        pVar2.fjz = me.description;
                        pVar2.fjx = me.thumburl;
                        e eVar = (e) me.X(e.class);
                        if (eVar == null) {
                            ab.w(TAG, "piece content fail");
                            pVar = null;
                        } else {
                            pVar2.fgd = eVar.fgd;
                            pVar2.time = (long) eVar.fga;
                            pVar2.type = eVar.ffZ;
                            pVar2.fjB = eVar.duration;
                            pVar2.videoWidth = eVar.videoWidth;
                            pVar2.videoHeight = eVar.videoHeight;
                            rVar.fgc = eVar.fgc;
                            pVar = pVar2;
                        }
                    }
                }
                rVar.fjT = pVar;
                rVar.type = jf.getType();
                i = 1;
                if (i == 0) {
                    j.p(intent, "intent");
                    j.p(rVar, "msg");
                    rVar.cwG = intent.getStringExtra("srcUsername");
                    rVar.fjR = intent.getStringExtra("srcDisplayname");
                    rVar.fjT.url = intent.getStringExtra("rawUrl");
                    rVar.fjT.title = intent.getStringExtra("biz_video_title");
                    rVar.fjT.fjz = intent.getStringExtra("biz_video_desc");
                    rVar.fjT.fjx = intent.getStringExtra("biz_video_icon_url");
                    rVar.fjT.type = intent.getIntExtra("biz_video_item_show_type", -1);
                    rVar.fjT.time = intent.getLongExtra("biz_video_pub_time", 0);
                    rVar.fjT.fjB = intent.getIntExtra("biz_video_duration", 0);
                    rVar.fjT.videoWidth = intent.getIntExtra("biz_video_width", 0);
                    rVar.fjT.videoHeight = intent.getIntExtra("biz_video_height", 0);
                    rVar.fjT.fgd = intent.getStringExtra("biz_video_vid");
                    rVar.fgc = intent.getIntExtra("biz_video_func_flag", 0);
                }
                AppMethodBeat.o(15319);
                return rVar;
            }
        }
        i = 0;
        if (i == 0) {
        }
        AppMethodBeat.o(15319);
        return rVar;
    }

    /* JADX WARNING: Missing block: B:10:0x0038, code skipped:
            if (r0.equals("zh_CN") != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:11:0x003a, code skipped:
            r0 = r4.getString(com.tencent.mm.R.string.g7y);
     */
    /* JADX WARNING: Missing block: B:12:0x0041, code skipped:
            if (r5 < 100000) goto L_0x0071;
     */
    /* JADX WARNING: Missing block: B:13:0x0043, code skipped:
            r0 = new java.lang.StringBuilder(com.tenpay.android.wechat.PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT).append(r0).append('+').toString();
            com.tencent.matrix.trace.core.AppMethodBeat.o(15320);
     */
    /* JADX WARNING: Missing block: B:15:0x0064, code skipped:
            if (r0.equals("zh_TW") != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:17:0x006e, code skipped:
            if (r0.equals("zh_HK") != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:18:0x0071, code skipped:
            r0 = (r5 / com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK) + '.' + ((r5 % com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK) / 1000) + r0;
            com.tencent.matrix.trace.core.AppMethodBeat.o(15320);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String G(Context context, int i) {
        AppMethodBeat.i(15320);
        j.p(context, "context");
        String valueOf;
        if (i < Downloads.MIN_WAIT_FOR_NETWORK) {
            valueOf = String.valueOf(i);
            AppMethodBeat.o(15320);
            return valueOf;
        }
        valueOf = aa.dor();
        if (valueOf != null) {
            switch (valueOf.hashCode()) {
                case 115861276:
                    break;
                case 115861428:
                    break;
                case 115861812:
                    break;
            }
        }
        if (i >= 100000) {
            valueOf = "100k+";
            AppMethodBeat.o(15320);
            return valueOf;
        }
        valueOf = (i / 1000) + 'k';
        AppMethodBeat.o(15320);
        return valueOf;
    }

    public static final void a(Context context, r rVar, String str) {
        AppMethodBeat.i(15321);
        j.p(context, "context");
        j.p(rVar, "msgInfo");
        j.p(str, "url");
        Intent intent = new Intent();
        intent.putExtra("KPublisherId", rVar.fjS);
        intent.putExtra("pre_username", rVar.HE());
        intent.putExtra("preUsername", rVar.HE());
        intent.putExtra("preChatName", rVar.HE());
        intent.putExtra("rawUrl", str);
        intent.putExtra("geta8key_username", rVar.HE());
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(15321);
    }

    public static final double Gg(String str) {
        AppMethodBeat.i(15322);
        j.p(str, "key");
        h hVar = (h) jYu.get(str);
        if (hVar == null) {
            AppMethodBeat.o(15322);
            return 0.0d;
        } else if (System.currentTimeMillis() - hVar.jYX > 180000) {
            AppMethodBeat.o(15322);
            return 0.0d;
        } else {
            double d = hVar.jYY;
            AppMethodBeat.o(15322);
            return d;
        }
    }

    public static final void e(String str, double d) {
        AppMethodBeat.i(15323);
        j.p(str, "key");
        jYu.put(str, new h(System.currentTimeMillis(), d));
        AppMethodBeat.o(15323);
    }
}
