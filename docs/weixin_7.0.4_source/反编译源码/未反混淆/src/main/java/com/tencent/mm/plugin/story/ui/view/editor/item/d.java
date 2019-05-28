package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcBean;", "", "lrc", "", "startTime", "", "stopTime", "(Ljava/lang/String;II)V", "getLrc", "()Ljava/lang/String;", "setLrc", "(Ljava/lang/String;)V", "getStartTime", "()I", "setStartTime", "(I)V", "getStopTime", "setStopTime", "plugin-story_release"})
public final class d {
    String snb;
    public int snc;
    int startTime;

    public d(String str, int i, int i2) {
        j.p(str, "lrc");
        AppMethodBeat.i(110676);
        this.snb = str;
        this.startTime = i;
        this.snc = i2;
        AppMethodBeat.o(110676);
    }
}
