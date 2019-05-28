package com.tencent.p177mm.plugin.story.p1032c.p1033a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.story.api.C35169f;
import com.tencent.p177mm.plugin.story.api.C35169f.C35170a;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p1032c.C46271b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44088i.C30131a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.util.HashSet;
import java.util.regex.Pattern;
import p000a.C0220l;
import p000a.p001a.C25035t;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableFavorite", "enableReply", "enableSnsNotify", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.c.a.a */
public final class C29274a extends C46271b<C13738a> implements C35169f {
    public static final C29274a rQZ = new C29274a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J1\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\u001eXD¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "enableFavorite", "getEnableFavorite", "()Z", "setEnableFavorite", "(Z)V", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.a$a */
    public static final class C13738a {
        final HashSet<C35170a> rRa;
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
                if (!(obj instanceof C13738a)) {
                    return false;
                }
                C13738a c13738a = (C13738a) obj;
                if (!(this.rRf == c13738a.rRf)) {
                    return false;
                }
                if (!(this.rRg == c13738a.rRg)) {
                    return false;
                }
                if (!(this.rRh == c13738a.rRh)) {
                    return false;
                }
                if (!(this.rRi == c13738a.rRi)) {
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
            AppMethodBeat.m2504i(108947);
            String str = "StoryBasicConfig(repeatMD5=" + this.rRf + ", showMusicIcon=" + this.rRg + ", albumThumbHeight=" + this.rRh + ", albumThumbWidth=" + this.rRi + ")";
            AppMethodBeat.m2505o(108947);
            return str;
        }

        private C13738a() {
            AppMethodBeat.m2504i(108946);
            this.rRf = 2;
            this.rRg = true;
            this.rRh = 0;
            this.rRi = 0;
            this.rRa = new HashSet();
            this.regex = "#冒泡#";
            this.rRe = 15552000;
            AppMethodBeat.m2505o(108946);
        }

        public /* synthetic */ C13738a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(108952);
        AppMethodBeat.m2505o(108952);
    }

    private C29274a() {
    }

    /* renamed from: Uv */
    public final void mo25945Uv() {
        boolean z = true;
        AppMethodBeat.m2504i(108949);
        if (C46270n.isShowStoryCheck()) {
            boolean z2;
            ((C13738a) mo53287Ut()).rRa.clear();
            if (mo45628L("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1) {
                ((C13738a) mo53287Ut()).rRa.add(C35170a.TimeLine_Like);
            }
            mo45628L("SnsTimelineJumpStorySwitch", 0);
            C30131a.vrR = Pattern.compile(((C13738a) mo53287Ut()).regex);
            C13738a c13738a = (C13738a) mo53287Ut();
            if (mo45628L("StoryEditVideoBgmSwitch", 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            c13738a.rRg = z2;
            int fromDPToPix = C1338a.fromDPToPix(C4996ah.getContext(), 1);
            ((C13738a) mo53287Ut()).rRh = fromDPToPix * 100;
            ((C13738a) mo53287Ut()).rRi = fromDPToPix * 100;
            if (C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE || C5058f.DEBUG) {
                ((C13738a) mo53287Ut()).rRb = true;
                ((C13738a) mo53287Ut()).rRc = true;
                c13738a = (C13738a) mo53287Ut();
            } else {
                c13738a = (C13738a) mo53287Ut();
                if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_favorite_enable, 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c13738a.rRb = z2;
                c13738a = (C13738a) mo53287Ut();
                if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_notify_sns_enable, 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c13738a.rRc = z2;
                c13738a = (C13738a) mo53287Ut();
                if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_reply_enable, 0) != 1) {
                    z = false;
                }
            }
            c13738a.rRd = z;
            ((C13738a) mo53287Ut()).rRe = mo45628L("StoryFeaturedExpiredTime", 15552000);
            AppMethodBeat.m2505o(108949);
            return;
        }
        AppMethodBeat.m2505o(108949);
    }

    /* renamed from: a */
    public final synchronized boolean mo47460a(C35170a c35170a) {
        boolean a;
        AppMethodBeat.m2504i(108950);
        a = C25035t.m39327a((Iterable) ((C13738a) mo53288Uw()).rRa, (Object) c35170a);
        AppMethodBeat.m2505o(108950);
        return a;
    }

    public final boolean cwU() {
        AppMethodBeat.m2504i(108951);
        boolean z = ((C13738a) mo53288Uw()).rRb;
        AppMethodBeat.m2505o(108951);
        return z;
    }

    public final boolean cxh() {
        AppMethodBeat.m2504i(138744);
        boolean z = ((C13738a) mo53288Uw()).rRc;
        AppMethodBeat.m2505o(138744);
        return z;
    }

    public final boolean cxi() {
        AppMethodBeat.m2504i(138745);
        boolean z = ((C13738a) mo53288Uw()).rRd;
        AppMethodBeat.m2505o(138745);
        return z;
    }

    /* renamed from: Uu */
    public final /* synthetic */ Object mo25944Uu() {
        AppMethodBeat.m2504i(108948);
        C13738a c13738a = new C13738a();
        AppMethodBeat.m2505o(108948);
        return c13738a;
    }
}
