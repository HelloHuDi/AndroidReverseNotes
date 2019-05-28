package com.tencent.smtt.export.external.extension.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import com.tencent.smtt.export.external.interfaces.IX5ScrollListener;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardListClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.ImageInfo;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IX5WebViewExtension {
    public static final int HANDLEVIEW_ALIGNMENT_CENTER = 1;
    public static final int HANDLEVIEW_ALIGNMENT_RIGHT = 2;
    public static final int HANDLEVIEW_POSITION_CENTER = 1;
    public static final int HANDLEVIEW_POSITION_RIGHT = 2;
    public static final int HANLDEVIEW_ALIGNMENT_LEFT = 0;
    public static final int HANLDEVIEW_POSITION_LEFT = 0;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int RENDER_MODE_DEFAULT = 0;
    public static final int RENDER_MODE_SMOOTHNESS_AGGRESSIVE = 2;
    public static final int RENDER_MODE_SMOOTHNESS_NORMAL = 1;

    void active();

    void cancelLongPress();

    boolean capturePageToFile(Config config, String str, boolean z, int i, int i2);

    void clearServiceWorkerCache();

    void clearTextEntry();

    void clearTextFieldLongPressStatus();

    void copyText();

    void cutText(CharSequence charSequence);

    void deactive();

    void doFingerSearchIfNeed();

    void doTranslateAction(int i);

    void documentAsText(Message message);

    void documentDumpRenderTree(Message message);

    boolean drawPreReadBaseLayer(Canvas canvas, boolean z);

    void dumpDisplayTree();

    void dumpViewportForLayoutTest(Message message);

    void enterSelectionMode(boolean z);

    void exitPluginFullScreen();

    void focusAndPopupIM(String str);

    void forceSyncOffsetToCore();

    ArrayList<ImageInfo> getAllImageInfo();

    Bitmap getBitmapByIndex(int i);

    int getCurrentHistoryItemIndex();

    String getDocumentOuterHTML();

    boolean getDrawWithBuffer();

    String getFocusCandidateText();

    IX5WebHistoryItem getHistoryItem(int i);

    int getQQBrowserVersion();

    int getScrollX();

    int getScrollY();

    Bundle getSdkQBStatisticsInfo();

    String getSelectionText();

    IX5WebSettingsExtension getSettingsExtension();

    int getSharedVideoTime();

    Point getSinglePressPoint();

    int getSniffVideoID();

    String getSniffVideoRefer();

    boolean getSolarMode();

    int getTitleHeight();

    IX5WebChromeClient getWebChromeClient();

    IX5WebChromeClientExtension getWebChromeClientExtension();

    int getWebTextScrollDis();

    IX5WebViewClient getWebViewClient();

    IX5WebViewClientExtension getWebViewClientExtension();

    boolean inFullScreenMode();

    boolean inputNodeIsPasswordType();

    boolean inputNodeIsPhoneType();

    void invalidateContent();

    Object invokeMiscMethod(String str, Bundle bundle);

    boolean isActive();

    boolean isEditingMode();

    boolean isEnableSetFont();

    boolean isHorizontalScrollBarEnabled();

    boolean isMobileSite();

    boolean isPluginFullScreen();

    boolean isPreReadCanGoForward();

    boolean isSelectionMode();

    boolean isVerticalScrollBarEnabled();

    void leaveSelectionMode();

    void loadDataWithBaseURLWithHeaders(String str, String str2, String str3, String str4, String str5, Map<String, String> map);

    void loaddataWithHeaders(String str, String str2, String str3, Map<String, String> map);

    boolean needSniff();

    void onAppExit();

    void onFingerSearchResult(String str, int i, int i2);

    void onPageTransFormationSettingChanged(boolean z);

    void onPauseActiveDomObject();

    void onPauseNativeVideo();

    void onResumeActiveDomObject();

    void pasteText(CharSequence charSequence);

    void pauseAudio();

    void playAudio();

    void preConnectQProxy();

    void preLoad(String str, int i, int i2, Map<String, String> map);

    void pruneMemoryCache();

    void registerServiceWorkerBackground(String str, String str2);

    void registerServiceWorkerOffline(String str, List<String> list, boolean z);

    void reloadCustomMetaData();

    void removeHistoryItem(int i);

    void replaceAllInputText(String str);

    void replyListBox(int i);

    void replyMultiListBox(int i, boolean[] zArr);

    boolean requestFocusForInputNode(int i);

    void retrieveFingerSearchContext(int i);

    void savePageToDisk(String str, Message message);

    void savePageToDisk(String str, boolean z, int i, ValueCallback<String> valueCallback);

    void scrollBy(int i, int i2);

    void scrollTo(int i, int i2);

    int seletionStatus();

    void sendNeverRememberMsg(String str, String str2, String str3, Message message);

    void sendRememberMsg(String str, String str2, String str3, Message message);

    void sendRememberMsg(String str, String str2, String str3, String str4, String str5);

    void sendResumeMsg(String str, String str2, String str3, Message message);

    void setAudioAutoPlayNotify(boolean z);

    void setBackFromSystem();

    void setDisableDrawingWhileLosingFocus(boolean z);

    void setDrawWithBuffer(boolean z);

    void setEmbTitleView(View view, LayoutParams layoutParams);

    void setForceEnableZoom(boolean z);

    void setHandleViewBitmap(Bitmap bitmap, Bitmap bitmap2, int i, int i2);

    void setHandleViewLineColor(int i, int i2);

    void setHandleViewLineIsShowing(boolean z, int i);

    void setHandleViewSelectionColor(int i, int i2);

    void setHorizontalScrollBarDrawable(Drawable drawable);

    void setHorizontalScrollBarEnabled(boolean z);

    void setHorizontalTrackDrawable(Drawable drawable);

    void setIsForVideoSniff(boolean z);

    void setLongPressTextExtensionMenu(int i);

    void setOrientation(int i);

    void setOverScrollParams(int i, int i2, int i3, int i4, int i5, int i6, Drawable drawable, Drawable drawable2, Drawable drawable3);

    void setRenderMode(int i);

    void setScreenState(int i);

    void setScrollBarDefaultDelayBeforeFade(int i);

    void setScrollBarFadeDuration(int i);

    void setScrollBarFadingEnabled(boolean z);

    void setScrollBarSize(int i);

    void setScrollListener(IX5ScrollListener iX5ScrollListener);

    void setSelectListener(ISelectionInterface iSelectionInterface);

    void setSharedVideoTime(int i);

    void setSniffVideoInfo(String str, int i, String str2, String str3);

    void setTextFieldInLongPressStatus(boolean z);

    void setVerticalScrollBarDrawable(Drawable drawable);

    void setVerticalScrollBarEnabled(boolean z);

    void setVerticalTrackDrawable(Drawable drawable);

    void setWebBackForwardListClient(IX5WebBackForwardListClient iX5WebBackForwardListClient);

    void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension);

    void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension);

    boolean shouldFitScreenLayout();

    void showImage(int i, int i2);

    Drawable snapshot(int i, boolean z);

    void snapshotVisible(Bitmap bitmap, boolean z, boolean z2, boolean z3, boolean z4, float f, float f2, Runnable runnable);

    void snapshotVisible(Canvas canvas, boolean z, boolean z2, boolean z3, boolean z4);

    void snapshotWholePage(Canvas canvas, boolean z, boolean z2);

    void stopPreLoad(String str);

    void trimMemory(int i);

    void unRegisterServiceWorker(String str, boolean z);

    void updateContext(Context context);

    void updateImageList(int i, int i2, boolean z);

    void updateSelectionPosition();

    void updateServiceWorkerBackground(String str);

    void waitSWInstalled(String str, Message message);

    Drawable wrapDrawableWithNativeBitmap(Drawable drawable, int i, Config config);
}
