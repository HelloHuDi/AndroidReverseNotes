package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    private IX5WebBackForwardList a = null;
    private android.webkit.WebBackForwardList b = null;

    static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        AppMethodBeat.i(64684);
        if (webBackForwardList == null) {
            AppMethodBeat.o(64684);
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.b = webBackForwardList;
        AppMethodBeat.o(64684);
        return webBackForwardList2;
    }

    static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        AppMethodBeat.i(64683);
        if (iX5WebBackForwardList == null) {
            AppMethodBeat.o(64683);
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.a = iX5WebBackForwardList;
        AppMethodBeat.o(64683);
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        AppMethodBeat.i(64686);
        int currentIndex;
        if (this.a != null) {
            currentIndex = this.a.getCurrentIndex();
            AppMethodBeat.o(64686);
            return currentIndex;
        }
        currentIndex = this.b.getCurrentIndex();
        AppMethodBeat.o(64686);
        return currentIndex;
    }

    public WebHistoryItem getCurrentItem() {
        AppMethodBeat.i(64685);
        WebHistoryItem a;
        if (this.a != null) {
            a = WebHistoryItem.a(this.a.getCurrentItem());
            AppMethodBeat.o(64685);
            return a;
        }
        a = WebHistoryItem.a(this.b.getCurrentItem());
        AppMethodBeat.o(64685);
        return a;
    }

    public WebHistoryItem getItemAtIndex(int i) {
        AppMethodBeat.i(64687);
        WebHistoryItem a;
        if (this.a != null) {
            a = WebHistoryItem.a(this.a.getItemAtIndex(i));
            AppMethodBeat.o(64687);
            return a;
        }
        a = WebHistoryItem.a(this.b.getItemAtIndex(i));
        AppMethodBeat.o(64687);
        return a;
    }

    public int getSize() {
        AppMethodBeat.i(64688);
        int size;
        if (this.a != null) {
            size = this.a.getSize();
            AppMethodBeat.o(64688);
            return size;
        }
        size = this.b.getSize();
        AppMethodBeat.o(64688);
        return size;
    }
}
