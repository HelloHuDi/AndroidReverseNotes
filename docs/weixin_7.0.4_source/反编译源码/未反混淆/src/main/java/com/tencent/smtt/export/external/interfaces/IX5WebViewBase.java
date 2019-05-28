package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Point;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Map;

public interface IX5WebViewBase {
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;

    public static class WebViewTransport {
        private IX5WebViewBase mWebview;

        public synchronized IX5WebViewBase getWebView() {
            return this.mWebview;
        }

        public synchronized void setWebView(IX5WebViewBase iX5WebViewBase) {
            this.mWebview = iX5WebViewBase;
        }
    }

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int BUTTON_TYPE = 10;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private Object mData;
        private String mExtra;
        private boolean mIsFromSinglePress = false;
        private Point mPoint;
        private int mType = 0;

        public class AnchorData {
            public String mAnchorTitle;
            public String mAnchorUrl;
        }

        public class EditableData {
            public String mEditableText;
            public boolean mIsPassword;
        }

        public class ImageData {
            public Bitmap mBmp;
            public int mImgHeight;
            public int mImgWidth;
            public String mPicUrl;
            public long mRawDataSize;

            public Bitmap getBitmap() {
                AppMethodBeat.i(63817);
                Bitmap bitmapData = HitTestResult.this.getBitmapData();
                AppMethodBeat.o(63817);
                return bitmapData;
            }
        }

        public class ImageAnchorData {
            public String mAHref;
            public Bitmap mBmp;
            public String mPicUrl;
            public long mRawDataSize;

            public Bitmap getBitmap() {
                AppMethodBeat.i(63816);
                Bitmap bitmapData = HitTestResult.this.getBitmapData();
                AppMethodBeat.o(63816);
                return bitmapData;
            }
        }

        /* Access modifiers changed, original: protected */
        public Bitmap getBitmapData() {
            return null;
        }

        public Object getData() {
            return this.mData;
        }

        public String getExtra() {
            return this.mExtra;
        }

        public Point getHitTestPoint() {
            AppMethodBeat.i(63818);
            Point point = new Point(this.mPoint);
            AppMethodBeat.o(63818);
            return point;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isFromSinglePress() {
            return this.mIsFromSinglePress;
        }

        public void setData(Object obj) {
            this.mData = obj;
        }

        public void setExtra(String str) {
            this.mExtra = str;
        }

        public void setHitTestPoint(Point point) {
            this.mPoint = point;
        }

        public void setIsFromSinglePress(boolean z) {
            this.mIsFromSinglePress = z;
        }

        public void setType(int i) {
            this.mType = i;
        }
    }

    public static class ImageInfo {
        public boolean mIsGif;
        public String mPicUrl;
        public long mRawDataSize;

        public long getPicSize() {
            return this.mRawDataSize;
        }

        public String getPicUrl() {
            return this.mPicUrl;
        }

        public boolean isGif() {
            return this.mIsGif;
        }
    }

    @Deprecated
    public interface PictureListener {
        @Deprecated
        void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z);

        void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture);
    }

    public interface FindListener {
        void onFindResultReceived(int i, int i2, boolean z);
    }

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    boolean canGoForward();

    @Deprecated
    boolean canZoomIn();

    @Deprecated
    boolean canZoomOut();

    Picture capturePicture();

    void clearCache(boolean z);

    void clearFormData();

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    @Deprecated
    void clearView();

    void computeScroll();

    IX5WebBackForwardList copyBackForwardList();

    Object createPrintDocumentAdapter(String str);

    void destroy();

    void documentHasImages(Message message);

    void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i);

    @Deprecated
    int findAll(String str);

    void findAllAsync(String str);

    View findHierarchyView(String str, int i);

    void findNext(boolean z);

    void flingScroll(int i, int i2);

    void freeMemory();

    SslCertificate getCertificate();

    int getContentHeight();

    int getContentWidth();

    Bitmap getFavicon();

    HitTestResult getHitTestResult();

    String[] getHttpAuthUsernamePassword(String str, String str2);

    String getOriginalUrl();

    int getProgress();

    @Deprecated
    float getScale();

    IX5WebSettings getSettings();

    String getTitle();

    String getUrl();

    View getView();

    int getVisibleTitleHeight();

    IX5WebViewExtension getX5WebViewExtension();

    @Deprecated
    View getZoomControls();

    void goBack();

    void goBackOrForward(int i);

    void goForward();

    void invokeZoomPicker();

    boolean isPrivateBrowsingEnable();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void onPause();

    void onResume();

    boolean overlayHorizontalScrollbar();

    boolean overlayVerticalScrollbar();

    boolean pageDown(boolean z, int i);

    boolean pageUp(boolean z, int i);

    void pauseTimers();

    void postUrl(String str, byte[] bArr);

    void refreshPlugins(boolean z);

    void reload();

    void removeJavascriptInterface(String str);

    void requestFocusNodeHref(Message message);

    void requestImageRef(Message message);

    @Deprecated
    boolean restorePicture(Bundle bundle, File file);

    IX5WebBackForwardList restoreState(Bundle bundle);

    void resumeTimers();

    @Deprecated
    void savePassword(String str, String str2, String str3);

    @Deprecated
    boolean savePicture(Bundle bundle, File file);

    IX5WebBackForwardList saveState(Bundle bundle);

    void saveWebArchive(String str);

    void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback);

    void setBackgroundColor(int i);

    void setCertificate(SslCertificate sslCertificate);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(FindListener findListener);

    void setHorizontalScrollbarOverlay(boolean z);

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setInitialScale(int i);

    @Deprecated
    void setMapTrackballToArrowKeys(boolean z);

    void setNetworkAvailable(boolean z);

    void setPictureListener(PictureListener pictureListener);

    void setVerticalScrollbarOverlay(boolean z);

    void setWebChromeClient(IX5WebChromeClient iX5WebChromeClient);

    void setWebViewClient(IX5WebViewClient iX5WebViewClient);

    @Deprecated
    boolean showFindDialog(String str, boolean z);

    void stopLoading();

    boolean zoomIn();

    boolean zoomOut();
}
