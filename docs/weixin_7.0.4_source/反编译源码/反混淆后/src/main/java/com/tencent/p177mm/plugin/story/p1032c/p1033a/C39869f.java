package com.tencent.p177mm.plugin.story.p1032c.p1033a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.story.p1032c.C39870a.C39865b;
import com.tencent.p177mm.plugin.story.p1032c.C39870a.C39871a;
import com.tencent.p177mm.plugin.story.p1032c.C46271b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.c.a.f */
public final class C39869f extends C46271b<C29278a> {
    private static final String TAG = TAG;
    private static final C29278a rRB = C29278a.BACKGROUND;
    public static final C39869f rRC = new C39869f();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.f$a */
    public enum C29278a {
        FORWARD(0),
        BACKGROUND(1);
        
        public final int value;

        private C29278a(int i) {
            this.value = i;
        }

        static {
            AppMethodBeat.m2505o(108981);
        }
    }

    static {
        AppMethodBeat.m2504i(108985);
        AppMethodBeat.m2505o(108985);
    }

    private C39869f() {
    }

    /* renamed from: Uu */
    public final /* bridge */ /* synthetic */ Object mo25944Uu() {
        return C29278a.BACKGROUND;
    }

    /* renamed from: Uv */
    public final void mo25945Uv() {
        AppMethodBeat.m2504i(108984);
        C4990ab.m7416i(TAG, "loadDebugConfig false ");
        String string = C5018as.amF(C39865b.rQX.name()).getString(C39871a.ELEMENT_PROCESS_TYPE.name(), rRB.name());
        if (string == null) {
            C25052j.dWJ();
        }
        C25052j.m39375o(string, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
        mo53289aQ(C29278a.valueOf(string));
        int L = mo45628L("StoryBackgroundRemux", 0);
        if (L != 0) {
            mo53289aQ(L == 1 ? C29278a.BACKGROUND : C29278a.FORWARD);
        }
        int i = C1427q.etk.etL;
        if (i != -1) {
            mo53289aQ(i == 1 ? C29278a.BACKGROUND : C29278a.FORWARD);
        }
        C4990ab.m7416i(TAG, "loadServerConfig : " + ((C29278a) mo53287Ut()) + ", serverConfig:" + L + ", deviceConfig:" + i);
        AppMethodBeat.m2505o(108984);
    }
}
