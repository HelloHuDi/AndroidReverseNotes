package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    private IX5WebHistoryItem a = null;
    private android.webkit.WebHistoryItem b = null;

    private WebHistoryItem() {
    }

    static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        AppMethodBeat.i(64694);
        if (webHistoryItem == null) {
            AppMethodBeat.o(64694);
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.b = webHistoryItem;
        AppMethodBeat.o(64694);
        return webHistoryItem2;
    }

    static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        AppMethodBeat.i(64693);
        if (iX5WebHistoryItem == null) {
            AppMethodBeat.o(64693);
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.a = iX5WebHistoryItem;
        AppMethodBeat.o(64693);
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        AppMethodBeat.i(64698);
        Bitmap favicon;
        if (this.a != null) {
            favicon = this.a.getFavicon();
            AppMethodBeat.o(64698);
            return favicon;
        }
        favicon = this.b.getFavicon();
        AppMethodBeat.o(64698);
        return favicon;
    }

    public String getOriginalUrl() {
        AppMethodBeat.i(64696);
        String originalUrl;
        if (this.a != null) {
            originalUrl = this.a.getOriginalUrl();
            AppMethodBeat.o(64696);
            return originalUrl;
        }
        originalUrl = this.b.getOriginalUrl();
        AppMethodBeat.o(64696);
        return originalUrl;
    }

    public String getTitle() {
        AppMethodBeat.i(64697);
        String title;
        if (this.a != null) {
            title = this.a.getTitle();
            AppMethodBeat.o(64697);
            return title;
        }
        title = this.b.getTitle();
        AppMethodBeat.o(64697);
        return title;
    }

    public String getUrl() {
        AppMethodBeat.i(64695);
        String url;
        if (this.a != null) {
            url = this.a.getUrl();
            AppMethodBeat.o(64695);
            return url;
        }
        url = this.b.getUrl();
        AppMethodBeat.o(64695);
        return url;
    }
}
