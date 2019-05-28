package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    /* renamed from: a */
    private IX5WebBackForwardList f17981a = null;
    /* renamed from: b */
    private android.webkit.WebBackForwardList f17982b = null;

    /* renamed from: a */
    static WebBackForwardList m88575a(android.webkit.WebBackForwardList webBackForwardList) {
        AppMethodBeat.m2504i(64684);
        if (webBackForwardList == null) {
            AppMethodBeat.m2505o(64684);
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.f17982b = webBackForwardList;
        AppMethodBeat.m2505o(64684);
        return webBackForwardList2;
    }

    /* renamed from: a */
    static WebBackForwardList m88576a(IX5WebBackForwardList iX5WebBackForwardList) {
        AppMethodBeat.m2504i(64683);
        if (iX5WebBackForwardList == null) {
            AppMethodBeat.m2505o(64683);
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f17981a = iX5WebBackForwardList;
        AppMethodBeat.m2505o(64683);
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        AppMethodBeat.m2504i(64686);
        int currentIndex;
        if (this.f17981a != null) {
            currentIndex = this.f17981a.getCurrentIndex();
            AppMethodBeat.m2505o(64686);
            return currentIndex;
        }
        currentIndex = this.f17982b.getCurrentIndex();
        AppMethodBeat.m2505o(64686);
        return currentIndex;
    }

    public WebHistoryItem getCurrentItem() {
        AppMethodBeat.m2504i(64685);
        WebHistoryItem a;
        if (this.f17981a != null) {
            a = WebHistoryItem.m88578a(this.f17981a.getCurrentItem());
            AppMethodBeat.m2505o(64685);
            return a;
        }
        a = WebHistoryItem.m88577a(this.f17982b.getCurrentItem());
        AppMethodBeat.m2505o(64685);
        return a;
    }

    public WebHistoryItem getItemAtIndex(int i) {
        AppMethodBeat.m2504i(64687);
        WebHistoryItem a;
        if (this.f17981a != null) {
            a = WebHistoryItem.m88578a(this.f17981a.getItemAtIndex(i));
            AppMethodBeat.m2505o(64687);
            return a;
        }
        a = WebHistoryItem.m88577a(this.f17982b.getItemAtIndex(i));
        AppMethodBeat.m2505o(64687);
        return a;
    }

    public int getSize() {
        AppMethodBeat.m2504i(64688);
        int size;
        if (this.f17981a != null) {
            size = this.f17981a.getSize();
            AppMethodBeat.m2505o(64688);
            return size;
        }
        size = this.f17982b.getSize();
        AppMethodBeat.m2505o(64688);
        return size;
    }
}
