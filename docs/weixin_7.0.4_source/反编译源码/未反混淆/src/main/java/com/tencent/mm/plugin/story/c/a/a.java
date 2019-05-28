package com.tencent.mm.plugin.story.c.a;

import a.a.t;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.regex.Pattern;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableFavorite", "enableReply", "enableSnsNotify", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
public final class a extends b<a> implements f {
    public static final a rQZ = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J1\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\u001eXD¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "enableFavorite", "getEnableFavorite", "()Z", "setEnableFavorite", "(Z)V", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
    public static final class a {
        final HashSet<com.tencent.mm.plugin.story.api.f.a> rRa;
        boolean rRb;
        boolean rRc;
        boolean rRd;
        public int rRe;
        private int rRf;
        public boolean rRg;
        public int rRh;
        public int rRi;
        final String regex;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (!(this.rRf == aVar.rRf)) {
                    return false;
                }
                if (!(this.rRg == aVar.rRg)) {
                    return false;
                }
                if (!(this.rRh == aVar.rRh)) {
                    return false;
                }
                if (!(this.rRi == aVar.rRi)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = this.rRf * 31;
            int i2 = this.rRg;
            if (i2 != 0) {
                i2 = 1;
            }
            return ((((i2 + i) * 31) + this.rRh) * 31) + this.rRi;
        }

        public final String toString() {
            AppMethodBeat.i(108947);
            String str = "StoryBasicConfig(repeatMD5=" + this.rRf + ", showMusicIcon=" + this.rRg + ", albumThumbHeight=" + this.rRh + ", albumThumbWidth=" + this.rRi + ")";
            AppMethodBeat.o(108947);
            return str;
        }

        private a() {
            AppMethodBeat.i(108946);
            this.rRf = 2;
            this.rRg = true;
            this.rRh = 0;
            this.rRi = 0;
            this.rRa = new HashSet();
            this.regex = "#冒泡#";
            this.rRe = 15552000;
            AppMethodBeat.o(108946);
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(108952);
        AppMethodBeat.o(108952);
    }

    private a() {
    }

    public final void Uv() {
        boolean z = true;
        AppMethodBeat.i(108949);
        if (n.isShowStoryCheck()) {
            boolean z2;
            ((a) Ut()).rRa.clear();
            if (L("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1) {
                ((a) Ut()).rRa.add(com.tencent.mm.plugin.story.api.f.a.TimeLine_Like);
            }
            L("SnsTimelineJumpStorySwitch", 0);
            com.tencent.mm.pluginsdk.ui.e.i.a.vrR = Pattern.compile(((a) Ut()).regex);
            a aVar = (a) Ut();
            if (L("StoryEditVideoBgmSwitch", 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.rRg = z2;
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 1);
            ((a) Ut()).rRh = fromDPToPix * 100;
            ((a) Ut()).rRi = fromDPToPix * 100;
            if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE || com.tencent.mm.sdk.platformtools.f.DEBUG) {
                ((a) Ut()).rRb = true;
                ((a) Ut()).rRc = true;
                aVar = (a) Ut();
            } else {
                aVar = (a) Ut();
                if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_favorite_enable, 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar.rRb = z2;
                aVar = (a) Ut();
                if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_notify_sns_enable, 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar.rRc = z2;
                aVar = (a) Ut();
                if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_reply_enable, 0) != 1) {
                    z = false;
                }
            }
            aVar.rRd = z;
            ((a) Ut()).rRe = L("StoryFeaturedExpiredTime", 15552000);
            AppMethodBeat.o(108949);
            return;
        }
        AppMethodBeat.o(108949);
    }

    public final synchronized boolean a(com.tencent.mm.plugin.story.api.f.a aVar) {
        boolean a;
        AppMethodBeat.i(108950);
        a = t.a((Iterable) ((a) Uw()).rRa, (Object) aVar);
        AppMethodBeat.o(108950);
        return a;
    }

    public final boolean cwU() {
        AppMethodBeat.i(108951);
        boolean z = ((a) Uw()).rRb;
        AppMethodBeat.o(108951);
        return z;
    }

    public final boolean cxh() {
        AppMethodBeat.i(138744);
        boolean z = ((a) Uw()).rRc;
        AppMethodBeat.o(138744);
        return z;
    }

    public final boolean cxi() {
        AppMethodBeat.i(138745);
        boolean z = ((a) Uw()).rRd;
        AppMethodBeat.o(138745);
        return z;
    }

    public final /* synthetic */ Object Uu() {
        AppMethodBeat.i(108948);
        a aVar = new a();
        AppMethodBeat.o(108948);
        return aVar;
    }
}
