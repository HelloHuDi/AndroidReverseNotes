package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;

/* renamed from: com.tencent.mm.plugin.webview.luggage.e */
public class C16926e extends C16404b {
    private C16404b uiH = new C16404b();

    public C16926e() {
        AppMethodBeat.m2504i(6095);
        AppMethodBeat.m2505o(6095);
    }

    /* renamed from: a */
    public final void mo30938a(C16404b c16404b) {
        if (c16404b != null) {
            this.uiH = c16404b;
        }
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.m2504i(6096);
        Object onMiscCallBack = this.uiH.onMiscCallBack(str, bundle);
        AppMethodBeat.m2505o(6096);
        return onMiscCallBack;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(6097);
        boolean onTouchEvent = this.uiH.onTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(6097);
        return onTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(6098);
        boolean onInterceptTouchEvent = this.uiH.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(6098);
        return onInterceptTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(6099);
        boolean dispatchTouchEvent = this.uiH.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.m2505o(6099);
        return dispatchTouchEvent;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.m2504i(6100);
        boolean overScrollBy = this.uiH.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        AppMethodBeat.m2505o(6100);
        return overScrollBy;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(6101);
        this.uiH.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.m2505o(6101);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.m2504i(6102);
        this.uiH.onOverScrolled(i, i2, z, z2, view);
        AppMethodBeat.m2505o(6102);
    }

    public void computeScroll(View view) {
        AppMethodBeat.m2504i(6103);
        this.uiH.computeScroll(view);
        AppMethodBeat.m2505o(6103);
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.m2504i(6104);
        boolean onShowLongClickPopupMenu = this.uiH.onShowLongClickPopupMenu();
        AppMethodBeat.m2505o(6104);
        return onShowLongClickPopupMenu;
    }

    public void invalidate() {
        AppMethodBeat.m2504i(6105);
        this.uiH.invalidate();
        AppMethodBeat.m2505o(6105);
    }
}
