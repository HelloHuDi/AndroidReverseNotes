package com.tencent.p177mm.plugin.story.p536ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0006\u0010\u001e\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R7\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.h */
public final class C22325h {
    boolean isRecording;
    C17126b<? super View, C37091y> skq;
    public C17126b<? super View, C37091y> skr;
    C17126b<? super View, C37091y> sks;
    int skt;
    final long sku = ((long) ViewConfiguration.getDoubleTapTimeout());
    Runnable skv = new C22326a(this);
    private final View view;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.h$a */
    static final class C22326a implements Runnable {
        final /* synthetic */ C22325h skw;

        C22326a(C22325h c22325h) {
            this.skw = c22325h;
        }

        public final void run() {
            AppMethodBeat.m2504i(110472);
            this.skw.cCq();
            AppMethodBeat.m2505o(110472);
        }
    }

    public C22325h(View view) {
        C25052j.m39376p(view, "view");
        AppMethodBeat.m2504i(110474);
        this.view = view;
        AppMethodBeat.m2505o(110474);
    }

    /* Access modifiers changed, original: final */
    public final void cCq() {
        AppMethodBeat.m2504i(110473);
        C17126b c17126b;
        switch (this.skt) {
            case 1:
                c17126b = this.skq;
                if (c17126b != null) {
                    c17126b.mo50am(this.view);
                    break;
                }
                break;
            case 2:
                c17126b = this.skr;
                if (c17126b != null) {
                    c17126b.mo50am(this.view);
                    break;
                }
                break;
            case 3:
                c17126b = this.sks;
                if (c17126b != null) {
                    c17126b.mo50am(this.view);
                    break;
                }
                break;
        }
        this.skt = 0;
        this.isRecording = false;
        AppMethodBeat.m2505o(110473);
    }
}
