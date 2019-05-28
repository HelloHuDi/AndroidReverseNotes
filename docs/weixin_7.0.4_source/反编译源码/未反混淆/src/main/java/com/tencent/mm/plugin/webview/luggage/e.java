package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.a.a.a.a.b;

public class e extends b {
    private b uiH = new b();

    public e() {
        AppMethodBeat.i(6095);
        AppMethodBeat.o(6095);
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.uiH = bVar;
        }
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(6096);
        Object onMiscCallBack = this.uiH.onMiscCallBack(str, bundle);
        AppMethodBeat.o(6096);
        return onMiscCallBack;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(6097);
        boolean onTouchEvent = this.uiH.onTouchEvent(motionEvent, view);
        AppMethodBeat.o(6097);
        return onTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(6098);
        boolean onInterceptTouchEvent = this.uiH.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.o(6098);
        return onInterceptTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(6099);
        boolean dispatchTouchEvent = this.uiH.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.o(6099);
        return dispatchTouchEvent;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.i(6100);
        boolean overScrollBy = this.uiH.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        AppMethodBeat.o(6100);
        return overScrollBy;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(6101);
        this.uiH.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.o(6101);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.i(6102);
        this.uiH.onOverScrolled(i, i2, z, z2, view);
        AppMethodBeat.o(6102);
    }

    public void computeScroll(View view) {
        AppMethodBeat.i(6103);
        this.uiH.computeScroll(view);
        AppMethodBeat.o(6103);
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(6104);
        boolean onShowLongClickPopupMenu = this.uiH.onShowLongClickPopupMenu();
        AppMethodBeat.o(6104);
        return onShowLongClickPopupMenu;
    }

    public void invalidate() {
        AppMethodBeat.i(6105);
        this.uiH.invalidate();
        AppMethodBeat.o(6105);
    }
}
