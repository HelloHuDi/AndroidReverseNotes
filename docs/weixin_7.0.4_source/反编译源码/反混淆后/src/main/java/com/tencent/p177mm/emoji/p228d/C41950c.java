package com.tencent.p177mm.emoji.p228d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p1460f.C32505c;
import com.tencent.p177mm.emoji.loader.p848c.C37683g;
import com.tencent.p177mm.emoji.p227a.C18190d;
import com.tencent.p177mm.emoji.p227a.C18190d.C18191b;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.d.c */
public final class C41950c extends C26365c {
    final String TAG = "MicroMsg.EmojiCaptureUploadTask";
    long eAa;
    final boolean eAb = this.exP.duV();
    final EmojiInfo exP;
    final long ezZ = this.exP.field_captureEnterTime;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.d.c$a */
    public static final class C26075a implements C18191b {
        final /* synthetic */ C41950c eAc;
        final /* synthetic */ long eAd;

        C26075a(C41950c c41950c, long j) {
            this.eAc = c41950c;
            this.eAd = j;
        }

        /* renamed from: f */
        public final void mo33667f(int i, String str, String str2) {
            AppMethodBeat.m2504i(63295);
            C4990ab.m7416i(this.eAc.TAG, "uploadCallback: " + i + ", " + str);
            this.eAc.eAa = C5046bo.m7566gb(this.eAd);
            C41950c c41950c;
            int i2;
            C1677a M;
            C23505at emojiStorageMgr;
            C41949b c41949b;
            if (i == 0) {
                c41950c = this.eAc;
                i2 = c41950c.exP.field_captureScene;
                c41950c.exP.mo48510a(C30302a.STATUS_SUCCESS);
                EmojiCaptureReporter.m66033d(c41950c.ezZ, c41950c.eAa, i2);
                C7060h.pYm.mo8381e(10431, Integer.valueOf(7), c41950c.exP.mo20410Aq(), c41950c.exP.field_designerID, c41950c.exP.awa(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c41950c.exP.getSize()), C1853r.m3846Yz(), c41950c.exP.field_activityid);
                if (!c41950c.eAb || C26072e.m41623OR()) {
                    C32497a.m53203OB().mo53141cd(true);
                    M = C1720g.m3530M(C6835d.class);
                    C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
                    C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
                    emojiStorageMgr.aUp().mo48555G(c41950c.exP);
                    c41950c.mo44157a(C45423h.OK);
                    c41949b = C41949b.ezV;
                    C41949b.m74084b(c41950c.ezZ, true, str);
                    AppMethodBeat.m2505o(63295);
                    return;
                }
                C4990ab.m7420w(c41950c.TAG, "upload wxam but not decode, load gif");
                C37683g c37683g = C37683g.exW;
                C37683g.m63731a(c41950c.exP, new C37676b(c41950c, str));
                AppMethodBeat.m2505o(63295);
                return;
            }
            c41950c = this.eAc;
            c41950c.exP.mo48510a(C30302a.STATUS_UPLOAD_FAIL);
            i2 = c41950c.exP.field_captureScene;
            switch (i) {
                case 2:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 2, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_OVER_SIZE);
                    break;
                case 3:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 1, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_OVER_LIMIT);
                    break;
                case 4:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 5, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_NOT_COMPLETED);
                    break;
                case 5:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 7, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_NON_NETWORK);
                    break;
                case 6:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 8, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_WIFI_NETWORK);
                    break;
                case 7:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 9, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_MOBILE_NETWORK);
                    break;
                case 8:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 6, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_SPAM);
                    break;
                case 9:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 10, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_OVER_UPLOAD_TIME);
                    break;
                case 10:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 4, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_LOCAL_FILE);
                    break;
                default:
                    EmojiCaptureReporter.m66036g(c41950c.ezZ, 3, i2);
                    c41950c.exP.mo48511a(C30301b.ERR_OTHERS);
                    break;
            }
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
            C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().mo48555G(c41950c.exP);
            c41949b = C41949b.ezV;
            C41949b.m74084b(c41950c.ezZ, false, null);
            c41950c.mo44157a(C45423h.Fail);
            AppMethodBeat.m2505o(63295);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.d.c$b */
    static final class C37676b extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ C41950c eAc;
        final /* synthetic */ String eAe;

        C37676b(C41950c c41950c, String str) {
            this.eAc = c41950c;
            this.eAe = str;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(63296);
            ((Boolean) obj).booleanValue();
            C32505c c32505c = C32505c.eyt;
            C32505c.m53223i(this.eAc.exP);
            C32497a.m53203OB().mo53141cd(true);
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            C23505at emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
            C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().mo48555G(this.eAc.exP);
            this.eAc.mo44157a(C45423h.OK);
            C41949b c41949b = C41949b.ezV;
            C41949b.m74084b(this.eAc.ezZ, true, this.eAe);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63296);
            return c37091y;
        }
    }

    public C41950c(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        AppMethodBeat.m2504i(63299);
        this.exP = emojiInfo;
        AppMethodBeat.m2505o(63299);
    }

    /* renamed from: Pa */
    public final void mo9026Pa() {
        AppMethodBeat.m2504i(63297);
        C18190d c18190d = new C18190d(this.exP, this.exP.dvd(), this.exP.field_imitateMd5, new C26075a(this, C5046bo.anU()));
        AppMethodBeat.m2505o(63297);
    }

    /* renamed from: Pc */
    public final String mo9027Pc() {
        AppMethodBeat.m2504i(63298);
        String valueOf = String.valueOf(this.ezZ);
        AppMethodBeat.m2505o(63298);
        return valueOf;
    }
}
