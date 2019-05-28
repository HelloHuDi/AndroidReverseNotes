package com.tencent.mm.emoji.d;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c extends com.tencent.mm.loader.g.c {
    final String TAG = "MicroMsg.EmojiCaptureUploadTask";
    long eAa;
    final boolean eAb = this.exP.duV();
    final EmojiInfo exP;
    final long ezZ = this.exP.field_captureEnterTime;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/emoji/upload/EmojiCaptureUploadTask$call$1", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
    public static final class a implements com.tencent.mm.emoji.a.d.b {
        final /* synthetic */ c eAc;
        final /* synthetic */ long eAd;

        a(c cVar, long j) {
            this.eAc = cVar;
            this.eAd = j;
        }

        public final void f(int i, String str, String str2) {
            AppMethodBeat.i(63295);
            ab.i(this.eAc.TAG, "uploadCallback: " + i + ", " + str);
            this.eAc.eAa = bo.gb(this.eAd);
            c cVar;
            int i2;
            com.tencent.mm.kernel.b.a M;
            at emojiStorageMgr;
            b bVar;
            if (i == 0) {
                cVar = this.eAc;
                i2 = cVar.exP.field_captureScene;
                cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_SUCCESS);
                EmojiCaptureReporter.d(cVar.ezZ, cVar.eAa, i2);
                h.pYm.e(10431, Integer.valueOf(7), cVar.exP.Aq(), cVar.exP.field_designerID, cVar.exP.awa(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cVar.exP.getSize()), r.Yz(), cVar.exP.field_activityid);
                if (!cVar.eAb || e.OR()) {
                    com.tencent.mm.emoji.a.a.OB().cd(true);
                    M = g.M(d.class);
                    j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
                    emojiStorageMgr = ((d) M).getEmojiStorageMgr();
                    j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
                    emojiStorageMgr.aUp().G(cVar.exP);
                    cVar.a(com.tencent.mm.loader.g.h.OK);
                    bVar = b.ezV;
                    b.b(cVar.ezZ, true, str);
                    AppMethodBeat.o(63295);
                    return;
                }
                ab.w(cVar.TAG, "upload wxam but not decode, load gif");
                com.tencent.mm.emoji.loader.c.g gVar = com.tencent.mm.emoji.loader.c.g.exW;
                com.tencent.mm.emoji.loader.c.g.a(cVar.exP, new b(cVar, str));
                AppMethodBeat.o(63295);
                return;
            }
            cVar = this.eAc;
            cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_UPLOAD_FAIL);
            i2 = cVar.exP.field_captureScene;
            switch (i) {
                case 2:
                    EmojiCaptureReporter.g(cVar.ezZ, 2, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_OVER_SIZE);
                    break;
                case 3:
                    EmojiCaptureReporter.g(cVar.ezZ, 1, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_OVER_LIMIT);
                    break;
                case 4:
                    EmojiCaptureReporter.g(cVar.ezZ, 5, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_NOT_COMPLETED);
                    break;
                case 5:
                    EmojiCaptureReporter.g(cVar.ezZ, 7, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_NON_NETWORK);
                    break;
                case 6:
                    EmojiCaptureReporter.g(cVar.ezZ, 8, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_WIFI_NETWORK);
                    break;
                case 7:
                    EmojiCaptureReporter.g(cVar.ezZ, 9, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_MOBILE_NETWORK);
                    break;
                case 8:
                    EmojiCaptureReporter.g(cVar.ezZ, 6, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_SPAM);
                    break;
                case 9:
                    EmojiCaptureReporter.g(cVar.ezZ, 10, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_OVER_UPLOAD_TIME);
                    break;
                case 10:
                    EmojiCaptureReporter.g(cVar.ezZ, 4, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_LOCAL_FILE);
                    break;
                default:
                    EmojiCaptureReporter.g(cVar.ezZ, 3, i2);
                    cVar.exP.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_OTHERS);
                    break;
            }
            M = g.M(d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            emojiStorageMgr = ((d) M).getEmojiStorageMgr();
            j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().G(cVar.exP);
            bVar = b.ezV;
            b.b(cVar.ezZ, false, null);
            cVar.a(com.tencent.mm.loader.g.h.Fail);
            AppMethodBeat.o(63295);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class b extends k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ c eAc;
        final /* synthetic */ String eAe;

        b(c cVar, String str) {
            this.eAc = cVar;
            this.eAe = str;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(63296);
            ((Boolean) obj).booleanValue();
            com.tencent.mm.emoji.loader.f.c cVar = com.tencent.mm.emoji.loader.f.c.eyt;
            com.tencent.mm.emoji.loader.f.c.i(this.eAc.exP);
            com.tencent.mm.emoji.a.a.OB().cd(true);
            com.tencent.mm.kernel.b.a M = g.M(d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            at emojiStorageMgr = ((d) M).getEmojiStorageMgr();
            j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().G(this.eAc.exP);
            this.eAc.a(com.tencent.mm.loader.g.h.OK);
            b bVar = b.ezV;
            b.b(this.eAc.ezZ, true, this.eAe);
            y yVar = y.AUy;
            AppMethodBeat.o(63296);
            return yVar;
        }
    }

    public c(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        AppMethodBeat.i(63299);
        this.exP = emojiInfo;
        AppMethodBeat.o(63299);
    }

    public final void Pa() {
        AppMethodBeat.i(63297);
        com.tencent.mm.emoji.a.d dVar = new com.tencent.mm.emoji.a.d(this.exP, this.exP.dvd(), this.exP.field_imitateMd5, new a(this, bo.anU()));
        AppMethodBeat.o(63297);
    }

    public final String Pc() {
        AppMethodBeat.i(63298);
        String valueOf = String.valueOf(this.ezZ);
        AppMethodBeat.o(63298);
        return valueOf;
    }
}
