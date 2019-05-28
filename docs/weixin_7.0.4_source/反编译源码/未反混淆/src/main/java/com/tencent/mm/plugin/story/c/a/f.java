package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class f extends b<a> {
    private static final String TAG = TAG;
    private static final a rRB = a.BACKGROUND;
    public static final f rRC = new f();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
    public enum a {
        FORWARD(0),
        BACKGROUND(1);
        
        public final int value;

        private a(int i) {
            this.value = i;
        }

        static {
            AppMethodBeat.o(108981);
        }
    }

    static {
        AppMethodBeat.i(108985);
        AppMethodBeat.o(108985);
    }

    private f() {
    }

    public final /* bridge */ /* synthetic */ Object Uu() {
        return a.BACKGROUND;
    }

    public final void Uv() {
        AppMethodBeat.i(108984);
        ab.i(TAG, "loadDebugConfig false ");
        String string = as.amF(com.tencent.mm.plugin.story.c.a.b.rQX.name()).getString(com.tencent.mm.plugin.story.c.a.a.ELEMENT_PROCESS_TYPE.name(), rRB.name());
        if (string == null) {
            j.dWJ();
        }
        j.o(string, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
        aQ(a.valueOf(string));
        int L = L("StoryBackgroundRemux", 0);
        if (L != 0) {
            aQ(L == 1 ? a.BACKGROUND : a.FORWARD);
        }
        int i = q.etk.etL;
        if (i != -1) {
            aQ(i == 1 ? a.BACKGROUND : a.FORWARD);
        }
        ab.i(TAG, "loadServerConfig : " + ((a) Ut()) + ", serverConfig:" + L + ", deviceConfig:" + i);
        AppMethodBeat.o(108984);
    }
}
