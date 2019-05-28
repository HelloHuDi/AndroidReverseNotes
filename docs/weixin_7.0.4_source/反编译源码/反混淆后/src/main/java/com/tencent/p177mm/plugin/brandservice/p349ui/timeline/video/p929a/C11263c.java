package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.BizVideoDetailUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0007J \u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0007H\u0007J8\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0007JP\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0003J\u0018\u00101\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "maxVideoPlaySaveTime", "playTimeHashMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/VideoPlayTime;", "Lkotlin/collections/HashMap;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "goToWebViewUI", "", "url", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "view", "Landroid/view/View;", "bundle", "Landroid/os/Bundle;", "left", "top", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c */
public final class C11263c {
    private static final String TAG = TAG;
    private static final HashMap<String, C33747h> jYu = new HashMap();
    public static final C11263c jYv = new C11263c();

    static {
        AppMethodBeat.m2504i(15324);
        AppMethodBeat.m2505o(15324);
    }

    private C11263c() {
    }

    /* renamed from: a */
    public static final void m18982a(Context context, long j, long j2, int i, View view, Bundle bundle) {
        AppMethodBeat.m2504i(15318);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(view, "view");
        C25052j.m39376p(bundle, "bundle");
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
        C4990ab.m7411d(TAG, "onVideoMsgClick left %d, top %d, w %d, h %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(width), Integer.valueOf(height));
        intent.putExtra("biz_video_msg_id", j);
        intent.putExtra("biz_video_msg_svr_index", j2);
        intent.putExtra("KPublisherId", "msg_".concat(String.valueOf(j2)));
        intent.putExtra("biz_video_msg_index", i);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.m2505o(15318);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: R */
    public static final C37436r m18981R(Intent intent) {
        int i;
        AppMethodBeat.m2504i(15319);
        C25052j.m39376p(intent, "intent");
        C37436r c37436r = new C37436r();
        c37436r.fjS = intent.getStringExtra("KPublisherId");
        c37436r.cwT = intent.getStringExtra("sns_local_id");
        c37436r.cvx = intent.getLongExtra("biz_video_msg_id", -1);
        if (c37436r.cvx > -1) {
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
            C7620bi jf = ((C6982j) K).bOr().mo15340jf(c37436r.cvx);
            C25052j.m39375o(jf, "msgInfo");
            if (jf.drC() || jf.bAA()) {
                C32224p c32224p;
                C25052j.m39376p(intent, "intent");
                C25052j.m39376p(c37436r, "mpMsgInfo");
                C25052j.m39376p(jf, "msgInfo");
                c37436r.cKK = intent.getLongExtra("biz_video_msg_svr_index", 0);
                c37436r.fjQ = intent.getIntExtra("biz_video_msg_index", 0);
                c37436r.userName = jf.mo14769HE();
                C25052j.m39376p(jf, "msgInfo");
                C25052j.m39376p(c37436r, "mpMsgInfo");
                if (jf.drC() || !jf.bAA()) {
                    C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(jf.mo14765HA(), jf.getContent());
                    if (b == null || C5046bo.m7548ek(b.fjr)) {
                        C4990ab.m7420w(TAG, "getBizReaderItem reader is null");
                        c32224p = null;
                    } else if (c37436r.fjQ >= b.fjr.size()) {
                        c32224p = (C32224p) b.fjr.get(0);
                    } else {
                        c32224p = (C32224p) b.fjr.get(c37436r.fjQ);
                    }
                } else {
                    C25052j.m39376p(jf, "msgInfo");
                    C25052j.m39376p(c37436r, "mpMsgInfo");
                    C8910b me = C8910b.m16064me(jf.getContent());
                    if (me == null) {
                        C4990ab.m7420w(TAG, "parse content fail");
                        c32224p = null;
                    } else {
                        C32224p c32224p2 = new C32224p();
                        c37436r.cwG = me.cMg;
                        c37436r.fjR = me.cMh;
                        c32224p2.url = me.url;
                        c32224p2.title = me.title;
                        c32224p2.fjz = me.description;
                        c32224p2.fjx = me.thumburl;
                        C25747e c25747e = (C25747e) me.mo20333X(C25747e.class);
                        if (c25747e == null) {
                            C4990ab.m7420w(TAG, "piece content fail");
                            c32224p = null;
                        } else {
                            c32224p2.fgd = c25747e.fgd;
                            c32224p2.time = (long) c25747e.fga;
                            c32224p2.type = c25747e.ffZ;
                            c32224p2.fjB = c25747e.duration;
                            c32224p2.videoWidth = c25747e.videoWidth;
                            c32224p2.videoHeight = c25747e.videoHeight;
                            c37436r.fgc = c25747e.fgc;
                            c32224p = c32224p2;
                        }
                    }
                }
                c37436r.fjT = c32224p;
                c37436r.type = jf.getType();
                i = 1;
                if (i == 0) {
                    C25052j.m39376p(intent, "intent");
                    C25052j.m39376p(c37436r, "msg");
                    c37436r.cwG = intent.getStringExtra("srcUsername");
                    c37436r.fjR = intent.getStringExtra("srcDisplayname");
                    c37436r.fjT.url = intent.getStringExtra("rawUrl");
                    c37436r.fjT.title = intent.getStringExtra("biz_video_title");
                    c37436r.fjT.fjz = intent.getStringExtra("biz_video_desc");
                    c37436r.fjT.fjx = intent.getStringExtra("biz_video_icon_url");
                    c37436r.fjT.type = intent.getIntExtra("biz_video_item_show_type", -1);
                    c37436r.fjT.time = intent.getLongExtra("biz_video_pub_time", 0);
                    c37436r.fjT.fjB = intent.getIntExtra("biz_video_duration", 0);
                    c37436r.fjT.videoWidth = intent.getIntExtra("biz_video_width", 0);
                    c37436r.fjT.videoHeight = intent.getIntExtra("biz_video_height", 0);
                    c37436r.fjT.fgd = intent.getStringExtra("biz_video_vid");
                    c37436r.fgc = intent.getIntExtra("biz_video_func_flag", 0);
                }
                AppMethodBeat.m2505o(15319);
                return c37436r;
            }
        }
        i = 0;
        if (i == 0) {
        }
        AppMethodBeat.m2505o(15319);
        return c37436r;
    }

    /* JADX WARNING: Missing block: B:10:0x0038, code skipped:
            if (r0.equals("zh_CN") != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:11:0x003a, code skipped:
            r0 = r4.getString(com.tencent.p177mm.C25738R.string.g7y);
     */
    /* JADX WARNING: Missing block: B:12:0x0041, code skipped:
            if (r5 < 100000) goto L_0x0071;
     */
    /* JADX WARNING: Missing block: B:13:0x0043, code skipped:
            r0 = new java.lang.StringBuilder(com.tenpay.android.wechat.PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT).append(r0).append('+').toString();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(15320);
     */
    /* JADX WARNING: Missing block: B:15:0x0064, code skipped:
            if (r0.equals("zh_TW") != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:17:0x006e, code skipped:
            if (r0.equals("zh_HK") != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:18:0x0071, code skipped:
            r0 = (r5 / com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK) + '.' + ((r5 % com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK) / 1000) + r0;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(15320);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: G */
    public static final String m18979G(Context context, int i) {
        AppMethodBeat.m2504i(15320);
        C25052j.m39376p(context, "context");
        String valueOf;
        if (i < Downloads.MIN_WAIT_FOR_NETWORK) {
            valueOf = String.valueOf(i);
            AppMethodBeat.m2505o(15320);
            return valueOf;
        }
        valueOf = C4988aa.dor();
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
            AppMethodBeat.m2505o(15320);
            return valueOf;
        }
        valueOf = (i / 1000) + 'k';
        AppMethodBeat.m2505o(15320);
        return valueOf;
    }

    /* renamed from: a */
    public static final void m18983a(Context context, C37436r c37436r, String str) {
        AppMethodBeat.m2504i(15321);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c37436r, "msgInfo");
        C25052j.m39376p(str, "url");
        Intent intent = new Intent();
        intent.putExtra("KPublisherId", c37436r.fjS);
        intent.putExtra("pre_username", c37436r.mo60325HE());
        intent.putExtra("preUsername", c37436r.mo60325HE());
        intent.putExtra("preChatName", c37436r.mo60325HE());
        intent.putExtra("rawUrl", str);
        intent.putExtra("geta8key_username", c37436r.mo60325HE());
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(15321);
    }

    /* renamed from: Gg */
    public static final double m18980Gg(String str) {
        AppMethodBeat.m2504i(15322);
        C25052j.m39376p(str, "key");
        C33747h c33747h = (C33747h) jYu.get(str);
        if (c33747h == null) {
            AppMethodBeat.m2505o(15322);
            return 0.0d;
        } else if (System.currentTimeMillis() - c33747h.jYX > 180000) {
            AppMethodBeat.m2505o(15322);
            return 0.0d;
        } else {
            double d = c33747h.jYY;
            AppMethodBeat.m2505o(15322);
            return d;
        }
    }

    /* renamed from: e */
    public static final void m18984e(String str, double d) {
        AppMethodBeat.m2504i(15323);
        C25052j.m39376p(str, "key");
        jYu.put(str, new C33747h(System.currentTimeMillis(), d));
        AppMethodBeat.m2505o(15323);
    }
}
