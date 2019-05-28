package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    /* renamed from: a */
    private IX5WebHistoryItem f17983a = null;
    /* renamed from: b */
    private android.webkit.WebHistoryItem f17984b = null;

    private WebHistoryItem() {
    }

    /* renamed from: a */
    static WebHistoryItem m88577a(android.webkit.WebHistoryItem webHistoryItem) {
        AppMethodBeat.m2504i(64694);
        if (webHistoryItem == null) {
            AppMethodBeat.m2505o(64694);
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.f17984b = webHistoryItem;
        AppMethodBeat.m2505o(64694);
        return webHistoryItem2;
    }

    /* renamed from: a */
    static WebHistoryItem m88578a(IX5WebHistoryItem iX5WebHistoryItem) {
        AppMethodBeat.m2504i(64693);
        if (iX5WebHistoryItem == null) {
            AppMethodBeat.m2505o(64693);
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f17983a = iX5WebHistoryItem;
        AppMethodBeat.m2505o(64693);
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        AppMethodBeat.m2504i(64698);
        Bitmap favicon;
        if (this.f17983a != null) {
            favicon = this.f17983a.getFavicon();
            AppMethodBeat.m2505o(64698);
            return favicon;
        }
        favicon = this.f17984b.getFavicon();
        AppMethodBeat.m2505o(64698);
        return favicon;
    }

    public String getOriginalUrl() {
        AppMethodBeat.m2504i(64696);
        String originalUrl;
        if (this.f17983a != null) {
            originalUrl = this.f17983a.getOriginalUrl();
            AppMethodBeat.m2505o(64696);
            return originalUrl;
        }
        originalUrl = this.f17984b.getOriginalUrl();
        AppMethodBeat.m2505o(64696);
        return originalUrl;
    }

    public String getTitle() {
        AppMethodBeat.m2504i(64697);
        String title;
        if (this.f17983a != null) {
            title = this.f17983a.getTitle();
            AppMethodBeat.m2505o(64697);
            return title;
        }
        title = this.f17984b.getTitle();
        AppMethodBeat.m2505o(64697);
        return title;
    }

    public String getUrl() {
        AppMethodBeat.m2504i(64695);
        String url;
        if (this.f17983a != null) {
            url = this.f17983a.getUrl();
            AppMethodBeat.m2505o(64695);
            return url;
        }
        url = this.f17984b.getUrl();
        AppMethodBeat.m2505o(64695);
        return url;
    }
}
